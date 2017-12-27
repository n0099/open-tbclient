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
    private static int eVy;
    private TbPageContext<?> aQq;
    private String bAK;
    private String bOw;
    private QuickVideoView bYA;
    private com.baidu.tieba.play.g cOT;
    private y cOY;
    private View cRK;
    private ImageView cRL;
    private View cRP;
    private p ckQ;
    private Animation dAw;
    private Animation dAx;
    protected View eUQ;
    private VideoListMediaControllerView eUS;
    private View eUT;
    private FrameLayout eUU;
    protected FrameLayout.LayoutParams eUV;
    private ImageView eUX;
    private ImageView eUY;
    private View eUZ;
    private View eVb;
    private TbImageView eVc;
    private g.f eVd;
    private ImageView eVf;
    private TextView eVg;
    private View eVl;
    private View eVm;
    private TextView eVn;
    private SeekBar eVo;
    private ImageView eVp;
    private ImageView eVq;
    private int eVr;
    private int eVw;
    private int eVx;
    private CallStateReceiver eVz;
    private g fXx;
    private ProgressBar gBP;
    private View gBQ;
    private View gBR;
    private TextView gBS;
    private TextView gBT;
    private TextView gBU;
    private g.a gBV;
    private g.b gBW;
    private b gBY;
    private InterfaceC0149c gBZ;
    private f gCa;
    private h gCb;
    private i gCc;
    private k gCd;
    private j gCe;
    private e gCf;
    private TextView gCk;
    private boolean gCm;
    private boolean gCn;
    private boolean gCo;
    private int gCp;
    private boolean gCq;
    private boolean gCr;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean gBO = false;
    protected boolean eib = false;
    private boolean eVh = false;
    private boolean eVj = false;
    private boolean gBX = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eVs = 0;
    private int eVt = 0;
    private boolean eVA = false;
    private boolean gCg = true;
    private boolean gCh = true;
    private boolean gCi = false;
    private boolean gCj = false;
    private String fXb = null;
    private int bal = -1;
    private boolean gCl = false;
    private g.f bNf = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cOT = gVar;
            if (c.this.bql()) {
                c.this.cOY.bri();
                c.this.gCq = true;
                return;
            }
            c.this.ajg();
        }
    };
    private VideoLoadingProgressView.a cPi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.ajg();
        }
    };
    private Runnable eVC = new Runnable() { // from class: com.baidu.tieba.play.c.15
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bYA.getCurrentPosition() > 100) {
                c.this.eVh = true;
                c.this.eUT.setVisibility(8);
                c.this.cRP.setVisibility(8);
                c.this.cOY.brj();
                c.this.eVc.setVisibility(8);
                c.this.aOL();
                if (c.this.bal == 1 || c.this.bal == 2) {
                    if (c.this.eUZ != null) {
                        c.this.eUZ.setVisibility(0);
                        c.this.gBR.setVisibility(0);
                        c.this.gBP.setVisibility(8);
                        if (c.this.gBZ != null) {
                            c.this.gBZ.fO(false);
                        }
                    }
                    c.this.eUS.showProgress();
                    c.this.aOM();
                }
                if (c.this.eVd != null) {
                    c.this.eVd.onPrepared(c.this.bYA.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eVC, 20L);
        }
    };
    private g.a bNe = new g.a() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eVh = false;
            c.this.gCo = false;
            c.this.mStartPosition = 0;
            c.this.aOt();
            c.this.eUT.setVisibility(0);
            c.this.gBP.setVisibility(8);
            c.this.gBP.setProgress(c.this.gBP.getMax());
            if (c.this.gBZ != null) {
                c.this.gBZ.fO(false);
            }
            if (c.this.eib) {
                c.this.eUZ.setVisibility(0);
                c.this.eVf.setVisibility(0);
                c.this.eVg.setVisibility(0);
                c.this.gBR.setVisibility(8);
            } else {
                c.this.eUZ.setVisibility(8);
                c.this.eVf.setVisibility(8);
                c.this.eVg.setVisibility(8);
                c.this.gBR.setVisibility(8);
            }
            if (c.this.bYA == null || c.this.bYA.getDuration() > 150000) {
                c.this.mx(false);
            } else {
                c.this.gBS.setVisibility(0);
            }
            z.bro().remove(c.this.bOw);
            if (c.this.gBV != null) {
                c.this.gBV.onCompletion(gVar);
            }
            c.this.bal = 3;
            c.this.bYA.setRecoveryState(3);
            if (!c.this.eib && c.this.bYA != null && c.this.bYA.getDuration() <= 150000) {
                if (!c.this.gCl) {
                    if (c.this.gCb != null) {
                        c.this.gCb.kX(true);
                    }
                    c.this.bQ(c.this.bOw, c.this.bAK);
                    return;
                }
                c.this.bal = 5;
                c.this.bYA.setRecoveryState(5);
                c.this.bYA.getPlayer().pause();
                c.this.bYA.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eVD = new g.b() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cRP.setVisibility(0);
            c.this.cOY.brk();
            c.this.bal = 4;
            c.this.bYA.setRecoveryState(4);
            if (c.this.gBW != null) {
                c.this.gBW.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.oI()) {
                c.this.gCm = true;
            }
            c.this.gCo = false;
            return true;
        }
    };
    private Runnable eVE = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            c.this.cRP.setVisibility(0);
            c.this.cOY.brk();
        }
    };
    private g.InterfaceC0150g bNj = new g.InterfaceC0150g() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.InterfaceC0150g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.gCi) {
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.gCs, 200L);
            }
        }
    };
    private Runnable gCs = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bYA == null || !c.this.gCi) {
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eVC, 200L);
                c.this.gCi = false;
            } else if (c.this.mStartPosition != c.this.bYA.getCurrentPosition()) {
                c.this.gCi = false;
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eVC, 20L);
            } else {
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.gCs, 200L);
            }
        }
    };
    private QuickVideoView.b bYH = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eVh = false;
            c.this.gCo = false;
            com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eVC);
            com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eVE);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cRP.getId()) {
                c.this.bqq();
            } else if (view.getId() != c.this.cRL.getId() && view.getId() != c.this.eUX.getId()) {
                if (view.getId() == c.this.gBT.getId()) {
                    if (c.this.gCa != null) {
                        c.this.gCa.bfT();
                    }
                } else if (view.getId() == c.this.gBS.getId()) {
                    if (c.this.gCb != null) {
                        c.this.gCb.kX(false);
                    }
                    c.this.bQ(c.this.bOw, c.this.bAK);
                } else if (view.getId() != c.this.eUY.getId() && view.getId() != c.this.gBQ.getId()) {
                    if (view.getId() == c.this.eVf.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.gCe != null) {
                            c.this.gCe.auz();
                        }
                        c.this.aOx();
                    }
                } else {
                    if (c.this.eib) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.gCe != null) {
                        c.this.gCe.auz();
                    }
                    c.this.aOx();
                }
            } else {
                c.this.bfK();
            }
        }
    };
    private Animation.AnimationListener eVG = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eUZ != null) {
                c.this.eUZ.setVisibility(8);
                c.this.gBP.setVisibility(0);
                c.this.eVj = false;
                if (c.this.gBZ != null) {
                    c.this.gBZ.auA();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eVH = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable eVI = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aOJ();
        }
    };
    private CustomMessageListener eVJ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private v.b eYt = new v.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.v.b
        public void jw(int i2) {
            int duration;
            if (c.this.bYA != null && (duration = c.this.bYA.getDuration()) > 0 && c.this.gBP != null) {
                c.this.gBP.setProgress((int) ((i2 * c.this.eUQ.getWidth()) / duration));
            }
            c.this.rk(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bRp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eVj) {
                c.this.aOM();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aOI() && c.this.aOy() != null) {
                c.this.setStartPosition(c.this.aOy().getSeekPosition());
                c.this.bQ(c.this.bOw, c.this.bAK);
            }
        }
    };
    private QuickVideoView.a gCt = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bqw() {
            if (!c.this.gCl) {
                c.this.cOY.startLoading();
                c.this.eVc.setVisibility(0);
                c.this.cRL.setVisibility(8);
                c.this.eUX.setImageResource(d.f.icon_video_suspend_n);
                c.this.gBT.setVisibility(8);
                c.this.gBS.setVisibility(8);
                c.this.gBU.setVisibility(8);
                c.this.cRP.setVisibility(8);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(c.this.eVE);
                com.baidu.adp.lib.g.e.nr().postDelayed(c.this.eVE, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void auw();

        void aux();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0149c {
        void auA();

        void fO(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void mB(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void bfT();
    }

    /* loaded from: classes.dex */
    public interface g {
        void auB();
    }

    /* loaded from: classes.dex */
    public interface h {
        void kX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void auy();

        void auz();
    }

    /* loaded from: classes.dex */
    public interface k {
        void bfU();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eVw = 0;
        this.gCr = true;
        if (tbPageContext != null) {
            this.aQq = tbPageContext;
            this.eUQ = o(tbPageContext);
            this.mRootView = view;
            this.gCr = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eUQ);
            }
            this.eVb = view;
            this.eUQ.setOnClickListener(this.mOnClickListener);
            this.bYA = (QuickVideoView) this.eUQ.findViewById(d.g.videoView);
            this.cOY = new y((ViewGroup) this.eUQ.findViewById(d.g.auto_video_loading_container));
            this.cOY.setLoadingAnimationListener(this.cPi);
            this.eUS = (VideoListMediaControllerView) this.eUQ.findViewById(d.g.media_controller);
            this.eUS.setPlayer(this.bYA);
            this.gBP = (ProgressBar) this.eUQ.findViewById(d.g.pgrBottomProgress);
            this.gBP.setMax(com.baidu.adp.lib.util.l.ao(this.aQq.getPageActivity()));
            this.gBP.setProgress(0);
            this.eUS.setOnSeekBarChangeListener(this.bRp);
            this.eUS.setOnProgressUpdatedListener(this.eYt);
            this.eUT = this.eUQ.findViewById(d.g.black_mask);
            this.cRP = this.eUQ.findViewById(d.g.layout_error);
            this.cRP.setOnClickListener(this.mOnClickListener);
            this.gCk = (TextView) this.eUQ.findViewById(d.g.auto_video_error_tips);
            this.eUU = (FrameLayout) this.eUQ.findViewById(d.g.danmu_container);
            this.eUX = (ImageView) this.eUQ.findViewById(d.g.img_play_icon);
            this.eUX.setOnClickListener(this.mOnClickListener);
            this.eUY = (ImageView) this.eUQ.findViewById(d.g.img_full_screen);
            this.eUY.setOnClickListener(this.mOnClickListener);
            this.gBQ = this.eUQ.findViewById(d.g.full_screen_container);
            this.gBQ.setOnClickListener(this.mOnClickListener);
            this.eUZ = this.eUQ.findViewById(d.g.layout_media_controller);
            this.gBR = this.eUQ.findViewById(d.g.time_show_controller);
            this.bYA.setOnPreparedListener(this.bNf);
            this.bYA.setOnCompletionListener(this.bNe);
            this.bYA.setOnErrorListener(this.eVD);
            this.bYA.setOnSeekCompleteListener(this.bNj);
            this.bYA.setOnSurfaceDestroyedListener(this.bYH);
            this.bYA.setOnRecoveryCallback(this.gCt);
            this.cRL = (ImageView) this.eUQ.findViewById(d.g.img_play);
            this.cRL.setOnClickListener(this.mOnClickListener);
            this.gBS = (TextView) this.eUQ.findViewById(d.g.txt_replay);
            this.gBS.setOnClickListener(this.mOnClickListener);
            this.gBT = (TextView) this.eUQ.findViewById(d.g.txt_playnext);
            this.gBT.setOnClickListener(this.mOnClickListener);
            this.gBU = (TextView) this.eUQ.findViewById(d.g.txt_next_video_title);
            this.eVc = (TbImageView) this.eUQ.findViewById(d.g.video_thumbnail);
            this.eVc.setDefaultErrorResource(0);
            this.eVc.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.aQq.getPageActivity());
            this.mScreenHeight = bQ(this.aQq.getPageActivity());
            this.eVf = (ImageView) this.eUQ.findViewById(d.g.img_exit);
            this.eVf.setOnClickListener(this.mOnClickListener);
            this.eVg = (TextView) this.eUQ.findViewById(d.g.video_title);
            this.cRK = this.eUQ.findViewById(d.g.layout_title);
            this.cRK.setVisibility(8);
            this.dAw = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dAx = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aQq.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eVr = this.mAudioManager.getStreamMaxVolume(3);
            this.eVx = this.mAudioManager.getStreamVolume(3);
            eVy = 100 / this.eVr;
            this.eUQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.gCc != null) {
                        c.this.gCc.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eVh) {
                            if (c.this.mStatus == 1 && c.this.eVt != 0) {
                                c.this.b(c.this.eVt == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eVt = 0;
                                c.this.eVs = 0;
                            }
                            if (!c.this.bYA.isPlaying() && 8 == c.this.cRL.getVisibility()) {
                                c.this.cRL.setVisibility(0);
                                c.this.gBT.setVisibility(8);
                                c.this.gBS.setVisibility(8);
                                c.this.gBU.setVisibility(8);
                            }
                        }
                        c.this.aOt();
                        if (c.this.gCc != null) {
                            c.this.gCc.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.ckQ = new p(this.aQq.getPageActivity());
            if (this.gCr) {
                this.ckQ.start();
            }
            this.eVw = com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.ds16);
            this.eVz = new CallStateReceiver();
            this.eVz.register(this.aQq.getPageActivity());
            this.aQq.registerListener(this.eVJ);
            bqk();
        }
    }

    public void bqk() {
        if (this.gCg) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eUQ.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eUQ.setSystemUiVisibility(0);
    }

    public void mu(boolean z) {
        this.gCg = z;
        bqk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOt() {
        this.mStatus = 0;
        if (this.eVl != null && this.eVl.getParent() != null && (this.eVl.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eVl.getParent()).removeView(this.eVl);
                this.eVl = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eVm != null && this.eVm.getParent() != null && (this.eVm.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eVm.getParent()).removeView(this.eVm);
                this.eVm = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aOu() {
        if (this.mStatus == 1) {
            if (this.eVl == null && this.eUQ != null && (this.eUQ instanceof ViewGroup)) {
                LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.eUQ, true);
                this.eVl = this.eUQ.findViewById(d.g.lay_jindu);
                this.eVn = (TextView) this.eVl.findViewById(d.g.show_time);
                this.eVq = (ImageView) this.eVl.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eVm == null && this.eUQ != null && (this.eUQ instanceof ViewGroup)) {
            LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.eUQ, true);
            this.eVm = this.eUQ.findViewById(d.g.lay_voice);
            this.eVp = (ImageView) this.eVm.findViewById(d.g.arrow_voice_icon);
            this.eVo = (SeekBar) this.eVm.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.gCc != null) {
                c.this.gCc.onStart();
            }
            if (c.this.eib && c.this.eVh) {
                if (!c.this.bYA.isPlaying() && c.this.cRL.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cRL.setVisibility(8);
                    c.this.gBT.setVisibility(8);
                    c.this.gBS.setVisibility(8);
                    c.this.gBU.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.am(f2);
                    }
                } else {
                    if (c.this.eib) {
                        c.this.aOw();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eVs = c.this.bYA.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.am(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.gCd != null) {
                c.this.gCd.bfU();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eVh) {
                if (c.this.bal != 2) {
                    c.this.bqs();
                } else {
                    c.this.bfK();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOw() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eUQ.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eUQ.setSystemUiVisibility(4);
        } else {
            this.eUQ.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(float f2) {
        if (!this.eVh) {
            this.mStatus = 0;
            return;
        }
        aOu();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eVy == 0) {
            if (f2 > 0.0f && this.eVx < this.eVr) {
                this.eVx++;
            }
            if (f2 < 0.0f && this.eVx > 0) {
                this.eVx--;
            }
        }
        if (this.mProgress > 0) {
            this.eVp.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eVp.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eVx, 0);
        this.eVo.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eVs += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eVt = 1;
            } else {
                this.eVs += 1000;
                this.eVt = 2;
            }
            if (this.eVs < 0) {
                this.eVs = 0;
            } else if (this.eVs > this.bYA.getDuration()) {
                this.eVs = this.bYA.getDuration();
            }
        }
        aOu();
        String vu = this.eUS.vu(this.eVs);
        if (f2 > 0.0f) {
            this.eVq.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eVq.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(vu)) {
            this.eVn.setText(new StringBuilder().append(vu).append("/").append(this.eUS.vu(this.bYA.getDuration())));
        }
        this.eUS.L(this.eVs, z ? false : true);
        this.eUZ.setVisibility(8);
        this.gBP.setVisibility(0);
        bqm();
    }

    protected View o(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bP(String str, String str2) {
        this.bOw = str;
        this.bAK = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bql() {
        if (this.gBX) {
            return this.gCp == 0 && !this.gCq;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajg() {
        if (this.bYA != null && this.cOT != null) {
            if (this.gCo) {
                this.bYA.start();
                this.gCo = false;
            }
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVC);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.eVC, 20L);
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVE);
            if (this.bYA.bqN()) {
                this.bal = 1;
                this.bYA.setRecoveryState(1);
            }
            if (this.cOT != null && this.eUS != null) {
                this.mStartPosition = z.bro().rD(this.bOw);
                this.eUS.aU(this.mStartPosition, this.cOT.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bYA != null) {
                        this.bYA.vt(this.mStartPosition);
                    } else {
                        this.cOT.seekTo(this.mStartPosition);
                    }
                    if (!this.gCn) {
                        this.eUS.showProgress();
                        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVC);
                    }
                    this.gCi = true;
                }
            }
        }
    }

    public void bfK() {
        if (!com.baidu.adp.lib.util.j.oI()) {
            com.baidu.adp.lib.util.l.J(this.aQq.getPageActivity(), this.aQq.getString(d.j.neterror));
        } else if (this.bYA.isPlaying()) {
            pausePlay();
        } else if (this.eVh) {
            aOH();
            if (this.fXx != null) {
                this.fXx.auB();
            }
        } else {
            bqq();
        }
    }

    public void aOx() {
        this.eVA = true;
        if (this.ckQ != null) {
            this.ckQ.aOx();
        }
    }

    public boolean vq(int i2) {
        switch (i2) {
            case 4:
                if (this.eib) {
                    aOx();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eVr <= 0 || this.eVo == null) {
                    return false;
                }
                this.eVx = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eVx * 100.0d) / this.eVr);
                this.eVo.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bYA;
    }

    public VideoListMediaControllerView aOy() {
        return this.eUS;
    }

    public void show() {
        this.eUQ.setVisibility(0);
    }

    public void aOC() {
        if (this.eVb != null) {
            ViewGroup.LayoutParams layoutParams = this.eVb.getLayoutParams();
            this.eUV = (FrameLayout.LayoutParams) this.eUQ.getLayoutParams();
            this.eUV.width = layoutParams.width;
            this.eUV.height = layoutParams.height;
            this.eUV.topMargin = 0;
            this.eUQ.setLayoutParams(this.eUV);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eVA) {
            if (this.eib) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.eVA = false;
        }
        if (configuration.orientation == 2) {
            this.eib = true;
            this.eUQ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.eUZ.setVisibility(0);
            this.cRK.setVisibility(0);
            this.eVf.setVisibility(0);
            this.eVg.setVisibility(0);
            this.eUU.setVisibility(8);
            if (this.gBX) {
                this.cOY.startLoading();
                this.eVc.setVisibility(0);
            } else {
                this.cOY.brk();
                this.eVc.setVisibility(8);
            }
            if (this.gBY != null) {
                this.gBY.auw();
            }
            this.eUY.setImageResource(d.f.icon_video_window);
            ri(this.eVw);
            aOw();
        } else {
            this.eib = false;
            if (this.eUV != null) {
                this.eUQ.setLayoutParams(this.eUV);
            }
            a(tbPageContext, false);
            this.cRK.setVisibility(8);
            this.eUU.setVisibility(0);
            if (this.gBX) {
                this.cOY.startLoading();
                this.eVc.setVisibility(0);
            } else {
                this.cOY.brk();
                this.eVc.setVisibility(8);
            }
            if (this.gBY != null) {
                this.gBY.aux();
            }
            if (this.bal == 3 && this.gBZ != null) {
                this.gBZ.fO(false);
            } else if (!this.eVh && this.eUZ != null) {
                this.eUZ.clearAnimation();
                this.eUZ.setVisibility(4);
                this.gBP.setVisibility(0);
                if (this.gBZ != null) {
                    this.gBZ.auA();
                }
            }
            aOt();
            this.eUY.setImageResource(d.f.icon_video_fullscreen);
            if (this.eUS != null && (this.eUS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUS.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.tbds24);
                layoutParams.rightMargin = 0;
                this.eUS.setLayoutParams(layoutParams);
            }
            this.eUQ.setSystemUiVisibility(0);
            bqk();
        }
        if (this.bYA.isPlaying()) {
            aOM();
        }
        bqm();
    }

    public void bqm() {
        if (this.bYA != null) {
            int ao = com.baidu.adp.lib.util.l.ao(this.aQq.getPageActivity());
            if (this.eib) {
                ao = com.baidu.adp.lib.util.l.aq(this.aQq.getPageActivity());
            }
            this.gBP.setMax(ao);
            int duration = this.bYA.getDuration();
            if (duration > 0) {
                if (this.gBS.getVisibility() == 0) {
                    this.gBP.setProgress(this.gBP.getMax());
                } else {
                    this.gBP.setProgress((int) ((this.bYA.getCurrentPosition() * this.gBP.getMax()) / duration));
                }
            }
        }
    }

    private void ri(int i2) {
        if (this.eUS != null && (this.eUS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUS.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eUS.setLayoutParams(layoutParams);
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

    public boolean aOE() {
        return !this.eib;
    }

    public void a(g.a aVar) {
        this.gBV = aVar;
    }

    public void a(g.b bVar) {
        this.gBW = bVar;
    }

    public void aOF() {
        this.eUX.setImageResource(d.f.icon_video_play);
        this.cOY.brk();
        this.cRL.setVisibility(0);
        this.gBT.setVisibility(8);
        this.gBS.setVisibility(8);
        this.gBU.setVisibility(8);
        this.bal = 2;
        this.bYA.setRecoveryState(2);
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bYA != null) {
            this.bYA.setPbLoadingTime(currentTimeMillis);
        }
        bQ(str, str2);
    }

    public void bQ(String str, String str2) {
        this.gCo = true;
        this.bal = 0;
        this.bYA.setRecoveryState(0);
        bP(str, str2);
        this.bYA.bS(str, str2);
        this.cOY.startLoading();
        this.eVc.setVisibility(0);
        this.cRL.setVisibility(8);
        this.eUX.setImageResource(d.f.icon_video_suspend_n);
        this.gBT.setVisibility(8);
        this.gBS.setVisibility(8);
        this.gBU.setVisibility(8);
        this.cRP.setVisibility(8);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVE);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.eVE, 60000L);
    }

    public void bR(String str, String str2) {
        this.gCo = true;
        this.bal = 0;
        this.bYA.setRecoveryState(0);
        this.cOY.startLoading();
        this.eVc.setVisibility(0);
        this.cRL.setVisibility(8);
        this.eUX.setImageResource(d.f.icon_video_suspend_n);
        this.gBT.setVisibility(8);
        this.gBS.setVisibility(8);
        this.gBU.setVisibility(8);
        this.cRP.setVisibility(8);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVE);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.eVE, 60000L);
    }

    public void aOH() {
        this.bal = 1;
        this.bYA.setRecoveryState(1);
        this.bYA.start();
        this.eUX.setImageResource(d.f.icon_video_suspend_n);
        this.eVc.setVisibility(8);
        this.eUT.setVisibility(8);
        this.cOY.brk();
        this.eUS.showProgress();
        this.cRL.setVisibility(8);
        this.gBT.setVisibility(8);
        this.gBS.setVisibility(8);
        this.gBU.setVisibility(8);
        bqu();
    }

    public void bqn() {
        if (com.baidu.adp.lib.util.j.oI() && this.gCm && !StringUtils.isNull(this.bOw) && !StringUtils.isNull(this.bAK)) {
            this.gCm = false;
            this.gCn = true;
            bQ(this.bOw, this.bAK);
        }
    }

    public void mv(boolean z) {
        if (this.bYA != null) {
            this.bYA.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bYA.isPlaying() && this.gCh) {
            bqo();
        }
        bqt();
        this.bYA.pause();
        aOF();
    }

    public void stopPlay() {
        if (this.bYA.isPlaying() && this.gCh) {
            bqo();
        }
        this.bal = 5;
        this.bYA.setRecoveryState(5);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVC);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVE);
        this.bYA.stopPlayback();
        this.eVh = false;
        this.gCo = false;
        this.mStartPosition = 0;
        aBY();
    }

    public void bqo() {
        z.bro().ay(this.bOw, this.bYA.getCurrentPosition());
    }

    public void mw(boolean z) {
        this.gCh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
        if (this.eUZ != null) {
            this.eUT.setVisibility(0);
            this.cRL.setVisibility(0);
            this.gBT.setVisibility(8);
            this.gBS.setVisibility(8);
            this.gBU.setVisibility(8);
            this.cOY.brk();
            this.eUX.setImageResource(d.f.icon_video_play);
            this.eUZ.setVisibility(4);
            this.gBP.setVisibility(8);
            this.cRP.setVisibility(8);
            this.eUS.TV();
            this.eVc.setVisibility(z ? 0 : 8);
        }
    }

    public void aBY() {
        mx(true);
    }

    public boolean bqp() {
        if (this.bYA == null) {
            return false;
        }
        return this.bYA.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bYA == null) {
            return 0;
        }
        return this.bYA.getCurrentPosition();
    }

    public void a(i iVar) {
        this.gCc = iVar;
    }

    public void a(h hVar) {
        this.gCb = hVar;
    }

    public void a(g gVar) {
        this.fXx = gVar;
    }

    public void a(f fVar) {
        this.gCa = fVar;
    }

    public void qy(String str) {
        this.fXb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqq() {
        a(this.bOw, this.bAK, null, new Object[0]);
    }

    public void b(InterfaceC0149c interfaceC0149c) {
        this.gBZ = interfaceC0149c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        if (com.baidu.adp.lib.util.j.oK()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gCj = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gCf != null) {
                    this.gCf.fN(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQq.getPageActivity());
                aVar.cZ(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bqr();
                        if (c.this.gCj) {
                            c.this.bR(str, str2);
                        } else {
                            c.this.bQ(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.mB(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aQq).AI();
                return;
            } else if (this.gCf != null) {
                this.gCf.fN(true);
                return;
            } else {
                if (!this.gBO) {
                    this.gBO = true;
                    com.baidu.adp.lib.util.l.showToast(this.aQq.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                if (this.gCj) {
                    bR(str, str2);
                } else {
                    bQ(str, str2);
                }
                if (dVar != null) {
                    dVar.mB(true);
                    return;
                }
                return;
            }
        }
        if (this.gCj) {
            bR(str, str2);
        } else {
            bQ(str, str2);
        }
        if (dVar != null) {
            dVar.mB(true);
        }
        if (this.gCe != null) {
            this.gCe.auy();
        }
    }

    public void bqr() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nY(String str) {
        this.eVc.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVI);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVC);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVE);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gCs);
        this.ckQ.stop();
        this.eVz.unregister(this.aQq.getPageActivity());
    }

    public void ry(String str) {
        this.eVg.setText(str);
    }

    public boolean aOI() {
        return this.eVh;
    }

    public void aOJ() {
        if (this.eUZ != null) {
            aOL();
            this.eUZ.setVisibility(0);
            this.gBR.setVisibility(0);
            if (this.gBZ != null) {
                this.gBZ.fO(true);
            }
            this.gBP.setVisibility(8);
            this.dAw.setAnimationListener(this.eVG);
            this.eUZ.startAnimation(this.dAw);
            this.eVj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqs() {
        if (this.eUZ != null) {
            if (this.eUZ.getVisibility() == 0) {
                aOL();
                this.eUZ.setVisibility(8);
                this.gBP.setVisibility(0);
                if (this.gBZ != null) {
                    this.gBZ.auA();
                    return;
                }
                return;
            }
            aOM();
        }
    }

    public void aOK() {
        if (this.eUZ != null) {
            aOL();
            this.eUZ.setVisibility(0);
            this.gBR.setVisibility(0);
            if (this.gBZ != null) {
                this.gBZ.fO(false);
            }
            this.gBP.setVisibility(8);
            this.dAx.setAnimationListener(this.eVH);
            this.eUZ.startAnimation(this.dAx);
        }
    }

    public void bqt() {
        if (this.eUZ != null) {
            aOL();
            this.eUZ.setVisibility(0);
            this.gBR.setVisibility(0);
            this.gBP.setVisibility(8);
            if (this.gBZ != null) {
                this.gBZ.fO(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        if (this.eUZ != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVI);
            this.dAx.setAnimationListener(null);
            this.dAw.setAnimationListener(null);
            this.eUZ.clearAnimation();
            this.eVj = false;
        }
    }

    public void aOM() {
        aOK();
        bqu();
    }

    private void bqu() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eVI);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.eVI, 3000L);
    }

    public void a(b bVar) {
        this.gBY = bVar;
    }

    public void rk(int i2) {
        if (this.bYA.getDuration() - i2 <= 3000) {
            aOL();
            if (this.eUZ != null) {
                this.eUZ.setVisibility(0);
                this.gBR.setVisibility(0);
                this.gBP.setVisibility(8);
                if (this.gBZ != null) {
                    this.gBZ.fO(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void my(boolean z) {
        if (this.ckQ != null) {
            if (this.eUY != null || this.gBQ != null) {
                this.eUY.setVisibility(z ? 0 : 8);
                this.gBQ.setVisibility(z ? 0 : 8);
            }
            if (!z && this.eUS != null && (this.eUS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUS.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.tbds52);
                this.eUS.setLayoutParams(layoutParams);
            }
            this.ckQ.mD(z);
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

    public int bqv() {
        return this.bal;
    }

    public void a(k kVar) {
        this.gCd = kVar;
    }

    public void a(j jVar) {
        this.gCe = jVar;
    }

    public void a(e eVar) {
        this.gCf = eVar;
    }

    public void mz(boolean z) {
        this.gCl = z;
    }

    public void mA(boolean z) {
        this.gBX = z;
    }

    public void vr(int i2) {
        this.gCp = i2;
    }
}
