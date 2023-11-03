package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.db.pojo.ChatSysNotifyPojo;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import protobuf.NewpushRepair;
/* loaded from: classes9.dex */
public class zs8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public List<GroupUpdateMessage> e;
    public int f;
    public long g;
    public int h;
    public final BdUniqueId i;
    public final Handler j;
    public LongSparseArray<Long> k;
    public LongSparseArray<Long> l;
    public long m;
    public final d6 n;
    public final SocketMessageListener o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2008017) {
                return;
            }
            bc5.j().m();
            zs8.n().B();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016002) {
                return;
            }
            zs8.n().q();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs8 a;

        @Override // com.baidu.tieba.d6
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.d6
        public void c(ke keVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keVar) == null) {
            }
        }

        @Override // com.baidu.tieba.d6
        public void d(se seVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, seVar) == null) {
            }
        }

        public c(zs8 zs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zs8Var;
        }

        @Override // com.baidu.tieba.d6
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                this.a.G();
                v5.a().c(map);
            }
        }

        @Override // com.baidu.tieba.d6
        public boolean b(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
                this.a.H();
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(zs8 zs8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs8Var, Integer.valueOf(i)};
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
            this.a = zs8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || socketResponsedMessage == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 1003) {
                if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() != 0) {
                    return;
                }
                this.a.C();
            } else if (socketResponsedMessage.getCmd() != 1001 || !(socketResponsedMessage instanceof ResponseOnlineMessage)) {
            } else {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (responseOnlineMessage.getError() != 0) {
                    return;
                }
                this.a.e = responseOnlineMessage.getGroupInfos();
                this.a.m = ov4.t().j();
                if (ss8.n().w()) {
                    this.a.q();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(zs8 zs8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs8Var, Integer.valueOf(i)};
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
            this.a = zs8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    this.a.I();
                } else {
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(zs8 zs8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs8Var, Integer.valueOf(i)};
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
            this.a = zs8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.m == ov4.t().j()) {
                return;
            }
            if (this.a.k != null) {
                this.a.k.clear();
            }
            if (this.a.l != null) {
                this.a.l.clear();
            }
            this.a.e = null;
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static final zs8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-221580633, "Lcom/baidu/tieba/zs8$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-221580633, "Lcom/baidu/tieba/zs8$g;");
                    return;
                }
            }
            a = new zs8();
        }
    }

    /* loaded from: classes9.dex */
    public static class h extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 2) {
                    if (i == 3) {
                        zs8.n().j.removeMessages(3);
                        if (zs8.n().h == 3) {
                            zs8.n().x();
                        } else {
                            zs8.n().z();
                        }
                        zs8.n().j.sendMessageDelayed(zs8.n().j.obtainMessage(3), zs8.n().c);
                        return;
                    }
                    return;
                }
                zs8.n().j.removeMessages(2);
                zs8.n().z();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948370634, "Lcom/baidu/tieba/zs8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948370634, "Lcom/baidu/tieba/zs8;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2008017));
        MessageManager.getInstance().registerListener(new b(2016002));
    }

    public zs8() {
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
        this.a = 900000;
        this.b = 360000;
        this.c = 360000;
        this.d = 0;
        this.f = 0;
        this.g = 0L;
        this.h = 0;
        this.i = BdUniqueId.gen();
        this.j = new h(null);
        this.k = null;
        this.l = null;
        this.n = new c(this);
        this.o = new d(this, 0);
        this.p = new e(this, 2001011);
        this.q = new f(this, 2005016);
    }

    public final synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.g < LiveFeedPageSdk.REFRESH_TIME) {
                    return;
                }
                PushCountMessage pushCountMessage = new PushCountMessage();
                pushCountMessage.setPusherCount(this.f);
                pushCountMessage.setUpFlowSize(pe.h().k());
                pushCountMessage.setDownFlowSize(pe.h().g());
                pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
                MessageManager.getInstance().sendMessage(pushCountMessage);
                this.g = System.currentTimeMillis();
                this.f = 0;
                pe.h().d();
                pe.h().e();
                TbadkCoreApplication.getInst().clearEnterForeCount();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.e == null) {
            return;
        }
        boolean z = false;
        LongSparseArray<Long> q = ss8.n().q();
        if (q == null) {
            this.e = null;
            return;
        }
        Iterator<GroupUpdateMessage> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null && q.get(next.getGroupId()) != null) {
                if (q.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                    z = true;
                    break;
                }
            }
        }
        this.h = 3;
        if (z) {
            Handler handler = this.j;
            handler.sendMessage(handler.obtainMessage(3));
        } else {
            n().j.sendMessageDelayed(n().j.obtainMessage(3), n().c);
        }
        this.e = null;
    }

    public final synchronized void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            synchronized (this) {
                this.h = i;
                r(null, i);
            }
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || i <= 0) {
            return;
        }
        this.a = i;
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || i <= 0) {
            return;
        }
        this.b = i;
    }

    public final void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i == 1) {
                if (this.d != 2) {
                    this.d = 1;
                }
            } else if (i == 3 || i == 2) {
                this.d = 2;
            }
        }
    }

    public final void r(LongSparseArray<Long> longSparseArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, longSparseArray, i) == null) {
            s(longSparseArray, i, 0L);
        }
    }

    public static zs8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return g.a;
        }
        return (zs8) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
            if (socketGetMsgStratgy.length == 2) {
                E(socketGetMsgStratgy[0] * 1000);
                D(socketGetMsgStratgy[1] * 1000);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l();
            k();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n().c = n().a;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c = this.b;
        }
    }

    public final void j() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (i = this.d) != 0) {
            if (i == 1) {
                u(0L, 0L, 0L);
            } else {
                z();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.j.removeMessages(3);
            this.j.removeMessages(2);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d = 0;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            j();
        }
    }

    public synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                A(3);
            }
        }
    }

    public synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                A(2);
            }
        }
    }

    public final MessageSyncMessage m(LongSparseArray<Long> longSparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, longSparseArray, i)) == null) {
            MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
            messageSyncMessage.setTag(this.i);
            if (longSparseArray != null && longSparseArray.size() > 0) {
                messageSyncMessage.setGroupMids(longSparseArray);
                NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
                if (makeNewpushRepair != null) {
                    messageSyncMessage.setNewpushRepire(makeNewpushRepair);
                }
            } else {
                messageSyncMessage.setGroupMids(ss8.n().q());
            }
            LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
            if (msgBPicMaxSize != null) {
                messageSyncMessage.setWidth(msgBPicMaxSize.width);
                messageSyncMessage.setHeight(msgBPicMaxSize.height);
            }
            LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
            if (msgSPicMaxSize != null) {
                messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
                messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
            }
            for (ChatSysNotifyPojo chatSysNotifyPojo : nq8.b().e()) {
                int type = chatSysNotifyPojo.getType();
                if (type != 1) {
                    if (type != 2) {
                        if (type != 3) {
                            if (type == 4) {
                                messageSyncMessage.setFanCount(chatSysNotifyPojo.getUnread());
                            }
                        } else {
                            messageSyncMessage.setAtMeCount(chatSysNotifyPojo.getUnread());
                        }
                    } else {
                        messageSyncMessage.setReplyMeCount(chatSysNotifyPojo.getUnread());
                    }
                } else {
                    messageSyncMessage.setAgreeCount(chatSysNotifyPojo.getUnread());
                }
            }
            messageSyncMessage.setSyncTypeString(String.valueOf(i));
            return messageSyncMessage;
        }
        return (MessageSyncMessage) invokeLI.objValue;
    }

    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            if (context != null) {
                MessageManager.getInstance().registerListener(this.p);
                MessageManager.getInstance().registerListener(this.q);
                ec5.j().p(this.n);
                MessageManager.getInstance().registerListener(1003, this.o);
                MessageManager.getInstance().registerListener(1001, this.o);
                MessageManager.getInstance().registerListener(202101, this.o);
                B();
                return;
            }
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
    }

    public final void s(LongSparseArray<Long> longSparseArray, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{longSparseArray, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (MessageManager.getInstance().getSocketClient().r() > 10) {
                hp5.a(false, true, false);
                Handler handler = this.j;
                handler.sendMessageDelayed(handler.obtainMessage(2), 2000L);
                return;
            }
            boolean t = MessageManager.getInstance().getSocketClient().t(202003, this.i);
            int s = MessageManager.getInstance().getSocketClient().s(202003);
            if (!t && s <= 0) {
                l();
                LongSparseArray<Long> longSparseArray2 = null;
                if (longSparseArray != null && longSparseArray.size() > 0) {
                    longSparseArray2 = new LongSparseArray<>();
                    for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                        long keyAt = longSparseArray.keyAt(i2);
                        longSparseArray2.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
                    }
                }
                MessageSyncMessage m = m(longSparseArray2, i);
                if (i != 3 && i != 2) {
                    if (i == 1 && j > 0) {
                        m.setNotifyMsgId(j);
                    }
                } else {
                    m.setNewpushRepire(ss8.n().r());
                }
                MessageManager.getInstance().sendMessage(m);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.d("MsgTabNotifyRemind", "processPullMessage: [202006推过来通知了] 需要拉消息 | 拉消息类型 pullType = " + i);
                hp5.a(true, false, false);
                if (i == 3 || i == 1 || i == 2) {
                    LongSparseArray<Long> longSparseArray3 = this.k;
                    if (longSparseArray3 != null) {
                        longSparseArray3.clear();
                    }
                    LongSparseArray<Long> longSparseArray4 = this.l;
                    if (longSparseArray4 != null) {
                        longSparseArray4.clear();
                        return;
                    }
                    return;
                }
                return;
            }
            hp5.a(false, false, true);
            F(i);
        }
    }

    public synchronized void t(LongSparseArray<Long> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, longSparseArray) == null) {
            synchronized (this) {
                if (longSparseArray != null) {
                    if (longSparseArray.size() != 0) {
                        this.h = 4;
                        this.j.removeMessages(3);
                        n().j.sendMessageDelayed(n().j.obtainMessage(3), n().c);
                        r(longSparseArray, 4);
                    }
                }
            }
        }
    }

    public void u(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            v(j, j2, j3, false);
        }
    }

    public void y(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            hw8.c(j2);
            w(j, j2, j3, false, true);
        }
    }

    public synchronized void v(long j, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                w(j, j2, j3, z, false);
            }
        }
    }

    public synchronized void w(long j, long j2, long j3, boolean z, boolean z2) {
        long j4;
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                this.f++;
                this.h = 1;
                this.j.removeMessages(3);
                n().j.sendMessageDelayed(n().j.obtainMessage(3), n().c);
                if (this.k == null) {
                    LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
                    this.k = longSparseArray;
                    longSparseArray.clear();
                }
                if (this.l == null) {
                    this.l = new LongSparseArray<>();
                }
                LongSparseArray<Long> q = ss8.n().q();
                if (0 != j) {
                    Long l = q.get(j);
                    Long l2 = this.k.get(j);
                    if (l == null) {
                        if (l2 == null || l2.longValue() >= j2) {
                            longValue = j2;
                        } else {
                            longValue = l2.longValue();
                        }
                    } else {
                        longValue = l.longValue();
                    }
                    if (longValue > 0) {
                        this.k.put(j, Long.valueOf(longValue));
                    }
                }
                if (this.k != null && this.k.size() > 0) {
                    for (int i = 0; i < this.k.size(); i++) {
                        long keyAt = this.k.keyAt(i);
                        Long l3 = q.get(keyAt);
                        if (l3 != null && l3.longValue() > 0) {
                            this.k.put(keyAt, l3);
                        }
                    }
                }
                if (!z) {
                    if (j > 0 && j2 > 0) {
                        if (this.l.get(j) == null) {
                            this.l.put(j, Long.valueOf(j2));
                        } else {
                            long longValue2 = this.l.get(j).longValue();
                            if (longValue2 <= j2) {
                                longValue2 = j2;
                            }
                            this.l.put(j, Long.valueOf(longValue2));
                        }
                    }
                    int size = this.k.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        long keyAt2 = this.k.keyAt(i2);
                        long longValue3 = this.k.valueAt(i2).longValue();
                        if (this.l.get(keyAt2) != null) {
                            j4 = this.l.get(keyAt2).longValue();
                        } else {
                            j4 = 0;
                        }
                        if (longValue3 >= j4) {
                            arrayList.add(Long.valueOf(j));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.k.remove(((Long) it.next()).longValue());
                    }
                }
                if (this.k.size() == 0) {
                    l();
                    this.l.clear();
                    return;
                }
                if (z2) {
                    s(this.k, 1, j2);
                } else {
                    r(this.k, 1);
                }
            }
        }
    }
}
