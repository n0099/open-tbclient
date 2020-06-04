package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.play.operableVideoView.a {
    protected BdUniqueId afZ;
    protected TbImageView aii;
    private ImageView aij;
    private ImageView aik;
    private TextView ail;
    private TextView aim;
    private TextView ain;
    protected boolean air;
    protected String ais;
    protected long ait;
    private com.baidu.mcn.c hOD;
    private o jbd;
    private View kCN;
    private TBLottieAnimationView kCO;
    private PercentSizeView kCP;
    protected SwitchImageView kCQ;
    protected SwitchImageView kCR;
    protected OperableVideoMediaControllerView kCS;
    protected OperableVideoNetworkStateTipView kCT;
    protected OperableVideoShareView kCU;
    protected ImageView kCV;
    protected View kCW;
    protected VideoGestureView kCX;
    private View kCY;
    private OperableVideoErrorView kCZ;
    protected ViewGroup kDa;
    protected boolean kDb;
    protected int kDc;
    protected n kDd;
    private float kDg;
    private float kDh;
    private int kDi;
    private int kDk;
    private boolean kDl;
    private float kDo;
    private int kDp;
    private McnAdInfo kDq;
    private a kDr;
    protected com.baidu.tieba.play.a.a kxZ;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int kCl = 3000;
    protected final int kCm = 1;
    protected final int kCn = 2;
    protected final int kCo = 4;
    protected final int kCp = 8;
    protected final int kCq = 16;
    protected final int kCr = 32;
    protected final int kCs = 64;
    protected final int kCt = 128;
    protected final int kCu = 256;
    protected final int kCv = 512;
    protected final int kCw = 1024;
    protected final int kCx = 2048;
    protected final int kCy = 4096;
    protected final int kCz = 8192;
    protected int kCA = 8211;
    protected int kCB = 0;
    protected int kCC = 4;
    protected int kCD = 232;
    protected int kCE = 8416;
    protected int kCF = 0;
    protected int kCG = 513;
    protected int kCH = 259;
    protected int kCI = 2048;
    protected int kCJ = 0;
    protected int STATE_ERROR = 4099;
    protected int kCK = this.kCA;
    private int kdz = 0;
    private int kCL = -1;
    private Runnable kCM = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.AU(d.this.kCB);
        }
    };
    private WeakReference<Context> aio = null;
    protected boolean jHB = false;
    private boolean isNewPlayer = false;
    protected boolean kDe = true;
    private boolean kDf = false;
    private int[] kDj = new int[2];
    private int kDm = 0;
    private int kDn = 0;
    protected View.OnClickListener ags = null;
    protected View.OnClickListener adx = null;
    private boolean adG = false;
    private long startPosition = -1;
    protected boolean ahG = false;
    private TbImageView.c ahi = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // com.baidu.tbadk.widget.TbImageView.c
        public void a(TbImageView tbImageView, Canvas canvas) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7 = 0.0f;
            if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                com.baidu.adp.widget.ImageView.a yv = com.baidu.tbadk.imageManager.c.beu().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), 10));
                if (yv != null) {
                    int width = yv.getWidth();
                    i = yv.getHeight();
                    i2 = width;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i2 != 0 && i != 0) {
                    int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                        float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                        if (i2 * height > width2 * i) {
                            f5 = height / i;
                            float f8 = i2 * smartCropCenterPointWidthRatio * f5;
                            if (f8 < width2 * 0.5f) {
                                f6 = 0.0f;
                            } else if ((i2 * f5) - f8 < width2 * 0.5f) {
                                f6 = width2 - (i2 * f5);
                            } else {
                                f6 = (width2 * 0.5f) - f8;
                            }
                        } else {
                            f5 = width2 / i2;
                            float f9 = i * smartCropCenterPointHeightRatio * f5;
                            if (f9 < height * 0.5f) {
                                f6 = 0.0f;
                            } else if ((i * f5) - f9 < height * 0.5f) {
                                f6 = 0.0f;
                                f7 = height - (i * f5);
                            } else {
                                float f10 = (height * 0.5f) - f9;
                                f6 = 0.0f;
                                f7 = f10;
                            }
                        }
                        imageMatrix.setScale(f5, f5);
                        imageMatrix.postTranslate(f6, f7);
                    } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i2 * height > width2 * i) {
                            f4 = height / i;
                        } else {
                            f4 = width2 / i2;
                        }
                        imageMatrix.setScale(f4, f4);
                        imageMatrix.postTranslate(0.0f, 0.0f);
                    } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i2 * height > width2 * i) {
                            float f11 = height / i;
                            f2 = f11;
                            f3 = (width2 - (i2 * f11)) * 0.5f;
                            f = 0.0f;
                        } else {
                            float f12 = width2 / i2;
                            f = (height - (i * f12)) * 0.5f;
                            f2 = f12;
                            f3 = 0.0f;
                        }
                        imageMatrix.setScale(f2, f2);
                        if (d.this.ahG && i > i2) {
                            imageMatrix.postTranslate(f3, 0.0f);
                        } else {
                            imageMatrix.postTranslate(f3, f);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.c
        public void b(TbImageView tbImageView, Canvas canvas) {
        }
    };
    private SeekBar.OnSeekBarChangeListener ePf = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.AU(d.this.kCD);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.kxZ.isPlaying()) {
                    d.this.kxZ.b(d.this.kDs);
                }
                d.this.cRT();
                if (d.this.kDe) {
                    TiebaStatic.log(new an("c13355").dh("tid", d.this.ais).s("fid", d.this.mFid).ag("obj_type", d.this.air ? 1 : 2).ag("obj_locate", d.this.jHB ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hxO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.kxZ.isPlaying()) {
                d.this.kxZ.pause();
                if (d.this.kCK == d.this.kCD) {
                    d.this.AU(d.this.kCE);
                } else {
                    d.this.AU(d.this.kCF);
                }
                d.this.AV(R.id.video_pause);
            } else if (d.this.kCK == d.this.kCE || d.this.kCK == (d.this.kCE | 1)) {
                d.this.AU(d.this.kCD);
                d.this.cRT();
                d.this.kxZ.b(d.this.kDs);
                d.this.AV(R.id.video_play);
            } else if (d.this.kCK == d.this.kCF || d.this.kCK == (d.this.kCF | 1)) {
                d.this.AU(d.this.kCB);
                d.this.kxZ.b(d.this.kDs);
                d.this.AV(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.kxZ.isPlaying()) {
                if (d.this.kCK == d.this.kCB || d.this.kCK == d.this.kCC) {
                    d.this.AU(d.this.kCD);
                    d.this.cRT();
                    return true;
                } else if (d.this.kCK == d.this.kCD) {
                    d.this.AU(d.this.kCB);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.kCK == d.this.kCE) {
                d.this.AU(d.this.kCF);
                return true;
            } else if (d.this.kCK == (d.this.kCE | 1)) {
                d.this.AU(d.this.kCF | 1);
                return true;
            } else if (d.this.kCK == d.this.kCF) {
                d.this.AU(d.this.kCE);
                return true;
            } else if (d.this.kCK == (d.this.kCF | 1)) {
                d.this.AU(d.this.kCE | 1);
                return true;
            } else {
                d.this.AU(d.this.kCA);
                d.this.startPlay();
                d.this.cRY();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kdz = 0;
            if (d.this.jHB) {
                d.this.i((Activity) d.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!d.this.J(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if ((d.this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.mContext).disableSwipeJustOnce();
            }
            if (d.this.air && d.this.cMe()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.kdz) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.kxZ.isPlaying()) {
                                d.this.kxZ.pause();
                                d.this.AU(d.this.kCJ);
                            }
                            d.this.kdz = 4;
                            d.this.kCL = d.this.kCK;
                            d.this.kCK = d.this.kCI;
                            d.this.kDk = d.this.kDa.getMeasuredHeight();
                            d.this.kDo = d.this.kDh / d.this.kDk;
                            d.this.kDp = (int) (1.2f * d.this.mRootView.getWidth());
                            cJ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cJ(rawX, rawY);
                        break;
                }
            } else if (d.this.kCK == d.this.kCB || d.this.kCK == d.this.kCD || d.this.kCK == d.this.kCE || d.this.kCK == d.this.kCF || d.this.kCK == d.this.kCI || d.this.kCK == (d.this.kCE | 1) || d.this.kCK == (d.this.kCF | 1)) {
                switch (d.this.kdz) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kdz = 3;
                            d.this.kDi = d.this.kxZ.getCurrentPosition();
                            ar(f);
                        } else if (motionEvent.getX() < d.this.kDa.getWidth() / 2) {
                            d.this.kdz = 2;
                            d.this.kCX.q(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kdz = 1;
                            d.this.kCX.p(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.kCK != d.this.kCI) {
                            if ((d.this.kCK & 1) > 0) {
                                d.this.kCI |= 1;
                            } else {
                                d.this.kCI &= -2;
                            }
                            d.this.AU(d.this.kCI);
                            break;
                        }
                        break;
                    case 1:
                        d.this.kCX.p(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cMi();
                            break;
                        }
                        break;
                    case 2:
                        d.this.kCX.q(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        ar(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cJ(int i, int i2) {
            if (d.this.kDm != i2 || d.this.kDn != i) {
                d.this.kDl = d.this.kDm - i2 > 0 || ((float) i2) < d.this.kDg / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.kDa.getLayoutParams();
                if (i2 != d.this.kDm) {
                    int i3 = d.this.kDk - i2;
                    int i4 = (int) (i3 * d.this.kDo);
                    if (i4 < d.this.kDp) {
                        i4 = d.this.kDp;
                        i3 = (int) (i4 / d.this.kDo);
                    }
                    if (i4 != d.this.kDp) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.kDa.setLayoutParams(layoutParams);
                    }
                    d.this.kDm = i2;
                    d.this.kDa.setTranslationY(d.this.kDm);
                }
                if (i != d.this.kDm) {
                    d.this.kDn = i;
                    d.this.kDa.setTranslationX(d.this.kDn + ((d.this.kDh - layoutParams.width) / 2.0f));
                }
                d.this.kCY.setAlpha((layoutParams.width - d.this.kDp) / (d.this.kDh - d.this.kDp));
                if (d.this.kCU.getVisibility() == 0) {
                    float f = d.this.kDg / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.kCU.setAlpha(f2);
                }
            }
        }

        private void ar(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.kDi -= 1000;
                z = true;
            } else {
                d.this.kDi += 1000;
                z = false;
            }
            int duration = d.this.kxZ.getDuration();
            if (d.this.kDi < 0) {
                d.this.kDi = 0;
            } else if (d.this.kDi > duration) {
                d.this.kDi = duration;
            }
            String str = aq.stringForVideoTime(d.this.kDi) + " / " + aq.stringForVideoTime(duration);
            if (d.this.kCX != null) {
                d.this.kCX.y(z, str);
            }
            d.this.kCS.setCurrentDuration(d.this.kDi, false);
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.kCK == d.this.kCI) {
                if (d.this.kdz == 4) {
                    d.this.cSb();
                    d.this.kDm = 0;
                    d.this.kDn = 0;
                } else {
                    d.this.kCK = -1;
                    if (d.this.kdz != 3) {
                        if (d.this.kCL != -1) {
                            d.this.AU(d.this.kCL);
                            d.this.kCL = -1;
                        } else if (d.this.kxZ.isPlaying()) {
                            d.this.AU(d.this.kCB);
                        } else {
                            d.this.AU(d.this.kCE);
                        }
                    } else {
                        d.this.kCS.setCurrentDuration(d.this.kDi, true);
                        if (d.this.kDi <= d.this.kxZ.getDuration()) {
                            if (!d.this.kxZ.isPlaying()) {
                                d.this.kxZ.b(d.this.kDs);
                            }
                            d.this.AU(d.this.kCB);
                        }
                    }
                }
                if (d.this.kDe) {
                    String str = null;
                    if (d.this.kdz != 1) {
                        if (d.this.kdz != 2) {
                            if (d.this.kdz == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).dh("tid", d.this.ais).s("fid", d.this.mFid));
                    }
                }
                d.this.kdz = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a kDs = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cRK() {
            d.this.kxZ.cRd();
            d.this.cRS();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cRL() {
            d.this.AU(d.this.kCA);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener kDt = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ag.a(d.this.aio, true);
                    }
                    d.this.kxZ.setVolume(1.0f, 1.0f);
                    d.this.kCQ.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cMc();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cj(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.kDg = l.getEquipmentHeight(this.mContext);
            this.kDh = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cMg() {
        int dimension;
        int i;
        int i2;
        this.kCT.al(this.air, this.jHB);
        this.kCU.al(this.air, this.jHB);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.air) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.jHB) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ail.setPadding(0, 0, i2, 0);
            this.kCR.setPadding(this.kCR.getPaddingLeft(), 0, i, 0);
            this.kCQ.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cMf() {
        if (this.air) {
            this.kCD = 104;
            this.kCE = 8290;
        } else {
            this.kCD = 232;
            this.kCE = 8418;
        }
        if (this.jHB) {
            this.kCA |= 1024;
            this.kCB |= 1024;
            this.kCC |= 1024;
            this.kCD |= 1024;
            this.kCE |= 1024;
            this.kCF |= 1024;
            this.kCG |= 1024;
            this.kCH |= 1024;
            this.kCK |= 1024;
            return;
        }
        this.kCA &= -1025;
        this.kCB &= -1025;
        this.kCC &= -1025;
        this.kCD &= -1025;
        this.kCE &= -1025;
        this.kCF &= -1025;
        this.kCG &= -1025;
        this.kCH &= -1025;
        this.kCK &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.kDa = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.kDa);
            }
            this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
            this.aii = (TbImageView) this.kDa.findViewById(R.id.video_thumbnail);
            this.kCN = this.kDa.findViewById(R.id.black_mask);
            this.kCO = (TBLottieAnimationView) this.kDa.findViewById(R.id.video_loading);
            this.aij = (ImageView) this.kDa.findViewById(R.id.video_play);
            this.kCP = (PercentSizeView) this.kDa.findViewById(R.id.video_media_controller_mask);
            this.aik = (ImageView) this.kDa.findViewById(R.id.video_pause);
            this.ail = (TextView) this.kDa.findViewById(R.id.video_play_count);
            this.aim = (TextView) this.kDa.findViewById(R.id.video_play_flag);
            this.ain = (TextView) this.kDa.findViewById(R.id.video_duration);
            this.kCQ = (SwitchImageView) this.kDa.findViewById(R.id.video_mute);
            this.kCR = (SwitchImageView) this.kDa.findViewById(R.id.video_full_screen);
            this.kCS = (OperableVideoMediaControllerView) this.kDa.findViewById(R.id.video_media_controller);
            this.kCT = (OperableVideoNetworkStateTipView) this.kDa.findViewById(R.id.video_network_state_tip);
            this.kCU = (OperableVideoShareView) this.kDa.findViewById(R.id.video_share_view);
            this.kCW = this.kDa.findViewById(R.id.video_back_btn_mask);
            this.kCV = (ImageView) this.kDa.findViewById(R.id.video_full_screen_back);
            this.kCX = (VideoGestureView) this.kDa.findViewById(R.id.video_gesture);
            this.kCZ = (OperableVideoErrorView) this.kDa.findViewById(R.id.video_error_layout);
            this.kCU.setVideoContainer(this);
            this.kDd = new n(this.mContext);
            this.kDd.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cSd() && !d.this.air && !d.this.jHB && d.this.adG) {
                        if (!com.baidu.mcn.b.Lx().gg(d.this.kDq.jump_url)) {
                            boolean z = ((long) i2) >= d.this.kDq.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.kDq.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.kDq.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.hOD.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.boJ = d.this.kDq.card_title;
                                    aVar.boK = d.this.kDq.button_title;
                                    aVar.boL = d.this.kDq.jump_url;
                                    aVar.boI = d.this.kDq.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.ais;
                                    aVar.boM = d.this.cgM();
                                    if (z2) {
                                        d.this.hOD.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.hOD.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.hOD.isShowing()) {
                                d.this.hOD.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.kDr != null) {
                        d.this.kDr.cj(i, i2);
                    }
                }
            });
            this.kCO.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kCO.setVisibility(8);
                    d.this.aij.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.kCO.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aUW().a(this.aij, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.aij.setOnClickListener(this);
            this.kCQ.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.kCQ.setState(1);
            this.kCQ.setOnClickListener(this);
            this.aii.bhs();
            this.aii.setDrawCorner(false);
            this.aii.setPlaceHolder(3);
            this.kCS.setOnSeekBarChangeListener(this.ePf);
            this.kCP.setHeightPercent(0.583f);
            this.kCP.setBackgroundResource(R.drawable.video_mask_bg);
            this.kCR.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.kCR.setState(0);
            this.kCR.setOnClickListener(this);
            SvgManager.aUW().a(this.aik, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.aik.setOnClickListener(this);
            this.kCV.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
            this.kxZ = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
            this.kxZ.setTryUseViewInSet(true);
            cRS();
            this.kCT.setPlayViewOnClickListener(this);
            this.kDa.setOnClickListener(null);
            this.kDa.setOnTouchListener(this.evw);
            this.kCU.setOnTouchListener(this.evw);
            this.kCZ.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hxO);
            AU(this.kCA);
            this.hOD = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cRS() {
        if (this.kxZ != null && this.kxZ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kDa.addView(this.kxZ.getView(), 0);
            this.kxZ.getView().setLayoutParams(layoutParams);
            this.kCS.setPlayer(this.kxZ);
            if (cQi()) {
                ((QuickVideoView) this.kxZ).setNeedRecovery(true);
            }
            this.kxZ.setContinuePlayEnable(true);
            this.kxZ.setBusiness(this.kDd);
            this.kxZ.setOnPreparedListener(this);
            this.kxZ.setOnCompletionListener(this);
            this.kxZ.setOnErrorListener(this);
            this.kxZ.setOnSurfaceDestroyedListener(this);
            this.kxZ.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.aQQ() != null) {
            this.startPosition = -1L;
            if (this.hOD != null) {
                this.hOD.reset();
            }
            if (!aq.equals(this.mVideoUrl, bkVar.aQQ().video_url)) {
                stopPlay();
                this.air = bkVar.aQQ().is_vertical.intValue() == 1;
                this.mVideoUrl = bkVar.aQQ().video_url;
                this.ais = bkVar.getTid();
                this.ait = bkVar.aQQ().video_length.intValue();
                this.kDc = bkVar.aQQ().video_duration.intValue();
                this.mFid = bkVar.getFid();
                this.kDq = bkVar.aQQ().mcn_ad_card;
                cMf();
                cMg();
                AU(this.kCA);
                int intValue = bkVar.aQQ().video_duration.intValue() * 1000;
                this.kCS.BN(intValue);
                this.kCS.setPlayer(this.kxZ);
                this.ain.setText(aq.stringForVideoTime(intValue));
                this.ail.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bkVar.aQQ().play_count.intValue())));
                this.kCT.setVideoLength(bkVar.aQQ().video_length.intValue());
                this.kCT.setVideoDuration(bkVar.aQQ().video_duration.intValue());
                this.kCT.setTid(this.ais);
                this.kDd.cRl().an(bkVar);
                this.aim.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bkVar.aQQ().wth_mid_loc != null && bkVar.aQQ().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.aii.setScaleType(ImageView.ScaleType.MATRIX);
                    this.aii.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.air) {
                        this.ain.setText("");
                        this.ail.setText("");
                        this.aim.setVisibility(0);
                    }
                    this.aii.setSmartCropCenterPointWidthRatio(bkVar.aQQ().wth_mid_loc.floatValue());
                    this.aii.setSmartCropCenterPointHeightRatio(bkVar.aQQ().hth_mid_loc.floatValue());
                    this.aii.setOnDrawListener(this.ahi);
                }
                this.aii.setPlaceHolder(3);
                this.aii.startLoad(bkVar.aQQ().thumbnail_url, 10, false);
                this.kCU.setShareData(bkVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.ahG = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.kDd != null) {
            this.kDd.setVideoStatsData(yVar);
            this.kxZ.setBusiness(this.kDd);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cRl() {
        if (this.kDd == null) {
            return null;
        }
        return this.kDd.cRl();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aa(View.OnClickListener onClickListener) {
        this.adx = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.afZ = bdUniqueId;
    }

    public void cRT() {
        e.ld().removeCallbacks(this.kCM);
        e.ld().postDelayed(this.kCM, this.kCl);
    }

    public void cRU() {
        e.ld().removeCallbacks(this.kCM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.kCO.setAlpha(1.0f);
        this.kCO.setVisibility(0);
        this.aij.setVisibility(8);
        if (this.kCO != null) {
            this.kCO.loop(true);
            this.kCO.setMinAndMaxFrame(14, 80);
            this.kCO.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cMd() {
        if (this.kCK == this.kCC) {
            AU(this.kCB);
        }
    }

    private void cRV() {
        AU(this.kCC);
        this.kCS.showProgress();
        if (this.kCO != null) {
            this.kCO.clearAnimation();
            this.kCO.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cMd();
                    if (!d.this.kDb) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kCO.setVisibility(8);
                    d.this.aij.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cRW() {
        return this.kCT != null && this.kCT.cMn();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dyW);
            MessageManager.getInstance().registerListener(this.kDt);
            if (cRW()) {
                AU(this.kCH);
                return;
            }
            this.kDb = true;
            if (!this.kxZ.isPlaying()) {
                com.baidu.tieba.play.a.a KC = TbVideoViewSet.cRJ().KC(this.mVideoUrl);
                if (KC == null) {
                    this.kxZ.cRd();
                    if (!StringUtils.isNull(this.kxZ.getOriginUrl())) {
                        this.kxZ = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.kxZ.setTryUseViewInSet(true);
                    }
                    cRS();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kxZ.setVideoDuration(this.kDc);
                        this.kxZ.setVideoPath(this.mVideoUrl, this.ais);
                        startLoadingAnim();
                        if (this.kDe) {
                            cMl();
                        }
                    }
                } else {
                    if (this.kxZ == KC) {
                        if (this.kxZ.getParent() == null || this.kxZ.getParent() != KC.getParent()) {
                            this.kxZ.cRd();
                            cRS();
                        }
                    } else {
                        this.kxZ.cRd();
                        KC.cRd();
                        this.kxZ = KC;
                        this.kxZ.setTryUseViewInSet(true);
                        cRS();
                    }
                    this.kxZ.cQY();
                    onPrepared(null);
                    cSc();
                    if (this.kDe) {
                        cMl();
                    }
                }
                if (this.kDe) {
                    TiebaStatic.log(new an("c13357").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ag("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.kDb = false;
        if (this.kCO != null) {
            this.kCO.cancelAnimation();
        }
        this.kxZ.stop();
        this.kxZ.cRd();
        this.kCS.awd();
        AU(this.kCA);
        MessageManager.getInstance().unRegisterListener(this.dyW);
        MessageManager.getInstance().unRegisterListener(this.kDt);
    }

    private void cRX() {
        this.kDb = false;
        if (this.kCO != null) {
            this.kCO.cancelAnimation();
        }
        this.kxZ.stop();
        this.kCS.awd();
        AU(this.kCA);
        MessageManager.getInstance().unRegisterListener(this.dyW);
        MessageManager.getInstance().unRegisterListener(this.kDt);
    }

    public void cMl() {
        if (this.kDd != null && this.kDd.cRo() != null) {
            y cRF = this.kDd.cRo().cRF();
            cRF.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(cRF.kBw, "", "1", cRF, this.kxZ.getPcdnState());
        }
    }

    public void AU(int i) {
        cRU();
        if (this.kCK == this.kCI) {
            this.kCL = i;
            return;
        }
        this.kCK = i;
        this.aii.setVisibility((i & 1) > 0 ? 0 : 8);
        this.kCN.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.kCO.clearAnimation();
        this.kCO.setVisibility(z ? 0 : 8);
        if (!z) {
            this.kCO.cancelAnimation();
        } else {
            this.kCO.setAlpha(1.0f);
        }
        this.aij.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.aik.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ail.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.air && (homePageStyleAbTest & 4) != 0) {
            this.aim.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.ain.setVisibility((i & 16) > 0 ? 0 : 8);
        this.kCQ.setVisibility((i & 32) > 0 ? 0 : 8);
        this.kCR.setVisibility((i & 64) > 0 ? 0 : 8);
        this.kCS.setVisibility((i & 128) > 0 ? 0 : 8);
        this.kCP.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.kCS.getVisibility() == 0) {
            this.kCS.showProgress();
        }
        this.kCT.setVisibility((i & 256) > 0 ? 0 : 8);
        this.kCU.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.kCU.getVisibility() == 0) {
            this.kCU.setAlpha(1.0f);
        }
        this.kCV.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kCW.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kCX.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.kCZ.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            AV(id);
            if (id == R.id.video_mute) {
                cRZ();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cSb();
            } else if (id == R.id.video_replay) {
                AU(this.kCA);
                startPlay();
                if (this.kDe) {
                    TiebaStatic.log(new an("c13345").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_locate", this.jHB ? 1 : 2));
                }
                cRY();
            } else if (id == R.id.video_play) {
                if (this.kCK == this.kCA) {
                    startPlay();
                } else {
                    AU(this.kCD);
                    cRT();
                    this.kxZ.b(this.kDs);
                }
                if (this.kDe) {
                    TiebaStatic.log(new an("c13344").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_source", this.jHB ? 1 : 2).ag("obj_locate", 1));
                }
                cRY();
            } else if (id == R.id.video_pause) {
                AU(this.kCE);
                cRU();
                this.kxZ.pause();
                if (this.kDe) {
                    TiebaStatic.log(new an("c13344").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_source", this.jHB ? 1 : 2).ag("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                AU(this.kCA);
                startPlay();
            } else if (id == R.id.retry) {
                AU(this.kCA);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRY() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.afZ);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cMc() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.kxZ.setVolume(0.0f, 0.0f);
            this.kCQ.setState(1);
            return;
        }
        this.kxZ.setVolume(1.0f, 1.0f);
        this.kCQ.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cRZ() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.kxZ.setVolume(1.0f, 1.0f);
            ag.a(this.aio, true);
            this.kCQ.setState(0);
        } else {
            this.kxZ.setVolume(0.0f, 0.0f);
            this.kCQ.setState(1);
            ag.a(this.aio, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void ty(boolean z) {
        if (this.jbd == null) {
            this.jbd = new o((Activity) this.mContext);
        }
        if (z) {
            this.jbd.start();
            this.jbd.cc(true);
            return;
        }
        this.jbd.stop();
        this.jbd.cc(false);
    }

    public void cSa() {
        sI(true);
    }

    public void sI(boolean z) {
        if (this.mRootView != null && this.kDa != null && this.kxZ != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.kxZ.setFullScreenToDestroySurface();
            if (this.jbd == null) {
                this.jbd = new o((Activity) this.mContext);
            }
            if (this.jHB) {
                if (this.kCY.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kCY.getParent()).removeView(this.kCY);
                }
                if ((this.kDa.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.jHB = false;
                    this.kDf = true;
                    ((ViewGroup) this.kDa.getParent()).removeView(this.kDa);
                    ((ViewGroup) this.mRootView).addView(this.kDa);
                    this.kDf = false;
                    i((Activity) this.mContext, this.jHB);
                }
                if (!this.air && z) {
                    this.jbd.GV();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.air && z) {
                        this.jbd.GV();
                    }
                    if (this.mContext instanceof Activity) {
                        this.kDa.getLocationOnScreen(this.kDj);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.kDf = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.kCY == null) {
                                    this.kCY = new View(this.mContext);
                                    this.kCY.setClickable(true);
                                    this.kCY.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.kCY.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.kCY.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.kCY.getParent()).removeView(this.kCY);
                                }
                                this.kCY.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.kCY);
                                ((ViewGroup) childAt).addView(this.kDa);
                                this.kDf = false;
                                this.jHB = true;
                                i((Activity) this.mContext, this.jHB);
                                if (this.hOD != null && this.hOD.isShowing()) {
                                    this.hOD.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.kDe) {
                    TiebaStatic.log(new an("c13360").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2));
                }
            }
            cMf();
            cMg();
            if (this.kxZ.isPlaying()) {
                AU(this.kCB);
            } else {
                if (!this.isNewPlayer) {
                    this.kCK |= 1;
                }
                AU(this.kCK);
            }
            this.kCR.dmp();
            os(this.jHB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSb() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.air) {
            cSa();
        } else if (this.kCK == this.kCI) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.kDa.setScaleX(1.0f);
                    d.this.kDa.setScaleY(1.0f);
                    d.this.kDa.setTranslationX(0.0f);
                    d.this.kDa.setTranslationY(0.0f);
                    d.this.kCU.setScaleX(1.0f);
                    d.this.kCU.setScaleY(1.0f);
                    d.this.kDa.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.kDl) {
                        d.this.cSa();
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
            if (!this.kDl) {
                float width = this.mRootView.getWidth() / this.kDa.getWidth();
                float height = this.mRootView.getHeight() / this.kDa.getHeight();
                this.kDa.setPivotX(0.0f);
                this.kDa.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kDa, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.kDa, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.kCU, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.kCU, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.kDa, "TranslationX", this.kDa.getTranslationX(), this.kDj[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.kDa, "TranslationY", this.kDa.getTranslationY(), this.kDj[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.kCY, "alpha", this.kCY.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kCU, "alpha", this.kCU.getAlpha(), 0.0f);
            } else {
                float width2 = this.kDh / this.kDa.getWidth();
                float height2 = this.kDk / this.kDa.getHeight();
                this.kDa.setPivotX(0.0f);
                this.kDa.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kDa, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.kDa, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.kCU, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.kCU, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.kDa, "TranslationX", this.kDa.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.kDa, "TranslationY", this.kDa.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kCU, "alpha", this.kCU.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.kCL != -1) {
                this.kCK = this.kCL;
                this.kCL = -1;
                if (this.kCK == this.kCJ || this.kCK == this.kCD || this.kCK == this.kCB) {
                    this.kxZ.b(this.kDs);
                    AU(this.kCB);
                }
            }
        } else {
            cSa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.air && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.kDa != null) {
                    if (z) {
                        this.kDa.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.kDa.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cuf();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.kDa.setSystemUiVisibility(0);
            }
        }
    }

    private void cSc() {
        AU(this.kCC);
        this.kCS.showProgress();
        cRV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void os(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cMc();
        if (this.kDb) {
            if (this.jHB && (this.mContext instanceof Activity)) {
                i((Activity) this.mContext, true);
            }
            this.kxZ.b(this.kDs);
            if (cQi() && ((QuickVideoView) this.kxZ).kAd) {
                cRV();
            }
        }
    }

    public void onCompletion(g gVar) {
        AU(this.kCG);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        AU(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.isNewPlayer && !this.kDf) {
            if (this.kCK == this.kCE || (this.kCK == this.kCF && !this.kxZ.isPlaying())) {
                cRX();
                AU(this.kCE);
            } else if (this.kCK == this.kCG) {
                cRX();
                AU(this.kCG);
            } else {
                cRX();
            }
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cSc();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cQD() {
        return this.kDa;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.kDb || this.kxZ.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.kxZ.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void buW() {
    }

    protected void AV(int i) {
    }

    protected boolean J(MotionEvent motionEvent) {
        return this.jHB;
    }

    protected boolean cMe() {
        return this.air && this.jHB;
    }

    public boolean cQi() {
        return !this.isNewPlayer && (this.kxZ instanceof QuickVideoView);
    }

    private void cuf() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kDa.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kDa.setSystemUiVisibility(4);
        } else {
            this.kDa.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cMi() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.kxZ.isPlaying() && !ag.bgT()) {
            this.kxZ.setVolume(1.0f, 1.0f);
            this.kCQ.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cMj() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean or(boolean z) {
        if (z) {
            this.kCO.cancelAnimation();
            if (this.kCK == this.kCB || this.kCK == this.kCC || this.kCK == this.kCD || this.kCK == this.kCA) {
                stopPlay();
            }
            this.kCK |= 1;
            AU(this.kCK);
        } else if (this.kCK == this.kCA) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.jHB;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cRP() {
        if (this.jHB) {
            cSb();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cgM() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cSd() {
        return this.kDq != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tz(boolean z) {
        this.adG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.kDr = aVar;
    }
}
