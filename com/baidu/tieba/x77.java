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
public class x77 extends v9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public j87 c;
    public sz6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public ol6 l;
    public FrsTabViewController m;
    public w77 n;
    public v77 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x77 a;

        public a(x77 x77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x77Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f0906c9);
            FrsViewData X0 = this.a.a.X0();
            if (X0 != null && X0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && X0.getForum() != null) {
                    if (this.a.a.a4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", X0.getForum().getId());
                    statisticItem.param("fname", X0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    d57.a(statisticItem);
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
            if (id != R.id.obfuscated_res_0x7f09255a && logicField != LogicField.LIKE_BTN) {
                if (id != R.id.obfuscated_res_0x7f0925a2 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090c2e) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && X0 != null && X0.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{X0.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090bd1) {
                        if (X0 != null && X0.getUserData() != null && X0.getUserData().isBawu()) {
                            String bawuCenterUrl = X0.getBawuCenterUrl();
                            if (!dj.isEmpty(bawuCenterUrl)) {
                                zu4.s(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (X0.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", X0.getForum().getId()).param("uid", X0.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f09141c && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090c39) {
                            if (X0 != null && X0.getForum() != null && !TextUtils.isEmpty(X0.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(dh.g(X0.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", X0.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090c88) {
                            if (X0 != null && X0.getForum() != null && !TextUtils.isEmpty(X0.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(X0.getForum().getId()), X0.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090c87 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && X0 != null && X0.getForum() != null && !TextUtils.isEmpty(X0.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> p = this.a.a.p();
                            urlManager.dealOneLink(p, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + X0.getForum().getId()});
                        }
                    } else if (!this.a.a.E3() && this.a.i == 0 && this.a.F() && this.a.c != null) {
                        this.a.c.S(view2, false);
                    }
                } else if (!this.a.a.E3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d11);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        if (!this.a.B()) {
                            this.a.y0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), dh.e(this.a.a.l(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.E3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d11);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.l()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f09110c);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        d57.d(this.a.a.l(), this.a.a.e());
                    }
                    this.a.x0(true);
                    if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        public final /* synthetic */ x77 a;

        public b(x77 x77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x77Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            fv6 u1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (u1 = this.a.a.u1()) != null && u1.c0() != null && !u1.c0().l() && !u1.e0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.g3() && this.a.k == 1 && this.a.F() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.v0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x77 a;

        public c(x77 x77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x77Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof ml) {
                ((ml) view2).refresh();
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
    public x77(FrsFragment frsFragment, sz6 sz6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, sz6Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((x9) newInitContext.callArgs[0]);
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
        this.d = sz6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new w77(this.a, gen);
        this.o = new v77(this.a);
        this.l = new ol6();
    }

    public final void y(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048623, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            d0();
            if (this.c == null || z) {
                j87 j87Var = this.c;
                if (j87Var != null) {
                    j87Var.u();
                    this.c = null;
                }
                j87 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            w77 w77Var = this.n;
            if (w77Var != null) {
                this.c.Q(w77Var);
            }
            v77 v77Var = this.o;
            if (v77Var != null) {
                this.c.O(v77Var);
            }
            this.b.a(this.c.l());
            z(str);
            w0();
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
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            w77 w77Var = this.n;
            if (w77Var != null) {
                w77Var.p();
            }
            v77 v77Var = this.o;
            if (v77Var != null) {
                v77Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                j87 j87Var = this.c;
                if (j87Var != null) {
                    this.b.d(j87Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            j87 j87Var2 = this.c;
            if (j87Var2 != null && j87Var2.h() != null && !this.e) {
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, str) == null) && this.a.P0() != null && this.a.P0().l0() != null) {
            int T = this.a.P0().l0().T();
            int Q = this.a.P0().l0().Q();
            int O = this.a.P0().l0().O();
            c49 i = c49.i();
            c49.i().n(i.g("1~" + str, T, Q, O), false);
        }
    }

    public final float C(ForumData forumData) {
        InterceptResult invokeL;
        w77 w77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, forumData)) == null) {
            if (forumData != null && (w77Var = this.n) != null) {
                return w77Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.g = i;
            j87 j87Var = this.c;
            if (j87Var != null) {
                j87Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void Q(boolean z) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (j87Var = this.c) != null) {
            j87Var.x(z);
        }
    }

    public void S(MotionEvent motionEvent) {
        ol6 ol6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, motionEvent) == null) && (ol6Var = this.l) != null) {
            ol6Var.c(motionEvent);
        }
    }

    public void T(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, num) == null) {
            p0(num.intValue());
            if (F()) {
                Y();
            }
        }
    }

    public void W(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, frsViewData) == null) && frsViewData != null && F()) {
            V(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && F()) {
            i0(i);
        }
    }

    public void a0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && frsViewData != null && this.c != null && F()) {
            this.c.A(C(frsViewData.getForum()));
        }
    }

    public void h0(int i) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && (j87Var = this.c) != null && j87Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.n();
        }
    }

    public void i0(int i) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i) == null) && (j87Var = this.c) != null) {
            j87Var.J(i);
        }
    }

    public void l0(int i) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && F() && (j87Var = this.c) != null) {
            j87Var.L(i);
        }
    }

    public void m0(FrsViewData frsViewData) {
        w77 w77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, frsViewData) == null) && F() && (w77Var = this.n) != null) {
            w77Var.v(this.c, frsViewData);
        }
    }

    public void p0(int i) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i) == null) && (j87Var = this.c) != null) {
            j87Var.P(i);
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            if (i > 1) {
                j87 j87Var = this.c;
                if (j87Var != null) {
                    j87Var.N(false);
                    return;
                }
                return;
            }
            j87 j87Var2 = this.c;
            if (j87Var2 != null) {
                j87Var2.N(true);
            }
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.i = i;
        }
    }

    public void s0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void u0(List<k49> list) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, list) == null) && (j87Var = this.c) != null) {
            j87Var.T(list);
        }
    }

    public void x0(boolean z) {
        v77 v77Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (v77Var = this.o) != null) {
            j87 j87Var = this.c;
            if (j87Var != null && j87Var.q()) {
                z2 = true;
            } else {
                z2 = false;
            }
            v77Var.m(z2);
            this.o.o(z);
        }
    }

    public void k0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048609, this, frsViewData, z) == null) && frsViewData != null && F()) {
            j0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void t0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048617, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        j87 j87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (F() && (j87Var = this.c) != null) {
                return j87Var.m();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        j87 j87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (F() && (j87Var = this.c) != null) {
                return j87Var.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (j87Var = this.c) != null) {
            j87Var.n();
        }
    }

    public void E() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j87Var = this.c) != null) {
            j87Var.p();
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        j87 j87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (F() && (j87Var = this.c) != null) {
                return j87Var.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            j87 j87Var = this.c;
            if (j87Var != null) {
                j87Var.u();
            }
            v77 v77Var = this.o;
            if (v77Var != null) {
                v77Var.k();
            }
            if (this.q != null) {
                gh.a().removeCallbacks(this.q);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            j87 j87Var = this.c;
            if (j87Var != null) {
                j87Var.z();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void P() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (j87Var = this.c) != null) {
            j87Var.w();
        }
    }

    public void R() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (j87Var = this.c) != null) {
            j87Var.y();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.c.C();
        }
    }

    public void Y() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (j87Var = this.c) != null) {
            j87Var.Y();
        }
    }

    public void Z() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void b0() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (j87Var = this.c) != null) {
            j87Var.D();
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            j87 j87Var = this.c;
            if (j87Var != null) {
                this.b.d(j87Var.l());
                this.b.d(this.c.h());
                e0();
            }
            this.e = false;
        }
    }

    public final void e0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.G3() != null) {
            this.a.G3().removeHeaderView(this.m.H());
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && F()) {
            i0(0);
        }
    }

    public final void v0() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && F() && (j87Var = this.c) != null) {
            j87Var.U();
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            gh.a().postDelayed(this.q, 4000L);
        }
    }

    public void x() {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && !this.e && (j87Var = this.c) != null) {
            this.b.a(j87Var.h());
            this.e = true;
        }
    }

    public void z0() {
        v77 v77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (v77Var = this.o) != null) {
            v77Var.p();
        }
    }

    public void A0(int i, int i2, int i3) {
        w77 w77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) && (w77Var = this.n) != null) {
            w77Var.y(i, i2, i3);
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        w77 w77Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (w77Var = this.n) != null) {
            j87 j87Var = this.c;
            if (j87Var != null) {
                w77Var.x(j87Var.s(), this.c.e());
            } else {
                w77Var.x(false, "");
            }
            j87 j87Var2 = this.c;
            if (j87Var2 != null) {
                this.n.w(j87Var2.k());
            }
        }
    }

    public void V(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float C = C(forumData);
            j87 j87Var = this.c;
            if (j87Var == null) {
                return;
            }
            j87Var.H(forumData, frsViewData);
            this.c.K(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), C, false);
            this.c.M(forumData.getSignData());
        }
    }

    public void j0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        j87 j87Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (j87Var = this.c) == null) {
            return;
        }
        j87Var.H(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.K(i, forumData.getLevelName(), forumData.getUser_level(), C(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }

    public final void z(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.G3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.G3().removeHeaderView(H);
            return;
        }
        this.a.G3().removeHeaderView(H);
        this.a.G3().t(H, 0);
    }
}
