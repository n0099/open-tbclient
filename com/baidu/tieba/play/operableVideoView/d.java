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
    private com.baidu.mcn.c hNQ;
    private o jaq;
    private View kBF;
    private TBLottieAnimationView kBG;
    private PercentSizeView kBH;
    protected SwitchImageView kBI;
    protected SwitchImageView kBJ;
    protected OperableVideoMediaControllerView kBK;
    protected OperableVideoNetworkStateTipView kBL;
    protected OperableVideoShareView kBM;
    protected ImageView kBN;
    protected View kBO;
    protected VideoGestureView kBP;
    private View kBQ;
    private OperableVideoErrorView kBR;
    protected ViewGroup kBS;
    protected boolean kBT;
    protected int kBU;
    protected n kBV;
    private float kBY;
    private float kBZ;
    private int kCa;
    private int kCc;
    private boolean kCd;
    private float kCg;
    private int kCh;
    private McnAdInfo kCi;
    private a kCj;
    protected com.baidu.tieba.play.a.a kwT;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int kBd = 3000;
    protected final int kBe = 1;
    protected final int kBf = 2;
    protected final int kBg = 4;
    protected final int kBh = 8;
    protected final int kBi = 16;
    protected final int kBj = 32;
    protected final int kBk = 64;
    protected final int kBl = 128;
    protected final int kBm = 256;
    protected final int kBn = 512;
    protected final int kBo = 1024;
    protected final int kBp = 2048;
    protected final int kBq = 4096;
    protected final int kBr = 8192;
    protected int kBs = 8211;
    protected int kBt = 0;
    protected int kBu = 4;
    protected int kBv = 232;
    protected int kBw = 8416;
    protected int kBx = 0;
    protected int kBy = 513;
    protected int kBz = 259;
    protected int kBA = 2048;
    protected int kBB = 0;
    protected int STATE_ERROR = 4099;
    protected int kBC = this.kBs;
    private int kct = 0;
    private int kBD = -1;
    private Runnable kBE = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.AS(d.this.kBt);
        }
    };
    private WeakReference<Context> aio = null;
    protected boolean jGv = false;
    private boolean isNewPlayer = false;
    protected boolean kBW = true;
    private boolean kBX = false;
    private int[] kCb = new int[2];
    private int kCe = 0;
    private int kCf = 0;
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
                com.baidu.adp.widget.ImageView.a yv = com.baidu.tbadk.imageManager.c.bet().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), 10));
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
    private SeekBar.OnSeekBarChangeListener eOU = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.AS(d.this.kBv);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.kwT.isPlaying()) {
                    d.this.kwT.b(d.this.kCk);
                }
                d.this.cRD();
                if (d.this.kBW) {
                    TiebaStatic.log(new an("c13355").dh("tid", d.this.ais).s("fid", d.this.mFid).ag("obj_type", d.this.air ? 1 : 2).ag("obj_locate", d.this.jGv ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hxD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.kwT.isPlaying()) {
                d.this.kwT.pause();
                if (d.this.kBC == d.this.kBv) {
                    d.this.AS(d.this.kBw);
                } else {
                    d.this.AS(d.this.kBx);
                }
                d.this.AT(R.id.video_pause);
            } else if (d.this.kBC == d.this.kBw || d.this.kBC == (d.this.kBw | 1)) {
                d.this.AS(d.this.kBv);
                d.this.cRD();
                d.this.kwT.b(d.this.kCk);
                d.this.AT(R.id.video_play);
            } else if (d.this.kBC == d.this.kBx || d.this.kBC == (d.this.kBx | 1)) {
                d.this.AS(d.this.kBt);
                d.this.kwT.b(d.this.kCk);
                d.this.AT(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.kwT.isPlaying()) {
                if (d.this.kBC == d.this.kBt || d.this.kBC == d.this.kBu) {
                    d.this.AS(d.this.kBv);
                    d.this.cRD();
                    return true;
                } else if (d.this.kBC == d.this.kBv) {
                    d.this.AS(d.this.kBt);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.kBC == d.this.kBw) {
                d.this.AS(d.this.kBx);
                return true;
            } else if (d.this.kBC == (d.this.kBw | 1)) {
                d.this.AS(d.this.kBx | 1);
                return true;
            } else if (d.this.kBC == d.this.kBx) {
                d.this.AS(d.this.kBw);
                return true;
            } else if (d.this.kBC == (d.this.kBx | 1)) {
                d.this.AS(d.this.kBw | 1);
                return true;
            } else {
                d.this.AS(d.this.kBs);
                d.this.startPlay();
                d.this.cRI();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kct = 0;
            if (d.this.jGv) {
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
            if (d.this.air && d.this.cLO()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.kct) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.kwT.isPlaying()) {
                                d.this.kwT.pause();
                                d.this.AS(d.this.kBB);
                            }
                            d.this.kct = 4;
                            d.this.kBD = d.this.kBC;
                            d.this.kBC = d.this.kBA;
                            d.this.kCc = d.this.kBS.getMeasuredHeight();
                            d.this.kCg = d.this.kBZ / d.this.kCc;
                            d.this.kCh = (int) (1.2f * d.this.mRootView.getWidth());
                            cJ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cJ(rawX, rawY);
                        break;
                }
            } else if (d.this.kBC == d.this.kBt || d.this.kBC == d.this.kBv || d.this.kBC == d.this.kBw || d.this.kBC == d.this.kBx || d.this.kBC == d.this.kBA || d.this.kBC == (d.this.kBw | 1) || d.this.kBC == (d.this.kBx | 1)) {
                switch (d.this.kct) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kct = 3;
                            d.this.kCa = d.this.kwT.getCurrentPosition();
                            ar(f);
                        } else if (motionEvent.getX() < d.this.kBS.getWidth() / 2) {
                            d.this.kct = 2;
                            d.this.kBP.q(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kct = 1;
                            d.this.kBP.p(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.kBC != d.this.kBA) {
                            if ((d.this.kBC & 1) > 0) {
                                d.this.kBA |= 1;
                            } else {
                                d.this.kBA &= -2;
                            }
                            d.this.AS(d.this.kBA);
                            break;
                        }
                        break;
                    case 1:
                        d.this.kBP.p(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cLS();
                            break;
                        }
                        break;
                    case 2:
                        d.this.kBP.q(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        ar(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cJ(int i, int i2) {
            if (d.this.kCe != i2 || d.this.kCf != i) {
                d.this.kCd = d.this.kCe - i2 > 0 || ((float) i2) < d.this.kBY / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.kBS.getLayoutParams();
                if (i2 != d.this.kCe) {
                    int i3 = d.this.kCc - i2;
                    int i4 = (int) (i3 * d.this.kCg);
                    if (i4 < d.this.kCh) {
                        i4 = d.this.kCh;
                        i3 = (int) (i4 / d.this.kCg);
                    }
                    if (i4 != d.this.kCh) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.kBS.setLayoutParams(layoutParams);
                    }
                    d.this.kCe = i2;
                    d.this.kBS.setTranslationY(d.this.kCe);
                }
                if (i != d.this.kCe) {
                    d.this.kCf = i;
                    d.this.kBS.setTranslationX(d.this.kCf + ((d.this.kBZ - layoutParams.width) / 2.0f));
                }
                d.this.kBQ.setAlpha((layoutParams.width - d.this.kCh) / (d.this.kBZ - d.this.kCh));
                if (d.this.kBM.getVisibility() == 0) {
                    float f = d.this.kBY / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.kBM.setAlpha(f2);
                }
            }
        }

        private void ar(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.kCa -= 1000;
                z = true;
            } else {
                d.this.kCa += 1000;
                z = false;
            }
            int duration = d.this.kwT.getDuration();
            if (d.this.kCa < 0) {
                d.this.kCa = 0;
            } else if (d.this.kCa > duration) {
                d.this.kCa = duration;
            }
            String str = aq.stringForVideoTime(d.this.kCa) + " / " + aq.stringForVideoTime(duration);
            if (d.this.kBP != null) {
                d.this.kBP.y(z, str);
            }
            d.this.kBK.setCurrentDuration(d.this.kCa, false);
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.kBC == d.this.kBA) {
                if (d.this.kct == 4) {
                    d.this.cRL();
                    d.this.kCe = 0;
                    d.this.kCf = 0;
                } else {
                    d.this.kBC = -1;
                    if (d.this.kct != 3) {
                        if (d.this.kBD != -1) {
                            d.this.AS(d.this.kBD);
                            d.this.kBD = -1;
                        } else if (d.this.kwT.isPlaying()) {
                            d.this.AS(d.this.kBt);
                        } else {
                            d.this.AS(d.this.kBw);
                        }
                    } else {
                        d.this.kBK.setCurrentDuration(d.this.kCa, true);
                        if (d.this.kCa <= d.this.kwT.getDuration()) {
                            if (!d.this.kwT.isPlaying()) {
                                d.this.kwT.b(d.this.kCk);
                            }
                            d.this.AS(d.this.kBt);
                        }
                    }
                }
                if (d.this.kBW) {
                    String str = null;
                    if (d.this.kct != 1) {
                        if (d.this.kct != 2) {
                            if (d.this.kct == 3) {
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
                d.this.kct = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a kCk = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cRu() {
            d.this.kwT.cQN();
            d.this.cRC();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cRv() {
            d.this.AS(d.this.kBs);
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
    private final CustomMessageListener kCl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ag.a(d.this.aio, true);
                    }
                    d.this.kwT.setVolume(1.0f, 1.0f);
                    d.this.kBI.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cLM();
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
            this.kBY = l.getEquipmentHeight(this.mContext);
            this.kBZ = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cLQ() {
        int dimension;
        int i;
        int i2;
        this.kBL.al(this.air, this.jGv);
        this.kBM.al(this.air, this.jGv);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.air) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.jGv) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ail.setPadding(0, 0, i2, 0);
            this.kBJ.setPadding(this.kBJ.getPaddingLeft(), 0, i, 0);
            this.kBI.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cLP() {
        if (this.air) {
            this.kBv = 104;
            this.kBw = 8290;
        } else {
            this.kBv = 232;
            this.kBw = 8418;
        }
        if (this.jGv) {
            this.kBs |= 1024;
            this.kBt |= 1024;
            this.kBu |= 1024;
            this.kBv |= 1024;
            this.kBw |= 1024;
            this.kBx |= 1024;
            this.kBy |= 1024;
            this.kBz |= 1024;
            this.kBC |= 1024;
            return;
        }
        this.kBs &= -1025;
        this.kBt &= -1025;
        this.kBu &= -1025;
        this.kBv &= -1025;
        this.kBw &= -1025;
        this.kBx &= -1025;
        this.kBy &= -1025;
        this.kBz &= -1025;
        this.kBC &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.kBS = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.kBS);
            }
            this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
            this.aii = (TbImageView) this.kBS.findViewById(R.id.video_thumbnail);
            this.kBF = this.kBS.findViewById(R.id.black_mask);
            this.kBG = (TBLottieAnimationView) this.kBS.findViewById(R.id.video_loading);
            this.aij = (ImageView) this.kBS.findViewById(R.id.video_play);
            this.kBH = (PercentSizeView) this.kBS.findViewById(R.id.video_media_controller_mask);
            this.aik = (ImageView) this.kBS.findViewById(R.id.video_pause);
            this.ail = (TextView) this.kBS.findViewById(R.id.video_play_count);
            this.aim = (TextView) this.kBS.findViewById(R.id.video_play_flag);
            this.ain = (TextView) this.kBS.findViewById(R.id.video_duration);
            this.kBI = (SwitchImageView) this.kBS.findViewById(R.id.video_mute);
            this.kBJ = (SwitchImageView) this.kBS.findViewById(R.id.video_full_screen);
            this.kBK = (OperableVideoMediaControllerView) this.kBS.findViewById(R.id.video_media_controller);
            this.kBL = (OperableVideoNetworkStateTipView) this.kBS.findViewById(R.id.video_network_state_tip);
            this.kBM = (OperableVideoShareView) this.kBS.findViewById(R.id.video_share_view);
            this.kBO = this.kBS.findViewById(R.id.video_back_btn_mask);
            this.kBN = (ImageView) this.kBS.findViewById(R.id.video_full_screen_back);
            this.kBP = (VideoGestureView) this.kBS.findViewById(R.id.video_gesture);
            this.kBR = (OperableVideoErrorView) this.kBS.findViewById(R.id.video_error_layout);
            this.kBM.setVideoContainer(this);
            this.kBV = new n(this.mContext);
            this.kBV.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cRN() && !d.this.air && !d.this.jGv && d.this.adG) {
                        if (!com.baidu.mcn.b.Lx().gg(d.this.kCi.jump_url)) {
                            boolean z = ((long) i2) >= d.this.kCi.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.kCi.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.kCi.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.hNQ.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.boJ = d.this.kCi.card_title;
                                    aVar.boK = d.this.kCi.button_title;
                                    aVar.boL = d.this.kCi.jump_url;
                                    aVar.boI = d.this.kCi.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.ais;
                                    aVar.boM = d.this.cgD();
                                    if (z2) {
                                        d.this.hNQ.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.hNQ.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.hNQ.isShowing()) {
                                d.this.hNQ.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.kCj != null) {
                        d.this.kCj.cj(i, i2);
                    }
                }
            });
            this.kBG.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kBG.setVisibility(8);
                    d.this.aij.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.kBG.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aUV().a(this.aij, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.aij.setOnClickListener(this);
            this.kBI.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.kBI.setState(1);
            this.kBI.setOnClickListener(this);
            this.aii.bhq();
            this.aii.setDrawCorner(false);
            this.aii.setPlaceHolder(3);
            this.kBK.setOnSeekBarChangeListener(this.eOU);
            this.kBH.setHeightPercent(0.583f);
            this.kBH.setBackgroundResource(R.drawable.video_mask_bg);
            this.kBJ.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.kBJ.setState(0);
            this.kBJ.setOnClickListener(this);
            SvgManager.aUV().a(this.aik, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.aik.setOnClickListener(this);
            this.kBN.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
            this.kwT = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
            this.kwT.setTryUseViewInSet(true);
            cRC();
            this.kBL.setPlayViewOnClickListener(this);
            this.kBS.setOnClickListener(null);
            this.kBS.setOnTouchListener(this.evw);
            this.kBM.setOnTouchListener(this.evw);
            this.kBR.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hxD);
            AS(this.kBs);
            this.hNQ = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cRC() {
        if (this.kwT != null && this.kwT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kBS.addView(this.kwT.getView(), 0);
            this.kwT.getView().setLayoutParams(layoutParams);
            this.kBK.setPlayer(this.kwT);
            if (cPS()) {
                ((QuickVideoView) this.kwT).setNeedRecovery(true);
            }
            this.kwT.setContinuePlayEnable(true);
            this.kwT.setBusiness(this.kBV);
            this.kwT.setOnPreparedListener(this);
            this.kwT.setOnCompletionListener(this);
            this.kwT.setOnErrorListener(this);
            this.kwT.setOnSurfaceDestroyedListener(this);
            this.kwT.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.aQQ() != null) {
            this.startPosition = -1L;
            if (this.hNQ != null) {
                this.hNQ.reset();
            }
            if (!aq.equals(this.mVideoUrl, bkVar.aQQ().video_url)) {
                stopPlay();
                this.air = bkVar.aQQ().is_vertical.intValue() == 1;
                this.mVideoUrl = bkVar.aQQ().video_url;
                this.ais = bkVar.getTid();
                this.ait = bkVar.aQQ().video_length.intValue();
                this.kBU = bkVar.aQQ().video_duration.intValue();
                this.mFid = bkVar.getFid();
                this.kCi = bkVar.aQQ().mcn_ad_card;
                cLP();
                cLQ();
                AS(this.kBs);
                int intValue = bkVar.aQQ().video_duration.intValue() * 1000;
                this.kBK.BL(intValue);
                this.kBK.setPlayer(this.kwT);
                this.ain.setText(aq.stringForVideoTime(intValue));
                this.ail.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bkVar.aQQ().play_count.intValue())));
                this.kBL.setVideoLength(bkVar.aQQ().video_length.intValue());
                this.kBL.setVideoDuration(bkVar.aQQ().video_duration.intValue());
                this.kBL.setTid(this.ais);
                this.kBV.cQV().an(bkVar);
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
                this.kBM.setShareData(bkVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.ahG = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.kBV != null) {
            this.kBV.setVideoStatsData(yVar);
            this.kwT.setBusiness(this.kBV);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cQV() {
        if (this.kBV == null) {
            return null;
        }
        return this.kBV.cQV();
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

    public void cRD() {
        e.ld().removeCallbacks(this.kBE);
        e.ld().postDelayed(this.kBE, this.kBd);
    }

    public void cRE() {
        e.ld().removeCallbacks(this.kBE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.kBG.setAlpha(1.0f);
        this.kBG.setVisibility(0);
        this.aij.setVisibility(8);
        if (this.kBG != null) {
            this.kBG.loop(true);
            this.kBG.setMinAndMaxFrame(14, 80);
            this.kBG.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cLN() {
        if (this.kBC == this.kBu) {
            AS(this.kBt);
        }
    }

    private void cRF() {
        AS(this.kBu);
        this.kBK.showProgress();
        if (this.kBG != null) {
            this.kBG.clearAnimation();
            this.kBG.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cLN();
                    if (!d.this.kBT) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.kBG.setVisibility(8);
                    d.this.aij.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cRG() {
        return this.kBL != null && this.kBL.cLX();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dyW);
            MessageManager.getInstance().registerListener(this.kCl);
            if (cRG()) {
                AS(this.kBz);
                return;
            }
            this.kBT = true;
            if (!this.kwT.isPlaying()) {
                com.baidu.tieba.play.a.a KB = TbVideoViewSet.cRt().KB(this.mVideoUrl);
                if (KB == null) {
                    this.kwT.cQN();
                    if (!StringUtils.isNull(this.kwT.getOriginUrl())) {
                        this.kwT = com.baidu.tieba.play.a.b.A(this.mContext, this.isNewPlayer ? 1 : 0);
                        this.kwT.setTryUseViewInSet(true);
                    }
                    cRC();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.kwT.setVideoDuration(this.kBU);
                        this.kwT.setVideoPath(this.mVideoUrl, this.ais);
                        startLoadingAnim();
                        if (this.kBW) {
                            cLV();
                        }
                    }
                } else {
                    if (this.kwT == KB) {
                        if (this.kwT.getParent() == null || this.kwT.getParent() != KB.getParent()) {
                            this.kwT.cQN();
                            cRC();
                        }
                    } else {
                        this.kwT.cQN();
                        KB.cQN();
                        this.kwT = KB;
                        this.kwT.setTryUseViewInSet(true);
                        cRC();
                    }
                    this.kwT.cQI();
                    onPrepared(null);
                    cRM();
                    if (this.kBW) {
                        cLV();
                    }
                }
                if (this.kBW) {
                    TiebaStatic.log(new an("c13357").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ag("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.kBT = false;
        if (this.kBG != null) {
            this.kBG.cancelAnimation();
        }
        this.kwT.stop();
        this.kwT.cQN();
        this.kBK.awd();
        AS(this.kBs);
        MessageManager.getInstance().unRegisterListener(this.dyW);
        MessageManager.getInstance().unRegisterListener(this.kCl);
    }

    private void cRH() {
        this.kBT = false;
        if (this.kBG != null) {
            this.kBG.cancelAnimation();
        }
        this.kwT.stop();
        this.kBK.awd();
        AS(this.kBs);
        MessageManager.getInstance().unRegisterListener(this.dyW);
        MessageManager.getInstance().unRegisterListener(this.kCl);
    }

    public void cLV() {
        if (this.kBV != null && this.kBV.cQY() != null) {
            y cRp = this.kBV.cQY().cRp();
            cRp.mLocate = this.mFrom;
            com.baidu.tieba.play.l.a(cRp.kAq, "", "1", cRp);
        }
    }

    public void AS(int i) {
        cRE();
        if (this.kBC == this.kBA) {
            this.kBD = i;
            return;
        }
        this.kBC = i;
        this.aii.setVisibility((i & 1) > 0 ? 0 : 8);
        this.kBF.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.kBG.clearAnimation();
        this.kBG.setVisibility(z ? 0 : 8);
        if (!z) {
            this.kBG.cancelAnimation();
        } else {
            this.kBG.setAlpha(1.0f);
        }
        this.aij.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.aik.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ail.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.air && (homePageStyleAbTest & 4) != 0) {
            this.aim.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.ain.setVisibility((i & 16) > 0 ? 0 : 8);
        this.kBI.setVisibility((i & 32) > 0 ? 0 : 8);
        this.kBJ.setVisibility((i & 64) > 0 ? 0 : 8);
        this.kBK.setVisibility((i & 128) > 0 ? 0 : 8);
        this.kBH.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.kBK.getVisibility() == 0) {
            this.kBK.showProgress();
        }
        this.kBL.setVisibility((i & 256) > 0 ? 0 : 8);
        this.kBM.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.kBM.getVisibility() == 0) {
            this.kBM.setAlpha(1.0f);
        }
        this.kBN.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kBO.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.kBP.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.kBR.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            AT(id);
            if (id == R.id.video_mute) {
                cRJ();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cRL();
            } else if (id == R.id.video_replay) {
                AS(this.kBs);
                startPlay();
                if (this.kBW) {
                    TiebaStatic.log(new an("c13345").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_locate", this.jGv ? 1 : 2));
                }
                cRI();
            } else if (id == R.id.video_play) {
                if (this.kBC == this.kBs) {
                    startPlay();
                } else {
                    AS(this.kBv);
                    cRD();
                    this.kwT.b(this.kCk);
                }
                if (this.kBW) {
                    TiebaStatic.log(new an("c13344").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_source", this.jGv ? 1 : 2).ag("obj_locate", 1));
                }
                cRI();
            } else if (id == R.id.video_pause) {
                AS(this.kBw);
                cRE();
                this.kwT.pause();
                if (this.kBW) {
                    TiebaStatic.log(new an("c13344").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2).ag("obj_source", this.jGv ? 1 : 2).ag("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                AS(this.kBs);
                startPlay();
            } else if (id == R.id.retry) {
                AS(this.kBs);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRI() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.afZ);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cLM() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.kwT.setVolume(0.0f, 0.0f);
            this.kBI.setState(1);
            return;
        }
        this.kwT.setVolume(1.0f, 1.0f);
        this.kBI.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cRJ() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.kwT.setVolume(1.0f, 1.0f);
            ag.a(this.aio, true);
            this.kBI.setState(0);
        } else {
            this.kwT.setVolume(0.0f, 0.0f);
            this.kBI.setState(1);
            ag.a(this.aio, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void ty(boolean z) {
        if (this.jaq == null) {
            this.jaq = new o((Activity) this.mContext);
        }
        if (z) {
            this.jaq.start();
            this.jaq.cc(true);
            return;
        }
        this.jaq.stop();
        this.jaq.cc(false);
    }

    public void cRK() {
        sI(true);
    }

    public void sI(boolean z) {
        if (this.mRootView != null && this.kBS != null && this.kwT != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.kwT.setFullScreenToDestroySurface();
            if (this.jaq == null) {
                this.jaq = new o((Activity) this.mContext);
            }
            if (this.jGv) {
                if (this.kBQ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kBQ.getParent()).removeView(this.kBQ);
                }
                if ((this.kBS.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.jGv = false;
                    this.kBX = true;
                    ((ViewGroup) this.kBS.getParent()).removeView(this.kBS);
                    ((ViewGroup) this.mRootView).addView(this.kBS);
                    this.kBX = false;
                    i((Activity) this.mContext, this.jGv);
                }
                if (!this.air && z) {
                    this.jaq.GV();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.air && z) {
                        this.jaq.GV();
                    }
                    if (this.mContext instanceof Activity) {
                        this.kBS.getLocationOnScreen(this.kCb);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.kBX = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.kBQ == null) {
                                    this.kBQ = new View(this.mContext);
                                    this.kBQ.setClickable(true);
                                    this.kBQ.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.kBQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.kBQ.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.kBQ.getParent()).removeView(this.kBQ);
                                }
                                this.kBQ.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.kBQ);
                                ((ViewGroup) childAt).addView(this.kBS);
                                this.kBX = false;
                                this.jGv = true;
                                i((Activity) this.mContext, this.jGv);
                                if (this.hNQ != null && this.hNQ.isShowing()) {
                                    this.hNQ.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.kBW) {
                    TiebaStatic.log(new an("c13360").dh("tid", this.ais).s("fid", this.mFid).ag("obj_type", this.air ? 1 : 2));
                }
            }
            cLP();
            cLQ();
            if (this.kwT.isPlaying()) {
                AS(this.kBt);
            } else {
                if (!this.isNewPlayer) {
                    this.kBC |= 1;
                }
                AS(this.kBC);
            }
            this.kBJ.dma();
            os(this.jGv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRL() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.air) {
            cRK();
        } else if (this.kBC == this.kBA) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.kBS.setScaleX(1.0f);
                    d.this.kBS.setScaleY(1.0f);
                    d.this.kBS.setTranslationX(0.0f);
                    d.this.kBS.setTranslationY(0.0f);
                    d.this.kBM.setScaleX(1.0f);
                    d.this.kBM.setScaleY(1.0f);
                    d.this.kBS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.kCd) {
                        d.this.cRK();
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
            if (!this.kCd) {
                float width = this.mRootView.getWidth() / this.kBS.getWidth();
                float height = this.mRootView.getHeight() / this.kBS.getHeight();
                this.kBS.setPivotX(0.0f);
                this.kBS.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kBS, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.kBS, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.kBM, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.kBM, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.kBS, "TranslationX", this.kBS.getTranslationX(), this.kCb[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.kBS, "TranslationY", this.kBS.getTranslationY(), this.kCb[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.kBQ, "alpha", this.kBQ.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kBM, "alpha", this.kBM.getAlpha(), 0.0f);
            } else {
                float width2 = this.kBZ / this.kBS.getWidth();
                float height2 = this.kCc / this.kBS.getHeight();
                this.kBS.setPivotX(0.0f);
                this.kBS.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.kBS, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.kBS, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.kBM, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.kBM, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.kBS, "TranslationX", this.kBS.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.kBS, "TranslationY", this.kBS.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.kBM, "alpha", this.kBM.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.kBD != -1) {
                this.kBC = this.kBD;
                this.kBD = -1;
                if (this.kBC == this.kBB || this.kBC == this.kBv || this.kBC == this.kBt) {
                    this.kwT.b(this.kCk);
                    AS(this.kBt);
                }
            }
        } else {
            cRK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.air && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.kBS != null) {
                    if (z) {
                        this.kBS.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.kBS.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                ctW();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.kBS.setSystemUiVisibility(0);
            }
        }
    }

    private void cRM() {
        AS(this.kBu);
        this.kBK.showProgress();
        cRF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void os(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cLM();
        if (this.kBT) {
            if (this.jGv && (this.mContext instanceof Activity)) {
                i((Activity) this.mContext, true);
            }
            this.kwT.b(this.kCk);
            if (cPS() && ((QuickVideoView) this.kwT).kyX) {
                cRF();
            }
        }
    }

    public void onCompletion(g gVar) {
        AS(this.kBy);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        AS(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.isNewPlayer && !this.kBX) {
            if (this.kBC == this.kBw || (this.kBC == this.kBx && !this.kwT.isPlaying())) {
                cRH();
                AS(this.kBw);
            } else if (this.kBC == this.kBy) {
                cRH();
                AS(this.kBy);
            } else {
                cRH();
            }
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cRM();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cQn() {
        return this.kBS;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.kBT || this.kwT.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.kwT.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void buU() {
    }

    protected void AT(int i) {
    }

    protected boolean J(MotionEvent motionEvent) {
        return this.jGv;
    }

    protected boolean cLO() {
        return this.air && this.jGv;
    }

    public boolean cPS() {
        return !this.isNewPlayer && (this.kwT instanceof QuickVideoView);
    }

    private void ctW() {
        if (Build.VERSION.SDK_INT < 16) {
            this.kBS.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.kBS.setSystemUiVisibility(4);
        } else {
            this.kBS.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cLS() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.kwT.isPlaying() && !ag.bgS()) {
            this.kwT.setVolume(1.0f, 1.0f);
            this.kBI.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cLT() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean or(boolean z) {
        if (z) {
            this.kBG.cancelAnimation();
            if (this.kBC == this.kBt || this.kBC == this.kBu || this.kBC == this.kBv || this.kBC == this.kBs) {
                stopPlay();
            }
            this.kBC |= 1;
            AS(this.kBC);
        } else if (this.kBC == this.kBs) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.jGv;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cRz() {
        if (this.jGv) {
            cRL();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cgD() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cRN() {
        return this.kCi != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tz(boolean z) {
        this.adG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.kCj = aVar;
    }
}
