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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class c {
    private static int kGT;
    private static CallStateReceiver kGU;
    private TbImageView alP;
    private String alZ;
    private View bDq;
    private Animation bWB;
    private TbPageContext<?> eGu;
    private com.baidu.tieba.play.m fFc;
    private String fyg;
    private ImageView gMX;
    protected TbCyberVideoView giK;
    private Animation iPs;
    protected View ibi;
    private CyberPlayerManager.OnPreparedListener kGA;
    private TextView kGC;
    private View kGG;
    private View kGH;
    private TextView kGI;
    private SeekBar kGJ;
    private ImageView kGK;
    private ImageView kGL;
    private int kGM;
    private com.baidu.tieba.play.j kGQ;
    private int kGS;
    public View kGn;
    private VideoListMediaControllerView kGp;
    private View kGq;
    private FrameLayout kGr;
    protected FrameLayout.LayoutParams kGs;
    private ImageView kGv;
    private View kGw;
    private View kGy;
    private p lLI;
    private i lLU;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private CyberPlayerManager.OnCompletionListener miA;
    private CyberPlayerManager.OnErrorListener miB;
    private View.OnClickListener miE;
    protected InterfaceC0829c miF;
    private d miG;
    private o miI;
    private h miJ;
    private j miK;
    private k miL;
    private m miM;
    private a miN;
    private n miO;
    private l miP;
    private f miQ;
    private g miR;
    private TextView miW;
    private boolean miY;
    private boolean miZ;
    private ProgressBar mit;
    private View miu;
    private SwitchImageView miv;
    private TextView miw;
    private TextView mix;
    private TextView miy;
    private int miz;
    private boolean mja;
    private int mjb;
    private boolean mjc;
    private boolean mjd;
    private int aak = 100;
    private boolean mis = false;
    protected boolean aau = false;
    private boolean aaj = false;
    private boolean miC = false;
    private boolean miD = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kGN = 0;
    private int kGO = 0;
    private long miH = 60000;
    private int kGR = 0;
    private boolean kGV = false;
    private boolean miS = true;
    private boolean miT = true;
    private boolean miU = false;
    private boolean miV = false;
    private String lLu = null;
    private int currentState = -1;
    private boolean miX = false;
    private boolean mje = false;
    private boolean mjf = false;
    private CyberPlayerManager.OnPreparedListener emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.kGp != null && c.this.giK != null && c.this.giK.getDuration() > 0) {
                c.this.kGp.bz(0, c.this.giK.getDuration());
            }
            c.this.cnA();
            if (c.this.miI != null) {
                c.this.miI.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener emz = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rZ();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hYs = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.cnA();
        }
    };
    private Runnable aap = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aap);
            if (c.this.alP.getVisibility() != 8) {
                if (c.this.giK.getCurrentPosition() > c.this.aak) {
                    c.this.rZ();
                } else {
                    com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aap, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.giK != null) {
                int duration = c.this.giK.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.aaj = false;
                    c.this.mja = false;
                    c.this.mStartPosition = 0;
                    c.this.cZc();
                    c.this.kGq.setVisibility(0);
                    c.this.mit.setProgress(c.this.mit.getMax());
                    c.this.aak = 100;
                    if (c.this.miA != null) {
                        c.this.miA.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.wq(false);
                        c.this.wr(true);
                    } else {
                        c.this.dwm();
                        c.this.miw.setVisibility(0);
                    }
                    if (!c.this.aau && duration <= 150000) {
                        if (!c.this.miX) {
                            if (c.this.miK != null) {
                                c.this.miK.vu(true);
                            }
                            c.this.B(c.this.mVideoUrl, c.this.alZ, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.giK.pause();
                            c.this.giK.seekTo(0);
                        }
                    }
                    if (c.this.miI != null) {
                        c.this.miI.HQ(c.this.mit.getMax());
                        c.this.miI.HY();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.ibi.setVisibility(0);
            c.this.fFc.dwD();
            c.this.currentState = 4;
            if (c.this.miB != null) {
                c.this.miB.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.miY = true;
            }
            if (c.this.miI != null) {
                c.this.miI.dwr();
            }
            c.this.mja = false;
            return true;
        }
    };
    protected Runnable kGY = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.giK == null || !c.this.giK.isPlaying()) {
                c.this.ibi.setVisibility(0);
                c.this.fFc.dwD();
                if (c.this.miI != null) {
                    c.this.miI.dwr();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener emB = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.miU) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mjg, 200L);
            }
        }
    };
    private Runnable mjg = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.giK == null || !c.this.miU) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aap, 200L);
                c.this.miU = false;
            } else if (c.this.mStartPosition != c.this.giK.getCurrentPosition()) {
                c.this.miU = false;
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aap, 20L);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mjg, 200L);
            }
        }
    };
    private TbCyberVideoView.a fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.aaj = false;
            if (c.this.miD) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.mjh, 300L);
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aap);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.kGY);
        }
    };
    private Runnable mjh = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.mja = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.lLI != null) {
                c.this.lLI.dqc();
            }
            if (view.getId() != c.this.ibi.getId()) {
                if (view.getId() != c.this.miv.getId()) {
                    if (view.getId() == c.this.mix.getId()) {
                        if (c.this.miJ != null) {
                            c.this.miJ.dqd();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.miw.getId()) {
                        if (c.this.miK != null) {
                            c.this.miK.vu(false);
                        }
                        c.this.fW(c.this.mVideoUrl, c.this.alZ);
                        return;
                    } else if (view.getId() == c.this.kGv.getId()) {
                        int i2 = c.this.miD ? 1 : 2;
                        if (c.this.aau) {
                            TiebaStatic.log(new ar("c11714"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.alZ).dR("fid", c.this.fyg).ak("obj_type", i2).ak("obj_source", 2));
                        } else {
                            TiebaStatic.log(new ar("c11710"));
                            TiebaStatic.log(new ar("c13262").dR("tid", c.this.alZ).dR("fid", c.this.fyg).ak("obj_type", i2).ak("obj_source", 1));
                        }
                        if (c.this.miP != null) {
                            c.this.miP.cAJ();
                        }
                        if (c.this.dvX()) {
                            if (c.this.aau) {
                                c.this.dwa();
                            } else {
                                c.this.dvZ();
                            }
                            c.this.wn(c.this.aau);
                            return;
                        }
                        c.this.SH();
                        return;
                    } else if (view.getId() != c.this.gMX.getId()) {
                        if (c.this.miE != null) {
                            c.this.miE.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new ar("c11713"));
                        if (c.this.miP != null) {
                            c.this.miP.cAJ();
                        }
                        if (c.this.dvX()) {
                            c.this.dwa();
                            c.this.wn(false);
                            return;
                        }
                        c.this.SH();
                        return;
                    }
                }
                TiebaStatic.log(new ar("c13255"));
                c.this.dpV();
                c.this.dwo();
                if (c.this.currentState != 1) {
                    c.this.dwk();
                    c.this.dwl();
                } else {
                    c.this.cZs();
                }
                if (c.this.miN != null) {
                    c.this.miN.qC(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.giK.stopPlayback();
            c.this.aaj = false;
            c.this.dwf();
        }
    };
    private Animation.AnimationListener kHa = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kHb = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kHc = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cZp();
        }
    };
    private CustomMessageListener kHd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aPd();
            }
        }
    };
    private VideoControllerView.b kIW = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void tN(int i2) {
            int duration;
            if (c.this.giK != null && (duration = c.this.giK.getDuration()) > 0 && c.this.mit != null) {
                c.this.mit.setProgress((int) ((i2 * c.this.kGn.getWidth()) / duration));
                if (c.this.miI != null) {
                    c.this.miI.HQ((c.this.giK.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fSy = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new ar("c13256"));
            c.this.dwk();
            c.this.wr(false);
            if (c.this.miN != null) {
                c.this.miN.qC(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cZg() != null) {
                c.this.EH(c.this.cZg().getSeekPosition());
                if (!c.this.cZo()) {
                    c.this.dwf();
                } else {
                    c.this.aPe();
                    if (c.this.lLU != null) {
                        c.this.lLU.cAL();
                    }
                }
            }
            c.this.wr(true);
            c.this.dwj();
            if (c.this.miN != null) {
                c.this.miN.qC(true);
            }
            if (c.this.miO != null) {
                c.this.miO.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qC(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0829c {
        void rI();

        void rJ();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cAK();

        void pX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void wv(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void pW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dqd();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cAL();
    }

    /* loaded from: classes.dex */
    public interface j {
        void vu(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cAI();

        void cAJ();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dqe();

        boolean dqf();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void HQ(int i);

        void HY();

        void dwr();

        void dws();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dqc();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.mjc = true;
        if (tbPageContext != null) {
            this.eGu = tbPageContext;
            this.mRootView = view;
            this.mjc = z;
            this.kGy = view;
            this.mActivity = this.eGu.getPageActivity();
            init();
        }
    }

    public void init() {
        this.kGn = av(this.mActivity);
        this.kGn.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.kGn);
        }
        this.giK = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.kGn).addView(this.giK.getView(), 0);
        this.giK.getView().setLayoutParams(layoutParams);
        this.fFc = new com.baidu.tieba.play.m((ViewGroup) this.kGn.findViewById(R.id.auto_video_loading_container));
        this.fFc.setLoadingAnimationListener(this.hYs);
        this.kGp = (VideoListMediaControllerView) this.kGn.findViewById(R.id.media_controller);
        this.kGp.setPlayer(this.giK);
        this.mit = (ProgressBar) this.kGn.findViewById(R.id.pgrBottomProgress);
        this.mit.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.mit.setProgress(0);
        this.kGp.setOnSeekBarChangeListener(this.fSy);
        this.kGp.setOnProgressUpdatedListener(this.kIW);
        this.kGq = this.kGn.findViewById(R.id.black_mask);
        this.ibi = this.kGn.findViewById(R.id.layout_error);
        this.ibi.setOnClickListener(this.mOnClickListener);
        this.miW = (TextView) this.kGn.findViewById(R.id.auto_video_error_tips);
        this.kGr = (FrameLayout) this.kGn.findViewById(R.id.danmu_container);
        this.kGv = (ImageView) this.kGn.findViewById(R.id.img_full_screen);
        this.kGv.setOnClickListener(this.mOnClickListener);
        this.kGw = this.kGn.findViewById(R.id.layout_media_controller);
        this.miu = this.kGn.findViewById(R.id.time_show_controller);
        this.giK.setContinuePlayEnable(true);
        this.giK.setOnPreparedListener(this.emw);
        this.giK.setOnCompletionListener(this.emy);
        this.giK.setOnErrorListener(this.kGX);
        this.giK.setOnSeekCompleteListener(this.emB);
        this.giK.setOnInfoListener(this.emz);
        this.giK.setOnSurfaceDestroyedListener(this.fFk);
        this.miv = (SwitchImageView) this.kGn.findViewById(R.id.img_play_controller);
        this.miv.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.miv.setState(0);
        this.miv.setOnClickListener(this.mOnClickListener);
        this.miw = (TextView) this.kGn.findViewById(R.id.txt_replay);
        this.miw.setOnClickListener(this.mOnClickListener);
        this.mix = (TextView) this.kGn.findViewById(R.id.txt_playnext);
        this.mix.setOnClickListener(this.mOnClickListener);
        this.miy = (TextView) this.kGn.findViewById(R.id.txt_next_video_title);
        this.alP = (TbImageView) this.kGn.findViewById(R.id.video_thumbnail);
        this.alP.setDefaultErrorResource(0);
        this.alP.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gMX = (ImageView) this.kGn.findViewById(R.id.img_exit);
        this.gMX.setOnClickListener(this.mOnClickListener);
        this.kGC = (TextView) this.kGn.findViewById(R.id.video_title);
        this.bDq = this.kGn.findViewById(R.id.layout_title);
        this.bDq.setVisibility(8);
        this.iPs = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bWB = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.kGM = this.mAudioManager.getStreamMaxVolume(3);
        this.kGS = this.mAudioManager.getStreamVolume(3);
        kGT = 100 / this.kGM;
        this.kGn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.miL != null) {
                    c.this.miL.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.aaj) {
                        if (c.this.mStatus == 1 && c.this.kGO != 0) {
                            c.this.b(c.this.kGO == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kGO = 0;
                            c.this.kGN = 0;
                        }
                        if (!c.this.giK.isPlaying()) {
                            c.this.mix.setVisibility(8);
                            c.this.miw.setVisibility(8);
                            c.this.miy.setVisibility(8);
                        }
                    }
                    c.this.cZc();
                    if (c.this.miL != null) {
                        c.this.miL.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kGQ = new com.baidu.tieba.play.j(this.mActivity);
        if (this.mjc) {
            this.kGQ.start();
        }
        this.kGR = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (kGU == null) {
            kGU = new CallStateReceiver();
        }
        kGU.register(this.mActivity);
        dvW();
        MessageManager.getInstance().registerListener(this.kHd);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kHd);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void HM(int i2) {
        if (this.alP != null) {
            this.alP.setDefaultBgResource(i2);
        }
    }

    public void dvW() {
        if (this.miS) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.kGn.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.kGn.setSystemUiVisibility(0);
    }

    public void wl(boolean z) {
        this.miS = z;
        dvW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZc() {
        this.mStatus = 0;
        if (this.kGG != null && this.kGG.getParent() != null && (this.kGG.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kGG.getParent()).removeView(this.kGG);
                this.kGG = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kGH != null && this.kGH.getParent() != null && (this.kGH.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kGH.getParent()).removeView(this.kGH);
                this.kGH = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cZd() {
        if (this.mStatus == 1) {
            if (this.kGG == null && this.kGn != null && (this.kGn instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.kGn, true);
                this.kGG = this.kGn.findViewById(R.id.lay_jindu);
                this.kGI = (TextView) this.kGG.findViewById(R.id.show_time);
                this.kGL = (ImageView) this.kGG.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kGH == null && this.kGn != null && (this.kGn instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.kGn, true);
            this.kGH = this.kGn.findViewById(R.id.lay_voice);
            this.kGK = (ImageView) this.kGH.findViewById(R.id.arrow_voice_icon);
            this.kGJ = (SeekBar) this.kGH.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.miE = onClickListener;
    }

    public void wm(boolean z) {
        this.miD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.miL != null) {
                c.this.miL.onStart();
            }
            if (c.this.aau && c.this.aaj) {
                if (c.this.mStatus == 1) {
                    c.this.dwm();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aL(f2);
                    }
                } else {
                    if (c.this.aau) {
                        c.this.cZf();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kGN = c.this.giK.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aL(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.mjd) {
                if (c.this.miM != null && c.this.miM.dqe()) {
                    return true;
                }
                c.this.dpV();
                c.this.dwo();
                if (c.this.giK.isPlaying()) {
                    c.this.dwj();
                } else {
                    c.this.dwk();
                }
                if (c.this.miN != null) {
                    c.this.miN.qC(c.this.giK.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.mjd) {
                if (c.this.aaj) {
                    if (c.this.miM != null && c.this.miM.dqf()) {
                        return true;
                    }
                    c.this.dwi();
                    if (c.this.giK.isPlaying()) {
                        c.this.dwj();
                    } else {
                        c.this.dwk();
                    }
                    if (c.this.miN != null) {
                        c.this.miN.qC(c.this.giK.isPlaying());
                    }
                } else {
                    c.this.dpV();
                    c.this.dwo();
                    if (c.this.currentState != 1) {
                        c.this.dwk();
                        c.this.dwl();
                    } else {
                        c.this.cZs();
                    }
                    if (c.this.miN != null) {
                        c.this.miN.qC(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZf() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kGn.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kGn.setSystemUiVisibility(4);
        } else {
            this.kGn.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(float f2) {
        if (!this.aaj) {
            this.mStatus = 0;
            return;
        }
        if (kGT == 0) {
            this.kGM = this.mAudioManager.getStreamMaxVolume(3);
            kGT = 100 / this.kGM;
            if (kGT == 0) {
                kGT = 1;
            }
        }
        cZd();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kGT == 0) {
            if (f2 > 0.0f && this.kGS < this.kGM) {
                this.kGS++;
            }
            if (f2 < 0.0f && this.kGS > 0) {
                this.kGS--;
            }
        }
        if (this.mProgress > 0) {
            this.kGK.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kGK.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kGS, 0);
        this.kGJ.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.kGN -= 1000;
                this.kGO = 1;
            } else {
                this.kGN += 1000;
                this.kGO = 2;
            }
            if (this.kGN < 0) {
                this.kGN = 0;
            } else if (this.kGN > this.giK.getDuration()) {
                this.kGN = this.giK.getDuration();
            }
        }
        cZd();
        String HU = this.kGp.HU(this.kGN);
        if (f2 > 0.0f) {
            this.kGL.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kGL.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(HU)) {
            this.kGI.setText(new StringBuilder().append(HU).append("/").append(this.kGp.HU(this.giK.getDuration())));
        }
        this.kGp.setCurrentDuration(this.kGN, z ? false : true);
        dwm();
        dwb();
    }

    protected View av(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void HN(int i2) {
        this.miz = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alZ = str2;
    }

    public void setFid(String str) {
        this.fyg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        int i2 = 100;
        if (this.giK != null && this.kGp != null) {
            this.kGp.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dwH().Qf(this.mVideoUrl);
            if (this.mja) {
                this.giK.setVolume(1.0f, 1.0f);
                this.giK.start();
                this.mja = false;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aap);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.aap, 20L);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGY);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjh);
                if (this.giK.dwO()) {
                    this.currentState = 1;
                    dwm();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dwH().Qf(this.mVideoUrl);
                this.kGp.setPlayer(this.giK);
                if (this.mStartPosition != 0) {
                    this.miU = true;
                }
                if (!this.miZ) {
                    this.kGp.showProgress();
                }
                if (!this.miD && this.giK.getDuration() <= 0) {
                    cZg().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.giK.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aak = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.alP.getVisibility() != 8 || !this.aaj) {
            this.aaj = true;
            this.kGq.setVisibility(8);
            this.ibi.setVisibility(8);
            this.fFc.dwC();
            this.alP.setVisibility(8);
            dwn();
            this.kGp.showProgress();
            this.mit.setVisibility(0);
            if (this.kGA != null) {
                this.kGA.onPrepared();
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

    protected void wn(boolean z) {
        if (hasNavBar(this.mActivity) && (this.miu.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.miu.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.miu.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.miu.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.miu.setLayoutParams(layoutParams);
        }
    }

    public void dpV() {
        if (this.giK.isPlaying()) {
            aPd();
            if (this.miR != null) {
                this.miR.onPause();
            }
            if (this.miI != null) {
                this.miI.onPaused();
            }
        } else if (this.aaj) {
            aPe();
            if (this.lLU != null) {
                this.lLU.cAL();
            }
            if (this.miI != null) {
                this.miI.dws();
            }
        } else {
            dwf();
        }
    }

    public void SH() {
        this.kGV = true;
        if (this.kGQ != null) {
            this.kGQ.SH();
        }
    }

    public boolean dvX() {
        return this.giK != null && this.giK.getView().getHeight() > this.giK.getView().getWidth();
    }

    public void dvY() {
        wn(false);
        dwa();
    }

    public boolean HO(int i2) {
        switch (i2) {
            case 4:
                if (this.aau) {
                    if (dvX()) {
                        wn(false);
                        dwa();
                    } else {
                        SH();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kGM <= 0 || this.kGJ == null) {
                    return false;
                }
                this.kGS = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kGS * 100.0d) / this.kGM);
                this.kGJ.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.giK;
    }

    public VideoListMediaControllerView cZg() {
        return this.kGp;
    }

    public void show() {
        this.kGn.setVisibility(0);
    }

    public void cZk() {
        if (this.kGy != null) {
            ViewGroup.LayoutParams layoutParams = this.kGy.getLayoutParams();
            this.kGs = (FrameLayout.LayoutParams) this.kGn.getLayoutParams();
            this.kGs.width = layoutParams.width;
            this.kGs.height = layoutParams.height;
            this.kGs.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.kGn.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.kGn.setLayoutParams(this.kGs);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kGV) {
            if (this.aau) {
                TiebaStatic.log(new ar("c11712"));
            } else {
                TiebaStatic.log(new ar("c11711"));
            }
        } else {
            this.kGV = false;
        }
        if (configuration.orientation == 2) {
            dvZ();
        } else {
            dwa();
        }
        dwb();
        if (this.mActivity == com.baidu.adp.base.a.lg().currentActivity()) {
            aPe();
        }
        dwo();
        cZs();
        if (this.miN != null) {
            this.miN.qC(true);
        }
    }

    protected void dvZ() {
        this.aau = true;
        this.kGn.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bCO().ey(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bCO().ez(this.mActivity))));
        j(this.mActivity, true);
        this.bDq.setVisibility(0);
        this.gMX.setVisibility(0);
        this.kGC.setVisibility(0);
        this.kGr.setVisibility(8);
        this.fFc.dwD();
        this.alP.setVisibility(8);
        this.kGv.setImageResource(R.drawable.icon_video_narrow_white);
        EE(this.kGR);
        cZf();
        if (this.miF != null) {
            this.miF.rI();
        }
    }

    protected void dwa() {
        this.aau = false;
        if (this.kGs != null) {
            this.kGn.setLayoutParams(this.kGs);
        }
        j(this.mActivity, false);
        this.bDq.setVisibility(8);
        this.kGr.setVisibility(0);
        this.fFc.dwD();
        this.alP.setVisibility(8);
        this.kGv.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.kGp != null && (this.kGp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGp.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.kGp.setLayoutParams(layoutParams);
        }
        this.kGn.setSystemUiVisibility(0);
        dvW();
        if (this.miF != null) {
            this.miF.rJ();
        }
    }

    public void dwb() {
        if (this.giK != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.aau) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.mit.setMax(equipmentWidth);
            int duration = this.giK.getDuration();
            if (duration > 0) {
                if (this.miw.getVisibility() == 0) {
                    this.mit.setProgress(this.mit.getMax());
                } else {
                    this.mit.setProgress((int) ((this.giK.getCurrentPositionSync() * this.mit.getMax()) / duration));
                }
            }
        }
    }

    private void EE(int i2) {
        if (this.kGp != null && (this.kGp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGp.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.kGp.setLayoutParams(layoutParams);
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

    public boolean cZm() {
        return !this.aau;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kGA = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.miA = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.miB = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.miV) {
            fX(str, str2);
        } else {
            fW(str, str2);
        }
        if (eVar != null) {
            eVar.wv(z);
        }
    }

    public void fV(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, boolean z) {
        dwg();
        this.mja = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.giK.setVideoDuration(this.miz);
        this.giK.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGY);
        if (this.miH > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kGY, this.miH);
        }
        if (this.miI != null) {
            this.miI.onStarted();
        }
        this.fFc.startLoading();
        wo(z);
    }

    public void fW(String str, String str2) {
        B(str, str2, true);
    }

    public void fX(String str, String str2) {
        dwg();
        this.mja = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGY);
        if (this.miH > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kGY, this.miH);
        }
        if (this.miI != null) {
            this.miI.onStarted();
        }
        this.fFc.startLoading();
        wo(true);
    }

    public void dwc() {
        aPe();
        this.mit.setVisibility(0);
    }

    public void aPe() {
        int i2 = 100;
        if (this.giK != null && this.kGp != null) {
            this.aaj = true;
            this.currentState = 1;
            this.giK.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dwH().Qf(this.mVideoUrl);
            this.miU = true;
            if (this.mStartPosition > 100 && this.giK.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aak = i2;
            this.fFc.dwD();
            wo(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.miY && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alZ)) {
            this.miY = false;
            this.miZ = true;
            fW(this.mVideoUrl, this.alZ);
        }
    }

    private void wo(boolean z) {
        if (z) {
            this.alP.setVisibility(0);
            dwm();
            this.mit.setProgress(0);
        } else {
            this.alP.setVisibility(8);
            dwm();
        }
        this.kGp.showProgress();
        this.kGq.setVisibility(8);
        this.mix.setVisibility(8);
        this.miw.setVisibility(8);
        this.miy.setVisibility(8);
        this.ibi.setVisibility(8);
    }

    private void dwd() {
        this.fFc.dwD();
        this.mix.setVisibility(8);
        this.miw.setVisibility(8);
        this.miy.setVisibility(8);
        dwo();
    }

    public void aPd() {
        this.giK.pause();
        this.currentState = 2;
        dwd();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aap);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGY);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjh);
        this.giK.stopPlayback();
        this.aaj = false;
        this.mja = false;
        this.mStartPosition = 0;
        cMa();
    }

    public void dwe() {
        if (this.giK.getDuration() >= this.giK.getCurrentPosition()) {
            com.baidu.tieba.play.n.dwH().bB(this.mVideoUrl, this.giK.getCurrentPositionSync());
        }
    }

    public void wp(boolean z) {
        this.miT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(boolean z) {
        if (this.kGw != null) {
            this.kGq.setVisibility(0);
            this.mix.setVisibility(8);
            this.miw.setVisibility(8);
            this.miy.setVisibility(8);
            this.fFc.dwD();
            dwm();
            this.mit.setVisibility(8);
            this.ibi.setVisibility(8);
            this.kGp.aPs();
            this.alP.setVisibility(z ? 0 : 8);
        }
    }

    public void cMa() {
        wq(true);
    }

    public boolean rK() {
        if (this.giK == null) {
            return false;
        }
        return this.giK.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.giK == null) {
            return 0;
        }
        return this.giK.getCurrentPosition();
    }

    public void a(k kVar) {
        this.miL = kVar;
    }

    public void a(j jVar) {
        this.miK = jVar;
    }

    public void a(i iVar) {
        this.lLU = iVar;
    }

    public void a(g gVar) {
        this.miR = gVar;
    }

    public void a(h hVar) {
        this.miJ = hVar;
    }

    public void PF(String str) {
        this.lLu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwf() {
        a(this.mVideoUrl, this.alZ, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.miG = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dwg();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dOt().dOu()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.miV = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.miQ != null) {
                    this.miQ.pW(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.AJ(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dwh();
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
                aVar.b(this.eGu).bog();
                return;
            } else if (this.miQ != null) {
                this.miQ.pW(true);
                return;
            } else {
                if (!this.mis) {
                    this.mis = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.miP != null) {
            this.miP.cAI();
        }
    }

    private void dwg() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dOt().fV(this.mActivity);
        }
    }

    public void dwh() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.alP.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kHc);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aap);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kGY);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjg);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjh);
        this.kGQ.stop();
        kGU.unregister(this.mActivity);
    }

    public void Qe(String str) {
        this.kGC.setText(str);
    }

    public boolean cZo() {
        return this.aaj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwi() {
        if (this.kGw != null) {
            if (this.miC) {
                dwm();
            } else {
                dwl();
            }
        }
    }

    public void cZs() {
        dwl();
        dwj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwj() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kHc);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.kHc, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwk() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kHc);
    }

    public void dwl() {
        if (this.kGw != null && !this.miC && !this.mje) {
            wr(true);
            cZr();
            this.kGw.setVisibility(0);
            this.miu.setVisibility(0);
            this.mit.setVisibility(8);
            this.miC = true;
            if (this.miG != null) {
                this.miG.pX(false);
            }
        }
    }

    public void cZp() {
        if (this.kGw != null && this.miC) {
            wr(false);
            cZr();
            this.kGw.setVisibility(8);
            this.miu.setVisibility(8);
            this.mit.setVisibility(0);
            this.iPs.setAnimationListener(this.kHa);
            this.kGw.startAnimation(this.iPs);
            this.miC = false;
            if (this.miG != null) {
                this.miG.cAK();
            }
        }
    }

    public void dwm() {
        if (this.kGw != null && this.miC) {
            this.bWB.cancel();
            this.iPs.cancel();
            wr(false);
            cZr();
            this.kGw.setVisibility(8);
            this.miu.setVisibility(8);
            this.mit.setVisibility(0);
            this.miC = false;
            if (this.miG != null) {
                this.miG.cAK();
            }
        }
    }

    private void cZr() {
        if (this.kGw != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kHc);
            this.bWB.setAnimationListener(null);
            this.iPs.setAnimationListener(null);
            this.kGw.clearAnimation();
        }
    }

    private void dwn() {
        if (this.kGw != null) {
            this.bWB.setAnimationListener(null);
            this.iPs.setAnimationListener(null);
            this.kGw.clearAnimation();
        }
    }

    public void wr(boolean z) {
        dwo();
        if (z) {
            this.miv.setVisibility(0);
        } else {
            this.miv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwo() {
        if (this.currentState == 1) {
            this.miv.setState(1);
        } else {
            this.miv.setState(0);
        }
    }

    public void a(InterfaceC0829c interfaceC0829c) {
        this.miF = interfaceC0829c;
    }

    public void EH(int i2) {
        this.mStartPosition = i2;
    }

    public void av(boolean z, boolean z2) {
        if (this.kGQ != null) {
            if (this.kGv != null) {
                this.kGv.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.kGp != null && (this.kGp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kGp.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.kGp.setLayoutParams(layoutParams);
            }
            this.kGQ.cM(z);
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

    public void ws(boolean z) {
        this.mjd = z;
    }

    public void a(m mVar) {
        this.miM = mVar;
    }

    public void a(a aVar) {
        this.miN = aVar;
    }

    public void a(n nVar) {
        this.miO = nVar;
    }

    public void a(l lVar) {
        this.miP = lVar;
    }

    public void a(f fVar) {
        this.miQ = fVar;
    }

    public void wt(boolean z) {
        this.miX = z;
    }

    public void wu(boolean z) {
        this.miD = z;
    }

    public void HP(int i2) {
        this.mjb = i2;
    }

    public View dwp() {
        return this.kGn;
    }

    public void a(p pVar) {
        this.lLI = pVar;
    }

    public void dwq() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eGu.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eGu.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.giK != null) {
            this.giK.setStageType(str);
        }
    }
}
