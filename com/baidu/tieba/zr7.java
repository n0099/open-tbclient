package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
import com.baidu.tieba.wk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public class zr7 extends dg1<qb5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements qb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<ub5> c;
        @NonNull
        public final Map<Long, vb5> d;
        public final IChatRoomMsgReceiveListener e;
        public final Map<Long, wk5> f;
        public final Map<wb5, IConnectListener> g;
        @NonNull
        public final Map<Long, String> h;

        /* loaded from: classes7.dex */
        public class b implements wk5.c<wk5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ sb5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.zr7$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0504a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ wk5.c b;
                public final /* synthetic */ b c;

                public C0504a(b bVar, boolean z, wk5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = bVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        js7.e(this.c.b.longValue(), i, str);
                        if (i != 0) {
                            if (this.a) {
                                js7.j("im_enter_auto_retry_", this.c.b.longValue());
                                b bVar = this.c;
                                bVar.c.a(bVar.b.longValue(), i, str, chatRoomInfo);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        js7.j("im_enter_auto_retry_", this.c.b.longValue());
                        this.c.d.f.remove(this.c.b);
                        b bVar2 = this.c;
                        bVar2.c.a(bVar2.b.longValue(), i, str, chatRoomInfo);
                    }
                }
            }

            public b(a aVar, Context context, Long l, sb5 sb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, sb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = context;
                this.b = l;
                this.c = sb5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wk5.c
            public void call(boolean z, wk5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b.longValue(), new C0504a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements wk5.c<wk5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ tb5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.zr7$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0505a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ wk5.c b;
                public final /* synthetic */ c c;

                public C0505a(c cVar, boolean z, wk5.c cVar2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, Boolean.valueOf(z), cVar2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = cVar;
                    this.a = z;
                    this.b = cVar2;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        js7.f(this.c.b.longValue(), i, str);
                        if (i != 0) {
                            if (this.a) {
                                js7.j("im_exit_auto_retry_", this.c.b.longValue());
                                c cVar = this.c;
                                cVar.c.a(cVar.b.longValue(), i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        js7.j("im_exit_auto_retry_", this.c.b.longValue());
                        this.c.d.f.remove(this.c.b);
                        c cVar2 = this.c;
                        cVar2.c.a(cVar2.b.longValue(), i, str);
                    }
                }
            }

            public c(a aVar, Context context, Long l, tb5 tb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, tb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = context;
                this.b = l;
                this.c = tb5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wk5.c
            public void call(boolean z, wk5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b.longValue(), new C0505a(this, z, cVar));
                }
            }
        }

        /* renamed from: com.baidu.tieba.zr7$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0503a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0503a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener
            public void onReceiveMessage(int i, long j, List<ChatMsg> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list}) == null) {
                    for (ub5 ub5Var : this.a.c) {
                        if (ub5Var.a(i, j, list)) {
                            return;
                        }
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(qb5.b);
                    treeSet.addAll(list);
                    ((vb5) this.a.d.get(Long.valueOf(j))).a(i, j, treeSet);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yb5 a;

            public d(a aVar, yb5 yb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, yb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = yb5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class e implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xb5 a;

            public e(a aVar, xb5 xb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, xb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = xb5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) == null) {
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(qb5.b);
                    treeSet.addAll(arrayList);
                    this.a.a(i, str, treeSet);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class f implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wb5 a;

            public f(a aVar, wb5 wb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, wb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = wb5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        public a(zr7 zr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            AlaLiveSdkStatic.k();
            this.c = new ArrayList();
            this.d = new HashMap();
            this.e = new C0503a(this);
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
        }

        @Override // com.baidu.tieba.qb5
        public void d(@NonNull wb5 wb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, wb5Var) == null) {
                f fVar = new f(this, wb5Var);
                this.g.put(wb5Var, fVar);
                BIMManager.registerConnectListenerToList(fVar);
            }
        }

        @Override // com.baidu.tieba.qb5
        public void g(@NonNull wb5 wb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, wb5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.g.remove(wb5Var));
            }
        }

        @Override // com.baidu.tieba.qb5
        public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, vb5Var) == null) {
                for (Long l : list) {
                    sk5.b(l);
                    if (this.d.get(l) == vb5Var) {
                        BIMManager.unregisterChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                        this.d.remove(l);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qb5
        public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
                for (Long l : list) {
                    sk5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                }
            }
        }

        @Override // com.baidu.tieba.qb5
        public void b(@NonNull Context context, @NonNull List<Long> list, @NonNull vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, vb5Var) == null) {
                for (Long l : list) {
                    sk5.b(l);
                    this.d.put(l, vb5Var);
                    BIMManager.registerChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                }
            }
        }

        @Override // com.baidu.tieba.qb5
        public void c(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull sb5 sb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, list, sb5Var) == null) {
                for (Long l : list) {
                    sk5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                    wk5 m = m(l.longValue());
                    js7.d("im_enter_auto_retry_", l.longValue());
                    m.i(new b(this, context, l, sb5Var));
                }
            }
        }

        @Override // com.baidu.tieba.qb5
        public void e(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull tb5 tb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, list, tb5Var) == null) {
                for (Long l : list) {
                    sk5.b(l);
                    if (TextUtils.equals(this.h.get(l), str + context)) {
                        wk5 m = m(l.longValue());
                        js7.d("im_exit_auto_retry_", l.longValue());
                        m.i(new c(this, context, l, tb5Var));
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qb5
        public void f(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @NonNull xb5 xb5Var) {
            long j3;
            int i2;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), xb5Var}) == null) {
                if (z) {
                    j4 = Long.MAX_VALUE;
                    j3 = 0;
                    i2 = i * (-1);
                } else if (z2) {
                    j4 = j2;
                    i2 = i * (-1);
                    j3 = 0;
                } else {
                    j3 = j2;
                    i2 = i;
                    j4 = Long.MAX_VALUE;
                }
                BIMManager.fetchChatRoomMsgRequest(context, Constants.APPID_TIEBA, AccountManager.getUK(context), 4, j, j3, j4, i2, z ? 1 : 0, new e(this, xb5Var));
            }
        }

        @Override // com.baidu.tieba.qb5
        public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull yb5 yb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, yb5Var}) == null) {
                BIMManager.sendMsgToChatRoom(context, j, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, new d(this, yb5Var));
            }
        }

        @NonNull
        public final wk5 m(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                wk5 wk5Var = this.f.get(Long.valueOf(j));
                if (wk5Var == null) {
                    wk5 g = wk5.g();
                    this.f.put(Long.valueOf(j), g);
                    return g;
                }
                wk5Var.h();
                return wk5Var;
            }
            return (wk5) invokeJ.objValue;
        }
    }

    public zr7() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dg1
    /* renamed from: a */
    public qb5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (qb5) invokeV.objValue;
    }
}
