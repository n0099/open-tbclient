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
    private static int dym;
    private static boolean eVL = false;
    private QuickVideoView aSL;
    private View aSN;
    private ImageView aSP;
    private View aSU;
    private String aTZ;
    private TbPageContext<?> aaI;
    private View bXQ;
    private TbImageView bXR;
    private TextView bXS;
    private View bXW;
    private Animation dwV;
    protected View dxF;
    private VideoListMediaControllerView dxH;
    private FrameLayout dxI;
    protected FrameLayout.LayoutParams dxJ;
    private ImageView dxL;
    private ImageView dxM;
    private View dxO;
    private v.d dxP;
    private ImageView dxR;
    private Animation dxV;
    private View dxY;
    private View dxZ;
    private View dxx;
    private TextView dya;
    private SeekBar dyb;
    private ImageView dyc;
    private ImageView dyd;
    private int dye;
    private ao dyj;
    private int dyk;
    private int dyl;
    private CallStateReceiver dyn;
    private TextView eVN;
    private View eVO;
    private ProgressBar eVP;
    private View eVQ;
    private TextView eVR;
    private TextView eVS;
    private TextView eVT;
    private v.a eVU;
    private v.b eVV;
    private b eVW;
    private InterfaceC0071c eVX;
    private d eVY;
    private f eVZ;
    private g eWa;
    private e ewR;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    protected View mRootView;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean eVM = false;
    protected boolean cHf = false;
    private boolean dxS = false;
    private boolean dxU = false;
    private int dxX = 0;
    private int mStatus = 0;
    private int dyf = 0;
    private int dyg = 0;
    private boolean dyo = false;
    private String ewL = null;
    private int akD = -1;
    private v.d aQs = new com.baidu.tieba.play.d(this);
    private Runnable dyq = new l(this);
    private v.a aQr = new m(this);
    private v.b dyr = new n(this);
    private Runnable dys = new o(this);
    private QuickVideoView.b aTe = new p(this);
    protected View.OnClickListener mOnClickListener = new q(this);
    private Animation.AnimationListener dyu = new r(this);
    private Animation.AnimationListener dyv = new s(this);
    private Runnable dyw = new com.baidu.tieba.play.e(this);
    private CustomMessageListener dyx = new com.baidu.tieba.play.f(this, CmdConfigCustom.CMD_CALL_STATE_CHANGED);
    private au.b dAR = new com.baidu.tieba.play.g(this);
    private SeekBar.OnSeekBarChangeListener aWL = new h(this);

    /* loaded from: classes.dex */
    public interface b {
        void azc();

        void azd();
    }

    /* renamed from: com.baidu.tieba.play.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071c {
        void aPn();

        void je(boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aPo();
    }

    /* loaded from: classes.dex */
    public interface e {
        void aPm();
    }

    /* loaded from: classes.dex */
    public interface f {
        void aPp();
    }

    /* loaded from: classes.dex */
    public interface g {
        void onStart();

        void onStop();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.dyk = 0;
        if (tbPageContext != null) {
            this.aaI = tbPageContext;
            this.dxF = u(tbPageContext);
            this.mRootView = view;
            if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(this.dxF);
            }
            this.dxO = view;
            this.dxF.setOnClickListener(this.mOnClickListener);
            this.aSL = (QuickVideoView) this.dxF.findViewById(w.h.videoView);
            this.bXW = this.dxF.findViewById(w.h.video_list_layout_loading);
            this.eVO = this.dxF.findViewById(w.h.layout_play_count);
            this.eVN = (TextView) this.dxF.findViewById(w.h.play_count);
            this.dxH = (VideoListMediaControllerView) this.dxF.findViewById(w.h.media_controller);
            this.dxH.setPlayer(this.aSL);
            this.eVP = (ProgressBar) this.dxF.findViewById(w.h.pgrBottomProgress);
            this.eVP.setMax(com.baidu.adp.lib.util.k.ag(this.aaI.getPageActivity()));
            this.eVP.setProgress(0);
            this.dxH.setOnSeekBarChangeListener(this.aWL);
            this.dxH.setOnProgressUpdatedListener(this.dAR);
            this.bXQ = this.dxF.findViewById(w.h.black_mask);
            this.aSU = this.dxF.findViewById(w.h.layout_error);
            this.aSU.setOnClickListener(this.mOnClickListener);
            this.dxI = (FrameLayout) this.dxF.findViewById(w.h.danmu_container);
            this.dxL = (ImageView) this.dxF.findViewById(w.h.img_play_icon);
            this.dxL.setOnClickListener(this.mOnClickListener);
            this.dxM = (ImageView) this.dxF.findViewById(w.h.img_full_screen);
            this.dxM.setOnClickListener(this.mOnClickListener);
            this.dxx = this.dxF.findViewById(w.h.layout_media_controller);
            this.eVQ = this.dxF.findViewById(w.h.time_show_controller);
            this.aSL.setOnPreparedListener(this.aQs);
            this.aSL.setOnCompletionListener(this.aQr);
            this.aSL.setOnErrorListener(this.dyr);
            this.aSL.setOnSurfaceDestroyedListener(this.aTe);
            this.aSP = (ImageView) this.dxF.findViewById(w.h.img_play);
            this.aSP.setOnClickListener(this.mOnClickListener);
            this.eVR = (TextView) this.dxF.findViewById(w.h.txt_replay);
            this.eVR.setOnClickListener(this.mOnClickListener);
            this.eVS = (TextView) this.dxF.findViewById(w.h.txt_playnext);
            this.eVS.setOnClickListener(this.mOnClickListener);
            this.eVT = (TextView) this.dxF.findViewById(w.h.txt_next_video_title);
            this.bXR = (TbImageView) this.dxF.findViewById(w.h.video_thumbnail);
            this.bXR.setDefaultErrorResource(0);
            this.bXR.setDefaultBgResource(w.g.pic_bg_video_frs);
            this.mScreenWidth = com.baidu.adp.lib.util.k.ag(this.aaI.getPageActivity());
            this.mScreenHeight = bG(this.aaI.getPageActivity());
            this.dxR = (ImageView) this.dxF.findViewById(w.h.img_exit);
            this.dxR.setOnClickListener(this.mOnClickListener);
            this.bXS = (TextView) this.dxF.findViewById(w.h.video_title);
            this.aSN = this.dxF.findViewById(w.h.layout_title);
            this.aSN.setVisibility(8);
            this.dxV = AnimationUtils.loadAnimation(this.aaI.getPageActivity(), w.a.anim_alpha_1_to_0_duration_2000);
            this.dwV = AnimationUtils.loadAnimation(this.aaI.getPageActivity(), w.a.anim_alpha_0_to_1_duration_200);
            this.mGestureDetector = new GestureDetector(this.aaI.getPageActivity(), new a(this, null));
            this.mAudioManager = (AudioManager) tbPageContext.getPageActivity().getSystemService("audio");
            this.dye = this.mAudioManager.getStreamMaxVolume(3);
            this.dyl = this.mAudioManager.getStreamVolume(3);
            dym = 100 / this.dye;
            this.dxF.setOnTouchListener(new i(this));
            this.dyj = new ao(this.aaI.getPageActivity());
            this.dyj.start();
            this.dyk = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds16);
            this.dyn = new CallStateReceiver();
            this.dyn.register(this.aaI.getPageActivity());
            this.aaI.registerListener(this.dyx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayI() {
        this.mStatus = 0;
        if (this.dxY != null && this.dxY.getParent() != null && (this.dxY.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dxY.getParent()).removeView(this.dxY);
                this.dxY = null;
            } catch (IllegalArgumentException e2) {
            }
        }
        if (this.dxZ != null && this.dxZ.getParent() != null && (this.dxZ.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.dxZ.getParent()).removeView(this.dxZ);
                this.dxZ = null;
            } catch (IllegalArgumentException e3) {
            }
        }
    }

    private void ayJ() {
        if (this.mStatus == 1) {
            if (this.dxY == null && this.dxF != null && (this.dxF instanceof ViewGroup)) {
                LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.float_video_window_jindu, (ViewGroup) this.dxF, true);
                this.dxY = this.dxF.findViewById(w.h.lay_jindu);
                this.dya = (TextView) this.dxY.findViewById(w.h.show_time);
                this.dyd = (ImageView) this.dxY.findViewById(w.h.arrow_icon);
            }
        } else if (this.mStatus == 2 && this.dxZ == null && this.dxF != null && (this.dxF instanceof ViewGroup)) {
            LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.float_video_window_voice, (ViewGroup) this.dxF, true);
            this.dxZ = this.dxF.findViewById(w.h.lay_voice);
            this.dyc = (ImageView) this.dxZ.findViewById(w.h.arrow_voice_icon);
            this.dyb = (SeekBar) this.dxZ.findViewById(w.h.show_voice_seekbar);
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
            if (c.this.eWa != null) {
                c.this.eWa.onStart();
            }
            if (c.this.dxS) {
                if (!c.this.aSL.isPlaying() && c.this.aSP.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.aSP.setVisibility(8);
                    c.this.eVS.setVisibility(8);
                    c.this.eVR.setVisibility(8);
                    c.this.eVT.setVisibility(8);
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
                    if (c.this.cHf) {
                        c.this.ayL();
                    }
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.dyf = c.this.aSL.getCurrentPosition();
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
    public void ayL() {
        if (Build.VERSION.SDK_INT < 16) {
            this.dxF.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.dxF.setSystemUiVisibility(4);
        } else {
            this.dxF.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f2) {
        if (!this.dxS) {
            this.mStatus = 0;
            return;
        }
        ayJ();
        if (f2 > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f2 < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % dym == 0) {
            if (f2 > 0.0f && this.dyl < this.dye) {
                this.dyl++;
            }
            if (f2 < 0.0f && this.dyl > 0) {
                this.dyl--;
            }
        }
        if (this.mProgress > 0) {
            this.dyc.setImageResource(w.g.icon_shengyin_open);
        } else {
            this.dyc.setImageResource(w.g.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.dyl, 0);
        this.dyb.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.dyf -= 1000;
                this.dyg = 1;
            } else {
                this.dyf += 1000;
                this.dyg = 2;
            }
            if (this.dyf < 0) {
                this.dyf = 0;
            } else if (this.dyf > this.aSL.getDuration()) {
                this.dyf = this.aSL.getDuration();
            }
        }
        ayJ();
        String qA = this.dxH.qA(this.dyf);
        if (f2 > 0.0f) {
            this.dyd.setImageResource(w.g.icon_kuaitui);
        } else {
            this.dyd.setImageResource(w.g.icon_kuaijin);
        }
        if (!StringUtils.isNull(qA)) {
            this.dya.setText(new StringBuilder().append(qA).append("/").append(this.dxH.qA(this.aSL.getDuration())));
        }
        this.dxH.D(this.dyf, z ? false : true);
        this.dxx.setVisibility(8);
        this.eVP.setVisibility(0);
        aXC();
    }

    protected View u(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(w.j.float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.aTZ = str;
    }

    public void aPl() {
        if (!com.baidu.adp.lib.util.i.he()) {
            com.baidu.adp.lib.util.k.G(this.aaI.getPageActivity(), this.aaI.getString(w.l.neterror));
        } else if (this.aSL.isPlaying()) {
            pausePlay();
        } else if (this.dxS) {
            ayW();
            if (this.ewR != null) {
                this.ewR.aPm();
            }
        } else {
            aXE();
        }
    }

    public void ayM() {
        this.dyo = true;
        if (this.dyj != null) {
            this.dyj.ayM();
        }
    }

    public boolean qx(int i) {
        switch (i) {
            case 4:
                if (this.cHf) {
                    ayM();
                    return true;
                }
                return false;
            case 24:
            case 25:
                if (this.mAudioManager == null || this.dye <= 0 || this.dyb == null) {
                    return false;
                }
                this.dyl = this.mAudioManager.getStreamVolume(3);
                this.mProgress = (int) ((this.dyl * 100.0d) / this.dye);
                this.dyb.setProgress(this.mProgress);
                return false;
            default:
                return false;
        }
    }

    public QuickVideoView KG() {
        return this.aSL;
    }

    public VideoListMediaControllerView ayN() {
        return this.dxH;
    }

    public View ayO() {
        return this.dxx;
    }

    public void show() {
        this.dxF.setVisibility(0);
    }

    public void ayR() {
        if (this.dxO != null) {
            ViewGroup.LayoutParams layoutParams = this.dxO.getLayoutParams();
            this.dxJ = (FrameLayout.LayoutParams) this.dxF.getLayoutParams();
            this.dxJ.width = layoutParams.width;
            this.dxJ.height = layoutParams.height;
            this.dxJ.topMargin = 0;
            this.dxF.setLayoutParams(this.dxJ);
        }
    }

    public void a(BaseActivity<?> baseActivity, Configuration configuration) {
        if (!this.dyo) {
            if (this.cHf) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11712"));
            } else {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11711"));
            }
        } else {
            this.dyo = false;
        }
        if (configuration.orientation == 2) {
            this.cHf = true;
            this.dxF.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            b(baseActivity, true);
            this.dxx.setVisibility(0);
            this.aSN.setVisibility(0);
            this.dxR.setVisibility(0);
            this.bXS.setVisibility(0);
            this.dxI.setVisibility(8);
            if (this.eVW != null) {
                this.eVW.azc();
            }
            this.dxM.setImageResource(w.g.icon_suoxiao);
            mB(this.dyk);
            ayL();
        } else {
            this.cHf = false;
            if (this.dxJ != null) {
                this.dxF.setLayoutParams(this.dxJ);
            }
            b(baseActivity, false);
            this.aSN.setVisibility(8);
            this.dxI.setVisibility(0);
            if (this.eVW != null) {
                this.eVW.azd();
            }
            if (this.akD == 3 && this.eVX != null) {
                this.eVX.je(false);
            } else if (!this.dxS && this.dxx != null) {
                this.dxx.clearAnimation();
                this.dxx.setVisibility(4);
                this.eVP.setVisibility(0);
                if (this.eVX != null) {
                    this.eVX.aPn();
                }
            }
            ayI();
            this.dxM.setImageResource(w.g.icon_fangda);
            mB(0);
            this.dxF.setSystemUiVisibility(0);
        }
        if (this.aSL.isPlaying()) {
            azb();
        }
        aXC();
    }

    private void aXC() {
        if (this.aSL != null) {
            int ag = com.baidu.adp.lib.util.k.ag(this.aaI.getPageActivity());
            if (this.cHf) {
                ag = com.baidu.adp.lib.util.k.ah(this.aaI.getPageActivity());
            }
            this.eVP.setMax(ag);
            if (this.aSL.getDuration() > 0) {
                if (this.eVR.getVisibility() == 0) {
                    this.eVP.setProgress(this.eVP.getMax());
                } else {
                    this.eVP.setProgress((int) ((this.aSL.getCurrentPosition() * this.eVP.getMax()) / this.aSL.getDuration()));
                }
            }
        }
    }

    private void mB(int i) {
        if (this.dxH != null && (this.dxH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dxH.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.dxH.setLayoutParams(layoutParams);
        }
    }

    private void b(BaseActivity<?> baseActivity, boolean z) {
        if (baseActivity != null && baseActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseActivity.getWindow().setAttributes(attributes);
                baseActivity.getWindow().addFlags(512);
                this.eVO.setVisibility(8);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes2);
            baseActivity.getWindow().clearFlags(512);
            if (this.bXW.getVisibility() == 0) {
                this.eVO.setVisibility(0);
            }
        }
    }

    public boolean ayT() {
        return !this.cHf;
    }

    public void a(v.b bVar) {
        this.eVV = bVar;
    }

    public void ayU() {
        this.dxL.setImageResource(w.g.icon_video_midpause);
        this.bXW.setVisibility(8);
        this.eVO.setVisibility(8);
        this.aSP.setVisibility(0);
        this.eVS.setVisibility(8);
        this.eVR.setVisibility(8);
        this.eVT.setVisibility(8);
        this.akD = 2;
        this.aSL.setRecoveryState(2);
    }

    public void startPlay(String str) {
        this.akD = 0;
        this.aSL.setRecoveryState(0);
        setVideoUrl(str);
        this.aSL.setVideoPath(str);
        this.aSL.start();
        this.bXW.setVisibility(0);
        if (this.cHf) {
            this.eVO.setVisibility(8);
        } else {
            this.eVO.setVisibility(0);
        }
        this.bXR.setVisibility(0);
        this.aSP.setVisibility(8);
        this.dxL.setImageResource(w.g.icon_video_midplay);
        this.eVS.setVisibility(8);
        this.eVR.setVisibility(8);
        this.eVT.setVisibility(8);
        this.aSU.setVisibility(8);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dys);
        com.baidu.adp.lib.g.h.fM().postDelayed(this.dys, TbConfig.USE_TIME_INTERVAL);
    }

    public void ayW() {
        this.akD = 1;
        this.aSL.setRecoveryState(1);
        this.aSL.start();
        this.dxL.setImageResource(w.g.icon_video_midplay);
        this.bXR.setVisibility(8);
        this.bXQ.setVisibility(8);
        this.bXW.setVisibility(8);
        this.eVO.setVisibility(8);
        this.dxH.showProgress();
        this.aSP.setVisibility(8);
        this.eVS.setVisibility(8);
        this.eVR.setVisibility(8);
        this.eVT.setVisibility(8);
        aXI();
    }

    public void kn(boolean z) {
        if (this.aSL != null) {
            this.aSL.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.aSL.isPlaying()) {
            az.aYd().ap(this.aTZ, this.aSL.getCurrentPosition());
        }
        aXG();
        this.aSL.pause();
        ayU();
    }

    public void stopPlay() {
        if (this.aSL.isPlaying()) {
            az.aYd().ap(this.aTZ, this.aSL.getCurrentPosition());
        }
        this.akD = 5;
        this.aSL.setRecoveryState(5);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dyq);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dys);
        this.aSL.stopPlayback();
        this.dxS = false;
        this.dxX = 0;
        alq();
    }

    public void alq() {
        if (this.dxx != null) {
            this.bXQ.setVisibility(0);
            this.aSP.setVisibility(0);
            this.eVS.setVisibility(8);
            this.eVR.setVisibility(8);
            this.eVT.setVisibility(8);
            this.bXW.setVisibility(8);
            this.eVO.setVisibility(8);
            this.dxL.setImageResource(w.g.icon_video_midpause);
            this.dxx.setVisibility(4);
            this.eVP.setVisibility(8);
            this.aSU.setVisibility(8);
            this.dxH.LJ();
            this.bXR.setVisibility(0);
        }
    }

    public boolean aXD() {
        if (this.aSL == null) {
            return false;
        }
        return this.aSL.isPlaying();
    }

    public void a(g gVar) {
        this.eWa = gVar;
    }

    public void a(f fVar) {
        this.eVZ = fVar;
    }

    public void a(e eVar) {
        this.ewR = eVar;
    }

    public void a(d dVar) {
        this.eVY = dVar;
    }

    public void nO(String str) {
        this.ewL = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXE() {
        oK(this.aTZ);
    }

    public void b(InterfaceC0071c interfaceC0071c) {
        this.eVX = interfaceC0071c;
    }

    public void oK(String str) {
        if (com.baidu.adp.lib.util.i.hg()) {
            if (!eVL) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaI.getPageActivity());
                aVar.cx(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
                aVar.a(w.l.confirm, new j(this, str));
                aVar.b(w.l.cancel, new k(this));
                aVar.b(this.aaI).ts();
                return;
            }
            if (!this.eVM) {
                this.eVM = true;
                com.baidu.adp.lib.util.k.showToast(this.aaI.getPageActivity(), w.l.play_video_mobile_tip2);
            }
            startPlay(str);
            return;
        }
        startPlay(str);
    }

    public void lu(String str) {
        this.bXR.c(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dyw);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dyq);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dys);
        this.dyj.stop();
        this.dyn.unregister(this.aaI.getPageActivity());
    }

    public void oL(String str) {
        this.bXS.setText(str);
    }

    public void bQ(long j) {
        this.eVN.setText(com.baidu.tbadk.core.util.au.t(j));
    }

    public boolean ayX() {
        return this.dxS;
    }

    public void ayY() {
        if (this.dxx != null) {
            aza();
            this.dxx.setVisibility(0);
            this.eVQ.setVisibility(0);
            if (this.eVX != null) {
                this.eVX.je(true);
            }
            this.eVP.setVisibility(8);
            this.dxV.setAnimationListener(this.dyu);
            this.dxx.startAnimation(this.dxV);
            this.dxU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXF() {
        if (this.dxx != null) {
            if (this.dxx.getVisibility() == 0) {
                aza();
                this.dxx.setVisibility(8);
                this.eVP.setVisibility(0);
                if (this.eVX != null) {
                    this.eVX.aPn();
                    return;
                }
                return;
            }
            azb();
        }
    }

    public void ayZ() {
        if (this.dxx != null) {
            aza();
            this.dxx.setVisibility(0);
            this.eVQ.setVisibility(0);
            if (this.eVX != null) {
                this.eVX.je(false);
            }
            this.eVP.setVisibility(8);
            this.dwV.setAnimationListener(this.dyv);
            this.dxx.startAnimation(this.dwV);
        }
    }

    public void aXG() {
        if (this.dxx != null) {
            aza();
            this.dxx.setVisibility(0);
            this.eVQ.setVisibility(0);
            this.eVP.setVisibility(8);
            if (this.eVX != null) {
                this.eVX.je(false);
            }
        }
    }

    public void aXH() {
        if (this.dxx != null) {
            this.dwV.cancel();
            this.dxV.cancel();
            aza();
            this.dxx.setVisibility(4);
            this.eVQ.setVisibility(4);
            this.eVP.setVisibility(8);
            if (this.eVX != null) {
                this.eVX.je(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aza() {
        if (this.dxx != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dyw);
            this.dwV.setAnimationListener(null);
            this.dxV.setAnimationListener(null);
            this.dxx.clearAnimation();
            this.dxU = false;
        }
    }

    public void azb() {
        ayZ();
        aXI();
    }

    private void aXI() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dyw);
        com.baidu.adp.lib.g.h.fM().postDelayed(this.dyw, 3000L);
    }

    public void a(b bVar) {
        this.eVW = bVar;
    }

    public void mD(int i) {
        if (this.aSL.getDuration() - i <= 3000) {
            aza();
            if (this.dxx != null) {
                this.dxx.setVisibility(0);
                this.eVQ.setVisibility(0);
                this.eVP.setVisibility(8);
                if (this.eVX != null) {
                    this.eVX.je(false);
                }
            }
        }
    }

    public void setStartPosition(int i) {
        this.dxX = i;
    }

    public void ko(boolean z) {
        if (this.dyj != null) {
            this.dyj.kq(z);
        }
    }

    public int bG(Context context) {
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

    public int aXJ() {
        return this.akD;
    }
}
