package com.baidu.tieba.lego.card.view;

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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.r;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class c {
    private static int ldo;
    private static CallStateReceiver ldp;
    private TbImageView ams;
    private View bMl;
    protected View bUP;
    private Animation chW;
    private TbPageContext<?> eUY;
    private TbCyberVideoView gzX;
    private ImageView hhz;
    private View izE;
    private Animation jny;
    private View kwj;
    SwipeBackLayout.c lcI;
    o lcJ;
    private View lcK;
    private VideoListMediaControllerView lcL;
    private View lcM;
    private FrameLayout lcN;
    protected FrameLayout.LayoutParams lcO;
    private ImageView lcP;
    private ImageView lcQ;
    private ImageView lcR;
    private View lcS;
    private View lcU;
    private ImageView lcV;
    private CyberPlayerManager.OnPreparedListener lcW;
    private m lcX;
    private TextView lcY;
    private b ldb;
    private View ldc;
    private View ldd;
    private TextView lde;
    private SeekBar ldf;
    private ImageView ldg;
    private ImageView ldh;
    private int ldi;
    private String ldl;
    private com.baidu.tieba.play.j ldm;
    private int ldn;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private int mVolume;
    private WeakReference<Context> mWeakContext;
    private WindowManager mWindowManager;
    private String statExtra;
    private int lcT = 0;
    protected boolean abT = false;
    private boolean abI = false;
    private boolean lcZ = false;
    private boolean lda = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int ldj = 0;
    private int ldk = 0;
    private boolean ldq = false;
    private boolean ldr = false;
    private boolean lcC = true;
    private CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            com.baidu.adp.lib.f.e.mA().post(c.this.abO);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.ldt);
            if (c.this.gzX != null && c.this.lcL != null) {
                if (c.this.ldr || c.this.abT) {
                    c.this.gzX.setVolume(1.0f, 1.0f);
                    ak.a(c.this.mWeakContext, true);
                } else {
                    c.this.gzX.setVolume(0.0f, 0.0f);
                    ak.a(c.this.mWeakContext, false);
                }
                c.this.lcL.bw(c.this.mStartPosition, c.this.gzX.getDuration());
                if (c.this.mStartPosition != 0) {
                    c.this.gzX.seekTo(c.this.mStartPosition);
                }
                if (c.this.lcW != null) {
                    c.this.lcW.onPrepared();
                }
            }
        }
    };
    private Runnable abO = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gzX.getCurrentPositionSync() > 100) {
                c.this.abI = true;
                c.this.lcM.setVisibility(8);
                c.this.izE.setVisibility(8);
                c.this.kwj.setVisibility(8);
                c.this.ams.setVisibility(8);
                c.this.dcv();
                if (c.this.lcS != null) {
                    c.this.lcS.setVisibility(0);
                }
                c.this.lcL.showProgress();
                return;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(c.this.abO, 20L);
        }
    };
    private CyberPlayerManager.OnCompletionListener eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.lego.card.view.c.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            c.this.abI = false;
            c.this.mStartPosition = 0;
            if (c.this.abT) {
                c.this.dcg();
                c.this.dcr();
                c.this.dcw();
            } else {
                c.this.cSD();
            }
            if (c.this.lcX != null) {
                c.this.lcX.mu(c.this.mVideoUrl);
            }
        }
    };
    private CyberPlayerManager.OnErrorListener lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            c.this.izE.setVisibility(0);
            c.this.kwj.setVisibility(8);
            return true;
        }
    };
    private Runnable ldt = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.izE.setVisibility(0);
            c.this.kwj.setVisibility(8);
        }
    };
    private TbCyberVideoView.a fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abI = false;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.ldt);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.izE.getId()) {
                if (view.getId() != c.this.lcV.getId() && view.getId() != c.this.lcQ.getId()) {
                    if (view.getId() != c.this.lcR.getId()) {
                        if (view.getId() == c.this.hhz.getId()) {
                            TiebaStatic.log(new ar("c11713"));
                            c.this.TZ();
                            return;
                        } else if (view.getId() == c.this.bUP.getId()) {
                            if (c.this.abI || c.this.abT) {
                                c.this.dcw();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.lcP.getId() && !c.this.abT) {
                            if (c.this.ldr) {
                                c.this.gzX.setVolume(0.0f, 0.0f);
                                c.this.lcP.setImageResource(R.drawable.card_icon_sound_close);
                                ak.a(c.this.mWeakContext, false);
                                c.this.ldr = false;
                                return;
                            }
                            c.this.gzX.setVolume(1.0f, 1.0f);
                            c.this.lcP.setImageResource(R.drawable.card_icon_sound_open);
                            ak.a(c.this.mWeakContext, true);
                            c.this.ldr = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.abT) {
                        if (c.this.lcI != null) {
                            c.this.lcI.enableSwipeBack();
                        }
                        TiebaStatic.log(new ar("c11714"));
                    } else {
                        if (c.this.lcI != null) {
                            c.this.lcI.disableSwipeBack();
                        }
                        TiebaStatic.log(new ar("c11710"));
                        r.dDm().dDi().ej(c.this.statExtra, c.this.ldl);
                    }
                    c.this.TZ();
                    return;
                } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(c.this.eUY.getPageActivity(), c.this.eUY.getString(R.string.neterror));
                    return;
                } else if (!c.this.gzX.isPlaying()) {
                    if (c.this.abI) {
                        c.this.resumePlay();
                        return;
                    } else {
                        c.this.performPlay();
                        return;
                    }
                } else {
                    c.this.pausePlay();
                    return;
                }
            }
            c.this.performPlay();
        }
    };
    private boolean ldu = false;
    private Animation.AnimationListener ldv = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.lcS != null) {
                c.this.lcS.setVisibility(8);
                c.this.lda = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener ldw = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.lcZ = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable ldx = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.dct();
        }
    };
    private CustomMessageListener ldy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.lego.card.view.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface b {
        void rj();

        void rk();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.ldn = 0;
        this.mWeakContext = null;
        this.eUY = tbPageContext;
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.bUP = z(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.bUP);
        }
        this.gzX = (TbCyberVideoView) this.bUP.findViewById(R.id.videoView);
        this.gzX.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.kwj = this.bUP.findViewById(R.id.video_list_layout_loading);
        this.lcL = (VideoListMediaControllerView) this.bUP.findViewById(R.id.media_controller);
        this.lcL.setPlayer(this.gzX);
        this.lcM = this.bUP.findViewById(R.id.black_mask);
        this.izE = this.bUP.findViewById(R.id.layout_error);
        this.izE.setOnClickListener(this.mOnClickListener);
        this.lcN = (FrameLayout) this.bUP.findViewById(R.id.danmu_container);
        this.lcQ = (ImageView) this.bUP.findViewById(R.id.img_play_icon);
        this.lcQ.setOnClickListener(this.mOnClickListener);
        this.lcP = (ImageView) this.bUP.findViewById(R.id.img_sound_control);
        this.lcP.setOnClickListener(this.mOnClickListener);
        this.lcR = (ImageView) this.bUP.findViewById(R.id.card_img_full_screen);
        this.lcR.setOnClickListener(this.mOnClickListener);
        this.lcS = this.bUP.findViewById(R.id.card_layout_media_controller);
        this.lcK = this.bUP.findViewById(R.id.rl_control);
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnCompletionListener(this.eAC);
        this.gzX.setOnErrorListener(this.lds);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        this.lcV = (ImageView) this.bUP.findViewById(R.id.img_play);
        this.lcV.setOnClickListener(this.mOnClickListener);
        this.ams = (TbImageView) this.bUP.findViewById(R.id.video_thumbnail);
        this.ams.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eUY.getPageActivity());
        this.hhz = (ImageView) this.bUP.findViewById(R.id.img_exit);
        this.hhz.setOnClickListener(this.mOnClickListener);
        this.lcY = (TextView) this.bUP.findViewById(R.id.video_title);
        this.bMl = this.bUP.findViewById(R.id.layout_title);
        this.bMl.setVisibility(8);
        this.jny = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.chW = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.eUY.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.eUY.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.ldi = this.mAudioManager.getStreamMaxVolume(3);
        this.mVolume = this.mAudioManager.getStreamVolume(3);
        ldo = 100 / this.ldi;
        this.bUP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abT && c.this.abI) {
                        if (c.this.mStatus == 1 && c.this.ldk != 0) {
                            c.this.c(c.this.ldk == 1 ? 1000.0f : -1000.0f, false);
                            c.this.ldk = 0;
                            c.this.ldj = 0;
                        }
                        if (!c.this.gzX.isPlaying() && 8 == c.this.lcV.getVisibility()) {
                            c.this.lcV.setVisibility(0);
                        }
                    }
                    c.this.dcg();
                }
                return onTouchEvent;
            }
        });
        this.ldm = new com.baidu.tieba.play.j(this.eUY.getPageActivity());
        this.ldm.start();
        this.ldn = com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.ds16);
        if (ldp == null) {
            ldp = new CallStateReceiver();
        }
        ldp.register(this.eUY.getPageActivity());
        this.eUY.registerListener(this.ldy);
    }

    public void a(o oVar) {
        this.lcJ = oVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.lcI = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcg() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.ldc != null && this.ldc.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.ldc);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.ldd != null && this.ldd.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.ldd);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void dch() {
        if (this.mStatus == 1) {
            if (this.ldc == null) {
                this.ldc = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                this.lde = (TextView) this.ldc.findViewById(R.id.show_time);
                this.ldh = (ImageView) this.ldc.findViewById(R.id.arrow_icon);
            }
            if (this.ldc.getParent() == null) {
                this.mWindowManager.addView(this.ldc, dci());
            }
        } else if (this.mStatus == 2) {
            if (this.ldd == null) {
                this.ldd = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                this.ldg = (ImageView) this.ldd.findViewById(R.id.arrow_voice_icon);
                this.ldf = (SeekBar) this.ldd.findViewById(R.id.show_voice_seekbar);
            }
            if (this.ldd.getParent() == null) {
                this.mWindowManager.addView(this.ldd, dci());
            }
        }
    }

    private WindowManager.LayoutParams dci() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* loaded from: classes9.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.abT && c.this.abI) {
                if (!c.this.gzX.isPlaying() && c.this.lcV.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.lcV.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.dcj();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ldj = c.this.gzX.getCurrentPositionSync();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aR(f2);
                    }
                } else if (c.this.mStatus == 1) {
                    c.this.c(f, true);
                } else if (c.this.mStatus == 2) {
                    c.this.aR(f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcj() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bUP.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bUP.setSystemUiVisibility(4);
        } else {
            this.bUP.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(float f) {
        if (!this.gzX.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        dch();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ldo == 0) {
            if (f > 0.0f && this.mVolume < this.ldi) {
                this.mVolume++;
            }
            if (f < 0.0f && this.mVolume > 0) {
                this.mVolume--;
            }
        }
        if (this.mVolume > 0) {
            this.ldg.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.ldg.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.mVolume, 0);
        this.ldf.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.ldj -= 1000;
                this.ldk = 1;
            } else {
                this.ldj += 1000;
                this.ldk = 2;
            }
            if (this.ldj < 0) {
                this.ldj = 0;
            } else if (this.ldj > this.gzX.getDuration()) {
                this.ldj = this.gzX.getDuration();
            }
        }
        dch();
        String Hq = this.lcL.Hq(this.ldj);
        if (f > 0.0f) {
            this.ldh.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.ldh.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Hq)) {
            this.lde.setText(new StringBuilder().append(Hq).append("/").append(this.lcL.Hq(this.gzX.getDuration())));
        }
        this.lcL.setCurrentDuration(this.ldj, z ? false : true);
    }

    protected View z(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void TZ() {
        this.ldq = true;
        if (this.ldm != null) {
            this.ldm.TZ();
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gzX;
    }

    public VideoListMediaControllerView dck() {
        return this.lcL;
    }

    public View dcl() {
        return this.lcS;
    }

    public void tL(boolean z) {
        if (z) {
            this.lcL.setVisibility(0);
            this.lcQ.setVisibility(0);
            return;
        }
        this.lcL.setVisibility(8);
        this.lcQ.setVisibility(8);
    }

    public void tJ(boolean z) {
        this.lcC = z;
    }

    public void hide() {
        this.bUP.setVisibility(8);
    }

    public void show() {
        this.bUP.setVisibility(0);
    }

    public void dcm() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcK.getLayoutParams();
        if (com.baidu.tieba.lego.card.c.e.ar(this.eUY.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.eUY.getResources().getDimension(R.dimen.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.eUY.getResources().getDimension(R.dimen.ds30) + 0.5f);
        }
        this.lcK.setLayoutParams(layoutParams);
        this.lcR.setClickable(false);
        this.lcR.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lcP.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.lcP.setPadding((int) (this.eUY.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds38) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.lcP.setLayoutParams(layoutParams2);
        }
    }

    public void dcn() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcK.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.lcK.setLayoutParams(layoutParams);
        this.lcR.setClickable(true);
        this.lcR.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lcP.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, R.id.card_img_full_screen);
            this.lcP.setPadding((int) (this.eUY.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f));
            this.lcP.setLayoutParams(layoutParams2);
        }
    }

    public void dco() {
        if (this.lcU != null) {
            this.lcO = (FrameLayout.LayoutParams) this.bUP.getLayoutParams();
            this.lcO.width = this.lcU.getWidth();
            this.lcO.height = this.lcU.getHeight();
            int[] iArr = new int[2];
            this.lcU.getLocationOnScreen(iArr);
            this.lcO.topMargin = iArr[1] - this.lcT;
            this.bUP.setLayoutParams(this.lcO);
        }
    }

    public void DY(int i) {
        if (this.lcJ != null && i != this.lcJ.getPage()) {
            this.lcJ.stopPlay();
        }
    }

    public void dr(View view) {
        this.lcU = view;
    }

    public View dcp() {
        return this.lcU;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.abT = true;
            this.lcP.setVisibility(8);
            this.gzX.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
            this.bUP.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.bMl.setVisibility(0);
            tM(true);
            this.lcN.setVisibility(8);
            if (this.ldb != null) {
                this.ldb.rj();
            }
            dcw();
            this.lcR.setImageResource(R.drawable.icon_suoxiao);
            DZ(this.ldn);
            dcj();
            return;
        }
        this.abT = false;
        this.lcP.setVisibility(0);
        if (this.ldr) {
            this.gzX.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
        } else {
            this.gzX.setVolume(0.0f, 0.0f);
            ak.a(this.mWeakContext, false);
        }
        if (this.lcO != null) {
            this.bUP.setLayoutParams(this.lcO);
        }
        a(baseFragmentActivity, false);
        this.bMl.setVisibility(8);
        tM(false);
        this.lcN.setVisibility(0);
        if (this.ldb != null) {
            this.ldb.rk();
        }
        if (!this.abI && this.lcS != null) {
            this.lcS.clearAnimation();
            this.lcS.setVisibility(4);
        }
        dcg();
        this.lcR.setImageResource(R.drawable.icon_fangda);
        DZ(0);
        this.bUP.setSystemUiVisibility(0);
    }

    private void DZ(int i) {
        if (this.lcL != null && (this.lcL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcL.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.lcL.setLayoutParams(layoutParams);
        }
    }

    protected void tM(boolean z) {
        if (z) {
            this.bUP.setOnClickListener(this.mOnClickListener);
        } else {
            this.bUP.setClickable(false);
        }
    }

    public void Ea(int i) {
        this.lcT = i;
    }

    private void a(BaseFragmentActivity baseFragmentActivity, boolean z) {
        if (baseFragmentActivity != null && baseFragmentActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseFragmentActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseFragmentActivity.getWindow().setAttributes(attributes);
                baseFragmentActivity.getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseFragmentActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseFragmentActivity.getWindow().setAttributes(attributes2);
            baseFragmentActivity.getWindow().clearFlags(512);
            if (this.kwj.getVisibility() == 0) {
            }
        }
    }

    public boolean dcq() {
        return !this.abT;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.lcW = onPreparedListener;
    }

    public void a(m mVar) {
        this.lcX = mVar;
    }

    public void setPauseState() {
        this.lcQ.setImageResource(R.drawable.icon_video_midpause);
        this.kwj.setVisibility(8);
        this.lcV.setVisibility(0);
    }

    public void dcr() {
        if (this.lcS != null) {
            this.lcM.setVisibility(0);
            this.lcV.setVisibility(0);
            this.kwj.setVisibility(8);
            this.lcQ.setImageResource(R.drawable.icon_video_midpause);
            this.lcS.setVisibility(0);
            this.izE.setVisibility(8);
            this.lcL.aRo();
            this.ams.setVisibility(0);
        }
    }

    public void FW(String str) {
        this.gzX.setVideoPath(str);
        this.gzX.start();
        this.kwj.setVisibility(0);
        this.ams.setVisibility(0);
        this.lcV.setVisibility(8);
        this.lcQ.setImageResource(R.drawable.icon_video_midplay);
        this.izE.setVisibility(8);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.ldt, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void resumePlay() {
        this.gzX.start();
        this.lcQ.setImageResource(R.drawable.icon_video_midplay);
        this.ams.setVisibility(8);
        this.lcM.setVisibility(8);
        this.kwj.setVisibility(8);
        this.lcL.showProgress();
        this.lcV.setVisibility(8);
    }

    public void pausePlay() {
        this.gzX.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        this.gzX.stopPlayback();
        this.abI = false;
        this.mStartPosition = 0;
        cSD();
    }

    public void cSD() {
        if (this.lcS != null) {
            this.lcM.setVisibility(0);
            this.lcV.setVisibility(0);
            this.kwj.setVisibility(8);
            this.lcQ.setImageResource(R.drawable.icon_video_midpause);
            this.lcS.setVisibility(4);
            this.izE.setVisibility(8);
            this.lcL.aRo();
            this.ams.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.ldu) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
            aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.ldu = true;
                    c.this.FW(c.this.mVideoUrl);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eUY).bqx();
            return;
        }
        FW(this.mVideoUrl);
    }

    public void setThumbnail(String str) {
        this.ams.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldt);
        this.ldm.stop();
        ldp.unregister(this.eUY.getPageActivity());
    }

    public void hh(long j) {
        au.numberUniformFormat(j);
    }

    public boolean dcs() {
        return this.abI;
    }

    public void clearAnimation() {
        dcv();
    }

    public void dct() {
        if (this.lcS != null && !this.lda && this.lcS.getVisibility() == 0) {
            dcv();
            this.lcS.setVisibility(0);
            this.jny.setAnimationListener(this.ldv);
            this.lcS.startAnimation(this.jny);
            this.lda = true;
        }
    }

    public void dcu() {
        if (this.lcS != null && !this.lcZ) {
            if (this.lda || this.lcS.getVisibility() != 0) {
                dcv();
                this.lcS.setVisibility(0);
                this.chW.setAnimationListener(this.ldw);
                this.lcS.startAnimation(this.chW);
                this.lcZ = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcv() {
        if (this.lcS != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
            this.chW.setAnimationListener(null);
            this.jny.setAnimationListener(null);
            this.lcS.clearAnimation();
            this.lda = false;
            this.lcZ = false;
        }
    }

    public void dcw() {
        dcu();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldx);
        if (this.lcC) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ldx, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void a(b bVar) {
        this.ldb = bVar;
    }

    public void Eb(int i) {
        if (this.gzX.getDuration() - i <= 3000 && this.abT) {
            dcv();
            if (this.lcS != null) {
                this.lcS.setVisibility(0);
            }
        }
    }

    public void Ec(int i) {
        this.mStartPosition = i;
    }

    public boolean isShow() {
        return this.bUP.getVisibility() == 0;
    }

    public void fJ(String str, String str2) {
        this.statExtra = str;
        this.ldl = str2;
    }

    public int getScreenHeight(Context context) {
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
            return com.baidu.adp.lib.util.l.getEquipmentHeight(context);
        }
        return i;
    }
}
