package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.LazyBaseFragment;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.md5;
import com.repackage.mr8;
import com.repackage.ni;
import com.repackage.ns8;
import com.repackage.o45;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.tj4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes4.dex */
public abstract class AbsVideoChannelFragment extends LazyBaseFragment implements ns8 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean J;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public final CustomMessageListener C;
    public final CustomMessageListener D;
    public final CustomMessageListener E;
    public final CustomMessageListener F;
    public HttpMessageListener G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public BdUniqueId g;
    public VideoChannelViewPager h;
    public VideoChannelHeaderLayout i;
    public ImageView j;
    public ImageView k;
    public ViewGroup l;
    public FragmentAdapter m;
    public List<o45> n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public long v;
    public boolean w;
    public String x;
    public View y;
    public WeakReference<Context> z;

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<o45> a;
        public int b;
        public boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<o45> list) {
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
            this.b = -1;
            this.a = list;
        }

        public BaseFragment c() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<o45> list = this.a;
                if (list == null || (i = this.b) == -1 || !(list.get(i).a instanceof BaseFragment)) {
                    return null;
                }
                return (BaseFragment) this.a.get(this.b).a;
            }
            return (BaseFragment) invokeV.objValue;
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.c = z;
                int i = this.b;
                if (i != -1 && (getItem(i) instanceof BaseFragment)) {
                    ((BaseFragment) getItem(this.b)).setPrimary(z);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<o45> list = this.a;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.a.get(i).c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i, obj) == null) {
                super.setPrimaryItem(viewGroup, i, obj);
                int i2 = this.b;
                if (i2 != i) {
                    if (i2 != -1 && (getItem(i2) instanceof BaseFragment)) {
                        ((BaseFragment) getItem(this.b)).setPrimary(false);
                    }
                    this.b = i;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(this.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements CyberPlayerManager.InstallListener2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;
        public final /* synthetic */ AbsVideoChannelFragment b;

        public a(AbsVideoChannelFragment absVideoChannelFragment, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoChannelFragment, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoChannelFragment;
            this.a = nVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                this.a.a();
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                TbadkCoreApplication.getInst().setLibcyberVersion(str);
                this.a.a();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.r) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
            statisticItem.addParam("obj_type", this.a.L1() == 1 ? 1 : 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new JumpYYLiveRequestHttpMessage());
            this.a.r = true;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TbSingleton.getInstance().isFromFeedVideoClick() && !"frs".equals(this.a.u)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                } else if (this.a.L1() != 1) {
                    if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                    } else {
                        this.a.getPageContext().getPageActivity().finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ViewPager.OnPageChangeListener {
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
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AbsVideoChannelFragment absVideoChannelFragment;
            VideoChannelViewPager videoChannelViewPager;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.q = i;
                this.a.i.setPageSelected(i);
                if (i == 0) {
                    this.a.p = 2;
                } else if (i == 1) {
                    this.a.p = 1;
                }
                if (i == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) this.a.n.get(1).a;
                    videoVerticalPageFragment.q2(null);
                    this.a.h.setListener(videoVerticalPageFragment.K1());
                    return;
                }
                this.a.h.setListener(null);
                if (this.a.o || (videoChannelViewPager = (absVideoChannelFragment = this.a).h) == null || ListUtils.getItem(absVideoChannelFragment.n, videoChannelViewPager.getCurrentItem()) == null) {
                    return;
                }
                AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                if (((o45) ListUtils.getItem(absVideoChannelFragment2.n, absVideoChannelFragment2.h.getCurrentItem())).a instanceof BaseFragment) {
                    this.a.o = true;
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                    absVideoChannelFragment3.i.f(((BaseFragment) ((o45) ListUtils.getItem(absVideoChannelFragment3.n, i)).a).getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.a.i) == null) {
                return;
            }
            videoChannelHeaderLayout.l(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.a.i) == null) {
                return;
            }
            videoChannelHeaderLayout.m(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes4.dex */
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
            if (!ni.z()) {
                pi.L(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c37));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    VideoChannelViewPager videoChannelViewPager2 = this.a.h;
                    if (videoChannelViewPager2 != null && videoChannelViewPager2.getCurrentItem() == 0) {
                        AbsVideoChannelFragment absVideoChannelFragment = this.a;
                        if (absVideoChannelFragment.i != null) {
                            absVideoChannelFragment.h.setCurrentItem(1, false);
                            this.a.i.setPageSelected(1);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (booleanValue) {
                } else {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                    if (absVideoChannelFragment2.i == null || (videoChannelViewPager = absVideoChannelFragment2.h) == null || ListUtils.getItem(absVideoChannelFragment2.n, videoChannelViewPager.getCurrentItem()) == null) {
                        return;
                    }
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                    if (((o45) ListUtils.getItem(absVideoChannelFragment3.n, absVideoChannelFragment3.h.getCurrentItem())).a instanceof BaseFragment) {
                        AbsVideoChannelFragment absVideoChannelFragment4 = this.a;
                        absVideoChannelFragment4.i.f(((BaseFragment) ((o45) ListUtils.getItem(absVideoChannelFragment4.n, absVideoChannelFragment4.h.getCurrentItem())).a).getUniqueId());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.S1((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.r = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (httpResponsedMessage instanceof JumpYYLiveHttpResponseMessage) {
                        YyExtData yyExtData = ((JumpYYLiveHttpResponseMessage) httpResponsedMessage).getYyExtData();
                        if (yyExtData == null) {
                            ToastUtil.show("服务器加载中，请稍候再试");
                            return;
                        } else {
                            YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), yyExtData, this.a.L1() == 1 ? YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL : YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE);
                            return;
                        }
                    }
                    return;
                }
                ToastUtil.show("服务器加载中，请稍候再试");
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.g.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.a.i.setAlpha(floatValue);
            this.a.j.setAlpha(floatValue);
            if (i == 0) {
                this.a.j.setVisibility(0);
            } else {
                this.a.j.setVisibility(8);
            }
            if (this.a.L1() == 2) {
                this.a.k.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.y != null) {
                    if (!booleanValue) {
                        this.a.y.setBackground(null);
                    } else {
                        this.a.y.setBackground(new ColorDrawable(this.a.getResources().getColor(R.color.CAM_X0611)));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public l(AbsVideoChannelFragment absVideoChannelFragment) {
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

        @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment.n
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.getContext() == null) {
                return;
            }
            View inflate = this.a.d.inflate();
            AbsVideoChannelFragment absVideoChannelFragment = this.a;
            absVideoChannelFragment.u1(inflate, absVideoChannelFragment.e);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public m(AbsVideoChannelFragment absVideoChannelFragment) {
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

        @Override // java.lang.Runnable
        public void run() {
            List<o45> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || !this.a.isPrimary() || (list = this.a.n) == null || list.size() <= this.a.q) {
                return;
            }
            AbsVideoChannelFragment absVideoChannelFragment = this.a;
            if (absVideoChannelFragment.n.get(absVideoChannelFragment.q) != null) {
                AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                if (absVideoChannelFragment2.n.get(absVideoChannelFragment2.q).a != null) {
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                    absVideoChannelFragment3.n.get(absVideoChannelFragment3.q).a.setUserVisibleHint(this.a.B);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a();
    }

    public AbsVideoChannelFragment() {
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
        this.o = false;
        this.p = 1;
        this.q = 0;
        this.r = false;
        this.v = 0L;
        this.z = null;
        this.A = false;
        this.B = false;
        this.C = new e(this, 2921576);
        this.D = new f(this, 2921575);
        this.E = new g(this, 2921580);
        this.F = new h(this, 2921578);
        this.G = new i(this, CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
        this.H = new j(this, 2921594);
        this.I = new k(this, 2921665);
    }

    @Override // com.repackage.ns8
    public long F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ns8 K1 = K1();
            if (K1 != null) {
                return K1.F0();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void J1(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) {
            if (CyberPlayerManager.isCoreLoaded(1)) {
                nVar.a();
            } else if (this.A) {
            } else {
                this.A = true;
                try {
                    CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuidGalaxy2(), (String) null, 3, (Class<?>) CyberRemotePlayerService.class, (Map<String, String>) null, (CyberPlayerManager.InstallListener2) new a(this, nVar));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final ns8 K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FragmentAdapter fragmentAdapter = this.m;
            if (fragmentAdapter == null || fragmentAdapter.b == -1) {
                return null;
            }
            Fragment item = this.m.getItem(this.m.b);
            if (item instanceof ns8) {
                return (ns8) item;
            }
            return null;
        }
        return (ns8) invokeV.objValue;
    }

    public abstract int L1();

    public final String M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String stringExtra = getPageContext().getPageActivity().getIntent().getStringExtra("sub_locate_type");
            if (StringUtils.isNull(stringExtra)) {
                return null;
            }
            return stringExtra;
        }
        return (String) invokeV.objValue;
    }

    public abstract Fragment N1();

    public abstract Fragment O1();

    public final void P1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.n == null) {
            this.n = new ArrayList();
            o45 o45Var = new o45();
            Fragment N1 = N1();
            o45Var.a = N1;
            N1.setArguments(getArguments());
            o45Var.c = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f02a4);
            this.n.add(o45Var);
            o45 o45Var2 = new o45();
            Fragment O1 = O1();
            o45Var2.a = O1;
            O1.setArguments(getArguments());
            o45Var2.c = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0481);
            this.n.add(o45Var2);
        }
    }

    public final void Q1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.v = System.currentTimeMillis();
            }
            this.h = (VideoChannelViewPager) view2.findViewById(R.id.obfuscated_res_0x7f091343);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.h.setBackground(null);
            }
            this.i = (VideoChannelHeaderLayout) view2.findViewById(R.id.obfuscated_res_0x7f091335);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901d3);
            this.j = imageView;
            this.i.setmAlaEntranceBtn(imageView);
            this.j.setOnClickListener(new b(this));
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902f5);
            this.k = imageView2;
            imageView2.setOnClickListener(new c(this));
            ViewGroup viewGroup = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091ed4);
            this.l = viewGroup;
            ((RelativeLayout.LayoutParams) viewGroup.getLayoutParams()).topMargin = tj4.c + UtilHelper.getStatusBarHeight();
            R1();
            FragmentAdapter fragmentAdapter = this.m;
            if (fragmentAdapter != null) {
                fragmentAdapter.d(isPrimary());
            }
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.m == null) {
                this.m = new FragmentAdapter(getChildFragmentManager(), this.n);
            }
            this.h.setAdapter(this.m);
            this.i.setupWithViewPager(this.h);
            U1();
            this.h.addOnPageChangeListener(new d(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.h.setCurrentItem(0);
            } else {
                this.h.setCurrentItem(1);
            }
            if (getArguments() != null) {
                getArguments().getString("from");
                J = TbSingleton.getInstance().getIsNeedShowPbCommentFloat();
                this.x = getArguments().getString("key_nid");
                this.t = getArguments().getString("page_from");
                this.s = getArguments().getString("from");
                this.u = getArguments().getString("source_from");
                this.w = getArguments().getBoolean("is_from_bjh_pb", false);
            }
            if (L1() == 1) {
                this.k.setVisibility(8);
                this.h.setScrollEnabled(true);
            } else {
                this.k.setVisibility(0);
                this.h.setScrollEnabled(false);
            }
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                mr8.a(this.x);
            }
        }
    }

    public final void S1(String str) {
        VideoChannelHeaderLayout videoChannelHeaderLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (videoChannelHeaderLayout = this.i) == null) {
            return;
        }
        videoChannelHeaderLayout.o(str);
    }

    public void T1(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.g = bdUniqueId;
        }
    }

    public abstract void U1();

    @Override // com.repackage.ns8
    public void X0(int i2, int i3, Intent intent) {
        ns8 K1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) || (K1 = K1()) == null) {
            return;
        }
        K1.X0(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.tabType = this.p;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.repackage.ns8
    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ns8 K1 = K1();
            if (K1 != null) {
                return K1.i1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            WebPManager.setMaskDrawable(this.j, R.drawable.obfuscated_res_0x7f080ae3, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.k, R.drawable.obfuscated_res_0x7f0809d6, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            FragmentAdapter fragmentAdapter = this.m;
            if (fragmentAdapter == null || fragmentAdapter.c() == null) {
                return;
            }
            this.m.c().onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            this.v = System.currentTimeMillis();
            this.z = new WeakReference<>(TbadkCoreApplication.getInst());
            registerListener(this.C);
            registerListener(this.D);
            registerListener(this.E);
            registerListener(this.F);
            registerListener(this.G);
            registerListener(this.H);
            registerListener(this.I);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            md5.e(this.z, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.i;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.k();
            }
            if (this.v != 0 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                mr8.b(this.x, this.w, this.v, this.t, this.u, this.s);
                this.v = 0L;
            }
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(false, getPageContext().getPageActivity());
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            FragmentAdapter fragmentAdapter = this.m;
            if (fragmentAdapter != null) {
                fragmentAdapter.d(isPrimary());
            }
            if (isPrimary()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("obj_type", L1() == 1 ? 1 : 2);
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
            md5.e(this.z, isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            if (this.h == null || this.i == null || StringUtils.isNull(M1()) || !"22_recommend".equals(M1())) {
                return;
            }
            this.h.setCurrentItem(1, false);
            this.i.setPageSelected(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onViewStateRestored(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public int s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? R.layout.obfuscated_res_0x7f0d0856 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.setUserVisibleHint(z);
            this.B = z;
            List<o45> list = this.n;
            if (list != null) {
                int size = list.size();
                int i2 = this.q;
                if (size <= i2 || this.n.get(i2) == null || this.n.get(this.q).a == null) {
                    return;
                }
                this.n.get(this.q).a.setUserVisibleHint(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public synchronized void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this) {
                if (!this.b && this.d != null) {
                    this.b = true;
                    J1(new l(this));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public void u1(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, view2, bundle) == null) {
            this.y = view2;
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && L1() != 1) {
                this.y.setBackground(null);
            } else {
                this.y.setBackground(new ColorDrawable(getResources().getColor(R.color.CAM_X0611)));
            }
            P1();
            Q1(this.y);
            qg.a().post(new m(this));
        }
    }

    @Override // com.repackage.ns8
    public void z0() {
        ns8 K1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (K1 = K1()) == null) {
            return;
        }
        K1.z0();
    }
}
