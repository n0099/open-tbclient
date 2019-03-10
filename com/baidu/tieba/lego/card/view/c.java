package com.baidu.tieba.lego.card.view;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.o;
import com.baidu.tieba.recapp.r;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class c {
    private static int gIE;
    private static CallStateReceiver gIF;
    private Animation aeX;
    private String bNk;
    private WeakReference<Context> bty;
    private o cVs;
    private QuickVideoView dbg;
    private View ekE;
    private View ekJ;
    private View fWY;
    private Animation fez;
    SwipeBackLayout.c gHV;
    m gHW;
    protected View gHX;
    private View gHY;
    private VideoListMediaControllerView gHZ;
    private String gIB;
    private int gIC;
    private int gID;
    private View gIa;
    private FrameLayout gIb;
    protected FrameLayout.LayoutParams gIc;
    private ImageView gId;
    private ImageView gIe;
    private ImageView gIf;
    private View gIg;
    private View gIi;
    private ImageView gIj;
    private TbImageView gIk;
    private g.f gIl;
    private k gIm;
    private ImageView gIn;
    private TextView gIo;
    private b gIr;
    private View gIs;
    private View gIt;
    private TextView gIu;
    private SeekBar gIv;
    private ImageView gIw;
    private ImageView gIx;
    private int gIy;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private WindowManager mWindowManager;
    private String statExtra;
    private int gIh = 0;
    protected boolean US = false;
    private boolean UF = false;
    private boolean gIp = false;
    private boolean gIq = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIz = 0;
    private int gIA = 0;
    private boolean gIG = false;
    private boolean gIH = false;
    private boolean gHP = true;
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            com.baidu.adp.lib.g.e.jH().post(c.this.UL);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIJ);
            if (gVar != null && c.this.gHZ != null) {
                if (c.this.gIH || c.this.US) {
                    gVar.setVolume(1.0f, 1.0f);
                    ad.a(c.this.bty, true);
                } else {
                    gVar.setVolume(0.0f, 0.0f);
                    ad.a(c.this.bty, false);
                }
                c.this.gHZ.ax(c.this.mStartPosition, gVar.getDuration());
                if (c.this.mStartPosition != 0) {
                    gVar.seekTo(c.this.mStartPosition);
                }
                if (c.this.gIl != null) {
                    c.this.gIl.onPrepared(c.this.dbg.getPlayer());
                }
            }
        }
    };
    private Runnable UL = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg.getCurrentPosition() > 100) {
                c.this.UF = true;
                c.this.gIa.setVisibility(8);
                c.this.ekJ.setVisibility(8);
                c.this.fWY.setVisibility(8);
                c.this.gIk.setVisibility(8);
                c.this.bAP();
                if (c.this.gIg != null) {
                    c.this.gIg.setVisibility(0);
                }
                c.this.gHZ.showProgress();
                return;
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(c.this.UL, 20L);
        }
    };
    private g.a cJI = new g.a() { // from class: com.baidu.tieba.lego.card.view.c.9
        @Override // com.baidu.tieba.play.g.a
        public void onCompletion(com.baidu.tieba.play.g gVar) {
            c.this.UF = false;
            c.this.mStartPosition = 0;
            if (c.this.US) {
                c.this.bAy();
                c.this.bAK();
                c.this.bAQ();
            } else {
                c.this.bnR();
            }
            if (c.this.gIm != null) {
                c.this.gIm.xW(c.this.bNk);
            }
        }
    };
    private g.b gII = new g.b() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
            c.this.ekJ.setVisibility(0);
            c.this.fWY.setVisibility(8);
            return true;
        }
    };
    private Runnable gIJ = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.ekJ.setVisibility(0);
            c.this.fWY.setVisibility(8);
        }
    };
    private QuickVideoView.b cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UF = false;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gIJ);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.ekJ.getId()) {
                if (view.getId() != c.this.gIj.getId() && view.getId() != c.this.gIe.getId()) {
                    if (view.getId() != c.this.gIf.getId()) {
                        if (view.getId() == c.this.gIn.getId()) {
                            TiebaStatic.log(new am("c11713"));
                            c.this.bAC();
                            return;
                        } else if (view.getId() == c.this.gHX.getId()) {
                            if (c.this.UF || c.this.US) {
                                c.this.bAQ();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.gId.getId() && !c.this.US) {
                            if (c.this.gIH) {
                                c.this.dbg.setVolume(0.0f, 0.0f);
                                c.this.gId.setImageResource(d.f.card_icon_sound_close);
                                ad.a(c.this.bty, false);
                                c.this.gIH = false;
                                return;
                            }
                            c.this.dbg.setVolume(1.0f, 1.0f);
                            c.this.gId.setImageResource(d.f.card_icon_sound_open);
                            ad.a(c.this.bty, true);
                            c.this.gIH = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.US) {
                        if (c.this.gHV != null) {
                            c.this.gHV.po();
                        }
                        TiebaStatic.log(new am("c11714"));
                    } else {
                        if (c.this.gHV != null) {
                            c.this.gHV.pp();
                        }
                        TiebaStatic.log(new am("c11710"));
                        r.bWH().bWD().cc(c.this.statExtra, c.this.gIB);
                    }
                    c.this.bAC();
                    return;
                } else if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.S(c.this.mContext.getPageActivity(), c.this.mContext.getString(d.j.neterror));
                    return;
                } else if (!c.this.dbg.isPlaying()) {
                    if (c.this.UF) {
                        c.this.bAL();
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
    private boolean gIK = false;
    private Animation.AnimationListener gIL = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.gIg != null) {
                c.this.gIg.setVisibility(8);
                c.this.gIq = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener gIM = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.gIp = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable gIN = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.bAN();
        }
    };
    private CustomMessageListener gIO = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.lego.card.view.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.pausePlay();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface b {
        void qj();

        void qk();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.gIC = 0;
        this.bty = null;
        this.mContext = tbPageContext;
        this.bty = new WeakReference<>(TbadkCoreApplication.getInst());
        this.gHX = r(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.gHX);
        }
        this.dbg = (QuickVideoView) this.gHX.findViewById(d.g.videoView);
        this.fWY = this.gHX.findViewById(d.g.video_list_layout_loading);
        this.gHZ = (VideoListMediaControllerView) this.gHX.findViewById(d.g.media_controller);
        this.gHZ.setPlayer(this.dbg);
        this.gIa = this.gHX.findViewById(d.g.black_mask);
        this.ekJ = this.gHX.findViewById(d.g.layout_error);
        this.ekJ.setOnClickListener(this.mOnClickListener);
        this.gIb = (FrameLayout) this.gHX.findViewById(d.g.danmu_container);
        this.gIe = (ImageView) this.gHX.findViewById(d.g.img_play_icon);
        this.gIe.setOnClickListener(this.mOnClickListener);
        this.gId = (ImageView) this.gHX.findViewById(d.g.img_sound_control);
        this.gId.setOnClickListener(this.mOnClickListener);
        this.gIf = (ImageView) this.gHX.findViewById(d.g.card_img_full_screen);
        this.gIf.setOnClickListener(this.mOnClickListener);
        this.gIg = this.gHX.findViewById(d.g.card_layout_media_controller);
        this.gHY = this.gHX.findViewById(d.g.rl_control);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gII);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.gIj = (ImageView) this.gHX.findViewById(d.g.img_play);
        this.gIj.setOnClickListener(this.mOnClickListener);
        this.gIk = (TbImageView) this.gHX.findViewById(d.g.video_thumbnail);
        this.gIk.setDefaultErrorResource(0);
        this.gIk.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
        this.gIn = (ImageView) this.gHX.findViewById(d.g.img_exit);
        this.gIn.setOnClickListener(this.mOnClickListener);
        this.gIo = (TextView) this.gHX.findViewById(d.g.video_title);
        this.ekE = this.gHX.findViewById(d.g.layout_title);
        this.ekE.setVisibility(8);
        this.fez = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aeX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.mContext.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.gIy = this.mAudioManager.getStreamMaxVolume(3);
        this.gID = this.mAudioManager.getStreamVolume(3);
        gIE = 100 / this.gIy;
        this.gHX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.US && c.this.UF) {
                        if (c.this.mStatus == 1 && c.this.gIA != 0) {
                            c.this.b(c.this.gIA == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIA = 0;
                            c.this.gIz = 0;
                        }
                        if (!c.this.dbg.isPlaying() && 8 == c.this.gIj.getVisibility()) {
                            c.this.gIj.setVisibility(0);
                        }
                    }
                    c.this.bAy();
                }
                return onTouchEvent;
            }
        });
        this.cVs = new o(this.mContext.getPageActivity());
        this.cVs.start();
        this.gIC = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds16);
        if (gIF == null) {
            gIF = new CallStateReceiver();
        }
        gIF.register(this.mContext.getPageActivity());
        this.mContext.registerListener(this.gIO);
    }

    public void a(m mVar) {
        this.gHW = mVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.gHV = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAy() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.gIs != null && this.gIs.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.gIs);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.gIt != null && this.gIt.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.gIt);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void bAz() {
        if (this.mStatus == 1) {
            if (this.gIs == null) {
                this.gIs = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) null);
                this.gIu = (TextView) this.gIs.findViewById(d.g.show_time);
                this.gIx = (ImageView) this.gIs.findViewById(d.g.arrow_icon);
            }
            if (this.gIs.getParent() == null) {
                this.mWindowManager.addView(this.gIs, bAA());
            }
        } else if (this.mStatus == 2) {
            if (this.gIt == null) {
                this.gIt = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) null);
                this.gIw = (ImageView) this.gIt.findViewById(d.g.arrow_voice_icon);
                this.gIv = (SeekBar) this.gIt.findViewById(d.g.show_voice_seekbar);
            }
            if (this.gIt.getParent() == null) {
                this.mWindowManager.addView(this.gIt, bAA());
            }
        }
    }

    private WindowManager.LayoutParams bAA() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* loaded from: classes2.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (c.this.US && c.this.UF) {
                if (!c.this.dbg.isPlaying() && c.this.gIj.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.gIj.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.bAB();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIz = c.this.dbg.getCurrentPosition();
                        c.this.b(f, true);
                    } else {
                        c.this.mStatus = 2;
                        c.this.aH(f2);
                    }
                } else if (c.this.mStatus == 1) {
                    c.this.b(f, true);
                } else if (c.this.mStatus == 2) {
                    c.this.aH(f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gHX.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gHX.setSystemUiVisibility(4);
        } else {
            this.gHX.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        if (!this.dbg.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        bAz();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gIE == 0) {
            if (f > 0.0f && this.gID < this.gIy) {
                this.gID++;
            }
            if (f < 0.0f && this.gID > 0) {
                this.gID--;
            }
        }
        if (this.gID > 0) {
            this.gIw.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.gIw.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gID, 0);
        this.gIv.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.gIz += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gIA = 1;
            } else {
                this.gIz += 1000;
                this.gIA = 2;
            }
            if (this.gIz < 0) {
                this.gIz = 0;
            } else if (this.gIz > this.dbg.getDuration()) {
                this.gIz = this.dbg.getDuration();
            }
        }
        bAz();
        String xr = this.gHZ.xr(this.gIz);
        if (f > 0.0f) {
            this.gIx.setImageResource(d.f.icon_kuaitui);
        } else {
            this.gIx.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(xr)) {
            this.gIu.setText(new StringBuilder().append(xr).append("/").append(this.gHZ.xr(this.dbg.getDuration())));
        }
        this.gHZ.setCurrentDuration(this.gIz, z ? false : true);
    }

    protected View r(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.bNk = str;
    }

    public void bAC() {
        this.gIG = true;
        if (this.cVs != null) {
            this.cVs.bAC();
        }
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public VideoListMediaControllerView bAD() {
        return this.gHZ;
    }

    public View bAE() {
        return this.gIg;
    }

    public void lb(boolean z) {
        if (z) {
            this.gHZ.setVisibility(0);
            this.gIe.setVisibility(0);
            return;
        }
        this.gHZ.setVisibility(8);
        this.gIe.setVisibility(8);
    }

    public void ma(boolean z) {
        this.gHP = z;
    }

    public void hide() {
        this.gHX.setVisibility(8);
    }

    public void show() {
        this.gHX.setVisibility(0);
    }

    public void bAF() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
        if (com.baidu.tieba.lego.card.d.d.al(this.mContext.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
        }
        this.gHY.setLayoutParams(layoutParams);
        this.gIf.setClickable(false);
        this.gIf.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gId.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.gId.setPadding((int) (this.mContext.getResources().getDimension(d.e.ds22) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds38) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.gId.setLayoutParams(layoutParams2);
        }
    }

    public void bAG() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.gHY.setLayoutParams(layoutParams);
        this.gIf.setClickable(true);
        this.gIf.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gId.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, d.g.card_img_full_screen);
            this.gId.setPadding((int) (this.mContext.getResources().getDimension(d.e.ds22) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f));
            this.gId.setLayoutParams(layoutParams2);
        }
    }

    public void bAH() {
        if (this.gIi != null) {
            this.gIc = (FrameLayout.LayoutParams) this.gHX.getLayoutParams();
            this.gIc.width = this.gIi.getWidth();
            this.gIc.height = this.gIi.getHeight();
            int[] iArr = new int[2];
            this.gIi.getLocationOnScreen(iArr);
            this.gIc.topMargin = iArr[1] - this.gIh;
            this.gHX.setLayoutParams(this.gIc);
        }
    }

    public void uU(int i) {
        if (this.gHW != null && i != this.gHW.getPage()) {
            this.gHW.stopPlay();
        }
    }

    public void bZ(View view) {
        this.gIi = view;
    }

    public View bAI() {
        return this.gIi;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.US = true;
            this.gId.setVisibility(8);
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.bty, true);
            this.gHX.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.ekE.setVisibility(0);
            mc(true);
            this.gIb.setVisibility(8);
            if (this.gIr != null) {
                this.gIr.qj();
            }
            bAQ();
            this.gIf.setImageResource(d.f.icon_suoxiao);
            uV(this.gIC);
            bAB();
            return;
        }
        this.US = false;
        this.gId.setVisibility(0);
        if (this.gIH) {
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.bty, true);
        } else {
            this.dbg.setVolume(0.0f, 0.0f);
            ad.a(this.bty, false);
        }
        if (this.gIc != null) {
            this.gHX.setLayoutParams(this.gIc);
        }
        a(baseFragmentActivity, false);
        this.ekE.setVisibility(8);
        mc(false);
        this.gIb.setVisibility(0);
        if (this.gIr != null) {
            this.gIr.qk();
        }
        if (!this.UF && this.gIg != null) {
            this.gIg.clearAnimation();
            this.gIg.setVisibility(4);
        }
        bAy();
        this.gIf.setImageResource(d.f.icon_fangda);
        uV(0);
        this.gHX.setSystemUiVisibility(0);
    }

    private void uV(int i) {
        if (this.gHZ != null && (this.gHZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHZ.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.gHZ.setLayoutParams(layoutParams);
        }
    }

    protected void mc(boolean z) {
        if (z) {
            this.gHX.setOnClickListener(this.mOnClickListener);
        } else {
            this.gHX.setClickable(false);
        }
    }

    public void uW(int i) {
        this.gIh = i;
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
            if (this.fWY.getVisibility() == 0) {
            }
        }
    }

    public boolean bAJ() {
        return !this.US;
    }

    public void a(g.f fVar) {
        this.gIl = fVar;
    }

    public void a(k kVar) {
        this.gIm = kVar;
    }

    public void setPauseState() {
        this.gIe.setImageResource(d.f.icon_video_midpause);
        this.fWY.setVisibility(8);
        this.gIj.setVisibility(0);
    }

    public void bAK() {
        if (this.gIg != null) {
            this.gIa.setVisibility(0);
            this.gIj.setVisibility(0);
            this.fWY.setVisibility(8);
            this.gIe.setImageResource(d.f.icon_video_midpause);
            this.gIg.setVisibility(0);
            this.ekJ.setVisibility(8);
            this.gHZ.awK();
            this.gIk.setVisibility(0);
        }
    }

    public void startPlay(String str) {
        this.dbg.setVideoPath(str);
        this.dbg.start();
        this.fWY.setVisibility(0);
        this.gIk.setVisibility(0);
        this.gIj.setVisibility(8);
        this.gIe.setImageResource(d.f.icon_video_midplay);
        this.ekJ.setVisibility(8);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gIJ, 60000L);
    }

    public void bAL() {
        this.dbg.start();
        this.gIe.setImageResource(d.f.icon_video_midplay);
        this.gIk.setVisibility(8);
        this.gIa.setVisibility(8);
        this.fWY.setVisibility(8);
        this.gHZ.showProgress();
        this.gIj.setVisibility(8);
    }

    public void pausePlay() {
        this.dbg.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        this.dbg.stopPlayback();
        this.UF = false;
        this.mStartPosition = 0;
        bnR();
    }

    public void bnR() {
        if (this.gIg != null) {
            this.gIa.setVisibility(0);
            this.gIj.setVisibility(0);
            this.fWY.setVisibility(8);
            this.gIe.setImageResource(d.f.icon_video_midpause);
            this.gIg.setVisibility(4);
            this.ekJ.setVisibility(8);
            this.gHZ.awK();
            this.gIk.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.la() && !this.gIK) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.ly(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.gIK = true;
                    c.this.startPlay(c.this.bNk);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).aaZ();
            return;
        }
        startPlay(this.bNk);
    }

    public void setThumbnail(String str) {
        this.gIk.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIJ);
        this.cVs.stop();
        gIF.unregister(this.mContext.getPageActivity());
    }

    public void dq(long j) {
        ap.as(j);
    }

    public boolean bAM() {
        return this.UF;
    }

    public void clearAnimation() {
        bAP();
    }

    public void bAN() {
        if (this.gIg != null && !this.gIq && this.gIg.getVisibility() == 0) {
            bAP();
            this.gIg.setVisibility(0);
            this.fez.setAnimationListener(this.gIL);
            this.gIg.startAnimation(this.fez);
            this.gIq = true;
        }
    }

    public void bAO() {
        if (this.gIg != null && !this.gIp) {
            if (this.gIq || this.gIg.getVisibility() != 0) {
                bAP();
                this.gIg.setVisibility(0);
                this.aeX.setAnimationListener(this.gIM);
                this.gIg.startAnimation(this.aeX);
                this.gIp = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        if (this.gIg != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
            this.aeX.setAnimationListener(null);
            this.fez.setAnimationListener(null);
            this.gIg.clearAnimation();
            this.gIq = false;
            this.gIp = false;
        }
    }

    public void bAQ() {
        bAO();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIN);
        if (this.gHP) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIN, 3000L);
        }
    }

    public void a(b bVar) {
        this.gIr = bVar;
    }

    public void uX(int i) {
        if (this.dbg.getDuration() - i <= 3000 && this.US) {
            bAP();
            if (this.gIg != null) {
                this.gIg.setVisibility(0);
            }
        }
    }

    public void setStartPosition(int i) {
        this.mStartPosition = i;
    }

    public boolean isShow() {
        return this.gHX.getVisibility() == 0;
    }

    public void dm(String str, String str2) {
        this.statExtra = str;
        this.gIB = str2;
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
            return com.baidu.adp.lib.util.l.aQ(context);
        }
        return i;
    }
}
