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
    protected BdUniqueId Zr;
    private String bNl;
    private o cVo;
    protected String ctu;
    protected QuickVideoView dbc;
    protected k ehN;
    private TextView eju;
    private TextView ejv;
    private com.baidu.mcn.c fxe;
    protected TbImageView gIj;
    private TBLottieAnimationView hZA;
    private ImageView hZB;
    private View hZC;
    private TextView hZD;
    protected SwitchImageView hZE;
    private SwitchImageView hZF;
    private OperableVideoMediaControllerView hZG;
    private OperableVideoNetworkStateTipView hZH;
    private OperableVideoShareView hZI;
    private ImageView hZJ;
    private VideoGestureView hZK;
    private View hZL;
    protected ViewGroup hZM;
    protected boolean hZN;
    protected boolean hZO;
    protected long hZP;
    protected long hZQ;
    private n hZR;
    private float hZS;
    private float hZT;
    private int hZU;
    private int hZW;
    private boolean hZX;
    private View hZy;
    private View hZz;
    private float iaa;
    private int iab;
    private McnAdInfo iac;
    private a iad;
    protected Context mContext;
    protected long mFid;
    protected String mFrom;
    private GestureDetector mGestureDetector;
    private View mRootView;
    protected int hZk = 3000;
    protected int hZl = 103;
    protected int hZm = 0;
    protected int hZn = 4;
    protected int hZo = 904;
    protected int hZp = 902;
    protected int hZq = 2066;
    protected int hZr = 1027;
    protected int hZs = 12288;
    protected int hZt = 0;
    protected int hZu = this.hZl;
    private int hZv = 0;
    private int hZw = -1;
    private Runnable hZx = new Runnable() { // from class: com.baidu.tieba.play.operableVideoView.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.xs(c.this.hZm);
        }
    };
    private WeakReference<Context> btA = null;
    private boolean hlV = false;
    private int[] hZV = new int[2];
    private int hZY = 0;
    private int hZZ = 0;
    protected View.OnClickListener bNu = null;
    private boolean XB = false;
    private long startPosition = -1;
    private SeekBar.OnSeekBarChangeListener cNS = new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.play.operableVideoView.c.7
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c.this.xs(c.this.hZo);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                if (!c.this.dbc.isPlaying()) {
                    c.this.dbc.start();
                }
                c.this.bUf();
                TiebaStatic.log(new am("c13355").bJ("tid", c.this.ctu).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZO ? 1 : 2).T("obj_locate", c.this.hlV ? 1 : 2));
            }
        }
    };
    private GestureDetector.SimpleOnGestureListener iae = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.play.operableVideoView.c.8
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (c.this.dbc.isPlaying()) {
                c.this.dbc.pause();
                c.this.xs(c.this.hZp);
            } else if (c.this.hZu == c.this.hZp || c.this.hZu == (c.this.hZp | 1)) {
                c.this.dbc.start();
                c.this.xs(c.this.hZo);
                c.this.bUf();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (c.this.hZu == c.this.hZm || c.this.hZu == c.this.hZn) {
                c.this.xs(c.this.hZo);
                c.this.bUf();
            } else if (c.this.hZu == c.this.hZo) {
                c.this.xs(c.this.hZm);
            } else if (c.this.hZu == c.this.hZp) {
                c.this.xs(c.this.hZo);
                c.this.bUf();
                c.this.dbc.start();
                TiebaStatic.log(new am("c13344").bJ("tid", c.this.ctu).k(ImageViewerConfig.FORUM_ID, c.this.mFid).T("obj_type", c.this.hZO ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.this.hlV ? 1 : 2).T("obj_locate", 1));
                c.this.bUi();
            } else {
                c.this.xs(c.this.hZl);
                c.this.startPlay();
                c.this.bUi();
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c.this.hZv = 0;
            if (c.this.hlV) {
                c.this.h((Activity) c.this.mContext, true);
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!c.this.hlV) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            if (c.this.hZO) {
                int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                switch (c.this.hZv) {
                    case 0:
                        if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                            if (c.this.dbc.isPlaying()) {
                                c.this.dbc.pause();
                                c.this.xs(c.this.hZt);
                            }
                            c.this.hZv = 4;
                            c.this.hZw = c.this.hZu;
                            c.this.hZu = c.this.hZs;
                            c.this.hZW = c.this.hZM.getMeasuredHeight();
                            c.this.iaa = c.this.hZT / c.this.hZW;
                            c.this.iab = (int) (1.2f * c.this.mRootView.getWidth());
                            bZ(rawX, rawY);
                            break;
                        }
                        break;
                    case 4:
                        bZ(rawX, rawY);
                        break;
                }
            } else if (c.this.hZu == c.this.hZm || c.this.hZu == c.this.hZo || c.this.hZu == c.this.hZp || c.this.hZu == c.this.hZs) {
                switch (c.this.hZv) {
                    case 0:
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            c.this.hZv = 3;
                            c.this.hZU = c.this.dbc.getCurrentPosition();
                            aK(f);
                        } else if (motionEvent.getX() < c.this.hZS / 2.0f) {
                            c.this.hZv = 2;
                            c.this.hZK.n(c.this.mContext, f2 > 0.0f);
                        } else {
                            c.this.hZv = 1;
                            c.this.hZK.m(c.this.mContext, f2 > 0.0f);
                        }
                        if (c.this.hZu != c.this.hZs) {
                            c.this.xs(c.this.hZs);
                            break;
                        }
                        break;
                    case 1:
                        c.this.hZK.m(c.this.mContext, f2 > 0.0f);
                        if (f2 > 0.0f) {
                            c.this.bUa();
                            break;
                        }
                        break;
                    case 2:
                        c.this.hZK.n(c.this.mContext, f2 > 0.0f);
                        break;
                    case 3:
                        aK(f);
                        break;
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        private void bZ(int i, int i2) {
            if (c.this.hZY != i2 || c.this.hZZ != i) {
                c.this.hZX = c.this.hZY - i2 > 0 || ((float) i2) < c.this.hZS / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.hZM.getLayoutParams();
                if (i2 != c.this.hZY) {
                    int i3 = c.this.hZW - i2;
                    int i4 = (int) (i3 * c.this.iaa);
                    if (i4 < c.this.iab) {
                        i4 = c.this.iab;
                        i3 = (int) (i4 / c.this.iaa);
                    }
                    if (i4 != c.this.iab) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        c.this.hZM.setLayoutParams(layoutParams);
                    }
                    c.this.hZY = i2;
                    c.this.hZM.setTranslationY(c.this.hZY);
                }
                if (i != c.this.hZY) {
                    c.this.hZZ = i;
                    c.this.hZM.setTranslationX(c.this.hZZ + ((c.this.hZT - layoutParams.width) / 2.0f));
                }
                c.this.hZL.setAlpha((layoutParams.width - c.this.iab) / (c.this.hZT - c.this.iab));
                if (c.this.hZI.getVisibility() == 0) {
                    float f = c.this.hZS / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    c.this.hZI.setAlpha(f2);
                }
            }
        }

        private void aK(float f) {
            boolean z;
            if (f > 0.0f) {
                c.this.hZU += NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                z = true;
            } else {
                c.this.hZU += 1000;
                z = false;
            }
            int duration = c.this.dbc.getDuration();
            if (c.this.hZU < 0) {
                c.this.hZU = 0;
            } else if (c.this.hZU > duration) {
                c.this.hZU = duration;
            }
            String str = ap.hz(c.this.hZU) + "/" + ap.hz(duration);
            if (c.this.hZK != null) {
                c.this.hZK.x(z, str);
            }
            c.this.hZG.setCurrentDuration(c.this.hZU, false);
        }
    };
    private View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.play.operableVideoView.c.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && c.this.hZu == c.this.hZs) {
                if (c.this.hZv == 4) {
                    c.this.bUm();
                    c.this.hZY = 0;
                    c.this.hZZ = 0;
                } else {
                    c.this.hZu = -1;
                    if (c.this.hZv != 3) {
                        if (c.this.hZw != -1) {
                            c.this.xs(c.this.hZw);
                            c.this.hZw = -1;
                        } else if (c.this.dbc.isPlaying()) {
                            c.this.xs(c.this.hZm);
                        } else {
                            c.this.xs(c.this.hZp);
                        }
                    } else {
                        c.this.hZG.setCurrentDuration(c.this.hZU, true);
                        if (c.this.hZU < c.this.dbc.getDuration()) {
                            if (!c.this.dbc.isPlaying()) {
                                c.this.dbc.start();
                            }
                            c.this.xs(c.this.hZm);
                        }
                    }
                }
                String str = null;
                if (c.this.hZv != 1) {
                    if (c.this.hZv != 2) {
                        if (c.this.hZv == 3) {
                            str = "c13362";
                        }
                    } else {
                        str = "c13346";
                    }
                } else {
                    str = "c13361";
                }
                if (!ap.isEmpty(str)) {
                    TiebaStatic.log(new am(str).bJ("tid", c.this.ctu).k(ImageViewerConfig.FORUM_ID, c.this.mFid));
                }
                c.this.hZv = 0;
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
    private final CustomMessageListener iaf = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.play.operableVideoView.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bUj();
                    return;
                }
                c.this.dbc.setVolume(1.0f, 1.0f);
                c.this.hZE.setState(0);
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
            this.hZS = l.aQ(this.mContext);
            this.hZT = l.aO(this.mContext);
            init();
        }
    }

    public int getLayoutR() {
        return d.h.operable_video_container;
    }

    public void bUb() {
        int dimension;
        int i;
        int i2;
        int i3;
        int dimension2;
        int i4;
        int i5;
        this.hZH.af(this.hZO, this.hlV);
        this.hZI.af(this.hZO, this.hlV);
        if (this.mContext != null && this.mContext.getResources() != null) {
            if (this.hlV) {
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
                if (this.hZO) {
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
            this.hZC.getLayoutParams().height = i;
            this.hZC.setPadding(0, 0, 0, i3);
            this.ejv.setPadding(0, 0, i2, 0);
            this.hZF.setPadding(this.hZF.getPaddingLeft(), 0, i5, 0);
            this.hZE.setPadding(i4, 0, this.hZE.getPaddingLeft(), 0);
            this.hZD.setPadding(dimension2, 0, this.hZE.getPaddingLeft(), 0);
        }
    }

    public void bUc() {
        if (this.hZO) {
            this.hZo = 392;
            this.hZp = 390;
        } else {
            this.hZo = 904;
            this.hZp = 902;
        }
        if (this.hlV) {
            this.hZl |= 4096;
            this.hZm |= 4096;
            this.hZn |= 4096;
            this.hZo |= 4096;
            this.hZp |= 4096;
            this.hZq |= 4096;
            this.hZr |= 4096;
            this.hZu |= 4096;
            return;
        }
        this.hZl &= -4097;
        this.hZm &= -4097;
        this.hZn &= -4097;
        this.hZo &= -4097;
        this.hZp &= -4097;
        this.hZq &= -4097;
        this.hZr &= -4097;
        this.hZu &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (this.mContext != null) {
            this.hZM = (ViewGroup) LayoutInflater.from(this.mContext).inflate(getLayoutR(), (ViewGroup) null);
            if (this.mRootView instanceof ViewGroup) {
                ((ViewGroup) this.mRootView).addView(this.hZM);
            }
            this.btA = new WeakReference<>(TbadkCoreApplication.getInst());
            this.dbc = (QuickVideoView) this.hZM.findViewById(d.g.video_view);
            this.gIj = (TbImageView) this.hZM.findViewById(d.g.video_thumbnail);
            this.hZy = this.hZM.findViewById(d.g.black_mask_bottom);
            this.hZz = this.hZM.findViewById(d.g.black_mask_top);
            this.hZA = (TBLottieAnimationView) this.hZM.findViewById(d.g.video_play);
            this.hZC = this.hZM.findViewById(d.g.video_bottom_ctrl_layout);
            this.hZB = (ImageView) this.hZM.findViewById(d.g.video_pause);
            this.hZD = (TextView) this.hZM.findViewById(d.g.video_replay);
            this.ejv = (TextView) this.hZM.findViewById(d.g.video_play_count);
            this.eju = (TextView) this.hZM.findViewById(d.g.video_duration);
            this.hZE = (SwitchImageView) this.hZM.findViewById(d.g.video_mute);
            this.hZF = (SwitchImageView) this.hZM.findViewById(d.g.video_full_screen);
            this.hZG = (OperableVideoMediaControllerView) this.hZM.findViewById(d.g.video_media_controller);
            this.hZH = (OperableVideoNetworkStateTipView) this.hZM.findViewById(d.g.video_network_state_tip);
            this.hZI = (OperableVideoShareView) this.hZM.findViewById(d.g.video_share_view);
            this.hZJ = (ImageView) this.hZM.findViewById(d.g.video_full_screen_back);
            this.hZK = (VideoGestureView) this.hZM.findViewById(d.g.video_gesture);
            this.hZI.setVideoContainer(this);
            this.hZR = new n(this.mContext);
            this.dbc.setNeedRecovery(true);
            this.dbc.setPlayerReuseEnable(true);
            this.dbc.setContinuePlayEnable(true);
            this.hZR.a(new j.b() { // from class: com.baidu.tieba.play.operableVideoView.c.3
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (c.this.startPosition <= 0) {
                        c.this.startPosition = i2;
                    }
                    if (c.this.bUn() && !c.this.hZO && !c.this.hlV && c.this.XB) {
                        if (!com.baidu.mcn.b.sY().cR(c.this.iac.jump_url)) {
                            boolean z = ((long) i2) >= c.this.iac.ad_start_time.longValue() * 1000 && ((long) i2) < c.this.iac.ad_end_time.longValue() * 1000;
                            boolean z2 = c.this.startPosition >= (c.this.iac.ad_start_time.longValue() * 1000) + 1000;
                            if (z) {
                                if (!c.this.fxe.isShowing()) {
                                    com.baidu.mcn.a aVar = new com.baidu.mcn.a();
                                    aVar.aeK = c.this.iac.card_title;
                                    aVar.aeL = c.this.iac.button_title;
                                    aVar.aeM = c.this.iac.jump_url;
                                    aVar.aeJ = c.this.iac.pic_url;
                                    aVar.fid = String.valueOf(c.this.mFid);
                                    aVar.tid = c.this.ctu;
                                    aVar.aeN = c.this.bna();
                                    if (z2) {
                                        c.this.fxe.b(aVar, (ViewGroup) c.this.mRootView);
                                    } else {
                                        c.this.fxe.a(aVar, (ViewGroup) c.this.mRootView);
                                    }
                                }
                            } else if (c.this.fxe.isShowing()) {
                                c.this.fxe.dismiss();
                            }
                        } else {
                            return;
                        }
                    }
                    if (c.this.iad != null) {
                        c.this.iad.bx(i, i2);
                    }
                }
            });
            this.dbc.setBusiness(this.hZR);
            this.dbc.setOnPreparedListener(this);
            this.dbc.setOnCompletionListener(this);
            this.dbc.setOnErrorListener(this);
            this.dbc.setOnSurfaceDestroyedListener(this);
            this.dbc.setOnOutInfoListener(this);
            this.hZA.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZA.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hZA.setAnimation(d.i.lotti_video_loading);
            this.hZA.setOnClickListener(this);
            this.hZE.setStateImage(d.f.icon_vedio_pronunciation_small_white, d.f.icon_vedio_npronunciation_small_white);
            this.hZE.setState(1);
            this.hZE.setOnClickListener(this);
            this.gIj.setConrers(15);
            this.gIj.setRadius(l.h(this.mContext, d.e.tbds20));
            this.gIj.setDrawCorner(true);
            this.gIj.setDefaultBgResource(e.get());
            this.hZG.setPlayer(this.dbc);
            this.hZG.setOnSeekBarChangeListener(this.cNS);
            this.hZF.setStateImage(d.f.icon_vedio_full_screen, d.f.icon_vedio_narrow_screen);
            this.hZF.setState(0);
            this.hZF.setOnClickListener(this);
            this.hZB.setOnClickListener(this);
            this.hZD.setOnClickListener(this);
            this.hZH.setPlayViewOnClickListener(this);
            this.hZJ.setOnClickListener(this);
            this.hZM.setOnClickListener(null);
            this.hZM.setOnTouchListener(this.ccU);
            this.hZI.setOnTouchListener(this.ccU);
            this.mGestureDetector = new GestureDetector(this.mContext, this.iae);
            xs(this.hZl);
            this.ehN = new k();
            this.fxe = new com.baidu.mcn.c(this.mContext);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.Zi() != null) {
            this.startPosition = -1L;
            if (this.fxe != null) {
                this.fxe.reset();
            }
            if (!ap.equals(this.bNl, bgVar.Zi().video_url)) {
                this.hZO = bgVar.Zi().is_vertical.intValue() == 1;
                this.bNl = bgVar.Zi().video_url;
                this.ctu = bgVar.getTid();
                this.hZP = bgVar.Zi().video_length.intValue();
                this.hZQ = bgVar.Zi().video_duration.intValue();
                this.mFid = bgVar.getFid();
                this.iac = bgVar.Zi().mcn_ad_card;
                bUc();
                bUb();
                xs(this.hZl);
                int intValue = bgVar.Zi().video_duration.intValue() * 1000;
                this.hZG.xq(intValue);
                this.hZG.setPlayer(this.dbc);
                this.eju.setText(ap.hz(intValue));
                this.ejv.setText(String.format(this.mContext.getResources().getString(d.j.play_count_new), ap.az(bgVar.Zi().play_count.intValue())));
                this.hZH.setVideoLength(bgVar.Zi().video_length.intValue());
                this.hZH.setTid(this.ctu);
                this.hZR.bTz().g(bgVar.Zi());
                this.gIj.startLoad(bgVar.Zi().thumbnail_url, 10, false);
                this.hZI.setShareData(bgVar);
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void b(z zVar) {
        if (zVar != null && this.hZR != null) {
            this.hZR.setVideoStatsData(zVar);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public v bTz() {
        if (this.hZR == null) {
            return null;
        }
        return this.hZR.bTz();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNu = onClickListener;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Zr = bdUniqueId;
    }

    public void bUf() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZx);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hZx, this.hZk);
    }

    public void bUg() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hZx);
    }

    private void startLoadingAnim() {
        if (this.hZA != null) {
            this.hZA.G(true);
            this.hZA.setMinAndMaxFrame(14, 80);
            this.hZA.cu();
        }
    }

    protected void bUd() {
        if (this.hZu == this.hZn) {
            xs(this.hZm);
        }
    }

    private void bUh() {
        if (this.hZA != null) {
            this.hZA.clearAnimation();
            this.hZA.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.bUd();
                    if (c.this.hZN) {
                        c.this.startPlay();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    c.this.hZA.setFrame(0);
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
        MessageManager.getInstance().registerListener(this.iaf);
        if (this.hZH != null && this.hZH.bUo()) {
            xs(this.hZr);
            return;
        }
        this.hZN = true;
        if (!this.dbc.isPlaying()) {
            this.ehN.bEA();
            this.dbc.setVideoPath(this.bNl, this.ctu);
            startLoadingAnim();
            TiebaStatic.log(new am("c13357").bJ("tid", this.ctu).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZO ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).T("obj_locate", TbSingleton.getInstance().isVideoEnterMiddlePage() ? 1 : 2));
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        this.hZN = false;
        if (this.hZA != null) {
            this.hZA.cancelAnimation();
        }
        this.dbc.stopPlayback();
        this.hZG.awJ();
        xs(this.hZl);
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iaf);
    }

    public void xs(int i) {
        bUg();
        if (i == this.hZn) {
            if ("index".equals(this.mFrom)) {
                this.ehN.a(this.ctu, this.hZP, this.hZQ, "homepage", this.dbc);
            } else {
                this.ehN.a(this.ctu, this.hZP, this.hZQ, this.mFrom, this.dbc);
            }
        }
        if (this.hZu == this.hZs) {
            this.hZw = i;
            return;
        }
        this.hZu = i;
        this.gIj.setVisibility((i & 1) > 0 ? 0 : 8);
        this.hZy.setVisibility((i & 2) > 0 ? 0 : 8);
        this.hZz.setVisibility((i & 2) > 0 ? 0 : 8);
        boolean z = (i & 4) > 0;
        this.hZA.clearAnimation();
        this.hZA.setVisibility(z ? 0 : 8);
        if (!z) {
            this.hZA.setFrame(0);
            this.hZA.cancelAnimation();
        } else {
            this.hZA.setAlpha(1.0f);
        }
        this.hZB.setVisibility((i & 8) > 0 ? 0 : 8);
        this.hZD.setVisibility((i & 16) > 0 ? 0 : 8);
        this.ejv.setVisibility((i & 32) > 0 ? 0 : 8);
        this.eju.setVisibility((i & 64) > 0 ? 0 : 8);
        this.hZE.setVisibility((i & 128) > 0 ? 0 : 8);
        this.hZF.setVisibility((i & 256) > 0 ? 0 : 8);
        this.hZG.setVisibility((i & 512) > 0 ? 0 : 8);
        if (this.hZG.getVisibility() == 0) {
            this.hZG.showProgress();
        }
        this.hZH.setVisibility((i & 1024) > 0 ? 0 : 8);
        this.hZI.setVisibility((i & 2048) > 0 ? 0 : 8);
        if (this.hZI.getVisibility() == 0) {
            this.hZI.setAlpha(1.0f);
        }
        this.hZJ.setVisibility((i & 4096) > 0 ? 0 : 8);
        this.hZK.setVisibility((i & 8192) <= 0 ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == d.g.video_mute) {
                bUk();
            } else if (id == d.g.video_full_screen || id == d.g.video_full_screen_back) {
                bUm();
            } else if (id == d.g.video_replay) {
                xs(this.hZl);
                startPlay();
                TiebaStatic.log(new am("c13345").bJ("tid", this.ctu).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZO ? 1 : 2).T("obj_locate", this.hlV ? 1 : 2));
                bUi();
            } else if (id == d.g.video_play) {
                if (this.hZu == this.hZl) {
                    startPlay();
                } else {
                    xs(this.hZo);
                    bUf();
                    this.dbc.start();
                }
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctu).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZO ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlV ? 1 : 2).T("obj_locate", 1));
                bUi();
            } else if (id == d.g.video_pause) {
                xs(this.hZp);
                bUg();
                this.dbc.pause();
                TiebaStatic.log(new am("c13344").bJ("tid", this.ctu).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZO ? 1 : 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.hlV ? 1 : 2).T("obj_locate", 2));
            } else if (id == d.g.play) {
                startPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUi() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.bNl);
        CustomMessage customMessage = new CustomMessage(2921387);
        customMessage.setTag(this.Zr);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUj() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbc.setVolume(0.0f, 0.0f);
            this.hZE.setState(1);
            return;
        }
        this.dbc.setVolume(1.0f, 1.0f);
        this.hZE.setState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUk() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.dbc.setVolume(1.0f, 1.0f);
            ad.a(this.btA, true);
            this.hZE.setState(0);
        } else {
            this.dbc.setVolume(0.0f, 0.0f);
            this.hZE.setState(1);
            ad.a(this.btA, false);
        }
        TbSingleton.getInstance().setVideoCardMute(isVideoCardMute ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUl() {
        if (this.mRootView != null && this.hZM != null && this.dbc != null) {
            this.dbc.setFullScreenToDestroySurface();
            if (this.cVo == null) {
                this.cVo = new o((Activity) this.mContext);
            }
            if (this.hlV) {
                if (!this.hZO) {
                    this.cVo.bAB();
                }
                if (this.hZL.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.hZL.getParent()).removeView(this.hZL);
                }
                if ((this.hZM.getParent() instanceof ViewGroup) && (this.mRootView instanceof ViewGroup)) {
                    this.hlV = false;
                    ((ViewGroup) this.hZM.getParent()).removeView(this.hZM);
                    ((ViewGroup) this.mRootView).addView(this.hZM);
                    h((Activity) this.mContext, this.hlV);
                }
            } else {
                if (this.mContext != null) {
                    if (!this.hZO) {
                        this.cVo.bAB();
                    }
                    if (this.mContext instanceof Activity) {
                        this.hZM.getLocationOnScreen(this.hZV);
                        View findViewById = ((Activity) this.mContext).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                ((ViewGroup) this.mRootView).removeAllViews();
                                if (this.hZL == null) {
                                    this.hZL = new View(this.mContext);
                                    this.hZL.setClickable(true);
                                    this.hZL.setBackgroundColor(al.getColor(d.C0277d.black_alpha100));
                                    this.hZL.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.hZL.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.hZL.getParent()).removeView(this.hZL);
                                }
                                this.hZL.setAlpha(1.0f);
                                ((ViewGroup) childAt).addView(this.hZL);
                                ((ViewGroup) childAt).addView(this.hZM);
                                this.hlV = true;
                                h((Activity) this.mContext, this.hlV);
                                if (this.fxe != null && this.fxe.isShowing()) {
                                    this.fxe.dismiss();
                                }
                            }
                        }
                    }
                }
                TiebaStatic.log(new am("c13360").bJ("tid", this.ctu).k(ImageViewerConfig.FORUM_ID, this.mFid).T("obj_type", this.hZO ? 1 : 2));
            }
            bUc();
            bUb();
            if (this.dbc.isPlaying()) {
                xs(this.hZm);
            } else {
                this.hZu |= 1;
                xs(this.hZu);
            }
            this.hZF.cnf();
            ks(this.hlV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUm() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator ofFloat7;
        if (!this.hZO) {
            bUl();
        } else if (this.hZu == this.hZs) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.play.operableVideoView.c.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.hZM.setScaleX(1.0f);
                    c.this.hZM.setScaleY(1.0f);
                    c.this.hZM.setTranslationX(0.0f);
                    c.this.hZM.setTranslationY(0.0f);
                    c.this.hZI.setScaleX(1.0f);
                    c.this.hZI.setScaleY(1.0f);
                    c.this.hZM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    if (!c.this.hZX) {
                        c.this.bUl();
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
            if (!this.hZX) {
                float width = this.mRootView.getWidth() / this.hZM.getWidth();
                float height = this.mRootView.getHeight() / this.hZM.getHeight();
                this.hZM.setPivotX(0.0f);
                this.hZM.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZM, "ScaleX", 1.0f, width);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZM, "ScaleY", 1.0f, height);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZI, "ScaleX", 1.0f, 1.0f / width);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZI, "ScaleY", 1.0f, 1.0f / height);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZM, "TranslationX", this.hZM.getTranslationX(), this.hZV[0]);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZM, "TranslationY", this.hZM.getTranslationY(), this.hZV[1]);
                objectAnimator = ObjectAnimator.ofFloat(this.hZL, "alpha", this.hZL.getAlpha(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZI, "alpha", this.hZI.getAlpha(), 0.0f);
            } else {
                float width2 = this.hZT / this.hZM.getWidth();
                float height2 = this.hZW / this.hZM.getHeight();
                this.hZM.setPivotX(0.0f);
                this.hZM.setPivotY(0.0f);
                ofFloat = ObjectAnimator.ofFloat(this.hZM, "ScaleX", 1.0f, width2);
                ofFloat2 = ObjectAnimator.ofFloat(this.hZM, "ScaleY", 1.0f, height2);
                ofFloat3 = ObjectAnimator.ofFloat(this.hZI, "ScaleX", 1.0f, 1.0f / width2);
                ofFloat4 = ObjectAnimator.ofFloat(this.hZI, "ScaleY", 1.0f, 1.0f / height2);
                ofFloat5 = ObjectAnimator.ofFloat(this.hZM, "TranslationX", this.hZM.getTranslationX(), 0.0f);
                ofFloat6 = ObjectAnimator.ofFloat(this.hZM, "TranslationY", this.hZM.getTranslationY(), 0.0f);
                ofFloat7 = ObjectAnimator.ofFloat(this.hZI, "alpha", this.hZI.getAlpha(), 1.0f);
            }
            if (objectAnimator != null) {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(objectAnimator).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            } else {
                animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat3).with(ofFloat4);
            }
            animatorSet.start();
            if (this.hZw != -1) {
                this.hZu = this.hZw;
                this.hZw = -1;
                if (this.hZu == this.hZt || this.hZu == this.hZo || this.hZu == this.hZm) {
                    this.dbc.start();
                    xs(this.hZm);
                }
            }
        } else {
            bUl();
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
            this.hZM.setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ks(boolean z) {
    }

    @Override // com.baidu.tieba.play.g.f
    public void onPrepared(g gVar) {
        bUj();
        this.ehN.bEB();
        if (this.hZN) {
            if (this.hlV && (this.mContext instanceof Activity)) {
                h((Activity) this.mContext, true);
            }
            this.dbc.start();
            if (!this.dbc.getPlayer().isNewPlayer()) {
                xs(this.hZn);
                this.hZG.showProgress();
                bUh();
            }
        }
    }

    public void onCompletion(g gVar) {
        xs(this.hZq);
    }

    @Override // com.baidu.tieba.play.g.b
    public boolean onError(g gVar, int i, int i2) {
        return false;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        if (this.hZu == this.hZp) {
            stopPlay();
            xs(this.hZp);
        } else if (this.hZu == this.hZq) {
            stopPlay();
            xs(this.hZq);
        } else {
            stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.g.e
    public boolean onInfo(g gVar, int i, int i2) {
        if (i == 3) {
            xs(this.hZn);
            this.hZG.showProgress();
            bUh();
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public View bSZ() {
        return this.hZM;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        return this.hZN || this.dbc.isPlaying();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public int getCurrentPosition() {
        return this.dbc.getCurrentPosition();
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bTZ() {
    }

    private void bAA() {
        if (Build.VERSION.SDK_INT < 16) {
            this.hZM.setSystemUiVisibility(2);
        } else if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
            this.hZM.setSystemUiVisibility(4);
        } else {
            this.hZM.setSystemUiVisibility(5894);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public void bUa() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.dbc.setVolume(1.0f, 1.0f);
            this.hZE.setState(0);
            TbSingleton.getInstance().setVideoCardMute(false);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (z) {
            this.hZA.cancelAnimation();
            if (this.hZu == this.hZm || this.hZu == this.hZn || this.hZu == this.hZo || this.hZu == this.hZl) {
                stopPlay();
            }
            this.hZu |= 1;
            xs(this.hZu);
        } else if (this.hZu == this.hZl) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean isFullScreen() {
        return this.hlV;
    }

    @Override // com.baidu.tieba.play.operableVideoView.a
    public boolean onBackPress() {
        if (this.hlV) {
            bUm();
            return true;
        }
        return false;
    }

    protected int bna() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bUn() {
        return this.iac != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pe(boolean z) {
        this.XB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.iad = aVar;
    }
}
