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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    protected BdUniqueId XE;
    protected String bWO;
    private String bWb;
    private o dft;
    protected QuickVideoView dnu;
    protected k eCm;
    private TextView eDT;
    private TextView eDU;
    private com.baidu.mcn.c fSI;
    protected TbImageView hfH;
    protected ViewGroup iyA;
    protected boolean iyB;
    protected boolean iyC;
    protected long iyD;
    protected long iyE;
    private n iyF;
    private float iyG;
    private float iyH;
    private int iyI;
    private int iyK;
    private boolean iyL;
    private float iyO;
    private int iyP;
    private McnAdInfo iyQ;
    private a iyR;
    private View iym;
    private View iyn;
    private TBLottieAnimationView iyo;
    private ImageView iyp;
    private View iyq;
    private TextView iyr;
    protected SwitchImageView iys;
    private SwitchImageView iyt;
    private OperableVideoMediaControllerView iyu;
    private OperableVideoNetworkStateTipView iyv;
    private OperableVideoShareView iyw;
    private ImageView iyx;
    private VideoGestureView iyy;
    private View iyz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int ixY = 3000;
    protected int ixZ = 103;
    protected int iya = 0;
    protected int iyb = 4;
    protected int iyc = 904;
    protected int iyd = 902;
    protected int iye = 2066;
    protected int iyf = 1027;
    protected int iyg = CommandMessage.COMMAND_BASE;
    protected int iyh = 0;
    protected int iyi = this.ixZ;
    private int iyj = 0;
    private int iyk = -1;
    private Runnable iyl = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.za(c.this.iya);
        }
    };
    private WeakReference<Context> bBD = null;
    private boolean hJA = false;
    private int[] iyJ = new int[2];
    private int iyM = 0;
    private int iyN = 0;
    protected View.OnClickListener bWk = null;
    private boolean VM = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cXE = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.za(c.this.iyc);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dnu.isPlaying()) {
                    c.this.dnu.start();
                }
                c.this.ceW();
                TiebaStatic.log(new an("c13355").bT("tid", c.this.bWO).l("fid", c.this.mFid).P("obj_type", c.this.iyC ? 1 : 2).P("obj_locate", c.this.hJA ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iyS = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dnu.isPlaying()) {
                c.this.dnu.pause();
                c.this.za(c.this.iyd);
            } else if (c.this.iyi == c.this.iyd || c.this.iyi == (c.this.iyd | 1)) {
                c.this.dnu.start();
                c.this.za(c.this.iyc);
                c.this.ceW();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.iyi == c.this.iya || c.this.iyi == c.this.iyb) {
                c.this.za(c.this.iyc);
                c.this.ceW();
            } else if (c.this.iyi == c.this.iyc) {
                c.this.za(c.this.iya);
            } else if (c.this.iyi == c.this.iyd) {
                c.this.za(c.this.iyc);
                c.this.ceW();
                c.this.dnu.start();
                TiebaStatic.log(new an("c13344").bT("tid", c.this.bWO).l("fid", c.this.mFid).P("obj_type", c.this.iyC ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hJA ? 1 : 2).P("obj_locate", 1));
                c.this.ceZ();
            } else {
                c.this.za(c.this.ixZ);
                c.this.startPlay();
                c.this.ceZ();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.iyj = 0;
            if (c.this.hJA) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hJA) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.iyC) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.iyj) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dnu.isPlaying()) {
                                c.this.dnu.pause();
                                c.this.za(c.this.iyh);
                            }
                            c.this.iyj = 4;
                            c.this.iyk = c.this.iyi;
                            c.this.iyi = c.this.iyg;
                            c.this.iyK = c.this.iyA.getMeasuredHeight();
                            c.this.iyO = c.this.iyH / c.this.iyK;
                            c.this.iyP = (int) (1.2f * c.this.mRootView.getWidth());
                            cm(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cm(rawX, rawY);
                        break;
                }
            } else if (c.this.iyi == c.this.iya || c.this.iyi == c.this.iyc || c.this.iyi == c.this.iyd || c.this.iyi == c.this.iyg) {
                switch (c.this.iyj) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.iyj = 3;
                            c.this.iyI = c.this.dnu.getCurrentPosition();
                            aP(f);
                        } else if (motionEvent.getX() < c.this.iyG / 2.0f) {
                            c.this.iyj = 2;
                            c.this.iyy.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.iyj = 1;
                            c.this.iyy.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.iyi != c.this.iyg) {
                            c.this.za(c.this.iyg);
                            break;
                        }
                        break;
                    case 1:
                        c.this.iyy.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.ceR();
                            break;
                        }
                        break;
                    case 2:
                        c.this.iyy.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aP(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cm(int i, int i2) {
            if (c.this.iyM != i2 || c.this.iyN != i) {
                c.this.iyL = c.this.iyM - i2 > 0 || ((float) i2) < c.this.iyG / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.iyA.getLayoutParams();
                if (i2 != c.this.iyM) {
                    int i3 = c.this.iyK - i2;
                    int i4 = (int) (i3 * c.this.iyO);
                    if (i4 < c.this.iyP) {
                        i4 = c.this.iyP;
                        i3 = (int) (i4 / c.this.iyO);
                    }
                    if (i4 != c.this.iyP) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.iyA.setLayoutParams(layoutParams);
                    }
                    c.this.iyM = i2;
                    c.this.iyA.setTranslationY(c.this.iyM);
                }
                if (i != c.this.iyM) {
                    c.this.iyN = i;
                    c.this.iyA.setTranslationX(c.this.iyN + ((c.this.iyH - layoutParams.width) / 2.0f));
                }
                c.this.iyz.setAlpha((layoutParams.width - c.this.iyP) / (c.this.iyH - c.this.iyP));
                if (c.this.iyw.getVisibility() == 0) {
                    float f = c.this.iyG / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.iyw.setAlpha(f2);
                }
            }
        }

        private void aP(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.iyI += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.iyI += 1000;
                z = false;
            }
            int duration = c.this.dnu.getDuration();
            if (c.this.iyI < 0) {
                c.this.iyI = 0;
            } else if (c.this.iyI > duration) {
                c.this.iyI = duration;
            }
            String str = aq.is(c.this.iyI) + "/" + aq.is(duration);
            if (c.this.iyy != null) {
                c.this.iyy.x(z, str);
            }
            c.this.iyu.setCurrentDuration(c.this.iyI, false);
        }
    };
    private View.OnTouchListener cmp = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.iyi == c.this.iyg) {
                if (c.this.iyj == 4) {
                    c.this.cfd();
                    c.this.iyM = 0;
                    c.this.iyN = 0;
                } else {
                    c.this.iyi = -1;
                    if (c.this.iyj != 3) {
                        if (c.this.iyk != -1) {
                            c.this.za(c.this.iyk);
                            c.this.iyk = -1;
                        } else if (c.this.dnu.isPlaying()) {
                            c.this.za(c.this.iya);
                        } else {
                            c.this.za(c.this.iyd);
                        }
                    } else {
                        c.this.iyu.setCurrentDuration(c.this.iyI, true);
                        if (c.this.iyI < c.this.dnu.getDuration()) {
                            if (!c.this.dnu.isPlaying()) {
                                c.this.dnu.start();
                            }
                            c.this.za(c.this.iya);
                        }
                    }
                }
                String str = null;
                if (c.this.iyj != 1) {
                    if (c.this.iyj != 2) {
                        if (c.this.iyj == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!aq.isEmpty(str)) {
                    TiebaStatic.log(new an(str).bT("tid", c.this.bWO).l("fid", c.this.mFid));
                }
                c.this.iyj = 0;
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
    private final CustomMessageListener iyT = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cfa();
                    return;
                }
                if (c.this.isPlaying()) {
                    ad.a(c.this.bBD, true);
                }
                c.this.dnu.setVolume(1.0f, 1.0f);
                c.this.iys.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bK(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.iyG = l.ah(this.mContext);
            this.iyH = l.af(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ceS() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.iyv.ah(this.iyC, this.hJA);
        this.iyw.ah(this.iyC, this.hJA);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hJA) {
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
                if (this.iyC) {
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
            this.iyq.getLayoutParams().height = i;
            this.iyq.setPadding(0, 0, 0, i3);
            this.eDU.setPadding(0, 0, i2, 0);
            this.iyt.setPadding(this.iyt.getPaddingLeft(), 0, i5, 0);
            this.iys.setPadding(i4, 0, this.iys.getPaddingLeft(), 0);
            this.iyr.setPadding(dimension2, 0, this.iys.getPaddingLeft(), 0);
        }
    }

    public void ceT() {
        if (this.iyC) {
            this.iyc = 392;
            this.iyd = 390;
        } else {
            this.iyc = 904;
            this.iyd = 902;
        }
        if (this.hJA) {
            this.ixZ |= 4096;
            this.iya |= 4096;
            this.iyb |= 4096;
            this.iyc |= 4096;
            this.iyd |= 4096;
            this.iye |= 4096;
            this.iyf |= 4096;
            this.iyi |= 4096;
            return;
        }
        this.ixZ &= -4097;
        this.iya &= -4097;
        this.iyb &= -4097;
        this.iyc &= -4097;
        this.iyd &= -4097;
        this.iye &= -4097;
        this.iyf &= -4097;
        this.iyi &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.iyA = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.iyA);
            }
            this.bBD = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dnu = (QuickVideoView) this.iyA.findViewById(R.id.video_view);
            this.hfH = (TbImageView) this.iyA.findViewById(R.id.video_thumbnail);
            this.iym = this.iyA.findViewById(R.id.black_mask_bottom);
            this.iyn = this.iyA.findViewById(R.id.black_mask_top);
            this.iyo = (TBLottieAnimationView) this.iyA.findViewById(R.id.video_play);
            this.iyq = this.iyA.findViewById(R.id.video_bottom_ctrl_layout);
            this.iyp = (ImageView) this.iyA.findViewById(R.id.video_pause);
            this.iyr = (TextView) this.iyA.findViewById(R.id.video_replay);
            this.eDU = (TextView) this.iyA.findViewById(R.id.video_play_count);
            this.eDT = (TextView) this.iyA.findViewById(R.id.video_duration);
            this.iys = (SwitchImageView) this.iyA.findViewById(R.id.video_mute);
            this.iyt = (SwitchImageView) this.iyA.findViewById(R.id.video_full_screen);
            this.iyu = (OperableVideoMediaControllerView) this.iyA.findViewById(R.id.video_media_controller);
            this.iyv = (OperableVideoNetworkStateTipView) this.iyA.findViewById(R.id.video_network_state_tip);
            this.iyw = (OperableVideoShareView) this.iyA.findViewById(R.id.video_share_view);
            this.iyx = (ImageView) this.iyA.findViewById(R.id.video_full_screen_back);
            this.iyy = (VideoGestureView) this.iyA.findViewById(R.id.video_gesture);
            this.iyw.setVideoContainer(this);
            this.iyF = new n(this.mContext);
            this.dnu.setNeedRecovery(true);
            this.dnu.setPlayerReuseEnable(true);
            this.dnu.setContinuePlayEnable(true);
            this.iyF.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cfe() && !c.this.iyC && !c.this.hJA && c.this.VM) {
                        if (!com.baidu.mcn.b.uj().cJ(c.this.iyQ.jump_url)) {
                            boolean z = ((long) i2) >= c.this.iyQ.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.iyQ.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.iyQ.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fSI.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aft = c.this.iyQ.card_title;
                                    aVar.afu = c.this.iyQ.button_title;
                                    aVar.afv = c.this.iyQ.jump_url;
                                    aVar.afs = c.this.iyQ.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.bWO;
                                    aVar.afw = c.this.bxh();
                                    if (z2) {
                                        c.this.fSI.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fSI.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fSI.isShowing()) {
                                c.this.fSI.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.iyR != null) {
                        c.this.iyR.bK(i, i2);
                    }
                }
            });
            this.dnu.setBusiness(this.iyF);
            this.dnu.setOnPreparedListener(this);
            this.dnu.setOnCompletionListener(this);
            this.dnu.setOnErrorListener(this);
            this.dnu.setOnSurfaceDestroyedListener(this);
            this.dnu.setOnOutInfoListener(this);
            this.iyo.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.iyo.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.iyo.setAnimation(R.raw.lotti_video_loading);
            this.iyo.setOnClickListener(this);
            this.iys.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.iys.setState(1);
            this.iys.setOnClickListener(this);
            this.hfH.setConrers(15);
            this.hfH.setRadius(l.g(this.mContext, R.dimen.tbds20));
            this.hfH.setDrawCorner(true);
            this.hfH.setDefaultBgResource(e.Qr());
            this.iyu.setPlayer(this.dnu);
            this.iyu.setOnSeekBarChangeListener(this.cXE);
            this.iyt.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.iyt.setState(0);
            this.iyt.setOnClickListener(this);
            this.iyp.setOnClickListener(this);
            this.iyr.setOnClickListener(this);
            this.iyv.setPlayViewOnClickListener(this);
            this.iyx.setOnClickListener(this);
            this.iyA.setOnClickListener(null);
            this.iyA.setOnTouchListener(this.cmp);
            this.iyw.setOnTouchListener(this.cmp);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iyS);
            za(this.ixZ);
            this.eCm = new k();
            this.fSI = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.aeO() != null) {
            this.startPosition = -1L;
            if (this.fSI != null) {
                this.fSI.reset();
            }
            if (!aq.bV(this.bWb, bgVar.aeO().video_url)) {
                this.iyC = bgVar.aeO().is_vertical.intValue() == 1;
                this.bWb = bgVar.aeO().video_url;
                this.bWO = bgVar.getTid();
                this.iyD = bgVar.aeO().video_length.intValue();
                this.iyE = bgVar.aeO().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.iyQ = bgVar.aeO().mcn_ad_card;
                ceT();
                ceS();
                za(this.ixZ);
                int intValue = bgVar.aeO().video_duration.intValue() * 1000;
                this.iyu.yY(intValue);
                this.iyu.setPlayer(this.dnu);
                this.eDT.setText(aq.is(intValue));
                this.eDU.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.aO(bgVar.aeO().play_count.intValue())));
                this.iyv.setVideoLength(bgVar.aeO().video_length.intValue());
                this.iyv.setTid(this.bWO);
                this.iyF.ceq().g(bgVar.aeO());
                this.hfH.startLoad(bgVar.aeO().thumbnail_url, 10, false);
                this.iyw.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.iyF != null) {
            this.iyF.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v ceq() {
        if (this.iyF == null) {
            return null;
        }
        return this.iyF.ceq();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWk = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.XE = bdUniqueId;
    }

    public void ceW() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyl);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iyl, this.ixY);
    }

    public void ceX() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyl);
    }

    private void startLoadingAnim() {
        if (this.iyo != null) {
            this.iyo.y(true);
            this.iyo.setMinAndMaxFrame(14, 80);
            this.iyo.br();
        }
    }

    protected void ceU() {
        if (this.iyi == this.iyb) {
            za(this.iya);
        }
    }

    private void ceY() {
        if (this.iyo != null) {
            this.iyo.clearAnimation();
            this.iyo.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.ceU();
                    if (c.this.iyB) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.iyo.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.iyT);
        if (this.iyv != null && this.iyv.cff()) {
            za(this.iyf);
            return;
        }
        this.iyB = true;
        if (!this.dnu.isPlaying()) {
            this.eCm.bOU();
            this.dnu.setVideoPath(this.bWb, this.bWO);
            startLoadingAnim();
            TiebaStatic.log(new an("c13357").bT("tid", this.bWO).l("fid", this.mFid).P("obj_type", this.iyC ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).P("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.iyB = false;
        if (this.iyo != null) {
            this.iyo.cancelAnimation();
        }
        this.dnu.ceg();
        this.iyu.aDe();
        za(this.ixZ);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iyT);
    }

    public void za(int i) {
        ceX();
        if (i == this.iyb) {
            if ("index".equals(this.mFrom)) {
                this.eCm.a(this.bWO, this.iyD, this.iyE, "homepage", this.dnu);
            } else {
                this.eCm.a(this.bWO, this.iyD, this.iyE, this.mFrom, this.dnu);
            }
        }
        if (this.iyi == this.iyg) {
            this.iyk = i;
            return;
        }
        this.iyi = i;
        this.hfH.setVisibility((i & 1) > 0 ? 0 : 8);
        this.iym.setVisibility((i & 2) > 0 ? 0 : 8);
        this.iyn.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.iyo.clearAnimation();
        this.iyo.setVisibility(z ? 0 : 8);
        if (!z) {
            this.iyo.setFrame(0);
            this.iyo.cancelAnimation();
        } else {
            this.iyo.setAlpha(1.0f);
        }
        this.iyp.setVisibility((i & 8) > 0 ? 0 : 8);
        this.iyr.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eDU.setVisibility((i & 32) > 0 ? 0 : 8);
        this.eDT.setVisibility((i & 64) > 0 ? 0 : 8);
        this.iys.setVisibility((i & 128) > 0 ? 0 : 8);
        this.iyt.setVisibility((i & 256) > 0 ? 0 : 8);
        this.iyu.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.iyu.getVisibility() == 0) {
            this.iyu.showProgress();
        }
        this.iyv.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.iyw.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.iyw.getVisibility() == 0) {
            this.iyw.setAlpha(1.0f);
        }
        this.iyx.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.iyy.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cfb();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cfd();
            } else if (id == R.id.video_replay) {
                za(this.ixZ);
                startPlay();
                TiebaStatic.log(new an("c13345").bT("tid", this.bWO).l("fid", this.mFid).P("obj_type", this.iyC ? 1 : 2).P("obj_locate", this.hJA ? 1 : 2));
                ceZ();
            } else if (id == R.id.video_play) {
                if (this.iyi == this.ixZ) {
                    startPlay();
                } else {
                    za(this.iyc);
                    ceW();
                    this.dnu.start();
                }
                TiebaStatic.log(new an("c13344").bT("tid", this.bWO).l("fid", this.mFid).P("obj_type", this.iyC ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hJA ? 1 : 2).P("obj_locate", 1));
                ceZ();
            } else if (id == R.id.video_pause) {
                za(this.iyd);
                ceX();
                this.dnu.pause();
                TiebaStatic.log(new an("c13344").bT("tid", this.bWO).l("fid", this.mFid).P("obj_type", this.iyC ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hJA ? 1 : 2).P("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceZ() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bWb);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.XE);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dnu.setVolume(0.0f, 0.0f);
            this.iys.setState(1);
            return;
        }
        this.dnu.setVolume(1.0f, 1.0f);
        this.iys.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cfb() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dnu.setVolume(1.0f, 1.0f);
            ad.a(this.bBD, true);
            this.iys.setState(0);
        } else {
            this.dnu.setVolume(0.0f, 0.0f);
            this.iys.setState(1);
            ad.a(this.bBD, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cfc() {
        if (this.mRootView != null && this.iyA != null && this.dnu != null) {
            this.dnu.setFullScreenToDestroySurface();
            if (this.dft == null) {
                this.dft = new o((Activity) this.mContext);
            }
            if (this.hJA) {
                if (!this.iyC) {
                    this.dft.bKT();
                }
                if (this.iyz.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.iyz.getParent()).removeView(this.iyz);
                }
                if ((this.iyA.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hJA = false;
                    ((ViewGroup) this.iyA.getParent()).removeView(this.iyA);
                    ((ViewGroup) this.mRootView).addView(this.iyA);
                    h((Activity) this.mContext, this.hJA);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.iyC) {
                        this.dft.bKT();
                    }
                    if (this.mContext instanceof Activity) {
                        this.iyA.getLocationOnScreen(this.iyJ);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.iyz == null) {
                                    this.iyz = new View(this.mContext);
                                    this.iyz.setClickable(true);
                                    this.iyz.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.iyz.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.iyz.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.iyz.getParent()).removeView(this.iyz);
                                }
                                this.iyz.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.iyz);
                                ((ViewGroup) childAt).addView(this.iyA);
                                this.hJA = true;
                                h((Activity) this.mContext, this.hJA);
                                if (this.fSI != null && this.fSI.isShowing()) {
                                    this.fSI.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new an("c13360").bT("tid", this.bWO).l("fid", this.mFid).P("obj_type", this.iyC ? 1 : 2));
            }
            ceT();
            ceS();
            if (this.dnu.isPlaying()) {
                za(this.iya);
            } else {
                this.iyi |= 1;
                za(this.iyi);
            }
            this.iyt.cxX();
            lv(this.hJA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfd() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.iyC) {
            cfc();
        } else if (this.iyi == this.iyg) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.iyA.setScaleX(1.0f);
                    c.this.iyA.setScaleY(1.0f);
                    c.this.iyA.setTranslationX(0.0f);
                    c.this.iyA.setTranslationY(0.0f);
                    c.this.iyw.setScaleX(1.0f);
                    c.this.iyw.setScaleY(1.0f);
                    c.this.iyA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.iyL) {
                        c.this.cfc();
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
            if (!this.iyL) {
                float width = this.mRootView.getWidth() / this.iyA.getWidth();
                float height = this.mRootView.getHeight() / this.iyA.getHeight();
                this.iyA.setPivotX(0.0f);
                this.iyA.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.iyA, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.iyA, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.iyw, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.iyw, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.iyA, "TranslationX", this.iyA.getTranslationX(), this.iyJ[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.iyA, "TranslationY", this.iyA.getTranslationY(), this.iyJ[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.iyz, "alpha", this.iyz.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.iyw, "alpha", this.iyw.getAlpha(), 0.0f);
            } else {
                float width2 = this.iyH / this.iyA.getWidth();
                float height2 = this.iyK / this.iyA.getHeight();
                this.iyA.setPivotX(0.0f);
                this.iyA.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.iyA, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.iyA, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.iyw, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.iyw, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.iyA, "TranslationX", this.iyA.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.iyA, "TranslationY", this.iyA.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.iyw, "alpha", this.iyw.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.iyk != -1) {
                this.iyi = this.iyk;
                this.iyk = -1;
                if (this.iyi == this.iyh || this.iyi == this.iyc || this.iyi == this.iya) {
                    this.dnu.start();
                    za(this.iya);
                }
            }
        } else {
            cfc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bKS();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.iyA.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lv(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cfa();
        this.eCm.bOV();
        if (this.iyB) {
            if (this.hJA && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dnu.start();
            if (!this.dnu.getPlayer().isNewPlayer()) {
                za(this.iyb);
                this.iyu.showProgress();
                ceY();
            }
        }
    }

    public void onCompletion(g gVar) {
        za(this.iye);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.iyi == this.iyd) {
            stopPlay();
            za(this.iyd);
        } else if (this.iyi == this.iye) {
            stopPlay();
            za(this.iye);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            za(this.iyb);
            this.iyu.showProgress();
            ceY();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cdO() {
        return this.iyA;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.iyB || this.dnu.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dnu.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ceQ() {
    }

    private void bKS() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iyA.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iyA.setSystemUiVisibility(4);
        } else {
            this.iyA.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ceR() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.dnu.isPlaying() && !ad.awG()) {
            this.dnu.setVolume(1.0f, 1.0f);
            this.iys.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean lu(boolean z) {
        if (z) {
            this.iyo.cancelAnimation();
            if (this.iyi == this.iya || this.iyi == this.iyb || this.iyi == this.iyc || this.iyi == this.ixZ) {
                stopPlay();
            }
            this.iyi |= 1;
            za(this.iyi);
        } else if (this.iyi == this.ixZ) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hJA;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hJA) {
            cfd();
            return true;
        }
        return false;
    }

    protected int bxh() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cfe() {
        return this.iyQ != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh(boolean z) {
        this.VM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.iyR = aVar;
    }
}
