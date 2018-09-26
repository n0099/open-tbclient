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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.view.SwitchImageView;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int eYU;
    private String aZG;
    private String avN;
    private QuickVideoView bBg;
    private o bPZ;
    private w bgt;
    private com.baidu.tieba.play.g cEr;
    private com.baidu.tieba.j.k cEt;
    private String cHI;
    private View cHg;
    private View cHl;
    private Animation dxp;
    private Animation dxq;
    private g.f eYA;
    private ImageView eYC;
    private TextView eYD;
    private View eYI;
    private View eYJ;
    private TextView eYK;
    private SeekBar eYL;
    private ImageView eYM;
    private ImageView eYN;
    private int eYO;
    private int eYS;
    private int eYT;
    private CallStateReceiver eYV;
    public View eYn;
    private VideoListMediaControllerView eYp;
    private View eYq;
    private FrameLayout eYr;
    protected FrameLayout.LayoutParams eYs;
    private ImageView eYv;
    private View eYw;
    private View eYy;
    private TbImageView eYz;
    private i fVs;
    private ProgressBar glI;
    private View glJ;
    private SwitchImageView glK;
    private TextView glL;
    private TextView glM;
    private TextView glN;
    private g.a glO;
    private g.b glP;
    private View.OnClickListener glS;
    private InterfaceC0224c glT;
    private d glU;
    private h glV;
    private j glW;
    private k glX;
    private m glY;
    private a glZ;
    private l gma;
    private f gmb;
    private g gmc;
    private TextView gmh;
    private boolean gmj;
    private boolean gmk;
    private boolean gml;
    private int gmm;
    private boolean gmn;
    private boolean gmo;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private int cEz = 100;
    private boolean glH = false;
    protected boolean dkW = false;
    private boolean eYE = false;
    private boolean glQ = false;
    private boolean glR = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int eYP = 0;
    private int eYQ = 0;
    private boolean eYW = false;
    private boolean gmd = true;
    private boolean gme = true;
    private boolean gmf = false;
    private boolean gmg = false;
    private String fUS = null;
    private int currentState = -1;
    private boolean gmi = false;
    private g.f bpy = new g.f() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            c.this.cEr = gVar;
            c.this.cEt.aYj();
            c.this.aku();
        }
    };
    private g.e bpA = new g.e() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.tieba.play.g.e
        public boolean onInfo(com.baidu.tieba.play.g gVar, int i2, int i3) {
            if (i2 == 3) {
                c.this.bmn();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a cED = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.aku();
        }
    };
    private Runnable eYY = new Runnable() { // from class: com.baidu.tieba.play.c.18
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(c.this.eYY);
            if (!c.this.eYE) {
                if (c.this.bBg.getCurrentPosition() > c.this.cEz) {
                    c.this.bmn();
                } else {
                    com.baidu.adp.lib.g.e.jt().postDelayed(c.this.eYY, 20L);
                }
            }
        }
    };
    private g.a bpx = new g.a() { // from class: com.baidu.tieba.play.c.19
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            if (c.this.bBg != null) {
                int duration = c.this.bBg.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.eYE = false;
                    c.this.gml = false;
                    c.this.mStartPosition = 0;
                    c.this.aUe();
                    c.this.eYq.setVisibility(0);
                    c.this.glI.setProgress(c.this.glI.getMax());
                    x.bnz().remove(c.this.avN);
                    c.this.cEz = 100;
                    if (c.this.glO != null) {
                        c.this.glO.onCompletion(gVar);
                    }
                    c.this.currentState = 3;
                    c.this.bBg.setRecoveryState(3);
                    if (duration > 150000) {
                        c.this.lO(false);
                        c.this.lP(true);
                    } else {
                        c.this.bmC();
                        c.this.glL.setVisibility(0);
                    }
                    if (!c.this.dkW && duration <= 150000) {
                        if (!c.this.gmi) {
                            if (c.this.glW != null) {
                                c.this.glW.ll(true);
                            }
                            c.this.cb(c.this.avN, c.this.aZG);
                            return;
                        }
                        c.this.currentState = 5;
                        c.this.bBg.setRecoveryState(5);
                        c.this.bBg.getPlayer().pause();
                        c.this.bBg.getPlayer().seekTo(0);
                    }
                }
            }
        }
    };
    private g.b eYZ = new g.b() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i2, int i3) {
            c.this.cHl.setVisibility(0);
            c.this.bgt.bnv();
            c.this.currentState = 4;
            c.this.bBg.setRecoveryState(4);
            if (c.this.glP != null) {
                c.this.glP.onError(gVar, i2, i3);
            }
            if (!com.baidu.adp.lib.util.j.kK()) {
                c.this.gmj = true;
            }
            c.this.gml = false;
            return true;
        }
    };
    private Runnable eZa = new Runnable() { // from class: com.baidu.tieba.play.c.21
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bBg == null || !c.this.bBg.isPlaying()) {
                c.this.cHl.setVisibility(0);
                c.this.bgt.bnv();
            }
        }
    };
    private g.InterfaceC0225g bpB = new g.InterfaceC0225g() { // from class: com.baidu.tieba.play.c.22
        @Override // com.baidu.tieba.play.g.InterfaceC0225g
        public void b(com.baidu.tieba.play.g gVar) {
            if (c.this.gmf) {
                com.baidu.adp.lib.g.e.jt().postDelayed(c.this.gmp, 200L);
            }
        }
    };
    private Runnable gmp = new Runnable() { // from class: com.baidu.tieba.play.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bBg == null || !c.this.gmf) {
                com.baidu.adp.lib.g.e.jt().postDelayed(c.this.eYY, 200L);
                c.this.gmf = false;
            } else if (c.this.mStartPosition != c.this.bBg.getCurrentPosition()) {
                c.this.gmf = false;
                com.baidu.adp.lib.g.e.jt().postDelayed(c.this.eYY, 20L);
            } else {
                com.baidu.adp.lib.g.e.jt().postDelayed(c.this.gmp, 200L);
            }
        }
    };
    private QuickVideoView.b bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.3
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.eYE = false;
            if (c.this.glR) {
                com.baidu.adp.lib.g.e.jt().postDelayed(c.this.gmq, 300L);
            }
            com.baidu.adp.lib.g.e.jt().removeCallbacks(c.this.eYY);
            com.baidu.adp.lib.g.e.jt().removeCallbacks(c.this.eZa);
        }
    };
    private Runnable gmq = new Runnable() { // from class: com.baidu.tieba.play.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.gml = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = false;
            if (view.getId() == c.this.cHl.getId()) {
                c.this.bmv();
            } else if (view.getId() != c.this.glK.getId()) {
                if (view.getId() == c.this.glM.getId()) {
                    if (c.this.glV != null) {
                        c.this.glV.biZ();
                    }
                } else if (view.getId() == c.this.glL.getId()) {
                    if (c.this.glW != null) {
                        c.this.glW.ll(false);
                    }
                    c.this.cb(c.this.avN, c.this.aZG);
                } else if (view.getId() == c.this.eYv.getId()) {
                    int i2 = c.this.glR ? 1 : 2;
                    if (c.this.dkW) {
                        TiebaStatic.log(new am("c11714"));
                        TiebaStatic.log(new am("c13262").al("tid", c.this.aZG).al(ImageViewerConfig.FORUM_ID, c.this.cHI).w("obj_type", i2).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                    } else {
                        TiebaStatic.log(new am("c11710"));
                        TiebaStatic.log(new am("c13262").al("tid", c.this.aZG).al(ImageViewerConfig.FORUM_ID, c.this.cHI).w("obj_type", i2).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                    }
                    if (c.this.gma != null) {
                        c.this.gma.ayu();
                    }
                    if (c.this.bmo()) {
                        if (c.this.dkW) {
                            c.this.bmq();
                        } else {
                            c.this.bmp();
                        }
                        c.this.lL(c.this.dkW);
                        return;
                    }
                    c.this.aUi();
                } else if (view.getId() != c.this.eYC.getId()) {
                    if (c.this.glS != null) {
                        c.this.glS.onClick(view);
                    }
                } else {
                    TiebaStatic.log(new am("c11713"));
                    if (c.this.gma != null) {
                        c.this.gma.ayu();
                    }
                    if (c.this.bmo()) {
                        c.this.bmq();
                        c.this.lL(false);
                        return;
                    }
                    c.this.aUi();
                }
            } else {
                TiebaStatic.log(new am("c13255"));
                c.this.biN();
                c.this.bmE();
                if (c.this.currentState != 1 && c.this.currentState != 0) {
                    c.this.bmA();
                    c.this.bmB();
                } else {
                    c.this.aUw();
                }
                if (c.this.glZ != null) {
                    a aVar = c.this.glZ;
                    if (c.this.currentState == 1 || c.this.currentState == 0) {
                        z = true;
                    }
                    aVar.gP(z);
                }
            }
        }
    };
    private Animation.AnimationListener eZc = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.8
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
    private Animation.AnimationListener eZd = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Runnable eZe = new Runnable() { // from class: com.baidu.tieba.play.c.10
        @Override // java.lang.Runnable
        public void run() {
            c.this.aUt();
        }
    };
    private CustomMessageListener eZf = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.play.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private VideoControllerView.b faZ = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.13
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void gZ(int i2) {
            int duration;
            if (c.this.bBg != null && (duration = c.this.bBg.getDuration()) > 0 && c.this.glI != null) {
                c.this.glI.setProgress((int) ((i2 * c.this.eYn.getWidth()) / duration));
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener btK = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.14
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new am("c13256"));
            c.this.bmA();
            c.this.lP(false);
            if (c.this.glZ != null) {
                c.this.glZ.gP(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.aUj() != null) {
                c.this.setStartPosition(c.this.aUj().getSeekPosition());
                if (!c.this.aUs()) {
                    c.this.bmv();
                } else {
                    c.this.aUr();
                    if (c.this.fVs != null) {
                        c.this.fVs.ayw();
                    }
                }
            }
            c.this.lP(true);
            c.this.bmz();
            if (c.this.glZ != null) {
                c.this.glZ.gP(true);
            }
        }
    };
    private QuickVideoView.a gmr = new QuickVideoView.a() { // from class: com.baidu.tieba.play.c.15
        @Override // com.baidu.tieba.play.QuickVideoView.a
        public void bmG() {
            if (!c.this.gmi) {
                c.this.bgt.startLoading();
                c.this.eYz.setVisibility(0);
                c.this.glK.setVisibility(8);
                c.this.glM.setVisibility(8);
                c.this.glL.setVisibility(8);
                c.this.glN.setVisibility(8);
                c.this.cHl.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(c.this.eZa);
                com.baidu.adp.lib.g.e.jt().postDelayed(c.this.eZa, 60000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void gP(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0224c {
        void ayr();

        void ays();
    }

    /* loaded from: classes.dex */
    public interface d {
        void ayv();

        void gr(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void lT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void gq(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void biZ();
    }

    /* loaded from: classes.dex */
    public interface i {
        void ayw();
    }

    /* loaded from: classes.dex */
    public interface j {
        void ll(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void ayt();

        void ayu();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean biX();

        boolean biY();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.eYS = 0;
        this.gmn = true;
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            this.eYn = q(tbPageContext);
            this.mRootView = view;
            this.gmn = z;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.eYn);
            }
            this.eYy = view;
            this.eYn.setOnClickListener(this.mOnClickListener);
            this.bBg = (QuickVideoView) this.eYn.findViewById(e.g.videoView);
            this.bgt = new w((ViewGroup) this.eYn.findViewById(e.g.auto_video_loading_container));
            this.bgt.setLoadingAnimationListener(this.cED);
            this.eYp = (VideoListMediaControllerView) this.eYn.findViewById(e.g.media_controller);
            this.eYp.setPlayer(this.bBg);
            this.glI = (ProgressBar) this.eYn.findViewById(e.g.pgrBottomProgress);
            this.glI.setMax(com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()));
            this.glI.setProgress(0);
            this.eYp.setOnSeekBarChangeListener(this.btK);
            this.eYp.setOnProgressUpdatedListener(this.faZ);
            this.eYq = this.eYn.findViewById(e.g.black_mask);
            this.cHl = this.eYn.findViewById(e.g.layout_error);
            this.cHl.setOnClickListener(this.mOnClickListener);
            this.gmh = (TextView) this.eYn.findViewById(e.g.auto_video_error_tips);
            this.eYr = (FrameLayout) this.eYn.findViewById(e.g.danmu_container);
            this.eYv = (ImageView) this.eYn.findViewById(e.g.img_full_screen);
            this.eYv.setOnClickListener(this.mOnClickListener);
            this.eYw = this.eYn.findViewById(e.g.layout_media_controller);
            this.glJ = this.eYn.findViewById(e.g.time_show_controller);
            this.bBg.setPlayerReuseEnable(true);
            this.bBg.setContinuePlayEnable(true);
            this.bBg.setOnPreparedListener(this.bpy);
            this.bBg.setOnCompletionListener(this.bpx);
            this.bBg.setOnErrorListener(this.eYZ);
            this.bBg.setOnSeekCompleteListener(this.bpB);
            this.bBg.setOnSurfaceDestroyedListener(this.bgC);
            this.bBg.setOnRecoveryCallback(this.gmr);
            this.bBg.setOnOutInfoListener(this.bpA);
            this.glK = (SwitchImageView) this.eYn.findViewById(e.g.img_play_controller);
            this.glK.setStateImage(e.f.btn_card_play_video_n, e.f.btn_card_stop_video_n);
            this.glK.setState(0);
            this.glK.setOnClickListener(this.mOnClickListener);
            this.glL = (TextView) this.eYn.findViewById(e.g.txt_replay);
            this.glL.setOnClickListener(this.mOnClickListener);
            this.glM = (TextView) this.eYn.findViewById(e.g.txt_playnext);
            this.glM.setOnClickListener(this.mOnClickListener);
            this.glN = (TextView) this.eYn.findViewById(e.g.txt_next_video_title);
            this.eYz = (TbImageView) this.eYn.findViewById(e.g.video_thumbnail);
            this.eYz.setDefaultErrorResource(0);
            this.eYz.setDefaultBgResource(e.f.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity());
            this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
            this.eYC = (ImageView) this.eYn.findViewById(e.g.img_exit);
            this.eYC.setOnClickListener(this.mOnClickListener);
            this.eYD = (TextView) this.eYn.findViewById(e.g.video_title);
            this.cHg = this.eYn.findViewById(e.g.layout_title);
            this.cHg.setVisibility(8);
            this.dxp = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dxq = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new b());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.eYO = this.mAudioManager.getStreamMaxVolume(3);
            this.eYT = this.mAudioManager.getStreamVolume(3);
            eYU = 100 / this.eYO;
            this.eYn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.glX != null) {
                        c.this.glX.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.eYE) {
                            if (c.this.mStatus == 1 && c.this.eYQ != 0) {
                                c.this.b(c.this.eYQ == 1 ? 1000.0f : -1000.0f, false);
                                c.this.eYQ = 0;
                                c.this.eYP = 0;
                            }
                            if (!c.this.bBg.isPlaying()) {
                                c.this.glM.setVisibility(8);
                                c.this.glL.setVisibility(8);
                                c.this.glN.setVisibility(8);
                            }
                        }
                        c.this.aUe();
                        if (c.this.glX != null) {
                            c.this.glX.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bPZ = new o(this.mContext.getPageActivity());
            if (this.gmn) {
                this.bPZ.start();
            }
            this.eYS = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.ds16);
            this.eYV = new CallStateReceiver();
            this.eYV.register(this.mContext.getPageActivity());
            this.mContext.registerListener(this.eZf);
            bmm();
            this.cEt = new com.baidu.tieba.j.k();
        }
    }

    public void bmm() {
        if (this.gmd) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eYn.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.eYn.setSystemUiVisibility(0);
    }

    public void lK(boolean z) {
        this.gmd = z;
        bmm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUe() {
        this.mStatus = 0;
        if (this.eYI != null && this.eYI.getParent() != null && (this.eYI.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eYI.getParent()).removeView(this.eYI);
                this.eYI = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.eYJ != null && this.eYJ.getParent() != null && (this.eYJ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.eYJ.getParent()).removeView(this.eYJ);
                this.eYJ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aUf() {
        if (this.mStatus == 1) {
            if (this.eYI == null && this.eYn != null && (this.eYn instanceof ViewGroup)) {
                LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.float_video_window_jindu, (ViewGroup) this.eYn, true);
                this.eYI = this.eYn.findViewById(e.g.lay_jindu);
                this.eYK = (TextView) this.eYI.findViewById(e.g.show_time);
                this.eYN = (ImageView) this.eYI.findViewById(e.g.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.eYJ == null && this.eYn != null && (this.eYn instanceof ViewGroup)) {
            LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.float_video_window_voice, (ViewGroup) this.eYn, true);
            this.eYJ = this.eYn.findViewById(e.g.lay_voice);
            this.eYM = (ImageView) this.eYJ.findViewById(e.g.arrow_voice_icon);
            this.eYL = (SeekBar) this.eYJ.findViewById(e.g.show_voice_seekbar);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.glS = onClickListener;
    }

    /* loaded from: classes.dex */
    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.glX != null) {
                c.this.glX.onStart();
            }
            if (c.this.dkW && c.this.eYE) {
                if (c.this.mStatus == 1) {
                    c.this.bmC();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ar(f2);
                    }
                } else {
                    if (c.this.dkW) {
                        c.this.aUh();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eYP = c.this.bBg.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ar(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.gmo) {
                if (c.this.glY != null && c.this.glY.biX()) {
                    return true;
                }
                c.this.biN();
                c.this.bmE();
                if (c.this.bBg.isPlaying()) {
                    c.this.bmz();
                } else {
                    c.this.bmA();
                }
                if (c.this.glZ != null) {
                    c.this.glZ.gP(c.this.bBg.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.gmo) {
                if (c.this.eYE) {
                    if (c.this.glY == null || !c.this.glY.biY()) {
                        c.this.bmy();
                        if (c.this.bBg.isPlaying()) {
                            c.this.bmz();
                        } else {
                            c.this.bmA();
                        }
                        if (c.this.glZ != null) {
                            c.this.glZ.gP(c.this.bBg.isPlaying());
                        }
                    } else {
                        return true;
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eYn.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eYn.setSystemUiVisibility(4);
        } else {
            this.eYn.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f2) {
        if (!this.eYE) {
            this.mStatus = 0;
            return;
        }
        aUf();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eYU == 0) {
            if (f2 > 0.0f && this.eYT < this.eYO) {
                this.eYT++;
            }
            if (f2 < 0.0f && this.eYT > 0) {
                this.eYT--;
            }
        }
        if (this.mProgress > 0) {
            this.eYM.setImageResource(e.f.icon_shengyin_open);
        } else {
            this.eYM.setImageResource(e.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.eYT, 0);
        this.eYL.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.eYP += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.eYQ = 1;
            } else {
                this.eYP += 1000;
                this.eYQ = 2;
            }
            if (this.eYP < 0) {
                this.eYP = 0;
            } else if (this.eYP > this.bBg.getDuration()) {
                this.eYP = this.bBg.getDuration();
            }
        }
        aUf();
        String sf = this.eYp.sf(this.eYP);
        if (f2 > 0.0f) {
            this.eYN.setImageResource(e.f.icon_kuaitui);
        } else {
            this.eYN.setImageResource(e.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(sf)) {
            this.eYK.setText(new StringBuilder().append(sf).append("/").append(this.eYp.sf(this.bBg.getDuration())));
        }
        this.eYp.setCurrentDuration(this.eYP, z ? false : true);
        bmC();
        bmr();
    }

    protected View q(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str, String str2) {
        this.avN = str;
        this.aZG = str2;
    }

    public void setFid(String str) {
        this.cHI = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        int i2 = 100;
        if (this.bBg != null && this.cEr != null) {
            this.eYp.showProgress();
            this.mStartPosition = x.bnz().sP(this.avN);
            if (this.gml) {
                this.cEr.setVolume(1.0f, 1.0f);
                this.bBg.start();
                this.gml = false;
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
                com.baidu.adp.lib.g.e.jt().postDelayed(this.eYY, 20L);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmq);
                if (this.bBg.bmW()) {
                    this.currentState = 1;
                    this.bBg.setRecoveryState(1);
                }
                if (this.cEr != null && this.eYp != null) {
                    this.mStartPosition = x.bnz().sP(this.avN);
                    this.eYp.setPlayer(this.bBg);
                    if (this.mStartPosition != 0 && !this.cEr.isPlayerReuse()) {
                        this.gmf = true;
                    }
                    if (!this.gmk) {
                        this.eYp.showProgress();
                    }
                }
            }
            if (this.mStartPosition > 100 && this.cEr.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.cEz = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        if (!this.eYE) {
            this.eYE = true;
            this.eYq.setVisibility(8);
            this.cHl.setVisibility(8);
            this.bgt.bnu();
            this.eYz.setVisibility(8);
            bmD();
            if (bmF()) {
                this.cEt.a(this.aZG, -1L, this.bBg.getDuration() / 1000, "middle");
            }
            this.eYp.showProgress();
            this.glI.setVisibility(0);
            if (this.eYA != null) {
                this.eYA.onPrepared(this.bBg.getPlayer());
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
    public void lL(boolean z) {
        if (hasNavBar(this.mContext.getPageActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glJ.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mContext.getPageActivity());
                this.glJ.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.glJ.setBackgroundResource(e.f.bg_video_shadow);
            }
            this.glJ.setLayoutParams(layoutParams);
        }
    }

    public void biN() {
        if (!com.baidu.adp.lib.util.j.kK()) {
            com.baidu.adp.lib.util.l.S(this.mContext.getPageActivity(), this.mContext.getString(e.j.neterror));
        } else if (this.bBg.isPlaying()) {
            pausePlay();
            if (this.gmc != null) {
                this.gmc.onPause();
            }
        } else if (this.eYE) {
            aUr();
            if (this.fVs != null) {
                this.fVs.ayw();
            }
        } else {
            bmv();
        }
    }

    public void aUi() {
        this.eYW = true;
        if (this.bPZ != null) {
            this.bPZ.aUi();
        }
    }

    public boolean bmo() {
        return this.cEr != null && this.cEr.getVideoHeight() > this.cEr.getVideoWidth();
    }

    public boolean sb(int i2) {
        switch (i2) {
            case 4:
                if (this.dkW) {
                    if (bmo()) {
                        lL(false);
                        bmq();
                    } else {
                        aUi();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.eYO <= 0 || this.eYL == null) {
                    return false;
                }
                this.eYT = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.eYT * 100.0d) / this.eYO);
                this.eYL.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bBg;
    }

    public VideoListMediaControllerView aUj() {
        return this.eYp;
    }

    public void show() {
        this.eYn.setVisibility(0);
    }

    public void aUn() {
        if (this.eYy != null) {
            ViewGroup.LayoutParams layoutParams = this.eYy.getLayoutParams();
            this.eYs = (FrameLayout.LayoutParams) this.eYn.getLayoutParams();
            this.eYs.width = layoutParams.width;
            this.eYs.height = layoutParams.height;
            this.eYs.topMargin = 0;
            this.eYn.setLayoutParams(this.eYs);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.eYW) {
            if (this.dkW) {
                TiebaStatic.log(new am("c11712"));
            } else {
                TiebaStatic.log(new am("c11711"));
            }
        } else {
            this.eYW = false;
        }
        if (configuration.orientation == 2) {
            bmp();
        } else {
            bmq();
        }
        bmr();
        aUr();
        bmE();
        aUw();
        if (this.glZ != null) {
            this.glZ.gP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        this.dkW = true;
        if (bmo()) {
            this.eYn.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.mScreenHeight));
        } else {
            this.eYn.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
        }
        a((TbPageContext) this.mContext, true);
        this.cHg.setVisibility(0);
        this.eYC.setVisibility(0);
        this.eYD.setVisibility(0);
        this.eYr.setVisibility(8);
        this.bgt.bnv();
        this.eYz.setVisibility(8);
        if (this.glT != null) {
            this.glT.ayr();
        }
        this.eYv.setImageResource(e.f.icon_video_narrow_white);
        pM(this.eYS);
        aUh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        this.dkW = false;
        if (this.eYs != null) {
            this.eYn.setLayoutParams(this.eYs);
        }
        a((TbPageContext) this.mContext, false);
        this.cHg.setVisibility(8);
        this.eYr.setVisibility(0);
        this.bgt.bnv();
        this.eYz.setVisibility(8);
        if (this.glT != null) {
            this.glT.ays();
        }
        this.eYv.setImageResource(e.f.icon_video_enlarge_white);
        if (this.eYp != null && (this.eYp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYp.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.tbds24);
            layoutParams.rightMargin = 0;
            this.eYp.setLayoutParams(layoutParams);
        }
        this.eYn.setSystemUiVisibility(0);
        bmm();
    }

    public void bmr() {
        if (this.bBg != null) {
            int aO = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity());
            if (this.dkW) {
                aO = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
            }
            this.glI.setMax(aO);
            int duration = this.bBg.getDuration();
            if (duration > 0) {
                if (this.glL.getVisibility() == 0) {
                    this.glI.setProgress(this.glI.getMax());
                } else {
                    this.glI.setProgress((int) ((this.bBg.getCurrentPosition() * this.glI.getMax()) / duration));
                }
            }
        }
    }

    private void pM(int i2) {
        if (this.eYp != null && (this.eYp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYp.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.eYp.setLayoutParams(layoutParams);
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

    public boolean aUp() {
        return !this.dkW;
    }

    public void a(g.f fVar) {
        this.eYA = fVar;
    }

    public void a(g.a aVar) {
        this.glO = aVar;
    }

    public void a(g.b bVar) {
        this.glP = bVar;
    }

    public void b(String str, String str2, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (currentTimeMillis != 0 && currentTimeMillis < 86400000 && this.bBg != null) {
            this.bBg.setPbLoadingTime(currentTimeMillis);
        }
        cb(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.gmg) {
            cc(str, str2);
        } else {
            cb(str, str2);
        }
        if (eVar != null) {
            eVar.lT(z);
        }
    }

    public void ca(String str, String str2) {
    }

    public void cb(String str, String str2) {
        bmw();
        this.gml = true;
        this.currentState = 0;
        this.bBg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bBg.setVideoPath(str, str2);
        this.cEt.aYi();
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.eZa, 60000L);
        this.bgt.startLoading();
        lM(true);
    }

    public void cc(String str, String str2) {
        bmw();
        this.gml = true;
        this.currentState = 0;
        this.bBg.setRecoveryState(0);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.eZa, 60000L);
        this.bgt.startLoading();
        lM(true);
    }

    public void aUr() {
        int i2 = 100;
        if (this.bBg != null && this.eYp != null) {
            this.eYE = true;
            this.currentState = 1;
            this.bBg.setRecoveryState(1);
            this.bBg.start();
            if (this.cEr != null && this.eYp != null) {
                this.mStartPosition = x.bnz().sP(this.avN);
                if (this.mStartPosition != 0 && !this.cEr.isPlayerReuse()) {
                    this.gmf = true;
                }
                if (this.mStartPosition > 100 && this.cEr.getDuration() > this.mStartPosition) {
                    i2 = this.mStartPosition;
                }
                this.cEz = i2;
            } else {
                this.cEz = 100;
            }
            this.bgt.bnv();
            lM(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.kK() && this.gmj && !StringUtils.isNull(this.avN) && !StringUtils.isNull(this.aZG)) {
            this.gmj = false;
            this.gmk = true;
            cb(this.avN, this.aZG);
        }
    }

    private void lM(boolean z) {
        if (z) {
            this.eYz.setVisibility(0);
            bmC();
            this.glI.setProgress(0);
        } else {
            this.eYz.setVisibility(8);
        }
        this.eYp.showProgress();
        this.eYq.setVisibility(8);
        this.glM.setVisibility(8);
        this.glL.setVisibility(8);
        this.glN.setVisibility(8);
        this.cHl.setVisibility(8);
    }

    private void bms() {
        this.bgt.bnv();
        this.glM.setVisibility(8);
        this.glL.setVisibility(8);
        this.glN.setVisibility(8);
        bmE();
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bBg != null) {
            this.bBg.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        this.bBg.pause();
        this.currentState = 2;
        this.bBg.setRecoveryState(2);
        bms();
    }

    public void stopPlay() {
        this.currentState = 5;
        this.bBg.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmq);
        this.bBg.stopPlayback();
        this.eYE = false;
        this.gml = false;
        this.mStartPosition = 0;
        aHp();
    }

    public void bmt() {
        x.bnz().aI(this.avN, this.bBg.getCurrentPosition());
    }

    public void lN(boolean z) {
        this.gme = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (this.eYw != null) {
            this.eYq.setVisibility(0);
            this.glM.setVisibility(8);
            this.glL.setVisibility(8);
            this.glN.setVisibility(8);
            this.bgt.bnv();
            bmC();
            this.glI.setVisibility(8);
            this.cHl.setVisibility(8);
            this.eYp.SZ();
            this.eYz.setVisibility(z ? 0 : 8);
        }
    }

    public void aHp() {
        lO(true);
    }

    public boolean bmu() {
        if (this.bBg == null) {
            return false;
        }
        return this.bBg.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bBg == null) {
            return 0;
        }
        return this.bBg.getCurrentPosition();
    }

    public void a(k kVar) {
        this.glX = kVar;
    }

    public void a(j jVar) {
        this.glW = jVar;
    }

    public void a(i iVar) {
        this.fVs = iVar;
    }

    public void a(g gVar) {
        this.gmc = gVar;
    }

    public void a(h hVar) {
        this.glV = hVar;
    }

    public void sp(String str) {
        this.fUS = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmv() {
        a(this.avN, this.aZG, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.glU = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        bmw();
        if (com.baidu.adp.lib.util.j.kM() && !com.baidu.tieba.video.g.bCZ().bDa()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.gmg = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.gmb != null) {
                    this.gmb.gq(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dT(TbadkCoreApplication.getInst().getString(e.j.play_video_mobile_tip));
                aVar.a(e.j.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bmx();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(e.j.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).yl();
                return;
            } else if (this.gmb != null) {
                this.gmb.gq(true);
                return;
            } else {
                if (!this.glH) {
                    this.glH = true;
                    com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.gma != null) {
            this.gma.ayt();
        }
    }

    private void bmw() {
        if (com.baidu.adp.lib.util.j.kM()) {
            com.baidu.tieba.video.g.bCZ().cR(this.mContext.getPageActivity());
        }
    }

    public void bmx() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.eYz.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZe);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmp);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmq);
        this.bPZ.stop();
        this.eYV.unregister(this.mContext.getPageActivity());
    }

    public void sK(String str) {
        this.eYD.setText(str);
    }

    public boolean aUs() {
        return this.eYE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmy() {
        if (this.eYw != null) {
            if (this.glQ) {
                bmC();
            } else {
                bmB();
            }
        }
    }

    public void aUw() {
        bmB();
        bmz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmz() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZe);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.eZe, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmA() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZe);
    }

    public void bmB() {
        if (this.eYw != null && !this.glQ) {
            lP(true);
            aUv();
            this.eYw.setVisibility(0);
            this.glJ.setVisibility(0);
            this.glI.setVisibility(8);
            this.glQ = true;
            if (this.glU != null) {
                this.glU.gr(false);
            }
        }
    }

    public void aUt() {
        if (this.eYw != null && this.glQ) {
            lP(false);
            aUv();
            this.eYw.setVisibility(8);
            this.glJ.setVisibility(8);
            this.glI.setVisibility(0);
            this.dxp.setAnimationListener(this.eZc);
            this.eYw.startAnimation(this.dxp);
            this.glQ = false;
            if (this.glU != null) {
                this.glU.ayv();
            }
        }
    }

    public void bmC() {
        if (this.eYw != null && this.glQ) {
            this.dxq.cancel();
            this.dxp.cancel();
            lP(false);
            aUv();
            this.eYw.setVisibility(8);
            this.glJ.setVisibility(8);
            this.glI.setVisibility(0);
            this.glQ = false;
            if (this.glU != null) {
                this.glU.ayv();
            }
        }
    }

    private void aUv() {
        if (this.eYw != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZe);
            this.dxq.setAnimationListener(null);
            this.dxp.setAnimationListener(null);
            this.eYw.clearAnimation();
        }
    }

    private void bmD() {
        if (this.eYw != null) {
            this.dxq.setAnimationListener(null);
            this.dxp.setAnimationListener(null);
            this.eYw.clearAnimation();
        }
    }

    public void lP(boolean z) {
        bmE();
        if (z) {
            this.glK.setVisibility(0);
        } else {
            this.glK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmE() {
        if (this.currentState == 1 || this.currentState == 0) {
            this.glK.setState(1);
        } else {
            this.glK.setState(0);
        }
    }

    public void a(InterfaceC0224c interfaceC0224c) {
        this.glT = interfaceC0224c;
    }

    public void setStartPosition(int i2) {
        this.mStartPosition = i2;
    }

    public void P(boolean z, boolean z2) {
        if (this.bPZ != null) {
            if (this.eYv != null) {
                this.eYv.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.eYp != null && (this.eYp.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYp.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.tbds52);
                this.eYp.setLayoutParams(layoutParams);
            }
            this.bPZ.lV(z);
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
            return com.baidu.adp.lib.util.l.aQ(context);
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
        return this.currentState;
    }

    public void lQ(boolean z) {
        this.gmo = z;
    }

    public void a(m mVar) {
        this.glY = mVar;
    }

    public void a(a aVar) {
        this.glZ = aVar;
    }

    public void a(l lVar) {
        this.gma = lVar;
    }

    public void a(f fVar) {
        this.gmb = fVar;
    }

    public void lR(boolean z) {
        this.gmi = z;
    }

    public boolean bmF() {
        return this.glR;
    }

    public void lS(boolean z) {
        this.glR = z;
    }

    public void sc(int i2) {
        this.gmm = i2;
    }
}
