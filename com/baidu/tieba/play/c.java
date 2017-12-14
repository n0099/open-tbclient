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
    private static int ejp;
    private String aMU;
    private TbPageContext<?> abX;
    private String baI;
    private QuickVideoView bll;
    private p bwY;
    private Animation cLn;
    private Animation cLo;
    private View cdd;
    private ImageView cde;
    private View cdi;
    private View dyU;
    protected View eiG;
    private VideoListMediaControllerView eiI;
    private View eiJ;
    private FrameLayout eiK;
    protected FrameLayout.LayoutParams eiL;
    private ImageView eiN;
    private ImageView eiO;
    private View eiP;
    private View eiR;
    private TbImageView eiS;
    private g.f eiT;
    private ImageView eiV;
    private TextView eiW;
    private View ejc;
    private View ejd;
    private TextView eje;
    private SeekBar ejf;
    private ImageView ejg;
    private ImageView ejh;
    private int eji;
    private int ejn;
    private int ejo;
    private CallStateReceiver ejq;
    private ProgressBar fOO;
    private View fOP;
    private View fOQ;
    private TextView fOR;
    private TextView fOS;
    private TextView fOT;
    private g.a fOU;
    private g.b fOV;
    private b fOX;
    private InterfaceC0137c fOY;
    private f fOZ;
    private h fPa;
    private i fPb;
    private k fPc;
    private j fPd;
    private e fPe;
    private TextView fPi;
    private boolean fPk;
    private boolean fPl;
    private g fkw;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fON = false;
    protected boolean dvV = false;
    private boolean eiX = false;
    private boolean eiZ = false;
    private boolean fOW = false;
    private int ejb = 0;
    private int mStatus = 0;
    private int ejj = 0;
    private int ejk = 0;
    private boolean ejr = false;
    private boolean fPf = true;
    private boolean fPg = true;
    private boolean fPh = false;
    private String fka = null;
    private int amj = -1;
    private boolean fPj = false;
    private g.f aZp = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejt);
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejt, 20L);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejv);
            if (c.this.bll.bjq()) {
                c.this.amj = 1;
                c.this.bll.setRecoveryState(1);
            }
            if (gVar != null && c.this.eiI != null) {
                c.this.ejb = x.bjK().rs(c.this.baI);
                c.this.eiI.V(c.this.ejb, gVar.getDuration());
                if (c.this.ejb != 0) {
                    if (c.this.bll != null) {
                        c.this.bll.sz(c.this.ejb);
                    } else {
                        gVar.seekTo(c.this.ejb);
                    }
                    if (!c.this.fPl) {
                        c.this.eiI.showProgress();
                        com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejt);
                    }
                    c.this.fPh = true;
                }
            }
        }
    };
    private Runnable ejt = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bll.getCurrentPosition() > 100) {
                c.this.eiX = true;
                c.this.eiJ.setVisibility(8);
                c.this.cdi.setVisibility(8);
                c.this.dyU.setVisibility(8);
                c.this.eiS.setVisibility(8);
                c.this.aHL();
                if (c.this.amj == 1 || c.this.amj == 2) {
                    if (c.this.eiP != null) {
                        c.this.eiP.setVisibility(0);
                        c.this.fOQ.setVisibility(0);
                        c.this.fOO.setVisibility(8);
                        if (c.this.fOY != null) {
                            c.this.fOY.fi(false);
                        }
                    }
                    c.this.eiI.showProgress();
                    c.this.aHM();
                }
                if (c.this.eiT != null) {
                    c.this.eiT.onPrepared(c.this.bll.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejt, 20L);
        }
    };
    private g.a aZo = new g.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eiX = false;
            c.this.ejb = 0;
            c.this.aHt();
            c.this.eiJ.setVisibility(0);
            c.this.fOO.setVisibility(8);
            c.this.fOO.setProgress(c.this.fOO.getMax());
            if (c.this.fOY != null) {
                c.this.fOY.fi(false);
            }
            if (c.this.dvV) {
                c.this.eiP.setVisibility(0);
                c.this.eiV.setVisibility(0);
                c.this.eiW.setVisibility(0);
                c.this.fOQ.setVisibility(8);
            } else {
                c.this.eiP.setVisibility(8);
                c.this.eiV.setVisibility(8);
                c.this.eiW.setVisibility(8);
                c.this.fOQ.setVisibility(8);
            }
            if (c.this.bll == null || c.this.bll.getDuration() > 150000) {
                c.this.lT(false);
            } else {
                c.this.fOR.setVisibility(0);
            }
            x.bjK().remove(c.this.baI);
            if (c.this.fOU != null) {
                c.this.fOU.onCompletion(gVar);
            }
            c.this.amj = 3;
            c.this.bll.setRecoveryState(3);
            if (!c.this.dvV && c.this.bll != null && c.this.bll.getDuration() <= 150000) {
                if (!c.this.fPj) {
                    if (c.this.fPa != null) {
                        c.this.fPa.ku(true);
                    }
                    c.this.bQ(c.this.baI, c.this.aMU);
                    return;
                }
                c.this.amj = 5;
                c.this.bll.setRecoveryState(5);
                c.this.bll.getPlayer().pause();
                c.this.bll.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eju = new g.b() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cdi.setVisibility(0);
            c.this.dyU.setVisibility(8);
            c.this.amj = 4;
            c.this.bll.setRecoveryState(4);
            if (c.this.fOV != null) {
                c.this.fOV.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.hh()) {
                c.this.fPk = true;
            }
            return true;
        }
    };
    private Runnable ejv = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            c.this.cdi.setVisibility(0);
            c.this.dyU.setVisibility(8);
        }
    };
    private g.InterfaceC0138g aZt = new g.InterfaceC0138g() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.InterfaceC0138g
        public void a(com.baidu.tieba.play.g gVar) {
            if (c.this.fPh) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fPm, 200L);
            }
        }
    };
    private Runnable fPm = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bll == null || !c.this.fPh) {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejt, 200L);
                c.this.fPh = false;
            } else if (c.this.ejb != c.this.bll.getCurrentPosition()) {
                c.this.fPh = false;
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejt, 20L);
            } else {
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.fPm, 200L);
            }
        }
    };
    private QuickVideoView.b bls = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eiX = false;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejt);
            com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejv);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cdi.getId()) {
                c.this.biW();
            } else if (view.getId() != c.this.cde.getId() && view.getId() != c.this.eiN.getId()) {
                if (view.getId() == c.this.fOS.getId()) {
                    if (c.this.fOZ != null) {
                        c.this.fOZ.aYD();
                    }
                } else if (view.getId() == c.this.fOR.getId()) {
                    if (c.this.fPa != null) {
                        c.this.fPa.ku(false);
                    }
                    c.this.bQ(c.this.baI, c.this.aMU);
                } else if (view.getId() != c.this.eiO.getId() && view.getId() != c.this.fOP.getId()) {
                    if (view.getId() == c.this.eiV.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fPd != null) {
                            c.this.fPd.amS();
                        }
                        c.this.aHx();
                    }
                } else {
                    if (c.this.dvV) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fPd != null) {
                        c.this.fPd.amS();
                    }
                    c.this.aHx();
                }
            } else {
                c.this.aYu();
            }
        }
    };
    private Animation.AnimationListener ejx = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.5
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eiP != null) {
                c.this.eiP.setVisibility(8);
                c.this.fOO.setVisibility(0);
                c.this.eiZ = false;
                if (c.this.fOY != null) {
                    c.this.fOY.amT();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener ejy = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.6
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
    private Runnable ejz = new Runnable() { // from class: com.baidu.tieba.play.c.7
        @Override // java.lang.Runnable
        public void run() {
            c.this.aHJ();
        }
    };
    private CustomMessageListener ejA = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private u.b emj = new u.b() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.u.b
        public void gx(int i2) {
            int duration;
            if (c.this.bll != null && (duration = c.this.bll.getDuration()) > 0 && c.this.fOO != null) {
                c.this.fOO.setProgress((int) ((i2 * c.this.eiG.getWidth()) / duration));
            }
            c.this.os(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bdz = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eiZ) {
                c.this.aHM();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aHI() && c.this.aHy() != null) {
                c.this.setStartPosition(c.this.aHy().getSeekPosition());
                c.this.bQ(c.this.baI, c.this.aMU);
            }
        }
    };
    private QuickVideoView.a fPn = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bjc() {
            if (!c.this.fPj) {
                c.this.dyU.setVisibility(0);
                c.this.eiS.setVisibility(0);
                c.this.cde.setVisibility(8);
                c.this.eiN.setImageResource(d.f.icon_video_suspend_n);
                c.this.fOS.setVisibility(8);
                c.this.fOR.setVisibility(8);
                c.this.fOT.setVisibility(8);
                c.this.cdi.setVisibility(8);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(c.this.ejv);
                com.baidu.adp.lib.g.e.fP().postDelayed(c.this.ejv, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void amP();

        void amQ();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0137c {
        void amT();

        void fi(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aYD();
    }

    /* loaded from: classes.dex */
    public interface g {
        void amU();
    }

    /* loaded from: classes.dex */
    public interface h {
        void ku(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void amR();

        void amS();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aYE();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.ejn = 0;
        if (tbPageContext != null) {
            this.abX = tbPageContext;
            this.eiG = p(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eiG);
            }
            this.eiR = view;
            this.eiG.setOnClickListener(this.mOnClickListener);
            this.bll = (QuickVideoView) this.eiG.findViewById(d.g.videoView);
            this.dyU = this.eiG.findViewById(d.g.video_list_layout_loading);
            this.eiI = (VideoListMediaControllerView) this.eiG.findViewById(d.g.media_controller);
            this.eiI.setPlayer(this.bll);
            this.fOO = (ProgressBar) this.eiG.findViewById(d.g.pgrBottomProgress);
            this.fOO.setMax(com.baidu.adp.lib.util.l.ac(this.abX.getPageActivity()));
            this.fOO.setProgress(0);
            this.eiI.setOnSeekBarChangeListener(this.bdz);
            this.eiI.setOnProgressUpdatedListener(this.emj);
            this.eiJ = this.eiG.findViewById(d.g.black_mask);
            this.cdi = this.eiG.findViewById(d.g.layout_error);
            this.cdi.setOnClickListener(this.mOnClickListener);
            this.fPi = (TextView) this.eiG.findViewById(d.g.auto_video_error_tips);
            this.eiK = (FrameLayout) this.eiG.findViewById(d.g.danmu_container);
            this.eiN = (ImageView) this.eiG.findViewById(d.g.img_play_icon);
            this.eiN.setOnClickListener(this.mOnClickListener);
            this.eiO = (ImageView) this.eiG.findViewById(d.g.img_full_screen);
            this.eiO.setOnClickListener(this.mOnClickListener);
            this.fOP = this.eiG.findViewById(d.g.full_screen_container);
            this.fOP.setOnClickListener(this.mOnClickListener);
            this.eiP = this.eiG.findViewById(d.g.layout_media_controller);
            this.fOQ = this.eiG.findViewById(d.g.time_show_controller);
            this.bll.setOnPreparedListener(this.aZp);
            this.bll.setOnCompletionListener(this.aZo);
            this.bll.setOnErrorListener(this.eju);
            this.bll.setOnSeekCompleteListener(this.aZt);
            this.bll.setOnSurfaceDestroyedListener(this.bls);
            this.bll.setOnRecoveryCallback(this.fPn);
            this.cde = (ImageView) this.eiG.findViewById(d.g.img_play);
            this.cde.setOnClickListener(this.mOnClickListener);
            this.fOR = (TextView) this.eiG.findViewById(d.g.txt_replay);
            this.fOR.setOnClickListener(this.mOnClickListener);
            this.fOS = (TextView) this.eiG.findViewById(d.g.txt_playnext);
            this.fOS.setOnClickListener(this.mOnClickListener);
            this.fOT = (TextView) this.eiG.findViewById(d.g.txt_next_video_title);
            this.eiS = (TbImageView) this.eiG.findViewById(d.g.video_thumbnail);
            this.eiS.setDefaultErrorResource(0);
            this.eiS.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.abX.getPageActivity());
            this.mScreenHeight = bF(this.abX.getPageActivity());
            this.eiV = (ImageView) this.eiG.findViewById(d.g.img_exit);
            this.eiV.setOnClickListener(this.mOnClickListener);
            this.eiW = (TextView) this.eiG.findViewById(d.g.video_title);
            this.cdd = this.eiG.findViewById(d.g.layout_title);
            this.cdd.setVisibility(8);
            this.cLn = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.cLo = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.abX.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eji = this.mAudioManager.getStreamMaxVolume(3);
            this.ejo = this.mAudioManager.getStreamVolume(3);
            ejp = 100 / this.eji;
            this.eiG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fPb != null) {
                        c.this.fPb.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eiX) {
                            if (c.this.mStatus == 1 && c.this.ejk != 0) {
                                c.this.b(c.this.ejk == 1 ? 1000.0f : -1000.0f, false);
                                c.this.ejk = 0;
                                c.this.ejj = 0;
                            }
                            if (!c.this.bll.isPlaying() && 8 == c.this.cde.getVisibility()) {
                                c.this.cde.setVisibility(0);
                                c.this.fOS.setVisibility(8);
                                c.this.fOR.setVisibility(8);
                                c.this.fOT.setVisibility(8);
                            }
                        }
                        c.this.aHt();
                        if (c.this.fPb != null) {
                            c.this.fPb.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bwY = new p(this.abX.getPageActivity());
            this.bwY.start();
            this.ejn = com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.ds16);
            this.ejq = new CallStateReceiver();
            this.ejq.register(this.abX.getPageActivity());
            this.abX.registerListener(this.ejA);
            biR();
        }
    }

    public void biR() {
        if (this.fPf) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eiG.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eiG.setSystemUiVisibility(0);
    }

    public void lQ(boolean z) {
        this.fPf = z;
        biR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        this.mStatus = 0;
        if (this.ejc != null && this.ejc.getParent() != null && (this.ejc.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ejc.getParent()).removeView(this.ejc);
                this.ejc = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.ejd != null && this.ejd.getParent() != null && (this.ejd.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.ejd.getParent()).removeView(this.ejd);
                this.ejd = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aHu() {
        if (this.mStatus == 1) {
            if (this.ejc == null && this.eiG != null && (this.eiG instanceof ViewGroup)) {
                LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.eiG, true);
                this.ejc = this.eiG.findViewById(d.g.lay_jindu);
                this.eje = (TextView) this.ejc.findViewById(d.g.show_time);
                this.ejh = (ImageView) this.ejc.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.ejd == null && this.eiG != null && (this.eiG instanceof ViewGroup)) {
            LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.eiG, true);
            this.ejd = this.eiG.findViewById(d.g.lay_voice);
            this.ejg = (ImageView) this.ejd.findViewById(d.g.arrow_voice_icon);
            this.ejf = (SeekBar) this.ejd.findViewById(d.g.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fPb != null) {
                c.this.fPb.onStart();
            }
            if (c.this.dvV && c.this.eiX) {
                if (!c.this.bll.isPlaying() && c.this.cde.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cde.setVisibility(8);
                    c.this.fOS.setVisibility(8);
                    c.this.fOR.setVisibility(8);
                    c.this.fOT.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.W(f2);
                    }
                } else {
                    if (c.this.dvV) {
                        c.this.aHw();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ejj = c.this.bll.getCurrentPosition();
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
            if (c.this.fPc != null) {
                c.this.fPc.aYE();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eiX) {
                if (c.this.amj != 2) {
                    c.this.biY();
                } else {
                    c.this.aYu();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHw() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eiG.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eiG.setSystemUiVisibility(4);
        } else {
            this.eiG.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(float f2) {
        if (!this.eiX) {
            this.mStatus = 0;
            return;
        }
        aHu();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ejp == 0) {
            if (f2 > 0.0f && this.ejo < this.eji) {
                this.ejo++;
            }
            if (f2 < 0.0f && this.ejo > 0) {
                this.ejo--;
            }
        }
        if (this.mProgress > 0) {
            this.ejg.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.ejg.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.ejo, 0);
        this.ejf.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.ejj -= 1000;
                this.ejk = 1;
            } else {
                this.ejj += 1000;
                this.ejk = 2;
            }
            if (this.ejj < 0) {
                this.ejj = 0;
            } else if (this.ejj > this.bll.getDuration()) {
                this.ejj = this.bll.getDuration();
            }
        }
        aHu();
        String sA = this.eiI.sA(this.ejj);
        if (f2 > 0.0f) {
            this.ejh.setImageResource(d.f.icon_kuaitui);
        } else {
            this.ejh.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(sA)) {
            this.eje.setText(new StringBuilder().append(sA).append("/").append(this.eiI.sA(this.bll.getDuration())));
        }
        this.eiI.A(this.ejj, z ? false : true);
        this.eiP.setVisibility(8);
        this.fOO.setVisibility(0);
        biS();
    }

    protected View p(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void bP(String str, String str2) {
        this.baI = str;
        this.aMU = str2;
    }

    public void aYu() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.F(this.abX.getPageActivity(), this.abX.getString(d.j.neterror));
        } else if (this.bll.isPlaying()) {
            pausePlay();
        } else if (this.eiX) {
            aHH();
            if (this.fkw != null) {
                this.fkw.amU();
            }
        } else {
            biW();
        }
    }

    public void aHx() {
        this.ejr = true;
        if (this.bwY != null) {
            this.bwY.aHx();
        }
    }

    public boolean sw(int i2) {
        switch (i2) {
            case 4:
                if (this.dvV) {
                    aHx();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eji <= 0 || this.ejf == null) {
                    return false;
                }
                this.ejo = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.ejo * 100.0d) / this.eji);
                this.ejf.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bll;
    }

    public VideoListMediaControllerView aHy() {
        return this.eiI;
    }

    public void show() {
        this.eiG.setVisibility(0);
    }

    public void aHC() {
        if (this.eiR != null) {
            ViewGroup.LayoutParams layoutParams = this.eiR.getLayoutParams();
            this.eiL = (FrameLayout.LayoutParams) this.eiG.getLayoutParams();
            this.eiL.width = layoutParams.width;
            this.eiL.height = layoutParams.height;
            this.eiL.topMargin = 0;
            this.eiG.setLayoutParams(this.eiL);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.ejr) {
            if (this.dvV) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.ejr = false;
        }
        if (configuration.orientation == 2) {
            this.dvV = true;
            this.eiG.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.eiP.setVisibility(0);
            this.cdd.setVisibility(0);
            this.eiV.setVisibility(0);
            this.eiW.setVisibility(0);
            this.eiK.setVisibility(8);
            if (this.fOW) {
                this.dyU.setVisibility(0);
                this.eiS.setVisibility(0);
            } else {
                this.dyU.setVisibility(8);
                this.eiS.setVisibility(8);
            }
            if (this.fOX != null) {
                this.fOX.amP();
            }
            this.eiO.setImageResource(d.f.icon_video_window);
            oq(this.ejn);
            aHw();
        } else {
            this.dvV = false;
            if (this.eiL != null) {
                this.eiG.setLayoutParams(this.eiL);
            }
            a(tbPageContext, false);
            this.cdd.setVisibility(8);
            this.eiK.setVisibility(0);
            if (this.fOW) {
                this.dyU.setVisibility(0);
                this.eiS.setVisibility(0);
            } else {
                this.dyU.setVisibility(8);
                this.eiS.setVisibility(8);
            }
            if (this.fOX != null) {
                this.fOX.amQ();
            }
            if (this.amj == 3 && this.fOY != null) {
                this.fOY.fi(false);
            } else if (!this.eiX && this.eiP != null) {
                this.eiP.clearAnimation();
                this.eiP.setVisibility(4);
                this.fOO.setVisibility(0);
                if (this.fOY != null) {
                    this.fOY.amT();
                }
            }
            aHt();
            this.eiO.setImageResource(d.f.icon_video_fullscreen);
            if (this.eiI != null && (this.eiI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiI.getLayoutParams();
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.tbds24);
                layoutParams.rightMargin = 0;
                this.eiI.setLayoutParams(layoutParams);
            }
            this.eiG.setSystemUiVisibility(0);
            biR();
        }
        if (this.bll.isPlaying()) {
            aHM();
        }
        biS();
    }

    public void biS() {
        if (this.bll != null) {
            int ac = com.baidu.adp.lib.util.l.ac(this.abX.getPageActivity());
            if (this.dvV) {
                ac = com.baidu.adp.lib.util.l.ae(this.abX.getPageActivity());
            }
            this.fOO.setMax(ac);
            int duration = this.bll.getDuration();
            if (duration > 0) {
                if (this.fOR.getVisibility() == 0) {
                    this.fOO.setProgress(this.fOO.getMax());
                } else {
                    this.fOO.setProgress((int) ((this.bll.getCurrentPosition() * this.fOO.getMax()) / duration));
                }
            }
        }
    }

    private void oq(int i2) {
        if (this.eiI != null && (this.eiI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiI.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eiI.setLayoutParams(layoutParams);
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

    public boolean aHE() {
        return !this.dvV;
    }

    public void a(g.a aVar) {
        this.fOU = aVar;
    }

    public void a(g.b bVar) {
        this.fOV = bVar;
    }

    public void aHF() {
        this.eiN.setImageResource(d.f.icon_video_play);
        this.dyU.setVisibility(8);
        this.cde.setVisibility(0);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        this.amj = 2;
        this.bll.setRecoveryState(2);
    }

    public void c(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bll != null) {
            this.bll.setPbLoadingTime(currentTimeMillis);
        }
        bQ(str, str2);
    }

    public void bQ(String str, String str2) {
        this.amj = 0;
        this.bll.setRecoveryState(0);
        bP(str, str2);
        this.bll.bR(str, str2);
        this.bll.start();
        this.dyU.setVisibility(0);
        this.eiS.setVisibility(0);
        this.cde.setVisibility(8);
        this.eiN.setImageResource(d.f.icon_video_suspend_n);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        this.cdi.setVisibility(8);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejv);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ejv, 60000L);
    }

    public void aHH() {
        this.amj = 1;
        this.bll.setRecoveryState(1);
        this.bll.start();
        this.eiN.setImageResource(d.f.icon_video_suspend_n);
        this.eiS.setVisibility(8);
        this.eiJ.setVisibility(8);
        this.dyU.setVisibility(8);
        this.eiI.showProgress();
        this.cde.setVisibility(8);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        bja();
    }

    public void biT() {
        if (com.baidu.adp.lib.util.j.hh() && this.fPk && !StringUtils.isNull(this.baI) && !StringUtils.isNull(this.aMU)) {
            this.fPk = false;
            this.fPl = true;
            bQ(this.baI, this.aMU);
        }
    }

    public void lR(boolean z) {
        if (this.bll != null) {
            this.bll.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bll.isPlaying() && this.fPg) {
            biU();
        }
        biZ();
        this.bll.pause();
        aHF();
    }

    public void stopPlay() {
        if (this.bll.isPlaying() && this.fPg) {
            biU();
        }
        this.amj = 5;
        this.bll.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejt);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejv);
        this.bll.stopPlayback();
        this.eiX = false;
        this.ejb = 0;
        auW();
    }

    public void biU() {
        x.bjK().aw(this.baI, this.bll.getCurrentPosition());
    }

    public void lS(boolean z) {
        this.fPg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lT(boolean z) {
        if (this.eiP != null) {
            this.eiJ.setVisibility(0);
            this.cde.setVisibility(0);
            this.fOS.setVisibility(8);
            this.fOR.setVisibility(8);
            this.fOT.setVisibility(8);
            this.dyU.setVisibility(8);
            this.eiN.setImageResource(d.f.icon_video_play);
            this.eiP.setVisibility(4);
            this.fOO.setVisibility(8);
            this.cdi.setVisibility(8);
            this.eiI.Mw();
            this.eiS.setVisibility(z ? 0 : 8);
        }
    }

    public void auW() {
        lT(true);
    }

    public boolean biV() {
        if (this.bll == null) {
            return false;
        }
        return this.bll.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bll == null) {
            return 0;
        }
        return this.bll.getCurrentPosition();
    }

    public void a(i iVar) {
        this.fPb = iVar;
    }

    public void a(h hVar) {
        this.fPa = hVar;
    }

    public void a(g gVar) {
        this.fkw = gVar;
    }

    public void a(f fVar) {
        this.fOZ = fVar;
    }

    public void qn(String str) {
        this.fka = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biW() {
        a(this.baI, this.aMU, (d) null);
    }

    public void b(InterfaceC0137c interfaceC0137c) {
        this.fOY = interfaceC0137c;
    }

    public void a(final String str, final String str2, final d dVar) {
        if (com.baidu.adp.lib.util.j.hj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fPe != null) {
                    this.fPe.fh(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abX.getPageActivity());
                aVar.cS(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.biX();
                        c.this.bQ(str, str2);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lX(false);
                        }
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.abX).th();
                return;
            } else if (this.fPe != null) {
                this.fPe.fh(true);
                return;
            } else {
                if (!this.fON) {
                    this.fON = true;
                    com.baidu.adp.lib.util.l.showToast(this.abX.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                bQ(str, str2);
                if (dVar != null) {
                    dVar.lX(true);
                    return;
                }
                return;
            }
        }
        bQ(str, str2);
        if (dVar != null) {
            dVar.lX(true);
        }
        if (this.fPd != null) {
            this.fPd.amR();
        }
    }

    public void biX() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nP(String str) {
        this.eiS.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejz);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejt);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejv);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPm);
        this.bwY.stop();
        this.ejq.unregister(this.abX.getPageActivity());
    }

    public void rm(String str) {
        this.eiW.setText(str);
    }

    public boolean aHI() {
        return this.eiX;
    }

    public void aHJ() {
        if (this.eiP != null) {
            aHL();
            this.eiP.setVisibility(0);
            this.fOQ.setVisibility(0);
            if (this.fOY != null) {
                this.fOY.fi(true);
            }
            this.fOO.setVisibility(8);
            this.cLn.setAnimationListener(this.ejx);
            this.eiP.startAnimation(this.cLn);
            this.eiZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biY() {
        if (this.eiP != null) {
            if (this.eiP.getVisibility() == 0) {
                aHL();
                this.eiP.setVisibility(8);
                this.fOO.setVisibility(0);
                if (this.fOY != null) {
                    this.fOY.amT();
                    return;
                }
                return;
            }
            aHM();
        }
    }

    public void aHK() {
        if (this.eiP != null) {
            aHL();
            this.eiP.setVisibility(0);
            this.fOQ.setVisibility(0);
            if (this.fOY != null) {
                this.fOY.fi(false);
            }
            this.fOO.setVisibility(8);
            this.cLo.setAnimationListener(this.ejy);
            this.eiP.startAnimation(this.cLo);
        }
    }

    public void biZ() {
        if (this.eiP != null) {
            aHL();
            this.eiP.setVisibility(0);
            this.fOQ.setVisibility(0);
            this.fOO.setVisibility(8);
            if (this.fOY != null) {
                this.fOY.fi(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHL() {
        if (this.eiP != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejz);
            this.cLo.setAnimationListener(null);
            this.cLn.setAnimationListener(null);
            this.eiP.clearAnimation();
            this.eiZ = false;
        }
    }

    public void aHM() {
        aHK();
        bja();
    }

    private void bja() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejz);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ejz, 3000L);
    }

    public void a(b bVar) {
        this.fOX = bVar;
    }

    public void os(int i2) {
        if (this.bll.getDuration() - i2 <= 3000) {
            aHL();
            if (this.eiP != null) {
                this.eiP.setVisibility(0);
                this.fOQ.setVisibility(0);
                this.fOO.setVisibility(8);
                if (this.fOY != null) {
                    this.fOY.fi(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.ejb = i2;
    }

    public void lU(boolean z) {
        if (this.bwY != null) {
            if (this.eiO != null || this.fOP != null) {
                this.eiO.setVisibility(z ? 0 : 8);
                this.fOP.setVisibility(z ? 0 : 8);
            }
            if (!z && this.eiI != null && (this.eiI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eiI.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.tbds52);
                this.eiI.setLayoutParams(layoutParams);
            }
            this.bwY.lZ(z);
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
            return com.baidu.adp.lib.util.l.ae(context);
        }
        return i2;
    }

    public int bjb() {
        return this.amj;
    }

    public void a(k kVar) {
        this.fPc = kVar;
    }

    public void a(j jVar) {
        this.fPd = jVar;
    }

    public void a(e eVar) {
        this.fPe = eVar;
    }

    public void lV(boolean z) {
        this.fPj = z;
    }

    public void lW(boolean z) {
        this.fOW = z;
    }
}
