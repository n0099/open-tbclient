package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.coreExtra.floatCardView.AlaLiveTipView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.gf5;
import com.baidu.tieba.jo5;
import com.baidu.tieba.kpa;
import com.baidu.tieba.lz5;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.model.JumpYYLiveHttpResponseMessage;
import com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout;
import com.baidu.tieba.videoplay.view.VideoChannelViewPager;
import com.baidu.tieba.yi;
import com.baidu.tieba.yv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes8.dex */
public abstract class AbsVideoChannelFragment extends BaseFragment implements kpa {
    public static /* synthetic */ Interceptable $ic;
    public static String w;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public VideoChannelViewPager b;
    public VideoChannelHeaderLayout c;
    public AlaLiveTipView d;
    public ImageView e;
    public ViewGroup f;
    public FragmentAdapter g;
    public List<jo5> h;
    public boolean i;
    public int j;
    public int k;
    public boolean l;
    public List<VideoItemData> m;
    public View n;
    public WeakReference<Context> o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final CustomMessageListener s;
    public HttpMessageListener t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    public abstract int Q1();

    public abstract Fragment S1();

    public abstract Fragment T1();

    public abstract void a2();

    /* loaded from: classes8.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<jo5> a;
        public int b;
        public boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<jo5> list) {
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

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        @NonNull
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.a.get(i).a;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return this.a.get(i).c;
            }
            return (CharSequence) invokeI.objValue;
        }

        public BaseFragment c() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<jo5> list = this.a;
                if (list != null && (i = this.b) != -1 && (list.get(i).a instanceof BaseFragment)) {
                    return (BaseFragment) this.a.get(this.b).a;
                }
                return null;
            }
            return (BaseFragment) invokeV.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<jo5> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
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

    /* loaded from: classes8.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AbsVideoChannelFragment absVideoChannelFragment;
            VideoChannelViewPager videoChannelViewPager;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.k = i;
                this.a.c.setPageSelected(i);
                if (i == 0) {
                    this.a.j = 2;
                } else if (i == 1) {
                    this.a.j = 1;
                }
                if (i == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) this.a.h.get(1).a;
                    videoVerticalPageFragment.I2(null);
                    this.a.b.setListener(videoVerticalPageFragment.b2());
                    return;
                }
                this.a.b.setListener(null);
                if (!this.a.i && (videoChannelViewPager = (absVideoChannelFragment = this.a).b) != null && ListUtils.getItem(absVideoChannelFragment.h, videoChannelViewPager.getCurrentItem()) != null) {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                    if (((jo5) ListUtils.getItem(absVideoChannelFragment2.h, absVideoChannelFragment2.b.getCurrentItem())).a instanceof BaseFragment) {
                        this.a.i = true;
                        AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                        absVideoChannelFragment3.c.f(((BaseFragment) ((jo5) ListUtils.getItem(absVideoChannelFragment3.h, i)).a).getUniqueId());
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsVideoChannelFragment absVideoChannelFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (videoChannelHeaderLayout = this.a.c) != null) {
                videoChannelHeaderLayout.l(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoChannelFragment absVideoChannelFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (videoChannelHeaderLayout = this.a.c) != null) {
                videoChannelHeaderLayout.m(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
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
            VideoChannelViewPager videoChannelViewPager;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                yi.O(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e1f));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    VideoChannelViewPager videoChannelViewPager2 = this.a.b;
                    if (videoChannelViewPager2 != null && videoChannelViewPager2.getCurrentItem() == 0) {
                        AbsVideoChannelFragment absVideoChannelFragment = this.a;
                        if (absVideoChannelFragment.c != null) {
                            absVideoChannelFragment.b.setCurrentItem(1, false);
                            this.a.c.setPageSelected(1);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (!booleanValue) {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.a;
                    if (absVideoChannelFragment2.c != null && (videoChannelViewPager = absVideoChannelFragment2.b) != null && ListUtils.getItem(absVideoChannelFragment2.h, videoChannelViewPager.getCurrentItem()) != null) {
                        AbsVideoChannelFragment absVideoChannelFragment3 = this.a;
                        if (((jo5) ListUtils.getItem(absVideoChannelFragment3.h, absVideoChannelFragment3.b.getCurrentItem())).a instanceof BaseFragment) {
                            AbsVideoChannelFragment absVideoChannelFragment4 = this.a;
                            absVideoChannelFragment4.c.f(((BaseFragment) ((jo5) ListUtils.getItem(absVideoChannelFragment4.h, absVideoChannelFragment4.b.getCurrentItem())).a).getUniqueId());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.X1((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends HttpMessageListener {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            YyExtData yyExtData;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.l = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof JumpYYLiveHttpResponseMessage) || (yyExtData = ((JumpYYLiveHttpResponseMessage) httpResponsedMessage).getYyExtData()) == null) {
                        return;
                    }
                    if (this.a.Q1() == 1) {
                        str = YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL;
                    } else {
                        str = YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE;
                    }
                    YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), yyExtData, str);
                    return;
                }
                this.a.showToast("服务器加载中，请稍候再试");
            }
        }
    }

    /* loaded from: classes8.dex */
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
            BdUniqueId tag;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.a.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue >= 0.0f && floatValue <= 1.0f) {
                this.a.c.setAlpha(floatValue);
                this.a.d.setAlpha(floatValue);
                if (i == 0) {
                    this.a.d.setVisibility(0);
                } else {
                    this.a.d.setVisibility(8);
                }
                if (this.a.Q1() == 2) {
                    this.a.e.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                boolean z = true;
                if (customResponsedMessage.getData() instanceof Boolean) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (this.a.n != null) {
                    if (z) {
                        this.a.n.setBackground(new ColorDrawable(this.a.getResources().getColor(R.color.CAM_X0611)));
                    } else {
                        this.a.n.setBackground(null);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public i(AbsVideoChannelFragment absVideoChannelFragment) {
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
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !this.a.l) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
                if (this.a.Q1() == 1) {
                    i = 1;
                } else {
                    i = 2;
                }
                statisticItem.addParam("obj_type", i);
                TiebaStatic.log(statisticItem);
                this.a.l = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoChannelFragment a;

        public j(AbsVideoChannelFragment absVideoChannelFragment) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.Q1() != 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
            }
        }
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
        this.i = false;
        this.j = 1;
        this.k = 0;
        this.l = false;
        this.o = null;
        this.p = new b(this, 2921576);
        this.q = new c(this, 2921575);
        this.r = new d(this, 2921580);
        this.s = new e(this, 2921578);
        this.t = new f(this, CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
        this.u = new g(this, 2921594);
        this.v = new h(this, 2921665);
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.h == null) {
            this.h = new ArrayList();
            jo5 jo5Var = new jo5();
            Fragment S1 = S1();
            jo5Var.a = S1;
            S1.setArguments(getArguments());
            jo5Var.c = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f02e8);
            this.h.add(jo5Var);
            jo5 jo5Var2 = new jo5();
            Fragment T1 = T1();
            jo5Var2.a = T1;
            T1.setArguments(getArguments());
            jo5Var2.c = getContext().getResources().getString(R.string.default_personalized_name);
            this.h.add(jo5Var2);
        }
    }

    public final void X1(String str) {
        VideoChannelHeaderLayout videoChannelHeaderLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (videoChannelHeaderLayout = this.c) != null) {
            videoChannelHeaderLayout.o(str);
        }
    }

    public void Y1(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void Z1(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.m = list;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            WebPManager.setPureDrawable(this.e, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            FragmentAdapter fragmentAdapter = this.g;
            if (fragmentAdapter != null && fragmentAdapter.c() != null) {
                this.g.c().onChangeSkinType(i2);
            }
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

    @Override // com.baidu.tieba.kpa
    public void L0() {
        kpa P1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (P1 = P1()) != null) {
            P1.L0();
        }
    }

    public final String R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String stringExtra = getPageContext().getPageActivity().getIntent().getStringExtra("sub_locate_type");
            if (!StringUtils.isNull(stringExtra)) {
                return stringExtra;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.tabType = this.j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kpa
    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            kpa P1 = P1();
            if (P1 != null) {
                return P1.m();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            lz5.e(this.o, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.c;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.k();
            }
            if (!UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(false, getPageContext().getPageActivity());
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tieba.kpa
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            kpa P1 = P1();
            if (P1 != null) {
                return P1.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final kpa P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FragmentAdapter fragmentAdapter = this.g;
            if (fragmentAdapter != null && fragmentAdapter.b != -1) {
                Fragment item = this.g.getItem(this.g.b);
                if (item instanceof kpa) {
                    return (kpa) item;
                }
                return null;
            }
            return null;
        }
        return (kpa) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            if (this.b != null && this.c != null && !StringUtils.isNull(R1()) && "22_recommend".equals(R1())) {
                this.b.setCurrentItem(1, false);
                this.c.setPageSelected(1);
            }
        }
    }

    public final void V1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            VideoChannelViewPager videoChannelViewPager = (VideoChannelViewPager) view2.findViewById(R.id.obfuscated_res_0x7f09169f);
            this.b = videoChannelViewPager;
            videoChannelViewPager.setBackground(null);
            this.c = (VideoChannelHeaderLayout) view2.findViewById(R.id.obfuscated_res_0x7f09168f);
            AlaLiveTipView alaLiveTipView = (AlaLiveTipView) view2.findViewById(R.id.obfuscated_res_0x7f0901ec);
            this.d = alaLiveTipView;
            alaLiveTipView.setViewLocate(3);
            AlaLiveTipView alaLiveTipView2 = this.d;
            int i2 = 1;
            if (Q1() != 1) {
                i2 = 2;
            }
            alaLiveTipView2.setShowFrom(i2);
            this.d.setNormalBottomMarginParams(yi.g(getPageContext().getPageActivity(), R.dimen.tbds10));
            gf5.g(Q1());
            this.c.setAlaEntranceBtn(this.d);
            if (!ListUtils.isEmpty(this.m)) {
                VideoItemData videoItemData = this.m.get(0);
                this.d.setForumInfo(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id);
            }
            this.d.setOnClickListener(new i(this));
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090326);
            this.e = imageView;
            imageView.setOnClickListener(new j(this));
            ViewGroup viewGroup = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f092401);
            this.f = viewGroup;
            ((RelativeLayout.LayoutParams) viewGroup.getLayoutParams()).topMargin = yv4.c + UtilHelper.getStatusBarHeight();
            W1();
            FragmentAdapter fragmentAdapter = this.g;
            if (fragmentAdapter != null) {
                fragmentAdapter.d(isPrimary());
            }
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.g == null) {
                this.g = new FragmentAdapter(getChildFragmentManager(), this.h);
            }
            this.b.setAdapter(this.g);
            this.c.setupWithViewPager(this.b);
            a2();
            this.b.addOnPageChangeListener(new a(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.b.setCurrentItem(0);
            } else {
                this.b.setCurrentItem(1);
            }
            if (getArguments() != null) {
                getArguments().getString("from");
                w = TbSingleton.getInstance().getIsNeedShowPbCommentThreadId();
                getArguments().getString("key_nid");
                getArguments().getString("page_from");
                getArguments().getString("from");
                getArguments().getString("source_from");
                getArguments().getBoolean("is_from_bjh_pb", false);
            }
            if (Q1() == 1) {
                this.e.setVisibility(8);
                this.b.setScrollEnabled(true);
                return;
            }
            this.e.setVisibility(0);
            this.b.setScrollEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            this.o = new WeakReference<>(TbadkCoreApplication.getInst());
            U1();
            registerListener(this.p);
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.s);
            registerListener(this.t);
            registerListener(this.u);
            registerListener(this.v);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            super.setUserVisibleHint(z);
            List<jo5> list = this.h;
            if (list != null) {
                int size = list.size();
                int i2 = this.k;
                if (size > i2 && this.h.get(i2) != null && this.h.get(this.k).a != null) {
                    this.h.get(this.k).a.setUserVisibleHint(z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            this.n = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09c6, (ViewGroup) null);
            if (Q1() != 1) {
                this.n.setBackground(null);
            } else {
                this.n.setBackground(new ColorDrawable(getResources().getColor(R.color.CAM_X0611)));
            }
            V1(this.n);
            return this.n;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            FragmentAdapter fragmentAdapter = this.g;
            if (fragmentAdapter != null) {
                fragmentAdapter.d(isPrimary());
            }
            if (!UtilHelper.isFlyMeOs()) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (!isPrimary() && skinType != 4) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
                }
            }
            lz5.e(this.o, isPrimary());
        }
    }

    @Override // com.baidu.tieba.kpa
    public void p(int i2, int i3, Intent intent) {
        kpa P1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048600, this, i2, i3, intent) == null) && (P1 = P1()) != null) {
            P1.p(i2, i3, intent);
        }
    }
}
