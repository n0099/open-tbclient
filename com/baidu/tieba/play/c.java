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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class c {
    private static int kAK;
    private static CallStateReceiver kAL;
    private TbImageView alJ;
    private String alT;
    private Animation bSB;
    private View byQ;
    private TbPageContext<?> eCn;
    private String fsZ;
    private com.baidu.tieba.play.m fzK;
    private ImageView gHE;
    protected TbCyberVideoView gdn;
    protected View hUJ;
    private Animation iII;
    private SeekBar kAA;
    private ImageView kAB;
    private ImageView kAC;
    private int kAD;
    private com.baidu.tieba.play.j kAH;
    private int kAJ;
    public View kAe;
    private VideoListMediaControllerView kAg;
    private View kAh;
    private FrameLayout kAi;
    protected FrameLayout.LayoutParams kAj;
    private ImageView kAm;
    private View kAn;
    private View kAp;
    private CyberPlayerManager.OnPreparedListener kAr;
    private TextView kAt;
    private View kAx;
    private View kAy;
    private TextView kAz;
    private i lFG;
    private p lFu;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private TextView mcE;
    private boolean mcG;
    private boolean mcH;
    private boolean mcI;
    private int mcJ;
    private boolean mcK;
    private boolean mcL;
    private ProgressBar mcb;
    private View mcc;
    private SwitchImageView mcd;
    private TextView mce;
    private TextView mcf;
    private TextView mcg;
    private int mch;
    private CyberPlayerManager.OnCompletionListener mci;
    private CyberPlayerManager.OnErrorListener mcj;
    private View.OnClickListener mcm;
    protected InterfaceC0812c mcn;
    private d mco;
    private o mcq;
    private h mcr;
    private j mcs;
    private k mct;
    private m mcu;
    private a mcv;
    private n mcw;
    private l mcx;
    private f mcy;
    private g mcz;
    private int aaf = 100;
    private boolean mca = false;
    protected boolean aap = false;
    private boolean aae = false;
    private boolean mck = false;
    private boolean mcl = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kAE = 0;
    private int kAF = 0;
    private long mcp = 60000;
    private int kAI = 0;
    private boolean kAM = false;
    private boolean mcA = true;
    private boolean mcB = true;
    private boolean mcC = false;
    private boolean mcD = false;
    private String lFg = null;
    private int currentState = -1;
    private boolean mcF = false;
    private boolean mcM = false;
    private boolean mcN = false;
    private CyberPlayerManager.OnPreparedListener eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kAg != null && c.this.gdn != null && c.this.gdn.getDuration() > 0) {
                c.this.kAg.bz(0, c.this.gdn.getDuration());
            }
            c.this.clx();
            if (c.this.mcq != null) {
                c.this.mcq.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rZ();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hRV = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.clx();
        }
    };
    private Runnable aak = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aak);
            if (c.this.alJ.getVisibility() != 8) {
                if (c.this.gdn.getCurrentPosition() > c.this.aaf) {
                    c.this.rZ();
                } else {
                    com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aak, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gdn != null) {
                int duration = c.this.gdn.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.aae = false;
                    c.this.mcI = false;
                    c.this.mStartPosition = 0;
                    c.this.cXf();
                    c.this.kAh.setVisibility(0);
                    c.this.mcb.setProgress(c.this.mcb.getMax());
                    c.this.aaf = 100;
                    if (c.this.mci != null) {
                        c.this.mci.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.we(false);
                        c.this.wf(true);
                    } else {
                        c.this.duk();
                        c.this.mce.setVisibility(0);
                    }
                    if (!c.this.aap && duration <= 150000) {
                        if (!c.this.mcF) {
                            if (c.this.mcs != null) {
                                c.this.mcs.vi(true);
                            }
                            c.this.A(c.this.mVideoUrl, c.this.alT, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gdn.pause();
                            c.this.gdn.seekTo(0);
                        }
                    }
                    if (c.this.mcq != null) {
                        c.this.mcq.Hf(c.this.mcb.getMax());
                        c.this.mcq.Ig();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.hUJ.setVisibility(0);
            c.this.fzK.duB();
            c.this.currentState = 4;
            if (c.this.mcj != null) {
                c.this.mcj.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.mcG = true;
            }
            if (c.this.mcq != null) {
                c.this.mcq.dup();
            }
            c.this.mcI = false;
            return true;
        }
    };
    protected Runnable kAP = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gdn == null || !c.this.gdn.isPlaying()) {
                c.this.hUJ.setVisibility(0);
                c.this.fzK.duB();
                if (c.this.mcq != null) {
                    c.this.mcq.dup();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eir = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.mcC) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mcO, 200L);
            }
        }
    };
    private Runnable mcO = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gdn == null || !c.this.mcC) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aak, 200L);
                c.this.mcC = false;
            } else if (c.this.mStartPosition != c.this.gdn.getCurrentPosition()) {
                c.this.mcC = false;
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aak, 20L);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mcO, 200L);
            }
        }
    };
    private TbCyberVideoView.a fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.aae = false;
            if (c.this.mcl) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mcP, 300L);
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aak);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.kAP);
        }
    };
    private Runnable mcP = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mcI = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.lFu != null) {
                c.this.lFu.doa();
            }
            if (view.getId() != c.this.hUJ.getId()) {
                if (view.getId() != c.this.mcd.getId()) {
                    if (view.getId() == c.this.mcf.getId()) {
                        if (c.this.mcr != null) {
                            c.this.mcr.dob();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mce.getId()) {
                        if (c.this.mcs != null) {
                            c.this.mcs.vi(false);
                        }
                        c.this.fW(c.this.mVideoUrl, c.this.alT);
                        return;
                    } else if (view.getId() == c.this.kAm.getId()) {
                        int i2 = c.this.mcl ? 1 : 2;
                        if (c.this.aap) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dR("tid", c.this.alT).dR("fid", c.this.fsZ).aj("obj_type", i2).aj("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dR("tid", c.this.alT).dR("fid", c.this.fsZ).aj("obj_type", i2).aj("obj_source", 1));
                        }
                        if (c.this.mcx != null) {
                            c.this.mcx.cyF();
                        }
                        if (c.this.dtV()) {
                            if (c.this.aap) {
                                c.this.dtY();
                            } else {
                                c.this.dtX();
                            }
                            c.this.wb(c.this.aap);
                            return;
                        }
                        c.this.QI();
                        return;
                    } else if (view.getId() != c.this.gHE.getId()) {
                        if (c.this.mcm != null) {
                            c.this.mcm.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.mcx != null) {
                            c.this.mcx.cyF();
                        }
                        if (c.this.dtV()) {
                            c.this.dtY();
                            c.this.wb(false);
                            return;
                        }
                        c.this.QI();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.dnT();
                c.this.dum();
                if (c.this.currentState != 1) {
                    c.this.dui();
                    c.this.duj();
                } else {
                    c.this.cXv();
                }
                if (c.this.mcv != null) {
                    c.this.mcv.qq(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gdn.stopPlayback();
            c.this.aae = false;
            c.this.dud();
        }
    };
    private Animation.AnimationListener kAR = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kAS = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kAT = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cXs();
        }
    };
    private CustomMessageListener kAU = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aNl();
            }
        }
    };
    private VideoControllerView.b kCN = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tf(int i2) {
            int duration;
            if (c.this.gdn != null && (duration = c.this.gdn.getDuration()) > 0 && c.this.mcb != null) {
                c.this.mcb.setProgress((int) ((i2 * c.this.kAe.getWidth()) / duration));
                if (c.this.mcq != null) {
                    c.this.mcq.Hf((c.this.gdn.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fNb = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.dui();
            c.this.wf(false);
            if (c.this.mcv != null) {
                c.this.mcv.qq(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cXj() != null) {
                c.this.DW(c.this.cXj().getSeekPosition());
                if (!c.this.cXr()) {
                    c.this.dud();
                } else {
                    c.this.aNm();
                    if (c.this.lFG != null) {
                        c.this.lFG.cyH();
                    }
                }
            }
            c.this.wf(true);
            c.this.duh();
            if (c.this.mcv != null) {
                c.this.mcv.qq(true);
            }
            if (c.this.mcw != null) {
                c.this.mcw.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qq(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0812c {
        void rI();

        void rJ();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cyG();

        void pL(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void wj(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void pK(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dob();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cyH();
    }

    /* loaded from: classes.dex */
    public interface j {
        void vi(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cyE();

        void cyF();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean doc();

        boolean dod();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Hf(int i);

        void Ig();

        void dup();

        void duq();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void doa();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mcK = true;
        if (tbPageContext != null) {
            this.eCn = tbPageContext;
            this.mRootView = view;
            this.mcK = z;
            this.kAp = view;
            this.mActivity = this.eCn.getPageActivity();
            init();
        }
    }

    public void init() {
        this.kAe = aw(this.mActivity);
        this.kAe.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.kAe);
        }
        this.gdn = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.kAe).addView(this.gdn.getView(), 0);
        this.gdn.getView().setLayoutParams(layoutParams);
        this.fzK = new com.baidu.tieba.play.m((ViewGroup) this.kAe.findViewById(R.id.auto_video_loading_container));
        this.fzK.setLoadingAnimationListener(this.hRV);
        this.kAg = (VideoListMediaControllerView) this.kAe.findViewById(R.id.media_controller);
        this.kAg.setPlayer(this.gdn);
        this.mcb = (ProgressBar) this.kAe.findViewById(R.id.pgrBottomProgress);
        this.mcb.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mcb.setProgress(0);
        this.kAg.setOnSeekBarChangeListener(this.fNb);
        this.kAg.setOnProgressUpdatedListener(this.kCN);
        this.kAh = this.kAe.findViewById(R.id.black_mask);
        this.hUJ = this.kAe.findViewById(R.id.layout_error);
        this.hUJ.setOnClickListener(this.mOnClickListener);
        this.mcE = (TextView) this.kAe.findViewById(R.id.auto_video_error_tips);
        this.kAi = (FrameLayout) this.kAe.findViewById(R.id.danmu_container);
        this.kAm = (ImageView) this.kAe.findViewById(R.id.img_full_screen);
        this.kAm.setOnClickListener(this.mOnClickListener);
        this.kAn = this.kAe.findViewById(R.id.layout_media_controller);
        this.mcc = this.kAe.findViewById(R.id.time_show_controller);
        this.gdn.setContinuePlayEnable(true);
        this.gdn.setOnPreparedListener(this.eim);
        this.gdn.setOnCompletionListener(this.eio);
        this.gdn.setOnErrorListener(this.kAO);
        this.gdn.setOnSeekCompleteListener(this.eir);
        this.gdn.setOnInfoListener(this.eip);
        this.gdn.setOnSurfaceDestroyedListener(this.fzS);
        this.mcd = (SwitchImageView) this.kAe.findViewById(R.id.img_play_controller);
        this.mcd.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mcd.setState(0);
        this.mcd.setOnClickListener(this.mOnClickListener);
        this.mce = (TextView) this.kAe.findViewById(R.id.txt_replay);
        this.mce.setOnClickListener(this.mOnClickListener);
        this.mcf = (TextView) this.kAe.findViewById(R.id.txt_playnext);
        this.mcf.setOnClickListener(this.mOnClickListener);
        this.mcg = (TextView) this.kAe.findViewById(R.id.txt_next_video_title);
        this.alJ = (TbImageView) this.kAe.findViewById(R.id.video_thumbnail);
        this.alJ.setDefaultErrorResource(0);
        this.alJ.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gHE = (ImageView) this.kAe.findViewById(R.id.img_exit);
        this.gHE.setOnClickListener(this.mOnClickListener);
        this.kAt = (TextView) this.kAe.findViewById(R.id.video_title);
        this.byQ = this.kAe.findViewById(R.id.layout_title);
        this.byQ.setVisibility(8);
        this.iII = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bSB = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.kAD = this.mAudioManager.getStreamMaxVolume(3);
        this.kAJ = this.mAudioManager.getStreamVolume(3);
        kAK = 100 / this.kAD;
        this.kAe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mct != null) {
                    c.this.mct.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.aae) {
                        if (c.this.mStatus == 1 && c.this.kAF != 0) {
                            c.this.b(c.this.kAF == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kAF = 0;
                            c.this.kAE = 0;
                        }
                        if (!c.this.gdn.isPlaying()) {
                            c.this.mcf.setVisibility(8);
                            c.this.mce.setVisibility(8);
                            c.this.mcg.setVisibility(8);
                        }
                    }
                    c.this.cXf();
                    if (c.this.mct != null) {
                        c.this.mct.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kAH = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mcK) {
            this.kAH.start();
        }
        this.kAI = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kAL == null) {
            kAL = new CallStateReceiver();
        }
        kAL.register(this.mActivity);
        dtU();
        MessageManager.getInstance().registerListener(this.kAU);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kAU);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Hb(int i2) {
        if (this.alJ != null) {
            this.alJ.setDefaultBgResource(i2);
        }
    }

    public void dtU() {
        if (this.mcA) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.kAe.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.kAe.setSystemUiVisibility(0);
    }

    public void vZ(boolean z) {
        this.mcA = z;
        dtU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXf() {
        this.mStatus = 0;
        if (this.kAx != null && this.kAx.getParent() != null && (this.kAx.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kAx.getParent()).removeView(this.kAx);
                this.kAx = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kAy != null && this.kAy.getParent() != null && (this.kAy.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kAy.getParent()).removeView(this.kAy);
                this.kAy = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cXg() {
        if (this.mStatus == 1) {
            if (this.kAx == null && this.kAe != null && (this.kAe instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.kAe, true);
                this.kAx = this.kAe.findViewById(R.id.lay_jindu);
                this.kAz = (TextView) this.kAx.findViewById(R.id.show_time);
                this.kAC = (ImageView) this.kAx.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kAy == null && this.kAe != null && (this.kAe instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.kAe, true);
            this.kAy = this.kAe.findViewById(R.id.lay_voice);
            this.kAB = (ImageView) this.kAy.findViewById(R.id.arrow_voice_icon);
            this.kAA = (SeekBar) this.kAy.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.mcm = onClickListener;
    }

    public void wa(boolean z) {
        this.mcl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mct != null) {
                c.this.mct.onStart();
            }
            if (c.this.aap && c.this.aae) {
                if (c.this.mStatus == 1) {
                    c.this.duk();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aC(f2);
                    }
                } else {
                    if (c.this.aap) {
                        c.this.cXi();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kAE = c.this.gdn.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aC(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.mcL) {
                if (c.this.mcu != null && c.this.mcu.doc()) {
                    return true;
                }
                c.this.dnT();
                c.this.dum();
                if (c.this.gdn.isPlaying()) {
                    c.this.duh();
                } else {
                    c.this.dui();
                }
                if (c.this.mcv != null) {
                    c.this.mcv.qq(c.this.gdn.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mcL) {
                if (c.this.aae) {
                    if (c.this.mcu != null && c.this.mcu.dod()) {
                        return true;
                    }
                    c.this.dug();
                    if (c.this.gdn.isPlaying()) {
                        c.this.duh();
                    } else {
                        c.this.dui();
                    }
                    if (c.this.mcv != null) {
                        c.this.mcv.qq(c.this.gdn.isPlaying());
                    }
                } else {
                    c.this.dnT();
                    c.this.dum();
                    if (c.this.currentState != 1) {
                        c.this.dui();
                        c.this.duj();
                    } else {
                        c.this.cXv();
                    }
                    if (c.this.mcv != null) {
                        c.this.mcv.qq(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXi() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kAe.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kAe.setSystemUiVisibility(4);
        } else {
            this.kAe.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(float f2) {
        if (!this.aae) {
            this.mStatus = 0;
            return;
        }
        if (kAK == 0) {
            this.kAD = this.mAudioManager.getStreamMaxVolume(3);
            kAK = 100 / this.kAD;
            if (kAK == 0) {
                kAK = 1;
            }
        }
        cXg();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kAK == 0) {
            if (f2 > 0.0f && this.kAJ < this.kAD) {
                this.kAJ++;
            }
            if (f2 < 0.0f && this.kAJ > 0) {
                this.kAJ--;
            }
        }
        if (this.mProgress > 0) {
            this.kAB.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kAB.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kAJ, 0);
        this.kAA.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kAE -= 1000;
                this.kAF = 1;
            } else {
                this.kAE += 1000;
                this.kAF = 2;
            }
            if (this.kAE < 0) {
                this.kAE = 0;
            } else if (this.kAE > this.gdn.getDuration()) {
                this.kAE = this.gdn.getDuration();
            }
        }
        cXg();
        String Hj = this.kAg.Hj(this.kAE);
        if (f2 > 0.0f) {
            this.kAC.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kAC.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Hj)) {
            this.kAz.setText(new StringBuilder().append(Hj).append("/").append(this.kAg.Hj(this.gdn.getDuration())));
        }
        this.kAg.setCurrentDuration(this.kAE, z ? false : true);
        duk();
        dtZ();
    }

    protected View aw(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Hc(int i2) {
        this.mch = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alT = str2;
    }

    public void setFid(String str) {
        this.fsZ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        int i2 = 100;
        if (this.gdn != null && this.kAg != null) {
            this.kAg.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.duF().Qt(this.mVideoUrl);
            if (this.mcI) {
                this.gdn.setVolume(1.0f, 1.0f);
                this.gdn.start();
                this.mcI = false;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aak);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.aak, 20L);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAP);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mcP);
                if (this.gdn.duM()) {
                    this.currentState = 1;
                    duk();
                }
                this.mStartPosition = com.baidu.tieba.play.n.duF().Qt(this.mVideoUrl);
                this.kAg.setPlayer(this.gdn);
                if (this.mStartPosition != 0) {
                    this.mcC = true;
                }
                if (!this.mcH) {
                    this.kAg.showProgress();
                }
                if (!this.mcl && this.gdn.getDuration() <= 0) {
                    cXj().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gdn.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aaf = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.alJ.getVisibility() != 8 || !this.aae) {
            this.aae = true;
            this.kAh.setVisibility(8);
            this.hUJ.setVisibility(8);
            this.fzK.duA();
            this.alJ.setVisibility(8);
            dul();
            this.kAg.showProgress();
            this.mcb.setVisibility(0);
            if (this.kAr != null) {
                this.kAr.onPrepared();
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

    protected void wb(boolean z) {
        if (hasNavBar(this.mActivity) && (this.mcc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mcc.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mcc.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mcc.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mcc.setLayoutParams(layoutParams);
        }
    }

    public void dnT() {
        if (this.gdn.isPlaying()) {
            aNl();
            if (this.mcz != null) {
                this.mcz.onPause();
            }
            if (this.mcq != null) {
                this.mcq.onPaused();
            }
        } else if (this.aae) {
            aNm();
            if (this.lFG != null) {
                this.lFG.cyH();
            }
            if (this.mcq != null) {
                this.mcq.duq();
            }
        } else {
            dud();
        }
    }

    public void QI() {
        this.kAM = true;
        if (this.kAH != null) {
            this.kAH.QI();
        }
    }

    public boolean dtV() {
        return this.gdn != null && this.gdn.getView().getHeight() > this.gdn.getView().getWidth();
    }

    public void dtW() {
        wb(false);
        dtY();
    }

    public boolean Hd(int i2) {
        switch (i2) {
            case 4:
                if (this.aap) {
                    if (dtV()) {
                        wb(false);
                        dtY();
                    } else {
                        QI();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kAD <= 0 || this.kAA == null) {
                    return false;
                }
                this.kAJ = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kAJ * 100.0d) / this.kAD);
                this.kAA.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gdn;
    }

    public VideoListMediaControllerView cXj() {
        return this.kAg;
    }

    public void show() {
        this.kAe.setVisibility(0);
    }

    public void cXn() {
        if (this.kAp != null) {
            ViewGroup.LayoutParams layoutParams = this.kAp.getLayoutParams();
            this.kAj = (FrameLayout.LayoutParams) this.kAe.getLayoutParams();
            this.kAj.width = layoutParams.width;
            this.kAj.height = layoutParams.height;
            this.kAj.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.kAe.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.kAe.setLayoutParams(this.kAj);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kAM) {
            if (this.aap) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.kAM = false;
        }
        if (configuration.orientation == 2) {
            dtX();
        } else {
            dtY();
        }
        dtZ();
        if (this.mActivity == com.baidu.adp.base.a.lg().currentActivity()) {
            aNm();
        }
        dum();
        cXv();
        if (this.mcv != null) {
            this.mcv.qq(true);
        }
    }

    protected void dtX() {
        this.aap = true;
        this.kAe.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bAW().ey(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bAW().ez(this.mActivity))));
        j(this.mActivity, true);
        this.byQ.setVisibility(0);
        this.gHE.setVisibility(0);
        this.kAt.setVisibility(0);
        this.kAi.setVisibility(8);
        this.fzK.duB();
        this.alJ.setVisibility(8);
        this.kAm.setImageResource(R.drawable.icon_video_narrow_white);
        DT(this.kAI);
        cXi();
        if (this.mcn != null) {
            this.mcn.rI();
        }
    }

    protected void dtY() {
        this.aap = false;
        if (this.kAj != null) {
            this.kAe.setLayoutParams(this.kAj);
        }
        j(this.mActivity, false);
        this.byQ.setVisibility(8);
        this.kAi.setVisibility(0);
        this.fzK.duB();
        this.alJ.setVisibility(8);
        this.kAm.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kAg != null && (this.kAg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kAg.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kAg.setLayoutParams(layoutParams);
        }
        this.kAe.setSystemUiVisibility(0);
        dtU();
        if (this.mcn != null) {
            this.mcn.rJ();
        }
    }

    public void dtZ() {
        if (this.gdn != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.aap) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mcb.setMax(equipmentWidth);
            int duration = this.gdn.getDuration();
            if (duration > 0) {
                if (this.mce.getVisibility() == 0) {
                    this.mcb.setProgress(this.mcb.getMax());
                } else {
                    this.mcb.setProgress((int) ((this.gdn.getCurrentPositionSync() * this.mcb.getMax()) / duration));
                }
            }
        }
    }

    private void DT(int i2) {
        if (this.kAg != null && (this.kAg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kAg.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kAg.setLayoutParams(layoutParams);
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

    public boolean cXp() {
        return !this.aap;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kAr = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mci = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mcj = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.mcD) {
            fX(str, str2);
        } else {
            fW(str, str2);
        }
        if (eVar != null) {
            eVar.wj(z);
        }
    }

    public void fV(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, boolean z) {
        due();
        this.mcI = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gdn.setVideoDuration(this.mch);
        this.gdn.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAP);
        if (this.mcp > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kAP, this.mcp);
        }
        if (this.mcq != null) {
            this.mcq.onStarted();
        }
        this.fzK.startLoading();
        wc(z);
    }

    public void fW(String str, String str2) {
        A(str, str2, true);
    }

    public void fX(String str, String str2) {
        due();
        this.mcI = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAP);
        if (this.mcp > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kAP, this.mcp);
        }
        if (this.mcq != null) {
            this.mcq.onStarted();
        }
        this.fzK.startLoading();
        wc(true);
    }

    public void dua() {
        aNm();
        this.mcb.setVisibility(0);
    }

    public void aNm() {
        int i2 = 100;
        if (this.gdn != null && this.kAg != null) {
            this.aae = true;
            this.currentState = 1;
            this.gdn.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.duF().Qt(this.mVideoUrl);
            this.mcC = true;
            if (this.mStartPosition > 100 && this.gdn.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aaf = i2;
            this.fzK.duB();
            wc(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mcG && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alT)) {
            this.mcG = false;
            this.mcH = true;
            fW(this.mVideoUrl, this.alT);
        }
    }

    private void wc(boolean z) {
        if (z) {
            this.alJ.setVisibility(0);
            duk();
            this.mcb.setProgress(0);
        } else {
            this.alJ.setVisibility(8);
            duk();
        }
        this.kAg.showProgress();
        this.kAh.setVisibility(8);
        this.mcf.setVisibility(8);
        this.mce.setVisibility(8);
        this.mcg.setVisibility(8);
        this.hUJ.setVisibility(8);
    }

    private void dub() {
        this.fzK.duB();
        this.mcf.setVisibility(8);
        this.mce.setVisibility(8);
        this.mcg.setVisibility(8);
        dum();
    }

    public void aNl() {
        this.gdn.pause();
        this.currentState = 2;
        dub();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aak);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mcP);
        this.gdn.stopPlayback();
        this.aae = false;
        this.mcI = false;
        this.mStartPosition = 0;
        cJS();
    }

    public void duc() {
        if (this.gdn.getDuration() >= this.gdn.getCurrentPosition()) {
            com.baidu.tieba.play.n.duF().bA(this.mVideoUrl, this.gdn.getCurrentPositionSync());
        }
    }

    public void wd(boolean z) {
        this.mcB = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(boolean z) {
        if (this.kAn != null) {
            this.kAh.setVisibility(0);
            this.mcf.setVisibility(8);
            this.mce.setVisibility(8);
            this.mcg.setVisibility(8);
            this.fzK.duB();
            duk();
            this.mcb.setVisibility(8);
            this.hUJ.setVisibility(8);
            this.kAg.aNA();
            this.alJ.setVisibility(z ? 0 : 8);
        }
    }

    public void cJS() {
        we(true);
    }

    public boolean rK() {
        if (this.gdn == null) {
            return false;
        }
        return this.gdn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gdn == null) {
            return 0;
        }
        return this.gdn.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mct = kVar;
    }

    public void a(j jVar) {
        this.mcs = jVar;
    }

    public void a(i iVar) {
        this.lFG = iVar;
    }

    public void a(g gVar) {
        this.mcz = gVar;
    }

    public void a(h hVar) {
        this.mcr = hVar;
    }

    public void PS(String str) {
        this.lFg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dud() {
        a(this.mVideoUrl, this.alT, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mco = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        due();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dLS().dLT()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.mcD = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mcy != null) {
                    this.mcy.pK(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Ba(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.duf();
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
                aVar.b(this.eCn).bmC();
                return;
            } else if (this.mcy != null) {
                this.mcy.pK(true);
                return;
            } else {
                if (!this.mca) {
                    this.mca = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.mcx != null) {
            this.mcx.cyE();
        }
    }

    private void due() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dLS().fW(this.mActivity);
        }
    }

    public void duf() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.alJ.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAT);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aak);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mcO);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mcP);
        this.kAH.stop();
        kAL.unregister(this.mActivity);
    }

    public void Qs(String str) {
        this.kAt.setText(str);
    }

    public boolean cXr() {
        return this.aae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dug() {
        if (this.kAn != null) {
            if (this.mck) {
                duk();
            } else {
                duj();
            }
        }
    }

    public void cXv() {
        duj();
        duh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duh() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAT);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.kAT, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dui() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAT);
    }

    public void duj() {
        if (this.kAn != null && !this.mck && !this.mcM) {
            wf(true);
            cXu();
            this.kAn.setVisibility(0);
            this.mcc.setVisibility(0);
            this.mcb.setVisibility(8);
            this.mck = true;
            if (this.mco != null) {
                this.mco.pL(false);
            }
        }
    }

    public void cXs() {
        if (this.kAn != null && this.mck) {
            wf(false);
            cXu();
            this.kAn.setVisibility(8);
            this.mcc.setVisibility(8);
            this.mcb.setVisibility(0);
            this.iII.setAnimationListener(this.kAR);
            this.kAn.startAnimation(this.iII);
            this.mck = false;
            if (this.mco != null) {
                this.mco.cyG();
            }
        }
    }

    public void duk() {
        if (this.kAn != null && this.mck) {
            this.bSB.cancel();
            this.iII.cancel();
            wf(false);
            cXu();
            this.kAn.setVisibility(8);
            this.mcc.setVisibility(8);
            this.mcb.setVisibility(0);
            this.mck = false;
            if (this.mco != null) {
                this.mco.cyG();
            }
        }
    }

    private void cXu() {
        if (this.kAn != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kAT);
            this.bSB.setAnimationListener(null);
            this.iII.setAnimationListener(null);
            this.kAn.clearAnimation();
        }
    }

    private void dul() {
        if (this.kAn != null) {
            this.bSB.setAnimationListener(null);
            this.iII.setAnimationListener(null);
            this.kAn.clearAnimation();
        }
    }

    public void wf(boolean z) {
        dum();
        if (z) {
            this.mcd.setVisibility(0);
        } else {
            this.mcd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dum() {
        if (this.currentState == 1) {
            this.mcd.setState(1);
        } else {
            this.mcd.setState(0);
        }
    }

    public void a(InterfaceC0812c interfaceC0812c) {
        this.mcn = interfaceC0812c;
    }

    public void DW(int i2) {
        this.mStartPosition = i2;
    }

    public void ay(boolean z, boolean z2) {
        if (this.kAH != null) {
            if (this.kAm != null) {
                this.kAm.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kAg != null && (this.kAg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kAg.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kAg.setLayoutParams(layoutParams);
            }
            this.kAH.cD(z);
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

    public void wg(boolean z) {
        this.mcL = z;
    }

    public void a(m mVar) {
        this.mcu = mVar;
    }

    public void a(a aVar) {
        this.mcv = aVar;
    }

    public void a(n nVar) {
        this.mcw = nVar;
    }

    public void a(l lVar) {
        this.mcx = lVar;
    }

    public void a(f fVar) {
        this.mcy = fVar;
    }

    public void wh(boolean z) {
        this.mcF = z;
    }

    public void wi(boolean z) {
        this.mcl = z;
    }

    public void He(int i2) {
        this.mcJ = i2;
    }

    public View dun() {
        return this.kAe;
    }

    public void a(p pVar) {
        this.lFu = pVar;
    }

    public void duo() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eCn.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eCn.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gdn != null) {
            this.gdn.setStageType(str);
        }
    }
}
