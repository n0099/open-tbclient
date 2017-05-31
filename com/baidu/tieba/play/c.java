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
    private static int dwA;
    private TbPageContext<?> aas;
    private QuickVideoView bCE;
    private View bCG;
    private ImageView bCH;
    private View bCL;
    private ap bfy;
    private View cKz;
    private Animation dvC;
    protected View dvQ;
    private VideoListMediaControllerView dvS;
    private View dvT;
    private FrameLayout dvU;
    protected FrameLayout.LayoutParams dvV;
    private ImageView dvX;
    private ImageView dvY;
    private View dvZ;
    private CallStateReceiver dwB;
    private View dwb;
    private TbImageView dwc;
    private v.d dwd;
    private ImageView dwf;
    private TextView dwg;
    private Animation dwk;
    private View dwn;
    private View dwo;
    private TextView dwp;
    private SeekBar dwq;
    private ImageView dwr;
    private ImageView dws;
    private int dwt;
    private int dwy;
    private int dwz;
    private e eAV;
    private TextView faM;
    private View faN;
    private ProgressBar faO;
    private View faP;
    private TextView faQ;
    private TextView faR;
    private TextView faS;
    private v.a faT;
    private v.b faU;
    private b faV;
    private InterfaceC0078c faW;
    private d faX;
    private f faY;
    private g faZ;
    private h fba;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean faL = false;
    protected boolean cHz = false;
    private boolean dwh = false;
    private boolean dwj = false;
    private int dwm = 0;
    private int mStatus = 0;
    private int dwu = 0;
    private int dwv = 0;
    private boolean dwC = false;
    private String eAD = null;
    private int akf = -1;
    private v.d aRe = new com.baidu.tieba.play.d(this);
    private Runnable dwE = new l(this);
    private v.a aRd = new m(this);
    private v.b dwF = new n(this);
    private Runnable dwG = new o(this);
    private QuickVideoView.b bAV = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener dwI = new r(this);
    private Animation.AnimationListener dwJ = new s(this);
    private Runnable dwK = new com.baidu.tieba.play.e(this);
    private CustomMessageListener dwL = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private av.b dzw = new com.baidu.tieba.play.g(this);
    private SeekBar.OnSeekBarChangeListener aUZ = new com.baidu.tieba.play.h(this);

    /* loaded from: classes.dex */
    public interface b {
        void axx();

        void axy();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078c {
        void aPc();

        void jl(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aPd();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aPb();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aOZ();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface h {
        void aPa();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dwy = 0;
        if (tbPageContext != null) {
            this.aas = tbPageContext;
            this.dvQ = s(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dvQ);
            }
            this.dwb = view;
            this.dvQ.setOnClickListener(this.mOnClickListener);
            this.bCE = (QuickVideoView) this.dvQ.findViewById(w.h.videoView);
            this.cKz = this.dvQ.findViewById(w.h.video_list_layout_loading);
            this.faN = this.dvQ.findViewById(w.h.layout_play_count);
            this.faM = (TextView) this.dvQ.findViewById(w.h.play_count);
            this.dvS = (VideoListMediaControllerView) this.dvQ.findViewById(w.h.media_controller);
            this.dvS.setPlayer(this.bCE);
            this.faO = (ProgressBar) this.dvQ.findViewById(w.h.pgrBottomProgress);
            this.faO.setMax(com.baidu.adp.lib.util.k.af(this.aas.getPageActivity()));
            this.faO.setProgress(0);
            this.dvS.setOnSeekBarChangeListener(this.aUZ);
            this.dvS.setOnProgressUpdatedListener(this.dzw);
            this.dvT = this.dvQ.findViewById(w.h.black_mask);
            this.bCL = this.dvQ.findViewById(w.h.layout_error);
            this.bCL.setOnClickListener(this.mOnClickListener);
            this.dvU = (FrameLayout) this.dvQ.findViewById(w.h.danmu_container);
            this.dvX = (ImageView) this.dvQ.findViewById(w.h.img_play_icon);
            this.dvX.setOnClickListener(this.mOnClickListener);
            this.dvY = (ImageView) this.dvQ.findViewById(w.h.img_full_screen);
            this.dvY.setOnClickListener(this.mOnClickListener);
            this.dvZ = this.dvQ.findViewById(w.h.layout_media_controller);
            this.faP = this.dvQ.findViewById(w.h.time_show_controller);
            this.bCE.setOnPreparedListener(this.aRe);
            this.bCE.setOnCompletionListener(this.aRd);
            this.bCE.setOnErrorListener(this.dwF);
            this.bCE.setOnSurfaceDestroyedListener(this.bAV);
            this.bCH = (ImageView) this.dvQ.findViewById(w.h.img_play);
            this.bCH.setOnClickListener(this.mOnClickListener);
            this.faQ = (TextView) this.dvQ.findViewById(w.h.txt_replay);
            this.faQ.setOnClickListener(this.mOnClickListener);
            this.faR = (TextView) this.dvQ.findViewById(w.h.txt_playnext);
            this.faR.setOnClickListener(this.mOnClickListener);
            this.faS = (TextView) this.dvQ.findViewById(w.h.txt_next_video_title);
            this.dwc = (TbImageView) this.dvQ.findViewById(w.h.video_thumbnail);
            this.dwc.setDefaultErrorResource(0);
            this.dwc.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.af(this.aas.getPageActivity());
            this.mScreenHeight = bC(this.aas.getPageActivity());
            this.dwf = (ImageView) this.dvQ.findViewById(w.h.img_exit);
            this.dwf.setOnClickListener(this.mOnClickListener);
            this.dwg = (TextView) this.dvQ.findViewById(w.h.video_title);
            this.bCG = this.dvQ.findViewById(w.h.layout_title);
            this.bCG.setVisibility(8);
            this.dwk = AnimationUtils.loadAnimation(this.aas.getPageActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dvC = AnimationUtils.loadAnimation(this.aas.getPageActivity(), w.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aas.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dwt = this.mAudioManager.getStreamMaxVolume(3);
            this.dwz = this.mAudioManager.getStreamVolume(3);
            dwA = 100 / this.dwt;
            this.dvQ.setOnTouchListener(new i(this));
            this.bfy = new ap(this.aas.getPageActivity());
            this.bfy.start();
            this.dwy = com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds16);
            this.dwB = new CallStateReceiver();
            this.dwB.register(this.aas.getPageActivity());
            this.aas.registerListener(this.dwL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axd() {
        this.mStatus = 0;
        if (this.dwn != null && this.dwn.getParent() != null && (this.dwn.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dwn.getParent()).removeView(this.dwn);
                this.dwn = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dwo != null && this.dwo.getParent() != null && (this.dwo.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dwo.getParent()).removeView(this.dwo);
                this.dwo = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void axe() {
        if (this.mStatus == 1) {
            if (this.dwn == null && this.dvQ != null && (this.dvQ instanceof ViewGroup)) {
                LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.float_video_window_jindu, (ViewGroup) this.dvQ, true);
                this.dwn = this.dvQ.findViewById(w.h.lay_jindu);
                this.dwp = (TextView) this.dwn.findViewById(w.h.show_time);
                this.dws = (ImageView) this.dwn.findViewById(w.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dwo == null && this.dvQ != null && (this.dvQ instanceof ViewGroup)) {
            LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.float_video_window_voice, (ViewGroup) this.dvQ, true);
            this.dwo = this.dvQ.findViewById(w.h.lay_voice);
            this.dwr = (ImageView) this.dwo.findViewById(w.h.arrow_voice_icon);
            this.dwq = (SeekBar) this.dwo.findViewById(w.h.show_voice_seekbar);
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
            if (c.this.faZ != null) {
                c.this.faZ.onStart();
            }
            if (c.this.cHz && c.this.dwh) {
                if (!c.this.bCE.isPlaying() && c.this.bCH.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.bCH.setVisibility(8);
                    c.this.faR.setVisibility(8);
                    c.this.faQ.setVisibility(8);
                    c.this.faS.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.X(f2);
                        }
                    } else {
                        c.this.c(f, true);
                    }
                } else {
                    if (c.this.cHz) {
                        c.this.axg();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dwu = c.this.bCE.getCurrentPosition();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.X(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.fba != null) {
                c.this.fba.aPa();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axg() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dvQ.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dvQ.setSystemUiVisibility(4);
        } else {
            this.dvQ.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(float f2) {
        if (!this.dwh) {
            this.mStatus = 0;
            return;
        }
        axe();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dwA == 0) {
            if (f2 > 0.0f && this.dwz < this.dwt) {
                this.dwz++;
            }
            if (f2 < 0.0f && this.dwz > 0) {
                this.dwz--;
            }
        }
        if (this.mProgress > 0) {
            this.dwr.setImageResource(w.g.icon_shengyin_open);
        } else {
            this.dwr.setImageResource(w.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dwz, 0);
        this.dwq.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dwu -= 1000;
                this.dwv = 1;
            } else {
                this.dwu += 1000;
                this.dwv = 2;
            }
            if (this.dwu < 0) {
                this.dwu = 0;
            } else if (this.dwu > this.bCE.getDuration()) {
                this.dwu = this.bCE.getDuration();
            }
        }
        axe();
        String qT = this.dvS.qT(this.dwu);
        if (f2 > 0.0f) {
            this.dws.setImageResource(w.g.icon_kuaitui);
        } else {
            this.dws.setImageResource(w.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(qT)) {
            this.dwp.setText(new StringBuilder().append(qT).append("/").append(this.dvS.qT(this.bCE.getDuration())));
        }
        this.dvS.B(this.dwu, z ? false : true);
        this.dvZ.setVisibility(8);
        this.faO.setVisibility(0);
        aXC();
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

    public void aOR() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.E(this.aas.getPageActivity(), this.aas.getString(w.l.neterror));
        } else if (this.bCE.isPlaying()) {
            pausePlay();
        } else if (this.dwh) {
            axr();
            if (this.eAV != null) {
                this.eAV.aPb();
            }
        } else {
            aXE();
        }
    }

    public void axh() {
        this.dwC = true;
        if (this.bfy != null) {
            this.bfy.axh();
        }
    }

    public boolean qS(int i) {
        switch (i) {
            case 4:
                if (this.cHz) {
                    axh();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dwt <= 0 || this.dwq == null) {
                    return false;
                }
                this.dwz = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dwz * 100.0d) / this.dwt);
                this.dwq.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView Uy() {
        return this.bCE;
    }

    public VideoListMediaControllerView axi() {
        return this.dvS;
    }

    public void show() {
        this.dvQ.setVisibility(0);
    }

    public void axm() {
        if (this.dwb != null) {
            ViewGroup.LayoutParams layoutParams = this.dwb.getLayoutParams();
            this.dvV = (FrameLayout.LayoutParams) this.dvQ.getLayoutParams();
            this.dvV.width = layoutParams.width;
            this.dvV.height = layoutParams.height;
            this.dvV.topMargin = 0;
            this.dvQ.setLayoutParams(this.dvV);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dwC) {
            if (this.cHz) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11711"));
            }
        } else {
            this.dwC = false;
        }
        if (configuration.orientation == 2) {
            this.cHz = true;
            this.dvQ.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dvZ.setVisibility(0);
            this.bCG.setVisibility(0);
            this.dwf.setVisibility(0);
            this.dwg.setVisibility(0);
            this.dvU.setVisibility(8);
            if (this.faV != null) {
                this.faV.axx();
            }
            this.dvY.setImageResource(w.g.icon_suoxiao);
            mM(this.dwy);
            axg();
        } else {
            this.cHz = false;
            if (this.dvV != null) {
                this.dvQ.setLayoutParams(this.dvV);
            }
            b(baseActivity, false);
            this.bCG.setVisibility(8);
            this.dvU.setVisibility(0);
            if (this.faV != null) {
                this.faV.axy();
            }
            if (this.akf == 3 && this.faW != null) {
                this.faW.jl(false);
            } else if (!this.dwh && this.dvZ != null) {
                this.dvZ.clearAnimation();
                this.dvZ.setVisibility(4);
                this.faO.setVisibility(0);
                if (this.faW != null) {
                    this.faW.aPc();
                }
            }
            axd();
            this.dvY.setImageResource(w.g.icon_fangda);
            mM(0);
            this.dvQ.setSystemUiVisibility(0);
        }
        if (this.bCE.isPlaying()) {
            axw();
        }
        aXC();
    }

    private void aXC() {
        if (this.bCE != null) {
            int af = com.baidu.adp.lib.util.k.af(this.aas.getPageActivity());
            if (this.cHz) {
                af = com.baidu.adp.lib.util.k.ag(this.aas.getPageActivity());
            }
            this.faO.setMax(af);
            int duration = this.bCE.getDuration();
            if (duration > 0) {
                if (this.faQ.getVisibility() == 0) {
                    this.faO.setProgress(this.faO.getMax());
                } else {
                    this.faO.setProgress((int) ((this.bCE.getCurrentPosition() * this.faO.getMax()) / duration));
                }
            }
        }
    }

    private void mM(int i) {
        if (this.dvS != null && (this.dvS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dvS.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dvS.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.faN.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.cKz.getVisibility() == 0) {
                this.faN.setVisibility(0);
            }
        }
    }

    public boolean axo() {
        return !this.cHz;
    }

    public void a(v.b bVar) {
        this.faU = bVar;
    }

    public void axp() {
        this.dvX.setImageResource(w.g.icon_video_midpause);
        this.cKz.setVisibility(8);
        this.faN.setVisibility(8);
        this.bCH.setVisibility(0);
        this.faR.setVisibility(8);
        this.faQ.setVisibility(8);
        this.faS.setVisibility(8);
        this.akf = 2;
        this.bCE.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.akf = 0;
        this.bCE.setRecoveryState(0);
        setVideoUrl(str);
        this.bCE.setVideoPath(str);
        this.bCE.start();
        this.cKz.setVisibility(0);
        if (this.cHz) {
            this.faN.setVisibility(8);
        } else {
            this.faN.setVisibility(0);
        }
        this.dwc.setVisibility(0);
        this.bCH.setVisibility(8);
        this.dvX.setImageResource(w.g.icon_video_midplay);
        this.faR.setVisibility(8);
        this.faQ.setVisibility(8);
        this.faS.setVisibility(8);
        this.bCL.setVisibility(8);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwG);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.dwG, TbConfig.USE_TIME_INTERVAL);
    }

    public void axr() {
        this.akf = 1;
        this.bCE.setRecoveryState(1);
        this.bCE.start();
        this.dvX.setImageResource(w.g.icon_video_midplay);
        this.dwc.setVisibility(8);
        this.dvT.setVisibility(8);
        this.cKz.setVisibility(8);
        this.faN.setVisibility(8);
        this.dvS.showProgress();
        this.bCH.setVisibility(8);
        this.faR.setVisibility(8);
        this.faQ.setVisibility(8);
        this.faS.setVisibility(8);
        aXH();
    }

    public void kx(boolean z) {
        if (this.bCE != null) {
            this.bCE.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bCE.isPlaying()) {
            ba.aYd().aq(this.mVideoUrl, this.bCE.getCurrentPosition());
        }
        aXG();
        this.bCE.pause();
        axp();
    }

    public void stopPlay() {
        if (this.bCE.isPlaying()) {
            ba.aYd().aq(this.mVideoUrl, this.bCE.getCurrentPosition());
        }
        this.akf = 5;
        this.bCE.setRecoveryState(5);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwE);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwG);
        this.bCE.stopPlayback();
        this.dwh = false;
        this.dwm = 0;
        aka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(boolean z) {
        if (this.dvZ != null) {
            this.dvT.setVisibility(0);
            this.bCH.setVisibility(0);
            this.faR.setVisibility(8);
            this.faQ.setVisibility(8);
            this.faS.setVisibility(8);
            this.cKz.setVisibility(8);
            this.faN.setVisibility(8);
            this.dvX.setImageResource(w.g.icon_video_midpause);
            this.dvZ.setVisibility(4);
            this.faO.setVisibility(8);
            this.bCL.setVisibility(8);
            this.dvS.Kt();
            this.dwc.setVisibility(z ? 0 : 8);
        }
    }

    public void aka() {
        ky(true);
    }

    public boolean aXD() {
        if (this.bCE == null) {
            return false;
        }
        return this.bCE.isPlaying();
    }

    public void a(f fVar) {
        this.faY = fVar;
    }

    public void a(e eVar) {
        this.eAV = eVar;
    }

    public void a(d dVar) {
        this.faX = dVar;
    }

    public void oo(String str) {
        this.eAD = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXE() {
        pe(this.mVideoUrl);
    }

    public void b(InterfaceC0078c interfaceC0078c) {
        this.faW = interfaceC0078c;
    }

    public void pe(String str) {
        if (com.baidu.adp.lib.util.i.hm()) {
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (date.getYear() != date2.getYear() || date.getMonth() != date2.getMonth() || date.getDay() != date2.getDay()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aas.getPageActivity());
                aVar.cB(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
                aVar.a(w.l.editor_dialog_yes, new j(this, str));
                aVar.b(w.l.editor_dialog_no, new k(this));
                aVar.b(this.aas).tc();
                return;
            }
            if (!this.faL) {
                this.faL = true;
                com.baidu.adp.lib.util.k.showToast(this.aas.getPageActivity(), w.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void lM(String str) {
        this.dwc.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwK);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwE);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwG);
        this.bfy.stop();
        this.dwB.unregister(this.aas.getPageActivity());
    }

    public void pf(String str) {
        this.dwg.setText(str);
    }

    public void bE(long j) {
        this.faM.setText(com.baidu.tbadk.core.util.au.t(j));
    }

    public boolean axs() {
        return this.dwh;
    }

    public void clearAnimation() {
        axv();
    }

    public void axt() {
        if (this.dvZ != null) {
            axv();
            this.dvZ.setVisibility(0);
            this.faP.setVisibility(0);
            if (this.faW != null) {
                this.faW.jl(true);
            }
            this.faO.setVisibility(8);
            this.dwk.setAnimationListener(this.dwI);
            this.dvZ.startAnimation(this.dwk);
            this.dwj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXF() {
        if (this.dvZ != null) {
            if (this.dvZ.getVisibility() == 0) {
                axv();
                this.dvZ.setVisibility(8);
                this.faO.setVisibility(0);
                if (this.faW != null) {
                    this.faW.aPc();
                    return;
                }
                return;
            }
            axw();
        }
    }

    public void axu() {
        if (this.dvZ != null) {
            axv();
            this.dvZ.setVisibility(0);
            this.faP.setVisibility(0);
            if (this.faW != null) {
                this.faW.jl(false);
            }
            this.faO.setVisibility(8);
            this.dvC.setAnimationListener(this.dwJ);
            this.dvZ.startAnimation(this.dvC);
        }
    }

    public void aXG() {
        if (this.dvZ != null) {
            axv();
            this.dvZ.setVisibility(0);
            this.faP.setVisibility(0);
            this.faO.setVisibility(8);
            if (this.faW != null) {
                this.faW.jl(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axv() {
        if (this.dvZ != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwK);
            this.dvC.setAnimationListener(null);
            this.dwk.setAnimationListener(null);
            this.dvZ.clearAnimation();
            this.dwj = false;
        }
    }

    public void axw() {
        axu();
        aXH();
    }

    private void aXH() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dwK);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.dwK, 3000L);
    }

    public void a(b bVar) {
        this.faV = bVar;
    }

    public void mO(int i) {
        if (this.bCE.getDuration() - i <= 3000) {
            axv();
            if (this.dvZ != null) {
                this.dvZ.setVisibility(0);
                this.faP.setVisibility(0);
                this.faO.setVisibility(8);
                if (this.faW != null) {
                    this.faW.jl(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dwm = i;
    }

    public void kz(boolean z) {
        if (this.bfy != null) {
            if (this.dvY != null) {
                this.dvY.setVisibility(z ? 0 : 8);
            }
            this.bfy.kA(z);
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

    public int aXI() {
        return this.akf;
    }

    public void a(h hVar) {
        this.fba = hVar;
    }
}
