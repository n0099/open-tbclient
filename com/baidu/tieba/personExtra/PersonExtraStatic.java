package com.baidu.tieba.personExtra;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.ReportThemeActivityConfig;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
import com.baidu.tbadk.core.message.UserGrowthTaskResponseMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.aq4;
import com.baidu.tieba.ax9;
import com.baidu.tieba.bq4;
import com.baidu.tieba.cq4;
import com.baidu.tieba.gk5;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.more.PersonCenterMoreActivity;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.jvbao.ReportThemeActivity;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericHttpResMsg;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericSocketResMsg;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserReportHttpResponseMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.post.PersonPostActivity;
import com.baidu.tieba.qi5;
import com.baidu.tieba.sr9;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import com.baidu.tieba.xda;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonExtraStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements CustomMessageTask.CustomRunnable<PersonInfoActivityConfig> {
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
        public CustomResponsedMessage<PersonInfoActivityConfig> run(CustomMessage<PersonInfoActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    PersonExtraStatic.d(customMessage.getData());
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_PERSON_INFO)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), WebviewHelper.getMatchStringFromURL(str, "userid="), WebviewHelper.getMatchStringFromURL(str, "un="))));
                        return 1;
                    } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.OPEN_PERSON_INFO)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), WebviewHelper.getMatchStringFromURL(str, "userid="), WebviewHelper.getMatchStringFromURL(str, "un="))));
                        return 0;
                    } else if (strArr[0].startsWith("com.baidu.tieba://unidispatch/usercenter")) {
                        UtilHelper.dealOneScheme(tbPageContext.getPageActivity(), strArr[0]);
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || !strArr[0].toLowerCase().contains(UrlSchemaHelper.JUMP_TO_MODIFY_NICKNAME)) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(tbPageContext.getPageActivity(), 25020, 0, null)));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements UrlManager.UrlDealListener {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_PERSON_INFO)) {
                        String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "userid=");
                        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                        long j2 = JavaTypesHelper.toLong(matchStringFromURL, 0L);
                        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(tbPageContext.getPageActivity());
                        if (j2 == j) {
                            z = true;
                        } else {
                            z = false;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personPolymericActivityConfig.createNormalConfig(j2, z, false)));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cq4 {
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

        @Override // com.baidu.tieba.cq4
        public View a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                TextView a = bq4.a(context);
                if (a != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    SkinManager.setViewTextColor(a, (int) R.color.CAM_X0302);
                    layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f07041c), 0, BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f07041c), 0);
                    layoutParams.gravity = 16;
                    a.setLayoutParams(layoutParams);
                }
                return a;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements UrlManager.UrlDealListener {
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
            AccountData currentAccountObj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || !strArr[0].contains(UrlSchemaHelper.JUMP_TO_POST_LIST) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(tbPageContext.getPageActivity(), currentAccountObj.getID(), currentAccountObj.getSex(), currentAccountObj.getPortrait())));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(530829204, "Lcom/baidu/tieba/personExtra/PersonExtraStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(530829204, "Lcom/baidu/tieba/personExtra/PersonExtraStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(EditHeadActivityConfig.class, EditHeadActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonMoreActivityConfig.class, PersonCenterMoreActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonChangeActivityConfig.class, PersonChangeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditNickNameActivityConfig.class, EditNickNameActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SmartAppBrowseHistoryActivityConfig.class, SmartAppBrowseHistoryActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonPolymericActivityConfig.class, PersonPolymericActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002003, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().addListener(new b());
        l();
        TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(107129);
        tbSocketMessageTask.setResponsedClass(ResponseGetLivableForumList.class);
        tbSocketMessageTask.setNeedCompress(false);
        tbSocketMessageTask.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(tbSocketMessageTask);
        j();
        n();
        m();
        o();
        p();
        f();
        g();
        e();
        b();
        c();
        ax9.a();
        h();
        i();
        k();
        q();
        qi5.a(gk5.b, new sr9());
    }

    public PersonExtraStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            aq4.b().c(7, new e());
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(ReportThemeActivityConfig.class, ReportThemeActivity.class);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            xda.d(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647, TbConfig.PERSON_CENTER_DYNAMIC_TAB_URL, PersonCenterDynamicTabHttpResMessage.class);
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            xda.f(303040, UserMuteCheckSocketResponsedMessage.class, false);
            xda.c(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            xda.f(303040, UserMuteCheckSocketResponsedMessage.class, false);
            xda.c(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            UrlManager.getInstance().addListener(new d());
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.URL_USER_REPORT);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(UserReportHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            xda.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, xda.a("c/u/feed/userpost", 303002));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, xda.a("c/u/user/getRecommendGodList", 309684));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecommendGodHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
            tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
            tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_YINJI_TASK_SHARE_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.GET_YINJI_TASK_REPORT);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(UserGrowthTaskResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void d(PersonInfoActivityConfig personInfoActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, personInfoActivityConfig) == null) {
            Context context = personInfoActivityConfig.getContext();
            String stringExtra = personInfoActivityConfig.getIntent().getStringExtra("user_id");
            if (stringExtra != null && stringExtra.length() > 0 && !stringExtra.equals("0") && !stringExtra.startsWith("-")) {
                Intent intent = personInfoActivityConfig.getIntent();
                intent.setClass(context, PersonPolymericActivity.class);
                intent.putExtra("user_id", JavaTypesHelper.toLong(stringExtra, 0L));
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    intent.putExtra(PersonPolymericActivityConfig.IS_USER_SELF, TbadkCoreApplication.getCurrentAccount().equals(stringExtra));
                } else {
                    intent.putExtra(PersonPolymericActivityConfig.IS_USER_SELF, false);
                }
                personInfoActivityConfig.setComponentClass(PersonPolymericActivity.class);
                personInfoActivityConfig.run();
            }
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            xda.h(309408, PersonPolymericSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PERSON_POLYMERIC, xda.a("c/u/user/personal", 309408));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(PersonPolymericHttpResMsg.class);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_PERSON_POLYMERIC);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
