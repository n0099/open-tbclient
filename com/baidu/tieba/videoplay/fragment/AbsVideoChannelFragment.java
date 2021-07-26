package com.baidu.tieba.videoplay.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.R;
import com.baidu.tieba.videoplay.model.JumpYYLiveHttpResponseMessage;
import com.baidu.tieba.videoplay.model.JumpYYLiveRequestHttpMessage;
import com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout;
import com.baidu.tieba.videoplay.view.VideoChannelViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes4.dex */
public abstract class AbsVideoChannelFragment extends BaseFragment implements d.a.q0.x3.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f22037e;

    /* renamed from: f  reason: collision with root package name */
    public View f22038f;

    /* renamed from: g  reason: collision with root package name */
    public VideoChannelViewPager f22039g;

    /* renamed from: h  reason: collision with root package name */
    public VideoChannelHeaderLayout f22040h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f22041i;
    public FragmentAdapter j;
    public List<d.a.p0.g0.c> k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public final CustomMessageListener r;
    public final CustomMessageListener s;
    public CustomMessageListener t;
    public HttpMessageListener u;
    public CustomMessageListener v;

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d.a.p0.g0.c> f22042a;

        /* renamed from: b  reason: collision with root package name */
        public int f22043b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22044c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<d.a.p0.g0.c> list) {
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
            this.f22043b = -1;
            this.f22042a = list;
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f22044c = z;
                int i2 = this.f22043b;
                if (i2 != -1 && (getItem(i2) instanceof BaseFragment)) {
                    ((BaseFragment) getItem(this.f22043b)).setPrimary(z);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<d.a.p0.g0.c> list = this.f22042a;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f22042a.get(i2).f52618a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f22042a.get(i2).f52620c : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                int i3 = this.f22043b;
                if (i3 != i2) {
                    if (i3 != -1 && (getItem(i3) instanceof BaseFragment)) {
                        ((BaseFragment) getItem(this.f22043b)).setPrimary(false);
                    }
                    this.f22043b = i2;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(this.f22044c);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements VideoChannelHeaderLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22045a;

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
            this.f22045a = absVideoChannelFragment;
        }

        @Override // com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsVideoChannelFragment absVideoChannelFragment = this.f22045a;
                if (absVideoChannelFragment.f22040h == null || absVideoChannelFragment.f22039g == null || ListUtils.getItem(this.f22045a.k, this.f22045a.f22039g.getCurrentItem()) == null || !(((d.a.p0.g0.c) ListUtils.getItem(this.f22045a.k, this.f22045a.f22039g.getCurrentItem())).f52618a instanceof BaseFragment)) {
                    return;
                }
                AbsVideoChannelFragment absVideoChannelFragment2 = this.f22045a;
                absVideoChannelFragment2.f22040h.f(((BaseFragment) ((d.a.p0.g0.c) ListUtils.getItem(absVideoChannelFragment2.k, this.f22045a.f22039g.getCurrentItem())).f52618a).getUniqueId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22046e;

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
            this.f22046e = absVideoChannelFragment;
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
                this.f22046e.n = i2;
                this.f22046e.f22040h.setPageSelected(i2);
                if (i2 == 0) {
                    this.f22046e.m = 2;
                } else if (i2 == 1) {
                    this.f22046e.m = 1;
                }
                if (i2 == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) ((d.a.p0.g0.c) this.f22046e.k.get(1)).f52618a;
                    videoVerticalPageFragment.Z0(null);
                    this.f22046e.f22039g.setListener(videoVerticalPageFragment.X0());
                    return;
                }
                this.f22046e.f22039g.setListener(null);
                if (this.f22046e.l || this.f22046e.f22039g == null || ListUtils.getItem(this.f22046e.k, this.f22046e.f22039g.getCurrentItem()) == null || !(((d.a.p0.g0.c) ListUtils.getItem(this.f22046e.k, this.f22046e.f22039g.getCurrentItem())).f52618a instanceof BaseFragment)) {
                    return;
                }
                this.f22046e.l = true;
                AbsVideoChannelFragment absVideoChannelFragment = this.f22046e;
                absVideoChannelFragment.f22040h.f(((BaseFragment) ((d.a.p0.g0.c) ListUtils.getItem(absVideoChannelFragment.k, i2)).f52618a).getUniqueId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22047a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
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
            this.f22047a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f22047a.f22040h.k(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22048a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
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
            this.f22048a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f22048a.f22040h.l(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22049a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbsVideoChannelFragment absVideoChannelFragment, int i2) {
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
            this.f22049a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!d.a.d.e.p.j.z()) {
                l.J(this.f22049a.getContext(), this.f22049a.getResources().getString(R.string.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    if (this.f22049a.f22039g.getCurrentItem() == 0) {
                        this.f22049a.f22039g.setCurrentItem(1, false);
                        this.f22049a.f22040h.setPageSelected(1);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (booleanValue || this.f22049a.f22039g == null || ListUtils.getItem(this.f22049a.k, this.f22049a.f22039g.getCurrentItem()) == null || !(((d.a.p0.g0.c) ListUtils.getItem(this.f22049a.k, this.f22049a.f22039g.getCurrentItem())).f52618a instanceof BaseFragment)) {
                } else {
                    AbsVideoChannelFragment absVideoChannelFragment = this.f22049a;
                    absVideoChannelFragment.f22040h.f(((BaseFragment) ((d.a.p0.g0.c) ListUtils.getItem(absVideoChannelFragment.k, this.f22049a.f22039g.getCurrentItem())).f52618a).getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22050a;

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
            this.f22050a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f22050a.c1((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22051a;

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
            this.f22051a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f22051a.e1();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22052a;

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
            this.f22052a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f22052a.o = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (httpResponsedMessage instanceof JumpYYLiveHttpResponseMessage) {
                        YyExtData yyExtData = ((JumpYYLiveHttpResponseMessage) httpResponsedMessage).getYyExtData();
                        if (yyExtData == null) {
                            ToastUtil.show("服务器加载中，请稍候再试");
                            return;
                        } else {
                            YYLiveUtil.jumpToYYLiveRoom(this.f22052a.getPageContext(), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "");
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
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22053a;

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
            this.f22053a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.f22053a.f22037e.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.f22053a.f22040h.setAlpha(floatValue);
            if (this.f22053a.X0() == 1) {
                this.f22053a.f22041i.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22054e;

        public j(AbsVideoChannelFragment absVideoChannelFragment) {
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
            this.f22054e = absVideoChannelFragment;
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

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f22055e;

        public k(AbsVideoChannelFragment absVideoChannelFragment) {
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
            this.f22055e = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22055e.o) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK));
            MessageManager.getInstance().sendMessage(new JumpYYLiveRequestHttpMessage());
            this.f22055e.o = true;
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
        this.l = false;
        this.m = 1;
        this.n = 0;
        this.o = false;
        this.p = new c(this, 2921576);
        this.q = new d(this, 2921575);
        this.r = new e(this, 2921580);
        this.s = new f(this, 2921578);
        this.t = new g(this, 2921509);
        this.u = new h(this, CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
        this.v = new i(this, 2921594);
    }

    @Override // d.a.q0.x3.f.a
    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.q0.x3.f.a W0 = W0();
            if (W0 != null) {
                return W0.E0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final d.a.q0.x3.f.a W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FragmentAdapter fragmentAdapter = this.j;
            if (fragmentAdapter == null || fragmentAdapter.f22043b == -1) {
                return null;
            }
            Fragment item = this.j.getItem(this.j.f22043b);
            if (item instanceof d.a.q0.x3.f.a) {
                return (d.a.q0.x3.f.a) item;
            }
            return null;
        }
        return (d.a.q0.x3.f.a) invokeV.objValue;
    }

    public abstract int X0();

    public abstract Fragment Y0();

    @Override // d.a.q0.x3.f.a
    public void Z() {
        d.a.q0.x3.f.a W0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (W0 = W0()) == null) {
            return;
        }
        W0.Z();
    }

    public abstract Fragment Z0();

    public final void a1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            View findViewById = view.findViewById(R.id.youngster_layout);
            this.f22038f = findViewById;
            findViewById.setOnTouchListener(new j(this));
            this.f22039g = (VideoChannelViewPager) view.findViewById(R.id.main_view_pager);
            this.f22040h = (VideoChannelHeaderLayout) view.findViewById(R.id.main_header_layout);
            ImageView imageView = (ImageView) view.findViewById(R.id.ala_entrance);
            this.f22041i = imageView;
            imageView.setOnClickListener(new k(this));
            b1();
            e1();
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), this.k);
            this.j = fragmentAdapter;
            this.f22039g.setAdapter(fragmentAdapter);
            this.f22040h.setupWithViewPager(this.f22039g);
            this.f22040h.setOnAchieveRefresh(new a(this));
            this.f22039g.addOnPageChangeListener(new b(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.f22039g.setCurrentItem(0);
            } else {
                this.f22039g.setCurrentItem(1);
            }
            if (getArguments() != null) {
                getArguments().getString("from");
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22040h.getLayoutParams();
                if (X0() == 1) {
                    this.f22041i.setVisibility(0);
                    this.f22039g.setScrollEnabled(true);
                    return;
                }
                this.f22041i.setVisibility(8);
                this.f22039g.setScrollEnabled(false);
            }
        }
    }

    public final void c1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f22040h.n(str);
        }
    }

    @Override // d.a.q0.x3.f.a
    public long d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.q0.x3.f.a W0 = W0();
            if (W0 != null) {
                return W0.d0();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void d1(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f22037e = bdUniqueId;
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean d2 = d.a.p0.e1.b.e.d();
            View view = this.f22038f;
            boolean z = false;
            if (view != null) {
                view.setVisibility(d2 ? 0 : 8);
            }
            FragmentAdapter fragmentAdapter = this.j;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.tabType = this.m;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            WebPManager.setMaskDrawable(this.f22041i, R.drawable.icon_videotab_live40, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            this.k = new ArrayList();
            d.a.p0.g0.c cVar = new d.a.p0.g0.c();
            Fragment Y0 = Y0();
            cVar.f52618a = Y0;
            Y0.setArguments(getArguments());
            cVar.f52620c = getContext().getResources().getString(R.string.attention);
            this.k.add(cVar);
            d.a.p0.g0.c cVar2 = new d.a.p0.g0.c();
            Fragment Z0 = Z0();
            cVar2.f52618a = Z0;
            Z0.setArguments(getArguments());
            cVar2.f52620c = getContext().getResources().getString(R.string.default_personalized_name);
            this.k.add(cVar2);
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
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.video_channel_fragment, (ViewGroup) null);
            a1(inflate);
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.f22040h;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.j();
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            e1();
            if (isPrimary() && X0() == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_SHOW));
            }
        }
    }

    @Override // d.a.q0.x3.f.a
    public void r0(int i2, int i3, Intent intent) {
        d.a.q0.x3.f.a W0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) || (W0 = W0()) == null) {
            return;
        }
        W0.r0(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.setUserVisibleHint(z);
            List<d.a.p0.g0.c> list = this.k;
            if (list != null) {
                int size = list.size();
                int i2 = this.n;
                if (size <= i2 || this.k.get(i2) == null || this.k.get(this.n).f52618a == null) {
                    return;
                }
                this.k.get(this.n).f52618a.setUserVisibleHint(z);
            }
        }
    }
}
