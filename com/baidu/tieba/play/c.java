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
import com.baidu.tieba.play.t;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int ecp;
    private String aMi;
    private String aXu;
    private TbPageContext<?> abI;
    private QuickVideoView bUg;
    private View bUi;
    private ImageView bUj;
    private View bUn;
    private p bqj;
    private Animation cBG;
    private Animation cBH;
    private View dpI;
    protected View ebG;
    private VideoListMediaControllerView ebI;
    private View ebJ;
    private FrameLayout ebK;
    protected FrameLayout.LayoutParams ebL;
    private ImageView ebN;
    private ImageView ebO;
    private View ebP;
    private View ebR;
    private TbImageView ebS;
    private g.InterfaceC0121g ebT;
    private ImageView ebV;
    private TextView ebW;
    private View ecc;
    private View ecd;
    private TextView ece;
    private SeekBar ecf;
    private ImageView ecg;
    private ImageView ech;
    private int eci;
    private int ecn;
    private int eco;
    private CallStateReceiver ecq;
    private ProgressBar fEQ;
    private View fER;
    private TextView fES;
    private TextView fET;
    private TextView fEU;
    private g.a fEV;
    private g.b fEW;
    private b fEX;
    private InterfaceC0120c fEY;
    private f fEZ;
    private h fFa;
    private i fFb;
    private k fFc;
    private j fFd;
    private e fFe;
    private TextView fFi;
    private g fch;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fEP = false;
    protected boolean dmH = false;
    private boolean ebX = false;
    private boolean ebZ = false;
    private int ecb = 0;
    private int mStatus = 0;
    private int ecj = 0;
    private int eck = 0;
    private boolean ecr = false;
    private boolean fFf = true;
    private boolean fFg = true;
    private boolean fFh = false;
    private String fbN = null;
    private int alR = -1;
    private boolean fFj = false;
    private g.InterfaceC0121g aWb = new g.InterfaceC0121g() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.InterfaceC0121g
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ect);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ect, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecv);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fFk);
            if (c.this.bUg.bhr()) {
                c.this.alR = 1;
                c.this.bUg.setRecoveryState(1);
            }
            if (gVar != null && c.this.ebI != null) {
                c.this.ecb = w.bhK().qT(c.this.aXu);
                c.this.ebI.V(c.this.ecb, gVar.getDuration());
                if (c.this.ecb != 0) {
                    if (c.this.bUg != null) {
                        c.this.bUg.seekTo(c.this.ecb);
                    } else {
                        gVar.seekTo(c.this.ecb);
                    }
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ect);
                    c.this.fFh = true;
                }
            }
        }
    };
    private Runnable ect = new Runnable() { // from class: com.baidu.tieba.play.c.14
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUg.getCurrentPosition() > 100) {
                c.this.ebX = true;
                c.this.ebJ.setVisibility(8);
                c.this.bUn.setVisibility(8);
                c.this.dpI.setVisibility(8);
                c.this.ebS.setVisibility(8);
                c.this.aGQ();
                if (c.this.alR == 1 || c.this.alR == 2) {
                    if (c.this.ebP != null) {
                        c.this.ebP.setVisibility(0);
                        c.this.fER.setVisibility(0);
                        c.this.fEQ.setVisibility(8);
                        if (c.this.fEY != null) {
                            c.this.fEY.eL(false);
                        }
                    }
                    c.this.ebI.showProgress();
                    c.this.aGR();
                }
                if (c.this.ebT != null) {
                    c.this.ebT.onPrepared(c.this.bUg.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ect, 20L);
        }
    };
    private g.a aWa = new g.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.ebX = false;
            c.this.ecb = 0;
            c.this.aGy();
            c.this.ebJ.setVisibility(0);
            c.this.fEQ.setVisibility(8);
            c.this.fEQ.setProgress(c.this.fEQ.getMax());
            if (c.this.fEY != null) {
                c.this.fEY.eL(false);
            }
            if (c.this.dmH) {
                c.this.ebP.setVisibility(0);
                c.this.ebV.setVisibility(0);
                c.this.ebW.setVisibility(0);
                c.this.fER.setVisibility(8);
            } else {
                c.this.ebP.setVisibility(8);
                c.this.ebV.setVisibility(8);
                c.this.ebW.setVisibility(8);
                c.this.fER.setVisibility(8);
            }
            if (c.this.bUg == null || c.this.bUg.getDuration() > 150000) {
                c.this.ln(false);
            } else {
                c.this.fES.setVisibility(0);
            }
            w.bhK().remove(c.this.aXu);
            if (c.this.fEV != null) {
                c.this.fEV.onCompletion(gVar);
            }
            c.this.alR = 3;
            c.this.bUg.setRecoveryState(3);
            if (!c.this.dmH && c.this.bUg != null && c.this.bUg.getDuration() <= 150000) {
                if (!c.this.fFj) {
                    if (c.this.fFa != null) {
                        c.this.fFa.jQ(true);
                    }
                    c.this.bK(c.this.aXu, c.this.aMi);
                    return;
                }
                c.this.alR = 5;
                c.this.bUg.setRecoveryState(5);
                c.this.bUg.getPlayer().pause();
                c.this.bUg.getPlayer().seekTo(0);
            }
        }
    };
    private g.b ecu = new g.b() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.bUn.setVisibility(0);
            c.this.dpI.setVisibility(8);
            c.this.alR = 4;
            c.this.bUg.setRecoveryState(4);
            if (c.this.fEW != null) {
                c.this.fEW.onError(gVar, i2, i3);
                return true;
            }
            return true;
        }
    };
    private Runnable ecv = new Runnable() { // from class: com.baidu.tieba.play.c.17
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUg == null || !c.this.bUg.bhs()) {
                c.this.bUn.setVisibility(0);
                c.this.dpI.setVisibility(8);
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecv, 60000L);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFk, 10000L);
        }
    };
    private Runnable fFk = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUg != null) {
                c.this.bUg.bht();
                c.this.bUg.bhu();
            }
        }
    };
    private g.h aWf = new g.h() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.h
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fFh) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFl, 200L);
            }
        }
    };
    private Runnable fFl = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUg == null || !c.this.fFh) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ect, 200L);
                c.this.fFh = false;
            } else if (c.this.ecb != c.this.bUg.getCurrentPosition()) {
                c.this.fFh = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ect, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFl, 200L);
            }
        }
    };
    private QuickVideoView.b bSr = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.ebX = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ect);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecv);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fFk);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bUn.getId()) {
                c.this.bhd();
            } else if (view.getId() != c.this.bUj.getId() && view.getId() != c.this.ebN.getId()) {
                if (view.getId() == c.this.fET.getId()) {
                    if (c.this.fEZ != null) {
                        c.this.fEZ.aXp();
                    }
                } else if (view.getId() == c.this.fES.getId()) {
                    if (c.this.fFa != null) {
                        c.this.fFa.jQ(false);
                    }
                    c.this.bK(c.this.aXu, c.this.aMi);
                } else if (view.getId() != c.this.ebO.getId()) {
                    if (view.getId() == c.this.ebV.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fFd != null) {
                            c.this.fFd.akz();
                        }
                        c.this.aGC();
                    }
                } else {
                    if (c.this.dmH) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fFd != null) {
                        c.this.fFd.akz();
                    }
                    c.this.aGC();
                }
            } else {
                c.this.aXf();
            }
        }
    };
    private Animation.AnimationListener ecx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.ebP != null) {
                c.this.ebP.setVisibility(8);
                c.this.fEQ.setVisibility(0);
                c.this.ebZ = false;
                if (c.this.fEY != null) {
                    c.this.fEY.akA();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener ecy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable ecz = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aGO();
        }
    };
    private CustomMessageListener ecA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private t.b efj = new t.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.t.b
        public void gn(int i2) {
            int duration;
            if (c.this.bUg != null && (duration = c.this.bUg.getDuration()) > 0 && c.this.fEQ != null) {
                c.this.fEQ.setProgress((int) ((i2 * c.this.ebG.getWidth()) / duration));
            }
            c.this.nZ(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener baf = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.ebZ) {
                c.this.aGR();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aGN() && c.this.aGD() != null) {
                c.this.setStartPosition(c.this.aGD().getSeekPosition());
                c.this.bK(c.this.aXu, c.this.aMi);
            }
        }
    };
    private QuickVideoView.a fFm = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bhj() {
            if (!c.this.fFj) {
                c.this.dpI.setVisibility(0);
                c.this.ebS.setVisibility(0);
                c.this.bUj.setVisibility(8);
                c.this.ebN.setImageResource(d.f.icon_video_midplay);
                c.this.fET.setVisibility(8);
                c.this.fES.setVisibility(8);
                c.this.fEU.setVisibility(8);
                c.this.bUn.setVisibility(8);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecv);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecv, 60000L);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fFk);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFk, 10000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void akw();

        void akx();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0120c {
        void akA();

        void eL(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void jP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eK(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aXp();
    }

    /* loaded from: classes.dex */
    public interface g {
        void akB();
    }

    /* loaded from: classes.dex */
    public interface h {
        void jQ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void aky();

        void akz();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aXo();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.ecn = 0;
        if (tbPageContext != null) {
            this.abI = tbPageContext;
            this.ebG = q(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.ebG);
            }
            this.ebR = view;
            this.ebG.setOnClickListener(this.mOnClickListener);
            this.bUg = (QuickVideoView) this.ebG.findViewById(d.g.videoView);
            this.dpI = this.ebG.findViewById(d.g.video_list_layout_loading);
            this.ebI = (VideoListMediaControllerView) this.ebG.findViewById(d.g.media_controller);
            this.ebI.setPlayer(this.bUg);
            this.fEQ = (ProgressBar) this.ebG.findViewById(d.g.pgrBottomProgress);
            this.fEQ.setMax(com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity()));
            this.fEQ.setProgress(0);
            this.ebI.setOnSeekBarChangeListener(this.baf);
            this.ebI.setOnProgressUpdatedListener(this.efj);
            this.ebJ = this.ebG.findViewById(d.g.black_mask);
            this.bUn = this.ebG.findViewById(d.g.layout_error);
            this.bUn.setOnClickListener(this.mOnClickListener);
            this.fFi = (TextView) this.ebG.findViewById(d.g.auto_video_error_tips);
            this.ebK = (FrameLayout) this.ebG.findViewById(d.g.danmu_container);
            this.ebN = (ImageView) this.ebG.findViewById(d.g.img_play_icon);
            this.ebN.setOnClickListener(this.mOnClickListener);
            this.ebO = (ImageView) this.ebG.findViewById(d.g.img_full_screen);
            this.ebO.setOnClickListener(this.mOnClickListener);
            this.ebP = this.ebG.findViewById(d.g.layout_media_controller);
            this.fER = this.ebG.findViewById(d.g.time_show_controller);
            this.bUg.setOnPreparedListener(this.aWb);
            this.bUg.setOnCompletionListener(this.aWa);
            this.bUg.setOnErrorListener(this.ecu);
            this.bUg.setOnSeekCompleteListener(this.aWf);
            this.bUg.setOnSurfaceDestroyedListener(this.bSr);
            this.bUg.setOnRecoveryCallback(this.fFm);
            this.bUj = (ImageView) this.ebG.findViewById(d.g.img_play);
            this.bUj.setOnClickListener(this.mOnClickListener);
            this.fES = (TextView) this.ebG.findViewById(d.g.txt_replay);
            this.fES.setOnClickListener(this.mOnClickListener);
            this.fET = (TextView) this.ebG.findViewById(d.g.txt_playnext);
            this.fET.setOnClickListener(this.mOnClickListener);
            this.fEU = (TextView) this.ebG.findViewById(d.g.txt_next_video_title);
            this.ebS = (TbImageView) this.ebG.findViewById(d.g.video_thumbnail);
            this.ebS.setDefaultErrorResource(0);
            this.ebS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity());
            this.mScreenHeight = bD(this.abI.getPageActivity());
            this.ebV = (ImageView) this.ebG.findViewById(d.g.img_exit);
            this.ebV.setOnClickListener(this.mOnClickListener);
            this.ebW = (TextView) this.ebG.findViewById(d.g.video_title);
            this.bUi = this.ebG.findViewById(d.g.layout_title);
            this.bUi.setVisibility(8);
            this.cBG = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cBH = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.abI.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eci = this.mAudioManager.getStreamMaxVolume(3);
            this.eco = this.mAudioManager.getStreamVolume(3);
            ecp = 100 / this.eci;
            this.ebG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fFb != null) {
                        c.this.fFb.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.ebX) {
                            if (c.this.mStatus == 1 && c.this.eck != 0) {
                                c.this.b(c.this.eck == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eck = 0;
                                c.this.ecj = 0;
                            }
                            if (!c.this.bUg.isPlaying() && 8 == c.this.bUj.getVisibility()) {
                                c.this.bUj.setVisibility(0);
                                c.this.fET.setVisibility(8);
                                c.this.fES.setVisibility(8);
                                c.this.fEU.setVisibility(8);
                            }
                        }
                        c.this.aGy();
                        if (c.this.fFb != null) {
                            c.this.fFb.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bqj = new p(this.abI.getPageActivity());
            this.bqj.start();
            this.ecn = com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds16);
            this.ecq = new CallStateReceiver();
            this.ecq.register(this.abI.getPageActivity());
            this.abI.registerListener(this.ecA);
            bgZ();
        }
    }

    public void bgZ() {
        if (this.fFf) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ebG.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.ebG.setSystemUiVisibility(0);
    }

    public void lk(boolean z) {
        this.fFf = z;
        bgZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGy() {
        this.mStatus = 0;
        if (this.ecc != null && this.ecc.getParent() != null && (this.ecc.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ecc.getParent()).removeView(this.ecc);
                this.ecc = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ecd != null && this.ecd.getParent() != null && (this.ecd.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ecd.getParent()).removeView(this.ecd);
                this.ecd = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aGz() {
        if (this.mStatus == 1) {
            if (this.ecc == null && this.ebG != null && (this.ebG instanceof ViewGroup)) {
                LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.ebG, true);
                this.ecc = this.ebG.findViewById(d.g.lay_jindu);
                this.ece = (TextView) this.ecc.findViewById(d.g.show_time);
                this.ech = (ImageView) this.ecc.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ecd == null && this.ebG != null && (this.ebG instanceof ViewGroup)) {
            LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.ebG, true);
            this.ecd = this.ebG.findViewById(d.g.lay_voice);
            this.ecg = (ImageView) this.ecd.findViewById(d.g.arrow_voice_icon);
            this.ecf = (SeekBar) this.ecd.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fFb != null) {
                c.this.fFb.onStart();
            }
            if (c.this.dmH && c.this.ebX) {
                if (!c.this.bUg.isPlaying() && c.this.bUj.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bUj.setVisibility(8);
                    c.this.fET.setVisibility(8);
                    c.this.fES.setVisibility(8);
                    c.this.fEU.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.V(f2);
                    }
                } else {
                    if (c.this.dmH) {
                        c.this.aGB();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ecj = c.this.bUg.getCurrentPosition();
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
            if (c.this.fFc != null) {
                c.this.fFc.aXo();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.ebX) {
                if (c.this.alR != 2) {
                    c.this.bhf();
                } else {
                    c.this.aXf();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.ebG.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.ebG.setSystemUiVisibility(4);
        } else {
            this.ebG.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f2) {
        if (!this.ebX) {
            this.mStatus = 0;
            return;
        }
        aGz();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ecp == 0) {
            if (f2 > 0.0f && this.eco < this.eci) {
                this.eco++;
            }
            if (f2 < 0.0f && this.eco > 0) {
                this.eco--;
            }
        }
        if (this.mProgress > 0) {
            this.ecg.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.ecg.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eco, 0);
        this.ecf.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ecj -= 1000;
                this.eck = 1;
            } else {
                this.ecj += 1000;
                this.eck = 2;
            }
            if (this.ecj < 0) {
                this.ecj = 0;
            } else if (this.ecj > this.bUg.getDuration()) {
                this.ecj = this.bUg.getDuration();
            }
        }
        aGz();
        String sd = this.ebI.sd(this.ecj);
        if (f2 > 0.0f) {
            this.ech.setImageResource(d.f.icon_kuaitui);
        } else {
            this.ech.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(sd)) {
            this.ece.setText(new StringBuilder().append(sd).append("/").append(this.ebI.sd(this.bUg.getDuration())));
        }
        this.ebI.A(this.ecj, z ? false : true);
        this.ebP.setVisibility(8);
        this.fEQ.setVisibility(0);
        bha();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bJ(String str, String str2) {
        this.aXu = str;
        this.aMi = str2;
    }

    public void aXf() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.abI.getPageActivity(), this.abI.getString(d.j.neterror));
        } else if (this.bUg.isPlaying()) {
            pausePlay();
        } else if (this.ebX) {
            aGM();
            if (this.fch != null) {
                this.fch.akB();
            }
        } else {
            bhd();
        }
    }

    public void aGC() {
        this.ecr = true;
        if (this.bqj != null) {
            this.bqj.aGC();
        }
    }

    public boolean sb(int i2) {
        switch (i2) {
            case 4:
                if (this.dmH) {
                    aGC();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eci <= 0 || this.ecf == null) {
                    return false;
                }
                this.eco = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eco * 100.0d) / this.eci);
                this.ecf.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bUg;
    }

    public VideoListMediaControllerView aGD() {
        return this.ebI;
    }

    public void show() {
        this.ebG.setVisibility(0);
    }

    public void aGH() {
        if (this.ebR != null) {
            ViewGroup.LayoutParams layoutParams = this.ebR.getLayoutParams();
            this.ebL = (FrameLayout.LayoutParams) this.ebG.getLayoutParams();
            this.ebL.width = layoutParams.width;
            this.ebL.height = layoutParams.height;
            this.ebL.topMargin = 0;
            this.ebG.setLayoutParams(this.ebL);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ecr) {
            if (this.dmH) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.ecr = false;
        }
        if (configuration.orientation == 2) {
            this.dmH = true;
            this.ebG.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.ebP.setVisibility(0);
            this.bUi.setVisibility(0);
            this.ebV.setVisibility(0);
            this.ebW.setVisibility(0);
            this.ebK.setVisibility(8);
            if (this.fEX != null) {
                this.fEX.akw();
            }
            this.ebO.setImageResource(d.f.icon_suoxiao);
            nX(this.ecn);
            aGB();
        } else {
            this.dmH = false;
            if (this.ebL != null) {
                this.ebG.setLayoutParams(this.ebL);
            }
            a(tbPageContext, false);
            this.bUi.setVisibility(8);
            this.ebK.setVisibility(0);
            if (this.fEX != null) {
                this.fEX.akx();
            }
            if (this.alR == 3 && this.fEY != null) {
                this.fEY.eL(false);
            } else if (!this.ebX && this.ebP != null) {
                this.ebP.clearAnimation();
                this.ebP.setVisibility(4);
                this.fEQ.setVisibility(0);
                if (this.fEY != null) {
                    this.fEY.akA();
                }
            }
            aGy();
            this.ebO.setImageResource(d.f.icon_fangda);
            nX(0);
            this.ebG.setSystemUiVisibility(0);
            bgZ();
        }
        if (this.bUg.isPlaying()) {
            aGR();
        }
        bha();
    }

    public void bha() {
        if (this.bUg != null) {
            int ac = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity());
            if (this.dmH) {
                ac = com.baidu.adp.lib.util.l.ae(this.abI.getPageActivity());
            }
            this.fEQ.setMax(ac);
            int duration = this.bUg.getDuration();
            if (duration > 0) {
                if (this.fES.getVisibility() == 0) {
                    this.fEQ.setProgress(this.fEQ.getMax());
                } else {
                    this.fEQ.setProgress((int) ((this.bUg.getCurrentPosition() * this.fEQ.getMax()) / duration));
                }
            }
        }
    }

    private void nX(int i2) {
        if (this.ebI != null && (this.ebI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ebI.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.ebI.setLayoutParams(layoutParams);
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

    public boolean aGJ() {
        return !this.dmH;
    }

    public void a(g.a aVar) {
        this.fEV = aVar;
    }

    public void a(g.b bVar) {
        this.fEW = bVar;
    }

    public void aGK() {
        this.ebN.setImageResource(d.f.icon_video_midpause);
        this.dpI.setVisibility(8);
        this.bUj.setVisibility(0);
        this.fET.setVisibility(8);
        this.fES.setVisibility(8);
        this.fEU.setVisibility(8);
        this.alR = 2;
        this.bUg.setRecoveryState(2);
    }

    public void bK(String str, String str2) {
        this.alR = 0;
        this.bUg.setRecoveryState(0);
        bJ(str, str2);
        this.bUg.bL(str, str2);
        this.bUg.start();
        this.dpI.setVisibility(0);
        this.ebS.setVisibility(0);
        this.bUj.setVisibility(8);
        this.ebN.setImageResource(d.f.icon_video_midplay);
        this.fET.setVisibility(8);
        this.fES.setVisibility(8);
        this.fEU.setVisibility(8);
        this.bUn.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecv);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ecv, 60000L);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFk);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fFk, 10000L);
    }

    public void aGM() {
        this.alR = 1;
        this.bUg.setRecoveryState(1);
        this.bUg.start();
        this.ebN.setImageResource(d.f.icon_video_midplay);
        this.ebS.setVisibility(8);
        this.ebJ.setVisibility(8);
        this.dpI.setVisibility(8);
        this.ebI.showProgress();
        this.bUj.setVisibility(8);
        this.fET.setVisibility(8);
        this.fES.setVisibility(8);
        this.fEU.setVisibility(8);
        bhh();
    }

    public void ll(boolean z) {
        if (this.bUg != null) {
            this.bUg.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bUg.isPlaying() && this.fFg) {
            bhb();
        }
        bhg();
        this.bUg.pause();
        aGK();
    }

    public void stopPlay() {
        if (this.bUg.isPlaying() && this.fFg) {
            bhb();
        }
        this.alR = 5;
        this.bUg.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ect);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecv);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFk);
        this.bUg.stopPlayback();
        this.ebX = false;
        this.ecb = 0;
        asW();
    }

    public void bhb() {
        w.bhK().au(this.aXu, this.bUg.getCurrentPosition());
    }

    public void lm(boolean z) {
        this.fFg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(boolean z) {
        if (this.ebP != null) {
            this.ebJ.setVisibility(0);
            this.bUj.setVisibility(0);
            this.fET.setVisibility(8);
            this.fES.setVisibility(8);
            this.fEU.setVisibility(8);
            this.dpI.setVisibility(8);
            this.ebN.setImageResource(d.f.icon_video_midpause);
            this.ebP.setVisibility(4);
            this.fEQ.setVisibility(8);
            this.bUn.setVisibility(8);
            this.ebI.LG();
            this.ebS.setVisibility(z ? 0 : 8);
        }
    }

    public void asW() {
        ln(true);
    }

    public boolean bhc() {
        if (this.bUg == null) {
            return false;
        }
        return this.bUg.isPlaying();
    }

    public void a(i iVar) {
        this.fFb = iVar;
    }

    public void a(h hVar) {
        this.fFa = hVar;
    }

    public void a(g gVar) {
        this.fch = gVar;
    }

    public void a(f fVar) {
        this.fEZ = fVar;
    }

    public void pW(String str) {
        this.fbN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhd() {
        a(this.aXu, this.aMi, (d) null);
    }

    public void b(InterfaceC0120c interfaceC0120c) {
        this.fEY = interfaceC0120c;
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fFe != null) {
                    this.fFe.eK(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abI.getPageActivity());
                aVar.cS(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bhe();
                        c.this.bK(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.jP(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.abI).th();
                return;
            } else if (this.fFe != null) {
                this.fFe.eK(true);
                return;
            } else {
                if (!this.fEP) {
                    this.fEP = true;
                    com.baidu.adp.lib.util.l.showToast(this.abI.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                bK(str, str2);
                if (dVar != null) {
                    dVar.jP(true);
                    return;
                }
                return;
            }
        }
        bK(str, str2);
        if (dVar != null) {
            dVar.jP(true);
        }
        if (this.fFd != null) {
            this.fFd.aky();
        }
    }

    public void bhe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nE(String str) {
        this.ebS.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecz);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ect);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecv);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFl);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFk);
        this.bqj.stop();
        this.ecq.unregister(this.abI.getPageActivity());
    }

    public void setVideoTitle(String str) {
        this.ebW.setText(str);
    }

    public boolean aGN() {
        return this.ebX;
    }

    public void aGO() {
        if (this.ebP != null) {
            aGQ();
            this.ebP.setVisibility(0);
            this.fER.setVisibility(0);
            if (this.fEY != null) {
                this.fEY.eL(true);
            }
            this.fEQ.setVisibility(8);
            this.cBG.setAnimationListener(this.ecx);
            this.ebP.startAnimation(this.cBG);
            this.ebZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhf() {
        if (this.ebP != null) {
            if (this.ebP.getVisibility() == 0) {
                aGQ();
                this.ebP.setVisibility(8);
                this.fEQ.setVisibility(0);
                if (this.fEY != null) {
                    this.fEY.akA();
                    return;
                }
                return;
            }
            aGR();
        }
    }

    public void aGP() {
        if (this.ebP != null) {
            aGQ();
            this.ebP.setVisibility(0);
            this.fER.setVisibility(0);
            if (this.fEY != null) {
                this.fEY.eL(false);
            }
            this.fEQ.setVisibility(8);
            this.cBH.setAnimationListener(this.ecy);
            this.ebP.startAnimation(this.cBH);
        }
    }

    public void bhg() {
        if (this.ebP != null) {
            aGQ();
            this.ebP.setVisibility(0);
            this.fER.setVisibility(0);
            this.fEQ.setVisibility(8);
            if (this.fEY != null) {
                this.fEY.eL(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGQ() {
        if (this.ebP != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecz);
            this.cBH.setAnimationListener(null);
            this.cBG.setAnimationListener(null);
            this.ebP.clearAnimation();
            this.ebZ = false;
        }
    }

    public void aGR() {
        aGP();
        bhh();
    }

    private void bhh() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecz);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ecz, 3000L);
    }

    public void a(b bVar) {
        this.fEX = bVar;
    }

    public void nZ(int i2) {
        if (this.bUg.getDuration() - i2 <= 3000) {
            aGQ();
            if (this.ebP != null) {
                this.ebP.setVisibility(0);
                this.fER.setVisibility(0);
                this.fEQ.setVisibility(8);
                if (this.fEY != null) {
                    this.fEY.eL(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.ecb = i2;
    }

    public void lo(boolean z) {
        if (this.bqj != null) {
            if (this.ebO != null) {
                this.ebO.setVisibility(z ? 0 : 8);
            }
            this.bqj.lq(z);
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
            return com.baidu.adp.lib.util.l.ae(context);
        }
        return i2;
    }

    public int bhi() {
        return this.alR;
    }

    public void a(k kVar) {
        this.fFc = kVar;
    }

    public void a(j jVar) {
        this.fFd = jVar;
    }

    public void a(e eVar) {
        this.fFe = eVar;
    }

    public void lp(boolean z) {
        this.fFj = z;
    }
}
