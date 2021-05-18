package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import d.a.c.e.p.l;
import d.a.j0.b1.p.a;
import d.a.k0.j2.f;
import d.a.k0.q3.h;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f21574e;

    /* renamed from: f  reason: collision with root package name */
    public VerticalViewPager f21575f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayFragmentAdapter f21576g;

    /* renamed from: i  reason: collision with root package name */
    public int f21578i;
    public List<VideoItemData> j;
    public g k;
    public VideoPlayActivity l;
    public TBLottieAnimationView m;
    public boolean n;
    public String o;
    public int p;
    public boolean s;
    public float t;

    /* renamed from: h  reason: collision with root package name */
    public int f21577h = 0;
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

        @Override // d.a.j0.b1.p.a.b
        public void N(float f2, float f3) {
            VideoPlayFragment b2 = VideoPlayView.this.f21576g.b(VideoPlayView.this.f21575f.getCurrentItem());
            if (b2 != null) {
                b2.N(f2, f3);
            }
        }

        @Override // d.a.j0.b1.p.a.b
        public void j() {
            VideoPlayFragment b2 = VideoPlayView.this.f21576g.b(VideoPlayView.this.f21575f.getCurrentItem());
            if (b2 != null) {
                b2.j();
            }
        }

        @Override // d.a.j0.b1.p.a.b
        public void l() {
            VideoPlayFragment b2 = VideoPlayView.this.f21576g.b(VideoPlayView.this.f21575f.getCurrentItem());
            if (b2 != null) {
                b2.l();
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
            VideoPlayFragment b2 = VideoPlayView.this.f21576g.b(VideoPlayView.this.f21575f.getCurrentItem());
            if (b2 != null) {
                return b2.H1();
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

        @Override // d.a.k0.j2.f.c
        public void a(int i2, int i3) {
            VideoPlayView.this.G(i2, i3);
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.l = videoPlayActivity;
        this.o = str;
        this.n = u(str);
        t(videoPlayActivity);
        this.f21574e = videoPlayActivity.findViewById(R.id.root_layout);
        this.f21575f = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.f21576g = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.g(new a());
        M();
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2 = this.f21576g;
        videoPlayFragmentAdapter2.f21563e = this.o;
        this.f21575f.setAdapter(videoPlayFragmentAdapter2);
        this.f21575f.setOffscreenPageLimit(1);
        this.f21575f.setEventListener(new b());
        this.f21575f.setOnPageChangeListener(this);
        this.f21575f.setOnTouchListener(new c());
    }

    public void A() {
        s();
    }

    public final void B() {
        if (this.f21577h == this.f21578i && this.q) {
            O(false);
        }
    }

    public final void F() {
        if (this.r) {
            h.c();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(p(this.o))) {
            if (this.q) {
                h.b();
            } else {
                h.c();
            }
        }
    }

    public final void G(int i2, int i3) {
        int i4;
        if (this.r || !VideoPlayActivityConfig.FROM_DEFAULT.equals(p(this.o)) || (i4 = i2 - i3) <= 2500 || i4 >= 3500 || !this.q || !h.d()) {
            return;
        }
        O(true);
        this.r = true;
        h.a();
    }

    public final void H() {
        this.f21575f.scrollTo(0, 0);
    }

    public final void I() {
        if (this.n) {
            d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
            j.t("video_play_vertical_first_in" + p(this.o), false);
            this.n = false;
        }
    }

    public void J(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21576g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.f21565g = str;
        }
    }

    public void K(g gVar) {
        this.k = gVar;
    }

    public void L(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21576g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.f21562d = str;
        }
    }

    public final void M() {
        this.f21576g.f(new f());
    }

    public void N(List<VideoItemData> list, int i2, Rect rect) {
        this.j = list;
        this.f21578i = i2;
        this.f21576g.e(list, rect);
        this.f21576g.notifyDataSetChanged();
        this.f21575f.setCurrentItem(i2);
    }

    public final boolean O(boolean z) {
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
            i2 = this.f21575f.getScrollY();
        } else {
            double d4 = 0.42d;
            if (d3 <= 0.42d) {
                i3 = this.p;
            } else if (d3 <= 0.5d) {
                i2 = this.f21575f.getScrollY();
            } else if (d3 <= 0.67d) {
                d2 = this.p * (d3 - 0.5d);
                i2 = (int) (d2 * 6.0d);
            } else if (d3 <= 0.75d) {
                i2 = this.f21575f.getScrollY();
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
        this.f21575f.scrollTo(0, i2);
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
        if (i2 != 0 || (videoPlayFragmentAdapter = this.f21576g) == null || (verticalViewPager = this.f21575f) == null) {
            return;
        }
        videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
        if (v()) {
            this.f21575f.setNeedHanleTouch(true);
            this.f21575f.setSelected(true);
            VerticalViewPager verticalViewPager2 = this.f21575f;
            verticalViewPager2.setCurrentItem(verticalViewPager2.getCurrentItem(), true);
            this.f21575f.setNeedHanleTouch(false);
            this.s = false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        if (i3 > l.i(TbadkCoreApplication.getInst())) {
            this.s = true;
        }
        if (v()) {
            this.f21575f.setNeedHanleTouch(true);
        } else {
            this.f21575f.setNeedHanleTouch(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        g gVar;
        this.f21577h = i2;
        if (this.f21578i != i2 && this.q) {
            this.q = false;
        }
        if (!ListUtils.isEmpty(this.j) && this.j.size() - 1 > 0 && this.j.size() - i2 <= 2 && (gVar = this.k) != null) {
            gVar.a();
        }
        if (v()) {
            this.f21575f.computeScroll();
        }
    }

    public final String p(String str) {
        return "video_tab".equals(str) ? "video_tab" : VideoPlayActivityConfig.FROM_DEFAULT;
    }

    public void q(int i2, int i3, Intent intent) {
        VerticalViewPager verticalViewPager;
        VideoPlayFragment b2;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21576g;
        if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21575f) == null || (b2 = videoPlayFragmentAdapter.b(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        b2.G1(i2, i3, intent);
    }

    public boolean r() {
        VerticalViewPager verticalViewPager;
        VideoPlayFragment b2;
        if (w()) {
            return true;
        }
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21576g;
        if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21575f) == null || (b2 = videoPlayFragmentAdapter.b(verticalViewPager.getCurrentItem())) == null) {
            return false;
        }
        return b2.H1();
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

    public final void t(VideoPlayActivity videoPlayActivity) {
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.m = tBLottieAnimationView;
        tBLottieAnimationView.setAnimation(R.raw.lottie_video_guide);
        this.m.setImageAssetsFolder("lottie_video_guide");
        this.m.setOnClickListener(this);
        this.m.addAnimatorUpdateListener(new d());
        this.m.addAnimatorListener(new e());
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public final boolean u(String str) {
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
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
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21576g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.notifyDataSetChanged();
        }
    }

    public void y(int i2) {
        SkinManager.setBackgroundColor(this.f21574e, R.color.CAM_X0201, i2);
        if (UtilHelper.isFlyMeOs()) {
            return;
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this.l);
    }

    public void z() {
        s();
        F();
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21576g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.d();
        }
        this.l = null;
    }
}
