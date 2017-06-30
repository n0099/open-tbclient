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
import com.baidu.tieba.play.av;
import com.baidu.tieba.play.v;
import com.baidu.tieba.w;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    private static int dFn;
    private TbPageContext<?> aat;
    private ImageView bDA;
    private View bDE;
    private QuickVideoView bDx;
    private View bDz;
    private ap biw;
    private View cSw;
    protected View dED;
    private VideoListMediaControllerView dEF;
    private View dEG;
    private FrameLayout dEH;
    protected FrameLayout.LayoutParams dEI;
    private ImageView dEK;
    private ImageView dEL;
    private View dEM;
    private View dEO;
    private TbImageView dEP;
    private v.d dEQ;
    private ImageView dES;
    private TextView dET;
    private Animation dEX;
    private Animation dEp;
    private View dFa;
    private View dFb;
    private TextView dFc;
    private SeekBar dFd;
    private ImageView dFe;
    private ImageView dFf;
    private int dFg;
    private int dFl;
    private int dFm;
    private CallStateReceiver dFo;
    private e eKt;
    private TextView flc;
    private View fld;
    private ProgressBar fle;
    private View flf;
    private TextView flg;
    private TextView flh;
    private TextView fli;
    private v.a flj;
    private v.b flk;
    private b fll;
    private InterfaceC0081c flm;
    private d fln;
    private f flo;
    private g flp;
    private h flq;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean flb = false;
    protected boolean cPv = false;
    private boolean dEU = false;
    private boolean dEW = false;
    private int dEZ = 0;
    private int mStatus = 0;
    private int dFh = 0;
    private int dFi = 0;
    private boolean dFp = false;
    private String eKb = null;
    private int akS = -1;
    private v.d aSx = new com.baidu.tieba.play.d(this);
    private Runnable dFr = new l(this);
    private v.a aSw = new m(this);
    private v.b dFs = new n(this);
    private Runnable dFt = new o(this);
    private QuickVideoView.b bBO = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener dFv = new r(this);
    private Animation.AnimationListener dFw = new s(this);
    private Runnable dFx = new com.baidu.tieba.play.e(this);
    private CustomMessageListener dFy = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private av.b dIi = new com.baidu.tieba.play.g(this);
    private SeekBar.OnSeekBarChangeListener aWs = new com.baidu.tieba.play.h(this);

    /* loaded from: classes.dex */
    public interface b {
        void aBw();

        void aBx();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081c {
        void aTb();

        void jJ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aTc();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aTa();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aSY();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface h {
        void aSZ();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dFl = 0;
        if (tbPageContext != null) {
            this.aat = tbPageContext;
            this.dED = s(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dED);
            }
            this.dEO = view;
            this.dED.setOnClickListener(this.mOnClickListener);
            this.bDx = (QuickVideoView) this.dED.findViewById(w.h.videoView);
            this.cSw = this.dED.findViewById(w.h.video_list_layout_loading);
            this.fld = this.dED.findViewById(w.h.layout_play_count);
            this.flc = (TextView) this.dED.findViewById(w.h.play_count);
            this.dEF = (VideoListMediaControllerView) this.dED.findViewById(w.h.media_controller);
            this.dEF.setPlayer(this.bDx);
            this.fle = (ProgressBar) this.dED.findViewById(w.h.pgrBottomProgress);
            this.fle.setMax(com.baidu.adp.lib.util.k.af(this.aat.getPageActivity()));
            this.fle.setProgress(0);
            this.dEF.setOnSeekBarChangeListener(this.aWs);
            this.dEF.setOnProgressUpdatedListener(this.dIi);
            this.dEG = this.dED.findViewById(w.h.black_mask);
            this.bDE = this.dED.findViewById(w.h.layout_error);
            this.bDE.setOnClickListener(this.mOnClickListener);
            this.dEH = (FrameLayout) this.dED.findViewById(w.h.danmu_container);
            this.dEK = (ImageView) this.dED.findViewById(w.h.img_play_icon);
            this.dEK.setOnClickListener(this.mOnClickListener);
            this.dEL = (ImageView) this.dED.findViewById(w.h.img_full_screen);
            this.dEL.setOnClickListener(this.mOnClickListener);
            this.dEM = this.dED.findViewById(w.h.layout_media_controller);
            this.flf = this.dED.findViewById(w.h.time_show_controller);
            this.bDx.setOnPreparedListener(this.aSx);
            this.bDx.setOnCompletionListener(this.aSw);
            this.bDx.setOnErrorListener(this.dFs);
            this.bDx.setOnSurfaceDestroyedListener(this.bBO);
            this.bDA = (ImageView) this.dED.findViewById(w.h.img_play);
            this.bDA.setOnClickListener(this.mOnClickListener);
            this.flg = (TextView) this.dED.findViewById(w.h.txt_replay);
            this.flg.setOnClickListener(this.mOnClickListener);
            this.flh = (TextView) this.dED.findViewById(w.h.txt_playnext);
            this.flh.setOnClickListener(this.mOnClickListener);
            this.fli = (TextView) this.dED.findViewById(w.h.txt_next_video_title);
            this.dEP = (TbImageView) this.dED.findViewById(w.h.video_thumbnail);
            this.dEP.setDefaultErrorResource(0);
            this.dEP.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity());
            this.mScreenHeight = bw(this.aat.getPageActivity());
            this.dES = (ImageView) this.dED.findViewById(w.h.img_exit);
            this.dES.setOnClickListener(this.mOnClickListener);
            this.dET = (TextView) this.dED.findViewById(w.h.video_title);
            this.bDz = this.dED.findViewById(w.h.layout_title);
            this.bDz.setVisibility(8);
            this.dEX = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dEp = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aat.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dFg = this.mAudioManager.getStreamMaxVolume(3);
            this.dFm = this.mAudioManager.getStreamVolume(3);
            dFn = 100 / this.dFg;
            this.dED.setOnTouchListener(new i(this));
            this.biw = new ap(this.aat.getPageActivity());
            this.biw.start();
            this.dFl = com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds16);
            this.dFo = new CallStateReceiver();
            this.dFo.register(this.aat.getPageActivity());
            this.aat.registerListener(this.dFy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        this.mStatus = 0;
        if (this.dFa != null && this.dFa.getParent() != null && (this.dFa.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dFa.getParent()).removeView(this.dFa);
                this.dFa = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dFb != null && this.dFb.getParent() != null && (this.dFb.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dFb.getParent()).removeView(this.dFb);
                this.dFb = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void aBd() {
        if (this.mStatus == 1) {
            if (this.dFa == null && this.dED != null && (this.dED instanceof ViewGroup)) {
                LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.float_video_window_jindu, (ViewGroup) this.dED, true);
                this.dFa = this.dED.findViewById(w.h.lay_jindu);
                this.dFc = (TextView) this.dFa.findViewById(w.h.show_time);
                this.dFf = (ImageView) this.dFa.findViewById(w.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dFb == null && this.dED != null && (this.dED instanceof ViewGroup)) {
            LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.float_video_window_voice, (ViewGroup) this.dED, true);
            this.dFb = this.dED.findViewById(w.h.lay_voice);
            this.dFe = (ImageView) this.dFb.findViewById(w.h.arrow_voice_icon);
            this.dFd = (SeekBar) this.dFb.findViewById(w.h.show_voice_seekbar);
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
            if (c.this.flp != null) {
                c.this.flp.onStart();
            }
            if (c.this.cPv && c.this.dEU) {
                if (!c.this.bDx.isPlaying() && c.this.bDA.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bDA.setVisibility(8);
                    c.this.flh.setVisibility(8);
                    c.this.flg.setVisibility(8);
                    c.this.fli.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.ad(f2);
                        }
                    } else {
                        c.this.c(f, true);
                    }
                } else {
                    if (c.this.cPv) {
                        c.this.aBf();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dFh = c.this.bDx.getCurrentPosition();
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
            if (c.this.flq != null) {
                c.this.flq.aSZ();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.dEU) {
                if (c.this.akS == 2) {
                    c.this.aSQ();
                    return super.onSingleTapConfirmed(motionEvent);
                }
                c.this.bbQ();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBf() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dED.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dED.setSystemUiVisibility(4);
        } else {
            this.dED.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f2) {
        if (!this.dEU) {
            this.mStatus = 0;
            return;
        }
        aBd();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dFn == 0) {
            if (f2 > 0.0f && this.dFm < this.dFg) {
                this.dFm++;
            }
            if (f2 < 0.0f && this.dFm > 0) {
                this.dFm--;
            }
        }
        if (this.mProgress > 0) {
            this.dFe.setImageResource(w.g.icon_shengyin_open);
        } else {
            this.dFe.setImageResource(w.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dFm, 0);
        this.dFd.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dFh -= 1000;
                this.dFi = 1;
            } else {
                this.dFh += 1000;
                this.dFi = 2;
            }
            if (this.dFh < 0) {
                this.dFh = 0;
            } else if (this.dFh > this.bDx.getDuration()) {
                this.dFh = this.bDx.getDuration();
            }
        }
        aBd();
        String rm = this.dEF.rm(this.dFh);
        if (f2 > 0.0f) {
            this.dFf.setImageResource(w.g.icon_kuaitui);
        } else {
            this.dFf.setImageResource(w.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(rm)) {
            this.dFc.setText(new StringBuilder().append(rm).append("/").append(this.dEF.rm(this.bDx.getDuration())));
        }
        this.dEF.B(this.dFh, z ? false : true);
        this.dEM.setVisibility(8);
        this.fle.setVisibility(0);
        bbN();
    }

    protected View s(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void aSQ() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            com.baidu.adp.lib.util.k.F(this.aat.getPageActivity(), this.aat.getString(w.l.neterror));
        } else if (this.bDx.isPlaying()) {
            pausePlay();
        } else if (this.dEU) {
            aBq();
            if (this.eKt != null) {
                this.eKt.aTa();
            }
        } else {
            bbP();
        }
    }

    public void aBg() {
        this.dFp = true;
        if (this.biw != null) {
            this.biw.aBg();
        }
    }

    public boolean rl(int i) {
        switch (i) {
            case 4:
                if (this.cPv) {
                    aBg();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dFg <= 0 || this.dFd == null) {
                    return false;
                }
                this.dFm = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dFm * 100.0d) / this.dFg);
                this.dFd.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView VP() {
        return this.bDx;
    }

    public VideoListMediaControllerView aBh() {
        return this.dEF;
    }

    public void show() {
        this.dED.setVisibility(0);
    }

    public void aBl() {
        if (this.dEO != null) {
            ViewGroup.LayoutParams layoutParams = this.dEO.getLayoutParams();
            this.dEI = (FrameLayout.LayoutParams) this.dED.getLayoutParams();
            this.dEI.width = layoutParams.width;
            this.dEI.height = layoutParams.height;
            this.dEI.topMargin = 0;
            this.dED.setLayoutParams(this.dEI);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dFp) {
            if (this.cPv) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11711"));
            }
        } else {
            this.dFp = false;
        }
        if (configuration.orientation == 2) {
            this.cPv = true;
            this.dED.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dEM.setVisibility(0);
            this.bDz.setVisibility(0);
            this.dES.setVisibility(0);
            this.dET.setVisibility(0);
            this.dEH.setVisibility(8);
            if (this.fll != null) {
                this.fll.aBw();
            }
            this.dEL.setImageResource(w.g.icon_suoxiao);
            mY(this.dFl);
            aBf();
        } else {
            this.cPv = false;
            if (this.dEI != null) {
                this.dED.setLayoutParams(this.dEI);
            }
            b(baseActivity, false);
            this.bDz.setVisibility(8);
            this.dEH.setVisibility(0);
            if (this.fll != null) {
                this.fll.aBx();
            }
            if (this.akS == 3 && this.flm != null) {
                this.flm.jJ(false);
            } else if (!this.dEU && this.dEM != null) {
                this.dEM.clearAnimation();
                this.dEM.setVisibility(4);
                this.fle.setVisibility(0);
                if (this.flm != null) {
                    this.flm.aTb();
                }
            }
            aBc();
            this.dEL.setImageResource(w.g.icon_fangda);
            mY(0);
            this.dED.setSystemUiVisibility(0);
        }
        if (this.bDx.isPlaying()) {
            aBv();
        }
        bbN();
    }

    private void bbN() {
        if (this.bDx != null) {
            int af = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity());
            if (this.cPv) {
                af = com.baidu.adp.lib.util.k.ag(this.aat.getPageActivity());
            }
            this.fle.setMax(af);
            int duration = this.bDx.getDuration();
            if (duration > 0) {
                if (this.flg.getVisibility() == 0) {
                    this.fle.setProgress(this.fle.getMax());
                } else {
                    this.fle.setProgress((int) ((this.bDx.getCurrentPosition() * this.fle.getMax()) / duration));
                }
            }
        }
    }

    private void mY(int i) {
        if (this.dEF != null && (this.dEF.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dEF.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dEF.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.fld.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.cSw.getVisibility() == 0) {
                this.fld.setVisibility(0);
            }
        }
    }

    public boolean aBn() {
        return !this.cPv;
    }

    public void a(v.b bVar) {
        this.flk = bVar;
    }

    public void aBo() {
        this.dEK.setImageResource(w.g.icon_video_midpause);
        this.cSw.setVisibility(8);
        this.fld.setVisibility(8);
        this.bDA.setVisibility(0);
        this.flh.setVisibility(8);
        this.flg.setVisibility(8);
        this.fli.setVisibility(8);
        this.akS = 2;
        this.bDx.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.akS = 0;
        this.bDx.setRecoveryState(0);
        setVideoUrl(str);
        this.bDx.setVideoPath(str);
        this.bDx.start();
        this.cSw.setVisibility(0);
        if (this.cPv) {
            this.fld.setVisibility(8);
        } else {
            this.fld.setVisibility(0);
        }
        this.dEP.setVisibility(0);
        this.bDA.setVisibility(8);
        this.dEK.setImageResource(w.g.icon_video_midplay);
        this.flh.setVisibility(8);
        this.flg.setVisibility(8);
        this.fli.setVisibility(8);
        this.bDE.setVisibility(8);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFt);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.dFt, TbConfig.USE_TIME_INTERVAL);
    }

    public void aBq() {
        this.akS = 1;
        this.bDx.setRecoveryState(1);
        this.bDx.start();
        this.dEK.setImageResource(w.g.icon_video_midplay);
        this.dEP.setVisibility(8);
        this.dEG.setVisibility(8);
        this.cSw.setVisibility(8);
        this.fld.setVisibility(8);
        this.dEF.showProgress();
        this.bDA.setVisibility(8);
        this.flh.setVisibility(8);
        this.flg.setVisibility(8);
        this.fli.setVisibility(8);
        bbS();
    }

    public void kX(boolean z) {
        if (this.bDx != null) {
            this.bDx.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bDx.isPlaying()) {
            ba.bco().ar(this.mVideoUrl, this.bDx.getCurrentPosition());
        }
        bbR();
        this.bDx.pause();
        aBo();
    }

    public void stopPlay() {
        if (this.bDx.isPlaying()) {
            ba.bco().ar(this.mVideoUrl, this.bDx.getCurrentPosition());
        }
        this.akS = 5;
        this.bDx.setRecoveryState(5);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFr);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFt);
        this.bDx.stopPlayback();
        this.dEU = false;
        this.dEZ = 0;
        anL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY(boolean z) {
        if (this.dEM != null) {
            this.dEG.setVisibility(0);
            this.bDA.setVisibility(0);
            this.flh.setVisibility(8);
            this.flg.setVisibility(8);
            this.fli.setVisibility(8);
            this.cSw.setVisibility(8);
            this.fld.setVisibility(8);
            this.dEK.setImageResource(w.g.icon_video_midpause);
            this.dEM.setVisibility(4);
            this.fle.setVisibility(8);
            this.bDE.setVisibility(8);
            this.dEF.KR();
            this.dEP.setVisibility(z ? 0 : 8);
        }
    }

    public void anL() {
        kY(true);
    }

    public boolean bbO() {
        if (this.bDx == null) {
            return false;
        }
        return this.bDx.isPlaying();
    }

    public void a(f fVar) {
        this.flo = fVar;
    }

    public void a(e eVar) {
        this.eKt = eVar;
    }

    public void a(d dVar) {
        this.fln = dVar;
    }

    public void pj(String str) {
        this.eKb = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbP() {
        qb(this.mVideoUrl);
    }

    public void b(InterfaceC0081c interfaceC0081c) {
        this.flm = interfaceC0081c;
    }

    public void qb(String str) {
        if (com.baidu.adp.lib.util.i.hl()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aat.getPageActivity());
                aVar.cI(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
                aVar.a(w.l.editor_dialog_yes, new j(this, str));
                aVar.b(w.l.editor_dialog_no, new k(this));
                aVar.b(this.aat).ta();
                return;
            }
            if (!this.flb) {
                this.flb = true;
                com.baidu.adp.lib.util.k.showToast(this.aat.getPageActivity(), w.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void mJ(String str) {
        this.dEP.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFx);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFr);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFt);
        this.biw.stop();
        this.dFo.unregister(this.aat.getPageActivity());
    }

    public void qc(String str) {
        this.dET.setText(str);
    }

    public void bS(long j) {
        this.flc.setText(com.baidu.tbadk.core.util.aw.t(j));
    }

    public boolean aBr() {
        return this.dEU;
    }

    public void clearAnimation() {
        aBu();
    }

    public void aBs() {
        if (this.dEM != null) {
            aBu();
            this.dEM.setVisibility(0);
            this.flf.setVisibility(0);
            if (this.flm != null) {
                this.flm.jJ(true);
            }
            this.fle.setVisibility(8);
            this.dEX.setAnimationListener(this.dFv);
            this.dEM.startAnimation(this.dEX);
            this.dEW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbQ() {
        if (this.dEM != null) {
            if (this.dEM.getVisibility() == 0) {
                aBu();
                this.dEM.setVisibility(8);
                this.fle.setVisibility(0);
                if (this.flm != null) {
                    this.flm.aTb();
                    return;
                }
                return;
            }
            aBv();
        }
    }

    public void aBt() {
        if (this.dEM != null) {
            aBu();
            this.dEM.setVisibility(0);
            this.flf.setVisibility(0);
            if (this.flm != null) {
                this.flm.jJ(false);
            }
            this.fle.setVisibility(8);
            this.dEp.setAnimationListener(this.dFw);
            this.dEM.startAnimation(this.dEp);
        }
    }

    public void bbR() {
        if (this.dEM != null) {
            aBu();
            this.dEM.setVisibility(0);
            this.flf.setVisibility(0);
            this.fle.setVisibility(8);
            if (this.flm != null) {
                this.flm.jJ(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.dEM != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFx);
            this.dEp.setAnimationListener(null);
            this.dEX.setAnimationListener(null);
            this.dEM.clearAnimation();
            this.dEW = false;
        }
    }

    public void aBv() {
        aBt();
        bbS();
    }

    private void bbS() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dFx);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.dFx, 3000L);
    }

    public void a(b bVar) {
        this.fll = bVar;
    }

    public void na(int i) {
        if (this.bDx.getDuration() - i <= 3000) {
            aBu();
            if (this.dEM != null) {
                this.dEM.setVisibility(0);
                this.flf.setVisibility(0);
                this.fle.setVisibility(8);
                if (this.flm != null) {
                    this.flm.jJ(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dEZ = i;
    }

    public void kZ(boolean z) {
        if (this.biw != null) {
            if (this.dEL != null) {
                this.dEL.setVisibility(z ? 0 : 8);
            }
            this.biw.la(z);
        }
    }

    public int bw(Context context) {
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

    public int bbT() {
        return this.akS;
    }

    public void a(h hVar) {
        this.flq = hVar;
    }
}
