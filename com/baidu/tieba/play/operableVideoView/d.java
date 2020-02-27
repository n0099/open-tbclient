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
    private o eej;
    private com.baidu.mcn.c gND;
    protected com.baidu.tieba.play.a.a jts;
    private View jxP;
    private TBLottieAnimationView jxQ;
    private PercentSizeView jxR;
    protected SwitchImageView jxS;
    protected SwitchImageView jxT;
    protected OperableVideoMediaControllerView jxU;
    protected OperableVideoNetworkStateTipView jxV;
    protected OperableVideoShareView jxW;
    protected ImageView jxX;
    protected View jxY;
    protected VideoGestureView jxZ;
    private View jya;
    private OperableVideoErrorView jyb;
    protected ViewGroup jyc;
    protected boolean jyd;
    protected int jye;
    protected n jyf;
    private float jyh;
    private float jyi;
    private int jyj;
    private int jyl;
    private boolean jym;
    private float jyp;
    private int jyq;
    private McnAdInfo jyr;
    private a jys;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jxp = 3000;
    protected final int jxq = 1;
    protected final int jxr = 2;
    protected final int jxs = 4;
    protected final int jxt = 8;
    protected final int jxu = 16;
    protected final int jxv = 32;
    protected final int jxw = 64;
    protected final int jxx = 128;
    protected final int jxy = 256;
    protected final int jxz = 512;
    protected final int jxA = 1024;
    protected final int jxB = 2048;
    protected final int jxC = 4096;
    protected final int jxD = 8192;
    protected int STATE_STOP = 8211;
    protected int jxE = 0;
    protected int jxF = 4;
    protected int jxG = 232;
    protected int STATE_PAUSE = 8416;
    protected int jxH = 0;
    protected int jxI = 513;
    protected int jxJ = 259;
    protected int jxK = 2048;
    protected int jxL = 0;
    protected int STATE_ERROR = 4099;
    protected int jxM = this.STATE_STOP;
    private int iYG = 0;
    private int jxN = -1;
    private Runnable jxO = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zy(d.this.jxE);
        }
    };
    private WeakReference<Context> Pf = null;
    protected boolean iDM = false;
    private boolean isNewPlayer = false;
    protected boolean jyg = true;
    private int[] jyk = new int[2];
    private int jyn = 0;
    private int jyo = 0;
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
                com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPO().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), 10));
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
    private SeekBar.OnSeekBarChangeListener dZY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.zy(d.this.jxG);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jts.isPlaying()) {
                    d.this.jts.b(d.this.jyt);
                }
                d.this.czz();
                if (d.this.jyg) {
                    TiebaStatic.log(new an("c13355").cy("tid", d.this.Pj).s("fid", d.this.mFid).X("obj_type", d.this.Pi ? 1 : 2).X("obj_locate", d.this.iDM ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iYM = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jts.isPlaying()) {
                d.this.jts.pause();
                if (d.this.jxM == d.this.jxG) {
                    d.this.zy(d.this.STATE_PAUSE);
                } else {
                    d.this.zy(d.this.jxH);
                }
                d.this.zz(R.id.video_pause);
            } else if (d.this.jxM == d.this.STATE_PAUSE || d.this.jxM == (d.this.STATE_PAUSE | 1)) {
                d.this.zy(d.this.jxG);
                d.this.czz();
                d.this.jts.b(d.this.jyt);
                d.this.zz(R.id.video_play);
            } else if (d.this.jxM == d.this.jxH || d.this.jxM == (d.this.jxH | 1)) {
                d.this.zy(d.this.jxE);
                d.this.jts.b(d.this.jyt);
                d.this.zz(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jts.isPlaying()) {
                if (d.this.jxM == d.this.jxE || d.this.jxM == d.this.jxF) {
                    d.this.zy(d.this.jxG);
                    d.this.czz();
                    return true;
                } else if (d.this.jxM == d.this.jxG) {
                    d.this.zy(d.this.jxE);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jxM == d.this.STATE_PAUSE) {
                d.this.zy(d.this.jxH);
                return true;
            } else if (d.this.jxM == (d.this.STATE_PAUSE | 1)) {
                d.this.zy(d.this.jxH | 1);
                return true;
            } else if (d.this.jxM == d.this.jxH) {
                d.this.zy(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jxM == (d.this.jxH | 1)) {
                d.this.zy(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zy(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.czD();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.iYG = 0;
            if (d.this.iDM) {
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
            if (d.this.Pi && d.this.ctN()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.iYG) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jts.isPlaying()) {
                                d.this.jts.pause();
                                d.this.zy(d.this.jxL);
                            }
                            d.this.iYG = 4;
                            d.this.jxN = d.this.jxM;
                            d.this.jxM = d.this.jxK;
                            d.this.jyl = d.this.jyc.getMeasuredHeight();
                            d.this.jyp = d.this.jyi / d.this.jyl;
                            d.this.jyq = (int) (1.2f * d.this.mRootView.getWidth());
                            cx(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cx(rawX, rawY);
                        break;
                }
            } else if (d.this.jxM == d.this.jxE || d.this.jxM == d.this.jxG || d.this.jxM == d.this.STATE_PAUSE || d.this.jxM == d.this.jxH || d.this.jxM == d.this.jxK || d.this.jxM == (d.this.STATE_PAUSE | 1) || d.this.jxM == (d.this.jxH | 1)) {
                switch (d.this.iYG) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.iYG = 3;
                            d.this.jyj = d.this.jts.getCurrentPosition();
                            aI(f);
                        } else if (motionEvent.getX() < d.this.jyc.getWidth() / 2) {
                            d.this.iYG = 2;
                            d.this.jxZ.l(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.iYG = 1;
                            d.this.jxZ.k(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jxM != d.this.jxK) {
                            if ((d.this.jxM & 1) > 0) {
                                d.this.jxK |= 1;
                            } else {
                                d.this.jxK &= -2;
                            }
                            d.this.zy(d.this.jxK);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jxZ.k(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.ctT();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jxZ.l(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aI(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cx(int i, int i2) {
            if (d.this.jyn != i2 || d.this.jyo != i) {
                d.this.jym = d.this.jyn - i2 > 0 || ((float) i2) < d.this.jyh / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jyc.getLayoutParams();
                if (i2 != d.this.jyn) {
                    int i3 = d.this.jyl - i2;
                    int i4 = (int) (i3 * d.this.jyp);
                    if (i4 < d.this.jyq) {
                        i4 = d.this.jyq;
                        i3 = (int) (i4 / d.this.jyp);
                    }
                    if (i4 != d.this.jyq) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jyc.setLayoutParams(layoutParams);
                    }
                    d.this.jyn = i2;
                    d.this.jyc.setTranslationY(d.this.jyn);
                }
                if (i != d.this.jyn) {
                    d.this.jyo = i;
                    d.this.jyc.setTranslationX(d.this.jyo + ((d.this.jyi - layoutParams.width) / 2.0f));
                }
                d.this.jya.setAlpha((layoutParams.width - d.this.jyq) / (d.this.jyi - d.this.jyq));
                if (d.this.jxW.getVisibility() == 0) {
                    float f = d.this.jyh / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jxW.setAlpha(f2);
                }
            }
        }

        private void aI(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jyj -= 1000;
                z = true;
            } else {
                d.this.jyj += 1000;
                z = false;
            }
            int duration = d.this.jts.getDuration();
            if (d.this.jyj < 0) {
                d.this.jyj = 0;
            } else if (d.this.jyj > duration) {
                d.this.jyj = duration;
            }
            String str = aq.stringForVideoTime(d.this.jyj) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jxZ != null) {
                d.this.jxZ.x(z, str);
            }
            d.this.jxU.setCurrentDuration(d.this.jyj, false);
        }
    };
    private View.OnTouchListener drz = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jxM == d.this.jxK) {
                if (d.this.iYG == 4) {
                    d.this.czG();
                    d.this.jyn = 0;
                    d.this.jyo = 0;
                } else {
                    d.this.jxM = -1;
                    if (d.this.iYG != 3) {
                        if (d.this.jxN != -1) {
                            d.this.zy(d.this.jxN);
                            d.this.jxN = -1;
                        } else if (d.this.jts.isPlaying()) {
                            d.this.zy(d.this.jxE);
                        } else {
                            d.this.zy(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jxU.setCurrentDuration(d.this.jyj, true);
                        if (d.this.jyj <= d.this.jts.getDuration()) {
                            if (!d.this.jts.isPlaying()) {
                                d.this.jts.b(d.this.jyt);
                            }
                            d.this.zy(d.this.jxE);
                        }
                    }
                }
                if (d.this.jyg) {
                    String str = null;
                    if (d.this.iYG != 1) {
                        if (d.this.iYG != 2) {
                            if (d.this.iYG == 3) {
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
                d.this.iYG = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jyt = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czu() {
            d.this.jts.cyP();
            d.this.czy();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czv() {
            d.this.zy(d.this.STATE_STOP);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener cLx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener jyu = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.Pf, true);
                    }
                    d.this.jts.setVolume(1.0f, 1.0f);
                    d.this.jxS.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.ctL();
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
            this.jyh = l.getEquipmentHeight(this.mContext);
            this.jyi = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ctR() {
        int dimension;
        int i;
        int i2;
        this.jxV.ah(this.Pi, this.iDM);
        this.jxW.ah(this.Pi, this.iDM);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.Pi) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.iDM) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.Pb.setPadding(0, 0, i2, 0);
            this.jxT.setPadding(this.jxT.getPaddingLeft(), 0, i, 0);
            this.jxS.setPadding(dimension, 0, 0, 0);
        }
    }

    public void ctQ() {
        if (this.Pi) {
            this.jxG = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jxG = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iDM) {
            this.STATE_STOP |= 1024;
            this.jxE |= 1024;
            this.jxF |= 1024;
            this.jxG |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jxH |= 1024;
            this.jxI |= 1024;
            this.jxJ |= 1024;
            this.jxM |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jxE &= -1025;
        this.jxF &= -1025;
        this.jxG &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jxH &= -1025;
        this.jxI &= -1025;
        this.jxJ &= -1025;
        this.jxM &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jyc = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jyc);
            }
            this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
            this.OY = (TbImageView) this.jyc.findViewById(R.id.video_thumbnail);
            this.jxP = this.jyc.findViewById(R.id.black_mask);
            this.jxQ = (TBLottieAnimationView) this.jyc.findViewById(R.id.video_loading);
            this.OZ = (ImageView) this.jyc.findViewById(R.id.video_play);
            this.jxR = (PercentSizeView) this.jyc.findViewById(R.id.video_media_controller_mask);
            this.Pa = (ImageView) this.jyc.findViewById(R.id.video_pause);
            this.Pb = (TextView) this.jyc.findViewById(R.id.video_play_count);
            this.Pc = (TextView) this.jyc.findViewById(R.id.video_play_flag);
            this.Pe = (TextView) this.jyc.findViewById(R.id.video_duration);
            this.jxS = (SwitchImageView) this.jyc.findViewById(R.id.video_mute);
            this.jxT = (SwitchImageView) this.jyc.findViewById(R.id.video_full_screen);
            this.jxU = (OperableVideoMediaControllerView) this.jyc.findViewById(R.id.video_media_controller);
            this.jxV = (OperableVideoNetworkStateTipView) this.jyc.findViewById(R.id.video_network_state_tip);
            this.jxW = (OperableVideoShareView) this.jyc.findViewById(R.id.video_share_view);
            this.jxY = this.jyc.findViewById(R.id.video_back_btn_mask);
            this.jxX = (ImageView) this.jyc.findViewById(R.id.video_full_screen_back);
            this.jxZ = (VideoGestureView) this.jyc.findViewById(R.id.video_gesture);
            this.jyb = (OperableVideoErrorView) this.jyc.findViewById(R.id.video_error_layout);
            this.jxW.setVideoContainer(this);
            this.jyf = new n(this.mContext);
            this.jyf.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.czI() && !d.this.Pi && !d.this.iDM && d.this.Kn) {
                        if (!com.baidu.mcn.b.DE().eB(d.this.jyr.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jyr.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jyr.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jyr.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gND.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLj = d.this.jyr.card_title;
                                    aVar.aLk = d.this.jyr.button_title;
                                    aVar.aLl = d.this.jyr.jump_url;
                                    aVar.aLi = d.this.jyr.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.Pj;
                                    aVar.aLm = d.this.bPj();
                                    if (z2) {
                                        d.this.gND.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.gND.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.gND.isShowing()) {
                                d.this.gND.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.jys != null) {
                        d.this.jys.bX(i, i2);
                    }
                }
            });
            this.jxQ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jxQ.setVisibility(8);
                    d.this.OZ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jxQ.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aGA().a(this.OZ, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.OZ.setOnClickListener(this);
            this.jxS.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jxS.setState(1);
            this.jxS.setOnClickListener(this);
            this.OY.aSQ();
            this.OY.setDrawCorner(false);
            this.OY.setPlaceHolder(3);
            this.jxU.setOnSeekBarChangeListener(this.dZY);
            this.jxR.setHeightPercent(0.583f);
            this.jxR.setBackgroundResource(R.drawable.video_mask_bg);
            this.jxT.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jxT.setState(0);
            this.jxT.setOnClickListener(this);
            SvgManager.aGA().a(this.Pa, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Pa.setOnClickListener(this);
            this.jxX.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rH("cyber_player_test");
            this.jts = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jts.setTryUseViewInSet(true);
            czy();
            this.jxV.setPlayViewOnClickListener(this);
            this.jyc.setOnClickListener(null);
            this.jyc.setOnTouchListener(this.drz);
            this.jxW.setOnTouchListener(this.drz);
            this.jyb.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iYM);
            zy(this.STATE_STOP);
            this.gND = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void czy() {
        if (this.jts != null && this.jts.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jyc.addView(this.jts.getView(), 0);
            this.jts.getView().setLayoutParams(layoutParams);
            this.jxU.setPlayer(this.jts);
            if (cxU()) {
                ((QuickVideoView) this.jts).setNeedRecovery(true);
                ((QuickVideoView) this.jts).setPlayerReuseEnable(true);
            }
            this.jts.setContinuePlayEnable(true);
            this.jts.setBusiness(this.jyf);
            this.jts.setOnPreparedListener(this);
            this.jts.setOnCompletionListener(this);
            this.jts.setOnErrorListener(this);
            this.jts.setOnSurfaceDestroyedListener(this);
            this.jts.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCD() != null) {
            this.startPosition = -1L;
            if (this.gND != null) {
                this.gND.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aCD().video_url)) {
                stopPlay();
                this.Pi = bjVar.aCD().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aCD().video_url;
                this.Pj = bjVar.getTid();
                this.Pk = bjVar.aCD().video_length.intValue();
                this.jye = bjVar.aCD().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.jyr = bjVar.aCD().mcn_ad_card;
                ctQ();
                ctR();
                zy(this.STATE_STOP);
                int intValue = bjVar.aCD().video_duration.intValue() * 1000;
                this.jxU.At(intValue);
                this.jxU.setPlayer(this.jts);
                this.Pe.setText(aq.stringForVideoTime(intValue));
                this.Pb.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aCD().play_count.intValue())));
                this.jxV.setVideoLength(bjVar.aCD().video_length.intValue());
                this.jxV.setVideoDuration(bjVar.aCD().video_duration.intValue());
                this.jxV.setTid(this.Pj);
                this.jyf.cyX().aj(bjVar);
                this.Pc.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.aCD().wth_mid_loc != null && bjVar.aCD().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.OY.setScaleType(ImageView.ScaleType.MATRIX);
                    this.OY.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.Pi) {
                        this.Pe.setText("");
                        this.Pb.setText("");
                        this.Pc.setVisibility(0);
                    }
                    this.OY.setSmartCropCenterPointWidthRatio(bjVar.aCD().wth_mid_loc.floatValue());
                    this.OY.setSmartCropCenterPointHeightRatio(bjVar.aCD().hth_mid_loc.floatValue());
                    this.OY.setOnDrawListener(this.NT);
                }
                this.OY.setPlaceHolder(3);
                this.OY.startLoad(bjVar.aCD().thumbnail_url, 10, false);
                this.jxW.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ou = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jyf != null) {
            this.jyf.setVideoStatsData(yVar);
            this.jts.setBusiness(this.jyf);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cyX() {
        if (this.jyf == null) {
            return null;
        }
        return this.jyf.cyX();
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

    public void czz() {
        e.gx().removeCallbacks(this.jxO);
        e.gx().postDelayed(this.jxO, this.jxp);
    }

    public void czA() {
        e.gx().removeCallbacks(this.jxO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jxQ.setAlpha(1.0f);
        this.jxQ.setVisibility(0);
        this.OZ.setVisibility(8);
        if (this.jxQ != null) {
            this.jxQ.loop(true);
            this.jxQ.setMinAndMaxFrame(14, 80);
            this.jxQ.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ctM() {
        if (this.jxM == this.jxF) {
            zy(this.jxE);
        }
    }

    private void czB() {
        zy(this.jxF);
        this.jxU.showProgress();
        if (this.jxQ != null) {
            this.jxQ.clearAnimation();
            this.jxQ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.ctM();
                    if (!d.this.jyd) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jxQ.setVisibility(8);
                    d.this.OZ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean ctP() {
        return this.jxV != null && this.jxV.ctZ();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.cLx);
            MessageManager.getInstance().registerListener(this.jyu);
            if (ctP()) {
                zy(this.jxJ);
                return;
            }
            this.jyd = true;
            if (!this.jts.isPlaying()) {
                com.baidu.tieba.play.a.a He = TbVideoViewSet.czt().He(this.mVideoUrl);
                if (He == null) {
                    this.jts.cyP();
                    if (!StringUtils.isNull(this.jts.getOriginUrl())) {
                        this.jts = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.jts.setTryUseViewInSet(true);
                    }
                    czy();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jts.setVideoDuration(this.jye);
                        this.jts.setVideoPath(this.mVideoUrl, this.Pj);
                        startLoadingAnim();
                        if (this.jyg) {
                            ctX();
                        }
                    }
                } else {
                    if (this.jts == He) {
                        if (this.jts.getParent() == null || this.jts.getParent() != He.getParent()) {
                            this.jts.cyP();
                            czy();
                        }
                    } else {
                        this.jts.cyP();
                        He.cyP();
                        this.jts = He;
                        this.jts.setTryUseViewInSet(true);
                        czy();
                    }
                    this.jts.cyK();
                    onPrepared(null);
                    czH();
                    if (this.jyg) {
                        ctX();
                    }
                }
                if (this.jyg) {
                    TiebaStatic.log(new an("c13357").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).X("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jyd = false;
        if (this.jxQ != null) {
            this.jxQ.cancelAnimation();
        }
        this.jts.stop();
        this.jts.cyP();
        this.jxU.akh();
        zy(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLx);
        MessageManager.getInstance().unRegisterListener(this.jyu);
    }

    private void czC() {
        this.jyd = false;
        if (this.jxQ != null) {
            this.jxQ.cancelAnimation();
        }
        this.jts.stop();
        this.jxU.akh();
        zy(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLx);
        MessageManager.getInstance().unRegisterListener(this.jyu);
    }

    public void ctX() {
        if (this.jyf != null && this.jyf.cza() != null) {
            y czr = this.jyf.cza().czr();
            czr.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(czr.jwI, "", "1", czr);
        }
    }

    public void zy(int i) {
        czA();
        if (this.jxM == this.jxK) {
            this.jxN = i;
            return;
        }
        this.jxM = i;
        this.OY.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jxP.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jxQ.clearAnimation();
        this.jxQ.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jxQ.cancelAnimation();
        } else {
            this.jxQ.setAlpha(1.0f);
        }
        this.OZ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Pa.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Pb.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.Pi && (homePageStyleAbTest & 4) != 0) {
            this.Pc.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.Pe.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jxS.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jxT.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jxU.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jxR.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jxU.getVisibility() == 0) {
            this.jxU.showProgress();
        }
        this.jxV.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jxW.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jxW.getVisibility() == 0) {
            this.jxW.setAlpha(1.0f);
        }
        this.jxX.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jxY.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jxZ.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jyb.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zz(id);
            if (id == R.id.video_mute) {
                czE();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                czG();
            } else if (id == R.id.video_replay) {
                zy(this.STATE_STOP);
                startPlay();
                if (this.jyg) {
                    TiebaStatic.log(new an("c13345").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_locate", this.iDM ? 1 : 2));
                }
                czD();
            } else if (id == R.id.video_play) {
                if (this.jxM == this.STATE_STOP) {
                    startPlay();
                } else {
                    zy(this.jxG);
                    czz();
                    this.jts.b(this.jyt);
                }
                if (this.jyg) {
                    TiebaStatic.log(new an("c13344").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", this.iDM ? 1 : 2).X("obj_locate", 1));
                }
                czD();
            } else if (id == R.id.video_pause) {
                zy(this.STATE_PAUSE);
                czA();
                this.jts.pause();
                if (this.jyg) {
                    TiebaStatic.log(new an("c13344").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", this.iDM ? 1 : 2).X("obj_locate", 2));
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
    public void czD() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.MO);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void ctL() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jts.setVolume(0.0f, 0.0f);
            this.jxS.setState(1);
            return;
        }
        this.jts.setVolume(1.0f, 1.0f);
        this.jxS.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czE() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jts.setVolume(1.0f, 1.0f);
            af.a(this.Pf, true);
            this.jxS.setState(0);
        } else {
            this.jts.setVolume(0.0f, 0.0f);
            this.jxS.setState(1);
            af.a(this.Pf, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void rQ(boolean z) {
        if (this.eej == null) {
            this.eej = new o((Activity) this.mContext);
        }
        if (z) {
            this.eej.start();
            this.eej.bn(true);
            return;
        }
        this.eej.stop();
        this.eej.bn(false);
    }

    public void czF() {
        ra(true);
    }

    public void ra(boolean z) {
        if (this.mRootView != null && this.jyc != null && this.jts != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jts.setFullScreenToDestroySurface();
            if (this.eej == null) {
                this.eej = new o((Activity) this.mContext);
            }
            if (this.iDM) {
                if (this.jya.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jya.getParent()).removeView(this.jya);
                }
                if ((this.jyc.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iDM = false;
                    ((ViewGroup) this.jyc.getParent()).removeView(this.jyc);
                    ((ViewGroup) this.mRootView).addView(this.jyc);
                    h((Activity) this.mContext, this.iDM);
                }
                if (!this.Pi && z) {
                    this.eej.zY();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.Pi && z) {
                        this.eej.zY();
                    }
                    if (this.mContext instanceof Activity) {
                        this.jyc.getLocationOnScreen(this.jyk);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jya == null) {
                                    this.jya = new View(this.mContext);
                                    this.jya.setClickable(true);
                                    this.jya.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jya.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jya.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jya.getParent()).removeView(this.jya);
                                }
                                this.jya.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jya);
                                ((ViewGroup) childAt).addView(this.jyc);
                                this.iDM = true;
                                h((Activity) this.mContext, this.iDM);
                                if (this.gND != null && this.gND.isShowing()) {
                                    this.gND.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jyg) {
                    TiebaStatic.log(new an("c13360").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2));
                }
            }
            ctQ();
            ctR();
            if (this.jts.isPlaying()) {
                zy(this.jxE);
            } else {
                this.jxM |= 1;
                zy(this.jxM);
            }
            this.jxT.cTA();
            mM(this.iDM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czG() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.Pi) {
            czF();
        } else if (this.jxM == this.jxK) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jyc.setScaleX(1.0f);
                    d.this.jyc.setScaleY(1.0f);
                    d.this.jyc.setTranslationX(0.0f);
                    d.this.jyc.setTranslationY(0.0f);
                    d.this.jxW.setScaleX(1.0f);
                    d.this.jxW.setScaleY(1.0f);
                    d.this.jyc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jym) {
                        d.this.czF();
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
            if (!this.jym) {
                float width = this.mRootView.getWidth() / this.jyc.getWidth();
                float height = this.mRootView.getHeight() / this.jyc.getHeight();
                this.jyc.setPivotX(0.0f);
                this.jyc.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jyc, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jyc, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxW, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxW, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jyc, "TranslationX", this.jyc.getTranslationX(), this.jyk[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jyc, "TranslationY", this.jyc.getTranslationY(), this.jyk[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jya, "alpha", this.jya.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxW, "alpha", this.jxW.getAlpha(), 0.0f);
            } else {
                float width2 = this.jyi / this.jyc.getWidth();
                float height2 = this.jyl / this.jyc.getHeight();
                this.jyc.setPivotX(0.0f);
                this.jyc.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jyc, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jyc, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxW, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxW, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jyc, "TranslationX", this.jyc.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jyc, "TranslationY", this.jyc.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxW, "alpha", this.jxW.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jxN != -1) {
                this.jxM = this.jxN;
                this.jxN = -1;
                if (this.jxM == this.jxL || this.jxM == this.jxG || this.jxM == this.jxE) {
                    this.jts.b(this.jyt);
                    zy(this.jxE);
                }
            }
        } else {
            czF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.Pi && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jyc != null) {
                    if (z) {
                        this.jyc.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jyc.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                ccz();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.jyc.setSystemUiVisibility(0);
            }
        }
    }

    private void czH() {
        zy(this.jxF);
        this.jxU.showProgress();
        czB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mM(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        ctL();
        if (this.jyd) {
            if (this.iDM && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jts.b(this.jyt);
            if (cxU() && ((QuickVideoView) this.jts).jvt) {
                czB();
            }
        }
    }

    public void onCompletion(g gVar) {
        zy(this.jxI);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zy(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jxM == this.STATE_PAUSE || (this.jxM == this.jxH && !this.jts.isPlaying())) {
            czC();
            zy(this.STATE_PAUSE);
        } else if (this.jxM == this.jxI) {
            czC();
            zy(this.jxI);
        } else {
            czC();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            czH();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cyp() {
        return this.jyc;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jyd || this.jts.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jts.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bfG() {
    }

    protected void zz(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.iDM;
    }

    protected boolean ctN() {
        return this.Pi && this.iDM;
    }

    public boolean cxU() {
        return !this.isNewPlayer && (this.jts instanceof QuickVideoView);
    }

    private void ccz() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jyc.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jyc.setSystemUiVisibility(4);
        } else {
            this.jyc.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean ctT() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jts.isPlaying() && !af.aSt()) {
            this.jts.setVolume(1.0f, 1.0f);
            this.jxS.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean ctU() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        if (z) {
            this.jxQ.cancelAnimation();
            if (this.jxM == this.jxE || this.jxM == this.jxF || this.jxM == this.jxG || this.jxM == this.STATE_STOP) {
                stopPlay();
            }
            this.jxM |= 1;
            zy(this.jxM);
        } else if (this.jxM == this.STATE_STOP) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.iDM;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.iDM) {
            czG();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int bPj() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean czI() {
        return this.jyr != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rR(boolean z) {
        this.Kn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jys = aVar;
    }
}
