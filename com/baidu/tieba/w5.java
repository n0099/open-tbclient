package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class w5 extends o5<SocketMessage, SocketMessageTask> implements d6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t5.a b;
    public final LinkedList<u5> c;
    public final LinkedList<u5> d;
    public final LinkedList<u5> e;
    public d6 f;
    public boolean g;
    public r5 h;
    public long i;

    @Override // com.baidu.tieba.l5
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(u5 u5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, u5Var) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements t5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w5 a;

        public a(w5 w5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w5Var;
        }

        @Override // com.baidu.tieba.t5.a
        public void a(t5.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) {
                return;
            }
            this.a.w(bVar);
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(265311953, "Lcom/baidu/tieba/w5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(265311953, "Lcom/baidu/tieba/w5$b;");
                    return;
                }
            }
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w5(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = null;
        this.g = true;
        this.h = null;
        this.i = 0L;
        BdSocketLinkService.setConnStateCallBack(this);
        this.b = new a(this);
    }

    @Override // com.baidu.tieba.l5
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            s5.m(this.c, i, bdUniqueId);
            s5.m(this.d, i, bdUniqueId);
            s5.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!s5.c(this.d, i, bdUniqueId) && !s5.c(this.c, i, bdUniqueId) && !s5.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, u5 u5Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, u5Var) == null) {
            if (i == 2) {
                if (u5Var.r() != null) {
                    i2 = u5Var.r().getErrorCode();
                } else {
                    i2 = x5.i;
                }
            } else {
                i2 = x5.n;
            }
            String i3 = x5.i(i2);
            C(u5Var);
            v(u5Var, i2, i3);
        }
    }

    public void A(u5 u5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u5Var) == null) {
            if (u5Var != null && u5Var.i() && u5Var.p() < u5Var.l()) {
                s5.j(this.c, this.e, u5Var);
                r5 r5Var = this.h;
                if (r5Var != null) {
                    r5Var.b(true, "timeout seq = " + u5Var.q());
                }
                y5.c("queue", u5Var.m(), u5Var.q(), "onSendTimeOut", x5.t, String.valueOf(u5Var.p()));
                return;
            }
            C(u5Var);
            v(u5Var, x5.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(u5 u5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u5Var) != null) || u5Var == null) {
            return;
        }
        u5Var.w();
        s5.n(u5Var, this.c);
        s5.n(u5Var, this.d);
        s5.n(u5Var, this.e);
    }

    public void F(d6 d6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, d6Var) == null) {
            this.f = d6Var;
        }
    }

    public void G(r5 r5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, r5Var) == null) {
            this.h = r5Var;
        }
    }

    @Override // com.baidu.tieba.d6
    public void a(String str) {
        d6 d6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (d6Var = this.f) != null) {
            d6Var.a(str);
        }
    }

    @Override // com.baidu.tieba.d6
    public void c(ke keVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, keVar) == null) {
            E();
            d6 d6Var = this.f;
            if (d6Var != null) {
                d6Var.c(keVar);
            }
        }
    }

    public final void k(LinkedList<u5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            u5 l = s5.l(linkedList);
            if (l != null) {
                l.w();
                v(l, x5.o, null);
            } else {
                return;
            }
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, socketResponsedMessage) == null) {
            this.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            return BdAsyncTask.getTaskNum(String.valueOf(i), t5.e());
        }
        return invokeI.intValue;
    }

    public void z(u5 u5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, u5Var) != null) || u5Var == null) {
            return;
        }
        if (u5Var.v()) {
            u5Var.h();
            s5.j(this.d, this.c, u5Var);
            return;
        }
        s5.n(u5Var, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l5
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            BdUtilHelper.checkMainThread();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.getDupLicateMode())) {
                    y5.c("queue", socketMessage, 0, "sendMessage", x5.q, "duplicate message be removed");
                    return;
                }
                u5 u5Var = new u5(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    y5.c("queue", socketMessage, 0, "sendMessage", x5.z, "user manual close socket");
                    u5Var.a(x5.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    y5.c("queue", socketMessage, 0, "sendMessage", x5.p, "isManualBlock message be removed");
                    u5Var.a(x5.p);
                } else {
                    y5.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    s5.h(u5Var, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d6
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            d6 d6Var = this.f;
            if (d6Var != null) {
                d6Var.b(i, str);
            }
            r5 r5Var = this.h;
            if (r5Var != null) {
                r5Var.a();
            }
            if (BdUtilHelper.isNetOk() && !s5.a(this.e) && !s5.a(this.d) && !s5.a(this.c) && BdSocketLinkService.isAvailable()) {
                s5.b(this.c);
                s5.i(this.d, this.e);
                s5.i(this.d, this.c);
                while (true) {
                    u5 k = s5.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, x5.o, null);
                }
                if (s5.q(this.d) <= 0) {
                    return false;
                }
                y5.a("queue", 0, 0, "onClose", x5.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        u5 f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = s5.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            y5.c("queue", f.m(), 0, "sendNext", x5.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (this.g && f.n() > -3) {
        } else {
            BdSocketLinkService.sendMessage(f);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = this.g;
            this.g = false;
            y5.a("queue", 0, 0, "unBlockMessageQueue", x5.s, "Queue block has release");
            if (z) {
                E();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            k(this.c);
            k(this.d);
            k(this.e);
        }
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public r5 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (r5) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(t5.e());
        }
        return invokeV.intValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (BdSocketLinkService.isOpen() && !this.g && BdSocketLinkService.isAvailable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d6
    public void d(se seVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, seVar) != null) || seVar == null || (bArr = seVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            b6 c = a6.f().c(bArr);
            int b2 = c.a.b();
            int h = c.a.h();
            y5.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            u5 o = o(b2, h);
            if (o != null) {
                o.m = seVar.b;
                o.n = seVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && s5.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, x5.A, null);
                }
            } else {
                new t5(c, o, this.b, h).execute(new String[0]);
            }
            d6 d6Var = this.f;
            if (d6Var != null) {
                d6Var.d(seVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            y5.a("queue", 0, 0, "onBinaryMesssage", x5.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.d6
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            v5.a().c(map);
            r5 r5Var = this.h;
            if (r5Var != null) {
                r5Var.e();
            }
            this.g = true;
            y5.a("queue", 0, 0, "onConnected", x5.y, "Queue blocked");
            d6 d6Var = this.f;
            if (d6Var != null) {
                d6Var.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof q5)) {
                q5 q5Var = (q5) socketMessage;
                if (s5.d(this.d, q5Var, socketMessage.getCmd()) || s5.d(this.c, q5Var, socketMessage.getCmd()) || s5.d(this.e, q5Var, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(t5.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        u5 u5Var = bVar.b;
        if (u5Var != null) {
            v(u5Var, x5.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        y5.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, socketMessage, dupLicateMode)) == null) {
            if (socketMessage != null) {
                int cmd = socketMessage.getCmd();
                int i = b.a[dupLicateMode.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (s5.e(this.d, cmd) || s5.e(this.c, cmd) || s5.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    s5.o(this.d, cmd);
                    return false;
                }
                s5.o(this.d, cmd);
                s5.o(this.c, cmd);
                s5.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final u5 o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                u5 p = s5.p(i2, this.c);
                if (p == null && (p = s5.p(i2, this.e)) == null && (p = s5.p(i2, this.d)) == null) {
                    y5.a("queue", i, i2, "findSenderData", x5.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                y5.a("queue", i, i2, "findSenderData", x5.v, "received ack message");
                return p;
            }
            return null;
        }
        return (u5) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(u5 u5Var, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, u5Var, i, str) == null) && u5Var != null && u5Var.m() != null) {
            int cmd = u5Var.m().getCmd();
            int q = u5Var.q();
            y5.c("queue", u5Var.m(), q, "onMessageSendFail", i, str + " retryTime-" + u5Var.p());
            NetLog.getInstance().i("Request_socket", "onMessageSendFail ： " + i + str);
            if (u5Var != null) {
                socketMessageTask = u5Var.t();
            } else {
                socketMessageTask = null;
            }
            if (socketMessageTask == null) {
                socketMessageTask = (SocketMessageTask) this.a.findTask(cmd);
            }
            if (socketMessageTask != null && socketMessageTask.getResponsedClass() != null) {
                try {
                    socketResponsedMessage = socketMessageTask.getResponsedClass().newInstance();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    try {
                        socketResponsedMessage = socketMessageTask.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                if (socketResponsedMessage != null) {
                    return;
                }
                socketResponsedMessage.setError(i);
                if (str == null) {
                    socketResponsedMessage.setErrorString(x5.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(u5Var.m());
                y5.c("queue", u5Var.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
