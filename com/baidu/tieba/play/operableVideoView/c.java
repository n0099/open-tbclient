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
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.SwitchImageView;
import com.coloros.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.play.operableVideoView.a {
    protected BdUniqueId Hx;
    protected String cmS;
    private String cmf;
    private o dqG;
    private TextView eOq;
    private TextView eOr;
    private com.baidu.mcn.c fUJ;
    protected TbImageView hgy;
    private int iAA;
    private int iAC;
    private boolean iAD;
    private float iAG;
    private int iAH;
    private McnAdInfo iAI;
    private a iAJ;
    private View iAd;
    private View iAe;
    private TBLottieAnimationView iAf;
    private ImageView iAg;
    private View iAh;
    private TextView iAi;
    private TextView iAj;
    protected SwitchImageView iAk;
    private SwitchImageView iAl;
    private OperableVideoMediaControllerView iAm;
    private OperableVideoNetworkStateTipView iAn;
    private OperableVideoShareView iAo;
    private ImageView iAp;
    private VideoGestureView iAq;
    private View iAr;
    protected ViewGroup iAs;
    protected boolean iAt;
    protected boolean iAu;
    protected long iAv;
    protected long iAw;
    private n iAx;
    private float iAy;
    private float iAz;
    protected com.baidu.tieba.play.a.a ivR;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int izP = 3000;
    protected int izQ = 103;
    protected int izR = 0;
    protected int izS = 4;
    protected int izT = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
    protected int izU = 902;
    protected int izV = 2066;
    protected int izW = 1027;
    protected int izX = CommandMessage.COMMAND_BASE;
    protected int izY = 0;
    protected int izZ = this.izQ;
    private int iAa = 0;
    private int iAb = -1;
    private Runnable iAc = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xK(c.this.izR);
        }
    };
    private WeakReference<Context> bUw = null;
    private boolean hKU = false;
    private boolean isNewPlayer = false;
    private int[] iAB = new int[2];
    private int iAE = 0;
    private int iAF = 0;
    protected View.OnClickListener cmo = null;
    private boolean FA = false;
    private long startPosition = -1;
    protected boolean IC = false;
    private TbImageView.b Id = new TbImageView.b() { // from class: com.baidu.tieba.play.operableVideoView.c.6
        @Override // com.baidu.tbadk.widget.TbImageView.b
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
                com.baidu.adp.widget.ImageView.a pY = com.baidu.tbadk.imageManager.c.avu().pY(com.baidu.adp.lib.f.c.fT().genCacheKey(tbImageView.getUrl(), 10));
                if (pY != null) {
                    int width = pY.getWidth();
                    i = pY.getHeight();
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
                        if (c.this.IC && i > i2) {
                            imageMatrix.postTranslate(f3, 0.0f);
                        } else {
                            imageMatrix.postTranslate(f3, f);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.b
        public void b(TbImageView tbImageView, Canvas canvas) {
        }
    };
    private SeekBar.OnSeekBarChangeListener diQ = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xK(c.this.izT);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.ivR.isPlaying()) {
                    c.this.ivR.start();
                }
                c.this.cdc();
                TiebaStatic.log(new an("c13355").bS("tid", c.this.cmS).p("fid", c.this.mFid).O("obj_type", c.this.iAu ? 1 : 2).O("obj_locate", c.this.hKU ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iAK = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.10
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.ivR.isPlaying()) {
                c.this.ivR.pause();
                c.this.xK(c.this.izU);
            } else if (c.this.izZ == c.this.izU || c.this.izZ == (c.this.izU | 1)) {
                c.this.ivR.start();
                c.this.xK(c.this.izT);
                c.this.cdc();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.izZ == c.this.izR || c.this.izZ == c.this.izS) {
                c.this.xK(c.this.izT);
                c.this.cdc();
            } else if (c.this.izZ == c.this.izT) {
                c.this.xK(c.this.izR);
            } else if (c.this.izZ == c.this.izU) {
                c.this.xK(c.this.izT);
                c.this.cdc();
                c.this.ivR.start();
                TiebaStatic.log(new an("c13344").bS("tid", c.this.cmS).p("fid", c.this.mFid).O("obj_type", c.this.iAu ? 1 : 2).O("obj_source", c.this.hKU ? 1 : 2).O("obj_locate", 1));
                c.this.cdf();
            } else {
                c.this.xK(c.this.izQ);
                c.this.startPlay();
                c.this.cdf();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.iAa = 0;
            if (c.this.hKU) {
                c.this.i((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hKU) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.iAu) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.iAa) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.ivR.isPlaying()) {
                                c.this.ivR.pause();
                                c.this.xK(c.this.izY);
                            }
                            c.this.iAa = 4;
                            c.this.iAb = c.this.izZ;
                            c.this.izZ = c.this.izX;
                            c.this.iAC = c.this.iAs.getMeasuredHeight();
                            c.this.iAG = c.this.iAz / c.this.iAC;
                            c.this.iAH = (int) (1.2f * c.this.mRootView.getWidth());
                            cf(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cf(rawX, rawY);
                        break;
                }
            } else if (c.this.izZ == c.this.izR || c.this.izZ == c.this.izT || c.this.izZ == c.this.izU || c.this.izZ == c.this.izX) {
                switch (c.this.iAa) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.iAa = 3;
                            c.this.iAA = c.this.ivR.getCurrentPosition();
                            at(f);
                        } else if (motionEvent.getX() < c.this.iAy / 2.0f) {
                            c.this.iAa = 2;
                            c.this.iAq.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.iAa = 1;
                            c.this.iAq.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.izZ != c.this.izX) {
                            c.this.xK(c.this.izX);
                            break;
                        }
                        break;
                    case 1:
                        c.this.iAq.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.ccX();
                            break;
                        }
                        break;
                    case 2:
                        c.this.iAq.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        at(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cf(int i, int i2) {
            if (c.this.iAE != i2 || c.this.iAF != i) {
                c.this.iAD = c.this.iAE - i2 > 0 || ((float) i2) < c.this.iAy / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.iAs.getLayoutParams();
                if (i2 != c.this.iAE) {
                    int i3 = c.this.iAC - i2;
                    int i4 = (int) (i3 * c.this.iAG);
                    if (i4 < c.this.iAH) {
                        i4 = c.this.iAH;
                        i3 = (int) (i4 / c.this.iAG);
                    }
                    if (i4 != c.this.iAH) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.iAs.setLayoutParams(layoutParams);
                    }
                    c.this.iAE = i2;
                    c.this.iAs.setTranslationY(c.this.iAE);
                }
                if (i != c.this.iAE) {
                    c.this.iAF = i;
                    c.this.iAs.setTranslationX(c.this.iAF + ((c.this.iAz - layoutParams.width) / 2.0f));
                }
                c.this.iAr.setAlpha((layoutParams.width - c.this.iAH) / (c.this.iAz - c.this.iAH));
                if (c.this.iAo.getVisibility() == 0) {
                    float f = c.this.iAy / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.iAo.setAlpha(f2);
                }
            }
        }

        private void at(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.iAA -= 1000;
                z = true;
            } else {
                c.this.iAA += 1000;
                z = false;
            }
            int duration = c.this.ivR.getDuration();
            if (c.this.iAA < 0) {
                c.this.iAA = 0;
            } else if (c.this.iAA > duration) {
                c.this.iAA = duration;
            }
            String str = aq.stringForVideoTime(c.this.iAA) + "/" + aq.stringForVideoTime(duration);
            if (c.this.iAq != null) {
                c.this.iAq.x(z, str);
            }
            c.this.iAm.setCurrentDuration(c.this.iAA, false);
        }
    };
    private View.OnTouchListener cAp = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.izZ == c.this.izX) {
                if (c.this.iAa == 4) {
                    c.this.cdj();
                    c.this.iAE = 0;
                    c.this.iAF = 0;
                } else {
                    c.this.izZ = -1;
                    if (c.this.iAa != 3) {
                        if (c.this.iAb != -1) {
                            c.this.xK(c.this.iAb);
                            c.this.iAb = -1;
                        } else if (c.this.ivR.isPlaying()) {
                            c.this.xK(c.this.izR);
                        } else {
                            c.this.xK(c.this.izU);
                        }
                    } else {
                        c.this.iAm.setCurrentDuration(c.this.iAA, true);
                        if (c.this.iAA < c.this.ivR.getDuration()) {
                            if (!c.this.ivR.isPlaying()) {
                                c.this.ivR.start();
                            }
                            c.this.xK(c.this.izR);
                        }
                    }
                }
                String str = null;
                if (c.this.iAa != 1) {
                    if (c.this.iAa != 2) {
                        if (c.this.iAa == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!aq.isEmpty(str)) {
                    TiebaStatic.log(new an(str).bS("tid", c.this.cmS).p("fid", c.this.mFid));
                }
                c.this.iAa = 0;
                return true;
            }
            return c.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private final CustomMessageListener bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                c.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener iAL = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cdg();
                    return;
                }
                if (c.this.isPlaying()) {
                    ac.a(c.this.bUw, true);
                }
                c.this.ivR.setVolume(1.0f, 1.0f);
                c.this.iAk.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bG(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.iAy = l.getEquipmentHeight(this.mContext);
            this.iAz = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ccY() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.iAn.ah(this.iAu, this.hKU);
        this.iAo.ah(this.iAu, this.hKU);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hKU) {
                int dimension3 = (int) this.mContext.getResources().getDimension(R.dimen.tbds112);
                dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i3 = (int) this.mContext.getResources().getDimension(R.dimen.tbds4);
                i2 = dimension2;
                i = dimension3;
                i5 = dimension2;
                i4 = dimension2;
            } else {
                int dimension4 = (int) this.mContext.getResources().getDimension(R.dimen.tbds97);
                int dimension5 = (int) this.mContext.getResources().getDimension(R.dimen.tbds32);
                if (this.iAu) {
                    dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds20);
                } else {
                    dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds32);
                }
                int dimension6 = (int) this.mContext.getResources().getDimension(R.dimen.tbds27);
                i = dimension4;
                i2 = dimension5;
                i3 = 0;
                int i6 = dimension;
                dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds38);
                i4 = dimension6;
                i5 = i6;
            }
            this.iAh.getLayoutParams().height = i;
            this.iAh.setPadding(0, 0, 0, i3);
            this.eOr.setPadding(0, 0, i2, 0);
            this.iAl.setPadding(this.iAl.getPaddingLeft(), 0, i5, 0);
            this.iAk.setPadding(i4, 0, this.iAk.getPaddingLeft(), 0);
            this.iAi.setPadding(dimension2, 0, this.iAk.getPaddingLeft(), 0);
        }
    }

    public void ccZ() {
        if (this.iAu) {
            this.izT = 392;
            this.izU = 390;
        } else {
            this.izT = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
            this.izU = 902;
        }
        if (this.hKU) {
            this.izQ |= 4096;
            this.izR |= 4096;
            this.izS |= 4096;
            this.izT |= 4096;
            this.izU |= 4096;
            this.izV |= 4096;
            this.izW |= 4096;
            this.izZ |= 4096;
            return;
        }
        this.izQ &= -4097;
        this.izR &= -4097;
        this.izS &= -4097;
        this.izT &= -4097;
        this.izU &= -4097;
        this.izV &= -4097;
        this.izW &= -4097;
        this.izZ &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.iAs = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.iAs);
            }
            this.bUw = new WeakReference<>(TbadkCoreApplication.getInst());
            this.isNewPlayer = com.baidu.tbadk.a.b.mb("cyber_player_test");
            this.ivR = com.baidu.tieba.play.a.b.x(this.mContext, this.isNewPlayer ? 1 : 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.iAs.addView(this.ivR.getView(), 0);
            this.ivR.getView().setLayoutParams(layoutParams);
            this.hgy = (TbImageView) this.iAs.findViewById(R.id.video_thumbnail);
            this.iAd = this.iAs.findViewById(R.id.black_mask_bottom);
            this.iAe = this.iAs.findViewById(R.id.black_mask_top);
            this.iAf = (TBLottieAnimationView) this.iAs.findViewById(R.id.video_play);
            this.iAh = this.iAs.findViewById(R.id.video_bottom_ctrl_layout);
            this.iAg = (ImageView) this.iAs.findViewById(R.id.video_pause);
            this.iAi = (TextView) this.iAs.findViewById(R.id.video_replay);
            this.eOr = (TextView) this.iAs.findViewById(R.id.video_play_count);
            this.iAj = (TextView) this.iAs.findViewById(R.id.video_play_flag);
            this.eOq = (TextView) this.iAs.findViewById(R.id.video_duration);
            this.iAk = (SwitchImageView) this.iAs.findViewById(R.id.video_mute);
            this.iAl = (SwitchImageView) this.iAs.findViewById(R.id.video_full_screen);
            this.iAm = (OperableVideoMediaControllerView) this.iAs.findViewById(R.id.video_media_controller);
            this.iAn = (OperableVideoNetworkStateTipView) this.iAs.findViewById(R.id.video_network_state_tip);
            this.iAo = (OperableVideoShareView) this.iAs.findViewById(R.id.video_share_view);
            this.iAp = (ImageView) this.iAs.findViewById(R.id.video_full_screen_back);
            this.iAq = (VideoGestureView) this.iAs.findViewById(R.id.video_gesture);
            this.iAo.setVideoContainer(this);
            this.iAx = new n(this.mContext);
            if (cbA()) {
                ((QuickVideoView) this.ivR).setNeedRecovery(true);
                ((QuickVideoView) this.ivR).setPlayerReuseEnable(true);
            }
            this.ivR.setContinuePlayEnable(true);
            this.iAx.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // com.baidu.tieba.play.j.b
                public void bj(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cdk() && !c.this.iAu && !c.this.hKU && c.this.FA) {
                        if (!com.baidu.mcn.b.zd().du(c.this.iAI.jump_url)) {
                            boolean z = ((long) i2) >= c.this.iAI.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.iAI.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.iAI.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fUJ.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.ayR = c.this.iAI.card_title;
                                    aVar.ayS = c.this.iAI.button_title;
                                    aVar.ayT = c.this.iAI.jump_url;
                                    aVar.ayQ = c.this.iAI.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.cmS;
                                    aVar.ayU = c.this.bvn();
                                    if (z2) {
                                        c.this.fUJ.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fUJ.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fUJ.isShowing()) {
                                c.this.fUJ.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.iAJ != null) {
                        c.this.iAJ.bG(i, i2);
                    }
                }
            });
            this.ivR.setBusiness(this.iAx);
            this.ivR.setOnPreparedListener(this);
            this.ivR.setOnCompletionListener(this);
            this.ivR.setOnErrorListener(this);
            this.ivR.setOnSurfaceDestroyedListener(this);
            this.ivR.setOnOutInfoListener(this);
            this.iAf.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.iAf.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.iAf.setAnimation(R.raw.lotti_video_loading);
            this.iAf.setOnClickListener(this);
            this.iAk.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.iAk.setState(1);
            this.iAk.setOnClickListener(this);
            this.hgy.setConrers(15);
            this.hgy.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
            this.hgy.setDrawCorner(true);
            this.hgy.setDefaultBgResource(e.Vl());
            this.iAm.setPlayer(this.ivR);
            this.iAm.setOnSeekBarChangeListener(this.diQ);
            this.iAl.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.iAl.setState(0);
            this.iAl.setOnClickListener(this);
            this.iAg.setOnClickListener(this);
            this.iAi.setOnClickListener(this);
            this.iAn.setPlayViewOnClickListener(this);
            this.iAp.setOnClickListener(this);
            this.iAs.setOnClickListener(null);
            this.iAs.setOnTouchListener(this.cAp);
            this.iAo.setOnTouchListener(this.cAp);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iAK);
            xK(this.izQ);
            this.fUJ = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aiX() != null) {
            stopPlay();
            this.startPosition = -1L;
            if (this.fUJ != null) {
                this.fUJ.reset();
            }
            if (!aq.equals(this.cmf, bhVar.aiX().video_url)) {
                this.iAu = bhVar.aiX().is_vertical.intValue() == 1;
                this.cmf = bhVar.aiX().video_url;
                this.cmS = bhVar.getTid();
                this.iAv = bhVar.aiX().video_length.intValue();
                this.iAw = bhVar.aiX().video_duration.intValue();
                this.mFid = bhVar.getFid();
                this.iAI = bhVar.aiX().mcn_ad_card;
                ccZ();
                ccY();
                xK(this.izQ);
                int intValue = bhVar.aiX().video_duration.intValue() * 1000;
                this.iAm.xI(intValue);
                this.iAm.setPlayer(this.ivR);
                this.eOq.setText(aq.stringForVideoTime(intValue));
                this.eOr.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bhVar.aiX().play_count.intValue())));
                this.iAn.setVideoLength(bhVar.aiX().video_length.intValue());
                this.iAn.setTid(this.cmS);
                this.iAx.ccy().g(bhVar.aiX());
                this.iAj.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bhVar.aiX().wth_mid_loc != null && bhVar.aiX().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.hgy.setScaleType(ImageView.ScaleType.MATRIX);
                    this.hgy.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.iAu) {
                        this.eOq.setText("");
                        this.eOr.setText("");
                        this.iAj.setVisibility(0);
                    }
                    this.hgy.setSmartCropCenterPointWidthRatio(bhVar.aiX().wth_mid_loc.floatValue());
                    this.hgy.setSmartCropCenterPointHeightRatio(bhVar.aiX().hth_mid_loc.floatValue());
                    this.hgy.setOnDrawListener(this.Id);
                }
                this.hgy.startLoad(bhVar.aiX().thumbnail_url, 10, false);
                this.iAo.setShareData(bhVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.IC = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(z zVar) {
        if (zVar != null && this.iAx != null) {
            this.iAx.setVideoStatsData(zVar);
            this.ivR.setBusiness(this.iAx);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v ccy() {
        if (this.iAx == null) {
            return null;
        }
        return this.iAx.ccy();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.cmo = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Hx = bdUniqueId;
    }

    public void cdc() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iAc);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iAc, this.izP);
    }

    public void cdd() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iAc);
    }

    private void startLoadingAnim() {
        if (this.iAf != null) {
            this.iAf.loop(true);
            this.iAf.setMinAndMaxFrame(14, 80);
            this.iAf.playAnimation();
        }
    }

    protected void cda() {
        if (this.izZ == this.izS) {
            xK(this.izR);
        }
    }

    private void cde() {
        if (this.iAf != null) {
            this.iAf.clearAnimation();
            this.iAf.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.cda();
                    if (c.this.iAt) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.iAf.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.bVI);
        MessageManager.getInstance().registerListener(this.iAL);
        if (this.iAn != null && this.iAn.cdl()) {
            xK(this.izW);
            return;
        }
        this.iAt = true;
        if (!this.ivR.isPlaying()) {
            this.ivR.setVideoPath(this.cmf, this.cmS);
            startLoadingAnim();
            TiebaStatic.log(new an("c13357").bS("tid", this.cmS).p("fid", this.mFid).O("obj_type", this.iAu ? 1 : 2).O("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).O("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.iAt = false;
        if (this.iAf != null) {
            this.iAf.cancelAnimation();
        }
        this.ivR.stopPlayback();
        this.iAm.aDT();
        xK(this.izQ);
        MessageManager.getInstance().unRegisterListener(this.bVI);
        MessageManager.getInstance().unRegisterListener(this.iAL);
    }

    public void xK(int i) {
        cdd();
        if (this.izZ == this.izX) {
            this.iAb = i;
            return;
        }
        this.izZ = i;
        this.hgy.setVisibility((i & 1) > 0 ? 0 : 8);
        this.iAd.setVisibility((i & 2) > 0 ? 0 : 8);
        this.iAe.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.iAf.clearAnimation();
        this.iAf.setVisibility(z ? 0 : 8);
        if (!z) {
            this.iAf.setFrame(0);
            this.iAf.cancelAnimation();
        } else {
            this.iAf.setAlpha(1.0f);
        }
        this.iAg.setVisibility((i & 8) > 0 ? 0 : 8);
        this.iAi.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eOr.setVisibility((i & 32) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.iAu && (homePageStyleAbTest & 4) != 0) {
            this.iAj.setVisibility((i & 32) > 0 ? 0 : 8);
        }
        this.eOq.setVisibility((i & 64) > 0 ? 0 : 8);
        this.iAk.setVisibility((i & 128) > 0 ? 0 : 8);
        this.iAl.setVisibility((i & 256) > 0 ? 0 : 8);
        this.iAm.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.iAm.getVisibility() == 0) {
            this.iAm.showProgress();
        }
        this.iAn.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.iAo.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.iAo.getVisibility() == 0) {
            this.iAo.setAlpha(1.0f);
        }
        this.iAp.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.iAq.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cdh();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cdj();
            } else if (id == R.id.video_replay) {
                xK(this.izQ);
                startPlay();
                TiebaStatic.log(new an("c13345").bS("tid", this.cmS).p("fid", this.mFid).O("obj_type", this.iAu ? 1 : 2).O("obj_locate", this.hKU ? 1 : 2));
                cdf();
            } else if (id == R.id.video_play) {
                if (this.izZ == this.izQ) {
                    startPlay();
                } else {
                    xK(this.izT);
                    cdc();
                    this.ivR.start();
                }
                TiebaStatic.log(new an("c13344").bS("tid", this.cmS).p("fid", this.mFid).O("obj_type", this.iAu ? 1 : 2).O("obj_source", this.hKU ? 1 : 2).O("obj_locate", 1));
                cdf();
            } else if (id == R.id.video_pause) {
                xK(this.izU);
                cdd();
                this.ivR.pause();
                TiebaStatic.log(new an("c13344").bS("tid", this.cmS).p("fid", this.mFid).O("obj_type", this.iAu ? 1 : 2).O("obj_source", this.hKU ? 1 : 2).O("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdf() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.cmf);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Hx);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdg() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.ivR.setVolume(0.0f, 0.0f);
            this.iAk.setState(1);
            return;
        }
        this.ivR.setVolume(1.0f, 1.0f);
        this.iAk.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdh() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.ivR.setVolume(1.0f, 1.0f);
            ac.a(this.bUw, true);
            this.iAk.setState(0);
        } else {
            this.ivR.setVolume(0.0f, 0.0f);
            this.iAk.setState(1);
            ac.a(this.bUw, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdi() {
        if (this.mRootView != null && this.iAs != null && this.ivR != null) {
            this.ivR.setFullScreenToDestroySurface();
            if (this.dqG == null) {
                this.dqG = new o((Activity) this.mContext);
            }
            if (this.hKU) {
                if (!this.iAu) {
                    this.dqG.vs();
                }
                if (this.iAr.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.iAr.getParent()).removeView(this.iAr);
                }
                if ((this.iAs.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hKU = false;
                    ((ViewGroup) this.iAs.getParent()).removeView(this.iAs);
                    ((ViewGroup) this.mRootView).addView(this.iAs);
                    i((Activity) this.mContext, this.hKU);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.iAu) {
                        this.dqG.vs();
                    }
                    if (this.mContext instanceof Activity) {
                        this.iAs.getLocationOnScreen(this.iAB);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.iAr == null) {
                                    this.iAr = new View(this.mContext);
                                    this.iAr.setClickable(true);
                                    this.iAr.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.iAr.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.iAr.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.iAr.getParent()).removeView(this.iAr);
                                }
                                this.iAr.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.iAr);
                                ((ViewGroup) childAt).addView(this.iAs);
                                this.hKU = true;
                                i((Activity) this.mContext, this.hKU);
                                if (this.fUJ != null && this.fUJ.isShowing()) {
                                    this.fUJ.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new an("c13360").bS("tid", this.cmS).p("fid", this.mFid).O("obj_type", this.iAu ? 1 : 2));
            }
            ccZ();
            ccY();
            if (this.ivR.isPlaying()) {
                xK(this.izR);
            } else {
                this.izZ |= 1;
                xK(this.izZ);
            }
            this.iAl.cwU();
            lm(this.hKU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdj() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.iAu) {
            cdi();
        } else if (this.izZ == this.izX) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.iAs.setScaleX(1.0f);
                    c.this.iAs.setScaleY(1.0f);
                    c.this.iAs.setTranslationX(0.0f);
                    c.this.iAs.setTranslationY(0.0f);
                    c.this.iAo.setScaleX(1.0f);
                    c.this.iAo.setScaleY(1.0f);
                    c.this.iAs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.iAD) {
                        c.this.cdi();
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
            if (!this.iAD) {
                float width = this.mRootView.getWidth() / this.iAs.getWidth();
                float height = this.mRootView.getHeight() / this.iAs.getHeight();
                this.iAs.setPivotX(0.0f);
                this.iAs.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.iAs, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.iAs, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.iAo, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.iAo, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.iAs, "TranslationX", this.iAs.getTranslationX(), this.iAB[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.iAs, "TranslationY", this.iAs.getTranslationY(), this.iAB[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.iAr, "alpha", this.iAr.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.iAo, "alpha", this.iAo.getAlpha(), 0.0f);
            } else {
                float width2 = this.iAz / this.iAs.getWidth();
                float height2 = this.iAC / this.iAs.getHeight();
                this.iAs.setPivotX(0.0f);
                this.iAs.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.iAs, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.iAs, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.iAo, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.iAo, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.iAs, "TranslationX", this.iAs.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.iAs, "TranslationY", this.iAs.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.iAo, "alpha", this.iAo.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.iAb != -1) {
                this.izZ = this.iAb;
                this.iAb = -1;
                if (this.izZ == this.izY || this.izZ == this.izT || this.izZ == this.izR) {
                    this.ivR.start();
                    xK(this.izR);
                }
            }
        } else {
            cdi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bID();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.iAs.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lm(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cdg();
        if (this.iAt) {
            if (this.hKU && (this.mContext instanceof Activity)) {
                i((Activity) this.mContext, true);
            }
            this.ivR.start();
        }
    }

    public void onCompletion(g gVar) {
        xK(this.izV);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.izZ == this.izU) {
            stopPlay();
            xK(this.izU);
        } else if (this.izZ == this.izV) {
            stopPlay();
            xK(this.izV);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            xK(this.izS);
            this.iAm.showProgress();
            cde();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cbX() {
        return this.iAs;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.iAt || this.ivR.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.ivR.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
        if ("index".equals(this.mFrom)) {
            this.ivR.setPageTypeForPerfStat("homepage");
        } else {
            this.ivR.setPageTypeForPerfStat(this.mFrom);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aLW() {
    }

    public boolean cbA() {
        return !this.isNewPlayer && (this.ivR instanceof QuickVideoView);
    }

    private void bID() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iAs.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iAs.setSystemUiVisibility(4);
        } else {
            this.iAs.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ccX() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.ivR.isPlaying() && !ac.axU()) {
            this.ivR.setVolume(1.0f, 1.0f);
            this.iAk.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean ll(boolean z) {
        if (z) {
            this.iAf.cancelAnimation();
            if (this.izZ == this.izR || this.izZ == this.izS || this.izZ == this.izT || this.izZ == this.izQ) {
                stopPlay();
            }
            this.izZ |= 1;
            xK(this.izZ);
        } else if (this.izZ == this.izQ) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hKU;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hKU) {
            cdj();
            return true;
        }
        return false;
    }

    protected int bvn() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cdk() {
        return this.iAI != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pS(boolean z) {
        this.FA = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.iAJ = aVar;
    }
}
