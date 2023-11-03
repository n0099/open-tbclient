package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
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
import com.baidu.tbadk.core.atomData.NewSupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ci8;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.unreadbawu.BawuUnreadRequestMessage;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.homepagecore.data.ForumSignInResultRespondedMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class m48 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public z48 c;
    public su7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public kv6 l;
    public FrsTabViewController m;
    public l48 n;
    public k48 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final HttpMessageListener r;
    public Runnable s;

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        public a(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object supplementSignActivityConfig;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090751);
            FrsViewData F1 = this.a.a.F1();
            if (F1 != null && F1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && F1.getForum() != null) {
                    if (this.a.a.X4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", F1.getForum().getId());
                    statisticItem.param("fname", F1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    g08.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (F1.getEntelechyTabInfo() != null && F1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < F1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(F1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), F1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(F1.serviceAreaFlutterData);
                int baWuNoticeNum = F1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (F1.getUserData() != null) {
                    if (F1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    F1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (F1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (F1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (F1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0927ac && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f0927f6 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090d12) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && F1 != null && F1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{F1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090cae) {
                        if (F1 != null && F1.getUserData() != null && F1.getUserData().isBawu()) {
                            String bawuCenterUrl = F1.getBawuCenterUrl();
                            if (!qd.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (F1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", F1.getForum().getId()).param("uid", F1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f091554 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090d1d) {
                            if (F1 != null && F1.getForum() != null && !TextUtils.isEmpty(F1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(F1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", F1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d6c) {
                            if (F1 != null && F1.getForum() != null && !TextUtils.isEmpty(F1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(F1.getForum().getId()), F1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d6b && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && F1 != null && F1.getForum() != null && !TextUtils.isEmpty(F1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> H = this.a.a.H();
                            urlManager.dealOneLink(H, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + F1.getForum().getId()});
                        }
                    } else if (!this.a.a.z4() && this.a.i == 0 && this.a.a0() && this.a.c != null) {
                        nu5.d(F1.getForum().getId(), F1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        ou5.c("c15281", F1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.z4()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e61);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String R = this.a.R();
                        if (!TextUtils.isEmpty(R)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{R});
                            if (F1 != null && F1.getForum() != null && F1.getForum().getSignData() != null && F1.getForum().getSignData().chatRoomGuideData != null) {
                                j = F1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.X();
                        } else if (!this.a.T()) {
                            this.a.Q0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            if (yi6.e("https://re_sign/")) {
                                supplementSignActivityConfig = new NewSupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002);
                            } else {
                                supplementSignActivityConfig = new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, supplementSignActivityConfig));
                        }
                    }
                }
            } else if (!this.a.a.z4()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e61);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091236);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        g08.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.P0(true);
                    if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        StatisticItem statisticItem3 = new StatisticItem("c10048");
                        statisticItem3.param("fid", this.a.a.w());
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        public b(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vp7 i2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || this.a.i != 0 || (i2 = this.a.a.i2()) == null || i2.c0() == null || i2.c0().m() || i2.e0() || !this.a.b.isShown() || !this.a.a.isPrimary()) {
                return;
            }
            if ((i2.b0() == null || !i2.b0().p()) && !this.a.j && this.a.a.c4() && this.a.k == 1 && this.a.a0() && this.a.c != null && this.a.c.w()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.N0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(m48 m48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var, Integer.valueOf(i)};
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
            this.a = m48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003577 && (httpResponsedMessage instanceof ForumSignInResultRespondedMessage)) {
                if (!httpResponsedMessage.hasError()) {
                    ci8 data = ((ForumSignInResultRespondedMessage) httpResponsedMessage).getData();
                    if (this.a.a != null && this.a.a.F1() != null) {
                        FrsViewData F1 = this.a.a.F1();
                        ci8.b Q = this.a.Q(F1, data);
                        if (Q != null) {
                            ci8.d c = Q.b().c();
                            ci8.a a = Q.b().a();
                            boolean b = Q.b().b();
                            SignData signData = F1.getSignData();
                            if (signData != null) {
                                signData.miss_sign_num = c.a();
                                signData.is_signed = c.b() ? 1 : 0;
                                if (b) {
                                    signData.showGuideToChatRoom = true;
                                    signData.chatRoomGuideData = new yw4(a.a(), a.c(), a.b());
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (this.a.o != null) {
                    this.a.o.i();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        public d(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m48Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof xf) {
                ((xf) view2).refresh();
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
    public m48(FrsFragment frsFragment, su7 su7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, su7Var, frsHeaderViewContainer};
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
        this.r = new c(this, CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
        this.s = new d(this);
        this.a = frsFragment;
        this.d = su7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new l48(this.a, gen);
        this.o = new k48(this.a);
        this.l = new kv6();
    }

    public final void O(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            x0();
            if (this.c == null || z) {
                z48 z48Var = this.c;
                if (z48Var != null) {
                    z48Var.y();
                    this.c = null;
                }
                z48 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.K(this.p);
            }
            l48 l48Var = this.n;
            if (l48Var != null) {
                this.c.T(l48Var);
            }
            k48 k48Var = this.o;
            if (k48Var != null) {
                this.c.R(k48Var);
            }
            this.b.a(this.c.n());
            P(str);
            O0();
        }
    }

    public void A0(int i) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (z48Var = this.c) != null && z48Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public void B0(int i) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (z48Var = this.c) != null) {
            z48Var.M(i);
        }
    }

    public void E0(int i) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && a0() && (z48Var = this.c) != null) {
            z48Var.O(i);
        }
    }

    public void F0(FrsViewData frsViewData) {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, frsViewData) == null) && a0() && (l48Var = this.n) != null) {
            l48Var.v(this.c, frsViewData);
        }
    }

    public void H0(int i) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (z48Var = this.c) != null) {
            z48Var.S(i);
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i > 1) {
                z48 z48Var = this.c;
                if (z48Var != null) {
                    z48Var.Q(false);
                    return;
                }
                return;
            }
            z48 z48Var2 = this.c;
            if (z48Var2 != null) {
                z48Var2.Q(true);
            }
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.i = i;
        }
    }

    public void K0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void M0(List<jqa> list) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && (z48Var = this.c) != null) {
            z48Var.V(list);
        }
    }

    public void P0(boolean z) {
        k48 k48Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (k48Var = this.o) != null) {
            z48 z48Var = this.c;
            if (z48Var != null && z48Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            k48Var.s(z2);
            this.o.v(z);
        }
    }

    public final float V(ForumData forumData) {
        InterceptResult invokeL;
        l48 l48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, forumData)) == null) {
            if (forumData != null && (l48Var = this.n) != null) {
                return l48Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean i0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) {
            this.g = i;
            z48 z48Var = this.c;
            if (z48Var != null) {
                z48Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void k0(boolean z) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (z48Var = this.c) != null) {
            z48Var.B(z);
        }
    }

    public void m0(MotionEvent motionEvent) {
        kv6 kv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, motionEvent) == null) && (kv6Var = this.l) != null) {
            kv6Var.c(motionEvent);
        }
    }

    public void n0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, num) == null) {
            H0(num.intValue());
            if (a0()) {
                s0();
            }
        }
    }

    public void q0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, frsViewData) == null) && frsViewData != null && a0()) {
            p0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.c();
            }
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i) == null) && a0()) {
            B0(i);
        }
    }

    public void u0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, frsViewData) == null) && frsViewData != null && this.c != null && a0()) {
            this.c.E(V(frsViewData.getForum()));
        }
    }

    public void S0(int i, int i2, int i3) {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048600, this, i, i2, i3) == null) && (l48Var = this.n) != null) {
            l48Var.y(i, i2, i3);
        }
    }

    public static boolean d0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, frsViewData)) == null) {
            if (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            if (z) {
                z48 z48Var = this.c;
                if (z48Var != null) {
                    this.b.d(z48Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            z48 z48Var2 = this.c;
            if (z48Var2 != null && z48Var2.i() != null && !this.e) {
                this.b.b(this.c.i(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean e0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, frsViewData)) == null) {
            if (frsViewData == null) {
                return false;
            }
            if ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && ((frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().d() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true))))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void w0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, str) == null) && this.a.y1() != null && this.a.y1().m0() != null) {
            int U = this.a.y1().m0().U();
            int R = this.a.y1().m0().R();
            int P = this.a.y1().m0().P();
            bqa i = bqa.i();
            bqa.i().n(i.g("1~" + str, U, R, P), false);
        }
    }

    public void D0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, frsViewData, z) == null) && frsViewData != null && a0()) {
            C0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void L0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            O(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void C0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (z48Var = this.c) == null) {
            return;
        }
        z48Var.L(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.N(i, forumData.getLevelName(), forumData.getUser_level(), V(forumData), z);
        this.c.P(forumData.getSignData());
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.b(false);
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && a0()) {
            B0(0);
        }
    }

    public void N() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.e && (z48Var = this.c) != null) {
            this.b.a(z48Var.i());
            this.e = true;
        }
    }

    public final void N0() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && a0() && (z48Var = this.c) != null) {
            z48Var.W();
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SafeHandler.getInst().postDelayed(this.q, 4000L);
        }
    }

    public String R() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (a0() && (z48Var = this.c) != null) {
                return z48Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void R0() {
        k48 k48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (k48Var = this.o) != null) {
            k48Var.w();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (a0() && (z48Var = this.c) != null) {
                return z48Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (a0() && (z48Var = this.c) != null) {
                return z48Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public z48 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.c;
        }
        return (z48) invokeV.objValue;
    }

    public k48 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.o;
        }
        return (k48) invokeV.objValue;
    }

    public void X() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && a0() && (z48Var = this.c) != null) {
            z48Var.o();
        }
    }

    public void Y() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (z48Var = this.c) != null) {
            z48Var.q();
        }
    }

    public void Z() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (z48Var = this.c) != null) {
            z48Var.s();
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        z48 z48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (a0() && (z48Var = this.c) != null) {
                return z48Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            z48 z48Var = this.c;
            if (z48Var != null) {
                z48Var.y();
            }
            k48 k48Var = this.o;
            if (k48Var != null) {
                k48Var.p();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            z48 z48Var = this.c;
            if (z48Var != null) {
                z48Var.D();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public void j0() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (z48Var = this.c) != null) {
            z48Var.A();
        }
    }

    public void l0() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (z48Var = this.c) != null) {
            z48Var.C();
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.c.G();
        }
    }

    public void s0() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (z48Var = this.c) != null) {
            z48Var.a0();
        }
    }

    public void t0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.s);
            this.b.postDelayed(this.s, 100L);
        }
    }

    public void v0() {
        z48 z48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (z48Var = this.c) != null) {
            z48Var.H();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            z48 z48Var = this.c;
            if (z48Var != null) {
                this.b.d(z48Var.n());
                this.b.d(this.c.i());
                y0();
            }
            this.e = false;
        }
    }

    public final void y0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.B4() != null) {
            this.a.B4().removeHeaderView(this.m.H());
        }
    }

    public final void P(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.B4() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.B4().removeHeaderView(H);
            return;
        }
        this.a.B4().removeHeaderView(H);
        this.a.B4().addHeaderView(H, 0);
    }

    public void f0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            l48 l48Var = this.n;
            if (l48Var != null) {
                l48Var.p();
            }
            k48 k48Var = this.o;
            if (k48Var != null) {
                k48Var.o();
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                frsFragment.registerListener(this.r);
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Nullable
    public final ci8.b Q(FrsViewData frsViewData, ci8 ci8Var) {
        InterceptResult invokeLL;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, frsViewData, ci8Var)) == null) {
            if (frsViewData != null && ci8Var != null && !ListUtils.isEmpty(ci8Var.a())) {
                if (frsViewData.getForum() == null) {
                    id = "";
                } else {
                    id = frsViewData.getForum().getId();
                }
                List<ci8.b> a2 = ci8Var.a();
                for (int i = 0; i < a2.size(); i++) {
                    ci8.b bVar = a2.get(i);
                    if (id.equals(String.valueOf(bVar.a()))) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (ci8.b) invokeLL.objValue;
    }

    public void Q0() {
        l48 l48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (l48Var = this.n) != null) {
            z48 z48Var = this.c;
            if (z48Var != null) {
                l48Var.x(z48Var.v(), this.c.f());
            } else {
                l48Var.x(false, "");
            }
            z48 z48Var2 = this.c;
            if (z48Var2 != null) {
                this.n.w(z48Var2.m());
            }
        }
    }

    public final boolean a0() {
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

    public void p0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float V = V(forumData);
            z48 z48Var = this.c;
            if (z48Var == null) {
                return;
            }
            z48Var.L(forumData, frsViewData);
            this.c.N(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), V, false);
            this.c.P(forumData.getSignData());
        }
    }
}
