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
    private static int duJ;
    private static boolean eTK = false;
    private QuickVideoView aTb;
    private View aTd;
    private ImageView aTe;
    private View aTj;
    private TbPageContext<?> aaX;
    private View cIH;
    private Animation dtK;
    protected View dtY;
    private ImageView duA;
    private int duB;
    private ao duG;
    private int duH;
    private int duI;
    private CallStateReceiver duK;
    private VideoListMediaControllerView dua;
    private View dub;
    private FrameLayout duc;
    protected FrameLayout.LayoutParams dud;
    private ImageView duf;
    private ImageView dug;
    private View duh;
    private View duj;
    private TbImageView duk;
    private v.d dul;
    private ImageView dun;
    private TextView duo;
    private Animation dus;
    private View duv;
    private View duw;
    private TextView dux;
    private SeekBar duy;
    private ImageView duz;
    private TextView eTM;
    private View eTN;
    private ProgressBar eTO;
    private View eTP;
    private TextView eTQ;
    private TextView eTR;
    private TextView eTS;
    private v.a eTT;
    private v.b eTU;
    private b eTV;
    private InterfaceC0070c eTW;
    private d eTX;
    private f eTY;
    private g eTZ;
    private e euX;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean eTL = false;
    protected boolean cFE = false;
    private boolean dup = false;
    private boolean dur = false;
    private int duu = 0;
    private int mStatus = 0;
    private int duC = 0;
    private int duD = 0;
    private boolean duL = false;
    private String euR = null;
    private int akR = -1;
    private v.d aQI = new com.baidu.tieba.play.d(this);
    private Runnable duN = new l(this);
    private v.a aQH = new m(this);
    private v.b duO = new n(this);
    private Runnable duP = new o(this);
    private QuickVideoView.b aTt = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener duR = new r(this);
    private Animation.AnimationListener duS = new s(this);
    private Runnable duT = new com.baidu.tieba.play.e(this);
    private CustomMessageListener duU = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private au.b dxz = new com.baidu.tieba.play.g(this);
    private SeekBar.OnSeekBarChangeListener aWY = new h(this);

    /* loaded from: classes.dex */
    public interface b {
        void ayG();

        void ayH();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070c {
        void aPw();

        void jd(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aPx();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aPv();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aPy();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.duH = 0;
        if (tbPageContext != null) {
            this.aaX = tbPageContext;
            this.dtY = u(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dtY);
            }
            this.duj = view;
            this.dtY.setOnClickListener(this.mOnClickListener);
            this.aTb = (QuickVideoView) this.dtY.findViewById(w.h.videoView);
            this.cIH = this.dtY.findViewById(w.h.video_list_layout_loading);
            this.eTN = this.dtY.findViewById(w.h.layout_play_count);
            this.eTM = (TextView) this.dtY.findViewById(w.h.play_count);
            this.dua = (VideoListMediaControllerView) this.dtY.findViewById(w.h.media_controller);
            this.dua.setPlayer(this.aTb);
            this.eTO = (ProgressBar) this.dtY.findViewById(w.h.pgrBottomProgress);
            this.eTO.setMax(com.baidu.adp.lib.util.k.af(this.aaX.getPageActivity()));
            this.eTO.setProgress(0);
            this.dua.setOnSeekBarChangeListener(this.aWY);
            this.dua.setOnProgressUpdatedListener(this.dxz);
            this.dub = this.dtY.findViewById(w.h.black_mask);
            this.aTj = this.dtY.findViewById(w.h.layout_error);
            this.aTj.setOnClickListener(this.mOnClickListener);
            this.duc = (FrameLayout) this.dtY.findViewById(w.h.danmu_container);
            this.duf = (ImageView) this.dtY.findViewById(w.h.img_play_icon);
            this.duf.setOnClickListener(this.mOnClickListener);
            this.dug = (ImageView) this.dtY.findViewById(w.h.img_full_screen);
            this.dug.setOnClickListener(this.mOnClickListener);
            this.duh = this.dtY.findViewById(w.h.layout_media_controller);
            this.eTP = this.dtY.findViewById(w.h.time_show_controller);
            this.aTb.setOnPreparedListener(this.aQI);
            this.aTb.setOnCompletionListener(this.aQH);
            this.aTb.setOnErrorListener(this.duO);
            this.aTb.setOnSurfaceDestroyedListener(this.aTt);
            this.aTe = (ImageView) this.dtY.findViewById(w.h.img_play);
            this.aTe.setOnClickListener(this.mOnClickListener);
            this.eTQ = (TextView) this.dtY.findViewById(w.h.txt_replay);
            this.eTQ.setOnClickListener(this.mOnClickListener);
            this.eTR = (TextView) this.dtY.findViewById(w.h.txt_playnext);
            this.eTR.setOnClickListener(this.mOnClickListener);
            this.eTS = (TextView) this.dtY.findViewById(w.h.txt_next_video_title);
            this.duk = (TbImageView) this.dtY.findViewById(w.h.video_thumbnail);
            this.duk.setDefaultErrorResource(0);
            this.duk.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.af(this.aaX.getPageActivity());
            this.mScreenHeight = bz(this.aaX.getPageActivity());
            this.dun = (ImageView) this.dtY.findViewById(w.h.img_exit);
            this.dun.setOnClickListener(this.mOnClickListener);
            this.duo = (TextView) this.dtY.findViewById(w.h.video_title);
            this.aTd = this.dtY.findViewById(w.h.layout_title);
            this.aTd.setVisibility(8);
            this.dus = AnimationUtils.loadAnimation(this.aaX.getPageActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dtK = AnimationUtils.loadAnimation(this.aaX.getPageActivity(), w.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aaX.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.duB = this.mAudioManager.getStreamMaxVolume(3);
            this.duI = this.mAudioManager.getStreamVolume(3);
            duJ = 100 / this.duB;
            this.dtY.setOnTouchListener(new i(this));
            this.duG = new ao(this.aaX.getPageActivity());
            this.duG.start();
            this.duH = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds16);
            this.duK = new CallStateReceiver();
            this.duK.register(this.aaX.getPageActivity());
            this.aaX.registerListener(this.duU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aym() {
        this.mStatus = 0;
        if (this.duv != null && this.duv.getParent() != null && (this.duv.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.duv.getParent()).removeView(this.duv);
                this.duv = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.duw != null && this.duw.getParent() != null && (this.duw.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.duw.getParent()).removeView(this.duw);
                this.duw = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ayn() {
        if (this.mStatus == 1) {
            if (this.duv == null && this.dtY != null && (this.dtY instanceof ViewGroup)) {
                LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.float_video_window_jindu, (ViewGroup) this.dtY, true);
                this.duv = this.dtY.findViewById(w.h.lay_jindu);
                this.dux = (TextView) this.duv.findViewById(w.h.show_time);
                this.duA = (ImageView) this.duv.findViewById(w.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.duw == null && this.dtY != null && (this.dtY instanceof ViewGroup)) {
            LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.float_video_window_voice, (ViewGroup) this.dtY, true);
            this.duw = this.dtY.findViewById(w.h.lay_voice);
            this.duz = (ImageView) this.duw.findViewById(w.h.arrow_voice_icon);
            this.duy = (SeekBar) this.duw.findViewById(w.h.show_voice_seekbar);
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
            if (c.this.eTZ != null) {
                c.this.eTZ.onStart();
            }
            if (c.this.dup) {
                if (!c.this.aTb.isPlaying() && c.this.aTe.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aTe.setVisibility(8);
                    c.this.eTR.setVisibility(8);
                    c.this.eTQ.setVisibility(8);
                    c.this.eTS.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.Z(f2);
                        }
                    } else {
                        c.this.b(f, true);
                    }
                } else {
                    if (c.this.cFE) {
                        c.this.ayp();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.duC = c.this.aTb.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.Z(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayp() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dtY.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dtY.setSystemUiVisibility(4);
        } else {
            this.dtY.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f2) {
        if (!this.dup) {
            this.mStatus = 0;
            return;
        }
        ayn();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % duJ == 0) {
            if (f2 > 0.0f && this.duI < this.duB) {
                this.duI++;
            }
            if (f2 < 0.0f && this.duI > 0) {
                this.duI--;
            }
        }
        if (this.mProgress > 0) {
            this.duz.setImageResource(w.g.icon_shengyin_open);
        } else {
            this.duz.setImageResource(w.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.duI, 0);
        this.duy.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.duC -= 1000;
                this.duD = 1;
            } else {
                this.duC += 1000;
                this.duD = 2;
            }
            if (this.duC < 0) {
                this.duC = 0;
            } else if (this.duC > this.aTb.getDuration()) {
                this.duC = this.aTb.getDuration();
            }
        }
        ayn();
        String qy = this.dua.qy(this.duC);
        if (f2 > 0.0f) {
            this.duA.setImageResource(w.g.icon_kuaitui);
        } else {
            this.duA.setImageResource(w.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(qy)) {
            this.dux.setText(new StringBuilder().append(qy).append("/").append(this.dua.qy(this.aTb.getDuration())));
        }
        this.dua.D(this.duC, z ? false : true);
        this.duh.setVisibility(8);
        this.eTO.setVisibility(0);
        aXL();
    }

    protected View u(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void aPu() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            com.baidu.adp.lib.util.k.E(this.aaX.getPageActivity(), this.aaX.getString(w.l.neterror));
        } else if (this.aTb.isPlaying()) {
            pausePlay();
        } else if (this.dup) {
            ayA();
            if (this.euX != null) {
                this.euX.aPv();
            }
        } else {
            aXN();
        }
    }

    public void ayq() {
        this.duL = true;
        if (this.duG != null) {
            this.duG.ayq();
        }
    }

    public boolean qv(int i) {
        switch (i) {
            case 4:
                if (this.cFE) {
                    ayq();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.duB <= 0 || this.duy == null) {
                    return false;
                }
                this.duI = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.duI * 100.0d) / this.duB);
                this.duy.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView Lg() {
        return this.aTb;
    }

    public VideoListMediaControllerView ayr() {
        return this.dua;
    }

    public View ays() {
        return this.duh;
    }

    public void show() {
        this.dtY.setVisibility(0);
    }

    public void ayv() {
        if (this.duj != null) {
            ViewGroup.LayoutParams layoutParams = this.duj.getLayoutParams();
            this.dud = (FrameLayout.LayoutParams) this.dtY.getLayoutParams();
            this.dud.width = layoutParams.width;
            this.dud.height = layoutParams.height;
            this.dud.topMargin = 0;
            this.dtY.setLayoutParams(this.dud);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.duL) {
            if (this.cFE) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11711"));
            }
        } else {
            this.duL = false;
        }
        if (configuration.orientation == 2) {
            this.cFE = true;
            this.dtY.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.duh.setVisibility(0);
            this.aTd.setVisibility(0);
            this.dun.setVisibility(0);
            this.duo.setVisibility(0);
            this.duc.setVisibility(8);
            if (this.eTV != null) {
                this.eTV.ayG();
            }
            this.dug.setImageResource(w.g.icon_suoxiao);
            mz(this.duH);
            ayp();
        } else {
            this.cFE = false;
            if (this.dud != null) {
                this.dtY.setLayoutParams(this.dud);
            }
            b(baseActivity, false);
            this.aTd.setVisibility(8);
            this.duc.setVisibility(0);
            if (this.eTV != null) {
                this.eTV.ayH();
            }
            if (this.akR == 3 && this.eTW != null) {
                this.eTW.jd(false);
            } else if (!this.dup && this.duh != null) {
                this.duh.clearAnimation();
                this.duh.setVisibility(4);
                this.eTO.setVisibility(0);
                if (this.eTW != null) {
                    this.eTW.aPw();
                }
            }
            aym();
            this.dug.setImageResource(w.g.icon_fangda);
            mz(0);
            this.dtY.setSystemUiVisibility(0);
        }
        if (this.aTb.isPlaying()) {
            ayF();
        }
        aXL();
    }

    private void aXL() {
        if (this.aTb != null) {
            int af = com.baidu.adp.lib.util.k.af(this.aaX.getPageActivity());
            if (this.cFE) {
                af = com.baidu.adp.lib.util.k.ag(this.aaX.getPageActivity());
            }
            this.eTO.setMax(af);
            if (this.aTb.getDuration() > 0) {
                if (this.eTQ.getVisibility() == 0) {
                    this.eTO.setProgress(this.eTO.getMax());
                } else {
                    this.eTO.setProgress((int) ((this.aTb.getCurrentPosition() * this.eTO.getMax()) / this.aTb.getDuration()));
                }
            }
        }
    }

    private void mz(int i) {
        if (this.dua != null && (this.dua.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dua.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dua.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.eTN.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.cIH.getVisibility() == 0) {
                this.eTN.setVisibility(0);
            }
        }
    }

    public boolean ayx() {
        return !this.cFE;
    }

    public void a(v.b bVar) {
        this.eTU = bVar;
    }

    public void ayy() {
        this.duf.setImageResource(w.g.icon_video_midpause);
        this.cIH.setVisibility(8);
        this.eTN.setVisibility(8);
        this.aTe.setVisibility(0);
        this.eTR.setVisibility(8);
        this.eTQ.setVisibility(8);
        this.eTS.setVisibility(8);
        this.akR = 2;
        this.aTb.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.akR = 0;
        this.aTb.setRecoveryState(0);
        setVideoUrl(str);
        this.aTb.setVideoPath(str);
        this.aTb.start();
        this.cIH.setVisibility(0);
        if (this.cFE) {
            this.eTN.setVisibility(8);
        } else {
            this.eTN.setVisibility(0);
        }
        this.duk.setVisibility(0);
        this.aTe.setVisibility(8);
        this.duf.setImageResource(w.g.icon_video_midplay);
        this.eTR.setVisibility(8);
        this.eTQ.setVisibility(8);
        this.eTS.setVisibility(8);
        this.aTj.setVisibility(8);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duP);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.duP, TbConfig.USE_TIME_INTERVAL);
    }

    public void ayA() {
        this.akR = 1;
        this.aTb.setRecoveryState(1);
        this.aTb.start();
        this.duf.setImageResource(w.g.icon_video_midplay);
        this.duk.setVisibility(8);
        this.dub.setVisibility(8);
        this.cIH.setVisibility(8);
        this.eTN.setVisibility(8);
        this.dua.showProgress();
        this.aTe.setVisibility(8);
        this.eTR.setVisibility(8);
        this.eTQ.setVisibility(8);
        this.eTS.setVisibility(8);
        aXR();
    }

    public void km(boolean z) {
        if (this.aTb != null) {
            this.aTb.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.aTb.isPlaying()) {
            az.aYm().ap(this.mVideoUrl, this.aTb.getCurrentPosition());
        }
        aXP();
        this.aTb.pause();
        ayy();
    }

    public void stopPlay() {
        if (this.aTb.isPlaying()) {
            az.aYm().ap(this.mVideoUrl, this.aTb.getCurrentPosition());
        }
        this.akR = 5;
        this.aTb.setRecoveryState(5);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duN);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duP);
        this.aTb.stopPlayback();
        this.dup = false;
        this.duu = 0;
        alk();
    }

    public void alk() {
        if (this.duh != null) {
            this.dub.setVisibility(0);
            this.aTe.setVisibility(0);
            this.eTR.setVisibility(8);
            this.eTQ.setVisibility(8);
            this.eTS.setVisibility(8);
            this.cIH.setVisibility(8);
            this.eTN.setVisibility(8);
            this.duf.setImageResource(w.g.icon_video_midpause);
            this.duh.setVisibility(4);
            this.eTO.setVisibility(8);
            this.aTj.setVisibility(8);
            this.dua.Mk();
            this.duk.setVisibility(0);
        }
    }

    public boolean aXM() {
        if (this.aTb == null) {
            return false;
        }
        return this.aTb.isPlaying();
    }

    public void a(g gVar) {
        this.eTZ = gVar;
    }

    public void a(f fVar) {
        this.eTY = fVar;
    }

    public void a(e eVar) {
        this.euX = eVar;
    }

    public void a(d dVar) {
        this.eTX = dVar;
    }

    public void nS(String str) {
        this.euR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXN() {
        oR(this.mVideoUrl);
    }

    public void b(InterfaceC0070c interfaceC0070c) {
        this.eTW = interfaceC0070c;
    }

    public void oR(String str) {
        if (com.baidu.adp.lib.util.i.hl()) {
            if (!eTK) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaX.getPageActivity());
                aVar.cE(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
                aVar.a(w.l.confirm, new j(this, str));
                aVar.b(w.l.cancel, new k(this));
                aVar.b(this.aaX).tQ();
                return;
            }
            if (!this.eTL) {
                this.eTL = true;
                com.baidu.adp.lib.util.k.showToast(this.aaX.getPageActivity(), w.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void lx(String str) {
        this.duk.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duT);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duN);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duP);
        this.duG.stop();
        this.duK.unregister(this.aaX.getPageActivity());
    }

    public void oS(String str) {
        this.duo.setText(str);
    }

    public void bQ(long j) {
        this.eTM.setText(com.baidu.tbadk.core.util.au.t(j));
    }

    public boolean ayB() {
        return this.dup;
    }

    public void ayC() {
        if (this.duh != null) {
            ayE();
            this.duh.setVisibility(0);
            this.eTP.setVisibility(0);
            if (this.eTW != null) {
                this.eTW.jd(true);
            }
            this.eTO.setVisibility(8);
            this.dus.setAnimationListener(this.duR);
            this.duh.startAnimation(this.dus);
            this.dur = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXO() {
        if (this.duh != null) {
            if (this.duh.getVisibility() == 0) {
                ayE();
                this.duh.setVisibility(8);
                this.eTO.setVisibility(0);
                if (this.eTW != null) {
                    this.eTW.aPw();
                    return;
                }
                return;
            }
            ayF();
        }
    }

    public void ayD() {
        if (this.duh != null) {
            ayE();
            this.duh.setVisibility(0);
            this.eTP.setVisibility(0);
            if (this.eTW != null) {
                this.eTW.jd(false);
            }
            this.eTO.setVisibility(8);
            this.dtK.setAnimationListener(this.duS);
            this.duh.startAnimation(this.dtK);
        }
    }

    public void aXP() {
        if (this.duh != null) {
            ayE();
            this.duh.setVisibility(0);
            this.eTP.setVisibility(0);
            this.eTO.setVisibility(8);
            if (this.eTW != null) {
                this.eTW.jd(false);
            }
        }
    }

    public void aXQ() {
        if (this.duh != null) {
            this.dtK.cancel();
            this.dus.cancel();
            ayE();
            this.duh.setVisibility(4);
            this.eTP.setVisibility(4);
            this.eTO.setVisibility(8);
            if (this.eTW != null) {
                this.eTW.jd(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayE() {
        if (this.duh != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duT);
            this.dtK.setAnimationListener(null);
            this.dus.setAnimationListener(null);
            this.duh.clearAnimation();
            this.dur = false;
        }
    }

    public void ayF() {
        ayD();
        aXR();
    }

    private void aXR() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.duT);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.duT, 3000L);
    }

    public void a(b bVar) {
        this.eTV = bVar;
    }

    public void mB(int i) {
        if (this.aTb.getDuration() - i <= 3000) {
            ayE();
            if (this.duh != null) {
                this.duh.setVisibility(0);
                this.eTP.setVisibility(0);
                this.eTO.setVisibility(8);
                if (this.eTW != null) {
                    this.eTW.jd(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.duu = i;
    }

    public void kn(boolean z) {
        if (this.duG != null) {
            this.duG.kp(z);
        }
    }

    public int bz(Context context) {
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

    public int aXS() {
        return this.akR;
    }
}
