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
    private View mEC;
    private float mFA;
    private float mFB;
    private int mFC;
    private int mFE;
    private boolean mFF;
    private float mFI;
    private int mFJ;
    private McnAdInfo mFK;
    private a mFL;
    private TBLottieAnimationView mFi;
    protected long mFid;
    private PercentSizeView mFj;
    protected SwitchImageView mFk;
    protected SwitchImageView mFl;
    protected OperableVideoMediaControllerView mFm;
    protected OperableVideoNetworkStateTipView mFn;
    protected OperableVideoShareView mFo;
    protected ImageView mFp;
    protected View mFq;
    protected VideoGestureView mFr;
    protected String mFrom;
    private View mFs;
    private OperableVideoErrorView mFt;
    protected ViewGroup mFu;
    protected boolean mFv;
    protected int mFw;
    protected o mFx;
    protected bz mFy;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int mEG = 3000;
    protected final int mEH = 1;
    protected final int mEI = 2;
    protected final int mEJ = 4;
    protected final int mEK = 8;
    protected final int mEL = 16;
    protected final int mEM = 32;
    protected final int mEN = 64;
    protected final int mEO = 128;
    protected final int mEP = 256;
    protected final int mEQ = 512;
    protected final int mER = 1024;
    protected final int mES = 2048;
    protected final int mET = 4096;
    protected final int mEU = 8192;
    protected int mEV = 8211;
    protected int mEW = 0;
    protected int mEX = 4;
    protected int mEY = 232;
    protected int mEZ = 8416;
    protected int mFa = 0;
    protected int mFb = 513;
    protected int mFc = 259;
    protected int mFd = 2048;
    protected int mFe = 0;
    protected int STATE_ERROR = 4099;
    protected int mFf = this.mEV;
    private int mfT = 0;
    private int mFg = -1;
    private Runnable mFh = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.HL(d.this.mEW);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lID = false;
    protected boolean mFz = true;
    private boolean isChangingOrientation = false;
    private int[] mFD = new int[2];
    private int mFG = 0;
    private int mFH = 0;
    protected View.OnClickListener akV = null;
    protected View.OnClickListener ahj = null;
    private boolean ahw = false;
    private long startPosition = -1;
    private f.b mFM = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ch(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dCw() && !d.this.anC && !d.this.lID && d.this.ahw) {
                if (!com.baidu.mcn.b.adv().jD(d.this.mFK.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mFK.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mFK.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mFK.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jLy.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.cio = d.this.mFK.card_title;
                            aVar.cip = d.this.mFK.button_title;
                            aVar.ciq = d.this.mFK.jump_url;
                            aVar.cin = d.this.mFK.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.anD;
                            aVar.cir = d.this.cTJ();
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
            if (d.this.mFL != null) {
                d.this.mFL.cJ(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gkb = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.HL(d.this.mEY);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gBU.isPlaying()) {
                    d.this.gBU.a(d.this.mFN);
                }
                d.this.dCn();
                if (d.this.mFz) {
                    TiebaStatic.log(new aq("c13355").dX("tid", d.this.anD).w("fid", d.this.mFid).an("obj_type", d.this.anC ? 1 : 2).an("obj_locate", d.this.lID ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jrz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gBU.isPlaying()) {
                d.this.gBU.pause();
                if (d.this.mFf == d.this.mEY) {
                    d.this.HL(d.this.mEZ);
                } else {
                    d.this.HL(d.this.mFa);
                }
                d.this.HM(R.id.video_pause);
            } else if (d.this.mFf == d.this.mEZ || d.this.mFf == (d.this.mEZ | 1)) {
                d.this.HL(d.this.mEY);
                d.this.dCn();
                d.this.gBU.a(d.this.mFN);
                d.this.HM(R.id.video_play);
            } else if (d.this.mFf == d.this.mFa || d.this.mFf == (d.this.mFa | 1)) {
                d.this.HL(d.this.mEW);
                d.this.gBU.a(d.this.mFN);
                d.this.HM(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gBU.isPlaying()) {
                if (d.this.mFf == d.this.mEW || d.this.mFf == d.this.mEX) {
                    d.this.HL(d.this.mEY);
                    d.this.dCn();
                    return true;
                } else if (d.this.mFf == d.this.mEY) {
                    d.this.HL(d.this.mEW);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mFf == d.this.mEZ) {
                d.this.HL(d.this.mFa);
                return true;
            } else if (d.this.mFf == (d.this.mEZ | 1)) {
                d.this.HL(d.this.mFa | 1);
                return true;
            } else if (d.this.mFf == d.this.mFa) {
                d.this.HL(d.this.mEZ);
                return true;
            } else if (d.this.mFf == (d.this.mFa | 1)) {
                d.this.HL(d.this.mEZ | 1);
                return true;
            } else {
                d.this.HL(d.this.mEV);
                d.this.startPlay();
                d.this.dCr();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.mfT = 0;
            if (d.this.lID) {
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
            if (d.this.anC && d.this.dwQ()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.mfT) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gBU.isPlaying()) {
                                d.this.gBU.pause();
                                d.this.HL(d.this.mFe);
                            }
                            d.this.mfT = 4;
                            d.this.mFg = d.this.mFf;
                            d.this.mFf = d.this.mFd;
                            d.this.mFE = d.this.mFu.getMeasuredHeight();
                            d.this.mFI = d.this.mFB / d.this.mFE;
                            d.this.mFJ = (int) (1.2f * d.this.mRootView.getWidth());
                            di(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        di(rawX, rawY);
                        break;
                }
            } else if (d.this.mFf == d.this.mEW || d.this.mFf == d.this.mEY || d.this.mFf == d.this.mEZ || d.this.mFf == d.this.mFa || d.this.mFf == d.this.mFd || d.this.mFf == (d.this.mEZ | 1) || d.this.mFf == (d.this.mFa | 1)) {
                switch (d.this.mfT) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.mfT = 3;
                            d.this.mFC = d.this.gBU.getCurrentPosition();
                            aV(f);
                        } else if (motionEvent.getX() < d.this.mFu.getWidth() / 2) {
                            d.this.mfT = 2;
                            d.this.mFr.v(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.mfT = 1;
                            d.this.mFr.u(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mFf != d.this.mFd) {
                            if ((d.this.mFf & 1) > 0) {
                                d.this.mFd |= 1;
                            } else {
                                d.this.mFd &= -2;
                            }
                            d.this.HL(d.this.mFd);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mFr.u(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dwU();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mFr.v(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aV(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void di(int i, int i2) {
            if (d.this.mFG != i2 || d.this.mFH != i) {
                d.this.mFF = d.this.mFG - i2 > 0 || ((float) i2) < d.this.mFA / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mFu.getLayoutParams();
                if (i2 != d.this.mFG) {
                    int i3 = d.this.mFE - i2;
                    int i4 = (int) (i3 * d.this.mFI);
                    if (i4 < d.this.mFJ) {
                        i4 = d.this.mFJ;
                        i3 = (int) (i4 / d.this.mFI);
                    }
                    if (i4 != d.this.mFJ) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mFu.setLayoutParams(layoutParams);
                    }
                    d.this.mFG = i2;
                    d.this.mFu.setTranslationY(d.this.mFG);
                }
                if (i != d.this.mFG) {
                    d.this.mFH = i;
                    d.this.mFu.setTranslationX(d.this.mFH + ((d.this.mFB - layoutParams.width) / 2.0f));
                }
                d.this.mFs.setAlpha((layoutParams.width - d.this.mFJ) / (d.this.mFB - d.this.mFJ));
                if (d.this.mFo.getVisibility() == 0) {
                    float f = d.this.mFA / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mFo.setAlpha(f2);
                }
            }
        }

        private void aV(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mFC -= 1000;
                z = true;
            } else {
                d.this.mFC += 1000;
                z = false;
            }
            int duration = d.this.gBU.getDuration();
            if (d.this.mFC < 0) {
                d.this.mFC = 0;
            } else if (d.this.mFC > duration) {
                d.this.mFC = duration;
            }
            String str = at.stringForVideoTime(d.this.mFC) + " / " + at.stringForVideoTime(duration);
            if (d.this.mFr != null) {
                d.this.mFr.E(z, str);
            }
            d.this.mFm.setCurrentDuration(d.this.mFC, false);
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mFf == d.this.mFd) {
                if (d.this.mfT == 4) {
                    d.this.dCu();
                    d.this.mFG = 0;
                    d.this.mFH = 0;
                } else {
                    d.this.mFf = -1;
                    if (d.this.mfT != 3) {
                        if (d.this.mFg != -1) {
                            d.this.HL(d.this.mFg);
                            d.this.mFg = -1;
                        } else if (d.this.gBU.isPlaying()) {
                            d.this.HL(d.this.mEW);
                        } else {
                            d.this.HL(d.this.mEZ);
                        }
                    } else {
                        d.this.mFm.setCurrentDuration(d.this.mFC, true);
                        if (d.this.mFC <= d.this.gBU.getDuration()) {
                            if (!d.this.gBU.isPlaying()) {
                                d.this.gBU.a(d.this.mFN);
                            }
                            d.this.HL(d.this.mEW);
                        }
                    }
                }
                if (d.this.mFz) {
                    String str = null;
                    if (d.this.mfT != 1) {
                        if (d.this.mfT != 2) {
                            if (d.this.mfT == 3) {
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
                d.this.mfT = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mFN = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCf() {
            d.this.gBU.dCb();
            d.this.dCm();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCg() {
            d.this.HL(d.this.mEV);
            d.this.bTH();
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
            this.mFA = l.getEquipmentHeight(this.mContext);
            this.mFB = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dwS() {
        int i;
        int i2;
        int i3;
        this.mFn.au(this.anC, this.lID);
        this.mFo.au(this.anC, this.lID);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.anC) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
                i3 = dimension;
            } else if (this.lID) {
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
            this.mFl.setPadding(this.mFl.getPaddingLeft(), 0, i2, 0);
            this.mFk.setPadding(i, 0, 0, 0);
        }
    }

    public void dwR() {
        if (this.anC) {
            this.mEY = 104;
            this.mEZ = 8290;
        } else {
            this.mEY = 232;
            this.mEZ = 8418;
        }
        if (this.lID) {
            this.mEV |= 1024;
            this.mEW |= 1024;
            this.mEX |= 1024;
            this.mEY |= 1024;
            this.mEZ |= 1024;
            this.mFa |= 1024;
            this.mFb |= 1024;
            this.mFc |= 1024;
            this.mFf |= 1024;
            return;
        }
        this.mEV &= -1025;
        this.mEW &= -1025;
        this.mEX &= -1025;
        this.mEY &= -1025;
        this.mEZ &= -1025;
        this.mFa &= -1025;
        this.mFb &= -1025;
        this.mFc &= -1025;
        this.mFf &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mFu = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mFu);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ant = (TbImageView) this.mFu.findViewById(R.id.video_thumbnail);
            this.mEC = this.mFu.findViewById(R.id.black_mask);
            this.mFi = (TBLottieAnimationView) this.mFu.findViewById(R.id.video_loading);
            this.anv = (ImageView) this.mFu.findViewById(R.id.video_play);
            this.mFj = (PercentSizeView) this.mFu.findViewById(R.id.video_media_controller_mask);
            this.anw = (ImageView) this.mFu.findViewById(R.id.video_pause);
            this.anx = (TextView) this.mFu.findViewById(R.id.video_play_count);
            this.any = (TextView) this.mFu.findViewById(R.id.video_play_flag);
            this.anz = (TextView) this.mFu.findViewById(R.id.video_duration);
            this.mFk = (SwitchImageView) this.mFu.findViewById(R.id.video_mute);
            this.mFl = (SwitchImageView) this.mFu.findViewById(R.id.video_full_screen);
            this.mFm = (OperableVideoMediaControllerView) this.mFu.findViewById(R.id.video_media_controller);
            this.mFn = (OperableVideoNetworkStateTipView) this.mFu.findViewById(R.id.video_network_state_tip);
            this.mFo = (OperableVideoShareView) this.mFu.findViewById(R.id.video_share_view);
            this.mFq = this.mFu.findViewById(R.id.video_back_btn_mask);
            this.mFp = (ImageView) this.mFu.findViewById(R.id.video_full_screen_back);
            this.mFr = (VideoGestureView) this.mFu.findViewById(R.id.video_gesture);
            this.mFt = (OperableVideoErrorView) this.mFu.findViewById(R.id.video_error_layout);
            this.mFo.setVideoContainer(this);
            this.mFi.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mFi.setVisibility(8);
                    d.this.anv.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mFi.setAnimation(R.raw.lotti_video_loading);
            this.anv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anv.setOnClickListener(this);
            this.mFk.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mFk.setState(1);
            this.mFk.setOnClickListener(this);
            this.ant.bJM();
            this.ant.setDrawCorner(false);
            this.ant.setPlaceHolder(3);
            com.baidu.tbadk.a.b.b.m(this.mEC, R.color.CAM_X0607);
            this.mFm.setOnSeekBarChangeListener(this.gkb);
            this.mFj.setHeightPercent(0.583f);
            this.mFj.setBackgroundResource(R.drawable.video_mask_bg);
            this.mFl.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mFl.setState(0);
            this.mFl.setOnClickListener(this);
            this.anw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.anw.setOnClickListener(this);
            this.mFp.setOnClickListener(this);
            this.gBU = new TbCyberVideoView(this.mContext);
            this.gBU.setTryUseViewInSet(true);
            dCm();
            this.mFn.setPlayViewOnClickListener(this);
            this.mFu.setOnClickListener(null);
            this.mFu.setOnTouchListener(this.bTP);
            this.mFo.setOnTouchListener(this.bTP);
            this.mFt.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jrz);
            HL(this.mEV);
            this.jLy = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dCm() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mFu.addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
            this.mFm.setPlayer(this.gBU);
            this.gBU.setContinuePlayEnable(true);
            this.gBU.setOnPreparedListener(this);
            this.gBU.setOnCompletionListener(this);
            this.gBU.setOnErrorListener(this);
            this.gBU.setOnSurfaceDestroyedListener(this);
            this.gBU.setOnInfoListener(this);
            this.gBU.setVideoStatData(this.mFx);
            this.gBU.setThreadDataForStatistic(this.mFy);
            this.gBU.getMediaProgressObserver().a(this.mFM);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.brI() != null) {
            this.startPosition = -1L;
            if (this.jLy != null) {
                this.jLy.reset();
            }
            if (!at.equals(this.mVideoUrl, bzVar.brI().video_url)) {
                stopPlay();
                this.anC = bzVar.brI().is_vertical.intValue() == 1;
                this.mVideoUrl = bzVar.brI().video_url;
                this.anD = bzVar.getTid();
                this.anE = bzVar.brI().video_length.intValue();
                this.mFw = bzVar.brI().video_duration.intValue();
                this.mFid = bzVar.getFid();
                this.mFK = bzVar.brI().mcn_ad_card;
                dwR();
                dwS();
                HL(this.mEV);
                int intValue = bzVar.brI().video_duration.intValue() * 1000;
                this.mFm.IE(intValue);
                this.mFm.setPlayer(this.gBU);
                this.anz.setText(at.stringForVideoTime(intValue));
                this.anx.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bzVar.brI().play_count.intValue())));
                this.mFn.setVideoLength(bzVar.brI().video_length.intValue());
                this.mFn.setVideoDuration(bzVar.brI().video_duration.intValue());
                this.mFn.setTid(this.anD);
                this.mFy = bzVar;
                this.gBU.setThreadDataForStatistic(bzVar);
                this.any.setVisibility(8);
                this.ant.setPlaceHolder(3);
                this.ant.startLoad(bzVar.brI().thumbnail_url, 10, false);
                this.mFo.setShareData(bzVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gBU != null) {
            this.mFx = oVar;
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

    public void dCn() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mFh);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mFh, this.mEG);
    }

    public void dCo() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mFh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTH() {
        this.mFi.setAlpha(1.0f);
        this.mFi.setVisibility(0);
        this.anv.setVisibility(8);
        if (this.mFi != null) {
            this.mFi.loop(true);
            this.mFi.setMinAndMaxFrame(14, 80);
            this.mFi.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwP() {
        if (this.mFf == this.mEX) {
            HL(this.mEW);
        }
    }

    private void dCp() {
        HL(this.mEX);
        this.mFm.showProgress();
        if (this.mFi != null) {
            this.mFi.clearAnimation();
            this.mFi.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dwP();
                    if (!d.this.mFv) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mFi.setVisibility(8);
                    d.this.anv.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dCq() {
        return this.mFn != null && this.mFn.dwZ();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.akh = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dCq()) {
                HL(this.mFc);
                return;
            }
            this.mFv = true;
            if (!this.gBU.isPlaying()) {
                TbCyberVideoView QV = TbVideoViewSet.dCe().QV(this.mVideoUrl);
                if (QV == null) {
                    this.gBU.dCb();
                    if (!StringUtils.isNull(this.gBU.getOriginUrl())) {
                        this.gBU = new TbCyberVideoView(this.mContext);
                        this.gBU.setTryUseViewInSet(true);
                    }
                    dCm();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gBU.setVideoDuration(this.mFw);
                        this.gBU.setVideoPath(this.mVideoUrl, this.anD);
                        this.gBU.setStageType(this.akh);
                        bTH();
                        if (this.mFz) {
                            dwX();
                        }
                    }
                } else {
                    if (this.gBU == QV) {
                        if (this.gBU.getParent() == null || this.gBU.getParent() != QV.getParent()) {
                            this.gBU.dCb();
                            dCm();
                        }
                    } else {
                        this.gBU.dCb();
                        QV.dCb();
                        this.gBU = QV;
                        this.gBU.setTryUseViewInSet(true);
                        dCm();
                    }
                    this.gBU.dCc();
                    onPrepared();
                    dCv();
                    if (this.mFz) {
                        dwX();
                    }
                }
                if (this.mFz) {
                    TiebaStatic.log(new aq("c13357").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).an("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mFv = false;
        if (this.mFi != null) {
            this.mFi.cancelAnimation();
        }
        this.gBU.stop();
        this.gBU.dCb();
        this.mFm.aUS();
        HL(this.mEV);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mFv = false;
        if (this.mFi != null) {
            this.mFi.cancelAnimation();
        }
        this.gBU.stop();
        this.mFm.aUS();
        HL(this.mEV);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dwX() {
        if (this.mFx != null) {
            o dBR = this.mFx.dBR();
            dBR.mLocate = this.mFrom;
            h.a(dBR.mDL, "", "1", dBR, this.gBU.getPcdnState());
        }
    }

    public void HL(int i) {
        dCo();
        if (this.mFf == this.mFd) {
            this.mFg = i;
            return;
        }
        this.mFf = i;
        this.ant.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mEC.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mFi.clearAnimation();
        this.mFi.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mFi.cancelAnimation();
        } else {
            this.mFi.setAlpha(1.0f);
        }
        this.anv.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.anw.setVisibility((i & 8) > 0 ? 0 : 8);
        this.anx.setVisibility((i & 16) > 0 ? 0 : 8);
        this.anz.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mFk.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mFl.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mFm.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mFj.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mFm.getVisibility() == 0) {
            this.mFm.showProgress();
        }
        this.mFn.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mFo.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mFo.getVisibility() == 0) {
            this.mFo.setAlpha(1.0f);
        }
        this.mFp.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mFq.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mFr.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mFt.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            HM(id);
            if (id == R.id.video_mute) {
                dCs();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dCu();
            } else if (id == R.id.video_replay) {
                HL(this.mEV);
                startPlay();
                if (this.mFz) {
                    TiebaStatic.log(new aq("c13345").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_locate", this.lID ? 1 : 2));
                }
                dCr();
            } else if (id == R.id.video_play) {
                if (this.mFf == this.mEV) {
                    startPlay();
                } else {
                    HL(this.mEY);
                    dCn();
                    this.gBU.a(this.mFN);
                }
                if (this.mFz) {
                    TiebaStatic.log(new aq("c13344").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_source", this.lID ? 1 : 2).an("obj_locate", 1));
                }
                dCr();
            } else if (id == R.id.video_pause) {
                HL(this.mEZ);
                dCo();
                this.gBU.pause();
                if (this.mFz) {
                    TiebaStatic.log(new aq("c13344").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2).an("obj_source", this.lID ? 1 : 2).an("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                HL(this.mEV);
                startPlay();
            } else if (id == R.id.retry) {
                HL(this.mEV);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCr() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ahE);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gBU.setVolume(0.0f, 0.0f);
            this.mFk.setState(1);
            return;
        }
        this.gBU.setVolume(1.0f, 1.0f);
        this.mFk.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCs() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gBU.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
            this.mFk.setState(0);
        } else {
            this.gBU.setVolume(0.0f, 0.0f);
            this.mFk.setState(1);
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

    public void dCt() {
        wk(true);
    }

    public void wk(boolean z) {
        if (this.mRootView != null && this.mFu != null && this.gBU != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kZN == null) {
                this.kZN = new j((Activity) this.mContext);
            }
            if (this.lID) {
                if (this.mFs.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mFs.getParent()).removeView(this.mFs);
                }
                if ((this.mFu.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lID = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mFu.getParent()).removeView(this.mFu);
                    ((ViewGroup) this.mRootView).addView(this.mFu);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lID);
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
                        this.mFu.getLocationOnScreen(this.mFD);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mFs == null) {
                                    this.mFs = new View(this.mContext);
                                    this.mFs.setClickable(true);
                                    this.mFs.setBackgroundColor(ao.getColor(R.color.black_alpha100));
                                    this.mFs.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mFs.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mFs.getParent()).removeView(this.mFs);
                                }
                                this.mFs.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mFs);
                                ((ViewGroup) childAt).addView(this.mFu);
                                this.isChangingOrientation = false;
                                this.lID = true;
                                k((Activity) this.mContext, this.lID);
                                if (this.jLy != null && this.jLy.isShowing()) {
                                    this.jLy.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mFz) {
                    TiebaStatic.log(new aq("c13360").dX("tid", this.anD).w("fid", this.mFid).an("obj_type", this.anC ? 1 : 2));
                }
            }
            dwR();
            dwS();
            if (this.gBU.isPlaying()) {
                HL(this.mEW);
            } else {
                HL(this.mFf);
            }
            this.mFl.dXL();
            xc(this.lID);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCu() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.anC) {
            dCt();
        } else if (this.mFf == this.mFd) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mFu.setScaleX(1.0f);
                    d.this.mFu.setScaleY(1.0f);
                    d.this.mFu.setTranslationX(0.0f);
                    d.this.mFu.setTranslationY(0.0f);
                    d.this.mFo.setScaleX(1.0f);
                    d.this.mFo.setScaleY(1.0f);
                    d.this.mFu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mFF) {
                        d.this.dCt();
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
            if (!this.mFF) {
                float width = this.mRootView.getWidth() / this.mFu.getWidth();
                float height = this.mRootView.getHeight() / this.mFu.getHeight();
                this.mFu.setPivotX(0.0f);
                this.mFu.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mFu, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mFu, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mFo, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mFo, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mFu, "TranslationX", this.mFu.getTranslationX(), this.mFD[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mFu, "TranslationY", this.mFu.getTranslationY(), this.mFD[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mFs, "alpha", this.mFs.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mFo, "alpha", this.mFo.getAlpha(), 0.0f);
            } else {
                float width2 = this.mFB / this.mFu.getWidth();
                float height2 = this.mFE / this.mFu.getHeight();
                this.mFu.setPivotX(0.0f);
                this.mFu.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mFu, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mFu, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mFo, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mFo, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mFu, "TranslationX", this.mFu.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mFu, "TranslationY", this.mFu.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mFo, "alpha", this.mFo.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mFg != -1) {
                this.mFf = this.mFg;
                this.mFg = -1;
                if (this.mFf == this.mFe || this.mFf == this.mEY || this.mFf == this.mEW) {
                    this.gBU.a(this.mFN);
                    HL(this.mEW);
                }
            }
        } else {
            dCt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.anC && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mFu != null) {
                    if (z) {
                        this.mFu.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mFu.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                ded();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mFu.setSystemUiVisibility(0);
            }
        }
    }

    private void dCv() {
        HL(this.mEX);
        this.mFm.showProgress();
        dCp();
    }

    protected void xc(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mFv) {
            if (this.lID && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gBU.a(this.mFN);
        }
    }

    public void onCompletion() {
        HL(this.mFb);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        HL(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mFf == this.mEZ || (this.mFf == this.mFa && !this.gBU.isPlaying())) {
                stopPlayForSurfaceDestroy();
                HL(this.mEZ);
            } else if (this.mFf == this.mFb) {
                stopPlayForSurfaceDestroy();
                HL(this.mFb);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dCv();
        }
        if (i == 701) {
            bTH();
            return false;
        } else if (i == 702) {
            dCv();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dBy() {
        return this.mFu;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mFv || this.gBU.isPlaying();
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
    public void bZk() {
    }

    protected void HM(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lID;
    }

    protected boolean dwQ() {
        return this.anC && this.lID;
    }

    private void ded() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mFu.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mFu.setSystemUiVisibility(4);
        } else {
            this.mFu.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dwU() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gBU.isPlaying() && !ah.bJo()) {
            this.gBU.setVolume(1.0f, 1.0f);
            this.mFk.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dwV() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean sg(boolean z) {
        if (z) {
            this.mFi.cancelAnimation();
            if (this.mFf == this.mEW || this.mFf == this.mEX || this.mFf == this.mEY || this.mFf == this.mEV) {
                stopPlay();
            }
            this.mFf |= 1;
            HL(this.mFf);
        } else if (this.mFf == this.mEV) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lID;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dCk() {
        if (this.lID) {
            dCu();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cTJ() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dCw() {
        return this.mFK != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xd(boolean z) {
        this.ahw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mFL = aVar;
    }
}
