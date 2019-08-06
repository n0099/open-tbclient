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
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.j.k;
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
    protected BdUniqueId XE;
    protected String bWU;
    private String bWh;
    private o dfA;
    protected QuickVideoView dnB;
    protected k eCt;
    private TextView eEa;
    private TextView eEb;
    private com.baidu.mcn.c fTy;
    protected TbImageView hgz;
    private OperableVideoShareView izA;
    private ImageView izB;
    private VideoGestureView izC;
    private View izD;
    protected ViewGroup izE;
    protected boolean izF;
    protected boolean izG;
    protected long izH;
    protected long izI;
    private n izJ;
    private float izK;
    private float izL;
    private int izM;
    private int izO;
    private boolean izP;
    private float izS;
    private int izT;
    private McnAdInfo izU;
    private a izV;
    private View izp;
    private View izq;
    private TBLottieAnimationView izr;
    private ImageView izs;
    private View izt;
    private TextView izu;
    private TextView izv;
    protected SwitchImageView izw;
    private SwitchImageView izx;
    private OperableVideoMediaControllerView izy;
    private OperableVideoNetworkStateTipView izz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int izb = 3000;
    protected int izc = 103;
    protected int izd = 0;
    protected int ize = 4;
    protected int izf = 904;
    protected int izg = 902;
    protected int izh = 2066;
    protected int izi = 1027;
    protected int izj = CommandMessage.COMMAND_BASE;
    protected int izk = 0;
    protected int izl = this.izc;
    private int izm = 0;
    private int izn = -1;
    private Runnable izo = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.zc(c.this.izd);
        }
    };
    private WeakReference<Context> bBD = null;
    private boolean hKt = false;
    private int[] izN = new int[2];
    private int izQ = 0;
    private int izR = 0;
    protected View.OnClickListener bWq = null;
    private boolean VM = false;
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
                com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.aty().qH(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), 10));
                if (qH != null) {
                    int width = qH.getWidth();
                    i = qH.getHeight();
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
    private SeekBar.OnSeekBarChangeListener cXL = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.zc(c.this.izf);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dnB.isPlaying()) {
                    c.this.dnB.start();
                }
                c.this.cfo();
                TiebaStatic.log(new an("c13355").bT("tid", c.this.bWU).l("fid", c.this.mFid).P("obj_type", c.this.izG ? 1 : 2).P("obj_locate", c.this.hKt ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener izW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.10
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dnB.isPlaying()) {
                c.this.dnB.pause();
                c.this.zc(c.this.izg);
            } else if (c.this.izl == c.this.izg || c.this.izl == (c.this.izg | 1)) {
                c.this.dnB.start();
                c.this.zc(c.this.izf);
                c.this.cfo();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.izl == c.this.izd || c.this.izl == c.this.ize) {
                c.this.zc(c.this.izf);
                c.this.cfo();
            } else if (c.this.izl == c.this.izf) {
                c.this.zc(c.this.izd);
            } else if (c.this.izl == c.this.izg) {
                c.this.zc(c.this.izf);
                c.this.cfo();
                c.this.dnB.start();
                TiebaStatic.log(new an("c13344").bT("tid", c.this.bWU).l("fid", c.this.mFid).P("obj_type", c.this.izG ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hKt ? 1 : 2).P("obj_locate", 1));
                c.this.cfr();
            } else {
                c.this.zc(c.this.izc);
                c.this.startPlay();
                c.this.cfr();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.izm = 0;
            if (c.this.hKt) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hKt) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.izG) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.izm) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dnB.isPlaying()) {
                                c.this.dnB.pause();
                                c.this.zc(c.this.izk);
                            }
                            c.this.izm = 4;
                            c.this.izn = c.this.izl;
                            c.this.izl = c.this.izj;
                            c.this.izO = c.this.izE.getMeasuredHeight();
                            c.this.izS = c.this.izL / c.this.izO;
                            c.this.izT = (int) (1.2f * c.this.mRootView.getWidth());
                            cm(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cm(rawX, rawY);
                        break;
                }
            } else if (c.this.izl == c.this.izd || c.this.izl == c.this.izf || c.this.izl == c.this.izg || c.this.izl == c.this.izj) {
                switch (c.this.izm) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.izm = 3;
                            c.this.izM = c.this.dnB.getCurrentPosition();
                            aP(f);
                        } else if (motionEvent.getX() < c.this.izK / 2.0f) {
                            c.this.izm = 2;
                            c.this.izC.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.izm = 1;
                            c.this.izC.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.izl != c.this.izj) {
                            c.this.zc(c.this.izj);
                            break;
                        }
                        break;
                    case 1:
                        c.this.izC.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.cfj();
                            break;
                        }
                        break;
                    case 2:
                        c.this.izC.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aP(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cm(int i, int i2) {
            if (c.this.izQ != i2 || c.this.izR != i) {
                c.this.izP = c.this.izQ - i2 > 0 || ((float) i2) < c.this.izK / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.izE.getLayoutParams();
                if (i2 != c.this.izQ) {
                    int i3 = c.this.izO - i2;
                    int i4 = (int) (i3 * c.this.izS);
                    if (i4 < c.this.izT) {
                        i4 = c.this.izT;
                        i3 = (int) (i4 / c.this.izS);
                    }
                    if (i4 != c.this.izT) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.izE.setLayoutParams(layoutParams);
                    }
                    c.this.izQ = i2;
                    c.this.izE.setTranslationY(c.this.izQ);
                }
                if (i != c.this.izQ) {
                    c.this.izR = i;
                    c.this.izE.setTranslationX(c.this.izR + ((c.this.izL - layoutParams.width) / 2.0f));
                }
                c.this.izD.setAlpha((layoutParams.width - c.this.izT) / (c.this.izL - c.this.izT));
                if (c.this.izA.getVisibility() == 0) {
                    float f = c.this.izK / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.izA.setAlpha(f2);
                }
            }
        }

        private void aP(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.izM += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.izM += 1000;
                z = false;
            }
            int duration = c.this.dnB.getDuration();
            if (c.this.izM < 0) {
                c.this.izM = 0;
            } else if (c.this.izM > duration) {
                c.this.izM = duration;
            }
            String str = aq.is(c.this.izM) + "/" + aq.is(duration);
            if (c.this.izC != null) {
                c.this.izC.x(z, str);
            }
            c.this.izy.setCurrentDuration(c.this.izM, false);
        }
    };
    private View.OnTouchListener cmw = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.izl == c.this.izj) {
                if (c.this.izm == 4) {
                    c.this.cfv();
                    c.this.izQ = 0;
                    c.this.izR = 0;
                } else {
                    c.this.izl = -1;
                    if (c.this.izm != 3) {
                        if (c.this.izn != -1) {
                            c.this.zc(c.this.izn);
                            c.this.izn = -1;
                        } else if (c.this.dnB.isPlaying()) {
                            c.this.zc(c.this.izd);
                        } else {
                            c.this.zc(c.this.izg);
                        }
                    } else {
                        c.this.izy.setCurrentDuration(c.this.izM, true);
                        if (c.this.izM < c.this.dnB.getDuration()) {
                            if (!c.this.dnB.isPlaying()) {
                                c.this.dnB.start();
                            }
                            c.this.zc(c.this.izd);
                        }
                    }
                }
                String str = null;
                if (c.this.izm != 1) {
                    if (c.this.izm != 2) {
                        if (c.this.izm == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!aq.isEmpty(str)) {
                    TiebaStatic.log(new an(str).bT("tid", c.this.bWU).l("fid", c.this.mFid));
                }
                c.this.izm = 0;
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
    private final CustomMessageListener izX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cfs();
                    return;
                }
                if (c.this.isPlaying()) {
                    ad.a(c.this.bBD, true);
                }
                c.this.dnB.setVolume(1.0f, 1.0f);
                c.this.izw.setState(0);
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
            this.izK = l.ah(this.mContext);
            this.izL = l.af(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void cfk() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.izz.ah(this.izG, this.hKt);
        this.izA.ah(this.izG, this.hKt);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hKt) {
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
                if (this.izG) {
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
            this.izt.getLayoutParams().height = i;
            this.izt.setPadding(0, 0, 0, i3);
            this.eEb.setPadding(0, 0, i2, 0);
            this.izx.setPadding(this.izx.getPaddingLeft(), 0, i5, 0);
            this.izw.setPadding(i4, 0, this.izw.getPaddingLeft(), 0);
            this.izu.setPadding(dimension2, 0, this.izw.getPaddingLeft(), 0);
        }
    }

    public void cfl() {
        if (this.izG) {
            this.izf = 392;
            this.izg = 390;
        } else {
            this.izf = 904;
            this.izg = 902;
        }
        if (this.hKt) {
            this.izc |= 4096;
            this.izd |= 4096;
            this.ize |= 4096;
            this.izf |= 4096;
            this.izg |= 4096;
            this.izh |= 4096;
            this.izi |= 4096;
            this.izl |= 4096;
            return;
        }
        this.izc &= -4097;
        this.izd &= -4097;
        this.ize &= -4097;
        this.izf &= -4097;
        this.izg &= -4097;
        this.izh &= -4097;
        this.izi &= -4097;
        this.izl &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.izE = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.izE);
            }
            this.bBD = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dnB = (QuickVideoView) this.izE.findViewById(R.id.video_view);
            this.hgz = (TbImageView) this.izE.findViewById(R.id.video_thumbnail);
            this.izp = this.izE.findViewById(R.id.black_mask_bottom);
            this.izq = this.izE.findViewById(R.id.black_mask_top);
            this.izr = (TBLottieAnimationView) this.izE.findViewById(R.id.video_play);
            this.izt = this.izE.findViewById(R.id.video_bottom_ctrl_layout);
            this.izs = (ImageView) this.izE.findViewById(R.id.video_pause);
            this.izu = (TextView) this.izE.findViewById(R.id.video_replay);
            this.eEb = (TextView) this.izE.findViewById(R.id.video_play_count);
            this.izv = (TextView) this.izE.findViewById(R.id.video_play_flag);
            this.eEa = (TextView) this.izE.findViewById(R.id.video_duration);
            this.izw = (SwitchImageView) this.izE.findViewById(R.id.video_mute);
            this.izx = (SwitchImageView) this.izE.findViewById(R.id.video_full_screen);
            this.izy = (OperableVideoMediaControllerView) this.izE.findViewById(R.id.video_media_controller);
            this.izz = (OperableVideoNetworkStateTipView) this.izE.findViewById(R.id.video_network_state_tip);
            this.izA = (OperableVideoShareView) this.izE.findViewById(R.id.video_share_view);
            this.izB = (ImageView) this.izE.findViewById(R.id.video_full_screen_back);
            this.izC = (VideoGestureView) this.izE.findViewById(R.id.video_gesture);
            this.izA.setVideoContainer(this);
            this.izJ = new n(this.mContext);
            this.dnB.setNeedRecovery(true);
            this.dnB.setPlayerReuseEnable(true);
            this.dnB.setContinuePlayEnable(true);
            this.izJ.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cfw() && !c.this.izG && !c.this.hKt && c.this.VM) {
                        if (!com.baidu.mcn.b.uj().cJ(c.this.izU.jump_url)) {
                            boolean z = ((long) i2) >= c.this.izU.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.izU.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.izU.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fTy.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aft = c.this.izU.card_title;
                                    aVar.afu = c.this.izU.button_title;
                                    aVar.afv = c.this.izU.jump_url;
                                    aVar.afs = c.this.izU.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.bWU;
                                    aVar.afw = c.this.bxv();
                                    if (z2) {
                                        c.this.fTy.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fTy.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fTy.isShowing()) {
                                c.this.fTy.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.izV != null) {
                        c.this.izV.bK(i, i2);
                    }
                }
            });
            this.dnB.setBusiness(this.izJ);
            this.dnB.setOnPreparedListener(this);
            this.dnB.setOnCompletionListener(this);
            this.dnB.setOnErrorListener(this);
            this.dnB.setOnSurfaceDestroyedListener(this);
            this.dnB.setOnOutInfoListener(this);
            this.izr.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.izr.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.izr.setAnimation(R.raw.lotti_video_loading);
            this.izr.setOnClickListener(this);
            this.izw.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.izw.setState(1);
            this.izw.setOnClickListener(this);
            this.hgz.setConrers(15);
            this.hgz.setRadius(l.g(this.mContext, R.dimen.tbds20));
            this.hgz.setDrawCorner(true);
            this.hgz.setDefaultBgResource(e.Qr());
            this.izy.setPlayer(this.dnB);
            this.izy.setOnSeekBarChangeListener(this.cXL);
            this.izx.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.izx.setState(0);
            this.izx.setOnClickListener(this);
            this.izs.setOnClickListener(this);
            this.izu.setOnClickListener(this);
            this.izz.setPlayViewOnClickListener(this);
            this.izB.setOnClickListener(this);
            this.izE.setOnClickListener(null);
            this.izE.setOnTouchListener(this.cmw);
            this.izA.setOnTouchListener(this.cmw);
            this.mGestureDetector = new GestureDetector(this.mContext, this.izW);
            zc(this.izc);
            this.eCt = new k();
            this.fTy = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aeP() != null) {
            this.startPosition = -1L;
            if (this.fTy != null) {
                this.fTy.reset();
            }
            if (!aq.bV(this.bWh, bhVar.aeP().video_url)) {
                this.izG = bhVar.aeP().is_vertical.intValue() == 1;
                this.bWh = bhVar.aeP().video_url;
                this.bWU = bhVar.getTid();
                this.izH = bhVar.aeP().video_length.intValue();
                this.izI = bhVar.aeP().video_duration.intValue();
                this.mFid = bhVar.getFid();
                this.izU = bhVar.aeP().mcn_ad_card;
                cfl();
                cfk();
                zc(this.izc);
                int intValue = bhVar.aeP().video_duration.intValue() * 1000;
                this.izy.za(intValue);
                this.izy.setPlayer(this.dnB);
                this.eEa.setText(aq.is(intValue));
                this.eEb.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.aO(bhVar.aeP().play_count.intValue())));
                this.izz.setVideoLength(bhVar.aeP().video_length.intValue());
                this.izz.setTid(this.bWU);
                this.izJ.ceI().g(bhVar.aeP());
                this.izv.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bhVar.aeP().wth_mid_loc != null && bhVar.aeP().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.hgz.setScaleType(ImageView.ScaleType.MATRIX);
                    this.hgz.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.izG) {
                        this.eEa.setText("");
                        this.eEb.setText("");
                        this.izv.setVisibility(0);
                    }
                    this.hgz.setSmartCropCenterPointWidthRatio(bhVar.aeP().wth_mid_loc.floatValue());
                    this.hgz.setSmartCropCenterPointHeightRatio(bhVar.aeP().hth_mid_loc.floatValue());
                    this.hgz.setOnDrawListener(this.mOnDrawListener);
                }
                this.hgz.startLoad(bhVar.aeP().thumbnail_url, 10, false);
                this.izA.setShareData(bhVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.YG = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(z zVar) {
        if (zVar != null && this.izJ != null) {
            this.izJ.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v ceI() {
        if (this.izJ == null) {
            return null;
        }
        return this.izJ.ceI();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWq = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.XE = bdUniqueId;
    }

    public void cfo() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.izo, this.izb);
    }

    public void cfp() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.izo);
    }

    private void startLoadingAnim() {
        if (this.izr != null) {
            this.izr.y(true);
            this.izr.setMinAndMaxFrame(14, 80);
            this.izr.br();
        }
    }

    protected void cfm() {
        if (this.izl == this.ize) {
            zc(this.izd);
        }
    }

    private void cfq() {
        if (this.izr != null) {
            this.izr.clearAnimation();
            this.izr.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.cfm();
                    if (c.this.izF) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.izr.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.izX);
        if (this.izz != null && this.izz.cfx()) {
            zc(this.izi);
            return;
        }
        this.izF = true;
        if (!this.dnB.isPlaying()) {
            this.eCt.bPi();
            this.dnB.setVideoPath(this.bWh, this.bWU);
            startLoadingAnim();
            TiebaStatic.log(new an("c13357").bT("tid", this.bWU).l("fid", this.mFid).P("obj_type", this.izG ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).P("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.izF = false;
        if (this.izr != null) {
            this.izr.cancelAnimation();
        }
        this.dnB.cey();
        this.izy.aDg();
        zc(this.izc);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.izX);
    }

    public void zc(int i) {
        cfp();
        if (i == this.ize) {
            if ("index".equals(this.mFrom)) {
                this.eCt.a(this.bWU, this.izH, this.izI, "homepage", this.dnB);
            } else {
                this.eCt.a(this.bWU, this.izH, this.izI, this.mFrom, this.dnB);
            }
        }
        if (this.izl == this.izj) {
            this.izn = i;
            return;
        }
        this.izl = i;
        this.hgz.setVisibility((i & 1) > 0 ? 0 : 8);
        this.izp.setVisibility((i & 2) > 0 ? 0 : 8);
        this.izq.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.izr.clearAnimation();
        this.izr.setVisibility(z ? 0 : 8);
        if (!z) {
            this.izr.setFrame(0);
            this.izr.cancelAnimation();
        } else {
            this.izr.setAlpha(1.0f);
        }
        this.izs.setVisibility((i & 8) > 0 ? 0 : 8);
        this.izu.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eEb.setVisibility((i & 32) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.izG && (homePageStyleAbTest & 4) != 0) {
            this.izv.setVisibility((i & 32) > 0 ? 0 : 8);
        }
        this.eEa.setVisibility((i & 64) > 0 ? 0 : 8);
        this.izw.setVisibility((i & 128) > 0 ? 0 : 8);
        this.izx.setVisibility((i & 256) > 0 ? 0 : 8);
        this.izy.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.izy.getVisibility() == 0) {
            this.izy.showProgress();
        }
        this.izz.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.izA.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.izA.getVisibility() == 0) {
            this.izA.setAlpha(1.0f);
        }
        this.izB.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.izC.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cft();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cfv();
            } else if (id == R.id.video_replay) {
                zc(this.izc);
                startPlay();
                TiebaStatic.log(new an("c13345").bT("tid", this.bWU).l("fid", this.mFid).P("obj_type", this.izG ? 1 : 2).P("obj_locate", this.hKt ? 1 : 2));
                cfr();
            } else if (id == R.id.video_play) {
                if (this.izl == this.izc) {
                    startPlay();
                } else {
                    zc(this.izf);
                    cfo();
                    this.dnB.start();
                }
                TiebaStatic.log(new an("c13344").bT("tid", this.bWU).l("fid", this.mFid).P("obj_type", this.izG ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hKt ? 1 : 2).P("obj_locate", 1));
                cfr();
            } else if (id == R.id.video_pause) {
                zc(this.izg);
                cfp();
                this.dnB.pause();
                TiebaStatic.log(new an("c13344").bT("tid", this.bWU).l("fid", this.mFid).P("obj_type", this.izG ? 1 : 2).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hKt ? 1 : 2).P("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfr() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bWh);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.XE);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfs() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dnB.setVolume(0.0f, 0.0f);
            this.izw.setState(1);
            return;
        }
        this.dnB.setVolume(1.0f, 1.0f);
        this.izw.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cft() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dnB.setVolume(1.0f, 1.0f);
            ad.a(this.bBD, true);
            this.izw.setState(0);
        } else {
            this.dnB.setVolume(0.0f, 0.0f);
            this.izw.setState(1);
            ad.a(this.bBD, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cfu() {
        if (this.mRootView != null && this.izE != null && this.dnB != null) {
            this.dnB.setFullScreenToDestroySurface();
            if (this.dfA == null) {
                this.dfA = new o((Activity) this.mContext);
            }
            if (this.hKt) {
                if (!this.izG) {
                    this.dfA.bLh();
                }
                if (this.izD.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.izD.getParent()).removeView(this.izD);
                }
                if ((this.izE.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hKt = false;
                    ((ViewGroup) this.izE.getParent()).removeView(this.izE);
                    ((ViewGroup) this.mRootView).addView(this.izE);
                    h((Activity) this.mContext, this.hKt);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.izG) {
                        this.dfA.bLh();
                    }
                    if (this.mContext instanceof Activity) {
                        this.izE.getLocationOnScreen(this.izN);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.izD == null) {
                                    this.izD = new View(this.mContext);
                                    this.izD.setClickable(true);
                                    this.izD.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.izD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.izD.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.izD.getParent()).removeView(this.izD);
                                }
                                this.izD.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.izD);
                                ((ViewGroup) childAt).addView(this.izE);
                                this.hKt = true;
                                h((Activity) this.mContext, this.hKt);
                                if (this.fTy != null && this.fTy.isShowing()) {
                                    this.fTy.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new an("c13360").bT("tid", this.bWU).l("fid", this.mFid).P("obj_type", this.izG ? 1 : 2));
            }
            cfl();
            cfk();
            if (this.dnB.isPlaying()) {
                zc(this.izd);
            } else {
                this.izl |= 1;
                zc(this.izl);
            }
            this.izx.cys();
            lv(this.hKt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfv() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.izG) {
            cfu();
        } else if (this.izl == this.izj) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.izE.setScaleX(1.0f);
                    c.this.izE.setScaleY(1.0f);
                    c.this.izE.setTranslationX(0.0f);
                    c.this.izE.setTranslationY(0.0f);
                    c.this.izA.setScaleX(1.0f);
                    c.this.izA.setScaleY(1.0f);
                    c.this.izE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.izP) {
                        c.this.cfu();
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
            if (!this.izP) {
                float width = this.mRootView.getWidth() / this.izE.getWidth();
                float height = this.mRootView.getHeight() / this.izE.getHeight();
                this.izE.setPivotX(0.0f);
                this.izE.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.izE, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.izE, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.izA, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.izA, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.izE, "TranslationX", this.izE.getTranslationX(), this.izN[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.izE, "TranslationY", this.izE.getTranslationY(), this.izN[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.izD, "alpha", this.izD.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.izA, "alpha", this.izA.getAlpha(), 0.0f);
            } else {
                float width2 = this.izL / this.izE.getWidth();
                float height2 = this.izO / this.izE.getHeight();
                this.izE.setPivotX(0.0f);
                this.izE.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.izE, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.izE, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.izA, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.izA, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.izE, "TranslationX", this.izE.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.izE, "TranslationY", this.izE.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.izA, "alpha", this.izA.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.izn != -1) {
                this.izl = this.izn;
                this.izn = -1;
                if (this.izl == this.izk || this.izl == this.izf || this.izl == this.izd) {
                    this.dnB.start();
                    zc(this.izd);
                }
            }
        } else {
            cfu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bLg();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.izE.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lv(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cfs();
        this.eCt.bPj();
        if (this.izF) {
            if (this.hKt && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dnB.start();
            if (!this.dnB.getPlayer().isNewPlayer()) {
                zc(this.ize);
                this.izy.showProgress();
                cfq();
            }
        }
    }

    public void onCompletion(g gVar) {
        zc(this.izh);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.izl == this.izg) {
            stopPlay();
            zc(this.izg);
        } else if (this.izl == this.izh) {
            stopPlay();
            zc(this.izh);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            zc(this.ize);
            this.izy.showProgress();
            cfq();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View ceg() {
        return this.izE;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.izF || this.dnB.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dnB.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cfi() {
    }

    private void bLg() {
        if (Build.VERSION.SDK_INT < 16) {
            this.izE.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.izE.setSystemUiVisibility(4);
        } else {
            this.izE.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void cfj() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.dnB.isPlaying() && !ad.awI()) {
            this.dnB.setVolume(1.0f, 1.0f);
            this.izw.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean lu(boolean z) {
        if (z) {
            this.izr.cancelAnimation();
            if (this.izl == this.izd || this.izl == this.ize || this.izl == this.izf || this.izl == this.izc) {
                stopPlay();
            }
            this.izl |= 1;
            zc(this.izl);
        } else if (this.izl == this.izc) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hKt;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hKt) {
            cfv();
            return true;
        }
        return false;
    }

    protected int bxv() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cfw() {
        return this.izU != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qi(boolean z) {
        this.VM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.izV = aVar;
    }
}
