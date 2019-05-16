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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int gZL;
    private static CallStateReceiver gZM;
    private Animation afk;
    private String bUZ;
    private String bVL;
    private x cIs;
    private com.baidu.tieba.play.o ddN;
    public com.baidu.tieba.play.g deB;
    protected QuickVideoView dlL;
    private String eAB;
    private View eAb;
    protected View eAg;
    private com.baidu.tieba.j.k exm;
    private Animation fuz;
    private View gZA;
    private TextView gZB;
    private SeekBar gZC;
    private ImageView gZD;
    private ImageView gZE;
    private int gZF;
    private int gZK;
    public View gZe;
    private VideoListMediaControllerView gZg;
    private View gZh;
    private FrameLayout gZi;
    protected FrameLayout.LayoutParams gZj;
    private ImageView gZm;
    private View gZn;
    private View gZp;
    private TbImageView gZr;
    private g.f gZs;
    private ImageView gZu;
    private TextView gZv;
    private View gZz;
    private p hWJ;
    private i hWV;
    private ProgressBar inS;
    private View inT;
    private SwitchImageView inU;
    private TextView inV;
    private TextView inW;
    private TextView inX;
    private g.a inY;
    private g.b inZ;
    private boolean ioA;
    private boolean ioB;
    private View.OnClickListener ioc;
    protected InterfaceC0387c iod;
    private d ioe;
    private o iog;
    private h ioh;
    private j ioi;
    private k ioj;
    private m iok;
    private a iol;
    private n iom;
    private l ion;
    private f ioo;
    private g iop;
    private TextView iou;
    private boolean iow;
    private boolean iox;
    private boolean ioy;
    private int ioz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int St = 100;
    private boolean inR = false;
    protected boolean SE = false;
    private boolean Ss = false;
    private boolean ioa = false;
    private boolean iob = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gZG = 0;
    private int gZH = 0;
    private long iof = 60000;
    private int gZJ = 0;
    private boolean gZN = false;
    private boolean ioq = true;
    private boolean ior = true;
    private boolean ios = false;
    private boolean iot = false;
    private String hWv = null;
    private int currentState = -1;
    private boolean iov = false;
    private boolean ioC = false;
    private boolean ioD = false;
    private g.f cRS = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.deB = gVar;
            c.this.exm.bMj();
            if (c.this.gZg != null && c.this.deB != null && c.this.deB.getDuration() > 0) {
                c.this.gZg.ax(0, c.this.deB.getDuration());
            }
            c.this.aXu();
            if (c.this.iog != null) {
                c.this.iog.onPrepared();
            }
        }
    };
    private g.e cRU = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.pw();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a exx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aXu();
        }
    };
    private Runnable Sy = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.Sy);
            if (c.this.gZr.getVisibility() != 8) {
                if (c.this.dlL.getCurrentPosition() > c.this.St) {
                    c.this.pw();
                } else {
                    com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sy, 20L);
                }
            }
        }
    };
    private g.a cRR = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dlL != null) {
                int duration = c.this.dlL.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.Ss = false;
                    c.this.ioy = false;
                    c.this.mStartPosition = 0;
                    c.this.bIe();
                    c.this.gZh.setVisibility(0);
                    c.this.inS.setProgress(c.this.inS.getMax());
                    c.this.St = 100;
                    if (c.this.inY != null) {
                        c.this.inY.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dlL.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.pJ(false);
                        c.this.pK(true);
                    } else {
                        c.this.caR();
                        c.this.inV.setVisibility(0);
                    }
                    if (!c.this.SE && duration <= 150000) {
                        if (!c.this.iov) {
                            if (c.this.ioi != null) {
                                c.this.ioi.pf(true);
                            }
                            c.this.cr(c.this.bUZ, c.this.bVL);
                        } else {
                            c.this.currentState = 5;
                            c.this.dlL.setRecoveryState(5);
                            c.this.dlL.getPlayer().pause();
                            c.this.dlL.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.iog != null) {
                        c.this.iog.mG(c.this.inS.getMax());
                        c.this.iog.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gZP = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.eAg.setVisibility(0);
            c.this.cIs.cbO();
            c.this.currentState = 4;
            c.this.dlL.setRecoveryState(4);
            if (c.this.inZ != null) {
                c.this.inZ.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jS()) {
                c.this.iow = true;
            }
            if (c.this.iog != null) {
                c.this.iog.aFj();
            }
            c.this.ioy = false;
            return true;
        }
    };
    protected Runnable gZQ = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dlL == null || !c.this.dlL.isPlaying()) {
                c.this.eAg.setVisibility(0);
                c.this.cIs.cbO();
                if (c.this.iog != null) {
                    c.this.iog.aFj();
                }
            }
        }
    };
    private g.InterfaceC0388g cRV = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0388g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.ios) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioE, 200L);
            }
        }
    };
    private Runnable ioE = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dlL == null || !c.this.ios) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sy, 200L);
                c.this.ios = false;
            } else if (c.this.mStartPosition != c.this.dlL.getCurrentPosition()) {
                c.this.ios = false;
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sy, 20L);
            } else {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioE, 200L);
            }
        }
    };
    private QuickVideoView.b cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.Ss = false;
            if (c.this.iob) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioF, 300L);
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.Sy);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.gZQ);
        }
    };
    private Runnable ioF = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.ioy = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hWJ != null) {
                c.this.hWJ.bXf();
            }
            if (view.getId() != c.this.eAg.getId()) {
                if (view.getId() != c.this.inU.getId()) {
                    if (view.getId() == c.this.inW.getId()) {
                        if (c.this.ioh != null) {
                            c.this.ioh.bXg();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.inV.getId()) {
                        if (c.this.ioi != null) {
                            c.this.ioi.pf(false);
                        }
                        c.this.cr(c.this.bUZ, c.this.bVL);
                        return;
                    } else if (view.getId() == c.this.gZm.getId()) {
                        int i2 = c.this.iob ? 1 : 2;
                        if (c.this.SE) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bT("tid", c.this.bVL).bT("fid", c.this.eAB).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bT("tid", c.this.bVL).bT("fid", c.this.eAB).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.ion != null) {
                            c.this.ion.bmg();
                        }
                        if (c.this.caC()) {
                            if (c.this.SE) {
                                c.this.caF();
                            } else {
                                c.this.caE();
                            }
                            c.this.pG(c.this.SE);
                            return;
                        }
                        c.this.bIi();
                        return;
                    } else if (view.getId() != c.this.gZu.getId()) {
                        if (c.this.ioc != null) {
                            c.this.ioc.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.ion != null) {
                            c.this.ion.bmg();
                        }
                        if (c.this.caC()) {
                            c.this.caF();
                            c.this.pG(false);
                            return;
                        }
                        c.this.bIi();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bWW();
                c.this.caT();
                if (c.this.currentState != 1) {
                    c.this.caP();
                    c.this.caQ();
                } else {
                    c.this.bIw();
                }
                if (c.this.iol != null) {
                    c.this.iol.kK(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dlL.stopPlayback();
            c.this.Ss = false;
            c.this.caK();
        }
    };
    private Animation.AnimationListener gZS = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gZT = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gZU = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bIt();
        }
    };
    private CustomMessageListener gZV = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b hbQ = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void mn(int i2) {
            int duration;
            if (c.this.dlL != null && (duration = c.this.dlL.getDuration()) > 0 && c.this.inS != null) {
                c.this.inS.setProgress((int) ((i2 * c.this.gZe.getWidth()) / duration));
                if (c.this.iog != null) {
                    c.this.iog.mG((c.this.dlL.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cWg = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.caP();
            c.this.pK(false);
            if (c.this.iol != null) {
                c.this.iol.kK(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bIj() != null) {
                c.this.setStartPosition(c.this.bIj().getSeekPosition());
                if (!c.this.bIs()) {
                    c.this.caK();
                } else {
                    c.this.bIr();
                    if (c.this.hWV != null) {
                        c.this.hWV.bmi();
                    }
                }
            }
            c.this.pK(true);
            c.this.caO();
            if (c.this.iol != null) {
                c.this.iol.kK(true);
            }
            if (c.this.iom != null) {
                c.this.iom.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a ioG = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void caX() {
            if (!c.this.iov) {
                c.this.cIs.startLoading();
                c.this.gZr.setVisibility(0);
                c.this.inU.setVisibility(8);
                c.this.inW.setVisibility(8);
                c.this.inV.setVisibility(8);
                c.this.inX.setVisibility(8);
                c.this.eAg.setVisibility(8);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.gZQ);
                if (c.this.iof > 0) {
                    com.baidu.adp.lib.g.e.iB().postDelayed(c.this.gZQ, c.this.iof);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kK(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0387c {
        void pe();

        void pf();
    }

    /* loaded from: classes.dex */
    public interface d {
        void bmh();

        void ki(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void pO(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void kh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void bXg();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bmi();
    }

    /* loaded from: classes.dex */
    public interface j {
        void pf(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bmf();

        void bmg();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bXh();

        boolean bXi();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aFj();

        void aFk();

        void mG(int i);

        void onPaused();

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bXf();
    }

    public c(Activity activity, View view, boolean z) {
        this.ioA = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.ioA = z;
            this.gZp = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.ioA = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.ioA = z;
            this.gZp = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gZe = ap(this.mActivity);
        this.gZe.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gZe);
        }
        this.dlL = (QuickVideoView) this.gZe.findViewById(R.id.videoView);
        this.cIs = new x((ViewGroup) this.gZe.findViewById(R.id.auto_video_loading_container));
        this.cIs.setLoadingAnimationListener(this.exx);
        this.gZg = (VideoListMediaControllerView) this.gZe.findViewById(R.id.media_controller);
        this.gZg.setPlayer(this.dlL);
        this.inS = (ProgressBar) this.gZe.findViewById(R.id.pgrBottomProgress);
        this.inS.setMax(com.baidu.adp.lib.util.l.af(this.mActivity));
        this.inS.setProgress(0);
        this.gZg.setOnSeekBarChangeListener(this.cWg);
        this.gZg.setOnProgressUpdatedListener(this.hbQ);
        this.gZh = this.gZe.findViewById(R.id.black_mask);
        this.eAg = this.gZe.findViewById(R.id.layout_error);
        this.eAg.setOnClickListener(this.mOnClickListener);
        this.iou = (TextView) this.gZe.findViewById(R.id.auto_video_error_tips);
        this.gZi = (FrameLayout) this.gZe.findViewById(R.id.danmu_container);
        this.gZm = (ImageView) this.gZe.findViewById(R.id.img_full_screen);
        this.gZm.setOnClickListener(this.mOnClickListener);
        this.gZn = this.gZe.findViewById(R.id.layout_media_controller);
        this.inT = this.gZe.findViewById(R.id.time_show_controller);
        this.dlL.setPlayerReuseEnable(true);
        this.dlL.setContinuePlayEnable(true);
        this.dlL.setOnPreparedListener(this.cRS);
        this.dlL.setOnCompletionListener(this.cRR);
        this.dlL.setOnErrorListener(this.gZP);
        this.dlL.setOnSeekCompleteListener(this.cRV);
        this.dlL.setOnSurfaceDestroyedListener(this.cIB);
        this.dlL.setOnRecoveryCallback(this.ioG);
        this.dlL.setOnOutInfoListener(this.cRU);
        this.inU = (SwitchImageView) this.gZe.findViewById(R.id.img_play_controller);
        this.inU.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.inU.setState(0);
        this.inU.setOnClickListener(this.mOnClickListener);
        this.inV = (TextView) this.gZe.findViewById(R.id.txt_replay);
        this.inV.setOnClickListener(this.mOnClickListener);
        this.inW = (TextView) this.gZe.findViewById(R.id.txt_playnext);
        this.inW.setOnClickListener(this.mOnClickListener);
        this.inX = (TextView) this.gZe.findViewById(R.id.txt_next_video_title);
        this.gZr = (TbImageView) this.gZe.findViewById(R.id.video_thumbnail);
        this.gZr.setDefaultErrorResource(0);
        this.gZr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gZu = (ImageView) this.gZe.findViewById(R.id.img_exit);
        this.gZu.setOnClickListener(this.mOnClickListener);
        this.gZv = (TextView) this.gZe.findViewById(R.id.video_title);
        this.eAb = this.gZe.findViewById(R.id.layout_title);
        this.eAb.setVisibility(8);
        this.fuz = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afk = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gZF = this.mAudioManager.getStreamMaxVolume(3);
        this.gZK = this.mAudioManager.getStreamVolume(3);
        gZL = 100 / this.gZF;
        this.gZe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.ioj != null) {
                    c.this.ioj.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Ss) {
                        if (c.this.mStatus == 1 && c.this.gZH != 0) {
                            c.this.b(c.this.gZH == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gZH = 0;
                            c.this.gZG = 0;
                        }
                        if (!c.this.dlL.isPlaying()) {
                            c.this.inW.setVisibility(8);
                            c.this.inV.setVisibility(8);
                            c.this.inX.setVisibility(8);
                        }
                    }
                    c.this.bIe();
                    if (c.this.ioj != null) {
                        c.this.ioj.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.ddN = new com.baidu.tieba.play.o(this.mActivity);
        if (this.ioA) {
            this.ddN.start();
        }
        this.gZJ = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.ds16);
        if (gZM == null) {
            gZM = new CallStateReceiver();
        }
        gZM.register(this.mActivity);
        caz();
        this.exm = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gZV);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gZV);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void caz() {
        if (this.ioq) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.gZe.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gZe.setSystemUiVisibility(0);
    }

    public void pE(boolean z) {
        this.ioq = z;
        caz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIe() {
        this.mStatus = 0;
        if (this.gZz != null && this.gZz.getParent() != null && (this.gZz.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gZz.getParent()).removeView(this.gZz);
                this.gZz = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gZA != null && this.gZA.getParent() != null && (this.gZA.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gZA.getParent()).removeView(this.gZA);
                this.gZA = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bIf() {
        if (this.mStatus == 1) {
            if (this.gZz == null && this.gZe != null && (this.gZe instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.gZe, true);
                this.gZz = this.gZe.findViewById(R.id.lay_jindu);
                this.gZB = (TextView) this.gZz.findViewById(R.id.show_time);
                this.gZE = (ImageView) this.gZz.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gZA == null && this.gZe != null && (this.gZe instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.gZe, true);
            this.gZA = this.gZe.findViewById(R.id.lay_voice);
            this.gZD = (ImageView) this.gZA.findViewById(R.id.arrow_voice_icon);
            this.gZC = (SeekBar) this.gZA.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        this.ioc = onClickListener;
    }

    public void pF(boolean z) {
        this.iob = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.ioj != null) {
                c.this.ioj.onStart();
            }
            if (c.this.SE && c.this.Ss) {
                if (c.this.mStatus == 1) {
                    c.this.caR();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aL(f2);
                    }
                } else {
                    if (c.this.SE) {
                        c.this.bIh();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gZG = c.this.dlL.getCurrentPosition();
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
            if (!c.this.ioB) {
                if (c.this.iok != null && c.this.iok.bXh()) {
                    return true;
                }
                c.this.bWW();
                c.this.caT();
                if (c.this.dlL.isPlaying()) {
                    c.this.caO();
                } else {
                    c.this.caP();
                }
                if (c.this.iol != null) {
                    c.this.iol.kK(c.this.dlL.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.ioB) {
                if (c.this.Ss) {
                    if (c.this.iok != null && c.this.iok.bXi()) {
                        return true;
                    }
                    c.this.caN();
                    if (c.this.dlL.isPlaying()) {
                        c.this.caO();
                    } else {
                        c.this.caP();
                    }
                    if (c.this.iol != null) {
                        c.this.iol.kK(c.this.dlL.isPlaying());
                    }
                } else {
                    c.this.bWW();
                    c.this.caT();
                    if (c.this.currentState != 1) {
                        c.this.caP();
                        c.this.caQ();
                    } else {
                        c.this.bIw();
                    }
                    if (c.this.iol != null) {
                        c.this.iol.kK(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gZe.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gZe.setSystemUiVisibility(4);
        } else {
            this.gZe.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(float f2) {
        if (!this.Ss) {
            this.mStatus = 0;
            return;
        }
        bIf();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gZL == 0) {
            if (f2 > 0.0f && this.gZK < this.gZF) {
                this.gZK++;
            }
            if (f2 < 0.0f && this.gZK > 0) {
                this.gZK--;
            }
        }
        if (this.mProgress > 0) {
            this.gZD.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.gZD.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gZK, 0);
        this.gZC.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gZG += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gZH = 1;
            } else {
                this.gZG += 1000;
                this.gZH = 2;
            }
            if (this.gZG < 0) {
                this.gZG = 0;
            } else if (this.gZG > this.dlL.getDuration()) {
                this.gZG = this.dlL.getDuration();
            }
        }
        bIf();
        String yu = this.gZg.yu(this.gZG);
        if (f2 > 0.0f) {
            this.gZE.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.gZE.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(yu)) {
            this.gZB.setText(new StringBuilder().append(yu).append("/").append(this.gZg.yu(this.dlL.getDuration())));
        }
        this.gZg.setCurrentDuration(this.gZG, z ? false : true);
        caR();
        caG();
    }

    protected View ap(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bUZ = str;
        this.bVL = str2;
    }

    public void caA() {
        if (this.dlL != null) {
            this.dlL.caA();
        }
    }

    public void setFid(String str) {
        this.eAB = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        int i2 = 100;
        if (this.dlL != null && this.deB != null && this.gZg != null) {
            this.gZg.showProgress();
            this.mStartPosition = y.cbS().Ck(this.bUZ);
            if (this.ioy) {
                this.deB.setVolume(1.0f, 1.0f);
                this.dlL.start();
                this.ioy = false;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sy);
                com.baidu.adp.lib.g.e.iB().postDelayed(this.Sy, 20L);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZQ);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioF);
                if (this.dlL.cbo()) {
                    this.currentState = 1;
                    this.dlL.setRecoveryState(1);
                    caR();
                }
                this.mStartPosition = y.cbS().Ck(this.bUZ);
                this.gZg.setPlayer(this.dlL);
                if (this.mStartPosition != 0 && !this.deB.isPlayerReuse()) {
                    this.ios = true;
                }
                if (!this.iox) {
                    this.gZg.showProgress();
                }
                if (!this.iob && this.deB.getDuration() <= 0) {
                    bIj().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.deB.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.St = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        if (this.gZr.getVisibility() != 8) {
            this.Ss = true;
            this.gZh.setVisibility(8);
            this.eAg.setVisibility(8);
            this.cIs.cbN();
            this.gZr.setVisibility(8);
            caS();
            if (caU()) {
                this.exm.a(this.bVL, -1L, this.dlL.getDuration() / 1000, "middle", this.dlL);
            }
            this.gZg.showProgress();
            this.inS.setVisibility(0);
            if (this.gZs != null) {
                this.gZs.onPrepared(this.dlL.getPlayer());
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

    protected void pG(boolean z) {
        if (hasNavBar(this.mActivity) && (this.inT.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.inT.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.inT.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.inT.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.inT.setLayoutParams(layoutParams);
        }
    }

    public void bWW() {
        if (this.dlL.isPlaying()) {
            pausePlay();
            if (this.iop != null) {
                this.iop.onPause();
            }
            if (this.iog != null) {
                this.iog.onPaused();
            }
        } else if (this.Ss) {
            bIr();
            if (this.hWV != null) {
                this.hWV.bmi();
            }
            if (this.iog != null) {
                this.iog.aFk();
            }
        } else {
            caK();
        }
    }

    public boolean caB() {
        return this.gZN;
    }

    public void bIi() {
        this.gZN = true;
        if (this.ddN != null) {
            this.ddN.bIi();
        }
    }

    public boolean caC() {
        return this.deB != null && this.dlL.getHeight() > this.dlL.getWidth();
    }

    public void caD() {
        pG(false);
        caF();
    }

    public boolean yo(int i2) {
        switch (i2) {
            case 4:
                if (this.SE) {
                    if (caC()) {
                        pG(false);
                        caF();
                    } else {
                        bIi();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.gZF <= 0 || this.gZC == null) {
                    return false;
                }
                this.gZK = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gZK * 100.0d) / this.gZF);
                this.gZC.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dlL;
    }

    public VideoListMediaControllerView bIj() {
        return this.gZg;
    }

    public void show() {
        this.gZe.setVisibility(0);
    }

    public void bIn() {
        if (this.gZp != null) {
            ViewGroup.LayoutParams layoutParams = this.gZp.getLayoutParams();
            this.gZj = (FrameLayout.LayoutParams) this.gZe.getLayoutParams();
            this.gZj.width = layoutParams.width;
            this.gZj.height = layoutParams.height;
            this.gZj.topMargin = 0;
            this.gZe.setLayoutParams(this.gZj);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gZN) {
            if (this.SE) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gZN = false;
        }
        if (configuration.orientation == 2) {
            caE();
        } else {
            caF();
        }
        caG();
        bIr();
        caT();
        bIw();
        if (this.iol != null) {
            this.iol.kK(true);
        }
    }

    protected void caE() {
        this.SE = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (caC()) {
            this.gZe.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gZe.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.eAb.setVisibility(0);
        this.gZu.setVisibility(0);
        this.gZv.setVisibility(0);
        this.gZi.setVisibility(8);
        this.cIs.cbO();
        this.gZr.setVisibility(8);
        this.gZm.setImageResource(R.drawable.icon_video_narrow_white);
        vY(this.gZJ);
        bIh();
        if (this.iod != null) {
            this.iod.pe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caF() {
        this.SE = false;
        if (this.gZj != null) {
            this.gZe.setLayoutParams(this.gZj);
        }
        g(this.mActivity, false);
        this.eAb.setVisibility(8);
        this.gZi.setVisibility(0);
        this.cIs.cbO();
        this.gZr.setVisibility(8);
        this.gZm.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.gZg != null && (this.gZg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZg.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.gZg.setLayoutParams(layoutParams);
        }
        this.gZe.setSystemUiVisibility(0);
        caz();
        if (this.iod != null) {
            this.iod.pf();
        }
    }

    public void caG() {
        if (this.dlL != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mActivity);
            if (this.SE) {
                af = com.baidu.adp.lib.util.l.ah(this.mActivity);
            }
            this.inS.setMax(af);
            int duration = this.dlL.getDuration();
            if (duration > 0) {
                if (this.inV.getVisibility() == 0) {
                    this.inS.setProgress(this.inS.getMax());
                } else {
                    this.inS.setProgress((int) ((this.dlL.getCurrentPosition() * this.inS.getMax()) / duration));
                }
            }
        }
    }

    private void vY(int i2) {
        if (this.gZg != null && (this.gZg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZg.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gZg.setLayoutParams(layoutParams);
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

    public boolean bIp() {
        return !this.SE;
    }

    public void a(g.f fVar) {
        this.gZs = fVar;
    }

    public void a(g.a aVar) {
        this.inY = aVar;
    }

    public void a(g.b bVar) {
        this.inZ = bVar;
    }

    public void i(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dlL != null) {
            this.dlL.setPbLoadingTime(currentTimeMillis);
        }
        cr(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.iot) {
            dQ(str, str2);
        } else {
            cr(str, str2);
        }
        if (eVar != null) {
            eVar.pO(z);
        }
    }

    public void dP(String str, String str2) {
    }

    public void cr(String str, String str2) {
        caL();
        this.ioy = true;
        this.currentState = 0;
        this.dlL.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dlL.setVideoPath(str, str2);
        this.exm.bMi();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZQ);
        if (this.iof > 0) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gZQ, this.iof);
        }
        if (this.iog != null) {
            this.iog.onStarted();
        }
        this.cIs.startLoading();
        pH(true);
    }

    public void dQ(String str, String str2) {
        caL();
        this.ioy = true;
        this.currentState = 0;
        this.dlL.setRecoveryState(0);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZQ);
        if (this.iof > 0) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gZQ, this.iof);
        }
        if (this.iog != null) {
            this.iog.onStarted();
        }
        this.cIs.startLoading();
        pH(true);
    }

    public void caH() {
        bIr();
        this.inS.setVisibility(0);
    }

    public void bIr() {
        int i2 = 100;
        if (this.dlL != null && this.gZg != null) {
            this.Ss = true;
            this.currentState = 1;
            this.dlL.setRecoveryState(1);
            this.dlL.start();
            if (this.deB != null && this.gZg != null) {
                this.mStartPosition = y.cbS().Ck(this.bUZ);
                if (this.mStartPosition != 0 && !this.deB.isPlayerReuse()) {
                    this.ios = true;
                }
                if (this.mStartPosition > 100 && this.deB.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.St = i2;
            } else {
                this.St = 100;
            }
            this.cIs.cbO();
            pH(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.jS() && this.iow && !StringUtils.isNull(this.bUZ) && !StringUtils.isNull(this.bVL)) {
            this.iow = false;
            this.iox = true;
            cr(this.bUZ, this.bVL);
        }
    }

    private void pH(boolean z) {
        if (z) {
            this.gZr.setVisibility(0);
            caR();
            this.inS.setProgress(0);
        } else {
            this.gZr.setVisibility(8);
        }
        this.gZg.showProgress();
        this.gZh.setVisibility(8);
        this.inW.setVisibility(8);
        this.inV.setVisibility(8);
        this.inX.setVisibility(8);
        this.eAg.setVisibility(8);
    }

    private void caI() {
        this.cIs.cbO();
        this.inW.setVisibility(8);
        this.inV.setVisibility(8);
        this.inX.setVisibility(8);
        caT();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dlL != null) {
            this.dlL.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dlL.pause();
        this.currentState = 2;
        this.dlL.setRecoveryState(2);
        caI();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dlL.setRecoveryState(5);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sy);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZQ);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioF);
        this.dlL.stopPlayback();
        this.Ss = false;
        this.ioy = false;
        this.mStartPosition = 0;
        bvq();
    }

    public void caJ() {
        if (this.dlL.getDuration() >= this.dlL.getCurrentPosition()) {
            y.cbS().bf(this.bUZ, this.dlL.getCurrentPosition());
        }
    }

    public void pI(boolean z) {
        this.ior = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(boolean z) {
        if (this.gZn != null) {
            this.gZh.setVisibility(0);
            this.inW.setVisibility(8);
            this.inV.setVisibility(8);
            this.inX.setVisibility(8);
            this.cIs.cbO();
            caR();
            this.inS.setVisibility(8);
            this.eAg.setVisibility(8);
            this.gZg.aBM();
            this.gZr.setVisibility(z ? 0 : 8);
        }
    }

    public void bvq() {
        pJ(true);
    }

    public boolean pg() {
        if (this.dlL == null) {
            return false;
        }
        return this.dlL.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dlL == null) {
            return 0;
        }
        return this.dlL.getCurrentPosition();
    }

    public void a(k kVar) {
        this.ioj = kVar;
    }

    public void a(j jVar) {
        this.ioi = jVar;
    }

    public void a(i iVar) {
        this.hWV = iVar;
    }

    public void a(g gVar) {
        this.iop = gVar;
    }

    public void a(h hVar) {
        this.ioh = hVar;
    }

    public void BG(String str) {
        this.hWv = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caK() {
        a(this.bUZ, this.bVL, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.ioe = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        caL();
        if (com.baidu.adp.lib.util.j.jU() && !com.baidu.tieba.video.g.cqQ().cqR()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.agM().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.iot = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ioo != null) {
                    this.ioo.kh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.mE(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.caM();
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
                aVar.b(this.mContext).afG();
                return;
            } else if (this.ioo != null) {
                this.ioo.kh(true);
                return;
            } else {
                if (!this.inR) {
                    this.inR = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.ion != null) {
            this.ion.bmf();
        }
    }

    private void caL() {
        if (com.baidu.adp.lib.util.j.jU()) {
            com.baidu.tieba.video.g.cqQ().en(this.mActivity);
        }
    }

    public void caM() {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gZr.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sy);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZQ);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioE);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioF);
        this.ddN.stop();
        gZM.unregister(this.mActivity);
    }

    public void Cf(String str) {
        this.gZv.setText(str);
    }

    public boolean bIs() {
        return this.Ss;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caN() {
        if (this.gZn != null) {
            if (this.ioa) {
                caR();
            } else {
                caQ();
            }
        }
    }

    public void bIw() {
        caQ();
        caO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caO() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.gZU, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caP() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
    }

    public void caQ() {
        if (this.gZn != null && !this.ioa && !this.ioC) {
            pK(true);
            bIv();
            this.gZn.setVisibility(0);
            this.inT.setVisibility(0);
            this.inS.setVisibility(8);
            this.ioa = true;
            if (this.ioe != null) {
                this.ioe.ki(false);
            }
        }
    }

    public void bIt() {
        if (this.gZn != null && this.ioa) {
            pK(false);
            bIv();
            this.gZn.setVisibility(8);
            this.inT.setVisibility(8);
            this.inS.setVisibility(0);
            this.fuz.setAnimationListener(this.gZS);
            this.gZn.startAnimation(this.fuz);
            this.ioa = false;
            if (this.ioe != null) {
                this.ioe.bmh();
            }
        }
    }

    public void caR() {
        if (this.gZn != null && this.ioa) {
            this.afk.cancel();
            this.fuz.cancel();
            pK(false);
            bIv();
            this.gZn.setVisibility(8);
            this.inT.setVisibility(8);
            this.inS.setVisibility(0);
            this.ioa = false;
            if (this.ioe != null) {
                this.ioe.bmh();
            }
        }
    }

    private void bIv() {
        if (this.gZn != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
            this.afk.setAnimationListener(null);
            this.fuz.setAnimationListener(null);
            this.gZn.clearAnimation();
        }
    }

    private void caS() {
        if (this.gZn != null) {
            this.afk.setAnimationListener(null);
            this.fuz.setAnimationListener(null);
            this.gZn.clearAnimation();
        }
    }

    public void pK(boolean z) {
        caT();
        if (z) {
            this.inU.setVisibility(0);
        } else {
            this.inU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caT() {
        if (this.currentState == 1) {
            this.inU.setState(1);
        } else {
            this.inU.setState(0);
        }
    }

    public void a(InterfaceC0387c interfaceC0387c) {
        this.iod = interfaceC0387c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ad(boolean z, boolean z2) {
        if (this.ddN != null) {
            if (this.gZm != null) {
                this.gZm.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gZg != null && (this.gZg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZg.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds52);
                this.gZg.setLayoutParams(layoutParams);
            }
            this.ddN.pQ(z);
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
            return com.baidu.adp.lib.util.l.ah(context);
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

    public void pL(boolean z) {
        this.ioB = z;
    }

    public void a(m mVar) {
        this.iok = mVar;
    }

    public void a(a aVar) {
        this.iol = aVar;
    }

    public void a(n nVar) {
        this.iom = nVar;
    }

    public void a(l lVar) {
        this.ion = lVar;
    }

    public void a(f fVar) {
        this.ioo = fVar;
    }

    public void pM(boolean z) {
        this.iov = z;
    }

    public boolean caU() {
        return this.iob;
    }

    public void pN(boolean z) {
        this.iob = z;
    }

    public void yp(int i2) {
        this.ioz = i2;
    }

    public View caV() {
        return this.gZe;
    }

    public void a(o oVar) {
        this.iog = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dlL != null) {
            this.dlL.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.hWJ = pVar;
    }

    public void caW() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
    }
}
