package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.r0.d1.u0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.pass.ecommerce.common.view.ToastUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.play.cyberPlayer.CyberRemotePlayerService;
import com.baidu.tieba.videoplay.model.JumpYYLiveHttpResponseMessage;
import com.baidu.tieba.videoplay.model.JumpYYLiveRequestHttpMessage;
import com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout;
import com.baidu.tieba.videoplay.view.VideoChannelViewPager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes12.dex */
public abstract class AbsVideoChannelFragment extends BaseFragment implements c.a.s0.l4.p.n {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean E = false;
    public static final int TYPE_VIDEO_CHANNEL = 1;
    public static final int TYPE_VIDEO_MIDDLE = 2;
    public static final int VIDEO_CHANNEL_PAGE_TYPE_ATTENTION = 0;
    public static final int VIDEO_CHANNEL_PAGE_TYPE_RECOMMEND = 1;
    public static boolean isShowComment;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public CustomMessageListener B;
    public HttpMessageListener C;
    public CustomMessageListener D;

    /* renamed from: e  reason: collision with root package name */
    public View f50566e;

    /* renamed from: f  reason: collision with root package name */
    public VideoChannelViewPager f50567f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentAdapter f50568g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.r0.i0.c> f50569h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50570i;

    /* renamed from: j  reason: collision with root package name */
    public int f50571j;

    /* renamed from: k  reason: collision with root package name */
    public int f50572k;
    public boolean l;
    public String m;
    public BdUniqueId mActivityPageUniqueId;
    public ImageView mAlaEntranceBtn;
    public ImageView mBackBtn;
    public ViewGroup mTaskFloatingView;
    public VideoChannelHeaderLayout mainHeaderLayout;
    public String n;
    public String o;
    public long p;
    public boolean q;
    public String r;
    public boolean s;
    public WeakReference<Context> t;
    public boolean u;
    public boolean v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public final CustomMessageListener z;

