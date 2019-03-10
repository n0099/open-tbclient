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
    protected TbImageView gIk;
    private View hZE;
    private View hZF;
    private TBLottieAnimationView hZG;
    private ImageView hZH;
    private View hZI;
    private TextView hZJ;
    protected SwitchImageView hZK;
    private SwitchImageView hZL;
    private OperableVideoMediaControllerView hZM;
    private OperableVideoNetworkStateTipView hZN;
    private OperableVideoShareView hZO;
    private ImageView hZP;
    private VideoGestureView hZQ;
    private View hZR;
    protected ViewGroup hZS;
    protected boolean hZT;
    protected boolean hZU;
    protected long hZV;
    protected long hZW;
    private n hZX;
    private float hZY;
    private float hZZ;
    private int iaa;
    private int iac;
    private boolean iad;
    private float iag;
    private int iah;
    private McnAdInfo iai;
    private a iaj;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int hZq = 3000;
    protected int hZr = 103;
    protected int hZs = 0;
    protected int hZt = 4;
    protected int hZu = 904;
    protected int hZv = 902;
    protected int hZw = 2066;
    protected int hZx = 1027;
    protected int hZy = 12288;
    protected int hZz = 0;
    protected int hZA = this.hZr;
    private int hZB = 0;
    private int hZC = -1;
    private Runnable hZD = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xs(c.this.hZs);
        }
    };
    private WeakReference<Context> bty = null;
    private boolean hma = false;
    private int[] iab = new int[2];
    private int iae = 0;
    private int iaf = 0;
    protected View.OnClickListener bNt = null;
    private boolean XA = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cNV = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xs(c.this.hZu);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dbg.isPlaying()) {
                    c.this.dbg.start();
                }
                c.this.bUd();
                TiebaStatic.log(new am("c13355").bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZU ? 1 : 2).T("obj_locate", c.this.hma ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iak = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dbg.isPlaying()) {
                c.this.dbg.pause();
                c.this.xs(c.this.hZv);
            } else if (c.this.hZA == c.this.hZv || c.this.hZA == (c.this.hZv | 1)) {
                c.this.dbg.start();
                c.this.xs(c.this.hZu);
                c.this.bUd();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.hZA == c.this.hZs || c.this.hZA == c.this.hZt) {
                c.this.xs(c.this.hZu);
                c.this.bUd();
            } else if (c.this.hZA == c.this.hZu) {
                c.this.xs(c.this.hZs);
            } else if (c.this.hZA == c.this.hZv) {
                c.this.xs(c.this.hZu);
                c.this.bUd();
                c.this.dbg.start();
                TiebaStatic.log(new am("c13344").bJ("tid", c.this.ctx).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZU ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hma ? 1 : 2).T("obj_locate", 1));
                c.this.bUg();
            } else {
                c.this.xs(c.this.hZr);
                c.this.startPlay();
                c.this.bUg();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.hZB = 0;
            if (c.this.hma) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hma) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.hZU) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.hZB) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dbg.isPlaying()) {
                                c.this.dbg.pause();
                                c.this.xs(c.this.hZz);
                            }
                            c.this.hZB = 4;
                            c.this.hZC = c.this.hZA;
                            c.this.hZA = c.this.hZy;
                            c.this.iac = c.this.hZS.getMeasuredHeight();
                            c.this.iag = c.this.hZZ / c.this.iac;
                            c.this.iah = (int) (1.2f * c.this.mRootView.getWidth());
                            bZ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        bZ(rawX, rawY);
                        break;
                }
            } else if (c.this.hZA == c.this.hZs || c.this.hZA == c.this.hZu || c.this.hZA == c.this.hZv || c.this.hZA == c.this.hZy) {
                switch (c.this.hZB) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.hZB = 3;
                            c.this.iaa = c.this.dbg.getCurrentPosition();
                            aK(f);
                        } else if (motionEvent.getX() < c.this.hZY / 2.0f) {
                            c.this.hZB = 2;
                            c.this.hZQ.n(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.hZB = 1;
                            c.this.hZQ.m(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.hZA != c.this.hZy) {
                            c.this.xs(c.this.hZy);
                            break;
                        }
                        break;
                    case 1:
                        c.this.hZQ.m(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.bTY();
                            break;
                        }
                        break;
                    case 2:
                        c.this.hZQ.n(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aK(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void bZ(int i, int i2) {
            if (c.this.iae != i2 || c.this.iaf != i) {
                c.this.iad = c.this.iae - i2 > 0 || ((float) i2) < c.this.hZY / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.hZS.getLayoutParams();
                if (i2 != c.this.iae) {
                    int i3 = c.this.iac - i2;
                    int i4 = (int) (i3 * c.this.iag);
                    if (i4 < c.this.iah) {
                        i4 = c.this.iah;
                        i3 = (int) (i4 / c.this.iag);
                    }
                    if (i4 != c.this.iah) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.hZS.setLayoutParams(layoutParams);
                    }
                    c.this.iae = i2;
                    c.this.hZS.setTranslationY(c.this.iae);
                }
                if (i != c.this.iae) {
                    c.this.iaf = i;
                    c.this.hZS.setTranslationX(c.this.iaf + ((c.this.hZZ - layoutParams.width) / 2.0f));
                }
                c.this.hZR.setAlpha((layoutParams.width - c.this.iah) / (c.this.hZZ - c.this.iah));
                if (c.this.hZO.getVisibility() == 0) {
                    float f = c.this.hZY / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.hZO.setAlpha(f2);
                }
            }
        }

        private void aK(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.iaa += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.iaa += 1000;
                z = false;
            }
            int duration = c.this.dbg.getDuration();
            if (c.this.iaa < 0) {
                c.this.iaa = 0;
            } else if (c.this.iaa > duration) {
                c.this.iaa = duration;
            }
            String str = ap.hz(c.this.iaa) + "/" + ap.hz(duration);
            if (c.this.hZQ != null) {
                c.this.hZQ.x(z, str);
            }
            c.this.hZM.setCurrentDuration(c.this.iaa, false);
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.hZA == c.this.hZy) {
                if (c.this.hZB == 4) {
                    c.this.bUk();
                    c.this.iae = 0;
                    c.this.iaf = 0;
                } else {
                    c.this.hZA = -1;
                    if (c.this.hZB != 3) {
                        if (c.this.hZC != -1) {
                            c.this.xs(c.this.hZC);
                            c.this.hZC = -1;
                        } else if (c.this.dbg.isPlaying()) {
                            c.this.xs(c.this.hZs);
                        } else {
                            c.this.xs(c.this.hZv);
                        }
                    } else {
                        c.this.hZM.setCurrentDuration(c.this.iaa, true);
                        if (c.this.iaa < c.this.dbg.getDuration()) {
                            if (!c.this.dbg.isPlaying()) {
                                c.this.dbg.start();
                            }
                            c.this.xs(c.this.hZs);
                        }
                    }
                }
                String str = null;
                if (c.this.hZB != 1) {
                    if (c.this.hZB != 2) {
                        if (c.this.hZB == 3) {
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
                c.this.hZB = 0;
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
    private final CustomMessageListener ial = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bUh();
                    return;
                }
                c.this.dbg.setVolume(1.0f, 1.0f);
                c.this.hZK.setState(0);
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
            this.hZY = l.aQ(this.mContext);
            this.hZZ = l.aO(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return d.h.operable_video_container;
    }

    public void bTZ() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.hZN.af(this.hZU, this.hma);
        this.hZO.af(this.hZU, this.hma);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hma) {
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
                if (this.hZU) {
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
            this.hZI.getLayoutParams().height = i;
            this.hZI.setPadding(0, 0, 0, i3);
            this.ejz.setPadding(0, 0, i2, 0);
            this.hZL.setPadding(this.hZL.getPaddingLeft(), 0, i5, 0);
            this.hZK.setPadding(i4, 0, this.hZK.getPaddingLeft(), 0);
            this.hZJ.setPadding(dimension2, 0, this.hZK.getPaddingLeft(), 0);
        }
    }

    public void bUa() {
        if (this.hZU) {
            this.hZu = 392;
            this.hZv = 390;
        } else {
            this.hZu = 904;
            this.hZv = 902;
        }
        if (this.hma) {
            this.hZr |= 4096;
            this.hZs |= 4096;
            this.hZt |= 4096;
            this.hZu |= 4096;
            this.hZv |= 4096;
            this.hZw |= 4096;
            this.hZx |= 4096;
            this.hZA |= 4096;
            return;
        }
        this.hZr &= -4097;
        this.hZs &= -4097;
        this.hZt &= -4097;
        this.hZu &= -4097;
        this.hZv &= -4097;
        this.hZw &= -4097;
        this.hZx &= -4097;
        this.hZA &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.hZS = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.hZS);
            }
            this.bty = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dbg = (QuickVideoView) this.hZS.findViewById(d.g.video_view);
            this.gIk = (TbImageView) this.hZS.findViewById(d.g.video_thumbnail);
            this.hZE = this.hZS.findViewById(d.g.black_mask_bottom);
            this.hZF = this.hZS.findViewById(d.g.black_mask_top);
            this.hZG = (TBLottieAnimationView) this.hZS.findViewById(d.g.video_play);
            this.hZI = this.hZS.findViewById(d.g.video_bottom_ctrl_layout);
            this.hZH = (ImageView) this.hZS.findViewById(d.g.video_pause);
            this.hZJ = (TextView) this.hZS.findViewById(d.g.video_replay);
            this.ejz = (TextView) this.hZS.findViewById(d.g.video_play_count);
            this.ejy = (TextView) this.hZS.findViewById(d.g.video_duration);
            this.hZK = (SwitchImageView) this.hZS.findViewById(d.g.video_mute);
            this.hZL = (SwitchImageView) this.hZS.findViewById(d.g.video_full_screen);
            this.hZM = (OperableVideoMediaControllerView) this.hZS.findViewById(d.g.video_media_controller);
            this.hZN = (OperableVideoNetworkStateTipView) this.hZS.findViewById(d.g.video_network_state_tip);
            this.hZO = (OperableVideoShareView) this.hZS.findViewById(d.g.video_share_view);
            this.hZP = (ImageView) this.hZS.findViewById(d.g.video_full_screen_back);
            this.hZQ = (VideoGestureView) this.hZS.findViewById(d.g.video_gesture);
            this.hZO.setVideoContainer(this);
            this.hZX = new n(this.mContext);
            this.dbg.setNeedRecovery(true);
            this.dbg.setPlayerReuseEnable(true);
            this.dbg.setContinuePlayEnable(true);
            this.hZX.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.bUl() && !c.this.hZU && !c.this.hma && c.this.XA) {
                        if (!com.baidu.mcn.b.sY().cR(c.this.iai.jump_url)) {
                            boolean z = ((long) i2) >= c.this.iai.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.iai.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.iai.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fxf.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeJ = c.this.iai.card_title;
                                    aVar.aeK = c.this.iai.button_title;
                                    aVar.aeL = c.this.iai.jump_url;
                                    aVar.aeI = c.this.iai.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.ctx;
                                    aVar.aeM = c.this.bnb();
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
                    if (c.this.iaj != null) {
                        c.this.iaj.bx(i, i2);
                    }
                }
            });
            this.dbg.setBusiness(this.hZX);
            this.dbg.setOnPreparedListener(this);
            this.dbg.setOnCompletionListener(this);
            this.dbg.setOnErrorListener(this);
            this.dbg.setOnSurfaceDestroyedListener(this);
            this.dbg.setOnOutInfoListener(this);
            this.hZG.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZG.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hZG.setAnimation(d.i.lotti_video_loading);
            this.hZG.setOnClickListener(this);
            this.hZK.setStateImage(d.f.icon_vedio_pronunciation_small_white, d.f.icon_vedio_npronunciation_small_white);
            this.hZK.setState(1);
            this.hZK.setOnClickListener(this);
            this.gIk.setConrers(15);
            this.gIk.setRadius(l.h(this.mContext, d.e.tbds20));
            this.gIk.setDrawCorner(true);
            this.gIk.setDefaultBgResource(e.get());
            this.hZM.setPlayer(this.dbg);
            this.hZM.setOnSeekBarChangeListener(this.cNV);
            this.hZL.setStateImage(d.f.icon_vedio_full_screen, d.f.icon_vedio_narrow_screen);
            this.hZL.setState(0);
            this.hZL.setOnClickListener(this);
            this.hZH.setOnClickListener(this);
            this.hZJ.setOnClickListener(this);
            this.hZN.setPlayViewOnClickListener(this);
            this.hZP.setOnClickListener(this);
            this.hZS.setOnClickListener(null);
            this.hZS.setOnTouchListener(this.ccU);
            this.hZO.setOnTouchListener(this.ccU);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iak);
            xs(this.hZr);
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
                this.hZU = bgVar.Zi().is_vertical.intValue() == 1;
                this.bNk = bgVar.Zi().video_url;
                this.ctx = bgVar.getTid();
                this.hZV = bgVar.Zi().video_length.intValue();
                this.hZW = bgVar.Zi().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.iai = bgVar.Zi().mcn_ad_card;
                bUa();
                bTZ();
                xs(this.hZr);
                int intValue = bgVar.Zi().video_duration.intValue() * 1000;
                this.hZM.xq(intValue);
                this.hZM.setPlayer(this.dbg);
                this.ejy.setText(ap.hz(intValue));
                this.ejz.setText(String.format(this.mContext.getResources().getString(d.j.play_count_new), ap.az(bgVar.Zi().play_count.intValue())));
                this.hZN.setVideoLength(bgVar.Zi().video_length.intValue());
                this.hZN.setTid(this.ctx);
                this.hZX.bTx().g(bgVar.Zi());
                this.gIk.startLoad(bgVar.Zi().thumbnail_url, 10, false);
                this.dbg.setVideoPath(this.bNk, this.ctx);
                this.hZO.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.hZX != null) {
            this.hZX.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v bTx() {
        if (this.hZX == null) {
            return null;
        }
        return this.hZX.bTx();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Zq = bdUniqueId;
    }

    public void bUd() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZD);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hZD, this.hZq);
    }

    public void bUe() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZD);
    }

    private void startLoadingAnim() {
        if (this.hZG != null) {
            this.hZG.G(true);
            this.hZG.setMinAndMaxFrame(14, 80);
            this.hZG.cu();
        }
    }

    protected void bUb() {
        if (this.hZA == this.hZt) {
            xs(this.hZs);
        }
    }

    private void bUf() {
        if (this.hZG != null) {
            this.hZG.clearAnimation();
            this.hZG.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.bUb();
                    if (c.this.hZT) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZG.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.ial);
        if (this.hZN != null && this.hZN.bUm()) {
            xs(this.hZx);
            return;
        }
        this.hZT = true;
        if (!this.dbg.isPlaying()) {
            this.ehR.bEB();
            this.dbg.setVideoPath(this.bNk, this.ctx);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZU ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).T("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.hZT = false;
        if (this.hZG != null) {
            this.hZG.cancelAnimation();
        }
        this.dbg.stopPlayback();
        this.hZM.awK();
        xs(this.hZr);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.ial);
    }

    public void xs(int i) {
        bUe();
        if (i == this.hZt) {
            this.ehR.a(this.ctx, this.hZV, this.hZW, this.mFrom, this.dbg);
        }
        if (this.hZA == this.hZy) {
            this.hZC = i;
            return;
        }
        this.hZA = i;
        this.gIk.setVisibility((i & 1) > 0 ? 0 : 8);
        this.hZE.setVisibility((i & 2) > 0 ? 0 : 8);
        this.hZF.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.hZG.clearAnimation();
        this.hZG.setVisibility(z ? 0 : 8);
        if (!z) {
            this.hZG.setFrame(0);
            this.hZG.cancelAnimation();
        } else {
            this.hZG.setAlpha(1.0f);
        }
        this.hZH.setVisibility((i & 8) > 0 ? 0 : 8);
        this.hZJ.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ejz.setVisibility((i & 32) > 0 ? 0 : 8);
        this.ejy.setVisibility((i & 64) > 0 ? 0 : 8);
        this.hZK.setVisibility((i & 128) > 0 ? 0 : 8);
        this.hZL.setVisibility((i & 256) > 0 ? 0 : 8);
        this.hZM.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.hZM.getVisibility() == 0) {
            this.hZM.showProgress();
        }
        this.hZN.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.hZO.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.hZO.getVisibility() == 0) {
            this.hZO.setAlpha(1.0f);
        }
        this.hZP.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.hZQ.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.video_mute) {
                bUi();
            } else if (id == d.g.video_full_screen || id == d.g.video_full_screen_back) {
                bUk();
            } else if (id == d.g.video_replay) {
                xs(this.hZr);
                startPlay();
                TiebaStatic.log(new am("c13345").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZU ? 1 : 2).T("obj_locate", this.hma ? 1 : 2));
                bUg();
            } else if (id == d.g.video_play) {
                if (this.hZA == this.hZr) {
                    startPlay();
                } else {
                    xs(this.hZu);
                    bUd();
                    this.dbg.start();
                }
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZU ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hma ? 1 : 2).T("obj_locate", 1));
                bUg();
            } else if (id == d.g.video_pause) {
                xs(this.hZv);
                bUe();
                this.dbg.pause();
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZU ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hma ? 1 : 2).T("obj_locate", 2));
            } else if (id == d.g.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUg() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bNk);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Zq);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUh() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbg.setVolume(0.0f, 0.0f);
            this.hZK.setState(1);
            return;
        }
        this.dbg.setVolume(1.0f, 1.0f);
        this.hZK.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUi() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dbg.setVolume(1.0f, 1.0f);
            ad.a(this.bty, true);
            this.hZK.setState(0);
        } else {
            this.dbg.setVolume(0.0f, 0.0f);
            this.hZK.setState(1);
            ad.a(this.bty, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUj() {
        if (this.mRootView != null && this.hZS != null && this.dbg != null) {
            this.dbg.setFullScreenToDestroySurface();
            if (this.cVs == null) {
                this.cVs = new o((Activity) this.mContext);
            }
            if (this.hma) {
                if (!this.hZU) {
                    this.cVs.bAC();
                }
                if (this.hZR.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hZR.getParent()).removeView(this.hZR);
                }
                if ((this.hZS.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hma = false;
                    ((ViewGroup) this.hZS.getParent()).removeView(this.hZS);
                    ((ViewGroup) this.mRootView).addView(this.hZS);
                    h((Activity) this.mContext, this.hma);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.hZU) {
                        this.cVs.bAC();
                    }
                    if (this.mContext instanceof Activity) {
                        this.hZS.getLocationOnScreen(this.iab);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.hZR == null) {
                                    this.hZR = new View(this.mContext);
                                    this.hZR.setClickable(true);
                                    this.hZR.setBackgroundColor(al.getColor(d.C0236d.black_alpha100));
                                    this.hZR.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.hZR.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.hZR.getParent()).removeView(this.hZR);
                                }
                                this.hZR.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.hZR);
                                ((ViewGroup) childAt).addView(this.hZS);
                                this.hma = true;
                                h((Activity) this.mContext, this.hma);
                                if (this.fxf != null && this.fxf.isShowing()) {
                                    this.fxf.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bJ("tid", this.ctx).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZU ? 1 : 2));
            }
            bUa();
            bTZ();
            if (this.dbg.isPlaying()) {
                xs(this.hZs);
            } else {
                this.hZA |= 1;
                xs(this.hZA);
            }
            this.hZL.cnc();
            ks(this.hma);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUk() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.hZU) {
            bUj();
        } else if (this.hZA == this.hZy) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.hZS.setScaleX(1.0f);
                    c.this.hZS.setScaleY(1.0f);
                    c.this.hZS.setTranslationX(0.0f);
                    c.this.hZS.setTranslationY(0.0f);
                    c.this.hZO.setScaleX(1.0f);
                    c.this.hZO.setScaleY(1.0f);
                    c.this.hZS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.iad) {
                        c.this.bUj();
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
            if (!this.iad) {
                float width = this.mRootView.getWidth() / this.hZS.getWidth();
                float height = this.mRootView.getHeight() / this.hZS.getHeight();
                this.hZS.setPivotX(0.0f);
                this.hZS.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZS, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZS, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZO, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZO, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZS, "TranslationX", this.hZS.getTranslationX(), this.iab[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZS, "TranslationY", this.hZS.getTranslationY(), this.iab[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.hZR, "alpha", this.hZR.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZO, "alpha", this.hZO.getAlpha(), 0.0f);
            } else {
                float width2 = this.hZZ / this.hZS.getWidth();
                float height2 = this.iac / this.hZS.getHeight();
                this.hZS.setPivotX(0.0f);
                this.hZS.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZS, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZS, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZO, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZO, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZS, "TranslationX", this.hZS.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZS, "TranslationY", this.hZS.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZO, "alpha", this.hZO.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.hZC != -1) {
                this.hZA = this.hZC;
                this.hZC = -1;
                if (this.hZA == this.hZz || this.hZA == this.hZu || this.hZA == this.hZs) {
                    this.dbg.start();
                    xs(this.hZs);
                }
            }
        } else {
            bUj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Activity activity, boolean z) {
        if (activity != null && activity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                bAB();
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.hZS.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        bUh();
        this.ehR.bEC();
        if (this.hZT) {
            if (this.hma && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dbg.start();
            if (!this.dbg.getPlayer().isNewPlayer()) {
                xs(this.hZt);
                this.hZM.showProgress();
                bUf();
            }
        }
    }

    public void onCompletion(g gVar) {
        xs(this.hZw);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.hZA == this.hZv) {
            stopPlay();
            xs(this.hZv);
        } else if (this.hZA == this.hZw) {
            stopPlay();
            xs(this.hZw);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            xs(this.hZt);
            this.hZM.showProgress();
            bUf();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View bSX() {
        return this.hZS;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.hZT || this.dbg.isPlaying();
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
    public void bTX() {
    }

    private void bAB() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZS.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZS.setSystemUiVisibility(4);
        } else {
            this.hZS.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTY() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbg.setVolume(1.0f, 1.0f);
            this.hZK.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (z) {
            this.hZG.cancelAnimation();
            if (this.hZA == this.hZs || this.hZA == this.hZt || this.hZA == this.hZu || this.hZA == this.hZr) {
                stopPlay();
            }
            this.hZA |= 1;
            xs(this.hZA);
        } else if (this.hZA == this.hZr) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hma;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hma) {
            bUk();
            return true;
        }
        return false;
    }

    protected int bnb() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bUl() {
        return this.iai != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pe(boolean z) {
        this.XA = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.iaj = aVar;
    }
}
