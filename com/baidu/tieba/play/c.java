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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.s;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int dPh;
    private TbPageContext<?> acp;
    private QuickVideoView bIS;
    private View bIU;
    private ImageView bIV;
    private View bIZ;
    private o bmS;
    private View dOA;
    private FrameLayout dOB;
    protected FrameLayout.LayoutParams dOC;
    private ImageView dOE;
    private ImageView dOF;
    private View dOG;
    private View dOI;
    private TbImageView dOJ;
    private f.d dOK;
    private ImageView dOM;
    private TextView dON;
    private Animation dOR;
    private View dOU;
    private View dOV;
    private TextView dOW;
    private SeekBar dOX;
    private ImageView dOY;
    private ImageView dOZ;
    private Animation dOj;
    protected View dOx;
    private VideoListMediaControllerView dOz;
    private int dPa;
    private int dPf;
    private int dPg;
    private CallStateReceiver dPi;
    private View dct;
    private e eYg;
    private TextView fza;
    private View fzb;
    private ProgressBar fzc;
    private View fzd;
    private TextView fze;
    private TextView fzf;
    private TextView fzg;
    private f.a fzh;
    private f.b fzi;
    private b fzj;
    private InterfaceC0116c fzk;
    private d fzl;
    private f fzm;
    private g fzn;
    private h fzo;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean fyZ = false;
    protected boolean cZr = false;
    private boolean dOO = false;
    private boolean dOQ = false;
    private int dOT = 0;
    private int mStatus = 0;
    private int dPb = 0;
    private int dPc = 0;
    private boolean dPj = false;
    private String eXO = null;
    private int amQ = -1;
    private f.d aUM = new f.d() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.f.d
        public void onPrepared(com.baidu.tieba.play.f fVar) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dPl);
            com.baidu.adp.lib.g.e.ga().postDelayed(c.this.dPl, 20L);
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dPn);
            if (c.this.bIS.bfJ()) {
                c.this.amQ = 1;
                c.this.bIS.setRecoveryState(1);
            }
            if (fVar != null && c.this.dOz != null) {
                c.this.dOT = v.bfZ().qI(c.this.mVideoUrl);
                c.this.dOz.U(c.this.dOT, fVar.getDuration());
                if (c.this.dOT != 0) {
                    fVar.seekTo(c.this.dOT);
                }
            }
        }
    };
    private Runnable dPl = new Runnable() { // from class: com.baidu.tieba.play.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bIS.getCurrentPosition() > 100) {
                c.this.dOO = true;
                c.this.dOA.setVisibility(8);
                c.this.bIZ.setVisibility(8);
                c.this.dct.setVisibility(8);
                c.this.fzb.setVisibility(8);
                c.this.dOJ.setVisibility(8);
                c.this.aDi();
                if (c.this.amQ == 1 || c.this.amQ == 2) {
                    if (c.this.dOG != null) {
                        c.this.dOG.setVisibility(0);
                        c.this.fzd.setVisibility(0);
                        c.this.fzc.setVisibility(8);
                        if (c.this.fzk != null) {
                            c.this.fzk.ke(false);
                        }
                    }
                    c.this.dOz.showProgress();
                    c.this.aDj();
                }
                if (c.this.dOK != null) {
                    c.this.dOK.onPrepared(c.this.bIS.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.ga().postDelayed(c.this.dPl, 20L);
        }
    };
    private f.a aUL = new f.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.f.a
        public void onCompletion(com.baidu.tieba.play.f fVar) {
            c.this.dOO = false;
            c.this.dOT = 0;
            c.this.aCQ();
            c.this.dOA.setVisibility(0);
            c.this.fzc.setVisibility(8);
            c.this.fzc.setProgress(c.this.fzc.getMax());
            if (c.this.fzk != null) {
                c.this.fzk.ke(false);
            }
            if (c.this.cZr) {
                c.this.dOG.setVisibility(0);
                c.this.dOM.setVisibility(0);
                c.this.dON.setVisibility(0);
                c.this.fzd.setVisibility(8);
            } else {
                c.this.dOG.setVisibility(8);
                c.this.dOM.setVisibility(8);
                c.this.dON.setVisibility(8);
                c.this.fzd.setVisibility(8);
            }
            if (c.this.bIS == null || c.this.bIS.getDuration() > 150000) {
                c.this.lt(false);
            } else {
                c.this.fze.setVisibility(0);
            }
            v.bfZ().remove(c.this.mVideoUrl);
            if (c.this.fzh != null) {
                c.this.fzh.onCompletion(fVar);
            }
            c.this.amQ = 3;
            c.this.bIS.setRecoveryState(3);
            if (!c.this.cZr && c.this.bIS != null && c.this.bIS.getDuration() <= 150000) {
                if (c.this.fzm != null) {
                    c.this.fzm.aWk();
                }
                c.this.startPlay(c.this.mVideoUrl);
            }
        }
    };
    private f.b dPm = new f.b() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.f.b
        public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
            c.this.bIZ.setVisibility(0);
            c.this.dct.setVisibility(8);
            c.this.fzb.setVisibility(8);
            c.this.amQ = 4;
            c.this.bIS.setRecoveryState(4);
            if (c.this.fzi != null) {
                c.this.fzi.onError(fVar, i, i2);
                return true;
            }
            return true;
        }
    };
    private Runnable dPn = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            c.this.bIZ.setVisibility(0);
            c.this.dct.setVisibility(8);
            c.this.fzb.setVisibility(8);
        }
    };
    private QuickVideoView.b bHf = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dOO = false;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dPl);
            com.baidu.adp.lib.g.e.ga().removeCallbacks(c.this.dPn);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bIZ.getId()) {
                c.this.bfB();
            } else if (view.getId() != c.this.bIV.getId() && view.getId() != c.this.dOE.getId()) {
                if (view.getId() == c.this.fzf.getId()) {
                    if (c.this.fzl != null) {
                        c.this.fzl.aWj();
                    }
                } else if (view.getId() == c.this.fze.getId()) {
                    if (c.this.fzm != null) {
                        c.this.fzm.aWk();
                    }
                    c.this.startPlay(c.this.mVideoUrl);
                } else if (view.getId() != c.this.dOF.getId()) {
                    if (view.getId() == c.this.dOM.getId()) {
                        TiebaStatic.log(new aj("c11713"));
                        c.this.aCU();
                    }
                } else {
                    if (c.this.cZr) {
                        TiebaStatic.log(new aj("c11714"));
                    } else {
                        TiebaStatic.log(new aj("c11710"));
                    }
                    c.this.aCU();
                }
            } else {
                c.this.aVY();
            }
        }
    };
    private Animation.AnimationListener dPp = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dOG != null) {
                c.this.dOG.setVisibility(8);
                c.this.fzc.setVisibility(0);
                c.this.dOQ = false;
                if (c.this.fzk != null) {
                    c.this.fzk.aWi();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dPq = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.4
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
    private Runnable dPr = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aDg();
        }
    };
    private CustomMessageListener dPs = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private s.b dSc = new s.b() { // from class: com.baidu.tieba.play.c.7
        @Override // com.baidu.tieba.play.s.b
        public void fQ(int i) {
            int duration;
            if (c.this.bIS != null && (duration = c.this.bIS.getDuration()) > 0 && c.this.fzc != null) {
                c.this.fzc.setProgress((int) ((i * c.this.dOx.getWidth()) / duration));
            }
            c.this.ni(i);
        }
    };
    private SeekBar.OnSeekBarChangeListener aYE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && c.this.dOQ) {
                c.this.aDj();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aDf() && c.this.aCV() != null) {
                c.this.setStartPosition(c.this.aCV().getSeekPosition());
                c.this.startPlay(c.this.mVideoUrl);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aDk();

        void aDl();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0116c {
        void aWi();

        void ke(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aWj();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aWg();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aWk();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface h {
        void aWh();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dPf = 0;
        if (tbPageContext != null) {
            this.acp = tbPageContext;
            this.dOx = t(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dOx);
            }
            this.dOI = view;
            this.dOx.setOnClickListener(this.mOnClickListener);
            this.bIS = (QuickVideoView) this.dOx.findViewById(d.h.videoView);
            this.dct = this.dOx.findViewById(d.h.video_list_layout_loading);
            this.fzb = this.dOx.findViewById(d.h.layout_play_count);
            this.fza = (TextView) this.dOx.findViewById(d.h.play_count);
            this.dOz = (VideoListMediaControllerView) this.dOx.findViewById(d.h.media_controller);
            this.dOz.setPlayer(this.bIS);
            this.fzc = (ProgressBar) this.dOx.findViewById(d.h.pgrBottomProgress);
            this.fzc.setMax(com.baidu.adp.lib.util.k.ag(this.acp.getPageActivity()));
            this.fzc.setProgress(0);
            this.dOz.setOnSeekBarChangeListener(this.aYE);
            this.dOz.setOnProgressUpdatedListener(this.dSc);
            this.dOA = this.dOx.findViewById(d.h.black_mask);
            this.bIZ = this.dOx.findViewById(d.h.layout_error);
            this.bIZ.setOnClickListener(this.mOnClickListener);
            this.dOB = (FrameLayout) this.dOx.findViewById(d.h.danmu_container);
            this.dOE = (ImageView) this.dOx.findViewById(d.h.img_play_icon);
            this.dOE.setOnClickListener(this.mOnClickListener);
            this.dOF = (ImageView) this.dOx.findViewById(d.h.img_full_screen);
            this.dOF.setOnClickListener(this.mOnClickListener);
            this.dOG = this.dOx.findViewById(d.h.layout_media_controller);
            this.fzd = this.dOx.findViewById(d.h.time_show_controller);
            this.bIS.setOnPreparedListener(this.aUM);
            this.bIS.setOnCompletionListener(this.aUL);
            this.bIS.setOnErrorListener(this.dPm);
            this.bIS.setOnSurfaceDestroyedListener(this.bHf);
            this.bIV = (ImageView) this.dOx.findViewById(d.h.img_play);
            this.bIV.setOnClickListener(this.mOnClickListener);
            this.fze = (TextView) this.dOx.findViewById(d.h.txt_replay);
            this.fze.setOnClickListener(this.mOnClickListener);
            this.fzf = (TextView) this.dOx.findViewById(d.h.txt_playnext);
            this.fzf.setOnClickListener(this.mOnClickListener);
            this.fzg = (TextView) this.dOx.findViewById(d.h.txt_next_video_title);
            this.dOJ = (TbImageView) this.dOx.findViewById(d.h.video_thumbnail);
            this.dOJ.setDefaultErrorResource(0);
            this.dOJ.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.ag(this.acp.getPageActivity());
            this.mScreenHeight = getScreenHeight(this.acp.getPageActivity());
            this.dOM = (ImageView) this.dOx.findViewById(d.h.img_exit);
            this.dOM.setOnClickListener(this.mOnClickListener);
            this.dON = (TextView) this.dOx.findViewById(d.h.video_title);
            this.bIU = this.dOx.findViewById(d.h.layout_title);
            this.bIU.setVisibility(8);
            this.dOR = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dOj = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.acp.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dPa = this.mAudioManager.getStreamMaxVolume(3);
            this.dPg = this.mAudioManager.getStreamVolume(3);
            dPh = 100 / this.dPa;
            this.dOx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dOO) {
                            if (c.this.mStatus == 1 && c.this.dPc != 0) {
                                c.this.c(c.this.dPc == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dPc = 0;
                                c.this.dPb = 0;
                            }
                            if (!c.this.bIS.isPlaying() && 8 == c.this.bIV.getVisibility()) {
                                c.this.bIV.setVisibility(0);
                                c.this.fzf.setVisibility(8);
                                c.this.fze.setVisibility(8);
                                c.this.fzg.setVisibility(8);
                            }
                        }
                        c.this.aCQ();
                        if (c.this.fzn != null) {
                            c.this.fzn.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bmS = new o(this.acp.getPageActivity());
            this.bmS.start();
            this.dPf = com.baidu.adp.lib.util.k.g(this.acp.getPageActivity(), d.f.ds16);
            this.dPi = new CallStateReceiver();
            this.dPi.register(this.acp.getPageActivity());
            this.acp.registerListener(this.dPs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCQ() {
        this.mStatus = 0;
        if (this.dOU != null && this.dOU.getParent() != null && (this.dOU.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dOU.getParent()).removeView(this.dOU);
                this.dOU = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dOV != null && this.dOV.getParent() != null && (this.dOV.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dOV.getParent()).removeView(this.dOV);
                this.dOV = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aCR() {
        if (this.mStatus == 1) {
            if (this.dOU == null && this.dOx != null && (this.dOx instanceof ViewGroup)) {
                LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dOx, true);
                this.dOU = this.dOx.findViewById(d.h.lay_jindu);
                this.dOW = (TextView) this.dOU.findViewById(d.h.show_time);
                this.dOZ = (ImageView) this.dOU.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dOV == null && this.dOx != null && (this.dOx instanceof ViewGroup)) {
            LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dOx, true);
            this.dOV = this.dOx.findViewById(d.h.lay_voice);
            this.dOY = (ImageView) this.dOV.findViewById(d.h.arrow_voice_icon);
            this.dOX = (SeekBar) this.dOV.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fzn != null) {
                c.this.fzn.onStart();
            }
            if (c.this.cZr && c.this.dOO) {
                if (!c.this.bIS.isPlaying() && c.this.bIV.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bIV.setVisibility(8);
                    c.this.fzf.setVisibility(8);
                    c.this.fze.setVisibility(8);
                    c.this.fzg.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.ad(f2);
                    }
                } else {
                    if (c.this.cZr) {
                        c.this.aCT();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dPb = c.this.bIS.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ad(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fzo != null) {
                c.this.fzo.aWh();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dOO) {
                if (c.this.amQ != 2) {
                    c.this.bfC();
                } else {
                    c.this.aVY();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dOx.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dOx.setSystemUiVisibility(4);
        } else {
            this.dOx.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f2) {
        if (!this.dOO) {
            this.mStatus = 0;
            return;
        }
        aCR();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dPh == 0) {
            if (f2 > 0.0f && this.dPg < this.dPa) {
                this.dPg++;
            }
            if (f2 < 0.0f && this.dPg > 0) {
                this.dPg--;
            }
        }
        if (this.mProgress > 0) {
            this.dOY.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dOY.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dPg, 0);
        this.dOX.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dPb -= 1000;
                this.dPc = 1;
            } else {
                this.dPb += 1000;
                this.dPc = 2;
            }
            if (this.dPb < 0) {
                this.dPb = 0;
            } else if (this.dPb > this.bIS.getDuration()) {
                this.dPb = this.bIS.getDuration();
            }
        }
        aCR();
        String rC = this.dOz.rC(this.dPb);
        if (f2 > 0.0f) {
            this.dOZ.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dOZ.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rC)) {
            this.dOW.setText(new StringBuilder().append(rC).append("/").append(this.dOz.rC(this.bIS.getDuration())));
        }
        this.dOz.D(this.dPb, z ? false : true);
        this.dOG.setVisibility(8);
        this.fzc.setVisibility(0);
        bfz();
    }

    protected View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void aVY() {
        if (!com.baidu.adp.lib.util.i.hr()) {
            com.baidu.adp.lib.util.k.F(this.acp.getPageActivity(), this.acp.getString(d.l.neterror));
        } else if (this.bIS.isPlaying()) {
            pausePlay();
        } else if (this.dOO) {
            aDe();
            if (this.eYg != null) {
                this.eYg.aWg();
            }
        } else {
            bfB();
        }
    }

    public void aCU() {
        this.dPj = true;
        if (this.bmS != null) {
            this.bmS.aCU();
        }
    }

    public boolean rA(int i) {
        switch (i) {
            case 4:
                if (this.cZr) {
                    aCU();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dPa <= 0 || this.dOX == null) {
                    return false;
                }
                this.dPg = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dPg * 100.0d) / this.dPa);
                this.dOX.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bIS;
    }

    public VideoListMediaControllerView aCV() {
        return this.dOz;
    }

    public void show() {
        this.dOx.setVisibility(0);
    }

    public void aCZ() {
        if (this.dOI != null) {
            ViewGroup.LayoutParams layoutParams = this.dOI.getLayoutParams();
            this.dOC = (FrameLayout.LayoutParams) this.dOx.getLayoutParams();
            this.dOC.width = layoutParams.width;
            this.dOC.height = layoutParams.height;
            this.dOC.topMargin = 0;
            this.dOx.setLayoutParams(this.dOC);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dPj) {
            if (this.cZr) {
                TiebaStatic.log(new aj("c11712"));
            } else {
                TiebaStatic.log(new aj("c11711"));
            }
        } else {
            this.dPj = false;
        }
        if (configuration.orientation == 2) {
            this.cZr = true;
            this.dOx.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dOG.setVisibility(0);
            this.bIU.setVisibility(0);
            this.dOM.setVisibility(0);
            this.dON.setVisibility(0);
            this.dOB.setVisibility(8);
            if (this.fzj != null) {
                this.fzj.aDk();
            }
            this.dOF.setImageResource(d.g.icon_suoxiao);
            ng(this.dPf);
            aCT();
        } else {
            this.cZr = false;
            if (this.dOC != null) {
                this.dOx.setLayoutParams(this.dOC);
            }
            b(baseActivity, false);
            this.bIU.setVisibility(8);
            this.dOB.setVisibility(0);
            if (this.fzj != null) {
                this.fzj.aDl();
            }
            if (this.amQ == 3 && this.fzk != null) {
                this.fzk.ke(false);
            } else if (!this.dOO && this.dOG != null) {
                this.dOG.clearAnimation();
                this.dOG.setVisibility(4);
                this.fzc.setVisibility(0);
                if (this.fzk != null) {
                    this.fzk.aWi();
                }
            }
            aCQ();
            this.dOF.setImageResource(d.g.icon_fangda);
            ng(0);
            this.dOx.setSystemUiVisibility(0);
        }
        if (this.bIS.isPlaying()) {
            aDj();
        }
        bfz();
    }

    private void bfz() {
        if (this.bIS != null) {
            int ag = com.baidu.adp.lib.util.k.ag(this.acp.getPageActivity());
            if (this.cZr) {
                ag = com.baidu.adp.lib.util.k.ah(this.acp.getPageActivity());
            }
            this.fzc.setMax(ag);
            int duration = this.bIS.getDuration();
            if (duration > 0) {
                if (this.fze.getVisibility() == 0) {
                    this.fzc.setProgress(this.fzc.getMax());
                } else {
                    this.fzc.setProgress((int) ((this.bIS.getCurrentPosition() * this.fzc.getMax()) / duration));
                }
            }
        }
    }

    private void ng(int i) {
        if (this.dOz != null && (this.dOz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dOz.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dOz.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.fzb.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.dct.getVisibility() == 0) {
                this.fzb.setVisibility(0);
            }
        }
    }

    public boolean aDb() {
        return !this.cZr;
    }

    public void a(f.b bVar) {
        this.fzi = bVar;
    }

    public void aDc() {
        this.dOE.setImageResource(d.g.icon_video_midpause);
        this.dct.setVisibility(8);
        this.fzb.setVisibility(8);
        this.bIV.setVisibility(0);
        this.fzf.setVisibility(8);
        this.fze.setVisibility(8);
        this.fzg.setVisibility(8);
        this.amQ = 2;
        this.bIS.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.amQ = 0;
        this.bIS.setRecoveryState(0);
        setVideoUrl(str);
        this.bIS.setVideoPath(str);
        this.bIS.start();
        this.dct.setVisibility(0);
        if (this.cZr) {
            this.fzb.setVisibility(8);
        } else {
            this.fzb.setVisibility(0);
        }
        this.dOJ.setVisibility(0);
        this.bIV.setVisibility(8);
        this.dOE.setImageResource(d.g.icon_video_midplay);
        this.fzf.setVisibility(8);
        this.fze.setVisibility(8);
        this.fzg.setVisibility(8);
        this.bIZ.setVisibility(8);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPn);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.dPn, TbConfig.USE_TIME_INTERVAL);
    }

    public void aDe() {
        this.amQ = 1;
        this.bIS.setRecoveryState(1);
        this.bIS.start();
        this.dOE.setImageResource(d.g.icon_video_midplay);
        this.dOJ.setVisibility(8);
        this.dOA.setVisibility(8);
        this.dct.setVisibility(8);
        this.fzb.setVisibility(8);
        this.dOz.showProgress();
        this.bIV.setVisibility(8);
        this.fzf.setVisibility(8);
        this.fze.setVisibility(8);
        this.fzg.setVisibility(8);
        bfE();
    }

    public void ls(boolean z) {
        if (this.bIS != null) {
            this.bIS.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bIS.isPlaying()) {
            v.bfZ().aq(this.mVideoUrl, this.bIS.getCurrentPosition());
        }
        bfD();
        this.bIS.pause();
        aDc();
    }

    public void stopPlay() {
        if (this.bIS.isPlaying()) {
            v.bfZ().aq(this.mVideoUrl, this.bIS.getCurrentPosition());
        }
        this.amQ = 5;
        this.bIS.setRecoveryState(5);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPl);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPn);
        this.bIS.stopPlayback();
        this.dOO = false;
        this.dOT = 0;
        apD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(boolean z) {
        if (this.dOG != null) {
            this.dOA.setVisibility(0);
            this.bIV.setVisibility(0);
            this.fzf.setVisibility(8);
            this.fze.setVisibility(8);
            this.fzg.setVisibility(8);
            this.dct.setVisibility(8);
            this.fzb.setVisibility(8);
            this.dOE.setImageResource(d.g.icon_video_midpause);
            this.dOG.setVisibility(4);
            this.fzc.setVisibility(8);
            this.bIZ.setVisibility(8);
            this.dOz.Ld();
            this.dOJ.setVisibility(z ? 0 : 8);
        }
    }

    public void apD() {
        lt(true);
    }

    public boolean bfA() {
        if (this.bIS == null) {
            return false;
        }
        return this.bIS.isPlaying();
    }

    public void a(f fVar) {
        this.fzm = fVar;
    }

    public void a(e eVar) {
        this.eYg = eVar;
    }

    public void a(d dVar) {
        this.fzl = dVar;
    }

    public void pN(String str) {
        this.eXO = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfB() {
        qF(this.mVideoUrl);
    }

    public void b(InterfaceC0116c interfaceC0116c) {
        this.fzk = interfaceC0116c;
    }

    public void qF(final String str) {
        if (com.baidu.adp.lib.util.i.ht()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.acp.getPageActivity());
                aVar.cT(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
                aVar.a(d.l.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
                        c.this.startPlay(str);
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.l.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.acp).tr();
                return;
            }
            if (!this.fyZ) {
                this.fyZ = true;
                com.baidu.adp.lib.util.k.showToast(this.acp.getPageActivity(), d.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void nd(String str) {
        this.dOJ.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPr);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPl);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPn);
        this.bmS.stop();
        this.dPi.unregister(this.acp.getPageActivity());
    }

    public void qG(String str) {
        this.dON.setText(str);
    }

    public void bU(long j) {
        this.fza.setText(al.u(j));
    }

    public boolean aDf() {
        return this.dOO;
    }

    public void clearAnimation() {
        aDi();
    }

    public void aDg() {
        if (this.dOG != null) {
            aDi();
            this.dOG.setVisibility(0);
            this.fzd.setVisibility(0);
            if (this.fzk != null) {
                this.fzk.ke(true);
            }
            this.fzc.setVisibility(8);
            this.dOR.setAnimationListener(this.dPp);
            this.dOG.startAnimation(this.dOR);
            this.dOQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfC() {
        if (this.dOG != null) {
            if (this.dOG.getVisibility() == 0) {
                aDi();
                this.dOG.setVisibility(8);
                this.fzc.setVisibility(0);
                if (this.fzk != null) {
                    this.fzk.aWi();
                    return;
                }
                return;
            }
            aDj();
        }
    }

    public void aDh() {
        if (this.dOG != null) {
            aDi();
            this.dOG.setVisibility(0);
            this.fzd.setVisibility(0);
            if (this.fzk != null) {
                this.fzk.ke(false);
            }
            this.fzc.setVisibility(8);
            this.dOj.setAnimationListener(this.dPq);
            this.dOG.startAnimation(this.dOj);
        }
    }

    public void bfD() {
        if (this.dOG != null) {
            aDi();
            this.dOG.setVisibility(0);
            this.fzd.setVisibility(0);
            this.fzc.setVisibility(8);
            if (this.fzk != null) {
                this.fzk.ke(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDi() {
        if (this.dOG != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPr);
            this.dOj.setAnimationListener(null);
            this.dOR.setAnimationListener(null);
            this.dOG.clearAnimation();
            this.dOQ = false;
        }
    }

    public void aDj() {
        aDh();
        bfE();
    }

    private void bfE() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dPr);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.dPr, 3000L);
    }

    public void a(b bVar) {
        this.fzj = bVar;
    }

    public void ni(int i) {
        if (this.bIS.getDuration() - i <= 3000) {
            aDi();
            if (this.dOG != null) {
                this.dOG.setVisibility(0);
                this.fzd.setVisibility(0);
                this.fzc.setVisibility(8);
                if (this.fzk != null) {
                    this.fzk.ke(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dOT = i;
    }

    public void lu(boolean z) {
        if (this.bmS != null) {
            if (this.dOF != null) {
                this.dOF.setVisibility(z ? 0 : 8);
            }
            this.bmS.lv(z);
        }
    }

    public int getScreenHeight(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.k.ah(context);
        }
        return i;
    }

    public int bfF() {
        return this.amQ;
    }

    public void a(h hVar) {
        this.fzo = hVar;
    }
}
