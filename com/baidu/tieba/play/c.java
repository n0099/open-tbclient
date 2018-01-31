package com.baidu.tieba.play;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.v;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int eXt;
    private TbPageContext<?> aQs;
    private String bBb;
    private String bON;
    private QuickVideoView bYP;
    private com.baidu.tieba.play.g cTP;
    private y cTU;
    private View cWH;
    private ImageView cWI;
    private View cWM;
    private p clg;
    private Animation dFs;
    private Animation dFt;
    protected View eWL;
    private VideoListMediaControllerView eWN;
    private View eWO;
    private FrameLayout eWP;
    protected FrameLayout.LayoutParams eWQ;
    private ImageView eWS;
    private ImageView eWT;
    private View eWU;
    private View eWW;
    private TbImageView eWX;
    private g.f eWY;
    private ImageView eXa;
    private TextView eXb;
    private View eXg;
    private View eXh;
    private TextView eXi;
    private SeekBar eXj;
    private ImageView eXk;
    private ImageView eXl;
    private int eXm;
    private int eXr;
    private int eXs;
    private CallStateReceiver eXu;
    private g fZt;
    private b grA;
    private InterfaceC0149c grB;
    private f grC;
    private h grD;
    private i grE;
    private k grF;
    private j grG;
    private e grH;
    private TextView grM;
    private boolean grO;
    private boolean grP;
    private boolean grQ;
    private int grR;
    private boolean grS;
    private boolean grT;
    private ProgressBar grr;
    private View grs;
    private View grt;
    private TextView gru;
    private TextView grv;
    private TextView grw;
    private g.a grx;
    private g.b gry;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean grq = false;
    protected boolean ejR = false;
    private boolean eXc = false;
    private boolean eXe = false;
    private boolean grz = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eXn = 0;
    private int eXo = 0;
    private boolean eXv = false;
    private boolean grI = true;
    private boolean grJ = true;
    private boolean grK = false;
    private boolean grL = false;
    private String fYX = null;
    private int bat = -1;
    private boolean grN = false;
    private g.f bNv = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cTP = gVar;
            if (c.this.bjF()) {
                c.this.cTU.bkC();
                c.this.grS = true;
                return;
            }
            c.this.ako();
        }
    };
    private VideoLoadingProgressView.a cUe = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.ako();
        }
    };
    private Runnable eXx = new Runnable() { // from class: com.baidu.tieba.play.c.15
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bYP.getCurrentPosition() > 100) {
                c.this.eXc = true;
                c.this.eWO.setVisibility(8);
                c.this.cWM.setVisibility(8);
                c.this.cTU.bkD();
                c.this.eWX.setVisibility(8);
                c.this.aOV();
                if (c.this.bat == 1 || c.this.bat == 2) {
                    if (c.this.eWU != null) {
                        c.this.eWU.setVisibility(0);
                        c.this.grt.setVisibility(0);
                        c.this.grr.setVisibility(8);
                        if (c.this.grB != null) {
                            c.this.grB.fU(false);
                        }
                    }
                    c.this.eWN.showProgress();
                    c.this.aOW();
                }
                if (c.this.eWY != null) {
                    c.this.eWY.onPrepared(c.this.bYP.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(c.this.eXx, 20L);
        }
    };
    private g.a bNu = new g.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eXc = false;
            c.this.grQ = false;
            c.this.mStartPosition = 0;
            c.this.aOD();
            c.this.eWO.setVisibility(0);
            c.this.grr.setVisibility(8);
            c.this.grr.setProgress(c.this.grr.getMax());
            if (c.this.grB != null) {
                c.this.grB.fU(false);
            }
            if (c.this.ejR) {
                c.this.eWU.setVisibility(0);
                c.this.eXa.setVisibility(0);
                c.this.eXb.setVisibility(0);
                c.this.grt.setVisibility(8);
            } else {
                c.this.eWU.setVisibility(8);
                c.this.eXa.setVisibility(8);
                c.this.eXb.setVisibility(8);
                c.this.grt.setVisibility(8);
            }
            if (c.this.bYP == null || c.this.bYP.getDuration() > 150000) {
                c.this.lB(false);
            } else {
                c.this.gru.setVisibility(0);
            }
            z.bkI().remove(c.this.bON);
            if (c.this.grx != null) {
                c.this.grx.onCompletion(gVar);
            }
            c.this.bat = 3;
            c.this.bYP.setRecoveryState(3);
            if (!c.this.ejR && c.this.bYP != null && c.this.bYP.getDuration() <= 150000) {
                if (!c.this.grN) {
                    if (c.this.grD != null) {
                        c.this.grD.lb(true);
                    }
                    c.this.bL(c.this.bON, c.this.bBb);
                    return;
                }
                c.this.bat = 5;
                c.this.bYP.setRecoveryState(5);
                c.this.bYP.getPlayer().pause();
                c.this.bYP.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eXy = new g.b() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cWM.setVisibility(0);
            c.this.cTU.bkE();
            c.this.bat = 4;
            c.this.bYP.setRecoveryState(4);
            if (c.this.gry != null) {
                c.this.gry.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.oJ()) {
                c.this.grO = true;
            }
            c.this.grQ = false;
            return true;
        }
    };
    private Runnable eXz = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            c.this.cWM.setVisibility(0);
            c.this.cTU.bkE();
        }
    };
    private g.InterfaceC0150g bNz = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0150g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.grK) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.grU, 200L);
            }
        }
    };
    private Runnable grU = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bYP == null || !c.this.grK) {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.eXx, 200L);
                c.this.grK = false;
            } else if (c.this.mStartPosition != c.this.bYP.getCurrentPosition()) {
                c.this.grK = false;
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.eXx, 20L);
            } else {
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.grU, 200L);
            }
        }
    };
    private QuickVideoView.b bYW = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eXc = false;
            c.this.grQ = false;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.eXx);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.eXz);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cWM.getId()) {
                c.this.bjK();
            } else if (view.getId() != c.this.cWI.getId() && view.getId() != c.this.eWS.getId()) {
                if (view.getId() == c.this.grv.getId()) {
                    if (c.this.grC != null) {
                        c.this.grC.bfZ();
                    }
                } else if (view.getId() == c.this.gru.getId()) {
                    if (c.this.grD != null) {
                        c.this.grD.lb(false);
                    }
                    c.this.bL(c.this.bON, c.this.bBb);
                } else if (view.getId() != c.this.eWT.getId() && view.getId() != c.this.grs.getId()) {
                    if (view.getId() == c.this.eXa.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.grG != null) {
                            c.this.grG.avH();
                        }
                        c.this.aOH();
                    }
                } else {
                    if (c.this.ejR) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.grG != null) {
                        c.this.grG.avH();
                    }
                    c.this.aOH();
                }
            } else {
                c.this.bfQ();
            }
        }
    };
    private Animation.AnimationListener eXB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eWU != null) {
                c.this.eWU.setVisibility(8);
                c.this.grr.setVisibility(0);
                c.this.eXe = false;
                if (c.this.grB != null) {
                    c.this.grB.avI();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eXC = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable eXD = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aOT();
        }
    };
    private CustomMessageListener eXE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private v.b fap = new v.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.v.b
        public void js(int i2) {
            int duration;
            if (c.this.bYP != null && (duration = c.this.bYP.getDuration()) > 0 && c.this.grr != null) {
                c.this.grr.setProgress((int) ((i2 * c.this.eWL.getWidth()) / duration));
            }
            c.this.rd(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bRE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eXe) {
                c.this.aOW();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aOS() && c.this.aOI() != null) {
                c.this.setStartPosition(c.this.aOI().getSeekPosition());
                c.this.bL(c.this.bON, c.this.bBb);
            }
        }
    };
    private QuickVideoView.a grV = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bjQ() {
            if (!c.this.grN) {
                c.this.cTU.startLoading();
                c.this.eWX.setVisibility(0);
                c.this.cWI.setVisibility(8);
                c.this.eWS.setImageResource(d.f.icon_video_suspend_n);
                c.this.grv.setVisibility(8);
                c.this.gru.setVisibility(8);
                c.this.grw.setVisibility(8);
                c.this.cWM.setVisibility(8);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(c.this.eXz);
                com.baidu.adp.lib.g.e.ns().postDelayed(c.this.eXz, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void avE();

        void avF();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0149c {
        void avI();

        void fU(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lF(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void bfZ();
    }

    /* loaded from: classes.dex */
    public interface g {
        void avJ();
    }

    /* loaded from: classes.dex */
    public interface h {
        void lb(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void avG();

        void avH();
    }

    /* loaded from: classes.dex */
    public interface k {
        void bga();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eXr = 0;
        this.grT = true;
        if (tbPageContext != null) {
            this.aQs = tbPageContext;
            this.eWL = o(tbPageContext);
            this.mRootView = view;
            this.grT = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eWL);
            }
            this.eWW = view;
            this.eWL.setOnClickListener(this.mOnClickListener);
            this.bYP = (QuickVideoView) this.eWL.findViewById(d.g.videoView);
            this.cTU = new y((ViewGroup) this.eWL.findViewById(d.g.auto_video_loading_container));
            this.cTU.setLoadingAnimationListener(this.cUe);
            this.eWN = (VideoListMediaControllerView) this.eWL.findViewById(d.g.media_controller);
            this.eWN.setPlayer(this.bYP);
            this.grr = (ProgressBar) this.eWL.findViewById(d.g.pgrBottomProgress);
            this.grr.setMax(com.baidu.adp.lib.util.l.ao(this.aQs.getPageActivity()));
            this.grr.setProgress(0);
            this.eWN.setOnSeekBarChangeListener(this.bRE);
            this.eWN.setOnProgressUpdatedListener(this.fap);
            this.eWO = this.eWL.findViewById(d.g.black_mask);
            this.cWM = this.eWL.findViewById(d.g.layout_error);
            this.cWM.setOnClickListener(this.mOnClickListener);
            this.grM = (TextView) this.eWL.findViewById(d.g.auto_video_error_tips);
            this.eWP = (FrameLayout) this.eWL.findViewById(d.g.danmu_container);
            this.eWS = (ImageView) this.eWL.findViewById(d.g.img_play_icon);
            this.eWS.setOnClickListener(this.mOnClickListener);
            this.eWT = (ImageView) this.eWL.findViewById(d.g.img_full_screen);
            this.eWT.setOnClickListener(this.mOnClickListener);
            this.grs = this.eWL.findViewById(d.g.full_screen_container);
            this.grs.setOnClickListener(this.mOnClickListener);
            this.eWU = this.eWL.findViewById(d.g.layout_media_controller);
            this.grt = this.eWL.findViewById(d.g.time_show_controller);
            this.bYP.setOnPreparedListener(this.bNv);
            this.bYP.setOnCompletionListener(this.bNu);
            this.bYP.setOnErrorListener(this.eXy);
            this.bYP.setOnSeekCompleteListener(this.bNz);
            this.bYP.setOnSurfaceDestroyedListener(this.bYW);
            this.bYP.setOnRecoveryCallback(this.grV);
            this.cWI = (ImageView) this.eWL.findViewById(d.g.img_play);
            this.cWI.setOnClickListener(this.mOnClickListener);
            this.gru = (TextView) this.eWL.findViewById(d.g.txt_replay);
            this.gru.setOnClickListener(this.mOnClickListener);
            this.grv = (TextView) this.eWL.findViewById(d.g.txt_playnext);
            this.grv.setOnClickListener(this.mOnClickListener);
            this.grw = (TextView) this.eWL.findViewById(d.g.txt_next_video_title);
            this.eWX = (TbImageView) this.eWL.findViewById(d.g.video_thumbnail);
            this.eWX.setDefaultErrorResource(0);
            this.eWX.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.aQs.getPageActivity());
            this.mScreenHeight = bN(this.aQs.getPageActivity());
            this.eXa = (ImageView) this.eWL.findViewById(d.g.img_exit);
            this.eXa.setOnClickListener(this.mOnClickListener);
            this.eXb = (TextView) this.eWL.findViewById(d.g.video_title);
            this.cWH = this.eWL.findViewById(d.g.layout_title);
            this.cWH.setVisibility(8);
            this.dFs = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dFt = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aQs.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eXm = this.mAudioManager.getStreamMaxVolume(3);
            this.eXs = this.mAudioManager.getStreamVolume(3);
            eXt = 100 / this.eXm;
            this.eWL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.grE != null) {
                        c.this.grE.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eXc) {
                            if (c.this.mStatus == 1 && c.this.eXo != 0) {
                                c.this.b(c.this.eXo == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eXo = 0;
                                c.this.eXn = 0;
                            }
                            if (!c.this.bYP.isPlaying() && 8 == c.this.cWI.getVisibility()) {
                                c.this.cWI.setVisibility(0);
                                c.this.grv.setVisibility(8);
                                c.this.gru.setVisibility(8);
                                c.this.grw.setVisibility(8);
                            }
                        }
                        c.this.aOD();
                        if (c.this.grE != null) {
                            c.this.grE.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.clg = new p(this.aQs.getPageActivity());
            if (this.grT) {
                this.clg.start();
            }
            this.eXr = com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.ds16);
            this.eXu = new CallStateReceiver();
            this.eXu.register(this.aQs.getPageActivity());
            this.aQs.registerListener(this.eXE);
            bjE();
        }
    }

    public void bjE() {
        if (this.grI) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eWL.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eWL.setSystemUiVisibility(0);
    }

    public void ly(boolean z) {
        this.grI = z;
        bjE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOD() {
        this.mStatus = 0;
        if (this.eXg != null && this.eXg.getParent() != null && (this.eXg.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eXg.getParent()).removeView(this.eXg);
                this.eXg = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eXh != null && this.eXh.getParent() != null && (this.eXh.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eXh.getParent()).removeView(this.eXh);
                this.eXh = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aOE() {
        if (this.mStatus == 1) {
            if (this.eXg == null && this.eWL != null && (this.eWL instanceof ViewGroup)) {
                LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.eWL, true);
                this.eXg = this.eWL.findViewById(d.g.lay_jindu);
                this.eXi = (TextView) this.eXg.findViewById(d.g.show_time);
                this.eXl = (ImageView) this.eXg.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eXh == null && this.eWL != null && (this.eWL instanceof ViewGroup)) {
            LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.eWL, true);
            this.eXh = this.eWL.findViewById(d.g.lay_voice);
            this.eXk = (ImageView) this.eXh.findViewById(d.g.arrow_voice_icon);
            this.eXj = (SeekBar) this.eXh.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.grE != null) {
                c.this.grE.onStart();
            }
            if (c.this.ejR && c.this.eXc) {
                if (!c.this.bYP.isPlaying() && c.this.cWI.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cWI.setVisibility(8);
                    c.this.grv.setVisibility(8);
                    c.this.gru.setVisibility(8);
                    c.this.grw.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.al(f2);
                    }
                } else {
                    if (c.this.ejR) {
                        c.this.aOG();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eXn = c.this.bYP.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.al(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.grF != null) {
                c.this.grF.bga();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eXc) {
                if (c.this.bat != 2) {
                    c.this.bjM();
                } else {
                    c.this.bfQ();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOG() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eWL.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eWL.setSystemUiVisibility(4);
        } else {
            this.eWL.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f2) {
        if (!this.eXc) {
            this.mStatus = 0;
            return;
        }
        aOE();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eXt == 0) {
            if (f2 > 0.0f && this.eXs < this.eXm) {
                this.eXs++;
            }
            if (f2 < 0.0f && this.eXs > 0) {
                this.eXs--;
            }
        }
        if (this.mProgress > 0) {
            this.eXk.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eXk.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eXs, 0);
        this.eXj.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eXn += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eXo = 1;
            } else {
                this.eXn += 1000;
                this.eXo = 2;
            }
            if (this.eXn < 0) {
                this.eXn = 0;
            } else if (this.eXn > this.bYP.getDuration()) {
                this.eXn = this.bYP.getDuration();
            }
        }
        aOE();
        String tV = this.eWN.tV(this.eXn);
        if (f2 > 0.0f) {
            this.eXl.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eXl.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tV)) {
            this.eXi.setText(new StringBuilder().append(tV).append("/").append(this.eWN.tV(this.bYP.getDuration())));
        }
        this.eWN.L(this.eXn, z ? false : true);
        this.eWU.setVisibility(8);
        this.grr.setVisibility(0);
        bjG();
    }

    protected View o(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.bON = str;
        this.bBb = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjF() {
        if (this.grz) {
            return this.grR == 0 && !this.grS;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        if (this.bYP != null && this.cTP != null) {
            if (this.grQ) {
                this.bYP.start();
                this.grQ = false;
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXx);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.eXx, 20L);
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXz);
            if (this.bYP.bkh()) {
                this.bat = 1;
                this.bYP.setRecoveryState(1);
            }
            if (this.cTP != null && this.eWN != null) {
                this.mStartPosition = z.bkI().re(this.bON);
                this.eWN.aU(this.mStartPosition, this.cTP.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bYP != null) {
                        this.bYP.tU(this.mStartPosition);
                    } else {
                        this.cTP.seekTo(this.mStartPosition);
                    }
                    if (!this.grP) {
                        this.eWN.showProgress();
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXx);
                    }
                    this.grK = true;
                }
            }
        }
    }

    public void bfQ() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.J(this.aQs.getPageActivity(), this.aQs.getString(d.j.neterror));
        } else if (this.bYP.isPlaying()) {
            pausePlay();
        } else if (this.eXc) {
            aOR();
            if (this.fZt != null) {
                this.fZt.avJ();
            }
        } else {
            bjK();
        }
    }

    public void aOH() {
        this.eXv = true;
        if (this.clg != null) {
            this.clg.aOH();
        }
    }

    public boolean tR(int i2) {
        switch (i2) {
            case 4:
                if (this.ejR) {
                    aOH();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eXm <= 0 || this.eXj == null) {
                    return false;
                }
                this.eXs = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eXs * 100.0d) / this.eXm);
                this.eXj.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bYP;
    }

    public VideoListMediaControllerView aOI() {
        return this.eWN;
    }

    public void show() {
        this.eWL.setVisibility(0);
    }

    public void aOM() {
        if (this.eWW != null) {
            ViewGroup.LayoutParams layoutParams = this.eWW.getLayoutParams();
            this.eWQ = (FrameLayout.LayoutParams) this.eWL.getLayoutParams();
            this.eWQ.width = layoutParams.width;
            this.eWQ.height = layoutParams.height;
            this.eWQ.topMargin = 0;
            this.eWL.setLayoutParams(this.eWQ);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eXv) {
            if (this.ejR) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.eXv = false;
        }
        if (configuration.orientation == 2) {
            this.ejR = true;
            this.eWL.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.eWU.setVisibility(0);
            this.cWH.setVisibility(0);
            this.eXa.setVisibility(0);
            this.eXb.setVisibility(0);
            this.eWP.setVisibility(8);
            if (this.grz) {
                this.cTU.startLoading();
                this.eWX.setVisibility(0);
            } else {
                this.cTU.bkE();
                this.eWX.setVisibility(8);
            }
            if (this.grA != null) {
                this.grA.avE();
            }
            this.eWT.setImageResource(d.f.icon_video_window);
            rb(this.eXr);
            aOG();
        } else {
            this.ejR = false;
            if (this.eWQ != null) {
                this.eWL.setLayoutParams(this.eWQ);
            }
            a(tbPageContext, false);
            this.cWH.setVisibility(8);
            this.eWP.setVisibility(0);
            if (this.grz) {
                this.cTU.startLoading();
                this.eWX.setVisibility(0);
            } else {
                this.cTU.bkE();
                this.eWX.setVisibility(8);
            }
            if (this.grA != null) {
                this.grA.avF();
            }
            if (this.bat == 3 && this.grB != null) {
                this.grB.fU(false);
            } else if (!this.eXc && this.eWU != null) {
                this.eWU.clearAnimation();
                this.eWU.setVisibility(4);
                this.grr.setVisibility(0);
                if (this.grB != null) {
                    this.grB.avI();
                }
            }
            aOD();
            this.eWT.setImageResource(d.f.icon_video_fullscreen);
            if (this.eWN != null && (this.eWN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWN.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.tbds24);
                layoutParams.rightMargin = 0;
                this.eWN.setLayoutParams(layoutParams);
            }
            this.eWL.setSystemUiVisibility(0);
            bjE();
        }
        if (this.bYP.isPlaying()) {
            aOW();
        }
        bjG();
    }

    public void bjG() {
        if (this.bYP != null) {
            int ao = com.baidu.adp.lib.util.l.ao(this.aQs.getPageActivity());
            if (this.ejR) {
                ao = com.baidu.adp.lib.util.l.aq(this.aQs.getPageActivity());
            }
            this.grr.setMax(ao);
            int duration = this.bYP.getDuration();
            if (duration > 0) {
                if (this.gru.getVisibility() == 0) {
                    this.grr.setProgress(this.grr.getMax());
                } else {
                    this.grr.setProgress((int) ((this.bYP.getCurrentPosition() * this.grr.getMax()) / duration));
                }
            }
        }
    }

    private void rb(int i2) {
        if (this.eWN != null && (this.eWN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWN.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eWN.setLayoutParams(layoutParams);
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

    public boolean aOO() {
        return !this.ejR;
    }

    public void a(g.f fVar) {
        this.eWY = fVar;
    }

    public void a(g.a aVar) {
        this.grx = aVar;
    }

    public void a(g.b bVar) {
        this.gry = bVar;
    }

    public void aOP() {
        this.eWS.setImageResource(d.f.icon_video_play);
        this.cTU.bkE();
        this.cWI.setVisibility(0);
        this.grv.setVisibility(8);
        this.gru.setVisibility(8);
        this.grw.setVisibility(8);
        this.bat = 2;
        this.bYP.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bYP != null) {
            this.bYP.setPbLoadingTime(currentTimeMillis);
        }
        bL(str, str2);
    }

    public void bL(String str, String str2) {
        this.grQ = true;
        this.bat = 0;
        this.bYP.setRecoveryState(0);
        bK(str, str2);
        this.bYP.bN(str, str2);
        this.cTU.startLoading();
        this.eWX.setVisibility(0);
        this.cWI.setVisibility(8);
        this.eWS.setImageResource(d.f.icon_video_suspend_n);
        this.grv.setVisibility(8);
        this.gru.setVisibility(8);
        this.grw.setVisibility(8);
        this.cWM.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXz);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.eXz, 60000L);
    }

    public void bM(String str, String str2) {
        this.grQ = true;
        this.bat = 0;
        this.bYP.setRecoveryState(0);
        this.cTU.startLoading();
        this.eWX.setVisibility(0);
        this.cWI.setVisibility(8);
        this.eWS.setImageResource(d.f.icon_video_suspend_n);
        this.grv.setVisibility(8);
        this.gru.setVisibility(8);
        this.grw.setVisibility(8);
        this.cWM.setVisibility(8);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXz);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.eXz, 60000L);
    }

    public void aOR() {
        this.bat = 1;
        this.bYP.setRecoveryState(1);
        this.bYP.start();
        this.eWS.setImageResource(d.f.icon_video_suspend_n);
        this.eWX.setVisibility(8);
        this.eWO.setVisibility(8);
        this.cTU.bkE();
        this.eWN.showProgress();
        this.cWI.setVisibility(8);
        this.grv.setVisibility(8);
        this.gru.setVisibility(8);
        this.grw.setVisibility(8);
        bjO();
    }

    public void bjH() {
        if (com.baidu.adp.lib.util.j.oJ() && this.grO && !StringUtils.isNull(this.bON) && !StringUtils.isNull(this.bBb)) {
            this.grO = false;
            this.grP = true;
            bL(this.bON, this.bBb);
        }
    }

    public void lz(boolean z) {
        if (this.bYP != null) {
            this.bYP.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bYP.isPlaying() && this.grJ) {
            bjI();
        }
        bjN();
        this.bYP.pause();
        aOP();
    }

    public void stopPlay() {
        if (this.bYP.isPlaying() && this.grJ) {
            bjI();
        }
        this.bat = 5;
        this.bYP.setRecoveryState(5);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXx);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXz);
        this.bYP.stopPlayback();
        this.eXc = false;
        this.grQ = false;
        this.mStartPosition = 0;
        aCi();
    }

    public void bjI() {
        z.bkI().aA(this.bON, this.bYP.getCurrentPosition());
    }

    public void lA(boolean z) {
        this.grJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        if (this.eWU != null) {
            this.eWO.setVisibility(0);
            this.cWI.setVisibility(0);
            this.grv.setVisibility(8);
            this.gru.setVisibility(8);
            this.grw.setVisibility(8);
            this.cTU.bkE();
            this.eWS.setImageResource(d.f.icon_video_play);
            this.eWU.setVisibility(4);
            this.grr.setVisibility(8);
            this.cWM.setVisibility(8);
            this.eWN.TL();
            this.eWX.setVisibility(z ? 0 : 8);
        }
    }

    public void aCi() {
        lB(true);
    }

    public boolean bjJ() {
        if (this.bYP == null) {
            return false;
        }
        return this.bYP.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bYP == null) {
            return 0;
        }
        return this.bYP.getCurrentPosition();
    }

    public void a(i iVar) {
        this.grE = iVar;
    }

    public void a(h hVar) {
        this.grD = hVar;
    }

    public void a(g gVar) {
        this.fZt = gVar;
    }

    public void a(f fVar) {
        this.grC = fVar;
    }

    public void qH(String str) {
        this.fYX = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjK() {
        a(this.bON, this.bBb, null, new Object[0]);
    }

    public void b(InterfaceC0149c interfaceC0149c) {
        this.grB = interfaceC0149c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        if (com.baidu.adp.lib.util.j.oL()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.grL = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.grH != null) {
                    this.grH.fT(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQs.getPageActivity());
                aVar.cZ(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bjL();
                        if (c.this.grL) {
                            c.this.bM(str, str2);
                        } else {
                            c.this.bL(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lF(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aQs).AB();
                return;
            } else if (this.grH != null) {
                this.grH.fT(true);
                return;
            } else {
                if (!this.grq) {
                    this.grq = true;
                    com.baidu.adp.lib.util.l.showToast(this.aQs.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                if (this.grL) {
                    bM(str, str2);
                } else {
                    bL(str, str2);
                }
                if (dVar != null) {
                    dVar.lF(true);
                    return;
                }
                return;
            }
        }
        if (this.grL) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.lF(true);
        }
        if (this.grG != null) {
            this.grG.avG();
        }
    }

    public void bjL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void oj(String str) {
        this.eWX.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXD);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXx);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXz);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.grU);
        this.clg.stop();
        this.eXu.unregister(this.aQs.getPageActivity());
    }

    public void qZ(String str) {
        this.eXb.setText(str);
    }

    public boolean aOS() {
        return this.eXc;
    }

    public void aOT() {
        if (this.eWU != null) {
            aOV();
            this.eWU.setVisibility(0);
            this.grt.setVisibility(0);
            if (this.grB != null) {
                this.grB.fU(true);
            }
            this.grr.setVisibility(8);
            this.dFs.setAnimationListener(this.eXB);
            this.eWU.startAnimation(this.dFs);
            this.eXe = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjM() {
        if (this.eWU != null) {
            if (this.eWU.getVisibility() == 0) {
                aOV();
                this.eWU.setVisibility(8);
                this.grr.setVisibility(0);
                if (this.grB != null) {
                    this.grB.avI();
                    return;
                }
                return;
            }
            aOW();
        }
    }

    public void aOU() {
        if (this.eWU != null) {
            aOV();
            this.eWU.setVisibility(0);
            this.grt.setVisibility(0);
            if (this.grB != null) {
                this.grB.fU(false);
            }
            this.grr.setVisibility(8);
            this.dFt.setAnimationListener(this.eXC);
            this.eWU.startAnimation(this.dFt);
        }
    }

    public void bjN() {
        if (this.eWU != null) {
            aOV();
            this.eWU.setVisibility(0);
            this.grt.setVisibility(0);
            this.grr.setVisibility(8);
            if (this.grB != null) {
                this.grB.fU(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOV() {
        if (this.eWU != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXD);
            this.dFt.setAnimationListener(null);
            this.dFs.setAnimationListener(null);
            this.eWU.clearAnimation();
            this.eXe = false;
        }
    }

    public void aOW() {
        aOU();
        bjO();
    }

    private void bjO() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eXD);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.eXD, 3000L);
    }

    public void a(b bVar) {
        this.grA = bVar;
    }

    public void rd(int i2) {
        if (this.bYP.getDuration() - i2 <= 3000) {
            aOV();
            if (this.eWU != null) {
                this.eWU.setVisibility(0);
                this.grt.setVisibility(0);
                this.grr.setVisibility(8);
                if (this.grB != null) {
                    this.grB.fU(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void lC(boolean z) {
        if (this.clg != null) {
            if (this.eWT != null || this.grs != null) {
                this.eWT.setVisibility(z ? 0 : 8);
                this.grs.setVisibility(z ? 0 : 8);
            }
            if (!z && this.eWN != null && (this.eWN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWN.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.tbds52);
                this.eWN.setLayoutParams(layoutParams);
            }
            this.clg.lH(z);
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

    public int bjP() {
        return this.bat;
    }

    public void a(k kVar) {
        this.grF = kVar;
    }

    public void a(j jVar) {
        this.grG = jVar;
    }

    public void a(e eVar) {
        this.grH = eVar;
    }

    public void lD(boolean z) {
        this.grN = z;
    }

    public void lE(boolean z) {
        this.grz = z;
    }

    public void tS(int i2) {
        this.grR = i2;
    }
}
