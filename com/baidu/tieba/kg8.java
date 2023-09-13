package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.module.alalivesdk.imSdkPersonService.data.PersonFetchMsgResponse;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.kg8;
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
/* loaded from: classes6.dex */
public final class kg8 {
    public static /* synthetic */ Interceptable $ic;
    public static final kg8 a;
    public static final lo5 b;
    public static final ConcurrentHashMap<Long, List<zg8>> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements no5 {
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
            kg8.a.e(arrayList);
            lg8.a.a().a(arrayList);
        }

        @Override // com.baidu.tieba.no5
        public void onReceiveMessage(int i, int i2, final ArrayList<ChatMsg> arrayList) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, arrayList) != null) || arrayList == null) {
                return;
            }
            mg.e(new Runnable() { // from class: com.baidu.tieba.ig8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kg8.a.a(arrayList);
                    }
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements mo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg8 a;

        public b(yg8 yg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yg8Var;
        }

        @Override // com.baidu.tieba.mo5
        public void a(int i, String str, PersonFetchMsgResponse personFetchMsgResponse) {
            List<ChatMsg> msgs;
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, personFetchMsgResponse) == null) {
                TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
                if (personFetchMsgResponse != null && (msgs = personFetchMsgResponse.getMsgs()) != null) {
                    for (ChatMsg chatMsg : msgs) {
                        fh8<?, ?> a = ng8.c.a(chatMsg.getClass());
                        if (a != null) {
                            Object b = lh8.b(a, xg8.a, chatMsg);
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
                yg8 yg8Var = this.a;
                if (str == null) {
                    str = "";
                }
                yg8Var.a(i, str, treeSet);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements oo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBaseMsg a;
        public final /* synthetic */ ah8 b;

        @Override // com.baidu.tieba.oo5
        public void a(ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, chatMsg) == null) {
            }
        }

        public c(TbBaseMsg tbBaseMsg, ah8 ah8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbBaseMsg, ah8Var};
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
            this.b = ah8Var;
        }

        @Override // com.baidu.tieba.oo5
        public void b(int i, String str, SendMsgResponse sendMsgResponse) {
            TbBaseMsg tbBaseMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, sendMsgResponse) == null) {
                TbBaseMsg tbBaseMsg2 = this.a;
                if (sendMsgResponse != null) {
                    ChatMsg chatMsg = sendMsgResponse.msg;
                    fh8<?, ?> a = ng8.c.a(chatMsg.getClass());
                    if (a != null) {
                        Object b = lh8.b(a, xg8.a, chatMsg);
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
                ah8 ah8Var = this.b;
                if (str == null) {
                    str = "";
                }
                ah8Var.a(i, str, tbBaseMsg2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947912237, "Lcom/baidu/tieba/kg8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947912237, "Lcom/baidu/tieba/kg8;");
                return;
            }
        }
        a = new kg8();
        b = ko5.a();
        c = new ConcurrentHashMap<>();
        b.a(a.getContext(), new a());
    }

    public kg8() {
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

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkNotNullExpressionValue(inst, "getInst()");
            return inst;
        }
        return (Context) invokeV.objValue;
    }

    public static final void h(TbBaseMsg tbMsg, ah8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbMsg, callback) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "$tbMsg");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            a.i(tbMsg, callback);
        }
    }

    public final void g(final TbBaseMsg tbMsg, final ah8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbMsg, callback) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            Intrinsics.checkNotNullParameter(callback, "callback");
            mg.e(new Runnable() { // from class: com.baidu.tieba.jg8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kg8.h(TbBaseMsg.this, callback);
                    }
                }
            });
        }
    }

    public static final void c(long j, long j2, long j3, int i, yg8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            a.d(j, j2, j3, i, callback);
        }
    }

    public final void b(final long j, final long j2, final long j3, final int i, final yg8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            mg.e(new Runnable() { // from class: com.baidu.tieba.hg8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kg8.c(j, j2, j3, i, callback);
                    }
                }
            });
        }
    }

    @WorkerThread
    public final void d(long j, long j2, long j3, int i, yg8 yg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), yg8Var}) == null) {
            b.b(getContext(), j2, j3, i, j, new b(yg8Var));
        }
    }

    @WorkerThread
    public final void e(ArrayList<ChatMsg> arrayList) {
        List<zg8> list;
        TbBaseMsg tbBaseMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                fh8<?, ?> a2 = ng8.c.a(next.getClass());
                if (a2 != null) {
                    Object b2 = lh8.b(a2, xg8.a, next);
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
                for (zg8 zg8Var : list) {
                    zg8Var.a(0, treeSet);
                }
            }
        }
    }

    public final synchronized void f(long j, zg8 listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, listener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (j == 0) {
                    return;
                }
                List<zg8> list = c.get(Long.valueOf(j));
                if (list == null) {
                    list = new ArrayList<>();
                    c.put(Long.valueOf(j), list);
                }
                list.add(listener);
            }
        }
    }

    @WorkerThread
    public final void i(TbBaseMsg tbBaseMsg, ah8 ah8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, tbBaseMsg, ah8Var) == null) {
            fh8<?, ?> b2 = ng8.c.b(tbBaseMsg.getClass());
            if (b2 != null) {
                Object a2 = lh8.a(b2, xg8.a, tbBaseMsg);
                if (a2 != null) {
                    ChatMsg chatMsg = (ChatMsg) a2;
                    b.d(getContext(), chatMsg, tbBaseMsg.getSessionId(), new c(tbBaseMsg, ah8Var));
                    lg8.a.a().a(CollectionsKt__CollectionsJVMKt.listOf(chatMsg));
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
    public final synchronized void j(long j, zg8 listener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, listener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (j == 0) {
                    return;
                }
                List<zg8> list = c.get(Long.valueOf(j));
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
