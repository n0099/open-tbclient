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
    private static int fcI;
    private TbPageContext<?> aRR;
    private String bDf;
    private String bQV;
    private y cWD;
    private com.baidu.tieba.play.g cWy;
    private View cZu;
    private ImageView cZv;
    private View cZz;
    private QuickVideoView caY;
    private p coB;
    private Animation dIw;
    private Animation dIx;
    private ImageView fcA;
    private int fcB;
    private int fcG;
    private int fcH;
    private CallStateReceiver fcJ;
    protected View fca;
    private VideoListMediaControllerView fcc;
    private View fcd;
    private FrameLayout fce;
    protected FrameLayout.LayoutParams fcf;
    private ImageView fch;
    private ImageView fci;
    private View fcj;
    private View fcl;
    private TbImageView fcm;
    private g.f fcn;
    private ImageView fcp;
    private TextView fcq;
    private View fcv;
    private View fcw;
    private TextView fcx;
    private SeekBar fcy;
    private ImageView fcz;
    private g gcA;
    private ProgressBar gsX;
    private View gsY;
    private View gsZ;
    private TextView gta;
    private TextView gtb;
    private TextView gtc;
    private g.a gtd;
    private g.b gte;
    private b gtg;
    private InterfaceC0218c gth;
    private f gti;
    private h gtj;
    private i gtk;
    private k gtl;
    private j gtm;
    private e gtn;
    private TextView gts;
    private boolean gtu;
    private boolean gtv;
    private boolean gtw;
    private int gtx;
    private boolean gty;
    private boolean gtz;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean gsW = false;
    protected boolean eoc = false;
    private boolean fcr = false;
    private boolean fct = false;
    private boolean gtf = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fcC = 0;
    private int fcD = 0;
    private boolean fcK = false;
    private boolean gto = true;
    private boolean gtp = true;
    private boolean gtq = false;
    private boolean gtr = false;
    private String gce = null;
    private int bcl = -1;
    private boolean gtt = false;
    private g.f bPD = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cWy = gVar;
            if (c.this.bkP()) {
                c.this.cWD.blP();
                c.this.gty = true;
                return;
            }
            c.this.akX();
        }
    };
    private VideoLoadingProgressView.a cWN = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.akX();
        }
    };
    private Runnable fcM = new Runnable() { // from class: com.baidu.tieba.play.c.15
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.caY.getCurrentPosition() > 100) {
                c.this.fcr = true;
                c.this.fcd.setVisibility(8);
                c.this.cZz.setVisibility(8);
                c.this.cWD.blQ();
                c.this.fcm.setVisibility(8);
                c.this.aQI();
                if (c.this.bcl == 1 || c.this.bcl == 2) {
                    if (c.this.fcj != null) {
                        c.this.fcj.setVisibility(0);
                        c.this.gsZ.setVisibility(0);
                        c.this.gsX.setVisibility(8);
                        if (c.this.gth != null) {
                            c.this.gth.gc(false);
                        }
                    }
                    c.this.fcc.showProgress();
                    c.this.aQJ();
                }
                if (c.this.fcn != null) {
                    c.this.fcn.onPrepared(c.this.caY.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcM, 20L);
        }
    };
    private g.a bPC = new g.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.fcr = false;
            c.this.gtw = false;
            c.this.mStartPosition = 0;
            c.this.aQq();
            c.this.fcd.setVisibility(0);
            c.this.gsX.setVisibility(8);
            c.this.gsX.setProgress(c.this.gsX.getMax());
            if (c.this.gth != null) {
                c.this.gth.gc(false);
            }
            if (c.this.eoc) {
                c.this.fcj.setVisibility(0);
                c.this.fcp.setVisibility(0);
                c.this.fcq.setVisibility(0);
                c.this.gsZ.setVisibility(8);
            } else {
                c.this.fcj.setVisibility(8);
                c.this.fcp.setVisibility(8);
                c.this.fcq.setVisibility(8);
                c.this.gsZ.setVisibility(8);
            }
            if (c.this.caY == null || c.this.caY.getDuration() > 150000) {
                c.this.lK(false);
            } else {
                c.this.gta.setVisibility(0);
            }
            z.blV().remove(c.this.bQV);
            if (c.this.gtd != null) {
                c.this.gtd.onCompletion(gVar);
            }
            c.this.bcl = 3;
            c.this.caY.setRecoveryState(3);
            if (!c.this.eoc && c.this.caY != null && c.this.caY.getDuration() <= 150000) {
                if (!c.this.gtt) {
                    if (c.this.gtj != null) {
                        c.this.gtj.lk(true);
                    }
                    c.this.bL(c.this.bQV, c.this.bDf);
                    return;
                }
                c.this.bcl = 5;
                c.this.caY.setRecoveryState(5);
                c.this.caY.getPlayer().pause();
                c.this.caY.getPlayer().seekTo(0);
            }
        }
    };
    private g.b fcN = new g.b() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cZz.setVisibility(0);
            c.this.cWD.blR();
            c.this.bcl = 4;
            c.this.caY.setRecoveryState(4);
            if (c.this.gte != null) {
                c.this.gte.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.oJ()) {
                c.this.gtu = true;
            }
            c.this.gtw = false;
            return true;
        }
    };
    private Runnable fcO = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            c.this.cZz.setVisibility(0);
            c.this.cWD.blR();
        }
    };
    private g.InterfaceC0219g bPH = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0219g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gtq) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.gtA, 200L);
            }
        }
    };
    private Runnable gtA = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.caY == null || !c.this.gtq) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcM, 200L);
                c.this.gtq = false;
            } else if (c.this.mStartPosition != c.this.caY.getCurrentPosition()) {
                c.this.gtq = false;
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcM, 20L);
            } else {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.gtA, 200L);
            }
        }
    };
    private QuickVideoView.b cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fcr = false;
            c.this.gtw = false;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcM);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcO);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cZz.getId()) {
                c.this.bkX();
            } else if (view.getId() != c.this.cZv.getId() && view.getId() != c.this.fch.getId()) {
                if (view.getId() == c.this.gtb.getId()) {
                    if (c.this.gti != null) {
                        c.this.gti.bhz();
                    }
                } else if (view.getId() == c.this.gta.getId()) {
                    if (c.this.gtj != null) {
                        c.this.gtj.lk(false);
                    }
                    c.this.bL(c.this.bQV, c.this.bDf);
                } else if (view.getId() != c.this.fci.getId() && view.getId() != c.this.gsY.getId()) {
                    if (view.getId() == c.this.fcp.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.gtm != null) {
                            c.this.gtm.awE();
                        }
                        if (c.this.bkQ()) {
                            c.this.bkS();
                            c.this.lH(false);
                            return;
                        }
                        c.this.aQu();
                    }
                } else {
                    if (c.this.eoc) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.gtm != null) {
                        c.this.gtm.awE();
                    }
                    if (c.this.bkQ()) {
                        if (c.this.eoc) {
                            c.this.bkS();
                        } else {
                            c.this.bkR();
                        }
                        c.this.lH(c.this.eoc);
                        return;
                    }
                    c.this.aQu();
                }
            } else {
                c.this.bhq();
            }
        }
    };
    private Animation.AnimationListener fcQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.fcj != null) {
                c.this.fcj.setVisibility(8);
                c.this.gsX.setVisibility(0);
                c.this.fct = false;
                if (c.this.gth != null) {
                    c.this.gth.awF();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener fcR = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable fcS = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aQG();
        }
    };
    private CustomMessageListener fcT = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private v.b feI = new v.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.v.b
        public void jo(int i2) {
            int duration;
            if (c.this.caY != null && (duration = c.this.caY.getDuration()) > 0 && c.this.gsX != null) {
                c.this.gsX.setProgress((int) ((i2 * c.this.fca.getWidth()) / duration));
            }
            c.this.rh(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bTJ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.fct) {
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
                c.this.bL(c.this.bQV, c.this.bDf);
            }
        }
    };
    private QuickVideoView.a gtB = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bld() {
            if (!c.this.gtt) {
                c.this.cWD.startLoading();
                c.this.fcm.setVisibility(0);
                c.this.cZv.setVisibility(8);
                c.this.fch.setImageResource(d.f.icon_video_suspend_n);
                c.this.gtb.setVisibility(8);
                c.this.gta.setVisibility(8);
                c.this.gtc.setVisibility(8);
                c.this.cZz.setVisibility(8);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcO);
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcO, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void awB();

        void awC();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0218c {
        void awF();

        void gc(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lN(boolean z);
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
        void awG();
    }

    /* loaded from: classes.dex */
    public interface h {
        void lk(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void awD();

        void awE();
    }

    /* loaded from: classes.dex */
    public interface k {
        void bhA();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.fcG = 0;
        this.gtz = true;
        if (tbPageContext != null) {
            this.aRR = tbPageContext;
            this.fca = p(tbPageContext);
            this.mRootView = view;
            this.gtz = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.fca);
            }
            this.fcl = view;
            this.fca.setOnClickListener(this.mOnClickListener);
            this.caY = (QuickVideoView) this.fca.findViewById(d.g.videoView);
            this.cWD = new y((ViewGroup) this.fca.findViewById(d.g.auto_video_loading_container));
            this.cWD.setLoadingAnimationListener(this.cWN);
            this.fcc = (VideoListMediaControllerView) this.fca.findViewById(d.g.media_controller);
            this.fcc.setPlayer(this.caY);
            this.gsX = (ProgressBar) this.fca.findViewById(d.g.pgrBottomProgress);
            this.gsX.setMax(com.baidu.adp.lib.util.l.ao(this.aRR.getPageActivity()));
            this.gsX.setProgress(0);
            this.fcc.setOnSeekBarChangeListener(this.bTJ);
            this.fcc.setOnProgressUpdatedListener(this.feI);
            this.fcd = this.fca.findViewById(d.g.black_mask);
            this.cZz = this.fca.findViewById(d.g.layout_error);
            this.cZz.setOnClickListener(this.mOnClickListener);
            this.gts = (TextView) this.fca.findViewById(d.g.auto_video_error_tips);
            this.fce = (FrameLayout) this.fca.findViewById(d.g.danmu_container);
            this.fch = (ImageView) this.fca.findViewById(d.g.img_play_icon);
            this.fch.setOnClickListener(this.mOnClickListener);
            this.fci = (ImageView) this.fca.findViewById(d.g.img_full_screen);
            this.fci.setOnClickListener(this.mOnClickListener);
            this.gsY = this.fca.findViewById(d.g.full_screen_container);
            this.gsY.setOnClickListener(this.mOnClickListener);
            this.fcj = this.fca.findViewById(d.g.layout_media_controller);
            this.gsZ = this.fca.findViewById(d.g.time_show_controller);
            this.caY.setOnPreparedListener(this.bPD);
            this.caY.setOnCompletionListener(this.bPC);
            this.caY.setOnErrorListener(this.fcN);
            this.caY.setOnSeekCompleteListener(this.bPH);
            this.caY.setOnSurfaceDestroyedListener(this.cbh);
            this.caY.setOnRecoveryCallback(this.gtB);
            this.cZv = (ImageView) this.fca.findViewById(d.g.img_play);
            this.cZv.setOnClickListener(this.mOnClickListener);
            this.gta = (TextView) this.fca.findViewById(d.g.txt_replay);
            this.gta.setOnClickListener(this.mOnClickListener);
            this.gtb = (TextView) this.fca.findViewById(d.g.txt_playnext);
            this.gtb.setOnClickListener(this.mOnClickListener);
            this.gtc = (TextView) this.fca.findViewById(d.g.txt_next_video_title);
            this.fcm = (TbImageView) this.fca.findViewById(d.g.video_thumbnail);
            this.fcm.setDefaultErrorResource(0);
            this.fcm.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.aRR.getPageActivity());
            this.mScreenHeight = bN(this.aRR.getPageActivity());
            this.fcp = (ImageView) this.fca.findViewById(d.g.img_exit);
            this.fcp.setOnClickListener(this.mOnClickListener);
            this.fcq = (TextView) this.fca.findViewById(d.g.video_title);
            this.cZu = this.fca.findViewById(d.g.layout_title);
            this.cZu.setVisibility(8);
            this.dIw = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dIx = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aRR.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.fcB = this.mAudioManager.getStreamMaxVolume(3);
            this.fcH = this.mAudioManager.getStreamVolume(3);
            fcI = 100 / this.fcB;
            this.fca.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.gtk != null) {
                        c.this.gtk.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.fcr) {
                            if (c.this.mStatus == 1 && c.this.fcD != 0) {
                                c.this.b(c.this.fcD == 1 ? 1000.0f : -1000.0f, false);
                                c.this.fcD = 0;
                                c.this.fcC = 0;
                            }
                            if (!c.this.caY.isPlaying() && 8 == c.this.cZv.getVisibility()) {
                                c.this.cZv.setVisibility(0);
                                c.this.gtb.setVisibility(8);
                                c.this.gta.setVisibility(8);
                                c.this.gtc.setVisibility(8);
                            }
                        }
                        c.this.aQq();
                        if (c.this.gtk != null) {
                            c.this.gtk.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.coB = new p(this.aRR.getPageActivity());
            if (this.gtz) {
                this.coB.start();
            }
            this.fcG = com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.ds16);
            this.fcJ = new CallStateReceiver();
            this.fcJ.register(this.aRR.getPageActivity());
            this.aRR.registerListener(this.fcT);
            bkO();
        }
    }

    public void bkO() {
        if (this.gto) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fca.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.fca.setSystemUiVisibility(0);
    }

    public void lG(boolean z) {
        this.gto = z;
        bkO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        this.mStatus = 0;
        if (this.fcv != null && this.fcv.getParent() != null && (this.fcv.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fcv.getParent()).removeView(this.fcv);
                this.fcv = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fcw != null && this.fcw.getParent() != null && (this.fcw.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fcw.getParent()).removeView(this.fcw);
                this.fcw = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aQr() {
        if (this.mStatus == 1) {
            if (this.fcv == null && this.fca != null && (this.fca instanceof ViewGroup)) {
                LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.fca, true);
                this.fcv = this.fca.findViewById(d.g.lay_jindu);
                this.fcx = (TextView) this.fcv.findViewById(d.g.show_time);
                this.fcA = (ImageView) this.fcv.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fcw == null && this.fca != null && (this.fca instanceof ViewGroup)) {
            LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.fca, true);
            this.fcw = this.fca.findViewById(d.g.lay_voice);
            this.fcz = (ImageView) this.fcw.findViewById(d.g.arrow_voice_icon);
            this.fcy = (SeekBar) this.fcw.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gtk != null) {
                c.this.gtk.onStart();
            }
            if (c.this.eoc && c.this.fcr) {
                if (!c.this.caY.isPlaying() && c.this.cZv.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cZv.setVisibility(8);
                    c.this.gtb.setVisibility(8);
                    c.this.gta.setVisibility(8);
                    c.this.gtc.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ar(f2);
                    }
                } else {
                    if (c.this.eoc) {
                        c.this.aQt();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fcC = c.this.caY.getCurrentPosition();
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
            if (c.this.gtl != null) {
                c.this.gtl.bhA();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.fcr) {
                if (c.this.bcl != 2) {
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
            this.fca.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.fca.setSystemUiVisibility(4);
        } else {
            this.fca.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f2) {
        if (!this.fcr) {
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
        if (this.mProgress % fcI == 0) {
            if (f2 > 0.0f && this.fcH < this.fcB) {
                this.fcH++;
            }
            if (f2 < 0.0f && this.fcH > 0) {
                this.fcH--;
            }
        }
        if (this.mProgress > 0) {
            this.fcz.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.fcz.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fcH, 0);
        this.fcy.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fcC += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fcD = 1;
            } else {
                this.fcC += 1000;
                this.fcD = 2;
            }
            if (this.fcC < 0) {
                this.fcC = 0;
            } else if (this.fcC > this.caY.getDuration()) {
                this.fcC = this.caY.getDuration();
            }
        }
        aQr();
        String tT = this.fcc.tT(this.fcC);
        if (f2 > 0.0f) {
            this.fcA.setImageResource(d.f.icon_kuaitui);
        } else {
            this.fcA.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tT)) {
            this.fcx.setText(new StringBuilder().append(tT).append("/").append(this.fcc.tT(this.caY.getDuration())));
        }
        this.fcc.R(this.fcC, z ? false : true);
        this.fcj.setVisibility(8);
        this.gsX.setVisibility(0);
        bkT();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.bQV = str;
        this.bDf = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkP() {
        if (this.gtf) {
            return this.gtx == 0 && !this.gty;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.caY != null && this.cWy != null) {
            if (this.gtw) {
                this.caY.start();
                this.gtw = false;
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcM);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.fcM, 20L);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
            if (this.caY.blu()) {
                this.bcl = 1;
                this.caY.setRecoveryState(1);
            }
            if (this.cWy != null && this.fcc != null) {
                this.mStartPosition = z.blV().rl(this.bQV);
                this.fcc.aU(this.mStartPosition, this.cWy.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.caY != null) {
                        this.caY.tS(this.mStartPosition);
                    } else {
                        this.cWy.seekTo(this.mStartPosition);
                    }
                    if (!this.gtv) {
                        this.fcc.showProgress();
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcM);
                    }
                    this.gtq = true;
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
    public void lH(boolean z) {
        if (hasNavBar(this.aRR.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsZ.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.aRR.getPageActivity());
                this.gsZ.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gsZ.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.gsZ.setLayoutParams(layoutParams);
        }
    }

    public void bhq() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.J(this.aRR.getPageActivity(), this.aRR.getString(d.j.neterror));
        } else if (this.caY.isPlaying()) {
            pausePlay();
        } else if (this.fcr) {
            aQE();
            if (this.gcA != null) {
                this.gcA.awG();
            }
        } else {
            bkX();
        }
    }

    public void aQu() {
        this.fcK = true;
        if (this.coB != null) {
            this.coB.aQu();
        }
    }

    public boolean bkQ() {
        return this.cWy != null && this.cWy.getVideoHeight() > this.cWy.getVideoWidth();
    }

    public boolean tP(int i2) {
        switch (i2) {
            case 4:
                if (this.eoc) {
                    if (bkQ()) {
                        lH(false);
                        bkS();
                    } else {
                        aQu();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.fcB <= 0 || this.fcy == null) {
                    return false;
                }
                this.fcH = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fcH * 100.0d) / this.fcB);
                this.fcy.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.caY;
    }

    public VideoListMediaControllerView aQv() {
        return this.fcc;
    }

    public void show() {
        this.fca.setVisibility(0);
    }

    public void aQz() {
        if (this.fcl != null) {
            ViewGroup.LayoutParams layoutParams = this.fcl.getLayoutParams();
            this.fcf = (FrameLayout.LayoutParams) this.fca.getLayoutParams();
            this.fcf.width = layoutParams.width;
            this.fcf.height = layoutParams.height;
            this.fcf.topMargin = 0;
            this.fca.setLayoutParams(this.fcf);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fcK) {
            if (this.eoc) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.fcK = false;
        }
        if (configuration.orientation == 2) {
            bkR();
        } else {
            bkS();
        }
        if (this.caY.isPlaying()) {
            aQJ();
        }
        bkT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkR() {
        this.eoc = true;
        if (bkQ()) {
            this.fca.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.fca.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.aRR, true);
        this.fcj.setVisibility(0);
        this.cZu.setVisibility(0);
        this.fcp.setVisibility(0);
        this.fcq.setVisibility(0);
        this.fce.setVisibility(8);
        if (this.gtf) {
            this.cWD.startLoading();
            this.fcm.setVisibility(0);
        } else {
            this.cWD.blR();
            this.fcm.setVisibility(8);
        }
        if (this.gtg != null) {
            this.gtg.awB();
        }
        this.fci.setImageResource(d.f.icon_video_window);
        rf(this.fcG);
        aQt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkS() {
        this.eoc = false;
        if (this.fcf != null) {
            this.fca.setLayoutParams(this.fcf);
        }
        a((TbPageContext) this.aRR, false);
        this.cZu.setVisibility(8);
        this.fce.setVisibility(0);
        if (this.gtf) {
            this.cWD.startLoading();
            this.fcm.setVisibility(0);
        } else {
            this.cWD.blR();
            this.fcm.setVisibility(8);
        }
        if (this.gtg != null) {
            this.gtg.awC();
        }
        if (this.bcl == 3 && this.gth != null) {
            this.gth.gc(false);
        } else if (!this.fcr && this.fcj != null) {
            this.fcj.clearAnimation();
            this.fcj.setVisibility(4);
            this.gsX.setVisibility(0);
            if (this.gth != null) {
                this.gth.awF();
            }
        }
        aQq();
        this.fci.setImageResource(d.f.icon_video_fullscreen);
        if (this.fcc != null && (this.fcc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fcc.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.fcc.setLayoutParams(layoutParams);
        }
        this.fca.setSystemUiVisibility(0);
        bkO();
    }

    public void bkT() {
        if (this.caY != null) {
            int ao = com.baidu.adp.lib.util.l.ao(this.aRR.getPageActivity());
            if (this.eoc) {
                ao = com.baidu.adp.lib.util.l.aq(this.aRR.getPageActivity());
            }
            this.gsX.setMax(ao);
            int duration = this.caY.getDuration();
            if (duration > 0) {
                if (this.gta.getVisibility() == 0) {
                    this.gsX.setProgress(this.gsX.getMax());
                } else {
                    this.gsX.setProgress((int) ((this.caY.getCurrentPosition() * this.gsX.getMax()) / duration));
                }
            }
        }
    }

    private void rf(int i2) {
        if (this.fcc != null && (this.fcc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fcc.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.fcc.setLayoutParams(layoutParams);
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
        return !this.eoc;
    }

    public void a(g.f fVar) {
        this.fcn = fVar;
    }

    public void a(g.a aVar) {
        this.gtd = aVar;
    }

    public void a(g.b bVar) {
        this.gte = bVar;
    }

    public void aQC() {
        this.fch.setImageResource(d.f.icon_video_play);
        this.cWD.blR();
        this.cZv.setVisibility(0);
        this.gtb.setVisibility(8);
        this.gta.setVisibility(8);
        this.gtc.setVisibility(8);
        this.bcl = 2;
        this.caY.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.caY != null) {
            this.caY.setPbLoadingTime(currentTimeMillis);
        }
        bL(str, str2);
    }

    public void bL(String str, String str2) {
        this.gtw = true;
        this.bcl = 0;
        this.caY.setRecoveryState(0);
        bK(str, str2);
        this.caY.bN(str, str2);
        this.cWD.startLoading();
        this.fcm.setVisibility(0);
        this.cZv.setVisibility(8);
        this.fch.setImageResource(d.f.icon_video_suspend_n);
        this.gtb.setVisibility(8);
        this.gta.setVisibility(8);
        this.gtc.setVisibility(8);
        this.cZz.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcO, 60000L);
    }

    public void bM(String str, String str2) {
        this.gtw = true;
        this.bcl = 0;
        this.caY.setRecoveryState(0);
        this.cWD.startLoading();
        this.fcm.setVisibility(0);
        this.cZv.setVisibility(8);
        this.fch.setImageResource(d.f.icon_video_suspend_n);
        this.gtb.setVisibility(8);
        this.gta.setVisibility(8);
        this.gtc.setVisibility(8);
        this.cZz.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcO, 60000L);
    }

    public void aQE() {
        this.bcl = 1;
        this.caY.setRecoveryState(1);
        this.caY.start();
        this.fch.setImageResource(d.f.icon_video_suspend_n);
        this.fcm.setVisibility(8);
        this.fcd.setVisibility(8);
        this.cWD.blR();
        this.fcc.showProgress();
        this.cZv.setVisibility(8);
        this.gtb.setVisibility(8);
        this.gta.setVisibility(8);
        this.gtc.setVisibility(8);
        blb();
    }

    public void bkU() {
        if (com.baidu.adp.lib.util.j.oJ() && this.gtu && !StringUtils.isNull(this.bQV) && !StringUtils.isNull(this.bDf)) {
            this.gtu = false;
            this.gtv = true;
            bL(this.bQV, this.bDf);
        }
    }

    public void lI(boolean z) {
        if (this.caY != null) {
            this.caY.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.caY.isPlaying() && this.gtp) {
            bkV();
        }
        bla();
        this.caY.pause();
        aQC();
    }

    public void stopPlay() {
        if (this.caY.isPlaying() && this.gtp) {
            bkV();
        }
        this.bcl = 5;
        this.caY.setRecoveryState(5);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcM);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
        this.caY.stopPlayback();
        this.fcr = false;
        this.gtw = false;
        this.mStartPosition = 0;
        aDC();
    }

    public void bkV() {
        z.blV().aB(this.bQV, this.caY.getCurrentPosition());
    }

    public void lJ(boolean z) {
        this.gtp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(boolean z) {
        if (this.fcj != null) {
            this.fcd.setVisibility(0);
            this.cZv.setVisibility(0);
            this.gtb.setVisibility(8);
            this.gta.setVisibility(8);
            this.gtc.setVisibility(8);
            this.cWD.blR();
            this.fch.setImageResource(d.f.icon_video_play);
            this.fcj.setVisibility(4);
            this.gsX.setVisibility(8);
            this.cZz.setVisibility(8);
            this.fcc.UD();
            this.fcm.setVisibility(z ? 0 : 8);
        }
    }

    public void aDC() {
        lK(true);
    }

    public boolean bkW() {
        if (this.caY == null) {
            return false;
        }
        return this.caY.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.caY == null) {
            return 0;
        }
        return this.caY.getCurrentPosition();
    }

    public void a(i iVar) {
        this.gtk = iVar;
    }

    public void a(h hVar) {
        this.gtj = hVar;
    }

    public void a(g gVar) {
        this.gcA = gVar;
    }

    public void a(f fVar) {
        this.gti = fVar;
    }

    public void qO(String str) {
        this.gce = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkX() {
        a(this.bQV, this.bDf, null, new Object[0]);
    }

    public void b(InterfaceC0218c interfaceC0218c) {
        this.gth = interfaceC0218c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        if (com.baidu.adp.lib.util.j.oL()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gtr = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gtn != null) {
                    this.gtn.gb(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
                aVar.dk(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bkY();
                        if (c.this.gtr) {
                            c.this.bM(str, str2);
                        } else {
                            c.this.bL(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lN(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRR).AU();
                return;
            } else if (this.gtn != null) {
                this.gtn.gb(true);
                return;
            } else {
                if (!this.gsW) {
                    this.gsW = true;
                    com.baidu.adp.lib.util.l.showToast(this.aRR.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                if (this.gtr) {
                    bM(str, str2);
                } else {
                    bL(str, str2);
                }
                if (dVar != null) {
                    dVar.lN(true);
                    return;
                }
                return;
            }
        }
        if (this.gtr) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.lN(true);
        }
        if (this.gtm != null) {
            this.gtm.awD();
        }
    }

    public void bkY() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void ov(String str) {
        this.fcm.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcS);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcM);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcO);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtA);
        this.coB.stop();
        this.fcJ.unregister(this.aRR.getPageActivity());
    }

    public void rg(String str) {
        this.fcq.setText(str);
    }

    public boolean aQF() {
        return this.fcr;
    }

    public void aQG() {
        if (this.fcj != null) {
            aQI();
            this.fcj.setVisibility(0);
            this.gsZ.setVisibility(0);
            if (this.gth != null) {
                this.gth.gc(true);
            }
            this.gsX.setVisibility(8);
            this.dIw.setAnimationListener(this.fcQ);
            this.fcj.startAnimation(this.dIw);
            this.fct = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        if (this.fcj != null) {
            if (this.fcj.getVisibility() == 0) {
                aQI();
                this.fcj.setVisibility(8);
                this.gsX.setVisibility(0);
                if (this.gth != null) {
                    this.gth.awF();
                    return;
                }
                return;
            }
            aQJ();
        }
    }

    public void aQH() {
        if (this.fcj != null) {
            aQI();
            this.fcj.setVisibility(0);
            this.gsZ.setVisibility(0);
            if (this.gth != null) {
                this.gth.gc(false);
            }
            this.gsX.setVisibility(8);
            this.dIx.setAnimationListener(this.fcR);
            this.fcj.startAnimation(this.dIx);
        }
    }

    public void bla() {
        if (this.fcj != null) {
            aQI();
            this.fcj.setVisibility(0);
            this.gsZ.setVisibility(0);
            this.gsX.setVisibility(8);
            if (this.gth != null) {
                this.gth.gc(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQI() {
        if (this.fcj != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcS);
            this.dIx.setAnimationListener(null);
            this.dIw.setAnimationListener(null);
            this.fcj.clearAnimation();
            this.fct = false;
        }
    }

    public void aQJ() {
        aQH();
        blb();
    }

    private void blb() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcS);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcS, 3000L);
    }

    public void a(b bVar) {
        this.gtg = bVar;
    }

    public void rh(int i2) {
        if (this.caY.getDuration() - i2 <= 3000) {
            aQI();
            if (this.fcj != null) {
                this.fcj.setVisibility(0);
                this.gsZ.setVisibility(0);
                this.gsX.setVisibility(8);
                if (this.gth != null) {
                    this.gth.gc(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void Q(boolean z, boolean z2) {
        int i2 = 8;
        if (this.coB != null) {
            if (this.fci != null || this.gsY != null) {
                this.fci.setVisibility((z || !z2) ? 0 : 8);
                View view = this.gsY;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.fcc != null && (this.fcc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fcc.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.tbds52);
                this.fcc.setLayoutParams(layoutParams);
            }
            this.coB.lP(z);
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
        return this.bcl;
    }

    public void a(k kVar) {
        this.gtl = kVar;
    }

    public void a(j jVar) {
        this.gtm = jVar;
    }

    public void a(e eVar) {
        this.gtn = eVar;
    }

    public void lL(boolean z) {
        this.gtt = z;
    }

    public void lM(boolean z) {
        this.gtf = z;
    }

    public void tQ(int i2) {
        this.gtx = i2;
    }
}
