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
    protected BdUniqueId Mh;
    protected boolean OB;
    protected String OC;
    protected long OD;
    protected long OE;
    protected TbImageView Os;
    private ImageView Ot;
    private ImageView Ou;
    private TextView Ov;
    private TextView Ow;
    private TextView Ox;
    private o dZX;
    private com.baidu.mcn.c gIr;
    protected com.baidu.tieba.play.a.a jpa;
    protected ImageView jtA;
    protected View jtB;
    protected VideoGestureView jtC;
    private View jtD;
    private OperableVideoErrorView jtE;
    protected ViewGroup jtF;
    protected boolean jtG;
    private n jtH;
    private float jtJ;
    private float jtK;
    private int jtL;
    private int jtN;
    private boolean jtO;
    private float jtR;
    private int jtS;
    private McnAdInfo jtT;
    private a jtU;
    private View jts;
    private TBLottieAnimationView jtt;
    private PercentSizeView jtu;
    protected SwitchImageView jtv;
    protected SwitchImageView jtw;
    protected OperableVideoMediaControllerView jtx;
    protected OperableVideoNetworkStateTipView jty;
    protected OperableVideoShareView jtz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int jsR = 3000;
    protected final int jsS = 1;
    protected final int jsT = 2;
    protected final int jsU = 4;
    protected final int jsV = 8;
    protected final int jsW = 16;
    protected final int jsX = 32;
    protected final int jsY = 64;
    protected final int jsZ = 128;
    protected final int jta = 256;
    protected final int jtb = 512;
    protected final int jtc = 1024;
    protected final int jtd = 2048;
    protected final int jte = 4096;
    protected final int jtf = 8192;
    protected int STATE_STOP = 8211;
    protected int jtg = 0;
    protected int jth = 4;
    protected int jti = 232;
    protected int STATE_PAUSE = 8416;
    protected int jtj = 0;
    protected int jtk = 513;
    protected int jtl = 259;
    protected int jtm = 2048;
    protected int jtn = 0;
    protected int STATE_ERROR = 4099;
    protected int jto = this.STATE_STOP;
    private int jtp = 0;
    private int jtq = -1;
    private Runnable jtr = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.zm(d.this.jtg);
        }
    };
    private WeakReference<Context> Oy = null;
    protected boolean iyq = false;
    private boolean isNewPlayer = false;
    protected boolean jtI = true;
    private int[] jtM = new int[2];
    private int jtP = 0;
    private int jtQ = 0;
    protected View.OnClickListener Mz = null;
    protected View.OnClickListener JC = null;
    private boolean JL = false;
    private long startPosition = -1;
    protected boolean NN = false;
    private TbImageView.c Nn = new TbImageView.c() { // from class: com.baidu.tieba.play.operableVideoView.d.7
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
                com.baidu.adp.widget.ImageView.a vb = com.baidu.tbadk.imageManager.c.aMZ().vb(com.baidu.adp.lib.e.c.gs().genCacheKey(tbImageView.getUrl(), 10));
                if (vb != null) {
                    int width = vb.getWidth();
                    i = vb.getHeight();
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
                        if (d.this.NN && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener dVL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.zm(d.this.jti);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.jpa.isPlaying()) {
                    d.this.jpa.b(d.this.jtW);
                }
                d.this.cwW();
                if (d.this.jtI) {
                    TiebaStatic.log(new an("c13355").cp("tid", d.this.OC).s("fid", d.this.mFid).Z("obj_type", d.this.OB ? 1 : 2).Z("obj_locate", d.this.iyq ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jtV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.jpa.isPlaying()) {
                d.this.jpa.pause();
                if (d.this.jto == d.this.jti) {
                    d.this.zm(d.this.STATE_PAUSE);
                } else {
                    d.this.zm(d.this.jtj);
                }
                d.this.zn(R.id.video_pause);
            } else if (d.this.jto == d.this.STATE_PAUSE || d.this.jto == (d.this.STATE_PAUSE | 1)) {
                d.this.zm(d.this.jti);
                d.this.cwW();
                d.this.jpa.b(d.this.jtW);
                d.this.zn(R.id.video_play);
            } else if (d.this.jto == d.this.jtj || d.this.jto == (d.this.jtj | 1)) {
                d.this.zm(d.this.jtg);
                d.this.jpa.b(d.this.jtW);
                d.this.zn(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.jpa.isPlaying()) {
                if (d.this.jto == d.this.jtg || d.this.jto == d.this.jth) {
                    d.this.zm(d.this.jti);
                    d.this.cwW();
                    return true;
                } else if (d.this.jto == d.this.jti) {
                    d.this.zm(d.this.jtg);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.jto == d.this.STATE_PAUSE) {
                d.this.zm(d.this.jtj);
                return true;
            } else if (d.this.jto == (d.this.STATE_PAUSE | 1)) {
                d.this.zm(d.this.jtj | 1);
                return true;
            } else if (d.this.jto == d.this.jtj) {
                d.this.zm(d.this.STATE_PAUSE);
                return true;
            } else if (d.this.jto == (d.this.jtj | 1)) {
                d.this.zm(d.this.STATE_PAUSE | 1);
                return true;
            } else {
                d.this.zm(d.this.STATE_STOP);
                d.this.startPlay();
                d.this.cwZ();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.jtp = 0;
            if (d.this.iyq) {
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
            if (d.this.OB && d.this.crl()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.jtp) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.jpa.isPlaying()) {
                                d.this.jpa.pause();
                                d.this.zm(d.this.jtn);
                            }
                            d.this.jtp = 4;
                            d.this.jtq = d.this.jto;
                            d.this.jto = d.this.jtm;
                            d.this.jtN = d.this.jtF.getMeasuredHeight();
                            d.this.jtR = d.this.jtK / d.this.jtN;
                            d.this.jtS = (int) (1.2f * d.this.mRootView.getWidth());
                            cx(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cx(rawX, rawY);
                        break;
                }
            } else if (d.this.jto == d.this.jtg || d.this.jto == d.this.jti || d.this.jto == d.this.STATE_PAUSE || d.this.jto == d.this.jtj || d.this.jto == d.this.jtm || d.this.jto == (d.this.STATE_PAUSE | 1) || d.this.jto == (d.this.jtj | 1)) {
                switch (d.this.jtp) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.jtp = 3;
                            d.this.jtL = d.this.jpa.getCurrentPosition();
                            aK(f);
                        } else if (motionEvent.getX() < d.this.jtF.getWidth() / 2) {
                            d.this.jtp = 2;
                            d.this.jtC.m(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.jtp = 1;
                            d.this.jtC.l(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.jto != d.this.jtm) {
                            if ((d.this.jto & 1) > 0) {
                                d.this.jtm |= 1;
                            } else {
                                d.this.jtm &= -2;
                            }
                            d.this.zm(d.this.jtm);
                            break;
                        }
                        break;
                    case 1:
                        d.this.jtC.l(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.crr();
                            break;
                        }
                        break;
                    case 2:
                        d.this.jtC.m(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aK(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cx(int i, int i2) {
            if (d.this.jtP != i2 || d.this.jtQ != i) {
                d.this.jtO = d.this.jtP - i2 > 0 || ((float) i2) < d.this.jtJ / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.jtF.getLayoutParams();
                if (i2 != d.this.jtP) {
                    int i3 = d.this.jtN - i2;
                    int i4 = (int) (i3 * d.this.jtR);
                    if (i4 < d.this.jtS) {
                        i4 = d.this.jtS;
                        i3 = (int) (i4 / d.this.jtR);
                    }
                    if (i4 != d.this.jtS) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.jtF.setLayoutParams(layoutParams);
                    }
                    d.this.jtP = i2;
                    d.this.jtF.setTranslationY(d.this.jtP);
                }
                if (i != d.this.jtP) {
                    d.this.jtQ = i;
                    d.this.jtF.setTranslationX(d.this.jtQ + ((d.this.jtK - layoutParams.width) / 2.0f));
                }
                d.this.jtD.setAlpha((layoutParams.width - d.this.jtS) / (d.this.jtK - d.this.jtS));
                if (d.this.jtz.getVisibility() == 0) {
                    float f = d.this.jtJ / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.jtz.setAlpha(f2);
                }
            }
        }

        private void aK(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.jtL -= 1000;
                z = true;
            } else {
                d.this.jtL += 1000;
                z = false;
            }
            int duration = d.this.jpa.getDuration();
            if (d.this.jtL < 0) {
                d.this.jtL = 0;
            } else if (d.this.jtL > duration) {
                d.this.jtL = duration;
            }
            String str = aq.stringForVideoTime(d.this.jtL) + " / " + aq.stringForVideoTime(duration);
            if (d.this.jtC != null) {
                d.this.jtC.x(z, str);
            }
            d.this.jtx.setCurrentDuration(d.this.jtL, false);
        }
    };
    private View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.12
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.jto == d.this.jtm) {
                if (d.this.jtp == 4) {
                    d.this.cxc();
                    d.this.jtP = 0;
                    d.this.jtQ = 0;
                } else {
                    d.this.jto = -1;
                    if (d.this.jtp != 3) {
                        if (d.this.jtq != -1) {
                            d.this.zm(d.this.jtq);
                            d.this.jtq = -1;
                        } else if (d.this.jpa.isPlaying()) {
                            d.this.zm(d.this.jtg);
                        } else {
                            d.this.zm(d.this.STATE_PAUSE);
                        }
                    } else {
                        d.this.jtx.setCurrentDuration(d.this.jtL, true);
                        if (d.this.jtL <= d.this.jpa.getDuration()) {
                            if (!d.this.jpa.isPlaying()) {
                                d.this.jpa.b(d.this.jtW);
                            }
                            d.this.zm(d.this.jtg);
                        }
                    }
                }
                if (d.this.jtI) {
                    String str = null;
                    if (d.this.jtp != 1) {
                        if (d.this.jtp != 2) {
                            if (d.this.jtp == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!aq.isEmpty(str)) {
                        TiebaStatic.log(new an(str).cp("tid", d.this.OC).s("fid", d.this.mFid));
                    }
                }
                d.this.jtp = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a jtW = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.2
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cwR() {
            d.this.jpa.cwm();
            d.this.cwV();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void cwS() {
            d.this.zm(d.this.STATE_STOP);
            d.this.startLoadingAnim();
        }
    };
    private final CustomMessageListener cHi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener jtX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        af.a(d.this.Oy, true);
                    }
                    d.this.jpa.setVolume(1.0f, 1.0f);
                    d.this.jtv.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.crj();
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
            this.jtJ = l.getEquipmentHeight(this.mContext);
            this.jtK = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void crp() {
        int dimension;
        int i;
        int i2;
        this.jty.af(this.OB, this.iyq);
        this.jtz.af(this.OB, this.iyq);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.OB) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.iyq) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.Ov.setPadding(0, 0, i2, 0);
            this.jtw.setPadding(this.jtw.getPaddingLeft(), 0, i, 0);
            this.jtv.setPadding(dimension, 0, 0, 0);
        }
    }

    public void cro() {
        if (this.OB) {
            this.jti = 104;
            this.STATE_PAUSE = 8290;
        } else {
            this.jti = 232;
            this.STATE_PAUSE = 8418;
        }
        if (this.iyq) {
            this.STATE_STOP |= 1024;
            this.jtg |= 1024;
            this.jth |= 1024;
            this.jti |= 1024;
            this.STATE_PAUSE |= 1024;
            this.jtj |= 1024;
            this.jtk |= 1024;
            this.jtl |= 1024;
            this.jto |= 1024;
            return;
        }
        this.STATE_STOP &= -1025;
        this.jtg &= -1025;
        this.jth &= -1025;
        this.jti &= -1025;
        this.STATE_PAUSE &= -1025;
        this.jtj &= -1025;
        this.jtk &= -1025;
        this.jtl &= -1025;
        this.jto &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.jtF = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.jtF);
            }
            this.Oy = new WeakReference<>(TbadkCoreApplication.getInst());
            this.Os = (TbImageView) this.jtF.findViewById(R.id.video_thumbnail);
            this.jts = this.jtF.findViewById(R.id.black_mask);
            this.jtt = (TBLottieAnimationView) this.jtF.findViewById(R.id.video_loading);
            this.Ot = (ImageView) this.jtF.findViewById(R.id.video_play);
            this.jtu = (PercentSizeView) this.jtF.findViewById(R.id.video_media_controller_mask);
            this.Ou = (ImageView) this.jtF.findViewById(R.id.video_pause);
            this.Ov = (TextView) this.jtF.findViewById(R.id.video_play_count);
            this.Ow = (TextView) this.jtF.findViewById(R.id.video_play_flag);
            this.Ox = (TextView) this.jtF.findViewById(R.id.video_duration);
            this.jtv = (SwitchImageView) this.jtF.findViewById(R.id.video_mute);
            this.jtw = (SwitchImageView) this.jtF.findViewById(R.id.video_full_screen);
            this.jtx = (OperableVideoMediaControllerView) this.jtF.findViewById(R.id.video_media_controller);
            this.jty = (OperableVideoNetworkStateTipView) this.jtF.findViewById(R.id.video_network_state_tip);
            this.jtz = (OperableVideoShareView) this.jtF.findViewById(R.id.video_share_view);
            this.jtB = this.jtF.findViewById(R.id.video_back_btn_mask);
            this.jtA = (ImageView) this.jtF.findViewById(R.id.video_full_screen_back);
            this.jtC = (VideoGestureView) this.jtF.findViewById(R.id.video_gesture);
            this.jtE = (OperableVideoErrorView) this.jtF.findViewById(R.id.video_error_layout);
            this.jtz.setVideoContainer(this);
            this.jtH = new n(this.mContext);
            this.jtH.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (d.this.startPosition <= 0) {
                        d.this.startPosition = i2;
                    }
                    if (d.this.cxe() && !d.this.OB && !d.this.iyq && d.this.JL) {
                        if (!com.baidu.mcn.b.AS().ej(d.this.jtT.jump_url)) {
                            boolean z = ((long) i2) >= d.this.jtT.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.jtT.ad_end_time.longValue() * 1000;
                            boolean z2 = d.this.startPosition >= (d.this.jtT.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!d.this.gIr.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aGm = d.this.jtT.card_title;
                                    aVar.aGn = d.this.jtT.button_title;
                                    aVar.aGo = d.this.jtT.jump_url;
                                    aVar.aGl = d.this.jtT.pic_url;
                                    aVar.fid = String.valueOf(d.this.mFid);
                                    aVar.tid = d.this.OC;
                                    aVar.aGp = d.this.bMz();
                                    if (z2) {
                                        d.this.gIr.b(aVar, (ViewGroup) d.this.mRootView);
                                    } else {
                                        d.this.gIr.a(aVar, (ViewGroup) d.this.mRootView);
                                    }
                                }
                            } else if (d.this.gIr.isShowing()) {
                                d.this.gIr.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (d.this.jtU != null) {
                        d.this.jtU.bX(i, i2);
                    }
                }
            });
            this.jtt.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jtt.setVisibility(8);
                    d.this.Ot.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jtt.setAnimation(R.raw.lotti_video_loading);
            SvgManager.aDW().a(this.Ot, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Ot.setOnClickListener(this);
            this.jtv.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.jtv.setState(1);
            this.jtv.setOnClickListener(this);
            this.Os.aQg();
            this.Os.setDrawCorner(false);
            this.Os.setPlaceHolder(3);
            this.jtx.setOnSeekBarChangeListener(this.dVL);
            this.jtu.setHeightPercent(0.583f);
            this.jtu.setBackgroundResource(R.drawable.video_mask_bg);
            this.jtw.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.jtw.setState(0);
            this.jtw.setOnClickListener(this);
            SvgManager.aDW().a(this.Ou, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.Ou.setOnClickListener(this);
            this.jtA.setOnClickListener(this);
            this.isNewPlayer = com.baidu.tbadk.a.b.rp("cyber_player_test");
            this.jpa = com.baidu.tieba.play.a.b.E(this.mContext, this.isNewPlayer ? 1 : 0);
            this.jpa.setTryUseViewInSet(true);
            cwV();
            this.jty.setPlayViewOnClickListener(this);
            this.jtF.setOnClickListener(null);
            this.jtF.setOnTouchListener(this.dne);
            this.jtz.setOnTouchListener(this.dne);
            this.jtE.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jtV);
            zm(this.STATE_STOP);
            this.gIr = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void cwV() {
        if (this.jpa != null && this.jpa.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jtF.addView(this.jpa.getView(), 0);
            this.jpa.getView().setLayoutParams(layoutParams);
            this.jtx.setPlayer(this.jpa);
            if (cvs()) {
                ((QuickVideoView) this.jpa).setNeedRecovery(true);
                ((QuickVideoView) this.jpa).setPlayerReuseEnable(true);
            }
            this.jpa.setContinuePlayEnable(true);
            this.jpa.setBusiness(this.jtH);
            this.jpa.setOnPreparedListener(this);
            this.jpa.setOnCompletionListener(this);
            this.jpa.setOnErrorListener(this);
            this.jpa.setOnOutInfoListener(this);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.azV() != null) {
            this.startPosition = -1L;
            if (this.gIr != null) {
                this.gIr.reset();
            }
            if (!aq.equals(this.mVideoUrl, bjVar.azV().video_url)) {
                stopPlay();
                this.OB = bjVar.azV().is_vertical.intValue() == 1;
                this.mVideoUrl = bjVar.azV().video_url;
                this.OC = bjVar.getTid();
                this.OD = bjVar.azV().video_length.intValue();
                this.OE = bjVar.azV().video_duration.intValue();
                this.mFid = bjVar.getFid();
                this.jtT = bjVar.azV().mcn_ad_card;
                cro();
                crp();
                zm(this.STATE_STOP);
                int intValue = bjVar.azV().video_duration.intValue() * 1000;
                this.jtx.Ae(intValue);
                this.jtx.setPlayer(this.jpa);
                this.Ox.setText(aq.stringForVideoTime(intValue));
                this.Ov.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bjVar.azV().play_count.intValue())));
                this.jty.setVideoLength(bjVar.azV().video_length.intValue());
                this.jty.setVideoDuration(bjVar.azV().video_duration.intValue());
                this.jty.setTid(this.OC);
                this.jtH.cwu().ah(bjVar);
                this.Ow.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bjVar.azV().wth_mid_loc != null && bjVar.azV().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.Os.setScaleType(ImageView.ScaleType.MATRIX);
                    this.Os.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.OB) {
                        this.Ox.setText("");
                        this.Ov.setText("");
                        this.Ow.setVisibility(0);
                    }
                    this.Os.setSmartCropCenterPointWidthRatio(bjVar.azV().wth_mid_loc.floatValue());
                    this.Os.setSmartCropCenterPointHeightRatio(bjVar.azV().hth_mid_loc.floatValue());
                    this.Os.setOnDrawListener(this.Nn);
                }
                this.Os.setPlaceHolder(3);
                this.Os.startLoad(bjVar.azV().thumbnail_url, 10, false);
                this.jtz.setShareData(bjVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.NN = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(y yVar) {
        if (yVar != null && this.jtH != null) {
            this.jtH.setVideoStatsData(yVar);
            this.jpa.setBusiness(this.jtH);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public u cwu() {
        if (this.jtH == null) {
            return null;
        }
        return this.jtH.cwu();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aa(View.OnClickListener onClickListener) {
        this.JC = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Mh = bdUniqueId;
    }

    public void cwW() {
        e.gy().removeCallbacks(this.jtr);
        e.gy().postDelayed(this.jtr, this.jsR);
    }

    public void cwX() {
        e.gy().removeCallbacks(this.jtr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        this.jtt.setAlpha(1.0f);
        this.jtt.setVisibility(0);
        this.Ot.setVisibility(8);
        if (this.jtt != null) {
            this.jtt.loop(true);
            this.jtt.setMinAndMaxFrame(14, 80);
            this.jtt.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crk() {
        if (this.jto == this.jth) {
            zm(this.jtg);
        }
    }

    private void cwY() {
        zm(this.jth);
        this.jtx.showProgress();
        if (this.jtt != null) {
            this.jtt.clearAnimation();
            this.jtt.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.crk();
                    if (!d.this.jtG) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.jtt.setVisibility(8);
                    d.this.Ot.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean crn() {
        return this.jty != null && this.jty.crv();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.cHi);
        MessageManager.getInstance().registerListener(this.jtX);
        if (crn()) {
            zm(this.jtl);
            return;
        }
        this.jtG = true;
        if (!this.jpa.isPlaying()) {
            com.baidu.tieba.play.a.a GG = TbVideoViewSet.cwQ().GG(this.mVideoUrl);
            if (GG == null) {
                this.jpa.cwm();
                if (!StringUtils.isNull(this.jpa.getOriginUrl())) {
                    this.jpa = com.baidu.tieba.play.a.b.E(this.mContext, this.isNewPlayer ? 1 : 0);
                    this.jpa.setTryUseViewInSet(true);
                }
                cwV();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    this.jpa.setVideoPath(this.mVideoUrl, this.OC);
                    startLoadingAnim();
                }
            } else {
                if (this.jpa == GG) {
                    if (this.jpa.getParent() == null || this.jpa.getParent() != GG.getParent()) {
                        this.jpa.cwm();
                        cwV();
                    }
                } else {
                    this.jpa.cwm();
                    GG.cwm();
                    this.jpa = GG;
                    this.jpa.setTryUseViewInSet(true);
                    cwV();
                }
                this.jpa.cwi();
                onPrepared(null);
                cxd();
            }
            if (this.jtI) {
                TiebaStatic.log(new an("c13357").cp("tid", this.OC).s("fid", this.mFid).Z("obj_type", this.OB ? 1 : 2).Z("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).Z("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.jtG = false;
        if (this.jtt != null) {
            this.jtt.cancelAnimation();
        }
        this.jpa.stop();
        this.jpa.cwm();
        this.jtx.ahA();
        zm(this.STATE_STOP);
        MessageManager.getInstance().unRegisterListener(this.cHi);
        MessageManager.getInstance().unRegisterListener(this.jtX);
    }

    public void zm(int i) {
        cwX();
        if (this.jto == this.jtm) {
            this.jtq = i;
            return;
        }
        this.jto = i;
        this.Os.setVisibility((i & 1) > 0 ? 0 : 8);
        this.jts.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.jtt.clearAnimation();
        this.jtt.setVisibility(z ? 0 : 8);
        if (!z) {
            this.jtt.cancelAnimation();
        } else {
            this.jtt.setAlpha(1.0f);
        }
        this.Ot.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.Ou.setVisibility((i & 8) > 0 ? 0 : 8);
        this.Ov.setVisibility((i & 16) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.OB && (homePageStyleAbTest & 4) != 0) {
            this.Ow.setVisibility((i & 16) > 0 ? 0 : 8);
        }
        this.Ox.setVisibility((i & 16) > 0 ? 0 : 8);
        this.jtv.setVisibility((i & 32) > 0 ? 0 : 8);
        this.jtw.setVisibility((i & 64) > 0 ? 0 : 8);
        this.jtx.setVisibility((i & 128) > 0 ? 0 : 8);
        this.jtu.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.jtx.getVisibility() == 0) {
            this.jtx.showProgress();
        }
        this.jty.setVisibility((i & 256) > 0 ? 0 : 8);
        this.jtz.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.jtz.getVisibility() == 0) {
            this.jtz.setAlpha(1.0f);
        }
        this.jtA.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jtB.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.jtC.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.jtE.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            zn(id);
            if (id == R.id.video_mute) {
                cxa();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cxc();
            } else if (id == R.id.video_replay) {
                zm(this.STATE_STOP);
                startPlay();
                if (this.jtI) {
                    TiebaStatic.log(new an("c13345").cp("tid", this.OC).s("fid", this.mFid).Z("obj_type", this.OB ? 1 : 2).Z("obj_locate", this.iyq ? 1 : 2));
                }
                cwZ();
            } else if (id == R.id.video_play) {
                if (this.jto == this.STATE_STOP) {
                    startPlay();
                } else {
                    zm(this.jti);
                    cwW();
                    this.jpa.b(this.jtW);
                }
                if (this.jtI) {
                    TiebaStatic.log(new an("c13344").cp("tid", this.OC).s("fid", this.mFid).Z("obj_type", this.OB ? 1 : 2).Z("obj_source", this.iyq ? 1 : 2).Z("obj_locate", 1));
                }
                cwZ();
            } else if (id == R.id.video_pause) {
                zm(this.STATE_PAUSE);
                cwX();
                this.jpa.pause();
                if (this.jtI) {
                    TiebaStatic.log(new an("c13344").cp("tid", this.OC).s("fid", this.mFid).Z("obj_type", this.OB ? 1 : 2).Z("obj_source", this.iyq ? 1 : 2).Z("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                zm(this.STATE_STOP);
                startPlay();
            } else if (id == R.id.retry) {
                zm(this.STATE_STOP);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwZ() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Mh);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void crj() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.jpa.setVolume(0.0f, 0.0f);
            this.jtv.setState(1);
            return;
        }
        this.jpa.setVolume(1.0f, 1.0f);
        this.jtv.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cxa() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.jpa.setVolume(1.0f, 1.0f);
            af.a(this.Oy, true);
            this.jtv.setState(0);
        } else {
            this.jpa.setVolume(0.0f, 0.0f);
            this.jtv.setState(1);
            af.a(this.Oy, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void rA(boolean z) {
        if (this.dZX == null) {
            this.dZX = new o((Activity) this.mContext);
        }
        if (z) {
            this.dZX.start();
            this.dZX.bb(true);
            return;
        }
        this.dZX.stop();
        this.dZX.bb(false);
    }

    public void cxb() {
        qI(true);
    }

    public void qI(boolean z) {
        if (this.mRootView != null && this.jtF != null && this.jpa != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            this.jpa.setFullScreenToDestroySurface();
            if (this.dZX == null) {
                this.dZX = new o((Activity) this.mContext);
            }
            if (this.iyq) {
                if (this.jtD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.jtD.getParent()).removeView(this.jtD);
                }
                if ((this.jtF.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.iyq = false;
                    ((ViewGroup) this.jtF.getParent()).removeView(this.jtF);
                    ((ViewGroup) this.mRootView).addView(this.jtF);
                    h((Activity) this.mContext, this.iyq);
                }
                if (!this.OB && z) {
                    this.dZX.xr();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.OB && z) {
                        this.dZX.xr();
                    }
                    if (this.mContext instanceof Activity) {
                        this.jtF.getLocationOnScreen(this.jtM);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.jtD == null) {
                                    this.jtD = new View(this.mContext);
                                    this.jtD.setClickable(true);
                                    this.jtD.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.jtD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.jtD.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.jtD.getParent()).removeView(this.jtD);
                                }
                                this.jtD.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.jtD);
                                ((ViewGroup) childAt).addView(this.jtF);
                                this.iyq = true;
                                h((Activity) this.mContext, this.iyq);
                                if (this.gIr != null && this.gIr.isShowing()) {
                                    this.gIr.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.jtI) {
                    TiebaStatic.log(new an("c13360").cp("tid", this.OC).s("fid", this.mFid).Z("obj_type", this.OB ? 1 : 2));
                }
            }
            cro();
            crp();
            if (this.jpa.isPlaying()) {
                zm(this.jtg);
            } else {
                this.jto |= 1;
                zm(this.jto);
            }
            this.jtw.cRa();
            mz(this.iyq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxc() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.OB) {
            cxb();
        } else if (this.jto == this.jtm) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.jtF.setScaleX(1.0f);
                    d.this.jtF.setScaleY(1.0f);
                    d.this.jtF.setTranslationX(0.0f);
                    d.this.jtF.setTranslationY(0.0f);
                    d.this.jtz.setScaleX(1.0f);
                    d.this.jtz.setScaleY(1.0f);
                    d.this.jtF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.jtO) {
                        d.this.cxb();
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
            if (!this.jtO) {
                float width = this.mRootView.getWidth() / this.jtF.getWidth();
                float height = this.mRootView.getHeight() / this.jtF.getHeight();
                this.jtF.setPivotX(0.0f);
                this.jtF.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jtF, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.jtF, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.jtz, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.jtz, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.jtF, "TranslationX", this.jtF.getTranslationX(), this.jtM[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.jtF, "TranslationY", this.jtF.getTranslationY(), this.jtM[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.jtD, "alpha", this.jtD.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jtz, "alpha", this.jtz.getAlpha(), 0.0f);
            } else {
                float width2 = this.jtK / this.jtF.getWidth();
                float height2 = this.jtN / this.jtF.getHeight();
                this.jtF.setPivotX(0.0f);
                this.jtF.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.jtF, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.jtF, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.jtz, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.jtz, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.jtF, "TranslationX", this.jtF.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.jtF, "TranslationY", this.jtF.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.jtz, "alpha", this.jtz.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.jtq != -1) {
                this.jto = this.jtq;
                this.jtq = -1;
                if (this.jto == this.jtn || this.jto == this.jti || this.jto == this.jtg) {
                    this.jpa.b(this.jtW);
                    zm(this.jtg);
                }
            }
        } else {
            cxb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.OB && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.jtF != null) {
                    if (z) {
                        this.jtF.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.jtF.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bZP();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.jtF.setSystemUiVisibility(0);
            }
        }
    }

    private void cxd() {
        zm(this.jth);
        this.jtx.showProgress();
        cwY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mz(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        crj();
        if (this.jtG) {
            if (this.iyq && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.jpa.b(this.jtW);
            if (cvs() && ((QuickVideoView) this.jpa).jqY) {
                cwY();
            }
        }
    }

    public void onCompletion(g gVar) {
        zm(this.jtk);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        zm(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.jto == this.STATE_PAUSE || (this.jto == this.jtj && !this.jpa.isPlaying())) {
            stopPlay();
            zm(this.STATE_PAUSE);
        } else if (this.jto == this.jtk) {
            stopPlay();
            zm(this.jtk);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            cxd();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cvN() {
        return this.jtF;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.jtG || this.jpa.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.jpa.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
        if ("index".equals(this.mFrom)) {
            this.jpa.setPageTypeForPerfStat("homepage");
        } else {
            this.jpa.setPageTypeForPerfStat(this.mFrom);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bdd() {
    }

    protected void zn(int i) {
    }

    protected boolean E(MotionEvent motionEvent) {
        return this.iyq;
    }

    protected boolean crl() {
        return this.OB && this.iyq;
    }

    public boolean cvs() {
        return !this.isNewPlayer && (this.jpa instanceof QuickVideoView);
    }

    private void bZP() {
        if (Build.VERSION.SDK_INT < 16) {
            this.jtF.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.jtF.setSystemUiVisibility(4);
        } else {
            this.jtF.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean crr() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.jpa.isPlaying() && !af.aPJ()) {
            this.jpa.setVolume(1.0f, 1.0f);
            this.jtv.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean crs() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean my(boolean z) {
        if (z) {
            this.jtt.cancelAnimation();
            if (this.jto == this.jtg || this.jto == this.jth || this.jto == this.jti || this.jto == this.STATE_STOP) {
                stopPlay();
            }
            this.jto |= 1;
            zm(this.jto);
        } else if (this.jto == this.STATE_STOP) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.iyq;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.iyq) {
            cxc();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int bMz() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cxe() {
        return this.jtT != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rB(boolean z) {
        this.JL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.jtU = aVar;
    }
}
