package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.n95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jg8 {
    public static /* synthetic */ Interceptable $ic;
    public static jg8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public SocketMessageListener a;
    public CustomMessageListener b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947882446, "Lcom/baidu/tieba/jg8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947882446, "Lcom/baidu/tieba/jg8;");
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jg8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jg8 jg8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg8Var, Integer.valueOf(i)};
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
            this.a = jg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 202006 && (socketResponsedMessage instanceof PushNotifyMessage)) {
                this.a.d((PushNotifyMessage) socketResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jg8 jg8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg8Var, Integer.valueOf(i)};
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
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016014 || (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) == null) {
                return;
            }
            bg8.n().v(JavaTypesHelper.toLong(imMessageCenterPojo.getGid(), 0L), kj8.c(imMessageCenterPojo.getPulled_msgId()), 0L, true);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements n95.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(jg8 jg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n95.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.onShow(TbadkCoreApplication.getInst(), "topNotify", new JSONObject());
            }
        }
    }

    public jg8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new ArrayList();
        this.a = new a(this, 202006);
        this.b = new b(this, 0);
    }

    public static synchronized jg8 b() {
        InterceptResult invokeV;
        jg8 jg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (jg8.class) {
                if (c == null) {
                    c = new jg8();
                }
                jg8Var = c;
            }
            return jg8Var;
        }
        return (jg8) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.a);
            MessageManager.getInstance().registerListener(2016014, this.b);
        }
    }

    public final void d(PushNotifyMessage pushNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pushNotifyMessage) == null) && pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (pushNotifyMessage.getType() == 36) {
                if (!TextUtils.isEmpty(pushNotifyMessage.getContent())) {
                    try {
                        String optString = new JSONObject(pushNotifyMessage.getContent()).optString("url");
                        if (TbConfig.GET_POLLING_DATA.equals(optString)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            i95.b().f(optString);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (pushNotifyMessage.getType() == 39) {
                    if (!TextUtils.isEmpty(pushNotifyMessage.getContent())) {
                        wo6.b().c(new kd9(pushNotifyMessage.getContent()));
                    }
                } else if (pushNotifyMessage.getType() == 41 && StringUtils.isNotNull(pushNotifyMessage.getContent())) {
                    try {
                        String optString2 = new JSONObject(pushNotifyMessage.getContent()).optString("url");
                        if (StringUtils.isNotNull(optString2)) {
                            n95.a.j(optString2, new c(this));
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (!uf8.n().w()) {
                    return;
                }
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                boolean z = false;
                Logger.addLog("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (TextUtils.isEmpty(valueOf)) {
                    return;
                }
                BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                if (pushNotifyMessage.getGroupType() == 0) {
                    bg8.n().y(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                    return;
                }
                int a2 = ag8.a(pushNotifyMessage.getGroupType());
                if (uf8.n().h(String.valueOf(pushNotifyMessage.getGroupId()), a2) != null) {
                    z = true;
                }
                if (z) {
                    bg8.n().y(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                } else {
                    g(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), a2);
                }
            }
        }
    }

    public final void g(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) != null) || j2 <= 0) {
            return;
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setCustomGroupType(i);
        imMessageCenterPojo.setGid(String.valueOf(j));
        imMessageCenterPojo.setPulled_msgId(kj8.a(j2 - 1));
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
    }
}
