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
    private static int gIr;
    private static CallStateReceiver gIs;
    private Animation afe;
    private String bNo;
    private x cAk;
    private com.baidu.tieba.play.o cVr;
    private String ctx;
    protected QuickVideoView dbg;
    private com.baidu.tieba.j.k ehA;
    private com.baidu.tieba.play.g ehy;
    private String ekN;
    private View ekn;
    protected View eks;
    private Animation fel;
    public View gHK;
    private VideoListMediaControllerView gHM;
    private View gHN;
    private FrameLayout gHO;
    protected FrameLayout.LayoutParams gHP;
    private ImageView gHS;
    private View gHT;
    private View gHV;
    private TbImageView gHX;
    private g.f gHY;
    private ImageView gIa;
    private TextView gIb;
    private View gIf;
    private View gIg;
    private TextView gIh;
    private SeekBar gIi;
    private ImageView gIj;
    private ImageView gIk;
    private int gIl;
    private int gIq;
    private p hEJ;
    private i hEV;
    private n hVA;
    private l hVB;
    private f hVC;
    private g hVD;
    private TextView hVI;
    private boolean hVK;
    private boolean hVL;
    private boolean hVM;
    private int hVN;
    private boolean hVO;
    private boolean hVP;
    private ProgressBar hVg;
    private View hVh;
    private SwitchImageView hVi;
    private TextView hVj;
    private TextView hVk;
    private TextView hVl;
    private g.a hVm;
    private g.b hVn;
    private View.OnClickListener hVq;
    protected InterfaceC0368c hVr;
    private d hVs;
    private o hVu;
    private h hVv;
    private j hVw;
    private k hVx;
    private m hVy;
    private a hVz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int UI = 100;
    private boolean hVf = false;
    protected boolean UU = false;
    private boolean UH = false;
    private boolean hVo = false;
    private boolean hVp = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIm = 0;
    private int gIn = 0;
    private long hVt = 60000;
    private int gIp = 0;
    private boolean gIt = false;
    private boolean hVE = true;
    private boolean hVF = true;
    private boolean hVG = false;
    private boolean hVH = false;
    private String hEv = null;
    private int currentState = -1;
    private boolean hVJ = false;
    private boolean hVQ = false;
    private boolean hVR = false;
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.ehy = gVar;
            c.this.ehA.bEy();
            if (c.this.gHM != null && c.this.ehy != null && c.this.ehy.getDuration() > 0) {
                c.this.gHM.ax(0, c.this.ehy.getDuration());
            }
            c.this.aQl();
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
    private VideoLoadingProgressView.a ehK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aQl();
        }
    };
    private Runnable UN = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UN);
            if (c.this.gHX.getVisibility() != 8) {
                if (c.this.dbg.getCurrentPosition() > c.this.UI) {
                    c.this.qB();
                } else {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UN, 20L);
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
                    c.this.UH = false;
                    c.this.hVM = false;
                    c.this.mStartPosition = 0;
                    c.this.bAu();
                    c.this.gHN.setVisibility(0);
                    c.this.hVg.setProgress(c.this.hVg.getMax());
                    c.this.UI = 100;
                    if (c.this.hVm != null) {
                        c.this.hVm.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dbg.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.oU(false);
                        c.this.oV(true);
                    } else {
                        c.this.bSR();
                        c.this.hVj.setVisibility(0);
                    }
                    if (!c.this.UU && duration <= 150000) {
                        if (!c.this.hVJ) {
                            if (c.this.hVw != null) {
                                c.this.hVw.oq(true);
                            }
                            c.this.cf(c.this.bNo, c.this.ctx);
                        } else {
                            c.this.currentState = 5;
                            c.this.dbg.setRecoveryState(5);
                            c.this.dbg.getPlayer().pause();
                            c.this.dbg.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.hVu != null) {
                        c.this.hVu.lU(c.this.hVg.getMax());
                        c.this.hVu.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gIv = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.eks.setVisibility(0);
            c.this.cAk.bTN();
            c.this.currentState = 4;
            c.this.dbg.setRecoveryState(4);
            if (c.this.hVn != null) {
                c.this.hVn.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kY()) {
                c.this.hVK = true;
            }
            if (c.this.hVu != null) {
                c.this.hVu.azE();
            }
            c.this.hVM = false;
            return true;
        }
    };
    protected Runnable gIw = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg == null || !c.this.dbg.isPlaying()) {
                c.this.eks.setVisibility(0);
                c.this.cAk.bTN();
                if (c.this.hVu != null) {
                    c.this.hVu.azE();
                }
            }
        }
    };
    private g.InterfaceC0369g cJM = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0369g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.hVG) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hVS, 200L);
            }
        }
    };
    private Runnable hVS = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg == null || !c.this.hVG) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UN, 200L);
                c.this.hVG = false;
            } else if (c.this.mStartPosition != c.this.dbg.getCurrentPosition()) {
                c.this.hVG = false;
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UN, 20L);
            } else {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hVS, 200L);
            }
        }
    };
    private QuickVideoView.b cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UH = false;
            if (c.this.hVp) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hVT, 300L);
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UN);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIw);
        }
    };
    private Runnable hVT = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.hVM = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hEJ != null) {
                c.this.hEJ.bPm();
            }
            if (view.getId() != c.this.eks.getId()) {
                if (view.getId() != c.this.hVi.getId()) {
                    if (view.getId() == c.this.hVk.getId()) {
                        if (c.this.hVv != null) {
                            c.this.hVv.bPn();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.hVj.getId()) {
                        if (c.this.hVw != null) {
                            c.this.hVw.oq(false);
                        }
                        c.this.cf(c.this.bNo, c.this.ctx);
                        return;
                    } else if (view.getId() == c.this.gHS.getId()) {
                        int i2 = c.this.hVp ? 1 : 2;
                        if (c.this.UU) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctx).bJ(ImageViewerConfig.FORUM_ID, c.this.ekN).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctx).bJ(ImageViewerConfig.FORUM_ID, c.this.ekN).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.hVB != null) {
                            c.this.hVB.beO();
                        }
                        if (c.this.bSC()) {
                            if (c.this.UU) {
                                c.this.bSF();
                            } else {
                                c.this.bSE();
                            }
                            c.this.oR(c.this.UU);
                            return;
                        }
                        c.this.bAy();
                        return;
                    } else if (view.getId() != c.this.gIa.getId()) {
                        if (c.this.hVq != null) {
                            c.this.hVq.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.hVB != null) {
                            c.this.hVB.beO();
                        }
                        if (c.this.bSC()) {
                            c.this.bSF();
                            c.this.oR(false);
                            return;
                        }
                        c.this.bAy();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bPd();
                c.this.bST();
                if (c.this.currentState != 1) {
                    c.this.bSP();
                    c.this.bSQ();
                } else {
                    c.this.bAM();
                }
                if (c.this.hVz != null) {
                    c.this.hVz.jV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dbg.stopPlayback();
            c.this.UH = false;
            c.this.bSK();
        }
    };
    private Animation.AnimationListener gIy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gIz = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gIA = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bAJ();
        }
    };
    private CustomMessageListener gIB = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b gKw = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void ly(int i2) {
            int duration;
            if (c.this.dbg != null && (duration = c.this.dbg.getDuration()) > 0 && c.this.hVg != null) {
                c.this.hVg.setProgress((int) ((i2 * c.this.gHK.getWidth()) / duration));
                if (c.this.hVu != null) {
                    c.this.hVu.lU((c.this.dbg.getCurrentPosition() * 100) / duration);
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
            c.this.bSP();
            c.this.oV(false);
            if (c.this.hVz != null) {
                c.this.hVz.jV(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bAz() != null) {
                c.this.setStartPosition(c.this.bAz().getSeekPosition());
                if (!c.this.bAI()) {
                    c.this.bSK();
                } else {
                    c.this.bAH();
                    if (c.this.hEV != null) {
                        c.this.hEV.beQ();
                    }
                }
            }
            c.this.oV(true);
            c.this.bSO();
            if (c.this.hVz != null) {
                c.this.hVz.jV(true);
            }
            if (c.this.hVA != null) {
                c.this.hVA.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a hVU = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bSW() {
            if (!c.this.hVJ) {
                c.this.cAk.startLoading();
                c.this.gHX.setVisibility(0);
                c.this.hVi.setVisibility(8);
                c.this.hVk.setVisibility(8);
                c.this.hVj.setVisibility(8);
                c.this.hVl.setVisibility(8);
                c.this.eks.setVisibility(8);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIw);
                if (c.this.hVt > 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.gIw, c.this.hVt);
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
        void beP();

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
        void beQ();
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
        void beN();

        void beO();
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
        void azE();

        void azF();

        void lU(int i);

        void onPaused();

        void onPlayEnd();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bPm();
    }

    public c(Activity activity, View view, boolean z) {
        this.hVO = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.hVO = z;
            this.gHV = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.hVO = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.hVO = z;
            this.gHV = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gHK = am(this.mActivity);
        this.gHK.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gHK);
        }
        this.dbg = (QuickVideoView) this.gHK.findViewById(d.g.videoView);
        this.cAk = new x((ViewGroup) this.gHK.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.ehK);
        this.gHM = (VideoListMediaControllerView) this.gHK.findViewById(d.g.media_controller);
        this.gHM.setPlayer(this.dbg);
        this.hVg = (ProgressBar) this.gHK.findViewById(d.g.pgrBottomProgress);
        this.hVg.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.hVg.setProgress(0);
        this.gHM.setOnSeekBarChangeListener(this.cNV);
        this.gHM.setOnProgressUpdatedListener(this.gKw);
        this.gHN = this.gHK.findViewById(d.g.black_mask);
        this.eks = this.gHK.findViewById(d.g.layout_error);
        this.eks.setOnClickListener(this.mOnClickListener);
        this.hVI = (TextView) this.gHK.findViewById(d.g.auto_video_error_tips);
        this.gHO = (FrameLayout) this.gHK.findViewById(d.g.danmu_container);
        this.gHS = (ImageView) this.gHK.findViewById(d.g.img_full_screen);
        this.gHS.setOnClickListener(this.mOnClickListener);
        this.gHT = this.gHK.findViewById(d.g.layout_media_controller);
        this.hVh = this.gHK.findViewById(d.g.time_show_controller);
        this.dbg.setPlayerReuseEnable(true);
        this.dbg.setContinuePlayEnable(true);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gIv);
        this.dbg.setOnSeekCompleteListener(this.cJM);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnRecoveryCallback(this.hVU);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.hVi = (SwitchImageView) this.gHK.findViewById(d.g.img_play_controller);
        this.hVi.setStateImage(d.f.btn_card_play_video_n, d.f.btn_card_stop_video_n);
        this.hVi.setState(0);
        this.hVi.setOnClickListener(this.mOnClickListener);
        this.hVj = (TextView) this.gHK.findViewById(d.g.txt_replay);
        this.hVj.setOnClickListener(this.mOnClickListener);
        this.hVk = (TextView) this.gHK.findViewById(d.g.txt_playnext);
        this.hVk.setOnClickListener(this.mOnClickListener);
        this.hVl = (TextView) this.gHK.findViewById(d.g.txt_next_video_title);
        this.gHX = (TbImageView) this.gHK.findViewById(d.g.video_thumbnail);
        this.gHX.setDefaultErrorResource(0);
        this.gHX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gIa = (ImageView) this.gHK.findViewById(d.g.img_exit);
        this.gIa.setOnClickListener(this.mOnClickListener);
        this.gIb = (TextView) this.gHK.findViewById(d.g.video_title);
        this.ekn = this.gHK.findViewById(d.g.layout_title);
        this.ekn.setVisibility(8);
        this.fel = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afe = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gIl = this.mAudioManager.getStreamMaxVolume(3);
        this.gIq = this.mAudioManager.getStreamVolume(3);
        gIr = 100 / this.gIl;
        this.gHK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.hVx != null) {
                    c.this.hVx.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.UH) {
                        if (c.this.mStatus == 1 && c.this.gIn != 0) {
                            c.this.b(c.this.gIn == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIn = 0;
                            c.this.gIm = 0;
                        }
                        if (!c.this.dbg.isPlaying()) {
                            c.this.hVk.setVisibility(8);
                            c.this.hVj.setVisibility(8);
                            c.this.hVl.setVisibility(8);
                        }
                    }
                    c.this.bAu();
                    if (c.this.hVx != null) {
                        c.this.hVx.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.cVr = new com.baidu.tieba.play.o(this.mActivity);
        if (this.hVO) {
            this.cVr.start();
        }
        this.gIp = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.ds16);
        if (gIs == null) {
            gIs = new CallStateReceiver();
        }
        gIs.register(this.mActivity);
        bSz();
        this.ehA = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gIB);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gIB);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bSz() {
        if (this.hVE) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gHK.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gHK.setSystemUiVisibility(0);
    }

    public void oP(boolean z) {
        this.hVE = z;
        bSz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        this.mStatus = 0;
        if (this.gIf != null && this.gIf.getParent() != null && (this.gIf.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIf.getParent()).removeView(this.gIf);
                this.gIf = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gIg != null && this.gIg.getParent() != null && (this.gIg.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIg.getParent()).removeView(this.gIg);
                this.gIg = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bAv() {
        if (this.mStatus == 1) {
            if (this.gIf == null && this.gHK != null && (this.gHK instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_jindu, (ViewGroup) this.gHK, true);
                this.gIf = this.gHK.findViewById(d.g.lay_jindu);
                this.gIh = (TextView) this.gIf.findViewById(d.g.show_time);
                this.gIk = (ImageView) this.gIf.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gIg == null && this.gHK != null && (this.gHK instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_voice, (ViewGroup) this.gHK, true);
            this.gIg = this.gHK.findViewById(d.g.lay_voice);
            this.gIj = (ImageView) this.gIg.findViewById(d.g.arrow_voice_icon);
            this.gIi = (SeekBar) this.gIg.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.hVq = onClickListener;
    }

    public void oQ(boolean z) {
        this.hVp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.hVx != null) {
                c.this.hVx.onStart();
            }
            if (c.this.UU && c.this.UH) {
                if (c.this.mStatus == 1) {
                    c.this.bSR();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aH(f2);
                    }
                } else {
                    if (c.this.UU) {
                        c.this.bAx();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIm = c.this.dbg.getCurrentPosition();
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
            if (!c.this.hVP) {
                if (c.this.hVy != null && c.this.hVy.bPo()) {
                    return true;
                }
                c.this.bPd();
                c.this.bST();
                if (c.this.dbg.isPlaying()) {
                    c.this.bSO();
                } else {
                    c.this.bSP();
                }
                if (c.this.hVz != null) {
                    c.this.hVz.jV(c.this.dbg.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.hVP) {
                if (c.this.UH) {
                    if (c.this.hVy != null && c.this.hVy.bPp()) {
                        return true;
                    }
                    c.this.bSN();
                    if (c.this.dbg.isPlaying()) {
                        c.this.bSO();
                    } else {
                        c.this.bSP();
                    }
                    if (c.this.hVz != null) {
                        c.this.hVz.jV(c.this.dbg.isPlaying());
                    }
                } else {
                    c.this.bPd();
                    c.this.bST();
                    if (c.this.currentState != 1) {
                        c.this.bSP();
                        c.this.bSQ();
                    } else {
                        c.this.bAM();
                    }
                    if (c.this.hVz != null) {
                        c.this.hVz.jV(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAx() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gHK.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gHK.setSystemUiVisibility(4);
        } else {
            this.gHK.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f2) {
        if (!this.UH) {
            this.mStatus = 0;
            return;
        }
        bAv();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gIr == 0) {
            if (f2 > 0.0f && this.gIq < this.gIl) {
                this.gIq++;
            }
            if (f2 < 0.0f && this.gIq > 0) {
                this.gIq--;
            }
        }
        if (this.mProgress > 0) {
            this.gIj.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.gIj.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gIq, 0);
        this.gIi.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gIm += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gIn = 1;
            } else {
                this.gIm += 1000;
                this.gIn = 2;
            }
            if (this.gIm < 0) {
                this.gIm = 0;
            } else if (this.gIm > this.dbg.getDuration()) {
                this.gIm = this.dbg.getDuration();
            }
        }
        bAv();
        String xn = this.gHM.xn(this.gIm);
        if (f2 > 0.0f) {
            this.gIk.setImageResource(d.f.icon_kuaitui);
        } else {
            this.gIk.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(xn)) {
            this.gIh.setText(new StringBuilder().append(xn).append("/").append(this.gHM.xn(this.dbg.getDuration())));
        }
        this.gHM.setCurrentDuration(this.gIm, z ? false : true);
        bSR();
        bSG();
    }

    protected View am(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bNo = str;
        this.ctx = str2;
    }

    public void bSA() {
        if (this.dbg != null) {
            this.dbg.bSA();
        }
    }

    public void setFid(String str) {
        this.ekN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        int i2 = 100;
        if (this.dbg != null && this.ehy != null && this.gHM != null) {
            this.gHM.showProgress();
            this.mStartPosition = y.bTR().AS(this.bNo);
            if (this.hVM) {
                this.ehy.setVolume(1.0f, 1.0f);
                this.dbg.start();
                this.hVM = false;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UN);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.UN, 20L);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIw);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVT);
                if (this.dbg.bTn()) {
                    this.currentState = 1;
                    this.dbg.setRecoveryState(1);
                    bSR();
                }
                this.mStartPosition = y.bTR().AS(this.bNo);
                this.gHM.setPlayer(this.dbg);
                if (this.mStartPosition != 0 && !this.ehy.isPlayerReuse()) {
                    this.hVG = true;
                }
                if (!this.hVL) {
                    this.gHM.showProgress();
                }
                if (!this.hVp && this.ehy.getDuration() <= 0) {
                    bAz().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.ehy.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.UI = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (this.gHX.getVisibility() != 8) {
            this.UH = true;
            this.gHN.setVisibility(8);
            this.eks.setVisibility(8);
            this.cAk.bTM();
            this.gHX.setVisibility(8);
            bSS();
            if (bSU()) {
                this.ehA.a(this.ctx, -1L, this.dbg.getDuration() / 1000, "middle", this.dbg);
            }
            this.gHM.showProgress();
            this.hVg.setVisibility(0);
            if (this.gHY != null) {
                this.gHY.onPrepared(this.dbg.getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.hVh.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hVh.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.hVh.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.hVh.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.hVh.setLayoutParams(layoutParams);
        }
    }

    public void bPd() {
        if (this.dbg.isPlaying()) {
            pausePlay();
            if (this.hVD != null) {
                this.hVD.onPause();
            }
            if (this.hVu != null) {
                this.hVu.onPaused();
            }
        } else if (this.UH) {
            bAH();
            if (this.hEV != null) {
                this.hEV.beQ();
            }
            if (this.hVu != null) {
                this.hVu.azF();
            }
        } else {
            bSK();
        }
    }

    public boolean bSB() {
        return this.gIt;
    }

    public void bAy() {
        this.gIt = true;
        if (this.cVr != null) {
            this.cVr.bAy();
        }
    }

    public boolean bSC() {
        return this.ehy != null && this.ehy.getVideoHeight() > this.ehy.getVideoWidth();
    }

    public void bSD() {
        oR(false);
        bSF();
    }

    public boolean xh(int i2) {
        switch (i2) {
            case 4:
                if (this.UU) {
                    if (bSC()) {
                        oR(false);
                        bSF();
                    } else {
                        bAy();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.gIl <= 0 || this.gIi == null) {
                    return false;
                }
                this.gIq = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gIq * 100.0d) / this.gIl);
                this.gIi.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public VideoListMediaControllerView bAz() {
        return this.gHM;
    }

    public void show() {
        this.gHK.setVisibility(0);
    }

    public void bAD() {
        if (this.gHV != null) {
            ViewGroup.LayoutParams layoutParams = this.gHV.getLayoutParams();
            this.gHP = (FrameLayout.LayoutParams) this.gHK.getLayoutParams();
            this.gHP.width = layoutParams.width;
            this.gHP.height = layoutParams.height;
            this.gHP.topMargin = 0;
            this.gHK.setLayoutParams(this.gHP);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gIt) {
            if (this.UU) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gIt = false;
        }
        if (configuration.orientation == 2) {
            bSE();
        } else {
            bSF();
        }
        bSG();
        bAH();
        bST();
        bAM();
        if (this.hVz != null) {
            this.hVz.jV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSE() {
        this.UU = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bSC()) {
            this.gHK.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gHK.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.ekn.setVisibility(0);
        this.gIa.setVisibility(0);
        this.gIb.setVisibility(0);
        this.gHO.setVisibility(8);
        this.cAk.bTN();
        this.gHX.setVisibility(8);
        this.gHS.setImageResource(d.f.icon_video_narrow_white);
        uR(this.gIp);
        bAx();
        if (this.hVr != null) {
            this.hVr.qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSF() {
        this.UU = false;
        if (this.gHP != null) {
            this.gHK.setLayoutParams(this.gHP);
        }
        g(this.mActivity, false);
        this.ekn.setVisibility(8);
        this.gHO.setVisibility(0);
        this.cAk.bTN();
        this.gHX.setVisibility(8);
        this.gHS.setImageResource(d.f.icon_video_enlarge_white);
        if (this.gHM != null && (this.gHM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHM.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.gHM.setLayoutParams(layoutParams);
        }
        this.gHK.setSystemUiVisibility(0);
        bSz();
        if (this.hVr != null) {
            this.hVr.qk();
        }
    }

    public void bSG() {
        if (this.dbg != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.UU) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.hVg.setMax(aO);
            int duration = this.dbg.getDuration();
            if (duration > 0) {
                if (this.hVj.getVisibility() == 0) {
                    this.hVg.setProgress(this.hVg.getMax());
                } else {
                    this.hVg.setProgress((int) ((this.dbg.getCurrentPosition() * this.hVg.getMax()) / duration));
                }
            }
        }
    }

    private void uR(int i2) {
        if (this.gHM != null && (this.gHM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHM.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gHM.setLayoutParams(layoutParams);
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

    public boolean bAF() {
        return !this.UU;
    }

    public void a(g.f fVar) {
        this.gHY = fVar;
    }

    public void a(g.a aVar) {
        this.hVm = aVar;
    }

    public void a(g.b bVar) {
        this.hVn = bVar;
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
        if (this.hVH) {
            dE(str, str2);
        } else {
            cf(str, str2);
        }
        if (eVar != null) {
            eVar.pa(z);
        }
    }

    public void dD(String str, String str2) {
    }

    public void cf(String str, String str2) {
        bSL();
        this.hVM = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbg.setVideoPath(str, str2);
        this.ehA.bEx();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIw);
        if (this.hVt > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIw, this.hVt);
        }
        if (this.hVu != null) {
            this.hVu.onStarted();
        }
        this.cAk.startLoading();
        oS(true);
    }

    public void dE(String str, String str2) {
        bSL();
        this.hVM = true;
        this.currentState = 0;
        this.dbg.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIw);
        if (this.hVt > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIw, this.hVt);
        }
        if (this.hVu != null) {
            this.hVu.onStarted();
        }
        this.cAk.startLoading();
        oS(true);
    }

    public void bSH() {
        bAH();
        this.hVg.setVisibility(0);
    }

    public void bAH() {
        int i2 = 100;
        if (this.dbg != null && this.gHM != null) {
            this.UH = true;
            this.currentState = 1;
            this.dbg.setRecoveryState(1);
            this.dbg.start();
            if (this.ehy != null && this.gHM != null) {
                this.mStartPosition = y.bTR().AS(this.bNo);
                if (this.mStartPosition != 0 && !this.ehy.isPlayerReuse()) {
                    this.hVG = true;
                }
                if (this.mStartPosition > 100 && this.ehy.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.UI = i2;
            } else {
                this.UI = 100;
            }
            this.cAk.bTN();
            oS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kY() && this.hVK && !StringUtils.isNull(this.bNo) && !StringUtils.isNull(this.ctx)) {
            this.hVK = false;
            this.hVL = true;
            cf(this.bNo, this.ctx);
        }
    }

    private void oS(boolean z) {
        if (z) {
            this.gHX.setVisibility(0);
            bSR();
            this.hVg.setProgress(0);
        } else {
            this.gHX.setVisibility(8);
        }
        this.gHM.showProgress();
        this.gHN.setVisibility(8);
        this.hVk.setVisibility(8);
        this.hVj.setVisibility(8);
        this.hVl.setVisibility(8);
        this.eks.setVisibility(8);
    }

    private void bSI() {
        this.cAk.bTN();
        this.hVk.setVisibility(8);
        this.hVj.setVisibility(8);
        this.hVl.setVisibility(8);
        bST();
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
        bSI();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dbg.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UN);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIw);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVT);
        this.dbg.stopPlayback();
        this.UH = false;
        this.hVM = false;
        this.mStartPosition = 0;
        bnN();
    }

    public void bSJ() {
        if (this.dbg.getDuration() >= this.dbg.getCurrentPosition()) {
            y.bTR().bj(this.bNo, this.dbg.getCurrentPosition());
        }
    }

    public void oT(boolean z) {
        this.hVF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        if (this.gHT != null) {
            this.gHN.setVisibility(0);
            this.hVk.setVisibility(8);
            this.hVj.setVisibility(8);
            this.hVl.setVisibility(8);
            this.cAk.bTN();
            bSR();
            this.hVg.setVisibility(8);
            this.eks.setVisibility(8);
            this.gHM.awG();
            this.gHX.setVisibility(z ? 0 : 8);
        }
    }

    public void bnN() {
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
        this.hVx = kVar;
    }

    public void a(j jVar) {
        this.hVw = jVar;
    }

    public void a(i iVar) {
        this.hEV = iVar;
    }

    public void a(g gVar) {
        this.hVD = gVar;
    }

    public void a(h hVar) {
        this.hVv = hVar;
    }

    public void Aq(String str) {
        this.hEv = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        a(this.bNo, this.ctx, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.hVs = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bSL();
        if (com.baidu.adp.lib.util.j.la() && !com.baidu.tieba.video.g.ciN().ciO()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.hVH = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.hVC != null) {
                    this.hVC.jx(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.lz(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bSM();
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
                aVar.b(this.mContext).aaW();
                return;
            } else if (this.hVC != null) {
                this.hVC.jx(true);
                return;
            } else {
                if (!this.hVf) {
                    this.hVf = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, d.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.hVB != null) {
            this.hVB.beN();
        }
    }

    private void bSL() {
        if (com.baidu.adp.lib.util.j.la()) {
            com.baidu.tieba.video.g.ciN().ex(this.mActivity);
        }
    }

    public void bSM() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gHX.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIA);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UN);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIw);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVS);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVT);
        this.cVr.stop();
        gIs.unregister(this.mActivity);
    }

    public void AN(String str) {
        this.gIb.setText(str);
    }

    public boolean bAI() {
        return this.UH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSN() {
        if (this.gHT != null) {
            if (this.hVo) {
                bSR();
            } else {
                bSQ();
            }
        }
    }

    public void bAM() {
        bSQ();
        bSO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSO() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIA);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gIA, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSP() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIA);
    }

    public void bSQ() {
        if (this.gHT != null && !this.hVo && !this.hVQ) {
            oV(true);
            bAL();
            this.gHT.setVisibility(0);
            this.hVh.setVisibility(0);
            this.hVg.setVisibility(8);
            this.hVo = true;
            if (this.hVs != null) {
                this.hVs.jy(false);
            }
        }
    }

    public void bAJ() {
        if (this.gHT != null && this.hVo) {
            oV(false);
            bAL();
            this.gHT.setVisibility(8);
            this.hVh.setVisibility(8);
            this.hVg.setVisibility(0);
            this.fel.setAnimationListener(this.gIy);
            this.gHT.startAnimation(this.fel);
            this.hVo = false;
            if (this.hVs != null) {
                this.hVs.beP();
            }
        }
    }

    public void bSR() {
        if (this.gHT != null && this.hVo) {
            this.afe.cancel();
            this.fel.cancel();
            oV(false);
            bAL();
            this.gHT.setVisibility(8);
            this.hVh.setVisibility(8);
            this.hVg.setVisibility(0);
            this.hVo = false;
            if (this.hVs != null) {
                this.hVs.beP();
            }
        }
    }

    private void bAL() {
        if (this.gHT != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIA);
            this.afe.setAnimationListener(null);
            this.fel.setAnimationListener(null);
            this.gHT.clearAnimation();
        }
    }

    private void bSS() {
        if (this.gHT != null) {
            this.afe.setAnimationListener(null);
            this.fel.setAnimationListener(null);
            this.gHT.clearAnimation();
        }
    }

    public void oV(boolean z) {
        bST();
        if (z) {
            this.hVi.setVisibility(0);
        } else {
            this.hVi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bST() {
        if (this.currentState == 1) {
            this.hVi.setState(1);
        } else {
            this.hVi.setState(0);
        }
    }

    public void a(InterfaceC0368c interfaceC0368c) {
        this.hVr = interfaceC0368c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ac(boolean z, boolean z2) {
        if (this.cVr != null) {
            if (this.gHS != null) {
                this.gHS.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gHM != null && (this.gHM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHM.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds52);
                this.gHM.setLayoutParams(layoutParams);
            }
            this.cVr.pc(z);
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
        this.hVP = z;
    }

    public void a(m mVar) {
        this.hVy = mVar;
    }

    public void a(a aVar) {
        this.hVz = aVar;
    }

    public void a(n nVar) {
        this.hVA = nVar;
    }

    public void a(l lVar) {
        this.hVB = lVar;
    }

    public void a(f fVar) {
        this.hVC = fVar;
    }

    public void oX(boolean z) {
        this.hVJ = z;
    }

    public boolean bSU() {
        return this.hVp;
    }

    public void oY(boolean z) {
        this.hVp = z;
    }

    public void xi(int i2) {
        this.hVN = i2;
    }

    public View bSV() {
        return this.gHK;
    }

    public void a(o oVar) {
        this.hVu = oVar;
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
        this.gIq = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oZ(boolean z) {
        this.hVQ = z;
        if (z) {
            bSR();
        } else {
            bAM();
        }
    }

    public void a(p pVar) {
        this.hEJ = pVar;
    }
}
