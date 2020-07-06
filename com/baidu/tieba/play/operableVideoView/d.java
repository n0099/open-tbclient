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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
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
    protected BdUniqueId agK;
    protected TbImageView ajE;
    private ImageView ajF;
    private ImageView ajG;
    private TextView ajH;
    private TextView ajI;
    private TextView ajJ;
    protected boolean ajN;
    protected String ajO;
    protected long ajP;
    private com.baidu.mcn.c ibP;
    private o jsn;
    protected com.baidu.tieba.play.a.a kRW;
    private View kWJ;
    private TBLottieAnimationView kWK;
    private PercentSizeView kWL;
    protected SwitchImageView kWM;
    protected SwitchImageView kWN;
    protected OperableVideoMediaControllerView kWO;
    protected OperableVideoNetworkStateTipView kWP;
    protected OperableVideoShareView kWQ;
    protected ImageView kWR;
    protected View kWS;
    protected VideoGestureView kWT;
    private View kWU;
    private OperableVideoErrorView kWV;
    protected ViewGroup kWW;
    protected boolean kWX;
    protected int kWY;
    protected n kWZ;
    private float kXc;
    private float kXd;
    private int kXe;
    private int kXg;
    private boolean kXh;
    private float kXk;
    private int kXl;
    private McnAdInfo kXm;
    private a kXn;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int kWh = 3000;
    protected final int kWi = 1;
    protected final int kWj = 2;
    protected final int kWk = 4;
    protected final int kWl = 8;
    protected final int kWm = 16;
    protected final int kWn = 32;
    protected final int kWo = 64;
    protected final int kWp = 128;
    protected final int kWq = 256;
    protected final int kWr = 512;
    protected final int kWs = 1024;
    protected final int kWt = 2048;
    protected final int kWu = 4096;
    protected final int kWv = 8192;
    protected int kWw = 8211;
    protected int kWx = 0;
    protected int kWy = 4;
    protected int kWz = 232;
    protected int kWA = 8416;
    protected int kWB = 0;
    protected int kWC = 513;
    protected int kWD = 259;
    protected int kWE = 2048;
    protected int kWF = 0;
    protected int STATE_ERROR = 4099;
    protected int kWG = this.kWw;
    private int kxm = 0;
    private int kWH = -1;
    private Runnable kWI = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.BW(d.this.kWx);
        }
    };
    private WeakReference<Context> ajK = null;
    protected boolean kbl = false;
    private boolean isNewPlayer = false;
    protected boolean kXa = true;
    private boolean kXb = false;
    private int[] kXf = new int[2];
    private int kXi = 0;
    private int kXj = 0;
    protected View.OnClickListener ahw = null;
    protected View.OnClickListener aeb = null;
    private boolean aek = false;
    private long startPosition = -1;
    protected boolean aiQ = false;
    private TbImageView.c ais = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a yO = com.baidu.tbadk.imageManager.c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), 10));
                if (yO != null) {
                    int width = yO.getWidth();
                    i = yO.getHeight();
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
                        if (d.this.aiQ && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener eZq = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.BW(d.this.kWz);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.kRW.isPlaying()) {
                    d.this.kRW.b(d.this.kXo);
                }
                d.this.cWk();
                if (d.this.kXa) {
                    TiebaStatic.log(new ao("c13355").dk("tid", d.this.ajO).s("fid", d.this.mFid).ag("obj_type", d.this.ajN ? 1 : 2).ag("obj_locate", d.this.kbl ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hKL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.kRW.isPlaying()) {
                d.this.kRW.pause();
                if (d.this.kWG == d.this.kWz) {
                    d.this.BW(d.this.kWA);
                } else {
                    d.this.BW(d.this.kWB);
                }
                d.this.BX(R.id.video_pause);
            } else if (d.this.kWG == d.this.kWA || d.this.kWG == (d.this.kWA | 1)) {
                d.this.BW(d.this.kWz);
                d.this.cWk();
                d.this.kRW.b(d.this.kXo);
                d.this.BX(R.id.video_play);
            } else if (d.this.kWG == d.this.kWB || d.this.kWG == (d.this.kWB | 1)) {
                d.this.BW(d.this.kWx);
                d.this.kRW.b(d.this.kXo);
                d.this.BX(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.kRW.isPlaying()) {
                if (d.this.kWG == d.this.kWx || d.this.kWG == d.this.kWy) {
                    d.this.BW(d.this.kWz);
                    d.this.cWk();
                    return true;
                } else if (d.this.kWG == d.this.kWz) {
                    d.this.BW(d.this.kWx);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.kWG == d.this.kWA) {
                d.this.BW(d.this.kWB);
                return true;
            } else if (d.this.kWG == (d.this.kWA | 1)) {
                d.this.BW(d.this.kWB | 1);
                return true;
            } else if (d.this.kWG == d.this.kWB) {
                d.this.BW(d.this.kWA);
                return true;
            } else if (d.this.kWG == (d.this.kWB | 1)) {
                d.this.BW(d.this.kWA | 1);
                return true;
            } else {
                d.this.BW(d.this.kWw);
                d.this.startPlay();
                d.this.cWp();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kxm = 0;
            if (d.this.kbl) {
                d.this.j((Activity) d.this.mContext, true);
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
            if (d.this.ajN && d.this.cQw()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.kxm) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.kRW.isPlaying()) {
                                d.this.kRW.pause();
                                d.this.BW(d.this.kWF);
                            }
                            d.this.kxm = 4;
                            d.this.kWH = d.this.kWG;
                            d.this.kWG = d.this.kWE;
                            d.this.kXg = d.this.kWW.getMeasuredHeight();
                            d.this.kXk = d.this.kXd / d.this.kXg;
                            d.this.kXl = (int) (1.2f * d.this.mRootView.getWidth());
                            cP(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cP(rawX, rawY);
                        break;
                }
            } else if (d.this.kWG == d.this.kWx || d.this.kWG == d.this.kWz || d.this.kWG == d.this.kWA || d.this.kWG == d.this.kWB || d.this.kWG == d.this.kWE || d.this.kWG == (d.this.kWA | 1) || d.this.kWG == (d.this.kWB | 1)) {
                switch (d.this.kxm) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kxm = 3;
                            d.this.kXe = d.this.kRW.getCurrentPosition();
                            aw(f);
                        } else if (motionEvent.getX() < d.this.kWW.getWidth() / 2) {
                            d.this.kxm = 2;
                            d.this.kWT.q(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kxm = 1;
                            d.this.kWT.p(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.kWG != d.this.kWE) {
                            if ((d.this.kWG & 1) > 0) {
                                d.this.kWE |= 1;
                            } else {
                                d.this.kWE &= -2;
                            }
                            d.this.BW(d.this.kWE);
                            break;
                        }
                        break;
                    case 1:
                        d.this.kWT.p(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cQA();
                            break;
                        }
                        break;
                    case 2:
                        d.this.kWT.q(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aw(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cP(int i, int i2) {
            if (d.this.kXi != i2 || d.this.kXj != i) {
                d.this.kXh = d.this.kXi - i2 > 0 || ((float) i2) < d.this.kXc / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.kWW.getLayoutParams();
                if (i2 != d.this.kXi) {
                    int i3 = d.this.kXg - i2;
                    int i4 = (int) (i3 * d.this.kXk);
                    if (i4 < d.this.kXl) {
                        i4 = d.this.kXl;
                        i3 = (int) (i4 / d.this.kXk);
                    }
                    if (i4 != d.this.kXl) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.kWW.setLayoutParams(layoutParams);
                    }
                    d.this.kXi = i2;
                    d.this.kWW.setTranslationY(d.this.kXi);
                }
                if (i != d.this.kXi) {
                    d.this.kXj = i;
                    d.this.kWW.setTranslationX(d.this.kXj + ((d.this.kXd - layoutParams.width) / 2.0f));
                }
                d.this.kWU.setAlpha((layoutParams.width - d.this.kXl) / (d.this.kXd - d.this.kXl));
                if (d.this.kWQ.getVisibility() == 0) {
                    float f = d.this.kXc / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.kWQ.setAlpha(f2);
                }
            }
        }

        private void aw(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.kXe -= 1000;
                z = true;
            } else {
                d.this.kXe += 1000;
                z = false;
            }
            int duration = d.this.kRW.getDuration();
            if (d.this.kXe < 0) {
                d.this.kXe = 0;
            } else if (d.this.kXe > duration) {
                d.this.kXe = duration;
            }
            String str = ar.stringForVideoTime(d.this.kXe) + " / " + ar.stringForVideoTime(duration);
            if (d.this.kWT != null) {
                d.this.kWT.A(z, str);
            }
            d.this.kWO.setCurrentDuration(d.this.kXe, false);
        }
    };
    private View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.kWG == d.this.kWE) {
                if (d.this.kxm == 4) {
                    d.this.cWs();
                    d.this.kXi = 0;
                    d.this.kXj = 0;
                } else {
                    d.this.kWG = -1;
                    if (d.this.kxm != 3) {
                        if (d.this.kWH != -1) {
                            d.this.BW(d.this.kWH);
                            d.this.kWH = -1;
                        } else if (d.this.kRW.isPlaying()) {
                            d.this.BW(d.this.kWx);
                        } else {
                            d.this.BW(d.this.kWA);
                        }
                    } else {
                        d.this.kWO.setCurrentDuration(d.this.kXe, true);
                        if (d.this.kXe <= d.this.kRW.getDuration()) {
                            if (!d.this.kRW.isPlaying()) {
                                d.this.kRW.b(d.this.kXo);
                            }
                            d.this.BW(d.this.kWx);
                        }
                    }
                }
                if (d.this.kXa) {
                    String str = null;
                    if (d.this.kxm != 1) {
                        if (d.this.kxm != 2) {
                            if (d.this.kxm == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!ar.isEmpty(str)) {
                        TiebaStatic.log(new ao(str).dk("tid", d.this.ajO).s("fid", d.this.mFid));
                    }
                }
                d.this.kxm = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a kXo = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cWc() {
            d.this.kRW.cVv();
            d.this.cWj();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cWd() {
            d.this.BW(d.this.kWw);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener kXp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ag.a(d.this.ajK, true);
                    }
                    d.this.kRW.setVolume(1.0f, 1.0f);
                    d.this.kWM.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cQu();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cp(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.kXc = l.getEquipmentHeight(this.mContext);
            this.kXd = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cQy() {
        int dimension;
        int i;
        int i2;
        this.kWP.am(this.ajN, this.kbl);
        this.kWQ.am(this.ajN, this.kbl);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.ajN) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kbl) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ajH.setPadding(0, 0, i2, 0);
            this.kWN.setPadding(this.kWN.getPaddingLeft(), 0, i, 0);
            this.kWM.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cQx() {
        if (this.ajN) {
            this.kWz = 104;
            this.kWA = 8290;
        } else {
            this.kWz = 232;
            this.kWA = 8418;
        }
        if (this.kbl) {
            this.kWw |= 1024;
            this.kWx |= 1024;
            this.kWy |= 1024;
            this.kWz |= 1024;
            this.kWA |= 1024;
            this.kWB |= 1024;
            this.kWC |= 1024;
            this.kWD |= 1024;
            this.kWG |= 1024;
            return;
        }
        this.kWw &= -1025;
        this.kWx &= -1025;
        this.kWy &= -1025;
        this.kWz &= -1025;
        this.kWA &= -1025;
        this.kWB &= -1025;
        this.kWC &= -1025;
        this.kWD &= -1025;
        this.kWG &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.kWW = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.kWW);
            }
            this.ajK = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ajE = (TbImageView) this.kWW.findViewById(R.id.video_thumbnail);
            this.kWJ = this.kWW.findViewById(R.id.black_mask);
            this.kWK = (TBLottieAnimationView) this.kWW.findViewById(R.id.video_loading);
            this.ajF = (ImageView) this.kWW.findViewById(R.id.video_play);
            this.kWL = (PercentSizeView) this.kWW.findViewById(R.id.video_media_controller_mask);
            this.ajG = (ImageView) this.kWW.findViewById(R.id.video_pause);
            this.ajH = (TextView) this.kWW.findViewById(R.id.video_play_count);
            this.ajI = (TextView) this.kWW.findViewById(R.id.video_play_flag);
            this.ajJ = (TextView) this.kWW.findViewById(R.id.video_duration);
            this.kWM = (SwitchImageView) this.kWW.findViewById(R.id.video_mute);
            this.kWN = (SwitchImageView) this.kWW.findViewById(R.id.video_full_screen);
            this.kWO = (OperableVideoMediaControllerView) this.kWW.findViewById(R.id.video_media_controller);
            this.kWP = (OperableVideoNetworkStateTipView) this.kWW.findViewById(R.id.video_network_state_tip);
            this.kWQ = (OperableVideoShareView) this.kWW.findViewById(R.id.video_share_view);
            this.kWS = this.kWW.findViewById(R.id.video_back_btn_mask);
            this.kWR = (ImageView) this.kWW.findViewById(R.id.video_full_screen_back);
            this.kWT = (VideoGestureView) this.kWW.findViewById(R.id.video_gesture);
            this.kWV = (OperableVideoErrorView) this.kWW.findViewById(R.id.video_error_layout);
            this.kWQ.setVideoContainer(this);
            this.kWZ = new n(this.mContext);
            this.kWZ.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bM(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cWu() && !d.this.ajN && !d.this.kbl && d.this.aek) {
                        if (!com.baidu.mcn.b.MG().go(d.this.kXm.jump_url)) {
                            boolean z = ((long) i2) >= d.this.kXm.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.kXm.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.kXm.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.ibP.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.btJ = d.this.kXm.card_title;
                                    aVar.btK = d.this.kXm.button_title;
                                    aVar.btL = d.this.kXm.jump_url;
                                    aVar.btI = d.this.kXm.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.ajO;
                                    aVar.btM = d.this.cko();
                                    if (z2) {
                                        d.this.ibP.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.ibP.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.ibP.isShowing()) {
                                d.this.ibP.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.kXn != null) {
                        d.this.kXn.cp(i, i2);
                    }
                }
            });
            this.kWK.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kWK.setVisibility(8);
                    d.this.ajF.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.kWK.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aWQ().a(this.ajF, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ajF.setOnClickListener(this);
            this.kWM.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.kWM.setState(1);
            this.kWM.setOnClickListener(this);
            this.ajE.bjF();
            this.ajE.setDrawCorner(false);
            this.ajE.setPlaceHolder(3);
            this.kWO.setOnSeekBarChangeListener(this.eZq);
            this.kWL.setHeightPercent(0.583f);
            this.kWL.setBackgroundResource(R.drawable.video_mask_bg);
            this.kWN.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.kWN.setState(0);
            this.kWN.setOnClickListener(this);
            SvgManager.aWQ().a(this.ajG, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ajG.setOnClickListener(this);
            this.kWR.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test");
            this.kRW = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
            this.kRW.setTryUseViewInSet(true);
            cWj();
            this.kWP.setPlayViewOnClickListener(this);
            this.kWW.setOnClickListener(null);
            this.kWW.setOnTouchListener(this.eEC);
            this.kWQ.setOnTouchListener(this.eEC);
            this.kWV.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hKL);
            BW(this.kWw);
            this.ibP = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cWj() {
        if (this.kRW != null && this.kRW.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kWW.addView(this.kRW.getView(), 0);
            this.kRW.getView().setLayoutParams(layoutParams);
            this.kWO.setPlayer(this.kRW);
            if (cUA()) {
                ((QuickVideoView) this.kRW).setNeedRecovery(true);
            }
            this.kRW.setContinuePlayEnable(true);
            this.kRW.setBusiness(this.kWZ);
            this.kRW.setOnPreparedListener(this);
            this.kRW.setOnCompletionListener(this);
            this.kRW.setOnErrorListener(this);
            this.kRW.setOnSurfaceDestroyedListener(this);
            this.kRW.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bu buVar) {
        if (buVar != null && buVar.aSH() != null) {
            this.startPosition = -1L;
            if (this.ibP != null) {
                this.ibP.reset();
            }
            if (!ar.equals(this.mVideoUrl, buVar.aSH().video_url)) {
                stopPlay();
                this.ajN = buVar.aSH().is_vertical.intValue() == 1;
                this.mVideoUrl = buVar.aSH().video_url;
                this.ajO = buVar.getTid();
                this.ajP = buVar.aSH().video_length.intValue();
                this.kWY = buVar.aSH().video_duration.intValue();
                this.mFid = buVar.getFid();
                this.kXm = buVar.aSH().mcn_ad_card;
                cQx();
                cQy();
                BW(this.kWw);
                int intValue = buVar.aSH().video_duration.intValue() * 1000;
                this.kWO.CP(intValue);
                this.kWO.setPlayer(this.kRW);
                this.ajJ.setText(ar.stringForVideoTime(intValue));
                this.ajH.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), ar.numFormatOverWan(buVar.aSH().play_count.intValue())));
                this.kWP.setVideoLength(buVar.aSH().video_length.intValue());
                this.kWP.setVideoDuration(buVar.aSH().video_duration.intValue());
                this.kWP.setTid(this.ajO);
                this.kWZ.cVD().an(buVar);
                this.ajI.setVisibility(8);
                this.ajE.setPlaceHolder(3);
                this.ajE.startLoad(buVar.aSH().thumbnail_url, 10, false);
                this.kWQ.setShareData(buVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.kWZ != null) {
            this.kWZ.setVideoStatsData(yVar);
            this.kRW.setBusiness(this.kWZ);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cVD() {
        if (this.kWZ == null) {
            return null;
        }
        return this.kWZ.cVD();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aa(View.OnClickListener onClickListener) {
        this.aeb = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agK = bdUniqueId;
    }

    public void cWk() {
        e.lt().removeCallbacks(this.kWI);
        e.lt().postDelayed(this.kWI, this.kWh);
    }

    public void cWl() {
        e.lt().removeCallbacks(this.kWI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.kWK.setAlpha(1.0f);
        this.kWK.setVisibility(0);
        this.ajF.setVisibility(8);
        if (this.kWK != null) {
            this.kWK.loop(true);
            this.kWK.setMinAndMaxFrame(14, 80);
            this.kWK.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cQv() {
        if (this.kWG == this.kWy) {
            BW(this.kWx);
        }
    }

    private void cWm() {
        BW(this.kWy);
        this.kWO.showProgress();
        if (this.kWK != null) {
            this.kWK.clearAnimation();
            this.kWK.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cQv();
                    if (!d.this.kWX) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kWK.setVisibility(8);
                    d.this.ajF.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cWn() {
        return this.kWP != null && this.kWP.cQF();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dFp);
            MessageManager.getInstance().registerListener(this.kXp);
            if (cWn()) {
                BW(this.kWD);
                return;
            }
            this.kWX = true;
            if (!this.kRW.isPlaying()) {
                com.baidu.tieba.play.a.a Ld = TbVideoViewSet.cWb().Ld(this.mVideoUrl);
                if (Ld == null) {
                    this.kRW.cVv();
                    if (!StringUtils.isNull(this.kRW.getOriginUrl())) {
                        this.kRW = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.kRW.setTryUseViewInSet(true);
                    }
                    cWj();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kRW.setVideoDuration(this.kWY);
                        this.kRW.setVideoPath(this.mVideoUrl, this.ajO);
                        startLoadingAnim();
                        if (this.kXa) {
                            cQD();
                        }
                    }
                } else {
                    if (this.kRW == Ld) {
                        if (this.kRW.getParent() == null || this.kRW.getParent() != Ld.getParent()) {
                            this.kRW.cVv();
                            cWj();
                        }
                    } else {
                        this.kRW.cVv();
                        Ld.cVv();
                        this.kRW = Ld;
                        this.kRW.setTryUseViewInSet(true);
                        cWj();
                    }
                    this.kRW.cVq();
                    onPrepared(null);
                    cWt();
                    if (this.kXa) {
                        cQD();
                    }
                }
                if (this.kXa) {
                    TiebaStatic.log(new ao("c13357").dk("tid", this.ajO).s("fid", this.mFid).ag("obj_type", this.ajN ? 1 : 2).ag("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ag("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.kWX = false;
        if (this.kWK != null) {
            this.kWK.cancelAnimation();
        }
        this.kRW.stop();
        this.kRW.cVv();
        this.kWO.axj();
        BW(this.kWw);
        MessageManager.getInstance().unRegisterListener(this.dFp);
        MessageManager.getInstance().unRegisterListener(this.kXp);
    }

    private void cWo() {
        this.kWX = false;
        if (this.kWK != null) {
            this.kWK.cancelAnimation();
        }
        this.kRW.stop();
        this.kWO.axj();
        BW(this.kWw);
        MessageManager.getInstance().unRegisterListener(this.dFp);
        MessageManager.getInstance().unRegisterListener(this.kXp);
    }

    public void cQD() {
        if (this.kWZ != null && this.kWZ.cVG() != null) {
            y cVX = this.kWZ.cVG().cVX();
            cVX.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(cVX.kVt, "", "1", cVX, this.kRW.getPcdnState());
        }
    }

    public void BW(int i) {
        cWl();
        if (this.kWG == this.kWE) {
            this.kWH = i;
            return;
        }
        this.kWG = i;
        this.ajE.setVisibility((i & 1) > 0 ? 0 : 8);
        this.kWJ.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.kWK.clearAnimation();
        this.kWK.setVisibility(z ? 0 : 8);
        if (!z) {
            this.kWK.cancelAnimation();
        } else {
            this.kWK.setAlpha(1.0f);
        }
        this.ajF.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.ajG.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ajH.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ajJ.setVisibility((i & 16) > 0 ? 0 : 8);
        this.kWM.setVisibility((i & 32) > 0 ? 0 : 8);
        this.kWN.setVisibility((i & 64) > 0 ? 0 : 8);
        this.kWO.setVisibility((i & 128) > 0 ? 0 : 8);
        this.kWL.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.kWO.getVisibility() == 0) {
            this.kWO.showProgress();
        }
        this.kWP.setVisibility((i & 256) > 0 ? 0 : 8);
        this.kWQ.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.kWQ.getVisibility() == 0) {
            this.kWQ.setAlpha(1.0f);
        }
        this.kWR.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kWS.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kWT.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.kWV.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            BX(id);
            if (id == R.id.video_mute) {
                cWq();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cWs();
            } else if (id == R.id.video_replay) {
                BW(this.kWw);
                startPlay();
                if (this.kXa) {
                    TiebaStatic.log(new ao("c13345").dk("tid", this.ajO).s("fid", this.mFid).ag("obj_type", this.ajN ? 1 : 2).ag("obj_locate", this.kbl ? 1 : 2));
                }
                cWp();
            } else if (id == R.id.video_play) {
                if (this.kWG == this.kWw) {
                    startPlay();
                } else {
                    BW(this.kWz);
                    cWk();
                    this.kRW.b(this.kXo);
                }
                if (this.kXa) {
                    TiebaStatic.log(new ao("c13344").dk("tid", this.ajO).s("fid", this.mFid).ag("obj_type", this.ajN ? 1 : 2).ag("obj_source", this.kbl ? 1 : 2).ag("obj_locate", 1));
                }
                cWp();
            } else if (id == R.id.video_pause) {
                BW(this.kWA);
                cWl();
                this.kRW.pause();
                if (this.kXa) {
                    TiebaStatic.log(new ao("c13344").dk("tid", this.ajO).s("fid", this.mFid).ag("obj_type", this.ajN ? 1 : 2).ag("obj_source", this.kbl ? 1 : 2).ag("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                BW(this.kWw);
                startPlay();
            } else if (id == R.id.retry) {
                BW(this.kWw);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWp() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.agK);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cQu() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.kRW.setVolume(0.0f, 0.0f);
            this.kWM.setState(1);
            return;
        }
        this.kRW.setVolume(1.0f, 1.0f);
        this.kWM.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cWq() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.kRW.setVolume(1.0f, 1.0f);
            ag.a(this.ajK, true);
            this.kWM.setState(0);
        } else {
            this.kRW.setVolume(0.0f, 0.0f);
            this.kWM.setState(1);
            ag.a(this.ajK, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void tM(boolean z) {
        if (this.jsn == null) {
            this.jsn = new o((Activity) this.mContext);
        }
        if (z) {
            this.jsn.start();
            this.jsn.ch(true);
            return;
        }
        this.jsn.stop();
        this.jsn.ch(false);
    }

    public void cWr() {
        sW(true);
    }

    public void sW(boolean z) {
        if (this.mRootView != null && this.kWW != null && this.kRW != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.kRW.setFullScreenToDestroySurface();
            if (this.jsn == null) {
                this.jsn = new o((Activity) this.mContext);
            }
            if (this.kbl) {
                if (this.kWU.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kWU.getParent()).removeView(this.kWU);
                }
                if ((this.kWW.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kbl = false;
                    this.kXb = true;
                    ((ViewGroup) this.kWW.getParent()).removeView(this.kWW);
                    ((ViewGroup) this.mRootView).addView(this.kWW);
                    this.kXb = false;
                    j((Activity) this.mContext, this.kbl);
                }
                if (!this.ajN && z) {
                    this.jsn.Ii();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.ajN && z) {
                        this.jsn.Ii();
                    }
                    if (this.mContext instanceof Activity) {
                        this.kWW.getLocationOnScreen(this.kXf);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.kXb = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.kWU == null) {
                                    this.kWU = new View(this.mContext);
                                    this.kWU.setClickable(true);
                                    this.kWU.setBackgroundColor(an.getColor(R.color.black_alpha100));
                                    this.kWU.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.kWU.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.kWU.getParent()).removeView(this.kWU);
                                }
                                this.kWU.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.kWU);
                                ((ViewGroup) childAt).addView(this.kWW);
                                this.kXb = false;
                                this.kbl = true;
                                j((Activity) this.mContext, this.kbl);
                                if (this.ibP != null && this.ibP.isShowing()) {
                                    this.ibP.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.kXa) {
                    TiebaStatic.log(new ao("c13360").dk("tid", this.ajO).s("fid", this.mFid).ag("obj_type", this.ajN ? 1 : 2));
                }
            }
            cQx();
            cQy();
            if (this.kRW.isPlaying()) {
                BW(this.kWx);
            } else {
                if (!this.isNewPlayer) {
                    this.kWG |= 1;
                }
                BW(this.kWG);
            }
            this.kWN.dqG();
            tN(this.kbl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWs() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.ajN) {
            cWr();
        } else if (this.kWG == this.kWE) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.kWW.setScaleX(1.0f);
                    d.this.kWW.setScaleY(1.0f);
                    d.this.kWW.setTranslationX(0.0f);
                    d.this.kWW.setTranslationY(0.0f);
                    d.this.kWQ.setScaleX(1.0f);
                    d.this.kWQ.setScaleY(1.0f);
                    d.this.kWW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.kXh) {
                        d.this.cWr();
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
            if (!this.kXh) {
                float width = this.mRootView.getWidth() / this.kWW.getWidth();
                float height = this.mRootView.getHeight() / this.kWW.getHeight();
                this.kWW.setPivotX(0.0f);
                this.kWW.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kWW, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.kWW, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.kWQ, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.kWQ, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.kWW, "TranslationX", this.kWW.getTranslationX(), this.kXf[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.kWW, "TranslationY", this.kWW.getTranslationY(), this.kXf[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.kWU, "alpha", this.kWU.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kWQ, "alpha", this.kWQ.getAlpha(), 0.0f);
            } else {
                float width2 = this.kXd / this.kWW.getWidth();
                float height2 = this.kXg / this.kWW.getHeight();
                this.kWW.setPivotX(0.0f);
                this.kWW.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kWW, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.kWW, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.kWQ, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.kWQ, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.kWW, "TranslationX", this.kWW.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.kWW, "TranslationY", this.kWW.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kWQ, "alpha", this.kWQ.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.kWH != -1) {
                this.kWG = this.kWH;
                this.kWH = -1;
                if (this.kWG == this.kWF || this.kWG == this.kWz || this.kWG == this.kWx) {
                    this.kRW.b(this.kXo);
                    BW(this.kWx);
                }
            }
        } else {
            cWr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.ajN && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.kWW != null) {
                    if (z) {
                        this.kWW.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.kWW.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cxV();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.kWW.setSystemUiVisibility(0);
            }
        }
    }

    private void cWt() {
        BW(this.kWy);
        this.kWO.showProgress();
        cWm();
    }

    protected void tN(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cQu();
        if (this.kWX) {
            if (this.kbl && (this.mContext instanceof Activity)) {
                j((Activity) this.mContext, true);
            }
            this.kRW.b(this.kXo);
            if (cUA() && ((QuickVideoView) this.kRW).kUa) {
                cWm();
            }
        }
    }

    public void onCompletion(g gVar) {
        BW(this.kWC);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        BW(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.isNewPlayer && !this.kXb) {
            if (this.kWG == this.kWA || (this.kWG == this.kWB && !this.kRW.isPlaying())) {
                cWo();
                BW(this.kWA);
            } else if (this.kWG == this.kWC) {
                cWo();
                BW(this.kWC);
            } else {
                cWo();
            }
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cWt();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cUV() {
        return this.kWW;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.kWX || this.kRW.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.kRW.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bxS() {
    }

    protected void BX(int i) {
    }

    protected boolean J(MotionEvent motionEvent) {
        return this.kbl;
    }

    protected boolean cQw() {
        return this.ajN && this.kbl;
    }

    public boolean cUA() {
        return !this.isNewPlayer && (this.kRW instanceof QuickVideoView);
    }

    private void cxV() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kWW.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kWW.setSystemUiVisibility(4);
        } else {
            this.kWW.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cQA() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.kRW.isPlaying() && !ag.bjh()) {
            this.kRW.setVolume(1.0f, 1.0f);
            this.kWM.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cQB() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean oC(boolean z) {
        if (z) {
            this.kWK.cancelAnimation();
            if (this.kWG == this.kWx || this.kWG == this.kWy || this.kWG == this.kWz || this.kWG == this.kWw) {
                stopPlay();
            }
            this.kWG |= 1;
            BW(this.kWG);
        } else if (this.kWG == this.kWw) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kbl;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cWh() {
        if (this.kbl) {
            cWs();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cko() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cWu() {
        return this.kXm != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tO(boolean z) {
        this.aek = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.kXn = aVar;
    }
}
