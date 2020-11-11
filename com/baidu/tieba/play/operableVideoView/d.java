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
    protected TbCyberVideoView gjd;
    private com.baidu.mcn.c jkK;
    private j kGB;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected String mVideoUrl;
    protected View mlA;
    protected VideoGestureView mlB;
    private View mlC;
    private OperableVideoErrorView mlD;
    protected ViewGroup mlE;
    protected boolean mlF;
    protected int mlG;
    protected o mlH;
    protected bw mlI;
    private float mlL;
    private float mlM;
    private int mlN;
    private int mlP;
    private boolean mlQ;
    private float mlT;
    private int mlU;
    private McnAdInfo mlV;
    private a mlW;
    private View mlr;
    private TBLottieAnimationView mls;
    private PercentSizeView mlt;
    protected SwitchImageView mlu;
    protected SwitchImageView mlv;
    protected OperableVideoMediaControllerView mlw;
    protected OperableVideoNetworkStateTipView mlx;
    protected OperableVideoShareView mly;
    protected ImageView mlz;
    protected int mkP = 3000;
    protected final int mkQ = 1;
    protected final int mkR = 2;
    protected final int mkS = 4;
    protected final int mkT = 8;
    protected final int mkU = 16;
    protected final int mkV = 32;
    protected final int mkW = 64;
    protected final int mkX = 128;
    protected final int mkY = 256;
    protected final int mkZ = 512;
    protected final int mla = 1024;
    protected final int mlb = 2048;
    protected final int mlc = 4096;
    protected final int mld = 8192;
    protected int mle = 8211;
    protected int mlf = 0;
    protected int mlg = 4;
    protected int mlh = 232;
    protected int mli = 8416;
    protected int mlj = 0;
    protected int mlk = 513;
    protected int mll = 259;
    protected int mlm = 2048;
    protected int mln = 0;
    protected int STATE_ERROR = 4099;
    protected int mlo = this.mle;
    private int lMm = 0;
    private int mlp = -1;
    private Runnable mlq = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.GD(d.this.mlf);
        }
    };
    private WeakReference<Context> alP = null;
    protected boolean lpy = false;
    protected boolean mlJ = true;
    private boolean mlK = false;
    private int[] mlO = new int[2];
    private int mlR = 0;
    private int mlS = 0;
    protected View.OnClickListener ajp = null;
    protected View.OnClickListener afJ = null;
    private boolean afT = false;
    private long startPosition = -1;
    private f.b mlX = new f.b() { // from class: com.baidu.tieba.play.operableVideoView.d.3
        @Override // com.baidu.tieba.play.f.b
        public void ce(int i, int i2) {
            if (d.this.startPosition <= 0) {
                d.this.startPosition = i2;
            }
            if (d.this.dxO() && !d.this.alS && !d.this.lpy && d.this.afT) {
                if (!com.baidu.mcn.b.ZP().jm(d.this.mlV.jump_url)) {
                    boolean z = ((long) i2) >= d.this.mlV.ad_start_time.longValue() * 1000 && ((long) i2) < d.this.mlV.ad_end_time.longValue() * 1000;
                    boolean z2 = d.this.startPosition >= (d.this.mlV.ad_start_time.longValue() * 1000) + 1000;
                    if (z) {
                        if (!d.this.jkK.isShowing()) {
                            com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                            aVar.bXY = d.this.mlV.card_title;
                            aVar.bXZ = d.this.mlV.button_title;
                            aVar.bYa = d.this.mlV.jump_url;
                            aVar.bXX = d.this.mlV.pic_url;
                            aVar.fid = String.valueOf(d.this.mFid);
                            aVar.tid = d.this.alT;
                            aVar.bYb = d.this.cLH();
                            if (z2) {
                                d.this.jkK.b(aVar, (ViewGroup) d.this.mRootView);
                            } else {
                                d.this.jkK.a(aVar, (ViewGroup) d.this.mRootView);
                            }
                        }
                    } else if (d.this.jkK.isShowing()) {
                        d.this.jkK.dismiss();
                    }
                } else {
                    return;
                }
            }
            if (d.this.mlW != null) {
                d.this.mlW.cH(i, i2);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener fSR = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.d.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            d.this.GD(d.this.mlh);
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!d.this.gjd.isPlaying()) {
                    d.this.gjd.a(d.this.mlY);
                }
                d.this.dxE();
                if (d.this.mlJ) {
                    TiebaStatic.log(new aq("c13355").dR("tid", d.this.alT).w("fid", d.this.mFid).al("obj_type", d.this.alS ? 1 : 2).al("obj_locate", d.this.lpy ? 1 : 2));
                }
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iTq = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.d.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (d.this.gjd.isPlaying()) {
                d.this.gjd.pause();
                if (d.this.mlo == d.this.mlh) {
                    d.this.GD(d.this.mli);
                } else {
                    d.this.GD(d.this.mlj);
                }
                d.this.GE(R.id.video_pause);
            } else if (d.this.mlo == d.this.mli || d.this.mlo == (d.this.mli | 1)) {
                d.this.GD(d.this.mlh);
                d.this.dxE();
                d.this.gjd.a(d.this.mlY);
                d.this.GE(R.id.video_play);
            } else if (d.this.mlo == d.this.mlj || d.this.mlo == (d.this.mlj | 1)) {
                d.this.GD(d.this.mlf);
                d.this.gjd.a(d.this.mlY);
                d.this.GE(R.id.video_play);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.this.gjd.isPlaying()) {
                if (d.this.mlo == d.this.mlf || d.this.mlo == d.this.mlg) {
                    d.this.GD(d.this.mlh);
                    d.this.dxE();
                    return true;
                } else if (d.this.mlo == d.this.mlh) {
                    d.this.GD(d.this.mlf);
                    return true;
                } else {
                    return true;
                }
            } else if (d.this.mlo == d.this.mli) {
                d.this.GD(d.this.mlj);
                return true;
            } else if (d.this.mlo == (d.this.mli | 1)) {
                d.this.GD(d.this.mlj | 1);
                return true;
            } else if (d.this.mlo == d.this.mlj) {
                d.this.GD(d.this.mli);
                return true;
            } else if (d.this.mlo == (d.this.mlj | 1)) {
                d.this.GD(d.this.mli | 1);
                return true;
            } else {
                d.this.GD(d.this.mle);
                d.this.startPlay();
                d.this.dxJ();
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            d.this.lMm = 0;
            if (d.this.lpy) {
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
            if (d.this.alS && d.this.dsh()) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (d.this.lMm) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (d.this.gjd.isPlaying()) {
                                d.this.gjd.pause();
                                d.this.GD(d.this.mln);
                            }
                            d.this.lMm = 4;
                            d.this.mlp = d.this.mlo;
                            d.this.mlo = d.this.mlm;
                            d.this.mlP = d.this.mlE.getMeasuredHeight();
                            d.this.mlT = d.this.mlM / d.this.mlP;
                            d.this.mlU = (int) (1.2f * d.this.mRootView.getWidth());
                            dh(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        dh(rawX, rawY);
                        break;
                }
            } else if (d.this.mlo == d.this.mlf || d.this.mlo == d.this.mlh || d.this.mlo == d.this.mli || d.this.mlo == d.this.mlj || d.this.mlo == d.this.mlm || d.this.mlo == (d.this.mli | 1) || d.this.mlo == (d.this.mlj | 1)) {
                switch (d.this.lMm) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            d.this.lMm = 3;
                            d.this.mlN = d.this.gjd.getCurrentPosition();
                            aL(f);
                        } else if (motionEvent.getX() < d.this.mlE.getWidth() / 2) {
                            d.this.lMm = 2;
                            d.this.mlB.u(d.this.mContext, f2 > 0.0f);
                        } else {
                            d.this.lMm = 1;
                            d.this.mlB.t(d.this.mContext, f2 > 0.0f);
                        }
                        if (d.this.mlo != d.this.mlm) {
                            if ((d.this.mlo & 1) > 0) {
                                d.this.mlm |= 1;
                            } else {
                                d.this.mlm &= -2;
                            }
                            d.this.GD(d.this.mlm);
                            break;
                        }
                        break;
                    case 1:
                        d.this.mlB.t(d.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            d.this.dsl();
                            break;
                        }
                        break;
                    case 2:
                        d.this.mlB.u(d.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aL(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void dh(int i, int i2) {
            if (d.this.mlR != i2 || d.this.mlS != i) {
                d.this.mlQ = d.this.mlR - i2 > 0 || ((float) i2) < d.this.mlL / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.mlE.getLayoutParams();
                if (i2 != d.this.mlR) {
                    int i3 = d.this.mlP - i2;
                    int i4 = (int) (i3 * d.this.mlT);
                    if (i4 < d.this.mlU) {
                        i4 = d.this.mlU;
                        i3 = (int) (i4 / d.this.mlT);
                    }
                    if (i4 != d.this.mlU) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        d.this.mlE.setLayoutParams(layoutParams);
                    }
                    d.this.mlR = i2;
                    d.this.mlE.setTranslationY(d.this.mlR);
                }
                if (i != d.this.mlR) {
                    d.this.mlS = i;
                    d.this.mlE.setTranslationX(d.this.mlS + ((d.this.mlM - layoutParams.width) / 2.0f));
                }
                d.this.mlC.setAlpha((layoutParams.width - d.this.mlU) / (d.this.mlM - d.this.mlU));
                if (d.this.mly.getVisibility() == 0) {
                    float f = d.this.mlL / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    d.this.mly.setAlpha(f2);
                }
            }
        }

        private void aL(float f) {
            boolean z;
            if (f > 0.0f) {
                d.this.mlN -= 1000;
                z = true;
            } else {
                d.this.mlN += 1000;
                z = false;
            }
            int duration = d.this.gjd.getDuration();
            if (d.this.mlN < 0) {
                d.this.mlN = 0;
            } else if (d.this.mlN > duration) {
                d.this.mlN = duration;
            }
            String str = at.stringForVideoTime(d.this.mlN) + " / " + at.stringForVideoTime(duration);
            if (d.this.mlB != null) {
                d.this.mlB.D(z, str);
            }
            d.this.mlw.setCurrentDuration(d.this.mlN, false);
        }
    };
    private View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.d.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && d.this.mlo == d.this.mlm) {
                if (d.this.lMm == 4) {
                    d.this.dxM();
                    d.this.mlR = 0;
                    d.this.mlS = 0;
                } else {
                    d.this.mlo = -1;
                    if (d.this.lMm != 3) {
                        if (d.this.mlp != -1) {
                            d.this.GD(d.this.mlp);
                            d.this.mlp = -1;
                        } else if (d.this.gjd.isPlaying()) {
                            d.this.GD(d.this.mlf);
                        } else {
                            d.this.GD(d.this.mli);
                        }
                    } else {
                        d.this.mlw.setCurrentDuration(d.this.mlN, true);
                        if (d.this.mlN <= d.this.gjd.getDuration()) {
                            if (!d.this.gjd.isPlaying()) {
                                d.this.gjd.a(d.this.mlY);
                            }
                            d.this.GD(d.this.mlf);
                        }
                    }
                }
                if (d.this.mlJ) {
                    String str = null;
                    if (d.this.lMm != 1) {
                        if (d.this.lMm != 2) {
                            if (d.this.lMm == 3) {
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
                d.this.lMm = 0;
                return true;
            }
            return d.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private TbVideoViewSet.a mlY = new TbVideoViewSet.a() { // from class: com.baidu.tieba.play.operableVideoView.d.10
        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dxw() {
            d.this.gjd.dxs();
            d.this.dxD();
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.a
        public void dxx() {
            d.this.GD(d.this.mle);
            d.this.bOd();
        }
    };
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.operableVideoView.d.2
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
            this.mlL = l.getEquipmentHeight(this.mContext);
            this.mlM = l.getEquipmentWidth(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return R.layout.operable_video_container;
    }

    public void dsj() {
        int dimension;
        int i;
        int i2;
        this.mlx.av(this.alS, this.lpy);
        this.mly.av(this.alS, this.lpy);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.alS) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            } else if (this.lpy) {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds78);
                i = dimension;
                i2 = dimension;
            } else {
                dimension = (int) this.mContext.getResources().getDimension(R.dimen.tbds44);
                i = dimension;
                i2 = dimension;
            }
            this.alM.setPadding(0, 0, i2, 0);
            this.mlv.setPadding(this.mlv.getPaddingLeft(), 0, i, 0);
            this.mlu.setPadding(dimension, 0, 0, 0);
        }
    }

    public void dsi() {
        if (this.alS) {
            this.mlh = 104;
            this.mli = 8290;
        } else {
            this.mlh = 232;
            this.mli = 8418;
        }
        if (this.lpy) {
            this.mle |= 1024;
            this.mlf |= 1024;
            this.mlg |= 1024;
            this.mlh |= 1024;
            this.mli |= 1024;
            this.mlj |= 1024;
            this.mlk |= 1024;
            this.mll |= 1024;
            this.mlo |= 1024;
            return;
        }
        this.mle &= -1025;
        this.mlf &= -1025;
        this.mlg &= -1025;
        this.mlh &= -1025;
        this.mli &= -1025;
        this.mlj &= -1025;
        this.mlk &= -1025;
        this.mll &= -1025;
        this.mlo &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.mlE = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.mlE);
            }
            this.alP = new WeakReference<>(TbadkCoreApplication.getInst());
            this.alJ = (TbImageView) this.mlE.findViewById(R.id.video_thumbnail);
            this.mlr = this.mlE.findViewById(R.id.black_mask);
            this.mls = (TBLottieAnimationView) this.mlE.findViewById(R.id.video_loading);
            this.alK = (ImageView) this.mlE.findViewById(R.id.video_play);
            this.mlt = (PercentSizeView) this.mlE.findViewById(R.id.video_media_controller_mask);
            this.alL = (ImageView) this.mlE.findViewById(R.id.video_pause);
            this.alM = (TextView) this.mlE.findViewById(R.id.video_play_count);
            this.alN = (TextView) this.mlE.findViewById(R.id.video_play_flag);
            this.alO = (TextView) this.mlE.findViewById(R.id.video_duration);
            this.mlu = (SwitchImageView) this.mlE.findViewById(R.id.video_mute);
            this.mlv = (SwitchImageView) this.mlE.findViewById(R.id.video_full_screen);
            this.mlw = (OperableVideoMediaControllerView) this.mlE.findViewById(R.id.video_media_controller);
            this.mlx = (OperableVideoNetworkStateTipView) this.mlE.findViewById(R.id.video_network_state_tip);
            this.mly = (OperableVideoShareView) this.mlE.findViewById(R.id.video_share_view);
            this.mlA = this.mlE.findViewById(R.id.video_back_btn_mask);
            this.mlz = (ImageView) this.mlE.findViewById(R.id.video_full_screen_back);
            this.mlB = (VideoGestureView) this.mlE.findViewById(R.id.video_gesture);
            this.mlD = (OperableVideoErrorView) this.mlE.findViewById(R.id.video_error_layout);
            this.mly.setVideoContainer(this);
            this.mls.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mls.setVisibility(8);
                    d.this.alK.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.mls.setAnimation(R.raw.lotti_video_loading);
            SvgManager.brn().a(this.alK, R.drawable.ic_icon_pure_video_play44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alK.setOnClickListener(this);
            this.mlu.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_sound24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_silent24_svg, R.color.cp_cont_a));
            this.mlu.setState(1);
            this.mlu.setOnClickListener(this);
            this.alJ.bEy();
            this.alJ.setDrawCorner(false);
            this.alJ.setPlaceHolder(3);
            com.baidu.tbadk.a.b.a.h(this.mlr, R.color.cp_mask_b_alpha50);
            this.mlw.setOnSeekBarChangeListener(this.fSR);
            this.mlt.setHeightPercent(0.583f);
            this.mlt.setBackgroundResource(R.drawable.video_mask_bg);
            this.mlv.setSvgStateImage(new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.cp_cont_a), new com.baidu.tbadk.core.util.d.c(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.cp_cont_a));
            this.mlv.setState(0);
            this.mlv.setOnClickListener(this);
            SvgManager.brn().a(this.alL, R.drawable.ic_icon_pure_video_pause44_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.alL.setOnClickListener(this);
            this.mlz.setOnClickListener(this);
            this.gjd = new TbCyberVideoView(this.mContext);
            this.gjd.setTryUseViewInSet(true);
            dxD();
            this.mlx.setPlayViewOnClickListener(this);
            this.mlE.setOnClickListener(null);
            this.mlE.setOnTouchListener(this.fzb);
            this.mly.setOnTouchListener(this.fzb);
            this.mlD.setOutOnClickListener(this);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iTq);
            GD(this.mle);
            this.jkK = new com.baidu.mcn.c(this.mContext);
        }
    }

    public void dxD() {
        if (this.gjd != null && this.gjd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mlE.addView(this.gjd.getView(), 0);
            this.gjd.getView().setLayoutParams(layoutParams);
            this.mlw.setPlayer(this.gjd);
            this.gjd.setContinuePlayEnable(true);
            this.gjd.setOnPreparedListener(this);
            this.gjd.setOnCompletionListener(this);
            this.gjd.setOnErrorListener(this);
            this.gjd.setOnSurfaceDestroyedListener(this);
            this.gjd.setOnInfoListener(this);
            this.gjd.setVideoStatData(this.mlH);
            this.gjd.setThreadDataForStatistic(this.mlI);
            this.gjd.getMediaProgressObserver().a(this.mlX);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bmS() != null) {
            this.startPosition = -1L;
            if (this.jkK != null) {
                this.jkK.reset();
            }
            if (!at.equals(this.mVideoUrl, bwVar.bmS().video_url)) {
                stopPlay();
                this.alS = bwVar.bmS().is_vertical.intValue() == 1;
                this.mVideoUrl = bwVar.bmS().video_url;
                this.alT = bwVar.getTid();
                this.alU = bwVar.bmS().video_length.intValue();
                this.mlG = bwVar.bmS().video_duration.intValue();
                this.mFid = bwVar.getFid();
                this.mlV = bwVar.bmS().mcn_ad_card;
                dsi();
                dsj();
                GD(this.mle);
                int intValue = bwVar.bmS().video_duration.intValue() * 1000;
                this.mlw.Hv(intValue);
                this.mlw.setPlayer(this.gjd);
                this.alO.setText(at.stringForVideoTime(intValue));
                this.alM.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), at.numFormatOverWan(bwVar.bmS().play_count.intValue())));
                this.mlx.setVideoLength(bwVar.bmS().video_length.intValue());
                this.mlx.setVideoDuration(bwVar.bmS().video_duration.intValue());
                this.mlx.setTid(this.alT);
                this.mlI = bwVar;
                this.gjd.setThreadDataForStatistic(bwVar);
                this.alN.setVisibility(8);
                this.alJ.setPlaceHolder(3);
                this.alJ.startLoad(bwVar.bmS().thumbnail_url, 10, false);
                this.mly.setShareData(bwVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(o oVar) {
        if (this.gjd != null) {
            this.mlH = oVar;
            this.gjd.setVideoStatData(oVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void ad(View.OnClickListener onClickListener) {
        this.afJ = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void Hx(int i) {
        this.gjd.getRenderView().setDisplayMode(i);
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiz = bdUniqueId;
    }

    public void dxE() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mlq);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mlq, this.mkP);
    }

    public void dxF() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mlq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOd() {
        this.mls.setAlpha(1.0f);
        this.mls.setVisibility(0);
        this.alK.setVisibility(8);
        if (this.mls != null) {
            this.mls.loop(true);
            this.mls.setMinAndMaxFrame(14, 80);
            this.mls.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dsg() {
        if (this.mlo == this.mlg) {
            GD(this.mlf);
        }
    }

    private void dxG() {
        GD(this.mlg);
        this.mlw.showProgress();
        if (this.mls != null) {
            this.mls.clearAnimation();
            this.mls.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.dsg();
                    if (!d.this.mlF) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    d.this.mls.setVisibility(8);
                    d.this.alK.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public boolean dxH() {
        return this.mlx != null && this.mlx.dsq();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setStageType(String str) {
        this.aiy = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (!StringUtils.isNull(this.mVideoUrl)) {
            MessageManager.getInstance().registerListener(this.exb);
            if (dxH()) {
                GD(this.mll);
                return;
            }
            this.mlF = true;
            if (!this.gjd.isPlaying()) {
                TbCyberVideoView QM = TbVideoViewSet.dxv().QM(this.mVideoUrl);
                if (QM == null) {
                    this.gjd.dxs();
                    if (!StringUtils.isNull(this.gjd.getOriginUrl())) {
                        this.gjd = new TbCyberVideoView(this.mContext);
                        this.gjd.setTryUseViewInSet(true);
                    }
                    dxD();
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.gjd.setVideoDuration(this.mlG);
                        this.gjd.setVideoPath(this.mVideoUrl, this.alT);
                        this.gjd.setStageType(this.aiy);
                        bOd();
                        if (this.mlJ) {
                            dso();
                        }
                    }
                } else {
                    if (this.gjd == QM) {
                        if (this.gjd.getParent() == null || this.gjd.getParent() != QM.getParent()) {
                            this.gjd.dxs();
                            dxD();
                        }
                    } else {
                        this.gjd.dxs();
                        QM.dxs();
                        this.gjd = QM;
                        this.gjd.setTryUseViewInSet(true);
                        dxD();
                    }
                    this.gjd.dxt();
                    onPrepared();
                    dxN();
                    if (this.mlJ) {
                        dso();
                    }
                }
                if (this.mlJ) {
                    TiebaStatic.log(new aq("c13357").dR("tid", this.alT).w("fid", this.mFid).al("obj_type", this.alS ? 1 : 2).al("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).al("obj_locate", 1));
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.mlF = false;
        if (this.mls != null) {
            this.mls.cancelAnimation();
        }
        this.gjd.stop();
        this.gjd.dxs();
        this.mlw.aQa();
        GD(this.mle);
        MessageManager.getInstance().unRegisterListener(this.exb);
    }

    private void dxI() {
        this.mlF = false;
        if (this.mls != null) {
            this.mls.cancelAnimation();
        }
        this.gjd.stop();
        this.mlw.aQa();
        GD(this.mle);
        MessageManager.getInstance().unRegisterListener(this.exb);
    }

    public void dso() {
        if (this.mlH != null) {
            o dxi = this.mlH.dxi();
            dxi.mLocate = this.mFrom;
            h.a(dxi.mjW, "", "1", dxi, this.gjd.getPcdnState());
        }
    }

    public void GD(int i) {
        dxF();
        if (this.mlo == this.mlm) {
            this.mlp = i;
            return;
        }
        this.mlo = i;
        this.alJ.setVisibility((i & 1) > 0 ? 0 : 8);
        this.mlr.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.mls.clearAnimation();
        this.mls.setVisibility(z ? 0 : 8);
        if (!z) {
            this.mls.cancelAnimation();
        } else {
            this.mls.setAlpha(1.0f);
        }
        this.alK.setVisibility((i & 8192) > 0 ? 0 : 8);
        this.alL.setVisibility((i & 8) > 0 ? 0 : 8);
        this.alM.setVisibility((i & 16) > 0 ? 0 : 8);
        this.alO.setVisibility((i & 16) > 0 ? 0 : 8);
        this.mlu.setVisibility((i & 32) > 0 ? 0 : 8);
        this.mlv.setVisibility((i & 64) > 0 ? 0 : 8);
        this.mlw.setVisibility((i & 128) > 0 ? 0 : 8);
        this.mlt.setVisibility((i & 128) > 0 ? 0 : 8);
        if (this.mlw.getVisibility() == 0) {
            this.mlw.showProgress();
        }
        this.mlx.setVisibility((i & 256) > 0 ? 0 : 8);
        this.mly.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.mly.getVisibility() == 0) {
            this.mly.setAlpha(1.0f);
        }
        this.mlz.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mlA.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.mlB.setVisibility((i & 2048) > 0 ? 0 : 8);
        this.mlD.setVisibility((i & 4096) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            GE(id);
            if (id == R.id.video_mute) {
                dxK();
            } else if (id == R.id.video_full_screen || id == R.id.video_full_screen_back) {
                dxM();
            } else if (id == R.id.video_replay) {
                GD(this.mle);
                startPlay();
                if (this.mlJ) {
                    TiebaStatic.log(new aq("c13345").dR("tid", this.alT).w("fid", this.mFid).al("obj_type", this.alS ? 1 : 2).al("obj_locate", this.lpy ? 1 : 2));
                }
                dxJ();
            } else if (id == R.id.video_play) {
                if (this.mlo == this.mle) {
                    startPlay();
                } else {
                    GD(this.mlh);
                    dxE();
                    this.gjd.a(this.mlY);
                }
                if (this.mlJ) {
                    TiebaStatic.log(new aq("c13344").dR("tid", this.alT).w("fid", this.mFid).al("obj_type", this.alS ? 1 : 2).al("obj_source", this.lpy ? 1 : 2).al("obj_locate", 1));
                }
                dxJ();
            } else if (id == R.id.video_pause) {
                GD(this.mli);
                dxF();
                this.gjd.pause();
                if (this.mlJ) {
                    TiebaStatic.log(new aq("c13344").dR("tid", this.alT).w("fid", this.mFid).al("obj_type", this.alS ? 1 : 2).al("obj_source", this.lpy ? 1 : 2).al("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                GD(this.mle);
                startPlay();
            } else if (id == R.id.retry) {
                GD(this.mle);
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxJ() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.mVideoUrl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.aiz);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    protected void dsf() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.gjd.setVolume(0.0f, 0.0f);
            this.mlu.setState(1);
            return;
        }
        this.gjd.setVolume(1.0f, 1.0f);
        this.mlu.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dxK() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.gjd.setVolume(1.0f, 1.0f);
            ai.a(this.alP, true);
            this.mlu.setState(0);
        } else {
            this.gjd.setVolume(0.0f, 0.0f);
            this.mlu.setState(1);
            ai.a(this.alP, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    public void wt(boolean z) {
        if (this.kGB == null) {
            this.kGB = new j((Activity) this.mContext);
        }
        if (z) {
            this.kGB.start();
            this.kGB.cK(true);
            return;
        }
        this.kGB.stop();
        this.kGB.cK(false);
    }

    public void dxL() {
        vC(true);
    }

    public void vC(boolean z) {
        if (this.mRootView != null && this.mlE != null && this.gjd != null) {
            if (this.mContext != null) {
                l.hideSoftKeyPad(this.mContext, this.mRootView);
            }
            if (this.kGB == null) {
                this.kGB = new j((Activity) this.mContext);
            }
            if (this.lpy) {
                if (this.mlC.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mlC.getParent()).removeView(this.mlC);
                }
                if ((this.mlE.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.lpy = false;
                    this.mlK = true;
                    ((ViewGroup) this.mlE.getParent()).removeView(this.mlE);
                    ((ViewGroup) this.mRootView).addView(this.mlE);
                    this.mlK = false;
                    k((Activity) this.mContext, this.lpy);
                }
                if (!this.alS && z) {
                    this.kGB.Tq();
                }
            } else {
                if (this.mContext != null) {
                    if (!this.alS && z) {
                        this.kGB.Tq();
                    }
                    if (this.mContext instanceof Activity) {
                        this.mlE.getLocationOnScreen(this.mlO);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.mlK = true;
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.mlC == null) {
                                    this.mlC = new View(this.mContext);
                                    this.mlC.setClickable(true);
                                    this.mlC.setBackgroundColor(ap.getColor(R.color.black_alpha100));
                                    this.mlC.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.mlC.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.mlC.getParent()).removeView(this.mlC);
                                }
                                this.mlC.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.mlC);
                                ((ViewGroup) childAt).addView(this.mlE);
                                this.mlK = false;
                                this.lpy = true;
                                k((Activity) this.mContext, this.lpy);
                                if (this.jkK != null && this.jkK.isShowing()) {
                                    this.jkK.dismiss();
                                }
                            }
                        }
                    }
                }
                if (this.mlJ) {
                    TiebaStatic.log(new aq("c13360").dR("tid", this.alT).w("fid", this.mFid).al("obj_type", this.alS ? 1 : 2));
                }
            }
            dsi();
            dsj();
            if (this.gjd.isPlaying()) {
                GD(this.mlf);
            } else {
                GD(this.mlo);
            }
            this.mlv.dSN();
            wu(this.lpy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxM() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.alS) {
            dxL();
        } else if (this.mlo == this.mlm) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.d.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.mlE.setScaleX(1.0f);
                    d.this.mlE.setScaleY(1.0f);
                    d.this.mlE.setTranslationX(0.0f);
                    d.this.mlE.setTranslationY(0.0f);
                    d.this.mly.setScaleX(1.0f);
                    d.this.mly.setScaleY(1.0f);
                    d.this.mlE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!d.this.mlQ) {
                        d.this.dxL();
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
            if (!this.mlQ) {
                float width = this.mRootView.getWidth() / this.mlE.getWidth();
                float height = this.mRootView.getHeight() / this.mlE.getHeight();
                this.mlE.setPivotX(0.0f);
                this.mlE.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mlE, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.mlE, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.mly, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.mly, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.mlE, "TranslationX", this.mlE.getTranslationX(), this.mlO[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.mlE, "TranslationY", this.mlE.getTranslationY(), this.mlO[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.mlC, "alpha", this.mlC.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mly, "alpha", this.mly.getAlpha(), 0.0f);
            } else {
                float width2 = this.mlM / this.mlE.getWidth();
                float height2 = this.mlP / this.mlE.getHeight();
                this.mlE.setPivotX(0.0f);
                this.mlE.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.mlE, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.mlE, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.mly, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.mly, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.mlE, "TranslationX", this.mlE.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.mlE, "TranslationY", this.mlE.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.mly, "alpha", this.mly.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.mlp != -1) {
                this.mlo = this.mlp;
                this.mlp = -1;
                if (this.mlo == this.mln || this.mlo == this.mlh || this.mlo == this.mlf) {
                    this.gjd.a(this.mlY);
                    GD(this.mlf);
                }
            }
        } else {
            dxL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (this.alS && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                if (this.mlE != null) {
                    if (z) {
                        this.mlE.setPadding(0, l.getStatusBarHeight((Activity) this.mContext), 0, 0);
                    } else {
                        this.mlE.setPadding(0, 0, 0, 0);
                    }
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                cZJ();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.mlE.setSystemUiVisibility(0);
            }
        }
    }

    private void dxN() {
        GD(this.mlg);
        this.mlw.showProgress();
        dxG();
    }

    protected void wu(boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        dsf();
        if (this.mlF) {
            if (this.lpy && (this.mContext instanceof Activity)) {
                k((Activity) this.mContext, true);
            }
            this.gjd.a(this.mlY);
        }
    }

    public void onCompletion() {
        GD(this.mlk);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        GD(this.STATE_ERROR);
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.mlK) {
            if (this.mlo == this.mli || (this.mlo == this.mlj && !this.gjd.isPlaying())) {
                dxI();
                GD(this.mli);
            } else if (this.mlo == this.mlk) {
                dxI();
                GD(this.mlk);
            } else {
                dxI();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            dxN();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View dwP() {
        return this.mlE;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.mlF || this.gjd.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.gjd.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTA() {
    }

    protected void GE(int i) {
    }

    protected boolean ac(MotionEvent motionEvent) {
        return this.lpy;
    }

    protected boolean dsh() {
        return this.alS && this.lpy;
    }

    private void cZJ() {
        if (Build.VERSION.SDK_INT < 16) {
            this.mlE.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.mlE.setSystemUiVisibility(4);
        } else {
            this.mlE.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dsl() {
        if (TbSingleton.getInstance().isVideoCardMute() && this.gjd.isPlaying() && !ai.bEa()) {
            this.gjd.setVolume(1.0f, 1.0f);
            this.mlu.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
        return false;
    }

    public boolean dsm() {
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean re(boolean z) {
        if (z) {
            this.mls.cancelAnimation();
            if (this.mlo == this.mlf || this.mlo == this.mlg || this.mlo == this.mlh || this.mlo == this.mle) {
                stopPlay();
            }
            this.mlo |= 1;
            GD(this.mlo);
        } else if (this.mlo == this.mle) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.lpy;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean dxB() {
        if (this.lpy) {
            dxM();
            return true;
        }
        return false;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    protected int cLH() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dxO() {
        return this.mlV != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wv(boolean z) {
        this.afT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.mlW = aVar;
    }
}
