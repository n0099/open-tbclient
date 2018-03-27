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
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.v;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int fcK;
    private TbPageContext<?> aRI;
    private String bCV;
    private String bQL;
    private com.baidu.tieba.play.g cWp;
    private y cWu;
    private View cZl;
    private ImageView cZm;
    private View cZq;
    private QuickVideoView caP;
    private p cos;
    private Animation dIp;
    private Animation dIq;
    private SeekBar fcA;
    private ImageView fcB;
    private ImageView fcC;
    private int fcD;
    private int fcI;
    private int fcJ;
    private CallStateReceiver fcL;
    protected View fcc;
    private VideoListMediaControllerView fce;
    private View fcf;
    private FrameLayout fcg;
    protected FrameLayout.LayoutParams fch;
    private ImageView fcj;
    private ImageView fck;
    private View fcl;
    private View fcn;
    private TbImageView fco;
    private g.f fcp;
    private ImageView fcr;
    private TextView fcs;
    private View fcx;
    private View fcy;
    private TextView fcz;
    private g gcF;
    private boolean gtA;
    private boolean gtB;
    private int gtC;
    private boolean gtD;
    private boolean gtE;
    private ProgressBar gtc;
    private View gtd;
    private View gte;
    private TextView gtf;
    private TextView gtg;
    private TextView gth;
    private g.a gti;
    private g.b gtj;
    private b gtl;
    private InterfaceC0219c gtm;
    private f gtn;
    private h gto;
    private i gtp;
    private k gtq;
    private j gtr;
    private e gts;
    private TextView gtx;
    private boolean gtz;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean gtb = false;
    protected boolean eoh = false;
    private boolean fct = false;
    private boolean fcv = false;
    private boolean gtk = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fcE = 0;
    private int fcF = 0;
    private boolean fcM = false;
    private boolean gtt = true;
    private boolean gtu = true;
    private boolean gtv = false;
    private boolean gtw = false;
    private String gcj = null;
    private int bcb = -1;
    private boolean gty = false;
    private g.f bPt = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cWp = gVar;
            if (c.this.bkP()) {
                c.this.cWu.blP();
                c.this.gtD = true;
                return;
            }
            c.this.akX();
        }
    };
    private VideoLoadingProgressView.a cWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.akX();
        }
    };
    private Runnable fcO = new Runnable() { // from class: com.baidu.tieba.play.c.15
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.caP.getCurrentPosition() > 100) {
                c.this.fct = true;
                c.this.fcf.setVisibility(8);
                c.this.cZq.setVisibility(8);
                c.this.cWu.blQ();
                c.this.fco.setVisibility(8);
                c.this.aQI();
                if (c.this.bcb == 1 || c.this.bcb == 2) {
                    if (c.this.fcl != null) {
                        c.this.fcl.setVisibility(0);
                        c.this.gte.setVisibility(0);
                        c.this.gtc.setVisibility(8);
                        if (c.this.gtm != null) {
                            c.this.gtm.gc(false);
                        }
                    }
                    c.this.fce.showProgress();
                    c.this.aQJ();
                }
                if (c.this.fcp != null) {
                    c.this.fcp.onPrepared(c.this.caP.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcO, 20L);
        }
    };
    private g.a bPs = new g.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.fct = false;
            c.this.gtB = false;
            c.this.mStartPosition = 0;
            c.this.aQq();
            c.this.fcf.setVisibility(0);
            c.this.gtc.setVisibility(8);
            c.this.gtc.setProgress(c.this.gtc.getMax());
            if (c.this.gtm != null) {
                c.this.gtm.gc(false);
            }
            if (c.this.eoh) {
                c.this.fcl.setVisibility(0);
                c.this.fcr.setVisibility(0);
                c.this.fcs.setVisibility(0);
                c.this.gte.setVisibility(8);
            } else {
                c.this.fcl.setVisibility(8);
                c.this.fcr.setVisibility(8);
                c.this.fcs.setVisibility(8);
                c.this.gte.setVisibility(8);
            }
            if (c.this.caP == null || c.this.caP.getDuration() > 150000) {
                c.this.lP(false);
            } else {
                c.this.gtf.setVisibility(0);
            }
            z.blV().remove(c.this.bQL);
            if (c.this.gti != null) {
                c.this.gti.onCompletion(gVar);
            }
            c.this.bcb = 3;
            c.this.caP.setRecoveryState(3);
            if (!c.this.eoh && c.this.caP != null && c.this.caP.getDuration() <= 150000) {
                if (!c.this.gty) {
                    if (c.this.gto != null) {
                        c.this.gto.lp(true);
                    }
                    c.this.bL(c.this.bQL, c.this.bCV);
                    return;
                }
                c.this.bcb = 5;
                c.this.caP.setRecoveryState(5);
                c.this.caP.getPlayer().pause();
                c.this.caP.getPlayer().seekTo(0);
            }
        }
    };
    private g.b fcP = new g.b() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cZq.setVisibility(0);
            c.this.cWu.blR();
            c.this.bcb = 4;
            c.this.caP.setRecoveryState(4);
            if (c.this.gtj != null) {
                c.this.gtj.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.oJ()) {
                c.this.gtz = true;
            }
            c.this.gtB = false;
            return true;
        }
    };
    private Runnable fcQ = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            c.this.cZq.setVisibility(0);
            c.this.cWu.blR();
        }
    };
    private g.InterfaceC0220g bPx = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0220g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gtv) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.gtF, 200L);
            }
        }
    };
    private Runnable gtF = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.caP == null || !c.this.gtv) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcO, 200L);
                c.this.gtv = false;
            } else if (c.this.mStartPosition != c.this.caP.getCurrentPosition()) {
                c.this.gtv = false;
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcO, 20L);
            } else {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.gtF, 200L);
            }
        }
    };
    private QuickVideoView.b caY = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fct = false;
            c.this.gtB = false;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcO);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcQ);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cZq.getId()) {
                c.this.bkX();
            } else if (view.getId() != c.this.cZm.getId() && view.getId() != c.this.fcj.getId()) {
                if (view.getId() == c.this.gtg.getId()) {
                    if (c.this.gtn != null) {
                        c.this.gtn.bhz();
                    }
                } else if (view.getId() == c.this.gtf.getId()) {
                    if (c.this.gto != null) {
                        c.this.gto.lp(false);
                    }
                    c.this.bL(c.this.bQL, c.this.bCV);
                } else if (view.getId() != c.this.fck.getId() && view.getId() != c.this.gtd.getId()) {
                    if (view.getId() == c.this.fcr.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.gtr != null) {
                            c.this.gtr.awF();
                        }
                        if (c.this.bkQ()) {
                            c.this.bkS();
                            c.this.lM(false);
                            return;
                        }
                        c.this.aQu();
                    }
                } else {
                    if (c.this.eoh) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.gtr != null) {
                        c.this.gtr.awF();
                    }
                    if (c.this.bkQ()) {
                        if (c.this.eoh) {
                            c.this.bkS();
                        } else {
                            c.this.bkR();
                        }
                        c.this.lM(c.this.eoh);
                        return;
                    }
                    c.this.aQu();
                }
            } else {
                c.this.bhq();
            }
        }
    };
    private Animation.AnimationListener fcS = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.fcl != null) {
                c.this.fcl.setVisibility(8);
                c.this.gtc.setVisibility(0);
                c.this.fcv = false;
                if (c.this.gtm != null) {
                    c.this.gtm.awG();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener fcT = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable fcU = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aQG();
        }
    };
    private CustomMessageListener fcV = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private v.b feK = new v.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.v.b
        public void jo(int i2) {
            int duration;
            if (c.this.caP != null && (duration = c.this.caP.getDuration()) > 0 && c.this.gtc != null) {
                c.this.gtc.setProgress((int) ((i2 * c.this.fcc.getWidth()) / duration));
            }
            c.this.ri(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bTA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.fcv) {
                c.this.aQJ();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aQF() && c.this.aQv() != null) {
                c.this.setStartPosition(c.this.aQv().getSeekPosition());
                c.this.bL(c.this.bQL, c.this.bCV);
            }
        }
    };
    private QuickVideoView.a gtG = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bld() {
            if (!c.this.gty) {
                c.this.cWu.startLoading();
                c.this.fco.setVisibility(0);
                c.this.cZm.setVisibility(8);
                c.this.fcj.setImageResource(d.f.icon_video_suspend_n);
                c.this.gtg.setVisibility(8);
                c.this.gtf.setVisibility(8);
                c.this.gth.setVisibility(8);
                c.this.cZq.setVisibility(8);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcQ);
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcQ, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void awC();

        void awD();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0219c {
        void awG();

        void gc(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void gb(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void bhz();
    }

    /* loaded from: classes.dex */
    public interface g {
        void awH();
    }

    /* loaded from: classes.dex */
    public interface h {
        void lp(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void awE();

        void awF();
    }

    /* loaded from: classes.dex */
    public interface k {
        void bhA();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.fcI = 0;
        this.gtE = true;
        if (tbPageContext != null) {
            this.aRI = tbPageContext;
            this.fcc = p(tbPageContext);
            this.mRootView = view;
            this.gtE = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.fcc);
            }
            this.fcn = view;
            this.fcc.setOnClickListener(this.mOnClickListener);
            this.caP = (QuickVideoView) this.fcc.findViewById(d.g.videoView);
            this.cWu = new y((ViewGroup) this.fcc.findViewById(d.g.auto_video_loading_container));
            this.cWu.setLoadingAnimationListener(this.cWE);
            this.fce = (VideoListMediaControllerView) this.fcc.findViewById(d.g.media_controller);
            this.fce.setPlayer(this.caP);
            this.gtc = (ProgressBar) this.fcc.findViewById(d.g.pgrBottomProgress);
            this.gtc.setMax(com.baidu.adp.lib.util.l.ao(this.aRI.getPageActivity()));
            this.gtc.setProgress(0);
            this.fce.setOnSeekBarChangeListener(this.bTA);
            this.fce.setOnProgressUpdatedListener(this.feK);
            this.fcf = this.fcc.findViewById(d.g.black_mask);
            this.cZq = this.fcc.findViewById(d.g.layout_error);
            this.cZq.setOnClickListener(this.mOnClickListener);
            this.gtx = (TextView) this.fcc.findViewById(d.g.auto_video_error_tips);
            this.fcg = (FrameLayout) this.fcc.findViewById(d.g.danmu_container);
            this.fcj = (ImageView) this.fcc.findViewById(d.g.img_play_icon);
            this.fcj.setOnClickListener(this.mOnClickListener);
            this.fck = (ImageView) this.fcc.findViewById(d.g.img_full_screen);
            this.fck.setOnClickListener(this.mOnClickListener);
            this.gtd = this.fcc.findViewById(d.g.full_screen_container);
            this.gtd.setOnClickListener(this.mOnClickListener);
            this.fcl = this.fcc.findViewById(d.g.layout_media_controller);
            this.gte = this.fcc.findViewById(d.g.time_show_controller);
            this.caP.setOnPreparedListener(this.bPt);
            this.caP.setOnCompletionListener(this.bPs);
            this.caP.setOnErrorListener(this.fcP);
            this.caP.setOnSeekCompleteListener(this.bPx);
            this.caP.setOnSurfaceDestroyedListener(this.caY);
            this.caP.setOnRecoveryCallback(this.gtG);
            this.cZm = (ImageView) this.fcc.findViewById(d.g.img_play);
            this.cZm.setOnClickListener(this.mOnClickListener);
            this.gtf = (TextView) this.fcc.findViewById(d.g.txt_replay);
            this.gtf.setOnClickListener(this.mOnClickListener);
            this.gtg = (TextView) this.fcc.findViewById(d.g.txt_playnext);
            this.gtg.setOnClickListener(this.mOnClickListener);
            this.gth = (TextView) this.fcc.findViewById(d.g.txt_next_video_title);
            this.fco = (TbImageView) this.fcc.findViewById(d.g.video_thumbnail);
            this.fco.setDefaultErrorResource(0);
            this.fco.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.aRI.getPageActivity());
            this.mScreenHeight = bN(this.aRI.getPageActivity());
            this.fcr = (ImageView) this.fcc.findViewById(d.g.img_exit);
            this.fcr.setOnClickListener(this.mOnClickListener);
            this.fcs = (TextView) this.fcc.findViewById(d.g.video_title);
            this.cZl = this.fcc.findViewById(d.g.layout_title);
            this.cZl.setVisibility(8);
            this.dIp = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dIq = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aRI.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.fcD = this.mAudioManager.getStreamMaxVolume(3);
            this.fcJ = this.mAudioManager.getStreamVolume(3);
            fcK = 100 / this.fcD;
            this.fcc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.gtp != null) {
                        c.this.gtp.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.fct) {
                            if (c.this.mStatus == 1 && c.this.fcF != 0) {
                                c.this.b(c.this.fcF == 1 ? 1000.0f : -1000.0f, false);
                                c.this.fcF = 0;
                                c.this.fcE = 0;
                            }
                            if (!c.this.caP.isPlaying() && 8 == c.this.cZm.getVisibility()) {
                                c.this.cZm.setVisibility(0);
                                c.this.gtg.setVisibility(8);
                                c.this.gtf.setVisibility(8);
                                c.this.gth.setVisibility(8);
                            }
                        }
                        c.this.aQq();
                        if (c.this.gtp != null) {
                            c.this.gtp.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.cos = new p(this.aRI.getPageActivity());
            if (this.gtE) {
                this.cos.start();
            }
            this.fcI = com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.ds16);
            this.fcL = new CallStateReceiver();
            this.fcL.register(this.aRI.getPageActivity());
            this.aRI.registerListener(this.fcV);
            bkO();
        }
    }

    public void bkO() {
        if (this.gtt) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fcc.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.fcc.setSystemUiVisibility(0);
    }

    public void lL(boolean z) {
        this.gtt = z;
        bkO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        this.mStatus = 0;
        if (this.fcx != null && this.fcx.getParent() != null && (this.fcx.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fcx.getParent()).removeView(this.fcx);
                this.fcx = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fcy != null && this.fcy.getParent() != null && (this.fcy.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fcy.getParent()).removeView(this.fcy);
                this.fcy = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aQr() {
        if (this.mStatus == 1) {
            if (this.fcx == null && this.fcc != null && (this.fcc instanceof ViewGroup)) {
                LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.fcc, true);
                this.fcx = this.fcc.findViewById(d.g.lay_jindu);
                this.fcz = (TextView) this.fcx.findViewById(d.g.show_time);
                this.fcC = (ImageView) this.fcx.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fcy == null && this.fcc != null && (this.fcc instanceof ViewGroup)) {
            LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.fcc, true);
            this.fcy = this.fcc.findViewById(d.g.lay_voice);
            this.fcB = (ImageView) this.fcy.findViewById(d.g.arrow_voice_icon);
            this.fcA = (SeekBar) this.fcy.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gtp != null) {
                c.this.gtp.onStart();
            }
            if (c.this.eoh && c.this.fct) {
                if (!c.this.caP.isPlaying() && c.this.cZm.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cZm.setVisibility(8);
                    c.this.gtg.setVisibility(8);
                    c.this.gtf.setVisibility(8);
                    c.this.gth.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ar(f2);
                    }
                } else {
                    if (c.this.eoh) {
                        c.this.aQt();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fcE = c.this.caP.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ar(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.gtq != null) {
                c.this.gtq.bhA();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.fct) {
                if (c.this.bcb != 2) {
                    c.this.bkZ();
                } else {
                    c.this.bhq();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        if (Build.VERSION.SDK_INT < 16) {
            this.fcc.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.fcc.setSystemUiVisibility(4);
        } else {
            this.fcc.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f2) {
        if (!this.fct) {
            this.mStatus = 0;
            return;
        }
        aQr();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % fcK == 0) {
            if (f2 > 0.0f && this.fcJ < this.fcD) {
                this.fcJ++;
            }
            if (f2 < 0.0f && this.fcJ > 0) {
                this.fcJ--;
            }
        }
        if (this.mProgress > 0) {
            this.fcB.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.fcB.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fcJ, 0);
        this.fcA.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fcE += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fcF = 1;
            } else {
                this.fcE += 1000;
                this.fcF = 2;
            }
            if (this.fcE < 0) {
                this.fcE = 0;
            } else if (this.fcE > this.caP.getDuration()) {
                this.fcE = this.caP.getDuration();
            }
        }
        aQr();
        String tU = this.fce.tU(this.fcE);
        if (f2 > 0.0f) {
            this.fcC.setImageResource(d.f.icon_kuaitui);
        } else {
            this.fcC.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tU)) {
            this.fcz.setText(new StringBuilder().append(tU).append("/").append(this.fce.tU(this.caP.getDuration())));
        }
        this.fce.R(this.fcE, z ? false : true);
        this.fcl.setVisibility(8);
        this.gtc.setVisibility(0);
        bkT();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.bQL = str;
        this.bCV = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkP() {
        if (this.gtk) {
            return this.gtC == 0 && !this.gtD;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.caP != null && this.cWp != null) {
            if (this.gtB) {
                this.caP.start();
                this.gtB = false;
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.fcO, 20L);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcQ);
            if (this.caP.blu()) {
                this.bcb = 1;
                this.caP.setRecoveryState(1);
            }
            if (this.cWp != null && this.fce != null) {
                this.mStartPosition = z.blV().rl(this.bQL);
                this.fce.aU(this.mStartPosition, this.cWp.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.caP != null) {
                        this.caP.tT(this.mStartPosition);
                    } else {
                        this.cWp.seekTo(this.mStartPosition);
                    }
                    if (!this.gtA) {
                        this.fce.showProgress();
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
                    }
                    this.gtv = true;
                }
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", Constants.OS_TYPE_VALUE);
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
    public void lM(boolean z) {
        if (hasNavBar(this.aRI.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gte.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.aRI.getPageActivity());
                this.gte.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gte.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.gte.setLayoutParams(layoutParams);
        }
    }

    public void bhq() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.J(this.aRI.getPageActivity(), this.aRI.getString(d.j.neterror));
        } else if (this.caP.isPlaying()) {
            pausePlay();
        } else if (this.fct) {
            aQE();
            if (this.gcF != null) {
                this.gcF.awH();
            }
        } else {
            bkX();
        }
    }

    public void aQu() {
        this.fcM = true;
        if (this.cos != null) {
            this.cos.aQu();
        }
    }

    public boolean bkQ() {
        return this.cWp != null && this.cWp.getVideoHeight() > this.cWp.getVideoWidth();
    }

    public boolean tQ(int i2) {
        switch (i2) {
            case 4:
                if (this.eoh) {
                    if (bkQ()) {
                        lM(false);
                        bkS();
                    } else {
                        aQu();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.fcD <= 0 || this.fcA == null) {
                    return false;
                }
                this.fcJ = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fcJ * 100.0d) / this.fcD);
                this.fcA.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.caP;
    }

    public VideoListMediaControllerView aQv() {
        return this.fce;
    }

    public void show() {
        this.fcc.setVisibility(0);
    }

    public void aQz() {
        if (this.fcn != null) {
            ViewGroup.LayoutParams layoutParams = this.fcn.getLayoutParams();
            this.fch = (FrameLayout.LayoutParams) this.fcc.getLayoutParams();
            this.fch.width = layoutParams.width;
            this.fch.height = layoutParams.height;
            this.fch.topMargin = 0;
            this.fcc.setLayoutParams(this.fch);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fcM) {
            if (this.eoh) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.fcM = false;
        }
        if (configuration.orientation == 2) {
            bkR();
        } else {
            bkS();
        }
        if (this.caP.isPlaying()) {
            aQJ();
        }
        bkT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkR() {
        this.eoh = true;
        if (bkQ()) {
            this.fcc.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.fcc.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.aRI, true);
        this.fcl.setVisibility(0);
        this.cZl.setVisibility(0);
        this.fcr.setVisibility(0);
        this.fcs.setVisibility(0);
        this.fcg.setVisibility(8);
        if (this.gtk) {
            this.cWu.startLoading();
            this.fco.setVisibility(0);
        } else {
            this.cWu.blR();
            this.fco.setVisibility(8);
        }
        if (this.gtl != null) {
            this.gtl.awC();
        }
        this.fck.setImageResource(d.f.icon_video_window);
        rg(this.fcI);
        aQt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkS() {
        this.eoh = false;
        if (this.fch != null) {
            this.fcc.setLayoutParams(this.fch);
        }
        a((TbPageContext) this.aRI, false);
        this.cZl.setVisibility(8);
        this.fcg.setVisibility(0);
        if (this.gtk) {
            this.cWu.startLoading();
            this.fco.setVisibility(0);
        } else {
            this.cWu.blR();
            this.fco.setVisibility(8);
        }
        if (this.gtl != null) {
            this.gtl.awD();
        }
        if (this.bcb == 3 && this.gtm != null) {
            this.gtm.gc(false);
        } else if (!this.fct && this.fcl != null) {
            this.fcl.clearAnimation();
            this.fcl.setVisibility(4);
            this.gtc.setVisibility(0);
            if (this.gtm != null) {
                this.gtm.awG();
            }
        }
        aQq();
        this.fck.setImageResource(d.f.icon_video_fullscreen);
        if (this.fce != null && (this.fce.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fce.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.fce.setLayoutParams(layoutParams);
        }
        this.fcc.setSystemUiVisibility(0);
        bkO();
    }

    public void bkT() {
        if (this.caP != null) {
            int ao = com.baidu.adp.lib.util.l.ao(this.aRI.getPageActivity());
            if (this.eoh) {
                ao = com.baidu.adp.lib.util.l.aq(this.aRI.getPageActivity());
            }
            this.gtc.setMax(ao);
            int duration = this.caP.getDuration();
            if (duration > 0) {
                if (this.gtf.getVisibility() == 0) {
                    this.gtc.setProgress(this.gtc.getMax());
                } else {
                    this.gtc.setProgress((int) ((this.caP.getCurrentPosition() * this.gtc.getMax()) / duration));
                }
            }
        }
    }

    private void rg(int i2) {
        if (this.fce != null && (this.fce.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fce.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.fce.setLayoutParams(layoutParams);
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

    public boolean aQB() {
        return !this.eoh;
    }

    public void a(g.f fVar) {
        this.fcp = fVar;
    }

    public void a(g.a aVar) {
        this.gti = aVar;
    }

    public void a(g.b bVar) {
        this.gtj = bVar;
    }

    public void aQC() {
        this.fcj.setImageResource(d.f.icon_video_play);
        this.cWu.blR();
        this.cZm.setVisibility(0);
        this.gtg.setVisibility(8);
        this.gtf.setVisibility(8);
        this.gth.setVisibility(8);
        this.bcb = 2;
        this.caP.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.caP != null) {
            this.caP.setPbLoadingTime(currentTimeMillis);
        }
        bL(str, str2);
    }

    public void bL(String str, String str2) {
        this.gtB = true;
        this.bcb = 0;
        this.caP.setRecoveryState(0);
        bK(str, str2);
        this.caP.bN(str, str2);
        this.cWu.startLoading();
        this.fco.setVisibility(0);
        this.cZm.setVisibility(8);
        this.fcj.setImageResource(d.f.icon_video_suspend_n);
        this.gtg.setVisibility(8);
        this.gtf.setVisibility(8);
        this.gth.setVisibility(8);
        this.cZq.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcQ);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcQ, 60000L);
    }

    public void bM(String str, String str2) {
        this.gtB = true;
        this.bcb = 0;
        this.caP.setRecoveryState(0);
        this.cWu.startLoading();
        this.fco.setVisibility(0);
        this.cZm.setVisibility(8);
        this.fcj.setImageResource(d.f.icon_video_suspend_n);
        this.gtg.setVisibility(8);
        this.gtf.setVisibility(8);
        this.gth.setVisibility(8);
        this.cZq.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcQ);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcQ, 60000L);
    }

    public void aQE() {
        this.bcb = 1;
        this.caP.setRecoveryState(1);
        this.caP.start();
        this.fcj.setImageResource(d.f.icon_video_suspend_n);
        this.fco.setVisibility(8);
        this.fcf.setVisibility(8);
        this.cWu.blR();
        this.fce.showProgress();
        this.cZm.setVisibility(8);
        this.gtg.setVisibility(8);
        this.gtf.setVisibility(8);
        this.gth.setVisibility(8);
        blb();
    }

    public void bkU() {
        if (com.baidu.adp.lib.util.j.oJ() && this.gtz && !StringUtils.isNull(this.bQL) && !StringUtils.isNull(this.bCV)) {
            this.gtz = false;
            this.gtA = true;
            bL(this.bQL, this.bCV);
        }
    }

    public void lN(boolean z) {
        if (this.caP != null) {
            this.caP.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.caP.isPlaying() && this.gtu) {
            bkV();
        }
        bla();
        this.caP.pause();
        aQC();
    }

    public void stopPlay() {
        if (this.caP.isPlaying() && this.gtu) {
            bkV();
        }
        this.bcb = 5;
        this.caP.setRecoveryState(5);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcQ);
        this.caP.stopPlayback();
        this.fct = false;
        this.gtB = false;
        this.mStartPosition = 0;
        aDC();
    }

    public void bkV() {
        z.blV().aB(this.bQL, this.caP.getCurrentPosition());
    }

    public void lO(boolean z) {
        this.gtu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP(boolean z) {
        if (this.fcl != null) {
            this.fcf.setVisibility(0);
            this.cZm.setVisibility(0);
            this.gtg.setVisibility(8);
            this.gtf.setVisibility(8);
            this.gth.setVisibility(8);
            this.cWu.blR();
            this.fcj.setImageResource(d.f.icon_video_play);
            this.fcl.setVisibility(4);
            this.gtc.setVisibility(8);
            this.cZq.setVisibility(8);
            this.fce.UD();
            this.fco.setVisibility(z ? 0 : 8);
        }
    }

    public void aDC() {
        lP(true);
    }

    public boolean bkW() {
        if (this.caP == null) {
            return false;
        }
        return this.caP.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.caP == null) {
            return 0;
        }
        return this.caP.getCurrentPosition();
    }

    public void a(i iVar) {
        this.gtp = iVar;
    }

    public void a(h hVar) {
        this.gto = hVar;
    }

    public void a(g gVar) {
        this.gcF = gVar;
    }

    public void a(f fVar) {
        this.gtn = fVar;
    }

    public void qO(String str) {
        this.gcj = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkX() {
        a(this.bQL, this.bCV, null, new Object[0]);
    }

    public void b(InterfaceC0219c interfaceC0219c) {
        this.gtm = interfaceC0219c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        if (com.baidu.adp.lib.util.j.oL()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gtw = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gts != null) {
                    this.gts.gb(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
                aVar.dk(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bkY();
                        if (c.this.gtw) {
                            c.this.bM(str, str2);
                        } else {
                            c.this.bL(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lS(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRI).AV();
                return;
            } else if (this.gts != null) {
                this.gts.gb(true);
                return;
            } else {
                if (!this.gtb) {
                    this.gtb = true;
                    com.baidu.adp.lib.util.l.showToast(this.aRI.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                if (this.gtw) {
                    bM(str, str2);
                } else {
                    bL(str, str2);
                }
                if (dVar != null) {
                    dVar.lS(true);
                    return;
                }
                return;
            }
        }
        if (this.gtw) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.lS(true);
        }
        if (this.gtr != null) {
            this.gtr.awE();
        }
    }

    public void bkY() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void ov(String str) {
        this.fco.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcU);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcQ);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtF);
        this.cos.stop();
        this.fcL.unregister(this.aRI.getPageActivity());
    }

    public void rg(String str) {
        this.fcs.setText(str);
    }

    public boolean aQF() {
        return this.fct;
    }

    public void aQG() {
        if (this.fcl != null) {
            aQI();
            this.fcl.setVisibility(0);
            this.gte.setVisibility(0);
            if (this.gtm != null) {
                this.gtm.gc(true);
            }
            this.gtc.setVisibility(8);
            this.dIp.setAnimationListener(this.fcS);
            this.fcl.startAnimation(this.dIp);
            this.fcv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        if (this.fcl != null) {
            if (this.fcl.getVisibility() == 0) {
                aQI();
                this.fcl.setVisibility(8);
                this.gtc.setVisibility(0);
                if (this.gtm != null) {
                    this.gtm.awG();
                    return;
                }
                return;
            }
            aQJ();
        }
    }

    public void aQH() {
        if (this.fcl != null) {
            aQI();
            this.fcl.setVisibility(0);
            this.gte.setVisibility(0);
            if (this.gtm != null) {
                this.gtm.gc(false);
            }
            this.gtc.setVisibility(8);
            this.dIq.setAnimationListener(this.fcT);
            this.fcl.startAnimation(this.dIq);
        }
    }

    public void bla() {
        if (this.fcl != null) {
            aQI();
            this.fcl.setVisibility(0);
            this.gte.setVisibility(0);
            this.gtc.setVisibility(8);
            if (this.gtm != null) {
                this.gtm.gc(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQI() {
        if (this.fcl != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcU);
            this.dIq.setAnimationListener(null);
            this.dIp.setAnimationListener(null);
            this.fcl.clearAnimation();
            this.fcv = false;
        }
    }

    public void aQJ() {
        aQH();
        blb();
    }

    private void blb() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcU);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcU, 3000L);
    }

    public void a(b bVar) {
        this.gtl = bVar;
    }

    public void ri(int i2) {
        if (this.caP.getDuration() - i2 <= 3000) {
            aQI();
            if (this.fcl != null) {
                this.fcl.setVisibility(0);
                this.gte.setVisibility(0);
                this.gtc.setVisibility(8);
                if (this.gtm != null) {
                    this.gtm.gc(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void Q(boolean z, boolean z2) {
        int i2 = 8;
        if (this.cos != null) {
            if (this.fck != null || this.gtd != null) {
                this.fck.setVisibility((z || !z2) ? 0 : 8);
                View view = this.gtd;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.fce != null && (this.fce.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fce.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.tbds52);
                this.fce.setLayoutParams(layoutParams);
            }
            this.cos.lU(z);
        }
    }

    public int bN(Context context) {
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
            return com.baidu.adp.lib.util.l.aq(context);
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

    public int blc() {
        return this.bcb;
    }

    public void a(k kVar) {
        this.gtq = kVar;
    }

    public void a(j jVar) {
        this.gtr = jVar;
    }

    public void a(e eVar) {
        this.gts = eVar;
    }

    public void lQ(boolean z) {
        this.gty = z;
    }

    public void lR(boolean z) {
        this.gtk = z;
    }

    public void tR(int i2) {
        this.gtC = i2;
    }
}
