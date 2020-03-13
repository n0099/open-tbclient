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
    private o eex;
    private com.baidu.mcn.c gNR;
    protected com.baidu.tieba.play.a.a jtG;
    private boolean jyA;
    private float jyD;
    private int jyE;
    private McnAdInfo jyF;
    private a jyG;
    private View jyd;
    private TBLottieAnimationView jye;
    private PercentSizeView jyf;
    protected SwitchImageView jyg;
    protected SwitchImageView jyh;
    protected OperableVideoMediaControllerView jyi;
    protected OperableVideoNetworkStateTipView jyj;
    protected OperableVideoShareView jyk;
    protected ImageView jyl;
    protected View jym;
    protected VideoGestureView jyn;
    private View jyo;
    private OperableVideoErrorView jyp;
    protected ViewGroup jyq;
    protected boolean jyr;
    protected int jys;
    protected n jyt;
    private float jyv;
    private float jyw;
    private int jyx;
    private int jyz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jxD = 3000;
    protected final int jxE = 1;
    protected final int jxF = 2;
    protected final int jxG = 4;
    protected final int jxH = 8;
    protected final int jxI = 16;
    protected final int jxJ = 32;
    protected final int jxK = 64;
    protected final int jxL = 128;
    protected final int jxM = 256;
    protected final int jxN = 512;
    protected final int jxO = 1024;
    protected final int jxP = 2048;
    protected final int jxQ = 4096;
    protected final int jxR = 8192;
    protected int STATE_STOP = 8211;
    protected int jxS = 0;
    protected int jxT = 4;
    protected int jxU = 232;
    protected int STATE_PAUSE = 8416;
    protected int jxV = 0;
    protected int jxW = 513;
    protected int jxX = 259;
    protected int jxY = 2048;
    protected int jxZ = 0;
    protected int STATE_ERROR = 4099;
    protected int jya = this.STATE_STOP;
    private int iYU = 0;
    private int jyb = -1;
    private Runnable jyc = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zy(d.this.jxS);
        }
    };
    private WeakReference<Context> Pf = null;
    protected boolean iEa = false;
    private boolean isNewPlayer = false;
    protected boolean jyu = true;
    private int[] jyy = new int[2];
    private int jyB = 0;
    private int jyC = 0;
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
                com.baidu.adp.widget.ImageView.a vy = com.baidu.tbadk.imageManager.c.aPR().vy(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), 10));
                if (vy != null) {
                    int width = vy.getWidth();
                    i = vy.getHeight();
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
    private SeekBar.OnSeekBarChangeListener eam = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.zy(d.this.jxU);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jtG.isPlaying()) {
                    d.this.jtG.b(d.this.jyH);
                }
                d.this.czC();
                if (d.this.jyu) {
                    TiebaStatic.log(new an("c13355").cy("tid", d.this.Pj).s("fid", d.this.mFid).X("obj_type", d.this.Pi ? 1 : 2).X("obj_locate", d.this.iEa ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iZa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jtG.isPlaying()) {
                d.this.jtG.pause();
                if (d.this.jya == d.this.jxU) {
                    d.this.zy(d.this.STATE_PAUSE);
                } else {
                    d.this.zy(d.this.jxV);
                }
                d.this.zz(R.id.video_pause);
            } else if (d.this.jya == d.this.STATE_PAUSE || d.this.jya == (d.this.STATE_PAUSE | 1)) {
                d.this.zy(d.this.jxU);
                d.this.czC();
                d.this.jtG.b(d.this.jyH);
                d.this.zz(R.id.video_play);
            } else if (d.this.jya == d.this.jxV || d.this.jya == (d.this.jxV | 1)) {
                d.this.zy(d.this.jxS);
                d.this.jtG.b(d.this.jyH);
                d.this.zz(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jtG.isPlaying()) {
                if (d.this.jya == d.this.jxS || d.this.jya == d.this.jxT) {
                    d.this.zy(d.this.jxU);
                    d.this.czC();
                    return true;
                } else if (d.this.jya == d.this.jxU) {
                    d.this.zy(d.this.jxS);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jya == d.this.STATE_PAUSE) {
                d.this.zy(d.this.jxV);
                return true;
            } else if (d.this.jya == (d.this.STATE_PAUSE | 1)) {
                d.this.zy(d.this.jxV | 1);
                return true;
            } else if (d.this.jya == d.this.jxV) {
                d.this.zy(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jya == (d.this.jxV | 1)) {
                d.this.zy(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zy(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.czG();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.iYU = 0;
            if (d.this.iEa) {
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
            if (d.this.Pi && d.this.ctQ()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.iYU) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jtG.isPlaying()) {
                                d.this.jtG.pause();
                                d.this.zy(d.this.jxZ);
                            }
                            d.this.iYU = 4;
                            d.this.jyb = d.this.jya;
                            d.this.jya = d.this.jxY;
                            d.this.jyz = d.this.jyq.getMeasuredHeight();
                            d.this.jyD = d.this.jyw / d.this.jyz;
                            d.this.jyE = (int) (1.2f * d.this.mRootView.getWidth());
                            cx(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cx(rawX, rawY);
                        break;
                }
            } else if (d.this.jya == d.this.jxS || d.this.jya == d.this.jxU || d.this.jya == d.this.STATE_PAUSE || d.this.jya == d.this.jxV || d.this.jya == d.this.jxY || d.this.jya == (d.this.STATE_PAUSE | 1) || d.this.jya == (d.this.jxV | 1)) {
                switch (d.this.iYU) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.iYU = 3;
                            d.this.jyx = d.this.jtG.getCurrentPosition();
                            aI(f);
                        } else if (motionEvent.getX() < d.this.jyq.getWidth() / 2) {
                            d.this.iYU = 2;
                            d.this.jyn.l(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.iYU = 1;
                            d.this.jyn.k(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jya != d.this.jxY) {
                            if ((d.this.jya & 1) > 0) {
                                d.this.jxY |= 1;
                            } else {
                                d.this.jxY &= -2;
                            }
                            d.this.zy(d.this.jxY);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jyn.k(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.ctW();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jyn.l(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aI(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cx(int i, int i2) {
            if (d.this.jyB != i2 || d.this.jyC != i) {
                d.this.jyA = d.this.jyB - i2 > 0 || ((float) i2) < d.this.jyv / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jyq.getLayoutParams();
                if (i2 != d.this.jyB) {
                    int i3 = d.this.jyz - i2;
                    int i4 = (int) (i3 * d.this.jyD);
                    if (i4 < d.this.jyE) {
                        i4 = d.this.jyE;
                        i3 = (int) (i4 / d.this.jyD);
                    }
                    if (i4 != d.this.jyE) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jyq.setLayoutParams(layoutParams);
                    }
                    d.this.jyB = i2;
                    d.this.jyq.setTranslationY(d.this.jyB);
                }
                if (i != d.this.jyB) {
                    d.this.jyC = i;
                    d.this.jyq.setTranslationX(d.this.jyC + ((d.this.jyw - layoutParams.width) / 2.0f));
                }
                d.this.jyo.setAlpha((layoutParams.width - d.this.jyE) / (d.this.jyw - d.this.jyE));
                if (d.this.jyk.getVisibility() == 0) {
                    float f = d.this.jyv / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jyk.setAlpha(f2);
                }
            }
        }

        private void aI(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jyx -= 1000;
                z = true;
            } else {
                d.this.jyx += 1000;
                z = false;
            }
            int duration = d.this.jtG.getDuration();
            if (d.this.jyx < 0) {
                d.this.jyx = 0;
            } else if (d.this.jyx > duration) {
                d.this.jyx = duration;
            }
            String str = aq.stringForVideoTime(d.this.jyx) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jyn != null) {
                d.this.jyn.x(z, str);
            }
            d.this.jyi.setCurrentDuration(d.this.jyx, false);
        }
    };
    private View.OnTouchListener drN = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jya == d.this.jxY) {
                if (d.this.iYU == 4) {
                    d.this.czJ();
                    d.this.jyB = 0;
                    d.this.jyC = 0;
                } else {
                    d.this.jya = -1;
                    if (d.this.iYU != 3) {
                        if (d.this.jyb != -1) {
                            d.this.zy(d.this.jyb);
                            d.this.jyb = -1;
                        } else if (d.this.jtG.isPlaying()) {
                            d.this.zy(d.this.jxS);
                        } else {
                            d.this.zy(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jyi.setCurrentDuration(d.this.jyx, true);
                        if (d.this.jyx <= d.this.jtG.getDuration()) {
                            if (!d.this.jtG.isPlaying()) {
                                d.this.jtG.b(d.this.jyH);
                            }
                            d.this.zy(d.this.jxS);
                        }
                    }
                }
                if (d.this.jyu) {
                    String str = null;
                    if (d.this.iYU != 1) {
                        if (d.this.iYU != 2) {
                            if (d.this.iYU == 3) {
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
                d.this.iYU = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jyH = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czx() {
            d.this.jtG.cyS();
            d.this.czB();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void czy() {
            d.this.zy(d.this.STATE_STOP);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener cLz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener jyI = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.Pf, true);
                    }
                    d.this.jtG.setVolume(1.0f, 1.0f);
                    d.this.jyg.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.ctO();
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
            this.jyv = l.getEquipmentHeight(this.mContext);
            this.jyw = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ctU() {
        int dimension;
        int i;
        int i2;
        this.jyj.ah(this.Pi, this.iEa);
        this.jyk.ah(this.Pi, this.iEa);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.Pi) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.iEa) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.Pb.setPadding(0, 0, i2, 0);
            this.jyh.setPadding(this.jyh.getPaddingLeft(), 0, i, 0);
            this.jyg.setPadding(dimension, 0, 0, 0);
        }
    }

    public void ctT() {
        if (this.Pi) {
            this.jxU = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jxU = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iEa) {
            this.STATE_STOP |= 1024;
            this.jxS |= 1024;
            this.jxT |= 1024;
            this.jxU |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jxV |= 1024;
            this.jxW |= 1024;
            this.jxX |= 1024;
            this.jya |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jxS &= -1025;
        this.jxT &= -1025;
        this.jxU &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jxV &= -1025;
        this.jxW &= -1025;
        this.jxX &= -1025;
        this.jya &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jyq = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jyq);
            }
            this.Pf = new WeakReference<>(TbadkCoreApplication.getInst());
            this.OY = (TbImageView) this.jyq.findViewById(R.id.video_thumbnail);
            this.jyd = this.jyq.findViewById(R.id.black_mask);
            this.jye = (TBLottieAnimationView) this.jyq.findViewById(R.id.video_loading);
            this.OZ = (ImageView) this.jyq.findViewById(R.id.video_play);
            this.jyf = (PercentSizeView) this.jyq.findViewById(R.id.video_media_controller_mask);
            this.Pa = (ImageView) this.jyq.findViewById(R.id.video_pause);
            this.Pb = (TextView) this.jyq.findViewById(R.id.video_play_count);
            this.Pc = (TextView) this.jyq.findViewById(R.id.video_play_flag);
            this.Pe = (TextView) this.jyq.findViewById(R.id.video_duration);
            this.jyg = (SwitchImageView) this.jyq.findViewById(R.id.video_mute);
            this.jyh = (SwitchImageView) this.jyq.findViewById(R.id.video_full_screen);
            this.jyi = (OperableVideoMediaControllerView) this.jyq.findViewById(R.id.video_media_controller);
            this.jyj = (OperableVideoNetworkStateTipView) this.jyq.findViewById(R.id.video_network_state_tip);
            this.jyk = (OperableVideoShareView) this.jyq.findViewById(R.id.video_share_view);
            this.jym = this.jyq.findViewById(R.id.video_back_btn_mask);
            this.jyl = (ImageView) this.jyq.findViewById(R.id.video_full_screen_back);
            this.jyn = (VideoGestureView) this.jyq.findViewById(R.id.video_gesture);
            this.jyp = (OperableVideoErrorView) this.jyq.findViewById(R.id.video_error_layout);
            this.jyk.setVideoContainer(this);
            this.jyt = new n(this.mContext);
            this.jyt.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.czL() && !d.this.Pi && !d.this.iEa && d.this.Kn) {
                        if (!com.baidu.mcn.b.DG().eB(d.this.jyF.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jyF.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jyF.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jyF.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gNR.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aLl = d.this.jyF.card_title;
                                    aVar.aLm = d.this.jyF.button_title;
                                    aVar.aLn = d.this.jyF.jump_url;
                                    aVar.aLk = d.this.jyF.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.Pj;
                                    aVar.aLo = d.this.bPm();
                                    if (z2) {
                                        d.this.gNR.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.gNR.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.gNR.isShowing()) {
                                d.this.gNR.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.jyG != null) {
                        d.this.jyG.bX(i, i2);
                    }
                }
            });
            this.jye.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jye.setVisibility(8);
                    d.this.OZ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jye.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aGC().a(this.OZ, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.OZ.setOnClickListener(this);
            this.jyg.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jyg.setState(1);
            this.jyg.setOnClickListener(this);
            this.OY.aST();
            this.OY.setDrawCorner(false);
            this.OY.setPlaceHolder(3);
            this.jyi.setOnSeekBarChangeListener(this.eam);
            this.jyf.setHeightPercent(0.583f);
            this.jyf.setBackgroundResource(R.drawable.video_mask_bg);
            this.jyh.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jyh.setState(0);
            this.jyh.setOnClickListener(this);
            SvgManager.aGC().a(this.Pa, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Pa.setOnClickListener(this);
            this.jyl.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rH("cyber_player_test");
            this.jtG = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jtG.setTryUseViewInSet(true);
            czB();
            this.jyj.setPlayViewOnClickListener(this);
            this.jyq.setOnClickListener(null);
            this.jyq.setOnTouchListener(this.drN);
            this.jyk.setOnTouchListener(this.drN);
            this.jyp.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iZa);
            zy(this.STATE_STOP);
            this.gNR = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void czB() {
        if (this.jtG != null && this.jtG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jyq.addView(this.jtG.getView(), 0);
            this.jtG.getView().setLayoutParams(layoutParams);
            this.jyi.setPlayer(this.jtG);
            if (cxX()) {
                ((QuickVideoView) this.jtG).setNeedRecovery(true);
                ((QuickVideoView) this.jtG).setPlayerReuseEnable(true);
            }
            this.jtG.setContinuePlayEnable(true);
            this.jtG.setBusiness(this.jyt);
            this.jtG.setOnPreparedListener(this);
            this.jtG.setOnCompletionListener(this);
            this.jtG.setOnErrorListener(this);
            this.jtG.setOnSurfaceDestroyedListener(this);
            this.jtG.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCF() != null) {
            this.startPosition = -1L;
            if (this.gNR != null) {
                this.gNR.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aCF().video_url)) {
                stopPlay();
                this.Pi = bjVar.aCF().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aCF().video_url;
                this.Pj = bjVar.getTid();
                this.Pk = bjVar.aCF().video_length.intValue();
                this.jys = bjVar.aCF().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.jyF = bjVar.aCF().mcn_ad_card;
                ctT();
                ctU();
                zy(this.STATE_STOP);
                int intValue = bjVar.aCF().video_duration.intValue() * 1000;
                this.jyi.At(intValue);
                this.jyi.setPlayer(this.jtG);
                this.Pe.setText(aq.stringForVideoTime(intValue));
                this.Pb.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aCF().play_count.intValue())));
                this.jyj.setVideoLength(bjVar.aCF().video_length.intValue());
                this.jyj.setVideoDuration(bjVar.aCF().video_duration.intValue());
                this.jyj.setTid(this.Pj);
                this.jyt.cza().aj(bjVar);
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
                this.jyk.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ou = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jyt != null) {
            this.jyt.setVideoStatsData(yVar);
            this.jtG.setBusiness(this.jyt);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cza() {
        if (this.jyt == null) {
            return null;
        }
        return this.jyt.cza();
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

    public void czC() {
        e.gx().removeCallbacks(this.jyc);
        e.gx().postDelayed(this.jyc, this.jxD);
    }

    public void czD() {
        e.gx().removeCallbacks(this.jyc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jye.setAlpha(1.0f);
        this.jye.setVisibility(0);
        this.OZ.setVisibility(8);
        if (this.jye != null) {
            this.jye.loop(true);
            this.jye.setMinAndMaxFrame(14, 80);
            this.jye.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ctP() {
        if (this.jya == this.jxT) {
            zy(this.jxS);
        }
    }

    private void czE() {
        zy(this.jxT);
        this.jyi.showProgress();
        if (this.jye != null) {
            this.jye.clearAnimation();
            this.jye.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.ctP();
                    if (!d.this.jyr) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jye.setVisibility(8);
                    d.this.OZ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean ctS() {
        return this.jyj != null && this.jyj.cuc();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.cLz);
            MessageManager.getInstance().registerListener(this.jyI);
            if (ctS()) {
                zy(this.jxX);
                return;
            }
            this.jyr = true;
            if (!this.jtG.isPlaying()) {
                com.baidu.tieba.play.a.a Hf = TbVideoViewSet.czw().Hf(this.mVideoUrl);
                if (Hf == null) {
                    this.jtG.cyS();
                    if (!StringUtils.isNull(this.jtG.getOriginUrl())) {
                        this.jtG = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.jtG.setTryUseViewInSet(true);
                    }
                    czB();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.jtG.setVideoDuration(this.jys);
                        this.jtG.setVideoPath(this.mVideoUrl, this.Pj);
                        startLoadingAnim();
                        if (this.jyu) {
                            cua();
                        }
                    }
                } else {
                    if (this.jtG == Hf) {
                        if (this.jtG.getParent() == null || this.jtG.getParent() != Hf.getParent()) {
                            this.jtG.cyS();
                            czB();
                        }
                    } else {
                        this.jtG.cyS();
                        Hf.cyS();
                        this.jtG = Hf;
                        this.jtG.setTryUseViewInSet(true);
                        czB();
                    }
                    this.jtG.cyN();
                    onPrepared(null);
                    czK();
                    if (this.jyu) {
                        cua();
                    }
                }
                if (this.jyu) {
                    TiebaStatic.log(new an("c13357").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).X("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jyr = false;
        if (this.jye != null) {
            this.jye.cancelAnimation();
        }
        this.jtG.stop();
        this.jtG.cyS();
        this.jyi.akj();
        zy(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLz);
        MessageManager.getInstance().unRegisterListener(this.jyI);
    }

    private void czF() {
        this.jyr = false;
        if (this.jye != null) {
            this.jye.cancelAnimation();
        }
        this.jtG.stop();
        this.jyi.akj();
        zy(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cLz);
        MessageManager.getInstance().unRegisterListener(this.jyI);
    }

    public void cua() {
        if (this.jyt != null && this.jyt.czd() != null) {
            y czu = this.jyt.czd().czu();
            czu.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(czu.jwW, "", "1", czu);
        }
    }

    public void zy(int i) {
        czD();
        if (this.jya == this.jxY) {
            this.jyb = i;
            return;
        }
        this.jya = i;
        this.OY.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jyd.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jye.clearAnimation();
        this.jye.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jye.cancelAnimation();
        } else {
            this.jye.setAlpha(1.0f);
        }
        this.OZ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Pa.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Pb.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.Pi && (homePageStyleAbTest & 4) != 0) {
            this.Pc.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.Pe.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jyg.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jyh.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jyi.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jyf.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jyi.getVisibility() == 0) {
            this.jyi.showProgress();
        }
        this.jyj.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jyk.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jyk.getVisibility() == 0) {
            this.jyk.setAlpha(1.0f);
        }
        this.jyl.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jym.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jyn.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jyp.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zz(id);
            if (id == R.id.video_mute) {
                czH();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                czJ();
            } else if (id == R.id.video_replay) {
                zy(this.STATE_STOP);
                startPlay();
                if (this.jyu) {
                    TiebaStatic.log(new an("c13345").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_locate", this.iEa ? 1 : 2));
                }
                czG();
            } else if (id == R.id.video_play) {
                if (this.jya == this.STATE_STOP) {
                    startPlay();
                } else {
                    zy(this.jxU);
                    czC();
                    this.jtG.b(this.jyH);
                }
                if (this.jyu) {
                    TiebaStatic.log(new an("c13344").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", this.iEa ? 1 : 2).X("obj_locate", 1));
                }
                czG();
            } else if (id == R.id.video_pause) {
                zy(this.STATE_PAUSE);
                czD();
                this.jtG.pause();
                if (this.jyu) {
                    TiebaStatic.log(new an("c13344").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2).X("obj_source", this.iEa ? 1 : 2).X("obj_locate", 2));
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
    public void czG() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.MO);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void ctO() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jtG.setVolume(0.0f, 0.0f);
            this.jyg.setState(1);
            return;
        }
        this.jtG.setVolume(1.0f, 1.0f);
        this.jyg.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void czH() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jtG.setVolume(1.0f, 1.0f);
            af.a(this.Pf, true);
            this.jyg.setState(0);
        } else {
            this.jtG.setVolume(0.0f, 0.0f);
            this.jyg.setState(1);
            af.a(this.Pf, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void rQ(boolean z) {
        if (this.eex == null) {
            this.eex = new o((Activity) this.mContext);
        }
        if (z) {
            this.eex.start();
            this.eex.bn(true);
            return;
        }
        this.eex.stop();
        this.eex.bn(false);
    }

    public void czI() {
        ra(true);
    }

    public void ra(boolean z) {
        if (this.mRootView != null && this.jyq != null && this.jtG != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jtG.setFullScreenToDestroySurface();
            if (this.eex == null) {
                this.eex = new o((Activity) this.mContext);
            }
            if (this.iEa) {
                if (this.jyo.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jyo.getParent()).removeView(this.jyo);
                }
                if ((this.jyq.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iEa = false;
                    ((ViewGroup) this.jyq.getParent()).removeView(this.jyq);
                    ((ViewGroup) this.mRootView).addView(this.jyq);
                    h((Activity) this.mContext, this.iEa);
                }
                if (!this.Pi && z) {
                    this.eex.Aa();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.Pi && z) {
                        this.eex.Aa();
                    }
                    if (this.mContext instanceof Activity) {
                        this.jyq.getLocationOnScreen(this.jyy);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jyo == null) {
                                    this.jyo = new View(this.mContext);
                                    this.jyo.setClickable(true);
                                    this.jyo.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jyo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jyo.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jyo.getParent()).removeView(this.jyo);
                                }
                                this.jyo.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jyo);
                                ((ViewGroup) childAt).addView(this.jyq);
                                this.iEa = true;
                                h((Activity) this.mContext, this.iEa);
                                if (this.gNR != null && this.gNR.isShowing()) {
                                    this.gNR.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jyu) {
                    TiebaStatic.log(new an("c13360").cy("tid", this.Pj).s("fid", this.mFid).X("obj_type", this.Pi ? 1 : 2));
                }
            }
            ctT();
            ctU();
            if (this.jtG.isPlaying()) {
                zy(this.jxS);
            } else {
                this.jya |= 1;
                zy(this.jya);
            }
            this.jyh.cTD();
            mM(this.iEa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czJ() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.Pi) {
            czI();
        } else if (this.jya == this.jxY) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jyq.setScaleX(1.0f);
                    d.this.jyq.setScaleY(1.0f);
                    d.this.jyq.setTranslationX(0.0f);
                    d.this.jyq.setTranslationY(0.0f);
                    d.this.jyk.setScaleX(1.0f);
                    d.this.jyk.setScaleY(1.0f);
                    d.this.jyq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jyA) {
                        d.this.czI();
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
            if (!this.jyA) {
                float width = this.mRootView.getWidth() / this.jyq.getWidth();
                float height = this.mRootView.getHeight() / this.jyq.getHeight();
                this.jyq.setPivotX(0.0f);
                this.jyq.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jyq, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jyq, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jyk, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jyk, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jyq, "TranslationX", this.jyq.getTranslationX(), this.jyy[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jyq, "TranslationY", this.jyq.getTranslationY(), this.jyy[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jyo, "alpha", this.jyo.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jyk, "alpha", this.jyk.getAlpha(), 0.0f);
            } else {
                float width2 = this.jyw / this.jyq.getWidth();
                float height2 = this.jyz / this.jyq.getHeight();
                this.jyq.setPivotX(0.0f);
                this.jyq.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jyq, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jyq, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jyk, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jyk, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jyq, "TranslationX", this.jyq.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jyq, "TranslationY", this.jyq.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jyk, "alpha", this.jyk.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jyb != -1) {
                this.jya = this.jyb;
                this.jyb = -1;
                if (this.jya == this.jxZ || this.jya == this.jxU || this.jya == this.jxS) {
                    this.jtG.b(this.jyH);
                    zy(this.jxS);
                }
            }
        } else {
            czI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.Pi && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jyq != null) {
                    if (z) {
                        this.jyq.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jyq.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                ccC();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.jyq.setSystemUiVisibility(0);
            }
        }
    }

    private void czK() {
        zy(this.jxT);
        this.jyi.showProgress();
        czE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mM(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        ctO();
        if (this.jyr) {
            if (this.iEa && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jtG.b(this.jyH);
            if (cxX() && ((QuickVideoView) this.jtG).jvH) {
                czE();
            }
        }
    }

    public void onCompletion(g gVar) {
        zy(this.jxW);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zy(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jya == this.STATE_PAUSE || (this.jya == this.jxV && !this.jtG.isPlaying())) {
            czF();
            zy(this.STATE_PAUSE);
        } else if (this.jya == this.jxW) {
            czF();
            zy(this.jxW);
        } else {
            czF();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            czK();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cys() {
        return this.jyq;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jyr || this.jtG.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jtG.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bfJ() {
    }

    protected void zz(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.iEa;
    }

    protected boolean ctQ() {
        return this.Pi && this.iEa;
    }

    public boolean cxX() {
        return !this.isNewPlayer && (this.jtG instanceof QuickVideoView);
    }

    private void ccC() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jyq.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jyq.setSystemUiVisibility(4);
        } else {
            this.jyq.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean ctW() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jtG.isPlaying() && !af.aSw()) {
            this.jtG.setVolume(1.0f, 1.0f);
            this.jyg.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean ctX() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        if (z) {
            this.jye.cancelAnimation();
            if (this.jya == this.jxS || this.jya == this.jxT || this.jya == this.jxU || this.jya == this.STATE_STOP) {
                stopPlay();
            }
            this.jya |= 1;
            zy(this.jya);
        } else if (this.jya == this.STATE_STOP) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.iEa;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.iEa) {
            czJ();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int bPm() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean czL() {
        return this.jyF != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rR(boolean z) {
        this.Kn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jyG = aVar;
    }
}