    /* loaded from: classes12.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.r0.i0.c> a;

        /* renamed from: b  reason: collision with root package name */
        public int f50573b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50574c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<c.a.r0.i0.c> list) {
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
            this.f50573b = -1;
            this.a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<c.a.r0.i0.c> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public BaseFragment getCurrentFragment() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<c.a.r0.i0.c> list = this.a;
                if (list == null || (i2 = this.f50573b) == -1 || !(list.get(i2).a instanceof BaseFragment)) {
                    return null;
                }
                return (BaseFragment) this.a.get(this.f50573b).a;
            }
            return (BaseFragment) invokeV.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        @NonNull
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.a.get(i2).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.a.get(i2).f12651c : (CharSequence) invokeI.objValue;
        }

        public void setPrimary(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f50574c = z;
                int i2 = this.f50573b;
                if (i2 != -1 && (getItem(i2) instanceof BaseFragment)) {
                    ((BaseFragment) getItem(this.f50573b)).setPrimary(z);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                int i3 = this.f50573b;
                if (i3 != i2) {
                    if (i3 != -1 && (getItem(i3) instanceof BaseFragment)) {
                        ((BaseFragment) getItem(this.f50573b)).setPrimary(false);
                    }
                    this.f50573b = i2;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(this.f50574c);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f50575e;

        public a(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50575e = absVideoChannelFragment;
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

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f50576e;

        public b(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50576e = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50576e.l) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
            statisticItem.addParam("obj_type", this.f50576e.getCurrentType() == 1 ? 1 : 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new JumpYYLiveRequestHttpMessage());
            this.f50576e.l = true;
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f50577e;

        public c(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50577e = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TbSingleton.getInstance().isFromFeedVideoClick() && !"frs".equals(this.f50577e.o)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                } else if (this.f50577e.getCurrentType() != 1) {
                    this.f50577e.getPageContext().getPageActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements VideoChannelHeaderLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public d(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoChannelFragment;
        }

        @Override // com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsVideoChannelFragment absVideoChannelFragment = this.a;
                if (absVideoChannelFragment.mainHeaderLayout == null || absVideoChannelFragment.f50567f == null || ListUtils.getItem(this.a.f50569h, this.a.f50567f.getCurrentItem()) == null || !(((c.a.r0.i0.c) ListUtils.getItem(this.a.f50569h, this.a.f50567f.getCurrentItem())).a instanceof BaseFragment)) {
                    return;
                }
                AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                absVideoChannelFragment2.mainHeaderLayout.achieveRefresh(((BaseFragment) ((c.a.r0.i0.c) ListUtils.getItem(absVideoChannelFragment2.f50569h, this.a.f50567f.getCurrentItem())).a).getUniqueId());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f50578e;

        public e(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50578e = absVideoChannelFragment;
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
                this.f50578e.f50572k = i2;
                this.f50578e.mainHeaderLayout.setPageSelected(i2);
                if (i2 == 0) {
                    this.f50578e.f50571j = 2;
                } else if (i2 == 1) {
                    this.f50578e.f50571j = 1;
                }
                if (i2 == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) ((c.a.r0.i0.c) this.f50578e.f50569h.get(1)).a;
                    videoVerticalPageFragment.setVideoPlayViewEventListener(null);
                    this.f50578e.f50567f.setListener(videoVerticalPageFragment.getVEventListener());
                    return;
                }
                this.f50578e.f50567f.setListener(null);
                if (this.f50578e.f50570i || this.f50578e.f50567f == null || ListUtils.getItem(this.f50578e.f50569h, this.f50578e.f50567f.getCurrentItem()) == null || !(((c.a.r0.i0.c) ListUtils.getItem(this.f50578e.f50569h, this.f50578e.f50567f.getCurrentItem())).a instanceof BaseFragment)) {
                    return;
                }
                this.f50578e.f50570i = true;
                AbsVideoChannelFragment absVideoChannelFragment = this.f50578e;
                absVideoChannelFragment.mainHeaderLayout.achieveRefresh(((BaseFragment) ((c.a.r0.i0.c) ListUtils.getItem(absVideoChannelFragment.f50569h, i2)).a).getUniqueId());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.a.mainHeaderLayout) == null) {
                return;
            }
            videoChannelHeaderLayout.onFinish(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                AbsVideoChannelFragment absVideoChannelFragment = this.a;
                absVideoChannelFragment.lazyInitViewPager(absVideoChannelFragment.getView());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.a.mainHeaderLayout) == null) {
                return;
            }
            videoChannelHeaderLayout.onRefresh(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes12.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!c.a.d.f.p.k.z()) {
                c.a.d.f.p.m.J(this.a.getContext(), this.a.getResources().getString(c.a.s0.l4.i.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    if (this.a.f50567f != null && this.a.f50567f.getCurrentItem() == 0) {
                        AbsVideoChannelFragment absVideoChannelFragment = this.a;
                        if (absVideoChannelFragment.mainHeaderLayout != null) {
                            absVideoChannelFragment.f50567f.setCurrentItem(1, false);
                            this.a.mainHeaderLayout.setPageSelected(1);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (booleanValue) {
                } else {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                    if (absVideoChannelFragment2.mainHeaderLayout == null || absVideoChannelFragment2.f50567f == null || ListUtils.getItem(this.a.f50569h, this.a.f50567f.getCurrentItem()) == null || !(((c.a.r0.i0.c) ListUtils.getItem(this.a.f50569h, this.a.f50567f.getCurrentItem())).a instanceof BaseFragment)) {
                        return;
                    }
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                    absVideoChannelFragment3.mainHeaderLayout.achieveRefresh(((BaseFragment) ((c.a.r0.i0.c) ListUtils.getItem(absVideoChannelFragment3.f50569h, this.a.f50567f.getCurrentItem())).a).getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.w((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.x();
        }
    }

    /* loaded from: classes12.dex */
    public class l extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.l = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (httpResponsedMessage instanceof JumpYYLiveHttpResponseMessage) {
                        YyExtData yyExtData = ((JumpYYLiveHttpResponseMessage) httpResponsedMessage).getYyExtData();
                        if (yyExtData == null) {
                            ToastUtil.show("服务器加载中，请稍候再试");
                            return;
                        } else {
                            YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), yyExtData, this.a.getCurrentType() == 1 ? YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL : YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE);
                            return;
                        }
                    }
                    return;
                }
                ToastUtil.show("服务器加载中，请稍候再试");
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i2)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.mActivityPageUniqueId.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.a.mainHeaderLayout.setAlpha(floatValue);
            this.a.mAlaEntranceBtn.setAlpha(floatValue);
            if (i2 == 0) {
                this.a.mAlaEntranceBtn.setVisibility(0);
            } else {
                this.a.mAlaEntranceBtn.setVisibility(8);
            }
            if (this.a.getCurrentType() == 2) {
                this.a.mBackBtn.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n implements CyberPlayerManager.InstallListener2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f50579b;

        public n(AbsVideoChannelFragment absVideoChannelFragment, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50579b = absVideoChannelFragment;
            this.a = view;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
        public void onInstallInfo(int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) && (obj instanceof String)) {
                if (i2 == 100) {
                    TbadkCoreApplication.getInst().setLibcyberffmpeg((String) obj);
                } else if (i2 == 101) {
                    TbadkCoreApplication.getInst().setLibssl((String) obj);
                } else if (i2 == 102) {
                    TbadkCoreApplication.getInst().setLibcrypto((String) obj);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                this.f50579b.u = false;
                TbadkCoreApplication.getInst().setLibcyberVersion(str);
                this.f50579b.lazyInitViewPagerImpl(this.a);
                if (!this.f50579b.isPrimary() || this.f50579b.f50569h == null || this.f50579b.f50569h.size() <= this.f50579b.f50572k || this.f50579b.f50569h.get(this.f50579b.f50572k) == null || ((c.a.r0.i0.c) this.f50579b.f50569h.get(this.f50579b.f50572k)).a == null) {
                    return;
                }
                ((c.a.r0.i0.c) this.f50579b.f50569h.get(this.f50579b.f50572k)).a.setUserVisibleHint(this.f50579b.v);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2348030, "Lcom/baidu/tieba/videoplay/fragment/AbsVideoChannelFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2348030, "Lcom/baidu/tieba/videoplay/fragment/AbsVideoChannelFragment;");
                return;
            }
        }
        E = !c.a.r0.b.d.E();
    }

    public AbsVideoChannelFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50570i = false;
        this.f50571j = 1;
        this.f50572k = 0;
        this.l = false;
        this.p = 0L;
        this.s = false;
        this.t = null;
        this.u = false;
        this.v = false;
        this.w = new f(this, 2921576);
        this.x = new g(this, 2921616);
        this.y = new h(this, 2921575);
        this.z = new i(this, 2921580);
        this.A = new j(this, 2921578);
        this.B = new k(this, 2921509);
        this.C = new l(this, CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
        this.D = new m(this, 2921594);
    }

    public abstract int getCurrentType();

    @Override // c.a.s0.l4.p.n
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.s0.l4.p.n s = s();
            if (s != null) {
                return s.getMissionTid();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.tabType = this.f50571j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public abstract Fragment getVideoAttentionFragment();

    public abstract Fragment getVideoRecommendFragment();

    @Override // c.a.s0.l4.p.n
    public void handleActivityResult(int i2, int i3, Intent intent) {
        c.a.s0.l4.p.n s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) || (s = s()) == null) {
            return;
        }
        s.handleActivityResult(i2, i3, intent);
    }

    @Override // c.a.s0.l4.p.n
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.l4.p.n s = s();
            if (s != null) {
                return s.handleBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.l4.p.n
    public void handleIndexMessage() {
        c.a.s0.l4.p.n s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (s = s()) == null) {
            return;
        }
        s.handleIndexMessage();
    }

    public void lazyInitViewPager(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        if (!this.u && CyberPlayerManager.isCoreLoaded(1)) {
            lazyInitViewPagerImpl(view);
        } else if (this.u) {
        } else {
            this.u = true;
            try {
                CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuidGalaxy2(), (String) null, 3, (Class<?>) CyberRemotePlayerService.class, (Map<String, String>) null, (CyberPlayerManager.InstallListener2) new n(this, view));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void lazyInitViewPagerImpl(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null || this.s || getActivity() == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(c.a.s0.l4.f.main_view_pager_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        u(view);
        this.s = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            WebPManager.setMaskDrawable(this.mAlaEntranceBtn, c.a.s0.l4.e.icon_videotab_live40, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.mBackBtn, c.a.s0.l4.e.icon_pure_topbar_return40, c.a.s0.l4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            FragmentAdapter fragmentAdapter = this.f50568g;
            if (fragmentAdapter == null || fragmentAdapter.getCurrentFragment() == null) {
                return;
            }
            this.f50568g.getCurrentFragment().onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.p = System.currentTimeMillis();
            this.t = new WeakReference<>(TbadkCoreApplication.getInst());
            this.f50569h = new ArrayList();
            c.a.r0.i0.c cVar = new c.a.r0.i0.c();
            Fragment videoAttentionFragment = getVideoAttentionFragment();
            cVar.a = videoAttentionFragment;
            videoAttentionFragment.setArguments(getArguments());
            cVar.f12651c = getContext().getResources().getString(c.a.s0.l4.i.attention);
            this.f50569h.add(cVar);
            c.a.r0.i0.c cVar2 = new c.a.r0.i0.c();
            Fragment videoRecommendFragment = getVideoRecommendFragment();
            cVar2.a = videoRecommendFragment;
            videoRecommendFragment.setArguments(getArguments());
            cVar2.f12651c = getContext().getResources().getString(c.a.s0.l4.i.default_personalized_name);
            this.f50569h.add(cVar2);
            registerListener(this.w);
            registerListener(this.x);
            registerListener(this.y);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.B);
            registerListener(this.C);
            registerListener(this.D);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.s0.l4.g.video_channel_fragment, (ViewGroup) null);
            if (!E) {
                lazyInitViewPager(inflate);
            } else {
                E = false;
                if (c.a.r0.a.d.y().E() && !StringUtils.isNull(t()) && "22_recommend".equals(t())) {
                    lazyInitViewPager(inflate);
                }
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            u0.f(this.t, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.mainHeaderLayout;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.onDestroy();
            }
            if (this.p != 0 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                c.a.s0.l4.k.b(this.r, this.q, this.p, this.n, this.o, this.m);
                this.p = 0L;
            }
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(false, getPageContext().getPageActivity());
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
            x();
            if (isPrimary()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("obj_type", getCurrentType() == 1 ? 1 : 2);
                TiebaStatic.log(statisticItem);
            }
            if (!UtilHelper.isFlyMeOs()) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (!isPrimary() && skinType != 4 && skinType != 1) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
                }
            }
            u0.f(this.t, isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (this.f50567f == null || this.mainHeaderLayout == null || StringUtils.isNull(t()) || !"22_recommend".equals(t())) {
                return;
            }
            this.f50567f.setCurrentItem(1, false);
            this.mainHeaderLayout.setPageSelected(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onViewStateRestored(bundle);
        }
    }

    public final c.a.s0.l4.p.n s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            FragmentAdapter fragmentAdapter = this.f50568g;
            if (fragmentAdapter == null || fragmentAdapter.f50573b == -1) {
                return null;
            }
            Fragment item = this.f50568g.getItem(this.f50568g.f50573b);
            if (item instanceof c.a.s0.l4.p.n) {
                return (c.a.s0.l4.p.n) item;
            }
            return null;
        }
        return (c.a.s0.l4.p.n) invokeV.objValue;
    }

    public void setActivityPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.mActivityPageUniqueId = bdUniqueId;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z) {
                lazyInitViewPager(getView());
            }
            this.v = z;
            List<c.a.r0.i0.c> list = this.f50569h;
            if (list != null) {
                int size = list.size();
                int i2 = this.f50572k;
                if (size <= i2 || this.f50569h.get(i2) == null || this.f50569h.get(this.f50572k).a == null) {
                    return;
                }
                this.f50569h.get(this.f50572k).a.setUserVisibleHint(z);
            }
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String stringExtra = getPageContext().getPageActivity().getIntent().getStringExtra("sub_locate_type");
            if (StringUtils.isNull(stringExtra)) {
                return null;
            }
            return stringExtra;
        }
        return (String) invokeV.objValue;
    }

    public final void u(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.p = System.currentTimeMillis();
            }
            View findViewById = view.findViewById(c.a.s0.l4.f.youngster_layout);
            this.f50566e = findViewById;
            findViewById.setOnTouchListener(new a(this));
            this.f50567f = (VideoChannelViewPager) view.findViewById(c.a.s0.l4.f.main_view_pager);
            this.mainHeaderLayout = (VideoChannelHeaderLayout) view.findViewById(c.a.s0.l4.f.main_header_layout);
            ImageView imageView = (ImageView) view.findViewById(c.a.s0.l4.f.ala_entrance);
            this.mAlaEntranceBtn = imageView;
            this.mainHeaderLayout.setmAlaEntranceBtn(imageView);
            this.mAlaEntranceBtn.setOnClickListener(new b(this));
            ImageView imageView2 = (ImageView) view.findViewById(c.a.s0.l4.f.back_entrance);
            this.mBackBtn = imageView2;
            imageView2.setOnClickListener(new c(this));
            ViewGroup viewGroup = (ViewGroup) view.findViewById(c.a.s0.l4.f.task_float_view);
            this.mTaskFloatingView = viewGroup;
            ((RelativeLayout.LayoutParams) viewGroup.getLayoutParams()).topMargin = c.a.r0.a.e0.c.f11950c + UtilHelper.getStatusBarHeight();
            v();
            x();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.f50568g == null) {
                this.f50568g = new FragmentAdapter(getChildFragmentManager(), this.f50569h);
            }
            this.f50567f.setAdapter(this.f50568g);
            this.mainHeaderLayout.setupWithViewPager(this.f50567f);
            this.mainHeaderLayout.setOnAchieveRefresh(new d(this));
            this.f50567f.addOnPageChangeListener(new e(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.f50567f.setCurrentItem(0);
            } else {
                this.f50567f.setCurrentItem(1);
            }
            if (getArguments() != null) {
                getArguments().getString("from");
                isShowComment = TbSingleton.getInstance().getIsNeedShowPbCommentFloat();
                this.r = getArguments().getString("key_nid");
                this.n = getArguments().getString("page_from");
                this.m = getArguments().getString("from");
                this.o = getArguments().getString("source_from");
                this.q = getArguments().getBoolean("is_from_bjh_pb", false);
            }
            if (getCurrentType() == 1) {
                this.mBackBtn.setVisibility(8);
                this.f50567f.setScrollEnabled(true);
            } else {
                this.mBackBtn.setVisibility(0);
                this.f50567f.setScrollEnabled(false);
            }
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                c.a.s0.l4.k.a(this.r);
            }
        }
    }

    public final void w(String str) {
        VideoChannelHeaderLayout videoChannelHeaderLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || (videoChannelHeaderLayout = this.mainHeaderLayout) == null) {
            return;
        }
        videoChannelHeaderLayout.refreshAttentionRedTip(str);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            boolean d2 = c.a.r0.g1.b.c.d();
            View view = this.f50566e;
            boolean z = false;
            if (view != null) {
                view.setVisibility(d2 ? 0 : 8);
            }
            FragmentAdapter fragmentAdapter = this.f50568g;
            if (fragmentAdapter != null) {
                fragmentAdapter.setPrimary(!d2 && isPrimary());
                if (UtilHelper.isFlyMeOs() || !d2) {
                    return;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                UtilHelper.changeStatusBarIconAndTextColor((isPrimary() || skinType == 4 || skinType == 1) ? true : true, getActivity());
            }
        }
    }
}
