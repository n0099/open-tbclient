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
    protected BdUniqueId GX;
    private String cln;
    protected String cma;
    private o dpP;
    private TextView eNA;
    private TextView eNz;
    private com.baidu.mcn.c fTS;
    protected TbImageView hfH;
    protected com.baidu.tieba.play.a.a iva;
    private View izA;
    protected ViewGroup izB;
    protected boolean izC;
    protected boolean izD;
    protected long izE;
    protected long izF;
    private n izG;
    private float izH;
    private float izI;
    private int izJ;
    private int izL;
    private boolean izM;
    private float izP;
    private int izQ;
    private McnAdInfo izR;
    private a izS;
    private View izm;
    private View izn;
    private TBLottieAnimationView izo;
    private ImageView izp;
    private View izq;
    private TextView izr;
    private TextView izs;
    protected SwitchImageView izt;
    private SwitchImageView izu;
    private OperableVideoMediaControllerView izv;
    private OperableVideoNetworkStateTipView izw;
    private OperableVideoShareView izx;
    private ImageView izy;
    private VideoGestureView izz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int iyY = 3000;
    protected int iyZ = 103;
    protected int iza = 0;
    protected int izb = 4;
    protected int izc = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
    protected int izd = 902;
    protected int ize = 2066;
    protected int izf = 1027;
    protected int izg = CommandMessage.COMMAND_BASE;
    protected int izh = 0;
    protected int izi = this.iyZ;
    private int izj = 0;
    private int izk = -1;
    private Runnable izl = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xJ(c.this.iza);
        }
    };
    private WeakReference<Context> bTF = null;
    private boolean hKd = false;
    private boolean isNewPlayer = false;
    private int[] izK = new int[2];
    private int izN = 0;
    private int izO = 0;
    protected View.OnClickListener clw = null;
    private boolean Fa = false;
    private long startPosition = -1;
    protected boolean Ic = false;
    private TbImageView.b HC = new TbImageView.b() { // from class: com.baidu.tieba.play.operableVideoView.c.6
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
                com.baidu.adp.widget.ImageView.a pY = com.baidu.tbadk.imageManager.c.avs().pY(com.baidu.adp.lib.f.c.fT().genCacheKey(tbImageView.getUrl(), 10));
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
                        if (c.this.Ic && i > i2) {
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
    private SeekBar.OnSeekBarChangeListener dhY = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xJ(c.this.izc);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.iva.isPlaying()) {
                    c.this.iva.start();
                }
                c.this.cda();
                TiebaStatic.log(new an("c13355").bS("tid", c.this.cma).p("fid", c.this.mFid).O("obj_type", c.this.izD ? 1 : 2).O("obj_locate", c.this.hKd ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener izT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.10
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.iva.isPlaying()) {
                c.this.iva.pause();
                c.this.xJ(c.this.izd);
            } else if (c.this.izi == c.this.izd || c.this.izi == (c.this.izd | 1)) {
                c.this.iva.start();
                c.this.xJ(c.this.izc);
                c.this.cda();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.izi == c.this.iza || c.this.izi == c.this.izb) {
                c.this.xJ(c.this.izc);
                c.this.cda();
            } else if (c.this.izi == c.this.izc) {
                c.this.xJ(c.this.iza);
            } else if (c.this.izi == c.this.izd) {
                c.this.xJ(c.this.izc);
                c.this.cda();
                c.this.iva.start();
                TiebaStatic.log(new an("c13344").bS("tid", c.this.cma).p("fid", c.this.mFid).O("obj_type", c.this.izD ? 1 : 2).O("obj_source", c.this.hKd ? 1 : 2).O("obj_locate", 1));
                c.this.cdd();
            } else {
                c.this.xJ(c.this.iyZ);
                c.this.startPlay();
                c.this.cdd();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.izj = 0;
            if (c.this.hKd) {
                c.this.i((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hKd) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.izD) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.izj) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.iva.isPlaying()) {
                                c.this.iva.pause();
                                c.this.xJ(c.this.izh);
                            }
                            c.this.izj = 4;
                            c.this.izk = c.this.izi;
                            c.this.izi = c.this.izg;
                            c.this.izL = c.this.izB.getMeasuredHeight();
                            c.this.izP = c.this.izI / c.this.izL;
                            c.this.izQ = (int) (1.2f * c.this.mRootView.getWidth());
                            cd(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        cd(rawX, rawY);
                        break;
                }
            } else if (c.this.izi == c.this.iza || c.this.izi == c.this.izc || c.this.izi == c.this.izd || c.this.izi == c.this.izg) {
                switch (c.this.izj) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.izj = 3;
                            c.this.izJ = c.this.iva.getCurrentPosition();
                            at(f);
                        } else if (motionEvent.getX() < c.this.izH / 2.0f) {
                            c.this.izj = 2;
                            c.this.izz.l(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.izj = 1;
                            c.this.izz.k(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.izi != c.this.izg) {
                            c.this.xJ(c.this.izg);
                            break;
                        }
                        break;
                    case 1:
                        c.this.izz.k(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.ccV();
                            break;
                        }
                        break;
                    case 2:
                        c.this.izz.l(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        at(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void cd(int i, int i2) {
            if (c.this.izN != i2 || c.this.izO != i) {
                c.this.izM = c.this.izN - i2 > 0 || ((float) i2) < c.this.izH / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.izB.getLayoutParams();
                if (i2 != c.this.izN) {
                    int i3 = c.this.izL - i2;
                    int i4 = (int) (i3 * c.this.izP);
                    if (i4 < c.this.izQ) {
                        i4 = c.this.izQ;
                        i3 = (int) (i4 / c.this.izP);
                    }
                    if (i4 != c.this.izQ) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.izB.setLayoutParams(layoutParams);
                    }
                    c.this.izN = i2;
                    c.this.izB.setTranslationY(c.this.izN);
                }
                if (i != c.this.izN) {
                    c.this.izO = i;
                    c.this.izB.setTranslationX(c.this.izO + ((c.this.izI - layoutParams.width) / 2.0f));
                }
                c.this.izA.setAlpha((layoutParams.width - c.this.izQ) / (c.this.izI - c.this.izQ));
                if (c.this.izx.getVisibility() == 0) {
                    float f = c.this.izH / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.izx.setAlpha(f2);
                }
            }
        }

        private void at(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.izJ -= 1000;
                z = true;
            } else {
                c.this.izJ += 1000;
                z = false;
            }
            int duration = c.this.iva.getDuration();
            if (c.this.izJ < 0) {
                c.this.izJ = 0;
            } else if (c.this.izJ > duration) {
                c.this.izJ = duration;
            }
            String str = aq.stringForVideoTime(c.this.izJ) + "/" + aq.stringForVideoTime(duration);
            if (c.this.izz != null) {
                c.this.izz.x(z, str);
            }
            c.this.izv.setCurrentDuration(c.this.izJ, false);
        }
    };
    private View.OnTouchListener czy = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.izi == c.this.izg) {
                if (c.this.izj == 4) {
                    c.this.cdh();
                    c.this.izN = 0;
                    c.this.izO = 0;
                } else {
                    c.this.izi = -1;
                    if (c.this.izj != 3) {
                        if (c.this.izk != -1) {
                            c.this.xJ(c.this.izk);
                            c.this.izk = -1;
                        } else if (c.this.iva.isPlaying()) {
                            c.this.xJ(c.this.iza);
                        } else {
                            c.this.xJ(c.this.izd);
                        }
                    } else {
                        c.this.izv.setCurrentDuration(c.this.izJ, true);
                        if (c.this.izJ < c.this.iva.getDuration()) {
                            if (!c.this.iva.isPlaying()) {
                                c.this.iva.start();
                            }
                            c.this.xJ(c.this.iza);
                        }
                    }
                }
                String str = null;
                if (c.this.izj != 1) {
                    if (c.this.izj != 2) {
                        if (c.this.izj == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!aq.isEmpty(str)) {
                    TiebaStatic.log(new an(str).bS("tid", c.this.cma).p("fid", c.this.mFid));
                }
                c.this.izj = 0;
                return true;
            }
            return c.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private final CustomMessageListener bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                c.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener izU = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cde();
                    return;
                }
                if (c.this.isPlaying()) {
                    ac.a(c.this.bTF, true);
                }
                c.this.iva.setVolume(1.0f, 1.0f);
                c.this.izt.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bE(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.izH = l.getEquipmentHeight(this.mContext);
            this.izI = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void ccW() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.izw.ah(this.izD, this.hKd);
        this.izx.ah(this.izD, this.hKd);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hKd) {
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
                if (this.izD) {
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
            this.izq.getLayoutParams().height = i;
            this.izq.setPadding(0, 0, 0, i3);
            this.eNA.setPadding(0, 0, i2, 0);
            this.izu.setPadding(this.izu.getPaddingLeft(), 0, i5, 0);
            this.izt.setPadding(i4, 0, this.izt.getPaddingLeft(), 0);
            this.izr.setPadding(dimension2, 0, this.izt.getPaddingLeft(), 0);
        }
    }

    public void ccX() {
        if (this.izD) {
            this.izc = 392;
            this.izd = 390;
        } else {
            this.izc = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
            this.izd = 902;
        }
        if (this.hKd) {
            this.iyZ |= 4096;
            this.iza |= 4096;
            this.izb |= 4096;
            this.izc |= 4096;
            this.izd |= 4096;
            this.ize |= 4096;
            this.izf |= 4096;
            this.izi |= 4096;
            return;
        }
        this.iyZ &= -4097;
        this.iza &= -4097;
        this.izb &= -4097;
        this.izc &= -4097;
        this.izd &= -4097;
        this.ize &= -4097;
        this.izf &= -4097;
        this.izi &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.izB = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.izB);
            }
            this.bTF = new WeakReference<>(TbadkCoreApplication.getInst());
            this.isNewPlayer = com.baidu.tbadk.a.b.mb("cyber_player_test");
            this.iva = com.baidu.tieba.play.a.b.x(this.mContext, this.isNewPlayer ? 1 : 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.izB.addView(this.iva.getView(), 0);
            this.iva.getView().setLayoutParams(layoutParams);
            this.hfH = (TbImageView) this.izB.findViewById(R.id.video_thumbnail);
            this.izm = this.izB.findViewById(R.id.black_mask_bottom);
            this.izn = this.izB.findViewById(R.id.black_mask_top);
            this.izo = (TBLottieAnimationView) this.izB.findViewById(R.id.video_play);
            this.izq = this.izB.findViewById(R.id.video_bottom_ctrl_layout);
            this.izp = (ImageView) this.izB.findViewById(R.id.video_pause);
            this.izr = (TextView) this.izB.findViewById(R.id.video_replay);
            this.eNA = (TextView) this.izB.findViewById(R.id.video_play_count);
            this.izs = (TextView) this.izB.findViewById(R.id.video_play_flag);
            this.eNz = (TextView) this.izB.findViewById(R.id.video_duration);
            this.izt = (SwitchImageView) this.izB.findViewById(R.id.video_mute);
            this.izu = (SwitchImageView) this.izB.findViewById(R.id.video_full_screen);
            this.izv = (OperableVideoMediaControllerView) this.izB.findViewById(R.id.video_media_controller);
            this.izw = (OperableVideoNetworkStateTipView) this.izB.findViewById(R.id.video_network_state_tip);
            this.izx = (OperableVideoShareView) this.izB.findViewById(R.id.video_share_view);
            this.izy = (ImageView) this.izB.findViewById(R.id.video_full_screen_back);
            this.izz = (VideoGestureView) this.izB.findViewById(R.id.video_gesture);
            this.izx.setVideoContainer(this);
            this.izG = new n(this.mContext);
            if (cby()) {
                ((QuickVideoView) this.iva).setNeedRecovery(true);
                ((QuickVideoView) this.iva).setPlayerReuseEnable(true);
            }
            this.iva.setContinuePlayEnable(true);
            this.izG.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.cdi() && !c.this.izD && !c.this.hKd && c.this.Fa) {
                        if (!com.baidu.mcn.b.ze().du(c.this.izR.jump_url)) {
                            boolean z = ((long) i2) >= c.this.izR.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.izR.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.izR.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fTS.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.ayz = c.this.izR.card_title;
                                    aVar.ayA = c.this.izR.button_title;
                                    aVar.ayB = c.this.izR.jump_url;
                                    aVar.ayy = c.this.izR.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.cma;
                                    aVar.ayC = c.this.bvl();
                                    if (z2) {
                                        c.this.fTS.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fTS.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fTS.isShowing()) {
                                c.this.fTS.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.izS != null) {
                        c.this.izS.bE(i, i2);
                    }
                }
            });
            this.iva.setBusiness(this.izG);
            this.iva.setOnPreparedListener(this);
            this.iva.setOnCompletionListener(this);
            this.iva.setOnErrorListener(this);
            this.iva.setOnSurfaceDestroyedListener(this);
            this.iva.setOnOutInfoListener(this);
            this.izo.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.izo.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.izo.setAnimation(R.raw.lotti_video_loading);
            this.izo.setOnClickListener(this);
            this.izt.setStateImage(R.drawable.icon_vedio_pronunciation_small_white, R.drawable.icon_vedio_npronunciation_small_white);
            this.izt.setState(1);
            this.izt.setOnClickListener(this);
            this.hfH.setConrers(15);
            this.hfH.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
            this.hfH.setDrawCorner(true);
            this.hfH.setDefaultBgResource(e.Vj());
            this.izv.setPlayer(this.iva);
            this.izv.setOnSeekBarChangeListener(this.dhY);
            this.izu.setStateImage(R.drawable.icon_vedio_full_screen, R.drawable.icon_vedio_narrow_screen);
            this.izu.setState(0);
            this.izu.setOnClickListener(this);
            this.izp.setOnClickListener(this);
            this.izr.setOnClickListener(this);
            this.izw.setPlayViewOnClickListener(this);
            this.izy.setOnClickListener(this);
            this.izB.setOnClickListener(null);
            this.izB.setOnTouchListener(this.czy);
            this.izx.setOnTouchListener(this.czy);
            this.mGestureDetector = new GestureDetector(this.mContext, this.izT);
            xJ(this.iyZ);
            this.fTS = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aiV() != null) {
            stopPlay();
            this.startPosition = -1L;
            if (this.fTS != null) {
                this.fTS.reset();
            }
            if (!aq.equals(this.cln, bhVar.aiV().video_url)) {
                this.izD = bhVar.aiV().is_vertical.intValue() == 1;
                this.cln = bhVar.aiV().video_url;
                this.cma = bhVar.getTid();
                this.izE = bhVar.aiV().video_length.intValue();
                this.izF = bhVar.aiV().video_duration.intValue();
                this.mFid = bhVar.getFid();
                this.izR = bhVar.aiV().mcn_ad_card;
                ccX();
                ccW();
                xJ(this.iyZ);
                int intValue = bhVar.aiV().video_duration.intValue() * 1000;
                this.izv.xH(intValue);
                this.izv.setPlayer(this.iva);
                this.eNz.setText(aq.stringForVideoTime(intValue));
                this.eNA.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), aq.numFormatOverWan(bhVar.aiV().play_count.intValue())));
                this.izw.setVideoLength(bhVar.aiV().video_length.intValue());
                this.izw.setTid(this.cma);
                this.izG.ccw().g(bhVar.aiV());
                this.izs.setVisibility(8);
                int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
                if (bhVar.aiV().wth_mid_loc != null && bhVar.aiV().hth_mid_loc != null && (homePageStyleAbTest & 4) != 0 && "index".equals(this.mFrom)) {
                    this.hfH.setScaleType(ImageView.ScaleType.MATRIX);
                    this.hfH.setIsSmartCrop(true);
                    setCanCenterStart(true);
                    if (this.izD) {
                        this.eNz.setText("");
                        this.eNA.setText("");
                        this.izs.setVisibility(0);
                    }
                    this.hfH.setSmartCropCenterPointWidthRatio(bhVar.aiV().wth_mid_loc.floatValue());
                    this.hfH.setSmartCropCenterPointHeightRatio(bhVar.aiV().hth_mid_loc.floatValue());
                    this.hfH.setOnDrawListener(this.HC);
                }
                this.hfH.startLoad(bhVar.aiV().thumbnail_url, 10, false);
                this.izx.setShareData(bhVar);
            }
        }
    }

    public void setCanCenterStart(boolean z) {
        this.Ic = z;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void c(z zVar) {
        if (zVar != null && this.izG != null) {
            this.izG.setVideoStatsData(zVar);
            this.iva.setBusiness(this.izG);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v ccw() {
        if (this.izG == null) {
            return null;
        }
        return this.izG.ccw();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.clw = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.GX = bdUniqueId;
    }

    public void cda() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.izl);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.izl, this.iyY);
    }

    public void cdb() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.izl);
    }

    private void startLoadingAnim() {
        if (this.izo != null) {
            this.izo.loop(true);
            this.izo.setMinAndMaxFrame(14, 80);
            this.izo.playAnimation();
        }
    }

    protected void ccY() {
        if (this.izi == this.izb) {
            xJ(this.iza);
        }
    }

    private void cdc() {
        if (this.izo != null) {
            this.izo.clearAnimation();
            this.izo.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.ccY();
                    if (c.this.izC) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.izo.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.bUR);
        MessageManager.getInstance().registerListener(this.izU);
        if (this.izw != null && this.izw.cdj()) {
            xJ(this.izf);
            return;
        }
        this.izC = true;
        if (!this.iva.isPlaying()) {
            this.iva.setVideoPath(this.cln, this.cma);
            startLoadingAnim();
            TiebaStatic.log(new an("c13357").bS("tid", this.cma).p("fid", this.mFid).O("obj_type", this.izD ? 1 : 2).O("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).O("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.izC = false;
        if (this.izo != null) {
            this.izo.cancelAnimation();
        }
        this.iva.stopPlayback();
        this.izv.aDR();
        xJ(this.iyZ);
        MessageManager.getInstance().unRegisterListener(this.bUR);
        MessageManager.getInstance().unRegisterListener(this.izU);
    }

    public void xJ(int i) {
        cdb();
        if (this.izi == this.izg) {
            this.izk = i;
            return;
        }
        this.izi = i;
        this.hfH.setVisibility((i & 1) > 0 ? 0 : 8);
        this.izm.setVisibility((i & 2) > 0 ? 0 : 8);
        this.izn.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.izo.clearAnimation();
        this.izo.setVisibility(z ? 0 : 8);
        if (!z) {
            this.izo.setFrame(0);
            this.izo.cancelAnimation();
        } else {
            this.izo.setAlpha(1.0f);
        }
        this.izp.setVisibility((i & 8) > 0 ? 0 : 8);
        this.izr.setVisibility((i & 16) > 0 ? 0 : 8);
        this.eNA.setVisibility((i & 32) > 0 ? 0 : 8);
        int homePageStyleAbTest = TbSingleton.getInstance().getHomePageStyleAbTest();
        if ("index".equals(this.mFrom) && this.izD && (homePageStyleAbTest & 4) != 0) {
            this.izs.setVisibility((i & 32) > 0 ? 0 : 8);
        }
        this.eNz.setVisibility((i & 64) > 0 ? 0 : 8);
        this.izt.setVisibility((i & 128) > 0 ? 0 : 8);
        this.izu.setVisibility((i & 256) > 0 ? 0 : 8);
        this.izv.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.izv.getVisibility() == 0) {
            this.izv.showProgress();
        }
        this.izw.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.izx.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.izx.getVisibility() == 0) {
            this.izx.setAlpha(1.0f);
        }
        this.izy.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.izz.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.video_mute) {
                cdf();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                cdh();
            } else if (id == R.id.video_replay) {
                xJ(this.iyZ);
                startPlay();
                TiebaStatic.log(new an("c13345").bS("tid", this.cma).p("fid", this.mFid).O("obj_type", this.izD ? 1 : 2).O("obj_locate", this.hKd ? 1 : 2));
                cdd();
            } else if (id == R.id.video_play) {
                if (this.izi == this.iyZ) {
                    startPlay();
                } else {
                    xJ(this.izc);
                    cda();
                    this.iva.start();
                }
                TiebaStatic.log(new an("c13344").bS("tid", this.cma).p("fid", this.mFid).O("obj_type", this.izD ? 1 : 2).O("obj_source", this.hKd ? 1 : 2).O("obj_locate", 1));
                cdd();
            } else if (id == R.id.video_pause) {
                xJ(this.izd);
                cdb();
                this.iva.pause();
                TiebaStatic.log(new an("c13344").bS("tid", this.cma).p("fid", this.mFid).O("obj_type", this.izD ? 1 : 2).O("obj_source", this.hKd ? 1 : 2).O("obj_locate", 2));
            } else if (id == R.id.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdd() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.cln);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.GX);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cde() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.iva.setVolume(0.0f, 0.0f);
            this.izt.setState(1);
            return;
        }
        this.iva.setVolume(1.0f, 1.0f);
        this.izt.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdf() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.iva.setVolume(1.0f, 1.0f);
            ac.a(this.bTF, true);
            this.izt.setState(0);
        } else {
            this.iva.setVolume(0.0f, 0.0f);
            this.izt.setState(1);
            ac.a(this.bTF, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdg() {
        if (this.mRootView != null && this.izB != null && this.iva != null) {
            this.iva.setFullScreenToDestroySurface();
            if (this.dpP == null) {
                this.dpP = new o((Activity) this.mContext);
            }
            if (this.hKd) {
                if (!this.izD) {
                    this.dpP.vt();
                }
                if (this.izA.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.izA.getParent()).removeView(this.izA);
                }
                if ((this.izB.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hKd = false;
                    ((ViewGroup) this.izB.getParent()).removeView(this.izB);
                    ((ViewGroup) this.mRootView).addView(this.izB);
                    i((Activity) this.mContext, this.hKd);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.izD) {
                        this.dpP.vt();
                    }
                    if (this.mContext instanceof Activity) {
                        this.izB.getLocationOnScreen(this.izK);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.izA == null) {
                                    this.izA = new View(this.mContext);
                                    this.izA.setClickable(true);
                                    this.izA.setBackgroundColor(am.getColor(R.color.black_alpha100));
                                    this.izA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.izA.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.izA.getParent()).removeView(this.izA);
                                }
                                this.izA.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.izA);
                                ((ViewGroup) childAt).addView(this.izB);
                                this.hKd = true;
                                i((Activity) this.mContext, this.hKd);
                                if (this.fTS != null && this.fTS.isShowing()) {
                                    this.fTS.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new an("c13360").bS("tid", this.cma).p("fid", this.mFid).O("obj_type", this.izD ? 1 : 2));
            }
            ccX();
            ccW();
            if (this.iva.isPlaying()) {
                xJ(this.iza);
            } else {
                this.izi |= 1;
                xJ(this.izi);
            }
            this.izu.cwS();
            lm(this.hKd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdh() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.izD) {
            cdg();
        } else if (this.izi == this.izg) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.izB.setScaleX(1.0f);
                    c.this.izB.setScaleY(1.0f);
                    c.this.izB.setTranslationX(0.0f);
                    c.this.izB.setTranslationY(0.0f);
                    c.this.izx.setScaleX(1.0f);
                    c.this.izx.setScaleY(1.0f);
                    c.this.izB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.izM) {
                        c.this.cdg();
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
            if (!this.izM) {
                float width = this.mRootView.getWidth() / this.izB.getWidth();
                float height = this.mRootView.getHeight() / this.izB.getHeight();
                this.izB.setPivotX(0.0f);
                this.izB.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.izB, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.izB, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.izx, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.izx, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.izB, "TranslationX", this.izB.getTranslationX(), this.izK[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.izB, "TranslationY", this.izB.getTranslationY(), this.izK[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.izA, "alpha", this.izA.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.izx, "alpha", this.izx.getAlpha(), 0.0f);
            } else {
                float width2 = this.izI / this.izB.getWidth();
                float height2 = this.izL / this.izB.getHeight();
                this.izB.setPivotX(0.0f);
                this.izB.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.izB, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.izB, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.izx, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.izx, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.izB, "TranslationX", this.izB.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.izB, "TranslationY", this.izB.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.izx, "alpha", this.izx.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.izk != -1) {
                this.izi = this.izk;
                this.izk = -1;
                if (this.izi == this.izh || this.izi == this.izc || this.izi == this.iza) {
                    this.iva.start();
                    xJ(this.iza);
                }
            }
        } else {
            cdg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bIB();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.izB.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lm(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        cde();
        if (this.izC) {
            if (this.hKd && (this.mContext instanceof Activity)) {
                i((Activity) this.mContext, true);
            }
            this.iva.start();
        }
    }

    public void onCompletion(g gVar) {
        xJ(this.ize);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.izi == this.izd) {
            stopPlay();
            xJ(this.izd);
        } else if (this.izi == this.ize) {
            stopPlay();
            xJ(this.ize);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3 || i == 904) {
            xJ(this.izb);
            this.izv.showProgress();
            cdc();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View cbV() {
        return this.izB;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.izC || this.iva.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.iva.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
        if ("index".equals(this.mFrom)) {
            this.iva.setPageTypeForPerfStat("homepage");
        } else {
            this.iva.setPageTypeForPerfStat(this.mFrom);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void aLU() {
    }

    public boolean cby() {
        return !this.isNewPlayer && (this.iva instanceof QuickVideoView);
    }

    private void bIB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.izB.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.izB.setSystemUiVisibility(4);
        } else {
            this.izB.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ccV() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.iva.isPlaying() && !ac.axS()) {
            this.iva.setVolume(1.0f, 1.0f);
            this.izt.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean ll(boolean z) {
        if (z) {
            this.izo.cancelAnimation();
            if (this.izi == this.iza || this.izi == this.izb || this.izi == this.izc || this.izi == this.iyZ) {
                stopPlay();
            }
            this.izi |= 1;
            xJ(this.izi);
        } else if (this.izi == this.iyZ) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hKd;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hKd) {
            cdh();
            return true;
        }
        return false;
    }

    protected int bvl() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cdi() {
        return this.izR != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pS(boolean z) {
        this.Fa = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.izS = aVar;
    }
}
