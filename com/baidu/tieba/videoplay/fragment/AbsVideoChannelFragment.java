package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import c.a.o0.c1.t0;
import c.a.p0.p4.g.n;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.R;
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
/* loaded from: classes6.dex */
public abstract class AbsVideoChannelFragment extends BaseFragment implements n {
    public static /* synthetic */ Interceptable $ic;
    public static boolean F;
    public static boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public final CustomMessageListener B;
    public HttpMessageListener C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public VideoChannelViewPager f36691b;

    /* renamed from: c  reason: collision with root package name */
    public VideoChannelHeaderLayout f36692c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36693d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f36694e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f36695f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentAdapter f36696g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.a.o0.h0.c> f36697h;
    public boolean i;
    public int j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public long p;
    public boolean q;
    public String r;
    public View s;
    public boolean t;
    public WeakReference<Context> u;
    public boolean v;
    public boolean w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public final CustomMessageListener z;

    /* loaded from: classes6.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c.a.o0.h0.c> a;

        /* renamed from: b  reason: collision with root package name */
        public int f36698b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36699c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<c.a.o0.h0.c> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36698b = -1;
            this.a = list;
        }

        public BaseFragment c() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<c.a.o0.h0.c> list = this.a;
                if (list == null || (i = this.f36698b) == -1 || !(list.get(i).a instanceof BaseFragment)) {
                    return null;
                }
                return (BaseFragment) this.a.get(this.f36698b).a;
            }
            return (BaseFragment) invokeV.objValue;
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f36699c = z;
                int i = this.f36698b;
                if (i != -1 && (getItem(i) instanceof BaseFragment)) {
                    ((BaseFragment) getItem(this.f36698b)).setPrimary(z);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<c.a.o0.h0.c> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        @NonNull
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.a.get(i).a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.a.get(i).f10297c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                int i2 = this.f36698b;
                if (i2 != i) {
                    if (i2 != -1 && (getItem(i2) instanceof BaseFragment)) {
                        ((BaseFragment) getItem(this.f36698b)).setPrimary(false);
                    }
                    this.f36698b = i;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(this.f36699c);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public a(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.l) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
            statisticItem.addParam("obj_type", this.a.P0() == 1 ? 1 : 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new JumpYYLiveRequestHttpMessage());
            this.a.l = true;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public b(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TbSingleton.getInstance().isFromFeedVideoClick() && !"frs".equals(this.a.o)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                } else if (this.a.P0() != 1) {
                    if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                    } else {
                        this.a.getPageContext().getPageActivity().finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public c(AbsVideoChannelFragment absVideoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoChannelFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AbsVideoChannelFragment absVideoChannelFragment;
            VideoChannelViewPager videoChannelViewPager;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.k = i;
                this.a.f36692c.setPageSelected(i);
                if (i == 0) {
                    this.a.j = 2;
                } else if (i == 1) {
                    this.a.j = 1;
                }
                if (i == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) this.a.f36697h.get(1).a;
                    videoVerticalPageFragment.A1(null);
                    this.a.f36691b.setListener(videoVerticalPageFragment.U0());
                    return;
                }
                this.a.f36691b.setListener(null);
                if (this.a.i || (videoChannelViewPager = (absVideoChannelFragment = this.a).f36691b) == null || ListUtils.getItem(absVideoChannelFragment.f36697h, videoChannelViewPager.getCurrentItem()) == null) {
                    return;
                }
                AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                if (((c.a.o0.h0.c) ListUtils.getItem(absVideoChannelFragment2.f36697h, absVideoChannelFragment2.f36691b.getCurrentItem())).a instanceof BaseFragment) {
                    this.a.i = true;
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                    absVideoChannelFragment3.f36692c.f(((BaseFragment) ((c.a.o0.h0.c) ListUtils.getItem(absVideoChannelFragment3.f36697h, i)).a).getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.a.f36692c) == null) {
                return;
            }
            videoChannelHeaderLayout.l(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                AbsVideoChannelFragment absVideoChannelFragment = this.a;
                absVideoChannelFragment.V0(absVideoChannelFragment.getView());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.a.f36692c) == null) {
                return;
            }
            videoChannelHeaderLayout.m(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelViewPager videoChannelViewPager;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.K(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    VideoChannelViewPager videoChannelViewPager2 = this.a.f36691b;
                    if (videoChannelViewPager2 != null && videoChannelViewPager2.getCurrentItem() == 0) {
                        AbsVideoChannelFragment absVideoChannelFragment = this.a;
                        if (absVideoChannelFragment.f36692c != null) {
                            absVideoChannelFragment.f36691b.setCurrentItem(1, false);
                            this.a.f36692c.setPageSelected(1);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (booleanValue) {
                } else {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                    if (absVideoChannelFragment2.f36692c == null || (videoChannelViewPager = absVideoChannelFragment2.f36691b) == null || ListUtils.getItem(absVideoChannelFragment2.f36697h, videoChannelViewPager.getCurrentItem()) == null) {
                        return;
                    }
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                    if (((c.a.o0.h0.c) ListUtils.getItem(absVideoChannelFragment3.f36697h, absVideoChannelFragment3.f36691b.getCurrentItem())).a instanceof BaseFragment) {
                        AbsVideoChannelFragment absVideoChannelFragment4 = this.a;
                        absVideoChannelFragment4.f36692c.f(((BaseFragment) ((c.a.o0.h0.c) ListUtils.getItem(absVideoChannelFragment4.f36697h, absVideoChannelFragment4.f36691b.getCurrentItem())).a).getUniqueId());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.X0((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
                            YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), yyExtData, this.a.P0() == 1 ? YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL : YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE);
                            return;
                        }
                    }
                    return;
                }
                ToastUtil.show("服务器加载中，请稍候再试");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.a.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.a.f36692c.setAlpha(floatValue);
            this.a.f36693d.setAlpha(floatValue);
            if (i == 0) {
                this.a.f36693d.setVisibility(0);
            } else {
                this.a.f36693d.setVisibility(8);
            }
            if (this.a.P0() == 2) {
                this.a.f36694e.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AbsVideoChannelFragment absVideoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, Integer.valueOf(i)};
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
            this.a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && customResponsedMessage.getData() == null) {
                    return;
                }
                boolean booleanValue = customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : true;
                if (this.a.s != null) {
                    if (!booleanValue) {
                        this.a.s.setBackground(null);
                    } else {
                        this.a.s.setBackground(new ColorDrawable(this.a.getResources().getColor(R.color.CAM_X0611)));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements CyberPlayerManager.InstallListener2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f36700b;

        public l(AbsVideoChannelFragment absVideoChannelFragment, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36700b = absVideoChannelFragment;
            this.a = view;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener2
        public void onInstallInfo(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) && (obj instanceof String)) {
                if (i == 100) {
                    TbadkCoreApplication.getInst().setLibcyberffmpeg((String) obj);
                } else if (i == 101) {
                    TbadkCoreApplication.getInst().setLibssl((String) obj);
                } else if (i == 102) {
                    TbadkCoreApplication.getInst().setLibcrypto((String) obj);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            List<c.a.o0.h0.c> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                this.f36700b.v = false;
                TbadkCoreApplication.getInst().setLibcyberVersion(str);
                this.f36700b.W0(this.a);
                if (!this.f36700b.isPrimary() || (list = this.f36700b.f36697h) == null || list.size() <= this.f36700b.k) {
                    return;
                }
                AbsVideoChannelFragment absVideoChannelFragment = this.f36700b;
                if (absVideoChannelFragment.f36697h.get(absVideoChannelFragment.k) != null) {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.f36700b;
                    if (absVideoChannelFragment2.f36697h.get(absVideoChannelFragment2.k).a != null) {
                        AbsVideoChannelFragment absVideoChannelFragment3 = this.f36700b;
                        absVideoChannelFragment3.f36697h.get(absVideoChannelFragment3.k).a.setUserVisibleHint(this.f36700b.w);
                    }
                }
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
        G = !UbsABTestHelper.isLaunchUpA();
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
        this.i = false;
        this.j = 1;
        this.k = 0;
        this.l = false;
        this.p = 0L;
        this.t = false;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = new d(this, 2921576);
        this.y = new e(this, 2921616);
        this.z = new f(this, 2921575);
        this.A = new g(this, 2921580);
        this.B = new h(this, 2921578);
        this.C = new i(this, CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
        this.D = new j(this, 2921594);
        this.E = new k(this, 2921665);
    }

    public final n O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentAdapter fragmentAdapter = this.f36696g;
            if (fragmentAdapter == null || fragmentAdapter.f36698b == -1) {
                return null;
            }
            Fragment item = this.f36696g.getItem(this.f36696g.f36698b);
            if (item instanceof n) {
                return (n) item;
            }
            return null;
        }
        return (n) invokeV.objValue;
    }

    public abstract int P0();

    public final String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String stringExtra = getPageContext().getPageActivity().getIntent().getStringExtra("sub_locate_type");
            if (StringUtils.isNull(stringExtra)) {
                return null;
            }
            return stringExtra;
        }
        return (String) invokeV.objValue;
    }

    public abstract Fragment R0();

    public abstract Fragment S0();

    @Override // c.a.p0.p4.g.n
    public void T() {
        n O0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (O0 = O0()) == null) {
            return;
        }
        O0.T();
    }

    public final void T0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.p = System.currentTimeMillis();
            }
            this.f36691b = (VideoChannelViewPager) view.findViewById(R.id.obfuscated_res_0x7f091381);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.f36691b.setBackground(null);
            }
            this.f36692c = (VideoChannelHeaderLayout) view.findViewById(R.id.obfuscated_res_0x7f091373);
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0901d8);
            this.f36693d = imageView;
            this.f36692c.setmAlaEntranceBtn(imageView);
            this.f36693d.setOnClickListener(new a(this));
            ImageView imageView2 = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0902f3);
            this.f36694e = imageView2;
            imageView2.setOnClickListener(new b(this));
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f091ef3);
            this.f36695f = viewGroup;
            ((RelativeLayout.LayoutParams) viewGroup.getLayoutParams()).topMargin = c.a.o0.a.f0.c.f9666c + UtilHelper.getStatusBarHeight();
            U0();
            FragmentAdapter fragmentAdapter = this.f36696g;
            if (fragmentAdapter != null) {
                fragmentAdapter.d(isPrimary());
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f36696g == null) {
                this.f36696g = new FragmentAdapter(getChildFragmentManager(), this.f36697h);
            }
            this.f36691b.setAdapter(this.f36696g);
            this.f36692c.setupWithViewPager(this.f36691b);
            Z0();
            this.f36691b.addOnPageChangeListener(new c(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.f36691b.setCurrentItem(0);
            } else {
                this.f36691b.setCurrentItem(1);
            }
            if (getArguments() != null) {
                getArguments().getString("from");
                F = TbSingleton.getInstance().getIsNeedShowPbCommentFloat();
                this.r = getArguments().getString("key_nid");
                this.n = getArguments().getString("page_from");
                this.m = getArguments().getString("from");
                this.o = getArguments().getString("source_from");
                this.q = getArguments().getBoolean("is_from_bjh_pb", false);
            }
            if (P0() == 1) {
                this.f36694e.setVisibility(8);
                this.f36691b.setScrollEnabled(true);
            } else {
                this.f36694e.setVisibility(0);
                this.f36691b.setScrollEnabled(false);
            }
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                c.a.p0.p4.b.a(this.r);
            }
        }
    }

    public void V0(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        if (!this.v && CyberPlayerManager.isCoreLoaded(1)) {
            W0(view);
        } else if (this.v) {
        } else {
            this.v = true;
            try {
                CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuidGalaxy2(), (String) null, 3, (Class<?>) CyberRemotePlayerService.class, (Map<String, String>) null, (CyberPlayerManager.InstallListener2) new l(this, view));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void W0(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null || this.t || getActivity() == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.obfuscated_res_0x7f091382);
        if (viewStub != null) {
            viewStub.inflate();
        }
        T0(view);
        this.t = true;
    }

    @Override // c.a.p0.p4.g.n
    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n O0 = O0();
            if (O0 != null) {
                return O0.X();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void X0(String str) {
        VideoChannelHeaderLayout videoChannelHeaderLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (videoChannelHeaderLayout = this.f36692c) == null) {
            return;
        }
        videoChannelHeaderLayout.o(str);
    }

    public void Y0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public abstract void Z0();

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.tabType = this.j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // c.a.p0.p4.g.n
    public void l0(int i2, int i3, Intent intent) {
        n O0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, intent) == null) || (O0 = O0()) == null) {
            return;
        }
        O0.l0(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            WebPManager.setMaskDrawable(this.f36693d, R.drawable.obfuscated_res_0x7f080acc, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f36694e, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            FragmentAdapter fragmentAdapter = this.f36696g;
            if (fragmentAdapter == null || fragmentAdapter.c() == null) {
                return;
            }
            this.f36696g.c().onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            this.p = System.currentTimeMillis();
            this.u = new WeakReference<>(TbadkCoreApplication.getInst());
            this.f36697h = new ArrayList();
            c.a.o0.h0.c cVar = new c.a.o0.h0.c();
            Fragment R0 = R0();
            cVar.a = R0;
            R0.setArguments(getArguments());
            cVar.f10297c = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f029b);
            this.f36697h.add(cVar);
            c.a.o0.h0.c cVar2 = new c.a.o0.h0.c();
            Fragment S0 = S0();
            cVar2.a = S0;
            S0.setArguments(getArguments());
            cVar2.f10297c = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0479);
            this.f36697h.add(cVar2);
            registerListener(this.x);
            registerListener(this.y);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.B);
            registerListener(this.C);
            registerListener(this.D);
            registerListener(this.E);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0875, (ViewGroup) null);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && P0() != 1) {
                this.s.setBackground(null);
            } else {
                this.s.setBackground(new ColorDrawable(getResources().getColor(R.color.CAM_X0611)));
            }
            if (!G) {
                V0(this.s);
            } else {
                G = false;
                if (c.a.o0.a.d.y().E() && !StringUtils.isNull(Q0()) && "22_recommend".equals(Q0())) {
                    V0(this.s);
                }
            }
            return this.s;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            t0.f(this.u, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.f36692c;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.k();
            }
            if (this.p != 0 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                c.a.p0.p4.b.b(this.r, this.q, this.p, this.n, this.o, this.m);
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPrimary();
            FragmentAdapter fragmentAdapter = this.f36696g;
            if (fragmentAdapter != null) {
                fragmentAdapter.d(isPrimary());
            }
            if (isPrimary()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("obj_type", P0() == 1 ? 1 : 2);
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
            t0.f(this.u, isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            if (this.f36691b == null || this.f36692c == null || StringUtils.isNull(Q0()) || !"22_recommend".equals(Q0())) {
                return;
            }
            this.f36691b.setCurrentItem(1, false);
            this.f36692c.setPageSelected(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onViewStateRestored(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z) {
                V0(getView());
            }
            this.w = z;
            List<c.a.o0.h0.c> list = this.f36697h;
            if (list != null) {
                int size = list.size();
                int i2 = this.k;
                if (size <= i2 || this.f36697h.get(i2) == null || this.f36697h.get(this.k).a == null) {
                    return;
                }
                this.f36697h.get(this.k).a.setUserVisibleHint(z);
            }
        }
    }

    @Override // c.a.p0.p4.g.n
    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            n O0 = O0();
            if (O0 != null) {
                return O0.v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
