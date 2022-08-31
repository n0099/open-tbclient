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
public class yr6 extends b9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public gs6 c;
    public ak6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public t56 l;
    public FrsTabViewController m;
    public xr6 n;
    public wr6 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final Runnable r;
    public Runnable s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr6 a;

        public a(yr6 yr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09063a);
            FrsViewData P0 = this.a.a.P0();
            if (P0 != null && P0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && P0.getForum() != null) {
                    int i = this.a.a.T3() ? 1 : 2;
                    statisticItem.param("fid", P0.getForum().getId());
                    statisticItem.param("fname", P0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    jp6.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (P0.getEntelechyTabInfo() != null && P0.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < P0.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(P0.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), P0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(P0.serviceAreaFlutterData);
                int baWuNoticeNum = P0.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (P0.getUserData() != null) {
                    if (P0.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    P0.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (P0.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (P0.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (P0.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092364 || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.x3()) {
                    return;
                }
                if (!pi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.d()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fbe);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        jp6.d(this.a.a.d(), this.a.a.c());
                    }
                    this.a.B0(true);
                    if (qi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c10048");
                    statisticItem2.param("fid", this.a.a.d());
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                }
            } else if (id == R.id.obfuscated_res_0x7f0923a7 || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.x3()) {
                    return;
                }
                if (!pi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.A()) {
                        this.a.C0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), pg.e(this.a.a.d(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090b3a) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || P0 == null || P0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{P0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090add) {
                if (P0 == null || P0.getUserData() == null || !P0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = P0.getBawuCenterUrl();
                if (qi.isEmpty(bawuCenterUrl)) {
                    return;
                }
                km4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (P0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", P0.getForum().getId()).param("uid", P0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f0912c5 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.x3() || this.a.i != 0 || !this.a.F() || this.a.c == null) {
                    return;
                }
                this.a.c.S(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b45) {
                if (P0 == null || P0.getForum() == null || TextUtils.isEmpty(P0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(pg.g(P0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem3 = new StatisticItem("c13666");
                statisticItem3.param("fid", P0.getForum().getId());
                TiebaStatic.log(statisticItem3);
            } else if (id != R.id.obfuscated_res_0x7f090b94) {
                if (id != R.id.obfuscated_res_0x7f090b93 || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || P0 == null || P0.getForum() == null || TextUtils.isEmpty(P0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> o = this.a.a.o();
                urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + P0.getForum().getId()});
            } else if (P0 != null && P0.getForum() != null && !TextUtils.isEmpty(P0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(P0.getForum().getId()), P0.getForum().getName())));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr6 a;

        public b(yr6 yr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            gf6 k1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (k1 = this.a.a.k1()) != null && k1.Z() != null && !k1.Z().p() && !k1.b0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.Y2() && this.a.k == 1 && this.a.F() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.y0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr6 a;

        public c(yr6 yr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.k1().b0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.t0();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr6 a;

        public d(yr6 yr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof xk) {
                ((xk) view2).refresh();
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                return;
            }
            int childCount = this.a.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(this.a.b.getChildAt(i));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr6(FrsFragment frsFragment, ak6 ak6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ak6Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
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
        this.d = ak6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new xr6(this.a, gen);
        this.o = new wr6(this.a);
        this.l = new t56();
    }

    public static boolean J(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean K(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData != null) {
                return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!F() || (gs6Var = this.c) == null) {
                return false;
            }
            return gs6Var.i();
        }
        return invokeV.booleanValue;
    }

    public final float B(ForumData forumData) {
        InterceptResult invokeL;
        xr6 xr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumData)) == null) {
            if (forumData == null || (xr6Var = this.n) == null) {
                return 0.0f;
            }
            return xr6Var.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void B0(boolean z) {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (wr6Var = this.o) == null) {
            return;
        }
        gs6 gs6Var = this.c;
        wr6Var.m(gs6Var != null && gs6Var.q());
        this.o.p(z);
    }

    public wr6 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : (wr6) invokeV.objValue;
    }

    public void C0() {
        xr6 xr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (xr6Var = this.n) == null) {
            return;
        }
        gs6 gs6Var = this.c;
        if (gs6Var != null) {
            xr6Var.v(gs6Var.s(), this.c.e());
        } else {
            xr6Var.v(false, "");
        }
        gs6 gs6Var2 = this.c;
        if (gs6Var2 != null) {
            this.n.u(gs6Var2.k());
        }
    }

    public void D() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.n();
    }

    public void D0() {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (wr6Var = this.o) == null) {
            return;
        }
        wr6Var.q();
    }

    public void E() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.p();
    }

    public void E0(int i, int i2, int i3) {
        xr6 xr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) || (xr6Var = this.n) == null) {
            return;
        }
        xr6Var.w(i, i2, i3);
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "frs_page".equals(this.h) || "normal_page".equals(this.h) || "book_page".equals(this.h) || "brand_page".equals(this.h) : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!F() || (gs6Var = this.c) == null) {
                return false;
            }
            return gs6Var.r();
        }
        return invokeV.booleanValue;
    }

    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            xr6 xr6Var = this.n;
            if (xr6Var != null) {
                xr6Var.n();
            }
            wr6 wr6Var = this.o;
            if (wr6Var != null) {
                wr6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            gs6 gs6Var = this.c;
            if (gs6Var != null) {
                gs6Var.u();
            }
            wr6 wr6Var = this.o;
            if (wr6Var != null) {
                wr6Var.k();
            }
            if (this.q != null) {
                sg.a().removeCallbacks(this.q);
            }
            if (this.r != null) {
                sg.a().removeCallbacks(this.r);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            gs6 gs6Var = this.c;
            if (gs6Var != null) {
                gs6Var.z();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public boolean O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.g = i;
            gs6 gs6Var = this.c;
            if (gs6Var != null) {
                gs6Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void P() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.w();
    }

    public void Q(boolean z) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.x(z);
    }

    public void R() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.y();
    }

    public void S(MotionEvent motionEvent) {
        t56 t56Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, motionEvent) == null) || (t56Var = this.l) == null) {
            return;
        }
        t56Var.c(motionEvent);
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

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c.C();
        }
    }

    public void V(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float B = B(forumData);
        gs6 gs6Var = this.c;
        if (gs6Var == null) {
            return;
        }
        gs6Var.H(forumData, frsViewData);
        this.c.K(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), B, false);
        this.c.M(forumData.getSignData());
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

    public void Y() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.Z();
    }

    public void Z() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsHeaderViewContainer = this.b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.s);
        this.b.postDelayed(this.s, 100L);
    }

    public void a0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, frsViewData) == null) || frsViewData == null || this.c == null || !F()) {
            return;
        }
        this.c.A(B(frsViewData.getForum()));
    }

    public void b0() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.D();
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || this.a.K0() == null || this.a.K0().W() == null) {
            return;
        }
        int F = this.a.K0().W().F();
        int C = this.a.K0().W().C();
        int A = this.a.K0().W().A();
        nj8 i = nj8.i();
        nj8.i().n(i.g("1~" + str, F, C, A), false);
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            gs6 gs6Var = this.c;
            if (gs6Var != null) {
                this.b.d(gs6Var.l());
                this.b.d(this.c.h());
                f0();
            }
            this.e = false;
        }
    }

    public final void f0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.z3() == null) {
            return;
        }
        this.a.z3().removeHeaderView(this.m.I());
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (z) {
                gs6 gs6Var = this.c;
                if (gs6Var != null) {
                    this.b.d(gs6Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            gs6 gs6Var2 = this.c;
            if (gs6Var2 == null || gs6Var2.h() == null || this.e) {
                return;
            }
            this.b.b(this.c.h(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void h0(int i) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i) == null) || (gs6Var = this.c) == null || gs6Var.h() == null) {
            return;
        }
        View findViewById = this.c.h().findViewById(R.id.obfuscated_res_0x7f0907ee);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.n();
    }

    public void i0(int i) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.J(i);
    }

    public void j0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.H(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.K(i, forumData.getLevelName(), forumData.getUser_level(), B(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.c.a(false);
    }

    public void k0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048612, this, frsViewData, z) == null) && frsViewData != null && F()) {
            j0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void m0(int i) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i) == null) && F() && (gs6Var = this.c) != null) {
            gs6Var.L(i);
        }
    }

    public void n0(FrsViewData frsViewData) {
        xr6 xr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, frsViewData) == null) && F() && (xr6Var = this.n) != null) {
            xr6Var.t(this.c, frsViewData);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && F()) {
            i0(0);
        }
    }

    public void p0(int i) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.P(i);
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            if (i > 1) {
                gs6 gs6Var = this.c;
                if (gs6Var != null) {
                    gs6Var.N(false);
                    return;
                }
                return;
            }
            gs6 gs6Var2 = this.c;
            if (gs6Var2 != null) {
                gs6Var2.N(true);
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

    public void t0() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.T();
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            sg.a().postDelayed(this.r, 500L);
        }
    }

    public void v0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048622, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public void w() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.e || (gs6Var = this.c) == null) {
            return;
        }
        this.b.a(gs6Var.h());
        this.e = true;
    }

    public void w0(List<vj8> list) {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || (gs6Var = this.c) == null) {
            return;
        }
        gs6Var.U(list);
    }

    public final void x(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048625, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            e0();
            if (this.c == null || z) {
                gs6 gs6Var = this.c;
                if (gs6Var != null) {
                    gs6Var.u();
                    this.c = null;
                }
                gs6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            xr6 xr6Var = this.n;
            if (xr6Var != null) {
                this.c.Q(xr6Var);
            }
            wr6 wr6Var = this.o;
            if (wr6Var != null) {
                this.c.O(wr6Var);
            }
            this.b.a(this.c.l());
            y(str);
            z0();
            u0();
        }
    }

    public final void y(String str) {
        FrsFragment frsFragment;
        RelativeLayout I;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.z3() == null || (I = this.m.I()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.z3().removeHeaderView(I);
            return;
        }
        this.a.z3().removeHeaderView(I);
        this.a.z3().t(I, 0);
    }

    public final void y0() {
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && F() && (gs6Var = this.c) != null) {
            gs6Var.V();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (!F() || (gs6Var = this.c) == null) {
                return false;
            }
            return gs6Var.m();
        }
        return invokeV.booleanValue;
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            sg.a().postDelayed(this.q, 4000L);
        }
    }
}
