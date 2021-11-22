package com.baidu.tieba.videoplay;

import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import b.a.e.f.p.l;
import b.a.q0.e1.r.b;
import b.a.r0.a3.e0.c;
import b.a.r0.q2.f;
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
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener, f.c, b.a.r0.c4.l.c, b.a.r0.c4.q.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_ATTENTION_SUB_FRAGMENT = "from_attention_sub_fragment";
    public static final String FROM_NO_SUB_FRAGMENT = "from_no_sub_fragment";
    public static final String FROM_SUGGEST_SUB_FRAGMENT = "from_suggest_sub_fragment";
    public static final int PAGE_TYPE_ATTENTION = 0;
    public static final int PAGE_TYPE_RECOMMEND = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public float B;
    public b.a.r0.c4.p.a C;
    public int currentSelectIndex;

    /* renamed from: e  reason: collision with root package name */
    public int f55917e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55918f;
    public int firstInIndex;

    /* renamed from: g  reason: collision with root package name */
    public View f55919g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f55920h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.g0.f f55921i;
    public VerticalViewPager j;
    public VideoPlayFragmentAdapter k;
    public b.a.r0.c4.l.d l;
    public e m;
    public FragmentActivity n;
    public TBLottieAnimationView o;
    public String p;
    public boolean q;
    public int r;
    public float s;
    public int t;
    public int u;
    public b.a.r0.c4.m.a v;
    public b.a.r0.c4.m.b w;
    public f x;
    public g y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f55922a;

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
            this.f55922a = videoPlayView;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.j
        public boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bdSwipeRefreshLayout, view)) == null) {
                if (this.f55922a.j == null) {
                    return false;
                }
                VideoAttentionListPageFragment attentionListFragment = this.f55922a.getAttentionListFragment();
                return attentionListFragment != null ? (this.f55922a.j.getCurrentItem() == 0 && attentionListFragment.isOnViewTop()) ? false : true : this.f55922a.j.getCurrentItem() != 0;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements VideoPlayFragment.k1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f55923a;

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
            this.f55923a = videoPlayView;
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.k1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55923a.v.j();
            }
        }

        @Override // com.baidu.tieba.videoplay.VideoPlayFragment.k1
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f55923a.A.equals(VideoPlayView.FROM_ATTENTION_SUB_FRAGMENT)) {
                return;
            }
            this.f55923a.v.d();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f55924e;

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
            this.f55924e = videoPlayView;
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
                        this.f55924e.B = motionEvent.getY() - this.f55924e.s;
                    } else if (action == 2) {
                        if (this.f55924e.s == 0.0f) {
                            this.f55924e.s = motionEvent.getY();
                        }
                        this.f55924e.B = motionEvent.getY() - this.f55924e.s;
                        if (this.f55924e.s > (l.j(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - this.f55924e.t && this.f55924e.B < UtilHelper.getDimenPixelSize(b.a.r0.c4.d.tbds25) && UtilHelper.hasNavBar(this.f55924e.n) && l.j(TbadkCoreApplication.getInst(), true) != this.f55924e.u) {
                            this.f55924e.q = true;
                        }
                    }
                    this.f55924e.s = 0.0f;
                } else {
                    this.f55924e.s = motionEvent.getY();
                    this.f55924e.q = false;
                }
                VideoPlayFragment currentFragment = this.f55924e.k.getCurrentFragment(this.f55924e.j.getCurrentItem());
                if (currentFragment != null) {
                    return currentFragment.handleBackPress();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f55925a;

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
            this.f55925a = videoPlayView;
        }

        @Override // b.a.r0.a3.e0.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f55925a.toNextPage();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes9.dex */
    public interface g {
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
        this.t = UtilHelper.getDimenPixelSize(b.a.r0.c4.d.tbds35);
        this.u = SpeedStatsStampTable.INIT_MSG_EIGHT_START_STAMP_KEY;
        this.w = new b.a.r0.c4.m.b();
        this.A = FROM_NO_SUB_FRAGMENT;
        this.B = 0.0f;
        this.n = fragmentActivity;
        this.f55917e = i3;
        this.f55918f = z;
        this.p = str;
        this.o = (TBLottieAnimationView) baseFragment.getView().findViewById(b.a.r0.c4.f.guide_animation_view);
        this.f55919g = baseFragment.getView().findViewById(b.a.r0.c4.f.root_layout);
        VerticalViewPager verticalViewPager = (VerticalViewPager) baseFragment.getView().findViewById(b.a.r0.c4.f.video_play_viewpager);
        this.j = verticalViewPager;
        verticalViewPager.setStrictSlide(false);
        this.v = new b.a.r0.c4.m.a(this.o, this.j);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) baseFragment.getView().findViewById(b.a.r0.c4.f.refresh_layout);
        this.f55920h = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setUseSlideAngleToPullRefresh(true);
        this.f55920h.setNoMoveTargetView(true);
        this.f55920h.setLimitDragDistance(true);
        b.a.q0.s.g0.f fVar = new b.a.q0.s.g0.f(fragmentActivity);
        this.f55921i = fVar;
        this.f55920h.setProgressView(fVar);
        this.f55920h.setOnChildScrollUpCallback(new a(this));
        if (this.k == null) {
            this.k = new VideoPlayFragmentAdapter(bdUniqueId, baseFragment, fragmentActivity, bdUniqueId2, i2, this.f55917e, this.f55918f);
        }
        this.k.setVideoStatusListener(new b(this));
        this.k.setVideoPlayPrefetcher(this);
        MessageManager.getInstance().registerListener(this.k.getAttentionListener());
        this.k.setOnProgressUpdatedListener(this);
        this.k.mFromPage = this.p;
        this.j.setOffscreenPageLimit(1);
        this.j.setAdapter(this.k);
        this.j.setOnPageChangeListener(this);
        this.j.setOnTouchListener(new c(this));
    }

    public VideoAttentionListPageFragment getAttentionListFragment() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.j) == null) {
                return null;
            }
            return videoPlayFragmentAdapter.getAttentionListFragment(verticalViewPager.getCurrentItem());
        }
        return (VideoAttentionListPageFragment) invokeV.objValue;
    }

    public b.InterfaceC0693b getCurrentFragment() {
        InterceptResult invokeV;
        VerticalViewPager verticalViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.j) == null) {
                return null;
            }
            VideoPlayFragment currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem());
            return currentFragment == null ? this.k.getVideoAdFragment(this.j.getCurrentItem()) : currentFragment;
        }
        return (b.InterfaceC0693b) invokeV.objValue;
    }

    public void handleActivityResult(int i2, int i3, Intent intent) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragment currentFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) || (videoPlayFragmentAdapter = this.k) == null || (verticalViewPager = this.j) == null || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem())) == null) {
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
            VideoPlayFragmentAdapter videoPlayFragmentAdapter = this.k;
            if (videoPlayFragmentAdapter == null || (verticalViewPager = this.j) == null || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(verticalViewPager.getCurrentItem())) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoPlayFragmentAdapter = this.k) == null || this.currentSelectIndex != 0 || (currentFragment = videoPlayFragmentAdapter.getCurrentFragment(0)) == null) {
            return;
        }
        currentFragment.initTiePlusRichTextView();
    }

    public boolean isUpOrDownScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.B < 0.0f : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55917e == 6 : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? DeviceInfoUtil.isHuaWeiVirtual() && this.q && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0 : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoPlayFragmentAdapter = this.k) == null) {
            return;
        }
        videoPlayFragmentAdapter.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f55919g, b.a.r0.c4.c.CAM_X0611, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view) == null) && view.getId() == b.a.r0.c4.f.guide_animation_view) {
            this.v.onClick(view);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
        g gVar;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        VerticalViewPager verticalViewPager;
        VideoPlayFragmentAdapter videoPlayFragmentAdapter2;
        VerticalViewPager verticalViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 == 1 && (videoPlayFragmentAdapter2 = this.k) != null && (verticalViewPager2 = this.j) != null) {
                videoPlayFragmentAdapter2.onStateChanged(verticalViewPager2.getCurrentItem());
            }
            if (i2 == 0 && (videoPlayFragmentAdapter = this.k) != null && (verticalViewPager = this.j) != null) {
                videoPlayFragmentAdapter.onPageScrollIdle(verticalViewPager.getCurrentItem());
                if (n()) {
                    this.j.setNeedHanleTouch(true);
                    this.j.setSelected(true);
                    VerticalViewPager verticalViewPager3 = this.j;
                    verticalViewPager3.setCurrentItem(verticalViewPager3.getCurrentItem(), true);
                    this.j.setNeedHanleTouch(false);
                    this.q = false;
                }
            }
            if (i2 == 0) {
                if (this.z || (gVar = this.y) == null) {
                    return;
                }
                gVar.a();
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
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (i3 > l.i(TbadkCoreApplication.getInst())) {
                this.q = true;
            }
            if (n()) {
                this.j.setNeedHanleTouch(true);
            } else {
                this.j.setNeedHanleTouch(false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.currentSelectIndex = i2;
            this.w.c(i2);
            if (!this.l.v() && this.l.k() - 1 > 0 && this.l.k() - i2 <= 2 && (eVar = this.m) != null) {
                eVar.a();
            }
            if (n()) {
                this.j.computeScroll();
            }
            this.v.g();
            b.a.r0.c4.p.a aVar = this.C;
            if (aVar != null) {
                aVar.m(i2);
            }
            f fVar = this.x;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.v.h();
        }
    }

    @Override // b.a.r0.q2.f.c
    public void onProgressUpdated(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || i2 - i3 >= 3500 || this.A.equals(FROM_ATTENTION_SUB_FRAGMENT) || m()) {
            return;
        }
        this.v.c();
    }

    @Override // b.a.r0.c4.l.c
    public void onVideoDataAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.w.b();
        }
    }

    @Override // b.a.r0.c4.l.c
    public void onVideoDataDelete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // b.a.r0.c4.l.c
    public void onVideoDataReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.w.b();
        }
    }

    @Override // b.a.r0.c4.q.a
    public void prefetch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w.a();
        }
    }

    public void setBottomScrollMoreCallback(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, gVar) == null) {
            this.y = gVar;
        }
    }

    public void setCurrentFragmentUserHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.k.setCurrentFragmentUserHint(z);
        }
    }

    public void setEventListener(b.InterfaceC0693b interfaceC0693b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, interfaceC0693b) == null) {
            this.j.setEventListener(interfaceC0693b);
        }
    }

    public void setNadDispatcher(b.a.r0.c4.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.C = aVar;
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
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || (videoPlayFragmentAdapter = this.k) == null) {
            return;
        }
        videoPlayFragmentAdapter.objId = str;
    }

    public void setOnLastShowVideoCallBack(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) {
            this.x = fVar;
        }
    }

    public void setOnLoadMoreListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eVar) == null) {
            this.m = eVar;
            this.w.e(eVar);
        }
    }

    public void setPageFrom(String str) {
        VideoPlayFragmentAdapter videoPlayFragmentAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (videoPlayFragmentAdapter = this.k) == null) {
            return;
        }
        videoPlayFragmentAdapter.mFrom = str;
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (this.f55920h != null) {
                if (!TbadkCoreApplication.isLogin() && this.r == 0) {
                    this.f55920h.setEnabled(false);
                } else {
                    this.f55920h.setEnabled(true);
                }
            }
            if (UtilHelper.isFlyMeOs() || this.f55917e != 5) {
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
        if (interceptable == null || interceptable.invokeL(1048606, this, kVar) == null) {
            this.f55921i.E().findViewById(b.a.r0.c4.f.continuous_loading_layout).setVisibility(4);
            this.f55920h.setProgressViewCallback(kVar);
        }
    }

    public void setSelectIndex(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.j.setCurrentItem(i2, z);
        }
    }

    public void setSubFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.A = str;
        }
    }

    public void setVideoChannelPageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setViewPagerScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.j.setScrollable(z);
        }
    }

    public void showData(b.a.r0.c4.l.d dVar, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048611, this, dVar, i2, rect) == null) {
            this.l = dVar;
            this.w.d(dVar);
            dVar.E(this);
            this.firstInIndex = i2;
            this.k.setDatas(dVar, rect);
            this.k.notifyDataSetChanged();
            this.j.setCurrentItem(i2);
        }
    }

    public void toNextPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.j.arrowScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        }
    }
}
