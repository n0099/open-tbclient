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
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.play.operableVideoView.a {
    private String ahJ;
    protected BdUniqueId ahK;
    protected TbImageView akO;
    private ImageView akP;
    private ImageView akQ;
    protected TextView akR;
    protected TextView akS;
    private TextView akT;
    protected boolean akX;
    protected String akY;
    protected long akZ;
    protected TbCyberVideoView fDL;
    private com.baidu.mcn.c ivY;
    private j jQm;
    private View luD;
    private TBLottieAnimationView luE;
    private PercentSizeView luF;
    protected SwitchImageView luG;
    protected SwitchImageView luH;
    protected OperableVideoMediaControllerView luI;
    protected OperableVideoNetworkStateTipView luJ;
    protected OperableVideoShareView luK;
    protected ImageView luL;
    protected View luM;
    protected VideoGestureView luN;
    private View luO;
    private OperableVideoErrorView luP;
    protected ViewGroup luQ;
    protected boolean luR;
    protected int luS;
    protected o luT;
    protected bw luU;
    private float luX;
    private float luY;
    private int luZ;
    private int lvb;
    private boolean lvc;
    private float lvf;
    private int lvg;
    private McnAdInfo lvh;
    private a lvi;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected int lub = 3000;
    protected final int luc = 1;
    protected final int lud = 2;
    protected final int lue = 4;
    protected final int luf = 8;
    protected final int lug = 16;
    protected final int luh = 32;
    protected final int lui = 64;
    protected final int luj = 128;
    protected final int luk = 256;
    protected final int lul = 512;
    protected final int lum = 1024;
    protected final int lun = 2048;
    protected final int luo = 4096;
    protected final int lup = 8192;
    protected int luq = 8211;
    protected int lur = 0;
    protected int lus = 4;
    protected int lut = 232;
    protected int luu = 8416;
    protected int luv = 0;
    protected int luw = 513;
    protected int lux = 259;
    protected int luy = 2048;
    protected int luz = 0;
    protected int STATE_ERROR = 4099;
    protected int luA = this.luq;
    private int kVP = 0;
    private int luB = -1;
    private Runnable luC = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.EQ(d.this.lur);
        }
    };
    private WeakReference<Context> akU = null;
    protected boolean kzj = false;
    protected boolean luV = true;
    private boolean luW = false;
    private int[] lva = new int[2];
    private int lvd = 0;
    private int lve = 0;
    protected View.OnClickListener aiA = null;
    protected View.OnClickListener aeX = null;
    private boolean afg = false;
    private long startPosition = -1;
    private f.b lvj = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.4
        @Override // com.baidu.tieba.play.f.b
        public void bX(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dkK() && !d.this.akX && !d.this.kzj && d.this.afg) {
                if (!com.baidu.mcn.b.SM().hI(d.this.lvh.jump_url)) {
                    boolean z = ((long) i2) >= d.this.lvh.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.lvh.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.lvh.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.ivY.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bzR = d.this.lvh.card_title;
                            aVar.bzS = d.this.lvh.button_title;
                            aVar.bzT = d.this.lvh.jump_url;
                            aVar.bzQ = d.this.lvh.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.akY;
                            aVar.bzU = d.this.cyI();
                            if (z2) {
                                d.this.ivY.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.ivY.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.ivY.isShowing()) {
                        d.this.ivY.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.lvi != null) {
                d.this.lvi.cA(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fpk = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.EQ(d.this.lut);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.fDL.isPlaying()) {
                    d.this.fDL.a(d.this.lvk);
                }
                d.this.dkA();
                if (d.this.luV) {
                    TiebaStatic.log(new aq("c13355").dD("tid", d.this.akY).u("fid", d.this.mFid).ai("obj_type", d.this.akX ? 1 : 2).ai("obj_locate", d.this.kzj ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener ieW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.fDL.isPlaying()) {
                d.this.fDL.pause();
                if (d.this.luA == d.this.lut) {
                    d.this.EQ(d.this.luu);
                } else {
                    d.this.EQ(d.this.luv);
                }
                d.this.ER(R.id.video_pause);
            } else if (d.this.luA == d.this.luu || d.this.luA == (d.this.luu | 1)) {
                d.this.EQ(d.this.lut);
                d.this.dkA();
                d.this.fDL.a(d.this.lvk);
                d.this.ER(R.id.video_play);
            } else if (d.this.luA == d.this.luv || d.this.luA == (d.this.luv | 1)) {
                d.this.EQ(d.this.lur);
                d.this.fDL.a(d.this.lvk);
                d.this.ER(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.fDL.isPlaying()) {
                if (d.this.luA == d.this.lur || d.this.luA == d.this.lus) {
                    d.this.EQ(d.this.lut);
                    d.this.dkA();
                    return true;
                } else if (d.this.luA == d.this.lut) {
                    d.this.EQ(d.this.lur);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.luA == d.this.luu) {
                d.this.EQ(d.this.luv);
                return true;
            } else if (d.this.luA == (d.this.luu | 1)) {
                d.this.EQ(d.this.luv | 1);
                return true;
            } else if (d.this.luA == d.this.luv) {
                d.this.EQ(d.this.luu);
                return true;
            } else if (d.this.luA == (d.this.luv | 1)) {
                d.this.EQ(d.this.luu | 1);
                return true;
            } else {
                d.this.EQ(d.this.luq);
                d.this.startPlay();
                d.this.dkF();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.kVP = 0;
            if (d.this.kzj) {
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
            if (d.this.akX && d.this.dfj()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.kVP) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.fDL.isPlaying()) {
                                d.this.fDL.pause();
                                d.this.EQ(d.this.luz);
                            }
                            d.this.kVP = 4;
                            d.this.luB = d.this.luA;
                            d.this.luA = d.this.luy;
                            d.this.lvb = d.this.luQ.getMeasuredHeight();
                            d.this.lvf = d.this.luY / d.this.lvb;
                            d.this.lvg = (int) (1.2f * d.this.mRootView.getWidth());
                            da(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        da(rawX, rawY);
                        break;
                }
            } else if (d.this.luA == d.this.lur || d.this.luA == d.this.lut || d.this.luA == d.this.luu || d.this.luA == d.this.luv || d.this.luA == d.this.luy || d.this.luA == (d.this.luu | 1) || d.this.luA == (d.this.luv | 1)) {
                switch (d.this.kVP) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.kVP = 3;
                            d.this.luZ = d.this.fDL.getCurrentPosition();
                            aB(f);
                        } else if (motionEvent.getX() < d.this.luQ.getWidth() / 2) {
                            d.this.kVP = 2;
                            d.this.luN.s(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.kVP = 1;
                            d.this.luN.r(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.luA != d.this.luy) {
                            if ((d.this.luA & 1) > 0) {
                                d.this.luy |= 1;
                            } else {
                                d.this.luy &= -2;
                            }
                            d.this.EQ(d.this.luy);
                            break;
                        }
                        break;
                    case 1:
                        d.this.luN.r(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dfn();
                            break;
                        }
                        break;
                    case 2:
                        d.this.luN.s(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aB(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void da(int i, int i2) {
            if (d.this.lvd != i2 || d.this.lve != i) {
                d.this.lvc = d.this.lvd - i2 > 0 || ((float) i2) < d.this.luX / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.luQ.getLayoutParams();
                if (i2 != d.this.lvd) {
                    int i3 = d.this.lvb - i2;
                    int i4 = (int) (i3 * d.this.lvf);
                    if (i4 < d.this.lvg) {
                        i4 = d.this.lvg;
                        i3 = (int) (i4 / d.this.lvf);
                    }
                    if (i4 != d.this.lvg) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.luQ.setLayoutParams(layoutParams);
                    }
                    d.this.lvd = i2;
                    d.this.luQ.setTranslationY(d.this.lvd);
                }
                if (i != d.this.lvd) {
                    d.this.lve = i;
                    d.this.luQ.setTranslationX(d.this.lve + ((d.this.luY - layoutParams.width) / 2.0f));
                }
                d.this.luO.setAlpha((layoutParams.width - d.this.lvg) / (d.this.luY - d.this.lvg));
                if (d.this.luK.getVisibility() == 0) {
                    float f = d.this.luX / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.luK.setAlpha(f2);
                }
            }
        }

        private void aB(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.luZ -= 1000;
                z = true;
            } else {
                d.this.luZ += 1000;
                z = false;
            }
            int duration = d.this.fDL.getDuration();
            if (d.this.luZ < 0) {
                d.this.luZ = 0;
            } else if (d.this.luZ > duration) {
                d.this.luZ = duration;
            }
            String str = at.stringForVideoTime(d.this.luZ) + " / " + at.stringForVideoTime(duration);
            if (d.this.luN != null) {
                d.this.luN.B(z, str);
            }
            d.this.luI.setCurrentDuration(d.this.luZ, false);
        }
    };
    private View.OnTouchListener eVD = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.luA == d.this.luy) {
                if (d.this.kVP == 4) {
                    d.this.dkI();
                    d.this.lvd = 0;
                    d.this.lve = 0;
                } else {
                    d.this.luA = -1;
                    if (d.this.kVP != 3) {
                        if (d.this.luB != -1) {
                            d.this.EQ(d.this.luB);
                            d.this.luB = -1;
                        } else if (d.this.fDL.isPlaying()) {
                            d.this.EQ(d.this.lur);
                        } else {
                            d.this.EQ(d.this.luu);
                        }
                    } else {
                        d.this.luI.setCurrentDuration(d.this.luZ, true);
                        if (d.this.luZ <= d.this.fDL.getDuration()) {
                            if (!d.this.fDL.isPlaying()) {
                                d.this.fDL.a(d.this.lvk);
                            }
                            d.this.EQ(d.this.lur);
                        }
                    }
                }
                if (d.this.luV) {
                    String str = null;
                    if (d.this.kVP != 1) {
                        if (d.this.kVP != 2) {
                            if (d.this.kVP == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!at.isEmpty(str)) {
                        TiebaStatic.log(new aq(str).dD("tid", d.this.akY).u("fid", d.this.mFid));
                    }
                }
                d.this.kVP = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a lvk = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.11
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dks() {
            d.this.fDL.dko();
            d.this.dkz();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dkt() {
            d.this.EQ(d.this.luq);
            d.this.bFb();
        }
    };
    private final CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                d.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener lvl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (d.this.isPlaying()) {
                        ah.a(d.this.akU, true);
                    }
                    d.this.fDL.setVolume(1.0f, 1.0f);
                    d.this.luG.setState(0);
                    TbSingleton.getInstance().setVideoCardMute(false);
                    return;
                }
                d.this.dfh();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void cA(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.luX = l.getEquipmentHeight(this.mContext);
            this.luY = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dfl() {
        int dimension;
        int i;
        int i2;
        this.luJ.ar(this.akX, this.kzj);
        this.luK.ar(this.akX, this.kzj);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.akX) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.kzj) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.akR.setPadding(0, 0, i2, 0);
            this.luH.setPadding(this.luH.getPaddingLeft(), 0, i, 0);
            this.luG.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dfk() {
        if (this.akX) {
            this.lut = 104;
            this.luu = 8290;
        } else {
            this.lut = 232;
            this.luu = 8418;
        }
        if (this.kzj) {
            this.luq |= 1024;
            this.lur |= 1024;
            this.lus |= 1024;
            this.lut |= 1024;
            this.luu |= 1024;
            this.luv |= 1024;
            this.luw |= 1024;
            this.lux |= 1024;
            this.luA |= 1024;
            return;
        }
        this.luq &= -1025;
        this.lur &= -1025;
        this.lus &= -1025;
        this.lut &= -1025;
        this.luu &= -1025;
        this.luv &= -1025;
        this.luw &= -1025;
        this.lux &= -1025;
        this.luA &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.luQ = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.luQ);
            }
            this.akU = new WeakReference<>(TbadkCoreApplication.getInst());
            this.akO = (TbImageView) this.luQ.findViewById(R.id.video_thumbnail);
            this.luD = this.luQ.findViewById(R.id.black_mask);
            this.luE = (TBLottieAnimationView) this.luQ.findViewById(R.id.video_loading);
            this.akP = (ImageView) this.luQ.findViewById(R.id.video_play);
            this.luF = (PercentSizeView) this.luQ.findViewById(R.id.video_media_controller_mask);
            this.akQ = (ImageView) this.luQ.findViewById(R.id.video_pause);
            this.akR = (TextView) this.luQ.findViewById(R.id.video_play_count);
            this.akS = (TextView) this.luQ.findViewById(R.id.video_play_flag);
            this.akT = (TextView) this.luQ.findViewById(R.id.video_duration);
            this.luG = (SwitchImageView) this.luQ.findViewById(R.id.video_mute);
            this.luH = (SwitchImageView) this.luQ.findViewById(R.id.video_full_screen);
            this.luI = (OperableVideoMediaControllerView) this.luQ.findViewById(R.id.video_media_controller);
            this.luJ = (OperableVideoNetworkStateTipView) this.luQ.findViewById(R.id.video_network_state_tip);
            this.luK = (OperableVideoShareView) this.luQ.findViewById(R.id.video_share_view);
            this.luM = this.luQ.findViewById(R.id.video_back_btn_mask);
            this.luL = (ImageView) this.luQ.findViewById(R.id.video_full_screen_back);
            this.luN = (VideoGestureView) this.luQ.findViewById(R.id.video_gesture);
            this.luP = (OperableVideoErrorView) this.luQ.findViewById(R.id.video_error_layout);
            this.luK.setVideoContainer(this);
            this.luE.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.luE.setVisibility(8);
                    d.this.akP.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.luE.setAnimation(R.raw.lotti_video_loading);
            SvgManager.bjq().a(this.akP, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.akP.setOnClickListener(this);
            this.luG.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.luG.setState(1);
            this.luG.setOnClickListener(this);
            this.akO.bwm();
            this.akO.setDrawCorner(false);
            this.akO.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.luD, R.color.cp_mask_b_alpha50);
            this.luI.setOnSeekBarChangeListener(this.fpk);
            this.luF.setHeightPercent(0.583f);
            this.luF.setBackgroundResource(R.drawable.video_mask_bg);
            this.luH.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.luH.setState(0);
            this.luH.setOnClickListener(this);
            SvgManager.bjq().a(this.akQ, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.akQ.setOnClickListener(this);
            this.luL.setOnClickListener(this);
            this.fDL = new TbCyberVideoView(this.mContext);
            this.fDL.setTryUseViewInSet(true);
            dkz();
            this.luJ.setPlayViewOnClickListener(this);
            this.luQ.setOnClickListener(null);
            this.luQ.setOnTouchListener(this.eVD);
            this.luK.setOnTouchListener(this.eVD);
            this.luP.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.ieW);
            EQ(this.luq);
            this.ivY = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dkz() {
        if (this.fDL != null && this.fDL.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.luQ.addView(this.fDL.getView(), 0);
            this.fDL.getView().setLayoutParams(layoutParams);
            this.luI.setPlayer(this.fDL);
            this.fDL.setContinuePlayEnable(true);
            this.fDL.setOnPreparedListener(this);
            this.fDL.setOnCompletionListener(this);
            this.fDL.setOnErrorListener(this);
            this.fDL.setOnSurfaceDestroyedListener(this);
            this.fDL.setOnInfoListener(this);
            this.fDL.setVideoStatData(this.luT);
            this.fDL.setThreadDataForStatistic(this.luU);
            this.fDL.getMediaProgressObserver().a(this.lvj);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.beW() != null) {
            this.startPosition = -1L;
            if (this.ivY != null) {
                this.ivY.reset();
            }
            if (!at.equals(this.mVideoUrl, bwVar.beW().video_url)) {
                stopPlay();
                this.akX = bwVar.beW().is_vertical.intValue() == 1;
                this.mVideoUrl = bwVar.beW().video_url;
                this.akY = bwVar.getTid();
                this.akZ = bwVar.beW().video_length.intValue();
                this.luS = bwVar.beW().video_duration.intValue();
                this.mFid = bwVar.getFid();
                this.lvh = bwVar.beW().mcn_ad_card;
                dfk();
                dfl();
                EQ(this.luq);
                int intValue = bwVar.beW().video_duration.intValue() * 1000;
                this.luI.FI(intValue);
                this.luI.setPlayer(this.fDL);
                this.akT.setText(at.stringForVideoTime(intValue));
                this.akR.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bwVar.beW().play_count.intValue())));
                this.luJ.setVideoLength(bwVar.beW().video_length.intValue());
                this.luJ.setVideoDuration(bwVar.beW().video_duration.intValue());
                this.luJ.setTid(this.akY);
                this.luU = bwVar;
                this.fDL.setThreadDataForStatistic(bwVar);
                this.akS.setVisibility(8);
                this.akO.setPlaceHolder(3);
                this.akO.startLoad(bwVar.beW().thumbnail_url, 10, false);
                this.luK.setShareData(bwVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.fDL != null) {
            this.luT = oVar;
            this.fDL.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.aeX = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void FK(int i) {
        this.fDL.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahK = bdUniqueId;
    }

    public void dkA() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.luC);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.luC, this.lub);
    }

    public void dkB() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.luC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFb() {
        this.luE.setAlpha(1.0f);
        this.luE.setVisibility(0);
        this.akP.setVisibility(8);
        if (this.luE != null) {
            this.luE.loop(true);
            this.luE.setMinAndMaxFrame(14, 80);
            this.luE.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dfi() {
        if (this.luA == this.lus) {
            EQ(this.lur);
        }
    }

    private void dkC() {
        EQ(this.lus);
        this.luI.showProgress();
        if (this.luE != null) {
            this.luE.clearAnimation();
            this.luE.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dfi();
                    if (!d.this.luR) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.luE.setVisibility(8);
                    d.this.akP.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dkD() {
        return this.luJ != null && this.luJ.dfs();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.ahJ = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.dUu);
            MessageManager.getInstance().registerListener(this.lvl);
            if (dkD()) {
                EQ(this.lux);
                return;
            }
            this.luR = true;
            if (!this.fDL.isPlaying()) {
                TbCyberVideoView OG = TbVideoViewSet.dkr().OG(this.mVideoUrl);
                if (OG == null) {
                    this.fDL.dko();
                    if (!StringUtils.isNull(this.fDL.getOriginUrl())) {
                        this.fDL = new TbCyberVideoView(this.mContext);
                        this.fDL.setTryUseViewInSet(true);
                    }
                    dkz();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.fDL.setVideoDuration(this.luS);
                        this.fDL.setVideoPath(this.mVideoUrl, this.akY);
                        this.fDL.setStageType(this.ahJ);
                        bFb();
                        if (this.luV) {
                            dfq();
                        }
                    }
                } else {
                    if (this.fDL == OG) {
                        if (this.fDL.getParent() == null || this.fDL.getParent() != OG.getParent()) {
                            this.fDL.dko();
                            dkz();
                        }
                    } else {
                        this.fDL.dko();
                        OG.dko();
                        this.fDL = OG;
                        this.fDL.setTryUseViewInSet(true);
                        dkz();
                    }
                    this.fDL.dkp();
                    onPrepared();
                    dkJ();
                    if (this.luV) {
                        dfq();
                    }
                }
                if (this.luV) {
                    TiebaStatic.log(new aq("c13357").dD("tid", this.akY).u("fid", this.mFid).ai("obj_type", this.akX ? 1 : 2).ai("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ai("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.luR = false;
        if (this.luE != null) {
            this.luE.cancelAnimation();
        }
        this.fDL.stop();
        this.fDL.dko();
        this.luI.aIm();
        EQ(this.luq);
        MessageManager.getInstance().unRegisterListener(this.dUu);
        MessageManager.getInstance().unRegisterListener(this.lvl);
    }

    private void dkE() {
        this.luR = false;
        if (this.luE != null) {
            this.luE.cancelAnimation();
        }
        this.fDL.stop();
        this.luI.aIm();
        EQ(this.luq);
        MessageManager.getInstance().unRegisterListener(this.dUu);
        MessageManager.getInstance().unRegisterListener(this.lvl);
    }

    public void dfq() {
        if (this.luT != null) {
            o dke = this.luT.dke();
            dke.mLocate = this.mFrom;
            h.a(dke.lth, "", "1", dke, this.fDL.getPcdnState());
        }
    }

    public void EQ(int i) {
        dkB();
        if (this.luA == this.luy) {
            this.luB = i;
            return;
        }
        this.luA = i;
        this.akO.setVisibility((i & 1) > 0 ? 0 : 8);
        this.luD.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.luE.clearAnimation();
        this.luE.setVisibility(z ? 0 : 8);
        if (!z) {
            this.luE.cancelAnimation();
        } else {
            this.luE.setAlpha(1.0f);
        }
        this.akP.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.akQ.setVisibility((i & 8) > 0 ? 0 : 8);
        this.akR.setVisibility((i & 16) > 0 ? 0 : 8);
        this.akT.setVisibility((i & 16) > 0 ? 0 : 8);
        this.luG.setVisibility((i & 32) > 0 ? 0 : 8);
        this.luH.setVisibility((i & 64) > 0 ? 0 : 8);
        this.luI.setVisibility((i & 128) > 0 ? 0 : 8);
        this.luF.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.luI.getVisibility() == 0) {
            this.luI.showProgress();
        }
        this.luJ.setVisibility((i & 256) > 0 ? 0 : 8);
        this.luK.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.luK.getVisibility() == 0) {
            this.luK.setAlpha(1.0f);
        }
        this.luL.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.luM.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.luN.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.luP.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            ER(id);
            if (id == R.id.video_mute) {
                dkG();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dkI();
            } else if (id == R.id.video_replay) {
                EQ(this.luq);
                startPlay();
                if (this.luV) {
                    TiebaStatic.log(new aq("c13345").dD("tid", this.akY).u("fid", this.mFid).ai("obj_type", this.akX ? 1 : 2).ai("obj_locate", this.kzj ? 1 : 2));
                }
                dkF();
            } else if (id == R.id.video_play) {
                if (this.luA == this.luq) {
                    startPlay();
                } else {
                    EQ(this.lut);
                    dkA();
                    this.fDL.a(this.lvk);
                }
                if (this.luV) {
                    TiebaStatic.log(new aq("c13344").dD("tid", this.akY).u("fid", this.mFid).ai("obj_type", this.akX ? 1 : 2).ai("obj_source", this.kzj ? 1 : 2).ai("obj_locate", 1));
                }
                dkF();
            } else if (id == R.id.video_pause) {
                EQ(this.luu);
                dkB();
                this.fDL.pause();
                if (this.luV) {
                    TiebaStatic.log(new aq("c13344").dD("tid", this.akY).u("fid", this.mFid).ai("obj_type", this.akX ? 1 : 2).ai("obj_source", this.kzj ? 1 : 2).ai("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                EQ(this.luq);
                startPlay();
            } else if (id == R.id.retry) {
                EQ(this.luq);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkF() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.ahK);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void dfh() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.fDL.setVolume(0.0f, 0.0f);
            this.luG.setState(1);
            return;
        }
        this.fDL.setVolume(1.0f, 1.0f);
        this.luG.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dkG() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.fDL.setVolume(1.0f, 1.0f);
            ah.a(this.akU, true);
            this.luG.setState(0);
        } else {
            this.fDL.setVolume(0.0f, 0.0f);
            this.luG.setState(1);
            ah.a(this.akU, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void vc(boolean z) {
        if (this.jQm == null) {
            this.jQm = new j((Activity) this.mContext);
        }
        if (z) {
            this.jQm.start();
            this.jQm.cs(true);
            return;
        }
        this.jQm.stop();
        this.jQm.cs(false);
    }

    public void dkH() {
        ul(true);
    }

    public void ul(boolean z) {
        if (this.mRootView != null && this.luQ != null && this.fDL != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.jQm == null) {
                this.jQm = new j((Activity) this.mContext);
            }
            if (this.kzj) {
                if (this.luO.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.luO.getParent()).removeView(this.luO);
                }
                if ((this.luQ.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.kzj = false;
                    this.luW = true;
                    ((ViewGroup) this.luQ.getParent()).removeView(this.luQ);
                    ((ViewGroup) this.mRootView).addView(this.luQ);
                    this.luW = false;
                    k((Activity) this.mContext, this.kzj);
                }
                if (!this.akX && z) {
                    this.jQm.Oh();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.akX && z) {
                        this.jQm.Oh();
                    }
                    if (this.mContext instanceof Activity) {
                        this.luQ.getLocationOnScreen(this.lva);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.luW = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.luO == null) {
                                    this.luO = new View(this.mContext);
                                    this.luO.setClickable(true);
                                    this.luO.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.luO.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.luO.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.luO.getParent()).removeView(this.luO);
                                }
                                this.luO.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.luO);
                                ((ViewGroup) childAt).addView(this.luQ);
                                this.luW = false;
                                this.kzj = true;
                                k((Activity) this.mContext, this.kzj);
                                if (this.ivY != null && this.ivY.isShowing()) {
                                    this.ivY.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.luV) {
                    TiebaStatic.log(new aq("c13360").dD("tid", this.akY).u("fid", this.mFid).ai("obj_type", this.akX ? 1 : 2));
                }
            }
            dfk();
            dfl();
            if (this.fDL.isPlaying()) {
                EQ(this.lur);
            } else {
                EQ(this.luA);
            }
            this.luH.dFo();
            vd(this.kzj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkI() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.akX) {
            dkH();
        } else if (this.luA == this.luy) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.luQ.setScaleX(1.0f);
                    d.this.luQ.setScaleY(1.0f);
                    d.this.luQ.setTranslationX(0.0f);
                    d.this.luQ.setTranslationY(0.0f);
                    d.this.luK.setScaleX(1.0f);
                    d.this.luK.setScaleY(1.0f);
                    d.this.luQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.lvc) {
                        d.this.dkH();
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
            if (!this.lvc) {
                float width = this.mRootView.getWidth() / this.luQ.getWidth();
                float height = this.mRootView.getHeight() / this.luQ.getHeight();
                this.luQ.setPivotX(0.0f);
                this.luQ.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.luQ, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.luQ, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.luK, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.luK, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.luQ, "TranslationX", this.luQ.getTranslationX(), this.lva[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.luQ, "TranslationY", this.luQ.getTranslationY(), this.lva[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.luO, "alpha", this.luO.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.luK, "alpha", this.luK.getAlpha(), 0.0f);
            } else {
                float width2 = this.luY / this.luQ.getWidth();
                float height2 = this.lvb / this.luQ.getHeight();
                this.luQ.setPivotX(0.0f);
                this.luQ.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.luQ, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.luQ, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.luK, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.luK, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.luQ, "TranslationX", this.luQ.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.luQ, "TranslationY", this.luQ.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.luK, "alpha", this.luK.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.luB != -1) {
                this.luA = this.luB;
                this.luB = -1;
                if (this.luA == this.luz || this.luA == this.lut || this.luA == this.lur) {
                    this.fDL.a(this.lvk);
                    EQ(this.lur);
                }
            }
        } else {
            dkH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.akX && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.luQ != null) {
                    if (z) {
                        this.luQ.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.luQ.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cML();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.luQ.setSystemUiVisibility(0);
            }
        }
    }

    private void dkJ() {
        EQ(this.lus);
        this.luI.showProgress();
        dkC();
    }

    protected void vd(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        dfh();
        if (this.luR) {
            if (this.kzj && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.fDL.a(this.lvk);
        }
    }

    public void onCompletion() {
        EQ(this.luw);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        EQ(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.luW) {
            if (this.luA == this.luu || (this.luA == this.luv && !this.fDL.isPlaying())) {
                dkE();
                EQ(this.luu);
            } else if (this.luA == this.luw) {
                dkE();
                EQ(this.luw);
            } else {
                dkE();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dkJ();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View djM() {
        return this.luQ;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.luR || this.fDL.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.fDL.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bKB() {
    }

    protected void ER(int i) {
    }

    protected boolean ab(MotionEvent motionEvent) {
        return this.kzj;
    }

    protected boolean dfj() {
        return this.akX && this.kzj;
    }

    private void cML() {
        if (Build.VERSION.SDK_INT < 16) {
            this.luQ.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.luQ.setSystemUiVisibility(4);
        } else {
            this.luQ.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dfn() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.fDL.isPlaying() && !ah.bvO()) {
            this.fDL.setVolume(1.0f, 1.0f);
            this.luG.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dfo() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean pN(boolean z) {
        if (z) {
            this.luE.cancelAnimation();
            if (this.luA == this.lur || this.luA == this.lus || this.luA == this.lut || this.luA == this.luq) {
                stopPlay();
            }
            this.luA |= 1;
            EQ(this.luA);
        } else if (this.luA == this.luq) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.kzj;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dkx() {
        if (this.kzj) {
            dkI();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cyI() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dkK() {
        return this.lvh != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ve(boolean z) {
        this.afg = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.lvi = aVar;
    }
}
