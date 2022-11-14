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
import com.baidu.tieba.qa;
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
public class ta extends la<SocketMessage, SocketMessageTask> implements ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qa.a b;
    public final LinkedList<ra> c;
    public final LinkedList<ra> d;
    public final LinkedList<ra> e;
    public ab f;
    public boolean g;
    public oa h;
    public long i;
    public int j;

    @Override // com.baidu.tieba.ia
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(ra raVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, raVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements qa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta a;

        public a(ta taVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = taVar;
        }

        @Override // com.baidu.tieba.qa.a
        public void a(qa.b bVar) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(263852194, "Lcom/baidu/tieba/ta$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(263852194, "Lcom/baidu/tieba/ta$b;");
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
    public ta(MessageManager messageManager) {
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

    public void A(ra raVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, raVar) == null) {
            if (raVar != null && raVar.i() && raVar.p() < raVar.l()) {
                pa.j(this.c, this.e, raVar);
                oa oaVar = this.h;
                if (oaVar != null) {
                    oaVar.b(true, "timeout seq = " + raVar.q());
                }
                va.c("queue", raVar.m(), raVar.q(), "onSendTimeOut", ua.t, String.valueOf(raVar.p()));
                return;
            }
            C(raVar);
            v(raVar, ua.m, null);
            E();
        }
    }

    @Override // com.baidu.tieba.ia
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            pa.m(this.c, i, bdUniqueId);
            pa.m(this.d, i, bdUniqueId);
            pa.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!pa.c(this.d, i, bdUniqueId) && !pa.c(this.c, i, bdUniqueId) && !pa.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, ra raVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, raVar) == null) {
            if (i == 2) {
                if (raVar.r() != null) {
                    i2 = raVar.r().getErrorCode();
                } else {
                    i2 = ua.i;
                }
            } else {
                i2 = ua.n;
            }
            String i3 = ua.i(i2);
            C(raVar);
            v(raVar, i2, i3);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(ra raVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, raVar) != null) || raVar == null) {
            return;
        }
        raVar.w();
        pa.n(raVar, this.c);
        pa.n(raVar, this.d);
        pa.n(raVar, this.e);
    }

    public void F(ab abVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, abVar) == null) {
            this.f = abVar;
        }
    }

    public void G(oa oaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oaVar) == null) {
            this.h = oaVar;
        }
    }

    @Override // com.baidu.tieba.ab
    public void a(String str) {
        ab abVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (abVar = this.f) != null) {
            abVar.a(str);
        }
    }

    @Override // com.baidu.tieba.ab
    public void c(tj tjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tjVar) == null) {
            E();
            ab abVar = this.f;
            if (abVar != null) {
                abVar.c(tjVar);
            }
        }
    }

    public final void k(LinkedList<ra> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            ra l = pa.l(linkedList);
            if (l != null) {
                l.w();
                v(l, ua.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), qa.e());
        }
        return invokeI.intValue;
    }

    public void z(ra raVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, raVar) != null) || raVar == null) {
            return;
        }
        if (raVar.v()) {
            raVar.h();
            pa.j(this.d, this.c, raVar);
            return;
        }
        pa.n(raVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ia
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            yi.c();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.a())) {
                    va.c("queue", socketMessage, 0, "sendMessage", ua.q, "duplicate message be removed");
                    return;
                }
                ra raVar = new ra(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    va.c("queue", socketMessage, 0, "sendMessage", ua.z, "user manual close socket");
                    raVar.a(ua.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    va.c("queue", socketMessage, 0, "sendMessage", ua.p, "isManualBlock message be removed");
                    raVar.a(ua.p);
                } else {
                    va.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    pa.h(raVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ab
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            ab abVar = this.f;
            if (abVar != null) {
                abVar.b(i, str);
            }
            oa oaVar = this.h;
            if (oaVar != null) {
                oaVar.a();
            }
            if (yi.F() && !pa.a(this.e) && !pa.a(this.d) && !pa.a(this.c) && BdSocketLinkService.isAvailable()) {
                pa.b(this.c);
                pa.i(this.d, this.e);
                pa.i(this.d, this.c);
                while (true) {
                    ra k = pa.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, ua.o, null);
                }
                if (pa.q(this.d) <= 0) {
                    return false;
                }
                va.a("queue", 0, 0, "onClose", ua.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        ra f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = pa.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            va.c("queue", f.m(), 0, "sendNext", ua.r, "");
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
            va.a("queue", 0, 0, "unBlockMessageQueue", ua.s, "Queue block has release");
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

    public oa q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (oa) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(qa.e());
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

    @Override // com.baidu.tieba.ab
    public void d(bk bkVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bkVar) != null) || bkVar == null || (bArr = bkVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            ya c = xa.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            va.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            ra o = o(b2, h);
            if (o != null) {
                o.m = bkVar.b;
                o.n = bkVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && pa.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, ua.A, null);
                }
            } else {
                new qa(c, o, this.b, h).execute(new String[0]);
            }
            ab abVar = this.f;
            if (abVar != null) {
                abVar.d(bkVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = vh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            va.a("queue", 0, 0, "onBinaryMesssage", ua.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.ab
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            sa.a().c(map);
            oa oaVar = this.h;
            if (oaVar != null) {
                oaVar.e();
            }
            this.g = true;
            va.a("queue", 0, 0, "onConnected", ua.y, "Queue blocked");
            ab abVar = this.f;
            if (abVar != null) {
                abVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof na)) {
                na naVar = (na) socketMessage;
                if (pa.d(this.d, naVar, socketMessage.getCmd()) || pa.d(this.c, naVar, socketMessage.getCmd()) || pa.d(this.e, naVar, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(qa.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        ra raVar = bVar.b;
        if (raVar != null) {
            v(raVar, ua.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        va.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (pa.e(this.d, cmd) || pa.e(this.c, cmd) || pa.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    pa.o(this.d, cmd);
                    return false;
                }
                pa.o(this.d, cmd);
                pa.o(this.c, cmd);
                pa.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final ra o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                ra p = pa.p(i2, this.c);
                if (p == null && (p = pa.p(i2, this.e)) == null && (p = pa.p(i2, this.d)) == null) {
                    va.a("queue", i, i2, "findSenderData", ua.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                va.a("queue", i, i2, "findSenderData", ua.v, "received ack message");
                return p;
            }
            return null;
        }
        return (ra) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(ra raVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, raVar, i, str) == null) && raVar != null && raVar.m() != null) {
            int cmd = raVar.m().getCmd();
            int q = raVar.q();
            va.c("queue", raVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + raVar.p());
            if (raVar != null) {
                socketMessageTask = raVar.t();
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
                    socketResponsedMessage.setErrorString(ua.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(raVar.m());
                va.c("queue", raVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
