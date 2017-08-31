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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.s;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int dXO;
    private String aVG;
    private TbPageContext<?> aby;
    private View bMB;
    private QuickVideoView bMu;
    private View bMw;
    private ImageView bMx;
    private o bnz;
    private Animation csY;
    private Animation csZ;
    private View dXB;
    private View dXC;
    private TextView dXD;
    private SeekBar dXE;
    private ImageView dXF;
    private ImageView dXG;
    private int dXH;
    private int dXM;
    private int dXN;
    private CallStateReceiver dXP;
    protected View dXf;
    private VideoListMediaControllerView dXh;
    private View dXi;
    private FrameLayout dXj;
    protected FrameLayout.LayoutParams dXk;
    private ImageView dXm;
    private ImageView dXn;
    private View dXo;
    private View dXq;
    private TbImageView dXr;
    private f.e dXs;
    private ImageView dXu;
    private TextView dXv;
    private View dkX;
    private g eYK;
    private f.b fzA;
    private b fzB;
    private InterfaceC0119c fzC;
    private f fzD;
    private h fzE;
    private i fzF;
    private k fzG;
    private j fzH;
    private e fzI;
    private TextView fzs;
    private View fzt;
    private ProgressBar fzu;
    private View fzv;
    private TextView fzw;
    private TextView fzx;
    private TextView fzy;
    private f.a fzz;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fzr = false;
    protected boolean dhY = false;
    private boolean dXw = false;
    private boolean dXy = false;
    private int dXA = 0;
    private int mStatus = 0;
    private int dXI = 0;
    private int dXJ = 0;
    private boolean dXQ = false;
    private boolean fzJ = true;
    private boolean fzK = true;
    private String eYr = null;
    private int aml = -1;
    private f.e aUw = new f.e() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.f.e
        public void onPrepared(com.baidu.tieba.play.f fVar) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dXS);
            com.baidu.adp.lib.g.e.fQ().postDelayed(c.this.dXS, 20L);
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dXU);
            if (c.this.bMu.bfA()) {
                c.this.aml = 1;
                c.this.bMu.setRecoveryState(1);
            }
            if (fVar != null && c.this.dXh != null) {
                c.this.dXA = v.bfQ().qB(c.this.aVG);
                c.this.dXh.S(c.this.dXA, fVar.getDuration());
                if (c.this.dXA != 0) {
                    fVar.seekTo(c.this.dXA);
                }
            }
        }
    };
    private Runnable dXS = new Runnable() { // from class: com.baidu.tieba.play.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMu.getCurrentPosition() > 100) {
                c.this.dXw = true;
                c.this.dXi.setVisibility(8);
                c.this.bMB.setVisibility(8);
                c.this.dkX.setVisibility(8);
                c.this.fzt.setVisibility(8);
                c.this.dXr.setVisibility(8);
                c.this.aFz();
                if (c.this.aml == 1 || c.this.aml == 2) {
                    if (c.this.dXo != null) {
                        c.this.dXo.setVisibility(0);
                        c.this.fzv.setVisibility(0);
                        c.this.fzu.setVisibility(8);
                        if (c.this.fzC != null) {
                            c.this.fzC.eW(false);
                        }
                    }
                    c.this.dXh.showProgress();
                    c.this.aFA();
                }
                if (c.this.dXs != null) {
                    c.this.dXs.onPrepared(c.this.bMu.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fQ().postDelayed(c.this.dXS, 20L);
        }
    };
    private f.a aUv = new f.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.f.a
        public void onCompletion(com.baidu.tieba.play.f fVar) {
            c.this.dXw = false;
            c.this.dXA = 0;
            c.this.aFh();
            c.this.dXi.setVisibility(0);
            c.this.fzu.setVisibility(8);
            c.this.fzu.setProgress(c.this.fzu.getMax());
            if (c.this.fzC != null) {
                c.this.fzC.eW(false);
            }
            if (c.this.dhY) {
                c.this.dXo.setVisibility(0);
                c.this.dXu.setVisibility(0);
                c.this.dXv.setVisibility(0);
                c.this.fzv.setVisibility(8);
            } else {
                c.this.dXo.setVisibility(8);
                c.this.dXu.setVisibility(8);
                c.this.dXv.setVisibility(8);
                c.this.fzv.setVisibility(8);
            }
            if (c.this.bMu == null || c.this.bMu.getDuration() > 150000) {
                c.this.lA(false);
            } else {
                c.this.fzw.setVisibility(0);
            }
            v.bfQ().remove(c.this.aVG);
            if (c.this.fzz != null) {
                c.this.fzz.onCompletion(fVar);
            }
            c.this.aml = 3;
            c.this.bMu.setRecoveryState(3);
            if (!c.this.dhY && c.this.bMu != null && c.this.bMu.getDuration() <= 150000) {
                if (c.this.fzE != null) {
                    c.this.fzE.eX(true);
                }
                c.this.startPlay(c.this.aVG);
            }
        }
    };
    private f.b dXT = new f.b() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.f.b
        public boolean onError(com.baidu.tieba.play.f fVar, int i2, int i3) {
            c.this.bMB.setVisibility(0);
            c.this.dkX.setVisibility(8);
            c.this.fzt.setVisibility(8);
            c.this.aml = 4;
            c.this.bMu.setRecoveryState(4);
            if (c.this.fzA != null) {
                c.this.fzA.onError(fVar, i2, i3);
                return true;
            }
            return true;
        }
    };
    private Runnable dXU = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            c.this.bMB.setVisibility(0);
            c.this.dkX.setVisibility(8);
            c.this.fzt.setVisibility(8);
        }
    };
    private QuickVideoView.b bKJ = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dXw = false;
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dXS);
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dXU);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bMB.getId()) {
                c.this.bfp();
            } else if (view.getId() != c.this.bMx.getId() && view.getId() != c.this.dXm.getId()) {
                if (view.getId() == c.this.fzx.getId()) {
                    if (c.this.fzD != null) {
                        c.this.fzD.aVY();
                    }
                } else if (view.getId() == c.this.fzw.getId()) {
                    if (c.this.fzE != null) {
                        c.this.fzE.eX(false);
                    }
                    c.this.startPlay(c.this.aVG);
                } else if (view.getId() != c.this.dXn.getId()) {
                    if (view.getId() == c.this.dXu.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fzH != null) {
                            c.this.fzH.aii();
                        }
                        c.this.aFl();
                    }
                } else {
                    if (c.this.dhY) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fzH != null) {
                        c.this.fzH.aii();
                    }
                    c.this.aFl();
                }
            } else {
                c.this.aVO();
            }
        }
    };
    private Animation.AnimationListener dXW = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dXo != null) {
                c.this.dXo.setVisibility(8);
                c.this.fzu.setVisibility(0);
                c.this.dXy = false;
                if (c.this.fzC != null) {
                    c.this.fzC.aij();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dXX = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.4
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
    private Runnable dXY = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aFx();
        }
    };
    private CustomMessageListener dXZ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private s.b eaJ = new s.b() { // from class: com.baidu.tieba.play.c.7
        @Override // com.baidu.tieba.play.s.b
        public void fR(int i2) {
            int duration;
            if (c.this.bMu != null && (duration = c.this.bMu.getDuration()) > 0 && c.this.fzu != null) {
                c.this.fzu.setProgress((int) ((i2 * c.this.dXf.getWidth()) / duration));
            }
            c.this.nL(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener aYs = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.dXy) {
                c.this.aFA();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aFw() && c.this.aFm() != null) {
                c.this.setStartPosition(c.this.aFm().getSeekPosition());
                c.this.startPlay(c.this.aVG);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aif();

        void aig();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0119c {
        void aij();

        void eW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void kh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eV(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aVY();
    }

    /* loaded from: classes.dex */
    public interface g {
        void aik();
    }

    /* loaded from: classes.dex */
    public interface h {
        void eX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void aih();

        void aii();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aVX();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dXM = 0;
        if (tbPageContext != null) {
            this.aby = tbPageContext;
            this.dXf = t(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dXf);
            }
            this.dXq = view;
            this.dXf.setOnClickListener(this.mOnClickListener);
            this.bMu = (QuickVideoView) this.dXf.findViewById(d.h.videoView);
            this.dkX = this.dXf.findViewById(d.h.video_list_layout_loading);
            this.fzt = this.dXf.findViewById(d.h.layout_play_count);
            this.fzs = (TextView) this.dXf.findViewById(d.h.play_count);
            this.dXh = (VideoListMediaControllerView) this.dXf.findViewById(d.h.media_controller);
            this.dXh.setPlayer(this.bMu);
            this.fzu = (ProgressBar) this.dXf.findViewById(d.h.pgrBottomProgress);
            this.fzu.setMax(com.baidu.adp.lib.util.k.ad(this.aby.getPageActivity()));
            this.fzu.setProgress(0);
            this.dXh.setOnSeekBarChangeListener(this.aYs);
            this.dXh.setOnProgressUpdatedListener(this.eaJ);
            this.dXi = this.dXf.findViewById(d.h.black_mask);
            this.bMB = this.dXf.findViewById(d.h.layout_error);
            this.bMB.setOnClickListener(this.mOnClickListener);
            this.dXj = (FrameLayout) this.dXf.findViewById(d.h.danmu_container);
            this.dXm = (ImageView) this.dXf.findViewById(d.h.img_play_icon);
            this.dXm.setOnClickListener(this.mOnClickListener);
            this.dXn = (ImageView) this.dXf.findViewById(d.h.img_full_screen);
            this.dXn.setOnClickListener(this.mOnClickListener);
            this.dXo = this.dXf.findViewById(d.h.layout_media_controller);
            this.fzv = this.dXf.findViewById(d.h.time_show_controller);
            this.bMu.setOnPreparedListener(this.aUw);
            this.bMu.setOnCompletionListener(this.aUv);
            this.bMu.setOnErrorListener(this.dXT);
            this.bMu.setOnSurfaceDestroyedListener(this.bKJ);
            this.bMx = (ImageView) this.dXf.findViewById(d.h.img_play);
            this.bMx.setOnClickListener(this.mOnClickListener);
            this.fzw = (TextView) this.dXf.findViewById(d.h.txt_replay);
            this.fzw.setOnClickListener(this.mOnClickListener);
            this.fzx = (TextView) this.dXf.findViewById(d.h.txt_playnext);
            this.fzx.setOnClickListener(this.mOnClickListener);
            this.fzy = (TextView) this.dXf.findViewById(d.h.txt_next_video_title);
            this.dXr = (TbImageView) this.dXf.findViewById(d.h.video_thumbnail);
            this.dXr.setDefaultErrorResource(0);
            this.dXr.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.ad(this.aby.getPageActivity());
            this.mScreenHeight = bF(this.aby.getPageActivity());
            this.dXu = (ImageView) this.dXf.findViewById(d.h.img_exit);
            this.dXu.setOnClickListener(this.mOnClickListener);
            this.dXv = (TextView) this.dXf.findViewById(d.h.video_title);
            this.bMw = this.dXf.findViewById(d.h.layout_title);
            this.bMw.setVisibility(8);
            this.csY = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.csZ = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aby.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dXH = this.mAudioManager.getStreamMaxVolume(3);
            this.dXN = this.mAudioManager.getStreamVolume(3);
            dXO = 100 / this.dXH;
            this.dXf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fzF != null) {
                        c.this.fzF.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dXw) {
                            if (c.this.mStatus == 1 && c.this.dXJ != 0) {
                                c.this.c(c.this.dXJ == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dXJ = 0;
                                c.this.dXI = 0;
                            }
                            if (!c.this.bMu.isPlaying() && 8 == c.this.bMx.getVisibility()) {
                                c.this.bMx.setVisibility(0);
                                c.this.fzx.setVisibility(8);
                                c.this.fzw.setVisibility(8);
                                c.this.fzy.setVisibility(8);
                            }
                        }
                        c.this.aFh();
                        if (c.this.fzF != null) {
                            c.this.fzF.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bnz = new o(this.aby.getPageActivity());
            this.bnz.start();
            this.dXM = com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds16);
            this.dXP = new CallStateReceiver();
            this.dXP.register(this.aby.getPageActivity());
            this.aby.registerListener(this.dXZ);
            bfl();
        }
    }

    public void bfl() {
        if (this.fzJ) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dXf.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.dXf.setSystemUiVisibility(0);
    }

    public void lx(boolean z) {
        this.fzJ = z;
        bfl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFh() {
        this.mStatus = 0;
        if (this.dXB != null && this.dXB.getParent() != null && (this.dXB.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dXB.getParent()).removeView(this.dXB);
                this.dXB = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dXC != null && this.dXC.getParent() != null && (this.dXC.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dXC.getParent()).removeView(this.dXC);
                this.dXC = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aFi() {
        if (this.mStatus == 1) {
            if (this.dXB == null && this.dXf != null && (this.dXf instanceof ViewGroup)) {
                LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dXf, true);
                this.dXB = this.dXf.findViewById(d.h.lay_jindu);
                this.dXD = (TextView) this.dXB.findViewById(d.h.show_time);
                this.dXG = (ImageView) this.dXB.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dXC == null && this.dXf != null && (this.dXf instanceof ViewGroup)) {
            LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dXf, true);
            this.dXC = this.dXf.findViewById(d.h.lay_voice);
            this.dXF = (ImageView) this.dXC.findViewById(d.h.arrow_voice_icon);
            this.dXE = (SeekBar) this.dXC.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fzF != null) {
                c.this.fzF.onStart();
            }
            if (c.this.dhY && c.this.dXw) {
                if (!c.this.bMu.isPlaying() && c.this.bMx.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bMx.setVisibility(8);
                    c.this.fzx.setVisibility(8);
                    c.this.fzw.setVisibility(8);
                    c.this.fzy.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.S(f2);
                    }
                } else {
                    if (c.this.dhY) {
                        c.this.aFk();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dXI = c.this.bMu.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.S(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fzG != null) {
                c.this.fzG.aVX();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dXw) {
                if (c.this.aml != 2) {
                    c.this.bfr();
                } else {
                    c.this.aVO();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFk() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dXf.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dXf.setSystemUiVisibility(4);
        } else {
            this.dXf.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(float f2) {
        if (!this.dXw) {
            this.mStatus = 0;
            return;
        }
        aFi();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dXO == 0) {
            if (f2 > 0.0f && this.dXN < this.dXH) {
                this.dXN++;
            }
            if (f2 < 0.0f && this.dXN > 0) {
                this.dXN--;
            }
        }
        if (this.mProgress > 0) {
            this.dXF.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dXF.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dXN, 0);
        this.dXE.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dXI -= 1000;
                this.dXJ = 1;
            } else {
                this.dXI += 1000;
                this.dXJ = 2;
            }
            if (this.dXI < 0) {
                this.dXI = 0;
            } else if (this.dXI > this.bMu.getDuration()) {
                this.dXI = this.bMu.getDuration();
            }
        }
        aFi();
        String rM = this.dXh.rM(this.dXI);
        if (f2 > 0.0f) {
            this.dXG.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dXG.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rM)) {
            this.dXD.setText(new StringBuilder().append(rM).append("/").append(this.dXh.rM(this.bMu.getDuration())));
        }
        this.dXh.A(this.dXI, z ? false : true);
        this.dXo.setVisibility(8);
        this.fzu.setVisibility(0);
        bfm();
    }

    protected View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.aVG = str;
    }

    public void aVO() {
        if (!com.baidu.adp.lib.util.i.hi()) {
            com.baidu.adp.lib.util.k.F(this.aby.getPageActivity(), this.aby.getString(d.l.neterror));
        } else if (this.bMu.isPlaying()) {
            pausePlay();
        } else if (this.dXw) {
            aFv();
            if (this.eYK != null) {
                this.eYK.aik();
            }
        } else {
            bfp();
        }
    }

    public void aFl() {
        this.dXQ = true;
        if (this.bnz != null) {
            this.bnz.aFl();
        }
    }

    public boolean rK(int i2) {
        switch (i2) {
            case 4:
                if (this.dhY) {
                    aFl();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dXH <= 0 || this.dXE == null) {
                    return false;
                }
                this.dXN = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dXN * 100.0d) / this.dXH);
                this.dXE.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bMu;
    }

    public VideoListMediaControllerView aFm() {
        return this.dXh;
    }

    public void show() {
        this.dXf.setVisibility(0);
    }

    public void aFq() {
        if (this.dXq != null) {
            ViewGroup.LayoutParams layoutParams = this.dXq.getLayoutParams();
            this.dXk = (FrameLayout.LayoutParams) this.dXf.getLayoutParams();
            this.dXk.width = layoutParams.width;
            this.dXk.height = layoutParams.height;
            this.dXk.topMargin = 0;
            this.dXf.setLayoutParams(this.dXk);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.dXQ) {
            if (this.dhY) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.dXQ = false;
        }
        if (configuration.orientation == 2) {
            this.dhY = true;
            this.dXf.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.dXo.setVisibility(0);
            this.bMw.setVisibility(0);
            this.dXu.setVisibility(0);
            this.dXv.setVisibility(0);
            this.dXj.setVisibility(8);
            if (this.fzB != null) {
                this.fzB.aif();
            }
            this.dXn.setImageResource(d.g.icon_suoxiao);
            nJ(this.dXM);
            aFk();
        } else {
            this.dhY = false;
            if (this.dXk != null) {
                this.dXf.setLayoutParams(this.dXk);
            }
            a(tbPageContext, false);
            this.bMw.setVisibility(8);
            this.dXj.setVisibility(0);
            if (this.fzB != null) {
                this.fzB.aig();
            }
            if (this.aml == 3 && this.fzC != null) {
                this.fzC.eW(false);
            } else if (!this.dXw && this.dXo != null) {
                this.dXo.clearAnimation();
                this.dXo.setVisibility(4);
                this.fzu.setVisibility(0);
                if (this.fzC != null) {
                    this.fzC.aij();
                }
            }
            aFh();
            this.dXn.setImageResource(d.g.icon_fangda);
            nJ(0);
            this.dXf.setSystemUiVisibility(0);
            bfl();
        }
        if (this.bMu.isPlaying()) {
            aFA();
        }
        bfm();
    }

    public void bfm() {
        if (this.bMu != null) {
            int ad = com.baidu.adp.lib.util.k.ad(this.aby.getPageActivity());
            if (this.dhY) {
                ad = com.baidu.adp.lib.util.k.ae(this.aby.getPageActivity());
            }
            this.fzu.setMax(ad);
            int duration = this.bMu.getDuration();
            if (duration > 0) {
                if (this.fzw.getVisibility() == 0) {
                    this.fzu.setProgress(this.fzu.getMax());
                } else {
                    this.fzu.setProgress((int) ((this.bMu.getCurrentPosition() * this.fzu.getMax()) / duration));
                }
            }
        }
    }

    private void nJ(int i2) {
        if (this.dXh != null && (this.dXh.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dXh.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.dXh.setLayoutParams(layoutParams);
        }
    }

    private void a(TbPageContext tbPageContext, boolean z) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = tbPageContext.getPageActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                tbPageContext.getPageActivity().getWindow().setAttributes(attributes);
                tbPageContext.getPageActivity().getWindow().addFlags(512);
                this.fzt.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = tbPageContext.getPageActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            tbPageContext.getPageActivity().getWindow().setAttributes(attributes2);
            tbPageContext.getPageActivity().getWindow().clearFlags(512);
            if (this.dkX.getVisibility() == 0) {
                this.fzt.setVisibility(0);
            }
        }
    }

    public boolean aFs() {
        return !this.dhY;
    }

    public void a(f.a aVar) {
        this.fzz = aVar;
    }

    public void a(f.b bVar) {
        this.fzA = bVar;
    }

    public void aFt() {
        this.dXm.setImageResource(d.g.icon_video_midpause);
        this.dkX.setVisibility(8);
        this.fzt.setVisibility(8);
        this.bMx.setVisibility(0);
        this.fzx.setVisibility(8);
        this.fzw.setVisibility(8);
        this.fzy.setVisibility(8);
        this.aml = 2;
        this.bMu.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.aml = 0;
        this.bMu.setRecoveryState(0);
        setVideoUrl(str);
        this.bMu.setVideoPath(str);
        this.bMu.start();
        this.dkX.setVisibility(0);
        if (this.dhY) {
            this.fzt.setVisibility(8);
        } else {
            this.fzt.setVisibility(0);
        }
        this.dXr.setVisibility(0);
        this.bMx.setVisibility(8);
        this.dXm.setImageResource(d.g.icon_video_midplay);
        this.fzx.setVisibility(8);
        this.fzw.setVisibility(8);
        this.fzy.setVisibility(8);
        this.bMB.setVisibility(8);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXU);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.dXU, TbConfig.USE_TIME_INTERVAL);
    }

    public void aFv() {
        this.aml = 1;
        this.bMu.setRecoveryState(1);
        this.bMu.start();
        this.dXm.setImageResource(d.g.icon_video_midplay);
        this.dXr.setVisibility(8);
        this.dXi.setVisibility(8);
        this.dkX.setVisibility(8);
        this.fzt.setVisibility(8);
        this.dXh.showProgress();
        this.bMx.setVisibility(8);
        this.fzx.setVisibility(8);
        this.fzw.setVisibility(8);
        this.fzy.setVisibility(8);
        bft();
    }

    public void ly(boolean z) {
        if (this.bMu != null) {
            this.bMu.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bMu.isPlaying() && this.fzK) {
            bfn();
        }
        bfs();
        this.bMu.pause();
        aFt();
    }

    public void stopPlay() {
        if (this.bMu.isPlaying() && this.fzK) {
            bfn();
        }
        this.aml = 5;
        this.bMu.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXS);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXU);
        this.bMu.stopPlayback();
        this.dXw = false;
        this.dXA = 0;
        arO();
    }

    public void bfn() {
        v.bfQ().ap(this.aVG, this.bMu.getCurrentPosition());
    }

    public void lz(boolean z) {
        this.fzK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA(boolean z) {
        if (this.dXo != null) {
            this.dXi.setVisibility(0);
            this.bMx.setVisibility(0);
            this.fzx.setVisibility(8);
            this.fzw.setVisibility(8);
            this.fzy.setVisibility(8);
            this.dkX.setVisibility(8);
            this.fzt.setVisibility(8);
            this.dXm.setImageResource(d.g.icon_video_midpause);
            this.dXo.setVisibility(4);
            this.fzu.setVisibility(8);
            this.bMB.setVisibility(8);
            this.dXh.Lm();
            this.dXr.setVisibility(z ? 0 : 8);
        }
    }

    public void arO() {
        lA(true);
    }

    public boolean bfo() {
        if (this.bMu == null) {
            return false;
        }
        return this.bMu.isPlaying();
    }

    public void a(i iVar) {
        this.fzF = iVar;
    }

    public void a(h hVar) {
        this.fzE = hVar;
    }

    public void a(g gVar) {
        this.eYK = gVar;
    }

    public void a(f fVar) {
        this.fzD = fVar;
    }

    public void pH(String str) {
        this.eYr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfp() {
        a(this.aVG, (d) null);
    }

    public void b(InterfaceC0119c interfaceC0119c) {
        this.fzC = interfaceC0119c;
    }

    public void a(final String str, final d dVar) {
        if (com.baidu.adp.lib.util.i.hk()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fzI != null) {
                    this.fzI.eV(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aby.getPageActivity());
                aVar.cM(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
                aVar.a(d.l.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bfq();
                        c.this.startPlay(str);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.kh(false);
                        }
                    }
                });
                aVar.b(d.l.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aby).to();
                return;
            } else if (this.fzI != null) {
                this.fzI.eV(true);
                return;
            } else {
                if (!this.fzr) {
                    this.fzr = true;
                    com.baidu.adp.lib.util.k.showToast(this.aby.getPageActivity(), d.l.play_video_mobile_tip2);
                }
                startPlay(str);
                if (dVar != null) {
                    dVar.kh(true);
                    return;
                }
                return;
            }
        }
        startPlay(str);
        if (dVar != null) {
            dVar.kh(true);
        }
        if (this.fzH != null) {
            this.fzH.aih();
        }
    }

    public void bfq() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nE(String str) {
        this.dXr.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXY);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXS);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXU);
        this.bnz.stop();
        this.dXP.unregister(this.aby.getPageActivity());
    }

    public void qz(String str) {
        this.dXv.setText(str);
    }

    public void bU(long j2) {
        this.fzs.setText(am.u(j2));
    }

    public boolean aFw() {
        return this.dXw;
    }

    public void aFx() {
        if (this.dXo != null) {
            aFz();
            this.dXo.setVisibility(0);
            this.fzv.setVisibility(0);
            if (this.fzC != null) {
                this.fzC.eW(true);
            }
            this.fzu.setVisibility(8);
            this.csY.setAnimationListener(this.dXW);
            this.dXo.startAnimation(this.csY);
            this.dXy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfr() {
        if (this.dXo != null) {
            if (this.dXo.getVisibility() == 0) {
                aFz();
                this.dXo.setVisibility(8);
                this.fzu.setVisibility(0);
                if (this.fzC != null) {
                    this.fzC.aij();
                    return;
                }
                return;
            }
            aFA();
        }
    }

    public void aFy() {
        if (this.dXo != null) {
            aFz();
            this.dXo.setVisibility(0);
            this.fzv.setVisibility(0);
            if (this.fzC != null) {
                this.fzC.eW(false);
            }
            this.fzu.setVisibility(8);
            this.csZ.setAnimationListener(this.dXX);
            this.dXo.startAnimation(this.csZ);
        }
    }

    public void bfs() {
        if (this.dXo != null) {
            aFz();
            this.dXo.setVisibility(0);
            this.fzv.setVisibility(0);
            this.fzu.setVisibility(8);
            if (this.fzC != null) {
                this.fzC.eW(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFz() {
        if (this.dXo != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXY);
            this.csZ.setAnimationListener(null);
            this.csY.setAnimationListener(null);
            this.dXo.clearAnimation();
            this.dXy = false;
        }
    }

    public void aFA() {
        aFy();
        bft();
    }

    private void bft() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dXY);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.dXY, 3000L);
    }

    public void a(b bVar) {
        this.fzB = bVar;
    }

    public void nL(int i2) {
        if (this.bMu.getDuration() - i2 <= 3000) {
            aFz();
            if (this.dXo != null) {
                this.dXo.setVisibility(0);
                this.fzv.setVisibility(0);
                this.fzu.setVisibility(8);
                if (this.fzC != null) {
                    this.fzC.eW(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.dXA = i2;
    }

    public void lB(boolean z) {
        if (this.bnz != null) {
            if (this.dXn != null) {
                this.dXn.setVisibility(z ? 0 : 8);
            }
            this.bnz.lC(z);
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
            return com.baidu.adp.lib.util.k.ae(context);
        }
        return i2;
    }

    public int bfu() {
        return this.aml;
    }

    public void a(k kVar) {
        this.fzG = kVar;
    }

    public void a(j jVar) {
        this.fzH = jVar;
    }

    public void a(e eVar) {
        this.fzI = eVar;
    }
}
