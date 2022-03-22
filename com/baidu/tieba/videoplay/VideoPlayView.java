package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.o0.e1.r.b;
import c.a.p0.c3.h;
import c.a.p0.l3.f0.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes6.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, h.c, c.a.p0.p4.c.c, c.a.p0.p4.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e A;
    public c.a.p0.p4.h.a B;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36627b;

    /* renamed from: c  reason: collision with root package name */
    public View f36628c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f36629d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.l0.f f36630e;

    /* renamed from: f  reason: collision with root package name */
    public VerticalViewPager f36631f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayFragmentAdapter f36632g;

    /* renamed from: h  reason: collision with root package name */
    public int f36633h;
    public int i;
    public c.a.p0.p4.c.d j;
    public f k;
    public FragmentActivity l;
    public TBLottieAnimationView m;
    public String n;
    public boolean o;
    public int p;
    public float q;
    public int r;
    public int s;
    public c.a.p0.p4.e.a t;
    public c.a.p0.p4.e.b u;
    public g v;
    public h w;
    public boolean x;
    public String y;
    public float z;

    /* loaded from: classes6.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        public a(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view)) == null) {
                if (this.a.f36631f == null) {
                    return false;
                }
                VideoAttentionListPageFragment s = this.a.s();
                return s != null ? (this.a.f36631f.getCurrentItem() == 0 && s.isOnViewTop()) ? false : true : this.a.f36631f.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements VideoPlayFragment.m1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        public b(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.m1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.j();
                int currentItem = this.a.f36631f.getCurrentItem();
                if (this.a.f36632g.f(currentItem) != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", this.a.f36632g.f(currentItem).thread_id);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.m1
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.y.equals("from_attention_sub_fragment") || this.a.a == 9) {
                return;
            }
            this.a.t.d();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        public c(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r5 != 3) goto L12;
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
                    if (action == 1) {
                        this.a.z = motionEvent.getY() - this.a.q;
                    } else if (action == 2) {
                        if (this.a.q == 0.0f) {
                            this.a.q = motionEvent.getY();
                        }
                        this.a.z = motionEvent.getY() - this.a.q;
                        if (this.a.q > (n.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.a.r && this.a.z < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.a.l) && n.j(TbadkCoreApplication.getInst(), true) != this.a.s) {
                            this.a.o = true;
                        }
                    }
                    this.a.q = 0.0f;
                } else {
                    this.a.q = motionEvent.getY();
                    this.a.o = false;
                }
                VideoPlayFragment e2 = this.a.f36632g.e(this.a.f36631f.getCurrentItem());
                if (e2 == null) {
                    this.a.f36631f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    return false;
                }
                return e2.v0();
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        public d(VideoPlayView videoPlayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        @Override // c.a.p0.l3.f0.c.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.U();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i);

        void b(int i);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a();
    }

    public VideoPlayView(BdUniqueId bdUniqueId, FragmentActivity fragmentActivity, BaseFragment baseFragment, String str, BdUniqueId bdUniqueId2, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, fragmentActivity, baseFragment, str, bdUniqueId2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36633h = 0;
        this.r = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.s = 2049;
        this.u = new c.a.p0.p4.e.b();
        this.y = "from_no_sub_fragment";
        this.z = 0.0f;
        this.l = fragmentActivity;
        this.a = i2;
        this.f36627b = z;
        this.n = str;
        this.m = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f090cff);
        this.f36628c = baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091ae5);
        VerticalViewPager verticalViewPager = (VerticalViewPager) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09236a);
        this.f36631f = verticalViewPager;
        verticalViewPager.setStrictSlide(false);
        this.t = new c.a.p0.p4.e.a(this.m, this.f36631f);
        this.f36629d = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091a2e);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            this.f36629d.setBackground(null);
            this.f36631f.setBackground(null);
        }
        this.f36629d.setUseSlideAngleToPullRefresh(true);
        this.f36629d.setNoMoveTargetView(true);
        this.f36629d.setLimitDragDistance(true);
        c.a.o0.r.l0.f fVar = new c.a.o0.r.l0.f(fragmentActivity);
        this.f36630e = fVar;
        this.f36629d.setProgressView(fVar);
        this.f36629d.setOnChildScrollUpCallback(new a(this));
        if (this.f36632g == null) {
            this.f36632g = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i, this.a, this.f36627b);
        }
        this.f36632g.p(new b(this));
        this.f36632g.o(this);
        MessageManager.getInstance().registerListener(this.f36632g.d());
        this.f36632g.n(this);
        this.f36632g.f36619h = this.n;
        this.f36631f.setOffscreenPageLimit(1);
        this.f36631f.setAdapter(this.f36632g);
        this.f36631f.setOnPageChangeListener(this);
        this.f36631f.setOnTouchListener(new c(this));
    }

    public void A() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayFragmentAdapter = this.f36632g) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.f36628c, R.color.CAM_X0611, i);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f36632g;
            if (videoPlayFragmentAdapter == null || videoPlayFragmentAdapter.e(this.f36633h) == null) {
                return;
            }
            this.f36632g.e(this.f36633h).E2(i);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f36632g != null) {
                MessageManager.getInstance().unRegisterListener(this.f36632g.d());
            }
            N(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f36632g;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.j();
            }
            this.l = null;
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.t.h();
        }
    }

    public void E(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            this.w = hVar;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f36632g.k(z);
        }
    }

    public void G(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.A = eVar;
        }
    }

    public void H(b.InterfaceC0807b interfaceC0807b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC0807b) == null) {
            this.f36631f.setEventListener(interfaceC0807b);
        }
    }

    public void I(c.a.p0.p4.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.B = aVar;
            if (aVar == null) {
                return;
            }
            aVar.n(new d(this));
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f36632g;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.m(aVar);
            }
        }
    }

    public void J(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (videoPlayFragmentAdapter = this.f36632g) == null) {
            return;
        }
        videoPlayFragmentAdapter.j = str;
    }

    public void K(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.v = gVar;
        }
    }

    public void L(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.k = fVar;
            this.u.e(fVar);
        }
    }

    public void M(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (videoPlayFragmentAdapter = this.f36632g) == null) {
            return;
        }
        videoPlayFragmentAdapter.f36618g = str;
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (this.f36629d != null) {
                if (!TbadkCoreApplication.isLogin() && this.p == 0) {
                    this.f36629d.setEnabled(false);
                } else {
                    this.f36629d.setEnabled(true);
                }
            }
            if (UtilHelper.isFlyMeOs() || this.a != 5) {
                return;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z && skinType != 4 && skinType != 1) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.l);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.l);
            }
        }
    }

    public void O(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kVar) == null) {
            this.f36630e.J().findViewById(R.id.obfuscated_res_0x7f0906ed).setVisibility(4);
            this.f36629d.setProgressViewCallback(kVar);
        }
    }

    public void P(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f36631f.setCurrentItem(i, z);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.y = str;
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.p = i;
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f36631f.setScrollable(z);
        }
    }

    public void T(c.a.p0.p4.c.d dVar, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, dVar, i, rect) == null) {
            this.j = dVar;
            this.u.d(dVar);
            dVar.E(this);
            this.i = i;
            this.f36632g.l(dVar, rect);
            this.f36632g.notifyDataSetChanged();
            this.f36631f.setCurrentItem(i);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f36631f.f(130);
        }
    }

    @Override // c.a.p0.c3.h.c
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) || i - i2 >= 3500 || this.y.equals("from_attention_sub_fragment") || x()) {
            return;
        }
        this.t.c();
    }

    @Override // c.a.p0.p4.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.u.b();
        }
    }

    @Override // c.a.p0.p4.i.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.u.a();
        }
    }

    @Override // c.a.p0.p4.c.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // c.a.p0.p4.c.c
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.u.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, view) == null) && view.getId() == R.id.obfuscated_res_0x7f090cff) {
            this.t.onClick(view);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        h hVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2;
        VerticalViewPager verticalViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            if (i == 1 && (videoPlayFragmentAdapter2 = this.f36632g) != null && (verticalViewPager2 = this.f36631f) != null) {
                videoPlayFragmentAdapter2.i(verticalViewPager2.getCurrentItem());
            }
            if (i == 0 && (videoPlayFragmentAdapter = this.f36632g) != null && (verticalViewPager = this.f36631f) != null) {
                videoPlayFragmentAdapter.h(verticalViewPager.getCurrentItem());
                if (y()) {
                    this.f36631f.setNeedHanleTouch(true);
                    this.f36631f.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.f36631f;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.f36631f.setNeedHanleTouch(false);
                    this.o = false;
                }
            }
            if (i == 0) {
                if (this.x || (hVar = this.w) == null) {
                    return;
                }
                hVar.a();
            } else if (i == 1) {
                this.x = false;
            } else if (i != 2) {
            } else {
                this.x = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            if (i2 > n.i(TbadkCoreApplication.getInst())) {
                this.o = true;
            }
            if (y()) {
                this.f36631f.setNeedHanleTouch(true);
            } else {
                this.f36631f.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (this.f36633h > i) {
                e eVar = this.A;
                if (eVar != null) {
                    eVar.a(i);
                }
            } else {
                e eVar2 = this.A;
                if (eVar2 != null) {
                    eVar2.b(i);
                }
            }
            this.f36633h = i;
            this.u.c(i);
            if (!this.j.v() && this.j.k() - 1 > 0 && this.j.k() - i <= 2 && (fVar = this.k) != null) {
                fVar.a();
            }
            if (y()) {
                this.f36631f.computeScroll();
            }
            this.t.g();
            c.a.p0.p4.h.a aVar = this.B;
            if (aVar != null) {
                aVar.m(i);
            }
            g gVar = this.v;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public VideoAttentionListPageFragment s() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f36632g;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f36631f) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public b.InterfaceC0807b t() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f36632g;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f36631f) == null) {
                return null;
            }
            VideoPlayFragment e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem());
            return e2 == null ? this.f36632g.g(this.f36631f.getCurrentItem()) : e2;
        }
        return (b.InterfaceC0807b) invokeV.objValue;
    }

    public void u(int i, int i2, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048608, this, i, i2, intent) == null) || (videoPlayFragmentAdapter = this.f36632g) == null || (verticalViewPager = this.f36631f) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        e2.l0(i, i2, intent);
    }

    public boolean v() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f36632g;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f36631f) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return e2.v0();
        }
        return invokeV.booleanValue;
    }

    public void w() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (videoPlayFragmentAdapter = this.f36632g) == null || this.f36633h != 0 || (e2 = videoPlayFragmentAdapter.e(0)) == null) {
            return;
        }
        e2.e3();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.o && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.z < 0.0f : invokeV.booleanValue;
    }
}
