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
import com.baidu.tbadk.core.util.an;
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
    private static int hgT;
    private static CallStateReceiver hgU;
    private Animation afH;
    private String bWU;
    private String bWh;
    private x cJU;
    private com.baidu.tieba.play.o dfA;
    public com.baidu.tieba.play.g dgn;
    protected QuickVideoView dnB;
    private com.baidu.tieba.j.k eCt;
    private String eFF;
    private View eFf;
    protected View eFk;
    private Animation fAk;
    private g.f hgA;
    private ImageView hgC;
    private TextView hgD;
    private View hgH;
    private View hgI;
    private TextView hgJ;
    private SeekBar hgK;
    private ImageView hgL;
    private ImageView hgM;
    private int hgN;
    private int hgS;
    public View hgm;
    private VideoListMediaControllerView hgo;
    private View hgp;
    private FrameLayout hgq;
    protected FrameLayout.LayoutParams hgr;
    private ImageView hgu;
    private View hgv;
    private View hgx;
    private TbImageView hgz;
    private p iea;
    private i iem;
    protected InterfaceC0392c ivA;
    private d ivB;
    private o ivD;
    private h ivE;
    private j ivF;
    private k ivG;
    private m ivH;
    private a ivI;
    private n ivJ;
    private l ivK;
    private f ivL;
    private g ivM;
    private TextView ivR;
    private boolean ivT;
    private boolean ivU;
    private boolean ivV;
    private int ivW;
    private boolean ivX;
    private boolean ivY;
    private ProgressBar ivp;
    private View ivq;
    private SwitchImageView ivr;
    private TextView ivs;
    private TextView ivt;
    private TextView ivu;
    private g.a ivv;
    private g.b ivw;
    private View.OnClickListener ivz;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int SL = 100;
    private boolean ivo = false;
    protected boolean SY = false;
    private boolean SK = false;
    private boolean ivx = false;
    private boolean ivy = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int hgO = 0;
    private int hgP = 0;
    private long ivC = 60000;
    private int hgR = 0;
    private boolean hgV = false;
    private boolean ivN = true;
    private boolean ivO = true;
    private boolean ivP = false;
    private boolean ivQ = false;
    private String idM = null;
    private int currentState = -1;
    private boolean ivS = false;
    private boolean ivZ = false;
    private boolean iwa = false;
    private g.f cTx = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.dgn = gVar;
            c.this.eCt.bPj();
            if (c.this.hgo != null && c.this.dgn != null && c.this.dgn.getDuration() > 0) {
                c.this.hgo.aC(0, c.this.dgn.getDuration());
            }
            c.this.aZw();
            if (c.this.ivD != null) {
                c.this.ivD.onPrepared();
            }
        }
    };
    private g.e cTz = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.pR();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a eCD = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aZw();
        }
    };
    private Runnable SS = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SS);
            if (c.this.hgz.getVisibility() != 8) {
                if (c.this.dnB.getCurrentPosition() > c.this.SL) {
                    c.this.pR();
                } else {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SS, 20L);
                }
            }
        }
    };
    private g.a cTw = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dnB != null) {
                int duration = c.this.dnB.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.SK = false;
                    c.this.ivV = false;
                    c.this.mStartPosition = 0;
                    c.this.bLd();
                    c.this.hgp.setVisibility(0);
                    c.this.ivp.setProgress(c.this.ivp.getMax());
                    c.this.SL = 100;
                    if (c.this.ivv != null) {
                        c.this.ivv.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dnB.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.pZ(false);
                        c.this.qa(true);
                    } else {
                        c.this.cec();
                        c.this.ivs.setVisibility(0);
                    }
                    if (!c.this.SY && duration <= 150000) {
                        if (!c.this.ivS) {
                            if (c.this.ivF != null) {
                                c.this.ivF.pu(true);
                            }
                            c.this.cs(c.this.bWh, c.this.bWU);
                        } else {
                            c.this.currentState = 5;
                            c.this.dnB.setRecoveryState(5);
                            c.this.dnB.getPlayer().pause();
                            c.this.dnB.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.ivD != null) {
                        c.this.ivD.mO(c.this.ivp.getMax());
                        c.this.ivD.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b hgX = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.eFk.setVisibility(0);
            c.this.cJU.cfa();
            c.this.currentState = 4;
            c.this.dnB.setRecoveryState(4);
            if (c.this.ivw != null) {
                c.this.ivw.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kc()) {
                c.this.ivT = true;
            }
            if (c.this.ivD != null) {
                c.this.ivD.aGI();
            }
            c.this.ivV = false;
            return true;
        }
    };
    protected Runnable hgY = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dnB == null || !c.this.dnB.isPlaying()) {
                c.this.eFk.setVisibility(0);
                c.this.cJU.cfa();
                if (c.this.ivD != null) {
                    c.this.ivD.aGI();
                }
            }
        }
    };
    private g.InterfaceC0393g cTA = new g.InterfaceC0393g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0393g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.ivP) {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iwb, 200L);
            }
        }
    };
    private Runnable iwb = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dnB == null || !c.this.ivP) {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SS, 200L);
                c.this.ivP = false;
            } else if (c.this.mStartPosition != c.this.dnB.getCurrentPosition()) {
                c.this.ivP = false;
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SS, 20L);
            } else {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iwb, 200L);
            }
        }
    };
    private QuickVideoView.b cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.SK = false;
            if (c.this.ivy) {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iwc, 300L);
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SS);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hgY);
        }
    };
    private Runnable iwc = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.ivV = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.iea != null) {
                c.this.iea.cap();
            }
            if (view.getId() != c.this.eFk.getId()) {
                if (view.getId() != c.this.ivr.getId()) {
                    if (view.getId() == c.this.ivt.getId()) {
                        if (c.this.ivE != null) {
                            c.this.ivE.caq();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.ivs.getId()) {
                        if (c.this.ivF != null) {
                            c.this.ivF.pu(false);
                        }
                        c.this.cs(c.this.bWh, c.this.bWU);
                        return;
                    } else if (view.getId() == c.this.hgu.getId()) {
                        int i2 = c.this.ivy ? 1 : 2;
                        if (c.this.SY) {
                            TiebaStatic.log(new an("c11714"));
                            TiebaStatic.log(new an("c13262").bT("tid", c.this.bWU).bT("fid", c.this.eFF).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new an("c11710"));
                            TiebaStatic.log(new an("c13262").bT("tid", c.this.bWU).bT("fid", c.this.eFF).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.ivK != null) {
                            c.this.ivK.box();
                        }
                        if (c.this.cdN()) {
                            if (c.this.SY) {
                                c.this.cdQ();
                            } else {
                                c.this.cdP();
                            }
                            c.this.pW(c.this.SY);
                            return;
                        }
                        c.this.bLh();
                        return;
                    } else if (view.getId() != c.this.hgC.getId()) {
                        if (c.this.ivz != null) {
                            c.this.ivz.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new an("c11713"));
                        if (c.this.ivK != null) {
                            c.this.ivK.box();
                        }
                        if (c.this.cdN()) {
                            c.this.cdQ();
                            c.this.pW(false);
                            return;
                        }
                        c.this.bLh();
                        return;
                    }
                }
                TiebaStatic.log(new an("c13255"));
                c.this.cag();
                c.this.cee();
                if (c.this.currentState != 1) {
                    c.this.cea();
                    c.this.ceb();
                } else {
                    c.this.bLv();
                }
                if (c.this.ivI != null) {
                    c.this.ivI.kV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dnB.cey();
            c.this.SK = false;
            c.this.cdV();
        }
    };
    private Animation.AnimationListener hha = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener hhb = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable hhc = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLs();
        }
    };
    private CustomMessageListener hhd = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b hiZ = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void mv(int i2) {
            int duration;
            if (c.this.dnB != null && (duration = c.this.dnB.getDuration()) > 0 && c.this.ivp != null) {
                c.this.ivp.setProgress((int) ((i2 * c.this.hgm.getWidth()) / duration));
                if (c.this.ivD != null) {
                    c.this.ivD.mO((c.this.dnB.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cXL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new an("c13256"));
            c.this.cea();
            c.this.qa(false);
            if (c.this.ivI != null) {
                c.this.ivI.kV(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bLi() != null) {
                c.this.wF(c.this.bLi().getSeekPosition());
                if (!c.this.bLr()) {
                    c.this.cdV();
                } else {
                    c.this.bLq();
                    if (c.this.iem != null) {
                        c.this.iem.boz();
                    }
                }
            }
            c.this.qa(true);
            c.this.cdZ();
            if (c.this.ivI != null) {
                c.this.ivI.kV(true);
            }
            if (c.this.ivJ != null) {
                c.this.ivJ.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a iwd = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void cei() {
            if (!c.this.ivS) {
                c.this.cJU.startLoading();
                c.this.hgz.setVisibility(0);
                c.this.ivr.setVisibility(8);
                c.this.ivt.setVisibility(8);
                c.this.ivs.setVisibility(8);
                c.this.ivu.setVisibility(8);
                c.this.eFk.setVisibility(8);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hgY);
                if (c.this.ivC > 0) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.hgY, c.this.ivC);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kV(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0392c {
        void pA();

        void pz();
    }

    /* loaded from: classes.dex */
    public interface d {
        void boy();

        void ks(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void qe(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void kr(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void caq();
    }

    /* loaded from: classes.dex */
    public interface i {
        void boz();
    }

    /* loaded from: classes.dex */
    public interface j {
        void pu(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void bow();

        void box();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean car();

        boolean cas();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aGH();

        void aGI();

        void aGJ();

        void mO(int i);

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void cap();
    }

    public c(Activity activity, View view, boolean z) {
        this.ivX = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.ivX = z;
            this.hgx = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.ivX = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.ivX = z;
            this.hgx = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.hgm = as(this.mActivity);
        this.hgm.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hgm);
        }
        this.dnB = (QuickVideoView) this.hgm.findViewById(R.id.videoView);
        this.cJU = new x((ViewGroup) this.hgm.findViewById(R.id.auto_video_loading_container));
        this.cJU.setLoadingAnimationListener(this.eCD);
        this.hgo = (VideoListMediaControllerView) this.hgm.findViewById(R.id.media_controller);
        this.hgo.setPlayer(this.dnB);
        this.ivp = (ProgressBar) this.hgm.findViewById(R.id.pgrBottomProgress);
        this.ivp.setMax(com.baidu.adp.lib.util.l.af(this.mActivity));
        this.ivp.setProgress(0);
        this.hgo.setOnSeekBarChangeListener(this.cXL);
        this.hgo.setOnProgressUpdatedListener(this.hiZ);
        this.hgp = this.hgm.findViewById(R.id.black_mask);
        this.eFk = this.hgm.findViewById(R.id.layout_error);
        this.eFk.setOnClickListener(this.mOnClickListener);
        this.ivR = (TextView) this.hgm.findViewById(R.id.auto_video_error_tips);
        this.hgq = (FrameLayout) this.hgm.findViewById(R.id.danmu_container);
        this.hgu = (ImageView) this.hgm.findViewById(R.id.img_full_screen);
        this.hgu.setOnClickListener(this.mOnClickListener);
        this.hgv = this.hgm.findViewById(R.id.layout_media_controller);
        this.ivq = this.hgm.findViewById(R.id.time_show_controller);
        this.dnB.setPlayerReuseEnable(true);
        this.dnB.setContinuePlayEnable(true);
        this.dnB.setOnPreparedListener(this.cTx);
        this.dnB.setOnCompletionListener(this.cTw);
        this.dnB.setOnErrorListener(this.hgX);
        this.dnB.setOnSeekCompleteListener(this.cTA);
        this.dnB.setOnSurfaceDestroyedListener(this.cKd);
        this.dnB.setOnRecoveryCallback(this.iwd);
        this.dnB.setOnOutInfoListener(this.cTz);
        this.ivr = (SwitchImageView) this.hgm.findViewById(R.id.img_play_controller);
        this.ivr.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.ivr.setState(0);
        this.ivr.setOnClickListener(this.mOnClickListener);
        this.ivs = (TextView) this.hgm.findViewById(R.id.txt_replay);
        this.ivs.setOnClickListener(this.mOnClickListener);
        this.ivt = (TextView) this.hgm.findViewById(R.id.txt_playnext);
        this.ivt.setOnClickListener(this.mOnClickListener);
        this.ivu = (TextView) this.hgm.findViewById(R.id.txt_next_video_title);
        this.hgz = (TbImageView) this.hgm.findViewById(R.id.video_thumbnail);
        this.hgz.setDefaultErrorResource(0);
        this.hgz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hgC = (ImageView) this.hgm.findViewById(R.id.img_exit);
        this.hgC.setOnClickListener(this.mOnClickListener);
        this.hgD = (TextView) this.hgm.findViewById(R.id.video_title);
        this.eFf = this.hgm.findViewById(R.id.layout_title);
        this.eFf.setVisibility(8);
        this.fAk = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afH = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hgN = this.mAudioManager.getStreamMaxVolume(3);
        this.hgS = this.mAudioManager.getStreamVolume(3);
        hgT = 100 / this.hgN;
        this.hgm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.ivG != null) {
                    c.this.ivG.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.SK) {
                        if (c.this.mStatus == 1 && c.this.hgP != 0) {
                            c.this.b(c.this.hgP == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hgP = 0;
                            c.this.hgO = 0;
                        }
                        if (!c.this.dnB.isPlaying()) {
                            c.this.ivt.setVisibility(8);
                            c.this.ivs.setVisibility(8);
                            c.this.ivu.setVisibility(8);
                        }
                    }
                    c.this.bLd();
                    if (c.this.ivG != null) {
                        c.this.ivG.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.dfA = new com.baidu.tieba.play.o(this.mActivity);
        if (this.ivX) {
            this.dfA.start();
        }
        this.hgR = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.ds16);
        if (hgU == null) {
            hgU = new CallStateReceiver();
        }
        hgU.register(this.mActivity);
        cdK();
        this.eCt = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.hhd);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hhd);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void cdK() {
        if (this.ivN) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hgm.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hgm.setSystemUiVisibility(0);
    }

    public void pU(boolean z) {
        this.ivN = z;
        cdK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLd() {
        this.mStatus = 0;
        if (this.hgH != null && this.hgH.getParent() != null && (this.hgH.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hgH.getParent()).removeView(this.hgH);
                this.hgH = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hgI != null && this.hgI.getParent() != null && (this.hgI.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hgI.getParent()).removeView(this.hgI);
                this.hgI = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bLe() {
        if (this.mStatus == 1) {
            if (this.hgH == null && this.hgm != null && (this.hgm instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hgm, true);
                this.hgH = this.hgm.findViewById(R.id.lay_jindu);
                this.hgJ = (TextView) this.hgH.findViewById(R.id.show_time);
                this.hgM = (ImageView) this.hgH.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hgI == null && this.hgm != null && (this.hgm instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hgm, true);
            this.hgI = this.hgm.findViewById(R.id.lay_voice);
            this.hgL = (ImageView) this.hgI.findViewById(R.id.arrow_voice_icon);
            this.hgK = (SeekBar) this.hgI.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.ivz = onClickListener;
    }

    public void pV(boolean z) {
        this.ivy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.ivG != null) {
                c.this.ivG.onStart();
            }
            if (c.this.SY && c.this.SK) {
                if (c.this.mStatus == 1) {
                    c.this.cec();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aM(f2);
                    }
                } else {
                    if (c.this.SY) {
                        c.this.bLg();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hgO = c.this.dnB.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aM(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.ivY) {
                if (c.this.ivH != null && c.this.ivH.car()) {
                    return true;
                }
                c.this.cag();
                c.this.cee();
                if (c.this.dnB.isPlaying()) {
                    c.this.cdZ();
                } else {
                    c.this.cea();
                }
                if (c.this.ivI != null) {
                    c.this.ivI.kV(c.this.dnB.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.ivY) {
                if (c.this.SK) {
                    if (c.this.ivH != null && c.this.ivH.cas()) {
                        return true;
                    }
                    c.this.cdY();
                    if (c.this.dnB.isPlaying()) {
                        c.this.cdZ();
                    } else {
                        c.this.cea();
                    }
                    if (c.this.ivI != null) {
                        c.this.ivI.kV(c.this.dnB.isPlaying());
                    }
                } else {
                    c.this.cag();
                    c.this.cee();
                    if (c.this.currentState != 1) {
                        c.this.cea();
                        c.this.ceb();
                    } else {
                        c.this.bLv();
                    }
                    if (c.this.ivI != null) {
                        c.this.ivI.kV(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLg() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hgm.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hgm.setSystemUiVisibility(4);
        } else {
            this.hgm.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(float f2) {
        if (!this.SK) {
            this.mStatus = 0;
            return;
        }
        bLe();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hgT == 0) {
            if (f2 > 0.0f && this.hgS < this.hgN) {
                this.hgS++;
            }
            if (f2 < 0.0f && this.hgS > 0) {
                this.hgS--;
            }
        }
        if (this.mProgress > 0) {
            this.hgL.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hgL.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hgS, 0);
        this.hgK.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hgO += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.hgP = 1;
            } else {
                this.hgO += 1000;
                this.hgP = 2;
            }
            if (this.hgO < 0) {
                this.hgO = 0;
            } else if (this.hgO > this.dnB.getDuration()) {
                this.hgO = this.dnB.getDuration();
            }
        }
        bLe();
        String zb = this.hgo.zb(this.hgO);
        if (f2 > 0.0f) {
            this.hgM.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hgM.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(zb)) {
            this.hgJ.setText(new StringBuilder().append(zb).append("/").append(this.hgo.zb(this.dnB.getDuration())));
        }
        this.hgo.setCurrentDuration(this.hgO, z ? false : true);
        cec();
        cdR();
    }

    protected View as(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bWh = str;
        this.bWU = str2;
    }

    public void cdL() {
        if (this.dnB != null) {
            this.dnB.cdL();
        }
    }

    public void setFid(String str) {
        this.eFF = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        int i2 = 100;
        if (this.dnB != null && this.dgn != null && this.hgo != null) {
            this.hgo.showProgress();
            this.mStartPosition = y.cfe().Da(this.bWh);
            if (this.ivV) {
                this.dgn.setVolume(1.0f, 1.0f);
                this.dnB.start();
                this.ivV = false;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SS);
                com.baidu.adp.lib.g.e.iK().postDelayed(this.SS, 20L);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgY);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwc);
                if (this.dnB.ceA()) {
                    this.currentState = 1;
                    this.dnB.setRecoveryState(1);
                    cec();
                }
                this.mStartPosition = y.cfe().Da(this.bWh);
                this.hgo.setPlayer(this.dnB);
                if (this.mStartPosition != 0 && !this.dgn.isPlayerReuse()) {
                    this.ivP = true;
                }
                if (!this.ivU) {
                    this.hgo.showProgress();
                }
                if (!this.ivy && this.dgn.getDuration() <= 0) {
                    bLi().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.dgn.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.SL = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR() {
        if (this.hgz.getVisibility() != 8) {
            this.SK = true;
            this.hgp.setVisibility(8);
            this.eFk.setVisibility(8);
            this.cJU.ceZ();
            this.hgz.setVisibility(8);
            ced();
            if (cef()) {
                this.eCt.a(this.bWU, -1L, this.dnB.getDuration() / 1000, "middle", this.dnB);
            }
            this.hgo.showProgress();
            this.ivp.setVisibility(0);
            if (this.hgA != null) {
                this.hgA.onPrepared(this.dnB.getPlayer());
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

    protected void pW(boolean z) {
        if (hasNavBar(this.mActivity) && (this.ivq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivq.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.ivq.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.ivq.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.ivq.setLayoutParams(layoutParams);
        }
    }

    public void cag() {
        if (this.dnB.isPlaying()) {
            pausePlay();
            if (this.ivM != null) {
                this.ivM.onPause();
            }
            if (this.ivD != null) {
                this.ivD.aGH();
            }
        } else if (this.SK) {
            bLq();
            if (this.iem != null) {
                this.iem.boz();
            }
            if (this.ivD != null) {
                this.ivD.aGJ();
            }
        } else {
            cdV();
        }
    }

    public boolean cdM() {
        return this.hgV;
    }

    public void bLh() {
        this.hgV = true;
        if (this.dfA != null) {
            this.dfA.bLh();
        }
    }

    public boolean cdN() {
        return this.dgn != null && this.dnB.getHeight() > this.dnB.getWidth();
    }

    public void cdO() {
        pW(false);
        cdQ();
    }

    public boolean yV(int i2) {
        switch (i2) {
            case 4:
                if (this.SY) {
                    if (cdN()) {
                        pW(false);
                        cdQ();
                    } else {
                        bLh();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hgN <= 0 || this.hgK == null) {
                    return false;
                }
                this.hgS = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hgS * 100.0d) / this.hgN);
                this.hgK.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dnB;
    }

    public VideoListMediaControllerView bLi() {
        return this.hgo;
    }

    public void show() {
        this.hgm.setVisibility(0);
    }

    public void bLm() {
        if (this.hgx != null) {
            ViewGroup.LayoutParams layoutParams = this.hgx.getLayoutParams();
            this.hgr = (FrameLayout.LayoutParams) this.hgm.getLayoutParams();
            this.hgr.width = layoutParams.width;
            this.hgr.height = layoutParams.height;
            this.hgr.topMargin = 0;
            this.hgm.setLayoutParams(this.hgr);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hgV) {
            if (this.SY) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hgV = false;
        }
        if (configuration.orientation == 2) {
            cdP();
        } else {
            cdQ();
        }
        cdR();
        bLq();
        cee();
        bLv();
        if (this.ivI != null) {
            this.ivI.kV(true);
        }
    }

    protected void cdP() {
        this.SY = true;
        int u = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.u(this.mActivity) : 0;
        if (cdN()) {
            this.hgm.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hgm.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - u, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.eFf.setVisibility(0);
        this.hgC.setVisibility(0);
        this.hgD.setVisibility(0);
        this.hgq.setVisibility(8);
        this.cJU.cfa();
        this.hgz.setVisibility(8);
        this.hgu.setImageResource(R.drawable.icon_video_narrow_white);
        wC(this.hgR);
        bLg();
        if (this.ivA != null) {
            this.ivA.pz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdQ() {
        this.SY = false;
        if (this.hgr != null) {
            this.hgm.setLayoutParams(this.hgr);
        }
        g(this.mActivity, false);
        this.eFf.setVisibility(8);
        this.hgq.setVisibility(0);
        this.cJU.cfa();
        this.hgz.setVisibility(8);
        this.hgu.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hgo != null && (this.hgo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgo.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hgo.setLayoutParams(layoutParams);
        }
        this.hgm.setSystemUiVisibility(0);
        cdK();
        if (this.ivA != null) {
            this.ivA.pA();
        }
    }

    public void cdR() {
        if (this.dnB != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mActivity);
            if (this.SY) {
                af = com.baidu.adp.lib.util.l.ah(this.mActivity);
            }
            this.ivp.setMax(af);
            int duration = this.dnB.getDuration();
            if (duration > 0) {
                if (this.ivs.getVisibility() == 0) {
                    this.ivp.setProgress(this.ivp.getMax());
                } else {
                    this.ivp.setProgress((int) ((this.dnB.getCurrentPosition() * this.ivp.getMax()) / duration));
                }
            }
        }
    }

    private void wC(int i2) {
        if (this.hgo != null && (this.hgo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgo.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hgo.setLayoutParams(layoutParams);
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

    public boolean bLo() {
        return !this.SY;
    }

    public void a(g.f fVar) {
        this.hgA = fVar;
    }

    public void a(g.a aVar) {
        this.ivv = aVar;
    }

    public void a(g.b bVar) {
        this.ivw = bVar;
    }

    public void i(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dnB != null) {
            this.dnB.setPbLoadingTime(currentTimeMillis);
        }
        cs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.ivQ) {
            dR(str, str2);
        } else {
            cs(str, str2);
        }
        if (eVar != null) {
            eVar.qe(z);
        }
    }

    public void dQ(String str, String str2) {
    }

    public void cs(String str, String str2) {
        cdW();
        this.ivV = true;
        this.currentState = 0;
        this.dnB.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dnB.setVideoPath(str, str2);
        this.eCt.bPi();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgY);
        if (this.ivC > 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.hgY, this.ivC);
        }
        if (this.ivD != null) {
            this.ivD.onStarted();
        }
        this.cJU.startLoading();
        pX(true);
    }

    public void dR(String str, String str2) {
        cdW();
        this.ivV = true;
        this.currentState = 0;
        this.dnB.setRecoveryState(0);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgY);
        if (this.ivC > 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.hgY, this.ivC);
        }
        if (this.ivD != null) {
            this.ivD.onStarted();
        }
        this.cJU.startLoading();
        pX(true);
    }

    public void cdS() {
        bLq();
        this.ivp.setVisibility(0);
    }

    public void bLq() {
        int i2 = 100;
        if (this.dnB != null && this.hgo != null) {
            this.SK = true;
            this.currentState = 1;
            this.dnB.setRecoveryState(1);
            this.dnB.start();
            if (this.dgn != null && this.hgo != null) {
                this.mStartPosition = y.cfe().Da(this.bWh);
                if (this.mStartPosition != 0 && !this.dgn.isPlayerReuse()) {
                    this.ivP = true;
                }
                if (this.mStartPosition > 100 && this.dgn.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.SL = i2;
            } else {
                this.SL = 100;
            }
            this.cJU.cfa();
            pX(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kc() && this.ivT && !StringUtils.isNull(this.bWh) && !StringUtils.isNull(this.bWU)) {
            this.ivT = false;
            this.ivU = true;
            cs(this.bWh, this.bWU);
        }
    }

    private void pX(boolean z) {
        if (z) {
            this.hgz.setVisibility(0);
            cec();
            this.ivp.setProgress(0);
        } else {
            this.hgz.setVisibility(8);
        }
        this.hgo.showProgress();
        this.hgp.setVisibility(8);
        this.ivt.setVisibility(8);
        this.ivs.setVisibility(8);
        this.ivu.setVisibility(8);
        this.eFk.setVisibility(8);
    }

    private void cdT() {
        this.cJU.cfa();
        this.ivt.setVisibility(8);
        this.ivs.setVisibility(8);
        this.ivu.setVisibility(8);
        cee();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dnB != null) {
            this.dnB.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dnB.pause();
        this.currentState = 2;
        this.dnB.setRecoveryState(2);
        cdT();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dnB.setRecoveryState(5);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SS);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgY);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwc);
        this.dnB.cey();
        this.SK = false;
        this.ivV = false;
        this.mStartPosition = 0;
        byn();
    }

    public void cdU() {
        if (this.dnB.getDuration() >= this.dnB.getCurrentPosition()) {
            y.cfe().bg(this.bWh, this.dnB.getCurrentPosition());
        }
    }

    public void pY(boolean z) {
        this.ivO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        if (this.hgv != null) {
            this.hgp.setVisibility(0);
            this.ivt.setVisibility(8);
            this.ivs.setVisibility(8);
            this.ivu.setVisibility(8);
            this.cJU.cfa();
            cec();
            this.ivp.setVisibility(8);
            this.eFk.setVisibility(8);
            this.hgo.aDg();
            this.hgz.setVisibility(z ? 0 : 8);
        }
    }

    public void byn() {
        pZ(true);
    }

    public boolean pB() {
        if (this.dnB == null) {
            return false;
        }
        return this.dnB.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dnB == null) {
            return 0;
        }
        return this.dnB.getCurrentPosition();
    }

    public void a(k kVar) {
        this.ivG = kVar;
    }

    public void a(j jVar) {
        this.ivF = jVar;
    }

    public void a(i iVar) {
        this.iem = iVar;
    }

    public void a(g gVar) {
        this.ivM = gVar;
    }

    public void a(h hVar) {
        this.ivE = hVar;
    }

    public void Cv(String str) {
        this.idM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdV() {
        a(this.bWh, this.bWU, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.ivB = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cdW();
        if (com.baidu.adp.lib.util.j.ke() && !com.baidu.tieba.video.g.cua().cub()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.ivQ = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ivL != null) {
                    this.ivL.kr(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.mO(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cdX();
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
                aVar.b(this.mContext).agK();
                return;
            } else if (this.ivL != null) {
                this.ivL.kr(true);
                return;
            } else {
                if (!this.ivo) {
                    this.ivo = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.ivK != null) {
            this.ivK.bow();
        }
    }

    private void cdW() {
        if (com.baidu.adp.lib.util.j.ke()) {
            com.baidu.tieba.video.g.cua().ep(this.mActivity);
        }
    }

    public void cdX() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.hgz.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hhc);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SS);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgY);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwb);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwc);
        this.dfA.stop();
        hgU.unregister(this.mActivity);
    }

    public void CV(String str) {
        this.hgD.setText(str);
    }

    public boolean bLr() {
        return this.SK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdY() {
        if (this.hgv != null) {
            if (this.ivx) {
                cec();
            } else {
                ceb();
            }
        }
    }

    public void bLv() {
        ceb();
        cdZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdZ() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hhc);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.hhc, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cea() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hhc);
    }

    public void ceb() {
        if (this.hgv != null && !this.ivx && !this.ivZ) {
            qa(true);
            bLu();
            this.hgv.setVisibility(0);
            this.ivq.setVisibility(0);
            this.ivp.setVisibility(8);
            this.ivx = true;
            if (this.ivB != null) {
                this.ivB.ks(false);
            }
        }
    }

    public void bLs() {
        if (this.hgv != null && this.ivx) {
            qa(false);
            bLu();
            this.hgv.setVisibility(8);
            this.ivq.setVisibility(8);
            this.ivp.setVisibility(0);
            this.fAk.setAnimationListener(this.hha);
            this.hgv.startAnimation(this.fAk);
            this.ivx = false;
            if (this.ivB != null) {
                this.ivB.boy();
            }
        }
    }

    public void cec() {
        if (this.hgv != null && this.ivx) {
            this.afH.cancel();
            this.fAk.cancel();
            qa(false);
            bLu();
            this.hgv.setVisibility(8);
            this.ivq.setVisibility(8);
            this.ivp.setVisibility(0);
            this.ivx = false;
            if (this.ivB != null) {
                this.ivB.boy();
            }
        }
    }

    private void bLu() {
        if (this.hgv != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hhc);
            this.afH.setAnimationListener(null);
            this.fAk.setAnimationListener(null);
            this.hgv.clearAnimation();
        }
    }

    private void ced() {
        if (this.hgv != null) {
            this.afH.setAnimationListener(null);
            this.fAk.setAnimationListener(null);
            this.hgv.clearAnimation();
        }
    }

    public void qa(boolean z) {
        cee();
        if (z) {
            this.ivr.setVisibility(0);
        } else {
            this.ivr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cee() {
        if (this.currentState == 1) {
            this.ivr.setState(1);
        } else {
            this.ivr.setState(0);
        }
    }

    public void a(InterfaceC0392c interfaceC0392c) {
        this.ivA = interfaceC0392c;
    }

    public void wF(int i2) {
        this.mStartPosition = i2;
    }

    public void ag(boolean z, boolean z2) {
        if (this.dfA != null) {
            if (this.hgu != null) {
                this.hgu.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hgo != null && (this.hgo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgo.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds52);
                this.hgo.setLayoutParams(layoutParams);
            }
            this.dfA.qg(z);
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

    public void qb(boolean z) {
        this.ivY = z;
    }

    public void a(m mVar) {
        this.ivH = mVar;
    }

    public void a(a aVar) {
        this.ivI = aVar;
    }

    public void a(n nVar) {
        this.ivJ = nVar;
    }

    public void a(l lVar) {
        this.ivK = lVar;
    }

    public void a(f fVar) {
        this.ivL = fVar;
    }

    public void qc(boolean z) {
        this.ivS = z;
    }

    public boolean cef() {
        return this.ivy;
    }

    public void qd(boolean z) {
        this.ivy = z;
    }

    public void yW(int i2) {
        this.ivW = i2;
    }

    public View ceg() {
        return this.hgm;
    }

    public void a(o oVar) {
        this.ivD = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dnB != null) {
            this.dnB.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.iea = pVar;
    }

    public void ceh() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
    }
}
