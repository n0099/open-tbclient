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
import com.baidu.tbadk.core.util.an;
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
    private static int eNI;
    private String aWo;
    private o bJx;
    private w bcO;
    private String bcS;
    private QuickVideoView buJ;
    private com.baidu.tieba.play.g cwc;
    private View cyM;
    private ImageView cyN;
    private View cyR;
    private Animation dol;
    private Animation dom;
    private ImageView eNA;
    private ImageView eNB;
    private int eNC;
    private int eNG;
    private int eNH;
    private CallStateReceiver eNJ;
    private VideoListMediaControllerView eNd;
    private View eNe;
    private FrameLayout eNf;
    protected FrameLayout.LayoutParams eNg;
    private ImageView eNi;
    private ImageView eNj;
    private View eNk;
    private View eNm;
    private TbImageView eNn;
    private g.f eNo;
    private ImageView eNq;
    private TextView eNr;
    private View eNw;
    private View eNx;
    private TextView eNy;
    private SeekBar eNz;
    private h fNn;
    private boolean geA;
    private boolean geB;
    private boolean geC;
    private int geD;
    private boolean geE;
    private boolean geF;
    private ProgressBar gea;
    private View geb;
    private View gec;
    private TextView ged;
    private TextView gee;
    private TextView gef;
    private g.a geg;
    private g.b geh;
    private View.OnClickListener gej;
    private b gek;
    private InterfaceC0219c gel;
    private g gem;
    private i gen;
    private j gep;
    private l geq;
    private k ger;
    private e ges;
    private f get;
    private TextView gey;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    public View mMainView;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean gdZ = false;
    protected boolean dcn = false;
    private boolean eNs = false;
    private boolean eNu = false;
    private boolean gei = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eND = 0;
    private int eNE = 0;
    private boolean eNK = false;
    private boolean geu = true;
    private boolean gev = true;
    private boolean gew = false;
    private boolean gex = false;
    private String fMR = null;
    private int awl = -1;
    private boolean gez = false;
    private g.f bjc = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cwc = gVar;
            if (c.this.blv()) {
                c.this.bcO.bmx();
                c.this.geE = true;
                return;
            }
            c.this.aii();
        }
    };
    private VideoLoadingProgressView.a cwm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aii();
        }
    };
    private Runnable eNM = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.buJ.getCurrentPosition() > 100) {
                c.this.eNs = true;
                c.this.eNe.setVisibility(8);
                c.this.cyR.setVisibility(8);
                c.this.bcO.bmy();
                c.this.eNn.setVisibility(8);
                c.this.aRj();
                if (c.this.awl == 1 || c.this.awl == 2) {
                    if (c.this.eNk != null) {
                        c.this.eNk.setVisibility(0);
                        c.this.gec.setVisibility(0);
                        c.this.gea.setVisibility(8);
                        if (c.this.gel != null) {
                            c.this.gel.fS(false);
                        }
                    }
                    c.this.eNd.showProgress();
                    c.this.aRk();
                }
                if (c.this.eNo != null) {
                    c.this.eNo.onPrepared(c.this.buJ.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.im().postDelayed(c.this.eNM, 20L);
        }
    };
    private g.a bjb = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eNs = false;
            c.this.geC = false;
            c.this.mStartPosition = 0;
            c.this.aQR();
            c.this.eNe.setVisibility(0);
            c.this.gea.setVisibility(8);
            c.this.gea.setProgress(c.this.gea.getMax());
            if (c.this.gel != null) {
                c.this.gel.fS(false);
            }
            if (c.this.dcn) {
                c.this.eNk.setVisibility(0);
                c.this.eNq.setVisibility(0);
                c.this.eNr.setVisibility(0);
                c.this.gec.setVisibility(8);
            } else {
                c.this.eNk.setVisibility(8);
                c.this.eNq.setVisibility(8);
                c.this.eNr.setVisibility(8);
                c.this.gec.setVisibility(8);
            }
            if (c.this.buJ == null || c.this.buJ.getDuration() > 150000) {
                c.this.lG(false);
            } else {
                c.this.ged.setVisibility(0);
            }
            x.bmD().remove(c.this.bcS);
            if (c.this.geg != null) {
                c.this.geg.onCompletion(gVar);
            }
            c.this.awl = 3;
            c.this.buJ.setRecoveryState(3);
            if (!c.this.dcn && c.this.buJ != null && c.this.buJ.getDuration() <= 150000) {
                if (!c.this.gez) {
                    if (c.this.gen != null) {
                        c.this.gen.ld(true);
                    }
                    c.this.bX(c.this.bcS, c.this.aWo);
                    return;
                }
                c.this.awl = 5;
                c.this.buJ.setRecoveryState(5);
                c.this.buJ.getPlayer().pause();
                c.this.buJ.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eNN = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cyR.setVisibility(0);
            c.this.bcO.bmz();
            c.this.awl = 4;
            c.this.buJ.setRecoveryState(4);
            if (c.this.geh != null) {
                c.this.geh.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jD()) {
                c.this.geA = true;
            }
            c.this.geC = false;
            return true;
        }
    };
    private Runnable eNO = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.cyR.setVisibility(0);
            c.this.bcO.bmz();
        }
    };
    private g.InterfaceC0220g bjf = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0220g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gew) {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.geG, 200L);
            }
        }
    };
    private Runnable geG = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.buJ == null || !c.this.gew) {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.eNM, 200L);
                c.this.gew = false;
            } else if (c.this.mStartPosition != c.this.buJ.getCurrentPosition()) {
                c.this.gew = false;
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.eNM, 20L);
            } else {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.geG, 200L);
            }
        }
    };
    private QuickVideoView.b bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eNs = false;
            if (c.this.gei) {
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.geH, 300L);
            } else {
                c.this.geC = false;
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(c.this.eNM);
            com.baidu.adp.lib.g.e.im().removeCallbacks(c.this.eNO);
        }
    };
    private Runnable geH = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.geC = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cyR.getId()) {
                c.this.blD();
            } else if (view.getId() != c.this.cyN.getId() && view.getId() != c.this.eNi.getId()) {
                if (view.getId() == c.this.gee.getId()) {
                    if (c.this.gem != null) {
                        c.this.gem.bif();
                    }
                } else if (view.getId() == c.this.ged.getId()) {
                    if (c.this.gen != null) {
                        c.this.gen.ld(false);
                    }
                    c.this.bX(c.this.bcS, c.this.aWo);
                } else if (view.getId() != c.this.eNj.getId() && view.getId() != c.this.geb.getId()) {
                    if (view.getId() != c.this.eNq.getId()) {
                        if (c.this.gej != null) {
                            c.this.gej.onClick(view);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c11713"));
                    if (c.this.ger != null) {
                        c.this.ger.avG();
                    }
                    if (c.this.blw()) {
                        c.this.bly();
                        c.this.lD(false);
                        return;
                    }
                    c.this.aQV();
                } else {
                    if (c.this.dcn) {
                        TiebaStatic.log(new an("c11714"));
                    } else {
                        TiebaStatic.log(new an("c11710"));
                    }
                    if (c.this.ger != null) {
                        c.this.ger.avG();
                    }
                    if (c.this.blw()) {
                        if (c.this.dcn) {
                            c.this.bly();
                        } else {
                            c.this.blx();
                        }
                        c.this.lD(c.this.dcn);
                        return;
                    }
                    c.this.aQV();
                }
            } else {
                c.this.bhW();
            }
        }
    };
    private Animation.AnimationListener eNQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eNk != null) {
                c.this.eNk.setVisibility(8);
                c.this.gea.setVisibility(0);
                c.this.eNu = false;
                if (c.this.gel != null) {
                    c.this.gel.avH();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eNR = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable eNS = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aRh();
        }
    };
    private CustomMessageListener eNT = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b ePN = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gv(int i2) {
            int duration;
            if (c.this.buJ != null && (duration = c.this.buJ.getDuration()) > 0 && c.this.gea != null) {
                c.this.gea.setProgress((int) ((i2 * c.this.mMainView.getWidth()) / duration));
            }
            c.this.oV(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bnn = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eNu) {
                c.this.aRk();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aRg() && c.this.aQW() != null) {
                c.this.setStartPosition(c.this.aQW().getSeekPosition());
                c.this.bX(c.this.bcS, c.this.aWo);
            }
        }
    };
    private QuickVideoView.a geI = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void blL() {
            if (!c.this.gez) {
                c.this.bcO.startLoading();
                c.this.eNn.setVisibility(0);
                c.this.cyN.setVisibility(8);
                c.this.eNi.setImageResource(d.f.icon_video_suspend_n);
                c.this.gee.setVisibility(8);
                c.this.ged.setVisibility(8);
                c.this.gef.setVisibility(8);
                c.this.cyR.setVisibility(8);
                com.baidu.adp.lib.g.e.im().removeCallbacks(c.this.eNO);
                com.baidu.adp.lib.g.e.im().postDelayed(c.this.eNO, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void avD();

        void avE();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0219c {
        void avH();

        void fS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lJ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface g {
        void bif();
    }

    /* loaded from: classes.dex */
    public interface h {
        void avI();
    }

    /* loaded from: classes.dex */
    public interface i {
        void ld(boolean z);
    }

    /* loaded from: classes.dex */
    public interface j {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface k {
        void avF();

        void avG();
    }

    /* loaded from: classes.dex */
    public interface l {
        void big();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eNG = 0;
        this.geF = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mMainView = q(tbPageContext);
            this.mRootView = view;
            this.geF = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.mMainView);
            }
            this.eNm = view;
            this.mMainView.setOnClickListener(this.mOnClickListener);
            this.buJ = (QuickVideoView) this.mMainView.findViewById(d.g.videoView);
            this.bcO = new w((ViewGroup) this.mMainView.findViewById(d.g.auto_video_loading_container));
            this.bcO.setLoadingAnimationListener(this.cwm);
            this.eNd = (VideoListMediaControllerView) this.mMainView.findViewById(d.g.media_controller);
            this.eNd.setPlayer(this.buJ);
            this.gea = (ProgressBar) this.mMainView.findViewById(d.g.pgrBottomProgress);
            this.gea.setMax(com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()));
            this.gea.setProgress(0);
            this.eNd.setOnSeekBarChangeListener(this.bnn);
            this.eNd.setOnProgressUpdatedListener(this.ePN);
            this.eNe = this.mMainView.findViewById(d.g.black_mask);
            this.cyR = this.mMainView.findViewById(d.g.layout_error);
            this.cyR.setOnClickListener(this.mOnClickListener);
            this.gey = (TextView) this.mMainView.findViewById(d.g.auto_video_error_tips);
            this.eNf = (FrameLayout) this.mMainView.findViewById(d.g.danmu_container);
            this.eNi = (ImageView) this.mMainView.findViewById(d.g.img_play_icon);
            this.eNi.setOnClickListener(this.mOnClickListener);
            this.eNj = (ImageView) this.mMainView.findViewById(d.g.img_full_screen);
            this.eNj.setOnClickListener(this.mOnClickListener);
            this.geb = this.mMainView.findViewById(d.g.full_screen_container);
            this.geb.setOnClickListener(this.mOnClickListener);
            this.eNk = this.mMainView.findViewById(d.g.layout_media_controller);
            this.gec = this.mMainView.findViewById(d.g.time_show_controller);
            this.buJ.setOnPreparedListener(this.bjc);
            this.buJ.setOnCompletionListener(this.bjb);
            this.buJ.setOnErrorListener(this.eNN);
            this.buJ.setOnSeekCompleteListener(this.bjf);
            this.buJ.setOnSurfaceDestroyedListener(this.bcY);
            this.buJ.setOnRecoveryCallback(this.geI);
            this.cyN = (ImageView) this.mMainView.findViewById(d.g.img_play);
            this.cyN.setOnClickListener(this.mOnClickListener);
            this.ged = (TextView) this.mMainView.findViewById(d.g.txt_replay);
            this.ged.setOnClickListener(this.mOnClickListener);
            this.gee = (TextView) this.mMainView.findViewById(d.g.txt_playnext);
            this.gee.setOnClickListener(this.mOnClickListener);
            this.gef = (TextView) this.mMainView.findViewById(d.g.txt_next_video_title);
            this.eNn = (TbImageView) this.mMainView.findViewById(d.g.video_thumbnail);
            this.eNn.setDefaultErrorResource(0);
            this.eNn.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            this.mScreenHeight = bL(this.mContext.getPageActivity());
            this.eNq = (ImageView) this.mMainView.findViewById(d.g.img_exit);
            this.eNq.setOnClickListener(this.mOnClickListener);
            this.eNr = (TextView) this.mMainView.findViewById(d.g.video_title);
            this.cyM = this.mMainView.findViewById(d.g.layout_title);
            this.cyM.setVisibility(8);
            this.dol = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dom = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eNC = this.mAudioManager.getStreamMaxVolume(3);
            this.eNH = this.mAudioManager.getStreamVolume(3);
            eNI = 100 / this.eNC;
            this.mMainView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.gep != null) {
                        c.this.gep.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eNs) {
                            if (c.this.mStatus == 1 && c.this.eNE != 0) {
                                c.this.b(c.this.eNE == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eNE = 0;
                                c.this.eND = 0;
                            }
                            if (!c.this.buJ.isPlaying() && 8 == c.this.cyN.getVisibility()) {
                                c.this.cyN.setVisibility(0);
                                c.this.gee.setVisibility(8);
                                c.this.ged.setVisibility(8);
                                c.this.gef.setVisibility(8);
                            }
                        }
                        c.this.aQR();
                        if (c.this.gep != null) {
                            c.this.gep.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bJx = new o(this.mContext.getPageActivity());
            if (this.geF) {
                this.bJx.start();
            }
            this.eNG = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds16);
            this.eNJ = new CallStateReceiver();
            this.eNJ.register(this.mContext.getPageActivity());
            this.mContext.registerListener(this.eNT);
            blu();
        }
    }

    public void blu() {
        if (this.geu) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.mMainView.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.mMainView.setSystemUiVisibility(0);
    }

    public void lC(boolean z) {
        this.geu = z;
        blu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQR() {
        this.mStatus = 0;
        if (this.eNw != null && this.eNw.getParent() != null && (this.eNw.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eNw.getParent()).removeView(this.eNw);
                this.eNw = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eNx != null && this.eNx.getParent() != null && (this.eNx.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eNx.getParent()).removeView(this.eNx);
                this.eNx = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aQS() {
        if (this.mStatus == 1) {
            if (this.eNw == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
                LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.float_video_window_jindu, (ViewGroup) this.mMainView, true);
                this.eNw = this.mMainView.findViewById(d.g.lay_jindu);
                this.eNy = (TextView) this.eNw.findViewById(d.g.show_time);
                this.eNB = (ImageView) this.eNw.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eNx == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
            LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.float_video_window_voice, (ViewGroup) this.mMainView, true);
            this.eNx = this.mMainView.findViewById(d.g.lay_voice);
            this.eNA = (ImageView) this.eNx.findViewById(d.g.arrow_voice_icon);
            this.eNz = (SeekBar) this.eNx.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void U(View.OnClickListener onClickListener) {
        this.gej = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gep != null) {
                c.this.gep.onStart();
            }
            if (c.this.dcn && c.this.eNs) {
                if (!c.this.buJ.isPlaying() && c.this.cyN.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cyN.setVisibility(8);
                    c.this.gee.setVisibility(8);
                    c.this.ged.setVisibility(8);
                    c.this.gef.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ap(f2);
                    }
                } else {
                    if (c.this.dcn) {
                        c.this.aQU();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eND = c.this.buJ.getCurrentPosition();
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
            if (c.this.geq != null) {
                c.this.geq.big();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eNs) {
                if (c.this.awl != 2) {
                    c.this.blG();
                } else {
                    c.this.bhW();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQU() {
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
        if (!this.eNs) {
            this.mStatus = 0;
            return;
        }
        aQS();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eNI == 0) {
            if (f2 > 0.0f && this.eNH < this.eNC) {
                this.eNH++;
            }
            if (f2 < 0.0f && this.eNH > 0) {
                this.eNH--;
            }
        }
        if (this.mProgress > 0) {
            this.eNA.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eNA.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eNH, 0);
        this.eNz.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eND += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eNE = 1;
            } else {
                this.eND += 1000;
                this.eNE = 2;
            }
            if (this.eND < 0) {
                this.eND = 0;
            } else if (this.eND > this.buJ.getDuration()) {
                this.eND = this.buJ.getDuration();
            }
        }
        aQS();
        String rL = this.eNd.rL(this.eND);
        if (f2 > 0.0f) {
            this.eNB.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eNB.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rL)) {
            this.eNy.setText(new StringBuilder().append(rL).append("/").append(this.eNd.rL(this.buJ.getDuration())));
        }
        this.eNd.setCurrentDuration(this.eND, z ? false : true);
        this.eNk.setVisibility(8);
        this.gea.setVisibility(0);
        blz();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.float_video_container, (ViewGroup) null);
    }

    public void bW(String str, String str2) {
        this.bcS = str;
        this.aWo = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blv() {
        if (this.gei) {
            return this.geD == 0 && !this.geE;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aii() {
        if (this.buJ != null && this.cwc != null) {
            if (this.geC) {
                this.buJ.start();
                this.geC = false;
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNM);
            com.baidu.adp.lib.g.e.im().postDelayed(this.eNM, 20L);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNO);
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.geH);
            if (this.buJ.bmc()) {
                this.awl = 1;
                this.buJ.setRecoveryState(1);
            }
            if (this.cwc != null && this.eNd != null) {
                this.mStartPosition = x.bmD().sk(this.bcS);
                this.eNd.R(this.mStartPosition, this.cwc.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.buJ != null) {
                        this.buJ.rK(this.mStartPosition);
                    } else {
                        this.cwc.seekTo(this.mStartPosition);
                    }
                    if (!this.geB) {
                        this.eNd.showProgress();
                        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNM);
                    }
                    this.gew = true;
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
    public void lD(boolean z) {
        if (hasNavBar(this.mContext.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gec.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mContext.getPageActivity());
                this.gec.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gec.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.gec.setLayoutParams(layoutParams);
        }
    }

    public void bhW() {
        if (!com.baidu.adp.lib.util.j.jD()) {
            com.baidu.adp.lib.util.l.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(d.k.neterror));
        } else if (this.buJ.isPlaying()) {
            pausePlay();
            if (this.get != null) {
                this.get.onPause();
            }
        } else if (this.eNs) {
            aRf();
            if (this.fNn != null) {
                this.fNn.avI();
            }
        } else {
            blD();
        }
    }

    public void aQV() {
        this.eNK = true;
        if (this.bJx != null) {
            this.bJx.aQV();
        }
    }

    public boolean blw() {
        return this.cwc != null && this.cwc.getVideoHeight() > this.cwc.getVideoWidth();
    }

    public boolean rH(int i2) {
        switch (i2) {
            case 4:
                if (this.dcn) {
                    if (blw()) {
                        lD(false);
                        bly();
                    } else {
                        aQV();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eNC <= 0 || this.eNz == null) {
                    return false;
                }
                this.eNH = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eNH * 100.0d) / this.eNC);
                this.eNz.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.buJ;
    }

    public VideoListMediaControllerView aQW() {
        return this.eNd;
    }

    public void show() {
        this.mMainView.setVisibility(0);
    }

    public void aRa() {
        if (this.eNm != null) {
            ViewGroup.LayoutParams layoutParams = this.eNm.getLayoutParams();
            this.eNg = (FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
            this.eNg.width = layoutParams.width;
            this.eNg.height = layoutParams.height;
            this.eNg.topMargin = 0;
            this.mMainView.setLayoutParams(this.eNg);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eNK) {
            if (this.dcn) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.eNK = false;
        }
        if (configuration.orientation == 2) {
            blx();
        } else {
            bly();
        }
        if (this.buJ.isPlaying()) {
            aRk();
        }
        blz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        this.dcn = true;
        if (blw()) {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.mContext, true);
        this.eNk.setVisibility(0);
        this.cyM.setVisibility(0);
        this.eNq.setVisibility(0);
        this.eNr.setVisibility(0);
        this.eNf.setVisibility(8);
        if (this.gei) {
            this.bcO.startLoading();
            this.eNn.setVisibility(0);
        } else {
            this.bcO.bmz();
            this.eNn.setVisibility(8);
        }
        if (this.gek != null) {
            this.gek.avD();
        }
        this.eNj.setImageResource(d.f.icon_video_window);
        oT(this.eNG);
        aQU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bly() {
        this.dcn = false;
        if (this.eNg != null) {
            this.mMainView.setLayoutParams(this.eNg);
        }
        a((TbPageContext) this.mContext, false);
        this.cyM.setVisibility(8);
        this.eNf.setVisibility(0);
        if (this.gei) {
            this.bcO.startLoading();
            this.eNn.setVisibility(0);
        } else {
            this.bcO.bmz();
            this.eNn.setVisibility(8);
        }
        if (this.gek != null) {
            this.gek.avE();
        }
        if (this.awl == 3 && this.gel != null) {
            this.gel.fS(false);
        } else if (!this.eNs && this.eNk != null) {
            this.eNk.clearAnimation();
            this.eNk.setVisibility(4);
            this.gea.setVisibility(0);
            if (this.gel != null) {
                this.gel.avH();
            }
        }
        aQR();
        this.eNj.setImageResource(d.f.icon_video_fullscreen);
        if (this.eNd != null && (this.eNd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNd.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.eNd.setLayoutParams(layoutParams);
        }
        this.mMainView.setSystemUiVisibility(0);
        blu();
    }

    public void blz() {
        if (this.buJ != null) {
            int ah = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            if (this.dcn) {
                ah = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
            }
            this.gea.setMax(ah);
            int duration = this.buJ.getDuration();
            if (duration > 0) {
                if (this.ged.getVisibility() == 0) {
                    this.gea.setProgress(this.gea.getMax());
                } else {
                    this.gea.setProgress((int) ((this.buJ.getCurrentPosition() * this.gea.getMax()) / duration));
                }
            }
        }
    }

    private void oT(int i2) {
        if (this.eNd != null && (this.eNd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNd.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eNd.setLayoutParams(layoutParams);
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

    public boolean aRc() {
        return !this.dcn;
    }

    public void a(g.f fVar) {
        this.eNo = fVar;
    }

    public void a(g.a aVar) {
        this.geg = aVar;
    }

    public void a(g.b bVar) {
        this.geh = bVar;
    }

    public void aRd() {
        this.eNi.setImageResource(d.f.icon_video_play);
        this.bcO.bmz();
        this.cyN.setVisibility(0);
        this.gee.setVisibility(8);
        this.ged.setVisibility(8);
        this.gef.setVisibility(8);
        this.awl = 2;
        this.buJ.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.buJ != null) {
            this.buJ.setPbLoadingTime(currentTimeMillis);
        }
        bX(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z, String str, String str2) {
        if (this.gex) {
            bY(str, str2);
        } else {
            bX(str, str2);
        }
        if (dVar != null) {
            dVar.lJ(z);
        }
        if (this.ger != null) {
            this.ger.avF();
        }
    }

    public void bX(String str, String str2) {
        blE();
        this.geC = true;
        this.awl = 0;
        this.buJ.setRecoveryState(0);
        bW(str, str2);
        this.buJ.setVideoPath(str, str2);
        this.bcO.startLoading();
        this.eNn.setVisibility(0);
        this.cyN.setVisibility(8);
        this.eNi.setImageResource(d.f.icon_video_suspend_n);
        this.gee.setVisibility(8);
        this.ged.setVisibility(8);
        this.gef.setVisibility(8);
        this.cyR.setVisibility(8);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNO);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eNO, 60000L);
    }

    public void bY(String str, String str2) {
        blE();
        this.geC = true;
        this.awl = 0;
        this.buJ.setRecoveryState(0);
        this.bcO.startLoading();
        this.eNn.setVisibility(0);
        this.cyN.setVisibility(8);
        this.eNi.setImageResource(d.f.icon_video_suspend_n);
        this.gee.setVisibility(8);
        this.ged.setVisibility(8);
        this.gef.setVisibility(8);
        this.cyR.setVisibility(8);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNO);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eNO, 60000L);
    }

    public void aRf() {
        this.awl = 1;
        this.buJ.setRecoveryState(1);
        this.buJ.start();
        this.eNi.setImageResource(d.f.icon_video_suspend_n);
        this.eNn.setVisibility(8);
        this.eNe.setVisibility(8);
        this.bcO.bmz();
        this.eNd.showProgress();
        this.cyN.setVisibility(8);
        this.gee.setVisibility(8);
        this.ged.setVisibility(8);
        this.gef.setVisibility(8);
        blI();
    }

    public void blA() {
        if (com.baidu.adp.lib.util.j.jD() && this.geA && !StringUtils.isNull(this.bcS) && !StringUtils.isNull(this.aWo)) {
            this.geA = false;
            this.geB = true;
            bX(this.bcS, this.aWo);
        }
    }

    public void lE(boolean z) {
        if (this.buJ != null) {
            this.buJ.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.buJ.isPlaying() && this.gev) {
            blB();
        }
        blH();
        this.buJ.pause();
        aRd();
    }

    public void stopPlay() {
        if (this.buJ.isPlaying() && this.gev) {
            blB();
        }
        this.awl = 5;
        this.buJ.setRecoveryState(5);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNM);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNO);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.geH);
        this.buJ.stopPlayback();
        this.eNs = false;
        this.geC = false;
        this.mStartPosition = 0;
        aEd();
    }

    public void blB() {
        x.bmD().aH(this.bcS, this.buJ.getCurrentPosition());
    }

    public void lF(boolean z) {
        this.gev = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if (this.eNk != null) {
            this.eNe.setVisibility(0);
            this.cyN.setVisibility(0);
            this.gee.setVisibility(8);
            this.ged.setVisibility(8);
            this.gef.setVisibility(8);
            this.bcO.bmz();
            this.eNi.setImageResource(d.f.icon_video_play);
            this.eNk.setVisibility(4);
            this.gea.setVisibility(8);
            this.cyR.setVisibility(8);
            this.eNd.QZ();
            this.eNn.setVisibility(z ? 0 : 8);
        }
    }

    public void aEd() {
        lG(true);
    }

    public boolean blC() {
        if (this.buJ == null) {
            return false;
        }
        return this.buJ.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.buJ == null) {
            return 0;
        }
        return this.buJ.getCurrentPosition();
    }

    public void a(j jVar) {
        this.gep = jVar;
    }

    public void a(i iVar) {
        this.gen = iVar;
    }

    public void a(h hVar) {
        this.fNn = hVar;
    }

    public void a(f fVar) {
        this.get = fVar;
    }

    public void a(g gVar) {
        this.gem = gVar;
    }

    public void rM(String str) {
        this.fMR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blD() {
        a(this.bcS, this.aWo, (d) null, new Object[0]);
    }

    public void b(InterfaceC0219c interfaceC0219c) {
        this.gel = interfaceC0219c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        blE();
        if (com.baidu.adp.lib.util.j.jF() && !com.baidu.tieba.video.f.bBB().bBC()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gex = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.ges != null) {
                    this.ges.fR(false);
                    if (this.ger != null) {
                        this.ger.avF();
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dE(TbadkCoreApplication.getInst().getString(d.k.play_video_mobile_tip));
                aVar.a(d.k.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.blF();
                        aVar2.dismiss();
                        c.this.a(dVar, false, str, str2);
                    }
                });
                aVar.b(d.k.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xn();
                return;
            } else if (this.ges != null) {
                this.ges.fR(true);
                if (this.ger != null) {
                    this.ger.avF();
                    return;
                }
                return;
            } else {
                if (!this.gdZ) {
                    this.gdZ = true;
                    com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.play_video_mobile_tip2);
                }
                a(dVar, true, str, str2);
                return;
            }
        }
        a(dVar, true, str, str2);
    }

    private void blE() {
        if (com.baidu.adp.lib.util.j.jF()) {
            com.baidu.tieba.video.f.bBB().ck(this.mContext.getPageActivity());
        }
    }

    public void blF() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void pr(String str) {
        this.eNn.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNS);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNM);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNO);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.geG);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.geH);
        this.bJx.stop();
        this.eNJ.unregister(this.mContext.getPageActivity());
    }

    public void sg(String str) {
        this.eNr.setText(str);
    }

    public boolean aRg() {
        return this.eNs;
    }

    public void aRh() {
        if (this.eNk != null) {
            aRj();
            this.eNk.setVisibility(0);
            this.gec.setVisibility(0);
            if (this.gel != null) {
                this.gel.fS(true);
            }
            this.gea.setVisibility(8);
            this.dol.setAnimationListener(this.eNQ);
            this.eNk.startAnimation(this.dol);
            this.eNu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blG() {
        if (this.eNk != null) {
            if (this.eNk.getVisibility() == 0) {
                aRj();
                this.eNk.setVisibility(8);
                this.gea.setVisibility(0);
                if (this.gel != null) {
                    this.gel.avH();
                    return;
                }
                return;
            }
            aRk();
        }
    }

    public void aRi() {
        if (this.eNk != null) {
            aRj();
            this.eNk.setVisibility(0);
            this.gec.setVisibility(0);
            if (this.gel != null) {
                this.gel.fS(false);
            }
            this.gea.setVisibility(8);
            this.dom.setAnimationListener(this.eNR);
            this.eNk.startAnimation(this.dom);
        }
    }

    public void blH() {
        if (this.eNk != null) {
            aRj();
            this.eNk.setVisibility(0);
            this.gec.setVisibility(0);
            this.gea.setVisibility(8);
            if (this.gel != null) {
                this.gel.fS(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        if (this.eNk != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNS);
            this.dom.setAnimationListener(null);
            this.dol.setAnimationListener(null);
            this.eNk.clearAnimation();
            this.eNu = false;
        }
    }

    public void aRk() {
        aRi();
        blI();
    }

    private void blI() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eNS);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eNS, 3000L);
    }

    public void a(b bVar) {
        this.gek = bVar;
    }

    public void oV(int i2) {
        if (this.buJ.getDuration() - i2 <= 3000) {
            aRj();
            if (this.eNk != null) {
                this.eNk.setVisibility(0);
                this.gec.setVisibility(0);
                this.gea.setVisibility(8);
                if (this.gel != null) {
                    this.gel.fS(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void N(boolean z, boolean z2) {
        int i2 = 8;
        if (this.bJx != null) {
            if (this.eNj != null || this.geb != null) {
                this.eNj.setVisibility((z || !z2) ? 0 : 8);
                View view = this.geb;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.eNd != null && (this.eNd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNd.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds52);
                this.eNd.setLayoutParams(layoutParams);
            }
            this.bJx.lL(z);
        }
    }

    public int bL(Context context) {
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

    public int blJ() {
        return this.awl;
    }

    public void a(l lVar) {
        this.geq = lVar;
    }

    public void a(k kVar) {
        this.ger = kVar;
    }

    public void a(e eVar) {
        this.ges = eVar;
    }

    public void lH(boolean z) {
        this.gez = z;
    }

    public void lI(boolean z) {
        this.gei = z;
    }

    public void rI(int i2) {
        this.geD = i2;
    }

    public void blK() {
        com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), this.eNi, 40, 40, 40, 40);
    }
}
