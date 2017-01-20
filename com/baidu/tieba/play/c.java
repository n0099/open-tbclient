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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private static int dvO;
    private static boolean eSh = false;
    private TbPageContext<?> Fp;
    private QuickVideoView aMY;
    private View aNa;
    private ImageView aNc;
    private View aNh;
    private String aOm;
    private WindowManager bC;
    private View bQI;
    private TbImageView bQJ;
    private TextView bQK;
    private View bQO;
    private View duX;
    private Animation dut;
    private View dvA;
    private View dvB;
    private TextView dvC;
    private SeekBar dvD;
    private ImageView dvE;
    private ImageView dvF;
    private int dvG;
    private ao dvL;
    private int dvM;
    private int dvN;
    private CallStateReceiver dvP;
    protected View dvf;
    private VideoListMediaControllerView dvh;
    private FrameLayout dvi;
    protected FrameLayout.LayoutParams dvj;
    private ImageView dvl;
    private ImageView dvm;
    private View dvo;
    private v.d dvp;
    private v.a dvq;
    private v.b dvs;
    private ImageView dvt;
    private Animation dvx;
    private TextView eSj;
    private View eSk;
    private ProgressBar eSl;
    private View eSm;
    private TextView eSn;
    private TextView eSo;
    private TextView eSp;
    private b eSq;
    private InterfaceC0072c eSr;
    private d eSs;
    private f eSt;
    private e etz;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean eSi = false;
    private int dvn = 0;
    protected boolean cFI = false;
    private boolean dvu = false;
    private boolean dvv = false;
    private boolean dvw = false;
    private int dvz = 0;
    private int mStatus = 0;
    private int dvH = 0;
    private int dvI = 0;
    private boolean dvQ = false;
    private String etw = null;
    private int afl = -1;
    private v.d aKH = new com.baidu.tieba.play.d(this);
    private Runnable dvS = new l(this);
    private v.a aKG = new m(this);
    private v.b dvT = new n(this);
    private Runnable dvU = new o(this);
    private QuickVideoView.b aNr = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener dvW = new r(this);
    private Animation.AnimationListener dvX = new s(this);
    private Runnable dvY = new com.baidu.tieba.play.e(this);
    private CustomMessageListener dvZ = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private au.b dyt = new g(this);
    private SeekBar.OnSeekBarChangeListener duN = new h(this);

    /* loaded from: classes.dex */
    public interface b {
        void azE();

        void azF();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072c {
        void aOr();

        void iZ(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aPL();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aPK();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aPM();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dvM = 0;
        if (tbPageContext != null) {
            this.Fp = tbPageContext;
            this.dvf = r(tbPageContext);
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dvf);
            }
            this.dvo = view;
            this.dvf.setOnClickListener(this.mOnClickListener);
            this.aMY = (QuickVideoView) this.dvf.findViewById(r.h.videoView);
            this.bQO = this.dvf.findViewById(r.h.video_list_layout_loading);
            this.eSk = this.dvf.findViewById(r.h.layout_play_count);
            this.eSj = (TextView) this.dvf.findViewById(r.h.play_count);
            this.dvh = (VideoListMediaControllerView) this.dvf.findViewById(r.h.media_controller);
            this.dvh.setPlayer(this.aMY);
            this.eSl = (ProgressBar) this.dvf.findViewById(r.h.pgrBottomProgress);
            this.eSl.setMax(com.baidu.adp.lib.util.k.I(this.Fp.getPageActivity()));
            this.eSl.setProgress(0);
            this.dvh.setOnSeekBarChangeListener(this.duN);
            this.dvh.setOnProgressUpdatedListener(this.dyt);
            this.bQI = this.dvf.findViewById(r.h.black_mask);
            this.aNh = this.dvf.findViewById(r.h.layout_error);
            this.aNh.setOnClickListener(this.mOnClickListener);
            this.dvi = (FrameLayout) this.dvf.findViewById(r.h.danmu_container);
            this.dvl = (ImageView) this.dvf.findViewById(r.h.img_play_icon);
            this.dvl.setOnClickListener(this.mOnClickListener);
            this.dvm = (ImageView) this.dvf.findViewById(r.h.img_full_screen);
            this.dvm.setOnClickListener(this.mOnClickListener);
            this.duX = this.dvf.findViewById(r.h.layout_media_controller);
            this.eSm = this.dvf.findViewById(r.h.time_show_controller);
            this.aMY.setOnPreparedListener(this.aKH);
            this.aMY.setOnCompletionListener(this.aKG);
            this.aMY.setOnErrorListener(this.dvT);
            this.aMY.setOnSurfaceDestroyedListener(this.aNr);
            this.aNc = (ImageView) this.dvf.findViewById(r.h.img_play);
            this.aNc.setOnClickListener(this.mOnClickListener);
            this.eSn = (TextView) this.dvf.findViewById(r.h.txt_replay);
            this.eSn.setOnClickListener(this.mOnClickListener);
            this.eSo = (TextView) this.dvf.findViewById(r.h.txt_playnext);
            this.eSo.setOnClickListener(this.mOnClickListener);
            this.eSp = (TextView) this.dvf.findViewById(r.h.txt_next_video_title);
            this.bQJ = (TbImageView) this.dvf.findViewById(r.h.video_thumbnail);
            this.bQJ.setDefaultErrorResource(0);
            this.bQJ.setDefaultBgResource(r.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.I(this.Fp.getPageActivity());
            this.mScreenHeight = bh(this.Fp.getPageActivity());
            this.dvt = (ImageView) this.dvf.findViewById(r.h.img_exit);
            this.dvt.setOnClickListener(this.mOnClickListener);
            this.bQK = (TextView) this.dvf.findViewById(r.h.video_title);
            this.aNa = this.dvf.findViewById(r.h.layout_title);
            this.aNa.setVisibility(8);
            this.dvx = AnimationUtils.loadAnimation(this.Fp.getPageActivity(), r.a.anim_alpha_1_to_0_duration_2000);
            this.dut = AnimationUtils.loadAnimation(this.Fp.getPageActivity(), r.a.anim_alpha_0_to_1_duration_200);
            this.bC = (WindowManager) this.Fp.getPageActivity().getSystemService("window");
            this.mGestureDetector = new GestureDetector(this.Fp.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getContext().getSystemService("audio");
            this.dvG = this.mAudioManager.getStreamMaxVolume(3);
            this.dvN = this.mAudioManager.getStreamVolume(3);
            dvO = 100 / this.dvG;
            this.dvf.setOnTouchListener(new i(this));
            this.dvL = new ao(this.Fp.getPageActivity());
            this.dvL.start();
            this.dvM = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds16);
            this.dvP = new CallStateReceiver();
            this.dvP.register(this.Fp.getPageActivity());
            this.Fp.registerListener(this.dvZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azm() {
        this.mStatus = 0;
        if (this.dvA != null && this.dvA.getParent() != null) {
            try {
                this.bC.removeView(this.dvA);
                this.dvA = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dvB != null && this.dvB.getParent() != null) {
            try {
                this.bC.removeView(this.dvB);
                this.dvB = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void azn() {
        if (this.mStatus == 1) {
            if (this.dvA == null) {
                this.dvA = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.float_video_window_jindu, (ViewGroup) null);
                this.dvC = (TextView) this.dvA.findViewById(r.h.show_time);
                this.dvF = (ImageView) this.dvA.findViewById(r.h.arrow_icon);
            }
            if (this.dvA.getParent() == null) {
                this.bC.addView(this.dvA, ags());
            }
        } else if (this.mStatus == 2) {
            if (this.dvB == null) {
                this.dvB = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.float_video_window_voice, (ViewGroup) null);
                this.dvE = (ImageView) this.dvB.findViewById(r.h.arrow_voice_icon);
                this.dvD = (SeekBar) this.dvB.findViewById(r.h.show_voice_seekbar);
            }
            if (this.dvB.getParent() == null) {
                this.bC.addView(this.dvB, ags());
            }
        }
    }

    private WindowManager.LayoutParams ags() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 17;
        return layoutParams;
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
            if (c.this.cFI && c.this.dvu) {
                if (!c.this.aMY.isPlaying() && c.this.aNc.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aNc.setVisibility(8);
                    c.this.eSo.setVisibility(8);
                    c.this.eSn.setVisibility(8);
                    c.this.eSp.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.ab(f2);
                        }
                    } else {
                        c.this.b(f, true);
                    }
                } else {
                    c.this.azo();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dvH = c.this.aMY.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ab(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azo() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dvf.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dvf.setSystemUiVisibility(4);
        } else {
            this.dvf.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(float f2) {
        if (!this.dvu) {
            this.mStatus = 0;
            return;
        }
        azn();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dvO == 0) {
            if (f2 > 0.0f && this.dvN < this.dvG) {
                this.dvN++;
            }
            if (f2 < 0.0f && this.dvN > 0) {
                this.dvN--;
            }
        }
        if (this.dvN > 0) {
            this.dvE.setImageResource(r.g.icon_shengyin_open);
        } else {
            this.dvE.setImageResource(r.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dvN, 0);
        this.dvD.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dvH -= 1000;
                this.dvI = 1;
            } else {
                this.dvH += 1000;
                this.dvI = 2;
            }
            if (this.dvH < 0) {
                this.dvH = 0;
            } else if (this.dvH > this.aMY.getDuration()) {
                this.dvH = this.aMY.getDuration();
            }
        }
        azn();
        String qD = this.dvh.qD(this.dvH);
        if (f2 > 0.0f) {
            this.dvF.setImageResource(r.g.icon_kuaitui);
        } else {
            this.dvF.setImageResource(r.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(qD)) {
            this.dvC.setText(new StringBuilder().append(qD).append("/").append(this.dvh.qD(this.aMY.getDuration())));
        }
        this.dvh.C(this.dvH, z ? false : true);
        this.duX.setVisibility(8);
        this.eSl.setVisibility(0);
        aXZ();
    }

    protected View r(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.aOm = str;
    }

    public void azp() {
        this.dvQ = true;
        if (this.dvL != null) {
            this.dvL.azp();
        }
    }

    public boolean aXY() {
        if (this.cFI) {
            azp();
            return true;
        }
        return false;
    }

    public QuickVideoView Kb() {
        return this.aMY;
    }

    public VideoListMediaControllerView azq() {
        return this.dvh;
    }

    public void hide() {
        this.dvf.setVisibility(8);
    }

    public void show() {
        this.dvf.setVisibility(0);
    }

    public void azu() {
        if (this.dvo != null) {
            ViewGroup.LayoutParams layoutParams = this.dvo.getLayoutParams();
            this.dvj = (FrameLayout.LayoutParams) this.dvf.getLayoutParams();
            this.dvj.width = layoutParams.width;
            this.dvj.height = layoutParams.height;
            this.dvj.topMargin = 0;
            this.dvf.setLayoutParams(this.dvj);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dvQ) {
            if (this.cFI) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11711"));
            }
        } else {
            this.dvQ = false;
        }
        if (configuration.orientation == 2) {
            this.cFI = true;
            this.dvf.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.duX.setVisibility(0);
            this.aNa.setVisibility(0);
            this.dvt.setVisibility(0);
            this.bQK.setVisibility(0);
            this.dvi.setVisibility(8);
            if (this.eSq != null) {
                this.eSq.azE();
            }
            this.dvm.setImageResource(r.g.icon_suoxiao);
            mL(this.dvM);
            azo();
        } else {
            this.cFI = false;
            if (this.dvj != null) {
                this.dvf.setLayoutParams(this.dvj);
            }
            b(baseActivity, false);
            this.aNa.setVisibility(8);
            this.dvi.setVisibility(0);
            if (this.eSq != null) {
                this.eSq.azF();
            }
            if (this.afl == 3 && this.eSr != null) {
                this.eSr.iZ(false);
            } else if (!this.dvu && this.duX != null) {
                this.duX.clearAnimation();
                this.duX.setVisibility(4);
                this.eSl.setVisibility(0);
                if (this.eSr != null) {
                    this.eSr.aOr();
                }
            }
            azm();
            this.dvm.setImageResource(r.g.icon_fangda);
            mL(0);
            this.dvf.setSystemUiVisibility(0);
        }
        if (this.aMY.isPlaying()) {
            azD();
        }
        aXZ();
    }

    private void aXZ() {
        if (this.aMY != null) {
            int I = com.baidu.adp.lib.util.k.I(this.Fp.getPageActivity());
            if (this.cFI) {
                I = com.baidu.adp.lib.util.k.J(this.Fp.getPageActivity());
            }
            this.eSl.setMax(I);
            if (this.aMY.getDuration() > 0) {
                if (this.eSn.getVisibility() == 0) {
                    this.eSl.setProgress(this.eSl.getMax());
                } else {
                    this.eSl.setProgress((this.aMY.getCurrentPosition() * this.eSl.getMax()) / this.aMY.getDuration());
                }
            }
        }
    }

    private void mL(int i) {
        if (this.dvh != null && (this.dvh.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dvh.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dvh.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.eSk.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.bQO.getVisibility() == 0) {
                this.eSk.setVisibility(0);
            }
        }
    }

    public boolean azw() {
        return !this.cFI;
    }

    public void a(v.a aVar) {
        this.dvq = aVar;
    }

    public void azx() {
        this.dvl.setImageResource(r.g.icon_video_midpause);
        this.bQO.setVisibility(8);
        this.eSk.setVisibility(8);
        this.aNc.setVisibility(0);
        this.eSo.setVisibility(8);
        this.eSn.setVisibility(8);
        this.eSp.setVisibility(8);
        this.afl = 2;
        this.aMY.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.afl = 0;
        this.aMY.setRecoveryState(0);
        setVideoUrl(str);
        this.aMY.setVideoPath(str);
        this.aMY.start();
        this.bQO.setVisibility(0);
        if (this.cFI) {
            this.eSk.setVisibility(8);
        } else {
            this.eSk.setVisibility(0);
        }
        this.bQJ.setVisibility(0);
        this.aNc.setVisibility(8);
        this.dvl.setImageResource(r.g.icon_video_midplay);
        this.eSo.setVisibility(8);
        this.eSn.setVisibility(8);
        this.eSp.setVisibility(8);
        this.aNh.setVisibility(8);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvU);
        com.baidu.adp.lib.g.h.eE().postDelayed(this.dvU, TbConfig.USE_TIME_INTERVAL);
    }

    public void amW() {
        this.afl = 1;
        this.aMY.setRecoveryState(1);
        this.aMY.start();
        this.dvl.setImageResource(r.g.icon_video_midplay);
        this.bQJ.setVisibility(8);
        this.bQI.setVisibility(8);
        this.bQO.setVisibility(8);
        this.eSk.setVisibility(8);
        this.dvh.showProgress();
        this.aNc.setVisibility(8);
        this.eSo.setVisibility(8);
        this.eSn.setVisibility(8);
        this.eSp.setVisibility(8);
        aYe();
    }

    public void kq(boolean z) {
        if (this.aMY != null) {
            this.aMY.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.aMY.isPlaying()) {
            az.aYy().aw(this.aOm, this.aMY.getCurrentPosition());
        }
        aYd();
        this.aMY.pause();
        azx();
    }

    public void stopPlay() {
        if (this.aMY.isPlaying()) {
            az.aYy().aw(this.aOm, this.aMY.getCurrentPosition());
        }
        this.afl = 5;
        this.aMY.setRecoveryState(5);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvS);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvU);
        this.aMY.stopPlayback();
        this.dvu = false;
        this.dvz = 0;
        amd();
    }

    public void amd() {
        if (this.duX != null) {
            this.bQI.setVisibility(0);
            this.aNc.setVisibility(0);
            this.eSo.setVisibility(8);
            this.eSn.setVisibility(8);
            this.eSp.setVisibility(8);
            this.bQO.setVisibility(8);
            this.eSk.setVisibility(8);
            this.dvl.setImageResource(r.g.icon_video_midpause);
            this.duX.setVisibility(4);
            this.eSl.setVisibility(8);
            this.aNh.setVisibility(8);
            this.dvh.anc();
            this.bQJ.setVisibility(0);
        }
    }

    public boolean aYa() {
        if (this.aMY == null) {
            return false;
        }
        return this.aMY.isPlaying();
    }

    public void a(f fVar) {
        this.eSt = fVar;
    }

    public void a(e eVar) {
        this.etz = eVar;
    }

    public void a(d dVar) {
        this.eSs = dVar;
    }

    public void oG(String str) {
        this.etw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYb() {
        pB(this.aOm);
    }

    public void b(InterfaceC0072c interfaceC0072c) {
        this.eSr = interfaceC0072c;
    }

    public void pB(String str) {
        if (com.baidu.adp.lib.util.i.gm()) {
            if (!eSh) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Fp.getPageActivity());
                aVar.cE(TbadkCoreApplication.m9getInst().getString(r.l.play_video_mobile_tip));
                aVar.a(r.l.confirm, new j(this, str));
                aVar.b(r.l.cancel, new k(this));
                aVar.b(this.Fp).sV();
                return;
            }
            if (!this.eSi) {
                this.eSi = true;
                com.baidu.adp.lib.util.k.showToast(this.Fp.getPageActivity(), r.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void lS(String str) {
        this.bQJ.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvY);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvS);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvU);
        this.dvL.stop();
        this.dvP.unregister(this.Fp.getPageActivity());
    }

    public void pC(String str) {
        this.bQK.setText(str);
    }

    public void bP(long j) {
        this.eSj.setText(com.baidu.tbadk.core.util.at.u(j));
    }

    public boolean azz() {
        return this.dvu;
    }

    public void azA() {
        if (this.duX != null) {
            azC();
            this.duX.setVisibility(0);
            this.eSm.setVisibility(0);
            if (this.eSr != null) {
                this.eSr.iZ(true);
            }
            this.eSl.setVisibility(8);
            this.dvx.setAnimationListener(this.dvW);
            this.duX.startAnimation(this.dvx);
            this.dvw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYc() {
        if (this.duX != null) {
            if (this.duX.getVisibility() == 0) {
                azC();
                this.duX.setVisibility(8);
                this.eSl.setVisibility(0);
                if (this.eSr != null) {
                    this.eSr.aOr();
                    return;
                }
                return;
            }
            azD();
        }
    }

    public void azB() {
        if (this.duX != null) {
            azC();
            this.duX.setVisibility(0);
            this.eSm.setVisibility(0);
            if (this.eSr != null) {
                this.eSr.iZ(false);
            }
            this.eSl.setVisibility(8);
            this.dut.setAnimationListener(this.dvX);
            this.duX.startAnimation(this.dut);
            this.dvv = true;
        }
    }

    public void aYd() {
        if (this.duX != null) {
            azC();
            this.duX.setVisibility(0);
            this.eSm.setVisibility(0);
            this.eSl.setVisibility(8);
            if (this.eSr != null) {
                this.eSr.iZ(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azC() {
        if (this.duX != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvY);
            this.dut.setAnimationListener(null);
            this.dvx.setAnimationListener(null);
            this.duX.clearAnimation();
            this.dvw = false;
            this.dvv = false;
        }
    }

    public void azD() {
        azB();
        aYe();
    }

    private void aYe() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dvY);
        com.baidu.adp.lib.g.h.eE().postDelayed(this.dvY, 3000L);
    }

    public void a(b bVar) {
        this.eSq = bVar;
    }

    public void mN(int i) {
        if (this.aMY.getDuration() - i <= 3000) {
            azC();
            if (this.duX != null) {
                this.duX.setVisibility(0);
                this.eSm.setVisibility(0);
                this.eSl.setVisibility(8);
                if (this.eSr != null) {
                    this.eSr.iZ(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dvz = i;
    }

    public boolean isShow() {
        return this.dvf.getVisibility() == 0;
    }

    public void kr(boolean z) {
        if (this.dvL != null) {
            this.dvL.kt(z);
        }
    }

    public int bh(Context context) {
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
            return com.baidu.adp.lib.util.k.J(context);
        }
        return i;
    }

    public int aYf() {
        return this.afl;
    }
}
