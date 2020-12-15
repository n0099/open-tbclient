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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ai;
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
    private String ajC;
    protected BdUniqueId ajD;
    protected TbImageView amP;
    private ImageView amQ;
    private ImageView amR;
    protected TextView amS;
    protected TextView amT;
    private TextView amU;
    protected boolean amX;
    protected String amY;
    protected long amZ;
    protected TbCyberVideoView gqV;
    private com.baidu.mcn.c jyZ;
    private j kUk;
    protected View mAa;
    protected VideoGestureView mAb;
    private View mAc;
    private OperableVideoErrorView mAd;
    protected ViewGroup mAe;
    protected boolean mAf;
    protected int mAg;
    protected o mAh;
    protected by mAi;
    private float mAk;
    private float mAl;
    private int mAm;
    private int mAo;
    private boolean mAp;
    private float mAs;
    private int mAt;
    private McnAdInfo mAu;
    private a mAv;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    private View mzR;
    private TBLottieAnimationView mzS;
    private PercentSizeView mzT;
    protected SwitchImageView mzU;
    protected SwitchImageView mzV;
    protected OperableVideoMediaControllerView mzW;
    protected OperableVideoNetworkStateTipView mzX;
    protected OperableVideoShareView mzY;
    protected ImageView mzZ;
    protected int mzp = 3000;
    protected final int mzq = 1;
    protected final int mzr = 2;
    protected final int mzs = 4;
    protected final int mzt = 8;
    protected final int mzu = 16;
    protected final int mzv = 32;
    protected final int mzw = 64;
    protected final int mzx = 128;
    protected final int mzy = 256;
    protected final int mzz = 512;
    protected final int mzA = 1024;
    protected final int mzB = 2048;
    protected final int mzC = 4096;
    protected final int mzD = 8192;
    protected int mzE = 8211;
    protected int mzF = 0;
    protected int mzG = 4;
    protected int mzH = 232;
    protected int mzI = 8416;
    protected int mzJ = 0;
    protected int mzK = 513;
    protected int mzL = 259;
    protected int mzM = 2048;
    protected int mzN = 0;
    protected int STATE_ERROR = 4099;
    protected int mzO = this.mzE;
    private int maI = 0;
    private int mzP = -1;
    private Runnable mzQ = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.HS(d.this.mzF);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lDy = false;
    protected boolean mAj = true;
    private boolean isChangingOrientation = false;
    private int[] mAn = new int[2];
    private int mAq = 0;
    private int mAr = 0;
    protected View.OnClickListener akt = null;
    protected View.OnClickListener agK = null;
    private boolean agX = false;
    private long startPosition = -1;
    private f.b mAw = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ci(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dCG() && !d.this.amX && !d.this.lDy && d.this.agX) {
                if (!com.baidu.mcn.b.abJ().jK(d.this.mAu.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mAu.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mAu.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mAu.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jyZ.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.cbD = d.this.mAu.card_title;
                            aVar.cbE = d.this.mAu.button_title;
                            aVar.cbF = d.this.mAu.jump_url;
                            aVar.cbC = d.this.mAu.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.amY;
                            aVar.cbG = d.this.cQC();
                            if (z2) {
                                d.this.jyZ.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jyZ.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jyZ.isShowing()) {
                        d.this.jyZ.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mAv != null) {
                d.this.mAv.cM(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gaK = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.HS(d.this.mzH);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gqV.isPlaying()) {
                    d.this.gqV.a(d.this.mAx);
                }
                d.this.dCx();
                if (d.this.mAj) {
                    TiebaStatic.log(new ar("c13355").dY("tid", d.this.amY).w("fid", d.this.mFid).al("obj_type", d.this.amX ? 1 : 2).al("obj_locate", d.this.lDy ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jfa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gqV.isPlaying()) {
                d.this.gqV.pause();
                if (d.this.mzO == d.this.mzH) {
                    d.this.HS(d.this.mzI);
                } else {
                    d.this.HS(d.this.mzJ);
                }
                d.this.HT(R.id.video_pause);
            } else if (d.this.mzO == d.this.mzI || d.this.mzO == (d.this.mzI | 1)) {
                d.this.HS(d.this.mzH);
                d.this.dCx();
                d.this.gqV.a(d.this.mAx);
                d.this.HT(R.id.video_play);
            } else if (d.this.mzO == d.this.mzJ || d.this.mzO == (d.this.mzJ | 1)) {
                d.this.HS(d.this.mzF);
                d.this.gqV.a(d.this.mAx);
                d.this.HT(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gqV.isPlaying()) {
                if (d.this.mzO == d.this.mzF || d.this.mzO == d.this.mzG) {
                    d.this.HS(d.this.mzH);
                    d.this.dCx();
                    return true;
                } else if (d.this.mzO == d.this.mzH) {
                    d.this.HS(d.this.mzF);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mzO == d.this.mzI) {
                d.this.HS(d.this.mzJ);
                return true;
            } else if (d.this.mzO == (d.this.mzI | 1)) {
                d.this.HS(d.this.mzJ | 1);
                return true;
            } else if (d.this.mzO == d.this.mzJ) {
                d.this.HS(d.this.mzI);
                return true;
            } else if (d.this.mzO == (d.this.mzJ | 1)) {
                d.this.HS(d.this.mzI | 1);
                return true;
            } else {
                d.this.HS(d.this.mzE);
                d.this.startPlay();
                d.this.dCB();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.maI = 0;
            if (d.this.lDy) {
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
            if (d.this.amX && d.this.dxa()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.maI) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gqV.isPlaying()) {
                                d.this.gqV.pause();
                                d.this.HS(d.this.mzN);
                            }
                            d.this.maI = 4;
                            d.this.mzP = d.this.mzO;
                            d.this.mzO = d.this.mzM;
                            d.this.mAo = d.this.mAe.getMeasuredHeight();
                            d.this.mAs = d.this.mAl / d.this.mAo;
                            d.this.mAt = (int) (1.2f * d.this.mRootView.getWidth());
                            dm(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dm(rawX, rawY);
                        break;
                }
            } else if (d.this.mzO == d.this.mzF || d.this.mzO == d.this.mzH || d.this.mzO == d.this.mzI || d.this.mzO == d.this.mzJ || d.this.mzO == d.this.mzM || d.this.mzO == (d.this.mzI | 1) || d.this.mzO == (d.this.mzJ | 1)) {
                switch (d.this.maI) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.maI = 3;
                            d.this.mAm = d.this.gqV.getCurrentPosition();
                            aT(f);
                        } else if (motionEvent.getX() < d.this.mAe.getWidth() / 2) {
                            d.this.maI = 2;
                            d.this.mAb.y(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.maI = 1;
                            d.this.mAb.x(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mzO != d.this.mzM) {
                            if ((d.this.mzO & 1) > 0) {
                                d.this.mzM |= 1;
                            } else {
                                d.this.mzM &= -2;
                            }
                            d.this.HS(d.this.mzM);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mAb.x(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dxe();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mAb.y(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aT(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dm(int i, int i2) {
            if (d.this.mAq != i2 || d.this.mAr != i) {
                d.this.mAp = d.this.mAq - i2 > 0 || ((float) i2) < d.this.mAk / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mAe.getLayoutParams();
                if (i2 != d.this.mAq) {
                    int i3 = d.this.mAo - i2;
                    int i4 = (int) (i3 * d.this.mAs);
                    if (i4 < d.this.mAt) {
                        i4 = d.this.mAt;
                        i3 = (int) (i4 / d.this.mAs);
                    }
                    if (i4 != d.this.mAt) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mAe.setLayoutParams(layoutParams);
                    }
                    d.this.mAq = i2;
                    d.this.mAe.setTranslationY(d.this.mAq);
                }
                if (i != d.this.mAq) {
                    d.this.mAr = i;
                    d.this.mAe.setTranslationX(d.this.mAr + ((d.this.mAl - layoutParams.width) / 2.0f));
                }
                d.this.mAc.setAlpha((layoutParams.width - d.this.mAt) / (d.this.mAl - d.this.mAt));
                if (d.this.mzY.getVisibility() == 0) {
                    float f = d.this.mAk / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mzY.setAlpha(f2);
                }
            }
        }

        private void aT(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mAm -= 1000;
                z = true;
            } else {
                d.this.mAm += 1000;
                z = false;
            }
            int duration = d.this.gqV.getDuration();
            if (d.this.mAm < 0) {
                d.this.mAm = 0;
            } else if (d.this.mAm > duration) {
                d.this.mAm = duration;
            }
            String str = au.stringForVideoTime(d.this.mAm) + " / " + au.stringForVideoTime(duration);
            if (d.this.mAb != null) {
                d.this.mAb.E(z, str);
            }
            d.this.mzW.setCurrentDuration(d.this.mAm, false);
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mzO == d.this.mzM) {
                if (d.this.maI == 4) {
                    d.this.dCE();
                    d.this.mAq = 0;
                    d.this.mAr = 0;
                } else {
                    d.this.mzO = -1;
                    if (d.this.maI != 3) {
                        if (d.this.mzP != -1) {
                            d.this.HS(d.this.mzP);
                            d.this.mzP = -1;
                        } else if (d.this.gqV.isPlaying()) {
                            d.this.HS(d.this.mzF);
                        } else {
                            d.this.HS(d.this.mzI);
                        }
                    } else {
                        d.this.mzW.setCurrentDuration(d.this.mAm, true);
                        if (d.this.mAm <= d.this.gqV.getDuration()) {
                            if (!d.this.gqV.isPlaying()) {
                                d.this.gqV.a(d.this.mAx);
                            }
                            d.this.HS(d.this.mzF);
                        }
                    }
                }
                if (d.this.mAj) {
                    String str = null;
                    if (d.this.maI != 1) {
                        if (d.this.maI != 2) {
                            if (d.this.maI == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!au.isEmpty(str)) {
                        TiebaStatic.log(new ar(str).dY("tid", d.this.amY).w("fid", d.this.mFid));
                    }
                }
                d.this.maI = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mAx = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCp() {
            d.this.gqV.dCl();
            d.this.dCw();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCq() {
            d.this.HS(d.this.mzE);
            d.this.bRi();
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
        void cM(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.mAk = l.getEquipmentHeight(this.mContext);
            this.mAl = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dxc() {
        int dimension;
        int i;
        int i2;
        this.mzX.as(this.amX, this.lDy);
        this.mzY.as(this.amX, this.lDy);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.amX) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.lDy) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.amS.setPadding(0, 0, i2, 0);
            this.mzV.setPadding(this.mzV.getPaddingLeft(), 0, i, 0);
            this.mzU.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dxb() {
        if (this.amX) {
            this.mzH = 104;
            this.mzI = 8290;
        } else {
            this.mzH = 232;
            this.mzI = 8418;
        }
        if (this.lDy) {
            this.mzE |= 1024;
            this.mzF |= 1024;
            this.mzG |= 1024;
            this.mzH |= 1024;
            this.mzI |= 1024;
            this.mzJ |= 1024;
            this.mzK |= 1024;
            this.mzL |= 1024;
            this.mzO |= 1024;
            return;
        }
        this.mzE &= -1025;
        this.mzF &= -1025;
        this.mzG &= -1025;
        this.mzH &= -1025;
        this.mzI &= -1025;
        this.mzJ &= -1025;
        this.mzK &= -1025;
        this.mzL &= -1025;
        this.mzO &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mAe = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mAe);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.amP = (TbImageView) this.mAe.findViewById(R.id.video_thumbnail);
            this.mzR = this.mAe.findViewById(R.id.black_mask);
            this.mzS = (TBLottieAnimationView) this.mAe.findViewById(R.id.video_loading);
            this.amQ = (ImageView) this.mAe.findViewById(R.id.video_play);
            this.mzT = (PercentSizeView) this.mAe.findViewById(R.id.video_media_controller_mask);
            this.amR = (ImageView) this.mAe.findViewById(R.id.video_pause);
            this.amS = (TextView) this.mAe.findViewById(R.id.video_play_count);
            this.amT = (TextView) this.mAe.findViewById(R.id.video_play_flag);
            this.amU = (TextView) this.mAe.findViewById(R.id.video_duration);
            this.mzU = (SwitchImageView) this.mAe.findViewById(R.id.video_mute);
            this.mzV = (SwitchImageView) this.mAe.findViewById(R.id.video_full_screen);
            this.mzW = (OperableVideoMediaControllerView) this.mAe.findViewById(R.id.video_media_controller);
            this.mzX = (OperableVideoNetworkStateTipView) this.mAe.findViewById(R.id.video_network_state_tip);
            this.mzY = (OperableVideoShareView) this.mAe.findViewById(R.id.video_share_view);
            this.mAa = this.mAe.findViewById(R.id.video_back_btn_mask);
            this.mzZ = (ImageView) this.mAe.findViewById(R.id.video_full_screen_back);
            this.mAb = (VideoGestureView) this.mAe.findViewById(R.id.video_gesture);
            this.mAd = (OperableVideoErrorView) this.mAe.findViewById(R.id.video_error_layout);
            this.mzY.setVideoContainer(this);
            this.mzS.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mzS.setVisibility(8);
                    d.this.amQ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mzS.setAnimation(R.raw.lotti_video_loading);
            this.amQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amQ.setOnClickListener(this);
            this.mzU.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mzU.setState(1);
            this.mzU.setOnClickListener(this);
            this.amP.bHt();
            this.amP.setDrawCorner(false);
            this.amP.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.j(this.mzR, R.color.CAM_X0607);
            this.mzW.setOnSeekBarChangeListener(this.gaK);
            this.mzT.setHeightPercent(0.583f);
            this.mzT.setBackgroundResource(R.drawable.video_mask_bg);
            this.mzV.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mzV.setState(0);
            this.mzV.setOnClickListener(this);
            this.amR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amR.setOnClickListener(this);
            this.mzZ.setOnClickListener(this);
            this.gqV = new TbCyberVideoView(this.mContext);
            this.gqV.setTryUseViewInSet(true);
            dCw();
            this.mzX.setPlayViewOnClickListener(this);
            this.mAe.setOnClickListener(null);
            this.mAe.setOnTouchListener(this.fGd);
            this.mzY.setOnTouchListener(this.fGd);
            this.mAd.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jfa);
            HS(this.mzE);
            this.jyZ = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dCw() {
        if (this.gqV != null && this.gqV.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mAe.addView(this.gqV.getView(), 0);
            this.gqV.getView().setLayoutParams(layoutParams);
            this.mzW.setPlayer(this.gqV);
            this.gqV.setContinuePlayEnable(true);
            this.gqV.setOnPreparedListener(this);
            this.gqV.setOnCompletionListener(this);
            this.gqV.setOnErrorListener(this);
            this.gqV.setOnSurfaceDestroyedListener(this);
            this.gqV.setOnInfoListener(this);
            this.gqV.setVideoStatData(this.mAh);
            this.gqV.setThreadDataForStatistic(this.mAi);
            this.gqV.getMediaProgressObserver().a(this.mAw);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        if (byVar != null && byVar.bph() != null) {
            this.startPosition = -1L;
            if (this.jyZ != null) {
                this.jyZ.reset();
            }
            if (!au.equals(this.mVideoUrl, byVar.bph().video_url)) {
                stopPlay();
                this.amX = byVar.bph().is_vertical.intValue() == 1;
                this.mVideoUrl = byVar.bph().video_url;
                this.amY = byVar.getTid();
                this.amZ = byVar.bph().video_length.intValue();
                this.mAg = byVar.bph().video_duration.intValue();
                this.mFid = byVar.getFid();
                this.mAu = byVar.bph().mcn_ad_card;
                dxb();
                dxc();
                HS(this.mzE);
                int intValue = byVar.bph().video_duration.intValue() * 1000;
                this.mzW.IK(intValue);
                this.mzW.setPlayer(this.gqV);
                this.amU.setText(au.stringForVideoTime(intValue));
                this.amS.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(byVar.bph().play_count.intValue())));
                this.mzX.setVideoLength(byVar.bph().video_length.intValue());
                this.mzX.setVideoDuration(byVar.bph().video_duration.intValue());
                this.mzX.setTid(this.amY);
                this.mAi = byVar;
                this.gqV.setThreadDataForStatistic(byVar);
                this.amT.setVisibility(8);
                this.amP.setPlaceHolder(3);
                this.amP.startLoad(byVar.bph().thumbnail_url, 10, false);
                this.mzY.setShareData(byVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gqV != null) {
            this.mAh = oVar;
            this.gqV.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.agK = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void IM(int i) {
        this.gqV.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ajD = bdUniqueId;
    }

    public void dCx() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mzQ);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mzQ, this.mzp);
    }

    public void dCy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mzQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRi() {
        this.mzS.setAlpha(1.0f);
        this.mzS.setVisibility(0);
        this.amQ.setVisibility(8);
        if (this.mzS != null) {
            this.mzS.loop(true);
            this.mzS.setMinAndMaxFrame(14, 80);
            this.mzS.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwZ() {
        if (this.mzO == this.mzG) {
            HS(this.mzF);
        }
    }

    private void dCz() {
        HS(this.mzG);
        this.mzW.showProgress();
        if (this.mzS != null) {
            this.mzS.clearAnimation();
            this.mzS.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dwZ();
                    if (!d.this.mAf) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mzS.setVisibility(8);
                    d.this.amQ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dCA() {
        return this.mzX != null && this.mzX.dxj();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.ajC = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dCA()) {
                HS(this.mzL);
                return;
            }
            this.mAf = true;
            if (!this.gqV.isPlaying()) {
                TbCyberVideoView Rq = TbVideoViewSet.dCo().Rq(this.mVideoUrl);
                if (Rq == null) {
                    this.gqV.dCl();
                    if (!StringUtils.isNull(this.gqV.getOriginUrl())) {
                        this.gqV = new TbCyberVideoView(this.mContext);
                        this.gqV.setTryUseViewInSet(true);
                    }
                    dCw();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gqV.setVideoDuration(this.mAg);
                        this.gqV.setVideoPath(this.mVideoUrl, this.amY);
                        this.gqV.setStageType(this.ajC);
                        bRi();
                        if (this.mAj) {
                            dxh();
                        }
                    }
                } else {
                    if (this.gqV == Rq) {
                        if (this.gqV.getParent() == null || this.gqV.getParent() != Rq.getParent()) {
                            this.gqV.dCl();
                            dCw();
                        }
                    } else {
                        this.gqV.dCl();
                        Rq.dCl();
                        this.gqV = Rq;
                        this.gqV.setTryUseViewInSet(true);
                        dCw();
                    }
                    this.gqV.dCm();
                    onPrepared();
                    dCF();
                    if (this.mAj) {
                        dxh();
                    }
                }
                if (this.mAj) {
                    TiebaStatic.log(new ar("c13357").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).al("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mAf = false;
        if (this.mzS != null) {
            this.mzS.cancelAnimation();
        }
        this.gqV.stop();
        this.gqV.dCl();
        this.mzW.aSx();
        HS(this.mzE);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mAf = false;
        if (this.mzS != null) {
            this.mzS.cancelAnimation();
        }
        this.gqV.stop();
        this.mzW.aSx();
        HS(this.mzE);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dxh() {
        if (this.mAh != null) {
            o dCb = this.mAh.dCb();
            dCb.mLocate = this.mFrom;
            h.a(dCb.myv, "", "1", dCb, this.gqV.getPcdnState());
        }
    }

    public void HS(int i) {
        dCy();
        if (this.mzO == this.mzM) {
            this.mzP = i;
            return;
        }
        this.mzO = i;
        this.amP.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mzR.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mzS.clearAnimation();
        this.mzS.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mzS.cancelAnimation();
        } else {
            this.mzS.setAlpha(1.0f);
        }
        this.amQ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.amR.setVisibility((i & 8) > 0 ? 0 : 8);
        this.amS.setVisibility((i & 16) > 0 ? 0 : 8);
        this.amU.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mzU.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mzV.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mzW.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mzT.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mzW.getVisibility() == 0) {
            this.mzW.showProgress();
        }
        this.mzX.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mzY.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mzY.getVisibility() == 0) {
            this.mzY.setAlpha(1.0f);
        }
        this.mzZ.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mAa.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mAb.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mAd.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            HT(id);
            if (id == R.id.video_mute) {
                dCC();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dCE();
            } else if (id == R.id.video_replay) {
                HS(this.mzE);
                startPlay();
                if (this.mAj) {
                    TiebaStatic.log(new ar("c13345").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_locate", this.lDy ? 1 : 2));
                }
                dCB();
            } else if (id == R.id.video_play) {
                if (this.mzO == this.mzE) {
                    startPlay();
                } else {
                    HS(this.mzH);
                    dCx();
                    this.gqV.a(this.mAx);
                }
                if (this.mAj) {
                    TiebaStatic.log(new ar("c13344").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_source", this.lDy ? 1 : 2).al("obj_locate", 1));
                }
                dCB();
            } else if (id == R.id.video_pause) {
                HS(this.mzI);
                dCy();
                this.gqV.pause();
                if (this.mAj) {
                    TiebaStatic.log(new ar("c13344").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_source", this.lDy ? 1 : 2).al("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                HS(this.mzE);
                startPlay();
            } else if (id == R.id.retry) {
                HS(this.mzE);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCB() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ajD);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gqV.setVolume(0.0f, 0.0f);
            this.mzU.setState(1);
            return;
        }
        this.gqV.setVolume(1.0f, 1.0f);
        this.mzU.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCC() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gqV.setVolume(1.0f, 1.0f);
            ai.a(this.mWeakContext, true);
            this.mzU.setState(0);
        } else {
            this.gqV.setVolume(0.0f, 0.0f);
            this.mzU.setState(1);
            ai.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void xa(boolean z) {
        if (this.kUk == null) {
            this.kUk = new j((Activity) this.mContext);
        }
        if (z) {
            this.kUk.start();
            this.kUk.da(true);
            return;
        }
        this.kUk.stop();
        this.kUk.da(false);
    }

    public void dCD() {
        wj(true);
    }

    public void wj(boolean z) {
        if (this.mRootView != null && this.mAe != null && this.gqV != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kUk == null) {
                this.kUk = new j((Activity) this.mContext);
            }
            if (this.lDy) {
                if (this.mAc.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mAc.getParent()).removeView(this.mAc);
                }
                if ((this.mAe.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lDy = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mAe.getParent()).removeView(this.mAe);
                    ((ViewGroup) this.mRootView).addView(this.mAe);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lDy);
                }
                if (!this.amX && z) {
                    this.kUk.Vh();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.amX && z) {
                        this.kUk.Vh();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mAe.getLocationOnScreen(this.mAn);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mAc == null) {
                                    this.mAc = new View(this.mContext);
                                    this.mAc.setClickable(true);
                                    this.mAc.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mAc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mAc.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mAc.getParent()).removeView(this.mAc);
                                }
                                this.mAc.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mAc);
                                ((ViewGroup) childAt).addView(this.mAe);
                                this.isChangingOrientation = false;
                                this.lDy = true;
                                k((Activity) this.mContext, this.lDy);
                                if (this.jyZ != null && this.jyZ.isShowing()) {
                                    this.jyZ.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mAj) {
                    TiebaStatic.log(new ar("c13360").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2));
                }
            }
            dxb();
            dxc();
            if (this.gqV.isPlaying()) {
                HS(this.mzF);
            } else {
                HS(this.mzO);
            }
            this.mzV.dYh();
            xb(this.lDy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCE() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.amX) {
            dCD();
        } else if (this.mzO == this.mzM) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mAe.setScaleX(1.0f);
                    d.this.mAe.setScaleY(1.0f);
                    d.this.mAe.setTranslationX(0.0f);
                    d.this.mAe.setTranslationY(0.0f);
                    d.this.mzY.setScaleX(1.0f);
                    d.this.mzY.setScaleY(1.0f);
                    d.this.mAe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mAp) {
                        d.this.dCD();
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
            if (!this.mAp) {
                float width = this.mRootView.getWidth() / this.mAe.getWidth();
                float height = this.mRootView.getHeight() / this.mAe.getHeight();
                this.mAe.setPivotX(0.0f);
                this.mAe.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mAe, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mAe, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mzY, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mzY, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mAe, "TranslationX", this.mAe.getTranslationX(), this.mAn[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mAe, "TranslationY", this.mAe.getTranslationY(), this.mAn[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mAc, "alpha", this.mAc.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mzY, "alpha", this.mzY.getAlpha(), 0.0f);
            } else {
                float width2 = this.mAl / this.mAe.getWidth();
                float height2 = this.mAo / this.mAe.getHeight();
                this.mAe.setPivotX(0.0f);
                this.mAe.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mAe, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mAe, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mzY, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mzY, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mAe, "TranslationX", this.mAe.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mAe, "TranslationY", this.mAe.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mzY, "alpha", this.mzY.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mzP != -1) {
                this.mzO = this.mzP;
                this.mzP = -1;
                if (this.mzO == this.mzN || this.mzO == this.mzH || this.mzO == this.mzF) {
                    this.gqV.a(this.mAx);
                    HS(this.mzF);
                }
            }
        } else {
            dCD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.amX && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mAe != null) {
                    if (z) {
                        this.mAe.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mAe.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                der();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mAe.setSystemUiVisibility(0);
            }
        }
    }

    private void dCF() {
        HS(this.mzG);
        this.mzW.showProgress();
        dCz();
    }

    protected void xb(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mAf) {
            if (this.lDy && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gqV.a(this.mAx);
        }
    }

    public void onCompletion() {
        HS(this.mzK);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        HS(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mzO == this.mzI || (this.mzO == this.mzJ && !this.gqV.isPlaying())) {
                stopPlayForSurfaceDestroy();
                HS(this.mzI);
            } else if (this.mzO == this.mzK) {
                stopPlayForSurfaceDestroy();
                HS(this.mzK);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dCF();
        }
        if (i == 701) {
            bRi();
            return false;
        } else if (i == 702) {
            dCF();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dBI() {
        return this.mAe;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mAf || this.gqV.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gqV.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bWE() {
    }

    protected void HT(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lDy;
    }

    protected boolean dxa() {
        return this.amX && this.lDy;
    }

    private void der() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mAe.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mAe.setSystemUiVisibility(4);
        } else {
            this.mAe.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dxe() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gqV.isPlaying() && !ai.bGU()) {
            this.gqV.setVolume(1.0f, 1.0f);
            this.mzU.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dxf() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean rJ(boolean z) {
        if (z) {
            this.mzS.cancelAnimation();
            if (this.mzO == this.mzF || this.mzO == this.mzG || this.mzO == this.mzH || this.mzO == this.mzE) {
                stopPlay();
            }
            this.mzO |= 1;
            HS(this.mzO);
        } else if (this.mzO == this.mzE) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lDy;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dCu() {
        if (this.lDy) {
            dCE();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cQC() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dCG() {
        return this.mAu != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xc(boolean z) {
        this.agX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mAv = aVar;
    }
}
