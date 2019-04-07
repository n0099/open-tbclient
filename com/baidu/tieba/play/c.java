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
    private static int gIq;
    private static CallStateReceiver gIr;
    private Animation afd;
    private String bNn;
    private x cAj;
    private com.baidu.tieba.play.o cVq;
    private String ctw;
    protected QuickVideoView dbf;
    private com.baidu.tieba.play.g ehx;
    private com.baidu.tieba.j.k ehz;
    private String ekM;
    private View ekm;
    protected View ekr;
    private Animation fel;
    public View gHJ;
    private VideoListMediaControllerView gHL;
    private View gHM;
    private FrameLayout gHN;
    protected FrameLayout.LayoutParams gHO;
    private ImageView gHR;
    private View gHS;
    private View gHU;
    private TbImageView gHW;
    private g.f gHX;
    private ImageView gHZ;
    private TextView gIa;
    private View gIe;
    private View gIf;
    private TextView gIg;
    private SeekBar gIh;
    private ImageView gIi;
    private ImageView gIj;
    private int gIk;
    private int gIp;
    private p hEI;
    private i hEU;
    private l hVA;
    private f hVB;
    private g hVC;
    private TextView hVH;
    private boolean hVJ;
    private boolean hVK;
    private boolean hVL;
    private int hVM;
    private boolean hVN;
    private boolean hVO;
    private ProgressBar hVf;
    private View hVg;
    private SwitchImageView hVh;
    private TextView hVi;
    private TextView hVj;
    private TextView hVk;
    private g.a hVl;
    private g.b hVm;
    private View.OnClickListener hVp;
    protected InterfaceC0368c hVq;
    private d hVr;
    private o hVt;
    private h hVu;
    private j hVv;
    private k hVw;
    private m hVx;
    private a hVy;
    private n hVz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int UH = 100;
    private boolean hVe = false;
    protected boolean UT = false;
    private boolean UG = false;
    private boolean hVn = false;
    private boolean hVo = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIl = 0;
    private int gIm = 0;
    private long hVs = 60000;
    private int gIo = 0;
    private boolean gIs = false;
    private boolean hVD = true;
    private boolean hVE = true;
    private boolean hVF = false;
    private boolean hVG = false;
    private String hEu = null;
    private int currentState = -1;
    private boolean hVI = false;
    private boolean hVP = false;
    private boolean hVQ = false;
    private g.f cJI = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.ehx = gVar;
            c.this.ehz.bEy();
            if (c.this.gHL != null && c.this.ehx != null && c.this.ehx.getDuration() > 0) {
                c.this.gHL.ax(0, c.this.ehx.getDuration());
            }
            c.this.aQl();
        }
    };
    private g.e cJK = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.qB();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a ehJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aQl();
        }
    };
    private Runnable UM = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UM);
            if (c.this.gHW.getVisibility() != 8) {
                if (c.this.dbf.getCurrentPosition() > c.this.UH) {
                    c.this.qB();
                } else {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UM, 20L);
                }
            }
        }
    };
    private g.a cJH = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dbf != null) {
                int duration = c.this.dbf.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.UG = false;
                    c.this.hVL = false;
                    c.this.mStartPosition = 0;
                    c.this.bAu();
                    c.this.gHM.setVisibility(0);
                    c.this.hVf.setProgress(c.this.hVf.getMax());
                    c.this.UH = 100;
                    if (c.this.hVl != null) {
                        c.this.hVl.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dbf.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.oU(false);
                        c.this.oV(true);
                    } else {
                        c.this.bSR();
                        c.this.hVi.setVisibility(0);
                    }
                    if (!c.this.UT && duration <= 150000) {
                        if (!c.this.hVI) {
                            if (c.this.hVv != null) {
                                c.this.hVv.oq(true);
                            }
                            c.this.cf(c.this.bNn, c.this.ctw);
                        } else {
                            c.this.currentState = 5;
                            c.this.dbf.setRecoveryState(5);
                            c.this.dbf.getPlayer().pause();
                            c.this.dbf.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.hVt != null) {
                        c.this.hVt.lU(c.this.hVf.getMax());
                        c.this.hVt.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gIu = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.ekr.setVisibility(0);
            c.this.cAj.bTN();
            c.this.currentState = 4;
            c.this.dbf.setRecoveryState(4);
            if (c.this.hVm != null) {
                c.this.hVm.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kY()) {
                c.this.hVJ = true;
            }
            if (c.this.hVt != null) {
                c.this.hVt.azE();
            }
            c.this.hVL = false;
            return true;
        }
    };
    protected Runnable gIv = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbf == null || !c.this.dbf.isPlaying()) {
                c.this.ekr.setVisibility(0);
                c.this.cAj.bTN();
                if (c.this.hVt != null) {
                    c.this.hVt.azE();
                }
            }
        }
    };
    private g.InterfaceC0369g cJL = new g.InterfaceC0369g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0369g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.hVF) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hVR, 200L);
            }
        }
    };
    private Runnable hVR = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbf == null || !c.this.hVF) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UM, 200L);
                c.this.hVF = false;
            } else if (c.this.mStartPosition != c.this.dbf.getCurrentPosition()) {
                c.this.hVF = false;
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UM, 20L);
            } else {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hVR, 200L);
            }
        }
    };
    private QuickVideoView.b cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UG = false;
            if (c.this.hVo) {
                com.baidu.adp.lib.g.e.jH().postDelayed(c.this.hVS, 300L);
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UM);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIv);
        }
    };
    private Runnable hVS = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.hVL = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hEI != null) {
                c.this.hEI.bPm();
            }
            if (view.getId() != c.this.ekr.getId()) {
                if (view.getId() != c.this.hVh.getId()) {
                    if (view.getId() == c.this.hVj.getId()) {
                        if (c.this.hVu != null) {
                            c.this.hVu.bPn();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.hVi.getId()) {
                        if (c.this.hVv != null) {
                            c.this.hVv.oq(false);
                        }
                        c.this.cf(c.this.bNn, c.this.ctw);
                        return;
                    } else if (view.getId() == c.this.gHR.getId()) {
                        int i2 = c.this.hVo ? 1 : 2;
                        if (c.this.UT) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctw).bJ(ImageViewerConfig.FORUM_ID, c.this.ekM).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bJ("tid", c.this.ctw).bJ(ImageViewerConfig.FORUM_ID, c.this.ekM).T("obj_type", i2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.hVA != null) {
                            c.this.hVA.beO();
                        }
                        if (c.this.bSC()) {
                            if (c.this.UT) {
                                c.this.bSF();
                            } else {
                                c.this.bSE();
                            }
                            c.this.oR(c.this.UT);
                            return;
                        }
                        c.this.bAy();
                        return;
                    } else if (view.getId() != c.this.gHZ.getId()) {
                        if (c.this.hVp != null) {
                            c.this.hVp.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.hVA != null) {
                            c.this.hVA.beO();
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
                if (c.this.hVy != null) {
                    c.this.hVy.jV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dbf.stopPlayback();
            c.this.UG = false;
            c.this.bSK();
        }
    };
    private Animation.AnimationListener gIx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gIy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gIz = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bAJ();
        }
    };
    private CustomMessageListener gIA = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b gKv = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void ly(int i2) {
            int duration;
            if (c.this.dbf != null && (duration = c.this.dbf.getDuration()) > 0 && c.this.hVf != null) {
                c.this.hVf.setProgress((int) ((i2 * c.this.gHJ.getWidth()) / duration));
                if (c.this.hVt != null) {
                    c.this.hVt.lU((c.this.dbf.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cNU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bSP();
            c.this.oV(false);
            if (c.this.hVy != null) {
                c.this.hVy.jV(false);
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
                    if (c.this.hEU != null) {
                        c.this.hEU.beQ();
                    }
                }
            }
            c.this.oV(true);
            c.this.bSO();
            if (c.this.hVy != null) {
                c.this.hVy.jV(true);
            }
            if (c.this.hVz != null) {
                c.this.hVz.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a hVT = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bSW() {
            if (!c.this.hVI) {
                c.this.cAj.startLoading();
                c.this.gHW.setVisibility(0);
                c.this.hVh.setVisibility(8);
                c.this.hVj.setVisibility(8);
                c.this.hVi.setVisibility(8);
                c.this.hVk.setVisibility(8);
                c.this.ekr.setVisibility(8);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIv);
                if (c.this.hVs > 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(c.this.gIv, c.this.hVs);
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
        this.hVN = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.hVN = z;
            this.gHU = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.hVN = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.hVN = z;
            this.gHU = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gHJ = am(this.mActivity);
        this.gHJ.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gHJ);
        }
        this.dbf = (QuickVideoView) this.gHJ.findViewById(d.g.videoView);
        this.cAj = new x((ViewGroup) this.gHJ.findViewById(d.g.auto_video_loading_container));
        this.cAj.setLoadingAnimationListener(this.ehJ);
        this.gHL = (VideoListMediaControllerView) this.gHJ.findViewById(d.g.media_controller);
        this.gHL.setPlayer(this.dbf);
        this.hVf = (ProgressBar) this.gHJ.findViewById(d.g.pgrBottomProgress);
        this.hVf.setMax(com.baidu.adp.lib.util.l.aO(this.mActivity));
        this.hVf.setProgress(0);
        this.gHL.setOnSeekBarChangeListener(this.cNU);
        this.gHL.setOnProgressUpdatedListener(this.gKv);
        this.gHM = this.gHJ.findViewById(d.g.black_mask);
        this.ekr = this.gHJ.findViewById(d.g.layout_error);
        this.ekr.setOnClickListener(this.mOnClickListener);
        this.hVH = (TextView) this.gHJ.findViewById(d.g.auto_video_error_tips);
        this.gHN = (FrameLayout) this.gHJ.findViewById(d.g.danmu_container);
        this.gHR = (ImageView) this.gHJ.findViewById(d.g.img_full_screen);
        this.gHR.setOnClickListener(this.mOnClickListener);
        this.gHS = this.gHJ.findViewById(d.g.layout_media_controller);
        this.hVg = this.gHJ.findViewById(d.g.time_show_controller);
        this.dbf.setPlayerReuseEnable(true);
        this.dbf.setContinuePlayEnable(true);
        this.dbf.setOnPreparedListener(this.cJI);
        this.dbf.setOnCompletionListener(this.cJH);
        this.dbf.setOnErrorListener(this.gIu);
        this.dbf.setOnSeekCompleteListener(this.cJL);
        this.dbf.setOnSurfaceDestroyedListener(this.cAs);
        this.dbf.setOnRecoveryCallback(this.hVT);
        this.dbf.setOnOutInfoListener(this.cJK);
        this.hVh = (SwitchImageView) this.gHJ.findViewById(d.g.img_play_controller);
        this.hVh.setStateImage(d.f.btn_card_play_video_n, d.f.btn_card_stop_video_n);
        this.hVh.setState(0);
        this.hVh.setOnClickListener(this.mOnClickListener);
        this.hVi = (TextView) this.gHJ.findViewById(d.g.txt_replay);
        this.hVi.setOnClickListener(this.mOnClickListener);
        this.hVj = (TextView) this.gHJ.findViewById(d.g.txt_playnext);
        this.hVj.setOnClickListener(this.mOnClickListener);
        this.hVk = (TextView) this.gHJ.findViewById(d.g.txt_next_video_title);
        this.gHW = (TbImageView) this.gHJ.findViewById(d.g.video_thumbnail);
        this.gHW.setDefaultErrorResource(0);
        this.gHW.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gHZ = (ImageView) this.gHJ.findViewById(d.g.img_exit);
        this.gHZ.setOnClickListener(this.mOnClickListener);
        this.gIa = (TextView) this.gHJ.findViewById(d.g.video_title);
        this.ekm = this.gHJ.findViewById(d.g.layout_title);
        this.ekm.setVisibility(8);
        this.fel = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afd = AnimationUtils.loadAnimation(this.mActivity, d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gIk = this.mAudioManager.getStreamMaxVolume(3);
        this.gIp = this.mAudioManager.getStreamVolume(3);
        gIq = 100 / this.gIk;
        this.gHJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.hVw != null) {
                    c.this.hVw.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.UG) {
                        if (c.this.mStatus == 1 && c.this.gIm != 0) {
                            c.this.b(c.this.gIm == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIm = 0;
                            c.this.gIl = 0;
                        }
                        if (!c.this.dbf.isPlaying()) {
                            c.this.hVj.setVisibility(8);
                            c.this.hVi.setVisibility(8);
                            c.this.hVk.setVisibility(8);
                        }
                    }
                    c.this.bAu();
                    if (c.this.hVw != null) {
                        c.this.hVw.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.cVq = new com.baidu.tieba.play.o(this.mActivity);
        if (this.hVN) {
            this.cVq.start();
        }
        this.gIo = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.ds16);
        if (gIr == null) {
            gIr = new CallStateReceiver();
        }
        gIr.register(this.mActivity);
        bSz();
        this.ehz = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gIA);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gIA);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void bSz() {
        if (this.hVD) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gHJ.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gHJ.setSystemUiVisibility(0);
    }

    public void oP(boolean z) {
        this.hVD = z;
        bSz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        this.mStatus = 0;
        if (this.gIe != null && this.gIe.getParent() != null && (this.gIe.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIe.getParent()).removeView(this.gIe);
                this.gIe = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gIf != null && this.gIf.getParent() != null && (this.gIf.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gIf.getParent()).removeView(this.gIf);
                this.gIf = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bAv() {
        if (this.mStatus == 1) {
            if (this.gIe == null && this.gHJ != null && (this.gHJ instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_jindu, (ViewGroup) this.gHJ, true);
                this.gIe = this.gHJ.findViewById(d.g.lay_jindu);
                this.gIg = (TextView) this.gIe.findViewById(d.g.show_time);
                this.gIj = (ImageView) this.gIe.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gIf == null && this.gHJ != null && (this.gHJ instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(d.h.float_video_window_voice, (ViewGroup) this.gHJ, true);
            this.gIf = this.gHJ.findViewById(d.g.lay_voice);
            this.gIi = (ImageView) this.gIf.findViewById(d.g.arrow_voice_icon);
            this.gIh = (SeekBar) this.gIf.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.hVp = onClickListener;
    }

    public void oQ(boolean z) {
        this.hVo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.hVw != null) {
                c.this.hVw.onStart();
            }
            if (c.this.UT && c.this.UG) {
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
                    if (c.this.UT) {
                        c.this.bAx();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIl = c.this.dbf.getCurrentPosition();
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
            if (!c.this.hVO) {
                if (c.this.hVx != null && c.this.hVx.bPo()) {
                    return true;
                }
                c.this.bPd();
                c.this.bST();
                if (c.this.dbf.isPlaying()) {
                    c.this.bSO();
                } else {
                    c.this.bSP();
                }
                if (c.this.hVy != null) {
                    c.this.hVy.jV(c.this.dbf.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.hVO) {
                if (c.this.UG) {
                    if (c.this.hVx != null && c.this.hVx.bPp()) {
                        return true;
                    }
                    c.this.bSN();
                    if (c.this.dbf.isPlaying()) {
                        c.this.bSO();
                    } else {
                        c.this.bSP();
                    }
                    if (c.this.hVy != null) {
                        c.this.hVy.jV(c.this.dbf.isPlaying());
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
                    if (c.this.hVy != null) {
                        c.this.hVy.jV(c.this.currentState == 1);
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
            this.gHJ.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gHJ.setSystemUiVisibility(4);
        } else {
            this.gHJ.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f2) {
        if (!this.UG) {
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
        if (this.mProgress % gIq == 0) {
            if (f2 > 0.0f && this.gIp < this.gIk) {
                this.gIp++;
            }
            if (f2 < 0.0f && this.gIp > 0) {
                this.gIp--;
            }
        }
        if (this.mProgress > 0) {
            this.gIi.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.gIi.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gIp, 0);
        this.gIh.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gIl += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gIm = 1;
            } else {
                this.gIl += 1000;
                this.gIm = 2;
            }
            if (this.gIl < 0) {
                this.gIl = 0;
            } else if (this.gIl > this.dbf.getDuration()) {
                this.gIl = this.dbf.getDuration();
            }
        }
        bAv();
        String xn = this.gHL.xn(this.gIl);
        if (f2 > 0.0f) {
            this.gIj.setImageResource(d.f.icon_kuaitui);
        } else {
            this.gIj.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(xn)) {
            this.gIg.setText(new StringBuilder().append(xn).append("/").append(this.gHL.xn(this.dbf.getDuration())));
        }
        this.gHL.setCurrentDuration(this.gIl, z ? false : true);
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
        this.bNn = str;
        this.ctw = str2;
    }

    public void bSA() {
        if (this.dbf != null) {
            this.dbf.bSA();
        }
    }

    public void setFid(String str) {
        this.ekM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        int i2 = 100;
        if (this.dbf != null && this.ehx != null && this.gHL != null) {
            this.gHL.showProgress();
            this.mStartPosition = y.bTR().AS(this.bNn);
            if (this.hVL) {
                this.ehx.setVolume(1.0f, 1.0f);
                this.dbf.start();
                this.hVL = false;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UM);
                com.baidu.adp.lib.g.e.jH().postDelayed(this.UM, 20L);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIv);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVS);
                if (this.dbf.bTn()) {
                    this.currentState = 1;
                    this.dbf.setRecoveryState(1);
                    bSR();
                }
                this.mStartPosition = y.bTR().AS(this.bNn);
                this.gHL.setPlayer(this.dbf);
                if (this.mStartPosition != 0 && !this.ehx.isPlayerReuse()) {
                    this.hVF = true;
                }
                if (!this.hVK) {
                    this.gHL.showProgress();
                }
                if (!this.hVo && this.ehx.getDuration() <= 0) {
                    bAz().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.ehx.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.UH = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB() {
        if (this.gHW.getVisibility() != 8) {
            this.UG = true;
            this.gHM.setVisibility(8);
            this.ekr.setVisibility(8);
            this.cAj.bTM();
            this.gHW.setVisibility(8);
            bSS();
            if (bSU()) {
                this.ehz.a(this.ctw, -1L, this.dbf.getDuration() / 1000, "middle", this.dbf);
            }
            this.gHL.showProgress();
            this.hVf.setVisibility(0);
            if (this.gHX != null) {
                this.gHX.onPrepared(this.dbf.getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.hVg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hVg.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.hVg.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.hVg.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.hVg.setLayoutParams(layoutParams);
        }
    }

    public void bPd() {
        if (this.dbf.isPlaying()) {
            pausePlay();
            if (this.hVC != null) {
                this.hVC.onPause();
            }
            if (this.hVt != null) {
                this.hVt.onPaused();
            }
        } else if (this.UG) {
            bAH();
            if (this.hEU != null) {
                this.hEU.beQ();
            }
            if (this.hVt != null) {
                this.hVt.azF();
            }
        } else {
            bSK();
        }
    }

    public boolean bSB() {
        return this.gIs;
    }

    public void bAy() {
        this.gIs = true;
        if (this.cVq != null) {
            this.cVq.bAy();
        }
    }

    public boolean bSC() {
        return this.ehx != null && this.ehx.getVideoHeight() > this.ehx.getVideoWidth();
    }

    public void bSD() {
        oR(false);
        bSF();
    }

    public boolean xh(int i2) {
        switch (i2) {
            case 4:
                if (this.UT) {
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
                if (this.mAudioManager == null || this.gIk <= 0 || this.gIh == null) {
                    return false;
                }
                this.gIp = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gIp * 100.0d) / this.gIk);
                this.gIh.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dbf;
    }

    public VideoListMediaControllerView bAz() {
        return this.gHL;
    }

    public void show() {
        this.gHJ.setVisibility(0);
    }

    public void bAD() {
        if (this.gHU != null) {
            ViewGroup.LayoutParams layoutParams = this.gHU.getLayoutParams();
            this.gHO = (FrameLayout.LayoutParams) this.gHJ.getLayoutParams();
            this.gHO.width = layoutParams.width;
            this.gHO.height = layoutParams.height;
            this.gHO.topMargin = 0;
            this.gHJ.setLayoutParams(this.gHO);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gIs) {
            if (this.UT) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gIs = false;
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
        if (this.hVy != null) {
            this.hVy.jV(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSE() {
        this.UT = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (bSC()) {
            this.gHJ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gHJ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.ekm.setVisibility(0);
        this.gHZ.setVisibility(0);
        this.gIa.setVisibility(0);
        this.gHN.setVisibility(8);
        this.cAj.bTN();
        this.gHW.setVisibility(8);
        this.gHR.setImageResource(d.f.icon_video_narrow_white);
        uR(this.gIo);
        bAx();
        if (this.hVq != null) {
            this.hVq.qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSF() {
        this.UT = false;
        if (this.gHO != null) {
            this.gHJ.setLayoutParams(this.gHO);
        }
        g(this.mActivity, false);
        this.ekm.setVisibility(8);
        this.gHN.setVisibility(0);
        this.cAj.bTN();
        this.gHW.setVisibility(8);
        this.gHR.setImageResource(d.f.icon_video_enlarge_white);
        if (this.gHL != null && (this.gHL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHL.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.gHL.setLayoutParams(layoutParams);
        }
        this.gHJ.setSystemUiVisibility(0);
        bSz();
        if (this.hVq != null) {
            this.hVq.qk();
        }
    }

    public void bSG() {
        if (this.dbf != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mActivity);
            if (this.UT) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mActivity);
            }
            this.hVf.setMax(aO);
            int duration = this.dbf.getDuration();
            if (duration > 0) {
                if (this.hVi.getVisibility() == 0) {
                    this.hVf.setProgress(this.hVf.getMax());
                } else {
                    this.hVf.setProgress((int) ((this.dbf.getCurrentPosition() * this.hVf.getMax()) / duration));
                }
            }
        }
    }

    private void uR(int i2) {
        if (this.gHL != null && (this.gHL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHL.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gHL.setLayoutParams(layoutParams);
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
        return !this.UT;
    }

    public void a(g.f fVar) {
        this.gHX = fVar;
    }

    public void a(g.a aVar) {
        this.hVl = aVar;
    }

    public void a(g.b bVar) {
        this.hVm = bVar;
    }

    public void h(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dbf != null) {
            this.dbf.setPbLoadingTime(currentTimeMillis);
        }
        cf(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.hVG) {
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
        this.hVL = true;
        this.currentState = 0;
        this.dbf.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dbf.setVideoPath(str, str2);
        this.ehz.bEx();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIv);
        if (this.hVs > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIv, this.hVs);
        }
        if (this.hVt != null) {
            this.hVt.onStarted();
        }
        this.cAj.startLoading();
        oS(true);
    }

    public void dE(String str, String str2) {
        bSL();
        this.hVL = true;
        this.currentState = 0;
        this.dbf.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIv);
        if (this.hVs > 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIv, this.hVs);
        }
        if (this.hVt != null) {
            this.hVt.onStarted();
        }
        this.cAj.startLoading();
        oS(true);
    }

    public void bSH() {
        bAH();
        this.hVf.setVisibility(0);
    }

    public void bAH() {
        int i2 = 100;
        if (this.dbf != null && this.gHL != null) {
            this.UG = true;
            this.currentState = 1;
            this.dbf.setRecoveryState(1);
            this.dbf.start();
            if (this.ehx != null && this.gHL != null) {
                this.mStartPosition = y.bTR().AS(this.bNn);
                if (this.mStartPosition != 0 && !this.ehx.isPlayerReuse()) {
                    this.hVF = true;
                }
                if (this.mStartPosition > 100 && this.ehx.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.UH = i2;
            } else {
                this.UH = 100;
            }
            this.cAj.bTN();
            oS(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kY() && this.hVJ && !StringUtils.isNull(this.bNn) && !StringUtils.isNull(this.ctw)) {
            this.hVJ = false;
            this.hVK = true;
            cf(this.bNn, this.ctw);
        }
    }

    private void oS(boolean z) {
        if (z) {
            this.gHW.setVisibility(0);
            bSR();
            this.hVf.setProgress(0);
        } else {
            this.gHW.setVisibility(8);
        }
        this.gHL.showProgress();
        this.gHM.setVisibility(8);
        this.hVj.setVisibility(8);
        this.hVi.setVisibility(8);
        this.hVk.setVisibility(8);
        this.ekr.setVisibility(8);
    }

    private void bSI() {
        this.cAj.bTN();
        this.hVj.setVisibility(8);
        this.hVi.setVisibility(8);
        this.hVk.setVisibility(8);
        bST();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dbf != null) {
            this.dbf.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dbf.pause();
        this.currentState = 2;
        this.dbf.setRecoveryState(2);
        bSI();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dbf.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIv);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVS);
        this.dbf.stopPlayback();
        this.UG = false;
        this.hVL = false;
        this.mStartPosition = 0;
        bnN();
    }

    public void bSJ() {
        if (this.dbf.getDuration() >= this.dbf.getCurrentPosition()) {
            y.bTR().bj(this.bNn, this.dbf.getCurrentPosition());
        }
    }

    public void oT(boolean z) {
        this.hVE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oU(boolean z) {
        if (this.gHS != null) {
            this.gHM.setVisibility(0);
            this.hVj.setVisibility(8);
            this.hVi.setVisibility(8);
            this.hVk.setVisibility(8);
            this.cAj.bTN();
            bSR();
            this.hVf.setVisibility(8);
            this.ekr.setVisibility(8);
            this.gHL.awG();
            this.gHW.setVisibility(z ? 0 : 8);
        }
    }

    public void bnN() {
        oU(true);
    }

    public boolean ql() {
        if (this.dbf == null) {
            return false;
        }
        return this.dbf.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dbf == null) {
            return 0;
        }
        return this.dbf.getCurrentPosition();
    }

    public void a(k kVar) {
        this.hVw = kVar;
    }

    public void a(j jVar) {
        this.hVv = jVar;
    }

    public void a(i iVar) {
        this.hEU = iVar;
    }

    public void a(g gVar) {
        this.hVC = gVar;
    }

    public void a(h hVar) {
        this.hVu = hVar;
    }

    public void Aq(String str) {
        this.hEu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        a(this.bNn, this.ctw, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.hVr = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bSL();
        if (com.baidu.adp.lib.util.j.la() && !com.baidu.tieba.video.g.ciN().ciO()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.hVG = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.hVB != null) {
                    this.hVB.jx(false);
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
            } else if (this.hVB != null) {
                this.hVB.jx(true);
                return;
            } else {
                if (!this.hVe) {
                    this.hVe = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, d.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.hVA != null) {
            this.hVA.beN();
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
        this.gHW.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIz);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIv);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVR);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hVS);
        this.cVq.stop();
        gIr.unregister(this.mActivity);
    }

    public void AN(String str) {
        this.gIa.setText(str);
    }

    public boolean bAI() {
        return this.UG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSN() {
        if (this.gHS != null) {
            if (this.hVn) {
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIz);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gIz, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSP() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIz);
    }

    public void bSQ() {
        if (this.gHS != null && !this.hVn && !this.hVP) {
            oV(true);
            bAL();
            this.gHS.setVisibility(0);
            this.hVg.setVisibility(0);
            this.hVf.setVisibility(8);
            this.hVn = true;
            if (this.hVr != null) {
                this.hVr.jy(false);
            }
        }
    }

    public void bAJ() {
        if (this.gHS != null && this.hVn) {
            oV(false);
            bAL();
            this.gHS.setVisibility(8);
            this.hVg.setVisibility(8);
            this.hVf.setVisibility(0);
            this.fel.setAnimationListener(this.gIx);
            this.gHS.startAnimation(this.fel);
            this.hVn = false;
            if (this.hVr != null) {
                this.hVr.beP();
            }
        }
    }

    public void bSR() {
        if (this.gHS != null && this.hVn) {
            this.afd.cancel();
            this.fel.cancel();
            oV(false);
            bAL();
            this.gHS.setVisibility(8);
            this.hVg.setVisibility(8);
            this.hVf.setVisibility(0);
            this.hVn = false;
            if (this.hVr != null) {
                this.hVr.beP();
            }
        }
    }

    private void bAL() {
        if (this.gHS != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIz);
            this.afd.setAnimationListener(null);
            this.fel.setAnimationListener(null);
            this.gHS.clearAnimation();
        }
    }

    private void bSS() {
        if (this.gHS != null) {
            this.afd.setAnimationListener(null);
            this.fel.setAnimationListener(null);
            this.gHS.clearAnimation();
        }
    }

    public void oV(boolean z) {
        bST();
        if (z) {
            this.hVh.setVisibility(0);
        } else {
            this.hVh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bST() {
        if (this.currentState == 1) {
            this.hVh.setState(1);
        } else {
            this.hVh.setState(0);
        }
    }

    public void a(InterfaceC0368c interfaceC0368c) {
        this.hVq = interfaceC0368c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ac(boolean z, boolean z2) {
        if (this.cVq != null) {
            if (this.gHR != null) {
                this.gHR.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gHL != null && (this.gHL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHL.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mActivity, d.e.tbds52);
                this.gHL.setLayoutParams(layoutParams);
            }
            this.cVq.pc(z);
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
        this.hVO = z;
    }

    public void a(m mVar) {
        this.hVx = mVar;
    }

    public void a(a aVar) {
        this.hVy = aVar;
    }

    public void a(n nVar) {
        this.hVz = nVar;
    }

    public void a(l lVar) {
        this.hVA = lVar;
    }

    public void a(f fVar) {
        this.hVB = fVar;
    }

    public void oX(boolean z) {
        this.hVI = z;
    }

    public boolean bSU() {
        return this.hVo;
    }

    public void oY(boolean z) {
        this.hVo = z;
    }

    public void xi(int i2) {
        this.hVM = i2;
    }

    public View bSV() {
        return this.gHJ;
    }

    public void a(o oVar) {
        this.hVt = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dbf != null) {
            this.dbf.setFullScreenToDestroySurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVolume(int i2) {
        this.gIp = i2;
        this.mAudioManager.setStreamVolume(3, i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oZ(boolean z) {
        this.hVP = z;
        if (z) {
            bSR();
        } else {
            bAM();
        }
    }

    public void a(p pVar) {
        this.hEI = pVar;
    }
}
