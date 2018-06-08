package com.baidu.tieba.play;

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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int eJS;
    private String aVt;
    private o bHE;
    private String biU;
    private QuickVideoView bti;
    private View cAS;
    private ImageView cAT;
    private View cAX;
    private com.baidu.tieba.play.g cxZ;
    private w cye;
    private Animation dlA;
    private Animation dlz;
    private TextView eJA;
    private View eJF;
    private View eJG;
    private TextView eJH;
    private SeekBar eJI;
    private ImageView eJJ;
    private ImageView eJK;
    private int eJL;
    private int eJQ;
    private int eJR;
    private CallStateReceiver eJT;
    private VideoListMediaControllerView eJm;
    private View eJn;
    private FrameLayout eJo;
    protected FrameLayout.LayoutParams eJp;
    private ImageView eJr;
    private ImageView eJs;
    private View eJt;
    private View eJv;
    private TbImageView eJw;
    private g.f eJx;
    private ImageView eJz;
    private h fJl;
    private boolean gaA;
    private boolean gaB;
    private int gaC;
    private boolean gaD;
    private boolean gaE;
    private ProgressBar gaa;
    private View gab;
    private View gac;
    private TextView gad;
    private TextView gae;
    private TextView gaf;
    private g.a gag;
    private g.b gah;
    private View.OnClickListener gaj;
    private b gak;
    private InterfaceC0217c gal;
    private g gam;
    private i gan;
    private j gao;
    private l gap;
    private k gaq;
    private e gar;
    private f gas;
    private TextView gax;
    private boolean gaz;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    public View mMainView;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fZZ = false;
    protected boolean dUT = false;
    private boolean eJB = false;
    private boolean eJD = false;
    private boolean gai = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eJM = 0;
    private int eJN = 0;
    private boolean eJU = false;
    private boolean gat = true;
    private boolean gau = true;
    private boolean gav = false;
    private boolean gaw = false;
    private String fIP = null;
    private int avC = -1;
    private boolean gay = false;
    private g.f bhz = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cxZ = gVar;
            if (c.this.bkR()) {
                c.this.cye.blT();
                c.this.gaD = true;
                return;
            }
            c.this.aiQ();
        }
    };
    private VideoLoadingProgressView.a cyp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aiQ();
        }
    };
    private Runnable eJW = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bti.getCurrentPosition() > 100) {
                c.this.eJB = true;
                c.this.eJn.setVisibility(8);
                c.this.cAX.setVisibility(8);
                c.this.cye.blU();
                c.this.eJw.setVisibility(8);
                c.this.aQD();
                if (c.this.avC == 1 || c.this.avC == 2) {
                    if (c.this.eJt != null) {
                        c.this.eJt.setVisibility(0);
                        c.this.gac.setVisibility(0);
                        c.this.gaa.setVisibility(8);
                        if (c.this.gal != null) {
                            c.this.gal.fM(false);
                        }
                    }
                    c.this.eJm.showProgress();
                    c.this.aQE();
                }
                if (c.this.eJx != null) {
                    c.this.eJx.onPrepared(c.this.bti.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.im().postDelayed(c.this.eJW, 20L);
        }
    };
    private g.a bhy = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eJB = false;
            c.this.gaB = false;
            c.this.mStartPosition = 0;
            c.this.aQl();
            c.this.eJn.setVisibility(0);
            c.this.gaa.setVisibility(8);
            c.this.gaa.setProgress(c.this.gaa.getMax());
            if (c.this.gal != null) {
                c.this.gal.fM(false);
            }
            if (c.this.dUT) {
                c.this.eJt.setVisibility(0);
                c.this.eJz.setVisibility(0);
                c.this.eJA.setVisibility(0);
                c.this.gac.setVisibility(8);
            } else {
                c.this.eJt.setVisibility(8);
                c.this.eJz.setVisibility(8);
                c.this.eJA.setVisibility(8);
                c.this.gac.setVisibility(8);
            }
            if (c.this.bti == null || c.this.bti.getDuration() > 150000) {
                c.this.lw(false);
            } else {
                c.this.gad.setVisibility(0);
            }
            x.blZ().remove(c.this.biU);
            if (c.this.gag != null) {
                c.this.gag.onCompletion(gVar);
            }
            c.this.avC = 3;
            c.this.bti.setRecoveryState(3);
            if (!c.this.dUT && c.this.bti != null && c.this.bti.getDuration() <= 150000) {
                if (!c.this.gay) {
                    if (c.this.gan != null) {
                        c.this.gan.kT(true);
                    }
                    c.this.bT(c.this.biU, c.this.aVt);
                    return;
                }
                c.this.avC = 5;
                c.this.bti.setRecoveryState(5);
                c.this.bti.getPlayer().pause();
                c.this.bti.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eJX = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cAX.setVisibility(0);
            c.this.cye.blV();
            c.this.avC = 4;
            c.this.bti.setRecoveryState(4);
            if (c.this.gah != null) {
                c.this.gah.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jD()) {
                c.this.gaz = true;
            }
            c.this.gaB = false;
            return true;
        }
    };
    private Runnable eJY = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.cAX.setVisibility(0);
            c.this.cye.blV();
        }
    };
    private g.InterfaceC0218g bhD = new g.InterfaceC0218g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0218g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gav) {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.gaF, 200L);
            }
        }
    };
    private Runnable gaF = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bti == null || !c.this.gav) {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.eJW, 200L);
                c.this.gav = false;
            } else if (c.this.mStartPosition != c.this.bti.getCurrentPosition()) {
                c.this.gav = false;
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.eJW, 20L);
            } else {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.gaF, 200L);
            }
        }
    };
    private QuickVideoView.b bts = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eJB = false;
            if (c.this.gai) {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.gaG, 300L);
            } else {
                c.this.gaB = false;
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(c.this.eJW);
            com.baidu.adp.lib.g.e.im().removeCallbacks(c.this.eJY);
        }
    };
    private Runnable gaG = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.gaB = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cAX.getId()) {
                c.this.bkZ();
            } else if (view.getId() != c.this.cAT.getId() && view.getId() != c.this.eJr.getId()) {
                if (view.getId() == c.this.gae.getId()) {
                    if (c.this.gam != null) {
                        c.this.gam.bhz();
                    }
                } else if (view.getId() == c.this.gad.getId()) {
                    if (c.this.gan != null) {
                        c.this.gan.kT(false);
                    }
                    c.this.bT(c.this.biU, c.this.aVt);
                } else if (view.getId() != c.this.eJs.getId() && view.getId() != c.this.gab.getId()) {
                    if (view.getId() != c.this.eJz.getId()) {
                        if (c.this.gaj != null) {
                            c.this.gaj.onClick(view);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new am("c11713"));
                    if (c.this.gaq != null) {
                        c.this.gaq.avc();
                    }
                    if (c.this.bkS()) {
                        c.this.bkU();
                        c.this.lt(false);
                        return;
                    }
                    c.this.aQp();
                } else {
                    if (c.this.dUT) {
                        TiebaStatic.log(new am("c11714"));
                    } else {
                        TiebaStatic.log(new am("c11710"));
                    }
                    if (c.this.gaq != null) {
                        c.this.gaq.avc();
                    }
                    if (c.this.bkS()) {
                        if (c.this.dUT) {
                            c.this.bkU();
                        } else {
                            c.this.bkT();
                        }
                        c.this.lt(c.this.dUT);
                        return;
                    }
                    c.this.aQp();
                }
            } else {
                c.this.bhq();
            }
        }
    };
    private Animation.AnimationListener eKa = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eJt != null) {
                c.this.eJt.setVisibility(8);
                c.this.gaa.setVisibility(0);
                c.this.eJD = false;
                if (c.this.gal != null) {
                    c.this.gal.avd();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eKb = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable eKc = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aQB();
        }
    };
    private CustomMessageListener eKd = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b eLX = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gu(int i2) {
            int duration;
            if (c.this.bti != null && (duration = c.this.bti.getDuration()) > 0 && c.this.gaa != null) {
                c.this.gaa.setProgress((int) ((i2 * c.this.mMainView.getWidth()) / duration));
            }
            c.this.oO(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener blO = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eJD) {
                c.this.aQE();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aQA() && c.this.aQq() != null) {
                c.this.setStartPosition(c.this.aQq().getSeekPosition());
                c.this.bT(c.this.biU, c.this.aVt);
            }
        }
    };
    private QuickVideoView.a gaH = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void blh() {
            if (!c.this.gay) {
                c.this.cye.startLoading();
                c.this.eJw.setVisibility(0);
                c.this.cAT.setVisibility(8);
                c.this.eJr.setImageResource(d.f.icon_video_suspend_n);
                c.this.gae.setVisibility(8);
                c.this.gad.setVisibility(8);
                c.this.gaf.setVisibility(8);
                c.this.cAX.setVisibility(8);
                com.baidu.adp.lib.g.e.im().removeCallbacks(c.this.eJY);
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.eJY, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void auZ();

        void ava();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0217c {
        void avd();

        void fM(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lz(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fL(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface g {
        void bhz();
    }

    /* loaded from: classes.dex */
    public interface h {
        void ave();
    }

    /* loaded from: classes.dex */
    public interface i {
        void kT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface j {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface k {
        void avb();

        void avc();
    }

    /* loaded from: classes.dex */
    public interface l {
        void bhA();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eJQ = 0;
        this.gaE = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mMainView = q(tbPageContext);
            this.mRootView = view;
            this.gaE = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.mMainView);
            }
            this.eJv = view;
            this.mMainView.setOnClickListener(this.mOnClickListener);
            this.bti = (QuickVideoView) this.mMainView.findViewById(d.g.videoView);
            this.cye = new w((ViewGroup) this.mMainView.findViewById(d.g.auto_video_loading_container));
            this.cye.setLoadingAnimationListener(this.cyp);
            this.eJm = (VideoListMediaControllerView) this.mMainView.findViewById(d.g.media_controller);
            this.eJm.setPlayer(this.bti);
            this.gaa = (ProgressBar) this.mMainView.findViewById(d.g.pgrBottomProgress);
            this.gaa.setMax(com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()));
            this.gaa.setProgress(0);
            this.eJm.setOnSeekBarChangeListener(this.blO);
            this.eJm.setOnProgressUpdatedListener(this.eLX);
            this.eJn = this.mMainView.findViewById(d.g.black_mask);
            this.cAX = this.mMainView.findViewById(d.g.layout_error);
            this.cAX.setOnClickListener(this.mOnClickListener);
            this.gax = (TextView) this.mMainView.findViewById(d.g.auto_video_error_tips);
            this.eJo = (FrameLayout) this.mMainView.findViewById(d.g.danmu_container);
            this.eJr = (ImageView) this.mMainView.findViewById(d.g.img_play_icon);
            this.eJr.setOnClickListener(this.mOnClickListener);
            this.eJs = (ImageView) this.mMainView.findViewById(d.g.img_full_screen);
            this.eJs.setOnClickListener(this.mOnClickListener);
            this.gab = this.mMainView.findViewById(d.g.full_screen_container);
            this.gab.setOnClickListener(this.mOnClickListener);
            this.eJt = this.mMainView.findViewById(d.g.layout_media_controller);
            this.gac = this.mMainView.findViewById(d.g.time_show_controller);
            this.bti.setOnPreparedListener(this.bhz);
            this.bti.setOnCompletionListener(this.bhy);
            this.bti.setOnErrorListener(this.eJX);
            this.bti.setOnSeekCompleteListener(this.bhD);
            this.bti.setOnSurfaceDestroyedListener(this.bts);
            this.bti.setOnRecoveryCallback(this.gaH);
            this.cAT = (ImageView) this.mMainView.findViewById(d.g.img_play);
            this.cAT.setOnClickListener(this.mOnClickListener);
            this.gad = (TextView) this.mMainView.findViewById(d.g.txt_replay);
            this.gad.setOnClickListener(this.mOnClickListener);
            this.gae = (TextView) this.mMainView.findViewById(d.g.txt_playnext);
            this.gae.setOnClickListener(this.mOnClickListener);
            this.gaf = (TextView) this.mMainView.findViewById(d.g.txt_next_video_title);
            this.eJw = (TbImageView) this.mMainView.findViewById(d.g.video_thumbnail);
            this.eJw.setDefaultErrorResource(0);
            this.eJw.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            this.mScreenHeight = bM(this.mContext.getPageActivity());
            this.eJz = (ImageView) this.mMainView.findViewById(d.g.img_exit);
            this.eJz.setOnClickListener(this.mOnClickListener);
            this.eJA = (TextView) this.mMainView.findViewById(d.g.video_title);
            this.cAS = this.mMainView.findViewById(d.g.layout_title);
            this.cAS.setVisibility(8);
            this.dlz = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dlA = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eJL = this.mAudioManager.getStreamMaxVolume(3);
            this.eJR = this.mAudioManager.getStreamVolume(3);
            eJS = 100 / this.eJL;
            this.mMainView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.gao != null) {
                        c.this.gao.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eJB) {
                            if (c.this.mStatus == 1 && c.this.eJN != 0) {
                                c.this.b(c.this.eJN == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eJN = 0;
                                c.this.eJM = 0;
                            }
                            if (!c.this.bti.isPlaying() && 8 == c.this.cAT.getVisibility()) {
                                c.this.cAT.setVisibility(0);
                                c.this.gae.setVisibility(8);
                                c.this.gad.setVisibility(8);
                                c.this.gaf.setVisibility(8);
                            }
                        }
                        c.this.aQl();
                        if (c.this.gao != null) {
                            c.this.gao.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bHE = new o(this.mContext.getPageActivity());
            if (this.gaE) {
                this.bHE.start();
            }
            this.eJQ = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds16);
            this.eJT = new CallStateReceiver();
            this.eJT.register(this.mContext.getPageActivity());
            this.mContext.registerListener(this.eKd);
            bkQ();
        }
    }

    public void bkQ() {
        if (this.gat) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.mMainView.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.mMainView.setSystemUiVisibility(0);
    }

    public void ls(boolean z) {
        this.gat = z;
        bkQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        this.mStatus = 0;
        if (this.eJF != null && this.eJF.getParent() != null && (this.eJF.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eJF.getParent()).removeView(this.eJF);
                this.eJF = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eJG != null && this.eJG.getParent() != null && (this.eJG.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eJG.getParent()).removeView(this.eJG);
                this.eJG = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aQm() {
        if (this.mStatus == 1) {
            if (this.eJF == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
                LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.float_video_window_jindu, (ViewGroup) this.mMainView, true);
                this.eJF = this.mMainView.findViewById(d.g.lay_jindu);
                this.eJH = (TextView) this.eJF.findViewById(d.g.show_time);
                this.eJK = (ImageView) this.eJF.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eJG == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
            LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.float_video_window_voice, (ViewGroup) this.mMainView, true);
            this.eJG = this.mMainView.findViewById(d.g.lay_voice);
            this.eJJ = (ImageView) this.eJG.findViewById(d.g.arrow_voice_icon);
            this.eJI = (SeekBar) this.eJG.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        this.gaj = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gao != null) {
                c.this.gao.onStart();
            }
            if (c.this.dUT && c.this.eJB) {
                if (!c.this.bti.isPlaying() && c.this.cAT.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cAT.setVisibility(8);
                    c.this.gae.setVisibility(8);
                    c.this.gad.setVisibility(8);
                    c.this.gaf.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ap(f2);
                    }
                } else {
                    if (c.this.dUT) {
                        c.this.aQo();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eJM = c.this.bti.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ap(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.gap != null) {
                c.this.gap.bhA();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eJB) {
                if (c.this.avC != 2) {
                    c.this.blc();
                } else {
                    c.this.bhq();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mMainView.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mMainView.setSystemUiVisibility(4);
        } else {
            this.mMainView.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f2) {
        if (!this.eJB) {
            this.mStatus = 0;
            return;
        }
        aQm();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eJS == 0) {
            if (f2 > 0.0f && this.eJR < this.eJL) {
                this.eJR++;
            }
            if (f2 < 0.0f && this.eJR > 0) {
                this.eJR--;
            }
        }
        if (this.mProgress > 0) {
            this.eJJ.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eJJ.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eJR, 0);
        this.eJI.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eJM += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eJN = 1;
            } else {
                this.eJM += 1000;
                this.eJN = 2;
            }
            if (this.eJM < 0) {
                this.eJM = 0;
            } else if (this.eJM > this.bti.getDuration()) {
                this.eJM = this.bti.getDuration();
            }
        }
        aQm();
        String rC = this.eJm.rC(this.eJM);
        if (f2 > 0.0f) {
            this.eJK.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eJK.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rC)) {
            this.eJH.setText(new StringBuilder().append(rC).append("/").append(this.eJm.rC(this.bti.getDuration())));
        }
        this.eJm.setCurrentDuration(this.eJM, z ? false : true);
        this.eJt.setVisibility(8);
        this.gaa.setVisibility(0);
        bkV();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.float_video_container, (ViewGroup) null);
    }

    public void bS(String str, String str2) {
        this.biU = str;
        this.aVt = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkR() {
        if (this.gai) {
            return this.gaC == 0 && !this.gaD;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        if (this.bti != null && this.cxZ != null) {
            if (this.gaB) {
                this.bti.start();
                this.gaB = false;
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJW);
            com.baidu.adp.lib.g.e.im().postDelayed(this.eJW, 20L);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJY);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaG);
            if (this.bti.bly()) {
                this.avC = 1;
                this.bti.setRecoveryState(1);
            }
            if (this.cxZ != null && this.eJm != null) {
                this.mStartPosition = x.blZ().sl(this.biU);
                this.eJm.R(this.mStartPosition, this.cxZ.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bti != null) {
                        this.bti.rB(this.mStartPosition);
                    } else {
                        this.cxZ.seekTo(this.mStartPosition);
                    }
                    if (!this.gaA) {
                        this.eJm.showProgress();
                        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJW);
                    }
                    this.gav = true;
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (hasNavBar(this.mContext.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gac.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mContext.getPageActivity());
                this.gac.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gac.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.gac.setLayoutParams(layoutParams);
        }
    }

    public void bhq() {
        if (!com.baidu.adp.lib.util.j.jD()) {
            com.baidu.adp.lib.util.l.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(d.k.neterror));
        } else if (this.bti.isPlaying()) {
            pausePlay();
            if (this.gas != null) {
                this.gas.onPause();
            }
        } else if (this.eJB) {
            aQz();
            if (this.fJl != null) {
                this.fJl.ave();
            }
        } else {
            bkZ();
        }
    }

    public void aQp() {
        this.eJU = true;
        if (this.bHE != null) {
            this.bHE.aQp();
        }
    }

    public boolean bkS() {
        return this.cxZ != null && this.cxZ.getVideoHeight() > this.cxZ.getVideoWidth();
    }

    public boolean ry(int i2) {
        switch (i2) {
            case 4:
                if (this.dUT) {
                    if (bkS()) {
                        lt(false);
                        bkU();
                    } else {
                        aQp();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eJL <= 0 || this.eJI == null) {
                    return false;
                }
                this.eJR = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eJR * 100.0d) / this.eJL);
                this.eJI.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bti;
    }

    public VideoListMediaControllerView aQq() {
        return this.eJm;
    }

    public void show() {
        this.mMainView.setVisibility(0);
    }

    public void aQu() {
        if (this.eJv != null) {
            ViewGroup.LayoutParams layoutParams = this.eJv.getLayoutParams();
            this.eJp = (FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
            this.eJp.width = layoutParams.width;
            this.eJp.height = layoutParams.height;
            this.eJp.topMargin = 0;
            this.mMainView.setLayoutParams(this.eJp);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eJU) {
            if (this.dUT) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.eJU = false;
        }
        if (configuration.orientation == 2) {
            bkT();
        } else {
            bkU();
        }
        if (this.bti.isPlaying()) {
            aQE();
        }
        bkV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkT() {
        this.dUT = true;
        if (bkS()) {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.mContext, true);
        this.eJt.setVisibility(0);
        this.cAS.setVisibility(0);
        this.eJz.setVisibility(0);
        this.eJA.setVisibility(0);
        this.eJo.setVisibility(8);
        if (this.gai) {
            this.cye.startLoading();
            this.eJw.setVisibility(0);
        } else {
            this.cye.blV();
            this.eJw.setVisibility(8);
        }
        if (this.gak != null) {
            this.gak.auZ();
        }
        this.eJs.setImageResource(d.f.icon_video_window);
        oM(this.eJQ);
        aQo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkU() {
        this.dUT = false;
        if (this.eJp != null) {
            this.mMainView.setLayoutParams(this.eJp);
        }
        a((TbPageContext) this.mContext, false);
        this.cAS.setVisibility(8);
        this.eJo.setVisibility(0);
        if (this.gai) {
            this.cye.startLoading();
            this.eJw.setVisibility(0);
        } else {
            this.cye.blV();
            this.eJw.setVisibility(8);
        }
        if (this.gak != null) {
            this.gak.ava();
        }
        if (this.avC == 3 && this.gal != null) {
            this.gal.fM(false);
        } else if (!this.eJB && this.eJt != null) {
            this.eJt.clearAnimation();
            this.eJt.setVisibility(4);
            this.gaa.setVisibility(0);
            if (this.gal != null) {
                this.gal.avd();
            }
        }
        aQl();
        this.eJs.setImageResource(d.f.icon_video_fullscreen);
        if (this.eJm != null && (this.eJm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJm.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.eJm.setLayoutParams(layoutParams);
        }
        this.mMainView.setSystemUiVisibility(0);
        bkQ();
    }

    public void bkV() {
        if (this.bti != null) {
            int ah = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            if (this.dUT) {
                ah = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
            }
            this.gaa.setMax(ah);
            int duration = this.bti.getDuration();
            if (duration > 0) {
                if (this.gad.getVisibility() == 0) {
                    this.gaa.setProgress(this.gaa.getMax());
                } else {
                    this.gaa.setProgress((int) ((this.bti.getCurrentPosition() * this.gaa.getMax()) / duration));
                }
            }
        }
    }

    private void oM(int i2) {
        if (this.eJm != null && (this.eJm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJm.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eJm.setLayoutParams(layoutParams);
        }
    }

    private void a(TbPageContext tbPageContext, boolean z) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = tbPageContext.getPageActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                tbPageContext.getPageActivity().getWindow().setAttributes(attributes);
                tbPageContext.getPageActivity().getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = tbPageContext.getPageActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            tbPageContext.getPageActivity().getWindow().setAttributes(attributes2);
            tbPageContext.getPageActivity().getWindow().clearFlags(512);
        }
    }

    public boolean aQw() {
        return !this.dUT;
    }

    public void a(g.f fVar) {
        this.eJx = fVar;
    }

    public void a(g.a aVar) {
        this.gag = aVar;
    }

    public void a(g.b bVar) {
        this.gah = bVar;
    }

    public void aQx() {
        this.eJr.setImageResource(d.f.icon_video_play);
        this.cye.blV();
        this.cAT.setVisibility(0);
        this.gae.setVisibility(8);
        this.gad.setVisibility(8);
        this.gaf.setVisibility(8);
        this.avC = 2;
        this.bti.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bti != null) {
            this.bti.setPbLoadingTime(currentTimeMillis);
        }
        bT(str, str2);
    }

    public void bT(String str, String str2) {
        bla();
        this.gaB = true;
        this.avC = 0;
        this.bti.setRecoveryState(0);
        bS(str, str2);
        this.bti.setVideoPath(str, str2);
        this.cye.startLoading();
        this.eJw.setVisibility(0);
        this.cAT.setVisibility(8);
        this.eJr.setImageResource(d.f.icon_video_suspend_n);
        this.gae.setVisibility(8);
        this.gad.setVisibility(8);
        this.gaf.setVisibility(8);
        this.cAX.setVisibility(8);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJY);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eJY, 60000L);
    }

    public void bU(String str, String str2) {
        bla();
        this.gaB = true;
        this.avC = 0;
        this.bti.setRecoveryState(0);
        this.cye.startLoading();
        this.eJw.setVisibility(0);
        this.cAT.setVisibility(8);
        this.eJr.setImageResource(d.f.icon_video_suspend_n);
        this.gae.setVisibility(8);
        this.gad.setVisibility(8);
        this.gaf.setVisibility(8);
        this.cAX.setVisibility(8);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJY);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eJY, 60000L);
    }

    public void aQz() {
        this.avC = 1;
        this.bti.setRecoveryState(1);
        this.bti.start();
        this.eJr.setImageResource(d.f.icon_video_suspend_n);
        this.eJw.setVisibility(8);
        this.eJn.setVisibility(8);
        this.cye.blV();
        this.eJm.showProgress();
        this.cAT.setVisibility(8);
        this.gae.setVisibility(8);
        this.gad.setVisibility(8);
        this.gaf.setVisibility(8);
        ble();
    }

    public void bkW() {
        if (com.baidu.adp.lib.util.j.jD() && this.gaz && !StringUtils.isNull(this.biU) && !StringUtils.isNull(this.aVt)) {
            this.gaz = false;
            this.gaA = true;
            bT(this.biU, this.aVt);
        }
    }

    public void lu(boolean z) {
        if (this.bti != null) {
            this.bti.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bti.isPlaying() && this.gau) {
            bkX();
        }
        bld();
        this.bti.pause();
        aQx();
    }

    public void stopPlay() {
        if (this.bti.isPlaying() && this.gau) {
            bkX();
        }
        this.avC = 5;
        this.bti.setRecoveryState(5);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJW);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJY);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaG);
        this.bti.stopPlayback();
        this.eJB = false;
        this.gaB = false;
        this.mStartPosition = 0;
        aDt();
    }

    public void bkX() {
        x.blZ().aG(this.biU, this.bti.getCurrentPosition());
    }

    public void lv(boolean z) {
        this.gau = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(boolean z) {
        if (this.eJt != null) {
            this.eJn.setVisibility(0);
            this.cAT.setVisibility(0);
            this.gae.setVisibility(8);
            this.gad.setVisibility(8);
            this.gaf.setVisibility(8);
            this.cye.blV();
            this.eJr.setImageResource(d.f.icon_video_play);
            this.eJt.setVisibility(4);
            this.gaa.setVisibility(8);
            this.cAX.setVisibility(8);
            this.eJm.QC();
            this.eJw.setVisibility(z ? 0 : 8);
        }
    }

    public void aDt() {
        lw(true);
    }

    public boolean bkY() {
        if (this.bti == null) {
            return false;
        }
        return this.bti.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bti == null) {
            return 0;
        }
        return this.bti.getCurrentPosition();
    }

    public void a(j jVar) {
        this.gao = jVar;
    }

    public void a(i iVar) {
        this.gan = iVar;
    }

    public void a(h hVar) {
        this.fJl = hVar;
    }

    public void a(f fVar) {
        this.gas = fVar;
    }

    public void a(g gVar) {
        this.gam = gVar;
    }

    public void rN(String str) {
        this.fIP = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        a(this.biU, this.aVt, null, new Object[0]);
    }

    public void b(InterfaceC0217c interfaceC0217c) {
        this.gal = interfaceC0217c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        bla();
        if (com.baidu.adp.lib.util.j.jF() && !com.baidu.tieba.video.f.bBb().bBc()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gaw = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gar != null) {
                    this.gar.fL(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(TbadkCoreApplication.getInst().getString(d.k.play_video_mobile_tip));
                aVar.a(d.k.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.blb();
                        if (c.this.gaw) {
                            c.this.bU(str, str2);
                        } else {
                            c.this.bT(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lz(false);
                        }
                    }
                });
                aVar.b(d.k.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xa();
                return;
            } else if (this.gar != null) {
                this.gar.fL(true);
                return;
            } else {
                if (!this.fZZ) {
                    this.fZZ = true;
                    com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.play_video_mobile_tip2);
                }
                if (this.gaw) {
                    bU(str, str2);
                } else {
                    bT(str, str2);
                }
                if (dVar != null) {
                    dVar.lz(true);
                    return;
                }
                return;
            }
        }
        if (this.gaw) {
            bU(str, str2);
        } else {
            bT(str, str2);
        }
        if (dVar != null) {
            dVar.lz(true);
        }
        if (this.gaq != null) {
            this.gaq.avb();
        }
    }

    private void bla() {
        if (com.baidu.adp.lib.util.j.jF()) {
            com.baidu.tieba.video.f.bBb().cm(this.mContext.getPageActivity());
        }
    }

    public void blb() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void pq(String str) {
        this.eJw.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eKc);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJW);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eJY);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaF);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaG);
        this.bHE.stop();
        this.eJT.unregister(this.mContext.getPageActivity());
    }

    public void sh(String str) {
        this.eJA.setText(str);
    }

    public boolean aQA() {
        return this.eJB;
    }

    public void aQB() {
        if (this.eJt != null) {
            aQD();
            this.eJt.setVisibility(0);
            this.gac.setVisibility(0);
            if (this.gal != null) {
                this.gal.fM(true);
            }
            this.gaa.setVisibility(8);
            this.dlz.setAnimationListener(this.eKa);
            this.eJt.startAnimation(this.dlz);
            this.eJD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blc() {
        if (this.eJt != null) {
            if (this.eJt.getVisibility() == 0) {
                aQD();
                this.eJt.setVisibility(8);
                this.gaa.setVisibility(0);
                if (this.gal != null) {
                    this.gal.avd();
                    return;
                }
                return;
            }
            aQE();
        }
    }

    public void aQC() {
        if (this.eJt != null) {
            aQD();
            this.eJt.setVisibility(0);
            this.gac.setVisibility(0);
            if (this.gal != null) {
                this.gal.fM(false);
            }
            this.gaa.setVisibility(8);
            this.dlA.setAnimationListener(this.eKb);
            this.eJt.startAnimation(this.dlA);
        }
    }

    public void bld() {
        if (this.eJt != null) {
            aQD();
            this.eJt.setVisibility(0);
            this.gac.setVisibility(0);
            this.gaa.setVisibility(8);
            if (this.gal != null) {
                this.gal.fM(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        if (this.eJt != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.eKc);
            this.dlA.setAnimationListener(null);
            this.dlz.setAnimationListener(null);
            this.eJt.clearAnimation();
            this.eJD = false;
        }
    }

    public void aQE() {
        aQC();
        ble();
    }

    private void ble() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eKc);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eKc, 3000L);
    }

    public void a(b bVar) {
        this.gak = bVar;
    }

    public void oO(int i2) {
        if (this.bti.getDuration() - i2 <= 3000) {
            aQD();
            if (this.eJt != null) {
                this.eJt.setVisibility(0);
                this.gac.setVisibility(0);
                this.gaa.setVisibility(8);
                if (this.gal != null) {
                    this.gal.fM(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void K(boolean z, boolean z2) {
        int i2 = 8;
        if (this.bHE != null) {
            if (this.eJs != null || this.gab != null) {
                this.eJs.setVisibility((z || !z2) ? 0 : 8);
                View view = this.gab;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.eJm != null && (this.eJm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJm.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds52);
                this.eJm.setLayoutParams(layoutParams);
            }
            this.bHE.lB(z);
        }
    }

    public int bM(Context context) {
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
            return com.baidu.adp.lib.util.l.aj(context);
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

    public int blf() {
        return this.avC;
    }

    public void a(l lVar) {
        this.gap = lVar;
    }

    public void a(k kVar) {
        this.gaq = kVar;
    }

    public void a(e eVar) {
        this.gar = eVar;
    }

    public void lx(boolean z) {
        this.gay = z;
    }

    public void ly(boolean z) {
        this.gai = z;
    }

    public void rz(int i2) {
        this.gaC = i2;
    }

    public void blg() {
        com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), this.eJr, 40, 40, 40, 40);
    }
}
