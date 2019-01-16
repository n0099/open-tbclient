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
    private static int fsA;
    private String aFq;
    private com.baidu.tieba.play.o bJM;
    protected QuickVideoView bPb;
    private String bjm;
    private x bpI;
    private com.baidu.tieba.play.g cXZ;
    private com.baidu.tieba.j.k cYb;
    private Animation dQB;
    private Animation dQC;
    private View daQ;
    protected View daV;
    private String dbr;
    public View frT;
    private VideoListMediaControllerView frV;
    private View frW;
    private FrameLayout frX;
    protected FrameLayout.LayoutParams frY;
    private CallStateReceiver fsB;
    private ImageView fsb;
    private View fsc;
    private View fse;
    private TbImageView fsf;
    private g.f fsg;
    private ImageView fsi;
    private TextView fsj;
    private View fso;
    private View fsp;
    private TextView fsq;
    private SeekBar fsr;
    private ImageView fss;
    private ImageView fst;
    private int fsu;
    private int fsz;
    private g.b gFA;
    private View.OnClickListener gFD;
    protected InterfaceC0297c gFE;
    private d gFF;
    private n gFH;
    private h gFI;
    private j gFJ;
    private k gFK;
    private m gFL;
    private a gFM;
    private l gFN;
    private f gFO;
    private g gFP;
    private TextView gFU;
    private boolean gFW;
    private boolean gFX;
    private boolean gFY;
    private int gFZ;
    private ProgressBar gFt;
    private View gFu;
    private SwitchImageView gFv;
    private TextView gFw;
    private TextView gFx;
    private TextView gFy;
    private g.a gFz;
    private boolean gGa;
    private boolean gGb;
    private o goQ;
    private i gpc;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cYh = 100;
    private boolean gFs = false;
    protected boolean bJP = false;
    private boolean fsk = false;
    private boolean gFB = false;
    private boolean gFC = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fsv = 0;
    private int fsw = 0;
    private long gFG = 60000;
    private int fsy = 0;
    private boolean fsC = false;
    private boolean gFQ = true;
    private boolean gFR = true;
    private boolean gFS = false;
    private boolean gFT = false;
    private String goC = null;
    private int currentState = -1;
    private boolean gFV = false;
    private boolean gGc = false;
    private g.f byA = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cXZ = gVar;
            c.this.cYb.bdY();
            c.this.aqx();
        }
    };
    private g.e byC = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.bsh();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cYl = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aqx();
        }
    };
    private Runnable fsE = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsE);
            if (!c.this.fsk) {
                if (c.this.bPb.getCurrentPosition() > c.this.cYh) {
                    c.this.bsh();
                } else {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsE, 20L);
                }
            }
        }
    };
    private g.a byz = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bPb != null) {
                int duration = c.this.bPb.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.fsk = false;
                    c.this.gFY = false;
                    c.this.mStartPosition = 0;
                    c.this.aZT();
                    c.this.frW.setVisibility(0);
                    c.this.gFt.setProgress(c.this.gFt.getMax());
                    c.this.cYh = 100;
                    if (c.this.gFz != null) {
                        c.this.gFz.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bPb.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.mw(false);
                        c.this.mx(true);
                    } else {
                        c.this.bsy();
                        c.this.gFw.setVisibility(0);
                    }
                    if (!c.this.bJP && duration <= 150000) {
                        if (!c.this.gFV) {
                            if (c.this.gFJ != null) {
                                c.this.gFJ.lT(true);
                            }
                            c.this.ba(c.this.aFq, c.this.bjm);
                        } else {
                            c.this.currentState = 5;
                            c.this.bPb.setRecoveryState(5);
                            c.this.bPb.getPlayer().pause();
                            c.this.bPb.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.gFH != null) {
                        c.this.gFH.ie(c.this.gFt.getMax());
                        c.this.gFH.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b fsF = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.daV.setVisibility(0);
            c.this.bpI.btt();
            c.this.currentState = 4;
            c.this.bPb.setRecoveryState(4);
            if (c.this.gFA != null) {
                c.this.gFA.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kV()) {
                c.this.gFW = true;
            }
            if (c.this.gFH != null) {
                c.this.gFH.Zr();
            }
            c.this.gFY = false;
            return true;
        }
    };
    protected Runnable fsG = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bPb == null || !c.this.bPb.isPlaying()) {
                c.this.daV.setVisibility(0);
                c.this.bpI.btt();
                if (c.this.gFH != null) {
                    c.this.gFH.Zr();
                }
            }
        }
    };
    private g.InterfaceC0298g byD = new g.InterfaceC0298g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0298g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gFS) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gGd, 200L);
            }
        }
    };
    private Runnable gGd = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bPb == null || !c.this.gFS) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsE, 200L);
                c.this.gFS = false;
            } else if (c.this.mStartPosition != c.this.bPb.getCurrentPosition()) {
                c.this.gFS = false;
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsE, 20L);
            } else {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gGd, 200L);
            }
        }
    };
    private QuickVideoView.b bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fsk = false;
            if (c.this.gFC) {
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.gGe, 300L);
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsE);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsG);
        }
    };
    private Runnable gGe = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.gFY = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.goQ != null) {
                c.this.goQ.boR();
            }
            if (view.getId() != c.this.daV.getId()) {
                if (view.getId() != c.this.gFv.getId()) {
                    if (view.getId() == c.this.gFx.getId()) {
                        if (c.this.gFI != null) {
                            c.this.gFI.boS();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.gFw.getId()) {
                        if (c.this.gFJ != null) {
                            c.this.gFJ.lT(false);
                        }
                        c.this.ba(c.this.aFq, c.this.bjm);
                        return;
                    } else if (view.getId() == c.this.fsb.getId()) {
                        int i2 = c.this.gFC ? 1 : 2;
                        if (c.this.bJP) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").aB("tid", c.this.bjm).aB(ImageViewerConfig.FORUM_ID, c.this.dbr).y("obj_type", i2).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").aB("tid", c.this.bjm).aB(ImageViewerConfig.FORUM_ID, c.this.dbr).y("obj_type", i2).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.gFN != null) {
                            c.this.gFN.aEh();
                        }
                        if (c.this.bsj()) {
                            if (c.this.bJP) {
                                c.this.bsl();
                            } else {
                                c.this.bsk();
                            }
                            c.this.mt(c.this.bJP);
                            return;
                        }
                        c.this.aZX();
                        return;
                    } else if (view.getId() != c.this.fsi.getId()) {
                        if (c.this.gFD != null) {
                            c.this.gFD.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.gFN != null) {
                            c.this.gFN.aEh();
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
                if (c.this.gFM != null) {
                    c.this.gFM.hz(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.bPb.stopPlayback();
            c.this.fsk = false;
            c.this.bsr();
        }
    };
    private Animation.AnimationListener fsI = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener fsJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable fsK = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bai();
        }
    };
    private CustomMessageListener fsL = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b fuG = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void hJ(int i2) {
            int duration;
            if (c.this.bPb != null && (duration = c.this.bPb.getDuration()) > 0 && c.this.gFt != null) {
                c.this.gFt.setProgress((int) ((i2 * c.this.frT.getWidth()) / duration));
                if (c.this.gFH != null) {
                    c.this.gFH.ie((c.this.bPb.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener bCN = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bsw();
            c.this.mx(false);
            if (c.this.gFM != null) {
                c.this.gFM.hz(false);
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
                    if (c.this.gpc != null) {
                        c.this.gpc.aEj();
                    }
                }
            }
            c.this.mx(true);
            c.this.bsv();
            if (c.this.gFM != null) {
                c.this.gFM.hz(true);
            }
        }
    };
    private QuickVideoView.a gGf = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bsD() {
            if (!c.this.gFV) {
                c.this.bpI.startLoading();
                c.this.fsf.setVisibility(0);
                c.this.gFv.setVisibility(8);
                c.this.gFx.setVisibility(8);
                c.this.gFw.setVisibility(8);
                c.this.gFy.setVisibility(8);
                c.this.daV.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(c.this.fsG);
                if (c.this.gFG > 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(c.this.fsG, c.this.gFG);
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
        this.gGa = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.gGa = z;
            this.fse = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.gGa = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.gGa = z;
            this.fse = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.frT = N(this.mActivity);
        this.frT.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.frT);
        }
        this.bPb = (QuickVideoView) this.frT.findViewById(e.g.videoView);
        this.bpI = new x((ViewGroup) this.frT.findViewById(e.g.auto_video_loading_container));
        this.bpI.setLoadingAnimationListener(this.cYl);
        this.frV = (VideoListMediaControllerView) this.frT.findViewById(e.g.media_controller);
        this.frV.setPlayer(this.bPb);
        this.gFt = (ProgressBar) this.frT.findViewById(e.g.pgrBottomProgress);
        this.gFt.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.gFt.setProgress(0);
        this.frV.setOnSeekBarChangeListener(this.bCN);
        this.frV.setOnProgressUpdatedListener(this.fuG);
        this.frW = this.frT.findViewById(e.g.black_mask);
        this.daV = this.frT.findViewById(e.g.layout_error);
        this.daV.setOnClickListener(this.mOnClickListener);
        this.gFU = (TextView) this.frT.findViewById(e.g.auto_video_error_tips);
        this.frX = (FrameLayout) this.frT.findViewById(e.g.danmu_container);
        this.fsb = (ImageView) this.frT.findViewById(e.g.img_full_screen);
        this.fsb.setOnClickListener(this.mOnClickListener);
        this.fsc = this.frT.findViewById(e.g.layout_media_controller);
        this.gFu = this.frT.findViewById(e.g.time_show_controller);
        this.bPb.setPlayerReuseEnable(true);
        this.bPb.setContinuePlayEnable(true);
        this.bPb.setOnPreparedListener(this.byA);
        this.bPb.setOnCompletionListener(this.byz);
        this.bPb.setOnErrorListener(this.fsF);
        this.bPb.setOnSeekCompleteListener(this.byD);
        this.bPb.setOnSurfaceDestroyedListener(this.bpR);
        this.bPb.setOnRecoveryCallback(this.gGf);
        this.bPb.setOnOutInfoListener(this.byC);
        this.gFv = (SwitchImageView) this.frT.findViewById(e.g.img_play_controller);
        this.gFv.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
        this.gFv.setState(0);
        this.gFv.setOnClickListener(this.mOnClickListener);
        this.gFw = (TextView) this.frT.findViewById(e.g.txt_replay);
        this.gFw.setOnClickListener(this.mOnClickListener);
        this.gFx = (TextView) this.frT.findViewById(e.g.txt_playnext);
        this.gFx.setOnClickListener(this.mOnClickListener);
        this.gFy = (TextView) this.frT.findViewById(e.g.txt_next_video_title);
        this.fsf = (TbImageView) this.frT.findViewById(e.g.video_thumbnail);
        this.fsf.setDefaultErrorResource(0);
        this.fsf.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.fsi = (ImageView) this.frT.findViewById(e.g.img_exit);
        this.fsi.setOnClickListener(this.mOnClickListener);
        this.fsj = (TextView) this.frT.findViewById(e.g.video_title);
        this.daQ = this.frT.findViewById(e.g.layout_title);
        this.daQ.setVisibility(8);
        this.dQB = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.dQC = AnimationUtils.loadAnimation(this.mActivity, e.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.fsu = this.mAudioManager.getStreamMaxVolume(3);
        this.fsz = this.mAudioManager.getStreamVolume(3);
        fsA = 100 / this.fsu;
        this.frT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.gFK != null) {
                    c.this.gFK.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.fsk) {
                        if (c.this.mStatus == 1 && c.this.fsw != 0) {
                            c.this.b(c.this.fsw == 1 ? 1000.0f : -1000.0f, false);
                            c.this.fsw = 0;
                            c.this.fsv = 0;
                        }
                        if (!c.this.bPb.isPlaying()) {
                            c.this.gFx.setVisibility(8);
                            c.this.gFw.setVisibility(8);
                            c.this.gFy.setVisibility(8);
                        }
                    }
                    c.this.aZT();
                    if (c.this.gFK != null) {
                        c.this.gFK.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.bJM = new com.baidu.tieba.play.o(this.mActivity);
        if (this.gGa) {
            this.bJM.start();
        }
        this.fsy = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.ds16);
        this.fsB = new CallStateReceiver();
        this.fsB.register(this.mActivity);
        bsf();
        this.cYb = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.fsL);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.fsL);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bsf() {
        if (this.gFQ) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.frT.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.frT.setSystemUiVisibility(0);
    }

    public void ms(boolean z) {
        this.gFQ = z;
        bsf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZT() {
        this.mStatus = 0;
        if (this.fso != null && this.fso.getParent() != null && (this.fso.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fso.getParent()).removeView(this.fso);
                this.fso = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fsp != null && this.fsp.getParent() != null && (this.fsp.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fsp.getParent()).removeView(this.fsp);
                this.fsp = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aZU() {
        if (this.mStatus == 1) {
            if (this.fso == null && this.frT != null && (this.frT instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_jindu, (ViewGroup) this.frT, true);
                this.fso = this.frT.findViewById(e.g.lay_jindu);
                this.fsq = (TextView) this.fso.findViewById(e.g.show_time);
                this.fst = (ImageView) this.fso.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fsp == null && this.frT != null && (this.frT instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(e.h.float_video_window_voice, (ViewGroup) this.frT, true);
            this.fsp = this.frT.findViewById(e.g.lay_voice);
            this.fss = (ImageView) this.fsp.findViewById(e.g.arrow_voice_icon);
            this.fsr = (SeekBar) this.fsp.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.gFD = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gFK != null) {
                c.this.gFK.onStart();
            }
            if (c.this.bJP && c.this.fsk) {
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
                    if (c.this.bJP) {
                        c.this.aZW();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fsv = c.this.bPb.getCurrentPosition();
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
            if (!c.this.gGb) {
                if (c.this.gFL != null && c.this.gFL.boT()) {
                    return true;
                }
                c.this.boH();
                c.this.bsA();
                if (c.this.bPb.isPlaying()) {
                    c.this.bsv();
                } else {
                    c.this.bsw();
                }
                if (c.this.gFM != null) {
                    c.this.gFM.hz(c.this.bPb.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gGb) {
                if (c.this.fsk) {
                    if (c.this.gFL != null && c.this.gFL.boU()) {
                        return true;
                    }
                    c.this.bsu();
                    if (c.this.bPb.isPlaying()) {
                        c.this.bsv();
                    } else {
                        c.this.bsw();
                    }
                    if (c.this.gFM != null) {
                        c.this.gFM.hz(c.this.bPb.isPlaying());
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
                    if (c.this.gFM != null) {
                        c.this.gFM.hz(c.this.currentState == 1);
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
            this.frT.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.frT.setSystemUiVisibility(4);
        } else {
            this.frT.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f2) {
        if (!this.fsk) {
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
        if (this.mProgress % fsA == 0) {
            if (f2 > 0.0f && this.fsz < this.fsu) {
                this.fsz++;
            }
            if (f2 < 0.0f && this.fsz > 0) {
                this.fsz--;
            }
        }
        if (this.mProgress > 0) {
            this.fss.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.fss.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fsz, 0);
        this.fsr.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fsv += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fsw = 1;
            } else {
                this.fsv += 1000;
                this.fsw = 2;
            }
            if (this.fsv < 0) {
                this.fsv = 0;
            } else if (this.fsv > this.bPb.getDuration()) {
                this.fsv = this.bPb.getDuration();
            }
        }
        aZU();
        String tG = this.frV.tG(this.fsv);
        if (f2 > 0.0f) {
            this.fst.setImageResource(e.f.icon_kuaitui);
        } else {
            this.fst.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tG)) {
            this.fsq.setText(new StringBuilder().append(tG).append("/").append(this.frV.tG(this.bPb.getDuration())));
        }
        this.frV.setCurrentDuration(this.fsv, z ? false : true);
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
        this.aFq = str;
        this.bjm = str2;
    }

    public void bsg() {
        if (this.bPb != null) {
            this.bPb.bsg();
        }
    }

    public void setFid(String str) {
        this.dbr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        int i2 = 100;
        if (this.bPb != null && this.cXZ != null && this.frV != null) {
            this.frV.showProgress();
            this.mStartPosition = y.btx().up(this.aFq);
            if (this.gFY) {
                this.cXZ.setVolume(1.0f, 1.0f);
                this.bPb.start();
                this.gFY = false;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fsE, 20L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGe);
                if (this.bPb.bsT()) {
                    this.currentState = 1;
                    this.bPb.setRecoveryState(1);
                    bsy();
                }
                this.mStartPosition = y.btx().up(this.aFq);
                this.frV.setPlayer(this.bPb);
                if (this.mStartPosition != 0 && !this.cXZ.isPlayerReuse()) {
                    this.gFS = true;
                }
                if (!this.gFX) {
                    this.frV.showProgress();
                }
                if (this.cXZ.getDuration() <= 0) {
                    aZY().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.cXZ.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cYh = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsh() {
        if (!this.fsk) {
            this.fsk = true;
            this.frW.setVisibility(8);
            this.daV.setVisibility(8);
            this.bpI.bts();
            this.fsf.setVisibility(8);
            bsz();
            if (bsB()) {
                this.cYb.a(this.bjm, -1L, this.bPb.getDuration() / 1000, "middle", this.bPb);
            }
            this.frV.showProgress();
            this.gFt.setVisibility(0);
            if (this.fsg != null) {
                this.fsg.onPrepared(this.bPb.getPlayer());
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFu.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.gFu.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gFu.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.gFu.setLayoutParams(layoutParams);
        }
    }

    public void boH() {
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.S(this.mActivity, this.mActivity.getString(e.j.neterror));
        } else if (this.bPb.isPlaying()) {
            pausePlay();
            if (this.gFP != null) {
                this.gFP.onPause();
            }
            if (this.gFH != null) {
                this.gFH.onPaused();
            }
        } else if (this.fsk) {
            bag();
            if (this.gpc != null) {
                this.gpc.aEj();
            }
            if (this.gFH != null) {
                this.gFH.Zs();
            }
        } else {
            bsr();
        }
    }

    public boolean bsi() {
        return this.fsC;
    }

    public void aZX() {
        this.fsC = true;
        if (this.bJM != null) {
            this.bJM.aZX();
        }
    }

    public boolean bsj() {
        return this.cXZ != null && this.cXZ.getVideoHeight() > this.cXZ.getVideoWidth();
    }

    public boolean tC(int i2) {
        switch (i2) {
            case 4:
                if (this.bJP) {
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
                if (this.mAudioManager == null || this.fsu <= 0 || this.fsr == null) {
                    return false;
                }
                this.fsz = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fsz * 100.0d) / this.fsu);
                this.fsr.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bPb;
    }

    public VideoListMediaControllerView aZY() {
        return this.frV;
    }

    public void show() {
        this.frT.setVisibility(0);
    }

    public void bac() {
        if (this.fse != null) {
            ViewGroup.LayoutParams layoutParams = this.fse.getLayoutParams();
            this.frY = (FrameLayout.LayoutParams) this.frT.getLayoutParams();
            this.frY.width = layoutParams.width;
            this.frY.height = layoutParams.height;
            this.frY.topMargin = 0;
            this.frT.setLayoutParams(this.frY);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fsC) {
            if (this.bJP) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.fsC = false;
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
        if (this.gFM != null) {
            this.gFM.hz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsk() {
        this.bJP = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bsj()) {
            this.frT.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.frT.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        e(this.mActivity, true);
        this.daQ.setVisibility(0);
        this.fsi.setVisibility(0);
        this.fsj.setVisibility(0);
        this.frX.setVisibility(8);
        this.bpI.btt();
        this.fsf.setVisibility(8);
        this.fsb.setImageResource(e.f.icon_video_narrow_white);
        rm(this.fsy);
        aZW();
        if (this.gFE != null) {
            this.gFE.Zp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsl() {
        this.bJP = false;
        if (this.frY != null) {
            this.frT.setLayoutParams(this.frY);
        }
        e(this.mActivity, false);
        this.daQ.setVisibility(8);
        this.frX.setVisibility(0);
        this.bpI.btt();
        this.fsf.setVisibility(8);
        this.fsb.setImageResource(e.f.icon_video_enlarge_white);
        if (this.frV != null && (this.frV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frV.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds24);
            layoutParams.rightMargin = 0;
            this.frV.setLayoutParams(layoutParams);
        }
        this.frT.setSystemUiVisibility(0);
        bsf();
        if (this.gFE != null) {
            this.gFE.Zq();
        }
    }

    public void bsm() {
        if (this.bPb != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.bJP) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.gFt.setMax(aO);
            int duration = this.bPb.getDuration();
            if (duration > 0) {
                if (this.gFw.getVisibility() == 0) {
                    this.gFt.setProgress(this.gFt.getMax());
                } else {
                    this.gFt.setProgress((int) ((this.bPb.getCurrentPosition() * this.gFt.getMax()) / duration));
                }
            }
        }
    }

    private void rm(int i2) {
        if (this.frV != null && (this.frV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frV.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.frV.setLayoutParams(layoutParams);
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
        return !this.bJP;
    }

    public void a(g.f fVar) {
        this.fsg = fVar;
    }

    public void a(g.a aVar) {
        this.gFz = aVar;
    }

    public void a(g.b bVar) {
        this.gFA = bVar;
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bPb != null) {
            this.bPb.setPbLoadingTime(currentTimeMillis);
        }
        ba(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gFT) {
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
        this.gFY = true;
        this.currentState = 0;
        this.bPb.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bPb.setVideoPath(str, str2);
        this.cYb.bdX();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        if (this.gFG > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fsG, this.gFG);
        }
        if (this.gFH != null) {
            this.gFH.onStarted();
        }
        this.bpI.startLoading();
        mu(true);
    }

    public void ct(String str, String str2) {
        bss();
        this.gFY = true;
        this.currentState = 0;
        this.bPb.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        if (this.gFG > 0) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.fsG, this.gFG);
        }
        if (this.gFH != null) {
            this.gFH.onStarted();
        }
        this.bpI.startLoading();
        mu(true);
    }

    public void bsn() {
        bag();
        this.gFt.setVisibility(0);
    }

    public void bag() {
        int i2 = 100;
        if (this.bPb != null && this.frV != null) {
            this.fsk = true;
            this.currentState = 1;
            this.bPb.setRecoveryState(1);
            this.bPb.start();
            if (this.cXZ != null && this.frV != null) {
                this.mStartPosition = y.btx().up(this.aFq);
                if (this.mStartPosition != 0 && !this.cXZ.isPlayerReuse()) {
                    this.gFS = true;
                }
                if (this.mStartPosition > 100 && this.cXZ.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cYh = i2;
            } else {
                this.cYh = 100;
            }
            this.bpI.btt();
            mu(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kV() && this.gFW && !StringUtils.isNull(this.aFq) && !StringUtils.isNull(this.bjm)) {
            this.gFW = false;
            this.gFX = true;
            ba(this.aFq, this.bjm);
        }
    }

    private void mu(boolean z) {
        if (z) {
            this.fsf.setVisibility(0);
            bsy();
            this.gFt.setProgress(0);
        } else {
            this.fsf.setVisibility(8);
        }
        this.frV.showProgress();
        this.frW.setVisibility(8);
        this.gFx.setVisibility(8);
        this.gFw.setVisibility(8);
        this.gFy.setVisibility(8);
        this.daV.setVisibility(8);
    }

    private void bso() {
        this.bpI.btt();
        this.gFx.setVisibility(8);
        this.gFw.setVisibility(8);
        this.gFy.setVisibility(8);
        bsA();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bPb != null) {
            this.bPb.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bPb.pause();
        this.currentState = 2;
        this.bPb.setRecoveryState(2);
        bso();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bPb.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGe);
        this.bPb.stopPlayback();
        this.fsk = false;
        this.gFY = false;
        this.mStartPosition = 0;
        aNk();
    }

    public void bsp() {
        if (this.bPb.getDuration() >= this.bPb.getCurrentPosition()) {
            y.btx().aO(this.aFq, this.bPb.getCurrentPosition());
        }
    }

    public void mv(boolean z) {
        this.gFR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        if (this.fsc != null) {
            this.frW.setVisibility(0);
            this.gFx.setVisibility(8);
            this.gFw.setVisibility(8);
            this.gFy.setVisibility(8);
            this.bpI.btt();
            bsy();
            this.gFt.setVisibility(8);
            this.daV.setVisibility(8);
            this.frV.WJ();
            this.fsf.setVisibility(z ? 0 : 8);
        }
    }

    public void aNk() {
        mw(true);
    }

    public boolean bsq() {
        if (this.bPb == null) {
            return false;
        }
        return this.bPb.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bPb == null) {
            return 0;
        }
        return this.bPb.getCurrentPosition();
    }

    public void a(k kVar) {
        this.gFK = kVar;
    }

    public void a(j jVar) {
        this.gFJ = jVar;
    }

    public void a(i iVar) {
        this.gpc = iVar;
    }

    public void a(g gVar) {
        this.gFP = gVar;
    }

    public void a(h hVar) {
        this.gFI = hVar;
    }

    public void tM(String str) {
        this.goC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsr() {
        a(this.aFq, this.bjm, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.gFF = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bss();
        if (com.baidu.adp.lib.util.j.kX() && !com.baidu.tieba.video.g.bJp().bJq()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gFT = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gFO != null) {
                    this.gFO.gZ(false);
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
            } else if (this.gFO != null) {
                this.gFO.gZ(true);
                return;
            } else {
                if (!this.gFs) {
                    this.gFs = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gFN != null) {
            this.gFN.aEg();
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
        this.fsf.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsK);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsE);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsG);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGd);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gGe);
        this.bJM.stop();
        this.fsB.unregister(this.mActivity);
    }

    public void uk(String str) {
        this.fsj.setText(str);
    }

    public boolean bah() {
        return this.fsk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsu() {
        if (this.fsc != null) {
            if (this.gFB) {
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsK);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fsK, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsw() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsK);
    }

    public void bsx() {
        if (this.fsc != null && !this.gFB && !this.gGc) {
            mx(true);
            bak();
            this.fsc.setVisibility(0);
            this.gFu.setVisibility(0);
            this.gFt.setVisibility(8);
            this.gFB = true;
            if (this.gFF != null) {
                this.gFF.ha(false);
            }
        }
    }

    public void bai() {
        if (this.fsc != null && this.gFB) {
            mx(false);
            bak();
            this.fsc.setVisibility(8);
            this.gFu.setVisibility(8);
            this.gFt.setVisibility(0);
            this.dQB.setAnimationListener(this.fsI);
            this.fsc.startAnimation(this.dQB);
            this.gFB = false;
            if (this.gFF != null) {
                this.gFF.aEi();
            }
        }
    }

    public void bsy() {
        if (this.fsc != null && this.gFB) {
            this.dQC.cancel();
            this.dQB.cancel();
            mx(false);
            bak();
            this.fsc.setVisibility(8);
            this.gFu.setVisibility(8);
            this.gFt.setVisibility(0);
            this.gFB = false;
            if (this.gFF != null) {
                this.gFF.aEi();
            }
        }
    }

    private void bak() {
        if (this.fsc != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fsK);
            this.dQC.setAnimationListener(null);
            this.dQB.setAnimationListener(null);
            this.fsc.clearAnimation();
        }
    }

    private void bsz() {
        if (this.fsc != null) {
            this.dQC.setAnimationListener(null);
            this.dQB.setAnimationListener(null);
            this.fsc.clearAnimation();
        }
    }

    public void mx(boolean z) {
        bsA();
        if (z) {
            this.gFv.setVisibility(0);
        } else {
            this.gFv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsA() {
        if (this.currentState == 1) {
            this.gFv.setState(1);
        } else {
            this.gFv.setState(0);
        }
    }

    public void a(InterfaceC0297c interfaceC0297c) {
        this.gFE = interfaceC0297c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void S(boolean z, boolean z2) {
        if (this.bJM != null) {
            if (this.fsb != null) {
                this.fsb.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.frV != null && (this.frV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frV.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, e.C0210e.tbds52);
                this.frV.setLayoutParams(layoutParams);
            }
            this.bJM.mE(z);
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
        this.gGb = z;
    }

    public void a(m mVar) {
        this.gFL = mVar;
    }

    public void a(a aVar) {
        this.gFM = aVar;
    }

    public void a(l lVar) {
        this.gFN = lVar;
    }

    public void a(f fVar) {
        this.gFO = fVar;
    }

    public void mz(boolean z) {
        this.gFV = z;
    }

    public boolean bsB() {
        return this.gFC;
    }

    public void mA(boolean z) {
        this.gFC = z;
    }

    public void tD(int i2) {
        this.gFZ = i2;
    }

    public View bsC() {
        return this.frT;
    }

    public void a(n nVar) {
        this.gFH = nVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.bPb != null) {
            this.bPb.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.fsz = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mB(boolean z) {
        this.gGc = z;
        if (z) {
            bsy();
        } else {
            bal();
        }
    }

    public void a(o oVar) {
        this.goQ = oVar;
    }
}
