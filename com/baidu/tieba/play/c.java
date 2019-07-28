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
    private static int hgb;
    private static CallStateReceiver hgc;
    private Animation afH;
    private String bWO;
    private String bWb;
    private x cJN;
    private com.baidu.tieba.play.o dft;
    public com.baidu.tieba.play.g dgg;
    protected QuickVideoView dnu;
    private com.baidu.tieba.j.k eCm;
    private View eEY;
    protected View eFd;
    private String eFy;
    private Animation fzw;
    private ImageView hfC;
    private View hfD;
    private View hfF;
    private TbImageView hfH;
    private g.f hfI;
    private ImageView hfK;
    private TextView hfL;
    private View hfP;
    private View hfQ;
    private TextView hfR;
    private SeekBar hfS;
    private ImageView hfT;
    private ImageView hfU;
    private int hfV;
    public View hfu;
    private VideoListMediaControllerView hfw;
    private View hfx;
    private FrameLayout hfy;
    protected FrameLayout.LayoutParams hfz;
    private int hga;
    private p ida;
    private i idn;
    private o iuA;
    private h iuB;
    private j iuC;
    private k iuD;
    private m iuE;
    private a iuF;
    private n iuG;
    private l iuH;
    private f iuI;
    private g iuJ;
    private TextView iuO;
    private boolean iuQ;
    private boolean iuR;
    private boolean iuS;
    private int iuT;
    private boolean iuU;
    private boolean iuV;
    private ProgressBar ium;
    private View iun;
    private SwitchImageView iuo;
    private TextView iup;
    private TextView iuq;
    private TextView iur;
    private g.a ius;
    private g.b iut;
    private View.OnClickListener iuw;
    protected InterfaceC0392c iux;
    private d iuy;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int SL = 100;
    private boolean iul = false;
    protected boolean SY = false;
    private boolean SK = false;
    private boolean iuu = false;
    private boolean iuv = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int hfW = 0;
    private int hfX = 0;
    private long iuz = 60000;
    private int hfZ = 0;
    private boolean hgd = false;
    private boolean iuK = true;
    private boolean iuL = true;
    private boolean iuM = false;
    private boolean iuN = false;
    private String icM = null;
    private int currentState = -1;
    private boolean iuP = false;
    private boolean iuW = false;
    private boolean iuX = false;
    private g.f cTq = new g.f() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.dgg = gVar;
            c.this.eCm.bOV();
            if (c.this.hfw != null && c.this.dgg != null && c.this.dgg.getDuration() > 0) {
                c.this.hfw.aC(0, c.this.dgg.getDuration());
            }
            c.this.aZu();
            if (c.this.iuA != null) {
                c.this.iuA.onPrepared();
            }
        }
    };
    private g.e cTs = new g.e() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3 || i2 == 702) {
                c.this.pR();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a eCw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aZu();
        }
    };
    private Runnable SS = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SS);
            if (c.this.hfH.getVisibility() != 8) {
                if (c.this.dnu.getCurrentPosition() > c.this.SL) {
                    c.this.pR();
                } else {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SS, 20L);
                }
            }
        }
    };
    private g.a cTp = new g.a() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.dnu != null) {
                int duration = c.this.dnu.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.SK = false;
                    c.this.iuS = false;
                    c.this.mStartPosition = 0;
                    c.this.bKP();
                    c.this.hfx.setVisibility(0);
                    c.this.ium.setProgress(c.this.ium.getMax());
                    c.this.SL = 100;
                    if (c.this.ius != null) {
                        c.this.ius.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.dnu.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.pY(false);
                        c.this.pZ(true);
                    } else {
                        c.this.cdK();
                        c.this.iup.setVisibility(0);
                    }
                    if (!c.this.SY && duration <= 150000) {
                        if (!c.this.iuP) {
                            if (c.this.iuC != null) {
                                c.this.iuC.pu(true);
                            }
                            c.this.cs(c.this.bWb, c.this.bWO);
                        } else {
                            c.this.currentState = 5;
                            c.this.dnu.setRecoveryState(5);
                            c.this.dnu.getPlayer().pause();
                            c.this.dnu.getPlayer().seekTo(0);
                        }
                    }
                    if (c.this.iuA != null) {
                        c.this.iuA.mN(c.this.ium.getMax());
                        c.this.iuA.onPlayEnd();
                    }
                }
            }
        }
    };
    private g.b hgf = new g.b() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.eFd.setVisibility(0);
            c.this.cJN.ceI();
            c.this.currentState = 4;
            c.this.dnu.setRecoveryState(4);
            if (c.this.iut != null) {
                c.this.iut.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kc()) {
                c.this.iuQ = true;
            }
            if (c.this.iuA != null) {
                c.this.iuA.aGG();
            }
            c.this.iuS = false;
            return true;
        }
    };
    protected Runnable hgg = new Runnable() { // from class: com.baidu.tieba.play.c.23
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dnu == null || !c.this.dnu.isPlaying()) {
                c.this.eFd.setVisibility(0);
                c.this.cJN.ceI();
                if (c.this.iuA != null) {
                    c.this.iuA.aGG();
                }
            }
        }
    };
    private g.InterfaceC0393g cTt = new g.InterfaceC0393g() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.g.InterfaceC0393g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.iuM) {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iuY, 200L);
            }
        }
    };
    private Runnable iuY = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dnu == null || !c.this.iuM) {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SS, 200L);
                c.this.iuM = false;
            } else if (c.this.mStartPosition != c.this.dnu.getCurrentPosition()) {
                c.this.iuM = false;
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.SS, 20L);
            } else {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iuY, 200L);
            }
        }
    };
    private QuickVideoView.b cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.SK = false;
            if (c.this.iuv) {
                com.baidu.adp.lib.g.e.iK().postDelayed(c.this.iuZ, 300L);
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.SS);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hgg);
        }
    };
    private Runnable iuZ = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.iuS = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ida != null) {
                c.this.ida.bZY();
            }
            if (view.getId() != c.this.eFd.getId()) {
                if (view.getId() != c.this.iuo.getId()) {
                    if (view.getId() == c.this.iuq.getId()) {
                        if (c.this.iuB != null) {
                            c.this.iuB.bZZ();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.iup.getId()) {
                        if (c.this.iuC != null) {
                            c.this.iuC.pu(false);
                        }
                        c.this.cs(c.this.bWb, c.this.bWO);
                        return;
                    } else if (view.getId() == c.this.hfC.getId()) {
                        int i2 = c.this.iuv ? 1 : 2;
                        if (c.this.SY) {
                            TiebaStatic.log(new an("c11714"));
                            TiebaStatic.log(new an("c13262").bT("tid", c.this.bWO).bT("fid", c.this.eFy).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new an("c11710"));
                            TiebaStatic.log(new an("c13262").bT("tid", c.this.bWO).bT("fid", c.this.eFy).P("obj_type", i2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        if (c.this.iuH != null) {
                            c.this.iuH.bok();
                        }
                        if (c.this.cdv()) {
                            if (c.this.SY) {
                                c.this.cdy();
                            } else {
                                c.this.cdx();
                            }
                            c.this.pV(c.this.SY);
                            return;
                        }
                        c.this.bKT();
                        return;
                    } else if (view.getId() != c.this.hfK.getId()) {
                        if (c.this.iuw != null) {
                            c.this.iuw.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new an("c11713"));
                        if (c.this.iuH != null) {
                            c.this.iuH.bok();
                        }
                        if (c.this.cdv()) {
                            c.this.cdy();
                            c.this.pV(false);
                            return;
                        }
                        c.this.bKT();
                        return;
                    }
                }
                TiebaStatic.log(new an("c13255"));
                c.this.bZP();
                c.this.cdM();
                if (c.this.currentState != 1) {
                    c.this.cdI();
                    c.this.cdJ();
                } else {
                    c.this.bLh();
                }
                if (c.this.iuF != null) {
                    c.this.iuF.kV(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.dnu.ceg();
            c.this.SK = false;
            c.this.cdD();
        }
    };
    private Animation.AnimationListener hgi = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener hgj = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable hgk = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLe();
        }
    };
    private CustomMessageListener hgl = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b hih = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void mu(int i2) {
            int duration;
            if (c.this.dnu != null && (duration = c.this.dnu.getDuration()) > 0 && c.this.ium != null) {
                c.this.ium.setProgress((int) ((i2 * c.this.hfu.getWidth()) / duration));
                if (c.this.iuA != null) {
                    c.this.iuA.mN((c.this.dnu.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener cXE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new an("c13256"));
            c.this.cdI();
            c.this.pZ(false);
            if (c.this.iuF != null) {
                c.this.iuF.kV(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.bKU() != null) {
                c.this.wD(c.this.bKU().getSeekPosition());
                if (!c.this.bLd()) {
                    c.this.cdD();
                } else {
                    c.this.bLc();
                    if (c.this.idn != null) {
                        c.this.idn.bom();
                    }
                }
            }
            c.this.pZ(true);
            c.this.cdH();
            if (c.this.iuF != null) {
                c.this.iuF.kV(true);
            }
            if (c.this.iuG != null) {
                c.this.iuG.onStopTrackingTouch(seekBar);
            }
        }
    };
    private QuickVideoView.a iva = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void cdQ() {
            if (!c.this.iuP) {
                c.this.cJN.startLoading();
                c.this.hfH.setVisibility(0);
                c.this.iuo.setVisibility(8);
                c.this.iuq.setVisibility(8);
                c.this.iup.setVisibility(8);
                c.this.iur.setVisibility(8);
                c.this.eFd.setVisibility(8);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(c.this.hgg);
                if (c.this.iuz > 0) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(c.this.hgg, c.this.iuz);
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
        void bol();

        void ks(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void qd(boolean z);
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
        void bZZ();
    }

    /* loaded from: classes.dex */
    public interface i {
        void bom();
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
        void boj();

        void bok();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean caa();

        boolean cab();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void aGF();

        void aGG();

        void aGH();

        void mN(int i);

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void bZY();
    }

    public c(Activity activity, View view, boolean z) {
        this.iuU = true;
        if (activity != null) {
            this.mActivity = activity;
            this.mRootView = view;
            this.iuU = z;
            this.hfF = view;
            init();
        }
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.iuU = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.iuU = z;
            this.hfF = view;
            this.mActivity = this.mContext.getPageActivity();
            init();
        }
    }

    public void init() {
        this.hfu = as(this.mActivity);
        this.hfu.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.hfu);
        }
        this.dnu = (QuickVideoView) this.hfu.findViewById(R.id.videoView);
        this.cJN = new x((ViewGroup) this.hfu.findViewById(R.id.auto_video_loading_container));
        this.cJN.setLoadingAnimationListener(this.eCw);
        this.hfw = (VideoListMediaControllerView) this.hfu.findViewById(R.id.media_controller);
        this.hfw.setPlayer(this.dnu);
        this.ium = (ProgressBar) this.hfu.findViewById(R.id.pgrBottomProgress);
        this.ium.setMax(com.baidu.adp.lib.util.l.af(this.mActivity));
        this.ium.setProgress(0);
        this.hfw.setOnSeekBarChangeListener(this.cXE);
        this.hfw.setOnProgressUpdatedListener(this.hih);
        this.hfx = this.hfu.findViewById(R.id.black_mask);
        this.eFd = this.hfu.findViewById(R.id.layout_error);
        this.eFd.setOnClickListener(this.mOnClickListener);
        this.iuO = (TextView) this.hfu.findViewById(R.id.auto_video_error_tips);
        this.hfy = (FrameLayout) this.hfu.findViewById(R.id.danmu_container);
        this.hfC = (ImageView) this.hfu.findViewById(R.id.img_full_screen);
        this.hfC.setOnClickListener(this.mOnClickListener);
        this.hfD = this.hfu.findViewById(R.id.layout_media_controller);
        this.iun = this.hfu.findViewById(R.id.time_show_controller);
        this.dnu.setPlayerReuseEnable(true);
        this.dnu.setContinuePlayEnable(true);
        this.dnu.setOnPreparedListener(this.cTq);
        this.dnu.setOnCompletionListener(this.cTp);
        this.dnu.setOnErrorListener(this.hgf);
        this.dnu.setOnSeekCompleteListener(this.cTt);
        this.dnu.setOnSurfaceDestroyedListener(this.cJW);
        this.dnu.setOnRecoveryCallback(this.iva);
        this.dnu.setOnOutInfoListener(this.cTs);
        this.iuo = (SwitchImageView) this.hfu.findViewById(R.id.img_play_controller);
        this.iuo.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.iuo.setState(0);
        this.iuo.setOnClickListener(this.mOnClickListener);
        this.iup = (TextView) this.hfu.findViewById(R.id.txt_replay);
        this.iup.setOnClickListener(this.mOnClickListener);
        this.iuq = (TextView) this.hfu.findViewById(R.id.txt_playnext);
        this.iuq.setOnClickListener(this.mOnClickListener);
        this.iur = (TextView) this.hfu.findViewById(R.id.txt_next_video_title);
        this.hfH = (TbImageView) this.hfu.findViewById(R.id.video_thumbnail);
        this.hfH.setDefaultErrorResource(0);
        this.hfH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.hfK = (ImageView) this.hfu.findViewById(R.id.img_exit);
        this.hfK.setOnClickListener(this.mOnClickListener);
        this.hfL = (TextView) this.hfu.findViewById(R.id.video_title);
        this.eEY = this.hfu.findViewById(R.id.layout_title);
        this.eEY.setVisibility(8);
        this.fzw = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.afH = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.hfV = this.mAudioManager.getStreamMaxVolume(3);
        this.hga = this.mAudioManager.getStreamVolume(3);
        hgb = 100 / this.hfV;
        this.hfu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.iuD != null) {
                    c.this.iuD.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.SK) {
                        if (c.this.mStatus == 1 && c.this.hfX != 0) {
                            c.this.b(c.this.hfX == 1 ? 1000.0f : -1000.0f, false);
                            c.this.hfX = 0;
                            c.this.hfW = 0;
                        }
                        if (!c.this.dnu.isPlaying()) {
                            c.this.iuq.setVisibility(8);
                            c.this.iup.setVisibility(8);
                            c.this.iur.setVisibility(8);
                        }
                    }
                    c.this.bKP();
                    if (c.this.iuD != null) {
                        c.this.iuD.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.dft = new com.baidu.tieba.play.o(this.mActivity);
        if (this.iuU) {
            this.dft.start();
        }
        this.hfZ = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.ds16);
        if (hgc == null) {
            hgc = new CallStateReceiver();
        }
        hgc.register(this.mActivity);
        cds();
        this.eCm = new com.baidu.tieba.j.k();
        MessageManager.getInstance().registerListener(this.hgl);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new q() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tieba.play.q, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.hgl);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void cds() {
        if (this.iuK) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.hfu.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.hfu.setSystemUiVisibility(0);
    }

    public void pT(boolean z) {
        this.iuK = z;
        cds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKP() {
        this.mStatus = 0;
        if (this.hfP != null && this.hfP.getParent() != null && (this.hfP.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hfP.getParent()).removeView(this.hfP);
                this.hfP = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.hfQ != null && this.hfQ.getParent() != null && (this.hfQ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.hfQ.getParent()).removeView(this.hfQ);
                this.hfQ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void bKQ() {
        if (this.mStatus == 1) {
            if (this.hfP == null && this.hfu != null && (this.hfu instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.hfu, true);
                this.hfP = this.hfu.findViewById(R.id.lay_jindu);
                this.hfR = (TextView) this.hfP.findViewById(R.id.show_time);
                this.hfU = (ImageView) this.hfP.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.hfQ == null && this.hfu != null && (this.hfu instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.hfu, true);
            this.hfQ = this.hfu.findViewById(R.id.lay_voice);
            this.hfT = (ImageView) this.hfQ.findViewById(R.id.arrow_voice_icon);
            this.hfS = (SeekBar) this.hfQ.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.iuw = onClickListener;
    }

    public void pU(boolean z) {
        this.iuv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.iuD != null) {
                c.this.iuD.onStart();
            }
            if (c.this.SY && c.this.SK) {
                if (c.this.mStatus == 1) {
                    c.this.cdK();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aM(f2);
                    }
                } else {
                    if (c.this.SY) {
                        c.this.bKS();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.hfW = c.this.dnu.getCurrentPosition();
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
            if (!c.this.iuV) {
                if (c.this.iuE != null && c.this.iuE.caa()) {
                    return true;
                }
                c.this.bZP();
                c.this.cdM();
                if (c.this.dnu.isPlaying()) {
                    c.this.cdH();
                } else {
                    c.this.cdI();
                }
                if (c.this.iuF != null) {
                    c.this.iuF.kV(c.this.dnu.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.iuV) {
                if (c.this.SK) {
                    if (c.this.iuE != null && c.this.iuE.cab()) {
                        return true;
                    }
                    c.this.cdG();
                    if (c.this.dnu.isPlaying()) {
                        c.this.cdH();
                    } else {
                        c.this.cdI();
                    }
                    if (c.this.iuF != null) {
                        c.this.iuF.kV(c.this.dnu.isPlaying());
                    }
                } else {
                    c.this.bZP();
                    c.this.cdM();
                    if (c.this.currentState != 1) {
                        c.this.cdI();
                        c.this.cdJ();
                    } else {
                        c.this.bLh();
                    }
                    if (c.this.iuF != null) {
                        c.this.iuF.kV(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKS() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hfu.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hfu.setSystemUiVisibility(4);
        } else {
            this.hfu.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(float f2) {
        if (!this.SK) {
            this.mStatus = 0;
            return;
        }
        bKQ();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % hgb == 0) {
            if (f2 > 0.0f && this.hga < this.hfV) {
                this.hga++;
            }
            if (f2 < 0.0f && this.hga > 0) {
                this.hga--;
            }
        }
        if (this.mProgress > 0) {
            this.hfT.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.hfT.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.hga, 0);
        this.hfS.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.hfW += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.hfX = 1;
            } else {
                this.hfW += 1000;
                this.hfX = 2;
            }
            if (this.hfW < 0) {
                this.hfW = 0;
            } else if (this.hfW > this.dnu.getDuration()) {
                this.hfW = this.dnu.getDuration();
            }
        }
        bKQ();
        String yZ = this.hfw.yZ(this.hfW);
        if (f2 > 0.0f) {
            this.hfU.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.hfU.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(yZ)) {
            this.hfR.setText(new StringBuilder().append(yZ).append("/").append(this.hfw.yZ(this.dnu.getDuration())));
        }
        this.hfw.setCurrentDuration(this.hfW, z ? false : true);
        cdK();
        cdz();
    }

    protected View as(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bWb = str;
        this.bWO = str2;
    }

    public void cdt() {
        if (this.dnu != null) {
            this.dnu.cdt();
        }
    }

    public void setFid(String str) {
        this.eFy = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        int i2 = 100;
        if (this.dnu != null && this.dgg != null && this.hfw != null) {
            this.hfw.showProgress();
            this.mStartPosition = y.ceM().CZ(this.bWb);
            if (this.iuS) {
                this.dgg.setVolume(1.0f, 1.0f);
                this.dnu.start();
                this.iuS = false;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SS);
                com.baidu.adp.lib.g.e.iK().postDelayed(this.SS, 20L);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgg);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iuZ);
                if (this.dnu.cei()) {
                    this.currentState = 1;
                    this.dnu.setRecoveryState(1);
                    cdK();
                }
                this.mStartPosition = y.ceM().CZ(this.bWb);
                this.hfw.setPlayer(this.dnu);
                if (this.mStartPosition != 0 && !this.dgg.isPlayerReuse()) {
                    this.iuM = true;
                }
                if (!this.iuR) {
                    this.hfw.showProgress();
                }
                if (!this.iuv && this.dgg.getDuration() <= 0) {
                    bKU().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.dgg.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.SL = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR() {
        if (this.hfH.getVisibility() != 8) {
            this.SK = true;
            this.hfx.setVisibility(8);
            this.eFd.setVisibility(8);
            this.cJN.ceH();
            this.hfH.setVisibility(8);
            cdL();
            if (cdN()) {
                this.eCm.a(this.bWO, -1L, this.dnu.getDuration() / 1000, "middle", this.dnu);
            }
            this.hfw.showProgress();
            this.ium.setVisibility(0);
            if (this.hfI != null) {
                this.hfI.onPrepared(this.dnu.getPlayer());
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

    protected void pV(boolean z) {
        if (hasNavBar(this.mActivity) && (this.iun.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iun.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.iun.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.iun.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.iun.setLayoutParams(layoutParams);
        }
    }

    public void bZP() {
        if (this.dnu.isPlaying()) {
            pausePlay();
            if (this.iuJ != null) {
                this.iuJ.onPause();
            }
            if (this.iuA != null) {
                this.iuA.aGF();
            }
        } else if (this.SK) {
            bLc();
            if (this.idn != null) {
                this.idn.bom();
            }
            if (this.iuA != null) {
                this.iuA.aGH();
            }
        } else {
            cdD();
        }
    }

    public boolean cdu() {
        return this.hgd;
    }

    public void bKT() {
        this.hgd = true;
        if (this.dft != null) {
            this.dft.bKT();
        }
    }

    public boolean cdv() {
        return this.dgg != null && this.dnu.getHeight() > this.dnu.getWidth();
    }

    public void cdw() {
        pV(false);
        cdy();
    }

    public boolean yT(int i2) {
        switch (i2) {
            case 4:
                if (this.SY) {
                    if (cdv()) {
                        pV(false);
                        cdy();
                    } else {
                        bKT();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.hfV <= 0 || this.hfS == null) {
                    return false;
                }
                this.hga = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.hga * 100.0d) / this.hfV);
                this.hfS.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.dnu;
    }

    public VideoListMediaControllerView bKU() {
        return this.hfw;
    }

    public void show() {
        this.hfu.setVisibility(0);
    }

    public void bKY() {
        if (this.hfF != null) {
            ViewGroup.LayoutParams layoutParams = this.hfF.getLayoutParams();
            this.hfz = (FrameLayout.LayoutParams) this.hfu.getLayoutParams();
            this.hfz.width = layoutParams.width;
            this.hfz.height = layoutParams.height;
            this.hfz.topMargin = 0;
            this.hfu.setLayoutParams(this.hfz);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.hgd) {
            if (this.SY) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.hgd = false;
        }
        if (configuration.orientation == 2) {
            cdx();
        } else {
            cdy();
        }
        cdz();
        bLc();
        cdM();
        bLh();
        if (this.iuF != null) {
            this.iuF.kV(true);
        }
    }

    protected void cdx() {
        this.SY = true;
        int u = (UtilHelper.hasNotchAndroidP(this.mActivity) || UtilHelper.hasNotchAtHuawei(this.mActivity)) ? com.baidu.adp.lib.util.l.u(this.mActivity) : 0;
        if (cdv()) {
            this.hfu.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.hfu.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight - u, this.mScreenWidth));
        }
        g(this.mActivity, true);
        this.eEY.setVisibility(0);
        this.hfK.setVisibility(0);
        this.hfL.setVisibility(0);
        this.hfy.setVisibility(8);
        this.cJN.ceI();
        this.hfH.setVisibility(8);
        this.hfC.setImageResource(R.drawable.icon_video_narrow_white);
        wA(this.hfZ);
        bKS();
        if (this.iux != null) {
            this.iux.pz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdy() {
        this.SY = false;
        if (this.hfz != null) {
            this.hfu.setLayoutParams(this.hfz);
        }
        g(this.mActivity, false);
        this.eEY.setVisibility(8);
        this.hfy.setVisibility(0);
        this.cJN.ceI();
        this.hfH.setVisibility(8);
        this.hfC.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.hfw != null && (this.hfw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfw.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.hfw.setLayoutParams(layoutParams);
        }
        this.hfu.setSystemUiVisibility(0);
        cds();
        if (this.iux != null) {
            this.iux.pA();
        }
    }

    public void cdz() {
        if (this.dnu != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mActivity);
            if (this.SY) {
                af = com.baidu.adp.lib.util.l.ah(this.mActivity);
            }
            this.ium.setMax(af);
            int duration = this.dnu.getDuration();
            if (duration > 0) {
                if (this.iup.getVisibility() == 0) {
                    this.ium.setProgress(this.ium.getMax());
                } else {
                    this.ium.setProgress((int) ((this.dnu.getCurrentPosition() * this.ium.getMax()) / duration));
                }
            }
        }
    }

    private void wA(int i2) {
        if (this.hfw != null && (this.hfw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfw.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.hfw.setLayoutParams(layoutParams);
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

    public boolean bLa() {
        return !this.SY;
    }

    public void a(g.f fVar) {
        this.hfI = fVar;
    }

    public void a(g.a aVar) {
        this.ius = aVar;
    }

    public void a(g.b bVar) {
        this.iut = bVar;
    }

    public void i(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.dnu != null) {
            this.dnu.setPbLoadingTime(currentTimeMillis);
        }
        cs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.iuN) {
            dR(str, str2);
        } else {
            cs(str, str2);
        }
        if (eVar != null) {
            eVar.qd(z);
        }
    }

    public void dQ(String str, String str2) {
    }

    public void cs(String str, String str2) {
        cdE();
        this.iuS = true;
        this.currentState = 0;
        this.dnu.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dnu.setVideoPath(str, str2);
        this.eCm.bOU();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgg);
        if (this.iuz > 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.hgg, this.iuz);
        }
        if (this.iuA != null) {
            this.iuA.onStarted();
        }
        this.cJN.startLoading();
        pW(true);
    }

    public void dR(String str, String str2) {
        cdE();
        this.iuS = true;
        this.currentState = 0;
        this.dnu.setRecoveryState(0);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgg);
        if (this.iuz > 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.hgg, this.iuz);
        }
        if (this.iuA != null) {
            this.iuA.onStarted();
        }
        this.cJN.startLoading();
        pW(true);
    }

    public void cdA() {
        bLc();
        this.ium.setVisibility(0);
    }

    public void bLc() {
        int i2 = 100;
        if (this.dnu != null && this.hfw != null) {
            this.SK = true;
            this.currentState = 1;
            this.dnu.setRecoveryState(1);
            this.dnu.start();
            if (this.dgg != null && this.hfw != null) {
                this.mStartPosition = y.ceM().CZ(this.bWb);
                if (this.mStartPosition != 0 && !this.dgg.isPlayerReuse()) {
                    this.iuM = true;
                }
                if (this.mStartPosition > 100 && this.dgg.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.SL = i2;
            } else {
                this.SL = 100;
            }
            this.cJN.ceI();
            pW(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kc() && this.iuQ && !StringUtils.isNull(this.bWb) && !StringUtils.isNull(this.bWO)) {
            this.iuQ = false;
            this.iuR = true;
            cs(this.bWb, this.bWO);
        }
    }

    private void pW(boolean z) {
        if (z) {
            this.hfH.setVisibility(0);
            cdK();
            this.ium.setProgress(0);
        } else {
            this.hfH.setVisibility(8);
        }
        this.hfw.showProgress();
        this.hfx.setVisibility(8);
        this.iuq.setVisibility(8);
        this.iup.setVisibility(8);
        this.iur.setVisibility(8);
        this.eFd.setVisibility(8);
    }

    private void cdB() {
        this.cJN.ceI();
        this.iuq.setVisibility(8);
        this.iup.setVisibility(8);
        this.iur.setVisibility(8);
        cdM();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dnu != null) {
            this.dnu.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.dnu.pause();
        this.currentState = 2;
        this.dnu.setRecoveryState(2);
        cdB();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.dnu.setRecoveryState(5);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SS);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgg);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iuZ);
        this.dnu.ceg();
        this.SK = false;
        this.iuS = false;
        this.mStartPosition = 0;
        bxZ();
    }

    public void cdC() {
        if (this.dnu.getDuration() >= this.dnu.getCurrentPosition()) {
            y.ceM().bg(this.bWb, this.dnu.getCurrentPosition());
        }
    }

    public void pX(boolean z) {
        this.iuL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(boolean z) {
        if (this.hfD != null) {
            this.hfx.setVisibility(0);
            this.iuq.setVisibility(8);
            this.iup.setVisibility(8);
            this.iur.setVisibility(8);
            this.cJN.ceI();
            cdK();
            this.ium.setVisibility(8);
            this.eFd.setVisibility(8);
            this.hfw.aDe();
            this.hfH.setVisibility(z ? 0 : 8);
        }
    }

    public void bxZ() {
        pY(true);
    }

    public boolean pB() {
        if (this.dnu == null) {
            return false;
        }
        return this.dnu.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dnu == null) {
            return 0;
        }
        return this.dnu.getCurrentPosition();
    }

    public void a(k kVar) {
        this.iuD = kVar;
    }

    public void a(j jVar) {
        this.iuC = jVar;
    }

    public void a(i iVar) {
        this.idn = iVar;
    }

    public void a(g gVar) {
        this.iuJ = gVar;
    }

    public void a(h hVar) {
        this.iuB = hVar;
    }

    public void Cu(String str) {
        this.icM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdD() {
        a(this.bWb, this.bWO, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.iuy = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        cdE();
        if (com.baidu.adp.lib.util.j.ke() && !com.baidu.tieba.video.g.ctE().ctF()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.ahO().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.iuN = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.iuI != null) {
                    this.iuI.kr(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.mO(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.cdF();
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
                aVar.b(this.mContext).agI();
                return;
            } else if (this.iuI != null) {
                this.iuI.kr(true);
                return;
            } else {
                if (!this.iul) {
                    this.iul = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, (int) R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.iuH != null) {
            this.iuH.boj();
        }
    }

    private void cdE() {
        if (com.baidu.adp.lib.util.j.ke()) {
            com.baidu.tieba.video.g.ctE().eo(this.mActivity);
        }
    }

    public void cdF() {
        com.baidu.tbadk.core.sharedPref.b.ahO().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.hfH.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgk);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.SS);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgg);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iuY);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iuZ);
        this.dft.stop();
        hgc.unregister(this.mActivity);
    }

    public void CU(String str) {
        this.hfL.setText(str);
    }

    public boolean bLd() {
        return this.SK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdG() {
        if (this.hfD != null) {
            if (this.iuu) {
                cdK();
            } else {
                cdJ();
            }
        }
    }

    public void bLh() {
        cdJ();
        cdH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdH() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgk);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.hgk, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdI() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgk);
    }

    public void cdJ() {
        if (this.hfD != null && !this.iuu && !this.iuW) {
            pZ(true);
            bLg();
            this.hfD.setVisibility(0);
            this.iun.setVisibility(0);
            this.ium.setVisibility(8);
            this.iuu = true;
            if (this.iuy != null) {
                this.iuy.ks(false);
            }
        }
    }

    public void bLe() {
        if (this.hfD != null && this.iuu) {
            pZ(false);
            bLg();
            this.hfD.setVisibility(8);
            this.iun.setVisibility(8);
            this.ium.setVisibility(0);
            this.fzw.setAnimationListener(this.hgi);
            this.hfD.startAnimation(this.fzw);
            this.iuu = false;
            if (this.iuy != null) {
                this.iuy.bol();
            }
        }
    }

    public void cdK() {
        if (this.hfD != null && this.iuu) {
            this.afH.cancel();
            this.fzw.cancel();
            pZ(false);
            bLg();
            this.hfD.setVisibility(8);
            this.iun.setVisibility(8);
            this.ium.setVisibility(0);
            this.iuu = false;
            if (this.iuy != null) {
                this.iuy.bol();
            }
        }
    }

    private void bLg() {
        if (this.hfD != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hgk);
            this.afH.setAnimationListener(null);
            this.fzw.setAnimationListener(null);
            this.hfD.clearAnimation();
        }
    }

    private void cdL() {
        if (this.hfD != null) {
            this.afH.setAnimationListener(null);
            this.fzw.setAnimationListener(null);
            this.hfD.clearAnimation();
        }
    }

    public void pZ(boolean z) {
        cdM();
        if (z) {
            this.iuo.setVisibility(0);
        } else {
            this.iuo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdM() {
        if (this.currentState == 1) {
            this.iuo.setState(1);
        } else {
            this.iuo.setState(0);
        }
    }

    public void a(InterfaceC0392c interfaceC0392c) {
        this.iux = interfaceC0392c;
    }

    public void wD(int i2) {
        this.mStartPosition = i2;
    }

    public void ag(boolean z, boolean z2) {
        if (this.dft != null) {
            if (this.hfC != null) {
                this.hfC.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.hfw != null && (this.hfw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfw.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mActivity, R.dimen.tbds52);
                this.hfw.setLayoutParams(layoutParams);
            }
            this.dft.qf(z);
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

    public void qa(boolean z) {
        this.iuV = z;
    }

    public void a(m mVar) {
        this.iuE = mVar;
    }

    public void a(a aVar) {
        this.iuF = aVar;
    }

    public void a(n nVar) {
        this.iuG = nVar;
    }

    public void a(l lVar) {
        this.iuH = lVar;
    }

    public void a(f fVar) {
        this.iuI = fVar;
    }

    public void qb(boolean z) {
        this.iuP = z;
    }

    public boolean cdN() {
        return this.iuv;
    }

    public void qc(boolean z) {
        this.iuv = z;
    }

    public void yU(int i2) {
        this.iuT = i2;
    }

    public View cdO() {
        return this.hfu;
    }

    public void a(o oVar) {
        this.iuA = oVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        a((TbPageContext) null, configuration);
    }

    public void setFullScreenToDestroySurface() {
        if (this.dnu != null) {
            this.dnu.setFullScreenToDestroySurface();
        }
    }

    public void a(p pVar) {
        this.ida = pVar;
    }

    public void cdP() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
    }
}
