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
    private static int gID;
    private static CallStateReceiver gIE;
    private Animation aeX;
    private String bNk;
    private WeakReference<Context> bty;
    private o cVs;
    private QuickVideoView dbg;
    private View ekE;
    private View ekJ;
    private View fWX;
    private Animation fez;
    SwipeBackLayout.c gHU;
    m gHV;
    protected View gHW;
    private View gHX;
    private VideoListMediaControllerView gHY;
    private View gHZ;
    private String gIA;
    private int gIB;
    private int gIC;
    private FrameLayout gIa;
    protected FrameLayout.LayoutParams gIb;
    private ImageView gIc;
    private ImageView gId;
    private ImageView gIe;
    private View gIf;
    private View gIh;
    private ImageView gIi;
    private TbImageView gIj;
    private g.f gIk;
    private k gIl;
    private ImageView gIm;
    private TextView gIn;
    private b gIq;
    private View gIr;
    private View gIs;
    private TextView gIt;
    private SeekBar gIu;
    private ImageView gIv;
    private ImageView gIw;
    private int gIx;
    private AudioManager mAudioManager;
    private TbPageContext<?> mContext;
    private GestureDetector mGestureDetector;
    private int mProgress;
    private int mScreenHeight;
    private int mScreenWidth;
    private WindowManager mWindowManager;
    private String statExtra;
    private int gIg = 0;
    protected boolean US = false;
    private boolean UF = false;
    private boolean gIo = false;
    private boolean gIp = false;
    private int mStartPosition = 0;
    private int mStatus = 0;
    private int gIy = 0;
    private int gIz = 0;
    private boolean gIF = false;
    private boolean gIG = false;
    private boolean gHO = true;
    private g.f cJJ = new g.f() { // from class: com.baidu.tieba.lego.card.view.c.7
        @Override // com.baidu.tieba.play.g.f
        public void onPrepared(com.baidu.tieba.play.g gVar) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            com.baidu.adp.lib.g.e.jH().post(c.this.UL);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gII);
            if (gVar != null && c.this.gHY != null) {
                if (c.this.gIG || c.this.US) {
                    gVar.setVolume(1.0f, 1.0f);
                    ad.a(c.this.bty, true);
                } else {
                    gVar.setVolume(0.0f, 0.0f);
                    ad.a(c.this.bty, false);
                }
                c.this.gHY.ax(c.this.mStartPosition, gVar.getDuration());
                if (c.this.mStartPosition != 0) {
                    gVar.seekTo(c.this.mStartPosition);
                }
                if (c.this.gIk != null) {
                    c.this.gIk.onPrepared(c.this.dbg.getPlayer());
                }
            }
        }
    };
    private Runnable UL = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.8
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dbg.getCurrentPosition() > 100) {
                c.this.UF = true;
                c.this.gHZ.setVisibility(8);
                c.this.ekJ.setVisibility(8);
                c.this.fWX.setVisibility(8);
                c.this.gIj.setVisibility(8);
                c.this.bAO();
                if (c.this.gIf != null) {
                    c.this.gIf.setVisibility(0);
                }
                c.this.gHY.showProgress();
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
                c.this.bAx();
                c.this.bAJ();
                c.this.bAP();
            } else {
                c.this.bnQ();
            }
            if (c.this.gIl != null) {
                c.this.gIl.xV(c.this.bNk);
            }
        }
    };
    private g.b gIH = new g.b() { // from class: com.baidu.tieba.lego.card.view.c.10
        @Override // com.baidu.tieba.play.g.b
        public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
            c.this.ekJ.setVisibility(0);
            c.this.fWX.setVisibility(8);
            return true;
        }
    };
    private Runnable gII = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.11
        @Override // java.lang.Runnable
        public void run() {
            c.this.ekJ.setVisibility(0);
            c.this.fWX.setVisibility(8);
        }
    };
    private QuickVideoView.b cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.lego.card.view.c.12
        @Override // com.baidu.tieba.play.QuickVideoView.b
        public void onSurfaceDestroyed() {
            c.this.UF = false;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.UL);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(c.this.gII);
        }
    };
    protected View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.c.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.ekJ.getId()) {
                if (view.getId() != c.this.gIi.getId() && view.getId() != c.this.gId.getId()) {
                    if (view.getId() != c.this.gIe.getId()) {
                        if (view.getId() == c.this.gIm.getId()) {
                            TiebaStatic.log(new am("c11713"));
                            c.this.bAB();
                            return;
                        } else if (view.getId() == c.this.gHW.getId()) {
                            if (c.this.UF || c.this.US) {
                                c.this.bAP();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.gIc.getId() && !c.this.US) {
                            if (c.this.gIG) {
                                c.this.dbg.setVolume(0.0f, 0.0f);
                                c.this.gIc.setImageResource(d.f.card_icon_sound_close);
                                ad.a(c.this.bty, false);
                                c.this.gIG = false;
                                return;
                            }
                            c.this.dbg.setVolume(1.0f, 1.0f);
                            c.this.gIc.setImageResource(d.f.card_icon_sound_open);
                            ad.a(c.this.bty, true);
                            c.this.gIG = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.this.US) {
                        if (c.this.gHU != null) {
                            c.this.gHU.po();
                        }
                        TiebaStatic.log(new am("c11714"));
                    } else {
                        if (c.this.gHU != null) {
                            c.this.gHU.pp();
                        }
                        TiebaStatic.log(new am("c11710"));
                        r.bWG().bWC().cc(c.this.statExtra, c.this.gIA);
                    }
                    c.this.bAB();
                    return;
                } else if (!com.baidu.adp.lib.util.j.kY()) {
                    com.baidu.adp.lib.util.l.S(c.this.mContext.getPageActivity(), c.this.mContext.getString(d.j.neterror));
                    return;
                } else if (!c.this.dbg.isPlaying()) {
                    if (c.this.UF) {
                        c.this.bAK();
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
    private boolean gIJ = false;
    private Animation.AnimationListener gIK = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.3
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.gIf != null) {
                c.this.gIf.setVisibility(8);
                c.this.gIp = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Animation.AnimationListener gIL = new Animation.AnimationListener() { // from class: com.baidu.tieba.lego.card.view.c.4
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.gIo = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private Runnable gIM = new Runnable() { // from class: com.baidu.tieba.lego.card.view.c.5
        @Override // java.lang.Runnable
        public void run() {
            c.this.bAM();
        }
    };
    private CustomMessageListener gIN = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.lego.card.view.c.6
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
        this.gIB = 0;
        this.bty = null;
        this.mContext = tbPageContext;
        this.bty = new WeakReference<>(TbadkCoreApplication.getInst());
        this.gHW = r(tbPageContext);
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.gHW);
        }
        this.dbg = (QuickVideoView) this.gHW.findViewById(d.g.videoView);
        this.fWX = this.gHW.findViewById(d.g.video_list_layout_loading);
        this.gHY = (VideoListMediaControllerView) this.gHW.findViewById(d.g.media_controller);
        this.gHY.setPlayer(this.dbg);
        this.gHZ = this.gHW.findViewById(d.g.black_mask);
        this.ekJ = this.gHW.findViewById(d.g.layout_error);
        this.ekJ.setOnClickListener(this.mOnClickListener);
        this.gIa = (FrameLayout) this.gHW.findViewById(d.g.danmu_container);
        this.gId = (ImageView) this.gHW.findViewById(d.g.img_play_icon);
        this.gId.setOnClickListener(this.mOnClickListener);
        this.gIc = (ImageView) this.gHW.findViewById(d.g.img_sound_control);
        this.gIc.setOnClickListener(this.mOnClickListener);
        this.gIe = (ImageView) this.gHW.findViewById(d.g.card_img_full_screen);
        this.gIe.setOnClickListener(this.mOnClickListener);
        this.gIf = this.gHW.findViewById(d.g.card_layout_media_controller);
        this.gHX = this.gHW.findViewById(d.g.rl_control);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnErrorListener(this.gIH);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.gIi = (ImageView) this.gHW.findViewById(d.g.img_play);
        this.gIi.setOnClickListener(this.mOnClickListener);
        this.gIj = (TbImageView) this.gHW.findViewById(d.g.video_thumbnail);
        this.gIj.setDefaultErrorResource(0);
        this.gIj.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity());
        this.mScreenHeight = getScreenHeight(this.mContext.getPageActivity());
        this.gIm = (ImageView) this.gHW.findViewById(d.g.img_exit);
        this.gIm.setOnClickListener(this.mOnClickListener);
        this.gIn = (TextView) this.gHW.findViewById(d.g.video_title);
        this.ekE = this.gHW.findViewById(d.g.layout_title);
        this.ekE.setVisibility(8);
        this.fez = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_2000_accelerate);
        this.aeX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_0_to_1_duration_200_accelerate);
        this.mWindowManager = (WindowManager) this.mContext.getPageActivity().getSystemService("window");
        this.mGestureDetector = new GestureDetector(this.mContext.getPageActivity(), new a());
        this.mAudioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.gIx = this.mAudioManager.getStreamMaxVolume(3);
        this.gIC = this.mAudioManager.getStreamVolume(3);
        gID = 100 / this.gIx;
        this.gHW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.lego.card.view.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent = c.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (c.this.US && c.this.UF) {
                        if (c.this.mStatus == 1 && c.this.gIz != 0) {
                            c.this.b(c.this.gIz == 1 ? 1000.0f : -1000.0f, false);
                            c.this.gIz = 0;
                            c.this.gIy = 0;
                        }
                        if (!c.this.dbg.isPlaying() && 8 == c.this.gIi.getVisibility()) {
                            c.this.gIi.setVisibility(0);
                        }
                    }
                    c.this.bAx();
                }
                return onTouchEvent;
            }
        });
        this.cVs = new o(this.mContext.getPageActivity());
        this.cVs.start();
        this.gIB = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds16);
        if (gIE == null) {
            gIE = new CallStateReceiver();
        }
        gIE.register(this.mContext.getPageActivity());
        this.mContext.registerListener(this.gIN);
    }

    public void a(m mVar) {
        this.gHV = mVar;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.gHU = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAx() {
        if (this.mStatus != 0) {
            this.mStatus = 0;
            if (this.gIr != null && this.gIr.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.gIr);
                } catch (IllegalArgumentException e) {
                }
            }
            if (this.gIs != null && this.gIs.getParent() != null) {
                try {
                    this.mWindowManager.removeView(this.gIs);
                } catch (IllegalArgumentException e2) {
                }
            }
        }
    }

    private void bAy() {
        if (this.mStatus == 1) {
            if (this.gIr == null) {
                this.gIr = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.float_video_window_jindu, (ViewGroup) null);
                this.gIt = (TextView) this.gIr.findViewById(d.g.show_time);
                this.gIw = (ImageView) this.gIr.findViewById(d.g.arrow_icon);
            }
            if (this.gIr.getParent() == null) {
                this.mWindowManager.addView(this.gIr, bAz());
            }
        } else if (this.mStatus == 2) {
            if (this.gIs == null) {
                this.gIs = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.float_video_window_voice, (ViewGroup) null);
                this.gIv = (ImageView) this.gIs.findViewById(d.g.arrow_voice_icon);
                this.gIu = (SeekBar) this.gIs.findViewById(d.g.show_voice_seekbar);
            }
            if (this.gIs.getParent() == null) {
                this.mWindowManager.addView(this.gIs, bAz());
            }
        }
    }

    private WindowManager.LayoutParams bAz() {
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
                if (!c.this.dbg.isPlaying() && c.this.gIi.getVisibility() == 0 && c.this.mStatus == 1) {
                    c.this.gIi.setVisibility(8);
                }
                if (c.this.mStatus == 0) {
                    c.this.bAA();
                    if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                        c.this.mStatus = 1;
                        c.this.gIy = c.this.dbg.getCurrentPosition();
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
    public void bAA() {
        if (Build.VERSION.SDK_INT < 16) {
            this.gHW.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.gHW.setSystemUiVisibility(4);
        } else {
            this.gHW.setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        if (!this.dbg.isPlaying()) {
            this.mStatus = 0;
            return;
        }
        bAy();
        if (f > 0.0f && this.mProgress < 100) {
            this.mProgress++;
        }
        if (f < 0.0f && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % gID == 0) {
            if (f > 0.0f && this.gIC < this.gIx) {
                this.gIC++;
            }
            if (f < 0.0f && this.gIC > 0) {
                this.gIC--;
            }
        }
        if (this.gIC > 0) {
            this.gIv.setImageResource(d.f.icon_shengyin_open);
        } else {
            this.gIv.setImageResource(d.f.icon_shengyin_close);
        }
        this.mAudioManager.setStreamVolume(3, this.gIC, 0);
        this.gIu.setProgress(this.mProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, boolean z) {
        if (z) {
            if (f > 0.0f) {
                this.gIy += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                this.gIz = 1;
            } else {
                this.gIy += 1000;
                this.gIz = 2;
            }
            if (this.gIy < 0) {
                this.gIy = 0;
            } else if (this.gIy > this.dbg.getDuration()) {
                this.gIy = this.dbg.getDuration();
            }
        }
        bAy();
        String xr = this.gHY.xr(this.gIy);
        if (f > 0.0f) {
            this.gIw.setImageResource(d.f.icon_kuaitui);
        } else {
            this.gIw.setImageResource(d.f.icon_kuaijin);
        }
        if (!StringUtils.isNull(xr)) {
            this.gIt.setText(new StringBuilder().append(xr).append("/").append(this.gHY.xr(this.dbg.getDuration())));
        }
        this.gHY.setCurrentDuration(this.gIy, z ? false : true);
    }

    protected View r(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_float_video_container, (ViewGroup) null);
    }

    public void setVideoUrl(String str) {
        this.bNk = str;
    }

    public void bAB() {
        this.gIF = true;
        if (this.cVs != null) {
            this.cVs.bAB();
        }
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public VideoListMediaControllerView bAC() {
        return this.gHY;
    }

    public View bAD() {
        return this.gIf;
    }

    public void lb(boolean z) {
        if (z) {
            this.gHY.setVisibility(0);
            this.gId.setVisibility(0);
            return;
        }
        this.gHY.setVisibility(8);
        this.gId.setVisibility(8);
    }

    public void ma(boolean z) {
        this.gHO = z;
    }

    public void hide() {
        this.gHW.setVisibility(8);
    }

    public void show() {
        this.gHW.setVisibility(0);
    }

    public void bAE() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHX.getLayoutParams();
        if (com.baidu.tieba.lego.card.d.d.al(this.mContext.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.mContext.getResources().getDimension(d.e.ds30) + 0.5f);
        }
        this.gHX.setLayoutParams(layoutParams);
        this.gIe.setClickable(false);
        this.gIe.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gIc.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            this.gIc.setPadding((int) (this.mContext.getResources().getDimension(d.e.ds22) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds38) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f));
            layoutParams2.addRule(11);
            this.gIc.setLayoutParams(layoutParams2);
        }
    }

    public void bAF() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHX.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.gHX.setLayoutParams(layoutParams);
        this.gIe.setClickable(true);
        this.gIe.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gIc.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, d.g.card_img_full_screen);
            this.gIc.setPadding((int) (this.mContext.getResources().getDimension(d.e.ds22) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f), (int) (this.mContext.getResources().getDimension(d.e.ds16) + 0.5f));
            this.gIc.setLayoutParams(layoutParams2);
        }
    }

    public void bAG() {
        if (this.gIh != null) {
            this.gIb = (FrameLayout.LayoutParams) this.gHW.getLayoutParams();
            this.gIb.width = this.gIh.getWidth();
            this.gIb.height = this.gIh.getHeight();
            int[] iArr = new int[2];
            this.gIh.getLocationOnScreen(iArr);
            this.gIb.topMargin = iArr[1] - this.gIg;
            this.gHW.setLayoutParams(this.gIb);
        }
    }

    public void uU(int i) {
        if (this.gHV != null && i != this.gHV.getPage()) {
            this.gHV.stopPlay();
        }
    }

    public void bZ(View view) {
        this.gIh = view;
    }

    public View bAH() {
        return this.gIh;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        if (configuration.orientation == 2) {
            this.US = true;
            this.gIc.setVisibility(8);
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.bty, true);
            this.gHW.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenHeight, this.mScreenWidth));
            a(baseFragmentActivity, true);
            this.ekE.setVisibility(0);
            mc(true);
            this.gIa.setVisibility(8);
            if (this.gIq != null) {
                this.gIq.qj();
            }
            bAP();
            this.gIe.setImageResource(d.f.icon_suoxiao);
            uV(this.gIB);
            bAA();
            return;
        }
        this.US = false;
        this.gIc.setVisibility(0);
        if (this.gIG) {
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.bty, true);
        } else {
            this.dbg.setVolume(0.0f, 0.0f);
            ad.a(this.bty, false);
        }
        if (this.gIb != null) {
            this.gHW.setLayoutParams(this.gIb);
        }
        a(baseFragmentActivity, false);
        this.ekE.setVisibility(8);
        mc(false);
        this.gIa.setVisibility(0);
        if (this.gIq != null) {
            this.gIq.qk();
        }
        if (!this.UF && this.gIf != null) {
            this.gIf.clearAnimation();
            this.gIf.setVisibility(4);
        }
        bAx();
        this.gIe.setImageResource(d.f.icon_fangda);
        uV(0);
        this.gHW.setSystemUiVisibility(0);
    }

    private void uV(int i) {
        if (this.gHY != null && (this.gHY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHY.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.gHY.setLayoutParams(layoutParams);
        }
    }

    protected void mc(boolean z) {
        if (z) {
            this.gHW.setOnClickListener(this.mOnClickListener);
        } else {
            this.gHW.setClickable(false);
        }
    }

    public void uW(int i) {
        this.gIg = i;
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
            if (this.fWX.getVisibility() == 0) {
            }
        }
    }

    public boolean bAI() {
        return !this.US;
    }

    public void a(g.f fVar) {
        this.gIk = fVar;
    }

    public void a(k kVar) {
        this.gIl = kVar;
    }

    public void setPauseState() {
        this.gId.setImageResource(d.f.icon_video_midpause);
        this.fWX.setVisibility(8);
        this.gIi.setVisibility(0);
    }

    public void bAJ() {
        if (this.gIf != null) {
            this.gHZ.setVisibility(0);
            this.gIi.setVisibility(0);
            this.fWX.setVisibility(8);
            this.gId.setImageResource(d.f.icon_video_midpause);
            this.gIf.setVisibility(0);
            this.ekJ.setVisibility(8);
            this.gHY.awJ();
            this.gIj.setVisibility(0);
        }
    }

    public void startPlay(String str) {
        this.dbg.setVideoPath(str);
        this.dbg.start();
        this.fWX.setVisibility(0);
        this.gIj.setVisibility(0);
        this.gIi.setVisibility(8);
        this.gId.setImageResource(d.f.icon_video_midplay);
        this.ekJ.setVisibility(8);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.gII, 60000L);
    }

    public void bAK() {
        this.dbg.start();
        this.gId.setImageResource(d.f.icon_video_midplay);
        this.gIj.setVisibility(8);
        this.gHZ.setVisibility(8);
        this.fWX.setVisibility(8);
        this.gHY.showProgress();
        this.gIi.setVisibility(8);
    }

    public void pausePlay() {
        this.dbg.pause();
        setPauseState();
    }

    public void stopPlay() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        this.dbg.stopPlayback();
        this.UF = false;
        this.mStartPosition = 0;
        bnQ();
    }

    public void bnQ() {
        if (this.gIf != null) {
            this.gHZ.setVisibility(0);
            this.gIi.setVisibility(0);
            this.fWX.setVisibility(8);
            this.gId.setImageResource(d.f.icon_video_midpause);
            this.gIf.setVisibility(4);
            this.ekJ.setVisibility(8);
            this.gHY.awJ();
            this.gIj.setVisibility(0);
        }
    }

    public void performPlay() {
        if (com.baidu.adp.lib.util.j.la() && !this.gIJ) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.ly(TbadkCoreApplication.getInst().getString(d.j.play_video_mobile_tip));
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.lego.card.view.c.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    c.this.gIJ = true;
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
        this.gIj.startLoad(str, 17, false);
    }

    public void destroy() {
        stopPlay();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.UL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gII);
        this.cVs.stop();
        gIE.unregister(this.mContext.getPageActivity());
    }

    public void dq(long j) {
        ap.as(j);
    }

    public boolean bAL() {
        return this.UF;
    }

    public void clearAnimation() {
        bAO();
    }

    public void bAM() {
        if (this.gIf != null && !this.gIp && this.gIf.getVisibility() == 0) {
            bAO();
            this.gIf.setVisibility(0);
            this.fez.setAnimationListener(this.gIK);
            this.gIf.startAnimation(this.fez);
            this.gIp = true;
        }
    }

    public void bAN() {
        if (this.gIf != null && !this.gIo) {
            if (this.gIp || this.gIf.getVisibility() != 0) {
                bAO();
                this.gIf.setVisibility(0);
                this.aeX.setAnimationListener(this.gIL);
                this.gIf.startAnimation(this.aeX);
                this.gIo = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAO() {
        if (this.gIf != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
            this.aeX.setAnimationListener(null);
            this.fez.setAnimationListener(null);
            this.gIf.clearAnimation();
            this.gIp = false;
            this.gIo = false;
        }
    }

    public void bAP() {
        bAN();
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gIM);
        if (this.gHO) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.gIM, 3000L);
        }
    }

    public void a(b bVar) {
        this.gIq = bVar;
    }

    public void uX(int i) {
        if (this.dbg.getDuration() - i <= 3000 && this.US) {
            bAO();
            if (this.gIf != null) {
                this.gIf.setVisibility(0);
            }
        }
    }

    public void setStartPosition(int i) {
        this.mStartPosition = i;
    }

    public boolean isShow() {
        return this.gHW.getVisibility() == 0;
    }

    public void dm(String str, String str2) {
        this.statExtra = str;
        this.gIA = str2;
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
