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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ah;
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
    private static int kZQ;
    private static CallStateReceiver kZR;
    private TbImageView ant;
    private View bNn;
    protected View bVM;
    private Animation ciB;
    private TbPageContext<?> eXu;
    private TbCyberVideoView gBU;
    private ImageView hhZ;
    private View iyB;
    private Animation jmy;
    private b kZC;
    private View kZD;
    private View kZE;
    private TextView kZF;
    private SeekBar kZG;
    private ImageView kZH;
    private ImageView kZI;
    private int kZJ;
    private String kZM;
    private com.baidu.tieba.play.j kZN;
    private int kZO;
    private int kZP;
    SwipeBackLayout.c kZj;
    o kZk;
    private View kZl;
    private VideoListMediaControllerView kZm;
    private View kZn;
    private FrameLayout kZo;
    protected FrameLayout.LayoutParams kZp;
    private ImageView kZq;
    private ImageView kZr;
    private ImageView kZs;
    private View kZt;
    private View kZv;
    private ImageView kZw;
    private CyberPlayerManager.OnPreparedListener kZx;
    private m kZy;
    private TextView kZz;
    private View ksH;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private WeakReference<Context> mWeakContext;
    private WindowManager mWindowManager;
    private String statExtra;
    private int kZu = 0;
    protected boolean aca = false;
    private boolean abP = false;
    private boolean kZA = false;
    private boolean kZB = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kZK = 0;
    private int kZL = 0;
    private boolean kZS = false;
    private boolean kZT = false;
    private boolean kZd = true;
    private CyberPlayerManager.OnPreparedListener eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abV);
            com.baidu.adp.lib.f.e.mB().post(c.this.abV);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.kZV);
            if (c.this.gBU != null && c.this.kZm != null) {
                if (c.this.kZT || c.this.aca) {
                    c.this.gBU.setVolume(1.0f, 1.0f);
                    ah.a(c.this.mWeakContext, true);
                } else {
                    c.this.gBU.setVolume(0.0f, 0.0f);
                    ah.a(c.this.mWeakContext, false);
                }
                c.this.kZm.bz(c.this.mStartPosition, c.this.gBU.getDuration());
                if (c.this.mStartPosition != 0) {
                    c.this.gBU.seekTo(c.this.mStartPosition);
                }
                if (c.this.kZx != null) {
                    c.this.kZx.onPrepared();
                }
            }
        }
    };
    private Runnable abV = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gBU.getCurrentPositionSync() > 100) {
                c.this.abP = true;
                c.this.kZn.setVisibility(8);
                c.this.iyB.setVisibility(8);
                c.this.ksH.setVisibility(8);
                c.this.ant.setVisibility(8);
                c.this.dep();
                if (c.this.kZt != null) {
                    c.this.kZt.setVisibility(0);
                }
                c.this.kZm.showProgress();
                return;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abV, 20L);
        }
    };
    private CyberPlayerManager.OnCompletionListener eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.lego.card.view.c.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            c.this.abP = false;
            c.this.mStartPosition = 0;
            if (c.this.aca) {
                c.this.dea();
                c.this.del();
                c.this.deq();
            } else {
                c.this.cUw();
            }
            if (c.this.kZy != null) {
                c.this.kZy.nn(c.this.mVideoUrl);
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            c.this.iyB.setVisibility(0);
            c.this.ksH.setVisibility(8);
            return true;
        }
    };
    private Runnable kZV = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.iyB.setVisibility(0);
            c.this.ksH.setVisibility(8);
        }
    };
    private TbCyberVideoView.a fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abP = false;
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abV);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.kZV);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.iyB.getId()) {
                if (view.getId() != c.this.kZw.getId() && view.getId() != c.this.kZr.getId()) {
                    if (view.getId() != c.this.kZs.getId()) {
                        if (view.getId() == c.this.hhZ.getId()) {
                            TiebaStatic.log(new aq("c11713"));
                            c.this.Wl();
                            return;
                        } else if (view.getId() == c.this.bVM.getId()) {
                            if (c.this.abP || c.this.aca) {
                                c.this.deq();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.kZq.getId() && !c.this.aca) {
                            if (c.this.kZT) {
                                c.this.gBU.setVolume(0.0f, 0.0f);
                                c.this.kZq.setImageResource(R.drawable.card_icon_sound_close);
                                ah.a(c.this.mWeakContext, false);
                                c.this.kZT = false;
                                return;
                            }
                            c.this.gBU.setVolume(1.0f, 1.0f);
                            c.this.kZq.setImageResource(R.drawable.card_icon_sound_open);
                            ah.a(c.this.mWeakContext, true);
                            c.this.kZT = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.aca) {
                        if (c.this.kZj != null) {
                            c.this.kZj.enableSwipeBack();
                        }
                        TiebaStatic.log(new aq("c11714"));
                    } else {
                        if (c.this.kZj != null) {
                            c.this.kZj.disableSwipeBack();
                        }
                        TiebaStatic.log(new aq("c11710"));
                        r.dEW().dES().em(c.this.statExtra, c.this.kZM);
                    }
                    c.this.Wl();
                    return;
                } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(c.this.eXu.getPageActivity(), c.this.eXu.getString(R.string.neterror));
                    return;
                } else if (!c.this.gBU.isPlaying()) {
                    if (c.this.abP) {
                        c.this.aUE();
                        return;
                    } else {
                        c.this.performPlay();
                        return;
                    }
                } else {
                    c.this.aUD();
                    return;
                }
            }
            c.this.performPlay();
        }
    };
    private boolean kZW = false;
    private Animation.AnimationListener kZX = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.kZt != null) {
                c.this.kZt.setVisibility(8);
                c.this.kZB = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener kZY = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.kZA = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable kZZ = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.den();
        }
    };
    private CustomMessageListener laa = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.lego.card.view.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aUD();
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface b {
        void rl();

        void rm();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.kZO = 0;
        this.mWeakContext = null;
        this.eXu = tbPageContext;
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.bVM = x(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.bVM);
        }
        this.gBU = (TbCyberVideoView) this.bVM.findViewById(R.id.videoView);
        this.gBU.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.ksH = this.bVM.findViewById(R.id.video_list_layout_loading);
        this.kZm = (VideoListMediaControllerView) this.bVM.findViewById(R.id.media_controller);
        this.kZm.setPlayer(this.gBU);
        this.kZn = this.bVM.findViewById(R.id.black_mask);
        this.iyB = this.bVM.findViewById(R.id.layout_error);
        this.iyB.setOnClickListener(this.mOnClickListener);
        this.kZo = (FrameLayout) this.bVM.findViewById(R.id.danmu_container);
        this.kZr = (ImageView) this.bVM.findViewById(R.id.img_play_icon);
        this.kZr.setOnClickListener(this.mOnClickListener);
        this.kZq = (ImageView) this.bVM.findViewById(R.id.img_sound_control);
        this.kZq.setOnClickListener(this.mOnClickListener);
        this.kZs = (ImageView) this.bVM.findViewById(R.id.card_img_full_screen);
        this.kZs.setOnClickListener(this.mOnClickListener);
        this.kZt = this.bVM.findViewById(R.id.card_layout_media_controller);
        this.kZl = this.bVM.findViewById(R.id.rl_control);
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnCompletionListener(this.eDh);
        this.gBU.setOnErrorListener(this.kZU);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        this.kZw = (ImageView) this.bVM.findViewById(R.id.img_play);
        this.kZw.setOnClickListener(this.mOnClickListener);
        this.ant = (TbImageView) this.bVM.findViewById(R.id.video_thumbnail);
        this.ant.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eXu.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eXu.getPageActivity());
        this.hhZ = (ImageView) this.bVM.findViewById(R.id.img_exit);
        this.hhZ.setOnClickListener(this.mOnClickListener);
        this.kZz = (TextView) this.bVM.findViewById(R.id.video_title);
        this.bNn = this.bVM.findViewById(R.id.layout_title);
        this.bNn.setVisibility(8);
        this.jmy = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.ciB = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.eXu.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.eXu.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.kZJ = this.mAudioManager.getStreamMaxVolume(3);
        this.kZP = this.mAudioManager.getStreamVolume(3);
        kZQ = 100 / this.kZJ;
        this.bVM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.aca && c.this.abP) {
                        if (c.this.mStatus == 1 && c.this.kZL != 0) {
                            c.this.c(c.this.kZL == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kZL = 0;
                            c.this.kZK = 0;
                        }
                        if (!c.this.gBU.isPlaying() && 8 == c.this.kZw.getVisibility()) {
                            c.this.kZw.setVisibility(0);
                        }
                    }
                    c.this.dea();
                }
                return onTouchEvent;
            }
        });
        this.kZN = new com.baidu.tieba.play.j(this.eXu.getPageActivity());
        this.kZN.start();
        this.kZO = com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.ds16);
        if (kZR == null) {
            kZR = new CallStateReceiver();
        }
        kZR.register(this.eXu.getPageActivity());
        this.eXu.registerListener(this.laa);
    }

    public void a(o oVar) {
        this.kZk = oVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.kZj = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dea() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.kZD != null && this.kZD.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.kZD);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.kZE != null && this.kZE.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.kZE);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void deb() {
        if (this.mStatus == 1) {
            if (this.kZD == null) {
                this.kZD = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                this.kZF = (TextView) this.kZD.findViewById(R.id.show_time);
                this.kZI = (ImageView) this.kZD.findViewById(R.id.arrow_icon);
            }
            if (this.kZD.getParent() == null) {
                this.mWindowManager.addView(this.kZD, dec());
            }
        } else if (this.mStatus == 2) {
            if (this.kZE == null) {
                this.kZE = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                this.kZH = (ImageView) this.kZE.findViewById(R.id.arrow_voice_icon);
                this.kZG = (SeekBar) this.kZE.findViewById(R.id.show_voice_seekbar);
            }
            if (this.kZE.getParent() == null) {
                this.mWindowManager.addView(this.kZE, dec());
            }
        }
    }

    private WindowManager.LayoutParams dec() {
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
            if (c.this.aca && c.this.abP) {
                if (!c.this.gBU.isPlaying() && c.this.kZw.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.kZw.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.ded();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kZK = c.this.gBU.getCurrentPositionSync();
                        c.this.c(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aO(f2);
                    }
                } else if (c.this.mStatus == 1) {
                    c.this.c(f, true);
                } else if (c.this.mStatus == 2) {
                    c.this.aO(f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ded() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bVM.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bVM.setSystemUiVisibility(4);
        } else {
            this.bVM.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f) {
        if (!this.gBU.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        deb();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kZQ == 0) {
            if (f > 0.0f && this.kZP < this.kZJ) {
                this.kZP++;
            }
            if (f < 0.0f && this.kZP > 0) {
                this.kZP--;
            }
        }
        if (this.kZP > 0) {
            this.kZH.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kZH.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kZP, 0);
        this.kZG.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.kZK -= 1000;
                this.kZL = 1;
            } else {
                this.kZK += 1000;
                this.kZL = 2;
            }
            if (this.kZK < 0) {
                this.kZK = 0;
            } else if (this.kZK > this.gBU.getDuration()) {
                this.kZK = this.gBU.getDuration();
            }
        }
        deb();
        String IF = this.kZm.IF(this.kZK);
        if (f > 0.0f) {
            this.kZI.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kZI.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(IF)) {
            this.kZF.setText(new StringBuilder().append(IF).append("/").append(this.kZm.IF(this.gBU.getDuration())));
        }
        this.kZm.setCurrentDuration(this.kZK, z ? false : true);
    }

    protected View x(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void Wl() {
        this.kZS = true;
        if (this.kZN != null) {
            this.kZN.Wl();
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gBU;
    }

    public VideoListMediaControllerView dee() {
        return this.kZm;
    }

    public View def() {
        return this.kZt;
    }

    public void tC(boolean z) {
        if (z) {
            this.kZm.setVisibility(0);
            this.kZr.setVisibility(0);
            return;
        }
        this.kZm.setVisibility(8);
        this.kZr.setVisibility(8);
    }

    public void tA(boolean z) {
        this.kZd = z;
    }

    public void hide() {
        this.bVM.setVisibility(8);
    }

    public void show() {
        this.bVM.setVisibility(0);
    }

    public void deg() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kZl.getLayoutParams();
        if (com.baidu.tieba.lego.card.c.e.ay(this.eXu.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.eXu.getResources().getDimension(R.dimen.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.eXu.getResources().getDimension(R.dimen.ds30) + 0.5f);
        }
        this.kZl.setLayoutParams(layoutParams);
        this.kZs.setClickable(false);
        this.kZs.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kZq.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.kZq.setPadding((int) (this.eXu.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eXu.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eXu.getResources().getDimension(R.dimen.ds38) + 0.5f), (int) (this.eXu.getResources().getDimension(R.dimen.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.kZq.setLayoutParams(layoutParams2);
        }
    }

    public void deh() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kZl.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.kZl.setLayoutParams(layoutParams);
        this.kZs.setClickable(true);
        this.kZs.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kZq.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, R.id.card_img_full_screen);
            this.kZq.setPadding((int) (this.eXu.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eXu.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eXu.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eXu.getResources().getDimension(R.dimen.ds16) + 0.5f));
            this.kZq.setLayoutParams(layoutParams2);
        }
    }

    public void dei() {
        if (this.kZv != null) {
            this.kZp = (FrameLayout.LayoutParams) this.bVM.getLayoutParams();
            this.kZp.width = this.kZv.getWidth();
            this.kZp.height = this.kZv.getHeight();
            int[] iArr = new int[2];
            this.kZv.getLocationOnScreen(iArr);
            this.kZp.topMargin = iArr[1] - this.kZu;
            this.bVM.setLayoutParams(this.kZp);
        }
    }

    public void Fm(int i) {
        if (this.kZk != null && i != this.kZk.getPage()) {
            this.kZk.stopPlay();
        }
    }

    public void dt(View view) {
        this.kZv = view;
    }

    public View dej() {
        return this.kZv;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.aca = true;
            this.kZq.setVisibility(8);
            this.gBU.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
            this.bVM.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.bNn.setVisibility(0);
            tD(true);
            this.kZo.setVisibility(8);
            if (this.kZC != null) {
                this.kZC.rl();
            }
            deq();
            this.kZs.setImageResource(R.drawable.icon_suoxiao);
            Fn(this.kZO);
            ded();
            return;
        }
        this.aca = false;
        this.kZq.setVisibility(0);
        if (this.kZT) {
            this.gBU.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
        } else {
            this.gBU.setVolume(0.0f, 0.0f);
            ah.a(this.mWeakContext, false);
        }
        if (this.kZp != null) {
            this.bVM.setLayoutParams(this.kZp);
        }
        a(baseFragmentActivity, false);
        this.bNn.setVisibility(8);
        tD(false);
        this.kZo.setVisibility(0);
        if (this.kZC != null) {
            this.kZC.rm();
        }
        if (!this.abP && this.kZt != null) {
            this.kZt.clearAnimation();
            this.kZt.setVisibility(4);
        }
        dea();
        this.kZs.setImageResource(R.drawable.icon_fangda);
        Fn(0);
        this.bVM.setSystemUiVisibility(0);
    }

    private void Fn(int i) {
        if (this.kZm != null && (this.kZm.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kZm.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.kZm.setLayoutParams(layoutParams);
        }
    }

    protected void tD(boolean z) {
        if (z) {
            this.bVM.setOnClickListener(this.mOnClickListener);
        } else {
            this.bVM.setClickable(false);
        }
    }

    public void Fo(int i) {
        this.kZu = i;
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
            if (this.ksH.getVisibility() == 0) {
            }
        }
    }

    public boolean dek() {
        return !this.aca;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kZx = onPreparedListener;
    }

    public void a(m mVar) {
        this.kZy = mVar;
    }

    public void setPauseState() {
        this.kZr.setImageResource(R.drawable.icon_video_midpause);
        this.ksH.setVisibility(8);
        this.kZw.setVisibility(0);
    }

    public void del() {
        if (this.kZt != null) {
            this.kZn.setVisibility(0);
            this.kZw.setVisibility(0);
            this.ksH.setVisibility(8);
            this.kZr.setImageResource(R.drawable.icon_video_midpause);
            this.kZt.setVisibility(0);
            this.iyB.setVisibility(8);
            this.kZm.aUS();
            this.ant.setVisibility(0);
        }
    }

    public void GJ(String str) {
        this.gBU.setVideoPath(str);
        this.gBU.start();
        this.ksH.setVisibility(0);
        this.ant.setVisibility(0);
        this.kZw.setVisibility(8);
        this.kZr.setImageResource(R.drawable.icon_video_midplay);
        this.iyB.setVisibility(8);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.kZV, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void aUE() {
        this.gBU.start();
        this.kZr.setImageResource(R.drawable.icon_video_midplay);
        this.ant.setVisibility(8);
        this.kZn.setVisibility(8);
        this.ksH.setVisibility(8);
        this.kZm.showProgress();
        this.kZw.setVisibility(8);
    }

    public void aUD() {
        this.gBU.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abV);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        this.gBU.stopPlayback();
        this.abP = false;
        this.mStartPosition = 0;
        cUw();
    }

    public void cUw() {
        if (this.kZt != null) {
            this.kZn.setVisibility(0);
            this.kZw.setVisibility(0);
            this.ksH.setVisibility(8);
            this.kZr.setImageResource(R.drawable.icon_video_midpause);
            this.kZt.setVisibility(4);
            this.iyB.setVisibility(8);
            this.kZm.aUS();
            this.ant.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kZW) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
            aVar.Bo(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.kZW = true;
                    c.this.GJ(c.this.mVideoUrl);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eXu).btY();
            return;
        }
        GJ(this.mVideoUrl);
    }

    public void setThumbnail(String str) {
        this.ant.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abV);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZV);
        this.kZN.stop();
        kZR.unregister(this.eXu.getPageActivity());
    }

    public void hc(long j) {
        at.numberUniformFormat(j);
    }

    public boolean dem() {
        return this.abP;
    }

    public void clearAnimation() {
        dep();
    }

    public void den() {
        if (this.kZt != null && !this.kZB && this.kZt.getVisibility() == 0) {
            dep();
            this.kZt.setVisibility(0);
            this.jmy.setAnimationListener(this.kZX);
            this.kZt.startAnimation(this.jmy);
            this.kZB = true;
        }
    }

    public void deo() {
        if (this.kZt != null && !this.kZA) {
            if (this.kZB || this.kZt.getVisibility() != 0) {
                dep();
                this.kZt.setVisibility(0);
                this.ciB.setAnimationListener(this.kZY);
                this.kZt.startAnimation(this.ciB);
                this.kZA = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dep() {
        if (this.kZt != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
            this.ciB.setAnimationListener(null);
            this.jmy.setAnimationListener(null);
            this.kZt.clearAnimation();
            this.kZB = false;
            this.kZA = false;
        }
    }

    public void deq() {
        deo();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kZZ);
        if (this.kZd) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kZZ, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void a(b bVar) {
        this.kZC = bVar;
    }

    public void Fp(int i) {
        if (this.gBU.getDuration() - i <= 3000 && this.aca) {
            dep();
            if (this.kZt != null) {
                this.kZt.setVisibility(0);
            }
        }
    }

    public void Fq(int i) {
        this.mStartPosition = i;
    }

    public boolean isShow() {
        return this.bVM.getVisibility() == 0;
    }

    public void fK(String str, String str2) {
        this.statExtra = str;
        this.kZM = str2;
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
