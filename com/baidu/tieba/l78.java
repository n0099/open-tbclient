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
import com.baidu.tieba.el8;
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
public class l78 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public y78 c;
    public ix7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public zv6 l;
    public FrsTabViewController m;
    public k78 n;
    public j78 o;
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
        public final /* synthetic */ l78 a;

        public a(l78 l78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object supplementSignActivityConfig;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09076d);
            FrsViewData Q1 = this.a.a.Q1();
            if (Q1 != null && Q1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && Q1.getForum() != null) {
                    if (this.a.a.j5()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", Q1.getForum().getId());
                    statisticItem.param("fname", Q1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    a38.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (Q1.getEntelechyTabInfo() != null && Q1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < Q1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(Q1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), Q1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(Q1.serviceAreaFlutterData);
                int baWuNoticeNum = Q1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (Q1.getUserData() != null) {
                    if (Q1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    Q1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (Q1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (Q1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (Q1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f092832 && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f09287c && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090d33) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && Q1 != null && Q1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{Q1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090ccf) {
                        if (Q1 != null && Q1.getUserData() != null && Q1.getUserData().isBawu()) {
                            String bawuCenterUrl = Q1.getBawuCenterUrl();
                            if (!rd.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (Q1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", Q1.getForum().getId()).param("uid", Q1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f0915c6 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090d3e) {
                            if (Q1 != null && Q1.getForum() != null && !TextUtils.isEmpty(Q1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(Q1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", Q1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d8d) {
                            if (Q1 != null && Q1.getForum() != null && !TextUtils.isEmpty(Q1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(Q1.getForum().getId()), Q1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d8c && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && Q1 != null && Q1.getForum() != null && !TextUtils.isEmpty(Q1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> I = this.a.a.I();
                            urlManager.dealOneLink(I, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + Q1.getForum().getId()});
                        }
                    } else if (!this.a.a.L4() && this.a.i == 0 && this.a.a0() && this.a.c != null) {
                        av5.d(Q1.getForum().getId(), Q1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        bv5.c("c15281", Q1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.L4()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e70);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String R = this.a.R();
                        if (!TextUtils.isEmpty(R)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{R});
                            if (Q1 != null && Q1.getForum() != null && Q1.getForum().getSignData() != null && Q1.getForum().getSignData().chatRoomGuideData != null) {
                                j = Q1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.X();
                        } else if (!this.a.T()) {
                            this.a.Q0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            if (mj6.e("https://re_sign/")) {
                                supplementSignActivityConfig = new NewSupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002);
                            } else {
                                supplementSignActivityConfig = new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, supplementSignActivityConfig));
                        }
                    }
                }
            } else if (!this.a.a.L4()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e70);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f091260);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        a38.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.P0(true);
                    if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        public final /* synthetic */ l78 a;

        public b(l78 l78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l78Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ms7 u2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || this.a.i != 0 || (u2 = this.a.a.u2()) == null || u2.c0() == null || u2.c0().m() || u2.e0() || !this.a.b.isShown() || !this.a.a.isPrimary()) {
                return;
            }
            if ((u2.b0() == null || !u2.b0().p()) && !this.a.j && this.a.a.o4() && this.a.k == 1 && this.a.a0() && this.a.c != null && this.a.c.w()) {
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
        public final /* synthetic */ l78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l78 l78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l78Var, Integer.valueOf(i)};
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
            this.a = l78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003577 && (httpResponsedMessage instanceof ForumSignInResultRespondedMessage)) {
                if (!httpResponsedMessage.hasError()) {
                    el8 data = ((ForumSignInResultRespondedMessage) httpResponsedMessage).getData();
                    if (this.a.a != null && this.a.a.Q1() != null) {
                        FrsViewData Q1 = this.a.a.Q1();
                        el8.b Q = this.a.Q(Q1, data);
                        if (Q != null) {
                            el8.d c = Q.b().c();
                            el8.a a = Q.b().a();
                            boolean b = Q.b().b();
                            SignData signData = Q1.getSignData();
                            if (signData != null) {
                                signData.miss_sign_num = c.a();
                                signData.is_signed = c.b() ? 1 : 0;
                                if (b) {
                                    signData.showGuideToChatRoom = true;
                                    signData.chatRoomGuideData = new dx4(a.a(), a.c(), a.b());
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
        public final /* synthetic */ l78 a;

        public d(l78 l78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l78Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof yf) {
                ((yf) view2).refresh();
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
    public l78(FrsFragment frsFragment, ix7 ix7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ix7Var, frsHeaderViewContainer};
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
        this.d = ix7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new k78(this.a, gen);
        this.o = new j78(this.a);
        this.l = new zv6();
    }

    public final void O(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            x0();
            if (this.c == null || z) {
                y78 y78Var = this.c;
                if (y78Var != null) {
                    y78Var.y();
                    this.c = null;
                }
                y78 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.K(this.p);
            }
            k78 k78Var = this.n;
            if (k78Var != null) {
                this.c.T(k78Var);
            }
            j78 j78Var = this.o;
            if (j78Var != null) {
                this.c.R(j78Var);
            }
            this.b.a(this.c.n());
            P(str);
            O0();
        }
    }

    public void A0(int i) {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (y78Var = this.c) != null && y78Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public void B0(int i) {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (y78Var = this.c) != null) {
            y78Var.M(i);
        }
    }

    public void E0(int i) {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && a0() && (y78Var = this.c) != null) {
            y78Var.O(i);
        }
    }

    public void F0(FrsViewData frsViewData) {
        k78 k78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, frsViewData) == null) && a0() && (k78Var = this.n) != null) {
            k78Var.v(this.c, frsViewData);
        }
    }

    public void H0(int i) {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (y78Var = this.c) != null) {
            y78Var.S(i);
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i > 1) {
                y78 y78Var = this.c;
                if (y78Var != null) {
                    y78Var.Q(false);
                    return;
                }
                return;
            }
            y78 y78Var2 = this.c;
            if (y78Var2 != null) {
                y78Var2.Q(true);
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

    public void M0(List<cva> list) {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && (y78Var = this.c) != null) {
            y78Var.V(list);
        }
    }

    public void P0(boolean z) {
        j78 j78Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (j78Var = this.o) != null) {
            y78 y78Var = this.c;
            if (y78Var != null && y78Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            j78Var.t(z2);
            this.o.w(z);
        }
    }

    public final float V(ForumData forumData) {
        InterceptResult invokeL;
        k78 k78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, forumData)) == null) {
            if (forumData != null && (k78Var = this.n) != null) {
                return k78Var.l(forumData);
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
            y78 y78Var = this.c;
            if (y78Var != null) {
                y78Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void k0(boolean z) {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (y78Var = this.c) != null) {
            y78Var.B(z);
        }
    }

    public void m0(MotionEvent motionEvent) {
        zv6 zv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, motionEvent) == null) && (zv6Var = this.l) != null) {
            zv6Var.c(motionEvent);
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
        k78 k78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048600, this, i, i2, i3) == null) && (k78Var = this.n) != null) {
            k78Var.y(i, i2, i3);
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
                y78 y78Var = this.c;
                if (y78Var != null) {
                    this.b.d(y78Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            y78 y78Var2 = this.c;
            if (y78Var2 != null && y78Var2.i() != null && !this.e) {
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
        if ((interceptable == null || interceptable.invokeL(1048628, this, str) == null) && this.a.J1() != null && this.a.J1().m0() != null) {
            int U = this.a.J1().m0().U();
            int R = this.a.J1().m0().R();
            int P = this.a.J1().m0().P();
            uua i = uua.i();
            uua.i().n(i.g("1~" + str, U, R, P), false);
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
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (y78Var = this.c) == null) {
            return;
        }
        y78Var.L(forumData, frsViewData);
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
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.e && (y78Var = this.c) != null) {
            this.b.a(y78Var.i());
            this.e = true;
        }
    }

    public final void N0() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && a0() && (y78Var = this.c) != null) {
            y78Var.W();
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
        y78 y78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (a0() && (y78Var = this.c) != null) {
                return y78Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void R0() {
        j78 j78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (j78Var = this.o) != null) {
            j78Var.x();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        y78 y78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (a0() && (y78Var = this.c) != null) {
                return y78Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        y78 y78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (a0() && (y78Var = this.c) != null) {
                return y78Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public y78 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.c;
        }
        return (y78) invokeV.objValue;
    }

    public j78 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.o;
        }
        return (j78) invokeV.objValue;
    }

    public void X() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && a0() && (y78Var = this.c) != null) {
            y78Var.o();
        }
    }

    public void Y() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (y78Var = this.c) != null) {
            y78Var.q();
        }
    }

    public void Z() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (y78Var = this.c) != null) {
            y78Var.s();
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        y78 y78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (a0() && (y78Var = this.c) != null) {
                return y78Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            y78 y78Var = this.c;
            if (y78Var != null) {
                y78Var.y();
            }
            j78 j78Var = this.o;
            if (j78Var != null) {
                j78Var.q();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            y78 y78Var = this.c;
            if (y78Var != null) {
                y78Var.D();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public void j0() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (y78Var = this.c) != null) {
            y78Var.A();
        }
    }

    public void l0() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (y78Var = this.c) != null) {
            y78Var.C();
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.c.G();
        }
    }

    public void s0() {
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (y78Var = this.c) != null) {
            y78Var.a0();
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
        y78 y78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (y78Var = this.c) != null) {
            y78Var.H();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            y78 y78Var = this.c;
            if (y78Var != null) {
                this.b.d(y78Var.n());
                this.b.d(this.c.i());
                y0();
            }
            this.e = false;
        }
    }

    public final void y0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.N4() != null) {
            this.a.N4().removeHeaderView(this.m.H());
        }
    }

    public final void P(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.N4() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.N4().removeHeaderView(H);
            return;
        }
        this.a.N4().removeHeaderView(H);
        this.a.N4().addHeaderView(H, 0);
    }

    public void f0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            k78 k78Var = this.n;
            if (k78Var != null) {
                k78Var.p();
            }
            j78 j78Var = this.o;
            if (j78Var != null) {
                j78Var.p();
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                frsFragment.registerListener(this.r);
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Nullable
    public final el8.b Q(FrsViewData frsViewData, el8 el8Var) {
        InterceptResult invokeLL;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, frsViewData, el8Var)) == null) {
            if (frsViewData != null && el8Var != null && !ListUtils.isEmpty(el8Var.a())) {
                if (frsViewData.getForum() == null) {
                    id = "";
                } else {
                    id = frsViewData.getForum().getId();
                }
                List<el8.b> a2 = el8Var.a();
                for (int i = 0; i < a2.size(); i++) {
                    el8.b bVar = a2.get(i);
                    if (id.equals(String.valueOf(bVar.a()))) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (el8.b) invokeLL.objValue;
    }

    public void Q0() {
        k78 k78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (k78Var = this.n) != null) {
            y78 y78Var = this.c;
            if (y78Var != null) {
                k78Var.x(y78Var.v(), this.c.f());
            } else {
                k78Var.x(false, "");
            }
            y78 y78Var2 = this.c;
            if (y78Var2 != null) {
                this.n.w(y78Var2.m());
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
            y78 y78Var = this.c;
            if (y78Var == null) {
                return;
            }
            y78Var.L(forumData, frsViewData);
            this.c.N(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), V, false);
            this.c.P(forumData.getSignData());
        }
    }
}
