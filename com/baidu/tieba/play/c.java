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
    private static int gZP;
    private static CallStateReceiver gZQ;
    private Animation afk;
    private String bVM;
    private String bVa;
    private x cIt;
    private com.baidu.tieba.play.o ddP;
    public com.baidu.tieba.play.g deD;
    protected QuickVideoView dlM;
    private String eAC;
    private View eAc;
    protected View eAh;
    private com.baidu.tieba.j.k exn;
    private Animation fuA;
    private View gZD;
    private View gZE;
    private TextView gZF;
    private SeekBar gZG;
    private ImageView gZH;
    private ImageView gZI;
    private int gZJ;
    private int gZO;
    public View gZi;
    private VideoListMediaControllerView gZk;
    private View gZl;
    private FrameLayout gZm;
    protected FrameLayout.LayoutParams gZn;
    private ImageView gZq;
    private View gZr;
    private View gZt;
    private TbImageView gZv;
    private g.f gZw;
    private ImageView gZy;
    private TextView gZz;
    private p hWN;
    private i hWZ;
    private ProgressBar inW;
    private View inX;
    private SwitchImageView inY;
    private TextView inZ;
    private boolean ioA;
    private boolean ioB;
    private boolean ioC;
    private int ioD;
    private boolean ioE;
    private boolean ioF;
    private TextView ioa;
    private TextView iob;
    private g.a ioc;
    private g.b iod;
    private View.OnClickListener iog;
    protected InterfaceC0387c ioh;
    private d ioi;
    private o iok;
    private h iol;
    private j iom;
    private k ion;
    private m ioo;
    private a iop;
    private n ioq;
    private l ior;
    private f ios;
    private g iot;
    private TextView ioy;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int Ss = 100;
    private boolean inV = false;
    protected boolean SD = false;
    private boolean Sr = false;
    private boolean ioe = false;
    private boolean iof = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gZK = 0;
    private int gZL = 0;
    private long ioj = 60000;
    private int gZN = 0;
    private boolean gZR = false;
    private boolean iou = true;
    private boolean iov = true;
    private boolean iow = false;
    private boolean iox = false;
    private String hWz = null;
    private int currentState = -1;
    private boolean ioz = false;
    private boolean ioG = false;
    private boolean ioH = false;
    private g.f cRU = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.deD = gVar;
            c.this.exn.bMn();
            if (c.this.gZk != null && c.this.deD != null && c.this.deD.getDuration() > 0) {
                c.this.gZk.ax(0, c.this.deD.getDuration());
            }
            c.this.aXx();
            if (c.this.iok != null) {
                c.this.iok.onPrepared();
            }
        }
    };
    private g.e cRW = new g.e() { // from class: com.baidu.tieba.play.c.18
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
    private Runnable Sx = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.Sx);
            if (c.this.gZv.getVisibility() != 8) {
                if (c.this.dlM.getCurrentPosition() > c.this.Ss) {
                    c.this.pw();
                } else {
                    com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sx, 20L);
                }
            }
        }
    };
    private g.a cRT = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dlM != null) {
                int duration = c.this.dlM.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.Sr = false;
                    c.this.ioC = false;
                    c.this.mStartPosition = 0;
                    c.this.bIi();
                    c.this.gZl.setVisibility(0);
                    c.this.inW.setProgress(c.this.inW.getMax());
                    c.this.Ss = 100;
                    if (c.this.ioc != null) {
                        c.this.ioc.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dlM.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.pK(false);
                        c.this.pL(true);
                    } else {
                        c.this.caV();
                        c.this.inZ.setVisibility(0);
                    }
                    if (!c.this.SD && duration <= 150000) {
                        if (!c.this.ioz) {
                            if (c.this.iom != null) {
                                c.this.iom.pg(true);
                            }
                            c.this.cr(c.this.bVa, c.this.bVM);
                        } else {
                            c.this.currentState = 5;
                            c.this.dlM.setRecoveryState(5);
                            c.this.dlM.getPlayer().pause();
                            c.this.dlM.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.iok != null) {
                        c.this.iok.mG(c.this.inW.getMax());
                        c.this.iok.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b gZT = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.eAh.setVisibility(0);
            c.this.cIt.cbS();
            c.this.currentState = 4;
            c.this.dlM.setRecoveryState(4);
            if (c.this.iod != null) {
                c.this.iod.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jS()) {
                c.this.ioA = true;
            }
            if (c.this.iok != null) {
                c.this.iok.aFm();
            }
            c.this.ioC = false;
            return true;
        }
    };
    protected Runnable gZU = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dlM == null || !c.this.dlM.isPlaying()) {
                c.this.eAh.setVisibility(0);
                c.this.cIt.cbS();
                if (c.this.iok != null) {
                    c.this.iok.aFm();
                }
            }
        }
    };
    private g.InterfaceC0388g cRX = new g.InterfaceC0388g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0388g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.iow) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioI, 200L);
            }
        }
    };
    private Runnable ioI = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dlM == null || !c.this.iow) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sx, 200L);
                c.this.iow = false;
            } else if (c.this.mStartPosition != c.this.dlM.getCurrentPosition()) {
                c.this.iow = false;
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.Sx, 20L);
            } else {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioI, 200L);
            }
        }
    };
    private QuickVideoView.b cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.Sr = false;
            if (c.this.iof) {
                com.baidu.adp.lib.g.e.iB().postDelayed(c.this.ioJ, 300L);
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.Sx);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.gZU);
        }
    };
    private Runnable ioJ = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.ioC = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.hWN != null) {
                c.this.hWN.bXj();
            }
            if (view.getId() != c.this.eAh.getId()) {
                if (view.getId() != c.this.inY.getId()) {
                    if (view.getId() == c.this.ioa.getId()) {
                        if (c.this.iol != null) {
                            c.this.iol.bXk();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.inZ.getId()) {
                        if (c.this.iom != null) {
                            c.this.iom.pg(false);
                        }
                        c.this.cr(c.this.bVa, c.this.bVM);
                        return;
                    } else if (view.getId() == c.this.gZq.getId()) {
                        int i2 = c.this.iof ? 1 : 2;
                        if (c.this.SD) {
                            TiebaStatic.log(new am("c11714"));
                            TiebaStatic.log(new am("c13262").bT("tid", c.this.bVM).bT("fid", c.this.eAC).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c11710"));
                            TiebaStatic.log(new am("c13262").bT("tid", c.this.bVM).bT("fid", c.this.eAC).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.ior != null) {
                            c.this.ior.bmj();
                        }
                        if (c.this.caG()) {
                            if (c.this.SD) {
                                c.this.caJ();
                            } else {
                                c.this.caI();
                            }
                            c.this.pH(c.this.SD);
                            return;
                        }
                        c.this.bIm();
                        return;
                    } else if (view.getId() != c.this.gZy.getId()) {
                        if (c.this.iog != null) {
                            c.this.iog.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new am("c11713"));
                        if (c.this.ior != null) {
                            c.this.ior.bmj();
                        }
                        if (c.this.caG()) {
                            c.this.caJ();
                            c.this.pH(false);
                            return;
                        }
                        c.this.bIm();
                        return;
                    }
                }
                TiebaStatic.log(new am("c13255"));
                c.this.bXa();
                c.this.caX();
                if (c.this.currentState != 1) {
                    c.this.caT();
                    c.this.caU();
                } else {
                    c.this.bIA();
                }
                if (c.this.iop != null) {
                    c.this.iop.kL(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dlM.stopPlayback();
            c.this.Sr = false;
            c.this.caO();
        }
    };
    private Animation.AnimationListener gZW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener gZX = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable gZY = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bIx();
        }
    };
    private CustomMessageListener gZZ = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b hbU = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void mn(int i2) {
            int duration;
            if (c.this.dlM != null && (duration = c.this.dlM.getDuration()) > 0 && c.this.inW != null) {
                c.this.inW.setProgress((int) ((i2 * c.this.gZi.getWidth()) / duration));
                if (c.this.iok != null) {
                    c.this.iok.mG((c.this.dlM.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cWi = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.caT();
            c.this.pL(false);
            if (c.this.iop != null) {
                c.this.iop.kL(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bIn() != null) {
                c.this.setStartPosition(c.this.bIn().getSeekPosition());
                if (!c.this.bIw()) {
                    c.this.caO();
                } else {
                    c.this.bIv();
                    if (c.this.hWZ != null) {
                        c.this.hWZ.bml();
                    }
                }
            }
            c.this.pL(true);
            c.this.caS();
            if (c.this.iop != null) {
                c.this.iop.kL(true);
            }
            if (c.this.ioq != null) {
                c.this.ioq.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a ioK = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void cbb() {
            if (!c.this.ioz) {
                c.this.cIt.startLoading();
                c.this.gZv.setVisibility(0);
                c.this.inY.setVisibility(8);
                c.this.ioa.setVisibility(8);
                c.this.inZ.setVisibility(8);
                c.this.iob.setVisibility(8);
                c.this.eAh.setVisibility(8);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(c.this.gZU);
                if (c.this.ioj > 0) {
                    com.baidu.adp.lib.g.e.iB().postDelayed(c.this.gZU, c.this.ioj);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kL(boolean z);
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
        void pP(boolean z);
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
        void bXk();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bml();
    }

    /* loaded from: classes.dex */
    public interface j {
        void pg(boolean z);
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
        boolean bXl();

        boolean bXm();
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
        void bXj();
    }

    public c(Activity activity, View view, boolean z) {
        this.ioE = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.ioE = z;
            this.gZt = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.ioE = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.ioE = z;
            this.gZt = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.gZi = ap(this.mActivity);
        this.gZi.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.gZi);
        }
        this.dlM = (QuickVideoView) this.gZi.findViewById(R.id.videoView);
        this.cIt = new x((ViewGroup) this.gZi.findViewById(R.id.auto_video_loading_container));
        this.cIt.setLoadingAnimationListener(this.exy);
        this.gZk = (VideoListMediaControllerView) this.gZi.findViewById(R.id.media_controller);
        this.gZk.setPlayer(this.dlM);
        this.inW = (ProgressBar) this.gZi.findViewById(R.id.pgrBottomProgress);
        this.inW.setMax(com.baidu.adp.lib.util.l.af(this.mActivity));
        this.inW.setProgress(0);
        this.gZk.setOnSeekBarChangeListener(this.cWi);
        this.gZk.setOnProgressUpdatedListener(this.hbU);
        this.gZl = this.gZi.findViewById(R.id.black_mask);
        this.eAh = this.gZi.findViewById(R.id.layout_error);
        this.eAh.setOnClickListener(this.mOnClickListener);
        this.ioy = (TextView) this.gZi.findViewById(R.id.auto_video_error_tips);
        this.gZm = (FrameLayout) this.gZi.findViewById(R.id.danmu_container);
        this.gZq = (ImageView) this.gZi.findViewById(R.id.img_full_screen);
        this.gZq.setOnClickListener(this.mOnClickListener);
        this.gZr = this.gZi.findViewById(R.id.layout_media_controller);
        this.inX = this.gZi.findViewById(R.id.time_show_controller);
        this.dlM.setPlayerReuseEnable(true);
        this.dlM.setContinuePlayEnable(true);
        this.dlM.setOnPreparedListener(this.cRU);
        this.dlM.setOnCompletionListener(this.cRT);
        this.dlM.setOnErrorListener(this.gZT);
        this.dlM.setOnSeekCompleteListener(this.cRX);
        this.dlM.setOnSurfaceDestroyedListener(this.cIC);
        this.dlM.setOnRecoveryCallback(this.ioK);
        this.dlM.setOnOutInfoListener(this.cRW);
        this.inY = (SwitchImageView) this.gZi.findViewById(R.id.img_play_controller);
        this.inY.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.inY.setState(0);
        this.inY.setOnClickListener(this.mOnClickListener);
        this.inZ = (TextView) this.gZi.findViewById(R.id.txt_replay);
        this.inZ.setOnClickListener(this.mOnClickListener);
        this.ioa = (TextView) this.gZi.findViewById(R.id.txt_playnext);
        this.ioa.setOnClickListener(this.mOnClickListener);
        this.iob = (TextView) this.gZi.findViewById(R.id.txt_next_video_title);
        this.gZv = (TbImageView) this.gZi.findViewById(R.id.video_thumbnail);
        this.gZv.setDefaultErrorResource(0);
        this.gZv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gZy = (ImageView) this.gZi.findViewById(R.id.img_exit);
        this.gZy.setOnClickListener(this.mOnClickListener);
        this.gZz = (TextView) this.gZi.findViewById(R.id.video_title);
        this.eAc = this.gZi.findViewById(R.id.layout_title);
        this.eAc.setVisibility(8);
        this.fuA = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afk = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.gZJ = this.mAudioManager.getStreamMaxVolume(3);
        this.gZO = this.mAudioManager.getStreamVolume(3);
        gZP = 100 / this.gZJ;
        this.gZi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.ion != null) {
                    c.this.ion.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.Sr) {
                        if (c.this.mStatus == 1 && c.this.gZL != 0) {
                            c.this.b(c.this.gZL == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gZL = 0;
                            c.this.gZK = 0;
                        }
                        if (!c.this.dlM.isPlaying()) {
                            c.this.ioa.setVisibility(8);
                            c.this.inZ.setVisibility(8);
                            c.this.iob.setVisibility(8);
                        }
                    }
                    c.this.bIi();
                    if (c.this.ion != null) {
                        c.this.ion.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.ddP = new com.baidu.tieba.play.o(this.mActivity);
        if (this.ioE) {
            this.ddP.start();
        }
        this.gZN = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.ds16);
        if (gZQ == null) {
            gZQ = new CallStateReceiver();
        }
        gZQ.register(this.mActivity);
        caD();
        this.exn = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.gZZ);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.gZZ);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void caD() {
        if (this.iou) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.gZi.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.gZi.setSystemUiVisibility(0);
    }

    public void pF(boolean z) {
        this.iou = z;
        caD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        this.mStatus = 0;
        if (this.gZD != null && this.gZD.getParent() != null && (this.gZD.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gZD.getParent()).removeView(this.gZD);
                this.gZD = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.gZE != null && this.gZE.getParent() != null && (this.gZE.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.gZE.getParent()).removeView(this.gZE);
                this.gZE = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bIj() {
        if (this.mStatus == 1) {
            if (this.gZD == null && this.gZi != null && (this.gZi instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.gZi, true);
                this.gZD = this.gZi.findViewById(R.id.lay_jindu);
                this.gZF = (TextView) this.gZD.findViewById(R.id.show_time);
                this.gZI = (ImageView) this.gZD.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.gZE == null && this.gZi != null && (this.gZi instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.gZi, true);
            this.gZE = this.gZi.findViewById(R.id.lay_voice);
            this.gZH = (ImageView) this.gZE.findViewById(R.id.arrow_voice_icon);
            this.gZG = (SeekBar) this.gZE.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        this.iog = onClickListener;
    }

    public void pG(boolean z) {
        this.iof = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.ion != null) {
                c.this.ion.onStart();
            }
            if (c.this.SD && c.this.Sr) {
                if (c.this.mStatus == 1) {
                    c.this.caV();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aL(f2);
                    }
                } else {
                    if (c.this.SD) {
                        c.this.bIl();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gZK = c.this.dlM.getCurrentPosition();
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
            if (!c.this.ioF) {
                if (c.this.ioo != null && c.this.ioo.bXl()) {
                    return true;
                }
                c.this.bXa();
                c.this.caX();
                if (c.this.dlM.isPlaying()) {
                    c.this.caS();
                } else {
                    c.this.caT();
                }
                if (c.this.iop != null) {
                    c.this.iop.kL(c.this.dlM.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.ioF) {
                if (c.this.Sr) {
                    if (c.this.ioo != null && c.this.ioo.bXm()) {
                        return true;
                    }
                    c.this.caR();
                    if (c.this.dlM.isPlaying()) {
                        c.this.caS();
                    } else {
                        c.this.caT();
                    }
                    if (c.this.iop != null) {
                        c.this.iop.kL(c.this.dlM.isPlaying());
                    }
                } else {
                    c.this.bXa();
                    c.this.caX();
                    if (c.this.currentState != 1) {
                        c.this.caT();
                        c.this.caU();
                    } else {
                        c.this.bIA();
                    }
                    if (c.this.iop != null) {
                        c.this.iop.kL(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIl() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gZi.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gZi.setSystemUiVisibility(4);
        } else {
            this.gZi.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(float f2) {
        if (!this.Sr) {
            this.mStatus = 0;
            return;
        }
        bIj();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gZP == 0) {
            if (f2 > 0.0f && this.gZO < this.gZJ) {
                this.gZO++;
            }
            if (f2 < 0.0f && this.gZO > 0) {
                this.gZO--;
            }
        }
        if (this.mProgress > 0) {
            this.gZH.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.gZH.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gZO, 0);
        this.gZG.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.gZK += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gZL = 1;
            } else {
                this.gZK += 1000;
                this.gZL = 2;
            }
            if (this.gZK < 0) {
                this.gZK = 0;
            } else if (this.gZK > this.dlM.getDuration()) {
                this.gZK = this.dlM.getDuration();
            }
        }
        bIj();
        String yu = this.gZk.yu(this.gZK);
        if (f2 > 0.0f) {
            this.gZI.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.gZI.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(yu)) {
            this.gZF.setText(new StringBuilder().append(yu).append("/").append(this.gZk.yu(this.dlM.getDuration())));
        }
        this.gZk.setCurrentDuration(this.gZK, z ? false : true);
        caV();
        caK();
    }

    protected View ap(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bVa = str;
        this.bVM = str2;
    }

    public void caE() {
        if (this.dlM != null) {
            this.dlM.caE();
        }
    }

    public void setFid(String str) {
        this.eAC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        int i2 = 100;
        if (this.dlM != null && this.deD != null && this.gZk != null) {
            this.gZk.showProgress();
            this.mStartPosition = y.cbW().Cm(this.bVa);
            if (this.ioC) {
                this.deD.setVolume(1.0f, 1.0f);
                this.dlM.start();
                this.ioC = false;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sx);
                com.baidu.adp.lib.g.e.iB().postDelayed(this.Sx, 20L);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioJ);
                if (this.dlM.cbs()) {
                    this.currentState = 1;
                    this.dlM.setRecoveryState(1);
                    caV();
                }
                this.mStartPosition = y.cbW().Cm(this.bVa);
                this.gZk.setPlayer(this.dlM);
                if (this.mStartPosition != 0 && !this.deD.isPlayerReuse()) {
                    this.iow = true;
                }
                if (!this.ioB) {
                    this.gZk.showProgress();
                }
                if (!this.iof && this.deD.getDuration() <= 0) {
                    bIn().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.deD.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.Ss = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw() {
        if (this.gZv.getVisibility() != 8) {
            this.Sr = true;
            this.gZl.setVisibility(8);
            this.eAh.setVisibility(8);
            this.cIt.cbR();
            this.gZv.setVisibility(8);
            caW();
            if (caY()) {
                this.exn.a(this.bVM, -1L, this.dlM.getDuration() / 1000, "middle", this.dlM);
            }
            this.gZk.showProgress();
            this.inW.setVisibility(0);
            if (this.gZw != null) {
                this.gZw.onPrepared(this.dlM.getPlayer());
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

    protected void pH(boolean z) {
        if (hasNavBar(this.mActivity) && (this.inX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.inX.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.inX.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.inX.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.inX.setLayoutParams(layoutParams);
        }
    }

    public void bXa() {
        if (this.dlM.isPlaying()) {
            pausePlay();
            if (this.iot != null) {
                this.iot.onPause();
            }
            if (this.iok != null) {
                this.iok.onPaused();
            }
        } else if (this.Sr) {
            bIv();
            if (this.hWZ != null) {
                this.hWZ.bml();
            }
            if (this.iok != null) {
                this.iok.aFn();
            }
        } else {
            caO();
        }
    }

    public boolean caF() {
        return this.gZR;
    }

    public void bIm() {
        this.gZR = true;
        if (this.ddP != null) {
            this.ddP.bIm();
        }
    }

    public boolean caG() {
        return this.deD != null && this.dlM.getHeight() > this.dlM.getWidth();
    }

    public void caH() {
        pH(false);
        caJ();
    }

    public boolean yo(int i2) {
        switch (i2) {
            case 4:
                if (this.SD) {
                    if (caG()) {
                        pH(false);
                        caJ();
                    } else {
                        bIm();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.gZJ <= 0 || this.gZG == null) {
                    return false;
                }
                this.gZO = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.gZO * 100.0d) / this.gZJ);
                this.gZG.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dlM;
    }

    public VideoListMediaControllerView bIn() {
        return this.gZk;
    }

    public void show() {
        this.gZi.setVisibility(0);
    }

    public void bIr() {
        if (this.gZt != null) {
            ViewGroup.LayoutParams layoutParams = this.gZt.getLayoutParams();
            this.gZn = (FrameLayout.LayoutParams) this.gZi.getLayoutParams();
            this.gZn.width = layoutParams.width;
            this.gZn.height = layoutParams.height;
            this.gZn.topMargin = 0;
            this.gZi.setLayoutParams(this.gZn);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.gZR) {
            if (this.SD) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.gZR = false;
        }
        if (configuration.orientation == 2) {
            caI();
        } else {
            caJ();
        }
        caK();
        bIv();
        caX();
        bIA();
        if (this.iop != null) {
            this.iop.kL(true);
        }
    }

    protected void caI() {
        this.SD = true;
        int r = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.r(this.mActivity) : 0;
        if (caG()) {
            this.gZi.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.gZi.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - r, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.eAc.setVisibility(0);
        this.gZy.setVisibility(0);
        this.gZz.setVisibility(0);
        this.gZm.setVisibility(8);
        this.cIt.cbS();
        this.gZv.setVisibility(8);
        this.gZq.setImageResource(R.drawable.icon_video_narrow_white);
        vY(this.gZN);
        bIl();
        if (this.ioh != null) {
            this.ioh.pe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caJ() {
        this.SD = false;
        if (this.gZn != null) {
            this.gZi.setLayoutParams(this.gZn);
        }
        g(this.mActivity, false);
        this.eAc.setVisibility(8);
        this.gZm.setVisibility(0);
        this.cIt.cbS();
        this.gZv.setVisibility(8);
        this.gZq.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.gZk != null && (this.gZk.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZk.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.gZk.setLayoutParams(layoutParams);
        }
        this.gZi.setSystemUiVisibility(0);
        caD();
        if (this.ioh != null) {
            this.ioh.pf();
        }
    }

    public void caK() {
        if (this.dlM != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mActivity);
            if (this.SD) {
                af = com.baidu.adp.lib.util.l.ah(this.mActivity);
            }
            this.inW.setMax(af);
            int duration = this.dlM.getDuration();
            if (duration > 0) {
                if (this.inZ.getVisibility() == 0) {
                    this.inW.setProgress(this.inW.getMax());
                } else {
                    this.inW.setProgress((int) ((this.dlM.getCurrentPosition() * this.inW.getMax()) / duration));
                }
            }
        }
    }

    private void vY(int i2) {
        if (this.gZk != null && (this.gZk.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZk.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.gZk.setLayoutParams(layoutParams);
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

    public boolean bIt() {
        return !this.SD;
    }

    public void a(g.f fVar) {
        this.gZw = fVar;
    }

    public void a(g.a aVar) {
        this.ioc = aVar;
    }

    public void a(g.b bVar) {
        this.iod = bVar;
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
        if (this.iox) {
            dQ(str, str2);
        } else {
            cr(str, str2);
        }
        if (eVar != null) {
            eVar.pP(z);
        }
    }

    public void dP(String str, String str2) {
    }

    public void cr(String str, String str2) {
        caP();
        this.ioC = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dlM.setVideoPath(str, str2);
        this.exn.bMm();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
        if (this.ioj > 0) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gZU, this.ioj);
        }
        if (this.iok != null) {
            this.iok.onStarted();
        }
        this.cIt.startLoading();
        pI(true);
    }

    public void dQ(String str, String str2) {
        caP();
        this.ioC = true;
        this.currentState = 0;
        this.dlM.setRecoveryState(0);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
        if (this.ioj > 0) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gZU, this.ioj);
        }
        if (this.iok != null) {
            this.iok.onStarted();
        }
        this.cIt.startLoading();
        pI(true);
    }

    public void caL() {
        bIv();
        this.inW.setVisibility(0);
    }

    public void bIv() {
        int i2 = 100;
        if (this.dlM != null && this.gZk != null) {
            this.Sr = true;
            this.currentState = 1;
            this.dlM.setRecoveryState(1);
            this.dlM.start();
            if (this.deD != null && this.gZk != null) {
                this.mStartPosition = y.cbW().Cm(this.bVa);
                if (this.mStartPosition != 0 && !this.deD.isPlayerReuse()) {
                    this.iow = true;
                }
                if (this.mStartPosition > 100 && this.deD.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.Ss = i2;
            } else {
                this.Ss = 100;
            }
            this.cIt.cbS();
            pI(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.jS() && this.ioA && !StringUtils.isNull(this.bVa) && !StringUtils.isNull(this.bVM)) {
            this.ioA = false;
            this.ioB = true;
            cr(this.bVa, this.bVM);
        }
    }

    private void pI(boolean z) {
        if (z) {
            this.gZv.setVisibility(0);
            caV();
            this.inW.setProgress(0);
        } else {
            this.gZv.setVisibility(8);
        }
        this.gZk.showProgress();
        this.gZl.setVisibility(8);
        this.ioa.setVisibility(8);
        this.inZ.setVisibility(8);
        this.iob.setVisibility(8);
        this.eAh.setVisibility(8);
    }

    private void caM() {
        this.cIt.cbS();
        this.ioa.setVisibility(8);
        this.inZ.setVisibility(8);
        this.iob.setVisibility(8);
        caX();
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
        caM();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dlM.setRecoveryState(5);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sx);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioJ);
        this.dlM.stopPlayback();
        this.Sr = false;
        this.ioC = false;
        this.mStartPosition = 0;
        bvu();
    }

    public void caN() {
        if (this.dlM.getDuration() >= this.dlM.getCurrentPosition()) {
            y.cbW().bf(this.bVa, this.dlM.getCurrentPosition());
        }
    }

    public void pJ(boolean z) {
        this.iov = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(boolean z) {
        if (this.gZr != null) {
            this.gZl.setVisibility(0);
            this.ioa.setVisibility(8);
            this.inZ.setVisibility(8);
            this.iob.setVisibility(8);
            this.cIt.cbS();
            caV();
            this.inW.setVisibility(8);
            this.eAh.setVisibility(8);
            this.gZk.aBP();
            this.gZv.setVisibility(z ? 0 : 8);
        }
    }

    public void bvu() {
        pK(true);
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
        this.ion = kVar;
    }

    public void a(j jVar) {
        this.iom = jVar;
    }

    public void a(i iVar) {
        this.hWZ = iVar;
    }

    public void a(g gVar) {
        this.iot = gVar;
    }

    public void a(h hVar) {
        this.iol = hVar;
    }

    public void BI(String str) {
        this.hWz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caO() {
        a(this.bVa, this.bVM, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.ioi = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        caP();
        if (com.baidu.adp.lib.util.j.jU() && !com.baidu.tieba.video.g.cqT().cqU()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.agM().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.iox = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ios != null) {
                    this.ios.kh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.mD(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.caQ();
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
            } else if (this.ios != null) {
                this.ios.kh(true);
                return;
            } else {
                if (!this.inV) {
                    this.inV = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.ior != null) {
            this.ior.bmi();
        }
    }

    private void caP() {
        if (com.baidu.adp.lib.util.j.jU()) {
            com.baidu.tieba.video.g.cqT().en(this.mActivity);
        }
    }

    public void caQ() {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.gZv.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZY);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Sx);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZU);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioI);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioJ);
        this.ddP.stop();
        gZQ.unregister(this.mActivity);
    }

    public void Ch(String str) {
        this.gZz.setText(str);
    }

    public boolean bIw() {
        return this.Sr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caR() {
        if (this.gZr != null) {
            if (this.ioe) {
                caV();
            } else {
                caU();
            }
        }
    }

    public void bIA() {
        caU();
        caS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caS() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZY);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.gZY, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caT() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZY);
    }

    public void caU() {
        if (this.gZr != null && !this.ioe && !this.ioG) {
            pL(true);
            bIz();
            this.gZr.setVisibility(0);
            this.inX.setVisibility(0);
            this.inW.setVisibility(8);
            this.ioe = true;
            if (this.ioi != null) {
                this.ioi.ki(false);
            }
        }
    }

    public void bIx() {
        if (this.gZr != null && this.ioe) {
            pL(false);
            bIz();
            this.gZr.setVisibility(8);
            this.inX.setVisibility(8);
            this.inW.setVisibility(0);
            this.fuA.setAnimationListener(this.gZW);
            this.gZr.startAnimation(this.fuA);
            this.ioe = false;
            if (this.ioi != null) {
                this.ioi.bmk();
            }
        }
    }

    public void caV() {
        if (this.gZr != null && this.ioe) {
            this.afk.cancel();
            this.fuA.cancel();
            pL(false);
            bIz();
            this.gZr.setVisibility(8);
            this.inX.setVisibility(8);
            this.inW.setVisibility(0);
            this.ioe = false;
            if (this.ioi != null) {
                this.ioi.bmk();
            }
        }
    }

    private void bIz() {
        if (this.gZr != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gZY);
            this.afk.setAnimationListener(null);
            this.fuA.setAnimationListener(null);
            this.gZr.clearAnimation();
        }
    }

    private void caW() {
        if (this.gZr != null) {
            this.afk.setAnimationListener(null);
            this.fuA.setAnimationListener(null);
            this.gZr.clearAnimation();
        }
    }

    public void pL(boolean z) {
        caX();
        if (z) {
            this.inY.setVisibility(0);
        } else {
            this.inY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caX() {
        if (this.currentState == 1) {
            this.inY.setState(1);
        } else {
            this.inY.setState(0);
        }
    }

    public void a(InterfaceC0387c interfaceC0387c) {
        this.ioh = interfaceC0387c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void ad(boolean z, boolean z2) {
        if (this.ddP != null) {
            if (this.gZq != null) {
                this.gZq.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.gZk != null && (this.gZk.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZk.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds52);
                this.gZk.setLayoutParams(layoutParams);
            }
            this.ddP.pR(z);
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

    public void pM(boolean z) {
        this.ioF = z;
    }

    public void a(m mVar) {
        this.ioo = mVar;
    }

    public void a(a aVar) {
        this.iop = aVar;
    }

    public void a(n nVar) {
        this.ioq = nVar;
    }

    public void a(l lVar) {
        this.ior = lVar;
    }

    public void a(f fVar) {
        this.ios = fVar;
    }

    public void pN(boolean z) {
        this.ioz = z;
    }

    public boolean caY() {
        return this.iof;
    }

    public void pO(boolean z) {
        this.iof = z;
    }

    public void yp(int i2) {
        this.ioD = i2;
    }

    public View caZ() {
        return this.gZi;
    }

    public void a(o oVar) {
        this.iok = oVar;
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
        this.hWN = pVar;
    }

    public void cba() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
    }
}
