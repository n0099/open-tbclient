package com.baidu.tieba.memberCenter.memberprivilege;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberTaskCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.fq7;
import com.baidu.tieba.gq7;
import com.baidu.tieba.ho7;
import com.baidu.tieba.io8;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.ResponseBubbleListMessage;
import com.baidu.tieba.memberCenter.index.MembercenterActivity;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.memberCenter.tail.edit.TailEditActivity;
import com.baidu.tieba.memberCenter.tail.management.TailManagementActivity;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import com.baidu.tieba.p65;
import com.baidu.tieba.wg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xj5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class MemberCenterStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<p65> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2001342, new gq7(customMessage.getData(), 1));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<p65> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2001343, new fq7(customMessage.getData()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements CustomMessageTask.CustomRunnable<TbPageContext> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<TbPageContext> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof TbPageContext)) {
                    BubbleListModel bubbleListModel = new BubbleListModel(customMessage.getData());
                    bubbleListModel.F();
                    bubbleListModel.I(0, xi.l(customMessage.getData().getPageActivity()), xi.j(customMessage.getData().getPageActivity()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements CustomMessageTask.CustomRunnable<HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Map<String, String>> run(CustomMessage<HttpResponsedMessage> customMessage) {
            InterceptResult invokeL;
            BubbleListData bubbleListData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                HashMap hashMap = null;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof ResponseBubbleListMessage) || (bubbleListData = ((ResponseBubbleListMessage) customMessage.getData()).getBubbleListData()) == null || bubbleListData.getB_info() == null || bubbleListData.getB_info().size() <= 0) {
                    return null;
                }
                Iterator<BubbleListData.BubbleData> it = bubbleListData.getB_info().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BubbleListData.BubbleData next = it.next();
                    if (next.getIs_free() == 1) {
                        hashMap = new HashMap();
                        hashMap.put("b_url", next.getB_url());
                        hashMap.put("dynamic_url", next.getDynamicUrl());
                        break;
                    }
                }
                return new CustomResponsedMessage<>(2001284, hashMap);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<p65> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2001339, new ho7(customMessage.getData()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || !strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_TASK_CENTER)) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberTaskCenterActivityConfig(tbPageContext.getPageActivity())));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER) && tbPageContext != null) {
                        if (ViewHelper.checkUpIsLogin(tbPageContext.getContext())) {
                            tbPageContext.sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(tbPageContext.getPageActivity())));
                        }
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Uri parse;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.PAY_MEMBER_PAGE) && (parse = Uri.parse(str)) != null && tbPageContext.getPageActivity() != null) {
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        if (currentAccountInfo != null && currentAccountInfo.getVipInfo() != null) {
                            i = currentAccountInfo.getVipInfo().getVipStatus();
                        } else {
                            i = 0;
                        }
                        String queryParameter = parse.getQueryParameter("fromtype");
                        String queryParameter2 = parse.getQueryParameter(MemberPayStatistic.REFER_PAGE);
                        String queryParameter3 = parse.getQueryParameter(MemberPayStatistic.CLICK_ZONE);
                        String queryParameter4 = parse.getQueryParameter(MemberPayActivityConfig.FROM_SCENE);
                        String queryParameter5 = parse.getQueryParameter(MemberPayActivityConfig.DEFAULT_GOODS);
                        if (!StringUtils.isNull(queryParameter)) {
                            if (queryParameter.equals(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS)) {
                                i2 = 6;
                            } else if (queryParameter.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                                i2 = 7;
                            }
                            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), i, false, i2, wg.e(queryParameter4, 0), queryParameter5);
                            memberPayActivityConfig.setReferPageClickZone(queryParameter2, queryParameter3);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                            return 0;
                        }
                        i2 = 0;
                        MemberPayActivityConfig memberPayActivityConfig2 = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), i, false, i2, wg.e(queryParameter4, 0), queryParameter5);
                        memberPayActivityConfig2.setReferPageClickZone(queryParameter2, queryParameter3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig2));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if ((str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY_ASSIST)) && tbPageContext != null) {
                        String d = xj5.d(str, MemberPayStatistic.REFER_PAGE);
                        String d2 = xj5.d(str, MemberPayStatistic.CLICK_ZONE);
                        String d3 = xj5.d(str, "onlyShowPrice");
                        String d4 = xj5.d(str, GuildActivityConfig.FROM_PAGE);
                        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), 0);
                        memberPayActivityConfig.setReferPageClickZone(d, d2);
                        memberPayActivityConfig.setShowPrice(d3);
                        if ("tail".equals(d4)) {
                            memberPayActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                            memberPayActivityConfig.setRequestCode(25073);
                            memberPayActivityConfig.setClose(true);
                        }
                        tbPageContext.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_MEMBER_BUY) && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), true, 220010, (String) null, 25)));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_TAIL_MANAGER)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TailManagementActivityConfig(tbPageContext.getPageActivity())));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(543469428, "Lcom/baidu/tieba/memberCenter/memberprivilege/MemberCenterStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(543469428, "Lcom/baidu/tieba/memberCenter/memberprivilege/MemberCenterStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(TailManagementActivityConfig.class, TailManagementActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TailEditActivityConfig.class, TailEditActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MemberTaskCenterActivityConfig.class, MemberTaskCenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleChooseActivityConfig.class, BubbleChooseActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPayActivityConfig.class, MemberPayFragmentActivity.class);
        TbadkApplication.getInst().RegisterIntent(MembercenterActivityConfig.class, MembercenterActivity.class);
        d();
        e();
        b();
        CustomMessageTask customMessageTask = new CustomMessageTask(2001283, new c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001284, new d());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001339, new e());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        UrlManager.getInstance().addListener(new f());
        UrlManager.getInstance().addListener(new g());
        UrlManager.getInstance().addListener(new h());
        UrlManager.getInstance().addListener(new i());
        UrlManager.getInstance().addListener(new j());
        UrlManager.getInstance().addListener(new k());
    }

    public MemberCenterStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001343, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001342, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void a(TbPageContext<?> tbPageContext, String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, strArr) == null) && strArr != null && strArr.length != 0) {
            boolean z = false;
            if (!TextUtils.isEmpty(strArr[0])) {
                String str = strArr[0];
                if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL)) ? true : true) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                        UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
                        return;
                    } else {
                        xi.O(tbPageContext.getPageActivity(), R.string.pluginstatus_tip_unknown);
                        return;
                    }
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
            }
        }
    }

    public static void c(int i2, int i3, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, cls, cls2}) == null) {
            io8.h(i3, cls2, false, false);
            io8.c(i3, i2, str, cls, false, false, false, false);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            c(CmdConfigHttp.CMD_TAIL_ADD, 305101, TbConfig.TAIL_ADD, AddTailHttpResponseMessage.class, AddTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_UPDATE, 305102, TbConfig.TAIL_UPDATE, UpdateTailHttpResponseMessage.class, UpdateTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_SET, 305104, TbConfig.TAIL_SET, SetTailHttpResponseMessage.class, SetTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_DELETE, 305103, TbConfig.TAIL_DELETE, DeleteTailHttpResponseMessage.class, DeleteTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_GET, 305001, TbConfig.TAIL_GET, GetTailsHttpResponseMessage.class, GetTailsSocketResponseMessage.class);
        }
    }
}
