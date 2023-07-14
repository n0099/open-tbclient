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
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ka;
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
public class na extends fa<SocketMessage, SocketMessageTask> implements ua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ka.a b;
    public final LinkedList<la> c;
    public final LinkedList<la> d;
    public final LinkedList<la> e;
    public ua f;
    public boolean g;
    public ia h;
    public long i;
    public int j;

    @Override // com.baidu.tieba.ca
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    public void y(la laVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, laVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ka.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na a;

        public a(na naVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {naVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = naVar;
        }

        @Override // com.baidu.tieba.ka.a
        public void a(ka.b bVar) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(258311068, "Lcom/baidu/tieba/na$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(258311068, "Lcom/baidu/tieba/na$b;");
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
    public na(MessageManager messageManager) {
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

    public void A(la laVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, laVar) == null) {
            if (laVar != null && laVar.i() && laVar.p() < laVar.l()) {
                ja.j(this.c, this.e, laVar);
                ia iaVar = this.h;
                if (iaVar != null) {
                    iaVar.b(true, "timeout seq = " + laVar.q());
                }
                pa.c("queue", laVar.m(), laVar.q(), "onSendTimeOut", oa.t, String.valueOf(laVar.p()));
                return;
            }
            C(laVar);
            v(laVar, oa.m, null);
            E();
        }
    }

    @Override // com.baidu.tieba.ca
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            ja.m(this.c, i, bdUniqueId);
            ja.m(this.d, i, bdUniqueId);
            ja.m(this.e, i, bdUniqueId);
        }
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) {
            if (!ja.c(this.d, i, bdUniqueId) && !ja.c(this.c, i, bdUniqueId) && !ja.c(this.e, i, bdUniqueId)) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void x(int i, la laVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, laVar) == null) {
            if (i == 2) {
                if (laVar.r() != null) {
                    i2 = laVar.r().getErrorCode();
                } else {
                    i2 = oa.i;
                }
            } else {
                i2 = oa.n;
            }
            String i3 = oa.i(i2);
            C(laVar);
            v(laVar, i2, i3);
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(la laVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, laVar) != null) || laVar == null) {
            return;
        }
        laVar.w();
        ja.n(laVar, this.c);
        ja.n(laVar, this.d);
        ja.n(laVar, this.e);
    }

    public void F(ua uaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uaVar) == null) {
            this.f = uaVar;
        }
    }

    public void G(ia iaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iaVar) == null) {
            this.h = iaVar;
        }
    }

    @Override // com.baidu.tieba.ua
    public void a(String str) {
        ua uaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (uaVar = this.f) != null) {
            uaVar.a(str);
        }
    }

    @Override // com.baidu.tieba.ua
    public void c(tj tjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tjVar) == null) {
            E();
            ua uaVar = this.f;
            if (uaVar != null) {
                uaVar.c(tjVar);
            }
        }
    }

    public final void k(LinkedList<la> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            la l = ja.l(linkedList);
            if (l != null) {
                l.w();
                v(l, oa.o, null);
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
            return BdAsyncTask.getTaskNum(String.valueOf(i), ka.e());
        }
        return invokeI.intValue;
    }

    public void z(la laVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, laVar) != null) || laVar == null) {
            return;
        }
        if (laVar.v()) {
            laVar.h();
            ja.j(this.d, this.c, laVar);
            return;
        }
        ja.n(laVar, this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ca
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            yi.c();
            if (socketMessage != null && socketMessageTask != null) {
                if (m(socketMessage, socketMessageTask.a())) {
                    pa.c("queue", socketMessage, 0, "sendMessage", oa.q, "duplicate message be removed");
                    return;
                }
                la laVar = new la(socketMessage, socketMessageTask, this);
                if (BdSocketLinkService.hasAbsoluteClose()) {
                    pa.c("queue", socketMessage, 0, "sendMessage", oa.z, "user manual close socket");
                    laVar.a(oa.z);
                } else if (!BdSocketLinkService.isAvailable()) {
                    pa.c("queue", socketMessage, 0, "sendMessage", oa.p, "isManualBlock message be removed");
                    laVar.a(oa.p);
                } else {
                    pa.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                    ja.h(laVar, this.d);
                    E();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ua
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            ua uaVar = this.f;
            if (uaVar != null) {
                uaVar.b(i, str);
            }
            ia iaVar = this.h;
            if (iaVar != null) {
                iaVar.a();
            }
            if (yi.G() && !ja.a(this.e) && !ja.a(this.d) && !ja.a(this.c) && BdSocketLinkService.isAvailable()) {
                ja.b(this.c);
                ja.i(this.d, this.e);
                ja.i(this.d, this.c);
                while (true) {
                    la k = ja.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, oa.o, null);
                }
                if (ja.q(this.d) <= 0) {
                    return false;
                }
                pa.a("queue", 0, 0, "onClose", oa.u, "have retry message, MessageQueue:reconnect");
                BdSocketLinkService.startService(false, "have retry message");
                return true;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void E() {
        la f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (f = ja.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            pa.c("queue", f.m(), 0, "sendNext", oa.r, "");
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
            pa.a("queue", 0, 0, "unBlockMessageQueue", oa.s, "Queue block has release");
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

    public ia q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return (ia) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return BdAsyncTask.getTaskNum(ka.e());
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

    @Override // com.baidu.tieba.ua
    public void d(bk bkVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bkVar) != null) || bkVar == null || (bArr = bkVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            sa c = ra.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            pa.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            la o = o(b2, h);
            if (o != null) {
                o.m = bkVar.b;
                o.n = bkVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && ja.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h != 0 && (o == null || o.k() != b2)) {
                if (o != null) {
                    v(o, oa.A, null);
                }
            } else {
                new ka(c, o, this.b, h).execute(new String[0]);
            }
            ua uaVar = this.f;
            if (uaVar != null) {
                uaVar.d(bkVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = uh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            pa.a("queue", 0, 0, "onBinaryMesssage", oa.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.baidu.tieba.ua
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ma.a().c(map);
            ia iaVar = this.h;
            if (iaVar != null) {
                iaVar.e();
            }
            this.g = true;
            pa.a("queue", 0, 0, "onConnected", oa.y, "Queue blocked");
            ua uaVar = this.f;
            if (uaVar != null) {
                uaVar.g(map);
            }
        }
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof ha)) {
                ha haVar = (ha) socketMessage;
                if (ja.d(this.d, haVar, socketMessage.getCmd()) || ja.d(this.c, haVar, socketMessage.getCmd()) || ja.d(this.e, haVar, socketMessage.getCmd())) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(ka.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, bVar) != null) || bVar == null) {
            return;
        }
        la laVar = bVar.b;
        if (laVar != null) {
            v(laVar, oa.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        pa.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
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
                            if (ja.e(this.d, cmd) || ja.e(this.c, cmd) || ja.e(this.e, cmd)) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    ja.o(this.d, cmd);
                    return false;
                }
                ja.o(this.d, cmd);
                ja.o(this.c, cmd);
                ja.o(this.e, cmd);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final la o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                la p = ja.p(i2, this.c);
                if (p == null && (p = ja.p(i2, this.e)) == null && (p = ja.p(i2, this.d)) == null) {
                    pa.a("queue", i, i2, "findSenderData", oa.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                pa.a("queue", i, i2, "findSenderData", oa.v, "received ack message");
                return p;
            }
            return null;
        }
        return (la) invokeII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(la laVar, int i, String str) {
        SocketMessageTask socketMessageTask;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048604, this, laVar, i, str) == null) && laVar != null && laVar.m() != null) {
            int cmd = laVar.m().getCmd();
            int q = laVar.q();
            pa.c("queue", laVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + laVar.p());
            NetLog.getInstance().c("Request_socket", "onMessageSendFail ： " + i + str);
            if (laVar != null) {
                socketMessageTask = laVar.t();
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
                    socketResponsedMessage.setErrorString(oa.i(i));
                } else {
                    socketResponsedMessage.setErrorString(str);
                }
                socketResponsedMessage.setOrginalMessage(laVar.m());
                pa.c("queue", laVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
                this.a.dispatchResponsedMessage(socketResponsedMessage);
                return;
            }
            socketResponsedMessage = null;
            if (socketResponsedMessage != null) {
            }
        }
    }
}
