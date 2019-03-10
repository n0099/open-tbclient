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
    private static int gIE;
    private static CallStateReceiver gIF;
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
    public View gHX;
    private VideoListMediaControllerView gHZ;
    private int gID;
    private View gIa;
    private FrameLayout gIb;
    protected FrameLayout.LayoutParams gIc;
    private ImageView gIf;
    private View gIg;
    private View gIi;
    private TbImageView gIk;
    private g.f gIl;
    private ImageView gIn;
    private TextView gIo;
    private View gIs;
    private View gIt;
    private TextView gIu;
    private SeekBar gIv;
    private ImageView gIw;
    private ImageView gIx;
    private int gIy;
    private p hFc;
    private i hFo;
    private View hVA;
    private SwitchImageView hVB;
    private TextView hVC;
    private TextView hVD;
    private TextView hVE;
    private g.a hVF;
    private g.b hVG;
    private View.OnClickListener hVJ;
    protected InterfaceC0294c hVK;
    private d hVL;
    private o hVN;
    private h hVO;
    private j hVP;
    private k hVQ;
    private m hVR;
    private a hVS;
    private n hVT;
    private l hVU;
    private f hVV;
    private g hVW;
    private ProgressBar hVz;
    private TextView hWb;
    private boolean hWd;
    private boolean hWe;
    private boolean hWf;
    private int hWg;
    private boolean hWh;
    private boolean hWi;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int UG = 100;
    private boolean hVy = false;
    protected boolean US = false;
    private boolean UF = false;
    private boolean hVH = false;
    private boolean hVI = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIz = 0;
    private int gIA = 0;
    private long hVM = 60000;
    private int gIC = 0;
    private boolean gIG = false;
    private boolean hVX = true;
    private boolean hVY = true;
    private boolean hVZ = false;
    private boolean hWa = false;
    private String hEO = null;
    private int currentState = -1;
    private boolean hWc = false;
    private boolean hWj = false;
    private boolean hWk = false;
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.ehP = gVar;
            c.this.ehR.bEC();
            if (c.this.gHZ != null && c.this.ehP != null && c.this.ehP.getDuration() > 0) {
                c.this.gHZ.ax(0, c.this.ehP.getDuration());
            }
            c.this.aQo();
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
            c.this.aQo();
        }
    };
    private Runnable UL = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            if (c.this.gIk.getVisibility() != 8) {
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
                    c.this.hWf = false;
                    c.this.mStartPosition = 0;
                    c.this.bAy();
                    c.this.gIa.setVisibility(0);
                    c.this.hVz.setProgress(c.this.hVz.getMax());
                    c.this.UG = 100;
                    if (c.this.hVF != null) {
                        c.this.hVF.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dbg.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.oU(false);
                        c.this.oV(true);
                    } else {
                        c.this.bST();
                        c.this.hVC.setVisibility(0);
                    }
                    if (!c.this.US && duration <= 150000) {
                        if (!c.this.hWc) {
                            if (c.this.hVP != null) {
                                c.this.hVP.oq(true);
                            }
                            c.this.cf(c.this.bNk, c.this.ctx);
                        } else {
                            c.this.currentState = 5;
                            c.this.dbg.setRecoveryState(5);
                            c.this.dbg.getPlayer().pause();
                            c.this.dbg.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.hVN != null) {
                        c.this.hVN.lV(c.this.hVz.getMax());
                        c.this.hVN.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gII = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.ekJ.setVisibility(0);
            c.this.cAk.bTP();
            c.this.currentState = 4;
            c.this.dbg.setRecoveryState(4);
            if (c.this.hVG != null) {
                c.this.hVG.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kY()) {
                c.this.hWd = true;
            }
            if (c.this.hVN != null) {
                c.this.hVN.azI();
            }
            c.this.hWf = false;
            return true;
        }
    };
    protected Runnable gIJ = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg == null || !c.this.dbg.isPlaying()) {
                c.this.ekJ.setVisibility(0);
                c.this.cAk.bTP();
                if (c.this.hVN != null) {
                    c.this.hVN.azI();
                }
            }
        }
    };
    private g.InterfaceC0295g cJM = new g.InterfaceC0295g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0295g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.hVZ) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWl, 200L);
            }
        }
    };
    private Runnable hWl = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg == null || !c.this.hVZ) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UL, 200L);
                c.this.hVZ = false;
            } else if (c.this.mStartPosition != c.this.dbg.getCurrentPosition()) {
                c.this.hVZ = false;
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UL, 20L);
            } else {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWl, 200L);
            }
        }
    };
    private QuickVideoView.b cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UF = false;
            if (c.this.hVI) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWm, 300L);
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIJ);
        }
    };
    private Runnable hWm = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.hWf = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hFc != null) {
                c.this.hFc.bPn();
            }
            if (view.getId() != c.this.ekJ.getId()) {
                if (view.getId() != c.this.hVB.getId()) {
                    if (view.getId() == c.this.hVD.getId()) {
                        if (c.this.hVO != null) {
                            c.this.hVO.bPo();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.hVC.getId()) {
                        if (c.this.hVP != null) {
                            c.this.hVP.oq(false);
                        }
                        c.this.cf(c.this.bNk, c.this.ctx);
                        return;
                    } else if (view.getId() == c.this.gIf.getId()) {
                        int i2 = c.this.hVI ? 1 : 2;
                        if (c.this.US) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctx).bJ(ImageViewerConfig.FORUM_ID, c.this.ele).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctx).bJ(ImageViewerConfig.FORUM_ID, c.this.ele).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.hVU != null) {
                            c.this.hVU.beR();
                        }
                        if (c.this.bSE()) {
                            if (c.this.US) {
                                c.this.bSH();
                            } else {
                                c.this.bSG();
                            }
                            c.this.oR(c.this.US);
                            return;
                        }
                        c.this.bAC();
                        return;
                    } else if (view.getId() != c.this.gIn.getId()) {
                        if (c.this.hVJ != null) {
                            c.this.hVJ.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.hVU != null) {
                            c.this.hVU.beR();
                        }
                        if (c.this.bSE()) {
                            c.this.bSH();
                            c.this.oR(false);
                            return;
                        }
                        c.this.bAC();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bPe();
                c.this.bSV();
                if (c.this.currentState != 1) {
                    c.this.bSR();
                    c.this.bSS();
                } else {
                    c.this.bAQ();
                }
                if (c.this.hVS != null) {
                    c.this.hVS.jV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dbg.stopPlayback();
            c.this.UF = false;
            c.this.bSM();
        }
    };
    private Animation.AnimationListener gIL = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gIM = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gIN = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bAN();
        }
    };
    private CustomMessageListener gIO = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b gKJ = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void lz(int i2) {
            int duration;
            if (c.this.dbg != null && (duration = c.this.dbg.getDuration()) > 0 && c.this.hVz != null) {
                c.this.hVz.setProgress((int) ((i2 * c.this.gHX.getWidth()) / duration));
                if (c.this.hVN != null) {
                    c.this.hVN.lV((c.this.dbg.getCurrentPosition() * 100) / duration);
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
            c.this.bSR();
            c.this.oV(false);
            if (c.this.hVS != null) {
                c.this.hVS.jV(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bAD() != null) {
                c.this.setStartPosition(c.this.bAD().getSeekPosition());
                if (!c.this.bAM()) {
                    c.this.bSM();
                } else {
                    c.this.bAL();
                    if (c.this.hFo != null) {
                        c.this.hFo.beT();
                    }
                }
            }
            c.this.oV(true);
            c.this.bSQ();
            if (c.this.hVS != null) {
                c.this.hVS.jV(true);
            }
            if (c.this.hVT != null) {
                c.this.hVT.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a hWn = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bSY() {
            if (!c.this.hWc) {
                c.this.cAk.startLoading();
                c.this.gIk.setVisibility(0);
                c.this.hVB.setVisibility(8);
                c.this.hVD.setVisibility(8);
                c.this.hVC.setVisibility(8);
                c.this.hVE.setVisibility(8);
                c.this.ekJ.setVisibility(8);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIJ);
                if (c.this.hVM > 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.gIJ, c.this.hVM);
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
        void beS();

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
        void bPo();
    }

    /* loaded from: classes.dex */
    public interface i {
        void beT();
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
        void beQ();

        void beR();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bPp();

        boolean bPq();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void azI();

        void azJ();

        void lV(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bPn();
    }

    public c(Activity activity, View view, boolean z) {
        this.hWh = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.hWh = z;
            this.gIi = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.hWh = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.hWh = z;
            this.gIi = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gHX = am(this.mActivity);
        this.gHX.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gHX);
        }
        this.dbg = (QuickVideoView) this.gHX.findViewById(d.g.videoView);
        this.cAk = new x((ViewGroup) this.gHX.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.eib);
        this.gHZ = (VideoListMediaControllerView) this.gHX.findViewById(d.g.media_controller);
        this.gHZ.setPlayer(this.dbg);
        this.hVz = (ProgressBar) this.gHX.findViewById(d.g.pgrBottomProgress);
        this.hVz.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.hVz.setProgress(0);
        this.gHZ.setOnSeekBarChangeListener(this.cNV);
        this.gHZ.setOnProgressUpdatedListener(this.gKJ);
        this.gIa = this.gHX.findViewById(d.g.black_mask);
        this.ekJ = this.gHX.findViewById(d.g.layout_error);
        this.ekJ.setOnClickListener(this.mOnClickListener);
        this.hWb = (TextView) this.gHX.findViewById(d.g.auto_video_error_tips);
        this.gIb = (FrameLayout) this.gHX.findViewById(d.g.danmu_container);
        this.gIf = (ImageView) this.gHX.findViewById(d.g.img_full_screen);
        this.gIf.setOnClickListener(this.mOnClickListener);
        this.gIg = this.gHX.findViewById(d.g.layout_media_controller);
        this.hVA = this.gHX.findViewById(d.g.time_show_controller);
        this.dbg.setPlayerReuseEnable(true);
        this.dbg.setContinuePlayEnable(true);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gII);
        this.dbg.setOnSeekCompleteListener(this.cJM);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnRecoveryCallback(this.hWn);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.hVB = (SwitchImageView) this.gHX.findViewById(d.g.img_play_controller);
        this.hVB.setStateImage(d.f.btn_card_play_video_n, d.f.btn_card_stop_video_n);
        this.hVB.setState(0);
        this.hVB.setOnClickListener(this.mOnClickListener);
        this.hVC = (TextView) this.gHX.findViewById(d.g.txt_replay);
        this.hVC.setOnClickListener(this.mOnClickListener);
        this.hVD = (TextView) this.gHX.findViewById(d.g.txt_playnext);
        this.hVD.setOnClickListener(this.mOnClickListener);
        this.hVE = (TextView) this.gHX.findViewById(d.g.txt_next_video_title);
        this.gIk = (TbImageView) this.gHX.findViewById(d.g.video_thumbnail);
        this.gIk.setDefaultErrorResource(0);
        this.gIk.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gIn = (ImageView) this.gHX.findViewById(d.g.img_exit);
        this.gIn.setOnClickListener(this.mOnClickListener);
        this.gIo = (TextView) this.gHX.findViewById(d.g.video_title);
        this.ekE = this.gHX.findViewById(d.g.layout_title);
        this.ekE.setVisibility(8);
        this.fez = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aeX = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gIy = this.mAudioManager.getStreamMaxVolume(3);
        this.gID = this.mAudioManager.getStreamVolume(3);
        gIE = 100 / this.gIy;
        this.gHX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.hVQ != null) {
                    c.this.hVQ.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.UF) {
                        if (c.this.mStatus == 1 && c.this.gIA != 0) {
                            c.this.b(c.this.gIA == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIA = 0;
                            c.this.gIz = 0;
                        }
                        if (!c.this.dbg.isPlaying()) {
                            c.this.hVD.setVisibility(8);
                            c.this.hVC.setVisibility(8);
                            c.this.hVE.setVisibility(8);
                        }
                    }
                    c.this.bAy();
                    if (c.this.hVQ != null) {
                        c.this.hVQ.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.cVs = new com.baidu.tieba.play.o(this.mActivity);
        if (this.hWh) {
            this.cVs.start();
        }
        this.gIC = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.ds16);
        if (gIF == null) {
            gIF = new CallStateReceiver();
        }
        gIF.register(this.mActivity);
        bSB();
        this.ehR = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gIO);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gIO);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bSB() {
        if (this.hVX) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gHX.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gHX.setSystemUiVisibility(0);
    }

    public void oP(boolean z) {
        this.hVX = z;
        bSB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAy() {
        this.mStatus = 0;
        if (this.gIs != null && this.gIs.getParent() != null && (this.gIs.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIs.getParent()).removeView(this.gIs);
                this.gIs = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gIt != null && this.gIt.getParent() != null && (this.gIt.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIt.getParent()).removeView(this.gIt);
                this.gIt = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bAz() {
        if (this.mStatus == 1) {
            if (this.gIs == null && this.gHX != null && (this.gHX instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_jindu, (ViewGroup) this.gHX, true);
                this.gIs = this.gHX.findViewById(d.g.lay_jindu);
                this.gIu = (TextView) this.gIs.findViewById(d.g.show_time);
                this.gIx = (ImageView) this.gIs.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gIt == null && this.gHX != null && (this.gHX instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_voice, (ViewGroup) this.gHX, true);
            this.gIt = this.gHX.findViewById(d.g.lay_voice);
            this.gIw = (ImageView) this.gIt.findViewById(d.g.arrow_voice_icon);
            this.gIv = (SeekBar) this.gIt.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.hVJ = onClickListener;
    }

    public void oQ(boolean z) {
        this.hVI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.hVQ != null) {
                c.this.hVQ.onStart();
            }
            if (c.this.US && c.this.UF) {
                if (c.this.mStatus == 1) {
                    c.this.bST();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aH(f2);
                    }
                } else {
                    if (c.this.US) {
                        c.this.bAB();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIz = c.this.dbg.getCurrentPosition();
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
            if (!c.this.hWi) {
                if (c.this.hVR != null && c.this.hVR.bPp()) {
                    return true;
                }
                c.this.bPe();
                c.this.bSV();
                if (c.this.dbg.isPlaying()) {
                    c.this.bSQ();
                } else {
                    c.this.bSR();
                }
                if (c.this.hVS != null) {
                    c.this.hVS.jV(c.this.dbg.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.hWi) {
                if (c.this.UF) {
                    if (c.this.hVR != null && c.this.hVR.bPq()) {
                        return true;
                    }
                    c.this.bSP();
                    if (c.this.dbg.isPlaying()) {
                        c.this.bSQ();
                    } else {
                        c.this.bSR();
                    }
                    if (c.this.hVS != null) {
                        c.this.hVS.jV(c.this.dbg.isPlaying());
                    }
                } else {
                    c.this.bPe();
                    c.this.bSV();
                    if (c.this.currentState != 1) {
                        c.this.bSR();
                        c.this.bSS();
                    } else {
                        c.this.bAQ();
                    }
                    if (c.this.hVS != null) {
                        c.this.hVS.jV(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gHX.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gHX.setSystemUiVisibility(4);
        } else {
            this.gHX.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f2) {
        if (!this.UF) {
            this.mStatus = 0;
            return;
        }
        bAz();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gIE == 0) {
            if (f2 > 0.0f && this.gID < this.gIy) {
                this.gID++;
            }
            if (f2 < 0.0f && this.gID > 0) {
                this.gID--;
            }
        }
        if (this.mProgress > 0) {
            this.gIw.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.gIw.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gID, 0);
        this.gIv.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gIz += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gIA = 1;
            } else {
                this.gIz += 1000;
                this.gIA = 2;
            }
            if (this.gIz < 0) {
                this.gIz = 0;
            } else if (this.gIz > this.dbg.getDuration()) {
                this.gIz = this.dbg.getDuration();
            }
        }
        bAz();
        String xr = this.gHZ.xr(this.gIz);
        if (f2 > 0.0f) {
            this.gIx.setImageResource(d.f.icon_kuaitui);
        } else {
            this.gIx.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(xr)) {
            this.gIu.setText(new StringBuilder().append(xr).append("/").append(this.gHZ.xr(this.dbg.getDuration())));
        }
        this.gHZ.setCurrentDuration(this.gIz, z ? false : true);
        bST();
        bSI();
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

    public void bSC() {
        if (this.dbg != null) {
            this.dbg.bSC();
        }
    }

    public void setFid(String str) {
        this.ele = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        int i2 = 100;
        if (this.dbg != null && this.ehP != null && this.gHZ != null) {
            this.gHZ.showProgress();
            this.mStartPosition = y.bTT().AV(this.bNk);
            if (this.hWf) {
                this.ehP.setVolume(1.0f, 1.0f);
                this.dbg.start();
                this.hWf = false;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.UL, 20L);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWm);
                if (this.dbg.bTp()) {
                    this.currentState = 1;
                    this.dbg.setRecoveryState(1);
                    bST();
                }
                this.mStartPosition = y.bTT().AV(this.bNk);
                this.gHZ.setPlayer(this.dbg);
                if (this.mStartPosition != 0 && !this.ehP.isPlayerReuse()) {
                    this.hVZ = true;
                }
                if (!this.hWe) {
                    this.gHZ.showProgress();
                }
                if (!this.hVI && this.ehP.getDuration() <= 0) {
                    bAD().setVisibility(4);
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
        if (this.gIk.getVisibility() != 8) {
            this.UF = true;
            this.gIa.setVisibility(8);
            this.ekJ.setVisibility(8);
            this.cAk.bTO();
            this.gIk.setVisibility(8);
            bSU();
            if (bSW()) {
                this.ehR.a(this.ctx, -1L, this.dbg.getDuration() / 1000, "middle", this.dbg);
            }
            this.gHZ.showProgress();
            this.hVz.setVisibility(0);
            if (this.gIl != null) {
                this.gIl.onPrepared(this.dbg.getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.hVA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hVA.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.hVA.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.hVA.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.hVA.setLayoutParams(layoutParams);
        }
    }

    public void bPe() {
        if (this.dbg.isPlaying()) {
            pausePlay();
            if (this.hVW != null) {
                this.hVW.onPause();
            }
            if (this.hVN != null) {
                this.hVN.onPaused();
            }
        } else if (this.UF) {
            bAL();
            if (this.hFo != null) {
                this.hFo.beT();
            }
            if (this.hVN != null) {
                this.hVN.azJ();
            }
        } else {
            bSM();
        }
    }

    public boolean bSD() {
        return this.gIG;
    }

    public void bAC() {
        this.gIG = true;
        if (this.cVs != null) {
            this.cVs.bAC();
        }
    }

    public boolean bSE() {
        return this.ehP != null && this.ehP.getVideoHeight() > this.ehP.getVideoWidth();
    }

    public void bSF() {
        oR(false);
        bSH();
    }

    public boolean xl(int i2) {
        switch (i2) {
            case 4:
                if (this.US) {
                    if (bSE()) {
                        oR(false);
                        bSH();
                    } else {
                        bAC();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.gIy <= 0 || this.gIv == null) {
                    return false;
                }
                this.gID = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gID * 100.0d) / this.gIy);
                this.gIv.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public VideoListMediaControllerView bAD() {
        return this.gHZ;
    }

    public void show() {
        this.gHX.setVisibility(0);
    }

    public void bAH() {
        if (this.gIi != null) {
            ViewGroup.LayoutParams layoutParams = this.gIi.getLayoutParams();
            this.gIc = (FrameLayout.LayoutParams) this.gHX.getLayoutParams();
            this.gIc.width = layoutParams.width;
            this.gIc.height = layoutParams.height;
            this.gIc.topMargin = 0;
            this.gHX.setLayoutParams(this.gIc);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gIG) {
            if (this.US) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gIG = false;
        }
        if (configuration.orientation == 2) {
            bSG();
        } else {
            bSH();
        }
        bSI();
        bAL();
        bSV();
        bAQ();
        if (this.hVS != null) {
            this.hVS.jV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSG() {
        this.US = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bSE()) {
            this.gHX.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gHX.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.ekE.setVisibility(0);
        this.gIn.setVisibility(0);
        this.gIo.setVisibility(0);
        this.gIb.setVisibility(8);
        this.cAk.bTP();
        this.gIk.setVisibility(8);
        this.gIf.setImageResource(d.f.icon_video_narrow_white);
        uV(this.gIC);
        bAB();
        if (this.hVK != null) {
            this.hVK.qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSH() {
        this.US = false;
        if (this.gIc != null) {
            this.gHX.setLayoutParams(this.gIc);
        }
        g(this.mActivity, false);
        this.ekE.setVisibility(8);
        this.gIb.setVisibility(0);
        this.cAk.bTP();
        this.gIk.setVisibility(8);
        this.gIf.setImageResource(d.f.icon_video_enlarge_white);
        if (this.gHZ != null && (this.gHZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHZ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.gHZ.setLayoutParams(layoutParams);
        }
        this.gHX.setSystemUiVisibility(0);
        bSB();
        if (this.hVK != null) {
            this.hVK.qk();
        }
    }

    public void bSI() {
        if (this.dbg != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.US) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.hVz.setMax(aO);
            int duration = this.dbg.getDuration();
            if (duration > 0) {
                if (this.hVC.getVisibility() == 0) {
                    this.hVz.setProgress(this.hVz.getMax());
                } else {
                    this.hVz.setProgress((int) ((this.dbg.getCurrentPosition() * this.hVz.getMax()) / duration));
                }
            }
        }
    }

    private void uV(int i2) {
        if (this.gHZ != null && (this.gHZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHZ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gHZ.setLayoutParams(layoutParams);
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

    public boolean bAJ() {
        return !this.US;
    }

    public void a(g.f fVar) {
        this.gIl = fVar;
    }

    public void a(g.a aVar) {
        this.hVF = aVar;
    }

    public void a(g.b bVar) {
        this.hVG = bVar;
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
        if (this.hWa) {
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
        bSN();
        this.hWf = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbg.setVideoPath(str, str2);
        this.ehR.bEB();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        if (this.hVM > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIJ, this.hVM);
        }
        if (this.hVN != null) {
            this.hVN.onStarted();
        }
        this.cAk.startLoading();
        oS(true);
    }

    public void dD(String str, String str2) {
        bSN();
        this.hWf = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        if (this.hVM > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIJ, this.hVM);
        }
        if (this.hVN != null) {
            this.hVN.onStarted();
        }
        this.cAk.startLoading();
        oS(true);
    }

    public void bSJ() {
        bAL();
        this.hVz.setVisibility(0);
    }

    public void bAL() {
        int i2 = 100;
        if (this.dbg != null && this.gHZ != null) {
            this.UF = true;
            this.currentState = 1;
            this.dbg.setRecoveryState(1);
            this.dbg.start();
            if (this.ehP != null && this.gHZ != null) {
                this.mStartPosition = y.bTT().AV(this.bNk);
                if (this.mStartPosition != 0 && !this.ehP.isPlayerReuse()) {
                    this.hVZ = true;
                }
                if (this.mStartPosition > 100 && this.ehP.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.UG = i2;
            } else {
                this.UG = 100;
            }
            this.cAk.bTP();
            oS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kY() && this.hWd && !StringUtils.isNull(this.bNk) && !StringUtils.isNull(this.ctx)) {
            this.hWd = false;
            this.hWe = true;
            cf(this.bNk, this.ctx);
        }
    }

    private void oS(boolean z) {
        if (z) {
            this.gIk.setVisibility(0);
            bST();
            this.hVz.setProgress(0);
        } else {
            this.gIk.setVisibility(8);
        }
        this.gHZ.showProgress();
        this.gIa.setVisibility(8);
        this.hVD.setVisibility(8);
        this.hVC.setVisibility(8);
        this.hVE.setVisibility(8);
        this.ekJ.setVisibility(8);
    }

    private void bSK() {
        this.cAk.bTP();
        this.hVD.setVisibility(8);
        this.hVC.setVisibility(8);
        this.hVE.setVisibility(8);
        bSV();
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
        bSK();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dbg.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWm);
        this.dbg.stopPlayback();
        this.UF = false;
        this.hWf = false;
        this.mStartPosition = 0;
        bnR();
    }

    public void bSL() {
        if (this.dbg.getDuration() >= this.dbg.getCurrentPosition()) {
            y.bTT().bj(this.bNk, this.dbg.getCurrentPosition());
        }
    }

    public void oT(boolean z) {
        this.hVY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        if (this.gIg != null) {
            this.gIa.setVisibility(0);
            this.hVD.setVisibility(8);
            this.hVC.setVisibility(8);
            this.hVE.setVisibility(8);
            this.cAk.bTP();
            bST();
            this.hVz.setVisibility(8);
            this.ekJ.setVisibility(8);
            this.gHZ.awK();
            this.gIk.setVisibility(z ? 0 : 8);
        }
    }

    public void bnR() {
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
        this.hVQ = kVar;
    }

    public void a(j jVar) {
        this.hVP = jVar;
    }

    public void a(i iVar) {
        this.hFo = iVar;
    }

    public void a(g gVar) {
        this.hVW = gVar;
    }

    public void a(h hVar) {
        this.hVO = hVar;
    }

    public void At(String str) {
        this.hEO = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSM() {
        a(this.bNk, this.ctx, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.hVL = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bSN();
        if (com.baidu.adp.lib.util.j.la() && !com.baidu.tieba.video.g.ciM().ciN()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.hWa = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.hVV != null) {
                    this.hVV.jx(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.ly(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bSO();
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
            } else if (this.hVV != null) {
                this.hVV.jx(true);
                return;
            } else {
                if (!this.hVy) {
                    this.hVy = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, d.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.hVU != null) {
            this.hVU.beQ();
        }
    }

    private void bSN() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciM().ey(this.mActivity);
        }
    }

    public void bSO() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gIk.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWm);
        this.cVs.stop();
        gIF.unregister(this.mActivity);
    }

    public void AQ(String str) {
        this.gIo.setText(str);
    }

    public boolean bAM() {
        return this.UF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSP() {
        if (this.gIg != null) {
            if (this.hVH) {
                bST();
            } else {
                bSS();
            }
        }
    }

    public void bAQ() {
        bSS();
        bSQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSQ() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gIN, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSR() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
    }

    public void bSS() {
        if (this.gIg != null && !this.hVH && !this.hWj) {
            oV(true);
            bAP();
            this.gIg.setVisibility(0);
            this.hVA.setVisibility(0);
            this.hVz.setVisibility(8);
            this.hVH = true;
            if (this.hVL != null) {
                this.hVL.jy(false);
            }
        }
    }

    public void bAN() {
        if (this.gIg != null && this.hVH) {
            oV(false);
            bAP();
            this.gIg.setVisibility(8);
            this.hVA.setVisibility(8);
            this.hVz.setVisibility(0);
            this.fez.setAnimationListener(this.gIL);
            this.gIg.startAnimation(this.fez);
            this.hVH = false;
            if (this.hVL != null) {
                this.hVL.beS();
            }
        }
    }

    public void bST() {
        if (this.gIg != null && this.hVH) {
            this.aeX.cancel();
            this.fez.cancel();
            oV(false);
            bAP();
            this.gIg.setVisibility(8);
            this.hVA.setVisibility(8);
            this.hVz.setVisibility(0);
            this.hVH = false;
            if (this.hVL != null) {
                this.hVL.beS();
            }
        }
    }

    private void bAP() {
        if (this.gIg != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
            this.aeX.setAnimationListener(null);
            this.fez.setAnimationListener(null);
            this.gIg.clearAnimation();
        }
    }

    private void bSU() {
        if (this.gIg != null) {
            this.aeX.setAnimationListener(null);
            this.fez.setAnimationListener(null);
            this.gIg.clearAnimation();
        }
    }

    public void oV(boolean z) {
        bSV();
        if (z) {
            this.hVB.setVisibility(0);
        } else {
            this.hVB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSV() {
        if (this.currentState == 1) {
            this.hVB.setState(1);
        } else {
            this.hVB.setState(0);
        }
    }

    public void a(InterfaceC0294c interfaceC0294c) {
        this.hVK = interfaceC0294c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ae(boolean z, boolean z2) {
        if (this.cVs != null) {
            if (this.gIf != null) {
                this.gIf.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gHZ != null && (this.gHZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHZ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds52);
                this.gHZ.setLayoutParams(layoutParams);
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
        this.hWi = z;
    }

    public void a(m mVar) {
        this.hVR = mVar;
    }

    public void a(a aVar) {
        this.hVS = aVar;
    }

    public void a(n nVar) {
        this.hVT = nVar;
    }

    public void a(l lVar) {
        this.hVU = lVar;
    }

    public void a(f fVar) {
        this.hVV = fVar;
    }

    public void oX(boolean z) {
        this.hWc = z;
    }

    public boolean bSW() {
        return this.hVI;
    }

    public void oY(boolean z) {
        this.hVI = z;
    }

    public void xm(int i2) {
        this.hWg = i2;
    }

    public View bSX() {
        return this.gHX;
    }

    public void a(o oVar) {
        this.hVN = oVar;
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
        this.gID = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oZ(boolean z) {
        this.hWj = z;
        if (z) {
            bST();
        } else {
            bAQ();
        }
    }

    public void a(p pVar) {
        this.hFc = pVar;
    }
}
