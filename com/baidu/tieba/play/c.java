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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
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
    private static int gID;
    private static CallStateReceiver gIE;
    private Animation aeX;
    private String bNk;
    private x cAk;
    private com.baidu.tieba.play.o cVs;
    private String ctx;
    protected QuickVideoView dbg;
    private com.baidu.tieba.play.g ehP;
    private com.baidu.tieba.j.k ehR;
    private View ekE;
    protected View ekJ;
    private String ele;
    private Animation fez;
    public View gHW;
    private VideoListMediaControllerView gHY;
    private View gHZ;
    private int gIC;
    private FrameLayout gIa;
    protected FrameLayout.LayoutParams gIb;
    private ImageView gIe;
    private View gIf;
    private View gIh;
    private TbImageView gIj;
    private g.f gIk;
    private ImageView gIm;
    private TextView gIn;
    private View gIr;
    private View gIs;
    private TextView gIt;
    private SeekBar gIu;
    private ImageView gIv;
    private ImageView gIw;
    private int gIx;
    private p hFb;
    private i hFn;
    private SwitchImageView hVA;
    private TextView hVB;
    private TextView hVC;
    private TextView hVD;
    private g.a hVE;
    private g.b hVF;
    private View.OnClickListener hVI;
    protected InterfaceC0294c hVJ;
    private d hVK;
    private o hVM;
    private h hVN;
    private j hVO;
    private k hVP;
    private m hVQ;
    private a hVR;
    private n hVS;
    private l hVT;
    private f hVU;
    private g hVV;
    private ProgressBar hVy;
    private View hVz;
    private TextView hWa;
    private boolean hWc;
    private boolean hWd;
    private boolean hWe;
    private int hWf;
    private boolean hWg;
    private boolean hWh;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int UG = 100;
    private boolean hVx = false;
    protected boolean US = false;
    private boolean UF = false;
    private boolean hVG = false;
    private boolean hVH = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIy = 0;
    private int gIz = 0;
    private long hVL = 60000;
    private int gIB = 0;
    private boolean gIF = false;
    private boolean hVW = true;
    private boolean hVX = true;
    private boolean hVY = false;
    private boolean hVZ = false;
    private String hEN = null;
    private int currentState = -1;
    private boolean hWb = false;
    private boolean hWi = false;
    private boolean hWj = false;
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.ehP = gVar;
            c.this.ehR.bEB();
            if (c.this.gHY != null && c.this.ehP != null && c.this.ehP.getDuration() > 0) {
                c.this.gHY.ax(0, c.this.ehP.getDuration());
            }
            c.this.aQn();
        }
    };
    private g.e cJL = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.qB();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a eib = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aQn();
        }
    };
    private Runnable UL = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            if (c.this.gIj.getVisibility() != 8) {
                if (c.this.dbg.getCurrentPosition() > c.this.UG) {
                    c.this.qB();
                } else {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UL, 20L);
                }
            }
        }
    };
    private g.a cJI = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dbg != null) {
                int duration = c.this.dbg.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.UF = false;
                    c.this.hWe = false;
                    c.this.mStartPosition = 0;
                    c.this.bAx();
                    c.this.gHZ.setVisibility(0);
                    c.this.hVy.setProgress(c.this.hVy.getMax());
                    c.this.UG = 100;
                    if (c.this.hVE != null) {
                        c.this.hVE.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dbg.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.oU(false);
                        c.this.oV(true);
                    } else {
                        c.this.bSS();
                        c.this.hVB.setVisibility(0);
                    }
                    if (!c.this.US && duration <= 150000) {
                        if (!c.this.hWb) {
                            if (c.this.hVO != null) {
                                c.this.hVO.oq(true);
                            }
                            c.this.cf(c.this.bNk, c.this.ctx);
                        } else {
                            c.this.currentState = 5;
                            c.this.dbg.setRecoveryState(5);
                            c.this.dbg.getPlayer().pause();
                            c.this.dbg.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.hVM != null) {
                        c.this.hVM.lV(c.this.hVy.getMax());
                        c.this.hVM.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gIH = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.ekJ.setVisibility(0);
            c.this.cAk.bTO();
            c.this.currentState = 4;
            c.this.dbg.setRecoveryState(4);
            if (c.this.hVF != null) {
                c.this.hVF.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kY()) {
                c.this.hWc = true;
            }
            if (c.this.hVM != null) {
                c.this.hVM.azH();
            }
            c.this.hWe = false;
            return true;
        }
    };
    protected Runnable gII = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg == null || !c.this.dbg.isPlaying()) {
                c.this.ekJ.setVisibility(0);
                c.this.cAk.bTO();
                if (c.this.hVM != null) {
                    c.this.hVM.azH();
                }
            }
        }
    };
    private g.InterfaceC0295g cJM = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0295g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.hVY) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWk, 200L);
            }
        }
    };
    private Runnable hWk = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg == null || !c.this.hVY) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UL, 200L);
                c.this.hVY = false;
            } else if (c.this.mStartPosition != c.this.dbg.getCurrentPosition()) {
                c.this.hVY = false;
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UL, 20L);
            } else {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWk, 200L);
            }
        }
    };
    private QuickVideoView.b cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UF = false;
            if (c.this.hVH) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWl, 300L);
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gII);
        }
    };
    private Runnable hWl = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.hWe = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hFb != null) {
                c.this.hFb.bPm();
            }
            if (view.getId() != c.this.ekJ.getId()) {
                if (view.getId() != c.this.hVA.getId()) {
                    if (view.getId() == c.this.hVC.getId()) {
                        if (c.this.hVN != null) {
                            c.this.hVN.bPn();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.hVB.getId()) {
                        if (c.this.hVO != null) {
                            c.this.hVO.oq(false);
                        }
                        c.this.cf(c.this.bNk, c.this.ctx);
                        return;
                    } else if (view.getId() == c.this.gIe.getId()) {
                        int i2 = c.this.hVH ? 1 : 2;
                        if (c.this.US) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctx).bJ(ImageViewerConfig.FORUM_ID, c.this.ele).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctx).bJ(ImageViewerConfig.FORUM_ID, c.this.ele).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.hVT != null) {
                            c.this.hVT.beQ();
                        }
                        if (c.this.bSD()) {
                            if (c.this.US) {
                                c.this.bSG();
                            } else {
                                c.this.bSF();
                            }
                            c.this.oR(c.this.US);
                            return;
                        }
                        c.this.bAB();
                        return;
                    } else if (view.getId() != c.this.gIm.getId()) {
                        if (c.this.hVI != null) {
                            c.this.hVI.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.hVT != null) {
                            c.this.hVT.beQ();
                        }
                        if (c.this.bSD()) {
                            c.this.bSG();
                            c.this.oR(false);
                            return;
                        }
                        c.this.bAB();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bPd();
                c.this.bSU();
                if (c.this.currentState != 1) {
                    c.this.bSQ();
                    c.this.bSR();
                } else {
                    c.this.bAP();
                }
                if (c.this.hVR != null) {
                    c.this.hVR.jV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dbg.stopPlayback();
            c.this.UF = false;
            c.this.bSL();
        }
    };
    private Animation.AnimationListener gIK = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gIL = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gIM = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bAM();
        }
    };
    private CustomMessageListener gIN = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b gKI = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void lz(int i2) {
            int duration;
            if (c.this.dbg != null && (duration = c.this.dbg.getDuration()) > 0 && c.this.hVy != null) {
                c.this.hVy.setProgress((int) ((i2 * c.this.gHW.getWidth()) / duration));
                if (c.this.hVM != null) {
                    c.this.hVM.lV((c.this.dbg.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cNV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bSQ();
            c.this.oV(false);
            if (c.this.hVR != null) {
                c.this.hVR.jV(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bAC() != null) {
                c.this.setStartPosition(c.this.bAC().getSeekPosition());
                if (!c.this.bAL()) {
                    c.this.bSL();
                } else {
                    c.this.bAK();
                    if (c.this.hFn != null) {
                        c.this.hFn.beS();
                    }
                }
            }
            c.this.oV(true);
            c.this.bSP();
            if (c.this.hVR != null) {
                c.this.hVR.jV(true);
            }
            if (c.this.hVS != null) {
                c.this.hVS.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a hWm = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bSX() {
            if (!c.this.hWb) {
                c.this.cAk.startLoading();
                c.this.gIj.setVisibility(0);
                c.this.hVA.setVisibility(8);
                c.this.hVC.setVisibility(8);
                c.this.hVB.setVisibility(8);
                c.this.hVD.setVisibility(8);
                c.this.ekJ.setVisibility(8);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gII);
                if (c.this.hVL > 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.gII, c.this.hVL);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void jV(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0294c {
        void qj();

        void qk();
    }

    /* loaded from: classes.dex */
    public interface d {
        void beR();

        void jy(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void pa(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void jx(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void bPn();
    }

    /* loaded from: classes.dex */
    public interface i {
        void beS();
    }

    /* loaded from: classes.dex */
    public interface j {
        void oq(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void beP();

        void beQ();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bPo();

        boolean bPp();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void azH();

        void azI();

        void lV(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bPm();
    }

    public c(Activity activity, View view, boolean z) {
        this.hWg = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.hWg = z;
            this.gIh = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.hWg = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.hWg = z;
            this.gIh = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gHW = am(this.mActivity);
        this.gHW.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gHW);
        }
        this.dbg = (QuickVideoView) this.gHW.findViewById(d.g.videoView);
        this.cAk = new x((ViewGroup) this.gHW.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.eib);
        this.gHY = (VideoListMediaControllerView) this.gHW.findViewById(d.g.media_controller);
        this.gHY.setPlayer(this.dbg);
        this.hVy = (ProgressBar) this.gHW.findViewById(d.g.pgrBottomProgress);
        this.hVy.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.hVy.setProgress(0);
        this.gHY.setOnSeekBarChangeListener(this.cNV);
        this.gHY.setOnProgressUpdatedListener(this.gKI);
        this.gHZ = this.gHW.findViewById(d.g.black_mask);
        this.ekJ = this.gHW.findViewById(d.g.layout_error);
        this.ekJ.setOnClickListener(this.mOnClickListener);
        this.hWa = (TextView) this.gHW.findViewById(d.g.auto_video_error_tips);
        this.gIa = (FrameLayout) this.gHW.findViewById(d.g.danmu_container);
        this.gIe = (ImageView) this.gHW.findViewById(d.g.img_full_screen);
        this.gIe.setOnClickListener(this.mOnClickListener);
        this.gIf = this.gHW.findViewById(d.g.layout_media_controller);
        this.hVz = this.gHW.findViewById(d.g.time_show_controller);
        this.dbg.setPlayerReuseEnable(true);
        this.dbg.setContinuePlayEnable(true);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gIH);
        this.dbg.setOnSeekCompleteListener(this.cJM);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnRecoveryCallback(this.hWm);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.hVA = (SwitchImageView) this.gHW.findViewById(d.g.img_play_controller);
        this.hVA.setStateImage(d.f.btn_card_play_video_n, d.f.btn_card_stop_video_n);
        this.hVA.setState(0);
        this.hVA.setOnClickListener(this.mOnClickListener);
        this.hVB = (TextView) this.gHW.findViewById(d.g.txt_replay);
        this.hVB.setOnClickListener(this.mOnClickListener);
        this.hVC = (TextView) this.gHW.findViewById(d.g.txt_playnext);
        this.hVC.setOnClickListener(this.mOnClickListener);
        this.hVD = (TextView) this.gHW.findViewById(d.g.txt_next_video_title);
        this.gIj = (TbImageView) this.gHW.findViewById(d.g.video_thumbnail);
        this.gIj.setDefaultErrorResource(0);
        this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gIm = (ImageView) this.gHW.findViewById(d.g.img_exit);
        this.gIm.setOnClickListener(this.mOnClickListener);
        this.gIn = (TextView) this.gHW.findViewById(d.g.video_title);
        this.ekE = this.gHW.findViewById(d.g.layout_title);
        this.ekE.setVisibility(8);
        this.fez = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aeX = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gIx = this.mAudioManager.getStreamMaxVolume(3);
        this.gIC = this.mAudioManager.getStreamVolume(3);
        gID = 100 / this.gIx;
        this.gHW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.hVP != null) {
                    c.this.hVP.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.UF) {
                        if (c.this.mStatus == 1 && c.this.gIz != 0) {
                            c.this.b(c.this.gIz == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIz = 0;
                            c.this.gIy = 0;
                        }
                        if (!c.this.dbg.isPlaying()) {
                            c.this.hVC.setVisibility(8);
                            c.this.hVB.setVisibility(8);
                            c.this.hVD.setVisibility(8);
                        }
                    }
                    c.this.bAx();
                    if (c.this.hVP != null) {
                        c.this.hVP.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.cVs = new com.baidu.tieba.play.o(this.mActivity);
        if (this.hWg) {
            this.cVs.start();
        }
        this.gIB = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.ds16);
        if (gIE == null) {
            gIE = new CallStateReceiver();
        }
        gIE.register(this.mActivity);
        bSA();
        this.ehR = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gIN);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gIN);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bSA() {
        if (this.hVW) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gHW.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gHW.setSystemUiVisibility(0);
    }

    public void oP(boolean z) {
        this.hVW = z;
        bSA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAx() {
        this.mStatus = 0;
        if (this.gIr != null && this.gIr.getParent() != null && (this.gIr.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIr.getParent()).removeView(this.gIr);
                this.gIr = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gIs != null && this.gIs.getParent() != null && (this.gIs.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIs.getParent()).removeView(this.gIs);
                this.gIs = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bAy() {
        if (this.mStatus == 1) {
            if (this.gIr == null && this.gHW != null && (this.gHW instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_jindu, (ViewGroup) this.gHW, true);
                this.gIr = this.gHW.findViewById(d.g.lay_jindu);
                this.gIt = (TextView) this.gIr.findViewById(d.g.show_time);
                this.gIw = (ImageView) this.gIr.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gIs == null && this.gHW != null && (this.gHW instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_voice, (ViewGroup) this.gHW, true);
            this.gIs = this.gHW.findViewById(d.g.lay_voice);
            this.gIv = (ImageView) this.gIs.findViewById(d.g.arrow_voice_icon);
            this.gIu = (SeekBar) this.gIs.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.hVI = onClickListener;
    }

    public void oQ(boolean z) {
        this.hVH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.hVP != null) {
                c.this.hVP.onStart();
            }
            if (c.this.US && c.this.UF) {
                if (c.this.mStatus == 1) {
                    c.this.bSS();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aH(f2);
                    }
                } else {
                    if (c.this.US) {
                        c.this.bAA();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIy = c.this.dbg.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aH(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.hWh) {
                if (c.this.hVQ != null && c.this.hVQ.bPo()) {
                    return true;
                }
                c.this.bPd();
                c.this.bSU();
                if (c.this.dbg.isPlaying()) {
                    c.this.bSP();
                } else {
                    c.this.bSQ();
                }
                if (c.this.hVR != null) {
                    c.this.hVR.jV(c.this.dbg.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.hWh) {
                if (c.this.UF) {
                    if (c.this.hVQ != null && c.this.hVQ.bPp()) {
                        return true;
                    }
                    c.this.bSO();
                    if (c.this.dbg.isPlaying()) {
                        c.this.bSP();
                    } else {
                        c.this.bSQ();
                    }
                    if (c.this.hVR != null) {
                        c.this.hVR.jV(c.this.dbg.isPlaying());
                    }
                } else {
                    c.this.bPd();
                    c.this.bSU();
                    if (c.this.currentState != 1) {
                        c.this.bSQ();
                        c.this.bSR();
                    } else {
                        c.this.bAP();
                    }
                    if (c.this.hVR != null) {
                        c.this.hVR.jV(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAA() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gHW.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gHW.setSystemUiVisibility(4);
        } else {
            this.gHW.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f2) {
        if (!this.UF) {
            this.mStatus = 0;
            return;
        }
        bAy();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gID == 0) {
            if (f2 > 0.0f && this.gIC < this.gIx) {
                this.gIC++;
            }
            if (f2 < 0.0f && this.gIC > 0) {
                this.gIC--;
            }
        }
        if (this.mProgress > 0) {
            this.gIv.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.gIv.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gIC, 0);
        this.gIu.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gIy += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gIz = 1;
            } else {
                this.gIy += 1000;
                this.gIz = 2;
            }
            if (this.gIy < 0) {
                this.gIy = 0;
            } else if (this.gIy > this.dbg.getDuration()) {
                this.gIy = this.dbg.getDuration();
            }
        }
        bAy();
        String xr = this.gHY.xr(this.gIy);
        if (f2 > 0.0f) {
            this.gIw.setImageResource(d.f.icon_kuaitui);
        } else {
            this.gIw.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(xr)) {
            this.gIt.setText(new StringBuilder().append(xr).append("/").append(this.gHY.xr(this.dbg.getDuration())));
        }
        this.gHY.setCurrentDuration(this.gIy, z ? false : true);
        bSS();
        bSH();
    }

    protected View am(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bNk = str;
        this.ctx = str2;
    }

    public void bSB() {
        if (this.dbg != null) {
            this.dbg.bSB();
        }
    }

    public void setFid(String str) {
        this.ele = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQn() {
        int i2 = 100;
        if (this.dbg != null && this.ehP != null && this.gHY != null) {
            this.gHY.showProgress();
            this.mStartPosition = y.bTS().AU(this.bNk);
            if (this.hWe) {
                this.ehP.setVolume(1.0f, 1.0f);
                this.dbg.start();
                this.hWe = false;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.UL, 20L);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
                if (this.dbg.bTo()) {
                    this.currentState = 1;
                    this.dbg.setRecoveryState(1);
                    bSS();
                }
                this.mStartPosition = y.bTS().AU(this.bNk);
                this.gHY.setPlayer(this.dbg);
                if (this.mStartPosition != 0 && !this.ehP.isPlayerReuse()) {
                    this.hVY = true;
                }
                if (!this.hWd) {
                    this.gHY.showProgress();
                }
                if (!this.hVH && this.ehP.getDuration() <= 0) {
                    bAC().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.ehP.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.UG = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (this.gIj.getVisibility() != 8) {
            this.UF = true;
            this.gHZ.setVisibility(8);
            this.ekJ.setVisibility(8);
            this.cAk.bTN();
            this.gIj.setVisibility(8);
            bST();
            if (bSV()) {
                this.ehR.a(this.ctx, -1L, this.dbg.getDuration() / 1000, "middle", this.dbg);
            }
            this.gHY.showProgress();
            this.hVy.setVisibility(0);
            if (this.gIk != null) {
                this.gIk.onPrepared(this.dbg.getPlayer());
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
            Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oR(boolean z) {
        if (hasNavBar(this.mActivity) && (this.hVz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hVz.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.hVz.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.hVz.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.hVz.setLayoutParams(layoutParams);
        }
    }

    public void bPd() {
        if (this.dbg.isPlaying()) {
            pausePlay();
            if (this.hVV != null) {
                this.hVV.onPause();
            }
            if (this.hVM != null) {
                this.hVM.onPaused();
            }
        } else if (this.UF) {
            bAK();
            if (this.hFn != null) {
                this.hFn.beS();
            }
            if (this.hVM != null) {
                this.hVM.azI();
            }
        } else {
            bSL();
        }
    }

    public boolean bSC() {
        return this.gIF;
    }

    public void bAB() {
        this.gIF = true;
        if (this.cVs != null) {
            this.cVs.bAB();
        }
    }

    public boolean bSD() {
        return this.ehP != null && this.ehP.getVideoHeight() > this.ehP.getVideoWidth();
    }

    public void bSE() {
        oR(false);
        bSG();
    }

    public boolean xl(int i2) {
        switch (i2) {
            case 4:
                if (this.US) {
                    if (bSD()) {
                        oR(false);
                        bSG();
                    } else {
                        bAB();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.gIx <= 0 || this.gIu == null) {
                    return false;
                }
                this.gIC = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gIC * 100.0d) / this.gIx);
                this.gIu.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public VideoListMediaControllerView bAC() {
        return this.gHY;
    }

    public void show() {
        this.gHW.setVisibility(0);
    }

    public void bAG() {
        if (this.gIh != null) {
            ViewGroup.LayoutParams layoutParams = this.gIh.getLayoutParams();
            this.gIb = (FrameLayout.LayoutParams) this.gHW.getLayoutParams();
            this.gIb.width = layoutParams.width;
            this.gIb.height = layoutParams.height;
            this.gIb.topMargin = 0;
            this.gHW.setLayoutParams(this.gIb);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gIF) {
            if (this.US) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gIF = false;
        }
        if (configuration.orientation == 2) {
            bSF();
        } else {
            bSG();
        }
        bSH();
        bAK();
        bSU();
        bAP();
        if (this.hVR != null) {
            this.hVR.jV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSF() {
        this.US = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bSD()) {
            this.gHW.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gHW.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.ekE.setVisibility(0);
        this.gIm.setVisibility(0);
        this.gIn.setVisibility(0);
        this.gIa.setVisibility(8);
        this.cAk.bTO();
        this.gIj.setVisibility(8);
        this.gIe.setImageResource(d.f.icon_video_narrow_white);
        uV(this.gIB);
        bAA();
        if (this.hVJ != null) {
            this.hVJ.qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSG() {
        this.US = false;
        if (this.gIb != null) {
            this.gHW.setLayoutParams(this.gIb);
        }
        g(this.mActivity, false);
        this.ekE.setVisibility(8);
        this.gIa.setVisibility(0);
        this.cAk.bTO();
        this.gIj.setVisibility(8);
        this.gIe.setImageResource(d.f.icon_video_enlarge_white);
        if (this.gHY != null && (this.gHY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.gHY.setLayoutParams(layoutParams);
        }
        this.gHW.setSystemUiVisibility(0);
        bSA();
        if (this.hVJ != null) {
            this.hVJ.qk();
        }
    }

    public void bSH() {
        if (this.dbg != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.US) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.hVy.setMax(aO);
            int duration = this.dbg.getDuration();
            if (duration > 0) {
                if (this.hVB.getVisibility() == 0) {
                    this.hVy.setProgress(this.hVy.getMax());
                } else {
                    this.hVy.setProgress((int) ((this.dbg.getCurrentPosition() * this.hVy.getMax()) / duration));
                }
            }
        }
    }

    private void uV(int i2) {
        if (this.gHY != null && (this.gHY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gHY.setLayoutParams(layoutParams);
        }
    }

    private void g(Activity activity, boolean z) {
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

    public boolean bAI() {
        return !this.US;
    }

    public void a(g.f fVar) {
        this.gIk = fVar;
    }

    public void a(g.a aVar) {
        this.hVE = aVar;
    }

    public void a(g.b bVar) {
        this.hVF = bVar;
    }

    public void h(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dbg != null) {
            this.dbg.setPbLoadingTime(currentTimeMillis);
        }
        cf(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.hVZ) {
            dD(str, str2);
        } else {
            cf(str, str2);
        }
        if (eVar != null) {
            eVar.pa(z);
        }
    }

    public void dC(String str, String str2) {
    }

    public void cf(String str, String str2) {
        bSM();
        this.hWe = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbg.setVideoPath(str, str2);
        this.ehR.bEA();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        if (this.hVL > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gII, this.hVL);
        }
        if (this.hVM != null) {
            this.hVM.onStarted();
        }
        this.cAk.startLoading();
        oS(true);
    }

    public void dD(String str, String str2) {
        bSM();
        this.hWe = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        if (this.hVL > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gII, this.hVL);
        }
        if (this.hVM != null) {
            this.hVM.onStarted();
        }
        this.cAk.startLoading();
        oS(true);
    }

    public void bSI() {
        bAK();
        this.hVy.setVisibility(0);
    }

    public void bAK() {
        int i2 = 100;
        if (this.dbg != null && this.gHY != null) {
            this.UF = true;
            this.currentState = 1;
            this.dbg.setRecoveryState(1);
            this.dbg.start();
            if (this.ehP != null && this.gHY != null) {
                this.mStartPosition = y.bTS().AU(this.bNk);
                if (this.mStartPosition != 0 && !this.ehP.isPlayerReuse()) {
                    this.hVY = true;
                }
                if (this.mStartPosition > 100 && this.ehP.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.UG = i2;
            } else {
                this.UG = 100;
            }
            this.cAk.bTO();
            oS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kY() && this.hWc && !StringUtils.isNull(this.bNk) && !StringUtils.isNull(this.ctx)) {
            this.hWc = false;
            this.hWd = true;
            cf(this.bNk, this.ctx);
        }
    }

    private void oS(boolean z) {
        if (z) {
            this.gIj.setVisibility(0);
            bSS();
            this.hVy.setProgress(0);
        } else {
            this.gIj.setVisibility(8);
        }
        this.gHY.showProgress();
        this.gHZ.setVisibility(8);
        this.hVC.setVisibility(8);
        this.hVB.setVisibility(8);
        this.hVD.setVisibility(8);
        this.ekJ.setVisibility(8);
    }

    private void bSJ() {
        this.cAk.bTO();
        this.hVC.setVisibility(8);
        this.hVB.setVisibility(8);
        this.hVD.setVisibility(8);
        bSU();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbg != null) {
            this.dbg.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dbg.pause();
        this.currentState = 2;
        this.dbg.setRecoveryState(2);
        bSJ();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dbg.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
        this.dbg.stopPlayback();
        this.UF = false;
        this.hWe = false;
        this.mStartPosition = 0;
        bnQ();
    }

    public void bSK() {
        if (this.dbg.getDuration() >= this.dbg.getCurrentPosition()) {
            y.bTS().bj(this.bNk, this.dbg.getCurrentPosition());
        }
    }

    public void oT(boolean z) {
        this.hVX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        if (this.gIf != null) {
            this.gHZ.setVisibility(0);
            this.hVC.setVisibility(8);
            this.hVB.setVisibility(8);
            this.hVD.setVisibility(8);
            this.cAk.bTO();
            bSS();
            this.hVy.setVisibility(8);
            this.ekJ.setVisibility(8);
            this.gHY.awJ();
            this.gIj.setVisibility(z ? 0 : 8);
        }
    }

    public void bnQ() {
        oU(true);
    }

    public boolean ql() {
        if (this.dbg == null) {
            return false;
        }
        return this.dbg.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dbg == null) {
            return 0;
        }
        return this.dbg.getCurrentPosition();
    }

    public void a(k kVar) {
        this.hVP = kVar;
    }

    public void a(j jVar) {
        this.hVO = jVar;
    }

    public void a(i iVar) {
        this.hFn = iVar;
    }

    public void a(g gVar) {
        this.hVV = gVar;
    }

    public void a(h hVar) {
        this.hVN = hVar;
    }

    public void As(String str) {
        this.hEN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSL() {
        a(this.bNk, this.ctx, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.hVK = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bSM();
        if (com.baidu.adp.lib.util.j.la() && !com.baidu.tieba.video.g.ciC().ciD()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.hVZ = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.hVU != null) {
                    this.hVU.jx(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.ly(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bSN();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).aaZ();
                return;
            } else if (this.hVU != null) {
                this.hVU.jx(true);
                return;
            } else {
                if (!this.hVx) {
                    this.hVx = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, d.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.hVT != null) {
            this.hVT.beP();
        }
    }

    private void bSM() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciC().ey(this.mActivity);
        }
    }

    public void bSN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gIj.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWk);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
        this.cVs.stop();
        gIE.unregister(this.mActivity);
    }

    public void AP(String str) {
        this.gIn.setText(str);
    }

    public boolean bAL() {
        return this.UF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSO() {
        if (this.gIf != null) {
            if (this.hVG) {
                bSS();
            } else {
                bSR();
            }
        }
    }

    public void bAP() {
        bSR();
        bSP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSP() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gIM, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSQ() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
    }

    public void bSR() {
        if (this.gIf != null && !this.hVG && !this.hWi) {
            oV(true);
            bAO();
            this.gIf.setVisibility(0);
            this.hVz.setVisibility(0);
            this.hVy.setVisibility(8);
            this.hVG = true;
            if (this.hVK != null) {
                this.hVK.jy(false);
            }
        }
    }

    public void bAM() {
        if (this.gIf != null && this.hVG) {
            oV(false);
            bAO();
            this.gIf.setVisibility(8);
            this.hVz.setVisibility(8);
            this.hVy.setVisibility(0);
            this.fez.setAnimationListener(this.gIK);
            this.gIf.startAnimation(this.fez);
            this.hVG = false;
            if (this.hVK != null) {
                this.hVK.beR();
            }
        }
    }

    public void bSS() {
        if (this.gIf != null && this.hVG) {
            this.aeX.cancel();
            this.fez.cancel();
            oV(false);
            bAO();
            this.gIf.setVisibility(8);
            this.hVz.setVisibility(8);
            this.hVy.setVisibility(0);
            this.hVG = false;
            if (this.hVK != null) {
                this.hVK.beR();
            }
        }
    }

    private void bAO() {
        if (this.gIf != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
            this.aeX.setAnimationListener(null);
            this.fez.setAnimationListener(null);
            this.gIf.clearAnimation();
        }
    }

    private void bST() {
        if (this.gIf != null) {
            this.aeX.setAnimationListener(null);
            this.fez.setAnimationListener(null);
            this.gIf.clearAnimation();
        }
    }

    public void oV(boolean z) {
        bSU();
        if (z) {
            this.hVA.setVisibility(0);
        } else {
            this.hVA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSU() {
        if (this.currentState == 1) {
            this.hVA.setState(1);
        } else {
            this.hVA.setState(0);
        }
    }

    public void a(InterfaceC0294c interfaceC0294c) {
        this.hVJ = interfaceC0294c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ae(boolean z, boolean z2) {
        if (this.cVs != null) {
            if (this.gIe != null) {
                this.gIe.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gHY != null && (this.gHY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds52);
                this.gHY.setLayoutParams(layoutParams);
            }
            this.cVs.pc(z);
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

    public void oW(boolean z) {
        this.hWh = z;
    }

    public void a(m mVar) {
        this.hVQ = mVar;
    }

    public void a(a aVar) {
        this.hVR = aVar;
    }

    public void a(n nVar) {
        this.hVS = nVar;
    }

    public void a(l lVar) {
        this.hVT = lVar;
    }

    public void a(f fVar) {
        this.hVU = fVar;
    }

    public void oX(boolean z) {
        this.hWb = z;
    }

    public boolean bSV() {
        return this.hVH;
    }

    public void oY(boolean z) {
        this.hVH = z;
    }

    public void xm(int i2) {
        this.hWf = i2;
    }

    public View bSW() {
        return this.gHW;
    }

    public void a(o oVar) {
        this.hVM = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dbg != null) {
            this.dbg.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.gIC = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oZ(boolean z) {
        this.hWi = z;
        if (z) {
            bSS();
        } else {
            bAP();
        }
    }

    public void a(p pVar) {
        this.hFb = pVar;
    }
}
