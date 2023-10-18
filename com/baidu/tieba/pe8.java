package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.pe8;
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
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pe8 {
    public static /* synthetic */ Interceptable $ic;
    public static final pe8 a;
    public static final vi5 b;
    public static final ConcurrentHashMap<Long, List<ff8>> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements xi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public static final void a(ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(65537, null, arrayList) != null) {
                return;
            }
            pe8.a.f(arrayList);
            qe8.a.a().a(arrayList);
        }

        @Override // com.baidu.tieba.xi5
        public void onReceiveMessage(int i, int i2, final ArrayList<ChatMsg> arrayList) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, arrayList) != null) || arrayList == null) {
                return;
            }
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.ne8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        pe8.a.a(arrayList);
                    }
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements wi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef8 a;

        public b(ef8 ef8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ef8Var;
        }

        @Override // com.baidu.tieba.wi5
        public void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
            List<ChatMsg> msgs;
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    for (ChatMsg chatMsg : msgs) {
                        kf8<?, ?> a = se8.c.a(chatMsg.getClass());
                        if (a != null) {
                            Object b = qf8.b(a, df8.a, chatMsg);
                            if (b instanceof TbBaseMsg) {
                                tbBaseMsg = (TbBaseMsg) b;
                            } else {
                                tbBaseMsg = null;
                            }
                            if (tbBaseMsg != null) {
                                treeSet.add(tbBaseMsg);
                            }
                        } else {
                            throw new IllegalArgumentException("转换器为null，请检查业务逻辑".toString());
                        }
                    }
                }
                ef8 ef8Var = this.a;
                if (str == null) {
                    str = "";
                }
                ef8Var.a(i, str, treeSet);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements yi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBaseMsg a;
        public final /* synthetic */ gf8 b;

        @Override // com.baidu.tieba.yi5
        public void a(ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, chatMsg) == null) {
            }
        }

        public c(TbBaseMsg tbBaseMsg, gf8 gf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbBaseMsg, gf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbBaseMsg;
            this.b = gf8Var;
        }

        @Override // com.baidu.tieba.yi5
        public void b(int i, String str, SendMsgResponse sendMsgResponse) {
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, sendMsgResponse) == null) {
                TbBaseMsg tbBaseMsg2 = this.a;
                if (sendMsgResponse != null) {
                    ChatMsg chatMsg = sendMsgResponse.msg;
                    kf8<?, ?> a = se8.c.a(chatMsg.getClass());
                    if (a != null) {
                        Object b = qf8.b(a, df8.a, chatMsg);
                        if (b instanceof TbBaseMsg) {
                            tbBaseMsg = (TbBaseMsg) b;
                        } else {
                            tbBaseMsg = null;
                        }
                        if (tbBaseMsg == null) {
                            tbBaseMsg = this.a;
                        }
                        tbBaseMsg2 = tbBaseMsg;
                    }
                }
                gf8 gf8Var = this.b;
                if (str == null) {
                    str = "";
                }
                gf8Var.a(i, str, tbBaseMsg2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059270, "Lcom/baidu/tieba/pe8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059270, "Lcom/baidu/tieba/pe8;");
                return;
            }
        }
        a = new pe8();
        b = ui5.a();
        c = new ConcurrentHashMap<>();
        b.a(a.e(), new a());
    }

    public pe8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            return inst;
        }
        return (Context) invokeV.objValue;
    }

    public static final void i(TbBaseMsg tbMsg, gf8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbMsg, callback) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "$tbMsg");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            a.j(tbMsg, callback);
        }
    }

    public final void h(final TbBaseMsg tbMsg, final gf8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, tbMsg, callback) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            Intrinsics.checkNotNullParameter(callback, "callback");
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.oe8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        pe8.i(TbBaseMsg.this, callback);
                    }
                }
            });
        }
    }

    public static final void c(long j, long j2, long j3, int i, ef8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            a.d(j, j2, j3, i, callback);
        }
    }

    public final void b(final long j, final long j2, final long j3, final int i, final ef8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.me8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        pe8.c(j, j2, j3, i, callback);
                    }
                }
            });
        }
    }

    @WorkerThread
    public final void d(long j, long j2, long j3, int i, ef8 ef8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), ef8Var}) == null) {
            b.b(e(), j2, j3, i, j, new b(ef8Var));
        }
    }

    @WorkerThread
    public final void f(ArrayList<ChatMsg> arrayList) {
        List<ff8> list;
        TbBaseMsg tbBaseMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                kf8<?, ?> a2 = se8.c.a(next.getClass());
                if (a2 != null) {
                    Object b2 = qf8.b(a2, df8.a, next);
                    if (b2 instanceof TbBaseMsg) {
                        tbBaseMsg = (TbBaseMsg) b2;
                    } else {
                        tbBaseMsg = null;
                    }
                    if (tbBaseMsg != null) {
                        treeSet.add(tbBaseMsg);
                    }
                }
            }
            if ((!treeSet.isEmpty()) && (list = c.get(Long.valueOf(treeSet.first().getSessionId()))) != null) {
                for (ff8 ff8Var : list) {
                    ff8Var.a(0, treeSet);
                }
            }
        }
    }

    public final synchronized void g(long j, ff8 listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048580, this, j, listener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (j == 0) {
                    return;
                }
                List<ff8> list = c.get(Long.valueOf(j));
                if (list == null) {
                    list = new ArrayList<>();
                    c.put(Long.valueOf(j), list);
                }
                list.add(listener);
            }
        }
    }

    @WorkerThread
    public final void j(TbBaseMsg tbBaseMsg, gf8 gf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, tbBaseMsg, gf8Var) == null) {
            kf8<?, ?> b2 = se8.c.b(tbBaseMsg.getClass());
            if (b2 != null) {
                Object a2 = qf8.a(b2, df8.a, tbBaseMsg);
                if (a2 != null) {
                    ChatMsg chatMsg = (ChatMsg) a2;
                    b.d(e(), chatMsg, tbBaseMsg.getSessionId(), new c(tbBaseMsg, gf8Var));
                    qe8.a.a().a(CollectionsKt__CollectionsJVMKt.listOf(chatMsg));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.imsdk.chatmessage.messages.ChatMsg");
            }
            throw new IllegalArgumentException("转换器为null，请检查业务逻辑".toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c A[Catch: all -> 0x003b, TryCatch #0 {, blocks: (B:5:0x0005, B:10:0x0012, B:12:0x0020, B:18:0x002c, B:19:0x0036), top: B:28:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:10:0x0012, B:12:0x0020, B:18:0x002c, B:19:0x0036), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void k(long j, ff8 listener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, listener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (j == 0) {
                    return;
                }
                List<ff8> list = c.get(Long.valueOf(j));
                if (list != null && !list.isEmpty()) {
                    z = false;
                    if (!z) {
                        c.remove(Long.valueOf(j));
                    } else {
                        list.remove(listener);
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
    }
}
