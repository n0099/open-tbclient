package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.s0.g1.r.b;
import c.a.t0.j3.e0.c;
import c.a.t0.z2.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, h.c, c.a.t0.m4.l.c, c.a.t0.m4.r.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_ATTENTION_SUB_FRAGMENT = "from_attention_sub_fragment";
    public static final String FROM_NO_SUB_FRAGMENT = "from_no_sub_fragment";
    public static final String FROM_SUGGEST_SUB_FRAGMENT = "from_suggest_sub_fragment";
    public static final int PAGE_TYPE_ATTENTION = 0;
    public static final int PAGE_TYPE_RECOMMEND = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public float B;
    public e C;
    public c.a.t0.m4.q.a D;
    public int currentSelectIndex;

    /* renamed from: e  reason: collision with root package name */
    public int f48825e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48826f;
    public int firstInIndex;

    /* renamed from: g  reason: collision with root package name */
    public View f48827g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f48828h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.s.j0.f f48829i;

    /* renamed from: j  reason: collision with root package name */
    public VerticalViewPager f48830j;
    public VideoPlayFragmentAdapter k;
    public c.a.t0.m4.l.d l;
    public f m;
    public FragmentActivity n;
    public TBLottieAnimationView o;
    public String p;
    public boolean q;
    public int r;
    public float s;
    public int t;
    public int u;
    public c.a.t0.m4.n.a v;
    public c.a.t0.m4.n.b w;
    public g x;
    public h y;
    public boolean z;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f48830j == null) {
                    return false;
                }
                VideoAttentionListPageFragment attentionListFragment = this.a.getAttentionListFragment();
                return attentionListFragment != null ? (this.a.f48830j.getCurrentItem() == 0 && attentionListFragment.isOnViewTop()) ? false : true : this.a.f48830j.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements VideoPlayFragment.k1 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.k1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v.j();
                int currentItem = this.a.f48830j.getCurrentItem();
                if (this.a.k.getData(currentItem) != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_AUTO_PLAY);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", this.a.k.getData(currentItem).thread_id);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.k1
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.A.equals(VideoPlayView.FROM_ATTENTION_SUB_FRAGMENT) || this.a.f48825e == 9) {
                return;
            }
            this.a.v.d();
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f48831e;

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
            this.f48831e = videoPlayView;
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
                        this.f48831e.B = motionEvent.getY() - this.f48831e.s;
                    } else if (action == 2) {
                        if (this.f48831e.s == 0.0f) {
                            this.f48831e.s = motionEvent.getY();
                        }
                        this.f48831e.B = motionEvent.getY() - this.f48831e.s;
                        if (this.f48831e.s > (n.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.f48831e.t && this.f48831e.B < UtilHelper.getDimenPixelSize(c.a.t0.m4.d.tbds25) && UtilHelper.hasNavBar(this.f48831e.n) && n.j(TbadkCoreApplication.getInst(), true) != this.f48831e.u) {
                            this.f48831e.q = true;
                        }
                    }
                    this.f48831e.s = 0.0f;
                } else {
                    this.f48831e.s = motionEvent.getY();
                    this.f48831e.q = false;
                }
                VideoPlayFragment currentFragment = this.f48831e.k.getCurrentFragment(this.f48831e.f48830j.getCurrentItem());
                if (currentFragment != null) {
                    return currentFragment.handleBackPress();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayView;
        }

        @Override // c.a.t0.j3.e0.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.toNextPage();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface e {
        void a(int i2);

        void b(int i2);
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes12.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes12.dex */
    public interface h {
        void a();
    }

    public VideoPlayView(BdUniqueId bdUniqueId, FragmentActivity fragmentActivity, BaseFragment baseFragment, String str, BdUniqueId bdUniqueId2, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, fragmentActivity, baseFragment, str, bdUniqueId2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentSelectIndex = 0;
        this.t = UtilHelper.getDimenPixelSize(c.a.t0.m4.d.tbds35);
        this.u = 2049;
        this.w = new c.a.t0.m4.n.b();
        this.A = FROM_NO_SUB_FRAGMENT;
        this.B = 0.0f;
        this.n = fragmentActivity;
        this.f48825e = i3;
        this.f48826f = z;
        this.p = str;
        this.o = (TBLottieAnimationView) baseFragment.getView().findViewById(c.a.t0.m4.f.guide_animation_view);
        this.f48827g = baseFragment.getView().findViewById(c.a.t0.m4.f.root_layout);
        VerticalViewPager verticalViewPager = (VerticalViewPager) baseFragment.getView().findViewById(c.a.t0.m4.f.video_play_viewpager);
        this.f48830j = verticalViewPager;
        verticalViewPager.setStrictSlide(false);
        this.v = new c.a.t0.m4.n.a(this.o, this.f48830j);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(c.a.t0.m4.f.refresh_layout);
        this.f48828h = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setUseSlideAngleToPullRefresh(true);
        this.f48828h.setNoMoveTargetView(true);
        this.f48828h.setLimitDragDistance(true);
        c.a.s0.s.j0.f fVar = new c.a.s0.s.j0.f(fragmentActivity);
        this.f48829i = fVar;
        this.f48828h.setProgressView(fVar);
        this.f48828h.setOnChildScrollUpCallback(new a(this));
        if (this.k == null) {
            this.k = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i2, this.f48825e, this.f48826f);
        }
        this.k.setVideoStatusListener(new b(this));
        this.k.setVideoPlayPrefetcher(this);
        MessageManager.getInstance().registerListener(this.k.getAttentionListener());
        this.k.setOnProgressUpdatedListener(this);
        this.k.mFromPage = this.p;
        this.f48830j.setOffscreenPageLimit(1);
        this.f48830j.setAdapter(this.k);
        this.f48830j.setOnPageChangeListener(this);
        this.f48830j.setOnTouchListener(new c(this));
    }

    public VideoAttentionListPageFragment getAttentionListFragment() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f48830j) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.getAttentionListFragment(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public b.InterfaceC0848b getCurrentFragment() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f48830j) == null) {
                return null;
            }
            VideoPlayFragment currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem());
            return currentFragment == null ? this.k.getVideoAdFragment(this.f48830j.getCurrentItem()) : currentFragment;
        }
        return (b.InterfaceC0848b) invokeV.objValue;
    }

    public e getDragDirectionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.C : (e) invokeV.objValue;
    }

    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment currentFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.k) == null || (verticalViewPager = this.f48830j) == null || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        currentFragment.handleActivityResult(i2, i3, intent);
    }

    public boolean handleBackPress() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment currentFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f48830j) == null || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return currentFragment.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    public void initTiePlusView() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VideoPlayFragment currentFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (videoPlayFragmentAdapter = this.k) == null || this.currentSelectIndex != 0 || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(0)) == null) {
            return;
        }
        currentFragment.initTiePlusRichTextView();
    }

    public boolean isUpOrDownScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B < 0.0f : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48825e == 6 : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoPlayFragmentAdapter = this.k) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.q && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f48827g, c.a.t0.m4.c.CAM_X0611, i2);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || videoPlayFragmentAdapter.getCurrentFragment(this.currentSelectIndex) == null) {
                return;
            }
            this.k.getCurrentFragment(this.currentSelectIndex).changeEditorSkinType(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view.getId() == c.a.t0.m4.f.guide_animation_view) {
            this.v.onClick(view);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k.getAttentionListener());
            }
            setPrimary(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.saveNaniShowTime();
            }
            this.n = null;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        h hVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2;
        VerticalViewPager verticalViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (i2 == 1 && (videoPlayFragmentAdapter2 = this.k) != null && (verticalViewPager2 = this.f48830j) != null) {
                videoPlayFragmentAdapter2.onStateChanged(verticalViewPager2.getCurrentItem());
            }
            if (i2 == 0 && (videoPlayFragmentAdapter = this.k) != null && (verticalViewPager = this.f48830j) != null) {
                videoPlayFragmentAdapter.onPageScrollIdle(verticalViewPager.getCurrentItem());
                if (o()) {
                    this.f48830j.setNeedHanleTouch(true);
                    this.f48830j.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.f48830j;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.f48830j.setNeedHanleTouch(false);
                    this.q = false;
                }
            }
            if (i2 == 0) {
                if (this.z || (hVar = this.y) == null) {
                    return;
                }
                hVar.a();
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
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > n.i(TbadkCoreApplication.getInst())) {
                this.q = true;
            }
            if (o()) {
                this.f48830j.setNeedHanleTouch(true);
            } else {
                this.f48830j.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (this.currentSelectIndex > i2) {
                e eVar = this.C;
                if (eVar != null) {
                    eVar.a(i2);
                }
            } else {
                e eVar2 = this.C;
                if (eVar2 != null) {
                    eVar2.b(i2);
                }
            }
            this.currentSelectIndex = i2;
            this.w.c(i2);
            if (!this.l.v() && this.l.k() - 1 > 0 && this.l.k() - i2 <= 2 && (fVar = this.m) != null) {
                fVar.a();
            }
            if (o()) {
                this.f48830j.computeScroll();
            }
            this.v.g();
            c.a.t0.m4.q.a aVar = this.D;
            if (aVar != null) {
                aVar.m(i2);
            }
            g gVar = this.x;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.v.h();
        }
    }

    @Override // c.a.t0.z2.h.c
    public void onProgressUpdated(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || i2 - i3 >= 3500 || this.A.equals(FROM_ATTENTION_SUB_FRAGMENT) || n()) {
            return;
        }
        this.v.c();
    }

    @Override // c.a.t0.m4.l.c
    public void onVideoDataAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.w.b();
        }
    }

    @Override // c.a.t0.m4.l.c
    public void onVideoDataDelete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // c.a.t0.m4.l.c
    public void onVideoDataReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w.b();
        }
    }

    @Override // c.a.t0.m4.r.a
    public void prefetch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.w.a();
        }
    }

    public void setBottomScrollMoreCallback(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, hVar) == null) {
            this.y = hVar;
        }
    }

    public void setCurrentFragmentUserHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.k.setCurrentFragmentUserHint(z);
        }
    }

    public void setDragDirectionListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, eVar) == null) {
            this.C = eVar;
        }
    }

    public void setEventListener(b.InterfaceC0848b interfaceC0848b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, interfaceC0848b) == null) {
            this.f48830j.setEventListener(interfaceC0848b);
        }
    }

    public void setNadDispatcher(c.a.t0.m4.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.D = aVar;
            if (aVar == null) {
                return;
            }
            aVar.n(new d(this));
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.setNadDispatcher(aVar);
            }
        }
    }

    public void setObjId(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || (videoPlayFragmentAdapter = this.k) == null) {
            return;
        }
        videoPlayFragmentAdapter.objId = str;
    }

    public void setOnLastShowVideoCallBack(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, gVar) == null) {
            this.x = gVar;
        }
    }

    public void setOnLoadMoreListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
            this.m = fVar;
            this.w.e(fVar);
        }
    }

    public void setPageFrom(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (videoPlayFragmentAdapter = this.k) == null) {
            return;
        }
        videoPlayFragmentAdapter.mFrom = str;
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (this.f48828h != null) {
                if (!TbadkCoreApplication.isLogin() && this.r == 0) {
                    this.f48828h.setEnabled(false);
                } else {
                    this.f48828h.setEnabled(true);
                }
            }
            if (UtilHelper.isFlyMeOs() || this.f48825e != 5) {
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

    public void setProgressViewCallback(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, kVar) == null) {
            this.f48829i.E().findViewById(c.a.t0.m4.f.continuous_loading_layout).setVisibility(4);
            this.f48828h.setProgressViewCallback(kVar);
        }
    }

    public void setSelectIndex(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f48830j.setCurrentItem(i2, z);
        }
    }

    public void setSubFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.A = str;
        }
    }

    public void setVideoChannelPageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setViewPagerScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f48830j.setScrollable(z);
        }
    }

    public void showData(c.a.t0.m4.l.d dVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048613, this, dVar, i2, rect) == null) {
            this.l = dVar;
            this.w.d(dVar);
            dVar.E(this);
            this.firstInIndex = i2;
            this.k.setDatas(dVar, rect);
            this.k.notifyDataSetChanged();
            this.f48830j.setCurrentItem(i2);
        }
    }

    public void toNextPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f48830j.arrowScroll(130);
        }
    }
}
