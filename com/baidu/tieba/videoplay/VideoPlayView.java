package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import d.a.c.e.p.l;
import d.a.n0.b1.p.a;
import d.a.o0.k2.f;
/* loaded from: classes5.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f21668e;

    /* renamed from: f  reason: collision with root package name */
    public VerticalViewPager f21669f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayFragmentAdapter f21670g;

    /* renamed from: i  reason: collision with root package name */
    public int f21672i;
    public d.a.o0.t3.a.c j;
    public g k;
    public FragmentActivity l;
    public TBLottieAnimationView m;
    public boolean n;
    public String o;
    public int p;
    public boolean s;
    public float t;

    /* renamed from: h  reason: collision with root package name */
    public int f21671h = 0;
    public int u = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
    public int v = 2049;
    public boolean q = true;
    public boolean r = false;

    /* loaded from: classes5.dex */
    public class a implements VideoPlayFragment.k0 {
        public a() {
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.k0
        public void onStart() {
            VideoPlayView.this.B();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.n0.b1.p.a.b
        public void O(float f2, float f3) {
            VideoPlayFragment i2 = VideoPlayView.this.f21670g.i(VideoPlayView.this.f21669f.getCurrentItem());
            if (i2 != null) {
                i2.O(f2, f3);
            }
        }

        @Override // d.a.n0.b1.p.a.b
        public void k() {
            VideoPlayFragment i2 = VideoPlayView.this.f21670g.i(VideoPlayView.this.f21669f.getCurrentItem());
            if (i2 != null) {
                i2.k();
            }
        }

        @Override // d.a.n0.b1.p.a.b
        public void m() {
            VideoPlayFragment i2 = VideoPlayView.this.f21670g.i(VideoPlayView.this.f21669f.getCurrentItem());
            if (i2 != null) {
                i2.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (r5 != 3) goto L9;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (VideoPlayView.this.t == 0.0f) {
                            VideoPlayView.this.t = motionEvent.getY();
                        }
                        float y = motionEvent.getY() - VideoPlayView.this.t;
                        if (VideoPlayView.this.t > (l.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - VideoPlayView.this.u && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(VideoPlayView.this.l) && l.j(TbadkCoreApplication.getInst(), true) != VideoPlayView.this.v) {
                            VideoPlayView.this.s = true;
                        }
                    }
                }
                VideoPlayView.this.t = 0.0f;
            } else {
                VideoPlayView.this.t = motionEvent.getY();
                VideoPlayView.this.s = false;
            }
            VideoPlayFragment i2 = VideoPlayView.this.f21670g.i(VideoPlayView.this.f21669f.getCurrentItem());
            if (i2 != null) {
                return i2.O1();
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (VideoPlayView.this.m.isAnimating()) {
                VideoPlayView.this.o(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPlayView.this.s();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            VideoPlayView.this.I();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f.c {
        public f() {
        }

        @Override // d.a.o0.k2.f.c
        public void a(int i2, int i3) {
            VideoPlayView.this.G(i2, i3);
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();
    }

    public VideoPlayView(FragmentActivity fragmentActivity, String str, BdUniqueId bdUniqueId) {
        this.l = fragmentActivity;
        this.o = str;
        this.n = u(str);
        t(fragmentActivity);
        this.f21668e = fragmentActivity.findViewById(R.id.root_layout);
        this.f21669f = (VerticalViewPager) fragmentActivity.findViewById(R.id.video_play_viewpager);
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(fragmentActivity.getSupportFragmentManager(), fragmentActivity);
        this.f21670g = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.o(new a());
        O();
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2 = this.f21670g;
        videoPlayFragmentAdapter2.f21657e = this.o;
        this.f21669f.setAdapter(videoPlayFragmentAdapter2);
        this.f21669f.setOffscreenPageLimit(1);
        this.f21669f.setEventListener(new b());
        this.f21669f.setOnPageChangeListener(this);
        this.f21669f.setOnTouchListener(new c());
    }

    public void A() {
        s();
    }

    public final void B() {
        if (this.f21671h == this.f21672i && this.q) {
            Q(false);
        }
    }

    public final void F() {
        if (this.r) {
            d.a.o0.r3.g.c();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(p(this.o))) {
            if (this.q) {
                d.a.o0.r3.g.b();
            } else {
                d.a.o0.r3.g.c();
            }
        }
    }

    public final void G(int i2, int i3) {
        int i4;
        if (this.r || !VideoPlayActivityConfig.FROM_DEFAULT.equals(p(this.o)) || (i4 = i2 - i3) <= 2500 || i4 >= 3500 || !this.q || !d.a.o0.r3.g.d()) {
            return;
        }
        Q(true);
        this.r = true;
        d.a.o0.r3.g.a();
    }

    public final void H() {
        this.f21669f.scrollTo(0, 0);
    }

    public final void I() {
        if (this.n) {
            d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
            j.t("video_play_vertical_first_in" + p(this.o), false);
            this.n = false;
        }
    }

    public void J(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.f21659g = str;
        }
    }

    public void K(g gVar) {
        this.k = gVar;
    }

    public void L(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.f21656d = str;
        }
    }

    public void M(boolean z) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.n(z);
        }
        if (UtilHelper.isFlyMeOs()) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z && skinType != 4 && skinType != 1) {
            UtilHelper.changeStatusBarIconAndTextColor(false, this.l);
        } else {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.l);
        }
    }

    public void N(int i2, boolean z) {
        this.f21669f.setCurrentItem(i2, z);
    }

    public final void O() {
        this.f21670g.m(new f());
    }

    public void P(d.a.o0.t3.a.c cVar, int i2, Rect rect) {
        this.j = cVar;
        this.f21672i = i2;
        this.f21670g.l(cVar, rect);
        this.f21670g.notifyDataSetChanged();
        this.f21669f.setCurrentItem(i2);
    }

    public final boolean Q(boolean z) {
        if (this.m == null) {
            return false;
        }
        if (this.n || z) {
            this.m.setVisibility(0);
            this.m.playAnimation();
            return true;
        }
        return false;
    }

    public final void o(float f2) {
        int i2;
        int i3;
        double d2;
        double d3 = f2;
        if (d3 <= 0.17d) {
            i2 = (int) (this.p * f2 * 6.0f);
        } else if (d3 <= 0.25d) {
            i2 = this.f21669f.getScrollY();
        } else {
            double d4 = 0.42d;
            if (d3 <= 0.42d) {
                i3 = this.p;
            } else if (d3 <= 0.5d) {
                i2 = this.f21669f.getScrollY();
            } else if (d3 <= 0.67d) {
                d2 = this.p * (d3 - 0.5d);
                i2 = (int) (d2 * 6.0d);
            } else if (d3 <= 0.75d) {
                i2 = this.f21669f.getScrollY();
            } else {
                d4 = 0.92d;
                if (d3 <= 0.92d) {
                    i3 = this.p;
                } else {
                    i2 = 0;
                }
            }
            d2 = i3 * (d4 - d3);
            i2 = (int) (d2 * 6.0d);
        }
        this.f21669f.scrollTo(0, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            s();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        if (i2 != 0 || (videoPlayFragmentAdapter = this.f21670g) == null || (verticalViewPager = this.f21669f) == null) {
            return;
        }
        videoPlayFragmentAdapter.j(verticalViewPager.getCurrentItem());
        if (v()) {
            this.f21669f.setNeedHanleTouch(true);
            this.f21669f.setSelected(true);
            VerticalViewPager verticalViewPager2 = this.f21669f;
            verticalViewPager2.setCurrentItem(verticalViewPager2.getCurrentItem(), true);
            this.f21669f.setNeedHanleTouch(false);
            this.s = false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        if (i3 > l.i(TbadkCoreApplication.getInst())) {
            this.s = true;
        }
        if (v()) {
            this.f21669f.setNeedHanleTouch(true);
        } else {
            this.f21669f.setNeedHanleTouch(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        g gVar;
        this.f21671h = i2;
        if (this.f21672i != i2 && this.q) {
            this.q = false;
        }
        if (!this.j.i() && this.j.d() - 1 > 0 && this.j.d() - i2 <= 2 && (gVar = this.k) != null) {
            gVar.a();
        }
        if (v()) {
            this.f21669f.computeScroll();
        }
    }

    public final String p(String str) {
        return "video_tab".equals(str) ? "video_tab" : VideoPlayActivityConfig.FROM_DEFAULT;
    }

    public void q(int i2, int i3, Intent intent) {
        VerticalViewPager verticalViewPager;
        VideoPlayFragment i4;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21669f) == null || (i4 = videoPlayFragmentAdapter.i(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        i4.N1(i2, i3, intent);
    }

    public boolean r() {
        VerticalViewPager verticalViewPager;
        VideoPlayFragment i2;
        if (w()) {
            return true;
        }
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21669f) == null || (i2 = videoPlayFragmentAdapter.i(verticalViewPager.getCurrentItem())) == null) {
            return false;
        }
        return i2.O1();
    }

    public final void s() {
        TBLottieAnimationView tBLottieAnimationView = this.m;
        if (tBLottieAnimationView != null) {
            if (tBLottieAnimationView.isAnimating()) {
                this.m.pauseAnimation();
                H();
            }
            this.m.setVisibility(8);
        }
    }

    public final void t(Activity activity) {
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) activity.findViewById(R.id.guide_animation_view);
        this.m = tBLottieAnimationView;
        tBLottieAnimationView.setAnimation(R.raw.lottie_video_guide);
        this.m.setImageAssetsFolder("lottie_video_guide");
        this.m.setOnClickListener(this);
        this.m.addAnimatorUpdateListener(new d());
        this.m.addAnimatorListener(new e());
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public final boolean u(String str) {
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        return j.g("video_play_vertical_first_in" + p(str), true);
    }

    public final boolean v() {
        return DeviceInfoUtil.isHuaWeiVirtual() && this.s && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0;
    }

    public final boolean w() {
        TBLottieAnimationView tBLottieAnimationView = this.m;
        if (tBLottieAnimationView == null || !tBLottieAnimationView.isAnimating()) {
            return false;
        }
        s();
        return true;
    }

    public void x() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.notifyDataSetChanged();
        }
    }

    public void y(int i2) {
        SkinManager.setBackgroundColor(this.f21668e, R.color.CAM_X0201, i2);
    }

    public void z() {
        M(false);
        s();
        F();
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21670g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.k();
        }
        this.l = null;
    }
}
