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
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.s;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int dYI;
    private String aVD;
    private TbPageContext<?> aby;
    private QuickVideoView bNl;
    private View bNn;
    private ImageView bNo;
    private View bNs;
    private o bny;
    private Animation ctR;
    private Animation ctS;
    protected View dXZ;
    private ImageView dYA;
    private int dYB;
    private int dYG;
    private int dYH;
    private CallStateReceiver dYJ;
    private VideoListMediaControllerView dYb;
    private View dYc;
    private FrameLayout dYd;
    protected FrameLayout.LayoutParams dYe;
    private ImageView dYg;
    private ImageView dYh;
    private View dYi;
    private View dYk;
    private TbImageView dYl;
    private f.e dYm;
    private ImageView dYo;
    private TextView dYp;
    private View dYv;
    private View dYw;
    private TextView dYx;
    private SeekBar dYy;
    private ImageView dYz;
    private View dlS;
    private g eZE;
    private j fAA;
    private e fAB;
    private TextView fAl;
    private View fAm;
    private ProgressBar fAn;
    private View fAo;
    private TextView fAp;
    private TextView fAq;
    private TextView fAr;
    private f.a fAs;
    private f.b fAt;
    private b fAu;
    private InterfaceC0118c fAv;
    private f fAw;
    private h fAx;
    private i fAy;
    private k fAz;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean fAk = false;
    protected boolean diT = false;
    private boolean dYq = false;
    private boolean dYs = false;
    private int dYu = 0;
    private int mStatus = 0;
    private int dYC = 0;
    private int dYD = 0;
    private boolean dYK = false;
    private boolean fAC = true;
    private boolean fAD = true;
    private String eZl = null;
    private int amj = -1;
    private f.e aUt = new f.e() { // from class: com.baidu.tieba.play.c.9
        @Override // com.baidu.tieba.play.f.e
        public void onPrepared(com.baidu.tieba.play.f fVar) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dYM);
            com.baidu.adp.lib.g.e.fQ().postDelayed(c.this.dYM, 20L);
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dYO);
            if (c.this.bNl.bfL()) {
                c.this.amj = 1;
                c.this.bNl.setRecoveryState(1);
            }
            if (fVar != null && c.this.dYb != null) {
                c.this.dYu = v.bgb().qD(c.this.aVD);
                c.this.dYb.S(c.this.dYu, fVar.getDuration());
                if (c.this.dYu != 0) {
                    fVar.seekTo(c.this.dYu);
                }
            }
        }
    };
    private Runnable dYM = new Runnable() { // from class: com.baidu.tieba.play.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bNl.getCurrentPosition() > 100) {
                c.this.dYq = true;
                c.this.dYc.setVisibility(8);
                c.this.bNs.setVisibility(8);
                c.this.dlS.setVisibility(8);
                c.this.fAm.setVisibility(8);
                c.this.dYl.setVisibility(8);
                c.this.aFK();
                if (c.this.amj == 1 || c.this.amj == 2) {
                    if (c.this.dYi != null) {
                        c.this.dYi.setVisibility(0);
                        c.this.fAo.setVisibility(0);
                        c.this.fAn.setVisibility(8);
                        if (c.this.fAv != null) {
                            c.this.fAv.eX(false);
                        }
                    }
                    c.this.dYb.showProgress();
                    c.this.aFL();
                }
                if (c.this.dYm != null) {
                    c.this.dYm.onPrepared(c.this.bNl.getPlayer());
                    return;
                }
                return;
            }
            com.baidu.adp.lib.g.e.fQ().postDelayed(c.this.dYM, 20L);
        }
    };
    private f.a aUs = new f.a() { // from class: com.baidu.tieba.play.c.11
        @Override // com.baidu.tieba.play.f.a
        public void onCompletion(com.baidu.tieba.play.f fVar) {
            c.this.dYq = false;
            c.this.dYu = 0;
            c.this.aFs();
            c.this.dYc.setVisibility(0);
            c.this.fAn.setVisibility(8);
            c.this.fAn.setProgress(c.this.fAn.getMax());
            if (c.this.fAv != null) {
                c.this.fAv.eX(false);
            }
            if (c.this.diT) {
                c.this.dYi.setVisibility(0);
                c.this.dYo.setVisibility(0);
                c.this.dYp.setVisibility(0);
                c.this.fAo.setVisibility(8);
            } else {
                c.this.dYi.setVisibility(8);
                c.this.dYo.setVisibility(8);
                c.this.dYp.setVisibility(8);
                c.this.fAo.setVisibility(8);
            }
            if (c.this.bNl == null || c.this.bNl.getDuration() > 150000) {
                c.this.lB(false);
            } else {
                c.this.fAp.setVisibility(0);
            }
            v.bgb().remove(c.this.aVD);
            if (c.this.fAs != null) {
                c.this.fAs.onCompletion(fVar);
            }
            c.this.amj = 3;
            c.this.bNl.setRecoveryState(3);
            if (!c.this.diT && c.this.bNl != null && c.this.bNl.getDuration() <= 150000) {
                if (c.this.fAx != null) {
                    c.this.fAx.eY(true);
                }
                c.this.startPlay(c.this.aVD);
            }
        }
    };
    private f.b dYN = new f.b() { // from class: com.baidu.tieba.play.c.12
        @Override // com.baidu.tieba.play.f.b
        public boolean onError(com.baidu.tieba.play.f fVar, int i2, int i3) {
            c.this.bNs.setVisibility(0);
            c.this.dlS.setVisibility(8);
            c.this.fAm.setVisibility(8);
            c.this.amj = 4;
            c.this.bNl.setRecoveryState(4);
            if (c.this.fAt != null) {
                c.this.fAt.onError(fVar, i2, i3);
                return true;
            }
            return true;
        }
    };
    private Runnable dYO = new Runnable() { // from class: com.baidu.tieba.play.c.13
        @Override // java.lang.Runnable
        public void run() {
            c.this.bNs.setVisibility(0);
            c.this.dlS.setVisibility(8);
            c.this.fAm.setVisibility(8);
        }
    };
    private QuickVideoView.b bLA = new QuickVideoView.b() { // from class: com.baidu.tieba.play.c.14
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.dYq = false;
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dYM);
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(c.this.dYO);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.c.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.bNs.getId()) {
                c.this.bfA();
            } else if (view.getId() != c.this.bNo.getId() && view.getId() != c.this.dYg.getId()) {
                if (view.getId() == c.this.fAq.getId()) {
                    if (c.this.fAw != null) {
                        c.this.fAw.aWj();
                    }
                } else if (view.getId() == c.this.fAp.getId()) {
                    if (c.this.fAx != null) {
                        c.this.fAx.eY(false);
                    }
                    c.this.startPlay(c.this.aVD);
                } else if (view.getId() != c.this.dYh.getId()) {
                    if (view.getId() == c.this.dYo.getId()) {
                        TiebaStatic.log(new ak("c11713"));
                        if (c.this.fAA != null) {
                            c.this.fAA.ait();
                        }
                        c.this.aFw();
                    }
                } else {
                    if (c.this.diT) {
                        TiebaStatic.log(new ak("c11714"));
                    } else {
                        TiebaStatic.log(new ak("c11710"));
                    }
                    if (c.this.fAA != null) {
                        c.this.fAA.ait();
                    }
                    c.this.aFw();
                }
            } else {
                c.this.aVZ();
            }
        }
    };
    private Animation.AnimationListener dYQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.dYi != null) {
                c.this.dYi.setVisibility(8);
                c.this.fAn.setVisibility(0);
                c.this.dYs = false;
                if (c.this.fAv != null) {
                    c.this.fAv.aiu();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener dYR = new Animation.AnimationListener() { // from class: com.baidu.tieba.play.c.4
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
    private Runnable dYS = new Runnable() { // from class: com.baidu.tieba.play.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.aFI();
        }
    };
    private CustomMessageListener dYT = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.play.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };
    private s.b ebD = new s.b() { // from class: com.baidu.tieba.play.c.7
        @Override // com.baidu.tieba.play.s.b
        public void fR(int i2) {
            int duration;
            if (c.this.bNl != null && (duration = c.this.bNl.getDuration()) > 0 && c.this.fAn != null) {
                c.this.fAn.setProgress((int) ((i2 * c.this.dXZ.getWidth()) / duration));
            }
            c.this.nN(i2);
        }
    };
    private SeekBar.OnSeekBarChangeListener aYp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.c.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z && c.this.dYs) {
                c.this.aFL();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!c.this.aFH() && c.this.aFx() != null) {
                c.this.setStartPosition(c.this.aFx().getSeekPosition());
                c.this.startPlay(c.this.aVD);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void aiq();

        void air();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0118c {
        void aiu();

        void eX(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void ki(boolean z);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eW(boolean z);
    }

    /* loaded from: classes.dex */
    public interface f {
        void aWj();
    }

    /* loaded from: classes.dex */
    public interface g {
        void aiv();
    }

    /* loaded from: classes.dex */
    public interface h {
        void eY(boolean z);
    }

    /* loaded from: classes.dex */
    public interface i {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface j {
        void ais();

        void ait();
    }

    /* loaded from: classes.dex */
    public interface k {
        void aWi();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dYG = 0;
        if (tbPageContext != null) {
            this.aby = tbPageContext;
            this.dXZ = t(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dXZ);
            }
            this.dYk = view;
            this.dXZ.setOnClickListener(this.mOnClickListener);
            this.bNl = (QuickVideoView) this.dXZ.findViewById(d.h.videoView);
            this.dlS = this.dXZ.findViewById(d.h.video_list_layout_loading);
            this.fAm = this.dXZ.findViewById(d.h.layout_play_count);
            this.fAl = (TextView) this.dXZ.findViewById(d.h.play_count);
            this.dYb = (VideoListMediaControllerView) this.dXZ.findViewById(d.h.media_controller);
            this.dYb.setPlayer(this.bNl);
            this.fAn = (ProgressBar) this.dXZ.findViewById(d.h.pgrBottomProgress);
            this.fAn.setMax(com.baidu.adp.lib.util.k.ae(this.aby.getPageActivity()));
            this.fAn.setProgress(0);
            this.dYb.setOnSeekBarChangeListener(this.aYp);
            this.dYb.setOnProgressUpdatedListener(this.ebD);
            this.dYc = this.dXZ.findViewById(d.h.black_mask);
            this.bNs = this.dXZ.findViewById(d.h.layout_error);
            this.bNs.setOnClickListener(this.mOnClickListener);
            this.dYd = (FrameLayout) this.dXZ.findViewById(d.h.danmu_container);
            this.dYg = (ImageView) this.dXZ.findViewById(d.h.img_play_icon);
            this.dYg.setOnClickListener(this.mOnClickListener);
            this.dYh = (ImageView) this.dXZ.findViewById(d.h.img_full_screen);
            this.dYh.setOnClickListener(this.mOnClickListener);
            this.dYi = this.dXZ.findViewById(d.h.layout_media_controller);
            this.fAo = this.dXZ.findViewById(d.h.time_show_controller);
            this.bNl.setOnPreparedListener(this.aUt);
            this.bNl.setOnCompletionListener(this.aUs);
            this.bNl.setOnErrorListener(this.dYN);
            this.bNl.setOnSurfaceDestroyedListener(this.bLA);
            this.bNo = (ImageView) this.dXZ.findViewById(d.h.img_play);
            this.bNo.setOnClickListener(this.mOnClickListener);
            this.fAp = (TextView) this.dXZ.findViewById(d.h.txt_replay);
            this.fAp.setOnClickListener(this.mOnClickListener);
            this.fAq = (TextView) this.dXZ.findViewById(d.h.txt_playnext);
            this.fAq.setOnClickListener(this.mOnClickListener);
            this.fAr = (TextView) this.dXZ.findViewById(d.h.txt_next_video_title);
            this.dYl = (TbImageView) this.dXZ.findViewById(d.h.video_thumbnail);
            this.dYl.setDefaultErrorResource(0);
            this.dYl.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.ae(this.aby.getPageActivity());
            this.mScreenHeight = bG(this.aby.getPageActivity());
            this.dYo = (ImageView) this.dXZ.findViewById(d.h.img_exit);
            this.dYo.setOnClickListener(this.mOnClickListener);
            this.dYp = (TextView) this.dXZ.findViewById(d.h.video_title);
            this.bNn = this.dXZ.findViewById(d.h.layout_title);
            this.bNn.setVisibility(8);
            this.ctR = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.ctS = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aby.getPageActivity(), new a());
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dYB = this.mAudioManager.getStreamMaxVolume(3);
            this.dYH = this.mAudioManager.getStreamVolume(3);
            dYI = 100 / this.dYB;
            this.dXZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.play.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (c.this.fAy != null) {
                        c.this.fAy.onTouch(view2, motionEvent);
                    }
                    boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                    if (motionEvent.getAction() == 1) {
                        if (c.this.dYq) {
                            if (c.this.mStatus == 1 && c.this.dYD != 0) {
                                c.this.c(c.this.dYD == 1 ? 1000.0f : -1000.0f, false);
                                c.this.dYD = 0;
                                c.this.dYC = 0;
                            }
                            if (!c.this.bNl.isPlaying() && 8 == c.this.bNo.getVisibility()) {
                                c.this.bNo.setVisibility(0);
                                c.this.fAq.setVisibility(8);
                                c.this.fAp.setVisibility(8);
                                c.this.fAr.setVisibility(8);
                            }
                        }
                        c.this.aFs();
                        if (c.this.fAy != null) {
                            c.this.fAy.onStop();
                        }
                    }
                    return onTouchEvent;
                }
            });
            this.bny = new o(this.aby.getPageActivity());
            this.bny.start();
            this.dYG = com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds16);
            this.dYJ = new CallStateReceiver();
            this.dYJ.register(this.aby.getPageActivity());
            this.aby.registerListener(this.dYT);
            bfw();
        }
    }

    public void bfw() {
        if (this.fAC) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dXZ.setSystemUiVisibility(4);
                return;
            }
            return;
        }
        this.dXZ.setSystemUiVisibility(0);
    }

    public void ly(boolean z) {
        this.fAC = z;
        bfw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFs() {
        this.mStatus = 0;
        if (this.dYv != null && this.dYv.getParent() != null && (this.dYv.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dYv.getParent()).removeView(this.dYv);
                this.dYv = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dYw != null && this.dYw.getParent() != null && (this.dYw.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dYw.getParent()).removeView(this.dYw);
                this.dYw = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aFt() {
        if (this.mStatus == 1) {
            if (this.dYv == null && this.dXZ != null && (this.dXZ instanceof ViewGroup)) {
                LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.float_video_window_jindu, (ViewGroup) this.dXZ, true);
                this.dYv = this.dXZ.findViewById(d.h.lay_jindu);
                this.dYx = (TextView) this.dYv.findViewById(d.h.show_time);
                this.dYA = (ImageView) this.dYv.findViewById(d.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dYw == null && this.dXZ != null && (this.dXZ instanceof ViewGroup)) {
            LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.float_video_window_voice, (ViewGroup) this.dXZ, true);
            this.dYw = this.dXZ.findViewById(d.h.lay_voice);
            this.dYz = (ImageView) this.dYw.findViewById(d.h.arrow_voice_icon);
            this.dYy = (SeekBar) this.dYw.findViewById(d.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.fAy != null) {
                c.this.fAy.onStart();
            }
            if (c.this.diT && c.this.dYq) {
                if (!c.this.bNl.isPlaying() && c.this.bNo.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bNo.setVisibility(8);
                    c.this.fAq.setVisibility(8);
                    c.this.fAp.setVisibility(8);
                    c.this.fAr.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus == 1) {
                        c.this.c(f, true);
                    } else if (c.this.mStatus == 2) {
                        c.this.S(f2);
                    }
                } else {
                    if (c.this.diT) {
                        c.this.aFv();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dYC = c.this.bNl.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.S(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fAz != null) {
                c.this.fAz.aWi();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dYq) {
                if (c.this.amj != 2) {
                    c.this.bfC();
                } else {
                    c.this.aVZ();
                    return super.onSingleTapConfirmed(motionEvent);
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFv() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dXZ.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dXZ.setSystemUiVisibility(4);
        } else {
            this.dXZ.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(float f2) {
        if (!this.dYq) {
            this.mStatus = 0;
            return;
        }
        aFt();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dYI == 0) {
            if (f2 > 0.0f && this.dYH < this.dYB) {
                this.dYH++;
            }
            if (f2 < 0.0f && this.dYH > 0) {
                this.dYH--;
            }
        }
        if (this.mProgress > 0) {
            this.dYz.setImageResource(d.g.icon_shengyin_open);
        } else {
            this.dYz.setImageResource(d.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dYH, 0);
        this.dYy.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dYC -= 1000;
                this.dYD = 1;
            } else {
                this.dYC += 1000;
                this.dYD = 2;
            }
            if (this.dYC < 0) {
                this.dYC = 0;
            } else if (this.dYC > this.bNl.getDuration()) {
                this.dYC = this.bNl.getDuration();
            }
        }
        aFt();
        String rO = this.dYb.rO(this.dYC);
        if (f2 > 0.0f) {
            this.dYA.setImageResource(d.g.icon_kuaitui);
        } else {
            this.dYA.setImageResource(d.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rO)) {
            this.dYx.setText(new StringBuilder().append(rO).append("/").append(this.dYb.rO(this.bNl.getDuration())));
        }
        this.dYb.A(this.dYC, z ? false : true);
        this.dYi.setVisibility(8);
        this.fAn.setVisibility(0);
        bfx();
    }

    protected View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.aVD = str;
    }

    public void aVZ() {
        if (!com.baidu.adp.lib.util.i.hi()) {
            com.baidu.adp.lib.util.k.F(this.aby.getPageActivity(), this.aby.getString(d.l.neterror));
        } else if (this.bNl.isPlaying()) {
            pausePlay();
        } else if (this.dYq) {
            aFG();
            if (this.eZE != null) {
                this.eZE.aiv();
            }
        } else {
            bfA();
        }
    }

    public void aFw() {
        this.dYK = true;
        if (this.bny != null) {
            this.bny.aFw();
        }
    }

    public boolean rM(int i2) {
        switch (i2) {
            case 4:
                if (this.diT) {
                    aFw();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dYB <= 0 || this.dYy == null) {
                    return false;
                }
                this.dYH = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dYH * 100.0d) / this.dYB);
                this.dYy.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView getVideoView() {
        return this.bNl;
    }

    public VideoListMediaControllerView aFx() {
        return this.dYb;
    }

    public void show() {
        this.dXZ.setVisibility(0);
    }

    public void aFB() {
        if (this.dYk != null) {
            ViewGroup.LayoutParams layoutParams = this.dYk.getLayoutParams();
            this.dYe = (FrameLayout.LayoutParams) this.dXZ.getLayoutParams();
            this.dYe.width = layoutParams.width;
            this.dYe.height = layoutParams.height;
            this.dYe.topMargin = 0;
            this.dXZ.setLayoutParams(this.dYe);
        }
    }

    public void a(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.dYK) {
            if (this.diT) {
                TiebaStatic.log(new ak("c11712"));
            } else {
                TiebaStatic.log(new ak("c11711"));
            }
        } else {
            this.dYK = false;
        }
        if (configuration.orientation == 2) {
            this.diT = true;
            this.dXZ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(tbPageContext, true);
            this.dYi.setVisibility(0);
            this.bNn.setVisibility(0);
            this.dYo.setVisibility(0);
            this.dYp.setVisibility(0);
            this.dYd.setVisibility(8);
            if (this.fAu != null) {
                this.fAu.aiq();
            }
            this.dYh.setImageResource(d.g.icon_suoxiao);
            nL(this.dYG);
            aFv();
        } else {
            this.diT = false;
            if (this.dYe != null) {
                this.dXZ.setLayoutParams(this.dYe);
            }
            a(tbPageContext, false);
            this.bNn.setVisibility(8);
            this.dYd.setVisibility(0);
            if (this.fAu != null) {
                this.fAu.air();
            }
            if (this.amj == 3 && this.fAv != null) {
                this.fAv.eX(false);
            } else if (!this.dYq && this.dYi != null) {
                this.dYi.clearAnimation();
                this.dYi.setVisibility(4);
                this.fAn.setVisibility(0);
                if (this.fAv != null) {
                    this.fAv.aiu();
                }
            }
            aFs();
            this.dYh.setImageResource(d.g.icon_fangda);
            nL(0);
            this.dXZ.setSystemUiVisibility(0);
            bfw();
        }
        if (this.bNl.isPlaying()) {
            aFL();
        }
        bfx();
    }

    public void bfx() {
        if (this.bNl != null) {
            int ae = com.baidu.adp.lib.util.k.ae(this.aby.getPageActivity());
            if (this.diT) {
                ae = com.baidu.adp.lib.util.k.af(this.aby.getPageActivity());
            }
            this.fAn.setMax(ae);
            int duration = this.bNl.getDuration();
            if (duration > 0) {
                if (this.fAp.getVisibility() == 0) {
                    this.fAn.setProgress(this.fAn.getMax());
                } else {
                    this.fAn.setProgress((int) ((this.bNl.getCurrentPosition() * this.fAn.getMax()) / duration));
                }
            }
        }
    }

    private void nL(int i2) {
        if (this.dYb != null && (this.dYb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dYb.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.dYb.setLayoutParams(layoutParams);
        }
    }

    private void a(TbPageContext tbPageContext, boolean z) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = tbPageContext.getPageActivity().getWindow().getAttributes();
                attributes.flags |= 1024;
                tbPageContext.getPageActivity().getWindow().setAttributes(attributes);
                tbPageContext.getPageActivity().getWindow().addFlags(512);
                this.fAm.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = tbPageContext.getPageActivity().getWindow().getAttributes();
            attributes2.flags &= -1025;
            tbPageContext.getPageActivity().getWindow().setAttributes(attributes2);
            tbPageContext.getPageActivity().getWindow().clearFlags(512);
            if (this.dlS.getVisibility() == 0) {
                this.fAm.setVisibility(0);
            }
        }
    }

    public boolean aFD() {
        return !this.diT;
    }

    public void a(f.a aVar) {
        this.fAs = aVar;
    }

    public void a(f.b bVar) {
        this.fAt = bVar;
    }

    public void aFE() {
        this.dYg.setImageResource(d.g.icon_video_midpause);
        this.dlS.setVisibility(8);
        this.fAm.setVisibility(8);
        this.bNo.setVisibility(0);
        this.fAq.setVisibility(8);
        this.fAp.setVisibility(8);
        this.fAr.setVisibility(8);
        this.amj = 2;
        this.bNl.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.amj = 0;
        this.bNl.setRecoveryState(0);
        setVideoUrl(str);
        this.bNl.setVideoPath(str);
        this.bNl.start();
        this.dlS.setVisibility(0);
        if (this.diT) {
            this.fAm.setVisibility(8);
        } else {
            this.fAm.setVisibility(0);
        }
        this.dYl.setVisibility(0);
        this.bNo.setVisibility(8);
        this.dYg.setImageResource(d.g.icon_video_midplay);
        this.fAq.setVisibility(8);
        this.fAp.setVisibility(8);
        this.fAr.setVisibility(8);
        this.bNs.setVisibility(8);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYO);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.dYO, TbConfig.USE_TIME_INTERVAL);
    }

    public void aFG() {
        this.amj = 1;
        this.bNl.setRecoveryState(1);
        this.bNl.start();
        this.dYg.setImageResource(d.g.icon_video_midplay);
        this.dYl.setVisibility(8);
        this.dYc.setVisibility(8);
        this.dlS.setVisibility(8);
        this.fAm.setVisibility(8);
        this.dYb.showProgress();
        this.bNo.setVisibility(8);
        this.fAq.setVisibility(8);
        this.fAp.setVisibility(8);
        this.fAr.setVisibility(8);
        bfE();
    }

    public void lz(boolean z) {
        if (this.bNl != null) {
            this.bNl.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bNl.isPlaying() && this.fAD) {
            bfy();
        }
        bfD();
        this.bNl.pause();
        aFE();
    }

    public void stopPlay() {
        if (this.bNl.isPlaying() && this.fAD) {
            bfy();
        }
        this.amj = 5;
        this.bNl.setRecoveryState(5);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYM);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYO);
        this.bNl.stopPlayback();
        this.dYq = false;
        this.dYu = 0;
        arZ();
    }

    public void bfy() {
        v.bgb().ap(this.aVD, this.bNl.getCurrentPosition());
    }

    public void lA(boolean z) {
        this.fAD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        if (this.dYi != null) {
            this.dYc.setVisibility(0);
            this.bNo.setVisibility(0);
            this.fAq.setVisibility(8);
            this.fAp.setVisibility(8);
            this.fAr.setVisibility(8);
            this.dlS.setVisibility(8);
            this.fAm.setVisibility(8);
            this.dYg.setImageResource(d.g.icon_video_midpause);
            this.dYi.setVisibility(4);
            this.fAn.setVisibility(8);
            this.bNs.setVisibility(8);
            this.dYb.Lm();
            this.dYl.setVisibility(z ? 0 : 8);
        }
    }

    public void arZ() {
        lB(true);
    }

    public boolean bfz() {
        if (this.bNl == null) {
            return false;
        }
        return this.bNl.isPlaying();
    }

    public void a(i iVar) {
        this.fAy = iVar;
    }

    public void a(h hVar) {
        this.fAx = hVar;
    }

    public void a(g gVar) {
        this.eZE = gVar;
    }

    public void a(f fVar) {
        this.fAw = fVar;
    }

    public void pJ(String str) {
        this.eZl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfA() {
        a(this.aVD, (d) null);
    }

    public void b(InterfaceC0118c interfaceC0118c) {
        this.fAv = interfaceC0118c;
    }

    public void a(final String str, final d dVar) {
        if (com.baidu.adp.lib.util.i.hk()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                if (this.fAB != null) {
                    this.fAB.eW(false);
                    return;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aby.getPageActivity());
                aVar.cM(TbadkCoreApplication.getInst().getString(d.l.play_video_mobile_tip));
                aVar.a(d.l.editor_dialog_yes, new a.b() { // from class: com.baidu.tieba.play.c.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        c.this.bfB();
                        c.this.startPlay(str);
                        aVar2.dismiss();
                        if (dVar != null) {
                            dVar.ki(false);
                        }
                    }
                });
                aVar.b(d.l.editor_dialog_no, new a.b() { // from class: com.baidu.tieba.play.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aby).to();
                return;
            } else if (this.fAB != null) {
                this.fAB.eW(true);
                return;
            } else {
                if (!this.fAk) {
                    this.fAk = true;
                    com.baidu.adp.lib.util.k.showToast(this.aby.getPageActivity(), d.l.play_video_mobile_tip2);
                }
                startPlay(str);
                if (dVar != null) {
                    dVar.ki(true);
                    return;
                }
                return;
            }
        }
        startPlay(str);
        if (dVar != null) {
            dVar.ki(true);
        }
        if (this.fAA != null) {
            this.fAA.ais();
        }
    }

    public void bfB() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public void nG(String str) {
        this.dYl.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYS);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYM);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYO);
        this.bny.stop();
        this.dYJ.unregister(this.aby.getPageActivity());
    }

    public void qB(String str) {
        this.dYp.setText(str);
    }

    public void bU(long j2) {
        this.fAl.setText(am.u(j2));
    }

    public boolean aFH() {
        return this.dYq;
    }

    public void aFI() {
        if (this.dYi != null) {
            aFK();
            this.dYi.setVisibility(0);
            this.fAo.setVisibility(0);
            if (this.fAv != null) {
                this.fAv.eX(true);
            }
            this.fAn.setVisibility(8);
            this.ctR.setAnimationListener(this.dYQ);
            this.dYi.startAnimation(this.ctR);
            this.dYs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfC() {
        if (this.dYi != null) {
            if (this.dYi.getVisibility() == 0) {
                aFK();
                this.dYi.setVisibility(8);
                this.fAn.setVisibility(0);
                if (this.fAv != null) {
                    this.fAv.aiu();
                    return;
                }
                return;
            }
            aFL();
        }
    }

    public void aFJ() {
        if (this.dYi != null) {
            aFK();
            this.dYi.setVisibility(0);
            this.fAo.setVisibility(0);
            if (this.fAv != null) {
                this.fAv.eX(false);
            }
            this.fAn.setVisibility(8);
            this.ctS.setAnimationListener(this.dYR);
            this.dYi.startAnimation(this.ctS);
        }
    }

    public void bfD() {
        if (this.dYi != null) {
            aFK();
            this.dYi.setVisibility(0);
            this.fAo.setVisibility(0);
            this.fAn.setVisibility(8);
            if (this.fAv != null) {
                this.fAv.eX(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFK() {
        if (this.dYi != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYS);
            this.ctS.setAnimationListener(null);
            this.ctR.setAnimationListener(null);
            this.dYi.clearAnimation();
            this.dYs = false;
        }
    }

    public void aFL() {
        aFJ();
        bfE();
    }

    private void bfE() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dYS);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.dYS, 3000L);
    }

    public void a(b bVar) {
        this.fAu = bVar;
    }

    public void nN(int i2) {
        if (this.bNl.getDuration() - i2 <= 3000) {
            aFK();
            if (this.dYi != null) {
                this.dYi.setVisibility(0);
                this.fAo.setVisibility(0);
                this.fAn.setVisibility(8);
                if (this.fAv != null) {
                    this.fAv.eX(false);
                }
            }
        }
    }

    public void setStartPosition(int i2) {
        this.dYu = i2;
    }

    public void lC(boolean z) {
        if (this.bny != null) {
            if (this.dYh != null) {
                this.dYh.setVisibility(z ? 0 : 8);
            }
            this.bny.lD(z);
        }
    }

    public int bG(Context context) {
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
            return com.baidu.adp.lib.util.k.af(context);
        }
        return i2;
    }

    public int bfF() {
        return this.amj;
    }

    public void a(k kVar) {
        this.fAz = kVar;
    }

    public void a(j jVar) {
        this.fAA = jVar;
    }

    public void a(e eVar) {
        this.fAB = eVar;
    }
}
