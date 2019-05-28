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
    private static int gZO;
    private static CallStateReceiver gZP;
    private Animation afk;
    private String bUZ;
    private String bVL;
    private x cIs;
    private com.baidu.tieba.play.o ddO;
    public com.baidu.tieba.play.g deC;
    protected QuickVideoView dlM;
    private String eAC;
    private View eAc;
    protected View eAh;
    private com.baidu.tieba.j.k exn;
    private Animation fuA;
    private View gZC;
    private View gZD;
    private TextView gZE;
    private SeekBar gZF;
    private ImageView gZG;
    private ImageView gZH;
    private int gZI;
    private int gZN;
    public View gZh;
    private VideoListMediaControllerView gZj;
    private View gZk;
    private FrameLayout gZl;
    protected FrameLayout.LayoutParams gZm;
    private ImageView gZp;
    private View gZq;
    private View gZs;
    private TbImageView gZu;
    private g.f gZv;
    private ImageView gZx;
    private TextView gZy;
    private p hWM;
    private i hWY;
    private ProgressBar inV;
    private View inW;
    private SwitchImageView inX;
    private TextView inY;
    private TextView inZ;
    private boolean ioA;
    private boolean ioB;
    private int ioC;
    private boolean ioD;
    private boolean ioE;
    private TextView ioa;
    private g.a iob;
    private g.b ioc;
    private View.OnClickListener iof;
    protected InterfaceC0387c iog;
    private d ioh;
    private o ioj;
    private h iok;
    private j iol;
    private k iom;
    private m ion;
    private a ioo;
    private n iop;
    private l ioq;
    private f ior;
    private g ios;
    private TextView iox;
    private boolean ioz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int St = 100;
    private boolean inU = false;
    protected boolean SE = false;
    private boolean Ss = false;
    private boolean iod = false;
    private boolean ioe = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gZJ = 0;
    private int gZK = 0;
    private long ioi = 60000;
    private int gZM = 0;
    private boolean gZQ = false;
    private boolean iot = true;
    private boolean iou = true;
    private boolean iov = false;
    private boolean iow = false;
    private String hWy = null;
    private int currentState = -1;
    private boolean ioy = false;
    private boolean ioF = false;
    private boolean ioG = false;
    private g.f cRT = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.deC = gVar;
            c.this.exn.bMm();
            if (c.this.gZj != null && c.this.deC != null && c.this.deC.getDuration() > 0) {
                c.this.gZj.ax(0, c.this.deC.getDuration());
            }
            c.this.aXx();
            if (c.this.ioj != null) {
                c.this.ioj.onPrepared();
            }
        }
    };
    private g.e cRV = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.pw();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aXx();
        }
    };
    private Runnable Sy = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.Sy);
            if (c.this.gZu.getVisibility() != 8) {
                if (c.this.dlM.getCurrentPosition() > c.this.St) {
                    c.this.pw();
                } else {
                    com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sy, 20L);
                }
            }
        }
    };
    private g.a cRS = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dlM != null) {
                int duration = c.this.dlM.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.Ss = false;
                    c.this.ioB = false;
                    c.this.mStartPosition = 0;
                    c.this.bIh();
                    c.this.gZk.setVisibility(0);
                    c.this.inV.setProgress(c.this.inV.getMax());
                    c.this.St = 100;
                    if (c.this.iob != null) {
                        c.this.iob.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dlM.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.pJ(false);
                        c.this.pK(true);
                    } else {
                        c.this.caU();
                        c.this.inY.setVisibility(0);
                    }
                    if (!c.this.SE && duration <= 150000) {
                        if (!c.this.ioy) {
                            if (c.this.iol != null) {
                                c.this.iol.pf(true);
                            }
                            c.this.cr(c.this.bUZ, c.this.bVL);
                        } else {
                            c.this.currentState = 5;
                            c.this.dlM.setRecoveryState(5);
                            c.this.dlM.getPlayer().pause();
                            c.this.dlM.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.ioj != null) {
                        c.this.ioj.mG(c.this.inV.getMax());
                        c.this.ioj.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gZS = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.eAh.setVisibility(0);
            c.this.cIs.cbR();
            c.this.currentState = 4;
            c.this.dlM.setRecoveryState(4);
            if (c.this.ioc != null) {
                c.this.ioc.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jS()) {
                c.this.ioz = true;
            }
            if (c.this.ioj != null) {
                c.this.ioj.aFm();
            }
            c.this.ioB = false;
            return true;
        }
    };
    protected Runnable gZT = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dlM == null || !c.this.dlM.isPlaying()) {
                c.this.eAh.setVisibility(0);
                c.this.cIs.cbR();
                if (c.this.ioj != null) {
                    c.this.ioj.aFm();
                }
            }
        }
    };
    private g.InterfaceC0388g cRW = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0388g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.iov) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioH, 200L);
            }
        }
    };
    private Runnable ioH = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dlM == null || !c.this.iov) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sy, 200L);
                c.this.iov = false;
            } else if (c.this.mStartPosition != c.this.dlM.getCurrentPosition()) {
                c.this.iov = false;
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sy, 20L);
            } else {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioH, 200L);
            }
        }
    };
    private QuickVideoView.b cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.Ss = false;
            if (c.this.ioe) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioI, 300L);
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.Sy);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.gZT);
        }
    };
    private Runnable ioI = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.ioB = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hWM != null) {
                c.this.hWM.bXi();
            }
            if (view.getId() != c.this.eAh.getId()) {
                if (view.getId() != c.this.inX.getId()) {
                    if (view.getId() == c.this.inZ.getId()) {
                        if (c.this.iok != null) {
                            c.this.iok.bXj();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.inY.getId()) {
                        if (c.this.iol != null) {
                            c.this.iol.pf(false);
                        }
                        c.this.cr(c.this.bUZ, c.this.bVL);
                        return;
                    } else if (view.getId() == c.this.gZp.getId()) {
                        int i2 = c.this.ioe ? 1 : 2;
                        if (c.this.SE) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bT("tid", c.this.bVL).bT("fid", c.this.eAC).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bT("tid", c.this.bVL).bT("fid", c.this.eAC).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.ioq != null) {
                            c.this.ioq.bmj();
                        }
                        if (c.this.caF()) {
                            if (c.this.SE) {
                                c.this.caI();
                            } else {
                                c.this.caH();
                            }
                            c.this.pG(c.this.SE);
                            return;
                        }
                        c.this.bIl();
                        return;
                    } else if (view.getId() != c.this.gZx.getId()) {
                        if (c.this.iof != null) {
                            c.this.iof.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.ioq != null) {
                            c.this.ioq.bmj();
                        }
                        if (c.this.caF()) {
                            c.this.caI();
                            c.this.pG(false);
                            return;
                        }
                        c.this.bIl();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bWZ();
                c.this.caW();
                if (c.this.currentState != 1) {
                    c.this.caS();
                    c.this.caT();
                } else {
                    c.this.bIz();
                }
                if (c.this.ioo != null) {
                    c.this.ioo.kK(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dlM.stopPlayback();
            c.this.Ss = false;
            c.this.caN();
        }
    };
    private Animation.AnimationListener gZV = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gZW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gZX = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bIw();
        }
    };
    private CustomMessageListener gZY = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b hbT = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void mn(int i2) {
            int duration;
            if (c.this.dlM != null && (duration = c.this.dlM.getDuration()) > 0 && c.this.inV != null) {
                c.this.inV.setProgress((int) ((i2 * c.this.gZh.getWidth()) / duration));
                if (c.this.ioj != null) {
                    c.this.ioj.mG((c.this.dlM.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cWh = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.caS();
            c.this.pK(false);
            if (c.this.ioo != null) {
                c.this.ioo.kK(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bIm() != null) {
                c.this.setStartPosition(c.this.bIm().getSeekPosition());
                if (!c.this.bIv()) {
                    c.this.caN();
                } else {
                    c.this.bIu();
                    if (c.this.hWY != null) {
                        c.this.hWY.bml();
                    }
                }
            }
            c.this.pK(true);
            c.this.caR();
            if (c.this.ioo != null) {
                c.this.ioo.kK(true);
            }
            if (c.this.iop != null) {
                c.this.iop.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a ioJ = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void cba() {
            if (!c.this.ioy) {
                c.this.cIs.startLoading();
                c.this.gZu.setVisibility(0);
                c.this.inX.setVisibility(8);
                c.this.inZ.setVisibility(8);
                c.this.inY.setVisibility(8);
                c.this.ioa.setVisibility(8);
                c.this.eAh.setVisibility(8);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.gZT);
                if (c.this.ioi > 0) {
                    com.baidu.adp.lib.g.e.iB().postDelayed(c.this.gZT, c.this.ioi);
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
        void bmk();

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
        void bXj();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bml();
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
        void bmi();

        void bmj();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean bXk();

        boolean bXl();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aFm();

        void aFn();

        void mG(int i);

        void onPaused();

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bXi();
    }

    public c(Activity activity, View view, boolean z) {
        this.ioD = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.ioD = z;
            this.gZs = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.ioD = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.ioD = z;
            this.gZs = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gZh = ap(this.mActivity);
        this.gZh.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gZh);
        }
        this.dlM = (QuickVideoView) this.gZh.findViewById(R.id.videoView);
        this.cIs = new x((ViewGroup) this.gZh.findViewById(R.id.auto_video_loading_container));
        this.cIs.setLoadingAnimationListener(this.exy);
        this.gZj = (VideoListMediaControllerView) this.gZh.findViewById(R.id.media_controller);
        this.gZj.setPlayer(this.dlM);
        this.inV = (ProgressBar) this.gZh.findViewById(R.id.pgrBottomProgress);
        this.inV.setMax(com.baidu.adp.lib.util.l.af(this.mActivity));
        this.inV.setProgress(0);
        this.gZj.setOnSeekBarChangeListener(this.cWh);
        this.gZj.setOnProgressUpdatedListener(this.hbT);
        this.gZk = this.gZh.findViewById(R.id.black_mask);
        this.eAh = this.gZh.findViewById(R.id.layout_error);
        this.eAh.setOnClickListener(this.mOnClickListener);
        this.iox = (TextView) this.gZh.findViewById(R.id.auto_video_error_tips);
        this.gZl = (FrameLayout) this.gZh.findViewById(R.id.danmu_container);
        this.gZp = (ImageView) this.gZh.findViewById(R.id.img_full_screen);
        this.gZp.setOnClickListener(this.mOnClickListener);
        this.gZq = this.gZh.findViewById(R.id.layout_media_controller);
        this.inW = this.gZh.findViewById(R.id.time_show_controller);
        this.dlM.setPlayerReuseEnable(true);
        this.dlM.setContinuePlayEnable(true);
        this.dlM.setOnPreparedListener(this.cRT);
        this.dlM.setOnCompletionListener(this.cRS);
        this.dlM.setOnErrorListener(this.gZS);
        this.dlM.setOnSeekCompleteListener(this.cRW);
        this.dlM.setOnSurfaceDestroyedListener(this.cIB);
        this.dlM.setOnRecoveryCallback(this.ioJ);
        this.dlM.setOnOutInfoListener(this.cRV);
        this.inX = (SwitchImageView) this.gZh.findViewById(R.id.img_play_controller);
        this.inX.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.inX.setState(0);
        this.inX.setOnClickListener(this.mOnClickListener);
        this.inY = (TextView) this.gZh.findViewById(R.id.txt_replay);
        this.inY.setOnClickListener(this.mOnClickListener);
        this.inZ = (TextView) this.gZh.findViewById(R.id.txt_playnext);
        this.inZ.setOnClickListener(this.mOnClickListener);
        this.ioa = (TextView) this.gZh.findViewById(R.id.txt_next_video_title);
        this.gZu = (TbImageView) this.gZh.findViewById(R.id.video_thumbnail);
        this.gZu.setDefaultErrorResource(0);
        this.gZu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gZx = (ImageView) this.gZh.findViewById(R.id.img_exit);
        this.gZx.setOnClickListener(this.mOnClickListener);
        this.gZy = (TextView) this.gZh.findViewById(R.id.video_title);
        this.eAc = this.gZh.findViewById(R.id.layout_title);
        this.eAc.setVisibility(8);
        this.fuA = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afk = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gZI = this.mAudioManager.getStreamMaxVolume(3);
        this.gZN = this.mAudioManager.getStreamVolume(3);
        gZO = 100 / this.gZI;
        this.gZh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.iom != null) {
                    c.this.iom.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Ss) {
                        if (c.this.mStatus == 1 && c.this.gZK != 0) {
                            c.this.b(c.this.gZK == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gZK = 0;
                            c.this.gZJ = 0;
                        }
                        if (!c.this.dlM.isPlaying()) {
                            c.this.inZ.setVisibility(8);
                            c.this.inY.setVisibility(8);
                            c.this.ioa.setVisibility(8);
                        }
                    }
                    c.this.bIh();
                    if (c.this.iom != null) {
                        c.this.iom.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.ddO = new com.baidu.tieba.play.o(this.mActivity);
        if (this.ioD) {
            this.ddO.start();
        }
        this.gZM = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.ds16);
        if (gZP == null) {
            gZP = new CallStateReceiver();
        }
        gZP.register(this.mActivity);
        caC();
        this.exn = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gZY);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gZY);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void caC() {
        if (this.iot) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.gZh.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gZh.setSystemUiVisibility(0);
    }

    public void pE(boolean z) {
        this.iot = z;
        caC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        this.mStatus = 0;
        if (this.gZC != null && this.gZC.getParent() != null && (this.gZC.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gZC.getParent()).removeView(this.gZC);
                this.gZC = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gZD != null && this.gZD.getParent() != null && (this.gZD.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gZD.getParent()).removeView(this.gZD);
                this.gZD = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bIi() {
        if (this.mStatus == 1) {
            if (this.gZC == null && this.gZh != null && (this.gZh instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.gZh, true);
                this.gZC = this.gZh.findViewById(R.id.lay_jindu);
                this.gZE = (TextView) this.gZC.findViewById(R.id.show_time);
                this.gZH = (ImageView) this.gZC.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gZD == null && this.gZh != null && (this.gZh instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.gZh, true);
            this.gZD = this.gZh.findViewById(R.id.lay_voice);
            this.gZG = (ImageView) this.gZD.findViewById(R.id.arrow_voice_icon);
            this.gZF = (SeekBar) this.gZD.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        this.iof = onClickListener;
    }

    public void pF(boolean z) {
        this.ioe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.iom != null) {
                c.this.iom.onStart();
            }
            if (c.this.SE && c.this.Ss) {
                if (c.this.mStatus == 1) {
                    c.this.caU();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aL(f2);
                    }
                } else {
                    if (c.this.SE) {
                        c.this.bIk();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gZJ = c.this.dlM.getCurrentPosition();
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
            if (!c.this.ioE) {
                if (c.this.ion != null && c.this.ion.bXk()) {
                    return true;
                }
                c.this.bWZ();
                c.this.caW();
                if (c.this.dlM.isPlaying()) {
                    c.this.caR();
                } else {
                    c.this.caS();
                }
                if (c.this.ioo != null) {
                    c.this.ioo.kK(c.this.dlM.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.ioE) {
                if (c.this.Ss) {
                    if (c.this.ion != null && c.this.ion.bXl()) {
                        return true;
                    }
                    c.this.caQ();
                    if (c.this.dlM.isPlaying()) {
                        c.this.caR();
                    } else {
                        c.this.caS();
                    }
                    if (c.this.ioo != null) {
                        c.this.ioo.kK(c.this.dlM.isPlaying());
                    }
                } else {
                    c.this.bWZ();
                    c.this.caW();
                    if (c.this.currentState != 1) {
                        c.this.caS();
                        c.this.caT();
                    } else {
                        c.this.bIz();
                    }
                    if (c.this.ioo != null) {
                        c.this.ioo.kK(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gZh.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gZh.setSystemUiVisibility(4);
        } else {
            this.gZh.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(float f2) {
        if (!this.Ss) {
            this.mStatus = 0;
            return;
        }
        bIi();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gZO == 0) {
            if (f2 > 0.0f && this.gZN < this.gZI) {
                this.gZN++;
            }
            if (f2 < 0.0f && this.gZN > 0) {
                this.gZN--;
            }
        }
        if (this.mProgress > 0) {
            this.gZG.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.gZG.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gZN, 0);
        this.gZF.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gZJ += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gZK = 1;
            } else {
                this.gZJ += 1000;
                this.gZK = 2;
            }
            if (this.gZJ < 0) {
                this.gZJ = 0;
            } else if (this.gZJ > this.dlM.getDuration()) {
                this.gZJ = this.dlM.getDuration();
            }
        }
        bIi();
        String yu = this.gZj.yu(this.gZJ);
        if (f2 > 0.0f) {
            this.gZH.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.gZH.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(yu)) {
            this.gZE.setText(new StringBuilder().append(yu).append("/").append(this.gZj.yu(this.dlM.getDuration())));
        }
        this.gZj.setCurrentDuration(this.gZJ, z ? false : true);
        caU();
        caJ();
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

    public void caD() {
        if (this.dlM != null) {
            this.dlM.caD();
        }
    }

    public void setFid(String str) {
        this.eAC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        int i2 = 100;
        if (this.dlM != null && this.deC != null && this.gZj != null) {
            this.gZj.showProgress();
            this.mStartPosition = y.cbV().Ck(this.bUZ);
            if (this.ioB) {
                this.deC.setVolume(1.0f, 1.0f);
                this.dlM.start();
                this.ioB = false;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sy);
                com.baidu.adp.lib.g.e.iB().postDelayed(this.Sy, 20L);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZT);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioI);
                if (this.dlM.cbr()) {
                    this.currentState = 1;
                    this.dlM.setRecoveryState(1);
                    caU();
                }
                this.mStartPosition = y.cbV().Ck(this.bUZ);
                this.gZj.setPlayer(this.dlM);
                if (this.mStartPosition != 0 && !this.deC.isPlayerReuse()) {
                    this.iov = true;
                }
                if (!this.ioA) {
                    this.gZj.showProgress();
                }
                if (!this.ioe && this.deC.getDuration() <= 0) {
                    bIm().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.deC.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.St = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        if (this.gZu.getVisibility() != 8) {
            this.Ss = true;
            this.gZk.setVisibility(8);
            this.eAh.setVisibility(8);
            this.cIs.cbQ();
            this.gZu.setVisibility(8);
            caV();
            if (caX()) {
                this.exn.a(this.bVL, -1L, this.dlM.getDuration() / 1000, "middle", this.dlM);
            }
            this.gZj.showProgress();
            this.inV.setVisibility(0);
            if (this.gZv != null) {
                this.gZv.onPrepared(this.dlM.getPlayer());
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
        if (hasNavBar(this.mActivity) && (this.inW.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.inW.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.inW.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.inW.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.inW.setLayoutParams(layoutParams);
        }
    }

    public void bWZ() {
        if (this.dlM.isPlaying()) {
            pausePlay();
            if (this.ios != null) {
                this.ios.onPause();
            }
            if (this.ioj != null) {
                this.ioj.onPaused();
            }
        } else if (this.Ss) {
            bIu();
            if (this.hWY != null) {
                this.hWY.bml();
            }
            if (this.ioj != null) {
                this.ioj.aFn();
            }
        } else {
            caN();
        }
    }

    public boolean caE() {
        return this.gZQ;
    }

    public void bIl() {
        this.gZQ = true;
        if (this.ddO != null) {
            this.ddO.bIl();
        }
    }

    public boolean caF() {
        return this.deC != null && this.dlM.getHeight() > this.dlM.getWidth();
    }

    public void caG() {
        pG(false);
        caI();
    }

    public boolean yo(int i2) {
        switch (i2) {
            case 4:
                if (this.SE) {
                    if (caF()) {
                        pG(false);
                        caI();
                    } else {
                        bIl();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.gZI <= 0 || this.gZF == null) {
                    return false;
                }
                this.gZN = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gZN * 100.0d) / this.gZI);
                this.gZF.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dlM;
    }

    public VideoListMediaControllerView bIm() {
        return this.gZj;
    }

    public void show() {
        this.gZh.setVisibility(0);
    }

    public void bIq() {
        if (this.gZs != null) {
            ViewGroup.LayoutParams layoutParams = this.gZs.getLayoutParams();
            this.gZm = (FrameLayout.LayoutParams) this.gZh.getLayoutParams();
            this.gZm.width = layoutParams.width;
            this.gZm.height = layoutParams.height;
            this.gZm.topMargin = 0;
            this.gZh.setLayoutParams(this.gZm);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gZQ) {
            if (this.SE) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gZQ = false;
        }
        if (configuration.orientation == 2) {
            caH();
        } else {
            caI();
        }
        caJ();
        bIu();
        caW();
        bIz();
        if (this.ioo != null) {
            this.ioo.kK(true);
        }
    }

    protected void caH() {
        this.SE = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (caF()) {
            this.gZh.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gZh.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.eAc.setVisibility(0);
        this.gZx.setVisibility(0);
        this.gZy.setVisibility(0);
        this.gZl.setVisibility(8);
        this.cIs.cbR();
        this.gZu.setVisibility(8);
        this.gZp.setImageResource(R.drawable.icon_video_narrow_white);
        vY(this.gZM);
        bIk();
        if (this.iog != null) {
            this.iog.pe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caI() {
        this.SE = false;
        if (this.gZm != null) {
            this.gZh.setLayoutParams(this.gZm);
        }
        g(this.mActivity, false);
        this.eAc.setVisibility(8);
        this.gZl.setVisibility(0);
        this.cIs.cbR();
        this.gZu.setVisibility(8);
        this.gZp.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.gZj != null && (this.gZj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZj.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.gZj.setLayoutParams(layoutParams);
        }
        this.gZh.setSystemUiVisibility(0);
        caC();
        if (this.iog != null) {
            this.iog.pf();
        }
    }

    public void caJ() {
        if (this.dlM != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mActivity);
            if (this.SE) {
                af = com.baidu.adp.lib.util.l.ah(this.mActivity);
            }
            this.inV.setMax(af);
            int duration = this.dlM.getDuration();
            if (duration > 0) {
                if (this.inY.getVisibility() == 0) {
                    this.inV.setProgress(this.inV.getMax());
                } else {
                    this.inV.setProgress((int) ((this.dlM.getCurrentPosition() * this.inV.getMax()) / duration));
                }
            }
        }
    }

    private void vY(int i2) {
        if (this.gZj != null && (this.gZj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZj.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gZj.setLayoutParams(layoutParams);
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

    public boolean bIs() {
        return !this.SE;
    }

    public void a(g.f fVar) {
        this.gZv = fVar;
    }

    public void a(g.a aVar) {
        this.iob = aVar;
    }

    public void a(g.b bVar) {
        this.ioc = bVar;
    }

    public void i(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dlM != null) {
            this.dlM.setPbLoadingTime(currentTimeMillis);
        }
        cr(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.iow) {
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
        caO();
        this.ioB = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dlM.setVideoPath(str, str2);
        this.exn.bMl();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZT);
        if (this.ioi > 0) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gZT, this.ioi);
        }
        if (this.ioj != null) {
            this.ioj.onStarted();
        }
        this.cIs.startLoading();
        pH(true);
    }

    public void dQ(String str, String str2) {
        caO();
        this.ioB = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZT);
        if (this.ioi > 0) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gZT, this.ioi);
        }
        if (this.ioj != null) {
            this.ioj.onStarted();
        }
        this.cIs.startLoading();
        pH(true);
    }

    public void caK() {
        bIu();
        this.inV.setVisibility(0);
    }

    public void bIu() {
        int i2 = 100;
        if (this.dlM != null && this.gZj != null) {
            this.Ss = true;
            this.currentState = 1;
            this.dlM.setRecoveryState(1);
            this.dlM.start();
            if (this.deC != null && this.gZj != null) {
                this.mStartPosition = y.cbV().Ck(this.bUZ);
                if (this.mStartPosition != 0 && !this.deC.isPlayerReuse()) {
                    this.iov = true;
                }
                if (this.mStartPosition > 100 && this.deC.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.St = i2;
            } else {
                this.St = 100;
            }
            this.cIs.cbR();
            pH(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.jS() && this.ioz && !StringUtils.isNull(this.bUZ) && !StringUtils.isNull(this.bVL)) {
            this.ioz = false;
            this.ioA = true;
            cr(this.bUZ, this.bVL);
        }
    }

    private void pH(boolean z) {
        if (z) {
            this.gZu.setVisibility(0);
            caU();
            this.inV.setProgress(0);
        } else {
            this.gZu.setVisibility(8);
        }
        this.gZj.showProgress();
        this.gZk.setVisibility(8);
        this.inZ.setVisibility(8);
        this.inY.setVisibility(8);
        this.ioa.setVisibility(8);
        this.eAh.setVisibility(8);
    }

    private void caL() {
        this.cIs.cbR();
        this.inZ.setVisibility(8);
        this.inY.setVisibility(8);
        this.ioa.setVisibility(8);
        caW();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dlM != null) {
            this.dlM.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dlM.pause();
        this.currentState = 2;
        this.dlM.setRecoveryState(2);
        caL();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dlM.setRecoveryState(5);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sy);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZT);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioI);
        this.dlM.stopPlayback();
        this.Ss = false;
        this.ioB = false;
        this.mStartPosition = 0;
        bvt();
    }

    public void caM() {
        if (this.dlM.getDuration() >= this.dlM.getCurrentPosition()) {
            y.cbV().bf(this.bUZ, this.dlM.getCurrentPosition());
        }
    }

    public void pI(boolean z) {
        this.iou = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(boolean z) {
        if (this.gZq != null) {
            this.gZk.setVisibility(0);
            this.inZ.setVisibility(8);
            this.inY.setVisibility(8);
            this.ioa.setVisibility(8);
            this.cIs.cbR();
            caU();
            this.inV.setVisibility(8);
            this.eAh.setVisibility(8);
            this.gZj.aBP();
            this.gZu.setVisibility(z ? 0 : 8);
        }
    }

    public void bvt() {
        pJ(true);
    }

    public boolean pg() {
        if (this.dlM == null) {
            return false;
        }
        return this.dlM.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dlM == null) {
            return 0;
        }
        return this.dlM.getCurrentPosition();
    }

    public void a(k kVar) {
        this.iom = kVar;
    }

    public void a(j jVar) {
        this.iol = jVar;
    }

    public void a(i iVar) {
        this.hWY = iVar;
    }

    public void a(g gVar) {
        this.ios = gVar;
    }

    public void a(h hVar) {
        this.iok = hVar;
    }

    public void BG(String str) {
        this.hWy = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caN() {
        a(this.bUZ, this.bVL, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.ioh = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        caO();
        if (com.baidu.adp.lib.util.j.jU() && !com.baidu.tieba.video.g.cqS().cqT()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.agM().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.iow = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ior != null) {
                    this.ior.kh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.mE(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.caP();
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
            } else if (this.ior != null) {
                this.ior.kh(true);
                return;
            } else {
                if (!this.inU) {
                    this.inU = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.ioq != null) {
            this.ioq.bmi();
        }
    }

    private void caO() {
        if (com.baidu.adp.lib.util.j.jU()) {
            com.baidu.tieba.video.g.cqS().en(this.mActivity);
        }
    }

    public void caP() {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gZu.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZX);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sy);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZT);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioH);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioI);
        this.ddO.stop();
        gZP.unregister(this.mActivity);
    }

    public void Cf(String str) {
        this.gZy.setText(str);
    }

    public boolean bIv() {
        return this.Ss;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caQ() {
        if (this.gZq != null) {
            if (this.iod) {
                caU();
            } else {
                caT();
            }
        }
    }

    public void bIz() {
        caT();
        caR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caR() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZX);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.gZX, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caS() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZX);
    }

    public void caT() {
        if (this.gZq != null && !this.iod && !this.ioF) {
            pK(true);
            bIy();
            this.gZq.setVisibility(0);
            this.inW.setVisibility(0);
            this.inV.setVisibility(8);
            this.iod = true;
            if (this.ioh != null) {
                this.ioh.ki(false);
            }
        }
    }

    public void bIw() {
        if (this.gZq != null && this.iod) {
            pK(false);
            bIy();
            this.gZq.setVisibility(8);
            this.inW.setVisibility(8);
            this.inV.setVisibility(0);
            this.fuA.setAnimationListener(this.gZV);
            this.gZq.startAnimation(this.fuA);
            this.iod = false;
            if (this.ioh != null) {
                this.ioh.bmk();
            }
        }
    }

    public void caU() {
        if (this.gZq != null && this.iod) {
            this.afk.cancel();
            this.fuA.cancel();
            pK(false);
            bIy();
            this.gZq.setVisibility(8);
            this.inW.setVisibility(8);
            this.inV.setVisibility(0);
            this.iod = false;
            if (this.ioh != null) {
                this.ioh.bmk();
            }
        }
    }

    private void bIy() {
        if (this.gZq != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZX);
            this.afk.setAnimationListener(null);
            this.fuA.setAnimationListener(null);
            this.gZq.clearAnimation();
        }
    }

    private void caV() {
        if (this.gZq != null) {
            this.afk.setAnimationListener(null);
            this.fuA.setAnimationListener(null);
            this.gZq.clearAnimation();
        }
    }

    public void pK(boolean z) {
        caW();
        if (z) {
            this.inX.setVisibility(0);
        } else {
            this.inX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caW() {
        if (this.currentState == 1) {
            this.inX.setState(1);
        } else {
            this.inX.setState(0);
        }
    }

    public void a(InterfaceC0387c interfaceC0387c) {
        this.iog = interfaceC0387c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ad(boolean z, boolean z2) {
        if (this.ddO != null) {
            if (this.gZp != null) {
                this.gZp.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gZj != null && (this.gZj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZj.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds52);
                this.gZj.setLayoutParams(layoutParams);
            }
            this.ddO.pQ(z);
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
        this.ioE = z;
    }

    public void a(m mVar) {
        this.ion = mVar;
    }

    public void a(a aVar) {
        this.ioo = aVar;
    }

    public void a(n nVar) {
        this.iop = nVar;
    }

    public void a(l lVar) {
        this.ioq = lVar;
    }

    public void a(f fVar) {
        this.ior = fVar;
    }

    public void pM(boolean z) {
        this.ioy = z;
    }

    public boolean caX() {
        return this.ioe;
    }

    public void pN(boolean z) {
        this.ioe = z;
    }

    public void yp(int i2) {
        this.ioC = i2;
    }

    public View caY() {
        return this.gZh;
    }

    public void a(o oVar) {
        this.ioj = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dlM != null) {
            this.dlM.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.hWM = pVar;
    }

    public void caZ() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
    }
}
