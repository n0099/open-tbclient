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
/* loaded from: classes4.dex */
public class jt6 extends p9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public rt6 c;
    public fl6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public j76 l;
    public FrsTabViewController m;
    public it6 n;
    public ht6 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final Runnable r;
    public Runnable s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt6 a;

        public a(jt6 jt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09064d);
            FrsViewData O0 = this.a.a.O0();
            if (O0 != null && O0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && O0.getForum() != null) {
                    int i = this.a.a.R3() ? 1 : 2;
                    statisticItem.param("fid", O0.getForum().getId());
                    statisticItem.param("fname", O0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    tq6.a(statisticItem);
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
            if (id == R.id.obfuscated_res_0x7f0923bd || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.w3()) {
                    return;
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.d()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fd9);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        tq6.d(this.a.a.d(), this.a.a.c());
                    }
                    this.a.B0(true);
                    if (dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c10048");
                    statisticItem2.param("fid", this.a.a.d());
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                }
            } else if (id == R.id.obfuscated_res_0x7f092401 || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.w3()) {
                    return;
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.A()) {
                        this.a.C0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), dh.e(this.a.a.d(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090b54) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || O0 == null || O0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{O0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090af6) {
                if (O0 == null || O0.getUserData() == null || !O0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = O0.getBawuCenterUrl();
                if (dj.isEmpty(bawuCenterUrl)) {
                    return;
                }
                lo4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (O0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", O0.getForum().getId()).param("uid", O0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f0912e3 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.w3() || this.a.i != 0 || !this.a.F() || this.a.c == null) {
                    return;
                }
                this.a.c.S(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b5f) {
                if (O0 == null || O0.getForum() == null || TextUtils.isEmpty(O0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(dh.g(O0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem3 = new StatisticItem("c13666");
                statisticItem3.param("fid", O0.getForum().getId());
                TiebaStatic.log(statisticItem3);
            } else if (id != R.id.obfuscated_res_0x7f090bae) {
                if (id != R.id.obfuscated_res_0x7f090bad || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || O0 == null || O0.getForum() == null || TextUtils.isEmpty(O0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> o = this.a.a.o();
                urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + O0.getForum().getId()});
            } else if (O0 != null && O0.getForum() != null && !TextUtils.isEmpty(O0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(O0.getForum().getId()), O0.getForum().getName())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt6 a;

        public b(jt6 jt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            wg6 j1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (j1 = this.a.a.j1()) != null && j1.Z() != null && !j1.Z().p() && !j1.b0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.X2() && this.a.k == 1 && this.a.F() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.y0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt6 a;

        public c(jt6 jt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.j1().b0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.t0();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt6 a;

        public d(jt6 jt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof ll) {
                ((ll) view2).refresh();
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
    public jt6(FrsFragment frsFragment, fl6 fl6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, fl6Var, frsHeaderViewContainer};
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
        this.d = fl6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new it6(this.a, gen);
        this.o = new ht6(this.a);
        this.l = new j76();
    }

    public static boolean I(FrsViewData frsViewData) {
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!F() || (rt6Var = this.c) == null) {
                return false;
            }
            return rt6Var.i();
        }
        return invokeV.booleanValue;
    }

    public final float B(ForumData forumData) {
        InterceptResult invokeL;
        it6 it6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumData)) == null) {
            if (forumData == null || (it6Var = this.n) == null) {
                return 0.0f;
            }
            return it6Var.l(forumData);
        }
        return invokeL.floatValue;
    }

    public void B0(boolean z) {
        ht6 ht6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (ht6Var = this.o) == null) {
            return;
        }
        rt6 rt6Var = this.c;
        ht6Var.m(rt6Var != null && rt6Var.q());
        this.o.p(z);
    }

    public ht6 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : (ht6) invokeV.objValue;
    }

    public void C0() {
        it6 it6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (it6Var = this.n) == null) {
            return;
        }
        rt6 rt6Var = this.c;
        if (rt6Var != null) {
            it6Var.x(rt6Var.s(), this.c.e());
        } else {
            it6Var.x(false, "");
        }
        rt6 rt6Var2 = this.c;
        if (rt6Var2 != null) {
            this.n.w(rt6Var2.k());
        }
    }

    public void D() {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.n();
    }

    public void D0() {
        ht6 ht6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ht6Var = this.o) == null) {
            return;
        }
        ht6Var.q();
    }

    public void E() {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.p();
    }

    public void E0(int i, int i2, int i3) {
        it6 it6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) || (it6Var = this.n) == null) {
            return;
        }
        it6Var.y(i, i2, i3);
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!F() || (rt6Var = this.c) == null) {
                return false;
            }
            return rt6Var.r();
        }
        return invokeV.booleanValue;
    }

    public void L(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            it6 it6Var = this.n;
            if (it6Var != null) {
                it6Var.p();
            }
            ht6 ht6Var = this.o;
            if (ht6Var != null) {
                ht6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            rt6 rt6Var = this.c;
            if (rt6Var != null) {
                rt6Var.u();
            }
            ht6 ht6Var = this.o;
            if (ht6Var != null) {
                ht6Var.k();
            }
            if (this.q != null) {
                gh.a().removeCallbacks(this.q);
            }
            if (this.r != null) {
                gh.a().removeCallbacks(this.r);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            rt6 rt6Var = this.c;
            if (rt6Var != null) {
                rt6Var.z();
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
            rt6 rt6Var = this.c;
            if (rt6Var != null) {
                rt6Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void P() {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.w();
    }

    public void Q(boolean z) {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.x(z);
    }

    public void R() {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.y();
    }

    public void S(MotionEvent motionEvent) {
        j76 j76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, motionEvent) == null) || (j76Var = this.l) == null) {
            return;
        }
        j76Var.c(motionEvent);
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
        rt6 rt6Var = this.c;
        if (rt6Var == null) {
            return;
        }
        rt6Var.H(forumData, frsViewData);
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.Z();
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.D();
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || this.a.J0() == null || this.a.J0().W() == null) {
            return;
        }
        int F = this.a.J0().W().F();
        int C = this.a.J0().W().C();
        int A = this.a.J0().W().A();
        bl8 i = bl8.i();
        bl8.i().n(i.g("1~" + str, F, C, A), false);
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            rt6 rt6Var = this.c;
            if (rt6Var != null) {
                this.b.d(rt6Var.l());
                this.b.d(this.c.h());
                f0();
            }
            this.e = false;
        }
    }

    public final void f0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.y3() == null) {
            return;
        }
        this.a.y3().removeHeaderView(this.m.I());
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (z) {
                rt6 rt6Var = this.c;
                if (rt6Var != null) {
                    this.b.d(rt6Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            rt6 rt6Var2 = this.c;
            if (rt6Var2 == null || rt6Var2.h() == null || this.e) {
                return;
            }
            this.b.b(this.c.h(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void h0(int i) {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i) == null) || (rt6Var = this.c) == null || rt6Var.h() == null) {
            return;
        }
        View findViewById = this.c.h().findViewById(R.id.obfuscated_res_0x7f090803);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.n();
    }

    public void i0(int i) {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.J(i);
    }

    public void j0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.H(forumData, frsViewData);
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i) == null) && F() && (rt6Var = this.c) != null) {
            rt6Var.L(i);
        }
    }

    public void n0(FrsViewData frsViewData) {
        it6 it6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, frsViewData) == null) && F() && (it6Var = this.n) != null) {
            it6Var.v(this.c, frsViewData);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && F()) {
            i0(0);
        }
    }

    public void p0(int i) {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.P(i);
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            if (i > 1) {
                rt6 rt6Var = this.c;
                if (rt6Var != null) {
                    rt6Var.N(false);
                    return;
                }
                return;
            }
            rt6 rt6Var2 = this.c;
            if (rt6Var2 != null) {
                rt6Var2.N(true);
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.T();
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            gh.a().postDelayed(this.r, 500L);
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
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.e || (rt6Var = this.c) == null) {
            return;
        }
        this.b.a(rt6Var.h());
        this.e = true;
    }

    public void w0(List<jl8> list) {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || (rt6Var = this.c) == null) {
            return;
        }
        rt6Var.U(list);
    }

    public final void x(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048625, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            e0();
            if (this.c == null || z) {
                rt6 rt6Var = this.c;
                if (rt6Var != null) {
                    rt6Var.u();
                    this.c = null;
                }
                rt6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            it6 it6Var = this.n;
            if (it6Var != null) {
                this.c.Q(it6Var);
            }
            ht6 ht6Var = this.o;
            if (ht6Var != null) {
                this.c.O(ht6Var);
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
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.y3() == null || (I = this.m.I()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.y3().removeHeaderView(I);
            return;
        }
        this.a.y3().removeHeaderView(I);
        this.a.y3().t(I, 0);
    }

    public final void y0() {
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && F() && (rt6Var = this.c) != null) {
            rt6Var.V();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        rt6 rt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (!F() || (rt6Var = this.c) == null) {
                return false;
            }
            return rt6Var.m();
        }
        return invokeV.booleanValue;
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            gh.a().postDelayed(this.q, 4000L);
        }
    }
}
