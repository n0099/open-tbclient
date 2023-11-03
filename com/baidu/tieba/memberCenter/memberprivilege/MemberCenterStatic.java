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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayPrivilegeResultActivityConfig;
import com.baidu.tbadk.core.atomData.MemberTaskCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.cra;
import com.baidu.tieba.hi9;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kk9;
import com.baidu.tieba.lk9;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.ResponseBubbleListMessage;
import com.baidu.tieba.memberCenter.index.MembercenterActivity;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity;
import com.baidu.tieba.memberCenter.memberpayresult.MemberPayPrivilegeResultActivity;
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
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.wk9;
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
/* loaded from: classes7.dex */
public class MemberCenterStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements CustomMessageTask.CustomRunnable<Context> {
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
        public CustomResponsedMessage<ke5> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2001342, new lk9(customMessage.getData(), 1));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CustomMessageTask.CustomRunnable<Context> {
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
        public CustomResponsedMessage<ke5> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2001343, new kk9(customMessage.getData()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements CustomMessageTask.CustomRunnable<Context> {
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
        public CustomResponsedMessage<ke5> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2921824, new wk9(customMessage.getData()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements CustomMessageTask.CustomRunnable<TbPageContext> {
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
        public CustomResponsedMessage<Boolean> run(CustomMessage<TbPageContext> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof TbPageContext)) {
                    BubbleListModel bubbleListModel = new BubbleListModel(customMessage.getData());
                    bubbleListModel.U();
                    bubbleListModel.X(0, BdUtilHelper.getEquipmentWidth(customMessage.getData().getPageActivity()), BdUtilHelper.getEquipmentHeight(customMessage.getData().getPageActivity()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CustomMessageTask.CustomRunnable<HttpResponsedMessage> {
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

    /* loaded from: classes7.dex */
    public class f implements CustomMessageTask.CustomRunnable<Context> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ke5> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof Context)) {
                    return new CustomResponsedMessage<>(2001339, new hi9(customMessage.getData()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements UrlManager.UrlDealListener {
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
                if (strArr == null || strArr.length == 0 || !strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_TASK_CENTER)) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberTaskCenterActivityConfig(tbPageContext.getPageActivity())));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements UrlManager.UrlDealListener {
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

    /* loaded from: classes7.dex */
    public class i implements UrlManager.UrlDealListener {
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
            Uri parse;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.PAY_MEMBER_PAGE) && (parse = Uri.parse(str)) != null) {
                        String queryParameter = parse.getQueryParameter(MemberPayStatistic.REFER_PAGE);
                        String queryParameter2 = parse.getQueryParameter(MemberPayStatistic.CLICK_ZONE);
                        String queryParameter3 = parse.getQueryParameter(MemberPayActivityConfig.FROM_SCENE);
                        String queryParameter4 = parse.getQueryParameter("scene_id");
                        if (TextUtils.isEmpty(queryParameter)) {
                            queryParameter = parse.getQueryParameter("referPage");
                        }
                        if (TextUtils.isEmpty(queryParameter2)) {
                            queryParameter2 = parse.getQueryParameter("clickZone");
                        }
                        if (TextUtils.isEmpty(queryParameter3)) {
                            queryParameter3 = parse.getQueryParameter("fromScene");
                        }
                        if (TextUtils.isEmpty(queryParameter4)) {
                            queryParameter4 = parse.getQueryParameter("sceneId");
                        }
                        PayPanelUtils.launchPayPanel(tbPageContext, JavaTypesHelper.toInt(queryParameter4, 0), queryParameter, queryParameter2, queryParameter3);
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements UrlManager.UrlDealListener {
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
                    if ((str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY_ASSIST)) && tbPageContext != null) {
                        String paramFromURL = WebviewHelper.getParamFromURL(str, MemberPayStatistic.REFER_PAGE);
                        String paramFromURL2 = WebviewHelper.getParamFromURL(str, MemberPayStatistic.CLICK_ZONE);
                        String paramFromURL3 = WebviewHelper.getParamFromURL(str, MemberPayActivityConfig.FROM_SCENE);
                        String paramFromURL4 = WebviewHelper.getParamFromURL(str, "scene_id");
                        if (TextUtils.isEmpty(paramFromURL4)) {
                            paramFromURL4 = WebviewHelper.getParamFromURL(str, "sceneId");
                        }
                        PayPanelUtils.launchPayPanel(tbPageContext, JavaTypesHelper.toInt(paramFromURL4, 0), paramFromURL, paramFromURL2, paramFromURL3);
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements UrlManager.UrlDealListener {
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
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_MEMBER_BUY) && tbPageContext != null) {
                        PayPanelUtils.b bVar = new PayPanelUtils.b();
                        bVar.h(220010);
                        PayPanelUtils.launchPayPanel(tbPageContext, bVar);
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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
        TbadkApplication.getInst().RegisterIntent(MemberPayPrivilegeResultActivityConfig.class, MemberPayPrivilegeResultActivity.class);
        d();
        e();
        b();
        f();
        CustomMessageTask customMessageTask = new CustomMessageTask(2001283, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001284, new e());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001339, new f());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        UrlManager.getInstance().addListener(new g());
        UrlManager.getInstance().addListener(new h());
        UrlManager.getInstance().addListener(new i());
        UrlManager.getInstance().addListener(new j());
        UrlManager.getInstance().addListener(new k());
        UrlManager.getInstance().addListener(new l());
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

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921824, new c());
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
                        BdUtilHelper.showToast(tbPageContext.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1141);
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
            cra.h(i3, cls2, false, false);
            cra.c(i3, i2, str, cls, false, false, false, false);
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
