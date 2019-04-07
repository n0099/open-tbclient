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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
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
    protected BdUniqueId Zr;
    private String bNn;
    private o cVq;
    protected String ctw;
    protected QuickVideoView dbf;
    protected k ehz;
    private TextView ejg;
    private TextView ejh;
    private com.baidu.mcn.c fwR;
    protected TbImageView gHW;
    protected boolean hZA;
    protected long hZB;
    protected long hZC;
    private n hZD;
    private float hZE;
    private float hZF;
    private int hZG;
    private int hZI;
    private boolean hZJ;
    private float hZM;
    private int hZN;
    private McnAdInfo hZO;
    private a hZP;
    private View hZk;
    private View hZl;
    private TBLottieAnimationView hZm;
    private ImageView hZn;
    private View hZo;
    private TextView hZp;
    protected SwitchImageView hZq;
    private SwitchImageView hZr;
    private OperableVideoMediaControllerView hZs;
    private OperableVideoNetworkStateTipView hZt;
    private OperableVideoShareView hZu;
    private ImageView hZv;
    private VideoGestureView hZw;
    private View hZx;
    protected ViewGroup hZy;
    protected boolean hZz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int hYW = 3000;
    protected int hYX = 103;
    protected int hYY = 0;
    protected int hYZ = 4;
    protected int hZa = 904;
    protected int hZb = 902;
    protected int hZc = 2066;
    protected int hZd = 1027;
    protected int hZe = CommandMessage.COMMAND_BASE;
    protected int hZf = 0;
    protected int hZg = this.hYX;
    private int hZh = 0;
    private int hZi = -1;
    private Runnable hZj = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xo(c.this.hYY);
        }
    };
    private WeakReference<Context> btD = null;
    private boolean hlI = false;
    private int[] hZH = new int[2];
    private int hZK = 0;
    private int hZL = 0;
    protected View.OnClickListener bNw = null;
    private boolean XB = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cNU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xo(c.this.hZa);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dbf.isPlaying()) {
                    c.this.dbf.start();
                }
                c.this.bUb();
                TiebaStatic.log(new am("c13355").bJ("tid", c.this.ctw).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZA ? 1 : 2).T("obj_locate", c.this.hlI ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hZQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dbf.isPlaying()) {
                c.this.dbf.pause();
                c.this.xo(c.this.hZb);
            } else if (c.this.hZg == c.this.hZb || c.this.hZg == (c.this.hZb | 1)) {
                c.this.dbf.start();
                c.this.xo(c.this.hZa);
                c.this.bUb();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.hZg == c.this.hYY || c.this.hZg == c.this.hYZ) {
                c.this.xo(c.this.hZa);
                c.this.bUb();
            } else if (c.this.hZg == c.this.hZa) {
                c.this.xo(c.this.hYY);
            } else if (c.this.hZg == c.this.hZb) {
                c.this.xo(c.this.hZa);
                c.this.bUb();
                c.this.dbf.start();
                TiebaStatic.log(new am("c13344").bJ("tid", c.this.ctw).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZA ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hlI ? 1 : 2).T("obj_locate", 1));
                c.this.bUe();
            } else {
                c.this.xo(c.this.hYX);
                c.this.startPlay();
                c.this.bUe();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.hZh = 0;
            if (c.this.hlI) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hlI) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.hZA) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.hZh) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dbf.isPlaying()) {
                                c.this.dbf.pause();
                                c.this.xo(c.this.hZf);
                            }
                            c.this.hZh = 4;
                            c.this.hZi = c.this.hZg;
                            c.this.hZg = c.this.hZe;
                            c.this.hZI = c.this.hZy.getMeasuredHeight();
                            c.this.hZM = c.this.hZF / c.this.hZI;
                            c.this.hZN = (int) (1.2f * c.this.mRootView.getWidth());
                            bZ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        bZ(rawX, rawY);
                        break;
                }
            } else if (c.this.hZg == c.this.hYY || c.this.hZg == c.this.hZa || c.this.hZg == c.this.hZb || c.this.hZg == c.this.hZe) {
                switch (c.this.hZh) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.hZh = 3;
                            c.this.hZG = c.this.dbf.getCurrentPosition();
                            aK(f);
                        } else if (motionEvent.getX() < c.this.hZE / 2.0f) {
                            c.this.hZh = 2;
                            c.this.hZw.n(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.hZh = 1;
                            c.this.hZw.m(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.hZg != c.this.hZe) {
                            c.this.xo(c.this.hZe);
                            break;
                        }
                        break;
                    case 1:
                        c.this.hZw.m(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.bTW();
                            break;
                        }
                        break;
                    case 2:
                        c.this.hZw.n(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aK(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void bZ(int i, int i2) {
            if (c.this.hZK != i2 || c.this.hZL != i) {
                c.this.hZJ = c.this.hZK - i2 > 0 || ((float) i2) < c.this.hZE / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.hZy.getLayoutParams();
                if (i2 != c.this.hZK) {
                    int i3 = c.this.hZI - i2;
                    int i4 = (int) (i3 * c.this.hZM);
                    if (i4 < c.this.hZN) {
                        i4 = c.this.hZN;
                        i3 = (int) (i4 / c.this.hZM);
                    }
                    if (i4 != c.this.hZN) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.hZy.setLayoutParams(layoutParams);
                    }
                    c.this.hZK = i2;
                    c.this.hZy.setTranslationY(c.this.hZK);
                }
                if (i != c.this.hZK) {
                    c.this.hZL = i;
                    c.this.hZy.setTranslationX(c.this.hZL + ((c.this.hZF - layoutParams.width) / 2.0f));
                }
                c.this.hZx.setAlpha((layoutParams.width - c.this.hZN) / (c.this.hZF - c.this.hZN));
                if (c.this.hZu.getVisibility() == 0) {
                    float f = c.this.hZE / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.hZu.setAlpha(f2);
                }
            }
        }

        private void aK(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.hZG += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.hZG += 1000;
                z = false;
            }
            int duration = c.this.dbf.getDuration();
            if (c.this.hZG < 0) {
                c.this.hZG = 0;
            } else if (c.this.hZG > duration) {
                c.this.hZG = duration;
            }
            String str = ap.hy(c.this.hZG) + "/" + ap.hy(duration);
            if (c.this.hZw != null) {
                c.this.hZw.x(z, str);
            }
            c.this.hZs.setCurrentDuration(c.this.hZG, false);
        }
    };
    private View.OnTouchListener ccW = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.hZg == c.this.hZe) {
                if (c.this.hZh == 4) {
                    c.this.bUi();
                    c.this.hZK = 0;
                    c.this.hZL = 0;
                } else {
                    c.this.hZg = -1;
                    if (c.this.hZh != 3) {
                        if (c.this.hZi != -1) {
                            c.this.xo(c.this.hZi);
                            c.this.hZi = -1;
                        } else if (c.this.dbf.isPlaying()) {
                            c.this.xo(c.this.hYY);
                        } else {
                            c.this.xo(c.this.hZb);
                        }
                    } else {
                        c.this.hZs.setCurrentDuration(c.this.hZG, true);
                        if (c.this.hZG < c.this.dbf.getDuration()) {
                            if (!c.this.dbf.isPlaying()) {
                                c.this.dbf.start();
                            }
                            c.this.xo(c.this.hYY);
                        }
                    }
                }
                String str = null;
                if (c.this.hZh != 1) {
                    if (c.this.hZh != 2) {
                        if (c.this.hZh == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!ap.isEmpty(str)) {
                    TiebaStatic.log(new am(str).bJ("tid", c.this.ctw).k(ImageViewerConfig.FORUM_ID, c.this.mFid));
                }
                c.this.hZh = 0;
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
    private final CustomMessageListener hZR = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bUf();
                    return;
                }
                c.this.dbf.setVolume(1.0f, 1.0f);
                c.this.hZq.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.hZE = l.aQ(this.mContext);
            this.hZF = l.aO(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return d.h.operable_video_container;
    }

    public void bTX() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.hZt.ad(this.hZA, this.hlI);
        this.hZu.ad(this.hZA, this.hlI);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hlI) {
                int dimension3 = (int) this.mContext.getResources().getDimension(d.e.tbds112);
                dimension2 = (int) this.mContext.getResources().getDimension(d.e.tbds44);
                i3 = (int) this.mContext.getResources().getDimension(d.e.tbds4);
                i2 = dimension2;
                i = dimension3;
                i5 = dimension2;
                i4 = dimension2;
            } else {
                int dimension4 = (int) this.mContext.getResources().getDimension(d.e.tbds97);
                int dimension5 = (int) this.mContext.getResources().getDimension(d.e.tbds32);
                if (this.hZA) {
                    dimension = (int) this.mContext.getResources().getDimension(d.e.tbds20);
                } else {
                    dimension = (int) this.mContext.getResources().getDimension(d.e.tbds32);
                }
                int dimension6 = (int) this.mContext.getResources().getDimension(d.e.tbds27);
                i = dimension4;
                i2 = dimension5;
                i3 = 0;
                int i6 = dimension;
                dimension2 = (int) this.mContext.getResources().getDimension(d.e.tbds38);
                i4 = dimension6;
                i5 = i6;
            }
            this.hZo.getLayoutParams().height = i;
            this.hZo.setPadding(0, 0, 0, i3);
            this.ejh.setPadding(0, 0, i2, 0);
            this.hZr.setPadding(this.hZr.getPaddingLeft(), 0, i5, 0);
            this.hZq.setPadding(i4, 0, this.hZq.getPaddingLeft(), 0);
            this.hZp.setPadding(dimension2, 0, this.hZq.getPaddingLeft(), 0);
        }
    }

    public void bTY() {
        if (this.hZA) {
            this.hZa = 392;
            this.hZb = 390;
        } else {
            this.hZa = 904;
            this.hZb = 902;
        }
        if (this.hlI) {
            this.hYX |= 4096;
            this.hYY |= 4096;
            this.hYZ |= 4096;
            this.hZa |= 4096;
            this.hZb |= 4096;
            this.hZc |= 4096;
            this.hZd |= 4096;
            this.hZg |= 4096;
            return;
        }
        this.hYX &= -4097;
        this.hYY &= -4097;
        this.hYZ &= -4097;
        this.hZa &= -4097;
        this.hZb &= -4097;
        this.hZc &= -4097;
        this.hZd &= -4097;
        this.hZg &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.hZy = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.hZy);
            }
            this.btD = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dbf = (QuickVideoView) this.hZy.findViewById(d.g.video_view);
            this.gHW = (TbImageView) this.hZy.findViewById(d.g.video_thumbnail);
            this.hZk = this.hZy.findViewById(d.g.black_mask_bottom);
            this.hZl = this.hZy.findViewById(d.g.black_mask_top);
            this.hZm = (TBLottieAnimationView) this.hZy.findViewById(d.g.video_play);
            this.hZo = this.hZy.findViewById(d.g.video_bottom_ctrl_layout);
            this.hZn = (ImageView) this.hZy.findViewById(d.g.video_pause);
            this.hZp = (TextView) this.hZy.findViewById(d.g.video_replay);
            this.ejh = (TextView) this.hZy.findViewById(d.g.video_play_count);
            this.ejg = (TextView) this.hZy.findViewById(d.g.video_duration);
            this.hZq = (SwitchImageView) this.hZy.findViewById(d.g.video_mute);
            this.hZr = (SwitchImageView) this.hZy.findViewById(d.g.video_full_screen);
            this.hZs = (OperableVideoMediaControllerView) this.hZy.findViewById(d.g.video_media_controller);
            this.hZt = (OperableVideoNetworkStateTipView) this.hZy.findViewById(d.g.video_network_state_tip);
            this.hZu = (OperableVideoShareView) this.hZy.findViewById(d.g.video_share_view);
            this.hZv = (ImageView) this.hZy.findViewById(d.g.video_full_screen_back);
            this.hZw = (VideoGestureView) this.hZy.findViewById(d.g.video_gesture);
            this.hZu.setVideoContainer(this);
            this.hZD = new n(this.mContext);
            this.dbf.setNeedRecovery(true);
            this.dbf.setPlayerReuseEnable(true);
            this.dbf.setContinuePlayEnable(true);
            this.hZD.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.bUj() && !c.this.hZA && !c.this.hlI && c.this.XB) {
                        if (!com.baidu.mcn.b.sX().cT(c.this.hZO.jump_url)) {
                            boolean z = ((long) i2) >= c.this.hZO.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.hZO.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.hZO.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fwR.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeP = c.this.hZO.card_title;
                                    aVar.aeQ = c.this.hZO.button_title;
                                    aVar.aeR = c.this.hZO.jump_url;
                                    aVar.aeO = c.this.hZO.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.ctw;
                                    aVar.aeS = c.this.bmX();
                                    if (z2) {
                                        c.this.fwR.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fwR.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fwR.isShowing()) {
                                c.this.fwR.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.hZP != null) {
                        c.this.hZP.bx(i, i2);
                    }
                }
            });
            this.dbf.setBusiness(this.hZD);
            this.dbf.setOnPreparedListener(this);
            this.dbf.setOnCompletionListener(this);
            this.dbf.setOnErrorListener(this);
            this.dbf.setOnSurfaceDestroyedListener(this);
            this.dbf.setOnOutInfoListener(this);
            this.hZm.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZm.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hZm.setAnimation(d.i.lotti_video_loading);
            this.hZm.setOnClickListener(this);
            this.hZq.setStateImage(d.f.icon_vedio_pronunciation_small_white, d.f.icon_vedio_npronunciation_small_white);
            this.hZq.setState(1);
            this.hZq.setOnClickListener(this);
            this.gHW.setConrers(15);
            this.gHW.setRadius(l.h(this.mContext, d.e.tbds20));
            this.gHW.setDrawCorner(true);
            this.gHW.setDefaultBgResource(e.get());
            this.hZs.setPlayer(this.dbf);
            this.hZs.setOnSeekBarChangeListener(this.cNU);
            this.hZr.setStateImage(d.f.icon_vedio_full_screen, d.f.icon_vedio_narrow_screen);
            this.hZr.setState(0);
            this.hZr.setOnClickListener(this);
            this.hZn.setOnClickListener(this);
            this.hZp.setOnClickListener(this);
            this.hZt.setPlayViewOnClickListener(this);
            this.hZv.setOnClickListener(this);
            this.hZy.setOnClickListener(null);
            this.hZy.setOnTouchListener(this.ccW);
            this.hZu.setOnTouchListener(this.ccW);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hZQ);
            xo(this.hYX);
            this.ehz = new k();
            this.fwR = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.Zf() != null) {
            this.startPosition = -1L;
            if (this.fwR != null) {
                this.fwR.reset();
            }
            if (!ap.equals(this.bNn, bgVar.Zf().video_url)) {
                this.hZA = bgVar.Zf().is_vertical.intValue() == 1;
                this.bNn = bgVar.Zf().video_url;
                this.ctw = bgVar.getTid();
                this.hZB = bgVar.Zf().video_length.intValue();
                this.hZC = bgVar.Zf().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.hZO = bgVar.Zf().mcn_ad_card;
                bTY();
                bTX();
                xo(this.hYX);
                int intValue = bgVar.Zf().video_duration.intValue() * 1000;
                this.hZs.xm(intValue);
                this.hZs.setPlayer(this.dbf);
                this.ejg.setText(ap.hy(intValue));
                this.ejh.setText(String.format(this.mContext.getResources().getString(d.j.play_count_new), ap.az(bgVar.Zf().play_count.intValue())));
                this.hZt.setVideoLength(bgVar.Zf().video_length.intValue());
                this.hZt.setTid(this.ctw);
                this.hZD.bTv().g(bgVar.Zf());
                this.gHW.startLoad(bgVar.Zf().thumbnail_url, 10, false);
                this.hZu.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.hZD != null) {
            this.hZD.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v bTv() {
        if (this.hZD == null) {
            return null;
        }
        return this.hZD.bTv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNw = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Zr = bdUniqueId;
    }

    public void bUb() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZj);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hZj, this.hYW);
    }

    public void bUc() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZj);
    }

    private void startLoadingAnim() {
        if (this.hZm != null) {
            this.hZm.G(true);
            this.hZm.setMinAndMaxFrame(14, 80);
            this.hZm.cu();
        }
    }

    protected void bTZ() {
        if (this.hZg == this.hYZ) {
            xo(this.hYY);
        }
    }

    private void bUd() {
        if (this.hZm != null) {
            this.hZm.clearAnimation();
            this.hZm.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.bTZ();
                    if (c.this.hZz) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZm.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.hZR);
        if (this.hZt != null && this.hZt.bUk()) {
            xo(this.hZd);
            return;
        }
        this.hZz = true;
        if (!this.dbf.isPlaying()) {
            this.ehz.bEx();
            this.dbf.setVideoPath(this.bNn, this.ctw);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bJ("tid", this.ctw).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZA ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).T("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.hZz = false;
        if (this.hZm != null) {
            this.hZm.cancelAnimation();
        }
        this.dbf.stopPlayback();
        this.hZs.awG();
        xo(this.hYX);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.hZR);
    }

    public void xo(int i) {
        bUc();
        if (i == this.hYZ) {
            if ("index".equals(this.mFrom)) {
                this.ehz.a(this.ctw, this.hZB, this.hZC, "homepage", this.dbf);
            } else {
                this.ehz.a(this.ctw, this.hZB, this.hZC, this.mFrom, this.dbf);
            }
        }
        if (this.hZg == this.hZe) {
            this.hZi = i;
            return;
        }
        this.hZg = i;
        this.gHW.setVisibility((i & 1) > 0 ? 0 : 8);
        this.hZk.setVisibility((i & 2) > 0 ? 0 : 8);
        this.hZl.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.hZm.clearAnimation();
        this.hZm.setVisibility(z ? 0 : 8);
        if (!z) {
            this.hZm.setFrame(0);
            this.hZm.cancelAnimation();
        } else {
            this.hZm.setAlpha(1.0f);
        }
        this.hZn.setVisibility((i & 8) > 0 ? 0 : 8);
        this.hZp.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ejh.setVisibility((i & 32) > 0 ? 0 : 8);
        this.ejg.setVisibility((i & 64) > 0 ? 0 : 8);
        this.hZq.setVisibility((i & 128) > 0 ? 0 : 8);
        this.hZr.setVisibility((i & 256) > 0 ? 0 : 8);
        this.hZs.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.hZs.getVisibility() == 0) {
            this.hZs.showProgress();
        }
        this.hZt.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.hZu.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.hZu.getVisibility() == 0) {
            this.hZu.setAlpha(1.0f);
        }
        this.hZv.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.hZw.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.video_mute) {
                bUg();
            } else if (id == d.g.video_full_screen || id == d.g.video_full_screen_back) {
                bUi();
            } else if (id == d.g.video_replay) {
                xo(this.hYX);
                startPlay();
                TiebaStatic.log(new am("c13345").bJ("tid", this.ctw).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZA ? 1 : 2).T("obj_locate", this.hlI ? 1 : 2));
                bUe();
            } else if (id == d.g.video_play) {
                if (this.hZg == this.hYX) {
                    startPlay();
                } else {
                    xo(this.hZa);
                    bUb();
                    this.dbf.start();
                }
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctw).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZA ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlI ? 1 : 2).T("obj_locate", 1));
                bUe();
            } else if (id == d.g.video_pause) {
                xo(this.hZb);
                bUc();
                this.dbf.pause();
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctw).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZA ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlI ? 1 : 2).T("obj_locate", 2));
            } else if (id == d.g.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUe() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bNn);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Zr);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbf.setVolume(0.0f, 0.0f);
            this.hZq.setState(1);
            return;
        }
        this.dbf.setVolume(1.0f, 1.0f);
        this.hZq.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUg() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dbf.setVolume(1.0f, 1.0f);
            ad.a(this.btD, true);
            this.hZq.setState(0);
        } else {
            this.dbf.setVolume(0.0f, 0.0f);
            this.hZq.setState(1);
            ad.a(this.btD, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUh() {
        if (this.mRootView != null && this.hZy != null && this.dbf != null) {
            this.dbf.setFullScreenToDestroySurface();
            if (this.cVq == null) {
                this.cVq = new o((Activity) this.mContext);
            }
            if (this.hlI) {
                if (!this.hZA) {
                    this.cVq.bAy();
                }
                if (this.hZx.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hZx.getParent()).removeView(this.hZx);
                }
                if ((this.hZy.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hlI = false;
                    ((ViewGroup) this.hZy.getParent()).removeView(this.hZy);
                    ((ViewGroup) this.mRootView).addView(this.hZy);
                    h((Activity) this.mContext, this.hlI);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.hZA) {
                        this.cVq.bAy();
                    }
                    if (this.mContext instanceof Activity) {
                        this.hZy.getLocationOnScreen(this.hZH);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.hZx == null) {
                                    this.hZx = new View(this.mContext);
                                    this.hZx.setClickable(true);
                                    this.hZx.setBackgroundColor(al.getColor(d.C0277d.black_alpha100));
                                    this.hZx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.hZx.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.hZx.getParent()).removeView(this.hZx);
                                }
                                this.hZx.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.hZx);
                                ((ViewGroup) childAt).addView(this.hZy);
                                this.hlI = true;
                                h((Activity) this.mContext, this.hlI);
                                if (this.fwR != null && this.fwR.isShowing()) {
                                    this.fwR.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bJ("tid", this.ctw).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZA ? 1 : 2));
            }
            bTY();
            bTX();
            if (this.dbf.isPlaying()) {
                xo(this.hYY);
            } else {
                this.hZg |= 1;
                xo(this.hZg);
            }
            this.hZr.cnd();
            ks(this.hlI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUi() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.hZA) {
            bUh();
        } else if (this.hZg == this.hZe) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.hZy.setScaleX(1.0f);
                    c.this.hZy.setScaleY(1.0f);
                    c.this.hZy.setTranslationX(0.0f);
                    c.this.hZy.setTranslationY(0.0f);
                    c.this.hZu.setScaleX(1.0f);
                    c.this.hZu.setScaleY(1.0f);
                    c.this.hZy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.hZJ) {
                        c.this.bUh();
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
            if (!this.hZJ) {
                float width = this.mRootView.getWidth() / this.hZy.getWidth();
                float height = this.mRootView.getHeight() / this.hZy.getHeight();
                this.hZy.setPivotX(0.0f);
                this.hZy.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZy, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZy, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZu, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZu, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZy, "TranslationX", this.hZy.getTranslationX(), this.hZH[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZy, "TranslationY", this.hZy.getTranslationY(), this.hZH[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.hZx, "alpha", this.hZx.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZu, "alpha", this.hZu.getAlpha(), 0.0f);
            } else {
                float width2 = this.hZF / this.hZy.getWidth();
                float height2 = this.hZI / this.hZy.getHeight();
                this.hZy.setPivotX(0.0f);
                this.hZy.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZy, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZy, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZu, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZu, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZy, "TranslationX", this.hZy.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZy, "TranslationY", this.hZy.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZu, "alpha", this.hZu.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.hZi != -1) {
                this.hZg = this.hZi;
                this.hZi = -1;
                if (this.hZg == this.hZf || this.hZg == this.hZa || this.hZg == this.hYY) {
                    this.dbf.start();
                    xo(this.hYY);
                }
            }
        } else {
            bUh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bAx();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.hZy.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        bUf();
        this.ehz.bEy();
        if (this.hZz) {
            if (this.hlI && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dbf.start();
            if (!this.dbf.getPlayer().isNewPlayer()) {
                xo(this.hYZ);
                this.hZs.showProgress();
                bUd();
            }
        }
    }

    public void onCompletion(g gVar) {
        xo(this.hZc);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.hZg == this.hZb) {
            stopPlay();
            xo(this.hZb);
        } else if (this.hZg == this.hZc) {
            stopPlay();
            xo(this.hZc);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            xo(this.hYZ);
            this.hZs.showProgress();
            bUd();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View bSV() {
        return this.hZy;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.hZz || this.dbf.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dbf.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTV() {
    }

    private void bAx() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZy.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZy.setSystemUiVisibility(4);
        } else {
            this.hZy.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTW() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbf.setVolume(1.0f, 1.0f);
            this.hZq.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (z) {
            this.hZm.cancelAnimation();
            if (this.hZg == this.hYY || this.hZg == this.hYZ || this.hZg == this.hZa || this.hZg == this.hYX) {
                stopPlay();
            }
            this.hZg |= 1;
            xo(this.hZg);
        } else if (this.hZg == this.hYX) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hlI;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hlI) {
            bUi();
            return true;
        }
        return false;
    }

    protected int bmX() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bUj() {
        return this.hZO != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pe(boolean z) {
        this.XB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.hZP = aVar;
    }
}
