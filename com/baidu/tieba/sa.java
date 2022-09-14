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
import com.baidu.tieba.pa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes5.dex */
public class sa extends ka<SocketMessage, SocketMessageTask> implements za {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pa.a b;
    public final LinkedList<qa> c;
    public final LinkedList<qa> d;
    public final LinkedList<qa> e;
    public za f;
    public boolean g;
    public na h;
    public long i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements pa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa a;

        public a(sa saVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {saVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = saVar;
        }

        @Override // com.baidu.tieba.pa.a
        public void a(pa.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.w(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(262928673, "Lcom/baidu/tieba/sa$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(262928673, "Lcom/baidu/tieba/sa$b;");
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
    public sa(MessageManager messageManager) {
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

    public void A(qa qaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qaVar) == null) {
            if (qaVar != null && qaVar.i() && qaVar.p() < qaVar.l()) {
                oa.j(this.c, this.e, qaVar);
                na naVar = this.h;
                if (naVar != null) {
                    naVar.b(true, "timeout seq = " + qaVar.q());
                }
                ua.c("queue", qaVar.m(), qaVar.q(), "onSendTimeOut", ta.t, String.valueOf(qaVar.p()));
                return;
            }
            C(qaVar);
            v(qaVar, ta.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(qa qaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qaVar) == null) || qaVar == null) {
            return;
        }
        qaVar.w();
        oa.n(qaVar, this.c);
        oa.n(qaVar, this.d);
        oa.n(qaVar, this.e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ha
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            ej.c();
            if (socketMessage == null || socketMessageTask == null) {
                return;
            }
            if (m(socketMessage, socketMessageTask.a())) {
                ua.c("queue", socketMessage, 0, "sendMessage", ta.q, "duplicate message be removed");
                return;
            }
            qa qaVar = new qa(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                ua.c("queue", socketMessage, 0, "sendMessage", ta.z, "user manual close socket");
                qaVar.a(ta.z);
            } else if (!BdSocketLinkService.isAvailable()) {
                ua.c("queue", socketMessage, 0, "sendMessage", ta.p, "isManualBlock message be removed");
                qaVar.a(ta.p);
            } else {
                ua.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                oa.h(qaVar, this.d);
                E();
            }
        }
    }

    public final void E() {
        qa f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (f = oa.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            ua.c("queue", f.m(), 0, "sendNext", ta.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.g || f.n() <= -3) {
            BdSocketLinkService.sendMessage(f);
        }
    }

    public void F(za zaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zaVar) == null) {
            this.f = zaVar;
        }
    }

    public void G(na naVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, naVar) == null) {
            this.h = naVar;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = this.g;
            this.g = false;
            ua.a("queue", 0, 0, "unBlockMessageQueue", ta.s, "Queue block has release");
            if (z) {
                E();
            }
        }
    }

