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
    private static int kUn;
    private static CallStateReceiver kUo;
    private TbImageView amP;
    private String amY;
    private View bIy;
    private Animation cbQ;
    private TbPageContext<?> eNx;
    private String fFV;
    private com.baidu.tieba.play.m fMO;
    private ImageView gWm;
    protected TbCyberVideoView gqV;
    protected View imh;
    private Animation jal;
    public View kTH;
    private VideoListMediaControllerView kTJ;
    private View kTK;
    private FrameLayout kTL;
    protected FrameLayout.LayoutParams kTM;
    private ImageView kTP;
    private View kTQ;
    private View kTS;
    private CyberPlayerManager.OnPreparedListener kTU;
    private TextView kTW;
    private View kUa;
    private View kUb;
    private TextView kUc;
    private SeekBar kUd;
    private ImageView kUe;
    private ImageView kUf;
    private int kUg;
    private com.baidu.tieba.play.j kUk;
    private int kUm;
    private p lZI;
    private i lZU;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private View mwA;
    private SwitchImageView mwB;
    private TextView mwC;
    private TextView mwD;
    private TextView mwE;
    private int mwF;
    private CyberPlayerManager.OnCompletionListener mwG;
    private CyberPlayerManager.OnErrorListener mwH;
    private View.OnClickListener mwK;
    protected InterfaceC0845c mwL;
    private d mwM;
    private o mwO;
    private h mwP;
    private j mwQ;
    private k mwR;
    private m mwS;
    private a mwT;
    private n mwU;
    private l mwV;
    private f mwW;
    private g mwX;
    private ProgressBar mwz;
    private TextView mxc;
    private boolean mxe;
    private boolean mxf;
    private boolean mxg;
    private int mxh;
    private boolean mxi;
    private boolean mxj;
    private int abg = 100;
    private boolean mwy = false;
    protected boolean abq = false;
    private boolean abf = false;
    private boolean mwI = false;
    private boolean mwJ = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kUh = 0;
    private int kUi = 0;
    private long mwN = 60000;
    private int kUl = 0;
    private boolean kUp = false;
    private boolean mwY = true;
    private boolean mwZ = true;
    private boolean mxa = false;
    private boolean mxb = false;
    private String lZu = null;
    private int currentState = -1;
    private boolean mxd = false;
    private boolean mxk = false;
    private boolean mxl = false;
    private CyberPlayerManager.OnPreparedListener ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kTJ != null && c.this.gqV != null && c.this.gqV.getDuration() > 0) {
                c.this.kTJ.bB(0, c.this.gqV.getDuration());
            }
            c.this.crO();
            if (c.this.mwO != null) {
                c.this.mwO.onPrepared();
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
    private VideoLoadingProgressView.a ijr = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.crO();
        }
    };
    private Runnable abl = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.abl);
            if (c.this.amP.getVisibility() != 8) {
                if (c.this.gqV.getCurrentPosition() > c.this.abg) {
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
            if (c.this.gqV != null) {
                int duration = c.this.gqV.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.abf = false;
                    c.this.mxg = false;
                    c.this.mStartPosition = 0;
                    c.this.deo();
                    c.this.kTK.setVisibility(0);
                    c.this.mwz.setProgress(c.this.mwz.getMax());
                    c.this.abg = 100;
                    if (c.this.mwG != null) {
                        c.this.mwG.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.wU(false);
                        c.this.wV(true);
                    } else {
                        c.this.dBF();
                        c.this.mwC.setVisibility(0);
                    }
                    if (!c.this.abq && duration <= 150000) {
                        if (!c.this.mxd) {
                            if (c.this.mwQ != null) {
                                c.this.mwQ.vX(true);
                            }
                            c.this.C(c.this.mVideoUrl, c.this.amY, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gqV.pause();
                            c.this.gqV.seekTo(0);
                        }
                    }
                    if (c.this.mwO != null) {
                        c.this.mwO.IH(c.this.mwz.getMax());
                        c.this.mwO.JP();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kUr = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.imh.setVisibility(0);
            c.this.fMO.dBW();
            c.this.currentState = 4;
            if (c.this.mwH != null) {
                c.this.mwH.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mxe = true;
            }
            if (c.this.mwO != null) {
                c.this.mwO.dBK();
            }
            c.this.mxg = false;
            return true;
        }
    };
    protected Runnable kUs = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gqV == null || !c.this.gqV.isPlaying()) {
                c.this.imh.setVisibility(0);
                c.this.fMO.dBW();
                if (c.this.mwO != null) {
                    c.this.mwO.dBK();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener etD = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mxa) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mxm, 200L);
            }
        }
    };
    private Runnable mxm = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gqV == null || !c.this.mxa) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.abl, 200L);
                c.this.mxa = false;
            } else if (c.this.mStartPosition != c.this.gqV.getCurrentPosition()) {
                c.this.mxa = false;
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.abl, 20L);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mxm, 200L);
            }
        }
    };
    private TbCyberVideoView.a fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abf = false;
            if (c.this.mwJ) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mxn, 300L);
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.abl);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.kUs);
        }
    };
    private Runnable mxn = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mxg = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.lZI != null) {
                c.this.lZI.dvw();
            }
            if (view.getId() != c.this.imh.getId()) {
                if (view.getId() != c.this.mwB.getId()) {
                    if (view.getId() == c.this.mwD.getId()) {
                        if (c.this.mwP != null) {
                            c.this.mwP.dvx();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mwC.getId()) {
                        if (c.this.mwQ != null) {
                            c.this.mwQ.vX(false);
                        }
                        c.this.gb(c.this.mVideoUrl, c.this.amY);
                        return;
                    } else if (view.getId() == c.this.kTP.getId()) {
                        int i2 = c.this.mwJ ? 1 : 2;
                        if (c.this.abq) {
                            TiebaStatic.log(new ar("c11714"));
                            TiebaStatic.log(new ar("c13262").dY("tid", c.this.amY).dY("fid", c.this.fFV).al("obj_type", i2).al("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ar("c11710"));
                            TiebaStatic.log(new ar("c13262").dY("tid", c.this.amY).dY("fid", c.this.fFV).al("obj_type", i2).al("obj_source", 1));
                        }
                        if (c.this.mwV != null) {
                            c.this.mwV.cFa();
                        }
                        if (c.this.dBq()) {
                            if (c.this.abq) {
                                c.this.dBt();
                            } else {
                                c.this.dBs();
                            }
                            c.this.wR(c.this.abq);
                            return;
                        }
                        c.this.Vh();
                        return;
                    } else if (view.getId() != c.this.gWm.getId()) {
                        if (c.this.mwK != null) {
                            c.this.mwK.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ar("c11713"));
                        if (c.this.mwV != null) {
                            c.this.mwV.cFa();
                        }
                        if (c.this.dBq()) {
                            c.this.dBt();
                            c.this.wR(false);
                            return;
                        }
                        c.this.Vh();
                        return;
                    }
                }
                TiebaStatic.log(new ar("c13255"));
                c.this.dvp();
                c.this.dBH();
                if (c.this.currentState != 1) {
                    c.this.dBD();
                    c.this.dBE();
                } else {
                    c.this.deE();
                }
                if (c.this.mwT != null) {
                    c.this.mwT.rd(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gqV.stopPlayback();
            c.this.abf = false;
            c.this.dBy();
        }
    };
    private Animation.AnimationListener kUu = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kUv = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kUw = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.deB();
        }
    };
    private CustomMessageListener kUx = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aSi();
            }
        }
    };
    private VideoControllerView.b kWq = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void ur(int i2) {
            int duration;
            if (c.this.gqV != null && (duration = c.this.gqV.getDuration()) > 0 && c.this.mwz != null) {
                c.this.mwz.setProgress((int) ((i2 * c.this.kTH.getWidth()) / duration));
                if (c.this.mwO != null) {
                    c.this.mwO.IH((c.this.gqV.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gaK = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ar("c13256"));
            c.this.dBD();
            c.this.wV(false);
            if (c.this.mwT != null) {
                c.this.mwT.rd(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.des() != null) {
                c.this.Fw(c.this.des().getSeekPosition());
                if (!c.this.deA()) {
                    c.this.dBy();
                } else {
                    c.this.aSj();
                    if (c.this.lZU != null) {
                        c.this.lZU.cFc();
                    }
                }
            }
            c.this.wV(true);
            c.this.dBC();
            if (c.this.mwT != null) {
                c.this.mwT.rd(true);
            }
            if (c.this.mwU != null) {
                c.this.mwU.onStopTrackingTouch(seekBar);
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
        void cFb();

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
        void dvx();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cFc();
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
        void cEZ();

        void cFa();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dvy();

        boolean dvz();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void IH(int i);

        void JP();

        void dBK();

        void dBL();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dvw();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mxi = true;
        if (tbPageContext != null) {
            this.eNx = tbPageContext;
            this.mRootView = view;
            this.mxi = z;
            this.kTS = view;
            this.mActivity = this.eNx.getPageActivity();
            init();
        }
    }

    public void init() {
        this.kTH = aw(this.mActivity);
        this.kTH.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.kTH);
        }
        this.gqV = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.kTH).addView(this.gqV.getView(), 0);
        this.gqV.getView().setLayoutParams(layoutParams);
        this.fMO = new com.baidu.tieba.play.m((ViewGroup) this.kTH.findViewById(R.id.auto_video_loading_container));
        this.fMO.setLoadingAnimationListener(this.ijr);
        this.kTJ = (VideoListMediaControllerView) this.kTH.findViewById(R.id.media_controller);
        this.kTJ.setPlayer(this.gqV);
        this.mwz = (ProgressBar) this.kTH.findViewById(R.id.pgrBottomProgress);
        this.mwz.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mwz.setProgress(0);
        this.kTJ.setOnSeekBarChangeListener(this.gaK);
        this.kTJ.setOnProgressUpdatedListener(this.kWq);
        this.kTK = this.kTH.findViewById(R.id.black_mask);
        this.imh = this.kTH.findViewById(R.id.layout_error);
        this.imh.setOnClickListener(this.mOnClickListener);
        this.mxc = (TextView) this.kTH.findViewById(R.id.auto_video_error_tips);
        this.kTL = (FrameLayout) this.kTH.findViewById(R.id.danmu_container);
        this.kTP = (ImageView) this.kTH.findViewById(R.id.img_full_screen);
        this.kTP.setOnClickListener(this.mOnClickListener);
        this.kTQ = this.kTH.findViewById(R.id.layout_media_controller);
        this.mwA = this.kTH.findViewById(R.id.time_show_controller);
        this.gqV.setContinuePlayEnable(true);
        this.gqV.setOnPreparedListener(this.ety);
        this.gqV.setOnCompletionListener(this.etA);
        this.gqV.setOnErrorListener(this.kUr);
        this.gqV.setOnSeekCompleteListener(this.etD);
        this.gqV.setOnInfoListener(this.etB);
        this.gqV.setOnSurfaceDestroyedListener(this.fMW);
        this.mwB = (SwitchImageView) this.kTH.findViewById(R.id.img_play_controller);
        this.mwB.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mwB.setState(0);
        this.mwB.setOnClickListener(this.mOnClickListener);
        this.mwC = (TextView) this.kTH.findViewById(R.id.txt_replay);
        this.mwC.setOnClickListener(this.mOnClickListener);
        this.mwD = (TextView) this.kTH.findViewById(R.id.txt_playnext);
        this.mwD.setOnClickListener(this.mOnClickListener);
        this.mwE = (TextView) this.kTH.findViewById(R.id.txt_next_video_title);
        this.amP = (TbImageView) this.kTH.findViewById(R.id.video_thumbnail);
        this.amP.setDefaultErrorResource(0);
        this.amP.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gWm = (ImageView) this.kTH.findViewById(R.id.img_exit);
        this.gWm.setOnClickListener(this.mOnClickListener);
        this.kTW = (TextView) this.kTH.findViewById(R.id.video_title);
        this.bIy = this.kTH.findViewById(R.id.layout_title);
        this.bIy.setVisibility(8);
        this.jal = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.cbQ = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.kUg = this.mAudioManager.getStreamMaxVolume(3);
        this.kUm = this.mAudioManager.getStreamVolume(3);
        kUn = 100 / this.kUg;
        this.kTH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mwR != null) {
                    c.this.mwR.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abf) {
                        if (c.this.mStatus == 1 && c.this.kUi != 0) {
                            c.this.b(c.this.kUi == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kUi = 0;
                            c.this.kUh = 0;
                        }
                        if (!c.this.gqV.isPlaying()) {
                            c.this.mwD.setVisibility(8);
                            c.this.mwC.setVisibility(8);
                            c.this.mwE.setVisibility(8);
                        }
                    }
                    c.this.deo();
                    if (c.this.mwR != null) {
                        c.this.mwR.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kUk = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mxi) {
            this.kUk.start();
        }
        this.kUl = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kUo == null) {
            kUo = new CallStateReceiver();
        }
        kUo.register(this.mActivity);
        dBp();
        MessageManager.getInstance().registerListener(this.kUx);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kUx);
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

    public void dBp() {
        if (this.mwY) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.kTH.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.kTH.setSystemUiVisibility(0);
    }

    public void wP(boolean z) {
        this.mwY = z;
        dBp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deo() {
        this.mStatus = 0;
        if (this.kUa != null && this.kUa.getParent() != null && (this.kUa.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kUa.getParent()).removeView(this.kUa);
                this.kUa = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kUb != null && this.kUb.getParent() != null && (this.kUb.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kUb.getParent()).removeView(this.kUb);
                this.kUb = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void dep() {
        if (this.mStatus == 1) {
            if (this.kUa == null && this.kTH != null && (this.kTH instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.kTH, true);
                this.kUa = this.kTH.findViewById(R.id.lay_jindu);
                this.kUc = (TextView) this.kUa.findViewById(R.id.show_time);
                this.kUf = (ImageView) this.kUa.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kUb == null && this.kTH != null && (this.kTH instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.kTH, true);
            this.kUb = this.kTH.findViewById(R.id.lay_voice);
            this.kUe = (ImageView) this.kUb.findViewById(R.id.arrow_voice_icon);
            this.kUd = (SeekBar) this.kUb.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mwK = onClickListener;
    }

    public void wQ(boolean z) {
        this.mwJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mwR != null) {
                c.this.mwR.onStart();
            }
            if (c.this.abq && c.this.abf) {
                if (c.this.mStatus == 1) {
                    c.this.dBF();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aM(f2);
                    }
                } else {
                    if (c.this.abq) {
                        c.this.der();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kUh = c.this.gqV.getCurrentPosition();
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
            if (!c.this.mxj) {
                if (c.this.mwS != null && c.this.mwS.dvy()) {
                    return true;
                }
                c.this.dvp();
                c.this.dBH();
                if (c.this.gqV.isPlaying()) {
                    c.this.dBC();
                } else {
                    c.this.dBD();
                }
                if (c.this.mwT != null) {
                    c.this.mwT.rd(c.this.gqV.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mxj) {
                if (c.this.abf) {
                    if (c.this.mwS != null && c.this.mwS.dvz()) {
                        return true;
                    }
                    c.this.dBB();
                    if (c.this.gqV.isPlaying()) {
                        c.this.dBC();
                    } else {
                        c.this.dBD();
                    }
                    if (c.this.mwT != null) {
                        c.this.mwT.rd(c.this.gqV.isPlaying());
                    }
                } else {
                    c.this.dvp();
                    c.this.dBH();
                    if (c.this.currentState != 1) {
                        c.this.dBD();
                        c.this.dBE();
                    } else {
                        c.this.deE();
                    }
                    if (c.this.mwT != null) {
                        c.this.mwT.rd(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void der() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kTH.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kTH.setSystemUiVisibility(4);
        } else {
            this.kTH.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(float f2) {
        if (!this.abf) {
            this.mStatus = 0;
            return;
        }
        if (kUn == 0) {
            this.kUg = this.mAudioManager.getStreamMaxVolume(3);
            kUn = 100 / this.kUg;
            if (kUn == 0) {
                kUn = 1;
            }
        }
        dep();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kUn == 0) {
            if (f2 > 0.0f && this.kUm < this.kUg) {
                this.kUm++;
            }
            if (f2 < 0.0f && this.kUm > 0) {
                this.kUm--;
            }
        }
        if (this.mProgress > 0) {
            this.kUe.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kUe.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kUm, 0);
        this.kUd.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kUh -= 1000;
                this.kUi = 1;
            } else {
                this.kUh += 1000;
                this.kUi = 2;
            }
            if (this.kUh < 0) {
                this.kUh = 0;
            } else if (this.kUh > this.gqV.getDuration()) {
                this.kUh = this.gqV.getDuration();
            }
        }
        dep();
        String IL = this.kTJ.IL(this.kUh);
        if (f2 > 0.0f) {
            this.kUf.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kUf.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(IL)) {
            this.kUc.setText(new StringBuilder().append(IL).append("/").append(this.kTJ.IL(this.gqV.getDuration())));
        }
        this.kTJ.setCurrentDuration(this.kUh, z ? false : true);
        dBF();
        dBu();
    }

    protected View aw(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void IE(int i2) {
        this.mwF = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amY = str2;
    }

    public void setFid(String str) {
        this.fFV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        int i2 = 100;
        if (this.gqV != null && this.kTJ != null) {
            this.kTJ.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dCa().Ro(this.mVideoUrl);
            if (this.mxg) {
                this.gqV.setVolume(1.0f, 1.0f);
                this.gqV.start();
                this.mxg = false;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abl);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.abl, 20L);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUs);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxn);
                if (this.gqV.dCh()) {
                    this.currentState = 1;
                    dBF();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dCa().Ro(this.mVideoUrl);
                this.kTJ.setPlayer(this.gqV);
                if (this.mStartPosition != 0) {
                    this.mxa = true;
                }
                if (!this.mxf) {
                    this.kTJ.showProgress();
                }
                if (!this.mwJ && this.gqV.getDuration() <= 0) {
                    des().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gqV.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abg = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        if (this.amP.getVisibility() != 8 || !this.abf) {
            this.abf = true;
            this.kTK.setVisibility(8);
            this.imh.setVisibility(8);
            this.fMO.dBV();
            this.amP.setVisibility(8);
            dBG();
            this.kTJ.showProgress();
            this.mwz.setVisibility(0);
            if (this.kTU != null) {
                this.kTU.onPrepared();
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
        if (hasNavBar(this.mActivity) && (this.mwA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mwA.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mwA.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mwA.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mwA.setLayoutParams(layoutParams);
        }
    }

    public void dvp() {
        if (this.gqV.isPlaying()) {
            aSi();
            if (this.mwX != null) {
                this.mwX.onPause();
            }
            if (this.mwO != null) {
                this.mwO.onPaused();
            }
        } else if (this.abf) {
            aSj();
            if (this.lZU != null) {
                this.lZU.cFc();
            }
            if (this.mwO != null) {
                this.mwO.dBL();
            }
        } else {
            dBy();
        }
    }

    public void Vh() {
        this.kUp = true;
        if (this.kUk != null) {
            this.kUk.Vh();
        }
    }

    public boolean dBq() {
        return this.gqV != null && this.gqV.getView().getHeight() > this.gqV.getView().getWidth();
    }

    public void dBr() {
        wR(false);
        dBt();
    }

    public boolean IF(int i2) {
        switch (i2) {
            case 4:
                if (this.abq) {
                    if (dBq()) {
                        wR(false);
                        dBt();
                    } else {
                        Vh();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kUg <= 0 || this.kUd == null) {
                    return false;
                }
                this.kUm = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kUm * 100.0d) / this.kUg);
                this.kUd.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gqV;
    }

    public VideoListMediaControllerView des() {
        return this.kTJ;
    }

    public void show() {
        this.kTH.setVisibility(0);
    }

    public void dew() {
        if (this.kTS != null) {
            ViewGroup.LayoutParams layoutParams = this.kTS.getLayoutParams();
            this.kTM = (FrameLayout.LayoutParams) this.kTH.getLayoutParams();
            this.kTM.width = layoutParams.width;
            this.kTM.height = layoutParams.height;
            this.kTM.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.kTH.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.kTH.setLayoutParams(this.kTM);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kUp) {
            if (this.abq) {
                TiebaStatic.log(new ar("c11712"));
            } else {
                TiebaStatic.log(new ar("c11711"));
            }
        } else {
            this.kUp = false;
        }
        if (configuration.orientation == 2) {
            dBs();
        } else {
            dBt();
        }
        dBu();
        if (this.mActivity == com.baidu.adp.base.a.lg().currentActivity()) {
            aSj();
        }
        dBH();
        deE();
        if (this.mwT != null) {
            this.mwT.rd(true);
        }
    }

    protected void dBs() {
        this.abq = true;
        this.kTH.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bGp().fe(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bGp().ff(this.mActivity))));
        j(this.mActivity, true);
        this.bIy.setVisibility(0);
        this.gWm.setVisibility(0);
        this.kTW.setVisibility(0);
        this.kTL.setVisibility(8);
        this.fMO.dBW();
        this.amP.setVisibility(8);
        this.kTP.setImageResource(R.drawable.icon_video_narrow_white);
        Ft(this.kUl);
        der();
        if (this.mwL != null) {
            this.mwL.rK();
        }
    }

    protected void dBt() {
        this.abq = false;
        if (this.kTM != null) {
            this.kTH.setLayoutParams(this.kTM);
        }
        j(this.mActivity, false);
        this.bIy.setVisibility(8);
        this.kTL.setVisibility(0);
        this.fMO.dBW();
        this.amP.setVisibility(8);
        this.kTP.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kTJ != null && (this.kTJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kTJ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kTJ.setLayoutParams(layoutParams);
        }
        this.kTH.setSystemUiVisibility(0);
        dBp();
        if (this.mwL != null) {
            this.mwL.rL();
        }
    }

    public void dBu() {
        if (this.gqV != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.abq) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mwz.setMax(equipmentWidth);
            int duration = this.gqV.getDuration();
            if (duration > 0) {
                if (this.mwC.getVisibility() == 0) {
                    this.mwz.setProgress(this.mwz.getMax());
                } else {
                    this.mwz.setProgress((int) ((this.gqV.getCurrentPositionSync() * this.mwz.getMax()) / duration));
                }
            }
        }
    }

    private void Ft(int i2) {
        if (this.kTJ != null && (this.kTJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kTJ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kTJ.setLayoutParams(layoutParams);
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

    public boolean dey() {
        return !this.abq;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kTU = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mwG = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mwH = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mxb) {
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
        dBz();
        this.mxg = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gqV.setVideoDuration(this.mwF);
        this.gqV.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUs);
        if (this.mwN > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kUs, this.mwN);
        }
        if (this.mwO != null) {
            this.mwO.onStarted();
        }
        this.fMO.startLoading();
        wS(z);
    }

    public void gb(String str, String str2) {
        C(str, str2, true);
    }

    public void gc(String str, String str2) {
        dBz();
        this.mxg = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUs);
        if (this.mwN > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kUs, this.mwN);
        }
        if (this.mwO != null) {
            this.mwO.onStarted();
        }
        this.fMO.startLoading();
        wS(true);
    }

    public void dBv() {
        aSj();
        this.mwz.setVisibility(0);
    }

    public void aSj() {
        int i2 = 100;
        if (this.gqV != null && this.kTJ != null) {
            this.abf = true;
            this.currentState = 1;
            this.gqV.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dCa().Ro(this.mVideoUrl);
            this.mxa = true;
            if (this.mStartPosition > 100 && this.gqV.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.abg = i2;
            this.fMO.dBW();
            wS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mxe && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amY)) {
            this.mxe = false;
            this.mxf = true;
            gb(this.mVideoUrl, this.amY);
        }
    }

    private void wS(boolean z) {
        if (z) {
            this.amP.setVisibility(0);
            dBF();
            this.mwz.setProgress(0);
        } else {
            this.amP.setVisibility(8);
            dBF();
        }
        this.kTJ.showProgress();
        this.kTK.setVisibility(8);
        this.mwD.setVisibility(8);
        this.mwC.setVisibility(8);
        this.mwE.setVisibility(8);
        this.imh.setVisibility(8);
    }

    private void dBw() {
        this.fMO.dBW();
        this.mwD.setVisibility(8);
        this.mwC.setVisibility(8);
        this.mwE.setVisibility(8);
        dBH();
    }

    public void aSi() {
        this.gqV.pause();
        this.currentState = 2;
        dBw();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abl);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUs);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxn);
        this.gqV.stopPlayback();
        this.abf = false;
        this.mxg = false;
        this.mStartPosition = 0;
        cRp();
    }

    public void dBx() {
        if (this.gqV.getDuration() >= this.gqV.getCurrentPosition()) {
            com.baidu.tieba.play.n.dCa().bD(this.mVideoUrl, this.gqV.getCurrentPositionSync());
        }
    }

    public void wT(boolean z) {
        this.mwZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU(boolean z) {
        if (this.kTQ != null) {
            this.kTK.setVisibility(0);
            this.mwD.setVisibility(8);
            this.mwC.setVisibility(8);
            this.mwE.setVisibility(8);
            this.fMO.dBW();
            dBF();
            this.mwz.setVisibility(8);
            this.imh.setVisibility(8);
            this.kTJ.aSx();
            this.amP.setVisibility(z ? 0 : 8);
        }
    }

    public void cRp() {
        wU(true);
    }

    public boolean rM() {
        if (this.gqV == null) {
            return false;
        }
        return this.gqV.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gqV == null) {
            return 0;
        }
        return this.gqV.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mwR = kVar;
    }

    public void a(j jVar) {
        this.mwQ = jVar;
    }

    public void a(i iVar) {
        this.lZU = iVar;
    }

    public void a(g gVar) {
        this.mwX = gVar;
    }

    public void a(h hVar) {
        this.mwP = hVar;
    }

    public void QO(String str) {
        this.lZu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBy() {
        a(this.mVideoUrl, this.amY, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mwM = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dBz();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dTM().dTN()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mxb = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mwW != null) {
                    this.mwW.qt(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Bq(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dBA();
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
            } else if (this.mwW != null) {
                this.mwW.qt(true);
                return;
            } else {
                if (!this.mwy) {
                    this.mwy = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mwV != null) {
            this.mwV.cEZ();
        }
    }

    private void dBz() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dTM().gG(this.mActivity);
        }
    }

    public void dBA() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.amP.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUw);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abl);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUs);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxm);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxn);
        this.kUk.stop();
        kUo.unregister(this.mActivity);
    }

    public void Rn(String str) {
        this.kTW.setText(str);
    }

    public boolean deA() {
        return this.abf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBB() {
        if (this.kTQ != null) {
            if (this.mwI) {
                dBF();
            } else {
                dBE();
            }
        }
    }

    public void deE() {
        dBE();
        dBC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBC() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUw);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.kUw, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBD() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUw);
    }

    public void dBE() {
        if (this.kTQ != null && !this.mwI && !this.mxk) {
            wV(true);
            deD();
            this.kTQ.setVisibility(0);
            this.mwA.setVisibility(0);
            this.mwz.setVisibility(8);
            this.mwI = true;
            if (this.mwM != null) {
                this.mwM.qu(false);
            }
        }
    }

    public void deB() {
        if (this.kTQ != null && this.mwI) {
            wV(false);
            deD();
            this.kTQ.setVisibility(8);
            this.mwA.setVisibility(8);
            this.mwz.setVisibility(0);
            this.jal.setAnimationListener(this.kUu);
            this.kTQ.startAnimation(this.jal);
            this.mwI = false;
            if (this.mwM != null) {
                this.mwM.cFb();
            }
        }
    }

    public void dBF() {
        if (this.kTQ != null && this.mwI) {
            this.cbQ.cancel();
            this.jal.cancel();
            wV(false);
            deD();
            this.kTQ.setVisibility(8);
            this.mwA.setVisibility(8);
            this.mwz.setVisibility(0);
            this.mwI = false;
            if (this.mwM != null) {
                this.mwM.cFb();
            }
        }
    }

    private void deD() {
        if (this.kTQ != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUw);
            this.cbQ.setAnimationListener(null);
            this.jal.setAnimationListener(null);
            this.kTQ.clearAnimation();
        }
    }

    private void dBG() {
        if (this.kTQ != null) {
            this.cbQ.setAnimationListener(null);
            this.jal.setAnimationListener(null);
            this.kTQ.clearAnimation();
        }
    }

    public void wV(boolean z) {
        dBH();
        if (z) {
            this.mwB.setVisibility(0);
        } else {
            this.mwB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBH() {
        if (this.currentState == 1) {
            this.mwB.setState(1);
        } else {
            this.mwB.setState(0);
        }
    }

    public void a(InterfaceC0845c interfaceC0845c) {
        this.mwL = interfaceC0845c;
    }

    public void Fw(int i2) {
        this.mStartPosition = i2;
    }

    public void av(boolean z, boolean z2) {
        if (this.kUk != null) {
            if (this.kTP != null) {
                this.kTP.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kTJ != null && (this.kTJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kTJ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kTJ.setLayoutParams(layoutParams);
            }
            this.kUk.da(z);
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
        this.mxj = z;
    }

    public void a(m mVar) {
        this.mwS = mVar;
    }

    public void a(a aVar) {
        this.mwT = aVar;
    }

    public void a(n nVar) {
        this.mwU = nVar;
    }

    public void a(l lVar) {
        this.mwV = lVar;
    }

    public void a(f fVar) {
        this.mwW = fVar;
    }

    public void wX(boolean z) {
        this.mxd = z;
    }

    public void wY(boolean z) {
        this.mwJ = z;
    }

    public void IG(int i2) {
        this.mxh = i2;
    }

    public View dBI() {
        return this.kTH;
    }

    public void a(p pVar) {
        this.lZI = pVar;
    }

    public void dBJ() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eNx.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eNx.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gqV != null) {
            this.gqV.setStageType(str);
        }
    }
}
