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
    protected BdUniqueId ahU;
    private String akw;
    protected TbImageView anK;
    private ImageView anM;
    private ImageView anN;
    protected TextView anO;
    protected TextView anP;
    private TextView anQ;
    protected boolean anT;
    protected String anU;
    protected long anV;
    protected TbCyberVideoView gBU;
    private com.baidu.mcn.c jOt;
    private j lfD;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mLv;
    private float mMA;
    private int mMB;
    private McnAdInfo mMC;
    private a mMD;
    private TBLottieAnimationView mMa;
    private PercentSizeView mMb;
    protected SwitchImageView mMc;
    protected SwitchImageView mMd;
    protected OperableVideoMediaControllerView mMe;
    protected OperableVideoNetworkStateTipView mMf;
    protected OperableVideoShareView mMg;
    protected ImageView mMh;
    protected View mMi;
    protected VideoGestureView mMj;
    private View mMk;
    private OperableVideoErrorView mMl;
    protected ViewGroup mMm;
    protected boolean mMn;
    protected int mMo;
    protected o mMp;
    protected cb mMq;
    private float mMs;
    private float mMt;
    private int mMu;
    private int mMw;
    private boolean mMx;
    private View mRootView;
    protected String mVideoUrl;
    protected int mLz = 3000;
    protected final int mLA = 1;
    protected final int mLB = 2;
    protected final int mLC = 4;
    protected final int mLD = 8;
    protected final int mLE = 16;
    protected final int mLF = 32;
    protected final int mLG = 64;
    protected final int mLH = 128;
    protected final int mLI = 256;
    protected final int mLJ = 512;
    protected final int mLK = 1024;
    protected final int mLL = 2048;
    protected final int mLM = 4096;
    protected final int mLN = 8192;
    protected int mLO = 8211;
    protected int mLP = 0;
    protected int mLQ = 4;
    protected int mLR = 232;
    protected int mLS = 8416;
    protected int mLT = 0;
    protected int mLU = 513;
    protected int mLV = 259;
    protected int mLW = 2048;
    protected int mLX = 0;
    protected int STATE_ERROR = 4099;
    protected int mViewState = this.mLO;
    private int mmI = 0;
    private int mLY = -1;
    private Runnable mLZ = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.GB(d.this.mLP);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lPe = false;
    protected boolean mMr = true;
    private boolean isChangingOrientation = false;
    private int[] mMv = new int[2];
    private int mMy = 0;
    private int mMz = 0;
    protected View.OnClickListener alm = null;
    protected View.OnClickListener ahC = null;
    private boolean ahM = false;
    private long startPosition = -1;
    private f.b mME = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void cf(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dBd() && !d.this.anT && !d.this.lPe && d.this.ahM) {
                if (!com.baidu.mcn.b.abu().je(d.this.mMC.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mMC.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mMC.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mMC.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jOt.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.cjk = d.this.mMC.card_title;
                            aVar.cjl = d.this.mMC.button_title;
                            aVar.cjm = d.this.mMC.jump_url;
                            aVar.cjj = d.this.mMC.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.anU;
                            aVar.cjn = d.this.cSe();
                            if (z2) {
                                d.this.jOt.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jOt.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jOt.isShowing()) {
                        d.this.jOt.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mMD != null) {
                d.this.mMD.cH(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gjA = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.GB(d.this.mLR);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gBU.isPlaying()) {
                    d.this.gBU.a(d.this.mMF);
                }
                d.this.dAU();
                if (d.this.mMr) {
                    TiebaStatic.log(new ar("c13355").dR("tid", d.this.anU).v("fid", d.this.mFid).aq("obj_type", d.this.anT ? 1 : 2).aq("obj_locate", d.this.lPe ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener juw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gBU.isPlaying()) {
                d.this.gBU.pause();
                if (d.this.mViewState == d.this.mLR) {
                    d.this.GB(d.this.mLS);
                } else {
                    d.this.GB(d.this.mLT);
                }
                d.this.GC(R.id.video_pause);
            } else if (d.this.mViewState == d.this.mLS || d.this.mViewState == (d.this.mLS | 1)) {
                d.this.GB(d.this.mLR);
                d.this.dAU();
                d.this.gBU.a(d.this.mMF);
                d.this.GC(R.id.video_play);
            } else if (d.this.mViewState == d.this.mLT || d.this.mViewState == (d.this.mLT | 1)) {
                d.this.GB(d.this.mLP);
                d.this.gBU.a(d.this.mMF);
                d.this.GC(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gBU.isPlaying()) {
                if (d.this.mViewState == d.this.mLP || d.this.mViewState == d.this.mLQ) {
                    d.this.GB(d.this.mLR);
                    d.this.dAU();
                    return true;
                } else if (d.this.mViewState == d.this.mLR) {
                    d.this.GB(d.this.mLP);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mViewState == d.this.mLS) {
                d.this.GB(d.this.mLT);
                return true;
            } else if (d.this.mViewState == (d.this.mLS | 1)) {
                d.this.GB(d.this.mLT | 1);
                return true;
            } else if (d.this.mViewState == d.this.mLT) {
                d.this.GB(d.this.mLS);
                return true;
            } else if (d.this.mViewState == (d.this.mLT | 1)) {
                d.this.GB(d.this.mLS | 1);
                return true;
            } else {
                d.this.GB(d.this.mLO);
                d.this.startPlay();
                d.this.dAY();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.mmI = 0;
            if (d.this.lPe) {
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
            if (d.this.anT && d.this.dvB()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.mmI) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gBU.isPlaying()) {
                                d.this.gBU.pause();
                                d.this.GB(d.this.mLX);
                            }
                            d.this.mmI = 4;
                            d.this.mLY = d.this.mViewState;
                            d.this.mViewState = d.this.mLW;
                            d.this.mMw = d.this.mMm.getMeasuredHeight();
                            d.this.mMA = d.this.mMt / d.this.mMw;
                            d.this.mMB = (int) (1.2f * d.this.mRootView.getWidth());
                            dg(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dg(rawX, rawY);
                        break;
                }
            } else if (d.this.mViewState == d.this.mLP || d.this.mViewState == d.this.mLR || d.this.mViewState == d.this.mLS || d.this.mViewState == d.this.mLT || d.this.mViewState == d.this.mLW || d.this.mViewState == (d.this.mLS | 1) || d.this.mViewState == (d.this.mLT | 1)) {
                switch (d.this.mmI) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.mmI = 3;
                            d.this.mMu = d.this.gBU.getCurrentPosition();
                            bc(f);
                        } else if (motionEvent.getX() < d.this.mMm.getWidth() / 2) {
                            d.this.mmI = 2;
                            d.this.mMj.v(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.mmI = 1;
                            d.this.mMj.u(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mViewState != d.this.mLW) {
                            if ((d.this.mViewState & 1) > 0) {
                                d.this.mLW |= 1;
                            } else {
                                d.this.mLW &= -2;
                            }
                            d.this.GB(d.this.mLW);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mMj.u(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dvF();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mMj.v(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        bc(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dg(int i, int i2) {
            if (d.this.mMy != i2 || d.this.mMz != i) {
                d.this.mMx = d.this.mMy - i2 > 0 || ((float) i2) < d.this.mMs / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mMm.getLayoutParams();
                if (i2 != d.this.mMy) {
                    int i3 = d.this.mMw - i2;
                    int i4 = (int) (i3 * d.this.mMA);
                    if (i4 < d.this.mMB) {
                        i4 = d.this.mMB;
                        i3 = (int) (i4 / d.this.mMA);
                    }
                    if (i4 != d.this.mMB) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mMm.setLayoutParams(layoutParams);
                    }
                    d.this.mMy = i2;
                    d.this.mMm.setTranslationY(d.this.mMy);
                }
                if (i != d.this.mMy) {
                    d.this.mMz = i;
                    d.this.mMm.setTranslationX(d.this.mMz + ((d.this.mMt - layoutParams.width) / 2.0f));
                }
                d.this.mMk.setAlpha((layoutParams.width - d.this.mMB) / (d.this.mMt - d.this.mMB));
                if (d.this.mMg.getVisibility() == 0) {
                    float f = d.this.mMs / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mMg.setAlpha(f2);
                }
            }
        }

        private void bc(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mMu -= 1000;
                z = true;
            } else {
                d.this.mMu += 1000;
                z = false;
            }
            int duration = d.this.gBU.getDuration();
            if (d.this.mMu < 0) {
                d.this.mMu = 0;
            } else if (d.this.mMu > duration) {
                d.this.mMu = duration;
            }
            String str = au.stringForVideoTime(d.this.mMu) + " / " + au.stringForVideoTime(duration);
            if (d.this.mMj != null) {
                d.this.mMj.L(z, str);
            }
            d.this.mMe.setCurrentDuration(d.this.mMu, false);
        }
    };
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mViewState == d.this.mLW) {
                if (d.this.mmI == 4) {
                    d.this.dBb();
                    d.this.mMy = 0;
                    d.this.mMz = 0;
                } else {
                    d.this.mViewState = -1;
                    if (d.this.mmI != 3) {
                        if (d.this.mLY != -1) {
                            d.this.GB(d.this.mLY);
                            d.this.mLY = -1;
                        } else if (d.this.gBU.isPlaying()) {
                            d.this.GB(d.this.mLP);
                        } else {
                            d.this.GB(d.this.mLS);
                        }
                    } else {
                        d.this.mMe.setCurrentDuration(d.this.mMu, true);
                        if (d.this.mMu <= d.this.gBU.getDuration()) {
                            if (!d.this.gBU.isPlaying()) {
                                d.this.gBU.a(d.this.mMF);
                            }
                            d.this.GB(d.this.mLP);
                        }
                    }
                }
                if (d.this.mMr) {
                    String str = null;
                    if (d.this.mmI != 1) {
                        if (d.this.mmI != 2) {
                            if (d.this.mmI == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!au.isEmpty(str)) {
                        TiebaStatic.log(new ar(str).dR("tid", d.this.anU).v("fid", d.this.mFid));
                    }
                }
                d.this.mmI = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mMF = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dAK() {
            d.this.gBU.dAG();
            d.this.dAT();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dAL() {
            d.this.GB(d.this.mLO);
            d.this.bQG();
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
            this.mMs = l.getEquipmentHeight(this.mContext);
            this.mMt = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dvD() {
        int i;
        int i2;
        int i3;
        this.mMf.au(this.anT, this.lPe);
        this.mMg.au(this.anT, this.lPe);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.anT) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
                i3 = dimension;
            } else if (this.lPe) {
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
            this.anO.setPadding(0, 0, i3, 0);
            this.mMd.setPadding(this.mMd.getPaddingLeft(), 0, i2, 0);
            this.mMc.setPadding(i, 0, 0, 0);
        }
    }

    public void dvC() {
        if (this.anT) {
            this.mLR = 104;
            this.mLS = 8290;
        } else {
            this.mLR = 232;
            this.mLS = 8418;
        }
        if (this.lPe) {
            this.mLO |= 1024;
            this.mLP |= 1024;
            this.mLQ |= 1024;
            this.mLR |= 1024;
            this.mLS |= 1024;
            this.mLT |= 1024;
            this.mLU |= 1024;
            this.mLV |= 1024;
            this.mViewState |= 1024;
            return;
        }
        this.mLO &= -1025;
        this.mLP &= -1025;
        this.mLQ &= -1025;
        this.mLR &= -1025;
        this.mLS &= -1025;
        this.mLT &= -1025;
        this.mLU &= -1025;
        this.mLV &= -1025;
        this.mViewState &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mMm = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mMm);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.anK = (TbImageView) this.mMm.findViewById(R.id.video_thumbnail);
            this.mLv = this.mMm.findViewById(R.id.black_mask);
            this.mMa = (TBLottieAnimationView) this.mMm.findViewById(R.id.video_loading);
            this.anM = (ImageView) this.mMm.findViewById(R.id.video_play);
            this.mMb = (PercentSizeView) this.mMm.findViewById(R.id.video_media_controller_mask);
            this.anN = (ImageView) this.mMm.findViewById(R.id.video_pause);
            this.anO = (TextView) this.mMm.findViewById(R.id.video_play_count);
            this.anP = (TextView) this.mMm.findViewById(R.id.video_play_flag);
            this.anQ = (TextView) this.mMm.findViewById(R.id.video_duration);
            this.mMc = (SwitchImageView) this.mMm.findViewById(R.id.video_mute);
            this.mMd = (SwitchImageView) this.mMm.findViewById(R.id.video_full_screen);
            this.mMe = (OperableVideoMediaControllerView) this.mMm.findViewById(R.id.video_media_controller);
            this.mMf = (OperableVideoNetworkStateTipView) this.mMm.findViewById(R.id.video_network_state_tip);
            this.mMg = (OperableVideoShareView) this.mMm.findViewById(R.id.video_share_view);
            this.mMi = this.mMm.findViewById(R.id.video_back_btn_mask);
            this.mMh = (ImageView) this.mMm.findViewById(R.id.video_full_screen_back);
            this.mMj = (VideoGestureView) this.mMm.findViewById(R.id.video_gesture);
            this.mMl = (OperableVideoErrorView) this.mMm.findViewById(R.id.video_error_layout);
            this.mMg.setVideoContainer(this);
            this.mMa.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mMa.setVisibility(8);
                    d.this.anM.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mMa.setAnimation(R.raw.lotti_video_loading);
            this.anM.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anM.setOnClickListener(this);
            this.mMc.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mMc.setState(1);
            this.mMc.setOnClickListener(this);
            this.anK.bGs();
            this.anK.setDrawCorner(false);
            this.anK.setPlaceHolder(3);
            com.baidu.tbadk.a.b.b.m(this.mLv, R.color.CAM_X0607);
            this.mMe.setOnSeekBarChangeListener(this.gjA);
            this.mMb.setHeightPercent(0.583f);
            this.mMb.setBackgroundResource(R.drawable.video_mask_bg);
            this.mMd.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mMd.setState(0);
            this.mMd.setOnClickListener(this);
            this.anN.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anN.setOnClickListener(this);
            this.mMh.setOnClickListener(this);
            this.gBU = new TbCyberVideoView(this.mContext);
            this.gBU.setTryUseViewInSet(true);
            dAT();
            this.mMf.setPlayViewOnClickListener(this);
            this.mMm.setOnClickListener(null);
            this.mMm.setOnTouchListener(this.bUt);
            this.mMg.setOnTouchListener(this.bUt);
            this.mMl.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.juw);
            GB(this.mLO);
            this.jOt = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dAT() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mMm.addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
            this.mMe.setPlayer(this.gBU);
            this.gBU.setContinuePlayEnable(true);
            this.gBU.setOnPreparedListener(this);
            this.gBU.setOnCompletionListener(this);
            this.gBU.setOnErrorListener(this);
            this.gBU.setOnSurfaceDestroyedListener(this);
            this.gBU.setOnInfoListener(this);
            this.gBU.setVideoStatData(this.mMp);
            this.gBU.setThreadDataForStatistic(this.mMq);
            this.gBU.getMediaProgressObserver().a(this.mME);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boj() != null) {
            this.startPosition = -1L;
            if (this.jOt != null) {
                this.jOt.reset();
            }
            if (!au.equals(this.mVideoUrl, cbVar.boj().video_url)) {
                stopPlay();
                this.anT = cbVar.boj().is_vertical.intValue() == 1;
                this.mVideoUrl = cbVar.boj().video_url;
                this.anU = cbVar.getTid();
                this.anV = cbVar.boj().video_length.intValue();
                this.mMo = cbVar.boj().video_duration.intValue();
                this.mFid = cbVar.getFid();
                this.mMC = cbVar.boj().mcn_ad_card;
                dvC();
                dvD();
                GB(this.mLO);
                int intValue = cbVar.boj().video_duration.intValue() * 1000;
                this.mMe.Hs(intValue);
                this.mMe.setPlayer(this.gBU);
                this.anQ.setText(au.stringForVideoTime(intValue));
                this.anO.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(cbVar.boj().play_count.intValue())));
                this.mMf.setVideoLength(cbVar.boj().video_length.intValue());
                this.mMf.setVideoDuration(cbVar.boj().video_duration.intValue());
                this.mMf.setTid(this.anU);
                this.mMq = cbVar;
                this.gBU.setThreadDataForStatistic(cbVar);
                this.anP.setVisibility(8);
                this.anK.setPlaceHolder(3);
                this.anK.startLoad(cbVar.boj().thumbnail_url, 10, false);
                this.mMg.setShareData(cbVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gBU != null) {
            this.mMp = oVar;
            this.gBU.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void af(View.OnClickListener onClickListener) {
        this.ahC = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Hu(int i) {
        this.gBU.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahU = bdUniqueId;
    }

    public void dAU() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mLZ);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mLZ, this.mLz);
    }

    public void dAV() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mLZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQG() {
        this.mMa.setAlpha(1.0f);
        this.mMa.setVisibility(0);
        this.anM.setVisibility(8);
        if (this.mMa != null) {
            this.mMa.loop(true);
            this.mMa.setMinAndMaxFrame(14, 80);
            this.mMa.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvA() {
        if (this.mViewState == this.mLQ) {
            GB(this.mLP);
        }
    }

    private void dAW() {
        GB(this.mLQ);
        this.mMe.showProgress();
        if (this.mMa != null) {
            this.mMa.clearAnimation();
            this.mMa.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dvA();
                    if (!d.this.mMn) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mMa.setVisibility(8);
                    d.this.anM.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dAX() {
        return this.mMf != null && this.mMf.dvK();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.akw = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dAX()) {
                GB(this.mLV);
                return;
            }
            this.mMn = true;
            if (!this.gBU.isPlaying()) {
                TbCyberVideoView QM = TbVideoViewSet.dAJ().QM(this.mVideoUrl);
                if (QM == null) {
                    this.gBU.dAG();
                    if (!StringUtils.isNull(this.gBU.getOriginUrl())) {
                        this.gBU = new TbCyberVideoView(this.mContext);
                        this.gBU.setTryUseViewInSet(true);
                    }
                    dAT();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gBU.setVideoDuration(this.mMo);
                        this.gBU.setVideoPath(this.mVideoUrl, this.anU);
                        this.gBU.setStageType(this.akw);
                        bQG();
                        if (this.mMr) {
                            dvI();
                        }
                    }
                } else {
                    if (this.gBU == QM) {
                        if (this.gBU.getParent() == null || this.gBU.getParent() != QM.getParent()) {
                            this.gBU.dAG();
                            dAT();
                        }
                    } else {
                        this.gBU.dAG();
                        QM.dAG();
                        this.gBU = QM;
                        this.gBU.setTryUseViewInSet(true);
                        dAT();
                    }
                    this.gBU.dAH();
                    onPrepared();
                    dBc();
                    if (this.mMr) {
                        dvI();
                    }
                }
                if (this.mMr) {
                    TiebaStatic.log(new ar("c13357").dR("tid", this.anU).v("fid", this.mFid).aq("obj_type", this.anT ? 1 : 2).aq("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).aq("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mMn = false;
        if (this.mMa != null) {
            this.mMa.cancelAnimation();
        }
        this.gBU.stop();
        this.gBU.dAG();
        this.mMe.aRr();
        GB(this.mLO);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mMn = false;
        if (this.mMa != null) {
            this.mMa.cancelAnimation();
        }
        this.gBU.stop();
        this.mMe.aRr();
        GB(this.mLO);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dvI() {
        if (this.mMp != null) {
            o dAw = this.mMp.dAw();
            dAw.mLocate = this.mFrom;
            h.a(dAw.mKE, "", "1", dAw, this.gBU.getPcdnState());
        }
    }

    public void GB(int i) {
        dAV();
        if (this.mViewState == this.mLW) {
            this.mLY = i;
            return;
        }
        this.mViewState = i;
        this.anK.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mLv.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mMa.clearAnimation();
        this.mMa.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mMa.cancelAnimation();
        } else {
            this.mMa.setAlpha(1.0f);
        }
        this.anM.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.anN.setVisibility((i & 8) > 0 ? 0 : 8);
        this.anO.setVisibility((i & 16) > 0 ? 0 : 8);
        this.anQ.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mMc.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mMd.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mMe.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mMb.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mMe.getVisibility() == 0) {
            this.mMe.showProgress();
        }
        this.mMf.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mMg.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mMg.getVisibility() == 0) {
            this.mMg.setAlpha(1.0f);
        }
        this.mMh.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mMi.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mMj.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mMl.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            GC(id);
            if (id == R.id.video_mute) {
                dAZ();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dBb();
            } else if (id == R.id.video_replay) {
                GB(this.mLO);
                startPlay();
                if (this.mMr) {
                    TiebaStatic.log(new ar("c13345").dR("tid", this.anU).v("fid", this.mFid).aq("obj_type", this.anT ? 1 : 2).aq("obj_locate", this.lPe ? 1 : 2));
                }
                dAY();
            } else if (id == R.id.video_play) {
                if (this.mViewState == this.mLO) {
                    startPlay();
                } else {
                    GB(this.mLR);
                    dAU();
                    this.gBU.a(this.mMF);
                }
                if (this.mMr) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.anU).v("fid", this.mFid).aq("obj_type", this.anT ? 1 : 2).aq("obj_source", this.lPe ? 1 : 2).aq("obj_locate", 1));
                }
                dAY();
            } else if (id == R.id.video_pause) {
                GB(this.mLS);
                dAV();
                this.gBU.pause();
                if (this.mMr) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.anU).v("fid", this.mFid).aq("obj_type", this.anT ? 1 : 2).aq("obj_source", this.lPe ? 1 : 2).aq("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                GB(this.mLO);
                startPlay();
            } else if (id == R.id.retry) {
                GB(this.mLO);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAY() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ahU);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gBU.setVolume(0.0f, 0.0f);
            this.mMc.setState(1);
            return;
        }
        this.gBU.setVolume(1.0f, 1.0f);
        this.mMc.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAZ() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gBU.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
            this.mMc.setState(0);
        } else {
            this.gBU.setVolume(0.0f, 0.0f);
            this.mMc.setState(1);
            ak.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void xp(boolean z) {
        if (this.lfD == null) {
            this.lfD = new j((Activity) this.mContext);
        }
        if (z) {
            this.lfD.start();
            this.lfD.dh(true);
            return;
        }
        this.lfD.stop();
        this.lfD.dh(false);
    }

    public void dBa() {
        wx(true);
    }

    public void wx(boolean z) {
        if (this.mRootView != null && this.mMm != null && this.gBU != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.lfD == null) {
                this.lfD = new j((Activity) this.mContext);
            }
            if (this.lPe) {
                if (this.mMk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mMk.getParent()).removeView(this.mMk);
                }
                if ((this.mMm.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lPe = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mMm.getParent()).removeView(this.mMm);
                    ((ViewGroup) this.mRootView).addView(this.mMm);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lPe);
                }
                if (!this.anT && z) {
                    this.lfD.Uc();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.anT && z) {
                        this.lfD.Uc();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mMm.getLocationOnScreen(this.mMv);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mMk == null) {
                                    this.mMk = new View(this.mContext);
                                    this.mMk.setClickable(true);
                                    this.mMk.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mMk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mMk.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mMk.getParent()).removeView(this.mMk);
                                }
                                this.mMk.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mMk);
                                ((ViewGroup) childAt).addView(this.mMm);
                                this.isChangingOrientation = false;
                                this.lPe = true;
                                k((Activity) this.mContext, this.lPe);
                                if (this.jOt != null && this.jOt.isShowing()) {
                                    this.jOt.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mMr) {
                    TiebaStatic.log(new ar("c13360").dR("tid", this.anU).v("fid", this.mFid).aq("obj_type", this.anT ? 1 : 2));
                }
            }
            dvC();
            dvD();
            if (this.gBU.isPlaying()) {
                GB(this.mLP);
            } else {
                GB(this.mViewState);
            }
            this.mMd.dWx();
            xq(this.lPe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBb() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.anT) {
            dBa();
        } else if (this.mViewState == this.mLW) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mMm.setScaleX(1.0f);
                    d.this.mMm.setScaleY(1.0f);
                    d.this.mMm.setTranslationX(0.0f);
                    d.this.mMm.setTranslationY(0.0f);
                    d.this.mMg.setScaleX(1.0f);
                    d.this.mMg.setScaleY(1.0f);
                    d.this.mMm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mMx) {
                        d.this.dBa();
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
            if (!this.mMx) {
                float width = this.mRootView.getWidth() / this.mMm.getWidth();
                float height = this.mRootView.getHeight() / this.mMm.getHeight();
                this.mMm.setPivotX(0.0f);
                this.mMm.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mMm, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mMm, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mMg, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mMg, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mMm, "TranslationX", this.mMm.getTranslationX(), this.mMv[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mMm, "TranslationY", this.mMm.getTranslationY(), this.mMv[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mMk, "alpha", this.mMk.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mMg, "alpha", this.mMg.getAlpha(), 0.0f);
            } else {
                float width2 = this.mMt / this.mMm.getWidth();
                float height2 = this.mMw / this.mMm.getHeight();
                this.mMm.setPivotX(0.0f);
                this.mMm.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mMm, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mMm, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mMg, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mMg, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mMm, "TranslationX", this.mMm.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mMm, "TranslationY", this.mMm.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mMg, "alpha", this.mMg.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mLY != -1) {
                this.mViewState = this.mLY;
                this.mLY = -1;
                if (this.mViewState == this.mLX || this.mViewState == this.mLR || this.mViewState == this.mLP) {
                    this.gBU.a(this.mMF);
                    GB(this.mLP);
                }
            }
        } else {
            dBa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.anT && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mMm != null) {
                    if (z) {
                        this.mMm.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mMm.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                dcz();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mMm.setSystemUiVisibility(0);
            }
        }
    }

    private void dBc() {
        GB(this.mLQ);
        this.mMe.showProgress();
        dAW();
    }

    protected void xq(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mMn) {
            if (this.lPe && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gBU.a(this.mMF);
        }
    }

    public void onCompletion() {
        GB(this.mLU);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        GB(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mViewState == this.mLS || (this.mViewState == this.mLT && !this.gBU.isPlaying())) {
                stopPlayForSurfaceDestroy();
                GB(this.mLS);
            } else if (this.mViewState == this.mLU) {
                stopPlayForSurfaceDestroy();
                GB(this.mLU);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dBc();
        }
        if (i == 701) {
            bQG();
            return false;
        } else if (i == 702) {
            dBc();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dAf() {
        return this.mMm;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mMn || this.gBU.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gBU.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void onScroll() {
    }

    protected void GC(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lPe;
    }

    protected boolean dvB() {
        return this.anT && this.lPe;
    }

    private void dcz() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mMm.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mMm.setSystemUiVisibility(4);
        } else {
            this.mMm.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dvF() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gBU.isPlaying() && !ak.bFU()) {
            this.gBU.setVolume(1.0f, 1.0f);
            this.mMc.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dvG() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        if (z) {
            this.mMa.cancelAnimation();
            if (this.mViewState == this.mLP || this.mViewState == this.mLQ || this.mViewState == this.mLR || this.mViewState == this.mLO) {
                stopPlay();
            }
            this.mViewState |= 1;
            GB(this.mViewState);
        } else if (this.mViewState == this.mLO) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lPe;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dAP() {
        if (this.lPe) {
            dBb();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cSe() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dBd() {
        return this.mMC != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xr(boolean z) {
        this.ahM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mMD = aVar;
    }
}
