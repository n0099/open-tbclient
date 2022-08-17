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
import com.repackage.av4;
import com.repackage.bw8;
import com.repackage.cv8;
import com.repackage.cw8;
import com.repackage.dv8;
import com.repackage.iv8;
import com.repackage.jv8;
import com.repackage.l88;
import com.repackage.mc8;
import com.repackage.oj5;
import com.repackage.qi;
/* loaded from: classes4.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, l88.c, cv8, cw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e A;
    public bw8 B;
    public int a;
    public boolean b;
    public View c;
    public BdSwipeRefreshLayout d;
    public av4 e;
    public VerticalViewPager f;
    public VideoPlayFragmentAdapter g;
    public int h;
    public int i;
    public dv8 j;
    public f k;
    public FragmentActivity l;
    public TBLottieAnimationView m;
    public String n;
    public boolean o;
    public int p;
    public float q;
    public int r;
    public int s;
    public iv8 t;
    public jv8 u;
    public g v;
    public h w;
    public boolean x;
    public String y;
    public float z;

    /* loaded from: classes4.dex */
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
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view2)) == null) {
                if (this.a.f == null) {
                    return false;
                }
                VideoAttentionListPageFragment s = this.a.s();
                return s != null ? (this.a.f.getCurrentItem() == 0 && s.s()) ? false : true : this.a.f.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements VideoPlayFragment.g1 {
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

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.g1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.j();
                int currentItem = this.a.f.getCurrentItem();
                if (this.a.g.f(currentItem) != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", this.a.g.f(currentItem).thread_id);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.g1
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.y.equals("from_attention_sub_fragment") || this.a.a == 9) {
                return;
            }
            this.a.t.d();
        }
    }

    /* loaded from: classes4.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.a.z = motionEvent.getY() - this.a.q;
                    } else if (action == 2) {
                        if (this.a.q == 0.0f) {
                            this.a.q = motionEvent.getY();
                        }
                        this.a.z = motionEvent.getY() - this.a.q;
                        if (this.a.q > (qi.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.a.r && this.a.z < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.a.l) && qi.j(TbadkCoreApplication.getInst(), true) != this.a.s) {
                            this.a.o = true;
                        }
                    }
                    this.a.q = 0.0f;
                } else {
                    this.a.q = motionEvent.getY();
                    this.a.o = false;
                }
                VideoPlayFragment e = this.a.g.e(this.a.f.getCurrentItem());
                if (e == null) {
                    this.a.f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    return false;
                }
                return e.i1();
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements mc8.a {
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

        @Override // com.repackage.mc8.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.V();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i);

        void b(int i);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes4.dex */
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
        this.h = 0;
        this.r = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.s = 2049;
        this.u = new jv8();
        this.y = "from_no_sub_fragment";
        this.z = 0.0f;
        this.l = fragmentActivity;
        this.a = i2;
        this.b = z;
        this.n = str;
        this.m = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f090cef);
        this.c = baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091c29);
        VerticalViewPager verticalViewPager = (VerticalViewPager) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f0924f7);
        this.f = verticalViewPager;
        verticalViewPager.setStrictSlide(false);
        this.t = new iv8(this.m, this.f);
        this.d = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091b7b);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            this.d.setBackground(null);
            this.f.setBackground(null);
        }
        this.d.setUseSlideAngleToPullRefresh(true);
        this.d.setNoMoveTargetView(true);
        this.d.setLimitDragDistance(true);
        av4 av4Var = new av4(fragmentActivity);
        this.e = av4Var;
        this.d.setProgressView(av4Var);
        this.d.setOnChildScrollUpCallback(new a(this));
        if (this.g == null) {
            this.g = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i, this.a, this.b);
        }
        this.g.p(new b(this));
        this.g.o(this);
        MessageManager.getInstance().registerListener(this.g.d());
        this.g.n(this);
        this.g.h = this.n;
        this.f.setOffscreenPageLimit(1);
        this.f.setAdapter(this.g);
        this.f.setOnPageChangeListener(this);
        this.f.setOnTouchListener(new c(this));
    }

    public void A() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoPlayFragmentAdapter = this.g) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0611, i);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.g;
            if (videoPlayFragmentAdapter == null || videoPlayFragmentAdapter.e(this.h) == null) {
                return;
            }
            this.g.e(this.h).y3(i);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.g != null) {
                MessageManager.getInstance().unRegisterListener(this.g.d());
            }
            O(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.g;
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
            this.g.k(z);
        }
    }

    public void G(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.A = eVar;
        }
    }

    public void H(oj5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f.setEventListener(bVar);
        }
    }

    public void J(bw8 bw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bw8Var) == null) {
            this.B = bw8Var;
            if (bw8Var == null) {
                return;
            }
            bw8Var.n(new d(this));
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.g;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.m(bw8Var);
            }
        }
    }

    public void K(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (videoPlayFragmentAdapter = this.g) == null) {
            return;
        }
        videoPlayFragmentAdapter.j = str;
    }

    public void L(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.v = gVar;
        }
    }

    public void M(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.k = fVar;
            this.u.e(fVar);
        }
    }

    public void N(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (videoPlayFragmentAdapter = this.g) == null) {
            return;
        }
        videoPlayFragmentAdapter.g = str;
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (this.d != null) {
                if (!TbadkCoreApplication.isLogin() && this.p == 0) {
                    this.d.setEnabled(false);
                } else {
                    this.d.setEnabled(true);
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

    public void P(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kVar) == null) {
            this.e.J().findViewById(R.id.obfuscated_res_0x7f0906e3).setVisibility(4);
            this.d.setProgressViewCallback(kVar);
        }
    }

    public void Q(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f.setCurrentItem(i, z);
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.y = str;
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.p = i;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f.setScrollable(z);
        }
    }

    public void U(dv8 dv8Var, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, dv8Var, i, rect) == null) {
            this.j = dv8Var;
            this.u.d(dv8Var);
            dv8Var.E(this);
            this.i = i;
            this.g.l(dv8Var, rect);
            this.g.notifyDataSetChanged();
            this.f.setCurrentItem(i);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f.f(130);
        }
    }

    @Override // com.repackage.l88.c
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) || i - i2 >= 3500 || this.y.equals("from_attention_sub_fragment") || x()) {
            return;
        }
        this.t.c();
    }

    @Override // com.repackage.cv8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.u.b();
        }
    }

    @Override // com.repackage.cw8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.u.a();
        }
    }

    @Override // com.repackage.cv8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // com.repackage.cv8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.u.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090cef) {
            this.t.onClick(view2);
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
            if (i == 1 && (videoPlayFragmentAdapter2 = this.g) != null && (verticalViewPager2 = this.f) != null) {
                videoPlayFragmentAdapter2.i(verticalViewPager2.getCurrentItem());
            }
            if (i == 0 && (videoPlayFragmentAdapter = this.g) != null && (verticalViewPager = this.f) != null) {
                videoPlayFragmentAdapter.h(verticalViewPager.getCurrentItem());
                if (y()) {
                    this.f.setNeedHanleTouch(true);
                    this.f.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.f;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.f.setNeedHanleTouch(false);
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
            if (i2 > qi.i(TbadkCoreApplication.getInst())) {
                this.o = true;
            }
            if (y()) {
                this.f.setNeedHanleTouch(true);
            } else {
                this.f.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (this.h > i) {
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
            this.h = i;
            this.u.c(i);
            if (!this.j.v() && this.j.k() - 1 > 0 && this.j.k() - i <= 2 && (fVar = this.k) != null) {
                fVar.a();
            }
            if (y()) {
                this.f.computeScroll();
            }
            this.t.g();
            bw8 bw8Var = this.B;
            if (bw8Var != null) {
                bw8Var.m(i);
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
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.g;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public oj5.b t() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.g;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f) == null) {
                return null;
            }
            VideoPlayFragment e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem());
            return e2 == null ? this.g.g(this.f.getCurrentItem()) : e2;
        }
        return (oj5.b) invokeV.objValue;
    }

    public void u(int i, int i2, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048608, this, i, i2, intent) == null) || (videoPlayFragmentAdapter = this.g) == null || (verticalViewPager = this.f) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        e2.Z0(i, i2, intent);
    }

    public boolean v() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.g;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return e2.i1();
        }
        return invokeV.booleanValue;
    }

    public void w() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (videoPlayFragmentAdapter = this.g) == null || this.h != 0 || (e2 = videoPlayFragmentAdapter.e(0)) == null) {
            return;
        }
        e2.Y3();
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
