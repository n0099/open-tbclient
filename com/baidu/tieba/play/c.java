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
    private static int lfF;
    private static CallStateReceiver lfG;
    private TbImageView anK;
    private String anU;
    private View bNL;
    public View bWp;
    private Animation cjx;
    private TbPageContext<?> eWx;
    private String fOD;
    private com.baidu.tieba.play.m fVA;
    protected TbCyberVideoView gBU;
    private ImageView hjx;
    protected View iBB;
    private Animation jpv;
    private com.baidu.tieba.play.j lfD;
    private VideoListMediaControllerView lfc;
    private View lfd;
    private FrameLayout lfe;
    protected FrameLayout.LayoutParams lff;
    private ImageView lfi;
    private View lfj;
    private View lfl;
    private CyberPlayerManager.OnPreparedListener lfn;
    private TextView lfp;
    private View lft;
    private View lfu;
    private TextView lfv;
    private SeekBar lfw;
    private ImageView lfx;
    private ImageView lfy;
    private int lfz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private ProgressBar mIH;
    private View mII;
    private SwitchImageView mIJ;
    private TextView mIK;
    private TextView mIL;
    private TextView mIM;
    private int mIN;
    private CyberPlayerManager.OnCompletionListener mIO;
    private CyberPlayerManager.OnErrorListener mIQ;
    private View.OnClickListener mIU;
    protected InterfaceC0855c mIV;
    private d mIW;
    private o mIY;
    private h mIZ;
    private j mJa;
    private k mJb;
    private m mJc;
    private a mJd;
    private n mJe;
    private l mJf;
    private f mJg;
    private g mJh;
    private TextView mJm;
    private boolean mJo;
    private boolean mJp;
    private boolean mJq;
    private int mJr;
    private boolean mJs;
    private boolean mJt;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int mVolume;
    private p mlM;
    private i mlY;
    private int adg = 100;
    private boolean mIG = false;
    protected boolean adq = false;
    private boolean adf = false;
    private boolean mIR = false;
    private boolean mIS = false;
    private boolean mIT = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int lfA = 0;
    private int lfB = 0;
    private long mIX = AppStatusRules.DEFAULT_GRANULARITY;
    private int lfE = 0;
    private boolean lfH = false;
    private boolean mJi = true;
    private boolean mJj = true;
    private boolean mJk = false;
    private boolean mJl = false;
    private String mlz = null;
    private int currentState = -1;
    private boolean mJn = false;
    private boolean mJu = false;
    private boolean mJv = false;
    private CyberPlayerManager.OnPreparedListener eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.lfc != null && c.this.gBU != null && c.this.gBU.getDuration() > 0) {
                c.this.lfc.bx(0, c.this.gBU.getDuration());
            }
            c.this.csn();
            if (c.this.mIY != null) {
                c.this.mIY.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rA();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a iyG = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.csn();
        }
    };
    private Runnable adl = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.adl);
            if (c.this.anK.getVisibility() != 8) {
                if (c.this.gBU.getCurrentPosition() > c.this.adg) {
                    c.this.rA();
                } else {
                    com.baidu.adp.lib.f.e.mA().postDelayed(c.this.adl, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gBU != null) {
                int duration = c.this.gBU.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.adf = false;
                    c.this.mJq = false;
                    c.this.mStartPosition = 0;
                    c.this.dcw();
                    c.this.lfd.setVisibility(0);
                    c.this.mIH.setProgress(c.this.mIH.getMax());
                    c.this.adg = 100;
                    if (c.this.mIO != null) {
                        c.this.mIO.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.xj(false);
                        c.this.xk(true);
                    } else {
                        c.this.dAc();
                        c.this.mIK.setVisibility(0);
                    }
                    if (!c.this.adq && duration <= 150000) {
                        if (!c.this.mJn) {
                            if (c.this.mJa != null) {
                                c.this.mJa.wk(true);
                            }
                            c.this.E(c.this.mVideoUrl, c.this.anU, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gBU.pause();
                            c.this.gBU.seekTo(0);
                        }
                    }
                    if (c.this.mIY != null) {
                        c.this.mIY.AZ(c.this.mIH.getMax());
                        c.this.mIY.GP();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.iBB.setVisibility(0);
            c.this.fVA.dAr();
            c.this.currentState = 4;
            if (c.this.mIQ != null) {
                c.this.mIQ.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mJo = true;
            }
            if (c.this.mIY != null) {
                c.this.mIY.cMU();
            }
            c.this.mJq = false;
            return true;
        }
    };
    protected Runnable lfK = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gBU == null || !c.this.gBU.isPlaying()) {
                c.this.iBB.setVisibility(0);
                c.this.fVA.dAr();
                if (c.this.mIY != null) {
                    c.this.mIY.cMU();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eCg = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mJk) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mJw, 200L);
            }
        }
    };
    private Runnable mJw = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gBU == null || !c.this.mJk) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.adl, 200L);
                c.this.mJk = false;
            } else if (c.this.mStartPosition != c.this.gBU.getCurrentPosition()) {
                c.this.mJk = false;
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.adl, 20L);
            } else {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mJw, 200L);
            }
        }
    };
    private TbCyberVideoView.a fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.adf = false;
            if (c.this.mIS && !c.this.mIT) {
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.mJx, 300L);
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.adl);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.lfK);
        }
    };
    private Runnable mJx = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mJq = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.mlM != null) {
                c.this.mlM.cMW();
            }
            if (view.getId() != c.this.iBB.getId()) {
                if (view.getId() != c.this.mIJ.getId()) {
                    if (view.getId() == c.this.mIL.getId()) {
                        if (c.this.mIZ != null) {
                            c.this.mIZ.dtY();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mIK.getId()) {
                        if (c.this.mJa != null) {
                            c.this.mJa.wk(false);
                        }
                        c.this.fX(c.this.mVideoUrl, c.this.anU);
                        return;
                    } else if (view.getId() == c.this.lfi.getId()) {
                        int i2 = c.this.mIS ? 1 : 2;
                        if (c.this.adq) {
                            TiebaStatic.log(new ar("c11714"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.anU).dR("fid", c.this.fOD).aq("obj_type", i2).aq("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ar("c11710"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.anU).dR("fid", c.this.fOD).aq("obj_type", i2).aq("obj_source", 1));
                        }
                        if (c.this.mJf != null) {
                            c.this.mJf.cFC();
                        }
                        if (c.this.dzN()) {
                            if (c.this.adq) {
                                c.this.dzQ();
                            } else {
                                c.this.dzP();
                            }
                            c.this.xg(c.this.adq);
                            return;
                        }
                        c.this.Uc();
                        return;
                    } else if (view.getId() != c.this.hjx.getId()) {
                        if (c.this.mIU != null) {
                            c.this.mIU.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ar("c11713"));
                        if (c.this.mJf != null) {
                            c.this.mJf.cFC();
                        }
                        if (c.this.dzN()) {
                            c.this.dzQ();
                            c.this.xg(false);
                            return;
                        }
                        c.this.Uc();
                        return;
                    }
                }
                TiebaStatic.log(new ar("c13255"));
                c.this.dtR();
                c.this.dAe();
                if (c.this.currentState != 1) {
                    c.this.dAa();
                    c.this.dAb();
                } else {
                    c.this.dcM();
                }
                if (c.this.mJd != null) {
                    c.this.mJd.rI(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gBU.stopPlayback();
            c.this.adf = false;
            c.this.dzV();
        }
    };
    private Animation.AnimationListener lfM = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener lfN = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable lfO = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.dcJ();
        }
    };
    private CustomMessageListener lfP = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b lhI = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void td(int i2) {
            int duration;
            if (c.this.gBU != null && (duration = c.this.gBU.getDuration()) > 0 && c.this.mIH != null) {
                c.this.mIH.setProgress((int) ((i2 * c.this.bWp.getWidth()) / duration));
                if (c.this.mIY != null) {
                    c.this.mIY.AZ((c.this.gBU.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gjA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ar("c13256"));
            c.this.dAa();
            c.this.xk(false);
            if (c.this.mJd != null) {
                c.this.mJd.rI(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.dcA() != null) {
                c.this.Ef(c.this.dcA().getSeekPosition());
                if (!c.this.dcI()) {
                    c.this.dzV();
                } else {
                    c.this.resumePlay();
                    if (c.this.mlY != null) {
                        c.this.mlY.cFE();
                    }
                }
            }
            c.this.xk(true);
            c.this.dzZ();
            if (c.this.mJd != null) {
                c.this.mJd.rI(true);
            }
            if (c.this.mJe != null) {
                c.this.mJe.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rI(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0855c {
        void rj();

        void rk();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cFD();

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
        void dtY();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cFE();
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
        void cFB();

        void cFC();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dtZ();

        boolean dua();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void AZ(int i);

        void GP();

        void cMU();

        void cMV();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cMW();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mJs = true;
        if (tbPageContext != null) {
            this.eWx = tbPageContext;
            this.mRootView = view;
            this.mJs = z;
            this.lfl = view;
            this.mActivity = this.eWx.getPageActivity();
            init();
        }
    }

    public void init() {
        this.bWp = at(this.mActivity);
        this.bWp.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.bWp);
        }
        this.gBU = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.bWp).addView(this.gBU.getView(), 0);
        this.gBU.getView().setLayoutParams(layoutParams);
        this.fVA = new com.baidu.tieba.play.m((ViewGroup) this.bWp.findViewById(R.id.auto_video_loading_container));
        this.fVA.setLoadingAnimationListener(this.iyG);
        this.lfc = (VideoListMediaControllerView) this.bWp.findViewById(R.id.media_controller);
        this.lfc.setPlayer(this.gBU);
        this.mIH = (ProgressBar) this.bWp.findViewById(R.id.pgrBottomProgress);
        this.mIH.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mIH.setProgress(0);
        this.lfc.setOnSeekBarChangeListener(this.gjA);
        this.lfc.setOnProgressUpdatedListener(this.lhI);
        this.lfd = this.bWp.findViewById(R.id.black_mask);
        this.iBB = this.bWp.findViewById(R.id.layout_error);
        this.iBB.setOnClickListener(this.mOnClickListener);
        this.mJm = (TextView) this.bWp.findViewById(R.id.auto_video_error_tips);
        this.lfe = (FrameLayout) this.bWp.findViewById(R.id.danmu_container);
        this.lfi = (ImageView) this.bWp.findViewById(R.id.img_full_screen);
        this.lfi.setOnClickListener(this.mOnClickListener);
        this.lfj = this.bWp.findViewById(R.id.layout_media_controller);
        this.mII = this.bWp.findViewById(R.id.time_show_controller);
        this.gBU.setContinuePlayEnable(true);
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnCompletionListener(this.eCd);
        this.gBU.setOnErrorListener(this.lfJ);
        this.gBU.setOnSeekCompleteListener(this.eCg);
        this.gBU.setOnInfoListener(this.eCe);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        this.mIJ = (SwitchImageView) this.bWp.findViewById(R.id.img_play_controller);
        this.mIJ.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mIJ.setState(0);
        this.mIJ.setOnClickListener(this.mOnClickListener);
        this.mIK = (TextView) this.bWp.findViewById(R.id.txt_replay);
        this.mIK.setOnClickListener(this.mOnClickListener);
        this.mIL = (TextView) this.bWp.findViewById(R.id.txt_playnext);
        this.mIL.setOnClickListener(this.mOnClickListener);
        this.mIM = (TextView) this.bWp.findViewById(R.id.txt_next_video_title);
        this.anK = (TbImageView) this.bWp.findViewById(R.id.video_thumbnail);
        this.anK.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hjx = (ImageView) this.bWp.findViewById(R.id.img_exit);
        this.hjx.setOnClickListener(this.mOnClickListener);
        this.lfp = (TextView) this.bWp.findViewById(R.id.video_title);
        this.bNL = this.bWp.findViewById(R.id.layout_title);
        this.bNL.setVisibility(8);
        this.jpv = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.cjx = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.lfz = this.mAudioManager.getStreamMaxVolume(3);
        this.mVolume = this.mAudioManager.getStreamVolume(3);
        lfF = 100 / this.lfz;
        this.bWp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mJb != null) {
                    c.this.mJb.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.adf) {
                        if (c.this.mStatus == 1 && c.this.lfB != 0) {
                            c.this.c(c.this.lfB == 1 ? 1000.0f : -1000.0f, false);
                            c.this.lfB = 0;
                            c.this.lfA = 0;
                        }
                        if (!c.this.gBU.isPlaying()) {
                            c.this.mIL.setVisibility(8);
                            c.this.mIK.setVisibility(8);
                            c.this.mIM.setVisibility(8);
                        }
                    }
                    c.this.dcw();
                    if (c.this.mJb != null) {
                        c.this.mJb.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.lfD = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mJs) {
            this.lfD.start();
        }
        this.lfE = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (lfG == null) {
            lfG = new CallStateReceiver();
        }
        lfG.register(this.mActivity);
        dzM();
        MessageManager.getInstance().registerListener(this.lfP);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.lfP);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Hl(int i2) {
        if (this.anK != null) {
            this.anK.setDefaultBgResource(i2);
        }
    }

    public void Hm(int i2) {
        if (this.anK != null) {
            this.anK.setPlaceHolder(i2);
        }
    }

    public void dzM() {
        if (this.mJi) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.bWp.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.bWp.setSystemUiVisibility(0);
    }

    public void xd(boolean z) {
        this.mJi = z;
        dzM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcw() {
        this.mStatus = 0;
        if (this.lft != null && this.lft.getParent() != null && (this.lft.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.lft.getParent()).removeView(this.lft);
                this.lft = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.lfu != null && this.lfu.getParent() != null && (this.lfu.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.lfu.getParent()).removeView(this.lfu);
                this.lfu = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void dcx() {
        if (this.mStatus == 1) {
            if (this.lft == null && this.bWp != null && (this.bWp instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.bWp, true);
                this.lft = this.bWp.findViewById(R.id.lay_jindu);
                this.lfv = (TextView) this.lft.findViewById(R.id.show_time);
                this.lfy = (ImageView) this.lft.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.lfu == null && this.bWp != null && (this.bWp instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.bWp, true);
            this.lfu = this.bWp.findViewById(R.id.lay_voice);
            this.lfx = (ImageView) this.lfu.findViewById(R.id.arrow_voice_icon);
            this.lfw = (SeekBar) this.lfu.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ae(View.OnClickListener onClickListener) {
        this.mIU = onClickListener;
    }

    public void xe(boolean z) {
        this.mIS = z;
    }

    public void xf(boolean z) {
        this.mIT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mJb != null) {
                c.this.mJb.onStart();
            }
            if (c.this.adq && c.this.adf) {
                if (c.this.mStatus == 1) {
                    c.this.dAc();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aV(f2);
                    }
                } else {
                    if (c.this.adq) {
                        c.this.dcz();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.lfA = c.this.gBU.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aV(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.mJt) {
                if (c.this.mJc != null && c.this.mJc.dtZ()) {
                    return true;
                }
                c.this.dtR();
                c.this.dAe();
                if (c.this.gBU.isPlaying()) {
                    c.this.dzZ();
                } else {
                    c.this.dAa();
                }
                if (c.this.mJd != null) {
                    c.this.mJd.rI(c.this.gBU.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mJt) {
                if (c.this.adf) {
                    if (c.this.mJc != null && c.this.mJc.dua()) {
                        return true;
                    }
                    c.this.dzY();
                    if (c.this.gBU.isPlaying()) {
                        c.this.dzZ();
                    } else {
                        c.this.dAa();
                    }
                    if (c.this.mJd != null) {
                        c.this.mJd.rI(c.this.gBU.isPlaying());
                    }
                } else {
                    c.this.dtR();
                    c.this.dAe();
                    if (c.this.currentState != 1) {
                        c.this.dAa();
                        c.this.dAb();
                    } else {
                        c.this.dcM();
                    }
                    if (c.this.mJd != null) {
                        c.this.mJd.rI(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcz() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bWp.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bWp.setSystemUiVisibility(4);
        } else {
            this.bWp.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(float f2) {
        if (!this.adf) {
            this.mStatus = 0;
            return;
        }
        if (lfF == 0) {
            this.lfz = this.mAudioManager.getStreamMaxVolume(3);
            lfF = 100 / this.lfz;
            if (lfF == 0) {
                lfF = 1;
            }
        }
        dcx();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % lfF == 0) {
            if (f2 > 0.0f && this.mVolume < this.lfz) {
                this.mVolume++;
            }
            if (f2 < 0.0f && this.mVolume > 0) {
                this.mVolume--;
            }
        }
        if (this.mProgress > 0) {
            this.lfx.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.lfx.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.mVolume, 0);
        this.lfw.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.lfA -= 1000;
                this.lfB = 1;
            } else {
                this.lfA += 1000;
                this.lfB = 2;
            }
            if (this.lfA < 0) {
                this.lfA = 0;
            } else if (this.lfA > this.gBU.getDuration()) {
                this.lfA = this.gBU.getDuration();
            }
        }
        dcx();
        String Ht = this.lfc.Ht(this.lfA);
        if (f2 > 0.0f) {
            this.lfy.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.lfy.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Ht)) {
            this.lfv.setText(new StringBuilder().append(Ht).append("/").append(this.lfc.Ht(this.gBU.getDuration())));
        }
        this.lfc.setCurrentDuration(this.lfA, z ? false : true);
        dAc();
        dzR();
    }

    protected View at(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Hn(int i2) {
        this.mIN = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.anU = str2;
    }

    public void setFid(String str) {
        this.fOD = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        int i2 = 100;
        if (this.gBU != null && this.lfc != null) {
            this.lfc.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dAv().QK(this.mVideoUrl);
            if (this.mJq) {
                this.gBU.setVolume(1.0f, 1.0f);
                this.gBU.start();
                this.mJq = false;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adl);
                com.baidu.adp.lib.f.e.mA().postDelayed(this.adl, 20L);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJx);
                if (this.gBU.dAC()) {
                    this.currentState = 1;
                    dAc();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dAv().QK(this.mVideoUrl);
                this.lfc.setPlayer(this.gBU);
                if (this.mStartPosition != 0) {
                    this.mJk = true;
                }
                if (!this.mJp) {
                    this.lfc.showProgress();
                }
                if (!this.mIS && this.gBU.getDuration() <= 0) {
                    dcA().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gBU.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.adg = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA() {
        if (this.anK.getVisibility() != 8 || !this.adf) {
            this.adf = true;
            this.lfd.setVisibility(8);
            this.iBB.setVisibility(8);
            this.fVA.dAq();
            this.anK.setVisibility(8);
            dAd();
            this.lfc.showProgress();
            this.mIH.setVisibility(0);
            if (this.lfn != null) {
                this.lfn.onPrepared();
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
        if (hasNavBar(this.mActivity) && (this.mII.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mII.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mII.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mII.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mII.setLayoutParams(layoutParams);
        }
    }

    public void dtR() {
        if (this.gBU.isPlaying()) {
            pausePlay();
            if (this.mJh != null) {
                this.mJh.onPause();
            }
            if (this.mIY != null) {
                this.mIY.onPaused();
            }
        } else if (this.adf) {
            resumePlay();
            if (this.mlY != null) {
                this.mlY.cFE();
            }
            if (this.mIY != null) {
                this.mIY.cMV();
            }
        } else {
            dzV();
        }
    }

    public void Uc() {
        this.lfH = true;
        if (this.lfD != null) {
            this.lfD.Uc();
        }
    }

    public boolean dzN() {
        return this.gBU != null && this.gBU.getView().getHeight() >= this.gBU.getView().getWidth();
    }

    public void dzO() {
        xg(false);
        dzQ();
    }

    public boolean Ho(int i2) {
        switch (i2) {
            case 4:
                if (this.adq) {
                    if (dzN()) {
                        xg(false);
                        dzQ();
                    } else {
                        Uc();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.lfz <= 0 || this.lfw == null) {
                    return false;
                }
                this.mVolume = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.mVolume * 100.0d) / this.lfz);
                this.lfw.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gBU;
    }

    public VideoListMediaControllerView dcA() {
        return this.lfc;
    }

    public void show() {
        this.bWp.setVisibility(0);
    }

    public void dcE() {
        if (this.lfl != null) {
            ViewGroup.LayoutParams layoutParams = this.lfl.getLayoutParams();
            this.lff = (FrameLayout.LayoutParams) this.bWp.getLayoutParams();
            this.lff.width = layoutParams.width;
            this.lff.height = layoutParams.height;
            this.lff.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.bWp.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.bWp.setLayoutParams(this.lff);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.lfH) {
            if (this.adq) {
                TiebaStatic.log(new ar("c11712"));
            } else {
                TiebaStatic.log(new ar("c11711"));
            }
        } else {
            this.lfH = false;
        }
        if (configuration.orientation == 2) {
            dzP();
        } else {
            dzQ();
        }
        dzR();
        if (this.mActivity == com.baidu.adp.base.b.kB().currentActivity()) {
            resumePlay();
        }
        dAe();
        dcM();
        if (this.mJd != null) {
            this.mJd.rI(true);
        }
    }

    protected void dzP() {
        this.adq = true;
        this.bWp.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bFp().fw(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bFp().fx(this.mActivity))));
        j(this.mActivity, true);
        this.bNL.setVisibility(0);
        this.hjx.setVisibility(0);
        this.lfp.setVisibility(0);
        this.lfe.setVisibility(8);
        this.fVA.dAr();
        this.anK.setVisibility(8);
        this.lfi.setImageResource(R.drawable.icon_video_narrow_white);
        Ec(this.lfE);
        dcz();
        if (this.mIV != null) {
            this.mIV.rj();
        }
    }

    protected void dzQ() {
        this.adq = false;
        if (this.lff != null) {
            this.bWp.setLayoutParams(this.lff);
        }
        j(this.mActivity, false);
        this.bNL.setVisibility(8);
        this.lfe.setVisibility(0);
        this.fVA.dAr();
        this.anK.setVisibility(8);
        this.lfi.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.lfc != null && (this.lfc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lfc.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.lfc.setLayoutParams(layoutParams);
        }
        this.bWp.setSystemUiVisibility(0);
        dzM();
        if (this.mIV != null) {
            this.mIV.rk();
        }
    }

    public void dzR() {
        if (this.gBU != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.adq) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mIH.setMax(equipmentWidth);
            int duration = this.gBU.getDuration();
            if (duration > 0) {
                if (this.mIK.getVisibility() == 0) {
                    this.mIH.setProgress(this.mIH.getMax());
                } else {
                    this.mIH.setProgress((int) ((this.gBU.getCurrentPositionSync() * this.mIH.getMax()) / duration));
                }
            }
        }
    }

    private void Ec(int i2) {
        if (this.lfc != null && (this.lfc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lfc.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.lfc.setLayoutParams(layoutParams);
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

    public boolean dcG() {
        return !this.adq;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.lfn = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mIO = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mIQ = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mJl) {
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
        dzW();
        this.mJq = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gBU.setVideoDuration(this.mIN);
        this.gBU.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        if (this.mIX > 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.lfK, this.mIX);
        }
        if (this.mIY != null) {
            this.mIY.onStarted();
        }
        this.fVA.startLoading();
        xh(z);
    }

    public void fX(String str, String str2) {
        E(str, str2, true);
    }

    public void fY(String str, String str2) {
        dzW();
        this.mJq = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        if (this.mIX > 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.lfK, this.mIX);
        }
        if (this.mIY != null) {
            this.mIY.onStarted();
        }
        this.fVA.startLoading();
        xh(true);
    }

    public void dzS() {
        resumePlay();
        this.mIH.setVisibility(0);
    }

    public void resumePlay() {
        int i2 = 100;
        if (this.gBU != null && this.lfc != null) {
            this.adf = true;
            this.currentState = 1;
            this.gBU.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dAv().QK(this.mVideoUrl);
            this.mJk = true;
            if (this.mStartPosition > 100 && this.gBU.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.adg = i2;
            this.fVA.dAr();
            xh(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mJo && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.anU)) {
            this.mJo = false;
            this.mJp = true;
            fX(this.mVideoUrl, this.anU);
        }
    }

    private void xh(boolean z) {
        if (z) {
            this.anK.setVisibility(0);
            dAc();
            this.mIH.setProgress(0);
        } else {
            this.anK.setVisibility(8);
            dAc();
        }
        this.lfc.showProgress();
        this.lfd.setVisibility(8);
        this.mIL.setVisibility(8);
        this.mIK.setVisibility(8);
        this.mIM.setVisibility(8);
        this.iBB.setVisibility(8);
    }

    private void dzT() {
        this.fVA.dAr();
        this.mIL.setVisibility(8);
        this.mIK.setVisibility(8);
        this.mIM.setVisibility(8);
        dAe();
    }

    public void pausePlay() {
        this.gBU.pause();
        this.currentState = 2;
        dzT();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adl);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJx);
        this.gBU.stopPlayback();
        this.adf = false;
        this.mJq = false;
        this.mStartPosition = 0;
        cSR();
    }

    public void dzU() {
        if (this.gBU.getDuration() >= this.gBU.getCurrentPosition()) {
            com.baidu.tieba.play.n.dAv().bL(this.mVideoUrl, this.gBU.getCurrentPositionSync());
        }
    }

    public void xi(boolean z) {
        this.mJj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        if (this.lfj != null) {
            this.lfd.setVisibility(0);
            this.mIL.setVisibility(8);
            this.mIK.setVisibility(8);
            this.mIM.setVisibility(8);
            this.fVA.dAr();
            dAc();
            this.mIH.setVisibility(8);
            this.iBB.setVisibility(8);
            this.lfc.aRr();
            this.anK.setVisibility(z ? 0 : 8);
        }
    }

    public void cSR() {
        xj(true);
    }

    public boolean rl() {
        if (this.gBU == null) {
            return false;
        }
        return this.gBU.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gBU == null) {
            return 0;
        }
        return this.gBU.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mJb = kVar;
    }

    public void a(j jVar) {
        this.mJa = jVar;
    }

    public void a(i iVar) {
        this.mlY = iVar;
    }

    public void a(g gVar) {
        this.mJh = gVar;
    }

    public void a(h hVar) {
        this.mIZ = hVar;
    }

    public void Qk(String str) {
        this.mlz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzV() {
        a(this.mVideoUrl, this.anU, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mIW = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dzW();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.f.dSn().dSo() && !TbSingleton.getInstance().hasAgreeToPlay()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mJl = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mJg != null) {
                    this.mJg.qX(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.AB(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dzX();
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
                aVar.b(this.eWx).bqz();
                return;
            } else if (this.mJg != null) {
                this.mJg.qX(true);
                return;
            } else {
                if (!this.mIG) {
                    this.mIG = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mJf != null) {
            this.mJf.cFB();
        }
    }

    private void dzW() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dSn().gY(this.mActivity);
        }
    }

    public void dzX() {
        com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.anK.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adl);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJw);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJx);
        this.lfD.stop();
        lfG.unregister(this.mActivity);
    }

    public void QJ(String str) {
        this.lfp.setText(str);
    }

    public boolean dcI() {
        return this.adf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzY() {
        if (this.lfj != null) {
            if (this.mIR) {
                dAc();
            } else {
                dAb();
            }
        }
    }

    public void dcM() {
        dAb();
        dzZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzZ() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.lfO, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAa() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
    }

    public void dAb() {
        if (this.lfj != null && !this.mIR && !this.mJu) {
            xk(true);
            dcL();
            this.lfj.setVisibility(0);
            this.mII.setVisibility(0);
            this.mIH.setVisibility(8);
            this.mIR = true;
            if (this.mIW != null) {
                this.mIW.qY(false);
            }
        }
    }

    public void dcJ() {
        if (this.lfj != null && this.mIR) {
            xk(false);
            dcL();
            this.lfj.setVisibility(8);
            this.mII.setVisibility(8);
            this.mIH.setVisibility(0);
            this.jpv.setAnimationListener(this.lfM);
            this.lfj.startAnimation(this.jpv);
            this.mIR = false;
            if (this.mIW != null) {
                this.mIW.cFD();
            }
        }
    }

    public void dAc() {
        if (this.lfj != null && this.mIR) {
            this.cjx.cancel();
            this.jpv.cancel();
            xk(false);
            dcL();
            this.lfj.setVisibility(8);
            this.mII.setVisibility(8);
            this.mIH.setVisibility(0);
            this.mIR = false;
            if (this.mIW != null) {
                this.mIW.cFD();
            }
        }
    }

    private void dcL() {
        if (this.lfj != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
            this.cjx.setAnimationListener(null);
            this.jpv.setAnimationListener(null);
            this.lfj.clearAnimation();
        }
    }

    private void dAd() {
        if (this.lfj != null) {
            this.cjx.setAnimationListener(null);
            this.jpv.setAnimationListener(null);
            this.lfj.clearAnimation();
        }
    }

    public void xk(boolean z) {
        dAe();
        if (z) {
            this.mIJ.setVisibility(0);
        } else {
            this.mIJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAe() {
        if (this.currentState == 1) {
            this.mIJ.setState(1);
        } else {
            this.mIJ.setState(0);
        }
    }

    public void a(InterfaceC0855c interfaceC0855c) {
        this.mIV = interfaceC0855c;
    }

    public void Ef(int i2) {
        this.mStartPosition = i2;
    }

    public void ax(boolean z, boolean z2) {
        if (this.lfD != null) {
            if (this.lfi != null) {
                this.lfi.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.lfc != null && (this.lfc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lfc.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.lfc.setLayoutParams(layoutParams);
            }
            this.lfD.dh(z);
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
        this.mJt = z;
    }

    public void a(m mVar) {
        this.mJc = mVar;
    }

    public void a(a aVar) {
        this.mJd = aVar;
    }

    public void a(n nVar) {
        this.mJe = nVar;
    }

    public void a(l lVar) {
        this.mJf = lVar;
    }

    public void a(f fVar) {
        this.mJg = fVar;
    }

    public void xm(boolean z) {
        this.mJn = z;
    }

    public void xn(boolean z) {
        this.mIS = z;
    }

    public void Hp(int i2) {
        this.mJr = i2;
    }

    public View dAf() {
        return this.bWp;
    }

    public void a(o oVar) {
        this.mIY = oVar;
    }

    public void a(p pVar) {
        this.mlM = pVar;
    }

    public void dAg() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eWx.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eWx.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gBU != null) {
            this.gBU.setStageType(str);
        }
    }

    public boolean isFullScreen() {
        return this.adq;
    }
}
