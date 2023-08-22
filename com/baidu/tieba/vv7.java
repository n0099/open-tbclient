package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
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
/* loaded from: classes8.dex */
public class vv7 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public hw7 c;
    public wl7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public by6 l;
    public FrsTabViewController m;
    public uv7 n;
    public tv7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv7 a;

        public a(vv7 vv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09072a);
            FrsViewData l1 = this.a.a.l1();
            if (l1 != null && l1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && l1.getForum() != null) {
                    if (this.a.a.y4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", l1.getForum().getId());
                    statisticItem.param("fname", l1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    sr7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (l1.getEntelechyTabInfo() != null && l1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < l1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(l1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), l1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(l1.serviceAreaFlutterData);
                int baWuNoticeNum = l1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (l1.getUserData() != null) {
                    if (l1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    l1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (l1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (l1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (l1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f092759 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f0927a4 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090cd3) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && l1 != null && l1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{l1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c74) {
                        if (l1 != null && l1.getUserData() != null && l1.getUserData().isBawu()) {
                            String bawuCenterUrl = l1.getBawuCenterUrl();
                            if (!di.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (l1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", l1.getForum().getId()).param("uid", l1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f091507 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090cde) {
                            if (l1 != null && l1.getForum() != null && !TextUtils.isEmpty(l1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(l1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", l1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d2d) {
                            if (l1 != null && l1.getForum() != null && !TextUtils.isEmpty(l1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(l1.getForum().getId()), l1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d2c && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && l1 != null && l1.getForum() != null && !TextUtils.isEmpty(l1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> u = this.a.a.u();
                            urlManager.dealOneLink(u, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + l1.getForum().getId()});
                        }
                    } else if (!this.a.a.Z3() && this.a.i == 0 && this.a.Z() && this.a.c != null) {
                        ox5.d(l1.getForum().getId(), l1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        px5.c("c15281", l1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.Z3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e29);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String P = this.a.P();
                        if (!TextUtils.isEmpty(P)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{P});
                            if (l1 != null && l1.getForum() != null && l1.getForum().getSignData() != null && l1.getForum().getSignData().chatRoomGuideData != null) {
                                j = l1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.W();
                        } else if (!this.a.R()) {
                            this.a.T0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.Z3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e29);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0911e9);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        sr7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.R0(true);
                    if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.w());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv7 a;

        public b(vv7 vv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            eh7 L1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || this.a.i != 0 || (L1 = this.a.a.L1()) == null || L1.c0() == null || L1.c0().m() || L1.e0() || !this.a.b.isShown() || !this.a.a.isPrimary()) {
                return;
            }
            if ((L1.b0() == null || !L1.b0().p()) && !this.a.j && this.a.a.C3() && this.a.k == 1 && this.a.Z() && this.a.c != null && this.a.c.w()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.O0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv7 a;

        public c(vv7 vv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof kk) {
                ((kk) view2).refresh();
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
    public vv7(FrsFragment frsFragment, wl7 wl7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, wl7Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
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
        this.d = wl7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new uv7(this.a, gen);
        this.o = new tv7(this.a);
        this.l = new by6();
    }

    public final void N(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            x0();
            if (this.c == null || z) {
                hw7 hw7Var = this.c;
                if (hw7Var != null) {
                    hw7Var.x();
                    this.c = null;
                }
                hw7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.J(this.p);
            }
            uv7 uv7Var = this.n;
            if (uv7Var != null) {
                this.c.S(uv7Var);
            }
            tv7 tv7Var = this.o;
            if (tv7Var != null) {
                this.c.Q(tv7Var);
            }
            this.b.a(this.c.n());
            O(str);
            P0();
        }
    }

    public void A0(int i) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (hw7Var = this.c) != null && hw7Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public void C0(int i) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (hw7Var = this.c) != null) {
            hw7Var.L(i);
        }
    }

    public void F0(int i) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && Z() && (hw7Var = this.c) != null) {
            hw7Var.N(i);
        }
    }

    public void G0(FrsViewData frsViewData) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, frsViewData) == null) && Z() && (uv7Var = this.n) != null) {
            uv7Var.v(this.c, frsViewData);
        }
    }

    public void I0(int i) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (hw7Var = this.c) != null) {
            hw7Var.R(i);
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i > 1) {
                hw7 hw7Var = this.c;
                if (hw7Var != null) {
                    hw7Var.P(false);
                    return;
                }
                return;
            }
            hw7 hw7Var2 = this.c;
            if (hw7Var2 != null) {
                hw7Var2.P(true);
            }
        }
    }

    public void K0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.i = i;
        }
    }

    public void L0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void N0(List<pea> list) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, list) == null) && (hw7Var = this.c) != null) {
            hw7Var.U(list);
        }
    }

    public void R0(boolean z) {
        tv7 tv7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (tv7Var = this.o) != null) {
            hw7 hw7Var = this.c;
            if (hw7Var != null && hw7Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            tv7Var.m(z2);
            this.o.p(z);
        }
    }

    public final float T(ForumData forumData) {
        InterceptResult invokeL;
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, forumData)) == null) {
            if (forumData != null && (uv7Var = this.n) != null) {
                return uv7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean h0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            this.g = i;
            hw7 hw7Var = this.c;
            if (hw7Var != null) {
                hw7Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void j0(boolean z) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (hw7Var = this.c) != null) {
            hw7Var.A(z);
        }
    }

    public void l0(MotionEvent motionEvent) {
        by6 by6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, motionEvent) == null) && (by6Var = this.l) != null) {
            by6Var.c(motionEvent);
        }
    }

    public void m0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, num) == null) {
            I0(num.intValue());
            if (Z()) {
                r0();
            }
        }
    }

    public void p0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, frsViewData) == null) && frsViewData != null && Z()) {
            o0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && Z()) {
            C0(i);
        }
    }

    public void u0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, frsViewData) == null) && frsViewData != null && this.c != null && Z()) {
            this.c.D(T(frsViewData.getForum()));
        }
    }

    public static boolean c0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            uv7 uv7Var = this.n;
            if (uv7Var != null) {
                uv7Var.p();
            }
            tv7 tv7Var = this.o;
            if (tv7Var != null) {
                tv7Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            if (z) {
                hw7 hw7Var = this.c;
                if (hw7Var != null) {
                    this.b.d(hw7Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            hw7 hw7Var2 = this.c;
            if (hw7Var2 != null && hw7Var2.i() != null && !this.e) {
                this.b.b(this.c.i(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean d0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, frsViewData)) == null) {
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

    public void w0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, str) == null) && this.a.e1() != null && this.a.e1().l0() != null) {
            int T2 = this.a.e1().l0().T();
            int Q = this.a.e1().l0().Q();
            int O = this.a.e1().l0().O();
            hea i = hea.i();
            hea.i().n(i.g("1~" + str, T2, Q, O), false);
        }
    }

    public void E0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, frsViewData, z) == null) && frsViewData != null && Z()) {
            D0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void M0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            N(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void D0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (hw7Var = this.c) == null) {
            return;
        }
        hw7Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.M(i, forumData.getLevelName(), forumData.getUser_level(), T(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && Z()) {
            C0(0);
        }
    }

    public void M() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.e && (hw7Var = this.c) != null) {
            this.b.a(hw7Var.i());
            this.e = true;
        }
    }

    public final void O0() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && Z() && (hw7Var = this.c) != null) {
            hw7Var.V();
        }
    }

    public String P() {
        InterceptResult invokeV;
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (Z() && (hw7Var = this.c) != null) {
                return hw7Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SafeHandler.getInst().postDelayed(this.q, 4000L);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Z() && (hw7Var = this.c) != null) {
                return hw7Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (Z() && (hw7Var = this.c) != null) {
                return hw7Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public hw7 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c;
        }
        return (hw7) invokeV.objValue;
    }

    public tv7 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.o;
        }
        return (tv7) invokeV.objValue;
    }

    public void U0() {
        tv7 tv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (tv7Var = this.o) != null) {
            tv7Var.q();
        }
    }

    public void W() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && Z() && (hw7Var = this.c) != null) {
            hw7Var.o();
        }
    }

    public void X() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (hw7Var = this.c) != null) {
            hw7Var.q();
        }
    }

    public void Y() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (hw7Var = this.c) != null) {
            hw7Var.s();
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (Z() && (hw7Var = this.c) != null) {
                return hw7Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            hw7 hw7Var = this.c;
            if (hw7Var != null) {
                hw7Var.x();
            }
            tv7 tv7Var = this.o;
            if (tv7Var != null) {
                tv7Var.k();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            hw7 hw7Var = this.c;
            if (hw7Var != null) {
                hw7Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void i0() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (hw7Var = this.c) != null) {
            hw7Var.z();
        }
    }

    public void k0() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (hw7Var = this.c) != null) {
            hw7Var.B();
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.c.F();
        }
    }

    public void r0() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (hw7Var = this.c) != null) {
            hw7Var.Z();
        }
    }

    public void t0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void v0() {
        hw7 hw7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (hw7Var = this.c) != null) {
            hw7Var.G();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            hw7 hw7Var = this.c;
            if (hw7Var != null) {
                this.b.d(hw7Var.n());
                this.b.d(this.c.i());
                y0();
            }
            this.e = false;
        }
    }

    public final void y0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.c4() != null) {
            this.a.c4().removeHeaderView(this.m.H());
        }
    }

    public final void O(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.c4() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.c4().removeHeaderView(H);
            return;
        }
        this.a.c4().removeHeaderView(H);
        this.a.c4().addHeaderView(H, 0);
    }

    public void T0() {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (uv7Var = this.n) != null) {
            hw7 hw7Var = this.c;
            if (hw7Var != null) {
                uv7Var.x(hw7Var.v(), this.c.f());
            } else {
                uv7Var.x(false, "");
            }
            hw7 hw7Var2 = this.c;
            if (hw7Var2 != null) {
                this.n.w(hw7Var2.m());
            }
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V0(int i, int i2, int i3) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048603, this, i, i2, i3) == null) && (uv7Var = this.n) != null) {
            uv7Var.y(i, i2, i3);
        }
    }

    public void o0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048620, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float T2 = T(forumData);
            hw7 hw7Var = this.c;
            if (hw7Var == null) {
                return;
            }
            hw7Var.K(forumData, frsViewData);
            this.c.M(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), T2, false);
            this.c.O(forumData.getSignData());
        }
    }
}
