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
    private static int ect;
    private String aMq;
    private String aXD;
    private TbPageContext<?> abI;
    private View bUA;
    private QuickVideoView bUt;
    private View bUv;
    private ImageView bUw;
    private p bqt;
    private Animation cBZ;
    private Animation cCa;
    private View dqc;
    protected View ebK;
    private VideoListMediaControllerView ebM;
    private View ebN;
    private FrameLayout ebO;
    protected FrameLayout.LayoutParams ebP;
    private ImageView ebR;
    private ImageView ebS;
    private View ebT;
    private View ebV;
    private TbImageView ebW;
    private g.InterfaceC0124g ebX;
    private ImageView ebZ;
    private TextView eca;
    private View ecg;
    private View ech;
    private TextView eci;
    private SeekBar ecj;
    private ImageView eck;
    private ImageView ecl;
    private int ecm;
    private int ecr;
    private int ecs;
    private CallStateReceiver ecu;
    private j fFA;
    private e fFB;
    private TextView fFF;
    private ProgressBar fFn;
    private View fFo;
    private TextView fFp;
    private TextView fFq;
    private TextView fFr;
    private g.a fFs;
    private g.b fFt;
    private b fFu;
    private InterfaceC0122c fFv;
    private f fFw;
    private h fFx;
    private i fFy;
    private k fFz;
    private g fcD;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fFm = false;
    protected boolean dnb = false;
    private boolean ecb = false;
    private boolean ecd = false;
    private int ecf = 0;
    private int mStatus = 0;
    private int ecn = 0;
    private int eco = 0;
    private boolean ecv = false;
    private boolean fFC = true;
    private boolean fFD = true;
    private boolean fFE = false;
    private String fci = null;
    private int alQ = -1;
    private boolean fFG = false;
    private g.InterfaceC0124g aWj = new g.InterfaceC0124g() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.InterfaceC0124g
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecx);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecx, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecz);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fFH);
            if (c.this.bUt.bhz()) {
                c.this.alQ = 1;
                c.this.bUt.setRecoveryState(1);
            }
            if (gVar != null && c.this.ebM != null) {
                c.this.ecf = w.bhS().qX(c.this.aXD);
                c.this.ebM.V(c.this.ecf, gVar.getDuration());
                if (c.this.ecf != 0) {
                    if (c.this.bUt != null) {
                        c.this.bUt.seekTo(c.this.ecf);
                    } else {
                        gVar.seekTo(c.this.ecf);
                    }
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecx);
                    c.this.fFE = true;
                }
            }
        }
    };
    private Runnable ecx = new Runnable() { // from class: com.baidu.tieba.play.c.14
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUt.getCurrentPosition() > 100) {
                c.this.ecb = true;
                c.this.ebN.setVisibility(8);
                c.this.bUA.setVisibility(8);
                c.this.dqc.setVisibility(8);
                c.this.ebW.setVisibility(8);
                c.this.aGU();
                if (c.this.alQ == 1 || c.this.alQ == 2) {
                    if (c.this.ebT != null) {
                        c.this.ebT.setVisibility(0);
                        c.this.fFo.setVisibility(0);
                        c.this.fFn.setVisibility(8);
                        if (c.this.fFv != null) {
                            c.this.fFv.eQ(false);
                        }
                    }
                    c.this.ebM.showProgress();
                    c.this.aGV();
                }
                if (c.this.ebX != null) {
                    c.this.ebX.onPrepared(c.this.bUt.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecx, 20L);
        }
    };
    private g.a aWi = new g.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.ecb = false;
            c.this.ecf = 0;
            c.this.aGC();
            c.this.ebN.setVisibility(0);
            c.this.fFn.setVisibility(8);
            c.this.fFn.setProgress(c.this.fFn.getMax());
            if (c.this.fFv != null) {
                c.this.fFv.eQ(false);
            }
            if (c.this.dnb) {
                c.this.ebT.setVisibility(0);
                c.this.ebZ.setVisibility(0);
                c.this.eca.setVisibility(0);
                c.this.fFo.setVisibility(8);
            } else {
                c.this.ebT.setVisibility(8);
                c.this.ebZ.setVisibility(8);
                c.this.eca.setVisibility(8);
                c.this.fFo.setVisibility(8);
            }
            if (c.this.bUt == null || c.this.bUt.getDuration() > 150000) {
                c.this.lt(false);
            } else {
                c.this.fFp.setVisibility(0);
            }
            w.bhS().remove(c.this.aXD);
            if (c.this.fFs != null) {
                c.this.fFs.onCompletion(gVar);
            }
            c.this.alQ = 3;
            c.this.bUt.setRecoveryState(3);
            if (!c.this.dnb && c.this.bUt != null && c.this.bUt.getDuration() <= 150000) {
                if (!c.this.fFG) {
                    if (c.this.fFx != null) {
                        c.this.fFx.jW(true);
                    }
                    c.this.bL(c.this.aXD, c.this.aMq);
                    return;
                }
                c.this.alQ = 5;
                c.this.bUt.setRecoveryState(5);
                c.this.bUt.getPlayer().pause();
                c.this.bUt.getPlayer().seekTo(0);
            }
        }
    };
    private g.b ecy = new g.b() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.bUA.setVisibility(0);
            c.this.dqc.setVisibility(8);
            c.this.alQ = 4;
            c.this.bUt.setRecoveryState(4);
            if (c.this.fFt != null) {
                c.this.fFt.onError(gVar, i2, i3);
                return true;
            }
            return true;
        }
    };
    private Runnable ecz = new Runnable() { // from class: com.baidu.tieba.play.c.17
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUt == null || !c.this.bUt.bhA()) {
                c.this.bUA.setVisibility(0);
                c.this.dqc.setVisibility(8);
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecz, 60000L);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFH, 10000L);
        }
    };
    private Runnable fFH = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUt != null) {
                c.this.bUt.bhB();
                c.this.bUt.bhC();
            }
        }
    };
    private g.h aWn = new g.h() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.h
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fFE) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFI, 200L);
            }
        }
    };
    private Runnable fFI = new Runnable() { // from class: com.baidu.tieba.play.c.20
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bUt == null || !c.this.fFE) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecx, 200L);
                c.this.fFE = false;
            } else if (c.this.ecf != c.this.bUt.getCurrentPosition()) {
                c.this.fFE = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecx, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFI, 200L);
            }
        }
    };
    private QuickVideoView.b bSE = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.ecb = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecx);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecz);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fFH);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bUA.getId()) {
                c.this.bhl();
            } else if (view.getId() != c.this.bUw.getId() && view.getId() != c.this.ebR.getId()) {
                if (view.getId() == c.this.fFq.getId()) {
                    if (c.this.fFw != null) {
                        c.this.fFw.aXx();
                    }
                } else if (view.getId() == c.this.fFp.getId()) {
                    if (c.this.fFx != null) {
                        c.this.fFx.jW(false);
                    }
                    c.this.bL(c.this.aXD, c.this.aMq);
                } else if (view.getId() != c.this.ebS.getId()) {
                    if (view.getId() == c.this.ebZ.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fFA != null) {
                            c.this.fFA.akN();
                        }
                        c.this.aGG();
                    }
                } else {
                    if (c.this.dnb) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fFA != null) {
                        c.this.fFA.akN();
                    }
                    c.this.aGG();
                }
            } else {
                c.this.aXn();
            }
        }
    };
    private Animation.AnimationListener ecB = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.ebT != null) {
                c.this.ebT.setVisibility(8);
                c.this.fFn.setVisibility(0);
                c.this.ecd = false;
                if (c.this.fFv != null) {
                    c.this.fFv.akO();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener ecC = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
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
    private Runnable ecD = new Runnable() { // from class: com.baidu.tieba.play.c.8
        @Override // java.lang.Runnable
        public void run() {
            c.this.aGS();
        }
    };
    private CustomMessageListener ecE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private t.b efn = new t.b() { // from class: com.baidu.tieba.play.c.10
        @Override // com.baidu.tieba.play.t.b
        public void gm(int i2) {
            int duration;
            if (c.this.bUt != null && (duration = c.this.bUt.getDuration()) > 0 && c.this.fFn != null) {
                c.this.fFn.setProgress((int) ((i2 * c.this.ebK.getWidth()) / duration));
            }
            c.this.oa(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bao = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.11
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.ecd) {
                c.this.aGV();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aGR() && c.this.aGH() != null) {
                c.this.setStartPosition(c.this.aGH().getSeekPosition());
                c.this.bL(c.this.aXD, c.this.aMq);
            }
        }
    };
    private QuickVideoView.a fFJ = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bhr() {
            if (!c.this.fFG) {
                c.this.dqc.setVisibility(0);
                c.this.ebW.setVisibility(0);
                c.this.bUw.setVisibility(8);
                c.this.ebR.setImageResource(d.f.icon_video_midplay);
                c.this.fFq.setVisibility(8);
                c.this.fFp.setVisibility(8);
                c.this.fFr.setVisibility(8);
                c.this.bUA.setVisibility(8);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ecz);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ecz, 60000L);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.fFH);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fFH, 10000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void akK();

        void akL();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122c {
        void akO();

        void eQ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void jV(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aXx();
    }

    /* loaded from: classes.dex */
    public interface g {
        void akP();
    }

    /* loaded from: classes.dex */
    public interface h {
        void jW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void akM();

        void akN();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aXw();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.ecr = 0;
        if (tbPageContext != null) {
            this.abI = tbPageContext;
            this.ebK = q(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.ebK);
            }
            this.ebV = view;
            this.ebK.setOnClickListener(this.mOnClickListener);
            this.bUt = (QuickVideoView) this.ebK.findViewById(d.g.videoView);
            this.dqc = this.ebK.findViewById(d.g.video_list_layout_loading);
            this.ebM = (VideoListMediaControllerView) this.ebK.findViewById(d.g.media_controller);
            this.ebM.setPlayer(this.bUt);
            this.fFn = (ProgressBar) this.ebK.findViewById(d.g.pgrBottomProgress);
            this.fFn.setMax(com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity()));
            this.fFn.setProgress(0);
            this.ebM.setOnSeekBarChangeListener(this.bao);
            this.ebM.setOnProgressUpdatedListener(this.efn);
            this.ebN = this.ebK.findViewById(d.g.black_mask);
            this.bUA = this.ebK.findViewById(d.g.layout_error);
            this.bUA.setOnClickListener(this.mOnClickListener);
            this.fFF = (TextView) this.ebK.findViewById(d.g.auto_video_error_tips);
            this.ebO = (FrameLayout) this.ebK.findViewById(d.g.danmu_container);
            this.ebR = (ImageView) this.ebK.findViewById(d.g.img_play_icon);
            this.ebR.setOnClickListener(this.mOnClickListener);
            this.ebS = (ImageView) this.ebK.findViewById(d.g.img_full_screen);
            this.ebS.setOnClickListener(this.mOnClickListener);
            this.ebT = this.ebK.findViewById(d.g.layout_media_controller);
            this.fFo = this.ebK.findViewById(d.g.time_show_controller);
            this.bUt.setOnPreparedListener(this.aWj);
            this.bUt.setOnCompletionListener(this.aWi);
            this.bUt.setOnErrorListener(this.ecy);
            this.bUt.setOnSeekCompleteListener(this.aWn);
            this.bUt.setOnSurfaceDestroyedListener(this.bSE);
            this.bUt.setOnRecoveryCallback(this.fFJ);
            this.bUw = (ImageView) this.ebK.findViewById(d.g.img_play);
            this.bUw.setOnClickListener(this.mOnClickListener);
            this.fFp = (TextView) this.ebK.findViewById(d.g.txt_replay);
            this.fFp.setOnClickListener(this.mOnClickListener);
            this.fFq = (TextView) this.ebK.findViewById(d.g.txt_playnext);
            this.fFq.setOnClickListener(this.mOnClickListener);
            this.fFr = (TextView) this.ebK.findViewById(d.g.txt_next_video_title);
            this.ebW = (TbImageView) this.ebK.findViewById(d.g.video_thumbnail);
            this.ebW.setDefaultErrorResource(0);
            this.ebW.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity());
            this.mScreenHeight = bD(this.abI.getPageActivity());
            this.ebZ = (ImageView) this.ebK.findViewById(d.g.img_exit);
            this.ebZ.setOnClickListener(this.mOnClickListener);
            this.eca = (TextView) this.ebK.findViewById(d.g.video_title);
            this.bUv = this.ebK.findViewById(d.g.layout_title);
            this.bUv.setVisibility(8);
            this.cBZ = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cCa = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.abI.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.ecm = this.mAudioManager.getStreamMaxVolume(3);
            this.ecs = this.mAudioManager.getStreamVolume(3);
            ect = 100 / this.ecm;
            this.ebK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fFy != null) {
                        c.this.fFy.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.ecb) {
                            if (c.this.mStatus == 1 && c.this.eco != 0) {
                                c.this.b(c.this.eco == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eco = 0;
                                c.this.ecn = 0;
                            }
                            if (!c.this.bUt.isPlaying() && 8 == c.this.bUw.getVisibility()) {
                                c.this.bUw.setVisibility(0);
                                c.this.fFq.setVisibility(8);
                                c.this.fFp.setVisibility(8);
                                c.this.fFr.setVisibility(8);
                            }
                        }
                        c.this.aGC();
                        if (c.this.fFy != null) {
                            c.this.fFy.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bqt = new p(this.abI.getPageActivity());
            this.bqt.start();
            this.ecr = com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds16);
            this.ecu = new CallStateReceiver();
            this.ecu.register(this.abI.getPageActivity());
            this.abI.registerListener(this.ecE);
            bhh();
        }
    }

    public void bhh() {
        if (this.fFC) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ebK.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.ebK.setSystemUiVisibility(0);
    }

    public void lq(boolean z) {
        this.fFC = z;
        bhh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGC() {
        this.mStatus = 0;
        if (this.ecg != null && this.ecg.getParent() != null && (this.ecg.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ecg.getParent()).removeView(this.ecg);
                this.ecg = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ech != null && this.ech.getParent() != null && (this.ech.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ech.getParent()).removeView(this.ech);
                this.ech = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aGD() {
        if (this.mStatus == 1) {
            if (this.ecg == null && this.ebK != null && (this.ebK instanceof ViewGroup)) {
                LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.ebK, true);
                this.ecg = this.ebK.findViewById(d.g.lay_jindu);
                this.eci = (TextView) this.ecg.findViewById(d.g.show_time);
                this.ecl = (ImageView) this.ecg.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ech == null && this.ebK != null && (this.ebK instanceof ViewGroup)) {
            LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.ebK, true);
            this.ech = this.ebK.findViewById(d.g.lay_voice);
            this.eck = (ImageView) this.ech.findViewById(d.g.arrow_voice_icon);
            this.ecj = (SeekBar) this.ech.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fFy != null) {
                c.this.fFy.onStart();
            }
            if (c.this.dnb && c.this.ecb) {
                if (!c.this.bUt.isPlaying() && c.this.bUw.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bUw.setVisibility(8);
                    c.this.fFq.setVisibility(8);
                    c.this.fFp.setVisibility(8);
                    c.this.fFr.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.V(f2);
                    }
                } else {
                    if (c.this.dnb) {
                        c.this.aGF();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ecn = c.this.bUt.getCurrentPosition();
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
            if (c.this.fFz != null) {
                c.this.fFz.aXw();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.ecb) {
                if (c.this.alQ != 2) {
                    c.this.bhn();
                } else {
                    c.this.aXn();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGF() {
        if (Build.VERSION.SDK_INT < 16) {
            this.ebK.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.ebK.setSystemUiVisibility(4);
        } else {
            this.ebK.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f2) {
        if (!this.ecb) {
            this.mStatus = 0;
            return;
        }
        aGD();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ect == 0) {
            if (f2 > 0.0f && this.ecs < this.ecm) {
                this.ecs++;
            }
            if (f2 < 0.0f && this.ecs > 0) {
                this.ecs--;
            }
        }
        if (this.mProgress > 0) {
            this.eck.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eck.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.ecs, 0);
        this.ecj.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ecn -= 1000;
                this.eco = 1;
            } else {
                this.ecn += 1000;
                this.eco = 2;
            }
            if (this.ecn < 0) {
                this.ecn = 0;
            } else if (this.ecn > this.bUt.getDuration()) {
                this.ecn = this.bUt.getDuration();
            }
        }
        aGD();
        String se = this.ebM.se(this.ecn);
        if (f2 > 0.0f) {
            this.ecl.setImageResource(d.f.icon_kuaitui);
        } else {
            this.ecl.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(se)) {
            this.eci.setText(new StringBuilder().append(se).append("/").append(this.ebM.se(this.bUt.getDuration())));
        }
        this.ebM.B(this.ecn, z ? false : true);
        this.ebT.setVisibility(8);
        this.fFn.setVisibility(0);
        bhi();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.aXD = str;
        this.aMq = str2;
    }

    public void aXn() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.abI.getPageActivity(), this.abI.getString(d.j.neterror));
        } else if (this.bUt.isPlaying()) {
            pausePlay();
        } else if (this.ecb) {
            aGQ();
            if (this.fcD != null) {
                this.fcD.akP();
            }
        } else {
            bhl();
        }
    }

    public void aGG() {
        this.ecv = true;
        if (this.bqt != null) {
            this.bqt.aGG();
        }
    }

    public boolean sc(int i2) {
        switch (i2) {
            case 4:
                if (this.dnb) {
                    aGG();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.ecm <= 0 || this.ecj == null) {
                    return false;
                }
                this.ecs = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.ecs * 100.0d) / this.ecm);
                this.ecj.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bUt;
    }

    public VideoListMediaControllerView aGH() {
        return this.ebM;
    }

    public void show() {
        this.ebK.setVisibility(0);
    }

    public void aGL() {
        if (this.ebV != null) {
            ViewGroup.LayoutParams layoutParams = this.ebV.getLayoutParams();
            this.ebP = (FrameLayout.LayoutParams) this.ebK.getLayoutParams();
            this.ebP.width = layoutParams.width;
            this.ebP.height = layoutParams.height;
            this.ebP.topMargin = 0;
            this.ebK.setLayoutParams(this.ebP);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ecv) {
            if (this.dnb) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.ecv = false;
        }
        if (configuration.orientation == 2) {
            this.dnb = true;
            this.ebK.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.ebT.setVisibility(0);
            this.bUv.setVisibility(0);
            this.ebZ.setVisibility(0);
            this.eca.setVisibility(0);
            this.ebO.setVisibility(8);
            if (this.fFu != null) {
                this.fFu.akK();
            }
            this.ebS.setImageResource(d.f.icon_suoxiao);
            nY(this.ecr);
            aGF();
        } else {
            this.dnb = false;
            if (this.ebP != null) {
                this.ebK.setLayoutParams(this.ebP);
            }
            a(tbPageContext, false);
            this.bUv.setVisibility(8);
            this.ebO.setVisibility(0);
            if (this.fFu != null) {
                this.fFu.akL();
            }
            if (this.alQ == 3 && this.fFv != null) {
                this.fFv.eQ(false);
            } else if (!this.ecb && this.ebT != null) {
                this.ebT.clearAnimation();
                this.ebT.setVisibility(4);
                this.fFn.setVisibility(0);
                if (this.fFv != null) {
                    this.fFv.akO();
                }
            }
            aGC();
            this.ebS.setImageResource(d.f.icon_fangda);
            nY(0);
            this.ebK.setSystemUiVisibility(0);
            bhh();
        }
        if (this.bUt.isPlaying()) {
            aGV();
        }
        bhi();
    }

    public void bhi() {
        if (this.bUt != null) {
            int ac = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity());
            if (this.dnb) {
                ac = com.baidu.adp.lib.util.l.ae(this.abI.getPageActivity());
            }
            this.fFn.setMax(ac);
            int duration = this.bUt.getDuration();
            if (duration > 0) {
                if (this.fFp.getVisibility() == 0) {
                    this.fFn.setProgress(this.fFn.getMax());
                } else {
                    this.fFn.setProgress((int) ((this.bUt.getCurrentPosition() * this.fFn.getMax()) / duration));
                }
            }
        }
    }

    private void nY(int i2) {
        if (this.ebM != null && (this.ebM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ebM.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.ebM.setLayoutParams(layoutParams);
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

    public boolean aGN() {
        return !this.dnb;
    }

    public void a(g.a aVar) {
        this.fFs = aVar;
    }

    public void a(g.b bVar) {
        this.fFt = bVar;
    }

    public void aGO() {
        this.ebR.setImageResource(d.f.icon_video_midpause);
        this.dqc.setVisibility(8);
        this.bUw.setVisibility(0);
        this.fFq.setVisibility(8);
        this.fFp.setVisibility(8);
        this.fFr.setVisibility(8);
        this.alQ = 2;
        this.bUt.setRecoveryState(2);
    }

    public void bL(String str, String str2) {
        this.alQ = 0;
        this.bUt.setRecoveryState(0);
        bK(str, str2);
        this.bUt.bM(str, str2);
        this.bUt.start();
        this.dqc.setVisibility(0);
        this.ebW.setVisibility(0);
        this.bUw.setVisibility(8);
        this.ebR.setImageResource(d.f.icon_video_midplay);
        this.fFq.setVisibility(8);
        this.fFp.setVisibility(8);
        this.fFr.setVisibility(8);
        this.bUA.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecz);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ecz, 60000L);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFH);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fFH, 10000L);
    }

    public void aGQ() {
        this.alQ = 1;
        this.bUt.setRecoveryState(1);
        this.bUt.start();
        this.ebR.setImageResource(d.f.icon_video_midplay);
        this.ebW.setVisibility(8);
        this.ebN.setVisibility(8);
        this.dqc.setVisibility(8);
        this.ebM.showProgress();
        this.bUw.setVisibility(8);
        this.fFq.setVisibility(8);
        this.fFp.setVisibility(8);
        this.fFr.setVisibility(8);
        bhp();
    }

    public void lr(boolean z) {
        if (this.bUt != null) {
            this.bUt.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bUt.isPlaying() && this.fFD) {
            bhj();
        }
        bho();
        this.bUt.pause();
        aGO();
    }

    public void stopPlay() {
        if (this.bUt.isPlaying() && this.fFD) {
            bhj();
        }
        this.alQ = 5;
        this.bUt.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecz);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFH);
        this.bUt.stopPlayback();
        this.ecb = false;
        this.ecf = 0;
        atn();
    }

    public void bhj() {
        w.bhS().au(this.aXD, this.bUt.getCurrentPosition());
    }

    public void ls(boolean z) {
        this.fFD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (this.ebT != null) {
            this.ebN.setVisibility(0);
            this.bUw.setVisibility(0);
            this.fFq.setVisibility(8);
            this.fFp.setVisibility(8);
            this.fFr.setVisibility(8);
            this.dqc.setVisibility(8);
            this.ebR.setImageResource(d.f.icon_video_midpause);
            this.ebT.setVisibility(4);
            this.fFn.setVisibility(8);
            this.bUA.setVisibility(8);
            this.ebM.LR();
            this.ebW.setVisibility(z ? 0 : 8);
        }
    }

    public void atn() {
        lt(true);
    }

    public boolean bhk() {
        if (this.bUt == null) {
            return false;
        }
        return this.bUt.isPlaying();
    }

    public void a(i iVar) {
        this.fFy = iVar;
    }

    public void a(h hVar) {
        this.fFx = hVar;
    }

    public void a(g gVar) {
        this.fcD = gVar;
    }

    public void a(f fVar) {
        this.fFw = fVar;
    }

    public void qa(String str) {
        this.fci = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        a(this.aXD, this.aMq, (d) null);
    }

    public void b(InterfaceC0122c interfaceC0122c) {
        this.fFv = interfaceC0122c;
    }

    public void a(String str, String str2, d dVar, long j2) {
        long currentTimeMillis;
        long j3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L);
        a(str, str2, dVar);
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(j3);
            Date date2 = new Date();
            currentTimeMillis = (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay()) ? System.currentTimeMillis() - j2 : 0L;
        } else {
            currentTimeMillis = System.currentTimeMillis() - j2;
        }
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bUt != null) {
            this.bUt.setPbLoadingTime(currentTimeMillis);
        }
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fFB != null) {
                    this.fFB.eP(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abI.getPageActivity());
                aVar.cS(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bhm();
                        c.this.bL(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.jV(false);
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
            } else if (this.fFB != null) {
                this.fFB.eP(true);
                return;
            } else {
                if (!this.fFm) {
                    this.fFm = true;
                    com.baidu.adp.lib.util.l.showToast(this.abI.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                bL(str, str2);
                if (dVar != null) {
                    dVar.jV(true);
                    return;
                }
                return;
            }
        }
        bL(str, str2);
        if (dVar != null) {
            dVar.jV(true);
        }
        if (this.fFA != null) {
            this.fFA.akM();
        }
    }

    public void bhm() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nG(String str) {
        this.ebW.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecD);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecz);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFI);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFH);
        this.bqt.stop();
        this.ecu.unregister(this.abI.getPageActivity());
    }

    public void setVideoTitle(String str) {
        this.eca.setText(str);
    }

    public boolean aGR() {
        return this.ecb;
    }

    public void aGS() {
        if (this.ebT != null) {
            aGU();
            this.ebT.setVisibility(0);
            this.fFo.setVisibility(0);
            if (this.fFv != null) {
                this.fFv.eQ(true);
            }
            this.fFn.setVisibility(8);
            this.cBZ.setAnimationListener(this.ecB);
            this.ebT.startAnimation(this.cBZ);
            this.ecd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhn() {
        if (this.ebT != null) {
            if (this.ebT.getVisibility() == 0) {
                aGU();
                this.ebT.setVisibility(8);
                this.fFn.setVisibility(0);
                if (this.fFv != null) {
                    this.fFv.akO();
                    return;
                }
                return;
            }
            aGV();
        }
    }

    public void aGT() {
        if (this.ebT != null) {
            aGU();
            this.ebT.setVisibility(0);
            this.fFo.setVisibility(0);
            if (this.fFv != null) {
                this.fFv.eQ(false);
            }
            this.fFn.setVisibility(8);
            this.cCa.setAnimationListener(this.ecC);
            this.ebT.startAnimation(this.cCa);
        }
    }

    public void bho() {
        if (this.ebT != null) {
            aGU();
            this.ebT.setVisibility(0);
            this.fFo.setVisibility(0);
            this.fFn.setVisibility(8);
            if (this.fFv != null) {
                this.fFv.eQ(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGU() {
        if (this.ebT != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecD);
            this.cCa.setAnimationListener(null);
            this.cBZ.setAnimationListener(null);
            this.ebT.clearAnimation();
            this.ecd = false;
        }
    }

    public void aGV() {
        aGT();
        bhp();
    }

    private void bhp() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ecD);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ecD, 3000L);
    }

    public void a(b bVar) {
        this.fFu = bVar;
    }

    public void oa(int i2) {
        if (this.bUt.getDuration() - i2 <= 3000) {
            aGU();
            if (this.ebT != null) {
                this.ebT.setVisibility(0);
                this.fFo.setVisibility(0);
                this.fFn.setVisibility(8);
                if (this.fFv != null) {
                    this.fFv.eQ(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.ecf = i2;
    }

    public void lu(boolean z) {
        if (this.bqt != null) {
            if (this.ebS != null) {
                this.ebS.setVisibility(z ? 0 : 8);
            }
            this.bqt.lw(z);
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

    public int bhq() {
        return this.alQ;
    }

    public void a(k kVar) {
        this.fFz = kVar;
    }

    public void a(j jVar) {
        this.fFA = jVar;
    }

    public void a(e eVar) {
        this.fFB = eVar;
    }

    public void lv(boolean z) {
        this.fFG = z;
    }
}
