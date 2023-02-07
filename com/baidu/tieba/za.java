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
import com.baidu.tieba.wa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class za extends ra<SocketMessage, SocketMessageTask> implements gb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wa.a b;
    public final LinkedList<xa> c;
    public final LinkedList<xa> d;
    public final LinkedList<xa> e;
    public gb f;
    public boolean g;
    public ua h;
    public long i;
    public int j;

    @Override // com.baidu.tieba.oa
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(xa xaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, xaVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements wa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za a;

        public a(za zaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zaVar;
        }

        @Override // com.baidu.tieba.wa.a
        public void a(wa.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) {
                return;
            }
            this.a.w(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(269393320, "Lcom/baidu/tieba/za$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(269393320, "Lcom/baidu/tieba/za$b;");
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
    public za(MessageManager messageManager) {
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

    public void A(xa xaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xaVar) == null) {
            if (xaVar != null && xaVar.i() && xaVar.p() < xaVar.l()) {
                va.j(this.c, this.e, xaVar);
                ua uaVar = this.h;
                if (uaVar != null) {
                    uaVar.b(true, "timeout seq = " + xaVar.q());
                }
                bb.c("queue", xaVar.m(), xaVar.q(), "onSendTimeOut", ab.t, String.valueOf(xaVar.p()));
                return;
            }
            C(xaVar);
            v(xaVar, ab.m, null);
            E();
        }
    }

    @Override // com.baidu.tieba.oa
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            va.m(this.c, i, bdUniqueId);
            va.m(this.d, i, bdUniqueId);
            va.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!va.c(this.d, i, bdUniqueId) && !va.c(this.c, i, bdUniqueId) && !va.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, xa xaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, xaVar) == null) {
            if (i == 2) {
                if (xaVar.r() != null) {
                    i2 = xaVar.r().getErrorCode();
                } else {
                    i2 = ab.i;
                }
            } else {
                i2 = ab.n;
            }
            String i3 = ab.i(i2);
            C(xaVar);
            v(xaVar, i2, i3);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(xa xaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xaVar) != null) || xaVar == null) {
            return;
        }
        xaVar.w();
        va.n(xaVar, this.c);
        va.n(xaVar, this.d);
        va.n(xaVar, this.e);
    }

    public void F(gb gbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gbVar) == null) {
            this.f = gbVar;
        }
    }

    public void G(ua uaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uaVar) == null) {
            this.h = uaVar;
        }
    }

    @Override // com.baidu.tieba.gb
    public void a(String str) {
        gb gbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (gbVar = this.f) != null) {
            gbVar.a(str);
        }
    }

    @Override // com.baidu.tieba.gb
    public void c(zj zjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zjVar) == null) {
            E();
            gb gbVar = this.f;
            if (gbVar != null) {
                gbVar.c(zjVar);
            }
        }
    }

    public final void k(LinkedList<xa> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            xa l = va.l(linkedList);
            if (l != null) {
                l.w();
                v(l, ab.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), wa.e());
        }
        return invokeI.intValue;
    }

    public void z(xa xaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, xaVar) != null) || xaVar == null) {
            return;
        }
        if (xaVar.v()) {
            xaVar.h();
            va.j(this.d, this.c, xaVar);
            return;
        }
        va.n(xaVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oa
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            ej.c();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.a())) {
                    bb.c("queue", socketMessage, 0, "sendMessage", ab.q, "duplicate message be removed");
                    return;
                }
                xa xaVar = new xa(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    bb.c("queue", socketMessage, 0, "sendMessage", ab.z, "user manual close socket");
                    xaVar.a(ab.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    bb.c("queue", socketMessage, 0, "sendMessage", ab.p, "isManualBlock message be removed");
                    xaVar.a(ab.p);
                } else {
                    bb.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    va.h(xaVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.gb
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            gb gbVar = this.f;
            if (gbVar != null) {
                gbVar.b(i, str);
            }
            ua uaVar = this.h;
            if (uaVar != null) {
                uaVar.a();
            }
            if (ej.F() && !va.a(this.e) && !va.a(this.d) && !va.a(this.c) && BdSocketLinkService.isAvailable()) {
                va.b(this.c);
                va.i(this.d, this.e);
                va.i(this.d, this.c);
                while (true) {
                    xa k = va.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, ab.o, null);
                }
                if (va.q(this.d) <= 0) {
                    return false;
                }
                bb.a("queue", 0, 0, "onClose", ab.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        xa f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = va.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            bb.c("queue", f.m(), 0, "sendNext", ab.r, "");
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
            bb.a("queue", 0, 0, "unBlockMessageQueue", ab.s, "Queue block has release");
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

    public ua q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (ua) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(wa.e());
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

    @Override // com.baidu.tieba.gb
    public void d(hk hkVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, hkVar) != null) || hkVar == null || (bArr = hkVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            eb c = db.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            bb.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            xa o = o(b2, h);
            if (o != null) {
                o.m = hkVar.b;
                o.n = hkVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && va.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, ab.A, null);
                }
            } else {
                new wa(c, o, this.b, h).execute(new String[0]);
            }
            gb gbVar = this.f;
            if (gbVar != null) {
                gbVar.d(hkVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = bi.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            bb.a("queue", 0, 0, "onBinaryMesssage", ab.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.gb
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ya.a().c(map);
            ua uaVar = this.h;
            if (uaVar != null) {
                uaVar.e();
            }
            this.g = true;
            bb.a("queue", 0, 0, "onConnected", ab.y, "Queue blocked");
            gb gbVar = this.f;
            if (gbVar != null) {
                gbVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof ta)) {
                ta taVar = (ta) socketMessage;
                if (va.d(this.d, taVar, socketMessage.getCmd()) || va.d(this.c, taVar, socketMessage.getCmd()) || va.d(this.e, taVar, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(wa.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        xa xaVar = bVar.b;
        if (xaVar != null) {
            v(xaVar, ab.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        bb.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (va.e(this.d, cmd) || va.e(this.c, cmd) || va.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    va.o(this.d, cmd);
                    return false;
                }
                va.o(this.d, cmd);
                va.o(this.c, cmd);
                va.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final xa o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                xa p = va.p(i2, this.c);
                if (p == null && (p = va.p(i2, this.e)) == null && (p = va.p(i2, this.d)) == null) {
                    bb.a("queue", i, i2, "findSenderData", ab.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                bb.a("queue", i, i2, "findSenderData", ab.v, "received ack message");
                return p;
            }
            return null;
        }
        return (xa) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(xa xaVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, xaVar, i, str) == null) && xaVar != null && xaVar.m() != null) {
            int cmd = xaVar.m().getCmd();
            int q = xaVar.q();
            bb.c("queue", xaVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + xaVar.p());
            if (xaVar != null) {
                socketMessageTask = xaVar.t();
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
                    socketResponsedMessage.setErrorString(ab.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(xaVar.m());
                bb.c("queue", xaVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
