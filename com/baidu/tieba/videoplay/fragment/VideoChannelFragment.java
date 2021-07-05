package com.baidu.tieba.videoplay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout;
import com.baidu.tieba.videoplay.view.VideoChannelViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes5.dex */
public class VideoChannelFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f21869e;

    /* renamed from: f  reason: collision with root package name */
    public VideoChannelViewPager f21870f;

    /* renamed from: g  reason: collision with root package name */
    public VideoChannelHeaderLayout f21871g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentAdapter f21872h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.r0.e0.c> f21873i;
    public boolean j;
    public int k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes5.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d.a.r0.e0.c> f21874a;

        /* renamed from: b  reason: collision with root package name */
        public int f21875b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21876c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<d.a.r0.e0.c> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21875b = -1;
            this.f21874a = list;
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21876c = z;
                int i2 = this.f21875b;
                if (i2 != -1 && (getItem(i2) instanceof BaseFragment)) {
                    ((BaseFragment) getItem(this.f21875b)).setPrimary(z);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<d.a.r0.e0.c> list = this.f21874a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        @NonNull
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f21874a.get(i2).f55251a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f21874a.get(i2).f55253c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                int i3 = this.f21875b;
                if (i3 != i2) {
                    if (i3 != -1 && (getItem(i3) instanceof BaseFragment)) {
                        ((BaseFragment) getItem(this.f21875b)).setPrimary(false);
                    }
                    this.f21875b = i2;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(this.f21876c);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21877a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoChannelFragment videoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21877a = videoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f21877a.f21871g.j(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21878a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoChannelFragment videoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21878a = videoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f21878a.f21871g.k(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21879a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoChannelFragment videoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21879a = videoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!j.z()) {
                l.J(this.f21879a.getContext(), this.f21879a.getResources().getString(R.string.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    if (this.f21879a.f21870f.getCurrentItem() == 0) {
                        this.f21879a.f21870f.setCurrentItem(1, false);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (booleanValue) {
                } else {
                    this.f21879a.f21871g.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21880a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoChannelFragment videoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21880a = videoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f21880a.Q0((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21881a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoChannelFragment videoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21881a = videoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f21881a.R0();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21882a;

        public f(VideoChannelFragment videoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21882a = videoChannelFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public void a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                this.f21882a.f21871g.l(i2, i3, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21883e;

        public g(VideoChannelFragment videoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21883e = videoChannelFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoChannelFragment f21884e;

        public h(VideoChannelFragment videoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21884e = videoChannelFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f21884e.f21871g.setPageSelected(i2);
                if (i2 == 0) {
                    this.f21884e.k = 2;
                } else if (i2 == 1) {
                    this.f21884e.k = 1;
                }
                if (i2 == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) ((d.a.r0.e0.c) this.f21884e.f21873i.get(1)).f55251a;
                    videoVerticalPageFragment.W0(null);
                    this.f21884e.f21870f.setListener(videoVerticalPageFragment.R0());
                    return;
                }
                this.f21884e.f21870f.setListener(null);
                if (this.f21884e.j) {
                    return;
                }
                this.f21884e.j = true;
                this.f21884e.f21871g.e();
            }
        }
    }

    public VideoChannelFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = 1;
        this.l = new a(this, 2921576);
        this.m = new b(this, 2921575);
        this.n = new c(this, 2921580);
        this.o = new d(this, 2921578);
        this.p = new e(this, 2921509);
    }

    public final void O0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            View findViewById = view.findViewById(R.id.youngster_layout);
            this.f21869e = findViewById;
            findViewById.setOnTouchListener(new g(this));
            this.f21870f = (VideoChannelViewPager) view.findViewById(R.id.main_view_pager);
            this.f21871g = (VideoChannelHeaderLayout) view.findViewById(R.id.main_header_layout);
            P0();
            R0();
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), this.f21873i);
            this.f21872h = fragmentAdapter;
            this.f21870f.setAdapter(fragmentAdapter);
            this.f21871g.setupWithViewPager(this.f21870f);
            this.f21870f.addOnPageChangeListener(new h(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.f21870f.setCurrentItem(0);
                return;
            }
            this.f21870f.setCurrentItem(1);
        }
    }

    public final void Q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f21871g.m(str);
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean d2 = d.a.r0.c1.b.e.d();
            View view = this.f21869e;
            boolean z = false;
            if (view != null) {
                view.setVisibility(d2 ? 0 : 8);
            }
            FragmentAdapter fragmentAdapter = this.f21872h;
            if (fragmentAdapter != null) {
                fragmentAdapter.c(!d2 && isPrimary());
                if (UtilHelper.isFlyMeOs() || !d2) {
                    return;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                UtilHelper.changeStatusBarIconAndTextColor((isPrimary() || skinType == 4 || skinType == 1) ? true : true, getActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.tabType = this.k;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            f fVar = new f(this);
            this.f21873i = new ArrayList();
            d.a.r0.e0.c cVar = new d.a.r0.e0.c();
            VideoAttentionPageFragment videoAttentionPageFragment = new VideoAttentionPageFragment(fVar, 0);
            cVar.f55251a = videoAttentionPageFragment;
            videoAttentionPageFragment.setArguments(getArguments());
            cVar.f55253c = getContext().getResources().getString(R.string.attention);
            this.f21873i.add(cVar);
            d.a.r0.e0.c cVar2 = new d.a.r0.e0.c();
            VideoVerticalPageFragment videoVerticalPageFragment = new VideoVerticalPageFragment(fVar, 1);
            cVar2.f55251a = videoVerticalPageFragment;
            videoVerticalPageFragment.setArguments(getArguments());
            cVar2.f55253c = getContext().getResources().getString(R.string.default_personalized_name);
            this.f21873i.add(cVar2);
            registerListener(this.l);
            registerListener(this.m);
            registerListener(this.n);
            registerListener(this.o);
            registerListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.video_channel_fragment, (ViewGroup) null);
            O0(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.f21871g;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.i();
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            R0();
        }
    }
}
