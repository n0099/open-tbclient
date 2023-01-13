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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ra;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes6.dex */
public class ua extends ma<SocketMessage, SocketMessageTask> implements bb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ra.a b;
    public final LinkedList<sa> c;
    public final LinkedList<sa> d;
    public final LinkedList<sa> e;
    public bb f;
    public boolean g;
    public pa h;
    public long i;
    public int j;

    @Override // com.baidu.tieba.ja
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(sa saVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, saVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ra.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua a;

        public a(ua uaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uaVar;
        }

        @Override // com.baidu.tieba.ra.a
        public void a(ra.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) {
                return;
            }
            this.a.w(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264775715, "Lcom/baidu/tieba/ua$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(264775715, "Lcom/baidu/tieba/ua$b;");
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
    public ua(MessageManager messageManager) {
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
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.b = new a(this);
    }

    public void A(sa saVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, saVar) == null) {
            if (saVar != null && saVar.i() && saVar.p() < saVar.l()) {
                qa.j(this.c, this.e, saVar);
                pa paVar = this.h;
                if (paVar != null) {
                    paVar.b(true, "timeout seq = " + saVar.q());
                }
                wa.c("queue", saVar.m(), saVar.q(), "onSendTimeOut", va.t, String.valueOf(saVar.p()));
                return;
            }
            C(saVar);
            v(saVar, va.m, null);
            E();
        }
    }

    @Override // com.baidu.tieba.ja
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            qa.m(this.c, i, bdUniqueId);
            qa.m(this.d, i, bdUniqueId);
            qa.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!qa.c(this.d, i, bdUniqueId) && !qa.c(this.c, i, bdUniqueId) && !qa.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, sa saVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, saVar) == null) {
            if (i == 2) {
                if (saVar.r() != null) {
                    i2 = saVar.r().getErrorCode();
                } else {
                    i2 = va.i;
                }
            } else {
                i2 = va.n;
            }
            String i3 = va.i(i2);
            C(saVar);
            v(saVar, i2, i3);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(sa saVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, saVar) != null) || saVar == null) {
            return;
        }
        saVar.w();
        qa.n(saVar, this.c);
        qa.n(saVar, this.d);
        qa.n(saVar, this.e);
    }

    public void F(bb bbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bbVar) == null) {
            this.f = bbVar;
        }
    }

    public void G(pa paVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, paVar) == null) {
            this.h = paVar;
        }
    }

    @Override // com.baidu.tieba.bb
    public void a(String str) {
        bb bbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (bbVar = this.f) != null) {
            bbVar.a(str);
        }
    }

    @Override // com.baidu.tieba.bb
    public void c(uj ujVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ujVar) == null) {
            E();
            bb bbVar = this.f;
            if (bbVar != null) {
                bbVar.c(ujVar);
            }
        }
    }

    public final void k(LinkedList<sa> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            sa l = qa.l(linkedList);
            if (l != null) {
                l.w();
                v(l, va.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), ra.e());
        }
        return invokeI.intValue;
    }

    public void z(sa saVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, saVar) != null) || saVar == null) {
            return;
        }
        if (saVar.v()) {
            saVar.h();
            qa.j(this.d, this.c, saVar);
            return;
        }
        qa.n(saVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ja
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            zi.c();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.a())) {
                    wa.c("queue", socketMessage, 0, "sendMessage", va.q, "duplicate message be removed");
                    return;
                }
                sa saVar = new sa(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    wa.c("queue", socketMessage, 0, "sendMessage", va.z, "user manual close socket");
                    saVar.a(va.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    wa.c("queue", socketMessage, 0, "sendMessage", va.p, "isManualBlock message be removed");
                    saVar.a(va.p);
                } else {
                    wa.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    qa.h(saVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.bb
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            bb bbVar = this.f;
            if (bbVar != null) {
                bbVar.b(i, str);
            }
            pa paVar = this.h;
            if (paVar != null) {
                paVar.a();
            }
            if (zi.F() && !qa.a(this.e) && !qa.a(this.d) && !qa.a(this.c) && BdSocketLinkService.isAvailable()) {
                qa.b(this.c);
                qa.i(this.d, this.e);
                qa.i(this.d, this.c);
                while (true) {
                    sa k = qa.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, va.o, null);
                }
                if (qa.q(this.d) <= 0) {
                    return false;
                }
                wa.a("queue", 0, 0, "onClose", va.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        sa f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = qa.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            wa.c("queue", f.m(), 0, "sendNext", va.r, "");
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
            wa.a("queue", 0, 0, "unBlockMessageQueue", va.s, "Queue block has release");
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

    public pa q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (pa) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(ra.e());
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

    @Override // com.baidu.tieba.bb
    public void d(ck ckVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ckVar) != null) || ckVar == null || (bArr = ckVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            za c = ya.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            wa.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            sa o = o(b2, h);
            if (o != null) {
                o.m = ckVar.b;
                o.n = ckVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && qa.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, va.A, null);
                }
            } else {
                new ra(c, o, this.b, h).execute(new String[0]);
            }
            bb bbVar = this.f;
            if (bbVar != null) {
                bbVar.d(ckVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = wh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            wa.a("queue", 0, 0, "onBinaryMesssage", va.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.bb
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ta.a().c(map);
            pa paVar = this.h;
            if (paVar != null) {
                paVar.e();
            }
            this.g = true;
            wa.a("queue", 0, 0, "onConnected", va.y, "Queue blocked");
            bb bbVar = this.f;
            if (bbVar != null) {
                bbVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof oa)) {
                oa oaVar = (oa) socketMessage;
                if (qa.d(this.d, oaVar, socketMessage.getCmd()) || qa.d(this.c, oaVar, socketMessage.getCmd()) || qa.d(this.e, oaVar, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(ra.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        sa saVar = bVar.b;
        if (saVar != null) {
            v(saVar, va.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        wa.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (qa.e(this.d, cmd) || qa.e(this.c, cmd) || qa.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    qa.o(this.d, cmd);
                    return false;
                }
                qa.o(this.d, cmd);
                qa.o(this.c, cmd);
                qa.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final sa o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                sa p = qa.p(i2, this.c);
                if (p == null && (p = qa.p(i2, this.e)) == null && (p = qa.p(i2, this.d)) == null) {
                    wa.a("queue", i, i2, "findSenderData", va.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                wa.a("queue", i, i2, "findSenderData", va.v, "received ack message");
                return p;
            }
            return null;
        }
        return (sa) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(sa saVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, saVar, i, str) == null) && saVar != null && saVar.m() != null) {
            int cmd = saVar.m().getCmd();
            int q = saVar.q();
            wa.c("queue", saVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + saVar.p());
            if (saVar != null) {
                socketMessageTask = saVar.t();
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
                    socketResponsedMessage.setErrorString(va.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(saVar.m());
                wa.c("queue", saVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
