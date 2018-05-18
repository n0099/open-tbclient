package com.baidu.tieba.play;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
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
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int eyy;
    private String aNv;
    private String baJ;
    private QuickVideoView ble;
    private o bzB;
    private w cpB;
    private com.baidu.tieba.play.g cpw;
    private View csp;
    private ImageView csq;
    private View csu;
    private Animation dcj;
    private Animation dck;
    private VideoListMediaControllerView exR;
    private View exS;
    private FrameLayout exT;
    protected FrameLayout.LayoutParams exU;
    private ImageView exW;
    private ImageView exX;
    private View exY;
    private View eya;
    private TbImageView eyb;
    private g.f eyc;
    private ImageView eye;
    private TextView eyf;
    private View eyk;
    private View eyl;
    private TextView eyn;
    private SeekBar eyo;
    private ImageView eyp;
    private ImageView eyq;
    private int eyr;
    private int eyw;
    private int eyx;
    private CallStateReceiver eyz;
    private ProgressBar fOO;
    private View fOP;
    private View fOQ;
    private TextView fOR;
    private TextView fOS;
    private TextView fOT;
    private g.a fOU;
    private g.b fOV;
    private View.OnClickListener fOX;
    private b fOY;
    private InterfaceC0201c fOZ;
    private g fPa;
    private i fPb;
    private j fPc;
    private l fPd;
    private k fPe;
    private e fPf;
    private f fPg;
    private TextView fPl;
    private boolean fPn;
    private boolean fPo;
    private boolean fPp;
    private int fPq;
    private boolean fPr;
    private boolean fPs;
    private h fxR;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    public View mMainView;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fON = false;
    protected boolean dJH = false;
    private boolean eyg = false;
    private boolean eyi = false;
    private boolean fOW = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eys = 0;
    private int eyt = 0;
    private boolean eyA = false;
    private boolean fPh = true;
    private boolean fPi = true;
    private boolean fPj = false;
    private boolean fPk = false;
    private String fxv = null;
    private int anu = -1;
    private boolean fPm = false;
    private g.f aZp = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cpw = gVar;
            if (c.this.bfT()) {
                c.this.cpB.bgV();
                c.this.fPr = true;
                return;
            }
            c.this.afh();
        }
    };
    private VideoLoadingProgressView.a cpM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.afh();
        }
    };
    private Runnable eyC = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ble.getCurrentPosition() > 100) {
                c.this.eyg = true;
                c.this.exS.setVisibility(8);
                c.this.csu.setVisibility(8);
                c.this.cpB.bgW();
                c.this.eyb.setVisibility(8);
                c.this.aLG();
                if (c.this.anu == 1 || c.this.anu == 2) {
                    if (c.this.exY != null) {
                        c.this.exY.setVisibility(0);
                        c.this.fOQ.setVisibility(0);
                        c.this.fOO.setVisibility(8);
                        if (c.this.fOZ != null) {
                            c.this.fOZ.fH(false);
                        }
                    }
                    c.this.exR.showProgress();
                    c.this.aLH();
                }
                if (c.this.eyc != null) {
                    c.this.eyc.onPrepared(c.this.ble.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(c.this.eyC, 20L);
        }
    };
    private g.a aZo = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.eyg = false;
            c.this.fPp = false;
            c.this.mStartPosition = 0;
            c.this.aLo();
            c.this.exS.setVisibility(0);
            c.this.fOO.setVisibility(8);
            c.this.fOO.setProgress(c.this.fOO.getMax());
            if (c.this.fOZ != null) {
                c.this.fOZ.fH(false);
            }
            if (c.this.dJH) {
                c.this.exY.setVisibility(0);
                c.this.eye.setVisibility(0);
                c.this.eyf.setVisibility(0);
                c.this.fOQ.setVisibility(8);
            } else {
                c.this.exY.setVisibility(8);
                c.this.eye.setVisibility(8);
                c.this.eyf.setVisibility(8);
                c.this.fOQ.setVisibility(8);
            }
            if (c.this.ble == null || c.this.ble.getDuration() > 150000) {
                c.this.lq(false);
            } else {
                c.this.fOR.setVisibility(0);
            }
            x.bhb().remove(c.this.baJ);
            if (c.this.fOU != null) {
                c.this.fOU.onCompletion(gVar);
            }
            c.this.anu = 3;
            c.this.ble.setRecoveryState(3);
            if (!c.this.dJH && c.this.ble != null && c.this.ble.getDuration() <= 150000) {
                if (!c.this.fPm) {
                    if (c.this.fPb != null) {
                        c.this.fPb.kN(true);
                    }
                    c.this.bL(c.this.baJ, c.this.aNv);
                    return;
                }
                c.this.anu = 5;
                c.this.ble.setRecoveryState(5);
                c.this.ble.getPlayer().pause();
                c.this.ble.getPlayer().seekTo(0);
            }
        }
    };
    private g.b eyD = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.csu.setVisibility(0);
            c.this.cpB.bgX();
            c.this.anu = 4;
            c.this.ble.setRecoveryState(4);
            if (c.this.fOV != null) {
                c.this.fOV.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.gP()) {
                c.this.fPn = true;
            }
            c.this.fPp = false;
            return true;
        }
    };
    private Runnable eyE = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.csu.setVisibility(0);
            c.this.cpB.bgX();
        }
    };
    private g.InterfaceC0202g aZt = new g.InterfaceC0202g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0202g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.fPj) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fPt, 200L);
            }
        }
    };
    private Runnable fPt = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ble == null || !c.this.fPj) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.eyC, 200L);
                c.this.fPj = false;
            } else if (c.this.mStartPosition != c.this.ble.getCurrentPosition()) {
                c.this.fPj = false;
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.eyC, 20L);
            } else {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fPt, 200L);
            }
        }
    };
    private QuickVideoView.b bln = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eyg = false;
            if (c.this.fOW) {
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.fPu, 300L);
            } else {
                c.this.fPp = false;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.eyC);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.eyE);
        }
    };
    private Runnable fPu = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.fPp = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getId() == c.this.csu.getId()) {
                c.this.bgb();
            } else if (view2.getId() != c.this.csq.getId() && view2.getId() != c.this.exW.getId()) {
                if (view2.getId() == c.this.fOS.getId()) {
                    if (c.this.fPa != null) {
                        c.this.fPa.bcz();
                    }
                } else if (view2.getId() == c.this.fOR.getId()) {
                    if (c.this.fPb != null) {
                        c.this.fPb.kN(false);
                    }
                    c.this.bL(c.this.baJ, c.this.aNv);
                } else if (view2.getId() != c.this.exX.getId() && view2.getId() != c.this.fOP.getId()) {
                    if (view2.getId() != c.this.eye.getId()) {
                        if (c.this.fOX != null) {
                            c.this.fOX.onClick(view2);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new al("c11713"));
                    if (c.this.fPe != null) {
                        c.this.fPe.aqX();
                    }
                    if (c.this.bfU()) {
                        c.this.bfW();
                        c.this.ln(false);
                        return;
                    }
                    c.this.aLs();
                } else {
                    if (c.this.dJH) {
                        TiebaStatic.log(new al("c11714"));
                    } else {
                        TiebaStatic.log(new al("c11710"));
                    }
                    if (c.this.fPe != null) {
                        c.this.fPe.aqX();
                    }
                    if (c.this.bfU()) {
                        if (c.this.dJH) {
                            c.this.bfW();
                        } else {
                            c.this.bfV();
                        }
                        c.this.ln(c.this.dJH);
                        return;
                    }
                    c.this.aLs();
                }
            } else {
                c.this.bcq();
            }
        }
    };
    private Animation.AnimationListener eyG = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.exY != null) {
                c.this.exY.setVisibility(8);
                c.this.fOO.setVisibility(0);
                c.this.eyi = false;
                if (c.this.fOZ != null) {
                    c.this.fOZ.aqY();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eyH = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable eyI = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aLE();
        }
    };
    private CustomMessageListener eyJ = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b eAD = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gt(int i2) {
            int duration;
            if (c.this.ble != null && (duration = c.this.ble.getDuration()) > 0 && c.this.fOO != null) {
                c.this.fOO.setProgress((int) ((i2 * c.this.mMainView.getWidth()) / duration));
            }
            c.this.oC(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bdE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eyi) {
                c.this.aLH();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aLD() && c.this.aLt() != null) {
                c.this.setStartPosition(c.this.aLt().getSeekPosition());
                c.this.bL(c.this.baJ, c.this.aNv);
            }
        }
    };
    private QuickVideoView.a fPv = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bgj() {
            if (!c.this.fPm) {
                c.this.cpB.startLoading();
                c.this.eyb.setVisibility(0);
                c.this.csq.setVisibility(8);
                c.this.exW.setImageResource(d.f.icon_video_suspend_n);
                c.this.fOS.setVisibility(8);
                c.this.fOR.setVisibility(8);
                c.this.fOT.setVisibility(8);
                c.this.csu.setVisibility(8);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(c.this.eyE);
                com.baidu.adp.lib.g.e.fw().postDelayed(c.this.eyE, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aqU();

        void aqV();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0201c {
        void aqY();

        void fH(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lt(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fG(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface g {
        void bcz();
    }

    /* loaded from: classes.dex */
    public interface h {
        void aqZ();
    }

    /* loaded from: classes.dex */
    public interface i {
        void kN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface j {
        void onStart();

        void onStop();

        boolean onTouch(View view2, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface k {
        void aqW();

        void aqX();
    }

    /* loaded from: classes.dex */
    public interface l {
        void bcA();
    }

    public c(TbPageContext<?> tbPageContext, View view2, boolean z) {
        this.eyw = 0;
        this.fPs = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.mMainView = q(tbPageContext);
            this.mRootView = view2;
            this.fPs = z;
            if (view2 instanceof FrameLayout) {
                ((FrameLayout) view2).addView(this.mMainView);
            }
            this.eya = view2;
            this.mMainView.setOnClickListener(this.mOnClickListener);
            this.ble = (QuickVideoView) this.mMainView.findViewById(d.g.videoView);
            this.cpB = new w((ViewGroup) this.mMainView.findViewById(d.g.auto_video_loading_container));
            this.cpB.setLoadingAnimationListener(this.cpM);
            this.exR = (VideoListMediaControllerView) this.mMainView.findViewById(d.g.media_controller);
            this.exR.setPlayer(this.ble);
            this.fOO = (ProgressBar) this.mMainView.findViewById(d.g.pgrBottomProgress);
            this.fOO.setMax(com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()));
            this.fOO.setProgress(0);
            this.exR.setOnSeekBarChangeListener(this.bdE);
            this.exR.setOnProgressUpdatedListener(this.eAD);
            this.exS = this.mMainView.findViewById(d.g.black_mask);
            this.csu = this.mMainView.findViewById(d.g.layout_error);
            this.csu.setOnClickListener(this.mOnClickListener);
            this.fPl = (TextView) this.mMainView.findViewById(d.g.auto_video_error_tips);
            this.exT = (FrameLayout) this.mMainView.findViewById(d.g.danmu_container);
            this.exW = (ImageView) this.mMainView.findViewById(d.g.img_play_icon);
            this.exW.setOnClickListener(this.mOnClickListener);
            this.exX = (ImageView) this.mMainView.findViewById(d.g.img_full_screen);
            this.exX.setOnClickListener(this.mOnClickListener);
            this.fOP = this.mMainView.findViewById(d.g.full_screen_container);
            this.fOP.setOnClickListener(this.mOnClickListener);
            this.exY = this.mMainView.findViewById(d.g.layout_media_controller);
            this.fOQ = this.mMainView.findViewById(d.g.time_show_controller);
            this.ble.setOnPreparedListener(this.aZp);
            this.ble.setOnCompletionListener(this.aZo);
            this.ble.setOnErrorListener(this.eyD);
            this.ble.setOnSeekCompleteListener(this.aZt);
            this.ble.setOnSurfaceDestroyedListener(this.bln);
            this.ble.setOnRecoveryCallback(this.fPv);
            this.csq = (ImageView) this.mMainView.findViewById(d.g.img_play);
            this.csq.setOnClickListener(this.mOnClickListener);
            this.fOR = (TextView) this.mMainView.findViewById(d.g.txt_replay);
            this.fOR.setOnClickListener(this.mOnClickListener);
            this.fOS = (TextView) this.mMainView.findViewById(d.g.txt_playnext);
            this.fOS.setOnClickListener(this.mOnClickListener);
            this.fOT = (TextView) this.mMainView.findViewById(d.g.txt_next_video_title);
            this.eyb = (TbImageView) this.mMainView.findViewById(d.g.video_thumbnail);
            this.eyb.setDefaultErrorResource(0);
            this.eyb.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
            this.mScreenHeight = bB(this.mContext.getPageActivity());
            this.eye = (ImageView) this.mMainView.findViewById(d.g.img_exit);
            this.eye.setOnClickListener(this.mOnClickListener);
            this.eyf = (TextView) this.mMainView.findViewById(d.g.video_title);
            this.csp = this.mMainView.findViewById(d.g.layout_title);
            this.csp.setVisibility(8);
            this.dcj = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dck = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eyr = this.mAudioManager.getStreamMaxVolume(3);
            this.eyx = this.mAudioManager.getStreamVolume(3);
            eyy = 100 / this.eyr;
            this.mMainView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    if (c.this.fPc != null) {
                        c.this.fPc.onTouch(view3, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eyg) {
                            if (c.this.mStatus == 1 && c.this.eyt != 0) {
                                c.this.b(c.this.eyt == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eyt = 0;
                                c.this.eys = 0;
                            }
                            if (!c.this.ble.isPlaying() && 8 == c.this.csq.getVisibility()) {
                                c.this.csq.setVisibility(0);
                                c.this.fOS.setVisibility(8);
                                c.this.fOR.setVisibility(8);
                                c.this.fOT.setVisibility(8);
                            }
                        }
                        c.this.aLo();
                        if (c.this.fPc != null) {
                            c.this.fPc.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bzB = new o(this.mContext.getPageActivity());
            if (this.fPs) {
                this.bzB.start();
            }
            this.eyw = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds16);
            this.eyz = new CallStateReceiver();
            this.eyz.register(this.mContext.getPageActivity());
            this.mContext.registerListener(this.eyJ);
            bfS();
        }
    }

    public void bfS() {
        if (this.fPh) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.mMainView.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.mMainView.setSystemUiVisibility(0);
    }

    public void lm(boolean z) {
        this.fPh = z;
        bfS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLo() {
        this.mStatus = 0;
        if (this.eyk != null && this.eyk.getParent() != null && (this.eyk.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eyk.getParent()).removeView(this.eyk);
                this.eyk = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eyl != null && this.eyl.getParent() != null && (this.eyl.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eyl.getParent()).removeView(this.eyl);
                this.eyl = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aLp() {
        if (this.mStatus == 1) {
            if (this.eyk == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
                LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.float_video_window_jindu, (ViewGroup) this.mMainView, true);
                this.eyk = this.mMainView.findViewById(d.g.lay_jindu);
                this.eyn = (TextView) this.eyk.findViewById(d.g.show_time);
                this.eyq = (ImageView) this.eyk.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eyl == null && this.mMainView != null && (this.mMainView instanceof ViewGroup)) {
            LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.float_video_window_voice, (ViewGroup) this.mMainView, true);
            this.eyl = this.mMainView.findViewById(d.g.lay_voice);
            this.eyp = (ImageView) this.eyl.findViewById(d.g.arrow_voice_icon);
            this.eyo = (SeekBar) this.eyl.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        this.fOX = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fPc != null) {
                c.this.fPc.onStart();
            }
            if (c.this.dJH && c.this.eyg) {
                if (!c.this.ble.isPlaying() && c.this.csq.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.csq.setVisibility(8);
                    c.this.fOS.setVisibility(8);
                    c.this.fOR.setVisibility(8);
                    c.this.fOT.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.af(f2);
                    }
                } else {
                    if (c.this.dJH) {
                        c.this.aLr();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eys = c.this.ble.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.af(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fPd != null) {
                c.this.fPd.bcA();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eyg) {
                if (c.this.anu != 2) {
                    c.this.bge();
                } else {
                    c.this.bcq();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLr() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mMainView.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mMainView.setSystemUiVisibility(4);
        } else {
            this.mMainView.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(float f2) {
        if (!this.eyg) {
            this.mStatus = 0;
            return;
        }
        aLp();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eyy == 0) {
            if (f2 > 0.0f && this.eyx < this.eyr) {
                this.eyx++;
            }
            if (f2 < 0.0f && this.eyx > 0) {
                this.eyx--;
            }
        }
        if (this.mProgress > 0) {
            this.eyp.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eyp.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eyx, 0);
        this.eyo.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eys += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eyt = 1;
            } else {
                this.eys += 1000;
                this.eyt = 2;
            }
            if (this.eys < 0) {
                this.eys = 0;
            } else if (this.eys > this.ble.getDuration()) {
                this.eys = this.ble.getDuration();
            }
        }
        aLp();
        String rq = this.exR.rq(this.eys);
        if (f2 > 0.0f) {
            this.eyq.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eyq.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rq)) {
            this.eyn.setText(new StringBuilder().append(rq).append("/").append(this.exR.rq(this.ble.getDuration())));
        }
        this.exR.setCurrentDuration(this.eys, z ? false : true);
        this.exY.setVisibility(8);
        this.fOO.setVisibility(0);
        bfX();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.float_video_container, (ViewGroup) null);
    }

    public void bK(String str, String str2) {
        this.baJ = str;
        this.aNv = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfT() {
        if (this.fOW) {
            return this.fPq == 0 && !this.fPr;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.ble != null && this.cpw != null) {
            if (this.fPp) {
                this.ble.start();
                this.fPp = false;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyC);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.eyC, 20L);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyE);
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
            if (this.ble.bgA()) {
                this.anu = 1;
                this.ble.setRecoveryState(1);
            }
            if (this.cpw != null && this.exR != null) {
                this.mStartPosition = x.bhb().ru(this.baJ);
                this.exR.Q(this.mStartPosition, this.cpw.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.ble != null) {
                        this.ble.rp(this.mStartPosition);
                    } else {
                        this.cpw.seekTo(this.mStartPosition);
                    }
                    if (!this.fPo) {
                        this.exR.showProgress();
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyC);
                    }
                    this.fPj = true;
                }
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", Constants.OS_TYPE_VALUE);
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    private static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(boolean z) {
        if (hasNavBar(this.mContext.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fOQ.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mContext.getPageActivity());
                this.fOQ.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.fOQ.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.fOQ.setLayoutParams(layoutParams);
        }
    }

    public void bcq() {
        if (!com.baidu.adp.lib.util.j.gP()) {
            com.baidu.adp.lib.util.l.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(d.k.neterror));
        } else if (this.ble.isPlaying()) {
            pausePlay();
            if (this.fPg != null) {
                this.fPg.onPause();
            }
        } else if (this.eyg) {
            aLC();
            if (this.fxR != null) {
                this.fxR.aqZ();
            }
        } else {
            bgb();
        }
    }

    public void aLs() {
        this.eyA = true;
        if (this.bzB != null) {
            this.bzB.aLs();
        }
    }

    public boolean bfU() {
        return this.cpw != null && this.cpw.getVideoHeight() > this.cpw.getVideoWidth();
    }

    public boolean rm(int i2) {
        switch (i2) {
            case 4:
                if (this.dJH) {
                    if (bfU()) {
                        ln(false);
                        bfW();
                    } else {
                        aLs();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eyr <= 0 || this.eyo == null) {
                    return false;
                }
                this.eyx = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eyx * 100.0d) / this.eyr);
                this.eyo.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.ble;
    }

    public VideoListMediaControllerView aLt() {
        return this.exR;
    }

    public void show() {
        this.mMainView.setVisibility(0);
    }

    public void aLx() {
        if (this.eya != null) {
            ViewGroup.LayoutParams layoutParams = this.eya.getLayoutParams();
            this.exU = (FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
            this.exU.width = layoutParams.width;
            this.exU.height = layoutParams.height;
            this.exU.topMargin = 0;
            this.mMainView.setLayoutParams(this.exU);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eyA) {
            if (this.dJH) {
                TiebaStatic.log(new al("c11712"));
            } else {
                TiebaStatic.log(new al("c11711"));
            }
        } else {
            this.eyA = false;
        }
        if (configuration.orientation == 2) {
            bfV();
        } else {
            bfW();
        }
        if (this.ble.isPlaying()) {
            aLH();
        }
        bfX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfV() {
        this.dJH = true;
        if (bfU()) {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.mMainView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.mContext, true);
        this.exY.setVisibility(0);
        this.csp.setVisibility(0);
        this.eye.setVisibility(0);
        this.eyf.setVisibility(0);
        this.exT.setVisibility(8);
        if (this.fOW) {
            this.cpB.startLoading();
            this.eyb.setVisibility(0);
        } else {
            this.cpB.bgX();
            this.eyb.setVisibility(8);
        }
        if (this.fOY != null) {
            this.fOY.aqU();
        }
        this.exX.setImageResource(d.f.icon_video_window);
        oA(this.eyw);
        aLr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfW() {
        this.dJH = false;
        if (this.exU != null) {
            this.mMainView.setLayoutParams(this.exU);
        }
        a((TbPageContext) this.mContext, false);
        this.csp.setVisibility(8);
        this.exT.setVisibility(0);
        if (this.fOW) {
            this.cpB.startLoading();
            this.eyb.setVisibility(0);
        } else {
            this.cpB.bgX();
            this.eyb.setVisibility(8);
        }
        if (this.fOY != null) {
            this.fOY.aqV();
        }
        if (this.anu == 3 && this.fOZ != null) {
            this.fOZ.fH(false);
        } else if (!this.eyg && this.exY != null) {
            this.exY.clearAnimation();
            this.exY.setVisibility(4);
            this.fOO.setVisibility(0);
            if (this.fOZ != null) {
                this.fOZ.aqY();
            }
        }
        aLo();
        this.exX.setImageResource(d.f.icon_video_fullscreen);
        if (this.exR != null && (this.exR.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.exR.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.exR.setLayoutParams(layoutParams);
        }
        this.mMainView.setSystemUiVisibility(0);
        bfS();
    }

    public void bfX() {
        if (this.ble != null) {
            int af = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
            if (this.dJH) {
                af = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            }
            this.fOO.setMax(af);
            int duration = this.ble.getDuration();
            if (duration > 0) {
                if (this.fOR.getVisibility() == 0) {
                    this.fOO.setProgress(this.fOO.getMax());
                } else {
                    this.fOO.setProgress((int) ((this.ble.getCurrentPosition() * this.fOO.getMax()) / duration));
                }
            }
        }
    }

    private void oA(int i2) {
        if (this.exR != null && (this.exR.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.exR.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.exR.setLayoutParams(layoutParams);
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

    public boolean aLz() {
        return !this.dJH;
    }

    public void a(g.f fVar) {
        this.eyc = fVar;
    }

    public void a(g.a aVar) {
        this.fOU = aVar;
    }

    public void a(g.b bVar) {
        this.fOV = bVar;
    }

    public void aLA() {
        this.exW.setImageResource(d.f.icon_video_play);
        this.cpB.bgX();
        this.csq.setVisibility(0);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        this.anu = 2;
        this.ble.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.ble != null) {
            this.ble.setPbLoadingTime(currentTimeMillis);
        }
        bL(str, str2);
    }

    public void bL(String str, String str2) {
        bgc();
        this.fPp = true;
        this.anu = 0;
        this.ble.setRecoveryState(0);
        bK(str, str2);
        this.ble.setVideoPath(str, str2);
        this.cpB.startLoading();
        this.eyb.setVisibility(0);
        this.csq.setVisibility(8);
        this.exW.setImageResource(d.f.icon_video_suspend_n);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        this.csu.setVisibility(8);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyE);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.eyE, 60000L);
    }

    public void bM(String str, String str2) {
        bgc();
        this.fPp = true;
        this.anu = 0;
        this.ble.setRecoveryState(0);
        this.cpB.startLoading();
        this.eyb.setVisibility(0);
        this.csq.setVisibility(8);
        this.exW.setImageResource(d.f.icon_video_suspend_n);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        this.csu.setVisibility(8);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyE);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.eyE, 60000L);
    }

    public void aLC() {
        this.anu = 1;
        this.ble.setRecoveryState(1);
        this.ble.start();
        this.exW.setImageResource(d.f.icon_video_suspend_n);
        this.eyb.setVisibility(8);
        this.exS.setVisibility(8);
        this.cpB.bgX();
        this.exR.showProgress();
        this.csq.setVisibility(8);
        this.fOS.setVisibility(8);
        this.fOR.setVisibility(8);
        this.fOT.setVisibility(8);
        bgg();
    }

    public void bfY() {
        if (com.baidu.adp.lib.util.j.gP() && this.fPn && !StringUtils.isNull(this.baJ) && !StringUtils.isNull(this.aNv)) {
            this.fPn = false;
            this.fPo = true;
            bL(this.baJ, this.aNv);
        }
    }

    public void lo(boolean z) {
        if (this.ble != null) {
            this.ble.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.ble.isPlaying() && this.fPi) {
            bfZ();
        }
        bgf();
        this.ble.pause();
        aLA();
    }

    public void stopPlay() {
        if (this.ble.isPlaying() && this.fPi) {
            bfZ();
        }
        this.anu = 5;
        this.ble.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyC);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyE);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
        this.ble.stopPlayback();
        this.eyg = false;
        this.fPp = false;
        this.mStartPosition = 0;
        ayy();
    }

    public void bfZ() {
        x.bhb().aD(this.baJ, this.ble.getCurrentPosition());
    }

    public void lp(boolean z) {
        this.fPi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(boolean z) {
        if (this.exY != null) {
            this.exS.setVisibility(0);
            this.csq.setVisibility(0);
            this.fOS.setVisibility(8);
            this.fOR.setVisibility(8);
            this.fOT.setVisibility(8);
            this.cpB.bgX();
            this.exW.setImageResource(d.f.icon_video_play);
            this.exY.setVisibility(4);
            this.fOO.setVisibility(8);
            this.csu.setVisibility(8);
            this.exR.Nc();
            this.eyb.setVisibility(z ? 0 : 8);
        }
    }

    public void ayy() {
        lq(true);
    }

    public boolean bga() {
        if (this.ble == null) {
            return false;
        }
        return this.ble.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ble == null) {
            return 0;
        }
        return this.ble.getCurrentPosition();
    }

    public void a(j jVar) {
        this.fPc = jVar;
    }

    public void a(i iVar) {
        this.fPb = iVar;
    }

    public void a(h hVar) {
        this.fxR = hVar;
    }

    public void a(f fVar) {
        this.fPg = fVar;
    }

    public void a(g gVar) {
        this.fPa = gVar;
    }

    public void qX(String str) {
        this.fxv = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgb() {
        a(this.baJ, this.aNv, null, new Object[0]);
    }

    public void b(InterfaceC0201c interfaceC0201c) {
        this.fOZ = interfaceC0201c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        bgc();
        if (com.baidu.adp.lib.util.j.gR() && !com.baidu.tieba.video.f.bvU().bvV()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.fPk = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fPf != null) {
                    this.fPf.fG(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dc(TbadkCoreApplication.getInst().getString(d.k.play_video_mobile_tip));
                aVar.a(d.k.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bgd();
                        if (c.this.fPk) {
                            c.this.bM(str, str2);
                        } else {
                            c.this.bL(str, str2);
                        }
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.lt(false);
                        }
                    }
                });
                aVar.b(d.k.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).tC();
                return;
            } else if (this.fPf != null) {
                this.fPf.fG(true);
                return;
            } else {
                if (!this.fON) {
                    this.fON = true;
                    com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.k.play_video_mobile_tip2);
                }
                if (this.fPk) {
                    bM(str, str2);
                } else {
                    bL(str, str2);
                }
                if (dVar != null) {
                    dVar.lt(true);
                    return;
                }
                return;
            }
        }
        if (this.fPk) {
            bM(str, str2);
        } else {
            bL(str, str2);
        }
        if (dVar != null) {
            dVar.lt(true);
        }
        if (this.fPe != null) {
            this.fPe.aqW();
        }
    }

    private void bgc() {
        if (com.baidu.adp.lib.util.j.gR()) {
            com.baidu.tieba.video.f.bvU().cb(this.mContext.getPageActivity());
        }
    }

    public void bgd() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void oC(String str) {
        this.eyb.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyI);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyC);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyE);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPt);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPu);
        this.bzB.stop();
        this.eyz.unregister(this.mContext.getPageActivity());
    }

    public void rq(String str) {
        this.eyf.setText(str);
    }

    public boolean aLD() {
        return this.eyg;
    }

    public void aLE() {
        if (this.exY != null) {
            aLG();
            this.exY.setVisibility(0);
            this.fOQ.setVisibility(0);
            if (this.fOZ != null) {
                this.fOZ.fH(true);
            }
            this.fOO.setVisibility(8);
            this.dcj.setAnimationListener(this.eyG);
            this.exY.startAnimation(this.dcj);
            this.eyi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bge() {
        if (this.exY != null) {
            if (this.exY.getVisibility() == 0) {
                aLG();
                this.exY.setVisibility(8);
                this.fOO.setVisibility(0);
                if (this.fOZ != null) {
                    this.fOZ.aqY();
                    return;
                }
                return;
            }
            aLH();
        }
    }

    public void aLF() {
        if (this.exY != null) {
            aLG();
            this.exY.setVisibility(0);
            this.fOQ.setVisibility(0);
            if (this.fOZ != null) {
                this.fOZ.fH(false);
            }
            this.fOO.setVisibility(8);
            this.dck.setAnimationListener(this.eyH);
            this.exY.startAnimation(this.dck);
        }
    }

    public void bgf() {
        if (this.exY != null) {
            aLG();
            this.exY.setVisibility(0);
            this.fOQ.setVisibility(0);
            this.fOO.setVisibility(8);
            if (this.fOZ != null) {
                this.fOZ.fH(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLG() {
        if (this.exY != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyI);
            this.dck.setAnimationListener(null);
            this.dcj.setAnimationListener(null);
            this.exY.clearAnimation();
            this.eyi = false;
        }
    }

    public void aLH() {
        aLF();
        bgg();
    }

    private void bgg() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyI);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.eyI, 3000L);
    }

    public void a(b bVar) {
        this.fOY = bVar;
    }

    public void oC(int i2) {
        if (this.ble.getDuration() - i2 <= 3000) {
            aLG();
            if (this.exY != null) {
                this.exY.setVisibility(0);
                this.fOQ.setVisibility(0);
                this.fOO.setVisibility(8);
                if (this.fOZ != null) {
                    this.fOZ.fH(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void K(boolean z, boolean z2) {
        int i2 = 8;
        if (this.bzB != null) {
            if (this.exX != null || this.fOP != null) {
                this.exX.setVisibility((z || !z2) ? 0 : 8);
                View view2 = this.fOP;
                if (z || !z2) {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            if (!z && z2 && this.exR != null && (this.exR.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.exR.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds52);
                this.exR.setLayoutParams(layoutParams);
            }
            this.bzB.lv(z);
        }
    }

    public int bB(Context context) {
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
            return com.baidu.adp.lib.util.l.ah(context);
        }
        return i2;
    }

    public static int getVirtualBarHeight(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        return i2;
    }

    public int bgh() {
        return this.anu;
    }

    public void a(l lVar) {
        this.fPd = lVar;
    }

    public void a(k kVar) {
        this.fPe = kVar;
    }

    public void a(e eVar) {
        this.fPf = eVar;
    }

    public void lr(boolean z) {
        this.fPm = z;
    }

    public void ls(boolean z) {
        this.fOW = z;
    }

    public void rn(int i2) {
        this.fPq = i2;
    }

    public void bgi() {
        com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), this.exW, 40, 40, 40, 40);
    }
}
