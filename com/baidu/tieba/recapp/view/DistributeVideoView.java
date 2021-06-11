package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoSwitchManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.tencent.connect.common.Constants;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.b.g.b;
import d.a.m0.r.s.a;
import d.a.m0.z0.m0;
import d.a.n0.a;
import d.a.n0.e3.v;
import d.a.n0.t2.f0.b.f;
import d.a.n0.t2.i0.c;
import d.a.n0.t2.i0.g;
import d.a.n0.t2.j0.d;
import d.a.n0.t2.j0.e;
import d.a.n0.t2.n;
import d.a.n0.t2.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class DistributeVideoView extends RelativeLayout implements n {
    public ImageView A;
    public VideoControllerView B;
    public TbImageView C;
    public RelativeLayout D;
    public WeakReference<Context> E;
    public int F;
    public long G;
    public boolean H;
    public long I;
    public int J;
    public AdCard K;
    public String L;
    public Animation M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public boolean U;
    public int V;
    public View.OnClickListener W;
    public Handler a0;
    public CyberPlayerManager.OnPreparedListener b0;
    public CyberPlayerManager.OnInfoListener c0;
    public CyberPlayerManager.OnErrorListener d0;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f20350e;
    public CyberPlayerManager.OnCompletionListener e0;

    /* renamed from: f  reason: collision with root package name */
    public Context f20351f;
    public TbCyberVideoView.g f0;

    /* renamed from: g  reason: collision with root package name */
    public View f20352g;
    public Runnable g0;

    /* renamed from: h  reason: collision with root package name */
    public View f20353h;
    public Runnable h0;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f20354i;
    public Runnable i0;
    public f j;
    public CustomMessageListener j0;
    public d k;
    public CustomMessageListener k0;
    public e l;
    public CustomMessageListener l0;
    public ViewGroup m;
    public AdvertAppInfo n;
    public int o;
    public String p;
    public TbCyberVideoView q;
    public TBLottieAnimationView r;
    public ForeDrawableImageView s;
    public TextView t;
    public View u;
    public ImageView v;
    public ImageView w;
    public View x;
    public TextView y;
    public View z;

    public DistributeVideoView(Context context) {
        super(context);
        this.E = null;
        this.F = -1;
        this.G = 0L;
        this.H = false;
        this.I = 0L;
        this.J = 1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.T = 2;
        this.V = 1;
        this.W = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.x) {
                    DistributeVideoView.this.x.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view != DistributeVideoView.this.w && view != DistributeVideoView.this.v) {
                    if (view == DistributeVideoView.this.r || view == DistributeVideoView.this.A) {
                        DistributeVideoView.this.c0();
                    } else if (DistributeVideoView.this.K == null) {
                        DistributeVideoView.this.c0();
                    } else {
                        int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.S();
                        if (y.p(jump2DownloadDetailPage)) {
                            DistributeVideoView.this.U(jump2DownloadDetailPage);
                        }
                    }
                } else {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.l0(!distributeVideoView.H);
                }
            }
        };
        this.a0 = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 != 1001) {
                    if (i2 == 1003 && DistributeVideoView.this.F == 1) {
                        if (DistributeVideoView.this.G == DistributeVideoView.this.q.getCurrentPosition()) {
                            DistributeVideoView.this.g0();
                        } else {
                            DistributeVideoView distributeVideoView = DistributeVideoView.this;
                            distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                            DistributeVideoView.this.setLoadingAnimShow(false);
                        }
                        DistributeVideoView.this.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                    }
                } else if (DistributeVideoView.this.F == 1) {
                } else {
                    if (!a.h().u() ? DistributeVideoView.this.q.getCurrentPosition() <= 0 : !DistributeVideoView.this.q.isPlaying()) {
                        DistributeVideoView.this.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                        return;
                    }
                    DistributeVideoView.this.F = 1;
                    DistributeVideoView.this.W();
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                DistributeVideoView.this.q.setVolume(0.0f, 0.0f);
                DistributeVideoView.this.a0.removeMessages(1001);
                DistributeVideoView.this.a0.sendEmptyMessage(1001);
                if (DistributeVideoView.this.H && DistributeVideoView.this.J == 1) {
                    DistributeVideoView.this.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (i2 == 3 && DistributeVideoView.this.n != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    int i4 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.T3)) ? 35 : 31;
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.i0(i4, distributeVideoView2.X(distributeVideoView2.T), 0);
                }
                return false;
            }
        };
        this.d0 = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                DistributeVideoView.this.k0();
                if (DistributeVideoView.this.q != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), DistributeVideoView.this.q.getCurrentPosition());
                }
                DistributeVideoView.this.s.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.x.setVisibility(0);
                return true;
            }
        };
        this.e0 = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.I = System.currentTimeMillis();
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.S = true;
                if (distributeVideoView.q != null) {
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), DistributeVideoView.this.q.getDuration());
                }
                DistributeVideoView.this.k0();
                if (DistributeVideoView.this.l != null) {
                    DistributeVideoView.this.l.e();
                    DistributeVideoView.this.t.setVisibility(8);
                    DistributeVideoView.this.u.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.f0 = new TbCyberVideoView.g() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.g0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.f20354i == null || DistributeVideoView.this.q == null || !DistributeVideoView.this.canPlay()) {
                    return;
                }
                DistributeVideoView.this.h0(1);
            }
        };
        this.h0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.Y();
            }
        };
        this.i0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.f0(false);
            }
        };
        this.j0 = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.P) {
                            DistributeVideoView.this.l0(true);
                            return;
                        } else {
                            DistributeVideoView.this.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.P = distributeVideoView.H;
                    DistributeVideoView.this.l0(true);
                }
            }
        };
        this.k0 = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.l0(true);
                    }
                }
            }
        };
        this.l0 = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.f0(true);
            }
        };
        Z(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        d0();
        if (z) {
            this.r.setAlpha(1.0f);
            this.r.setVisibility(0);
            return;
        }
        this.r.setVisibility(8);
    }

    public final boolean R() {
        if (this.J == 1) {
            return v.a();
        }
        return j.H();
    }

    public final void S() {
        i0(2, 1, 0);
    }

    public final void T(AdvertAppInfo advertAppInfo, int i2, String str) {
        advertAppInfo.T3 = str;
        c l = g.l(this.n, 303, i2, X(this.T), this.f20354i.video_duration.intValue(), this.R, -1);
        e eVar = this.l;
        if (eVar != null) {
            eVar.k(l);
        }
    }

    public final void U(int i2) {
        VideoInfo videoInfo;
        AdvertAppInfo advertAppInfo = this.n;
        if (advertAppInfo == null || (videoInfo = this.f20354i) == null) {
            return;
        }
        advertAppInfo.T3 = this.p;
        c l = g.l(advertAppInfo, SDKLogTypeConstants.CLOSE_GAME_TYPE, this.o, 1, videoInfo.video_duration.intValue(), d.a.n0.q.g.a.a(0), -1);
        boolean z = i2 == 1000;
        l.c(z ? "APP" : "URL");
        if (!z) {
            l.l(i2);
        }
        l.h("DEEPLINK");
        d.a.n0.t2.i0.e.b().d(l);
    }

    public final void V() {
        d.a.c.e.m.e.a().removeCallbacks(this.i0);
        d.a.c.e.m.e.a().postDelayed(this.i0, 5000L);
    }

    public final void W() {
        TBLottieAnimationView tBLottieAnimationView = this.r;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.clearAnimation();
            this.r.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.r.setMinFrame(0);
                    DistributeVideoView.this.r.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.r.setVisibility(8);
                    DistributeVideoView.this.s.setVisibility(8);
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.l0(distributeVideoView.H);
                    if (DistributeVideoView.this.J == 1) {
                        DistributeVideoView.this.t.setVisibility(8);
                        DistributeVideoView.this.u.setVisibility(8);
                    } else {
                        DistributeVideoView.this.B.setPlayer(DistributeVideoView.this.q);
                        DistributeVideoView.this.B.p(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.f20354i.video_duration.intValue()));
                        DistributeVideoView.this.B.s();
                        DistributeVideoView.this.e0(true);
                        d.a.c.e.m.e.a().removeCallbacks(DistributeVideoView.this.h0);
                        d.a.c.e.m.e.a().postDelayed(DistributeVideoView.this.h0, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.G = distributeVideoView2.q.getCurrentPosition();
                    DistributeVideoView.this.f0(true);
                    DistributeVideoView.this.a0.removeMessages(1003);
                    DistributeVideoView.this.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    public final int X(int i2) {
        return i2 == 1 ? 0 : 1;
    }

    public final void Y() {
        Animation animation;
        if (this.N || (animation = this.M) == null) {
            return;
        }
        this.z.startAnimation(animation);
        this.N = true;
    }

    public final void Z(Context context) {
        if (context == null) {
            return;
        }
        this.f20351f = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
        this.f20353h = inflate;
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.distribute_texture);
        this.q = tbCyberVideoView;
        tbCyberVideoView.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.q.setNoBussinessStats();
        this.r = (TBLottieAnimationView) this.f20353h.findViewById(R.id.video_play);
        this.s = (ForeDrawableImageView) this.f20353h.findViewById(R.id.distribute_thumbnail);
        this.t = (TextView) this.f20353h.findViewById(R.id.distribute_count_process);
        this.u = this.f20353h.findViewById(R.id.black_mask_top);
        this.x = this.f20353h.findViewById(R.id.distribute_error_tip);
        this.y = (TextView) this.f20353h.findViewById(R.id.distribute_error_tip_text);
        this.v = (ImageView) this.f20353h.findViewById(R.id.distribute_voice_feed);
        View findViewById = this.f20353h.findViewById(R.id.distribute_control);
        this.z = findViewById;
        this.A = (ImageView) findViewById.findViewById(R.id.distribute_play_icon);
        this.w = (ImageView) this.z.findViewById(R.id.distribute_voice);
        this.B = (VideoControllerView) this.z.findViewById(R.id.distribute_process);
        FrameLayout frameLayout = (FrameLayout) this.f20353h.findViewById(R.id.tail_frame_container);
        this.m = frameLayout;
        this.k = new d(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.f20353h.findViewById(R.id.bottom_picture);
        this.C = tbImageView;
        tbImageView.setVisibility(8);
        this.D = (RelativeLayout) this.f20353h.findViewById(R.id.video_container);
        this.r.setAnimation(R.raw.lotti_video_loading);
        this.r.setMinFrame(0);
        this.r.setFrame(0);
        b.f(this.u, R.drawable.video_mask_bg);
    }

    public final void a0() {
        TbPageContext<?> tbPageContext = this.f20350e;
        if (tbPageContext == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
        this.M = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                DistributeVideoView.this.z.setVisibility(8);
                DistributeVideoView.this.N = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void autoContinue() {
        if (this.O) {
            return;
        }
        continuePlay(1);
    }

    @Override // d.a.n0.t2.n
    public void autoPlay(int i2) {
        if (R()) {
            if (i2 <= 0) {
                h0(1);
                return;
            }
            d.a.c.e.m.e.a().removeCallbacks(this.g0);
            d.a.c.e.m.e.a().postDelayed(this.g0, TimeUnit.SECONDS.toMillis(i2));
        }
    }

    public final int b0() {
        String str = this.K.scheme;
        if (!TextUtils.isEmpty(this.L)) {
            str = this.L;
        }
        if (TextUtils.isEmpty(str) || this.f20351f == null) {
            return 0;
        }
        if (y.B(this.n, str)) {
            return 3;
        }
        if (isPlaying() && a.h().t()) {
            return y.d(this.f20351f, str, this.n.getDownloadId(), this.n.Q3);
        }
        return y.g(this.f20351f, str, this.n);
    }

    public final void c0() {
        TbPageContext<?> tbPageContext;
        TbPageContext<?> tbPageContext2;
        int i2 = this.F;
        if (i2 == -1) {
            if (!j.z() && (tbPageContext2 = this.f20350e) != null) {
                tbPageContext2.showToast(R.string.neterror);
            } else if (!j.H() && (tbPageContext = this.f20350e) != null) {
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(tbPageContext.getPageActivity());
                aVar.setMessageId(R.string.play_video_mobile_tip);
                aVar.setPositiveButton(R.string.alert_yes_button, new a.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                    @Override // d.a.m0.r.s.a.e
                    public void onClick(d.a.m0.r.s.a aVar2) {
                        aVar2.dismiss();
                        DistributeVideoView.this.performPlay();
                    }
                });
                aVar.setNegativeButton(R.string.cancel, new a.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                    @Override // d.a.m0.r.s.a.e
                    public void onClick(d.a.m0.r.s.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.create(this.f20350e).show();
            } else {
                performPlay();
            }
        } else if (i2 == 0) {
            stopPlay();
        } else if (i2 == 1) {
            this.O = true;
            pausePlay(0);
            if (this.J == 2) {
                e0(true);
            }
        } else if (i2 != 2) {
        } else {
            this.O = false;
            continuePlay(2);
            if (this.J == 2) {
                d.a.c.e.m.e.a().removeCallbacks(this.h0);
                d.a.c.e.m.e.a().postDelayed(this.h0, TimeUnit.SECONDS.toMillis(3L));
            }
        }
    }

    @Override // d.a.n0.t2.n
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.i(this.f20351f);
    }

    public void continuePlay(int i2) {
        if (this.F != 2) {
            return;
        }
        this.T = i2;
        i0(33, X(i2), this.q.getCurrentPosition());
        this.q.getCurrentPosition();
        this.q.start();
        if (this.H) {
            m0.e(this.E, true);
        }
        setLoadingAnimShow(false);
        SkinManager.setImageResource(this.A, R.drawable.icon_video_midplay);
        this.F = 1;
    }

    public final void d0() {
        TBLottieAnimationView tBLottieAnimationView = this.r;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setMinFrame(0);
            this.r.setFrame(0);
            this.r.cancelAnimation();
        }
    }

    public final void e0(boolean z) {
        if (z) {
            d.a.c.e.m.e.a().removeCallbacks(this.h0);
            Animation animation = this.M;
            if (animation != null) {
                animation.cancel();
            }
            this.z.setVisibility(0);
            if (this.F == 1) {
                SkinManager.setImageResource(this.A, R.drawable.icon_video_midplay);
                return;
            } else {
                SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.z.setVisibility(8);
    }

    public final void f0(boolean z) {
        ImageView imageView = this.v;
        if (imageView == null || this.J != 1) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
            V();
            return;
        }
        imageView.setVisibility(8);
    }

    public final void g0() {
        TBLottieAnimationView tBLottieAnimationView = this.r;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setAlpha(1.0f);
            this.r.setVisibility(0);
            this.r.loop(true);
            this.r.setMinAndMaxFrame(14, 80);
            this.r.playAnimation();
        }
    }

    @Override // d.a.n0.t2.n
    public long getCurrentPosition() {
        return this.G;
    }

    public VideoInfo getData() {
        return this.f20354i;
    }

    @Override // d.a.n0.t2.n
    public int getPlayStatus() {
        return this.F;
    }

    @Override // d.a.n0.t2.n
    public String getPlayUrl() {
        VideoInfo videoInfo = this.f20354i;
        return videoInfo != null ? videoInfo.video_url : "";
    }

    @Override // d.a.n0.t2.n
    public View getVideoContainer() {
        return this;
    }

    public final void h0(int i2) {
        this.T = i2;
        if (this.f20354i != null && this.F == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.I) < TimeUnit.SECONDS.toSeconds(3L)) {
                return;
            }
            e eVar = this.l;
            if (eVar != null) {
                eVar.f();
            }
            this.q.setVideoPath(this.f20354i.video_url);
            this.q.setVideoScalingMode(this.V);
            this.q.start();
            this.q.getCurrentPosition();
            SkinManager.setImageResource(this.A, R.drawable.icon_video_midplay);
            g0();
            this.x.setVisibility(8);
            this.s.setForegroundDrawable(0);
            this.F = 0;
            if (this.J == 1) {
                this.t.setVisibility(0);
                this.u.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
            TbPageContext<?> tbPageContext = this.f20350e;
            if (tbPageContext != null) {
                tbPageContext.registerListener(this.l0);
                this.f20350e.registerListener(this.j0);
                this.f20350e.registerListener(this.k0);
            }
            i0(31, X(this.T), 0);
        }
    }

    public final void i0(int i2, int i3, int i4) {
        j0(i2, i3, i4, -1);
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20353h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        if (z) {
            int k = l.k(getContext());
            int c2 = d.a.n0.t2.f0.c.a.c(k);
            layoutParams.width = l.k(getContext());
            layoutParams.height = k;
            layoutParams2.width = c2;
            layoutParams2.height = k;
            layoutParams3.width = c2;
            layoutParams3.height = k;
            layoutParams4.width = c2;
            layoutParams4.height = k;
            SkinManager.setBackgroundColor(this, R.color.black_alpha100);
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        }
        this.q.requestLayout();
    }

    @Override // d.a.n0.t2.n
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // d.a.n0.t2.n
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    public final void j0(int i2, int i3, int i4, int i5) {
        VideoInfo videoInfo;
        AdvertAppInfo advertAppInfo = this.n;
        if (advertAppInfo == null || (videoInfo = this.f20354i) == null) {
            return;
        }
        advertAppInfo.T3 = this.p;
        d.a.n0.t2.i0.e.b().d(g.l(advertAppInfo, i2, this.o, i3, videoInfo.video_duration.intValue(), d.a.n0.q.g.a.a(i4), i5));
    }

    public int jump2DownloadDetailPage() {
        return b0();
    }

    public final void k0() {
        d.a.c.e.m.e.a().removeCallbacks(this.g0);
        d.a.c.e.m.e.a().removeCallbacks(this.h0);
        d.a.c.e.m.e.a().removeCallbacks(this.i0);
        this.a0.removeMessages(1001);
        this.a0.removeMessages(1003);
        this.q.stopPlayback();
        this.F = -1;
        m0.e(this.E, false);
        f0(false);
        this.s.setForegroundDrawable(0);
        this.s.setVisibility(0);
        setLoadingAnimShow(true);
        SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
        this.B.q();
        this.x.setVisibility(8);
        VideoInfo videoInfo = this.f20354i;
        if (videoInfo != null) {
            this.t.setText(StringUtils.translateSecondsToString(videoInfo.video_duration.intValue()));
            this.t.setVisibility(0);
            this.u.setVisibility(0);
        }
        this.P = false;
        MessageManager.getInstance().unRegisterListener(this.l0);
        MessageManager.getInstance().unRegisterListener(this.j0);
        MessageManager.getInstance().unRegisterListener(this.k0);
    }

    public final void l0(boolean z) {
        if (z) {
            TbCyberVideoView tbCyberVideoView = this.q;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(1.0f, 1.0f);
            }
            SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_open);
            SkinManager.setImageResource(this.v, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.F == 1) {
                m0.e(this.E, true);
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.q;
            if (tbCyberVideoView2 != null) {
                tbCyberVideoView2.setVolume(0.0f, 0.0f);
            }
            SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_close);
            SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
            m0.e(this.E, false);
        }
        this.H = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AdCard adCard;
        super.onAttachedToWindow();
        if (!(this.l instanceof d.a.n0.t2.j0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
            return;
        }
        ((d.a.n0.t2.j0.a) this.l).w();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AdCard adCard;
        super.onDetachedFromWindow();
        if (!(this.l instanceof d.a.n0.t2.j0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
            return;
        }
        ((d.a.n0.t2.j0.a) this.l).B();
    }

    public void pausePlay(int i2) {
        if (this.F != 1) {
            return;
        }
        j0(32, X(this.T), this.q.getCurrentPosition(), i2);
        this.q.pause();
        m0.e(this.E, false);
        setLoadingAnimShow(true);
        SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
        this.F = 2;
    }

    public void performPlay() {
        h0(2);
    }

    @Override // d.a.n0.t2.n
    public void release() {
    }

    public void setAdInfo(AdCard adCard) {
        this.K = adCard;
    }

    public void setData(VideoInfo videoInfo, int i2, TbPageContext<?> tbPageContext) {
        if (i2 != 1 && i2 != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.J = i2;
        if (tbPageContext != null) {
            this.f20350e = tbPageContext;
            a0();
        }
        setData(videoInfo);
    }

    public void setDownloadCallback(d.a.n0.k1.o.c cVar) {
        e eVar = this.l;
        if (eVar != null) {
            eVar.h(cVar);
        }
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.f20352g = view;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.f20350e = tbPageContext;
    }

    public void setScheme(String str) {
        this.L = str;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i2, String str) {
        this.n = advertAppInfo;
        this.o = i2;
        this.p = str;
        T(advertAppInfo, i2, str);
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.U = z;
    }

    public void setVideoScalingMode(int i2) {
        this.V = i2;
        this.q.setVideoScalingMode(i2);
    }

    public void setVideoTailFrameData(f fVar) {
        this.j = fVar;
    }

    @Override // d.a.n0.t2.n
    public void startPlay() {
        autoPlay(0);
    }

    @Override // d.a.n0.t2.n
    public void stopPlay() {
        stopPlay(true);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.n;
        }
        e b2 = this.k.b(this.j, this.l);
        this.l = b2;
        if (b2 != null) {
            b2.j(this.f20350e);
            this.l.i(this.K);
            e eVar = this.l;
            if (eVar instanceof d.a.n0.t2.j0.a) {
                ((d.a.n0.t2.j0.a) eVar).y(this.U);
            }
            this.l.g(advertAppInfo);
            this.l.d(this.j);
            this.l.f();
        }
    }

    public void stopPlay(boolean z) {
        if (this.q.getCurrentPosition() > 0 && this.F != -1 && z) {
            int currentPosition = this.q.getCurrentPosition();
            i0(this.q.getDuration() == currentPosition ? 34 : 32, X(this.T), currentPosition);
        }
        k0();
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.f20354i = videoInfo;
        this.R = videoInfo.video_duration.intValue() * 1000;
        this.E = new WeakReference<>(this.f20351f.getApplicationContext());
        k0();
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        int k = l.k(this.f20351f) - l.g(this.f20351f, R.dimen.ds146);
        if (this.J == 2) {
            k = l.k(this.f20351f);
        }
        int intValue = this.f20354i.video_width.intValue() > 0 ? (this.f20354i.video_height.intValue() * k) / this.f20354i.video_width.intValue() : k;
        ViewGroup.LayoutParams layoutParams = this.f20353h.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = k;
            layoutParams.height = intValue;
            this.f20353h.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.W);
        this.s.setDefaultResource(0);
        this.s.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!k.isEmpty(videoInfo.thumbnail_url)) {
            this.s.U(videoInfo.thumbnail_url, 10, false);
        }
        this.q.setOnPreparedListener(this.b0);
        if (d.a.n0.a.h().u()) {
            this.q.setVideoPath(videoInfo.video_url);
            CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
        }
        this.q.setOnErrorListener(this.d0);
        this.q.setOnCompletionListener(this.e0);
        this.q.setOnInfoListener(this.c0);
        this.q.setOnSurfaceDestroyedListener(this.f0);
        SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
        this.t.setText(StringUtils.translateSecondsToString(this.f20354i.video_duration.intValue()));
        if (this.J == 1) {
            this.H = false;
            SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
            this.v.setVisibility(8);
        } else {
            this.H = true;
            SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_open);
            this.v.setVisibility(8);
        }
        this.q.setIsVolume0(!this.H);
        this.w.setOnClickListener(this.W);
        this.v.setOnClickListener(this.W);
        this.x.setOnClickListener(this.W);
        this.x.setVisibility(8);
        SkinManager.setBackgroundColor(this.x, R.color.black_alpha80);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0101);
        if (this.J == 1) {
            this.u.setVisibility(0);
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
        this.A.setOnClickListener(this.W);
        this.r.setOnClickListener(this.W);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = null;
        this.F = -1;
        this.G = 0L;
        this.H = false;
        this.I = 0L;
        this.J = 1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.T = 2;
        this.V = 1;
        this.W = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.x) {
                    DistributeVideoView.this.x.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view != DistributeVideoView.this.w && view != DistributeVideoView.this.v) {
                    if (view == DistributeVideoView.this.r || view == DistributeVideoView.this.A) {
                        DistributeVideoView.this.c0();
                    } else if (DistributeVideoView.this.K == null) {
                        DistributeVideoView.this.c0();
                    } else {
                        int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.S();
                        if (y.p(jump2DownloadDetailPage)) {
                            DistributeVideoView.this.U(jump2DownloadDetailPage);
                        }
                    }
                } else {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.l0(!distributeVideoView.H);
                }
            }
        };
        this.a0 = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 != 1001) {
                    if (i2 == 1003 && DistributeVideoView.this.F == 1) {
                        if (DistributeVideoView.this.G == DistributeVideoView.this.q.getCurrentPosition()) {
                            DistributeVideoView.this.g0();
                        } else {
                            DistributeVideoView distributeVideoView = DistributeVideoView.this;
                            distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                            DistributeVideoView.this.setLoadingAnimShow(false);
                        }
                        DistributeVideoView.this.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                    }
                } else if (DistributeVideoView.this.F == 1) {
                } else {
                    if (!d.a.n0.a.h().u() ? DistributeVideoView.this.q.getCurrentPosition() <= 0 : !DistributeVideoView.this.q.isPlaying()) {
                        DistributeVideoView.this.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                        return;
                    }
                    DistributeVideoView.this.F = 1;
                    DistributeVideoView.this.W();
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                DistributeVideoView.this.q.setVolume(0.0f, 0.0f);
                DistributeVideoView.this.a0.removeMessages(1001);
                DistributeVideoView.this.a0.sendEmptyMessage(1001);
                if (DistributeVideoView.this.H && DistributeVideoView.this.J == 1) {
                    DistributeVideoView.this.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i3, Object obj) {
                if (i2 == 3 && DistributeVideoView.this.n != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    int i4 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.T3)) ? 35 : 31;
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.i0(i4, distributeVideoView2.X(distributeVideoView2.T), 0);
                }
                return false;
            }
        };
        this.d0 = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i3, Object obj) {
                DistributeVideoView.this.k0();
                if (DistributeVideoView.this.q != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), DistributeVideoView.this.q.getCurrentPosition());
                }
                DistributeVideoView.this.s.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.x.setVisibility(0);
                return true;
            }
        };
        this.e0 = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.I = System.currentTimeMillis();
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.S = true;
                if (distributeVideoView.q != null) {
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), DistributeVideoView.this.q.getDuration());
                }
                DistributeVideoView.this.k0();
                if (DistributeVideoView.this.l != null) {
                    DistributeVideoView.this.l.e();
                    DistributeVideoView.this.t.setVisibility(8);
                    DistributeVideoView.this.u.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.f0 = new TbCyberVideoView.g() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.g0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.f20354i == null || DistributeVideoView.this.q == null || !DistributeVideoView.this.canPlay()) {
                    return;
                }
                DistributeVideoView.this.h0(1);
            }
        };
        this.h0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.Y();
            }
        };
        this.i0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.f0(false);
            }
        };
        this.j0 = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.P) {
                            DistributeVideoView.this.l0(true);
                            return;
                        } else {
                            DistributeVideoView.this.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.P = distributeVideoView.H;
                    DistributeVideoView.this.l0(true);
                }
            }
        };
        this.k0 = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.l0(true);
                    }
                }
            }
        };
        this.l0 = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.f0(true);
            }
        };
        Z(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.E = null;
        this.F = -1;
        this.G = 0L;
        this.H = false;
        this.I = 0L;
        this.J = 1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.T = 2;
        this.V = 1;
        this.W = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.x) {
                    DistributeVideoView.this.x.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view != DistributeVideoView.this.w && view != DistributeVideoView.this.v) {
                    if (view == DistributeVideoView.this.r || view == DistributeVideoView.this.A) {
                        DistributeVideoView.this.c0();
                    } else if (DistributeVideoView.this.K == null) {
                        DistributeVideoView.this.c0();
                    } else {
                        int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.S();
                        if (y.p(jump2DownloadDetailPage)) {
                            DistributeVideoView.this.U(jump2DownloadDetailPage);
                        }
                    }
                } else {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.l0(!distributeVideoView.H);
                }
            }
        };
        this.a0 = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i22 = message.what;
                if (i22 != 1001) {
                    if (i22 == 1003 && DistributeVideoView.this.F == 1) {
                        if (DistributeVideoView.this.G == DistributeVideoView.this.q.getCurrentPosition()) {
                            DistributeVideoView.this.g0();
                        } else {
                            DistributeVideoView distributeVideoView = DistributeVideoView.this;
                            distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                            DistributeVideoView.this.setLoadingAnimShow(false);
                        }
                        DistributeVideoView.this.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                    }
                } else if (DistributeVideoView.this.F == 1) {
                } else {
                    if (!d.a.n0.a.h().u() ? DistributeVideoView.this.q.getCurrentPosition() <= 0 : !DistributeVideoView.this.q.isPlaying()) {
                        DistributeVideoView.this.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                        return;
                    }
                    DistributeVideoView.this.F = 1;
                    DistributeVideoView.this.W();
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                DistributeVideoView.this.q.setVolume(0.0f, 0.0f);
                DistributeVideoView.this.a0.removeMessages(1001);
                DistributeVideoView.this.a0.sendEmptyMessage(1001);
                if (DistributeVideoView.this.H && DistributeVideoView.this.J == 1) {
                    DistributeVideoView.this.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i22, int i3, Object obj) {
                if (i22 == 3 && DistributeVideoView.this.n != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    int i4 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.T3)) ? 35 : 31;
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.i0(i4, distributeVideoView2.X(distributeVideoView2.T), 0);
                }
                return false;
            }
        };
        this.d0 = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i22, int i3, Object obj) {
                DistributeVideoView.this.k0();
                if (DistributeVideoView.this.q != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), DistributeVideoView.this.q.getCurrentPosition());
                }
                DistributeVideoView.this.s.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.x.setVisibility(0);
                return true;
            }
        };
        this.e0 = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.I = System.currentTimeMillis();
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.S = true;
                if (distributeVideoView.q != null) {
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), DistributeVideoView.this.q.getDuration());
                }
                DistributeVideoView.this.k0();
                if (DistributeVideoView.this.l != null) {
                    DistributeVideoView.this.l.e();
                    DistributeVideoView.this.t.setVisibility(8);
                    DistributeVideoView.this.u.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.f0 = new TbCyberVideoView.g() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.g0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.f20354i == null || DistributeVideoView.this.q == null || !DistributeVideoView.this.canPlay()) {
                    return;
                }
                DistributeVideoView.this.h0(1);
            }
        };
        this.h0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.Y();
            }
        };
        this.i0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.f0(false);
            }
        };
        this.j0 = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.P) {
                            DistributeVideoView.this.l0(true);
                            return;
                        } else {
                            DistributeVideoView.this.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.P = distributeVideoView.H;
                    DistributeVideoView.this.l0(true);
                }
            }
        };
        this.k0 = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.l0(true);
                    }
                }
            }
        };
        this.l0 = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.f0(true);
            }
        };
        Z(context);
    }

    public void setData(VideoInfo videoInfo, d.a.n0.t2.f0.b.e eVar, int i2, int i3, int i4, int i5) {
        int i6;
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.f20354i = videoInfo;
        this.E = new WeakReference<>(this.f20351f.getApplicationContext());
        k0();
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20353h.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i5;
        setOnClickListener(this.W);
        int i7 = 13;
        if (eVar != null && eVar.a()) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams2.width = i4;
            layoutParams2.height = i5;
            this.C.U(eVar.f64766a, 30, false);
            this.C.setVisibility(0);
            double d2 = eVar.f64767b;
            if (d2 > 0.0d) {
                i2 = (int) (i4 * d2);
                i3 = d.a.n0.t2.f0.c.a.b(i2);
            }
            double d3 = eVar.f64768c;
            i6 = d3 > 0.0d ? Math.min((int) (i4 * d3), i4 - i2) : 0;
            i7 = 11;
        } else {
            this.C.setVisibility(8);
            i6 = 0;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams3.width = i2;
        layoutParams3.height = i3;
        layoutParams3.rightMargin = i6;
        layoutParams3.addRule(i7);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        layoutParams4.width = i2;
        layoutParams4.height = i3;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams5.width = i2;
        layoutParams5.height = i3;
        this.s.setDefaultResource(0);
        this.s.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!k.isEmpty(videoInfo.thumbnail_url)) {
            this.s.U(videoInfo.thumbnail_url, 10, false);
        }
        this.q.setOnPreparedListener(this.b0);
        if (d.a.n0.a.h().u()) {
            this.q.setVideoPath(videoInfo.video_url);
            CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
        }
        this.q.setOnErrorListener(this.d0);
        this.q.setOnCompletionListener(this.e0);
        this.q.setOnInfoListener(this.c0);
        this.q.setOnSurfaceDestroyedListener(this.f0);
        SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
        this.t.setText(StringUtils.translateSecondsToString(this.f20354i.video_duration.intValue()));
        if (this.J == 1) {
            this.H = false;
            SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
            this.v.setVisibility(8);
        } else {
            this.H = true;
            SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_open);
            this.v.setVisibility(8);
        }
        this.q.setIsVolume0(!this.H);
        this.w.setOnClickListener(this.W);
        this.v.setOnClickListener(this.W);
        this.x.setOnClickListener(this.W);
        this.x.setVisibility(8);
        SkinManager.setBackgroundColor(this.x, R.color.black_alpha80);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0101);
        if (this.J == 1) {
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
        this.A.setOnClickListener(this.W);
    }
}
