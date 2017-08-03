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
    private static int dNQ;
    private TbPageContext<?> aaS;
    private QuickVideoView bHI;
    private View bHK;
    private ImageView bHL;
    private View bHP;
    private o blI;
    private Animation dMS;
    private Animation dNA;
    private View dND;
    private View dNE;
    private TextView dNF;
    private SeekBar dNG;
    private ImageView dNH;
    private ImageView dNI;
    private int dNJ;
    private int dNO;
    private int dNP;
    private CallStateReceiver dNR;
    protected View dNg;
    private VideoListMediaControllerView dNi;
    private View dNj;
    private FrameLayout dNk;
    protected FrameLayout.LayoutParams dNl;
    private ImageView dNn;
    private ImageView dNo;
    private View dNp;
    private View dNr;
    private TbImageView dNs;
    private f.d dNt;
    private ImageView dNv;
    private TextView dNw;
    private View dbb;
    private e eWU;
    private TextView fxO;
    private View fxP;
    private ProgressBar fxQ;
    private View fxR;
    private TextView fxS;
    private TextView fxT;
    private TextView fxU;
    private f.a fxV;
    private f.b fxW;
    private b fxX;
    private InterfaceC0117c fxY;
    private d fxZ;
    private f fya;
    private g fyb;
    private h fyc;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean fxN = false;
    protected boolean cXZ = false;
    private boolean dNx = false;
    private boolean dNz = false;
    private int dNC = 0;
    private int mStatus = 0;
    private int dNK = 0;
    private int dNL = 0;
    private boolean dNS = false;
    private String eWC = null;
    private int alx = -1;
    private f.d aTA = new f.d() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.f.d
        public void onPrepared(com.baidu.tieba.play.f fVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dNU);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dNU, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dNW);
            if (c.this.bHI.bfz()) {
                c.this.alx = 1;
                c.this.bHI.setRecoveryState(1);
            }
            if (fVar != null && c.this.dNi != null) {
                c.this.dNC = v.bfP().qD(c.this.mVideoUrl);
                c.this.dNi.T(c.this.dNC, fVar.getDuration());
                if (c.this.dNC != 0) {
                    fVar.seekTo(c.this.dNC);
                }
            }
        }
    };
    private Runnable dNU = new Runnable() { // from class: com.baidu.tieba.play.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bHI.getCurrentPosition() > 100) {
                c.this.dNx = true;
                c.this.dNj.setVisibility(8);
                c.this.bHP.setVisibility(8);
                c.this.dbb.setVisibility(8);
                c.this.fxP.setVisibility(8);
                c.this.dNs.setVisibility(8);
                c.this.aCX();
                if (c.this.alx == 1 || c.this.alx == 2) {
                    if (c.this.dNp != null) {
                        c.this.dNp.setVisibility(0);
                        c.this.fxR.setVisibility(0);
                        c.this.fxQ.setVisibility(8);
                        if (c.this.fxY != null) {
                            c.this.fxY.ke(false);
                        }
                    }
                    c.this.dNi.showProgress();
                    c.this.aCY();
                }
                if (c.this.dNt != null) {
                    c.this.dNt.onPrepared(c.this.bHI.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dNU, 20L);
        }
    };
    private f.a aTz = new f.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.f.a
        public void onCompletion(com.baidu.tieba.play.f fVar) {
            c.this.dNx = false;
            c.this.dNC = 0;
            c.this.aCF();
            c.this.dNj.setVisibility(0);
            c.this.fxQ.setVisibility(8);
            c.this.fxQ.setProgress(c.this.fxQ.getMax());
            if (c.this.fxY != null) {
                c.this.fxY.ke(false);
            }
            if (c.this.cXZ) {
                c.this.dNp.setVisibility(0);
                c.this.dNv.setVisibility(0);
                c.this.dNw.setVisibility(0);
                c.this.fxR.setVisibility(8);
            } else {
                c.this.dNp.setVisibility(8);
                c.this.dNv.setVisibility(8);
                c.this.dNw.setVisibility(8);
                c.this.fxR.setVisibility(8);
            }
            if (c.this.bHI == null || c.this.bHI.getDuration() > 150000) {
                c.this.lt(false);
            } else {
                c.this.fxS.setVisibility(0);
            }
            v.bfP().remove(c.this.mVideoUrl);
            if (c.this.fxV != null) {
                c.this.fxV.onCompletion(fVar);
            }
            c.this.alx = 3;
            c.this.bHI.setRecoveryState(3);
            if (!c.this.cXZ && c.this.bHI != null && c.this.bHI.getDuration() <= 150000) {
                if (c.this.fya != null) {
                    c.this.fya.aVZ();
                }
                c.this.startPlay(c.this.mVideoUrl);
            }
        }
    };
    private f.b dNV = new f.b() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.f.b
        public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
            c.this.bHP.setVisibility(0);
            c.this.dbb.setVisibility(8);
            c.this.fxP.setVisibility(8);
            c.this.alx = 4;
            c.this.bHI.setRecoveryState(4);
            if (c.this.fxW != null) {
                c.this.fxW.onError(fVar, i, i2);
                return true;
            }
            return true;
        }
    };
    private Runnable dNW = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            c.this.bHP.setVisibility(0);
            c.this.dbb.setVisibility(8);
            c.this.fxP.setVisibility(8);
        }
    };
    private QuickVideoView.b bFV = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dNx = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dNU);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dNW);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bHP.getId()) {
                c.this.bfr();
            } else if (view.getId() != c.this.bHL.getId() && view.getId() != c.this.dNn.getId()) {
                if (view.getId() == c.this.fxT.getId()) {
                    if (c.this.fxZ != null) {
                        c.this.fxZ.aVY();
                    }
                } else if (view.getId() == c.this.fxS.getId()) {
                    if (c.this.fya != null) {
                        c.this.fya.aVZ();
                    }
                    c.this.startPlay(c.this.mVideoUrl);
                } else if (view.getId() != c.this.dNo.getId()) {
                    if (view.getId() == c.this.dNv.getId()) {
                        TiebaStatic.log(new aj("c11713"));
                        c.this.aCJ();
                    }
                } else {
                    if (c.this.cXZ) {
                        TiebaStatic.log(new aj("c11714"));
                    } else {
                        TiebaStatic.log(new aj("c11710"));
                    }
                    c.this.aCJ();
                }
            } else {
                c.this.aVN();
            }
        }
    };
    private Animation.AnimationListener dNY = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dNp != null) {
                c.this.dNp.setVisibility(8);
                c.this.fxQ.setVisibility(0);
                c.this.dNz = false;
                if (c.this.fxY != null) {
                    c.this.fxY.aVX();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dNZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.4
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
    private Runnable dOa = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aCV();
        }
    };
    private CustomMessageListener dOb = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private s.b dQL = new s.b() { // from class: com.baidu.tieba.play.c.7
        @Override // com.baidu.tieba.play.s.b
        public void fO(int i) {
            int duration;
            if (c.this.bHI != null && (duration = c.this.bHI.getDuration()) > 0 && c.this.fxQ != null) {
                c.this.fxQ.setProgress((int) ((i * c.this.dNg.getWidth()) / duration));
            }
            c.this.ni(i);
        }
    };
    private SeekBar.OnSeekBarChangeListener aXt = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && c.this.dNz) {
                c.this.aCY();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aCU() && c.this.aCK() != null) {
                c.this.setStartPosition(c.this.aCK().getSeekPosition());
                c.this.startPlay(c.this.mVideoUrl);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aCZ();

        void aDa();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0117c {
        void aVX();

        void ke(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aVY();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aVV();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aVZ();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface h {
        void aVW();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dNO = 0;
        if (tbPageContext != null) {
            this.aaS = tbPageContext;
            this.dNg = t(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dNg);
            }
            this.dNr = view;
            this.dNg.setOnClickListener(this.mOnClickListener);
            this.bHI = (QuickVideoView) this.dNg.findViewById(d.h.videoView);
            this.dbb = this.dNg.findViewById(d.h.video_list_layout_loading);
            this.fxP = this.dNg.findViewById(d.h.layout_play_count);
            this.fxO = (TextView) this.dNg.findViewById(d.h.play_count);
            this.dNi = (VideoListMediaControllerView) this.dNg.findViewById(d.h.media_controller);
            this.dNi.setPlayer(this.bHI);
            this.fxQ = (ProgressBar) this.dNg.findViewById(d.h.pgrBottomProgress);
            this.fxQ.setMax(com.baidu.adp.lib.util.k.af(this.aaS.getPageActivity()));
            this.fxQ.setProgress(0);
            this.dNi.setOnSeekBarChangeListener(this.aXt);
            this.dNi.setOnProgressUpdatedListener(this.dQL);
            this.dNj = this.dNg.findViewById(d.h.black_mask);
            this.bHP = this.dNg.findViewById(d.h.layout_error);
            this.bHP.setOnClickListener(this.mOnClickListener);
            this.dNk = (FrameLayout) this.dNg.findViewById(d.h.danmu_container);
            this.dNn = (ImageView) this.dNg.findViewById(d.h.img_play_icon);
            this.dNn.setOnClickListener(this.mOnClickListener);
            this.dNo = (ImageView) this.dNg.findViewById(d.h.img_full_screen);
            this.dNo.setOnClickListener(this.mOnClickListener);
            this.dNp = this.dNg.findViewById(d.h.layout_media_controller);
            this.fxR = this.dNg.findViewById(d.h.time_show_controller);
            this.bHI.setOnPreparedListener(this.aTA);
            this.bHI.setOnCompletionListener(this.aTz);
            this.bHI.setOnErrorListener(this.dNV);
            this.bHI.setOnSurfaceDestroyedListener(this.bFV);
            this.bHL = (ImageView) this.dNg.findViewById(d.h.img_play);
            this.bHL.setOnClickListener(this.mOnClickListener);
            this.fxS = (TextView) this.dNg.findViewById(d.h.txt_replay);
            this.fxS.setOnClickListener(this.mOnClickListener);
            this.fxT = (TextView) this.dNg.findViewById(d.h.txt_playnext);
            this.fxT.setOnClickListener(this.mOnClickListener);
            this.fxU = (TextView) this.dNg.findViewById(d.h.txt_next_video_title);
            this.dNs = (TbImageView) this.dNg.findViewById(d.h.video_thumbnail);
            this.dNs.setDefaultErrorResource(0);
            this.dNs.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.af(this.aaS.getPageActivity());
            this.mScreenHeight = bx(this.aaS.getPageActivity());
            this.dNv = (ImageView) this.dNg.findViewById(d.h.img_exit);
            this.dNv.setOnClickListener(this.mOnClickListener);
            this.dNw = (TextView) this.dNg.findViewById(d.h.video_title);
            this.bHK = this.dNg.findViewById(d.h.layout_title);
            this.bHK.setVisibility(8);
            this.dNA = AnimationUtils.loadAnimation(this.aaS.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dMS = AnimationUtils.loadAnimation(this.aaS.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aaS.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dNJ = this.mAudioManager.getStreamMaxVolume(3);
            this.dNP = this.mAudioManager.getStreamVolume(3);
            dNQ = 100 / this.dNJ;
            this.dNg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dNx) {
                            if (c.this.mStatus == 1 && c.this.dNL != 0) {
                                c.this.c(c.this.dNL == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dNL = 0;
                                c.this.dNK = 0;
                            }
                            if (!c.this.bHI.isPlaying() && 8 == c.this.bHL.getVisibility()) {
                                c.this.bHL.setVisibility(0);
                                c.this.fxT.setVisibility(8);
                                c.this.fxS.setVisibility(8);
                                c.this.fxU.setVisibility(8);
                            }
                        }
                        c.this.aCF();
                        if (c.this.fyb != null) {
                            c.this.fyb.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.blI = new o(this.aaS.getPageActivity());
            this.blI.start();
            this.dNO = com.baidu.adp.lib.util.k.g(this.aaS.getPageActivity(), d.f.ds16);
            this.dNR = new CallStateReceiver();
            this.dNR.register(this.aaS.getPageActivity());
            this.aaS.registerListener(this.dOb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCF() {
        this.mStatus = 0;
        if (this.dND != null && this.dND.getParent() != null && (this.dND.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dND.getParent()).removeView(this.dND);
                this.dND = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dNE != null && this.dNE.getParent() != null && (this.dNE.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dNE.getParent()).removeView(this.dNE);
                this.dNE = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aCG() {
        if (this.mStatus == 1) {
            if (this.dND == null && this.dNg != null && (this.dNg instanceof ViewGroup)) {
                LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dNg, true);
                this.dND = this.dNg.findViewById(d.h.lay_jindu);
                this.dNF = (TextView) this.dND.findViewById(d.h.show_time);
                this.dNI = (ImageView) this.dND.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dNE == null && this.dNg != null && (this.dNg instanceof ViewGroup)) {
            LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dNg, true);
            this.dNE = this.dNg.findViewById(d.h.lay_voice);
            this.dNH = (ImageView) this.dNE.findViewById(d.h.arrow_voice_icon);
            this.dNG = (SeekBar) this.dNE.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fyb != null) {
                c.this.fyb.onStart();
            }
            if (c.this.cXZ && c.this.dNx) {
                if (!c.this.bHI.isPlaying() && c.this.bHL.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bHL.setVisibility(8);
                    c.this.fxT.setVisibility(8);
                    c.this.fxS.setVisibility(8);
                    c.this.fxU.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ad(f2);
                    }
                } else {
                    if (c.this.cXZ) {
                        c.this.aCI();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dNK = c.this.bHI.getCurrentPosition();
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
            if (c.this.fyc != null) {
                c.this.fyc.aVW();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dNx) {
                if (c.this.alx != 2) {
                    c.this.bfs();
                } else {
                    c.this.aVN();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCI() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dNg.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dNg.setSystemUiVisibility(4);
        } else {
            this.dNg.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f2) {
        if (!this.dNx) {
            this.mStatus = 0;
            return;
        }
        aCG();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dNQ == 0) {
            if (f2 > 0.0f && this.dNP < this.dNJ) {
                this.dNP++;
            }
            if (f2 < 0.0f && this.dNP > 0) {
                this.dNP--;
            }
        }
        if (this.mProgress > 0) {
            this.dNH.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dNH.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dNP, 0);
        this.dNG.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dNK -= 1000;
                this.dNL = 1;
            } else {
                this.dNK += 1000;
                this.dNL = 2;
            }
            if (this.dNK < 0) {
                this.dNK = 0;
            } else if (this.dNK > this.bHI.getDuration()) {
                this.dNK = this.bHI.getDuration();
            }
        }
        aCG();
        String rC = this.dNi.rC(this.dNK);
        if (f2 > 0.0f) {
            this.dNI.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dNI.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rC)) {
            this.dNF.setText(new StringBuilder().append(rC).append("/").append(this.dNi.rC(this.bHI.getDuration())));
        }
        this.dNi.C(this.dNK, z ? false : true);
        this.dNp.setVisibility(8);
        this.fxQ.setVisibility(0);
        bfp();
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

    public void aVN() {
        if (!com.baidu.adp.lib.util.i.hh()) {
            com.baidu.adp.lib.util.k.F(this.aaS.getPageActivity(), this.aaS.getString(d.l.neterror));
        } else if (this.bHI.isPlaying()) {
            pausePlay();
        } else if (this.dNx) {
            aCT();
            if (this.eWU != null) {
                this.eWU.aVV();
            }
        } else {
            bfr();
        }
    }

    public void aCJ() {
        this.dNS = true;
        if (this.blI != null) {
            this.blI.aCJ();
        }
    }

    public boolean rA(int i) {
        switch (i) {
            case 4:
                if (this.cXZ) {
                    aCJ();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dNJ <= 0 || this.dNG == null) {
                    return false;
                }
                this.dNP = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dNP * 100.0d) / this.dNJ);
                this.dNG.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bHI;
    }

    public VideoListMediaControllerView aCK() {
        return this.dNi;
    }

    public void show() {
        this.dNg.setVisibility(0);
    }

    public void aCO() {
        if (this.dNr != null) {
            ViewGroup.LayoutParams layoutParams = this.dNr.getLayoutParams();
            this.dNl = (FrameLayout.LayoutParams) this.dNg.getLayoutParams();
            this.dNl.width = layoutParams.width;
            this.dNl.height = layoutParams.height;
            this.dNl.topMargin = 0;
            this.dNg.setLayoutParams(this.dNl);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dNS) {
            if (this.cXZ) {
                TiebaStatic.log(new aj("c11712"));
            } else {
                TiebaStatic.log(new aj("c11711"));
            }
        } else {
            this.dNS = false;
        }
        if (configuration.orientation == 2) {
            this.cXZ = true;
            this.dNg.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dNp.setVisibility(0);
            this.bHK.setVisibility(0);
            this.dNv.setVisibility(0);
            this.dNw.setVisibility(0);
            this.dNk.setVisibility(8);
            if (this.fxX != null) {
                this.fxX.aCZ();
            }
            this.dNo.setImageResource(d.g.icon_suoxiao);
            ng(this.dNO);
            aCI();
        } else {
            this.cXZ = false;
            if (this.dNl != null) {
                this.dNg.setLayoutParams(this.dNl);
            }
            b(baseActivity, false);
            this.bHK.setVisibility(8);
            this.dNk.setVisibility(0);
            if (this.fxX != null) {
                this.fxX.aDa();
            }
            if (this.alx == 3 && this.fxY != null) {
                this.fxY.ke(false);
            } else if (!this.dNx && this.dNp != null) {
                this.dNp.clearAnimation();
                this.dNp.setVisibility(4);
                this.fxQ.setVisibility(0);
                if (this.fxY != null) {
                    this.fxY.aVX();
                }
            }
            aCF();
            this.dNo.setImageResource(d.g.icon_fangda);
            ng(0);
            this.dNg.setSystemUiVisibility(0);
        }
        if (this.bHI.isPlaying()) {
            aCY();
        }
        bfp();
    }

    private void bfp() {
        if (this.bHI != null) {
            int af = com.baidu.adp.lib.util.k.af(this.aaS.getPageActivity());
            if (this.cXZ) {
                af = com.baidu.adp.lib.util.k.ag(this.aaS.getPageActivity());
            }
            this.fxQ.setMax(af);
            int duration = this.bHI.getDuration();
            if (duration > 0) {
                if (this.fxS.getVisibility() == 0) {
                    this.fxQ.setProgress(this.fxQ.getMax());
                } else {
                    this.fxQ.setProgress((int) ((this.bHI.getCurrentPosition() * this.fxQ.getMax()) / duration));
                }
            }
        }
    }

    private void ng(int i) {
        if (this.dNi != null && (this.dNi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dNi.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dNi.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.fxP.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.dbb.getVisibility() == 0) {
                this.fxP.setVisibility(0);
            }
        }
    }

    public boolean aCQ() {
        return !this.cXZ;
    }

    public void a(f.b bVar) {
        this.fxW = bVar;
    }

    public void aCR() {
        this.dNn.setImageResource(d.g.icon_video_midpause);
        this.dbb.setVisibility(8);
        this.fxP.setVisibility(8);
        this.bHL.setVisibility(0);
        this.fxT.setVisibility(8);
        this.fxS.setVisibility(8);
        this.fxU.setVisibility(8);
        this.alx = 2;
        this.bHI.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.alx = 0;
        this.bHI.setRecoveryState(0);
        setVideoUrl(str);
        this.bHI.setVideoPath(str);
        this.bHI.start();
        this.dbb.setVisibility(0);
        if (this.cXZ) {
            this.fxP.setVisibility(8);
        } else {
            this.fxP.setVisibility(0);
        }
        this.dNs.setVisibility(0);
        this.bHL.setVisibility(8);
        this.dNn.setImageResource(d.g.icon_video_midplay);
        this.fxT.setVisibility(8);
        this.fxS.setVisibility(8);
        this.fxU.setVisibility(8);
        this.bHP.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dNW);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.dNW, TbConfig.USE_TIME_INTERVAL);
    }

    public void aCT() {
        this.alx = 1;
        this.bHI.setRecoveryState(1);
        this.bHI.start();
        this.dNn.setImageResource(d.g.icon_video_midplay);
        this.dNs.setVisibility(8);
        this.dNj.setVisibility(8);
        this.dbb.setVisibility(8);
        this.fxP.setVisibility(8);
        this.dNi.showProgress();
        this.bHL.setVisibility(8);
        this.fxT.setVisibility(8);
        this.fxS.setVisibility(8);
        this.fxU.setVisibility(8);
        bfu();
    }

    public void ls(boolean z) {
        if (this.bHI != null) {
            this.bHI.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bHI.isPlaying()) {
            v.bfP().aq(this.mVideoUrl, this.bHI.getCurrentPosition());
        }
        bft();
        this.bHI.pause();
        aCR();
    }

    public void stopPlay() {
        if (this.bHI.isPlaying()) {
            v.bfP().aq(this.mVideoUrl, this.bHI.getCurrentPosition());
        }
        this.alx = 5;
        this.bHI.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dNU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dNW);
        this.bHI.stopPlayback();
        this.dNx = false;
        this.dNC = 0;
        apr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (this.dNp != null) {
            this.dNj.setVisibility(0);
            this.bHL.setVisibility(0);
            this.fxT.setVisibility(8);
            this.fxS.setVisibility(8);
            this.fxU.setVisibility(8);
            this.dbb.setVisibility(8);
            this.fxP.setVisibility(8);
            this.dNn.setImageResource(d.g.icon_video_midpause);
            this.dNp.setVisibility(4);
            this.fxQ.setVisibility(8);
            this.bHP.setVisibility(8);
            this.dNi.KY();
            this.dNs.setVisibility(z ? 0 : 8);
        }
    }

    public void apr() {
        lt(true);
    }

    public boolean bfq() {
        if (this.bHI == null) {
            return false;
        }
        return this.bHI.isPlaying();
    }

    public void a(f fVar) {
        this.fya = fVar;
    }

    public void a(e eVar) {
        this.eWU = eVar;
    }

    public void a(d dVar) {
        this.fxZ = dVar;
    }

    public void pI(String str) {
        this.eWC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfr() {
        qA(this.mVideoUrl);
    }

    public void b(InterfaceC0117c interfaceC0117c) {
        this.fxY = interfaceC0117c;
    }

    public void qA(final String str) {
        if (com.baidu.adp.lib.util.i.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaS.getPageActivity());
                aVar.cN(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
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
                aVar.b(this.aaS).th();
                return;
            }
            if (!this.fxN) {
                this.fxN = true;
                com.baidu.adp.lib.util.k.showToast(this.aaS.getPageActivity(), d.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void mZ(String str) {
        this.dNs.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dOa);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dNU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dNW);
        this.blI.stop();
        this.dNR.unregister(this.aaS.getPageActivity());
    }

    public void qB(String str) {
        this.dNw.setText(str);
    }

    public void bU(long j) {
        this.fxO.setText(al.u(j));
    }

    public boolean aCU() {
        return this.dNx;
    }

    public void clearAnimation() {
        aCX();
    }

    public void aCV() {
        if (this.dNp != null) {
            aCX();
            this.dNp.setVisibility(0);
            this.fxR.setVisibility(0);
            if (this.fxY != null) {
                this.fxY.ke(true);
            }
            this.fxQ.setVisibility(8);
            this.dNA.setAnimationListener(this.dNY);
            this.dNp.startAnimation(this.dNA);
            this.dNz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfs() {
        if (this.dNp != null) {
            if (this.dNp.getVisibility() == 0) {
                aCX();
                this.dNp.setVisibility(8);
                this.fxQ.setVisibility(0);
                if (this.fxY != null) {
                    this.fxY.aVX();
                    return;
                }
                return;
            }
            aCY();
        }
    }

    public void aCW() {
        if (this.dNp != null) {
            aCX();
            this.dNp.setVisibility(0);
            this.fxR.setVisibility(0);
            if (this.fxY != null) {
                this.fxY.ke(false);
            }
            this.fxQ.setVisibility(8);
            this.dMS.setAnimationListener(this.dNZ);
            this.dNp.startAnimation(this.dMS);
        }
    }

    public void bft() {
        if (this.dNp != null) {
            aCX();
            this.dNp.setVisibility(0);
            this.fxR.setVisibility(0);
            this.fxQ.setVisibility(8);
            if (this.fxY != null) {
                this.fxY.ke(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCX() {
        if (this.dNp != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dOa);
            this.dMS.setAnimationListener(null);
            this.dNA.setAnimationListener(null);
            this.dNp.clearAnimation();
            this.dNz = false;
        }
    }

    public void aCY() {
        aCW();
        bfu();
    }

    private void bfu() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dOa);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.dOa, 3000L);
    }

    public void a(b bVar) {
        this.fxX = bVar;
    }

    public void ni(int i) {
        if (this.bHI.getDuration() - i <= 3000) {
            aCX();
            if (this.dNp != null) {
                this.dNp.setVisibility(0);
                this.fxR.setVisibility(0);
                this.fxQ.setVisibility(8);
                if (this.fxY != null) {
                    this.fxY.ke(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dNC = i;
    }

    public void lu(boolean z) {
        if (this.blI != null) {
            if (this.dNo != null) {
                this.dNo.setVisibility(z ? 0 : 8);
            }
            this.blI.lv(z);
        }
    }

    public int bx(Context context) {
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
            return com.baidu.adp.lib.util.k.ag(context);
        }
        return i;
    }

    public int bfv() {
        return this.alx;
    }

    public void a(h hVar) {
        this.fyc = hVar;
    }
}
