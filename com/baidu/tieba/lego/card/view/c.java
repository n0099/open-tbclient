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
/* loaded from: classes8.dex */
public class c {
    private static int lfF;
    private static CallStateReceiver lfG;
    private TbImageView anK;
    private View bNL;
    protected View bWp;
    private Animation cjx;
    private TbPageContext<?> eWx;
    private TbCyberVideoView gBU;
    private ImageView hjx;
    private View iBB;
    private Animation jpv;
    private View kyz;
    SwipeBackLayout.c leZ;
    private String lfC;
    private com.baidu.tieba.play.j lfD;
    private int lfE;
    o lfa;
    private View lfb;
    private VideoListMediaControllerView lfc;
    private View lfd;
    private FrameLayout lfe;
    protected FrameLayout.LayoutParams lff;
    private ImageView lfg;
    private ImageView lfh;
    private ImageView lfi;
    private View lfj;
    private View lfl;
    private ImageView lfm;
    private CyberPlayerManager.OnPreparedListener lfn;
    private m lfo;
    private TextView lfp;
    private b lfs;
    private View lft;
    private View lfu;
    private TextView lfv;
    private SeekBar lfw;
    private ImageView lfx;
    private ImageView lfy;
    private int lfz;
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
    private int lfk = 0;
    protected boolean adq = false;
    private boolean adf = false;
    private boolean lfq = false;
    private boolean lfr = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int lfA = 0;
    private int lfB = 0;
    private boolean lfH = false;
    private boolean lfI = false;
    private boolean leT = true;
    private CyberPlayerManager.OnPreparedListener eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.adl);
            com.baidu.adp.lib.f.e.mA().post(c.this.adl);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.lfK);
            if (c.this.gBU != null && c.this.lfc != null) {
                if (c.this.lfI || c.this.adq) {
                    c.this.gBU.setVolume(1.0f, 1.0f);
                    ak.a(c.this.mWeakContext, true);
                } else {
                    c.this.gBU.setVolume(0.0f, 0.0f);
                    ak.a(c.this.mWeakContext, false);
                }
                c.this.lfc.bx(c.this.mStartPosition, c.this.gBU.getDuration());
                if (c.this.mStartPosition != 0) {
                    c.this.gBU.seekTo(c.this.mStartPosition);
                }
                if (c.this.lfn != null) {
                    c.this.lfn.onPrepared();
                }
            }
        }
    };
    private Runnable adl = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gBU.getCurrentPositionSync() > 100) {
                c.this.adf = true;
                c.this.lfd.setVisibility(8);
                c.this.iBB.setVisibility(8);
                c.this.kyz.setVisibility(8);
                c.this.anK.setVisibility(8);
                c.this.dcL();
                if (c.this.lfj != null) {
                    c.this.lfj.setVisibility(0);
                }
                c.this.lfc.showProgress();
                return;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(c.this.adl, 20L);
        }
    };
    private CyberPlayerManager.OnCompletionListener eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.lego.card.view.c.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            c.this.adf = false;
            c.this.mStartPosition = 0;
            if (c.this.adq) {
                c.this.dcw();
                c.this.dcH();
                c.this.dcM();
            } else {
                c.this.cSR();
            }
            if (c.this.lfo != null) {
                c.this.lfo.mB(c.this.mVideoUrl);
            }
        }
    };
    private CyberPlayerManager.OnErrorListener lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            c.this.iBB.setVisibility(0);
            c.this.kyz.setVisibility(8);
            return true;
        }
    };
    private Runnable lfK = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.iBB.setVisibility(0);
            c.this.kyz.setVisibility(8);
        }
    };
    private TbCyberVideoView.a fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.adf = false;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.adl);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(c.this.lfK);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.iBB.getId()) {
                if (view.getId() != c.this.lfm.getId() && view.getId() != c.this.lfh.getId()) {
                    if (view.getId() != c.this.lfi.getId()) {
                        if (view.getId() == c.this.hjx.getId()) {
                            TiebaStatic.log(new ar("c11713"));
                            c.this.Uc();
                            return;
                        } else if (view.getId() == c.this.bWp.getId()) {
                            if (c.this.adf || c.this.adq) {
                                c.this.dcM();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.lfg.getId() && !c.this.adq) {
                            if (c.this.lfI) {
                                c.this.gBU.setVolume(0.0f, 0.0f);
                                c.this.lfg.setImageResource(R.drawable.card_icon_sound_close);
                                ak.a(c.this.mWeakContext, false);
                                c.this.lfI = false;
                                return;
                            }
                            c.this.gBU.setVolume(1.0f, 1.0f);
                            c.this.lfg.setImageResource(R.drawable.card_icon_sound_open);
                            ak.a(c.this.mWeakContext, true);
                            c.this.lfI = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.adq) {
                        if (c.this.leZ != null) {
                            c.this.leZ.enableSwipeBack();
                        }
                        TiebaStatic.log(new ar("c11714"));
                    } else {
                        if (c.this.leZ != null) {
                            c.this.leZ.disableSwipeBack();
                        }
                        TiebaStatic.log(new ar("c11710"));
                        s.dDB().dDx().ej(c.this.statExtra, c.this.lfC);
                    }
                    c.this.Uc();
                    return;
                } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(c.this.eWx.getPageActivity(), c.this.eWx.getString(R.string.neterror));
                    return;
                } else if (!c.this.gBU.isPlaying()) {
                    if (c.this.adf) {
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
    private boolean lfL = false;
    private Animation.AnimationListener lfM = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.lfj != null) {
                c.this.lfj.setVisibility(8);
                c.this.lfr = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener lfN = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.lfq = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable lfO = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.dcJ();
        }
    };
    private CustomMessageListener lfP = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.lego.card.view.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface b {
        void rj();

        void rk();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.lfE = 0;
        this.mWeakContext = null;
        this.eWx = tbPageContext;
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.bWp = z(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.bWp);
        }
        this.gBU = (TbCyberVideoView) this.bWp.findViewById(R.id.videoView);
        this.gBU.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.kyz = this.bWp.findViewById(R.id.video_list_layout_loading);
        this.lfc = (VideoListMediaControllerView) this.bWp.findViewById(R.id.media_controller);
        this.lfc.setPlayer(this.gBU);
        this.lfd = this.bWp.findViewById(R.id.black_mask);
        this.iBB = this.bWp.findViewById(R.id.layout_error);
        this.iBB.setOnClickListener(this.mOnClickListener);
        this.lfe = (FrameLayout) this.bWp.findViewById(R.id.danmu_container);
        this.lfh = (ImageView) this.bWp.findViewById(R.id.img_play_icon);
        this.lfh.setOnClickListener(this.mOnClickListener);
        this.lfg = (ImageView) this.bWp.findViewById(R.id.img_sound_control);
        this.lfg.setOnClickListener(this.mOnClickListener);
        this.lfi = (ImageView) this.bWp.findViewById(R.id.card_img_full_screen);
        this.lfi.setOnClickListener(this.mOnClickListener);
        this.lfj = this.bWp.findViewById(R.id.card_layout_media_controller);
        this.lfb = this.bWp.findViewById(R.id.rl_control);
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnCompletionListener(this.eCd);
        this.gBU.setOnErrorListener(this.lfJ);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        this.lfm = (ImageView) this.bWp.findViewById(R.id.img_play);
        this.lfm.setOnClickListener(this.mOnClickListener);
        this.anK = (TbImageView) this.bWp.findViewById(R.id.video_thumbnail);
        this.anK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eWx.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eWx.getPageActivity());
        this.hjx = (ImageView) this.bWp.findViewById(R.id.img_exit);
        this.hjx.setOnClickListener(this.mOnClickListener);
        this.lfp = (TextView) this.bWp.findViewById(R.id.video_title);
        this.bNL = this.bWp.findViewById(R.id.layout_title);
        this.bNL.setVisibility(8);
        this.jpv = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.cjx = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.eWx.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.eWx.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.lfz = this.mAudioManager.getStreamMaxVolume(3);
        this.mVolume = this.mAudioManager.getStreamVolume(3);
        lfF = 100 / this.lfz;
        this.bWp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.adq && c.this.adf) {
                        if (c.this.mStatus == 1 && c.this.lfB != 0) {
                            c.this.c(c.this.lfB == 1 ? 1000.0f : -1000.0f, false);
                            c.this.lfB = 0;
                            c.this.lfA = 0;
                        }
                        if (!c.this.gBU.isPlaying() && 8 == c.this.lfm.getVisibility()) {
                            c.this.lfm.setVisibility(0);
                        }
                    }
                    c.this.dcw();
                }
                return onTouchEvent;
            }
        });
        this.lfD = new com.baidu.tieba.play.j(this.eWx.getPageActivity());
        this.lfD.start();
        this.lfE = com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.ds16);
        if (lfG == null) {
            lfG = new CallStateReceiver();
        }
        lfG.register(this.eWx.getPageActivity());
        this.eWx.registerListener(this.lfP);
    }

    public void a(o oVar) {
        this.lfa = oVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.leZ = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcw() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.lft != null && this.lft.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.lft);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.lfu != null && this.lfu.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.lfu);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void dcx() {
        if (this.mStatus == 1) {
            if (this.lft == null) {
                this.lft = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                this.lfv = (TextView) this.lft.findViewById(R.id.show_time);
                this.lfy = (ImageView) this.lft.findViewById(R.id.arrow_icon);
            }
            if (this.lft.getParent() == null) {
                this.mWindowManager.addView(this.lft, dcy());
            }
        } else if (this.mStatus == 2) {
            if (this.lfu == null) {
                this.lfu = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                this.lfx = (ImageView) this.lfu.findViewById(R.id.arrow_voice_icon);
                this.lfw = (SeekBar) this.lfu.findViewById(R.id.show_voice_seekbar);
            }
            if (this.lfu.getParent() == null) {
                this.mWindowManager.addView(this.lfu, dcy());
            }
        }
    }

    private WindowManager.LayoutParams dcy() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* loaded from: classes8.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.adq && c.this.adf) {
                if (!c.this.gBU.isPlaying() && c.this.lfm.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.lfm.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.dcz();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.lfA = c.this.gBU.getCurrentPositionSync();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aV(f2);
                    }
                } else if (c.this.mStatus == 1) {
                    c.this.c(f, true);
                } else if (c.this.mStatus == 2) {
                    c.this.aV(f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcz() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bWp.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bWp.setSystemUiVisibility(4);
        } else {
            this.bWp.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(float f) {
        if (!this.gBU.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        dcx();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % lfF == 0) {
            if (f > 0.0f && this.mVolume < this.lfz) {
                this.mVolume++;
            }
            if (f < 0.0f && this.mVolume > 0) {
                this.mVolume--;
            }
        }
        if (this.mVolume > 0) {
            this.lfx.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.lfx.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.mVolume, 0);
        this.lfw.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.lfA -= 1000;
                this.lfB = 1;
            } else {
                this.lfA += 1000;
                this.lfB = 2;
            }
            if (this.lfA < 0) {
                this.lfA = 0;
            } else if (this.lfA > this.gBU.getDuration()) {
                this.lfA = this.gBU.getDuration();
            }
        }
        dcx();
        String Ht = this.lfc.Ht(this.lfA);
        if (f > 0.0f) {
            this.lfy.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.lfy.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(Ht)) {
            this.lfv.setText(new StringBuilder().append(Ht).append("/").append(this.lfc.Ht(this.gBU.getDuration())));
        }
        this.lfc.setCurrentDuration(this.lfA, z ? false : true);
    }

    protected View z(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void Uc() {
        this.lfH = true;
        if (this.lfD != null) {
            this.lfD.Uc();
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gBU;
    }

    public VideoListMediaControllerView dcA() {
        return this.lfc;
    }

    public View dcB() {
        return this.lfj;
    }

    public void tL(boolean z) {
        if (z) {
            this.lfc.setVisibility(0);
            this.lfh.setVisibility(0);
            return;
        }
        this.lfc.setVisibility(8);
        this.lfh.setVisibility(8);
    }

    public void tJ(boolean z) {
        this.leT = z;
    }

    public void hide() {
        this.bWp.setVisibility(8);
    }

    public void show() {
        this.bWp.setVisibility(0);
    }

    public void dcC() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lfb.getLayoutParams();
        if (com.baidu.tieba.lego.card.c.e.as(this.eWx.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.eWx.getResources().getDimension(R.dimen.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.eWx.getResources().getDimension(R.dimen.ds30) + 0.5f);
        }
        this.lfb.setLayoutParams(layoutParams);
        this.lfi.setClickable(false);
        this.lfi.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lfg.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.lfg.setPadding((int) (this.eWx.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eWx.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eWx.getResources().getDimension(R.dimen.ds38) + 0.5f), (int) (this.eWx.getResources().getDimension(R.dimen.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.lfg.setLayoutParams(layoutParams2);
        }
    }

    public void dcD() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lfb.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.lfb.setLayoutParams(layoutParams);
        this.lfi.setClickable(true);
        this.lfi.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lfg.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, R.id.card_img_full_screen);
            this.lfg.setPadding((int) (this.eWx.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eWx.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eWx.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eWx.getResources().getDimension(R.dimen.ds16) + 0.5f));
            this.lfg.setLayoutParams(layoutParams2);
        }
    }

    public void dcE() {
        if (this.lfl != null) {
            this.lff = (FrameLayout.LayoutParams) this.bWp.getLayoutParams();
            this.lff.width = this.lfl.getWidth();
            this.lff.height = this.lfl.getHeight();
            int[] iArr = new int[2];
            this.lfl.getLocationOnScreen(iArr);
            this.lff.topMargin = iArr[1] - this.lfk;
            this.bWp.setLayoutParams(this.lff);
        }
    }

    public void Eb(int i) {
        if (this.lfa != null && i != this.lfa.getPage()) {
            this.lfa.stopPlay();
        }
    }

    public void dr(View view) {
        this.lfl = view;
    }

    public View dcF() {
        return this.lfl;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.adq = true;
            this.lfg.setVisibility(8);
            this.gBU.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
            this.bWp.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.bNL.setVisibility(0);
            tM(true);
            this.lfe.setVisibility(8);
            if (this.lfs != null) {
                this.lfs.rj();
            }
            dcM();
            this.lfi.setImageResource(R.drawable.icon_suoxiao);
            Ec(this.lfE);
            dcz();
            return;
        }
        this.adq = false;
        this.lfg.setVisibility(0);
        if (this.lfI) {
            this.gBU.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
        } else {
            this.gBU.setVolume(0.0f, 0.0f);
            ak.a(this.mWeakContext, false);
        }
        if (this.lff != null) {
            this.bWp.setLayoutParams(this.lff);
        }
        a(baseFragmentActivity, false);
        this.bNL.setVisibility(8);
        tM(false);
        this.lfe.setVisibility(0);
        if (this.lfs != null) {
            this.lfs.rk();
        }
        if (!this.adf && this.lfj != null) {
            this.lfj.clearAnimation();
            this.lfj.setVisibility(4);
        }
        dcw();
        this.lfi.setImageResource(R.drawable.icon_fangda);
        Ec(0);
        this.bWp.setSystemUiVisibility(0);
    }

    private void Ec(int i) {
        if (this.lfc != null && (this.lfc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lfc.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.lfc.setLayoutParams(layoutParams);
        }
    }

    protected void tM(boolean z) {
        if (z) {
            this.bWp.setOnClickListener(this.mOnClickListener);
        } else {
            this.bWp.setClickable(false);
        }
    }

    public void Ed(int i) {
        this.lfk = i;
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
            if (this.kyz.getVisibility() == 0) {
            }
        }
    }

    public boolean dcG() {
        return !this.adq;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.lfn = onPreparedListener;
    }

    public void a(m mVar) {
        this.lfo = mVar;
    }

    public void setPauseState() {
        this.lfh.setImageResource(R.drawable.icon_video_midpause);
        this.kyz.setVisibility(8);
        this.lfm.setVisibility(0);
    }

    public void dcH() {
        if (this.lfj != null) {
            this.lfd.setVisibility(0);
            this.lfm.setVisibility(0);
            this.kyz.setVisibility(8);
            this.lfh.setImageResource(R.drawable.icon_video_midpause);
            this.lfj.setVisibility(0);
            this.iBB.setVisibility(8);
            this.lfc.aRr();
            this.anK.setVisibility(0);
        }
    }

    public void Gg(String str) {
        this.gBU.setVideoPath(str);
        this.gBU.start();
        this.kyz.setVisibility(0);
        this.anK.setVisibility(0);
        this.lfm.setVisibility(8);
        this.lfh.setImageResource(R.drawable.icon_video_midplay);
        this.iBB.setVisibility(8);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.lfK, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void resumePlay() {
        this.gBU.start();
        this.lfh.setImageResource(R.drawable.icon_video_midplay);
        this.anK.setVisibility(8);
        this.lfd.setVisibility(8);
        this.kyz.setVisibility(8);
        this.lfc.showProgress();
        this.lfm.setVisibility(8);
    }

    public void pausePlay() {
        this.gBU.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adl);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        this.gBU.stopPlayback();
        this.adf = false;
        this.mStartPosition = 0;
        cSR();
    }

    public void cSR() {
        if (this.lfj != null) {
            this.lfd.setVisibility(0);
            this.lfm.setVisibility(0);
            this.kyz.setVisibility(8);
            this.lfh.setImageResource(R.drawable.icon_video_midpause);
            this.lfj.setVisibility(4);
            this.iBB.setVisibility(8);
            this.lfc.aRr();
            this.anK.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.lfL) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
            aVar.AB(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.lfL = true;
                    c.this.Gg(c.this.mVideoUrl);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eWx).bqz();
            return;
        }
        Gg(this.mVideoUrl);
    }

    public void setThumbnail(String str) {
        this.anK.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adl);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfK);
        this.lfD.stop();
        lfG.unregister(this.eWx.getPageActivity());
    }

    public void hh(long j) {
        au.numberUniformFormat(j);
    }

    public boolean dcI() {
        return this.adf;
    }

    public void clearAnimation() {
        dcL();
    }

    public void dcJ() {
        if (this.lfj != null && !this.lfr && this.lfj.getVisibility() == 0) {
            dcL();
            this.lfj.setVisibility(0);
            this.jpv.setAnimationListener(this.lfM);
            this.lfj.startAnimation(this.jpv);
            this.lfr = true;
        }
    }

    public void dcK() {
        if (this.lfj != null && !this.lfq) {
            if (this.lfr || this.lfj.getVisibility() != 0) {
                dcL();
                this.lfj.setVisibility(0);
                this.cjx.setAnimationListener(this.lfN);
                this.lfj.startAnimation(this.cjx);
                this.lfq = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcL() {
        if (this.lfj != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
            this.cjx.setAnimationListener(null);
            this.jpv.setAnimationListener(null);
            this.lfj.clearAnimation();
            this.lfr = false;
            this.lfq = false;
        }
    }

    public void dcM() {
        dcK();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfO);
        if (this.leT) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.lfO, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void a(b bVar) {
        this.lfs = bVar;
    }

    public void Ee(int i) {
        if (this.gBU.getDuration() - i <= 3000 && this.adq) {
            dcL();
            if (this.lfj != null) {
                this.lfj.setVisibility(0);
            }
        }
    }

    public void Ef(int i) {
        this.mStartPosition = i;
    }

    public boolean isShow() {
        return this.bWp.getVisibility() == 0;
    }

    public void fJ(String str, String str2) {
        this.statExtra = str;
        this.lfC = str2;
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
