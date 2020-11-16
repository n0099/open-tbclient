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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private String aiD;
    protected BdUniqueId aiE;
    protected TbImageView alP;
    private ImageView alQ;
    private ImageView alR;
    protected TextView alS;
    protected TextView alT;
    private TextView alU;
    protected boolean alY;
    protected String alZ;
    protected long ama;
    protected TbCyberVideoView giK;
    private com.baidu.mcn.c jlu;
    private j kGQ;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    private View mlL;
    private TBLottieAnimationView mlM;
    private PercentSizeView mlN;
    protected SwitchImageView mlO;
    protected SwitchImageView mlP;
    protected OperableVideoMediaControllerView mlQ;
    protected OperableVideoNetworkStateTipView mlR;
    protected OperableVideoShareView mlS;
    protected ImageView mlT;
    protected View mlU;
    protected VideoGestureView mlV;
    private View mlW;
    private OperableVideoErrorView mlX;
    protected ViewGroup mlY;
    protected boolean mlZ;
    protected int mma;
    protected o mmb;
    protected bx mmc;
    private float mmf;
    private float mmg;
    private int mmh;
    private int mmj;
    private boolean mmk;
    private float mmn;
    private int mmo;
    private McnAdInfo mmp;
    private a mmq;
    protected int mlj = 3000;
    protected final int mlk = 1;
    protected final int mll = 2;
    protected final int mlm = 4;
    protected final int mln = 8;
    protected final int mlo = 16;
    protected final int mlp = 32;
    protected final int mlq = 64;
    protected final int mlr = 128;
    protected final int mls = 256;
    protected final int mlt = 512;
    protected final int mlu = 1024;
    protected final int mlv = 2048;
    protected final int mlw = 4096;
    protected final int mlx = 8192;
    protected int mly = 8211;
    protected int mlz = 0;
    protected int mlA = 4;
    protected int mlB = 232;
    protected int mlC = 8416;
    protected int mlD = 0;
    protected int mlE = 513;
    protected int mlF = 259;
    protected int mlG = 2048;
    protected int mlH = 0;
    protected int STATE_ERROR = 4099;
    protected int mlI = this.mly;
    private int lME = 0;
    private int mlJ = -1;
    private Runnable mlK = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.Hb(d.this.mlz);
        }
    };
    private WeakReference<Context> alV = null;
    protected boolean lpN = false;
    protected boolean mmd = true;
    private boolean mme = false;
    private int[] mmi = new int[2];
    private int mml = 0;
    private int mmm = 0;
    protected View.OnClickListener aju = null;
    protected View.OnClickListener afO = null;
    private boolean afY = false;
    private long startPosition = -1;
    private f.b mmr = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ce(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dxo() && !d.this.alY && !d.this.lpN && d.this.afY) {
                if (!com.baidu.mcn.b.Zg().jg(d.this.mmp.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mmp.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mmp.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mmp.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jlu.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bWo = d.this.mmp.card_title;
                            aVar.bWp = d.this.mmp.button_title;
                            aVar.bWq = d.this.mmp.jump_url;
                            aVar.bWn = d.this.mmp.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.alZ;
                            aVar.bWr = d.this.cLn();
                            if (z2) {
                                d.this.jlu.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jlu.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jlu.isShowing()) {
                        d.this.jlu.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mmq != null) {
                d.this.mmq.cH(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fSy = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.Hb(d.this.mlB);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.giK.isPlaying()) {
                    d.this.giK.a(d.this.mms);
                }
                d.this.dxe();
                if (d.this.mmd) {
                    TiebaStatic.log(new ar("c13355").dR("tid", d.this.alZ).w("fid", d.this.mFid).ak("obj_type", d.this.alY ? 1 : 2).ak("obj_locate", d.this.lpN ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iUc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.giK.isPlaying()) {
                d.this.giK.pause();
                if (d.this.mlI == d.this.mlB) {
                    d.this.Hb(d.this.mlC);
                } else {
                    d.this.Hb(d.this.mlD);
                }
                d.this.Hc(R.id.video_pause);
            } else if (d.this.mlI == d.this.mlC || d.this.mlI == (d.this.mlC | 1)) {
                d.this.Hb(d.this.mlB);
                d.this.dxe();
                d.this.giK.a(d.this.mms);
                d.this.Hc(R.id.video_play);
            } else if (d.this.mlI == d.this.mlD || d.this.mlI == (d.this.mlD | 1)) {
                d.this.Hb(d.this.mlz);
                d.this.giK.a(d.this.mms);
                d.this.Hc(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.giK.isPlaying()) {
                if (d.this.mlI == d.this.mlz || d.this.mlI == d.this.mlA) {
                    d.this.Hb(d.this.mlB);
                    d.this.dxe();
                    return true;
                } else if (d.this.mlI == d.this.mlB) {
                    d.this.Hb(d.this.mlz);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mlI == d.this.mlC) {
                d.this.Hb(d.this.mlD);
                return true;
            } else if (d.this.mlI == (d.this.mlC | 1)) {
                d.this.Hb(d.this.mlD | 1);
                return true;
            } else if (d.this.mlI == d.this.mlD) {
                d.this.Hb(d.this.mlC);
                return true;
            } else if (d.this.mlI == (d.this.mlD | 1)) {
                d.this.Hb(d.this.mlC | 1);
                return true;
            } else {
                d.this.Hb(d.this.mly);
                d.this.startPlay();
                d.this.dxj();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.lME = 0;
            if (d.this.lpN) {
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
            if (d.this.alY && d.this.drH()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.lME) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.giK.isPlaying()) {
                                d.this.giK.pause();
                                d.this.Hb(d.this.mlH);
                            }
                            d.this.lME = 4;
                            d.this.mlJ = d.this.mlI;
                            d.this.mlI = d.this.mlG;
                            d.this.mmj = d.this.mlY.getMeasuredHeight();
                            d.this.mmn = d.this.mmg / d.this.mmj;
                            d.this.mmo = (int) (1.2f * d.this.mRootView.getWidth());
                            dh(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dh(rawX, rawY);
                        break;
                }
            } else if (d.this.mlI == d.this.mlz || d.this.mlI == d.this.mlB || d.this.mlI == d.this.mlC || d.this.mlI == d.this.mlD || d.this.mlI == d.this.mlG || d.this.mlI == (d.this.mlC | 1) || d.this.mlI == (d.this.mlD | 1)) {
                switch (d.this.lME) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.lME = 3;
                            d.this.mmh = d.this.giK.getCurrentPosition();
                            aS(f);
                        } else if (motionEvent.getX() < d.this.mlY.getWidth() / 2) {
                            d.this.lME = 2;
                            d.this.mlV.t(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.lME = 1;
                            d.this.mlV.s(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mlI != d.this.mlG) {
                            if ((d.this.mlI & 1) > 0) {
                                d.this.mlG |= 1;
                            } else {
                                d.this.mlG &= -2;
                            }
                            d.this.Hb(d.this.mlG);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mlV.s(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.drL();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mlV.t(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aS(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dh(int i, int i2) {
            if (d.this.mml != i2 || d.this.mmm != i) {
                d.this.mmk = d.this.mml - i2 > 0 || ((float) i2) < d.this.mmf / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mlY.getLayoutParams();
                if (i2 != d.this.mml) {
                    int i3 = d.this.mmj - i2;
                    int i4 = (int) (i3 * d.this.mmn);
                    if (i4 < d.this.mmo) {
                        i4 = d.this.mmo;
                        i3 = (int) (i4 / d.this.mmn);
                    }
                    if (i4 != d.this.mmo) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mlY.setLayoutParams(layoutParams);
                    }
                    d.this.mml = i2;
                    d.this.mlY.setTranslationY(d.this.mml);
                }
                if (i != d.this.mml) {
                    d.this.mmm = i;
                    d.this.mlY.setTranslationX(d.this.mmm + ((d.this.mmg - layoutParams.width) / 2.0f));
                }
                d.this.mlW.setAlpha((layoutParams.width - d.this.mmo) / (d.this.mmg - d.this.mmo));
                if (d.this.mlS.getVisibility() == 0) {
                    float f = d.this.mmf / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mlS.setAlpha(f2);
                }
            }
        }

        private void aS(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mmh -= 1000;
                z = true;
            } else {
                d.this.mmh += 1000;
                z = false;
            }
            int duration = d.this.giK.getDuration();
            if (d.this.mmh < 0) {
                d.this.mmh = 0;
            } else if (d.this.mmh > duration) {
                d.this.mmh = duration;
            }
            String str = au.stringForVideoTime(d.this.mmh) + " / " + au.stringForVideoTime(duration);
            if (d.this.mlV != null) {
                d.this.mlV.E(z, str);
            }
            d.this.mlQ.setCurrentDuration(d.this.mmh, false);
        }
    };
    private View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mlI == d.this.mlG) {
                if (d.this.lME == 4) {
                    d.this.dxm();
                    d.this.mml = 0;
                    d.this.mmm = 0;
                } else {
                    d.this.mlI = -1;
                    if (d.this.lME != 3) {
                        if (d.this.mlJ != -1) {
                            d.this.Hb(d.this.mlJ);
                            d.this.mlJ = -1;
                        } else if (d.this.giK.isPlaying()) {
                            d.this.Hb(d.this.mlz);
                        } else {
                            d.this.Hb(d.this.mlC);
                        }
                    } else {
                        d.this.mlQ.setCurrentDuration(d.this.mmh, true);
                        if (d.this.mmh <= d.this.giK.getDuration()) {
                            if (!d.this.giK.isPlaying()) {
                                d.this.giK.a(d.this.mms);
                            }
                            d.this.Hb(d.this.mlz);
                        }
                    }
                }
                if (d.this.mmd) {
                    String str = null;
                    if (d.this.lME != 1) {
                        if (d.this.lME != 2) {
                            if (d.this.lME == 3) {
                                str = "c13362";
                            }
                        } else {
                            str = "c13346";
                        }
                    } else {
                        str = "c13361";
                    }
                    if (!au.isEmpty(str)) {
                        TiebaStatic.log(new ar(str).dR("tid", d.this.alZ).w("fid", d.this.mFid));
                    }
                }
                d.this.lME = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mms = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dwW() {
            d.this.giK.dwS();
            d.this.dxd();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dwX() {
            d.this.Hb(d.this.mly);
            d.this.bNw();
        }
    };
    private final CustomMessageListener evs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
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
        void cH(int i, int i2);
    }

    public d(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.mmf = l.getEquipmentHeight(this.mContext);
            this.mmg = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void drJ() {
        int dimension;
        int i;
        int i2;
        this.mlR.as(this.alY, this.lpN);
        this.mlS.as(this.alY, this.lpN);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.alY) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.lpN) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.alS.setPadding(0, 0, i2, 0);
            this.mlP.setPadding(this.mlP.getPaddingLeft(), 0, i, 0);
            this.mlO.setPadding(dimension, 0, 0, 0);
        }
    }

    public void drI() {
        if (this.alY) {
            this.mlB = 104;
            this.mlC = 8290;
        } else {
            this.mlB = 232;
            this.mlC = 8418;
        }
        if (this.lpN) {
            this.mly |= 1024;
            this.mlz |= 1024;
            this.mlA |= 1024;
            this.mlB |= 1024;
            this.mlC |= 1024;
            this.mlD |= 1024;
            this.mlE |= 1024;
            this.mlF |= 1024;
            this.mlI |= 1024;
            return;
        }
        this.mly &= -1025;
        this.mlz &= -1025;
        this.mlA &= -1025;
        this.mlB &= -1025;
        this.mlC &= -1025;
        this.mlD &= -1025;
        this.mlE &= -1025;
        this.mlF &= -1025;
        this.mlI &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mlY = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mlY);
            }
            this.alV = new WeakReference<>(TbadkCoreApplication.getInst());
            this.alP = (TbImageView) this.mlY.findViewById(R.id.video_thumbnail);
            this.mlL = this.mlY.findViewById(R.id.black_mask);
            this.mlM = (TBLottieAnimationView) this.mlY.findViewById(R.id.video_loading);
            this.alQ = (ImageView) this.mlY.findViewById(R.id.video_play);
            this.mlN = (PercentSizeView) this.mlY.findViewById(R.id.video_media_controller_mask);
            this.alR = (ImageView) this.mlY.findViewById(R.id.video_pause);
            this.alS = (TextView) this.mlY.findViewById(R.id.video_play_count);
            this.alT = (TextView) this.mlY.findViewById(R.id.video_play_flag);
            this.alU = (TextView) this.mlY.findViewById(R.id.video_duration);
            this.mlO = (SwitchImageView) this.mlY.findViewById(R.id.video_mute);
            this.mlP = (SwitchImageView) this.mlY.findViewById(R.id.video_full_screen);
            this.mlQ = (OperableVideoMediaControllerView) this.mlY.findViewById(R.id.video_media_controller);
            this.mlR = (OperableVideoNetworkStateTipView) this.mlY.findViewById(R.id.video_network_state_tip);
            this.mlS = (OperableVideoShareView) this.mlY.findViewById(R.id.video_share_view);
            this.mlU = this.mlY.findViewById(R.id.video_back_btn_mask);
            this.mlT = (ImageView) this.mlY.findViewById(R.id.video_full_screen_back);
            this.mlV = (VideoGestureView) this.mlY.findViewById(R.id.video_gesture);
            this.mlX = (OperableVideoErrorView) this.mlY.findViewById(R.id.video_error_layout);
            this.mlS.setVideoContainer(this);
            this.mlM.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mlM.setVisibility(8);
                    d.this.alQ.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mlM.setAnimation(R.raw.lotti_video_loading);
            this.alQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.alQ.setOnClickListener(this);
            this.mlO.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
            this.mlO.setState(1);
            this.mlO.setOnClickListener(this);
            this.alP.bDR();
            this.alP.setDrawCorner(false);
            this.alP.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.j(this.mlL, R.color.CAM_X0607);
            this.mlQ.setOnSeekBarChangeListener(this.fSy);
            this.mlN.setHeightPercent(0.583f);
            this.mlN.setBackgroundResource(R.drawable.video_mask_bg);
            this.mlP.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
            this.mlP.setState(0);
            this.mlP.setOnClickListener(this);
            this.alR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.alR.setOnClickListener(this);
            this.mlT.setOnClickListener(this);
            this.giK = new TbCyberVideoView(this.mContext);
            this.giK.setTryUseViewInSet(true);
            dxd();
            this.mlR.setPlayViewOnClickListener(this);
            this.mlY.setOnClickListener(null);
            this.mlY.setOnTouchListener(this.fyo);
            this.mlS.setOnTouchListener(this.fyo);
            this.mlX.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iUc);
            Hb(this.mly);
            this.jlu = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dxd() {
        if (this.giK != null && this.giK.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mlY.addView(this.giK.getView(), 0);
            this.giK.getView().setLayoutParams(layoutParams);
            this.mlQ.setPlayer(this.giK);
            this.giK.setContinuePlayEnable(true);
            this.giK.setOnPreparedListener(this);
            this.giK.setOnCompletionListener(this);
            this.giK.setOnErrorListener(this);
            this.giK.setOnSurfaceDestroyedListener(this);
            this.giK.setOnInfoListener(this);
            this.giK.setVideoStatData(this.mmb);
            this.giK.setThreadDataForStatistic(this.mmc);
            this.giK.getMediaProgressObserver().a(this.mmr);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bx bxVar) {
        if (bxVar != null && bxVar.blU() != null) {
            this.startPosition = -1L;
            if (this.jlu != null) {
                this.jlu.reset();
            }
            if (!au.equals(this.mVideoUrl, bxVar.blU().video_url)) {
                stopPlay();
                this.alY = bxVar.blU().is_vertical.intValue() == 1;
                this.mVideoUrl = bxVar.blU().video_url;
                this.alZ = bxVar.getTid();
                this.ama = bxVar.blU().video_length.intValue();
                this.mma = bxVar.blU().video_duration.intValue();
                this.mFid = bxVar.getFid();
                this.mmp = bxVar.blU().mcn_ad_card;
                drI();
                drJ();
                Hb(this.mly);
                int intValue = bxVar.blU().video_duration.intValue() * 1000;
                this.mlQ.HT(intValue);
                this.mlQ.setPlayer(this.giK);
                this.alU.setText(au.stringForVideoTime(intValue));
                this.alS.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(bxVar.blU().play_count.intValue())));
                this.mlR.setVideoLength(bxVar.blU().video_length.intValue());
                this.mlR.setVideoDuration(bxVar.blU().video_duration.intValue());
                this.mlR.setTid(this.alZ);
                this.mmc = bxVar;
                this.giK.setThreadDataForStatistic(bxVar);
                this.alT.setVisibility(8);
                this.alP.setPlaceHolder(3);
                this.alP.startLoad(bxVar.blU().thumbnail_url, 10, false);
                this.mlS.setShareData(bxVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.giK != null) {
            this.mmb = oVar;
            this.giK.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ac(View.OnClickListener onClickListener) {
        this.afO = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void HV(int i) {
        this.giK.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiE = bdUniqueId;
    }

    public void dxe() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mlK);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mlK, this.mlj);
    }

    public void dxf() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mlK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        this.mlM.setAlpha(1.0f);
        this.mlM.setVisibility(0);
        this.alQ.setVisibility(8);
        if (this.mlM != null) {
            this.mlM.loop(true);
            this.mlM.setMinAndMaxFrame(14, 80);
            this.mlM.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drG() {
        if (this.mlI == this.mlA) {
            Hb(this.mlz);
        }
    }

    private void dxg() {
        Hb(this.mlA);
        this.mlQ.showProgress();
        if (this.mlM != null) {
            this.mlM.clearAnimation();
            this.mlM.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.drG();
                    if (!d.this.mlZ) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mlM.setVisibility(8);
                    d.this.alQ.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dxh() {
        return this.mlR != null && this.mlR.drQ();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aiD = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.evs);
            if (dxh()) {
                Hb(this.mlF);
                return;
            }
            this.mlZ = true;
            if (!this.giK.isPlaying()) {
                TbCyberVideoView Qh = TbVideoViewSet.dwV().Qh(this.mVideoUrl);
                if (Qh == null) {
                    this.giK.dwS();
                    if (!StringUtils.isNull(this.giK.getOriginUrl())) {
                        this.giK = new TbCyberVideoView(this.mContext);
                        this.giK.setTryUseViewInSet(true);
                    }
                    dxd();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.giK.setVideoDuration(this.mma);
                        this.giK.setVideoPath(this.mVideoUrl, this.alZ);
                        this.giK.setStageType(this.aiD);
                        bNw();
                        if (this.mmd) {
                            drO();
                        }
                    }
                } else {
                    if (this.giK == Qh) {
                        if (this.giK.getParent() == null || this.giK.getParent() != Qh.getParent()) {
                            this.giK.dwS();
                            dxd();
                        }
                    } else {
                        this.giK.dwS();
                        Qh.dwS();
                        this.giK = Qh;
                        this.giK.setTryUseViewInSet(true);
                        dxd();
                    }
                    this.giK.dwT();
                    onPrepared();
                    dxn();
                    if (this.mmd) {
                        drO();
                    }
                }
                if (this.mmd) {
                    TiebaStatic.log(new ar("c13357").dR("tid", this.alZ).w("fid", this.mFid).ak("obj_type", this.alY ? 1 : 2).ak("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).ak("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mlZ = false;
        if (this.mlM != null) {
            this.mlM.cancelAnimation();
        }
        this.giK.stop();
        this.giK.dwS();
        this.mlQ.aPs();
        Hb(this.mly);
        MessageManager.getInstance().unRegisterListener(this.evs);
    }

    private void dxi() {
        this.mlZ = false;
        if (this.mlM != null) {
            this.mlM.cancelAnimation();
        }
        this.giK.stop();
        this.mlQ.aPs();
        Hb(this.mly);
        MessageManager.getInstance().unRegisterListener(this.evs);
    }

    public void drO() {
        if (this.mmb != null) {
            o dwI = this.mmb.dwI();
            dwI.mLocate = this.mFrom;
            h.a(dwI.mkp, "", "1", dwI, this.giK.getPcdnState());
        }
    }

    public void Hb(int i) {
        dxf();
        if (this.mlI == this.mlG) {
            this.mlJ = i;
            return;
        }
        this.mlI = i;
        this.alP.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mlL.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mlM.clearAnimation();
        this.mlM.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mlM.cancelAnimation();
        } else {
            this.mlM.setAlpha(1.0f);
        }
        this.alQ.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.alR.setVisibility((i & 8) > 0 ? 0 : 8);
        this.alS.setVisibility((i & 16) > 0 ? 0 : 8);
        this.alU.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mlO.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mlP.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mlQ.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mlN.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mlQ.getVisibility() == 0) {
            this.mlQ.showProgress();
        }
        this.mlR.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mlS.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mlS.getVisibility() == 0) {
            this.mlS.setAlpha(1.0f);
        }
        this.mlT.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mlU.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mlV.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mlX.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Hc(id);
            if (id == R.id.video_mute) {
                dxk();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dxm();
            } else if (id == R.id.video_replay) {
                Hb(this.mly);
                startPlay();
                if (this.mmd) {
                    TiebaStatic.log(new ar("c13345").dR("tid", this.alZ).w("fid", this.mFid).ak("obj_type", this.alY ? 1 : 2).ak("obj_locate", this.lpN ? 1 : 2));
                }
                dxj();
            } else if (id == R.id.video_play) {
                if (this.mlI == this.mly) {
                    startPlay();
                } else {
                    Hb(this.mlB);
                    dxe();
                    this.giK.a(this.mms);
                }
                if (this.mmd) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.alZ).w("fid", this.mFid).ak("obj_type", this.alY ? 1 : 2).ak("obj_source", this.lpN ? 1 : 2).ak("obj_locate", 1));
                }
                dxj();
            } else if (id == R.id.video_pause) {
                Hb(this.mlC);
                dxf();
                this.giK.pause();
                if (this.mmd) {
                    TiebaStatic.log(new ar("c13344").dR("tid", this.alZ).w("fid", this.mFid).ak("obj_type", this.alY ? 1 : 2).ak("obj_source", this.lpN ? 1 : 2).ak("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                Hb(this.mly);
                startPlay();
            } else if (id == R.id.retry) {
                Hb(this.mly);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxj() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.aiE);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void drF() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.giK.setVolume(0.0f, 0.0f);
            this.mlO.setState(1);
            return;
        }
        this.giK.setVolume(1.0f, 1.0f);
        this.mlO.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxk() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.giK.setVolume(1.0f, 1.0f);
            ah.a(this.alV, true);
            this.mlO.setState(0);
        } else {
            this.giK.setVolume(0.0f, 0.0f);
            this.mlO.setState(1);
            ah.a(this.alV, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void ww(boolean z) {
        if (this.kGQ == null) {
            this.kGQ = new j((Activity) this.mContext);
        }
        if (z) {
            this.kGQ.start();
            this.kGQ.cM(true);
            return;
        }
        this.kGQ.stop();
        this.kGQ.cM(false);
    }

    public void dxl() {
        vF(true);
    }

    public void vF(boolean z) {
        if (this.mRootView != null && this.mlY != null && this.giK != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kGQ == null) {
                this.kGQ = new j((Activity) this.mContext);
            }
            if (this.lpN) {
                if (this.mlW.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mlW.getParent()).removeView(this.mlW);
                }
                if ((this.mlY.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lpN = false;
                    this.mme = true;
                    ((ViewGroup) this.mlY.getParent()).removeView(this.mlY);
                    ((ViewGroup) this.mRootView).addView(this.mlY);
                    this.mme = false;
                    k((Activity) this.mContext, this.lpN);
                }
                if (!this.alY && z) {
                    this.kGQ.SH();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.alY && z) {
                        this.kGQ.SH();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mlY.getLocationOnScreen(this.mmi);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.mme = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mlW == null) {
                                    this.mlW = new View(this.mContext);
                                    this.mlW.setClickable(true);
                                    this.mlW.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mlW.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mlW.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mlW.getParent()).removeView(this.mlW);
                                }
                                this.mlW.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mlW);
                                ((ViewGroup) childAt).addView(this.mlY);
                                this.mme = false;
                                this.lpN = true;
                                k((Activity) this.mContext, this.lpN);
                                if (this.jlu != null && this.jlu.isShowing()) {
                                    this.jlu.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mmd) {
                    TiebaStatic.log(new ar("c13360").dR("tid", this.alZ).w("fid", this.mFid).ak("obj_type", this.alY ? 1 : 2));
                }
            }
            drI();
            drJ();
            if (this.giK.isPlaying()) {
                Hb(this.mlz);
            } else {
                Hb(this.mlI);
            }
            this.mlP.dSM();
            wx(this.lpN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxm() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.alY) {
            dxl();
        } else if (this.mlI == this.mlG) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mlY.setScaleX(1.0f);
                    d.this.mlY.setScaleY(1.0f);
                    d.this.mlY.setTranslationX(0.0f);
                    d.this.mlY.setTranslationY(0.0f);
                    d.this.mlS.setScaleX(1.0f);
                    d.this.mlS.setScaleY(1.0f);
                    d.this.mlY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mmk) {
                        d.this.dxl();
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
            if (!this.mmk) {
                float width = this.mRootView.getWidth() / this.mlY.getWidth();
                float height = this.mRootView.getHeight() / this.mlY.getHeight();
                this.mlY.setPivotX(0.0f);
                this.mlY.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mlY, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mlY, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mlS, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mlS, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mlY, "TranslationX", this.mlY.getTranslationX(), this.mmi[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mlY, "TranslationY", this.mlY.getTranslationY(), this.mmi[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mlW, "alpha", this.mlW.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mlS, "alpha", this.mlS.getAlpha(), 0.0f);
            } else {
                float width2 = this.mmg / this.mlY.getWidth();
                float height2 = this.mmj / this.mlY.getHeight();
                this.mlY.setPivotX(0.0f);
                this.mlY.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mlY, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mlY, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mlS, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mlS, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mlY, "TranslationX", this.mlY.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mlY, "TranslationY", this.mlY.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mlS, "alpha", this.mlS.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mlJ != -1) {
                this.mlI = this.mlJ;
                this.mlJ = -1;
                if (this.mlI == this.mlH || this.mlI == this.mlB || this.mlI == this.mlz) {
                    this.giK.a(this.mms);
                    Hb(this.mlz);
                }
            }
        } else {
            dxl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.alY && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mlY != null) {
                    if (z) {
                        this.mlY.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mlY.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cZf();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mlY.setSystemUiVisibility(0);
            }
        }
    }

    private void dxn() {
        Hb(this.mlA);
        this.mlQ.showProgress();
        dxg();
    }

    protected void wx(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        drF();
        if (this.mlZ) {
            if (this.lpN && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.giK.a(this.mms);
        }
    }

    public void onCompletion() {
        Hb(this.mlE);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        Hb(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.mme) {
            if (this.mlI == this.mlC || (this.mlI == this.mlD && !this.giK.isPlaying())) {
                dxi();
                Hb(this.mlC);
            } else if (this.mlI == this.mlE) {
                dxi();
                Hb(this.mlE);
            } else {
                dxi();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dxn();
        }
        if (i == 701) {
            bNw();
            return false;
        } else if (i == 702) {
            dxn();
            return false;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dwp() {
        return this.mlY;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mlZ || this.giK.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.giK.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bST() {
    }

    protected void Hc(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lpN;
    }

    protected boolean drH() {
        return this.alY && this.lpN;
    }

    private void cZf() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mlY.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mlY.setSystemUiVisibility(4);
        } else {
            this.mlY.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean drL() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.giK.isPlaying() && !ah.bDt()) {
            this.giK.setVolume(1.0f, 1.0f);
            this.mlO.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean drM() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean rh(boolean z) {
        if (z) {
            this.mlM.cancelAnimation();
            if (this.mlI == this.mlz || this.mlI == this.mlA || this.mlI == this.mlB || this.mlI == this.mly) {
                stopPlay();
            }
            this.mlI |= 1;
            Hb(this.mlI);
        } else if (this.mlI == this.mly) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lpN;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dxb() {
        if (this.lpN) {
            dxm();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cLn() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dxo() {
        return this.mmp != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wy(boolean z) {
        this.afY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mmq = aVar;
    }
}
