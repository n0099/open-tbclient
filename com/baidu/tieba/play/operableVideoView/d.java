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
    private String ahL;
    protected BdUniqueId ahM;
    protected TbImageView akQ;
    private ImageView akR;
    private ImageView akS;
    protected TextView akT;
    protected TextView akU;
    private TextView akV;
    protected boolean akZ;
    protected String ala;
    protected long alb;
    protected TbCyberVideoView fDP;
    private com.baidu.mcn.c iwe;
    private j jQs;
    private View luO;
    private TBLottieAnimationView luP;
    private PercentSizeView luQ;
    protected SwitchImageView luR;
    protected SwitchImageView luS;
    protected OperableVideoMediaControllerView luT;
    protected OperableVideoNetworkStateTipView luU;
    protected OperableVideoShareView luV;
    protected ImageView luW;
    protected View luX;
    protected VideoGestureView luY;
    private View luZ;
    private OperableVideoErrorView lva;
    protected ViewGroup lvb;
    protected boolean lvc;
    protected int lvd;
    protected o lve;
    protected bw lvf;
    private float lvi;
    private float lvj;
    private int lvk;
    private int lvm;
    private boolean lvn;
    private float lvq;
    private int lvr;
    private McnAdInfo lvs;
    private a lvt;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int lum = 3000;
    protected final int lun = 1;
    protected final int luo = 2;
    protected final int lup = 4;
    protected final int luq = 8;
    protected final int lur = 16;
    protected final int lus = 32;
    protected final int lut = 64;
    protected final int luu = 128;
    protected final int luv = 256;
    protected final int luw = 512;
    protected final int lux = 1024;
    protected final int luy = 2048;
    protected final int luz = 4096;
    protected final int luA = 8192;
    protected int luB = 8211;
    protected int luC = 0;
    protected int luD = 4;
    protected int luE = 232;
    protected int luF = 8416;
    protected int luG = 0;
    protected int luH = 513;
    protected int luI = 259;
    protected int luJ = 2048;
    protected int luK = 0;
    protected int STATE_ERROR = 4099;
    protected int luL = this.luB;
    private int kVW = 0;
    private int luM = -1;
    private Runnable luN = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.EQ(d.this.luC);
        }
    };
    private WeakReference<Context> akW = null;
    protected boolean kzq = false;
    protected boolean lvg = true;
    private boolean lvh = false;
    private int[] lvl = new int[2];
    private int lvo = 0;
    private int lvp = 0;
    protected View.OnClickListener aiC = null;
    protected View.OnClickListener aeZ = null;
    private boolean afi = false;
    private long startPosition = -1;
    private f.b lvu = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.4
        @Override // com.baidu.tieba.play.f.b
        public void bX(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dkN() && !d.this.akZ && !d.this.kzq && d.this.afi) {
                if (!com.baidu.mcn.b.SM().hJ(d.this.lvs.jump_url)) {
                    boolean z = ((long) i2) >= d.this.lvs.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.lvs.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.lvs.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.iwe.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bzU = d.this.lvs.card_title;
                            aVar.bzV = d.this.lvs.button_title;
                            aVar.bzW = d.this.lvs.jump_url;
                            aVar.bzT = d.this.lvs.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.ala;
                            aVar.bzX = d.this.cyJ();
                            if (z2) {
                                d.this.iwe.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.iwe.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.iwe.isShowing()) {
                        d.this.iwe.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.lvt != null) {
                d.this.lvt.cA(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fpo = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.EQ(d.this.luE);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.fDP.isPlaying()) {
                    d.this.fDP.a(d.this.lvv);
                }
                d.this.dkD();
                if (d.this.lvg) {
                    TiebaStatic.log(new aq("c13355").dD("tid", d.this.ala).u("fid", d.this.mFid).ai("obj_type", d.this.akZ ? 1 : 2).ai("obj_locate", d.this.kzq ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener ifc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.fDP.isPlaying()) {
                d.this.fDP.pause();
                if (d.this.luL == d.this.luE) {
                    d.this.EQ(d.this.luF);
                } else {
                    d.this.EQ(d.this.luG);
                }
                d.this.ER(R.id.video_pause);
            } else if (d.this.luL == d.this.luF || d.this.luL == (d.this.luF | 1)) {
                d.this.EQ(d.this.luE);
                d.this.dkD();
                d.this.fDP.a(d.this.lvv);
                d.this.ER(R.id.video_play);
            } else if (d.this.luL == d.this.luG || d.this.luL == (d.this.luG | 1)) {
                d.this.EQ(d.this.luC);
                d.this.fDP.a(d.this.lvv);
                d.this.ER(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.fDP.isPlaying()) {
                if (d.this.luL == d.this.luC || d.this.luL == d.this.luD) {
                    d.this.EQ(d.this.luE);
                    d.this.dkD();
                    return true;
                } else if (d.this.luL == d.this.luE) {
                    d.this.EQ(d.this.luC);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.luL == d.this.luF) {
                d.this.EQ(d.this.luG);
                return true;
            } else if (d.this.luL == (d.this.luF | 1)) {
                d.this.EQ(d.this.luG | 1);
                return true;
            } else if (d.this.luL == d.this.luG) {
                d.this.EQ(d.this.luF);
                return true;
            } else if (d.this.luL == (d.this.luG | 1)) {
                d.this.EQ(d.this.luF | 1);
                return true;
            } else {
                d.this.EQ(d.this.luB);
                d.this.startPlay();
                d.this.dkI();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kVW = 0;
            if (d.this.kzq) {
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
            if (d.this.akZ && d.this.dfk()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.kVW) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.fDP.isPlaying()) {
                                d.this.fDP.pause();
                                d.this.EQ(d.this.luK);
                            }
                            d.this.kVW = 4;
                            d.this.luM = d.this.luL;
                            d.this.luL = d.this.luJ;
                            d.this.lvm = d.this.lvb.getMeasuredHeight();
                            d.this.lvq = d.this.lvj / d.this.lvm;
                            d.this.lvr = (int) (1.2f * d.this.mRootView.getWidth());
                            da(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        da(rawX, rawY);
                        break;
                }
            } else if (d.this.luL == d.this.luC || d.this.luL == d.this.luE || d.this.luL == d.this.luF || d.this.luL == d.this.luG || d.this.luL == d.this.luJ || d.this.luL == (d.this.luF | 1) || d.this.luL == (d.this.luG | 1)) {
                switch (d.this.kVW) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kVW = 3;
                            d.this.lvk = d.this.fDP.getCurrentPosition();
                            aB(f);
                        } else if (motionEvent.getX() < d.this.lvb.getWidth() / 2) {
                            d.this.kVW = 2;
                            d.this.luY.s(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kVW = 1;
                            d.this.luY.r(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.luL != d.this.luJ) {
                            if ((d.this.luL & 1) > 0) {
                                d.this.luJ |= 1;
                            } else {
                                d.this.luJ &= -2;
                            }
                            d.this.EQ(d.this.luJ);
                            break;
                        }
                        break;
                    case 1:
                        d.this.luY.r(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dfo();
                            break;
                        }
                        break;
                    case 2:
                        d.this.luY.s(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aB(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void da(int i, int i2) {
            if (d.this.lvo != i2 || d.this.lvp != i) {
                d.this.lvn = d.this.lvo - i2 > 0 || ((float) i2) < d.this.lvi / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.lvb.getLayoutParams();
                if (i2 != d.this.lvo) {
                    int i3 = d.this.lvm - i2;
                    int i4 = (int) (i3 * d.this.lvq);
                    if (i4 < d.this.lvr) {
                        i4 = d.this.lvr;
                        i3 = (int) (i4 / d.this.lvq);
                    }
                    if (i4 != d.this.lvr) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.lvb.setLayoutParams(layoutParams);
                    }
                    d.this.lvo = i2;
                    d.this.lvb.setTranslationY(d.this.lvo);
                }
                if (i != d.this.lvo) {
                    d.this.lvp = i;
                    d.this.lvb.setTranslationX(d.this.lvp + ((d.this.lvj - layoutParams.width) / 2.0f));
                }
                d.this.luZ.setAlpha((layoutParams.width - d.this.lvr) / (d.this.lvj - d.this.lvr));
                if (d.this.luV.getVisibility() == 0) {
                    float f = d.this.lvi / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.luV.setAlpha(f2);
                }
            }
        }

        private void aB(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.lvk -= 1000;
                z = true;
            } else {
                d.this.lvk += 1000;
                z = false;
            }
            int duration = d.this.fDP.getDuration();
            if (d.this.lvk < 0) {
                d.this.lvk = 0;
            } else if (d.this.lvk > duration) {
                d.this.lvk = duration;
            }
            String str = at.stringForVideoTime(d.this.lvk) + " / " + at.stringForVideoTime(duration);
            if (d.this.luY != null) {
                d.this.luY.B(z, str);
            }
            d.this.luT.setCurrentDuration(d.this.lvk, false);
        }
    };
    private View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.luL == d.this.luJ) {
                if (d.this.kVW == 4) {
                    d.this.dkL();
                    d.this.lvo = 0;
                    d.this.lvp = 0;
                } else {
                    d.this.luL = -1;
                    if (d.this.kVW != 3) {
                        if (d.this.luM != -1) {
                            d.this.EQ(d.this.luM);
                            d.this.luM = -1;
                        } else if (d.this.fDP.isPlaying()) {
                            d.this.EQ(d.this.luC);
                        } else {
                            d.this.EQ(d.this.luF);
                        }
                    } else {
                        d.this.luT.setCurrentDuration(d.this.lvk, true);
                        if (d.this.lvk <= d.this.fDP.getDuration()) {
                            if (!d.this.fDP.isPlaying()) {
                                d.this.fDP.a(d.this.lvv);
                            }
                            d.this.EQ(d.this.luC);
                        }
                    }
                }
                if (d.this.lvg) {
                    String str = null;
                    if (d.this.kVW != 1) {
                        if (d.this.kVW != 2) {
                            if (d.this.kVW == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dD("tid", d.this.ala).u("fid", d.this.mFid));
                    }
                }
                d.this.kVW = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a lvv = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dkv() {
            d.this.fDP.dkr();
            d.this.dkC();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dkw() {
            d.this.EQ(d.this.luB);
            d.this.bFc();
        }
    };
    private final CustomMessageListener dUy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener lvw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ah.a(d.this.akW, true);
                    }
                    d.this.fDP.setVolume(1.0f, 1.0f);
                    d.this.luR.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.dfi();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void cA(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.lvi = l.getEquipmentHeight(this.mContext);
            this.lvj = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dfm() {
        int dimension;
        int i;
        int i2;
        this.luU.ar(this.akZ, this.kzq);
        this.luV.ar(this.akZ, this.kzq);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.akZ) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kzq) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.akT.setPadding(0, 0, i2, 0);
            this.luS.setPadding(this.luS.getPaddingLeft(), 0, i, 0);
            this.luR.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dfl() {
        if (this.akZ) {
            this.luE = 104;
            this.luF = 8290;
        } else {
            this.luE = 232;
            this.luF = 8418;
        }
        if (this.kzq) {
            this.luB |= 1024;
            this.luC |= 1024;
            this.luD |= 1024;
            this.luE |= 1024;
            this.luF |= 1024;
            this.luG |= 1024;
            this.luH |= 1024;
            this.luI |= 1024;
            this.luL |= 1024;
            return;
        }
        this.luB &= -1025;
        this.luC &= -1025;
        this.luD &= -1025;
        this.luE &= -1025;
        this.luF &= -1025;
        this.luG &= -1025;
        this.luH &= -1025;
        this.luI &= -1025;
        this.luL &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.lvb = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.lvb);
            }
            this.akW = new WeakReference<>(TbadkCoreApplication.getInst());
            this.akQ = (TbImageView) this.lvb.findViewById(R.id.video_thumbnail);
            this.luO = this.lvb.findViewById(R.id.black_mask);
            this.luP = (TBLottieAnimationView) this.lvb.findViewById(R.id.video_loading);
            this.akR = (ImageView) this.lvb.findViewById(R.id.video_play);
            this.luQ = (PercentSizeView) this.lvb.findViewById(R.id.video_media_controller_mask);
            this.akS = (ImageView) this.lvb.findViewById(R.id.video_pause);
            this.akT = (TextView) this.lvb.findViewById(R.id.video_play_count);
            this.akU = (TextView) this.lvb.findViewById(R.id.video_play_flag);
            this.akV = (TextView) this.lvb.findViewById(R.id.video_duration);
            this.luR = (SwitchImageView) this.lvb.findViewById(R.id.video_mute);
            this.luS = (SwitchImageView) this.lvb.findViewById(R.id.video_full_screen);
            this.luT = (OperableVideoMediaControllerView) this.lvb.findViewById(R.id.video_media_controller);
            this.luU = (OperableVideoNetworkStateTipView) this.lvb.findViewById(R.id.video_network_state_tip);
            this.luV = (OperableVideoShareView) this.lvb.findViewById(R.id.video_share_view);
            this.luX = this.lvb.findViewById(R.id.video_back_btn_mask);
            this.luW = (ImageView) this.lvb.findViewById(R.id.video_full_screen_back);
            this.luY = (VideoGestureView) this.lvb.findViewById(R.id.video_gesture);
            this.lva = (OperableVideoErrorView) this.lvb.findViewById(R.id.video_error_layout);
            this.luV.setVideoContainer(this);
            this.luP.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.luP.setVisibility(8);
                    d.this.akR.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.luP.setAnimation(R.raw.lotti_video_loading);
            SvgManager.bjq().a(this.akR, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.akR.setOnClickListener(this);
            this.luR.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.luR.setState(1);
            this.luR.setOnClickListener(this);
            this.akQ.bwn();
            this.akQ.setDrawCorner(false);
            this.akQ.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.luO, R.color.cp_mask_b_alpha50);
            this.luT.setOnSeekBarChangeListener(this.fpo);
            this.luQ.setHeightPercent(0.583f);
            this.luQ.setBackgroundResource(R.drawable.video_mask_bg);
            this.luS.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.luS.setState(0);
            this.luS.setOnClickListener(this);
            SvgManager.bjq().a(this.akS, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.akS.setOnClickListener(this);
            this.luW.setOnClickListener(this);
            this.fDP = new TbCyberVideoView(this.mContext);
            this.fDP.setTryUseViewInSet(true);
            dkC();
            this.luU.setPlayViewOnClickListener(this);
            this.lvb.setOnClickListener(null);
            this.lvb.setOnTouchListener(this.eVH);
            this.luV.setOnTouchListener(this.eVH);
            this.lva.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.ifc);
            EQ(this.luB);
            this.iwe = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dkC() {
        if (this.fDP != null && this.fDP.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.lvb.addView(this.fDP.getView(), 0);
            this.fDP.getView().setLayoutParams(layoutParams);
            this.luT.setPlayer(this.fDP);
            this.fDP.setContinuePlayEnable(true);
            this.fDP.setOnPreparedListener(this);
            this.fDP.setOnCompletionListener(this);
            this.fDP.setOnErrorListener(this);
            this.fDP.setOnSurfaceDestroyedListener(this);
            this.fDP.setOnInfoListener(this);
            this.fDP.setVideoStatData(this.lve);
            this.fDP.setThreadDataForStatistic(this.lvf);
            this.fDP.getMediaProgressObserver().a(this.lvu);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.beW() != null) {
            this.startPosition = -1L;
            if (this.iwe != null) {
                this.iwe.reset();
            }
            if (!at.equals(this.mVideoUrl, bwVar.beW().video_url)) {
                stopPlay();
                this.akZ = bwVar.beW().is_vertical.intValue() == 1;
                this.mVideoUrl = bwVar.beW().video_url;
                this.ala = bwVar.getTid();
                this.alb = bwVar.beW().video_length.intValue();
                this.lvd = bwVar.beW().video_duration.intValue();
                this.mFid = bwVar.getFid();
                this.lvs = bwVar.beW().mcn_ad_card;
                dfl();
                dfm();
                EQ(this.luB);
                int intValue = bwVar.beW().video_duration.intValue() * 1000;
                this.luT.FI(intValue);
                this.luT.setPlayer(this.fDP);
                this.akV.setText(at.stringForVideoTime(intValue));
                this.akT.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bwVar.beW().play_count.intValue())));
                this.luU.setVideoLength(bwVar.beW().video_length.intValue());
                this.luU.setVideoDuration(bwVar.beW().video_duration.intValue());
                this.luU.setTid(this.ala);
                this.lvf = bwVar;
                this.fDP.setThreadDataForStatistic(bwVar);
                this.akU.setVisibility(8);
                this.akQ.setPlaceHolder(3);
                this.akQ.startLoad(bwVar.beW().thumbnail_url, 10, false);
                this.luV.setShareData(bwVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.fDP != null) {
            this.lve = oVar;
            this.fDP.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.aeZ = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void FK(int i) {
        this.fDP.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahM = bdUniqueId;
    }

    public void dkD() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.luN);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.luN, this.lum);
    }

    public void dkE() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.luN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFc() {
        this.luP.setAlpha(1.0f);
        this.luP.setVisibility(0);
        this.akR.setVisibility(8);
        if (this.luP != null) {
            this.luP.loop(true);
            this.luP.setMinAndMaxFrame(14, 80);
            this.luP.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dfj() {
        if (this.luL == this.luD) {
            EQ(this.luC);
        }
    }

    private void dkF() {
        EQ(this.luD);
        this.luT.showProgress();
        if (this.luP != null) {
            this.luP.clearAnimation();
            this.luP.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dfj();
                    if (!d.this.lvc) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.luP.setVisibility(8);
                    d.this.akR.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dkG() {
        return this.luU != null && this.luU.dft();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.ahL = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dUy);
            MessageManager.getInstance().registerListener(this.lvw);
            if (dkG()) {
                EQ(this.luI);
                return;
            }
            this.lvc = true;
            if (!this.fDP.isPlaying()) {
                TbCyberVideoView OH = TbVideoViewSet.dku().OH(this.mVideoUrl);
                if (OH == null) {
                    this.fDP.dkr();
                    if (!StringUtils.isNull(this.fDP.getOriginUrl())) {
                        this.fDP = new TbCyberVideoView(this.mContext);
                        this.fDP.setTryUseViewInSet(true);
                    }
                    dkC();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.fDP.setVideoDuration(this.lvd);
                        this.fDP.setVideoPath(this.mVideoUrl, this.ala);
                        this.fDP.setStageType(this.ahL);
                        bFc();
                        if (this.lvg) {
                            dfr();
                        }
                    }
                } else {
                    if (this.fDP == OH) {
                        if (this.fDP.getParent() == null || this.fDP.getParent() != OH.getParent()) {
                            this.fDP.dkr();
                            dkC();
                        }
                    } else {
                        this.fDP.dkr();
                        OH.dkr();
                        this.fDP = OH;
                        this.fDP.setTryUseViewInSet(true);
                        dkC();
                    }
                    this.fDP.dks();
                    onPrepared();
                    dkM();
                    if (this.lvg) {
                        dfr();
                    }
                }
                if (this.lvg) {
                    TiebaStatic.log(new aq("c13357").dD("tid", this.ala).u("fid", this.mFid).ai("obj_type", this.akZ ? 1 : 2).ai("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ai("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.lvc = false;
        if (this.luP != null) {
            this.luP.cancelAnimation();
        }
        this.fDP.stop();
        this.fDP.dkr();
        this.luT.aIm();
        EQ(this.luB);
        MessageManager.getInstance().unRegisterListener(this.dUy);
        MessageManager.getInstance().unRegisterListener(this.lvw);
    }

    private void dkH() {
        this.lvc = false;
        if (this.luP != null) {
            this.luP.cancelAnimation();
        }
        this.fDP.stop();
        this.luT.aIm();
        EQ(this.luB);
        MessageManager.getInstance().unRegisterListener(this.dUy);
        MessageManager.getInstance().unRegisterListener(this.lvw);
    }

    public void dfr() {
        if (this.lve != null) {
            o dkh = this.lve.dkh();
            dkh.mLocate = this.mFrom;
            h.a(dkh.ltt, "", "1", dkh, this.fDP.getPcdnState());
        }
    }

    public void EQ(int i) {
        dkE();
        if (this.luL == this.luJ) {
            this.luM = i;
            return;
        }
        this.luL = i;
        this.akQ.setVisibility((i & 1) > 0 ? 0 : 8);
        this.luO.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.luP.clearAnimation();
        this.luP.setVisibility(z ? 0 : 8);
        if (!z) {
            this.luP.cancelAnimation();
        } else {
            this.luP.setAlpha(1.0f);
        }
        this.akR.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.akS.setVisibility((i & 8) > 0 ? 0 : 8);
        this.akT.setVisibility((i & 16) > 0 ? 0 : 8);
        this.akV.setVisibility((i & 16) > 0 ? 0 : 8);
        this.luR.setVisibility((i & 32) > 0 ? 0 : 8);
        this.luS.setVisibility((i & 64) > 0 ? 0 : 8);
        this.luT.setVisibility((i & 128) > 0 ? 0 : 8);
        this.luQ.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.luT.getVisibility() == 0) {
            this.luT.showProgress();
        }
        this.luU.setVisibility((i & 256) > 0 ? 0 : 8);
        this.luV.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.luV.getVisibility() == 0) {
            this.luV.setAlpha(1.0f);
        }
        this.luW.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.luX.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.luY.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.lva.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            ER(id);
            if (id == R.id.video_mute) {
                dkJ();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dkL();
            } else if (id == R.id.video_replay) {
                EQ(this.luB);
                startPlay();
                if (this.lvg) {
                    TiebaStatic.log(new aq("c13345").dD("tid", this.ala).u("fid", this.mFid).ai("obj_type", this.akZ ? 1 : 2).ai("obj_locate", this.kzq ? 1 : 2));
                }
                dkI();
            } else if (id == R.id.video_play) {
                if (this.luL == this.luB) {
                    startPlay();
                } else {
                    EQ(this.luE);
                    dkD();
                    this.fDP.a(this.lvv);
                }
                if (this.lvg) {
                    TiebaStatic.log(new aq("c13344").dD("tid", this.ala).u("fid", this.mFid).ai("obj_type", this.akZ ? 1 : 2).ai("obj_source", this.kzq ? 1 : 2).ai("obj_locate", 1));
                }
                dkI();
            } else if (id == R.id.video_pause) {
                EQ(this.luF);
                dkE();
                this.fDP.pause();
                if (this.lvg) {
                    TiebaStatic.log(new aq("c13344").dD("tid", this.ala).u("fid", this.mFid).ai("obj_type", this.akZ ? 1 : 2).ai("obj_source", this.kzq ? 1 : 2).ai("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                EQ(this.luB);
                startPlay();
            } else if (id == R.id.retry) {
                EQ(this.luB);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkI() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ahM);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void dfi() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.fDP.setVolume(0.0f, 0.0f);
            this.luR.setState(1);
            return;
        }
        this.fDP.setVolume(1.0f, 1.0f);
        this.luR.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dkJ() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.fDP.setVolume(1.0f, 1.0f);
            ah.a(this.akW, true);
            this.luR.setState(0);
        } else {
            this.fDP.setVolume(0.0f, 0.0f);
            this.luR.setState(1);
            ah.a(this.akW, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void ve(boolean z) {
        if (this.jQs == null) {
            this.jQs = new j((Activity) this.mContext);
        }
        if (z) {
            this.jQs.start();
            this.jQs.ct(true);
            return;
        }
        this.jQs.stop();
        this.jQs.ct(false);
    }

    public void dkK() {
        un(true);
    }

    public void un(boolean z) {
        if (this.mRootView != null && this.lvb != null && this.fDP != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.jQs == null) {
                this.jQs = new j((Activity) this.mContext);
            }
            if (this.kzq) {
                if (this.luZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.luZ.getParent()).removeView(this.luZ);
                }
                if ((this.lvb.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kzq = false;
                    this.lvh = true;
                    ((ViewGroup) this.lvb.getParent()).removeView(this.lvb);
                    ((ViewGroup) this.mRootView).addView(this.lvb);
                    this.lvh = false;
                    k((Activity) this.mContext, this.kzq);
                }
                if (!this.akZ && z) {
                    this.jQs.Oh();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.akZ && z) {
                        this.jQs.Oh();
                    }
                    if (this.mContext instanceof Activity) {
                        this.lvb.getLocationOnScreen(this.lvl);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.lvh = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.luZ == null) {
                                    this.luZ = new View(this.mContext);
                                    this.luZ.setClickable(true);
                                    this.luZ.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.luZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.luZ.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.luZ.getParent()).removeView(this.luZ);
                                }
                                this.luZ.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.luZ);
                                ((ViewGroup) childAt).addView(this.lvb);
                                this.lvh = false;
                                this.kzq = true;
                                k((Activity) this.mContext, this.kzq);
                                if (this.iwe != null && this.iwe.isShowing()) {
                                    this.iwe.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.lvg) {
                    TiebaStatic.log(new aq("c13360").dD("tid", this.ala).u("fid", this.mFid).ai("obj_type", this.akZ ? 1 : 2));
                }
            }
            dfl();
            dfm();
            if (this.fDP.isPlaying()) {
                EQ(this.luC);
            } else {
                EQ(this.luL);
            }
            this.luS.dFx();
            vf(this.kzq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkL() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.akZ) {
            dkK();
        } else if (this.luL == this.luJ) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.lvb.setScaleX(1.0f);
                    d.this.lvb.setScaleY(1.0f);
                    d.this.lvb.setTranslationX(0.0f);
                    d.this.lvb.setTranslationY(0.0f);
                    d.this.luV.setScaleX(1.0f);
                    d.this.luV.setScaleY(1.0f);
                    d.this.lvb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.lvn) {
                        d.this.dkK();
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
            if (!this.lvn) {
                float width = this.mRootView.getWidth() / this.lvb.getWidth();
                float height = this.mRootView.getHeight() / this.lvb.getHeight();
                this.lvb.setPivotX(0.0f);
                this.lvb.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lvb, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.lvb, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.luV, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.luV, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.lvb, "TranslationX", this.lvb.getTranslationX(), this.lvl[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.lvb, "TranslationY", this.lvb.getTranslationY(), this.lvl[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.luZ, "alpha", this.luZ.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.luV, "alpha", this.luV.getAlpha(), 0.0f);
            } else {
                float width2 = this.lvj / this.lvb.getWidth();
                float height2 = this.lvm / this.lvb.getHeight();
                this.lvb.setPivotX(0.0f);
                this.lvb.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.lvb, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.lvb, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.luV, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.luV, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.lvb, "TranslationX", this.lvb.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.lvb, "TranslationY", this.lvb.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.luV, "alpha", this.luV.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.luM != -1) {
                this.luL = this.luM;
                this.luM = -1;
                if (this.luL == this.luK || this.luL == this.luE || this.luL == this.luC) {
                    this.fDP.a(this.lvv);
                    EQ(this.luC);
                }
            }
        } else {
            dkK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.akZ && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.lvb != null) {
                    if (z) {
                        this.lvb.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.lvb.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cMM();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.lvb.setSystemUiVisibility(0);
            }
        }
    }

    private void dkM() {
        EQ(this.luD);
        this.luT.showProgress();
        dkF();
    }

    protected void vf(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        dfi();
        if (this.lvc) {
            if (this.kzq && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.fDP.a(this.lvv);
        }
    }

    public void onCompletion() {
        EQ(this.luH);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        EQ(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.lvh) {
            if (this.luL == this.luF || (this.luL == this.luG && !this.fDP.isPlaying())) {
                dkH();
                EQ(this.luF);
            } else if (this.luL == this.luH) {
                dkH();
                EQ(this.luH);
            } else {
                dkH();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dkM();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View djP() {
        return this.lvb;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.lvc || this.fDP.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.fDP.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bKC() {
    }

    protected void ER(int i) {
    }

    protected boolean ab(MotionEvent motionEvent) {
        return this.kzq;
    }

    protected boolean dfk() {
        return this.akZ && this.kzq;
    }

    private void cMM() {
        if (Build.VERSION.SDK_INT < 16) {
            this.lvb.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.lvb.setSystemUiVisibility(4);
        } else {
            this.lvb.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dfo() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.fDP.isPlaying() && !ah.bvP()) {
            this.fDP.setVolume(1.0f, 1.0f);
            this.luR.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dfp() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean pP(boolean z) {
        if (z) {
            this.luP.cancelAnimation();
            if (this.luL == this.luC || this.luL == this.luD || this.luL == this.luE || this.luL == this.luB) {
                stopPlay();
            }
            this.luL |= 1;
            EQ(this.luL);
        } else if (this.luL == this.luB) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kzq;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dkA() {
        if (this.kzq) {
            dkL();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cyJ() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dkN() {
        return this.lvs != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vg(boolean z) {
        this.afi = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.lvt = aVar;
    }
}
