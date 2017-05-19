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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.au;
import com.baidu.tieba.play.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c {
    private static int dri;
    private static boolean eSa = false;
    private View aTA;
    private ImageView aTB;
    private View aTG;
    private QuickVideoView aTy;
    private TbPageContext<?> aat;
    private ao bew;
    private View cFb;
    private VideoListMediaControllerView dqA;
    private View dqB;
    private FrameLayout dqC;
    protected FrameLayout.LayoutParams dqD;
    private ImageView dqF;
    private ImageView dqG;
    private View dqH;
    private View dqJ;
    private TbImageView dqK;
    private v.d dqL;
    private ImageView dqN;
    private TextView dqO;
    private Animation dqS;
    private View dqV;
    private View dqW;
    private TextView dqX;
    private SeekBar dqY;
    private ImageView dqZ;
    private Animation dqk;
    protected View dqy;
    private ImageView dra;
    private int drb;
    private int drg;
    private int drh;
    private CallStateReceiver drj;
    private TextView eSc;
    private View eSd;
    private ProgressBar eSe;
    private View eSf;
    private TextView eSg;
    private TextView eSh;
    private TextView eSi;
    private v.a eSj;
    private v.b eSk;
    private b eSl;
    private InterfaceC0076c eSm;
    private d eSn;
    private f eSo;
    private g eSp;
    private e esX;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean eSb = false;
    protected boolean cCa = false;
    private boolean dqP = false;
    private boolean dqR = false;
    private int dqU = 0;
    private int mStatus = 0;
    private int drc = 0;
    private int drd = 0;
    private boolean drk = false;
    private String esR = null;
    private int akp = -1;
    private v.d aRd = new com.baidu.tieba.play.d(this);
    private Runnable drm = new l(this);
    private v.a aRc = new m(this);
    private v.b drn = new n(this);
    private Runnable dro = new o(this);
    private QuickVideoView.b aTQ = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener drq = new r(this);
    private Animation.AnimationListener drr = new s(this);
    private Runnable drs = new com.baidu.tieba.play.e(this);
    private CustomMessageListener drt = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private au.b due = new com.baidu.tieba.play.g(this);
    private SeekBar.OnSeekBarChangeListener aXx = new h(this);

    /* loaded from: classes.dex */
    public interface b {
        void awE();

        void awF();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0076c {
        void aNO();

        void iS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aNP();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aNN();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aNQ();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.drg = 0;
        if (tbPageContext != null) {
            this.aat = tbPageContext;
            this.dqy = t(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dqy);
            }
            this.dqJ = view;
            this.dqy.setOnClickListener(this.mOnClickListener);
            this.aTy = (QuickVideoView) this.dqy.findViewById(w.h.videoView);
            this.cFb = this.dqy.findViewById(w.h.video_list_layout_loading);
            this.eSd = this.dqy.findViewById(w.h.layout_play_count);
            this.eSc = (TextView) this.dqy.findViewById(w.h.play_count);
            this.dqA = (VideoListMediaControllerView) this.dqy.findViewById(w.h.media_controller);
            this.dqA.setPlayer(this.aTy);
            this.eSe = (ProgressBar) this.dqy.findViewById(w.h.pgrBottomProgress);
            this.eSe.setMax(com.baidu.adp.lib.util.k.af(this.aat.getPageActivity()));
            this.eSe.setProgress(0);
            this.dqA.setOnSeekBarChangeListener(this.aXx);
            this.dqA.setOnProgressUpdatedListener(this.due);
            this.dqB = this.dqy.findViewById(w.h.black_mask);
            this.aTG = this.dqy.findViewById(w.h.layout_error);
            this.aTG.setOnClickListener(this.mOnClickListener);
            this.dqC = (FrameLayout) this.dqy.findViewById(w.h.danmu_container);
            this.dqF = (ImageView) this.dqy.findViewById(w.h.img_play_icon);
            this.dqF.setOnClickListener(this.mOnClickListener);
            this.dqG = (ImageView) this.dqy.findViewById(w.h.img_full_screen);
            this.dqG.setOnClickListener(this.mOnClickListener);
            this.dqH = this.dqy.findViewById(w.h.layout_media_controller);
            this.eSf = this.dqy.findViewById(w.h.time_show_controller);
            this.aTy.setOnPreparedListener(this.aRd);
            this.aTy.setOnCompletionListener(this.aRc);
            this.aTy.setOnErrorListener(this.drn);
            this.aTy.setOnSurfaceDestroyedListener(this.aTQ);
            this.aTB = (ImageView) this.dqy.findViewById(w.h.img_play);
            this.aTB.setOnClickListener(this.mOnClickListener);
            this.eSg = (TextView) this.dqy.findViewById(w.h.txt_replay);
            this.eSg.setOnClickListener(this.mOnClickListener);
            this.eSh = (TextView) this.dqy.findViewById(w.h.txt_playnext);
            this.eSh.setOnClickListener(this.mOnClickListener);
            this.eSi = (TextView) this.dqy.findViewById(w.h.txt_next_video_title);
            this.dqK = (TbImageView) this.dqy.findViewById(w.h.video_thumbnail);
            this.dqK.setDefaultErrorResource(0);
            this.dqK.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity());
            this.mScreenHeight = bC(this.aat.getPageActivity());
            this.dqN = (ImageView) this.dqy.findViewById(w.h.img_exit);
            this.dqN.setOnClickListener(this.mOnClickListener);
            this.dqO = (TextView) this.dqy.findViewById(w.h.video_title);
            this.aTA = this.dqy.findViewById(w.h.layout_title);
            this.aTA.setVisibility(8);
            this.dqS = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dqk = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aat.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.drb = this.mAudioManager.getStreamMaxVolume(3);
            this.drh = this.mAudioManager.getStreamVolume(3);
            dri = 100 / this.drb;
            this.dqy.setOnTouchListener(new i(this));
            this.bew = new ao(this.aat.getPageActivity());
            this.bew.start();
            this.drg = com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds16);
            this.drj = new CallStateReceiver();
            this.drj.register(this.aat.getPageActivity());
            this.aat.registerListener(this.drt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awk() {
        this.mStatus = 0;
        if (this.dqV != null && this.dqV.getParent() != null && (this.dqV.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dqV.getParent()).removeView(this.dqV);
                this.dqV = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dqW != null && this.dqW.getParent() != null && (this.dqW.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dqW.getParent()).removeView(this.dqW);
                this.dqW = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void awl() {
        if (this.mStatus == 1) {
            if (this.dqV == null && this.dqy != null && (this.dqy instanceof ViewGroup)) {
                LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.float_video_window_jindu, (ViewGroup) this.dqy, true);
                this.dqV = this.dqy.findViewById(w.h.lay_jindu);
                this.dqX = (TextView) this.dqV.findViewById(w.h.show_time);
                this.dra = (ImageView) this.dqV.findViewById(w.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dqW == null && this.dqy != null && (this.dqy instanceof ViewGroup)) {
            LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.float_video_window_voice, (ViewGroup) this.dqy, true);
            this.dqW = this.dqy.findViewById(w.h.lay_voice);
            this.dqZ = (ImageView) this.dqW.findViewById(w.h.arrow_voice_icon);
            this.dqY = (SeekBar) this.dqW.findViewById(w.h.show_voice_seekbar);
        }
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.eSp != null) {
                c.this.eSp.onStart();
            }
            if (c.this.dqP) {
                if (!c.this.aTy.isPlaying() && c.this.aTB.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aTB.setVisibility(8);
                    c.this.eSh.setVisibility(8);
                    c.this.eSg.setVisibility(8);
                    c.this.eSi.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.Y(f2);
                        }
                    } else {
                        c.this.b(f, true);
                    }
                } else {
                    if (c.this.cCa) {
                        c.this.awn();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.drc = c.this.aTy.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.Y(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awn() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dqy.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dqy.setSystemUiVisibility(4);
        } else {
            this.dqy.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(float f2) {
        if (!this.dqP) {
            this.mStatus = 0;
            return;
        }
        awl();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dri == 0) {
            if (f2 > 0.0f && this.drh < this.drb) {
                this.drh++;
            }
            if (f2 < 0.0f && this.drh > 0) {
                this.drh--;
            }
        }
        if (this.mProgress > 0) {
            this.dqZ.setImageResource(w.g.icon_shengyin_open);
        } else {
            this.dqZ.setImageResource(w.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.drh, 0);
        this.dqY.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.drc -= 1000;
                this.drd = 1;
            } else {
                this.drc += 1000;
                this.drd = 2;
            }
            if (this.drc < 0) {
                this.drc = 0;
            } else if (this.drc > this.aTy.getDuration()) {
                this.drc = this.aTy.getDuration();
            }
        }
        awl();
        String qw = this.dqA.qw(this.drc);
        if (f2 > 0.0f) {
            this.dra.setImageResource(w.g.icon_kuaitui);
        } else {
            this.dra.setImageResource(w.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(qw)) {
            this.dqX.setText(new StringBuilder().append(qw).append("/").append(this.dqA.qw(this.aTy.getDuration())));
        }
        this.dqA.C(this.drc, z ? false : true);
        this.dqH.setVisibility(8);
        this.eSe.setVisibility(0);
        aWl();
    }

    protected View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void aNM() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.E(this.aat.getPageActivity(), this.aat.getString(w.l.neterror));
        } else if (this.aTy.isPlaying()) {
            pausePlay();
        } else if (this.dqP) {
            awy();
            if (this.esX != null) {
                this.esX.aNN();
            }
        } else {
            aWn();
        }
    }

    public void awo() {
        this.drk = true;
        if (this.bew != null) {
            this.bew.awo();
        }
    }

    public boolean qt(int i) {
        switch (i) {
            case 4:
                if (this.cCa) {
                    awo();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.drb <= 0 || this.dqY == null) {
                    return false;
                }
                this.drh = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.drh * 100.0d) / this.drb);
                this.dqY.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView Ku() {
        return this.aTy;
    }

    public VideoListMediaControllerView awp() {
        return this.dqA;
    }

    public View awq() {
        return this.dqH;
    }

    public void show() {
        this.dqy.setVisibility(0);
    }

    public void awt() {
        if (this.dqJ != null) {
            ViewGroup.LayoutParams layoutParams = this.dqJ.getLayoutParams();
            this.dqD = (FrameLayout.LayoutParams) this.dqy.getLayoutParams();
            this.dqD.width = layoutParams.width;
            this.dqD.height = layoutParams.height;
            this.dqD.topMargin = 0;
            this.dqy.setLayoutParams(this.dqD);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.drk) {
            if (this.cCa) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11711"));
            }
        } else {
            this.drk = false;
        }
        if (configuration.orientation == 2) {
            this.cCa = true;
            this.dqy.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dqH.setVisibility(0);
            this.aTA.setVisibility(0);
            this.dqN.setVisibility(0);
            this.dqO.setVisibility(0);
            this.dqC.setVisibility(8);
            if (this.eSl != null) {
                this.eSl.awE();
            }
            this.dqG.setImageResource(w.g.icon_suoxiao);
            ms(this.drg);
            awn();
        } else {
            this.cCa = false;
            if (this.dqD != null) {
                this.dqy.setLayoutParams(this.dqD);
            }
            b(baseActivity, false);
            this.aTA.setVisibility(8);
            this.dqC.setVisibility(0);
            if (this.eSl != null) {
                this.eSl.awF();
            }
            if (this.akp == 3 && this.eSm != null) {
                this.eSm.iS(false);
            } else if (!this.dqP && this.dqH != null) {
                this.dqH.clearAnimation();
                this.dqH.setVisibility(4);
                this.eSe.setVisibility(0);
                if (this.eSm != null) {
                    this.eSm.aNO();
                }
            }
            awk();
            this.dqG.setImageResource(w.g.icon_fangda);
            ms(0);
            this.dqy.setSystemUiVisibility(0);
        }
        if (this.aTy.isPlaying()) {
            awD();
        }
        aWl();
    }

    private void aWl() {
        if (this.aTy != null) {
            int af = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity());
            if (this.cCa) {
                af = com.baidu.adp.lib.util.k.ag(this.aat.getPageActivity());
            }
            this.eSe.setMax(af);
            int duration = this.aTy.getDuration();
            if (duration > 0) {
                if (this.eSg.getVisibility() == 0) {
                    this.eSe.setProgress(this.eSe.getMax());
                } else {
                    this.eSe.setProgress((int) ((this.aTy.getCurrentPosition() * this.eSe.getMax()) / duration));
                }
            }
        }
    }

    private void ms(int i) {
        if (this.dqA != null && (this.dqA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dqA.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dqA.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.eSd.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.cFb.getVisibility() == 0) {
                this.eSd.setVisibility(0);
            }
        }
    }

    public boolean awv() {
        return !this.cCa;
    }

    public void a(v.b bVar) {
        this.eSk = bVar;
    }

    public void aww() {
        this.dqF.setImageResource(w.g.icon_video_midpause);
        this.cFb.setVisibility(8);
        this.eSd.setVisibility(8);
        this.aTB.setVisibility(0);
        this.eSh.setVisibility(8);
        this.eSg.setVisibility(8);
        this.eSi.setVisibility(8);
        this.akp = 2;
        this.aTy.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.akp = 0;
        this.aTy.setRecoveryState(0);
        setVideoUrl(str);
        this.aTy.setVideoPath(str);
        this.aTy.start();
        this.cFb.setVisibility(0);
        if (this.cCa) {
            this.eSd.setVisibility(8);
        } else {
            this.eSd.setVisibility(0);
        }
        this.dqK.setVisibility(0);
        this.aTB.setVisibility(8);
        this.dqF.setImageResource(w.g.icon_video_midplay);
        this.eSh.setVisibility(8);
        this.eSg.setVisibility(8);
        this.eSi.setVisibility(8);
        this.aTG.setVisibility(8);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dro);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.dro, TbConfig.USE_TIME_INTERVAL);
    }

    public void awy() {
        this.akp = 1;
        this.aTy.setRecoveryState(1);
        this.aTy.start();
        this.dqF.setImageResource(w.g.icon_video_midplay);
        this.dqK.setVisibility(8);
        this.dqB.setVisibility(8);
        this.cFb.setVisibility(8);
        this.eSd.setVisibility(8);
        this.dqA.showProgress();
        this.aTB.setVisibility(8);
        this.eSh.setVisibility(8);
        this.eSg.setVisibility(8);
        this.eSi.setVisibility(8);
        aWr();
    }

    public void kd(boolean z) {
        if (this.aTy != null) {
            this.aTy.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.aTy.isPlaying()) {
            az.aWM().ar(this.mVideoUrl, this.aTy.getCurrentPosition());
        }
        aWp();
        this.aTy.pause();
        aww();
    }

    public void stopPlay() {
        if (this.aTy.isPlaying()) {
            az.aWM().ar(this.mVideoUrl, this.aTy.getCurrentPosition());
        }
        this.akp = 5;
        this.aTy.setRecoveryState(5);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.drm);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dro);
        this.aTy.stopPlayback();
        this.dqP = false;
        this.dqU = 0;
        ajb();
    }

    public void ajb() {
        if (this.dqH != null) {
            this.dqB.setVisibility(0);
            this.aTB.setVisibility(0);
            this.eSh.setVisibility(8);
            this.eSg.setVisibility(8);
            this.eSi.setVisibility(8);
            this.cFb.setVisibility(8);
            this.eSd.setVisibility(8);
            this.dqF.setImageResource(w.g.icon_video_midpause);
            this.dqH.setVisibility(4);
            this.eSe.setVisibility(8);
            this.aTG.setVisibility(8);
            this.dqA.Ly();
            this.dqK.setVisibility(0);
        }
    }

    public boolean aWm() {
        if (this.aTy == null) {
            return false;
        }
        return this.aTy.isPlaying();
    }

    public void a(g gVar) {
        this.eSp = gVar;
    }

    public void a(f fVar) {
        this.eSo = fVar;
    }

    public void a(e eVar) {
        this.esX = eVar;
    }

    public void a(d dVar) {
        this.eSn = dVar;
    }

    public void nZ(String str) {
        this.esR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWn() {
        oQ(this.mVideoUrl);
    }

    public void b(InterfaceC0076c interfaceC0076c) {
        this.eSm = interfaceC0076c;
    }

    public void oQ(String str) {
        if (com.baidu.adp.lib.util.i.hm()) {
            if (!eSa) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aat.getPageActivity());
                aVar.cC(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
                aVar.a(w.l.confirm, new j(this, str));
                aVar.b(w.l.cancel, new k(this));
                aVar.b(this.aat).td();
                return;
            }
            if (!this.eSb) {
                this.eSb = true;
                com.baidu.adp.lib.util.k.showToast(this.aat.getPageActivity(), w.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void lC(String str) {
        this.dqK.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.drs);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.drm);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dro);
        this.bew.stop();
        this.drj.unregister(this.aat.getPageActivity());
    }

    public void oR(String str) {
        this.dqO.setText(str);
    }

    public void bB(long j) {
        this.eSc.setText(com.baidu.tbadk.core.util.au.t(j));
    }

    public boolean awz() {
        return this.dqP;
    }

    public void awA() {
        if (this.dqH != null) {
            awC();
            this.dqH.setVisibility(0);
            this.eSf.setVisibility(0);
            if (this.eSm != null) {
                this.eSm.iS(true);
            }
            this.eSe.setVisibility(8);
            this.dqS.setAnimationListener(this.drq);
            this.dqH.startAnimation(this.dqS);
            this.dqR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWo() {
        if (this.dqH != null) {
            if (this.dqH.getVisibility() == 0) {
                awC();
                this.dqH.setVisibility(8);
                this.eSe.setVisibility(0);
                if (this.eSm != null) {
                    this.eSm.aNO();
                    return;
                }
                return;
            }
            awD();
        }
    }

    public void awB() {
        if (this.dqH != null) {
            awC();
            this.dqH.setVisibility(0);
            this.eSf.setVisibility(0);
            if (this.eSm != null) {
                this.eSm.iS(false);
            }
            this.eSe.setVisibility(8);
            this.dqk.setAnimationListener(this.drr);
            this.dqH.startAnimation(this.dqk);
        }
    }

    public void aWp() {
        if (this.dqH != null) {
            awC();
            this.dqH.setVisibility(0);
            this.eSf.setVisibility(0);
            this.eSe.setVisibility(8);
            if (this.eSm != null) {
                this.eSm.iS(false);
            }
        }
    }

    public void aWq() {
        if (this.dqH != null) {
            this.dqk.cancel();
            this.dqS.cancel();
            awC();
            this.dqH.setVisibility(4);
            this.eSf.setVisibility(4);
            this.eSe.setVisibility(8);
            if (this.eSm != null) {
                this.eSm.iS(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awC() {
        if (this.dqH != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.drs);
            this.dqk.setAnimationListener(null);
            this.dqS.setAnimationListener(null);
            this.dqH.clearAnimation();
            this.dqR = false;
        }
    }

    public void awD() {
        awB();
        aWr();
    }

    private void aWr() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.drs);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.drs, 3000L);
    }

    public void a(b bVar) {
        this.eSl = bVar;
    }

    public void mu(int i) {
        if (this.aTy.getDuration() - i <= 3000) {
            awC();
            if (this.dqH != null) {
                this.dqH.setVisibility(0);
                this.eSf.setVisibility(0);
                this.eSe.setVisibility(8);
                if (this.eSm != null) {
                    this.eSm.iS(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dqU = i;
    }

    public void ke(boolean z) {
        if (this.bew != null) {
            this.bew.kg(z);
        }
    }

    public int bC(Context context) {
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
            return com.baidu.adp.lib.util.k.ag(context);
        }
        return i;
    }

    public int aWs() {
        return this.akp;
    }
}
