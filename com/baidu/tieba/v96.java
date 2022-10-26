package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.ForumSquareFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class v96 extends p9 implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFragment a;
    public LinearLayout b;
    public ForumHeaderView c;
    public NewPagerSlidingTabBaseStrip d;
    public PullLeftViewPager e;
    public EnterForumTabPagerAdapter f;
    public List g;
    public View h;
    public AlphaAnimation i;
    public AlphaAnimation j;
    public h96 k;
    public h96 l;
    public ImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public NoNetworkView r;
    public lb6 s;
    public int t;
    public int u;
    public qb v;
    public CustomMessageListener w;
    public ViewPager.OnPageChangeListener x;

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v96 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v96 v96Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v96Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v96Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().z();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().z();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.a.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0591);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v96 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v96 v96Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v96Var, Integer.valueOf(i)};
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
            this.a = v96Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.a.u();
                } else {
                    this.a.W();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v96 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public c(v96 v96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v96Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) {
                return;
            }
            this.a.O(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Fragment fragment;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.N(i);
            if (this.a.g != null && this.a.g.size() > i) {
                if (this.a.s != null) {
                    this.a.s.U();
                }
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.a.g.get(i);
                if (aVar != null && (fragment = aVar.a) != null) {
                    if (fragment instanceof EnterForumFragment) {
                        z = ((EnterForumFragment) fragment).w1();
                    } else if (fragment instanceof EnterForumTabFeedFragment) {
                        i26.b().e(false);
                        boolean t1 = ((EnterForumTabFeedFragment) aVar.a).t1();
                        TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.a).s1()));
                        z = t1;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        this.a.W();
                    } else {
                        this.a.u();
                    }
                    if (i == 0) {
                        TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
                    }
                    if (i == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v96 a;

        public d(v96 v96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v96Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(this.a.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                } else {
                    this.a.a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.a.getPageContext().getPageActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v96 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public e(v96 v96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v96Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.q.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v96(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new a(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.w = new b(this, 2001630);
        this.x = new c(this);
        this.a = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.v);
        this.a.registerListener(this.w);
        this.t = fj.f(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.u = UtilHelper.getStatusBarHeight() + fj.f(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public final void F(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.e = (PullLeftViewPager) this.h.findViewById(R.id.obfuscated_res_0x7f090911);
            EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
            aVar.a = new EnterForumFragment();
            aVar.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b6b);
            ((EnterForumFragment) aVar.a).A1(this);
            EnterForumTabPagerAdapter.a aVar2 = new EnterForumTabPagerAdapter.a();
            aVar2.a = new ForumSquareFragment();
            aVar2.b = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06d9);
            aVar2.d = "ForumSquare";
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            arrayList.add(aVar);
            this.g.add(aVar2);
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.a.getChildFragmentManager(), this.g);
            this.f = enterForumTabPagerAdapter;
            this.e.setAdapter(enterForumTabPagerAdapter);
            this.e.setOffscreenPageLimit(this.g.size());
        }
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048599, this, i) != null) || this.r == null) {
            return;
        }
        N(this.e.getCurrentItem());
        NoNetworkView noNetworkView = this.r;
        if (noNetworkView != null) {
            noNetworkView.d(getPageContext(), i);
        }
        List list = this.g;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.g.get(i2);
                if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).onChangeSkinType(i);
                }
            }
        }
        SkinManager.setBackgroundResource(this.q, R.drawable.personalize_tab_shadow);
        this.d.G();
        this.c.b();
        SkinManager.setBackgroundColorToTransparent(this.o, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        SkinManager.setBackgroundColorToTransparent(this.n, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public static String G(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    public void V(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048595, this, i, str) == null) && i >= 0 && i <= this.g.size()) {
            this.e.setCurrentItem(i, true);
            if (this.g.get(i) != null && (((EnterForumTabPagerAdapter.a) this.g.get(i)).a instanceof ForumSquareFragment)) {
                ((ForumSquareFragment) ((EnterForumTabPagerAdapter.a) this.g.get(i)).a).q1(str);
            }
        }
    }

    public String A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.g, i);
            if (aVar != null) {
                Fragment fragment = aVar.a;
                if (fragment instanceof EnterForumTabFeedFragment) {
                    return ((EnterForumTabFeedFragment) fragment).s1();
                }
                return "";
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public boolean Q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (i >= 0 && i <= this.g.size()) {
                this.e.setCurrentItem(i, true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void R(h96 h96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, h96Var) == null) {
            this.l = this.k;
            this.k = h96Var;
            this.c.setAdState(h96Var);
            N(this.e.getCurrentItem());
        }
    }

    public void S(lb6 lb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, lb6Var) == null) {
            this.s = lb6Var;
        }
    }

    public void U(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || (forumHeaderView = this.c) == null) {
            return;
        }
        forumHeaderView.setSearchHint(str);
    }

    public final void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.topMargin = this.u + i;
            this.q.setLayoutParams(layoutParams);
        }
    }

    public void t(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) && (newPagerSlidingTabBaseStrip = this.d) != null && cVar != null) {
            newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
        }
    }

    public void E(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, view2, bundle) != null) || view2 == null) {
            return;
        }
        this.h = view2;
        F(bundle);
        D(bundle);
        C(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.h.findViewById(R.id.obfuscated_res_0x7f0925af);
        this.r = noNetworkView;
        noNetworkView.a(this);
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            N(this.e.getCurrentItem());
        }
    }

    public final void v() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (view2 = this.q) == null || view2.getVisibility() == 8) {
            return;
        }
        this.q.clearAnimation();
        this.q.setVisibility(8);
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f;
            if (enterForumTabPagerAdapter != null) {
                return enterForumTabPagerAdapter.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e.getCurrentItem();
        }
        return invokeV.intValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return getPageContext().getPageActivity().getWindow().getDecorView();
        }
        return (View) invokeV.objValue;
    }

    public final void C(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) this.h.findViewById(R.id.obfuscated_res_0x7f09090c);
            this.p = navigationBar;
            navigationBar.setNavHeight(this.t);
            this.p.hideBottomLine();
            this.q = this.h.findViewById(R.id.obfuscated_res_0x7f090822);
            X(0);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091642);
            this.m = imageView;
            imageView.setOnClickListener(new d(this));
            if (this.d != null) {
                this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.b, (View.OnClickListener) null);
                ViewGroup viewGroup = (ViewGroup) this.b.getParent();
                if (viewGroup instanceof LinearLayout) {
                    ((LinearLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof RelativeLayout) {
                    ((RelativeLayout) viewGroup).setGravity(3);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.gravity = 3;
                    viewGroup.setLayoutParams(layoutParams);
                }
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
                newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), this.d.getPaddingBottom());
            }
        }
    }

    public final void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0275, (ViewGroup) null);
            this.b = linearLayout;
            ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091b94);
            this.c = forumHeaderView;
            forumHeaderView.setFrom(0);
            this.c.b();
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.b.findViewById(R.id.obfuscated_res_0x7f092018);
            this.d = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.B(fj.f(this.a.getContext(), R.dimen.tbds46), fj.f(this.a.getContext(), R.dimen.tbds46), fj.f(this.a.getContext(), R.dimen.tbds10), fj.f(this.a.getContext(), R.dimen.tbds46), true);
            this.d.setmIndicatorWidth(fj.f(this.mContext.getPageActivity(), R.dimen.tbds42));
            this.d.setIndicatorOvershot(fj.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.d.setIndicatorRadius(fj.f(this.mContext.getPageActivity(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(fj.f(this.a.getContext(), R.dimen.tbds0));
            this.d.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.d.setTabPadding(fj.f(this.a.getContext(), R.dimen.tbds36), 0, fj.f(this.a.getContext(), R.dimen.tbds36), 0);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(this.x);
            this.o = this.b.findViewById(R.id.obfuscated_res_0x7f09090d);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f09090e);
        }
    }

    public void I(int i, int i2, Intent intent) {
        List list;
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) && (list = this.g) != null && list.size() > 0 && (pullLeftViewPager = this.e) != null) {
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.g.get(pullLeftViewPager.getCurrentItem());
            if (aVar != null && (fragment = aVar.a) != null) {
                fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            EnterForumTabFragment enterForumTabFragment = this.a;
            if (enterForumTabFragment != null && this.g != null && this.e != null && this.f != null) {
                FragmentManager childFragmentManager = enterForumTabFragment.getChildFragmentManager();
                if (childFragmentManager.isDestroyed()) {
                    return;
                }
                FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                for (int i = 0; i < this.g.size(); i++) {
                    Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(G(this.e.getId(), this.f.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            }
            NoNetworkView noNetworkView = this.r;
            if (noNetworkView != null) {
                noNetworkView.e(this);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LinearLayout linearLayout = this.b;
            if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
                v();
                return;
            }
            View view2 = this.q;
            if (view2 == null) {
                return;
            }
            view2.clearAnimation();
            if (this.q.getVisibility() == 0) {
                return;
            }
            this.q.setVisibility(0);
            if (this.i == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.i = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.i.setDuration(300L);
            }
            this.q.startAnimation(this.i);
        }
    }

    public void u() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (view2 = this.q) == null || view2.getVisibility() == 8) {
            return;
        }
        if (this.j == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.j = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.j.setDuration(300L);
            this.j.setAnimationListener(new e(this));
        }
        this.q.startAnimation(this.j);
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
            } else if (ListUtils.getItem(this.g, i) != null && (((EnterForumTabPagerAdapter.a) this.g.get(i)).a instanceof EnterForumTabFeedFragment)) {
                ((EnterForumTabFeedFragment) ((EnterForumTabPagerAdapter.a) this.g.get(i)).a).q1(true);
            }
        }
    }

    public int w(String str) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (StringUtils.isNull(str) || (list = this.g) == null || list.size() <= 0) {
                return -1;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (str.equals(((EnterForumTabPagerAdapter.a) this.g.get(i2)).d)) {
                    i = i2;
                }
            }
            if (i == -1 && this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b6b).equals(str)) {
                return 0;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void N(int i) {
        h96 h96Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (this.m != null) {
                if (i == 0) {
                    h96 h96Var2 = this.k;
                    if (h96Var2 != null && h96Var2.a && h96Var2.b > 0) {
                        lb6 lb6Var = this.s;
                        if (lb6Var != null && lb6Var.T() != null && this.s.T().isViewAttached()) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            h96 h96Var3 = this.k;
                            int i4 = h96Var3.c;
                            if (i4 > 0 && h96Var3.b > i4 / 2) {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    } else {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            NavigationBar navigationBar = this.p;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                if (i == 0) {
                    h96 h96Var4 = this.k;
                    if (h96Var4 != null && h96Var4.a && h96Var4.b > 0) {
                        lb6 lb6Var2 = this.s;
                        if (lb6Var2 != null && lb6Var2.T() != null && this.s.T().isViewAttached()) {
                            SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        } else {
                            h96 h96Var5 = this.k;
                            int i5 = h96Var5.c;
                            if (i5 > 0) {
                                int i6 = (h96Var5.b * 255) / i5;
                                if (i6 > 255) {
                                    i6 = 255;
                                }
                                i3 = 255 - i6;
                            } else {
                                i3 = 0;
                            }
                            this.p.setBackgroundColor(0);
                            SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, i3 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                        }
                    } else {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
            if (newPagerSlidingTabBaseStrip != null) {
                if (i == 0) {
                    h96 h96Var6 = this.k;
                    if (h96Var6 != null && h96Var6.a && (i2 = h96Var6.b) > 0) {
                        int i7 = h96Var6.c;
                        if (i7 > 0 && i2 > i7 / 2) {
                            lb6 lb6Var3 = this.s;
                            if (lb6Var3 != null && lb6Var3.T() != null && this.s.T().isViewAttached()) {
                                this.d.setWhiteStyle(false);
                            } else {
                                this.d.setWhiteStyle(true);
                            }
                        } else {
                            this.d.setWhiteStyle(false);
                        }
                    } else {
                        this.d.setWhiteStyle(false);
                    }
                } else {
                    newPagerSlidingTabBaseStrip.setWhiteStyle(false);
                }
            }
            ForumHeaderView forumHeaderView = this.c;
            if (forumHeaderView != null) {
                if (i == 0) {
                    forumHeaderView.setAdState(this.k);
                } else {
                    forumHeaderView.setAdState(null);
                }
            }
            if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.a.isPrimary() && (h96Var = this.k) != null && h96Var.a && i == 0) {
                int i8 = h96Var.b;
                int i9 = h96Var.c;
                if (i8 > i9 / 2) {
                    h96 h96Var7 = this.l;
                    if (h96Var7 != null && h96Var7.b <= i9 / 2) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                        return;
                    }
                    return;
                }
                h96 h96Var8 = this.l;
                if (h96Var8 != null && h96Var8.b >= i9 / 2) {
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            }
        }
    }

    public final void O(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.p != null) {
            if (i == 0) {
                if (i2 == 0) {
                    N(i);
                    return;
                }
                h96 h96Var = this.k;
                if (h96Var != null && h96Var.a && h96Var.b > 0) {
                    lb6 lb6Var = this.s;
                    if (lb6Var != null && lb6Var.T() != null && this.s.T().isViewAttached()) {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.p.setBackgroundColor(0);
                    SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                N(i);
            } else {
                h96 h96Var2 = this.k;
                if (h96Var2 != null && h96Var2.a && h96Var2.b > 0) {
                    lb6 lb6Var2 = this.s;
                    if (lb6Var2 != null && lb6Var2.T() != null && this.s.T().isViewAttached()) {
                        SkinManager.setBackgroundColor(this.p.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.p.setBackgroundColor(0);
                    SkinManager.setBackgroundColorWithAlpha(this.p.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                if (this.e.getCurrentItem() == 0 && this.a.isPrimary()) {
                    lb6 lb6Var = this.s;
                    if (lb6Var != null && lb6Var.T() != null && this.s.T().isViewAttached()) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    }
                    h96 h96Var = this.k;
                    if (h96Var != null && h96Var.a) {
                        int i = h96Var.b;
                        if (i <= h96Var.c / 2 && i != 0) {
                            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                            return;
                        } else {
                            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                            return;
                        }
                    }
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                return;
            }
            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        }
    }

    public void T(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.f;
            if (enterForumTabPagerAdapter != null) {
                enterForumTabPagerAdapter.c(z);
            }
            List list = this.g;
            if (list != null && list.size() > 0 && (pullLeftViewPager = this.e) != null) {
                EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.g.get(pullLeftViewPager.getCurrentItem());
                if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).setPrimary(z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void d(boolean z) {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            List list = this.g;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.g.size(); i++) {
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) this.g.get(i);
                    if (aVar != null && (fragment = aVar.a) != null && (fragment instanceof NoNetworkView.b)) {
                        ((NoNetworkView.b) fragment).d(z);
                    }
                }
            }
            N(this.e.getCurrentItem());
        }
    }
}
