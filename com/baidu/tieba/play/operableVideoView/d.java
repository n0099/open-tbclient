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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ak;
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
    protected BdUniqueId agC;
    private String aje;
    protected boolean amB;
    protected String amC;
    protected long amD;
    protected TbImageView ams;
    private ImageView amu;
    private ImageView amv;
    protected TextView amw;
    protected TextView amx;
    private TextView amy;
    protected TbCyberVideoView gzX;
    private com.baidu.mcn.c jMw;
    private j ldm;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private TBLottieAnimationView mJJ;
    private PercentSizeView mJK;
    protected SwitchImageView mJL;
    protected SwitchImageView mJM;
    protected OperableVideoMediaControllerView mJN;
    protected OperableVideoNetworkStateTipView mJO;
    protected OperableVideoShareView mJP;
    protected ImageView mJQ;
    protected View mJR;
    protected VideoGestureView mJS;
    private View mJT;
    private OperableVideoErrorView mJU;
    protected ViewGroup mJV;
    protected boolean mJW;
    protected int mJX;
    protected o mJY;
    protected cb mJZ;
    private View mJe;
    private float mKb;
    private float mKc;
    private int mKd;
    private int mKf;
    private boolean mKg;
    private float mKj;
    private int mKk;
    private McnAdInfo mKl;
    private a mKm;
    private View mRootView;
    protected String mVideoUrl;
    protected int mJi = 3000;
    protected final int mJj = 1;
    protected final int mJk = 2;
    protected final int mJl = 4;
    protected final int mJm = 8;
    protected final int mJn = 16;
    protected final int mJo = 32;
    protected final int mJp = 64;
    protected final int mJq = 128;
    protected final int mJr = 256;
    protected final int mJs = 512;
    protected final int mJt = 1024;
    protected final int mJu = 2048;
    protected final int mJv = 4096;
    protected final int mJw = 8192;
    protected int mJx = 8211;
    protected int mJy = 0;
    protected int mJz = 4;
    protected int mJA = 232;
    protected int mJB = 8416;
    protected int mJC = 0;
    protected int mJD = 513;
    protected int mJE = 259;
    protected int mJF = 2048;
    protected int mJG = 0;
    protected int STATE_ERROR = 4099;
    protected int mViewState = this.mJx;
    private int mkr = 0;
    private int mJH = -1;
    private Runnable mJI = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Gy(d.this.mJy);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lMN = false;
    protected boolean mKa = true;
    private boolean isChangingOrientation = false;
    private int[] mKe = new int[2];
    private int mKh = 0;
    private int mKi = 0;
    protected View.OnClickListener ajT = null;
    protected View.OnClickListener agk = null;
    private boolean agu = false;
    private long startPosition = -1;
    private f.b mKn = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ce(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dAO() && !d.this.amB && !d.this.lMN && d.this.agu) {
                if (!com.baidu.mcn.b.abr().iY(d.this.mKl.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mKl.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mKl.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mKl.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jMw.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.chJ = d.this.mKl.card_title;
                            aVar.chK = d.this.mKl.button_title;
                            aVar.chL = d.this.mKl.jump_url;
                            aVar.chI = d.this.mKl.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.amC;
                            aVar.chM = d.this.cRQ();
                            if (z2) {
                                d.this.jMw.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jMw.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jMw.isShowing()) {
                        d.this.jMw.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mKm != null) {
                d.this.mKm.cG(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener ghI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Gy(d.this.mJA);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gzX.isPlaying()) {
                    d.this.gzX.a(d.this.mKo);
                }
                d.this.dAF();
                if (d.this.mKa) {
                    TiebaStatic.log(new ar("c13355").dR("tid", d.this.amC).v("fid", d.this.mFid).ap("obj_type", d.this.amB ? 1 : 2).ap("obj_locate", d.this.lMN ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jsz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gzX.isPlaying()) {
                d.this.gzX.pause();
                if (d.this.mViewState == d.this.mJA) {
                    d.this.Gy(d.this.mJB);
                } else {
                    d.this.Gy(d.this.mJC);
                }
                d.this.Gz(R.id.video_pause);
            } else if (d.this.mViewState == d.this.mJB || d.this.mViewState == (d.this.mJB | 1)) {
                d.this.Gy(d.this.mJA);
                d.this.dAF();
                d.this.gzX.a(d.this.mKo);
                d.this.Gz(R.id.video_play);
            } else if (d.this.mViewState == d.this.mJC || d.this.mViewState == (d.this.mJC | 1)) {
                d.this.Gy(d.this.mJy);
                d.this.gzX.a(d.this.mKo);
                d.this.Gz(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gzX.isPlaying()) {
                if (d.this.mViewState == d.this.mJy || d.this.mViewState == d.this.mJz) {
                    d.this.Gy(d.this.mJA);
                    d.this.dAF();
                    return true;
                } else if (d.this.mViewState == d.this.mJA) {
                    d.this.Gy(d.this.mJy);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mViewState == d.this.mJB) {
                d.this.Gy(d.this.mJC);
                return true;
            } else if (d.this.mViewState == (d.this.mJB | 1)) {
                d.this.Gy(d.this.mJC | 1);
                return true;
            } else if (d.this.mViewState == d.this.mJC) {
                d.this.Gy(d.this.mJB);
                return true;
            } else if (d.this.mViewState == (d.this.mJC | 1)) {
                d.this.Gy(d.this.mJB | 1);
                return true;
            } else {
                d.this.Gy(d.this.mJx);
                d.this.startPlay();
                d.this.dAJ();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.mkr = 0;
            if (d.this.lMN) {
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
            if (d.this.amB && d.this.dvl()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.mkr) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gzX.isPlaying()) {
                                d.this.gzX.pause();
                                d.this.Gy(d.this.mJG);
                            }
                            d.this.mkr = 4;
                            d.this.mJH = d.this.mViewState;
                            d.this.mViewState = d.this.mJF;
                            d.this.mKf = d.this.mJV.getMeasuredHeight();
                            d.this.mKj = d.this.mKc / d.this.mKf;
                            d.this.mKk = (int) (1.2f * d.this.mRootView.getWidth());
                            df(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        df(rawX, rawY);
                        break;
                }
            } else if (d.this.mViewState == d.this.mJy || d.this.mViewState == d.this.mJA || d.this.mViewState == d.this.mJB || d.this.mViewState == d.this.mJC || d.this.mViewState == d.this.mJF || d.this.mViewState == (d.this.mJB | 1) || d.this.mViewState == (d.this.mJC | 1)) {
                switch (d.this.mkr) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.mkr = 3;
                            d.this.mKd = d.this.gzX.getCurrentPosition();
                            aY(f);
                        } else if (motionEvent.getX() < d.this.mJV.getWidth() / 2) {
                            d.this.mkr = 2;
                            d.this.mJS.v(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.mkr = 1;
                            d.this.mJS.u(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mViewState != d.this.mJF) {
                            if ((d.this.mViewState & 1) > 0) {
                                d.this.mJF |= 1;
                            } else {
                                d.this.mJF &= -2;
                            }
                            d.this.Gy(d.this.mJF);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mJS.u(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dvp();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mJS.v(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aY(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void df(int i, int i2) {
            if (d.this.mKh != i2 || d.this.mKi != i) {
                d.this.mKg = d.this.mKh - i2 > 0 || ((float) i2) < d.this.mKb / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mJV.getLayoutParams();
                if (i2 != d.this.mKh) {
                    int i3 = d.this.mKf - i2;
                    int i4 = (int) (i3 * d.this.mKj);
                    if (i4 < d.this.mKk) {
                        i4 = d.this.mKk;
                        i3 = (int) (i4 / d.this.mKj);
                    }
                    if (i4 != d.this.mKk) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mJV.setLayoutParams(layoutParams);
                    }
                    d.this.mKh = i2;
                    d.this.mJV.setTranslationY(d.this.mKh);
                }
                if (i != d.this.mKh) {
                    d.this.mKi = i;
                    d.this.mJV.setTranslationX(d.this.mKi + ((d.this.mKc - layoutParams.width) / 2.0f));
                }
                d.this.mJT.setAlpha((layoutParams.width - d.this.mKk) / (d.this.mKc - d.this.mKk));
                if (d.this.mJP.getVisibility() == 0) {
                    float f = d.this.mKb / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mJP.setAlpha(f2);
                }
            }
        }

        private void aY(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mKd -= 1000;
                z = true;
            } else {
                d.this.mKd += 1000;
                z = false;
            }
            int duration = d.this.gzX.getDuration();
            if (d.this.mKd < 0) {
                d.this.mKd = 0;
            } else if (d.this.mKd > duration) {
                d.this.mKd = duration;
            }
            String str = au.stringForVideoTime(d.this.mKd) + " / " + au.stringForVideoTime(duration);
            if (d.this.mJS != null) {
                d.this.mJS.L(z, str);
            }
            d.this.mJN.setCurrentDuration(d.this.mKd, false);
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mViewState == d.this.mJF) {
                if (d.this.mkr == 4) {
                    d.this.dAM();
                    d.this.mKh = 0;
                    d.this.mKi = 0;
                } else {
                    d.this.mViewState = -1;
                    if (d.this.mkr != 3) {
                        if (d.this.mJH != -1) {
                            d.this.Gy(d.this.mJH);
                            d.this.mJH = -1;
                        } else if (d.this.gzX.isPlaying()) {
                            d.this.Gy(d.this.mJy);
                        } else {
                            d.this.Gy(d.this.mJB);
                        }
                    } else {
                        d.this.mJN.setCurrentDuration(d.this.mKd, true);
                        if (d.this.mKd <= d.this.gzX.getDuration()) {
                            if (!d.this.gzX.isPlaying()) {
                                d.this.gzX.a(d.this.mKo);
                            }
                            d.this.Gy(d.this.mJy);
                        }
                    }
                }
                if (d.this.mKa) {
                    String str = null;
                    if (d.this.mkr != 1) {
                        if (d.this.mkr != 2) {
                            if (d.this.mkr == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!au.isEmpty(str)) {
                        TiebaStatic.log(new ar(str).dR("tid", d.this.amC).v("fid", d.this.mFid));
                    }
                }
                d.this.mkr = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mKo = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dAv() {
            d.this.gzX.dAr();
            d.this.dAE();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dAw() {
            d.this.Gy(d.this.mJx);
            d.this.bQt();
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
        void cG(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.mKb = l.getEquipmentHeight(this.mContext);
            this.mKc = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dvn() {
        int i;
        int i2;
        int i3;
        this.mJO.au(this.amB, this.lMN);
        this.mJP.au(this.amB, this.lMN);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.amB) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
                i3 = dimension;
            } else if (this.lMN) {
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
            this.amw.setPadding(0, 0, i3, 0);
            this.mJM.setPadding(this.mJM.getPaddingLeft(), 0, i2, 0);
            this.mJL.setPadding(i, 0, 0, 0);
        }
    }

    public void dvm() {
        if (this.amB) {
            this.mJA = 104;
            this.mJB = 8290;
        } else {
            this.mJA = 232;
            this.mJB = 8418;
        }
        if (this.lMN) {
            this.mJx |= 1024;
            this.mJy |= 1024;
            this.mJz |= 1024;
            this.mJA |= 1024;
            this.mJB |= 1024;
            this.mJC |= 1024;
            this.mJD |= 1024;
            this.mJE |= 1024;
            this.mViewState |= 1024;
            return;
        }
        this.mJx &= -1025;
        this.mJy &= -1025;
        this.mJz &= -1025;
        this.mJA &= -1025;
        this.mJB &= -1025;
        this.mJC &= -1025;
        this.mJD &= -1025;
        this.mJE &= -1025;
        this.mViewState &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mJV = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mJV);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.ams = (TbImageView) this.mJV.findViewById(R.id.video_thumbnail);
            this.mJe = this.mJV.findViewById(R.id.black_mask);
            this.mJJ = (TBLottieAnimationView) this.mJV.findViewById(R.id.video_loading);
            this.amu = (ImageView) this.mJV.findViewById(R.id.video_play);
            this.mJK = (PercentSizeView) this.mJV.findViewById(R.id.video_media_controller_mask);
            this.amv = (ImageView) this.mJV.findViewById(R.id.video_pause);
            this.amw = (TextView) this.mJV.findViewById(R.id.video_play_count);
            this.amx = (TextView) this.mJV.findViewById(R.id.video_play_flag);
            this.amy = (TextView) this.mJV.findViewById(R.id.video_duration);
            this.mJL = (SwitchImageView) this.mJV.findViewById(R.id.video_mute);
            this.mJM = (SwitchImageView) this.mJV.findViewById(R.id.video_full_screen);
            this.mJN = (OperableVideoMediaControllerView) this.mJV.findViewById(R.id.video_media_controller);
            this.mJO = (OperableVideoNetworkStateTipView) this.mJV.findViewById(R.id.video_network_state_tip);
            this.mJP = (OperableVideoShareView) this.mJV.findViewById(R.id.video_share_view);
            this.mJR = this.mJV.findViewById(R.id.video_back_btn_mask);
            this.mJQ = (ImageView) this.mJV.findViewById(R.id.video_full_screen_back);
            this.mJS = (VideoGestureView) this.mJV.findViewById(R.id.video_gesture);
            this.mJU = (OperableVideoErrorView) this.mJV.findViewById(R.id.video_error_layout);
            this.mJP.setVideoContainer(this);
            this.mJJ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mJJ.setVisibility(8);
                    d.this.amu.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mJJ.setAnimation(R.raw.lotti_video_loading);
            this.amu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amu.setOnClickListener(this);
            this.mJL.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mJL.setState(1);
            this.mJL.setOnClickListener(this);
            this.ams.bGo();
            this.ams.setDrawCorner(false);
            this.ams.setPlaceHolder(3);
            com.baidu.tbadk.a.b.b.m(this.mJe, R.color.CAM_X0607);
            this.mJN.setOnSeekBarChangeListener(this.ghI);
            this.mJK.setHeightPercent(0.583f);
            this.mJK.setBackgroundResource(R.drawable.video_mask_bg);
            this.mJM.setSvgStateImage(new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.e.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mJM.setState(0);
            this.mJM.setOnClickListener(this);
            this.amv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amv.setOnClickListener(this);
            this.mJQ.setOnClickListener(this);
            this.gzX = new TbCyberVideoView(this.mContext);
            this.gzX.setTryUseViewInSet(true);
            dAE();
            this.mJO.setPlayViewOnClickListener(this);
            this.mJV.setOnClickListener(null);
            this.mJV.setOnTouchListener(this.bST);
            this.mJP.setOnTouchListener(this.bST);
            this.mJU.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jsz);
            Gy(this.mJx);
            this.jMw = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dAE() {
        if (this.gzX != null && this.gzX.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mJV.addView(this.gzX.getView(), 0);
            this.gzX.getView().setLayoutParams(layoutParams);
            this.mJN.setPlayer(this.gzX);
            this.gzX.setContinuePlayEnable(true);
            this.gzX.setOnPreparedListener(this);
            this.gzX.setOnCompletionListener(this);
            this.gzX.setOnErrorListener(this);
            this.gzX.setOnSurfaceDestroyedListener(this);
            this.gzX.setOnInfoListener(this);
            this.gzX.setVideoStatData(this.mJY);
            this.gzX.setThreadDataForStatistic(this.mJZ);
            this.gzX.getMediaProgressObserver().a(this.mKn);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boh() != null) {
            this.startPosition = -1L;
            if (this.jMw != null) {
                this.jMw.reset();
            }
            if (!au.equals(this.mVideoUrl, cbVar.boh().video_url)) {
                stopPlay();
                this.amB = cbVar.boh().is_vertical.intValue() == 1;
                this.mVideoUrl = cbVar.boh().video_url;
                this.amC = cbVar.getTid();
                this.amD = cbVar.boh().video_length.intValue();
                this.mJX = cbVar.boh().video_duration.intValue();
                this.mFid = cbVar.getFid();
                this.mKl = cbVar.boh().mcn_ad_card;
                dvm();
                dvn();
                Gy(this.mJx);
                int intValue = cbVar.boh().video_duration.intValue() * 1000;
                this.mJN.Hp(intValue);
                this.mJN.setPlayer(this.gzX);
                this.amy.setText(au.stringForVideoTime(intValue));
                this.amw.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(cbVar.boh().play_count.intValue())));
                this.mJO.setVideoLength(cbVar.boh().video_length.intValue());
                this.mJO.setVideoDuration(cbVar.boh().video_duration.intValue());
                this.mJO.setTid(this.amC);
                this.mJZ = cbVar;
                this.gzX.setThreadDataForStatistic(cbVar);
                this.amx.setVisibility(8);
                this.ams.setPlaceHolder(3);
                this.ams.startLoad(cbVar.boh().thumbnail_url, 10, false);
                this.mJP.setShareData(cbVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gzX != null) {
            this.mJY = oVar;
            this.gzX.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ae(View.OnClickListener onClickListener) {
        this.agk = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Hr(int i) {
        this.gzX.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    public void dAF() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJI);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mJI, this.mJi);
    }

    public void dAG() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQt() {
        this.mJJ.setAlpha(1.0f);
        this.mJJ.setVisibility(0);
        this.amu.setVisibility(8);
        if (this.mJJ != null) {
            this.mJJ.loop(true);
            this.mJJ.setMinAndMaxFrame(14, 80);
            this.mJJ.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvk() {
        if (this.mViewState == this.mJz) {
            Gy(this.mJy);
        }
    }

    private void dAH() {
        Gy(this.mJz);
        this.mJN.showProgress();
        if (this.mJJ != null) {
            this.mJJ.clearAnimation();
            this.mJJ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dvk();
                    if (!d.this.mJW) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mJJ.setVisibility(8);
                    d.this.amu.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dAI() {
        return this.mJO != null && this.mJO.dvu();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aje = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dAI()) {
                Gy(this.mJE);
                return;
            }
            this.mJW = true;
            if (!this.gzX.isPlaying()) {
                TbCyberVideoView QF = TbVideoViewSet.dAu().QF(this.mVideoUrl);
                if (QF == null) {
                    this.gzX.dAr();
                    if (!StringUtils.isNull(this.gzX.getOriginUrl())) {
                        this.gzX = new TbCyberVideoView(this.mContext);
                        this.gzX.setTryUseViewInSet(true);
                    }
                    dAE();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gzX.setVideoDuration(this.mJX);
                        this.gzX.setVideoPath(this.mVideoUrl, this.amC);
                        this.gzX.setStageType(this.aje);
                        bQt();
                        if (this.mKa) {
                            dvs();
                        }
                    }
                } else {
                    if (this.gzX == QF) {
                        if (this.gzX.getParent() == null || this.gzX.getParent() != QF.getParent()) {
                            this.gzX.dAr();
                            dAE();
                        }
                    } else {
                        this.gzX.dAr();
                        QF.dAr();
                        this.gzX = QF;
                        this.gzX.setTryUseViewInSet(true);
                        dAE();
                    }
                    this.gzX.dAs();
                    onPrepared();
                    dAN();
                    if (this.mKa) {
                        dvs();
                    }
                }
                if (this.mKa) {
                    TiebaStatic.log(new ar("c13357").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ap("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mJW = false;
        if (this.mJJ != null) {
            this.mJJ.cancelAnimation();
        }
        this.gzX.stop();
        this.gzX.dAr();
        this.mJN.aRo();
        Gy(this.mJx);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mJW = false;
        if (this.mJJ != null) {
            this.mJJ.cancelAnimation();
        }
        this.gzX.stop();
        this.mJN.aRo();
        Gy(this.mJx);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dvs() {
        if (this.mJY != null) {
            o dAh = this.mJY.dAh();
            dAh.mLocate = this.mFrom;
            h.a(dAh.mIj, "", "1", dAh, this.gzX.getPcdnState());
        }
    }

    public void Gy(int i) {
        dAG();
        if (this.mViewState == this.mJF) {
            this.mJH = i;
            return;
        }
        this.mViewState = i;
        this.ams.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mJe.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mJJ.clearAnimation();
        this.mJJ.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mJJ.cancelAnimation();
        } else {
            this.mJJ.setAlpha(1.0f);
        }
        this.amu.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.amv.setVisibility((i & 8) > 0 ? 0 : 8);
        this.amw.setVisibility((i & 16) > 0 ? 0 : 8);
        this.amy.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mJL.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mJM.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mJN.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mJK.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mJN.getVisibility() == 0) {
            this.mJN.showProgress();
        }
        this.mJO.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mJP.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mJP.getVisibility() == 0) {
            this.mJP.setAlpha(1.0f);
        }
        this.mJQ.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mJR.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mJS.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mJU.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Gz(id);
            if (id == R.id.video_mute) {
                dAK();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dAM();
            } else if (id == R.id.video_replay) {
                Gy(this.mJx);
                startPlay();
                if (this.mKa) {
                    TiebaStatic.log(new ar("c13345").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_locate", this.lMN ? 1 : 2));
                }
                dAJ();
            } else if (id == R.id.video_play) {
                if (this.mViewState == this.mJx) {
                    startPlay();
                } else {
                    Gy(this.mJA);
                    dAF();
                    this.gzX.a(this.mKo);
                }
                if (this.mKa) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_source", this.lMN ? 1 : 2).ap("obj_locate", 1));
                }
                dAJ();
            } else if (id == R.id.video_pause) {
                Gy(this.mJB);
                dAG();
                this.gzX.pause();
                if (this.mKa) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2).ap("obj_source", this.lMN ? 1 : 2).ap("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Gy(this.mJx);
                startPlay();
            } else if (id == R.id.retry) {
                Gy(this.mJx);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAJ() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.agC);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gzX.setVolume(0.0f, 0.0f);
            this.mJL.setState(1);
            return;
        }
        this.gzX.setVolume(1.0f, 1.0f);
        this.mJL.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAK() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gzX.setVolume(1.0f, 1.0f);
            ak.a(this.mWeakContext, true);
            this.mJL.setState(0);
        } else {
            this.gzX.setVolume(0.0f, 0.0f);
            this.mJL.setState(1);
            ak.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void xp(boolean z) {
        if (this.ldm == null) {
            this.ldm = new j((Activity) this.mContext);
        }
        if (z) {
            this.ldm.start();
            this.ldm.dh(true);
            return;
        }
        this.ldm.stop();
        this.ldm.dh(false);
    }

    public void dAL() {
        wx(true);
    }

    public void wx(boolean z) {
        if (this.mRootView != null && this.mJV != null && this.gzX != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.ldm == null) {
                this.ldm = new j((Activity) this.mContext);
            }
            if (this.lMN) {
                if (this.mJT.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mJT.getParent()).removeView(this.mJT);
                }
                if ((this.mJV.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lMN = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mJV.getParent()).removeView(this.mJV);
                    ((ViewGroup) this.mRootView).addView(this.mJV);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lMN);
                }
                if (!this.amB && z) {
                    this.ldm.TZ();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.amB && z) {
                        this.ldm.TZ();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mJV.getLocationOnScreen(this.mKe);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mJT == null) {
                                    this.mJT = new View(this.mContext);
                                    this.mJT.setClickable(true);
                                    this.mJT.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mJT.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mJT.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mJT.getParent()).removeView(this.mJT);
                                }
                                this.mJT.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mJT);
                                ((ViewGroup) childAt).addView(this.mJV);
                                this.isChangingOrientation = false;
                                this.lMN = true;
                                k((Activity) this.mContext, this.lMN);
                                if (this.jMw != null && this.jMw.isShowing()) {
                                    this.jMw.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mKa) {
                    TiebaStatic.log(new ar("c13360").dR("tid", this.amC).v("fid", this.mFid).ap("obj_type", this.amB ? 1 : 2));
                }
            }
            dvm();
            dvn();
            if (this.gzX.isPlaying()) {
                Gy(this.mJy);
            } else {
                Gy(this.mViewState);
            }
            this.mJM.dWh();
            xq(this.lMN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAM() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.amB) {
            dAL();
        } else if (this.mViewState == this.mJF) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mJV.setScaleX(1.0f);
                    d.this.mJV.setScaleY(1.0f);
                    d.this.mJV.setTranslationX(0.0f);
                    d.this.mJV.setTranslationY(0.0f);
                    d.this.mJP.setScaleX(1.0f);
                    d.this.mJP.setScaleY(1.0f);
                    d.this.mJV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mKg) {
                        d.this.dAL();
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
            if (!this.mKg) {
                float width = this.mRootView.getWidth() / this.mJV.getWidth();
                float height = this.mRootView.getHeight() / this.mJV.getHeight();
                this.mJV.setPivotX(0.0f);
                this.mJV.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mJV, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mJV, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mJP, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mJP, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mJV, "TranslationX", this.mJV.getTranslationX(), this.mKe[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mJV, "TranslationY", this.mJV.getTranslationY(), this.mKe[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mJT, "alpha", this.mJT.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mJP, "alpha", this.mJP.getAlpha(), 0.0f);
            } else {
                float width2 = this.mKc / this.mJV.getWidth();
                float height2 = this.mKf / this.mJV.getHeight();
                this.mJV.setPivotX(0.0f);
                this.mJV.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mJV, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mJV, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mJP, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mJP, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mJV, "TranslationX", this.mJV.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mJV, "TranslationY", this.mJV.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mJP, "alpha", this.mJP.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mJH != -1) {
                this.mViewState = this.mJH;
                this.mJH = -1;
                if (this.mViewState == this.mJG || this.mViewState == this.mJA || this.mViewState == this.mJy) {
                    this.gzX.a(this.mKo);
                    Gy(this.mJy);
                }
            }
        } else {
            dAL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.amB && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mJV != null) {
                    if (z) {
                        this.mJV.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mJV.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                dcj();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mJV.setSystemUiVisibility(0);
            }
        }
    }

    private void dAN() {
        Gy(this.mJz);
        this.mJN.showProgress();
        dAH();
    }

    protected void xq(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mJW) {
            if (this.lMN && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gzX.a(this.mKo);
        }
    }

    public void onCompletion() {
        Gy(this.mJD);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Gy(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mViewState == this.mJB || (this.mViewState == this.mJC && !this.gzX.isPlaying())) {
                stopPlayForSurfaceDestroy();
                Gy(this.mJB);
            } else if (this.mViewState == this.mJD) {
                stopPlayForSurfaceDestroy();
                Gy(this.mJD);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dAN();
        }
        if (i == 701) {
            bQt();
            return false;
        } else if (i == 702) {
            dAN();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dzP() {
        return this.mJV;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mJW || this.gzX.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gzX.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void onScroll() {
    }

    protected void Gz(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lMN;
    }

    protected boolean dvl() {
        return this.amB && this.lMN;
    }

    private void dcj() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mJV.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mJV.setSystemUiVisibility(4);
        } else {
            this.mJV.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dvp() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gzX.isPlaying() && !ak.bFQ()) {
            this.gzX.setVolume(1.0f, 1.0f);
            this.mJL.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dvq() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        if (z) {
            this.mJJ.cancelAnimation();
            if (this.mViewState == this.mJy || this.mViewState == this.mJz || this.mViewState == this.mJA || this.mViewState == this.mJx) {
                stopPlay();
            }
            this.mViewState |= 1;
            Gy(this.mViewState);
        } else if (this.mViewState == this.mJx) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lMN;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dAA() {
        if (this.lMN) {
            dAM();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cRQ() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dAO() {
        return this.mKl != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xr(boolean z) {
        this.agu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mKm = aVar;
    }
}
