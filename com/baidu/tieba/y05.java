package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y05 extends Handler implements z9 {
    public static /* synthetic */ Interceptable $ic;
    public static y05 f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;
    public int c;
    public int d;
    public PingMessage e;

    /* loaded from: classes6.dex */
    public class a extends db {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y05 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y05 y05Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y05Var, Integer.valueOf(i)};
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
            this.a = y05Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            this.a.l(socketResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y05 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y05 y05Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y05Var, Integer.valueOf(i)};
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
            this.a = y05Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.h((BackgroundSwitchMessage) customResponsedMessage);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948276363, "Lcom/baidu/tieba/y05;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948276363, "Lcom/baidu/tieba/y05;");
        }
    }

    public y05() {
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
        this.a = 0L;
        this.b = TiebaStatic.MAX_COST_VALUE;
        this.c = 900000;
        this.d = 900000;
        this.e = null;
    }

    public static y05 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f == null) {
                synchronized (y05.class) {
                    if (f == null) {
                        f = new y05();
                    }
                }
            }
            return f;
        }
        return (y05) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeMessages(1);
        }
    }

    @Override // com.baidu.tieba.z9
    public boolean b(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str)) == null) {
            if ((z || System.currentTimeMillis() - this.a >= LiveFeedPageSdk.REFRESH_TIME) && BdSocketLinkService.isOpen()) {
                this.a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(this.e);
                PingMessage pingMessage = this.e;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("-");
                sb.append(this.d == this.c ? "back" : "fore");
                ga.c("PingManager", pingMessage, 0, "send_ping", 0, sb.toString());
                return true;
            }
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.z9
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1003;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.z9
    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            if (BdSocketLinkService.isClose()) {
                d65.b(0, 0, 0, 1, 10);
                BdSocketLinkService.startService(false, str);
            } else if (BdSocketLinkService.isOpen()) {
                b(false, str);
            }
        }
    }

    @Override // com.baidu.tieba.z9
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeMessages(1);
            sendMessageDelayed(obtainMessage(1), this.d);
            this.a = System.currentTimeMillis();
        }
    }

    public final void h(BackgroundSwitchMessage backgroundSwitchMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, backgroundSwitchMessage) == null) || backgroundSwitchMessage == null) {
            return;
        }
        if (backgroundSwitchMessage.getData().booleanValue()) {
            this.d = this.c;
            return;
        }
        this.d = this.b;
        d("switchToForeground");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, message) == null) && message.what == 1) {
            e();
            b(true, "regular time send");
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.intValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qb5 qb5Var = new qb5(1003);
            qb5Var.setResponsedClass(ResponsedPingMessage.class);
            qb5Var.h(false);
            qb5Var.setPriority(-3);
            qb5Var.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
            qb5Var.e(false);
            MessageManager.getInstance().registerTask(qb5Var);
            this.e = new PingMessage();
            m();
            a aVar = new a(this, 1003);
            MessageManager.getInstance().registerListener(new b(this, 2001011));
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public final void l(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        int error = responsedMessage.getError();
        if (error == 0) {
            com.baidu.adp.framework.message.Message<?> orginalMessage = responsedMessage.getOrginalMessage();
            int i = qn4.a;
            ga.c("PingManager", orginalMessage, 0, "ping_succ", i, "costtime:" + String.valueOf(System.currentTimeMillis() - this.a));
            return;
        }
        BdSocketLinkService.close(7, "ping error");
        int cmd = this.e.getCmd();
        long clientLogID = this.e.getClientLogID();
        ga.b("PingManager", cmd, clientLogID, 0, "ping_err", error, "costtime:" + String.valueOf(System.currentTimeMillis() - this.a));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int[] socketHeartBeatStratgy = TbadkCoreApplication.getInst().getSocketHeartBeatStratgy();
            if (socketHeartBeatStratgy.length == 2) {
                int i = socketHeartBeatStratgy[0] * 1000;
                this.b = i;
                this.c = socketHeartBeatStratgy[1] * 1000;
                if (i < 180000) {
                    this.b = TiebaStatic.MAX_COST_VALUE;
                }
                if (this.c < 180000) {
                    this.c = TiebaStatic.MAX_COST_VALUE;
                }
            }
        }
    }
}
