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
import com.baidu.tieba.u5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes9.dex */
public class x5 extends p5<SocketMessage, SocketMessageTask> implements e6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u5.a b;
    public final LinkedList<v5> c;
    public final LinkedList<v5> d;
    public final LinkedList<v5> e;
    public e6 f;
    public boolean g;
    public s5 h;
    public long i;

    @Override // com.baidu.tieba.m5
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(v5 v5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, v5Var) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements u5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x5 a;

        public a(x5 x5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x5Var;
        }

        @Override // com.baidu.tieba.u5.a
        public void a(u5.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) {
                return;
            }
            this.a.w(bVar);
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(266235474, "Lcom/baidu/tieba/x5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(266235474, "Lcom/baidu/tieba/x5$b;");
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
    public x5(MessageManager messageManager) {
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

    @Override // com.baidu.tieba.m5
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            t5.m(this.c, i, bdUniqueId);
            t5.m(this.d, i, bdUniqueId);
            t5.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!t5.c(this.d, i, bdUniqueId) && !t5.c(this.c, i, bdUniqueId) && !t5.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, v5 v5Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, v5Var) == null) {
            if (i == 2) {
                if (v5Var.r() != null) {
                    i2 = v5Var.r().getErrorCode();
                } else {
                    i2 = y5.i;
                }
            } else {
                i2 = y5.n;
            }
            String i3 = y5.i(i2);
            C(v5Var);
            v(v5Var, i2, i3);
        }
    }

    public void A(v5 v5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v5Var) == null) {
            if (v5Var != null && v5Var.i() && v5Var.p() < v5Var.l()) {
                t5.j(this.c, this.e, v5Var);
                s5 s5Var = this.h;
                if (s5Var != null) {
                    s5Var.b(true, "timeout seq = " + v5Var.q());
                }
                z5.c("queue", v5Var.m(), v5Var.q(), "onSendTimeOut", y5.t, String.valueOf(v5Var.p()));
                return;
            }
            C(v5Var);
            v(v5Var, y5.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(v5 v5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v5Var) != null) || v5Var == null) {
            return;
        }
        v5Var.w();
        t5.n(v5Var, this.c);
        t5.n(v5Var, this.d);
        t5.n(v5Var, this.e);
    }

    public void F(e6 e6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, e6Var) == null) {
            this.f = e6Var;
        }
    }

    public void G(s5 s5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s5Var) == null) {
            this.h = s5Var;
        }
    }

    @Override // com.baidu.tieba.e6
    public void a(String str) {
        e6 e6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (e6Var = this.f) != null) {
            e6Var.a(str);
        }
    }

    @Override // com.baidu.tieba.e6
    public void c(le leVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, leVar) == null) {
            E();
            e6 e6Var = this.f;
            if (e6Var != null) {
                e6Var.c(leVar);
            }
        }
    }

    public final void k(LinkedList<v5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            v5 l = t5.l(linkedList);
            if (l != null) {
                l.w();
                v(l, y5.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), u5.e());
        }
        return invokeI.intValue;
    }

    public void z(v5 v5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, v5Var) != null) || v5Var == null) {
            return;
        }
        if (v5Var.v()) {
            v5Var.h();
            t5.j(this.d, this.c, v5Var);
            return;
        }
        t5.n(v5Var, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m5
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            BdUtilHelper.checkMainThread();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.getDupLicateMode())) {
                    z5.c("queue", socketMessage, 0, "sendMessage", y5.q, "duplicate message be removed");
                    return;
                }
                v5 v5Var = new v5(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    z5.c("queue", socketMessage, 0, "sendMessage", y5.z, "user manual close socket");
                    v5Var.a(y5.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    z5.c("queue", socketMessage, 0, "sendMessage", y5.p, "isManualBlock message be removed");
                    v5Var.a(y5.p);
                } else {
                    z5.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    t5.h(v5Var, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e6
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            e6 e6Var = this.f;
            if (e6Var != null) {
                e6Var.b(i, str);
            }
            s5 s5Var = this.h;
            if (s5Var != null) {
                s5Var.a();
            }
            if (BdUtilHelper.isNetOk() && !t5.a(this.e) && !t5.a(this.d) && !t5.a(this.c) && BdSocketLinkService.isAvailable()) {
                t5.b(this.c);
                t5.i(this.d, this.e);
                t5.i(this.d, this.c);
                while (true) {
                    v5 k = t5.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, y5.o, null);
                }
                if (t5.q(this.d) <= 0) {
                    return false;
                }
                z5.a("queue", 0, 0, "onClose", y5.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        v5 f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = t5.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            z5.c("queue", f.m(), 0, "sendNext", y5.r, "");
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
            z5.a("queue", 0, 0, "unBlockMessageQueue", y5.s, "Queue block has release");
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

    public s5 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (s5) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(u5.e());
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

    @Override // com.baidu.tieba.e6
    public void d(te teVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, teVar) != null) || teVar == null || (bArr = teVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            c6 c = b6.f().c(bArr);
            int b2 = c.a.b();
            int h = c.a.h();
            z5.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            v5 o = o(b2, h);
            if (o != null) {
                o.m = teVar.b;
                o.n = teVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && t5.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, y5.A, null);
                }
            } else {
                new u5(c, o, this.b, h).execute(new String[0]);
            }
            e6 e6Var = this.f;
            if (e6Var != null) {
                e6Var.d(teVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            z5.a("queue", 0, 0, "onBinaryMesssage", y5.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.e6
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            w5.a().c(map);
            s5 s5Var = this.h;
            if (s5Var != null) {
                s5Var.e();
            }
            this.g = true;
            z5.a("queue", 0, 0, "onConnected", y5.y, "Queue blocked");
            e6 e6Var = this.f;
            if (e6Var != null) {
                e6Var.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof r5)) {
                r5 r5Var = (r5) socketMessage;
                if (t5.d(this.d, r5Var, socketMessage.getCmd()) || t5.d(this.c, r5Var, socketMessage.getCmd()) || t5.d(this.e, r5Var, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(u5.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        v5 v5Var = bVar.b;
        if (v5Var != null) {
            v(v5Var, y5.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        z5.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (t5.e(this.d, cmd) || t5.e(this.c, cmd) || t5.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    t5.o(this.d, cmd);
                    return false;
                }
                t5.o(this.d, cmd);
                t5.o(this.c, cmd);
                t5.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final v5 o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                v5 p = t5.p(i2, this.c);
                if (p == null && (p = t5.p(i2, this.e)) == null && (p = t5.p(i2, this.d)) == null) {
                    z5.a("queue", i, i2, "findSenderData", y5.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                z5.a("queue", i, i2, "findSenderData", y5.v, "received ack message");
                return p;
            }
            return null;
        }
        return (v5) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(v5 v5Var, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, v5Var, i, str) == null) && v5Var != null && v5Var.m() != null) {
            int cmd = v5Var.m().getCmd();
            int q = v5Var.q();
            z5.c("queue", v5Var.m(), q, "onMessageSendFail", i, str + " retryTime-" + v5Var.p());
            NetLog.getInstance().i("Request_socket", "onMessageSendFail ： " + i + str);
            if (v5Var != null) {
                socketMessageTask = v5Var.t();
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
                    socketResponsedMessage.setErrorString(y5.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(v5Var.m());
                z5.c("queue", v5Var.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
