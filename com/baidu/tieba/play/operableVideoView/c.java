package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    protected BdUniqueId XD;
    protected String bXN;
    private String bXa;
    private o dhl;
    private TextView eFJ;
    private TextView eFK;
    private com.baidu.mcn.c fVp;
    protected TbImageView hiu;
    private View iBH;
    private View iBI;
    private TBLottieAnimationView iBJ;
    private ImageView iBK;
    private View iBL;
    private TextView iBM;
    private TextView iBN;
    protected SwitchImageView iBO;
    private SwitchImageView iBP;
    private OperableVideoMediaControllerView iBQ;
    private OperableVideoNetworkStateTipView iBR;
    private OperableVideoShareView iBS;
    private ImageView iBT;
    private VideoGestureView iBU;
    private View iBV;
    protected ViewGroup iBW;
    protected boolean iBX;
    protected boolean iBY;
    protected long iBZ;
    protected long iCa;
    private n iCb;
    private float iCc;
    private float iCd;
    private int iCe;
    private int iCg;
    private boolean iCh;
    private float iCk;
    private int iCl;
    private McnAdInfo iCm;
    private a iCn;
    protected com.baidu.tieba.play.a.a ixp;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int iBt = 3000;
    protected int iBu = 103;
    protected int iBv = 0;
    protected int iBw = 4;
    protected int iBx = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
    protected int iBy = 902;
    protected int iBz = 2066;
    protected int iBA = 1027;
    protected int iBB = CommandMessage.COMMAND_BASE;
    protected int iBC = 0;
    protected int iBD = this.iBu;
    private int iBE = 0;
    private int iBF = -1;
    private Runnable iBG = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.zf(c.this.iBv);
        }
    };
    private WeakReference<Context> bCb = null;
    private boolean hMq = false;
    private boolean isNewPlayer = false;
    private int[] iCf = new int[2];
    private int iCi = 0;
    private int iCj = 0;
    protected View.OnClickListener bXj = null;
    private boolean VL = false;
    private long startPosition = -1;
    protected boolean YG = false;
    private TbImageView.b mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.play.operableVideoView.c.6
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
                com.baidu.adp.widget.ImageView.a qS = com.baidu.tbadk.imageManager.c.atK().qS(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), 10));
                if (qS != null) {
                    int width = qS.getWidth();
                    i = qS.getHeight();
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
                        if (c.this.YG && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener cZr = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.zf(c.this.iBx);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.ixp.isPlaying()) {
                    c.this.ixp.start();
                }
                c.this.cgc();
                TiebaStatic.log(new an("c13355").bT("tid", c.this.bXN).n("fid", c.this.mFid).P("obj_type", c.this.iBY ? 1 : 2).P("obj_locate", c.this.hMq ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iCo = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.10
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.ixp.isPlaying()) {
                c.this.ixp.pause();
                c.this.zf(c.this.iBy);
            } else if (c.this.iBD == c.this.iBy || c.this.iBD == (c.this.iBy | 1)) {
                c.this.ixp.start();
                c.this.zf(c.this.iBx);
                c.this.cgc();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.iBD == c.this.iBv || c.this.iBD == c.this.iBw) {
                c.this.zf(c.this.iBx);
                c.this.cgc();
            } else if (c.this.iBD == c.this.iBx) {
                c.this.zf(c.this.iBv);
            } else if (c.this.iBD == c.this.iBy) {
                c.this.zf(c.this.iBx);
                c.this.cgc();
                c.this.ixp.start();
                TiebaStatic.log(new an("c13344").bT("tid", c.this.bXN).n("fid", c.this.mFid).P("obj_type", c.this.iBY ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hMq ? 1 : 2).P("obj_locate", 1));
                c.this.cgf();
            } else {
                c.this.zf(c.this.iBu);
                c.this.startPlay();
                c.this.cgf();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.iBE = 0;
            if (c.this.hMq) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hMq) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.iBY) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.iBE) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.ixp.isPlaying()) {
                                c.this.ixp.pause();
                                c.this.zf(c.this.iBC);
                            }
                            c.this.iBE = 4;
                            c.this.iBF = c.this.iBD;
                            c.this.iBD = c.this.iBB;
                            c.this.iCg = c.this.iBW.getMeasuredHeight();
                            c.this.iCk = c.this.iCd / c.this.iCg;
                            c.this.iCl = (int) (1.2f * c.this.mRootView.getWidth());
                            cm(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cm(rawX, rawY);
                        break;
                }
            } else if (c.this.iBD == c.this.iBv || c.this.iBD == c.this.iBx || c.this.iBD == c.this.iBy || c.this.iBD == c.this.iBB) {
                switch (c.this.iBE) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.iBE = 3;
                            c.this.iCe = c.this.ixp.getCurrentPosition();
                            aQ(f);
                        } else if (motionEvent.getX() < c.this.iCc / 2.0f) {
                            c.this.iBE = 2;
                            c.this.iBU.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.iBE = 1;
                            c.this.iBU.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.iBD != c.this.iBB) {
                            c.this.zf(c.this.iBB);
                            break;
                        }
                        break;
                    case 1:
                        c.this.iBU.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.cfX();
                            break;
                        }
                        break;
                    case 2:
                        c.this.iBU.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aQ(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cm(int i, int i2) {
            if (c.this.iCi != i2 || c.this.iCj != i) {
                c.this.iCh = c.this.iCi - i2 > 0 || ((float) i2) < c.this.iCc / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.iBW.getLayoutParams();
                if (i2 != c.this.iCi) {
                    int i3 = c.this.iCg - i2;
                    int i4 = (int) (i3 * c.this.iCk);
                    if (i4 < c.this.iCl) {
                        i4 = c.this.iCl;
                        i3 = (int) (i4 / c.this.iCk);
                    }
                    if (i4 != c.this.iCl) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.iBW.setLayoutParams(layoutParams);
                    }
                    c.this.iCi = i2;
                    c.this.iBW.setTranslationY(c.this.iCi);
                }
                if (i != c.this.iCi) {
                    c.this.iCj = i;
                    c.this.iBW.setTranslationX(c.this.iCj + ((c.this.iCd - layoutParams.width) / 2.0f));
                }
                c.this.iBV.setAlpha((layoutParams.width - c.this.iCl) / (c.this.iCd - c.this.iCl));
                if (c.this.iBS.getVisibility() == 0) {
                    float f = c.this.iCc / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.iBS.setAlpha(f2);
                }
            }
        }

        private void aQ(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.iCe += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.iCe += 1000;
                z = false;
            }
            int duration = c.this.ixp.getDuration();
            if (c.this.iCe < 0) {
                c.this.iCe = 0;
            } else if (c.this.iCe > duration) {
                c.this.iCe = duration;
            }
            String str = aq.it(c.this.iCe) + "/" + aq.it(duration);
            if (c.this.iBU != null) {
                c.this.iBU.x(z, str);
            }
            c.this.iBQ.setCurrentDuration(c.this.iCe, false);
        }
    };
    private View.OnTouchListener cnr = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.iBD == c.this.iBB) {
                if (c.this.iBE == 4) {
                    c.this.cgj();
                    c.this.iCi = 0;
                    c.this.iCj = 0;
                } else {
                    c.this.iBD = -1;
                    if (c.this.iBE != 3) {
                        if (c.this.iBF != -1) {
                            c.this.zf(c.this.iBF);
                            c.this.iBF = -1;
                        } else if (c.this.ixp.isPlaying()) {
                            c.this.zf(c.this.iBv);
                        } else {
                            c.this.zf(c.this.iBy);
                        }
                    } else {
                        c.this.iBQ.setCurrentDuration(c.this.iCe, true);
                        if (c.this.iCe < c.this.ixp.getDuration()) {
                            if (!c.this.ixp.isPlaying()) {
                                c.this.ixp.start();
                            }
                            c.this.zf(c.this.iBv);
                        }
                    }
                }
                String str = null;
                if (c.this.iBE != 1) {
                    if (c.this.iBE != 2) {
                        if (c.this.iBE == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!aq.isEmpty(str)) {
                    TiebaStatic.log(new an(str).bT("tid", c.this.bXN).n("fid", c.this.mFid));
                }
                c.this.iBE = 0;
                return true;
            }
            return c.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                c.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener iCp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cgg();
                    return;
                }
                if (c.this.isPlaying()) {
                    ac.a(c.this.bCb, true);
                }
                c.this.ixp.setVolume(1.0f, 1.0f);
                c.this.iBO.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bK(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.iCc = l.ah(this.mContext);
            this.iCd = l.af(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cfY() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.iBR.af(this.iBY, this.hMq);
        this.iBS.af(this.iBY, this.hMq);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hMq) {
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
                if (this.iBY) {
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
            this.iBL.getLayoutParams().height = i;
            this.iBL.setPadding(0, 0, 0, i3);
            this.eFK.setPadding(0, 0, i2, 0);
            this.iBP.setPadding(this.iBP.getPaddingLeft(), 0, i5, 0);
            this.iBO.setPadding(i4, 0, this.iBO.getPaddingLeft(), 0);
            this.iBM.setPadding(dimension2, 0, this.iBO.getPaddingLeft(), 0);
        }
    }

    public void cfZ() {
        if (this.iBY) {
            this.iBx = 392;
            this.iBy = 390;
        } else {
            this.iBx = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
            this.iBy = 902;
        }
        if (this.hMq) {
            this.iBu |= 4096;
            this.iBv |= 4096;
            this.iBw |= 4096;
            this.iBx |= 4096;
            this.iBy |= 4096;
            this.iBz |= 4096;
            this.iBA |= 4096;
            this.iBD |= 4096;
            return;
        }
        this.iBu &= -4097;
        this.iBv &= -4097;
        this.iBw &= -4097;
        this.iBx &= -4097;
        this.iBy &= -4097;
        this.iBz &= -4097;
        this.iBA &= -4097;
        this.iBD &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.iBW = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.iBW);
            }
            this.bCb = new WeakReference<>(TbadkCoreApplication.getInst());
            this.isNewPlayer = com.baidu.tbadk.a.b.ly("cyber_player_test");
            this.ixp = com.baidu.tieba.play.a.b.y(this.mContext, this.isNewPlayer ? 1 : 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.iBW.addView(this.ixp.getView(), 0);
            this.ixp.getView().setLayoutParams(layoutParams);
            this.hiu = (TbImageView) this.iBW.findViewById(R.id.video_thumbnail);
            this.iBH = this.iBW.findViewById(R.id.black_mask_bottom);
            this.iBI = this.iBW.findViewById(R.id.black_mask_top);
            this.iBJ = (TBLottieAnimationView) this.iBW.findViewById(R.id.video_play);
            this.iBL = this.iBW.findViewById(R.id.video_bottom_ctrl_layout);
            this.iBK = (ImageView) this.iBW.findViewById(R.id.video_pause);
            this.iBM = (TextView) this.iBW.findViewById(R.id.video_replay);
            this.eFK = (TextView) this.iBW.findViewById(R.id.video_play_count);
            this.iBN = (TextView) this.iBW.findViewById(R.id.video_play_flag);
            this.eFJ = (TextView) this.iBW.findViewById(R.id.video_duration);
            this.iBO = (SwitchImageView) this.iBW.findViewById(R.id.video_mute);
            this.iBP = (SwitchImageView) this.iBW.findViewById(R.id.video_full_screen);
            this.iBQ = (OperableVideoMediaControllerView) this.iBW.findViewById(R.id.video_media_controller);
            this.iBR = (OperableVideoNetworkStateTipView) this.iBW.findViewById(R.id.video_network_state_tip);
            this.iBS = (OperableVideoShareView) this.iBW.findViewById(R.id.video_share_view);
            this.iBT = (ImageView) this.iBW.findViewById(R.id.video_full_screen_back);
            this.iBU = (VideoGestureView) this.iBW.findViewById(R.id.video_gesture);
            this.iBS.setVideoContainer(this);
            this.iCb = new n(this.mContext);
            if (cey()) {
                ((QuickVideoView) this.ixp).setNeedRecovery(true);
                ((QuickVideoView) this.ixp).setPlayerReuseEnable(true);
            }
            this.ixp.setContinuePlayEnable(true);
            this.iCb.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cgk() && !c.this.iBY && !c.this.hMq && c.this.VL) {
                        if (!com.baidu.mcn.b.uj().cJ(c.this.iCm.jump_url)) {
                            boolean z = ((long) i2) >= c.this.iCm.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.iCm.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.iCm.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fVp.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aft = c.this.iCm.card_title;
                                    aVar.afu = c.this.iCm.button_title;
                                    aVar.afv = c.this.iCm.jump_url;
                                    aVar.afs = c.this.iCm.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.bXN;
                                    aVar.afw = c.this.byj();
                                    if (z2) {
                                        c.this.fVp.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fVp.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fVp.isShowing()) {
                                c.this.fVp.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.iCn != null) {
                        c.this.iCn.bK(i, i2);
                    }
                }
            });
            this.ixp.setBusiness(this.iCb);
            this.ixp.setOnPreparedListener(this);
            this.ixp.setOnCompletionListener(this);
            this.ixp.setOnErrorListener(this);
            this.ixp.setOnSurfaceDestroyedListener(this);
            this.ixp.setOnOutInfoListener(this);
            this.iBJ.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.iBJ.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.iBJ.setAnimation(R.raw.lotti_video_loading);
            this.iBJ.setOnClickListener(this);
            this.iBO.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.iBO.setState(1);
            this.iBO.setOnClickListener(this);
            this.hiu.setConrers(15);
            this.hiu.setRadius(l.g(this.mContext, R.dimen.tbds20));
            this.hiu.setDrawCorner(true);
            this.hiu.setDefaultBgResource(e.Qv());
            this.iBQ.setPlayer(this.ixp);
            this.iBQ.setOnSeekBarChangeListener(this.cZr);
            this.iBP.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.iBP.setState(0);
            this.iBP.setOnClickListener(this);
            this.iBK.setOnClickListener(this);
            this.iBM.setOnClickListener(this);
            this.iBR.setPlayViewOnClickListener(this);
            this.iBT.setOnClickListener(this);
            this.iBW.setOnClickListener(null);
            this.iBW.setOnTouchListener(this.cnr);
            this.iBS.setOnTouchListener(this.cnr);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iCo);
            zf(this.iBu);
            this.fVp = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aeT() != null) {
            stopPlay();
            this.startPosition = -1L;
            if (this.fVp != null) {
                this.fVp.reset();
            }
            if (!aq.bV(this.bXa, bhVar.aeT().video_url)) {
                this.iBY = bhVar.aeT().is_vertical.intValue() == 1;
                this.bXa = bhVar.aeT().video_url;
                this.bXN = bhVar.getTid();
                this.iBZ = bhVar.aeT().video_length.intValue();
                this.iCa = bhVar.aeT().video_duration.intValue();
                this.mFid = bhVar.getFid();
                this.iCm = bhVar.aeT().mcn_ad_card;
                cfZ();
                cfY();
                zf(this.iBu);
                int intValue = bhVar.aeT().video_duration.intValue() * 1000;
                this.iBQ.zd(intValue);
                this.iBQ.setPlayer(this.ixp);
                this.eFJ.setText(aq.it(intValue));
                this.eFK.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.aO(bhVar.aeT().play_count.intValue())));
                this.iBR.setVideoLength(bhVar.aeT().video_length.intValue());
                this.iBR.setTid(this.bXN);
                this.iCb.cfw().g(bhVar.aeT());
                this.iBN.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bhVar.aeT().wth_mid_loc != null && bhVar.aeT().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.hiu.setScaleType(ImageView.ScaleType.MATRIX);
                    this.hiu.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.iBY) {
                        this.eFJ.setText("");
                        this.eFK.setText("");
                        this.iBN.setVisibility(0);
                    }
                    this.hiu.setSmartCropCenterPointWidthRatio(bhVar.aeT().wth_mid_loc.floatValue());
                    this.hiu.setSmartCropCenterPointHeightRatio(bhVar.aeT().hth_mid_loc.floatValue());
                    this.hiu.setOnDrawListener(this.mOnDrawListener);
                }
                this.hiu.startLoad(bhVar.aeT().thumbnail_url, 10, false);
                this.iBS.setShareData(bhVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.YG = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(z zVar) {
        if (zVar != null && this.iCb != null) {
            this.iCb.setVideoStatsData(zVar);
            this.ixp.setBusiness(this.iCb);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v cfw() {
        if (this.iCb == null) {
            return null;
        }
        return this.iCb.cfw();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bXj = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.XD = bdUniqueId;
    }

    public void cgc() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iBG);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iBG, this.iBt);
    }

    public void cgd() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iBG);
    }

    private void startLoadingAnim() {
        if (this.iBJ != null) {
            this.iBJ.y(true);
            this.iBJ.setMinAndMaxFrame(14, 80);
            this.iBJ.br();
        }
    }

    protected void cga() {
        if (this.iBD == this.iBw) {
            zf(this.iBv);
        }
    }

    private void cge() {
        if (this.iBJ != null) {
            this.iBJ.clearAnimation();
            this.iBJ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.cga();
                    if (c.this.iBX) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.iBJ.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().registerListener(this.iCp);
        if (this.iBR != null && this.iBR.cgl()) {
            zf(this.iBA);
            return;
        }
        this.iBX = true;
        if (!this.ixp.isPlaying()) {
            this.ixp.setVideoPath(this.bXa, this.bXN);
            startLoadingAnim();
            TiebaStatic.log(new an("c13357").bT("tid", this.bXN).n("fid", this.mFid).P("obj_type", this.iBY ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).P("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.iBX = false;
        if (this.iBJ != null) {
            this.iBJ.cancelAnimation();
        }
        this.ixp.stopPlayback();
        this.iBQ.aDK();
        zf(this.iBu);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iCp);
    }

    public void zf(int i) {
        cgd();
        if (this.iBD == this.iBB) {
            this.iBF = i;
            return;
        }
        this.iBD = i;
        this.hiu.setVisibility((i & 1) > 0 ? 0 : 8);
        this.iBH.setVisibility((i & 2) > 0 ? 0 : 8);
        this.iBI.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.iBJ.clearAnimation();
        this.iBJ.setVisibility(z ? 0 : 8);
        if (!z) {
            this.iBJ.setFrame(0);
            this.iBJ.cancelAnimation();
        } else {
            this.iBJ.setAlpha(1.0f);
        }
        this.iBK.setVisibility((i & 8) > 0 ? 0 : 8);
        this.iBM.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eFK.setVisibility((i & 32) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.iBY && (homePageStyleAbTest & 4) != 0) {
            this.iBN.setVisibility((i & 32) > 0 ? 0 : 8);
        }
        this.eFJ.setVisibility((i & 64) > 0 ? 0 : 8);
        this.iBO.setVisibility((i & 128) > 0 ? 0 : 8);
        this.iBP.setVisibility((i & 256) > 0 ? 0 : 8);
        this.iBQ.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.iBQ.getVisibility() == 0) {
            this.iBQ.showProgress();
        }
        this.iBR.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.iBS.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.iBS.getVisibility() == 0) {
            this.iBS.setAlpha(1.0f);
        }
        this.iBT.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.iBU.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cgh();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cgj();
            } else if (id == R.id.video_replay) {
                zf(this.iBu);
                startPlay();
                TiebaStatic.log(new an("c13345").bT("tid", this.bXN).n("fid", this.mFid).P("obj_type", this.iBY ? 1 : 2).P("obj_locate", this.hMq ? 1 : 2));
                cgf();
            } else if (id == R.id.video_play) {
                if (this.iBD == this.iBu) {
                    startPlay();
                } else {
                    zf(this.iBx);
                    cgc();
                    this.ixp.start();
                }
                TiebaStatic.log(new an("c13344").bT("tid", this.bXN).n("fid", this.mFid).P("obj_type", this.iBY ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hMq ? 1 : 2).P("obj_locate", 1));
                cgf();
            } else if (id == R.id.video_pause) {
                zf(this.iBy);
                cgd();
                this.ixp.pause();
                TiebaStatic.log(new an("c13344").bT("tid", this.bXN).n("fid", this.mFid).P("obj_type", this.iBY ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hMq ? 1 : 2).P("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgf() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bXa);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.XD);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgg() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.ixp.setVolume(0.0f, 0.0f);
            this.iBO.setState(1);
            return;
        }
        this.ixp.setVolume(1.0f, 1.0f);
        this.iBO.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgh() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.ixp.setVolume(1.0f, 1.0f);
            ac.a(this.bCb, true);
            this.iBO.setState(0);
        } else {
            this.ixp.setVolume(0.0f, 0.0f);
            this.iBO.setState(1);
            ac.a(this.bCb, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgi() {
        if (this.mRootView != null && this.iBW != null && this.ixp != null) {
            this.ixp.setFullScreenToDestroySurface();
            if (this.dhl == null) {
                this.dhl = new o((Activity) this.mContext);
            }
            if (this.hMq) {
                if (!this.iBY) {
                    this.dhl.bLU();
                }
                if (this.iBV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.iBV.getParent()).removeView(this.iBV);
                }
                if ((this.iBW.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hMq = false;
                    ((ViewGroup) this.iBW.getParent()).removeView(this.iBW);
                    ((ViewGroup) this.mRootView).addView(this.iBW);
                    h((Activity) this.mContext, this.hMq);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.iBY) {
                        this.dhl.bLU();
                    }
                    if (this.mContext instanceof Activity) {
                        this.iBW.getLocationOnScreen(this.iCf);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.iBV == null) {
                                    this.iBV = new View(this.mContext);
                                    this.iBV.setClickable(true);
                                    this.iBV.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.iBV.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.iBV.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.iBV.getParent()).removeView(this.iBV);
                                }
                                this.iBV.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.iBV);
                                ((ViewGroup) childAt).addView(this.iBW);
                                this.hMq = true;
                                h((Activity) this.mContext, this.hMq);
                                if (this.fVp != null && this.fVp.isShowing()) {
                                    this.fVp.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new an("c13360").bT("tid", this.bXN).n("fid", this.mFid).P("obj_type", this.iBY ? 1 : 2));
            }
            cfZ();
            cfY();
            if (this.ixp.isPlaying()) {
                zf(this.iBv);
            } else {
                this.iBD |= 1;
                zf(this.iBD);
            }
            this.iBP.czg();
            ly(this.hMq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgj() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.iBY) {
            cgi();
        } else if (this.iBD == this.iBB) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.iBW.setScaleX(1.0f);
                    c.this.iBW.setScaleY(1.0f);
                    c.this.iBW.setTranslationX(0.0f);
                    c.this.iBW.setTranslationY(0.0f);
                    c.this.iBS.setScaleX(1.0f);
                    c.this.iBS.setScaleY(1.0f);
                    c.this.iBW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.iCh) {
                        c.this.cgi();
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
            if (!this.iCh) {
                float width = this.mRootView.getWidth() / this.iBW.getWidth();
                float height = this.mRootView.getHeight() / this.iBW.getHeight();
                this.iBW.setPivotX(0.0f);
                this.iBW.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.iBW, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.iBW, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.iBS, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.iBS, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.iBW, "TranslationX", this.iBW.getTranslationX(), this.iCf[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.iBW, "TranslationY", this.iBW.getTranslationY(), this.iCf[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.iBV, "alpha", this.iBV.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.iBS, "alpha", this.iBS.getAlpha(), 0.0f);
            } else {
                float width2 = this.iCd / this.iBW.getWidth();
                float height2 = this.iCg / this.iBW.getHeight();
                this.iBW.setPivotX(0.0f);
                this.iBW.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.iBW, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.iBW, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.iBS, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.iBS, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.iBW, "TranslationX", this.iBW.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.iBW, "TranslationY", this.iBW.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.iBS, "alpha", this.iBS.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.iBF != -1) {
                this.iBD = this.iBF;
                this.iBF = -1;
                if (this.iBD == this.iBC || this.iBD == this.iBx || this.iBD == this.iBv) {
                    this.ixp.start();
                    zf(this.iBv);
                }
            }
        } else {
            cgi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bLT();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.iBW.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ly(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cgg();
        if (this.iBX) {
            if (this.hMq && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.ixp.start();
        }
    }

    public void onCompletion(g gVar) {
        zf(this.iBz);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.iBD == this.iBy) {
            stopPlay();
            zf(this.iBy);
        } else if (this.iBD == this.iBz) {
            stopPlay();
            zf(this.iBz);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            zf(this.iBw);
            this.iBQ.showProgress();
            cge();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View ceV() {
        return this.iBW;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.iBX || this.ixp.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.ixp.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
        if ("index".equals(this.mFrom)) {
            this.ixp.setPageTypeForPerfStat("homepage");
        } else {
            this.ixp.setPageTypeForPerfStat(this.mFrom);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cfW() {
    }

    public boolean cey() {
        return !this.isNewPlayer && (this.ixp instanceof QuickVideoView);
    }

    private void bLT() {
        if (Build.VERSION.SDK_INT < 16) {
            this.iBW.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.iBW.setSystemUiVisibility(4);
        } else {
            this.iBW.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cfX() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.ixp.isPlaying() && !ac.awU()) {
            this.ixp.setVolume(1.0f, 1.0f);
            this.iBO.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean lx(boolean z) {
        if (z) {
            this.iBJ.cancelAnimation();
            if (this.iBD == this.iBv || this.iBD == this.iBw || this.iBD == this.iBx || this.iBD == this.iBu) {
                stopPlay();
            }
            this.iBD |= 1;
            zf(this.iBD);
        } else if (this.iBD == this.iBu) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hMq;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hMq) {
            cgj();
            return true;
        }
        return false;
    }

    protected int byj() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cgk() {
        return this.iCm != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ql(boolean z) {
        this.VL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.iCn = aVar;
    }
}
