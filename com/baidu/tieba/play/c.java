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
    private static int ffq;
    private TbPageContext<?> Gf;
    private QuickVideoView aOE;
    private View aOG;
    private ImageView aOI;
    private View aON;
    private String aPS;
    private Animation aQZ;
    private TbImageView aSE;
    private TextView aSH;
    private View aSI;
    private View aSJ;
    private d aSS;
    private InterfaceC0076c aST;
    private b aSY;
    private WindowManager bC;
    private AudioManager bE;
    private View ceH;
    private TextView ceI;
    private View ceM;
    protected View feN;
    private VideoListMediaControllerView feO;
    private FrameLayout feP;
    protected FrameLayout.LayoutParams feQ;
    private ImageView feR;
    private ImageView feS;
    private View feU;
    private t.d feV;
    private t.a feW;
    private t.b feX;
    private ImageView feY;
    private Animation ffc;
    private View ffe;
    private View fff;
    private TextView ffg;
    private SeekBar ffh;
    private ImageView ffi;
    private ImageView ffj;
    private int ffk;
    private am ffn;
    private int ffo;
    private int ffp;
    private CallStateReceiver ffr;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private int feT = 0;
    protected boolean cTv = false;
    private boolean feZ = false;
    private boolean ffa = false;
    private boolean ffb = false;
    private int ffd = 0;
    private int mStatus = 0;
    private int ffl = 0;
    private int ffm = 0;
    private boolean ffs = false;
    private t.d aMo = new com.baidu.tieba.play.d(this);
    private Runnable fft = new j(this);
    private t.a aMn = new k(this);
    private t.b ffu = new l(this);
    private Runnable ffv = new m(this);
    private QuickVideoView.b aOX = new n(this);
    protected View.OnClickListener mOnClickListener = new o(this);
    private Animation.AnimationListener ffw = new p(this);
    private Animation.AnimationListener ffx = new q(this);
    private Runnable ffy = new e(this);
    private CustomMessageListener ffz = new f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);

    /* loaded from: classes.dex */
    public interface b {
        void Mc();

        void Md();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0076c {
        void Mb();
    }

    /* loaded from: classes.dex */
    public interface d {
        void LZ();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.ffo = 0;
        this.Gf = tbPageContext;
        this.feN = v(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.feN);
        }
        this.aOE = (QuickVideoView) this.feN.findViewById(r.g.videoView);
        this.ceM = this.feN.findViewById(r.g.video_list_layout_loading);
        this.aSI = this.feN.findViewById(r.g.layout_play_count);
        this.aSH = (TextView) this.feN.findViewById(r.g.play_count);
        this.feO = (VideoListMediaControllerView) this.feN.findViewById(r.g.media_controller);
        this.feO.setPlayer(this.aOE);
        this.ceH = this.feN.findViewById(r.g.black_mask);
        this.aON = this.feN.findViewById(r.g.layout_error);
        this.aON.setOnClickListener(this.mOnClickListener);
        this.feP = (FrameLayout) this.feN.findViewById(r.g.danmu_container);
        this.feR = (ImageView) this.feN.findViewById(r.g.img_play_icon);
        this.feR.setOnClickListener(this.mOnClickListener);
        this.feS = (ImageView) this.feN.findViewById(r.g.img_full_screen);
        this.feS.setOnClickListener(this.mOnClickListener);
        this.aSJ = this.feN.findViewById(r.g.layout_media_controller);
        this.aOE.setOnPreparedListener(this.aMo);
        this.aOE.setOnCompletionListener(this.aMn);
        this.aOE.setOnErrorListener(this.ffu);
        this.aOE.setOnSurfaceDestroyedListener(this.aOX);
        this.aOI = (ImageView) this.feN.findViewById(r.g.img_play);
        this.aOI.setOnClickListener(this.mOnClickListener);
        this.aSE = (TbImageView) this.feN.findViewById(r.g.video_thumbnail);
        this.aSE.setDefaultErrorResource(0);
        this.aSE.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.k.K(this.Gf.getPageActivity());
        this.mScreenHeight = bn(this.Gf.getPageActivity());
        this.feY = (ImageView) this.feN.findViewById(r.g.img_exit);
        this.feY.setOnClickListener(this.mOnClickListener);
        this.ceI = (TextView) this.feN.findViewById(r.g.video_title);
        this.aOG = this.feN.findViewById(r.g.layout_title);
        this.aOG.setVisibility(8);
        this.ffc = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.anim_alpha_1_to_0_duration_2000);
        this.aQZ = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.anim_alpha_0_to_1_duration_200);
        this.bC = (WindowManager) this.Gf.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.Gf.getPageActivity(), new a(this, null));
        this.bE = (AudioManager) tbPageContext.getContext().getSystemService("audio");
        this.ffk = this.bE.getStreamMaxVolume(3);
        this.ffp = this.bE.getStreamVolume(3);
        ffq = 100 / this.ffk;
        this.feN.setOnTouchListener(new g(this));
        this.ffn = new am(this.Gf.getPageActivity());
        this.ffn.start();
        this.ffo = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds16);
        this.ffr = new CallStateReceiver();
        this.ffr.register(this.Gf.getPageActivity());
        this.Gf.registerListener(this.ffz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcq() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.ffe != null && this.ffe.getParent() != null) {
                try {
                    this.bC.removeView(this.ffe);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.fff != null && this.fff.getParent() != null) {
                try {
                    this.bC.removeView(this.fff);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void bcr() {
        if (this.mStatus == 1) {
            if (this.ffe == null) {
                this.ffe = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.float_video_window_jindu, (ViewGroup) null);
                this.ffg = (TextView) this.ffe.findViewById(r.g.show_time);
                this.ffj = (ImageView) this.ffe.findViewById(r.g.arrow_icon);
            }
            if (this.ffe.getParent() == null) {
                this.bC.addView(this.ffe, akJ());
            }
        } else if (this.mStatus == 2) {
            if (this.fff == null) {
                this.fff = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.float_video_window_voice, (ViewGroup) null);
                this.ffi = (ImageView) this.fff.findViewById(r.g.arrow_voice_icon);
                this.ffh = (SeekBar) this.fff.findViewById(r.g.show_voice_seekbar);
            }
            if (this.fff.getParent() == null) {
                this.bC.addView(this.fff, akJ());
            }
        }
    }

    private WindowManager.LayoutParams akJ() {
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
            if (c.this.cTv && c.this.feZ) {
                if (!c.this.aOE.isPlaying() && c.this.aOI.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aOI.setVisibility(8);
                }
                if (c.this.mStatus != 0) {
                    if (c.this.mStatus != 1) {
                        if (c.this.mStatus == 2) {
                            c.this.ar(f2);
                        }
                    } else {
                        c.this.b(f, true);
                    }
                } else {
                    c.this.bcs();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ffl = c.this.aOE.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.ar(f2);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcs() {
        if (Build.VERSION.SDK_INT < 16) {
            this.feN.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.feN.setSystemUiVisibility(4);
        } else {
            this.feN.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f) {
        if (!this.aOE.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        bcr();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ffq == 0) {
            if (f > 0.0f && this.ffp < this.ffk) {
                this.ffp++;
            }
            if (f < 0.0f && this.ffp > 0) {
                this.ffp--;
            }
        }
        if (this.ffp > 0) {
            this.ffi.setImageResource(r.f.icon_shengyin_open);
        } else {
            this.ffi.setImageResource(r.f.icon_shengyin_close);
        }
        this.bE.setStreamVolume(3, this.ffp, 0);
        this.ffh.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.ffl -= 1000;
                this.ffm = 1;
            } else {
                this.ffl += 1000;
                this.ffm = 2;
            }
            if (this.ffl < 0) {
                this.ffl = 0;
            } else if (this.ffl > this.aOE.getDuration()) {
                this.ffl = this.aOE.getDuration();
            }
        }
        bcr();
        String qS = this.feO.qS(this.ffl);
        if (f > 0.0f) {
            this.ffj.setImageResource(r.f.icon_kuaitui);
        } else {
            this.ffj.setImageResource(r.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(qS)) {
            this.ffg.setText(new StringBuilder().append(qS).append("/").append(this.feO.qS(this.aOE.getDuration())));
        }
        this.feO.Q(this.ffl, z ? false : true);
    }

    protected View v(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.h.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.aPS = str;
    }

    public void bct() {
        this.ffs = true;
        if (this.ffn != null) {
            this.ffn.bct();
        }
    }

    public QuickVideoView Kt() {
        return this.aOE;
    }

    public VideoListMediaControllerView bcu() {
        return this.feO;
    }

    public void bg(View view) {
        this.feP.removeAllViews();
        this.feP.addView(view);
    }

    public void bcv() {
        this.feP.removeAllViews();
    }

    public View bcw() {
        return this.aSJ;
    }

    public void hide() {
        this.feN.setVisibility(8);
    }

    public void show() {
        this.feN.setVisibility(0);
    }

    public void bcx() {
        if (this.feU != null) {
            this.feQ = (FrameLayout.LayoutParams) this.feN.getLayoutParams();
            this.feQ.width = this.feU.getWidth();
            this.feQ.height = this.feU.getHeight();
            int[] iArr = new int[2];
            this.feU.getLocationOnScreen(iArr);
            this.feQ.topMargin = iArr[1] - this.feT;
            this.feN.setLayoutParams(this.feQ);
        }
    }

    public void bh(View view) {
        this.feU = view;
    }

    public View bcy() {
        return this.feU;
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.ffs) {
            if (this.cTv) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11711"));
            }
        } else {
            this.ffs = false;
        }
        if (configuration.orientation == 2) {
            this.cTv = true;
            this.feN.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.aOG.setVisibility(0);
            fz(true);
            this.feP.setVisibility(8);
            if (this.aSY != null) {
                this.aSY.Mc();
            }
            bcG();
            this.feS.setImageResource(r.f.icon_suoxiao);
            qK(this.ffo);
            bcs();
            return;
        }
        this.cTv = false;
        if (this.feQ != null) {
            this.feN.setLayoutParams(this.feQ);
        }
        b(baseActivity, false);
        this.aOG.setVisibility(8);
        fz(false);
        this.feP.setVisibility(0);
        if (this.aSY != null) {
            this.aSY.Md();
        }
        if (!this.feZ && this.aSJ != null) {
            this.aSJ.clearAnimation();
            this.aSJ.setVisibility(4);
        }
        bcq();
        this.feS.setImageResource(r.f.icon_fangda);
        qK(0);
        this.feN.setSystemUiVisibility(0);
    }

    private void qK(int i) {
        if (this.feO != null && (this.feO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feO.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.feO.setLayoutParams(layoutParams);
        }
    }

    protected void fz(boolean z) {
        if (z) {
            this.feN.setOnClickListener(this.mOnClickListener);
        } else {
            this.feN.setClickable(false);
        }
    }

    public void qL(int i) {
        this.feT = i;
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.aSI.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.ceM.getVisibility() == 0) {
                this.aSI.setVisibility(0);
            }
        }
    }

    public boolean bcz() {
        return !this.cTv;
    }

    public void a(t.d dVar) {
        this.feV = dVar;
    }

    public void a(t.a aVar) {
        this.feW = aVar;
    }

    public void a(t.b bVar) {
        this.feX = bVar;
    }

    public void bcA() {
        this.feR.setImageResource(r.f.icon_video_midpause);
        this.ceM.setVisibility(8);
        this.aSI.setVisibility(8);
        this.aOI.setVisibility(0);
    }

    public void bcB() {
        if (this.aSJ != null) {
            this.ceH.setVisibility(0);
            this.aOI.setVisibility(0);
            this.ceM.setVisibility(8);
            this.aSI.setVisibility(8);
            this.feR.setImageResource(r.f.icon_video_midpause);
            this.aSJ.setVisibility(0);
            this.aON.setVisibility(8);
            this.feO.arr();
            this.aSE.setVisibility(0);
        }
    }

    public void lm(String str) {
        this.aOE.setVideoPath(str);
        this.aOE.start();
        this.ceM.setVisibility(0);
        if (this.cTv) {
            this.aSI.setVisibility(8);
        } else {
            this.aSI.setVisibility(0);
        }
        this.aSE.setVisibility(0);
        this.aOI.setVisibility(8);
        this.feR.setImageResource(r.f.icon_video_midplay);
        this.aON.setVisibility(8);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffv);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.ffv, TbConfig.USE_TIME_INTERVAL);
    }

    public void LQ() {
        this.aOE.start();
        this.feR.setImageResource(r.f.icon_video_midplay);
        this.aSE.setVisibility(8);
        this.ceH.setVisibility(8);
        this.ceM.setVisibility(8);
        this.aSI.setVisibility(8);
        this.feO.showProgress();
        this.aOI.setVisibility(8);
    }

    public void pausePlay() {
        this.aOE.pause();
        bcA();
    }

    public void stopPlay() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fft);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffv);
        this.aOE.stopPlayback();
        this.feZ = false;
        this.ffd = 0;
        aqu();
    }

    public void aqu() {
        if (this.aSJ != null) {
            this.ceH.setVisibility(0);
            this.aOI.setVisibility(0);
            this.ceM.setVisibility(8);
            this.aSI.setVisibility(8);
            this.feR.setImageResource(r.f.icon_video_midpause);
            this.aSJ.setVisibility(4);
            this.aON.setVisibility(8);
            this.feO.arr();
            this.aSE.setVisibility(0);
        }
    }

    public void a(d dVar) {
        this.aSS = dVar;
    }

    public void a(InterfaceC0076c interfaceC0076c) {
        this.aST = interfaceC0076c;
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.i.go() && !com.baidu.tbadk.core.sharedPref.b.um().getBoolean("video_list_confirm_play_in_mobile", false)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Gf.getPageActivity());
            aVar.cF(TbadkCoreApplication.m9getInst().getString(r.j.play_video_mobile_tip));
            aVar.a(r.j.confirm, new h(this));
            aVar.b(r.j.cancel, new i(this));
            aVar.b(this.Gf).tq();
            return;
        }
        lm(this.aPS);
        if (this.aSS != null) {
            this.aSS.LZ();
        }
    }

    public void qH(String str) {
        this.aSE.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffy);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fft);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffv);
        this.ffn.stop();
        this.ffr.unregister(this.Gf.getPageActivity());
    }

    public void qI(String str) {
        this.ceI.setText(str);
    }

    public void cS(long j) {
        this.aSH.setText(com.baidu.tbadk.core.util.ax.v(j));
    }

    public boolean bcC() {
        return this.feZ;
    }

    public void clearAnimation() {
        bcF();
    }

    public void bcD() {
        if (this.aSJ != null && !this.ffb && this.aSJ.getVisibility() == 0) {
            bcF();
            this.aSJ.setVisibility(0);
            this.ffc.setAnimationListener(this.ffw);
            this.aSJ.startAnimation(this.ffc);
            this.ffb = true;
        }
    }

    public void bcE() {
        if (this.aSJ != null && !this.ffa) {
            if (this.ffb || this.aSJ.getVisibility() != 0) {
                bcF();
                this.aSJ.setVisibility(0);
                this.aQZ.setAnimationListener(this.ffx);
                this.aSJ.startAnimation(this.aQZ);
                this.ffa = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcF() {
        if (this.aSJ != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffy);
            this.aQZ.setAnimationListener(null);
            this.ffc.setAnimationListener(null);
            this.aSJ.clearAnimation();
            this.ffb = false;
            this.ffa = false;
        }
    }

    public void bcG() {
        bcE();
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffy);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.ffy, 3000L);
    }

    public void a(b bVar) {
        this.aSY = bVar;
    }

    public void qM(int i) {
        if (this.aOE.getDuration() - i <= 3000 && this.cTv) {
            bcF();
            if (this.aSJ != null) {
                this.aSJ.setVisibility(0);
            }
        }
    }

    public void setStartPosition(int i) {
        this.ffd = i;
    }

    public boolean isShow() {
        return this.feN.getVisibility() == 0;
    }

    public void kx(boolean z) {
        if (this.ffn != null) {
            this.ffn.kz(z);
        }
    }

    public int bn(Context context) {
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
            return com.baidu.adp.lib.util.k.L(context);
        }
        return i;
    }
}
