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
/* loaded from: classes8.dex */
public class c {
    private static int kVl;
    private static CallStateReceiver kVm;
    private TbImageView amC;
    private View bIB;
    protected View bRa;
    private Animation cdO;
    private TbPageContext<?> eSJ;
    private TbCyberVideoView gxn;
    private ImageView hdt;
    private View itU;
    private Animation jhQ;
    SwipeBackLayout.c kUE;
    o kUF;
    private View kUG;
    private VideoListMediaControllerView kUH;
    private View kUI;
    private FrameLayout kUJ;
    protected FrameLayout.LayoutParams kUK;
    private ImageView kUL;
    private ImageView kUM;
    private ImageView kUN;
    private View kUO;
    private View kUQ;
    private ImageView kUR;
    private CyberPlayerManager.OnPreparedListener kUS;
    private m kUT;
    private TextView kUU;
    private b kUX;
    private View kUY;
    private View kUZ;
    private TextView kVa;
    private SeekBar kVb;
    private ImageView kVc;
    private ImageView kVd;
    private int kVe;
    private String kVh;
    private com.baidu.tieba.play.j kVi;
    private int kVj;
    private int kVk;
    private View koc;
    private AudioManager mAudioManager;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mVideoUrl;
    private WeakReference<Context> mWeakContext;
    private WindowManager mWindowManager;
    private String statExtra;
    private int kUP = 0;
    protected boolean abY = false;
    private boolean abN = false;
    private boolean kUV = false;
    private boolean kUW = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int kVf = 0;
    private int kVg = 0;
    private boolean kVn = false;
    private boolean kVo = false;
    private boolean kUy = true;
    private CyberPlayerManager.OnPreparedListener eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abT);
            com.baidu.adp.lib.f.e.mB().post(c.this.abT);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.kVq);
            if (c.this.gxn != null && c.this.kUH != null) {
                if (c.this.kVo || c.this.abY) {
                    c.this.gxn.setVolume(1.0f, 1.0f);
                    ah.a(c.this.mWeakContext, true);
                } else {
                    c.this.gxn.setVolume(0.0f, 0.0f);
                    ah.a(c.this.mWeakContext, false);
                }
                c.this.kUH.bz(c.this.mStartPosition, c.this.gxn.getDuration());
                if (c.this.mStartPosition != 0) {
                    c.this.gxn.seekTo(c.this.mStartPosition);
                }
                if (c.this.kUS != null) {
                    c.this.kUS.onPrepared();
                }
            }
        }
    };
    private Runnable abT = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.gxn.getCurrentPositionSync() > 100) {
                c.this.abN = true;
                c.this.kUI.setVisibility(8);
                c.this.itU.setVisibility(8);
                c.this.koc.setVisibility(8);
                c.this.amC.setVisibility(8);
                c.this.dax();
                if (c.this.kUO != null) {
                    c.this.kUO.setVisibility(0);
                }
                c.this.kUH.showProgress();
                return;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(c.this.abT, 20L);
        }
    };
    private CyberPlayerManager.OnCompletionListener eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.lego.card.view.c.9
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            c.this.abN = false;
            c.this.mStartPosition = 0;
            if (c.this.abY) {
                c.this.dai();
                c.this.dat();
                c.this.day();
            } else {
                c.this.cQE();
            }
            if (c.this.kUT != null) {
                c.this.kUT.mc(c.this.mVideoUrl);
            }
        }
    };
    private CyberPlayerManager.OnErrorListener kVp = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            c.this.itU.setVisibility(0);
            c.this.koc.setVisibility(8);
            return true;
        }
    };
    private Runnable kVq = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.itU.setVisibility(0);
            c.this.koc.setVisibility(8);
        }
    };
    private TbCyberVideoView.a fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
        public void onSurfaceDestroyed() {
            c.this.abN = false;
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.abT);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(c.this.kVq);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.itU.getId()) {
                if (view.getId() != c.this.kUR.getId() && view.getId() != c.this.kUM.getId()) {
                    if (view.getId() != c.this.kUN.getId()) {
                        if (view.getId() == c.this.hdt.getId()) {
                            TiebaStatic.log(new aq("c11713"));
                            c.this.Ss();
                            return;
                        } else if (view.getId() == c.this.bRa.getId()) {
                            if (c.this.abN || c.this.abY) {
                                c.this.day();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.kUL.getId() && !c.this.abY) {
                            if (c.this.kVo) {
                                c.this.gxn.setVolume(0.0f, 0.0f);
                                c.this.kUL.setImageResource(R.drawable.card_icon_sound_close);
                                ah.a(c.this.mWeakContext, false);
                                c.this.kVo = false;
                                return;
                            }
                            c.this.gxn.setVolume(1.0f, 1.0f);
                            c.this.kUL.setImageResource(R.drawable.card_icon_sound_open);
                            ah.a(c.this.mWeakContext, true);
                            c.this.kVo = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.abY) {
                        if (c.this.kUE != null) {
                            c.this.kUE.enableSwipeBack();
                        }
                        TiebaStatic.log(new aq("c11714"));
                    } else {
                        if (c.this.kUE != null) {
                            c.this.kUE.disableSwipeBack();
                        }
                        TiebaStatic.log(new aq("c11710"));
                        r.dBe().dBa().el(c.this.statExtra, c.this.kVh);
                    }
                    c.this.Ss();
                    return;
                } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showLongToast(c.this.eSJ.getPageActivity(), c.this.eSJ.getString(R.string.neterror));
                    return;
                } else if (!c.this.gxn.isPlaying()) {
                    if (c.this.abN) {
                        c.this.aQK();
                        return;
                    } else {
                        c.this.performPlay();
                        return;
                    }
                } else {
                    c.this.aQJ();
                    return;
                }
            }
            c.this.performPlay();
        }
    };
    private boolean kVr = false;
    private Animation.AnimationListener kVs = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.kUO != null) {
                c.this.kUO.setVisibility(8);
                c.this.kUW = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener kVt = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.kUV = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable kVu = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.dav();
        }
    };
    private CustomMessageListener kVv = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.lego.card.view.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.aQJ();
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface b {
        void rl();

        void rm();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.kVj = 0;
        this.mWeakContext = null;
        this.eSJ = tbPageContext;
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        this.bRa = x(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.bRa);
        }
        this.gxn = (TbCyberVideoView) this.bRa.findViewById(R.id.videoView);
        this.gxn.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.koc = this.bRa.findViewById(R.id.video_list_layout_loading);
        this.kUH = (VideoListMediaControllerView) this.bRa.findViewById(R.id.media_controller);
        this.kUH.setPlayer(this.gxn);
        this.kUI = this.bRa.findViewById(R.id.black_mask);
        this.itU = this.bRa.findViewById(R.id.layout_error);
        this.itU.setOnClickListener(this.mOnClickListener);
        this.kUJ = (FrameLayout) this.bRa.findViewById(R.id.danmu_container);
        this.kUM = (ImageView) this.bRa.findViewById(R.id.img_play_icon);
        this.kUM.setOnClickListener(this.mOnClickListener);
        this.kUL = (ImageView) this.bRa.findViewById(R.id.img_sound_control);
        this.kUL.setOnClickListener(this.mOnClickListener);
        this.kUN = (ImageView) this.bRa.findViewById(R.id.card_img_full_screen);
        this.kUN.setOnClickListener(this.mOnClickListener);
        this.kUO = this.bRa.findViewById(R.id.card_layout_media_controller);
        this.kUG = this.bRa.findViewById(R.id.rl_control);
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnCompletionListener(this.eyv);
        this.gxn.setOnErrorListener(this.kVp);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        this.kUR = (ImageView) this.bRa.findViewById(R.id.img_play);
        this.kUR.setOnClickListener(this.mOnClickListener);
        this.amC = (TbImageView) this.bRa.findViewById(R.id.video_thumbnail);
        this.amC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eSJ.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.eSJ.getPageActivity());
        this.hdt = (ImageView) this.bRa.findViewById(R.id.img_exit);
        this.hdt.setOnClickListener(this.mOnClickListener);
        this.kUU = (TextView) this.bRa.findViewById(R.id.video_title);
        this.bIB = this.bRa.findViewById(R.id.layout_title);
        this.bIB.setVisibility(8);
        this.jhQ = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.cdO = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.eSJ.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.eSJ.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.kVe = this.mAudioManager.getStreamMaxVolume(3);
        this.kVk = this.mAudioManager.getStreamVolume(3);
        kVl = 100 / this.kVe;
        this.bRa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.abY && c.this.abN) {
                        if (c.this.mStatus == 1 && c.this.kVg != 0) {
                            c.this.c(c.this.kVg == 1 ? 1000.0f : -1000.0f, false);
                            c.this.kVg = 0;
                            c.this.kVf = 0;
                        }
                        if (!c.this.gxn.isPlaying() && 8 == c.this.kUR.getVisibility()) {
                            c.this.kUR.setVisibility(0);
                        }
                    }
                    c.this.dai();
                }
                return onTouchEvent;
            }
        });
        this.kVi = new com.baidu.tieba.play.j(this.eSJ.getPageActivity());
        this.kVi.start();
        this.kVj = com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds16);
        if (kVm == null) {
            kVm = new CallStateReceiver();
        }
        kVm.register(this.eSJ.getPageActivity());
        this.eSJ.registerListener(this.kVv);
    }

    public void a(o oVar) {
        this.kUF = oVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.kUE = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dai() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.kUY != null && this.kUY.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.kUY);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.kUZ != null && this.kUZ.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.kUZ);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void daj() {
        if (this.mStatus == 1) {
            if (this.kUY == null) {
                this.kUY = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                this.kVa = (TextView) this.kUY.findViewById(R.id.show_time);
                this.kVd = (ImageView) this.kUY.findViewById(R.id.arrow_icon);
            }
            if (this.kUY.getParent() == null) {
                this.mWindowManager.addView(this.kUY, dak());
            }
        } else if (this.mStatus == 2) {
            if (this.kUZ == null) {
                this.kUZ = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                this.kVc = (ImageView) this.kUZ.findViewById(R.id.arrow_voice_icon);
                this.kVb = (SeekBar) this.kUZ.findViewById(R.id.show_voice_seekbar);
            }
            if (this.kUZ.getParent() == null) {
                this.mWindowManager.addView(this.kUZ, dak());
            }
        }
    }

    private WindowManager.LayoutParams dak() {
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
            if (c.this.abY && c.this.abN) {
                if (!c.this.gxn.isPlaying() && c.this.kUR.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.kUR.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.dal();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.kVf = c.this.gxn.getCurrentPositionSync();
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
    public void dal() {
        if (Build.VERSION.SDK_INT < 16) {
            this.bRa.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.bRa.setSystemUiVisibility(4);
        } else {
            this.bRa.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f) {
        if (!this.gxn.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        daj();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % kVl == 0) {
            if (f > 0.0f && this.kVk < this.kVe) {
                this.kVk++;
            }
            if (f < 0.0f && this.kVk > 0) {
                this.kVk--;
            }
        }
        if (this.kVk > 0) {
            this.kVc.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.kVc.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.kVk, 0);
        this.kVb.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.kVf -= 1000;
                this.kVg = 1;
            } else {
                this.kVf += 1000;
                this.kVg = 2;
            }
            if (this.kVf < 0) {
                this.kVf = 0;
            } else if (this.kVf > this.gxn.getDuration()) {
                this.kVf = this.gxn.getDuration();
            }
        }
        daj();
        String GY = this.kUH.GY(this.kVf);
        if (f > 0.0f) {
            this.kVd.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.kVd.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(GY)) {
            this.kVa.setText(new StringBuilder().append(GY).append("/").append(this.kUH.GY(this.gxn.getDuration())));
        }
        this.kUH.setCurrentDuration(this.kVf, z ? false : true);
    }

    protected View x(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void Ss() {
        this.kVn = true;
        if (this.kVi != null) {
            this.kVi.Ss();
        }
    }

    public TbCyberVideoView getVideoView() {
        return this.gxn;
    }

    public VideoListMediaControllerView dam() {
        return this.kUH;
    }

    public View dan() {
        return this.kUO;
    }

    public void ty(boolean z) {
        if (z) {
            this.kUH.setVisibility(0);
            this.kUM.setVisibility(0);
            return;
        }
        this.kUH.setVisibility(8);
        this.kUM.setVisibility(8);
    }

    public void tw(boolean z) {
        this.kUy = z;
    }

    public void hide() {
        this.bRa.setVisibility(8);
    }

    public void show() {
        this.bRa.setVisibility(0);
    }

    public void dao() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUG.getLayoutParams();
        if (com.baidu.tieba.lego.card.c.e.ay(this.eSJ.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.eSJ.getResources().getDimension(R.dimen.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.eSJ.getResources().getDimension(R.dimen.ds30) + 0.5f);
        }
        this.kUG.setLayoutParams(layoutParams);
        this.kUN.setClickable(false);
        this.kUN.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kUL.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.kUL.setPadding((int) (this.eSJ.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eSJ.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eSJ.getResources().getDimension(R.dimen.ds38) + 0.5f), (int) (this.eSJ.getResources().getDimension(R.dimen.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.kUL.setLayoutParams(layoutParams2);
        }
    }

    public void dap() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUG.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.kUG.setLayoutParams(layoutParams);
        this.kUN.setClickable(true);
        this.kUN.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kUL.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, R.id.card_img_full_screen);
            this.kUL.setPadding((int) (this.eSJ.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.eSJ.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eSJ.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.eSJ.getResources().getDimension(R.dimen.ds16) + 0.5f));
            this.kUL.setLayoutParams(layoutParams2);
        }
    }

    public void daq() {
        if (this.kUQ != null) {
            this.kUK = (FrameLayout.LayoutParams) this.bRa.getLayoutParams();
            this.kUK.width = this.kUQ.getWidth();
            this.kUK.height = this.kUQ.getHeight();
            int[] iArr = new int[2];
            this.kUQ.getLocationOnScreen(iArr);
            this.kUK.topMargin = iArr[1] - this.kUP;
            this.bRa.setLayoutParams(this.kUK);
        }
    }

    public void DG(int i) {
        if (this.kUF != null && i != this.kUF.getPage()) {
            this.kUF.stopPlay();
        }
    }

    public void dt(View view) {
        this.kUQ = view;
    }

    public View dar() {
        return this.kUQ;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.abY = true;
            this.kUL.setVisibility(8);
            this.gxn.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
            this.bRa.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.bIB.setVisibility(0);
            tz(true);
            this.kUJ.setVisibility(8);
            if (this.kUX != null) {
                this.kUX.rl();
            }
            day();
            this.kUN.setImageResource(R.drawable.icon_suoxiao);
            DH(this.kVj);
            dal();
            return;
        }
        this.abY = false;
        this.kUL.setVisibility(0);
        if (this.kVo) {
            this.gxn.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
        } else {
            this.gxn.setVolume(0.0f, 0.0f);
            ah.a(this.mWeakContext, false);
        }
        if (this.kUK != null) {
            this.bRa.setLayoutParams(this.kUK);
        }
        a(baseFragmentActivity, false);
        this.bIB.setVisibility(8);
        tz(false);
        this.kUJ.setVisibility(0);
        if (this.kUX != null) {
            this.kUX.rm();
        }
        if (!this.abN && this.kUO != null) {
            this.kUO.clearAnimation();
            this.kUO.setVisibility(4);
        }
        dai();
        this.kUN.setImageResource(R.drawable.icon_fangda);
        DH(0);
        this.bRa.setSystemUiVisibility(0);
    }

    private void DH(int i) {
        if (this.kUH != null && (this.kUH.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kUH.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.kUH.setLayoutParams(layoutParams);
        }
    }

    protected void tz(boolean z) {
        if (z) {
            this.bRa.setOnClickListener(this.mOnClickListener);
        } else {
            this.bRa.setClickable(false);
        }
    }

    public void DI(int i) {
        this.kUP = i;
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
            if (this.koc.getVisibility() == 0) {
            }
        }
    }

    public boolean das() {
        return !this.abY;
    }

    public void a(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.kUS = onPreparedListener;
    }

    public void a(m mVar) {
        this.kUT = mVar;
    }

    public void setPauseState() {
        this.kUM.setImageResource(R.drawable.icon_video_midpause);
        this.koc.setVisibility(8);
        this.kUR.setVisibility(0);
    }

    public void dat() {
        if (this.kUO != null) {
            this.kUI.setVisibility(0);
            this.kUR.setVisibility(0);
            this.koc.setVisibility(8);
            this.kUM.setImageResource(R.drawable.icon_video_midpause);
            this.kUO.setVisibility(0);
            this.itU.setVisibility(8);
            this.kUH.aQY();
            this.amC.setVisibility(0);
        }
    }

    public void Fy(String str) {
        this.gxn.setVideoPath(str);
        this.gxn.start();
        this.koc.setVisibility(0);
        this.amC.setVisibility(0);
        this.kUR.setVisibility(8);
        this.kUM.setImageResource(R.drawable.icon_video_midplay);
        this.itU.setVisibility(8);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.kVq, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void aQK() {
        this.gxn.start();
        this.kUM.setImageResource(R.drawable.icon_video_midplay);
        this.amC.setVisibility(8);
        this.kUI.setVisibility(8);
        this.koc.setVisibility(8);
        this.kUH.showProgress();
        this.kUR.setVisibility(8);
    }

    public void aQJ() {
        this.gxn.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abT);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        this.gxn.stopPlayback();
        this.abN = false;
        this.mStartPosition = 0;
        cQE();
    }

    public void cQE() {
        if (this.kUO != null) {
            this.kUI.setVisibility(0);
            this.kUR.setVisibility(0);
            this.koc.setVisibility(8);
            this.kUM.setImageResource(R.drawable.icon_video_midpause);
            this.kUO.setVisibility(4);
            this.itU.setVisibility(8);
            this.kUH.aQY();
            this.amC.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.kVr) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
            aVar.Ad(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.kVr = true;
                    c.this.Fy(c.this.mVideoUrl);
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.eSJ).bqe();
            return;
        }
        Fy(this.mVideoUrl);
    }

    public void setThumbnail(String str) {
        this.amC.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.abT);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVq);
        this.kVi.stop();
        kVm.unregister(this.eSJ.getPageActivity());
    }

    public void hc(long j) {
        at.numberUniformFormat(j);
    }

    public boolean dau() {
        return this.abN;
    }

    public void clearAnimation() {
        dax();
    }

    public void dav() {
        if (this.kUO != null && !this.kUW && this.kUO.getVisibility() == 0) {
            dax();
            this.kUO.setVisibility(0);
            this.jhQ.setAnimationListener(this.kVs);
            this.kUO.startAnimation(this.jhQ);
            this.kUW = true;
        }
    }

    public void daw() {
        if (this.kUO != null && !this.kUV) {
            if (this.kUW || this.kUO.getVisibility() != 0) {
                dax();
                this.kUO.setVisibility(0);
                this.cdO.setAnimationListener(this.kVt);
                this.kUO.startAnimation(this.cdO);
                this.kUV = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dax() {
        if (this.kUO != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
            this.cdO.setAnimationListener(null);
            this.jhQ.setAnimationListener(null);
            this.kUO.clearAnimation();
            this.kUW = false;
            this.kUV = false;
        }
    }

    public void day() {
        daw();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kVu);
        if (this.kUy) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.kVu, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public void a(b bVar) {
        this.kUX = bVar;
    }

    public void DJ(int i) {
        if (this.gxn.getDuration() - i <= 3000 && this.abY) {
            dax();
            if (this.kUO != null) {
                this.kUO.setVisibility(0);
            }
        }
    }

    public void DK(int i) {
        this.mStartPosition = i;
    }

    public boolean isShow() {
        return this.bRa.getVisibility() == 0;
    }

    public void fJ(String str, String str2) {
        this.statExtra = str;
        this.kVh = str2;
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
