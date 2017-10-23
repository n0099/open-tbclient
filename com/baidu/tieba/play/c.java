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
    private static int dUC;
    private String aXe;
    private TbPageContext<?> abm;
    private QuickVideoView bMC;
    private View bME;
    private ImageView bMF;
    private View bMJ;
    private p boW;
    private Animation cuj;
    private Animation cuk;
    private String cyL;
    protected View dTT;
    private VideoListMediaControllerView dTV;
    private View dTW;
    private FrameLayout dTX;
    protected FrameLayout.LayoutParams dTY;
    private int dUA;
    private int dUB;
    private CallStateReceiver dUD;
    private ImageView dUa;
    private ImageView dUb;
    private View dUc;
    private View dUe;
    private TbImageView dUf;
    private g.f dUg;
    private ImageView dUi;
    private TextView dUj;
    private View dUp;
    private View dUq;
    private TextView dUr;
    private SeekBar dUs;
    private ImageView dUt;
    private ImageView dUu;
    private int dUv;
    private View dhU;
    private g eTz;
    private TextView fwA;
    private TextView fwg;
    private View fwh;
    private ProgressBar fwi;
    private View fwj;
    private TextView fwk;
    private TextView fwl;
    private TextView fwm;
    private g.a fwn;
    private g.b fwo;
    private b fwp;
    private InterfaceC0120c fwq;
    private f fwr;
    private h fws;
    private i fwt;
    private k fwu;
    private j fwv;
    private e fww;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fwf = false;
    protected boolean deU = false;
    private boolean dUk = false;
    private boolean dUm = false;
    private int dUo = 0;
    private int mStatus = 0;
    private int dUw = 0;
    private int dUx = 0;
    private boolean dUE = false;
    private boolean fwx = true;
    private boolean fwy = true;
    private boolean fwz = false;
    private String eTg = null;
    private int alv = -1;
    private g.f aVR = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUG);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUG, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUI);
            if (c.this.bMC.bei()) {
                c.this.alv = 1;
                c.this.bMC.setRecoveryState(1);
            }
            if (gVar != null && c.this.dTV != null) {
                c.this.dUo = w.bey().qm(c.this.aXe);
                c.this.dTV.W(c.this.dUo, gVar.getDuration());
                if (c.this.dUo != 0) {
                    gVar.seekTo(c.this.dUo);
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUG);
                    c.this.fwz = true;
                }
            }
        }
    };
    private Runnable dUG = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMC.getCurrentPosition() > 100) {
                c.this.dUk = true;
                c.this.dTW.setVisibility(8);
                c.this.bMJ.setVisibility(8);
                c.this.dhU.setVisibility(8);
                c.this.fwh.setVisibility(8);
                c.this.dUf.setVisibility(8);
                c.this.aEv();
                if (c.this.alv == 1 || c.this.alv == 2) {
                    if (c.this.dUc != null) {
                        c.this.dUc.setVisibility(0);
                        c.this.fwj.setVisibility(0);
                        c.this.fwi.setVisibility(8);
                        if (c.this.fwq != null) {
                            c.this.fwq.eP(false);
                        }
                    }
                    c.this.dTV.showProgress();
                    c.this.aEw();
                }
                if (c.this.dUg != null) {
                    c.this.dUg.onPrepared(c.this.bMC.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUG, 20L);
        }
    };
    private g.a aVQ = new g.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.dUk = false;
            c.this.dUo = 0;
            c.this.aEd();
            c.this.dTW.setVisibility(0);
            c.this.fwi.setVisibility(8);
            c.this.fwi.setProgress(c.this.fwi.getMax());
            if (c.this.fwq != null) {
                c.this.fwq.eP(false);
            }
            if (c.this.deU) {
                c.this.dUc.setVisibility(0);
                c.this.dUi.setVisibility(0);
                c.this.dUj.setVisibility(0);
                c.this.fwj.setVisibility(8);
            } else {
                c.this.dUc.setVisibility(8);
                c.this.dUi.setVisibility(8);
                c.this.dUj.setVisibility(8);
                c.this.fwj.setVisibility(8);
            }
            if (c.this.bMC == null || c.this.bMC.getDuration() > 150000) {
                c.this.lt(false);
            } else {
                c.this.fwk.setVisibility(0);
            }
            w.bey().remove(c.this.aXe);
            if (c.this.fwn != null) {
                c.this.fwn.onCompletion(gVar);
            }
            c.this.alv = 3;
            c.this.bMC.setRecoveryState(3);
            if (!c.this.deU && c.this.bMC != null && c.this.bMC.getDuration() <= 150000) {
                if (c.this.fws != null) {
                    c.this.fws.eQ(true);
                }
                c.this.bO(c.this.aXe, c.this.cyL);
            }
        }
    };
    private g.b dUH = new g.b() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.bMJ.setVisibility(0);
            c.this.dhU.setVisibility(8);
            c.this.fwh.setVisibility(8);
            c.this.alv = 4;
            c.this.bMC.setRecoveryState(4);
            if (c.this.fwo != null) {
                c.this.fwo.onError(gVar, i2, i3);
                return true;
            }
            return true;
        }
    };
    private Runnable dUI = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMC == null || !c.this.bMC.bej()) {
                c.this.bMJ.setVisibility(0);
                c.this.dhU.setVisibility(8);
                c.this.fwh.setVisibility(8);
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUI, 60000L);
        }
    };
    private g.InterfaceC0121g aVV = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.InterfaceC0121g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fwz) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fwB, 200L);
            }
        }
    };
    private Runnable fwB = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bMC == null || !c.this.fwz) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUG, 200L);
                c.this.fwz = false;
            } else if (c.this.dUo != c.this.bMC.getCurrentPosition()) {
                c.this.fwz = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUG, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fwB, 200L);
            }
        }
    };
    private QuickVideoView.b bKK = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dUk = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUG);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUI);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bMJ.getId()) {
                c.this.bdV();
            } else if (view.getId() != c.this.bMF.getId() && view.getId() != c.this.dUa.getId()) {
                if (view.getId() == c.this.fwl.getId()) {
                    if (c.this.fwr != null) {
                        c.this.fwr.aUn();
                    }
                } else if (view.getId() == c.this.fwk.getId()) {
                    if (c.this.fws != null) {
                        c.this.fws.eQ(false);
                    }
                    c.this.bO(c.this.aXe, c.this.cyL);
                } else if (view.getId() != c.this.dUb.getId()) {
                    if (view.getId() == c.this.dUi.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fwv != null) {
                            c.this.fwv.air();
                        }
                        c.this.aEh();
                    }
                } else {
                    if (c.this.deU) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fwv != null) {
                        c.this.fwv.air();
                    }
                    c.this.aEh();
                }
            } else {
                c.this.aUd();
            }
        }
    };
    private Animation.AnimationListener dUK = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.5
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dUc != null) {
                c.this.dUc.setVisibility(8);
                c.this.fwi.setVisibility(0);
                c.this.dUm = false;
                if (c.this.fwq != null) {
                    c.this.fwq.ais();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dUL = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
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
    private Runnable dUM = new Runnable() { // from class: com.baidu.tieba.play.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.aEt();
        }
    };
    private CustomMessageListener dUN = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private t.b dXy = new t.b() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.t.b
        public void ge(int i2) {
            int duration;
            if (c.this.bMC != null && (duration = c.this.bMC.getDuration()) > 0 && c.this.fwi != null) {
                c.this.fwi.setProgress((int) ((i2 * c.this.dTT.getWidth()) / duration));
            }
            c.this.nI(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener aZO = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.dUm) {
                c.this.aEw();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aEs() && c.this.aEi() != null) {
                c.this.setStartPosition(c.this.aEi().getSeekPosition());
                c.this.bO(c.this.aXe, c.this.cyL);
            }
        }
    };
    private QuickVideoView.a fwC = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void beb() {
            c.this.dhU.setVisibility(0);
            if (c.this.deU) {
                c.this.fwh.setVisibility(8);
            } else {
                c.this.fwh.setVisibility(0);
            }
            c.this.dUf.setVisibility(0);
            c.this.bMF.setVisibility(8);
            c.this.dUa.setImageResource(d.g.icon_video_midplay);
            c.this.fwl.setVisibility(8);
            c.this.fwk.setVisibility(8);
            c.this.fwm.setVisibility(8);
            c.this.bMJ.setVisibility(8);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.dUI);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.dUI, 60000L);
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aio();

        void aip();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0120c {
        void ais();

        void eP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void jW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eO(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aUn();
    }

    /* loaded from: classes.dex */
    public interface g {
        void ait();
    }

    /* loaded from: classes.dex */
    public interface h {
        void eQ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void aiq();

        void air();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aUm();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dUA = 0;
        if (tbPageContext != null) {
            this.abm = tbPageContext;
            this.dTT = q(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dTT);
            }
            this.dUe = view;
            this.dTT.setOnClickListener(this.mOnClickListener);
            this.bMC = (QuickVideoView) this.dTT.findViewById(d.h.videoView);
            this.dhU = this.dTT.findViewById(d.h.video_list_layout_loading);
            this.fwh = this.dTT.findViewById(d.h.layout_play_count);
            this.fwg = (TextView) this.dTT.findViewById(d.h.play_count);
            this.dTV = (VideoListMediaControllerView) this.dTT.findViewById(d.h.media_controller);
            this.dTV.setPlayer(this.bMC);
            this.fwi = (ProgressBar) this.dTT.findViewById(d.h.pgrBottomProgress);
            this.fwi.setMax(com.baidu.adp.lib.util.l.ad(this.abm.getPageActivity()));
            this.fwi.setProgress(0);
            this.dTV.setOnSeekBarChangeListener(this.aZO);
            this.dTV.setOnProgressUpdatedListener(this.dXy);
            this.dTW = this.dTT.findViewById(d.h.black_mask);
            this.bMJ = this.dTT.findViewById(d.h.layout_error);
            this.bMJ.setOnClickListener(this.mOnClickListener);
            this.fwA = (TextView) this.dTT.findViewById(d.h.auto_video_error_tips);
            this.dTX = (FrameLayout) this.dTT.findViewById(d.h.danmu_container);
            this.dUa = (ImageView) this.dTT.findViewById(d.h.img_play_icon);
            this.dUa.setOnClickListener(this.mOnClickListener);
            this.dUb = (ImageView) this.dTT.findViewById(d.h.img_full_screen);
            this.dUb.setOnClickListener(this.mOnClickListener);
            this.dUc = this.dTT.findViewById(d.h.layout_media_controller);
            this.fwj = this.dTT.findViewById(d.h.time_show_controller);
            this.bMC.setOnPreparedListener(this.aVR);
            this.bMC.setOnCompletionListener(this.aVQ);
            this.bMC.setOnErrorListener(this.dUH);
            this.bMC.setOnSeekCompleteListener(this.aVV);
            this.bMC.setOnSurfaceDestroyedListener(this.bKK);
            this.bMC.setOnRecoveryCallback(this.fwC);
            this.bMF = (ImageView) this.dTT.findViewById(d.h.img_play);
            this.bMF.setOnClickListener(this.mOnClickListener);
            this.fwk = (TextView) this.dTT.findViewById(d.h.txt_replay);
            this.fwk.setOnClickListener(this.mOnClickListener);
            this.fwl = (TextView) this.dTT.findViewById(d.h.txt_playnext);
            this.fwl.setOnClickListener(this.mOnClickListener);
            this.fwm = (TextView) this.dTT.findViewById(d.h.txt_next_video_title);
            this.dUf = (TbImageView) this.dTT.findViewById(d.h.video_thumbnail);
            this.dUf.setDefaultErrorResource(0);
            this.dUf.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ad(this.abm.getPageActivity());
            this.mScreenHeight = bD(this.abm.getPageActivity());
            this.dUi = (ImageView) this.dTT.findViewById(d.h.img_exit);
            this.dUi.setOnClickListener(this.mOnClickListener);
            this.dUj = (TextView) this.dTT.findViewById(d.h.video_title);
            this.bME = this.dTT.findViewById(d.h.layout_title);
            this.bME.setVisibility(8);
            this.cuj = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cuk = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.abm.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dUv = this.mAudioManager.getStreamMaxVolume(3);
            this.dUB = this.mAudioManager.getStreamVolume(3);
            dUC = 100 / this.dUv;
            this.dTT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fwt != null) {
                        c.this.fwt.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dUk) {
                            if (c.this.mStatus == 1 && c.this.dUx != 0) {
                                c.this.b(c.this.dUx == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dUx = 0;
                                c.this.dUw = 0;
                            }
                            if (!c.this.bMC.isPlaying() && 8 == c.this.bMF.getVisibility()) {
                                c.this.bMF.setVisibility(0);
                                c.this.fwl.setVisibility(8);
                                c.this.fwk.setVisibility(8);
                                c.this.fwm.setVisibility(8);
                            }
                        }
                        c.this.aEd();
                        if (c.this.fwt != null) {
                            c.this.fwt.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.boW = new p(this.abm.getPageActivity());
            this.boW.start();
            this.dUA = com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds16);
            this.dUD = new CallStateReceiver();
            this.dUD.register(this.abm.getPageActivity());
            this.abm.registerListener(this.dUN);
            bdR();
        }
    }

    public void bdR() {
        if (this.fwx) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dTT.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.dTT.setSystemUiVisibility(0);
    }

    public void lq(boolean z) {
        this.fwx = z;
        bdR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEd() {
        this.mStatus = 0;
        if (this.dUp != null && this.dUp.getParent() != null && (this.dUp.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dUp.getParent()).removeView(this.dUp);
                this.dUp = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dUq != null && this.dUq.getParent() != null && (this.dUq.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dUq.getParent()).removeView(this.dUq);
                this.dUq = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aEe() {
        if (this.mStatus == 1) {
            if (this.dUp == null && this.dTT != null && (this.dTT instanceof ViewGroup)) {
                LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dTT, true);
                this.dUp = this.dTT.findViewById(d.h.lay_jindu);
                this.dUr = (TextView) this.dUp.findViewById(d.h.show_time);
                this.dUu = (ImageView) this.dUp.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dUq == null && this.dTT != null && (this.dTT instanceof ViewGroup)) {
            LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dTT, true);
            this.dUq = this.dTT.findViewById(d.h.lay_voice);
            this.dUt = (ImageView) this.dUq.findViewById(d.h.arrow_voice_icon);
            this.dUs = (SeekBar) this.dUq.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fwt != null) {
                c.this.fwt.onStart();
            }
            if (c.this.deU && c.this.dUk) {
                if (!c.this.bMC.isPlaying() && c.this.bMF.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bMF.setVisibility(8);
                    c.this.fwl.setVisibility(8);
                    c.this.fwk.setVisibility(8);
                    c.this.fwm.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.V(f2);
                    }
                } else {
                    if (c.this.deU) {
                        c.this.aEg();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dUw = c.this.bMC.getCurrentPosition();
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
            if (c.this.fwu != null) {
                c.this.fwu.aUm();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dUk) {
                if (c.this.alv != 2) {
                    c.this.bdX();
                } else {
                    c.this.aUd();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEg() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dTT.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dTT.setSystemUiVisibility(4);
        } else {
            this.dTT.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f2) {
        if (!this.dUk) {
            this.mStatus = 0;
            return;
        }
        aEe();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dUC == 0) {
            if (f2 > 0.0f && this.dUB < this.dUv) {
                this.dUB++;
            }
            if (f2 < 0.0f && this.dUB > 0) {
                this.dUB--;
            }
        }
        if (this.mProgress > 0) {
            this.dUt.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dUt.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dUB, 0);
        this.dUs.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dUw -= 1000;
                this.dUx = 1;
            } else {
                this.dUw += 1000;
                this.dUx = 2;
            }
            if (this.dUw < 0) {
                this.dUw = 0;
            } else if (this.dUw > this.bMC.getDuration()) {
                this.dUw = this.bMC.getDuration();
            }
        }
        aEe();
        String rN = this.dTV.rN(this.dUw);
        if (f2 > 0.0f) {
            this.dUu.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dUu.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rN)) {
            this.dUr.setText(new StringBuilder().append(rN).append("/").append(this.dTV.rN(this.bMC.getDuration())));
        }
        this.dTV.z(this.dUw, z ? false : true);
        this.dUc.setVisibility(8);
        this.fwi.setVisibility(0);
        bdS();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.float_video_container, (ViewGroup) null);
    }

    public void bN(String str, String str2) {
        this.aXe = str;
        this.cyL = str2;
    }

    public void aUd() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.abm.getPageActivity(), this.abm.getString(d.l.neterror));
        } else if (this.bMC.isPlaying()) {
            pausePlay();
        } else if (this.dUk) {
            aEr();
            if (this.eTz != null) {
                this.eTz.ait();
            }
        } else {
            bdV();
        }
    }

    public void aEh() {
        this.dUE = true;
        if (this.boW != null) {
            this.boW.aEh();
        }
    }

    public boolean rL(int i2) {
        switch (i2) {
            case 4:
                if (this.deU) {
                    aEh();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dUv <= 0 || this.dUs == null) {
                    return false;
                }
                this.dUB = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dUB * 100.0d) / this.dUv);
                this.dUs.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bMC;
    }

    public VideoListMediaControllerView aEi() {
        return this.dTV;
    }

    public void show() {
        this.dTT.setVisibility(0);
    }

    public void aEm() {
        if (this.dUe != null) {
            ViewGroup.LayoutParams layoutParams = this.dUe.getLayoutParams();
            this.dTY = (FrameLayout.LayoutParams) this.dTT.getLayoutParams();
            this.dTY.width = layoutParams.width;
            this.dTY.height = layoutParams.height;
            this.dTY.topMargin = 0;
            this.dTT.setLayoutParams(this.dTY);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.dUE) {
            if (this.deU) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.dUE = false;
        }
        if (configuration.orientation == 2) {
            this.deU = true;
            this.dTT.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.dUc.setVisibility(0);
            this.bME.setVisibility(0);
            this.dUi.setVisibility(0);
            this.dUj.setVisibility(0);
            this.dTX.setVisibility(8);
            if (this.fwp != null) {
                this.fwp.aio();
            }
            this.dUb.setImageResource(d.g.icon_suoxiao);
            nG(this.dUA);
            aEg();
        } else {
            this.deU = false;
            if (this.dTY != null) {
                this.dTT.setLayoutParams(this.dTY);
            }
            a(tbPageContext, false);
            this.bME.setVisibility(8);
            this.dTX.setVisibility(0);
            if (this.fwp != null) {
                this.fwp.aip();
            }
            if (this.alv == 3 && this.fwq != null) {
                this.fwq.eP(false);
            } else if (!this.dUk && this.dUc != null) {
                this.dUc.clearAnimation();
                this.dUc.setVisibility(4);
                this.fwi.setVisibility(0);
                if (this.fwq != null) {
                    this.fwq.ais();
                }
            }
            aEd();
            this.dUb.setImageResource(d.g.icon_fangda);
            nG(0);
            this.dTT.setSystemUiVisibility(0);
            bdR();
        }
        if (this.bMC.isPlaying()) {
            aEw();
        }
        bdS();
    }

    public void bdS() {
        if (this.bMC != null) {
            int ad = com.baidu.adp.lib.util.l.ad(this.abm.getPageActivity());
            if (this.deU) {
                ad = com.baidu.adp.lib.util.l.af(this.abm.getPageActivity());
            }
            this.fwi.setMax(ad);
            int duration = this.bMC.getDuration();
            if (duration > 0) {
                if (this.fwk.getVisibility() == 0) {
                    this.fwi.setProgress(this.fwi.getMax());
                } else {
                    this.fwi.setProgress((int) ((this.bMC.getCurrentPosition() * this.fwi.getMax()) / duration));
                }
            }
        }
    }

    private void nG(int i2) {
        if (this.dTV != null && (this.dTV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dTV.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.dTV.setLayoutParams(layoutParams);
        }
    }

    private void a(TbPageContext tbPageContext, boolean z) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = tbPageContext.getPageActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                tbPageContext.getPageActivity().getWindow().setAttributes(attributes);
                tbPageContext.getPageActivity().getWindow().addFlags(512);
                this.fwh.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = tbPageContext.getPageActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            tbPageContext.getPageActivity().getWindow().setAttributes(attributes2);
            tbPageContext.getPageActivity().getWindow().clearFlags(512);
            if (this.dhU.getVisibility() == 0) {
                this.fwh.setVisibility(0);
            }
        }
    }

    public boolean aEo() {
        return !this.deU;
    }

    public void a(g.a aVar) {
        this.fwn = aVar;
    }

    public void a(g.b bVar) {
        this.fwo = bVar;
    }

    public void aEp() {
        this.dUa.setImageResource(d.g.icon_video_midpause);
        this.dhU.setVisibility(8);
        this.fwh.setVisibility(8);
        this.bMF.setVisibility(0);
        this.fwl.setVisibility(8);
        this.fwk.setVisibility(8);
        this.fwm.setVisibility(8);
        this.alv = 2;
        this.bMC.setRecoveryState(2);
    }

    public void bO(String str, String str2) {
        this.alv = 0;
        this.bMC.setRecoveryState(0);
        bN(str, str2);
        if (TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ak("c12026").ac("tid", str2));
        }
        this.bMC.setVideoPath(str);
        this.bMC.start();
        this.dhU.setVisibility(0);
        if (this.deU) {
            this.fwh.setVisibility(8);
        } else {
            this.fwh.setVisibility(0);
        }
        this.dUf.setVisibility(0);
        this.bMF.setVisibility(8);
        this.dUa.setImageResource(d.g.icon_video_midplay);
        this.fwl.setVisibility(8);
        this.fwk.setVisibility(8);
        this.fwm.setVisibility(8);
        this.bMJ.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUI);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.dUI, 60000L);
    }

    public void aEr() {
        this.alv = 1;
        this.bMC.setRecoveryState(1);
        this.bMC.start();
        this.dUa.setImageResource(d.g.icon_video_midplay);
        this.dUf.setVisibility(8);
        this.dTW.setVisibility(8);
        this.dhU.setVisibility(8);
        this.fwh.setVisibility(8);
        this.dTV.showProgress();
        this.bMF.setVisibility(8);
        this.fwl.setVisibility(8);
        this.fwk.setVisibility(8);
        this.fwm.setVisibility(8);
        bdZ();
    }

    public void lr(boolean z) {
        if (this.bMC != null) {
            this.bMC.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bMC.isPlaying() && this.fwy) {
            bdT();
        }
        bdY();
        this.bMC.pause();
        aEp();
    }

    public void stopPlay() {
        if (this.bMC.isPlaying() && this.fwy) {
            bdT();
        }
        this.alv = 5;
        this.bMC.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUG);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUI);
        this.bMC.stopPlayback();
        this.dUk = false;
        this.dUo = 0;
        aqA();
    }

    public void bdT() {
        w.bey().ao(this.aXe, this.bMC.getCurrentPosition());
    }

    public void ls(boolean z) {
        this.fwy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (this.dUc != null) {
            this.dTW.setVisibility(0);
            this.bMF.setVisibility(0);
            this.fwl.setVisibility(8);
            this.fwk.setVisibility(8);
            this.fwm.setVisibility(8);
            this.dhU.setVisibility(8);
            this.fwh.setVisibility(8);
            this.dUa.setImageResource(d.g.icon_video_midpause);
            this.dUc.setVisibility(4);
            this.fwi.setVisibility(8);
            this.bMJ.setVisibility(8);
            this.dTV.Lx();
            this.dUf.setVisibility(z ? 0 : 8);
        }
    }

    public void aqA() {
        lt(true);
    }

    public boolean bdU() {
        if (this.bMC == null) {
            return false;
        }
        return this.bMC.isPlaying();
    }

    public void a(i iVar) {
        this.fwt = iVar;
    }

    public void a(h hVar) {
        this.fws = hVar;
    }

    public void a(g gVar) {
        this.eTz = gVar;
    }

    public void a(f fVar) {
        this.fwr = fVar;
    }

    public void pr(String str) {
        this.eTg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdV() {
        a(this.aXe, this.cyL, (d) null);
    }

    public void b(InterfaceC0120c interfaceC0120c) {
        this.fwq = interfaceC0120c;
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fww != null) {
                    this.fww.eO(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abm.getPageActivity());
                aVar.cL(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
                aVar.a(d.l.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bdW();
                        c.this.bO(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.jW(false);
                        }
                    }
                });
                aVar.b(d.l.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.abm).tb();
                return;
            } else if (this.fww != null) {
                this.fww.eO(true);
                return;
            } else {
                if (!this.fwf) {
                    this.fwf = true;
                    com.baidu.adp.lib.util.l.showToast(this.abm.getPageActivity(), d.l.play_video_mobile_tip2);
                }
                bO(str, str2);
                if (dVar != null) {
                    dVar.jW(true);
                    return;
                }
                return;
            }
        }
        bO(str, str2);
        if (dVar != null) {
            dVar.jW(true);
        }
        if (this.fwv != null) {
            this.fwv.aiq();
        }
    }

    public void bdW() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nj(String str) {
        this.dUf.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUM);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUG);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUI);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwB);
        this.boW.stop();
        this.dUD.unregister(this.abm.getPageActivity());
    }

    public void setVideoTitle(String str) {
        this.dUj.setText(str);
    }

    public void bS(long j2) {
        this.fwg.setText(am.u(j2));
    }

    public boolean aEs() {
        return this.dUk;
    }

    public void aEt() {
        if (this.dUc != null) {
            aEv();
            this.dUc.setVisibility(0);
            this.fwj.setVisibility(0);
            if (this.fwq != null) {
                this.fwq.eP(true);
            }
            this.fwi.setVisibility(8);
            this.cuj.setAnimationListener(this.dUK);
            this.dUc.startAnimation(this.cuj);
            this.dUm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdX() {
        if (this.dUc != null) {
            if (this.dUc.getVisibility() == 0) {
                aEv();
                this.dUc.setVisibility(8);
                this.fwi.setVisibility(0);
                if (this.fwq != null) {
                    this.fwq.ais();
                    return;
                }
                return;
            }
            aEw();
        }
    }

    public void aEu() {
        if (this.dUc != null) {
            aEv();
            this.dUc.setVisibility(0);
            this.fwj.setVisibility(0);
            if (this.fwq != null) {
                this.fwq.eP(false);
            }
            this.fwi.setVisibility(8);
            this.cuk.setAnimationListener(this.dUL);
            this.dUc.startAnimation(this.cuk);
        }
    }

    public void bdY() {
        if (this.dUc != null) {
            aEv();
            this.dUc.setVisibility(0);
            this.fwj.setVisibility(0);
            this.fwi.setVisibility(8);
            if (this.fwq != null) {
                this.fwq.eP(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEv() {
        if (this.dUc != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUM);
            this.cuk.setAnimationListener(null);
            this.cuj.setAnimationListener(null);
            this.dUc.clearAnimation();
            this.dUm = false;
        }
    }

    public void aEw() {
        aEu();
        bdZ();
    }

    private void bdZ() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dUM);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.dUM, 3000L);
    }

    public void a(b bVar) {
        this.fwp = bVar;
    }

    public void nI(int i2) {
        if (this.bMC.getDuration() - i2 <= 3000) {
            aEv();
            if (this.dUc != null) {
                this.dUc.setVisibility(0);
                this.fwj.setVisibility(0);
                this.fwi.setVisibility(8);
                if (this.fwq != null) {
                    this.fwq.eP(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.dUo = i2;
    }

    public void lu(boolean z) {
        if (this.boW != null) {
            if (this.dUb != null) {
                this.dUb.setVisibility(z ? 0 : 8);
            }
            this.boW.lv(z);
        }
    }

    public int bD(Context context) {
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

    public int bea() {
        return this.alv;
    }

    public void a(k kVar) {
        this.fwu = kVar;
    }

    public void a(j jVar) {
        this.fwv = jVar;
    }

    public void a(e eVar) {
        this.fww = eVar;
    }
}
