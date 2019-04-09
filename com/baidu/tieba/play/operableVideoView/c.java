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
    protected BdUniqueId Zs;
    private String bNo;
    private o cVr;
    protected String ctx;
    protected QuickVideoView dbg;
    protected k ehA;
    private TextView ejh;
    private TextView eji;
    private com.baidu.mcn.c fwR;
    protected TbImageView gHX;
    protected boolean hZA;
    protected boolean hZB;
    protected long hZC;
    protected long hZD;
    private n hZE;
    private float hZF;
    private float hZG;
    private int hZH;
    private int hZJ;
    private boolean hZK;
    private float hZN;
    private int hZO;
    private McnAdInfo hZP;
    private a hZQ;
    private View hZl;
    private View hZm;
    private TBLottieAnimationView hZn;
    private ImageView hZo;
    private View hZp;
    private TextView hZq;
    protected SwitchImageView hZr;
    private SwitchImageView hZs;
    private OperableVideoMediaControllerView hZt;
    private OperableVideoNetworkStateTipView hZu;
    private OperableVideoShareView hZv;
    private ImageView hZw;
    private VideoGestureView hZx;
    private View hZy;
    protected ViewGroup hZz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int hYX = 3000;
    protected int hYY = 103;
    protected int hYZ = 0;
    protected int hZa = 4;
    protected int hZb = 904;
    protected int hZc = 902;
    protected int hZd = 2066;
    protected int hZe = 1027;
    protected int hZf = CommandMessage.COMMAND_BASE;
    protected int hZg = 0;
    protected int hZh = this.hYY;
    private int hZi = 0;
    private int hZj = -1;
    private Runnable hZk = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xo(c.this.hYZ);
        }
    };
    private WeakReference<Context> btE = null;
    private boolean hlJ = false;
    private int[] hZI = new int[2];
    private int hZL = 0;
    private int hZM = 0;
    protected View.OnClickListener bNx = null;
    private boolean XC = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cNV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xo(c.this.hZb);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dbg.isPlaying()) {
                    c.this.dbg.start();
                }
                c.this.bUb();
                TiebaStatic.log(new am("c13355").bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZB ? 1 : 2).T("obj_locate", c.this.hlJ ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hZR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dbg.isPlaying()) {
                c.this.dbg.pause();
                c.this.xo(c.this.hZc);
            } else if (c.this.hZh == c.this.hZc || c.this.hZh == (c.this.hZc | 1)) {
                c.this.dbg.start();
                c.this.xo(c.this.hZb);
                c.this.bUb();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.hZh == c.this.hYZ || c.this.hZh == c.this.hZa) {
                c.this.xo(c.this.hZb);
                c.this.bUb();
            } else if (c.this.hZh == c.this.hZb) {
                c.this.xo(c.this.hYZ);
            } else if (c.this.hZh == c.this.hZc) {
                c.this.xo(c.this.hZb);
                c.this.bUb();
                c.this.dbg.start();
                TiebaStatic.log(new am("c13344").bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZB ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hlJ ? 1 : 2).T("obj_locate", 1));
                c.this.bUe();
            } else {
                c.this.xo(c.this.hYY);
                c.this.startPlay();
                c.this.bUe();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.hZi = 0;
            if (c.this.hlJ) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hlJ) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.hZB) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.hZi) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dbg.isPlaying()) {
                                c.this.dbg.pause();
                                c.this.xo(c.this.hZg);
                            }
                            c.this.hZi = 4;
                            c.this.hZj = c.this.hZh;
                            c.this.hZh = c.this.hZf;
                            c.this.hZJ = c.this.hZz.getMeasuredHeight();
                            c.this.hZN = c.this.hZG / c.this.hZJ;
                            c.this.hZO = (int) (1.2f * c.this.mRootView.getWidth());
                            bZ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        bZ(rawX, rawY);
                        break;
                }
            } else if (c.this.hZh == c.this.hYZ || c.this.hZh == c.this.hZb || c.this.hZh == c.this.hZc || c.this.hZh == c.this.hZf) {
                switch (c.this.hZi) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.hZi = 3;
                            c.this.hZH = c.this.dbg.getCurrentPosition();
                            aK(f);
                        } else if (motionEvent.getX() < c.this.hZF / 2.0f) {
                            c.this.hZi = 2;
                            c.this.hZx.n(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.hZi = 1;
                            c.this.hZx.m(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.hZh != c.this.hZf) {
                            c.this.xo(c.this.hZf);
                            break;
                        }
                        break;
                    case 1:
                        c.this.hZx.m(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.bTW();
                            break;
                        }
                        break;
                    case 2:
                        c.this.hZx.n(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aK(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void bZ(int i, int i2) {
            if (c.this.hZL != i2 || c.this.hZM != i) {
                c.this.hZK = c.this.hZL - i2 > 0 || ((float) i2) < c.this.hZF / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.hZz.getLayoutParams();
                if (i2 != c.this.hZL) {
                    int i3 = c.this.hZJ - i2;
                    int i4 = (int) (i3 * c.this.hZN);
                    if (i4 < c.this.hZO) {
                        i4 = c.this.hZO;
                        i3 = (int) (i4 / c.this.hZN);
                    }
                    if (i4 != c.this.hZO) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.hZz.setLayoutParams(layoutParams);
                    }
                    c.this.hZL = i2;
                    c.this.hZz.setTranslationY(c.this.hZL);
                }
                if (i != c.this.hZL) {
                    c.this.hZM = i;
                    c.this.hZz.setTranslationX(c.this.hZM + ((c.this.hZG - layoutParams.width) / 2.0f));
                }
                c.this.hZy.setAlpha((layoutParams.width - c.this.hZO) / (c.this.hZG - c.this.hZO));
                if (c.this.hZv.getVisibility() == 0) {
                    float f = c.this.hZF / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.hZv.setAlpha(f2);
                }
            }
        }

        private void aK(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.hZH += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.hZH += 1000;
                z = false;
            }
            int duration = c.this.dbg.getDuration();
            if (c.this.hZH < 0) {
                c.this.hZH = 0;
            } else if (c.this.hZH > duration) {
                c.this.hZH = duration;
            }
            String str = ap.hy(c.this.hZH) + "/" + ap.hy(duration);
            if (c.this.hZx != null) {
                c.this.hZx.x(z, str);
            }
            c.this.hZt.setCurrentDuration(c.this.hZH, false);
        }
    };
    private View.OnTouchListener ccX = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.hZh == c.this.hZf) {
                if (c.this.hZi == 4) {
                    c.this.bUi();
                    c.this.hZL = 0;
                    c.this.hZM = 0;
                } else {
                    c.this.hZh = -1;
                    if (c.this.hZi != 3) {
                        if (c.this.hZj != -1) {
                            c.this.xo(c.this.hZj);
                            c.this.hZj = -1;
                        } else if (c.this.dbg.isPlaying()) {
                            c.this.xo(c.this.hYZ);
                        } else {
                            c.this.xo(c.this.hZc);
                        }
                    } else {
                        c.this.hZt.setCurrentDuration(c.this.hZH, true);
                        if (c.this.hZH < c.this.dbg.getDuration()) {
                            if (!c.this.dbg.isPlaying()) {
                                c.this.dbg.start();
                            }
                            c.this.xo(c.this.hYZ);
                        }
                    }
                }
                String str = null;
                if (c.this.hZi != 1) {
                    if (c.this.hZi != 2) {
                        if (c.this.hZi == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!ap.isEmpty(str)) {
                    TiebaStatic.log(new am(str).bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid));
                }
                c.this.hZi = 0;
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
    private final CustomMessageListener hZS = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bUf();
                    return;
                }
                c.this.dbg.setVolume(1.0f, 1.0f);
                c.this.hZr.setState(0);
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
            this.hZF = l.aQ(this.mContext);
            this.hZG = l.aO(this.mContext);
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
        this.hZu.ad(this.hZB, this.hlJ);
        this.hZv.ad(this.hZB, this.hlJ);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hlJ) {
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
                if (this.hZB) {
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
            this.hZp.getLayoutParams().height = i;
            this.hZp.setPadding(0, 0, 0, i3);
            this.eji.setPadding(0, 0, i2, 0);
            this.hZs.setPadding(this.hZs.getPaddingLeft(), 0, i5, 0);
            this.hZr.setPadding(i4, 0, this.hZr.getPaddingLeft(), 0);
            this.hZq.setPadding(dimension2, 0, this.hZr.getPaddingLeft(), 0);
        }
    }

    public void bTY() {
        if (this.hZB) {
            this.hZb = 392;
            this.hZc = 390;
        } else {
            this.hZb = 904;
            this.hZc = 902;
        }
        if (this.hlJ) {
            this.hYY |= 4096;
            this.hYZ |= 4096;
            this.hZa |= 4096;
            this.hZb |= 4096;
            this.hZc |= 4096;
            this.hZd |= 4096;
            this.hZe |= 4096;
            this.hZh |= 4096;
            return;
        }
        this.hYY &= -4097;
        this.hYZ &= -4097;
        this.hZa &= -4097;
        this.hZb &= -4097;
        this.hZc &= -4097;
        this.hZd &= -4097;
        this.hZe &= -4097;
        this.hZh &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.hZz = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.hZz);
            }
            this.btE = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dbg = (QuickVideoView) this.hZz.findViewById(d.g.video_view);
            this.gHX = (TbImageView) this.hZz.findViewById(d.g.video_thumbnail);
            this.hZl = this.hZz.findViewById(d.g.black_mask_bottom);
            this.hZm = this.hZz.findViewById(d.g.black_mask_top);
            this.hZn = (TBLottieAnimationView) this.hZz.findViewById(d.g.video_play);
            this.hZp = this.hZz.findViewById(d.g.video_bottom_ctrl_layout);
            this.hZo = (ImageView) this.hZz.findViewById(d.g.video_pause);
            this.hZq = (TextView) this.hZz.findViewById(d.g.video_replay);
            this.eji = (TextView) this.hZz.findViewById(d.g.video_play_count);
            this.ejh = (TextView) this.hZz.findViewById(d.g.video_duration);
            this.hZr = (SwitchImageView) this.hZz.findViewById(d.g.video_mute);
            this.hZs = (SwitchImageView) this.hZz.findViewById(d.g.video_full_screen);
            this.hZt = (OperableVideoMediaControllerView) this.hZz.findViewById(d.g.video_media_controller);
            this.hZu = (OperableVideoNetworkStateTipView) this.hZz.findViewById(d.g.video_network_state_tip);
            this.hZv = (OperableVideoShareView) this.hZz.findViewById(d.g.video_share_view);
            this.hZw = (ImageView) this.hZz.findViewById(d.g.video_full_screen_back);
            this.hZx = (VideoGestureView) this.hZz.findViewById(d.g.video_gesture);
            this.hZv.setVideoContainer(this);
            this.hZE = new n(this.mContext);
            this.dbg.setNeedRecovery(true);
            this.dbg.setPlayerReuseEnable(true);
            this.dbg.setContinuePlayEnable(true);
            this.hZE.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.bUj() && !c.this.hZB && !c.this.hlJ && c.this.XC) {
                        if (!com.baidu.mcn.b.sX().cT(c.this.hZP.jump_url)) {
                            boolean z = ((long) i2) >= c.this.hZP.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.hZP.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.hZP.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fwR.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeQ = c.this.hZP.card_title;
                                    aVar.aeR = c.this.hZP.button_title;
                                    aVar.aeS = c.this.hZP.jump_url;
                                    aVar.aeP = c.this.hZP.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.ctx;
                                    aVar.aeT = c.this.bmX();
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
                    if (c.this.hZQ != null) {
                        c.this.hZQ.bx(i, i2);
                    }
                }
            });
            this.dbg.setBusiness(this.hZE);
            this.dbg.setOnPreparedListener(this);
            this.dbg.setOnCompletionListener(this);
            this.dbg.setOnErrorListener(this);
            this.dbg.setOnSurfaceDestroyedListener(this);
            this.dbg.setOnOutInfoListener(this);
            this.hZn.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZn.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hZn.setAnimation(d.i.lotti_video_loading);
            this.hZn.setOnClickListener(this);
            this.hZr.setStateImage(d.f.icon_vedio_pronunciation_small_white, d.f.icon_vedio_npronunciation_small_white);
            this.hZr.setState(1);
            this.hZr.setOnClickListener(this);
            this.gHX.setConrers(15);
            this.gHX.setRadius(l.h(this.mContext, d.e.tbds20));
            this.gHX.setDrawCorner(true);
            this.gHX.setDefaultBgResource(e.get());
            this.hZt.setPlayer(this.dbg);
            this.hZt.setOnSeekBarChangeListener(this.cNV);
            this.hZs.setStateImage(d.f.icon_vedio_full_screen, d.f.icon_vedio_narrow_screen);
            this.hZs.setState(0);
            this.hZs.setOnClickListener(this);
            this.hZo.setOnClickListener(this);
            this.hZq.setOnClickListener(this);
            this.hZu.setPlayViewOnClickListener(this);
            this.hZw.setOnClickListener(this);
            this.hZz.setOnClickListener(null);
            this.hZz.setOnTouchListener(this.ccX);
            this.hZv.setOnTouchListener(this.ccX);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hZR);
            xo(this.hYY);
            this.ehA = new k();
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
            if (!ap.equals(this.bNo, bgVar.Zf().video_url)) {
                this.hZB = bgVar.Zf().is_vertical.intValue() == 1;
                this.bNo = bgVar.Zf().video_url;
                this.ctx = bgVar.getTid();
                this.hZC = bgVar.Zf().video_length.intValue();
                this.hZD = bgVar.Zf().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.hZP = bgVar.Zf().mcn_ad_card;
                bTY();
                bTX();
                xo(this.hYY);
                int intValue = bgVar.Zf().video_duration.intValue() * 1000;
                this.hZt.xm(intValue);
                this.hZt.setPlayer(this.dbg);
                this.ejh.setText(ap.hy(intValue));
                this.eji.setText(String.format(this.mContext.getResources().getString(d.j.play_count_new), ap.az(bgVar.Zf().play_count.intValue())));
                this.hZu.setVideoLength(bgVar.Zf().video_length.intValue());
                this.hZu.setTid(this.ctx);
                this.hZE.bTv().g(bgVar.Zf());
                this.gHX.startLoad(bgVar.Zf().thumbnail_url, 10, false);
                this.hZv.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.hZE != null) {
            this.hZE.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v bTv() {
        if (this.hZE == null) {
            return null;
        }
        return this.hZE.bTv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNx = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Zs = bdUniqueId;
    }

    public void bUb() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZk);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hZk, this.hYX);
    }

    public void bUc() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZk);
    }

    private void startLoadingAnim() {
        if (this.hZn != null) {
            this.hZn.G(true);
            this.hZn.setMinAndMaxFrame(14, 80);
            this.hZn.cu();
        }
    }

    protected void bTZ() {
        if (this.hZh == this.hZa) {
            xo(this.hYZ);
        }
    }

    private void bUd() {
        if (this.hZn != null) {
            this.hZn.clearAnimation();
            this.hZn.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.bTZ();
                    if (c.this.hZA) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZn.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.hZS);
        if (this.hZu != null && this.hZu.bUk()) {
            xo(this.hZe);
            return;
        }
        this.hZA = true;
        if (!this.dbg.isPlaying()) {
            this.ehA.bEx();
            this.dbg.setVideoPath(this.bNo, this.ctx);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZB ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).T("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.hZA = false;
        if (this.hZn != null) {
            this.hZn.cancelAnimation();
        }
        this.dbg.stopPlayback();
        this.hZt.awG();
        xo(this.hYY);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.hZS);
    }

    public void xo(int i) {
        bUc();
        if (i == this.hZa) {
            if ("index".equals(this.mFrom)) {
                this.ehA.a(this.ctx, this.hZC, this.hZD, "homepage", this.dbg);
            } else {
                this.ehA.a(this.ctx, this.hZC, this.hZD, this.mFrom, this.dbg);
            }
        }
        if (this.hZh == this.hZf) {
            this.hZj = i;
            return;
        }
        this.hZh = i;
        this.gHX.setVisibility((i & 1) > 0 ? 0 : 8);
        this.hZl.setVisibility((i & 2) > 0 ? 0 : 8);
        this.hZm.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.hZn.clearAnimation();
        this.hZn.setVisibility(z ? 0 : 8);
        if (!z) {
            this.hZn.setFrame(0);
            this.hZn.cancelAnimation();
        } else {
            this.hZn.setAlpha(1.0f);
        }
        this.hZo.setVisibility((i & 8) > 0 ? 0 : 8);
        this.hZq.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eji.setVisibility((i & 32) > 0 ? 0 : 8);
        this.ejh.setVisibility((i & 64) > 0 ? 0 : 8);
        this.hZr.setVisibility((i & 128) > 0 ? 0 : 8);
        this.hZs.setVisibility((i & 256) > 0 ? 0 : 8);
        this.hZt.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.hZt.getVisibility() == 0) {
            this.hZt.showProgress();
        }
        this.hZu.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.hZv.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.hZv.getVisibility() == 0) {
            this.hZv.setAlpha(1.0f);
        }
        this.hZw.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.hZx.setVisibility((i & 8192) <= 0 ? 8 : 0);
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
                xo(this.hYY);
                startPlay();
                TiebaStatic.log(new am("c13345").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZB ? 1 : 2).T("obj_locate", this.hlJ ? 1 : 2));
                bUe();
            } else if (id == d.g.video_play) {
                if (this.hZh == this.hYY) {
                    startPlay();
                } else {
                    xo(this.hZb);
                    bUb();
                    this.dbg.start();
                }
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZB ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlJ ? 1 : 2).T("obj_locate", 1));
                bUe();
            } else if (id == d.g.video_pause) {
                xo(this.hZc);
                bUc();
                this.dbg.pause();
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZB ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlJ ? 1 : 2).T("obj_locate", 2));
            } else if (id == d.g.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUe() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bNo);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Zs);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbg.setVolume(0.0f, 0.0f);
            this.hZr.setState(1);
            return;
        }
        this.dbg.setVolume(1.0f, 1.0f);
        this.hZr.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUg() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.btE, true);
            this.hZr.setState(0);
        } else {
            this.dbg.setVolume(0.0f, 0.0f);
            this.hZr.setState(1);
            ad.a(this.btE, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUh() {
        if (this.mRootView != null && this.hZz != null && this.dbg != null) {
            this.dbg.setFullScreenToDestroySurface();
            if (this.cVr == null) {
                this.cVr = new o((Activity) this.mContext);
            }
            if (this.hlJ) {
                if (!this.hZB) {
                    this.cVr.bAy();
                }
                if (this.hZy.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hZy.getParent()).removeView(this.hZy);
                }
                if ((this.hZz.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hlJ = false;
                    ((ViewGroup) this.hZz.getParent()).removeView(this.hZz);
                    ((ViewGroup) this.mRootView).addView(this.hZz);
                    h((Activity) this.mContext, this.hlJ);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.hZB) {
                        this.cVr.bAy();
                    }
                    if (this.mContext instanceof Activity) {
                        this.hZz.getLocationOnScreen(this.hZI);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.hZy == null) {
                                    this.hZy = new View(this.mContext);
                                    this.hZy.setClickable(true);
                                    this.hZy.setBackgroundColor(al.getColor(d.C0277d.black_alpha100));
                                    this.hZy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.hZy.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.hZy.getParent()).removeView(this.hZy);
                                }
                                this.hZy.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.hZy);
                                ((ViewGroup) childAt).addView(this.hZz);
                                this.hlJ = true;
                                h((Activity) this.mContext, this.hlJ);
                                if (this.fwR != null && this.fwR.isShowing()) {
                                    this.fwR.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZB ? 1 : 2));
            }
            bTY();
            bTX();
            if (this.dbg.isPlaying()) {
                xo(this.hYZ);
            } else {
                this.hZh |= 1;
                xo(this.hZh);
            }
            this.hZs.cnd();
            ks(this.hlJ);
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
        if (!this.hZB) {
            bUh();
        } else if (this.hZh == this.hZf) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.hZz.setScaleX(1.0f);
                    c.this.hZz.setScaleY(1.0f);
                    c.this.hZz.setTranslationX(0.0f);
                    c.this.hZz.setTranslationY(0.0f);
                    c.this.hZv.setScaleX(1.0f);
                    c.this.hZv.setScaleY(1.0f);
                    c.this.hZz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.hZK) {
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
            if (!this.hZK) {
                float width = this.mRootView.getWidth() / this.hZz.getWidth();
                float height = this.mRootView.getHeight() / this.hZz.getHeight();
                this.hZz.setPivotX(0.0f);
                this.hZz.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZz, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZz, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZv, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZv, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZz, "TranslationX", this.hZz.getTranslationX(), this.hZI[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZz, "TranslationY", this.hZz.getTranslationY(), this.hZI[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.hZy, "alpha", this.hZy.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZv, "alpha", this.hZv.getAlpha(), 0.0f);
            } else {
                float width2 = this.hZG / this.hZz.getWidth();
                float height2 = this.hZJ / this.hZz.getHeight();
                this.hZz.setPivotX(0.0f);
                this.hZz.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZz, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZz, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZv, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZv, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZz, "TranslationX", this.hZz.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZz, "TranslationY", this.hZz.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZv, "alpha", this.hZv.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.hZj != -1) {
                this.hZh = this.hZj;
                this.hZj = -1;
                if (this.hZh == this.hZg || this.hZh == this.hZb || this.hZh == this.hYZ) {
                    this.dbg.start();
                    xo(this.hYZ);
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
            this.hZz.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        bUf();
        this.ehA.bEy();
        if (this.hZA) {
            if (this.hlJ && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dbg.start();
            if (!this.dbg.getPlayer().isNewPlayer()) {
                xo(this.hZa);
                this.hZt.showProgress();
                bUd();
            }
        }
    }

    public void onCompletion(g gVar) {
        xo(this.hZd);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.hZh == this.hZc) {
            stopPlay();
            xo(this.hZc);
        } else if (this.hZh == this.hZd) {
            stopPlay();
            xo(this.hZd);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            xo(this.hZa);
            this.hZt.showProgress();
            bUd();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View bSV() {
        return this.hZz;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.hZA || this.dbg.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dbg.getCurrentPosition();
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
            this.hZz.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZz.setSystemUiVisibility(4);
        } else {
            this.hZz.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTW() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbg.setVolume(1.0f, 1.0f);
            this.hZr.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (z) {
            this.hZn.cancelAnimation();
            if (this.hZh == this.hYZ || this.hZh == this.hZa || this.hZh == this.hZb || this.hZh == this.hYY) {
                stopPlay();
            }
            this.hZh |= 1;
            xo(this.hZh);
        } else if (this.hZh == this.hYY) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hlJ;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hlJ) {
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
        return this.hZP != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pe(boolean z) {
        this.XC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.hZQ = aVar;
    }
}
