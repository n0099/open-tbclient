package com.baidu.tieba.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.reflect.Method;
import java.util.Date;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class c {
    private static int kon;
    private static CallStateReceiver koo;
    private TbImageView alI;
    private String alS;
    private Animation bKg;
    private View bwC;
    private TbPageContext<?> etO;
    protected TbCyberVideoView fTk;
    private String fkA;
    private com.baidu.tieba.play.m frm;
    private ImageView gvQ;
    protected View hIm;
    private Animation iwm;
    public View knH;
    private VideoListMediaControllerView knJ;
    private View knK;
    private FrameLayout knL;
    protected FrameLayout.LayoutParams knM;
    private ImageView knP;
    private View knQ;
    private View knS;
    private CyberPlayerManager.OnPreparedListener knU;
    private TextView knW;
    private View koa;
    private View kob;
    private TextView koc;
    private SeekBar kod;
    private ImageView koe;
    private ImageView kof;
    private int kog;
    private com.baidu.tieba.play.j kok;
    private int kom;
    private ProgressBar lPD;
    private View lPE;
    private SwitchImageView lPF;
    private TextView lPG;
    private TextView lPH;
    private TextView lPI;
    private int lPJ;
    private CyberPlayerManager.OnCompletionListener lPK;
    private CyberPlayerManager.OnErrorListener lPL;
    private View.OnClickListener lPO;
    protected InterfaceC0797c lPP;
    private d lPQ;
    private o lPS;
    private h lPT;
    private j lPU;
    private k lPV;
    private m lPW;
    private a lPX;
    private n lPY;
    private l lPZ;
    private f lQa;
    private g lQb;
    private TextView lQg;
    private boolean lQi;
    private boolean lQj;
    private boolean lQk;
    private int lQl;
    private boolean lQm;
    private boolean lQn;
    private p lsV;
    private i lth;
    protected Activity mActivity;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int aae = 100;
    private boolean lPC = false;
    protected boolean aao = false;
    private boolean aac = false;
    private boolean lPM = false;
    private boolean lPN = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int koh = 0;
    private int koi = 0;
    private long lPR = 60000;
    private int kol = 0;
    private boolean kop = false;
    private boolean lQc = true;
    private boolean lQd = true;
    private boolean lQe = false;
    private boolean lQf = false;
    private String lsH = null;
    private int currentState = -1;
    private boolean lQh = false;
    private boolean lQo = false;
    private boolean lQp = false;
    private CyberPlayerManager.OnPreparedListener dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.play.c.16
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (c.this.knJ != null && c.this.fTk != null && c.this.fTk.getDuration() > 0) {
                c.this.knJ.by(0, c.this.fTk.getDuration());
            }
            c.this.ciq();
            if (c.this.lPS != null) {
                c.this.lPS.onPrepared();
            }
        }
    };
    private CyberPlayerManager.OnInfoListener dZS = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.play.c.17
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 702 || i2 == 904) {
                c.this.rZ();
                return false;
            }
            return false;
        }
    };
    private VideoLoadingProgressView.a hFy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.play.c.18
        @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
        public void onAnimationEnd() {
            c.this.ciq();
        }
    };
    private Runnable aaj = new Runnable() { // from class: com.baidu.tieba.play.c.19
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aaj);
            if (c.this.alI.getVisibility() != 8) {
                if (c.this.fTk.getCurrentPosition() > c.this.aae) {
                    c.this.rZ();
                } else {
                    com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aaj, 20L);
                }
            }
        }
    };
    private CyberPlayerManager.OnCompletionListener dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.play.c.20
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (c.this.fTk != null) {
                int duration = c.this.fTk.getDuration();
                if (duration - c.this.getCurrentPosition() <= 5000) {
                    c.this.aac = false;
                    c.this.lQk = false;
                    c.this.mStartPosition = 0;
                    c.this.cTY();
                    c.this.knK.setVisibility(0);
                    c.this.lPD.setProgress(c.this.lPD.getMax());
                    c.this.aae = 100;
                    if (c.this.lPK != null) {
                        c.this.lPK.onCompletion();
                    }
                    c.this.currentState = 3;
                    if (duration > 150000) {
                        c.this.vN(false);
                        c.this.vO(true);
                    } else {
                        c.this.drd();
                        c.this.lPG.setVisibility(0);
                    }
                    if (!c.this.aao && duration <= 150000) {
                        if (!c.this.lQh) {
                            if (c.this.lPU != null) {
                                c.this.lPU.uR(true);
                            }
                            c.this.A(c.this.mVideoUrl, c.this.alS, false);
                        } else {
                            c.this.currentState = 5;
                            c.this.fTk.pause();
                            c.this.fTk.seekTo(0);
                        }
                    }
                    if (c.this.lPS != null) {
                        c.this.lPS.GM(c.this.lPD.getMax());
                        c.this.lPS.HL();
                    }
                }
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kor = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.play.c.21
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.hIm.setVisibility(0);
            c.this.frm.dru();
            c.this.currentState = 4;
            if (c.this.lPL != null) {
                c.this.lPL.onError(i2, i3, null);
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                c.this.lQi = true;
            }
            if (c.this.lPS != null) {
                c.this.lPS.dri();
            }
            c.this.lQk = false;
            return true;
        }
    };
    protected Runnable kos = new Runnable() { // from class: com.baidu.tieba.play.c.22
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fTk == null || !c.this.fTk.isPlaying()) {
                c.this.hIm.setVisibility(0);
                c.this.frm.dru();
                if (c.this.lPS != null) {
                    c.this.lPS.dri();
                }
            }
        }
    };
    private CyberPlayerManager.OnSeekCompleteListener dZU = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.play.c.2
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.lQe) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.lQq, 200L);
            }
        }
    };
    private Runnable lQq = new Runnable() { // from class: com.baidu.tieba.play.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.fTk == null || !c.this.lQe) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aaj, 200L);
                c.this.lQe = false;
            } else if (c.this.mStartPosition != c.this.fTk.getCurrentPosition()) {
                c.this.lQe = false;
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.aaj, 20L);
            } else {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.lQq, 200L);
            }
        }
    };
    private TbCyberVideoView.a frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.play.c.4
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.aac = false;
            if (c.this.lPN) {
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.lQr, 300L);
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.aaj);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(c.this.kos);
        }
    };
    private Runnable lQr = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.lQk = false;
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.lsV != null) {
                c.this.lsV.dkS();
            }
            if (view.getId() != c.this.hIm.getId()) {
                if (view.getId() != c.this.lPF.getId()) {
                    if (view.getId() == c.this.lPH.getId()) {
                        if (c.this.lPT != null) {
                            c.this.lPT.dkT();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.lPG.getId()) {
                        if (c.this.lPU != null) {
                            c.this.lPU.uR(false);
                        }
                        c.this.fR(c.this.mVideoUrl, c.this.alS);
                        return;
                    } else if (view.getId() == c.this.knP.getId()) {
                        int i2 = c.this.lPN ? 1 : 2;
                        if (c.this.aao) {
                            TiebaStatic.log(new aq("c11714"));
                            TiebaStatic.log(new aq("c13262").dK("tid", c.this.alS).dK("fid", c.this.fkA).aj("obj_type", i2).aj("obj_source", 2));
                        } else {
                            TiebaStatic.log(new aq("c11710"));
                            TiebaStatic.log(new aq("c13262").dK("tid", c.this.alS).dK("fid", c.this.fkA).aj("obj_type", i2).aj("obj_source", 1));
                        }
                        if (c.this.lPZ != null) {
                            c.this.lPZ.cvy();
                        }
                        if (c.this.dqO()) {
                            if (c.this.aao) {
                                c.this.dqR();
                            } else {
                                c.this.dqQ();
                            }
                            c.this.vK(c.this.aao);
                            return;
                        }
                        c.this.PP();
                        return;
                    } else if (view.getId() != c.this.gvQ.getId()) {
                        if (c.this.lPO != null) {
                            c.this.lPO.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new aq("c11713"));
                        if (c.this.lPZ != null) {
                            c.this.lPZ.cvy();
                        }
                        if (c.this.dqO()) {
                            c.this.dqR();
                            c.this.vK(false);
                            return;
                        }
                        c.this.PP();
                        return;
                    }
                }
                TiebaStatic.log(new aq("c13255"));
                c.this.dkL();
                c.this.drf();
                if (c.this.currentState != 1) {
                    c.this.drb();
                    c.this.drc();
                } else {
                    c.this.cUo();
                }
                if (c.this.lPX != null) {
                    c.this.lPX.pY(c.this.currentState == 1);
                    return;
                }
                return;
            }
            c.this.fTk.stopPlayback();
            c.this.aac = false;
            c.this.dqW();
        }
    };
    private Animation.AnimationListener kou = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.9
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
    private Animation.AnimationListener kov = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.10
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
    private Runnable kow = new Runnable() { // from class: com.baidu.tieba.play.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.cUl();
        }
    };
    private CustomMessageListener kox = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aLr();
            }
        }
    };
    private VideoControllerView.b kqq = new VideoControllerView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.VideoControllerView.b
        public void sU(int i2) {
            int duration;
            if (c.this.fTk != null && (duration = c.this.fTk.getDuration()) > 0 && c.this.lPD != null) {
                c.this.lPD.setProgress((int) ((i2 * c.this.knH.getWidth()) / duration));
                if (c.this.lPS != null) {
                    c.this.lPS.GM((c.this.fTk.getCurrentPosition() * 100) / duration);
                }
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fEG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new aq("c13256"));
            c.this.drb();
            c.this.vO(false);
            if (c.this.lPX != null) {
                c.this.lPX.pY(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.cUc() != null) {
                c.this.DD(c.this.cUc().getSeekPosition());
                if (!c.this.cUk()) {
                    c.this.dqW();
                } else {
                    c.this.aLs();
                    if (c.this.lth != null) {
                        c.this.lth.cvA();
                    }
                }
            }
            c.this.vO(true);
            c.this.dra();
            if (c.this.lPX != null) {
                c.this.lPX.pY(true);
            }
            if (c.this.lPY != null) {
                c.this.lPY.onStopTrackingTouch(seekBar);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pY(boolean z);
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0797c {
        void rI();

        void rJ();
    }

    /* loaded from: classes.dex */
    public interface d {
        void cvz();

        void pt(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void vS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void ps(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onPause();
    }

    /* loaded from: classes.dex */
    public interface h {
        void dkT();
    }

    /* loaded from: classes.dex */
    public interface i {
        void cvA();
    }

    /* loaded from: classes.dex */
    public interface j {
        void uR(boolean z);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface l {
        void cvx();

        void cvy();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean dkU();

        boolean dkV();
    }

    /* loaded from: classes.dex */
    public interface n {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface o {
        void GM(int i);

        void HL();

        void dri();

        void drj();

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes.dex */
    public interface p {
        void dkS();
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z) {
        this.lQm = true;
        if (tbPageContext != null) {
            this.etO = tbPageContext;
            this.mRootView = view;
            this.lQm = z;
            this.knS = view;
            this.mActivity = this.etO.getPageActivity();
            init();
        }
    }

    public void init() {
        this.knH = aw(this.mActivity);
        this.knH.setOnClickListener(this.mOnClickListener);
        if (this.mRootView instanceof FrameLayout) {
            ((FrameLayout) this.mRootView).addView(this.knH);
        }
        this.fTk = new TbCyberVideoView(this.mActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.knH).addView(this.fTk.getView(), 0);
        this.fTk.getView().setLayoutParams(layoutParams);
        this.frm = new com.baidu.tieba.play.m((ViewGroup) this.knH.findViewById(R.id.auto_video_loading_container));
        this.frm.setLoadingAnimationListener(this.hFy);
        this.knJ = (VideoListMediaControllerView) this.knH.findViewById(R.id.media_controller);
        this.knJ.setPlayer(this.fTk);
        this.lPD = (ProgressBar) this.knH.findViewById(R.id.pgrBottomProgress);
        this.lPD.setMax(com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity));
        this.lPD.setProgress(0);
        this.knJ.setOnSeekBarChangeListener(this.fEG);
        this.knJ.setOnProgressUpdatedListener(this.kqq);
        this.knK = this.knH.findViewById(R.id.black_mask);
        this.hIm = this.knH.findViewById(R.id.layout_error);
        this.hIm.setOnClickListener(this.mOnClickListener);
        this.lQg = (TextView) this.knH.findViewById(R.id.auto_video_error_tips);
        this.knL = (FrameLayout) this.knH.findViewById(R.id.danmu_container);
        this.knP = (ImageView) this.knH.findViewById(R.id.img_full_screen);
        this.knP.setOnClickListener(this.mOnClickListener);
        this.knQ = this.knH.findViewById(R.id.layout_media_controller);
        this.lPE = this.knH.findViewById(R.id.time_show_controller);
        this.fTk.setContinuePlayEnable(true);
        this.fTk.setOnPreparedListener(this.dZP);
        this.fTk.setOnCompletionListener(this.dZR);
        this.fTk.setOnErrorListener(this.kor);
        this.fTk.setOnSeekCompleteListener(this.dZU);
        this.fTk.setOnInfoListener(this.dZS);
        this.fTk.setOnSurfaceDestroyedListener(this.frv);
        this.lPF = (SwitchImageView) this.knH.findViewById(R.id.img_play_controller);
        this.lPF.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.lPF.setState(0);
        this.lPF.setOnClickListener(this.mOnClickListener);
        this.lPG = (TextView) this.knH.findViewById(R.id.txt_replay);
        this.lPG.setOnClickListener(this.mOnClickListener);
        this.lPH = (TextView) this.knH.findViewById(R.id.txt_playnext);
        this.lPH.setOnClickListener(this.mOnClickListener);
        this.lPI = (TextView) this.knH.findViewById(R.id.txt_next_video_title);
        this.alI = (TbImageView) this.knH.findViewById(R.id.video_thumbnail);
        this.alI.setDefaultErrorResource(0);
        this.alI.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
        this.mScreenHeight = getScreenHeight(this.mActivity);
        this.gvQ = (ImageView) this.knH.findViewById(R.id.img_exit);
        this.gvQ.setOnClickListener(this.mOnClickListener);
        this.knW = (TextView) this.knH.findViewById(R.id.video_title);
        this.bwC = this.knH.findViewById(R.id.layout_title);
        this.bwC.setVisibility(8);
        this.iwm = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.bKg = AnimationUtils.loadAnimation(this.mActivity, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mGestureDetector = new GestureDetector(this.mActivity, new b());
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.kog = this.mAudioManager.getStreamMaxVolume(3);
        this.kom = this.mAudioManager.getStreamVolume(3);
        kon = 100 / this.kog;
        this.knH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (c.this.lPV != null) {
                    c.this.lPV.onTouch(view, motionEvent);
                }
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.aac) {
                        if (c.this.mStatus == 1 && c.this.koi != 0) {
                            c.this.b(c.this.koi == 1 ? 1000.0f : -1000.0f, false);
                            c.this.koi = 0;
                            c.this.koh = 0;
                        }
                        if (!c.this.fTk.isPlaying()) {
                            c.this.lPH.setVisibility(8);
                            c.this.lPG.setVisibility(8);
                            c.this.lPI.setVisibility(8);
                        }
                    }
                    c.this.cTY();
                    if (c.this.lPV != null) {
                        c.this.lPV.onStop();
                    }
                }
                return onTouchEvent;
            }
        });
        this.kok = new com.baidu.tieba.play.j(this.mActivity);
        if (this.lQm) {
            this.kok.start();
        }
        this.kol = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.ds16);
        if (koo == null) {
            koo = new CallStateReceiver();
        }
        koo.register(this.mActivity);
        dqN();
        MessageManager.getInstance().registerListener(this.kox);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new com.baidu.tbadk.h.g() { // from class: com.baidu.tieba.play.c.12
            @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == c.this.mActivity) {
                    MessageManager.getInstance().unRegisterListener(c.this.kox);
                    TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    public void GI(int i2) {
        if (this.alI != null) {
            this.alI.setDefaultBgResource(i2);
        }
    }

    public void dqN() {
        if (this.lQc) {
            if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.mActivity) && !TbSingleton.getInstance().isCutoutScreen(this.mActivity)) {
                this.knH.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.knH.setSystemUiVisibility(0);
    }

    public void vI(boolean z) {
        this.lQc = z;
        dqN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTY() {
        this.mStatus = 0;
        if (this.koa != null && this.koa.getParent() != null && (this.koa.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.koa.getParent()).removeView(this.koa);
                this.koa = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.kob != null && this.kob.getParent() != null && (this.kob.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.kob.getParent()).removeView(this.kob);
                this.kob = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void cTZ() {
        if (this.mStatus == 1) {
            if (this.koa == null && this.knH != null && (this.knH instanceof ViewGroup)) {
                LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.knH, true);
                this.koa = this.knH.findViewById(R.id.lay_jindu);
                this.koc = (TextView) this.koa.findViewById(R.id.show_time);
                this.kof = (ImageView) this.koa.findViewById(R.id.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.kob == null && this.knH != null && (this.knH instanceof ViewGroup)) {
            LayoutInflater.from(this.mActivity).inflate(R.layout.float_video_window_voice, (ViewGroup) this.knH, true);
            this.kob = this.knH.findViewById(R.id.lay_voice);
            this.koe = (ImageView) this.kob.findViewById(R.id.arrow_voice_icon);
            this.kod = (SeekBar) this.kob.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void ab(View.OnClickListener onClickListener) {
        this.lPO = onClickListener;
    }

    public void vJ(boolean z) {
        this.lPN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.lPV != null) {
                c.this.lPV.onStart();
            }
            if (c.this.aao && c.this.aac) {
                if (c.this.mStatus == 1) {
                    c.this.drd();
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.b(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.aA(f2);
                    }
                } else {
                    if (c.this.aao) {
                        c.this.cUb();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.koh = c.this.fTk.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aA(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.lQn) {
                if (c.this.lPW != null && c.this.lPW.dkU()) {
                    return true;
                }
                c.this.dkL();
                c.this.drf();
                if (c.this.fTk.isPlaying()) {
                    c.this.dra();
                } else {
                    c.this.drb();
                }
                if (c.this.lPX != null) {
                    c.this.lPX.pY(c.this.fTk.isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.lQn) {
                if (c.this.aac) {
                    if (c.this.lPW != null && c.this.lPW.dkV()) {
                        return true;
                    }
                    c.this.dqZ();
                    if (c.this.fTk.isPlaying()) {
                        c.this.dra();
                    } else {
                        c.this.drb();
                    }
                    if (c.this.lPX != null) {
                        c.this.lPX.pY(c.this.fTk.isPlaying());
                    }
                } else {
                    c.this.dkL();
                    c.this.drf();
                    if (c.this.currentState != 1) {
                        c.this.drb();
                        c.this.drc();
                    } else {
                        c.this.cUo();
                    }
                    if (c.this.lPX != null) {
                        c.this.lPX.pY(c.this.currentState == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUb() {
        if (Build.VERSION.SDK_INT < 16) {
            this.knH.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.knH.setSystemUiVisibility(4);
        } else {
            this.knH.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(float f2) {
        if (!this.aac) {
            this.mStatus = 0;
            return;
        }
        if (kon == 0) {
            this.kog = this.mAudioManager.getStreamMaxVolume(3);
            kon = 100 / this.kog;
            if (kon == 0) {
                kon = 1;
            }
        }
        cTZ();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kon == 0) {
            if (f2 > 0.0f && this.kom < this.kog) {
                this.kom++;
            }
            if (f2 < 0.0f && this.kom > 0) {
                this.kom--;
            }
        }
        if (this.mProgress > 0) {
            this.koe.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.koe.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kom, 0);
        this.kod.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.koh -= 1000;
                this.koi = 1;
            } else {
                this.koh += 1000;
                this.koi = 2;
            }
            if (this.koh < 0) {
                this.koh = 0;
            } else if (this.koh > this.fTk.getDuration()) {
                this.koh = this.fTk.getDuration();
            }
        }
        cTZ();
        String GQ = this.knJ.GQ(this.koh);
        if (f2 > 0.0f) {
            this.kof.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kof.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(GQ)) {
            this.koc.setText(new StringBuilder().append(GQ).append("/").append(this.knJ.GQ(this.fTk.getDuration())));
        }
        this.knJ.setCurrentDuration(this.koh, z ? false : true);
        drd();
        dqS();
    }

    protected View aw(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void GJ(int i2) {
        this.lPJ = i2;
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alS = str2;
    }

    public void setFid(String str) {
        this.fkA = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciq() {
        int i2 = 100;
        if (this.fTk != null && this.knJ != null) {
            this.knJ.showProgress();
            this.mStartPosition = com.baidu.tieba.play.n.dry().PV(this.mVideoUrl);
            if (this.lQk) {
                this.fTk.setVolume(1.0f, 1.0f);
                this.fTk.start();
                this.lQk = false;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aaj);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.aaj, 20L);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kos);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQr);
                if (this.fTk.drF()) {
                    this.currentState = 1;
                    drd();
                }
                this.mStartPosition = com.baidu.tieba.play.n.dry().PV(this.mVideoUrl);
                this.knJ.setPlayer(this.fTk);
                if (this.mStartPosition != 0) {
                    this.lQe = true;
                }
                if (!this.lQj) {
                    this.knJ.showProgress();
                }
                if (!this.lPN && this.fTk.getDuration() <= 0) {
                    cUc().setVisibility(4);
                }
            }
            if (this.mStartPosition > 100 && this.fTk.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aae = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.alI.getVisibility() != 8 || !this.aac) {
            this.aac = true;
            this.knK.setVisibility(8);
            this.hIm.setVisibility(8);
            this.frm.drt();
            this.alI.setVisibility(8);
            dre();
            this.knJ.showProgress();
            this.lPD.setVisibility(0);
            if (this.knU != null) {
                this.knU.onPrepared();
            }
        }
    }

    private static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
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
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            return null;
        }
    }

    protected void vK(boolean z) {
        if (hasNavBar(this.mActivity) && (this.lPE.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lPE.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = getVirtualBarHeight(this.mActivity);
                this.lPE.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.lPE.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.lPE.setLayoutParams(layoutParams);
        }
    }

    public void dkL() {
        if (this.fTk.isPlaying()) {
            aLr();
            if (this.lQb != null) {
                this.lQb.onPause();
            }
            if (this.lPS != null) {
                this.lPS.onPaused();
            }
        } else if (this.aac) {
            aLs();
            if (this.lth != null) {
                this.lth.cvA();
            }
            if (this.lPS != null) {
                this.lPS.drj();
            }
        } else {
            dqW();
        }
    }

    public void PP() {
        this.kop = true;
        if (this.kok != null) {
            this.kok.PP();
        }
    }

    public boolean dqO() {
        return this.fTk != null && this.fTk.getView().getHeight() > this.fTk.getView().getWidth();
    }

    public void dqP() {
        vK(false);
        dqR();
    }

    public boolean GK(int i2) {
        switch (i2) {
            case 4:
                if (this.aao) {
                    if (dqO()) {
                        vK(false);
                        dqR();
                    } else {
                        PP();
                    }
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.kog <= 0 || this.kod == null) {
                    return false;
                }
                this.kom = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.kom * 100.0d) / this.kog);
                this.kod.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.fTk;
    }

    public VideoListMediaControllerView cUc() {
        return this.knJ;
    }

    public void show() {
        this.knH.setVisibility(0);
    }

    public void cUg() {
        if (this.knS != null) {
            ViewGroup.LayoutParams layoutParams = this.knS.getLayoutParams();
            this.knM = (FrameLayout.LayoutParams) this.knH.getLayoutParams();
            this.knM.width = layoutParams.width;
            this.knM.height = layoutParams.height;
            this.knM.topMargin = 0;
            if (this.mActivity != null && this.mActivity.getResources() != null && this.mActivity.getResources().getConfiguration() != null && this.mActivity.getResources().getConfiguration().orientation == 2) {
                this.knH.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity), com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity)));
                return;
            }
            this.knH.setLayoutParams(this.knM);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.kop) {
            if (this.aao) {
                TiebaStatic.log(new aq("c11712"));
            } else {
                TiebaStatic.log(new aq("c11711"));
            }
        } else {
            this.kop = false;
        }
        if (configuration.orientation == 2) {
            dqQ();
        } else {
            dqR();
        }
        dqS();
        if (this.mActivity == com.baidu.adp.base.a.lg().currentActivity()) {
            aLs();
        }
        drf();
        cUo();
        if (this.lPX != null) {
            this.lPX.pY(true);
        }
    }

    protected void dqQ() {
        this.aao = true;
        this.knH.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(com.baidu.tbadk.util.g.bzd().ey(this.mActivity)), Integer.parseInt(com.baidu.tbadk.util.g.bzd().ez(this.mActivity))));
        j(this.mActivity, true);
        this.bwC.setVisibility(0);
        this.gvQ.setVisibility(0);
        this.knW.setVisibility(0);
        this.knL.setVisibility(8);
        this.frm.dru();
        this.alI.setVisibility(8);
        this.knP.setImageResource(R.drawable.icon_video_narrow_white);
        DA(this.kol);
        cUb();
        if (this.lPP != null) {
            this.lPP.rI();
        }
    }

    protected void dqR() {
        this.aao = false;
        if (this.knM != null) {
            this.knH.setLayoutParams(this.knM);
        }
        j(this.mActivity, false);
        this.bwC.setVisibility(8);
        this.knL.setVisibility(0);
        this.frm.dru();
        this.alI.setVisibility(8);
        this.knP.setImageResource(R.drawable.icon_video_enlarge_white);
        if (this.knJ != null && (this.knJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.knJ.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds24);
            layoutParams.rightMargin = 0;
            this.knJ.setLayoutParams(layoutParams);
        }
        this.knH.setSystemUiVisibility(0);
        dqN();
        if (this.lPP != null) {
            this.lPP.rJ();
        }
    }

    public void dqS() {
        if (this.fTk != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mActivity);
            if (this.aao) {
                equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mActivity);
            }
            this.lPD.setMax(equipmentWidth);
            int duration = this.fTk.getDuration();
            if (duration > 0) {
                if (this.lPG.getVisibility() == 0) {
                    this.lPD.setProgress(this.lPD.getMax());
                } else {
                    this.lPD.setProgress((int) ((this.fTk.getCurrentPositionSync() * this.lPD.getMax()) / duration));
                }
            }
        }
    }

    private void DA(int i2) {
        if (this.knJ != null && (this.knJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.knJ.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.knJ.setLayoutParams(layoutParams);
        }
    }

    private void j(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            activity.getWindow().clearFlags(512);
        }
    }

    public boolean cUi() {
        return !this.aao;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.knU = onPreparedListener;
    }

    public void a(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.lPK = onCompletionListener;
    }

    public void a(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.lPL = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str, String str2) {
        if (this.lQf) {
            fS(str, str2);
        } else {
            fR(str, str2);
        }
        if (eVar != null) {
            eVar.vS(z);
        }
    }

    public void fQ(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, String str2, boolean z) {
        dqX();
        this.lQk = true;
        this.currentState = 0;
        setVideoUrl(str, str2);
        this.fTk.setVideoDuration(this.lPJ);
        this.fTk.setVideoPath(str, str2);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kos);
        if (this.lPR > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kos, this.lPR);
        }
        if (this.lPS != null) {
            this.lPS.onStarted();
        }
        this.frm.startLoading();
        vL(z);
    }

    public void fR(String str, String str2) {
        A(str, str2, true);
    }

    public void fS(String str, String str2) {
        dqX();
        this.lQk = true;
        this.currentState = 0;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kos);
        if (this.lPR > 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.kos, this.lPR);
        }
        if (this.lPS != null) {
            this.lPS.onStarted();
        }
        this.frm.startLoading();
        vL(true);
    }

    public void dqT() {
        aLs();
        this.lPD.setVisibility(0);
    }

    public void aLs() {
        int i2 = 100;
        if (this.fTk != null && this.knJ != null) {
            this.aac = true;
            this.currentState = 1;
            this.fTk.b((TbVideoViewSet.a) null);
            this.mStartPosition = com.baidu.tieba.play.n.dry().PV(this.mVideoUrl);
            this.lQe = true;
            if (this.mStartPosition > 100 && this.fTk.getDuration() > this.mStartPosition) {
                i2 = this.mStartPosition;
            }
            this.aae = i2;
            this.frm.dru();
            vL(false);
        }
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lQi && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alS)) {
            this.lQi = false;
            this.lQj = true;
            fR(this.mVideoUrl, this.alS);
        }
    }

    private void vL(boolean z) {
        if (z) {
            this.alI.setVisibility(0);
            drd();
            this.lPD.setProgress(0);
        } else {
            this.alI.setVisibility(8);
            drd();
        }
        this.knJ.showProgress();
        this.knK.setVisibility(8);
        this.lPH.setVisibility(8);
        this.lPG.setVisibility(8);
        this.lPI.setVisibility(8);
        this.hIm.setVisibility(8);
    }

    private void dqU() {
        this.frm.dru();
        this.lPH.setVisibility(8);
        this.lPG.setVisibility(8);
        this.lPI.setVisibility(8);
        drf();
    }

    public void aLr() {
        this.fTk.pause();
        this.currentState = 2;
        dqU();
    }

    public void stopPlay() {
        this.currentState = 5;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aaj);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kos);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQr);
        this.fTk.stopPlayback();
        this.aac = false;
        this.lQk = false;
        this.mStartPosition = 0;
        cGL();
    }

    public void dqV() {
        if (this.fTk.getDuration() >= this.fTk.getCurrentPosition()) {
            com.baidu.tieba.play.n.dry().bz(this.mVideoUrl, this.fTk.getCurrentPositionSync());
        }
    }

    public void vM(boolean z) {
        this.lQd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vN(boolean z) {
        if (this.knQ != null) {
            this.knK.setVisibility(0);
            this.lPH.setVisibility(8);
            this.lPG.setVisibility(8);
            this.lPI.setVisibility(8);
            this.frm.dru();
            drd();
            this.lPD.setVisibility(8);
            this.hIm.setVisibility(8);
            this.knJ.aLG();
            this.alI.setVisibility(z ? 0 : 8);
        }
    }

    public void cGL() {
        vN(true);
    }

    public boolean rK() {
        if (this.fTk == null) {
            return false;
        }
        return this.fTk.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fTk == null) {
            return 0;
        }
        return this.fTk.getCurrentPosition();
    }

    public void a(k kVar) {
        this.lPV = kVar;
    }

    public void a(j jVar) {
        this.lPU = jVar;
    }

    public void a(i iVar) {
        this.lth = iVar;
    }

    public void a(g gVar) {
        this.lQb = gVar;
    }

    public void a(h hVar) {
        this.lPT = hVar;
    }

    public void Pu(String str) {
        this.lsH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqW() {
        a(this.mVideoUrl, this.alS, (e) null, new Object[0]);
    }

    public void b(d dVar) {
        this.lPQ = dVar;
    }

    public void a(final String str, final String str2, final e eVar, Object... objArr) {
        dqX();
        if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dIK().dIL()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.lQf = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.lQa != null) {
                    this.lQa.ps(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
                aVar.AH(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.a(R.string.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.dqY();
                        aVar2.dismiss();
                        c.this.a(eVar, false, str, str2);
                    }
                });
                aVar.b(R.string.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.etO).bkJ();
                return;
            } else if (this.lQa != null) {
                this.lQa.ps(true);
                return;
            } else {
                if (!this.lPC) {
                    this.lPC = true;
                    com.baidu.adp.lib.util.l.showToast(this.mActivity, R.string.play_video_mobile_tip2);
                }
                a(eVar, true, str, str2);
                return;
            }
        }
        a(eVar, true, str, str2);
        if (this.lPZ != null) {
            this.lPZ.cvx();
        }
    }

    private void dqX() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            com.baidu.tieba.video.g.dIK().fV(this.mActivity);
        }
    }

    public void dqY() {
        com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.VIDEO_LIST_CONFIRM_PLAY_IN_MOBILE, System.currentTimeMillis());
    }

    public void setThumbnail(String str) {
        this.alI.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kow);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.aaj);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kos);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQq);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQr);
        this.kok.stop();
        koo.unregister(this.mActivity);
    }

    public void PU(String str) {
        this.knW.setText(str);
    }

    public boolean cUk() {
        return this.aac;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqZ() {
        if (this.knQ != null) {
            if (this.lPM) {
                drd();
            } else {
                drc();
            }
        }
    }

    public void cUo() {
        drc();
        dra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dra() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kow);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.kow, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drb() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kow);
    }

    public void drc() {
        if (this.knQ != null && !this.lPM && !this.lQo) {
            vO(true);
            cUn();
            this.knQ.setVisibility(0);
            this.lPE.setVisibility(0);
            this.lPD.setVisibility(8);
            this.lPM = true;
            if (this.lPQ != null) {
                this.lPQ.pt(false);
            }
        }
    }

    public void cUl() {
        if (this.knQ != null && this.lPM) {
            vO(false);
            cUn();
            this.knQ.setVisibility(8);
            this.lPE.setVisibility(8);
            this.lPD.setVisibility(0);
            this.iwm.setAnimationListener(this.kou);
            this.knQ.startAnimation(this.iwm);
            this.lPM = false;
            if (this.lPQ != null) {
                this.lPQ.cvz();
            }
        }
    }

    public void drd() {
        if (this.knQ != null && this.lPM) {
            this.bKg.cancel();
            this.iwm.cancel();
            vO(false);
            cUn();
            this.knQ.setVisibility(8);
            this.lPE.setVisibility(8);
            this.lPD.setVisibility(0);
            this.lPM = false;
            if (this.lPQ != null) {
                this.lPQ.cvz();
            }
        }
    }

    private void cUn() {
        if (this.knQ != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kow);
            this.bKg.setAnimationListener(null);
            this.iwm.setAnimationListener(null);
            this.knQ.clearAnimation();
        }
    }

    private void dre() {
        if (this.knQ != null) {
            this.bKg.setAnimationListener(null);
            this.iwm.setAnimationListener(null);
            this.knQ.clearAnimation();
        }
    }

    public void vO(boolean z) {
        drf();
        if (z) {
            this.lPF.setVisibility(0);
        } else {
            this.lPF.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drf() {
        if (this.currentState == 1) {
            this.lPF.setState(1);
        } else {
            this.lPF.setState(0);
        }
    }

    public void a(InterfaceC0797c interfaceC0797c) {
        this.lPP = interfaceC0797c;
    }

    public void DD(int i2) {
        this.mStartPosition = i2;
    }

    public void av(boolean z, boolean z2) {
        if (this.kok != null) {
            if (this.knP != null) {
                this.knP.setVisibility((z || !z2) ? 0 : 8);
            }
            if (!z && z2 && this.knJ != null && (this.knJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.knJ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mActivity, R.dimen.tbds52);
                this.knJ.setLayoutParams(layoutParams);
            }
            this.kok.cx(z);
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
            if (context.getResources() != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().orientation == 2) {
                i2 = displayMetrics.widthPixels;
            } else {
                i2 = displayMetrics.heightPixels;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
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

    public void vP(boolean z) {
        this.lQn = z;
    }

    public void a(m mVar) {
        this.lPW = mVar;
    }

    public void a(a aVar) {
        this.lPX = aVar;
    }

    public void a(n nVar) {
        this.lPY = nVar;
    }

    public void a(l lVar) {
        this.lPZ = lVar;
    }

    public void a(f fVar) {
        this.lQa = fVar;
    }

    public void vQ(boolean z) {
        this.lQh = z;
    }

    public void vR(boolean z) {
        this.lPN = z;
    }

    public void GL(int i2) {
        this.lQl = i2;
    }

    public View drg() {
        return this.knH;
    }

    public void a(p pVar) {
        this.lsV = pVar;
    }

    public void drh() {
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.etO.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.etO.getPageActivity());
    }

    public void setStageType(String str) {
        if (this.fTk != null) {
            this.fTk.setStageType(str);
        }
    }
}
