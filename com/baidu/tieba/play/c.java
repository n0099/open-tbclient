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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static int eRz;
    private String aWq;
    private o bKk;
    private w bcX;
    private String bdb;
    private QuickVideoView bvr;
    private View cBo;
    private ImageView cBp;
    private View cBt;
    private com.baidu.tieba.play.g cyB;
    private com.baidu.tieba.j.k cyD;
    private Animation drc;
    private Animation drd;
    public View eQS;
    private VideoListMediaControllerView eQU;
    private View eQV;
    private FrameLayout eQW;
    protected FrameLayout.LayoutParams eQX;
    private ImageView eQZ;
    private CallStateReceiver eRA;
    private ImageView eRa;
    private View eRb;
    private View eRd;
    private TbImageView eRe;
    private g.f eRf;
    private ImageView eRh;
    private TextView eRi;
    private View eRn;
    private View eRo;
    private TextView eRp;
    private SeekBar eRq;
    private ImageView eRr;
    private ImageView eRs;
    private int eRt;
    private int eRx;
    private int eRy;
    private h fNw;
    private g.b geA;
    private View.OnClickListener geC;
    private b geD;
    private InterfaceC0218c geE;
    private g geF;
    private i geG;
    private j geH;
    private l geI;
    private k geJ;
    private e geK;
    private f geL;
    private TextView geQ;
    private boolean geS;
    private boolean geT;
    private boolean geU;
    private int geV;
    private boolean geW;
    private ProgressBar get;
    private View geu;
    private View gev;
    private TextView gew;
    private TextView gex;
    private TextView gey;
    private g.a gez;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int ger = 100;
    private boolean ges = false;
    protected boolean dfe = false;
    private boolean eRj = false;
    private boolean eRl = false;
    private boolean geB = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eRu = 0;
    private int eRv = 0;
    private boolean eRB = false;
    private boolean geM = true;
    private boolean geN = true;
    private boolean geO = false;
    private boolean geP = false;
    private String fMY = null;
    private int avP = -1;
    private boolean geR = false;
    private g.f bjN = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cyB = gVar;
            c.this.cyD.aVV();
            c.this.aiK();
        }
    };
    private VideoLoadingProgressView.a cyM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aiK();
        }
    };
    private Runnable eRD = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bvr.getCurrentPosition() > c.this.ger) {
                c.this.eRj = true;
                c.this.eQV.setVisibility(8);
                c.this.cBt.setVisibility(8);
                c.this.bcX.bkO();
                c.this.eRe.setVisibility(8);
                c.this.aSh();
                if (c.this.bjY()) {
                    c.this.cyD.a(c.this.aWq, -1L, c.this.bvr.getDuration() / 1000, "middle");
                }
                if (c.this.avP == 1 || c.this.avP == 2) {
                    if (c.this.eRb != null) {
                        c.this.eRb.setVisibility(0);
                        c.this.gev.setVisibility(0);
                        c.this.get.setVisibility(8);
                        if (c.this.geE != null) {
                            c.this.geE.fU(false);
                        }
                    }
                    c.this.eQU.showProgress();
                    c.this.aSi();
                }
                if (c.this.eRf != null) {
                    c.this.eRf.onPrepared(c.this.bvr.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRD, 20L);
        }
    };
    private g.a bjM = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bvr != null) {
                int duration = c.this.bvr.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.eRj = false;
                    c.this.geU = false;
                    c.this.mStartPosition = 0;
                    c.this.aRQ();
                    c.this.eQV.setVisibility(0);
                    c.this.get.setVisibility(8);
                    c.this.get.setProgress(c.this.get.getMax());
                    if (c.this.geE != null) {
                        c.this.geE.fU(false);
                    }
                    if (c.this.dfe) {
                        c.this.eRb.setVisibility(0);
                        c.this.eRh.setVisibility(0);
                        c.this.eRi.setVisibility(0);
                        c.this.gev.setVisibility(8);
                    } else {
                        c.this.eRb.setVisibility(8);
                        c.this.eRh.setVisibility(8);
                        c.this.eRi.setVisibility(8);
                        c.this.gev.setVisibility(8);
                    }
                    if (c.this.bvr == null || duration > 150000) {
                        c.this.lr(false);
                    } else {
                        c.this.gew.setVisibility(0);
                        c.this.cBp.setVisibility(8);
                    }
                    x.bkT().remove(c.this.bdb);
                    c.this.ger = 100;
                    if (c.this.gez != null) {
                        c.this.gez.onCompletion(gVar);
                    }
                    c.this.avP = 3;
                    c.this.bvr.setRecoveryState(3);
                    if (!c.this.dfe && c.this.bvr != null && duration <= 150000) {
                        if (!c.this.geR) {
                            if (c.this.geG != null) {
                                c.this.geG.kP(true);
                            }
                            c.this.bS(c.this.bdb, c.this.aWq);
                            return;
                        }
                        c.this.avP = 5;
                        c.this.bvr.setRecoveryState(5);
                        c.this.bvr.getPlayer().pause();
                        c.this.bvr.getPlayer().seekTo(0);
                    }
                }
            }
        }
    };
    private g.b eRE = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cBt.setVisibility(0);
            c.this.bcX.bkP();
            c.this.avP = 4;
            c.this.bvr.setRecoveryState(4);
            if (c.this.geA != null) {
                c.this.geA.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jE()) {
                c.this.geS = true;
            }
            c.this.geU = false;
            return true;
        }
    };
    private Runnable eRF = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.cBt.setVisibility(0);
            c.this.bcX.bkP();
        }
    };
    private g.InterfaceC0219g bjQ = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0219g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.geO) {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.geX, 200L);
            }
        }
    };
    private Runnable geX = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bvr == null || !c.this.geO) {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRD, 200L);
                c.this.geO = false;
            } else if (c.this.mStartPosition != c.this.bvr.getCurrentPosition()) {
                c.this.geO = false;
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRD, 20L);
            } else {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.geX, 200L);
            }
        }
    };
    private QuickVideoView.b bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eRj = false;
            if (c.this.geB) {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.geY, 300L);
            } else {
                c.this.geU = false;
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(c.this.eRD);
            com.baidu.adp.lib.g.e.in().removeCallbacks(c.this.eRF);
        }
    };
    private Runnable geY = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.geU = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cBt.getId()) {
                c.this.bjS();
            } else if (view.getId() != c.this.cBp.getId() && view.getId() != c.this.eQZ.getId()) {
                if (view.getId() == c.this.gex.getId()) {
                    if (c.this.geF != null) {
                        c.this.geF.bgt();
                    }
                } else if (view.getId() == c.this.gew.getId()) {
                    if (c.this.geG != null) {
                        c.this.geG.kP(false);
                    }
                    c.this.bS(c.this.bdb, c.this.aWq);
                } else if (view.getId() != c.this.eRa.getId() && view.getId() != c.this.geu.getId()) {
                    if (view.getId() != c.this.eRh.getId()) {
                        if (c.this.geC != null) {
                            c.this.geC.onClick(view);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c11713"));
                    if (c.this.geJ != null) {
                        c.this.geJ.awk();
                    }
                    if (c.this.bjM()) {
                        c.this.bjO();
                        c.this.lp(false);
                        return;
                    }
                    c.this.aRU();
                } else {
                    if (c.this.dfe) {
                        TiebaStatic.log(new an("c11714"));
                    } else {
                        TiebaStatic.log(new an("c11710"));
                    }
                    if (c.this.geJ != null) {
                        c.this.geJ.awk();
                    }
                    if (c.this.bjM()) {
                        if (c.this.dfe) {
                            c.this.bjO();
                        } else {
                            c.this.bjN();
                        }
                        c.this.lp(c.this.dfe);
                        return;
                    }
                    c.this.aRU();
                }
            } else {
                c.this.bgk();
            }
        }
    };
    private Animation.AnimationListener eRH = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eRb != null) {
                c.this.eRb.setVisibility(8);
                c.this.get.setVisibility(0);
                c.this.eRl = false;
                if (c.this.geE != null) {
                    c.this.geE.awl();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eRI = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable eRJ = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aSf();
        }
    };
    private CustomMessageListener eRK = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b eTE = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gz(int i2) {
            int duration;
            if (c.this.bvr != null && (duration = c.this.bvr.getDuration()) > 0 && c.this.get != null) {
                c.this.get.setProgress((int) ((i2 * c.this.eQS.getWidth()) / duration));
            }
            c.this.pk(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bnV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eRl) {
                c.this.aSi();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aSe() && c.this.aRV() != null) {
                c.this.setStartPosition(c.this.aRV().getSeekPosition());
                c.this.bS(c.this.bdb, c.this.aWq);
            }
        }
    };
    private QuickVideoView.a geZ = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bka() {
            if (!c.this.geR) {
                c.this.bcX.startLoading();
                c.this.eRe.setVisibility(0);
                c.this.cBp.setVisibility(8);
                c.this.eQZ.setImageResource(f.C0146f.icon_video_suspend_n);
                c.this.gex.setVisibility(8);
                c.this.gew.setVisibility(8);
                c.this.gey.setVisibility(8);
                c.this.cBt.setVisibility(8);
                com.baidu.adp.lib.g.e.in().removeCallbacks(c.this.eRF);
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRF, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void awh();

        void awi();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0218c {
        void awl();

        void fU(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void lu(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface g {
        void bgt();
    }

    /* loaded from: classes.dex */
    public interface h {
        void awm();
    }

    /* loaded from: classes.dex */
    public interface i {
        void kP(boolean z);
    }

    /* loaded from: classes.dex */
    public interface j {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface k {
        void awj();

        void awk();
    }

    /* loaded from: classes.dex */
    public interface l {
        void bgu();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eRx = 0;
        this.geW = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.eQS = q(tbPageContext);
            this.mRootView = view;
            this.geW = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eQS);
            }
            this.eRd = view;
            this.eQS.setOnClickListener(this.mOnClickListener);
            this.bvr = (QuickVideoView) this.eQS.findViewById(f.g.videoView);
            this.bcX = new w((ViewGroup) this.eQS.findViewById(f.g.auto_video_loading_container));
            this.bcX.setLoadingAnimationListener(this.cyM);
            this.eQU = (VideoListMediaControllerView) this.eQS.findViewById(f.g.media_controller);
            this.eQU.setPlayer(this.bvr);
            this.get = (ProgressBar) this.eQS.findViewById(f.g.pgrBottomProgress);
            this.get.setMax(com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()));
            this.get.setProgress(0);
            this.eQU.setOnSeekBarChangeListener(this.bnV);
            this.eQU.setOnProgressUpdatedListener(this.eTE);
            this.eQV = this.eQS.findViewById(f.g.black_mask);
            this.cBt = this.eQS.findViewById(f.g.layout_error);
            this.cBt.setOnClickListener(this.mOnClickListener);
            this.geQ = (TextView) this.eQS.findViewById(f.g.auto_video_error_tips);
            this.eQW = (FrameLayout) this.eQS.findViewById(f.g.danmu_container);
            this.eQZ = (ImageView) this.eQS.findViewById(f.g.img_play_icon);
            this.eQZ.setOnClickListener(this.mOnClickListener);
            this.eRa = (ImageView) this.eQS.findViewById(f.g.img_full_screen);
            this.eRa.setOnClickListener(this.mOnClickListener);
            this.geu = this.eQS.findViewById(f.g.full_screen_container);
            this.geu.setOnClickListener(this.mOnClickListener);
            this.eRb = this.eQS.findViewById(f.g.layout_media_controller);
            this.gev = this.eQS.findViewById(f.g.time_show_controller);
            this.bvr.setOnPreparedListener(this.bjN);
            this.bvr.setOnCompletionListener(this.bjM);
            this.bvr.setOnErrorListener(this.eRE);
            this.bvr.setOnSeekCompleteListener(this.bjQ);
            this.bvr.setOnSurfaceDestroyedListener(this.bdh);
            this.bvr.setOnRecoveryCallback(this.geZ);
            this.cBp = (ImageView) this.eQS.findViewById(f.g.img_play);
            this.cBp.setOnClickListener(this.mOnClickListener);
            this.gew = (TextView) this.eQS.findViewById(f.g.txt_replay);
            this.gew.setOnClickListener(this.mOnClickListener);
            this.gex = (TextView) this.eQS.findViewById(f.g.txt_playnext);
            this.gex.setOnClickListener(this.mOnClickListener);
            this.gey = (TextView) this.eQS.findViewById(f.g.txt_next_video_title);
            this.eRe = (TbImageView) this.eQS.findViewById(f.g.video_thumbnail);
            this.eRe.setDefaultErrorResource(0);
            this.eRe.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
            this.eRh = (ImageView) this.eQS.findViewById(f.g.img_exit);
            this.eRh.setOnClickListener(this.mOnClickListener);
            this.eRi = (TextView) this.eQS.findViewById(f.g.video_title);
            this.cBo = this.eQS.findViewById(f.g.layout_title);
            this.cBo.setVisibility(8);
            this.drc = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.drd = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eRt = this.mAudioManager.getStreamMaxVolume(3);
            this.eRy = this.mAudioManager.getStreamVolume(3);
            eRz = 100 / this.eRt;
            this.eQS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.geH != null) {
                        c.this.geH.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eRj) {
                            if (c.this.mStatus == 1 && c.this.eRv != 0) {
                                c.this.b(c.this.eRv == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eRv = 0;
                                c.this.eRu = 0;
                            }
                            if (!c.this.bvr.isPlaying() && 8 == c.this.cBp.getVisibility()) {
                                c.this.cBp.setVisibility(0);
                                c.this.gex.setVisibility(8);
                                c.this.gew.setVisibility(8);
                                c.this.gey.setVisibility(8);
                            }
                        }
                        c.this.aRQ();
                        if (c.this.geH != null) {
                            c.this.geH.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bKk = new o(this.mContext.getPageActivity());
            if (this.geW) {
                this.bKk.start();
            }
            this.eRx = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.ds16);
            this.eRA = new CallStateReceiver();
            this.eRA.register(this.mContext.getPageActivity());
            this.mContext.registerListener(this.eRK);
            bjL();
            this.cyD = new com.baidu.tieba.j.k();
        }
    }

    public void bjL() {
        if (this.geM) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eQS.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eQS.setSystemUiVisibility(0);
    }

    public void lo(boolean z) {
        this.geM = z;
        bjL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRQ() {
        this.mStatus = 0;
        if (this.eRn != null && this.eRn.getParent() != null && (this.eRn.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eRn.getParent()).removeView(this.eRn);
                this.eRn = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eRo != null && this.eRo.getParent() != null && (this.eRo.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eRo.getParent()).removeView(this.eRo);
                this.eRo = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aRR() {
        if (this.mStatus == 1) {
            if (this.eRn == null && this.eQS != null && (this.eQS instanceof ViewGroup)) {
                LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.float_video_window_jindu, (ViewGroup) this.eQS, true);
                this.eRn = this.eQS.findViewById(f.g.lay_jindu);
                this.eRp = (TextView) this.eRn.findViewById(f.g.show_time);
                this.eRs = (ImageView) this.eRn.findViewById(f.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eRo == null && this.eQS != null && (this.eQS instanceof ViewGroup)) {
            LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.float_video_window_voice, (ViewGroup) this.eQS, true);
            this.eRo = this.eQS.findViewById(f.g.lay_voice);
            this.eRr = (ImageView) this.eRo.findViewById(f.g.arrow_voice_icon);
            this.eRq = (SeekBar) this.eRo.findViewById(f.g.show_voice_seekbar);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.geC = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.geH != null) {
                c.this.geH.onStart();
            }
            if (c.this.dfe && c.this.eRj) {
                if (!c.this.bvr.isPlaying() && c.this.cBp.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cBp.setVisibility(8);
                    c.this.gex.setVisibility(8);
                    c.this.gew.setVisibility(8);
                    c.this.gey.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ap(f2);
                    }
                } else {
                    if (c.this.dfe) {
                        c.this.aRT();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eRu = c.this.bvr.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ap(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.geI != null) {
                c.this.geI.bgu();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eRj) {
                if (c.this.avP != 2) {
                    c.this.bjV();
                } else {
                    c.this.bgk();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eQS.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eQS.setSystemUiVisibility(4);
        } else {
            this.eQS.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f2) {
        if (!this.eRj) {
            this.mStatus = 0;
            return;
        }
        aRR();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eRz == 0) {
            if (f2 > 0.0f && this.eRy < this.eRt) {
                this.eRy++;
            }
            if (f2 < 0.0f && this.eRy > 0) {
                this.eRy--;
            }
        }
        if (this.mProgress > 0) {
            this.eRr.setImageResource(f.C0146f.icon_shengyin_open);
        } else {
            this.eRr.setImageResource(f.C0146f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eRy, 0);
        this.eRq.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eRu += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eRv = 1;
            } else {
                this.eRu += 1000;
                this.eRv = 2;
            }
            if (this.eRu < 0) {
                this.eRu = 0;
            } else if (this.eRu > this.bvr.getDuration()) {
                this.eRu = this.bvr.getDuration();
            }
        }
        aRR();
        String rI = this.eQU.rI(this.eRu);
        if (f2 > 0.0f) {
            this.eRs.setImageResource(f.C0146f.icon_kuaitui);
        } else {
            this.eRs.setImageResource(f.C0146f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rI)) {
            this.eRp.setText(new StringBuilder().append(rI).append("/").append(this.eQU.rI(this.bvr.getDuration())));
        }
        this.eQU.setCurrentDuration(this.eRu, z ? false : true);
        this.eRb.setVisibility(8);
        this.get.setVisibility(0);
        bjP();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bdb = str;
        this.aWq = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        int i2 = 100;
        if (this.bvr != null && this.cyB != null) {
            if (this.geU) {
                this.bvr.start();
                this.geU = false;
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRD);
            com.baidu.adp.lib.g.e.in().postDelayed(this.eRD, 20L);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRF);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.geY);
            if (this.bvr.bkr()) {
                this.avP = 1;
                this.bvr.setRecoveryState(1);
            }
            if (this.cyB != null && this.eQU != null) {
                this.mStartPosition = x.bkT().sh(this.bdb);
                this.eQU.T(this.mStartPosition, this.cyB.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bvr != null) {
                        this.bvr.rH(this.mStartPosition);
                    } else {
                        this.cyB.seekTo(this.mStartPosition);
                    }
                    if (!this.geT) {
                        this.eQU.showProgress();
                    }
                    this.geO = true;
                }
                if (this.mStartPosition > 100 && this.cyB.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.ger = i2;
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
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
    public void lp(boolean z) {
        if (hasNavBar(this.mContext.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gev.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mContext.getPageActivity());
                this.gev.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gev.setBackgroundResource(f.C0146f.bg_video_shadow);
            }
            this.gev.setLayoutParams(layoutParams);
        }
    }

    public void bgk() {
        if (!com.baidu.adp.lib.util.j.jE()) {
            com.baidu.adp.lib.util.l.F(this.mContext.getPageActivity(), this.mContext.getString(f.j.neterror));
        } else if (this.bvr.isPlaying()) {
            pausePlay();
            if (this.geL != null) {
                this.geL.onPause();
            }
        } else if (this.eRj) {
            aSd();
            if (this.fNw != null) {
                this.fNw.awm();
            }
        } else {
            bjS();
        }
    }

    public void aRU() {
        this.eRB = true;
        if (this.bKk != null) {
            this.bKk.aRU();
        }
    }

    public boolean bjM() {
        return this.cyB != null && this.cyB.getVideoHeight() > this.cyB.getVideoWidth();
    }

    public boolean rE(int i2) {
        switch (i2) {
            case 4:
                if (this.dfe) {
                    if (bjM()) {
                        lp(false);
                        bjO();
                    } else {
                        aRU();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eRt <= 0 || this.eRq == null) {
                    return false;
                }
                this.eRy = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eRy * 100.0d) / this.eRt);
                this.eRq.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bvr;
    }

    public VideoListMediaControllerView aRV() {
        return this.eQU;
    }

    public void show() {
        this.eQS.setVisibility(0);
    }

    public void aRZ() {
        if (this.eRd != null) {
            ViewGroup.LayoutParams layoutParams = this.eRd.getLayoutParams();
            this.eQX = (FrameLayout.LayoutParams) this.eQS.getLayoutParams();
            this.eQX.width = layoutParams.width;
            this.eQX.height = layoutParams.height;
            this.eQX.topMargin = 0;
            this.eQS.setLayoutParams(this.eQX);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eRB) {
            if (this.dfe) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.eRB = false;
        }
        if (configuration.orientation == 2) {
            bjN();
        } else {
            bjO();
        }
        if (this.bvr.isPlaying()) {
            aSi();
        }
        bjP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjN() {
        this.dfe = true;
        if (bjM()) {
            this.eQS.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.eQS.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.mContext, true);
        this.eRb.setVisibility(0);
        this.cBo.setVisibility(0);
        this.eRh.setVisibility(0);
        this.eRi.setVisibility(0);
        this.eQW.setVisibility(8);
        if (this.geB) {
            this.bcX.startLoading();
            this.eRe.setVisibility(0);
        } else {
            this.bcX.bkP();
            this.eRe.setVisibility(8);
        }
        if (this.geD != null) {
            this.geD.awh();
        }
        this.eRa.setImageResource(f.C0146f.icon_video_window);
        pi(this.eRx);
        aRT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjO() {
        this.dfe = false;
        if (this.eQX != null) {
            this.eQS.setLayoutParams(this.eQX);
        }
        a((TbPageContext) this.mContext, false);
        this.cBo.setVisibility(8);
        this.eQW.setVisibility(0);
        if (this.geB) {
            this.bcX.startLoading();
            this.eRe.setVisibility(0);
        } else {
            this.bcX.bkP();
            this.eRe.setVisibility(8);
        }
        if (this.geD != null) {
            this.geD.awi();
        }
        if (this.avP == 3 && this.geE != null) {
            this.geE.fU(false);
        } else if (!this.eRj && this.eRb != null) {
            this.eRb.clearAnimation();
            this.eRb.setVisibility(4);
            this.get.setVisibility(0);
            if (this.geE != null) {
                this.geE.awl();
            }
        }
        aRQ();
        this.eRa.setImageResource(f.C0146f.icon_video_fullscreen);
        if (this.eQU != null && (this.eQU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQU.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.tbds24);
            layoutParams.rightMargin = 0;
            this.eQU.setLayoutParams(layoutParams);
        }
        this.eQS.setSystemUiVisibility(0);
        bjL();
    }

    public void bjP() {
        if (this.bvr != null) {
            int ah = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            if (this.dfe) {
                ah = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
            }
            this.get.setMax(ah);
            int duration = this.bvr.getDuration();
            if (duration > 0) {
                if (this.gew.getVisibility() == 0) {
                    this.get.setProgress(this.get.getMax());
                } else {
                    this.get.setProgress((int) ((this.bvr.getCurrentPosition() * this.get.getMax()) / duration));
                }
            }
        }
    }

    private void pi(int i2) {
        if (this.eQU != null && (this.eQU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQU.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eQU.setLayoutParams(layoutParams);
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

    public boolean aSb() {
        return !this.dfe;
    }

    public void a(g.f fVar) {
        this.eRf = fVar;
    }

    public void a(g.a aVar) {
        this.gez = aVar;
    }

    public void a(g.b bVar) {
        this.geA = bVar;
    }

    public void setPauseState() {
        this.eQZ.setImageResource(f.C0146f.icon_video_play);
        this.bcX.bkP();
        this.cBp.setVisibility(0);
        this.gex.setVisibility(8);
        this.gew.setVisibility(8);
        this.gey.setVisibility(8);
        this.avP = 2;
        this.bvr.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bvr != null) {
            this.bvr.setPbLoadingTime(currentTimeMillis);
        }
        bS(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z, String str, String str2) {
        if (this.geP) {
            bT(str, str2);
        } else {
            bS(str, str2);
        }
        if (dVar != null) {
            dVar.lu(z);
        }
    }

    public void bS(String str, String str2) {
        bjT();
        this.geU = true;
        this.avP = 0;
        this.bvr.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bvr.setVideoPath(str, str2);
        this.bcX.startLoading();
        this.cyD.aVU();
        this.eRe.setVisibility(0);
        this.cBp.setVisibility(8);
        this.eQZ.setImageResource(f.C0146f.icon_video_suspend_n);
        this.gex.setVisibility(8);
        this.gew.setVisibility(8);
        this.gey.setVisibility(8);
        this.cBt.setVisibility(8);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRF);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eRF, 60000L);
    }

    public void bT(String str, String str2) {
        bjT();
        this.geU = true;
        this.avP = 0;
        this.bvr.setRecoveryState(0);
        this.bcX.startLoading();
        this.eRe.setVisibility(0);
        this.cBp.setVisibility(8);
        this.eQZ.setImageResource(f.C0146f.icon_video_suspend_n);
        this.gex.setVisibility(8);
        this.gew.setVisibility(8);
        this.gey.setVisibility(8);
        this.cBt.setVisibility(8);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRF);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eRF, 60000L);
    }

    public void aSd() {
        this.avP = 1;
        this.bvr.setRecoveryState(1);
        this.bvr.start();
        this.eQZ.setImageResource(f.C0146f.icon_video_suspend_n);
        this.eRe.setVisibility(8);
        this.eQV.setVisibility(8);
        this.bcX.bkP();
        this.eQU.showProgress();
        this.cBp.setVisibility(8);
        this.gex.setVisibility(8);
        this.gew.setVisibility(8);
        this.gey.setVisibility(8);
        bjX();
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.jE() && this.geS && !StringUtils.isNull(this.bdb) && !StringUtils.isNull(this.aWq)) {
            this.geS = false;
            this.geT = true;
            bS(this.bdb, this.aWq);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bvr != null) {
            this.bvr.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bvr.isPlaying() && this.geN) {
            bjQ();
        }
        bjW();
        this.bvr.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bvr.isPlaying() && this.geN) {
            bjQ();
        }
        this.avP = 5;
        this.bvr.setRecoveryState(5);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRD);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRF);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.geY);
        this.bvr.stopPlayback();
        this.eRj = false;
        this.geU = false;
        this.mStartPosition = 0;
        aFa();
    }

    public void bjQ() {
        x.bkT().aD(this.bdb, this.bvr.getCurrentPosition());
    }

    public void lq(boolean z) {
        this.geN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        if (this.eRb != null) {
            this.eQV.setVisibility(0);
            this.cBp.setVisibility(0);
            this.gex.setVisibility(8);
            this.gew.setVisibility(8);
            this.gey.setVisibility(8);
            this.bcX.bkP();
            this.eQZ.setImageResource(f.C0146f.icon_video_play);
            this.eRb.setVisibility(4);
            this.get.setVisibility(8);
            this.cBt.setVisibility(8);
            this.eQU.Rl();
            this.eRe.setVisibility(z ? 0 : 8);
        }
    }

    public void aFa() {
        lr(true);
    }

    public boolean bjR() {
        if (this.bvr == null) {
            return false;
        }
        return this.bvr.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bvr == null) {
            return 0;
        }
        return this.bvr.getCurrentPosition();
    }

    public void a(j jVar) {
        this.geH = jVar;
    }

    public void a(i iVar) {
        this.geG = iVar;
    }

    public void a(h hVar) {
        this.fNw = hVar;
    }

    public void a(f fVar) {
        this.geL = fVar;
    }

    public void a(g gVar) {
        this.geF = gVar;
    }

    public void rJ(String str) {
        this.fMY = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjS() {
        a(this.bdb, this.aWq, (d) null, new Object[0]);
    }

    public void b(InterfaceC0218c interfaceC0218c) {
        this.geE = interfaceC0218c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        bjT();
        if (com.baidu.adp.lib.util.j.jG() && !com.baidu.tieba.video.g.bAk().bAl()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.geP = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.geK != null) {
                    this.geK.fT(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(TbadkCoreApplication.getInst().getString(f.j.play_video_mobile_tip));
                aVar.a(f.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bjU();
                        aVar2.dismiss();
                        c.this.a(dVar, false, str, str2);
                    }
                });
                aVar.b(f.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xe();
                return;
            } else if (this.geK != null) {
                this.geK.fT(true);
                return;
            } else {
                if (!this.ges) {
                    this.ges = true;
                    com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.play_video_mobile_tip2);
                }
                a(dVar, true, str, str2);
                return;
            }
        }
        a(dVar, true, str, str2);
        if (this.geJ != null) {
            this.geJ.awj();
        }
    }

    private void bjT() {
        if (com.baidu.adp.lib.util.j.jG()) {
            com.baidu.tieba.video.g.bAk().ck(this.mContext.getPageActivity());
        }
    }

    public void bjU() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.eRe.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRJ);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRD);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRF);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.geX);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.geY);
        this.bKk.stop();
        this.eRA.unregister(this.mContext.getPageActivity());
    }

    public void sd(String str) {
        this.eRi.setText(str);
    }

    public boolean aSe() {
        return this.eRj;
    }

    public void aSf() {
        if (this.eRb != null) {
            aSh();
            this.eRb.setVisibility(0);
            this.gev.setVisibility(0);
            if (this.geE != null) {
                this.geE.fU(true);
            }
            this.get.setVisibility(8);
            this.drc.setAnimationListener(this.eRH);
            this.eRb.startAnimation(this.drc);
            this.eRl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjV() {
        if (this.eRb != null) {
            if (this.eRb.getVisibility() == 0) {
                aSh();
                this.eRb.setVisibility(8);
                this.get.setVisibility(0);
                if (this.geE != null) {
                    this.geE.awl();
                    return;
                }
                return;
            }
            aSi();
        }
    }

    public void aSg() {
        if (this.eRb != null) {
            aSh();
            this.eRb.setVisibility(0);
            this.gev.setVisibility(0);
            if (this.geE != null) {
                this.geE.fU(false);
            }
            this.get.setVisibility(8);
            this.drd.setAnimationListener(this.eRI);
            this.eRb.startAnimation(this.drd);
        }
    }

    public void bjW() {
        if (this.eRb != null) {
            aSh();
            this.eRb.setVisibility(0);
            this.gev.setVisibility(0);
            this.get.setVisibility(8);
            if (this.geE != null) {
                this.geE.fU(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSh() {
        if (this.eRb != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRJ);
            this.drd.setAnimationListener(null);
            this.drc.setAnimationListener(null);
            this.eRb.clearAnimation();
            this.eRl = false;
        }
    }

    public void aSi() {
        aSg();
        bjX();
    }

    private void bjX() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRJ);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eRJ, 3000L);
    }

    public void a(b bVar) {
        this.geD = bVar;
    }

    public void pk(int i2) {
        if (this.bvr.getDuration() - i2 <= 3000) {
            aSh();
            if (this.eRb != null) {
                this.eRb.setVisibility(0);
                this.gev.setVisibility(0);
                this.get.setVisibility(8);
                if (this.geE != null) {
                    this.geE.fU(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void N(boolean z, boolean z2) {
        int i2 = 8;
        if (this.bKk != null) {
            if (this.eRa != null || this.geu != null) {
                this.eRa.setVisibility((z || !z2) ? 0 : 8);
                View view = this.geu;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.eQU != null && (this.eQU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQU.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.tbds52);
                this.eQU.setLayoutParams(layoutParams);
            }
            this.bKk.lw(z);
        }
    }

    public int getScreenHeight(Context context) {
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
            return com.baidu.adp.lib.util.l.aj(context);
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

    public int getCurrentState() {
        return this.avP;
    }

    public void a(l lVar) {
        this.geI = lVar;
    }

    public void a(k kVar) {
        this.geJ = kVar;
    }

    public void a(e eVar) {
        this.geK = eVar;
    }

    public void ls(boolean z) {
        this.geR = z;
    }

    public boolean bjY() {
        return this.geB;
    }

    public void lt(boolean z) {
        this.geB = z;
    }

    public void rF(int i2) {
        this.geV = i2;
    }

    public void bjZ() {
        com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), this.eQZ, 40, 40, 40, 40);
    }

    public List<String> getMediaIDs() {
        if (this.bvr != null) {
            return this.bvr.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.bvr != null ? this.bvr.getMediaId() : "";
    }
}
