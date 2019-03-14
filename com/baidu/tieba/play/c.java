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
    private Animation aeY;
    private String bNl;
    private x cAh;
    private com.baidu.tieba.play.o cVo;
    private String ctu;
    protected QuickVideoView dbc;
    private com.baidu.tieba.play.g ehL;
    private com.baidu.tieba.j.k ehN;
    private View ekA;
    protected View ekF;
    private String ela;
    private Animation fey;
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
    private p hEW;
    private i hFi;
    private g.b hVA;
    private View.OnClickListener hVD;
    protected InterfaceC0368c hVE;
    private d hVF;
    private o hVH;
    private h hVI;
    private j hVJ;
    private k hVK;
    private m hVL;
    private a hVM;
    private n hVN;
    private l hVO;
    private f hVP;
    private g hVQ;
    private TextView hVV;
    private boolean hVX;
    private boolean hVY;
    private boolean hVZ;
    private ProgressBar hVt;
    private View hVu;
    private SwitchImageView hVv;
    private TextView hVw;
    private TextView hVx;
    private TextView hVy;
    private g.a hVz;
    private int hWa;
    private boolean hWb;
    private boolean hWc;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int UH = 100;
    private boolean hVs = false;
    protected boolean UT = false;
    private boolean UG = false;
    private boolean hVB = false;
    private boolean hVC = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIy = 0;
    private int gIz = 0;
    private long hVG = 60000;
    private int gIB = 0;
    private boolean gIF = false;
    private boolean hVR = true;
    private boolean hVS = true;
    private boolean hVT = false;
    private boolean hVU = false;
    private String hEI = null;
    private int currentState = -1;
    private boolean hVW = false;
    private boolean hWd = false;
    private boolean hWe = false;
    private g.f cJG = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.ehL = gVar;
            c.this.ehN.bEB();
            if (c.this.gHY != null && c.this.ehL != null && c.this.ehL.getDuration() > 0) {
                c.this.gHY.ax(0, c.this.ehL.getDuration());
            }
            c.this.aQn();
        }
    };
    private g.e cJI = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.qB();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a ehX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aQn();
        }
    };
    private Runnable UM = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UM);
            if (c.this.gIj.getVisibility() != 8) {
                if (c.this.dbc.getCurrentPosition() > c.this.UH) {
                    c.this.qB();
                } else {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UM, 20L);
                }
            }
        }
    };
    private g.a cJF = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dbc != null) {
                int duration = c.this.dbc.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.UG = false;
                    c.this.hVZ = false;
                    c.this.mStartPosition = 0;
                    c.this.bAx();
                    c.this.gHZ.setVisibility(0);
                    c.this.hVt.setProgress(c.this.hVt.getMax());
                    c.this.UH = 100;
                    if (c.this.hVz != null) {
                        c.this.hVz.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dbc.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.oU(false);
                        c.this.oV(true);
                    } else {
                        c.this.bSV();
                        c.this.hVw.setVisibility(0);
                    }
                    if (!c.this.UT && duration <= 150000) {
                        if (!c.this.hVW) {
                            if (c.this.hVJ != null) {
                                c.this.hVJ.oq(true);
                            }
                            c.this.cf(c.this.bNl, c.this.ctu);
                        } else {
                            c.this.currentState = 5;
                            c.this.dbc.setRecoveryState(5);
                            c.this.dbc.getPlayer().pause();
                            c.this.dbc.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.hVH != null) {
                        c.this.hVH.lV(c.this.hVt.getMax());
                        c.this.hVH.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gIH = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.ekF.setVisibility(0);
            c.this.cAh.bTR();
            c.this.currentState = 4;
            c.this.dbc.setRecoveryState(4);
            if (c.this.hVA != null) {
                c.this.hVA.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kY()) {
                c.this.hVX = true;
            }
            if (c.this.hVH != null) {
                c.this.hVH.azH();
            }
            c.this.hVZ = false;
            return true;
        }
    };
    protected Runnable gII = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbc == null || !c.this.dbc.isPlaying()) {
                c.this.ekF.setVisibility(0);
                c.this.cAh.bTR();
                if (c.this.hVH != null) {
                    c.this.hVH.azH();
                }
            }
        }
    };
    private g.InterfaceC0369g cJJ = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0369g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.hVT) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWf, 200L);
            }
        }
    };
    private Runnable hWf = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbc == null || !c.this.hVT) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UM, 200L);
                c.this.hVT = false;
            } else if (c.this.mStartPosition != c.this.dbc.getCurrentPosition()) {
                c.this.hVT = false;
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UM, 20L);
            } else {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWf, 200L);
            }
        }
    };
    private QuickVideoView.b cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UG = false;
            if (c.this.hVC) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hWg, 300L);
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UM);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gII);
        }
    };
    private Runnable hWg = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.hVZ = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hEW != null) {
                c.this.hEW.bPp();
            }
            if (view.getId() != c.this.ekF.getId()) {
                if (view.getId() != c.this.hVv.getId()) {
                    if (view.getId() == c.this.hVx.getId()) {
                        if (c.this.hVI != null) {
                            c.this.hVI.bPq();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.hVw.getId()) {
                        if (c.this.hVJ != null) {
                            c.this.hVJ.oq(false);
                        }
                        c.this.cf(c.this.bNl, c.this.ctu);
                        return;
                    } else if (view.getId() == c.this.gIe.getId()) {
                        int i2 = c.this.hVC ? 1 : 2;
                        if (c.this.UT) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctu).bJ(ImageViewerConfig.FORUM_ID, c.this.ela).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctu).bJ(ImageViewerConfig.FORUM_ID, c.this.ela).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.hVO != null) {
                            c.this.hVO.beQ();
                        }
                        if (c.this.bSG()) {
                            if (c.this.UT) {
                                c.this.bSJ();
                            } else {
                                c.this.bSI();
                            }
                            c.this.oR(c.this.UT);
                            return;
                        }
                        c.this.bAB();
                        return;
                    } else if (view.getId() != c.this.gIm.getId()) {
                        if (c.this.hVD != null) {
                            c.this.hVD.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.hVO != null) {
                            c.this.hVO.beQ();
                        }
                        if (c.this.bSG()) {
                            c.this.bSJ();
                            c.this.oR(false);
                            return;
                        }
                        c.this.bAB();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bPg();
                c.this.bSX();
                if (c.this.currentState != 1) {
                    c.this.bST();
                    c.this.bSU();
                } else {
                    c.this.bAP();
                }
                if (c.this.hVM != null) {
                    c.this.hVM.jV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dbc.stopPlayback();
            c.this.UG = false;
            c.this.bSO();
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
            if (c.this.dbc != null && (duration = c.this.dbc.getDuration()) > 0 && c.this.hVt != null) {
                c.this.hVt.setProgress((int) ((i2 * c.this.gHW.getWidth()) / duration));
                if (c.this.hVH != null) {
                    c.this.hVH.lV((c.this.dbc.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cNS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bST();
            c.this.oV(false);
            if (c.this.hVM != null) {
                c.this.hVM.jV(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bAC() != null) {
                c.this.setStartPosition(c.this.bAC().getSeekPosition());
                if (!c.this.bAL()) {
                    c.this.bSO();
                } else {
                    c.this.bAK();
                    if (c.this.hFi != null) {
                        c.this.hFi.beS();
                    }
                }
            }
            c.this.oV(true);
            c.this.bSS();
            if (c.this.hVM != null) {
                c.this.hVM.jV(true);
            }
            if (c.this.hVN != null) {
                c.this.hVN.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a hWh = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bTa() {
            if (!c.this.hVW) {
                c.this.cAh.startLoading();
                c.this.gIj.setVisibility(0);
                c.this.hVv.setVisibility(8);
                c.this.hVx.setVisibility(8);
                c.this.hVw.setVisibility(8);
                c.this.hVy.setVisibility(8);
                c.this.ekF.setVisibility(8);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gII);
                if (c.this.hVG > 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.gII, c.this.hVG);
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
    public interface InterfaceC0368c {
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
        void bPq();
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
        boolean bPr();

        boolean bPs();
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
        void bPp();
    }

    public c(Activity activity, View view, boolean z) {
        this.hWb = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.hWb = z;
            this.gIh = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.hWb = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.hWb = z;
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
        this.dbc = (QuickVideoView) this.gHW.findViewById(d.g.videoView);
        this.cAh = new x((ViewGroup) this.gHW.findViewById(d.g.auto_video_loading_container));
        this.cAh.setLoadingAnimationListener(this.ehX);
        this.gHY = (VideoListMediaControllerView) this.gHW.findViewById(d.g.media_controller);
        this.gHY.setPlayer(this.dbc);
        this.hVt = (ProgressBar) this.gHW.findViewById(d.g.pgrBottomProgress);
        this.hVt.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.hVt.setProgress(0);
        this.gHY.setOnSeekBarChangeListener(this.cNS);
        this.gHY.setOnProgressUpdatedListener(this.gKI);
        this.gHZ = this.gHW.findViewById(d.g.black_mask);
        this.ekF = this.gHW.findViewById(d.g.layout_error);
        this.ekF.setOnClickListener(this.mOnClickListener);
        this.hVV = (TextView) this.gHW.findViewById(d.g.auto_video_error_tips);
        this.gIa = (FrameLayout) this.gHW.findViewById(d.g.danmu_container);
        this.gIe = (ImageView) this.gHW.findViewById(d.g.img_full_screen);
        this.gIe.setOnClickListener(this.mOnClickListener);
        this.gIf = this.gHW.findViewById(d.g.layout_media_controller);
        this.hVu = this.gHW.findViewById(d.g.time_show_controller);
        this.dbc.setPlayerReuseEnable(true);
        this.dbc.setContinuePlayEnable(true);
        this.dbc.setOnPreparedListener(this.cJG);
        this.dbc.setOnCompletionListener(this.cJF);
        this.dbc.setOnErrorListener(this.gIH);
        this.dbc.setOnSeekCompleteListener(this.cJJ);
        this.dbc.setOnSurfaceDestroyedListener(this.cAq);
        this.dbc.setOnRecoveryCallback(this.hWh);
        this.dbc.setOnOutInfoListener(this.cJI);
        this.hVv = (SwitchImageView) this.gHW.findViewById(d.g.img_play_controller);
        this.hVv.setStateImage(d.f.btn_card_play_video_n, d.f.btn_card_stop_video_n);
        this.hVv.setState(0);
        this.hVv.setOnClickListener(this.mOnClickListener);
        this.hVw = (TextView) this.gHW.findViewById(d.g.txt_replay);
        this.hVw.setOnClickListener(this.mOnClickListener);
        this.hVx = (TextView) this.gHW.findViewById(d.g.txt_playnext);
        this.hVx.setOnClickListener(this.mOnClickListener);
        this.hVy = (TextView) this.gHW.findViewById(d.g.txt_next_video_title);
        this.gIj = (TbImageView) this.gHW.findViewById(d.g.video_thumbnail);
        this.gIj.setDefaultErrorResource(0);
        this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gIm = (ImageView) this.gHW.findViewById(d.g.img_exit);
        this.gIm.setOnClickListener(this.mOnClickListener);
        this.gIn = (TextView) this.gHW.findViewById(d.g.video_title);
        this.ekA = this.gHW.findViewById(d.g.layout_title);
        this.ekA.setVisibility(8);
        this.fey = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aeY = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gIx = this.mAudioManager.getStreamMaxVolume(3);
        this.gIC = this.mAudioManager.getStreamVolume(3);
        gID = 100 / this.gIx;
        this.gHW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.hVK != null) {
                    c.this.hVK.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.UG) {
                        if (c.this.mStatus == 1 && c.this.gIz != 0) {
                            c.this.b(c.this.gIz == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIz = 0;
                            c.this.gIy = 0;
                        }
                        if (!c.this.dbc.isPlaying()) {
                            c.this.hVx.setVisibility(8);
                            c.this.hVw.setVisibility(8);
                            c.this.hVy.setVisibility(8);
                        }
                    }
                    c.this.bAx();
                    if (c.this.hVK != null) {
                        c.this.hVK.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.cVo = new com.baidu.tieba.play.o(this.mActivity);
        if (this.hWb) {
            this.cVo.start();
        }
        this.gIB = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.ds16);
        if (gIE == null) {
            gIE = new CallStateReceiver();
        }
        gIE.register(this.mActivity);
        bSD();
        this.ehN = new com.baidu.tieba.j.k();
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

    public void bSD() {
        if (this.hVR) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gHW.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gHW.setSystemUiVisibility(0);
    }

    public void oP(boolean z) {
        this.hVR = z;
        bSD();
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
        this.hVD = onClickListener;
    }

    public void oQ(boolean z) {
        this.hVC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.hVK != null) {
                c.this.hVK.onStart();
            }
            if (c.this.UT && c.this.UG) {
                if (c.this.mStatus == 1) {
                    c.this.bSV();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aH(f2);
                    }
                } else {
                    if (c.this.UT) {
                        c.this.bAA();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIy = c.this.dbc.getCurrentPosition();
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
            if (!c.this.hWc) {
                if (c.this.hVL != null && c.this.hVL.bPr()) {
                    return true;
                }
                c.this.bPg();
                c.this.bSX();
                if (c.this.dbc.isPlaying()) {
                    c.this.bSS();
                } else {
                    c.this.bST();
                }
                if (c.this.hVM != null) {
                    c.this.hVM.jV(c.this.dbc.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.hWc) {
                if (c.this.UG) {
                    if (c.this.hVL != null && c.this.hVL.bPs()) {
                        return true;
                    }
                    c.this.bSR();
                    if (c.this.dbc.isPlaying()) {
                        c.this.bSS();
                    } else {
                        c.this.bST();
                    }
                    if (c.this.hVM != null) {
                        c.this.hVM.jV(c.this.dbc.isPlaying());
                    }
                } else {
                    c.this.bPg();
                    c.this.bSX();
                    if (c.this.currentState != 1) {
                        c.this.bST();
                        c.this.bSU();
                    } else {
                        c.this.bAP();
                    }
                    if (c.this.hVM != null) {
                        c.this.hVM.jV(c.this.currentState == 1);
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
        if (!this.UG) {
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
            } else if (this.gIy > this.dbc.getDuration()) {
                this.gIy = this.dbc.getDuration();
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
            this.gIt.setText(new StringBuilder().append(xr).append("/").append(this.gHY.xr(this.dbc.getDuration())));
        }
        this.gHY.setCurrentDuration(this.gIy, z ? false : true);
        bSV();
        bSK();
    }

    protected View am(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bNl = str;
        this.ctu = str2;
    }

    public void bSE() {
        if (this.dbc != null) {
            this.dbc.bSE();
        }
    }

    public void setFid(String str) {
        this.ela = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQn() {
        int i2 = 100;
        if (this.dbc != null && this.ehL != null && this.gHY != null) {
            this.gHY.showProgress();
            this.mStartPosition = y.bTV().AT(this.bNl);
            if (this.hVZ) {
                this.ehL.setVolume(1.0f, 1.0f);
                this.dbc.start();
                this.hVZ = false;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UM);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.UM, 20L);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWg);
                if (this.dbc.bTr()) {
                    this.currentState = 1;
                    this.dbc.setRecoveryState(1);
                    bSV();
                }
                this.mStartPosition = y.bTV().AT(this.bNl);
                this.gHY.setPlayer(this.dbc);
                if (this.mStartPosition != 0 && !this.ehL.isPlayerReuse()) {
                    this.hVT = true;
                }
                if (!this.hVY) {
                    this.gHY.showProgress();
                }
                if (!this.hVC && this.ehL.getDuration() <= 0) {
                    bAC().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.ehL.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.UH = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (this.gIj.getVisibility() != 8) {
            this.UG = true;
            this.gHZ.setVisibility(8);
            this.ekF.setVisibility(8);
            this.cAh.bTQ();
            this.gIj.setVisibility(8);
            bSW();
            if (bSY()) {
                this.ehN.a(this.ctu, -1L, this.dbc.getDuration() / 1000, "middle", this.dbc);
            }
            this.gHY.showProgress();
            this.hVt.setVisibility(0);
            if (this.gIk != null) {
                this.gIk.onPrepared(this.dbc.getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.hVu.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hVu.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.hVu.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.hVu.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.hVu.setLayoutParams(layoutParams);
        }
    }

    public void bPg() {
        if (this.dbc.isPlaying()) {
            pausePlay();
            if (this.hVQ != null) {
                this.hVQ.onPause();
            }
            if (this.hVH != null) {
                this.hVH.onPaused();
            }
        } else if (this.UG) {
            bAK();
            if (this.hFi != null) {
                this.hFi.beS();
            }
            if (this.hVH != null) {
                this.hVH.azI();
            }
        } else {
            bSO();
        }
    }

    public boolean bSF() {
        return this.gIF;
    }

    public void bAB() {
        this.gIF = true;
        if (this.cVo != null) {
            this.cVo.bAB();
        }
    }

    public boolean bSG() {
        return this.ehL != null && this.ehL.getVideoHeight() > this.ehL.getVideoWidth();
    }

    public void bSH() {
        oR(false);
        bSJ();
    }

    public boolean xl(int i2) {
        switch (i2) {
            case 4:
                if (this.UT) {
                    if (bSG()) {
                        oR(false);
                        bSJ();
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
        return this.dbc;
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
            if (this.UT) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gIF = false;
        }
        if (configuration.orientation == 2) {
            bSI();
        } else {
            bSJ();
        }
        bSK();
        bAK();
        bSX();
        bAP();
        if (this.hVM != null) {
            this.hVM.jV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSI() {
        this.UT = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bSG()) {
            this.gHW.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gHW.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.ekA.setVisibility(0);
        this.gIm.setVisibility(0);
        this.gIn.setVisibility(0);
        this.gIa.setVisibility(8);
        this.cAh.bTR();
        this.gIj.setVisibility(8);
        this.gIe.setImageResource(d.f.icon_video_narrow_white);
        uV(this.gIB);
        bAA();
        if (this.hVE != null) {
            this.hVE.qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSJ() {
        this.UT = false;
        if (this.gIb != null) {
            this.gHW.setLayoutParams(this.gIb);
        }
        g(this.mActivity, false);
        this.ekA.setVisibility(8);
        this.gIa.setVisibility(0);
        this.cAh.bTR();
        this.gIj.setVisibility(8);
        this.gIe.setImageResource(d.f.icon_video_enlarge_white);
        if (this.gHY != null && (this.gHY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.gHY.setLayoutParams(layoutParams);
        }
        this.gHW.setSystemUiVisibility(0);
        bSD();
        if (this.hVE != null) {
            this.hVE.qk();
        }
    }

    public void bSK() {
        if (this.dbc != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.UT) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.hVt.setMax(aO);
            int duration = this.dbc.getDuration();
            if (duration > 0) {
                if (this.hVw.getVisibility() == 0) {
                    this.hVt.setProgress(this.hVt.getMax());
                } else {
                    this.hVt.setProgress((int) ((this.dbc.getCurrentPosition() * this.hVt.getMax()) / duration));
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
        return !this.UT;
    }

    public void a(g.f fVar) {
        this.gIk = fVar;
    }

    public void a(g.a aVar) {
        this.hVz = aVar;
    }

    public void a(g.b bVar) {
        this.hVA = bVar;
    }

    public void h(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dbc != null) {
            this.dbc.setPbLoadingTime(currentTimeMillis);
        }
        cf(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.hVU) {
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
        bSP();
        this.hVZ = true;
        this.currentState = 0;
        this.dbc.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbc.setVideoPath(str, str2);
        this.ehN.bEA();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        if (this.hVG > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gII, this.hVG);
        }
        if (this.hVH != null) {
            this.hVH.onStarted();
        }
        this.cAh.startLoading();
        oS(true);
    }

    public void dD(String str, String str2) {
        bSP();
        this.hVZ = true;
        this.currentState = 0;
        this.dbc.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        if (this.hVG > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gII, this.hVG);
        }
        if (this.hVH != null) {
            this.hVH.onStarted();
        }
        this.cAh.startLoading();
        oS(true);
    }

    public void bSL() {
        bAK();
        this.hVt.setVisibility(0);
    }

    public void bAK() {
        int i2 = 100;
        if (this.dbc != null && this.gHY != null) {
            this.UG = true;
            this.currentState = 1;
            this.dbc.setRecoveryState(1);
            this.dbc.start();
            if (this.ehL != null && this.gHY != null) {
                this.mStartPosition = y.bTV().AT(this.bNl);
                if (this.mStartPosition != 0 && !this.ehL.isPlayerReuse()) {
                    this.hVT = true;
                }
                if (this.mStartPosition > 100 && this.ehL.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.UH = i2;
            } else {
                this.UH = 100;
            }
            this.cAh.bTR();
            oS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kY() && this.hVX && !StringUtils.isNull(this.bNl) && !StringUtils.isNull(this.ctu)) {
            this.hVX = false;
            this.hVY = true;
            cf(this.bNl, this.ctu);
        }
    }

    private void oS(boolean z) {
        if (z) {
            this.gIj.setVisibility(0);
            bSV();
            this.hVt.setProgress(0);
        } else {
            this.gIj.setVisibility(8);
        }
        this.gHY.showProgress();
        this.gHZ.setVisibility(8);
        this.hVx.setVisibility(8);
        this.hVw.setVisibility(8);
        this.hVy.setVisibility(8);
        this.ekF.setVisibility(8);
    }

    private void bSM() {
        this.cAh.bTR();
        this.hVx.setVisibility(8);
        this.hVw.setVisibility(8);
        this.hVy.setVisibility(8);
        bSX();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbc != null) {
            this.dbc.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dbc.pause();
        this.currentState = 2;
        this.dbc.setRecoveryState(2);
        bSM();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dbc.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWg);
        this.dbc.stopPlayback();
        this.UG = false;
        this.hVZ = false;
        this.mStartPosition = 0;
        bnQ();
    }

    public void bSN() {
        if (this.dbc.getDuration() >= this.dbc.getCurrentPosition()) {
            y.bTV().bj(this.bNl, this.dbc.getCurrentPosition());
        }
    }

    public void oT(boolean z) {
        this.hVS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        if (this.gIf != null) {
            this.gHZ.setVisibility(0);
            this.hVx.setVisibility(8);
            this.hVw.setVisibility(8);
            this.hVy.setVisibility(8);
            this.cAh.bTR();
            bSV();
            this.hVt.setVisibility(8);
            this.ekF.setVisibility(8);
            this.gHY.awJ();
            this.gIj.setVisibility(z ? 0 : 8);
        }
    }

    public void bnQ() {
        oU(true);
    }

    public boolean ql() {
        if (this.dbc == null) {
            return false;
        }
        return this.dbc.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dbc == null) {
            return 0;
        }
        return this.dbc.getCurrentPosition();
    }

    public void a(k kVar) {
        this.hVK = kVar;
    }

    public void a(j jVar) {
        this.hVJ = jVar;
    }

    public void a(i iVar) {
        this.hFi = iVar;
    }

    public void a(g gVar) {
        this.hVQ = gVar;
    }

    public void a(h hVar) {
        this.hVI = hVar;
    }

    public void Ar(String str) {
        this.hEI = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSO() {
        a(this.bNl, this.ctu, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.hVF = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bSP();
        if (com.baidu.adp.lib.util.j.la() && !com.baidu.tieba.video.g.ciP().ciQ()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.hVU = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.hVP != null) {
                    this.hVP.jx(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.ly(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bSQ();
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
            } else if (this.hVP != null) {
                this.hVP.jx(true);
                return;
            } else {
                if (!this.hVs) {
                    this.hVs = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, d.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.hVO != null) {
            this.hVO.beP();
        }
    }

    private void bSP() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciP().ex(this.mActivity);
        }
    }

    public void bSQ() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gIj.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWf);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWg);
        this.cVo.stop();
        gIE.unregister(this.mActivity);
    }

    public void AO(String str) {
        this.gIn.setText(str);
    }

    public boolean bAL() {
        return this.UG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSR() {
        if (this.gIf != null) {
            if (this.hVB) {
                bSV();
            } else {
                bSU();
            }
        }
    }

    public void bAP() {
        bSU();
        bSS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSS() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gIM, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bST() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
    }

    public void bSU() {
        if (this.gIf != null && !this.hVB && !this.hWd) {
            oV(true);
            bAO();
            this.gIf.setVisibility(0);
            this.hVu.setVisibility(0);
            this.hVt.setVisibility(8);
            this.hVB = true;
            if (this.hVF != null) {
                this.hVF.jy(false);
            }
        }
    }

    public void bAM() {
        if (this.gIf != null && this.hVB) {
            oV(false);
            bAO();
            this.gIf.setVisibility(8);
            this.hVu.setVisibility(8);
            this.hVt.setVisibility(0);
            this.fey.setAnimationListener(this.gIK);
            this.gIf.startAnimation(this.fey);
            this.hVB = false;
            if (this.hVF != null) {
                this.hVF.beR();
            }
        }
    }

    public void bSV() {
        if (this.gIf != null && this.hVB) {
            this.aeY.cancel();
            this.fey.cancel();
            oV(false);
            bAO();
            this.gIf.setVisibility(8);
            this.hVu.setVisibility(8);
            this.hVt.setVisibility(0);
            this.hVB = false;
            if (this.hVF != null) {
                this.hVF.beR();
            }
        }
    }

    private void bAO() {
        if (this.gIf != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
            this.aeY.setAnimationListener(null);
            this.fey.setAnimationListener(null);
            this.gIf.clearAnimation();
        }
    }

    private void bSW() {
        if (this.gIf != null) {
            this.aeY.setAnimationListener(null);
            this.fey.setAnimationListener(null);
            this.gIf.clearAnimation();
        }
    }

    public void oV(boolean z) {
        bSX();
        if (z) {
            this.hVv.setVisibility(0);
        } else {
            this.hVv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSX() {
        if (this.currentState == 1) {
            this.hVv.setState(1);
        } else {
            this.hVv.setState(0);
        }
    }

    public void a(InterfaceC0368c interfaceC0368c) {
        this.hVE = interfaceC0368c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ae(boolean z, boolean z2) {
        if (this.cVo != null) {
            if (this.gIe != null) {
                this.gIe.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gHY != null && (this.gHY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds52);
                this.gHY.setLayoutParams(layoutParams);
            }
            this.cVo.pc(z);
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
        this.hWc = z;
    }

    public void a(m mVar) {
        this.hVL = mVar;
    }

    public void a(a aVar) {
        this.hVM = aVar;
    }

    public void a(n nVar) {
        this.hVN = nVar;
    }

    public void a(l lVar) {
        this.hVO = lVar;
    }

    public void a(f fVar) {
        this.hVP = fVar;
    }

    public void oX(boolean z) {
        this.hVW = z;
    }

    public boolean bSY() {
        return this.hVC;
    }

    public void oY(boolean z) {
        this.hVC = z;
    }

    public void xm(int i2) {
        this.hWa = i2;
    }

    public View bSZ() {
        return this.gHW;
    }

    public void a(o oVar) {
        this.hVH = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dbc != null) {
            this.dbc.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.gIC = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oZ(boolean z) {
        this.hWd = z;
        if (z) {
            bSV();
        } else {
            bAP();
        }
    }

    public void a(p pVar) {
        this.hEW = pVar;
    }
}
