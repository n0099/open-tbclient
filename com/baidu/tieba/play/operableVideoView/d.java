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
    private com.baidu.mcn.c ihT;
    private j jAS;
    protected o leA;
    protected bv leB;
    private float leE;
    private float leF;
    private int leG;
    private int leI;
    private boolean leJ;
    private float leM;
    private int leN;
    private McnAdInfo leO;
    private a leP;
    private View lej;
    private TBLottieAnimationView lek;
    private PercentSizeView lel;
    protected SwitchImageView lem;
    protected SwitchImageView leo;
    protected OperableVideoMediaControllerView lep;
    protected OperableVideoNetworkStateTipView leq;
    protected OperableVideoShareView ler;
    protected ImageView les;
    protected View let;
    protected VideoGestureView leu;
    private View lev;
    private OperableVideoErrorView lew;
    protected ViewGroup lex;
    protected boolean ley;
    protected int lez;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int ldH = 3000;
    protected final int ldI = 1;
    protected final int ldJ = 2;
    protected final int ldK = 4;
    protected final int ldL = 8;
    protected final int ldM = 16;
    protected final int ldN = 32;
    protected final int ldO = 64;
    protected final int ldP = 128;
    protected final int ldQ = 256;
    protected final int ldR = 512;
    protected final int ldS = 1024;
    protected final int ldT = 2048;
    protected final int ldU = 4096;
    protected final int ldV = 8192;
    protected int ldW = 8211;
    protected int ldX = 0;
    protected int ldY = 4;
    protected int ldZ = 232;
    protected int lea = 8416;
    protected int leb = 0;
    protected int lec = 513;
    protected int led = 259;
    protected int lee = 2048;
    protected int lef = 0;
    protected int STATE_ERROR = 4099;
    protected int leg = this.ldW;
    private int kGi = 0;
    private int leh = -1;
    private Runnable lei = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Cw(d.this.ldX);
        }
    };
    private WeakReference<Context> ajF = null;
    protected boolean kjR = false;
    protected boolean leC = true;
    private boolean leD = false;
    private int[] leH = new int[2];
    private int leK = 0;
    private int leL = 0;
    protected View.OnClickListener ahn = null;
    protected View.OnClickListener adR = null;
    private boolean aea = false;
    private long startPosition = -1;
    private f.b leQ = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
        @Override // com.baidu.tieba.play.f.b
        public void bP(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.cZG() && !d.this.ajI && !d.this.kjR && d.this.aea) {
                if (!com.baidu.mcn.b.MN().gn(d.this.leO.jump_url)) {
                    boolean z = ((long) i2) >= d.this.leO.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.leO.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.leO.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.ihT.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bug = d.this.leO.card_title;
                            aVar.buh = d.this.leO.button_title;
                            aVar.bui = d.this.leO.jump_url;
                            aVar.bue = d.this.leO.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.ajJ;
                            aVar.buj = d.this.cnP();
                            if (z2) {
                                d.this.ihT.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.ihT.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.ihT.isShowing()) {
                        d.this.ihT.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.leP != null) {
                d.this.leP.cs(i, i2);
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
            d.this.Cw(d.this.ldZ);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.fsr.isPlaying()) {
                    d.this.fsr.a(d.this.leR);
                }
                d.this.cZw();
                if (d.this.leC) {
                    TiebaStatic.log(new ap("c13355").dn("tid", d.this.ajJ).t("fid", d.this.mFid).ah("obj_type", d.this.ajI ? 1 : 2).ah("obj_locate", d.this.kjR ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener hQN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.fsr.isPlaying()) {
                d.this.fsr.pause();
                if (d.this.leg == d.this.ldZ) {
                    d.this.Cw(d.this.lea);
                } else {
                    d.this.Cw(d.this.leb);
                }
                d.this.Cx(R.id.video_pause);
            } else if (d.this.leg == d.this.lea || d.this.leg == (d.this.lea | 1)) {
                d.this.Cw(d.this.ldZ);
                d.this.cZw();
                d.this.fsr.a(d.this.leR);
                d.this.Cx(R.id.video_play);
            } else if (d.this.leg == d.this.leb || d.this.leg == (d.this.leb | 1)) {
                d.this.Cw(d.this.ldX);
                d.this.fsr.a(d.this.leR);
                d.this.Cx(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.fsr.isPlaying()) {
                if (d.this.leg == d.this.ldX || d.this.leg == d.this.ldY) {
                    d.this.Cw(d.this.ldZ);
                    d.this.cZw();
                    return true;
                } else if (d.this.leg == d.this.ldZ) {
                    d.this.Cw(d.this.ldX);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.leg == d.this.lea) {
                d.this.Cw(d.this.leb);
                return true;
            } else if (d.this.leg == (d.this.lea | 1)) {
                d.this.Cw(d.this.leb | 1);
                return true;
            } else if (d.this.leg == d.this.leb) {
                d.this.Cw(d.this.lea);
                return true;
            } else if (d.this.leg == (d.this.leb | 1)) {
                d.this.Cw(d.this.lea | 1);
                return true;
            } else {
                d.this.Cw(d.this.ldW);
                d.this.startPlay();
                d.this.cZB();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kGi = 0;
            if (d.this.kjR) {
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
                switch (d.this.kGi) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.fsr.isPlaying()) {
                                d.this.fsr.pause();
                                d.this.Cw(d.this.lef);
                            }
                            d.this.kGi = 4;
                            d.this.leh = d.this.leg;
                            d.this.leg = d.this.lee;
                            d.this.leI = d.this.lex.getMeasuredHeight();
                            d.this.leM = d.this.leF / d.this.leI;
                            d.this.leN = (int) (1.2f * d.this.mRootView.getWidth());
                            cS(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cS(rawX, rawY);
                        break;
                }
            } else if (d.this.leg == d.this.ldX || d.this.leg == d.this.ldZ || d.this.leg == d.this.lea || d.this.leg == d.this.leb || d.this.leg == d.this.lee || d.this.leg == (d.this.lea | 1) || d.this.leg == (d.this.leb | 1)) {
                switch (d.this.kGi) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kGi = 3;
                            d.this.leG = d.this.fsr.getCurrentPosition();
                            av(f);
                        } else if (motionEvent.getX() < d.this.lex.getWidth() / 2) {
                            d.this.kGi = 2;
                            d.this.leu.r(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kGi = 1;
                            d.this.leu.q(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.leg != d.this.lee) {
                            if ((d.this.leg & 1) > 0) {
                                d.this.lee |= 1;
                            } else {
                                d.this.lee &= -2;
                            }
                            d.this.Cw(d.this.lee);
                            break;
                        }
                        break;
                    case 1:
                        d.this.leu.q(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.cUq();
                            break;
                        }
                        break;
                    case 2:
                        d.this.leu.r(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        av(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cS(int i, int i2) {
            if (d.this.leK != i2 || d.this.leL != i) {
                d.this.leJ = d.this.leK - i2 > 0 || ((float) i2) < d.this.leE / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.lex.getLayoutParams();
                if (i2 != d.this.leK) {
                    int i3 = d.this.leI - i2;
                    int i4 = (int) (i3 * d.this.leM);
                    if (i4 < d.this.leN) {
                        i4 = d.this.leN;
                        i3 = (int) (i4 / d.this.leM);
                    }
                    if (i4 != d.this.leN) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.lex.setLayoutParams(layoutParams);
                    }
                    d.this.leK = i2;
                    d.this.lex.setTranslationY(d.this.leK);
                }
                if (i != d.this.leK) {
                    d.this.leL = i;
                    d.this.lex.setTranslationX(d.this.leL + ((d.this.leF - layoutParams.width) / 2.0f));
                }
                d.this.lev.setAlpha((layoutParams.width - d.this.leN) / (d.this.leF - d.this.leN));
                if (d.this.ler.getVisibility() == 0) {
                    float f = d.this.leE / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.ler.setAlpha(f2);
                }
            }
        }

        private void av(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.leG -= 1000;
                z = true;
            } else {
                d.this.leG += 1000;
                z = false;
            }
            int duration = d.this.fsr.getDuration();
            if (d.this.leG < 0) {
                d.this.leG = 0;
            } else if (d.this.leG > duration) {
                d.this.leG = duration;
            }
            String str = as.stringForVideoTime(d.this.leG) + " / " + as.stringForVideoTime(duration);
            if (d.this.leu != null) {
                d.this.leu.A(z, str);
            }
            d.this.lep.setCurrentDuration(d.this.leG, false);
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.leg == d.this.lee) {
                if (d.this.kGi == 4) {
                    d.this.cZE();
                    d.this.leK = 0;
                    d.this.leL = 0;
                } else {
                    d.this.leg = -1;
                    if (d.this.kGi != 3) {
                        if (d.this.leh != -1) {
                            d.this.Cw(d.this.leh);
                            d.this.leh = -1;
                        } else if (d.this.fsr.isPlaying()) {
                            d.this.Cw(d.this.ldX);
                        } else {
                            d.this.Cw(d.this.lea);
                        }
                    } else {
                        d.this.lep.setCurrentDuration(d.this.leG, true);
                        if (d.this.leG <= d.this.fsr.getDuration()) {
                            if (!d.this.fsr.isPlaying()) {
                                d.this.fsr.a(d.this.leR);
                            }
                            d.this.Cw(d.this.ldX);
                        }
                    }
                }
                if (d.this.leC) {
                    String str = null;
                    if (d.this.kGi != 1) {
                        if (d.this.kGi != 2) {
                            if (d.this.kGi == 3) {
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
                d.this.kGi = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a leR = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cZo() {
            d.this.fsr.cZk();
            d.this.cZv();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cZp() {
            d.this.Cw(d.this.ldW);
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
    private final CustomMessageListener leS = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ag.a(d.this.ajF, true);
                    }
                    d.this.fsr.setVolume(1.0f, 1.0f);
                    d.this.lem.setState(0);
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
            this.leE = l.getEquipmentHeight(this.mContext);
            this.leF = l.getEquipmentWidth(this.mContext);
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
        this.leq.an(this.ajI, this.kjR);
        this.ler.an(this.ajI, this.kjR);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.ajI) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kjR) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.ajC.setPadding(0, 0, i2, 0);
            this.leo.setPadding(this.leo.getPaddingLeft(), 0, i, 0);
            this.lem.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cUn() {
        if (this.ajI) {
            this.ldZ = 104;
            this.lea = 8290;
        } else {
            this.ldZ = 232;
            this.lea = 8418;
        }
        if (this.kjR) {
            this.ldW |= 1024;
            this.ldX |= 1024;
            this.ldY |= 1024;
            this.ldZ |= 1024;
            this.lea |= 1024;
            this.leb |= 1024;
            this.lec |= 1024;
            this.led |= 1024;
            this.leg |= 1024;
            return;
        }
        this.ldW &= -1025;
        this.ldX &= -1025;
        this.ldY &= -1025;
        this.ldZ &= -1025;
        this.lea &= -1025;
        this.leb &= -1025;
        this.lec &= -1025;
        this.led &= -1025;
        this.leg &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.lex = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.lex);
            }
            this.ajF = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ajz = (TbImageView) this.lex.findViewById(R.id.video_thumbnail);
            this.lej = this.lex.findViewById(R.id.black_mask);
            this.lek = (TBLottieAnimationView) this.lex.findViewById(R.id.video_loading);
            this.ajA = (ImageView) this.lex.findViewById(R.id.video_play);
            this.lel = (PercentSizeView) this.lex.findViewById(R.id.video_media_controller_mask);
            this.ajB = (ImageView) this.lex.findViewById(R.id.video_pause);
            this.ajC = (TextView) this.lex.findViewById(R.id.video_play_count);
            this.ajD = (TextView) this.lex.findViewById(R.id.video_play_flag);
            this.ajE = (TextView) this.lex.findViewById(R.id.video_duration);
            this.lem = (SwitchImageView) this.lex.findViewById(R.id.video_mute);
            this.leo = (SwitchImageView) this.lex.findViewById(R.id.video_full_screen);
            this.lep = (OperableVideoMediaControllerView) this.lex.findViewById(R.id.video_media_controller);
            this.leq = (OperableVideoNetworkStateTipView) this.lex.findViewById(R.id.video_network_state_tip);
            this.ler = (OperableVideoShareView) this.lex.findViewById(R.id.video_share_view);
            this.let = this.lex.findViewById(R.id.video_back_btn_mask);
            this.les = (ImageView) this.lex.findViewById(R.id.video_full_screen_back);
            this.leu = (VideoGestureView) this.lex.findViewById(R.id.video_gesture);
            this.lew = (OperableVideoErrorView) this.lex.findViewById(R.id.video_error_layout);
            this.ler.setVideoContainer(this);
            this.lek.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lek.setVisibility(8);
                    d.this.ajA.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.lek.setAnimation(R.raw.lotti_video_loading);
            SvgManager.baR().a(this.ajA, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ajA.setOnClickListener(this);
            this.lem.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.lem.setState(1);
            this.lem.setOnClickListener(this);
            this.ajz.bny();
            this.ajz.setDrawCorner(false);
            this.ajz.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.lej, R.color.cp_mask_b_alpha50);
            this.lep.setOnSeekBarChangeListener(this.fdS);
            this.lel.setHeightPercent(0.583f);
            this.lel.setBackgroundResource(R.drawable.video_mask_bg);
            this.leo.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.leo.setState(0);
            this.leo.setOnClickListener(this);
            SvgManager.baR().a(this.ajB, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.ajB.setOnClickListener(this);
            this.les.setOnClickListener(this);
            this.fsr = new TbCyberVideoView(this.mContext);
            this.fsr.setTryUseViewInSet(true);
            cZv();
            this.leq.setPlayViewOnClickListener(this);
            this.lex.setOnClickListener(null);
            this.lex.setOnTouchListener(this.eKY);
            this.ler.setOnTouchListener(this.eKY);
            this.lew.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.hQN);
            Cw(this.ldW);
            this.ihT = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cZv() {
        if (this.fsr != null && this.fsr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.lex.addView(this.fsr.getView(), 0);
            this.fsr.getView().setLayoutParams(layoutParams);
            this.lep.setPlayer(this.fsr);
            this.fsr.setContinuePlayEnable(true);
            this.fsr.setOnPreparedListener(this);
            this.fsr.setOnCompletionListener(this);
            this.fsr.setOnErrorListener(this);
            this.fsr.setOnSurfaceDestroyedListener(this);
            this.fsr.setOnInfoListener(this);
            this.fsr.setVideoStatData(this.leA);
            this.fsr.setThreadDataForStatistic(this.leB);
            this.fsr.getMediaProgressObserver().a(this.leQ);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        if (bvVar != null && bvVar.aWD() != null) {
            this.startPosition = -1L;
            if (this.ihT != null) {
                this.ihT.reset();
            }
            if (!as.equals(this.mVideoUrl, bvVar.aWD().video_url)) {
                stopPlay();
                this.ajI = bvVar.aWD().is_vertical.intValue() == 1;
                this.mVideoUrl = bvVar.aWD().video_url;
                this.ajJ = bvVar.getTid();
                this.ajK = bvVar.aWD().video_length.intValue();
                this.lez = bvVar.aWD().video_duration.intValue();
                this.mFid = bvVar.getFid();
                this.leO = bvVar.aWD().mcn_ad_card;
                cUn();
                cUo();
                Cw(this.ldW);
                int intValue = bvVar.aWD().video_duration.intValue() * 1000;
                this.lep.Dn(intValue);
                this.lep.setPlayer(this.fsr);
                this.ajE.setText(as.stringForVideoTime(intValue));
                this.ajC.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), as.numFormatOverWan(bvVar.aWD().play_count.intValue())));
                this.leq.setVideoLength(bvVar.aWD().video_length.intValue());
                this.leq.setVideoDuration(bvVar.aWD().video_duration.intValue());
                this.leq.setTid(this.ajJ);
                this.leB = bvVar;
                this.fsr.setThreadDataForStatistic(bvVar);
                this.ajD.setVisibility(8);
                this.ajz.setPlaceHolder(3);
                this.ajz.startLoad(bvVar.aWD().thumbnail_url, 10, false);
                this.ler.setShareData(bvVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.fsr != null) {
            this.leA = oVar;
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
        e.lt().removeCallbacks(this.lei);
        e.lt().postDelayed(this.lei, this.ldH);
    }

    public void cZx() {
        e.lt().removeCallbacks(this.lei);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.lek.setAlpha(1.0f);
        this.lek.setVisibility(0);
        this.ajA.setVisibility(8);
        if (this.lek != null) {
            this.lek.loop(true);
            this.lek.setMinAndMaxFrame(14, 80);
            this.lek.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUl() {
        if (this.leg == this.ldY) {
            Cw(this.ldX);
        }
    }

    private void cZy() {
        Cw(this.ldY);
        this.lep.showProgress();
        if (this.lek != null) {
            this.lek.clearAnimation();
            this.lek.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.cUl();
                    if (!d.this.ley) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lek.setVisibility(8);
                    d.this.ajA.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean cZz() {
        return this.leq != null && this.leq.cUv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dLm);
            MessageManager.getInstance().registerListener(this.leS);
            if (cZz()) {
                Cw(this.led);
                return;
            }
            this.ley = true;
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
                        this.fsr.setVideoDuration(this.lez);
                        this.fsr.setVideoPath(this.mVideoUrl, this.ajJ);
                        startLoadingAnim();
                        if (this.leC) {
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
                    if (this.leC) {
                        cUt();
                    }
                }
                if (this.leC) {
                    TiebaStatic.log(new ap("c13357").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ah("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.ley = false;
        if (this.lek != null) {
            this.lek.cancelAnimation();
        }
        this.fsr.stop();
        this.fsr.cZk();
        this.lep.azZ();
        Cw(this.ldW);
        MessageManager.getInstance().unRegisterListener(this.dLm);
        MessageManager.getInstance().unRegisterListener(this.leS);
    }

    private void cZA() {
        this.ley = false;
        if (this.lek != null) {
            this.lek.cancelAnimation();
        }
        this.fsr.stop();
        this.lep.azZ();
        Cw(this.ldW);
        MessageManager.getInstance().unRegisterListener(this.dLm);
        MessageManager.getInstance().unRegisterListener(this.leS);
    }

    public void cUt() {
        if (this.leA != null) {
            o cZb = this.leA.cZb();
            cZb.mLocate = this.mFrom;
            h.a(cZb.lcO, "", "1", cZb, this.fsr.getPcdnState());
        }
    }

    public void Cw(int i) {
        cZx();
        if (this.leg == this.lee) {
            this.leh = i;
            return;
        }
        this.leg = i;
        this.ajz.setVisibility((i & 1) > 0 ? 0 : 8);
        this.lej.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.lek.clearAnimation();
        this.lek.setVisibility(z ? 0 : 8);
        if (!z) {
            this.lek.cancelAnimation();
        } else {
            this.lek.setAlpha(1.0f);
        }
        this.ajA.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.ajB.setVisibility((i & 8) > 0 ? 0 : 8);
        this.ajC.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ajE.setVisibility((i & 16) > 0 ? 0 : 8);
        this.lem.setVisibility((i & 32) > 0 ? 0 : 8);
        this.leo.setVisibility((i & 64) > 0 ? 0 : 8);
        this.lep.setVisibility((i & 128) > 0 ? 0 : 8);
        this.lel.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.lep.getVisibility() == 0) {
            this.lep.showProgress();
        }
        this.leq.setVisibility((i & 256) > 0 ? 0 : 8);
        this.ler.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.ler.getVisibility() == 0) {
            this.ler.setAlpha(1.0f);
        }
        this.les.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.let.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.leu.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.lew.setVisibility((i & 4096) <= 0 ? 8 : 0);
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
                Cw(this.ldW);
                startPlay();
                if (this.leC) {
                    TiebaStatic.log(new ap("c13345").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_locate", this.kjR ? 1 : 2));
                }
                cZB();
            } else if (id == R.id.video_play) {
                if (this.leg == this.ldW) {
                    startPlay();
                } else {
                    Cw(this.ldZ);
                    cZw();
                    this.fsr.a(this.leR);
                }
                if (this.leC) {
                    TiebaStatic.log(new ap("c13344").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_source", this.kjR ? 1 : 2).ah("obj_locate", 1));
                }
                cZB();
            } else if (id == R.id.video_pause) {
                Cw(this.lea);
                cZx();
                this.fsr.pause();
                if (this.leC) {
                    TiebaStatic.log(new ap("c13344").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2).ah("obj_source", this.kjR ? 1 : 2).ah("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Cw(this.ldW);
                startPlay();
            } else if (id == R.id.retry) {
                Cw(this.ldW);
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
            this.lem.setState(1);
            return;
        }
        this.fsr.setVolume(1.0f, 1.0f);
        this.lem.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cZC() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.fsr.setVolume(1.0f, 1.0f);
            ag.a(this.ajF, true);
            this.lem.setState(0);
        } else {
            this.fsr.setVolume(0.0f, 0.0f);
            this.lem.setState(1);
            ag.a(this.ajF, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void uq(boolean z) {
        if (this.jAS == null) {
            this.jAS = new j((Activity) this.mContext);
        }
        if (z) {
            this.jAS.start();
            this.jAS.cj(true);
            return;
        }
        this.jAS.stop();
        this.jAS.cj(false);
    }

    public void cZD() {
        tC(true);
    }

    public void tC(boolean z) {
        if (this.mRootView != null && this.lex != null && this.fsr != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.jAS == null) {
                this.jAS = new j((Activity) this.mContext);
            }
            if (this.kjR) {
                if (this.lev.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lev.getParent()).removeView(this.lev);
                }
                if ((this.lex.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kjR = false;
                    this.leD = true;
                    ((ViewGroup) this.lex.getParent()).removeView(this.lex);
                    ((ViewGroup) this.mRootView).addView(this.lex);
                    this.leD = false;
                    j((Activity) this.mContext, this.kjR);
                }
                if (!this.ajI && z) {
                    this.jAS.Io();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.ajI && z) {
                        this.jAS.Io();
                    }
                    if (this.mContext instanceof Activity) {
                        this.lex.getLocationOnScreen(this.leH);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.leD = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.lev == null) {
                                    this.lev = new View(this.mContext);
                                    this.lev.setClickable(true);
                                    this.lev.setBackgroundColor(ao.getColor(R.color.black_alpha100));
                                    this.lev.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.lev.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.lev.getParent()).removeView(this.lev);
                                }
                                this.lev.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.lev);
                                ((ViewGroup) childAt).addView(this.lex);
                                this.leD = false;
                                this.kjR = true;
                                j((Activity) this.mContext, this.kjR);
                                if (this.ihT != null && this.ihT.isShowing()) {
                                    this.ihT.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.leC) {
                    TiebaStatic.log(new ap("c13360").dn("tid", this.ajJ).t("fid", this.mFid).ah("obj_type", this.ajI ? 1 : 2));
                }
            }
            cUn();
            cUo();
            if (this.fsr.isPlaying()) {
                Cw(this.ldX);
            } else {
                Cw(this.leg);
            }
            this.leo.dtT();
            ur(this.kjR);
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
        } else if (this.leg == this.lee) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.lex.setScaleX(1.0f);
                    d.this.lex.setScaleY(1.0f);
                    d.this.lex.setTranslationX(0.0f);
                    d.this.lex.setTranslationY(0.0f);
                    d.this.ler.setScaleX(1.0f);
                    d.this.ler.setScaleY(1.0f);
                    d.this.lex.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.leJ) {
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
            if (!this.leJ) {
                float width = this.mRootView.getWidth() / this.lex.getWidth();
                float height = this.mRootView.getHeight() / this.lex.getHeight();
                this.lex.setPivotX(0.0f);
                this.lex.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lex, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.lex, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.ler, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.ler, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.lex, "TranslationX", this.lex.getTranslationX(), this.leH[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.lex, "TranslationY", this.lex.getTranslationY(), this.leH[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.lev, "alpha", this.lev.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.ler, "alpha", this.ler.getAlpha(), 0.0f);
            } else {
                float width2 = this.leF / this.lex.getWidth();
                float height2 = this.leI / this.lex.getHeight();
                this.lex.setPivotX(0.0f);
                this.lex.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lex, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.lex, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.ler, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.ler, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.lex, "TranslationX", this.lex.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.lex, "TranslationY", this.lex.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.ler, "alpha", this.ler.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.leh != -1) {
                this.leg = this.leh;
                this.leh = -1;
                if (this.leg == this.lef || this.leg == this.ldZ || this.leg == this.ldX) {
                    this.fsr.a(this.leR);
                    Cw(this.ldX);
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
                if (this.lex != null) {
                    if (z) {
                        this.lex.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.lex.setPadding(0, 0, 0, 0);
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
                this.lex.setSystemUiVisibility(0);
            }
        }
    }

    private void cZF() {
        Cw(this.ldY);
        this.lep.showProgress();
        cZy();
    }

    protected void ur(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        cUk();
        if (this.ley) {
            if (this.kjR && (this.mContext instanceof Activity)) {
                j((Activity) this.mContext, true);
            }
            this.fsr.a(this.leR);
        }
    }

    public void onCompletion() {
        Cw(this.lec);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Cw(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.leD) {
            if (this.leg == this.lea || (this.leg == this.leb && !this.fsr.isPlaying())) {
                cZA();
                Cw(this.lea);
            } else if (this.leg == this.lec) {
                cZA();
                Cw(this.lec);
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
        return this.lex;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.ley || this.fsr.isPlaying();
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
        return this.kjR;
    }

    protected boolean cUm() {
        return this.ajI && this.kjR;
    }

    private void cBT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.lex.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.lex.setSystemUiVisibility(4);
        } else {
            this.lex.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cUq() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.fsr.isPlaying() && !ag.bna()) {
            this.fsr.setVolume(1.0f, 1.0f);
            this.lem.setState(0);
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
            this.lek.cancelAnimation();
            if (this.leg == this.ldX || this.leg == this.ldY || this.leg == this.ldZ || this.leg == this.ldW) {
                stopPlay();
            }
            this.leg |= 1;
            Cw(this.leg);
        } else if (this.leg == this.ldW) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kjR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean cZt() {
        if (this.kjR) {
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
        return this.leO != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void us(boolean z) {
        this.aea = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.leP = aVar;
    }
}
