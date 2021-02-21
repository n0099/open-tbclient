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
import com.baidu.tieba.recapp.s;
import com.kwad.sdk.collector.AppStatusRules;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class c {
    private static int ldC;
    private static CallStateReceiver ldD;
    private TbImageView ams;
    private View bMl;
    protected View bUP;
    private Animation chW;
    private TbPageContext<?> eUY;
    private TbCyberVideoView gAl;
    private ImageView hhN;
    private View izS;
    private Animation jnM;
    private View kwx;
    SwipeBackLayout.c lcW;
    o lcX;
    private View lcY;
    private VideoListMediaControllerView lcZ;
    private com.baidu.tieba.play.j ldA;
    private int ldB;
    private View lda;
    private FrameLayout ldb;
    protected FrameLayout.LayoutParams ldc;
    private ImageView ldd;
    private ImageView lde;
    private ImageView ldf;
    private View ldg;
    private View ldi;
    private ImageView ldj;
    private CyberPlayerManager.OnPreparedListener ldk;
    private m ldl;
    private TextView ldm;
    private b ldp;
    private View ldq;
    private View ldr;
    private TextView lds;
    private SeekBar ldt;
    private ImageView ldu;
    private ImageView ldv;
    private int ldw;
    private String ldz;
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
    private int ldh = 0;
    protected boolean abT = false;
    private boolean abI = false;
    private boolean ldn = false;
    private boolean ldo = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int ldx = 0;
    private int ldy = 0;
    private boolean ldE = false;
    private boolean ldF = false;
    private boolean lcQ = true;
    private CyberPlayerManager.OnPreparedListener eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            com.baidu.adp.lib.f.e.mA().post(c.this.abO);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.ldH);
            if (c.this.gAl != null && c.this.lcZ != null) {
                if (c.this.ldF || c.this.abT) {
                    c.this.gAl.setVolume(1.0f, 1.0f);
                    ak.a(c.this.mWeakContext, true);
                } else {
                    c.this.gAl.setVolume(0.0f, 0.0f);
                    ak.a(c.this.mWeakContext, false);
                }
                c.this.lcZ.bx(c.this.mStartPosition, c.this.gAl.getDuration());
                if (c.this.mStartPosition != 0) {
                    c.this.gAl.seekTo(c.this.mStartPosition);
                }
                if (c.this.ldk != null) {
                    c.this.ldk.onPrepared();
                }
            }
        }
    };
    private Runnable abO = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gAl.getCurrentPositionSync() > 100) {
                c.this.abI = true;
                c.this.lda.setVisibility(8);
                c.this.izS.setVisibility(8);
                c.this.kwx.setVisibility(8);
                c.this.ams.setVisibility(8);
                c.this.dcC();
                if (c.this.ldg != null) {
                    c.this.ldg.setVisibility(0);
                }
                c.this.lcZ.showProgress();
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
                c.this.dcn();
                c.this.dcy();
                c.this.dcD();
            } else {
                c.this.cSK();
            }
            if (c.this.ldl != null) {
                c.this.ldl.mu(c.this.mVideoUrl);
            }
        }
    };
    private CyberPlayerManager.OnErrorListener ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            c.this.izS.setVisibility(0);
            c.this.kwx.setVisibility(8);
            return true;
        }
    };
    private Runnable ldH = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.izS.setVisibility(0);
            c.this.kwx.setVisibility(8);
        }
    };
    private TbCyberVideoView.a fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abI = false;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.abO);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.ldH);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.izS.getId()) {
                if (view.getId() != c.this.ldj.getId() && view.getId() != c.this.lde.getId()) {
                    if (view.getId() != c.this.ldf.getId()) {
                        if (view.getId() == c.this.hhN.getId()) {
                            TiebaStatic.log(new ar("c11713"));
                            c.this.TZ();
                            return;
                        } else if (view.getId() == c.this.bUP.getId()) {
                            if (c.this.abI || c.this.abT) {
                                c.this.dcD();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.ldd.getId() && !c.this.abT) {
                            if (c.this.ldF) {
                                c.this.gAl.setVolume(0.0f, 0.0f);
                                c.this.ldd.setImageResource(R.drawable.card_icon_sound_close);
                                ak.a(c.this.mWeakContext, false);
                                c.this.ldF = false;
                                return;
                            }
                            c.this.gAl.setVolume(1.0f, 1.0f);
                            c.this.ldd.setImageResource(R.drawable.card_icon_sound_open);
                            ak.a(c.this.mWeakContext, true);
                            c.this.ldF = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.abT) {
                        if (c.this.lcW != null) {
                            c.this.lcW.enableSwipeBack();
                        }
                        TiebaStatic.log(new ar("c11714"));
                    } else {
                        if (c.this.lcW != null) {
                            c.this.lcW.disableSwipeBack();
                        }
                        TiebaStatic.log(new ar("c11710"));
                        s.dDt().dDp().ej(c.this.statExtra, c.this.ldz);
                    }
                    c.this.TZ();
                    return;
                } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(c.this.eUY.getPageActivity(), c.this.eUY.getString(R.string.neterror));
                    return;
                } else if (!c.this.gAl.isPlaying()) {
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
    private boolean ldI = false;
    private Animation.AnimationListener ldJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.ldg != null) {
                c.this.ldg.setVisibility(8);
                c.this.ldo = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener ldK = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.ldn = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable ldL = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.dcA();
        }
    };
    private CustomMessageListener ldM = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.lego.card.view.c.6
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
        this.ldB = 0;
        this.mWeakContext = null;
        this.eUY = tbPageContext;
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.bUP = z(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.bUP);
        }
        this.gAl = (TbCyberVideoView) this.bUP.findViewById(R.id.videoView);
        this.gAl.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.kwx = this.bUP.findViewById(R.id.video_list_layout_loading);
        this.lcZ = (VideoListMediaControllerView) this.bUP.findViewById(R.id.media_controller);
        this.lcZ.setPlayer(this.gAl);
        this.lda = this.bUP.findViewById(R.id.black_mask);
        this.izS = this.bUP.findViewById(R.id.layout_error);
        this.izS.setOnClickListener(this.mOnClickListener);
        this.ldb = (FrameLayout) this.bUP.findViewById(R.id.danmu_container);
        this.lde = (ImageView) this.bUP.findViewById(R.id.img_play_icon);
        this.lde.setOnClickListener(this.mOnClickListener);
        this.ldd = (ImageView) this.bUP.findViewById(R.id.img_sound_control);
        this.ldd.setOnClickListener(this.mOnClickListener);
        this.ldf = (ImageView) this.bUP.findViewById(R.id.card_img_full_screen);
        this.ldf.setOnClickListener(this.mOnClickListener);
        this.ldg = this.bUP.findViewById(R.id.card_layout_media_controller);
        this.lcY = this.bUP.findViewById(R.id.rl_control);
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnCompletionListener(this.eAC);
        this.gAl.setOnErrorListener(this.ldG);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        this.ldj = (ImageView) this.bUP.findViewById(R.id.img_play);
        this.ldj.setOnClickListener(this.mOnClickListener);
        this.ams = (TbImageView) this.bUP.findViewById(R.id.video_thumbnail);
        this.ams.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eUY.getPageActivity());
        this.hhN = (ImageView) this.bUP.findViewById(R.id.img_exit);
        this.hhN.setOnClickListener(this.mOnClickListener);
        this.ldm = (TextView) this.bUP.findViewById(R.id.video_title);
        this.bMl = this.bUP.findViewById(R.id.layout_title);
        this.bMl.setVisibility(8);
        this.jnM = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.chW = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.eUY.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.eUY.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.ldw = this.mAudioManager.getStreamMaxVolume(3);
        this.mVolume = this.mAudioManager.getStreamVolume(3);
        ldC = 100 / this.ldw;
        this.bUP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abT && c.this.abI) {
                        if (c.this.mStatus == 1 && c.this.ldy != 0) {
                            c.this.c(c.this.ldy == 1 ? 1000.0f : -1000.0f, false);
                            c.this.ldy = 0;
                            c.this.ldx = 0;
                        }
                        if (!c.this.gAl.isPlaying() && 8 == c.this.ldj.getVisibility()) {
                            c.this.ldj.setVisibility(0);
                        }
                    }
                    c.this.dcn();
                }
                return onTouchEvent;
            }
        });
        this.ldA = new com.baidu.tieba.play.j(this.eUY.getPageActivity());
        this.ldA.start();
        this.ldB = com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.ds16);
        if (ldD == null) {
            ldD = new CallStateReceiver();
        }
        ldD.register(this.eUY.getPageActivity());
        this.eUY.registerListener(this.ldM);
    }

    public void a(o oVar) {
        this.lcX = oVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.lcW = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcn() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.ldq != null && this.ldq.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.ldq);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.ldr != null && this.ldr.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.ldr);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void dco() {
        if (this.mStatus == 1) {
            if (this.ldq == null) {
                this.ldq = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                this.lds = (TextView) this.ldq.findViewById(R.id.show_time);
                this.ldv = (ImageView) this.ldq.findViewById(R.id.arrow_icon);
            }
            if (this.ldq.getParent() == null) {
                this.mWindowManager.addView(this.ldq, dcp());
            }
        } else if (this.mStatus == 2) {
            if (this.ldr == null) {
                this.ldr = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                this.ldu = (ImageView) this.ldr.findViewById(R.id.arrow_voice_icon);
                this.ldt = (SeekBar) this.ldr.findViewById(R.id.show_voice_seekbar);
            }
            if (this.ldr.getParent() == null) {
                this.mWindowManager.addView(this.ldr, dcp());
            }
        }
    }

    private WindowManager.LayoutParams dcp() {
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
                if (!c.this.gAl.isPlaying() && c.this.ldj.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.ldj.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.dcq();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.ldx = c.this.gAl.getCurrentPositionSync();
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
    public void dcq() {
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
        if (!this.gAl.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        dco();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % ldC == 0) {
            if (f > 0.0f && this.mVolume < this.ldw) {
                this.mVolume++;
            }
            if (f < 0.0f && this.mVolume > 0) {
                this.mVolume--;
            }
        }
        if (this.mVolume > 0) {
            this.ldu.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.ldu.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.mVolume, 0);
        this.ldt.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.ldx -= 1000;
                this.ldy = 1;
            } else {
                this.ldx += 1000;
                this.ldy = 2;
            }
            if (this.ldx < 0) {
                this.ldx = 0;
            } else if (this.ldx > this.gAl.getDuration()) {
                this.ldx = this.gAl.getDuration();
            }
        }
        dco();
        String Hq = this.lcZ.Hq(this.ldx);
        if (f > 0.0f) {
            this.ldv.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.ldv.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Hq)) {
            this.lds.setText(new StringBuilder().append(Hq).append("/").append(this.lcZ.Hq(this.gAl.getDuration())));
        }
        this.lcZ.setCurrentDuration(this.ldx, z ? false : true);
    }

    protected View z(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void TZ() {
        this.ldE = true;
        if (this.ldA != null) {
            this.ldA.TZ();
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gAl;
    }

    public VideoListMediaControllerView dcr() {
        return this.lcZ;
    }

    public View dcs() {
        return this.ldg;
    }

    public void tL(boolean z) {
        if (z) {
            this.lcZ.setVisibility(0);
            this.lde.setVisibility(0);
            return;
        }
        this.lcZ.setVisibility(8);
        this.lde.setVisibility(8);
    }

    public void tJ(boolean z) {
        this.lcQ = z;
    }

    public void hide() {
        this.bUP.setVisibility(8);
    }

    public void show() {
        this.bUP.setVisibility(0);
    }

    public void dct() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcY.getLayoutParams();
        if (com.baidu.tieba.lego.card.c.e.ar(this.eUY.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.eUY.getResources().getDimension(R.dimen.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.eUY.getResources().getDimension(R.dimen.ds30) + 0.5f);
        }
        this.lcY.setLayoutParams(layoutParams);
        this.ldf.setClickable(false);
        this.ldf.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ldd.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.ldd.setPadding((int) (this.eUY.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds38) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.ldd.setLayoutParams(layoutParams2);
        }
    }

    public void dcu() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcY.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.lcY.setLayoutParams(layoutParams);
        this.ldf.setClickable(true);
        this.ldf.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ldd.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, R.id.card_img_full_screen);
            this.ldd.setPadding((int) (this.eUY.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eUY.getResources().getDimension(R.dimen.ds16) + 0.5f));
            this.ldd.setLayoutParams(layoutParams2);
        }
    }

    public void dcv() {
        if (this.ldi != null) {
            this.ldc = (FrameLayout.LayoutParams) this.bUP.getLayoutParams();
            this.ldc.width = this.ldi.getWidth();
            this.ldc.height = this.ldi.getHeight();
            int[] iArr = new int[2];
            this.ldi.getLocationOnScreen(iArr);
            this.ldc.topMargin = iArr[1] - this.ldh;
            this.bUP.setLayoutParams(this.ldc);
        }
    }

    public void DY(int i) {
        if (this.lcX != null && i != this.lcX.getPage()) {
            this.lcX.stopPlay();
        }
    }

    public void dr(View view) {
        this.ldi = view;
    }

    public View dcw() {
        return this.ldi;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.abT = true;
            this.ldd.setVisibility(8);
            this.gAl.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
            this.bUP.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.bMl.setVisibility(0);
            tM(true);
            this.ldb.setVisibility(8);
            if (this.ldp != null) {
                this.ldp.rj();
            }
            dcD();
            this.ldf.setImageResource(R.drawable.icon_suoxiao);
            DZ(this.ldB);
            dcq();
            return;
        }
        this.abT = false;
        this.ldd.setVisibility(0);
        if (this.ldF) {
            this.gAl.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
        } else {
            this.gAl.setVolume(0.0f, 0.0f);
            ak.a(this.mWeakContext, false);
        }
        if (this.ldc != null) {
            this.bUP.setLayoutParams(this.ldc);
        }
        a(baseFragmentActivity, false);
        this.bMl.setVisibility(8);
        tM(false);
        this.ldb.setVisibility(0);
        if (this.ldp != null) {
            this.ldp.rk();
        }
        if (!this.abI && this.ldg != null) {
            this.ldg.clearAnimation();
            this.ldg.setVisibility(4);
        }
        dcn();
        this.ldf.setImageResource(R.drawable.icon_fangda);
        DZ(0);
        this.bUP.setSystemUiVisibility(0);
    }

    private void DZ(int i) {
        if (this.lcZ != null && (this.lcZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lcZ.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.lcZ.setLayoutParams(layoutParams);
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
        this.ldh = i;
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
            if (this.kwx.getVisibility() == 0) {
            }
        }
    }

    public boolean dcx() {
        return !this.abT;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.ldk = onPreparedListener;
    }

    public void a(m mVar) {
        this.ldl = mVar;
    }

    public void setPauseState() {
        this.lde.setImageResource(R.drawable.icon_video_midpause);
        this.kwx.setVisibility(8);
        this.ldj.setVisibility(0);
    }

    public void dcy() {
        if (this.ldg != null) {
            this.lda.setVisibility(0);
            this.ldj.setVisibility(0);
            this.kwx.setVisibility(8);
            this.lde.setImageResource(R.drawable.icon_video_midpause);
            this.ldg.setVisibility(0);
            this.izS.setVisibility(8);
            this.lcZ.aRo();
            this.ams.setVisibility(0);
        }
    }

    public void FX(String str) {
        this.gAl.setVideoPath(str);
        this.gAl.start();
        this.kwx.setVisibility(0);
        this.ams.setVisibility(0);
        this.ldj.setVisibility(8);
        this.lde.setImageResource(R.drawable.icon_video_midplay);
        this.izS.setVisibility(8);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.ldH, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void resumePlay() {
        this.gAl.start();
        this.lde.setImageResource(R.drawable.icon_video_midplay);
        this.ams.setVisibility(8);
        this.lda.setVisibility(8);
        this.kwx.setVisibility(8);
        this.lcZ.showProgress();
        this.ldj.setVisibility(8);
    }

    public void pausePlay() {
        this.gAl.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        this.gAl.stopPlayback();
        this.abI = false;
        this.mStartPosition = 0;
        cSK();
    }

    public void cSK() {
        if (this.ldg != null) {
            this.lda.setVisibility(0);
            this.ldj.setVisibility(0);
            this.kwx.setVisibility(8);
            this.lde.setImageResource(R.drawable.icon_video_midpause);
            this.ldg.setVisibility(4);
            this.izS.setVisibility(8);
            this.lcZ.aRo();
            this.ams.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.ldI) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
            aVar.Au(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.ldI = true;
                    c.this.FX(c.this.mVideoUrl);
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
        FX(this.mVideoUrl);
    }

    public void setThumbnail(String str) {
        this.ams.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.abO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldH);
        this.ldA.stop();
        ldD.unregister(this.eUY.getPageActivity());
    }

    public void hh(long j) {
        au.numberUniformFormat(j);
    }

    public boolean dcz() {
        return this.abI;
    }

    public void clearAnimation() {
        dcC();
    }

    public void dcA() {
        if (this.ldg != null && !this.ldo && this.ldg.getVisibility() == 0) {
            dcC();
            this.ldg.setVisibility(0);
            this.jnM.setAnimationListener(this.ldJ);
            this.ldg.startAnimation(this.jnM);
            this.ldo = true;
        }
    }

    public void dcB() {
        if (this.ldg != null && !this.ldn) {
            if (this.ldo || this.ldg.getVisibility() != 0) {
                dcC();
                this.ldg.setVisibility(0);
                this.chW.setAnimationListener(this.ldK);
                this.ldg.startAnimation(this.chW);
                this.ldn = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcC() {
        if (this.ldg != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
            this.chW.setAnimationListener(null);
            this.jnM.setAnimationListener(null);
            this.ldg.clearAnimation();
            this.ldo = false;
            this.ldn = false;
        }
    }

    public void dcD() {
        dcB();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.ldL);
        if (this.lcQ) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.ldL, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void a(b bVar) {
        this.ldp = bVar;
    }

    public void Eb(int i) {
        if (this.gAl.getDuration() - i <= 3000 && this.abT) {
            dcC();
            if (this.ldg != null) {
                this.ldg.setVisibility(0);
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
        this.ldz = str2;
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
