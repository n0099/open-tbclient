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
    private static int dwZ;
    private static boolean eWa = false;
    private QuickVideoView aTd;
    private View aTf;
    private ImageView aTg;
    private View aTl;
    private TbPageContext<?> aaY;
    private ao bed;
    private View cKY;
    private View dwA;
    private TbImageView dwB;
    private v.d dwC;
    private ImageView dwE;
    private TextView dwF;
    private Animation dwJ;
    private View dwM;
    private View dwN;
    private TextView dwO;
    private SeekBar dwP;
    private ImageView dwQ;
    private ImageView dwR;
    private int dwS;
    private int dwX;
    private int dwY;
    private Animation dwb;
    protected View dwp;
    private VideoListMediaControllerView dwr;
    private View dws;
    private FrameLayout dwt;
    protected FrameLayout.LayoutParams dwu;
    private ImageView dww;
    private ImageView dwx;
    private View dwy;
    private CallStateReceiver dxa;
    private TextView eWc;
    private View eWd;
    private ProgressBar eWe;
    private View eWf;
    private TextView eWg;
    private TextView eWh;
    private TextView eWi;
    private v.a eWj;
    private v.b eWk;
    private b eWl;
    private InterfaceC0070c eWm;
    private d eWn;
    private f eWo;
    private g eWp;
    private e exn;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private boolean eWb = false;
    protected boolean cHV = false;
    private boolean dwG = false;
    private boolean dwI = false;
    private int dwL = 0;
    private int mStatus = 0;
    private int dwT = 0;
    private int dwU = 0;
    private boolean dxb = false;
    private String exh = null;
    private int akS = -1;
    private v.d aQK = new com.baidu.tieba.play.d(this);
    private Runnable dxd = new l(this);
    private v.a aQJ = new m(this);
    private v.b dxe = new n(this);
    private Runnable dxf = new o(this);
    private QuickVideoView.b aTv = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener dxh = new r(this);
    private Animation.AnimationListener dxi = new s(this);
    private Runnable dxj = new com.baidu.tieba.play.e(this);
    private CustomMessageListener dxk = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private au.b dzP = new com.baidu.tieba.play.g(this);
    private SeekBar.OnSeekBarChangeListener aXb = new h(this);

    /* loaded from: classes.dex */
    public interface b {
        void azH();

        void azI();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070c {
        void aQx();

        void jn(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aQy();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aQw();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aQz();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dwX = 0;
        if (tbPageContext != null) {
            this.aaY = tbPageContext;
            this.dwp = u(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dwp);
            }
            this.dwA = view;
            this.dwp.setOnClickListener(this.mOnClickListener);
            this.aTd = (QuickVideoView) this.dwp.findViewById(w.h.videoView);
            this.cKY = this.dwp.findViewById(w.h.video_list_layout_loading);
            this.eWd = this.dwp.findViewById(w.h.layout_play_count);
            this.eWc = (TextView) this.dwp.findViewById(w.h.play_count);
            this.dwr = (VideoListMediaControllerView) this.dwp.findViewById(w.h.media_controller);
            this.dwr.setPlayer(this.aTd);
            this.eWe = (ProgressBar) this.dwp.findViewById(w.h.pgrBottomProgress);
            this.eWe.setMax(com.baidu.adp.lib.util.k.af(this.aaY.getPageActivity()));
            this.eWe.setProgress(0);
            this.dwr.setOnSeekBarChangeListener(this.aXb);
            this.dwr.setOnProgressUpdatedListener(this.dzP);
            this.dws = this.dwp.findViewById(w.h.black_mask);
            this.aTl = this.dwp.findViewById(w.h.layout_error);
            this.aTl.setOnClickListener(this.mOnClickListener);
            this.dwt = (FrameLayout) this.dwp.findViewById(w.h.danmu_container);
            this.dww = (ImageView) this.dwp.findViewById(w.h.img_play_icon);
            this.dww.setOnClickListener(this.mOnClickListener);
            this.dwx = (ImageView) this.dwp.findViewById(w.h.img_full_screen);
            this.dwx.setOnClickListener(this.mOnClickListener);
            this.dwy = this.dwp.findViewById(w.h.layout_media_controller);
            this.eWf = this.dwp.findViewById(w.h.time_show_controller);
            this.aTd.setOnPreparedListener(this.aQK);
            this.aTd.setOnCompletionListener(this.aQJ);
            this.aTd.setOnErrorListener(this.dxe);
            this.aTd.setOnSurfaceDestroyedListener(this.aTv);
            this.aTg = (ImageView) this.dwp.findViewById(w.h.img_play);
            this.aTg.setOnClickListener(this.mOnClickListener);
            this.eWg = (TextView) this.dwp.findViewById(w.h.txt_replay);
            this.eWg.setOnClickListener(this.mOnClickListener);
            this.eWh = (TextView) this.dwp.findViewById(w.h.txt_playnext);
            this.eWh.setOnClickListener(this.mOnClickListener);
            this.eWi = (TextView) this.dwp.findViewById(w.h.txt_next_video_title);
            this.dwB = (TbImageView) this.dwp.findViewById(w.h.video_thumbnail);
            this.dwB.setDefaultErrorResource(0);
            this.dwB.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.af(this.aaY.getPageActivity());
            this.mScreenHeight = bz(this.aaY.getPageActivity());
            this.dwE = (ImageView) this.dwp.findViewById(w.h.img_exit);
            this.dwE.setOnClickListener(this.mOnClickListener);
            this.dwF = (TextView) this.dwp.findViewById(w.h.video_title);
            this.aTf = this.dwp.findViewById(w.h.layout_title);
            this.aTf.setVisibility(8);
            this.dwJ = AnimationUtils.loadAnimation(this.aaY.getPageActivity(), w.a.anim_alpha_1_to_0_duration_2000_accelerate);
            this.dwb = AnimationUtils.loadAnimation(this.aaY.getPageActivity(), w.a.anim_alpha_0_to_1_duration_200_accelerate);
            this.mGestureDetector = new GestureDetector(this.aaY.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dwS = this.mAudioManager.getStreamMaxVolume(3);
            this.dwY = this.mAudioManager.getStreamVolume(3);
            dwZ = 100 / this.dwS;
            this.dwp.setOnTouchListener(new i(this));
            this.bed = new ao(this.aaY.getPageActivity());
            this.bed.start();
            this.dwX = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds16);
            this.dxa = new CallStateReceiver();
            this.dxa.register(this.aaY.getPageActivity());
            this.aaY.registerListener(this.dxk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azn() {
        this.mStatus = 0;
        if (this.dwM != null && this.dwM.getParent() != null && (this.dwM.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dwM.getParent()).removeView(this.dwM);
                this.dwM = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dwN != null && this.dwN.getParent() != null && (this.dwN.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dwN.getParent()).removeView(this.dwN);
                this.dwN = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void azo() {
        if (this.mStatus == 1) {
            if (this.dwM == null && this.dwp != null && (this.dwp instanceof ViewGroup)) {
                LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.float_video_window_jindu, (ViewGroup) this.dwp, true);
                this.dwM = this.dwp.findViewById(w.h.lay_jindu);
                this.dwO = (TextView) this.dwM.findViewById(w.h.show_time);
                this.dwR = (ImageView) this.dwM.findViewById(w.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dwN == null && this.dwp != null && (this.dwp instanceof ViewGroup)) {
            LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.float_video_window_voice, (ViewGroup) this.dwp, true);
            this.dwN = this.dwp.findViewById(w.h.lay_voice);
            this.dwQ = (ImageView) this.dwN.findViewById(w.h.arrow_voice_icon);
            this.dwP = (SeekBar) this.dwN.findViewById(w.h.show_voice_seekbar);
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
            if (c.this.eWp != null) {
                c.this.eWp.onStart();
            }
            if (c.this.dwG) {
                if (!c.this.aTd.isPlaying() && c.this.aTg.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aTg.setVisibility(8);
                    c.this.eWh.setVisibility(8);
                    c.this.eWg.setVisibility(8);
                    c.this.eWi.setVisibility(8);
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
                    if (c.this.cHV) {
                        c.this.azq();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dwT = c.this.aTd.getCurrentPosition();
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
    public void azq() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dwp.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dwp.setSystemUiVisibility(4);
        } else {
            this.dwp.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f2) {
        if (!this.dwG) {
            this.mStatus = 0;
            return;
        }
        azo();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dwZ == 0) {
            if (f2 > 0.0f && this.dwY < this.dwS) {
                this.dwY++;
            }
            if (f2 < 0.0f && this.dwY > 0) {
                this.dwY--;
            }
        }
        if (this.mProgress > 0) {
            this.dwQ.setImageResource(w.g.icon_shengyin_open);
        } else {
            this.dwQ.setImageResource(w.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dwY, 0);
        this.dwP.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dwT -= 1000;
                this.dwU = 1;
            } else {
                this.dwT += 1000;
                this.dwU = 2;
            }
            if (this.dwT < 0) {
                this.dwT = 0;
            } else if (this.dwT > this.aTd.getDuration()) {
                this.dwT = this.aTd.getDuration();
            }
        }
        azo();
        String qE = this.dwr.qE(this.dwT);
        if (f2 > 0.0f) {
            this.dwR.setImageResource(w.g.icon_kuaitui);
        } else {
            this.dwR.setImageResource(w.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(qE)) {
            this.dwO.setText(new StringBuilder().append(qE).append("/").append(this.dwr.qE(this.aTd.getDuration())));
        }
        this.dwr.D(this.dwT, z ? false : true);
        this.dwy.setVisibility(8);
        this.eWe.setVisibility(0);
        aYM();
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

    public void aQv() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            com.baidu.adp.lib.util.k.E(this.aaY.getPageActivity(), this.aaY.getString(w.l.neterror));
        } else if (this.aTd.isPlaying()) {
            pausePlay();
        } else if (this.dwG) {
            azB();
            if (this.exn != null) {
                this.exn.aQw();
            }
        } else {
            aYO();
        }
    }

    public void azr() {
        this.dxb = true;
        if (this.bed != null) {
            this.bed.azr();
        }
    }

    public boolean qB(int i) {
        switch (i) {
            case 4:
                if (this.cHV) {
                    azr();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dwS <= 0 || this.dwP == null) {
                    return false;
                }
                this.dwY = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dwY * 100.0d) / this.dwS);
                this.dwP.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView Lg() {
        return this.aTd;
    }

    public VideoListMediaControllerView azs() {
        return this.dwr;
    }

    public View azt() {
        return this.dwy;
    }

    public void show() {
        this.dwp.setVisibility(0);
    }

    public void azw() {
        if (this.dwA != null) {
            ViewGroup.LayoutParams layoutParams = this.dwA.getLayoutParams();
            this.dwu = (FrameLayout.LayoutParams) this.dwp.getLayoutParams();
            this.dwu.width = layoutParams.width;
            this.dwu.height = layoutParams.height;
            this.dwu.topMargin = 0;
            this.dwp.setLayoutParams(this.dwu);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dxb) {
            if (this.cHV) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11711"));
            }
        } else {
            this.dxb = false;
        }
        if (configuration.orientation == 2) {
            this.cHV = true;
            this.dwp.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dwy.setVisibility(0);
            this.aTf.setVisibility(0);
            this.dwE.setVisibility(0);
            this.dwF.setVisibility(0);
            this.dwt.setVisibility(8);
            if (this.eWl != null) {
                this.eWl.azH();
            }
            this.dwx.setImageResource(w.g.icon_suoxiao);
            mF(this.dwX);
            azq();
        } else {
            this.cHV = false;
            if (this.dwu != null) {
                this.dwp.setLayoutParams(this.dwu);
            }
            b(baseActivity, false);
            this.aTf.setVisibility(8);
            this.dwt.setVisibility(0);
            if (this.eWl != null) {
                this.eWl.azI();
            }
            if (this.akS == 3 && this.eWm != null) {
                this.eWm.jn(false);
            } else if (!this.dwG && this.dwy != null) {
                this.dwy.clearAnimation();
                this.dwy.setVisibility(4);
                this.eWe.setVisibility(0);
                if (this.eWm != null) {
                    this.eWm.aQx();
                }
            }
            azn();
            this.dwx.setImageResource(w.g.icon_fangda);
            mF(0);
            this.dwp.setSystemUiVisibility(0);
        }
        if (this.aTd.isPlaying()) {
            azG();
        }
        aYM();
    }

    private void aYM() {
        if (this.aTd != null) {
            int af = com.baidu.adp.lib.util.k.af(this.aaY.getPageActivity());
            if (this.cHV) {
                af = com.baidu.adp.lib.util.k.ag(this.aaY.getPageActivity());
            }
            this.eWe.setMax(af);
            if (this.aTd.getDuration() > 0) {
                if (this.eWg.getVisibility() == 0) {
                    this.eWe.setProgress(this.eWe.getMax());
                } else {
                    this.eWe.setProgress((int) ((this.aTd.getCurrentPosition() * this.eWe.getMax()) / this.aTd.getDuration()));
                }
            }
        }
    }

    private void mF(int i) {
        if (this.dwr != null && (this.dwr.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dwr.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dwr.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.eWd.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.cKY.getVisibility() == 0) {
                this.eWd.setVisibility(0);
            }
        }
    }

    public boolean azy() {
        return !this.cHV;
    }

    public void a(v.b bVar) {
        this.eWk = bVar;
    }

    public void azz() {
        this.dww.setImageResource(w.g.icon_video_midpause);
        this.cKY.setVisibility(8);
        this.eWd.setVisibility(8);
        this.aTg.setVisibility(0);
        this.eWh.setVisibility(8);
        this.eWg.setVisibility(8);
        this.eWi.setVisibility(8);
        this.akS = 2;
        this.aTd.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.akS = 0;
        this.aTd.setRecoveryState(0);
        setVideoUrl(str);
        this.aTd.setVideoPath(str);
        this.aTd.start();
        this.cKY.setVisibility(0);
        if (this.cHV) {
            this.eWd.setVisibility(8);
        } else {
            this.eWd.setVisibility(0);
        }
        this.dwB.setVisibility(0);
        this.aTg.setVisibility(8);
        this.dww.setImageResource(w.g.icon_video_midplay);
        this.eWh.setVisibility(8);
        this.eWg.setVisibility(8);
        this.eWi.setVisibility(8);
        this.aTl.setVisibility(8);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxf);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.dxf, TbConfig.USE_TIME_INTERVAL);
    }

    public void azB() {
        this.akS = 1;
        this.aTd.setRecoveryState(1);
        this.aTd.start();
        this.dww.setImageResource(w.g.icon_video_midplay);
        this.dwB.setVisibility(8);
        this.dws.setVisibility(8);
        this.cKY.setVisibility(8);
        this.eWd.setVisibility(8);
        this.dwr.showProgress();
        this.aTg.setVisibility(8);
        this.eWh.setVisibility(8);
        this.eWg.setVisibility(8);
        this.eWi.setVisibility(8);
        aYS();
    }

    public void kw(boolean z) {
        if (this.aTd != null) {
            this.aTd.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.aTd.isPlaying()) {
            az.aZn().ap(this.mVideoUrl, this.aTd.getCurrentPosition());
        }
        aYQ();
        this.aTd.pause();
        azz();
    }

    public void stopPlay() {
        if (this.aTd.isPlaying()) {
            az.aZn().ap(this.mVideoUrl, this.aTd.getCurrentPosition());
        }
        this.akS = 5;
        this.aTd.setRecoveryState(5);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxd);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxf);
        this.aTd.stopPlayback();
        this.dwG = false;
        this.dwL = 0;
        aml();
    }

    public void aml() {
        if (this.dwy != null) {
            this.dws.setVisibility(0);
            this.aTg.setVisibility(0);
            this.eWh.setVisibility(8);
            this.eWg.setVisibility(8);
            this.eWi.setVisibility(8);
            this.cKY.setVisibility(8);
            this.eWd.setVisibility(8);
            this.dww.setImageResource(w.g.icon_video_midpause);
            this.dwy.setVisibility(4);
            this.eWe.setVisibility(8);
            this.aTl.setVisibility(8);
            this.dwr.Mk();
            this.dwB.setVisibility(0);
        }
    }

    public boolean aYN() {
        if (this.aTd == null) {
            return false;
        }
        return this.aTd.isPlaying();
    }

    public void a(g gVar) {
        this.eWp = gVar;
    }

    public void a(f fVar) {
        this.eWo = fVar;
    }

    public void a(e eVar) {
        this.exn = eVar;
    }

    public void a(d dVar) {
        this.eWn = dVar;
    }

    public void nT(String str) {
        this.exh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYO() {
        oS(this.mVideoUrl);
    }

    public void b(InterfaceC0070c interfaceC0070c) {
        this.eWm = interfaceC0070c;
    }

    public void oS(String str) {
        if (com.baidu.adp.lib.util.i.hm()) {
            if (!eWa) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaY.getPageActivity());
                aVar.cE(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
                aVar.a(w.l.confirm, new j(this, str));
                aVar.b(w.l.cancel, new k(this));
                aVar.b(this.aaY).tQ();
                return;
            }
            if (!this.eWb) {
                this.eWb = true;
                com.baidu.adp.lib.util.k.showToast(this.aaY.getPageActivity(), w.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void ly(String str) {
        this.dwB.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxj);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxd);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxf);
        this.bed.stop();
        this.dxa.unregister(this.aaY.getPageActivity());
    }

    public void oT(String str) {
        this.dwF.setText(str);
    }

    public void bQ(long j) {
        this.eWc.setText(com.baidu.tbadk.core.util.au.t(j));
    }

    public boolean azC() {
        return this.dwG;
    }

    public void azD() {
        if (this.dwy != null) {
            azF();
            this.dwy.setVisibility(0);
            this.eWf.setVisibility(0);
            if (this.eWm != null) {
                this.eWm.jn(true);
            }
            this.eWe.setVisibility(8);
            this.dwJ.setAnimationListener(this.dxh);
            this.dwy.startAnimation(this.dwJ);
            this.dwI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYP() {
        if (this.dwy != null) {
            if (this.dwy.getVisibility() == 0) {
                azF();
                this.dwy.setVisibility(8);
                this.eWe.setVisibility(0);
                if (this.eWm != null) {
                    this.eWm.aQx();
                    return;
                }
                return;
            }
            azG();
        }
    }

    public void azE() {
        if (this.dwy != null) {
            azF();
            this.dwy.setVisibility(0);
            this.eWf.setVisibility(0);
            if (this.eWm != null) {
                this.eWm.jn(false);
            }
            this.eWe.setVisibility(8);
            this.dwb.setAnimationListener(this.dxi);
            this.dwy.startAnimation(this.dwb);
        }
    }

    public void aYQ() {
        if (this.dwy != null) {
            azF();
            this.dwy.setVisibility(0);
            this.eWf.setVisibility(0);
            this.eWe.setVisibility(8);
            if (this.eWm != null) {
                this.eWm.jn(false);
            }
        }
    }

    public void aYR() {
        if (this.dwy != null) {
            this.dwb.cancel();
            this.dwJ.cancel();
            azF();
            this.dwy.setVisibility(4);
            this.eWf.setVisibility(4);
            this.eWe.setVisibility(8);
            if (this.eWm != null) {
                this.eWm.jn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azF() {
        if (this.dwy != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxj);
            this.dwb.setAnimationListener(null);
            this.dwJ.setAnimationListener(null);
            this.dwy.clearAnimation();
            this.dwI = false;
        }
    }

    public void azG() {
        azE();
        aYS();
    }

    private void aYS() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dxj);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.dxj, 3000L);
    }

    public void a(b bVar) {
        this.eWl = bVar;
    }

    public void mH(int i) {
        if (this.aTd.getDuration() - i <= 3000) {
            azF();
            if (this.dwy != null) {
                this.dwy.setVisibility(0);
                this.eWf.setVisibility(0);
                this.eWe.setVisibility(8);
                if (this.eWm != null) {
                    this.eWm.jn(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dwL = i;
    }

    public void kx(boolean z) {
        if (this.bed != null) {
            this.bed.kz(z);
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

    public int aYT() {
        return this.akS;
    }
}
