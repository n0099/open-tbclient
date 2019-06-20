package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.j.k;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.SwitchImageView;
import com.coloros.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.play.operableVideoView.a {
    protected BdUniqueId Xj;
    protected String bVM;
    private String bVa;
    private o ddP;
    protected QuickVideoView dlM;
    protected k exn;
    private TextView eyW;
    private TextView eyX;
    private com.baidu.mcn.c fNL;
    protected TbImageView gZv;
    private View irV;
    private View irW;
    private TBLottieAnimationView irX;
    private ImageView irY;
    private View irZ;
    private a isA;
    private TextView isa;
    protected SwitchImageView isb;
    private SwitchImageView isc;
    private OperableVideoMediaControllerView isd;
    private OperableVideoNetworkStateTipView ise;
    private OperableVideoShareView isf;
    private ImageView isg;
    private VideoGestureView ish;
    private View isi;
    protected ViewGroup isj;
    protected boolean isk;
    protected boolean isl;
    protected long ism;
    protected long isn;
    private n iso;
    private float isp;
    private float isq;
    private int isr;
    private int ist;
    private boolean isu;
    private float isx;
    private int isy;
    private McnAdInfo isz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int irH = 3000;
    protected int irI = 103;
    protected int irJ = 0;
    protected int irK = 4;
    protected int irL = 904;
    protected int irM = 902;
    protected int irN = 2066;
    protected int irO = 1027;
    protected int irP = CommandMessage.COMMAND_BASE;
    protected int irQ = 0;
    protected int irR = this.irI;
    private int irS = 0;
    private int irT = -1;
    private Runnable irU = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.yv(c.this.irJ);
        }
    };
    private WeakReference<Context> bAG = null;
    private boolean hDn = false;
    private int[] iss = new int[2];
    private int isv = 0;
    private int isw = 0;
    protected View.OnClickListener bVj = null;
    private boolean Vs = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cWi = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.yv(c.this.irL);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dlM.isPlaying()) {
                    c.this.dlM.start();
                }
                c.this.ccg();
                TiebaStatic.log(new am("c13355").bT("tid", c.this.bVM).l("fid", c.this.mFid).P("obj_type", c.this.isl ? 1 : 2).P("obj_locate", c.this.hDn ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener isB = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dlM.isPlaying()) {
                c.this.dlM.pause();
                c.this.yv(c.this.irM);
            } else if (c.this.irR == c.this.irM || c.this.irR == (c.this.irM | 1)) {
                c.this.dlM.start();
                c.this.yv(c.this.irL);
                c.this.ccg();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.irR == c.this.irJ || c.this.irR == c.this.irK) {
                c.this.yv(c.this.irL);
                c.this.ccg();
            } else if (c.this.irR == c.this.irL) {
                c.this.yv(c.this.irJ);
            } else if (c.this.irR == c.this.irM) {
                c.this.yv(c.this.irL);
                c.this.ccg();
                c.this.dlM.start();
                TiebaStatic.log(new am("c13344").bT("tid", c.this.bVM).l("fid", c.this.mFid).P("obj_type", c.this.isl ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hDn ? 1 : 2).P("obj_locate", 1));
                c.this.ccj();
            } else {
                c.this.yv(c.this.irI);
                c.this.startPlay();
                c.this.ccj();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.irS = 0;
            if (c.this.hDn) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hDn) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.isl) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.irS) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dlM.isPlaying()) {
                                c.this.dlM.pause();
                                c.this.yv(c.this.irQ);
                            }
                            c.this.irS = 4;
                            c.this.irT = c.this.irR;
                            c.this.irR = c.this.irP;
                            c.this.ist = c.this.isj.getMeasuredHeight();
                            c.this.isx = c.this.isq / c.this.ist;
                            c.this.isy = (int) (1.2f * c.this.mRootView.getWidth());
                            cg(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cg(rawX, rawY);
                        break;
                }
            } else if (c.this.irR == c.this.irJ || c.this.irR == c.this.irL || c.this.irR == c.this.irM || c.this.irR == c.this.irP) {
                switch (c.this.irS) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.irS = 3;
                            c.this.isr = c.this.dlM.getCurrentPosition();
                            aO(f);
                        } else if (motionEvent.getX() < c.this.isp / 2.0f) {
                            c.this.irS = 2;
                            c.this.ish.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.irS = 1;
                            c.this.ish.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.irR != c.this.irP) {
                            c.this.yv(c.this.irP);
                            break;
                        }
                        break;
                    case 1:
                        c.this.ish.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.ccb();
                            break;
                        }
                        break;
                    case 2:
                        c.this.ish.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aO(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cg(int i, int i2) {
            if (c.this.isv != i2 || c.this.isw != i) {
                c.this.isu = c.this.isv - i2 > 0 || ((float) i2) < c.this.isp / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.isj.getLayoutParams();
                if (i2 != c.this.isv) {
                    int i3 = c.this.ist - i2;
                    int i4 = (int) (i3 * c.this.isx);
                    if (i4 < c.this.isy) {
                        i4 = c.this.isy;
                        i3 = (int) (i4 / c.this.isx);
                    }
                    if (i4 != c.this.isy) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.isj.setLayoutParams(layoutParams);
                    }
                    c.this.isv = i2;
                    c.this.isj.setTranslationY(c.this.isv);
                }
                if (i != c.this.isv) {
                    c.this.isw = i;
                    c.this.isj.setTranslationX(c.this.isw + ((c.this.isq - layoutParams.width) / 2.0f));
                }
                c.this.isi.setAlpha((layoutParams.width - c.this.isy) / (c.this.isq - c.this.isy));
                if (c.this.isf.getVisibility() == 0) {
                    float f = c.this.isp / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.isf.setAlpha(f2);
                }
            }
        }

        private void aO(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.isr += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.isr += 1000;
                z = false;
            }
            int duration = c.this.dlM.getDuration();
            if (c.this.isr < 0) {
                c.this.isr = 0;
            } else if (c.this.isr > duration) {
                c.this.isr = duration;
            }
            String str = ap.im(c.this.isr) + "/" + ap.im(duration);
            if (c.this.ish != null) {
                c.this.ish.w(z, str);
            }
            c.this.isd.setCurrentDuration(c.this.isr, false);
        }
    };
    private View.OnTouchListener clc = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.irR == c.this.irP) {
                if (c.this.irS == 4) {
                    c.this.ccn();
                    c.this.isv = 0;
                    c.this.isw = 0;
                } else {
                    c.this.irR = -1;
                    if (c.this.irS != 3) {
                        if (c.this.irT != -1) {
                            c.this.yv(c.this.irT);
                            c.this.irT = -1;
                        } else if (c.this.dlM.isPlaying()) {
                            c.this.yv(c.this.irJ);
                        } else {
                            c.this.yv(c.this.irM);
                        }
                    } else {
                        c.this.isd.setCurrentDuration(c.this.isr, true);
                        if (c.this.isr < c.this.dlM.getDuration()) {
                            if (!c.this.dlM.isPlaying()) {
                                c.this.dlM.start();
                            }
                            c.this.yv(c.this.irJ);
                        }
                    }
                }
                String str = null;
                if (c.this.irS != 1) {
                    if (c.this.irS != 2) {
                        if (c.this.irS == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!ap.isEmpty(str)) {
                    TiebaStatic.log(new am(str).bT("tid", c.this.bVM).l("fid", c.this.mFid));
                }
                c.this.irS = 0;
                return true;
            }
            return c.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.operableVideoView.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                c.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener isC = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cck();
                    return;
                }
                if (c.this.isPlaying()) {
                    ad.a(c.this.bAG, true);
                }
                c.this.dlM.setVolume(1.0f, 1.0f);
                c.this.isb.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bE(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.isp = l.ah(this.mContext);
            this.isq = l.af(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ccc() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.ise.ae(this.isl, this.hDn);
        this.isf.ae(this.isl, this.hDn);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hDn) {
                int dimension3 = (int) this.mContext.getResources().getDimension(R.dimen.tbds112);
                dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i3 = (int) this.mContext.getResources().getDimension(R.dimen.tbds4);
                i2 = dimension2;
                i = dimension3;
                i5 = dimension2;
                i4 = dimension2;
            } else {
                int dimension4 = (int) this.mContext.getResources().getDimension(R.dimen.tbds97);
                int dimension5 = (int) this.mContext.getResources().getDimension(R.dimen.tbds32);
                if (this.isl) {
                    dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds20);
                } else {
                    dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds32);
                }
                int dimension6 = (int) this.mContext.getResources().getDimension(R.dimen.tbds27);
                i = dimension4;
                i2 = dimension5;
                i3 = 0;
                int i6 = dimension;
                dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
                i4 = dimension6;
                i5 = i6;
            }
            this.irZ.getLayoutParams().height = i;
            this.irZ.setPadding(0, 0, 0, i3);
            this.eyX.setPadding(0, 0, i2, 0);
            this.isc.setPadding(this.isc.getPaddingLeft(), 0, i5, 0);
            this.isb.setPadding(i4, 0, this.isb.getPaddingLeft(), 0);
            this.isa.setPadding(dimension2, 0, this.isb.getPaddingLeft(), 0);
        }
    }

    public void ccd() {
        if (this.isl) {
            this.irL = 392;
            this.irM = 390;
        } else {
            this.irL = 904;
            this.irM = 902;
        }
        if (this.hDn) {
            this.irI |= 4096;
            this.irJ |= 4096;
            this.irK |= 4096;
            this.irL |= 4096;
            this.irM |= 4096;
            this.irN |= 4096;
            this.irO |= 4096;
            this.irR |= 4096;
            return;
        }
        this.irI &= -4097;
        this.irJ &= -4097;
        this.irK &= -4097;
        this.irL &= -4097;
        this.irM &= -4097;
        this.irN &= -4097;
        this.irO &= -4097;
        this.irR &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.isj = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.isj);
            }
            this.bAG = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dlM = (QuickVideoView) this.isj.findViewById(R.id.video_view);
            this.gZv = (TbImageView) this.isj.findViewById(R.id.video_thumbnail);
            this.irV = this.isj.findViewById(R.id.black_mask_bottom);
            this.irW = this.isj.findViewById(R.id.black_mask_top);
            this.irX = (TBLottieAnimationView) this.isj.findViewById(R.id.video_play);
            this.irZ = this.isj.findViewById(R.id.video_bottom_ctrl_layout);
            this.irY = (ImageView) this.isj.findViewById(R.id.video_pause);
            this.isa = (TextView) this.isj.findViewById(R.id.video_replay);
            this.eyX = (TextView) this.isj.findViewById(R.id.video_play_count);
            this.eyW = (TextView) this.isj.findViewById(R.id.video_duration);
            this.isb = (SwitchImageView) this.isj.findViewById(R.id.video_mute);
            this.isc = (SwitchImageView) this.isj.findViewById(R.id.video_full_screen);
            this.isd = (OperableVideoMediaControllerView) this.isj.findViewById(R.id.video_media_controller);
            this.ise = (OperableVideoNetworkStateTipView) this.isj.findViewById(R.id.video_network_state_tip);
            this.isf = (OperableVideoShareView) this.isj.findViewById(R.id.video_share_view);
            this.isg = (ImageView) this.isj.findViewById(R.id.video_full_screen_back);
            this.ish = (VideoGestureView) this.isj.findViewById(R.id.video_gesture);
            this.isf.setVideoContainer(this);
            this.iso = new n(this.mContext);
            this.dlM.setNeedRecovery(true);
            this.dlM.setPlayerReuseEnable(true);
            this.dlM.setContinuePlayEnable(true);
            this.iso.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cco() && !c.this.isl && !c.this.hDn && c.this.Vs) {
                        if (!com.baidu.mcn.b.tJ().cE(c.this.isz.jump_url)) {
                            boolean z = ((long) i2) >= c.this.isz.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.isz.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.isz.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fNL.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeW = c.this.isz.card_title;
                                    aVar.aeX = c.this.isz.button_title;
                                    aVar.aeY = c.this.isz.jump_url;
                                    aVar.aeV = c.this.isz.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.bVM;
                                    aVar.aeZ = c.this.buD();
                                    if (z2) {
                                        c.this.fNL.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fNL.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fNL.isShowing()) {
                                c.this.fNL.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.isA != null) {
                        c.this.isA.bE(i, i2);
                    }
                }
            });
            this.dlM.setBusiness(this.iso);
            this.dlM.setOnPreparedListener(this);
            this.dlM.setOnCompletionListener(this);
            this.dlM.setOnErrorListener(this);
            this.dlM.setOnSurfaceDestroyedListener(this);
            this.dlM.setOnOutInfoListener(this);
            this.irX.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.irX.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.irX.setAnimation(R.raw.lotti_video_loading);
            this.irX.setOnClickListener(this);
            this.isb.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.isb.setState(1);
            this.isb.setOnClickListener(this);
            this.gZv.setConrers(15);
            this.gZv.setRadius(l.g(this.mContext, R.dimen.tbds20));
            this.gZv.setDrawCorner(true);
            this.gZv.setDefaultBgResource(e.get());
            this.isd.setPlayer(this.dlM);
            this.isd.setOnSeekBarChangeListener(this.cWi);
            this.isc.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.isc.setState(0);
            this.isc.setOnClickListener(this);
            this.irY.setOnClickListener(this);
            this.isa.setOnClickListener(this);
            this.ise.setPlayViewOnClickListener(this);
            this.isg.setOnClickListener(this);
            this.isj.setOnClickListener(null);
            this.isj.setOnTouchListener(this.clc);
            this.isf.setOnTouchListener(this.clc);
            this.mGestureDetector = new GestureDetector(this.mContext, this.isB);
            yv(this.irI);
            this.exn = new k();
            this.fNL = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.adM() != null) {
            this.startPosition = -1L;
            if (this.fNL != null) {
                this.fNL.reset();
            }
            if (!ap.equals(this.bVa, bgVar.adM().video_url)) {
                this.isl = bgVar.adM().is_vertical.intValue() == 1;
                this.bVa = bgVar.adM().video_url;
                this.bVM = bgVar.getTid();
                this.ism = bgVar.adM().video_length.intValue();
                this.isn = bgVar.adM().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.isz = bgVar.adM().mcn_ad_card;
                ccd();
                ccc();
                yv(this.irI);
                int intValue = bgVar.adM().video_duration.intValue() * 1000;
                this.isd.yt(intValue);
                this.isd.setPlayer(this.dlM);
                this.eyW.setText(ap.im(intValue));
                this.eyX.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), ap.aN(bgVar.adM().play_count.intValue())));
                this.ise.setVideoLength(bgVar.adM().video_length.intValue());
                this.ise.setTid(this.bVM);
                this.iso.cbA().g(bgVar.adM());
                this.gZv.startLoad(bgVar.adM().thumbnail_url, 10, false);
                this.isf.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.iso != null) {
            this.iso.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v cbA() {
        if (this.iso == null) {
            return null;
        }
        return this.iso.cbA();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVj = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Xj = bdUniqueId;
    }

    public void ccg() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.irU);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.irU, this.irH);
    }

    public void cch() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.irU);
    }

    private void startLoadingAnim() {
        if (this.irX != null) {
            this.irX.y(true);
            this.irX.setMinAndMaxFrame(14, 80);
            this.irX.bo();
        }
    }

    protected void cce() {
        if (this.irR == this.irK) {
            yv(this.irJ);
        }
    }

    private void cci() {
        if (this.irX != null) {
            this.irX.clearAnimation();
            this.irX.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.cce();
                    if (c.this.isk) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.irX.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().registerListener(this.isC);
        if (this.ise != null && this.ise.ccp()) {
            yv(this.irO);
            return;
        }
        this.isk = true;
        if (!this.dlM.isPlaying()) {
            this.exn.bMm();
            this.dlM.setVideoPath(this.bVa, this.bVM);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bT("tid", this.bVM).l("fid", this.mFid).P("obj_type", this.isl ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).P("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.isk = false;
        if (this.irX != null) {
            this.irX.cancelAnimation();
        }
        this.dlM.stopPlayback();
        this.isd.aBP();
        yv(this.irI);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.isC);
    }

    public void yv(int i) {
        cch();
        if (i == this.irK) {
            if ("index".equals(this.mFrom)) {
                this.exn.a(this.bVM, this.ism, this.isn, "homepage", this.dlM);
            } else {
                this.exn.a(this.bVM, this.ism, this.isn, this.mFrom, this.dlM);
            }
        }
        if (this.irR == this.irP) {
            this.irT = i;
            return;
        }
        this.irR = i;
        this.gZv.setVisibility((i & 1) > 0 ? 0 : 8);
        this.irV.setVisibility((i & 2) > 0 ? 0 : 8);
        this.irW.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.irX.clearAnimation();
        this.irX.setVisibility(z ? 0 : 8);
        if (!z) {
            this.irX.setFrame(0);
            this.irX.cancelAnimation();
        } else {
            this.irX.setAlpha(1.0f);
        }
        this.irY.setVisibility((i & 8) > 0 ? 0 : 8);
        this.isa.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eyX.setVisibility((i & 32) > 0 ? 0 : 8);
        this.eyW.setVisibility((i & 64) > 0 ? 0 : 8);
        this.isb.setVisibility((i & 128) > 0 ? 0 : 8);
        this.isc.setVisibility((i & 256) > 0 ? 0 : 8);
        this.isd.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.isd.getVisibility() == 0) {
            this.isd.showProgress();
        }
        this.ise.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.isf.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.isf.getVisibility() == 0) {
            this.isf.setAlpha(1.0f);
        }
        this.isg.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.ish.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                ccl();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                ccn();
            } else if (id == R.id.video_replay) {
                yv(this.irI);
                startPlay();
                TiebaStatic.log(new am("c13345").bT("tid", this.bVM).l("fid", this.mFid).P("obj_type", this.isl ? 1 : 2).P("obj_locate", this.hDn ? 1 : 2));
                ccj();
            } else if (id == R.id.video_play) {
                if (this.irR == this.irI) {
                    startPlay();
                } else {
                    yv(this.irL);
                    ccg();
                    this.dlM.start();
                }
                TiebaStatic.log(new am("c13344").bT("tid", this.bVM).l("fid", this.mFid).P("obj_type", this.isl ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hDn ? 1 : 2).P("obj_locate", 1));
                ccj();
            } else if (id == R.id.video_pause) {
                yv(this.irM);
                cch();
                this.dlM.pause();
                TiebaStatic.log(new am("c13344").bT("tid", this.bVM).l("fid", this.mFid).P("obj_type", this.isl ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hDn ? 1 : 2).P("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bVa);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Xj);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cck() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dlM.setVolume(0.0f, 0.0f);
            this.isb.setState(1);
            return;
        }
        this.dlM.setVolume(1.0f, 1.0f);
        this.isb.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccl() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dlM.setVolume(1.0f, 1.0f);
            ad.a(this.bAG, true);
            this.isb.setState(0);
        } else {
            this.dlM.setVolume(0.0f, 0.0f);
            this.isb.setState(1);
            ad.a(this.bAG, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccm() {
        if (this.mRootView != null && this.isj != null && this.dlM != null) {
            this.dlM.setFullScreenToDestroySurface();
            if (this.ddP == null) {
                this.ddP = new o((Activity) this.mContext);
            }
            if (this.hDn) {
                if (!this.isl) {
                    this.ddP.bIm();
                }
                if (this.isi.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.isi.getParent()).removeView(this.isi);
                }
                if ((this.isj.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hDn = false;
                    ((ViewGroup) this.isj.getParent()).removeView(this.isj);
                    ((ViewGroup) this.mRootView).addView(this.isj);
                    h((Activity) this.mContext, this.hDn);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.isl) {
                        this.ddP.bIm();
                    }
                    if (this.mContext instanceof Activity) {
                        this.isj.getLocationOnScreen(this.iss);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.isi == null) {
                                    this.isi = new View(this.mContext);
                                    this.isi.setClickable(true);
                                    this.isi.setBackgroundColor(al.getColor(R.color.black_alpha100));
                                    this.isi.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.isi.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.isi.getParent()).removeView(this.isi);
                                }
                                this.isi.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.isi);
                                ((ViewGroup) childAt).addView(this.isj);
                                this.hDn = true;
                                h((Activity) this.mContext, this.hDn);
                                if (this.fNL != null && this.fNL.isShowing()) {
                                    this.fNL.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bT("tid", this.bVM).l("fid", this.mFid).P("obj_type", this.isl ? 1 : 2));
            }
            ccd();
            ccc();
            if (this.dlM.isPlaying()) {
                yv(this.irJ);
            } else {
                this.irR |= 1;
                yv(this.irR);
            }
            this.isc.cvh();
            lj(this.hDn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccn() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.isl) {
            ccm();
        } else if (this.irR == this.irP) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.isj.setScaleX(1.0f);
                    c.this.isj.setScaleY(1.0f);
                    c.this.isj.setTranslationX(0.0f);
                    c.this.isj.setTranslationY(0.0f);
                    c.this.isf.setScaleX(1.0f);
                    c.this.isf.setScaleY(1.0f);
                    c.this.isj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.isu) {
                        c.this.ccm();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ObjectAnimator objectAnimator = null;
            if (!this.isu) {
                float width = this.mRootView.getWidth() / this.isj.getWidth();
                float height = this.mRootView.getHeight() / this.isj.getHeight();
                this.isj.setPivotX(0.0f);
                this.isj.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.isj, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.isj, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.isf, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.isf, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.isj, "TranslationX", this.isj.getTranslationX(), this.iss[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.isj, "TranslationY", this.isj.getTranslationY(), this.iss[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.isi, "alpha", this.isi.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.isf, "alpha", this.isf.getAlpha(), 0.0f);
            } else {
                float width2 = this.isq / this.isj.getWidth();
                float height2 = this.ist / this.isj.getHeight();
                this.isj.setPivotX(0.0f);
                this.isj.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.isj, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.isj, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.isf, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.isf, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.isj, "TranslationX", this.isj.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.isj, "TranslationY", this.isj.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.isf, "alpha", this.isf.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.irT != -1) {
                this.irR = this.irT;
                this.irT = -1;
                if (this.irR == this.irQ || this.irR == this.irL || this.irR == this.irJ) {
                    this.dlM.start();
                    yv(this.irJ);
                }
            }
        } else {
            ccm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bIl();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.isj.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lj(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cck();
        this.exn.bMn();
        if (this.isk) {
            if (this.hDn && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dlM.start();
            if (!this.dlM.getPlayer().isNewPlayer()) {
                yv(this.irK);
                this.isd.showProgress();
                cci();
            }
        }
    }

    public void onCompletion(g gVar) {
        yv(this.irN);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.irR == this.irM) {
            stopPlay();
            yv(this.irM);
        } else if (this.irR == this.irN) {
            stopPlay();
            yv(this.irN);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            yv(this.irK);
            this.isd.showProgress();
            cci();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View caZ() {
        return this.isj;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.isk || this.dlM.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dlM.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cca() {
    }

    private void bIl() {
        if (Build.VERSION.SDK_INT < 16) {
            this.isj.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.isj.setSystemUiVisibility(4);
        } else {
            this.isj.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ccb() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.dlM.isPlaying() && !ad.avx()) {
            this.dlM.setVolume(1.0f, 1.0f);
            this.isb.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean li(boolean z) {
        if (z) {
            this.irX.cancelAnimation();
            if (this.irR == this.irJ || this.irR == this.irK || this.irR == this.irL || this.irR == this.irI) {
                stopPlay();
            }
            this.irR |= 1;
            yv(this.irR);
        } else if (this.irR == this.irI) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hDn;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hDn) {
            ccn();
            return true;
        }
        return false;
    }

    protected int buD() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cco() {
        return this.isz != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pT(boolean z) {
        this.Vs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.isA = aVar;
    }
}
