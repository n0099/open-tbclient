package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import b.a.q0.d1.s0;
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
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes9.dex */
public abstract class AbsVideoChannelFragment extends BaseFragment implements b.a.r0.b4.o.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean C = false;
    public static final int TYPE_VIDEO_CHANNEL = 1;
    public static final int TYPE_VIDEO_MIDDLE = 2;
    public static final int VIDEO_CHANNEL_PAGE_TYPE_ATTENTION = 0;
    public static final int VIDEO_CHANNEL_PAGE_TYPE_RECOMMEND = 1;
    public static boolean isShowComment;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpMessageListener A;
    public CustomMessageListener B;

    /* renamed from: e  reason: collision with root package name */
    public View f55034e;

    /* renamed from: f  reason: collision with root package name */
    public VideoChannelViewPager f55035f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentAdapter f55036g;

    /* renamed from: h  reason: collision with root package name */
    public List<b.a.q0.h0.c> f55037h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55038i;
    public int j;
    public int k;
    public boolean l;
    public String m;
    public BdUniqueId mActivityPageUniqueId;
    public ImageView mAlaEntranceBtn;
    public ImageView mBackBtn;
    public VideoChannelHeaderLayout mainHeaderLayout;
    public String n;
    public String o;
    public long p;
    public boolean q;
    public String r;
    public boolean s;
    public WeakReference<Context> t;
    public final CustomMessageListener u;
    public final CustomMessageListener v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;
    public final CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<b.a.q0.h0.c> f55039a;

        /* renamed from: b  reason: collision with root package name */
        public int f55040b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55041c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(@NonNull FragmentManager fragmentManager, List<b.a.q0.h0.c> list) {
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
            this.f55040b = -1;
            this.f55039a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<b.a.q0.h0.c> list = this.f55039a;
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f55039a.get(i2).f12612a : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f55039a.get(i2).f12614c : (CharSequence) invokeI.objValue;
        }

        public void setPrimary(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f55041c = z;
                int i2 = this.f55040b;
                if (i2 != -1 && (getItem(i2) instanceof BaseFragment)) {
                    ((BaseFragment) getItem(this.f55040b)).setPrimary(z);
                }
            }
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
                super.setPrimaryItem(viewGroup, i2, obj);
                int i3 = this.f55040b;
                if (i3 != i2) {
                    if (i3 != -1 && (getItem(i3) instanceof BaseFragment)) {
                        ((BaseFragment) getItem(this.f55040b)).setPrimary(false);
                    }
                    this.f55040b = i2;
                    if (obj instanceof BaseFragment) {
                        ((BaseFragment) obj).setPrimary(this.f55041c);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55042e;

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
            this.f55042e = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55042e.l) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_ENTRANCE_IN_VIDEO_LIST_CLICK);
            statisticItem.addParam("obj_type", this.f55042e.getCurrentType() == 1 ? 1 : 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new JumpYYLiveRequestHttpMessage());
            this.f55042e.l = true;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55043e;

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
            this.f55043e = absVideoChannelFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (TbSingleton.getInstance().isFromFeedVideoClick() && !"frs".equals(this.f55043e.o)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                } else if (this.f55043e.getCurrentType() != 1) {
                    this.f55043e.getPageContext().getPageActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements VideoChannelHeaderLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55044a;

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
            this.f55044a = absVideoChannelFragment;
        }

        @Override // com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsVideoChannelFragment absVideoChannelFragment = this.f55044a;
                if (absVideoChannelFragment.mainHeaderLayout == null || absVideoChannelFragment.f55035f == null || ListUtils.getItem(this.f55044a.f55037h, this.f55044a.f55035f.getCurrentItem()) == null || !(((b.a.q0.h0.c) ListUtils.getItem(this.f55044a.f55037h, this.f55044a.f55035f.getCurrentItem())).f12612a instanceof BaseFragment)) {
                    return;
                }
                AbsVideoChannelFragment absVideoChannelFragment2 = this.f55044a;
                absVideoChannelFragment2.mainHeaderLayout.achieveRefresh(((BaseFragment) ((b.a.q0.h0.c) ListUtils.getItem(absVideoChannelFragment2.f55037h, this.f55044a.f55035f.getCurrentItem())).f12612a).getUniqueId());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55045e;

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
            this.f55045e = absVideoChannelFragment;
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
                this.f55045e.k = i2;
                this.f55045e.mainHeaderLayout.setPageSelected(i2);
                if (i2 == 0) {
                    this.f55045e.j = 2;
                } else if (i2 == 1) {
                    this.f55045e.j = 1;
                }
                if (i2 == 1) {
                    VideoVerticalPageFragment videoVerticalPageFragment = (VideoVerticalPageFragment) ((b.a.q0.h0.c) this.f55045e.f55037h.get(1)).f12612a;
                    videoVerticalPageFragment.setVideoPlayViewEventListener(null);
                    this.f55045e.f55035f.setListener(videoVerticalPageFragment.getVEventListener());
                    return;
                }
                this.f55045e.f55035f.setListener(null);
                if (this.f55045e.f55038i || this.f55045e.f55035f == null || ListUtils.getItem(this.f55045e.f55037h, this.f55045e.f55035f.getCurrentItem()) == null || !(((b.a.q0.h0.c) ListUtils.getItem(this.f55045e.f55037h, this.f55045e.f55035f.getCurrentItem())).f12612a instanceof BaseFragment)) {
                    return;
                }
                this.f55045e.f55038i = true;
                AbsVideoChannelFragment absVideoChannelFragment = this.f55045e;
                absVideoChannelFragment.mainHeaderLayout.achieveRefresh(((BaseFragment) ((b.a.q0.h0.c) ListUtils.getItem(absVideoChannelFragment.f55037h, i2)).f12612a).getUniqueId());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55046a;

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
            this.f55046a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.f55046a.mainHeaderLayout) == null) {
                return;
            }
            videoChannelHeaderLayout.onFinish(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55047a;

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
            this.f55047a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                AbsVideoChannelFragment absVideoChannelFragment = this.f55047a;
                absVideoChannelFragment.lazyInitViewPager(absVideoChannelFragment.getView());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55048a;

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
            this.f55048a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoChannelHeaderLayout videoChannelHeaderLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (videoChannelHeaderLayout = this.f55048a.mainHeaderLayout) == null) {
                return;
            }
            videoChannelHeaderLayout.onRefresh(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55049a;

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
            this.f55049a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!b.a.e.e.p.j.z()) {
                b.a.e.e.p.l.J(this.f55049a.getContext(), this.f55049a.getResources().getString(b.a.r0.b4.i.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                RedIcon videoChannelRecommendRedIcon = TbSingleton.getInstance().getVideoChannelRecommendRedIcon();
                if (videoChannelRecommendRedIcon != null) {
                    if (this.f55049a.f55035f != null && this.f55049a.f55035f.getCurrentItem() == 0) {
                        AbsVideoChannelFragment absVideoChannelFragment = this.f55049a;
                        if (absVideoChannelFragment.mainHeaderLayout != null) {
                            absVideoChannelFragment.f55035f.setCurrentItem(1, false);
                            this.f55049a.mainHeaderLayout.setPageSelected(1);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921581, videoChannelRecommendRedIcon));
                } else if (booleanValue) {
                } else {
                    AbsVideoChannelFragment absVideoChannelFragment2 = this.f55049a;
                    if (absVideoChannelFragment2.mainHeaderLayout == null || absVideoChannelFragment2.f55035f == null || ListUtils.getItem(this.f55049a.f55037h, this.f55049a.f55035f.getCurrentItem()) == null || !(((b.a.q0.h0.c) ListUtils.getItem(this.f55049a.f55037h, this.f55049a.f55035f.getCurrentItem())).f12612a instanceof BaseFragment)) {
                        return;
                    }
                    AbsVideoChannelFragment absVideoChannelFragment3 = this.f55049a;
                    absVideoChannelFragment3.mainHeaderLayout.achieveRefresh(((BaseFragment) ((b.a.q0.h0.c) ListUtils.getItem(absVideoChannelFragment3.f55037h, this.f55049a.f55035f.getCurrentItem())).f12612a).getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55050a;

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
            this.f55050a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f55050a.o((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55051a;

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
            this.f55051a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f55051a.p();
        }
    }

    /* loaded from: classes9.dex */
    public class k extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55052a;

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
            this.f55052a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f55052a.l = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (httpResponsedMessage instanceof JumpYYLiveHttpResponseMessage) {
                        YyExtData yyExtData = ((JumpYYLiveHttpResponseMessage) httpResponsedMessage).getYyExtData();
                        if (yyExtData == null) {
                            ToastUtil.show("服务器加载中，请稍候再试");
                            return;
                        } else {
                            YYLiveUtil.jumpToYYLiveRoom(this.f55052a.getPageContext(), yyExtData, this.f55052a.getCurrentType() == 1 ? YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_CHANNEL : YYLiveUtil.SOURCE_HOMEPAGE_VIDEO_MIDDLE);
                            return;
                        }
                    }
                    return;
                }
                ToastUtil.show("服务器加载中，请稍候再试");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoChannelFragment f55053a;

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
            this.f55053a = absVideoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.f55053a.mActivityPageUniqueId.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            this.f55053a.mainHeaderLayout.setAlpha(floatValue);
            this.f55053a.mAlaEntranceBtn.setAlpha(floatValue);
            if (i2 == 0) {
                this.f55053a.mAlaEntranceBtn.setVisibility(0);
            } else {
                this.f55053a.mAlaEntranceBtn.setVisibility(8);
            }
            if (this.f55053a.getCurrentType() == 2) {
                this.f55053a.mBackBtn.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(AbsVideoChannelFragment absVideoChannelFragment) {
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
                }
            }
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
        C = !b.a.q0.b.d.C();
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
        this.f55038i = false;
        this.j = 1;
        this.k = 0;
        this.l = false;
        this.p = 0L;
        this.s = false;
        this.t = null;
        this.u = new e(this, 2921576);
        this.v = new f(this, 2921616);
        this.w = new g(this, 2921575);
        this.x = new h(this, 2921580);
        this.y = new i(this, 2921578);
        this.z = new j(this, 2921509);
        this.A = new k(this, CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST);
        this.B = new l(this, 2921594);
    }

    public abstract int getCurrentType();

    @Override // b.a.r0.b4.o.a
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.r0.b4.o.a l2 = l();
            if (l2 != null) {
                return l2.getMissionTid();
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
            tbPageTag.tabType = this.j;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public abstract Fragment getVideoAttentionFragment();

    public abstract Fragment getVideoRecommendFragment();

    @Override // b.a.r0.b4.o.a
    public void handleActivityResult(int i2, int i3, Intent intent) {
        b.a.r0.b4.o.a l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) || (l2 = l()) == null) {
            return;
        }
        l2.handleActivityResult(i2, i3, intent);
    }

    @Override // b.a.r0.b4.o.a
    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.r0.b4.o.a l2 = l();
            if (l2 != null) {
                return l2.handleBackPress();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.b4.o.a
    public void handleIndexMessage() {
        b.a.r0.b4.o.a l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (l2 = l()) == null) {
            return;
        }
        l2.handleIndexMessage();
    }

    public final b.a.r0.b4.o.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FragmentAdapter fragmentAdapter = this.f55036g;
            if (fragmentAdapter == null || fragmentAdapter.f55040b == -1) {
                return null;
            }
            Fragment item = this.f55036g.getItem(this.f55036g.f55040b);
            if (item instanceof b.a.r0.b4.o.a) {
                return (b.a.r0.b4.o.a) item;
            }
            return null;
        }
        return (b.a.r0.b4.o.a) invokeV.objValue;
    }

    public void lazyInitViewPager(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || view == null || this.s) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(b.a.r0.b4.f.main_view_pager_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        m(view);
        this.s = true;
    }

    public final void m(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.p = System.currentTimeMillis();
            }
            View findViewById = view.findViewById(b.a.r0.b4.f.youngster_layout);
            this.f55034e = findViewById;
            findViewById.setOnTouchListener(new m(this));
            this.f55035f = (VideoChannelViewPager) view.findViewById(b.a.r0.b4.f.main_view_pager);
            this.mainHeaderLayout = (VideoChannelHeaderLayout) view.findViewById(b.a.r0.b4.f.main_header_layout);
            ImageView imageView = (ImageView) view.findViewById(b.a.r0.b4.f.ala_entrance);
            this.mAlaEntranceBtn = imageView;
            this.mainHeaderLayout.setmAlaEntranceBtn(imageView);
            this.mAlaEntranceBtn.setOnClickListener(new a(this));
            ImageView imageView2 = (ImageView) view.findViewById(b.a.r0.b4.f.back_entrance);
            this.mBackBtn = imageView2;
            imageView2.setOnClickListener(new b(this));
            n();
            p();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f55036g == null) {
                this.f55036g = new FragmentAdapter(getChildFragmentManager(), this.f55037h);
            }
            this.f55035f.setAdapter(this.f55036g);
            this.mainHeaderLayout.setupWithViewPager(this.f55035f);
            this.mainHeaderLayout.setOnAchieveRefresh(new c(this));
            this.f55035f.addOnPageChangeListener(new d(this));
            if (TbSingleton.loginFrom == 1) {
                TbSingleton.loginFrom = -1;
                this.f55035f.setCurrentItem(0);
            } else {
                this.f55035f.setCurrentItem(1);
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
                this.f55035f.setScrollEnabled(true);
            } else {
                this.mBackBtn.setVisibility(0);
                this.f55035f.setScrollEnabled(false);
            }
            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                b.a.r0.b4.k.a(this.r);
            }
        }
    }

    public final void o(String str) {
        VideoChannelHeaderLayout videoChannelHeaderLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (videoChannelHeaderLayout = this.mainHeaderLayout) == null) {
            return;
        }
        videoChannelHeaderLayout.refreshAttentionRedTip(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            WebPManager.setMaskDrawable(this.mAlaEntranceBtn, b.a.r0.b4.e.icon_videotab_live40, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.mBackBtn, b.a.r0.b4.e.icon_pure_topbar_return40, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            this.p = System.currentTimeMillis();
            this.t = new WeakReference<>(TbadkCoreApplication.getInst());
            this.f55037h = new ArrayList();
            b.a.q0.h0.c cVar = new b.a.q0.h0.c();
            Fragment videoAttentionFragment = getVideoAttentionFragment();
            cVar.f12612a = videoAttentionFragment;
            videoAttentionFragment.setArguments(getArguments());
            cVar.f12614c = getContext().getResources().getString(b.a.r0.b4.i.attention);
            this.f55037h.add(cVar);
            b.a.q0.h0.c cVar2 = new b.a.q0.h0.c();
            Fragment videoRecommendFragment = getVideoRecommendFragment();
            cVar2.f12612a = videoRecommendFragment;
            videoRecommendFragment.setArguments(getArguments());
            cVar2.f12614c = getContext().getResources().getString(b.a.r0.b4.i.default_personalized_name);
            this.f55037h.add(cVar2);
            registerListener(this.u);
            registerListener(this.v);
            registerListener(this.w);
            registerListener(this.x);
            registerListener(this.y);
            registerListener(this.z);
            registerListener(this.A);
            registerListener(this.B);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.r0.b4.g.video_channel_fragment, (ViewGroup) null);
            if (!C) {
                lazyInitViewPager(inflate);
            } else {
                C = false;
                if (b.a.q0.a.d.y().D()) {
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
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            s0.f(this.t, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            VideoChannelHeaderLayout videoChannelHeaderLayout = this.mainHeaderLayout;
            if (videoChannelHeaderLayout != null) {
                videoChannelHeaderLayout.onDestroy();
            }
            if (this.p != 0 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                b.a.r0.b4.k.b(this.r, this.q, this.p, this.n, this.o, this.m);
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
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            p();
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
            s0.f(this.t, isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            if (getPageContext().getPageActivity() == null || getPageContext().getPageActivity().getIntent() == null || (intent = getPageContext().getPageActivity().getIntent()) == null || intent.getExtras() == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("sub_locate_type");
            if (this.f55035f == null || this.mainHeaderLayout == null || TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.f55035f.setCurrentItem(1, false);
            this.mainHeaderLayout.setPageSelected(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onViewStateRestored(bundle);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean d2 = b.a.q0.g1.b.c.d();
            View view = this.f55034e;
            boolean z = false;
            if (view != null) {
                view.setVisibility(d2 ? 0 : 8);
            }
            FragmentAdapter fragmentAdapter = this.f55036g;
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

    public void setActivityPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            this.mActivityPageUniqueId = bdUniqueId;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z) {
                lazyInitViewPager(getView());
            }
            List<b.a.q0.h0.c> list = this.f55037h;
            if (list != null) {
                int size = list.size();
                int i2 = this.k;
                if (size <= i2 || this.f55037h.get(i2) == null || this.f55037h.get(this.k).f12612a == null) {
                    return;
                }
                this.f55037h.get(this.k).f12612a.setUserVisibleHint(z);
            }
        }
    }
}
