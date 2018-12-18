package com.baidu.tieba.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.view.SwitchImageView;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int foN;
    private String aEN;
    private o bIW;
    protected QuickVideoView bOn;
    private String biw;
    private x boR;
    private com.baidu.tieba.j.k cUA;
    private com.baidu.tieba.play.g cUy;
    private String cXO;
    private View cXn;
    protected View cXs;
    private Animation dNe;
    private Animation dNf;
    private View foB;
    private View foC;
    private TextView foD;
    private SeekBar foE;
    private ImageView foF;
    private ImageView foG;
    private int foH;
    private int foM;
    private CallStateReceiver foO;
    public View fog;
    private VideoListMediaControllerView foi;
    private View foj;
    private FrameLayout fok;
    protected FrameLayout.LayoutParams fol;
    private ImageView foo;
    private View fop;

    /* renamed from: for  reason: not valid java name */
    private View f0for;
    private TbImageView fos;
    private g.f fot;
    private ImageView fov;
    private TextView fow;
    private SwitchImageView gBA;
    private TextView gBB;
    private TextView gBC;
    private TextView gBD;
    private g.a gBE;
    private g.b gBF;
    private View.OnClickListener gBI;
    protected InterfaceC0297c gBJ;
    private d gBK;
    private n gBM;
    private h gBN;
    private j gBO;
    private k gBP;
    private m gBQ;
    private a gBR;
    private l gBS;
    private f gBT;
    private g gBU;
    private TextView gBZ;
    private ProgressBar gBy;
    private View gBz;
    private boolean gCb;
    private boolean gCc;
    private boolean gCd;
    private int gCe;
    private boolean gCf;
    private boolean gCg;
    private i glh;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cUG = 100;
    private boolean gBx = false;
    protected boolean bIZ = false;
    private boolean fox = false;
    private boolean gBG = false;
    private boolean gBH = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int foI = 0;
    private int foJ = 0;
    private long gBL = 60000;
    private int foL = 0;
    private boolean foP = false;
    private boolean gBV = true;
    private boolean gBW = true;
    private boolean gBX = false;
    private boolean gBY = false;
    private String gkI = null;
    private int currentState = -1;
    private boolean gCa = false;
    private boolean gCh = false;
    private g.f bxJ = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cUy = gVar;
            c.this.cUA.bcK();
            c.this.apl();
        }
    };
    private g.e bxL = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.bqM();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cUK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.apl();
        }
    };
    private Runnable foR = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.foR);
            if (!c.this.fox) {
                if (c.this.bOn.getCurrentPosition() > c.this.cUG) {
                    c.this.bqM();
                } else {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.foR, 20L);
                }
            }
        }
    };
    private g.a bxI = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bOn != null) {
                int duration = c.this.bOn.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.fox = false;
                    c.this.gCd = false;
                    c.this.mStartPosition = 0;
                    c.this.aYF();
                    c.this.foj.setVisibility(0);
                    c.this.gBy.setProgress(c.this.gBy.getMax());
                    c.this.cUG = 100;
                    if (c.this.gBE != null) {
                        c.this.gBE.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bOn.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.mt(false);
                        c.this.mu(true);
                    } else {
                        c.this.brd();
                        c.this.gBB.setVisibility(0);
                    }
                    if (!c.this.bIZ && duration <= 150000) {
                        if (!c.this.gCa) {
                            if (c.this.gBO != null) {
                                c.this.gBO.lQ(true);
                            }
                            c.this.aZ(c.this.aEN, c.this.biw);
                        } else {
                            c.this.currentState = 5;
                            c.this.bOn.setRecoveryState(5);
                            c.this.bOn.getPlayer().pause();
                            c.this.bOn.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.gBM != null) {
                        c.this.gBM.id(c.this.gBy.getMax());
                        c.this.gBM.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b foS = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cXs.setVisibility(0);
            c.this.boR.brY();
            c.this.currentState = 4;
            c.this.bOn.setRecoveryState(4);
            if (c.this.gBF != null) {
                c.this.gBF.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kV()) {
                c.this.gCb = true;
            }
            if (c.this.gBM != null) {
                c.this.gBM.YS();
            }
            c.this.gCd = false;
            return true;
        }
    };
    protected Runnable foT = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bOn == null || !c.this.bOn.isPlaying()) {
                c.this.cXs.setVisibility(0);
                c.this.boR.brY();
                if (c.this.gBM != null) {
                    c.this.gBM.YS();
                }
            }
        }
    };
    private g.InterfaceC0298g bxM = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0298g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gBX) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gCi, 200L);
            }
        }
    };
    private Runnable gCi = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bOn == null || !c.this.gBX) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.foR, 200L);
                c.this.gBX = false;
            } else if (c.this.mStartPosition != c.this.bOn.getCurrentPosition()) {
                c.this.gBX = false;
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.foR, 20L);
            } else {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gCi, 200L);
            }
        }
    };
    private QuickVideoView.b bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fox = false;
            if (c.this.gBH) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gCj, 300L);
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.foR);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.foT);
        }
    };
    private Runnable gCj = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.gCd = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.cXs.getId()) {
                if (view.getId() != c.this.gBA.getId()) {
                    if (view.getId() == c.this.gBC.getId()) {
                        if (c.this.gBN != null) {
                            c.this.gBN.bnz();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.gBB.getId()) {
                        if (c.this.gBO != null) {
                            c.this.gBO.lQ(false);
                        }
                        c.this.aZ(c.this.aEN, c.this.biw);
                        return;
                    } else if (view.getId() == c.this.foo.getId()) {
                        int i2 = c.this.gBH ? 1 : 2;
                        if (c.this.bIZ) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").aA("tid", c.this.biw).aA(ImageViewerConfig.FORUM_ID, c.this.cXO).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").aA("tid", c.this.biw).aA(ImageViewerConfig.FORUM_ID, c.this.cXO).x("obj_type", i2).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.gBS != null) {
                            c.this.gBS.aCV();
                        }
                        if (c.this.bqO()) {
                            if (c.this.bIZ) {
                                c.this.bqQ();
                            } else {
                                c.this.bqP();
                            }
                            c.this.mq(c.this.bIZ);
                            return;
                        }
                        c.this.aYJ();
                        return;
                    } else if (view.getId() != c.this.fov.getId()) {
                        if (c.this.gBI != null) {
                            c.this.gBI.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.gBS != null) {
                            c.this.gBS.aCV();
                        }
                        if (c.this.bqO()) {
                            c.this.bqQ();
                            c.this.mq(false);
                            return;
                        }
                        c.this.aYJ();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bnn();
                c.this.brf();
                if (c.this.currentState != 1) {
                    c.this.brb();
                    c.this.brc();
                } else {
                    c.this.aYX();
                }
                if (c.this.gBR != null) {
                    c.this.gBR.ht(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.bOn.stopPlayback();
            c.this.fox = false;
            c.this.bqW();
        }
    };
    private Animation.AnimationListener foV = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener foW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable foX = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.aYU();
        }
    };
    private CustomMessageListener foY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b fqT = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void hI(int i2) {
            int duration;
            if (c.this.bOn != null && (duration = c.this.bOn.getDuration()) > 0 && c.this.gBy != null) {
                c.this.gBy.setProgress((int) ((i2 * c.this.fog.getWidth()) / duration));
                if (c.this.gBM != null) {
                    c.this.gBM.id((c.this.bOn.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener bBX = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.brb();
            c.this.mu(false);
            if (c.this.gBR != null) {
                c.this.gBR.ht(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.aYK() != null) {
                c.this.setStartPosition(c.this.aYK().getSeekPosition());
                if (!c.this.aYT()) {
                    c.this.bqW();
                } else {
                    c.this.aYS();
                    if (c.this.glh != null) {
                        c.this.glh.aCX();
                    }
                }
            }
            c.this.mu(true);
            c.this.bra();
            if (c.this.gBR != null) {
                c.this.gBR.ht(true);
            }
        }
    };
    private QuickVideoView.a gCk = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bri() {
            if (!c.this.gCa) {
                c.this.boR.startLoading();
                c.this.fos.setVisibility(0);
                c.this.gBA.setVisibility(8);
                c.this.gBC.setVisibility(8);
                c.this.gBB.setVisibility(8);
                c.this.gBD.setVisibility(8);
                c.this.cXs.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.foT);
                if (c.this.gBL > 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.foT, c.this.gBL);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ht(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0297c {
        void YQ();

        void YR();
    }

    /* loaded from: classes.dex */
    public interface d {
        void aCW();

        void gU(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void mz(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void gT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void bnz();
    }

    /* loaded from: classes.dex */
    public interface i {
        void aCX();
    }

    /* loaded from: classes.dex */
    public interface j {
        void lQ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void aCU();

        void aCV();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bnx();

        boolean bny();
    }

    /* loaded from: classes.dex */
    public interface n {
        void YS();

        void YT();

        void id(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    public c(Activity activity, View view, boolean z) {
        this.gCf = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.gCf = z;
            this.f0for = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.gCf = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.gCf = z;
            this.f0for = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.fog = Q(this.mActivity);
        this.fog.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.fog);
        }
        this.bOn = (QuickVideoView) this.fog.findViewById(e.g.videoView);
        this.boR = new x((ViewGroup) this.fog.findViewById(e.g.auto_video_loading_container));
        this.boR.setLoadingAnimationListener(this.cUK);
        this.foi = (VideoListMediaControllerView) this.fog.findViewById(e.g.media_controller);
        this.foi.setPlayer(this.bOn);
        this.gBy = (ProgressBar) this.fog.findViewById(e.g.pgrBottomProgress);
        this.gBy.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.gBy.setProgress(0);
        this.foi.setOnSeekBarChangeListener(this.bBX);
        this.foi.setOnProgressUpdatedListener(this.fqT);
        this.foj = this.fog.findViewById(e.g.black_mask);
        this.cXs = this.fog.findViewById(e.g.layout_error);
        this.cXs.setOnClickListener(this.mOnClickListener);
        this.gBZ = (TextView) this.fog.findViewById(e.g.auto_video_error_tips);
        this.fok = (FrameLayout) this.fog.findViewById(e.g.danmu_container);
        this.foo = (ImageView) this.fog.findViewById(e.g.img_full_screen);
        this.foo.setOnClickListener(this.mOnClickListener);
        this.fop = this.fog.findViewById(e.g.layout_media_controller);
        this.gBz = this.fog.findViewById(e.g.time_show_controller);
        this.bOn.setPlayerReuseEnable(true);
        this.bOn.setContinuePlayEnable(true);
        this.bOn.setOnPreparedListener(this.bxJ);
        this.bOn.setOnCompletionListener(this.bxI);
        this.bOn.setOnErrorListener(this.foS);
        this.bOn.setOnSeekCompleteListener(this.bxM);
        this.bOn.setOnSurfaceDestroyedListener(this.bpa);
        this.bOn.setOnRecoveryCallback(this.gCk);
        this.bOn.setOnOutInfoListener(this.bxL);
        this.gBA = (SwitchImageView) this.fog.findViewById(e.g.img_play_controller);
        this.gBA.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
        this.gBA.setState(0);
        this.gBA.setOnClickListener(this.mOnClickListener);
        this.gBB = (TextView) this.fog.findViewById(e.g.txt_replay);
        this.gBB.setOnClickListener(this.mOnClickListener);
        this.gBC = (TextView) this.fog.findViewById(e.g.txt_playnext);
        this.gBC.setOnClickListener(this.mOnClickListener);
        this.gBD = (TextView) this.fog.findViewById(e.g.txt_next_video_title);
        this.fos = (TbImageView) this.fog.findViewById(e.g.video_thumbnail);
        this.fos.setDefaultErrorResource(0);
        this.fos.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.fov = (ImageView) this.fog.findViewById(e.g.img_exit);
        this.fov.setOnClickListener(this.mOnClickListener);
        this.fow = (TextView) this.fog.findViewById(e.g.video_title);
        this.cXn = this.fog.findViewById(e.g.layout_title);
        this.cXn.setVisibility(8);
        this.dNe = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.dNf = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.foH = this.mAudioManager.getStreamMaxVolume(3);
        this.foM = this.mAudioManager.getStreamVolume(3);
        foN = 100 / this.foH;
        this.fog.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.gBP != null) {
                    c.this.gBP.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.fox) {
                        if (c.this.mStatus == 1 && c.this.foJ != 0) {
                            c.this.b(c.this.foJ == 1 ? 1000.0f : -1000.0f, false);
                            c.this.foJ = 0;
                            c.this.foI = 0;
                        }
                        if (!c.this.bOn.isPlaying()) {
                            c.this.gBC.setVisibility(8);
                            c.this.gBB.setVisibility(8);
                            c.this.gBD.setVisibility(8);
                        }
                    }
                    c.this.aYF();
                    if (c.this.gBP != null) {
                        c.this.gBP.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.bIW = new o(this.mActivity);
        if (this.gCf) {
            this.bIW.start();
        }
        this.foL = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.ds16);
        this.foO = new CallStateReceiver();
        this.foO.register(this.mActivity);
        bqK();
        this.cUA = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.foY);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.foY);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bqK() {
        if (this.gBV) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fog.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.fog.setSystemUiVisibility(0);
    }

    public void mp(boolean z) {
        this.gBV = z;
        bqK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYF() {
        this.mStatus = 0;
        if (this.foB != null && this.foB.getParent() != null && (this.foB.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.foB.getParent()).removeView(this.foB);
                this.foB = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.foC != null && this.foC.getParent() != null && (this.foC.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.foC.getParent()).removeView(this.foC);
                this.foC = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aYG() {
        if (this.mStatus == 1) {
            if (this.foB == null && this.fog != null && (this.fog instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_jindu, (ViewGroup) this.fog, true);
                this.foB = this.fog.findViewById(e.g.lay_jindu);
                this.foD = (TextView) this.foB.findViewById(e.g.show_time);
                this.foG = (ImageView) this.foB.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.foC == null && this.fog != null && (this.fog instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_voice, (ViewGroup) this.fog, true);
            this.foC = this.fog.findViewById(e.g.lay_voice);
            this.foF = (ImageView) this.foC.findViewById(e.g.arrow_voice_icon);
            this.foE = (SeekBar) this.foC.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.gBI = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gBP != null) {
                c.this.gBP.onStart();
            }
            if (c.this.bIZ && c.this.fox) {
                if (c.this.mStatus == 1) {
                    c.this.brd();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.bIZ) {
                        c.this.aYI();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.foI = c.this.bOn.getCurrentPosition();
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
            if (!c.this.gCg) {
                if (c.this.gBQ != null && c.this.gBQ.bnx()) {
                    return true;
                }
                c.this.bnn();
                c.this.brf();
                if (c.this.bOn.isPlaying()) {
                    c.this.bra();
                } else {
                    c.this.brb();
                }
                if (c.this.gBR != null) {
                    c.this.gBR.ht(c.this.bOn.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gCg) {
                if (c.this.fox) {
                    if (c.this.gBQ != null && c.this.gBQ.bny()) {
                        return true;
                    }
                    c.this.bqZ();
                    if (c.this.bOn.isPlaying()) {
                        c.this.bra();
                    } else {
                        c.this.brb();
                    }
                    if (c.this.gBR != null) {
                        c.this.gBR.ht(c.this.bOn.isPlaying());
                    }
                } else {
                    c.this.bnn();
                    c.this.brf();
                    if (c.this.currentState != 1) {
                        c.this.brb();
                        c.this.brc();
                    } else {
                        c.this.aYX();
                    }
                    if (c.this.gBR != null) {
                        c.this.gBR.ht(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYI() {
        if (Build.VERSION.SDK_INT < 16) {
            this.fog.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.fog.setSystemUiVisibility(4);
        } else {
            this.fog.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.fox) {
            this.mStatus = 0;
            return;
        }
        aYG();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % foN == 0) {
            if (f2 > 0.0f && this.foM < this.foH) {
                this.foM++;
            }
            if (f2 < 0.0f && this.foM > 0) {
                this.foM--;
            }
        }
        if (this.mProgress > 0) {
            this.foF.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.foF.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.foM, 0);
        this.foE.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.foI += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.foJ = 1;
            } else {
                this.foI += 1000;
                this.foJ = 2;
            }
            if (this.foI < 0) {
                this.foI = 0;
            } else if (this.foI > this.bOn.getDuration()) {
                this.foI = this.bOn.getDuration();
            }
        }
        aYG();
        String tp = this.foi.tp(this.foI);
        if (f2 > 0.0f) {
            this.foG.setImageResource(e.f.icon_kuaitui);
        } else {
            this.foG.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tp)) {
            this.foD.setText(new StringBuilder().append(tp).append("/").append(this.foi.tp(this.bOn.getDuration())));
        }
        this.foi.setCurrentDuration(this.foI, z ? false : true);
        brd();
        bqR();
    }

    protected View Q(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(e.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.aEN = str;
        this.biw = str2;
    }

    public void bqL() {
        if (this.bOn != null) {
            this.bOn.bqL();
        }
    }

    public void setFid(String str) {
        this.cXO = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        int i2 = 100;
        if (this.bOn != null && this.cUy != null && this.foi != null) {
            this.foi.showProgress();
            this.mStartPosition = y.bsc().tW(this.aEN);
            if (this.gCd) {
                this.cUy.setVolume(1.0f, 1.0f);
                this.bOn.start();
                this.gCd = false;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.foR, 20L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCj);
                if (this.bOn.bry()) {
                    this.currentState = 1;
                    this.bOn.setRecoveryState(1);
                    brd();
                }
                this.mStartPosition = y.bsc().tW(this.aEN);
                this.foi.setPlayer(this.bOn);
                if (this.mStartPosition != 0 && !this.cUy.isPlayerReuse()) {
                    this.gBX = true;
                }
                if (!this.gCc) {
                    this.foi.showProgress();
                }
                if (this.cUy.getDuration() <= 0) {
                    aYK().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.cUy.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cUG = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqM() {
        if (!this.fox) {
            this.fox = true;
            this.foj.setVisibility(8);
            this.cXs.setVisibility(8);
            this.boR.brX();
            this.fos.setVisibility(8);
            bre();
            if (brg()) {
                this.cUA.a(this.biw, -1L, this.bOn.getDuration() / 1000, "middle", this.bOn);
            }
            this.foi.showProgress();
            this.gBy.setVisibility(0);
            if (this.fot != null) {
                this.fot.onPrepared(this.bOn.getPlayer());
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
            Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mq(boolean z) {
        if (hasNavBar(this.mActivity)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gBz.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.gBz.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gBz.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.gBz.setLayoutParams(layoutParams);
        }
    }

    public void bnn() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.S(this.mActivity, this.mActivity.getString(e.j.neterror));
        } else if (this.bOn.isPlaying()) {
            pausePlay();
            if (this.gBU != null) {
                this.gBU.onPause();
            }
            if (this.gBM != null) {
                this.gBM.onPaused();
            }
        } else if (this.fox) {
            aYS();
            if (this.glh != null) {
                this.glh.aCX();
            }
            if (this.gBM != null) {
                this.gBM.YT();
            }
        } else {
            bqW();
        }
    }

    public boolean bqN() {
        return this.foP;
    }

    public void aYJ() {
        this.foP = true;
        if (this.bIW != null) {
            this.bIW.aYJ();
        }
    }

    public boolean bqO() {
        return this.cUy != null && this.cUy.getVideoHeight() > this.cUy.getVideoWidth();
    }

    public boolean tl(int i2) {
        switch (i2) {
            case 4:
                if (this.bIZ) {
                    if (bqO()) {
                        mq(false);
                        bqQ();
                    } else {
                        aYJ();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.foH <= 0 || this.foE == null) {
                    return false;
                }
                this.foM = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.foM * 100.0d) / this.foH);
                this.foE.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bOn;
    }

    public VideoListMediaControllerView aYK() {
        return this.foi;
    }

    public void show() {
        this.fog.setVisibility(0);
    }

    public void aYO() {
        if (this.f0for != null) {
            ViewGroup.LayoutParams layoutParams = this.f0for.getLayoutParams();
            this.fol = (FrameLayout.LayoutParams) this.fog.getLayoutParams();
            this.fol.width = layoutParams.width;
            this.fol.height = layoutParams.height;
            this.fol.topMargin = 0;
            this.fog.setLayoutParams(this.fol);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.foP) {
            if (this.bIZ) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.foP = false;
        }
        if (configuration.orientation == 2) {
            bqP();
        } else {
            bqQ();
        }
        bqR();
        aYS();
        brf();
        aYX();
        if (this.gBR != null) {
            this.gBR.ht(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqP() {
        this.bIZ = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bqO()) {
            this.fog.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.fog.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        e(this.mActivity, true);
        this.cXn.setVisibility(0);
        this.fov.setVisibility(0);
        this.fow.setVisibility(0);
        this.fok.setVisibility(8);
        this.boR.brY();
        this.fos.setVisibility(8);
        this.foo.setImageResource(e.f.icon_video_narrow_white);
        qX(this.foL);
        aYI();
        if (this.gBJ != null) {
            this.gBJ.YQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqQ() {
        this.bIZ = false;
        if (this.fol != null) {
            this.fog.setLayoutParams(this.fol);
        }
        e(this.mActivity, false);
        this.cXn.setVisibility(8);
        this.fok.setVisibility(0);
        this.boR.brY();
        this.fos.setVisibility(8);
        this.foo.setImageResource(e.f.icon_video_enlarge_white);
        if (this.foi != null && (this.foi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foi.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds24);
            layoutParams.rightMargin = 0;
            this.foi.setLayoutParams(layoutParams);
        }
        this.fog.setSystemUiVisibility(0);
        bqK();
        if (this.gBJ != null) {
            this.gBJ.YR();
        }
    }

    public void bqR() {
        if (this.bOn != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.bIZ) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.gBy.setMax(aO);
            int duration = this.bOn.getDuration();
            if (duration > 0) {
                if (this.gBB.getVisibility() == 0) {
                    this.gBy.setProgress(this.gBy.getMax());
                } else {
                    this.gBy.setProgress((int) ((this.bOn.getCurrentPosition() * this.gBy.getMax()) / duration));
                }
            }
        }
    }

    private void qX(int i2) {
        if (this.foi != null && (this.foi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foi.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.foi.setLayoutParams(layoutParams);
        }
    }

    private void e(Activity activity, boolean z) {
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

    public boolean aYQ() {
        return !this.bIZ;
    }

    public void a(g.f fVar) {
        this.fot = fVar;
    }

    public void a(g.a aVar) {
        this.gBE = aVar;
    }

    public void a(g.b bVar) {
        this.gBF = bVar;
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bOn != null) {
            this.bOn.setPbLoadingTime(currentTimeMillis);
        }
        aZ(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gBY) {
            cs(str, str2);
        } else {
            aZ(str, str2);
        }
        if (eVar != null) {
            eVar.mz(z);
        }
    }

    public void cr(String str, String str2) {
    }

    public void aZ(String str, String str2) {
        bqX();
        this.gCd = true;
        this.currentState = 0;
        this.bOn.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bOn.setVideoPath(str, str2);
        this.cUA.bcJ();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        if (this.gBL > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.foT, this.gBL);
        }
        if (this.gBM != null) {
            this.gBM.onStarted();
        }
        this.boR.startLoading();
        mr(true);
    }

    public void cs(String str, String str2) {
        bqX();
        this.gCd = true;
        this.currentState = 0;
        this.bOn.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        if (this.gBL > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.foT, this.gBL);
        }
        if (this.gBM != null) {
            this.gBM.onStarted();
        }
        this.boR.startLoading();
        mr(true);
    }

    public void bqS() {
        aYS();
        this.gBy.setVisibility(0);
    }

    public void aYS() {
        int i2 = 100;
        if (this.bOn != null && this.foi != null) {
            this.fox = true;
            this.currentState = 1;
            this.bOn.setRecoveryState(1);
            this.bOn.start();
            if (this.cUy != null && this.foi != null) {
                this.mStartPosition = y.bsc().tW(this.aEN);
                if (this.mStartPosition != 0 && !this.cUy.isPlayerReuse()) {
                    this.gBX = true;
                }
                if (this.mStartPosition > 100 && this.cUy.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cUG = i2;
            } else {
                this.cUG = 100;
            }
            this.boR.brY();
            mr(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kV() && this.gCb && !StringUtils.isNull(this.aEN) && !StringUtils.isNull(this.biw)) {
            this.gCb = false;
            this.gCc = true;
            aZ(this.aEN, this.biw);
        }
    }

    private void mr(boolean z) {
        if (z) {
            this.fos.setVisibility(0);
            brd();
            this.gBy.setProgress(0);
        } else {
            this.fos.setVisibility(8);
        }
        this.foi.showProgress();
        this.foj.setVisibility(8);
        this.gBC.setVisibility(8);
        this.gBB.setVisibility(8);
        this.gBD.setVisibility(8);
        this.cXs.setVisibility(8);
    }

    private void bqT() {
        this.boR.brY();
        this.gBC.setVisibility(8);
        this.gBB.setVisibility(8);
        this.gBD.setVisibility(8);
        brf();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bOn != null) {
            this.bOn.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bOn.pause();
        this.currentState = 2;
        this.bOn.setRecoveryState(2);
        bqT();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bOn.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCj);
        this.bOn.stopPlayback();
        this.fox = false;
        this.gCd = false;
        this.mStartPosition = 0;
        aLW();
    }

    public void bqU() {
        if (this.bOn.getDuration() >= this.bOn.getCurrentPosition()) {
            y.bsc().aN(this.aEN, this.bOn.getCurrentPosition());
        }
    }

    public void ms(boolean z) {
        this.gBW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt(boolean z) {
        if (this.fop != null) {
            this.foj.setVisibility(0);
            this.gBC.setVisibility(8);
            this.gBB.setVisibility(8);
            this.gBD.setVisibility(8);
            this.boR.brY();
            brd();
            this.gBy.setVisibility(8);
            this.cXs.setVisibility(8);
            this.foi.Wk();
            this.fos.setVisibility(z ? 0 : 8);
        }
    }

    public void aLW() {
        mt(true);
    }

    public boolean bqV() {
        if (this.bOn == null) {
            return false;
        }
        return this.bOn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bOn == null) {
            return 0;
        }
        return this.bOn.getCurrentPosition();
    }

    public void a(k kVar) {
        this.gBP = kVar;
    }

    public void a(j jVar) {
        this.gBO = jVar;
    }

    public void a(i iVar) {
        this.glh = iVar;
    }

    public void a(g gVar) {
        this.gBU = gVar;
    }

    public void a(h hVar) {
        this.gBN = hVar;
    }

    public void tt(String str) {
        this.gkI = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqW() {
        a(this.aEN, this.biw, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.gBK = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bqX();
        if (com.baidu.adp.lib.util.j.kX() && !com.baidu.tieba.video.g.bHQ().bHR()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gBY = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gBT != null) {
                    this.gBT.gT(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.eB(TbadkCoreApplication.getInst().getString(e.j.play_video_mobile_tip));
                aVar.a(e.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bqY();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(e.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).BF();
                return;
            } else if (this.gBT != null) {
                this.gBT.gT(true);
                return;
            } else {
                if (!this.gBx) {
                    this.gBx = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gBS != null) {
            this.gBS.aCU();
        }
    }

    private void bqX() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bHQ().dc(this.mActivity);
        }
    }

    public void bqY() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.fos.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foX);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foR);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foT);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCi);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCj);
        this.bIW.stop();
        this.foO.unregister(this.mActivity);
    }

    public void tR(String str) {
        this.fow.setText(str);
    }

    public boolean aYT() {
        return this.fox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqZ() {
        if (this.fop != null) {
            if (this.gBG) {
                brd();
            } else {
                brc();
            }
        }
    }

    public void aYX() {
        brc();
        bra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foX);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.foX, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foX);
    }

    public void brc() {
        if (this.fop != null && !this.gBG && !this.gCh) {
            mu(true);
            aYW();
            this.fop.setVisibility(0);
            this.gBz.setVisibility(0);
            this.gBy.setVisibility(8);
            this.gBG = true;
            if (this.gBK != null) {
                this.gBK.gU(false);
            }
        }
    }

    public void aYU() {
        if (this.fop != null && this.gBG) {
            mu(false);
            aYW();
            this.fop.setVisibility(8);
            this.gBz.setVisibility(8);
            this.gBy.setVisibility(0);
            this.dNe.setAnimationListener(this.foV);
            this.fop.startAnimation(this.dNe);
            this.gBG = false;
            if (this.gBK != null) {
                this.gBK.aCW();
            }
        }
    }

    public void brd() {
        if (this.fop != null && this.gBG) {
            this.dNf.cancel();
            this.dNe.cancel();
            mu(false);
            aYW();
            this.fop.setVisibility(8);
            this.gBz.setVisibility(8);
            this.gBy.setVisibility(0);
            this.gBG = false;
            if (this.gBK != null) {
                this.gBK.aCW();
            }
        }
    }

    private void aYW() {
        if (this.fop != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.foX);
            this.dNf.setAnimationListener(null);
            this.dNe.setAnimationListener(null);
            this.fop.clearAnimation();
        }
    }

    private void bre() {
        if (this.fop != null) {
            this.dNf.setAnimationListener(null);
            this.dNe.setAnimationListener(null);
            this.fop.clearAnimation();
        }
    }

    public void mu(boolean z) {
        brf();
        if (z) {
            this.gBA.setVisibility(0);
        } else {
            this.gBA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brf() {
        if (this.currentState == 1) {
            this.gBA.setState(1);
        } else {
            this.gBA.setState(0);
        }
    }

    public void a(InterfaceC0297c interfaceC0297c) {
        this.gBJ = interfaceC0297c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void S(boolean z, boolean z2) {
        if (this.bIW != null) {
            if (this.foo != null) {
                this.foo.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.foi != null && (this.foi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foi.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds52);
                this.foi.setLayoutParams(layoutParams);
            }
            this.bIW.mB(z);
        }
    }

    public int getScreenHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            return com.baidu.adp.lib.util.l.aQ(context);
        }
        return i2;
    }

    public static int getVirtualBarHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
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

    public void mv(boolean z) {
        this.gCg = z;
    }

    public void a(m mVar) {
        this.gBQ = mVar;
    }

    public void a(a aVar) {
        this.gBR = aVar;
    }

    public void a(l lVar) {
        this.gBS = lVar;
    }

    public void a(f fVar) {
        this.gBT = fVar;
    }

    public void mw(boolean z) {
        this.gCa = z;
    }

    public boolean brg() {
        return this.gBH;
    }

    public void mx(boolean z) {
        this.gBH = z;
    }

    public void tm(int i2) {
        this.gCe = i2;
    }

    public View brh() {
        return this.fog;
    }

    public void a(n nVar) {
        this.gBM = nVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.bOn != null) {
            this.bOn.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.foM = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void my(boolean z) {
        this.gCh = z;
        if (z) {
            brd();
        } else {
            aYX();
        }
    }
}