    @Override // com.baidu.tieba.za
    public void a(String str) {
        za zaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (zaVar = this.f) == null) {
            return;
        }
        zaVar.a(str);
    }

    @Override // com.baidu.tieba.za
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            za zaVar = this.f;
            if (zaVar != null) {
                zaVar.b(i, str);
            }
            na naVar = this.h;
            if (naVar != null) {
                naVar.a();
            }
            if (ej.D() && !oa.a(this.e) && !oa.a(this.d) && !oa.a(this.c) && BdSocketLinkService.isAvailable()) {
                oa.b(this.c);
                oa.i(this.d, this.e);
                oa.i(this.d, this.c);
                while (true) {
                    qa k = oa.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, ta.o, null);
                }
                if (oa.q(this.d) > 0) {
                    ua.a("queue", 0, 0, "onClose", ta.u, "have retry message, MessageQueue:reconnect");
                    BdSocketLinkService.startService(false, "have retry message");
                    return true;
                }
                return false;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.za
    public void c(zj zjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zjVar) == null) {
            E();
            za zaVar = this.f;
            if (zaVar != null) {
                zaVar.c(zjVar);
            }
        }
    }

    @Override // com.baidu.tieba.za
    public void d(hk hkVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, hkVar) == null) || hkVar == null || (bArr = hkVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            xa c = wa.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            ua.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            qa o = o(b2, h);
            if (o != null) {
                o.m = hkVar.b;
                o.n = hkVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && oa.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h == 0 || (o != null && o.k() == b2)) {
                new pa(c, o, this.b, h).execute(new String[0]);
            } else if (o != null) {
                v(o, ta.A, null);
            }
            za zaVar = this.f;
            if (zaVar != null) {
                zaVar.d(hkVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = bi.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            ua.a("queue", 0, 0, "onBinaryMesssage", ta.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.ha
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.za
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ra.a().c(map);
            na naVar = this.h;
            if (naVar != null) {
                naVar.e();
            }
            this.g = true;
            ua.a("queue", 0, 0, "onConnected", ta.y, "Queue blocked");
            za zaVar = this.f;
            if (zaVar != null) {
                zaVar.g(map);
            }
        }
    }

    @Override // com.baidu.tieba.ha
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            oa.m(this.c, i, bdUniqueId);
            oa.m(this.d, i, bdUniqueId);
            oa.m(this.e, i, bdUniqueId);
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

    public final void k(LinkedList<qa> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            qa l = oa.l(linkedList);
            if (l == null) {
                return;
            }
            l.w();
            v(l, ta.o, null);
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, socketResponsedMessage) == null) {
            this.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, socketMessage, dupLicateMode)) == null) {
            if (socketMessage != null) {
                int cmd = socketMessage.getCmd();
                int i = b.a[dupLicateMode.ordinal()];
                if (i == 1) {
                    oa.o(this.d, cmd);
                    oa.o(this.c, cmd);
                    oa.o(this.e, cmd);
                    return false;
                } else if (i == 2) {
                    oa.o(this.d, cmd);
                    return false;
                } else if (i != 3) {
                    return false;
                } else {
                    return oa.e(this.d, cmd) || oa.e(this.c, cmd) || oa.e(this.e, cmd);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage == null || !(socketMessage instanceof ma)) {
                return false;
            }
            ma maVar = (ma) socketMessage;
            return oa.d(this.d, maVar, socketMessage.getCmd()) || oa.d(this.c, maVar, socketMessage.getCmd()) || oa.d(this.e, maVar, socketMessage.getCmd());
        }
        return invokeL.booleanValue;
    }

    public final qa o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                qa p = oa.p(i2, this.c);
                if (p == null && (p = oa.p(i2, this.e)) == null && (p = oa.p(i2, this.d)) == null) {
                    ua.a("queue", i, i2, "findSenderData", ta.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                ua.a("queue", i, i2, "findSenderData", ta.v, "received ack message");
                return p;
            }
            return null;
        }
        return (qa) invokeII.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.i : invokeV.longValue;
    }

    public na q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h : (na) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? BdAsyncTask.getTaskNum(pa.e()) : invokeV.intValue;
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) ? BdAsyncTask.getTaskNum(String.valueOf(i), pa.e()) : invokeI.intValue;
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) ? oa.c(this.d, i, bdUniqueId) || oa.c(this.c, i, bdUniqueId) || oa.c(this.e, i, bdUniqueId) : invokeIL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? BdSocketLinkService.isOpen() && !this.g && BdSocketLinkService.isAvailable() : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(qa qaVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048604, this, qaVar, i, str) == null) || qaVar == null || qaVar.m() == null) {
            return;
        }
        int cmd = qaVar.m().getCmd();
        int q = qaVar.q();
        ua.c("queue", qaVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + qaVar.p());
        SocketMessageTask t = qaVar != null ? qaVar.t() : null;
        if (t == null) {
            t = (SocketMessageTask) this.a.findTask(cmd);
        }
        if (t != null && t.getResponsedClass() != null) {
            try {
                socketResponsedMessage = t.getResponsedClass().newInstance();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                try {
                    socketResponsedMessage = t.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (socketResponsedMessage != null) {
                return;
            }
            socketResponsedMessage.setError(i);
            if (str == null) {
                socketResponsedMessage.setErrorString(ta.i(i));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(qaVar.m());
            ua.c("queue", qaVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.a.dispatchResponsedMessage(socketResponsedMessage);
            return;
        }
        socketResponsedMessage = null;
        if (socketResponsedMessage != null) {
        }
    }

    public final void w(pa.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) || bVar == null) {
            return;
        }
        qa qaVar = bVar.b;
        if (qaVar != null) {
            v(qaVar, ta.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        ua.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void x(int i, qa qaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, qaVar) == null) {
            if (i == 2) {
                if (qaVar.r() != null) {
                    i2 = qaVar.r().getErrorCode();
                } else {
                    i2 = ta.i;
                }
            } else {
                i2 = ta.n;
            }
            String i3 = ta.i(i2);
            C(qaVar);
            v(qaVar, i2, i3);
        }
    }

    public void y(qa qaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, qaVar) == null) {
        }
    }

    public void z(qa qaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, qaVar) == null) || qaVar == null) {
            return;
        }
        if (qaVar.v()) {
            qaVar.h();
            oa.j(this.d, this.c, qaVar);
            return;
        }
        oa.n(qaVar, this.d);
    }
}
