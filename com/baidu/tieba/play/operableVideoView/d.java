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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.play.operableVideoView.a {
    protected BdUniqueId agB;
    private ImageView ajA;
    private ImageView ajB;
    private TextView ajC;
    private TextView ajD;
    private TextView ajE;
    protected boolean ajI;
    protected String ajJ;
    protected long ajK;
    protected TbImageView ajz;
    protected TbCyberVideoView fsr;
    private com.baidu.mcn.c ihR;
    private j jAQ;
    private float leC;
    private float leD;
    private int leE;
    private int leG;
    private boolean leH;
    private float leK;
    private int leL;
    private McnAdInfo leM;
    private a leN;
    private View leh;
    private TBLottieAnimationView lei;
    private PercentSizeView lej;
    protected SwitchImageView lek;
    protected SwitchImageView lel;
    protected OperableVideoMediaControllerView lem;
    protected OperableVideoNetworkStateTipView leo;
    protected OperableVideoShareView lep;
    protected ImageView leq;
    protected View ler;
    protected VideoGestureView les;
    private View let;
    private OperableVideoErrorView leu;
    protected ViewGroup lev;
    protected boolean lew;
    protected int lex;
    protected o ley;
    protected bv lez;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int ldF = 3000;
    protected final int ldG = 1;
    protected final int ldH = 2;
    protected final int ldI = 4;
    protected final int ldJ = 8;
    protected final int ldK = 16;
    protected final int ldL = 32;
    protected final int ldM = 64;
    protected final int ldN = 128;
    protected final int ldO = 256;
    protected final int ldP = 512;
    protected final int ldQ = 1024;
    protected final int ldR = 2048;
    protected final int ldS = 4096;
    protected final int ldT = 8192;
    protected int ldU = 8211;
    protected int ldV = 0;
    protected int ldW = 4;
    protected int ldX = 232;
    protected int ldY = 8416;
    protected int ldZ = 0;
    protected int lea = 513;
    protected int leb = 259;
    protected int lec = 2048;
    protected int led = 0;
    protected int STATE_ERROR = 4099;
    protected int lee = this.ldU;
    private int kGg = 0;
    private int lef = -1;
    private Runnable leg = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Cw(d.this.ldV);
        }
    };
    private WeakReference<Context> ajF = null;
    protected boolean kjP = false;
    protected boolean leA = true;
    private boolean leB = false;
    private int[] leF = new int[2];
    private int leI = 0;
    private int leJ = 0;
    protected View.OnClickListener ahn = null;
    protected View.OnClickListener adR = null;
    private boolean aea = false;
    private long startPosition = -1;
    private f.b leO = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
        @Override // com.baidu.tieba.play.f.b
        public void bP(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.cZG() && !d.this.ajI && !d.this.kjP && d.this.aea) {
                if (!com.baidu.mcn.b.MN().gn(d.this.leM.jump_url)) {
                    boolean z = ((long) i2) >= d.this.leM.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.leM.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.leM.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.ihR.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bug = d.this.leM.card_title;
                            aVar.buh = d.this.leM.button_title;
                            aVar.bui = d.this.leM.jump_url;
                            aVar.bue = d.this.leM.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.ajJ;
                            aVar.buj = d.this.cnP();
                            if (z2) {
                                d.this.ihR.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.ihR.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.ihR.isShowing()) {
                        d.this.ihR.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.leN != null) {
                d.this.leN.cs(i, i2);
            }
        }
    };
    protected boolean aiI = false;
    private TbImageView.c aik = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a zV = com.baidu.tbadk.imageManager.c.bkk().zV(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), 10));
                if (zV != null) {
                    int width = zV.getWidth();
                    i = zV.getHeight();
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
                        if (d.this.aiI && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener fdS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Cw(d.this.ldX);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.fsr.isPlaying()) {
                    d.this.fsr.a(d.this.leP);
                }
                d.this.cZw();
                if (d.this.leA) {
                    TiebaStatic.log(new ap("c13355").dn("tid", d.this.ajJ).t("fid", d.this.mFid).ah("obj_type", d.this.ajI ? 1 : 2).ah("obj_locate", d.this.kjP ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hQL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.fsr.isPlaying()) {
                d.this.fsr.pause();
                if (d.this.lee == d.this.ldX) {
                    d.this.Cw(d.this.ldY);
                } else {
                    d.this.Cw(d.this.ldZ);
                }
                d.this.Cx(R.id.video_pause);
            } else if (d.this.lee == d.this.ldY || d.this.lee == (d.this.ldY | 1)) {
                d.this.Cw(d.this.ldX);
                d.this.cZw();
                d.this.fsr.a(d.this.leP);
                d.this.Cx(R.id.video_play);
            } else if (d.this.lee == d.this.ldZ || d.this.lee == (d.this.ldZ | 1)) {
                d.this.Cw(d.this.ldV);
                d.this.fsr.a(d.this.leP);
                d.this.Cx(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.fsr.isPlaying()) {
                if (d.this.lee == d.this.ldV || d.this.lee == d.this.ldW) {
                    d.this.Cw(d.this.ldX);
                    d.this.cZw();
                    return true;
                } else if (d.this.lee == d.this.ldX) {
                    d.this.Cw(d.this.ldV);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.lee == d.this.ldY) {
                d.this.Cw(d.this.ldZ);
                return true;
            } else if (d.this.lee == (d.this.ldY | 1)) {
                d.this.Cw(d.this.ldZ | 1);
                return true;
            } else if (d.this.lee == d.this.ldZ) {
                d.this.Cw(d.this.ldY);
                return true;
            } else if (d.this.lee == (d.this.ldZ | 1)) {
                d.this.Cw(d.this.ldY | 1);
                return true;
            } else {
                d.this.Cw(d.this.ldU);
                d.this.startPlay();
                d.this.cZB();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kGg = 0;
            if (d.this.kjP) {
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
            if (d.this.ajI && d.this.cUm()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.kGg) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.fsr.isPlaying()) {
                                d.this.fsr.pause();
                                d.this.Cw(d.this.led);
                            }
                            d.this.kGg = 4;
                            d.this.lef = d.this.lee;
                            d.this.lee = d.this.lec;
                            d.this.leG = d.this.lev.getMeasuredHeight();
                            d.this.leK = d.this.leD / d.this.leG;
                            d.this.leL = (int) (1.2f * d.this.mRootView.getWidth());
                            cS(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cS(rawX, rawY);
                        break;
                }
            } else if (d.this.lee == d.this.ldV || d.this.lee == d.this.ldX || d.this.lee == d.this.ldY || d.this.lee == d.this.ldZ || d.this.lee == d.this.lec || d.this.lee == (d.this.ldY | 1) || d.this.lee == (d.this.ldZ | 1)) {
                switch (d.this.kGg) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kGg = 3;
                            d.this.leE = d.this.fsr.getCurrentPosition();
                            av(f);
                        } else if (motionEvent.getX() < d.this.lev.getWidth() / 2) {
                            d.this.kGg = 2;
                            d.this.les.r(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kGg = 1;
                            d.this.les.q(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.lee != d.this.lec) {
                            if ((d.this.lee & 1) > 0) {
                                d.this.lec |= 1;
                            } else {
                                d.this.lec &= -2;
                            }
                            d.this.Cw(d.this.lec);
                            break;
                        }
                        break;
                    case 1:
                        d.this.les.q(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cUq();
                            break;
                        }
                        break;
                    case 2:
                        d.this.les.r(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        av(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cS(int i, int i2) {
            if (d.this.leI != i2 || d.this.leJ != i) {
                d.this.leH = d.this.leI - i2 > 0 || ((float) i2) < d.this.leC / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.lev.getLayoutParams();
                if (i2 != d.this.leI) {
                    int i3 = d.this.leG - i2;
                    int i4 = (int) (i3 * d.this.leK);
                    if (i4 < d.this.leL) {
                        i4 = d.this.leL;
                        i3 = (int) (i4 / d.this.leK);
                    }
                    if (i4 != d.this.leL) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.lev.setLayoutParams(layoutParams);
                    }
                    d.this.leI = i2;
                    d.this.lev.setTranslationY(d.this.leI);
                }
                if (i != d.this.leI) {
                    d.this.leJ = i;
                    d.this.lev.setTranslationX(d.this.leJ + ((d.this.leD - layoutParams.width) / 2.0f));
                }
                d.this.let.setAlpha((layoutParams.width - d.this.leL) / (d.this.leD - d.this.leL));
                if (d.this.lep.getVisibility() == 0) {
                    float f = d.this.leC / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.lep.setAlpha(f2);
                }
            }
        }

        private void av(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.leE -= 1000;
                z = true;
            } else {
                d.this.leE += 1000;
                z = false;
            }
            int duration = d.this.fsr.getDuration();
            if (d.this.leE < 0) {
                d.this.leE = 0;
            } else if (d.this.leE > duration) {
                d.this.leE = duration;
            }
            String str = as.stringForVideoTime(d.this.leE) + " / " + as.stringForVideoTime(duration);
            if (d.this.les != null) {
                d.this.les.A(z, str);
            }
            d.this.lem.setCurrentDuration(d.this.leE, false);
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.lee == d.this.lec) {
                if (d.this.kGg == 4) {
                    d.this.cZE();
                    d.this.leI = 0;
                    d.this.leJ = 0;
                } else {
                    d.this.lee = -1;
                    if (d.this.kGg != 3) {
                        if (d.this.lef != -1) {
                            d.this.Cw(d.this.lef);
                            d.this.lef = -1;
                        } else if (d.this.fsr.isPlaying()) {
                            d.this.Cw(d.this.ldV);
                        } else {
                            d.this.Cw(d.this.ldY);
                        }
                    } else {
                        d.this.lem.setCurrentDuration(d.this.leE, true);
                        if (d.this.leE <= d.this.fsr.getDuration()) {
                            if (!d.this.fsr.isPlaying()) {
                                d.this.fsr.a(d.this.leP);
                            }
                            d.this.Cw(d.this.ldV);
                        }
                    }
                }
                if (d.this.leA) {
                    String str = null;
                    if (d.this.kGg != 1) {
                        if (d.this.kGg != 2) {
                            if (d.this.kGg == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!as.isEmpty(str)) {
                        TiebaStatic.log(new ap(str).dn("tid", d.this.ajJ).t("fid", d.this.mFid));
                    }
                }
                d.this.kGg = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a leP = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cZo() {
            d.this.fsr.cZk();
            d.this.cZv();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cZp() {
            d.this.Cw(d.this.ldU);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener leQ = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ag.a(d.this.ajF, true);
                    }
                    d.this.fsr.setVolume(1.0f, 1.0f);
                    d.this.lek.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.cUk();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cs(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.leC = l.getEquipmentHeight(this.mContext);
            this.leD = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cUo() {
        int dimension;
        int i;
        int i2;
        this.leo.an(this.ajI, this.kjP);
        this.lep.an(this.ajI, this.kjP);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.ajI) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kjP) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ajC.setPadding(0, 0, i2, 0);
            this.lel.setPadding(this.lel.getPaddingLeft(), 0, i, 0);
            this.lek.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cUn() {
        if (this.ajI) {
            this.ldX = 104;
            this.ldY = 8290;
        } else {
            this.ldX = 232;
            this.ldY = 8418;
        }
        if (this.kjP) {
            this.ldU |= 1024;
            this.ldV |= 1024;
            this.ldW |= 1024;
            this.ldX |= 1024;
            this.ldY |= 1024;
            this.ldZ |= 1024;
            this.lea |= 1024;
            this.leb |= 1024;
            this.lee |= 1024;
            return;
        }
        this.ldU &= -1025;
        this.ldV &= -1025;
        this.ldW &= -1025;
        this.ldX &= -1025;
        this.ldY &= -1025;
        this.ldZ &= -1025;
        this.lea &= -1025;
        this.leb &= -1025;
        this.lee &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.lev = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.lev);
            }
            this.ajF = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ajz = (TbImageView) this.lev.findViewById(R.id.video_thumbnail);
            this.leh = this.lev.findViewById(R.id.black_mask);
            this.lei = (TBLottieAnimationView) this.lev.findViewById(R.id.video_loading);
            this.ajA = (ImageView) this.lev.findViewById(R.id.video_play);
            this.lej = (PercentSizeView) this.lev.findViewById(R.id.video_media_controller_mask);
            this.ajB = (ImageView) this.lev.findViewById(R.id.video_pause);
            this.ajC = (TextView) this.lev.findViewById(R.id.video_play_count);
            this.ajD = (TextView) this.lev.findViewById(R.id.video_play_flag);
            this.ajE = (TextView) this.lev.findViewById(R.id.video_duration);
            this.lek = (SwitchImageView) this.lev.findViewById(R.id.video_mute);
            this.lel = (SwitchImageView) this.lev.findViewById(R.id.video_full_screen);
            this.lem = (OperableVideoMediaControllerView) this.lev.findViewById(R.id.video_media_controller);
            this.leo = (OperableVideoNetworkStateTipView) this.lev.findViewById(R.id.video_network_state_tip);
            this.lep = (OperableVideoShareView) this.lev.findViewById(R.id.video_share_view);
            this.ler = this.lev.findViewById(R.id.video_back_btn_mask);
            this.leq = (ImageView) this.lev.findViewById(R.id.video_full_screen_back);
            this.les = (VideoGestureView) this.lev.findViewById(R.id.video_gesture);
            this.leu = (OperableVideoErrorView) this.lev.findViewById(R.id.video_error_layout);
            this.lep.setVideoContainer(this);
            this.lei.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lei.setVisibility(8);
                    d.this.ajA.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.lei.setAnimation(R.raw.lotti_video_loading);
            SvgManager.baR().a(this.ajA, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ajA.setOnClickListener(this);
            this.lek.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.lek.setState(1);
            this.lek.setOnClickListener(this);
            this.ajz.bny();
            this.ajz.setDrawCorner(false);
            this.ajz.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.leh, R.color.cp_mask_b_alpha50);
            this.lem.setOnSeekBarChangeListener(this.fdS);
            this.lej.setHeightPercent(0.583f);
            this.lej.setBackgroundResource(R.drawable.video_mask_bg);
            this.lel.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.lel.setState(0);
            this.lel.setOnClickListener(this);
            SvgManager.baR().a(this.ajB, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ajB.setOnClickListener(this);
            this.leq.setOnClickListener(this);
            this.fsr = new TbCyberVideoView(this.mContext);
            this.fsr.setTryUseViewInSet(true);
            cZv();
            this.leo.setPlayViewOnClickListener(this);
            this.lev.setOnClickListener(null);
            this.lev.setOnTouchListener(this.eKY);
            this.lep.setOnTouchListener(this.eKY);
            this.leu.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hQL);
            Cw(this.ldU);
            this.ihR = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cZv() {
        if (this.fsr != null && this.fsr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.lev.addView(this.fsr.getView(), 0);
            this.fsr.getView().setLayoutParams(layoutParams);
            this.lem.setPlayer(this.fsr);
            this.fsr.setContinuePlayEnable(true);
            this.fsr.setOnPreparedListener(this);
            this.fsr.setOnCompletionListener(this);
            this.fsr.setOnErrorListener(this);
            this.fsr.setOnSurfaceDestroyedListener(this);
            this.fsr.setOnInfoListener(this);
            this.fsr.setVideoStatData(this.ley);
            this.fsr.setThreadDataForStatistic(this.lez);
            this.fsr.getMediaProgressObserver().a(this.leO);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        if (bvVar != null && bvVar.aWD() != null) {
            this.startPosition = -1L;
            if (this.ihR != null) {
                this.ihR.reset();
            }
            if (!as.equals(this.mVideoUrl, bvVar.aWD().video_url)) {
                stopPlay();
                this.ajI = bvVar.aWD().is_vertical.intValue() == 1;
                this.mVideoUrl = bvVar.aWD().video_url;
                this.ajJ = bvVar.getTid();
                this.ajK = bvVar.aWD().video_length.intValue();
                this.lex = bvVar.aWD().video_duration.intValue();
                this.mFid = bvVar.getFid();
                this.leM = bvVar.aWD().mcn_ad_card;
                cUn();
                cUo();
                Cw(this.ldU);
                int intValue = bvVar.aWD().video_duration.intValue() * 1000;
                this.lem.Dn(intValue);
                this.lem.setPlayer(this.fsr);
                this.ajE.setText(as.stringForVideoTime(intValue));
                this.ajC.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), as.numFormatOverWan(bvVar.aWD().play_count.intValue())));
                this.leo.setVideoLength(bvVar.aWD().video_length.intValue());
                this.leo.setVideoDuration(bvVar.aWD().video_duration.intValue());
                this.leo.setTid(this.ajJ);
                this.lez = bvVar;
                this.fsr.setThreadDataForStatistic(bvVar);
                this.ajD.setVisibility(8);
                this.ajz.setPlaceHolder(3);
                this.ajz.startLoad(bvVar.aWD().thumbnail_url, 10, false);
                this.lep.setShareData(bvVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.fsr != null) {
            this.ley = oVar;
            this.fsr.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ab(View.OnClickListener onClickListener) {
        this.adR = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Dp(int i) {
        this.fsr.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agB = bdUniqueId;
    }

    public void cZw() {
        e.lt().removeCallbacks(this.leg);
        e.lt().postDelayed(this.leg, this.ldF);
    }

    public void cZx() {
        e.lt().removeCallbacks(this.leg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.lei.setAlpha(1.0f);
        this.lei.setVisibility(0);
        this.ajA.setVisibility(8);
        if (this.lei != null) {
            this.lei.loop(true);
            this.lei.setMinAndMaxFrame(14, 80);
            this.lei.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUl() {
        if (this.lee == this.ldW) {
            Cw(this.ldV);
        }
    }

    private void cZy() {
        Cw(this.ldW);
        this.lem.showProgress();
        if (this.lei != null) {
            this.lei.clearAnimation();
            this.lei.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cUl();
                    if (!d.this.lew) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lei.setVisibility(8);
                    d.this.ajA.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cZz() {
        return this.leo != null && this.leo.cUv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dLm);
            MessageManager.getInstance().registerListener(this.leQ);
            if (cZz()) {
                Cw(this.leb);
                return;
            }
            this.lew = true;
            if (!this.fsr.isPlaying()) {
                TbCyberVideoView LN = TbVideoViewSet.cZn().LN(this.mVideoUrl);
                if (LN == null) {
                    this.fsr.cZk();
                    if (!StringUtils.isNull(this.fsr.getOriginUrl())) {
                        this.fsr = new TbCyberVideoView(this.mContext);
                        this.fsr.setTryUseViewInSet(true);
                    }
                    cZv();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.fsr.setVideoDuration(this.lex);
                        this.fsr.setVideoPath(this.mVideoUrl, this.ajJ);
                        startLoadingAnim();
                        if (this.leA) {
                            cUt();
                        }
                    }
                } else {
                    if (this.fsr == LN) {
                        if (this.fsr.getParent() == null || this.fsr.getParent() != LN.getParent()) {
                            this.fsr.cZk();
                            cZv();
                        }
                    } else {
                        this.fsr.cZk();
                        LN.cZk();
                        this.fsr = LN;
                        this.fsr.setTryUseViewInSet(true);
                        cZv();
                    }
                    this.fsr.cZl();
                    onPrepared();
                    cZF();
                    if (this.leA) {
                        cUt();
                    }
                }
                if (this.leA) {
                    TiebaStatic.log(new ap("c13357").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ah("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.lew = false;
        if (this.lei != null) {
            this.lei.cancelAnimation();
        }
        this.fsr.stop();
        this.fsr.cZk();
        this.lem.azZ();
        Cw(this.ldU);
        MessageManager.getInstance().unRegisterListener(this.dLm);
        MessageManager.getInstance().unRegisterListener(this.leQ);
    }

    private void cZA() {
        this.lew = false;
        if (this.lei != null) {
            this.lei.cancelAnimation();
        }
        this.fsr.stop();
        this.lem.azZ();
        Cw(this.ldU);
        MessageManager.getInstance().unRegisterListener(this.dLm);
        MessageManager.getInstance().unRegisterListener(this.leQ);
    }

    public void cUt() {
        if (this.ley != null) {
            o cZb = this.ley.cZb();
            cZb.mLocate = this.mFrom;
            h.a(cZb.lcM, "", "1", cZb, this.fsr.getPcdnState());
        }
    }

    public void Cw(int i) {
        cZx();
        if (this.lee == this.lec) {
            this.lef = i;
            return;
        }
        this.lee = i;
        this.ajz.setVisibility((i & 1) > 0 ? 0 : 8);
        this.leh.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.lei.clearAnimation();
        this.lei.setVisibility(z ? 0 : 8);
        if (!z) {
            this.lei.cancelAnimation();
        } else {
            this.lei.setAlpha(1.0f);
        }
        this.ajA.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.ajB.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ajC.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ajE.setVisibility((i & 16) > 0 ? 0 : 8);
        this.lek.setVisibility((i & 32) > 0 ? 0 : 8);
        this.lel.setVisibility((i & 64) > 0 ? 0 : 8);
        this.lem.setVisibility((i & 128) > 0 ? 0 : 8);
        this.lej.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.lem.getVisibility() == 0) {
            this.lem.showProgress();
        }
        this.leo.setVisibility((i & 256) > 0 ? 0 : 8);
        this.lep.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.lep.getVisibility() == 0) {
            this.lep.setAlpha(1.0f);
        }
        this.leq.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.ler.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.les.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.leu.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Cx(id);
            if (id == R.id.video_mute) {
                cZC();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cZE();
            } else if (id == R.id.video_replay) {
                Cw(this.ldU);
                startPlay();
                if (this.leA) {
                    TiebaStatic.log(new ap("c13345").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_locate", this.kjP ? 1 : 2));
                }
                cZB();
            } else if (id == R.id.video_play) {
                if (this.lee == this.ldU) {
                    startPlay();
                } else {
                    Cw(this.ldX);
                    cZw();
                    this.fsr.a(this.leP);
                }
                if (this.leA) {
                    TiebaStatic.log(new ap("c13344").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_source", this.kjP ? 1 : 2).ah("obj_locate", 1));
                }
                cZB();
            } else if (id == R.id.video_pause) {
                Cw(this.ldY);
                cZx();
                this.fsr.pause();
                if (this.leA) {
                    TiebaStatic.log(new ap("c13344").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_source", this.kjP ? 1 : 2).ah("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Cw(this.ldU);
                startPlay();
            } else if (id == R.id.retry) {
                Cw(this.ldU);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZB() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.agB);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void cUk() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.fsr.setVolume(0.0f, 0.0f);
            this.lek.setState(1);
            return;
        }
        this.fsr.setVolume(1.0f, 1.0f);
        this.lek.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cZC() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.fsr.setVolume(1.0f, 1.0f);
            ag.a(this.ajF, true);
            this.lek.setState(0);
        } else {
            this.fsr.setVolume(0.0f, 0.0f);
            this.lek.setState(1);
            ag.a(this.ajF, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void uq(boolean z) {
        if (this.jAQ == null) {
            this.jAQ = new j((Activity) this.mContext);
        }
        if (z) {
            this.jAQ.start();
            this.jAQ.cj(true);
            return;
        }
        this.jAQ.stop();
        this.jAQ.cj(false);
    }

    public void cZD() {
        tC(true);
    }

    public void tC(boolean z) {
        if (this.mRootView != null && this.lev != null && this.fsr != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.jAQ == null) {
                this.jAQ = new j((Activity) this.mContext);
            }
            if (this.kjP) {
                if (this.let.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.let.getParent()).removeView(this.let);
                }
                if ((this.lev.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kjP = false;
                    this.leB = true;
                    ((ViewGroup) this.lev.getParent()).removeView(this.lev);
                    ((ViewGroup) this.mRootView).addView(this.lev);
                    this.leB = false;
                    j((Activity) this.mContext, this.kjP);
                }
                if (!this.ajI && z) {
                    this.jAQ.Io();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.ajI && z) {
                        this.jAQ.Io();
                    }
                    if (this.mContext instanceof Activity) {
                        this.lev.getLocationOnScreen(this.leF);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.leB = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.let == null) {
                                    this.let = new View(this.mContext);
                                    this.let.setClickable(true);
                                    this.let.setBackgroundColor(ao.getColor(R.color.black_alpha100));
                                    this.let.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.let.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.let.getParent()).removeView(this.let);
                                }
                                this.let.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.let);
                                ((ViewGroup) childAt).addView(this.lev);
                                this.leB = false;
                                this.kjP = true;
                                j((Activity) this.mContext, this.kjP);
                                if (this.ihR != null && this.ihR.isShowing()) {
                                    this.ihR.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.leA) {
                    TiebaStatic.log(new ap("c13360").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2));
                }
            }
            cUn();
            cUo();
            if (this.fsr.isPlaying()) {
                Cw(this.ldV);
            } else {
                Cw(this.lee);
            }
            this.lel.dtS();
            ur(this.kjP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZE() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.ajI) {
            cZD();
        } else if (this.lee == this.lec) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.lev.setScaleX(1.0f);
                    d.this.lev.setScaleY(1.0f);
                    d.this.lev.setTranslationX(0.0f);
                    d.this.lev.setTranslationY(0.0f);
                    d.this.lep.setScaleX(1.0f);
                    d.this.lep.setScaleY(1.0f);
                    d.this.lev.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.leH) {
                        d.this.cZD();
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
            if (!this.leH) {
                float width = this.mRootView.getWidth() / this.lev.getWidth();
                float height = this.mRootView.getHeight() / this.lev.getHeight();
                this.lev.setPivotX(0.0f);
                this.lev.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lev, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.lev, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.lep, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.lep, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.lev, "TranslationX", this.lev.getTranslationX(), this.leF[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.lev, "TranslationY", this.lev.getTranslationY(), this.leF[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.let, "alpha", this.let.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.lep, "alpha", this.lep.getAlpha(), 0.0f);
            } else {
                float width2 = this.leD / this.lev.getWidth();
                float height2 = this.leG / this.lev.getHeight();
                this.lev.setPivotX(0.0f);
                this.lev.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lev, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.lev, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.lep, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.lep, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.lev, "TranslationX", this.lev.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.lev, "TranslationY", this.lev.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.lep, "alpha", this.lep.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.lef != -1) {
                this.lee = this.lef;
                this.lef = -1;
                if (this.lee == this.led || this.lee == this.ldX || this.lee == this.ldV) {
                    this.fsr.a(this.leP);
                    Cw(this.ldV);
                }
            }
        } else {
            cZD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.ajI && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.lev != null) {
                    if (z) {
                        this.lev.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.lev.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cBT();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.lev.setSystemUiVisibility(0);
            }
        }
    }

    private void cZF() {
        Cw(this.ldW);
        this.lem.showProgress();
        cZy();
    }

    protected void ur(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        cUk();
        if (this.lew) {
            if (this.kjP && (this.mContext instanceof Activity)) {
                j((Activity) this.mContext, true);
            }
            this.fsr.a(this.leP);
        }
    }

    public void onCompletion() {
        Cw(this.lea);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Cw(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.leB) {
            if (this.lee == this.ldY || (this.lee == this.ldZ && !this.fsr.isPlaying())) {
                cZA();
                Cw(this.ldY);
            } else if (this.lee == this.lea) {
                cZA();
                Cw(this.lea);
            } else {
                cZA();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            cZF();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cYJ() {
        return this.lev;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.lew || this.fsr.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.fsr.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bBh() {
    }

    protected void Cx(int i) {
    }

    protected boolean J(MotionEvent motionEvent) {
        return this.kjP;
    }

    protected boolean cUm() {
        return this.ajI && this.kjP;
    }

    private void cBT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.lev.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.lev.setSystemUiVisibility(4);
        } else {
            this.lev.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cUq() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.fsr.isPlaying() && !ag.bna()) {
            this.fsr.setVolume(1.0f, 1.0f);
            this.lek.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean cUr() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean ph(boolean z) {
        if (z) {
            this.lei.cancelAnimation();
            if (this.lee == this.ldV || this.lee == this.ldW || this.lee == this.ldX || this.lee == this.ldU) {
                stopPlay();
            }
            this.lee |= 1;
            Cw(this.lee);
        } else if (this.lee == this.ldU) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kjP;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cZt() {
        if (this.kjP) {
            cZE();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cnP() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cZG() {
        return this.leM != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void us(boolean z) {
        this.aea = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.leN = aVar;
    }
}
