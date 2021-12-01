package com.baidu.tieba.write.write;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.r0.t3.s0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectClassDialogActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.SelectTagActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.spanGroup.UrlParserHttpResponseMessage;
import com.baidu.tbadk.core.view.spanGroup.UrlParserSocketResponseMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.AlbumFloatActivity;
import com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity;
import com.baidu.tieba.write.transmit.SelectForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchActivity;
import com.baidu.tieba.write.write.vote.WriteVoteActivity;
import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.tieba.write.write.work.classdialog.SelectClassDialogActivity;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassHttpResMessage;
import com.baidu.tieba.write.write.work.guide.WorkVideoGuideActivity;
import com.baidu.tieba.write.write.work.selecttag.SelectTagActivity;
import com.baidu.tieba.write.write.work.topic.model.GetRecommendTopicHttpResMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes11.dex */
public class WriteActivityStatic {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 11;

    /* renamed from: b  reason: collision with root package name */
    public static int f51061b = 18;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class a implements UrlManager.UrlSchemaHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, map) == null) || tbPageContext == null) {
                return;
            }
            WriteActivityStatic.b(tbPageContext);
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends c.a.d.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // c.a.d.c.f.f
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            Class<?> cls;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null) {
                    Object data = customMessage.getData();
                    if (data instanceof IntentConfig) {
                        IntentConfig intentConfig = (IntentConfig) data;
                        if (intentConfig.getContext() != null && (WriteActivityConfig.class == (cls = data.getClass()) || RecordVideoActivityConfig.class == cls || WriteVoteActivityConfig.class == cls || AlbumFloatActivityConfig.class == cls)) {
                            String simpleName = intentConfig.getContext().getClass().getSimpleName();
                            if ("FrsActivity".equals(simpleName) || "MainTabActivity".equals(simpleName)) {
                                g.j().v(j.a(intentConfig.getContext()).getUniqueId());
                                g.j().y(false);
                            }
                        }
                    }
                }
                return customMessage;
            }
            return (CustomMessage) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData) || TiebaStaticHelper.getCurrentActivity() == null || TiebaStaticHelper.getCurrentActivity().indexOf("NewVcode") == -1) {
                return;
            }
            TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
        }
    }

    /* loaded from: classes11.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a.r0.k0.c> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001449, new c.a.r0.l4.b()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2125123053, "Lcom/baidu/tieba/write/write/WriteActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2125123053, "Lcom/baidu/tieba/write/write/WriteActivityStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WorkPublishActivityConfig.class, WorkPublishActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WorkPublishGuideActivityConfig.class, WorkVideoGuideActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectClassDialogActivityConfig.class, SelectClassDialogActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectTagActivityConfig.class, SelectTagActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TransmitPostEditActivityConfig.class, TransmitPostEditActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlbumFloatActivityConfig.class, AlbumFloatActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TransmitForumActivityConfig.class, TransmitForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectForumActivityConfig.class, SelectForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(HotTopicChangeActivityConfig.class, HotTopicChangeFourmActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AccountAccessActivityConfig.class, AccountAccessActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteVoteActivityConfig.class, WriteVoteActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RelevanceItemSearchActivityConfig.class, RelevanceItemSearchActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AddLinkActivityConfig.class, AddLinkActivity.class);
        LocationModel.H();
        e();
        UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK, new a());
        f();
        g();
        c.a.r0.t3.f0.a.h(309450, GetRepostForumSocketResMessage.class, false, false);
        c.a.r0.t3.f0.a.c(309450, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, TbConfig.CMD_GET_REPOST_FORUM_LIST, GetRepostForumHttpResMessage.class, false, false, true, false);
        c.a.r0.t3.f0.a.c(309713, CmdConfigHttp.CMD_GET_SELECT_CLASS, TbConfig.URL_GET_WORKS_TAGS, GetSelectClassHttpResMessage.class, false, false, true, false);
        c.a.r0.t3.f0.a.c(309719, CmdConfigHttp.CMD_GET_RECOMMEND_TOPIC, TbConfig.URL_GET_RECOMMEND_TOPIC, GetRecommendTopicHttpResMessage.class, false, false, true, false);
    }

    public WriteActivityStatic() {
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

    public static void b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tbPageContext) == null) {
            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 <= f51061b && i2 >= a) {
                d(tbPageContext);
            } else {
                c(tbPageContext);
            }
        }
    }

    public static void c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                if (antiData.getIfpost() == 0) {
                    l.M(tbPageContext.getPageActivity(), antiData.getForbid_info());
                    return;
                }
                antiData.setIfVoice(false);
                WriteActivityConfig.newInstance(tbPageContext.getPageActivity()).setType(9).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setAntiData(antiData).send();
                return;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, 12008)));
        }
    }

    public static void d(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, tbPageContext) == null) {
            c.a.q0.m.a.r(tbPageContext.getPageActivity(), TbadkCoreApplication.getInst().getString(R.string.feedback), TbConfig.FEED_BACK_WEB_VIEW_URL, true, true, false, false, true);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001449, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            c.a.r0.t3.f0.a.f(309686, UrlParserSocketResponseMessage.class, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, c.a.r0.t3.f0.a.a(TbConfig.URL_URL_PARSER, 309686));
            tbHttpMessageTask.setResponsedClass(UrlParserHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            MessageManager.getInstance().addMessageRule(new b(2002001));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            MessageManager.getInstance().registerListener(new c(2016301));
        }
    }
}
