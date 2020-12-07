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
    protected TbCyberVideoView gqT;
    private com.baidu.mcn.c jyX;
    private j kUi;
    private View mAa;
    private OperableVideoErrorView mAb;
    protected ViewGroup mAc;
    protected boolean mAd;
    protected int mAe;
    protected o mAf;
    protected by mAg;
    private float mAi;
    private float mAj;
    private int mAk;
    private int mAm;
    private boolean mAn;
    private float mAq;
    private int mAr;
    private McnAdInfo mAs;
    private a mAt;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    private View mzP;
    private TBLottieAnimationView mzQ;
    private PercentSizeView mzR;
    protected SwitchImageView mzS;
    protected SwitchImageView mzT;
    protected OperableVideoMediaControllerView mzU;
    protected OperableVideoNetworkStateTipView mzV;
    protected OperableVideoShareView mzW;
    protected ImageView mzX;
    protected View mzY;
    protected VideoGestureView mzZ;
    protected int mzn = 3000;
    protected final int mzo = 1;
    protected final int mzp = 2;
    protected final int mzq = 4;
    protected final int mzr = 8;
    protected final int mzs = 16;
    protected final int mzt = 32;
    protected final int mzu = 64;
    protected final int mzv = 128;
    protected final int mzw = 256;
    protected final int mzx = 512;
    protected final int mzy = 1024;
    protected final int mzz = 2048;
    protected final int mzA = 4096;
    protected final int mzB = 8192;
    protected int mzC = 8211;
    protected int mzD = 0;
    protected int mzE = 4;
    protected int mzF = 232;
    protected int mzG = 8416;
    protected int mzH = 0;
    protected int mzI = 513;
    protected int mzJ = 259;
    protected int mzK = 2048;
    protected int mzL = 0;
    protected int STATE_ERROR = 4099;
    protected int mzM = this.mzC;
    private int maG = 0;
    private int mzN = -1;
    private Runnable mzO = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.HS(d.this.mzD);
        }
    };
    private WeakReference<Context> mWeakContext = null;
    protected boolean lDw = false;
    protected boolean mAh = true;
    private boolean isChangingOrientation = false;
    private int[] mAl = new int[2];
    private int mAo = 0;
    private int mAp = 0;
    protected View.OnClickListener akt = null;
    protected View.OnClickListener agK = null;
    private boolean agX = false;
    private long startPosition = -1;
    private f.b mAu = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ci(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dCF() && !d.this.amX && !d.this.lDw && d.this.agX) {
                if (!com.baidu.mcn.b.abJ().jK(d.this.mAs.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mAs.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mAs.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mAs.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jyX.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.cbD = d.this.mAs.card_title;
                            aVar.cbE = d.this.mAs.button_title;
                            aVar.cbF = d.this.mAs.jump_url;
                            aVar.cbC = d.this.mAs.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.amY;
                            aVar.cbG = d.this.cQB();
                            if (z2) {
                                d.this.jyX.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jyX.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jyX.isShowing()) {
                        d.this.jyX.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mAt != null) {
                d.this.mAt.cM(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener gaI = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.HS(d.this.mzF);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gqT.isPlaying()) {
                    d.this.gqT.a(d.this.mAv);
                }
                d.this.dCw();
                if (d.this.mAh) {
                    TiebaStatic.log(new ar("c13355").dY("tid", d.this.amY).w("fid", d.this.mFid).al("obj_type", d.this.amX ? 1 : 2).al("obj_locate", d.this.lDw ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener jeY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gqT.isPlaying()) {
                d.this.gqT.pause();
                if (d.this.mzM == d.this.mzF) {
                    d.this.HS(d.this.mzG);
                } else {
                    d.this.HS(d.this.mzH);
                }
                d.this.HT(R.id.video_pause);
            } else if (d.this.mzM == d.this.mzG || d.this.mzM == (d.this.mzG | 1)) {
                d.this.HS(d.this.mzF);
                d.this.dCw();
                d.this.gqT.a(d.this.mAv);
                d.this.HT(R.id.video_play);
            } else if (d.this.mzM == d.this.mzH || d.this.mzM == (d.this.mzH | 1)) {
                d.this.HS(d.this.mzD);
                d.this.gqT.a(d.this.mAv);
                d.this.HT(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gqT.isPlaying()) {
                if (d.this.mzM == d.this.mzD || d.this.mzM == d.this.mzE) {
                    d.this.HS(d.this.mzF);
                    d.this.dCw();
                    return true;
                } else if (d.this.mzM == d.this.mzF) {
                    d.this.HS(d.this.mzD);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mzM == d.this.mzG) {
                d.this.HS(d.this.mzH);
                return true;
            } else if (d.this.mzM == (d.this.mzG | 1)) {
                d.this.HS(d.this.mzH | 1);
                return true;
            } else if (d.this.mzM == d.this.mzH) {
                d.this.HS(d.this.mzG);
                return true;
            } else if (d.this.mzM == (d.this.mzH | 1)) {
                d.this.HS(d.this.mzG | 1);
                return true;
            } else {
                d.this.HS(d.this.mzC);
                d.this.startPlay();
                d.this.dCA();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.maG = 0;
            if (d.this.lDw) {
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
            if (d.this.amX && d.this.dwZ()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.maG) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gqT.isPlaying()) {
                                d.this.gqT.pause();
                                d.this.HS(d.this.mzL);
                            }
                            d.this.maG = 4;
                            d.this.mzN = d.this.mzM;
                            d.this.mzM = d.this.mzK;
                            d.this.mAm = d.this.mAc.getMeasuredHeight();
                            d.this.mAq = d.this.mAj / d.this.mAm;
                            d.this.mAr = (int) (1.2f * d.this.mRootView.getWidth());
                            dm(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dm(rawX, rawY);
                        break;
                }
            } else if (d.this.mzM == d.this.mzD || d.this.mzM == d.this.mzF || d.this.mzM == d.this.mzG || d.this.mzM == d.this.mzH || d.this.mzM == d.this.mzK || d.this.mzM == (d.this.mzG | 1) || d.this.mzM == (d.this.mzH | 1)) {
                switch (d.this.maG) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.maG = 3;
                            d.this.mAk = d.this.gqT.getCurrentPosition();
                            aT(f);
                        } else if (motionEvent.getX() < d.this.mAc.getWidth() / 2) {
                            d.this.maG = 2;
                            d.this.mzZ.y(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.maG = 1;
                            d.this.mzZ.x(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mzM != d.this.mzK) {
                            if ((d.this.mzM & 1) > 0) {
                                d.this.mzK |= 1;
                            } else {
                                d.this.mzK &= -2;
                            }
                            d.this.HS(d.this.mzK);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mzZ.x(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dxd();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mzZ.y(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aT(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dm(int i, int i2) {
            if (d.this.mAo != i2 || d.this.mAp != i) {
                d.this.mAn = d.this.mAo - i2 > 0 || ((float) i2) < d.this.mAi / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mAc.getLayoutParams();
                if (i2 != d.this.mAo) {
                    int i3 = d.this.mAm - i2;
                    int i4 = (int) (i3 * d.this.mAq);
                    if (i4 < d.this.mAr) {
                        i4 = d.this.mAr;
                        i3 = (int) (i4 / d.this.mAq);
                    }
                    if (i4 != d.this.mAr) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mAc.setLayoutParams(layoutParams);
                    }
                    d.this.mAo = i2;
                    d.this.mAc.setTranslationY(d.this.mAo);
                }
                if (i != d.this.mAo) {
                    d.this.mAp = i;
                    d.this.mAc.setTranslationX(d.this.mAp + ((d.this.mAj - layoutParams.width) / 2.0f));
                }
                d.this.mAa.setAlpha((layoutParams.width - d.this.mAr) / (d.this.mAj - d.this.mAr));
                if (d.this.mzW.getVisibility() == 0) {
                    float f = d.this.mAi / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mzW.setAlpha(f2);
                }
            }
        }

        private void aT(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mAk -= 1000;
                z = true;
            } else {
                d.this.mAk += 1000;
                z = false;
            }
            int duration = d.this.gqT.getDuration();
            if (d.this.mAk < 0) {
                d.this.mAk = 0;
            } else if (d.this.mAk > duration) {
                d.this.mAk = duration;
            }
            String str = au.stringForVideoTime(d.this.mAk) + " / " + au.stringForVideoTime(duration);
            if (d.this.mzZ != null) {
                d.this.mzZ.E(z, str);
            }
            d.this.mzU.setCurrentDuration(d.this.mAk, false);
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mzM == d.this.mzK) {
                if (d.this.maG == 4) {
                    d.this.dCD();
                    d.this.mAo = 0;
                    d.this.mAp = 0;
                } else {
                    d.this.mzM = -1;
                    if (d.this.maG != 3) {
                        if (d.this.mzN != -1) {
                            d.this.HS(d.this.mzN);
                            d.this.mzN = -1;
                        } else if (d.this.gqT.isPlaying()) {
                            d.this.HS(d.this.mzD);
                        } else {
                            d.this.HS(d.this.mzG);
                        }
                    } else {
                        d.this.mzU.setCurrentDuration(d.this.mAk, true);
                        if (d.this.mAk <= d.this.gqT.getDuration()) {
                            if (!d.this.gqT.isPlaying()) {
                                d.this.gqT.a(d.this.mAv);
                            }
                            d.this.HS(d.this.mzD);
                        }
                    }
                }
                if (d.this.mAh) {
                    String str = null;
                    if (d.this.maG != 1) {
                        if (d.this.maG != 2) {
                            if (d.this.maG == 3) {
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
                d.this.maG = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mAv = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCo() {
            d.this.gqT.dCk();
            d.this.dCv();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dCp() {
            d.this.HS(d.this.mzC);
            d.this.bRh();
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
            this.mAi = l.getEquipmentHeight(this.mContext);
            this.mAj = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dxb() {
        int dimension;
        int i;
        int i2;
        this.mzV.as(this.amX, this.lDw);
        this.mzW.as(this.amX, this.lDw);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.amX) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.lDw) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.amS.setPadding(0, 0, i2, 0);
            this.mzT.setPadding(this.mzT.getPaddingLeft(), 0, i, 0);
            this.mzS.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dxa() {
        if (this.amX) {
            this.mzF = 104;
            this.mzG = 8290;
        } else {
            this.mzF = 232;
            this.mzG = 8418;
        }
        if (this.lDw) {
            this.mzC |= 1024;
            this.mzD |= 1024;
            this.mzE |= 1024;
            this.mzF |= 1024;
            this.mzG |= 1024;
            this.mzH |= 1024;
            this.mzI |= 1024;
            this.mzJ |= 1024;
            this.mzM |= 1024;
            return;
        }
        this.mzC &= -1025;
        this.mzD &= -1025;
        this.mzE &= -1025;
        this.mzF &= -1025;
        this.mzG &= -1025;
        this.mzH &= -1025;
        this.mzI &= -1025;
        this.mzJ &= -1025;
        this.mzM &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mAc = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mAc);
            }
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            this.amP = (TbImageView) this.mAc.findViewById(R.id.video_thumbnail);
            this.mzP = this.mAc.findViewById(R.id.black_mask);
            this.mzQ = (TBLottieAnimationView) this.mAc.findViewById(R.id.video_loading);
            this.amQ = (ImageView) this.mAc.findViewById(R.id.video_play);
            this.mzR = (PercentSizeView) this.mAc.findViewById(R.id.video_media_controller_mask);
            this.amR = (ImageView) this.mAc.findViewById(R.id.video_pause);
            this.amS = (TextView) this.mAc.findViewById(R.id.video_play_count);
            this.amT = (TextView) this.mAc.findViewById(R.id.video_play_flag);
            this.amU = (TextView) this.mAc.findViewById(R.id.video_duration);
            this.mzS = (SwitchImageView) this.mAc.findViewById(R.id.video_mute);
            this.mzT = (SwitchImageView) this.mAc.findViewById(R.id.video_full_screen);
            this.mzU = (OperableVideoMediaControllerView) this.mAc.findViewById(R.id.video_media_controller);
            this.mzV = (OperableVideoNetworkStateTipView) this.mAc.findViewById(R.id.video_network_state_tip);
            this.mzW = (OperableVideoShareView) this.mAc.findViewById(R.id.video_share_view);
            this.mzY = this.mAc.findViewById(R.id.video_back_btn_mask);
            this.mzX = (ImageView) this.mAc.findViewById(R.id.video_full_screen_back);
            this.mzZ = (VideoGestureView) this.mAc.findViewById(R.id.video_gesture);
            this.mAb = (OperableVideoErrorView) this.mAc.findViewById(R.id.video_error_layout);
            this.mzW.setVideoContainer(this);
            this.mzQ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mzQ.setVisibility(8);
                    d.this.amQ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mzQ.setAnimation(R.raw.lotti_video_loading);
            this.amQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amQ.setOnClickListener(this);
            this.mzS.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mzS.setState(1);
            this.mzS.setOnClickListener(this);
            this.amP.bHt();
            this.amP.setDrawCorner(false);
            this.amP.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.j(this.mzP, R.color.CAM_X0607);
            this.mzU.setOnSeekBarChangeListener(this.gaI);
            this.mzR.setHeightPercent(0.583f);
            this.mzR.setBackgroundResource(R.drawable.video_mask_bg);
            this.mzT.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mzT.setState(0);
            this.mzT.setOnClickListener(this);
            this.amR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.amR.setOnClickListener(this);
            this.mzX.setOnClickListener(this);
            this.gqT = new TbCyberVideoView(this.mContext);
            this.gqT.setTryUseViewInSet(true);
            dCv();
            this.mzV.setPlayViewOnClickListener(this);
            this.mAc.setOnClickListener(null);
            this.mAc.setOnTouchListener(this.fGd);
            this.mzW.setOnTouchListener(this.fGd);
            this.mAb.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.jeY);
            HS(this.mzC);
            this.jyX = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dCv() {
        if (this.gqT != null && this.gqT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mAc.addView(this.gqT.getView(), 0);
            this.gqT.getView().setLayoutParams(layoutParams);
            this.mzU.setPlayer(this.gqT);
            this.gqT.setContinuePlayEnable(true);
            this.gqT.setOnPreparedListener(this);
            this.gqT.setOnCompletionListener(this);
            this.gqT.setOnErrorListener(this);
            this.gqT.setOnSurfaceDestroyedListener(this);
            this.gqT.setOnInfoListener(this);
            this.gqT.setVideoStatData(this.mAf);
            this.gqT.setThreadDataForStatistic(this.mAg);
            this.gqT.getMediaProgressObserver().a(this.mAu);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        if (byVar != null && byVar.bph() != null) {
            this.startPosition = -1L;
            if (this.jyX != null) {
                this.jyX.reset();
            }
            if (!au.equals(this.mVideoUrl, byVar.bph().video_url)) {
                stopPlay();
                this.amX = byVar.bph().is_vertical.intValue() == 1;
                this.mVideoUrl = byVar.bph().video_url;
                this.amY = byVar.getTid();
                this.amZ = byVar.bph().video_length.intValue();
                this.mAe = byVar.bph().video_duration.intValue();
                this.mFid = byVar.getFid();
                this.mAs = byVar.bph().mcn_ad_card;
                dxa();
                dxb();
                HS(this.mzC);
                int intValue = byVar.bph().video_duration.intValue() * 1000;
                this.mzU.IK(intValue);
                this.mzU.setPlayer(this.gqT);
                this.amU.setText(au.stringForVideoTime(intValue));
                this.amS.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(byVar.bph().play_count.intValue())));
                this.mzV.setVideoLength(byVar.bph().video_length.intValue());
                this.mzV.setVideoDuration(byVar.bph().video_duration.intValue());
                this.mzV.setTid(this.amY);
                this.mAg = byVar;
                this.gqT.setThreadDataForStatistic(byVar);
                this.amT.setVisibility(8);
                this.amP.setPlaceHolder(3);
                this.amP.startLoad(byVar.bph().thumbnail_url, 10, false);
                this.mzW.setShareData(byVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gqT != null) {
            this.mAf = oVar;
            this.gqT.setVideoStatData(oVar);
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
        this.gqT.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ajD = bdUniqueId;
    }

    public void dCw() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mzO);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mzO, this.mzn);
    }

    public void dCx() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mzO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRh() {
        this.mzQ.setAlpha(1.0f);
        this.mzQ.setVisibility(0);
        this.amQ.setVisibility(8);
        if (this.mzQ != null) {
            this.mzQ.loop(true);
            this.mzQ.setMinAndMaxFrame(14, 80);
            this.mzQ.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwY() {
        if (this.mzM == this.mzE) {
            HS(this.mzD);
        }
    }

    private void dCy() {
        HS(this.mzE);
        this.mzU.showProgress();
        if (this.mzQ != null) {
            this.mzQ.clearAnimation();
            this.mzQ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dwY();
                    if (!d.this.mAd) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mzQ.setVisibility(8);
                    d.this.amQ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dCz() {
        return this.mzV != null && this.mzV.dxi();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.ajC = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            if (dCz()) {
                HS(this.mzJ);
                return;
            }
            this.mAd = true;
            if (!this.gqT.isPlaying()) {
                TbCyberVideoView Rq = TbVideoViewSet.dCn().Rq(this.mVideoUrl);
                if (Rq == null) {
                    this.gqT.dCk();
                    if (!StringUtils.isNull(this.gqT.getOriginUrl())) {
                        this.gqT = new TbCyberVideoView(this.mContext);
                        this.gqT.setTryUseViewInSet(true);
                    }
                    dCv();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gqT.setVideoDuration(this.mAe);
                        this.gqT.setVideoPath(this.mVideoUrl, this.amY);
                        this.gqT.setStageType(this.ajC);
                        bRh();
                        if (this.mAh) {
                            dxg();
                        }
                    }
                } else {
                    if (this.gqT == Rq) {
                        if (this.gqT.getParent() == null || this.gqT.getParent() != Rq.getParent()) {
                            this.gqT.dCk();
                            dCv();
                        }
                    } else {
                        this.gqT.dCk();
                        Rq.dCk();
                        this.gqT = Rq;
                        this.gqT.setTryUseViewInSet(true);
                        dCv();
                    }
                    this.gqT.dCl();
                    onPrepared();
                    dCE();
                    if (this.mAh) {
                        dxg();
                    }
                }
                if (this.mAh) {
                    TiebaStatic.log(new ar("c13357").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).al("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mAd = false;
        if (this.mzQ != null) {
            this.mzQ.cancelAnimation();
        }
        this.gqT.stop();
        this.gqT.dCk();
        this.mzU.aSx();
        HS(this.mzC);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    private void stopPlayForSurfaceDestroy() {
        this.mAd = false;
        if (this.mzQ != null) {
            this.mzQ.cancelAnimation();
        }
        this.gqT.stop();
        this.mzU.aSx();
        HS(this.mzC);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    public void dxg() {
        if (this.mAf != null) {
            o dCa = this.mAf.dCa();
            dCa.mLocate = this.mFrom;
            h.a(dCa.myt, "", "1", dCa, this.gqT.getPcdnState());
        }
    }

    public void HS(int i) {
        dCx();
        if (this.mzM == this.mzK) {
            this.mzN = i;
            return;
        }
        this.mzM = i;
        this.amP.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mzP.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mzQ.clearAnimation();
        this.mzQ.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mzQ.cancelAnimation();
        } else {
            this.mzQ.setAlpha(1.0f);
        }
        this.amQ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.amR.setVisibility((i & 8) > 0 ? 0 : 8);
        this.amS.setVisibility((i & 16) > 0 ? 0 : 8);
        this.amU.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mzS.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mzT.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mzU.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mzR.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mzU.getVisibility() == 0) {
            this.mzU.showProgress();
        }
        this.mzV.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mzW.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mzW.getVisibility() == 0) {
            this.mzW.setAlpha(1.0f);
        }
        this.mzX.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mzY.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mzZ.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mAb.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            HT(id);
            if (id == R.id.video_mute) {
                dCB();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dCD();
            } else if (id == R.id.video_replay) {
                HS(this.mzC);
                startPlay();
                if (this.mAh) {
                    TiebaStatic.log(new ar("c13345").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_locate", this.lDw ? 1 : 2));
                }
                dCA();
            } else if (id == R.id.video_play) {
                if (this.mzM == this.mzC) {
                    startPlay();
                } else {
                    HS(this.mzF);
                    dCw();
                    this.gqT.a(this.mAv);
                }
                if (this.mAh) {
                    TiebaStatic.log(new ar("c13344").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_source", this.lDw ? 1 : 2).al("obj_locate", 1));
                }
                dCA();
            } else if (id == R.id.video_pause) {
                HS(this.mzG);
                dCx();
                this.gqT.pause();
                if (this.mAh) {
                    TiebaStatic.log(new ar("c13344").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2).al("obj_source", this.lDw ? 1 : 2).al("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                HS(this.mzC);
                startPlay();
            } else if (id == R.id.retry) {
                HS(this.mzC);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCA() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ajD);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gqT.setVolume(0.0f, 0.0f);
            this.mzS.setState(1);
            return;
        }
        this.gqT.setVolume(1.0f, 1.0f);
        this.mzS.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dCB() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gqT.setVolume(1.0f, 1.0f);
            ai.a(this.mWeakContext, true);
            this.mzS.setState(0);
        } else {
            this.gqT.setVolume(0.0f, 0.0f);
            this.mzS.setState(1);
            ai.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void xa(boolean z) {
        if (this.kUi == null) {
            this.kUi = new j((Activity) this.mContext);
        }
        if (z) {
            this.kUi.start();
            this.kUi.da(true);
            return;
        }
        this.kUi.stop();
        this.kUi.da(false);
    }

    public void dCC() {
        wj(true);
    }

    public void wj(boolean z) {
        if (this.mRootView != null && this.mAc != null && this.gqT != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kUi == null) {
                this.kUi = new j((Activity) this.mContext);
            }
            if (this.lDw) {
                if (this.mAa.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mAa.getParent()).removeView(this.mAa);
                }
                if ((this.mAc.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lDw = false;
                    this.isChangingOrientation = true;
                    ((ViewGroup) this.mAc.getParent()).removeView(this.mAc);
                    ((ViewGroup) this.mRootView).addView(this.mAc);
                    this.isChangingOrientation = false;
                    k((Activity) this.mContext, this.lDw);
                }
                if (!this.amX && z) {
                    this.kUi.Vh();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.amX && z) {
                        this.kUi.Vh();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mAc.getLocationOnScreen(this.mAl);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.isChangingOrientation = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mAa == null) {
                                    this.mAa = new View(this.mContext);
                                    this.mAa.setClickable(true);
                                    this.mAa.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mAa.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mAa.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mAa.getParent()).removeView(this.mAa);
                                }
                                this.mAa.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mAa);
                                ((ViewGroup) childAt).addView(this.mAc);
                                this.isChangingOrientation = false;
                                this.lDw = true;
                                k((Activity) this.mContext, this.lDw);
                                if (this.jyX != null && this.jyX.isShowing()) {
                                    this.jyX.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mAh) {
                    TiebaStatic.log(new ar("c13360").dY("tid", this.amY).w("fid", this.mFid).al("obj_type", this.amX ? 1 : 2));
                }
            }
            dxa();
            dxb();
            if (this.gqT.isPlaying()) {
                HS(this.mzD);
            } else {
                HS(this.mzM);
            }
            this.mzT.dYg();
            xb(this.lDw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCD() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.amX) {
            dCC();
        } else if (this.mzM == this.mzK) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mAc.setScaleX(1.0f);
                    d.this.mAc.setScaleY(1.0f);
                    d.this.mAc.setTranslationX(0.0f);
                    d.this.mAc.setTranslationY(0.0f);
                    d.this.mzW.setScaleX(1.0f);
                    d.this.mzW.setScaleY(1.0f);
                    d.this.mAc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mAn) {
                        d.this.dCC();
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
            if (!this.mAn) {
                float width = this.mRootView.getWidth() / this.mAc.getWidth();
                float height = this.mRootView.getHeight() / this.mAc.getHeight();
                this.mAc.setPivotX(0.0f);
                this.mAc.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mAc, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mAc, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mzW, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mzW, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mAc, "TranslationX", this.mAc.getTranslationX(), this.mAl[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mAc, "TranslationY", this.mAc.getTranslationY(), this.mAl[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mAa, "alpha", this.mAa.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mzW, "alpha", this.mzW.getAlpha(), 0.0f);
            } else {
                float width2 = this.mAj / this.mAc.getWidth();
                float height2 = this.mAm / this.mAc.getHeight();
                this.mAc.setPivotX(0.0f);
                this.mAc.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mAc, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mAc, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mzW, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mzW, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mAc, "TranslationX", this.mAc.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mAc, "TranslationY", this.mAc.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mzW, "alpha", this.mzW.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mzN != -1) {
                this.mzM = this.mzN;
                this.mzN = -1;
                if (this.mzM == this.mzL || this.mzM == this.mzF || this.mzM == this.mzD) {
                    this.gqT.a(this.mAv);
                    HS(this.mzD);
                }
            }
        } else {
            dCC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.amX && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mAc != null) {
                    if (z) {
                        this.mAc.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mAc.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                deq();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mAc.setSystemUiVisibility(0);
            }
        }
    }

    private void dCE() {
        HS(this.mzE);
        this.mzU.showProgress();
        dCy();
    }

    protected void xb(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        if (this.mAd) {
            if (this.lDw && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gqT.a(this.mAv);
        }
    }

    public void onCompletion() {
        HS(this.mzI);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        HS(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            if (this.mzM == this.mzG || (this.mzM == this.mzH && !this.gqT.isPlaying())) {
                stopPlayForSurfaceDestroy();
                HS(this.mzG);
            } else if (this.mzM == this.mzI) {
                stopPlayForSurfaceDestroy();
                HS(this.mzI);
            } else {
                stopPlayForSurfaceDestroy();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dCE();
        }
        if (i == 701) {
            bRh();
            return false;
        } else if (i == 702) {
            dCE();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dBH() {
        return this.mAc;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mAd || this.gqT.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gqT.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bWD() {
    }

    protected void HT(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lDw;
    }

    protected boolean dwZ() {
        return this.amX && this.lDw;
    }

    private void deq() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mAc.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mAc.setSystemUiVisibility(4);
        } else {
            this.mAc.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dxd() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gqT.isPlaying() && !ai.bGU()) {
            this.gqT.setVolume(1.0f, 1.0f);
            this.mzS.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dxe() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean rJ(boolean z) {
        if (z) {
            this.mzQ.cancelAnimation();
            if (this.mzM == this.mzD || this.mzM == this.mzE || this.mzM == this.mzF || this.mzM == this.mzC) {
                stopPlay();
            }
            this.mzM |= 1;
            HS(this.mzM);
        } else if (this.mzM == this.mzC) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lDw;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dCt() {
        if (this.lDw) {
            dCD();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cQB() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dCF() {
        return this.mAs != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xc(boolean z) {
        this.agX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mAt = aVar;
    }
}
