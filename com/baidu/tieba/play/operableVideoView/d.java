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
    protected BdUniqueId MP;
    protected TbImageView OZ;
    private ImageView Pa;
    private ImageView Pb;
    private TextView Pc;
    private TextView Pe;
    private TextView Pf;
    protected boolean Pj;
    protected String Pk;
    protected long Pl;
    private o eeN;
    private com.baidu.mcn.c gOY;
    private float jAc;
    private int jAd;
    private McnAdInfo jAe;
    private a jAf;
    protected com.baidu.tieba.play.a.a jvf;
    private View jzC;
    private TBLottieAnimationView jzD;
    private PercentSizeView jzE;
    protected SwitchImageView jzF;
    protected SwitchImageView jzG;
    protected OperableVideoMediaControllerView jzH;
    protected OperableVideoNetworkStateTipView jzI;
    protected OperableVideoShareView jzJ;
    protected ImageView jzK;
    protected View jzL;
    protected VideoGestureView jzM;
    private View jzN;
    private OperableVideoErrorView jzO;
    protected ViewGroup jzP;
    protected boolean jzQ;
    protected int jzR;
    protected n jzS;
    private float jzU;
    private float jzV;
    private int jzW;
    private int jzY;
    private boolean jzZ;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jzc = 3000;
    protected final int jzd = 1;
    protected final int jze = 2;
    protected final int jzf = 4;
    protected final int jzg = 8;
    protected final int jzh = 16;
    protected final int jzi = 32;
    protected final int jzj = 64;
    protected final int jzk = 128;
    protected final int jzl = 256;
    protected final int jzm = 512;
    protected final int jzn = 1024;
    protected final int jzo = 2048;
    protected final int jzp = 4096;
    protected final int jzq = 8192;
    protected int STATE_STOP = 8211;
    protected int jzr = 0;
    protected int jzs = 4;
    protected int jzt = 232;
    protected int STATE_PAUSE = 8416;
    protected int jzu = 0;
    protected int jzv = 513;
    protected int jzw = 259;
    protected int jzx = 2048;
    protected int jzy = 0;
    protected int STATE_ERROR = 4099;
    protected int jzz = this.STATE_STOP;
    private int jav = 0;
    private int jzA = -1;
    private Runnable jzB = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zG(d.this.jzr);
        }
    };
    private WeakReference<Context> Pg = null;
    protected boolean iFB = false;
    private boolean isNewPlayer = false;
    protected boolean jzT = true;
    private int[] jzX = new int[2];
    private int jAa = 0;
    private int jAb = 0;
    protected View.OnClickListener Ni = null;
    protected View.OnClickListener Ke = null;
    private boolean Kn = false;
    private long startPosition = -1;
    protected boolean Ov = false;
    private TbImageView.c NU = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPV().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), 10));
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
                        if (d.this.Ov && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener eaC = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.zG(d.this.jzt);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jvf.isPlaying()) {
                    d.this.jvf.b(d.this.jAg);
                }
                d.this.czV();
                if (d.this.jzT) {
                    TiebaStatic.log(new an("c13355").cx("tid", d.this.Pk).s("fid", d.this.mFid).X("obj_type", d.this.Pj ? 1 : 2).X("obj_locate", d.this.iFB ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener gzo = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jvf.isPlaying()) {
                d.this.jvf.pause();
                if (d.this.jzz == d.this.jzt) {
                    d.this.zG(d.this.STATE_PAUSE);
                } else {
                    d.this.zG(d.this.jzu);
                }
                d.this.zH(R.id.video_pause);
            } else if (d.this.jzz == d.this.STATE_PAUSE || d.this.jzz == (d.this.STATE_PAUSE | 1)) {
                d.this.zG(d.this.jzt);
                d.this.czV();
                d.this.jvf.b(d.this.jAg);
                d.this.zH(R.id.video_play);
            } else if (d.this.jzz == d.this.jzu || d.this.jzz == (d.this.jzu | 1)) {
                d.this.zG(d.this.jzr);
                d.this.jvf.b(d.this.jAg);
                d.this.zH(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jvf.isPlaying()) {
                if (d.this.jzz == d.this.jzr || d.this.jzz == d.this.jzs) {
                    d.this.zG(d.this.jzt);
                    d.this.czV();
                    return true;
                } else if (d.this.jzz == d.this.jzt) {
                    d.this.zG(d.this.jzr);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jzz == d.this.STATE_PAUSE) {
                d.this.zG(d.this.jzu);
                return true;
            } else if (d.this.jzz == (d.this.STATE_PAUSE | 1)) {
                d.this.zG(d.this.jzu | 1);
                return true;
            } else if (d.this.jzz == d.this.jzu) {
                d.this.zG(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jzz == (d.this.jzu | 1)) {
                d.this.zG(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zG(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.cAa();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.jav = 0;
            if (d.this.iFB) {
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
            if (d.this.Pj && d.this.cul()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.jav) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jvf.isPlaying()) {
                                d.this.jvf.pause();
                                d.this.zG(d.this.jzy);
                            }
                            d.this.jav = 4;
                            d.this.jzA = d.this.jzz;
                            d.this.jzz = d.this.jzx;
                            d.this.jzY = d.this.jzP.getMeasuredHeight();
                            d.this.jAc = d.this.jzV / d.this.jzY;
                            d.this.jAd = (int) (1.2f * d.this.mRootView.getWidth());
                            cy(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cy(rawX, rawY);
                        break;
                }
            } else if (d.this.jzz == d.this.jzr || d.this.jzz == d.this.jzt || d.this.jzz == d.this.STATE_PAUSE || d.this.jzz == d.this.jzu || d.this.jzz == d.this.jzx || d.this.jzz == (d.this.STATE_PAUSE | 1) || d.this.jzz == (d.this.jzu | 1)) {
                switch (d.this.jav) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.jav = 3;
                            d.this.jzW = d.this.jvf.getCurrentPosition();
                            aI(f);
                        } else if (motionEvent.getX() < d.this.jzP.getWidth() / 2) {
                            d.this.jav = 2;
                            d.this.jzM.l(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.jav = 1;
                            d.this.jzM.k(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jzz != d.this.jzx) {
                            if ((d.this.jzz & 1) > 0) {
                                d.this.jzx |= 1;
                            } else {
                                d.this.jzx &= -2;
                            }
                            d.this.zG(d.this.jzx);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jzM.k(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cup();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jzM.l(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aI(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cy(int i, int i2) {
            if (d.this.jAa != i2 || d.this.jAb != i) {
                d.this.jzZ = d.this.jAa - i2 > 0 || ((float) i2) < d.this.jzU / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jzP.getLayoutParams();
                if (i2 != d.this.jAa) {
                    int i3 = d.this.jzY - i2;
                    int i4 = (int) (i3 * d.this.jAc);
                    if (i4 < d.this.jAd) {
                        i4 = d.this.jAd;
                        i3 = (int) (i4 / d.this.jAc);
                    }
                    if (i4 != d.this.jAd) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jzP.setLayoutParams(layoutParams);
                    }
                    d.this.jAa = i2;
                    d.this.jzP.setTranslationY(d.this.jAa);
                }
                if (i != d.this.jAa) {
                    d.this.jAb = i;
                    d.this.jzP.setTranslationX(d.this.jAb + ((d.this.jzV - layoutParams.width) / 2.0f));
                }
                d.this.jzN.setAlpha((layoutParams.width - d.this.jAd) / (d.this.jzV - d.this.jAd));
                if (d.this.jzJ.getVisibility() == 0) {
                    float f = d.this.jzU / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jzJ.setAlpha(f2);
                }
            }
        }

        private void aI(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jzW -= 1000;
                z = true;
            } else {
                d.this.jzW += 1000;
                z = false;
            }
            int duration = d.this.jvf.getDuration();
            if (d.this.jzW < 0) {
                d.this.jzW = 0;
            } else if (d.this.jzW > duration) {
                d.this.jzW = duration;
            }
            String str = aq.stringForVideoTime(d.this.jzW) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jzM != null) {
                d.this.jzM.x(z, str);
            }
            d.this.jzH.setCurrentDuration(d.this.jzW, false);
        }
    };
    private View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jzz == d.this.jzx) {
                if (d.this.jav == 4) {
                    d.this.cAd();
                    d.this.jAa = 0;
                    d.this.jAb = 0;
                } else {
                    d.this.jzz = -1;
                    if (d.this.jav != 3) {
                        if (d.this.jzA != -1) {
                            d.this.zG(d.this.jzA);
                            d.this.jzA = -1;
                        } else if (d.this.jvf.isPlaying()) {
                            d.this.zG(d.this.jzr);
                        } else {
                            d.this.zG(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jzH.setCurrentDuration(d.this.jzW, true);
                        if (d.this.jzW <= d.this.jvf.getDuration()) {
                            if (!d.this.jvf.isPlaying()) {
                                d.this.jvf.b(d.this.jAg);
                            }
                            d.this.zG(d.this.jzr);
                        }
                    }
                }
                if (d.this.jzT) {
                    String str = null;
                    if (d.this.jav != 1) {
                        if (d.this.jav != 2) {
                            if (d.this.jav == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).cx("tid", d.this.Pk).s("fid", d.this.mFid));
                    }
                }
                d.this.jav = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jAg = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czQ() {
            d.this.jvf.czl();
            d.this.czU();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czR() {
            d.this.zG(d.this.STATE_STOP);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener jAh = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.Pg, true);
                    }
                    d.this.jvf.setVolume(1.0f, 1.0f);
                    d.this.jzF.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cuj();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bY(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.jzU = l.getEquipmentHeight(this.mContext);
            this.jzV = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cun() {
        int dimension;
        int i;
        int i2;
        this.jzI.ah(this.Pj, this.iFB);
        this.jzJ.ah(this.Pj, this.iFB);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.Pj) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.iFB) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.Pc.setPadding(0, 0, i2, 0);
            this.jzG.setPadding(this.jzG.getPaddingLeft(), 0, i, 0);
            this.jzF.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cum() {
        if (this.Pj) {
            this.jzt = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jzt = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iFB) {
            this.STATE_STOP |= 1024;
            this.jzr |= 1024;
            this.jzs |= 1024;
            this.jzt |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jzu |= 1024;
            this.jzv |= 1024;
            this.jzw |= 1024;
            this.jzz |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jzr &= -1025;
        this.jzs &= -1025;
        this.jzt &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jzu &= -1025;
        this.jzv &= -1025;
        this.jzw &= -1025;
        this.jzz &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jzP = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jzP);
            }
            this.Pg = new WeakReference<>(TbadkCoreApplication.getInst());
            this.OZ = (TbImageView) this.jzP.findViewById(R.id.video_thumbnail);
            this.jzC = this.jzP.findViewById(R.id.black_mask);
            this.jzD = (TBLottieAnimationView) this.jzP.findViewById(R.id.video_loading);
            this.Pa = (ImageView) this.jzP.findViewById(R.id.video_play);
            this.jzE = (PercentSizeView) this.jzP.findViewById(R.id.video_media_controller_mask);
            this.Pb = (ImageView) this.jzP.findViewById(R.id.video_pause);
            this.Pc = (TextView) this.jzP.findViewById(R.id.video_play_count);
            this.Pe = (TextView) this.jzP.findViewById(R.id.video_play_flag);
            this.Pf = (TextView) this.jzP.findViewById(R.id.video_duration);
            this.jzF = (SwitchImageView) this.jzP.findViewById(R.id.video_mute);
            this.jzG = (SwitchImageView) this.jzP.findViewById(R.id.video_full_screen);
            this.jzH = (OperableVideoMediaControllerView) this.jzP.findViewById(R.id.video_media_controller);
            this.jzI = (OperableVideoNetworkStateTipView) this.jzP.findViewById(R.id.video_network_state_tip);
            this.jzJ = (OperableVideoShareView) this.jzP.findViewById(R.id.video_share_view);
            this.jzL = this.jzP.findViewById(R.id.video_back_btn_mask);
            this.jzK = (ImageView) this.jzP.findViewById(R.id.video_full_screen_back);
            this.jzM = (VideoGestureView) this.jzP.findViewById(R.id.video_gesture);
            this.jzO = (OperableVideoErrorView) this.jzP.findViewById(R.id.video_error_layout);
            this.jzJ.setVideoContainer(this);
            this.jzS = new n(this.mContext);
            this.jzS.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bz(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cAf() && !d.this.Pj && !d.this.iFB && d.this.Kn) {
                        if (!com.baidu.mcn.b.DN().eA(d.this.jAe.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jAe.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jAe.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jAe.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gOY.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLz = d.this.jAe.card_title;
                                    aVar.aLA = d.this.jAe.button_title;
                                    aVar.aLB = d.this.jAe.jump_url;
                                    aVar.aLy = d.this.jAe.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.Pk;
                                    aVar.aLC = d.this.bPE();
                                    if (z2) {
                                        d.this.gOY.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.gOY.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.gOY.isShowing()) {
                                d.this.gOY.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.jAf != null) {
                        d.this.jAf.bY(i, i2);
                    }
                }
            });
            this.jzD.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jzD.setVisibility(8);
                    d.this.Pa.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jzD.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aGG().a(this.Pa, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Pa.setOnClickListener(this);
            this.jzF.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jzF.setState(1);
            this.jzF.setOnClickListener(this);
            this.OZ.aSX();
            this.OZ.setDrawCorner(false);
            this.OZ.setPlaceHolder(3);
            this.jzH.setOnSeekBarChangeListener(this.eaC);
            this.jzE.setHeightPercent(0.583f);
            this.jzE.setBackgroundResource(R.drawable.video_mask_bg);
            this.jzG.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jzG.setState(0);
            this.jzG.setOnClickListener(this);
            SvgManager.aGG().a(this.Pb, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Pb.setOnClickListener(this);
            this.jzK.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rG("cyber_player_test");
            this.jvf = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jvf.setTryUseViewInSet(true);
            czU();
            this.jzI.setPlayViewOnClickListener(this);
            this.jzP.setOnClickListener(null);
            this.jzP.setOnTouchListener(this.dsa);
            this.jzJ.setOnTouchListener(this.dsa);
            this.jzO.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.gzo);
            zG(this.STATE_STOP);
            this.gOY = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void czU() {
        if (this.jvf != null && this.jvf.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jzP.addView(this.jvf.getView(), 0);
            this.jvf.getView().setLayoutParams(layoutParams);
            this.jzH.setPlayer(this.jvf);
            if (cyq()) {
                ((QuickVideoView) this.jvf).setNeedRecovery(true);
                ((QuickVideoView) this.jvf).setPlayerReuseEnable(true);
            }
            this.jvf.setContinuePlayEnable(true);
            this.jvf.setBusiness(this.jzS);
            this.jvf.setOnPreparedListener(this);
            this.jvf.setOnCompletionListener(this);
            this.jvf.setOnErrorListener(this);
            this.jvf.setOnSurfaceDestroyedListener(this);
            this.jvf.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCI() != null) {
            this.startPosition = -1L;
            if (this.gOY != null) {
                this.gOY.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aCI().video_url)) {
                stopPlay();
                this.Pj = bjVar.aCI().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aCI().video_url;
                this.Pk = bjVar.getTid();
                this.Pl = bjVar.aCI().video_length.intValue();
                this.jzR = bjVar.aCI().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.jAe = bjVar.aCI().mcn_ad_card;
                cum();
                cun();
                zG(this.STATE_STOP);
                int intValue = bjVar.aCI().video_duration.intValue() * 1000;
                this.jzH.AB(intValue);
                this.jzH.setPlayer(this.jvf);
                this.Pf.setText(aq.stringForVideoTime(intValue));
                this.Pc.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aCI().play_count.intValue())));
                this.jzI.setVideoLength(bjVar.aCI().video_length.intValue());
                this.jzI.setVideoDuration(bjVar.aCI().video_duration.intValue());
                this.jzI.setTid(this.Pk);
                this.jzS.czt().ak(bjVar);
                this.Pe.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.aCI().wth_mid_loc != null && bjVar.aCI().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.OZ.setScaleType(ImageView.ScaleType.MATRIX);
                    this.OZ.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.Pj) {
                        this.Pf.setText("");
                        this.Pc.setText("");
                        this.Pe.setVisibility(0);
                    }
                    this.OZ.setSmartCropCenterPointWidthRatio(bjVar.aCI().wth_mid_loc.floatValue());
                    this.OZ.setSmartCropCenterPointHeightRatio(bjVar.aCI().hth_mid_loc.floatValue());
                    this.OZ.setOnDrawListener(this.NU);
                }
                this.OZ.setPlaceHolder(3);
                this.OZ.startLoad(bjVar.aCI().thumbnail_url, 10, false);
                this.jzJ.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ov = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jzS != null) {
            this.jzS.setVideoStatsData(yVar);
            this.jvf.setBusiness(this.jzS);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u czt() {
        if (this.jzS == null) {
            return null;
        }
        return this.jzS.czt();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Z(View.OnClickListener onClickListener) {
        this.Ke = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.MP = bdUniqueId;
    }

    public void czV() {
        e.gx().removeCallbacks(this.jzB);
        e.gx().postDelayed(this.jzB, this.jzc);
    }

    public void czW() {
        e.gx().removeCallbacks(this.jzB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jzD.setAlpha(1.0f);
        this.jzD.setVisibility(0);
        this.Pa.setVisibility(8);
        if (this.jzD != null) {
            this.jzD.loop(true);
            this.jzD.setMinAndMaxFrame(14, 80);
            this.jzD.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cuk() {
        if (this.jzz == this.jzs) {
            zG(this.jzr);
        }
    }

    private void czX() {
        zG(this.jzs);
        this.jzH.showProgress();
        if (this.jzD != null) {
            this.jzD.clearAnimation();
            this.jzD.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cuk();
                    if (!d.this.jzQ) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jzD.setVisibility(8);
                    d.this.Pa.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean czY() {
        return this.jzI != null && this.jzI.cuv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.cLK);
            MessageManager.getInstance().registerListener(this.jAh);
            if (czY()) {
                zG(this.jzw);
                return;
            }
            this.jzQ = true;
            if (!this.jvf.isPlaying()) {
                com.baidu.tieba.play.a.a He = TbVideoViewSet.czP().He(this.mVideoUrl);
                if (He == null) {
                    this.jvf.czl();
                    if (!StringUtils.isNull(this.jvf.getOriginUrl())) {
                        this.jvf = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.jvf.setTryUseViewInSet(true);
                    }
                    czU();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jvf.setVideoDuration(this.jzR);
                        this.jvf.setVideoPath(this.mVideoUrl, this.Pk);
                        startLoadingAnim();
                        if (this.jzT) {
                            cut();
                        }
                    }
                } else {
                    if (this.jvf == He) {
                        if (this.jvf.getParent() == null || this.jvf.getParent() != He.getParent()) {
                            this.jvf.czl();
                            czU();
                        }
                    } else {
                        this.jvf.czl();
                        He.czl();
                        this.jvf = He;
                        this.jvf.setTryUseViewInSet(true);
                        czU();
                    }
                    this.jvf.czg();
                    onPrepared(null);
                    cAe();
                    if (this.jzT) {
                        cut();
                    }
                }
                if (this.jzT) {
                    TiebaStatic.log(new an("c13357").cx("tid", this.Pk).s("fid", this.mFid).X("obj_type", this.Pj ? 1 : 2).X("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).X("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jzQ = false;
        if (this.jzD != null) {
            this.jzD.cancelAnimation();
        }
        this.jvf.stop();
        this.jvf.czl();
        this.jzH.akm();
        zG(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLK);
        MessageManager.getInstance().unRegisterListener(this.jAh);
    }

    private void czZ() {
        this.jzQ = false;
        if (this.jzD != null) {
            this.jzD.cancelAnimation();
        }
        this.jvf.stop();
        this.jzH.akm();
        zG(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLK);
        MessageManager.getInstance().unRegisterListener(this.jAh);
    }

    public void cut() {
        if (this.jzS != null && this.jzS.czw() != null) {
            y czN = this.jzS.czw().czN();
            czN.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(czN.jyv, "", "1", czN);
        }
    }

    public void zG(int i) {
        czW();
        if (this.jzz == this.jzx) {
            this.jzA = i;
            return;
        }
        this.jzz = i;
        this.OZ.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jzC.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jzD.clearAnimation();
        this.jzD.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jzD.cancelAnimation();
        } else {
            this.jzD.setAlpha(1.0f);
        }
        this.Pa.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Pb.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Pc.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.Pj && (homePageStyleAbTest & 4) != 0) {
            this.Pe.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.Pf.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jzF.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jzG.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jzH.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jzE.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jzH.getVisibility() == 0) {
            this.jzH.showProgress();
        }
        this.jzI.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jzJ.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jzJ.getVisibility() == 0) {
            this.jzJ.setAlpha(1.0f);
        }
        this.jzK.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jzL.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jzM.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jzO.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zH(id);
            if (id == R.id.video_mute) {
                cAb();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cAd();
            } else if (id == R.id.video_replay) {
                zG(this.STATE_STOP);
                startPlay();
                if (this.jzT) {
                    TiebaStatic.log(new an("c13345").cx("tid", this.Pk).s("fid", this.mFid).X("obj_type", this.Pj ? 1 : 2).X("obj_locate", this.iFB ? 1 : 2));
                }
                cAa();
            } else if (id == R.id.video_play) {
                if (this.jzz == this.STATE_STOP) {
                    startPlay();
                } else {
                    zG(this.jzt);
                    czV();
                    this.jvf.b(this.jAg);
                }
                if (this.jzT) {
                    TiebaStatic.log(new an("c13344").cx("tid", this.Pk).s("fid", this.mFid).X("obj_type", this.Pj ? 1 : 2).X("obj_source", this.iFB ? 1 : 2).X("obj_locate", 1));
                }
                cAa();
            } else if (id == R.id.video_pause) {
                zG(this.STATE_PAUSE);
                czW();
                this.jvf.pause();
                if (this.jzT) {
                    TiebaStatic.log(new an("c13344").cx("tid", this.Pk).s("fid", this.mFid).X("obj_type", this.Pj ? 1 : 2).X("obj_source", this.iFB ? 1 : 2).X("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                zG(this.STATE_STOP);
                startPlay();
            } else if (id == R.id.retry) {
                zG(this.STATE_STOP);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAa() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.MP);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cuj() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jvf.setVolume(0.0f, 0.0f);
            this.jzF.setState(1);
            return;
        }
        this.jvf.setVolume(1.0f, 1.0f);
        this.jzF.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cAb() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jvf.setVolume(1.0f, 1.0f);
            af.a(this.Pg, true);
            this.jzF.setState(0);
        } else {
            this.jvf.setVolume(0.0f, 0.0f);
            this.jzF.setState(1);
            af.a(this.Pg, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void rW(boolean z) {
        if (this.eeN == null) {
            this.eeN = new o((Activity) this.mContext);
        }
        if (z) {
            this.eeN.start();
            this.eeN.bo(true);
            return;
        }
        this.eeN.stop();
        this.eeN.bo(false);
    }

    public void cAc() {
        rg(true);
    }

    public void rg(boolean z) {
        if (this.mRootView != null && this.jzP != null && this.jvf != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jvf.setFullScreenToDestroySurface();
            if (this.eeN == null) {
                this.eeN = new o((Activity) this.mContext);
            }
            if (this.iFB) {
                if (this.jzN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jzN.getParent()).removeView(this.jzN);
                }
                if ((this.jzP.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iFB = false;
                    ((ViewGroup) this.jzP.getParent()).removeView(this.jzP);
                    ((ViewGroup) this.mRootView).addView(this.jzP);
                    h((Activity) this.mContext, this.iFB);
                }
                if (!this.Pj && z) {
                    this.eeN.Ah();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.Pj && z) {
                        this.eeN.Ah();
                    }
                    if (this.mContext instanceof Activity) {
                        this.jzP.getLocationOnScreen(this.jzX);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jzN == null) {
                                    this.jzN = new View(this.mContext);
                                    this.jzN.setClickable(true);
                                    this.jzN.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jzN.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jzN.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jzN.getParent()).removeView(this.jzN);
                                }
                                this.jzN.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jzN);
                                ((ViewGroup) childAt).addView(this.jzP);
                                this.iFB = true;
                                h((Activity) this.mContext, this.iFB);
                                if (this.gOY != null && this.gOY.isShowing()) {
                                    this.gOY.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jzT) {
                    TiebaStatic.log(new an("c13360").cx("tid", this.Pk).s("fid", this.mFid).X("obj_type", this.Pj ? 1 : 2));
                }
            }
            cum();
            cun();
            if (this.jvf.isPlaying()) {
                zG(this.jzr);
            } else {
                this.jzz |= 1;
                zG(this.jzz);
            }
            this.jzG.cTX();
            mS(this.iFB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAd() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.Pj) {
            cAc();
        } else if (this.jzz == this.jzx) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jzP.setScaleX(1.0f);
                    d.this.jzP.setScaleY(1.0f);
                    d.this.jzP.setTranslationX(0.0f);
                    d.this.jzP.setTranslationY(0.0f);
                    d.this.jzJ.setScaleX(1.0f);
                    d.this.jzJ.setScaleY(1.0f);
                    d.this.jzP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jzZ) {
                        d.this.cAc();
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
            if (!this.jzZ) {
                float width = this.mRootView.getWidth() / this.jzP.getWidth();
                float height = this.mRootView.getHeight() / this.jzP.getHeight();
                this.jzP.setPivotX(0.0f);
                this.jzP.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jzP, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jzP, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jzJ, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jzJ, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jzP, "TranslationX", this.jzP.getTranslationX(), this.jzX[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jzP, "TranslationY", this.jzP.getTranslationY(), this.jzX[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jzN, "alpha", this.jzN.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jzJ, "alpha", this.jzJ.getAlpha(), 0.0f);
            } else {
                float width2 = this.jzV / this.jzP.getWidth();
                float height2 = this.jzY / this.jzP.getHeight();
                this.jzP.setPivotX(0.0f);
                this.jzP.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jzP, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jzP, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jzJ, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jzJ, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jzP, "TranslationX", this.jzP.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jzP, "TranslationY", this.jzP.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jzJ, "alpha", this.jzJ.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jzA != -1) {
                this.jzz = this.jzA;
                this.jzA = -1;
                if (this.jzz == this.jzy || this.jzz == this.jzt || this.jzz == this.jzr) {
                    this.jvf.b(this.jAg);
                    zG(this.jzr);
                }
            }
        } else {
            cAc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.Pj && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jzP != null) {
                    if (z) {
                        this.jzP.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jzP.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                ccV();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.jzP.setSystemUiVisibility(0);
            }
        }
    }

    private void cAe() {
        zG(this.jzs);
        this.jzH.showProgress();
        czX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mS(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cuj();
        if (this.jzQ) {
            if (this.iFB && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jvf.b(this.jAg);
            if (cyq() && ((QuickVideoView) this.jvf).jxg) {
                czX();
            }
        }
    }

    public void onCompletion(g gVar) {
        zG(this.jzv);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zG(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jzz == this.STATE_PAUSE || (this.jzz == this.jzu && !this.jvf.isPlaying())) {
            czZ();
            zG(this.STATE_PAUSE);
        } else if (this.jzz == this.jzv) {
            czZ();
            zG(this.jzv);
        } else {
            czZ();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cAe();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cyL() {
        return this.jzP;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jzQ || this.jvf.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jvf.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bfO() {
    }

    protected void zH(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.iFB;
    }

    protected boolean cul() {
        return this.Pj && this.iFB;
    }

    public boolean cyq() {
        return !this.isNewPlayer && (this.jvf instanceof QuickVideoView);
    }

    private void ccV() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jzP.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jzP.setSystemUiVisibility(4);
        } else {
            this.jzP.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cup() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jvf.isPlaying() && !af.aSA()) {
            this.jvf.setVolume(1.0f, 1.0f);
            this.jzF.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cuq() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean mR(boolean z) {
        if (z) {
            this.jzD.cancelAnimation();
            if (this.jzz == this.jzr || this.jzz == this.jzs || this.jzz == this.jzt || this.jzz == this.STATE_STOP) {
                stopPlay();
            }
            this.jzz |= 1;
            zG(this.jzz);
        } else if (this.jzz == this.STATE_STOP) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.iFB;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.iFB) {
            cAd();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int bPE() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cAf() {
        return this.jAe != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rX(boolean z) {
        this.Kn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jAf = aVar;
    }
}
