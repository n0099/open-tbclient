package com.baidu.tieba.play.operableVideoView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.k;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.SwitchImageView;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.play.operableVideoView.a {
    protected BdUniqueId Zq;
    private String bNk;
    private o cVs;
    protected String ctx;
    protected QuickVideoView dbg;
    protected k ehR;
    private TextView ejy;
    private TextView ejz;
    private com.baidu.mcn.c fxf;
    protected TbImageView gIj;
    private View hZD;
    private View hZE;
    private TBLottieAnimationView hZF;
    private ImageView hZG;
    private View hZH;
    private TextView hZI;
    protected SwitchImageView hZJ;
    private SwitchImageView hZK;
    private OperableVideoMediaControllerView hZL;
    private OperableVideoNetworkStateTipView hZM;
    private OperableVideoShareView hZN;
    private ImageView hZO;
    private VideoGestureView hZP;
    private View hZQ;
    protected ViewGroup hZR;
    protected boolean hZS;
    protected boolean hZT;
    protected long hZU;
    protected long hZV;
    private n hZW;
    private float hZX;
    private float hZY;
    private int hZZ;
    private int iab;
    private boolean iac;
    private float iaf;
    private int iag;
    private McnAdInfo iah;
    private a iai;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int hZp = 3000;
    protected int hZq = 103;
    protected int hZr = 0;
    protected int hZs = 4;
    protected int hZt = 904;
    protected int hZu = 902;
    protected int hZv = 2066;
    protected int hZw = 1027;
    protected int hZx = 12288;
    protected int hZy = 0;
    protected int hZz = this.hZq;
    private int hZA = 0;
    private int hZB = -1;
    private Runnable hZC = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xs(c.this.hZr);
        }
    };
    private WeakReference<Context> bty = null;
    private boolean hlZ = false;
    private int[] iaa = new int[2];
    private int iad = 0;
    private int iae = 0;
    protected View.OnClickListener bNt = null;
    private boolean XA = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cNV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xs(c.this.hZt);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dbg.isPlaying()) {
                    c.this.dbg.start();
                }
                c.this.bUc();
                TiebaStatic.log(new am("c13355").bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZT ? 1 : 2).T("obj_locate", c.this.hlZ ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iaj = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dbg.isPlaying()) {
                c.this.dbg.pause();
                c.this.xs(c.this.hZu);
            } else if (c.this.hZz == c.this.hZu || c.this.hZz == (c.this.hZu | 1)) {
                c.this.dbg.start();
                c.this.xs(c.this.hZt);
                c.this.bUc();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.hZz == c.this.hZr || c.this.hZz == c.this.hZs) {
                c.this.xs(c.this.hZt);
                c.this.bUc();
            } else if (c.this.hZz == c.this.hZt) {
                c.this.xs(c.this.hZr);
            } else if (c.this.hZz == c.this.hZu) {
                c.this.xs(c.this.hZt);
                c.this.bUc();
                c.this.dbg.start();
                TiebaStatic.log(new am("c13344").bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZT ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hlZ ? 1 : 2).T("obj_locate", 1));
                c.this.bUf();
            } else {
                c.this.xs(c.this.hZq);
                c.this.startPlay();
                c.this.bUf();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.hZA = 0;
            if (c.this.hlZ) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hlZ) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.hZT) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.hZA) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dbg.isPlaying()) {
                                c.this.dbg.pause();
                                c.this.xs(c.this.hZy);
                            }
                            c.this.hZA = 4;
                            c.this.hZB = c.this.hZz;
                            c.this.hZz = c.this.hZx;
                            c.this.iab = c.this.hZR.getMeasuredHeight();
                            c.this.iaf = c.this.hZY / c.this.iab;
                            c.this.iag = (int) (1.2f * c.this.mRootView.getWidth());
                            bZ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        bZ(rawX, rawY);
                        break;
                }
            } else if (c.this.hZz == c.this.hZr || c.this.hZz == c.this.hZt || c.this.hZz == c.this.hZu || c.this.hZz == c.this.hZx) {
                switch (c.this.hZA) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.hZA = 3;
                            c.this.hZZ = c.this.dbg.getCurrentPosition();
                            aK(f);
                        } else if (motionEvent.getX() < c.this.hZX / 2.0f) {
                            c.this.hZA = 2;
                            c.this.hZP.n(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.hZA = 1;
                            c.this.hZP.m(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.hZz != c.this.hZx) {
                            c.this.xs(c.this.hZx);
                            break;
                        }
                        break;
                    case 1:
                        c.this.hZP.m(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.bTX();
                            break;
                        }
                        break;
                    case 2:
                        c.this.hZP.n(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aK(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void bZ(int i, int i2) {
            if (c.this.iad != i2 || c.this.iae != i) {
                c.this.iac = c.this.iad - i2 > 0 || ((float) i2) < c.this.hZX / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.hZR.getLayoutParams();
                if (i2 != c.this.iad) {
                    int i3 = c.this.iab - i2;
                    int i4 = (int) (i3 * c.this.iaf);
                    if (i4 < c.this.iag) {
                        i4 = c.this.iag;
                        i3 = (int) (i4 / c.this.iaf);
                    }
                    if (i4 != c.this.iag) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.hZR.setLayoutParams(layoutParams);
                    }
                    c.this.iad = i2;
                    c.this.hZR.setTranslationY(c.this.iad);
                }
                if (i != c.this.iad) {
                    c.this.iae = i;
                    c.this.hZR.setTranslationX(c.this.iae + ((c.this.hZY - layoutParams.width) / 2.0f));
                }
                c.this.hZQ.setAlpha((layoutParams.width - c.this.iag) / (c.this.hZY - c.this.iag));
                if (c.this.hZN.getVisibility() == 0) {
                    float f = c.this.hZX / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.hZN.setAlpha(f2);
                }
            }
        }

        private void aK(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.hZZ += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.hZZ += 1000;
                z = false;
            }
            int duration = c.this.dbg.getDuration();
            if (c.this.hZZ < 0) {
                c.this.hZZ = 0;
            } else if (c.this.hZZ > duration) {
                c.this.hZZ = duration;
            }
            String str = ap.hz(c.this.hZZ) + "/" + ap.hz(duration);
            if (c.this.hZP != null) {
                c.this.hZP.x(z, str);
            }
            c.this.hZL.setCurrentDuration(c.this.hZZ, false);
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.hZz == c.this.hZx) {
                if (c.this.hZA == 4) {
                    c.this.bUj();
                    c.this.iad = 0;
                    c.this.iae = 0;
                } else {
                    c.this.hZz = -1;
                    if (c.this.hZA != 3) {
                        if (c.this.hZB != -1) {
                            c.this.xs(c.this.hZB);
                            c.this.hZB = -1;
                        } else if (c.this.dbg.isPlaying()) {
                            c.this.xs(c.this.hZr);
                        } else {
                            c.this.xs(c.this.hZu);
                        }
                    } else {
                        c.this.hZL.setCurrentDuration(c.this.hZZ, true);
                        if (c.this.hZZ < c.this.dbg.getDuration()) {
                            if (!c.this.dbg.isPlaying()) {
                                c.this.dbg.start();
                            }
                            c.this.xs(c.this.hZr);
                        }
                    }
                }
                String str = null;
                if (c.this.hZA != 1) {
                    if (c.this.hZA != 2) {
                        if (c.this.hZA == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!ap.isEmpty(str)) {
                    TiebaStatic.log(new am(str).bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid));
                }
                c.this.hZA = 0;
                return true;
            }
            return c.this.mGestureDetector.onTouchEvent(motionEvent);
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.operableVideoView.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                c.this.stopPlay();
            }
        }
    };
    private final CustomMessageListener iak = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bUg();
                    return;
                }
                c.this.dbg.setVolume(1.0f, 1.0f);
                c.this.hZJ.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void bx(int i, int i2);
    }

    public c(Context context, View view) {
        if (context != null && view != null) {
            this.mContext = context;
            this.mRootView = view;
            this.hZX = l.aQ(this.mContext);
            this.hZY = l.aO(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return d.h.operable_video_container;
    }

    public void bTY() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.hZM.af(this.hZT, this.hlZ);
        this.hZN.af(this.hZT, this.hlZ);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hlZ) {
                int dimension3 = (int) this.mContext.getResources().getDimension(d.e.tbds112);
                dimension2 = (int) this.mContext.getResources().getDimension(d.e.tbds44);
                i3 = (int) this.mContext.getResources().getDimension(d.e.tbds4);
                i2 = dimension2;
                i = dimension3;
                i5 = dimension2;
                i4 = dimension2;
            } else {
                int dimension4 = (int) this.mContext.getResources().getDimension(d.e.tbds97);
                int dimension5 = (int) this.mContext.getResources().getDimension(d.e.tbds32);
                if (this.hZT) {
                    dimension = (int) this.mContext.getResources().getDimension(d.e.tbds20);
                } else {
                    dimension = (int) this.mContext.getResources().getDimension(d.e.tbds32);
                }
                int dimension6 = (int) this.mContext.getResources().getDimension(d.e.tbds27);
                i = dimension4;
                i2 = dimension5;
                i3 = 0;
                int i6 = dimension;
                dimension2 = (int) this.mContext.getResources().getDimension(d.e.tbds38);
                i4 = dimension6;
                i5 = i6;
            }
            this.hZH.getLayoutParams().height = i;
            this.hZH.setPadding(0, 0, 0, i3);
            this.ejz.setPadding(0, 0, i2, 0);
            this.hZK.setPadding(this.hZK.getPaddingLeft(), 0, i5, 0);
            this.hZJ.setPadding(i4, 0, this.hZJ.getPaddingLeft(), 0);
            this.hZI.setPadding(dimension2, 0, this.hZJ.getPaddingLeft(), 0);
        }
    }

    public void bTZ() {
        if (this.hZT) {
            this.hZt = 392;
            this.hZu = 390;
        } else {
            this.hZt = 904;
            this.hZu = 902;
        }
        if (this.hlZ) {
            this.hZq |= 4096;
            this.hZr |= 4096;
            this.hZs |= 4096;
            this.hZt |= 4096;
            this.hZu |= 4096;
            this.hZv |= 4096;
            this.hZw |= 4096;
            this.hZz |= 4096;
            return;
        }
        this.hZq &= -4097;
        this.hZr &= -4097;
        this.hZs &= -4097;
        this.hZt &= -4097;
        this.hZu &= -4097;
        this.hZv &= -4097;
        this.hZw &= -4097;
        this.hZz &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.hZR = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.hZR);
            }
            this.bty = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dbg = (QuickVideoView) this.hZR.findViewById(d.g.video_view);
            this.gIj = (TbImageView) this.hZR.findViewById(d.g.video_thumbnail);
            this.hZD = this.hZR.findViewById(d.g.black_mask_bottom);
            this.hZE = this.hZR.findViewById(d.g.black_mask_top);
            this.hZF = (TBLottieAnimationView) this.hZR.findViewById(d.g.video_play);
            this.hZH = this.hZR.findViewById(d.g.video_bottom_ctrl_layout);
            this.hZG = (ImageView) this.hZR.findViewById(d.g.video_pause);
            this.hZI = (TextView) this.hZR.findViewById(d.g.video_replay);
            this.ejz = (TextView) this.hZR.findViewById(d.g.video_play_count);
            this.ejy = (TextView) this.hZR.findViewById(d.g.video_duration);
            this.hZJ = (SwitchImageView) this.hZR.findViewById(d.g.video_mute);
            this.hZK = (SwitchImageView) this.hZR.findViewById(d.g.video_full_screen);
            this.hZL = (OperableVideoMediaControllerView) this.hZR.findViewById(d.g.video_media_controller);
            this.hZM = (OperableVideoNetworkStateTipView) this.hZR.findViewById(d.g.video_network_state_tip);
            this.hZN = (OperableVideoShareView) this.hZR.findViewById(d.g.video_share_view);
            this.hZO = (ImageView) this.hZR.findViewById(d.g.video_full_screen_back);
            this.hZP = (VideoGestureView) this.hZR.findViewById(d.g.video_gesture);
            this.hZN.setVideoContainer(this);
            this.hZW = new n(this.mContext);
            this.dbg.setNeedRecovery(true);
            this.dbg.setPlayerReuseEnable(true);
            this.dbg.setContinuePlayEnable(true);
            this.hZW.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.bUk() && !c.this.hZT && !c.this.hlZ && c.this.XA) {
                        if (!com.baidu.mcn.b.sY().cR(c.this.iah.jump_url)) {
                            boolean z = ((long) i2) >= c.this.iah.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.iah.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.iah.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fxf.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeJ = c.this.iah.card_title;
                                    aVar.aeK = c.this.iah.button_title;
                                    aVar.aeL = c.this.iah.jump_url;
                                    aVar.aeI = c.this.iah.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.ctx;
                                    aVar.aeM = c.this.bna();
                                    if (z2) {
                                        c.this.fxf.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fxf.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fxf.isShowing()) {
                                c.this.fxf.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.iai != null) {
                        c.this.iai.bx(i, i2);
                    }
                }
            });
            this.dbg.setBusiness(this.hZW);
            this.dbg.setOnPreparedListener(this);
            this.dbg.setOnCompletionListener(this);
            this.dbg.setOnErrorListener(this);
            this.dbg.setOnSurfaceDestroyedListener(this);
            this.dbg.setOnOutInfoListener(this);
            this.hZF.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZF.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hZF.setAnimation(d.i.lotti_video_loading);
            this.hZF.setOnClickListener(this);
            this.hZJ.setStateImage(d.f.icon_vedio_pronunciation_small_white, d.f.icon_vedio_npronunciation_small_white);
            this.hZJ.setState(1);
            this.hZJ.setOnClickListener(this);
            this.gIj.setConrers(15);
            this.gIj.setRadius(l.h(this.mContext, d.e.tbds20));
            this.gIj.setDrawCorner(true);
            this.gIj.setDefaultBgResource(e.get());
            this.hZL.setPlayer(this.dbg);
            this.hZL.setOnSeekBarChangeListener(this.cNV);
            this.hZK.setStateImage(d.f.icon_vedio_full_screen, d.f.icon_vedio_narrow_screen);
            this.hZK.setState(0);
            this.hZK.setOnClickListener(this);
            this.hZG.setOnClickListener(this);
            this.hZI.setOnClickListener(this);
            this.hZM.setPlayViewOnClickListener(this);
            this.hZO.setOnClickListener(this);
            this.hZR.setOnClickListener(null);
            this.hZR.setOnTouchListener(this.ccU);
            this.hZN.setOnTouchListener(this.ccU);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iaj);
            xs(this.hZq);
            this.ehR = new k();
            this.fxf = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.Zi() != null) {
            this.startPosition = -1L;
            if (this.fxf != null) {
                this.fxf.reset();
            }
            if (!ap.equals(this.bNk, bgVar.Zi().video_url)) {
                this.hZT = bgVar.Zi().is_vertical.intValue() == 1;
                this.bNk = bgVar.Zi().video_url;
                this.ctx = bgVar.getTid();
                this.hZU = bgVar.Zi().video_length.intValue();
                this.hZV = bgVar.Zi().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.iah = bgVar.Zi().mcn_ad_card;
                bTZ();
                bTY();
                xs(this.hZq);
                int intValue = bgVar.Zi().video_duration.intValue() * 1000;
                this.hZL.xq(intValue);
                this.hZL.setPlayer(this.dbg);
                this.ejy.setText(ap.hz(intValue));
                this.ejz.setText(String.format(this.mContext.getResources().getString(d.j.play_count_new), ap.az(bgVar.Zi().play_count.intValue())));
                this.hZM.setVideoLength(bgVar.Zi().video_length.intValue());
                this.hZM.setTid(this.ctx);
                this.hZW.bTw().g(bgVar.Zi());
                this.gIj.startLoad(bgVar.Zi().thumbnail_url, 10, false);
                this.dbg.setVideoPath(this.bNk, this.ctx);
                this.hZN.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.hZW != null) {
            this.hZW.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v bTw() {
        if (this.hZW == null) {
            return null;
        }
        return this.hZW.bTw();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Zq = bdUniqueId;
    }

    public void bUc() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZC);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hZC, this.hZp);
    }

    public void bUd() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZC);
    }

    private void startLoadingAnim() {
        if (this.hZF != null) {
            this.hZF.G(true);
            this.hZF.setMinAndMaxFrame(14, 80);
            this.hZF.cu();
        }
    }

    protected void bUa() {
        if (this.hZz == this.hZs) {
            xs(this.hZr);
        }
    }

    private void bUe() {
        if (this.hZF != null) {
            this.hZF.clearAnimation();
            this.hZF.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.bUa();
                    if (c.this.hZS) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZF.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().registerListener(this.iak);
        if (this.hZM != null && this.hZM.bUl()) {
            xs(this.hZw);
            return;
        }
        this.hZS = true;
        if (!this.dbg.isPlaying()) {
            this.ehR.bEA();
            this.dbg.setVideoPath(this.bNk, this.ctx);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZT ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).T("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.hZS = false;
        if (this.hZF != null) {
            this.hZF.cancelAnimation();
        }
        this.dbg.stopPlayback();
        this.hZL.awJ();
        xs(this.hZq);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iak);
    }

    public void xs(int i) {
        bUd();
        if (i == this.hZs) {
            this.ehR.a(this.ctx, this.hZU, this.hZV, this.mFrom, this.dbg);
        }
        if (this.hZz == this.hZx) {
            this.hZB = i;
            return;
        }
        this.hZz = i;
        this.gIj.setVisibility((i & 1) > 0 ? 0 : 8);
        this.hZD.setVisibility((i & 2) > 0 ? 0 : 8);
        this.hZE.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.hZF.clearAnimation();
        this.hZF.setVisibility(z ? 0 : 8);
        if (!z) {
            this.hZF.setFrame(0);
            this.hZF.cancelAnimation();
        } else {
            this.hZF.setAlpha(1.0f);
        }
        this.hZG.setVisibility((i & 8) > 0 ? 0 : 8);
        this.hZI.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ejz.setVisibility((i & 32) > 0 ? 0 : 8);
        this.ejy.setVisibility((i & 64) > 0 ? 0 : 8);
        this.hZJ.setVisibility((i & 128) > 0 ? 0 : 8);
        this.hZK.setVisibility((i & 256) > 0 ? 0 : 8);
        this.hZL.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.hZL.getVisibility() == 0) {
            this.hZL.showProgress();
        }
        this.hZM.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.hZN.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.hZN.getVisibility() == 0) {
            this.hZN.setAlpha(1.0f);
        }
        this.hZO.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.hZP.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.video_mute) {
                bUh();
            } else if (id == d.g.video_full_screen || id == d.g.video_full_screen_back) {
                bUj();
            } else if (id == d.g.video_replay) {
                xs(this.hZq);
                startPlay();
                TiebaStatic.log(new am("c13345").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZT ? 1 : 2).T("obj_locate", this.hlZ ? 1 : 2));
                bUf();
            } else if (id == d.g.video_play) {
                if (this.hZz == this.hZq) {
                    startPlay();
                } else {
                    xs(this.hZt);
                    bUc();
                    this.dbg.start();
                }
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZT ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlZ ? 1 : 2).T("obj_locate", 1));
                bUf();
            } else if (id == d.g.video_pause) {
                xs(this.hZu);
                bUd();
                this.dbg.pause();
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZT ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlZ ? 1 : 2).T("obj_locate", 2));
            } else if (id == d.g.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bNk);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Zq);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUg() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbg.setVolume(0.0f, 0.0f);
            this.hZJ.setState(1);
            return;
        }
        this.dbg.setVolume(1.0f, 1.0f);
        this.hZJ.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUh() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.bty, true);
            this.hZJ.setState(0);
        } else {
            this.dbg.setVolume(0.0f, 0.0f);
            this.hZJ.setState(1);
            ad.a(this.bty, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUi() {
        if (this.mRootView != null && this.hZR != null && this.dbg != null) {
            this.dbg.setFullScreenToDestroySurface();
            if (this.cVs == null) {
                this.cVs = new o((Activity) this.mContext);
            }
            if (this.hlZ) {
                if (!this.hZT) {
                    this.cVs.bAB();
                }
                if (this.hZQ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hZQ.getParent()).removeView(this.hZQ);
                }
                if ((this.hZR.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hlZ = false;
                    ((ViewGroup) this.hZR.getParent()).removeView(this.hZR);
                    ((ViewGroup) this.mRootView).addView(this.hZR);
                    h((Activity) this.mContext, this.hlZ);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.hZT) {
                        this.cVs.bAB();
                    }
                    if (this.mContext instanceof Activity) {
                        this.hZR.getLocationOnScreen(this.iaa);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.hZQ == null) {
                                    this.hZQ = new View(this.mContext);
                                    this.hZQ.setClickable(true);
                                    this.hZQ.setBackgroundColor(al.getColor(d.C0236d.black_alpha100));
                                    this.hZQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.hZQ.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.hZQ.getParent()).removeView(this.hZQ);
                                }
                                this.hZQ.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.hZQ);
                                ((ViewGroup) childAt).addView(this.hZR);
                                this.hlZ = true;
                                h((Activity) this.mContext, this.hlZ);
                                if (this.fxf != null && this.fxf.isShowing()) {
                                    this.fxf.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZT ? 1 : 2));
            }
            bTZ();
            bTY();
            if (this.dbg.isPlaying()) {
                xs(this.hZr);
            } else {
                this.hZz |= 1;
                xs(this.hZz);
            }
            this.hZK.cmS();
            ks(this.hlZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUj() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.hZT) {
            bUi();
        } else if (this.hZz == this.hZx) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.hZR.setScaleX(1.0f);
                    c.this.hZR.setScaleY(1.0f);
                    c.this.hZR.setTranslationX(0.0f);
                    c.this.hZR.setTranslationY(0.0f);
                    c.this.hZN.setScaleX(1.0f);
                    c.this.hZN.setScaleY(1.0f);
                    c.this.hZR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.iac) {
                        c.this.bUi();
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
            if (!this.iac) {
                float width = this.mRootView.getWidth() / this.hZR.getWidth();
                float height = this.mRootView.getHeight() / this.hZR.getHeight();
                this.hZR.setPivotX(0.0f);
                this.hZR.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZR, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZR, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZN, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZN, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZR, "TranslationX", this.hZR.getTranslationX(), this.iaa[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZR, "TranslationY", this.hZR.getTranslationY(), this.iaa[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.hZQ, "alpha", this.hZQ.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZN, "alpha", this.hZN.getAlpha(), 0.0f);
            } else {
                float width2 = this.hZY / this.hZR.getWidth();
                float height2 = this.iab / this.hZR.getHeight();
                this.hZR.setPivotX(0.0f);
                this.hZR.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZR, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZR, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZN, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZN, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZR, "TranslationX", this.hZR.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZR, "TranslationY", this.hZR.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZN, "alpha", this.hZN.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.hZB != -1) {
                this.hZz = this.hZB;
                this.hZB = -1;
                if (this.hZz == this.hZy || this.hZz == this.hZt || this.hZz == this.hZr) {
                    this.dbg.start();
                    xs(this.hZr);
                }
            }
        } else {
            bUi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bAA();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.hZR.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        bUg();
        this.ehR.bEB();
        if (this.hZS) {
            if (this.hlZ && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dbg.start();
            if (!this.dbg.getPlayer().isNewPlayer()) {
                xs(this.hZs);
                this.hZL.showProgress();
                bUe();
            }
        }
    }

    public void onCompletion(g gVar) {
        xs(this.hZv);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.hZz == this.hZu) {
            stopPlay();
            xs(this.hZu);
        } else if (this.hZz == this.hZv) {
            stopPlay();
            xs(this.hZv);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            xs(this.hZs);
            this.hZL.showProgress();
            bUe();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View bSW() {
        return this.hZR;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.hZS || this.dbg.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dbg.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTW() {
    }

    private void bAA() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZR.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZR.setSystemUiVisibility(4);
        } else {
            this.hZR.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTX() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbg.setVolume(1.0f, 1.0f);
            this.hZJ.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (z) {
            this.hZF.cancelAnimation();
            if (this.hZz == this.hZr || this.hZz == this.hZs || this.hZz == this.hZt || this.hZz == this.hZq) {
                stopPlay();
            }
            this.hZz |= 1;
            xs(this.hZz);
        } else if (this.hZz == this.hZq) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hlZ;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hlZ) {
            bUj();
            return true;
        }
        return false;
    }

    protected int bna() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bUk() {
        return this.iah != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pe(boolean z) {
        this.XA = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.iai = aVar;
    }
}
