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
    protected com.baidu.tieba.play.a.a jsB;
    private View jwU;
    private TBLottieAnimationView jwV;
    private PercentSizeView jwW;
    protected SwitchImageView jwX;
    protected SwitchImageView jwY;
    protected OperableVideoMediaControllerView jwZ;
    protected OperableVideoNetworkStateTipView jxa;
    protected OperableVideoShareView jxb;
    protected ImageView jxc;
    protected View jxd;
    protected VideoGestureView jxe;
    private View jxf;
    private OperableVideoErrorView jxg;
    protected ViewGroup jxh;
    protected boolean jxi;
    private n jxj;
    private float jxl;
    private float jxm;
    private int jxn;
    private int jxp;
    private boolean jxq;
    private float jxt;
    private int jxu;
    private McnAdInfo jxv;
    private a jxw;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jwt = 3000;
    protected final int jwu = 1;
    protected final int jwv = 2;
    protected final int jww = 4;
    protected final int jwx = 8;
    protected final int jwy = 16;
    protected final int jwz = 32;
    protected final int jwA = 64;
    protected final int jwB = 128;
    protected final int jwC = 256;
    protected final int jwD = 512;
    protected final int jwE = 1024;
    protected final int jwF = 2048;
    protected final int jwG = 4096;
    protected final int jwH = 8192;
    protected int STATE_STOP = 8211;
    protected int jwI = 0;
    protected int jwJ = 4;
    protected int jwK = 232;
    protected int STATE_PAUSE = 8416;
    protected int jwL = 0;
    protected int jwM = 513;
    protected int jwN = 259;
    protected int jwO = 2048;
    protected int jwP = 0;
    protected int STATE_ERROR = 4099;
    protected int jwQ = this.STATE_STOP;
    private int jwR = 0;
    private int jwS = -1;
    private Runnable jwT = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zr(d.this.jwI);
        }
    };
    private WeakReference<Context> OC = null;
    protected boolean iBU = false;
    private boolean isNewPlayer = false;
    protected boolean jxk = true;
    private int[] jxo = new int[2];
    private int jxr = 0;
    private int jxs = 0;
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
            d.this.zr(d.this.jwK);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jsB.isPlaying()) {
                    d.this.jsB.b(d.this.jxy);
                }
                d.this.cyd();
                if (d.this.jxk) {
                    TiebaStatic.log(new an("c13355").cp("tid", d.this.OG).s("fid", d.this.mFid).Z("obj_type", d.this.OF ? 1 : 2).Z("obj_locate", d.this.iBU ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jxx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jsB.isPlaying()) {
                d.this.jsB.pause();
                if (d.this.jwQ == d.this.jwK) {
                    d.this.zr(d.this.STATE_PAUSE);
                } else {
                    d.this.zr(d.this.jwL);
                }
                d.this.zs(R.id.video_pause);
            } else if (d.this.jwQ == d.this.STATE_PAUSE || d.this.jwQ == (d.this.STATE_PAUSE | 1)) {
                d.this.zr(d.this.jwK);
                d.this.cyd();
                d.this.jsB.b(d.this.jxy);
                d.this.zs(R.id.video_play);
            } else if (d.this.jwQ == d.this.jwL || d.this.jwQ == (d.this.jwL | 1)) {
                d.this.zr(d.this.jwI);
                d.this.jsB.b(d.this.jxy);
                d.this.zs(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jsB.isPlaying()) {
                if (d.this.jwQ == d.this.jwI || d.this.jwQ == d.this.jwJ) {
                    d.this.zr(d.this.jwK);
                    d.this.cyd();
                    return true;
                } else if (d.this.jwQ == d.this.jwK) {
                    d.this.zr(d.this.jwI);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jwQ == d.this.STATE_PAUSE) {
                d.this.zr(d.this.jwL);
                return true;
            } else if (d.this.jwQ == (d.this.STATE_PAUSE | 1)) {
                d.this.zr(d.this.jwL | 1);
                return true;
            } else if (d.this.jwQ == d.this.jwL) {
                d.this.zr(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jwQ == (d.this.jwL | 1)) {
                d.this.zr(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zr(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.cyg();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.jwR = 0;
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
            if (d.this.OF && d.this.css()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.jwR) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jsB.isPlaying()) {
                                d.this.jsB.pause();
                                d.this.zr(d.this.jwP);
                            }
                            d.this.jwR = 4;
                            d.this.jwS = d.this.jwQ;
                            d.this.jwQ = d.this.jwO;
                            d.this.jxp = d.this.jxh.getMeasuredHeight();
                            d.this.jxt = d.this.jxm / d.this.jxp;
                            d.this.jxu = (int) (1.2f * d.this.mRootView.getWidth());
                            cw(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cw(rawX, rawY);
                        break;
                }
            } else if (d.this.jwQ == d.this.jwI || d.this.jwQ == d.this.jwK || d.this.jwQ == d.this.STATE_PAUSE || d.this.jwQ == d.this.jwL || d.this.jwQ == d.this.jwO || d.this.jwQ == (d.this.STATE_PAUSE | 1) || d.this.jwQ == (d.this.jwL | 1)) {
                switch (d.this.jwR) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.jwR = 3;
                            d.this.jxn = d.this.jsB.getCurrentPosition();
                            aJ(f);
                        } else if (motionEvent.getX() < d.this.jxh.getWidth() / 2) {
                            d.this.jwR = 2;
                            d.this.jxe.m(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.jwR = 1;
                            d.this.jxe.l(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jwQ != d.this.jwO) {
                            if ((d.this.jwQ & 1) > 0) {
                                d.this.jwO |= 1;
                            } else {
                                d.this.jwO &= -2;
                            }
                            d.this.zr(d.this.jwO);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jxe.l(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.csy();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jxe.m(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aJ(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cw(int i, int i2) {
            if (d.this.jxr != i2 || d.this.jxs != i) {
                d.this.jxq = d.this.jxr - i2 > 0 || ((float) i2) < d.this.jxl / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jxh.getLayoutParams();
                if (i2 != d.this.jxr) {
                    int i3 = d.this.jxp - i2;
                    int i4 = (int) (i3 * d.this.jxt);
                    if (i4 < d.this.jxu) {
                        i4 = d.this.jxu;
                        i3 = (int) (i4 / d.this.jxt);
                    }
                    if (i4 != d.this.jxu) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jxh.setLayoutParams(layoutParams);
                    }
                    d.this.jxr = i2;
                    d.this.jxh.setTranslationY(d.this.jxr);
                }
                if (i != d.this.jxr) {
                    d.this.jxs = i;
                    d.this.jxh.setTranslationX(d.this.jxs + ((d.this.jxm - layoutParams.width) / 2.0f));
                }
                d.this.jxf.setAlpha((layoutParams.width - d.this.jxu) / (d.this.jxm - d.this.jxu));
                if (d.this.jxb.getVisibility() == 0) {
                    float f = d.this.jxl / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jxb.setAlpha(f2);
                }
            }
        }

        private void aJ(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jxn -= 1000;
                z = true;
            } else {
                d.this.jxn += 1000;
                z = false;
            }
            int duration = d.this.jsB.getDuration();
            if (d.this.jxn < 0) {
                d.this.jxn = 0;
            } else if (d.this.jxn > duration) {
                d.this.jxn = duration;
            }
            String str = aq.stringForVideoTime(d.this.jxn) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jxe != null) {
                d.this.jxe.x(z, str);
            }
            d.this.jwZ.setCurrentDuration(d.this.jxn, false);
        }
    };
    private View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jwQ == d.this.jwO) {
                if (d.this.jwR == 4) {
                    d.this.cyj();
                    d.this.jxr = 0;
                    d.this.jxs = 0;
                } else {
                    d.this.jwQ = -1;
                    if (d.this.jwR != 3) {
                        if (d.this.jwS != -1) {
                            d.this.zr(d.this.jwS);
                            d.this.jwS = -1;
                        } else if (d.this.jsB.isPlaying()) {
                            d.this.zr(d.this.jwI);
                        } else {
                            d.this.zr(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jwZ.setCurrentDuration(d.this.jxn, true);
                        if (d.this.jxn <= d.this.jsB.getDuration()) {
                            if (!d.this.jsB.isPlaying()) {
                                d.this.jsB.b(d.this.jxy);
                            }
                            d.this.zr(d.this.jwI);
                        }
                    }
                }
                if (d.this.jxk) {
                    String str = null;
                    if (d.this.jwR != 1) {
                        if (d.this.jwR != 2) {
                            if (d.this.jwR == 3) {
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
                d.this.jwR = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jxy = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cxY() {
            d.this.jsB.cxt();
            d.this.cyc();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cxZ() {
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
    private final CustomMessageListener jxz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.OC, true);
                    }
                    d.this.jsB.setVolume(1.0f, 1.0f);
                    d.this.jwX.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.csq();
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
            this.jxl = l.getEquipmentHeight(this.mContext);
            this.jxm = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void csw() {
        int dimension;
        int i;
        int i2;
        this.jxa.af(this.OF, this.iBU);
        this.jxb.af(this.OF, this.iBU);
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
            this.jwY.setPadding(this.jwY.getPaddingLeft(), 0, i, 0);
            this.jwX.setPadding(dimension, 0, 0, 0);
        }
    }

    public void csv() {
        if (this.OF) {
            this.jwK = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jwK = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iBU) {
            this.STATE_STOP |= 1024;
            this.jwI |= 1024;
            this.jwJ |= 1024;
            this.jwK |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jwL |= 1024;
            this.jwM |= 1024;
            this.jwN |= 1024;
            this.jwQ |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jwI &= -1025;
        this.jwJ &= -1025;
        this.jwK &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jwL &= -1025;
        this.jwM &= -1025;
        this.jwN &= -1025;
        this.jwQ &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jxh = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jxh);
            }
            this.OC = new WeakReference<>(TbadkCoreApplication.getInst());
            this.Ow = (TbImageView) this.jxh.findViewById(R.id.video_thumbnail);
            this.jwU = this.jxh.findViewById(R.id.black_mask);
            this.jwV = (TBLottieAnimationView) this.jxh.findViewById(R.id.video_loading);
            this.Ox = (ImageView) this.jxh.findViewById(R.id.video_play);
            this.jwW = (PercentSizeView) this.jxh.findViewById(R.id.video_media_controller_mask);
            this.Oy = (ImageView) this.jxh.findViewById(R.id.video_pause);
            this.Oz = (TextView) this.jxh.findViewById(R.id.video_play_count);
            this.OA = (TextView) this.jxh.findViewById(R.id.video_play_flag);
            this.OB = (TextView) this.jxh.findViewById(R.id.video_duration);
            this.jwX = (SwitchImageView) this.jxh.findViewById(R.id.video_mute);
            this.jwY = (SwitchImageView) this.jxh.findViewById(R.id.video_full_screen);
            this.jwZ = (OperableVideoMediaControllerView) this.jxh.findViewById(R.id.video_media_controller);
            this.jxa = (OperableVideoNetworkStateTipView) this.jxh.findViewById(R.id.video_network_state_tip);
            this.jxb = (OperableVideoShareView) this.jxh.findViewById(R.id.video_share_view);
            this.jxd = this.jxh.findViewById(R.id.video_back_btn_mask);
            this.jxc = (ImageView) this.jxh.findViewById(R.id.video_full_screen_back);
            this.jxe = (VideoGestureView) this.jxh.findViewById(R.id.video_gesture);
            this.jxg = (OperableVideoErrorView) this.jxh.findViewById(R.id.video_error_layout);
            this.jxb.setVideoContainer(this);
            this.jxj = new n(this.mContext);
            this.jxj.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bx(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cyl() && !d.this.OF && !d.this.iBU && d.this.JR) {
                        if (!com.baidu.mcn.b.Bo().em(d.this.jxv.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jxv.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jxv.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jxv.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gLE.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aHe = d.this.jxv.card_title;
                                    aVar.aHf = d.this.jxv.button_title;
                                    aVar.aHg = d.this.jxv.jump_url;
                                    aVar.aHd = d.this.jxv.pic_url;
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
                    if (d.this.jxw != null) {
                        d.this.jxw.bW(i, i2);
                    }
                }
            });
            this.jwV.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jwV.setVisibility(8);
                    d.this.Ox.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jwV.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aEp().a(this.Ox, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Ox.setOnClickListener(this);
            this.jwX.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jwX.setState(1);
            this.jwX.setOnClickListener(this);
            this.Ow.aQz();
            this.Ow.setDrawCorner(false);
            this.Ow.setPlaceHolder(3);
            this.jwZ.setOnSeekBarChangeListener(this.dVU);
            this.jwW.setHeightPercent(0.583f);
            this.jwW.setBackgroundResource(R.drawable.video_mask_bg);
            this.jwY.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jwY.setState(0);
            this.jwY.setOnClickListener(this);
            SvgManager.aEp().a(this.Oy, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Oy.setOnClickListener(this);
            this.jxc.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rs("cyber_player_test");
            this.jsB = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jsB.setTryUseViewInSet(true);
            cyc();
            this.jxa.setPlayViewOnClickListener(this);
            this.jxh.setOnClickListener(null);
            this.jxh.setOnTouchListener(this.dnp);
            this.jxb.setOnTouchListener(this.dnp);
            this.jxg.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jxx);
            zr(this.STATE_STOP);
            this.gLE = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cyc() {
        if (this.jsB != null && this.jsB.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jxh.addView(this.jsB.getView(), 0);
            this.jsB.getView().setLayoutParams(layoutParams);
            this.jwZ.setPlayer(this.jsB);
            if (cwz()) {
                ((QuickVideoView) this.jsB).setNeedRecovery(true);
                ((QuickVideoView) this.jsB).setPlayerReuseEnable(true);
            }
            this.jsB.setContinuePlayEnable(true);
            this.jsB.setBusiness(this.jxj);
            this.jsB.setOnPreparedListener(this);
            this.jsB.setOnCompletionListener(this);
            this.jsB.setOnErrorListener(this);
            this.jsB.setOnOutInfoListener(this);
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
                this.jxv = bjVar.aAo().mcn_ad_card;
                csv();
                csw();
                zr(this.STATE_STOP);
                int intValue = bjVar.aAo().video_duration.intValue() * 1000;
                this.jwZ.Aj(intValue);
                this.jwZ.setPlayer(this.jsB);
                this.OB.setText(aq.stringForVideoTime(intValue));
                this.Oz.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aAo().play_count.intValue())));
                this.jxa.setVideoLength(bjVar.aAo().video_length.intValue());
                this.jxa.setVideoDuration(bjVar.aAo().video_duration.intValue());
                this.jxa.setTid(this.OG);
                this.jxj.cxB().ai(bjVar);
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
                this.jxb.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.NT = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jxj != null) {
            this.jxj.setVideoStatsData(yVar);
            this.jsB.setBusiness(this.jxj);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cxB() {
        if (this.jxj == null) {
            return null;
        }
        return this.jxj.cxB();
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

    public void cyd() {
        e.gx().removeCallbacks(this.jwT);
        e.gx().postDelayed(this.jwT, this.jwt);
    }

    public void cye() {
        e.gx().removeCallbacks(this.jwT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jwV.setAlpha(1.0f);
        this.jwV.setVisibility(0);
        this.Ox.setVisibility(8);
        if (this.jwV != null) {
            this.jwV.loop(true);
            this.jwV.setMinAndMaxFrame(14, 80);
            this.jwV.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void csr() {
        if (this.jwQ == this.jwJ) {
            zr(this.jwI);
        }
    }

    private void cyf() {
        zr(this.jwJ);
        this.jwZ.showProgress();
        if (this.jwV != null) {
            this.jwV.clearAnimation();
            this.jwV.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.csr();
                    if (!d.this.jxi) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jwV.setVisibility(8);
                    d.this.Ox.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean csu() {
        return this.jxa != null && this.jxa.csC();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.cHu);
        MessageManager.getInstance().registerListener(this.jxz);
        if (csu()) {
            zr(this.jwN);
            return;
        }
        this.jxi = true;
        if (!this.jsB.isPlaying()) {
            com.baidu.tieba.play.a.a GQ = TbVideoViewSet.cxX().GQ(this.mVideoUrl);
            if (GQ == null) {
                this.jsB.cxt();
                if (!StringUtils.isNull(this.jsB.getOriginUrl())) {
                    this.jsB = com.baidu.tieba.play.a.b.F(this.mContext, this.isNewPlayer ? 1 : 0);
                    this.jsB.setTryUseViewInSet(true);
                }
                cyc();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.jsB.setVideoPath(this.mVideoUrl, this.OG);
                    startLoadingAnim();
                }
            } else {
                if (this.jsB == GQ) {
                    if (this.jsB.getParent() == null || this.jsB.getParent() != GQ.getParent()) {
                        this.jsB.cxt();
                        cyc();
                    }
                } else {
                    this.jsB.cxt();
                    GQ.cxt();
                    this.jsB = GQ;
                    this.jsB.setTryUseViewInSet(true);
                    cyc();
                }
                this.jsB.cxp();
                onPrepared(null);
                cyk();
            }
            if (this.jxk) {
                TiebaStatic.log(new an("c13357").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).Z("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jxi = false;
        if (this.jwV != null) {
            this.jwV.cancelAnimation();
        }
        this.jsB.stop();
        this.jsB.cxt();
        this.jwZ.ahT();
        zr(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cHu);
        MessageManager.getInstance().unRegisterListener(this.jxz);
    }

    public void zr(int i) {
        cye();
        if (this.jwQ == this.jwO) {
            this.jwS = i;
            return;
        }
        this.jwQ = i;
        this.Ow.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jwU.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jwV.clearAnimation();
        this.jwV.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jwV.cancelAnimation();
        } else {
            this.jwV.setAlpha(1.0f);
        }
        this.Ox.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Oy.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Oz.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.OF && (homePageStyleAbTest & 4) != 0) {
            this.OA.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.OB.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jwX.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jwY.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jwZ.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jwW.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jwZ.getVisibility() == 0) {
            this.jwZ.showProgress();
        }
        this.jxa.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jxb.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jxb.getVisibility() == 0) {
            this.jxb.setAlpha(1.0f);
        }
        this.jxc.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jxd.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jxe.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jxg.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zs(id);
            if (id == R.id.video_mute) {
                cyh();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cyj();
            } else if (id == R.id.video_replay) {
                zr(this.STATE_STOP);
                startPlay();
                if (this.jxk) {
                    TiebaStatic.log(new an("c13345").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_locate", this.iBU ? 1 : 2));
                }
                cyg();
            } else if (id == R.id.video_play) {
                if (this.jwQ == this.STATE_STOP) {
                    startPlay();
                } else {
                    zr(this.jwK);
                    cyd();
                    this.jsB.b(this.jxy);
                }
                if (this.jxk) {
                    TiebaStatic.log(new an("c13344").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2).Z("obj_source", this.iBU ? 1 : 2).Z("obj_locate", 1));
                }
                cyg();
            } else if (id == R.id.video_pause) {
                zr(this.STATE_PAUSE);
                cye();
                this.jsB.pause();
                if (this.jxk) {
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
    public void cyg() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Mm);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void csq() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jsB.setVolume(0.0f, 0.0f);
            this.jwX.setState(1);
            return;
        }
        this.jsB.setVolume(1.0f, 1.0f);
        this.jwX.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cyh() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jsB.setVolume(1.0f, 1.0f);
            af.a(this.OC, true);
            this.jwX.setState(0);
        } else {
            this.jsB.setVolume(0.0f, 0.0f);
            this.jwX.setState(1);
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

    public void cyi() {
        qV(true);
    }

    public void qV(boolean z) {
        if (this.mRootView != null && this.jxh != null && this.jsB != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jsB.setFullScreenToDestroySurface();
            if (this.eag == null) {
                this.eag = new o((Activity) this.mContext);
            }
            if (this.iBU) {
                if (this.jxf.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jxf.getParent()).removeView(this.jxf);
                }
                if ((this.jxh.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iBU = false;
                    ((ViewGroup) this.jxh.getParent()).removeView(this.jxh);
                    ((ViewGroup) this.mRootView).addView(this.jxh);
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
                        this.jxh.getLocationOnScreen(this.jxo);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jxf == null) {
                                    this.jxf = new View(this.mContext);
                                    this.jxf.setClickable(true);
                                    this.jxf.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jxf.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jxf.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jxf.getParent()).removeView(this.jxf);
                                }
                                this.jxf.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jxf);
                                ((ViewGroup) childAt).addView(this.jxh);
                                this.iBU = true;
                                h((Activity) this.mContext, this.iBU);
                                if (this.gLE != null && this.gLE.isShowing()) {
                                    this.gLE.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jxk) {
                    TiebaStatic.log(new an("c13360").cp("tid", this.OG).s("fid", this.mFid).Z("obj_type", this.OF ? 1 : 2));
                }
            }
            csv();
            csw();
            if (this.jsB.isPlaying()) {
                zr(this.jwI);
            } else {
                this.jwQ |= 1;
                zr(this.jwQ);
            }
            this.jwY.cSd();
            mK(this.iBU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyj() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.OF) {
            cyi();
        } else if (this.jwQ == this.jwO) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jxh.setScaleX(1.0f);
                    d.this.jxh.setScaleY(1.0f);
                    d.this.jxh.setTranslationX(0.0f);
                    d.this.jxh.setTranslationY(0.0f);
                    d.this.jxb.setScaleX(1.0f);
                    d.this.jxb.setScaleY(1.0f);
                    d.this.jxh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jxq) {
                        d.this.cyi();
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
            if (!this.jxq) {
                float width = this.mRootView.getWidth() / this.jxh.getWidth();
                float height = this.mRootView.getHeight() / this.jxh.getHeight();
                this.jxh.setPivotX(0.0f);
                this.jxh.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jxh, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jxh, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxb, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxb, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jxh, "TranslationX", this.jxh.getTranslationX(), this.jxo[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jxh, "TranslationY", this.jxh.getTranslationY(), this.jxo[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jxf, "alpha", this.jxf.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxb, "alpha", this.jxb.getAlpha(), 0.0f);
            } else {
                float width2 = this.jxm / this.jxh.getWidth();
                float height2 = this.jxp / this.jxh.getHeight();
                this.jxh.setPivotX(0.0f);
                this.jxh.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jxh, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jxh, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jxb, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jxb, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jxh, "TranslationX", this.jxh.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jxh, "TranslationY", this.jxh.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jxb, "alpha", this.jxb.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jwS != -1) {
                this.jwQ = this.jwS;
                this.jwS = -1;
                if (this.jwQ == this.jwP || this.jwQ == this.jwK || this.jwQ == this.jwI) {
                    this.jsB.b(this.jxy);
                    zr(this.jwI);
                }
            }
        } else {
            cyi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.OF && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jxh != null) {
                    if (z) {
                        this.jxh.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jxh.setPadding(0, 0, 0, 0);
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
                this.jxh.setSystemUiVisibility(0);
            }
        }
    }

    private void cyk() {
        zr(this.jwJ);
        this.jwZ.showProgress();
        cyf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mK(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        csq();
        if (this.jxi) {
            if (this.iBU && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jsB.b(this.jxy);
            if (cwz() && ((QuickVideoView) this.jsB).juz) {
                cyf();
            }
        }
    }

    public void onCompletion(g gVar) {
        zr(this.jwM);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zr(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jwQ == this.STATE_PAUSE || (this.jwQ == this.jwL && !this.jsB.isPlaying())) {
            stopPlay();
            zr(this.STATE_PAUSE);
        } else if (this.jwQ == this.jwM) {
            stopPlay();
            zr(this.jwM);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cyk();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cwU() {
        return this.jxh;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jxi || this.jsB.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jsB.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
        if ("index".equals(this.mFrom)) {
            this.jsB.setPageTypeForPerfStat("homepage");
        } else {
            this.jsB.setPageTypeForPerfStat(this.mFrom);
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

    protected boolean css() {
        return this.OF && this.iBU;
    }

    public boolean cwz() {
        return !this.isNewPlayer && (this.jsB instanceof QuickVideoView);
    }

    private void caY() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jxh.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jxh.setSystemUiVisibility(4);
        } else {
            this.jxh.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean csy() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jsB.isPlaying() && !af.aQc()) {
            this.jsB.setVolume(1.0f, 1.0f);
            this.jwX.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean csz() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean mJ(boolean z) {
        if (z) {
            this.jwV.cancelAnimation();
            if (this.jwQ == this.jwI || this.jwQ == this.jwJ || this.jwQ == this.jwK || this.jwQ == this.STATE_STOP) {
                stopPlay();
            }
            this.jwQ |= 1;
            zr(this.jwQ);
        } else if (this.jwQ == this.STATE_STOP) {
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
            cyj();
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
    public boolean cyl() {
        return this.jxv != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rO(boolean z) {
        this.JR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jxw = aVar;
    }
}
