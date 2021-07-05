package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.b1.p.a;
import d.a.s0.n2.f;
/* loaded from: classes5.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;

    /* renamed from: e  reason: collision with root package name */
    public View f21800e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f21801f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.f0.f f21802g;

    /* renamed from: h  reason: collision with root package name */
    public VerticalViewPager f21803h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPlayFragmentAdapter f21804i;
    public int j;
    public int k;
    public d.a.s0.x3.b.c l;
    public g m;
    public FragmentActivity n;
    public TBLottieAnimationView o;
    public boolean p;
    public String q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public float w;
    public int x;
    public int y;
    public h z;

    /* loaded from: classes5.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21805a;

        public a(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21805a = videoPlayView;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view)) == null) {
                if (this.f21805a.f21803h == null) {
                    return false;
                }
                VideoAttentionListPageFragment q = this.f21805a.q();
                return q != null ? (this.f21805a.f21803h.getCurrentItem() == 0 && q.H0()) ? false : true : this.f21805a.f21803h.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements VideoPlayFragment.l0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21806a;

        public b(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21806a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.l0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21806a.H();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21807e;

        public c(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21807e = videoPlayView;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.f21807e.w == 0.0f) {
                                this.f21807e.w = motionEvent.getY();
                            }
                            float y = motionEvent.getY() - this.f21807e.w;
                            if (this.f21807e.w > (l.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.f21807e.x && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.f21807e.n) && l.j(TbadkCoreApplication.getInst(), true) != this.f21807e.y) {
                                this.f21807e.u = true;
                            }
                        }
                    }
                    this.f21807e.w = 0.0f;
                } else {
                    this.f21807e.w = motionEvent.getY();
                    this.f21807e.u = false;
                }
                VideoPlayFragment k = this.f21807e.f21804i.k(this.f21807e.f21803h.getCurrentItem());
                if (k != null) {
                    return k.Q1();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21808e;

        public d(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21808e = videoPlayView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && this.f21808e.o.isAnimating()) {
                this.f21808e.p(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21809e;

        public e(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21809e = videoPlayView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f21809e.K();
                this.f21809e.o.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f21809e.v();
                this.f21809e.o.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f21809e.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21810a;

        public f(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21810a = videoPlayView;
        }

        @Override // d.a.s0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f21810a.J(i2, i3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a();
    }

    public VideoPlayView(FragmentActivity fragmentActivity, BaseFragment baseFragment, String str, BdUniqueId bdUniqueId, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity, baseFragment, str, bdUniqueId, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.x = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.y = 2049;
        this.n = fragmentActivity;
        this.q = str;
        this.s = true;
        this.t = false;
        this.p = x(str);
        w(fragmentActivity);
        this.f21800e = baseFragment.getView().findViewById(R.id.root_layout);
        this.f21803h = (VerticalViewPager) baseFragment.getView().findViewById(R.id.video_play_viewpager);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.refresh_layout);
        this.f21801f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setNoMoveTargetView(true);
        this.f21801f.setLimitDragDistance(true);
        d.a.r0.r.f0.f fVar = new d.a.r0.r.f0.f(fragmentActivity);
        this.f21802g = fVar;
        this.f21801f.setProgressView(fVar);
        this.f21801f.setOnChildScrollUpCallback(new a(this));
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(baseFragment, fragmentActivity, bdUniqueId, i2);
        this.f21804i = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.q(new b(this));
        if (this.f21804i != null) {
            MessageManager.getInstance().registerListener(this.f21804i.j());
        }
        W();
        this.f21804i.f21788e = this.q;
        this.f21803h.setOffscreenPageLimit(1);
        this.f21803h.setAdapter(this.f21804i);
        this.f21803h.setOnPageChangeListener(this);
        this.f21803h.setOnTouchListener(new c(this));
    }

    public void A() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayFragmentAdapter = this.f21804i) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f21800e, R.color.CAM_X0611, i2);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f21804i != null) {
                MessageManager.getInstance().unRegisterListener(this.f21804i.j());
            }
            R(false);
            v();
            I();
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21804i;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.m();
            }
            this.n = null;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            v();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.j == this.k && this.s) {
            Z(false);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.t) {
                d.a.s0.v3.g.c();
            } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(s(this.q))) {
                if (this.s) {
                    d.a.s0.v3.g.b();
                } else {
                    d.a.s0.v3.g.c();
                }
            }
        }
    }

    public final void J(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) && !this.t && VideoPlayActivityConfig.FROM_DEFAULT.equals(s(this.q)) && (i4 = i2 - i3) > 2500 && i4 < 3500 && this.s && d.a.s0.v3.g.d()) {
            Z(true);
            this.t = true;
            d.a.s0.v3.g.a();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21803h.scrollTo(0, 0);
        }
    }

    public void L(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
            this.z = hVar;
        }
    }

    public void M(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f21803h.setEventListener(bVar);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.p) {
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            j.t("video_play_vertical_first_in" + s(this.q), false);
            this.p = false;
        }
    }

    public void O(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (videoPlayFragmentAdapter = this.f21804i) == null) {
            return;
        }
        videoPlayFragmentAdapter.f21790g = str;
    }

    public void P(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.m = gVar;
        }
    }

    public void Q(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (videoPlayFragmentAdapter = this.f21804i) == null) {
            return;
        }
        videoPlayFragmentAdapter.f21787d = str;
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.f21801f != null) {
                if (!TbadkCoreApplication.isLogin() && this.v == 0) {
                    this.f21801f.setEnabled(false);
                } else {
                    this.f21801f.setEnabled(true);
                }
            }
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21804i;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.p(z);
            }
            if (UtilHelper.isFlyMeOs()) {
                return;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z && skinType != 4 && skinType != 1) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.n);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.n);
            }
        }
    }

    public void S(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            this.f21802g.K().findViewById(R.id.continuous_loading_layout).setVisibility(4);
            this.f21801f.setProgressViewCallback(kVar);
        }
    }

    public void T(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f21803h.setCurrentItem(i2, z);
        }
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.v = i2;
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f21804i.o(new f(this));
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f21803h.setScrollable(z);
        }
    }

    public void Y(d.a.s0.x3.b.c cVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, cVar, i2, rect) == null) {
            this.l = cVar;
            this.k = i2;
            this.f21804i.n(cVar, rect);
            this.f21804i.notifyDataSetChanged();
            this.f21803h.setCurrentItem(i2);
        }
    }

    public final boolean Z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (this.o == null) {
                return false;
            }
            if (this.p || z) {
                this.o.setVisibility(0);
                this.o.playAnimation();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view) == null) && view.getId() == R.id.guide_animation_view) {
            v();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        h hVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            if (i2 == 0 && (videoPlayFragmentAdapter = this.f21804i) != null && (verticalViewPager = this.f21803h) != null) {
                videoPlayFragmentAdapter.l(verticalViewPager.getCurrentItem());
                if (y()) {
                    this.f21803h.setNeedHanleTouch(true);
                    this.f21803h.setSelected(true);
                    VerticalViewPager verticalViewPager2 = this.f21803h;
                    verticalViewPager2.setCurrentItem(verticalViewPager2.getCurrentItem(), true);
                    this.f21803h.setNeedHanleTouch(false);
                    this.u = false;
                }
            }
            if (i2 == 0) {
                if (this.A || (hVar = this.z) == null) {
                    return;
                }
                hVar.a();
            } else if (i2 == 1) {
                this.A = false;
            } else if (i2 != 2) {
            } else {
                this.A = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > l.i(TbadkCoreApplication.getInst())) {
                this.u = true;
            }
            if (y()) {
                this.f21803h.setNeedHanleTouch(true);
            } else {
                this.f21803h.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.j = i2;
            if (this.k != i2 && this.s) {
                this.s = false;
            }
            if (!this.l.m() && this.l.e() - 1 > 0 && this.l.e() - i2 <= 2 && (gVar = this.m) != null) {
                gVar.a();
            }
            if (y()) {
                this.f21803h.computeScroll();
            }
        }
    }

    public final void p(float f2) {
        int i2;
        int i3;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            double d3 = f2;
            if (d3 <= 0.17d) {
                i2 = (int) (this.r * f2 * 6.0f);
            } else if (d3 <= 0.25d) {
                i2 = this.f21803h.getScrollY();
            } else {
                double d4 = 0.42d;
                if (d3 <= 0.42d) {
                    i3 = this.r;
                } else if (d3 <= 0.5d) {
                    i2 = this.f21803h.getScrollY();
                } else if (d3 <= 0.67d) {
                    d2 = this.r * (d3 - 0.5d);
                    i2 = (int) (d2 * 6.0d);
                } else if (d3 <= 0.75d) {
                    i2 = this.f21803h.getScrollY();
                } else {
                    d4 = 0.92d;
                    if (d3 <= 0.92d) {
                        i3 = this.r;
                    } else {
                        i2 = 0;
                    }
                }
                d2 = i3 * (d4 - d3);
                i2 = (int) (d2 * 6.0d);
            }
            this.f21803h.scrollTo(0, i2);
        }
    }

    public VideoAttentionListPageFragment q() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21804i;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21803h) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.i(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public VideoPlayFragment r() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21804i;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21803h) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.k(verticalViewPager.getCurrentItem());
        }
        return (VideoPlayFragment) invokeV.objValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? "video_tab".equals(str) ? "video_tab" : VideoPlayActivityConfig.FROM_DEFAULT : (String) invokeL.objValue;
    }

    public void t(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048606, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.f21804i) == null || (verticalViewPager = this.f21803h) == null || (k = videoPlayFragmentAdapter.k(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        k.P1(i2, i3, intent);
    }

    public boolean u() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (z()) {
                return true;
            }
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21804i;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21803h) == null || (k = videoPlayFragmentAdapter.k(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return k.Q1();
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (tBLottieAnimationView = this.o) != null && tBLottieAnimationView.isAnimating()) {
            this.o.cancelAnimation();
        }
    }

    public final void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, activity) == null) {
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) activity.findViewById(R.id.guide_animation_view);
            this.o = tBLottieAnimationView;
            tBLottieAnimationView.setAnimation(R.raw.lottie_video_guide);
            this.o.setImageAssetsFolder("lottie_video_guide");
            this.o.setOnClickListener(this);
            this.o.addAnimatorUpdateListener(new d(this));
            this.o.addAnimatorListener(new e(this));
            this.r = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
        }
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
            return j.g("video_play_vertical_first_in" + s(str), true);
        }
        return invokeL.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.u && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView == null || !tBLottieAnimationView.isAnimating()) {
                return false;
            }
            v();
            return true;
        }
        return invokeV.booleanValue;
    }
}
