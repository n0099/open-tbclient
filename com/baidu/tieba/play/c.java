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
    private static int fsB;
    private String aFr;
    private com.baidu.tieba.play.o bJN;
    protected QuickVideoView bPc;
    private String bjn;
    private x bpJ;
    private com.baidu.tieba.play.g cYa;
    private com.baidu.tieba.j.k cYc;
    private Animation dQC;
    private Animation dQD;
    private View daR;
    protected View daW;
    private String dbs;
    public View frU;
    private VideoListMediaControllerView frW;
    private View frX;
    private FrameLayout frY;
    protected FrameLayout.LayoutParams frZ;
    private int fsA;
    private CallStateReceiver fsC;
    private ImageView fsc;
    private View fsd;
    private View fsf;
    private TbImageView fsg;
    private g.f fsh;
    private ImageView fsj;
    private TextView fsk;
    private View fsp;
    private View fsq;
    private TextView fsr;
    private SeekBar fss;
    private ImageView fst;
    private ImageView fsu;
    private int fsv;
    private g.a gFA;
    private g.b gFB;
    private View.OnClickListener gFE;
    protected InterfaceC0297c gFF;
    private d gFG;
    private n gFI;
    private h gFJ;
    private j gFK;
    private k gFL;
    private m gFM;
    private a gFN;
    private l gFO;
    private f gFP;
    private g gFQ;
    private TextView gFV;
    private boolean gFX;
    private boolean gFY;
    private boolean gFZ;
    private ProgressBar gFu;
    private View gFv;
    private SwitchImageView gFw;
    private TextView gFx;
    private TextView gFy;
    private TextView gFz;
    private int gGa;
    private boolean gGb;
    private boolean gGc;
    private o goR;
    private i gpd;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cYi = 100;
    private boolean gFt = false;
    protected boolean bJQ = false;
    private boolean fsl = false;
    private boolean gFC = false;
    private boolean gFD = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fsw = 0;
    private int fsx = 0;
    private long gFH = 60000;
    private int fsz = 0;
    private boolean fsD = false;
    private boolean gFR = true;
    private boolean gFS = true;
    private boolean gFT = false;
    private boolean gFU = false;
    private String goD = null;
    private int currentState = -1;
    private boolean gFW = false;
    private boolean gGd = false;
    private g.f byB = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cYa = gVar;
            c.this.cYc.bdY();
            c.this.aqx();
        }
    };
    private g.e byD = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.bsh();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cYm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aqx();
        }
    };
    private Runnable fsF = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsF);
            if (!c.this.fsl) {
                if (c.this.bPc.getCurrentPosition() > c.this.cYi) {
                    c.this.bsh();
                } else {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsF, 20L);
                }
            }
        }
    };
    private g.a byA = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bPc != null) {
                int duration = c.this.bPc.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.fsl = false;
                    c.this.gFZ = false;
                    c.this.mStartPosition = 0;
                    c.this.aZT();
                    c.this.frX.setVisibility(0);
                    c.this.gFu.setProgress(c.this.gFu.getMax());
                    c.this.cYi = 100;
                    if (c.this.gFA != null) {
                        c.this.gFA.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bPc.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.mw(false);
                        c.this.mx(true);
                    } else {
                        c.this.bsy();
                        c.this.gFx.setVisibility(0);
                    }
                    if (!c.this.bJQ && duration <= 150000) {
                        if (!c.this.gFW) {
                            if (c.this.gFK != null) {
                                c.this.gFK.lT(true);
                            }
                            c.this.ba(c.this.aFr, c.this.bjn);
                        } else {
                            c.this.currentState = 5;
                            c.this.bPc.setRecoveryState(5);
                            c.this.bPc.getPlayer().pause();
                            c.this.bPc.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.gFI != null) {
                        c.this.gFI.ie(c.this.gFu.getMax());
                        c.this.gFI.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b fsG = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.daW.setVisibility(0);
            c.this.bpJ.btt();
            c.this.currentState = 4;
            c.this.bPc.setRecoveryState(4);
            if (c.this.gFB != null) {
                c.this.gFB.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kV()) {
                c.this.gFX = true;
            }
            if (c.this.gFI != null) {
                c.this.gFI.Zr();
            }
            c.this.gFZ = false;
            return true;
        }
    };
    protected Runnable fsH = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bPc == null || !c.this.bPc.isPlaying()) {
                c.this.daW.setVisibility(0);
                c.this.bpJ.btt();
                if (c.this.gFI != null) {
                    c.this.gFI.Zr();
                }
            }
        }
    };
    private g.InterfaceC0298g byE = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0298g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gFT) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gGe, 200L);
            }
        }
    };
    private Runnable gGe = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bPc == null || !c.this.gFT) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsF, 200L);
                c.this.gFT = false;
            } else if (c.this.mStartPosition != c.this.bPc.getCurrentPosition()) {
                c.this.gFT = false;
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsF, 20L);
            } else {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gGe, 200L);
            }
        }
    };
    private QuickVideoView.b bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fsl = false;
            if (c.this.gFD) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gGf, 300L);
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsF);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsH);
        }
    };
    private Runnable gGf = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.gFZ = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.goR != null) {
                c.this.goR.boR();
            }
            if (view.getId() != c.this.daW.getId()) {
                if (view.getId() != c.this.gFw.getId()) {
                    if (view.getId() == c.this.gFy.getId()) {
                        if (c.this.gFJ != null) {
                            c.this.gFJ.boS();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.gFx.getId()) {
                        if (c.this.gFK != null) {
                            c.this.gFK.lT(false);
                        }
                        c.this.ba(c.this.aFr, c.this.bjn);
                        return;
                    } else if (view.getId() == c.this.fsc.getId()) {
                        int i2 = c.this.gFD ? 1 : 2;
                        if (c.this.bJQ) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").aB("tid", c.this.bjn).aB(ImageViewerConfig.FORUM_ID, c.this.dbs).y("obj_type", i2).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").aB("tid", c.this.bjn).aB(ImageViewerConfig.FORUM_ID, c.this.dbs).y("obj_type", i2).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.gFO != null) {
                            c.this.gFO.aEh();
                        }
                        if (c.this.bsj()) {
                            if (c.this.bJQ) {
                                c.this.bsl();
                            } else {
                                c.this.bsk();
                            }
                            c.this.mt(c.this.bJQ);
                            return;
                        }
                        c.this.aZX();
                        return;
                    } else if (view.getId() != c.this.fsj.getId()) {
                        if (c.this.gFE != null) {
                            c.this.gFE.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.gFO != null) {
                            c.this.gFO.aEh();
                        }
                        if (c.this.bsj()) {
                            c.this.bsl();
                            c.this.mt(false);
                            return;
                        }
                        c.this.aZX();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.boH();
                c.this.bsA();
                if (c.this.currentState != 1) {
                    c.this.bsw();
                    c.this.bsx();
                } else {
                    c.this.bal();
                }
                if (c.this.gFN != null) {
                    c.this.gFN.hz(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.bPc.stopPlayback();
            c.this.fsl = false;
            c.this.bsr();
        }
    };
    private Animation.AnimationListener fsJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener fsK = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable fsL = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bai();
        }
    };
    private CustomMessageListener fsM = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b fuH = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void hJ(int i2) {
            int duration;
            if (c.this.bPc != null && (duration = c.this.bPc.getDuration()) > 0 && c.this.gFu != null) {
                c.this.gFu.setProgress((int) ((i2 * c.this.frU.getWidth()) / duration));
                if (c.this.gFI != null) {
                    c.this.gFI.ie((c.this.bPc.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener bCO = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bsw();
            c.this.mx(false);
            if (c.this.gFN != null) {
                c.this.gFN.hz(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.aZY() != null) {
                c.this.setStartPosition(c.this.aZY().getSeekPosition());
                if (!c.this.bah()) {
                    c.this.bsr();
                } else {
                    c.this.bag();
                    if (c.this.gpd != null) {
                        c.this.gpd.aEj();
                    }
                }
            }
            c.this.mx(true);
            c.this.bsv();
            if (c.this.gFN != null) {
                c.this.gFN.hz(true);
            }
        }
    };
    private QuickVideoView.a gGg = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bsD() {
            if (!c.this.gFW) {
                c.this.bpJ.startLoading();
                c.this.fsg.setVisibility(0);
                c.this.gFw.setVisibility(8);
                c.this.gFy.setVisibility(8);
                c.this.gFx.setVisibility(8);
                c.this.gFz.setVisibility(8);
                c.this.daW.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsH);
                if (c.this.gFH > 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsH, c.this.gFH);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void hz(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0297c {
        void Zp();

        void Zq();
    }

    /* loaded from: classes.dex */
    public interface d {
        void aEi();

        void ha(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void mC(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void gZ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void boS();
    }

    /* loaded from: classes.dex */
    public interface i {
        void aEj();
    }

    /* loaded from: classes.dex */
    public interface j {
        void lT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void aEg();

        void aEh();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean boT();

        boolean boU();
    }

    /* loaded from: classes.dex */
    public interface n {
        void Zr();

        void Zs();

        void ie(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface o {
        void boR();
    }

    public c(Activity activity, View view, boolean z) {
        this.gGb = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.gGb = z;
            this.fsf = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.gGb = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.gGb = z;
            this.fsf = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.frU = N(this.mActivity);
        this.frU.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.frU);
        }
        this.bPc = (QuickVideoView) this.frU.findViewById(e.g.videoView);
        this.bpJ = new x((ViewGroup) this.frU.findViewById(e.g.auto_video_loading_container));
        this.bpJ.setLoadingAnimationListener(this.cYm);
        this.frW = (VideoListMediaControllerView) this.frU.findViewById(e.g.media_controller);
        this.frW.setPlayer(this.bPc);
        this.gFu = (ProgressBar) this.frU.findViewById(e.g.pgrBottomProgress);
        this.gFu.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.gFu.setProgress(0);
        this.frW.setOnSeekBarChangeListener(this.bCO);
        this.frW.setOnProgressUpdatedListener(this.fuH);
        this.frX = this.frU.findViewById(e.g.black_mask);
        this.daW = this.frU.findViewById(e.g.layout_error);
        this.daW.setOnClickListener(this.mOnClickListener);
        this.gFV = (TextView) this.frU.findViewById(e.g.auto_video_error_tips);
        this.frY = (FrameLayout) this.frU.findViewById(e.g.danmu_container);
        this.fsc = (ImageView) this.frU.findViewById(e.g.img_full_screen);
        this.fsc.setOnClickListener(this.mOnClickListener);
        this.fsd = this.frU.findViewById(e.g.layout_media_controller);
        this.gFv = this.frU.findViewById(e.g.time_show_controller);
        this.bPc.setPlayerReuseEnable(true);
        this.bPc.setContinuePlayEnable(true);
        this.bPc.setOnPreparedListener(this.byB);
        this.bPc.setOnCompletionListener(this.byA);
        this.bPc.setOnErrorListener(this.fsG);
        this.bPc.setOnSeekCompleteListener(this.byE);
        this.bPc.setOnSurfaceDestroyedListener(this.bpS);
        this.bPc.setOnRecoveryCallback(this.gGg);
        this.bPc.setOnOutInfoListener(this.byD);
        this.gFw = (SwitchImageView) this.frU.findViewById(e.g.img_play_controller);
        this.gFw.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
        this.gFw.setState(0);
        this.gFw.setOnClickListener(this.mOnClickListener);
        this.gFx = (TextView) this.frU.findViewById(e.g.txt_replay);
        this.gFx.setOnClickListener(this.mOnClickListener);
        this.gFy = (TextView) this.frU.findViewById(e.g.txt_playnext);
        this.gFy.setOnClickListener(this.mOnClickListener);
        this.gFz = (TextView) this.frU.findViewById(e.g.txt_next_video_title);
        this.fsg = (TbImageView) this.frU.findViewById(e.g.video_thumbnail);
        this.fsg.setDefaultErrorResource(0);
        this.fsg.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.fsj = (ImageView) this.frU.findViewById(e.g.img_exit);
        this.fsj.setOnClickListener(this.mOnClickListener);
        this.fsk = (TextView) this.frU.findViewById(e.g.video_title);
        this.daR = this.frU.findViewById(e.g.layout_title);
        this.daR.setVisibility(8);
        this.dQC = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.dQD = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.fsv = this.mAudioManager.getStreamMaxVolume(3);
        this.fsA = this.mAudioManager.getStreamVolume(3);
        fsB = 100 / this.fsv;
        this.frU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.gFL != null) {
                    c.this.gFL.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.fsl) {
                        if (c.this.mStatus == 1 && c.this.fsx != 0) {
                            c.this.b(c.this.fsx == 1 ? 1000.0f : -1000.0f, false);
                            c.this.fsx = 0;
                            c.this.fsw = 0;
                        }
                        if (!c.this.bPc.isPlaying()) {
                            c.this.gFy.setVisibility(8);
                            c.this.gFx.setVisibility(8);
                            c.this.gFz.setVisibility(8);
                        }
                    }
                    c.this.aZT();
                    if (c.this.gFL != null) {
                        c.this.gFL.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.bJN = new com.baidu.tieba.play.o(this.mActivity);
        if (this.gGb) {
            this.bJN.start();
        }
        this.fsz = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.ds16);
        this.fsC = new CallStateReceiver();
        this.fsC.register(this.mActivity);
        bsf();
        this.cYc = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.fsM);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.fsM);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bsf() {
        if (this.gFR) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.frU.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.frU.setSystemUiVisibility(0);
    }

    public void ms(boolean z) {
        this.gFR = z;
        bsf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZT() {
        this.mStatus = 0;
        if (this.fsp != null && this.fsp.getParent() != null && (this.fsp.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fsp.getParent()).removeView(this.fsp);
                this.fsp = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fsq != null && this.fsq.getParent() != null && (this.fsq.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fsq.getParent()).removeView(this.fsq);
                this.fsq = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aZU() {
        if (this.mStatus == 1) {
            if (this.fsp == null && this.frU != null && (this.frU instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_jindu, (ViewGroup) this.frU, true);
                this.fsp = this.frU.findViewById(e.g.lay_jindu);
                this.fsr = (TextView) this.fsp.findViewById(e.g.show_time);
                this.fsu = (ImageView) this.fsp.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fsq == null && this.frU != null && (this.frU instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_voice, (ViewGroup) this.frU, true);
            this.fsq = this.frU.findViewById(e.g.lay_voice);
            this.fst = (ImageView) this.fsq.findViewById(e.g.arrow_voice_icon);
            this.fss = (SeekBar) this.fsq.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.gFE = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gFL != null) {
                c.this.gFL.onStart();
            }
            if (c.this.bJQ && c.this.fsl) {
                if (c.this.mStatus == 1) {
                    c.this.bsy();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.au(f2);
                    }
                } else {
                    if (c.this.bJQ) {
                        c.this.aZW();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fsw = c.this.bPc.getCurrentPosition();
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
            if (!c.this.gGc) {
                if (c.this.gFM != null && c.this.gFM.boT()) {
                    return true;
                }
                c.this.boH();
                c.this.bsA();
                if (c.this.bPc.isPlaying()) {
                    c.this.bsv();
                } else {
                    c.this.bsw();
                }
                if (c.this.gFN != null) {
                    c.this.gFN.hz(c.this.bPc.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gGc) {
                if (c.this.fsl) {
                    if (c.this.gFM != null && c.this.gFM.boU()) {
                        return true;
                    }
                    c.this.bsu();
                    if (c.this.bPc.isPlaying()) {
                        c.this.bsv();
                    } else {
                        c.this.bsw();
                    }
                    if (c.this.gFN != null) {
                        c.this.gFN.hz(c.this.bPc.isPlaying());
                    }
                } else {
                    c.this.boH();
                    c.this.bsA();
                    if (c.this.currentState != 1) {
                        c.this.bsw();
                        c.this.bsx();
                    } else {
                        c.this.bal();
                    }
                    if (c.this.gFN != null) {
                        c.this.gFN.hz(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZW() {
        if (Build.VERSION.SDK_INT < 16) {
            this.frU.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.frU.setSystemUiVisibility(4);
        } else {
            this.frU.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.fsl) {
            this.mStatus = 0;
            return;
        }
        aZU();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % fsB == 0) {
            if (f2 > 0.0f && this.fsA < this.fsv) {
                this.fsA++;
            }
            if (f2 < 0.0f && this.fsA > 0) {
                this.fsA--;
            }
        }
        if (this.mProgress > 0) {
            this.fst.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.fst.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fsA, 0);
        this.fss.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fsw += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fsx = 1;
            } else {
                this.fsw += 1000;
                this.fsx = 2;
            }
            if (this.fsw < 0) {
                this.fsw = 0;
            } else if (this.fsw > this.bPc.getDuration()) {
                this.fsw = this.bPc.getDuration();
            }
        }
        aZU();
        String tG = this.frW.tG(this.fsw);
        if (f2 > 0.0f) {
            this.fsu.setImageResource(e.f.icon_kuaitui);
        } else {
            this.fsu.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tG)) {
            this.fsr.setText(new StringBuilder().append(tG).append("/").append(this.frW.tG(this.bPc.getDuration())));
        }
        this.frW.setCurrentDuration(this.fsw, z ? false : true);
        bsy();
        bsm();
    }

    protected View N(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(e.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.aFr = str;
        this.bjn = str2;
    }

    public void bsg() {
        if (this.bPc != null) {
            this.bPc.bsg();
        }
    }

    public void setFid(String str) {
        this.dbs = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        int i2 = 100;
        if (this.bPc != null && this.cYa != null && this.frW != null) {
            this.frW.showProgress();
            this.mStartPosition = y.btx().up(this.aFr);
            if (this.gFZ) {
                this.cYa.setVolume(1.0f, 1.0f);
                this.bPc.start();
                this.gFZ = false;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fsF, 20L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGf);
                if (this.bPc.bsT()) {
                    this.currentState = 1;
                    this.bPc.setRecoveryState(1);
                    bsy();
                }
                this.mStartPosition = y.btx().up(this.aFr);
                this.frW.setPlayer(this.bPc);
                if (this.mStartPosition != 0 && !this.cYa.isPlayerReuse()) {
                    this.gFT = true;
                }
                if (!this.gFY) {
                    this.frW.showProgress();
                }
                if (this.cYa.getDuration() <= 0) {
                    aZY().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.cYa.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cYi = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsh() {
        if (!this.fsl) {
            this.fsl = true;
            this.frX.setVisibility(8);
            this.daW.setVisibility(8);
            this.bpJ.bts();
            this.fsg.setVisibility(8);
            bsz();
            if (bsB()) {
                this.cYc.a(this.bjn, -1L, this.bPc.getDuration() / 1000, "middle", this.bPc);
            }
            this.frW.showProgress();
            this.gFu.setVisibility(0);
            if (this.fsh != null) {
                this.fsh.onPrepared(this.bPc.getPlayer());
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
    public void mt(boolean z) {
        if (hasNavBar(this.mActivity)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFv.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.gFv.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gFv.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.gFv.setLayoutParams(layoutParams);
        }
    }

    public void boH() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.S(this.mActivity, this.mActivity.getString(e.j.neterror));
        } else if (this.bPc.isPlaying()) {
            pausePlay();
            if (this.gFQ != null) {
                this.gFQ.onPause();
            }
            if (this.gFI != null) {
                this.gFI.onPaused();
            }
        } else if (this.fsl) {
            bag();
            if (this.gpd != null) {
                this.gpd.aEj();
            }
            if (this.gFI != null) {
                this.gFI.Zs();
            }
        } else {
            bsr();
        }
    }

    public boolean bsi() {
        return this.fsD;
    }

    public void aZX() {
        this.fsD = true;
        if (this.bJN != null) {
            this.bJN.aZX();
        }
    }

    public boolean bsj() {
        return this.cYa != null && this.cYa.getVideoHeight() > this.cYa.getVideoWidth();
    }

    public boolean tC(int i2) {
        switch (i2) {
            case 4:
                if (this.bJQ) {
                    if (bsj()) {
                        mt(false);
                        bsl();
                    } else {
                        aZX();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.fsv <= 0 || this.fss == null) {
                    return false;
                }
                this.fsA = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fsA * 100.0d) / this.fsv);
                this.fss.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bPc;
    }

    public VideoListMediaControllerView aZY() {
        return this.frW;
    }

    public void show() {
        this.frU.setVisibility(0);
    }

    public void bac() {
        if (this.fsf != null) {
            ViewGroup.LayoutParams layoutParams = this.fsf.getLayoutParams();
            this.frZ = (FrameLayout.LayoutParams) this.frU.getLayoutParams();
            this.frZ.width = layoutParams.width;
            this.frZ.height = layoutParams.height;
            this.frZ.topMargin = 0;
            this.frU.setLayoutParams(this.frZ);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fsD) {
            if (this.bJQ) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.fsD = false;
        }
        if (configuration.orientation == 2) {
            bsk();
        } else {
            bsl();
        }
        bsm();
        bag();
        bsA();
        bal();
        if (this.gFN != null) {
            this.gFN.hz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsk() {
        this.bJQ = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bsj()) {
            this.frU.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.frU.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        e(this.mActivity, true);
        this.daR.setVisibility(0);
        this.fsj.setVisibility(0);
        this.fsk.setVisibility(0);
        this.frY.setVisibility(8);
        this.bpJ.btt();
        this.fsg.setVisibility(8);
        this.fsc.setImageResource(e.f.icon_video_narrow_white);
        rm(this.fsz);
        aZW();
        if (this.gFF != null) {
            this.gFF.Zp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsl() {
        this.bJQ = false;
        if (this.frZ != null) {
            this.frU.setLayoutParams(this.frZ);
        }
        e(this.mActivity, false);
        this.daR.setVisibility(8);
        this.frY.setVisibility(0);
        this.bpJ.btt();
        this.fsg.setVisibility(8);
        this.fsc.setImageResource(e.f.icon_video_enlarge_white);
        if (this.frW != null && (this.frW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frW.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds24);
            layoutParams.rightMargin = 0;
            this.frW.setLayoutParams(layoutParams);
        }
        this.frU.setSystemUiVisibility(0);
        bsf();
        if (this.gFF != null) {
            this.gFF.Zq();
        }
    }

    public void bsm() {
        if (this.bPc != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.bJQ) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.gFu.setMax(aO);
            int duration = this.bPc.getDuration();
            if (duration > 0) {
                if (this.gFx.getVisibility() == 0) {
                    this.gFu.setProgress(this.gFu.getMax());
                } else {
                    this.gFu.setProgress((int) ((this.bPc.getCurrentPosition() * this.gFu.getMax()) / duration));
                }
            }
        }
    }

    private void rm(int i2) {
        if (this.frW != null && (this.frW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frW.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.frW.setLayoutParams(layoutParams);
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

    public boolean bae() {
        return !this.bJQ;
    }

    public void a(g.f fVar) {
        this.fsh = fVar;
    }

    public void a(g.a aVar) {
        this.gFA = aVar;
    }

    public void a(g.b bVar) {
        this.gFB = bVar;
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bPc != null) {
            this.bPc.setPbLoadingTime(currentTimeMillis);
        }
        ba(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gFU) {
            ct(str, str2);
        } else {
            ba(str, str2);
        }
        if (eVar != null) {
            eVar.mC(z);
        }
    }

    public void cs(String str, String str2) {
    }

    public void ba(String str, String str2) {
        bss();
        this.gFZ = true;
        this.currentState = 0;
        this.bPc.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bPc.setVideoPath(str, str2);
        this.cYc.bdX();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        if (this.gFH > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fsH, this.gFH);
        }
        if (this.gFI != null) {
            this.gFI.onStarted();
        }
        this.bpJ.startLoading();
        mu(true);
    }

    public void ct(String str, String str2) {
        bss();
        this.gFZ = true;
        this.currentState = 0;
        this.bPc.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        if (this.gFH > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fsH, this.gFH);
        }
        if (this.gFI != null) {
            this.gFI.onStarted();
        }
        this.bpJ.startLoading();
        mu(true);
    }

    public void bsn() {
        bag();
        this.gFu.setVisibility(0);
    }

    public void bag() {
        int i2 = 100;
        if (this.bPc != null && this.frW != null) {
            this.fsl = true;
            this.currentState = 1;
            this.bPc.setRecoveryState(1);
            this.bPc.start();
            if (this.cYa != null && this.frW != null) {
                this.mStartPosition = y.btx().up(this.aFr);
                if (this.mStartPosition != 0 && !this.cYa.isPlayerReuse()) {
                    this.gFT = true;
                }
                if (this.mStartPosition > 100 && this.cYa.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cYi = i2;
            } else {
                this.cYi = 100;
            }
            this.bpJ.btt();
            mu(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kV() && this.gFX && !StringUtils.isNull(this.aFr) && !StringUtils.isNull(this.bjn)) {
            this.gFX = false;
            this.gFY = true;
            ba(this.aFr, this.bjn);
        }
    }

    private void mu(boolean z) {
        if (z) {
            this.fsg.setVisibility(0);
            bsy();
            this.gFu.setProgress(0);
        } else {
            this.fsg.setVisibility(8);
        }
        this.frW.showProgress();
        this.frX.setVisibility(8);
        this.gFy.setVisibility(8);
        this.gFx.setVisibility(8);
        this.gFz.setVisibility(8);
        this.daW.setVisibility(8);
    }

    private void bso() {
        this.bpJ.btt();
        this.gFy.setVisibility(8);
        this.gFx.setVisibility(8);
        this.gFz.setVisibility(8);
        bsA();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bPc != null) {
            this.bPc.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bPc.pause();
        this.currentState = 2;
        this.bPc.setRecoveryState(2);
        bso();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bPc.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGf);
        this.bPc.stopPlayback();
        this.fsl = false;
        this.gFZ = false;
        this.mStartPosition = 0;
        aNk();
    }

    public void bsp() {
        if (this.bPc.getDuration() >= this.bPc.getCurrentPosition()) {
            y.btx().aO(this.aFr, this.bPc.getCurrentPosition());
        }
    }

    public void mv(boolean z) {
        this.gFS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        if (this.fsd != null) {
            this.frX.setVisibility(0);
            this.gFy.setVisibility(8);
            this.gFx.setVisibility(8);
            this.gFz.setVisibility(8);
            this.bpJ.btt();
            bsy();
            this.gFu.setVisibility(8);
            this.daW.setVisibility(8);
            this.frW.WJ();
            this.fsg.setVisibility(z ? 0 : 8);
        }
    }

    public void aNk() {
        mw(true);
    }

    public boolean bsq() {
        if (this.bPc == null) {
            return false;
        }
        return this.bPc.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bPc == null) {
            return 0;
        }
        return this.bPc.getCurrentPosition();
    }

    public void a(k kVar) {
        this.gFL = kVar;
    }

    public void a(j jVar) {
        this.gFK = jVar;
    }

    public void a(i iVar) {
        this.gpd = iVar;
    }

    public void a(g gVar) {
        this.gFQ = gVar;
    }

    public void a(h hVar) {
        this.gFJ = hVar;
    }

    public void tM(String str) {
        this.goD = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsr() {
        a(this.aFr, this.bjn, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.gFG = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bss();
        if (com.baidu.adp.lib.util.j.kX() && !com.baidu.tieba.video.g.bJp().bJq()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gFU = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gFP != null) {
                    this.gFP.gZ(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.eK(TbadkCoreApplication.getInst().getString(e.j.play_video_mobile_tip));
                aVar.a(e.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bst();
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
                aVar.b(this.mContext).BS();
                return;
            } else if (this.gFP != null) {
                this.gFP.gZ(true);
                return;
            } else {
                if (!this.gFt) {
                    this.gFt = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gFO != null) {
            this.gFO.aEg();
        }
    }

    private void bss() {
        if (com.baidu.adp.lib.util.j.kX()) {
            com.baidu.tieba.video.g.bJp().dc(this.mActivity);
        }
    }

    public void bst() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.fsg.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsL);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsF);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsH);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGe);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGf);
        this.bJN.stop();
        this.fsC.unregister(this.mActivity);
    }

    public void uk(String str) {
        this.fsk.setText(str);
    }

    public boolean bah() {
        return this.fsl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsu() {
        if (this.fsd != null) {
            if (this.gFC) {
                bsy();
            } else {
                bsx();
            }
        }
    }

    public void bal() {
        bsx();
        bsv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsv() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsL);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fsL, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsw() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsL);
    }

    public void bsx() {
        if (this.fsd != null && !this.gFC && !this.gGd) {
            mx(true);
            bak();
            this.fsd.setVisibility(0);
            this.gFv.setVisibility(0);
            this.gFu.setVisibility(8);
            this.gFC = true;
            if (this.gFG != null) {
                this.gFG.ha(false);
            }
        }
    }

    public void bai() {
        if (this.fsd != null && this.gFC) {
            mx(false);
            bak();
            this.fsd.setVisibility(8);
            this.gFv.setVisibility(8);
            this.gFu.setVisibility(0);
            this.dQC.setAnimationListener(this.fsJ);
            this.fsd.startAnimation(this.dQC);
            this.gFC = false;
            if (this.gFG != null) {
                this.gFG.aEi();
            }
        }
    }

    public void bsy() {
        if (this.fsd != null && this.gFC) {
            this.dQD.cancel();
            this.dQC.cancel();
            mx(false);
            bak();
            this.fsd.setVisibility(8);
            this.gFv.setVisibility(8);
            this.gFu.setVisibility(0);
            this.gFC = false;
            if (this.gFG != null) {
                this.gFG.aEi();
            }
        }
    }

    private void bak() {
        if (this.fsd != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsL);
            this.dQD.setAnimationListener(null);
            this.dQC.setAnimationListener(null);
            this.fsd.clearAnimation();
        }
    }

    private void bsz() {
        if (this.fsd != null) {
            this.dQD.setAnimationListener(null);
            this.dQC.setAnimationListener(null);
            this.fsd.clearAnimation();
        }
    }

    public void mx(boolean z) {
        bsA();
        if (z) {
            this.gFw.setVisibility(0);
        } else {
            this.gFw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsA() {
        if (this.currentState == 1) {
            this.gFw.setState(1);
        } else {
            this.gFw.setState(0);
        }
    }

    public void a(InterfaceC0297c interfaceC0297c) {
        this.gFF = interfaceC0297c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void S(boolean z, boolean z2) {
        if (this.bJN != null) {
            if (this.fsc != null) {
                this.fsc.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.frW != null && (this.frW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frW.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds52);
                this.frW.setLayoutParams(layoutParams);
            }
            this.bJN.mE(z);
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

    public void my(boolean z) {
        this.gGc = z;
    }

    public void a(m mVar) {
        this.gFM = mVar;
    }

    public void a(a aVar) {
        this.gFN = aVar;
    }

    public void a(l lVar) {
        this.gFO = lVar;
    }

    public void a(f fVar) {
        this.gFP = fVar;
    }

    public void mz(boolean z) {
        this.gFW = z;
    }

    public boolean bsB() {
        return this.gFD;
    }

    public void mA(boolean z) {
        this.gFD = z;
    }

    public void tD(int i2) {
        this.gGa = i2;
    }

    public View bsC() {
        return this.frU;
    }

    public void a(n nVar) {
        this.gFI = nVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.bPc != null) {
            this.bPc.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.fsA = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mB(boolean z) {
        this.gGd = z;
        if (z) {
            bsy();
        } else {
            bal();
        }
    }

    public void a(o oVar) {
        this.goR = oVar;
    }
}
