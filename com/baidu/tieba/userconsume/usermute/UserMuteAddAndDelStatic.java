package com.baidu.tieba.userconsume.usermute;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckRequestMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ar8;
import com.repackage.hj8;
import com.repackage.wa;
/* loaded from: classes4.dex */
public class UserMuteAddAndDelStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.userconsume.usermute.UserMuteAddAndDelStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0232a extends HttpMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UserMuteAddAndDelCustomMessage a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0232a(a aVar, int i, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), userMuteAddAndDelCustomMessage};
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
                this.a = userMuteAddAndDelCustomMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof UserMuteAddResponseMessage)) {
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016304));
                        int i = this.a.from;
                        if (i == 1) {
                            TiebaStatic.log("c10034");
                        } else if (i == 0) {
                            TiebaStatic.log("c10043");
                        }
                    }
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001427, userMuteAddResponseMessage);
                    customResponsedMessage.setOrginalMessage(this.a);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b extends HttpMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UserMuteAddAndDelCustomMessage a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(a aVar, int i, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), userMuteAddAndDelCustomMessage};
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
                this.a = userMuteAddAndDelCustomMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof UserMuteDelResponseMessage)) {
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016303));
                    }
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001428, userMuteDelResponseMessage);
                    customResponsedMessage.setOrginalMessage(this.a);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }

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
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof UserMuteAddAndDelCustomMessage)) {
                    return null;
                }
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = (UserMuteAddAndDelCustomMessage) customMessage;
                C0232a c0232a = new C0232a(this, CmdConfigHttp.CMD_USER_MUTE_ADD, userMuteAddAndDelCustomMessage);
                b bVar = new b(this, CmdConfigHttp.CMD_USER_MUTE_DEL, userMuteAddAndDelCustomMessage);
                c0232a.setSelfListener(true);
                c0232a.setTag(userMuteAddAndDelCustomMessage.mId);
                bVar.setSelfListener(true);
                bVar.setTag(userMuteAddAndDelCustomMessage.mId);
                MessageManager.getInstance().registerListener(c0232a);
                MessageManager.getInstance().registerListener(bVar);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Object> {
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
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof UserMuteAddAndDelCustomMessage) || (i = (userMuteAddAndDelCustomMessage = (UserMuteAddAndDelCustomMessage) customMessage).from) == -1) {
                    return null;
                }
                if (userMuteAddAndDelCustomMessage.isMute) {
                    if (i == 1) {
                        TiebaStatic.log("c10024");
                    } else if (i == 0) {
                        TiebaStatic.log("c10037");
                    } else if (i == 2) {
                        TiebaStatic.log("c10047");
                    }
                    UserMuteAddAndDelStatic.k(userMuteAddAndDelCustomMessage.muteUserId, userMuteAddAndDelCustomMessage.mId);
                } else {
                    if (i == 1) {
                        TiebaStatic.log("c10012");
                    } else if (i == 0) {
                        TiebaStatic.log("c10036");
                    }
                    UserMuteAddAndDelStatic.j(userMuteAddAndDelCustomMessage.muteUserId, userMuteAddAndDelCustomMessage.threadId, userMuteAddAndDelCustomMessage.postId, userMuteAddAndDelCustomMessage.mId);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<Object> {
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
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof UserMuteCheckCustomMessage)) {
                    return null;
                }
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = (UserMuteCheckCustomMessage) customMessage;
                UserMuteCheckRequestMessage userMuteCheckRequestMessage = new UserMuteCheckRequestMessage();
                userMuteCheckRequestMessage.setUserIdF(userMuteCheckCustomMessage.userIdF);
                userMuteCheckRequestMessage.setUserIdT(userMuteCheckCustomMessage.userIdT);
                userMuteCheckRequestMessage.setTag(userMuteCheckCustomMessage.mId);
                userMuteCheckRequestMessage.mTagId = userMuteCheckCustomMessage.mId;
                MessageManager.getInstance().sendMessage(userMuteCheckRequestMessage);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a extends wa {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UserMuteCheckCustomMessage a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i, int i2, UserMuteCheckCustomMessage userMuteCheckCustomMessage) {
                super(i, i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i), Integer.valueOf(i2), userMuteCheckCustomMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = userMuteCheckCustomMessage;
            }

            @Override // com.repackage.wa
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                    ar8 ar8Var = new ar8();
                    if (responsedMessage instanceof UserMuteCheckSocketResponsedMessage) {
                        UserMuteCheckSocketResponsedMessage userMuteCheckSocketResponsedMessage = (UserMuteCheckSocketResponsedMessage) responsedMessage;
                        ar8Var.a = userMuteCheckSocketResponsedMessage.getResult();
                        ar8Var.c = userMuteCheckSocketResponsedMessage.getError();
                        ar8Var.b = userMuteCheckSocketResponsedMessage.getErrorString();
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001426, ar8Var);
                        customResponsedMessage.setOrginalMessage(this.a);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                    if (responsedMessage instanceof UserMuteCheckHttpResponsedMessage) {
                        UserMuteCheckHttpResponsedMessage userMuteCheckHttpResponsedMessage = (UserMuteCheckHttpResponsedMessage) responsedMessage;
                        ar8Var.a = userMuteCheckHttpResponsedMessage.getResult();
                        ar8Var.c = userMuteCheckHttpResponsedMessage.getError();
                        ar8Var.b = userMuteCheckHttpResponsedMessage.getErrorString();
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001426, ar8Var);
                        customResponsedMessage2.setOrginalMessage(this.a);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                    }
                }
            }
        }

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
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage instanceof UserMuteCheckCustomMessage)) {
                    return null;
                }
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = (UserMuteCheckCustomMessage) customMessage;
                a aVar = new a(this, CmdConfigHttp.CMD_USER_MUTE_CHECK, 303040, userMuteCheckCustomMessage);
                aVar.getHttpMessageListener().setSelfListener(true);
                aVar.getSocketMessageListener().setSelfListener(true);
                aVar.setTag(userMuteCheckCustomMessage.mId);
                MessageManager.getInstance().registerListener(aVar);
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1252598619, "Lcom/baidu/tieba/userconsume/usermute/UserMuteAddAndDelStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1252598619, "Lcom/baidu/tieba/userconsume/usermute/UserMuteAddAndDelStatic;");
                return;
            }
        }
        d();
        h();
        e();
        c();
        g();
        i();
        f();
    }

    public UserMuteAddAndDelStatic() {
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

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001431, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_ADD, TbConfig.SERVER_ADDRESS + TbConfig.USER_MUTE_ADD);
            tbHttpMessageTask.setResponsedClass(UserMuteAddResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001430, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001432, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            hj8.f(303040, UserMuteCheckSocketResponsedMessage.class, false);
            hj8.c(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_MUTE_DEL, TbConfig.SERVER_ADDRESS + TbConfig.USER_MUTE_DEL);
            tbHttpMessageTask.setResponsedClass(UserMuteDelResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001429, new c());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void j(String str, String str2, String str3, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, str, str2, str3, bdUniqueId) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_ADD);
            httpMessage.addParam("mute_user", str);
            if (str2 != null) {
                httpMessage.addParam("thread_id", str2);
            }
            if (str3 != null) {
                httpMessage.addParam("post_id", str3);
            }
            httpMessage.addParam("mute_type", 0);
            httpMessage.setExtra(str);
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void k(String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, bdUniqueId) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_MUTE_DEL);
            httpMessage.addParam("mute_user", str);
            httpMessage.addParam("mute_type", 0);
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
