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
    private static int fcw;
    private TbPageContext<?> aRG;
    private String bCS;
    private String bQI;
    private com.baidu.tieba.play.g cWm;
    private y cWr;
    private View cZi;
    private ImageView cZj;
    private View cZn;
    private QuickVideoView caM;
    private p cop;
    private Animation dIk;
    private Animation dIl;
    protected View fbO;
    private VideoListMediaControllerView fbQ;
    private View fbR;
    private FrameLayout fbS;
    protected FrameLayout.LayoutParams fbT;
    private ImageView fbV;
    private ImageView fbW;
    private View fbX;
    private View fbZ;
    private TbImageView fca;
    private g.f fcb;
    private ImageView fcd;
    private TextView fce;
    private View fcj;
    private View fck;
    private TextView fcl;
    private SeekBar fcm;
    private ImageView fcn;
    private ImageView fco;
    private int fcp;
    private int fcu;
    private int fcv;
    private CallStateReceiver fcx;
    private g gcp;
    private ProgressBar gsM;
    private View gsN;
    private View gsO;
    private TextView gsP;
    private TextView gsQ;
    private TextView gsR;
    private g.a gsS;
    private g.b gsT;
    private b gsV;
    private InterfaceC0219c gsW;
    private f gsX;
    private h gsY;
    private i gsZ;
    private k gta;
    private j gtb;
    private e gtc;
    private TextView gth;
    private boolean gtj;
    private boolean gtk;
    private boolean gtl;
    private int gtm;
    private boolean gtn;
    private boolean gto;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean gsL = false;
    protected boolean enQ = false;
    private boolean fcf = false;
    private boolean fch = false;
    private boolean gsU = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int fcq = 0;
    private int fcr = 0;
    private boolean fcy = false;
    private boolean gtd = true;
    private boolean gte = true;
    private boolean gtf = false;
    private boolean gtg = false;
    private String gbT = null;
    private int bbZ = -1;
    private boolean gti = false;
    private g.f bPq = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cWm = gVar;
            if (c.this.bkO()) {
                c.this.cWr.blO();
                c.this.gtn = true;
                return;
            }
            c.this.akW();
        }
    };
    private VideoLoadingProgressView.a cWB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.akW();
        }
    };
    private Runnable fcA = new Runnable() { // from class: com.baidu.tieba.play.c.15
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.caM.getCurrentPosition() > 100) {
                c.this.fcf = true;
                c.this.fbR.setVisibility(8);
                c.this.cZn.setVisibility(8);
                c.this.cWr.blP();
                c.this.fca.setVisibility(8);
                c.this.aQH();
                if (c.this.bbZ == 1 || c.this.bbZ == 2) {
                    if (c.this.fbX != null) {
                        c.this.fbX.setVisibility(0);
                        c.this.gsO.setVisibility(0);
                        c.this.gsM.setVisibility(8);
                        if (c.this.gsW != null) {
                            c.this.gsW.gc(false);
                        }
                    }
                    c.this.fbQ.showProgress();
                    c.this.aQI();
                }
                if (c.this.fcb != null) {
                    c.this.fcb.onPrepared(c.this.caM.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcA, 20L);
        }
    };
    private g.a bPp = new g.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.fcf = false;
            c.this.gtl = false;
            c.this.mStartPosition = 0;
            c.this.aQp();
            c.this.fbR.setVisibility(0);
            c.this.gsM.setVisibility(8);
            c.this.gsM.setProgress(c.this.gsM.getMax());
            if (c.this.gsW != null) {
                c.this.gsW.gc(false);
            }
            if (c.this.enQ) {
                c.this.fbX.setVisibility(0);
                c.this.fcd.setVisibility(0);
                c.this.fce.setVisibility(0);
                c.this.gsO.setVisibility(8);
            } else {
                c.this.fbX.setVisibility(8);
                c.this.fcd.setVisibility(8);
                c.this.fce.setVisibility(8);
                c.this.gsO.setVisibility(8);
            }
            if (c.this.caM == null || c.this.caM.getDuration() > 150000) {
                c.this.lK(false);
            } else {
                c.this.gsP.setVisibility(0);
            }
            z.blU().remove(c.this.bQI);
            if (c.this.gsS != null) {
                c.this.gsS.onCompletion(gVar);
            }
            c.this.bbZ = 3;
            c.this.caM.setRecoveryState(3);
            if (!c.this.enQ && c.this.caM != null && c.this.caM.getDuration() <= 150000) {
                if (!c.this.gti) {
                    if (c.this.gsY != null) {
                        c.this.gsY.lk(true);
                    }
                    c.this.bL(c.this.bQI, c.this.bCS);
                    return;
                }
                c.this.bbZ = 5;
                c.this.caM.setRecoveryState(5);
                c.this.caM.getPlayer().pause();
                c.this.caM.getPlayer().seekTo(0);
            }
        }
    };
    private g.b fcB = new g.b() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cZn.setVisibility(0);
            c.this.cWr.blQ();
            c.this.bbZ = 4;
            c.this.caM.setRecoveryState(4);
            if (c.this.gsT != null) {
                c.this.gsT.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.oJ()) {
                c.this.gtj = true;
            }
            c.this.gtl = false;
            return true;
        }
    };
    private Runnable fcC = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            c.this.cZn.setVisibility(0);
            c.this.cWr.blQ();
        }
    };
    private g.InterfaceC0220g bPu = new g.InterfaceC0220g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0220g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gtf) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.gtp, 200L);
            }
        }
    };
    private Runnable gtp = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.caM == null || !c.this.gtf) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcA, 200L);
                c.this.gtf = false;
            } else if (c.this.mStartPosition != c.this.caM.getCurrentPosition()) {
                c.this.gtf = false;
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcA, 20L);
            } else {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.gtp, 200L);
            }
        }
    };
    private QuickVideoView.b caV = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.fcf = false;
            c.this.gtl = false;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcA);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcC);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cZn.getId()) {
                c.this.bkW();
            } else if (view.getId() != c.this.cZj.getId() && view.getId() != c.this.fbV.getId()) {
                if (view.getId() == c.this.gsQ.getId()) {
                    if (c.this.gsX != null) {
                        c.this.gsX.bhy();
                    }
                } else if (view.getId() == c.this.gsP.getId()) {
                    if (c.this.gsY != null) {
                        c.this.gsY.lk(false);
                    }
                    c.this.bL(c.this.bQI, c.this.bCS);
                } else if (view.getId() != c.this.fbW.getId() && view.getId() != c.this.gsN.getId()) {
                    if (view.getId() == c.this.fcd.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.gtb != null) {
                            c.this.gtb.awD();
                        }
                        if (c.this.bkP()) {
                            c.this.bkR();
                            c.this.lH(false);
                            return;
                        }
                        c.this.aQt();
                    }
                } else {
                    if (c.this.enQ) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.gtb != null) {
                        c.this.gtb.awD();
                    }
                    if (c.this.bkP()) {
                        if (c.this.enQ) {
                            c.this.bkR();
                        } else {
                            c.this.bkQ();
                        }
                        c.this.lH(c.this.enQ);
                        return;
                    }
                    c.this.aQt();
                }
            } else {
                c.this.bhp();
            }
        }
    };
    private Animation.AnimationListener fcE = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.fbX != null) {
                c.this.fbX.setVisibility(8);
                c.this.gsM.setVisibility(0);
                c.this.fch = false;
                if (c.this.gsW != null) {
                    c.this.gsW.awE();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener fcF = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable fcG = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aQF();
        }
    };
    private CustomMessageListener fcH = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private v.b few = new v.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.v.b
        public void jo(int i2) {
            int duration;
            if (c.this.caM != null && (duration = c.this.caM.getDuration()) > 0 && c.this.gsM != null) {
                c.this.gsM.setProgress((int) ((i2 * c.this.fbO.getWidth()) / duration));
            }
            c.this.ri(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bTx = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.fch) {
                c.this.aQI();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aQE() && c.this.aQu() != null) {
                c.this.setStartPosition(c.this.aQu().getSeekPosition());
                c.this.bL(c.this.bQI, c.this.bCS);
            }
        }
    };
    private QuickVideoView.a gtq = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void blc() {
            if (!c.this.gti) {
                c.this.cWr.startLoading();
                c.this.fca.setVisibility(0);
                c.this.cZj.setVisibility(8);
                c.this.fbV.setImageResource(d.f.icon_video_suspend_n);
                c.this.gsQ.setVisibility(8);
                c.this.gsP.setVisibility(8);
                c.this.gsR.setVisibility(8);
                c.this.cZn.setVisibility(8);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.fcC);
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.fcC, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void awA();

        void awB();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0219c {
        void awE();

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
        void bhy();
    }

    /* loaded from: classes.dex */
    public interface g {
        void awF();
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
        void awC();

        void awD();
    }

    /* loaded from: classes.dex */
    public interface k {
        void bhz();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.fcu = 0;
        this.gto = true;
        if (tbPageContext != null) {
            this.aRG = tbPageContext;
            this.fbO = p(tbPageContext);
            this.mRootView = view;
            this.gto = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.fbO);
            }
            this.fbZ = view;
            this.fbO.setOnClickListener(this.mOnClickListener);
            this.caM = (QuickVideoView) this.fbO.findViewById(d.g.videoView);
            this.cWr = new y((ViewGroup) this.fbO.findViewById(d.g.auto_video_loading_container));
            this.cWr.setLoadingAnimationListener(this.cWB);
            this.fbQ = (VideoListMediaControllerView) this.fbO.findViewById(d.g.media_controller);
            this.fbQ.setPlayer(this.caM);
            this.gsM = (ProgressBar) this.fbO.findViewById(d.g.pgrBottomProgress);
            this.gsM.setMax(com.baidu.adp.lib.util.l.ao(this.aRG.getPageActivity()));
            this.gsM.setProgress(0);
            this.fbQ.setOnSeekBarChangeListener(this.bTx);
            this.fbQ.setOnProgressUpdatedListener(this.few);
            this.fbR = this.fbO.findViewById(d.g.black_mask);
            this.cZn = this.fbO.findViewById(d.g.layout_error);
            this.cZn.setOnClickListener(this.mOnClickListener);
            this.gth = (TextView) this.fbO.findViewById(d.g.auto_video_error_tips);
            this.fbS = (FrameLayout) this.fbO.findViewById(d.g.danmu_container);
            this.fbV = (ImageView) this.fbO.findViewById(d.g.img_play_icon);
            this.fbV.setOnClickListener(this.mOnClickListener);
            this.fbW = (ImageView) this.fbO.findViewById(d.g.img_full_screen);
            this.fbW.setOnClickListener(this.mOnClickListener);
            this.gsN = this.fbO.findViewById(d.g.full_screen_container);
            this.gsN.setOnClickListener(this.mOnClickListener);
            this.fbX = this.fbO.findViewById(d.g.layout_media_controller);
            this.gsO = this.fbO.findViewById(d.g.time_show_controller);
            this.caM.setOnPreparedListener(this.bPq);
            this.caM.setOnCompletionListener(this.bPp);
            this.caM.setOnErrorListener(this.fcB);
            this.caM.setOnSeekCompleteListener(this.bPu);
            this.caM.setOnSurfaceDestroyedListener(this.caV);
            this.caM.setOnRecoveryCallback(this.gtq);
            this.cZj = (ImageView) this.fbO.findViewById(d.g.img_play);
            this.cZj.setOnClickListener(this.mOnClickListener);
            this.gsP = (TextView) this.fbO.findViewById(d.g.txt_replay);
            this.gsP.setOnClickListener(this.mOnClickListener);
            this.gsQ = (TextView) this.fbO.findViewById(d.g.txt_playnext);
            this.gsQ.setOnClickListener(this.mOnClickListener);
            this.gsR = (TextView) this.fbO.findViewById(d.g.txt_next_video_title);
            this.fca = (TbImageView) this.fbO.findViewById(d.g.video_thumbnail);
            this.fca.setDefaultErrorResource(0);
            this.fca.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.aRG.getPageActivity());
            this.mScreenHeight = bN(this.aRG.getPageActivity());
            this.fcd = (ImageView) this.fbO.findViewById(d.g.img_exit);
            this.fcd.setOnClickListener(this.mOnClickListener);
            this.fce = (TextView) this.fbO.findViewById(d.g.video_title);
            this.cZi = this.fbO.findViewById(d.g.layout_title);
            this.cZi.setVisibility(8);
            this.dIk = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dIl = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aRG.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.fcp = this.mAudioManager.getStreamMaxVolume(3);
            this.fcv = this.mAudioManager.getStreamVolume(3);
            fcw = 100 / this.fcp;
            this.fbO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.gsZ != null) {
                        c.this.gsZ.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.fcf) {
                            if (c.this.mStatus == 1 && c.this.fcr != 0) {
                                c.this.b(c.this.fcr == 1 ? 1000.0f : -1000.0f, false);
                                c.this.fcr = 0;
                                c.this.fcq = 0;
                            }
                            if (!c.this.caM.isPlaying() && 8 == c.this.cZj.getVisibility()) {
                                c.this.cZj.setVisibility(0);
                                c.this.gsQ.setVisibility(8);
                                c.this.gsP.setVisibility(8);
                                c.this.gsR.setVisibility(8);
                            }
                        }
                        c.this.aQp();
                        if (c.this.gsZ != null) {
                            c.this.gsZ.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.cop = new p(this.aRG.getPageActivity());
            if (this.gto) {
                this.cop.start();
            }
            this.fcu = com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.ds16);
            this.fcx = new CallStateReceiver();
            this.fcx.register(this.aRG.getPageActivity());
            this.aRG.registerListener(this.fcH);
            bkN();
        }
    }

    public void bkN() {
        if (this.gtd) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fbO.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.fbO.setSystemUiVisibility(0);
    }

    public void lG(boolean z) {
        this.gtd = z;
        bkN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQp() {
        this.mStatus = 0;
        if (this.fcj != null && this.fcj.getParent() != null && (this.fcj.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fcj.getParent()).removeView(this.fcj);
                this.fcj = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.fck != null && this.fck.getParent() != null && (this.fck.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.fck.getParent()).removeView(this.fck);
                this.fck = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aQq() {
        if (this.mStatus == 1) {
            if (this.fcj == null && this.fbO != null && (this.fbO instanceof ViewGroup)) {
                LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.fbO, true);
                this.fcj = this.fbO.findViewById(d.g.lay_jindu);
                this.fcl = (TextView) this.fcj.findViewById(d.g.show_time);
                this.fco = (ImageView) this.fcj.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.fck == null && this.fbO != null && (this.fbO instanceof ViewGroup)) {
            LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.fbO, true);
            this.fck = this.fbO.findViewById(d.g.lay_voice);
            this.fcn = (ImageView) this.fck.findViewById(d.g.arrow_voice_icon);
            this.fcm = (SeekBar) this.fck.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gsZ != null) {
                c.this.gsZ.onStart();
            }
            if (c.this.enQ && c.this.fcf) {
                if (!c.this.caM.isPlaying() && c.this.cZj.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cZj.setVisibility(8);
                    c.this.gsQ.setVisibility(8);
                    c.this.gsP.setVisibility(8);
                    c.this.gsR.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ar(f2);
                    }
                } else {
                    if (c.this.enQ) {
                        c.this.aQs();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.fcq = c.this.caM.getCurrentPosition();
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
            if (c.this.gta != null) {
                c.this.gta.bhz();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.fcf) {
                if (c.this.bbZ != 2) {
                    c.this.bkY();
                } else {
                    c.this.bhp();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        if (Build.VERSION.SDK_INT < 16) {
            this.fbO.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.fbO.setSystemUiVisibility(4);
        } else {
            this.fbO.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f2) {
        if (!this.fcf) {
            this.mStatus = 0;
            return;
        }
        aQq();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % fcw == 0) {
            if (f2 > 0.0f && this.fcv < this.fcp) {
                this.fcv++;
            }
            if (f2 < 0.0f && this.fcv > 0) {
                this.fcv--;
            }
        }
        if (this.mProgress > 0) {
            this.fcn.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.fcn.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.fcv, 0);
        this.fcm.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.fcq += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.fcr = 1;
            } else {
                this.fcq += 1000;
                this.fcr = 2;
            }
            if (this.fcq < 0) {
                this.fcq = 0;
            } else if (this.fcq > this.caM.getDuration()) {
                this.fcq = this.caM.getDuration();
            }
        }
        aQq();
        String tU = this.fbQ.tU(this.fcq);
        if (f2 > 0.0f) {
            this.fco.setImageResource(d.f.icon_kuaitui);
        } else {
            this.fco.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tU)) {
            this.fcl.setText(new StringBuilder().append(tU).append("/").append(this.fbQ.tU(this.caM.getDuration())));
        }
        this.fbQ.R(this.fcq, z ? false : true);
        this.fbX.setVisibility(8);
        this.gsM.setVisibility(0);
        bkS();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.bQI = str;
        this.bCS = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkO() {
        if (this.gsU) {
            return this.gtm == 0 && !this.gtn;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akW() {
        if (this.caM != null && this.cWm != null) {
            if (this.gtl) {
                this.caM.start();
                this.gtl = false;
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcA);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.fcA, 20L);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcC);
            if (this.caM.blt()) {
                this.bbZ = 1;
                this.caM.setRecoveryState(1);
            }
            if (this.cWm != null && this.fbQ != null) {
                this.mStartPosition = z.blU().rl(this.bQI);
                this.fbQ.aU(this.mStartPosition, this.cWm.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.caM != null) {
                        this.caM.tT(this.mStartPosition);
                    } else {
                        this.cWm.seekTo(this.mStartPosition);
                    }
                    if (!this.gtk) {
                        this.fbQ.showProgress();
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcA);
                    }
                    this.gtf = true;
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
        if (hasNavBar(this.aRG.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsO.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.aRG.getPageActivity());
                this.gsO.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gsO.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.gsO.setLayoutParams(layoutParams);
        }
    }

    public void bhp() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.J(this.aRG.getPageActivity(), this.aRG.getString(d.j.neterror));
        } else if (this.caM.isPlaying()) {
            pausePlay();
        } else if (this.fcf) {
            aQD();
            if (this.gcp != null) {
                this.gcp.awF();
            }
        } else {
            bkW();
        }
    }

    public void aQt() {
        this.fcy = true;
        if (this.cop != null) {
            this.cop.aQt();
        }
    }

    public boolean bkP() {
        return this.cWm != null && this.cWm.getVideoHeight() > this.cWm.getVideoWidth();
    }

    public boolean tQ(int i2) {
        switch (i2) {
            case 4:
                if (this.enQ) {
                    if (bkP()) {
                        lH(false);
                        bkR();
                    } else {
                        aQt();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.fcp <= 0 || this.fcm == null) {
                    return false;
                }
                this.fcv = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.fcv * 100.0d) / this.fcp);
                this.fcm.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.caM;
    }

    public VideoListMediaControllerView aQu() {
        return this.fbQ;
    }

    public void show() {
        this.fbO.setVisibility(0);
    }

    public void aQy() {
        if (this.fbZ != null) {
            ViewGroup.LayoutParams layoutParams = this.fbZ.getLayoutParams();
            this.fbT = (FrameLayout.LayoutParams) this.fbO.getLayoutParams();
            this.fbT.width = layoutParams.width;
            this.fbT.height = layoutParams.height;
            this.fbT.topMargin = 0;
            this.fbO.setLayoutParams(this.fbT);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.fcy) {
            if (this.enQ) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.fcy = false;
        }
        if (configuration.orientation == 2) {
            bkQ();
        } else {
            bkR();
        }
        if (this.caM.isPlaying()) {
            aQI();
        }
        bkS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkQ() {
        this.enQ = true;
        if (bkP()) {
            this.fbO.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.fbO.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.aRG, true);
        this.fbX.setVisibility(0);
        this.cZi.setVisibility(0);
        this.fcd.setVisibility(0);
        this.fce.setVisibility(0);
        this.fbS.setVisibility(8);
        if (this.gsU) {
            this.cWr.startLoading();
            this.fca.setVisibility(0);
        } else {
            this.cWr.blQ();
            this.fca.setVisibility(8);
        }
        if (this.gsV != null) {
            this.gsV.awA();
        }
        this.fbW.setImageResource(d.f.icon_video_window);
        rg(this.fcu);
        aQs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkR() {
        this.enQ = false;
        if (this.fbT != null) {
            this.fbO.setLayoutParams(this.fbT);
        }
        a((TbPageContext) this.aRG, false);
        this.cZi.setVisibility(8);
        this.fbS.setVisibility(0);
        if (this.gsU) {
            this.cWr.startLoading();
            this.fca.setVisibility(0);
        } else {
            this.cWr.blQ();
            this.fca.setVisibility(8);
        }
        if (this.gsV != null) {
            this.gsV.awB();
        }
        if (this.bbZ == 3 && this.gsW != null) {
            this.gsW.gc(false);
        } else if (!this.fcf && this.fbX != null) {
            this.fbX.clearAnimation();
            this.fbX.setVisibility(4);
            this.gsM.setVisibility(0);
            if (this.gsW != null) {
                this.gsW.awE();
            }
        }
        aQp();
        this.fbW.setImageResource(d.f.icon_video_fullscreen);
        if (this.fbQ != null && (this.fbQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fbQ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.fbQ.setLayoutParams(layoutParams);
        }
        this.fbO.setSystemUiVisibility(0);
        bkN();
    }

    public void bkS() {
        if (this.caM != null) {
            int ao = com.baidu.adp.lib.util.l.ao(this.aRG.getPageActivity());
            if (this.enQ) {
                ao = com.baidu.adp.lib.util.l.aq(this.aRG.getPageActivity());
            }
            this.gsM.setMax(ao);
            int duration = this.caM.getDuration();
            if (duration > 0) {
                if (this.gsP.getVisibility() == 0) {
                    this.gsM.setProgress(this.gsM.getMax());
                } else {
                    this.gsM.setProgress((int) ((this.caM.getCurrentPosition() * this.gsM.getMax()) / duration));
                }
            }
        }
    }

    private void rg(int i2) {
        if (this.fbQ != null && (this.fbQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fbQ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.fbQ.setLayoutParams(layoutParams);
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

    public boolean aQA() {
        return !this.enQ;
    }

    public void a(g.f fVar) {
        this.fcb = fVar;
    }

    public void a(g.a aVar) {
        this.gsS = aVar;
    }

    public void a(g.b bVar) {
        this.gsT = bVar;
    }

    public void aQB() {
        this.fbV.setImageResource(d.f.icon_video_play);
        this.cWr.blQ();
        this.cZj.setVisibility(0);
        this.gsQ.setVisibility(8);
        this.gsP.setVisibility(8);
        this.gsR.setVisibility(8);
        this.bbZ = 2;
        this.caM.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.caM != null) {
            this.caM.setPbLoadingTime(currentTimeMillis);
        }
        bL(str, str2);
    }

    public void bL(String str, String str2) {
        this.gtl = true;
        this.bbZ = 0;
        this.caM.setRecoveryState(0);
        bK(str, str2);
        this.caM.bN(str, str2);
        this.cWr.startLoading();
        this.fca.setVisibility(0);
        this.cZj.setVisibility(8);
        this.fbV.setImageResource(d.f.icon_video_suspend_n);
        this.gsQ.setVisibility(8);
        this.gsP.setVisibility(8);
        this.gsR.setVisibility(8);
        this.cZn.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcC);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcC, 60000L);
    }

    public void bM(String str, String str2) {
        this.gtl = true;
        this.bbZ = 0;
        this.caM.setRecoveryState(0);
        this.cWr.startLoading();
        this.fca.setVisibility(0);
        this.cZj.setVisibility(8);
        this.fbV.setImageResource(d.f.icon_video_suspend_n);
        this.gsQ.setVisibility(8);
        this.gsP.setVisibility(8);
        this.gsR.setVisibility(8);
        this.cZn.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcC);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcC, 60000L);
    }

    public void aQD() {
        this.bbZ = 1;
        this.caM.setRecoveryState(1);
        this.caM.start();
        this.fbV.setImageResource(d.f.icon_video_suspend_n);
        this.fca.setVisibility(8);
        this.fbR.setVisibility(8);
        this.cWr.blQ();
        this.fbQ.showProgress();
        this.cZj.setVisibility(8);
        this.gsQ.setVisibility(8);
        this.gsP.setVisibility(8);
        this.gsR.setVisibility(8);
        bla();
    }

    public void bkT() {
        if (com.baidu.adp.lib.util.j.oJ() && this.gtj && !StringUtils.isNull(this.bQI) && !StringUtils.isNull(this.bCS)) {
            this.gtj = false;
            this.gtk = true;
            bL(this.bQI, this.bCS);
        }
    }

    public void lI(boolean z) {
        if (this.caM != null) {
            this.caM.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.caM.isPlaying() && this.gte) {
            bkU();
        }
        bkZ();
        this.caM.pause();
        aQB();
    }

    public void stopPlay() {
        if (this.caM.isPlaying() && this.gte) {
            bkU();
        }
        this.bbZ = 5;
        this.caM.setRecoveryState(5);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcA);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcC);
        this.caM.stopPlayback();
        this.fcf = false;
        this.gtl = false;
        this.mStartPosition = 0;
        aDB();
    }

    public void bkU() {
        z.blU().aB(this.bQI, this.caM.getCurrentPosition());
    }

    public void lJ(boolean z) {
        this.gte = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(boolean z) {
        if (this.fbX != null) {
            this.fbR.setVisibility(0);
            this.cZj.setVisibility(0);
            this.gsQ.setVisibility(8);
            this.gsP.setVisibility(8);
            this.gsR.setVisibility(8);
            this.cWr.blQ();
            this.fbV.setImageResource(d.f.icon_video_play);
            this.fbX.setVisibility(4);
            this.gsM.setVisibility(8);
            this.cZn.setVisibility(8);
            this.fbQ.UC();
            this.fca.setVisibility(z ? 0 : 8);
        }
    }

    public void aDB() {
        lK(true);
    }

    public boolean bkV() {
        if (this.caM == null) {
            return false;
        }
        return this.caM.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.caM == null) {
            return 0;
        }
        return this.caM.getCurrentPosition();
    }

    public void a(i iVar) {
        this.gsZ = iVar;
    }

    public void a(h hVar) {
        this.gsY = hVar;
    }

    public void a(g gVar) {
        this.gcp = gVar;
    }

    public void a(f fVar) {
        this.gsX = fVar;
    }

    public void qO(String str) {
        this.gbT = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkW() {
        a(this.bQI, this.bCS, null, new Object[0]);
    }

    public void b(InterfaceC0219c interfaceC0219c) {
        this.gsW = interfaceC0219c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        if (com.baidu.adp.lib.util.j.oL()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gtg = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gtc != null) {
                    this.gtc.gb(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
                aVar.dk(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bkX();
                        if (c.this.gtg) {
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
                aVar.b(this.aRG).AU();
                return;
            } else if (this.gtc != null) {
                this.gtc.gb(true);
                return;
            } else {
                if (!this.gsL) {
                    this.gsL = true;
                    com.baidu.adp.lib.util.l.showToast(this.aRG.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                if (this.gtg) {
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
        if (this.gtg) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.lN(true);
        }
        if (this.gtb != null) {
            this.gtb.awC();
        }
    }

    public void bkX() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void ov(String str) {
        this.fca.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcG);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcA);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcC);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtp);
        this.cop.stop();
        this.fcx.unregister(this.aRG.getPageActivity());
    }

    public void rg(String str) {
        this.fce.setText(str);
    }

    public boolean aQE() {
        return this.fcf;
    }

    public void aQF() {
        if (this.fbX != null) {
            aQH();
            this.fbX.setVisibility(0);
            this.gsO.setVisibility(0);
            if (this.gsW != null) {
                this.gsW.gc(true);
            }
            this.gsM.setVisibility(8);
            this.dIk.setAnimationListener(this.fcE);
            this.fbX.startAnimation(this.dIk);
            this.fch = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        if (this.fbX != null) {
            if (this.fbX.getVisibility() == 0) {
                aQH();
                this.fbX.setVisibility(8);
                this.gsM.setVisibility(0);
                if (this.gsW != null) {
                    this.gsW.awE();
                    return;
                }
                return;
            }
            aQI();
        }
    }

    public void aQG() {
        if (this.fbX != null) {
            aQH();
            this.fbX.setVisibility(0);
            this.gsO.setVisibility(0);
            if (this.gsW != null) {
                this.gsW.gc(false);
            }
            this.gsM.setVisibility(8);
            this.dIl.setAnimationListener(this.fcF);
            this.fbX.startAnimation(this.dIl);
        }
    }

    public void bkZ() {
        if (this.fbX != null) {
            aQH();
            this.fbX.setVisibility(0);
            this.gsO.setVisibility(0);
            this.gsM.setVisibility(8);
            if (this.gsW != null) {
                this.gsW.gc(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQH() {
        if (this.fbX != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcG);
            this.dIl.setAnimationListener(null);
            this.dIk.setAnimationListener(null);
            this.fbX.clearAnimation();
            this.fch = false;
        }
    }

    public void aQI() {
        aQG();
        bla();
    }

    private void bla() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fcG);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.fcG, 3000L);
    }

    public void a(b bVar) {
        this.gsV = bVar;
    }

    public void ri(int i2) {
        if (this.caM.getDuration() - i2 <= 3000) {
            aQH();
            if (this.fbX != null) {
                this.fbX.setVisibility(0);
                this.gsO.setVisibility(0);
                this.gsM.setVisibility(8);
                if (this.gsW != null) {
                    this.gsW.gc(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void Q(boolean z, boolean z2) {
        int i2 = 8;
        if (this.cop != null) {
            if (this.fbW != null || this.gsN != null) {
                this.fbW.setVisibility((z || !z2) ? 0 : 8);
                View view = this.gsN;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.fbQ != null && (this.fbQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fbQ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.tbds52);
                this.fbQ.setLayoutParams(layoutParams);
            }
            this.cop.lP(z);
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

    public int blb() {
        return this.bbZ;
    }

    public void a(k kVar) {
        this.gta = kVar;
    }

    public void a(j jVar) {
        this.gtb = jVar;
    }

    public void a(e eVar) {
        this.gtc = eVar;
    }

    public void lL(boolean z) {
        this.gti = z;
    }

    public void lM(boolean z) {
        this.gsU = z;
    }

    public void tR(int i2) {
        this.gtm = i2;
    }
}
