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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import d.b.i0.z0.m0;
import d.b.j0.d3.v;
import d.b.j0.j1.o.h.b;
import d.b.j0.o.g.a;
import d.b.j0.s2.c0.b.e;
import d.b.j0.s2.f0.c;
import d.b.j0.s2.f0.h;
import d.b.j0.s2.h0.d;
import d.b.j0.s2.m;
import d.b.j0.s2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class DistributeVideoView extends RelativeLayout implements m {
    public View A;
    public ImageView B;
    public VideoControllerView C;
    public TbImageView D;
    public RelativeLayout E;
    public WeakReference<Context> F;
    public int G;
    public long H;
    public boolean I;
    public long J;
    public int K;
    public b L;
    public String M;
    public Animation N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public int S;
    public boolean T;
    public int U;
    public boolean V;
    public int W;
    public View.OnClickListener a0;
    public Handler b0;
    public CyberPlayerManager.OnPreparedListener c0;
    public CyberPlayerManager.OnInfoListener d0;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f20559e;
    public CyberPlayerManager.OnErrorListener e0;

    /* renamed from: f  reason: collision with root package name */
    public Context f20560f;
    public CyberPlayerManager.OnCompletionListener f0;

    /* renamed from: g  reason: collision with root package name */
    public View f20561g;
    public TbCyberVideoView.g g0;

    /* renamed from: h  reason: collision with root package name */
    public View f20562h;
    public Runnable h0;
    public VideoInfo i;
    public Runnable i0;
    public AdCard.a j;
    public Runnable j0;
    public e k;
    public CustomMessageListener k0;
    public d l;
    public CustomMessageListener l0;
    public d.b.j0.s2.h0.e m;
    public CustomMessageListener m0;
    public ViewGroup n;
    public AdvertAppInfo o;
    public int p;
    public String q;
    public TbCyberVideoView r;
    public TBLottieAnimationView s;
    public ForeDrawableImageView t;
    public TextView u;
    public View v;
    public ImageView w;
    public ImageView x;
    public View y;
    public TextView z;

    public DistributeVideoView(Context context) {
        super(context);
        this.F = null;
        this.G = -1;
        this.H = 0L;
        this.I = false;
        this.J = 0L;
        this.K = 1;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.T = false;
        this.U = 2;
        this.W = 1;
        this.a0 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.y) {
                    DistributeVideoView.this.y.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view != DistributeVideoView.this.x && view != DistributeVideoView.this.w) {
                    if (view == DistributeVideoView.this.s || view == DistributeVideoView.this.B) {
                        DistributeVideoView.this.d0();
                    } else if (!(DistributeVideoView.this.L instanceof AdCard)) {
                        DistributeVideoView.this.d0();
                    } else {
                        int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.S();
                        if (w.p(jump2DownloadDetailPage)) {
                            DistributeVideoView.this.U(jump2DownloadDetailPage);
                        }
                    }
                } else {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.p0(!distributeVideoView.I);
                }
            }
        };
        this.b0 = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 1001) {
                    if (i == 1003 && DistributeVideoView.this.G == 1) {
                        if (DistributeVideoView.this.H == DistributeVideoView.this.r.getCurrentPosition()) {
                            DistributeVideoView.this.i0();
                        } else {
                            DistributeVideoView distributeVideoView = DistributeVideoView.this;
                            distributeVideoView.H = distributeVideoView.r.getCurrentPosition();
                            DistributeVideoView.this.setLoadingAnimShow(false);
                        }
                        DistributeVideoView.this.b0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                    }
                } else if (DistributeVideoView.this.G == 1) {
                } else {
                    if (DistributeVideoView.this.r.getCurrentPosition() > 0) {
                        DistributeVideoView.this.G = 1;
                        DistributeVideoView.this.W();
                        return;
                    }
                    DistributeVideoView.this.b0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.r == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.R = distributeVideoView.r.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                distributeVideoView2.S = distributeVideoView2.r.getDuration();
                DistributeVideoView.this.r.setVolume(0.0f, 0.0f);
                DistributeVideoView.this.b0.removeMessages(1001);
                DistributeVideoView.this.b0.sendEmptyMessage(1001);
                if (DistributeVideoView.this.I && DistributeVideoView.this.K == 1) {
                    DistributeVideoView.this.p0(false);
                }
            }
        };
        this.d0 = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 && DistributeVideoView.this.o != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    int i3 = (distributeVideoView.T && "DETAIL".equals(distributeVideoView.o.c4)) ? 35 : 31;
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.k0(i3, distributeVideoView2.Y(distributeVideoView2.U), 0);
                }
                return false;
            }
        };
        this.e0 = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.o0();
                if (DistributeVideoView.this.r != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.k0(36, distributeVideoView.Y(distributeVideoView.U), DistributeVideoView.this.r.getCurrentPosition());
                }
                DistributeVideoView.this.t.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.y.setVisibility(0);
                return true;
            }
        };
        this.f0 = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.J = System.currentTimeMillis();
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.T = true;
                if (distributeVideoView.r != null) {
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.k0(34, distributeVideoView2.Y(distributeVideoView2.U), DistributeVideoView.this.r.getDuration());
                }
                DistributeVideoView.this.o0();
                if (DistributeVideoView.this.m != null) {
                    DistributeVideoView.this.m.e();
                    DistributeVideoView.this.u.setVisibility(8);
                    DistributeVideoView.this.v.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.g0 = new TbCyberVideoView.g() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.h0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.i == null || DistributeVideoView.this.r == null || !DistributeVideoView.this.canPlay()) {
                    return;
                }
                DistributeVideoView.this.j0(1);
            }
        };
        this.i0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.Z();
            }
        };
        this.j0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.h0(false);
            }
        };
        this.k0 = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.K == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.Q) {
                            DistributeVideoView.this.p0(true);
                            return;
                        } else {
                            DistributeVideoView.this.p0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.Q = distributeVideoView.I;
                    DistributeVideoView.this.p0(true);
                }
            }
        };
        this.l0 = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.K == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.p0(true);
                    }
                }
            }
        };
        this.m0 = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.h0(true);
            }
        };
        a0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        e0();
        if (z) {
            this.s.setAlpha(1.0f);
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }

    public final boolean R() {
        if (this.K == 1) {
            return v.a();
        }
        return j.H();
    }

    public final void S() {
        k0(2, 1, 0);
    }

    public final void T(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.c4 = str;
        c l = h.l(this.o, 303, i, Y(this.U), this.i.video_duration.intValue(), this.S, -1);
        d.b.j0.s2.h0.e eVar = this.m;
        if (eVar != null) {
            eVar.k(l);
        }
    }

    public final void U(int i) {
        VideoInfo videoInfo;
        AdvertAppInfo advertAppInfo = this.o;
        if (advertAppInfo == null || (videoInfo = this.i) == null) {
            return;
        }
        advertAppInfo.c4 = this.q;
        c l = h.l(advertAppInfo, SDKLogTypeConstants.CLOSE_GAME_TYPE, this.p, 1, videoInfo.video_duration.intValue(), a.a(0), -1);
        boolean z = i == 1000;
        l.c(z ? "APP" : "URL");
        if (!z) {
            l.m(i);
        }
        l.h("DEEPLINK");
        d.b.j0.s2.f0.e.b().d(l);
    }

    public final void V() {
        d.b.c.e.m.e.a().removeCallbacks(this.j0);
        d.b.c.e.m.e.a().postDelayed(this.j0, 5000L);
    }

    public final void W() {
        TBLottieAnimationView tBLottieAnimationView = this.s;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.clearAnimation();
            this.s.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.s.setMinFrame(0);
                    DistributeVideoView.this.s.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.s.setVisibility(8);
                    DistributeVideoView.this.t.setVisibility(8);
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.p0(distributeVideoView.I);
                    if (DistributeVideoView.this.K == 1) {
                        DistributeVideoView.this.u.setVisibility(8);
                        DistributeVideoView.this.v.setVisibility(8);
                    } else {
                        DistributeVideoView.this.C.setPlayer(DistributeVideoView.this.r);
                        DistributeVideoView.this.C.p(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.i.video_duration.intValue()));
                        DistributeVideoView.this.C.s();
                        DistributeVideoView.this.g0(true);
                        d.b.c.e.m.e.a().removeCallbacks(DistributeVideoView.this.i0);
                        d.b.c.e.m.e.a().postDelayed(DistributeVideoView.this.i0, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.H = distributeVideoView2.r.getCurrentPosition();
                    DistributeVideoView.this.h0(true);
                    DistributeVideoView.this.b0.removeMessages(1003);
                    DistributeVideoView.this.b0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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

    public final String X(int i) {
        return (i != 0 && i == 1) ? Config.CELL_LOCATION : ActVideoSetting.ACT_URL;
    }

    public final int Y(int i) {
        return i == 1 ? 0 : 1;
    }

    public final void Z() {
        Animation animation;
        if (this.O || (animation = this.N) == null) {
            return;
        }
        this.A.startAnimation(animation);
        this.O = true;
    }

    public final void a0(Context context) {
        if (context == null) {
            return;
        }
        this.f20560f = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
        this.f20562h = inflate;
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.distribute_texture);
        this.r = tbCyberVideoView;
        tbCyberVideoView.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.r.setNoBussinessStats();
        this.s = (TBLottieAnimationView) this.f20562h.findViewById(R.id.video_play);
        this.t = (ForeDrawableImageView) this.f20562h.findViewById(R.id.distribute_thumbnail);
        this.u = (TextView) this.f20562h.findViewById(R.id.distribute_count_process);
        this.v = this.f20562h.findViewById(R.id.black_mask_top);
        this.y = this.f20562h.findViewById(R.id.distribute_error_tip);
        this.z = (TextView) this.f20562h.findViewById(R.id.distribute_error_tip_text);
        this.w = (ImageView) this.f20562h.findViewById(R.id.distribute_voice_feed);
        View findViewById = this.f20562h.findViewById(R.id.distribute_control);
        this.A = findViewById;
        this.B = (ImageView) findViewById.findViewById(R.id.distribute_play_icon);
        this.x = (ImageView) this.A.findViewById(R.id.distribute_voice);
        this.C = (VideoControllerView) this.A.findViewById(R.id.distribute_process);
        FrameLayout frameLayout = (FrameLayout) this.f20562h.findViewById(R.id.tail_frame_container);
        this.n = frameLayout;
        this.l = new d(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.f20562h.findViewById(R.id.bottom_picture);
        this.D = tbImageView;
        tbImageView.setVisibility(8);
        this.E = (RelativeLayout) this.f20562h.findViewById(R.id.video_container);
        this.s.setAnimation(R.raw.lotti_video_loading);
        this.s.setMinFrame(0);
        this.s.setFrame(0);
        d.b.i0.b.g.b.f(this.v, R.drawable.video_mask_bg);
    }

    public void autoContinue() {
        if (this.P) {
            return;
        }
        continuePlay(1);
    }

    @Override // d.b.j0.s2.m
    public void autoPlay(int i) {
        if (R()) {
            if (i <= 0) {
                j0(1);
                return;
            }
            d.b.c.e.m.e.a().removeCallbacks(this.h0);
            d.b.c.e.m.e.a().postDelayed(this.h0, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public final void b0() {
        TbPageContext<?> tbPageContext = this.f20559e;
        if (tbPageContext == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
        this.N = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                DistributeVideoView.this.A.setVisibility(8);
                DistributeVideoView.this.O = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public final int c0() {
        AdvertAppInfo advertAppInfo = this.o;
        String str = advertAppInfo != null ? advertAppInfo.H3 : "";
        if (!TextUtils.isEmpty(this.M)) {
            str = this.M;
        }
        if (TextUtils.isEmpty(str) || this.f20560f == null) {
            return 0;
        }
        if (w.B(this.o, str)) {
            return 3;
        }
        if (isPlaying() && d.b.j0.a.e().q()) {
            return w.d(this.f20560f, str, TextUtils.isEmpty(this.o.J3) ? this.o.E3 : this.o.J3, this.o.T3);
        }
        return w.g(this.f20560f, str, this.o);
    }

    @Override // d.b.j0.s2.m
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.i(this.f20560f);
    }

    public void continuePlay(int i) {
        if (this.G != 2) {
            return;
        }
        this.U = i;
        k0(33, Y(i), this.r.getCurrentPosition());
        this.R = this.r.getCurrentPosition();
        this.r.start();
        if (this.I) {
            m0.e(this.F, true);
        }
        setLoadingAnimShow(false);
        SkinManager.setImageResource(this.B, R.drawable.icon_video_midplay);
        this.G = 1;
    }

    public final void d0() {
        TbPageContext<?> tbPageContext;
        TbPageContext<?> tbPageContext2;
        int i = this.G;
        if (i == -1) {
            if (!j.z() && (tbPageContext2 = this.f20559e) != null) {
                tbPageContext2.showToast(R.string.neterror);
            } else if (!j.H() && (tbPageContext = this.f20559e) != null) {
                d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(tbPageContext.getPageActivity());
                aVar.setMessageId(R.string.play_video_mobile_tip);
                aVar.setPositiveButton(R.string.alert_yes_button, new a.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                    @Override // d.b.i0.r.s.a.e
                    public void onClick(d.b.i0.r.s.a aVar2) {
                        aVar2.dismiss();
                        DistributeVideoView.this.performPlay();
                    }
                });
                aVar.setNegativeButton(R.string.cancel, new a.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                    @Override // d.b.i0.r.s.a.e
                    public void onClick(d.b.i0.r.s.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.create(this.f20559e).show();
            } else {
                performPlay();
            }
        } else if (i == 0) {
            stopPlay();
        } else if (i == 1) {
            this.P = true;
            pausePlay(0);
            if (this.K == 2) {
                g0(true);
            }
        } else if (i != 2) {
        } else {
            this.P = false;
            continuePlay(2);
            if (this.K == 2) {
                d.b.c.e.m.e.a().removeCallbacks(this.i0);
                d.b.c.e.m.e.a().postDelayed(this.i0, TimeUnit.SECONDS.toMillis(3L));
            }
        }
    }

    public final void e0() {
        TBLottieAnimationView tBLottieAnimationView = this.s;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setMinFrame(0);
            this.s.setFrame(0);
            this.s.cancelAnimation();
        }
    }

    public final void f0(String str, int i, int i2, int i3, String str2, String str3) {
        AdCard.a aVar = this.j;
        if (aVar == null || !AdCard.CHARGE_STYLE_CPV.equals(aVar.f20397a) || TextUtils.isEmpty(this.j.f20398b)) {
            return;
        }
        new d.b.j0.s2.g0.a(this.j.f20398b).f(str, i, i2, i3, str2, str3);
    }

    public final void g0(boolean z) {
        if (z) {
            d.b.c.e.m.e.a().removeCallbacks(this.i0);
            Animation animation = this.N;
            if (animation != null) {
                animation.cancel();
            }
            this.A.setVisibility(0);
            if (this.G == 1) {
                SkinManager.setImageResource(this.B, R.drawable.icon_video_midplay);
                return;
            } else {
                SkinManager.setImageResource(this.B, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.A.setVisibility(8);
    }

    @Override // d.b.j0.s2.m
    public long getCurrentPosition() {
        return this.H;
    }

    public VideoInfo getData() {
        return this.i;
    }

    @Override // d.b.j0.s2.m
    public int getPlayStatus() {
        return this.G;
    }

    @Override // d.b.j0.s2.m
    public String getPlayUrl() {
        VideoInfo videoInfo = this.i;
        return videoInfo != null ? videoInfo.video_url : "";
    }

    @Override // d.b.j0.s2.m
    public View getVideoContainer() {
        return this;
    }

    public final void h0(boolean z) {
        ImageView imageView = this.w;
        if (imageView == null || this.K != 1) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
            V();
            return;
        }
        imageView.setVisibility(8);
    }

    public final void i0() {
        TBLottieAnimationView tBLottieAnimationView = this.s;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setAlpha(1.0f);
            this.s.setVisibility(0);
            this.s.loop(true);
            this.s.setMinAndMaxFrame(14, 80);
            this.s.playAnimation();
        }
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20562h.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        if (z) {
            int k = l.k(getContext());
            int c2 = d.b.j0.s2.c0.c.a.c(k);
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
        this.r.requestLayout();
    }

    @Override // d.b.j0.s2.m
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // d.b.j0.s2.m
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    public final void j0(int i) {
        this.U = i;
        if (this.i != null && this.G == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.J) < TimeUnit.SECONDS.toSeconds(3L)) {
                return;
            }
            d.b.j0.s2.h0.e eVar = this.m;
            if (eVar != null) {
                eVar.f();
            }
            this.r.setVideoPath(this.i.video_url);
            this.r.setVideoScalingMode(this.W);
            this.r.start();
            this.R = this.r.getCurrentPosition();
            SkinManager.setImageResource(this.B, R.drawable.icon_video_midplay);
            i0();
            this.y.setVisibility(8);
            this.t.setForegroundDrawable(0);
            this.G = 0;
            if (this.K == 1) {
                this.u.setVisibility(0);
                this.v.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            TbPageContext<?> tbPageContext = this.f20559e;
            if (tbPageContext != null) {
                tbPageContext.registerListener(this.m0);
                this.f20559e.registerListener(this.k0);
                this.f20559e.registerListener(this.l0);
            }
            k0(31, Y(this.U), 0);
        }
    }

    public int jump2DownloadDetailPage() {
        return c0();
    }

    public final void k0(int i, int i2, int i3) {
        l0(i, i2, i3, -1);
    }

    public final void l0(int i, int i2, int i3, int i4) {
        m0(i, i2, i3, i4, true);
    }

    public final void m0(int i, int i2, int i3, int i4, boolean z) {
        VideoInfo videoInfo;
        String str;
        AdvertAppInfo advertAppInfo = this.o;
        if (advertAppInfo == null || (videoInfo = this.i) == null) {
            return;
        }
        advertAppInfo.c4 = this.q;
        d.b.j0.s2.f0.e.b().d(h.l(advertAppInfo, i, this.p, i2, videoInfo.video_duration.intValue(), d.b.j0.o.g.a.a(i3), i4));
        if (!z || i == 31 || i == 33 || i == 35 || i == 2) {
            return;
        }
        String str2 = i == 34 ? "com" : i == 36 ? Config.EXCEPTION_PART : i4 == 1 ? "hide" : i4 == 0 ? "cl_pau" : "other";
        if ("DETAIL".equals(this.q)) {
            str = "det";
        } else if ("FRS".equals(this.q)) {
            str = "frs";
        } else {
            str = "NEWINDEX".equals(this.q) ? "ind" : "oth";
        }
        f0(str2, this.R, i3, this.S, str, X(i2));
    }

    public final void n0(int i, int i2, int i3, boolean z) {
        m0(i, i2, i3, -1, z);
    }

    public final void o0() {
        d.b.c.e.m.e.a().removeCallbacks(this.h0);
        d.b.c.e.m.e.a().removeCallbacks(this.i0);
        d.b.c.e.m.e.a().removeCallbacks(this.j0);
        this.b0.removeMessages(1001);
        this.b0.removeMessages(1003);
        this.r.stopPlayback();
        this.G = -1;
        m0.e(this.F, false);
        h0(false);
        this.t.setForegroundDrawable(0);
        this.t.setVisibility(0);
        setLoadingAnimShow(true);
        SkinManager.setImageResource(this.B, R.drawable.icon_video_midpause);
        this.C.q();
        this.y.setVisibility(8);
        VideoInfo videoInfo = this.i;
        if (videoInfo != null) {
            this.u.setText(StringUtils.translateSecondsToString(videoInfo.video_duration.intValue()));
            this.u.setVisibility(0);
            this.v.setVisibility(0);
        }
        this.Q = false;
        MessageManager.getInstance().unRegisterListener(this.m0);
        MessageManager.getInstance().unRegisterListener(this.k0);
        MessageManager.getInstance().unRegisterListener(this.l0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.b.j0.s2.h0.e eVar = this.m;
        if (eVar instanceof d.b.j0.s2.h0.a) {
            b bVar = this.L;
            if (!(bVar instanceof AdCard) || ((AdCard) bVar).directDownload) {
                return;
            }
            ((d.b.j0.s2.h0.a) eVar).w();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.j0.s2.h0.e eVar = this.m;
        if (eVar instanceof d.b.j0.s2.h0.a) {
            b bVar = this.L;
            if (!(bVar instanceof AdCard) || ((AdCard) bVar).directDownload) {
                return;
            }
            ((d.b.j0.s2.h0.a) eVar).B();
        }
    }

    public final void p0(boolean z) {
        if (z) {
            TbCyberVideoView tbCyberVideoView = this.r;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(1.0f, 1.0f);
            }
            SkinManager.setImageResource(this.x, R.drawable.ad_icon_sound_open);
            SkinManager.setImageResource(this.w, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.G == 1) {
                m0.e(this.F, true);
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.r;
            if (tbCyberVideoView2 != null) {
                tbCyberVideoView2.setVolume(0.0f, 0.0f);
            }
            SkinManager.setImageResource(this.x, R.drawable.ad_icon_sound_close);
            SkinManager.setImageResource(this.w, R.drawable.icon_vedio_npronunciation_small_white);
            m0.e(this.F, false);
        }
        this.I = z;
    }

    public void pausePlay(int i) {
        if (this.G != 1) {
            return;
        }
        l0(32, Y(this.U), this.r.getCurrentPosition(), i);
        this.r.pause();
        m0.e(this.F, false);
        setLoadingAnimShow(true);
        SkinManager.setImageResource(this.B, R.drawable.icon_video_midpause);
        this.G = 2;
    }

    public void performPlay() {
        j0(2);
    }

    @Override // d.b.j0.s2.m
    public void release() {
    }

    public void setAdInfo(AdCard adCard) {
        this.L = adCard;
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.j = aVar;
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.K = i;
        if (tbPageContext != null) {
            this.f20559e = tbPageContext;
            b0();
        }
        setData(videoInfo);
    }

    public void setDownloadCallback(d.b.j0.j1.o.c cVar) {
        d.b.j0.s2.h0.e eVar = this.m;
        if (eVar != null) {
            eVar.h(cVar);
        }
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.f20561g = view;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.f20559e = tbPageContext;
    }

    public void setScheme(String str) {
        this.M = str;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.o = advertAppInfo;
        this.p = i;
        this.q = str;
        T(advertAppInfo, i, str);
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.V = z;
    }

    public void setVideoScalingMode(int i) {
        this.W = i;
        this.r.setVideoScalingMode(i);
    }

    public void setVideoTailFrameData(e eVar) {
        this.k = eVar;
    }

    @Override // d.b.j0.s2.m
    public void startPlay() {
        autoPlay(0);
    }

    @Override // d.b.j0.s2.m
    public void stopPlay() {
        stopPlay(true);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.o;
        }
        d.b.j0.s2.h0.e b2 = this.l.b(this.k, this.m);
        this.m = b2;
        if (b2 != null) {
            b2.j(this.f20559e);
            this.m.i(this.L);
            d.b.j0.s2.h0.e eVar = this.m;
            if (eVar instanceof d.b.j0.s2.h0.a) {
                ((d.b.j0.s2.h0.a) eVar).y(this.V);
            }
            this.m.g(advertAppInfo);
            this.m.d(this.k);
            this.m.f();
        }
    }

    public void stopPlay(boolean z) {
        if (this.r.getCurrentPosition() > 0 && this.G != -1 && z) {
            int currentPosition = this.r.getCurrentPosition();
            n0(this.r.getDuration() == currentPosition ? 34 : 32, Y(this.U), currentPosition, this.r.isPlaying());
        }
        o0();
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.i = videoInfo;
        this.S = videoInfo.video_duration.intValue() * 1000;
        this.F = new WeakReference<>(this.f20560f.getApplicationContext());
        o0();
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        int k = l.k(this.f20560f) - l.g(this.f20560f, R.dimen.ds146);
        if (this.K == 2) {
            k = l.k(this.f20560f);
        }
        int intValue = this.i.video_width.intValue() > 0 ? (this.i.video_height.intValue() * k) / this.i.video_width.intValue() : k;
        ViewGroup.LayoutParams layoutParams = this.f20562h.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = k;
            layoutParams.height = intValue;
            this.f20562h.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.a0);
        this.t.setDefaultResource(0);
        this.t.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!k.isEmpty(videoInfo.thumbnail_url)) {
            this.t.W(videoInfo.thumbnail_url, 10, false);
        }
        this.r.setOnPreparedListener(this.c0);
        this.r.setOnErrorListener(this.e0);
        this.r.setOnCompletionListener(this.f0);
        this.r.setOnInfoListener(this.d0);
        this.r.setOnSurfaceDestroyedListener(this.g0);
        SkinManager.setViewTextColor(this.u, R.color.cp_cont_m);
        this.u.setText(StringUtils.translateSecondsToString(this.i.video_duration.intValue()));
        if (this.K == 1) {
            this.I = false;
            SkinManager.setImageResource(this.w, R.drawable.icon_vedio_npronunciation_small_white);
            this.w.setVisibility(8);
        } else {
            this.I = true;
            SkinManager.setImageResource(this.x, R.drawable.ad_icon_sound_open);
            this.w.setVisibility(8);
        }
        this.x.setOnClickListener(this.a0);
        this.w.setOnClickListener(this.a0);
        this.y.setOnClickListener(this.a0);
        this.y.setVisibility(8);
        SkinManager.setBackgroundColor(this.y, R.color.black_alpha80);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0101);
        if (this.K == 1) {
            this.v.setVisibility(0);
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
        this.B.setOnClickListener(this.a0);
        this.s.setOnClickListener(this.a0);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = null;
        this.G = -1;
        this.H = 0L;
        this.I = false;
        this.J = 0L;
        this.K = 1;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.T = false;
        this.U = 2;
        this.W = 1;
        this.a0 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.y) {
                    DistributeVideoView.this.y.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view != DistributeVideoView.this.x && view != DistributeVideoView.this.w) {
                    if (view == DistributeVideoView.this.s || view == DistributeVideoView.this.B) {
                        DistributeVideoView.this.d0();
                    } else if (!(DistributeVideoView.this.L instanceof AdCard)) {
                        DistributeVideoView.this.d0();
                    } else {
                        int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.S();
                        if (w.p(jump2DownloadDetailPage)) {
                            DistributeVideoView.this.U(jump2DownloadDetailPage);
                        }
                    }
                } else {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.p0(!distributeVideoView.I);
                }
            }
        };
        this.b0 = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 1001) {
                    if (i == 1003 && DistributeVideoView.this.G == 1) {
                        if (DistributeVideoView.this.H == DistributeVideoView.this.r.getCurrentPosition()) {
                            DistributeVideoView.this.i0();
                        } else {
                            DistributeVideoView distributeVideoView = DistributeVideoView.this;
                            distributeVideoView.H = distributeVideoView.r.getCurrentPosition();
                            DistributeVideoView.this.setLoadingAnimShow(false);
                        }
                        DistributeVideoView.this.b0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                    }
                } else if (DistributeVideoView.this.G == 1) {
                } else {
                    if (DistributeVideoView.this.r.getCurrentPosition() > 0) {
                        DistributeVideoView.this.G = 1;
                        DistributeVideoView.this.W();
                        return;
                    }
                    DistributeVideoView.this.b0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.r == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.R = distributeVideoView.r.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                distributeVideoView2.S = distributeVideoView2.r.getDuration();
                DistributeVideoView.this.r.setVolume(0.0f, 0.0f);
                DistributeVideoView.this.b0.removeMessages(1001);
                DistributeVideoView.this.b0.sendEmptyMessage(1001);
                if (DistributeVideoView.this.I && DistributeVideoView.this.K == 1) {
                    DistributeVideoView.this.p0(false);
                }
            }
        };
        this.d0 = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 && DistributeVideoView.this.o != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    int i3 = (distributeVideoView.T && "DETAIL".equals(distributeVideoView.o.c4)) ? 35 : 31;
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.k0(i3, distributeVideoView2.Y(distributeVideoView2.U), 0);
                }
                return false;
            }
        };
        this.e0 = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.o0();
                if (DistributeVideoView.this.r != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.k0(36, distributeVideoView.Y(distributeVideoView.U), DistributeVideoView.this.r.getCurrentPosition());
                }
                DistributeVideoView.this.t.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.y.setVisibility(0);
                return true;
            }
        };
        this.f0 = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.J = System.currentTimeMillis();
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.T = true;
                if (distributeVideoView.r != null) {
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.k0(34, distributeVideoView2.Y(distributeVideoView2.U), DistributeVideoView.this.r.getDuration());
                }
                DistributeVideoView.this.o0();
                if (DistributeVideoView.this.m != null) {
                    DistributeVideoView.this.m.e();
                    DistributeVideoView.this.u.setVisibility(8);
                    DistributeVideoView.this.v.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.g0 = new TbCyberVideoView.g() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.h0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.i == null || DistributeVideoView.this.r == null || !DistributeVideoView.this.canPlay()) {
                    return;
                }
                DistributeVideoView.this.j0(1);
            }
        };
        this.i0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.Z();
            }
        };
        this.j0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.h0(false);
            }
        };
        this.k0 = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.K == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.Q) {
                            DistributeVideoView.this.p0(true);
                            return;
                        } else {
                            DistributeVideoView.this.p0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.Q = distributeVideoView.I;
                    DistributeVideoView.this.p0(true);
                }
            }
        };
        this.l0 = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.K == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.p0(true);
                    }
                }
            }
        };
        this.m0 = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.h0(true);
            }
        };
        a0(context);
    }

    public void setData(VideoInfo videoInfo, AdCard.f fVar, int i, int i2, int i3, int i4) {
        int i5;
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.i = videoInfo;
        this.F = new WeakReference<>(this.f20560f.getApplicationContext());
        o0();
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20562h.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        setOnClickListener(this.a0);
        int i6 = 13;
        if (fVar != null && fVar.a()) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i4;
            this.D.W(fVar.f20415a, 30, false);
            this.D.setVisibility(0);
            double d2 = fVar.f20416b;
            if (d2 > 0.0d) {
                i = (int) (i3 * d2);
                i2 = d.b.j0.s2.c0.c.a.b(i);
            }
            double d3 = fVar.f20417c;
            i5 = d3 > 0.0d ? Math.min((int) (i3 * d3), i3 - i) : 0;
            i6 = 11;
        } else {
            this.D.setVisibility(8);
            i5 = 0;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams3.width = i;
        layoutParams3.height = i2;
        layoutParams3.rightMargin = i5;
        layoutParams3.addRule(i6);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams4.width = i;
        layoutParams4.height = i2;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams5.width = i;
        layoutParams5.height = i2;
        this.t.setDefaultResource(0);
        this.t.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!k.isEmpty(videoInfo.thumbnail_url)) {
            this.t.W(videoInfo.thumbnail_url, 10, false);
        }
        this.r.setOnPreparedListener(this.c0);
        this.r.setOnErrorListener(this.e0);
        this.r.setOnCompletionListener(this.f0);
        this.r.setOnInfoListener(this.d0);
        this.r.setOnSurfaceDestroyedListener(this.g0);
        SkinManager.setViewTextColor(this.u, R.color.cp_cont_m);
        this.u.setText(StringUtils.translateSecondsToString(this.i.video_duration.intValue()));
        if (this.K == 1) {
            this.I = false;
            SkinManager.setImageResource(this.w, R.drawable.icon_vedio_npronunciation_small_white);
            this.w.setVisibility(8);
        } else {
            this.I = true;
            SkinManager.setImageResource(this.x, R.drawable.ad_icon_sound_open);
            this.w.setVisibility(8);
        }
        this.x.setOnClickListener(this.a0);
        this.w.setOnClickListener(this.a0);
        this.y.setOnClickListener(this.a0);
        this.y.setVisibility(8);
        SkinManager.setBackgroundColor(this.y, R.color.black_alpha80);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0101);
        if (this.K == 1) {
            this.u.setVisibility(0);
            this.v.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
        this.B.setOnClickListener(this.a0);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = null;
        this.G = -1;
        this.H = 0L;
        this.I = false;
        this.J = 0L;
        this.K = 1;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.T = false;
        this.U = 2;
        this.W = 1;
        this.a0 = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.y) {
                    DistributeVideoView.this.y.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view != DistributeVideoView.this.x && view != DistributeVideoView.this.w) {
                    if (view == DistributeVideoView.this.s || view == DistributeVideoView.this.B) {
                        DistributeVideoView.this.d0();
                    } else if (!(DistributeVideoView.this.L instanceof AdCard)) {
                        DistributeVideoView.this.d0();
                    } else {
                        int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.S();
                        if (w.p(jump2DownloadDetailPage)) {
                            DistributeVideoView.this.U(jump2DownloadDetailPage);
                        }
                    }
                } else {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.p0(!distributeVideoView.I);
                }
            }
        };
        this.b0 = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 != 1001) {
                    if (i2 == 1003 && DistributeVideoView.this.G == 1) {
                        if (DistributeVideoView.this.H == DistributeVideoView.this.r.getCurrentPosition()) {
                            DistributeVideoView.this.i0();
                        } else {
                            DistributeVideoView distributeVideoView = DistributeVideoView.this;
                            distributeVideoView.H = distributeVideoView.r.getCurrentPosition();
                            DistributeVideoView.this.setLoadingAnimShow(false);
                        }
                        DistributeVideoView.this.b0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                    }
                } else if (DistributeVideoView.this.G == 1) {
                } else {
                    if (DistributeVideoView.this.r.getCurrentPosition() > 0) {
                        DistributeVideoView.this.G = 1;
                        DistributeVideoView.this.W();
                        return;
                    }
                    DistributeVideoView.this.b0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.r == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.R = distributeVideoView.r.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                distributeVideoView2.S = distributeVideoView2.r.getDuration();
                DistributeVideoView.this.r.setVolume(0.0f, 0.0f);
                DistributeVideoView.this.b0.removeMessages(1001);
                DistributeVideoView.this.b0.sendEmptyMessage(1001);
                if (DistributeVideoView.this.I && DistributeVideoView.this.K == 1) {
                    DistributeVideoView.this.p0(false);
                }
            }
        };
        this.d0 = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                if (i2 == 3 && DistributeVideoView.this.o != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    int i3 = (distributeVideoView.T && "DETAIL".equals(distributeVideoView.o.c4)) ? 35 : 31;
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.k0(i3, distributeVideoView2.Y(distributeVideoView2.U), 0);
                }
                return false;
            }
        };
        this.e0 = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.o0();
                if (DistributeVideoView.this.r != null) {
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.k0(36, distributeVideoView.Y(distributeVideoView.U), DistributeVideoView.this.r.getCurrentPosition());
                }
                DistributeVideoView.this.t.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.y.setVisibility(0);
                return true;
            }
        };
        this.f0 = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.J = System.currentTimeMillis();
                DistributeVideoView distributeVideoView = DistributeVideoView.this;
                distributeVideoView.T = true;
                if (distributeVideoView.r != null) {
                    DistributeVideoView distributeVideoView2 = DistributeVideoView.this;
                    distributeVideoView2.k0(34, distributeVideoView2.Y(distributeVideoView2.U), DistributeVideoView.this.r.getDuration());
                }
                DistributeVideoView.this.o0();
                if (DistributeVideoView.this.m != null) {
                    DistributeVideoView.this.m.e();
                    DistributeVideoView.this.u.setVisibility(8);
                    DistributeVideoView.this.v.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.g0 = new TbCyberVideoView.g() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.h0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.i == null || DistributeVideoView.this.r == null || !DistributeVideoView.this.canPlay()) {
                    return;
                }
                DistributeVideoView.this.j0(1);
            }
        };
        this.i0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.Z();
            }
        };
        this.j0 = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.h0(false);
            }
        };
        this.k0 = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.K == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.Q) {
                            DistributeVideoView.this.p0(true);
                            return;
                        } else {
                            DistributeVideoView.this.p0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = DistributeVideoView.this;
                    distributeVideoView.Q = distributeVideoView.I;
                    DistributeVideoView.this.p0(true);
                }
            }
        };
        this.l0 = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.K == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.p0(true);
                    }
                }
            }
        };
        this.m0 = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.h0(true);
            }
        };
        a0(context);
    }
}
