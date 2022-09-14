package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ae8;
import com.baidu.tieba.ay8;
import com.baidu.tieba.bx8;
import com.baidu.tieba.by8;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.tieba.cx8;
import com.baidu.tieba.dm5;
import com.baidu.tieba.ej;
import com.baidu.tieba.hx8;
import com.baidu.tieba.ix8;
import com.baidu.tieba.lx4;
import com.baidu.tieba.uu4;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.tieba.videoplay.view.SecondFloorPullView;
import com.baidu.tieba.ww8;
import com.baidu.tieba.y16;
import com.baidu.tieba.z16;
import com.baidu.tieba.z98;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes6.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, z98.c, bx8, by8, ww8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hx8 A;
    public ix8 B;
    public j C;
    public k D;
    public boolean E;
    public String F;
    public float G;
    public h H;
    public ay8 I;
    public CustomMessageListener J;
    public int a;
    public boolean b;
    public boolean c;
    public BdUniqueId d;
    public View e;
    public SecondFloorPullView f;
    public AlaRecommendLayout g;
    public View h;
    public TextView i;
    public BdSwipeRefreshLayout j;
    public lx4 k;
    public VerticalViewPager l;
    public VideoPlayFragmentAdapter m;
    public int n;
    public int o;
    public cx8 p;
    public i q;
    public FragmentActivity r;
    public TBLottieAnimationView s;
    public String t;
    public String u;
    public boolean v;
    public int w;
    public float x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayView videoPlayView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            boolean z = true;
            boolean booleanValue = customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : true;
            if (this.a.a != 1 && this.a.a != 2) {
                z = false;
            }
            if (!z || booleanValue) {
                return;
            }
            this.a.B();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lx4.f {
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

        @Override // com.baidu.tieba.lx4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z && this.a.l.getCurrentItem() == 0 && this.a.f != null && this.a.Q(TbSingleton.getInstance().getLiveFollowSecondFloor()) && this.a.f.getCurrentStatus() == 2) {
                this.a.f.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BdSwipeRefreshLayout.j {
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

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view2)) == null) {
                if (this.a.l == null) {
                    return false;
                }
                VideoAttentionListPageFragment D = this.a.D();
                return D != null ? (this.a.l.getCurrentItem() == 0 && D.s()) ? false : true : this.a.l.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements VideoPlayFragment.i1 {
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

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.i1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A.j();
                int currentItem = this.a.l.getCurrentItem();
                if (this.a.m.f(currentItem) != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", this.a.m.f(currentItem).thread_id);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.i1
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.F.equals("from_attention_sub_fragment") || this.a.a == 9) {
                return;
            }
            this.a.A.d();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        public e(VideoPlayView videoPlayView) {
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
                        this.a.G = motionEvent.getY() - this.a.x;
                    } else if (action == 2) {
                        if (this.a.x == 0.0f) {
                            this.a.x = motionEvent.getY();
                        }
                        this.a.G = motionEvent.getY() - this.a.x;
                        if (this.a.x > (ej.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.a.y && this.a.G < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.a.r) && ej.j(TbadkCoreApplication.getInst(), true) != this.a.z) {
                            this.a.v = true;
                        }
                    }
                    this.a.x = 0.0f;
                } else {
                    this.a.x = motionEvent.getY();
                    this.a.v = false;
                }
                VideoPlayFragment e = this.a.m.e(this.a.l.getCurrentItem());
                if (e == null) {
                    this.a.l.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    return false;
                }
                return e.h1();
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements SecondFloorPullView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ VideoPlayView b;

        public f(VideoPlayView videoPlayView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoPlayView;
            this.a = str;
        }

        @Override // com.baidu.tieba.videoplay.view.SecondFloorPullView.g
        public void a(int i) {
            VideoPlayFragment e;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (e = this.b.m.e(this.b.l.getCurrentItem())) == null) {
                return;
            }
            e.m4(i);
            if (i == 1) {
                this.b.W(true);
            } else if (i == 2) {
                this.b.b0(false);
                this.b.W(true);
            } else if (i == 5) {
                if (this.b.c) {
                    this.b.b0(true);
                    this.b.O();
                    this.b.W(false);
                }
            } else if (i == 6) {
                this.b.P();
            } else if (i != 7) {
            } else {
                TiebaStatic.log(new StatisticItem("c14931").param("obj_locate", this.b.F()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a).param("cuid", TbadkCoreApplication.getInst().getCuid()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ae8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayView a;

        public g(VideoPlayView videoPlayView) {
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

        @Override // com.baidu.tieba.ae8.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(int i);

        void b(int i);
    }

    /* loaded from: classes6.dex */
    public interface i {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface k {
        void a();
    }

    public VideoPlayView(BdUniqueId bdUniqueId, FragmentActivity fragmentActivity, BaseFragment baseFragment, String str, BdUniqueId bdUniqueId2, int i2, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, fragmentActivity, baseFragment, str, bdUniqueId2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.u = "0";
        this.y = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.z = 2049;
        this.B = new ix8();
        this.F = "from_no_sub_fragment";
        this.G = 0.0f;
        this.J = new a(this, 2921665);
        this.d = bdUniqueId;
        this.r = fragmentActivity;
        this.a = i3;
        this.b = z;
        this.t = str;
        if ("frs".equals(str)) {
            this.u = str2;
        }
        this.s = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f090d0b);
        this.e = baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091c79);
        VerticalViewPager verticalViewPager = (VerticalViewPager) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09255c);
        this.l = verticalViewPager;
        verticalViewPager.setStrictSlide(false);
        this.A = new hx8(this.s, this.l);
        this.j = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091bc0);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            this.j.setBackground(null);
            this.l.setBackground(null);
        }
        this.j.setUseSlideAngleToPullRefresh(true);
        this.j.setNoMoveTargetView(true);
        this.j.setLimitDragDistance(true);
        lx4 lx4Var = new lx4(fragmentActivity);
        this.k = lx4Var;
        lx4Var.m(new b(this));
        this.j.setProgressView(this.k);
        this.j.setOnChildScrollUpCallback(new c(this));
        if (this.m == null) {
            this.m = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i2, this.a, this.b, Q(TbSingleton.getInstance().getLiveFollowSecondFloor()) && R());
        }
        this.m.q(new d(this));
        this.m.p(this);
        this.m.k(this);
        MessageManager.getInstance().registerListener(this.m.d());
        MessageManager.getInstance().registerListener(this.J);
        this.m.o(this);
        this.m.h = this.t;
        this.l.setOffscreenPageLimit(1);
        this.l.setAdapter(this.m);
        this.l.setOnPageChangeListener(this);
        this.l.setOnTouchListener(new e(this));
        this.i = (TextView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09022e);
        this.h = baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09022c);
        AlaRecommendLayout alaRecommendLayout = (AlaRecommendLayout) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f092565);
        this.g = alaRecommendLayout;
        alaRecommendLayout.setDarkMode(true);
        SecondFloorPullView secondFloorPullView = (SecondFloorPullView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f091e1d);
        this.f = secondFloorPullView;
        secondFloorPullView.setOnStatusChange(new f(this, str2));
        this.f.setHideButton(this.h);
        this.f.setPullView(this.l);
        this.f.setSecondFloorView(this.g);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.h();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (Q(TbSingleton.getInstance().getLiveFollowSecondFloor())) {
                if (R()) {
                    o0();
                    W(false);
                } else {
                    I();
                }
                q0(this.d, TbSingleton.getInstance().getLiveFollowSecondFloor(), this.a == 1 ? "video_recommend" : "video_concern");
                return;
            }
            B();
        }
    }

    public VideoAttentionListPageFragment D() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.l) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public dm5.b E() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.l) == null) {
                return null;
            }
            VideoPlayFragment e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem());
            return e2 == null ? this.m.g(this.l.getCurrentItem()) : e2;
        }
        return (dm5.b) invokeV.objValue;
    }

    public final int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.a;
            if (i2 == 1) {
                return 1;
            }
            return i2 == 2 ? 2 : 0;
        }
        return invokeV.intValue;
    }

    public void G(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.m) == null || (verticalViewPager = this.l) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        e2.W0(i2, i3, intent);
    }

    public boolean H() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.l) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return e2.h1();
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f.j();
        }
    }

    public void K() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoPlayFragmentAdapter = this.m) == null || this.n != 0 || (e2 = videoPlayFragmentAdapter.e(0)) == null) {
            return;
        }
        e2.X3();
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.v && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.G < 0.0f : invokeV.booleanValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = this.a;
            TiebaStatic.log(y16.c("c13620", i2 == 1 ? 5 : i2 == 2 ? 6 : 0));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TiebaStatic.log(new StatisticItem("c14930").param("obj_locate", F()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.u).param("cuid", TbadkCoreApplication.getInst().getCuid()));
        }
    }

    public boolean Q(List<AlaLiveInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (ListUtils.isEmpty(list) || list.get(0) == null) {
                return false;
            }
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                int intValue = list.get(0).show_page.intValue();
                return intValue == 3 || (this.a == 2 && intValue == 1) || (this.a == 1 && intValue == 2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a == 1 && TbSingleton.getInstance().isShowRecommendLiveSecondFloor()) {
                return true;
            }
            return this.a == 2 && TbSingleton.getInstance().isShowConcernLiveSecondFloor();
        }
        return invokeV.booleanValue;
    }

    public void S() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (videoPlayFragmentAdapter = this.m) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, i2);
            uu4 d2 = uu4.d(this.h);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X01);
            d2.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0106));
            this.g.d(i2);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter == null || videoPlayFragmentAdapter.e(this.n) == null) {
                return;
            }
            this.m.e(this.n).x3(i2);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.m != null) {
                MessageManager.getInstance().unRegisterListener(this.m.d());
            }
            MessageManager.getInstance().unRegisterListener(this.J);
            h0(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.j();
            }
            this.r = null;
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.A.h();
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            FragmentActivity fragmentActivity = this.r;
            if (fragmentActivity instanceof VideoPlayActivity) {
                ((VideoPlayActivity) fragmentActivity).setIsAddSwipeBackLayout(z);
            }
        }
    }

    public void X(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, kVar) == null) {
            this.D = kVar;
        }
    }

    public void Y(boolean z) {
        SecondFloorPullView secondFloorPullView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.c = z;
            this.m.l(z);
            if (!z || (secondFloorPullView = this.f) == null) {
                return;
            }
            int currentStatus = secondFloorPullView.getCurrentStatus();
            if (currentStatus == 2) {
                P();
            } else if (currentStatus != 5) {
            } else {
                O();
            }
        }
    }

    public void Z(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, hVar) == null) {
            this.H = hVar;
        }
    }

    @Override // com.baidu.tieba.z98.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) || i2 - i3 >= 3500 || this.F.equals("from_attention_sub_fragment") || L()) {
            return;
        }
        this.A.c();
    }

    public void a0(dm5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.l.setEventListener(bVar);
        }
    }

    @Override // com.baidu.tieba.bx8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B.b();
        }
    }

    public final void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            int i2 = this.a;
            if (i2 == 1) {
                TbSingleton.getInstance().setShowRecommendLiveSecondFloor(z);
            } else if (i2 == 2) {
                TbSingleton.getInstance().setShowConcernLiveSecondFloor(z);
            }
        }
    }

    @Override // com.baidu.tieba.by8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.B.a();
        }
    }

    public void c0(ay8 ay8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, ay8Var) == null) {
            this.I = ay8Var;
            if (ay8Var == null) {
                return;
            }
            ay8Var.n(new g(this));
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.n(ay8Var);
            }
        }
    }

    @Override // com.baidu.tieba.ww8
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (Q(TbSingleton.getInstance().getLiveFollowSecondFloor()) && !z) {
                I();
            } else {
                B();
            }
        }
    }

    public void d0(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || (videoPlayFragmentAdapter = this.m) == null) {
            return;
        }
        videoPlayFragmentAdapter.j = str;
    }

    @Override // com.baidu.tieba.bx8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void e0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jVar) == null) {
            this.C = jVar;
        }
    }

    @Override // com.baidu.tieba.bx8
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.B.b();
        }
    }

    public void f0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iVar) == null) {
            this.q = iVar;
            this.B.e(iVar);
        }
    }

    @Override // com.baidu.tieba.ww8
    public void g(float f2) {
        AlaRecommendLayout alaRecommendLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || (alaRecommendLayout = this.g) == null) {
            return;
        }
        if (f2 == 1.0f) {
            alaRecommendLayout.setAlpha(1.0f);
            this.h.setAlpha(1.0f);
            return;
        }
        alaRecommendLayout.setAlpha(0.0f);
        this.h.setAlpha(0.0f);
    }

    public void g0(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, str) == null) || (videoPlayFragmentAdapter = this.m) == null) {
            return;
        }
        videoPlayFragmentAdapter.g = str;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            if (this.j != null) {
                if (!TbadkCoreApplication.isLogin() && this.w == 0) {
                    this.j.setEnabled(false);
                } else {
                    this.j.setEnabled(true);
                }
            }
            if (UtilHelper.isFlyMeOs() || this.a != 5) {
                return;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z && skinType != 4 && skinType != 1) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.r);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.r);
            }
        }
    }

    public void i0(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, kVar) == null) {
            this.k.J().findViewById(R.id.obfuscated_res_0x7f0906f9).setVisibility(4);
            this.j.setProgressViewCallback(kVar);
        }
    }

    public void j0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l.setCurrentItem(i2, z);
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.F = str;
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.w = i2;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.l.setScrollable(z);
        }
    }

    public void n0(cx8 cx8Var, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048620, this, cx8Var, i2, rect) == null) {
            this.p = cx8Var;
            this.B.d(cx8Var);
            cx8Var.E(this);
            this.o = i2;
            this.m.m(cx8Var, rect);
            this.m.notifyDataSetChanged();
            this.l.setCurrentItem(i2);
            C();
            if (rect == null || this.a != 1) {
                return;
            }
            this.g.setAlpha(0.0f);
            this.h.setAlpha(0.0f);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f.l();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090d0b) {
            this.A.onClick(view2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        k kVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2;
        VerticalViewPager verticalViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            if (i2 == 1 && (videoPlayFragmentAdapter2 = this.m) != null && (verticalViewPager2 = this.l) != null) {
                videoPlayFragmentAdapter2.i(verticalViewPager2.getCurrentItem());
            }
            if (i2 == 0 && (videoPlayFragmentAdapter = this.m) != null && (verticalViewPager = this.l) != null) {
                videoPlayFragmentAdapter.h(verticalViewPager.getCurrentItem());
                if (M()) {
                    this.l.setNeedHanleTouch(true);
                    this.l.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.l;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.l.setNeedHanleTouch(false);
                    this.v = false;
                }
            }
            if (i2 == 0) {
                if (this.E || (kVar = this.D) == null) {
                    return;
                }
                kVar.a();
            } else if (i2 == 1) {
                this.E = false;
            } else if (i2 != 2) {
            } else {
                this.E = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > ej.i(TbadkCoreApplication.getInst())) {
                this.v = true;
            }
            if (M()) {
                this.l.setNeedHanleTouch(true);
            } else {
                this.l.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            if (this.n > i2) {
                h hVar = this.H;
                if (hVar != null) {
                    hVar.a(i2);
                }
            } else {
                h hVar2 = this.H;
                if (hVar2 != null) {
                    hVar2.b(i2);
                }
            }
            this.n = i2;
            this.B.c(i2);
            if (!this.p.v() && this.p.k() - 1 > 0 && this.p.k() - i2 <= 2 && (iVar = this.q) != null) {
                iVar.a();
            }
            if (M()) {
                this.l.computeScroll();
            }
            this.A.g();
            ay8 ay8Var = this.I;
            if (ay8Var != null) {
                ay8Var.m(i2);
            }
            j jVar = this.C;
            if (jVar != null) {
                jVar.a();
            }
            if (Q(TbSingleton.getInstance().getLiveFollowSecondFloor()) && this.m.e(this.n) != null) {
                I();
            } else {
                B();
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.l.f(130);
        }
    }

    public void q0(BdUniqueId bdUniqueId, List<AlaLiveInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048627, this, bdUniqueId, list, str) == null) || list == null) {
            return;
        }
        this.i.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0249), Integer.valueOf(list.size())));
        z16 z16Var = new z16(bdUniqueId, list, str);
        if (ListUtils.isEmpty(z16Var.c())) {
            B();
            return;
        }
        this.g.setData(z16Var);
        this.g.d(TbadkCoreApplication.getInst().getSkinType());
    }
}
