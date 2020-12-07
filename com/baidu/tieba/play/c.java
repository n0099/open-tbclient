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
import com.baidu.tbadk.core.util.ar;
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
    private static int kUl;
    private static CallStateReceiver kUm;
    private TbImageView amP;
    private String amY;
    private View bIy;
    private Animation cbQ;
    private TbPageContext<?> eNx;
    private String fFV;
    private com.baidu.tieba.play.m fMO;
    private ImageView gWk;
    protected TbCyberVideoView gqT;
    protected View ime;
    private Animation jaj;
    public View kTF;
    private VideoListMediaControllerView kTH;
    private View kTI;
    private FrameLayout kTJ;
    protected FrameLayout.LayoutParams kTK;
    private ImageView kTN;
    private View kTO;
    private View kTQ;
    private CyberPlayerManager.OnPreparedListener kTS;
    private TextView kTU;
    private View kTY;
    private View kTZ;
    private TextView kUa;
    private SeekBar kUb;
    private ImageView kUc;
    private ImageView kUd;
    private int kUe;
    private com.baidu.tieba.play.j kUi;
    private int kUk;
    private p lZG;
    private i lZS;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private TextView mwA;
    private TextView mwB;
    private TextView mwC;
    private int mwD;
    private CyberPlayerManager.OnCompletionListener mwE;
    private CyberPlayerManager.OnErrorListener mwF;
    private View.OnClickListener mwI;
    protected InterfaceC0845c mwJ;
    private d mwK;
    private o mwM;
    private h mwN;
    private j mwO;
    private k mwP;
    private m mwQ;
    private a mwR;
    private n mwS;
    private l mwT;
    private f mwU;
    private g mwV;
    private ProgressBar mwx;
    private View mwy;
    private SwitchImageView mwz;
    private TextView mxa;
    private boolean mxc;
    private boolean mxd;
    private boolean mxe;
    private int mxf;
    private boolean mxg;
    private boolean mxh;
    private int abg = 100;
    private boolean mww = false;
    protected boolean abq = false;
    private boolean abf = false;
    private boolean mwG = false;
    private boolean mwH = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kUf = 0;
    private int kUg = 0;
    private long mwL = 60000;
    private int kUj = 0;
    private boolean kUn = false;
    private boolean mwW = true;
    private boolean mwX = true;
    private boolean mwY = false;
    private boolean mwZ = false;
    private String lZs = null;
    private int currentState = -1;
    private boolean mxb = false;
    private boolean mxi = false;
    private boolean mxj = false;
    private CyberPlayerManager.OnPreparedListener ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kTH != null && c.this.gqT != null && c.this.gqT.getDuration() > 0) {
                c.this.kTH.bB(0, c.this.gqT.getDuration());
            }
            c.this.crN();
            if (c.this.mwM != null) {
                c.this.mwM.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.sb();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a ijp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.crN();
        }
    };
    private Runnable abl = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.abl);
            if (c.this.amP.getVisibility() != 8) {
                if (c.this.gqT.getCurrentPosition() > c.this.abg) {
                    c.this.sb();
                } else {
                    com.baidu.adp.lib.f.e.mY().postDelayed(c.this.abl, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gqT != null) {
                int duration = c.this.gqT.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.abf = false;
                    c.this.mxe = false;
                    c.this.mStartPosition = 0;
                    c.this.den();
                    c.this.kTI.setVisibility(0);
                    c.this.mwx.setProgress(c.this.mwx.getMax());
                    c.this.abg = 100;
                    if (c.this.mwE != null) {
                        c.this.mwE.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.wU(false);
                        c.this.wV(true);
                    } else {
                        c.this.dBE();
                        c.this.mwA.setVisibility(0);
                    }
                    if (!c.this.abq && duration <= 150000) {
                        if (!c.this.mxb) {
                            if (c.this.mwO != null) {
                                c.this.mwO.vX(true);
                            }
                            c.this.C(c.this.mVideoUrl, c.this.amY, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gqT.pause();
                            c.this.gqT.seekTo(0);
                        }
                    }
                    if (c.this.mwM != null) {
                        c.this.mwM.IH(c.this.mwx.getMax());
                        c.this.mwM.JP();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kUp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.ime.setVisibility(0);
            c.this.fMO.dBV();
            c.this.currentState = 4;
            if (c.this.mwF != null) {
                c.this.mwF.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mxc = true;
            }
            if (c.this.mwM != null) {
                c.this.mwM.dBJ();
            }
            c.this.mxe = false;
            return true;
        }
    };
    protected Runnable kUq = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gqT == null || !c.this.gqT.isPlaying()) {
                c.this.ime.setVisibility(0);
                c.this.fMO.dBV();
                if (c.this.mwM != null) {
                    c.this.mwM.dBJ();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mwY) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mxk, 200L);
            }
        }
    };
    private Runnable mxk = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gqT == null || !c.this.mwY) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.abl, 200L);
                c.this.mwY = false;
            } else if (c.this.mStartPosition != c.this.gqT.getCurrentPosition()) {
                c.this.mwY = false;
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.abl, 20L);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mxk, 200L);
            }
        }
    };
    private TbCyberVideoView.a fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abf = false;
            if (c.this.mwH) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mxl, 300L);
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.abl);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.kUq);
        }
    };
    private Runnable mxl = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mxe = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.lZG != null) {
                c.this.lZG.dvv();
            }
            if (view.getId() != c.this.ime.getId()) {
                if (view.getId() != c.this.mwz.getId()) {
                    if (view.getId() == c.this.mwB.getId()) {
                        if (c.this.mwN != null) {
                            c.this.mwN.dvw();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mwA.getId()) {
                        if (c.this.mwO != null) {
                            c.this.mwO.vX(false);
                        }
                        c.this.gb(c.this.mVideoUrl, c.this.amY);
                        return;
                    } else if (view.getId() == c.this.kTN.getId()) {
                        int i2 = c.this.mwH ? 1 : 2;
                        if (c.this.abq) {
                            TiebaStatic.log(new ar("c11714"));
                            TiebaStatic.log(new ar("c13262").dY("tid", c.this.amY).dY("fid", c.this.fFV).al("obj_type", i2).al("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ar("c11710"));
                            TiebaStatic.log(new ar("c13262").dY("tid", c.this.amY).dY("fid", c.this.fFV).al("obj_type", i2).al("obj_source", 1));
                        }
                        if (c.this.mwT != null) {
                            c.this.mwT.cEZ();
                        }
                        if (c.this.dBp()) {
                            if (c.this.abq) {
                                c.this.dBs();
                            } else {
                                c.this.dBr();
                            }
                            c.this.wR(c.this.abq);
                            return;
                        }
                        c.this.Vh();
                        return;
                    } else if (view.getId() != c.this.gWk.getId()) {
                        if (c.this.mwI != null) {
                            c.this.mwI.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ar("c11713"));
                        if (c.this.mwT != null) {
                            c.this.mwT.cEZ();
                        }
                        if (c.this.dBp()) {
                            c.this.dBs();
                            c.this.wR(false);
                            return;
                        }
                        c.this.Vh();
                        return;
                    }
                }
                TiebaStatic.log(new ar("c13255"));
                c.this.dvo();
                c.this.dBG();
                if (c.this.currentState != 1) {
                    c.this.dBC();
                    c.this.dBD();
                } else {
                    c.this.deD();
                }
                if (c.this.mwR != null) {
                    c.this.mwR.rd(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gqT.stopPlayback();
            c.this.abf = false;
            c.this.dBx();
        }
    };
    private Animation.AnimationListener kUs = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kUt = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kUu = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.deA();
        }
    };
    private CustomMessageListener kUv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aSi();
            }
        }
    };
    private VideoControllerView.b kWo = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void ur(int i2) {
            int duration;
            if (c.this.gqT != null && (duration = c.this.gqT.getDuration()) > 0 && c.this.mwx != null) {
                c.this.mwx.setProgress((int) ((i2 * c.this.kTF.getWidth()) / duration));
                if (c.this.mwM != null) {
                    c.this.mwM.IH((c.this.gqT.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gaI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ar("c13256"));
            c.this.dBC();
            c.this.wV(false);
            if (c.this.mwR != null) {
                c.this.mwR.rd(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.der() != null) {
                c.this.Fw(c.this.der().getSeekPosition());
                if (!c.this.dez()) {
                    c.this.dBx();
                } else {
                    c.this.aSj();
                    if (c.this.lZS != null) {
                        c.this.lZS.cFb();
                    }
                }
            }
            c.this.wV(true);
            c.this.dBB();
            if (c.this.mwR != null) {
                c.this.mwR.rd(true);
            }
            if (c.this.mwS != null) {
                c.this.mwS.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rd(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0845c {
        void rK();

        void rL();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cFa();

        void qu(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void wZ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void qt(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dvw();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cFb();
    }

    /* loaded from: classes.dex */
    public interface j {
        void vX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cEY();

        void cEZ();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dvx();

        boolean dvy();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void IH(int i);

        void JP();

        void dBJ();

        void dBK();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dvv();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mxg = true;
        if (tbPageContext != null) {
            this.eNx = tbPageContext;
            this.mRootView = view;
            this.mxg = z;
            this.kTQ = view;
            this.mActivity = this.eNx.getPageActivity();
            init();
        }
    }

    public void init() {
        this.kTF = aw(this.mActivity);
        this.kTF.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.kTF);
        }
        this.gqT = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.kTF).addView(this.gqT.getView(), 0);
        this.gqT.getView().setLayoutParams(layoutParams);
        this.fMO = new com.baidu.tieba.play.m((ViewGroup) this.kTF.findViewById(R.id.auto_video_loading_container));
        this.fMO.setLoadingAnimationListener(this.ijp);
        this.kTH = (VideoListMediaControllerView) this.kTF.findViewById(R.id.media_controller);
        this.kTH.setPlayer(this.gqT);
        this.mwx = (ProgressBar) this.kTF.findViewById(R.id.pgrBottomProgress);
        this.mwx.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mwx.setProgress(0);
        this.kTH.setOnSeekBarChangeListener(this.gaI);
        this.kTH.setOnProgressUpdatedListener(this.kWo);
        this.kTI = this.kTF.findViewById(R.id.black_mask);
        this.ime = this.kTF.findViewById(R.id.layout_error);
        this.ime.setOnClickListener(this.mOnClickListener);
        this.mxa = (TextView) this.kTF.findViewById(R.id.auto_video_error_tips);
        this.kTJ = (FrameLayout) this.kTF.findViewById(R.id.danmu_container);
        this.kTN = (ImageView) this.kTF.findViewById(R.id.img_full_screen);
        this.kTN.setOnClickListener(this.mOnClickListener);
        this.kTO = this.kTF.findViewById(R.id.layout_media_controller);
        this.mwy = this.kTF.findViewById(R.id.time_show_controller);
        this.gqT.setContinuePlayEnable(true);
        this.gqT.setOnPreparedListener(this.ety);
        this.gqT.setOnCompletionListener(this.etA);
        this.gqT.setOnErrorListener(this.kUp);
        this.gqT.setOnSeekCompleteListener(this.etD);
        this.gqT.setOnInfoListener(this.etB);
        this.gqT.setOnSurfaceDestroyedListener(this.fMW);
        this.mwz = (SwitchImageView) this.kTF.findViewById(R.id.img_play_controller);
        this.mwz.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mwz.setState(0);
        this.mwz.setOnClickListener(this.mOnClickListener);
        this.mwA = (TextView) this.kTF.findViewById(R.id.txt_replay);
        this.mwA.setOnClickListener(this.mOnClickListener);
        this.mwB = (TextView) this.kTF.findViewById(R.id.txt_playnext);
        this.mwB.setOnClickListener(this.mOnClickListener);
        this.mwC = (TextView) this.kTF.findViewById(R.id.txt_next_video_title);
        this.amP = (TbImageView) this.kTF.findViewById(R.id.video_thumbnail);
        this.amP.setDefaultErrorResource(0);
        this.amP.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gWk = (ImageView) this.kTF.findViewById(R.id.img_exit);
        this.gWk.setOnClickListener(this.mOnClickListener);
        this.kTU = (TextView) this.kTF.findViewById(R.id.video_title);
        this.bIy = this.kTF.findViewById(R.id.layout_title);
        this.bIy.setVisibility(8);
        this.jaj = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.cbQ = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.kUe = this.mAudioManager.getStreamMaxVolume(3);
        this.kUk = this.mAudioManager.getStreamVolume(3);
        kUl = 100 / this.kUe;
        this.kTF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mwP != null) {
                    c.this.mwP.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abf) {
                        if (c.this.mStatus == 1 && c.this.kUg != 0) {
                            c.this.b(c.this.kUg == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kUg = 0;
                            c.this.kUf = 0;
                        }
                        if (!c.this.gqT.isPlaying()) {
                            c.this.mwB.setVisibility(8);
                            c.this.mwA.setVisibility(8);
                            c.this.mwC.setVisibility(8);
                        }
                    }
                    c.this.den();
                    if (c.this.mwP != null) {
                        c.this.mwP.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kUi = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mxg) {
            this.kUi.start();
        }
        this.kUj = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kUm == null) {
            kUm = new CallStateReceiver();
        }
        kUm.register(this.mActivity);
        dBo();
        MessageManager.getInstance().registerListener(this.kUv);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kUv);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void ID(int i2) {
        if (this.amP != null) {
            this.amP.setDefaultBgResource(i2);
        }
    }

    public void dBo() {
        if (this.mwW) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.kTF.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.kTF.setSystemUiVisibility(0);
    }

    public void wP(boolean z) {
        this.mwW = z;
        dBo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void den() {
        this.mStatus = 0;
        if (this.kTY != null && this.kTY.getParent() != null && (this.kTY.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kTY.getParent()).removeView(this.kTY);
                this.kTY = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kTZ != null && this.kTZ.getParent() != null && (this.kTZ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kTZ.getParent()).removeView(this.kTZ);
                this.kTZ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void deo() {
        if (this.mStatus == 1) {
            if (this.kTY == null && this.kTF != null && (this.kTF instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.kTF, true);
                this.kTY = this.kTF.findViewById(R.id.lay_jindu);
                this.kUa = (TextView) this.kTY.findViewById(R.id.show_time);
                this.kUd = (ImageView) this.kTY.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kTZ == null && this.kTF != null && (this.kTF instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.kTF, true);
            this.kTZ = this.kTF.findViewById(R.id.lay_voice);
            this.kUc = (ImageView) this.kTZ.findViewById(R.id.arrow_voice_icon);
            this.kUb = (SeekBar) this.kTZ.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mwI = onClickListener;
    }

    public void wQ(boolean z) {
        this.mwH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mwP != null) {
                c.this.mwP.onStart();
            }
            if (c.this.abq && c.this.abf) {
                if (c.this.mStatus == 1) {
                    c.this.dBE();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aM(f2);
                    }
                } else {
                    if (c.this.abq) {
                        c.this.deq();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kUf = c.this.gqT.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aM(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.mxh) {
                if (c.this.mwQ != null && c.this.mwQ.dvx()) {
                    return true;
                }
                c.this.dvo();
                c.this.dBG();
                if (c.this.gqT.isPlaying()) {
                    c.this.dBB();
                } else {
                    c.this.dBC();
                }
                if (c.this.mwR != null) {
                    c.this.mwR.rd(c.this.gqT.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mxh) {
                if (c.this.abf) {
                    if (c.this.mwQ != null && c.this.mwQ.dvy()) {
                        return true;
                    }
                    c.this.dBA();
                    if (c.this.gqT.isPlaying()) {
                        c.this.dBB();
                    } else {
                        c.this.dBC();
                    }
                    if (c.this.mwR != null) {
                        c.this.mwR.rd(c.this.gqT.isPlaying());
                    }
                } else {
                    c.this.dvo();
                    c.this.dBG();
                    if (c.this.currentState != 1) {
                        c.this.dBC();
                        c.this.dBD();
                    } else {
                        c.this.deD();
                    }
                    if (c.this.mwR != null) {
                        c.this.mwR.rd(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deq() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kTF.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kTF.setSystemUiVisibility(4);
        } else {
            this.kTF.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(float f2) {
        if (!this.abf) {
            this.mStatus = 0;
            return;
        }
        if (kUl == 0) {
            this.kUe = this.mAudioManager.getStreamMaxVolume(3);
            kUl = 100 / this.kUe;
            if (kUl == 0) {
                kUl = 1;
            }
        }
        deo();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kUl == 0) {
            if (f2 > 0.0f && this.kUk < this.kUe) {
                this.kUk++;
            }
            if (f2 < 0.0f && this.kUk > 0) {
                this.kUk--;
            }
        }
        if (this.mProgress > 0) {
            this.kUc.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kUc.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kUk, 0);
        this.kUb.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kUf -= 1000;
                this.kUg = 1;
            } else {
                this.kUf += 1000;
                this.kUg = 2;
            }
            if (this.kUf < 0) {
                this.kUf = 0;
            } else if (this.kUf > this.gqT.getDuration()) {
                this.kUf = this.gqT.getDuration();
            }
        }
        deo();
        String IL = this.kTH.IL(this.kUf);
        if (f2 > 0.0f) {
            this.kUd.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kUd.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(IL)) {
            this.kUa.setText(new StringBuilder().append(IL).append("/").append(this.kTH.IL(this.gqT.getDuration())));
        }
        this.kTH.setCurrentDuration(this.kUf, z ? false : true);
        dBE();
        dBt();
    }

    protected View aw(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void IE(int i2) {
        this.mwD = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amY = str2;
    }

    public void setFid(String str) {
        this.fFV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crN() {
        int i2 = 100;
        if (this.gqT != null && this.kTH != null) {
            this.kTH.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dBZ().Ro(this.mVideoUrl);
            if (this.mxe) {
                this.gqT.setVolume(1.0f, 1.0f);
                this.gqT.start();
                this.mxe = false;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abl);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.abl, 20L);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUq);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxl);
                if (this.gqT.dCg()) {
                    this.currentState = 1;
                    dBE();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dBZ().Ro(this.mVideoUrl);
                this.kTH.setPlayer(this.gqT);
                if (this.mStartPosition != 0) {
                    this.mwY = true;
                }
                if (!this.mxd) {
                    this.kTH.showProgress();
                }
                if (!this.mwH && this.gqT.getDuration() <= 0) {
                    der().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gqT.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abg = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        if (this.amP.getVisibility() != 8 || !this.abf) {
            this.abf = true;
            this.kTI.setVisibility(8);
            this.ime.setVisibility(8);
            this.fMO.dBU();
            this.amP.setVisibility(8);
            dBF();
            this.kTH.showProgress();
            this.mwx.setVisibility(0);
            if (this.kTS != null) {
                this.kTS.onPrepared();
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

    protected void wR(boolean z) {
        if (hasNavBar(this.mActivity) && (this.mwy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mwy.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mwy.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mwy.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mwy.setLayoutParams(layoutParams);
        }
    }

    public void dvo() {
        if (this.gqT.isPlaying()) {
            aSi();
            if (this.mwV != null) {
                this.mwV.onPause();
            }
            if (this.mwM != null) {
                this.mwM.onPaused();
            }
        } else if (this.abf) {
            aSj();
            if (this.lZS != null) {
                this.lZS.cFb();
            }
            if (this.mwM != null) {
                this.mwM.dBK();
            }
        } else {
            dBx();
        }
    }

    public void Vh() {
        this.kUn = true;
        if (this.kUi != null) {
            this.kUi.Vh();
        }
    }

    public boolean dBp() {
        return this.gqT != null && this.gqT.getView().getHeight() > this.gqT.getView().getWidth();
    }

    public void dBq() {
        wR(false);
        dBs();
    }

    public boolean IF(int i2) {
        switch (i2) {
            case 4:
                if (this.abq) {
                    if (dBp()) {
                        wR(false);
                        dBs();
                    } else {
                        Vh();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kUe <= 0 || this.kUb == null) {
                    return false;
                }
                this.kUk = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kUk * 100.0d) / this.kUe);
                this.kUb.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gqT;
    }

    public VideoListMediaControllerView der() {
        return this.kTH;
    }

    public void show() {
        this.kTF.setVisibility(0);
    }

    public void dev() {
        if (this.kTQ != null) {
            ViewGroup.LayoutParams layoutParams = this.kTQ.getLayoutParams();
            this.kTK = (FrameLayout.LayoutParams) this.kTF.getLayoutParams();
            this.kTK.width = layoutParams.width;
            this.kTK.height = layoutParams.height;
            this.kTK.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.kTF.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.kTF.setLayoutParams(this.kTK);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kUn) {
            if (this.abq) {
                TiebaStatic.log(new ar("c11712"));
            } else {
                TiebaStatic.log(new ar("c11711"));
            }
        } else {
            this.kUn = false;
        }
        if (configuration.orientation == 2) {
            dBr();
        } else {
            dBs();
        }
        dBt();
        if (this.mActivity == com.baidu.adp.base.a.lg().currentActivity()) {
            aSj();
        }
        dBG();
        deD();
        if (this.mwR != null) {
            this.mwR.rd(true);
        }
    }

    protected void dBr() {
        this.abq = true;
        this.kTF.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bGp().fe(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bGp().ff(this.mActivity))));
        j(this.mActivity, true);
        this.bIy.setVisibility(0);
        this.gWk.setVisibility(0);
        this.kTU.setVisibility(0);
        this.kTJ.setVisibility(8);
        this.fMO.dBV();
        this.amP.setVisibility(8);
        this.kTN.setImageResource(R.drawable.icon_video_narrow_white);
        Ft(this.kUj);
        deq();
        if (this.mwJ != null) {
            this.mwJ.rK();
        }
    }

    protected void dBs() {
        this.abq = false;
        if (this.kTK != null) {
            this.kTF.setLayoutParams(this.kTK);
        }
        j(this.mActivity, false);
        this.bIy.setVisibility(8);
        this.kTJ.setVisibility(0);
        this.fMO.dBV();
        this.amP.setVisibility(8);
        this.kTN.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kTH != null && (this.kTH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kTH.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kTH.setLayoutParams(layoutParams);
        }
        this.kTF.setSystemUiVisibility(0);
        dBo();
        if (this.mwJ != null) {
            this.mwJ.rL();
        }
    }

    public void dBt() {
        if (this.gqT != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.abq) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mwx.setMax(equipmentWidth);
            int duration = this.gqT.getDuration();
            if (duration > 0) {
                if (this.mwA.getVisibility() == 0) {
                    this.mwx.setProgress(this.mwx.getMax());
                } else {
                    this.mwx.setProgress((int) ((this.gqT.getCurrentPositionSync() * this.mwx.getMax()) / duration));
                }
            }
        }
    }

    private void Ft(int i2) {
        if (this.kTH != null && (this.kTH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kTH.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kTH.setLayoutParams(layoutParams);
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

    public boolean dex() {
        return !this.abq;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kTS = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mwE = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mwF = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mwZ) {
            gc(str, str2);
        } else {
            gb(str, str2);
        }
        if (eVar != null) {
            eVar.wZ(z);
        }
    }

    public void ga(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, String str2, boolean z) {
        dBy();
        this.mxe = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gqT.setVideoDuration(this.mwD);
        this.gqT.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUq);
        if (this.mwL > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kUq, this.mwL);
        }
        if (this.mwM != null) {
            this.mwM.onStarted();
        }
        this.fMO.startLoading();
        wS(z);
    }

    public void gb(String str, String str2) {
        C(str, str2, true);
    }

    public void gc(String str, String str2) {
        dBy();
        this.mxe = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUq);
        if (this.mwL > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kUq, this.mwL);
        }
        if (this.mwM != null) {
            this.mwM.onStarted();
        }
        this.fMO.startLoading();
        wS(true);
    }

    public void dBu() {
        aSj();
        this.mwx.setVisibility(0);
    }

    public void aSj() {
        int i2 = 100;
        if (this.gqT != null && this.kTH != null) {
            this.abf = true;
            this.currentState = 1;
            this.gqT.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dBZ().Ro(this.mVideoUrl);
            this.mwY = true;
            if (this.mStartPosition > 100 && this.gqT.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abg = i2;
            this.fMO.dBV();
            wS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mxc && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amY)) {
            this.mxc = false;
            this.mxd = true;
            gb(this.mVideoUrl, this.amY);
        }
    }

    private void wS(boolean z) {
        if (z) {
            this.amP.setVisibility(0);
            dBE();
            this.mwx.setProgress(0);
        } else {
            this.amP.setVisibility(8);
            dBE();
        }
        this.kTH.showProgress();
        this.kTI.setVisibility(8);
        this.mwB.setVisibility(8);
        this.mwA.setVisibility(8);
        this.mwC.setVisibility(8);
        this.ime.setVisibility(8);
    }

    private void dBv() {
        this.fMO.dBV();
        this.mwB.setVisibility(8);
        this.mwA.setVisibility(8);
        this.mwC.setVisibility(8);
        dBG();
    }

    public void aSi() {
        this.gqT.pause();
        this.currentState = 2;
        dBv();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abl);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUq);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxl);
        this.gqT.stopPlayback();
        this.abf = false;
        this.mxe = false;
        this.mStartPosition = 0;
        cRo();
    }

    public void dBw() {
        if (this.gqT.getDuration() >= this.gqT.getCurrentPosition()) {
            com.baidu.tieba.play.n.dBZ().bD(this.mVideoUrl, this.gqT.getCurrentPositionSync());
        }
    }

    public void wT(boolean z) {
        this.mwX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU(boolean z) {
        if (this.kTO != null) {
            this.kTI.setVisibility(0);
            this.mwB.setVisibility(8);
            this.mwA.setVisibility(8);
            this.mwC.setVisibility(8);
            this.fMO.dBV();
            dBE();
            this.mwx.setVisibility(8);
            this.ime.setVisibility(8);
            this.kTH.aSx();
            this.amP.setVisibility(z ? 0 : 8);
        }
    }

    public void cRo() {
        wU(true);
    }

    public boolean rM() {
        if (this.gqT == null) {
            return false;
        }
        return this.gqT.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gqT == null) {
            return 0;
        }
        return this.gqT.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mwP = kVar;
    }

    public void a(j jVar) {
        this.mwO = jVar;
    }

    public void a(i iVar) {
        this.lZS = iVar;
    }

    public void a(g gVar) {
        this.mwV = gVar;
    }

    public void a(h hVar) {
        this.mwN = hVar;
    }

    public void QO(String str) {
        this.lZs = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBx() {
        a(this.mVideoUrl, this.amY, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mwK = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dBy();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dTL().dTM()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mwZ = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mwU != null) {
                    this.mwU.qt(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Bq(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dBz();
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
                aVar.b(this.eNx).brv();
                return;
            } else if (this.mwU != null) {
                this.mwU.qt(true);
                return;
            } else {
                if (!this.mww) {
                    this.mww = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mwT != null) {
            this.mwT.cEY();
        }
    }

    private void dBy() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dTL().gG(this.mActivity);
        }
    }

    public void dBz() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.amP.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUu);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abl);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUq);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxk);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxl);
        this.kUi.stop();
        kUm.unregister(this.mActivity);
    }

    public void Rn(String str) {
        this.kTU.setText(str);
    }

    public boolean dez() {
        return this.abf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBA() {
        if (this.kTO != null) {
            if (this.mwG) {
                dBE();
            } else {
                dBD();
            }
        }
    }

    public void deD() {
        dBD();
        dBB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBB() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUu);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.kUu, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBC() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUu);
    }

    public void dBD() {
        if (this.kTO != null && !this.mwG && !this.mxi) {
            wV(true);
            deC();
            this.kTO.setVisibility(0);
            this.mwy.setVisibility(0);
            this.mwx.setVisibility(8);
            this.mwG = true;
            if (this.mwK != null) {
                this.mwK.qu(false);
            }
        }
    }

    public void deA() {
        if (this.kTO != null && this.mwG) {
            wV(false);
            deC();
            this.kTO.setVisibility(8);
            this.mwy.setVisibility(8);
            this.mwx.setVisibility(0);
            this.jaj.setAnimationListener(this.kUs);
            this.kTO.startAnimation(this.jaj);
            this.mwG = false;
            if (this.mwK != null) {
                this.mwK.cFa();
            }
        }
    }

    public void dBE() {
        if (this.kTO != null && this.mwG) {
            this.cbQ.cancel();
            this.jaj.cancel();
            wV(false);
            deC();
            this.kTO.setVisibility(8);
            this.mwy.setVisibility(8);
            this.mwx.setVisibility(0);
            this.mwG = false;
            if (this.mwK != null) {
                this.mwK.cFa();
            }
        }
    }

    private void deC() {
        if (this.kTO != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUu);
            this.cbQ.setAnimationListener(null);
            this.jaj.setAnimationListener(null);
            this.kTO.clearAnimation();
        }
    }

    private void dBF() {
        if (this.kTO != null) {
            this.cbQ.setAnimationListener(null);
            this.jaj.setAnimationListener(null);
            this.kTO.clearAnimation();
        }
    }

    public void wV(boolean z) {
        dBG();
        if (z) {
            this.mwz.setVisibility(0);
        } else {
            this.mwz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBG() {
        if (this.currentState == 1) {
            this.mwz.setState(1);
        } else {
            this.mwz.setState(0);
        }
    }

    public void a(InterfaceC0845c interfaceC0845c) {
        this.mwJ = interfaceC0845c;
    }

    public void Fw(int i2) {
        this.mStartPosition = i2;
    }

    public void av(boolean z, boolean z2) {
        if (this.kUi != null) {
            if (this.kTN != null) {
                this.kTN.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kTH != null && (this.kTH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kTH.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kTH.setLayoutParams(layoutParams);
            }
            this.kUi.da(z);
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

    public void wW(boolean z) {
        this.mxh = z;
    }

    public void a(m mVar) {
        this.mwQ = mVar;
    }

    public void a(a aVar) {
        this.mwR = aVar;
    }

    public void a(n nVar) {
        this.mwS = nVar;
    }

    public void a(l lVar) {
        this.mwT = lVar;
    }

    public void a(f fVar) {
        this.mwU = fVar;
    }

    public void wX(boolean z) {
        this.mxb = z;
    }

    public void wY(boolean z) {
        this.mwH = z;
    }

    public void IG(int i2) {
        this.mxf = i2;
    }

    public View dBH() {
        return this.kTF;
    }

    public void a(p pVar) {
        this.lZG = pVar;
    }

    public void dBI() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eNx.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eNx.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gqT != null) {
            this.gqT.setStageType(str);
        }
    }
}
