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
import com.baidu.tieba.d;
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
    private static int eRE;
    private String aWq;
    private o bKl;
    private w bcX;
    private String bdb;
    private QuickVideoView bvp;
    private View cBr;
    private ImageView cBs;
    private View cBw;
    private com.baidu.tieba.play.g cyE;
    private com.baidu.tieba.j.k cyG;
    private Animation dre;
    private Animation drf;
    public View eQX;
    private VideoListMediaControllerView eQZ;
    private int eRC;
    private int eRD;
    private CallStateReceiver eRF;
    private View eRa;
    private FrameLayout eRb;
    protected FrameLayout.LayoutParams eRc;
    private ImageView eRe;
    private ImageView eRf;
    private View eRg;
    private View eRi;
    private TbImageView eRj;
    private g.f eRk;
    private ImageView eRm;
    private TextView eRn;
    private View eRs;
    private View eRt;
    private TextView eRu;
    private SeekBar eRv;
    private ImageView eRw;
    private ImageView eRx;
    private int eRy;
    private h fND;
    private g.a geA;
    private g.b geB;
    private View.OnClickListener geD;
    private b geE;
    private InterfaceC0218c geF;
    private g geG;
    private i geH;
    private j geI;
    private l geJ;
    private k geK;
    private e geL;
    private f geM;
    private TextView geR;
    private boolean geT;
    private boolean geU;
    private boolean geV;
    private int geW;
    private boolean geX;
    private ProgressBar geu;
    private View gev;
    private View gew;
    private TextView gex;
    private TextView gey;
    private TextView gez;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int ges = 100;
    private boolean get = false;
    protected boolean dfg = false;
    private boolean eRo = false;
    private boolean eRq = false;
    private boolean geC = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eRz = 0;
    private int eRA = 0;
    private boolean eRG = false;
    private boolean geN = true;
    private boolean geO = true;
    private boolean geP = false;
    private boolean geQ = false;
    private String fNf = null;
    private int avR = -1;
    private boolean geS = false;
    private g.f bjH = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cyE = gVar;
            c.this.cyG.aVZ();
            c.this.aiH();
        }
    };
    private VideoLoadingProgressView.a cyP = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aiH();
        }
    };
    private Runnable eRI = new Runnable() { // from class: com.baidu.tieba.play.c.16
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bvp.getCurrentPosition() > c.this.ges) {
                c.this.eRo = true;
                c.this.eRa.setVisibility(8);
                c.this.cBw.setVisibility(8);
                c.this.bcX.bkR();
                c.this.eRj.setVisibility(8);
                c.this.aSk();
                if (c.this.bkb()) {
                    c.this.cyG.a(c.this.aWq, -1L, c.this.bvp.getDuration() / 1000, "middle");
                }
                if (c.this.avR == 1 || c.this.avR == 2) {
                    if (c.this.eRg != null) {
                        c.this.eRg.setVisibility(0);
                        c.this.gew.setVisibility(0);
                        c.this.geu.setVisibility(8);
                        if (c.this.geF != null) {
                            c.this.geF.fU(false);
                        }
                    }
                    c.this.eQZ.showProgress();
                    c.this.aSl();
                }
                if (c.this.eRk != null) {
                    c.this.eRk.onPrepared(c.this.bvp.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRI, 20L);
        }
    };
    private g.a bjG = new g.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bvp != null) {
                int duration = c.this.bvp.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.eRo = false;
                    c.this.geV = false;
                    c.this.mStartPosition = 0;
                    c.this.aRT();
                    c.this.eRa.setVisibility(0);
                    c.this.geu.setVisibility(8);
                    c.this.geu.setProgress(c.this.geu.getMax());
                    if (c.this.geF != null) {
                        c.this.geF.fU(false);
                    }
                    if (c.this.dfg) {
                        c.this.eRg.setVisibility(0);
                        c.this.eRm.setVisibility(0);
                        c.this.eRn.setVisibility(0);
                        c.this.gew.setVisibility(8);
                    } else {
                        c.this.eRg.setVisibility(8);
                        c.this.eRm.setVisibility(8);
                        c.this.eRn.setVisibility(8);
                        c.this.gew.setVisibility(8);
                    }
                    if (c.this.bvp == null || duration > 150000) {
                        c.this.lr(false);
                    } else {
                        c.this.gex.setVisibility(0);
                        c.this.cBs.setVisibility(8);
                    }
                    x.bkW().remove(c.this.bdb);
                    c.this.ges = 100;
                    if (c.this.geA != null) {
                        c.this.geA.onCompletion(gVar);
                    }
                    c.this.avR = 3;
                    c.this.bvp.setRecoveryState(3);
                    if (!c.this.dfg && c.this.bvp != null && duration <= 150000) {
                        if (!c.this.geS) {
                            if (c.this.geH != null) {
                                c.this.geH.kP(true);
                            }
                            c.this.bS(c.this.bdb, c.this.aWq);
                            return;
                        }
                        c.this.avR = 5;
                        c.this.bvp.setRecoveryState(5);
                        c.this.bvp.getPlayer().pause();
                        c.this.bvp.getPlayer().seekTo(0);
                    }
                }
            }
        }
    };
    private g.b eRJ = new g.b() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cBw.setVisibility(0);
            c.this.bcX.bkS();
            c.this.avR = 4;
            c.this.bvp.setRecoveryState(4);
            if (c.this.geB != null) {
                c.this.geB.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.jE()) {
                c.this.geT = true;
            }
            c.this.geV = false;
            return true;
        }
    };
    private Runnable eRK = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            c.this.cBw.setVisibility(0);
            c.this.bcX.bkS();
        }
    };
    private g.InterfaceC0219g bjK = new g.InterfaceC0219g() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.InterfaceC0219g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.geP) {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.geY, 200L);
            }
        }
    };
    private Runnable geY = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bvp == null || !c.this.geP) {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRI, 200L);
                c.this.geP = false;
            } else if (c.this.mStartPosition != c.this.bvp.getCurrentPosition()) {
                c.this.geP = false;
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRI, 20L);
            } else {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.geY, 200L);
            }
        }
    };
    private QuickVideoView.b bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eRo = false;
            if (c.this.geC) {
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.geZ, 300L);
            } else {
                c.this.geV = false;
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(c.this.eRI);
            com.baidu.adp.lib.g.e.in().removeCallbacks(c.this.eRK);
        }
    };
    private Runnable geZ = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.geV = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.cBw.getId()) {
                c.this.bjV();
            } else if (view.getId() != c.this.cBs.getId() && view.getId() != c.this.eRe.getId()) {
                if (view.getId() == c.this.gey.getId()) {
                    if (c.this.geG != null) {
                        c.this.geG.bgy();
                    }
                } else if (view.getId() == c.this.gex.getId()) {
                    if (c.this.geH != null) {
                        c.this.geH.kP(false);
                    }
                    c.this.bS(c.this.bdb, c.this.aWq);
                } else if (view.getId() != c.this.eRf.getId() && view.getId() != c.this.gev.getId()) {
                    if (view.getId() != c.this.eRm.getId()) {
                        if (c.this.geD != null) {
                            c.this.geD.onClick(view);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new an("c11713"));
                    if (c.this.geK != null) {
                        c.this.geK.awl();
                    }
                    if (c.this.bjP()) {
                        c.this.bjR();
                        c.this.lp(false);
                        return;
                    }
                    c.this.aRX();
                } else {
                    if (c.this.dfg) {
                        TiebaStatic.log(new an("c11714"));
                    } else {
                        TiebaStatic.log(new an("c11710"));
                    }
                    if (c.this.geK != null) {
                        c.this.geK.awl();
                    }
                    if (c.this.bjP()) {
                        if (c.this.dfg) {
                            c.this.bjR();
                        } else {
                            c.this.bjQ();
                        }
                        c.this.lp(c.this.dfg);
                        return;
                    }
                    c.this.aRX();
                }
            } else {
                c.this.bgp();
            }
        }
    };
    private Animation.AnimationListener eRM = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.7
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.eRg != null) {
                c.this.eRg.setVisibility(8);
                c.this.geu.setVisibility(0);
                c.this.eRq = false;
                if (c.this.geF != null) {
                    c.this.geF.awm();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener eRN = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Runnable eRO = new Runnable() { // from class: com.baidu.tieba.play.c.9
        @Override // java.lang.Runnable
        public void run() {
            c.this.aSi();
        }
    };
    private CustomMessageListener eRP = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b eTJ = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gA(int i2) {
            int duration;
            if (c.this.bvp != null && (duration = c.this.bvp.getDuration()) > 0 && c.this.geu != null) {
                c.this.geu.setProgress((int) ((i2 * c.this.eQX.getWidth()) / duration));
            }
            c.this.pk(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener bnT = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.13
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.eRq) {
                c.this.aSl();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aSh() && c.this.aRY() != null) {
                c.this.setStartPosition(c.this.aRY().getSeekPosition());
                c.this.bS(c.this.bdb, c.this.aWq);
            }
        }
    };
    private QuickVideoView.a gfa = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bkd() {
            if (!c.this.geS) {
                c.this.bcX.startLoading();
                c.this.eRj.setVisibility(0);
                c.this.cBs.setVisibility(8);
                c.this.eRe.setImageResource(d.f.icon_video_suspend_n);
                c.this.gey.setVisibility(8);
                c.this.gex.setVisibility(8);
                c.this.gez.setVisibility(8);
                c.this.cBw.setVisibility(8);
                com.baidu.adp.lib.g.e.in().removeCallbacks(c.this.eRK);
                com.baidu.adp.lib.g.e.in().postDelayed(c.this.eRK, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void awi();

        void awj();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0218c {
        void awm();

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
        void bgy();
    }

    /* loaded from: classes.dex */
    public interface h {
        void awn();
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
        void awk();

        void awl();
    }

    /* loaded from: classes.dex */
    public interface l {
        void bgz();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eRC = 0;
        this.geX = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.eQX = q(tbPageContext);
            this.mRootView = view;
            this.geX = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eQX);
            }
            this.eRi = view;
            this.eQX.setOnClickListener(this.mOnClickListener);
            this.bvp = (QuickVideoView) this.eQX.findViewById(d.g.videoView);
            this.bcX = new w((ViewGroup) this.eQX.findViewById(d.g.auto_video_loading_container));
            this.bcX.setLoadingAnimationListener(this.cyP);
            this.eQZ = (VideoListMediaControllerView) this.eQX.findViewById(d.g.media_controller);
            this.eQZ.setPlayer(this.bvp);
            this.geu = (ProgressBar) this.eQX.findViewById(d.g.pgrBottomProgress);
            this.geu.setMax(com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()));
            this.geu.setProgress(0);
            this.eQZ.setOnSeekBarChangeListener(this.bnT);
            this.eQZ.setOnProgressUpdatedListener(this.eTJ);
            this.eRa = this.eQX.findViewById(d.g.black_mask);
            this.cBw = this.eQX.findViewById(d.g.layout_error);
            this.cBw.setOnClickListener(this.mOnClickListener);
            this.geR = (TextView) this.eQX.findViewById(d.g.auto_video_error_tips);
            this.eRb = (FrameLayout) this.eQX.findViewById(d.g.danmu_container);
            this.eRe = (ImageView) this.eQX.findViewById(d.g.img_play_icon);
            this.eRe.setOnClickListener(this.mOnClickListener);
            this.eRf = (ImageView) this.eQX.findViewById(d.g.img_full_screen);
            this.eRf.setOnClickListener(this.mOnClickListener);
            this.gev = this.eQX.findViewById(d.g.full_screen_container);
            this.gev.setOnClickListener(this.mOnClickListener);
            this.eRg = this.eQX.findViewById(d.g.layout_media_controller);
            this.gew = this.eQX.findViewById(d.g.time_show_controller);
            this.bvp.setOnPreparedListener(this.bjH);
            this.bvp.setOnCompletionListener(this.bjG);
            this.bvp.setOnErrorListener(this.eRJ);
            this.bvp.setOnSeekCompleteListener(this.bjK);
            this.bvp.setOnSurfaceDestroyedListener(this.bdh);
            this.bvp.setOnRecoveryCallback(this.gfa);
            this.cBs = (ImageView) this.eQX.findViewById(d.g.img_play);
            this.cBs.setOnClickListener(this.mOnClickListener);
            this.gex = (TextView) this.eQX.findViewById(d.g.txt_replay);
            this.gex.setOnClickListener(this.mOnClickListener);
            this.gey = (TextView) this.eQX.findViewById(d.g.txt_playnext);
            this.gey.setOnClickListener(this.mOnClickListener);
            this.gez = (TextView) this.eQX.findViewById(d.g.txt_next_video_title);
            this.eRj = (TbImageView) this.eQX.findViewById(d.g.video_thumbnail);
            this.eRj.setDefaultErrorResource(0);
            this.eRj.setDefaultBgResource(d.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            this.mScreenHeight = bM(this.mContext.getPageActivity());
            this.eRm = (ImageView) this.eQX.findViewById(d.g.img_exit);
            this.eRm.setOnClickListener(this.mOnClickListener);
            this.eRn = (TextView) this.eQX.findViewById(d.g.video_title);
            this.cBr = this.eQX.findViewById(d.g.layout_title);
            this.cBr.setVisibility(8);
            this.dre = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.drf = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eRy = this.mAudioManager.getStreamMaxVolume(3);
            this.eRD = this.mAudioManager.getStreamVolume(3);
            eRE = 100 / this.eRy;
            this.eQX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.geI != null) {
                        c.this.geI.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eRo) {
                            if (c.this.mStatus == 1 && c.this.eRA != 0) {
                                c.this.b(c.this.eRA == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eRA = 0;
                                c.this.eRz = 0;
                            }
                            if (!c.this.bvp.isPlaying() && 8 == c.this.cBs.getVisibility()) {
                                c.this.cBs.setVisibility(0);
                                c.this.gey.setVisibility(8);
                                c.this.gex.setVisibility(8);
                                c.this.gez.setVisibility(8);
                            }
                        }
                        c.this.aRT();
                        if (c.this.geI != null) {
                            c.this.geI.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bKl = new o(this.mContext.getPageActivity());
            if (this.geX) {
                this.bKl.start();
            }
            this.eRC = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.ds16);
            this.eRF = new CallStateReceiver();
            this.eRF.register(this.mContext.getPageActivity());
            this.mContext.registerListener(this.eRP);
            bjO();
            this.cyG = new com.baidu.tieba.j.k();
        }
    }

    public void bjO() {
        if (this.geN) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eQX.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eQX.setSystemUiVisibility(0);
    }

    public void lo(boolean z) {
        this.geN = z;
        bjO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRT() {
        this.mStatus = 0;
        if (this.eRs != null && this.eRs.getParent() != null && (this.eRs.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eRs.getParent()).removeView(this.eRs);
                this.eRs = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eRt != null && this.eRt.getParent() != null && (this.eRt.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eRt.getParent()).removeView(this.eRt);
                this.eRt = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aRU() {
        if (this.mStatus == 1) {
            if (this.eRs == null && this.eQX != null && (this.eQX instanceof ViewGroup)) {
                LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) this.eQX, true);
                this.eRs = this.eQX.findViewById(d.g.lay_jindu);
                this.eRu = (TextView) this.eRs.findViewById(d.g.show_time);
                this.eRx = (ImageView) this.eRs.findViewById(d.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eRt == null && this.eQX != null && (this.eQX instanceof ViewGroup)) {
            LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) this.eQX, true);
            this.eRt = this.eQX.findViewById(d.g.lay_voice);
            this.eRw = (ImageView) this.eRt.findViewById(d.g.arrow_voice_icon);
            this.eRv = (SeekBar) this.eRt.findViewById(d.g.show_voice_seekbar);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.geD = onClickListener;
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.geI != null) {
                c.this.geI.onStart();
            }
            if (c.this.dfg && c.this.eRo) {
                if (!c.this.bvp.isPlaying() && c.this.cBs.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.cBs.setVisibility(8);
                    c.this.gey.setVisibility(8);
                    c.this.gex.setVisibility(8);
                    c.this.gez.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aq(f2);
                    }
                } else {
                    if (c.this.dfg) {
                        c.this.aRW();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eRz = c.this.bvp.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aq(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.geJ != null) {
                c.this.geJ.bgz();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.eRo) {
                if (c.this.avR != 2) {
                    c.this.bjY();
                } else {
                    c.this.bgp();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRW() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eQX.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eQX.setSystemUiVisibility(4);
        } else {
            this.eQX.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f2) {
        if (!this.eRo) {
            this.mStatus = 0;
            return;
        }
        aRU();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eRE == 0) {
            if (f2 > 0.0f && this.eRD < this.eRy) {
                this.eRD++;
            }
            if (f2 < 0.0f && this.eRD > 0) {
                this.eRD--;
            }
        }
        if (this.mProgress > 0) {
            this.eRw.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.eRw.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eRD, 0);
        this.eRv.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eRz += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eRA = 1;
            } else {
                this.eRz += 1000;
                this.eRA = 2;
            }
            if (this.eRz < 0) {
                this.eRz = 0;
            } else if (this.eRz > this.bvp.getDuration()) {
                this.eRz = this.bvp.getDuration();
            }
        }
        aRU();
        String rI = this.eQZ.rI(this.eRz);
        if (f2 > 0.0f) {
            this.eRx.setImageResource(d.f.icon_kuaitui);
        } else {
            this.eRx.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(rI)) {
            this.eRu.setText(new StringBuilder().append(rI).append("/").append(this.eQZ.rI(this.bvp.getDuration())));
        }
        this.eQZ.setCurrentDuration(this.eRz, z ? false : true);
        this.eRg.setVisibility(8);
        this.geu.setVisibility(0);
        bjS();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.bdb = str;
        this.aWq = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        int i2 = 100;
        if (this.bvp != null && this.cyE != null) {
            if (this.geV) {
                this.bvp.start();
                this.geV = false;
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRI);
            com.baidu.adp.lib.g.e.in().postDelayed(this.eRI, 20L);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRK);
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.geZ);
            if (this.bvp.bku()) {
                this.avR = 1;
                this.bvp.setRecoveryState(1);
            }
            if (this.cyE != null && this.eQZ != null) {
                this.mStartPosition = x.bkW().se(this.bdb);
                this.eQZ.T(this.mStartPosition, this.cyE.getDuration());
                if (this.mStartPosition != 0) {
                    if (this.bvp != null) {
                        this.bvp.rH(this.mStartPosition);
                    } else {
                        this.cyE.seekTo(this.mStartPosition);
                    }
                    if (!this.geU) {
                        this.eQZ.showProgress();
                    }
                    this.geP = true;
                }
                if (this.mStartPosition > 100 && this.cyE.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.ges = i2;
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gew.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mContext.getPageActivity());
                this.gew.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.gew.setBackgroundResource(d.f.bg_video_shadow);
            }
            this.gew.setLayoutParams(layoutParams);
        }
    }

    public void bgp() {
        if (!com.baidu.adp.lib.util.j.jE()) {
            com.baidu.adp.lib.util.l.F(this.mContext.getPageActivity(), this.mContext.getString(d.j.neterror));
        } else if (this.bvp.isPlaying()) {
            pausePlay();
            if (this.geM != null) {
                this.geM.onPause();
            }
        } else if (this.eRo) {
            aSg();
            if (this.fND != null) {
                this.fND.awn();
            }
        } else {
            bjV();
        }
    }

    public void aRX() {
        this.eRG = true;
        if (this.bKl != null) {
            this.bKl.aRX();
        }
    }

    public boolean bjP() {
        return this.cyE != null && this.cyE.getVideoHeight() > this.cyE.getVideoWidth();
    }

    public boolean rE(int i2) {
        switch (i2) {
            case 4:
                if (this.dfg) {
                    if (bjP()) {
                        lp(false);
                        bjR();
                    } else {
                        aRX();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eRy <= 0 || this.eRv == null) {
                    return false;
                }
                this.eRD = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eRD * 100.0d) / this.eRy);
                this.eRv.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bvp;
    }

    public VideoListMediaControllerView aRY() {
        return this.eQZ;
    }

    public void show() {
        this.eQX.setVisibility(0);
    }

    public void aSc() {
        if (this.eRi != null) {
            ViewGroup.LayoutParams layoutParams = this.eRi.getLayoutParams();
            this.eRc = (FrameLayout.LayoutParams) this.eQX.getLayoutParams();
            this.eRc.width = layoutParams.width;
            this.eRc.height = layoutParams.height;
            this.eRc.topMargin = 0;
            this.eQX.setLayoutParams(this.eRc);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eRG) {
            if (this.dfg) {
                TiebaStatic.log(new an("c11712"));
            } else {
                TiebaStatic.log(new an("c11711"));
            }
        } else {
            this.eRG = false;
        }
        if (configuration.orientation == 2) {
            bjQ();
        } else {
            bjR();
        }
        if (this.bvp.isPlaying()) {
            aSl();
        }
        bjS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjQ() {
        this.dfg = true;
        if (bjP()) {
            this.eQX.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.eQX.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.mContext, true);
        this.eRg.setVisibility(0);
        this.cBr.setVisibility(0);
        this.eRm.setVisibility(0);
        this.eRn.setVisibility(0);
        this.eRb.setVisibility(8);
        if (this.geC) {
            this.bcX.startLoading();
            this.eRj.setVisibility(0);
        } else {
            this.bcX.bkS();
            this.eRj.setVisibility(8);
        }
        if (this.geE != null) {
            this.geE.awi();
        }
        this.eRf.setImageResource(d.f.icon_video_window);
        pi(this.eRC);
        aRW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjR() {
        this.dfg = false;
        if (this.eRc != null) {
            this.eQX.setLayoutParams(this.eRc);
        }
        a((TbPageContext) this.mContext, false);
        this.cBr.setVisibility(8);
        this.eRb.setVisibility(0);
        if (this.geC) {
            this.bcX.startLoading();
            this.eRj.setVisibility(0);
        } else {
            this.bcX.bkS();
            this.eRj.setVisibility(8);
        }
        if (this.geE != null) {
            this.geE.awj();
        }
        if (this.avR == 3 && this.geF != null) {
            this.geF.fU(false);
        } else if (!this.eRo && this.eRg != null) {
            this.eRg.clearAnimation();
            this.eRg.setVisibility(4);
            this.geu.setVisibility(0);
            if (this.geF != null) {
                this.geF.awm();
            }
        }
        aRT();
        this.eRf.setImageResource(d.f.icon_video_fullscreen);
        if (this.eQZ != null && (this.eQZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQZ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.tbds24);
            layoutParams.rightMargin = 0;
            this.eQZ.setLayoutParams(layoutParams);
        }
        this.eQX.setSystemUiVisibility(0);
        bjO();
    }

    public void bjS() {
        if (this.bvp != null) {
            int ah = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
            if (this.dfg) {
                ah = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
            }
            this.geu.setMax(ah);
            int duration = this.bvp.getDuration();
            if (duration > 0) {
                if (this.gex.getVisibility() == 0) {
                    this.geu.setProgress(this.geu.getMax());
                } else {
                    this.geu.setProgress((int) ((this.bvp.getCurrentPosition() * this.geu.getMax()) / duration));
                }
            }
        }
    }

    private void pi(int i2) {
        if (this.eQZ != null && (this.eQZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQZ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eQZ.setLayoutParams(layoutParams);
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

    public boolean aSe() {
        return !this.dfg;
    }

    public void a(g.f fVar) {
        this.eRk = fVar;
    }

    public void a(g.a aVar) {
        this.geA = aVar;
    }

    public void a(g.b bVar) {
        this.geB = bVar;
    }

    public void setPauseState() {
        this.eRe.setImageResource(d.f.icon_video_play);
        this.bcX.bkS();
        this.cBs.setVisibility(0);
        this.gey.setVisibility(8);
        this.gex.setVisibility(8);
        this.gez.setVisibility(8);
        this.avR = 2;
        this.bvp.setRecoveryState(2);
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bvp != null) {
            this.bvp.setPbLoadingTime(currentTimeMillis);
        }
        bS(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z, String str, String str2) {
        if (this.geQ) {
            bT(str, str2);
        } else {
            bS(str, str2);
        }
        if (dVar != null) {
            dVar.lu(z);
        }
    }

    public void bS(String str, String str2) {
        bjW();
        this.geV = true;
        this.avR = 0;
        this.bvp.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bvp.setVideoPath(str, str2);
        this.bcX.startLoading();
        this.cyG.aVY();
        this.eRj.setVisibility(0);
        this.cBs.setVisibility(8);
        this.eRe.setImageResource(d.f.icon_video_suspend_n);
        this.gey.setVisibility(8);
        this.gex.setVisibility(8);
        this.gez.setVisibility(8);
        this.cBw.setVisibility(8);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRK);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eRK, 60000L);
    }

    public void bT(String str, String str2) {
        bjW();
        this.geV = true;
        this.avR = 0;
        this.bvp.setRecoveryState(0);
        this.bcX.startLoading();
        this.eRj.setVisibility(0);
        this.cBs.setVisibility(8);
        this.eRe.setImageResource(d.f.icon_video_suspend_n);
        this.gey.setVisibility(8);
        this.gex.setVisibility(8);
        this.gez.setVisibility(8);
        this.cBw.setVisibility(8);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRK);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eRK, 60000L);
    }

    public void aSg() {
        this.avR = 1;
        this.bvp.setRecoveryState(1);
        this.bvp.start();
        this.eRe.setImageResource(d.f.icon_video_suspend_n);
        this.eRj.setVisibility(8);
        this.eRa.setVisibility(8);
        this.bcX.bkS();
        this.eQZ.showProgress();
        this.cBs.setVisibility(8);
        this.gey.setVisibility(8);
        this.gex.setVisibility(8);
        this.gez.setVisibility(8);
        bka();
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.jE() && this.geT && !StringUtils.isNull(this.bdb) && !StringUtils.isNull(this.aWq)) {
            this.geT = false;
            this.geU = true;
            bS(this.bdb, this.aWq);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bvp != null) {
            this.bvp.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bvp.isPlaying() && this.geO) {
            bjT();
        }
        bjZ();
        this.bvp.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bvp.isPlaying() && this.geO) {
            bjT();
        }
        this.avR = 5;
        this.bvp.setRecoveryState(5);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRI);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRK);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.geZ);
        this.bvp.stopPlayback();
        this.eRo = false;
        this.geV = false;
        this.mStartPosition = 0;
        aFd();
    }

    public void bjT() {
        x.bkW().aD(this.bdb, this.bvp.getCurrentPosition());
    }

    public void lq(boolean z) {
        this.geO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        if (this.eRg != null) {
            this.eRa.setVisibility(0);
            this.cBs.setVisibility(0);
            this.gey.setVisibility(8);
            this.gex.setVisibility(8);
            this.gez.setVisibility(8);
            this.bcX.bkS();
            this.eRe.setImageResource(d.f.icon_video_play);
            this.eRg.setVisibility(4);
            this.geu.setVisibility(8);
            this.cBw.setVisibility(8);
            this.eQZ.Rg();
            this.eRj.setVisibility(z ? 0 : 8);
        }
    }

    public void aFd() {
        lr(true);
    }

    public boolean bjU() {
        if (this.bvp == null) {
            return false;
        }
        return this.bvp.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bvp == null) {
            return 0;
        }
        return this.bvp.getCurrentPosition();
    }

    public void a(j jVar) {
        this.geI = jVar;
    }

    public void a(i iVar) {
        this.geH = iVar;
    }

    public void a(h hVar) {
        this.fND = hVar;
    }

    public void a(f fVar) {
        this.geM = fVar;
    }

    public void a(g gVar) {
        this.geG = gVar;
    }

    public void rG(String str) {
        this.fNf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjV() {
        a(this.bdb, this.aWq, (d) null, new Object[0]);
    }

    public void b(InterfaceC0218c interfaceC0218c) {
        this.geF = interfaceC0218c;
    }

    public void a(final String str, final String str2, final d dVar, Object... objArr) {
        bjW();
        if (com.baidu.adp.lib.util.j.jG() && !com.baidu.tieba.video.g.bAi().bAj()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.geQ = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.geL != null) {
                    this.geL.fT(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
                aVar.a(d.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bjX();
                        aVar2.dismiss();
                        c.this.a(dVar, false, str, str2);
                    }
                });
                aVar.b(d.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xf();
                return;
            } else if (this.geL != null) {
                this.geL.fT(true);
                return;
            } else {
                if (!this.get) {
                    this.get = true;
                    com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.play_video_mobile_tip2);
                }
                a(dVar, true, str, str2);
                return;
            }
        }
        a(dVar, true, str, str2);
        if (this.geK != null) {
            this.geK.awk();
        }
    }

    private void bjW() {
        if (com.baidu.adp.lib.util.j.jG()) {
            com.baidu.tieba.video.g.bAi().cl(this.mContext.getPageActivity());
        }
    }

    public void bjX() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.eRj.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRO);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRI);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRK);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.geY);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.geZ);
        this.bKl.stop();
        this.eRF.unregister(this.mContext.getPageActivity());
    }

    public void sa(String str) {
        this.eRn.setText(str);
    }

    public boolean aSh() {
        return this.eRo;
    }

    public void aSi() {
        if (this.eRg != null) {
            aSk();
            this.eRg.setVisibility(0);
            this.gew.setVisibility(0);
            if (this.geF != null) {
                this.geF.fU(true);
            }
            this.geu.setVisibility(8);
            this.dre.setAnimationListener(this.eRM);
            this.eRg.startAnimation(this.dre);
            this.eRq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjY() {
        if (this.eRg != null) {
            if (this.eRg.getVisibility() == 0) {
                aSk();
                this.eRg.setVisibility(8);
                this.geu.setVisibility(0);
                if (this.geF != null) {
                    this.geF.awm();
                    return;
                }
                return;
            }
            aSl();
        }
    }

    public void aSj() {
        if (this.eRg != null) {
            aSk();
            this.eRg.setVisibility(0);
            this.gew.setVisibility(0);
            if (this.geF != null) {
                this.geF.fU(false);
            }
            this.geu.setVisibility(8);
            this.drf.setAnimationListener(this.eRN);
            this.eRg.startAnimation(this.drf);
        }
    }

    public void bjZ() {
        if (this.eRg != null) {
            aSk();
            this.eRg.setVisibility(0);
            this.gew.setVisibility(0);
            this.geu.setVisibility(8);
            if (this.geF != null) {
                this.geF.fU(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (this.eRg != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRO);
            this.drf.setAnimationListener(null);
            this.dre.setAnimationListener(null);
            this.eRg.clearAnimation();
            this.eRq = false;
        }
    }

    public void aSl() {
        aSj();
        bka();
    }

    private void bka() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eRO);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eRO, 3000L);
    }

    public void a(b bVar) {
        this.geE = bVar;
    }

    public void pk(int i2) {
        if (this.bvp.getDuration() - i2 <= 3000) {
            aSk();
            if (this.eRg != null) {
                this.eRg.setVisibility(0);
                this.gew.setVisibility(0);
                this.geu.setVisibility(8);
                if (this.geF != null) {
                    this.geF.fU(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void N(boolean z, boolean z2) {
        int i2 = 8;
        if (this.bKl != null) {
            if (this.eRf != null || this.gev != null) {
                this.eRf.setVisibility((z || !z2) ? 0 : 8);
                View view = this.gev;
                if (z || !z2) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
            if (!z && z2 && this.eQZ != null && (this.eQZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eQZ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.tbds52);
                this.eQZ.setLayoutParams(layoutParams);
            }
            this.bKl.lw(z);
        }
    }

    public int bM(Context context) {
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
        return this.avR;
    }

    public void a(l lVar) {
        this.geJ = lVar;
    }

    public void a(k kVar) {
        this.geK = kVar;
    }

    public void a(e eVar) {
        this.geL = eVar;
    }

    public void ls(boolean z) {
        this.geS = z;
    }

    public boolean bkb() {
        return this.geC;
    }

    public void lt(boolean z) {
        this.geC = z;
    }

    public void rF(int i2) {
        this.geW = i2;
    }

    public void bkc() {
        com.baidu.adp.lib.util.l.a(this.mContext.getPageActivity(), this.eRe, 40, 40, 40, 40);
    }

    public List<String> getMediaIDs() {
        if (this.bvp != null) {
            return this.bvp.getMediaIDs();
        }
        return null;
    }

    public String getMediaId() {
        return this.bvp != null ? this.bvp.getMediaId() : "";
    }
}
