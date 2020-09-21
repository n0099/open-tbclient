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
    private static int jYY;
    private static CallStateReceiver jYZ;
    private String alA;
    private TbImageView alq;
    private Animation bDE;
    private View bsO;
    private String eYo;
    private TbPageContext<?> ehG;
    protected TbCyberVideoView fHb;
    private com.baidu.tieba.play.m feY;
    protected View hts;
    private Animation ihp;
    private View jYA;
    private View jYC;
    private CyberPlayerManager.OnPreparedListener jYE;
    private ImageView jYG;
    private TextView jYH;
    private View jYL;
    private View jYM;
    private TextView jYN;
    private SeekBar jYO;
    private ImageView jYP;
    private ImageView jYQ;
    private int jYR;
    private com.baidu.tieba.play.j jYV;
    private int jYX;
    public View jYr;
    private VideoListMediaControllerView jYt;
    private View jYu;
    private FrameLayout jYv;
    protected FrameLayout.LayoutParams jYw;
    private ImageView jYz;
    protected InterfaceC0779c lAA;
    private d lAB;
    private o lAD;
    private h lAE;
    private j lAF;
    private k lAG;
    private m lAH;
    private a lAI;
    private n lAJ;
    private l lAK;
    private f lAL;
    private g lAM;
    private TextView lAR;
    private boolean lAT;
    private boolean lAU;
    private boolean lAV;
    private int lAW;
    private boolean lAX;
    private boolean lAY;
    private ProgressBar lAo;
    private View lAp;
    private SwitchImageView lAq;
    private TextView lAr;
    private TextView lAs;
    private TextView lAt;
    private int lAu;
    private CyberPlayerManager.OnCompletionListener lAv;
    private CyberPlayerManager.OnErrorListener lAw;
    private View.OnClickListener lAz;
    private p ldE;
    private i ldQ;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int ZN = 100;
    private boolean lAn = false;
    protected boolean ZX = false;
    private boolean ZM = false;
    private boolean lAx = false;
    private boolean lAy = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int jYS = 0;
    private int jYT = 0;
    private long lAC = 60000;
    private int jYW = 0;
    private boolean jZa = false;
    private boolean lAN = true;
    private boolean lAO = true;
    private boolean lAP = false;
    private boolean lAQ = false;
    private String ldq = null;
    private int currentState = -1;
    private boolean lAS = false;
    private boolean lAZ = false;
    private boolean lBa = false;
    private CyberPlayerManager.OnPreparedListener dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.jYt != null && c.this.fHb != null && c.this.fHb.getDuration() > 0) {
                c.this.jYt.bz(0, c.this.fHb.getDuration());
            }
            c.this.ceU();
            if (c.this.lAD != null) {
                c.this.lAD.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rZ();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hqE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.ceU();
        }
    };
    private Runnable ZS = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(c.this.ZS);
            if (c.this.alq.getVisibility() != 8) {
                if (c.this.fHb.getCurrentPosition() > c.this.ZN) {
                    c.this.rZ();
                } else {
                    com.baidu.adp.lib.f.e.mX().postDelayed(c.this.ZS, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.fHb != null) {
                int duration = c.this.fHb.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.ZM = false;
                    c.this.lAV = false;
                    c.this.mStartPosition = 0;
                    c.this.cQo();
                    c.this.jYu.setVisibility(0);
                    c.this.lAo.setProgress(c.this.lAo.getMax());
                    c.this.ZN = 100;
                    if (c.this.lAv != null) {
                        c.this.lAv.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.vg(false);
                        c.this.vh(true);
                    } else {
                        c.this.dnr();
                        c.this.lAr.setVisibility(0);
                    }
                    if (!c.this.ZX && duration <= 150000) {
                        if (!c.this.lAS) {
                            if (c.this.lAF != null) {
                                c.this.lAF.uk(true);
                            }
                            c.this.A(c.this.mVideoUrl, c.this.alA, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.fHb.pause();
                            c.this.fHb.seekTo(0);
                        }
                    }
                    if (c.this.lAD != null) {
                        c.this.lAD.Gg(c.this.lAo.getMax());
                        c.this.lAD.GP();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.hts.setVisibility(0);
            c.this.feY.dnJ();
            c.this.currentState = 4;
            if (c.this.lAw != null) {
                c.this.lAw.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.lAT = true;
            }
            if (c.this.lAD != null) {
                c.this.lAD.dnx();
            }
            c.this.lAV = false;
            return true;
        }
    };
    protected Runnable jZd = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fHb == null || !c.this.fHb.isPlaying()) {
                c.this.hts.setVisibility(0);
                c.this.feY.dnJ();
                if (c.this.lAD != null) {
                    c.this.lAD.dnx();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener dNT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.lAP) {
                com.baidu.adp.lib.f.e.mX().postDelayed(c.this.lBb, 200L);
            }
        }
    };
    private Runnable lBb = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fHb == null || !c.this.lAP) {
                com.baidu.adp.lib.f.e.mX().postDelayed(c.this.ZS, 200L);
                c.this.lAP = false;
            } else if (c.this.mStartPosition != c.this.fHb.getCurrentPosition()) {
                c.this.lAP = false;
                com.baidu.adp.lib.f.e.mX().postDelayed(c.this.ZS, 20L);
            } else {
                com.baidu.adp.lib.f.e.mX().postDelayed(c.this.lBb, 200L);
            }
        }
    };
    private TbCyberVideoView.a ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.ZM = false;
            if (c.this.lAy) {
                com.baidu.adp.lib.f.e.mX().postDelayed(c.this.lBc, 300L);
            }
            com.baidu.adp.lib.f.e.mX().removeCallbacks(c.this.ZS);
            com.baidu.adp.lib.f.e.mX().removeCallbacks(c.this.jZd);
        }
    };
    private Runnable lBc = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lAV = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ldE != null) {
                c.this.ldE.dhj();
            }
            if (view.getId() != c.this.hts.getId()) {
                if (view.getId() != c.this.lAq.getId()) {
                    if (view.getId() == c.this.lAs.getId()) {
                        if (c.this.lAE != null) {
                            c.this.lAE.dhk();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.lAr.getId()) {
                        if (c.this.lAF != null) {
                            c.this.lAF.uk(false);
                        }
                        c.this.fK(c.this.mVideoUrl, c.this.alA);
                        return;
                    } else if (view.getId() == c.this.jYz.getId()) {
                        int i2 = c.this.lAy ? 1 : 2;
                        if (c.this.ZX) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dF("tid", c.this.alA).dF("fid", c.this.eYo).ai("obj_type", i2).ai("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dF("tid", c.this.alA).dF("fid", c.this.eYo).ai("obj_type", i2).ai("obj_source", 1));
                        }
                        if (c.this.lAK != null) {
                            c.this.lAK.csb();
                        }
                        if (c.this.dnc()) {
                            if (c.this.ZX) {
                                c.this.dnf();
                            } else {
                                c.this.dne();
                            }
                            c.this.vd(c.this.ZX);
                            return;
                        }
                        c.this.OK();
                        return;
                    } else if (view.getId() != c.this.jYG.getId()) {
                        if (c.this.lAz != null) {
                            c.this.lAz.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.lAK != null) {
                            c.this.lAK.csb();
                        }
                        if (c.this.dnc()) {
                            c.this.dnf();
                            c.this.vd(false);
                            return;
                        }
                        c.this.OK();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.dhc();
                c.this.dnu();
                if (c.this.currentState != 1) {
                    c.this.dnp();
                    c.this.dnq();
                } else {
                    c.this.cQE();
                }
                if (c.this.lAI != null) {
                    c.this.lAI.pt(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.fHb.stopPlayback();
            c.this.ZM = false;
            c.this.dnk();
        }
    };
    private Animation.AnimationListener jZf = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener jZg = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable jZh = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cQB();
        }
    };
    private CustomMessageListener jZi = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aII();
            }
        }
    };
    private VideoControllerView.b kbc = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void sw(int i2) {
            int duration;
            if (c.this.fHb != null && (duration = c.this.fHb.getDuration()) > 0 && c.this.lAo != null) {
                c.this.lAo.setProgress((int) ((i2 * c.this.jYr.getWidth()) / duration));
                if (c.this.lAD != null) {
                    c.this.lAD.Gg((c.this.fHb.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fsv = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.dnp();
            c.this.vh(false);
            if (c.this.lAI != null) {
                c.this.lAI.pt(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cQs() != null) {
                c.this.CX(c.this.cQs().getSeekPosition());
                if (!c.this.cQA()) {
                    c.this.dnk();
                } else {
                    c.this.aIJ();
                    if (c.this.ldQ != null) {
                        c.this.ldQ.csd();
                    }
                }
            }
            c.this.vh(true);
            c.this.dno();
            if (c.this.lAI != null) {
                c.this.lAI.pt(true);
            }
            if (c.this.lAJ != null) {
                c.this.lAJ.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pt(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0779c {
        void rI();

        void rJ();
    }

    /* loaded from: classes.dex */
    public interface d {
        void csc();

        void oO(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void vl(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void oN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dhk();
    }

    /* loaded from: classes.dex */
    public interface i {
        void csd();
    }

    /* loaded from: classes.dex */
    public interface j {
        void uk(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void csa();

        void csb();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dhl();

        boolean dhm();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void GP();

        void Gg(int i);

        void dnx();

        void dny();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dhj();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.lAX = true;
        if (tbPageContext != null) {
            this.ehG = tbPageContext;
            this.mRootView = view;
            this.lAX = z;
            this.jYC = view;
            this.mActivity = this.ehG.getPageActivity();
            init();
        }
    }

    public void init() {
        this.jYr = av(this.mActivity);
        this.jYr.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.jYr);
        }
        this.fHb = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.jYr).addView(this.fHb.getView(), 0);
        this.fHb.getView().setLayoutParams(layoutParams);
        this.feY = new com.baidu.tieba.play.m((ViewGroup) this.jYr.findViewById(R.id.auto_video_loading_container));
        this.feY.setLoadingAnimationListener(this.hqE);
        this.jYt = (VideoListMediaControllerView) this.jYr.findViewById(R.id.media_controller);
        this.jYt.setPlayer(this.fHb);
        this.lAo = (ProgressBar) this.jYr.findViewById(R.id.pgrBottomProgress);
        this.lAo.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.lAo.setProgress(0);
        this.jYt.setOnSeekBarChangeListener(this.fsv);
        this.jYt.setOnProgressUpdatedListener(this.kbc);
        this.jYu = this.jYr.findViewById(R.id.black_mask);
        this.hts = this.jYr.findViewById(R.id.layout_error);
        this.hts.setOnClickListener(this.mOnClickListener);
        this.lAR = (TextView) this.jYr.findViewById(R.id.auto_video_error_tips);
        this.jYv = (FrameLayout) this.jYr.findViewById(R.id.danmu_container);
        this.jYz = (ImageView) this.jYr.findViewById(R.id.img_full_screen);
        this.jYz.setOnClickListener(this.mOnClickListener);
        this.jYA = this.jYr.findViewById(R.id.layout_media_controller);
        this.lAp = this.jYr.findViewById(R.id.time_show_controller);
        this.fHb.setContinuePlayEnable(true);
        this.fHb.setOnPreparedListener(this.dNO);
        this.fHb.setOnCompletionListener(this.dNQ);
        this.fHb.setOnErrorListener(this.jZc);
        this.fHb.setOnSeekCompleteListener(this.dNT);
        this.fHb.setOnInfoListener(this.dNR);
        this.fHb.setOnSurfaceDestroyedListener(this.ffg);
        this.lAq = (SwitchImageView) this.jYr.findViewById(R.id.img_play_controller);
        this.lAq.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.lAq.setState(0);
        this.lAq.setOnClickListener(this.mOnClickListener);
        this.lAr = (TextView) this.jYr.findViewById(R.id.txt_replay);
        this.lAr.setOnClickListener(this.mOnClickListener);
        this.lAs = (TextView) this.jYr.findViewById(R.id.txt_playnext);
        this.lAs.setOnClickListener(this.mOnClickListener);
        this.lAt = (TextView) this.jYr.findViewById(R.id.txt_next_video_title);
        this.alq = (TbImageView) this.jYr.findViewById(R.id.video_thumbnail);
        this.alq.setDefaultErrorResource(0);
        this.alq.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.jYG = (ImageView) this.jYr.findViewById(R.id.img_exit);
        this.jYG.setOnClickListener(this.mOnClickListener);
        this.jYH = (TextView) this.jYr.findViewById(R.id.video_title);
        this.bsO = this.jYr.findViewById(R.id.layout_title);
        this.bsO.setVisibility(8);
        this.ihp = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bDE = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.jYR = this.mAudioManager.getStreamMaxVolume(3);
        this.jYX = this.mAudioManager.getStreamVolume(3);
        jYY = 100 / this.jYR;
        this.jYr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.lAG != null) {
                    c.this.lAG.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.ZM) {
                        if (c.this.mStatus == 1 && c.this.jYT != 0) {
                            c.this.b(c.this.jYT == 1 ? 1000.0f : -1000.0f, false);
                            c.this.jYT = 0;
                            c.this.jYS = 0;
                        }
                        if (!c.this.fHb.isPlaying()) {
                            c.this.lAs.setVisibility(8);
                            c.this.lAr.setVisibility(8);
                            c.this.lAt.setVisibility(8);
                        }
                    }
                    c.this.cQo();
                    if (c.this.lAG != null) {
                        c.this.lAG.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.jYV = new com.baidu.tieba.play.j(this.mActivity);
        if (this.lAX) {
            this.jYV.start();
        }
        this.jYW = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (jYZ == null) {
            jYZ = new CallStateReceiver();
        }
        jYZ.register(this.mActivity);
        dnb();
        MessageManager.getInstance().registerListener(this.jZi);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.jZi);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Gc(int i2) {
        if (this.alq != null) {
            this.alq.setDefaultBgResource(i2);
        }
    }

    public void dnb() {
        if (this.lAN) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.jYr.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.jYr.setSystemUiVisibility(0);
    }

    public void vb(boolean z) {
        this.lAN = z;
        dnb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQo() {
        this.mStatus = 0;
        if (this.jYL != null && this.jYL.getParent() != null && (this.jYL.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jYL.getParent()).removeView(this.jYL);
                this.jYL = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.jYM != null && this.jYM.getParent() != null && (this.jYM.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.jYM.getParent()).removeView(this.jYM);
                this.jYM = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cQp() {
        if (this.mStatus == 1) {
            if (this.jYL == null && this.jYr != null && (this.jYr instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.jYr, true);
                this.jYL = this.jYr.findViewById(R.id.lay_jindu);
                this.jYN = (TextView) this.jYL.findViewById(R.id.show_time);
                this.jYQ = (ImageView) this.jYL.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.jYM == null && this.jYr != null && (this.jYr instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.jYr, true);
            this.jYM = this.jYr.findViewById(R.id.lay_voice);
            this.jYP = (ImageView) this.jYM.findViewById(R.id.arrow_voice_icon);
            this.jYO = (SeekBar) this.jYM.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.lAz = onClickListener;
    }

    public void vc(boolean z) {
        this.lAy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.lAG != null) {
                c.this.lAG.onStart();
            }
            if (c.this.ZX && c.this.ZM) {
                if (c.this.mStatus == 1) {
                    c.this.dnr();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.ZX) {
                        c.this.cQr();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.jYS = c.this.fHb.getCurrentPosition();
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
            if (!c.this.lAY) {
                if (c.this.lAH != null && c.this.lAH.dhl()) {
                    return true;
                }
                c.this.dhc();
                c.this.dnu();
                if (c.this.fHb.isPlaying()) {
                    c.this.dno();
                } else {
                    c.this.dnp();
                }
                if (c.this.lAI != null) {
                    c.this.lAI.pt(c.this.fHb.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.lAY) {
                if (c.this.ZM) {
                    if (c.this.lAH != null && c.this.lAH.dhm()) {
                        return true;
                    }
                    c.this.dnn();
                    if (c.this.fHb.isPlaying()) {
                        c.this.dno();
                    } else {
                        c.this.dnp();
                    }
                    if (c.this.lAI != null) {
                        c.this.lAI.pt(c.this.fHb.isPlaying());
                    }
                } else {
                    c.this.dhc();
                    c.this.dnu();
                    if (c.this.currentState != 1) {
                        c.this.dnp();
                        c.this.dnq();
                    } else {
                        c.this.cQE();
                    }
                    if (c.this.lAI != null) {
                        c.this.lAI.pt(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQr() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jYr.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jYr.setSystemUiVisibility(4);
        } else {
            this.jYr.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.ZM) {
            this.mStatus = 0;
            return;
        }
        if (jYY == 0) {
            this.jYR = this.mAudioManager.getStreamMaxVolume(3);
            jYY = 100 / this.jYR;
            if (jYY == 0) {
                jYY = 1;
            }
        }
        cQp();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % jYY == 0) {
            if (f2 > 0.0f && this.jYX < this.jYR) {
                this.jYX++;
            }
            if (f2 < 0.0f && this.jYX > 0) {
                this.jYX--;
            }
        }
        if (this.mProgress > 0) {
            this.jYP.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.jYP.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.jYX, 0);
        this.jYO.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.jYS -= 1000;
                this.jYT = 1;
            } else {
                this.jYS += 1000;
                this.jYT = 2;
            }
            if (this.jYS < 0) {
                this.jYS = 0;
            } else if (this.jYS > this.fHb.getDuration()) {
                this.jYS = this.fHb.getDuration();
            }
        }
        cQp();
        String Gk = this.jYt.Gk(this.jYS);
        if (f2 > 0.0f) {
            this.jYQ.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.jYQ.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Gk)) {
            this.jYN.setText(new StringBuilder().append(Gk).append("/").append(this.jYt.Gk(this.fHb.getDuration())));
        }
        this.jYt.setCurrentDuration(this.jYS, z ? false : true);
        dnr();
        dng();
    }

    protected View av(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Gd(int i2) {
        this.lAu = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alA = str2;
    }

    public void setFid(String str) {
        this.eYo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        int i2 = 100;
        if (this.fHb != null && this.jYt != null) {
            this.jYt.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dnN().Pg(this.mVideoUrl);
            if (this.lAV) {
                this.fHb.setVolume(1.0f, 1.0f);
                this.fHb.start();
                this.lAV = false;
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ZS);
                com.baidu.adp.lib.f.e.mX().postDelayed(this.ZS, 20L);
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZd);
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBc);
                if (this.fHb.dnU()) {
                    this.currentState = 1;
                    dnr();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dnN().Pg(this.mVideoUrl);
                this.jYt.setPlayer(this.fHb);
                if (this.mStartPosition != 0) {
                    this.lAP = true;
                }
                if (!this.lAU) {
                    this.jYt.showProgress();
                }
                if (!this.lAy && this.fHb.getDuration() <= 0) {
                    cQs().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.fHb.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.ZN = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.alq.getVisibility() != 8 || !this.ZM) {
            this.ZM = true;
            this.jYu.setVisibility(8);
            this.hts.setVisibility(8);
            this.feY.dnI();
            this.alq.setVisibility(8);
            dnt();
            this.jYt.showProgress();
            this.lAo.setVisibility(0);
            if (this.jYE != null) {
                this.jYE.onPrepared();
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

    protected void vd(boolean z) {
        if (hasNavBar(this.mActivity) && (this.lAp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lAp.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.lAp.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.lAp.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.lAp.setLayoutParams(layoutParams);
        }
    }

    public void dhc() {
        if (this.fHb.isPlaying()) {
            aII();
            if (this.lAM != null) {
                this.lAM.onPause();
            }
            if (this.lAD != null) {
                this.lAD.onPaused();
            }
        } else if (this.ZM) {
            aIJ();
            if (this.ldQ != null) {
                this.ldQ.csd();
            }
            if (this.lAD != null) {
                this.lAD.dny();
            }
        } else {
            dnk();
        }
    }

    public void OK() {
        this.jZa = true;
        if (this.jYV != null) {
            this.jYV.OK();
        }
    }

    public boolean dnc() {
        return this.fHb != null && this.fHb.getView().getHeight() > this.fHb.getView().getWidth();
    }

    public void dnd() {
        vd(false);
        dnf();
    }

    public boolean Ge(int i2) {
        switch (i2) {
            case 4:
                if (this.ZX) {
                    if (dnc()) {
                        vd(false);
                        dnf();
                    } else {
                        OK();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.jYR <= 0 || this.jYO == null) {
                    return false;
                }
                this.jYX = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.jYX * 100.0d) / this.jYR);
                this.jYO.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.fHb;
    }

    public VideoListMediaControllerView cQs() {
        return this.jYt;
    }

    public void show() {
        this.jYr.setVisibility(0);
    }

    public void cQw() {
        if (this.jYC != null) {
            ViewGroup.LayoutParams layoutParams = this.jYC.getLayoutParams();
            this.jYw = (FrameLayout.LayoutParams) this.jYr.getLayoutParams();
            this.jYw.width = layoutParams.width;
            this.jYw.height = layoutParams.height;
            this.jYw.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.jYr.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.jYr.setLayoutParams(this.jYw);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.jZa) {
            if (this.ZX) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.jZa = false;
        }
        if (configuration.orientation == 2) {
            dne();
        } else {
            dnf();
        }
        dng();
        if (this.mActivity == com.baidu.adp.base.a.lf().currentActivity()) {
            aIJ();
        }
        dnu();
        cQE();
        if (this.lAI != null) {
            this.lAI.pt(true);
        }
    }

    protected void dne() {
        this.ZX = true;
        if (dnc()) {
            this.jYr.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.jYr.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        j(this.mActivity, true);
        this.bsO.setVisibility(0);
        this.jYG.setVisibility(0);
        this.jYH.setVisibility(0);
        this.jYv.setVisibility(8);
        this.feY.dnJ();
        this.alq.setVisibility(8);
        this.jYz.setImageResource(R.drawable.icon_video_narrow_white);
        CU(this.jYW);
        cQr();
        if (this.lAA != null) {
            this.lAA.rI();
        }
    }

    protected void dnf() {
        this.ZX = false;
        if (this.jYw != null) {
            this.jYr.setLayoutParams(this.jYw);
        }
        j(this.mActivity, false);
        this.bsO.setVisibility(8);
        this.jYv.setVisibility(0);
        this.feY.dnJ();
        this.alq.setVisibility(8);
        this.jYz.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.jYt != null && (this.jYt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jYt.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.jYt.setLayoutParams(layoutParams);
        }
        this.jYr.setSystemUiVisibility(0);
        dnb();
        if (this.lAA != null) {
            this.lAA.rJ();
        }
    }

    public void dng() {
        if (this.fHb != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.ZX) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.lAo.setMax(equipmentWidth);
            int duration = this.fHb.getDuration();
            if (duration > 0) {
                if (this.lAr.getVisibility() == 0) {
                    this.lAo.setProgress(this.lAo.getMax());
                } else {
                    this.lAo.setProgress((int) ((this.fHb.getCurrentPositionSync() * this.lAo.getMax()) / duration));
                }
            }
        }
    }

    private void CU(int i2) {
        if (this.jYt != null && (this.jYt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jYt.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.jYt.setLayoutParams(layoutParams);
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

    public boolean cQy() {
        return !this.ZX;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.jYE = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lAv = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lAw = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.lAQ) {
            fL(str, str2);
        } else {
            fK(str, str2);
        }
        if (eVar != null) {
            eVar.vl(z);
        }
    }

    public void fJ(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, boolean z) {
        dnl();
        this.lAV = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.fHb.setVideoDuration(this.lAu);
        this.fHb.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZd);
        if (this.lAC > 0) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.jZd, this.lAC);
        }
        if (this.lAD != null) {
            this.lAD.onStarted();
        }
        this.feY.startLoading();
        ve(z);
    }

    public void fK(String str, String str2) {
        A(str, str2, true);
    }

    public void fL(String str, String str2) {
        dnl();
        this.lAV = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZd);
        if (this.lAC > 0) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.jZd, this.lAC);
        }
        if (this.lAD != null) {
            this.lAD.onStarted();
        }
        this.feY.startLoading();
        ve(true);
    }

    public void dnh() {
        aIJ();
        this.lAo.setVisibility(0);
    }

    public void aIJ() {
        int i2 = 100;
        if (this.fHb != null && this.jYt != null) {
            this.ZM = true;
            this.currentState = 1;
            this.fHb.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dnN().Pg(this.mVideoUrl);
            this.lAP = true;
            if (this.mStartPosition > 100 && this.fHb.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.ZN = i2;
            this.feY.dnJ();
            ve(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lAT && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alA)) {
            this.lAT = false;
            this.lAU = true;
            fK(this.mVideoUrl, this.alA);
        }
    }

    private void ve(boolean z) {
        if (z) {
            this.alq.setVisibility(0);
            dnr();
            this.lAo.setProgress(0);
        } else {
            this.alq.setVisibility(8);
            dnr();
        }
        this.jYt.showProgress();
        this.jYu.setVisibility(8);
        this.lAs.setVisibility(8);
        this.lAr.setVisibility(8);
        this.lAt.setVisibility(8);
        this.hts.setVisibility(8);
    }

    private void dni() {
        this.feY.dnJ();
        this.lAs.setVisibility(8);
        this.lAr.setVisibility(8);
        this.lAt.setVisibility(8);
        dnu();
    }

    public void aII() {
        this.fHb.pause();
        this.currentState = 2;
        dni();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ZS);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZd);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBc);
        this.fHb.stopPlayback();
        this.ZM = false;
        this.lAV = false;
        this.mStartPosition = 0;
        cDc();
    }

    public void dnj() {
        if (this.fHb.getDuration() >= this.fHb.getCurrentPosition()) {
            com.baidu.tieba.play.n.dnN().by(this.mVideoUrl, this.fHb.getCurrentPositionSync());
        }
    }

    public void vf(boolean z) {
        this.lAO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg(boolean z) {
        if (this.jYA != null) {
            this.jYu.setVisibility(0);
            this.lAs.setVisibility(8);
            this.lAr.setVisibility(8);
            this.lAt.setVisibility(8);
            this.feY.dnJ();
            dnr();
            this.lAo.setVisibility(8);
            this.hts.setVisibility(8);
            this.jYt.aIX();
            this.alq.setVisibility(z ? 0 : 8);
        }
    }

    public void cDc() {
        vg(true);
    }

    public boolean rK() {
        if (this.fHb == null) {
            return false;
        }
        return this.fHb.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fHb == null) {
            return 0;
        }
        return this.fHb.getCurrentPosition();
    }

    public void a(k kVar) {
        this.lAG = kVar;
    }

    public void a(j jVar) {
        this.lAF = jVar;
    }

    public void a(i iVar) {
        this.ldQ = iVar;
    }

    public void a(g gVar) {
        this.lAM = gVar;
    }

    public void a(h hVar) {
        this.lAE = hVar;
    }

    public void OF(String str) {
        this.ldq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnk() {
        a(this.mVideoUrl, this.alA, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.lAB = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dnl();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dEY().dEZ()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.lAQ = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.lAL != null) {
                    this.lAL.oN(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.zV(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dnm();
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
                aVar.b(this.ehG).bia();
                return;
            } else if (this.lAL != null) {
                this.lAL.oN(true);
                return;
            } else {
                if (!this.lAn) {
                    this.lAn = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.lAK != null) {
            this.lAK.csa();
        }
    }

    private void dnl() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dEY().fO(this.mActivity);
        }
    }

    public void dnm() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.alq.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZh);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ZS);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZd);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBb);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBc);
        this.jYV.stop();
        jYZ.unregister(this.mActivity);
    }

    public void Pf(String str) {
        this.jYH.setText(str);
    }

    public boolean cQA() {
        return this.ZM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnn() {
        if (this.jYA != null) {
            if (this.lAx) {
                dnr();
            } else {
                dnq();
            }
        }
    }

    public void cQE() {
        dnq();
        dno();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dno() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZh);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.jZh, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnp() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZh);
    }

    public void dnq() {
        if (this.jYA != null && !this.lAx && !this.lAZ) {
            vh(true);
            cQD();
            this.jYA.setVisibility(0);
            this.lAp.setVisibility(0);
            this.lAo.setVisibility(8);
            this.lAx = true;
            if (this.lAB != null) {
                this.lAB.oO(false);
            }
        }
    }

    public void cQB() {
        if (this.jYA != null && this.lAx) {
            vh(false);
            cQD();
            this.jYA.setVisibility(8);
            this.lAp.setVisibility(8);
            this.lAo.setVisibility(0);
            this.ihp.setAnimationListener(this.jZf);
            this.jYA.startAnimation(this.ihp);
            this.lAx = false;
            if (this.lAB != null) {
                this.lAB.csc();
            }
        }
    }

    public void dnr() {
        if (this.jYA != null && this.lAx) {
            this.bDE.cancel();
            this.ihp.cancel();
            vh(false);
            cQD();
            this.jYA.setVisibility(8);
            this.lAp.setVisibility(8);
            this.lAo.setVisibility(0);
            this.lAx = false;
            if (this.lAB != null) {
                this.lAB.csc();
            }
        }
    }

    private void cQD() {
        if (this.jYA != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jZh);
            this.bDE.setAnimationListener(null);
            this.ihp.setAnimationListener(null);
            this.jYA.clearAnimation();
        }
    }

    private void dnt() {
        if (this.jYA != null) {
            this.bDE.setAnimationListener(null);
            this.ihp.setAnimationListener(null);
            this.jYA.clearAnimation();
        }
    }

    public void vh(boolean z) {
        dnu();
        if (z) {
            this.lAq.setVisibility(0);
        } else {
            this.lAq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnu() {
        if (this.currentState == 1) {
            this.lAq.setState(1);
        } else {
            this.lAq.setState(0);
        }
    }

    public void a(InterfaceC0779c interfaceC0779c) {
        this.lAA = interfaceC0779c;
    }

    public void CX(int i2) {
        this.mStartPosition = i2;
    }

    public void aw(boolean z, boolean z2) {
        if (this.jYV != null) {
            if (this.jYz != null) {
                this.jYz.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.jYt != null && (this.jYt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jYt.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.jYt.setLayoutParams(layoutParams);
            }
            this.jYV.cu(z);
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

    public void vi(boolean z) {
        this.lAY = z;
    }

    public void a(m mVar) {
        this.lAH = mVar;
    }

    public void a(a aVar) {
        this.lAI = aVar;
    }

    public void a(n nVar) {
        this.lAJ = nVar;
    }

    public void a(l lVar) {
        this.lAK = lVar;
    }

    public void a(f fVar) {
        this.lAL = fVar;
    }

    public void vj(boolean z) {
        this.lAS = z;
    }

    public void vk(boolean z) {
        this.lAy = z;
    }

    public void Gf(int i2) {
        this.lAW = i2;
    }

    public View dnv() {
        return this.jYr;
    }

    public void a(p pVar) {
        this.ldE = pVar;
    }

    public void dnw() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ehG.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.ehG.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.fHb != null) {
            this.fHb.setStageType(str);
        }
    }
}
