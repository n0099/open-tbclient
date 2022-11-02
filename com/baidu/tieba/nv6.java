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
/* loaded from: classes5.dex */
public class nv6 extends p9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public vv6 c;
    public kn6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public n96 l;
    public FrsTabViewController m;
    public mv6 n;
    public lv6 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final Runnable r;
    public Runnable s;

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv6 a;

        public a(nv6 nv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090663);
            FrsViewData O0 = this.a.a.O0();
            if (O0 != null && O0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && O0.getForum() != null) {
                    if (this.a.a.Q3()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", O0.getForum().getId());
                    statisticItem.param("fname", O0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    ws6.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (O0.getEntelechyTabInfo() != null && O0.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < O0.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(O0.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), O0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(O0.serviceAreaFlutterData);
                int baWuNoticeNum = O0.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (O0.getUserData() != null) {
                    if (O0.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    O0.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (O0.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (O0.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (O0.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f092400 && logicField != LogicField.LIKE_BTN) {
                if (id != R.id.obfuscated_res_0x7f092444 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090b70) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && O0 != null && O0.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{O0.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090b12) {
                        if (O0 != null && O0.getUserData() != null && O0.getUserData().isBawu()) {
                            String bawuCenterUrl = O0.getBawuCenterUrl();
                            if (!wi.isEmpty(bawuCenterUrl)) {
                                rp4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (O0.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", O0.getForum().getId()).param("uid", O0.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f091314 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090b7b) {
                            if (O0 != null && O0.getForum() != null && !TextUtils.isEmpty(O0.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(wg.g(O0.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", O0.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090bca) {
                            if (O0 != null && O0.getForum() != null && !TextUtils.isEmpty(O0.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(O0.getForum().getId()), O0.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090bc9 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && O0 != null && O0.getForum() != null && !TextUtils.isEmpty(O0.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> o = this.a.a.o();
                            urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + O0.getForum().getId()});
                        }
                    } else if (!this.a.a.w3() && this.a.i == 0 && this.a.F() && this.a.c != null) {
                        this.a.c.S(view2, false);
                    }
                } else if (!this.a.a.w3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c7f);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        if (!this.a.A()) {
                            this.a.C0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), wg.e(this.a.a.k(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.w3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c7f);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.k()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091006);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        ws6.d(this.a.a.k(), this.a.a.c());
                    }
                    this.a.B0(true);
                    if (!wi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.k());
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
        public final /* synthetic */ nv6 a;

        public b(nv6 nv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            aj6 j1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (j1 = this.a.a.j1()) != null && j1.a0() != null && !j1.a0().o() && !j1.c0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.X2() && this.a.k == 1 && this.a.F() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.y0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv6 a;

        public c(nv6 nv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && !this.a.a.j1().c0() && this.a.b.isShown() && this.a.a.isPrimary() && this.a.a.getActivity() != null && this.a.a.getActivity().getIntent() != null && !FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                this.a.t0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv6 a;

        public d(nv6 nv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nv6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof el) {
                ((el) view2).refresh();
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
    public nv6(FrsFragment frsFragment, kn6 kn6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kn6Var, frsHeaderViewContainer};
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
        this.d = kn6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new mv6(this.a, gen);
        this.o = new lv6(this.a);
        this.l = new n96();
    }

    public final void x(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048625, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            e0();
            if (this.c == null || z) {
                vv6 vv6Var = this.c;
                if (vv6Var != null) {
                    vv6Var.u();
                    this.c = null;
                }
                vv6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            mv6 mv6Var = this.n;
            if (mv6Var != null) {
                this.c.Q(mv6Var);
            }
            lv6 lv6Var = this.o;
            if (lv6Var != null) {
                this.c.O(lv6Var);
            }
            this.b.a(this.c.l());
            y(str);
            A0();
            u0();
        }
    }

    public static boolean I(FrsViewData frsViewData) {
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
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            mv6 mv6Var = this.n;
            if (mv6Var != null) {
                mv6Var.p();
            }
            lv6 lv6Var = this.o;
            if (lv6Var != null) {
                lv6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                vv6 vv6Var = this.c;
                if (vv6Var != null) {
                    this.b.d(vv6Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            vv6 vv6Var2 = this.c;
            if (vv6Var2 != null && vv6Var2.h() != null && !this.e) {
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

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && this.a.J0() != null && this.a.J0().W() != null) {
            int F = this.a.J0().W().F();
            int C = this.a.J0().W().C();
            int A = this.a.J0().W().A();
            gn8 i = gn8.i();
            gn8.i().n(i.g("1~" + str, F, C, A), false);
        }
    }

    public final float B(ForumData forumData) {
        InterceptResult invokeL;
        mv6 mv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData != null && (mv6Var = this.n) != null) {
                return mv6Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public void B0(boolean z) {
        lv6 lv6Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (lv6Var = this.o) != null) {
            vv6 vv6Var = this.c;
            if (vv6Var != null && vv6Var.q()) {
                z2 = true;
            } else {
                z2 = false;
            }
            lv6Var.m(z2);
            this.o.p(z);
        }
    }

    public boolean O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.g = i;
            vv6 vv6Var = this.c;
            if (vv6Var != null) {
                vv6Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void Q(boolean z) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (vv6Var = this.c) != null) {
            vv6Var.x(z);
        }
    }

    public void S(MotionEvent motionEvent) {
        n96 n96Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, motionEvent) == null) && (n96Var = this.l) != null) {
            n96Var.c(motionEvent);
        }
    }

    public void T(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, num) == null) {
            p0(num.intValue());
            if (F()) {
                Y();
            }
        }
    }

    public void W(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && frsViewData != null && F()) {
            V(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i) == null) && F()) {
            i0(i);
        }
    }

    public void a0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, frsViewData) == null) && frsViewData != null && this.c != null && F()) {
            this.c.A(B(frsViewData.getForum()));
        }
    }

    public void h0(int i) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && (vv6Var = this.c) != null && vv6Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.obfuscated_res_0x7f09081c);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.n();
        }
    }

    public void i0(int i) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && (vv6Var = this.c) != null) {
            vv6Var.J(i);
        }
    }

    public void m0(int i) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i) == null) && F() && (vv6Var = this.c) != null) {
            vv6Var.L(i);
        }
    }

    public void n0(FrsViewData frsViewData) {
        mv6 mv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, frsViewData) == null) && F() && (mv6Var = this.n) != null) {
            mv6Var.v(this.c, frsViewData);
        }
    }

    public void p0(int i) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048617, this, i) == null) && (vv6Var = this.c) != null) {
            vv6Var.P(i);
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            if (i > 1) {
                vv6 vv6Var = this.c;
                if (vv6Var != null) {
                    vv6Var.N(false);
                    return;
                }
                return;
            }
            vv6 vv6Var2 = this.c;
            if (vv6Var2 != null) {
                vv6Var2.N(true);
            }
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.i = i;
        }
    }

    public void s0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void x0(List<on8> list) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, list) == null) && (vv6Var = this.c) != null) {
            vv6Var.U(list);
        }
    }

    public void l0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048613, this, frsViewData, z) == null) && frsViewData != null && F()) {
            j0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void v0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048623, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            x(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (F() && (vv6Var = this.c) != null) {
                return vv6Var.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zg.a().postDelayed(this.q, 4000L);
        }
    }

    public lv6 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return (lv6) invokeV.objValue;
    }

    public void D() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.n();
        }
    }

    public void D0() {
        lv6 lv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (lv6Var = this.o) != null) {
            lv6Var.q();
        }
    }

    public void E() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.p();
        }
    }

    public boolean H() {
        InterceptResult invokeV;
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (F() && (vv6Var = this.c) != null) {
                return vv6Var.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            vv6 vv6Var = this.c;
            if (vv6Var != null) {
                vv6Var.z();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public void P() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.w();
        }
    }

    public void R() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.y();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.c.C();
        }
    }

    public void Y() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.Z();
        }
    }

    public void Z() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.s);
            this.b.postDelayed(this.s, 100L);
        }
    }

    public void b0() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.D();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            vv6 vv6Var = this.c;
            if (vv6Var != null) {
                this.b.d(vv6Var.l());
                this.b.d(this.c.h());
                f0();
            }
            this.e = false;
        }
    }

    public final void f0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.y3() != null) {
            this.a.y3().removeHeaderView(this.m.I());
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && F()) {
            i0(0);
        }
    }

    public void t0() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (vv6Var = this.c) != null) {
            vv6Var.T();
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            zg.a().postDelayed(this.r, 500L);
        }
    }

    public void w() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && !this.e && (vv6Var = this.c) != null) {
            this.b.a(vv6Var.h());
            this.e = true;
        }
    }

    public final void y0() {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && F() && (vv6Var = this.c) != null) {
            vv6Var.V();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (F() && (vv6Var = this.c) != null) {
                return vv6Var.m();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void C0() {
        mv6 mv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (mv6Var = this.n) != null) {
            vv6 vv6Var = this.c;
            if (vv6Var != null) {
                mv6Var.x(vv6Var.s(), this.c.e());
            } else {
                mv6Var.x(false, "");
            }
            vv6 vv6Var2 = this.c;
            if (vv6Var2 != null) {
                this.n.w(vv6Var2.k());
            }
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            vv6 vv6Var = this.c;
            if (vv6Var != null) {
                vv6Var.u();
            }
            lv6 lv6Var = this.o;
            if (lv6Var != null) {
                lv6Var.k();
            }
            if (this.q != null) {
                zg.a().removeCallbacks(this.q);
            }
            if (this.r != null) {
                zg.a().removeCallbacks(this.r);
            }
        }
    }

    public void E0(int i, int i2, int i3) {
        mv6 mv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048585, this, i, i2, i3) == null) && (mv6Var = this.n) != null) {
            mv6Var.y(i, i2, i3);
        }
    }

    public void V(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float B = B(forumData);
            vv6 vv6Var = this.c;
            if (vv6Var == null) {
                return;
            }
            vv6Var.H(forumData, frsViewData);
            this.c.K(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), B, false);
            this.c.M(forumData.getSignData());
        }
    }

    public void j0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        vv6 vv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (vv6Var = this.c) == null) {
            return;
        }
        vv6Var.H(forumData, frsViewData);
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
        RelativeLayout I;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.y3() == null || (I = this.m.I()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.y3().removeHeaderView(I);
            return;
        }
        this.a.y3().removeHeaderView(I);
        this.a.y3().t(I, 0);
    }
}
