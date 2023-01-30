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
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
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
/* loaded from: classes5.dex */
public class q07 extends q9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public c17 c;
    public is6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public ne6 l;
    public FrsTabViewController m;
    public p07 n;
    public o07 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q07 a;

        public a(q07 q07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090672);
            FrsViewData X0 = this.a.a.X0();
            if (X0 != null && X0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && X0.getForum() != null) {
                    if (this.a.a.Z3()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", X0.getForum().getId());
                    statisticItem.param("fname", X0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    wx6.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (X0.getEntelechyTabInfo() != null && X0.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < X0.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(X0.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), X0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(X0.serviceAreaFlutterData);
                int baWuNoticeNum = X0.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (X0.getUserData() != null) {
                    if (X0.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    X0.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (X0.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (X0.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (X0.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0924af && logicField != LogicField.LIKE_BTN) {
                if (id != R.id.obfuscated_res_0x7f0924f3 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090b99) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && X0 != null && X0.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{X0.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090b3c) {
                        if (X0 != null && X0.getUserData() != null && X0.getUserData().isBawu()) {
                            String bawuCenterUrl = X0.getBawuCenterUrl();
                            if (!yi.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.p(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (X0.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", X0.getForum().getId()).param("uid", X0.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f091384 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090ba4) {
                            if (X0 != null && X0.getForum() != null && !TextUtils.isEmpty(X0.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(yg.g(X0.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", X0.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090bf3) {
                            if (X0 != null && X0.getForum() != null && !TextUtils.isEmpty(X0.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(X0.getForum().getId()), X0.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090bf2 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && X0 != null && X0.getForum() != null && !TextUtils.isEmpty(X0.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> p = this.a.a.p();
                            urlManager.dealOneLink(p, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + X0.getForum().getId()});
                        }
                    } else if (!this.a.a.D3() && this.a.i == 0 && this.a.E() && this.a.c != null) {
                        this.a.c.S(view2, false);
                    }
                } else if (!this.a.a.D3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        if (!this.a.A()) {
                            this.a.x0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), yg.e(this.a.a.l(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.D3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.l()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091071);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        wx6.d(this.a.a.l(), this.a.a.e());
                    }
                    this.a.w0(true);
                    if (!yi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.l());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q07 a;

        public b(q07 q07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q07Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vn6 u1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (u1 = this.a.a.u1()) != null && u1.c0() != null && !u1.c0().o() && !u1.e0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.f3() && this.a.k == 1 && this.a.E() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.u0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q07 a;

        public c(q07 q07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q07Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof gl) {
                ((gl) view2).refresh();
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
    public q07(FrsFragment frsFragment, is6 is6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, is6Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s9) newInitContext.callArgs[0]);
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
        this.a = frsFragment;
        this.d = is6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new p07(this.a, gen);
        this.o = new o07(this.a);
        this.l = new ne6();
    }

    public final void x(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            c0();
            if (this.c == null || z) {
                c17 c17Var = this.c;
                if (c17Var != null) {
                    c17Var.u();
                    this.c = null;
                }
                c17 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            p07 p07Var = this.n;
            if (p07Var != null) {
                this.c.Q(p07Var);
            }
            o07 o07Var = this.o;
            if (o07Var != null) {
                this.c.O(o07Var);
            }
            this.b.a(this.c.l());
            y(str);
            v0();
        }
    }

    public static boolean H(FrsViewData frsViewData) {
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

    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            p07 p07Var = this.n;
            if (p07Var != null) {
                p07Var.p();
            }
            o07 o07Var = this.o;
            if (o07Var != null) {
                o07Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (z) {
                c17 c17Var = this.c;
                if (c17Var != null) {
                    this.b.d(c17Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            c17 c17Var2 = this.c;
            if (c17Var2 != null && c17Var2.h() != null && !this.e) {
                this.b.b(this.c.h(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean J(FrsViewData frsViewData) {
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

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.a.P0() != null && this.a.P0().e0() != null) {
            int M = this.a.P0().e0().M();
            int J = this.a.P0().e0().J();
            int H = this.a.P0().e0().H();
            ov8 i = ov8.i();
            ov8.i().n(i.g("1~" + str, M, J, H), false);
        }
    }

    public final float B(ForumData forumData) {
        InterceptResult invokeL;
        p07 p07Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumData)) == null) {
            if (forumData != null && (p07Var = this.n) != null) {
                return p07Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.g = i;
            c17 c17Var = this.c;
            if (c17Var != null) {
                c17Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void P(boolean z) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (c17Var = this.c) != null) {
            c17Var.x(z);
        }
    }

    public void R(MotionEvent motionEvent) {
        ne6 ne6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, motionEvent) == null) && (ne6Var = this.l) != null) {
            ne6Var.c(motionEvent);
        }
    }

    public void S(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            n0(num.intValue());
            if (E()) {
                X();
            }
        }
    }

    public void V(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, frsViewData) == null) && frsViewData != null && E()) {
            U(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && E()) {
            h0(i);
        }
    }

    public void Z(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) && frsViewData != null && this.c != null && E()) {
            this.c.A(B(frsViewData.getForum()));
        }
    }

    public void f0(int i) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i) == null) && (c17Var = this.c) != null && c17Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.n();
        }
    }

    public void h0(int i) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i) == null) && (c17Var = this.c) != null) {
            c17Var.J(i);
        }
    }

    public void k0(int i) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && E() && (c17Var = this.c) != null) {
            c17Var.L(i);
        }
    }

    public void l0(FrsViewData frsViewData) {
        p07 p07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, frsViewData) == null) && E() && (p07Var = this.n) != null) {
            p07Var.v(this.c, frsViewData);
        }
    }

    public void n0(int i) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && (c17Var = this.c) != null) {
            c17Var.P(i);
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            if (i > 1) {
                c17 c17Var = this.c;
                if (c17Var != null) {
                    c17Var.N(false);
                    return;
                }
                return;
            }
            c17 c17Var2 = this.c;
            if (c17Var2 != null) {
                c17Var2.N(true);
            }
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.i = i;
        }
    }

    public void r0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void t0(List<wv8> list) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, list) == null) && (c17Var = this.c) != null) {
            c17Var.T(list);
        }
    }

    public void w0(boolean z) {
        o07 o07Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && (o07Var = this.o) != null) {
            c17 c17Var = this.c;
            if (c17Var != null && c17Var.q()) {
                z2 = true;
            } else {
                z2 = false;
            }
            o07Var.m(z2);
            this.o.o(z);
        }
    }

    public void j0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048607, this, frsViewData, z) == null) && frsViewData != null && E()) {
            i0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void s0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048615, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        c17 c17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (E() && (c17Var = this.c) != null) {
                return c17Var.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void C() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (c17Var = this.c) != null) {
            c17Var.n();
        }
    }

    public void D() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (c17Var = this.c) != null) {
            c17Var.p();
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        c17 c17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (E() && (c17Var = this.c) != null) {
                return c17Var.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c17 c17Var = this.c;
            if (c17Var != null) {
                c17Var.u();
            }
            o07 o07Var = this.o;
            if (o07Var != null) {
                o07Var.k();
            }
            if (this.q != null) {
                bh.a().removeCallbacks(this.q);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c17 c17Var = this.c;
            if (c17Var != null) {
                c17Var.z();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void O() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (c17Var = this.c) != null) {
            c17Var.w();
        }
    }

    public void Q() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (c17Var = this.c) != null) {
            c17Var.y();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.C();
        }
    }

    public void X() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (c17Var = this.c) != null) {
            c17Var.Y();
        }
    }

    public void Y() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void a0() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (c17Var = this.c) != null) {
            c17Var.D();
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c17 c17Var = this.c;
            if (c17Var != null) {
                this.b.d(c17Var.l());
                this.b.d(this.c.h());
                d0();
            }
            this.e = false;
        }
    }

    public final void d0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.F3() != null) {
            this.a.F3().removeHeaderView(this.m.H());
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && E()) {
            h0(0);
        }
    }

    public final void u0() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && E() && (c17Var = this.c) != null) {
            c17Var.U();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            bh.a().postDelayed(this.q, 4000L);
        }
    }

    public void w() {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && !this.e && (c17Var = this.c) != null) {
            this.b.a(c17Var.h());
            this.e = true;
        }
    }

    public void y0() {
        o07 o07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (o07Var = this.o) != null) {
            o07Var.p();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        c17 c17Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (E() && (c17Var = this.c) != null) {
                return c17Var.m();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        p07 p07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (p07Var = this.n) != null) {
            c17 c17Var = this.c;
            if (c17Var != null) {
                p07Var.x(c17Var.s(), this.c.e());
            } else {
                p07Var.x(false, "");
            }
            c17 c17Var2 = this.c;
            if (c17Var2 != null) {
                this.n.w(c17Var2.k());
            }
        }
    }

    public void U(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float B = B(forumData);
            c17 c17Var = this.c;
            if (c17Var == null) {
                return;
            }
            c17Var.H(forumData, frsViewData);
            this.c.K(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), B, false);
            this.c.M(forumData.getSignData());
        }
    }

    public void i0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        c17 c17Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (c17Var = this.c) == null) {
            return;
        }
        c17Var.H(forumData, frsViewData);
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
        if ((interceptable != null && interceptable.invokeL(1048623, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.F3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.F3().removeHeaderView(H);
            return;
        }
        this.a.F3().removeHeaderView(H);
        this.a.F3().t(H, 0);
    }

    public void z0(int i, int i2, int i3) {
        p07 p07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048626, this, i, i2, i3) == null) && (p07Var = this.n) != null) {
            p07Var.y(i, i2, i3);
        }
    }
}
