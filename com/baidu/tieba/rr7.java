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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.unreadbawu.BawuUnreadRequestMessage;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.h58;
import com.baidu.tieba.homepagecore.data.ForumSignInResultRespondedMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class rr7 extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public es7 c;
    public yh7 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public ut6 l;
    public FrsTabViewController m;
    public qr7 n;
    public pr7 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final HttpMessageListener r;
    public Runnable s;

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr7 a;

        public a(rr7 rr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rr7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object supplementSignActivityConfig;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090732);
            FrsViewData s1 = this.a.a.s1();
            if (s1 != null && s1.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.l() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && s1.getForum() != null) {
                    if (this.a.a.G4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    statisticItem.param("fid", s1.getForum().getId());
                    statisticItem.param("fname", s1.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    mn7.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (s1.getEntelechyTabInfo() != null && s1.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < s1.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(s1.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), s1.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(s1.serviceAreaFlutterData);
                int baWuNoticeNum = s1.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (s1.getUserData() != null) {
                    if (s1.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    s1.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (s1.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (s1.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (s1.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f09274d && logicField != LogicField.LIKE_BTN) {
                long j = 0;
                if (id != R.id.obfuscated_res_0x7f092797 && logicField != LogicField.SIGN_BTN) {
                    if (id == R.id.obfuscated_res_0x7f090cdf) {
                        if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && s1 != null && s1.getGameUrl() != null) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{s1.getGameUrl()}, true);
                        }
                    } else if (id == R.id.obfuscated_res_0x7f090c80) {
                        if (s1 != null && s1.getUserData() != null && s1.getUserData().isBawu()) {
                            String bawuCenterUrl = s1.getBawuCenterUrl();
                            if (!ad.isEmpty(bawuCenterUrl)) {
                                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (s1.getForum() != null) {
                                    TiebaStatic.log(new StatisticItem("c10502").param("fid", s1.getForum().getId()).param("uid", s1.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id != R.id.obfuscated_res_0x7f091515 && logicField != LogicField.LEVEL_AND_LEVEL_NAME) {
                        if (id == R.id.obfuscated_res_0x7f090cea) {
                            if (s1 != null && s1.getForum() != null && !TextUtils.isEmpty(s1.getForum().getId())) {
                                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                                hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(s1.getForum().getId(), 0L)));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                                StatisticItem statisticItem2 = new StatisticItem("c13666");
                                statisticItem2.param("fid", s1.getForum().getId());
                                TiebaStatic.log(statisticItem2);
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d39) {
                            if (s1 != null && s1.getForum() != null && !TextUtils.isEmpty(s1.getForum().getId())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(s1.getForum().getId()), s1.getForum().getName())));
                            }
                        } else if (id == R.id.obfuscated_res_0x7f090d38 && ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) && s1 != null && s1.getForum() != null && !TextUtils.isEmpty(s1.getForum().getId())) {
                            UrlManager urlManager = UrlManager.getInstance();
                            TbPageContext<?> D = this.a.a.D();
                            urlManager.dealOneLink(D, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + s1.getForum().getId()});
                        }
                    } else if (!this.a.a.h4() && this.a.i == 0 && this.a.W() && this.a.c != null) {
                        ts5.d(s1.getForum().getId(), s1.getUserData().getPortrait(), "1", this.a.mContext.getPageActivity());
                        us5.c("c15281", s1.getForum().getId(), "1");
                    }
                } else if (!this.a.a.h4()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                        String N = this.a.N();
                        if (!TextUtils.isEmpty(N)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{N});
                            if (s1 != null && s1.getForum() != null && s1.getForum().getSignData() != null && s1.getForum().getSignData().chatRoomGuideData != null) {
                                j = s1.getForum().getSignData().chatRoomGuideData.a();
                            }
                            TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.a.w()).param("fname", this.a.a.v()).param("room_id", j));
                            this.a.T();
                        } else if (!this.a.P()) {
                            this.a.N0();
                            StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            if (ch6.e("https://re_sign/")) {
                                supplementSignActivityConfig = new NewSupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002);
                            } else {
                                supplementSignActivityConfig = new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), JavaTypesHelper.toInt(this.a.a.w(), 0), 24002);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, supplementSignActivityConfig));
                        }
                    }
                }
            } else if (!this.a.a.h4()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.w()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f0911f8);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        mn7.d(this.a.a.w(), this.a.a.v());
                    }
                    this.a.M0(true);
                    if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        public final /* synthetic */ rr7 a;

        public b(rr7 rr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rr7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ed7 R1;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || this.a.i != 0 || (R1 = this.a.a.R1()) == null || R1.d0() == null || R1.d0().m() || R1.f0() || !this.a.b.isShown() || !this.a.a.isPrimary()) {
                return;
            }
            if ((R1.c0() == null || !R1.c0().p()) && !this.a.j && this.a.a.K3() && this.a.k == 1 && this.a.W() && this.a.c != null && this.a.c.w()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.K0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(rr7 rr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var, Integer.valueOf(i)};
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
            this.a = rr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003577 && (httpResponsedMessage instanceof ForumSignInResultRespondedMessage)) {
                if (!httpResponsedMessage.hasError()) {
                    h58 data = ((ForumSignInResultRespondedMessage) httpResponsedMessage).getData();
                    if (this.a.a != null && this.a.a.s1() != null) {
                        FrsViewData s1 = this.a.a.s1();
                        h58.b M = this.a.M(s1, data);
                        if (M != null) {
                            h58.d c = M.b().c();
                            h58.a a = M.b().a();
                            boolean b = M.b().b();
                            SignData signData = s1.getSignData();
                            if (signData != null) {
                                signData.miss_sign_num = c.a();
                                signData.is_signed = c.b() ? 1 : 0;
                                if (b) {
                                    signData.showGuideToChatRoom = true;
                                    signData.chatRoomGuideData = new gw4(a.a(), a.c(), a.b());
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

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr7 a;

        public d(rr7 rr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rr7Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (view2 instanceof hf) {
                ((hf) view2).refresh();
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
    public rr7(FrsFragment frsFragment, yh7 yh7Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, yh7Var, frsHeaderViewContainer};
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
        this.d = yh7Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new qr7(this.a, gen);
        this.o = new pr7(this.a);
        this.l = new ut6();
    }

    public final void K(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            u0();
            if (this.c == null || z) {
                es7 es7Var = this.c;
                if (es7Var != null) {
                    es7Var.y();
                    this.c = null;
                }
                es7 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.K(this.p);
            }
            qr7 qr7Var = this.n;
            if (qr7Var != null) {
                this.c.T(qr7Var);
            }
            pr7 pr7Var = this.o;
            if (pr7Var != null) {
                this.c.R(pr7Var);
            }
            this.b.a(this.c.n());
            L(str);
            L0();
        }
    }

    public void B0(int i) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && W() && (es7Var = this.c) != null) {
            es7Var.O(i);
        }
    }

    public void C0(FrsViewData frsViewData) {
        qr7 qr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) && W() && (qr7Var = this.n) != null) {
            qr7Var.v(this.c, frsViewData);
        }
    }

    public void E0(int i) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (es7Var = this.c) != null) {
            es7Var.S(i);
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i > 1) {
                es7 es7Var = this.c;
                if (es7Var != null) {
                    es7Var.Q(false);
                    return;
                }
                return;
            }
            es7 es7Var2 = this.c;
            if (es7Var2 != null) {
                es7Var2.Q(true);
            }
        }
    }

    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.i = i;
        }
    }

    public void H0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void J0(List<eda> list) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, list) == null) && (es7Var = this.c) != null) {
            es7Var.V(list);
        }
    }

    public void M0(boolean z) {
        pr7 pr7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (pr7Var = this.o) != null) {
            es7 es7Var = this.c;
            if (es7Var != null && es7Var.t()) {
                z2 = true;
            } else {
                z2 = false;
            }
            pr7Var.s(z2);
            this.o.v(z);
        }
    }

    public final float R(ForumData forumData) {
        InterceptResult invokeL;
        qr7 qr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, forumData)) == null) {
            if (forumData != null && (qr7Var = this.n) != null) {
                return qr7Var.l(forumData);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public boolean f0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            this.g = i;
            es7 es7Var = this.c;
            if (es7Var != null) {
                es7Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void h0(boolean z) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (es7Var = this.c) != null) {
            es7Var.B(z);
        }
    }

    public void j0(MotionEvent motionEvent) {
        ut6 ut6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, motionEvent) == null) && (ut6Var = this.l) != null) {
            ut6Var.c(motionEvent);
        }
    }

    public void k0(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, num) == null) {
            E0(num.intValue());
            if (W()) {
                p0();
            }
        }
    }

    public void n0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, frsViewData) == null) && frsViewData != null && W()) {
            m0(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.c();
            }
        }
    }

    public void o0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && W()) {
            y0(i);
        }
    }

    public void r0(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, frsViewData) == null) && frsViewData != null && this.c != null && W()) {
            this.c.E(R(frsViewData.getForum()));
        }
    }

    public void x0(int i) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i) == null) && (es7Var = this.c) != null && es7Var.i() != null) {
            View findViewById = this.c.i().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.c.q();
        }
    }

    public void y0(int i) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048630, this, i) == null) && (es7Var = this.c) != null) {
            es7Var.M(i);
        }
    }

    public static boolean a0(FrsViewData frsViewData) {
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

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            if (z) {
                es7 es7Var = this.c;
                if (es7Var != null) {
                    this.b.d(es7Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            es7 es7Var2 = this.c;
            if (es7Var2 != null && es7Var2.i() != null && !this.e) {
                this.b.b(this.c.i(), this.b.getHeaderViewsCount());
                this.e = true;
            }
        }
    }

    public static boolean b0(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, frsViewData)) == null) {
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

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, str) == null) && this.a.l1() != null && this.a.l1().l0() != null) {
            int T2 = this.a.l1().l0().T();
            int Q = this.a.l1().l0().Q();
            int O = this.a.l1().l0().O();
            wca i = wca.i();
            wca.i().n(i.g("1~" + str, T2, Q, O), false);
        }
    }

    public void A0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, frsViewData, z) == null) && frsViewData != null && W()) {
            z0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void I0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, frsViewData) == null) && frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            K(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public void P0(int i, int i2, int i3) {
        qr7 qr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048598, this, i, i2, i3) == null) && (qr7Var = this.n) != null) {
            qr7Var.y(i, i2, i3);
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && W()) {
            y0(0);
        }
    }

    public void J() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.e && (es7Var = this.c) != null) {
            this.b.a(es7Var.i());
            this.e = true;
        }
    }

    public final void K0() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && W() && (es7Var = this.c) != null) {
            es7Var.W();
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SafeHandler.getInst().postDelayed(this.q, 4000L);
        }
    }

    public String N() {
        InterceptResult invokeV;
        es7 es7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (W() && (es7Var = this.c) != null) {
                return es7Var.j();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        es7 es7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (W() && (es7Var = this.c) != null) {
                return es7Var.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void O0() {
        pr7 pr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (pr7Var = this.o) != null) {
            pr7Var.w();
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        es7 es7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (W() && (es7Var = this.c) != null) {
                return es7Var.k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public es7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c;
        }
        return (es7) invokeV.objValue;
    }

    public pr7 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.o;
        }
        return (pr7) invokeV.objValue;
    }

    public void T() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && W() && (es7Var = this.c) != null) {
            es7Var.o();
        }
    }

    public void U() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (es7Var = this.c) != null) {
            es7Var.q();
        }
    }

    public void V() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (es7Var = this.c) != null) {
            es7Var.s();
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        es7 es7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (W() && (es7Var = this.c) != null) {
                return es7Var.u();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            es7 es7Var = this.c;
            if (es7Var != null) {
                es7Var.y();
            }
            pr7 pr7Var = this.o;
            if (pr7Var != null) {
                pr7Var.p();
            }
            if (this.q != null) {
                SafeHandler.getInst().removeCallbacks(this.q);
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            es7 es7Var = this.c;
            if (es7Var != null) {
                es7Var.D();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public void g0() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (es7Var = this.c) != null) {
            es7Var.A();
        }
    }

    public void i0() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (es7Var = this.c) != null) {
            es7Var.C();
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.c.G();
        }
    }

    public void p0() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (es7Var = this.c) != null) {
            es7Var.a0();
        }
    }

    public void q0() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (frsHeaderViewContainer = this.b) != null) {
            frsHeaderViewContainer.removeCallbacks(this.s);
            this.b.postDelayed(this.s, 100L);
        }
    }

    public void s0() {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (es7Var = this.c) != null) {
            es7Var.H();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            es7 es7Var = this.c;
            if (es7Var != null) {
                this.b.d(es7Var.n());
                this.b.d(this.c.i());
                v0();
            }
            this.e = false;
        }
    }

    public final void v0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.m != null && (frsFragment = this.a) != null && frsFragment.k4() != null) {
            this.a.k4().removeHeaderView(this.m.H());
        }
    }

    public final void L(String str) {
        FrsFragment frsFragment;
        RelativeLayout H;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || this.m == null || (frsFragment = this.a) == null || frsFragment.k4() == null || (H = this.m.H()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.k4().removeHeaderView(H);
            return;
        }
        this.a.k4().removeHeaderView(H);
        this.a.k4().addHeaderView(H, 0);
    }

    public void c0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            qr7 qr7Var = this.n;
            if (qr7Var != null) {
                qr7Var.p();
            }
            pr7 pr7Var = this.o;
            if (pr7Var != null) {
                pr7Var.o();
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                frsFragment.registerListener(this.r);
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Nullable
    public final h58.b M(FrsViewData frsViewData, h58 h58Var) {
        InterceptResult invokeLL;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, frsViewData, h58Var)) == null) {
            if (frsViewData != null && h58Var != null && !ListUtils.isEmpty(h58Var.a())) {
                if (frsViewData.getForum() == null) {
                    id = "";
                } else {
                    id = frsViewData.getForum().getId();
                }
                List<h58.b> a2 = h58Var.a();
                for (int i = 0; i < a2.size(); i++) {
                    h58.b bVar = a2.get(i);
                    if (id.equals(String.valueOf(bVar.a()))) {
                        return bVar;
                    }
                }
            }
            return null;
        }
        return (h58.b) invokeLL.objValue;
    }

    public void N0() {
        qr7 qr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (qr7Var = this.n) != null) {
            es7 es7Var = this.c;
            if (es7Var != null) {
                qr7Var.x(es7Var.v(), this.c.f());
            } else {
                qr7Var.x(false, "");
            }
            es7 es7Var2 = this.c;
            if (es7Var2 != null) {
                this.n.w(es7Var2.m());
            }
        }
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (!"frs_page".equals(this.h) && !"normal_page".equals(this.h) && !"book_page".equals(this.h) && !"brand_page".equals(this.h)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m0(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048618, this, forumData, frsViewData) == null) && forumData != null && frsViewData != null) {
            float R = R(forumData);
            es7 es7Var = this.c;
            if (es7Var == null) {
                return;
            }
            es7Var.L(forumData, frsViewData);
            this.c.N(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), R, false);
            this.c.P(forumData.getSignData());
        }
    }

    public void z0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        es7 es7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) != null) || (es7Var = this.c) == null) {
            return;
        }
        es7Var.L(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.N(i, forumData.getLevelName(), forumData.getUser_level(), R(forumData), z);
        this.c.P(forumData.getSignData());
        if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
            this.c.b(false);
        }
    }
}
