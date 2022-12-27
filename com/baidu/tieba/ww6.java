package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.unreadbawu.BawuUnreadRequestMessage;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ww6 extends p9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public ex6 c;
    public so6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public va6 l;
    public FrsTabViewController m;
    public vw6 n;
    public uw6 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final Runnable r;
    public Runnable s;

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww6 a;

        public a(ww6 ww6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090674);
            FrsViewData S0 = this.a.a.S0();
            if (S0 != null && S0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && S0.getForum() != null) {
                    if (this.a.a.T3()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", S0.getForum().getId());
                    statisticItem.param("fname", S0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    eu6.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (S0.getEntelechyTabInfo() != null && S0.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < S0.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(S0.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), S0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(S0.serviceAreaFlutterData);
                int baWuNoticeNum = S0.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (S0.getUserData() != null) {
                    if (S0.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    S0.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (S0.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (S0.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (S0.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f092482 && logicField != LogicField.LIKE_BTN) {
                if (id != R.id.obfuscated_res_0x7f0924c6 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090b8c) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && S0 != null && S0.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{S0.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090b2e) {
                        if (S0 != null && S0.getUserData() != null && S0.getUserData().isBawu()) {
                            String bawuCenterUrl = S0.getBawuCenterUrl();
                            if (!xi.isEmpty(bawuCenterUrl)) {
                                sp4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (S0.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", S0.getForum().getId()).param("uid", S0.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f091379 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090b97) {
                            if (S0 != null && S0.getForum() != null && !TextUtils.isEmpty(S0.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(xg.g(S0.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", S0.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090be6) {
                            if (S0 != null && S0.getForum() != null && !TextUtils.isEmpty(S0.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(S0.getForum().getId()), S0.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090be5 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && S0 != null && S0.getForum() != null && !TextUtils.isEmpty(S0.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> p = this.a.a.p();
                            urlManager.dealOneLink(p, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + S0.getForum().getId()});
                        }
                    } else if (!this.a.a.y3() && this.a.i == 0 && this.a.F() && this.a.c != null) {
                        this.a.c.S(view2, false);
                    }
                } else if (!this.a.a.y3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0cb8);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        if (!this.a.A()) {
                            this.a.C0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), xg.e(this.a.a.l(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.y3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0cb8);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.l()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091066);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        eu6.d(this.a.a.l(), this.a.a.g());
                    }
                    this.a.A0(true);
                    if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.l());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww6 a;

        public b(ww6 ww6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ik6 q1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (q1 = this.a.a.q1()) != null && q1.a0() != null && !q1.a0().o() && !q1.c0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.a3() && this.a.k == 1 && this.a.F() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.x0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww6 a;

        public c(ww6 ww6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && !this.a.a.q1().c0() && this.a.b.isShown() && this.a.a.isPrimary() && this.a.a.getActivity() != null && this.a.a.getActivity().getIntent() != null && !FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                this.a.t0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww6 a;

        public d(ww6 ww6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof fl) {
                ((fl) view2).refresh();
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null) {
                int childCount = this.a.b.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(this.a.b.getChildAt(i));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww6(FrsFragment frsFragment, so6 so6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, so6Var, frsHeaderViewContainer};
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
        this.e = false;
        this.g = 0;
        this.h = "normal_page";
        this.i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = frsFragment;
        this.d = so6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new vw6(this.a, gen);
        this.o = new uw6(this.a);
        this.l = new va6();
    }

    public final void x(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048625, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            d0();
            if (this.c == null || z) {
                ex6 ex6Var = this.c;
                if (ex6Var != null) {
                    ex6Var.u();
                    this.c = null;
                }
                ex6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            vw6 vw6Var = this.n;
            if (vw6Var != null) {
                this.c.Q(vw6Var);
            }
            uw6 uw6Var = this.o;
            if (uw6Var != null) {
                this.c.O(uw6Var);
            }
            this.b.a(this.c.l());
            y(str);
            y0();
            u0();
        }
    }

    public static boolean J(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            vw6 vw6Var = this.n;
            if (vw6Var != null) {
                vw6Var.p();
            }
            uw6 uw6Var = this.o;
            if (uw6Var != null) {
                uw6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (z) {
                ex6 ex6Var = this.c;
                if (ex6Var != null) {
                    this.b.d(ex6Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            ex6 ex6Var2 = this.c;
            if (ex6Var2 != null && ex6Var2.h() != null && !this.e) {
                this.b.b(this.c.h(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean K(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData == null) {
                return false;
            }
            if ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && ((frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true))))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && this.a.N0() != null && this.a.N0().e0() != null) {
            int M = this.a.N0().e0().M();
            int J = this.a.N0().e0().J();
            int H = this.a.N0().e0().H();
            sq8 i = sq8.i();
            sq8.i().n(i.g("1~" + str, M, J, H), false);
        }
    }

    public void A0(boolean z) {
        uw6 uw6Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (uw6Var = this.o) != null) {
            ex6 ex6Var = this.c;
            if (ex6Var != null && ex6Var.q()) {
                z2 = true;
            } else {
                z2 = false;
            }
            uw6Var.m(z2);
            this.o.p(z);
        }
    }

    public final float B(ForumData forumData) {
        InterceptResult invokeL;
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData != null && (vw6Var = this.n) != null) {
                return vw6Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.g = i;
            ex6 ex6Var = this.c;
            if (ex6Var != null) {
                ex6Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void Q(boolean z) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (ex6Var = this.c) != null) {
            ex6Var.x(z);
        }
    }

    public void S(MotionEvent motionEvent) {
        va6 va6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, motionEvent) == null) && (va6Var = this.l) != null) {
            va6Var.c(motionEvent);
        }
    }

    public void T(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, num) == null) {
            p0(num.intValue());
            if (F()) {
                Y();
            }
        }
    }

    public void W(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) && frsViewData != null && F()) {
            V(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && F()) {
            i0(i);
        }
    }

    public void a0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, frsViewData) == null) && frsViewData != null && this.c != null && F()) {
            this.c.A(B(frsViewData.getForum()));
        }
    }

    public void h0(int i) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048609, this, i) == null) && (ex6Var = this.c) != null && ex6Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.n();
        }
    }

    public void i0(int i) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && (ex6Var = this.c) != null) {
            ex6Var.J(i);
        }
    }

    public void l0(int i) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i) == null) && F() && (ex6Var = this.c) != null) {
            ex6Var.L(i);
        }
    }

    public void n0(FrsViewData frsViewData) {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, frsViewData) == null) && F() && (vw6Var = this.n) != null) {
            vw6Var.v(this.c, frsViewData);
        }
    }

    public void p0(int i) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048616, this, i) == null) && (ex6Var = this.c) != null) {
            ex6Var.P(i);
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            if (i > 1) {
                ex6 ex6Var = this.c;
                if (ex6Var != null) {
                    ex6Var.N(false);
                    return;
                }
                return;
            }
            ex6 ex6Var2 = this.c;
            if (ex6Var2 != null) {
                ex6Var2.N(true);
            }
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.i = i;
        }
    }

    public void s0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void w0(List<ar8> list) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, list) == null) && (ex6Var = this.c) != null) {
            ex6Var.U(list);
        }
    }

    public void k0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048612, this, frsViewData, z) == null) && frsViewData != null && F()) {
            j0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void v0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048622, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (F() && (ex6Var = this.c) != null) {
                return ex6Var.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public uw6 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.o;
        }
        return (uw6) invokeV.objValue;
    }

    public void D() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.n();
        }
    }

    public void D0() {
        uw6 uw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (uw6Var = this.o) != null) {
            uw6Var.q();
        }
    }

    public void E() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.p();
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (F() && (ex6Var = this.c) != null) {
                return ex6Var.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ex6 ex6Var = this.c;
            if (ex6Var != null) {
                ex6Var.z();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public void P() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.w();
        }
    }

    public void R() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.y();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c.C();
        }
    }

    public void Y() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.Z();
        }
    }

    public void Z() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.s);
            this.b.postDelayed(this.s, 100L);
        }
    }

    public void b0() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.D();
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ex6 ex6Var = this.c;
            if (ex6Var != null) {
                this.b.d(ex6Var.l());
                this.b.d(this.c.h());
                e0();
            }
            this.e = false;
        }
    }

    public final void e0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.A3() != null) {
            this.a.A3().removeHeaderView(this.m.H());
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && F()) {
            i0(0);
        }
    }

    public void t0() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (ex6Var = this.c) != null) {
            ex6Var.T();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            ah.a().postDelayed(this.r, 500L);
        }
    }

    public void w() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && !this.e && (ex6Var = this.c) != null) {
            this.b.a(ex6Var.h());
            this.e = true;
        }
    }

    public final void x0() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && F() && (ex6Var = this.c) != null) {
            ex6Var.V();
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            ah.a().postDelayed(this.q, 4000L);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (F() && (ex6Var = this.c) != null) {
                return ex6Var.m();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void C0() {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (vw6Var = this.n) != null) {
            ex6 ex6Var = this.c;
            if (ex6Var != null) {
                vw6Var.x(ex6Var.s(), this.c.e());
            } else {
                vw6Var.x(false, "");
            }
            ex6 ex6Var2 = this.c;
            if (ex6Var2 != null) {
                this.n.w(ex6Var2.k());
            }
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ex6 ex6Var = this.c;
            if (ex6Var != null) {
                ex6Var.u();
            }
            uw6 uw6Var = this.o;
            if (uw6Var != null) {
                uw6Var.k();
            }
            if (this.q != null) {
                ah.a().removeCallbacks(this.q);
            }
            if (this.r != null) {
                ah.a().removeCallbacks(this.r);
            }
        }
    }

    public void E0(int i, int i2, int i3) {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) && (vw6Var = this.n) != null) {
            vw6Var.y(i, i2, i3);
        }
    }

    public void V(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float B = B(forumData);
            ex6 ex6Var = this.c;
            if (ex6Var == null) {
                return;
            }
            ex6Var.H(forumData, frsViewData);
            this.c.K(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), B, false);
            this.c.M(forumData.getSignData());
        }
    }

    public void j0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (ex6Var = this.c) == null) {
            return;
        }
        ex6Var.H(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.K(i, forumData.getLevelName(), forumData.getUser_level(), B(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }

    public final void y(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.A3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.A3().removeHeaderView(H);
            return;
        }
        this.a.A3().removeHeaderView(H);
        this.a.A3().t(H, 0);
    }
}
