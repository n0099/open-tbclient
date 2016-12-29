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
import com.baidu.tieba.play.t;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private static int eIL;
    private TbPageContext<?> Gf;
    private QuickVideoView aNV;
    private View aNX;
    private ImageView aNZ;
    private View aOe;
    private String aPj;
    private Animation aQq;
    private TbImageView aRV;
    private TextView aRY;
    private View aRZ;
    private View aSa;
    private d aSj;
    private InterfaceC0070c aSk;
    private b aSp;
    private WindowManager bC;
    private AudioManager bE;
    private View bKq;
    private TextView bKr;
    private View bKv;
    private VideoListMediaControllerView dns;
    private ImageView dnt;
    private Animation dnx;
    private View eIA;
    private TextView eIB;
    private SeekBar eIC;
    private ImageView eID;
    private ImageView eIE;
    private int eIF;
    private am eII;
    private int eIJ;
    private int eIK;
    private CallStateReceiver eIM;
    protected View eIo;
    private FrameLayout eIp;
    protected FrameLayout.LayoutParams eIq;
    private ImageView eIr;
    private View eIt;
    private t.d eIu;
    private t.a eIv;
    private t.b eIw;
    private ImageView eIx;
    private View eIz;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private int eIs = 0;
    protected boolean cyE = false;
    private boolean eIy = false;
    private boolean dny = false;
    private boolean dnz = false;
    private int dnr = 0;
    private int mStatus = 0;
    private int eIG = 0;
    private int eIH = 0;
    private boolean eIN = false;
    private t.d aLF = new com.baidu.tieba.play.d(this);
    private Runnable eIO = new j(this);
    private t.a aLE = new k(this);
    private t.b eIP = new l(this);
    private Runnable eIQ = new m(this);
    private QuickVideoView.b aOo = new n(this);
    protected View.OnClickListener mOnClickListener = new o(this);
    private Animation.AnimationListener dnC = new p(this);
    private Animation.AnimationListener dnD = new q(this);
    private Runnable dnB = new e(this);
    private CustomMessageListener eIR = new f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);

    /* loaded from: classes.dex */
    public interface b {
        void Lv();

        void Lw();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070c {
        void Lu();
    }

    /* loaded from: classes.dex */
    public interface d {
        void Ls();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.eIJ = 0;
        this.Gf = tbPageContext;
        this.eIo = w(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.eIo);
        }
        this.aNV = (QuickVideoView) this.eIo.findViewById(r.g.videoView);
        this.bKv = this.eIo.findViewById(r.g.video_list_layout_loading);
        this.aRZ = this.eIo.findViewById(r.g.layout_play_count);
        this.aRY = (TextView) this.eIo.findViewById(r.g.play_count);
        this.dns = (VideoListMediaControllerView) this.eIo.findViewById(r.g.media_controller);
        this.dns.setPlayer(this.aNV);
        this.bKq = this.eIo.findViewById(r.g.black_mask);
        this.aOe = this.eIo.findViewById(r.g.layout_error);
        this.aOe.setOnClickListener(this.mOnClickListener);
        this.eIp = (FrameLayout) this.eIo.findViewById(r.g.danmu_container);
        this.dnt = (ImageView) this.eIo.findViewById(r.g.img_play_icon);
        this.dnt.setOnClickListener(this.mOnClickListener);
        this.eIr = (ImageView) this.eIo.findViewById(r.g.img_full_screen);
        this.eIr.setOnClickListener(this.mOnClickListener);
        this.aSa = this.eIo.findViewById(r.g.layout_media_controller);
        this.aNV.setOnPreparedListener(this.aLF);
        this.aNV.setOnCompletionListener(this.aLE);
        this.aNV.setOnErrorListener(this.eIP);
        this.aNV.setOnSurfaceDestroyedListener(this.aOo);
        this.aNZ = (ImageView) this.eIo.findViewById(r.g.img_play);
        this.aNZ.setOnClickListener(this.mOnClickListener);
        this.aRV = (TbImageView) this.eIo.findViewById(r.g.video_thumbnail);
        this.aRV.setDefaultErrorResource(0);
        this.aRV.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.k.I(this.Gf.getPageActivity());
        this.mScreenHeight = bm(this.Gf.getPageActivity());
        this.eIx = (ImageView) this.eIo.findViewById(r.g.img_exit);
        this.eIx.setOnClickListener(this.mOnClickListener);
        this.bKr = (TextView) this.eIo.findViewById(r.g.video_title);
        this.aNX = this.eIo.findViewById(r.g.layout_title);
        this.aNX.setVisibility(8);
        this.dnx = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.anim_alpha_1_to_0_duration_2000);
        this.aQq = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.anim_alpha_0_to_1_duration_200);
        this.bC = (WindowManager) this.Gf.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.Gf.getPageActivity(), new a(this, null));
        this.bE = (AudioManager) tbPageContext.getContext().getSystemService("audio");
        this.eIF = this.bE.getStreamMaxVolume(3);
        this.eIK = this.bE.getStreamVolume(3);
        eIL = 100 / this.eIF;
        this.eIo.setOnTouchListener(new g(this));
        this.eII = new am(this.Gf.getPageActivity());
        this.eII.start();
        this.eIJ = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds16);
        this.eIM = new CallStateReceiver();
        this.eIM.register(this.Gf.getPageActivity());
        this.Gf.registerListener(this.eIR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.eIz != null && this.eIz.getParent() != null) {
                try {
                    this.bC.removeView(this.eIz);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.eIA != null && this.eIA.getParent() != null) {
                try {
                    this.bC.removeView(this.eIA);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void aWc() {
        if (this.mStatus == 1) {
            if (this.eIz == null) {
                this.eIz = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.float_video_window_jindu, (ViewGroup) null);
                this.eIB = (TextView) this.eIz.findViewById(r.g.show_time);
                this.eIE = (ImageView) this.eIz.findViewById(r.g.arrow_icon);
            }
            if (this.eIz.getParent() == null) {
                this.bC.addView(this.eIz, afj());
            }
        } else if (this.mStatus == 2) {
            if (this.eIA == null) {
                this.eIA = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.float_video_window_voice, (ViewGroup) null);
                this.eID = (ImageView) this.eIA.findViewById(r.g.arrow_voice_icon);
                this.eIC = (SeekBar) this.eIA.findViewById(r.g.show_voice_seekbar);
            }
            if (this.eIA.getParent() == null) {
                this.bC.addView(this.eIA, afj());
            }
        }
    }

    private WindowManager.LayoutParams afj() {
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
            if (c.this.cyE && c.this.eIy) {
                if (!c.this.aNV.isPlaying() && c.this.aNZ.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aNZ.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.ak(f2);
                        }
                    } else {
                        c.this.b(f, true);
                    }
                } else {
                    c.this.aWd();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.eIG = c.this.aNV.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ak(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWd() {
        if (Build.VERSION.SDK_INT < 16) {
            this.eIo.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.eIo.setSystemUiVisibility(4);
        } else {
            this.eIo.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(float f) {
        if (!this.aNV.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        aWc();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % eIL == 0) {
            if (f > 0.0f && this.eIK < this.eIF) {
                this.eIK++;
            }
            if (f < 0.0f && this.eIK > 0) {
                this.eIK--;
            }
        }
        if (this.eIK > 0) {
            this.eID.setImageResource(r.f.icon_shengyin_open);
        } else {
            this.eID.setImageResource(r.f.icon_shengyin_close);
        }
        this.bE.setStreamVolume(3, this.eIK, 0);
        this.eIC.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.eIG -= 1000;
                this.eIH = 1;
            } else {
                this.eIG += 1000;
                this.eIH = 2;
            }
            if (this.eIG < 0) {
                this.eIG = 0;
            } else if (this.eIG > this.aNV.getDuration()) {
                this.eIG = this.aNV.getDuration();
            }
        }
        aWc();
        String pT = this.dns.pT(this.eIG);
        if (f > 0.0f) {
            this.eIE.setImageResource(r.f.icon_kuaitui);
        } else {
            this.eIE.setImageResource(r.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(pT)) {
            this.eIB.setText(new StringBuilder().append(pT).append("/").append(this.dns.pT(this.aNV.getDuration())));
        }
        this.dns.C(this.eIG, z ? false : true);
    }

    protected View w(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.aPj = str;
    }

    public void aWe() {
        this.eIN = true;
        if (this.eII != null) {
            this.eII.aWe();
        }
    }

    public QuickVideoView JM() {
        return this.aNV;
    }

    public VideoListMediaControllerView aWf() {
        return this.dns;
    }

    public void bf(View view) {
        this.eIp.removeAllViews();
        this.eIp.addView(view);
    }

    public void aWg() {
        this.eIp.removeAllViews();
    }

    public View aWh() {
        return this.aSa;
    }

    public void hide() {
        this.eIo.setVisibility(8);
    }

    public void show() {
        this.eIo.setVisibility(0);
    }

    public void aWi() {
        if (this.eIt != null) {
            this.eIq = (FrameLayout.LayoutParams) this.eIo.getLayoutParams();
            this.eIq.width = this.eIt.getWidth();
            this.eIq.height = this.eIt.getHeight();
            int[] iArr = new int[2];
            this.eIt.getLocationOnScreen(iArr);
            this.eIq.topMargin = iArr[1] - this.eIs;
            this.eIo.setLayoutParams(this.eIq);
        }
    }

    public void bg(View view) {
        this.eIt = view;
    }

    public View aWj() {
        return this.eIt;
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.eIN) {
            if (this.cyE) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11711"));
            }
        } else {
            this.eIN = false;
        }
        if (configuration.orientation == 2) {
            this.cyE = true;
            this.eIo.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.aNX.setVisibility(0);
            fk(true);
            this.eIp.setVisibility(8);
            if (this.aSp != null) {
                this.aSp.Lv();
            }
            axO();
            this.eIr.setImageResource(r.f.icon_suoxiao);
            pL(this.eIJ);
            aWd();
            return;
        }
        this.cyE = false;
        if (this.eIq != null) {
            this.eIo.setLayoutParams(this.eIq);
        }
        b(baseActivity, false);
        this.aNX.setVisibility(8);
        fk(false);
        this.eIp.setVisibility(0);
        if (this.aSp != null) {
            this.aSp.Lw();
        }
        if (!this.eIy && this.aSa != null) {
            this.aSa.clearAnimation();
            this.aSa.setVisibility(4);
        }
        aWb();
        this.eIr.setImageResource(r.f.icon_fangda);
        pL(0);
        this.eIo.setSystemUiVisibility(0);
    }

    private void pL(int i) {
        if (this.dns != null && (this.dns.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dns.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dns.setLayoutParams(layoutParams);
        }
    }

    protected void fk(boolean z) {
        if (z) {
            this.eIo.setOnClickListener(this.mOnClickListener);
        } else {
            this.eIo.setClickable(false);
        }
    }

    public void pM(int i) {
        this.eIs = i;
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.aRZ.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.bKv.getVisibility() == 0) {
                this.aRZ.setVisibility(0);
            }
        }
    }

    public boolean aWk() {
        return !this.cyE;
    }

    public void a(t.d dVar) {
        this.eIu = dVar;
    }

    public void a(t.a aVar) {
        this.eIv = aVar;
    }

    public void a(t.b bVar) {
        this.eIw = bVar;
    }

    public void aWl() {
        this.dnt.setImageResource(r.f.icon_video_midpause);
        this.bKv.setVisibility(8);
        this.aRZ.setVisibility(8);
        this.aNZ.setVisibility(0);
    }

    public void aWm() {
        if (this.aSa != null) {
            this.bKq.setVisibility(0);
            this.aNZ.setVisibility(0);
            this.bKv.setVisibility(8);
            this.aRZ.setVisibility(8);
            this.dnt.setImageResource(r.f.icon_video_midpause);
            this.aSa.setVisibility(0);
            this.aOe.setVisibility(8);
            this.dns.alT();
            this.aRV.setVisibility(0);
        }
    }

    public void startPlay(String str) {
        this.aNV.setVideoPath(str);
        this.aNV.start();
        this.bKv.setVisibility(0);
        if (this.cyE) {
            this.aRZ.setVisibility(8);
        } else {
            this.aRZ.setVisibility(0);
        }
        this.aRV.setVisibility(0);
        this.aNZ.setVisibility(8);
        this.dnt.setImageResource(r.f.icon_video_midplay);
        this.aOe.setVisibility(8);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eIQ);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eIQ, TbConfig.USE_TIME_INTERVAL);
    }

    public void Lj() {
        this.aNV.start();
        this.dnt.setImageResource(r.f.icon_video_midplay);
        this.aRV.setVisibility(8);
        this.bKq.setVisibility(8);
        this.bKv.setVisibility(8);
        this.aRZ.setVisibility(8);
        this.dns.showProgress();
        this.aNZ.setVisibility(8);
    }

    public void pausePlay() {
        this.aNV.pause();
        aWl();
    }

    public void stopPlay() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eIO);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eIQ);
        this.aNV.stopPlayback();
        this.eIy = false;
        this.dnr = 0;
        akW();
    }

    public void akW() {
        if (this.aSa != null) {
            this.bKq.setVisibility(0);
            this.aNZ.setVisibility(0);
            this.bKv.setVisibility(8);
            this.aRZ.setVisibility(8);
            this.dnt.setImageResource(r.f.icon_video_midpause);
            this.aSa.setVisibility(4);
            this.aOe.setVisibility(8);
            this.dns.alT();
            this.aRV.setVisibility(0);
        }
    }

    public void a(d dVar) {
        this.aSj = dVar;
    }

    public void a(InterfaceC0070c interfaceC0070c) {
        this.aSk = interfaceC0070c;
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.i.go() && !com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("video_list_confirm_play_in_mobile", false)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Gf.getPageActivity());
            aVar.cG(TbadkCoreApplication.m9getInst().getString(r.j.play_video_mobile_tip));
            aVar.a(r.j.confirm, new h(this));
            aVar.b(r.j.cancel, new i(this));
            aVar.b(this.Gf).tb();
            return;
        }
        startPlay(this.aPj);
        if (this.aSj != null) {
            this.aSj.Ls();
        }
    }

    public void pj(String str) {
        this.aRV.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.dnB);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eIO);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eIQ);
        this.eII.stop();
        this.eIM.unregister(this.Gf.getPageActivity());
    }

    public void pk(String str) {
        this.bKr.setText(str);
    }

    public void cA(long j) {
        this.aRY.setText(com.baidu.tbadk.core.util.av.v(j));
    }

    public boolean aWn() {
        return this.eIy;
    }

    public void clearAnimation() {
        axR();
    }

    public void axP() {
        if (this.aSa != null && !this.dnz && this.aSa.getVisibility() == 0) {
            axR();
            this.aSa.setVisibility(0);
            this.dnx.setAnimationListener(this.dnC);
            this.aSa.startAnimation(this.dnx);
            this.dnz = true;
        }
    }

    public void axQ() {
        if (this.aSa != null && !this.dny) {
            if (this.dnz || this.aSa.getVisibility() != 0) {
                axR();
                this.aSa.setVisibility(0);
                this.aQq.setAnimationListener(this.dnD);
                this.aSa.startAnimation(this.aQq);
                this.dny = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axR() {
        if (this.aSa != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.dnB);
            this.aQq.setAnimationListener(null);
            this.dnx.setAnimationListener(null);
            this.aSa.clearAnimation();
            this.dnz = false;
            this.dny = false;
        }
    }

    public void axO() {
        axQ();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.dnB);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.dnB, 3000L);
    }

    public void a(b bVar) {
        this.aSp = bVar;
    }

    public void pN(int i) {
        if (this.aNV.getDuration() - i <= 3000 && this.cyE) {
            axR();
            if (this.aSa != null) {
                this.aSa.setVisibility(0);
            }
        }
    }

    public void setStartPosition(int i) {
        this.dnr = i;
    }

    public boolean isShow() {
        return this.eIo.getVisibility() == 0;
    }

    public void kh(boolean z) {
        if (this.eII != null) {
            this.eII.kj(z);
        }
    }

    public int bm(Context context) {
        int i;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            return com.baidu.adp.lib.util.k.J(context);
        }
        return i;
    }
}
