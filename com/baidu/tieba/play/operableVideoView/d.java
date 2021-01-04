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
    protected BdUniqueId ahE;
    private String akh;
    protected boolean anC;
    protected String anD;
    protected long anE;
    protected TbImageView ant;
    private ImageView anv;
    private ImageView anw;
    protected TextView anx;
    protected TextView any;
    private TextView anz;
    protected TbCyberVideoView gBU;
    private com.baidu.mcn.c jLy;
    private j kZN;
    protected Context mContext;
    private View mED;
    private float mFB;
    private float mFC;
    private int mFD;
    private int mFF;
    private boolean mFG;
    private float mFJ;
    private int mFK;
    private McnAdInfo mFL;
    private a mFM;
    protected long mFid;
    private TBLottieAnimationView mFj;
    private PercentSizeView mFk;
    protected SwitchImageView mFl;
    protected SwitchImageView mFm;
    protected OperableVideoMediaControllerView mFn;
    protected OperableVideoNetworkStateTipView mFo;
    protected OperableVideoShareView mFp;
    protected ImageView mFq;
    protected View mFr;
    protected String mFrom;
    protected VideoGestureView mFs;
    private View mFt;
    private OperableVideoErrorView mFu;
    protected ViewGroup mFv;
    protected boolean mFw;
    protected int mFx;
    protected o mFy;
    protected bz mFz;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int mEH = 3000;
    protected final int mEI = 1;
    protected final int mEJ = 2;
    protected final int mEK = 4;
    protected final int mEL = 8;
    protected final int mEM = 16;
    protected final int mEN = 32;
    protected final int mEO = 64;
    protected final int mEP = 128;
    protected final int mEQ = 256;
    protected final int mER = 512;
    protected final int mES = 1024;
    protected final int mET = 2048;
    protected final int mEU = 4096;
    protected final int mEV = 8192;
    protected int mEW = 8211;
    protected int mEX = 0;
    protected int mEY = 4;
    protected int mEZ = 232;
    protected int mFa = 8416;
    protected int mFb = 0;
    protected int mFc = 513;
    protected int mFd = 259;
    protected int mFe = 2048;
    protected int mFf = 0;
    protected int STATE_ERROR = 4099;
    protected int mFg = this.mEW;
    private int mfU = 0;
    private int mFh = -1;
    private Runnable mFi = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.HL(d.this.mEX);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lIE = false;
    protected boolean mFA = true;
    private boolean isChangingOrientation = false;
    private int[] mFE = new int[2];
    private int mFH = 0;
    private int mFI = 0;
    protected View.OnClickListener akV = null;
    protected View.OnClickListener ahj = null;
    private boolean ahw = false;
    private long startPosition = -1;
    private f.b mFN = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ch(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dCv() && !d.this.anC && !d.this.lIE && d.this.ahw) {
                if (!com.baidu.mcn.b.adu().jD(d.this.mFL.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mFL.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mFL.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mFL.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jLy.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.cio = d.this.mFL.card_title;
                            aVar.cip = d.this.mFL.button_title;
                            aVar.ciq = d.this.mFL.jump_url;
                            aVar.cin = d.this.mFL.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.anD;
                            aVar.cir = d.this.cTI();
                            if (z2) {
                                d.this.jLy.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jLy.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jLy.isShowing()) {
                        d.this.jLy.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mFM != null) {
                d.this.mFM.cJ(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gkb = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.HL(d.this.mEZ);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gBU.isPlaying()) {
                    d.this.gBU.a(d.this.mFO);
                }
                d.this.dCm();
                if (d.this.mFA) {
                    TiebaStatic.log(new aq("c13355").dX("tid", d.this.anD).w("fid", d.this.mFid).an("obj_type", d.this.anC ? 1 : 2).an("obj_locate", d.this.lIE ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jrz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gBU.isPlaying()) {
                d.this.gBU.pause();
                if (d.this.mFg == d.this.mEZ) {
                    d.this.HL(d.this.mFa);
                } else {
                    d.this.HL(d.this.mFb);
                }
                d.this.HM(R.id.video_pause);
            } else if (d.this.mFg == d.this.mFa || d.this.mFg == (d.this.mFa | 1)) {
                d.this.HL(d.this.mEZ);
                d.this.dCm();
                d.this.gBU.a(d.this.mFO);
                d.this.HM(R.id.video_play);
            } else if (d.this.mFg == d.this.mFb || d.this.mFg == (d.this.mFb | 1)) {
                d.this.HL(d.this.mEX);
                d.this.gBU.a(d.this.mFO);
                d.this.HM(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gBU.isPlaying()) {
                if (d.this.mFg == d.this.mEX || d.this.mFg == d.this.mEY) {
                    d.this.HL(d.this.mEZ);
                    d.this.dCm();
                    return true;
                } else if (d.this.mFg == d.this.mEZ) {
                    d.this.HL(d.this.mEX);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mFg == d.this.mFa) {
                d.this.HL(d.this.mFb);
                return true;
            } else if (d.this.mFg == (d.this.mFa | 1)) {
                d.this.HL(d.this.mFb | 1);
                return true;
            } else if (d.this.mFg == d.this.mFb) {
                d.this.HL(d.this.mFa);
                return true;
            } else if (d.this.mFg == (d.this.mFb | 1)) {
                d.this.HL(d.this.mFa | 1);
                return true;
            } else {
                d.this.HL(d.this.mEW);
                d.this.startPlay();
                d.this.dCq();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.mfU = 0;
            if (d.this.lIE) {
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
            if (d.this.anC && d.this.dwP()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.mfU) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gBU.isPlaying()) {
                                d.this.gBU.pause();
                                d.this.HL(d.this.mFf);
                            }
                            d.this.mfU = 4;
                            d.this.mFh = d.this.mFg;
                            d.this.mFg = d.this.mFe;
                            d.this.mFF = d.this.mFv.getMeasuredHeight();
                            d.this.mFJ = d.this.mFC / d.this.mFF;
                            d.this.mFK = (int) (1.2f * d.this.mRootView.getWidth());
                            di(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        di(rawX, rawY);
                        break;
                }
            } else if (d.this.mFg == d.this.mEX || d.this.mFg == d.this.mEZ || d.this.mFg == d.this.mFa || d.this.mFg == d.this.mFb || d.this.mFg == d.this.mFe || d.this.mFg == (d.this.mFa | 1) || d.this.mFg == (d.this.mFb | 1)) {
                switch (d.this.mfU) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.mfU = 3;
                            d.this.mFD = d.this.gBU.getCurrentPosition();
                            aV(f);
                        } else if (motionEvent.getX() < d.this.mFv.getWidth() / 2) {
                            d.this.mfU = 2;
                            d.this.mFs.v(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.mfU = 1;
                            d.this.mFs.u(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mFg != d.this.mFe) {
                            if ((d.this.mFg & 1) > 0) {
                                d.this.mFe |= 1;
                            } else {
                                d.this.mFe &= -2;
                            }
                            d.this.HL(d.this.mFe);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mFs.u(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dwT();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mFs.v(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aV(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void di(int i, int i2) {
            if (d.this.mFH != i2 || d.this.mFI != i) {
                d.this.mFG = d.this.mFH - i2 > 0 || ((float) i2) < d.this.mFB / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mFv.getLayoutParams();
                if (i2 != d.this.mFH) {
                    int i3 = d.this.mFF - i2;
                    int i4 = (int) (i3 * d.this.mFJ);
                    if (i4 < d.this.mFK) {
                        i4 = d.this.mFK;
                        i3 = (int) (i4 / d.this.mFJ);
                    }
                    if (i4 != d.this.mFK) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mFv.setLayoutParams(layoutParams);
                    }
                    d.this.mFH = i2;
                    d.this.mFv.setTranslationY(d.this.mFH);
                }
                if (i != d.this.mFH) {
                    d.this.mFI = i;
                    d.this.mFv.setTranslationX(d.this.mFI + ((d.this.mFC - layoutParams.width) / 2.0f));
                }
                d.this.mFt.setAlpha((layoutParams.width - d.this.mFK) / (d.this.mFC - d.this.mFK));
                if (d.this.mFp.getVisibility() == 0) {
                    float f = d.this.mFB / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mFp.setAlpha(f2);
                }
            }
        }

        private void aV(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mFD -= 1000;
                z = true;
            } else {
                d.this.mFD += 1000;
                z = false;
            }
            int duration = d.this.gBU.getDuration();
            if (d.this.mFD < 0) {
                d.this.mFD = 0;
            } else if (d.this.mFD > duration) {
                d.this.mFD = duration;
            }
            String str = at.stringForVideoTime(d.this.mFD) + " / " + at.stringForVideoTime(duration);
            if (d.this.mFs != null) {
                d.this.mFs.E(z, str);
            }
            d.this.mFn.setCurrentDuration(d.this.mFD, false);
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mFg == d.this.mFe) {
                if (d.this.mfU == 4) {
                    d.this.dCt();
                    d.this.mFH = 0;
                    d.this.mFI = 0;
                } else {
                    d.this.mFg = -1;
                    if (d.this.mfU != 3) {
                        if (d.this.mFh != -1) {
                            d.this.HL(d.this.mFh);
                            d.this.mFh = -1;
                        } else if (d.this.gBU.isPlaying()) {
                            d.this.HL(d.this.mEX);
                        } else {
                            d.this.HL(d.this.mFa);
                        }
                    } else {
                        d.this.mFn.setCurrentDuration(d.this.mFD, true);
                        if (d.this.mFD <= d.this.gBU.getDuration()) {
                            if (!d.this.gBU.isPlaying()) {
                                d.this.gBU.a(d.this.mFO);
                            }
                            d.this.HL(d.this.mEX);
                        }
                    }
                }
                if (d.this.mFA) {
                    String str = null;
                    if (d.this.mfU != 1) {
                        if (d.this.mfU != 2) {
                            if (d.this.mfU == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dX("tid", d.this.anD).w("fid", d.this.mFid));
                    }
                }
                d.this.mfU = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mFO = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCe() {
            d.this.gBU.dCa();
            d.this.dCl();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCf() {
            d.this.HL(d.this.mEW);
            d.this.bTG();
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
            this.mFB = l.getEquipmentHeight(this.mContext);
            this.mFC = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dwR() {
        int i;
        int i2;
        int i3;
        this.mFo.au(this.anC, this.lIE);
        this.mFp.au(this.anC, this.lIE);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.anC) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
                i3 = dimension;
            } else if (this.lIE) {
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
            this.anx.setPadding(0, 0, i3, 0);
            this.mFm.setPadding(this.mFm.getPaddingLeft(), 0, i2, 0);
            this.mFl.setPadding(i, 0, 0, 0);
        }
    }

    public void dwQ() {
        if (this.anC) {
            this.mEZ = 104;
            this.mFa = 8290;
        } else {
            this.mEZ = 232;
            this.mFa = 8418;
        }
        if (this.lIE) {
            this.mEW |= 1024;
            this.mEX |= 1024;
            this.mEY |= 1024;
            this.mEZ |= 1024;
            this.mFa |= 1024;
            this.mFb |= 1024;
            this.mFc |= 1024;
            this.mFd |= 1024;
            this.mFg |= 1024;
            return;
        }
        this.mEW &= -1025;
        this.mEX &= -1025;
        this.mEY &= -1025;
        this.mEZ &= -1025;
        this.mFa &= -1025;
        this.mFb &= -1025;
        this.mFc &= -1025;
        this.mFd &= -1025;
        this.mFg &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mFv = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mFv);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ant = (TbImageView) this.mFv.findViewById(R.id.video_thumbnail);
            this.mED = this.mFv.findViewById(R.id.black_mask);
            this.mFj = (TBLottieAnimationView) this.mFv.findViewById(R.id.video_loading);
            this.anv = (ImageView) this.mFv.findViewById(R.id.video_play);
            this.mFk = (PercentSizeView) this.mFv.findViewById(R.id.video_media_controller_mask);
            this.anw = (ImageView) this.mFv.findViewById(R.id.video_pause);
            this.anx = (TextView) this.mFv.findViewById(R.id.video_play_count);
            this.any = (TextView) this.mFv.findViewById(R.id.video_play_flag);
            this.anz = (TextView) this.mFv.findViewById(R.id.video_duration);
            this.mFl = (SwitchImageView) this.mFv.findViewById(R.id.video_mute);
            this.mFm = (SwitchImageView) this.mFv.findViewById(R.id.video_full_screen);
            this.mFn = (OperableVideoMediaControllerView) this.mFv.findViewById(R.id.video_media_controller);
            this.mFo = (OperableVideoNetworkStateTipView) this.mFv.findViewById(R.id.video_network_state_tip);
            this.mFp = (OperableVideoShareView) this.mFv.findViewById(R.id.video_share_view);
            this.mFr = this.mFv.findViewById(R.id.video_back_btn_mask);
            this.mFq = (ImageView) this.mFv.findViewById(R.id.video_full_screen_back);
            this.mFs = (VideoGestureView) this.mFv.findViewById(R.id.video_gesture);
            this.mFu = (OperableVideoErrorView) this.mFv.findViewById(R.id.video_error_layout);
            this.mFp.setVideoContainer(this);
            this.mFj.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mFj.setVisibility(8);
                    d.this.anv.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mFj.setAnimation(R.raw.lotti_video_loading);
            this.anv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anv.setOnClickListener(this);
            this.mFl.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mFl.setState(1);
            this.mFl.setOnClickListener(this);
            this.ant.bJL();
            this.ant.setDrawCorner(false);
            this.ant.setPlaceHolder(3);
            com.baidu.tbadk.a.b.b.m(this.mED, R.color.CAM_X0607);
            this.mFn.setOnSeekBarChangeListener(this.gkb);
            this.mFk.setHeightPercent(0.583f);
            this.mFk.setBackgroundResource(R.drawable.video_mask_bg);
            this.mFm.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mFm.setState(0);
            this.mFm.setOnClickListener(this);
            this.anw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anw.setOnClickListener(this);
            this.mFq.setOnClickListener(this);
            this.gBU = new TbCyberVideoView(this.mContext);
            this.gBU.setTryUseViewInSet(true);
            dCl();
            this.mFo.setPlayViewOnClickListener(this);
            this.mFv.setOnClickListener(null);
            this.mFv.setOnTouchListener(this.bTP);
            this.mFp.setOnTouchListener(this.bTP);
            this.mFu.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jrz);
            HL(this.mEW);
            this.jLy = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dCl() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mFv.addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
            this.mFn.setPlayer(this.gBU);
            this.gBU.setContinuePlayEnable(true);
            this.gBU.setOnPreparedListener(this);
            this.gBU.setOnCompletionListener(this);
            this.gBU.setOnErrorListener(this);
            this.gBU.setOnSurfaceDestroyedListener(this);
            this.gBU.setOnInfoListener(this);
            this.gBU.setVideoStatData(this.mFy);
            this.gBU.setThreadDataForStatistic(this.mFz);
            this.gBU.getMediaProgressObserver().a(this.mFN);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.brH() != null) {
            this.startPosition = -1L;
            if (this.jLy != null) {
                this.jLy.reset();
            }
            if (!at.equals(this.mVideoUrl, bzVar.brH().video_url)) {
                stopPlay();
                this.anC = bzVar.brH().is_vertical.intValue() == 1;
                this.mVideoUrl = bzVar.brH().video_url;
                this.anD = bzVar.getTid();
                this.anE = bzVar.brH().video_length.intValue();
                this.mFx = bzVar.brH().video_duration.intValue();
                this.mFid = bzVar.getFid();
                this.mFL = bzVar.brH().mcn_ad_card;
                dwQ();
                dwR();
                HL(this.mEW);
                int intValue = bzVar.brH().video_duration.intValue() * 1000;
                this.mFn.IE(intValue);
                this.mFn.setPlayer(this.gBU);
                this.anz.setText(at.stringForVideoTime(intValue));
                this.anx.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bzVar.brH().play_count.intValue())));
                this.mFo.setVideoLength(bzVar.brH().video_length.intValue());
                this.mFo.setVideoDuration(bzVar.brH().video_duration.intValue());
                this.mFo.setTid(this.anD);
                this.mFz = bzVar;
                this.gBU.setThreadDataForStatistic(bzVar);
                this.any.setVisibility(8);
                this.ant.setPlaceHolder(3);
                this.ant.startLoad(bzVar.brH().thumbnail_url, 10, false);
                this.mFp.setShareData(bzVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gBU != null) {
            this.mFy = oVar;
            this.gBU.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ae(View.OnClickListener onClickListener) {
        this.ahj = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void IG(int i) {
        this.gBU.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahE = bdUniqueId;
    }

    public void dCm() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mFi);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mFi, this.mEH);
    }

    public void dCn() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mFi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTG() {
        this.mFj.setAlpha(1.0f);
        this.mFj.setVisibility(0);
        this.anv.setVisibility(8);
        if (this.mFj != null) {
            this.mFj.loop(true);
            this.mFj.setMinAndMaxFrame(14, 80);
            this.mFj.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwO() {
        if (this.mFg == this.mEY) {
            HL(this.mEX);
        }
    }

    private void dCo() {
        HL(this.mEY);
        this.mFn.showProgress();
        if (this.mFj != null) {
            this.mFj.clearAnimation();
            this.mFj.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dwO();
                    if (!d.this.mFw) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mFj.setVisibility(8);
                    d.this.anv.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dCp() {
        return this.mFo != null && this.mFo.dwY();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.akh = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dCp()) {
                HL(this.mFd);
                return;
            }
            this.mFw = true;
            if (!this.gBU.isPlaying()) {
                TbCyberVideoView QW = TbVideoViewSet.dCd().QW(this.mVideoUrl);
                if (QW == null) {
                    this.gBU.dCa();
                    if (!StringUtils.isNull(this.gBU.getOriginUrl())) {
                        this.gBU = new TbCyberVideoView(this.mContext);
                        this.gBU.setTryUseViewInSet(true);
                    }
                    dCl();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gBU.setVideoDuration(this.mFx);
                        this.gBU.setVideoPath(this.mVideoUrl, this.anD);
                        this.gBU.setStageType(this.akh);
                        bTG();
                        if (this.mFA) {
                            dwW();
                        }
                    }
                } else {
                    if (this.gBU == QW) {
                        if (this.gBU.getParent() == null || this.gBU.getParent() != QW.getParent()) {
                            this.gBU.dCa();
                            dCl();
                        }
                    } else {
                        this.gBU.dCa();
                        QW.dCa();
                        this.gBU = QW;
                        this.gBU.setTryUseViewInSet(true);
                        dCl();
                    }
                    this.gBU.dCb();
                    onPrepared();
                    dCu();
                    if (this.mFA) {
                        dwW();
                    }
                }
                if (this.mFA) {
                    TiebaStatic.log(new aq("c13357").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).an("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mFw = false;
        if (this.mFj != null) {
            this.mFj.cancelAnimation();
        }
        this.gBU.stop();
        this.gBU.dCa();
        this.mFn.aUR();
        HL(this.mEW);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mFw = false;
        if (this.mFj != null) {
            this.mFj.cancelAnimation();
        }
        this.gBU.stop();
        this.mFn.aUR();
        HL(this.mEW);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dwW() {
        if (this.mFy != null) {
            o dBQ = this.mFy.dBQ();
            dBQ.mLocate = this.mFrom;
            h.a(dBQ.mDM, "", "1", dBQ, this.gBU.getPcdnState());
        }
    }

    public void HL(int i) {
        dCn();
        if (this.mFg == this.mFe) {
            this.mFh = i;
            return;
        }
        this.mFg = i;
        this.ant.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mED.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mFj.clearAnimation();
        this.mFj.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mFj.cancelAnimation();
        } else {
            this.mFj.setAlpha(1.0f);
        }
        this.anv.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.anw.setVisibility((i & 8) > 0 ? 0 : 8);
        this.anx.setVisibility((i & 16) > 0 ? 0 : 8);
        this.anz.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mFl.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mFm.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mFn.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mFk.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mFn.getVisibility() == 0) {
            this.mFn.showProgress();
        }
        this.mFo.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mFp.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mFp.getVisibility() == 0) {
            this.mFp.setAlpha(1.0f);
        }
        this.mFq.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mFr.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mFs.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mFu.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            HM(id);
            if (id == R.id.video_mute) {
                dCr();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dCt();
            } else if (id == R.id.video_replay) {
                HL(this.mEW);
                startPlay();
                if (this.mFA) {
                    TiebaStatic.log(new aq("c13345").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_locate", this.lIE ? 1 : 2));
                }
                dCq();
            } else if (id == R.id.video_play) {
                if (this.mFg == this.mEW) {
                    startPlay();
                } else {
                    HL(this.mEZ);
                    dCm();
                    this.gBU.a(this.mFO);
                }
                if (this.mFA) {
                    TiebaStatic.log(new aq("c13344").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_source", this.lIE ? 1 : 2).an("obj_locate", 1));
                }
                dCq();
            } else if (id == R.id.video_pause) {
                HL(this.mFa);
                dCn();
                this.gBU.pause();
                if (this.mFA) {
                    TiebaStatic.log(new aq("c13344").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_source", this.lIE ? 1 : 2).an("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                HL(this.mEW);
                startPlay();
            } else if (id == R.id.retry) {
                HL(this.mEW);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCq() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ahE);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gBU.setVolume(0.0f, 0.0f);
            this.mFl.setState(1);
            return;
        }
        this.gBU.setVolume(1.0f, 1.0f);
        this.mFl.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCr() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gBU.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
            this.mFl.setState(0);
        } else {
            this.gBU.setVolume(0.0f, 0.0f);
            this.mFl.setState(1);
            ah.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void xb(boolean z) {
        if (this.kZN == null) {
            this.kZN = new j((Activity) this.mContext);
        }
        if (z) {
            this.kZN.start();
            this.kZN.dd(true);
            return;
        }
        this.kZN.stop();
        this.kZN.dd(false);
    }

    public void dCs() {
        wk(true);
    }

    public void wk(boolean z) {
        if (this.mRootView != null && this.mFv != null && this.gBU != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kZN == null) {
                this.kZN = new j((Activity) this.mContext);
            }
            if (this.lIE) {
                if (this.mFt.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mFt.getParent()).removeView(this.mFt);
                }
                if ((this.mFv.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lIE = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mFv.getParent()).removeView(this.mFv);
                    ((ViewGroup) this.mRootView).addView(this.mFv);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lIE);
                }
                if (!this.anC && z) {
                    this.kZN.Wl();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.anC && z) {
                        this.kZN.Wl();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mFv.getLocationOnScreen(this.mFE);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mFt == null) {
                                    this.mFt = new View(this.mContext);
                                    this.mFt.setClickable(true);
                                    this.mFt.setBackgroundColor(ao.getColor(R.color.black_alpha100));
                                    this.mFt.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mFt.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mFt.getParent()).removeView(this.mFt);
                                }
                                this.mFt.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mFt);
                                ((ViewGroup) childAt).addView(this.mFv);
                                this.isChangingOrientation = false;
                                this.lIE = true;
                                k((Activity) this.mContext, this.lIE);
                                if (this.jLy != null && this.jLy.isShowing()) {
                                    this.jLy.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mFA) {
                    TiebaStatic.log(new aq("c13360").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2));
                }
            }
            dwQ();
            dwR();
            if (this.gBU.isPlaying()) {
                HL(this.mEX);
            } else {
                HL(this.mFg);
            }
            this.mFm.dXK();
            xc(this.lIE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCt() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.anC) {
            dCs();
        } else if (this.mFg == this.mFe) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mFv.setScaleX(1.0f);
                    d.this.mFv.setScaleY(1.0f);
                    d.this.mFv.setTranslationX(0.0f);
                    d.this.mFv.setTranslationY(0.0f);
                    d.this.mFp.setScaleX(1.0f);
                    d.this.mFp.setScaleY(1.0f);
                    d.this.mFv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mFG) {
                        d.this.dCs();
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
            if (!this.mFG) {
                float width = this.mRootView.getWidth() / this.mFv.getWidth();
                float height = this.mRootView.getHeight() / this.mFv.getHeight();
                this.mFv.setPivotX(0.0f);
                this.mFv.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mFv, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mFv, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mFp, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mFp, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mFv, "TranslationX", this.mFv.getTranslationX(), this.mFE[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mFv, "TranslationY", this.mFv.getTranslationY(), this.mFE[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mFt, "alpha", this.mFt.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mFp, "alpha", this.mFp.getAlpha(), 0.0f);
            } else {
                float width2 = this.mFC / this.mFv.getWidth();
                float height2 = this.mFF / this.mFv.getHeight();
                this.mFv.setPivotX(0.0f);
                this.mFv.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mFv, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mFv, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mFp, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mFp, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mFv, "TranslationX", this.mFv.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mFv, "TranslationY", this.mFv.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mFp, "alpha", this.mFp.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mFh != -1) {
                this.mFg = this.mFh;
                this.mFh = -1;
                if (this.mFg == this.mFf || this.mFg == this.mEZ || this.mFg == this.mEX) {
                    this.gBU.a(this.mFO);
                    HL(this.mEX);
                }
            }
        } else {
            dCs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.anC && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mFv != null) {
                    if (z) {
                        this.mFv.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mFv.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                dec();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mFv.setSystemUiVisibility(0);
            }
        }
    }

    private void dCu() {
        HL(this.mEY);
        this.mFn.showProgress();
        dCo();
    }

    protected void xc(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mFw) {
            if (this.lIE && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gBU.a(this.mFO);
        }
    }

    public void onCompletion() {
        HL(this.mFc);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        HL(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mFg == this.mFa || (this.mFg == this.mFb && !this.gBU.isPlaying())) {
                stopPlayForSurfaceDestroy();
                HL(this.mFa);
            } else if (this.mFg == this.mFc) {
                stopPlayForSurfaceDestroy();
                HL(this.mFc);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dCu();
        }
        if (i == 701) {
            bTG();
            return false;
        } else if (i == 702) {
            dCu();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dBx() {
        return this.mFv;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mFw || this.gBU.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gBU.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bZj() {
    }

    protected void HM(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lIE;
    }

    protected boolean dwP() {
        return this.anC && this.lIE;
    }

    private void dec() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mFv.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mFv.setSystemUiVisibility(4);
        } else {
            this.mFv.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dwT() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gBU.isPlaying() && !ah.bJn()) {
            this.gBU.setVolume(1.0f, 1.0f);
            this.mFl.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dwU() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean sg(boolean z) {
        if (z) {
            this.mFj.cancelAnimation();
            if (this.mFg == this.mEX || this.mFg == this.mEY || this.mFg == this.mEZ || this.mFg == this.mEW) {
                stopPlay();
            }
            this.mFg |= 1;
            HL(this.mFg);
        } else if (this.mFg == this.mEW) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lIE;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dCj() {
        if (this.lIE) {
            dCt();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cTI() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dCv() {
        return this.mFL != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xd(boolean z) {
        this.ahw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mFM = aVar;
    }
}
