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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.s;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int dRd;
    private TbPageContext<?> acr;
    private QuickVideoView bJC;
    private View bJE;
    private ImageView bJF;
    private View bJJ;
    private o bnc;
    private ImageView dQA;
    private ImageView dQB;
    private View dQC;
    private View dQE;
    private TbImageView dQF;
    private f.d dQG;
    private ImageView dQI;
    private TextView dQJ;
    private Animation dQN;
    private View dQQ;
    private View dQR;
    private TextView dQS;
    private SeekBar dQT;
    private ImageView dQU;
    private ImageView dQV;
    private int dQW;
    private Animation dQf;
    protected View dQt;
    private VideoListMediaControllerView dQv;
    private View dQw;
    private FrameLayout dQx;
    protected FrameLayout.LayoutParams dQy;
    private int dRb;
    private int dRc;
    private CallStateReceiver dRe;
    private View det;
    private TextView fAV;
    private View fAW;
    private ProgressBar fAX;
    private View fAY;
    private TextView fAZ;
    private TextView fBa;
    private TextView fBb;
    private f.a fBc;
    private f.b fBd;
    private b fBe;
    private InterfaceC0117c fBf;
    private d fBg;
    private f fBh;
    private g fBi;
    private h fBj;
    private e fab;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean fAU = false;
    protected boolean dbr = false;
    private boolean dQK = false;
    private boolean dQM = false;
    private int dQP = 0;
    private int mStatus = 0;
    private int dQX = 0;
    private int dQY = 0;
    private boolean dRf = false;
    private String eZJ = null;
    private int amR = -1;
    private f.d aUO = new f.d() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.f.d
        public void onPrepared(com.baidu.tieba.play.f fVar) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dRh);
            com.baidu.adp.lib.g.e.ga().postDelayed(c.this.dRh, 20L);
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dRj);
            if (c.this.bJC.bgk()) {
                c.this.amR = 1;
                c.this.bJC.setRecoveryState(1);
            }
            if (fVar != null && c.this.dQv != null) {
                c.this.dQP = v.bgA().qP(c.this.mVideoUrl);
                c.this.dQv.U(c.this.dQP, fVar.getDuration());
                if (c.this.dQP != 0) {
                    fVar.seekTo(c.this.dQP);
                }
            }
        }
    };
    private Runnable dRh = new Runnable() { // from class: com.baidu.tieba.play.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bJC.getCurrentPosition() > 100) {
                c.this.dQK = true;
                c.this.dQw.setVisibility(8);
                c.this.bJJ.setVisibility(8);
                c.this.det.setVisibility(8);
                c.this.fAW.setVisibility(8);
                c.this.dQF.setVisibility(8);
                c.this.aDK();
                if (c.this.amR == 1 || c.this.amR == 2) {
                    if (c.this.dQC != null) {
                        c.this.dQC.setVisibility(0);
                        c.this.fAY.setVisibility(0);
                        c.this.fAX.setVisibility(8);
                        if (c.this.fBf != null) {
                            c.this.fBf.kh(false);
                        }
                    }
                    c.this.dQv.showProgress();
                    c.this.aDL();
                }
                if (c.this.dQG != null) {
                    c.this.dQG.onPrepared(c.this.bJC.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.ga().postDelayed(c.this.dRh, 20L);
        }
    };
    private f.a aUN = new f.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.f.a
        public void onCompletion(com.baidu.tieba.play.f fVar) {
            c.this.dQK = false;
            c.this.dQP = 0;
            c.this.aDs();
            c.this.dQw.setVisibility(0);
            c.this.fAX.setVisibility(8);
            c.this.fAX.setProgress(c.this.fAX.getMax());
            if (c.this.fBf != null) {
                c.this.fBf.kh(false);
            }
            if (c.this.dbr) {
                c.this.dQC.setVisibility(0);
                c.this.dQI.setVisibility(0);
                c.this.dQJ.setVisibility(0);
                c.this.fAY.setVisibility(8);
            } else {
                c.this.dQC.setVisibility(8);
                c.this.dQI.setVisibility(8);
                c.this.dQJ.setVisibility(8);
                c.this.fAY.setVisibility(8);
            }
            if (c.this.bJC == null || c.this.bJC.getDuration() > 150000) {
                c.this.lw(false);
            } else {
                c.this.fAZ.setVisibility(0);
            }
            v.bgA().remove(c.this.mVideoUrl);
            if (c.this.fBc != null) {
                c.this.fBc.onCompletion(fVar);
            }
            c.this.amR = 3;
            c.this.bJC.setRecoveryState(3);
            if (!c.this.dbr && c.this.bJC != null && c.this.bJC.getDuration() <= 150000) {
                if (c.this.fBh != null) {
                    c.this.fBh.aWM();
                }
                c.this.startPlay(c.this.mVideoUrl);
            }
        }
    };
    private f.b dRi = new f.b() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.f.b
        public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
            c.this.bJJ.setVisibility(0);
            c.this.det.setVisibility(8);
            c.this.fAW.setVisibility(8);
            c.this.amR = 4;
            c.this.bJC.setRecoveryState(4);
            if (c.this.fBd != null) {
                c.this.fBd.onError(fVar, i, i2);
                return true;
            }
            return true;
        }
    };
    private Runnable dRj = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            c.this.bJJ.setVisibility(0);
            c.this.det.setVisibility(8);
            c.this.fAW.setVisibility(8);
        }
    };
    private QuickVideoView.b bHP = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dQK = false;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dRh);
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dRj);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bJJ.getId()) {
                c.this.bgc();
            } else if (view.getId() != c.this.bJF.getId() && view.getId() != c.this.dQA.getId()) {
                if (view.getId() == c.this.fBa.getId()) {
                    if (c.this.fBg != null) {
                        c.this.fBg.aWL();
                    }
                } else if (view.getId() == c.this.fAZ.getId()) {
                    if (c.this.fBh != null) {
                        c.this.fBh.aWM();
                    }
                    c.this.startPlay(c.this.mVideoUrl);
                } else if (view.getId() != c.this.dQB.getId()) {
                    if (view.getId() == c.this.dQI.getId()) {
                        TiebaStatic.log(new aj("c11713"));
                        c.this.aDw();
                    }
                } else {
                    if (c.this.dbr) {
                        TiebaStatic.log(new aj("c11714"));
                    } else {
                        TiebaStatic.log(new aj("c11710"));
                    }
                    c.this.aDw();
                }
            } else {
                c.this.aWA();
            }
        }
    };
    private Animation.AnimationListener dRl = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dQC != null) {
                c.this.dQC.setVisibility(8);
                c.this.fAX.setVisibility(0);
                c.this.dQM = false;
                if (c.this.fBf != null) {
                    c.this.fBf.aWK();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dRm = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.4
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
    private Runnable dRn = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aDI();
        }
    };
    private CustomMessageListener dRo = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private s.b dTY = new s.b() { // from class: com.baidu.tieba.play.c.7
        @Override // com.baidu.tieba.play.s.b
        public void fQ(int i) {
            int duration;
            if (c.this.bJC != null && (duration = c.this.bJC.getDuration()) > 0 && c.this.fAX != null) {
                c.this.fAX.setProgress((int) ((i * c.this.dQt.getWidth()) / duration));
            }
            c.this.ns(i);
        }
    };
    private SeekBar.OnSeekBarChangeListener aYG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && c.this.dQM) {
                c.this.aDL();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aDH() && c.this.aDx() != null) {
                c.this.setStartPosition(c.this.aDx().getSeekPosition());
                c.this.startPlay(c.this.mVideoUrl);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aDM();

        void aDN();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0117c {
        void aWK();

        void kh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aWL();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aWI();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aWM();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface h {
        void aWJ();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dRb = 0;
        if (tbPageContext != null) {
            this.acr = tbPageContext;
            this.dQt = t(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dQt);
            }
            this.dQE = view;
            this.dQt.setOnClickListener(this.mOnClickListener);
            this.bJC = (QuickVideoView) this.dQt.findViewById(d.h.videoView);
            this.det = this.dQt.findViewById(d.h.video_list_layout_loading);
            this.fAW = this.dQt.findViewById(d.h.layout_play_count);
            this.fAV = (TextView) this.dQt.findViewById(d.h.play_count);
            this.dQv = (VideoListMediaControllerView) this.dQt.findViewById(d.h.media_controller);
            this.dQv.setPlayer(this.bJC);
            this.fAX = (ProgressBar) this.dQt.findViewById(d.h.pgrBottomProgress);
            this.fAX.setMax(com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity()));
            this.fAX.setProgress(0);
            this.dQv.setOnSeekBarChangeListener(this.aYG);
            this.dQv.setOnProgressUpdatedListener(this.dTY);
            this.dQw = this.dQt.findViewById(d.h.black_mask);
            this.bJJ = this.dQt.findViewById(d.h.layout_error);
            this.bJJ.setOnClickListener(this.mOnClickListener);
            this.dQx = (FrameLayout) this.dQt.findViewById(d.h.danmu_container);
            this.dQA = (ImageView) this.dQt.findViewById(d.h.img_play_icon);
            this.dQA.setOnClickListener(this.mOnClickListener);
            this.dQB = (ImageView) this.dQt.findViewById(d.h.img_full_screen);
            this.dQB.setOnClickListener(this.mOnClickListener);
            this.dQC = this.dQt.findViewById(d.h.layout_media_controller);
            this.fAY = this.dQt.findViewById(d.h.time_show_controller);
            this.bJC.setOnPreparedListener(this.aUO);
            this.bJC.setOnCompletionListener(this.aUN);
            this.bJC.setOnErrorListener(this.dRi);
            this.bJC.setOnSurfaceDestroyedListener(this.bHP);
            this.bJF = (ImageView) this.dQt.findViewById(d.h.img_play);
            this.bJF.setOnClickListener(this.mOnClickListener);
            this.fAZ = (TextView) this.dQt.findViewById(d.h.txt_replay);
            this.fAZ.setOnClickListener(this.mOnClickListener);
            this.fBa = (TextView) this.dQt.findViewById(d.h.txt_playnext);
            this.fBa.setOnClickListener(this.mOnClickListener);
            this.fBb = (TextView) this.dQt.findViewById(d.h.txt_next_video_title);
            this.dQF = (TbImageView) this.dQt.findViewById(d.h.video_thumbnail);
            this.dQF.setDefaultErrorResource(0);
            this.dQF.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity());
            this.mScreenHeight = getScreenHeight(this.acr.getPageActivity());
            this.dQI = (ImageView) this.dQt.findViewById(d.h.img_exit);
            this.dQI.setOnClickListener(this.mOnClickListener);
            this.dQJ = (TextView) this.dQt.findViewById(d.h.video_title);
            this.bJE = this.dQt.findViewById(d.h.layout_title);
            this.bJE.setVisibility(8);
            this.dQN = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dQf = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.acr.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dQW = this.mAudioManager.getStreamMaxVolume(3);
            this.dRc = this.mAudioManager.getStreamVolume(3);
            dRd = 100 / this.dQW;
            this.dQt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dQK) {
                            if (c.this.mStatus == 1 && c.this.dQY != 0) {
                                c.this.c(c.this.dQY == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dQY = 0;
                                c.this.dQX = 0;
                            }
                            if (!c.this.bJC.isPlaying() && 8 == c.this.bJF.getVisibility()) {
                                c.this.bJF.setVisibility(0);
                                c.this.fBa.setVisibility(8);
                                c.this.fAZ.setVisibility(8);
                                c.this.fBb.setVisibility(8);
                            }
                        }
                        c.this.aDs();
                        if (c.this.fBi != null) {
                            c.this.fBi.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bnc = new o(this.acr.getPageActivity());
            this.bnc.start();
            this.dRb = com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds16);
            this.dRe = new CallStateReceiver();
            this.dRe.register(this.acr.getPageActivity());
            this.acr.registerListener(this.dRo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDs() {
        this.mStatus = 0;
        if (this.dQQ != null && this.dQQ.getParent() != null && (this.dQQ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dQQ.getParent()).removeView(this.dQQ);
                this.dQQ = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dQR != null && this.dQR.getParent() != null && (this.dQR.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dQR.getParent()).removeView(this.dQR);
                this.dQR = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aDt() {
        if (this.mStatus == 1) {
            if (this.dQQ == null && this.dQt != null && (this.dQt instanceof ViewGroup)) {
                LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dQt, true);
                this.dQQ = this.dQt.findViewById(d.h.lay_jindu);
                this.dQS = (TextView) this.dQQ.findViewById(d.h.show_time);
                this.dQV = (ImageView) this.dQQ.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dQR == null && this.dQt != null && (this.dQt instanceof ViewGroup)) {
            LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dQt, true);
            this.dQR = this.dQt.findViewById(d.h.lay_voice);
            this.dQU = (ImageView) this.dQR.findViewById(d.h.arrow_voice_icon);
            this.dQT = (SeekBar) this.dQR.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fBi != null) {
                c.this.fBi.onStart();
            }
            if (c.this.dbr && c.this.dQK) {
                if (!c.this.bJC.isPlaying() && c.this.bJF.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bJF.setVisibility(8);
                    c.this.fBa.setVisibility(8);
                    c.this.fAZ.setVisibility(8);
                    c.this.fBb.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ad(f2);
                    }
                } else {
                    if (c.this.dbr) {
                        c.this.aDv();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dQX = c.this.bJC.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ad(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fBj != null) {
                c.this.fBj.aWJ();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dQK) {
                if (c.this.amR != 2) {
                    c.this.bgd();
                } else {
                    c.this.aWA();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDv() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dQt.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dQt.setSystemUiVisibility(4);
        } else {
            this.dQt.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f2) {
        if (!this.dQK) {
            this.mStatus = 0;
            return;
        }
        aDt();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dRd == 0) {
            if (f2 > 0.0f && this.dRc < this.dQW) {
                this.dRc++;
            }
            if (f2 < 0.0f && this.dRc > 0) {
                this.dRc--;
            }
        }
        if (this.mProgress > 0) {
            this.dQU.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dQU.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dRc, 0);
        this.dQT.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dQX -= 1000;
                this.dQY = 1;
            } else {
                this.dQX += 1000;
                this.dQY = 2;
            }
            if (this.dQX < 0) {
                this.dQX = 0;
            } else if (this.dQX > this.bJC.getDuration()) {
                this.dQX = this.bJC.getDuration();
            }
        }
        aDt();
        String rM = this.dQv.rM(this.dQX);
        if (f2 > 0.0f) {
            this.dQV.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dQV.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rM)) {
            this.dQS.setText(new StringBuilder().append(rM).append("/").append(this.dQv.rM(this.bJC.getDuration())));
        }
        this.dQv.D(this.dQX, z ? false : true);
        this.dQC.setVisibility(8);
        this.fAX.setVisibility(0);
        bga();
    }

    protected View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void aWA() {
        if (!com.baidu.adp.lib.util.i.hr()) {
            com.baidu.adp.lib.util.k.F(this.acr.getPageActivity(), this.acr.getString(d.l.neterror));
        } else if (this.bJC.isPlaying()) {
            pausePlay();
        } else if (this.dQK) {
            aDG();
            if (this.fab != null) {
                this.fab.aWI();
            }
        } else {
            bgc();
        }
    }

    public void aDw() {
        this.dRf = true;
        if (this.bnc != null) {
            this.bnc.aDw();
        }
    }

    public boolean rK(int i) {
        switch (i) {
            case 4:
                if (this.dbr) {
                    aDw();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dQW <= 0 || this.dQT == null) {
                    return false;
                }
                this.dRc = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dRc * 100.0d) / this.dQW);
                this.dQT.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bJC;
    }

    public VideoListMediaControllerView aDx() {
        return this.dQv;
    }

    public void show() {
        this.dQt.setVisibility(0);
    }

    public void aDB() {
        if (this.dQE != null) {
            ViewGroup.LayoutParams layoutParams = this.dQE.getLayoutParams();
            this.dQy = (FrameLayout.LayoutParams) this.dQt.getLayoutParams();
            this.dQy.width = layoutParams.width;
            this.dQy.height = layoutParams.height;
            this.dQy.topMargin = 0;
            this.dQt.setLayoutParams(this.dQy);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dRf) {
            if (this.dbr) {
                TiebaStatic.log(new aj("c11712"));
            } else {
                TiebaStatic.log(new aj("c11711"));
            }
        } else {
            this.dRf = false;
        }
        if (configuration.orientation == 2) {
            this.dbr = true;
            this.dQt.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dQC.setVisibility(0);
            this.bJE.setVisibility(0);
            this.dQI.setVisibility(0);
            this.dQJ.setVisibility(0);
            this.dQx.setVisibility(8);
            if (this.fBe != null) {
                this.fBe.aDM();
            }
            this.dQB.setImageResource(d.g.icon_suoxiao);
            nq(this.dRb);
            aDv();
        } else {
            this.dbr = false;
            if (this.dQy != null) {
                this.dQt.setLayoutParams(this.dQy);
            }
            b(baseActivity, false);
            this.bJE.setVisibility(8);
            this.dQx.setVisibility(0);
            if (this.fBe != null) {
                this.fBe.aDN();
            }
            if (this.amR == 3 && this.fBf != null) {
                this.fBf.kh(false);
            } else if (!this.dQK && this.dQC != null) {
                this.dQC.clearAnimation();
                this.dQC.setVisibility(4);
                this.fAX.setVisibility(0);
                if (this.fBf != null) {
                    this.fBf.aWK();
                }
            }
            aDs();
            this.dQB.setImageResource(d.g.icon_fangda);
            nq(0);
            this.dQt.setSystemUiVisibility(0);
        }
        if (this.bJC.isPlaying()) {
            aDL();
        }
        bga();
    }

    private void bga() {
        if (this.bJC != null) {
            int ag = com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity());
            if (this.dbr) {
                ag = com.baidu.adp.lib.util.k.ah(this.acr.getPageActivity());
            }
            this.fAX.setMax(ag);
            int duration = this.bJC.getDuration();
            if (duration > 0) {
                if (this.fAZ.getVisibility() == 0) {
                    this.fAX.setProgress(this.fAX.getMax());
                } else {
                    this.fAX.setProgress((int) ((this.bJC.getCurrentPosition() * this.fAX.getMax()) / duration));
                }
            }
        }
    }

    private void nq(int i) {
        if (this.dQv != null && (this.dQv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dQv.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dQv.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.fAW.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.det.getVisibility() == 0) {
                this.fAW.setVisibility(0);
            }
        }
    }

    public boolean aDD() {
        return !this.dbr;
    }

    public void a(f.b bVar) {
        this.fBd = bVar;
    }

    public void aDE() {
        this.dQA.setImageResource(d.g.icon_video_midpause);
        this.det.setVisibility(8);
        this.fAW.setVisibility(8);
        this.bJF.setVisibility(0);
        this.fBa.setVisibility(8);
        this.fAZ.setVisibility(8);
        this.fBb.setVisibility(8);
        this.amR = 2;
        this.bJC.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.amR = 0;
        this.bJC.setRecoveryState(0);
        setVideoUrl(str);
        this.bJC.setVideoPath(str);
        this.bJC.start();
        this.det.setVisibility(0);
        if (this.dbr) {
            this.fAW.setVisibility(8);
        } else {
            this.fAW.setVisibility(0);
        }
        this.dQF.setVisibility(0);
        this.bJF.setVisibility(8);
        this.dQA.setImageResource(d.g.icon_video_midplay);
        this.fBa.setVisibility(8);
        this.fAZ.setVisibility(8);
        this.fBb.setVisibility(8);
        this.bJJ.setVisibility(8);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRj);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.dRj, TbConfig.USE_TIME_INTERVAL);
    }

    public void aDG() {
        this.amR = 1;
        this.bJC.setRecoveryState(1);
        this.bJC.start();
        this.dQA.setImageResource(d.g.icon_video_midplay);
        this.dQF.setVisibility(8);
        this.dQw.setVisibility(8);
        this.det.setVisibility(8);
        this.fAW.setVisibility(8);
        this.dQv.showProgress();
        this.bJF.setVisibility(8);
        this.fBa.setVisibility(8);
        this.fAZ.setVisibility(8);
        this.fBb.setVisibility(8);
        bgf();
    }

    public void lv(boolean z) {
        if (this.bJC != null) {
            this.bJC.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bJC.isPlaying()) {
            v.bgA().aq(this.mVideoUrl, this.bJC.getCurrentPosition());
        }
        bge();
        this.bJC.pause();
        aDE();
    }

    public void stopPlay() {
        if (this.bJC.isPlaying()) {
            v.bgA().aq(this.mVideoUrl, this.bJC.getCurrentPosition());
        }
        this.amR = 5;
        this.bJC.setRecoveryState(5);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRh);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRj);
        this.bJC.stopPlayback();
        this.dQK = false;
        this.dQP = 0;
        aqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lw(boolean z) {
        if (this.dQC != null) {
            this.dQw.setVisibility(0);
            this.bJF.setVisibility(0);
            this.fBa.setVisibility(8);
            this.fAZ.setVisibility(8);
            this.fBb.setVisibility(8);
            this.det.setVisibility(8);
            this.fAW.setVisibility(8);
            this.dQA.setImageResource(d.g.icon_video_midpause);
            this.dQC.setVisibility(4);
            this.fAX.setVisibility(8);
            this.bJJ.setVisibility(8);
            this.dQv.Ld();
            this.dQF.setVisibility(z ? 0 : 8);
        }
    }

    public void aqe() {
        lw(true);
    }

    public boolean bgb() {
        if (this.bJC == null) {
            return false;
        }
        return this.bJC.isPlaying();
    }

    public void a(f fVar) {
        this.fBh = fVar;
    }

    public void a(e eVar) {
        this.fab = eVar;
    }

    public void a(d dVar) {
        this.fBg = dVar;
    }

    public void pU(String str) {
        this.eZJ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgc() {
        qM(this.mVideoUrl);
    }

    public void b(InterfaceC0117c interfaceC0117c) {
        this.fBf = interfaceC0117c;
    }

    public void qM(final String str) {
        if (com.baidu.adp.lib.util.i.ht()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.acr.getPageActivity());
                aVar.cW(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
                aVar.a(d.l.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
                        c.this.startPlay(str);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.l.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.acr).ts();
                return;
            }
            if (!this.fAU) {
                this.fAU = true;
                com.baidu.adp.lib.util.k.showToast(this.acr.getPageActivity(), d.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void nm(String str) {
        this.dQF.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRn);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRh);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRj);
        this.bnc.stop();
        this.dRe.unregister(this.acr.getPageActivity());
    }

    public void qN(String str) {
        this.dQJ.setText(str);
    }

    public void bU(long j) {
        this.fAV.setText(al.u(j));
    }

    public boolean aDH() {
        return this.dQK;
    }

    public void clearAnimation() {
        aDK();
    }

    public void aDI() {
        if (this.dQC != null) {
            aDK();
            this.dQC.setVisibility(0);
            this.fAY.setVisibility(0);
            if (this.fBf != null) {
                this.fBf.kh(true);
            }
            this.fAX.setVisibility(8);
            this.dQN.setAnimationListener(this.dRl);
            this.dQC.startAnimation(this.dQN);
            this.dQM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgd() {
        if (this.dQC != null) {
            if (this.dQC.getVisibility() == 0) {
                aDK();
                this.dQC.setVisibility(8);
                this.fAX.setVisibility(0);
                if (this.fBf != null) {
                    this.fBf.aWK();
                    return;
                }
                return;
            }
            aDL();
        }
    }

    public void aDJ() {
        if (this.dQC != null) {
            aDK();
            this.dQC.setVisibility(0);
            this.fAY.setVisibility(0);
            if (this.fBf != null) {
                this.fBf.kh(false);
            }
            this.fAX.setVisibility(8);
            this.dQf.setAnimationListener(this.dRm);
            this.dQC.startAnimation(this.dQf);
        }
    }

    public void bge() {
        if (this.dQC != null) {
            aDK();
            this.dQC.setVisibility(0);
            this.fAY.setVisibility(0);
            this.fAX.setVisibility(8);
            if (this.fBf != null) {
                this.fBf.kh(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDK() {
        if (this.dQC != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRn);
            this.dQf.setAnimationListener(null);
            this.dQN.setAnimationListener(null);
            this.dQC.clearAnimation();
            this.dQM = false;
        }
    }

    public void aDL() {
        aDJ();
        bgf();
    }

    private void bgf() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dRn);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.dRn, 3000L);
    }

    public void a(b bVar) {
        this.fBe = bVar;
    }

    public void ns(int i) {
        if (this.bJC.getDuration() - i <= 3000) {
            aDK();
            if (this.dQC != null) {
                this.dQC.setVisibility(0);
                this.fAY.setVisibility(0);
                this.fAX.setVisibility(8);
                if (this.fBf != null) {
                    this.fBf.kh(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dQP = i;
    }

    public void lx(boolean z) {
        if (this.bnc != null) {
            if (this.dQB != null) {
                this.dQB.setVisibility(z ? 0 : 8);
            }
            this.bnc.ly(z);
        }
    }

    public int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.k.ah(context);
        }
        return i;
    }

    public int bgg() {
        return this.amR;
    }

    public void a(h hVar) {
        this.fBj = hVar;
    }
}
