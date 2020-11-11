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
    private static int kGE;
    private static CallStateReceiver kGF;
    private TbImageView alJ;
    private String alT;
    private View bFb;
    private Animation bYl;
    private TbPageContext<?> eIc;
    private com.baidu.tieba.play.m fFA;
    private String fyR;
    private ImageView gNq;
    protected TbCyberVideoView gjd;
    private Animation iOF;
    protected View iaG;
    public View kFY;
    private com.baidu.tieba.play.j kGB;
    private int kGD;
    private VideoListMediaControllerView kGa;
    private View kGb;
    private FrameLayout kGc;
    protected FrameLayout.LayoutParams kGd;
    private ImageView kGg;
    private View kGh;
    private View kGj;
    private CyberPlayerManager.OnPreparedListener kGl;
    private TextView kGn;
    private View kGr;
    private View kGs;
    private TextView kGt;
    private SeekBar kGu;
    private ImageView kGv;
    private ImageView kGw;
    private int kGx;
    private i lLC;
    private p lLq;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private ProgressBar mhY;
    private View mhZ;
    private TextView miD;
    private boolean miF;
    private boolean miG;
    private boolean miH;
    private int miI;
    private boolean miJ;
    private boolean miK;
    private SwitchImageView mia;
    private TextView mib;
    private TextView mic;
    private TextView mie;
    private int mif;
    private CyberPlayerManager.OnCompletionListener mig;
    private CyberPlayerManager.OnErrorListener mih;
    private View.OnClickListener mik;
    protected InterfaceC0827c mil;
    private d mim;
    private o mip;
    private h miq;
    private j mir;
    private k mis;
    private m mit;
    private a miu;
    private n miv;
    private l miw;
    private f mix;
    private g miy;
    private int aaf = 100;
    private boolean mhX = false;
    protected boolean aap = false;
    private boolean aae = false;
    private boolean mii = false;
    private boolean mij = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kGy = 0;
    private int kGz = 0;
    private long mio = 60000;
    private int kGC = 0;
    private boolean kGG = false;
    private boolean miz = true;
    private boolean miA = true;
    private boolean miB = false;
    private boolean miC = false;
    private String lLc = null;
    private int currentState = -1;
    private boolean miE = false;
    private boolean miL = false;
    private boolean miM = false;
    private CyberPlayerManager.OnPreparedListener eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kGa != null && c.this.gjd != null && c.this.gjd.getDuration() > 0) {
                c.this.kGa.bz(0, c.this.gjd.getDuration());
            }
            c.this.cnY();
            if (c.this.mip != null) {
                c.this.mip.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rZ();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hXS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.cnY();
        }
    };
    private Runnable aak = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aak);
            if (c.this.alJ.getVisibility() != 8) {
                if (c.this.gjd.getCurrentPosition() > c.this.aaf) {
                    c.this.rZ();
                } else {
                    com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aak, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.gjd != null) {
                int duration = c.this.gjd.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.aae = false;
                    c.this.miH = false;
                    c.this.mStartPosition = 0;
                    c.this.cZG();
                    c.this.kGb.setVisibility(0);
                    c.this.mhY.setProgress(c.this.mhY.getMax());
                    c.this.aaf = 100;
                    if (c.this.mig != null) {
                        c.this.mig.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.wn(false);
                        c.this.wo(true);
                    } else {
                        c.this.dwM();
                        c.this.mib.setVisibility(0);
                    }
                    if (!c.this.aap && duration <= 150000) {
                        if (!c.this.miE) {
                            if (c.this.mir != null) {
                                c.this.mir.vr(true);
                            }
                            c.this.B(c.this.mVideoUrl, c.this.alT, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.gjd.pause();
                            c.this.gjd.seekTo(0);
                        }
                    }
                    if (c.this.mip != null) {
                        c.this.mip.Hs(c.this.mhY.getMax());
                        c.this.mip.IH();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.iaG.setVisibility(0);
            c.this.fFA.dxd();
            c.this.currentState = 4;
            if (c.this.mih != null) {
                c.this.mih.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.miF = true;
            }
            if (c.this.mip != null) {
                c.this.mip.dwR();
            }
            c.this.miH = false;
            return true;
        }
    };
    protected Runnable kGJ = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gjd == null || !c.this.gjd.isPlaying()) {
                c.this.iaG.setVisibility(0);
                c.this.fFA.dxd();
                if (c.this.mip != null) {
                    c.this.mip.dwR();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener eol = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.miB) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.miN, 200L);
            }
        }
    };
    private Runnable miN = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gjd == null || !c.this.miB) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aak, 200L);
                c.this.miB = false;
            } else if (c.this.mStartPosition != c.this.gjd.getCurrentPosition()) {
                c.this.miB = false;
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aak, 20L);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.miN, 200L);
            }
        }
    };
    private TbCyberVideoView.a fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.aae = false;
            if (c.this.mij) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.miO, 300L);
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aak);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.kGJ);
        }
    };
    private Runnable miO = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.miH = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.lLq != null) {
                c.this.lLq.dqC();
            }
            if (view.getId() != c.this.iaG.getId()) {
                if (view.getId() != c.this.mia.getId()) {
                    if (view.getId() == c.this.mic.getId()) {
                        if (c.this.miq != null) {
                            c.this.miq.dqD();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.mib.getId()) {
                        if (c.this.mir != null) {
                            c.this.mir.vr(false);
                        }
                        c.this.fW(c.this.mVideoUrl, c.this.alT);
                        return;
                    } else if (view.getId() == c.this.kGg.getId()) {
                        int i2 = c.this.mij ? 1 : 2;
                        if (c.this.aap) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dR("tid", c.this.alT).dR("fid", c.this.fyR).al("obj_type", i2).al("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dR("tid", c.this.alT).dR("fid", c.this.fyR).al("obj_type", i2).al("obj_source", 1));
                        }
                        if (c.this.miw != null) {
                            c.this.miw.cBg();
                        }
                        if (c.this.dwx()) {
                            if (c.this.aap) {
                                c.this.dwA();
                            } else {
                                c.this.dwz();
                            }
                            c.this.wk(c.this.aap);
                            return;
                        }
                        c.this.Tq();
                        return;
                    } else if (view.getId() != c.this.gNq.getId()) {
                        if (c.this.mik != null) {
                            c.this.mik.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.miw != null) {
                            c.this.miw.cBg();
                        }
                        if (c.this.dwx()) {
                            c.this.dwA();
                            c.this.wk(false);
                            return;
                        }
                        c.this.Tq();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.dqv();
                c.this.dwO();
                if (c.this.currentState != 1) {
                    c.this.dwK();
                    c.this.dwL();
                } else {
                    c.this.cZW();
                }
                if (c.this.miu != null) {
                    c.this.miu.qz(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.gjd.stopPlayback();
            c.this.aae = false;
            c.this.dwF();
        }
    };
    private Animation.AnimationListener kGL = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kGM = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kGN = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cZT();
        }
    };
    private CustomMessageListener kGO = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aPL();
            }
        }
    };
    private VideoControllerView.b kIH = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tp(int i2) {
            int duration;
            if (c.this.gjd != null && (duration = c.this.gjd.getDuration()) > 0 && c.this.mhY != null) {
                c.this.mhY.setProgress((int) ((i2 * c.this.kFY.getWidth()) / duration));
                if (c.this.mip != null) {
                    c.this.mip.Hs((c.this.gjd.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fSR = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.dwK();
            c.this.wo(false);
            if (c.this.miu != null) {
                c.this.miu.qz(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cZK() != null) {
                c.this.Ej(c.this.cZK().getSeekPosition());
                if (!c.this.cZS()) {
                    c.this.dwF();
                } else {
                    c.this.aPM();
                    if (c.this.lLC != null) {
                        c.this.lLC.cBi();
                    }
                }
            }
            c.this.wo(true);
            c.this.dwJ();
            if (c.this.miu != null) {
                c.this.miu.qz(true);
            }
            if (c.this.miv != null) {
                c.this.miv.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qz(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0827c {
        void rI();

        void rJ();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cBh();

        void pU(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void ws(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void pT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dqD();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cBi();
    }

    /* loaded from: classes.dex */
    public interface j {
        void vr(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cBf();

        void cBg();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dqE();

        boolean dqF();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void Hs(int i);

        void IH();

        void dwR();

        void dwS();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dqC();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.miJ = true;
        if (tbPageContext != null) {
            this.eIc = tbPageContext;
            this.mRootView = view;
            this.miJ = z;
            this.kGj = view;
            this.mActivity = this.eIc.getPageActivity();
            init();
        }
    }

    public void init() {
        this.kFY = aw(this.mActivity);
        this.kFY.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.kFY);
        }
        this.gjd = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.kFY).addView(this.gjd.getView(), 0);
        this.gjd.getView().setLayoutParams(layoutParams);
        this.fFA = new com.baidu.tieba.play.m((ViewGroup) this.kFY.findViewById(R.id.auto_video_loading_container));
        this.fFA.setLoadingAnimationListener(this.hXS);
        this.kGa = (VideoListMediaControllerView) this.kFY.findViewById(R.id.media_controller);
        this.kGa.setPlayer(this.gjd);
        this.mhY = (ProgressBar) this.kFY.findViewById(R.id.pgrBottomProgress);
        this.mhY.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mhY.setProgress(0);
        this.kGa.setOnSeekBarChangeListener(this.fSR);
        this.kGa.setOnProgressUpdatedListener(this.kIH);
        this.kGb = this.kFY.findViewById(R.id.black_mask);
        this.iaG = this.kFY.findViewById(R.id.layout_error);
        this.iaG.setOnClickListener(this.mOnClickListener);
        this.miD = (TextView) this.kFY.findViewById(R.id.auto_video_error_tips);
        this.kGc = (FrameLayout) this.kFY.findViewById(R.id.danmu_container);
        this.kGg = (ImageView) this.kFY.findViewById(R.id.img_full_screen);
        this.kGg.setOnClickListener(this.mOnClickListener);
        this.kGh = this.kFY.findViewById(R.id.layout_media_controller);
        this.mhZ = this.kFY.findViewById(R.id.time_show_controller);
        this.gjd.setContinuePlayEnable(true);
        this.gjd.setOnPreparedListener(this.eog);
        this.gjd.setOnCompletionListener(this.eoi);
        this.gjd.setOnErrorListener(this.kGI);
        this.gjd.setOnSeekCompleteListener(this.eol);
        this.gjd.setOnInfoListener(this.eoj);
        this.gjd.setOnSurfaceDestroyedListener(this.fFI);
        this.mia = (SwitchImageView) this.kFY.findViewById(R.id.img_play_controller);
        this.mia.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.mia.setState(0);
        this.mia.setOnClickListener(this.mOnClickListener);
        this.mib = (TextView) this.kFY.findViewById(R.id.txt_replay);
        this.mib.setOnClickListener(this.mOnClickListener);
        this.mic = (TextView) this.kFY.findViewById(R.id.txt_playnext);
        this.mic.setOnClickListener(this.mOnClickListener);
        this.mie = (TextView) this.kFY.findViewById(R.id.txt_next_video_title);
        this.alJ = (TbImageView) this.kFY.findViewById(R.id.video_thumbnail);
        this.alJ.setDefaultErrorResource(0);
        this.alJ.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gNq = (ImageView) this.kFY.findViewById(R.id.img_exit);
        this.gNq.setOnClickListener(this.mOnClickListener);
        this.kGn = (TextView) this.kFY.findViewById(R.id.video_title);
        this.bFb = this.kFY.findViewById(R.id.layout_title);
        this.bFb.setVisibility(8);
        this.iOF = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bYl = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.kGx = this.mAudioManager.getStreamMaxVolume(3);
        this.kGD = this.mAudioManager.getStreamVolume(3);
        kGE = 100 / this.kGx;
        this.kFY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.mis != null) {
                    c.this.mis.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.aae) {
                        if (c.this.mStatus == 1 && c.this.kGz != 0) {
                            c.this.b(c.this.kGz == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kGz = 0;
                            c.this.kGy = 0;
                        }
                        if (!c.this.gjd.isPlaying()) {
                            c.this.mic.setVisibility(8);
                            c.this.mib.setVisibility(8);
                            c.this.mie.setVisibility(8);
                        }
                    }
                    c.this.cZG();
                    if (c.this.mis != null) {
                        c.this.mis.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kGB = new com.baidu.tieba.play.j(this.mActivity);
        if (this.miJ) {
            this.kGB.start();
        }
        this.kGC = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kGF == null) {
            kGF = new CallStateReceiver();
        }
        kGF.register(this.mActivity);
        dww();
        MessageManager.getInstance().registerListener(this.kGO);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kGO);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void Ho(int i2) {
        if (this.alJ != null) {
            this.alJ.setDefaultBgResource(i2);
        }
    }

    public void dww() {
        if (this.miz) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.kFY.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.kFY.setSystemUiVisibility(0);
    }

    public void wi(boolean z) {
        this.miz = z;
        dww();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZG() {
        this.mStatus = 0;
        if (this.kGr != null && this.kGr.getParent() != null && (this.kGr.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kGr.getParent()).removeView(this.kGr);
                this.kGr = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kGs != null && this.kGs.getParent() != null && (this.kGs.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kGs.getParent()).removeView(this.kGs);
                this.kGs = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cZH() {
        if (this.mStatus == 1) {
            if (this.kGr == null && this.kFY != null && (this.kFY instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.kFY, true);
                this.kGr = this.kFY.findViewById(R.id.lay_jindu);
                this.kGt = (TextView) this.kGr.findViewById(R.id.show_time);
                this.kGw = (ImageView) this.kGr.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kGs == null && this.kFY != null && (this.kFY instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.kFY, true);
            this.kGs = this.kFY.findViewById(R.id.lay_voice);
            this.kGv = (ImageView) this.kGs.findViewById(R.id.arrow_voice_icon);
            this.kGu = (SeekBar) this.kGs.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ac(View.OnClickListener onClickListener) {
        this.mik = onClickListener;
    }

    public void wj(boolean z) {
        this.mij = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.mis != null) {
                c.this.mis.onStart();
            }
            if (c.this.aap && c.this.aae) {
                if (c.this.mStatus == 1) {
                    c.this.dwM();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aE(f2);
                    }
                } else {
                    if (c.this.aap) {
                        c.this.cZJ();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kGy = c.this.gjd.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aE(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.miK) {
                if (c.this.mit != null && c.this.mit.dqE()) {
                    return true;
                }
                c.this.dqv();
                c.this.dwO();
                if (c.this.gjd.isPlaying()) {
                    c.this.dwJ();
                } else {
                    c.this.dwK();
                }
                if (c.this.miu != null) {
                    c.this.miu.qz(c.this.gjd.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.miK) {
                if (c.this.aae) {
                    if (c.this.mit != null && c.this.mit.dqF()) {
                        return true;
                    }
                    c.this.dwI();
                    if (c.this.gjd.isPlaying()) {
                        c.this.dwJ();
                    } else {
                        c.this.dwK();
                    }
                    if (c.this.miu != null) {
                        c.this.miu.qz(c.this.gjd.isPlaying());
                    }
                } else {
                    c.this.dqv();
                    c.this.dwO();
                    if (c.this.currentState != 1) {
                        c.this.dwK();
                        c.this.dwL();
                    } else {
                        c.this.cZW();
                    }
                    if (c.this.miu != null) {
                        c.this.miu.qz(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZJ() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kFY.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kFY.setSystemUiVisibility(4);
        } else {
            this.kFY.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(float f2) {
        if (!this.aae) {
            this.mStatus = 0;
            return;
        }
        if (kGE == 0) {
            this.kGx = this.mAudioManager.getStreamMaxVolume(3);
            kGE = 100 / this.kGx;
            if (kGE == 0) {
                kGE = 1;
            }
        }
        cZH();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kGE == 0) {
            if (f2 > 0.0f && this.kGD < this.kGx) {
                this.kGD++;
            }
            if (f2 < 0.0f && this.kGD > 0) {
                this.kGD--;
            }
        }
        if (this.mProgress > 0) {
            this.kGv.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kGv.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kGD, 0);
        this.kGu.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kGy -= 1000;
                this.kGz = 1;
            } else {
                this.kGy += 1000;
                this.kGz = 2;
            }
            if (this.kGy < 0) {
                this.kGy = 0;
            } else if (this.kGy > this.gjd.getDuration()) {
                this.kGy = this.gjd.getDuration();
            }
        }
        cZH();
        String Hw = this.kGa.Hw(this.kGy);
        if (f2 > 0.0f) {
            this.kGw.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kGw.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Hw)) {
            this.kGt.setText(new StringBuilder().append(Hw).append("/").append(this.kGa.Hw(this.gjd.getDuration())));
        }
        this.kGa.setCurrentDuration(this.kGy, z ? false : true);
        dwM();
        dwB();
    }

    protected View aw(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void Hp(int i2) {
        this.mif = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alT = str2;
    }

    public void setFid(String str) {
        this.fyR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnY() {
        int i2 = 100;
        if (this.gjd != null && this.kGa != null) {
            this.kGa.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dxh().QK(this.mVideoUrl);
            if (this.miH) {
                this.gjd.setVolume(1.0f, 1.0f);
                this.gjd.start();
                this.miH = false;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aak);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.aak, 20L);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGJ);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.miO);
                if (this.gjd.dxo()) {
                    this.currentState = 1;
                    dwM();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dxh().QK(this.mVideoUrl);
                this.kGa.setPlayer(this.gjd);
                if (this.mStartPosition != 0) {
                    this.miB = true;
                }
                if (!this.miG) {
                    this.kGa.showProgress();
                }
                if (!this.mij && this.gjd.getDuration() <= 0) {
                    cZK().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.gjd.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aaf = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.alJ.getVisibility() != 8 || !this.aae) {
            this.aae = true;
            this.kGb.setVisibility(8);
            this.iaG.setVisibility(8);
            this.fFA.dxc();
            this.alJ.setVisibility(8);
            dwN();
            this.kGa.showProgress();
            this.mhY.setVisibility(0);
            if (this.kGl != null) {
                this.kGl.onPrepared();
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

    protected void wk(boolean z) {
        if (hasNavBar(this.mActivity) && (this.mhZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mhZ.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.mhZ.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.mhZ.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.mhZ.setLayoutParams(layoutParams);
        }
    }

    public void dqv() {
        if (this.gjd.isPlaying()) {
            aPL();
            if (this.miy != null) {
                this.miy.onPause();
            }
            if (this.mip != null) {
                this.mip.onPaused();
            }
        } else if (this.aae) {
            aPM();
            if (this.lLC != null) {
                this.lLC.cBi();
            }
            if (this.mip != null) {
                this.mip.dwS();
            }
        } else {
            dwF();
        }
    }

    public void Tq() {
        this.kGG = true;
        if (this.kGB != null) {
            this.kGB.Tq();
        }
    }

    public boolean dwx() {
        return this.gjd != null && this.gjd.getView().getHeight() > this.gjd.getView().getWidth();
    }

    public void dwy() {
        wk(false);
        dwA();
    }

    public boolean Hq(int i2) {
        switch (i2) {
            case 4:
                if (this.aap) {
                    if (dwx()) {
                        wk(false);
                        dwA();
                    } else {
                        Tq();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kGx <= 0 || this.kGu == null) {
                    return false;
                }
                this.kGD = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kGD * 100.0d) / this.kGx);
                this.kGu.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gjd;
    }

    public VideoListMediaControllerView cZK() {
        return this.kGa;
    }

    public void show() {
        this.kFY.setVisibility(0);
    }

    public void cZO() {
        if (this.kGj != null) {
            ViewGroup.LayoutParams layoutParams = this.kGj.getLayoutParams();
            this.kGd = (FrameLayout.LayoutParams) this.kFY.getLayoutParams();
            this.kGd.width = layoutParams.width;
            this.kGd.height = layoutParams.height;
            this.kGd.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.kFY.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.kFY.setLayoutParams(this.kGd);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kGG) {
            if (this.aap) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.kGG = false;
        }
        if (configuration.orientation == 2) {
            dwz();
        } else {
            dwA();
        }
        dwB();
        if (this.mActivity == com.baidu.adp.base.a.lg().currentActivity()) {
            aPM();
        }
        dwO();
        cZW();
        if (this.miu != null) {
            this.miu.qz(true);
        }
    }

    protected void dwz() {
        this.aap = true;
        this.kFY.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bDv().ey(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bDv().ez(this.mActivity))));
        j(this.mActivity, true);
        this.bFb.setVisibility(0);
        this.gNq.setVisibility(0);
        this.kGn.setVisibility(0);
        this.kGc.setVisibility(8);
        this.fFA.dxd();
        this.alJ.setVisibility(8);
        this.kGg.setImageResource(R.drawable.icon_video_narrow_white);
        Eg(this.kGC);
        cZJ();
        if (this.mil != null) {
            this.mil.rI();
        }
    }

    protected void dwA() {
        this.aap = false;
        if (this.kGd != null) {
            this.kFY.setLayoutParams(this.kGd);
        }
        j(this.mActivity, false);
        this.bFb.setVisibility(8);
        this.kGc.setVisibility(0);
        this.fFA.dxd();
        this.alJ.setVisibility(8);
        this.kGg.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kGa != null && (this.kGa.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGa.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kGa.setLayoutParams(layoutParams);
        }
        this.kFY.setSystemUiVisibility(0);
        dww();
        if (this.mil != null) {
            this.mil.rJ();
        }
    }

    public void dwB() {
        if (this.gjd != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.aap) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mhY.setMax(equipmentWidth);
            int duration = this.gjd.getDuration();
            if (duration > 0) {
                if (this.mib.getVisibility() == 0) {
                    this.mhY.setProgress(this.mhY.getMax());
                } else {
                    this.mhY.setProgress((int) ((this.gjd.getCurrentPositionSync() * this.mhY.getMax()) / duration));
                }
            }
        }
    }

    private void Eg(int i2) {
        if (this.kGa != null && (this.kGa.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGa.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kGa.setLayoutParams(layoutParams);
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

    public boolean cZQ() {
        return !this.aap;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kGl = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.mig = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.mih = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.miC) {
            fX(str, str2);
        } else {
            fW(str, str2);
        }
        if (eVar != null) {
            eVar.ws(z);
        }
    }

    public void fV(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, boolean z) {
        dwG();
        this.miH = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.gjd.setVideoDuration(this.mif);
        this.gjd.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGJ);
        if (this.mio > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kGJ, this.mio);
        }
        if (this.mip != null) {
            this.mip.onStarted();
        }
        this.fFA.startLoading();
        wl(z);
    }

    public void fW(String str, String str2) {
        B(str, str2, true);
    }

    public void fX(String str, String str2) {
        dwG();
        this.miH = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGJ);
        if (this.mio > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kGJ, this.mio);
        }
        if (this.mip != null) {
            this.mip.onStarted();
        }
        this.fFA.startLoading();
        wl(true);
    }

    public void dwC() {
        aPM();
        this.mhY.setVisibility(0);
    }

    public void aPM() {
        int i2 = 100;
        if (this.gjd != null && this.kGa != null) {
            this.aae = true;
            this.currentState = 1;
            this.gjd.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dxh().QK(this.mVideoUrl);
            this.miB = true;
            if (this.mStartPosition > 100 && this.gjd.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aaf = i2;
            this.fFA.dxd();
            wl(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.miF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alT)) {
            this.miF = false;
            this.miG = true;
            fW(this.mVideoUrl, this.alT);
        }
    }

    private void wl(boolean z) {
        if (z) {
            this.alJ.setVisibility(0);
            dwM();
            this.mhY.setProgress(0);
        } else {
            this.alJ.setVisibility(8);
            dwM();
        }
        this.kGa.showProgress();
        this.kGb.setVisibility(8);
        this.mic.setVisibility(8);
        this.mib.setVisibility(8);
        this.mie.setVisibility(8);
        this.iaG.setVisibility(8);
    }

    private void dwD() {
        this.fFA.dxd();
        this.mic.setVisibility(8);
        this.mib.setVisibility(8);
        this.mie.setVisibility(8);
        dwO();
    }

    public void aPL() {
        this.gjd.pause();
        this.currentState = 2;
        dwD();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aak);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGJ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.miO);
        this.gjd.stopPlayback();
        this.aae = false;
        this.miH = false;
        this.mStartPosition = 0;
        cMt();
    }

    public void dwE() {
        if (this.gjd.getDuration() >= this.gjd.getCurrentPosition()) {
            com.baidu.tieba.play.n.dxh().bC(this.mVideoUrl, this.gjd.getCurrentPositionSync());
        }
    }

    public void wm(boolean z) {
        this.miA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn(boolean z) {
        if (this.kGh != null) {
            this.kGb.setVisibility(0);
            this.mic.setVisibility(8);
            this.mib.setVisibility(8);
            this.mie.setVisibility(8);
            this.fFA.dxd();
            dwM();
            this.mhY.setVisibility(8);
            this.iaG.setVisibility(8);
            this.kGa.aQa();
            this.alJ.setVisibility(z ? 0 : 8);
        }
    }

    public void cMt() {
        wn(true);
    }

    public boolean rK() {
        if (this.gjd == null) {
            return false;
        }
        return this.gjd.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gjd == null) {
            return 0;
        }
        return this.gjd.getCurrentPosition();
    }

    public void a(k kVar) {
        this.mis = kVar;
    }

    public void a(j jVar) {
        this.mir = jVar;
    }

    public void a(i iVar) {
        this.lLC = iVar;
    }

    public void a(g gVar) {
        this.miy = gVar;
    }

    public void a(h hVar) {
        this.miq = hVar;
    }

    public void Qj(String str) {
        this.lLc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwF() {
        a(this.mVideoUrl, this.alT, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.mim = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dwG();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dOu().dOv()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.miC = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.mix != null) {
                    this.mix.pT(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dwH();
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
                aVar.b(this.eIc).bpc();
                return;
            } else if (this.mix != null) {
                this.mix.pT(true);
                return;
            } else {
                if (!this.mhX) {
                    this.mhX = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.miw != null) {
            this.miw.cBf();
        }
    }

    private void dwG() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dOu().fW(this.mActivity);
        }
    }

    public void dwH() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.alJ.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGN);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aak);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGJ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.miN);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.miO);
        this.kGB.stop();
        kGF.unregister(this.mActivity);
    }

    public void QJ(String str) {
        this.kGn.setText(str);
    }

    public boolean cZS() {
        return this.aae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwI() {
        if (this.kGh != null) {
            if (this.mii) {
                dwM();
            } else {
                dwL();
            }
        }
    }

    public void cZW() {
        dwL();
        dwJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwJ() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGN);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.kGN, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwK() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGN);
    }

    public void dwL() {
        if (this.kGh != null && !this.mii && !this.miL) {
            wo(true);
            cZV();
            this.kGh.setVisibility(0);
            this.mhZ.setVisibility(0);
            this.mhY.setVisibility(8);
            this.mii = true;
            if (this.mim != null) {
                this.mim.pU(false);
            }
        }
    }

    public void cZT() {
        if (this.kGh != null && this.mii) {
            wo(false);
            cZV();
            this.kGh.setVisibility(8);
            this.mhZ.setVisibility(8);
            this.mhY.setVisibility(0);
            this.iOF.setAnimationListener(this.kGL);
            this.kGh.startAnimation(this.iOF);
            this.mii = false;
            if (this.mim != null) {
                this.mim.cBh();
            }
        }
    }

    public void dwM() {
        if (this.kGh != null && this.mii) {
            this.bYl.cancel();
            this.iOF.cancel();
            wo(false);
            cZV();
            this.kGh.setVisibility(8);
            this.mhZ.setVisibility(8);
            this.mhY.setVisibility(0);
            this.mii = false;
            if (this.mim != null) {
                this.mim.cBh();
            }
        }
    }

    private void cZV() {
        if (this.kGh != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGN);
            this.bYl.setAnimationListener(null);
            this.iOF.setAnimationListener(null);
            this.kGh.clearAnimation();
        }
    }

    private void dwN() {
        if (this.kGh != null) {
            this.bYl.setAnimationListener(null);
            this.iOF.setAnimationListener(null);
            this.kGh.clearAnimation();
        }
    }

    public void wo(boolean z) {
        dwO();
        if (z) {
            this.mia.setVisibility(0);
        } else {
            this.mia.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwO() {
        if (this.currentState == 1) {
            this.mia.setState(1);
        } else {
            this.mia.setState(0);
        }
    }

    public void a(InterfaceC0827c interfaceC0827c) {
        this.mil = interfaceC0827c;
    }

    public void Ej(int i2) {
        this.mStartPosition = i2;
    }

    public void ay(boolean z, boolean z2) {
        if (this.kGB != null) {
            if (this.kGg != null) {
                this.kGg.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kGa != null && (this.kGa.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGa.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kGa.setLayoutParams(layoutParams);
            }
            this.kGB.cK(z);
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

    public void wp(boolean z) {
        this.miK = z;
    }

    public void a(m mVar) {
        this.mit = mVar;
    }

    public void a(a aVar) {
        this.miu = aVar;
    }

    public void a(n nVar) {
        this.miv = nVar;
    }

    public void a(l lVar) {
        this.miw = lVar;
    }

    public void a(f fVar) {
        this.mix = fVar;
    }

    public void wq(boolean z) {
        this.miE = z;
    }

    public void wr(boolean z) {
        this.mij = z;
    }

    public void Hr(int i2) {
        this.miI = i2;
    }

    public View dwP() {
        return this.kFY;
    }

    public void a(p pVar) {
        this.lLq = pVar;
    }

    public void dwQ() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eIc.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eIc.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.gjd != null) {
            this.gjd.setStageType(str);
        }
    }
}
