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
    protected BdUniqueId afD;
    protected TbImageView ahE;
    private ImageView ahF;
    private ImageView ahG;
    private TextView ahH;
    private TextView ahI;
    private TextView ahJ;
    protected boolean ahN;
    protected String ahO;
    protected long ahP;
    private o eEJ;
    private com.baidu.mcn.c hzd;
    protected com.baidu.tieba.play.a.a kfd;
    private View kjK;
    private TBLottieAnimationView kjL;
    private PercentSizeView kjM;
    protected SwitchImageView kjN;
    protected SwitchImageView kjO;
    protected OperableVideoMediaControllerView kjP;
    protected OperableVideoNetworkStateTipView kjQ;
    protected OperableVideoShareView kjR;
    protected ImageView kjS;
    protected View kjT;
    protected VideoGestureView kjU;
    private View kjV;
    private OperableVideoErrorView kjW;
    protected ViewGroup kjX;
    protected boolean kjY;
    protected int kjZ;
    protected n kka;
    private float kkd;
    private float kke;
    private int kkf;
    private int kkh;
    private boolean kki;
    private float kkl;
    private int kkm;
    private McnAdInfo kkn;
    private a kko;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int kji = 3000;
    protected final int kjj = 1;
    protected final int kjk = 2;
    protected final int kjl = 4;
    protected final int kjm = 8;
    protected final int kjn = 16;
    protected final int kjo = 32;
    protected final int kjp = 64;
    protected final int kjq = 128;
    protected final int kjr = 256;
    protected final int kjs = 512;
    protected final int kjt = 1024;
    protected final int kju = 2048;
    protected final int kjv = 4096;
    protected final int kjw = 8192;
    protected int kjx = 8211;
    protected int kjy = 0;
    protected int kjz = 4;
    protected int kjA = 232;
    protected int kjB = 8416;
    protected int kjC = 0;
    protected int kjD = 513;
    protected int kjE = 259;
    protected int kjF = 2048;
    protected int kjG = 0;
    protected int STATE_ERROR = 4099;
    protected int kjH = this.kjx;
    private int jKH = 0;
    private int kjI = -1;
    private Runnable kjJ = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Ah(d.this.kjy);
        }
    };
    private WeakReference<Context> ahK = null;
    protected boolean jpM = false;
    private boolean isNewPlayer = false;
    protected boolean kkb = true;
    private boolean kkc = false;
    private int[] kkg = new int[2];
    private int kkj = 0;
    private int kkk = 0;
    protected View.OnClickListener afV = null;
    protected View.OnClickListener adf = null;
    private boolean ado = false;
    private long startPosition = -1;
    protected boolean ahd = false;
    private TbImageView.c agE = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a wP = com.baidu.tbadk.imageManager.c.aYk().wP(com.baidu.adp.lib.e.c.kV().genCacheKey(tbImageView.getUrl(), 10));
                if (wP != null) {
                    int width = wP.getWidth();
                    i = wP.getHeight();
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
                        if (d.this.ahd && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener eAu = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Ah(d.this.kjA);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.kfd.isPlaying()) {
                    d.this.kfd.b(d.this.kkp);
                }
                d.this.cKC();
                if (d.this.kkb) {
                    TiebaStatic.log(new an("c13355").cI("tid", d.this.ahO).t("fid", d.this.mFid).af("obj_type", d.this.ahN ? 1 : 2).af("obj_locate", d.this.jpM ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hiQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.kfd.isPlaying()) {
                d.this.kfd.pause();
                if (d.this.kjH == d.this.kjA) {
                    d.this.Ah(d.this.kjB);
                } else {
                    d.this.Ah(d.this.kjC);
                }
                d.this.Ai(R.id.video_pause);
            } else if (d.this.kjH == d.this.kjB || d.this.kjH == (d.this.kjB | 1)) {
                d.this.Ah(d.this.kjA);
                d.this.cKC();
                d.this.kfd.b(d.this.kkp);
                d.this.Ai(R.id.video_play);
            } else if (d.this.kjH == d.this.kjC || d.this.kjH == (d.this.kjC | 1)) {
                d.this.Ah(d.this.kjy);
                d.this.kfd.b(d.this.kkp);
                d.this.Ai(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.kfd.isPlaying()) {
                if (d.this.kjH == d.this.kjy || d.this.kjH == d.this.kjz) {
                    d.this.Ah(d.this.kjA);
                    d.this.cKC();
                    return true;
                } else if (d.this.kjH == d.this.kjA) {
                    d.this.Ah(d.this.kjy);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.kjH == d.this.kjB) {
                d.this.Ah(d.this.kjC);
                return true;
            } else if (d.this.kjH == (d.this.kjB | 1)) {
                d.this.Ah(d.this.kjC | 1);
                return true;
            } else if (d.this.kjH == d.this.kjC) {
                d.this.Ah(d.this.kjB);
                return true;
            } else if (d.this.kjH == (d.this.kjC | 1)) {
                d.this.Ah(d.this.kjB | 1);
                return true;
            } else {
                d.this.Ah(d.this.kjx);
                d.this.startPlay();
                d.this.cKH();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.jKH = 0;
            if (d.this.jpM) {
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
            if (d.this.ahN && d.this.cEO()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.jKH) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.kfd.isPlaying()) {
                                d.this.kfd.pause();
                                d.this.Ah(d.this.kjG);
                            }
                            d.this.jKH = 4;
                            d.this.kjI = d.this.kjH;
                            d.this.kjH = d.this.kjF;
                            d.this.kkh = d.this.kjX.getMeasuredHeight();
                            d.this.kkl = d.this.kke / d.this.kkh;
                            d.this.kkm = (int) (1.2f * d.this.mRootView.getWidth());
                            cE(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cE(rawX, rawY);
                        break;
                }
            } else if (d.this.kjH == d.this.kjy || d.this.kjH == d.this.kjA || d.this.kjH == d.this.kjB || d.this.kjH == d.this.kjC || d.this.kjH == d.this.kjF || d.this.kjH == (d.this.kjB | 1) || d.this.kjH == (d.this.kjC | 1)) {
                switch (d.this.jKH) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.jKH = 3;
                            d.this.kkf = d.this.kfd.getCurrentPosition();
                            as(f);
                        } else if (motionEvent.getX() < d.this.kjX.getWidth() / 2) {
                            d.this.jKH = 2;
                            d.this.kjU.l(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.jKH = 1;
                            d.this.kjU.k(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.kjH != d.this.kjF) {
                            if ((d.this.kjH & 1) > 0) {
                                d.this.kjF |= 1;
                            } else {
                                d.this.kjF &= -2;
                            }
                            d.this.Ah(d.this.kjF);
                            break;
                        }
                        break;
                    case 1:
                        d.this.kjU.k(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cES();
                            break;
                        }
                        break;
                    case 2:
                        d.this.kjU.l(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        as(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cE(int i, int i2) {
            if (d.this.kkj != i2 || d.this.kkk != i) {
                d.this.kki = d.this.kkj - i2 > 0 || ((float) i2) < d.this.kkd / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.kjX.getLayoutParams();
                if (i2 != d.this.kkj) {
                    int i3 = d.this.kkh - i2;
                    int i4 = (int) (i3 * d.this.kkl);
                    if (i4 < d.this.kkm) {
                        i4 = d.this.kkm;
                        i3 = (int) (i4 / d.this.kkl);
                    }
                    if (i4 != d.this.kkm) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.kjX.setLayoutParams(layoutParams);
                    }
                    d.this.kkj = i2;
                    d.this.kjX.setTranslationY(d.this.kkj);
                }
                if (i != d.this.kkj) {
                    d.this.kkk = i;
                    d.this.kjX.setTranslationX(d.this.kkk + ((d.this.kke - layoutParams.width) / 2.0f));
                }
                d.this.kjV.setAlpha((layoutParams.width - d.this.kkm) / (d.this.kke - d.this.kkm));
                if (d.this.kjR.getVisibility() == 0) {
                    float f = d.this.kkd / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.kjR.setAlpha(f2);
                }
            }
        }

        private void as(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.kkf -= 1000;
                z = true;
            } else {
                d.this.kkf += 1000;
                z = false;
            }
            int duration = d.this.kfd.getDuration();
            if (d.this.kkf < 0) {
                d.this.kkf = 0;
            } else if (d.this.kkf > duration) {
                d.this.kkf = duration;
            }
            String str = aq.stringForVideoTime(d.this.kkf) + " / " + aq.stringForVideoTime(duration);
            if (d.this.kjU != null) {
                d.this.kjU.y(z, str);
            }
            d.this.kjP.setCurrentDuration(d.this.kkf, false);
        }
    };
    private View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.kjH == d.this.kjF) {
                if (d.this.jKH == 4) {
                    d.this.cKK();
                    d.this.kkj = 0;
                    d.this.kkk = 0;
                } else {
                    d.this.kjH = -1;
                    if (d.this.jKH != 3) {
                        if (d.this.kjI != -1) {
                            d.this.Ah(d.this.kjI);
                            d.this.kjI = -1;
                        } else if (d.this.kfd.isPlaying()) {
                            d.this.Ah(d.this.kjy);
                        } else {
                            d.this.Ah(d.this.kjB);
                        }
                    } else {
                        d.this.kjP.setCurrentDuration(d.this.kkf, true);
                        if (d.this.kkf <= d.this.kfd.getDuration()) {
                            if (!d.this.kfd.isPlaying()) {
                                d.this.kfd.b(d.this.kkp);
                            }
                            d.this.Ah(d.this.kjy);
                        }
                    }
                }
                if (d.this.kkb) {
                    String str = null;
                    if (d.this.jKH != 1) {
                        if (d.this.jKH != 2) {
                            if (d.this.jKH == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).cI("tid", d.this.ahO).t("fid", d.this.mFid));
                    }
                }
                d.this.jKH = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a kkp = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cKu() {
            d.this.kfd.cJN();
            d.this.cKB();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cKv() {
            d.this.Ah(d.this.kjx);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener dkW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener kkq = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.ahK, true);
                    }
                    d.this.kfd.setVolume(1.0f, 1.0f);
                    d.this.kjN.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cEM();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ce(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.kkd = l.getEquipmentHeight(this.mContext);
            this.kke = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cEQ() {
        int dimension;
        int i;
        int i2;
        this.kjQ.ai(this.ahN, this.jpM);
        this.kjR.ai(this.ahN, this.jpM);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.ahN) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.jpM) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ahH.setPadding(0, 0, i2, 0);
            this.kjO.setPadding(this.kjO.getPaddingLeft(), 0, i, 0);
            this.kjN.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cEP() {
        if (this.ahN) {
            this.kjA = 104;
            this.kjB = 8290;
        } else {
            this.kjA = 232;
            this.kjB = 8418;
        }
        if (this.jpM) {
            this.kjx |= 1024;
            this.kjy |= 1024;
            this.kjz |= 1024;
            this.kjA |= 1024;
            this.kjB |= 1024;
            this.kjC |= 1024;
            this.kjD |= 1024;
            this.kjE |= 1024;
            this.kjH |= 1024;
            return;
        }
        this.kjx &= -1025;
        this.kjy &= -1025;
        this.kjz &= -1025;
        this.kjA &= -1025;
        this.kjB &= -1025;
        this.kjC &= -1025;
        this.kjD &= -1025;
        this.kjE &= -1025;
        this.kjH &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.kjX = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.kjX);
            }
            this.ahK = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ahE = (TbImageView) this.kjX.findViewById(R.id.video_thumbnail);
            this.kjK = this.kjX.findViewById(R.id.black_mask);
            this.kjL = (TBLottieAnimationView) this.kjX.findViewById(R.id.video_loading);
            this.ahF = (ImageView) this.kjX.findViewById(R.id.video_play);
            this.kjM = (PercentSizeView) this.kjX.findViewById(R.id.video_media_controller_mask);
            this.ahG = (ImageView) this.kjX.findViewById(R.id.video_pause);
            this.ahH = (TextView) this.kjX.findViewById(R.id.video_play_count);
            this.ahI = (TextView) this.kjX.findViewById(R.id.video_play_flag);
            this.ahJ = (TextView) this.kjX.findViewById(R.id.video_duration);
            this.kjN = (SwitchImageView) this.kjX.findViewById(R.id.video_mute);
            this.kjO = (SwitchImageView) this.kjX.findViewById(R.id.video_full_screen);
            this.kjP = (OperableVideoMediaControllerView) this.kjX.findViewById(R.id.video_media_controller);
            this.kjQ = (OperableVideoNetworkStateTipView) this.kjX.findViewById(R.id.video_network_state_tip);
            this.kjR = (OperableVideoShareView) this.kjX.findViewById(R.id.video_share_view);
            this.kjT = this.kjX.findViewById(R.id.video_back_btn_mask);
            this.kjS = (ImageView) this.kjX.findViewById(R.id.video_full_screen_back);
            this.kjU = (VideoGestureView) this.kjX.findViewById(R.id.video_gesture);
            this.kjW = (OperableVideoErrorView) this.kjX.findViewById(R.id.video_error_layout);
            this.kjR.setVideoContainer(this);
            this.kka = new n(this.mContext);
            this.kka.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cKM() && !d.this.ahN && !d.this.jpM && d.this.ado) {
                        if (!com.baidu.mcn.b.JE().fu(d.this.kkn.jump_url)) {
                            boolean z = ((long) i2) >= d.this.kkn.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.kkn.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.kkn.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.hzd.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.bhl = d.this.kkn.card_title;
                                    aVar.bhm = d.this.kkn.button_title;
                                    aVar.bhn = d.this.kkn.jump_url;
                                    aVar.bhk = d.this.kkn.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.ahO;
                                    aVar.bho = d.this.cad();
                                    if (z2) {
                                        d.this.hzd.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.hzd.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.hzd.isShowing()) {
                                d.this.hzd.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.kko != null) {
                        d.this.kko.ce(i, i2);
                    }
                }
            });
            this.kjL.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kjL.setVisibility(8);
                    d.this.ahF.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.kjL.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aOR().a(this.ahF, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ahF.setOnClickListener(this);
            this.kjN.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.kjN.setState(1);
            this.kjN.setOnClickListener(this);
            this.ahE.bbf();
            this.ahE.setDrawCorner(false);
            this.ahE.setPlaceHolder(3);
            this.kjP.setOnSeekBarChangeListener(this.eAu);
            this.kjM.setHeightPercent(0.583f);
            this.kjM.setBackgroundResource(R.drawable.video_mask_bg);
            this.kjO.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.kjO.setState(0);
            this.kjO.setOnClickListener(this);
            SvgManager.aOR().a(this.ahG, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ahG.setOnClickListener(this);
            this.kjS.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.sY("cyber_player_test") || com.baidu.tbadk.a.b.sX("cyber_player_test");
            this.kfd = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
            this.kfd.setTryUseViewInSet(true);
            cKB();
            this.kjQ.setPlayViewOnClickListener(this);
            this.kjX.setOnClickListener(null);
            this.kjX.setOnTouchListener(this.dSb);
            this.kjR.setOnTouchListener(this.dSb);
            this.kjW.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hiQ);
            Ah(this.kjx);
            this.hzd = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cKB() {
        if (this.kfd != null && this.kfd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kjX.addView(this.kfd.getView(), 0);
            this.kfd.getView().setLayoutParams(layoutParams);
            this.kjP.setPlayer(this.kfd);
            if (cIS()) {
                ((QuickVideoView) this.kfd).setNeedRecovery(true);
            }
            this.kfd.setContinuePlayEnable(true);
            this.kfd.setBusiness(this.kka);
            this.kfd.setOnPreparedListener(this);
            this.kfd.setOnCompletionListener(this);
            this.kfd.setOnErrorListener(this);
            this.kfd.setOnSurfaceDestroyedListener(this);
            this.kfd.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aKT() != null) {
            this.startPosition = -1L;
            if (this.hzd != null) {
                this.hzd.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aKT().video_url)) {
                stopPlay();
                this.ahN = bjVar.aKT().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aKT().video_url;
                this.ahO = bjVar.getTid();
                this.ahP = bjVar.aKT().video_length.intValue();
                this.kjZ = bjVar.aKT().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.kkn = bjVar.aKT().mcn_ad_card;
                cEP();
                cEQ();
                Ah(this.kjx);
                int intValue = bjVar.aKT().video_duration.intValue() * 1000;
                this.kjP.Bb(intValue);
                this.kjP.setPlayer(this.kfd);
                this.ahJ.setText(aq.stringForVideoTime(intValue));
                this.ahH.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aKT().play_count.intValue())));
                this.kjQ.setVideoLength(bjVar.aKT().video_length.intValue());
                this.kjQ.setVideoDuration(bjVar.aKT().video_duration.intValue());
                this.kjQ.setTid(this.ahO);
                this.kka.cJV().am(bjVar);
                this.ahI.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.aKT().wth_mid_loc != null && bjVar.aKT().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.ahE.setScaleType(ImageView.ScaleType.MATRIX);
                    this.ahE.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.ahN) {
                        this.ahJ.setText("");
                        this.ahH.setText("");
                        this.ahI.setVisibility(0);
                    }
                    this.ahE.setSmartCropCenterPointWidthRatio(bjVar.aKT().wth_mid_loc.floatValue());
                    this.ahE.setSmartCropCenterPointHeightRatio(bjVar.aKT().hth_mid_loc.floatValue());
                    this.ahE.setOnDrawListener(this.agE);
                }
                this.ahE.setPlaceHolder(3);
                this.ahE.startLoad(bjVar.aKT().thumbnail_url, 10, false);
                this.kjR.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.ahd = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.kka != null) {
            this.kka.setVideoStatsData(yVar);
            this.kfd.setBusiness(this.kka);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cJV() {
        if (this.kka == null) {
            return null;
        }
        return this.kka.cJV();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aa(View.OnClickListener onClickListener) {
        this.adf = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.afD = bdUniqueId;
    }

    public void cKC() {
        e.lb().removeCallbacks(this.kjJ);
        e.lb().postDelayed(this.kjJ, this.kji);
    }

    public void cKD() {
        e.lb().removeCallbacks(this.kjJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.kjL.setAlpha(1.0f);
        this.kjL.setVisibility(0);
        this.ahF.setVisibility(8);
        if (this.kjL != null) {
            this.kjL.loop(true);
            this.kjL.setMinAndMaxFrame(14, 80);
            this.kjL.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cEN() {
        if (this.kjH == this.kjz) {
            Ah(this.kjy);
        }
    }

    private void cKE() {
        Ah(this.kjz);
        this.kjP.showProgress();
        if (this.kjL != null) {
            this.kjL.clearAnimation();
            this.kjL.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cEN();
                    if (!d.this.kjY) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kjL.setVisibility(8);
                    d.this.ahF.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cKF() {
        return this.kjQ != null && this.kjQ.cEY();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dkW);
            MessageManager.getInstance().registerListener(this.kkq);
            if (cKF()) {
                Ah(this.kjE);
                return;
            }
            this.kjY = true;
            if (!this.kfd.isPlaying()) {
                com.baidu.tieba.play.a.a IP = TbVideoViewSet.cKt().IP(this.mVideoUrl);
                if (IP == null) {
                    this.kfd.cJN();
                    if (!StringUtils.isNull(this.kfd.getOriginUrl())) {
                        this.kfd = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.kfd.setTryUseViewInSet(true);
                    }
                    cKB();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kfd.setVideoDuration(this.kjZ);
                        this.kfd.setVideoPath(this.mVideoUrl, this.ahO);
                        startLoadingAnim();
                        if (this.kkb) {
                            cEW();
                        }
                    }
                } else {
                    if (this.kfd == IP) {
                        if (this.kfd.getParent() == null || this.kfd.getParent() != IP.getParent()) {
                            this.kfd.cJN();
                            cKB();
                        }
                    } else {
                        this.kfd.cJN();
                        IP.cJN();
                        this.kfd = IP;
                        this.kfd.setTryUseViewInSet(true);
                        cKB();
                    }
                    this.kfd.cJI();
                    onPrepared(null);
                    cKL();
                    if (this.kkb) {
                        cEW();
                    }
                }
                if (this.kkb) {
                    TiebaStatic.log(new an("c13357").cI("tid", this.ahO).t("fid", this.mFid).af("obj_type", this.ahN ? 1 : 2).af("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).af("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.kjY = false;
        if (this.kjL != null) {
            this.kjL.cancelAnimation();
        }
        this.kfd.stop();
        this.kfd.cJN();
        this.kjP.asw();
        Ah(this.kjx);
        MessageManager.getInstance().unRegisterListener(this.dkW);
        MessageManager.getInstance().unRegisterListener(this.kkq);
    }

    private void cKG() {
        this.kjY = false;
        if (this.kjL != null) {
            this.kjL.cancelAnimation();
        }
        this.kfd.stop();
        this.kjP.asw();
        Ah(this.kjx);
        MessageManager.getInstance().unRegisterListener(this.dkW);
        MessageManager.getInstance().unRegisterListener(this.kkq);
    }

    public void cEW() {
        if (this.kka != null && this.kka.cJY() != null) {
            y cKp = this.kka.cJY().cKp();
            cKp.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(cKp.kiw, "", "1", cKp);
        }
    }

    public void Ah(int i) {
        cKD();
        if (this.kjH == this.kjF) {
            this.kjI = i;
            return;
        }
        this.kjH = i;
        this.ahE.setVisibility((i & 1) > 0 ? 0 : 8);
        this.kjK.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.kjL.clearAnimation();
        this.kjL.setVisibility(z ? 0 : 8);
        if (!z) {
            this.kjL.cancelAnimation();
        } else {
            this.kjL.setAlpha(1.0f);
        }
        this.ahF.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.ahG.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ahH.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.ahN && (homePageStyleAbTest & 4) != 0) {
            this.ahI.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.ahJ.setVisibility((i & 16) > 0 ? 0 : 8);
        this.kjN.setVisibility((i & 32) > 0 ? 0 : 8);
        this.kjO.setVisibility((i & 64) > 0 ? 0 : 8);
        this.kjP.setVisibility((i & 128) > 0 ? 0 : 8);
        this.kjM.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.kjP.getVisibility() == 0) {
            this.kjP.showProgress();
        }
        this.kjQ.setVisibility((i & 256) > 0 ? 0 : 8);
        this.kjR.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.kjR.getVisibility() == 0) {
            this.kjR.setAlpha(1.0f);
        }
        this.kjS.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kjT.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kjU.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.kjW.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Ai(id);
            if (id == R.id.video_mute) {
                cKI();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cKK();
            } else if (id == R.id.video_replay) {
                Ah(this.kjx);
                startPlay();
                if (this.kkb) {
                    TiebaStatic.log(new an("c13345").cI("tid", this.ahO).t("fid", this.mFid).af("obj_type", this.ahN ? 1 : 2).af("obj_locate", this.jpM ? 1 : 2));
                }
                cKH();
            } else if (id == R.id.video_play) {
                if (this.kjH == this.kjx) {
                    startPlay();
                } else {
                    Ah(this.kjA);
                    cKC();
                    this.kfd.b(this.kkp);
                }
                if (this.kkb) {
                    TiebaStatic.log(new an("c13344").cI("tid", this.ahO).t("fid", this.mFid).af("obj_type", this.ahN ? 1 : 2).af("obj_source", this.jpM ? 1 : 2).af("obj_locate", 1));
                }
                cKH();
            } else if (id == R.id.video_pause) {
                Ah(this.kjB);
                cKD();
                this.kfd.pause();
                if (this.kkb) {
                    TiebaStatic.log(new an("c13344").cI("tid", this.ahO).t("fid", this.mFid).af("obj_type", this.ahN ? 1 : 2).af("obj_source", this.jpM ? 1 : 2).af("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Ah(this.kjx);
                startPlay();
            } else if (id == R.id.retry) {
                Ah(this.kjx);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKH() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.afD);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cEM() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.kfd.setVolume(0.0f, 0.0f);
            this.kjN.setState(1);
            return;
        }
        this.kfd.setVolume(1.0f, 1.0f);
        this.kjN.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cKI() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.kfd.setVolume(1.0f, 1.0f);
            af.a(this.ahK, true);
            this.kjN.setState(0);
        } else {
            this.kfd.setVolume(0.0f, 0.0f);
            this.kjN.setState(1);
            af.a(this.ahK, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void ta(boolean z) {
        if (this.eEJ == null) {
            this.eEJ = new o((Activity) this.mContext);
        }
        if (z) {
            this.eEJ.start();
            this.eEJ.bS(true);
            return;
        }
        this.eEJ.stop();
        this.eEJ.bS(false);
    }

    public void cKJ() {
        sk(true);
    }

    public void sk(boolean z) {
        if (this.mRootView != null && this.kjX != null && this.kfd != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.kfd.setFullScreenToDestroySurface();
            if (this.eEJ == null) {
                this.eEJ = new o((Activity) this.mContext);
            }
            if (this.jpM) {
                if (this.kjV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kjV.getParent()).removeView(this.kjV);
                }
                if ((this.kjX.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.jpM = false;
                    this.kkc = true;
                    ((ViewGroup) this.kjX.getParent()).removeView(this.kjX);
                    ((ViewGroup) this.mRootView).addView(this.kjX);
                    this.kkc = false;
                    h((Activity) this.mContext, this.jpM);
                }
                if (!this.ahN && z) {
                    this.eEJ.Fe();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.ahN && z) {
                        this.eEJ.Fe();
                    }
                    if (this.mContext instanceof Activity) {
                        this.kjX.getLocationOnScreen(this.kkg);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.kkc = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.kjV == null) {
                                    this.kjV = new View(this.mContext);
                                    this.kjV.setClickable(true);
                                    this.kjV.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.kjV.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.kjV.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.kjV.getParent()).removeView(this.kjV);
                                }
                                this.kjV.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.kjV);
                                ((ViewGroup) childAt).addView(this.kjX);
                                this.kkc = false;
                                this.jpM = true;
                                h((Activity) this.mContext, this.jpM);
                                if (this.hzd != null && this.hzd.isShowing()) {
                                    this.hzd.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.kkb) {
                    TiebaStatic.log(new an("c13360").cI("tid", this.ahO).t("fid", this.mFid).af("obj_type", this.ahN ? 1 : 2));
                }
            }
            cEP();
            cEQ();
            if (this.kfd.isPlaying()) {
                Ah(this.kjy);
            } else {
                if (!this.isNewPlayer) {
                    this.kjH |= 1;
                }
                Ah(this.kjH);
            }
            this.kjO.deJ();
            nW(this.jpM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKK() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.ahN) {
            cKJ();
        } else if (this.kjH == this.kjF) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.kjX.setScaleX(1.0f);
                    d.this.kjX.setScaleY(1.0f);
                    d.this.kjX.setTranslationX(0.0f);
                    d.this.kjX.setTranslationY(0.0f);
                    d.this.kjR.setScaleX(1.0f);
                    d.this.kjR.setScaleY(1.0f);
                    d.this.kjX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.kki) {
                        d.this.cKJ();
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
            if (!this.kki) {
                float width = this.mRootView.getWidth() / this.kjX.getWidth();
                float height = this.mRootView.getHeight() / this.kjX.getHeight();
                this.kjX.setPivotX(0.0f);
                this.kjX.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kjX, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.kjX, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.kjR, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.kjR, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.kjX, "TranslationX", this.kjX.getTranslationX(), this.kkg[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.kjX, "TranslationY", this.kjX.getTranslationY(), this.kkg[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.kjV, "alpha", this.kjV.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kjR, "alpha", this.kjR.getAlpha(), 0.0f);
            } else {
                float width2 = this.kke / this.kjX.getWidth();
                float height2 = this.kkh / this.kjX.getHeight();
                this.kjX.setPivotX(0.0f);
                this.kjX.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kjX, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.kjX, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.kjR, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.kjR, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.kjX, "TranslationX", this.kjX.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.kjX, "TranslationY", this.kjX.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kjR, "alpha", this.kjR.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.kjI != -1) {
                this.kjH = this.kjI;
                this.kjI = -1;
                if (this.kjH == this.kjG || this.kjH == this.kjA || this.kjH == this.kjy) {
                    this.kfd.b(this.kkp);
                    Ah(this.kjy);
                }
            }
        } else {
            cKJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.ahN && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.kjX != null) {
                    if (z) {
                        this.kjX.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.kjX.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cnt();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.kjX.setSystemUiVisibility(0);
            }
        }
    }

    private void cKL() {
        Ah(this.kjz);
        this.kjP.showProgress();
        cKE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nW(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cEM();
        if (this.kjY) {
            if (this.jpM && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.kfd.b(this.kkp);
            if (cIS() && ((QuickVideoView) this.kfd).khf) {
                cKE();
            }
        }
    }

    public void onCompletion(g gVar) {
        Ah(this.kjD);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        Ah(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.isNewPlayer && !this.kkc) {
            if (this.kjH == this.kjB || (this.kjH == this.kjC && !this.kfd.isPlaying())) {
                cKG();
                Ah(this.kjB);
            } else if (this.kjH == this.kjD) {
                cKG();
                Ah(this.kjD);
            } else {
                cKG();
            }
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cKL();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cJn() {
        return this.kjX;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.kjY || this.kfd.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.kfd.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bpd() {
    }

    protected void Ai(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.jpM;
    }

    protected boolean cEO() {
        return this.ahN && this.jpM;
    }

    public boolean cIS() {
        return !this.isNewPlayer && (this.kfd instanceof QuickVideoView);
    }

    private void cnt() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kjX.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kjX.setSystemUiVisibility(4);
        } else {
            this.kjX.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cES() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.kfd.isPlaying() && !af.baH()) {
            this.kfd.setVolume(1.0f, 1.0f);
            this.kjN.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cET() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean nV(boolean z) {
        if (z) {
            this.kjL.cancelAnimation();
            if (this.kjH == this.kjy || this.kjH == this.kjz || this.kjH == this.kjA || this.kjH == this.kjx) {
                stopPlay();
            }
            this.kjH |= 1;
            Ah(this.kjH);
        } else if (this.kjH == this.kjx) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.jpM;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.jpM) {
            cKK();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cad() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cKM() {
        return this.kkn != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tb(boolean z) {
        this.ado = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.kko = aVar;
    }
}
