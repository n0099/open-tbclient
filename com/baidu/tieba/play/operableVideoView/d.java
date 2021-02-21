package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.play.operableVideoView.a {
    protected BdUniqueId agC;
    private String aje;
    protected boolean amB;
    protected String amC;
    protected long amD;
    protected TbImageView ams;
    private ImageView amu;
    private ImageView amv;
    protected TextView amw;
    protected TextView amx;
    private TextView amy;
    protected TbCyberVideoView gAl;
    private com.baidu.mcn.c jMK;
    private j ldA;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private TBLottieAnimationView mJY;
    private PercentSizeView mJZ;
    private View mJt;
    private McnAdInfo mKA;
    private a mKB;
    protected SwitchImageView mKa;
    protected SwitchImageView mKb;
    protected OperableVideoMediaControllerView mKc;
    protected OperableVideoNetworkStateTipView mKd;
    protected OperableVideoShareView mKe;
    protected ImageView mKf;
    protected View mKg;
    protected VideoGestureView mKh;
    private View mKi;
    private OperableVideoErrorView mKj;
    protected ViewGroup mKk;
    protected boolean mKl;
    protected int mKm;
    protected o mKn;
    protected cb mKo;
    private float mKq;
    private float mKr;
    private int mKs;
    private int mKu;
    private boolean mKv;
    private float mKy;
    private int mKz;
    private View mRootView;
    protected String mVideoUrl;
    protected int mJx = 3000;
    protected final int mJy = 1;
    protected final int mJz = 2;
    protected final int mJA = 4;
    protected final int mJB = 8;
    protected final int mJC = 16;
    protected final int mJD = 32;
    protected final int mJE = 64;
    protected final int mJF = 128;
    protected final int mJG = 256;
    protected final int mJH = 512;
    protected final int mJI = 1024;
    protected final int mJJ = 2048;
    protected final int mJK = 4096;
    protected final int mJL = 8192;
    protected int mJM = 8211;
    protected int mJN = 0;
    protected int mJO = 4;
    protected int mJP = 232;
    protected int mJQ = 8416;
    protected int mJR = 0;
    protected int mJS = 513;
    protected int mJT = 259;
    protected int mJU = 2048;
    protected int mJV = 0;
    protected int STATE_ERROR = 4099;
    protected int mViewState = this.mJM;
    private int mkG = 0;
    private int mJW = -1;
    private Runnable mJX = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Gy(d.this.mJN);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lNc = false;
    protected boolean mKp = true;
    private boolean isChangingOrientation = false;
    private int[] mKt = new int[2];
    private int mKw = 0;
    private int mKx = 0;
    protected View.OnClickListener ajT = null;
    protected View.OnClickListener agk = null;
    private boolean agu = false;
    private long startPosition = -1;
    private f.b mKC = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void cf(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dAV() && !d.this.amB && !d.this.lNc && d.this.agu) {
                if (!com.baidu.mcn.b.abr().iY(d.this.mKA.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mKA.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mKA.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mKA.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jMK.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.chJ = d.this.mKA.card_title;
                            aVar.chK = d.this.mKA.button_title;
                            aVar.chL = d.this.mKA.jump_url;
                            aVar.chI = d.this.mKA.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.amC;
                            aVar.chM = d.this.cRX();
                            if (z2) {
                                d.this.jMK.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jMK.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jMK.isShowing()) {
                        d.this.jMK.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mKB != null) {
                d.this.mKB.cH(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener ghW = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Gy(d.this.mJP);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gAl.isPlaying()) {
                    d.this.gAl.a(d.this.mKD);
                }
                d.this.dAM();
                if (d.this.mKp) {
                    TiebaStatic.log(new ar("c13355").dR("tid", d.this.amC).v("fid", d.this.mFid).ap("obj_type", d.this.amB ? 1 : 2).ap("obj_locate", d.this.lNc ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jsN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gAl.isPlaying()) {
                d.this.gAl.pause();
                if (d.this.mViewState == d.this.mJP) {
                    d.this.Gy(d.this.mJQ);
                } else {
                    d.this.Gy(d.this.mJR);
                }
                d.this.Gz(R.id.video_pause);
            } else if (d.this.mViewState == d.this.mJQ || d.this.mViewState == (d.this.mJQ | 1)) {
                d.this.Gy(d.this.mJP);
                d.this.dAM();
                d.this.gAl.a(d.this.mKD);
                d.this.Gz(R.id.video_play);
            } else if (d.this.mViewState == d.this.mJR || d.this.mViewState == (d.this.mJR | 1)) {
                d.this.Gy(d.this.mJN);
                d.this.gAl.a(d.this.mKD);
                d.this.Gz(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gAl.isPlaying()) {
                if (d.this.mViewState == d.this.mJN || d.this.mViewState == d.this.mJO) {
                    d.this.Gy(d.this.mJP);
                    d.this.dAM();
                    return true;
                } else if (d.this.mViewState == d.this.mJP) {
                    d.this.Gy(d.this.mJN);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mViewState == d.this.mJQ) {
                d.this.Gy(d.this.mJR);
                return true;
            } else if (d.this.mViewState == (d.this.mJQ | 1)) {
                d.this.Gy(d.this.mJR | 1);
                return true;
            } else if (d.this.mViewState == d.this.mJR) {
                d.this.Gy(d.this.mJQ);
                return true;
            } else if (d.this.mViewState == (d.this.mJR | 1)) {
                d.this.Gy(d.this.mJQ | 1);
                return true;
            } else {
                d.this.Gy(d.this.mJM);
                d.this.startPlay();
                d.this.dAQ();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.mkG = 0;
            if (d.this.lNc) {
                d.this.k((Activity) d.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!d.this.ac(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if ((d.this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.mContext).disableSwipeJustOnce();
            } else if ((d.this.mContext instanceof BaseActivity) && ((BaseActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseActivity) d.this.mContext).disableSwipeJustOnce();
            }
            if (d.this.amB && d.this.dvs()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.mkG) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gAl.isPlaying()) {
                                d.this.gAl.pause();
                                d.this.Gy(d.this.mJV);
                            }
                            d.this.mkG = 4;
                            d.this.mJW = d.this.mViewState;
                            d.this.mViewState = d.this.mJU;
                            d.this.mKu = d.this.mKk.getMeasuredHeight();
                            d.this.mKy = d.this.mKr / d.this.mKu;
                            d.this.mKz = (int) (1.2f * d.this.mRootView.getWidth());
                            dg(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dg(rawX, rawY);
                        break;
                }
            } else if (d.this.mViewState == d.this.mJN || d.this.mViewState == d.this.mJP || d.this.mViewState == d.this.mJQ || d.this.mViewState == d.this.mJR || d.this.mViewState == d.this.mJU || d.this.mViewState == (d.this.mJQ | 1) || d.this.mViewState == (d.this.mJR | 1)) {
                switch (d.this.mkG) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.mkG = 3;
                            d.this.mKs = d.this.gAl.getCurrentPosition();
                            aY(f);
                        } else if (motionEvent.getX() < d.this.mKk.getWidth() / 2) {
                            d.this.mkG = 2;
                            d.this.mKh.v(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.mkG = 1;
                            d.this.mKh.u(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mViewState != d.this.mJU) {
                            if ((d.this.mViewState & 1) > 0) {
                                d.this.mJU |= 1;
                            } else {
                                d.this.mJU &= -2;
                            }
                            d.this.Gy(d.this.mJU);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mKh.u(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dvw();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mKh.v(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aY(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dg(int i, int i2) {
            if (d.this.mKw != i2 || d.this.mKx != i) {
                d.this.mKv = d.this.mKw - i2 > 0 || ((float) i2) < d.this.mKq / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mKk.getLayoutParams();
                if (i2 != d.this.mKw) {
                    int i3 = d.this.mKu - i2;
                    int i4 = (int) (i3 * d.this.mKy);
                    if (i4 < d.this.mKz) {
                        i4 = d.this.mKz;
                        i3 = (int) (i4 / d.this.mKy);
                    }
                    if (i4 != d.this.mKz) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mKk.setLayoutParams(layoutParams);
                    }
                    d.this.mKw = i2;
                    d.this.mKk.setTranslationY(d.this.mKw);
                }
                if (i != d.this.mKw) {
                    d.this.mKx = i;
                    d.this.mKk.setTranslationX(d.this.mKx + ((d.this.mKr - layoutParams.width) / 2.0f));
                }
                d.this.mKi.setAlpha((layoutParams.width - d.this.mKz) / (d.this.mKr - d.this.mKz));
                if (d.this.mKe.getVisibility() == 0) {
                    float f = d.this.mKq / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mKe.setAlpha(f2);
                }
            }
        }

        private void aY(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mKs -= 1000;
                z = true;
            } else {
                d.this.mKs += 1000;
                z = false;
            }
            int duration = d.this.gAl.getDuration();
            if (d.this.mKs < 0) {
                d.this.mKs = 0;
            } else if (d.this.mKs > duration) {
                d.this.mKs = duration;
            }
            String str = au.stringForVideoTime(d.this.mKs) + " / " + au.stringForVideoTime(duration);
            if (d.this.mKh != null) {
                d.this.mKh.L(z, str);
            }
            d.this.mKc.setCurrentDuration(d.this.mKs, false);
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mViewState == d.this.mJU) {
                if (d.this.mkG == 4) {
                    d.this.dAT();
                    d.this.mKw = 0;
                    d.this.mKx = 0;
                } else {
                    d.this.mViewState = -1;
                    if (d.this.mkG != 3) {
                        if (d.this.mJW != -1) {
                            d.this.Gy(d.this.mJW);
                            d.this.mJW = -1;
                        } else if (d.this.gAl.isPlaying()) {
                            d.this.Gy(d.this.mJN);
                        } else {
                            d.this.Gy(d.this.mJQ);
                        }
                    } else {
                        d.this.mKc.setCurrentDuration(d.this.mKs, true);
                        if (d.this.mKs <= d.this.gAl.getDuration()) {
                            if (!d.this.gAl.isPlaying()) {
                                d.this.gAl.a(d.this.mKD);
                            }
                            d.this.Gy(d.this.mJN);
                        }
                    }
                }
                if (d.this.mKp) {
                    String str = null;
                    if (d.this.mkG != 1) {
                        if (d.this.mkG != 2) {
                            if (d.this.mkG == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!au.isEmpty(str)) {
                        TiebaStatic.log(new ar(str).dR("tid", d.this.amC).v("fid", d.this.mFid));
                    }
                }
                d.this.mkG = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mKD = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dAC() {
            d.this.gAl.dAy();
            d.this.dAL();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dAD() {
            d.this.Gy(d.this.mJM);
            d.this.bQA();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cH(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.mKq = l.getEquipmentHeight(this.mContext);
            this.mKr = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dvu() {
        int i;
        int i2;
        int i3;
        this.mKd.au(this.amB, this.lNc);
        this.mKe.au(this.amB, this.lNc);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.amB) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
                i3 = dimension;
            } else if (this.lNc) {
                int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension2;
                i2 = dimension2;
                i3 = dimension2;
            } else {
                int dimension3 = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension3;
                i2 = dimension3;
                i3 = dimension3;
            }
            this.amw.setPadding(0, 0, i3, 0);
            this.mKb.setPadding(this.mKb.getPaddingLeft(), 0, i2, 0);
            this.mKa.setPadding(i, 0, 0, 0);
        }
    }

    public void dvt() {
        if (this.amB) {
            this.mJP = 104;
            this.mJQ = 8290;
        } else {
            this.mJP = 232;
            this.mJQ = 8418;
        }
        if (this.lNc) {
            this.mJM |= 1024;
            this.mJN |= 1024;
            this.mJO |= 1024;
            this.mJP |= 1024;
            this.mJQ |= 1024;
            this.mJR |= 1024;
            this.mJS |= 1024;
            this.mJT |= 1024;
            this.mViewState |= 1024;
            return;
        }
        this.mJM &= -1025;
        this.mJN &= -1025;
        this.mJO &= -1025;
        this.mJP &= -1025;
        this.mJQ &= -1025;
        this.mJR &= -1025;
        this.mJS &= -1025;
        this.mJT &= -1025;
        this.mViewState &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mKk = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mKk);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ams = (TbImageView) this.mKk.findViewById(R.id.video_thumbnail);
            this.mJt = this.mKk.findViewById(R.id.black_mask);
            this.mJY = (TBLottieAnimationView) this.mKk.findViewById(R.id.video_loading);
            this.amu = (ImageView) this.mKk.findViewById(R.id.video_play);
            this.mJZ = (PercentSizeView) this.mKk.findViewById(R.id.video_media_controller_mask);
            this.amv = (ImageView) this.mKk.findViewById(R.id.video_pause);
            this.amw = (TextView) this.mKk.findViewById(R.id.video_play_count);
            this.amx = (TextView) this.mKk.findViewById(R.id.video_play_flag);
            this.amy = (TextView) this.mKk.findViewById(R.id.video_duration);
            this.mKa = (SwitchImageView) this.mKk.findViewById(R.id.video_mute);
            this.mKb = (SwitchImageView) this.mKk.findViewById(R.id.video_full_screen);
            this.mKc = (OperableVideoMediaControllerView) this.mKk.findViewById(R.id.video_media_controller);
            this.mKd = (OperableVideoNetworkStateTipView) this.mKk.findViewById(R.id.video_network_state_tip);
            this.mKe = (OperableVideoShareView) this.mKk.findViewById(R.id.video_share_view);
            this.mKg = this.mKk.findViewById(R.id.video_back_btn_mask);
            this.mKf = (ImageView) this.mKk.findViewById(R.id.video_full_screen_back);
            this.mKh = (VideoGestureView) this.mKk.findViewById(R.id.video_gesture);
            this.mKj = (OperableVideoErrorView) this.mKk.findViewById(R.id.video_error_layout);
            this.mKe.setVideoContainer(this);
            this.mJY.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mJY.setVisibility(8);
                    d.this.amu.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mJY.setAnimation(R.raw.lotti_video_loading);
            this.amu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amu.setOnClickListener(this);
            this.mKa.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mKa.setState(1);
            this.mKa.setOnClickListener(this);
            this.ams.bGo();
            this.ams.setDrawCorner(false);
            this.ams.setPlaceHolder(3);
            com.baidu.tbadk.a.b.b.m(this.mJt, R.color.CAM_X0607);
            this.mKc.setOnSeekBarChangeListener(this.ghW);
            this.mJZ.setHeightPercent(0.583f);
            this.mJZ.setBackgroundResource(R.drawable.video_mask_bg);
            this.mKb.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mKb.setState(0);
            this.mKb.setOnClickListener(this);
            this.amv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amv.setOnClickListener(this);
            this.mKf.setOnClickListener(this);
            this.gAl = new TbCyberVideoView(this.mContext);
            this.gAl.setTryUseViewInSet(true);
            dAL();
            this.mKd.setPlayViewOnClickListener(this);
            this.mKk.setOnClickListener(null);
            this.mKk.setOnTouchListener(this.bST);
            this.mKe.setOnTouchListener(this.bST);
            this.mKj.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jsN);
            Gy(this.mJM);
            this.jMK = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dAL() {
        if (this.gAl != null && this.gAl.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mKk.addView(this.gAl.getView(), 0);
            this.gAl.getView().setLayoutParams(layoutParams);
            this.mKc.setPlayer(this.gAl);
            this.gAl.setContinuePlayEnable(true);
            this.gAl.setOnPreparedListener(this);
            this.gAl.setOnCompletionListener(this);
            this.gAl.setOnErrorListener(this);
            this.gAl.setOnSurfaceDestroyedListener(this);
            this.gAl.setOnInfoListener(this);
            this.gAl.setVideoStatData(this.mKn);
            this.gAl.setThreadDataForStatistic(this.mKo);
            this.gAl.getMediaProgressObserver().a(this.mKC);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boh() != null) {
            this.startPosition = -1L;
            if (this.jMK != null) {
                this.jMK.reset();
            }
            if (!au.equals(this.mVideoUrl, cbVar.boh().video_url)) {
                stopPlay();
                this.amB = cbVar.boh().is_vertical.intValue() == 1;
                this.mVideoUrl = cbVar.boh().video_url;
                this.amC = cbVar.getTid();
                this.amD = cbVar.boh().video_length.intValue();
                this.mKm = cbVar.boh().video_duration.intValue();
                this.mFid = cbVar.getFid();
                this.mKA = cbVar.boh().mcn_ad_card;
                dvt();
                dvu();
                Gy(this.mJM);
                int intValue = cbVar.boh().video_duration.intValue() * 1000;
                this.mKc.Hp(intValue);
                this.mKc.setPlayer(this.gAl);
                this.amy.setText(au.stringForVideoTime(intValue));
                this.amw.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(cbVar.boh().play_count.intValue())));
                this.mKd.setVideoLength(cbVar.boh().video_length.intValue());
                this.mKd.setVideoDuration(cbVar.boh().video_duration.intValue());
                this.mKd.setTid(this.amC);
                this.mKo = cbVar;
                this.gAl.setThreadDataForStatistic(cbVar);
                this.amx.setVisibility(8);
                this.ams.setPlaceHolder(3);
                this.ams.startLoad(cbVar.boh().thumbnail_url, 10, false);
                this.mKe.setShareData(cbVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gAl != null) {
            this.mKn = oVar;
            this.gAl.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ae(View.OnClickListener onClickListener) {
        this.agk = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Hr(int i) {
        this.gAl.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    public void dAM() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJX);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mJX, this.mJx);
    }

    public void dAN() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQA() {
        this.mJY.setAlpha(1.0f);
        this.mJY.setVisibility(0);
        this.amu.setVisibility(8);
        if (this.mJY != null) {
            this.mJY.loop(true);
            this.mJY.setMinAndMaxFrame(14, 80);
            this.mJY.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvr() {
        if (this.mViewState == this.mJO) {
            Gy(this.mJN);
        }
    }

    private void dAO() {
        Gy(this.mJO);
        this.mKc.showProgress();
        if (this.mJY != null) {
            this.mJY.clearAnimation();
            this.mJY.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dvr();
                    if (!d.this.mKl) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mJY.setVisibility(8);
                    d.this.amu.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dAP() {
        return this.mKd != null && this.mKd.dvB();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aje = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dAP()) {
                Gy(this.mJT);
                return;
            }
            this.mKl = true;
            if (!this.gAl.isPlaying()) {
                TbCyberVideoView QG = TbVideoViewSet.dAB().QG(this.mVideoUrl);
                if (QG == null) {
                    this.gAl.dAy();
                    if (!StringUtils.isNull(this.gAl.getOriginUrl())) {
                        this.gAl = new TbCyberVideoView(this.mContext);
                        this.gAl.setTryUseViewInSet(true);
                    }
                    dAL();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gAl.setVideoDuration(this.mKm);
                        this.gAl.setVideoPath(this.mVideoUrl, this.amC);
                        this.gAl.setStageType(this.aje);
                        bQA();
                        if (this.mKp) {
                            dvz();
                        }
                    }
                } else {
                    if (this.gAl == QG) {
                        if (this.gAl.getParent() == null || this.gAl.getParent() != QG.getParent()) {
                            this.gAl.dAy();
                            dAL();
                        }
                    } else {
                        this.gAl.dAy();
                        QG.dAy();
                        this.gAl = QG;
                        this.gAl.setTryUseViewInSet(true);
                        dAL();
                    }
                    this.gAl.dAz();
                    onPrepared();
                    dAU();
                    if (this.mKp) {
                        dvz();
                    }
                }
                if (this.mKp) {
                    TiebaStatic.log(new ar("c13357").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ap("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mKl = false;
        if (this.mJY != null) {
            this.mJY.cancelAnimation();
        }
        this.gAl.stop();
        this.gAl.dAy();
        this.mKc.aRo();
        Gy(this.mJM);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mKl = false;
        if (this.mJY != null) {
            this.mJY.cancelAnimation();
        }
        this.gAl.stop();
        this.mKc.aRo();
        Gy(this.mJM);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dvz() {
        if (this.mKn != null) {
            o dAo = this.mKn.dAo();
            dAo.mLocate = this.mFrom;
            h.a(dAo.mIA, "", "1", dAo, this.gAl.getPcdnState());
        }
    }

    public void Gy(int i) {
        dAN();
        if (this.mViewState == this.mJU) {
            this.mJW = i;
            return;
        }
        this.mViewState = i;
        this.ams.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mJt.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mJY.clearAnimation();
        this.mJY.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mJY.cancelAnimation();
        } else {
            this.mJY.setAlpha(1.0f);
        }
        this.amu.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.amv.setVisibility((i & 8) > 0 ? 0 : 8);
        this.amw.setVisibility((i & 16) > 0 ? 0 : 8);
        this.amy.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mKa.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mKb.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mKc.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mJZ.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mKc.getVisibility() == 0) {
            this.mKc.showProgress();
        }
        this.mKd.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mKe.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mKe.getVisibility() == 0) {
            this.mKe.setAlpha(1.0f);
        }
        this.mKf.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mKg.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mKh.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mKj.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Gz(id);
            if (id == R.id.video_mute) {
                dAR();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dAT();
            } else if (id == R.id.video_replay) {
                Gy(this.mJM);
                startPlay();
                if (this.mKp) {
                    TiebaStatic.log(new ar("c13345").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_locate", this.lNc ? 1 : 2));
                }
                dAQ();
            } else if (id == R.id.video_play) {
                if (this.mViewState == this.mJM) {
                    startPlay();
                } else {
                    Gy(this.mJP);
                    dAM();
                    this.gAl.a(this.mKD);
                }
                if (this.mKp) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_source", this.lNc ? 1 : 2).ap("obj_locate", 1));
                }
                dAQ();
            } else if (id == R.id.video_pause) {
                Gy(this.mJQ);
                dAN();
                this.gAl.pause();
                if (this.mKp) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_source", this.lNc ? 1 : 2).ap("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Gy(this.mJM);
                startPlay();
            } else if (id == R.id.retry) {
                Gy(this.mJM);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAQ() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.agC);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gAl.setVolume(0.0f, 0.0f);
            this.mKa.setState(1);
            return;
        }
        this.gAl.setVolume(1.0f, 1.0f);
        this.mKa.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAR() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gAl.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
            this.mKa.setState(0);
        } else {
            this.gAl.setVolume(0.0f, 0.0f);
            this.mKa.setState(1);
            ak.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void xp(boolean z) {
        if (this.ldA == null) {
            this.ldA = new j((Activity) this.mContext);
        }
        if (z) {
            this.ldA.start();
            this.ldA.dh(true);
            return;
        }
        this.ldA.stop();
        this.ldA.dh(false);
    }

    public void dAS() {
        wx(true);
    }

    public void wx(boolean z) {
        if (this.mRootView != null && this.mKk != null && this.gAl != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.ldA == null) {
                this.ldA = new j((Activity) this.mContext);
            }
            if (this.lNc) {
                if (this.mKi.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mKi.getParent()).removeView(this.mKi);
                }
                if ((this.mKk.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lNc = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mKk.getParent()).removeView(this.mKk);
                    ((ViewGroup) this.mRootView).addView(this.mKk);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lNc);
                }
                if (!this.amB && z) {
                    this.ldA.TZ();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.amB && z) {
                        this.ldA.TZ();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mKk.getLocationOnScreen(this.mKt);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mKi == null) {
                                    this.mKi = new View(this.mContext);
                                    this.mKi.setClickable(true);
                                    this.mKi.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mKi.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mKi.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mKi.getParent()).removeView(this.mKi);
                                }
                                this.mKi.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mKi);
                                ((ViewGroup) childAt).addView(this.mKk);
                                this.isChangingOrientation = false;
                                this.lNc = true;
                                k((Activity) this.mContext, this.lNc);
                                if (this.jMK != null && this.jMK.isShowing()) {
                                    this.jMK.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mKp) {
                    TiebaStatic.log(new ar("c13360").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2));
                }
            }
            dvt();
            dvu();
            if (this.gAl.isPlaying()) {
                Gy(this.mJN);
            } else {
                Gy(this.mViewState);
            }
            this.mKb.dWp();
            xq(this.lNc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAT() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.amB) {
            dAS();
        } else if (this.mViewState == this.mJU) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mKk.setScaleX(1.0f);
                    d.this.mKk.setScaleY(1.0f);
                    d.this.mKk.setTranslationX(0.0f);
                    d.this.mKk.setTranslationY(0.0f);
                    d.this.mKe.setScaleX(1.0f);
                    d.this.mKe.setScaleY(1.0f);
                    d.this.mKk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mKv) {
                        d.this.dAS();
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
            if (!this.mKv) {
                float width = this.mRootView.getWidth() / this.mKk.getWidth();
                float height = this.mRootView.getHeight() / this.mKk.getHeight();
                this.mKk.setPivotX(0.0f);
                this.mKk.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mKk, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mKk, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mKe, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mKe, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mKk, "TranslationX", this.mKk.getTranslationX(), this.mKt[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mKk, "TranslationY", this.mKk.getTranslationY(), this.mKt[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mKi, "alpha", this.mKi.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mKe, "alpha", this.mKe.getAlpha(), 0.0f);
            } else {
                float width2 = this.mKr / this.mKk.getWidth();
                float height2 = this.mKu / this.mKk.getHeight();
                this.mKk.setPivotX(0.0f);
                this.mKk.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mKk, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mKk, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mKe, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mKe, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mKk, "TranslationX", this.mKk.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mKk, "TranslationY", this.mKk.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mKe, "alpha", this.mKe.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mJW != -1) {
                this.mViewState = this.mJW;
                this.mJW = -1;
                if (this.mViewState == this.mJV || this.mViewState == this.mJP || this.mViewState == this.mJN) {
                    this.gAl.a(this.mKD);
                    Gy(this.mJN);
                }
            }
        } else {
            dAS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.amB && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mKk != null) {
                    if (z) {
                        this.mKk.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mKk.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                dcq();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mKk.setSystemUiVisibility(0);
            }
        }
    }

    private void dAU() {
        Gy(this.mJO);
        this.mKc.showProgress();
        dAO();
    }

    protected void xq(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mKl) {
            if (this.lNc && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gAl.a(this.mKD);
        }
    }

    public void onCompletion() {
        Gy(this.mJS);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Gy(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mViewState == this.mJQ || (this.mViewState == this.mJR && !this.gAl.isPlaying())) {
                stopPlayForSurfaceDestroy();
                Gy(this.mJQ);
            } else if (this.mViewState == this.mJS) {
                stopPlayForSurfaceDestroy();
                Gy(this.mJS);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dAU();
        }
        if (i == 701) {
            bQA();
            return false;
        } else if (i == 702) {
            dAU();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dzW() {
        return this.mKk;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mKl || this.gAl.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gAl.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void onScroll() {
    }

    protected void Gz(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lNc;
    }

    protected boolean dvs() {
        return this.amB && this.lNc;
    }

    private void dcq() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mKk.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mKk.setSystemUiVisibility(4);
        } else {
            this.mKk.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dvw() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gAl.isPlaying() && !ak.bFQ()) {
            this.gAl.setVolume(1.0f, 1.0f);
            this.mKa.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dvx() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        if (z) {
            this.mJY.cancelAnimation();
            if (this.mViewState == this.mJN || this.mViewState == this.mJO || this.mViewState == this.mJP || this.mViewState == this.mJM) {
                stopPlay();
            }
            this.mViewState |= 1;
            Gy(this.mViewState);
        } else if (this.mViewState == this.mJM) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lNc;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dAH() {
        if (this.lNc) {
            dAT();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cRX() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dAV() {
        return this.mKA != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xr(boolean z) {
        this.agu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mKB = aVar;
    }
}
