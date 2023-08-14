package com.baidu.tieba.immessagecenter.im.chat;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMeActivityConfig;
import com.baidu.tbadk.core.atomData.GamePersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.InvateAnswerSettingActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.aba;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.immessagecenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.immessagecenter.ResponseFriendListMessage;
import com.baidu.tieba.immessagecenter.StrangerListActivityConfig;
import com.baidu.tieba.immessagecenter.im.addFriend.AddFriendActivity;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.InvatateAnswerSettingActivity;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.MsgReplyCardViewItemAdapter;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.immessagecenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.immessagecenter.mention.AtMeActivity;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.mention.agree.AgreeMeActivity;
import com.baidu.tieba.immessagecenter.mention.reply.ReplyMeActivity;
import com.baidu.tieba.immessagecenter.msgtab.obs.ObserverRegistry;
import com.baidu.tieba.kw5;
import com.baidu.tieba.oo8;
import com.baidu.tieba.ow5;
import com.baidu.tieba.pv5;
import com.baidu.tieba.r98;
import com.baidu.tieba.vn8;
import com.baidu.tieba.wn8;
import com.baidu.tieba.xn8;
import com.baidu.tieba.yn8;
import com.baidu.tieba.zb8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class PersonalChatActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public static yn8 a;
    public static CustomMessageListener b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class b implements CustomMessageTask.CustomRunnable<PersonalChatActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a extends kw5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LinkedList a;

            public a(b bVar, LinkedList linkedList) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, linkedList};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.kw5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return zb8.w().a(this.a);
                }
                return (Void) invokeV.objValue;
            }
        }

        /* renamed from: com.baidu.tieba.immessagecenter.im.chat.PersonalChatActivityStatic$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0356b implements pv5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomMessage a;

            public C0356b(b bVar, CustomMessage customMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, customMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.pv5
            /* renamed from: a */
            public void onReturnDataInUI(Void r5) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                    ((PersonalChatActivityConfig) this.a.getData()).getIntent().addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    if (((PersonalChatActivityConfig) this.a.getData()).getUserData().getUserIdLong() == 0) {
                        return;
                    }
                    ((PersonalChatActivityConfig) this.a.getData()).startActivity(PersonalChatActivity.class);
                }
            }
        }

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
        public CustomResponsedMessage<PersonalChatActivityConfig> run(CustomMessage<PersonalChatActivityConfig> customMessage) {
            InterceptResult invokeL;
            UserData userData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || (userData = customMessage.getData().getUserData()) == null) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(String.valueOf(userData.getUserId()));
                ow5.c(new a(this, linkedList), new C0356b(this, customMessage));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            yn8 unused = PersonalChatActivityStatic.a = null;
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && tbPageContext.getPageActivity() != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_PERSONAL_CHAT)) {
                        if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst().getContext())) {
                            return 0;
                        }
                        String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "userid=");
                        String matchStringFromURL2 = WebviewHelper.getMatchStringFromURL(str, "username=");
                        String matchStringFromURL3 = WebviewHelper.getMatchStringFromURL(str, "portrait=");
                        if (matchStringFromURL != null && matchStringFromURL.length() > 0) {
                            try {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(matchStringFromURL), matchStringFromURL2, matchStringFromURL2, matchStringFromURL3, 0)));
                                return 1;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return 1;
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getPageActivity(), -2)));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
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
            TbPageContext<MsglistActivity<?>> tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                if (aVar.b != null && (tbPageContext = aVar.a) != null) {
                    MsgReplyCardViewItemAdapter msgReplyCardViewItemAdapter = new MsgReplyCardViewItemAdapter(tbPageContext, ChatMessage.TYPE_MSG_REPLY_CARD);
                    msgReplyCardViewItemAdapter.z(true);
                    aVar.b.add(msgReplyCardViewItemAdapter);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    oo8.e().f();
                } else {
                    oo8.e().d();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                    String str = strArr[0];
                    if (str.contains(UrlSchemaHelper.JUMP_TO_CHAT)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(tbPageContext.getContext(), -2)));
                        return 0;
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_REPLY_ME)) {
                        ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(tbPageContext.getContext());
                        replyMeActivityConfig.setHighLightPostId(Uri.parse(str).getQueryParameter("pid"));
                        replyMeActivityConfig.setFrom(2);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
                        return 0;
                    } else {
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_FANS_PAGE)) {
                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                i = TbadkCoreApplication.getCurrentAccountInfo().getSex();
                            } else {
                                i = 0;
                            }
                            if (currentAccount != null && currentAccount.length() > 0) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(tbPageContext.getContext(), false, currentAccount, i)));
                                return 0;
                            }
                        }
                        if (str.startsWith(UrlSchemaHelper.SCHEMA_AT_ME)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMeActivityConfig(tbPageContext.getPageActivity())));
                            return 0;
                        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_AGREE_ME)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(tbPageContext.getContext())));
                            return 0;
                        }
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(507360053, "Lcom/baidu/tieba/immessagecenter/im/chat/PersonalChatActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(507360053, "Lcom/baidu/tieba/immessagecenter/im/chat/PersonalChatActivityStatic;");
                return;
            }
        }
        b = new a(2005016);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalMsgImageActivityConfig.class, PersonalMsgImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MessageCenterActivityConfig.class, MessageCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtMeActivityConfig.class, AtMeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ReplyMeActivityConfig.class, ReplyMeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AgreeMeActivityConfig.class, AgreeMeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(InvateAnswerSettingActivityConfig.class, InvatateAnswerSettingActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalChatActivityConfig.class, PersonalChatActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GamePersonalChatActivityConfig.class, GamePersonalChatActivity.class);
        r98.b(205001, ResponseCommitPersonalMessage.class, false);
        r98.b(205003, ResponseQueryUserInfoMessage.class, false);
        r98.b(205006, ResponsedPersonalMsgReadMessage.class, false);
        r98.a(2001143, vn8.class);
        r98.a(2001146, xn8.class);
        r98.a(2001149, wn8.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FRIEND_LIST, TbConfig.SERVER_ADDRESS + "c/u/follow/list");
        tbHttpMessageTask.setResponsedClass(ResponseFriendListMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        aba.e(CmdConfigHttp.CMD_HTTP_SHARE_CONTENT_TO_CHAT_GROUP, TbConfig.SHARE_CONTENT_TO_CHAT_GROUP_ROOM, JsonHttpResponsedMessage.class, true, true, true, true);
        c();
        MessageManager.getInstance().registerListener(b);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002005, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().addListener(new c());
        MessageManager.getInstance().registerListener(new d(2001275));
        MessageManager.getInstance().registerListener(new e(2005016));
        ObserverRegistry.a.start();
    }

    public PersonalChatActivityStatic() {
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

    public static yn8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return (yn8) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            UrlManager.getInstance().addListener(new f());
        }
    }

    public static void d(yn8 yn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, yn8Var) == null) {
            a = yn8Var;
        }
    }
}
