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
public class zt7 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public lu7 c;
    public ak7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public mw6 l;
    public FrsTabViewController m;
    public yt7 n;
    public xt7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public Runnable r;

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public a(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090726);
            FrsViewData d1 = this.a.a.d1();
            if (d1 != null && d1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && d1.getForum() != null) {
                    if (this.a.a.m4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", d1.getForum().getId());
                    statisticItem.param("fname", d1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    wp7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (d1.getEntelechyTabInfo() != null && d1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < d1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(d1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), d1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(d1.serviceAreaFlutterData);
                int baWuNoticeNum = d1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (d1.getUserData() != null) {
                    if (d1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    d1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (d1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (d1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (d1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f092722 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f09276d && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090cc6) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && d1 != null && d1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{d1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c67) {
                        if (d1 != null && d1.getUserData() != null && d1.getUserData().isBawu()) {
                            String bawuCenterUrl = d1.getBawuCenterUrl();
                            if (!bi.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (d1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", d1.getForum().getId()).param("uid", d1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f0914f0 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090cd1) {
                            if (d1 != null && d1.getForum() != null && !TextUtils.isEmpty(d1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(d1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", d1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d20) {
                            if (d1 != null && d1.getForum() != null && !TextUtils.isEmpty(d1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(d1.getForum().getId()), d1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d1f && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && d1 != null && d1.getForum() != null && !TextUtils.isEmpty(d1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> u = this.a.a.u();
                            urlManager.dealOneLink(u, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + d1.getForum().getId()});
                        }
                    } else if (!this.a.a.N3() && this.a.i == 0 && this.a.Z() && this.a.c != null) {
                        ww5.d(d1.getForum().getId(), d1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        xw5.c("c15281", d1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.N3()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String Q = this.a.Q();
                        if (!TextUtils.isEmpty(Q)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{Q});
                            if (d1 != null && d1.getForum() != null && d1.getForum().getSignData() != null && d1.getForum().getSignData().chatRoomGuideData != null) {
                                j = d1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.W();
                        } else if (!this.a.S()) {
                            this.a.T0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002)));
                        }
                    }
                }
            } else if (!this.a.a.N3()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0911d3);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        wp7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.S0(true);
                    if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        public final /* synthetic */ zt7 a;

        public b(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            mf7 z1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (z1 = this.a.a.z1()) != null && z1.c0() != null && !z1.c0().l() && !z1.e0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.q3() && this.a.k == 1 && this.a.Z() && this.a.c != null && this.a.c.w()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.Q0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public c(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof hk) {
                ((hk) view2).refresh();
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
    public zt7(FrsFragment frsFragment, ak7 ak7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ak7Var, frsHeaderViewContainer};
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
        this.d = ak7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new yt7(this.a, gen);
        this.o = new xt7(this.a);
        this.l = new mw6();
    }

    public final void O(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            y0();
            if (this.c == null || z) {
                lu7 lu7Var = this.c;
                if (lu7Var != null) {
                    lu7Var.x();
                    this.c = null;
                }
                lu7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.J(this.p);
            }
            yt7 yt7Var = this.n;
            if (yt7Var != null) {
                this.c.S(yt7Var);
            }
            xt7 xt7Var = this.o;
            if (xt7Var != null) {
                this.c.Q(xt7Var);
            }
            this.b.a(this.c.n());
            P(str);
            R0();
        }
    }

    public void B0(int i) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (lu7Var = this.c) != null && lu7Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public void C0(int i) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (lu7Var = this.c) != null) {
            lu7Var.L(i);
        }
    }

    public void F0(int i) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && Z() && (lu7Var = this.c) != null) {
            lu7Var.N(i);
        }
    }

    public void G0(FrsViewData frsViewData) {
        yt7 yt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, frsViewData) == null) && Z() && (yt7Var = this.n) != null) {
            yt7Var.v(this.c, frsViewData);
        }
    }

    public void J0(int i) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (lu7Var = this.c) != null) {
            lu7Var.R(i);
        }
    }

    public void L0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i > 1) {
                lu7 lu7Var = this.c;
                if (lu7Var != null) {
                    lu7Var.P(false);
                    return;
                }
                return;
            }
            lu7 lu7Var2 = this.c;
            if (lu7Var2 != null) {
                lu7Var2.P(true);
            }
        }
    }

    public void M0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i = i;
        }
    }

    public void N0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void P0(List<gaa> list) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, list) == null) && (lu7Var = this.c) != null) {
            lu7Var.U(list);
        }
    }

    public void S0(boolean z) {
        xt7 xt7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && (xt7Var = this.o) != null) {
            lu7 lu7Var = this.c;
            if (lu7Var != null && lu7Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            xt7Var.m(z2);
            this.o.p(z);
        }
    }

    public final float U(ForumData forumData) {
        InterceptResult invokeL;
        yt7 yt7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, forumData)) == null) {
            if (forumData != null && (yt7Var = this.n) != null) {
                return yt7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean h0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) {
            this.g = i;
            lu7 lu7Var = this.c;
            if (lu7Var != null) {
                lu7Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void j0(boolean z) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (lu7Var = this.c) != null) {
            lu7Var.A(z);
        }
    }

    public void l0(MotionEvent motionEvent) {
        mw6 mw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, motionEvent) == null) && (mw6Var = this.l) != null) {
            mw6Var.c(motionEvent);
        }
    }

    public void n0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, num) == null) {
            J0(num.intValue());
            if (Z()) {
                s0();
            }
        }
    }

    public void q0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, frsViewData) == null) && frsViewData != null && Z()) {
            p0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i) == null) && Z()) {
            C0(i);
        }
    }

    public void v0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, frsViewData) == null) && frsViewData != null && this.c != null && Z()) {
            this.c.D(U(frsViewData.getForum()));
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

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                lu7 lu7Var = this.c;
                if (lu7Var != null) {
                    this.b.d(lu7Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            lu7 lu7Var2 = this.c;
            if (lu7Var2 != null && lu7Var2.i() != null && !this.e) {
                this.b.b(this.c.i(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public void e0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            yt7 yt7Var = this.n;
            if (yt7Var != null) {
                yt7Var.p();
            }
            xt7 xt7Var = this.o;
            if (xt7Var != null) {
                xt7Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
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

    public void x0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, str) == null) && this.a.W0() != null && this.a.W0().l0() != null) {
            int T2 = this.a.W0().l0().T();
            int Q = this.a.W0().l0().Q();
            int O = this.a.W0().l0().O();
            y9a i = y9a.i();
            y9a.i().n(i.g("1~" + str, T2, Q, O), false);
        }
    }

    public void E0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, frsViewData, z) == null) && frsViewData != null && Z()) {
            D0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void O0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            O(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void D0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (lu7Var = this.c) == null) {
            return;
        }
        lu7Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.M(i, forumData.getLevelName(), forumData.getUser_level(), U(forumData), z);
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.a(false);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && Z()) {
            C0(0);
        }
    }

    public void N() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.e && (lu7Var = this.c) != null) {
            this.b.a(lu7Var.i());
            this.e = true;
        }
    }

    public String Q() {
        InterceptResult invokeV;
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (Z() && (lu7Var = this.c) != null) {
                return lu7Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void Q0() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && Z() && (lu7Var = this.c) != null) {
            lu7Var.V();
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (Z() && (lu7Var = this.c) != null) {
                return lu7Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            SafeHandler.getInst().postDelayed(this.q, 4000L);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (Z() && (lu7Var = this.c) != null) {
                return lu7Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public lu7 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c;
        }
        return (lu7) invokeV.objValue;
    }

    public void U0() {
        xt7 xt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (xt7Var = this.o) != null) {
            xt7Var.q();
        }
    }

    public xt7 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.o;
        }
        return (xt7) invokeV.objValue;
    }

    public void W() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && Z() && (lu7Var = this.c) != null) {
            lu7Var.o();
        }
    }

    public void X() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (lu7Var = this.c) != null) {
            lu7Var.q();
        }
    }

    public void Y() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (lu7Var = this.c) != null) {
            lu7Var.s();
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (Z() && (lu7Var = this.c) != null) {
                return lu7Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            lu7 lu7Var = this.c;
            if (lu7Var != null) {
                lu7Var.x();
            }
            xt7 xt7Var = this.o;
            if (xt7Var != null) {
                xt7Var.k();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            lu7 lu7Var = this.c;
            if (lu7Var != null) {
                lu7Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public void i0() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (lu7Var = this.c) != null) {
            lu7Var.z();
        }
    }

    public void k0() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (lu7Var = this.c) != null) {
            lu7Var.B();
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.c.F();
        }
    }

    public void s0() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (lu7Var = this.c) != null) {
            lu7Var.Z();
        }
    }

    public void t0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.b.postDelayed(this.r, 100L);
        }
    }

    public void w0() {
        lu7 lu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (lu7Var = this.c) != null) {
            lu7Var.G();
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            lu7 lu7Var = this.c;
            if (lu7Var != null) {
                this.b.d(lu7Var.n());
                this.b.d(this.c.i());
                z0();
            }
            this.e = false;
        }
    }

    public final void z0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.Q3() != null) {
            this.a.Q3().removeHeaderView(this.m.H());
        }
    }

    public final void P(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.Q3() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.Q3().removeHeaderView(H);
            return;
        }
        this.a.Q3().removeHeaderView(H);
        this.a.Q3().addHeaderView(H, 0);
    }

    public void T0() {
        yt7 yt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (yt7Var = this.n) != null) {
            lu7 lu7Var = this.c;
            if (lu7Var != null) {
                yt7Var.x(lu7Var.v(), this.c.f());
            } else {
                yt7Var.x(false, "");
            }
            lu7 lu7Var2 = this.c;
            if (lu7Var2 != null) {
                this.n.w(lu7Var2.m());
            }
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V0(int i, int i2, int i3) {
        yt7 yt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048604, this, i, i2, i3) == null) && (yt7Var = this.n) != null) {
            yt7Var.y(i, i2, i3);
        }
    }

    public void p0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float U = U(forumData);
            lu7 lu7Var = this.c;
            if (lu7Var == null) {
                return;
            }
            lu7Var.K(forumData, frsViewData);
            this.c.M(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), U, false);
            this.c.O(forumData.getSignData());
        }
    }
}
