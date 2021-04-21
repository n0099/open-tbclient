package com.baidu.tieba.recapp.lego.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.tencent.connect.common.Constants;
import d.b.j0.j2.c;
import d.b.j0.s2.w;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements d.b.j0.j1.o.l.h, CountDownTextView.c, View.OnClickListener, d.b.j0.j1.o.l.k {
    public TextView A;
    public HeadImageView B;
    public TextView C;
    public d.b.j0.j2.c D;
    public Animation E;
    public Animation F;
    public VideoMiddlePageAdCard G;
    public int H;
    public TextView I;
    public TextView J;
    public d.b.j0.q0.i1.a K;
    public boolean L;
    public ViewGroup M;
    public d.b.j0.s2.h0.d N;
    public d.b.j0.s2.h0.e O;
    public VideoNetworkStateTipView P;
    public int Q;
    public d.b.j0.q0.p2.c R;
    public d.b.j0.j1.o.l.f S;
    public int T;
    public boolean U;
    public boolean V;
    public o W;
    public Animation.AnimationListener a0;
    public Animation.AnimationListener b0;
    public View r;
    public View s;
    public FrameLayout t;
    public FrameLayout u;
    public View v;
    public View w;
    public View x;
    public View y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements CyberPlayerManager.OnErrorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.q0.i1.a f20483e;

        public a(d.b.j0.q0.i1.a aVar) {
            this.f20483e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            d.b.j0.q0.i1.a aVar = this.f20483e;
            if (aVar != null) {
                aVar.cancel();
            }
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.x0(!videoMiddlePageAdView.L ? 1 : 0);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d0 {
        public b() {
        }

        @Override // d.b.j0.j2.c.d0
        public void a() {
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.v0(1, videoMiddlePageAdView.D.B0());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.b0 {
        public c() {
        }

        @Override // d.b.j0.j2.c.b0
        public void onPause() {
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.w0(1, videoMiddlePageAdView.D.B0());
            VideoMiddlePageAdView.this.V = true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnLongClickListener {
        public d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            d.b.i0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense == null || !adAdSense.f() || VideoMiddlePageAdView.this.G == null) {
                return false;
            }
            d.b.c.e.p.a.a(VideoMiddlePageAdView.this.G.adCollect());
            ((Vibrator) VideoMiddlePageAdView.this.m.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdCard f20488e;

        public e(VideoMiddlePageAdCard videoMiddlePageAdCard) {
            this.f20488e = videoMiddlePageAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (VideoMiddlePageAdView.this.G == null || VideoMiddlePageAdView.this.G.getAdFacadeData() == null || VideoMiddlePageAdView.this.G.getAdFacadeData().v() == null) {
                str = null;
                str2 = null;
            } else {
                AdvertAppInfo v = VideoMiddlePageAdView.this.G.getAdFacadeData().v();
                str2 = VideoMiddlePageAdView.this.p(v);
                str = v.T3;
            }
            int e2 = w.e(VideoMiddlePageAdView.this.m, this.f20488e.operateData.f20405c, str2, str);
            if (VideoMiddlePageAdView.this.O != null) {
                VideoMiddlePageAdView.this.O.a(false);
            }
            if (VideoMiddlePageAdView.this.o != null) {
                VideoMiddlePageAdView.this.o.a(e2, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public f() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            d.b.j0.j2.c cVar = VideoMiddlePageAdView.this.D;
            if (cVar == null || cVar.I0() == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.T = (int) TimeUnit.MILLISECONDS.toSeconds(videoMiddlePageAdView.D.I0().getDuration());
        }
    }

    /* loaded from: classes4.dex */
    public class g implements c.v {
        public g() {
        }

        @Override // d.b.j0.j2.c.v
        public void a(boolean z) {
            if (VideoMiddlePageAdView.this.W == null) {
                return;
            }
            if (z) {
                VideoMiddlePageAdView.this.W.g(0);
            } else {
                VideoMiddlePageAdView.this.W.g(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoMiddlePageAdView.this.P.setHasAgreeToPlay(true);
            VideoMiddlePageAdView.this.D.n1(false);
            VideoMiddlePageAdView.this.P.g();
            if (VideoMiddlePageAdView.this.G == null || VideoMiddlePageAdView.this.G.video == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.D.d2(videoMiddlePageAdView.G.video.video_url, "");
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Animation.AnimationListener {
        public i() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VideoMiddlePageAdView.this.v != null) {
                VideoMiddlePageAdView.this.v.setVisibility(8);
            }
            if (VideoMiddlePageAdView.this.w != null) {
                VideoMiddlePageAdView.this.w.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (VideoMiddlePageAdView.this.v != null) {
                VideoMiddlePageAdView.this.v.setVisibility(0);
            }
            if (VideoMiddlePageAdView.this.w != null) {
                VideoMiddlePageAdView.this.w.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animation.AnimationListener {
        public j() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VideoMiddlePageAdView.this.v != null) {
                VideoMiddlePageAdView.this.v.setVisibility(0);
            }
            if (VideoMiddlePageAdView.this.w != null) {
                VideoMiddlePageAdView.this.w.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (VideoMiddlePageAdView.this.v != null) {
                VideoMiddlePageAdView.this.v.setVisibility(8);
            }
            if (VideoMiddlePageAdView.this.w != null) {
                VideoMiddlePageAdView.this.w.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements c.x {
        public k() {
        }

        @Override // d.b.j0.j2.c.x
        public void a() {
        }

        @Override // d.b.j0.j2.c.x
        public void b() {
        }
    }

    /* loaded from: classes4.dex */
    public class l implements c.g0 {
        public l() {
        }

        @Override // d.b.j0.j2.c.g0
        public void a() {
            if (VideoMiddlePageAdView.this.G != null && VideoMiddlePageAdView.this.G.video != null && VideoMiddlePageAdView.this.G.video.video_height.intValue() > VideoMiddlePageAdView.this.G.video.video_width.intValue()) {
                VideoMiddlePageAdView.this.D.M1(false, true);
            } else {
                VideoMiddlePageAdView.this.D.M1(false, true);
            }
            if (VideoMiddlePageAdView.this.S != null) {
                VideoMiddlePageAdView.this.S.q(VideoMiddlePageAdView.this);
            }
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.y0(1 ^ (videoMiddlePageAdView.L ? 1 : 0));
            VideoMiddlePageAdView.this.U = false;
        }

        @Override // d.b.j0.j2.c.g0
        public void b() {
        }
    }

    /* loaded from: classes4.dex */
    public class m implements c.a0 {
        public m() {
        }

        @Override // d.b.j0.j2.c.a0
        public void a(boolean z) {
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.D.d2(videoMiddlePageAdView.G.video.video_url, "");
            if (VideoMiddlePageAdView.this.S != null) {
                VideoMiddlePageAdView.this.S.q(VideoMiddlePageAdView.this);
            }
            VideoMiddlePageAdView.this.y0(1);
            VideoMiddlePageAdView.this.U = false;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements CyberPlayerManager.OnCompletionListener {
        public n() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            VideoMiddlePageAdView.this.D.a1();
            if (VideoMiddlePageAdView.this.O != null) {
                VideoMiddlePageAdView.this.O.e();
            }
            VideoMiddlePageAdView videoMiddlePageAdView = VideoMiddlePageAdView.this;
            videoMiddlePageAdView.u0(!videoMiddlePageAdView.L ? 1 : 0);
            VideoMiddlePageAdView.this.V = true;
        }
    }

    /* loaded from: classes4.dex */
    public class o {

        /* renamed from: a  reason: collision with root package name */
        public int f20499a = -1;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f20501c = new a();

        /* renamed from: b  reason: collision with root package name */
        public Handler f20500b = new Handler();

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f20500b.removeCallbacks(o.this.f20501c);
                o.this.g(2);
            }
        }

        public o() {
        }

        public final void c() {
            this.f20500b.removeCallbacks(this.f20501c);
            this.f20500b.postDelayed(this.f20501c, 3000L);
        }

        public final int d(int i) {
            int i2 = this.f20499a;
            if (i == i2) {
                return i2;
            }
            VideoMiddlePageAdView.this.y.setVisibility(8);
            VideoMiddlePageAdView.this.x.setVisibility(8);
            VideoMiddlePageAdView.this.A0(true);
            return i;
        }

        public final int e(int i) {
            int i2 = this.f20499a;
            if (i == i2) {
                return i2;
            }
            VideoMiddlePageAdView.this.y.setVisibility(0);
            VideoMiddlePageAdView.this.x.setVisibility(0);
            VideoMiddlePageAdView.this.A0(true);
            return i;
        }

        public final int f(int i) {
            int i2 = this.f20499a;
            if (i == i2) {
                return i2;
            }
            VideoMiddlePageAdView.this.y.setVisibility(0);
            VideoMiddlePageAdView.this.x.setVisibility(0);
            d.b.j0.j2.c cVar = VideoMiddlePageAdView.this.D;
            if (cVar != null) {
                cVar.O0();
            }
            if (i2 != 3 || VideoMiddlePageAdView.this.G.autoPlay) {
                VideoMiddlePageAdView.this.A0(false);
                return i;
            }
            return i;
        }

        public void g(int i) {
            if (i == 0) {
                this.f20499a = d(i);
                c();
            } else if (i == 1) {
                this.f20499a = d(i);
                this.f20500b.removeCallbacks(this.f20501c);
            } else if (i == 2) {
                this.f20499a = f(i);
            } else if (i != 3) {
                this.f20499a = f(i);
            } else {
                this.f20499a = e(i);
                c();
            }
        }
    }

    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.U = false;
        this.V = true;
        this.a0 = new i();
        this.b0 = new j();
        this.U = false;
        this.V = true;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.r = inflate;
        this.t = (FrameLayout) inflate.findViewById(R.id.video_agg_container);
        this.s = this.r.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) this.r.findViewById(R.id.video_container);
        this.u = frameLayout;
        d.b.j0.j2.c cVar = new d.b.j0.j2.c(this.m, frameLayout, false);
        this.D = cVar;
        cVar.O1(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.D.K1(new f());
        this.D.p1(new g());
        this.D.f57960e.setOnTouchListener(null);
        this.z = (TextView) this.r.findViewById(R.id.title);
        HeadImageView headImageView = (HeadImageView) this.r.findViewById(R.id.user_icon);
        this.B = headImageView;
        headImageView.setIsRound(true);
        this.B.setDefaultBgResource(R.color.CAM_X0205);
        this.B.setDefaultResource(R.drawable.icon_default_avatar100);
        this.A = (TextView) this.r.findViewById(R.id.ad_tag);
        this.C = (TextView) this.r.findViewById(R.id.user_name);
        this.I = (TextView) this.r.findViewById(R.id.ad_operate_title);
        this.J = (TextView) this.r.findViewById(R.id.ad_operate_button);
        this.M = (FrameLayout) this.r.findViewById(R.id.tail_frame_container);
        d.b.j0.s2.h0.d dVar = new d.b.j0.s2.h0.d(this.m.getPageActivity(), this.M);
        this.N = dVar;
        dVar.f62148a = 1;
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) this.r.findViewById(R.id.network_state_tip);
        this.P = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new h());
        this.v = this.r.findViewById(R.id.video_agg_container_foreground);
        this.x = this.r.findViewById(R.id.user_container_foreground);
        this.y = this.r.findViewById(R.id.title_foreground);
        this.w = this.r.findViewById(R.id.operate_area_foreground);
        this.v.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.D.H1(this);
        this.z.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.H = d.b.c.e.p.l.k(this.m.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams.height = (int) (this.H * 0.5625f);
        this.t.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.E = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.E.setAnimationListener(this.b0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.F = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.F.setAnimationListener(this.a0);
        this.r.setOnClickListener(this);
        this.W = new o();
    }

    public final void A0(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void B0() {
        this.D.k2();
        TextView textView = this.z;
        if (textView != null) {
            textView.setVisibility(0);
        }
        o oVar = this.W;
        if (oVar != null) {
            oVar.g(2);
        }
        this.U = false;
        this.V = true;
    }

    public final void C0(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        d.b.j0.s2.h0.e b2 = this.N.b(videoMiddlePageAdCard.tailFrame, this.O);
        this.O = b2;
        if (b2 != null) {
            n0(this.G.getAdFacadeData());
            this.O.j(this.m);
            this.O.l(this);
            this.O.d(videoMiddlePageAdCard.tailFrame);
            this.O.i(this.G);
            this.O.f();
        }
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
    public void a(View view) {
        this.K.a(this.Q);
    }

    public d.b.j0.q0.i1.a getAutoPlayCallBack() {
        return this.K;
    }

    @Override // d.b.j0.j1.o.l.k
    public boolean isPlaying() {
        return this.D.T0();
    }

    @Override // d.b.j0.j1.o.l.k
    public void j() {
        if (isPlaying()) {
            this.D.W0();
            w0(!this.L ? 1 : 0, this.D.B0());
            this.V = true;
        }
    }

    public final void n0(d.b.d.d dVar) {
        if (dVar == null) {
            return;
        }
        int i2 = !this.L ? 1 : 0;
        d.b.j0.s2.f0.c m2 = d.b.j0.s2.f0.h.m(this.G.getAdFacadeData(), 303, this.G.getAdFacadeData().n(), i2, this.G.video.video_duration.intValue(), 0, -1);
        d.b.j0.s2.h0.e eVar = this.O;
        if (eVar != null) {
            eVar.k(m2);
        }
    }

    public final void o0(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2, d.b.j0.q0.i1.a aVar) {
        VideoInfo videoInfo;
        if (videoMiddlePageAdCard == null || (videoInfo = videoMiddlePageAdCard.video) == null) {
            return;
        }
        this.Q = i2;
        this.L = this.G.autoPlay;
        this.U = false;
        Integer num = videoInfo.video_duration;
        if (num != null && num.intValue() > 0) {
            this.T = videoMiddlePageAdCard.video.video_duration.intValue();
        }
        if (this.D.T0()) {
            w0(!videoMiddlePageAdCard.autoPlay ? 1 : 0, this.D.B0());
            this.V = true;
        }
        this.D.k2();
        this.D.s1(true);
        this.D.v1(false);
        this.D.t1(true);
        this.D.M1(false, true);
        this.D.L1(i2);
        this.D.y1(new k());
        this.D.G1(new l());
        this.D.A1(new m());
        this.D.o1(false);
        this.D.q0();
        this.D.I1(new n());
        this.D.J1(new a(aVar));
        this.D.S1(videoMiddlePageAdCard.video.thumbnail_url);
        this.D.Y1(videoMiddlePageAdCard.video.video_url, "");
        this.D.D1(new b());
        this.D.B1(new c());
        this.D.a1();
        this.D.a2();
        if (videoMiddlePageAdCard.autoPlay) {
            if (this.P.d()) {
                this.D.c2(false);
                this.P.f();
                this.D.n1(true);
                this.D.U0(videoMiddlePageAdCard.video.video_url, "");
            } else {
                this.D.n1(false);
                this.D.c2(false);
                this.P.b();
                this.D.i2(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
            }
            d.b.j0.s2.h0.e eVar = this.O;
            if (eVar != null) {
                eVar.a(true);
            }
            if (i2 == 0) {
                this.v.setVisibility(8);
                this.w.setVisibility(8);
            } else {
                this.v.startAnimation(this.F);
                this.w.startAnimation(this.F);
            }
            if (i2 == 0) {
                this.W.g(3);
                return;
            } else {
                this.W.g(0);
                return;
            }
        }
        this.P.b();
        this.D.c2(true);
        this.W.g(3);
        if (d.b.c.e.p.j.x() && videoMiddlePageAdCard.waitConfirm) {
            this.v.startAnimation(this.F);
            this.w.startAnimation(this.F);
            return;
        }
        this.v.setVisibility(0);
        this.w.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        View view2 = this.v;
        if (view == view2 && view2.getVisibility() == 0) {
            d.b.j0.q0.p2.c cVar = this.R;
            if (cVar != null) {
                cVar.g0(this.f18324g);
                return;
            }
            return;
        }
        View view3 = this.w;
        if (view == view3 && view3.getVisibility() == 0) {
            d.b.j0.q0.p2.c cVar2 = this.R;
            if (cVar2 != null) {
                cVar2.g0(this.f18324g);
            }
        } else if (view != this.y && view != this.x) {
            if (view.getId() != R.id.video_container && view.getId() != R.id.video_agg_container && view.getId() != R.id.float_video_container) {
                if (this.G.getAdFacadeData() == null || this.G.getAdFacadeData().v() == null) {
                    str = null;
                    str2 = null;
                } else {
                    str = p(this.G.getAdFacadeData().v());
                    str2 = this.G.getAdFacadeData().v().T3;
                }
                int e2 = w.e(this.m, this.G.getScheme(), str, str2);
                d.b.j0.j1.o.a aVar = this.o;
                if (aVar != null) {
                    aVar.a(e2, null);
                }
                d.b.j0.s2.h0.e eVar = this.O;
                if (eVar != null) {
                    eVar.a(false);
                    return;
                }
                return;
            }
            q0();
        } else if (this.v.getVisibility() == 0) {
            d.b.j0.q0.p2.c cVar3 = this.R;
            if (cVar3 != null) {
                cVar3.g0(this.f18324g);
            }
        } else {
            this.W.g(0);
        }
    }

    @Override // d.b.j0.j1.o.l.k
    public void onDestroy() {
        t0();
        View view = this.v;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.w;
        if (view2 != null) {
            view2.clearAnimation();
        }
    }

    public final boolean p0() {
        try {
            int intValue = this.G.video.video_width.intValue();
            return intValue <= 0 || ((float) this.G.video.video_height.intValue()) / ((float) intValue) < 1.0f;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    public final void q0() {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        TbPageContext tbPageContext = this.m;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.getAdFacadeData() == null || TextUtils.isEmpty(this.G.getScheme())) {
            return;
        }
        String scheme = this.G.getScheme();
        AdvertAppInfo v = this.G.getAdFacadeData().v();
        int f2 = w.o(this.G.getScheme()) ? w.f(this.m.getPageActivity(), scheme) : 0;
        d.b.j0.j1.o.a aVar = this.o;
        if (aVar != null) {
            aVar.a(f2, null);
        }
        d.b.j0.s2.h0.e eVar = this.O;
        if (eVar != null) {
            eVar.a(false);
        }
        if (f2 == 1000) {
            return;
        }
        String m2 = w.m(scheme);
        if (this.D.T0() && v != null && d.b.j0.a.e().q()) {
            w.e(this.m, m2, p(v), v.T3);
            return;
        }
        AdWebVideoActivity.setStaticInfo(v, this.G.getAdFacadeData().f43240g != null ? this.G.getAdFacadeData().f43240g.e() : 0, "DETAIL");
        Bundle bundle = new Bundle();
        bundle.putString("video_url", this.G.video.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.G.video.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.T);
        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.G.tailFrame.e());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, p(this.G.getAdFacadeData().v()));
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(this.m.getPageActivity(), "", m2, true, true, true, bundle));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: r0 */
    public void y(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2) {
        this.z.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.A.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.I.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
        this.J.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
        SkinManager.setBackgroundResource(this.J, R.drawable.btn_rouned_corner_bg_shape);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: s0 */
    public void z(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        this.G = videoMiddlePageAdCard;
        z0();
        this.z.setText(videoMiddlePageAdCard.threadTitle);
        this.C.setText(videoMiddlePageAdCard.userName);
        if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith("http")) {
            this.B.W(videoMiddlePageAdCard.userPortrait, 10, false);
        } else {
            this.B.W(videoMiddlePageAdCard.userPortrait, 12, false);
        }
        this.B.setOnLongClickListener(new d());
        this.A.setText(videoMiddlePageAdCard.tagName);
        this.I.setText(videoMiddlePageAdCard.operateData.f20404b);
        this.J.setText(videoMiddlePageAdCard.operateData.f20406d);
        this.J.setOnClickListener(new e(videoMiddlePageAdCard));
        o0(videoMiddlePageAdCard, this.f18324g, getAutoPlayCallBack());
        C0(videoMiddlePageAdCard);
        y(this.G, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.j1.o.l.h
    public void setAutoPlayCallBack(d.b.j0.q0.i1.a aVar) {
        this.K = aVar;
    }

    @Override // d.b.j0.j1.o.l.h
    public void setCurrentPlayCallBack(d.b.j0.j1.o.l.f fVar) {
        this.S = fVar;
    }

    @Override // d.b.j0.j1.o.l.h
    public void setOnVideoContainerForegroundClickListener(d.b.j0.q0.p2.c cVar) {
        this.R = cVar;
    }

    @Override // d.b.j0.j1.o.l.k
    public void stopPlay() {
        if (d.b.j0.o.g.a.a(this.D.B0()) < this.T && this.D.T0()) {
            w0(!this.L ? 1 : 0, this.D.B0());
        }
        B0();
        this.O.a(false);
    }

    public void t0() {
        d.b.j0.j2.c cVar = this.D;
        if (cVar != null) {
            cVar.v0();
        }
        this.U = false;
        this.V = true;
    }

    public final void u0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard = this.G;
        if (videoMiddlePageAdCard == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || this.U) {
            return;
        }
        int n2 = this.G.getAdFacadeData().n();
        d.b.d.d adFacadeData = this.G.getAdFacadeData();
        int i3 = this.T;
        d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.m(adFacadeData, 34, n2, i2, i3, i3, -1));
        this.U = true;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        return this.r;
    }

    public final void v0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard = this.G;
        if (videoMiddlePageAdCard == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.m(this.G.getAdFacadeData(), 33, this.G.getAdFacadeData().n(), i2, this.T, d.b.j0.o.g.a.a(i3), -1));
    }

    public final void w0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard = this.G;
        if (videoMiddlePageAdCard == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.m(this.G.getAdFacadeData(), 32, this.G.getAdFacadeData().n(), i2, this.T, d.b.j0.o.g.a.a(i3), -1));
    }

    public final void x0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard = this.G;
        if (videoMiddlePageAdCard == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.m(this.G.getAdFacadeData(), 36, this.G.getAdFacadeData().n(), i2, this.T, d.b.j0.o.g.a.a(this.D.B0()), -1));
    }

    public final void y0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard = this.G;
        if (videoMiddlePageAdCard == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || !this.V) {
            return;
        }
        d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.m(this.G.getAdFacadeData(), 31, this.G.getAdFacadeData().n(), i2, this.T, 0, -1));
        this.V = false;
    }

    public final void z0() {
        if (!p0()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.height = (int) (this.H * 0.875f);
            this.t.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.height = (int) (this.H * 0.5625f);
        this.t.setLayoutParams(layoutParams2);
    }
}
