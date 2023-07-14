package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.data.ChatTabUnreadCountData;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.da5;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.nq5;
import com.baidu.tieba.rta;
import com.baidu.tieba.wg;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes8.dex */
public class MainTabActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.startsWith("tiebavr:") && !TbadkCoreApplication.getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
                        tbPageContext.showToast((int) R.string.vr_plugin_not_available);
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Activity) {
                    y95.d((Activity) data);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements UrlManager.UrlDealListener {
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

        /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
                        if (str.contains(UrlSchemaHelper.GOTO_ENTERFORUM_TAB)) {
                            y95.f(tbPageContext.getPageActivity(), 1, true);
                            return 1;
                        } else if (str.contains(UrlSchemaHelper.GOTO_RECOMMNEDS_FRS_TAB)) {
                            y95.f(tbPageContext.getPageActivity(), 2, true);
                            return 1;
                        }
                    }
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_LIVETAB)) {
                        try {
                            Uri parse = Uri.parse(str);
                            if (parse != null && !StringUtils.isNull(parse.getQueryParameter("subTabIndex"))) {
                                int e = wg.e(parse.getQueryParameter("subTabIndex"), 0);
                                if (e == 1) {
                                    i = 18;
                                } else {
                                    i = 17;
                                }
                                try {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921446, Integer.valueOf(e)));
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (i != -1) {
                                    }
                                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_ANYTAB)) {
                                    }
                                    return 3;
                                }
                            } else {
                                i = -1;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i = -1;
                        }
                        if (i != -1) {
                            y95.f(tbPageContext.getPageActivity(), i, true);
                            return 1;
                        }
                    }
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_ANYTAB)) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(TbadkCoreApplication.getInst()).createUriCfg(Uri.parse(str))));
                            return 0;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001626) {
                return;
            }
            MainTabActivityStatic.d(customResponsedMessage);
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof KeyBoardSwitchMessage) || (data = ((KeyBoardSwitchMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.booleanValue()) {
                nq5.b().m(nq5.b().j());
                nq5.b().c();
            } else if (!nq5.b().i() && nq5.b().k()) {
                nq5.b().o();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof WindowSwitchMessage) || (data = ((WindowSwitchMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (data.booleanValue()) {
                nq5.b().m(nq5.b().j());
                nq5.b().c();
            } else if (!nq5.b().i() && nq5.b().k()) {
                nq5.b().o();
            }
        }
    }

    /* loaded from: classes8.dex */
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
            String str;
            String str2;
            String str3;
            Map<String, String> paramPair;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null) {
                    String lowerCase = strArr[0].toLowerCase();
                    if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                        String paramStr = UrlManager.getParamStr(lowerCase);
                        if (StringUtils.isNull(paramStr) || (paramPair = UrlManager.getParamPair(paramStr)) == null) {
                            str = "";
                            str2 = str;
                            str3 = str2;
                        } else {
                            str2 = paramPair.get("title");
                            if (!StringUtils.isNull(str2)) {
                                str2 = URLDecoder.decode(str2);
                            }
                            str3 = paramPair.get("fid");
                            str = paramPair.get("fname");
                            if (!StringUtils.isNull(str)) {
                                str = URLDecoder.decode(str);
                            }
                        }
                        if (ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                            if (!StringUtils.isNull(str) && !StringUtils.isNull(str3)) {
                                ForumWriteData forumWriteData = new ForumWriteData(str3, str, null, null);
                                forumWriteData.writeCallFrom = "0";
                                rta.j(tbPageContext, "", forumWriteData);
                            } else {
                                ForumWriteData forumWriteData2 = new ForumWriteData("", "", null, null);
                                forumWriteData2.writeCallFrom = "0";
                                rta.j(tbPageContext, str2, forumWriteData2);
                            }
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 4).param("obj_type", 2));
                            TiebaStatic.log(new StatisticItem("c12292").param("obj_locate", "3"));
                        }
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements CustomMessageTask.CustomRunnable<MainTabActivityConfig> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<MainTabActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(MainTabActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class i implements CustomMessageTask.CustomRunnable<Void> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                TbadkCoreApplication.getInst().setFriendFeedNew(true);
                return new CustomResponsedMessage<>(2012118);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Integer> {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof NewMsgArriveRequestMessage)) {
                    return null;
                }
                return new NewMsgArriveResponsedMessage(((NewMsgArriveRequestMessage) customMessage).getData().intValue());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1503843829, "Lcom/baidu/tieba/tblauncher/MainTabActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1503843829, "Lcom/baidu/tieba/tblauncher/MainTabActivityStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(MainTabActivityConfig.class, MainTabActivity.class);
        g();
        f();
        e();
        i();
        h();
        MessageManager.getInstance().registerListener(new b(2002004));
        UrlManager.getInstance().addListener(new c());
        MessageManager.getInstance().registerListener(new d(2001626));
        MessageManager.getInstance().registerStickyMode(2001626);
        MessageManager.getInstance().registerListener(new e(2001013));
        MessageManager.getInstance().registerListener(new f(2001014));
        UrlManager.getInstance().addListener(new g());
    }

    public MainTabActivityStatic() {
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

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new i());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new j());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            UrlManager.getInstance().addListener(new a());
        }
    }

    public static int b(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, newsRemindMessage)) == null) {
            if (newsRemindMessage == null) {
                return 0;
            }
            return newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
        }
        return invokeL.intValue;
    }

    public static boolean c(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, newsRemindMessage)) == null) {
            if (newsRemindMessage == null) {
                return false;
            }
            boolean hasMsgRemind = newsRemindMessage.hasMsgRemind();
            boolean hasChatRemind = newsRemindMessage.hasChatRemind();
            boolean hasNotificationRemind = newsRemindMessage.hasNotificationRemind();
            if (!hasMsgRemind && !hasChatRemind && !hasNotificationRemind) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(ResponsedMessage<?> responsedMessage) {
        NewsRemindMessage newsRemindMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, responsedMessage) != null) || responsedMessage == null || !(responsedMessage instanceof NewsRemindMessage) || (newsRemindMessage = (NewsRemindMessage) responsedMessage) == null) {
            return;
        }
        int b2 = b(newsRemindMessage);
        boolean c2 = c(newsRemindMessage);
        if (b2 != a || c2 != b) {
            a = b2;
            b = c2;
            da5.p().F("message_count", b2);
            ChatTabUnreadCountData chatTabUnreadCountData = new ChatTabUnreadCountData();
            chatTabUnreadCountData.setCountNum(b2);
            chatTabUnreadCountData.setShowTip(c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921002, chatTabUnreadCountData));
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SCHEMA_UPLOAD, TbConfig.SERVER_ADDRESS + "c/s/schemastat");
            tbHttpMessageTask.setResponsedClass(HttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
