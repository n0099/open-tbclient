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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.af;
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
    protected BdUniqueId MO;
    protected TbImageView OY;
    private ImageView OZ;
    private ImageView Pa;
    private TextView Pb;
    private TextView Pc;
    private TextView Pe;
    protected boolean Pi;
    protected String Pj;
    protected long Pk;
    private o eek;
    private com.baidu.mcn.c gNF;
    protected com.baidu.tieba.play.a.a jtu;
    private View jxR;
    private TBLottieAnimationView jxS;
    private PercentSizeView jxT;
    protected SwitchImageView jxU;
    protected SwitchImageView jxV;
    protected OperableVideoMediaControllerView jxW;
    protected OperableVideoNetworkStateTipView jxX;
    protected OperableVideoShareView jxY;
    protected ImageView jxZ;
    protected View jya;
    protected VideoGestureView jyb;
    private View jyc;
    private OperableVideoErrorView jyd;
    protected ViewGroup jye;
    protected boolean jyf;
    protected int jyg;
    protected n jyh;
    private float jyj;
    private float jyk;
    private int jyl;
    private int jyn;
    private boolean jyo;
    private float jyr;
    private int jys;
    private McnAdInfo jyt;
    private a jyu;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jxr = 3000;
    protected final int jxs = 1;
    protected final int jxt = 2;
    protected final int jxu = 4;
    protected final int jxv = 8;
    protected final int jxw = 16;
    protected final int jxx = 32;
    protected final int jxy = 64;
    protected final int jxz = 128;
    protected final int jxA = 256;
    protected final int jxB = 512;
    protected final int jxC = 1024;
    protected final int jxD = 2048;
    protected final int jxE = 4096;
    protected final int jxF = 8192;
    protected int STATE_STOP = 8211;
    protected int jxG = 0;
    protected int jxH = 4;
    protected int jxI = 232;
    protected int STATE_PAUSE = 8416;
    protected int jxJ = 0;
    protected int jxK = 513;
    protected int jxL = 259;
    protected int jxM = 2048;
    protected int jxN = 0;
    protected int STATE_ERROR = 4099;
    protected int jxO = this.STATE_STOP;
    private int iYI = 0;
    private int jxP = -1;
    private Runnable jxQ = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zy(d.this.jxG);
        }
    };
    private WeakReference<Context> Pf = null;
    protected boolean iDO = false;
    private boolean isNewPlayer = false;
    protected boolean jyi = true;
    private int[] jym = new int[2];
    private int jyp = 0;
    private int jyq = 0;
    protected View.OnClickListener Nh = null;
    protected View.OnClickListener Ke = null;
    private boolean Kn = false;
    private long startPosition = -1;
    protected boolean Ou = false;
    private TbImageView.c NT = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPQ().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), 10));
                if (vx != null) {
                    int width = vx.getWidth();
                    i = vx.getHeight();
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
                        if (d.this.Ou && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener dZZ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.zy(d.this.jxI);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jtu.isPlaying()) {
                    d.this.jtu.b(d.this.jyv);
                }
                d.this.czB();
                if (d.this.jyi) {
                    TiebaStatic.log(new an("c13355").cy("tid", d.this.Pj).s("fid", d.this.mFid).X("obj_type", d.this.Pi ? 1 : 2).X("obj_locate", d.this.iDO ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iYO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jtu.isPlaying()) {
                d.this.jtu.pause();
                if (d.this.jxO == d.this.jxI) {
                    d.this.zy(d.this.STATE_PAUSE);
                } else {
                    d.this.zy(d.this.jxJ);
                }
                d.this.zz(R.id.video_pause);
            } else if (d.this.jxO == d.this.STATE_PAUSE || d.this.jxO == (d.this.STATE_PAUSE | 1)) {
                d.this.zy(d.this.jxI);
                d.this.czB();
                d.this.jtu.b(d.this.jyv);
                d.this.zz(R.id.video_play);
            } else if (d.this.jxO == d.this.jxJ || d.this.jxO == (d.this.jxJ | 1)) {
                d.this.zy(d.this.jxG);
                d.this.jtu.b(d.this.jyv);
                d.this.zz(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jtu.isPlaying()) {
                if (d.this.jxO == d.this.jxG || d.this.jxO == d.this.jxH) {
                    d.this.zy(d.this.jxI);
                    d.this.czB();
                    return true;
                } else if (d.this.jxO == d.this.jxI) {
                    d.this.zy(d.this.jxG);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jxO == d.this.STATE_PAUSE) {
                d.this.zy(d.this.jxJ);
                return true;
            } else if (d.this.jxO == (d.this.STATE_PAUSE | 1)) {
                d.this.zy(d.this.jxJ | 1);
                return true;
            } else if (d.this.jxO == d.this.jxJ) {
                d.this.zy(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jxO == (d.this.jxJ | 1)) {
                d.this.zy(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zy(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.czF();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.iYI = 0;
            if (d.this.iDO) {
                d.this.h((Activity) d.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!d.this.E(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if ((d.this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.mContext).disableSwipeJustOnce();
            }
            if (d.this.Pi && d.this.ctP()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.iYI) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jtu.isPlaying()) {
                                d.this.jtu.pause();
                                d.this.zy(d.this.jxN);
                            }
                            d.this.iYI = 4;
                            d.this.jxP = d.this.jxO;
                            d.this.jxO = d.this.jxM;
                            d.this.jyn = d.this.jye.getMeasuredHeight();
                            d.this.jyr = d.this.jyk / d.this.jyn;
                            d.this.jys = (int) (1.2f * d.this.mRootView.getWidth());
                            cx(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cx(rawX, rawY);
                        break;
                }
            } else if (d.this.jxO == d.this.jxG || d.this.jxO == d.this.jxI || d.this.jxO == d.this.STATE_PAUSE || d.this.jxO == d.this.jxJ || d.this.jxO == d.this.jxM || d.this.jxO == (d.this.STATE_PAUSE | 1) || d.this.jxO == (d.this.jxJ | 1)) {
                switch (d.this.iYI) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.iYI = 3;
                            d.this.jyl = d.this.jtu.getCurrentPosition();
                            aI(f);
                        } else if (motionEvent.getX() < d.this.jye.getWidth() / 2) {
                            d.this.iYI = 2;
                            d.this.jyb.l(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.iYI = 1;
                            d.this.jyb.k(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jxO != d.this.jxM) {
                            if ((d.this.jxO & 1) > 0) {
                                d.this.jxM |= 1;
                            } else {
                                d.this.jxM &= -2;
                            }
                            d.this.zy(d.this.jxM);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jyb.k(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.ctV();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jyb.l(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aI(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cx(int i, int i2) {
            if (d.this.jyp != i2 || d.this.jyq != i) {
                d.this.jyo = d.this.jyp - i2 > 0 || ((float) i2) < d.this.jyj / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jye.getLayoutParams();
                if (i2 != d.this.jyp) {
                    int i3 = d.this.jyn - i2;
                    int i4 = (int) (i3 * d.this.jyr);
                    if (i4 < d.this.jys) {
                        i4 = d.this.jys;
                        i3 = (int) (i4 / d.this.jyr);
                    }
                    if (i4 != d.this.jys) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jye.setLayoutParams(layoutParams);
                    }
                    d.this.jyp = i2;
                    d.this.jye.setTranslationY(d.this.jyp);
                }
                if (i != d.this.jyp) {
                    d.this.jyq = i;
                    d.this.jye.setTranslationX(d.this.jyq + ((d.this.jyk - layoutParams.width) / 2.0f));
                }
                d.this.jyc.setAlpha((layoutParams.width - d.this.jys) / (d.this.jyk - d.this.jys));
                if (d.this.jxY.getVisibility() == 0) {
                    float f = d.this.jyj / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jxY.setAlpha(f2);
                }
            }
        }

        private void aI(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jyl -= 1000;
                z = true;
            } else {
                d.this.jyl += 1000;
                z = false;
            }
            int duration = d.this.jtu.getDuration();
            if (d.this.jyl < 0) {
                d.this.jyl = 0;
            } else if (d.this.jyl > duration) {
                d.this.jyl = duration;
            }
            String str = aq.stringForVideoTime(d.this.jyl) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jyb != null) {
                d.this.jyb.x(z, str);
            }
            d.this.jxW.setCurrentDuration(d.this.jyl, false);
        }
    };
    private View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jxO == d.this.jxM) {
                if (d.this.iYI == 4) {
                    d.this.czI();
                    d.this.jyp = 0;
                    d.this.jyq = 0;
                } else {
                    d.this.jxO = -1;
                    if (d.this.iYI != 3) {
                        if (d.this.jxP != -1) {
                            d.this.zy(d.this.jxP);
                            d.this.jxP = -1;
                        } else if (d.this.jtu.isPlaying()) {
                            d.this.zy(d.this.jxG);
                        } else {
                            d.this.zy(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jxW.setCurrentDuration(d.this.jyl, true);
                        if (d.this.jyl <= d.this.jtu.getDuration()) {
                            if (!d.this.jtu.isPlaying()) {
                                d.this.jtu.b(d.this.jyv);
                            }
                            d.this.zy(d.this.jxG);
                        }
                    }
                }
                if (d.this.jyi) {
                    String str = null;
                    if (d.this.iYI != 1) {
                        if (d.this.iYI != 2) {
                            if (d.this.iYI == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).cy("tid", d.this.Pj).s("fid", d.this.mFid));
                    }
                }
                d.this.iYI = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jyv = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czw() {
            d.this.jtu.cyR();
            d.this.czA();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czx() {
            d.this.zy(d.this.STATE_STOP);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener cLy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener jyw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.Pf, true);
                    }
                    d.this.jtu.setVolume(1.0f, 1.0f);
                    d.this.jxU.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.ctN();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bX(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.jyj = l.getEquipmentHeight(this.mContext);
            this.jyk = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ctT() {
        int dimension;
        int i;
        int i2;
        this.jxX.ah(this.Pi, this.iDO);
        this.jxY.ah(this.Pi, this.iDO);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.Pi) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.iDO) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.Pb.setPadding(0, 0, i2, 0);
            this.jxV.setPadding(this.jxV.getPaddingLeft(), 0, i, 0);
            this.jxU.setPadding(dimension, 0, 0, 0);
        }
    }

    public void ctS() {
        if (this.Pi) {
            this.jxI = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jxI = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iDO) {
            this.STATE_STOP |= 1024;
            this.jxG |= 1024;
            this.jxH |= 1024;
            this.jxI |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jxJ |= 1024;
            this.jxK |= 1024;
            this.jxL |= 1024;
            this.jxO |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jxG &= -1025;
        this.jxH &= -1025;
        this.jxI &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jxJ &= -1025;
        this.jxK &= -1025;
        this.jxL &= -1025;
        this.jxO &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jye = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jye);
            }
            this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
            this.OY = (TbImageView) this.jye.findViewById(R.id.video_thumbnail);
            this.jxR = this.jye.findViewById(R.id.black_mask);
            this.jxS = (TBLottieAnimationView) this.jye.findViewById(R.id.video_loading);
            this.OZ = (ImageView) this.jye.findViewById(R.id.video_play);
            this.jxT = (PercentSizeView) this.jye.findViewById(R.id.video_media_controller_mask);
            this.Pa = (ImageView) this.jye.findViewById(R.id.video_pause);
            this.Pb = (TextView) this.jye.findViewById(R.id.video_play_count);
            this.Pc = (TextView) this.jye.findViewById(R.id.video_play_flag);
            this.Pe = (TextView) this.jye.findViewById(R.id.video_duration);
            this.jxU = (SwitchImageView) this.jye.findViewById(R.id.video_mute);
            this.jxV = (SwitchImageView) this.jye.findViewById(R.id.video_full_screen);
            this.jxW = (OperableVideoMediaControllerView) this.jye.findViewById(R.id.video_media_controller);
            this.jxX = (OperableVideoNetworkStateTipView) this.jye.findViewById(R.id.video_network_state_tip);
            this.jxY = (OperableVideoShareView) this.jye.findViewById(R.id.video_share_view);
            this.jya = this.jye.findViewById(R.id.video_back_btn_mask);
            this.jxZ = (ImageView) this.jye.findViewById(R.id.video_full_screen_back);
            this.jyb = (VideoGestureView) this.jye.findViewById(R.id.video_gesture);
            this.jyd = (OperableVideoErrorView) this.jye.findViewById(R.id.video_error_layout);
            this.jxY.setVideoContainer(this);
            this.jyh = new n(this.mContext);
            this.jyh.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.czK() && !d.this.Pi && !d.this.iDO && d.this.Kn) {
                        if (!com.baidu.mcn.b.DG().eB(d.this.jyt.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jyt.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jyt.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jyt.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gNF.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLk = d.this.jyt.card_title;
                                    aVar.aLl = d.this.jyt.button_title;
                                    aVar.aLm = d.this.jyt.jump_url;
                                    aVar.aLj = d.this.jyt.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.Pj;
                                    aVar.aLn = d.this.bPl();
                                    if (z2) {
                                        d.this.gNF.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.gNF.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.gNF.isShowing()) {
                                d.this.gNF.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.jyu != null) {
                        d.this.jyu.bX(i, i2);
                    }
                }
            });
            this.jxS.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jxS.setVisibility(8);
                    d.this.OZ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jxS.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aGC().a(this.OZ, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.OZ.setOnClickListener(this);
            this.jxU.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jxU.setState(1);
            this.jxU.setOnClickListener(this);
            this.OY.aSS();
            this.OY.setDrawCorner(false);
            this.OY.setPlaceHolder(3);
            this.jxW.setOnSeekBarChangeListener(this.dZZ);
            this.jxT.setHeightPercent(0.583f);
            this.jxT.setBackgroundResource(R.drawable.video_mask_bg);
            this.jxV.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jxV.setState(0);
            this.jxV.setOnClickListener(this);
            SvgManager.aGC().a(this.Pa, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Pa.setOnClickListener(this);
            this.jxZ.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rH("cyber_player_test");
            this.jtu = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jtu.setTryUseViewInSet(true);
            czA();
            this.jxX.setPlayViewOnClickListener(this);
            this.jye.setOnClickListener(null);
            this.jye.setOnTouchListener(this.drA);
            this.jxY.setOnTouchListener(this.drA);
            this.jyd.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iYO);
            zy(this.STATE_STOP);
            this.gNF = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void czA() {
        if (this.jtu != null && this.jtu.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jye.addView(this.jtu.getView(), 0);
            this.jtu.getView().setLayoutParams(layoutParams);
            this.jxW.setPlayer(this.jtu);
            if (cxW()) {
                ((QuickVideoView) this.jtu).setNeedRecovery(true);
                ((QuickVideoView) this.jtu).setPlayerReuseEnable(true);
            }
            this.jtu.setContinuePlayEnable(true);
            this.jtu.setBusiness(this.jyh);
            this.jtu.setOnPreparedListener(this);
            this.jtu.setOnCompletionListener(this);
            this.jtu.setOnErrorListener(this);
            this.jtu.setOnSurfaceDestroyedListener(this);
            this.jtu.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCF() != null) {
            this.startPosition = -1L;
            if (this.gNF != null) {
                this.gNF.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aCF().video_url)) {
                stopPlay();
                this.Pi = bjVar.aCF().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aCF().video_url;
                this.Pj = bjVar.getTid();
                this.Pk = bjVar.aCF().video_length.intValue();
                this.jyg = bjVar.aCF().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.jyt = bjVar.aCF().mcn_ad_card;
                ctS();
                ctT();
                zy(this.STATE_STOP);
                int intValue = bjVar.aCF().video_duration.intValue() * 1000;
                this.jxW.At(intValue);
                this.jxW.setPlayer(this.jtu);
                this.Pe.setText(aq.stringForVideoTime(intValue));
                this.Pb.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aCF().play_count.intValue())));
                this.jxX.setVideoLength(bjVar.aCF().video_length.intValue());
                this.jxX.setVideoDuration(bjVar.aCF().video_duration.intValue());
                this.jxX.setTid(this.Pj);
                this.jyh.cyZ().aj(bjVar);
                this.Pc.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.aCF().wth_mid_loc != null && bjVar.aCF().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.OY.setScaleType(ImageView.ScaleType.MATRIX);
                    this.OY.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.Pi) {
                        this.Pe.setText("");
                        this.Pb.setText("");
                        this.Pc.setVisibility(0);
                    }
                    this.OY.setSmartCropCenterPointWidthRatio(bjVar.aCF().wth_mid_loc.floatValue());
                    this.OY.setSmartCropCenterPointHeightRatio(bjVar.aCF().hth_mid_loc.floatValue());
                    this.OY.setOnDrawListener(this.NT);
                }
                this.OY.setPlaceHolder(3);
                this.OY.startLoad(bjVar.aCF().thumbnail_url, 10, false);
                this.jxY.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ou = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jyh != null) {
            this.jyh.setVideoStatsData(yVar);
            this.jtu.setBusiness(this.jyh);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cyZ() {
        if (this.jyh == null) {
            return null;
        }
        return this.jyh.cyZ();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Z(View.OnClickListener onClickListener) {
        this.Ke = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.MO = bdUniqueId;
    }

    public void czB() {
        e.gx().removeCallbacks(this.jxQ);
        e.gx().postDelayed(this.jxQ, this.jxr);
    }

    public void czC() {
        e.gx().removeCallbacks(this.jxQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jxS.setAlpha(1.0f);
        this.jxS.setVisibility(0);
        this.OZ.setVisibility(8);
        if (this.jxS != null) {
            this.jxS.loop(true);
            this.jxS.setMinAndMaxFrame(14, 80);
            this.jxS.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ctO() {
        if (this.jxO == this.jxH) {
            zy(this.jxG);
        }
    }

    private void czD() {
        zy(this.jxH);
        this.jxW.showProgress();
        if (this.jxS != null) {
            this.jxS.clearAnimation();
            this.jxS.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.ctO();
                    if (!d.this.jyf) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jxS.setVisibility(8);
                    d.this.OZ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean ctR() {
        return this.jxX != null && this.jxX.cub();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.cLy);
            MessageManager.getInstance().registerListener(this.jyw);
            if (ctR()) {
                zy(this.jxL);
                return;
            }
            this.jyf = true;
            if (!this.jtu.isPlaying()) {
                com.baidu.tieba.play.a.a He = TbVideoViewSet.czv().He(this.mVideoUrl);
                if (He == null) {
                    this.jtu.cyR();
                    if (!StringUtils.isNull(this.jtu.getOriginUrl())) {
                        this.jtu = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.jtu.setTryUseViewInSet(true);
                    }
                    czA();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jtu.setVideoDuration(this.jyg);
                        this.jtu.setVideoPath(this.mVideoUrl, this.Pj);
                        startLoadingAnim();
                        if (this.jyi) {
                            ctZ();
                        }
                    }
                } else {
                    if (this.jtu == He) {
                        if (this.jtu.getParent() == null || this.jtu.getParent() != He.getParent()) {
                            this.jtu.cyR();
                            czA();
                        }
                    } else {
                        this.jtu.cyR();
                        He.cyR();
                        this.jtu = He;
                        this.jtu.setTryUseViewInSet(true);
                        czA();
                    }
                    this.jtu.cyM();
                    onPrepared(null);
                    czJ();
                    if (this.jyi) {
                        ctZ();
                    }
                }
                if (this.jyi) {
                    TiebaStatic.log(new an("c13357").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).X("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jyf = false;
        if (this.jxS != null) {
            this.jxS.cancelAnimation();
        }
        this.jtu.stop();
        this.jtu.cyR();
        this.jxW.akj();
        zy(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLy);
        MessageManager.getInstance().unRegisterListener(this.jyw);
    }

    private void czE() {
        this.jyf = false;
        if (this.jxS != null) {
            this.jxS.cancelAnimation();
        }
        this.jtu.stop();
        this.jxW.akj();
        zy(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLy);
        MessageManager.getInstance().unRegisterListener(this.jyw);
    }

    public void ctZ() {
        if (this.jyh != null && this.jyh.czc() != null) {
            y czt = this.jyh.czc().czt();
            czt.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(czt.jwK, "", "1", czt);
        }
    }

    public void zy(int i) {
        czC();
        if (this.jxO == this.jxM) {
            this.jxP = i;
            return;
        }
        this.jxO = i;
        this.OY.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jxR.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jxS.clearAnimation();
        this.jxS.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jxS.cancelAnimation();
        } else {
            this.jxS.setAlpha(1.0f);
        }
        this.OZ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Pa.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Pb.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.Pi && (homePageStyleAbTest & 4) != 0) {
            this.Pc.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.Pe.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jxU.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jxV.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jxW.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jxT.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jxW.getVisibility() == 0) {
            this.jxW.showProgress();
        }
        this.jxX.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jxY.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jxY.getVisibility() == 0) {
            this.jxY.setAlpha(1.0f);
        }
        this.jxZ.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jya.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jyb.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jyd.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zz(id);
            if (id == R.id.video_mute) {
                czG();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                czI();
            } else if (id == R.id.video_replay) {
                zy(this.STATE_STOP);
                startPlay();
                if (this.jyi) {
                    TiebaStatic.log(new an("c13345").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_locate", this.iDO ? 1 : 2));
                }
                czF();
            } else if (id == R.id.video_play) {
                if (this.jxO == this.STATE_STOP) {
                    startPlay();
                } else {
                    zy(this.jxI);
                    czB();
                    this.jtu.b(this.jyv);
                }
                if (this.jyi) {
                    TiebaStatic.log(new an("c13344").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", this.iDO ? 1 : 2).X("obj_locate", 1));
                }
                czF();
            } else if (id == R.id.video_pause) {
                zy(this.STATE_PAUSE);
                czC();
                this.jtu.pause();
                if (this.jyi) {
                    TiebaStatic.log(new an("c13344").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", this.iDO ? 1 : 2).X("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                zy(this.STATE_STOP);
                startPlay();
            } else if (id == R.id.retry) {
                zy(this.STATE_STOP);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czF() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.MO);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void ctN() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jtu.setVolume(0.0f, 0.0f);
            this.jxU.setState(1);
            return;
        }
        this.jtu.setVolume(1.0f, 1.0f);
        this.jxU.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czG() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jtu.setVolume(1.0f, 1.0f);
            af.a(this.Pf, true);
            this.jxU.setState(0);
        } else {
            this.jtu.setVolume(0.0f, 0.0f);
            this.jxU.setState(1);
            af.a(this.Pf, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void rQ(boolean z) {
        if (this.eek == null) {
            this.eek = new o((Activity) this.mContext);
        }
        if (z) {
            this.eek.start();
            this.eek.bn(true);
            return;
        }
        this.eek.stop();
        this.eek.bn(false);
    }

    public void czH() {
        ra(true);
    }

    public void ra(boolean z) {
        if (this.mRootView != null && this.jye != null && this.jtu != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jtu.setFullScreenToDestroySurface();
            if (this.eek == null) {
                this.eek = new o((Activity) this.mContext);
            }
            if (this.iDO) {
                if (this.jyc.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jyc.getParent()).removeView(this.jyc);
                }
                if ((this.jye.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iDO = false;
                    ((ViewGroup) this.jye.getParent()).removeView(this.jye);
                    ((ViewGroup) this.mRootView).addView(this.jye);
                    h((Activity) this.mContext, this.iDO);
                }
                if (!this.Pi && z) {
                    this.eek.Aa();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.Pi && z) {
                        this.eek.Aa();
                    }
                    if (this.mContext instanceof Activity) {
                        this.jye.getLocationOnScreen(this.jym);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jyc == null) {
                                    this.jyc = new View(this.mContext);
                                    this.jyc.setClickable(true);
                                    this.jyc.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jyc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jyc.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jyc.getParent()).removeView(this.jyc);
                                }
                                this.jyc.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jyc);
                                ((ViewGroup) childAt).addView(this.jye);
                                this.iDO = true;
                                h((Activity) this.mContext, this.iDO);
                                if (this.gNF != null && this.gNF.isShowing()) {
                                    this.gNF.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jyi) {
                    TiebaStatic.log(new an("c13360").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2));
                }
            }
            ctS();
            ctT();
            if (this.jtu.isPlaying()) {
                zy(this.jxG);
            } else {
                this.jxO |= 1;
                zy(this.jxO);
            }
            this.jxV.cTC();
            mM(this.iDO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czI() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.Pi) {
            czH();
        } else if (this.jxO == this.jxM) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jye.setScaleX(1.0f);
                    d.this.jye.setScaleY(1.0f);
                    d.this.jye.setTranslationX(0.0f);
                    d.this.jye.setTranslationY(0.0f);
                    d.this.jxY.setScaleX(1.0f);
                    d.this.jxY.setScaleY(1.0f);
                    d.this.jye.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jyo) {
                        d.this.czH();
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
            if (!this.jyo) {
                float width = this.mRootView.getWidth() / this.jye.getWidth();
                float height = this.mRootView.getHeight() / this.jye.getHeight();
                this.jye.setPivotX(0.0f);
                this.jye.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jye, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jye, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxY, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxY, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jye, "TranslationX", this.jye.getTranslationX(), this.jym[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jye, "TranslationY", this.jye.getTranslationY(), this.jym[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jyc, "alpha", this.jyc.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxY, "alpha", this.jxY.getAlpha(), 0.0f);
            } else {
                float width2 = this.jyk / this.jye.getWidth();
                float height2 = this.jyn / this.jye.getHeight();
                this.jye.setPivotX(0.0f);
                this.jye.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jye, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jye, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxY, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxY, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jye, "TranslationX", this.jye.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jye, "TranslationY", this.jye.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxY, "alpha", this.jxY.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jxP != -1) {
                this.jxO = this.jxP;
                this.jxP = -1;
                if (this.jxO == this.jxN || this.jxO == this.jxI || this.jxO == this.jxG) {
                    this.jtu.b(this.jyv);
                    zy(this.jxG);
                }
            }
        } else {
            czH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.Pi && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jye != null) {
                    if (z) {
                        this.jye.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jye.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                ccB();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.jye.setSystemUiVisibility(0);
            }
        }
    }

    private void czJ() {
        zy(this.jxH);
        this.jxW.showProgress();
        czD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mM(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        ctN();
        if (this.jyf) {
            if (this.iDO && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jtu.b(this.jyv);
            if (cxW() && ((QuickVideoView) this.jtu).jvv) {
                czD();
            }
        }
    }

    public void onCompletion(g gVar) {
        zy(this.jxK);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zy(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jxO == this.STATE_PAUSE || (this.jxO == this.jxJ && !this.jtu.isPlaying())) {
            czE();
            zy(this.STATE_PAUSE);
        } else if (this.jxO == this.jxK) {
            czE();
            zy(this.jxK);
        } else {
            czE();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            czJ();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cyr() {
        return this.jye;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jyf || this.jtu.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jtu.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bfI() {
    }

    protected void zz(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.iDO;
    }

    protected boolean ctP() {
        return this.Pi && this.iDO;
    }

    public boolean cxW() {
        return !this.isNewPlayer && (this.jtu instanceof QuickVideoView);
    }

    private void ccB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jye.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jye.setSystemUiVisibility(4);
        } else {
            this.jye.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean ctV() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jtu.isPlaying() && !af.aSv()) {
            this.jtu.setVolume(1.0f, 1.0f);
            this.jxU.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean ctW() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        if (z) {
            this.jxS.cancelAnimation();
            if (this.jxO == this.jxG || this.jxO == this.jxH || this.jxO == this.jxI || this.jxO == this.STATE_STOP) {
                stopPlay();
            }
            this.jxO |= 1;
            zy(this.jxO);
        } else if (this.jxO == this.STATE_STOP) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.iDO;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.iDO) {
            czI();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int bPl() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean czK() {
        return this.jyt != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rR(boolean z) {
        this.Kn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jyu = aVar;
    }
}
