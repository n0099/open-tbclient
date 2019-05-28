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
    private o ddO;
    protected QuickVideoView dlM;
    protected k exn;
    private TextView eyW;
    private TextView eyX;
    private com.baidu.mcn.c fNJ;
    protected TbImageView gZu;
    private View irU;
    private View irV;
    private TBLottieAnimationView irW;
    private ImageView irX;
    private View irY;
    private TextView irZ;
    protected SwitchImageView isa;
    private SwitchImageView isb;
    private OperableVideoMediaControllerView isc;
    private OperableVideoNetworkStateTipView isd;
    private OperableVideoShareView ise;
    private ImageView isf;
    private VideoGestureView isg;
    private View ish;
    protected ViewGroup isi;
    protected boolean isj;
    protected boolean isk;
    protected long isl;
    protected long ism;
    private n isn;
    private float iso;
    private float isp;
    private int isq;
    private int iss;
    private boolean ist;
    private float isw;
    private int isx;
    private McnAdInfo isy;
    private a isz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int irG = 3000;
    protected int irH = 103;
    protected int irI = 0;
    protected int irJ = 4;
    protected int irK = 904;
    protected int irL = 902;
    protected int irM = 2066;
    protected int irN = 1027;
    protected int irO = CommandMessage.COMMAND_BASE;
    protected int irP = 0;
    protected int irQ = this.irH;
    private int irR = 0;
    private int irS = -1;
    private Runnable irT = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.yv(c.this.irI);
        }
    };
    private WeakReference<Context> bAG = null;
    private boolean hDm = false;
    private int[] isr = new int[2];
    private int isu = 0;
    private int isv = 0;
    protected View.OnClickListener bVi = null;
    private boolean Vt = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cWh = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.yv(c.this.irK);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dlM.isPlaying()) {
                    c.this.dlM.start();
                }
                c.this.ccf();
                TiebaStatic.log(new am("c13355").bT("tid", c.this.bVL).l("fid", c.this.mFid).P("obj_type", c.this.isk ? 1 : 2).P("obj_locate", c.this.hDm ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener isA = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dlM.isPlaying()) {
                c.this.dlM.pause();
                c.this.yv(c.this.irL);
            } else if (c.this.irQ == c.this.irL || c.this.irQ == (c.this.irL | 1)) {
                c.this.dlM.start();
                c.this.yv(c.this.irK);
                c.this.ccf();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.irQ == c.this.irI || c.this.irQ == c.this.irJ) {
                c.this.yv(c.this.irK);
                c.this.ccf();
            } else if (c.this.irQ == c.this.irK) {
                c.this.yv(c.this.irI);
            } else if (c.this.irQ == c.this.irL) {
                c.this.yv(c.this.irK);
                c.this.ccf();
                c.this.dlM.start();
                TiebaStatic.log(new am("c13344").bT("tid", c.this.bVL).l("fid", c.this.mFid).P("obj_type", c.this.isk ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hDm ? 1 : 2).P("obj_locate", 1));
                c.this.cci();
            } else {
                c.this.yv(c.this.irH);
                c.this.startPlay();
                c.this.cci();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.irR = 0;
            if (c.this.hDm) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hDm) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.isk) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.irR) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dlM.isPlaying()) {
                                c.this.dlM.pause();
                                c.this.yv(c.this.irP);
                            }
                            c.this.irR = 4;
                            c.this.irS = c.this.irQ;
                            c.this.irQ = c.this.irO;
                            c.this.iss = c.this.isi.getMeasuredHeight();
                            c.this.isw = c.this.isp / c.this.iss;
                            c.this.isx = (int) (1.2f * c.this.mRootView.getWidth());
                            cg(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cg(rawX, rawY);
                        break;
                }
            } else if (c.this.irQ == c.this.irI || c.this.irQ == c.this.irK || c.this.irQ == c.this.irL || c.this.irQ == c.this.irO) {
                switch (c.this.irR) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.irR = 3;
                            c.this.isq = c.this.dlM.getCurrentPosition();
                            aO(f);
                        } else if (motionEvent.getX() < c.this.iso / 2.0f) {
                            c.this.irR = 2;
                            c.this.isg.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.irR = 1;
                            c.this.isg.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.irQ != c.this.irO) {
                            c.this.yv(c.this.irO);
                            break;
                        }
                        break;
                    case 1:
                        c.this.isg.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.cca();
                            break;
                        }
                        break;
                    case 2:
                        c.this.isg.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aO(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cg(int i, int i2) {
            if (c.this.isu != i2 || c.this.isv != i) {
                c.this.ist = c.this.isu - i2 > 0 || ((float) i2) < c.this.iso / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.isi.getLayoutParams();
                if (i2 != c.this.isu) {
                    int i3 = c.this.iss - i2;
                    int i4 = (int) (i3 * c.this.isw);
                    if (i4 < c.this.isx) {
                        i4 = c.this.isx;
                        i3 = (int) (i4 / c.this.isw);
                    }
                    if (i4 != c.this.isx) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.isi.setLayoutParams(layoutParams);
                    }
                    c.this.isu = i2;
                    c.this.isi.setTranslationY(c.this.isu);
                }
                if (i != c.this.isu) {
                    c.this.isv = i;
                    c.this.isi.setTranslationX(c.this.isv + ((c.this.isp - layoutParams.width) / 2.0f));
                }
                c.this.ish.setAlpha((layoutParams.width - c.this.isx) / (c.this.isp - c.this.isx));
                if (c.this.ise.getVisibility() == 0) {
                    float f = c.this.iso / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.ise.setAlpha(f2);
                }
            }
        }

        private void aO(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.isq += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.isq += 1000;
                z = false;
            }
            int duration = c.this.dlM.getDuration();
            if (c.this.isq < 0) {
                c.this.isq = 0;
            } else if (c.this.isq > duration) {
                c.this.isq = duration;
            }
            String str = ap.im(c.this.isq) + "/" + ap.im(duration);
            if (c.this.isg != null) {
                c.this.isg.w(z, str);
            }
            c.this.isc.setCurrentDuration(c.this.isq, false);
        }
    };
    private View.OnTouchListener clb = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.irQ == c.this.irO) {
                if (c.this.irR == 4) {
                    c.this.ccm();
                    c.this.isu = 0;
                    c.this.isv = 0;
                } else {
                    c.this.irQ = -1;
                    if (c.this.irR != 3) {
                        if (c.this.irS != -1) {
                            c.this.yv(c.this.irS);
                            c.this.irS = -1;
                        } else if (c.this.dlM.isPlaying()) {
                            c.this.yv(c.this.irI);
                        } else {
                            c.this.yv(c.this.irL);
                        }
                    } else {
                        c.this.isc.setCurrentDuration(c.this.isq, true);
                        if (c.this.isq < c.this.dlM.getDuration()) {
                            if (!c.this.dlM.isPlaying()) {
                                c.this.dlM.start();
                            }
                            c.this.yv(c.this.irI);
                        }
                    }
                }
                String str = null;
                if (c.this.irR != 1) {
                    if (c.this.irR != 2) {
                        if (c.this.irR == 3) {
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
                c.this.irR = 0;
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
    private final CustomMessageListener isB = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.ccj();
                    return;
                }
                if (c.this.isPlaying()) {
                    ad.a(c.this.bAG, true);
                }
                c.this.dlM.setVolume(1.0f, 1.0f);
                c.this.isa.setState(0);
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
            this.iso = l.ah(this.mContext);
            this.isp = l.af(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ccb() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.isd.ae(this.isk, this.hDm);
        this.ise.ae(this.isk, this.hDm);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hDm) {
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
                if (this.isk) {
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
            this.irY.getLayoutParams().height = i;
            this.irY.setPadding(0, 0, 0, i3);
            this.eyX.setPadding(0, 0, i2, 0);
            this.isb.setPadding(this.isb.getPaddingLeft(), 0, i5, 0);
            this.isa.setPadding(i4, 0, this.isa.getPaddingLeft(), 0);
            this.irZ.setPadding(dimension2, 0, this.isa.getPaddingLeft(), 0);
        }
    }

    public void ccc() {
        if (this.isk) {
            this.irK = 392;
            this.irL = 390;
        } else {
            this.irK = 904;
            this.irL = 902;
        }
        if (this.hDm) {
            this.irH |= 4096;
            this.irI |= 4096;
            this.irJ |= 4096;
            this.irK |= 4096;
            this.irL |= 4096;
            this.irM |= 4096;
            this.irN |= 4096;
            this.irQ |= 4096;
            return;
        }
        this.irH &= -4097;
        this.irI &= -4097;
        this.irJ &= -4097;
        this.irK &= -4097;
        this.irL &= -4097;
        this.irM &= -4097;
        this.irN &= -4097;
        this.irQ &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.isi = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.isi);
            }
            this.bAG = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dlM = (QuickVideoView) this.isi.findViewById(R.id.video_view);
            this.gZu = (TbImageView) this.isi.findViewById(R.id.video_thumbnail);
            this.irU = this.isi.findViewById(R.id.black_mask_bottom);
            this.irV = this.isi.findViewById(R.id.black_mask_top);
            this.irW = (TBLottieAnimationView) this.isi.findViewById(R.id.video_play);
            this.irY = this.isi.findViewById(R.id.video_bottom_ctrl_layout);
            this.irX = (ImageView) this.isi.findViewById(R.id.video_pause);
            this.irZ = (TextView) this.isi.findViewById(R.id.video_replay);
            this.eyX = (TextView) this.isi.findViewById(R.id.video_play_count);
            this.eyW = (TextView) this.isi.findViewById(R.id.video_duration);
            this.isa = (SwitchImageView) this.isi.findViewById(R.id.video_mute);
            this.isb = (SwitchImageView) this.isi.findViewById(R.id.video_full_screen);
            this.isc = (OperableVideoMediaControllerView) this.isi.findViewById(R.id.video_media_controller);
            this.isd = (OperableVideoNetworkStateTipView) this.isi.findViewById(R.id.video_network_state_tip);
            this.ise = (OperableVideoShareView) this.isi.findViewById(R.id.video_share_view);
            this.isf = (ImageView) this.isi.findViewById(R.id.video_full_screen_back);
            this.isg = (VideoGestureView) this.isi.findViewById(R.id.video_gesture);
            this.ise.setVideoContainer(this);
            this.isn = new n(this.mContext);
            this.dlM.setNeedRecovery(true);
            this.dlM.setPlayerReuseEnable(true);
            this.dlM.setContinuePlayEnable(true);
            this.isn.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.ccn() && !c.this.isk && !c.this.hDm && c.this.Vt) {
                        if (!com.baidu.mcn.b.tJ().cF(c.this.isy.jump_url)) {
                            boolean z = ((long) i2) >= c.this.isy.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.isy.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.isy.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fNJ.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeW = c.this.isy.card_title;
                                    aVar.aeX = c.this.isy.button_title;
                                    aVar.aeY = c.this.isy.jump_url;
                                    aVar.aeV = c.this.isy.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.bVL;
                                    aVar.aeZ = c.this.buC();
                                    if (z2) {
                                        c.this.fNJ.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fNJ.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fNJ.isShowing()) {
                                c.this.fNJ.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.isz != null) {
                        c.this.isz.bE(i, i2);
                    }
                }
            });
            this.dlM.setBusiness(this.isn);
            this.dlM.setOnPreparedListener(this);
            this.dlM.setOnCompletionListener(this);
            this.dlM.setOnErrorListener(this);
            this.dlM.setOnSurfaceDestroyedListener(this);
            this.dlM.setOnOutInfoListener(this);
            this.irW.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.irW.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.irW.setAnimation(R.raw.lotti_video_loading);
            this.irW.setOnClickListener(this);
            this.isa.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.isa.setState(1);
            this.isa.setOnClickListener(this);
            this.gZu.setConrers(15);
            this.gZu.setRadius(l.g(this.mContext, R.dimen.tbds20));
            this.gZu.setDrawCorner(true);
            this.gZu.setDefaultBgResource(e.get());
            this.isc.setPlayer(this.dlM);
            this.isc.setOnSeekBarChangeListener(this.cWh);
            this.isb.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.isb.setState(0);
            this.isb.setOnClickListener(this);
            this.irX.setOnClickListener(this);
            this.irZ.setOnClickListener(this);
            this.isd.setPlayViewOnClickListener(this);
            this.isf.setOnClickListener(this);
            this.isi.setOnClickListener(null);
            this.isi.setOnTouchListener(this.clb);
            this.ise.setOnTouchListener(this.clb);
            this.mGestureDetector = new GestureDetector(this.mContext, this.isA);
            yv(this.irH);
            this.exn = new k();
            this.fNJ = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.adM() != null) {
            this.startPosition = -1L;
            if (this.fNJ != null) {
                this.fNJ.reset();
            }
            if (!ap.equals(this.bUZ, bgVar.adM().video_url)) {
                this.isk = bgVar.adM().is_vertical.intValue() == 1;
                this.bUZ = bgVar.adM().video_url;
                this.bVL = bgVar.getTid();
                this.isl = bgVar.adM().video_length.intValue();
                this.ism = bgVar.adM().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.isy = bgVar.adM().mcn_ad_card;
                ccc();
                ccb();
                yv(this.irH);
                int intValue = bgVar.adM().video_duration.intValue() * 1000;
                this.isc.yt(intValue);
                this.isc.setPlayer(this.dlM);
                this.eyW.setText(ap.im(intValue));
                this.eyX.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), ap.aN(bgVar.adM().play_count.intValue())));
                this.isd.setVideoLength(bgVar.adM().video_length.intValue());
                this.isd.setTid(this.bVL);
                this.isn.cbz().g(bgVar.adM());
                this.gZu.startLoad(bgVar.adM().thumbnail_url, 10, false);
                this.ise.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.isn != null) {
            this.isn.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v cbz() {
        if (this.isn == null) {
            return null;
        }
        return this.isn.cbz();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVi = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Xk = bdUniqueId;
    }

    public void ccf() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.irT);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.irT, this.irG);
    }

    public void ccg() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.irT);
    }

    private void startLoadingAnim() {
        if (this.irW != null) {
            this.irW.y(true);
            this.irW.setMinAndMaxFrame(14, 80);
            this.irW.bo();
        }
    }

    protected void ccd() {
        if (this.irQ == this.irJ) {
            yv(this.irI);
        }
    }

    private void cch() {
        if (this.irW != null) {
            this.irW.clearAnimation();
            this.irW.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.ccd();
                    if (c.this.isj) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.irW.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.isB);
        if (this.isd != null && this.isd.cco()) {
            yv(this.irN);
            return;
        }
        this.isj = true;
        if (!this.dlM.isPlaying()) {
            this.exn.bMl();
            this.dlM.setVideoPath(this.bUZ, this.bVL);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.isk ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).P("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.isj = false;
        if (this.irW != null) {
            this.irW.cancelAnimation();
        }
        this.dlM.stopPlayback();
        this.isc.aBP();
        yv(this.irH);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.isB);
    }

    public void yv(int i) {
        ccg();
        if (i == this.irJ) {
            if ("index".equals(this.mFrom)) {
                this.exn.a(this.bVL, this.isl, this.ism, "homepage", this.dlM);
            } else {
                this.exn.a(this.bVL, this.isl, this.ism, this.mFrom, this.dlM);
            }
        }
        if (this.irQ == this.irO) {
            this.irS = i;
            return;
        }
        this.irQ = i;
        this.gZu.setVisibility((i & 1) > 0 ? 0 : 8);
        this.irU.setVisibility((i & 2) > 0 ? 0 : 8);
        this.irV.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.irW.clearAnimation();
        this.irW.setVisibility(z ? 0 : 8);
        if (!z) {
            this.irW.setFrame(0);
            this.irW.cancelAnimation();
        } else {
            this.irW.setAlpha(1.0f);
        }
        this.irX.setVisibility((i & 8) > 0 ? 0 : 8);
        this.irZ.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eyX.setVisibility((i & 32) > 0 ? 0 : 8);
        this.eyW.setVisibility((i & 64) > 0 ? 0 : 8);
        this.isa.setVisibility((i & 128) > 0 ? 0 : 8);
        this.isb.setVisibility((i & 256) > 0 ? 0 : 8);
        this.isc.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.isc.getVisibility() == 0) {
            this.isc.showProgress();
        }
        this.isd.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.ise.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.ise.getVisibility() == 0) {
            this.ise.setAlpha(1.0f);
        }
        this.isf.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.isg.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cck();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                ccm();
            } else if (id == R.id.video_replay) {
                yv(this.irH);
                startPlay();
                TiebaStatic.log(new am("c13345").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.isk ? 1 : 2).P("obj_locate", this.hDm ? 1 : 2));
                cci();
            } else if (id == R.id.video_play) {
                if (this.irQ == this.irH) {
                    startPlay();
                } else {
                    yv(this.irK);
                    ccf();
                    this.dlM.start();
                }
                TiebaStatic.log(new am("c13344").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.isk ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hDm ? 1 : 2).P("obj_locate", 1));
                cci();
            } else if (id == R.id.video_pause) {
                yv(this.irL);
                ccg();
                this.dlM.pause();
                TiebaStatic.log(new am("c13344").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.isk ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hDm ? 1 : 2).P("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bUZ);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Xk);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dlM.setVolume(0.0f, 0.0f);
            this.isa.setState(1);
            return;
        }
        this.dlM.setVolume(1.0f, 1.0f);
        this.isa.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cck() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dlM.setVolume(1.0f, 1.0f);
            ad.a(this.bAG, true);
            this.isa.setState(0);
        } else {
            this.dlM.setVolume(0.0f, 0.0f);
            this.isa.setState(1);
            ad.a(this.bAG, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccl() {
        if (this.mRootView != null && this.isi != null && this.dlM != null) {
            this.dlM.setFullScreenToDestroySurface();
            if (this.ddO == null) {
                this.ddO = new o((Activity) this.mContext);
            }
            if (this.hDm) {
                if (!this.isk) {
                    this.ddO.bIl();
                }
                if (this.ish.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.ish.getParent()).removeView(this.ish);
                }
                if ((this.isi.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hDm = false;
                    ((ViewGroup) this.isi.getParent()).removeView(this.isi);
                    ((ViewGroup) this.mRootView).addView(this.isi);
                    h((Activity) this.mContext, this.hDm);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.isk) {
                        this.ddO.bIl();
                    }
                    if (this.mContext instanceof Activity) {
                        this.isi.getLocationOnScreen(this.isr);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.ish == null) {
                                    this.ish = new View(this.mContext);
                                    this.ish.setClickable(true);
                                    this.ish.setBackgroundColor(al.getColor(R.color.black_alpha100));
                                    this.ish.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.ish.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.ish.getParent()).removeView(this.ish);
                                }
                                this.ish.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.ish);
                                ((ViewGroup) childAt).addView(this.isi);
                                this.hDm = true;
                                h((Activity) this.mContext, this.hDm);
                                if (this.fNJ != null && this.fNJ.isShowing()) {
                                    this.fNJ.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bT("tid", this.bVL).l("fid", this.mFid).P("obj_type", this.isk ? 1 : 2));
            }
            ccc();
            ccb();
            if (this.dlM.isPlaying()) {
                yv(this.irI);
            } else {
                this.irQ |= 1;
                yv(this.irQ);
            }
            this.isb.cvi();
            li(this.hDm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.isk) {
            ccl();
        } else if (this.irQ == this.irO) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.isi.setScaleX(1.0f);
                    c.this.isi.setScaleY(1.0f);
                    c.this.isi.setTranslationX(0.0f);
                    c.this.isi.setTranslationY(0.0f);
                    c.this.ise.setScaleX(1.0f);
                    c.this.ise.setScaleY(1.0f);
                    c.this.isi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.ist) {
                        c.this.ccl();
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
            if (!this.ist) {
                float width = this.mRootView.getWidth() / this.isi.getWidth();
                float height = this.mRootView.getHeight() / this.isi.getHeight();
                this.isi.setPivotX(0.0f);
                this.isi.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.isi, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.isi, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.ise, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.ise, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.isi, "TranslationX", this.isi.getTranslationX(), this.isr[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.isi, "TranslationY", this.isi.getTranslationY(), this.isr[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.ish, "alpha", this.ish.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.ise, "alpha", this.ise.getAlpha(), 0.0f);
            } else {
                float width2 = this.isp / this.isi.getWidth();
                float height2 = this.iss / this.isi.getHeight();
                this.isi.setPivotX(0.0f);
                this.isi.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.isi, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.isi, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.ise, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.ise, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.isi, "TranslationX", this.isi.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.isi, "TranslationY", this.isi.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.ise, "alpha", this.ise.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.irS != -1) {
                this.irQ = this.irS;
                this.irS = -1;
                if (this.irQ == this.irP || this.irQ == this.irK || this.irQ == this.irI) {
                    this.dlM.start();
                    yv(this.irI);
                }
            }
        } else {
            ccl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bIk();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.isi.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void li(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        ccj();
        this.exn.bMm();
        if (this.isj) {
            if (this.hDm && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dlM.start();
            if (!this.dlM.getPlayer().isNewPlayer()) {
                yv(this.irJ);
                this.isc.showProgress();
                cch();
            }
        }
    }

    public void onCompletion(g gVar) {
        yv(this.irM);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.irQ == this.irL) {
            stopPlay();
            yv(this.irL);
        } else if (this.irQ == this.irM) {
            stopPlay();
            yv(this.irM);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            yv(this.irJ);
            this.isc.showProgress();
            cch();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View caY() {
        return this.isi;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.isj || this.dlM.isPlaying();
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
    public void cbZ() {
    }

    private void bIk() {
        if (Build.VERSION.SDK_INT < 16) {
            this.isi.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.isi.setSystemUiVisibility(4);
        } else {
            this.isi.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cca() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.dlM.isPlaying() && !ad.avx()) {
            this.dlM.setVolume(1.0f, 1.0f);
            this.isa.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean lh(boolean z) {
        if (z) {
            this.irW.cancelAnimation();
            if (this.irQ == this.irI || this.irQ == this.irJ || this.irQ == this.irK || this.irQ == this.irH) {
                stopPlay();
            }
            this.irQ |= 1;
            yv(this.irQ);
        } else if (this.irQ == this.irH) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hDm;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hDm) {
            ccm();
            return true;
        }
        return false;
    }

    protected int buC() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ccn() {
        return this.isy != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pS(boolean z) {
        this.Vt = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.isz = aVar;
    }
}
