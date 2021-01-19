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
    private static int kVl;
    private static CallStateReceiver kVm;
    private TbImageView amC;
    private String amM;
    private View bIB;
    public View bRa;
    private Animation cdO;
    private TbPageContext<?> eSJ;
    private String fKR;
    private com.baidu.tieba.play.m fRL;
    protected TbCyberVideoView gxn;
    private ImageView hdt;
    protected View itU;
    private Animation jhQ;
    private VideoListMediaControllerView kUH;
    private View kUI;
    private FrameLayout kUJ;
    protected FrameLayout.LayoutParams kUK;
    private ImageView kUN;
    private View kUO;
    private View kUQ;
    private CyberPlayerManager.OnPreparedListener kUS;
    private TextView kUU;
    private View kUY;
    private View kUZ;
    private TextView kVa;
    private SeekBar kVb;
    private ImageView kVc;
    private ImageView kVd;
    private int kVe;
    private com.baidu.tieba.play.j kVi;
    private int kVk;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private i maD;
    private p maq;
    private m mxA;
    private a mxB;
    private n mxC;
    private l mxD;
    private f mxE;
    private g mxF;
    private TextView mxK;
    private boolean mxM;
    private boolean mxN;
    private boolean mxO;
    private int mxP;
    private boolean mxQ;
    private boolean mxR;
    private ProgressBar mxh;
    private View mxi;
    private SwitchImageView mxj;
    private TextView mxk;
    private TextView mxl;
    private TextView mxm;
    private int mxn;
    private CyberPlayerManager.OnCompletionListener mxo;
    private CyberPlayerManager.OnErrorListener mxp;
    private View.OnClickListener mxs;
    protected InterfaceC0845c mxt;
    private d mxu;
    private o mxw;
    private h mxx;
    private j mxy;
    private k mxz;
    private int abO = 100;
    private boolean mxg = false;
    protected boolean abY = false;
    private boolean abN = false;
    private boolean mxq = false;
    private boolean mxr = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kVf = 0;
    private int kVg = 0;
    private long mxv = AppStatusRules.DEFAULT_GRANULARITY;
    private int kVj = 0;
    private boolean kVn = false;
    private boolean mxG = true;
    private boolean mxH = true;
    private boolean mxI = false;
    private boolean mxJ = false;
    private String mab = null;
    private int currentState = -1;
    private boolean mxL = false;
    private boolean mxS = false;
    private boolean mxT = false;
    private CyberPlayerManager.OnPreparedListener eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kUH != null && c.this.gxn != null && c.this.gxn.getDuration() > 0) {
                c.this.kUH.bz(0, c.this.gxn.getDuration());
            }
            c.this.cqQ();
            if (c.this.mxw != null) {
                c.this.mxw.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rC();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a irf = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.cqQ();
        }
    };
    private Runnable abT = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abT);
            if (c.this.amC.getVisibility() != 8) {
                if (c.this.gxn.getCurrentPosition() > c.this.abO) {
                    c.this.rC();
                } else {
                    com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abT, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gxn != null) {
                int duration = c.this.gxn.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.abN = false;
                    c.this.mxO = false;
                    c.this.mStartPosition = 0;
                    c.this.dai();
                    c.this.kUI.setVisibility(0);
                    c.this.mxh.setProgress(c.this.mxh.getMax());
                    c.this.abO = 100;
                    if (c.this.mxo != null) {
                        c.this.mxo.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.wR(false);
                        c.this.wS(true);
                    } else {
                        c.this.dxD();
                        c.this.mxk.setVisibility(0);
                    }
                    if (!c.this.abY && duration <= 150000) {
                        if (!c.this.mxL) {
                            if (c.this.mxy != null) {
                                c.this.mxy.vU(true);
                            }
                            c.this.E(c.this.mVideoUrl, c.this.amM, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gxn.pause();
                            c.this.gxn.seekTo(0);
                        }
                    }
                    if (c.this.mxw != null) {
                        c.this.mxw.GU(c.this.mxh.getMax());
                        c.this.mxw.Fw();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.itU.setVisibility(0);
            c.this.fRL.dxU();
            c.this.currentState = 4;
            if (c.this.mxp != null) {
                c.this.mxp.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mxM = true;
            }
            if (c.this.mxw != null) {
                c.this.mxw.dxI();
            }
            c.this.mxO = false;
            return true;
        }
    };
    protected Runnable kVq = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gxn == null || !c.this.gxn.isPlaying()) {
                c.this.itU.setVisibility(0);
                c.this.fRL.dxU();
                if (c.this.mxw != null) {
                    c.this.mxw.dxI();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eyy = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mxI) {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.mxU, 200L);
            }
        }
    };
    private Runnable mxU = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gxn == null || !c.this.mxI) {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abT, 200L);
                c.this.mxI = false;
            } else if (c.this.mStartPosition != c.this.gxn.getCurrentPosition()) {
                c.this.mxI = false;
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abT, 20L);
            } else {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.mxU, 200L);
            }
        }
    };
    private TbCyberVideoView.a fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abN = false;
            if (c.this.mxr) {
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.mxV, 300L);
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abT);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.kVq);
        }
    };
    private Runnable mxV = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mxO = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.maq != null) {
                c.this.maq.dru();
            }
            if (view.getId() != c.this.itU.getId()) {
                if (view.getId() != c.this.mxj.getId()) {
                    if (view.getId() == c.this.mxl.getId()) {
                        if (c.this.mxx != null) {
                            c.this.mxx.drv();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mxk.getId()) {
                        if (c.this.mxy != null) {
                            c.this.mxy.vU(false);
                        }
                        c.this.fX(c.this.mVideoUrl, c.this.amM);
                        return;
                    } else if (view.getId() == c.this.kUN.getId()) {
                        int i2 = c.this.mxr ? 1 : 2;
                        if (c.this.abY) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dW("tid", c.this.amM).dW("fid", c.this.fKR).an("obj_type", i2).an("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dW("tid", c.this.amM).dW("fid", c.this.fKR).an("obj_type", i2).an("obj_source", 1));
                        }
                        if (c.this.mxD != null) {
                            c.this.mxD.cEd();
                        }
                        if (c.this.dxo()) {
                            if (c.this.abY) {
                                c.this.dxr();
                            } else {
                                c.this.dxq();
                            }
                            c.this.wO(c.this.abY);
                            return;
                        }
                        c.this.Ss();
                        return;
                    } else if (view.getId() != c.this.hdt.getId()) {
                        if (c.this.mxs != null) {
                            c.this.mxs.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.mxD != null) {
                            c.this.mxD.cEd();
                        }
                        if (c.this.dxo()) {
                            c.this.dxr();
                            c.this.wO(false);
                            return;
                        }
                        c.this.Ss();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.drn();
                c.this.dxF();
                if (c.this.currentState != 1) {
                    c.this.dxB();
                    c.this.dxC();
                } else {
                    c.this.day();
                }
                if (c.this.mxB != null) {
                    c.this.mxB.ry(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gxn.stopPlayback();
            c.this.abN = false;
            c.this.dxw();
        }
    };
    private Animation.AnimationListener kVs = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kVt = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kVu = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.dav();
        }
    };
    private CustomMessageListener kVv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aQJ();
            }
        }
    };
    private VideoControllerView.b kXo = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void sW(int i2) {
            int duration;
            if (c.this.gxn != null && (duration = c.this.gxn.getDuration()) > 0 && c.this.mxh != null) {
                c.this.mxh.setProgress((int) ((i2 * c.this.bRa.getWidth()) / duration));
                if (c.this.mxw != null) {
                    c.this.mxw.GU((c.this.gxn.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gft = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.dxB();
            c.this.wS(false);
            if (c.this.mxB != null) {
                c.this.mxB.ry(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.dam() != null) {
                c.this.DK(c.this.dam().getSeekPosition());
                if (!c.this.dau()) {
                    c.this.dxw();
                } else {
                    c.this.aQK();
                    if (c.this.maD != null) {
                        c.this.maD.cEf();
                    }
                }
            }
            c.this.wS(true);
            c.this.dxA();
            if (c.this.mxB != null) {
                c.this.mxB.ry(true);
            }
            if (c.this.mxC != null) {
                c.this.mxC.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ry(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0845c {
        void rl();

        void rm();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cEe();

        void qO(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void wW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void qN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void drv();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cEf();
    }

    /* loaded from: classes.dex */
    public interface j {
        void vU(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cEc();

        void cEd();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean drw();

        boolean drx();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Fw();

        void GU(int i);

        void dxI();

        void dxJ();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dru();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mxQ = true;
        if (tbPageContext != null) {
            this.eSJ = tbPageContext;
            this.mRootView = view;
            this.mxQ = z;
            this.kUQ = view;
            this.mActivity = this.eSJ.getPageActivity();
            init();
        }
    }

    public void init() {
        this.bRa = az(this.mActivity);
        this.bRa.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.bRa);
        }
        this.gxn = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.bRa).addView(this.gxn.getView(), 0);
        this.gxn.getView().setLayoutParams(layoutParams);
        this.fRL = new com.baidu.tieba.play.m((ViewGroup) this.bRa.findViewById(R.id.auto_video_loading_container));
        this.fRL.setLoadingAnimationListener(this.irf);
        this.kUH = (VideoListMediaControllerView) this.bRa.findViewById(R.id.media_controller);
        this.kUH.setPlayer(this.gxn);
        this.mxh = (ProgressBar) this.bRa.findViewById(R.id.pgrBottomProgress);
        this.mxh.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mxh.setProgress(0);
        this.kUH.setOnSeekBarChangeListener(this.gft);
        this.kUH.setOnProgressUpdatedListener(this.kXo);
        this.kUI = this.bRa.findViewById(R.id.black_mask);
        this.itU = this.bRa.findViewById(R.id.layout_error);
        this.itU.setOnClickListener(this.mOnClickListener);
        this.mxK = (TextView) this.bRa.findViewById(R.id.auto_video_error_tips);
        this.kUJ = (FrameLayout) this.bRa.findViewById(R.id.danmu_container);
        this.kUN = (ImageView) this.bRa.findViewById(R.id.img_full_screen);
        this.kUN.setOnClickListener(this.mOnClickListener);
        this.kUO = this.bRa.findViewById(R.id.layout_media_controller);
        this.mxi = this.bRa.findViewById(R.id.time_show_controller);
        this.gxn.setContinuePlayEnable(true);
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnCompletionListener(this.eyv);
        this.gxn.setOnErrorListener(this.kVp);
        this.gxn.setOnSeekCompleteListener(this.eyy);
        this.gxn.setOnInfoListener(this.eyw);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        this.mxj = (SwitchImageView) this.bRa.findViewById(R.id.img_play_controller);
        this.mxj.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mxj.setState(0);
        this.mxj.setOnClickListener(this.mOnClickListener);
        this.mxk = (TextView) this.bRa.findViewById(R.id.txt_replay);
        this.mxk.setOnClickListener(this.mOnClickListener);
        this.mxl = (TextView) this.bRa.findViewById(R.id.txt_playnext);
        this.mxl.setOnClickListener(this.mOnClickListener);
        this.mxm = (TextView) this.bRa.findViewById(R.id.txt_next_video_title);
        this.amC = (TbImageView) this.bRa.findViewById(R.id.video_thumbnail);
        this.amC.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hdt = (ImageView) this.bRa.findViewById(R.id.img_exit);
        this.hdt.setOnClickListener(this.mOnClickListener);
        this.kUU = (TextView) this.bRa.findViewById(R.id.video_title);
        this.bIB = this.bRa.findViewById(R.id.layout_title);
        this.bIB.setVisibility(8);
        this.jhQ = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.cdO = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.kVe = this.mAudioManager.getStreamMaxVolume(3);
        this.kVk = this.mAudioManager.getStreamVolume(3);
        kVl = 100 / this.kVe;
        this.bRa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mxz != null) {
                    c.this.mxz.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abN) {
                        if (c.this.mStatus == 1 && c.this.kVg != 0) {
                            c.this.c(c.this.kVg == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kVg = 0;
                            c.this.kVf = 0;
                        }
                        if (!c.this.gxn.isPlaying()) {
                            c.this.mxl.setVisibility(8);
                            c.this.mxk.setVisibility(8);
                            c.this.mxm.setVisibility(8);
                        }
                    }
                    c.this.dai();
                    if (c.this.mxz != null) {
                        c.this.mxz.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kVi = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mxQ) {
            this.kVi.start();
        }
        this.kVj = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kVm == null) {
            kVm = new CallStateReceiver();
        }
        kVm.register(this.mActivity);
        dxn();
        MessageManager.getInstance().registerListener(this.kVv);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kVv);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void GQ(int i2) {
        if (this.amC != null) {
            this.amC.setDefaultBgResource(i2);
        }
    }

    public void dxn() {
        if (this.mxG) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.bRa.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.bRa.setSystemUiVisibility(0);
    }

    public void wM(boolean z) {
        this.mxG = z;
        dxn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dai() {
        this.mStatus = 0;
        if (this.kUY != null && this.kUY.getParent() != null && (this.kUY.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kUY.getParent()).removeView(this.kUY);
                this.kUY = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kUZ != null && this.kUZ.getParent() != null && (this.kUZ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kUZ.getParent()).removeView(this.kUZ);
                this.kUZ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void daj() {
        if (this.mStatus == 1) {
            if (this.kUY == null && this.bRa != null && (this.bRa instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.bRa, true);
                this.kUY = this.bRa.findViewById(R.id.lay_jindu);
                this.kVa = (TextView) this.kUY.findViewById(R.id.show_time);
                this.kVd = (ImageView) this.kUY.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kUZ == null && this.bRa != null && (this.bRa instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.bRa, true);
            this.kUZ = this.bRa.findViewById(R.id.lay_voice);
            this.kVc = (ImageView) this.kUZ.findViewById(R.id.arrow_voice_icon);
            this.kVb = (SeekBar) this.kUZ.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ad(View.OnClickListener onClickListener) {
        this.mxs = onClickListener;
    }

    public void wN(boolean z) {
        this.mxr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mxz != null) {
                c.this.mxz.onStart();
            }
            if (c.this.abY && c.this.abN) {
                if (c.this.mStatus == 1) {
                    c.this.dxD();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aO(f2);
                    }
                } else {
                    if (c.this.abY) {
                        c.this.dal();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kVf = c.this.gxn.getCurrentPosition();
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
            if (!c.this.mxR) {
                if (c.this.mxA != null && c.this.mxA.drw()) {
                    return true;
                }
                c.this.drn();
                c.this.dxF();
                if (c.this.gxn.isPlaying()) {
                    c.this.dxA();
                } else {
                    c.this.dxB();
                }
                if (c.this.mxB != null) {
                    c.this.mxB.ry(c.this.gxn.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mxR) {
                if (c.this.abN) {
                    if (c.this.mxA != null && c.this.mxA.drx()) {
                        return true;
                    }
                    c.this.dxz();
                    if (c.this.gxn.isPlaying()) {
                        c.this.dxA();
                    } else {
                        c.this.dxB();
                    }
                    if (c.this.mxB != null) {
                        c.this.mxB.ry(c.this.gxn.isPlaying());
                    }
                } else {
                    c.this.drn();
                    c.this.dxF();
                    if (c.this.currentState != 1) {
                        c.this.dxB();
                        c.this.dxC();
                    } else {
                        c.this.day();
                    }
                    if (c.this.mxB != null) {
                        c.this.mxB.ry(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dal() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bRa.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bRa.setSystemUiVisibility(4);
        } else {
            this.bRa.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f2) {
        if (!this.abN) {
            this.mStatus = 0;
            return;
        }
        if (kVl == 0) {
            this.kVe = this.mAudioManager.getStreamMaxVolume(3);
            kVl = 100 / this.kVe;
            if (kVl == 0) {
                kVl = 1;
            }
        }
        daj();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kVl == 0) {
            if (f2 > 0.0f && this.kVk < this.kVe) {
                this.kVk++;
            }
            if (f2 < 0.0f && this.kVk > 0) {
                this.kVk--;
            }
        }
        if (this.mProgress > 0) {
            this.kVc.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kVc.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kVk, 0);
        this.kVb.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kVf -= 1000;
                this.kVg = 1;
            } else {
                this.kVf += 1000;
                this.kVg = 2;
            }
            if (this.kVf < 0) {
                this.kVf = 0;
            } else if (this.kVf > this.gxn.getDuration()) {
                this.kVf = this.gxn.getDuration();
            }
        }
        daj();
        String GY = this.kUH.GY(this.kVf);
        if (f2 > 0.0f) {
            this.kVd.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kVd.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(GY)) {
            this.kVa.setText(new StringBuilder().append(GY).append("/").append(this.kUH.GY(this.gxn.getDuration())));
        }
        this.kUH.setCurrentDuration(this.kVf, z ? false : true);
        dxD();
        dxs();
    }

    protected View az(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void GR(int i2) {
        this.mxn = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amM = str2;
    }

    public void setFid(String str) {
        this.fKR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        int i2 = 100;
        if (this.gxn != null && this.kUH != null) {
            this.kUH.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dxY().PM(this.mVideoUrl);
            if (this.mxO) {
                this.gxn.setVolume(1.0f, 1.0f);
                this.gxn.start();
                this.mxO = false;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abT);
                com.baidu.adp.lib.f.e.mB().postDelayed(this.abT, 20L);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mxV);
                if (this.gxn.dyf()) {
                    this.currentState = 1;
                    dxD();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dxY().PM(this.mVideoUrl);
                this.kUH.setPlayer(this.gxn);
                if (this.mStartPosition != 0) {
                    this.mxI = true;
                }
                if (!this.mxN) {
                    this.kUH.showProgress();
                }
                if (!this.mxr && this.gxn.getDuration() <= 0) {
                    dam().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gxn.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abO = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        if (this.amC.getVisibility() != 8 || !this.abN) {
            this.abN = true;
            this.kUI.setVisibility(8);
            this.itU.setVisibility(8);
            this.fRL.dxT();
            this.amC.setVisibility(8);
            dxE();
            this.kUH.showProgress();
            this.mxh.setVisibility(0);
            if (this.kUS != null) {
                this.kUS.onPrepared();
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

    protected void wO(boolean z) {
        if (hasNavBar(this.mActivity) && (this.mxi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mxi.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mxi.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mxi.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mxi.setLayoutParams(layoutParams);
        }
    }

    public void drn() {
        if (this.gxn.isPlaying()) {
            aQJ();
            if (this.mxF != null) {
                this.mxF.onPause();
            }
            if (this.mxw != null) {
                this.mxw.onPaused();
            }
        } else if (this.abN) {
            aQK();
            if (this.maD != null) {
                this.maD.cEf();
            }
            if (this.mxw != null) {
                this.mxw.dxJ();
            }
        } else {
            dxw();
        }
    }

    public void Ss() {
        this.kVn = true;
        if (this.kVi != null) {
            this.kVi.Ss();
        }
    }

    public boolean dxo() {
        return this.gxn != null && this.gxn.getView().getHeight() > this.gxn.getView().getWidth();
    }

    public void dxp() {
        wO(false);
        dxr();
    }

    public boolean GS(int i2) {
        switch (i2) {
            case 4:
                if (this.abY) {
                    if (dxo()) {
                        wO(false);
                        dxr();
                    } else {
                        Ss();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kVe <= 0 || this.kVb == null) {
                    return false;
                }
                this.kVk = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kVk * 100.0d) / this.kVe);
                this.kVb.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gxn;
    }

    public VideoListMediaControllerView dam() {
        return this.kUH;
    }

    public void show() {
        this.bRa.setVisibility(0);
    }

    public void daq() {
        if (this.kUQ != null) {
            ViewGroup.LayoutParams layoutParams = this.kUQ.getLayoutParams();
            this.kUK = (FrameLayout.LayoutParams) this.bRa.getLayoutParams();
            this.kUK.width = layoutParams.width;
            this.kUK.height = layoutParams.height;
            this.kUK.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.bRa.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.bRa.setLayoutParams(this.kUK);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kVn) {
            if (this.abY) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.kVn = false;
        }
        if (configuration.orientation == 2) {
            dxq();
        } else {
            dxr();
        }
        dxs();
        if (this.mActivity == com.baidu.adp.base.b.kC().currentActivity()) {
            aQK();
        }
        dxF();
        day();
        if (this.mxB != null) {
            this.mxB.ry(true);
        }
    }

    protected void dxq() {
        this.abY = true;
        this.bRa.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.f.bES().fy(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.f.bES().fz(this.mActivity))));
        j(this.mActivity, true);
        this.bIB.setVisibility(0);
        this.hdt.setVisibility(0);
        this.kUU.setVisibility(0);
        this.kUJ.setVisibility(8);
        this.fRL.dxU();
        this.amC.setVisibility(8);
        this.kUN.setImageResource(R.drawable.icon_video_narrow_white);
        DH(this.kVj);
        dal();
        if (this.mxt != null) {
            this.mxt.rl();
        }
    }

    protected void dxr() {
        this.abY = false;
        if (this.kUK != null) {
            this.bRa.setLayoutParams(this.kUK);
        }
        j(this.mActivity, false);
        this.bIB.setVisibility(8);
        this.kUJ.setVisibility(0);
        this.fRL.dxU();
        this.amC.setVisibility(8);
        this.kUN.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kUH != null && (this.kUH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUH.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kUH.setLayoutParams(layoutParams);
        }
        this.bRa.setSystemUiVisibility(0);
        dxn();
        if (this.mxt != null) {
            this.mxt.rm();
        }
    }

    public void dxs() {
        if (this.gxn != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.abY) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mxh.setMax(equipmentWidth);
            int duration = this.gxn.getDuration();
            if (duration > 0) {
                if (this.mxk.getVisibility() == 0) {
                    this.mxh.setProgress(this.mxh.getMax());
                } else {
                    this.mxh.setProgress((int) ((this.gxn.getCurrentPositionSync() * this.mxh.getMax()) / duration));
                }
            }
        }
    }

    private void DH(int i2) {
        if (this.kUH != null && (this.kUH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUH.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kUH.setLayoutParams(layoutParams);
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

    public boolean das() {
        return !this.abY;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kUS = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mxo = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mxp = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mxJ) {
            fY(str, str2);
        } else {
            fX(str, str2);
        }
        if (eVar != null) {
            eVar.wW(z);
        }
    }

    public void fW(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2, boolean z) {
        dxx();
        this.mxO = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gxn.setVideoDuration(this.mxn);
        this.gxn.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        if (this.mxv > 0) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kVq, this.mxv);
        }
        if (this.mxw != null) {
            this.mxw.onStarted();
        }
        this.fRL.startLoading();
        wP(z);
    }

    public void fX(String str, String str2) {
        E(str, str2, true);
    }

    public void fY(String str, String str2) {
        dxx();
        this.mxO = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        if (this.mxv > 0) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kVq, this.mxv);
        }
        if (this.mxw != null) {
            this.mxw.onStarted();
        }
        this.fRL.startLoading();
        wP(true);
    }

    public void dxt() {
        aQK();
        this.mxh.setVisibility(0);
    }

    public void aQK() {
        int i2 = 100;
        if (this.gxn != null && this.kUH != null) {
            this.abN = true;
            this.currentState = 1;
            this.gxn.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dxY().PM(this.mVideoUrl);
            this.mxI = true;
            if (this.mStartPosition > 100 && this.gxn.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abO = i2;
            this.fRL.dxU();
            wP(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mxM && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amM)) {
            this.mxM = false;
            this.mxN = true;
            fX(this.mVideoUrl, this.amM);
        }
    }

    private void wP(boolean z) {
        if (z) {
            this.amC.setVisibility(0);
            dxD();
            this.mxh.setProgress(0);
        } else {
            this.amC.setVisibility(8);
            dxD();
        }
        this.kUH.showProgress();
        this.kUI.setVisibility(8);
        this.mxl.setVisibility(8);
        this.mxk.setVisibility(8);
        this.mxm.setVisibility(8);
        this.itU.setVisibility(8);
    }

    private void dxu() {
        this.fRL.dxU();
        this.mxl.setVisibility(8);
        this.mxk.setVisibility(8);
        this.mxm.setVisibility(8);
        dxF();
    }

    public void aQJ() {
        this.gxn.pause();
        this.currentState = 2;
        dxu();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abT);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mxV);
        this.gxn.stopPlayback();
        this.abN = false;
        this.mxO = false;
        this.mStartPosition = 0;
        cQE();
    }

    public void dxv() {
        if (this.gxn.getDuration() >= this.gxn.getCurrentPosition()) {
            com.baidu.tieba.play.n.dxY().bL(this.mVideoUrl, this.gxn.getCurrentPositionSync());
        }
    }

    public void wQ(boolean z) {
        this.mxH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR(boolean z) {
        if (this.kUO != null) {
            this.kUI.setVisibility(0);
            this.mxl.setVisibility(8);
            this.mxk.setVisibility(8);
            this.mxm.setVisibility(8);
            this.fRL.dxU();
            dxD();
            this.mxh.setVisibility(8);
            this.itU.setVisibility(8);
            this.kUH.aQY();
            this.amC.setVisibility(z ? 0 : 8);
        }
    }

    public void cQE() {
        wR(true);
    }

    public boolean rn() {
        if (this.gxn == null) {
            return false;
        }
        return this.gxn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gxn == null) {
            return 0;
        }
        return this.gxn.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mxz = kVar;
    }

    public void a(j jVar) {
        this.mxy = jVar;
    }

    public void a(i iVar) {
        this.maD = iVar;
    }

    public void a(g gVar) {
        this.mxF = gVar;
    }

    public void a(h hVar) {
        this.mxx = hVar;
    }

    public void Pm(String str) {
        this.mab = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxw() {
        a(this.mVideoUrl, this.amM, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mxu = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dxx();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.f.dPM().dPN()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mxJ = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mxE != null) {
                    this.mxE.qN(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Ad(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dxy();
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
                aVar.b(this.eSJ).bqe();
                return;
            } else if (this.mxE != null) {
                this.mxE.qN(true);
                return;
            } else {
                if (!this.mxg) {
                    this.mxg = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mxD != null) {
            this.mxD.cEc();
        }
    }

    private void dxx() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.f.dPM().gW(this.mActivity);
        }
    }

    public void dxy() {
        com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.amC.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abT);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mxU);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mxV);
        this.kVi.stop();
        kVm.unregister(this.mActivity);
    }

    public void PL(String str) {
        this.kUU.setText(str);
    }

    public boolean dau() {
        return this.abN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxz() {
        if (this.kUO != null) {
            if (this.mxq) {
                dxD();
            } else {
                dxC();
            }
        }
    }

    public void day() {
        dxC();
        dxA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxA() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.kVu, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxB() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
    }

    public void dxC() {
        if (this.kUO != null && !this.mxq && !this.mxS) {
            wS(true);
            dax();
            this.kUO.setVisibility(0);
            this.mxi.setVisibility(0);
            this.mxh.setVisibility(8);
            this.mxq = true;
            if (this.mxu != null) {
                this.mxu.qO(false);
            }
        }
    }

    public void dav() {
        if (this.kUO != null && this.mxq) {
            wS(false);
            dax();
            this.kUO.setVisibility(8);
            this.mxi.setVisibility(8);
            this.mxh.setVisibility(0);
            this.jhQ.setAnimationListener(this.kVs);
            this.kUO.startAnimation(this.jhQ);
            this.mxq = false;
            if (this.mxu != null) {
                this.mxu.cEe();
            }
        }
    }

    public void dxD() {
        if (this.kUO != null && this.mxq) {
            this.cdO.cancel();
            this.jhQ.cancel();
            wS(false);
            dax();
            this.kUO.setVisibility(8);
            this.mxi.setVisibility(8);
            this.mxh.setVisibility(0);
            this.mxq = false;
            if (this.mxu != null) {
                this.mxu.cEe();
            }
        }
    }

    private void dax() {
        if (this.kUO != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
            this.cdO.setAnimationListener(null);
            this.jhQ.setAnimationListener(null);
            this.kUO.clearAnimation();
        }
    }

    private void dxE() {
        if (this.kUO != null) {
            this.cdO.setAnimationListener(null);
            this.jhQ.setAnimationListener(null);
            this.kUO.clearAnimation();
        }
    }

    public void wS(boolean z) {
        dxF();
        if (z) {
            this.mxj.setVisibility(0);
        } else {
            this.mxj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxF() {
        if (this.currentState == 1) {
            this.mxj.setState(1);
        } else {
            this.mxj.setState(0);
        }
    }

    public void a(InterfaceC0845c interfaceC0845c) {
        this.mxt = interfaceC0845c;
    }

    public void DK(int i2) {
        this.mStartPosition = i2;
    }

    public void ax(boolean z, boolean z2) {
        if (this.kVi != null) {
            if (this.kUN != null) {
                this.kUN.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kUH != null && (this.kUH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUH.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kUH.setLayoutParams(layoutParams);
            }
            this.kVi.cZ(z);
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

    public void wT(boolean z) {
        this.mxR = z;
    }

    public void a(m mVar) {
        this.mxA = mVar;
    }

    public void a(a aVar) {
        this.mxB = aVar;
    }

    public void a(n nVar) {
        this.mxC = nVar;
    }

    public void a(l lVar) {
        this.mxD = lVar;
    }

    public void a(f fVar) {
        this.mxE = fVar;
    }

    public void wU(boolean z) {
        this.mxL = z;
    }

    public void wV(boolean z) {
        this.mxr = z;
    }

    public void GT(int i2) {
        this.mxP = i2;
    }

    public View dxG() {
        return this.bRa;
    }

    public void a(p pVar) {
        this.maq = pVar;
    }

    public void dxH() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eSJ.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eSJ.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gxn != null) {
            this.gxn.setStageType(str);
        }
    }
}
