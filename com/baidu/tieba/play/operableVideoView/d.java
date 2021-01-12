package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ah;
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
    protected BdUniqueId agN;
    private String ajq;
    protected TbImageView amC;
    private ImageView amE;
    private ImageView amF;
    protected TextView amG;
    protected TextView amH;
    private TextView amI;
    protected boolean amL;
    protected String amM;
    protected long amN;
    protected TbCyberVideoView gxn;
    private com.baidu.mcn.c jGS;
    private j kVi;
    private PercentSizeView mAA;
    protected SwitchImageView mAB;
    protected SwitchImageView mAC;
    protected OperableVideoMediaControllerView mAD;
    protected OperableVideoNetworkStateTipView mAE;
    protected OperableVideoShareView mAF;
    protected ImageView mAG;
    protected View mAH;
    protected VideoGestureView mAI;
    private View mAJ;
    private OperableVideoErrorView mAK;
    protected ViewGroup mAL;
    protected boolean mAM;
    protected int mAN;
    protected o mAO;
    protected bz mAP;
    private float mAR;
    private float mAS;
    private int mAT;
    private int mAV;
    private boolean mAW;
    private float mAZ;
    private TBLottieAnimationView mAz;
    private int mBa;
    private McnAdInfo mBb;
    private a mBc;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    private View mzT;
    protected int mzX = 3000;
    protected final int mzY = 1;
    protected final int mzZ = 2;
    protected final int mAa = 4;
    protected final int mAb = 8;
    protected final int mAc = 16;
    protected final int mAd = 32;
    protected final int mAe = 64;
    protected final int mAf = 128;
    protected final int mAg = 256;
    protected final int mAh = 512;
    protected final int mAi = 1024;
    protected final int mAj = 2048;
    protected final int mAk = 4096;
    protected final int mAl = 8192;
    protected int mAm = 8211;
    protected int mAn = 0;
    protected int mAo = 4;
    protected int mAp = 232;
    protected int mAq = 8416;
    protected int mAr = 0;
    protected int mAs = 513;
    protected int mAt = 259;
    protected int mAu = 2048;
    protected int mAv = 0;
    protected int STATE_ERROR = 4099;
    protected int mAw = this.mAm;
    private int mbo = 0;
    private int mAx = -1;
    private Runnable mAy = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Gf(d.this.mAn);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lDY = false;
    protected boolean mAQ = true;
    private boolean isChangingOrientation = false;
    private int[] mAU = new int[2];
    private int mAX = 0;
    private int mAY = 0;
    protected View.OnClickListener ake = null;
    protected View.OnClickListener ags = null;
    private boolean agF = false;
    private long startPosition = -1;
    private f.b mBd = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ch(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dyE() && !d.this.amL && !d.this.lDY && d.this.agF) {
                if (!com.baidu.mcn.b.ZC().is(d.this.mBb.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mBb.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mBb.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mBb.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jGS.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.cdB = d.this.mBb.card_title;
                            aVar.cdC = d.this.mBb.button_title;
                            aVar.cdD = d.this.mBb.jump_url;
                            aVar.cdA = d.this.mBb.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.amM;
                            aVar.cdE = d.this.cPR();
                            if (z2) {
                                d.this.jGS.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jGS.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jGS.isShowing()) {
                        d.this.jGS.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mBc != null) {
                d.this.mBc.cJ(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gft = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Gf(d.this.mAp);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gxn.isPlaying()) {
                    d.this.gxn.a(d.this.mBe);
                }
                d.this.dyv();
                if (d.this.mAQ) {
                    TiebaStatic.log(new aq("c13355").dW("tid", d.this.amM).w("fid", d.this.mFid).an("obj_type", d.this.amL ? 1 : 2).an("obj_locate", d.this.lDY ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jmT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gxn.isPlaying()) {
                d.this.gxn.pause();
                if (d.this.mAw == d.this.mAp) {
                    d.this.Gf(d.this.mAq);
                } else {
                    d.this.Gf(d.this.mAr);
                }
                d.this.Gg(R.id.video_pause);
            } else if (d.this.mAw == d.this.mAq || d.this.mAw == (d.this.mAq | 1)) {
                d.this.Gf(d.this.mAp);
                d.this.dyv();
                d.this.gxn.a(d.this.mBe);
                d.this.Gg(R.id.video_play);
            } else if (d.this.mAw == d.this.mAr || d.this.mAw == (d.this.mAr | 1)) {
                d.this.Gf(d.this.mAn);
                d.this.gxn.a(d.this.mBe);
                d.this.Gg(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gxn.isPlaying()) {
                if (d.this.mAw == d.this.mAn || d.this.mAw == d.this.mAo) {
                    d.this.Gf(d.this.mAp);
                    d.this.dyv();
                    return true;
                } else if (d.this.mAw == d.this.mAp) {
                    d.this.Gf(d.this.mAn);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mAw == d.this.mAq) {
                d.this.Gf(d.this.mAr);
                return true;
            } else if (d.this.mAw == (d.this.mAq | 1)) {
                d.this.Gf(d.this.mAr | 1);
                return true;
            } else if (d.this.mAw == d.this.mAr) {
                d.this.Gf(d.this.mAq);
                return true;
            } else if (d.this.mAw == (d.this.mAr | 1)) {
                d.this.Gf(d.this.mAq | 1);
                return true;
            } else {
                d.this.Gf(d.this.mAm);
                d.this.startPlay();
                d.this.dyz();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.mbo = 0;
            if (d.this.lDY) {
                d.this.k((Activity) d.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!d.this.ac(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if ((d.this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.mContext).disableSwipeJustOnce();
            } else if ((d.this.mContext instanceof BaseActivity) && ((BaseActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseActivity) d.this.mContext).disableSwipeJustOnce();
            }
            if (d.this.amL && d.this.dsY()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.mbo) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gxn.isPlaying()) {
                                d.this.gxn.pause();
                                d.this.Gf(d.this.mAv);
                            }
                            d.this.mbo = 4;
                            d.this.mAx = d.this.mAw;
                            d.this.mAw = d.this.mAu;
                            d.this.mAV = d.this.mAL.getMeasuredHeight();
                            d.this.mAZ = d.this.mAS / d.this.mAV;
                            d.this.mBa = (int) (1.2f * d.this.mRootView.getWidth());
                            di(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        di(rawX, rawY);
                        break;
                }
            } else if (d.this.mAw == d.this.mAn || d.this.mAw == d.this.mAp || d.this.mAw == d.this.mAq || d.this.mAw == d.this.mAr || d.this.mAw == d.this.mAu || d.this.mAw == (d.this.mAq | 1) || d.this.mAw == (d.this.mAr | 1)) {
                switch (d.this.mbo) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.mbo = 3;
                            d.this.mAT = d.this.gxn.getCurrentPosition();
                            aV(f);
                        } else if (motionEvent.getX() < d.this.mAL.getWidth() / 2) {
                            d.this.mbo = 2;
                            d.this.mAI.v(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.mbo = 1;
                            d.this.mAI.u(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mAw != d.this.mAu) {
                            if ((d.this.mAw & 1) > 0) {
                                d.this.mAu |= 1;
                            } else {
                                d.this.mAu &= -2;
                            }
                            d.this.Gf(d.this.mAu);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mAI.u(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dtc();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mAI.v(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aV(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void di(int i, int i2) {
            if (d.this.mAX != i2 || d.this.mAY != i) {
                d.this.mAW = d.this.mAX - i2 > 0 || ((float) i2) < d.this.mAR / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mAL.getLayoutParams();
                if (i2 != d.this.mAX) {
                    int i3 = d.this.mAV - i2;
                    int i4 = (int) (i3 * d.this.mAZ);
                    if (i4 < d.this.mBa) {
                        i4 = d.this.mBa;
                        i3 = (int) (i4 / d.this.mAZ);
                    }
                    if (i4 != d.this.mBa) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mAL.setLayoutParams(layoutParams);
                    }
                    d.this.mAX = i2;
                    d.this.mAL.setTranslationY(d.this.mAX);
                }
                if (i != d.this.mAX) {
                    d.this.mAY = i;
                    d.this.mAL.setTranslationX(d.this.mAY + ((d.this.mAS - layoutParams.width) / 2.0f));
                }
                d.this.mAJ.setAlpha((layoutParams.width - d.this.mBa) / (d.this.mAS - d.this.mBa));
                if (d.this.mAF.getVisibility() == 0) {
                    float f = d.this.mAR / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mAF.setAlpha(f2);
                }
            }
        }

        private void aV(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mAT -= 1000;
                z = true;
            } else {
                d.this.mAT += 1000;
                z = false;
            }
            int duration = d.this.gxn.getDuration();
            if (d.this.mAT < 0) {
                d.this.mAT = 0;
            } else if (d.this.mAT > duration) {
                d.this.mAT = duration;
            }
            String str = at.stringForVideoTime(d.this.mAT) + " / " + at.stringForVideoTime(duration);
            if (d.this.mAI != null) {
                d.this.mAI.E(z, str);
            }
            d.this.mAD.setCurrentDuration(d.this.mAT, false);
        }
    };
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mAw == d.this.mAu) {
                if (d.this.mbo == 4) {
                    d.this.dyC();
                    d.this.mAX = 0;
                    d.this.mAY = 0;
                } else {
                    d.this.mAw = -1;
                    if (d.this.mbo != 3) {
                        if (d.this.mAx != -1) {
                            d.this.Gf(d.this.mAx);
                            d.this.mAx = -1;
                        } else if (d.this.gxn.isPlaying()) {
                            d.this.Gf(d.this.mAn);
                        } else {
                            d.this.Gf(d.this.mAq);
                        }
                    } else {
                        d.this.mAD.setCurrentDuration(d.this.mAT, true);
                        if (d.this.mAT <= d.this.gxn.getDuration()) {
                            if (!d.this.gxn.isPlaying()) {
                                d.this.gxn.a(d.this.mBe);
                            }
                            d.this.Gf(d.this.mAn);
                        }
                    }
                }
                if (d.this.mAQ) {
                    String str = null;
                    if (d.this.mbo != 1) {
                        if (d.this.mbo != 2) {
                            if (d.this.mbo == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dW("tid", d.this.amM).w("fid", d.this.mFid));
                    }
                }
                d.this.mbo = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mBe = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dyn() {
            d.this.gxn.dyj();
            d.this.dyu();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dyo() {
            d.this.Gf(d.this.mAm);
            d.this.bPP();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cJ(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.mAR = l.getEquipmentHeight(this.mContext);
            this.mAS = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dta() {
        int i;
        int i2;
        int i3;
        this.mAE.au(this.amL, this.lDY);
        this.mAF.au(this.amL, this.lDY);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.amL) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
                i3 = dimension;
            } else if (this.lDY) {
                int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension2;
                i2 = dimension2;
                i3 = dimension2;
            } else {
                int dimension3 = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension3;
                i2 = dimension3;
                i3 = dimension3;
            }
            this.amG.setPadding(0, 0, i3, 0);
            this.mAC.setPadding(this.mAC.getPaddingLeft(), 0, i2, 0);
            this.mAB.setPadding(i, 0, 0, 0);
        }
    }

    public void dsZ() {
        if (this.amL) {
            this.mAp = 104;
            this.mAq = 8290;
        } else {
            this.mAp = 232;
            this.mAq = 8418;
        }
        if (this.lDY) {
            this.mAm |= 1024;
            this.mAn |= 1024;
            this.mAo |= 1024;
            this.mAp |= 1024;
            this.mAq |= 1024;
            this.mAr |= 1024;
            this.mAs |= 1024;
            this.mAt |= 1024;
            this.mAw |= 1024;
            return;
        }
        this.mAm &= -1025;
        this.mAn &= -1025;
        this.mAo &= -1025;
        this.mAp &= -1025;
        this.mAq &= -1025;
        this.mAr &= -1025;
        this.mAs &= -1025;
        this.mAt &= -1025;
        this.mAw &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mAL = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mAL);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.amC = (TbImageView) this.mAL.findViewById(R.id.video_thumbnail);
            this.mzT = this.mAL.findViewById(R.id.black_mask);
            this.mAz = (TBLottieAnimationView) this.mAL.findViewById(R.id.video_loading);
            this.amE = (ImageView) this.mAL.findViewById(R.id.video_play);
            this.mAA = (PercentSizeView) this.mAL.findViewById(R.id.video_media_controller_mask);
            this.amF = (ImageView) this.mAL.findViewById(R.id.video_pause);
            this.amG = (TextView) this.mAL.findViewById(R.id.video_play_count);
            this.amH = (TextView) this.mAL.findViewById(R.id.video_play_flag);
            this.amI = (TextView) this.mAL.findViewById(R.id.video_duration);
            this.mAB = (SwitchImageView) this.mAL.findViewById(R.id.video_mute);
            this.mAC = (SwitchImageView) this.mAL.findViewById(R.id.video_full_screen);
            this.mAD = (OperableVideoMediaControllerView) this.mAL.findViewById(R.id.video_media_controller);
            this.mAE = (OperableVideoNetworkStateTipView) this.mAL.findViewById(R.id.video_network_state_tip);
            this.mAF = (OperableVideoShareView) this.mAL.findViewById(R.id.video_share_view);
            this.mAH = this.mAL.findViewById(R.id.video_back_btn_mask);
            this.mAG = (ImageView) this.mAL.findViewById(R.id.video_full_screen_back);
            this.mAI = (VideoGestureView) this.mAL.findViewById(R.id.video_gesture);
            this.mAK = (OperableVideoErrorView) this.mAL.findViewById(R.id.video_error_layout);
            this.mAF.setVideoContainer(this);
            this.mAz.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mAz.setVisibility(8);
                    d.this.amE.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mAz.setAnimation(R.raw.lotti_video_loading);
            this.amE.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amE.setOnClickListener(this);
            this.mAB.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mAB.setState(1);
            this.mAB.setOnClickListener(this);
            this.amC.bFU();
            this.amC.setDrawCorner(false);
            this.amC.setPlaceHolder(3);
            com.baidu.tbadk.a.b.b.m(this.mzT, R.color.CAM_X0607);
            this.mAD.setOnSeekBarChangeListener(this.gft);
            this.mAA.setHeightPercent(0.583f);
            this.mAA.setBackgroundResource(R.drawable.video_mask_bg);
            this.mAC.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mAC.setState(0);
            this.mAC.setOnClickListener(this);
            this.amF.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amF.setOnClickListener(this);
            this.mAG.setOnClickListener(this);
            this.gxn = new TbCyberVideoView(this.mContext);
            this.gxn.setTryUseViewInSet(true);
            dyu();
            this.mAE.setPlayViewOnClickListener(this);
            this.mAL.setOnClickListener(null);
            this.mAL.setOnTouchListener(this.bPd);
            this.mAF.setOnTouchListener(this.bPd);
            this.mAK.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jmT);
            Gf(this.mAm);
            this.jGS = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dyu() {
        if (this.gxn != null && this.gxn.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mAL.addView(this.gxn.getView(), 0);
            this.gxn.getView().setLayoutParams(layoutParams);
            this.mAD.setPlayer(this.gxn);
            this.gxn.setContinuePlayEnable(true);
            this.gxn.setOnPreparedListener(this);
            this.gxn.setOnCompletionListener(this);
            this.gxn.setOnErrorListener(this);
            this.gxn.setOnSurfaceDestroyedListener(this);
            this.gxn.setOnInfoListener(this);
            this.gxn.setVideoStatData(this.mAO);
            this.gxn.setThreadDataForStatistic(this.mAP);
            this.gxn.getMediaProgressObserver().a(this.mBd);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.bnO() != null) {
            this.startPosition = -1L;
            if (this.jGS != null) {
                this.jGS.reset();
            }
            if (!at.equals(this.mVideoUrl, bzVar.bnO().video_url)) {
                stopPlay();
                this.amL = bzVar.bnO().is_vertical.intValue() == 1;
                this.mVideoUrl = bzVar.bnO().video_url;
                this.amM = bzVar.getTid();
                this.amN = bzVar.bnO().video_length.intValue();
                this.mAN = bzVar.bnO().video_duration.intValue();
                this.mFid = bzVar.getFid();
                this.mBb = bzVar.bnO().mcn_ad_card;
                dsZ();
                dta();
                Gf(this.mAm);
                int intValue = bzVar.bnO().video_duration.intValue() * 1000;
                this.mAD.GX(intValue);
                this.mAD.setPlayer(this.gxn);
                this.amI.setText(at.stringForVideoTime(intValue));
                this.amG.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bzVar.bnO().play_count.intValue())));
                this.mAE.setVideoLength(bzVar.bnO().video_length.intValue());
                this.mAE.setVideoDuration(bzVar.bnO().video_duration.intValue());
                this.mAE.setTid(this.amM);
                this.mAP = bzVar;
                this.gxn.setThreadDataForStatistic(bzVar);
                this.amH.setVisibility(8);
                this.amC.setPlaceHolder(3);
                this.amC.startLoad(bzVar.bnO().thumbnail_url, 10, false);
                this.mAF.setShareData(bzVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gxn != null) {
            this.mAO = oVar;
            this.gxn.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ae(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void GZ(int i) {
        this.gxn.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agN = bdUniqueId;
    }

    public void dyv() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mAy);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mAy, this.mzX);
    }

    public void dyw() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mAy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPP() {
        this.mAz.setAlpha(1.0f);
        this.mAz.setVisibility(0);
        this.amE.setVisibility(8);
        if (this.mAz != null) {
            this.mAz.loop(true);
            this.mAz.setMinAndMaxFrame(14, 80);
            this.mAz.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dsX() {
        if (this.mAw == this.mAo) {
            Gf(this.mAn);
        }
    }

    private void dyx() {
        Gf(this.mAo);
        this.mAD.showProgress();
        if (this.mAz != null) {
            this.mAz.clearAnimation();
            this.mAz.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dsX();
                    if (!d.this.mAM) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mAz.setVisibility(8);
                    d.this.amE.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dyy() {
        return this.mAE != null && this.mAE.dth();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.ajq = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dyy()) {
                Gf(this.mAt);
                return;
            }
            this.mAM = true;
            if (!this.gxn.isPlaying()) {
                TbCyberVideoView PN = TbVideoViewSet.dym().PN(this.mVideoUrl);
                if (PN == null) {
                    this.gxn.dyj();
                    if (!StringUtils.isNull(this.gxn.getOriginUrl())) {
                        this.gxn = new TbCyberVideoView(this.mContext);
                        this.gxn.setTryUseViewInSet(true);
                    }
                    dyu();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gxn.setVideoDuration(this.mAN);
                        this.gxn.setVideoPath(this.mVideoUrl, this.amM);
                        this.gxn.setStageType(this.ajq);
                        bPP();
                        if (this.mAQ) {
                            dtf();
                        }
                    }
                } else {
                    if (this.gxn == PN) {
                        if (this.gxn.getParent() == null || this.gxn.getParent() != PN.getParent()) {
                            this.gxn.dyj();
                            dyu();
                        }
                    } else {
                        this.gxn.dyj();
                        PN.dyj();
                        this.gxn = PN;
                        this.gxn.setTryUseViewInSet(true);
                        dyu();
                    }
                    this.gxn.dyk();
                    onPrepared();
                    dyD();
                    if (this.mAQ) {
                        dtf();
                    }
                }
                if (this.mAQ) {
                    TiebaStatic.log(new aq("c13357").dW("tid", this.amM).w("fid", this.mFid).an("obj_type", this.amL ? 1 : 2).an("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).an("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mAM = false;
        if (this.mAz != null) {
            this.mAz.cancelAnimation();
        }
        this.gxn.stop();
        this.gxn.dyj();
        this.mAD.aQY();
        Gf(this.mAm);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mAM = false;
        if (this.mAz != null) {
            this.mAz.cancelAnimation();
        }
        this.gxn.stop();
        this.mAD.aQY();
        Gf(this.mAm);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dtf() {
        if (this.mAO != null) {
            o dxZ = this.mAO.dxZ();
            dxZ.mLocate = this.mFrom;
            h.a(dxZ.mzc, "", "1", dxZ, this.gxn.getPcdnState());
        }
    }

    public void Gf(int i) {
        dyw();
        if (this.mAw == this.mAu) {
            this.mAx = i;
            return;
        }
        this.mAw = i;
        this.amC.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mzT.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mAz.clearAnimation();
        this.mAz.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mAz.cancelAnimation();
        } else {
            this.mAz.setAlpha(1.0f);
        }
        this.amE.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.amF.setVisibility((i & 8) > 0 ? 0 : 8);
        this.amG.setVisibility((i & 16) > 0 ? 0 : 8);
        this.amI.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mAB.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mAC.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mAD.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mAA.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mAD.getVisibility() == 0) {
            this.mAD.showProgress();
        }
        this.mAE.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mAF.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mAF.getVisibility() == 0) {
            this.mAF.setAlpha(1.0f);
        }
        this.mAG.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mAH.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mAI.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mAK.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Gg(id);
            if (id == R.id.video_mute) {
                dyA();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dyC();
            } else if (id == R.id.video_replay) {
                Gf(this.mAm);
                startPlay();
                if (this.mAQ) {
                    TiebaStatic.log(new aq("c13345").dW("tid", this.amM).w("fid", this.mFid).an("obj_type", this.amL ? 1 : 2).an("obj_locate", this.lDY ? 1 : 2));
                }
                dyz();
            } else if (id == R.id.video_play) {
                if (this.mAw == this.mAm) {
                    startPlay();
                } else {
                    Gf(this.mAp);
                    dyv();
                    this.gxn.a(this.mBe);
                }
                if (this.mAQ) {
                    TiebaStatic.log(new aq("c13344").dW("tid", this.amM).w("fid", this.mFid).an("obj_type", this.amL ? 1 : 2).an("obj_source", this.lDY ? 1 : 2).an("obj_locate", 1));
                }
                dyz();
            } else if (id == R.id.video_pause) {
                Gf(this.mAq);
                dyw();
                this.gxn.pause();
                if (this.mAQ) {
                    TiebaStatic.log(new aq("c13344").dW("tid", this.amM).w("fid", this.mFid).an("obj_type", this.amL ? 1 : 2).an("obj_source", this.lDY ? 1 : 2).an("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Gf(this.mAm);
                startPlay();
            } else if (id == R.id.retry) {
                Gf(this.mAm);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyz() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.agN);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gxn.setVolume(0.0f, 0.0f);
            this.mAB.setState(1);
            return;
        }
        this.gxn.setVolume(1.0f, 1.0f);
        this.mAB.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dyA() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gxn.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
            this.mAB.setState(0);
        } else {
            this.gxn.setVolume(0.0f, 0.0f);
            this.mAB.setState(1);
            ah.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void wX(boolean z) {
        if (this.kVi == null) {
            this.kVi = new j((Activity) this.mContext);
        }
        if (z) {
            this.kVi.start();
            this.kVi.cZ(true);
            return;
        }
        this.kVi.stop();
        this.kVi.cZ(false);
    }

    public void dyB() {
        wg(true);
    }

    public void wg(boolean z) {
        if (this.mRootView != null && this.mAL != null && this.gxn != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kVi == null) {
                this.kVi = new j((Activity) this.mContext);
            }
            if (this.lDY) {
                if (this.mAJ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mAJ.getParent()).removeView(this.mAJ);
                }
                if ((this.mAL.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lDY = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mAL.getParent()).removeView(this.mAL);
                    ((ViewGroup) this.mRootView).addView(this.mAL);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lDY);
                }
                if (!this.amL && z) {
                    this.kVi.Ss();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.amL && z) {
                        this.kVi.Ss();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mAL.getLocationOnScreen(this.mAU);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mAJ == null) {
                                    this.mAJ = new View(this.mContext);
                                    this.mAJ.setClickable(true);
                                    this.mAJ.setBackgroundColor(ao.getColor(R.color.black_alpha100));
                                    this.mAJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mAJ.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mAJ.getParent()).removeView(this.mAJ);
                                }
                                this.mAJ.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mAJ);
                                ((ViewGroup) childAt).addView(this.mAL);
                                this.isChangingOrientation = false;
                                this.lDY = true;
                                k((Activity) this.mContext, this.lDY);
                                if (this.jGS != null && this.jGS.isShowing()) {
                                    this.jGS.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mAQ) {
                    TiebaStatic.log(new aq("c13360").dW("tid", this.amM).w("fid", this.mFid).an("obj_type", this.amL ? 1 : 2));
                }
            }
            dsZ();
            dta();
            if (this.gxn.isPlaying()) {
                Gf(this.mAn);
            } else {
                Gf(this.mAw);
            }
            this.mAC.dTT();
            wY(this.lDY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyC() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.amL) {
            dyB();
        } else if (this.mAw == this.mAu) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mAL.setScaleX(1.0f);
                    d.this.mAL.setScaleY(1.0f);
                    d.this.mAL.setTranslationX(0.0f);
                    d.this.mAL.setTranslationY(0.0f);
                    d.this.mAF.setScaleX(1.0f);
                    d.this.mAF.setScaleY(1.0f);
                    d.this.mAL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mAW) {
                        d.this.dyB();
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
            if (!this.mAW) {
                float width = this.mRootView.getWidth() / this.mAL.getWidth();
                float height = this.mRootView.getHeight() / this.mAL.getHeight();
                this.mAL.setPivotX(0.0f);
                this.mAL.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mAL, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mAL, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mAF, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mAF, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mAL, "TranslationX", this.mAL.getTranslationX(), this.mAU[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mAL, "TranslationY", this.mAL.getTranslationY(), this.mAU[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mAJ, "alpha", this.mAJ.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mAF, "alpha", this.mAF.getAlpha(), 0.0f);
            } else {
                float width2 = this.mAS / this.mAL.getWidth();
                float height2 = this.mAV / this.mAL.getHeight();
                this.mAL.setPivotX(0.0f);
                this.mAL.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mAL, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mAL, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mAF, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mAF, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mAL, "TranslationX", this.mAL.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mAL, "TranslationY", this.mAL.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mAF, "alpha", this.mAF.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mAx != -1) {
                this.mAw = this.mAx;
                this.mAx = -1;
                if (this.mAw == this.mAv || this.mAw == this.mAp || this.mAw == this.mAn) {
                    this.gxn.a(this.mBe);
                    Gf(this.mAn);
                }
            }
        } else {
            dyB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.amL && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mAL != null) {
                    if (z) {
                        this.mAL.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mAL.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                dal();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mAL.setSystemUiVisibility(0);
            }
        }
    }

    private void dyD() {
        Gf(this.mAo);
        this.mAD.showProgress();
        dyx();
    }

    protected void wY(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mAM) {
            if (this.lDY && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gxn.a(this.mBe);
        }
    }

    public void onCompletion() {
        Gf(this.mAs);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Gf(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mAw == this.mAq || (this.mAw == this.mAr && !this.gxn.isPlaying())) {
                stopPlayForSurfaceDestroy();
                Gf(this.mAq);
            } else if (this.mAw == this.mAs) {
                stopPlayForSurfaceDestroy();
                Gf(this.mAs);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dyD();
        }
        if (i == 701) {
            bPP();
            return false;
        } else if (i == 702) {
            dyD();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dxG() {
        return this.mAL;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mAM || this.gxn.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gxn.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bVs() {
    }

    protected void Gg(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lDY;
    }

    protected boolean dsY() {
        return this.amL && this.lDY;
    }

    private void dal() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mAL.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mAL.setSystemUiVisibility(4);
        } else {
            this.mAL.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dtc() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gxn.isPlaying() && !ah.bFw()) {
            this.gxn.setVolume(1.0f, 1.0f);
            this.mAB.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dtd() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean sc(boolean z) {
        if (z) {
            this.mAz.cancelAnimation();
            if (this.mAw == this.mAn || this.mAw == this.mAo || this.mAw == this.mAp || this.mAw == this.mAm) {
                stopPlay();
            }
            this.mAw |= 1;
            Gf(this.mAw);
        } else if (this.mAw == this.mAm) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lDY;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dys() {
        if (this.lDY) {
            dyC();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cPR() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dyE() {
        return this.mBb != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wZ(boolean z) {
        this.agF = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mBc = aVar;
    }
}
