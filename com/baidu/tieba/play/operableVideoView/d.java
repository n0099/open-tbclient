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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private String aiy;
    protected BdUniqueId aiz;
    protected TbImageView alJ;
    private ImageView alK;
    private ImageView alL;
    protected TextView alM;
    protected TextView alN;
    private TextView alO;
    protected boolean alS;
    protected String alT;
    protected long alU;
    protected TbCyberVideoView gdn;
    private com.baidu.mcn.c jeM;
    private j kAH;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected OperableVideoShareView mfA;
    protected ImageView mfB;
    protected View mfC;
    protected VideoGestureView mfD;
    private View mfE;
    private OperableVideoErrorView mfF;
    protected ViewGroup mfG;
    protected boolean mfH;
    protected int mfI;
    protected o mfJ;
    protected bw mfK;
    private float mfN;
    private float mfO;
    private int mfP;
    private int mfR;
    private boolean mfS;
    private float mfV;
    private int mfW;
    private McnAdInfo mfX;
    private a mfY;
    private View mft;
    private TBLottieAnimationView mfu;
    private PercentSizeView mfv;
    protected SwitchImageView mfw;
    protected SwitchImageView mfx;
    protected OperableVideoMediaControllerView mfy;
    protected OperableVideoNetworkStateTipView mfz;
    protected int meR = 3000;
    protected final int meS = 1;
    protected final int meT = 2;
    protected final int meU = 4;
    protected final int meV = 8;
    protected final int meW = 16;
    protected final int meX = 32;
    protected final int meY = 64;
    protected final int meZ = 128;
    protected final int mfa = 256;
    protected final int mfb = 512;
    protected final int mfc = 1024;
    protected final int mfd = 2048;
    protected final int mfe = 4096;
    protected final int mff = 8192;
    protected int mfg = 8211;
    protected int mfh = 0;
    protected int mfi = 4;
    protected int mfj = 232;
    protected int mfk = 8416;
    protected int mfl = 0;
    protected int mfm = 513;
    protected int mfn = 259;
    protected int mfo = 2048;
    protected int mfp = 0;
    protected int STATE_ERROR = 4099;
    protected int mfq = this.mfg;
    private int lGq = 0;
    private int mfr = -1;
    private Runnable mfs = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Gq(d.this.mfh);
        }
    };
    private WeakReference<Context> alP = null;
    protected boolean ljx = false;
    protected boolean mfL = true;
    private boolean mfM = false;
    private int[] mfQ = new int[2];
    private int mfT = 0;
    private int mfU = 0;
    protected View.OnClickListener ajp = null;
    protected View.OnClickListener afJ = null;
    private boolean afT = false;
    private long startPosition = -1;
    private f.b mfZ = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void cc(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dvm() && !d.this.alS && !d.this.ljx && d.this.afT) {
                if (!com.baidu.mcn.b.Xq().iZ(d.this.mfX.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mfX.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mfX.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mfX.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jeM.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bSo = d.this.mfX.card_title;
                            aVar.bSp = d.this.mfX.button_title;
                            aVar.bSq = d.this.mfX.jump_url;
                            aVar.bSn = d.this.mfX.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.alT;
                            aVar.bSr = d.this.cJg();
                            if (z2) {
                                d.this.jeM.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jeM.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jeM.isShowing()) {
                        d.this.jeM.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mfY != null) {
                d.this.mfY.cF(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fNb = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Gq(d.this.mfj);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gdn.isPlaying()) {
                    d.this.gdn.a(d.this.mga);
                }
                d.this.dvc();
                if (d.this.mfL) {
                    TiebaStatic.log(new aq("c13355").dR("tid", d.this.alT).w("fid", d.this.mFid).aj("obj_type", d.this.alS ? 1 : 2).aj("obj_locate", d.this.ljx ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iNt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gdn.isPlaying()) {
                d.this.gdn.pause();
                if (d.this.mfq == d.this.mfj) {
                    d.this.Gq(d.this.mfk);
                } else {
                    d.this.Gq(d.this.mfl);
                }
                d.this.Gr(R.id.video_pause);
            } else if (d.this.mfq == d.this.mfk || d.this.mfq == (d.this.mfk | 1)) {
                d.this.Gq(d.this.mfj);
                d.this.dvc();
                d.this.gdn.a(d.this.mga);
                d.this.Gr(R.id.video_play);
            } else if (d.this.mfq == d.this.mfl || d.this.mfq == (d.this.mfl | 1)) {
                d.this.Gq(d.this.mfh);
                d.this.gdn.a(d.this.mga);
                d.this.Gr(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gdn.isPlaying()) {
                if (d.this.mfq == d.this.mfh || d.this.mfq == d.this.mfi) {
                    d.this.Gq(d.this.mfj);
                    d.this.dvc();
                    return true;
                } else if (d.this.mfq == d.this.mfj) {
                    d.this.Gq(d.this.mfh);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mfq == d.this.mfk) {
                d.this.Gq(d.this.mfl);
                return true;
            } else if (d.this.mfq == (d.this.mfk | 1)) {
                d.this.Gq(d.this.mfl | 1);
                return true;
            } else if (d.this.mfq == d.this.mfl) {
                d.this.Gq(d.this.mfk);
                return true;
            } else if (d.this.mfq == (d.this.mfl | 1)) {
                d.this.Gq(d.this.mfk | 1);
                return true;
            } else {
                d.this.Gq(d.this.mfg);
                d.this.startPlay();
                d.this.dvh();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.lGq = 0;
            if (d.this.ljx) {
                d.this.k((Activity) d.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!d.this.ab(motionEvent)) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if ((d.this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) d.this.mContext).disableSwipeJustOnce();
            } else if ((d.this.mContext instanceof BaseActivity) && ((BaseActivity) d.this.mContext).isSwipeBackEnabled()) {
                ((BaseActivity) d.this.mContext).disableSwipeJustOnce();
            }
            if (d.this.alS && d.this.dpF()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.lGq) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gdn.isPlaying()) {
                                d.this.gdn.pause();
                                d.this.Gq(d.this.mfp);
                            }
                            d.this.lGq = 4;
                            d.this.mfr = d.this.mfq;
                            d.this.mfq = d.this.mfo;
                            d.this.mfR = d.this.mfG.getMeasuredHeight();
                            d.this.mfV = d.this.mfO / d.this.mfR;
                            d.this.mfW = (int) (1.2f * d.this.mRootView.getWidth());
                            df(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        df(rawX, rawY);
                        break;
                }
            } else if (d.this.mfq == d.this.mfh || d.this.mfq == d.this.mfj || d.this.mfq == d.this.mfk || d.this.mfq == d.this.mfl || d.this.mfq == d.this.mfo || d.this.mfq == (d.this.mfk | 1) || d.this.mfq == (d.this.mfl | 1)) {
                switch (d.this.lGq) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.lGq = 3;
                            d.this.mfP = d.this.gdn.getCurrentPosition();
                            aJ(f);
                        } else if (motionEvent.getX() < d.this.mfG.getWidth() / 2) {
                            d.this.lGq = 2;
                            d.this.mfD.t(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.lGq = 1;
                            d.this.mfD.s(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mfq != d.this.mfo) {
                            if ((d.this.mfq & 1) > 0) {
                                d.this.mfo |= 1;
                            } else {
                                d.this.mfo &= -2;
                            }
                            d.this.Gq(d.this.mfo);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mfD.s(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dpJ();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mfD.t(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aJ(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void df(int i, int i2) {
            if (d.this.mfT != i2 || d.this.mfU != i) {
                d.this.mfS = d.this.mfT - i2 > 0 || ((float) i2) < d.this.mfN / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mfG.getLayoutParams();
                if (i2 != d.this.mfT) {
                    int i3 = d.this.mfR - i2;
                    int i4 = (int) (i3 * d.this.mfV);
                    if (i4 < d.this.mfW) {
                        i4 = d.this.mfW;
                        i3 = (int) (i4 / d.this.mfV);
                    }
                    if (i4 != d.this.mfW) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mfG.setLayoutParams(layoutParams);
                    }
                    d.this.mfT = i2;
                    d.this.mfG.setTranslationY(d.this.mfT);
                }
                if (i != d.this.mfT) {
                    d.this.mfU = i;
                    d.this.mfG.setTranslationX(d.this.mfU + ((d.this.mfO - layoutParams.width) / 2.0f));
                }
                d.this.mfE.setAlpha((layoutParams.width - d.this.mfW) / (d.this.mfO - d.this.mfW));
                if (d.this.mfA.getVisibility() == 0) {
                    float f = d.this.mfN / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mfA.setAlpha(f2);
                }
            }
        }

        private void aJ(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mfP -= 1000;
                z = true;
            } else {
                d.this.mfP += 1000;
                z = false;
            }
            int duration = d.this.gdn.getDuration();
            if (d.this.mfP < 0) {
                d.this.mfP = 0;
            } else if (d.this.mfP > duration) {
                d.this.mfP = duration;
            }
            String str = at.stringForVideoTime(d.this.mfP) + " / " + at.stringForVideoTime(duration);
            if (d.this.mfD != null) {
                d.this.mfD.D(z, str);
            }
            d.this.mfy.setCurrentDuration(d.this.mfP, false);
        }
    };
    private View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mfq == d.this.mfo) {
                if (d.this.lGq == 4) {
                    d.this.dvk();
                    d.this.mfT = 0;
                    d.this.mfU = 0;
                } else {
                    d.this.mfq = -1;
                    if (d.this.lGq != 3) {
                        if (d.this.mfr != -1) {
                            d.this.Gq(d.this.mfr);
                            d.this.mfr = -1;
                        } else if (d.this.gdn.isPlaying()) {
                            d.this.Gq(d.this.mfh);
                        } else {
                            d.this.Gq(d.this.mfk);
                        }
                    } else {
                        d.this.mfy.setCurrentDuration(d.this.mfP, true);
                        if (d.this.mfP <= d.this.gdn.getDuration()) {
                            if (!d.this.gdn.isPlaying()) {
                                d.this.gdn.a(d.this.mga);
                            }
                            d.this.Gq(d.this.mfh);
                        }
                    }
                }
                if (d.this.mfL) {
                    String str = null;
                    if (d.this.lGq != 1) {
                        if (d.this.lGq != 2) {
                            if (d.this.lGq == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dR("tid", d.this.alT).w("fid", d.this.mFid));
                    }
                }
                d.this.lGq = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mga = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void duU() {
            d.this.gdn.duQ();
            d.this.dvb();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void duV() {
            d.this.Gq(d.this.mfg);
            d.this.bLE();
        }
    };
    private final CustomMessageListener eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
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
        void cF(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.mfN = l.getEquipmentHeight(this.mContext);
            this.mfO = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dpH() {
        int dimension;
        int i;
        int i2;
        this.mfz.av(this.alS, this.ljx);
        this.mfA.av(this.alS, this.ljx);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.alS) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.ljx) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.alM.setPadding(0, 0, i2, 0);
            this.mfx.setPadding(this.mfx.getPaddingLeft(), 0, i, 0);
            this.mfw.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dpG() {
        if (this.alS) {
            this.mfj = 104;
            this.mfk = 8290;
        } else {
            this.mfj = 232;
            this.mfk = 8418;
        }
        if (this.ljx) {
            this.mfg |= 1024;
            this.mfh |= 1024;
            this.mfi |= 1024;
            this.mfj |= 1024;
            this.mfk |= 1024;
            this.mfl |= 1024;
            this.mfm |= 1024;
            this.mfn |= 1024;
            this.mfq |= 1024;
            return;
        }
        this.mfg &= -1025;
        this.mfh &= -1025;
        this.mfi &= -1025;
        this.mfj &= -1025;
        this.mfk &= -1025;
        this.mfl &= -1025;
        this.mfm &= -1025;
        this.mfn &= -1025;
        this.mfq &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mfG = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mfG);
            }
            this.alP = new WeakReference<>(TbadkCoreApplication.getInst());
            this.alJ = (TbImageView) this.mfG.findViewById(R.id.video_thumbnail);
            this.mft = this.mfG.findViewById(R.id.black_mask);
            this.mfu = (TBLottieAnimationView) this.mfG.findViewById(R.id.video_loading);
            this.alK = (ImageView) this.mfG.findViewById(R.id.video_play);
            this.mfv = (PercentSizeView) this.mfG.findViewById(R.id.video_media_controller_mask);
            this.alL = (ImageView) this.mfG.findViewById(R.id.video_pause);
            this.alM = (TextView) this.mfG.findViewById(R.id.video_play_count);
            this.alN = (TextView) this.mfG.findViewById(R.id.video_play_flag);
            this.alO = (TextView) this.mfG.findViewById(R.id.video_duration);
            this.mfw = (SwitchImageView) this.mfG.findViewById(R.id.video_mute);
            this.mfx = (SwitchImageView) this.mfG.findViewById(R.id.video_full_screen);
            this.mfy = (OperableVideoMediaControllerView) this.mfG.findViewById(R.id.video_media_controller);
            this.mfz = (OperableVideoNetworkStateTipView) this.mfG.findViewById(R.id.video_network_state_tip);
            this.mfA = (OperableVideoShareView) this.mfG.findViewById(R.id.video_share_view);
            this.mfC = this.mfG.findViewById(R.id.video_back_btn_mask);
            this.mfB = (ImageView) this.mfG.findViewById(R.id.video_full_screen_back);
            this.mfD = (VideoGestureView) this.mfG.findViewById(R.id.video_gesture);
            this.mfF = (OperableVideoErrorView) this.mfG.findViewById(R.id.video_error_layout);
            this.mfA.setVideoContainer(this);
            this.mfu.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mfu.setVisibility(8);
                    d.this.alK.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mfu.setAnimation(R.raw.lotti_video_loading);
            SvgManager.boN().a(this.alK, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alK.setOnClickListener(this);
            this.mfw.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.mfw.setState(1);
            this.mfw.setOnClickListener(this);
            this.alJ.bBZ();
            this.alJ.setDrawCorner(false);
            this.alJ.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.mft, R.color.cp_mask_b_alpha50);
            this.mfy.setOnSeekBarChangeListener(this.fNb);
            this.mfv.setHeightPercent(0.583f);
            this.mfv.setBackgroundResource(R.drawable.video_mask_bg);
            this.mfx.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.mfx.setState(0);
            this.mfx.setOnClickListener(this);
            SvgManager.boN().a(this.alL, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alL.setOnClickListener(this);
            this.mfB.setOnClickListener(this);
            this.gdn = new TbCyberVideoView(this.mContext);
            this.gdn.setTryUseViewInSet(true);
            dvb();
            this.mfz.setPlayViewOnClickListener(this);
            this.mfG.setOnClickListener(null);
            this.mfG.setOnTouchListener(this.ftj);
            this.mfA.setOnTouchListener(this.ftj);
            this.mfF.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iNt);
            Gq(this.mfg);
            this.jeM = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dvb() {
        if (this.gdn != null && this.gdn.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mfG.addView(this.gdn.getView(), 0);
            this.gdn.getView().setLayoutParams(layoutParams);
            this.mfy.setPlayer(this.gdn);
            this.gdn.setContinuePlayEnable(true);
            this.gdn.setOnPreparedListener(this);
            this.gdn.setOnCompletionListener(this);
            this.gdn.setOnErrorListener(this);
            this.gdn.setOnSurfaceDestroyedListener(this);
            this.gdn.setOnInfoListener(this);
            this.gdn.setVideoStatData(this.mfJ);
            this.gdn.setThreadDataForStatistic(this.mfK);
            this.gdn.getMediaProgressObserver().a(this.mfZ);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bks() != null) {
            this.startPosition = -1L;
            if (this.jeM != null) {
                this.jeM.reset();
            }
            if (!at.equals(this.mVideoUrl, bwVar.bks().video_url)) {
                stopPlay();
                this.alS = bwVar.bks().is_vertical.intValue() == 1;
                this.mVideoUrl = bwVar.bks().video_url;
                this.alT = bwVar.getTid();
                this.alU = bwVar.bks().video_length.intValue();
                this.mfI = bwVar.bks().video_duration.intValue();
                this.mFid = bwVar.getFid();
                this.mfX = bwVar.bks().mcn_ad_card;
                dpG();
                dpH();
                Gq(this.mfg);
                int intValue = bwVar.bks().video_duration.intValue() * 1000;
                this.mfy.Hi(intValue);
                this.mfy.setPlayer(this.gdn);
                this.alO.setText(at.stringForVideoTime(intValue));
                this.alM.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bwVar.bks().play_count.intValue())));
                this.mfz.setVideoLength(bwVar.bks().video_length.intValue());
                this.mfz.setVideoDuration(bwVar.bks().video_duration.intValue());
                this.mfz.setTid(this.alT);
                this.mfK = bwVar;
                this.gdn.setThreadDataForStatistic(bwVar);
                this.alN.setVisibility(8);
                this.alJ.setPlaceHolder(3);
                this.alJ.startLoad(bwVar.bks().thumbnail_url, 10, false);
                this.mfA.setShareData(bwVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gdn != null) {
            this.mfJ = oVar;
            this.gdn.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.afJ = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Hk(int i) {
        this.gdn.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiz = bdUniqueId;
    }

    public void dvc() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mfs);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mfs, this.meR);
    }

    public void dvd() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mfs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLE() {
        this.mfu.setAlpha(1.0f);
        this.mfu.setVisibility(0);
        this.alK.setVisibility(8);
        if (this.mfu != null) {
            this.mfu.loop(true);
            this.mfu.setMinAndMaxFrame(14, 80);
            this.mfu.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dpE() {
        if (this.mfq == this.mfi) {
            Gq(this.mfh);
        }
    }

    private void dve() {
        Gq(this.mfi);
        this.mfy.showProgress();
        if (this.mfu != null) {
            this.mfu.clearAnimation();
            this.mfu.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dpE();
                    if (!d.this.mfH) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mfu.setVisibility(8);
                    d.this.alK.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dvf() {
        return this.mfz != null && this.mfz.dpO();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aiy = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.eri);
            if (dvf()) {
                Gq(this.mfn);
                return;
            }
            this.mfH = true;
            if (!this.gdn.isPlaying()) {
                TbCyberVideoView Qv = TbVideoViewSet.duT().Qv(this.mVideoUrl);
                if (Qv == null) {
                    this.gdn.duQ();
                    if (!StringUtils.isNull(this.gdn.getOriginUrl())) {
                        this.gdn = new TbCyberVideoView(this.mContext);
                        this.gdn.setTryUseViewInSet(true);
                    }
                    dvb();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gdn.setVideoDuration(this.mfI);
                        this.gdn.setVideoPath(this.mVideoUrl, this.alT);
                        this.gdn.setStageType(this.aiy);
                        bLE();
                        if (this.mfL) {
                            dpM();
                        }
                    }
                } else {
                    if (this.gdn == Qv) {
                        if (this.gdn.getParent() == null || this.gdn.getParent() != Qv.getParent()) {
                            this.gdn.duQ();
                            dvb();
                        }
                    } else {
                        this.gdn.duQ();
                        Qv.duQ();
                        this.gdn = Qv;
                        this.gdn.setTryUseViewInSet(true);
                        dvb();
                    }
                    this.gdn.duR();
                    onPrepared();
                    dvl();
                    if (this.mfL) {
                        dpM();
                    }
                }
                if (this.mfL) {
                    TiebaStatic.log(new aq("c13357").dR("tid", this.alT).w("fid", this.mFid).aj("obj_type", this.alS ? 1 : 2).aj("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).aj("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mfH = false;
        if (this.mfu != null) {
            this.mfu.cancelAnimation();
        }
        this.gdn.stop();
        this.gdn.duQ();
        this.mfy.aNA();
        Gq(this.mfg);
        MessageManager.getInstance().unRegisterListener(this.eri);
    }

    private void dvg() {
        this.mfH = false;
        if (this.mfu != null) {
            this.mfu.cancelAnimation();
        }
        this.gdn.stop();
        this.mfy.aNA();
        Gq(this.mfg);
        MessageManager.getInstance().unRegisterListener(this.eri);
    }

    public void dpM() {
        if (this.mfJ != null) {
            o duG = this.mfJ.duG();
            duG.mLocate = this.mFrom;
            h.a(duG.mdX, "", "1", duG, this.gdn.getPcdnState());
        }
    }

    public void Gq(int i) {
        dvd();
        if (this.mfq == this.mfo) {
            this.mfr = i;
            return;
        }
        this.mfq = i;
        this.alJ.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mft.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mfu.clearAnimation();
        this.mfu.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mfu.cancelAnimation();
        } else {
            this.mfu.setAlpha(1.0f);
        }
        this.alK.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.alL.setVisibility((i & 8) > 0 ? 0 : 8);
        this.alM.setVisibility((i & 16) > 0 ? 0 : 8);
        this.alO.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mfw.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mfx.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mfy.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mfv.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mfy.getVisibility() == 0) {
            this.mfy.showProgress();
        }
        this.mfz.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mfA.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mfA.getVisibility() == 0) {
            this.mfA.setAlpha(1.0f);
        }
        this.mfB.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mfC.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mfD.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mfF.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Gr(id);
            if (id == R.id.video_mute) {
                dvi();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dvk();
            } else if (id == R.id.video_replay) {
                Gq(this.mfg);
                startPlay();
                if (this.mfL) {
                    TiebaStatic.log(new aq("c13345").dR("tid", this.alT).w("fid", this.mFid).aj("obj_type", this.alS ? 1 : 2).aj("obj_locate", this.ljx ? 1 : 2));
                }
                dvh();
            } else if (id == R.id.video_play) {
                if (this.mfq == this.mfg) {
                    startPlay();
                } else {
                    Gq(this.mfj);
                    dvc();
                    this.gdn.a(this.mga);
                }
                if (this.mfL) {
                    TiebaStatic.log(new aq("c13344").dR("tid", this.alT).w("fid", this.mFid).aj("obj_type", this.alS ? 1 : 2).aj("obj_source", this.ljx ? 1 : 2).aj("obj_locate", 1));
                }
                dvh();
            } else if (id == R.id.video_pause) {
                Gq(this.mfk);
                dvd();
                this.gdn.pause();
                if (this.mfL) {
                    TiebaStatic.log(new aq("c13344").dR("tid", this.alT).w("fid", this.mFid).aj("obj_type", this.alS ? 1 : 2).aj("obj_source", this.ljx ? 1 : 2).aj("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Gq(this.mfg);
                startPlay();
            } else if (id == R.id.retry) {
                Gq(this.mfg);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvh() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.aiz);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void dpD() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gdn.setVolume(0.0f, 0.0f);
            this.mfw.setState(1);
            return;
        }
        this.gdn.setVolume(1.0f, 1.0f);
        this.mfw.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvi() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gdn.setVolume(1.0f, 1.0f);
            ai.a(this.alP, true);
            this.mfw.setState(0);
        } else {
            this.gdn.setVolume(0.0f, 0.0f);
            this.mfw.setState(1);
            ai.a(this.alP, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void wk(boolean z) {
        if (this.kAH == null) {
            this.kAH = new j((Activity) this.mContext);
        }
        if (z) {
            this.kAH.start();
            this.kAH.cD(true);
            return;
        }
        this.kAH.stop();
        this.kAH.cD(false);
    }

    public void dvj() {
        vt(true);
    }

    public void vt(boolean z) {
        if (this.mRootView != null && this.mfG != null && this.gdn != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kAH == null) {
                this.kAH = new j((Activity) this.mContext);
            }
            if (this.ljx) {
                if (this.mfE.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mfE.getParent()).removeView(this.mfE);
                }
                if ((this.mfG.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.ljx = false;
                    this.mfM = true;
                    ((ViewGroup) this.mfG.getParent()).removeView(this.mfG);
                    ((ViewGroup) this.mRootView).addView(this.mfG);
                    this.mfM = false;
                    k((Activity) this.mContext, this.ljx);
                }
                if (!this.alS && z) {
                    this.kAH.QI();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.alS && z) {
                        this.kAH.QI();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mfG.getLocationOnScreen(this.mfQ);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.mfM = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mfE == null) {
                                    this.mfE = new View(this.mContext);
                                    this.mfE.setClickable(true);
                                    this.mfE.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mfE.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mfE.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mfE.getParent()).removeView(this.mfE);
                                }
                                this.mfE.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mfE);
                                ((ViewGroup) childAt).addView(this.mfG);
                                this.mfM = false;
                                this.ljx = true;
                                k((Activity) this.mContext, this.ljx);
                                if (this.jeM != null && this.jeM.isShowing()) {
                                    this.jeM.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mfL) {
                    TiebaStatic.log(new aq("c13360").dR("tid", this.alT).w("fid", this.mFid).aj("obj_type", this.alS ? 1 : 2));
                }
            }
            dpG();
            dpH();
            if (this.gdn.isPlaying()) {
                Gq(this.mfh);
            } else {
                Gq(this.mfq);
            }
            this.mfx.dQl();
            wl(this.ljx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvk() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.alS) {
            dvj();
        } else if (this.mfq == this.mfo) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mfG.setScaleX(1.0f);
                    d.this.mfG.setScaleY(1.0f);
                    d.this.mfG.setTranslationX(0.0f);
                    d.this.mfG.setTranslationY(0.0f);
                    d.this.mfA.setScaleX(1.0f);
                    d.this.mfA.setScaleY(1.0f);
                    d.this.mfG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mfS) {
                        d.this.dvj();
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
            if (!this.mfS) {
                float width = this.mRootView.getWidth() / this.mfG.getWidth();
                float height = this.mRootView.getHeight() / this.mfG.getHeight();
                this.mfG.setPivotX(0.0f);
                this.mfG.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mfG, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mfG, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mfA, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mfA, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mfG, "TranslationX", this.mfG.getTranslationX(), this.mfQ[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mfG, "TranslationY", this.mfG.getTranslationY(), this.mfQ[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mfE, "alpha", this.mfE.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mfA, "alpha", this.mfA.getAlpha(), 0.0f);
            } else {
                float width2 = this.mfO / this.mfG.getWidth();
                float height2 = this.mfR / this.mfG.getHeight();
                this.mfG.setPivotX(0.0f);
                this.mfG.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mfG, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mfG, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mfA, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mfA, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mfG, "TranslationX", this.mfG.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mfG, "TranslationY", this.mfG.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mfA, "alpha", this.mfA.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mfr != -1) {
                this.mfq = this.mfr;
                this.mfr = -1;
                if (this.mfq == this.mfp || this.mfq == this.mfj || this.mfq == this.mfh) {
                    this.gdn.a(this.mga);
                    Gq(this.mfh);
                }
            }
        } else {
            dvj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.alS && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mfG != null) {
                    if (z) {
                        this.mfG.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mfG.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cXi();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mfG.setSystemUiVisibility(0);
            }
        }
    }

    private void dvl() {
        Gq(this.mfi);
        this.mfy.showProgress();
        dve();
    }

    protected void wl(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        dpD();
        if (this.mfH) {
            if (this.ljx && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gdn.a(this.mga);
        }
    }

    public void onCompletion() {
        Gq(this.mfm);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Gq(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.mfM) {
            if (this.mfq == this.mfk || (this.mfq == this.mfl && !this.gdn.isPlaying())) {
                dvg();
                Gq(this.mfk);
            } else if (this.mfq == this.mfm) {
                dvg();
                Gq(this.mfm);
            } else {
                dvg();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dvl();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dun() {
        return this.mfG;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mfH || this.gdn.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gdn.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bRb() {
    }

    protected void Gr(int i) {
    }

    protected boolean ab(MotionEvent motionEvent) {
        return this.ljx;
    }

    protected boolean dpF() {
        return this.alS && this.ljx;
    }

    private void cXi() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mfG.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mfG.setSystemUiVisibility(4);
        } else {
            this.mfG.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dpJ() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gdn.isPlaying() && !ai.bBB()) {
            this.gdn.setVolume(1.0f, 1.0f);
            this.mfw.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dpK() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean qV(boolean z) {
        if (z) {
            this.mfu.cancelAnimation();
            if (this.mfq == this.mfh || this.mfq == this.mfi || this.mfq == this.mfj || this.mfq == this.mfg) {
                stopPlay();
            }
            this.mfq |= 1;
            Gq(this.mfq);
        } else if (this.mfq == this.mfg) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.ljx;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean duZ() {
        if (this.ljx) {
            dvk();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cJg() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dvm() {
        return this.mfX != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wm(boolean z) {
        this.afT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mfY = aVar;
    }
}
