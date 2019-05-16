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
    protected BdUniqueId Xk;
    private String bUZ;
    protected String bVL;
    private o ddN;
    protected QuickVideoView dlL;
    protected k exm;
    private TextView eyV;
    private TextView eyW;
    private com.baidu.mcn.c fNI;
    protected TbImageView gZr;
    private View irR;
    private View irS;
    private TBLottieAnimationView irT;
    private ImageView irU;
    private View irV;
    private TextView irW;
    protected SwitchImageView irX;
    private SwitchImageView irY;
    private OperableVideoMediaControllerView irZ;
    private OperableVideoNetworkStateTipView isa;
    private OperableVideoShareView isb;
    private ImageView isc;
    private VideoGestureView isd;
    private View ise;
    protected ViewGroup isf;
    protected boolean isg;
    protected boolean ish;
    protected long isi;
    protected long isj;
    private n isk;
    private float isl;
    private float ism;
    private int isn;
    private int isp;
    private boolean isq;
    private float ist;
    private int isu;
    private McnAdInfo isv;
    private a isw;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int irD = 3000;
    protected int irE = 103;
    protected int irF = 0;
    protected int irG = 4;
    protected int irH = 904;
    protected int irI = 902;
    protected int irJ = 2066;
    protected int irK = 1027;
    protected int irL = CommandMessage.COMMAND_BASE;
    protected int irM = 0;
    protected int irN = this.irE;
    private int irO = 0;
    private int irP = -1;
    private Runnable irQ = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.yv(c.this.irF);
        }
    };
    private WeakReference<Context> bAG = null;
    private boolean hDj = false;
    private int[] iso = new int[2];
    private int isr = 0;
    private int iss = 0;
    protected View.OnClickListener bVi = null;
    private boolean Vt = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cWg = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.yv(c.this.irH);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dlL.isPlaying()) {
                    c.this.dlL.start();
                }
                c.this.ccc();
                TiebaStatic.log(new am("c13355").bT("tid", c.this.bVL).l("fid", c.this.mFid).P("obj_type", c.this.ish ? 1 : 2).P("obj_locate", c.this.hDj ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener isx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dlL.isPlaying()) {
                c.this.dlL.pause();
                c.this.yv(c.this.irI);
            } else if (c.this.irN == c.this.irI || c.this.irN == (c.this.irI | 1)) {
                c.this.dlL.start();
                c.this.yv(c.this.irH);
                c.this.ccc();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.irN == c.this.irF || c.this.irN == c.this.irG) {
                c.this.yv(c.this.irH);
                c.this.ccc();
            } else if (c.this.irN == c.this.irH) {
                c.this.yv(c.this.irF);
            } else if (c.this.irN == c.this.irI) {
                c.this.yv(c.this.irH);
                c.this.ccc();
                c.this.dlL.start();
                TiebaStatic.log(new am("c13344").bT("tid", c.this.bVL).l("fid", c.this.mFid).P("obj_type", c.this.ish ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hDj ? 1 : 2).P("obj_locate", 1));
                c.this.ccf();
            } else {
                c.this.yv(c.this.irE);
                c.this.startPlay();
                c.this.ccf();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.irO = 0;
            if (c.this.hDj) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hDj) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.ish) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.irO) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dlL.isPlaying()) {
                                c.this.dlL.pause();
                                c.this.yv(c.this.irM);
                            }
                            c.this.irO = 4;
                            c.this.irP = c.this.irN;
                            c.this.irN = c.this.irL;
                            c.this.isp = c.this.isf.getMeasuredHeight();
                            c.this.ist = c.this.ism / c.this.isp;
                            c.this.isu = (int) (1.2f * c.this.mRootView.getWidth());
                            cg(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cg(rawX, rawY);
                        break;
                }
            } else if (c.this.irN == c.this.irF || c.this.irN == c.this.irH || c.this.irN == c.this.irI || c.this.irN == c.this.irL) {
                switch (c.this.irO) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.irO = 3;
                            c.this.isn = c.this.dlL.getCurrentPosition();
                            aO(f);
                        } else if (motionEvent.getX() < c.this.isl / 2.0f) {
                            c.this.irO = 2;
                            c.this.isd.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.irO = 1;
                            c.this.isd.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.irN != c.this.irL) {
                            c.this.yv(c.this.irL);
                            break;
                        }
                        break;
                    case 1:
                        c.this.isd.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.cbX();
                            break;
                        }
                        break;
                    case 2:
                        c.this.isd.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aO(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cg(int i, int i2) {
            if (c.this.isr != i2 || c.this.iss != i) {
                c.this.isq = c.this.isr - i2 > 0 || ((float) i2) < c.this.isl / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.isf.getLayoutParams();
                if (i2 != c.this.isr) {
                    int i3 = c.this.isp - i2;
                    int i4 = (int) (i3 * c.this.ist);
                    if (i4 < c.this.isu) {
                        i4 = c.this.isu;
                        i3 = (int) (i4 / c.this.ist);
                    }
                    if (i4 != c.this.isu) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.isf.setLayoutParams(layoutParams);
                    }
                    c.this.isr = i2;
                    c.this.isf.setTranslationY(c.this.isr);
                }
                if (i != c.this.isr) {
                    c.this.iss = i;
                    c.this.isf.setTranslationX(c.this.iss + ((c.this.ism - layoutParams.width) / 2.0f));
                }
                c.this.ise.setAlpha((layoutParams.width - c.this.isu) / (c.this.ism - c.this.isu));
                if (c.this.isb.getVisibility() == 0) {
                    float f = c.this.isl / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.isb.setAlpha(f2);
                }
            }
        }

        private void aO(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.isn += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.isn += 1000;
                z = false;
            }
            int duration = c.this.dlL.getDuration();
            if (c.this.isn < 0) {
                c.this.isn = 0;
            } else if (c.this.isn > duration) {
                c.this.isn = duration;
            }
            String str = ap.im(c.this.isn) + "/" + ap.im(duration);
            if (c.this.isd != null) {
                c.this.isd.w(z, str);
            }
            c.this.irZ.setCurrentDuration(c.this.isn, false);
        }
    };
    private View.OnTouchListener clb = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.irN == c.this.irL) {
                if (c.this.irO == 4) {
                    c.this.ccj();
                    c.this.isr = 0;
                    c.this.iss = 0;
                } else {
                    c.this.irN = -1;
                    if (c.this.irO != 3) {
                        if (c.this.irP != -1) {
                            c.this.yv(c.this.irP);
                            c.this.irP = -1;
                        } else if (c.this.dlL.isPlaying()) {
                            c.this.yv(c.this.irF);
                        } else {
                            c.this.yv(c.this.irI);
                        }
                    } else {
                        c.this.irZ.setCurrentDuration(c.this.isn, true);
                        if (c.this.isn < c.this.dlL.getDuration()) {
                            if (!c.this.dlL.isPlaying()) {
                                c.this.dlL.start();
                            }
                            c.this.yv(c.this.irF);
                        }
                    }
                }
                String str = null;
                if (c.this.irO != 1) {
                    if (c.this.irO != 2) {
                        if (c.this.irO == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!ap.isEmpty(str)) {
                    TiebaStatic.log(new am(str).bT("tid", c.this.bVL).l("fid", c.this.mFid));
                }
                c.this.irO = 0;
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
    private final CustomMessageListener isy = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.ccg();
                    return;
                }
                if (c.this.isPlaying()) {
                    ad.a(c.this.bAG, true);
                }
                c.this.dlL.setVolume(1.0f, 1.0f);
                c.this.irX.setState(0);
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
            this.isl = l.ah(this.mContext);
            this.ism = l.af(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cbY() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.isa.ae(this.ish, this.hDj);
        this.isb.ae(this.ish, this.hDj);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hDj) {
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
                if (this.ish) {
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
            this.irV.getLayoutParams().height = i;
            this.irV.setPadding(0, 0, 0, i3);
            this.eyW.setPadding(0, 0, i2, 0);
            this.irY.setPadding(this.irY.getPaddingLeft(), 0, i5, 0);
            this.irX.setPadding(i4, 0, this.irX.getPaddingLeft(), 0);
            this.irW.setPadding(dimension2, 0, this.irX.getPaddingLeft(), 0);
        }
    }

    public void cbZ() {
        if (this.ish) {
            this.irH = 392;
            this.irI = 390;
        } else {
            this.irH = 904;
            this.irI = 902;
        }
        if (this.hDj) {
            this.irE |= 4096;
            this.irF |= 4096;
            this.irG |= 4096;
            this.irH |= 4096;
            this.irI |= 4096;
            this.irJ |= 4096;
            this.irK |= 4096;
            this.irN |= 4096;
            return;
        }
        this.irE &= -4097;
        this.irF &= -4097;
        this.irG &= -4097;
        this.irH &= -4097;
        this.irI &= -4097;
        this.irJ &= -4097;
        this.irK &= -4097;
        this.irN &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.isf = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.isf);
            }
            this.bAG = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dlL = (QuickVideoView) this.isf.findViewById(R.id.video_view);
            this.gZr = (TbImageView) this.isf.findViewById(R.id.video_thumbnail);
            this.irR = this.isf.findViewById(R.id.black_mask_bottom);
            this.irS = this.isf.findViewById(R.id.black_mask_top);
            this.irT = (TBLottieAnimationView) this.isf.findViewById(R.id.video_play);
            this.irV = this.isf.findViewById(R.id.video_bottom_ctrl_layout);
            this.irU = (ImageView) this.isf.findViewById(R.id.video_pause);
            this.irW = (TextView) this.isf.findViewById(R.id.video_replay);
            this.eyW = (TextView) this.isf.findViewById(R.id.video_play_count);
            this.eyV = (TextView) this.isf.findViewById(R.id.video_duration);
            this.irX = (SwitchImageView) this.isf.findViewById(R.id.video_mute);
            this.irY = (SwitchImageView) this.isf.findViewById(R.id.video_full_screen);
            this.irZ = (OperableVideoMediaControllerView) this.isf.findViewById(R.id.video_media_controller);
            this.isa = (OperableVideoNetworkStateTipView) this.isf.findViewById(R.id.video_network_state_tip);
            this.isb = (OperableVideoShareView) this.isf.findViewById(R.id.video_share_view);
            this.isc = (ImageView) this.isf.findViewById(R.id.video_full_screen_back);
            this.isd = (VideoGestureView) this.isf.findViewById(R.id.video_gesture);
            this.isb.setVideoContainer(this);
            this.isk = new n(this.mContext);
            this.dlL.setNeedRecovery(true);
            this.dlL.setPlayerReuseEnable(true);
            this.dlL.setContinuePlayEnable(true);
            this.isk.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cck() && !c.this.ish && !c.this.hDj && c.this.Vt) {
                        if (!com.baidu.mcn.b.tJ().cF(c.this.isv.jump_url)) {
                            boolean z = ((long) i2) >= c.this.isv.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.isv.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.isv.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fNI.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeW = c.this.isv.card_title;
                                    aVar.aeX = c.this.isv.button_title;
                                    aVar.aeY = c.this.isv.jump_url;
                                    aVar.aeV = c.this.isv.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.bVL;
                                    aVar.aeZ = c.this.buz();
                                    if (z2) {
                                        c.this.fNI.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fNI.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fNI.isShowing()) {
                                c.this.fNI.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.isw != null) {
                        c.this.isw.bE(i, i2);
                    }
                }
            });
            this.dlL.setBusiness(this.isk);
            this.dlL.setOnPreparedListener(this);
            this.dlL.setOnCompletionListener(this);
            this.dlL.setOnErrorListener(this);
            this.dlL.setOnSurfaceDestroyedListener(this);
            this.dlL.setOnOutInfoListener(this);
            this.irT.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.irT.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.irT.setAnimation(R.raw.lotti_video_loading);
            this.irT.setOnClickListener(this);
            this.irX.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.irX.setState(1);
            this.irX.setOnClickListener(this);
            this.gZr.setConrers(15);
            this.gZr.setRadius(l.g(this.mContext, R.dimen.tbds20));
            this.gZr.setDrawCorner(true);
            this.gZr.setDefaultBgResource(e.get());
            this.irZ.setPlayer(this.dlL);
            this.irZ.setOnSeekBarChangeListener(this.cWg);
            this.irY.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.irY.setState(0);
            this.irY.setOnClickListener(this);
            this.irU.setOnClickListener(this);
            this.irW.setOnClickListener(this);
            this.isa.setPlayViewOnClickListener(this);
            this.isc.setOnClickListener(this);
            this.isf.setOnClickListener(null);
            this.isf.setOnTouchListener(this.clb);
            this.isb.setOnTouchListener(this.clb);
            this.mGestureDetector = new GestureDetector(this.mContext, this.isx);
            yv(this.irE);
            this.exm = new k();
            this.fNI = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.adM() != null) {
            this.startPosition = -1L;
            if (this.fNI != null) {
                this.fNI.reset();
            }
            if (!ap.equals(this.bUZ, bgVar.adM().video_url)) {
                this.ish = bgVar.adM().is_vertical.intValue() == 1;
                this.bUZ = bgVar.adM().video_url;
                this.bVL = bgVar.getTid();
                this.isi = bgVar.adM().video_length.intValue();
                this.isj = bgVar.adM().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.isv = bgVar.adM().mcn_ad_card;
                cbZ();
                cbY();
                yv(this.irE);
                int intValue = bgVar.adM().video_duration.intValue() * 1000;
                this.irZ.yt(intValue);
                this.irZ.setPlayer(this.dlL);
                this.eyV.setText(ap.im(intValue));
                this.eyW.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), ap.aN(bgVar.adM().play_count.intValue())));
                this.isa.setVideoLength(bgVar.adM().video_length.intValue());
                this.isa.setTid(this.bVL);
                this.isk.cbw().g(bgVar.adM());
                this.gZr.startLoad(bgVar.adM().thumbnail_url, 10, false);
                this.isb.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.isk != null) {
            this.isk.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v cbw() {
        if (this.isk == null) {
            return null;
        }
        return this.isk.cbw();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVi = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Xk = bdUniqueId;
    }

    public void ccc() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.irQ);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.irQ, this.irD);
    }

    public void ccd() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.irQ);
    }

    private void startLoadingAnim() {
        if (this.irT != null) {
            this.irT.y(true);
            this.irT.setMinAndMaxFrame(14, 80);
            this.irT.bo();
        }
    }

    protected void cca() {
        if (this.irN == this.irG) {
            yv(this.irF);
        }
    }

    private void cce() {
        if (this.irT != null) {
            this.irT.clearAnimation();
            this.irT.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.cca();
                    if (c.this.isg) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.irT.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.isy);
        if (this.isa != null && this.isa.ccl()) {
            yv(this.irK);
            return;
        }
        this.isg = true;
        if (!this.dlL.isPlaying()) {
            this.exm.bMi();
            this.dlL.setVideoPath(this.bUZ, this.bVL);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.ish ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).P("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.isg = false;
        if (this.irT != null) {
            this.irT.cancelAnimation();
        }
        this.dlL.stopPlayback();
        this.irZ.aBM();
        yv(this.irE);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    public void yv(int i) {
        ccd();
        if (i == this.irG) {
            if ("index".equals(this.mFrom)) {
                this.exm.a(this.bVL, this.isi, this.isj, "homepage", this.dlL);
            } else {
                this.exm.a(this.bVL, this.isi, this.isj, this.mFrom, this.dlL);
            }
        }
        if (this.irN == this.irL) {
            this.irP = i;
            return;
        }
        this.irN = i;
        this.gZr.setVisibility((i & 1) > 0 ? 0 : 8);
        this.irR.setVisibility((i & 2) > 0 ? 0 : 8);
        this.irS.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.irT.clearAnimation();
        this.irT.setVisibility(z ? 0 : 8);
        if (!z) {
            this.irT.setFrame(0);
            this.irT.cancelAnimation();
        } else {
            this.irT.setAlpha(1.0f);
        }
        this.irU.setVisibility((i & 8) > 0 ? 0 : 8);
        this.irW.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eyW.setVisibility((i & 32) > 0 ? 0 : 8);
        this.eyV.setVisibility((i & 64) > 0 ? 0 : 8);
        this.irX.setVisibility((i & 128) > 0 ? 0 : 8);
        this.irY.setVisibility((i & 256) > 0 ? 0 : 8);
        this.irZ.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.irZ.getVisibility() == 0) {
            this.irZ.showProgress();
        }
        this.isa.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.isb.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.isb.getVisibility() == 0) {
            this.isb.setAlpha(1.0f);
        }
        this.isc.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.isd.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cch();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                ccj();
            } else if (id == R.id.video_replay) {
                yv(this.irE);
                startPlay();
                TiebaStatic.log(new am("c13345").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.ish ? 1 : 2).P("obj_locate", this.hDj ? 1 : 2));
                ccf();
            } else if (id == R.id.video_play) {
                if (this.irN == this.irE) {
                    startPlay();
                } else {
                    yv(this.irH);
                    ccc();
                    this.dlL.start();
                }
                TiebaStatic.log(new am("c13344").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.ish ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hDj ? 1 : 2).P("obj_locate", 1));
                ccf();
            } else if (id == R.id.video_pause) {
                yv(this.irI);
                ccd();
                this.dlL.pause();
                TiebaStatic.log(new am("c13344").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.ish ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hDj ? 1 : 2).P("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccf() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bUZ);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Xk);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dlL.setVolume(0.0f, 0.0f);
            this.irX.setState(1);
            return;
        }
        this.dlL.setVolume(1.0f, 1.0f);
        this.irX.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cch() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dlL.setVolume(1.0f, 1.0f);
            ad.a(this.bAG, true);
            this.irX.setState(0);
        } else {
            this.dlL.setVolume(0.0f, 0.0f);
            this.irX.setState(1);
            ad.a(this.bAG, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cci() {
        if (this.mRootView != null && this.isf != null && this.dlL != null) {
            this.dlL.setFullScreenToDestroySurface();
            if (this.ddN == null) {
                this.ddN = new o((Activity) this.mContext);
            }
            if (this.hDj) {
                if (!this.ish) {
                    this.ddN.bIi();
                }
                if (this.ise.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.ise.getParent()).removeView(this.ise);
                }
                if ((this.isf.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hDj = false;
                    ((ViewGroup) this.isf.getParent()).removeView(this.isf);
                    ((ViewGroup) this.mRootView).addView(this.isf);
                    h((Activity) this.mContext, this.hDj);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.ish) {
                        this.ddN.bIi();
                    }
                    if (this.mContext instanceof Activity) {
                        this.isf.getLocationOnScreen(this.iso);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.ise == null) {
                                    this.ise = new View(this.mContext);
                                    this.ise.setClickable(true);
                                    this.ise.setBackgroundColor(al.getColor(R.color.black_alpha100));
                                    this.ise.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.ise.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.ise.getParent()).removeView(this.ise);
                                }
                                this.ise.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.ise);
                                ((ViewGroup) childAt).addView(this.isf);
                                this.hDj = true;
                                h((Activity) this.mContext, this.hDj);
                                if (this.fNI != null && this.fNI.isShowing()) {
                                    this.fNI.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.ish ? 1 : 2));
            }
            cbZ();
            cbY();
            if (this.dlL.isPlaying()) {
                yv(this.irF);
            } else {
                this.irN |= 1;
                yv(this.irN);
            }
            this.irY.cvg();
            li(this.hDj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.ish) {
            cci();
        } else if (this.irN == this.irL) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.isf.setScaleX(1.0f);
                    c.this.isf.setScaleY(1.0f);
                    c.this.isf.setTranslationX(0.0f);
                    c.this.isf.setTranslationY(0.0f);
                    c.this.isb.setScaleX(1.0f);
                    c.this.isb.setScaleY(1.0f);
                    c.this.isf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.isq) {
                        c.this.cci();
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
            if (!this.isq) {
                float width = this.mRootView.getWidth() / this.isf.getWidth();
                float height = this.mRootView.getHeight() / this.isf.getHeight();
                this.isf.setPivotX(0.0f);
                this.isf.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.isf, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.isf, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.isb, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.isb, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.isf, "TranslationX", this.isf.getTranslationX(), this.iso[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.isf, "TranslationY", this.isf.getTranslationY(), this.iso[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.ise, "alpha", this.ise.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.isb, "alpha", this.isb.getAlpha(), 0.0f);
            } else {
                float width2 = this.ism / this.isf.getWidth();
                float height2 = this.isp / this.isf.getHeight();
                this.isf.setPivotX(0.0f);
                this.isf.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.isf, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.isf, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.isb, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.isb, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.isf, "TranslationX", this.isf.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.isf, "TranslationY", this.isf.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.isb, "alpha", this.isb.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.irP != -1) {
                this.irN = this.irP;
                this.irP = -1;
                if (this.irN == this.irM || this.irN == this.irH || this.irN == this.irF) {
                    this.dlL.start();
                    yv(this.irF);
                }
            }
        } else {
            cci();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bIh();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.isf.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void li(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        ccg();
        this.exm.bMj();
        if (this.isg) {
            if (this.hDj && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dlL.start();
            if (!this.dlL.getPlayer().isNewPlayer()) {
                yv(this.irG);
                this.irZ.showProgress();
                cce();
            }
        }
    }

    public void onCompletion(g gVar) {
        yv(this.irJ);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.irN == this.irI) {
            stopPlay();
            yv(this.irI);
        } else if (this.irN == this.irJ) {
            stopPlay();
            yv(this.irJ);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            yv(this.irG);
            this.irZ.showProgress();
            cce();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View caV() {
        return this.isf;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.isg || this.dlL.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dlL.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cbW() {
    }

    private void bIh() {
        if (Build.VERSION.SDK_INT < 16) {
            this.isf.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.isf.setSystemUiVisibility(4);
        } else {
            this.isf.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cbX() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.dlL.isPlaying() && !ad.avx()) {
            this.dlL.setVolume(1.0f, 1.0f);
            this.irX.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean lh(boolean z) {
        if (z) {
            this.irT.cancelAnimation();
            if (this.irN == this.irF || this.irN == this.irG || this.irN == this.irH || this.irN == this.irE) {
                stopPlay();
            }
            this.irN |= 1;
            yv(this.irN);
        } else if (this.irN == this.irE) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hDj;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hDj) {
            ccj();
            return true;
        }
        return false;
    }

    protected int buz() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cck() {
        return this.isv != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pS(boolean z) {
        this.Vt = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.isw = aVar;
    }
}
