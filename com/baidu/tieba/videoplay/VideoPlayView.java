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
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.tieba.jo6;
import com.baidu.tieba.ko6;
import com.baidu.tieba.n9a;
import com.baidu.tieba.o75;
import com.baidu.tieba.oi9;
import com.baidu.tieba.s9a;
import com.baidu.tieba.saa;
import com.baidu.tieba.t9a;
import com.baidu.tieba.taa;
import com.baidu.tieba.vi;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.tieba.videoplay.view.SecondFloorPullView;
import com.baidu.tieba.w95;
import com.baidu.tieba.xm9;
import com.baidu.tieba.y9a;
import com.baidu.tieba.z26;
import com.baidu.tieba.z9a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes8.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, oi9.c, s9a, taa, n9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y9a A;
    public z9a B;
    public j C;
    public k D;
    public boolean E;
    public String F;
    public float G;
    public h H;
    public saa I;
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
    public w95 k;
    public VerticalViewPager l;
    public VideoPlayFragmentAdapter m;
    public int n;
    public int o;
    public t9a p;
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

    /* loaded from: classes8.dex */
    public interface h {
        void a(int i);

        void b(int i);
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface k {
        void a();
    }

    @Override // com.baidu.tieba.s9a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                boolean z2 = true;
                if (customResponsedMessage.getData() instanceof Boolean) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                } else {
                    z = true;
                }
                if (this.a.a != 1 && this.a.a != 2) {
                    z2 = false;
                }
                if (z2 && !z) {
                    this.a.D();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements w95.f {
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

        @Override // com.baidu.tieba.w95.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z && this.a.l.getCurrentItem() == 0 && this.a.f != null && this.a.S(TbSingleton.getInstance().getLiveFollowSecondFloor()) && this.a.f.getCurrentStatus() == 2) {
                this.a.f.m();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                VideoAttentionListPageFragment F = this.a.F();
                if (F != null) {
                    if (this.a.l.getCurrentItem() == 0 && F.z()) {
                        return false;
                    }
                    return true;
                } else if (this.a.l.getCurrentItem() == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.a.F.equals("from_attention_sub_fragment") && this.a.a != 9) {
                this.a.A.d();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.x == 0.0f) {
                                this.a.x = motionEvent.getY();
                            }
                            this.a.G = motionEvent.getY() - this.a.x;
                            if (this.a.x > (vi.k(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.a.y && this.a.G < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.a.r) && vi.k(TbadkCoreApplication.getInst(), true) != this.a.z) {
                                this.a.v = true;
                            }
                        }
                    } else {
                        this.a.G = motionEvent.getY() - this.a.x;
                    }
                    this.a.x = 0.0f;
                } else {
                    this.a.x = motionEvent.getY();
                    this.a.v = false;
                }
                VideoPlayFragment e = this.a.m.e(this.a.l.getCurrentItem());
                if (e != null) {
                    return e.r();
                }
                this.a.l.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (e = this.b.m.e(this.b.l.getCurrentItem())) == null) {
                return;
            }
            e.D4(i);
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i == 6) {
                            this.b.R();
                            return;
                        } else if (i == 7) {
                            TiebaStatic.log(new StatisticItem("c14931").param("obj_locate", this.b.H()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a).param("cuid", TbadkCoreApplication.getInst().getCuid()));
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.b.c) {
                        return;
                    } else {
                        this.b.c0(true);
                        this.b.Q();
                        this.b.X(false);
                        return;
                    }
                }
                this.b.c0(false);
                this.b.X(true);
                return;
            }
            this.b.X(true);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements xm9.a {
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

        @Override // com.baidu.tieba.xm9.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.q0();
            }
        }
    }

    public VideoPlayView(BdUniqueId bdUniqueId, FragmentActivity fragmentActivity, BaseFragment baseFragment, String str, BdUniqueId bdUniqueId2, int i2, int i3, boolean z, String str2) {
        boolean z2;
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
        this.B = new z9a();
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
        this.s = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f090ea3);
        this.e = baseFragment.getView().findViewById(R.id.root_layout);
        VerticalViewPager verticalViewPager = (VerticalViewPager) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f092824);
        this.l = verticalViewPager;
        verticalViewPager.setStrictSlide(false);
        this.A = new y9a(this.s, this.l);
        this.j = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.refresh_layout);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            this.j.setBackground(null);
            this.l.setBackground(null);
        }
        this.j.setUseSlideAngleToPullRefresh(true);
        this.j.setNoMoveTargetView(true);
        this.j.setLimitDragDistance(true);
        w95 w95Var = new w95(fragmentActivity);
        this.k = w95Var;
        w95Var.m(new b(this));
        this.j.setProgressView(this.k);
        this.j.setOnChildScrollUpCallback(new c(this));
        if (this.m == null) {
            int i6 = this.a;
            boolean z3 = this.b;
            if (S(TbSingleton.getInstance().getLiveFollowSecondFloor()) && T()) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.m = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i2, i6, z3, z2);
        }
        this.m.r(new d(this));
        this.m.q(this);
        this.m.l(this);
        MessageManager.getInstance().registerListener(this.m.d());
        MessageManager.getInstance().registerListener(this.J);
        this.m.p(this);
        this.m.h = this.t;
        this.l.setOffscreenPageLimit(1);
        this.l.setAdapter(this.m);
        this.l.setOnPageChangeListener(this);
        this.l.setOnTouchListener(new e(this));
        this.i = (TextView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09023f);
        this.h = baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09023d);
        AlaRecommendLayout alaRecommendLayout = (AlaRecommendLayout) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09282d);
        this.g = alaRecommendLayout;
        alaRecommendLayout.setDarkMode(true);
        SecondFloorPullView secondFloorPullView = (SecondFloorPullView) baseFragment.getView().findViewById(R.id.obfuscated_res_0x7f09206f);
        this.f = secondFloorPullView;
        secondFloorPullView.setOnStatusChange(new f(this, str2));
        this.f.setHideButton(this.h);
        this.f.setPullView(this.l);
        this.f.setSecondFloorView(this.g);
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            FragmentActivity fragmentActivity = this.r;
            if (fragmentActivity instanceof VideoPlayActivity) {
                ((VideoPlayActivity) fragmentActivity).setIsAddSwipeBackLayout(z);
            }
        }
    }

    public void Y(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, kVar) == null) {
            this.D = kVar;
        }
    }

    public void Z(boolean z) {
        SecondFloorPullView secondFloorPullView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.c = z;
            this.m.m(z);
            if (z && (secondFloorPullView = this.f) != null) {
                int currentStatus = secondFloorPullView.getCurrentStatus();
                if (currentStatus != 2) {
                    if (currentStatus == 5) {
                        Q();
                        return;
                    }
                    return;
                }
                R();
            }
        }
    }

    public void a0(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, hVar) == null) {
            this.H = hVar;
        }
    }

    public void b0(z26.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.l.setEventListener(bVar);
        }
    }

    public final void c0(boolean z) {
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

    @Override // com.baidu.tieba.n9a
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (S(TbSingleton.getInstance().getLiveFollowSecondFloor()) && !z) {
                K();
            } else {
                D();
            }
        }
    }

    public void d0(saa saaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, saaVar) == null) {
            this.I = saaVar;
            if (saaVar == null) {
                return;
            }
            saaVar.n(new g(this));
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.o(saaVar);
            }
        }
    }

    public void e0(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (videoPlayFragmentAdapter = this.m) != null) {
            videoPlayFragmentAdapter.j = str;
        }
    }

    public void f0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jVar) == null) {
            this.C = jVar;
        }
    }

    @Override // com.baidu.tieba.n9a
    public void g(float f2) {
        AlaRecommendLayout alaRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048610, this, f2) != null) || (alaRecommendLayout = this.g) == null) {
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

    public void g0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iVar) == null) {
            this.q = iVar;
            this.B.e(iVar);
        }
    }

    public void h0(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, str) == null) && (videoPlayFragmentAdapter = this.m) != null) {
            videoPlayFragmentAdapter.g = str;
        }
    }

    public void j0(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, kVar) == null) {
            this.k.J().findViewById(R.id.continuous_loading_layout).setVisibility(4);
            this.j.setProgressViewCallback(kVar);
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.F = str;
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.w = i2;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.l.setScrollable(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090ea3) {
            this.A.onClick(view2);
        }
    }

    @Override // com.baidu.tieba.oi9.c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) && i2 - i3 < 3500 && !this.F.equals("from_attention_sub_fragment") && !N()) {
            this.A.c();
        }
    }

    public void k0(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.l.setCurrentItem(i2, z);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.i();
        }
    }

    public VideoAttentionListPageFragment F() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null && (verticalViewPager = this.l) != null) {
                return videoPlayFragmentAdapter.c(verticalViewPager.getCurrentItem());
            }
            return null;
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.a;
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.l) == null || (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return e2.r();
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f.l();
        }
    }

    public void M() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (videoPlayFragmentAdapter = this.m) != null && this.n == 0 && (e2 = videoPlayFragmentAdapter.e(0)) != null) {
            e2.o4();
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.a == 6) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (DeviceInfoUtil.isHuaWeiVirtual() && this.v && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.G < 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i3 = this.a;
            if (i3 == 1) {
                i2 = 5;
            } else if (i3 == 2) {
                i2 = 6;
            } else {
                i2 = 0;
            }
            TiebaStatic.log(jo6.c("c13620", i2));
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.a == 1 && TbSingleton.getInstance().isShowRecommendLiveSecondFloor()) {
                return true;
            }
            if (this.a == 2 && TbSingleton.getInstance().isShowConcernLiveSecondFloor()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.A.h();
        }
    }

    @Override // com.baidu.tieba.s9a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.B.b();
        }
    }

    @Override // com.baidu.tieba.taa
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.B.a();
        }
    }

    @Override // com.baidu.tieba.s9a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.B.b();
        }
    }

    public void notifyDataSetChanged() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (videoPlayFragmentAdapter = this.m) != null) {
            videoPlayFragmentAdapter.notifyDataSetChanged();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f.n();
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.l.f(130);
        }
    }

    public final void E() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (S(TbSingleton.getInstance().getLiveFollowSecondFloor())) {
                if (T()) {
                    p0();
                    X(false);
                } else {
                    K();
                }
                BdUniqueId bdUniqueId = this.d;
                List<AlaLiveInfo> liveFollowSecondFloor = TbSingleton.getInstance().getLiveFollowSecondFloor();
                if (this.a == 1) {
                    str = "video_recommend";
                } else {
                    str = "video_concern";
                }
                r0(bdUniqueId, liveFollowSecondFloor, str);
                return;
            }
            D();
        }
    }

    public z26.b G() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null && (verticalViewPager = this.l) != null) {
                VideoPlayFragment e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem());
                if (e2 == null) {
                    return this.m.g(this.l.getCurrentItem());
                }
                return e2;
            }
            return null;
        }
        return (z26.b) invokeV.objValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TiebaStatic.log(new StatisticItem("c14930").param("obj_locate", H()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.u).param("cuid", TbadkCoreApplication.getInst().getCuid()));
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.m != null) {
                MessageManager.getInstance().unRegisterListener(this.m.d());
            }
            SecondFloorPullView secondFloorPullView = this.f;
            if (secondFloorPullView != null) {
                secondFloorPullView.setPullView(null);
            }
            MessageManager.getInstance().unRegisterListener(this.J);
            i0(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.k();
            }
            this.r = null;
        }
    }

    public void I(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) && (videoPlayFragmentAdapter = this.m) != null && (verticalViewPager = this.l) != null && (e2 = videoPlayFragmentAdapter.e(verticalViewPager.getCurrentItem())) != null) {
            e2.p(i2, i3, intent);
        }
    }

    public boolean S(List<AlaLiveInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (ListUtils.isEmpty(list) || list.get(0) == null) {
                return false;
            }
            int i2 = this.a;
            if (i2 != 1 && i2 != 2) {
                return false;
            }
            int intValue = list.get(0).show_page.intValue();
            if (intValue != 3 && ((this.a != 2 || intValue != 1) && (this.a != 1 || intValue != 2))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, i2);
            o75 d2 = o75.d(this.h);
            d2.e(R.string.A_X05);
            d2.o(R.string.J_X01);
            d2.h(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0106));
            this.g.d(i2);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.m;
            if (videoPlayFragmentAdapter != null && videoPlayFragmentAdapter.e(this.n) != null) {
                this.m.e(this.n).O3(i2);
            }
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            if (this.j != null) {
                if (!TbadkCoreApplication.isLogin() && this.w == 0) {
                    this.j.setEnabled(false);
                } else {
                    this.j.setEnabled(true);
                }
            }
            if (!UtilHelper.isFlyMeOs() && this.a == 5) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (!z && skinType != 4) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, this.r);
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.r);
                }
            }
        }
    }

    public void o0(t9a t9aVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048620, this, t9aVar, i2, rect) == null) {
            this.p = t9aVar;
            this.B.d(t9aVar);
            t9aVar.G(this);
            this.o = i2;
            this.m.n(t9aVar, rect);
            this.m.notifyDataSetChanged();
            this.l.setCurrentItem(i2);
            E();
            if (rect != null && this.a == 1) {
                this.g.setAlpha(0.0f);
                this.h.setAlpha(0.0f);
            }
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
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            if (i2 == 1 && (videoPlayFragmentAdapter2 = this.m) != null && (verticalViewPager2 = this.l) != null) {
                videoPlayFragmentAdapter2.j(verticalViewPager2.getCurrentItem());
            }
            if (i2 == 0 && (videoPlayFragmentAdapter = this.m) != null && (verticalViewPager = this.l) != null) {
                videoPlayFragmentAdapter.i(verticalViewPager.getCurrentItem());
                if (O()) {
                    this.l.setNeedHanleTouch(true);
                    this.l.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.l;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.l.setNeedHanleTouch(false);
                    this.v = false;
                }
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.E = true;
                        return;
                    }
                    return;
                }
                this.E = false;
            } else if (!this.E && (kVar = this.D) != null) {
                kVar.a();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
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
            if (!this.p.w() && this.p.k() - 1 > 0 && this.p.k() - i2 <= 2 && (iVar = this.q) != null) {
                iVar.a();
            }
            if (O()) {
                this.l.computeScroll();
            }
            this.A.g();
            saa saaVar = this.I;
            if (saaVar != null) {
                saaVar.m(i2);
            }
            j jVar = this.C;
            if (jVar != null) {
                jVar.a();
            }
            if (S(TbSingleton.getInstance().getLiveFollowSecondFloor()) && this.m.e(this.n) != null) {
                K();
            } else {
                D();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > vi.j(TbadkCoreApplication.getInst())) {
                this.v = true;
            }
            if (O()) {
                this.l.setNeedHanleTouch(true);
            } else {
                this.l.setNeedHanleTouch(false);
            }
        }
    }

    public void r0(BdUniqueId bdUniqueId, List<AlaLiveInfo> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048627, this, bdUniqueId, list, str) == null) && this.h != null && this.f != null) {
            if (list != null && !list.isEmpty()) {
                this.f.setAlaCount(list.size());
                if (this.f.getCurrentStatus() != 5) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
                this.i.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0274), Integer.valueOf(list.size())));
                ko6 ko6Var = new ko6(bdUniqueId, list, str);
                if (ListUtils.isEmpty(ko6Var.c())) {
                    D();
                    return;
                }
                this.g.setData(ko6Var);
                this.g.d(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
