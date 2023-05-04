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
public class wk7 extends y8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public il7 c;
    public ib7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public hq6 l;
    public FrsTabViewController m;
    public vk7 n;
    public uk7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk7 a;

        public a(wk7 wk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f0906ef);
            FrsViewData a1 = this.a.a.a1();
            if (a1 != null && a1.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && a1.getForum() != null) {
                    if (this.a.a.g4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", a1.getForum().getId());
                    statisticItem.param("fname", a1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    zg7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (a1.getEntelechyTabInfo() != null && a1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < a1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(a1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), a1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(a1.serviceAreaFlutterData);
                int baWuNoticeNum = a1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (a1.getUserData() != null) {
                    if (a1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    a1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (a1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (a1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (a1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0925c4 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f09260d && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090c63) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && a1 != null && a1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{a1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c04) {
                        if (a1 != null && a1.getUserData() != null && a1.getUserData().isBawu()) {
                            String bawuCenterUrl = a1.getBawuCenterUrl();
                            if (!hi.isEmpty(bawuCenterUrl)) {
                                pt4.s(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (a1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", a1.getForum().getId()).param("uid", a1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f09145f && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090c6e) {
                            if (a1 != null && a1.getForum() != null && !TextUtils.isEmpty(a1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(gg.g(a1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", a1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090cbd) {
                            if (a1 != null && a1.getForum() != null && !TextUtils.isEmpty(a1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(a1.getForum().getId()), a1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090cbc && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && a1 != null && a1.getForum() != null && !TextUtils.isEmpty(a1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> t = this.a.a.t();
                            urlManager.dealOneLink(t, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + a1.getForum().getId()});
                        }
                    } else if (!this.a.a.J3() && this.a.i == 0 && this.a.V() && this.a.c != null) {
                        this.a.c.U(view2, false);
                    }
                } else if (!this.a.a.J3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String N = this.a.N();
                        if (!TextUtils.isEmpty(N)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{N});
                            if (a1 != null && a1.getForum() != null && a1.getForum().getSignData() != null && a1.getForum().getSignData().chatRoomGuideData != null) {
                                j = a1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.S();
                        } else if (!this.a.P()) {
                            this.a.P0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), gg.e(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.J3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091151);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        zg7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.O0(true);
                    if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.w());
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
        public final /* synthetic */ wk7 a;

        public b(wk7 wk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wk7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            v67 w1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (w1 = this.a.a.w1()) != null && w1.c0() != null && !w1.c0().l() && !w1.e0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.l3() && this.a.k == 1 && this.a.V() && this.a.c != null && this.a.c.v()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.M0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk7 a;

        public c(wk7 wk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wk7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof qk) {
                ((qk) view2).refresh();
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
    public wk7(FrsFragment frsFragment, ib7 ib7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ib7Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
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
        this.d = ib7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new vk7(this.a, gen);
        this.o = new uk7(this.a);
        this.l = new hq6();
    }

    public final void K(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            u0();
            if (this.c == null || z) {
                il7 il7Var = this.c;
                if (il7Var != null) {
                    il7Var.w();
                    this.c = null;
                }
                il7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.I(this.p);
            }
            vk7 vk7Var = this.n;
            if (vk7Var != null) {
                this.c.S(vk7Var);
            }
            uk7 uk7Var = this.o;
            if (uk7Var != null) {
                this.c.Q(uk7Var);
            }
            this.b.a(this.c.m());
            M(str);
            N0();
        }
    }

    public void B0(int i) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && V() && (il7Var = this.c) != null) {
            il7Var.N(i);
        }
    }

    public void C0(FrsViewData frsViewData) {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) && V() && (vk7Var = this.n) != null) {
            vk7Var.v(this.c, frsViewData);
        }
    }

    public void E0(int i) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (il7Var = this.c) != null) {
            il7Var.R(i);
        }
    }

    public void H0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i > 1) {
                il7 il7Var = this.c;
                if (il7Var != null) {
                    il7Var.P(false);
                    return;
                }
                return;
            }
            il7 il7Var2 = this.c;
            if (il7Var2 != null) {
                il7Var2.P(true);
            }
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.i = i;
        }
    }

    public void J0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void L0(List<do9> list) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && (il7Var = this.c) != null) {
            il7Var.V(list);
        }
    }

    public void O0(boolean z) {
        uk7 uk7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (uk7Var = this.o) != null) {
            il7 il7Var = this.c;
            if (il7Var != null && il7Var.s()) {
                z2 = true;
            } else {
                z2 = false;
            }
            uk7Var.m(z2);
            this.o.p(z);
        }
    }

    public final float Q(ForumData forumData) {
        InterceptResult invokeL;
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, forumData)) == null) {
            if (forumData != null && (vk7Var = this.n) != null) {
                return vk7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean d0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            this.g = i;
            il7 il7Var = this.c;
            if (il7Var != null) {
                il7Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void f0(boolean z) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (il7Var = this.c) != null) {
            il7Var.z(z);
        }
    }

    public void h0(MotionEvent motionEvent) {
        hq6 hq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, motionEvent) == null) && (hq6Var = this.l) != null) {
            hq6Var.c(motionEvent);
        }
    }

    public void i0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, num) == null) {
            E0(num.intValue());
            if (V()) {
                o0();
            }
        }
    }

    public void m0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, frsViewData) == null) && frsViewData != null && V()) {
            l0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i) == null) && V()) {
            y0(i);
        }
    }

    public void q0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, frsViewData) == null) && frsViewData != null && this.c != null && V()) {
            this.c.C(Q(frsViewData.getForum()));
        }
    }

    public void x0(int i) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i) == null) && (il7Var = this.c) != null && il7Var.h() != null) {
            View findViewById = this.c.h().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.p();
        }
    }

    public void y0(int i) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048628, this, i) == null) && (il7Var = this.c) != null) {
            il7Var.L(i);
        }
    }

    public void A0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, frsViewData, z) == null) && frsViewData != null && V()) {
            z0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void K0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            K(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public static boolean Y(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            vk7 vk7Var = this.n;
            if (vk7Var != null) {
                vk7Var.p();
            }
            uk7 uk7Var = this.o;
            if (uk7Var != null) {
                uk7Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            if (z) {
                il7 il7Var = this.c;
                if (il7Var != null) {
                    this.b.d(il7Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            il7 il7Var2 = this.c;
            if (il7Var2 != null && il7Var2.h() != null && !this.e) {
                this.b.b(this.c.h(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean Z(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, frsViewData)) == null) {
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

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, str) == null) && this.a.T0() != null && this.a.T0().t0() != null) {
            int b0 = this.a.T0().t0().b0();
            int Y = this.a.T0().t0().Y();
            int W = this.a.T0().t0().W();
            vn9 i = vn9.i();
            vn9.i().n(i.g("1~" + str, b0, Y, W), false);
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && V()) {
            y0(0);
        }
    }

    public void J() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.e && (il7Var = this.c) != null) {
            this.b.a(il7Var.h());
            this.e = true;
        }
    }

    public final void M0() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && V() && (il7Var = this.c) != null) {
            il7Var.W();
        }
    }

    public String N() {
        InterceptResult invokeV;
        il7 il7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (V() && (il7Var = this.c) != null) {
                return il7Var.i();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            jg.a().postDelayed(this.q, 4000L);
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        il7 il7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (V() && (il7Var = this.c) != null) {
                return il7Var.o();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        il7 il7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (V() && (il7Var = this.c) != null) {
                return il7Var.j();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Q0() {
        uk7 uk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (uk7Var = this.o) != null) {
            uk7Var.q();
        }
    }

    public uk7 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.o;
        }
        return (uk7) invokeV.objValue;
    }

    public void S() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && V() && (il7Var = this.c) != null) {
            il7Var.n();
        }
    }

    public void T() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (il7Var = this.c) != null) {
            il7Var.p();
        }
    }

    public void U() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (il7Var = this.c) != null) {
            il7Var.r();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        il7 il7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (V() && (il7Var = this.c) != null) {
                return il7Var.t();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            il7 il7Var = this.c;
            if (il7Var != null) {
                il7Var.w();
            }
            uk7 uk7Var = this.o;
            if (uk7Var != null) {
                uk7Var.k();
            }
            if (this.q != null) {
                jg.a().removeCallbacks(this.q);
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            il7 il7Var = this.c;
            if (il7Var != null) {
                il7Var.B();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void e0() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (il7Var = this.c) != null) {
            il7Var.y();
        }
    }

    public void g0() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (il7Var = this.c) != null) {
            il7Var.A();
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.c.E();
        }
    }

    public void o0() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (il7Var = this.c) != null) {
            il7Var.a0();
        }
    }

    public void p0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void r0() {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (il7Var = this.c) != null) {
            il7Var.F();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            il7 il7Var = this.c;
            if (il7Var != null) {
                this.b.d(il7Var.m());
                this.b.d(this.c.h());
                v0();
            }
            this.e = false;
        }
    }

    public final void v0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.L3() != null) {
            this.a.L3().removeHeaderView(this.m.H());
        }
    }

    public final void M(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.L3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.L3().removeHeaderView(H);
            return;
        }
        this.a.L3().removeHeaderView(H);
        this.a.L3().addHeaderView(H, 0);
    }

    public void P0() {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (vk7Var = this.n) != null) {
            il7 il7Var = this.c;
            if (il7Var != null) {
                vk7Var.x(il7Var.u(), this.c.e());
            } else {
                vk7Var.x(false, "");
            }
            il7 il7Var2 = this.c;
            if (il7Var2 != null) {
                this.n.w(il7Var2.l());
            }
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R0(int i, int i2, int i3) {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048599, this, i, i2, i3) == null) && (vk7Var = this.n) != null) {
            vk7Var.y(i, i2, i3);
        }
    }

    public void l0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048616, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float Q = Q(forumData);
            il7 il7Var = this.c;
            if (il7Var == null) {
                return;
            }
            il7Var.J(forumData, frsViewData);
            this.c.M(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), Q, false);
            this.c.O(forumData.getSignData());
        }
    }

    public void z0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        il7 il7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (il7Var = this.c) == null) {
            return;
        }
        il7Var.J(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.M(i, forumData.getLevelName(), forumData.getUser_level(), Q(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }
}
