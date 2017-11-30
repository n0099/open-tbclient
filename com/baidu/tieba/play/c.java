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
    private static int eik;
    private String aMR;
    private TbPageContext<?> acd;
    private String baH;
    private QuickVideoView blk;
    private p bwX;
    private Animation cLd;
    private Animation cLe;
    private View ccP;
    private ImageView ccQ;
    private View ccU;
    private View dxP;
    protected View ehB;
    private VideoListMediaControllerView ehD;
    private View ehE;
    private FrameLayout ehF;
    protected FrameLayout.LayoutParams ehG;
    private ImageView ehI;
    private ImageView ehJ;
    private View ehK;
    private View ehM;
    private TbImageView ehN;
    private g.f ehO;
    private ImageView ehQ;
    private TextView ehR;
    private View ehX;
    private View ehY;
    private TextView ehZ;
    private SeekBar eia;
    private ImageView eib;
    private ImageView eic;
    private int eid;
    private int eii;
    private int eij;
    private CallStateReceiver eil;
    private ProgressBar fNW;
    private View fNX;
    private TextView fNY;
    private TextView fNZ;
    private TextView fOa;
    private g.a fOb;
    private g.b fOc;
    private b fOd;
    private InterfaceC0122c fOe;
    private f fOf;
    private h fOg;
    private i fOh;
    private k fOi;
    private j fOj;
    private e fOk;
    private TextView fOo;
    private boolean fOq;
    private boolean fOr;
    private g fjy;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fNV = false;
    protected boolean duQ = false;
    private boolean ehS = false;
    private boolean ehU = false;
    private int ehW = 0;
    private int mStatus = 0;
    private int eie = 0;
    private int eif = 0;
    private boolean eim = false;
    private boolean fOl = true;
    private boolean fOm = true;
    private boolean fOn = false;
    private String fjc = null;
    private int amm = -1;
    private boolean fOp = false;
    private g.f aZn = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eio);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.eio, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eiq);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fOs);
            if (c.this.blk.bjh()) {
                c.this.amm = 1;
                c.this.blk.setRecoveryState(1);
            }
            if (gVar != null && c.this.ehD != null) {
                c.this.ehW = x.bjC().rs(c.this.baH);
                c.this.ehD.U(c.this.ehW, gVar.getDuration());
                if (c.this.ehW != 0) {
                    if (c.this.blk != null) {
                        c.this.blk.ss(c.this.ehW);
                    } else {
                        gVar.seekTo(c.this.ehW);
                    }
                    if (!c.this.fOr) {
                        c.this.ehD.showProgress();
                        com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eio);
                    }
                    c.this.fOn = true;
                }
            }
        }
    };
    private Runnable eio = new Runnable() { // from class: com.baidu.tieba.play.c.14
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.blk.getCurrentPosition() > 100) {
                c.this.ehS = true;
                c.this.ehE.setVisibility(8);
                c.this.ccU.setVisibility(8);
                c.this.dxP.setVisibility(8);
                c.this.ehN.setVisibility(8);
                c.this.aHC();
                if (c.this.amm == 1 || c.this.amm == 2) {
                    if (c.this.ehK != null) {
                        c.this.ehK.setVisibility(0);
                        c.this.fNX.setVisibility(0);
                        c.this.fNW.setVisibility(8);
                        if (c.this.fOe != null) {
                            c.this.fOe.fh(false);
                        }
                    }
                    c.this.ehD.showProgress();
                    c.this.aHD();
                }
                if (c.this.ehO != null) {
                    c.this.ehO.onPrepared(c.this.blk.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.eio, 20L);
        }
    };
    private g.a aZm = new g.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.ehS = false;
            c.this.ehW = 0;
            c.this.aHk();
            c.this.ehE.setVisibility(0);
            c.this.fNW.setVisibility(8);
            c.this.fNW.setProgress(c.this.fNW.getMax());
            if (c.this.fOe != null) {
                c.this.fOe.fh(false);
            }
            if (c.this.duQ) {
                c.this.ehK.setVisibility(0);
                c.this.ehQ.setVisibility(0);
                c.this.ehR.setVisibility(0);
                c.this.fNX.setVisibility(8);
            } else {
                c.this.ehK.setVisibility(8);
                c.this.ehQ.setVisibility(8);
                c.this.ehR.setVisibility(8);
                c.this.fNX.setVisibility(8);
            }
            if (c.this.blk == null || c.this.blk.getDuration() > 150000) {
                c.this.lS(false);
            } else {
                c.this.fNY.setVisibility(0);
            }
            x.bjC().remove(c.this.baH);
            if (c.this.fOb != null) {
                c.this.fOb.onCompletion(gVar);
            }
            c.this.amm = 3;
            c.this.blk.setRecoveryState(3);
            if (!c.this.duQ && c.this.blk != null && c.this.blk.getDuration() <= 150000) {
                if (!c.this.fOp) {
                    if (c.this.fOg != null) {
                        c.this.fOg.kt(true);
                    }
                    c.this.bP(c.this.baH, c.this.aMR);
                    return;
                }
                c.this.amm = 5;
                c.this.blk.setRecoveryState(5);
                c.this.blk.getPlayer().pause();
                c.this.blk.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eip = new g.b() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.ccU.setVisibility(0);
            c.this.dxP.setVisibility(8);
            c.this.amm = 4;
            c.this.blk.setRecoveryState(4);
            if (c.this.fOc != null) {
                c.this.fOc.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.hh()) {
                c.this.fOq = true;
            }
            return true;
        }
    };
    private Runnable eiq = new Runnable() { // from class: com.baidu.tieba.play.c.17
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.blk == null || !c.this.blk.bji()) {
                c.this.ccU.setVisibility(0);
                c.this.dxP.setVisibility(8);
                return;
            }
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eiq);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.eiq, 60000L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fOs);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fOs, 10000L);
        }
    };
    private Runnable fOs = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.blk != null) {
                c.this.blk.bjj();
                c.this.blk.bjk();
            }
        }
    };
    private g.InterfaceC0123g aZr = new g.InterfaceC0123g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0123g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fOn) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fOt, 200L);
            }
        }
    };
    private Runnable fOt = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.blk == null || !c.this.fOn) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.eio, 200L);
                c.this.fOn = false;
            } else if (c.this.ehW != c.this.blk.getCurrentPosition()) {
                c.this.fOn = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.eio, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fOt, 200L);
            }
        }
    };
    private QuickVideoView.b blr = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.ehS = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eio);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eiq);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fOs);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.ccU.getId()) {
                c.this.biO();
            } else if (view.getId() != c.this.ccQ.getId() && view.getId() != c.this.ehI.getId()) {
                if (view.getId() == c.this.fNZ.getId()) {
                    if (c.this.fOf != null) {
                        c.this.fOf.aYv();
                    }
                } else if (view.getId() == c.this.fNY.getId()) {
                    if (c.this.fOg != null) {
                        c.this.fOg.kt(false);
                    }
                    c.this.bP(c.this.baH, c.this.aMR);
                } else if (view.getId() != c.this.ehJ.getId()) {
                    if (view.getId() == c.this.ehQ.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fOj != null) {
                            c.this.fOj.amJ();
                        }
                        c.this.aHo();
                    }
                } else {
                    if (c.this.duQ) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fOj != null) {
                        c.this.fOj.amJ();
                    }
                    c.this.aHo();
                }
            } else {
                c.this.aYm();
            }
        }
    };
    private Animation.AnimationListener eis = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.ehK != null) {
                c.this.ehK.setVisibility(8);
                c.this.fNW.setVisibility(0);
                c.this.ehU = false;
                if (c.this.fOe != null) {
                    c.this.fOe.amK();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eit = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable eiu = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aHA();
        }
    };
    private CustomMessageListener eiv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private u.b ele = new u.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.u.b
        public void gx(int i2) {
            int duration;
            if (c.this.blk != null && (duration = c.this.blk.getDuration()) > 0 && c.this.fNW != null) {
                c.this.fNW.setProgress((int) ((i2 * c.this.ehB.getWidth()) / duration));
            }
            c.this.ol(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bdy = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.ehU) {
                c.this.aHD();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aHz() && c.this.aHp() != null) {
                c.this.setStartPosition(c.this.aHp().getSeekPosition());
                c.this.bP(c.this.baH, c.this.aMR);
            }
        }
    };
    private QuickVideoView.a fOu = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void biU() {
            if (!c.this.fOp) {
                c.this.dxP.setVisibility(0);
                c.this.ehN.setVisibility(0);
                c.this.ccQ.setVisibility(8);
                c.this.ehI.setImageResource(d.f.icon_video_suspend_n);
                c.this.fNZ.setVisibility(8);
                c.this.fNY.setVisibility(8);
                c.this.fOa.setVisibility(8);
                c.this.ccU.setVisibility(8);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.eiq);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.eiq, 60000L);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fOs);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fOs, 10000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void amG();

        void amH();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122c {
        void amK();

        void fh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lV(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fg(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aYv();
    }

    /* loaded from: classes.dex */
    public interface g {
        void amL();
    }

    /* loaded from: classes.dex */
    public interface h {
        void kt(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void amI();

        void amJ();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aYw();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.eii = 0;
        if (tbPageContext != null) {
            this.acd = tbPageContext;
            this.ehB = p(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.ehB);
            }
            this.ehM = view;
            this.ehB.setOnClickListener(this.mOnClickListener);
            this.blk = (QuickVideoView) this.ehB.findViewById(d.g.videoView);
            this.dxP = this.ehB.findViewById(d.g.video_list_layout_loading);
            this.ehD = (VideoListMediaControllerView) this.ehB.findViewById(d.g.media_controller);
            this.ehD.setPlayer(this.blk);
            this.fNW = (ProgressBar) this.ehB.findViewById(d.g.pgrBottomProgress);
            this.fNW.setMax(com.baidu.adp.lib.util.l.ac(this.acd.getPageActivity()));
            this.fNW.setProgress(0);
            this.ehD.setOnSeekBarChangeListener(this.bdy);
            this.ehD.setOnProgressUpdatedListener(this.ele);
            this.ehE = this.ehB.findViewById(d.g.black_mask);
            this.ccU = this.ehB.findViewById(d.g.layout_error);
            this.ccU.setOnClickListener(this.mOnClickListener);
            this.fOo = (TextView) this.ehB.findViewById(d.g.auto_video_error_tips);
            this.ehF = (FrameLayout) this.ehB.findViewById(d.g.danmu_container);
            this.ehI = (ImageView) this.ehB.findViewById(d.g.img_play_icon);
            this.ehI.setOnClickListener(this.mOnClickListener);
            this.ehJ = (ImageView) this.ehB.findViewById(d.g.img_full_screen);
            this.ehJ.setOnClickListener(this.mOnClickListener);
            this.ehK = this.ehB.findViewById(d.g.layout_media_controller);
            this.fNX = this.ehB.findViewById(d.g.time_show_controller);
            this.blk.setOnPreparedListener(this.aZn);
            this.blk.setOnCompletionListener(this.aZm);
            this.blk.setOnErrorListener(this.eip);
            this.blk.setOnSeekCompleteListener(this.aZr);
            this.blk.setOnSurfaceDestroyedListener(this.blr);
            this.blk.setOnRecoveryCallback(this.fOu);
            this.ccQ = (ImageView) this.ehB.findViewById(d.g.img_play);
            this.ccQ.setOnClickListener(this.mOnClickListener);
            this.fNY = (TextView) this.ehB.findViewById(d.g.txt_replay);
            this.fNY.setOnClickListener(this.mOnClickListener);
            this.fNZ = (TextView) this.ehB.findViewById(d.g.txt_playnext);
            this.fNZ.setOnClickListener(this.mOnClickListener);
            this.fOa = (TextView) this.ehB.findViewById(d.g.txt_next_video_title);
            this.ehN = (TbImageView) this.ehB.findViewById(d.g.video_thumbnail);
            this.ehN.setDefaultErrorResource(0);
            this.ehN.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.acd.getPageActivity());
            this.mScreenHeight = bI(this.acd.getPageActivity());
            this.ehQ = (ImageView) this.ehB.findViewById(d.g.img_exit);
            this.ehQ.setOnClickListener(this.mOnClickListener);
            this.ehR = (TextView) this.ehB.findViewById(d.g.video_title);
            this.ccP = this.ehB.findViewById(d.g.layout_title);
            this.ccP.setVisibility(8);
            this.cLd = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cLe = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.acd.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eid = this.mAudioManager.getStreamMaxVolume(3);
            this.eij = this.mAudioManager.getStreamVolume(3);
            eik = 100 / this.eid;
            this.ehB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fOh != null) {
                        c.this.fOh.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.ehS) {
                            if (c.this.mStatus == 1 && c.this.eif != 0) {
                                c.this.b(c.this.eif == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eif = 0;
                                c.this.eie = 0;
                            }
                            if (!c.this.blk.isPlaying() && 8 == c.this.ccQ.getVisibility()) {
                                c.this.ccQ.setVisibility(0);
                                c.this.fNZ.setVisibility(8);
                                c.this.fNY.setVisibility(8);
                                c.this.fOa.setVisibility(8);
                            }
                        }
                        c.this.aHk();
                        if (c.this.fOh != null) {
                            c.this.fOh.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bwX = new p(this.acd.getPageActivity());
            this.bwX.start();
            this.eii = com.baidu.adp.lib.util.l.f(this.acd.getPageActivity(), d.e.ds16);
            this.eil = new CallStateReceiver();
            this.eil.register(this.acd.getPageActivity());
            this.acd.registerListener(this.eiv);
            biJ();
        }
    }

    public void biJ() {
        if (this.fOl) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ehB.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.ehB.setSystemUiVisibility(0);
    }

    public void lP(boolean z) {
        this.fOl = z;
        biJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHk() {
        this.mStatus = 0;
        if (this.ehX != null && this.ehX.getParent() != null && (this.ehX.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ehX.getParent()).removeView(this.ehX);
                this.ehX = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ehY != null && this.ehY.getParent() != null && (this.ehY.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ehY.getParent()).removeView(this.ehY);
                this.ehY = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aHl() {
        if (this.mStatus == 1) {
            if (this.ehX == null && this.ehB != null && (this.ehB instanceof ViewGroup)) {
                LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.ehB, true);
                this.ehX = this.ehB.findViewById(d.g.lay_jindu);
                this.ehZ = (TextView) this.ehX.findViewById(d.g.show_time);
                this.eic = (ImageView) this.ehX.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ehY == null && this.ehB != null && (this.ehB instanceof ViewGroup)) {
            LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.ehB, true);
            this.ehY = this.ehB.findViewById(d.g.lay_voice);
            this.eib = (ImageView) this.ehY.findViewById(d.g.arrow_voice_icon);
            this.eia = (SeekBar) this.ehY.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fOh != null) {
                c.this.fOh.onStart();
            }
            if (c.this.duQ && c.this.ehS) {
                if (!c.this.blk.isPlaying() && c.this.ccQ.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.ccQ.setVisibility(8);
                    c.this.fNZ.setVisibility(8);
                    c.this.fNY.setVisibility(8);
                    c.this.fOa.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.W(f2);
                    }
                } else {
                    if (c.this.duQ) {
                        c.this.aHn();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eie = c.this.blk.getCurrentPosition();
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
            if (c.this.fOi != null) {
                c.this.fOi.aYw();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.ehS) {
                if (c.this.amm != 2) {
                    c.this.biQ();
                } else {
                    c.this.aYm();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHn() {
        if (Build.VERSION.SDK_INT < 16) {
            this.ehB.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.ehB.setSystemUiVisibility(4);
        } else {
            this.ehB.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(float f2) {
        if (!this.ehS) {
            this.mStatus = 0;
            return;
        }
        aHl();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eik == 0) {
            if (f2 > 0.0f && this.eij < this.eid) {
                this.eij++;
            }
            if (f2 < 0.0f && this.eij > 0) {
                this.eij--;
            }
        }
        if (this.mProgress > 0) {
            this.eib.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eib.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eij, 0);
        this.eia.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eie -= 1000;
                this.eif = 1;
            } else {
                this.eie += 1000;
                this.eif = 2;
            }
            if (this.eie < 0) {
                this.eie = 0;
            } else if (this.eie > this.blk.getDuration()) {
                this.eie = this.blk.getDuration();
            }
        }
        aHl();
        String st = this.ehD.st(this.eie);
        if (f2 > 0.0f) {
            this.eic.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eic.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(st)) {
            this.ehZ.setText(new StringBuilder().append(st).append("/").append(this.ehD.st(this.blk.getDuration())));
        }
        this.ehD.A(this.eie, z ? false : true);
        this.ehK.setVisibility(8);
        this.fNW.setVisibility(0);
        biK();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bO(String str, String str2) {
        this.baH = str;
        this.aMR = str2;
    }

    public void aYm() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.acd.getPageActivity(), this.acd.getString(d.j.neterror));
        } else if (this.blk.isPlaying()) {
            pausePlay();
        } else if (this.ehS) {
            aHy();
            if (this.fjy != null) {
                this.fjy.amL();
            }
        } else {
            biO();
        }
    }

    public void aHo() {
        this.eim = true;
        if (this.bwX != null) {
            this.bwX.aHo();
        }
    }

    public boolean sp(int i2) {
        switch (i2) {
            case 4:
                if (this.duQ) {
                    aHo();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eid <= 0 || this.eia == null) {
                    return false;
                }
                this.eij = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eij * 100.0d) / this.eid);
                this.eia.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.blk;
    }

    public VideoListMediaControllerView aHp() {
        return this.ehD;
    }

    public void show() {
        this.ehB.setVisibility(0);
    }

    public void aHt() {
        if (this.ehM != null) {
            ViewGroup.LayoutParams layoutParams = this.ehM.getLayoutParams();
            this.ehG = (FrameLayout.LayoutParams) this.ehB.getLayoutParams();
            this.ehG.width = layoutParams.width;
            this.ehG.height = layoutParams.height;
            this.ehG.topMargin = 0;
            this.ehB.setLayoutParams(this.ehG);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eim) {
            if (this.duQ) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.eim = false;
        }
        if (configuration.orientation == 2) {
            this.duQ = true;
            this.ehB.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.ehK.setVisibility(0);
            this.ccP.setVisibility(0);
            this.ehQ.setVisibility(0);
            this.ehR.setVisibility(0);
            this.ehF.setVisibility(8);
            if (this.fOd != null) {
                this.fOd.amG();
            }
            this.ehJ.setImageResource(d.f.icon_video_window);
            oj(this.eii);
            aHn();
        } else {
            this.duQ = false;
            if (this.ehG != null) {
                this.ehB.setLayoutParams(this.ehG);
            }
            a(tbPageContext, false);
            this.ccP.setVisibility(8);
            this.ehF.setVisibility(0);
            if (this.fOd != null) {
                this.fOd.amH();
            }
            if (this.amm == 3 && this.fOe != null) {
                this.fOe.fh(false);
            } else if (!this.ehS && this.ehK != null) {
                this.ehK.clearAnimation();
                this.ehK.setVisibility(4);
                this.fNW.setVisibility(0);
                if (this.fOe != null) {
                    this.fOe.amK();
                }
            }
            aHk();
            this.ehJ.setImageResource(d.f.icon_video_fullscreen);
            oj(0);
            this.ehB.setSystemUiVisibility(0);
            biJ();
        }
        if (this.blk.isPlaying()) {
            aHD();
        }
        biK();
    }

    public void biK() {
        if (this.blk != null) {
            int ac = com.baidu.adp.lib.util.l.ac(this.acd.getPageActivity());
            if (this.duQ) {
                ac = com.baidu.adp.lib.util.l.ae(this.acd.getPageActivity());
            }
            this.fNW.setMax(ac);
            int duration = this.blk.getDuration();
            if (duration > 0) {
                if (this.fNY.getVisibility() == 0) {
                    this.fNW.setProgress(this.fNW.getMax());
                } else {
                    this.fNW.setProgress((int) ((this.blk.getCurrentPosition() * this.fNW.getMax()) / duration));
                }
            }
        }
    }

    private void oj(int i2) {
        if (this.ehD != null && (this.ehD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ehD.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.ehD.setLayoutParams(layoutParams);
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

    public boolean aHv() {
        return !this.duQ;
    }

    public void a(g.a aVar) {
        this.fOb = aVar;
    }

    public void a(g.b bVar) {
        this.fOc = bVar;
    }

    public void aHw() {
        this.ehI.setImageResource(d.f.icon_video_play);
        this.dxP.setVisibility(8);
        this.ccQ.setVisibility(0);
        this.fNZ.setVisibility(8);
        this.fNY.setVisibility(8);
        this.fOa.setVisibility(8);
        this.amm = 2;
        this.blk.setRecoveryState(2);
    }

    public void d(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.blk != null) {
            this.blk.setPbLoadingTime(currentTimeMillis);
        }
        bP(str, str2);
    }

    public void bP(String str, String str2) {
        this.amm = 0;
        this.blk.setRecoveryState(0);
        bO(str, str2);
        this.blk.bQ(str, str2);
        this.blk.start();
        this.dxP.setVisibility(0);
        this.ehN.setVisibility(0);
        this.ccQ.setVisibility(8);
        this.ehI.setImageResource(d.f.icon_video_suspend_n);
        this.fNZ.setVisibility(8);
        this.fNY.setVisibility(8);
        this.fOa.setVisibility(8);
        this.ccU.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eiq);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.eiq, 60000L);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOs);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fOs, 10000L);
    }

    public void aHy() {
        this.amm = 1;
        this.blk.setRecoveryState(1);
        this.blk.start();
        this.ehI.setImageResource(d.f.icon_video_suspend_n);
        this.ehN.setVisibility(8);
        this.ehE.setVisibility(8);
        this.dxP.setVisibility(8);
        this.ehD.showProgress();
        this.ccQ.setVisibility(8);
        this.fNZ.setVisibility(8);
        this.fNY.setVisibility(8);
        this.fOa.setVisibility(8);
        biS();
    }

    public void biL() {
        if (com.baidu.adp.lib.util.j.hh() && this.fOq && !StringUtils.isNull(this.baH) && !StringUtils.isNull(this.aMR)) {
            this.fOq = false;
            this.fOr = true;
            bP(this.baH, this.aMR);
        }
    }

    public void lQ(boolean z) {
        if (this.blk != null) {
            this.blk.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.blk.isPlaying() && this.fOm) {
            biM();
        }
        biR();
        this.blk.pause();
        aHw();
    }

    public void stopPlay() {
        if (this.blk.isPlaying() && this.fOm) {
            biM();
        }
        this.amm = 5;
        this.blk.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eio);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eiq);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOs);
        this.blk.stopPlayback();
        this.ehS = false;
        this.ehW = 0;
        auN();
    }

    public void biM() {
        x.bjC().av(this.baH, this.blk.getCurrentPosition());
    }

    public void lR(boolean z) {
        this.fOm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.ehK != null) {
            this.ehE.setVisibility(0);
            this.ccQ.setVisibility(0);
            this.fNZ.setVisibility(8);
            this.fNY.setVisibility(8);
            this.fOa.setVisibility(8);
            this.dxP.setVisibility(8);
            this.ehI.setImageResource(d.f.icon_video_play);
            this.ehK.setVisibility(4);
            this.fNW.setVisibility(8);
            this.ccU.setVisibility(8);
            this.ehD.Mw();
            this.ehN.setVisibility(z ? 0 : 8);
        }
    }

    public void auN() {
        lS(true);
    }

    public boolean biN() {
        if (this.blk == null) {
            return false;
        }
        return this.blk.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.blk == null) {
            return 0;
        }
        return this.blk.getCurrentPosition();
    }

    public void a(i iVar) {
        this.fOh = iVar;
    }

    public void a(h hVar) {
        this.fOg = hVar;
    }

    public void a(g gVar) {
        this.fjy = gVar;
    }

    public void a(f fVar) {
        this.fOf = fVar;
    }

    public void qn(String str) {
        this.fjc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biO() {
        a(this.baH, this.aMR, (d) null);
    }

    public void b(InterfaceC0122c interfaceC0122c) {
        this.fOe = interfaceC0122c;
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fOk != null) {
                    this.fOk.fg(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.acd.getPageActivity());
                aVar.cS(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.biP();
                        c.this.bP(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lV(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.acd).tk();
                return;
            } else if (this.fOk != null) {
                this.fOk.fg(true);
                return;
            } else {
                if (!this.fNV) {
                    this.fNV = true;
                    com.baidu.adp.lib.util.l.showToast(this.acd.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                bP(str, str2);
                if (dVar != null) {
                    dVar.lV(true);
                    return;
                }
                return;
            }
        }
        bP(str, str2);
        if (dVar != null) {
            dVar.lV(true);
        }
        if (this.fOj != null) {
            this.fOj.amI();
        }
    }

    public void biP() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nP(String str) {
        this.ehN.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eiu);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eio);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eiq);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOt);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOs);
        this.bwX.stop();
        this.eil.unregister(this.acd.getPageActivity());
    }

    public void rm(String str) {
        this.ehR.setText(str);
    }

    public boolean aHz() {
        return this.ehS;
    }

    public void aHA() {
        if (this.ehK != null) {
            aHC();
            this.ehK.setVisibility(0);
            this.fNX.setVisibility(0);
            if (this.fOe != null) {
                this.fOe.fh(true);
            }
            this.fNW.setVisibility(8);
            this.cLd.setAnimationListener(this.eis);
            this.ehK.startAnimation(this.cLd);
            this.ehU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        if (this.ehK != null) {
            if (this.ehK.getVisibility() == 0) {
                aHC();
                this.ehK.setVisibility(8);
                this.fNW.setVisibility(0);
                if (this.fOe != null) {
                    this.fOe.amK();
                    return;
                }
                return;
            }
            aHD();
        }
    }

    public void aHB() {
        if (this.ehK != null) {
            aHC();
            this.ehK.setVisibility(0);
            this.fNX.setVisibility(0);
            if (this.fOe != null) {
                this.fOe.fh(false);
            }
            this.fNW.setVisibility(8);
            this.cLe.setAnimationListener(this.eit);
            this.ehK.startAnimation(this.cLe);
        }
    }

    public void biR() {
        if (this.ehK != null) {
            aHC();
            this.ehK.setVisibility(0);
            this.fNX.setVisibility(0);
            this.fNW.setVisibility(8);
            if (this.fOe != null) {
                this.fOe.fh(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHC() {
        if (this.ehK != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eiu);
            this.cLe.setAnimationListener(null);
            this.cLd.setAnimationListener(null);
            this.ehK.clearAnimation();
            this.ehU = false;
        }
    }

    public void aHD() {
        aHB();
        biS();
    }

    private void biS() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eiu);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.eiu, 3000L);
    }

    public void a(b bVar) {
        this.fOd = bVar;
    }

    public void ol(int i2) {
        if (this.blk.getDuration() - i2 <= 3000) {
            aHC();
            if (this.ehK != null) {
                this.ehK.setVisibility(0);
                this.fNX.setVisibility(0);
                this.fNW.setVisibility(8);
                if (this.fOe != null) {
                    this.fOe.fh(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.ehW = i2;
    }

    public void lT(boolean z) {
        if (this.bwX != null) {
            if (this.ehJ != null) {
                this.ehJ.setVisibility(z ? 0 : 8);
            }
            this.bwX.lX(z);
        }
    }

    public int bI(Context context) {
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

    public int biT() {
        return this.amm;
    }

    public void a(k kVar) {
        this.fOi = kVar;
    }

    public void a(j jVar) {
        this.fOj = jVar;
    }

    public void a(e eVar) {
        this.fOk = eVar;
    }

    public void lU(boolean z) {
        this.fOp = z;
    }
}
