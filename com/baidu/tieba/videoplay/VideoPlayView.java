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
import d.b.c.e.p.l;
import d.b.i0.b1.p.a;
import d.b.j0.j2.f;
import d.b.j0.q3.h;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f21686e;

    /* renamed from: f  reason: collision with root package name */
    public VerticalViewPager f21687f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayFragmentAdapter f21688g;
    public int i;
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
    public int f21689h = 0;
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
            VideoPlayView.this.E();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i0.b1.p.a.b
        public void k() {
            VideoPlayFragment i = VideoPlayView.this.f21688g.i(VideoPlayView.this.f21687f.getCurrentItem());
            if (i != null) {
                i.k();
            }
        }

        @Override // d.b.i0.b1.p.a.b
        public void l() {
            VideoPlayFragment i = VideoPlayView.this.f21688g.i(VideoPlayView.this.f21687f.getCurrentItem());
            if (i != null) {
                i.l();
            }
        }

        @Override // d.b.i0.b1.p.a.b
        public void r0(float f2, float f3) {
            VideoPlayFragment i = VideoPlayView.this.f21688g.i(VideoPlayView.this.f21687f.getCurrentItem());
            if (i != null) {
                i.r0(f2, f3);
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
            VideoPlayFragment i = VideoPlayView.this.f21688g.i(VideoPlayView.this.f21687f.getCurrentItem());
            if (i != null) {
                return i.I1();
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
            VideoPlayView.this.J();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f.c {
        public f() {
        }

        @Override // d.b.j0.j2.f.c
        public void a(int i, int i2) {
            VideoPlayView.this.G(i, i2);
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.l = videoPlayActivity;
        this.o = str;
        this.n = v(str);
        u(videoPlayActivity);
        this.f21686e = videoPlayActivity.findViewById(R.id.root_layout);
        this.f21687f = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.f21688g = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.n(new a());
        O();
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2 = this.f21688g;
        videoPlayFragmentAdapter2.f21677e = this.o;
        this.f21687f.setAdapter(videoPlayFragmentAdapter2);
        this.f21687f.setOffscreenPageLimit(1);
        this.f21687f.setEventListener(new b());
        this.f21687f.setOnPageChangeListener(this);
        this.f21687f.setOnTouchListener(new c());
    }

    public void A() {
        s();
        F();
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21688g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.k();
        }
        this.l = null;
    }

    public void B() {
        s();
    }

    public final void E() {
        if (this.f21689h == this.i && this.q) {
            Q(false);
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

    public final void G(int i, int i2) {
        int i3;
        if (this.r || !VideoPlayActivityConfig.FROM_DEFAULT.equals(p(this.o)) || (i3 = i - i2) <= 2500 || i3 >= 3500 || !this.q || !h.d()) {
            return;
        }
        Q(true);
        this.r = true;
        h.a();
    }

    public final void I() {
        this.f21687f.scrollTo(0, 0);
    }

    public final void J() {
        if (this.n) {
            d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
            j.t("video_play_vertical_first_in" + p(this.o), false);
            this.n = false;
        }
    }

    public void K(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21688g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.f21679g = str;
        }
    }

    public void L(g gVar) {
        this.k = gVar;
    }

    public void M(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21688g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.f21676d = str;
        }
    }

    public final void O() {
        this.f21688g.m(new f());
    }

    public void P(List<VideoItemData> list, int i, Rect rect) {
        this.j = list;
        this.i = i;
        this.f21688g.l(list, rect);
        this.f21688g.notifyDataSetChanged();
        this.f21687f.setCurrentItem(i);
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
        int i;
        int i2;
        double d2;
        double d3 = f2;
        if (d3 <= 0.17d) {
            i = (int) (this.p * f2 * 6.0f);
        } else if (d3 <= 0.25d) {
            i = this.f21687f.getScrollY();
        } else {
            double d4 = 0.42d;
            if (d3 <= 0.42d) {
                i2 = this.p;
            } else if (d3 <= 0.5d) {
                i = this.f21687f.getScrollY();
            } else if (d3 <= 0.67d) {
                d2 = this.p * (d3 - 0.5d);
                i = (int) (d2 * 6.0d);
            } else if (d3 <= 0.75d) {
                i = this.f21687f.getScrollY();
            } else {
                d4 = 0.92d;
                if (d3 <= 0.92d) {
                    i2 = this.p;
                } else {
                    i = 0;
                }
            }
            d2 = i2 * (d4 - d3);
            i = (int) (d2 * 6.0d);
        }
        this.f21687f.scrollTo(0, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            s();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        if (i != 0 || (videoPlayFragmentAdapter = this.f21688g) == null || (verticalViewPager = this.f21687f) == null) {
            return;
        }
        videoPlayFragmentAdapter.j(verticalViewPager.getCurrentItem());
        if (w()) {
            this.f21687f.setNeedHanleTouch(true);
            this.f21687f.setSelected(true);
            VerticalViewPager verticalViewPager2 = this.f21687f;
            verticalViewPager2.setCurrentItem(verticalViewPager2.getCurrentItem(), true);
            this.f21687f.setNeedHanleTouch(false);
            this.s = false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        if (i2 > l.i(TbadkCoreApplication.getInst())) {
            this.s = true;
        }
        if (w()) {
            this.f21687f.setNeedHanleTouch(true);
        } else {
            this.f21687f.setNeedHanleTouch(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        g gVar;
        this.f21689h = i;
        if (this.i != i && this.q) {
            this.q = false;
        }
        if (!ListUtils.isEmpty(this.j) && this.j.size() - 1 > 0 && this.j.size() - i <= 2 && (gVar = this.k) != null) {
            gVar.a();
        }
        if (w()) {
            this.f21687f.computeScroll();
        }
    }

    public final String p(String str) {
        return "video_tab".equals(str) ? "video_tab" : VideoPlayActivityConfig.FROM_DEFAULT;
    }

    public void q(int i, int i2, Intent intent) {
        VerticalViewPager verticalViewPager;
        VideoPlayFragment i3;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21688g;
        if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21687f) == null || (i3 = videoPlayFragmentAdapter.i(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        i3.H1(i, i2, intent);
    }

    public boolean r() {
        VerticalViewPager verticalViewPager;
        VideoPlayFragment i;
        if (x()) {
            return true;
        }
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21688g;
        if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21687f) == null || (i = videoPlayFragmentAdapter.i(verticalViewPager.getCurrentItem())) == null) {
            return false;
        }
        return i.I1();
    }

    public final void s() {
        TBLottieAnimationView tBLottieAnimationView = this.m;
        if (tBLottieAnimationView != null) {
            if (tBLottieAnimationView.isAnimating()) {
                this.m.pauseAnimation();
                I();
            }
            this.m.setVisibility(8);
        }
    }

    public final void u(VideoPlayActivity videoPlayActivity) {
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.m = tBLottieAnimationView;
        tBLottieAnimationView.setAnimation(R.raw.lottie_video_guide);
        this.m.setImageAssetsFolder("lottie_video_guide");
        this.m.setOnClickListener(this);
        this.m.addAnimatorUpdateListener(new d());
        this.m.addAnimatorListener(new e());
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public final boolean v(String str) {
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        return j.g("video_play_vertical_first_in" + p(str), true);
    }

    public final boolean w() {
        return DeviceInfoUtil.isHuaWeiVirtual() && this.s && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0;
    }

    public final boolean x() {
        TBLottieAnimationView tBLottieAnimationView = this.m;
        if (tBLottieAnimationView == null || !tBLottieAnimationView.isAnimating()) {
            return false;
        }
        s();
        return true;
    }

    public void y() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21688g;
        if (videoPlayFragmentAdapter != null) {
            videoPlayFragmentAdapter.notifyDataSetChanged();
        }
    }

    public void z(int i) {
        SkinManager.setBackgroundColor(this.f21686e, R.color.CAM_X0201, i);
        if (UtilHelper.isFlyMeOs()) {
            return;
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this.l);
    }
}
