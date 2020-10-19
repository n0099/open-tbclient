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
    private String aix;
    protected BdUniqueId aiy;
    protected TbImageView alI;
    private ImageView alJ;
    private ImageView alK;
    protected TextView alL;
    protected TextView alM;
    private TextView alN;
    protected boolean alR;
    protected String alS;
    protected long alT;
    protected TbCyberVideoView fTk;
    private com.baidu.mcn.c iSq;
    private j kok;
    private View lSU;
    private TBLottieAnimationView lSV;
    private PercentSizeView lSW;
    protected SwitchImageView lSX;
    protected SwitchImageView lSY;
    protected OperableVideoMediaControllerView lSZ;
    protected OperableVideoNetworkStateTipView lTa;
    protected OperableVideoShareView lTb;
    protected ImageView lTc;
    protected View lTd;
    protected VideoGestureView lTe;
    private View lTf;
    private OperableVideoErrorView lTg;
    protected ViewGroup lTh;
    protected boolean lTi;
    protected int lTj;
    protected o lTk;
    protected bw lTl;
    private float lTo;
    private float lTp;
    private int lTq;
    private int lTs;
    private boolean lTt;
    private float lTw;
    private int lTx;
    private McnAdInfo lTy;
    private a lTz;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int lSs = 3000;
    protected final int lSt = 1;
    protected final int lSu = 2;
    protected final int lSv = 4;
    protected final int lSw = 8;
    protected final int lSx = 16;
    protected final int lSy = 32;
    protected final int lSz = 64;
    protected final int lSA = 128;
    protected final int lSB = 256;
    protected final int lSC = 512;
    protected final int lSD = 1024;
    protected final int lSE = 2048;
    protected final int lSF = 4096;
    protected final int lSG = 8192;
    protected int lSH = 8211;
    protected int lSI = 0;
    protected int lSJ = 4;
    protected int lSK = 232;
    protected int lSL = 8416;
    protected int lSM = 0;
    protected int lSN = 513;
    protected int lSO = 259;
    protected int lSP = 2048;
    protected int lSQ = 0;
    protected int STATE_ERROR = 4099;
    protected int lSR = this.lSH;
    private int ltS = 0;
    private int lSS = -1;
    private Runnable lST = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.FX(d.this.lSI);
        }
    };
    private WeakReference<Context> alO = null;
    protected boolean kWY = false;
    protected boolean lTm = true;
    private boolean lTn = false;
    private int[] lTr = new int[2];
    private int lTu = 0;
    private int lTv = 0;
    protected View.OnClickListener ajo = null;
    protected View.OnClickListener afI = null;
    private boolean afS = false;
    private long startPosition = -1;
    private f.b lTA = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ca(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dsf() && !d.this.alR && !d.this.kWY && d.this.afS) {
                if (!com.baidu.mcn.b.Vw().iG(d.this.lTy.jump_url)) {
                    boolean z = ((long) i2) >= d.this.lTy.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.lTy.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.lTy.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.iSq.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bJT = d.this.lTy.card_title;
                            aVar.bJU = d.this.lTy.button_title;
                            aVar.bJV = d.this.lTy.jump_url;
                            aVar.bJS = d.this.lTy.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.alS;
                            aVar.bJW = d.this.cFZ();
                            if (z2) {
                                d.this.iSq.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.iSq.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.iSq.isShowing()) {
                        d.this.iSq.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.lTz != null) {
                d.this.lTz.cD(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fEG = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.FX(d.this.lSK);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.fTk.isPlaying()) {
                    d.this.fTk.a(d.this.lTB);
                }
                d.this.drV();
                if (d.this.lTm) {
                    TiebaStatic.log(new aq("c13355").dK("tid", d.this.alS).u("fid", d.this.mFid).aj("obj_type", d.this.alR ? 1 : 2).aj("obj_locate", d.this.kWY ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iAX = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.fTk.isPlaying()) {
                d.this.fTk.pause();
                if (d.this.lSR == d.this.lSK) {
                    d.this.FX(d.this.lSL);
                } else {
                    d.this.FX(d.this.lSM);
                }
                d.this.FY(R.id.video_pause);
            } else if (d.this.lSR == d.this.lSL || d.this.lSR == (d.this.lSL | 1)) {
                d.this.FX(d.this.lSK);
                d.this.drV();
                d.this.fTk.a(d.this.lTB);
                d.this.FY(R.id.video_play);
            } else if (d.this.lSR == d.this.lSM || d.this.lSR == (d.this.lSM | 1)) {
                d.this.FX(d.this.lSI);
                d.this.fTk.a(d.this.lTB);
                d.this.FY(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.fTk.isPlaying()) {
                if (d.this.lSR == d.this.lSI || d.this.lSR == d.this.lSJ) {
                    d.this.FX(d.this.lSK);
                    d.this.drV();
                    return true;
                } else if (d.this.lSR == d.this.lSK) {
                    d.this.FX(d.this.lSI);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.lSR == d.this.lSL) {
                d.this.FX(d.this.lSM);
                return true;
            } else if (d.this.lSR == (d.this.lSL | 1)) {
                d.this.FX(d.this.lSM | 1);
                return true;
            } else if (d.this.lSR == d.this.lSM) {
                d.this.FX(d.this.lSL);
                return true;
            } else if (d.this.lSR == (d.this.lSM | 1)) {
                d.this.FX(d.this.lSL | 1);
                return true;
            } else {
                d.this.FX(d.this.lSH);
                d.this.startPlay();
                d.this.dsa();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.ltS = 0;
            if (d.this.kWY) {
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
            if (d.this.alR && d.this.dmx()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.ltS) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.fTk.isPlaying()) {
                                d.this.fTk.pause();
                                d.this.FX(d.this.lSQ);
                            }
                            d.this.ltS = 4;
                            d.this.lSS = d.this.lSR;
                            d.this.lSR = d.this.lSP;
                            d.this.lTs = d.this.lTh.getMeasuredHeight();
                            d.this.lTw = d.this.lTp / d.this.lTs;
                            d.this.lTx = (int) (1.2f * d.this.mRootView.getWidth());
                            dd(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dd(rawX, rawY);
                        break;
                }
            } else if (d.this.lSR == d.this.lSI || d.this.lSR == d.this.lSK || d.this.lSR == d.this.lSL || d.this.lSR == d.this.lSM || d.this.lSR == d.this.lSP || d.this.lSR == (d.this.lSL | 1) || d.this.lSR == (d.this.lSM | 1)) {
                switch (d.this.ltS) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.ltS = 3;
                            d.this.lTq = d.this.fTk.getCurrentPosition();
                            aH(f);
                        } else if (motionEvent.getX() < d.this.lTh.getWidth() / 2) {
                            d.this.ltS = 2;
                            d.this.lTe.t(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.ltS = 1;
                            d.this.lTe.s(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.lSR != d.this.lSP) {
                            if ((d.this.lSR & 1) > 0) {
                                d.this.lSP |= 1;
                            } else {
                                d.this.lSP &= -2;
                            }
                            d.this.FX(d.this.lSP);
                            break;
                        }
                        break;
                    case 1:
                        d.this.lTe.s(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dmB();
                            break;
                        }
                        break;
                    case 2:
                        d.this.lTe.t(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aH(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dd(int i, int i2) {
            if (d.this.lTu != i2 || d.this.lTv != i) {
                d.this.lTt = d.this.lTu - i2 > 0 || ((float) i2) < d.this.lTo / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.lTh.getLayoutParams();
                if (i2 != d.this.lTu) {
                    int i3 = d.this.lTs - i2;
                    int i4 = (int) (i3 * d.this.lTw);
                    if (i4 < d.this.lTx) {
                        i4 = d.this.lTx;
                        i3 = (int) (i4 / d.this.lTw);
                    }
                    if (i4 != d.this.lTx) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.lTh.setLayoutParams(layoutParams);
                    }
                    d.this.lTu = i2;
                    d.this.lTh.setTranslationY(d.this.lTu);
                }
                if (i != d.this.lTu) {
                    d.this.lTv = i;
                    d.this.lTh.setTranslationX(d.this.lTv + ((d.this.lTp - layoutParams.width) / 2.0f));
                }
                d.this.lTf.setAlpha((layoutParams.width - d.this.lTx) / (d.this.lTp - d.this.lTx));
                if (d.this.lTb.getVisibility() == 0) {
                    float f = d.this.lTo / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.lTb.setAlpha(f2);
                }
            }
        }

        private void aH(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.lTq -= 1000;
                z = true;
            } else {
                d.this.lTq += 1000;
                z = false;
            }
            int duration = d.this.fTk.getDuration();
            if (d.this.lTq < 0) {
                d.this.lTq = 0;
            } else if (d.this.lTq > duration) {
                d.this.lTq = duration;
            }
            String str = at.stringForVideoTime(d.this.lTq) + " / " + at.stringForVideoTime(duration);
            if (d.this.lTe != null) {
                d.this.lTe.B(z, str);
            }
            d.this.lSZ.setCurrentDuration(d.this.lTq, false);
        }
    };
    private View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.lSR == d.this.lSP) {
                if (d.this.ltS == 4) {
                    d.this.dsd();
                    d.this.lTu = 0;
                    d.this.lTv = 0;
                } else {
                    d.this.lSR = -1;
                    if (d.this.ltS != 3) {
                        if (d.this.lSS != -1) {
                            d.this.FX(d.this.lSS);
                            d.this.lSS = -1;
                        } else if (d.this.fTk.isPlaying()) {
                            d.this.FX(d.this.lSI);
                        } else {
                            d.this.FX(d.this.lSL);
                        }
                    } else {
                        d.this.lSZ.setCurrentDuration(d.this.lTq, true);
                        if (d.this.lTq <= d.this.fTk.getDuration()) {
                            if (!d.this.fTk.isPlaying()) {
                                d.this.fTk.a(d.this.lTB);
                            }
                            d.this.FX(d.this.lSI);
                        }
                    }
                }
                if (d.this.lTm) {
                    String str = null;
                    if (d.this.ltS != 1) {
                        if (d.this.ltS != 2) {
                            if (d.this.ltS == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dK("tid", d.this.alS).u("fid", d.this.mFid));
                    }
                }
                d.this.ltS = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a lTB = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void drN() {
            d.this.fTk.drJ();
            d.this.drU();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void drO() {
            d.this.FX(d.this.lSH);
            d.this.bJe();
        }
    };
    private final CustomMessageListener eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
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
        void cD(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.lTo = l.getEquipmentHeight(this.mContext);
            this.lTp = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dmz() {
        int dimension;
        int i;
        int i2;
        this.lTa.as(this.alR, this.kWY);
        this.lTb.as(this.alR, this.kWY);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.alR) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kWY) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.alL.setPadding(0, 0, i2, 0);
            this.lSY.setPadding(this.lSY.getPaddingLeft(), 0, i, 0);
            this.lSX.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dmy() {
        if (this.alR) {
            this.lSK = 104;
            this.lSL = 8290;
        } else {
            this.lSK = 232;
            this.lSL = 8418;
        }
        if (this.kWY) {
            this.lSH |= 1024;
            this.lSI |= 1024;
            this.lSJ |= 1024;
            this.lSK |= 1024;
            this.lSL |= 1024;
            this.lSM |= 1024;
            this.lSN |= 1024;
            this.lSO |= 1024;
            this.lSR |= 1024;
            return;
        }
        this.lSH &= -1025;
        this.lSI &= -1025;
        this.lSJ &= -1025;
        this.lSK &= -1025;
        this.lSL &= -1025;
        this.lSM &= -1025;
        this.lSN &= -1025;
        this.lSO &= -1025;
        this.lSR &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.lTh = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.lTh);
            }
            this.alO = new WeakReference<>(TbadkCoreApplication.getInst());
            this.alI = (TbImageView) this.lTh.findViewById(R.id.video_thumbnail);
            this.lSU = this.lTh.findViewById(R.id.black_mask);
            this.lSV = (TBLottieAnimationView) this.lTh.findViewById(R.id.video_loading);
            this.alJ = (ImageView) this.lTh.findViewById(R.id.video_play);
            this.lSW = (PercentSizeView) this.lTh.findViewById(R.id.video_media_controller_mask);
            this.alK = (ImageView) this.lTh.findViewById(R.id.video_pause);
            this.alL = (TextView) this.lTh.findViewById(R.id.video_play_count);
            this.alM = (TextView) this.lTh.findViewById(R.id.video_play_flag);
            this.alN = (TextView) this.lTh.findViewById(R.id.video_duration);
            this.lSX = (SwitchImageView) this.lTh.findViewById(R.id.video_mute);
            this.lSY = (SwitchImageView) this.lTh.findViewById(R.id.video_full_screen);
            this.lSZ = (OperableVideoMediaControllerView) this.lTh.findViewById(R.id.video_media_controller);
            this.lTa = (OperableVideoNetworkStateTipView) this.lTh.findViewById(R.id.video_network_state_tip);
            this.lTb = (OperableVideoShareView) this.lTh.findViewById(R.id.video_share_view);
            this.lTd = this.lTh.findViewById(R.id.video_back_btn_mask);
            this.lTc = (ImageView) this.lTh.findViewById(R.id.video_full_screen_back);
            this.lTe = (VideoGestureView) this.lTh.findViewById(R.id.video_gesture);
            this.lTg = (OperableVideoErrorView) this.lTh.findViewById(R.id.video_error_layout);
            this.lTb.setVideoContainer(this);
            this.lSV.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lSV.setVisibility(8);
                    d.this.alJ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.lSV.setAnimation(R.raw.lotti_video_loading);
            SvgManager.bmU().a(this.alJ, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alJ.setOnClickListener(this);
            this.lSX.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.lSX.setState(1);
            this.lSX.setOnClickListener(this);
            this.alI.bAg();
            this.alI.setDrawCorner(false);
            this.alI.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.lSU, R.color.cp_mask_b_alpha50);
            this.lSZ.setOnSeekBarChangeListener(this.fEG);
            this.lSW.setHeightPercent(0.583f);
            this.lSW.setBackgroundResource(R.drawable.video_mask_bg);
            this.lSY.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.lSY.setState(0);
            this.lSY.setOnClickListener(this);
            SvgManager.bmU().a(this.alK, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alK.setOnClickListener(this);
            this.lTc.setOnClickListener(this);
            this.fTk = new TbCyberVideoView(this.mContext);
            this.fTk.setTryUseViewInSet(true);
            drU();
            this.lTa.setPlayViewOnClickListener(this);
            this.lTh.setOnClickListener(null);
            this.lTh.setOnTouchListener(this.fkK);
            this.lTb.setOnTouchListener(this.fkK);
            this.lTg.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iAX);
            FX(this.lSH);
            this.iSq = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void drU() {
        if (this.fTk != null && this.fTk.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.lTh.addView(this.fTk.getView(), 0);
            this.fTk.getView().setLayoutParams(layoutParams);
            this.lSZ.setPlayer(this.fTk);
            this.fTk.setContinuePlayEnable(true);
            this.fTk.setOnPreparedListener(this);
            this.fTk.setOnCompletionListener(this);
            this.fTk.setOnErrorListener(this);
            this.fTk.setOnSurfaceDestroyedListener(this);
            this.fTk.setOnInfoListener(this);
            this.fTk.setVideoStatData(this.lTk);
            this.fTk.setThreadDataForStatistic(this.lTl);
            this.fTk.getMediaProgressObserver().a(this.lTA);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.biz() != null) {
            this.startPosition = -1L;
            if (this.iSq != null) {
                this.iSq.reset();
            }
            if (!at.equals(this.mVideoUrl, bwVar.biz().video_url)) {
                stopPlay();
                this.alR = bwVar.biz().is_vertical.intValue() == 1;
                this.mVideoUrl = bwVar.biz().video_url;
                this.alS = bwVar.getTid();
                this.alT = bwVar.biz().video_length.intValue();
                this.lTj = bwVar.biz().video_duration.intValue();
                this.mFid = bwVar.getFid();
                this.lTy = bwVar.biz().mcn_ad_card;
                dmy();
                dmz();
                FX(this.lSH);
                int intValue = bwVar.biz().video_duration.intValue() * 1000;
                this.lSZ.GP(intValue);
                this.lSZ.setPlayer(this.fTk);
                this.alN.setText(at.stringForVideoTime(intValue));
                this.alL.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bwVar.biz().play_count.intValue())));
                this.lTa.setVideoLength(bwVar.biz().video_length.intValue());
                this.lTa.setVideoDuration(bwVar.biz().video_duration.intValue());
                this.lTa.setTid(this.alS);
                this.lTl = bwVar;
                this.fTk.setThreadDataForStatistic(bwVar);
                this.alM.setVisibility(8);
                this.alI.setPlaceHolder(3);
                this.alI.startLoad(bwVar.biz().thumbnail_url, 10, false);
                this.lTb.setShareData(bwVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.fTk != null) {
            this.lTk = oVar;
            this.fTk.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.afI = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void GR(int i) {
        this.fTk.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiy = bdUniqueId;
    }

    public void drV() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lST);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lST, this.lSs);
    }

    public void drW() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJe() {
        this.lSV.setAlpha(1.0f);
        this.lSV.setVisibility(0);
        this.alJ.setVisibility(8);
        if (this.lSV != null) {
            this.lSV.loop(true);
            this.lSV.setMinAndMaxFrame(14, 80);
            this.lSV.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmw() {
        if (this.lSR == this.lSJ) {
            FX(this.lSI);
        }
    }

    private void drX() {
        FX(this.lSJ);
        this.lSZ.showProgress();
        if (this.lSV != null) {
            this.lSV.clearAnimation();
            this.lSV.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dmw();
                    if (!d.this.lTi) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.lSV.setVisibility(8);
                    d.this.alJ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean drY() {
        return this.lTa != null && this.lTa.dmG();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aix = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.eiK);
            if (drY()) {
                FX(this.lSO);
                return;
            }
            this.lTi = true;
            if (!this.fTk.isPlaying()) {
                TbCyberVideoView PX = TbVideoViewSet.drM().PX(this.mVideoUrl);
                if (PX == null) {
                    this.fTk.drJ();
                    if (!StringUtils.isNull(this.fTk.getOriginUrl())) {
                        this.fTk = new TbCyberVideoView(this.mContext);
                        this.fTk.setTryUseViewInSet(true);
                    }
                    drU();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.fTk.setVideoDuration(this.lTj);
                        this.fTk.setVideoPath(this.mVideoUrl, this.alS);
                        this.fTk.setStageType(this.aix);
                        bJe();
                        if (this.lTm) {
                            dmE();
                        }
                    }
                } else {
                    if (this.fTk == PX) {
                        if (this.fTk.getParent() == null || this.fTk.getParent() != PX.getParent()) {
                            this.fTk.drJ();
                            drU();
                        }
                    } else {
                        this.fTk.drJ();
                        PX.drJ();
                        this.fTk = PX;
                        this.fTk.setTryUseViewInSet(true);
                        drU();
                    }
                    this.fTk.drK();
                    onPrepared();
                    dse();
                    if (this.lTm) {
                        dmE();
                    }
                }
                if (this.lTm) {
                    TiebaStatic.log(new aq("c13357").dK("tid", this.alS).u("fid", this.mFid).aj("obj_type", this.alR ? 1 : 2).aj("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).aj("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.lTi = false;
        if (this.lSV != null) {
            this.lSV.cancelAnimation();
        }
        this.fTk.stop();
        this.fTk.drJ();
        this.lSZ.aLG();
        FX(this.lSH);
        MessageManager.getInstance().unRegisterListener(this.eiK);
    }

    private void drZ() {
        this.lTi = false;
        if (this.lSV != null) {
            this.lSV.cancelAnimation();
        }
        this.fTk.stop();
        this.lSZ.aLG();
        FX(this.lSH);
        MessageManager.getInstance().unRegisterListener(this.eiK);
    }

    public void dmE() {
        if (this.lTk != null) {
            o drz = this.lTk.drz();
            drz.mLocate = this.mFrom;
            h.a(drz.lRz, "", "1", drz, this.fTk.getPcdnState());
        }
    }

    public void FX(int i) {
        drW();
        if (this.lSR == this.lSP) {
            this.lSS = i;
            return;
        }
        this.lSR = i;
        this.alI.setVisibility((i & 1) > 0 ? 0 : 8);
        this.lSU.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.lSV.clearAnimation();
        this.lSV.setVisibility(z ? 0 : 8);
        if (!z) {
            this.lSV.cancelAnimation();
        } else {
            this.lSV.setAlpha(1.0f);
        }
        this.alJ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.alK.setVisibility((i & 8) > 0 ? 0 : 8);
        this.alL.setVisibility((i & 16) > 0 ? 0 : 8);
        this.alN.setVisibility((i & 16) > 0 ? 0 : 8);
        this.lSX.setVisibility((i & 32) > 0 ? 0 : 8);
        this.lSY.setVisibility((i & 64) > 0 ? 0 : 8);
        this.lSZ.setVisibility((i & 128) > 0 ? 0 : 8);
        this.lSW.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.lSZ.getVisibility() == 0) {
            this.lSZ.showProgress();
        }
        this.lTa.setVisibility((i & 256) > 0 ? 0 : 8);
        this.lTb.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.lTb.getVisibility() == 0) {
            this.lTb.setAlpha(1.0f);
        }
        this.lTc.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.lTd.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.lTe.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.lTg.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            FY(id);
            if (id == R.id.video_mute) {
                dsb();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dsd();
            } else if (id == R.id.video_replay) {
                FX(this.lSH);
                startPlay();
                if (this.lTm) {
                    TiebaStatic.log(new aq("c13345").dK("tid", this.alS).u("fid", this.mFid).aj("obj_type", this.alR ? 1 : 2).aj("obj_locate", this.kWY ? 1 : 2));
                }
                dsa();
            } else if (id == R.id.video_play) {
                if (this.lSR == this.lSH) {
                    startPlay();
                } else {
                    FX(this.lSK);
                    drV();
                    this.fTk.a(this.lTB);
                }
                if (this.lTm) {
                    TiebaStatic.log(new aq("c13344").dK("tid", this.alS).u("fid", this.mFid).aj("obj_type", this.alR ? 1 : 2).aj("obj_source", this.kWY ? 1 : 2).aj("obj_locate", 1));
                }
                dsa();
            } else if (id == R.id.video_pause) {
                FX(this.lSL);
                drW();
                this.fTk.pause();
                if (this.lTm) {
                    TiebaStatic.log(new aq("c13344").dK("tid", this.alS).u("fid", this.mFid).aj("obj_type", this.alR ? 1 : 2).aj("obj_source", this.kWY ? 1 : 2).aj("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                FX(this.lSH);
                startPlay();
            } else if (id == R.id.retry) {
                FX(this.lSH);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsa() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.aiy);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void dmv() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.fTk.setVolume(0.0f, 0.0f);
            this.lSX.setState(1);
            return;
        }
        this.fTk.setVolume(1.0f, 1.0f);
        this.lSX.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dsb() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.fTk.setVolume(1.0f, 1.0f);
            ai.a(this.alO, true);
            this.lSX.setState(0);
        } else {
            this.fTk.setVolume(0.0f, 0.0f);
            this.lSX.setState(1);
            ai.a(this.alO, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void vT(boolean z) {
        if (this.kok == null) {
            this.kok = new j((Activity) this.mContext);
        }
        if (z) {
            this.kok.start();
            this.kok.cx(true);
            return;
        }
        this.kok.stop();
        this.kok.cx(false);
    }

    public void dsc() {
        vc(true);
    }

    public void vc(boolean z) {
        if (this.mRootView != null && this.lTh != null && this.fTk != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kok == null) {
                this.kok = new j((Activity) this.mContext);
            }
            if (this.kWY) {
                if (this.lTf.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.lTf.getParent()).removeView(this.lTf);
                }
                if ((this.lTh.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kWY = false;
                    this.lTn = true;
                    ((ViewGroup) this.lTh.getParent()).removeView(this.lTh);
                    ((ViewGroup) this.mRootView).addView(this.lTh);
                    this.lTn = false;
                    k((Activity) this.mContext, this.kWY);
                }
                if (!this.alR && z) {
                    this.kok.PP();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.alR && z) {
                        this.kok.PP();
                    }
                    if (this.mContext instanceof Activity) {
                        this.lTh.getLocationOnScreen(this.lTr);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.lTn = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.lTf == null) {
                                    this.lTf = new View(this.mContext);
                                    this.lTf.setClickable(true);
                                    this.lTf.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.lTf.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.lTf.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.lTf.getParent()).removeView(this.lTf);
                                }
                                this.lTf.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.lTf);
                                ((ViewGroup) childAt).addView(this.lTh);
                                this.lTn = false;
                                this.kWY = true;
                                k((Activity) this.mContext, this.kWY);
                                if (this.iSq != null && this.iSq.isShowing()) {
                                    this.iSq.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.lTm) {
                    TiebaStatic.log(new aq("c13360").dK("tid", this.alS).u("fid", this.mFid).aj("obj_type", this.alR ? 1 : 2));
                }
            }
            dmy();
            dmz();
            if (this.fTk.isPlaying()) {
                FX(this.lSI);
            } else {
                FX(this.lSR);
            }
            this.lSY.dNd();
            vU(this.kWY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsd() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.alR) {
            dsc();
        } else if (this.lSR == this.lSP) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.lTh.setScaleX(1.0f);
                    d.this.lTh.setScaleY(1.0f);
                    d.this.lTh.setTranslationX(0.0f);
                    d.this.lTh.setTranslationY(0.0f);
                    d.this.lTb.setScaleX(1.0f);
                    d.this.lTb.setScaleY(1.0f);
                    d.this.lTh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.lTt) {
                        d.this.dsc();
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
            if (!this.lTt) {
                float width = this.mRootView.getWidth() / this.lTh.getWidth();
                float height = this.mRootView.getHeight() / this.lTh.getHeight();
                this.lTh.setPivotX(0.0f);
                this.lTh.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lTh, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.lTh, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.lTb, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.lTb, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.lTh, "TranslationX", this.lTh.getTranslationX(), this.lTr[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.lTh, "TranslationY", this.lTh.getTranslationY(), this.lTr[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.lTf, "alpha", this.lTf.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.lTb, "alpha", this.lTb.getAlpha(), 0.0f);
            } else {
                float width2 = this.lTp / this.lTh.getWidth();
                float height2 = this.lTs / this.lTh.getHeight();
                this.lTh.setPivotX(0.0f);
                this.lTh.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lTh, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.lTh, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.lTb, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.lTb, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.lTh, "TranslationX", this.lTh.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.lTh, "TranslationY", this.lTh.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.lTb, "alpha", this.lTb.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.lSS != -1) {
                this.lSR = this.lSS;
                this.lSS = -1;
                if (this.lSR == this.lSQ || this.lSR == this.lSK || this.lSR == this.lSI) {
                    this.fTk.a(this.lTB);
                    FX(this.lSI);
                }
            }
        } else {
            dsc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.alR && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.lTh != null) {
                    if (z) {
                        this.lTh.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.lTh.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cUb();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.lTh.setSystemUiVisibility(0);
            }
        }
    }

    private void dse() {
        FX(this.lSJ);
        this.lSZ.showProgress();
        drX();
    }

    protected void vU(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        dmv();
        if (this.lTi) {
            if (this.kWY && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.fTk.a(this.lTB);
        }
    }

    public void onCompletion() {
        FX(this.lSN);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        FX(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.lTn) {
            if (this.lSR == this.lSL || (this.lSR == this.lSM && !this.fTk.isPlaying())) {
                drZ();
                FX(this.lSL);
            } else if (this.lSR == this.lSN) {
                drZ();
                FX(this.lSN);
            } else {
                drZ();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dse();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View drg() {
        return this.lTh;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.lTi || this.fTk.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.fTk.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bOw() {
    }

    protected void FY(int i) {
    }

    protected boolean ab(MotionEvent motionEvent) {
        return this.kWY;
    }

    protected boolean dmx() {
        return this.alR && this.kWY;
    }

    private void cUb() {
        if (Build.VERSION.SDK_INT < 16) {
            this.lTh.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.lTh.setSystemUiVisibility(4);
        } else {
            this.lTh.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dmB() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.fTk.isPlaying() && !ai.bzI()) {
            this.fTk.setVolume(1.0f, 1.0f);
            this.lSX.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dmC() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean qD(boolean z) {
        if (z) {
            this.lSV.cancelAnimation();
            if (this.lSR == this.lSI || this.lSR == this.lSJ || this.lSR == this.lSK || this.lSR == this.lSH) {
                stopPlay();
            }
            this.lSR |= 1;
            FX(this.lSR);
        } else if (this.lSR == this.lSH) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kWY;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean drS() {
        if (this.kWY) {
            dsd();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cFZ() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dsf() {
        return this.lTy != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vV(boolean z) {
        this.afS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.lTz = aVar;
    }
}
