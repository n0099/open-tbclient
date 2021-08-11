package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.p.l;
import c.a.o0.d1.q.a;
import c.a.p0.o2.f;
import c.a.p0.x2.e0.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
/* loaded from: classes7.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, f.c, c.a.p0.y3.c.c, c.a.p0.y3.h.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_ATTENTION_SUB_FRAGMENT = "from_attention_sub_fragment";
    public static final String FROM_NO_SUB_FRAGMENT = "from_no_sub_fragment";
    public static final String FROM_SUGGEST_SUB_FRAGMENT = "from_suggest_sub_fragment";
    public static final int PAGE_TYPE_ATTENTION = 0;
    public static final int PAGE_TYPE_RECOMMEND = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentSelectIndex;

    /* renamed from: e  reason: collision with root package name */
    public int f57571e;

    /* renamed from: f  reason: collision with root package name */
    public View f57572f;
    public int firstInIndex;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f57573g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.s.f0.f f57574h;

    /* renamed from: i  reason: collision with root package name */
    public VerticalViewPager f57575i;

    /* renamed from: j  reason: collision with root package name */
    public VideoPlayFragmentAdapter f57576j;
    public c.a.p0.y3.c.d k;
    public e l;
    public FragmentActivity m;
    public TBLottieAnimationView n;
    public String o;
    public boolean p;
    public int q;
    public float r;
    public int s;
    public int t;
    public c.a.p0.y3.d.a u;
    public c.a.p0.y3.d.b v;
    public f w;
    public boolean x;
    public String y;
    public c.a.p0.y3.g.a z;

    /* loaded from: classes7.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f57577a;

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
            this.f57577a = videoPlayView;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view)) == null) {
                if (this.f57577a.f57575i == null) {
                    return false;
                }
                VideoAttentionListPageFragment attentionListFragment = this.f57577a.getAttentionListFragment();
                return attentionListFragment != null ? (this.f57577a.f57575i.getCurrentItem() == 0 && attentionListFragment.isOnViewTop()) ? false : true : this.f57577a.f57575i.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements VideoPlayFragment.z0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f57578a;

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
            this.f57578a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.z0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57578a.u.j();
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.z0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f57578a.y.equals(VideoPlayView.FROM_ATTENTION_SUB_FRAGMENT)) {
                return;
            }
            this.f57578a.u.d();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f57579e;

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
            this.f57579e = videoPlayView;
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
                            if (this.f57579e.r == 0.0f) {
                                this.f57579e.r = motionEvent.getY();
                            }
                            float y = motionEvent.getY() - this.f57579e.r;
                            if (this.f57579e.r > (l.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.f57579e.s && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(this.f57579e.m) && l.j(TbadkCoreApplication.getInst(), true) != this.f57579e.t) {
                                this.f57579e.p = true;
                            }
                        }
                    }
                    this.f57579e.r = 0.0f;
                } else {
                    this.f57579e.r = motionEvent.getY();
                    this.f57579e.p = false;
                }
                VideoPlayFragment currentFragment = this.f57579e.f57576j.getCurrentFragment(this.f57579e.f57575i.getCurrentItem());
                if (currentFragment != null) {
                    return currentFragment.handleBackPress();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f57580a;

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
            this.f57580a = videoPlayView;
        }

        @Override // c.a.p0.x2.e0.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f57580a.toNextPage();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface f {
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
        this.currentSelectIndex = 0;
        this.s = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
        this.t = SpeedStatsStampTable.INIT_MSG_EIGHT_START_STAMP_KEY;
        this.v = new c.a.p0.y3.d.b();
        this.y = FROM_NO_SUB_FRAGMENT;
        this.m = fragmentActivity;
        this.f57571e = i3;
        this.o = str;
        this.n = (TBLottieAnimationView) baseFragment.getView().findViewById(R.id.guide_animation_view);
        this.f57572f = baseFragment.getView().findViewById(R.id.root_layout);
        this.f57575i = (VerticalViewPager) baseFragment.getView().findViewById(R.id.video_play_viewpager);
        this.u = new c.a.p0.y3.d.a(this.n, this.f57575i);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(R.id.refresh_layout);
        this.f57573g = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setNoMoveTargetView(true);
        this.f57573g.setLimitDragDistance(true);
        c.a.o0.s.f0.f fVar = new c.a.o0.s.f0.f(fragmentActivity);
        this.f57574h = fVar;
        this.f57573g.setProgressView(fVar);
        this.f57573g.setOnChildScrollUpCallback(new a(this));
        VideoPlayFragmentAdapter videoPlayFragmentAdapter = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i2, this.f57571e);
        this.f57576j = videoPlayFragmentAdapter;
        videoPlayFragmentAdapter.setVideoStatusListener(new b(this));
        this.f57576j.setVideoPlayPrefetcher(this);
        MessageManager.getInstance().registerListener(this.f57576j.getAttentionListener());
        this.f57576j.setOnProgressUpdatedListener(this);
        this.f57576j.mFromPage = this.o;
        this.f57575i.setOffscreenPageLimit(1);
        this.f57575i.setAdapter(this.f57576j);
        this.f57575i.setOnPageChangeListener(this);
        this.f57575i.setOnTouchListener(new c(this));
    }

    public VideoAttentionListPageFragment getAttentionListFragment() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f57576j;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f57575i) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.getAttentionListFragment(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public a.b getCurrentFragment() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f57576j;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f57575i) == null) {
                return null;
            }
            VideoPlayFragment currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem());
            return currentFragment == null ? this.f57576j.getVideoAdFragment(this.f57575i.getCurrentItem()) : currentFragment;
        }
        return (a.b) invokeV.objValue;
    }

    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment currentFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.f57576j) == null || (verticalViewPager = this.f57575i) == null || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem())) == null) {
            return;
        }
        currentFragment.handleActivityResult(i2, i3, intent);
    }

    public boolean handleBackPress() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment currentFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f57576j;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.f57575i) == null || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem())) == null) {
                return false;
            }
            return currentFragment.handleBackPress();
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.p && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (videoPlayFragmentAdapter = this.f57576j) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f57572f, R.color.CAM_X0611, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && view.getId() == R.id.guide_animation_view) {
            this.u.onClick(view);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f57576j != null) {
                MessageManager.getInstance().unRegisterListener(this.f57576j.getAttentionListener());
            }
            setPrimary(false);
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f57576j;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.saveNaniShowTime();
            }
            this.m = null;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        f fVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VerticalViewPager verticalViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter2 = this.f57576j;
            if (videoPlayFragmentAdapter2 != null && (verticalViewPager2 = this.f57575i) != null) {
                videoPlayFragmentAdapter2.onStateChanged(verticalViewPager2.getCurrentItem());
            }
            if (i2 == 0 && (videoPlayFragmentAdapter = this.f57576j) != null && (verticalViewPager = this.f57575i) != null) {
                videoPlayFragmentAdapter.onPageScrollIdle(verticalViewPager.getCurrentItem());
                if (k()) {
                    this.f57575i.setNeedHanleTouch(true);
                    this.f57575i.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.f57575i;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.f57575i.setNeedHanleTouch(false);
                    this.p = false;
                }
            }
            if (i2 == 0) {
                if (this.x || (fVar = this.w) == null) {
                    return;
                }
                fVar.a();
            } else if (i2 == 1) {
                this.x = false;
            } else if (i2 != 2) {
            } else {
                this.x = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > l.i(TbadkCoreApplication.getInst())) {
                this.p = true;
            }
            if (k()) {
                this.f57575i.setNeedHanleTouch(true);
            } else {
                this.f57575i.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.currentSelectIndex = i2;
            this.v.c(i2);
            if (!this.k.r() && this.k.j() - 1 > 0 && this.k.j() - i2 <= 2 && (eVar = this.l) != null) {
                eVar.a();
            }
            if (k()) {
                this.f57575i.computeScroll();
            }
            this.u.g();
            c.a.p0.y3.g.a aVar = this.z;
            if (aVar != null) {
                aVar.m(i2);
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.u.h();
        }
    }

    @Override // c.a.p0.o2.f.c
    public void onProgressUpdated(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) || i2 - i3 >= 3500 || this.y.equals(FROM_ATTENTION_SUB_FRAGMENT)) {
            return;
        }
        this.u.c();
    }

    @Override // c.a.p0.y3.c.c
    public void onVideoDataAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.v.b();
        }
    }

    @Override // c.a.p0.y3.c.c
    public void onVideoDataDelete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // c.a.p0.y3.c.c
    public void onVideoDataReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.v.b();
        }
    }

    @Override // c.a.p0.y3.h.a
    public void prefetch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.v.a();
        }
    }

    public void setBottomScrollMoreCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.w = fVar;
        }
    }

    public void setCurrentFragmentUserHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f57576j.setCurrentFragmentUserHint(z);
        }
    }

    public void setEventListener(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.f57575i.setEventListener(bVar);
        }
    }

    public void setNadDispatcher(c.a.p0.y3.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.z = aVar;
            if (aVar == null) {
                return;
            }
            aVar.n(new d(this));
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.f57576j;
            if (videoPlayFragmentAdapter != null) {
                videoPlayFragmentAdapter.setNadDispatcher(aVar);
            }
        }
    }

    public void setObjId(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (videoPlayFragmentAdapter = this.f57576j) == null) {
            return;
        }
        videoPlayFragmentAdapter.objId = str;
    }

    public void setOnLoadMoreListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.l = eVar;
            this.v.e(eVar);
        }
    }

    public void setPageFrom(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (videoPlayFragmentAdapter = this.f57576j) == null) {
            return;
        }
        videoPlayFragmentAdapter.mFrom = str;
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (this.f57573g != null) {
                if (!TbadkCoreApplication.isLogin() && this.q == 0) {
                    this.f57573g.setEnabled(false);
                } else {
                    this.f57573g.setEnabled(true);
                }
            }
            if (UtilHelper.isFlyMeOs()) {
                return;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z && skinType != 4 && skinType != 1) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.m);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.m);
            }
        }
    }

    public void setProgressViewCallback(BdSwipeRefreshLayout.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, kVar) == null) {
            this.f57574h.F().findViewById(R.id.continuous_loading_layout).setVisibility(4);
            this.f57573g.setProgressViewCallback(kVar);
        }
    }

    public void setSelectIndex(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f57575i.setCurrentItem(i2, z);
        }
    }

    public void setSubFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.y = str;
        }
    }

    public void setVideoChannelPageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setViewPagerScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f57575i.setScrollable(z);
        }
    }

    public void showData(c.a.p0.y3.c.d dVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048607, this, dVar, i2, rect) == null) {
            this.k = dVar;
            this.v.d(dVar);
            dVar.z(this);
            this.firstInIndex = i2;
            this.f57576j.setDatas(dVar, rect);
            this.f57576j.notifyDataSetChanged();
            this.f57575i.setCurrentItem(i2);
        }
    }

    public void toNextPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f57575i.arrowScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        }
    }
}
