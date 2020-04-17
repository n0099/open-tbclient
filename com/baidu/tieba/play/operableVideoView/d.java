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
    protected BdUniqueId afA;
    protected TbImageView ahB;
    private ImageView ahC;
    private ImageView ahD;
    private TextView ahE;
    private TextView ahF;
    private TextView ahG;
    protected boolean ahK;
    protected String ahL;
    protected long ahM;
    private o eEE;
    private com.baidu.mcn.c hyX;
    protected com.baidu.tieba.play.a.a keZ;
    private View kjG;
    private TBLottieAnimationView kjH;
    private PercentSizeView kjI;
    protected SwitchImageView kjJ;
    protected SwitchImageView kjK;
    protected OperableVideoMediaControllerView kjL;
    protected OperableVideoNetworkStateTipView kjM;
    protected OperableVideoShareView kjN;
    protected ImageView kjO;
    protected View kjP;
    protected VideoGestureView kjQ;
    private View kjR;
    private OperableVideoErrorView kjS;
    protected ViewGroup kjT;
    protected boolean kjU;
    protected int kjV;
    protected n kjW;
    private float kjZ;
    private float kka;
    private int kkb;
    private int kkd;
    private boolean kke;
    private float kkh;
    private int kki;
    private McnAdInfo kkj;
    private a kkk;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int kje = 3000;
    protected final int kjf = 1;
    protected final int kjg = 2;
    protected final int kjh = 4;
    protected final int kji = 8;
    protected final int kjj = 16;
    protected final int kjk = 32;
    protected final int kjl = 64;
    protected final int kjm = 128;
    protected final int kjn = 256;
    protected final int kjo = 512;
    protected final int kjp = 1024;
    protected final int kjq = 2048;
    protected final int kjr = 4096;
    protected final int kjs = 8192;
    protected int kjt = 8211;
    protected int kju = 0;
    protected int kjv = 4;
    protected int kjw = 232;
    protected int kjx = 8416;
    protected int kjy = 0;
    protected int kjz = 513;
    protected int kjA = 259;
    protected int kjB = 2048;
    protected int kjC = 0;
    protected int STATE_ERROR = 4099;
    protected int kjD = this.kjt;
    private int jKD = 0;
    private int kjE = -1;
    private Runnable kjF = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Ah(d.this.kju);
        }
    };
    private WeakReference<Context> ahH = null;
    protected boolean jpI = false;
    private boolean isNewPlayer = false;
    protected boolean kjX = true;
    private boolean kjY = false;
    private int[] kkc = new int[2];
    private int kkf = 0;
    private int kkg = 0;
    protected View.OnClickListener afS = null;
    protected View.OnClickListener adb = null;
    private boolean adl = false;
    private long startPosition = -1;
    protected boolean aha = false;
    private TbImageView.c agB = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a wM = com.baidu.tbadk.imageManager.c.aYm().wM(com.baidu.adp.lib.e.c.kV().genCacheKey(tbImageView.getUrl(), 10));
                if (wM != null) {
                    int width = wM.getWidth();
                    i = wM.getHeight();
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
                        if (d.this.aha && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener eAp = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Ah(d.this.kjw);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.keZ.isPlaying()) {
                    d.this.keZ.b(d.this.kkl);
                }
                d.this.cKF();
                if (d.this.kjX) {
                    TiebaStatic.log(new an("c13355").cI("tid", d.this.ahL).t("fid", d.this.mFid).af("obj_type", d.this.ahK ? 1 : 2).af("obj_locate", d.this.jpI ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hiK = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.keZ.isPlaying()) {
                d.this.keZ.pause();
                if (d.this.kjD == d.this.kjw) {
                    d.this.Ah(d.this.kjx);
                } else {
                    d.this.Ah(d.this.kjy);
                }
                d.this.Ai(R.id.video_pause);
            } else if (d.this.kjD == d.this.kjx || d.this.kjD == (d.this.kjx | 1)) {
                d.this.Ah(d.this.kjw);
                d.this.cKF();
                d.this.keZ.b(d.this.kkl);
                d.this.Ai(R.id.video_play);
            } else if (d.this.kjD == d.this.kjy || d.this.kjD == (d.this.kjy | 1)) {
                d.this.Ah(d.this.kju);
                d.this.keZ.b(d.this.kkl);
                d.this.Ai(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.keZ.isPlaying()) {
                if (d.this.kjD == d.this.kju || d.this.kjD == d.this.kjv) {
                    d.this.Ah(d.this.kjw);
                    d.this.cKF();
                    return true;
                } else if (d.this.kjD == d.this.kjw) {
                    d.this.Ah(d.this.kju);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.kjD == d.this.kjx) {
                d.this.Ah(d.this.kjy);
                return true;
            } else if (d.this.kjD == (d.this.kjx | 1)) {
                d.this.Ah(d.this.kjy | 1);
                return true;
            } else if (d.this.kjD == d.this.kjy) {
                d.this.Ah(d.this.kjx);
                return true;
            } else if (d.this.kjD == (d.this.kjy | 1)) {
                d.this.Ah(d.this.kjx | 1);
                return true;
            } else {
                d.this.Ah(d.this.kjt);
                d.this.startPlay();
                d.this.cKK();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.jKD = 0;
            if (d.this.jpI) {
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
            if (d.this.ahK && d.this.cER()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.jKD) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.keZ.isPlaying()) {
                                d.this.keZ.pause();
                                d.this.Ah(d.this.kjC);
                            }
                            d.this.jKD = 4;
                            d.this.kjE = d.this.kjD;
                            d.this.kjD = d.this.kjB;
                            d.this.kkd = d.this.kjT.getMeasuredHeight();
                            d.this.kkh = d.this.kka / d.this.kkd;
                            d.this.kki = (int) (1.2f * d.this.mRootView.getWidth());
                            cE(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cE(rawX, rawY);
                        break;
                }
            } else if (d.this.kjD == d.this.kju || d.this.kjD == d.this.kjw || d.this.kjD == d.this.kjx || d.this.kjD == d.this.kjy || d.this.kjD == d.this.kjB || d.this.kjD == (d.this.kjx | 1) || d.this.kjD == (d.this.kjy | 1)) {
                switch (d.this.jKD) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.jKD = 3;
                            d.this.kkb = d.this.keZ.getCurrentPosition();
                            as(f);
                        } else if (motionEvent.getX() < d.this.kjT.getWidth() / 2) {
                            d.this.jKD = 2;
                            d.this.kjQ.l(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.jKD = 1;
                            d.this.kjQ.k(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.kjD != d.this.kjB) {
                            if ((d.this.kjD & 1) > 0) {
                                d.this.kjB |= 1;
                            } else {
                                d.this.kjB &= -2;
                            }
                            d.this.Ah(d.this.kjB);
                            break;
                        }
                        break;
                    case 1:
                        d.this.kjQ.k(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cEV();
                            break;
                        }
                        break;
                    case 2:
                        d.this.kjQ.l(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        as(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cE(int i, int i2) {
            if (d.this.kkf != i2 || d.this.kkg != i) {
                d.this.kke = d.this.kkf - i2 > 0 || ((float) i2) < d.this.kjZ / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.kjT.getLayoutParams();
                if (i2 != d.this.kkf) {
                    int i3 = d.this.kkd - i2;
                    int i4 = (int) (i3 * d.this.kkh);
                    if (i4 < d.this.kki) {
                        i4 = d.this.kki;
                        i3 = (int) (i4 / d.this.kkh);
                    }
                    if (i4 != d.this.kki) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.kjT.setLayoutParams(layoutParams);
                    }
                    d.this.kkf = i2;
                    d.this.kjT.setTranslationY(d.this.kkf);
                }
                if (i != d.this.kkf) {
                    d.this.kkg = i;
                    d.this.kjT.setTranslationX(d.this.kkg + ((d.this.kka - layoutParams.width) / 2.0f));
                }
                d.this.kjR.setAlpha((layoutParams.width - d.this.kki) / (d.this.kka - d.this.kki));
                if (d.this.kjN.getVisibility() == 0) {
                    float f = d.this.kjZ / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.kjN.setAlpha(f2);
                }
            }
        }

        private void as(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.kkb -= 1000;
                z = true;
            } else {
                d.this.kkb += 1000;
                z = false;
            }
            int duration = d.this.keZ.getDuration();
            if (d.this.kkb < 0) {
                d.this.kkb = 0;
            } else if (d.this.kkb > duration) {
                d.this.kkb = duration;
            }
            String str = aq.stringForVideoTime(d.this.kkb) + " / " + aq.stringForVideoTime(duration);
            if (d.this.kjQ != null) {
                d.this.kjQ.y(z, str);
            }
            d.this.kjL.setCurrentDuration(d.this.kkb, false);
        }
    };
    private View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.kjD == d.this.kjB) {
                if (d.this.jKD == 4) {
                    d.this.cKN();
                    d.this.kkf = 0;
                    d.this.kkg = 0;
                } else {
                    d.this.kjD = -1;
                    if (d.this.jKD != 3) {
                        if (d.this.kjE != -1) {
                            d.this.Ah(d.this.kjE);
                            d.this.kjE = -1;
                        } else if (d.this.keZ.isPlaying()) {
                            d.this.Ah(d.this.kju);
                        } else {
                            d.this.Ah(d.this.kjx);
                        }
                    } else {
                        d.this.kjL.setCurrentDuration(d.this.kkb, true);
                        if (d.this.kkb <= d.this.keZ.getDuration()) {
                            if (!d.this.keZ.isPlaying()) {
                                d.this.keZ.b(d.this.kkl);
                            }
                            d.this.Ah(d.this.kju);
                        }
                    }
                }
                if (d.this.kjX) {
                    String str = null;
                    if (d.this.jKD != 1) {
                        if (d.this.jKD != 2) {
                            if (d.this.jKD == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).cI("tid", d.this.ahL).t("fid", d.this.mFid));
                    }
                }
                d.this.jKD = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a kkl = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cKx() {
            d.this.keZ.cJQ();
            d.this.cKE();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cKy() {
            d.this.Ah(d.this.kjt);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener dkS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener kkm = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.ahH, true);
                    }
                    d.this.keZ.setVolume(1.0f, 1.0f);
                    d.this.kjJ.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cEP();
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
            this.kjZ = l.getEquipmentHeight(this.mContext);
            this.kka = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cET() {
        int dimension;
        int i;
        int i2;
        this.kjM.ai(this.ahK, this.jpI);
        this.kjN.ai(this.ahK, this.jpI);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.ahK) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.jpI) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ahE.setPadding(0, 0, i2, 0);
            this.kjK.setPadding(this.kjK.getPaddingLeft(), 0, i, 0);
            this.kjJ.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cES() {
        if (this.ahK) {
            this.kjw = 104;
            this.kjx = 8290;
        } else {
            this.kjw = 232;
            this.kjx = 8418;
        }
        if (this.jpI) {
            this.kjt |= 1024;
            this.kju |= 1024;
            this.kjv |= 1024;
            this.kjw |= 1024;
            this.kjx |= 1024;
            this.kjy |= 1024;
            this.kjz |= 1024;
            this.kjA |= 1024;
            this.kjD |= 1024;
            return;
        }
        this.kjt &= -1025;
        this.kju &= -1025;
        this.kjv &= -1025;
        this.kjw &= -1025;
        this.kjx &= -1025;
        this.kjy &= -1025;
        this.kjz &= -1025;
        this.kjA &= -1025;
        this.kjD &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.kjT = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.kjT);
            }
            this.ahH = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ahB = (TbImageView) this.kjT.findViewById(R.id.video_thumbnail);
            this.kjG = this.kjT.findViewById(R.id.black_mask);
            this.kjH = (TBLottieAnimationView) this.kjT.findViewById(R.id.video_loading);
            this.ahC = (ImageView) this.kjT.findViewById(R.id.video_play);
            this.kjI = (PercentSizeView) this.kjT.findViewById(R.id.video_media_controller_mask);
            this.ahD = (ImageView) this.kjT.findViewById(R.id.video_pause);
            this.ahE = (TextView) this.kjT.findViewById(R.id.video_play_count);
            this.ahF = (TextView) this.kjT.findViewById(R.id.video_play_flag);
            this.ahG = (TextView) this.kjT.findViewById(R.id.video_duration);
            this.kjJ = (SwitchImageView) this.kjT.findViewById(R.id.video_mute);
            this.kjK = (SwitchImageView) this.kjT.findViewById(R.id.video_full_screen);
            this.kjL = (OperableVideoMediaControllerView) this.kjT.findViewById(R.id.video_media_controller);
            this.kjM = (OperableVideoNetworkStateTipView) this.kjT.findViewById(R.id.video_network_state_tip);
            this.kjN = (OperableVideoShareView) this.kjT.findViewById(R.id.video_share_view);
            this.kjP = this.kjT.findViewById(R.id.video_back_btn_mask);
            this.kjO = (ImageView) this.kjT.findViewById(R.id.video_full_screen_back);
            this.kjQ = (VideoGestureView) this.kjT.findViewById(R.id.video_gesture);
            this.kjS = (OperableVideoErrorView) this.kjT.findViewById(R.id.video_error_layout);
            this.kjN.setVideoContainer(this);
            this.kjW = new n(this.mContext);
            this.kjW.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cKP() && !d.this.ahK && !d.this.jpI && d.this.adl) {
                        if (!com.baidu.mcn.b.JF().fu(d.this.kkj.jump_url)) {
                            boolean z = ((long) i2) >= d.this.kkj.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.kkj.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.kkj.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.hyX.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.bhg = d.this.kkj.card_title;
                                    aVar.bhh = d.this.kkj.button_title;
                                    aVar.bhi = d.this.kkj.jump_url;
                                    aVar.bhf = d.this.kkj.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.ahL;
                                    aVar.bhj = d.this.caf();
                                    if (z2) {
                                        d.this.hyX.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.hyX.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.hyX.isShowing()) {
                                d.this.hyX.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.kkk != null) {
                        d.this.kkk.ce(i, i2);
                    }
                }
            });
            this.kjH.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kjH.setVisibility(8);
                    d.this.ahC.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.kjH.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aOU().a(this.ahC, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ahC.setOnClickListener(this);
            this.kjJ.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.kjJ.setState(1);
            this.kjJ.setOnClickListener(this);
            this.ahB.bbh();
            this.ahB.setDrawCorner(false);
            this.ahB.setPlaceHolder(3);
            this.kjL.setOnSeekBarChangeListener(this.eAp);
            this.kjI.setHeightPercent(0.583f);
            this.kjI.setBackgroundResource(R.drawable.video_mask_bg);
            this.kjK.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.kjK.setState(0);
            this.kjK.setOnClickListener(this);
            SvgManager.aOU().a(this.ahD, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ahD.setOnClickListener(this);
            this.kjO.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.sV("cyber_player_test") || com.baidu.tbadk.a.b.sU("cyber_player_test");
            this.keZ = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
            this.keZ.setTryUseViewInSet(true);
            cKE();
            this.kjM.setPlayViewOnClickListener(this);
            this.kjT.setOnClickListener(null);
            this.kjT.setOnTouchListener(this.dRW);
            this.kjN.setOnTouchListener(this.dRW);
            this.kjS.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hiK);
            Ah(this.kjt);
            this.hyX = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cKE() {
        if (this.keZ != null && this.keZ.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kjT.addView(this.keZ.getView(), 0);
            this.keZ.getView().setLayoutParams(layoutParams);
            this.kjL.setPlayer(this.keZ);
            if (cIV()) {
                ((QuickVideoView) this.keZ).setNeedRecovery(true);
            }
            this.keZ.setContinuePlayEnable(true);
            this.keZ.setBusiness(this.kjW);
            this.keZ.setOnPreparedListener(this);
            this.keZ.setOnCompletionListener(this);
            this.keZ.setOnErrorListener(this);
            this.keZ.setOnSurfaceDestroyedListener(this);
            this.keZ.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aKV() != null) {
            this.startPosition = -1L;
            if (this.hyX != null) {
                this.hyX.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.aKV().video_url)) {
                stopPlay();
                this.ahK = bjVar.aKV().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.aKV().video_url;
                this.ahL = bjVar.getTid();
                this.ahM = bjVar.aKV().video_length.intValue();
                this.kjV = bjVar.aKV().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.kkj = bjVar.aKV().mcn_ad_card;
                cES();
                cET();
                Ah(this.kjt);
                int intValue = bjVar.aKV().video_duration.intValue() * 1000;
                this.kjL.Bb(intValue);
                this.kjL.setPlayer(this.keZ);
                this.ahG.setText(aq.stringForVideoTime(intValue));
                this.ahE.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.aKV().play_count.intValue())));
                this.kjM.setVideoLength(bjVar.aKV().video_length.intValue());
                this.kjM.setVideoDuration(bjVar.aKV().video_duration.intValue());
                this.kjM.setTid(this.ahL);
                this.kjW.cJY().am(bjVar);
                this.ahF.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.aKV().wth_mid_loc != null && bjVar.aKV().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.ahB.setScaleType(ImageView.ScaleType.MATRIX);
                    this.ahB.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.ahK) {
                        this.ahG.setText("");
                        this.ahE.setText("");
                        this.ahF.setVisibility(0);
                    }
                    this.ahB.setSmartCropCenterPointWidthRatio(bjVar.aKV().wth_mid_loc.floatValue());
                    this.ahB.setSmartCropCenterPointHeightRatio(bjVar.aKV().hth_mid_loc.floatValue());
                    this.ahB.setOnDrawListener(this.agB);
                }
                this.ahB.setPlaceHolder(3);
                this.ahB.startLoad(bjVar.aKV().thumbnail_url, 10, false);
                this.kjN.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.kjW != null) {
            this.kjW.setVideoStatsData(yVar);
            this.keZ.setBusiness(this.kjW);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cJY() {
        if (this.kjW == null) {
            return null;
        }
        return this.kjW.cJY();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afS = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aa(View.OnClickListener onClickListener) {
        this.adb = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.afA = bdUniqueId;
    }

    public void cKF() {
        e.lb().removeCallbacks(this.kjF);
        e.lb().postDelayed(this.kjF, this.kje);
    }

    public void cKG() {
        e.lb().removeCallbacks(this.kjF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.kjH.setAlpha(1.0f);
        this.kjH.setVisibility(0);
        this.ahC.setVisibility(8);
        if (this.kjH != null) {
            this.kjH.loop(true);
            this.kjH.setMinAndMaxFrame(14, 80);
            this.kjH.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cEQ() {
        if (this.kjD == this.kjv) {
            Ah(this.kju);
        }
    }

    private void cKH() {
        Ah(this.kjv);
        this.kjL.showProgress();
        if (this.kjH != null) {
            this.kjH.clearAnimation();
            this.kjH.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cEQ();
                    if (!d.this.kjU) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kjH.setVisibility(8);
                    d.this.ahC.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cKI() {
        return this.kjM != null && this.kjM.cFb();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dkS);
            MessageManager.getInstance().registerListener(this.kkm);
            if (cKI()) {
                Ah(this.kjA);
                return;
            }
            this.kjU = true;
            if (!this.keZ.isPlaying()) {
                com.baidu.tieba.play.a.a IM = TbVideoViewSet.cKw().IM(this.mVideoUrl);
                if (IM == null) {
                    this.keZ.cJQ();
                    if (!StringUtils.isNull(this.keZ.getOriginUrl())) {
                        this.keZ = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.keZ.setTryUseViewInSet(true);
                    }
                    cKE();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.keZ.setVideoDuration(this.kjV);
                        this.keZ.setVideoPath(this.mVideoUrl, this.ahL);
                        startLoadingAnim();
                        if (this.kjX) {
                            cEZ();
                        }
                    }
                } else {
                    if (this.keZ == IM) {
                        if (this.keZ.getParent() == null || this.keZ.getParent() != IM.getParent()) {
                            this.keZ.cJQ();
                            cKE();
                        }
                    } else {
                        this.keZ.cJQ();
                        IM.cJQ();
                        this.keZ = IM;
                        this.keZ.setTryUseViewInSet(true);
                        cKE();
                    }
                    this.keZ.cJL();
                    onPrepared(null);
                    cKO();
                    if (this.kjX) {
                        cEZ();
                    }
                }
                if (this.kjX) {
                    TiebaStatic.log(new an("c13357").cI("tid", this.ahL).t("fid", this.mFid).af("obj_type", this.ahK ? 1 : 2).af("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).af("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.kjU = false;
        if (this.kjH != null) {
            this.kjH.cancelAnimation();
        }
        this.keZ.stop();
        this.keZ.cJQ();
        this.kjL.asx();
        Ah(this.kjt);
        MessageManager.getInstance().unRegisterListener(this.dkS);
        MessageManager.getInstance().unRegisterListener(this.kkm);
    }

    private void cKJ() {
        this.kjU = false;
        if (this.kjH != null) {
            this.kjH.cancelAnimation();
        }
        this.keZ.stop();
        this.kjL.asx();
        Ah(this.kjt);
        MessageManager.getInstance().unRegisterListener(this.dkS);
        MessageManager.getInstance().unRegisterListener(this.kkm);
    }

    public void cEZ() {
        if (this.kjW != null && this.kjW.cKb() != null) {
            y cKs = this.kjW.cKb().cKs();
            cKs.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(cKs.kis, "", "1", cKs);
        }
    }

    public void Ah(int i) {
        cKG();
        if (this.kjD == this.kjB) {
            this.kjE = i;
            return;
        }
        this.kjD = i;
        this.ahB.setVisibility((i & 1) > 0 ? 0 : 8);
        this.kjG.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.kjH.clearAnimation();
        this.kjH.setVisibility(z ? 0 : 8);
        if (!z) {
            this.kjH.cancelAnimation();
        } else {
            this.kjH.setAlpha(1.0f);
        }
        this.ahC.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.ahD.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ahE.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.ahK && (homePageStyleAbTest & 4) != 0) {
            this.ahF.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.ahG.setVisibility((i & 16) > 0 ? 0 : 8);
        this.kjJ.setVisibility((i & 32) > 0 ? 0 : 8);
        this.kjK.setVisibility((i & 64) > 0 ? 0 : 8);
        this.kjL.setVisibility((i & 128) > 0 ? 0 : 8);
        this.kjI.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.kjL.getVisibility() == 0) {
            this.kjL.showProgress();
        }
        this.kjM.setVisibility((i & 256) > 0 ? 0 : 8);
        this.kjN.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.kjN.getVisibility() == 0) {
            this.kjN.setAlpha(1.0f);
        }
        this.kjO.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kjP.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kjQ.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.kjS.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Ai(id);
            if (id == R.id.video_mute) {
                cKL();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cKN();
            } else if (id == R.id.video_replay) {
                Ah(this.kjt);
                startPlay();
                if (this.kjX) {
                    TiebaStatic.log(new an("c13345").cI("tid", this.ahL).t("fid", this.mFid).af("obj_type", this.ahK ? 1 : 2).af("obj_locate", this.jpI ? 1 : 2));
                }
                cKK();
            } else if (id == R.id.video_play) {
                if (this.kjD == this.kjt) {
                    startPlay();
                } else {
                    Ah(this.kjw);
                    cKF();
                    this.keZ.b(this.kkl);
                }
                if (this.kjX) {
                    TiebaStatic.log(new an("c13344").cI("tid", this.ahL).t("fid", this.mFid).af("obj_type", this.ahK ? 1 : 2).af("obj_source", this.jpI ? 1 : 2).af("obj_locate", 1));
                }
                cKK();
            } else if (id == R.id.video_pause) {
                Ah(this.kjx);
                cKG();
                this.keZ.pause();
                if (this.kjX) {
                    TiebaStatic.log(new an("c13344").cI("tid", this.ahL).t("fid", this.mFid).af("obj_type", this.ahK ? 1 : 2).af("obj_source", this.jpI ? 1 : 2).af("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Ah(this.kjt);
                startPlay();
            } else if (id == R.id.retry) {
                Ah(this.kjt);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKK() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.afA);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cEP() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.keZ.setVolume(0.0f, 0.0f);
            this.kjJ.setState(1);
            return;
        }
        this.keZ.setVolume(1.0f, 1.0f);
        this.kjJ.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cKL() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.keZ.setVolume(1.0f, 1.0f);
            af.a(this.ahH, true);
            this.kjJ.setState(0);
        } else {
            this.keZ.setVolume(0.0f, 0.0f);
            this.kjJ.setState(1);
            af.a(this.ahH, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void ta(boolean z) {
        if (this.eEE == null) {
            this.eEE = new o((Activity) this.mContext);
        }
        if (z) {
            this.eEE.start();
            this.eEE.bS(true);
            return;
        }
        this.eEE.stop();
        this.eEE.bS(false);
    }

    public void cKM() {
        sk(true);
    }

    public void sk(boolean z) {
        if (this.mRootView != null && this.kjT != null && this.keZ != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.keZ.setFullScreenToDestroySurface();
            if (this.eEE == null) {
                this.eEE = new o((Activity) this.mContext);
            }
            if (this.jpI) {
                if (this.kjR.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kjR.getParent()).removeView(this.kjR);
                }
                if ((this.kjT.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.jpI = false;
                    this.kjY = true;
                    ((ViewGroup) this.kjT.getParent()).removeView(this.kjT);
                    ((ViewGroup) this.mRootView).addView(this.kjT);
                    this.kjY = false;
                    h((Activity) this.mContext, this.jpI);
                }
                if (!this.ahK && z) {
                    this.eEE.Ff();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.ahK && z) {
                        this.eEE.Ff();
                    }
                    if (this.mContext instanceof Activity) {
                        this.kjT.getLocationOnScreen(this.kkc);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.kjY = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.kjR == null) {
                                    this.kjR = new View(this.mContext);
                                    this.kjR.setClickable(true);
                                    this.kjR.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.kjR.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.kjR.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.kjR.getParent()).removeView(this.kjR);
                                }
                                this.kjR.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.kjR);
                                ((ViewGroup) childAt).addView(this.kjT);
                                this.kjY = false;
                                this.jpI = true;
                                h((Activity) this.mContext, this.jpI);
                                if (this.hyX != null && this.hyX.isShowing()) {
                                    this.hyX.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.kjX) {
                    TiebaStatic.log(new an("c13360").cI("tid", this.ahL).t("fid", this.mFid).af("obj_type", this.ahK ? 1 : 2));
                }
            }
            cES();
            cET();
            if (this.keZ.isPlaying()) {
                Ah(this.kju);
            } else {
                if (!this.isNewPlayer) {
                    this.kjD |= 1;
                }
                Ah(this.kjD);
            }
            this.kjK.deM();
            nW(this.jpI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKN() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.ahK) {
            cKM();
        } else if (this.kjD == this.kjB) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.kjT.setScaleX(1.0f);
                    d.this.kjT.setScaleY(1.0f);
                    d.this.kjT.setTranslationX(0.0f);
                    d.this.kjT.setTranslationY(0.0f);
                    d.this.kjN.setScaleX(1.0f);
                    d.this.kjN.setScaleY(1.0f);
                    d.this.kjT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.kke) {
                        d.this.cKM();
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
            if (!this.kke) {
                float width = this.mRootView.getWidth() / this.kjT.getWidth();
                float height = this.mRootView.getHeight() / this.kjT.getHeight();
                this.kjT.setPivotX(0.0f);
                this.kjT.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kjT, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.kjT, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.kjN, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.kjN, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.kjT, "TranslationX", this.kjT.getTranslationX(), this.kkc[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.kjT, "TranslationY", this.kjT.getTranslationY(), this.kkc[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.kjR, "alpha", this.kjR.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kjN, "alpha", this.kjN.getAlpha(), 0.0f);
            } else {
                float width2 = this.kka / this.kjT.getWidth();
                float height2 = this.kkd / this.kjT.getHeight();
                this.kjT.setPivotX(0.0f);
                this.kjT.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kjT, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.kjT, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.kjN, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.kjN, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.kjT, "TranslationX", this.kjT.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.kjT, "TranslationY", this.kjT.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kjN, "alpha", this.kjN.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.kjE != -1) {
                this.kjD = this.kjE;
                this.kjE = -1;
                if (this.kjD == this.kjC || this.kjD == this.kjw || this.kjD == this.kju) {
                    this.keZ.b(this.kkl);
                    Ah(this.kju);
                }
            }
        } else {
            cKM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.ahK && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.kjT != null) {
                    if (z) {
                        this.kjT.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.kjT.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cnw();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.kjT.setSystemUiVisibility(0);
            }
        }
    }

    private void cKO() {
        Ah(this.kjv);
        this.kjL.showProgress();
        cKH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nW(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cEP();
        if (this.kjU) {
            if (this.jpI && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.keZ.b(this.kkl);
            if (cIV() && ((QuickVideoView) this.keZ).khb) {
                cKH();
            }
        }
    }

    public void onCompletion(g gVar) {
        Ah(this.kjz);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        Ah(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.isNewPlayer && !this.kjY) {
            if (this.kjD == this.kjx || (this.kjD == this.kjy && !this.keZ.isPlaying())) {
                cKJ();
                Ah(this.kjx);
            } else if (this.kjD == this.kjz) {
                cKJ();
                Ah(this.kjz);
            } else {
                cKJ();
            }
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cKO();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cJq() {
        return this.kjT;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.kjU || this.keZ.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.keZ.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bpf() {
    }

    protected void Ai(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.jpI;
    }

    protected boolean cER() {
        return this.ahK && this.jpI;
    }

    public boolean cIV() {
        return !this.isNewPlayer && (this.keZ instanceof QuickVideoView);
    }

    private void cnw() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kjT.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kjT.setSystemUiVisibility(4);
        } else {
            this.kjT.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cEV() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.keZ.isPlaying() && !af.baJ()) {
            this.keZ.setVolume(1.0f, 1.0f);
            this.kjJ.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cEW() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean nV(boolean z) {
        if (z) {
            this.kjH.cancelAnimation();
            if (this.kjD == this.kju || this.kjD == this.kjv || this.kjD == this.kjw || this.kjD == this.kjt) {
                stopPlay();
            }
            this.kjD |= 1;
            Ah(this.kjD);
        } else if (this.kjD == this.kjt) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.jpI;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.jpI) {
            cKN();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int caf() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cKP() {
        return this.kkj != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tb(boolean z) {
        this.adl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.kkk = aVar;
    }
}
