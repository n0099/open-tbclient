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
import d.a.d.e.p.l;
import d.a.p0.d1.p.a;
import d.a.q0.n2.f;
/* loaded from: classes4.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, f.c, d.a.q0.x3.c.c, d.a.q0.x3.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;

    /* renamed from: e  reason: collision with root package name */
    public int f21985e;

    /* renamed from: f  reason: collision with root package name */
    public View f21986f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f21987g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.s.f0.f f21988h;

    /* renamed from: i  reason: collision with root package name */
    public VerticalViewPager f21989i;
    public VideoPlayFragmentAdapter j;
    public int k;
    public int l;
    public d.a.q0.x3.c.d m;
    public d n;
    public FragmentActivity o;
    public TBLottieAnimationView p;
    public String q;
    public boolean r;
    public int s;
    public float t;
    public int u;
    public int v;
    public d.a.q0.x3.d.a w;
    public d.a.q0.x3.d.b x;
    public e y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21990a;

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
            this.f21990a = videoPlayView;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view)) == null) {
                if (this.f21990a.f21989i == null) {
                    return false;
                }
                VideoAttentionListPageFragment p = this.f21990a.p();
                return p != null ? (this.f21990a.f21989i.getCurrentItem() == 0 && p.isOnViewTop()) ? false : true : this.f21990a.f21989i.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements VideoPlayFragment.u0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21991a;

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
            this.f21991a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.u0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21991a.w.j();
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.u0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21991a.A.equals("from_attention_sub_fragment")) {
                return;
            }
            this.f21991a.w.d();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f21992e;

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
            this.f21992e = videoPlayView;
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
                            if (this.f21992e.t == 0.0f) {
                                this.f21992e.t = motionEvent.getY();
                            }
                            float y = motionEvent.getY() - this.f21992e.t;
                            if (this.f21992e.t > (l.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.f21992e.u && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.f21992e.o) && l.j(TbadkCoreApplication.getInst(), true) != this.f21992e.v) {
                                this.f21992e.r = true;
                            }
                        }
                    }
                    this.f21992e.t = 0.0f;
                } else {
                    this.f21992e.t = motionEvent.getY();
                    this.f21992e.r = false;
                }
                VideoPlayFragment e2 = this.f21992e.j.e(this.f21992e.f21989i.getCurrentItem());
                if (e2 != null) {
                    return e2.E0();
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

    public VideoPlayView(BdUniqueId bdUniqueId, FragmentActivity fragmentActivity, BaseFragment baseFragment, String str, BdUniqueId bdUniqueId2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, fragmentActivity, baseFragment, str, bdUniqueId2, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.u = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.v = 2049;
        this.x = new d.a.q0.x3.d.b();
        this.A = "from_no_sub_fragment";
        this.o = fragmentActivity;
        this.f21985e = i3;
        this.q = str;
        this.p = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.guide_animation_view);
        this.f21986f = baseFragment.getView().findViewById(R.id.root_layout);
        this.f21989i = (VerticalViewPager) baseFragment.getView().findViewById(R.id.video_play_viewpager);
        this.w = new d.a.q0.x3.d.a(this.p, this.f21989i);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.refresh_layout);
        this.f21987g = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setNoMoveTargetView(true);
        this.f21987g.setLimitDragDistance(true);
        d.a.p0.s.f0.f fVar = new d.a.p0.s.f0.f(fragmentActivity);
        this.f21988h = fVar;
        this.f21987g.setProgressView(fVar);
        this.f21987g.setOnChildScrollUpCallback(new a(this));
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i2, this.f21985e);
        this.j = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.n(new b(this));
        this.j.m(this);
        MessageManager.getInstance().registerListener(this.j.d());
        this.j.l(this);
        this.j.f21974g = this.q;
        this.f21989i.setOffscreenPageLimit(1);
        this.f21989i.setAdapter(this.j);
        this.f21989i.setOnPageChangeListener(this);
        this.f21989i.setOnTouchListener(new c(this));
    }

    public void A(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f21989i.setEventListener(bVar);
        }
    }

    public void B(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (videoPlayFragmentAdapter = this.j) == null) {
            return;
        }
        videoPlayFragmentAdapter.f21976i = str;
    }

    public void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.n = dVar;
            this.x.e(dVar);
        }
    }

    public void G(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (videoPlayFragmentAdapter = this.j) == null) {
            return;
        }
        videoPlayFragmentAdapter.f21973f = str;
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (this.f21987g != null) {
                if (!TbadkCoreApplication.isLogin() && this.s == 0) {
                    this.f21987g.setEnabled(false);
                } else {
                    this.f21987g.setEnabled(true);
                }
            }
            if (UtilHelper.isFlyMeOs()) {
                return;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z && skinType != 4 && skinType != 1) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.o);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.o);
            }
        }
    }

    public void I(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.f21988h.K().findViewById(R.id.continuous_loading_layout).setVisibility(4);
            this.f21987g.setProgressViewCallback(kVar);
        }
    }

    public void J(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f21989i.setCurrentItem(i2, z);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.A = str;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.s = i2;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f21989i.setScrollable(z);
        }
    }

    public void N(d.a.q0.x3.c.d dVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, dVar, i2, rect) == null) {
            this.m = dVar;
            this.x.d(dVar);
            dVar.y(this);
            this.l = i2;
            this.j.k(dVar, rect);
            this.j.notifyDataSetChanged();
            this.f21989i.setCurrentItem(i2);
        }
    }

    @Override // d.a.q0.n2.f.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || i2 - i3 >= 3500 || this.A.equals("from_attention_sub_fragment")) {
            return;
        }
        this.w.c();
    }

    @Override // d.a.q0.x3.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.x.b();
        }
    }

    @Override // d.a.q0.x3.g.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.x.a();
        }
    }

    @Override // d.a.q0.x3.c.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // d.a.q0.x3.c.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.x.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view) == null) && view.getId() == R.id.guide_animation_view) {
            this.w.onClick(view);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        e eVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VerticalViewPager verticalViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter2 = this.j;
            if (videoPlayFragmentAdapter2 != null && (verticalViewPager2 = this.f21989i) != null) {
                videoPlayFragmentAdapter2.h(verticalViewPager2.getCurrentItem());
            }
            if (i2 == 0 && (videoPlayFragmentAdapter = this.j) != null && (verticalViewPager = this.f21989i) != null) {
                videoPlayFragmentAdapter.g(verticalViewPager.getCurrentItem());
                if (t()) {
                    this.f21989i.setNeedHanleTouch(true);
                    this.f21989i.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.f21989i;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.f21989i.setNeedHanleTouch(false);
                    this.r = false;
                }
            }
            if (i2 == 0) {
                if (this.z || (eVar = this.y) == null) {
                    return;
                }
                eVar.a();
            } else if (i2 == 1) {
                this.z = false;
            } else if (i2 != 2) {
            } else {
                this.z = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > l.i(TbadkCoreApplication.getInst())) {
                this.r = true;
            }
            if (t()) {
                this.f21989i.setNeedHanleTouch(true);
            } else {
                this.f21989i.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.k = i2;
            this.x.c(i2);
            if (!this.m.q() && this.m.i() - 1 > 0 && this.m.i() - i2 <= 2 && (dVar = this.n) != null) {
                dVar.a();
            }
            if (t()) {
                this.f21989i.computeScroll();
            }
            this.w.g();
        }
    }

    public VideoAttentionListPageFragment p() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.j;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21989i) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public a.b q() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.j;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21989i) == null) {
                return null;
            }
            VideoPlayFragment e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem());
            return e2 == null ? this.j.f(this.f21989i.getCurrentItem()) : e2;
        }
        return (a.b) invokeV.objValue;
    }

    public void r(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.j) == null || (verticalViewPager = this.f21989i) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        e2.r0(i2, i3, intent);
    }

    public boolean s() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.j;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f21989i) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return e2.E0();
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.r && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public void u() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (videoPlayFragmentAdapter = this.j) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f21986f, R.color.CAM_X0611, i2);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().unRegisterListener(this.j.d());
            }
            H(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.j;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.i();
            }
            this.o = null;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.w.h();
        }
    }

    public void y(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eVar) == null) {
            this.y = eVar;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.j.j(z);
        }
    }
}
