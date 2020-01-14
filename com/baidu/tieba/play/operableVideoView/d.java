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
    protected BdUniqueId Mm;
    private TextView OA;
    private TextView OB;
    protected boolean OF;
    protected String OG;
    protected long OH;
    protected long OI;
    protected TbImageView Ow;
    private ImageView Ox;
    private ImageView Oy;
    private TextView Oz;
    private o eag;
    private com.baidu.mcn.c gLE;
    protected com.baidu.tieba.play.a.a jsG;
    private View jwZ;
    private McnAdInfo jxA;
    private a jxB;
    private TBLottieAnimationView jxa;
    private PercentSizeView jxb;
    protected SwitchImageView jxc;
    protected SwitchImageView jxd;
    protected OperableVideoMediaControllerView jxe;
    protected OperableVideoNetworkStateTipView jxf;
    protected OperableVideoShareView jxg;
    protected ImageView jxh;
    protected View jxi;
    protected VideoGestureView jxj;
    private View jxk;
    private OperableVideoErrorView jxl;
    protected ViewGroup jxm;
    protected boolean jxn;
    private n jxo;
    private float jxq;
    private float jxr;
    private int jxs;
    private int jxu;
    private boolean jxv;
    private float jxy;
    private int jxz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jwy = 3000;
    protected final int jwz = 1;
    protected final int jwA = 2;
    protected final int jwB = 4;
    protected final int jwC = 8;
    protected final int jwD = 16;
    protected final int jwE = 32;
    protected final int jwF = 64;
    protected final int jwG = 128;
    protected final int jwH = 256;
    protected final int jwI = 512;
    protected final int jwJ = 1024;
    protected final int jwK = 2048;
    protected final int jwL = 4096;
    protected final int jwM = 8192;
    protected int STATE_STOP = 8211;
    protected int jwN = 0;
    protected int jwO = 4;
    protected int jwP = 232;
    protected int STATE_PAUSE = 8416;
    protected int jwQ = 0;
    protected int jwR = 513;
    protected int jwS = 259;
    protected int jwT = 2048;
    protected int jwU = 0;
    protected int STATE_ERROR = 4099;
    protected int jwV = this.STATE_STOP;
    private int jwW = 0;
    private int jwX = -1;
    private Runnable jwY = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zr(d.this.jwN);
        }
    };
    private WeakReference<Context> OC = null;
    protected boolean iBU = false;
    private boolean isNewPlayer = false;
    protected boolean jxp = true;
    private int[] jxt = new int[2];
    private int jxw = 0;
    private int jxx = 0;
    protected View.OnClickListener MG = null;
    protected View.OnClickListener JI = null;
    private boolean JR = false;
    private long startPosition = -1;
    protected boolean NT = false;
    private TbImageView.c Nr = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a vg = com.baidu.tbadk.imageManager.c.aNs().vg(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), 10));
                if (vg != null) {
                    int width = vg.getWidth();
                    i = vg.getHeight();
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
                        if (d.this.NT && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener dVU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.zr(d.this.jwP);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jsG.isPlaying()) {
                    d.this.jsG.b(d.this.jxD);
                }
                d.this.cyf();
                if (d.this.jxp) {
                    TiebaStatic.log(new an("c13355").cp("tid", d.this.OG).s("fid", d.this.mFid).Z("obj_type", d.this.OF ? 1 : 2).Z("obj_locate", d.this.iBU ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jxC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jsG.isPlaying()) {
                d.this.jsG.pause();
                if (d.this.jwV == d.this.jwP) {
                    d.this.zr(d.this.STATE_PAUSE);
                } else {
                    d.this.zr(d.this.jwQ);
                }
                d.this.zs(R.id.video_pause);
            } else if (d.this.jwV == d.this.STATE_PAUSE || d.this.jwV == (d.this.STATE_PAUSE | 1)) {
                d.this.zr(d.this.jwP);
                d.this.cyf();
                d.this.jsG.b(d.this.jxD);
                d.this.zs(R.id.video_play);
            } else if (d.this.jwV == d.this.jwQ || d.this.jwV == (d.this.jwQ | 1)) {
                d.this.zr(d.this.jwN);
                d.this.jsG.b(d.this.jxD);
                d.this.zs(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jsG.isPlaying()) {
                if (d.this.jwV == d.this.jwN || d.this.jwV == d.this.jwO) {
                    d.this.zr(d.this.jwP);
                    d.this.cyf();
                    return true;
                } else if (d.this.jwV == d.this.jwP) {
                    d.this.zr(d.this.jwN);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jwV == d.this.STATE_PAUSE) {
                d.this.zr(d.this.jwQ);
                return true;
            } else if (d.this.jwV == (d.this.STATE_PAUSE | 1)) {
                d.this.zr(d.this.jwQ | 1);
                return true;
            } else if (d.this.jwV == d.this.jwQ) {
                d.this.zr(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jwV == (d.this.jwQ | 1)) {
                d.this.zr(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zr(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.cyi();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.jwW = 0;
            if (d.this.iBU) {
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
            if (d.this.OF && d.this.csu()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.jwW) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jsG.isPlaying()) {
                                d.this.jsG.pause();
                                d.this.zr(d.this.jwU);
                            }
                            d.this.jwW = 4;
                            d.this.jwX = d.this.jwV;
                            d.this.jwV = d.this.jwT;
                            d.this.jxu = d.this.jxm.getMeasuredHeight();
                            d.this.jxy = d.this.jxr / d.this.jxu;
                            d.this.jxz = (int) (1.2f * d.this.mRootView.getWidth());
                            cw(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cw(rawX, rawY);
                        break;
                }
            } else if (d.this.jwV == d.this.jwN || d.this.jwV == d.this.jwP || d.this.jwV == d.this.STATE_PAUSE || d.this.jwV == d.this.jwQ || d.this.jwV == d.this.jwT || d.this.jwV == (d.this.STATE_PAUSE | 1) || d.this.jwV == (d.this.jwQ | 1)) {
                switch (d.this.jwW) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.jwW = 3;
                            d.this.jxs = d.this.jsG.getCurrentPosition();
                            aJ(f);
                        } else if (motionEvent.getX() < d.this.jxm.getWidth() / 2) {
                            d.this.jwW = 2;
                            d.this.jxj.m(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.jwW = 1;
                            d.this.jxj.l(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jwV != d.this.jwT) {
                            if ((d.this.jwV & 1) > 0) {
                                d.this.jwT |= 1;
                            } else {
                                d.this.jwT &= -2;
                            }
                            d.this.zr(d.this.jwT);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jxj.l(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.csA();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jxj.m(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aJ(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cw(int i, int i2) {
            if (d.this.jxw != i2 || d.this.jxx != i) {
                d.this.jxv = d.this.jxw - i2 > 0 || ((float) i2) < d.this.jxq / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jxm.getLayoutParams();
                if (i2 != d.this.jxw) {
                    int i3 = d.this.jxu - i2;
                    int i4 = (int) (i3 * d.this.jxy);
                    if (i4 < d.this.jxz) {
                        i4 = d.this.jxz;
                        i3 = (int) (i4 / d.this.jxy);
                    }
                    if (i4 != d.this.jxz) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jxm.setLayoutParams(layoutParams);
                    }
                    d.this.jxw = i2;
                    d.this.jxm.setTranslationY(d.this.jxw);
                }
                if (i != d.this.jxw) {
                    d.this.jxx = i;
                    d.this.jxm.setTranslationX(d.this.jxx + ((d.this.jxr - layoutParams.width) / 2.0f));
                }
                d.this.jxk.setAlpha((layoutParams.width - d.this.jxz) / (d.this.jxr - d.this.jxz));
                if (d.this.jxg.getVisibility() == 0) {
                    float f = d.this.jxq / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jxg.setAlpha(f2);
                }
            }
        }

        private void aJ(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jxs -= 1000;
                z = true;
            } else {
                d.this.jxs += 1000;
                z = false;
            }
            int duration = d.this.jsG.getDuration();
            if (d.this.jxs < 0) {
                d.this.jxs = 0;
            } else if (d.this.jxs > duration) {
                d.this.jxs = duration;
            }
            String str = aq.stringForVideoTime(d.this.jxs) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jxj != null) {
                d.this.jxj.x(z, str);
            }
            d.this.jxe.setCurrentDuration(d.this.jxs, false);
        }
    };
    private View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jwV == d.this.jwT) {
                if (d.this.jwW == 4) {
                    d.this.cyl();
                    d.this.jxw = 0;
                    d.this.jxx = 0;
                } else {
                    d.this.jwV = -1;
                    if (d.this.jwW != 3) {
                        if (d.this.jwX != -1) {
                            d.this.zr(d.this.jwX);
                            d.this.jwX = -1;
                        } else if (d.this.jsG.isPlaying()) {
                            d.this.zr(d.this.jwN);
                        } else {
                            d.this.zr(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jxe.setCurrentDuration(d.this.jxs, true);
                        if (d.this.jxs <= d.this.jsG.getDuration()) {
                            if (!d.this.jsG.isPlaying()) {
                                d.this.jsG.b(d.this.jxD);
                            }
                            d.this.zr(d.this.jwN);
                        }
                    }
                }
                if (d.this.jxp) {
                    String str = null;
                    if (d.this.jwW != 1) {
                        if (d.this.jwW != 2) {
                            if (d.this.jwW == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).cp("tid", d.this.OG).s("fid", d.this.mFid));
                    }
                }
                d.this.jwW = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jxD = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cya() {
            d.this.jsG.cxv();
            d.this.cye();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cyb() {
            d.this.zr(d.this.STATE_STOP);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener cHu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener jxE = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.OC, true);
                    }
                    d.this.jsG.setVolume(1.0f, 1.0f);
                    d.this.jxc.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.css();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bW(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.jxq = l.getEquipmentHeight(this.mContext);
            this.jxr = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void csy() {
        int dimension;
        int i;
        int i2;
        this.jxf.af(this.OF, this.iBU);
        this.jxg.af(this.OF, this.iBU);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.OF) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.iBU) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.Oz.setPadding(0, 0, i2, 0);
            this.jxd.setPadding(this.jxd.getPaddingLeft(), 0, i, 0);
            this.jxc.setPadding(dimension, 0, 0, 0);
        }
    }

    public void csx() {
        if (this.OF) {
            this.jwP = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jwP = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iBU) {
            this.STATE_STOP |= 1024;
            this.jwN |= 1024;
            this.jwO |= 1024;
            this.jwP |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jwQ |= 1024;
            this.jwR |= 1024;
            this.jwS |= 1024;
            this.jwV |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jwN &= -1025;
        this.jwO &= -1025;
        this.jwP &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jwQ &= -1025;
        this.jwR &= -1025;
        this.jwS &= -1025;
        this.jwV &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jxm = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jxm);
            }
            this.OC = new WeakReference<>(TbadkCoreApplication.getInst());
            this.Ow = (TbImageView) this.jxm.findViewById(R.id.video_thumbnail);
            this.jwZ = this.jxm.findViewById(R.id.black_mask);
            this.jxa = (TBLottieAnimationView) this.jxm.findViewById(R.id.video_loading);
            this.Ox = (ImageView) this.jxm.findViewById(R.id.video_play);
            this.jxb = (PercentSizeView) this.jxm.findViewById(R.id.video_media_controller_mask);
            this.Oy = (ImageView) this.jxm.findViewById(R.id.video_pause);
            this.Oz = (TextView) this.jxm.findViewById(R.id.video_play_count);
            this.OA = (TextView) this.jxm.findViewById(R.id.video_play_flag);
            this.OB = (TextView) this.jxm.findViewById(R.id.video_duration);
            this.jxc = (SwitchImageView) this.jxm.findViewById(R.id.video_mute);
            this.jxd = (SwitchImageView) this.jxm.findViewById(R.id.video_full_screen);
            this.jxe = (OperableVideoMediaControllerView) this.jxm.findViewById(R.id.video_media_controller);
            this.jxf = (OperableVideoNetworkStateTipView) this.jxm.findViewById(R.id.video_network_state_tip);
            this.jxg = (OperableVideoShareView) this.jxm.findViewById(R.id.video_share_view);
            this.jxi = this.jxm.findViewById(R.id.video_back_btn_mask);
            this.jxh = (ImageView) this.jxm.findViewById(R.id.video_full_screen_back);
            this.jxj = (VideoGestureView) this.jxm.findViewById(R.id.video_gesture);
            this.jxl = (OperableVideoErrorView) this.jxm.findViewById(R.id.video_error_layout);
            this.jxg.setVideoContainer(this);
            this.jxo = new n(this.mContext);
            this.jxo.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bx(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cyn() && !d.this.OF && !d.this.iBU && d.this.JR) {
                        if (!com.baidu.mcn.b.Bo().em(d.this.jxA.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jxA.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jxA.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jxA.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gLE.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aHe = d.this.jxA.card_title;
                                    aVar.aHf = d.this.jxA.button_title;
                                    aVar.aHg = d.this.jxA.jump_url;
                                    aVar.aHd = d.this.jxA.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.OG;
                                    aVar.aHh = d.this.bNH();
                                    if (z2) {
                                        d.this.gLE.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.gLE.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.gLE.isShowing()) {
                                d.this.gLE.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.jxB != null) {
                        d.this.jxB.bW(i, i2);
                    }
                }
            });
            this.jxa.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jxa.setVisibility(8);
                    d.this.Ox.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jxa.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aEp().a(this.Ox, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Ox.setOnClickListener(this);
            this.jxc.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jxc.setState(1);
            this.jxc.setOnClickListener(this);
            this.Ow.aQz();
            this.Ow.setDrawCorner(false);
            this.Ow.setPlaceHolder(3);
            this.jxe.setOnSeekBarChangeListener(this.dVU);
            this.jxb.setHeightPercent(0.583f);
            this.jxb.setBackgroundResource(R.drawable.video_mask_bg);
            this.jxd.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jxd.setState(0);
            this.jxd.setOnClickListener(this);
            SvgManager.aEp().a(this.Oy, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Oy.setOnClickListener(this);
            this.jxh.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rs("cyber_player_test");
            this.jsG = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jsG.setTryUseViewInSet(true);
            cye();
            this.jxf.setPlayViewOnClickListener(this);
            this.jxm.setOnClickListener(null);
            this.jxm.setOnTouchListener(this.dnp);
            this.jxg.setOnTouchListener(this.dnp);
            this.jxl.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jxC);
            zr(this.STATE_STOP);
            this.gLE = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cye() {
        if (this.jsG != null && this.jsG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jxm.addView(this.jsG.getView(), 0);
            this.jsG.getView().setLayoutParams(layoutParams);
            this.jxe.setPlayer(this.jsG);
            if (cwB()) {
                ((QuickVideoView) this.jsG).setNeedRecovery(true);
                ((QuickVideoView) this.jsG).setPlayerReuseEnable(true);
            }
            this.jsG.setContinuePlayEnable(true);
            this.jsG.setBusiness(this.jxo);
            this.jsG.setOnPreparedListener(this);
            this.jsG.setOnCompletionListener(this);
            this.jsG.setOnErrorListener(this);
            this.jsG.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aAo() != null) {
            this.startPosition = -1L;
            if (this.gLE != null) {
                this.gLE.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aAo().video_url)) {
                stopPlay();
                this.OF = bjVar.aAo().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aAo().video_url;
                this.OG = bjVar.getTid();
                this.OH = bjVar.aAo().video_length.intValue();
                this.OI = bjVar.aAo().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.jxA = bjVar.aAo().mcn_ad_card;
                csx();
                csy();
                zr(this.STATE_STOP);
                int intValue = bjVar.aAo().video_duration.intValue() * 1000;
                this.jxe.Aj(intValue);
                this.jxe.setPlayer(this.jsG);
                this.OB.setText(aq.stringForVideoTime(intValue));
                this.Oz.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aAo().play_count.intValue())));
                this.jxf.setVideoLength(bjVar.aAo().video_length.intValue());
                this.jxf.setVideoDuration(bjVar.aAo().video_duration.intValue());
                this.jxf.setTid(this.OG);
                this.jxo.cxD().ai(bjVar);
                this.OA.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.aAo().wth_mid_loc != null && bjVar.aAo().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.Ow.setScaleType(ImageView.ScaleType.MATRIX);
                    this.Ow.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.OF) {
                        this.OB.setText("");
                        this.Oz.setText("");
                        this.OA.setVisibility(0);
                    }
                    this.Ow.setSmartCropCenterPointWidthRatio(bjVar.aAo().wth_mid_loc.floatValue());
                    this.Ow.setSmartCropCenterPointHeightRatio(bjVar.aAo().hth_mid_loc.floatValue());
                    this.Ow.setOnDrawListener(this.Nr);
                }
                this.Ow.setPlaceHolder(3);
                this.Ow.startLoad(bjVar.aAo().thumbnail_url, 10, false);
                this.jxg.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.NT = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jxo != null) {
            this.jxo.setVideoStatsData(yVar);
            this.jsG.setBusiness(this.jxo);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cxD() {
        if (this.jxo == null) {
            return null;
        }
        return this.jxo.cxD();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Z(View.OnClickListener onClickListener) {
        this.JI = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Mm = bdUniqueId;
    }

    public void cyf() {
        e.gx().removeCallbacks(this.jwY);
        e.gx().postDelayed(this.jwY, this.jwy);
    }

    public void cyg() {
        e.gx().removeCallbacks(this.jwY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jxa.setAlpha(1.0f);
        this.jxa.setVisibility(0);
        this.Ox.setVisibility(8);
        if (this.jxa != null) {
            this.jxa.loop(true);
            this.jxa.setMinAndMaxFrame(14, 80);
            this.jxa.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cst() {
        if (this.jwV == this.jwO) {
            zr(this.jwN);
        }
    }

    private void cyh() {
        zr(this.jwO);
        this.jxe.showProgress();
        if (this.jxa != null) {
            this.jxa.clearAnimation();
            this.jxa.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cst();
                    if (!d.this.jxn) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jxa.setVisibility(8);
                    d.this.Ox.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean csw() {
        return this.jxf != null && this.jxf.csE();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.cHu);
        MessageManager.getInstance().registerListener(this.jxE);
        if (csw()) {
            zr(this.jwS);
            return;
        }
        this.jxn = true;
        if (!this.jsG.isPlaying()) {
            com.baidu.tieba.play.a.a GQ = TbVideoViewSet.cxZ().GQ(this.mVideoUrl);
            if (GQ == null) {
                this.jsG.cxv();
                if (!StringUtils.isNull(this.jsG.getOriginUrl())) {
                    this.jsG = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
                    this.jsG.setTryUseViewInSet(true);
                }
                cye();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.jsG.setVideoPath(this.mVideoUrl, this.OG);
                    startLoadingAnim();
                }
            } else {
                if (this.jsG == GQ) {
                    if (this.jsG.getParent() == null || this.jsG.getParent() != GQ.getParent()) {
                        this.jsG.cxv();
                        cye();
                    }
                } else {
                    this.jsG.cxv();
                    GQ.cxv();
                    this.jsG = GQ;
                    this.jsG.setTryUseViewInSet(true);
                    cye();
                }
                this.jsG.cxr();
                onPrepared(null);
                cym();
            }
            if (this.jxp) {
                TiebaStatic.log(new an("c13357").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).Z("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jxn = false;
        if (this.jxa != null) {
            this.jxa.cancelAnimation();
        }
        this.jsG.stop();
        this.jsG.cxv();
        this.jxe.ahT();
        zr(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cHu);
        MessageManager.getInstance().unRegisterListener(this.jxE);
    }

    public void zr(int i) {
        cyg();
        if (this.jwV == this.jwT) {
            this.jwX = i;
            return;
        }
        this.jwV = i;
        this.Ow.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jwZ.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jxa.clearAnimation();
        this.jxa.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jxa.cancelAnimation();
        } else {
            this.jxa.setAlpha(1.0f);
        }
        this.Ox.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Oy.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Oz.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.OF && (homePageStyleAbTest & 4) != 0) {
            this.OA.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.OB.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jxc.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jxd.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jxe.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jxb.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jxe.getVisibility() == 0) {
            this.jxe.showProgress();
        }
        this.jxf.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jxg.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jxg.getVisibility() == 0) {
            this.jxg.setAlpha(1.0f);
        }
        this.jxh.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jxi.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jxj.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jxl.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zs(id);
            if (id == R.id.video_mute) {
                cyj();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cyl();
            } else if (id == R.id.video_replay) {
                zr(this.STATE_STOP);
                startPlay();
                if (this.jxp) {
                    TiebaStatic.log(new an("c13345").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_locate", this.iBU ? 1 : 2));
                }
                cyi();
            } else if (id == R.id.video_play) {
                if (this.jwV == this.STATE_STOP) {
                    startPlay();
                } else {
                    zr(this.jwP);
                    cyf();
                    this.jsG.b(this.jxD);
                }
                if (this.jxp) {
                    TiebaStatic.log(new an("c13344").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_source", this.iBU ? 1 : 2).Z("obj_locate", 1));
                }
                cyi();
            } else if (id == R.id.video_pause) {
                zr(this.STATE_PAUSE);
                cyg();
                this.jsG.pause();
                if (this.jxp) {
                    TiebaStatic.log(new an("c13344").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_source", this.iBU ? 1 : 2).Z("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                zr(this.STATE_STOP);
                startPlay();
            } else if (id == R.id.retry) {
                zr(this.STATE_STOP);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Mm);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void css() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jsG.setVolume(0.0f, 0.0f);
            this.jxc.setState(1);
            return;
        }
        this.jsG.setVolume(1.0f, 1.0f);
        this.jxc.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cyj() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jsG.setVolume(1.0f, 1.0f);
            af.a(this.OC, true);
            this.jxc.setState(0);
        } else {
            this.jsG.setVolume(0.0f, 0.0f);
            this.jxc.setState(1);
            af.a(this.OC, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void rN(boolean z) {
        if (this.eag == null) {
            this.eag = new o((Activity) this.mContext);
        }
        if (z) {
            this.eag.start();
            this.eag.bf(true);
            return;
        }
        this.eag.stop();
        this.eag.bf(false);
    }

    public void cyk() {
        qV(true);
    }

    public void qV(boolean z) {
        if (this.mRootView != null && this.jxm != null && this.jsG != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jsG.setFullScreenToDestroySurface();
            if (this.eag == null) {
                this.eag = new o((Activity) this.mContext);
            }
            if (this.iBU) {
                if (this.jxk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jxk.getParent()).removeView(this.jxk);
                }
                if ((this.jxm.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iBU = false;
                    ((ViewGroup) this.jxm.getParent()).removeView(this.jxm);
                    ((ViewGroup) this.mRootView).addView(this.jxm);
                    h((Activity) this.mContext, this.iBU);
                }
                if (!this.OF && z) {
                    this.eag.xH();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.OF && z) {
                        this.eag.xH();
                    }
                    if (this.mContext instanceof Activity) {
                        this.jxm.getLocationOnScreen(this.jxt);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jxk == null) {
                                    this.jxk = new View(this.mContext);
                                    this.jxk.setClickable(true);
                                    this.jxk.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jxk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jxk.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jxk.getParent()).removeView(this.jxk);
                                }
                                this.jxk.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jxk);
                                ((ViewGroup) childAt).addView(this.jxm);
                                this.iBU = true;
                                h((Activity) this.mContext, this.iBU);
                                if (this.gLE != null && this.gLE.isShowing()) {
                                    this.gLE.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jxp) {
                    TiebaStatic.log(new an("c13360").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2));
                }
            }
            csx();
            csy();
            if (this.jsG.isPlaying()) {
                zr(this.jwN);
            } else {
                this.jwV |= 1;
                zr(this.jwV);
            }
            this.jxd.cSf();
            mK(this.iBU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyl() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.OF) {
            cyk();
        } else if (this.jwV == this.jwT) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jxm.setScaleX(1.0f);
                    d.this.jxm.setScaleY(1.0f);
                    d.this.jxm.setTranslationX(0.0f);
                    d.this.jxm.setTranslationY(0.0f);
                    d.this.jxg.setScaleX(1.0f);
                    d.this.jxg.setScaleY(1.0f);
                    d.this.jxm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jxv) {
                        d.this.cyk();
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
            if (!this.jxv) {
                float width = this.mRootView.getWidth() / this.jxm.getWidth();
                float height = this.mRootView.getHeight() / this.jxm.getHeight();
                this.jxm.setPivotX(0.0f);
                this.jxm.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jxm, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jxm, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxg, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxg, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jxm, "TranslationX", this.jxm.getTranslationX(), this.jxt[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jxm, "TranslationY", this.jxm.getTranslationY(), this.jxt[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jxk, "alpha", this.jxk.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxg, "alpha", this.jxg.getAlpha(), 0.0f);
            } else {
                float width2 = this.jxr / this.jxm.getWidth();
                float height2 = this.jxu / this.jxm.getHeight();
                this.jxm.setPivotX(0.0f);
                this.jxm.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jxm, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jxm, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxg, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxg, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jxm, "TranslationX", this.jxm.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jxm, "TranslationY", this.jxm.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxg, "alpha", this.jxg.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jwX != -1) {
                this.jwV = this.jwX;
                this.jwX = -1;
                if (this.jwV == this.jwU || this.jwV == this.jwP || this.jwV == this.jwN) {
                    this.jsG.b(this.jxD);
                    zr(this.jwN);
                }
            }
        } else {
            cyk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.OF && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jxm != null) {
                    if (z) {
                        this.jxm.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jxm.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                caY();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.jxm.setSystemUiVisibility(0);
            }
        }
    }

    private void cym() {
        zr(this.jwO);
        this.jxe.showProgress();
        cyh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mK(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        css();
        if (this.jxn) {
            if (this.iBU && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jsG.b(this.jxD);
            if (cwB() && ((QuickVideoView) this.jsG).juE) {
                cyh();
            }
        }
    }

    public void onCompletion(g gVar) {
        zr(this.jwR);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zr(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jwV == this.STATE_PAUSE || (this.jwV == this.jwQ && !this.jsG.isPlaying())) {
            stopPlay();
            zr(this.STATE_PAUSE);
        } else if (this.jwV == this.jwR) {
            stopPlay();
            zr(this.jwR);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cym();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cwW() {
        return this.jxm;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jxn || this.jsG.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jsG.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
        if ("index".equals(this.mFrom)) {
            this.jsG.setPageTypeForPerfStat("homepage");
        } else {
            this.jsG.setPageTypeForPerfStat(this.mFrom);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bdy() {
    }

    protected void zs(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.iBU;
    }

    protected boolean csu() {
        return this.OF && this.iBU;
    }

    public boolean cwB() {
        return !this.isNewPlayer && (this.jsG instanceof QuickVideoView);
    }

    private void caY() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jxm.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jxm.setSystemUiVisibility(4);
        } else {
            this.jxm.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean csA() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jsG.isPlaying() && !af.aQc()) {
            this.jsG.setVolume(1.0f, 1.0f);
            this.jxc.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean csB() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean mJ(boolean z) {
        if (z) {
            this.jxa.cancelAnimation();
            if (this.jwV == this.jwN || this.jwV == this.jwO || this.jwV == this.jwP || this.jwV == this.STATE_STOP) {
                stopPlay();
            }
            this.jwV |= 1;
            zr(this.jwV);
        } else if (this.jwV == this.STATE_STOP) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.iBU;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.iBU) {
            cyl();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int bNH() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cyn() {
        return this.jxA != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rO(boolean z) {
        this.JR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jxB = aVar;
    }
}
