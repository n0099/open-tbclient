package com.baidu.tieba.videoplay;

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
import d.a.o0.b1.p.a;
import d.a.p0.n2.f;
/* loaded from: classes4.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, f.c, d.a.p0.x3.c.c, d.a.p0.x3.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f21850e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f21851f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r.f0.f f21852g;

    /* renamed from: h  reason: collision with root package name */
    public VerticalViewPager f21853h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPlayFragmentAdapter f21854i;
    public int j;
    public int k;
    public d.a.p0.x3.c.d l;
    public d m;
    public FragmentActivity n;
    public TBLottieAnimationView o;
    public String p;
    public boolean q;
    public int r;
    public float s;
    public int t;
    public int u;
    public d.a.p0.x3.d.a v;
    public d.a.p0.x3.d.b w;
    public e x;
    public boolean y;
    public String z;

    /* loaded from: classes4.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21855a;

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
            this.f21855a = videoPlayView;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view)) == null) {
                if (this.f21855a.f21853h == null) {
                    return false;
                }
                VideoAttentionListPageFragment p = this.f21855a.p();
                return p != null ? (this.f21855a.f21853h.getCurrentItem() == 0 && p.I0()) ? false : true : this.f21855a.f21853h.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements VideoPlayFragment.p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21856a;

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
            this.f21856a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.p0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21856a.z.equals("from_attention_sub_fragment")) {
                return;
            }
            this.f21856a.v.c();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21857e;

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
            this.f21857e = videoPlayView;
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
                            if (this.f21857e.s == 0.0f) {
                                this.f21857e.s = motionEvent.getY();
                            }
                            float y = motionEvent.getY() - this.f21857e.s;
                            if (this.f21857e.s > (l.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.f21857e.t && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.f21857e.n) && l.j(TbadkCoreApplication.getInst(), true) != this.f21857e.u) {
                                this.f21857e.q = true;
                            }
                        }
                    }
                    this.f21857e.s = 0.0f;
                } else {
                    this.f21857e.s = motionEvent.getY();
                    this.f21857e.q = false;
                }
                VideoPlayFragment e2 = this.f21857e.f21854i.e(this.f21857e.f21853h.getCurrentItem());
                if (e2 != null) {
                    return e2.S1();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface e {
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
        this.t = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.u = 2049;
        this.w = new d.a.p0.x3.d.b();
        this.z = "from_no_sub_fragment";
        this.n = fragmentActivity;
        this.p = str;
        this.o = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.guide_animation_view);
        this.f21850e = baseFragment.getView().findViewById(R.id.root_layout);
        this.f21853h = (VerticalViewPager) baseFragment.getView().findViewById(R.id.video_play_viewpager);
        this.v = new d.a.p0.x3.d.a(this.o, this.f21853h);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.refresh_layout);
        this.f21851f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setNoMoveTargetView(true);
        this.f21851f.setLimitDragDistance(true);
        d.a.o0.r.f0.f fVar = new d.a.o0.r.f0.f(fragmentActivity);
        this.f21852g = fVar;
        this.f21851f.setProgressView(fVar);
        this.f21851f.setOnChildScrollUpCallback(new a(this));
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(baseFragment, fragmentActivity, bdUniqueId, i2);
        this.f21854i = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.m(new b(this));
        this.f21854i.l(this);
        MessageManager.getInstance().registerListener(this.f21854i.d());
        this.f21854i.j(this);
        this.f21854i.f21838e = this.p;
        this.f21853h.setOffscreenPageLimit(1);
        this.f21853h.setAdapter(this.f21854i);
        this.f21853h.setOnPageChangeListener(this);
        this.f21853h.setOnTouchListener(new c(this));
    }

    public void A(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f21853h.setEventListener(bVar);
        }
    }

    public void B(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (videoPlayFragmentAdapter = this.f21854i) == null) {
            return;
        }
        videoPlayFragmentAdapter.f21840g = str;
    }

    public void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.m = dVar;
            this.w.e(dVar);
        }
    }

    public void G(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (videoPlayFragmentAdapter = this.f21854i) == null) {
            return;
        }
        videoPlayFragmentAdapter.f21837d = str;
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (this.f21851f != null) {
                if (!TbadkCoreApplication.isLogin() && this.r == 0) {
                    this.f21851f.setEnabled(false);
                } else {
                    this.f21851f.setEnabled(true);
                }
            }
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21854i;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.k(z);
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

    public void I(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.f21852g.K().findViewById(R.id.continuous_loading_layout).setVisibility(4);
            this.f21851f.setProgressViewCallback(kVar);
        }
    }

    public void J(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f21853h.setCurrentItem(i2, z);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.z = str;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.r = i2;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f21853h.setScrollable(z);
        }
    }

    public void N(d.a.p0.x3.c.d dVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, dVar, i2, rect) == null) {
            this.l = dVar;
            this.w.d(dVar);
            dVar.x(this);
            this.k = i2;
            this.f21854i.i(dVar, rect);
            this.f21854i.notifyDataSetChanged();
            this.f21853h.setCurrentItem(i2);
        }
    }

    @Override // d.a.p0.n2.f.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || i2 - i3 >= 3500 || this.z.equals("from_attention_sub_fragment")) {
            return;
        }
        this.v.b();
    }

    @Override // d.a.p0.x3.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.w.b();
        }
    }

    @Override // d.a.p0.x3.f.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.w.a();
        }
    }

    @Override // d.a.p0.x3.c.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // d.a.p0.x3.c.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.w.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view) == null) && view.getId() == R.id.guide_animation_view) {
            this.v.onClick(view);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        e eVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (i2 == 0 && (videoPlayFragmentAdapter = this.f21854i) != null && (verticalViewPager = this.f21853h) != null) {
                videoPlayFragmentAdapter.f(verticalViewPager.getCurrentItem());
                if (t()) {
                    this.f21853h.setNeedHanleTouch(true);
                    this.f21853h.setSelected(true);
                    VerticalViewPager verticalViewPager2 = this.f21853h;
                    verticalViewPager2.setCurrentItem(verticalViewPager2.getCurrentItem(), true);
                    this.f21853h.setNeedHanleTouch(false);
                    this.q = false;
                }
            }
            if (i2 == 0) {
                if (this.y || (eVar = this.x) == null) {
                    return;
                }
                eVar.a();
            } else if (i2 == 1) {
                this.y = false;
            } else if (i2 != 2) {
            } else {
                this.y = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > l.i(TbadkCoreApplication.getInst())) {
                this.q = true;
            }
            if (t()) {
                this.f21853h.setNeedHanleTouch(true);
            } else {
                this.f21853h.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.j = i2;
            this.w.c(i2);
            if (!this.l.p() && this.l.h() - 1 > 0 && this.l.h() - i2 <= 2 && (dVar = this.m) != null) {
                dVar.a();
            }
            if (t()) {
                this.f21853h.computeScroll();
            }
            this.v.f();
        }
    }

    public VideoAttentionListPageFragment p() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21854i;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21853h) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public VideoPlayFragment q() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21854i;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21853h) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem());
        }
        return (VideoPlayFragment) invokeV.objValue;
    }

    public void r(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.f21854i) == null || (verticalViewPager = this.f21853h) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        e2.R1(i2, i3, intent);
    }

    public boolean s() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21854i;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21853h) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return e2.S1();
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.q && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public void u() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (videoPlayFragmentAdapter = this.f21854i) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f21850e, R.color.CAM_X0611, i2);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.f21854i != null) {
                MessageManager.getInstance().unRegisterListener(this.f21854i.d());
            }
            H(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f21854i;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.g();
            }
            this.n = null;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.v.g();
        }
    }

    public void y(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eVar) == null) {
            this.x = eVar;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f21854i.h(z);
        }
    }
}
