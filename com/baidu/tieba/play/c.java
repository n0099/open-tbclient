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
import com.baidu.tbadk.core.util.aq;
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
    private static int kZQ;
    private static CallStateReceiver kZR;
    private String anD;
    private TbImageView ant;
    private View bNn;
    public View bVM;
    private Animation ciB;
    private TbPageContext<?> eXu;
    private String fPy;
    private com.baidu.tieba.play.m fWs;
    protected TbCyberVideoView gBU;
    private ImageView hhZ;
    protected View iyB;
    private Animation jmy;
    private View kZD;
    private View kZE;
    private TextView kZF;
    private SeekBar kZG;
    private ImageView kZH;
    private ImageView kZI;
    private int kZJ;
    private com.baidu.tieba.play.j kZN;
    private int kZP;
    private VideoListMediaControllerView kZm;
    private View kZn;
    private FrameLayout kZo;
    protected FrameLayout.LayoutParams kZp;
    private ImageView kZs;
    private View kZt;
    private View kZv;
    private CyberPlayerManager.OnPreparedListener kZx;
    private TextView kZz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private ProgressBar mBM;
    private View mBN;
    private SwitchImageView mBO;
    private TextView mBP;
    private TextView mBQ;
    private TextView mBR;
    private int mBS;
    private CyberPlayerManager.OnCompletionListener mBT;
    private CyberPlayerManager.OnErrorListener mBU;
    private View.OnClickListener mBX;
    protected InterfaceC0862c mBY;
    private d mBZ;
    private o mCb;
    private h mCc;
    private j mCd;
    private k mCe;
    private m mCf;
    private a mCg;
    private n mCh;
    private l mCi;
    private f mCj;
    private g mCk;
    private TextView mCp;
    private boolean mCr;
    private boolean mCs;
    private boolean mCt;
    private int mCu;
    private boolean mCw;
    private boolean mCx;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private p meW;
    private i mfi;
    private int abQ = 100;
    private boolean mBL = false;
    protected boolean aca = false;
    private boolean abP = false;
    private boolean mBV = false;
    private boolean mBW = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kZK = 0;
    private int kZL = 0;
    private long mCa = AppStatusRules.DEFAULT_GRANULARITY;
    private int kZO = 0;
    private boolean kZS = false;
    private boolean mCl = true;
    private boolean mCm = true;
    private boolean mCn = false;
    private boolean mCo = false;
    private String meJ = null;
    private int currentState = -1;
    private boolean mCq = false;
    private boolean mCy = false;
    private boolean mCz = false;
    private CyberPlayerManager.OnPreparedListener eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kZm != null && c.this.gBU != null && c.this.gBU.getDuration() > 0) {
                c.this.kZm.bz(0, c.this.gBU.getDuration());
            }
            c.this.cuI();
            if (c.this.mCb != null) {
                c.this.mCb.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rC();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a ivM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.cuI();
        }
    };
    private Runnable abV = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abV);
            if (c.this.ant.getVisibility() != 8) {
                if (c.this.gBU.getCurrentPosition() > c.this.abQ) {
                    c.this.rC();
                } else {
                    com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abV, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gBU != null) {
                int duration = c.this.gBU.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.abP = false;
                    c.this.mCt = false;
                    c.this.mStartPosition = 0;
                    c.this.dea();
                    c.this.kZn.setVisibility(0);
                    c.this.mBM.setProgress(c.this.mBM.getMax());
                    c.this.abQ = 100;
                    if (c.this.mBT != null) {
                        c.this.mBT.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.wV(false);
                        c.this.wW(true);
                    } else {
                        c.this.dBv();
                        c.this.mBP.setVisibility(0);
                    }
                    if (!c.this.aca && duration <= 150000) {
                        if (!c.this.mCq) {
                            if (c.this.mCd != null) {
                                c.this.mCd.vY(true);
                            }
                            c.this.E(c.this.mVideoUrl, c.this.anD, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gBU.pause();
                            c.this.gBU.seekTo(0);
                        }
                    }
                    if (c.this.mCb != null) {
                        c.this.mCb.IB(c.this.mBM.getMax());
                        c.this.mCb.Jr();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.iyB.setVisibility(0);
            c.this.fWs.dBM();
            c.this.currentState = 4;
            if (c.this.mBU != null) {
                c.this.mBU.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mCr = true;
            }
            if (c.this.mCb != null) {
                c.this.mCb.dBA();
            }
            c.this.mCt = false;
            return true;
        }
    };
    protected Runnable kZV = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gBU == null || !c.this.gBU.isPlaying()) {
                c.this.iyB.setVisibility(0);
                c.this.fWs.dBM();
                if (c.this.mCb != null) {
                    c.this.mCb.dBA();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eDk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mCn) {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.mCA, 200L);
            }
        }
    };
    private Runnable mCA = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gBU == null || !c.this.mCn) {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abV, 200L);
                c.this.mCn = false;
            } else if (c.this.mStartPosition != c.this.gBU.getCurrentPosition()) {
                c.this.mCn = false;
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abV, 20L);
            } else {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.mCA, 200L);
            }
        }
    };
    private TbCyberVideoView.a fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abP = false;
            if (c.this.mBW) {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.mCB, 300L);
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abV);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.kZV);
        }
    };
    private Runnable mCB = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mCt = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.meW != null) {
                c.this.meW.dvm();
            }
            if (view.getId() != c.this.iyB.getId()) {
                if (view.getId() != c.this.mBO.getId()) {
                    if (view.getId() == c.this.mBQ.getId()) {
                        if (c.this.mCc != null) {
                            c.this.mCc.dvn();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mBP.getId()) {
                        if (c.this.mCd != null) {
                            c.this.mCd.vY(false);
                        }
                        c.this.fY(c.this.mVideoUrl, c.this.anD);
                        return;
                    } else if (view.getId() == c.this.kZs.getId()) {
                        int i2 = c.this.mBW ? 1 : 2;
                        if (c.this.aca) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dX("tid", c.this.anD).dX("fid", c.this.fPy).an("obj_type", i2).an("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dX("tid", c.this.anD).dX("fid", c.this.fPy).an("obj_type", i2).an("obj_source", 1));
                        }
                        if (c.this.mCi != null) {
                            c.this.mCi.cHV();
                        }
                        if (c.this.dBg()) {
                            if (c.this.aca) {
                                c.this.dBj();
                            } else {
                                c.this.dBi();
                            }
                            c.this.wS(c.this.aca);
                            return;
                        }
                        c.this.Wl();
                        return;
                    } else if (view.getId() != c.this.hhZ.getId()) {
                        if (c.this.mBX != null) {
                            c.this.mBX.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.mCi != null) {
                            c.this.mCi.cHV();
                        }
                        if (c.this.dBg()) {
                            c.this.dBj();
                            c.this.wS(false);
                            return;
                        }
                        c.this.Wl();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.dvf();
                c.this.dBx();
                if (c.this.currentState != 1) {
                    c.this.dBt();
                    c.this.dBu();
                } else {
                    c.this.deq();
                }
                if (c.this.mCg != null) {
                    c.this.mCg.rC(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gBU.stopPlayback();
            c.this.abP = false;
            c.this.dBo();
        }
    };
    private Animation.AnimationListener kZX = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kZY = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kZZ = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.den();
        }
    };
    private CustomMessageListener laa = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aUD();
            }
        }
    };
    private VideoControllerView.b lbU = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void uC(int i2) {
            int duration;
            if (c.this.gBU != null && (duration = c.this.gBU.getDuration()) > 0 && c.this.mBM != null) {
                c.this.mBM.setProgress((int) ((i2 * c.this.bVM.getWidth()) / duration));
                if (c.this.mCb != null) {
                    c.this.mCb.IB((c.this.gBU.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gkb = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.dBt();
            c.this.wW(false);
            if (c.this.mCg != null) {
                c.this.mCg.rC(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.dee() != null) {
                c.this.Fq(c.this.dee().getSeekPosition());
                if (!c.this.dem()) {
                    c.this.dBo();
                } else {
                    c.this.aUE();
                    if (c.this.mfi != null) {
                        c.this.mfi.cHX();
                    }
                }
            }
            c.this.wW(true);
            c.this.dBs();
            if (c.this.mCg != null) {
                c.this.mCg.rC(true);
            }
            if (c.this.mCh != null) {
                c.this.mCh.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rC(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0862c {
        void rl();

        void rm();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cHW();

        void qS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void xa(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void qR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dvn();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cHX();
    }

    /* loaded from: classes.dex */
    public interface j {
        void vY(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cHU();

        void cHV();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dvo();

        boolean dvp();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void IB(int i);

        void Jr();

        void dBA();

        void dBB();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dvm();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mCw = true;
        if (tbPageContext != null) {
            this.eXu = tbPageContext;
            this.mRootView = view;
            this.mCw = z;
            this.kZv = view;
            this.mActivity = this.eXu.getPageActivity();
            init();
        }
    }

    public void init() {
        this.bVM = az(this.mActivity);
        this.bVM.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.bVM);
        }
        this.gBU = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.bVM).addView(this.gBU.getView(), 0);
        this.gBU.getView().setLayoutParams(layoutParams);
        this.fWs = new com.baidu.tieba.play.m((ViewGroup) this.bVM.findViewById(R.id.auto_video_loading_container));
        this.fWs.setLoadingAnimationListener(this.ivM);
        this.kZm = (VideoListMediaControllerView) this.bVM.findViewById(R.id.media_controller);
        this.kZm.setPlayer(this.gBU);
        this.mBM = (ProgressBar) this.bVM.findViewById(R.id.pgrBottomProgress);
        this.mBM.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mBM.setProgress(0);
        this.kZm.setOnSeekBarChangeListener(this.gkb);
        this.kZm.setOnProgressUpdatedListener(this.lbU);
        this.kZn = this.bVM.findViewById(R.id.black_mask);
        this.iyB = this.bVM.findViewById(R.id.layout_error);
        this.iyB.setOnClickListener(this.mOnClickListener);
        this.mCp = (TextView) this.bVM.findViewById(R.id.auto_video_error_tips);
        this.kZo = (FrameLayout) this.bVM.findViewById(R.id.danmu_container);
        this.kZs = (ImageView) this.bVM.findViewById(R.id.img_full_screen);
        this.kZs.setOnClickListener(this.mOnClickListener);
        this.kZt = this.bVM.findViewById(R.id.layout_media_controller);
        this.mBN = this.bVM.findViewById(R.id.time_show_controller);
        this.gBU.setContinuePlayEnable(true);
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnCompletionListener(this.eDh);
        this.gBU.setOnErrorListener(this.kZU);
        this.gBU.setOnSeekCompleteListener(this.eDk);
        this.gBU.setOnInfoListener(this.eDi);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        this.mBO = (SwitchImageView) this.bVM.findViewById(R.id.img_play_controller);
        this.mBO.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mBO.setState(0);
        this.mBO.setOnClickListener(this.mOnClickListener);
        this.mBP = (TextView) this.bVM.findViewById(R.id.txt_replay);
        this.mBP.setOnClickListener(this.mOnClickListener);
        this.mBQ = (TextView) this.bVM.findViewById(R.id.txt_playnext);
        this.mBQ.setOnClickListener(this.mOnClickListener);
        this.mBR = (TextView) this.bVM.findViewById(R.id.txt_next_video_title);
        this.ant = (TbImageView) this.bVM.findViewById(R.id.video_thumbnail);
        this.ant.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hhZ = (ImageView) this.bVM.findViewById(R.id.img_exit);
        this.hhZ.setOnClickListener(this.mOnClickListener);
        this.kZz = (TextView) this.bVM.findViewById(R.id.video_title);
        this.bNn = this.bVM.findViewById(R.id.layout_title);
        this.bNn.setVisibility(8);
        this.jmy = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.ciB = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.kZJ = this.mAudioManager.getStreamMaxVolume(3);
        this.kZP = this.mAudioManager.getStreamVolume(3);
        kZQ = 100 / this.kZJ;
        this.bVM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mCe != null) {
                    c.this.mCe.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abP) {
                        if (c.this.mStatus == 1 && c.this.kZL != 0) {
                            c.this.c(c.this.kZL == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kZL = 0;
                            c.this.kZK = 0;
                        }
                        if (!c.this.gBU.isPlaying()) {
                            c.this.mBQ.setVisibility(8);
                            c.this.mBP.setVisibility(8);
                            c.this.mBR.setVisibility(8);
                        }
                    }
                    c.this.dea();
                    if (c.this.mCe != null) {
                        c.this.mCe.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kZN = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mCw) {
            this.kZN.start();
        }
        this.kZO = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kZR == null) {
            kZR = new CallStateReceiver();
        }
        kZR.register(this.mActivity);
        dBf();
        MessageManager.getInstance().registerListener(this.laa);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.laa);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Ix(int i2) {
        if (this.ant != null) {
            this.ant.setDefaultBgResource(i2);
        }
    }

    public void dBf() {
        if (this.mCl) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.bVM.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.bVM.setSystemUiVisibility(0);
    }

    public void wQ(boolean z) {
        this.mCl = z;
        dBf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dea() {
        this.mStatus = 0;
        if (this.kZD != null && this.kZD.getParent() != null && (this.kZD.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kZD.getParent()).removeView(this.kZD);
                this.kZD = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kZE != null && this.kZE.getParent() != null && (this.kZE.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kZE.getParent()).removeView(this.kZE);
                this.kZE = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void deb() {
        if (this.mStatus == 1) {
            if (this.kZD == null && this.bVM != null && (this.bVM instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.bVM, true);
                this.kZD = this.bVM.findViewById(R.id.lay_jindu);
                this.kZF = (TextView) this.kZD.findViewById(R.id.show_time);
                this.kZI = (ImageView) this.kZD.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kZE == null && this.bVM != null && (this.bVM instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.bVM, true);
            this.kZE = this.bVM.findViewById(R.id.lay_voice);
            this.kZH = (ImageView) this.kZE.findViewById(R.id.arrow_voice_icon);
            this.kZG = (SeekBar) this.kZE.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mBX = onClickListener;
    }

    public void wR(boolean z) {
        this.mBW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mCe != null) {
                c.this.mCe.onStart();
            }
            if (c.this.aca && c.this.abP) {
                if (c.this.mStatus == 1) {
                    c.this.dBv();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aO(f2);
                    }
                } else {
                    if (c.this.aca) {
                        c.this.ded();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kZK = c.this.gBU.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aO(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.mCx) {
                if (c.this.mCf != null && c.this.mCf.dvo()) {
                    return true;
                }
                c.this.dvf();
                c.this.dBx();
                if (c.this.gBU.isPlaying()) {
                    c.this.dBs();
                } else {
                    c.this.dBt();
                }
                if (c.this.mCg != null) {
                    c.this.mCg.rC(c.this.gBU.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mCx) {
                if (c.this.abP) {
                    if (c.this.mCf != null && c.this.mCf.dvp()) {
                        return true;
                    }
                    c.this.dBr();
                    if (c.this.gBU.isPlaying()) {
                        c.this.dBs();
                    } else {
                        c.this.dBt();
                    }
                    if (c.this.mCg != null) {
                        c.this.mCg.rC(c.this.gBU.isPlaying());
                    }
                } else {
                    c.this.dvf();
                    c.this.dBx();
                    if (c.this.currentState != 1) {
                        c.this.dBt();
                        c.this.dBu();
                    } else {
                        c.this.deq();
                    }
                    if (c.this.mCg != null) {
                        c.this.mCg.rC(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ded() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bVM.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bVM.setSystemUiVisibility(4);
        } else {
            this.bVM.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f2) {
        if (!this.abP) {
            this.mStatus = 0;
            return;
        }
        if (kZQ == 0) {
            this.kZJ = this.mAudioManager.getStreamMaxVolume(3);
            kZQ = 100 / this.kZJ;
            if (kZQ == 0) {
                kZQ = 1;
            }
        }
        deb();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kZQ == 0) {
            if (f2 > 0.0f && this.kZP < this.kZJ) {
                this.kZP++;
            }
            if (f2 < 0.0f && this.kZP > 0) {
                this.kZP--;
            }
        }
        if (this.mProgress > 0) {
            this.kZH.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kZH.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kZP, 0);
        this.kZG.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kZK -= 1000;
                this.kZL = 1;
            } else {
                this.kZK += 1000;
                this.kZL = 2;
            }
            if (this.kZK < 0) {
                this.kZK = 0;
            } else if (this.kZK > this.gBU.getDuration()) {
                this.kZK = this.gBU.getDuration();
            }
        }
        deb();
        String IF = this.kZm.IF(this.kZK);
        if (f2 > 0.0f) {
            this.kZI.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kZI.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(IF)) {
            this.kZF.setText(new StringBuilder().append(IF).append("/").append(this.kZm.IF(this.gBU.getDuration())));
        }
        this.kZm.setCurrentDuration(this.kZK, z ? false : true);
        dBv();
        dBk();
    }

    protected View az(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Iy(int i2) {
        this.mBS = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.anD = str2;
    }

    public void setFid(String str) {
        this.fPy = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        int i2 = 100;
        if (this.gBU != null && this.kZm != null) {
            this.kZm.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dBQ().QT(this.mVideoUrl);
            if (this.mCt) {
                this.gBU.setVolume(1.0f, 1.0f);
                this.gBU.start();
                this.mCt = false;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abV);
                com.baidu.adp.lib.f.e.mB().postDelayed(this.abV, 20L);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCB);
                if (this.gBU.dBX()) {
                    this.currentState = 1;
                    dBv();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dBQ().QT(this.mVideoUrl);
                this.kZm.setPlayer(this.gBU);
                if (this.mStartPosition != 0) {
                    this.mCn = true;
                }
                if (!this.mCs) {
                    this.kZm.showProgress();
                }
                if (!this.mBW && this.gBU.getDuration() <= 0) {
                    dee().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gBU.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abQ = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        if (this.ant.getVisibility() != 8 || !this.abP) {
            this.abP = true;
            this.kZn.setVisibility(8);
            this.iyB.setVisibility(8);
            this.fWs.dBL();
            this.ant.setVisibility(8);
            dBw();
            this.kZm.showProgress();
            this.mBM.setVisibility(0);
            if (this.kZx != null) {
                this.kZx.onPrepared();
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

    protected void wS(boolean z) {
        if (hasNavBar(this.mActivity) && (this.mBN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBN.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mBN.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mBN.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mBN.setLayoutParams(layoutParams);
        }
    }

    public void dvf() {
        if (this.gBU.isPlaying()) {
            aUD();
            if (this.mCk != null) {
                this.mCk.onPause();
            }
            if (this.mCb != null) {
                this.mCb.onPaused();
            }
        } else if (this.abP) {
            aUE();
            if (this.mfi != null) {
                this.mfi.cHX();
            }
            if (this.mCb != null) {
                this.mCb.dBB();
            }
        } else {
            dBo();
        }
    }

    public void Wl() {
        this.kZS = true;
        if (this.kZN != null) {
            this.kZN.Wl();
        }
    }

    public boolean dBg() {
        return this.gBU != null && this.gBU.getView().getHeight() > this.gBU.getView().getWidth();
    }

    public void dBh() {
        wS(false);
        dBj();
    }

    public boolean Iz(int i2) {
        switch (i2) {
            case 4:
                if (this.aca) {
                    if (dBg()) {
                        wS(false);
                        dBj();
                    } else {
                        Wl();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kZJ <= 0 || this.kZG == null) {
                    return false;
                }
                this.kZP = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kZP * 100.0d) / this.kZJ);
                this.kZG.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gBU;
    }

    public VideoListMediaControllerView dee() {
        return this.kZm;
    }

    public void show() {
        this.bVM.setVisibility(0);
    }

    public void dei() {
        if (this.kZv != null) {
            ViewGroup.LayoutParams layoutParams = this.kZv.getLayoutParams();
            this.kZp = (FrameLayout.LayoutParams) this.bVM.getLayoutParams();
            this.kZp.width = layoutParams.width;
            this.kZp.height = layoutParams.height;
            this.kZp.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.bVM.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.bVM.setLayoutParams(this.kZp);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kZS) {
            if (this.aca) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.kZS = false;
        }
        if (configuration.orientation == 2) {
            dBi();
        } else {
            dBj();
        }
        dBk();
        if (this.mActivity == com.baidu.adp.base.b.kC().currentActivity()) {
            aUE();
        }
        dBx();
        deq();
        if (this.mCg != null) {
            this.mCg.rC(true);
        }
    }

    protected void dBi() {
        this.aca = true;
        this.bVM.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.f.bIK().fA(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.f.bIK().fB(this.mActivity))));
        j(this.mActivity, true);
        this.bNn.setVisibility(0);
        this.hhZ.setVisibility(0);
        this.kZz.setVisibility(0);
        this.kZo.setVisibility(8);
        this.fWs.dBM();
        this.ant.setVisibility(8);
        this.kZs.setImageResource(R.drawable.icon_video_narrow_white);
        Fn(this.kZO);
        ded();
        if (this.mBY != null) {
            this.mBY.rl();
        }
    }

    protected void dBj() {
        this.aca = false;
        if (this.kZp != null) {
            this.bVM.setLayoutParams(this.kZp);
        }
        j(this.mActivity, false);
        this.bNn.setVisibility(8);
        this.kZo.setVisibility(0);
        this.fWs.dBM();
        this.ant.setVisibility(8);
        this.kZs.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kZm != null && (this.kZm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kZm.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kZm.setLayoutParams(layoutParams);
        }
        this.bVM.setSystemUiVisibility(0);
        dBf();
        if (this.mBY != null) {
            this.mBY.rm();
        }
    }

    public void dBk() {
        if (this.gBU != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.aca) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mBM.setMax(equipmentWidth);
            int duration = this.gBU.getDuration();
            if (duration > 0) {
                if (this.mBP.getVisibility() == 0) {
                    this.mBM.setProgress(this.mBM.getMax());
                } else {
                    this.mBM.setProgress((int) ((this.gBU.getCurrentPositionSync() * this.mBM.getMax()) / duration));
                }
            }
        }
    }

    private void Fn(int i2) {
        if (this.kZm != null && (this.kZm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kZm.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kZm.setLayoutParams(layoutParams);
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

    public boolean dek() {
        return !this.aca;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kZx = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mBT = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mBU = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mCo) {
            fZ(str, str2);
        } else {
            fY(str, str2);
        }
        if (eVar != null) {
            eVar.xa(z);
        }
    }

    public void fX(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2, boolean z) {
        dBp();
        this.mCt = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gBU.setVideoDuration(this.mBS);
        this.gBU.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        if (this.mCa > 0) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kZV, this.mCa);
        }
        if (this.mCb != null) {
            this.mCb.onStarted();
        }
        this.fWs.startLoading();
        wT(z);
    }

    public void fY(String str, String str2) {
        E(str, str2, true);
    }

    public void fZ(String str, String str2) {
        dBp();
        this.mCt = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        if (this.mCa > 0) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kZV, this.mCa);
        }
        if (this.mCb != null) {
            this.mCb.onStarted();
        }
        this.fWs.startLoading();
        wT(true);
    }

    public void dBl() {
        aUE();
        this.mBM.setVisibility(0);
    }

    public void aUE() {
        int i2 = 100;
        if (this.gBU != null && this.kZm != null) {
            this.abP = true;
            this.currentState = 1;
            this.gBU.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dBQ().QT(this.mVideoUrl);
            this.mCn = true;
            if (this.mStartPosition > 100 && this.gBU.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abQ = i2;
            this.fWs.dBM();
            wT(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mCr && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.anD)) {
            this.mCr = false;
            this.mCs = true;
            fY(this.mVideoUrl, this.anD);
        }
    }

    private void wT(boolean z) {
        if (z) {
            this.ant.setVisibility(0);
            dBv();
            this.mBM.setProgress(0);
        } else {
            this.ant.setVisibility(8);
            dBv();
        }
        this.kZm.showProgress();
        this.kZn.setVisibility(8);
        this.mBQ.setVisibility(8);
        this.mBP.setVisibility(8);
        this.mBR.setVisibility(8);
        this.iyB.setVisibility(8);
    }

    private void dBm() {
        this.fWs.dBM();
        this.mBQ.setVisibility(8);
        this.mBP.setVisibility(8);
        this.mBR.setVisibility(8);
        dBx();
    }

    public void aUD() {
        this.gBU.pause();
        this.currentState = 2;
        dBm();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abV);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCB);
        this.gBU.stopPlayback();
        this.abP = false;
        this.mCt = false;
        this.mStartPosition = 0;
        cUw();
    }

    public void dBn() {
        if (this.gBU.getDuration() >= this.gBU.getCurrentPosition()) {
            com.baidu.tieba.play.n.dBQ().bK(this.mVideoUrl, this.gBU.getCurrentPositionSync());
        }
    }

    public void wU(boolean z) {
        this.mCm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(boolean z) {
        if (this.kZt != null) {
            this.kZn.setVisibility(0);
            this.mBQ.setVisibility(8);
            this.mBP.setVisibility(8);
            this.mBR.setVisibility(8);
            this.fWs.dBM();
            dBv();
            this.mBM.setVisibility(8);
            this.iyB.setVisibility(8);
            this.kZm.aUS();
            this.ant.setVisibility(z ? 0 : 8);
        }
    }

    public void cUw() {
        wV(true);
    }

    public boolean rn() {
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
        this.mCe = kVar;
    }

    public void a(j jVar) {
        this.mCd = jVar;
    }

    public void a(i iVar) {
        this.mfi = iVar;
    }

    public void a(g gVar) {
        this.mCk = gVar;
    }

    public void a(h hVar) {
        this.mCc = hVar;
    }

    public void Qt(String str) {
        this.meJ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBo() {
        a(this.mVideoUrl, this.anD, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mBZ = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dBp();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.f.dTE().dTF()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mCo = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mCj != null) {
                    this.mCj.qR(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dBq();
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
                aVar.b(this.eXu).btY();
                return;
            } else if (this.mCj != null) {
                this.mCj.qR(true);
                return;
            } else {
                if (!this.mBL) {
                    this.mBL = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mCi != null) {
            this.mCi.cHU();
        }
    }

    private void dBp() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dTE().gY(this.mActivity);
        }
    }

    public void dBq() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.ant.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abV);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCA);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCB);
        this.kZN.stop();
        kZR.unregister(this.mActivity);
    }

    public void QS(String str) {
        this.kZz.setText(str);
    }

    public boolean dem() {
        return this.abP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBr() {
        if (this.kZt != null) {
            if (this.mBV) {
                dBv();
            } else {
                dBu();
            }
        }
    }

    public void deq() {
        dBu();
        dBs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBs() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.kZZ, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBt() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
    }

    public void dBu() {
        if (this.kZt != null && !this.mBV && !this.mCy) {
            wW(true);
            dep();
            this.kZt.setVisibility(0);
            this.mBN.setVisibility(0);
            this.mBM.setVisibility(8);
            this.mBV = true;
            if (this.mBZ != null) {
                this.mBZ.qS(false);
            }
        }
    }

    public void den() {
        if (this.kZt != null && this.mBV) {
            wW(false);
            dep();
            this.kZt.setVisibility(8);
            this.mBN.setVisibility(8);
            this.mBM.setVisibility(0);
            this.jmy.setAnimationListener(this.kZX);
            this.kZt.startAnimation(this.jmy);
            this.mBV = false;
            if (this.mBZ != null) {
                this.mBZ.cHW();
            }
        }
    }

    public void dBv() {
        if (this.kZt != null && this.mBV) {
            this.ciB.cancel();
            this.jmy.cancel();
            wW(false);
            dep();
            this.kZt.setVisibility(8);
            this.mBN.setVisibility(8);
            this.mBM.setVisibility(0);
            this.mBV = false;
            if (this.mBZ != null) {
                this.mBZ.cHW();
            }
        }
    }

    private void dep() {
        if (this.kZt != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
            this.ciB.setAnimationListener(null);
            this.jmy.setAnimationListener(null);
            this.kZt.clearAnimation();
        }
    }

    private void dBw() {
        if (this.kZt != null) {
            this.ciB.setAnimationListener(null);
            this.jmy.setAnimationListener(null);
            this.kZt.clearAnimation();
        }
    }

    public void wW(boolean z) {
        dBx();
        if (z) {
            this.mBO.setVisibility(0);
        } else {
            this.mBO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBx() {
        if (this.currentState == 1) {
            this.mBO.setState(1);
        } else {
            this.mBO.setState(0);
        }
    }

    public void a(InterfaceC0862c interfaceC0862c) {
        this.mBY = interfaceC0862c;
    }

    public void Fq(int i2) {
        this.mStartPosition = i2;
    }

    public void ax(boolean z, boolean z2) {
        if (this.kZN != null) {
            if (this.kZs != null) {
                this.kZs.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kZm != null && (this.kZm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kZm.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kZm.setLayoutParams(layoutParams);
            }
            this.kZN.dd(z);
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

    public void wX(boolean z) {
        this.mCx = z;
    }

    public void a(m mVar) {
        this.mCf = mVar;
    }

    public void a(a aVar) {
        this.mCg = aVar;
    }

    public void a(n nVar) {
        this.mCh = nVar;
    }

    public void a(l lVar) {
        this.mCi = lVar;
    }

    public void a(f fVar) {
        this.mCj = fVar;
    }

    public void wY(boolean z) {
        this.mCq = z;
    }

    public void wZ(boolean z) {
        this.mBW = z;
    }

    public void IA(int i2) {
        this.mCu = i2;
    }

    public View dBy() {
        return this.bVM;
    }

    public void a(p pVar) {
        this.meW = pVar;
    }

    public void dBz() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eXu.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eXu.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gBU != null) {
            this.gBU.setStageType(str);
        }
    }
}
