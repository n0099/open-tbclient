package com.baidu.tieba.play;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
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
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.u;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int ejt;
    private String aMX;
    private TbPageContext<?> aca;
    private String baM;
    private QuickVideoView blp;
    private p bxc;
    private Animation cLr;
    private Animation cLs;
    private View cdh;
    private ImageView cdi;
    private View cdm;
    private View dyY;
    protected View eiK;
    private VideoListMediaControllerView eiM;
    private View eiN;
    private FrameLayout eiO;
    protected FrameLayout.LayoutParams eiP;
    private ImageView eiR;
    private ImageView eiS;
    private View eiT;
    private View eiV;
    private TbImageView eiW;
    private g.f eiX;
    private ImageView eiZ;
    private TextView eja;
    private View ejg;
    private View ejh;
    private TextView eji;
    private SeekBar ejj;
    private ImageView ejk;
    private ImageView ejl;
    private int ejm;
    private int ejr;
    private int ejs;
    private CallStateReceiver eju;
    private ProgressBar fOT;
    private View fOU;
    private View fOV;
    private TextView fOW;
    private TextView fOX;
    private TextView fOY;
    private g.a fOZ;
    private g.b fPa;
    private b fPc;
    private InterfaceC0136c fPd;
    private f fPe;
    private h fPf;
    private i fPg;
    private k fPh;
    private j fPi;
    private e fPj;
    private TextView fPn;
    private boolean fPp;
    private boolean fPq;
    private g fkB;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fOS = false;
    protected boolean dvZ = false;
    private boolean ejb = false;
    private boolean ejd = false;
    private boolean fPb = false;
    private int ejf = 0;
    private int mStatus = 0;
    private int ejn = 0;
    private int ejo = 0;
    private boolean ejv = false;
    private boolean fPk = true;
    private boolean fPl = true;
    private boolean fPm = false;
    private String fkf = null;
    private int amm = -1;
    private boolean fPo = false;
    private g.f aZt = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejx);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejx, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejz);
            if (c.this.blp.bjq()) {
                c.this.amm = 1;
                c.this.blp.setRecoveryState(1);
            }
            if (gVar != null && c.this.eiM != null) {
                c.this.ejf = x.bjK().rs(c.this.baM);
                c.this.eiM.V(c.this.ejf, gVar.getDuration());
                if (c.this.ejf != 0) {
                    if (c.this.blp != null) {
                        c.this.blp.sz(c.this.ejf);
                    } else {
                        gVar.seekTo(c.this.ejf);
                    }
                    if (!c.this.fPq) {
                        c.this.eiM.showProgress();
                        com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejx);
                    }
                    c.this.fPm = true;
                }
            }
        }
    };
    private Runnable ejx = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.blp.getCurrentPosition() > 100) {
                c.this.ejb = true;
                c.this.eiN.setVisibility(8);
                c.this.cdm.setVisibility(8);
                c.this.dyY.setVisibility(8);
                c.this.eiW.setVisibility(8);
                c.this.aHL();
                if (c.this.amm == 1 || c.this.amm == 2) {
                    if (c.this.eiT != null) {
                        c.this.eiT.setVisibility(0);
                        c.this.fOV.setVisibility(0);
                        c.this.fOT.setVisibility(8);
                        if (c.this.fPd != null) {
                            c.this.fPd.fi(false);
                        }
                    }
                    c.this.eiM.showProgress();
                    c.this.aHM();
                }
                if (c.this.eiX != null) {
                    c.this.eiX.onPrepared(c.this.blp.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejx, 20L);
        }
    };
    private g.a aZs = new g.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.ejb = false;
            c.this.ejf = 0;
            c.this.aHt();
            c.this.eiN.setVisibility(0);
            c.this.fOT.setVisibility(8);
            c.this.fOT.setProgress(c.this.fOT.getMax());
            if (c.this.fPd != null) {
                c.this.fPd.fi(false);
            }
            if (c.this.dvZ) {
                c.this.eiT.setVisibility(0);
                c.this.eiZ.setVisibility(0);
                c.this.eja.setVisibility(0);
                c.this.fOV.setVisibility(8);
            } else {
                c.this.eiT.setVisibility(8);
                c.this.eiZ.setVisibility(8);
                c.this.eja.setVisibility(8);
                c.this.fOV.setVisibility(8);
            }
            if (c.this.blp == null || c.this.blp.getDuration() > 150000) {
                c.this.lT(false);
            } else {
                c.this.fOW.setVisibility(0);
            }
            x.bjK().remove(c.this.baM);
            if (c.this.fOZ != null) {
                c.this.fOZ.onCompletion(gVar);
            }
            c.this.amm = 3;
            c.this.blp.setRecoveryState(3);
            if (!c.this.dvZ && c.this.blp != null && c.this.blp.getDuration() <= 150000) {
                if (!c.this.fPo) {
                    if (c.this.fPf != null) {
                        c.this.fPf.ku(true);
                    }
                    c.this.bQ(c.this.baM, c.this.aMX);
                    return;
                }
                c.this.amm = 5;
                c.this.blp.setRecoveryState(5);
                c.this.blp.getPlayer().pause();
                c.this.blp.getPlayer().seekTo(0);
            }
        }
    };
    private g.b ejy = new g.b() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cdm.setVisibility(0);
            c.this.dyY.setVisibility(8);
            c.this.amm = 4;
            c.this.blp.setRecoveryState(4);
            if (c.this.fPa != null) {
                c.this.fPa.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.hh()) {
                c.this.fPp = true;
            }
            return true;
        }
    };
    private Runnable ejz = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            c.this.cdm.setVisibility(0);
            c.this.dyY.setVisibility(8);
        }
    };
    private g.InterfaceC0137g aZx = new g.InterfaceC0137g() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.InterfaceC0137g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fPm) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fPr, 200L);
            }
        }
    };
    private Runnable fPr = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.blp == null || !c.this.fPm) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejx, 200L);
                c.this.fPm = false;
            } else if (c.this.ejf != c.this.blp.getCurrentPosition()) {
                c.this.fPm = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejx, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fPr, 200L);
            }
        }
    };
    private QuickVideoView.b blw = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.ejb = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejx);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejz);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cdm.getId()) {
                c.this.biW();
            } else if (view.getId() != c.this.cdi.getId() && view.getId() != c.this.eiR.getId()) {
                if (view.getId() == c.this.fOX.getId()) {
                    if (c.this.fPe != null) {
                        c.this.fPe.aYD();
                    }
                } else if (view.getId() == c.this.fOW.getId()) {
                    if (c.this.fPf != null) {
                        c.this.fPf.ku(false);
                    }
                    c.this.bQ(c.this.baM, c.this.aMX);
                } else if (view.getId() != c.this.eiS.getId() && view.getId() != c.this.fOU.getId()) {
                    if (view.getId() == c.this.eiZ.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fPi != null) {
                            c.this.fPi.amS();
                        }
                        c.this.aHx();
                    }
                } else {
                    if (c.this.dvZ) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fPi != null) {
                        c.this.fPi.amS();
                    }
                    c.this.aHx();
                }
            } else {
                c.this.aYu();
            }
        }
    };
    private Animation.AnimationListener ejB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.5
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eiT != null) {
                c.this.eiT.setVisibility(8);
                c.this.fOT.setVisibility(0);
                c.this.ejd = false;
                if (c.this.fPd != null) {
                    c.this.fPd.amT();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener ejC = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
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
    private Runnable ejD = new Runnable() { // from class: com.baidu.tieba.play.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.aHJ();
        }
    };
    private CustomMessageListener ejE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private u.b emn = new u.b() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.u.b
        public void gx(int i2) {
            int duration;
            if (c.this.blp != null && (duration = c.this.blp.getDuration()) > 0 && c.this.fOT != null) {
                c.this.fOT.setProgress((int) ((i2 * c.this.eiK.getWidth()) / duration));
            }
            c.this.os(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bdD = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.ejd) {
                c.this.aHM();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aHI() && c.this.aHy() != null) {
                c.this.setStartPosition(c.this.aHy().getSeekPosition());
                c.this.bQ(c.this.baM, c.this.aMX);
            }
        }
    };
    private QuickVideoView.a fPs = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bjc() {
            if (!c.this.fPo) {
                c.this.dyY.setVisibility(0);
                c.this.eiW.setVisibility(0);
                c.this.cdi.setVisibility(8);
                c.this.eiR.setImageResource(d.f.icon_video_suspend_n);
                c.this.fOX.setVisibility(8);
                c.this.fOW.setVisibility(8);
                c.this.fOY.setVisibility(8);
                c.this.cdm.setVisibility(8);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejz);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejz, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void amP();

        void amQ();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0136c {
        void amT();

        void fi(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aYD();
    }

    /* loaded from: classes.dex */
    public interface g {
        void amU();
    }

    /* loaded from: classes.dex */
    public interface h {
        void ku(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void amR();

        void amS();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aYE();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.ejr = 0;
        if (tbPageContext != null) {
            this.aca = tbPageContext;
            this.eiK = p(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eiK);
            }
            this.eiV = view;
            this.eiK.setOnClickListener(this.mOnClickListener);
            this.blp = (QuickVideoView) this.eiK.findViewById(d.g.videoView);
            this.dyY = this.eiK.findViewById(d.g.video_list_layout_loading);
            this.eiM = (VideoListMediaControllerView) this.eiK.findViewById(d.g.media_controller);
            this.eiM.setPlayer(this.blp);
            this.fOT = (ProgressBar) this.eiK.findViewById(d.g.pgrBottomProgress);
            this.fOT.setMax(com.baidu.adp.lib.util.l.ac(this.aca.getPageActivity()));
            this.fOT.setProgress(0);
            this.eiM.setOnSeekBarChangeListener(this.bdD);
            this.eiM.setOnProgressUpdatedListener(this.emn);
            this.eiN = this.eiK.findViewById(d.g.black_mask);
            this.cdm = this.eiK.findViewById(d.g.layout_error);
            this.cdm.setOnClickListener(this.mOnClickListener);
            this.fPn = (TextView) this.eiK.findViewById(d.g.auto_video_error_tips);
            this.eiO = (FrameLayout) this.eiK.findViewById(d.g.danmu_container);
            this.eiR = (ImageView) this.eiK.findViewById(d.g.img_play_icon);
            this.eiR.setOnClickListener(this.mOnClickListener);
            this.eiS = (ImageView) this.eiK.findViewById(d.g.img_full_screen);
            this.eiS.setOnClickListener(this.mOnClickListener);
            this.fOU = this.eiK.findViewById(d.g.full_screen_container);
            this.fOU.setOnClickListener(this.mOnClickListener);
            this.eiT = this.eiK.findViewById(d.g.layout_media_controller);
            this.fOV = this.eiK.findViewById(d.g.time_show_controller);
            this.blp.setOnPreparedListener(this.aZt);
            this.blp.setOnCompletionListener(this.aZs);
            this.blp.setOnErrorListener(this.ejy);
            this.blp.setOnSeekCompleteListener(this.aZx);
            this.blp.setOnSurfaceDestroyedListener(this.blw);
            this.blp.setOnRecoveryCallback(this.fPs);
            this.cdi = (ImageView) this.eiK.findViewById(d.g.img_play);
            this.cdi.setOnClickListener(this.mOnClickListener);
            this.fOW = (TextView) this.eiK.findViewById(d.g.txt_replay);
            this.fOW.setOnClickListener(this.mOnClickListener);
            this.fOX = (TextView) this.eiK.findViewById(d.g.txt_playnext);
            this.fOX.setOnClickListener(this.mOnClickListener);
            this.fOY = (TextView) this.eiK.findViewById(d.g.txt_next_video_title);
            this.eiW = (TbImageView) this.eiK.findViewById(d.g.video_thumbnail);
            this.eiW.setDefaultErrorResource(0);
            this.eiW.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.aca.getPageActivity());
            this.mScreenHeight = bF(this.aca.getPageActivity());
            this.eiZ = (ImageView) this.eiK.findViewById(d.g.img_exit);
            this.eiZ.setOnClickListener(this.mOnClickListener);
            this.eja = (TextView) this.eiK.findViewById(d.g.video_title);
            this.cdh = this.eiK.findViewById(d.g.layout_title);
            this.cdh.setVisibility(8);
            this.cLr = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cLs = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aca.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.ejm = this.mAudioManager.getStreamMaxVolume(3);
            this.ejs = this.mAudioManager.getStreamVolume(3);
            ejt = 100 / this.ejm;
            this.eiK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fPg != null) {
                        c.this.fPg.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.ejb) {
                            if (c.this.mStatus == 1 && c.this.ejo != 0) {
                                c.this.b(c.this.ejo == 1 ? 1000.0f : -1000.0f, false);
                                c.this.ejo = 0;
                                c.this.ejn = 0;
                            }
                            if (!c.this.blp.isPlaying() && 8 == c.this.cdi.getVisibility()) {
                                c.this.cdi.setVisibility(0);
                                c.this.fOX.setVisibility(8);
                                c.this.fOW.setVisibility(8);
                                c.this.fOY.setVisibility(8);
                            }
                        }
                        c.this.aHt();
                        if (c.this.fPg != null) {
                            c.this.fPg.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bxc = new p(this.aca.getPageActivity());
            this.bxc.start();
            this.ejr = com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.ds16);
            this.eju = new CallStateReceiver();
            this.eju.register(this.aca.getPageActivity());
            this.aca.registerListener(this.ejE);
            biR();
        }
    }

    public void biR() {
        if (this.fPk) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eiK.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eiK.setSystemUiVisibility(0);
    }

    public void lQ(boolean z) {
        this.fPk = z;
        biR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        this.mStatus = 0;
        if (this.ejg != null && this.ejg.getParent() != null && (this.ejg.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ejg.getParent()).removeView(this.ejg);
                this.ejg = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ejh != null && this.ejh.getParent() != null && (this.ejh.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ejh.getParent()).removeView(this.ejh);
                this.ejh = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aHu() {
        if (this.mStatus == 1) {
            if (this.ejg == null && this.eiK != null && (this.eiK instanceof ViewGroup)) {
                LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.eiK, true);
                this.ejg = this.eiK.findViewById(d.g.lay_jindu);
                this.eji = (TextView) this.ejg.findViewById(d.g.show_time);
                this.ejl = (ImageView) this.ejg.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ejh == null && this.eiK != null && (this.eiK instanceof ViewGroup)) {
            LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.eiK, true);
            this.ejh = this.eiK.findViewById(d.g.lay_voice);
            this.ejk = (ImageView) this.ejh.findViewById(d.g.arrow_voice_icon);
            this.ejj = (SeekBar) this.ejh.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fPg != null) {
                c.this.fPg.onStart();
            }
            if (c.this.dvZ && c.this.ejb) {
                if (!c.this.blp.isPlaying() && c.this.cdi.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cdi.setVisibility(8);
                    c.this.fOX.setVisibility(8);
                    c.this.fOW.setVisibility(8);
                    c.this.fOY.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.W(f2);
                    }
                } else {
                    if (c.this.dvZ) {
                        c.this.aHw();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ejn = c.this.blp.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.W(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fPh != null) {
                c.this.fPh.aYE();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.ejb) {
                if (c.this.amm != 2) {
                    c.this.biY();
                } else {
                    c.this.aYu();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHw() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eiK.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eiK.setSystemUiVisibility(4);
        } else {
            this.eiK.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(float f2) {
        if (!this.ejb) {
            this.mStatus = 0;
            return;
        }
        aHu();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ejt == 0) {
            if (f2 > 0.0f && this.ejs < this.ejm) {
                this.ejs++;
            }
            if (f2 < 0.0f && this.ejs > 0) {
                this.ejs--;
            }
        }
        if (this.mProgress > 0) {
            this.ejk.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.ejk.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.ejs, 0);
        this.ejj.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ejn -= 1000;
                this.ejo = 1;
            } else {
                this.ejn += 1000;
                this.ejo = 2;
            }
            if (this.ejn < 0) {
                this.ejn = 0;
            } else if (this.ejn > this.blp.getDuration()) {
                this.ejn = this.blp.getDuration();
            }
        }
        aHu();
        String sA = this.eiM.sA(this.ejn);
        if (f2 > 0.0f) {
            this.ejl.setImageResource(d.f.icon_kuaitui);
        } else {
            this.ejl.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(sA)) {
            this.eji.setText(new StringBuilder().append(sA).append("/").append(this.eiM.sA(this.blp.getDuration())));
        }
        this.eiM.A(this.ejn, z ? false : true);
        this.eiT.setVisibility(8);
        this.fOT.setVisibility(0);
        biS();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bP(String str, String str2) {
        this.baM = str;
        this.aMX = str2;
    }

    public void aYu() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.aca.getPageActivity(), this.aca.getString(d.j.neterror));
        } else if (this.blp.isPlaying()) {
            pausePlay();
        } else if (this.ejb) {
            aHH();
            if (this.fkB != null) {
                this.fkB.amU();
            }
        } else {
            biW();
        }
    }

    public void aHx() {
        this.ejv = true;
        if (this.bxc != null) {
            this.bxc.aHx();
        }
    }

    public boolean sw(int i2) {
        switch (i2) {
            case 4:
                if (this.dvZ) {
                    aHx();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.ejm <= 0 || this.ejj == null) {
                    return false;
                }
                this.ejs = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.ejs * 100.0d) / this.ejm);
                this.ejj.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.blp;
    }

    public VideoListMediaControllerView aHy() {
        return this.eiM;
    }

    public void show() {
        this.eiK.setVisibility(0);
    }

    public void aHC() {
        if (this.eiV != null) {
            ViewGroup.LayoutParams layoutParams = this.eiV.getLayoutParams();
            this.eiP = (FrameLayout.LayoutParams) this.eiK.getLayoutParams();
            this.eiP.width = layoutParams.width;
            this.eiP.height = layoutParams.height;
            this.eiP.topMargin = 0;
            this.eiK.setLayoutParams(this.eiP);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ejv) {
            if (this.dvZ) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.ejv = false;
        }
        if (configuration.orientation == 2) {
            this.dvZ = true;
            this.eiK.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.eiT.setVisibility(0);
            this.cdh.setVisibility(0);
            this.eiZ.setVisibility(0);
            this.eja.setVisibility(0);
            this.eiO.setVisibility(8);
            if (this.fPb) {
                this.dyY.setVisibility(0);
                this.eiW.setVisibility(0);
            } else {
                this.dyY.setVisibility(8);
                this.eiW.setVisibility(8);
            }
            if (this.fPc != null) {
                this.fPc.amP();
            }
            this.eiS.setImageResource(d.f.icon_video_window);
            oq(this.ejr);
            aHw();
        } else {
            this.dvZ = false;
            if (this.eiP != null) {
                this.eiK.setLayoutParams(this.eiP);
            }
            a(tbPageContext, false);
            this.cdh.setVisibility(8);
            this.eiO.setVisibility(0);
            if (this.fPb) {
                this.dyY.setVisibility(0);
                this.eiW.setVisibility(0);
            } else {
                this.dyY.setVisibility(8);
                this.eiW.setVisibility(8);
            }
            if (this.fPc != null) {
                this.fPc.amQ();
            }
            if (this.amm == 3 && this.fPd != null) {
                this.fPd.fi(false);
            } else if (!this.ejb && this.eiT != null) {
                this.eiT.clearAnimation();
                this.eiT.setVisibility(4);
                this.fOT.setVisibility(0);
                if (this.fPd != null) {
                    this.fPd.amT();
                }
            }
            aHt();
            this.eiS.setImageResource(d.f.icon_video_fullscreen);
            if (this.eiM != null && (this.eiM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiM.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.tbds24);
                layoutParams.rightMargin = 0;
                this.eiM.setLayoutParams(layoutParams);
            }
            this.eiK.setSystemUiVisibility(0);
            biR();
        }
        if (this.blp.isPlaying()) {
            aHM();
        }
        biS();
    }

    public void biS() {
        if (this.blp != null) {
            int ac = com.baidu.adp.lib.util.l.ac(this.aca.getPageActivity());
            if (this.dvZ) {
                ac = com.baidu.adp.lib.util.l.ae(this.aca.getPageActivity());
            }
            this.fOT.setMax(ac);
            int duration = this.blp.getDuration();
            if (duration > 0) {
                if (this.fOW.getVisibility() == 0) {
                    this.fOT.setProgress(this.fOT.getMax());
                } else {
                    this.fOT.setProgress((int) ((this.blp.getCurrentPosition() * this.fOT.getMax()) / duration));
                }
            }
        }
    }

    private void oq(int i2) {
        if (this.eiM != null && (this.eiM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiM.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eiM.setLayoutParams(layoutParams);
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

    public boolean aHE() {
        return !this.dvZ;
    }

    public void a(g.a aVar) {
        this.fOZ = aVar;
    }

    public void a(g.b bVar) {
        this.fPa = bVar;
    }

    public void aHF() {
        this.eiR.setImageResource(d.f.icon_video_play);
        this.dyY.setVisibility(8);
        this.cdi.setVisibility(0);
        this.fOX.setVisibility(8);
        this.fOW.setVisibility(8);
        this.fOY.setVisibility(8);
        this.amm = 2;
        this.blp.setRecoveryState(2);
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.blp != null) {
            this.blp.setPbLoadingTime(currentTimeMillis);
        }
        bQ(str, str2);
    }

    public void bQ(String str, String str2) {
        this.amm = 0;
        this.blp.setRecoveryState(0);
        bP(str, str2);
        this.blp.bR(str, str2);
        this.blp.start();
        this.dyY.setVisibility(0);
        this.eiW.setVisibility(0);
        this.cdi.setVisibility(8);
        this.eiR.setImageResource(d.f.icon_video_suspend_n);
        this.fOX.setVisibility(8);
        this.fOW.setVisibility(8);
        this.fOY.setVisibility(8);
        this.cdm.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejz);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ejz, 60000L);
    }

    public void aHH() {
        this.amm = 1;
        this.blp.setRecoveryState(1);
        this.blp.start();
        this.eiR.setImageResource(d.f.icon_video_suspend_n);
        this.eiW.setVisibility(8);
        this.eiN.setVisibility(8);
        this.dyY.setVisibility(8);
        this.eiM.showProgress();
        this.cdi.setVisibility(8);
        this.fOX.setVisibility(8);
        this.fOW.setVisibility(8);
        this.fOY.setVisibility(8);
        bja();
    }

    public void biT() {
        if (com.baidu.adp.lib.util.j.hh() && this.fPp && !StringUtils.isNull(this.baM) && !StringUtils.isNull(this.aMX)) {
            this.fPp = false;
            this.fPq = true;
            bQ(this.baM, this.aMX);
        }
    }

    public void lR(boolean z) {
        if (this.blp != null) {
            this.blp.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.blp.isPlaying() && this.fPl) {
            biU();
        }
        biZ();
        this.blp.pause();
        aHF();
    }

    public void stopPlay() {
        if (this.blp.isPlaying() && this.fPl) {
            biU();
        }
        this.amm = 5;
        this.blp.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejz);
        this.blp.stopPlayback();
        this.ejb = false;
        this.ejf = 0;
        auW();
    }

    public void biU() {
        x.bjK().aw(this.baM, this.blp.getCurrentPosition());
    }

    public void lS(boolean z) {
        this.fPl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(boolean z) {
        if (this.eiT != null) {
            this.eiN.setVisibility(0);
            this.cdi.setVisibility(0);
            this.fOX.setVisibility(8);
            this.fOW.setVisibility(8);
            this.fOY.setVisibility(8);
            this.dyY.setVisibility(8);
            this.eiR.setImageResource(d.f.icon_video_play);
            this.eiT.setVisibility(4);
            this.fOT.setVisibility(8);
            this.cdm.setVisibility(8);
            this.eiM.Mw();
            this.eiW.setVisibility(z ? 0 : 8);
        }
    }

    public void auW() {
        lT(true);
    }

    public boolean biV() {
        if (this.blp == null) {
            return false;
        }
        return this.blp.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.blp == null) {
            return 0;
        }
        return this.blp.getCurrentPosition();
    }

    public void a(i iVar) {
        this.fPg = iVar;
    }

    public void a(h hVar) {
        this.fPf = hVar;
    }

    public void a(g gVar) {
        this.fkB = gVar;
    }

    public void a(f fVar) {
        this.fPe = fVar;
    }

    public void qn(String str) {
        this.fkf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biW() {
        a(this.baM, this.aMX, (d) null);
    }

    public void b(InterfaceC0136c interfaceC0136c) {
        this.fPd = interfaceC0136c;
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fPj != null) {
                    this.fPj.fh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aca.getPageActivity());
                aVar.cS(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.biX();
                        c.this.bQ(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lX(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aca).th();
                return;
            } else if (this.fPj != null) {
                this.fPj.fh(true);
                return;
            } else {
                if (!this.fOS) {
                    this.fOS = true;
                    com.baidu.adp.lib.util.l.showToast(this.aca.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                bQ(str, str2);
                if (dVar != null) {
                    dVar.lX(true);
                    return;
                }
                return;
            }
        }
        bQ(str, str2);
        if (dVar != null) {
            dVar.lX(true);
        }
        if (this.fPi != null) {
            this.fPi.amR();
        }
    }

    public void biX() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nP(String str) {
        this.eiW.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejD);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejz);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPr);
        this.bxc.stop();
        this.eju.unregister(this.aca.getPageActivity());
    }

    public void rm(String str) {
        this.eja.setText(str);
    }

    public boolean aHI() {
        return this.ejb;
    }

    public void aHJ() {
        if (this.eiT != null) {
            aHL();
            this.eiT.setVisibility(0);
            this.fOV.setVisibility(0);
            if (this.fPd != null) {
                this.fPd.fi(true);
            }
            this.fOT.setVisibility(8);
            this.cLr.setAnimationListener(this.ejB);
            this.eiT.startAnimation(this.cLr);
            this.ejd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biY() {
        if (this.eiT != null) {
            if (this.eiT.getVisibility() == 0) {
                aHL();
                this.eiT.setVisibility(8);
                this.fOT.setVisibility(0);
                if (this.fPd != null) {
                    this.fPd.amT();
                    return;
                }
                return;
            }
            aHM();
        }
    }

    public void aHK() {
        if (this.eiT != null) {
            aHL();
            this.eiT.setVisibility(0);
            this.fOV.setVisibility(0);
            if (this.fPd != null) {
                this.fPd.fi(false);
            }
            this.fOT.setVisibility(8);
            this.cLs.setAnimationListener(this.ejC);
            this.eiT.startAnimation(this.cLs);
        }
    }

    public void biZ() {
        if (this.eiT != null) {
            aHL();
            this.eiT.setVisibility(0);
            this.fOV.setVisibility(0);
            this.fOT.setVisibility(8);
            if (this.fPd != null) {
                this.fPd.fi(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHL() {
        if (this.eiT != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejD);
            this.cLs.setAnimationListener(null);
            this.cLr.setAnimationListener(null);
            this.eiT.clearAnimation();
            this.ejd = false;
        }
    }

    public void aHM() {
        aHK();
        bja();
    }

    private void bja() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejD);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ejD, 3000L);
    }

    public void a(b bVar) {
        this.fPc = bVar;
    }

    public void os(int i2) {
        if (this.blp.getDuration() - i2 <= 3000) {
            aHL();
            if (this.eiT != null) {
                this.eiT.setVisibility(0);
                this.fOV.setVisibility(0);
                this.fOT.setVisibility(8);
                if (this.fPd != null) {
                    this.fPd.fi(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.ejf = i2;
    }

    public void lU(boolean z) {
        if (this.bxc != null) {
            if (this.eiS != null || this.fOU != null) {
                this.eiS.setVisibility(z ? 0 : 8);
                this.fOU.setVisibility(z ? 0 : 8);
            }
            if (!z && this.eiM != null && (this.eiM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiM.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.tbds52);
                this.eiM.setLayoutParams(layoutParams);
            }
            this.bxc.lZ(z);
        }
    }

    public int bF(Context context) {
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
            return com.baidu.adp.lib.util.l.ae(context);
        }
        return i2;
    }

    public int bjb() {
        return this.amm;
    }

    public void a(k kVar) {
        this.fPh = kVar;
    }

    public void a(j jVar) {
        this.fPi = jVar;
    }

    public void a(e eVar) {
        this.fPj = eVar;
    }

    public void lV(boolean z) {
        this.fPo = z;
    }

    public void lW(boolean z) {
        this.fPb = z;
    }
}
