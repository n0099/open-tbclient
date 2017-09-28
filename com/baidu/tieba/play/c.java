package com.baidu.tieba.play;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.t;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int dUQ;
    private String aXr;
    private TbPageContext<?> abz;
    private QuickVideoView bMO;
    private View bMQ;
    private ImageView bMR;
    private View bMV;
    private p bpi;
    private Animation cuv;
    private Animation cuw;
    private String cyX;
    private View dUD;
    private View dUE;
    private TextView dUF;
    private SeekBar dUG;
    private ImageView dUH;
    private ImageView dUI;
    private int dUJ;
    private int dUO;
    private int dUP;
    private CallStateReceiver dUR;
    protected View dUh;
    private VideoListMediaControllerView dUj;
    private View dUk;
    private FrameLayout dUl;
    protected FrameLayout.LayoutParams dUm;
    private ImageView dUo;
    private ImageView dUp;
    private View dUq;
    private View dUs;
    private TbImageView dUt;
    private g.f dUu;
    private ImageView dUw;
    private TextView dUx;
    private View dih;
    private g eTN;
    private TextView fwA;
    private TextView fwB;
    private g.a fwC;
    private g.b fwD;
    private b fwE;
    private InterfaceC0120c fwF;
    private f fwG;
    private h fwH;
    private i fwI;
    private k fwJ;
    private j fwK;
    private e fwL;
    private TextView fwP;
    private TextView fwv;
    private View fww;
    private ProgressBar fwx;
    private View fwy;
    private TextView fwz;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fwu = false;
    protected boolean dfh = false;
    private boolean dUy = false;
    private boolean dUA = false;
    private int dUC = 0;
    private int mStatus = 0;
    private int dUK = 0;
    private int dUL = 0;
    private boolean dUS = false;
    private boolean fwM = true;
    private boolean fwN = true;
    private boolean fwO = false;
    private String eTu = null;
    private int alH = -1;
    private g.f aWe = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUU);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUU, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUW);
            if (c.this.bMO.beo()) {
                c.this.alH = 1;
                c.this.bMO.setRecoveryState(1);
            }
            if (gVar != null && c.this.dUj != null) {
                c.this.dUC = w.beE().qn(c.this.aXr);
                c.this.dUj.W(c.this.dUC, gVar.getDuration());
                if (c.this.dUC != 0) {
                    gVar.seekTo(c.this.dUC);
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUU);
                    c.this.fwO = true;
                }
            }
        }
    };
    private Runnable dUU = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMO.getCurrentPosition() > 100) {
                c.this.dUy = true;
                c.this.dUk.setVisibility(8);
                c.this.bMV.setVisibility(8);
                c.this.dih.setVisibility(8);
                c.this.fww.setVisibility(8);
                c.this.dUt.setVisibility(8);
                c.this.aEA();
                if (c.this.alH == 1 || c.this.alH == 2) {
                    if (c.this.dUq != null) {
                        c.this.dUq.setVisibility(0);
                        c.this.fwy.setVisibility(0);
                        c.this.fwx.setVisibility(8);
                        if (c.this.fwF != null) {
                            c.this.fwF.eQ(false);
                        }
                    }
                    c.this.dUj.showProgress();
                    c.this.aEB();
                }
                if (c.this.dUu != null) {
                    c.this.dUu.onPrepared(c.this.bMO.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUU, 20L);
        }
    };
    private g.a aWd = new g.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.dUy = false;
            c.this.dUC = 0;
            c.this.aEi();
            c.this.dUk.setVisibility(0);
            c.this.fwx.setVisibility(8);
            c.this.fwx.setProgress(c.this.fwx.getMax());
            if (c.this.fwF != null) {
                c.this.fwF.eQ(false);
            }
            if (c.this.dfh) {
                c.this.dUq.setVisibility(0);
                c.this.dUw.setVisibility(0);
                c.this.dUx.setVisibility(0);
                c.this.fwy.setVisibility(8);
            } else {
                c.this.dUq.setVisibility(8);
                c.this.dUw.setVisibility(8);
                c.this.dUx.setVisibility(8);
                c.this.fwy.setVisibility(8);
            }
            if (c.this.bMO == null || c.this.bMO.getDuration() > 150000) {
                c.this.lu(false);
            } else {
                c.this.fwz.setVisibility(0);
            }
            w.beE().remove(c.this.aXr);
            if (c.this.fwC != null) {
                c.this.fwC.onCompletion(gVar);
            }
            c.this.alH = 3;
            c.this.bMO.setRecoveryState(3);
            if (!c.this.dfh && c.this.bMO != null && c.this.bMO.getDuration() <= 150000) {
                if (c.this.fwH != null) {
                    c.this.fwH.eR(true);
                }
                c.this.bP(c.this.aXr, c.this.cyX);
            }
        }
    };
    private g.b dUV = new g.b() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.bMV.setVisibility(0);
            c.this.dih.setVisibility(8);
            c.this.fww.setVisibility(8);
            c.this.alH = 4;
            c.this.bMO.setRecoveryState(4);
            if (c.this.fwD != null) {
                c.this.fwD.onError(gVar, i2, i3);
                return true;
            }
            return true;
        }
    };
    private Runnable dUW = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMO == null || !c.this.bMO.bep()) {
                c.this.bMV.setVisibility(0);
                c.this.dih.setVisibility(8);
                c.this.fww.setVisibility(8);
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUW, 60000L);
        }
    };
    private g.InterfaceC0121g aWi = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.InterfaceC0121g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fwO) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fwQ, 200L);
            }
        }
    };
    private Runnable fwQ = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMO == null || !c.this.fwO) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUU, 200L);
                c.this.fwO = false;
            } else if (c.this.dUC != c.this.bMO.getCurrentPosition()) {
                c.this.fwO = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUU, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fwQ, 200L);
            }
        }
    };
    private QuickVideoView.b bKW = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dUy = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUU);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUW);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bMV.getId()) {
                c.this.beb();
            } else if (view.getId() != c.this.bMR.getId() && view.getId() != c.this.dUo.getId()) {
                if (view.getId() == c.this.fwA.getId()) {
                    if (c.this.fwG != null) {
                        c.this.fwG.aUs();
                    }
                } else if (view.getId() == c.this.fwz.getId()) {
                    if (c.this.fwH != null) {
                        c.this.fwH.eR(false);
                    }
                    c.this.bP(c.this.aXr, c.this.cyX);
                } else if (view.getId() != c.this.dUp.getId()) {
                    if (view.getId() == c.this.dUw.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fwK != null) {
                            c.this.fwK.aiw();
                        }
                        c.this.aEm();
                    }
                } else {
                    if (c.this.dfh) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fwK != null) {
                        c.this.fwK.aiw();
                    }
                    c.this.aEm();
                }
            } else {
                c.this.aUi();
            }
        }
    };
    private Animation.AnimationListener dUY = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.5
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dUq != null) {
                c.this.dUq.setVisibility(8);
                c.this.fwx.setVisibility(0);
                c.this.dUA = false;
                if (c.this.fwF != null) {
                    c.this.fwF.aix();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dUZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
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
    private Runnable dVa = new Runnable() { // from class: com.baidu.tieba.play.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.aEy();
        }
    };
    private CustomMessageListener dVb = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private t.b dXM = new t.b() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.t.b
        public void gf(int i2) {
            int duration;
            if (c.this.bMO != null && (duration = c.this.bMO.getDuration()) > 0 && c.this.fwx != null) {
                c.this.fwx.setProgress((int) ((i2 * c.this.dUh.getWidth()) / duration));
            }
            c.this.nJ(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bac = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.dUA) {
                c.this.aEB();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aEx() && c.this.aEn() != null) {
                c.this.setStartPosition(c.this.aEn().getSeekPosition());
                c.this.bP(c.this.aXr, c.this.cyX);
            }
        }
    };
    private QuickVideoView.a fwR = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void beh() {
            c.this.dih.setVisibility(0);
            if (c.this.dfh) {
                c.this.fww.setVisibility(8);
            } else {
                c.this.fww.setVisibility(0);
            }
            c.this.dUt.setVisibility(0);
            c.this.bMR.setVisibility(8);
            c.this.dUo.setImageResource(d.g.icon_video_midplay);
            c.this.fwA.setVisibility(8);
            c.this.fwz.setVisibility(8);
            c.this.fwB.setVisibility(8);
            c.this.bMV.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUW);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUW, 60000L);
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void ait();

        void aiu();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0120c {
        void aix();

        void eQ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void jX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aUs();
    }

    /* loaded from: classes.dex */
    public interface g {
        void aiy();
    }

    /* loaded from: classes.dex */
    public interface h {
        void eR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void aiv();

        void aiw();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aUr();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dUO = 0;
        if (tbPageContext != null) {
            this.abz = tbPageContext;
            this.dUh = q(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dUh);
            }
            this.dUs = view;
            this.dUh.setOnClickListener(this.mOnClickListener);
            this.bMO = (QuickVideoView) this.dUh.findViewById(d.h.videoView);
            this.dih = this.dUh.findViewById(d.h.video_list_layout_loading);
            this.fww = this.dUh.findViewById(d.h.layout_play_count);
            this.fwv = (TextView) this.dUh.findViewById(d.h.play_count);
            this.dUj = (VideoListMediaControllerView) this.dUh.findViewById(d.h.media_controller);
            this.dUj.setPlayer(this.bMO);
            this.fwx = (ProgressBar) this.dUh.findViewById(d.h.pgrBottomProgress);
            this.fwx.setMax(com.baidu.adp.lib.util.l.ad(this.abz.getPageActivity()));
            this.fwx.setProgress(0);
            this.dUj.setOnSeekBarChangeListener(this.bac);
            this.dUj.setOnProgressUpdatedListener(this.dXM);
            this.dUk = this.dUh.findViewById(d.h.black_mask);
            this.bMV = this.dUh.findViewById(d.h.layout_error);
            this.bMV.setOnClickListener(this.mOnClickListener);
            this.fwP = (TextView) this.dUh.findViewById(d.h.auto_video_error_tips);
            this.dUl = (FrameLayout) this.dUh.findViewById(d.h.danmu_container);
            this.dUo = (ImageView) this.dUh.findViewById(d.h.img_play_icon);
            this.dUo.setOnClickListener(this.mOnClickListener);
            this.dUp = (ImageView) this.dUh.findViewById(d.h.img_full_screen);
            this.dUp.setOnClickListener(this.mOnClickListener);
            this.dUq = this.dUh.findViewById(d.h.layout_media_controller);
            this.fwy = this.dUh.findViewById(d.h.time_show_controller);
            this.bMO.setOnPreparedListener(this.aWe);
            this.bMO.setOnCompletionListener(this.aWd);
            this.bMO.setOnErrorListener(this.dUV);
            this.bMO.setOnSeekCompleteListener(this.aWi);
            this.bMO.setOnSurfaceDestroyedListener(this.bKW);
            this.bMO.setOnRecoveryCallback(this.fwR);
            this.bMR = (ImageView) this.dUh.findViewById(d.h.img_play);
            this.bMR.setOnClickListener(this.mOnClickListener);
            this.fwz = (TextView) this.dUh.findViewById(d.h.txt_replay);
            this.fwz.setOnClickListener(this.mOnClickListener);
            this.fwA = (TextView) this.dUh.findViewById(d.h.txt_playnext);
            this.fwA.setOnClickListener(this.mOnClickListener);
            this.fwB = (TextView) this.dUh.findViewById(d.h.txt_next_video_title);
            this.dUt = (TbImageView) this.dUh.findViewById(d.h.video_thumbnail);
            this.dUt.setDefaultErrorResource(0);
            this.dUt.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ad(this.abz.getPageActivity());
            this.mScreenHeight = bE(this.abz.getPageActivity());
            this.dUw = (ImageView) this.dUh.findViewById(d.h.img_exit);
            this.dUw.setOnClickListener(this.mOnClickListener);
            this.dUx = (TextView) this.dUh.findViewById(d.h.video_title);
            this.bMQ = this.dUh.findViewById(d.h.layout_title);
            this.bMQ.setVisibility(8);
            this.cuv = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cuw = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.abz.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dUJ = this.mAudioManager.getStreamMaxVolume(3);
            this.dUP = this.mAudioManager.getStreamVolume(3);
            dUQ = 100 / this.dUJ;
            this.dUh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fwI != null) {
                        c.this.fwI.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dUy) {
                            if (c.this.mStatus == 1 && c.this.dUL != 0) {
                                c.this.b(c.this.dUL == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dUL = 0;
                                c.this.dUK = 0;
                            }
                            if (!c.this.bMO.isPlaying() && 8 == c.this.bMR.getVisibility()) {
                                c.this.bMR.setVisibility(0);
                                c.this.fwA.setVisibility(8);
                                c.this.fwz.setVisibility(8);
                                c.this.fwB.setVisibility(8);
                            }
                        }
                        c.this.aEi();
                        if (c.this.fwI != null) {
                            c.this.fwI.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bpi = new p(this.abz.getPageActivity());
            this.bpi.start();
            this.dUO = com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds16);
            this.dUR = new CallStateReceiver();
            this.dUR.register(this.abz.getPageActivity());
            this.abz.registerListener(this.dVb);
            bdX();
        }
    }

    public void bdX() {
        if (this.fwM) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dUh.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.dUh.setSystemUiVisibility(0);
    }

    public void lr(boolean z) {
        this.fwM = z;
        bdX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEi() {
        this.mStatus = 0;
        if (this.dUD != null && this.dUD.getParent() != null && (this.dUD.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dUD.getParent()).removeView(this.dUD);
                this.dUD = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dUE != null && this.dUE.getParent() != null && (this.dUE.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dUE.getParent()).removeView(this.dUE);
                this.dUE = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aEj() {
        if (this.mStatus == 1) {
            if (this.dUD == null && this.dUh != null && (this.dUh instanceof ViewGroup)) {
                LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dUh, true);
                this.dUD = this.dUh.findViewById(d.h.lay_jindu);
                this.dUF = (TextView) this.dUD.findViewById(d.h.show_time);
                this.dUI = (ImageView) this.dUD.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dUE == null && this.dUh != null && (this.dUh instanceof ViewGroup)) {
            LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dUh, true);
            this.dUE = this.dUh.findViewById(d.h.lay_voice);
            this.dUH = (ImageView) this.dUE.findViewById(d.h.arrow_voice_icon);
            this.dUG = (SeekBar) this.dUE.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fwI != null) {
                c.this.fwI.onStart();
            }
            if (c.this.dfh && c.this.dUy) {
                if (!c.this.bMO.isPlaying() && c.this.bMR.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bMR.setVisibility(8);
                    c.this.fwA.setVisibility(8);
                    c.this.fwz.setVisibility(8);
                    c.this.fwB.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.V(f2);
                    }
                } else {
                    if (c.this.dfh) {
                        c.this.aEl();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dUK = c.this.bMO.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.V(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fwJ != null) {
                c.this.fwJ.aUr();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dUy) {
                if (c.this.alH != 2) {
                    c.this.bed();
                } else {
                    c.this.aUi();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEl() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dUh.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dUh.setSystemUiVisibility(4);
        } else {
            this.dUh.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f2) {
        if (!this.dUy) {
            this.mStatus = 0;
            return;
        }
        aEj();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dUQ == 0) {
            if (f2 > 0.0f && this.dUP < this.dUJ) {
                this.dUP++;
            }
            if (f2 < 0.0f && this.dUP > 0) {
                this.dUP--;
            }
        }
        if (this.mProgress > 0) {
            this.dUH.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dUH.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dUP, 0);
        this.dUG.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dUK -= 1000;
                this.dUL = 1;
            } else {
                this.dUK += 1000;
                this.dUL = 2;
            }
            if (this.dUK < 0) {
                this.dUK = 0;
            } else if (this.dUK > this.bMO.getDuration()) {
                this.dUK = this.bMO.getDuration();
            }
        }
        aEj();
        String rO = this.dUj.rO(this.dUK);
        if (f2 > 0.0f) {
            this.dUI.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dUI.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rO)) {
            this.dUF.setText(new StringBuilder().append(rO).append("/").append(this.dUj.rO(this.bMO.getDuration())));
        }
        this.dUj.z(this.dUK, z ? false : true);
        this.dUq.setVisibility(8);
        this.fwx.setVisibility(0);
        bdY();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.float_video_container, (ViewGroup) null);
    }

    public void bO(String str, String str2) {
        this.aXr = str;
        this.cyX = str2;
    }

    public void aUi() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.abz.getPageActivity(), this.abz.getString(d.l.neterror));
        } else if (this.bMO.isPlaying()) {
            pausePlay();
        } else if (this.dUy) {
            aEw();
            if (this.eTN != null) {
                this.eTN.aiy();
            }
        } else {
            beb();
        }
    }

    public void aEm() {
        this.dUS = true;
        if (this.bpi != null) {
            this.bpi.aEm();
        }
    }

    public boolean rM(int i2) {
        switch (i2) {
            case 4:
                if (this.dfh) {
                    aEm();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dUJ <= 0 || this.dUG == null) {
                    return false;
                }
                this.dUP = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dUP * 100.0d) / this.dUJ);
                this.dUG.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bMO;
    }

    public VideoListMediaControllerView aEn() {
        return this.dUj;
    }

    public void show() {
        this.dUh.setVisibility(0);
    }

    public void aEr() {
        if (this.dUs != null) {
            ViewGroup.LayoutParams layoutParams = this.dUs.getLayoutParams();
            this.dUm = (FrameLayout.LayoutParams) this.dUh.getLayoutParams();
            this.dUm.width = layoutParams.width;
            this.dUm.height = layoutParams.height;
            this.dUm.topMargin = 0;
            this.dUh.setLayoutParams(this.dUm);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.dUS) {
            if (this.dfh) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.dUS = false;
        }
        if (configuration.orientation == 2) {
            this.dfh = true;
            this.dUh.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.dUq.setVisibility(0);
            this.bMQ.setVisibility(0);
            this.dUw.setVisibility(0);
            this.dUx.setVisibility(0);
            this.dUl.setVisibility(8);
            if (this.fwE != null) {
                this.fwE.ait();
            }
            this.dUp.setImageResource(d.g.icon_suoxiao);
            nH(this.dUO);
            aEl();
        } else {
            this.dfh = false;
            if (this.dUm != null) {
                this.dUh.setLayoutParams(this.dUm);
            }
            a(tbPageContext, false);
            this.bMQ.setVisibility(8);
            this.dUl.setVisibility(0);
            if (this.fwE != null) {
                this.fwE.aiu();
            }
            if (this.alH == 3 && this.fwF != null) {
                this.fwF.eQ(false);
            } else if (!this.dUy && this.dUq != null) {
                this.dUq.clearAnimation();
                this.dUq.setVisibility(4);
                this.fwx.setVisibility(0);
                if (this.fwF != null) {
                    this.fwF.aix();
                }
            }
            aEi();
            this.dUp.setImageResource(d.g.icon_fangda);
            nH(0);
            this.dUh.setSystemUiVisibility(0);
            bdX();
        }
        if (this.bMO.isPlaying()) {
            aEB();
        }
        bdY();
    }

    public void bdY() {
        if (this.bMO != null) {
            int ad = com.baidu.adp.lib.util.l.ad(this.abz.getPageActivity());
            if (this.dfh) {
                ad = com.baidu.adp.lib.util.l.af(this.abz.getPageActivity());
            }
            this.fwx.setMax(ad);
            int duration = this.bMO.getDuration();
            if (duration > 0) {
                if (this.fwz.getVisibility() == 0) {
                    this.fwx.setProgress(this.fwx.getMax());
                } else {
                    this.fwx.setProgress((int) ((this.bMO.getCurrentPosition() * this.fwx.getMax()) / duration));
                }
            }
        }
    }

    private void nH(int i2) {
        if (this.dUj != null && (this.dUj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUj.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.dUj.setLayoutParams(layoutParams);
        }
    }

    private void a(TbPageContext tbPageContext, boolean z) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = tbPageContext.getPageActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                tbPageContext.getPageActivity().getWindow().setAttributes(attributes);
                tbPageContext.getPageActivity().getWindow().addFlags(512);
                this.fww.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = tbPageContext.getPageActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            tbPageContext.getPageActivity().getWindow().setAttributes(attributes2);
            tbPageContext.getPageActivity().getWindow().clearFlags(512);
            if (this.dih.getVisibility() == 0) {
                this.fww.setVisibility(0);
            }
        }
    }

    public boolean aEt() {
        return !this.dfh;
    }

    public void a(g.a aVar) {
        this.fwC = aVar;
    }

    public void a(g.b bVar) {
        this.fwD = bVar;
    }

    public void aEu() {
        this.dUo.setImageResource(d.g.icon_video_midpause);
        this.dih.setVisibility(8);
        this.fww.setVisibility(8);
        this.bMR.setVisibility(0);
        this.fwA.setVisibility(8);
        this.fwz.setVisibility(8);
        this.fwB.setVisibility(8);
        this.alH = 2;
        this.bMO.setRecoveryState(2);
    }

    public void bP(String str, String str2) {
        this.alH = 0;
        this.bMO.setRecoveryState(0);
        bO(str, str2);
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ad("tid", str2));
        }
        this.bMO.setVideoPath(str);
        this.bMO.start();
        this.dih.setVisibility(0);
        if (this.dfh) {
            this.fww.setVisibility(8);
        } else {
            this.fww.setVisibility(0);
        }
        this.dUt.setVisibility(0);
        this.bMR.setVisibility(8);
        this.dUo.setImageResource(d.g.icon_video_midplay);
        this.fwA.setVisibility(8);
        this.fwz.setVisibility(8);
        this.fwB.setVisibility(8);
        this.bMV.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUW);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.dUW, 60000L);
    }

    public void aEw() {
        this.alH = 1;
        this.bMO.setRecoveryState(1);
        this.bMO.start();
        this.dUo.setImageResource(d.g.icon_video_midplay);
        this.dUt.setVisibility(8);
        this.dUk.setVisibility(8);
        this.dih.setVisibility(8);
        this.fww.setVisibility(8);
        this.dUj.showProgress();
        this.bMR.setVisibility(8);
        this.fwA.setVisibility(8);
        this.fwz.setVisibility(8);
        this.fwB.setVisibility(8);
        bef();
    }

    public void ls(boolean z) {
        if (this.bMO != null) {
            this.bMO.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bMO.isPlaying() && this.fwN) {
            bdZ();
        }
        bee();
        this.bMO.pause();
        aEu();
    }

    public void stopPlay() {
        if (this.bMO.isPlaying() && this.fwN) {
            bdZ();
        }
        this.alH = 5;
        this.bMO.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUW);
        this.bMO.stopPlayback();
        this.dUy = false;
        this.dUC = 0;
        aqF();
    }

    public void bdZ() {
        w.beE().ao(this.aXr, this.bMO.getCurrentPosition());
    }

    public void lt(boolean z) {
        this.fwN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lu(boolean z) {
        if (this.dUq != null) {
            this.dUk.setVisibility(0);
            this.bMR.setVisibility(0);
            this.fwA.setVisibility(8);
            this.fwz.setVisibility(8);
            this.fwB.setVisibility(8);
            this.dih.setVisibility(8);
            this.fww.setVisibility(8);
            this.dUo.setImageResource(d.g.icon_video_midpause);
            this.dUq.setVisibility(4);
            this.fwx.setVisibility(8);
            this.bMV.setVisibility(8);
            this.dUj.LD();
            this.dUt.setVisibility(z ? 0 : 8);
        }
    }

    public void aqF() {
        lu(true);
    }

    public boolean bea() {
        if (this.bMO == null) {
            return false;
        }
        return this.bMO.isPlaying();
    }

    public void a(i iVar) {
        this.fwI = iVar;
    }

    public void a(h hVar) {
        this.fwH = hVar;
    }

    public void a(g gVar) {
        this.eTN = gVar;
    }

    public void a(f fVar) {
        this.fwG = fVar;
    }

    public void ps(String str) {
        this.eTu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beb() {
        a(this.aXr, this.cyX, (d) null);
    }

    public void b(InterfaceC0120c interfaceC0120c) {
        this.fwF = interfaceC0120c;
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fwL != null) {
                    this.fwL.eP(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abz.getPageActivity());
                aVar.cM(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
                aVar.a(d.l.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bec();
                        c.this.bP(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.jX(false);
                        }
                    }
                });
                aVar.b(d.l.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.abz).ti();
                return;
            } else if (this.fwL != null) {
                this.fwL.eP(true);
                return;
            } else {
                if (!this.fwu) {
                    this.fwu = true;
                    com.baidu.adp.lib.util.l.showToast(this.abz.getPageActivity(), d.l.play_video_mobile_tip2);
                }
                bP(str, str2);
                if (dVar != null) {
                    dVar.jX(true);
                    return;
                }
                return;
            }
        }
        bP(str, str2);
        if (dVar != null) {
            dVar.jX(true);
        }
        if (this.fwK != null) {
            this.fwK.aiv();
        }
    }

    public void bec() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nk(String str) {
        this.dUt.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dVa);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUW);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwQ);
        this.bpi.stop();
        this.dUR.unregister(this.abz.getPageActivity());
    }

    public void setVideoTitle(String str) {
        this.dUx.setText(str);
    }

    public void bR(long j2) {
        this.fwv.setText(am.t(j2));
    }

    public boolean aEx() {
        return this.dUy;
    }

    public void aEy() {
        if (this.dUq != null) {
            aEA();
            this.dUq.setVisibility(0);
            this.fwy.setVisibility(0);
            if (this.fwF != null) {
                this.fwF.eQ(true);
            }
            this.fwx.setVisibility(8);
            this.cuv.setAnimationListener(this.dUY);
            this.dUq.startAnimation(this.cuv);
            this.dUA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        if (this.dUq != null) {
            if (this.dUq.getVisibility() == 0) {
                aEA();
                this.dUq.setVisibility(8);
                this.fwx.setVisibility(0);
                if (this.fwF != null) {
                    this.fwF.aix();
                    return;
                }
                return;
            }
            aEB();
        }
    }

    public void aEz() {
        if (this.dUq != null) {
            aEA();
            this.dUq.setVisibility(0);
            this.fwy.setVisibility(0);
            if (this.fwF != null) {
                this.fwF.eQ(false);
            }
            this.fwx.setVisibility(8);
            this.cuw.setAnimationListener(this.dUZ);
            this.dUq.startAnimation(this.cuw);
        }
    }

    public void bee() {
        if (this.dUq != null) {
            aEA();
            this.dUq.setVisibility(0);
            this.fwy.setVisibility(0);
            this.fwx.setVisibility(8);
            if (this.fwF != null) {
                this.fwF.eQ(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEA() {
        if (this.dUq != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dVa);
            this.cuw.setAnimationListener(null);
            this.cuv.setAnimationListener(null);
            this.dUq.clearAnimation();
            this.dUA = false;
        }
    }

    public void aEB() {
        aEz();
        bef();
    }

    private void bef() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dVa);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.dVa, 3000L);
    }

    public void a(b bVar) {
        this.fwE = bVar;
    }

    public void nJ(int i2) {
        if (this.bMO.getDuration() - i2 <= 3000) {
            aEA();
            if (this.dUq != null) {
                this.dUq.setVisibility(0);
                this.fwy.setVisibility(0);
                this.fwx.setVisibility(8);
                if (this.fwF != null) {
                    this.fwF.eQ(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.dUC = i2;
    }

    public void lv(boolean z) {
        if (this.bpi != null) {
            if (this.dUp != null) {
                this.dUp.setVisibility(z ? 0 : 8);
            }
            this.bpi.lw(z);
        }
    }

    public int bE(Context context) {
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
            return com.baidu.adp.lib.util.l.af(context);
        }
        return i2;
    }

    public int beg() {
        return this.alH;
    }

    public void a(k kVar) {
        this.fwJ = kVar;
    }

    public void a(j jVar) {
        this.fwK = jVar;
    }

    public void a(e eVar) {
        this.fwL = eVar;
    }
}
