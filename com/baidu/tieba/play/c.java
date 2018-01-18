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
    private static int eWY;
    private TbPageContext<?> aQp;
    private String bAT;
    private String bOE;
    private QuickVideoView bYH;
    private com.baidu.tieba.play.g cTu;
    private y cTz;
    private View cWm;
    private ImageView cWn;
    private View cWr;
    private p ckY;
    private Animation dEX;
    private Animation dEY;
    private View eWB;
    private TbImageView eWC;
    private g.f eWD;
    private ImageView eWF;
    private TextView eWG;
    private View eWL;
    private View eWM;
    private TextView eWN;
    private SeekBar eWO;
    private ImageView eWP;
    private ImageView eWQ;
    private int eWR;
    private int eWW;
    private int eWX;
    private CallStateReceiver eWZ;
    protected View eWq;
    private VideoListMediaControllerView eWs;
    private View eWt;
    private FrameLayout eWu;
    protected FrameLayout.LayoutParams eWv;
    private ImageView eWx;
    private ImageView eWy;
    private View eWz;
    private g fYY;
    private ProgressBar gqW;
    private View gqX;
    private View gqY;
    private TextView gqZ;
    private TextView gra;
    private TextView grb;
    private g.a grc;
    private g.b grd;
    private b grf;
    private InterfaceC0148c grg;
    private f grh;
    private h gri;
    private i grj;
    private k grk;
    private j grl;
    private e grm;
    private TextView grr;
    private boolean grt;
    private boolean gru;
    private boolean grv;
    private int grw;
    private boolean grx;
    private boolean gry;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean gqV = false;
    protected boolean ejw = false;
    private boolean eWH = false;
    private boolean eWJ = false;
    private boolean gre = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eWS = 0;
    private int eWT = 0;
    private boolean eXa = false;
    private boolean grn = true;
    private boolean gro = true;
    private boolean grp = false;
    private boolean grq = false;
    private String fYC = null;
    private int bak = -1;
    private boolean grs = false;
    private g.f bNn = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cTu = gVar;
            if (c.this.bjE()) {
                c.this.cTz.bkB();
                c.this.grx = true;
                return;
            }
            c.this.akj();
        }
    };
    private VideoLoadingProgressView.a cTJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.akj();
        }
    };
    private Runnable eXc = new Runnable() { // from class: com.baidu.tieba.play.c.15
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bYH.getCurrentPosition() > 100) {
                c.this.eWH = true;
                c.this.eWt.setVisibility(8);
                c.this.cWr.setVisibility(8);
                c.this.cTz.bkC();
                c.this.eWC.setVisibility(8);
                c.this.aOQ();
                if (c.this.bak == 1 || c.this.bak == 2) {
                    if (c.this.eWz != null) {
                        c.this.eWz.setVisibility(0);
                        c.this.gqY.setVisibility(0);
                        c.this.gqW.setVisibility(8);
                        if (c.this.grg != null) {
                            c.this.grg.fS(false);
                        }
                    }
                    c.this.eWs.showProgress();
                    c.this.aOR();
                }
                if (c.this.eWD != null) {
                    c.this.eWD.onPrepared(c.this.bYH.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eXc, 20L);
        }
    };
    private g.a bNm = new g.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eWH = false;
            c.this.grv = false;
            c.this.mStartPosition = 0;
            c.this.aOy();
            c.this.eWt.setVisibility(0);
            c.this.gqW.setVisibility(8);
            c.this.gqW.setProgress(c.this.gqW.getMax());
            if (c.this.grg != null) {
                c.this.grg.fS(false);
            }
            if (c.this.ejw) {
                c.this.eWz.setVisibility(0);
                c.this.eWF.setVisibility(0);
                c.this.eWG.setVisibility(0);
                c.this.gqY.setVisibility(8);
            } else {
                c.this.eWz.setVisibility(8);
                c.this.eWF.setVisibility(8);
                c.this.eWG.setVisibility(8);
                c.this.gqY.setVisibility(8);
            }
            if (c.this.bYH == null || c.this.bYH.getDuration() > 150000) {
                c.this.lz(false);
            } else {
                c.this.gqZ.setVisibility(0);
            }
            z.bkH().remove(c.this.bOE);
            if (c.this.grc != null) {
                c.this.grc.onCompletion(gVar);
            }
            c.this.bak = 3;
            c.this.bYH.setRecoveryState(3);
            if (!c.this.ejw && c.this.bYH != null && c.this.bYH.getDuration() <= 150000) {
                if (!c.this.grs) {
                    if (c.this.gri != null) {
                        c.this.gri.kZ(true);
                    }
                    c.this.bM(c.this.bOE, c.this.bAT);
                    return;
                }
                c.this.bak = 5;
                c.this.bYH.setRecoveryState(5);
                c.this.bYH.getPlayer().pause();
                c.this.bYH.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eXd = new g.b() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cWr.setVisibility(0);
            c.this.cTz.bkD();
            c.this.bak = 4;
            c.this.bYH.setRecoveryState(4);
            if (c.this.grd != null) {
                c.this.grd.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.oI()) {
                c.this.grt = true;
            }
            c.this.grv = false;
            return true;
        }
    };
    private Runnable eXe = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            c.this.cWr.setVisibility(0);
            c.this.cTz.bkD();
        }
    };
    private g.InterfaceC0149g bNr = new g.InterfaceC0149g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0149g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.grp) {
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.grz, 200L);
            }
        }
    };
    private Runnable grz = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bYH == null || !c.this.grp) {
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eXc, 200L);
                c.this.grp = false;
            } else if (c.this.mStartPosition != c.this.bYH.getCurrentPosition()) {
                c.this.grp = false;
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eXc, 20L);
            } else {
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.grz, 200L);
            }
        }
    };
    private QuickVideoView.b bYO = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eWH = false;
            c.this.grv = false;
            com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eXc);
            com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eXe);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cWr.getId()) {
                c.this.bjJ();
            } else if (view.getId() != c.this.cWn.getId() && view.getId() != c.this.eWx.getId()) {
                if (view.getId() == c.this.gra.getId()) {
                    if (c.this.grh != null) {
                        c.this.grh.bfU();
                    }
                } else if (view.getId() == c.this.gqZ.getId()) {
                    if (c.this.gri != null) {
                        c.this.gri.kZ(false);
                    }
                    c.this.bM(c.this.bOE, c.this.bAT);
                } else if (view.getId() != c.this.eWy.getId() && view.getId() != c.this.gqX.getId()) {
                    if (view.getId() == c.this.eWF.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.grl != null) {
                            c.this.grl.avC();
                        }
                        c.this.aOC();
                    }
                } else {
                    if (c.this.ejw) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.grl != null) {
                        c.this.grl.avC();
                    }
                    c.this.aOC();
                }
            } else {
                c.this.bfL();
            }
        }
    };
    private Animation.AnimationListener eXg = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eWz != null) {
                c.this.eWz.setVisibility(8);
                c.this.gqW.setVisibility(0);
                c.this.eWJ = false;
                if (c.this.grg != null) {
                    c.this.grg.avD();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eXh = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable eXi = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aOO();
        }
    };
    private CustomMessageListener eXj = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private v.b eZU = new v.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.v.b
        public void js(int i2) {
            int duration;
            if (c.this.bYH != null && (duration = c.this.bYH.getDuration()) > 0 && c.this.gqW != null) {
                c.this.gqW.setProgress((int) ((i2 * c.this.eWq.getWidth()) / duration));
            }
            c.this.rd(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bRw = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eWJ) {
                c.this.aOR();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aON() && c.this.aOD() != null) {
                c.this.setStartPosition(c.this.aOD().getSeekPosition());
                c.this.bM(c.this.bOE, c.this.bAT);
            }
        }
    };
    private QuickVideoView.a grA = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bjP() {
            if (!c.this.grs) {
                c.this.cTz.startLoading();
                c.this.eWC.setVisibility(0);
                c.this.cWn.setVisibility(8);
                c.this.eWx.setImageResource(d.f.icon_video_suspend_n);
                c.this.gra.setVisibility(8);
                c.this.gqZ.setVisibility(8);
                c.this.grb.setVisibility(8);
                c.this.cWr.setVisibility(8);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eXe);
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eXe, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void avA();

        void avz();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0148c {
        void avD();

        void fS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lD(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void bfU();
    }

    /* loaded from: classes.dex */
    public interface g {
        void avE();
    }

    /* loaded from: classes.dex */
    public interface h {
        void kZ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void avB();

        void avC();
    }

    /* loaded from: classes.dex */
    public interface k {
        void bfV();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eWW = 0;
        this.gry = true;
        if (tbPageContext != null) {
            this.aQp = tbPageContext;
            this.eWq = o(tbPageContext);
            this.mRootView = view;
            this.gry = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eWq);
            }
            this.eWB = view;
            this.eWq.setOnClickListener(this.mOnClickListener);
            this.bYH = (QuickVideoView) this.eWq.findViewById(d.g.videoView);
            this.cTz = new y((ViewGroup) this.eWq.findViewById(d.g.auto_video_loading_container));
            this.cTz.setLoadingAnimationListener(this.cTJ);
            this.eWs = (VideoListMediaControllerView) this.eWq.findViewById(d.g.media_controller);
            this.eWs.setPlayer(this.bYH);
            this.gqW = (ProgressBar) this.eWq.findViewById(d.g.pgrBottomProgress);
            this.gqW.setMax(com.baidu.adp.lib.util.l.ao(this.aQp.getPageActivity()));
            this.gqW.setProgress(0);
            this.eWs.setOnSeekBarChangeListener(this.bRw);
            this.eWs.setOnProgressUpdatedListener(this.eZU);
            this.eWt = this.eWq.findViewById(d.g.black_mask);
            this.cWr = this.eWq.findViewById(d.g.layout_error);
            this.cWr.setOnClickListener(this.mOnClickListener);
            this.grr = (TextView) this.eWq.findViewById(d.g.auto_video_error_tips);
            this.eWu = (FrameLayout) this.eWq.findViewById(d.g.danmu_container);
            this.eWx = (ImageView) this.eWq.findViewById(d.g.img_play_icon);
            this.eWx.setOnClickListener(this.mOnClickListener);
            this.eWy = (ImageView) this.eWq.findViewById(d.g.img_full_screen);
            this.eWy.setOnClickListener(this.mOnClickListener);
            this.gqX = this.eWq.findViewById(d.g.full_screen_container);
            this.gqX.setOnClickListener(this.mOnClickListener);
            this.eWz = this.eWq.findViewById(d.g.layout_media_controller);
            this.gqY = this.eWq.findViewById(d.g.time_show_controller);
            this.bYH.setOnPreparedListener(this.bNn);
            this.bYH.setOnCompletionListener(this.bNm);
            this.bYH.setOnErrorListener(this.eXd);
            this.bYH.setOnSeekCompleteListener(this.bNr);
            this.bYH.setOnSurfaceDestroyedListener(this.bYO);
            this.bYH.setOnRecoveryCallback(this.grA);
            this.cWn = (ImageView) this.eWq.findViewById(d.g.img_play);
            this.cWn.setOnClickListener(this.mOnClickListener);
            this.gqZ = (TextView) this.eWq.findViewById(d.g.txt_replay);
            this.gqZ.setOnClickListener(this.mOnClickListener);
            this.gra = (TextView) this.eWq.findViewById(d.g.txt_playnext);
            this.gra.setOnClickListener(this.mOnClickListener);
            this.grb = (TextView) this.eWq.findViewById(d.g.txt_next_video_title);
            this.eWC = (TbImageView) this.eWq.findViewById(d.g.video_thumbnail);
            this.eWC.setDefaultErrorResource(0);
            this.eWC.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.aQp.getPageActivity());
            this.mScreenHeight = bQ(this.aQp.getPageActivity());
            this.eWF = (ImageView) this.eWq.findViewById(d.g.img_exit);
            this.eWF.setOnClickListener(this.mOnClickListener);
            this.eWG = (TextView) this.eWq.findViewById(d.g.video_title);
            this.cWm = this.eWq.findViewById(d.g.layout_title);
            this.cWm.setVisibility(8);
            this.dEX = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dEY = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aQp.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eWR = this.mAudioManager.getStreamMaxVolume(3);
            this.eWX = this.mAudioManager.getStreamVolume(3);
            eWY = 100 / this.eWR;
            this.eWq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.grj != null) {
                        c.this.grj.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eWH) {
                            if (c.this.mStatus == 1 && c.this.eWT != 0) {
                                c.this.b(c.this.eWT == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eWT = 0;
                                c.this.eWS = 0;
                            }
                            if (!c.this.bYH.isPlaying() && 8 == c.this.cWn.getVisibility()) {
                                c.this.cWn.setVisibility(0);
                                c.this.gra.setVisibility(8);
                                c.this.gqZ.setVisibility(8);
                                c.this.grb.setVisibility(8);
                            }
                        }
                        c.this.aOy();
                        if (c.this.grj != null) {
                            c.this.grj.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.ckY = new p(this.aQp.getPageActivity());
            if (this.gry) {
                this.ckY.start();
            }
            this.eWW = com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.ds16);
            this.eWZ = new CallStateReceiver();
            this.eWZ.register(this.aQp.getPageActivity());
            this.aQp.registerListener(this.eXj);
            bjD();
        }
    }

    public void bjD() {
        if (this.grn) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eWq.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eWq.setSystemUiVisibility(0);
    }

    public void lw(boolean z) {
        this.grn = z;
        bjD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOy() {
        this.mStatus = 0;
        if (this.eWL != null && this.eWL.getParent() != null && (this.eWL.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eWL.getParent()).removeView(this.eWL);
                this.eWL = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eWM != null && this.eWM.getParent() != null && (this.eWM.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eWM.getParent()).removeView(this.eWM);
                this.eWM = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aOz() {
        if (this.mStatus == 1) {
            if (this.eWL == null && this.eWq != null && (this.eWq instanceof ViewGroup)) {
                LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.eWq, true);
                this.eWL = this.eWq.findViewById(d.g.lay_jindu);
                this.eWN = (TextView) this.eWL.findViewById(d.g.show_time);
                this.eWQ = (ImageView) this.eWL.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eWM == null && this.eWq != null && (this.eWq instanceof ViewGroup)) {
            LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.eWq, true);
            this.eWM = this.eWq.findViewById(d.g.lay_voice);
            this.eWP = (ImageView) this.eWM.findViewById(d.g.arrow_voice_icon);
            this.eWO = (SeekBar) this.eWM.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.grj != null) {
                c.this.grj.onStart();
            }
            if (c.this.ejw && c.this.eWH) {
                if (!c.this.bYH.isPlaying() && c.this.cWn.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cWn.setVisibility(8);
                    c.this.gra.setVisibility(8);
                    c.this.gqZ.setVisibility(8);
                    c.this.grb.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.al(f2);
                    }
                } else {
                    if (c.this.ejw) {
                        c.this.aOB();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eWS = c.this.bYH.getCurrentPosition();
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
            if (c.this.grk != null) {
                c.this.grk.bfV();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eWH) {
                if (c.this.bak != 2) {
                    c.this.bjL();
                } else {
                    c.this.bfL();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eWq.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eWq.setSystemUiVisibility(4);
        } else {
            this.eWq.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f2) {
        if (!this.eWH) {
            this.mStatus = 0;
            return;
        }
        aOz();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eWY == 0) {
            if (f2 > 0.0f && this.eWX < this.eWR) {
                this.eWX++;
            }
            if (f2 < 0.0f && this.eWX > 0) {
                this.eWX--;
            }
        }
        if (this.mProgress > 0) {
            this.eWP.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eWP.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eWX, 0);
        this.eWO.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eWS += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eWT = 1;
            } else {
                this.eWS += 1000;
                this.eWT = 2;
            }
            if (this.eWS < 0) {
                this.eWS = 0;
            } else if (this.eWS > this.bYH.getDuration()) {
                this.eWS = this.bYH.getDuration();
            }
        }
        aOz();
        String tV = this.eWs.tV(this.eWS);
        if (f2 > 0.0f) {
            this.eWQ.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eWQ.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(tV)) {
            this.eWN.setText(new StringBuilder().append(tV).append("/").append(this.eWs.tV(this.bYH.getDuration())));
        }
        this.eWs.L(this.eWS, z ? false : true);
        this.eWz.setVisibility(8);
        this.gqW.setVisibility(0);
        bjF();
    }

    protected View o(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bL(String str, String str2) {
        this.bOE = str;
        this.bAT = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjE() {
        if (this.gre) {
            return this.grw == 0 && !this.grx;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        if (this.bYH != null && this.cTu != null) {
            if (this.grv) {
                this.bYH.start();
                this.grv = false;
            }
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXc);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.eXc, 20L);
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
            if (this.bYH.bkg()) {
                this.bak = 1;
                this.bYH.setRecoveryState(1);
            }
            if (this.cTu != null && this.eWs != null) {
                this.mStartPosition = z.bkH().qX(this.bOE);
                this.eWs.aU(this.mStartPosition, this.cTu.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bYH != null) {
                        this.bYH.tU(this.mStartPosition);
                    } else {
                        this.cTu.seekTo(this.mStartPosition);
                    }
                    if (!this.gru) {
                        this.eWs.showProgress();
                        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXc);
                    }
                    this.grp = true;
                }
            }
        }
    }

    public void bfL() {
        if (!com.baidu.adp.lib.util.j.oI()) {
            com.baidu.adp.lib.util.l.J(this.aQp.getPageActivity(), this.aQp.getString(d.j.neterror));
        } else if (this.bYH.isPlaying()) {
            pausePlay();
        } else if (this.eWH) {
            aOM();
            if (this.fYY != null) {
                this.fYY.avE();
            }
        } else {
            bjJ();
        }
    }

    public void aOC() {
        this.eXa = true;
        if (this.ckY != null) {
            this.ckY.aOC();
        }
    }

    public boolean tR(int i2) {
        switch (i2) {
            case 4:
                if (this.ejw) {
                    aOC();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eWR <= 0 || this.eWO == null) {
                    return false;
                }
                this.eWX = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eWX * 100.0d) / this.eWR);
                this.eWO.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bYH;
    }

    public VideoListMediaControllerView aOD() {
        return this.eWs;
    }

    public void show() {
        this.eWq.setVisibility(0);
    }

    public void aOH() {
        if (this.eWB != null) {
            ViewGroup.LayoutParams layoutParams = this.eWB.getLayoutParams();
            this.eWv = (FrameLayout.LayoutParams) this.eWq.getLayoutParams();
            this.eWv.width = layoutParams.width;
            this.eWv.height = layoutParams.height;
            this.eWv.topMargin = 0;
            this.eWq.setLayoutParams(this.eWv);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eXa) {
            if (this.ejw) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.eXa = false;
        }
        if (configuration.orientation == 2) {
            this.ejw = true;
            this.eWq.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.eWz.setVisibility(0);
            this.cWm.setVisibility(0);
            this.eWF.setVisibility(0);
            this.eWG.setVisibility(0);
            this.eWu.setVisibility(8);
            if (this.gre) {
                this.cTz.startLoading();
                this.eWC.setVisibility(0);
            } else {
                this.cTz.bkD();
                this.eWC.setVisibility(8);
            }
            if (this.grf != null) {
                this.grf.avz();
            }
            this.eWy.setImageResource(d.f.icon_video_window);
            rb(this.eWW);
            aOB();
        } else {
            this.ejw = false;
            if (this.eWv != null) {
                this.eWq.setLayoutParams(this.eWv);
            }
            a(tbPageContext, false);
            this.cWm.setVisibility(8);
            this.eWu.setVisibility(0);
            if (this.gre) {
                this.cTz.startLoading();
                this.eWC.setVisibility(0);
            } else {
                this.cTz.bkD();
                this.eWC.setVisibility(8);
            }
            if (this.grf != null) {
                this.grf.avA();
            }
            if (this.bak == 3 && this.grg != null) {
                this.grg.fS(false);
            } else if (!this.eWH && this.eWz != null) {
                this.eWz.clearAnimation();
                this.eWz.setVisibility(4);
                this.gqW.setVisibility(0);
                if (this.grg != null) {
                    this.grg.avD();
                }
            }
            aOy();
            this.eWy.setImageResource(d.f.icon_video_fullscreen);
            if (this.eWs != null && (this.eWs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWs.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.tbds24);
                layoutParams.rightMargin = 0;
                this.eWs.setLayoutParams(layoutParams);
            }
            this.eWq.setSystemUiVisibility(0);
            bjD();
        }
        if (this.bYH.isPlaying()) {
            aOR();
        }
        bjF();
    }

    public void bjF() {
        if (this.bYH != null) {
            int ao = com.baidu.adp.lib.util.l.ao(this.aQp.getPageActivity());
            if (this.ejw) {
                ao = com.baidu.adp.lib.util.l.aq(this.aQp.getPageActivity());
            }
            this.gqW.setMax(ao);
            int duration = this.bYH.getDuration();
            if (duration > 0) {
                if (this.gqZ.getVisibility() == 0) {
                    this.gqW.setProgress(this.gqW.getMax());
                } else {
                    this.gqW.setProgress((int) ((this.bYH.getCurrentPosition() * this.gqW.getMax()) / duration));
                }
            }
        }
    }

    private void rb(int i2) {
        if (this.eWs != null && (this.eWs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWs.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eWs.setLayoutParams(layoutParams);
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

    public boolean aOJ() {
        return !this.ejw;
    }

    public void a(g.f fVar) {
        this.eWD = fVar;
    }

    public void a(g.a aVar) {
        this.grc = aVar;
    }

    public void a(g.b bVar) {
        this.grd = bVar;
    }

    public void aOK() {
        this.eWx.setImageResource(d.f.icon_video_play);
        this.cTz.bkD();
        this.cWn.setVisibility(0);
        this.gra.setVisibility(8);
        this.gqZ.setVisibility(8);
        this.grb.setVisibility(8);
        this.bak = 2;
        this.bYH.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bYH != null) {
            this.bYH.setPbLoadingTime(currentTimeMillis);
        }
        bM(str, str2);
    }

    public void bM(String str, String str2) {
        this.grv = true;
        this.bak = 0;
        this.bYH.setRecoveryState(0);
        bL(str, str2);
        this.bYH.bO(str, str2);
        this.cTz.startLoading();
        this.eWC.setVisibility(0);
        this.cWn.setVisibility(8);
        this.eWx.setImageResource(d.f.icon_video_suspend_n);
        this.gra.setVisibility(8);
        this.gqZ.setVisibility(8);
        this.grb.setVisibility(8);
        this.cWr.setVisibility(8);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.eXe, 60000L);
    }

    public void bN(String str, String str2) {
        this.grv = true;
        this.bak = 0;
        this.bYH.setRecoveryState(0);
        this.cTz.startLoading();
        this.eWC.setVisibility(0);
        this.cWn.setVisibility(8);
        this.eWx.setImageResource(d.f.icon_video_suspend_n);
        this.gra.setVisibility(8);
        this.gqZ.setVisibility(8);
        this.grb.setVisibility(8);
        this.cWr.setVisibility(8);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.eXe, 60000L);
    }

    public void aOM() {
        this.bak = 1;
        this.bYH.setRecoveryState(1);
        this.bYH.start();
        this.eWx.setImageResource(d.f.icon_video_suspend_n);
        this.eWC.setVisibility(8);
        this.eWt.setVisibility(8);
        this.cTz.bkD();
        this.eWs.showProgress();
        this.cWn.setVisibility(8);
        this.gra.setVisibility(8);
        this.gqZ.setVisibility(8);
        this.grb.setVisibility(8);
        bjN();
    }

    public void bjG() {
        if (com.baidu.adp.lib.util.j.oI() && this.grt && !StringUtils.isNull(this.bOE) && !StringUtils.isNull(this.bAT)) {
            this.grt = false;
            this.gru = true;
            bM(this.bOE, this.bAT);
        }
    }

    public void lx(boolean z) {
        if (this.bYH != null) {
            this.bYH.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bYH.isPlaying() && this.gro) {
            bjH();
        }
        bjM();
        this.bYH.pause();
        aOK();
    }

    public void stopPlay() {
        if (this.bYH.isPlaying() && this.gro) {
            bjH();
        }
        this.bak = 5;
        this.bYH.setRecoveryState(5);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXc);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
        this.bYH.stopPlayback();
        this.eWH = false;
        this.grv = false;
        this.mStartPosition = 0;
        aCd();
    }

    public void bjH() {
        z.bkH().aA(this.bOE, this.bYH.getCurrentPosition());
    }

    public void ly(boolean z) {
        this.gro = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(boolean z) {
        if (this.eWz != null) {
            this.eWt.setVisibility(0);
            this.cWn.setVisibility(0);
            this.gra.setVisibility(8);
            this.gqZ.setVisibility(8);
            this.grb.setVisibility(8);
            this.cTz.bkD();
            this.eWx.setImageResource(d.f.icon_video_play);
            this.eWz.setVisibility(4);
            this.gqW.setVisibility(8);
            this.cWr.setVisibility(8);
            this.eWs.TJ();
            this.eWC.setVisibility(z ? 0 : 8);
        }
    }

    public void aCd() {
        lz(true);
    }

    public boolean bjI() {
        if (this.bYH == null) {
            return false;
        }
        return this.bYH.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bYH == null) {
            return 0;
        }
        return this.bYH.getCurrentPosition();
    }

    public void a(i iVar) {
        this.grj = iVar;
    }

    public void a(h hVar) {
        this.gri = hVar;
    }

    public void a(g gVar) {
        this.fYY = gVar;
    }

    public void a(f fVar) {
        this.grh = fVar;
    }

    public void qA(String str) {
        this.fYC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjJ() {
        a(this.bOE, this.bAT, null, new Object[0]);
    }

    public void b(InterfaceC0148c interfaceC0148c) {
        this.grg = interfaceC0148c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        if (com.baidu.adp.lib.util.j.oK()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.grq = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.grm != null) {
                    this.grm.fR(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQp.getPageActivity());
                aVar.cZ(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bjK();
                        if (c.this.grq) {
                            c.this.bN(str, str2);
                        } else {
                            c.this.bM(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lD(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aQp).AA();
                return;
            } else if (this.grm != null) {
                this.grm.fR(true);
                return;
            } else {
                if (!this.gqV) {
                    this.gqV = true;
                    com.baidu.adp.lib.util.l.showToast(this.aQp.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                if (this.grq) {
                    bN(str, str2);
                } else {
                    bM(str, str2);
                }
                if (dVar != null) {
                    dVar.lD(true);
                    return;
                }
                return;
            }
        }
        if (this.grq) {
            bN(str, str2);
        } else {
            bM(str, str2);
        }
        if (dVar != null) {
            dVar.lD(true);
        }
        if (this.grl != null) {
            this.grl.avB();
        }
    }

    public void bjK() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void ob(String str) {
        this.eWC.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXi);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXc);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.grz);
        this.ckY.stop();
        this.eWZ.unregister(this.aQp.getPageActivity());
    }

    public void qS(String str) {
        this.eWG.setText(str);
    }

    public boolean aON() {
        return this.eWH;
    }

    public void aOO() {
        if (this.eWz != null) {
            aOQ();
            this.eWz.setVisibility(0);
            this.gqY.setVisibility(0);
            if (this.grg != null) {
                this.grg.fS(true);
            }
            this.gqW.setVisibility(8);
            this.dEX.setAnimationListener(this.eXg);
            this.eWz.startAnimation(this.dEX);
            this.eWJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjL() {
        if (this.eWz != null) {
            if (this.eWz.getVisibility() == 0) {
                aOQ();
                this.eWz.setVisibility(8);
                this.gqW.setVisibility(0);
                if (this.grg != null) {
                    this.grg.avD();
                    return;
                }
                return;
            }
            aOR();
        }
    }

    public void aOP() {
        if (this.eWz != null) {
            aOQ();
            this.eWz.setVisibility(0);
            this.gqY.setVisibility(0);
            if (this.grg != null) {
                this.grg.fS(false);
            }
            this.gqW.setVisibility(8);
            this.dEY.setAnimationListener(this.eXh);
            this.eWz.startAnimation(this.dEY);
        }
    }

    public void bjM() {
        if (this.eWz != null) {
            aOQ();
            this.eWz.setVisibility(0);
            this.gqY.setVisibility(0);
            this.gqW.setVisibility(8);
            if (this.grg != null) {
                this.grg.fS(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOQ() {
        if (this.eWz != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXi);
            this.dEY.setAnimationListener(null);
            this.dEX.setAnimationListener(null);
            this.eWz.clearAnimation();
            this.eWJ = false;
        }
    }

    public void aOR() {
        aOP();
        bjN();
    }

    private void bjN() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXi);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.eXi, 3000L);
    }

    public void a(b bVar) {
        this.grf = bVar;
    }

    public void rd(int i2) {
        if (this.bYH.getDuration() - i2 <= 3000) {
            aOQ();
            if (this.eWz != null) {
                this.eWz.setVisibility(0);
                this.gqY.setVisibility(0);
                this.gqW.setVisibility(8);
                if (this.grg != null) {
                    this.grg.fS(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void lA(boolean z) {
        if (this.ckY != null) {
            if (this.eWy != null || this.gqX != null) {
                this.eWy.setVisibility(z ? 0 : 8);
                this.gqX.setVisibility(z ? 0 : 8);
            }
            if (!z && this.eWs != null && (this.eWs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eWs.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.tbds52);
                this.eWs.setLayoutParams(layoutParams);
            }
            this.ckY.lF(z);
        }
    }

    public int bQ(Context context) {
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

    public int bjO() {
        return this.bak;
    }

    public void a(k kVar) {
        this.grk = kVar;
    }

    public void a(j jVar) {
        this.grl = jVar;
    }

    public void a(e eVar) {
        this.grm = eVar;
    }

    public void lB(boolean z) {
        this.grs = z;
    }

    public void lC(boolean z) {
        this.gre = z;
    }

    public void tS(int i2) {
        this.grw = i2;
    }
}
