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
import com.baidu.tieba.fk5;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
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
/* loaded from: classes5.dex */
public class kn7 extends yf1<cb5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements cb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<gb5> c;
        @NonNull
        public final Map<Long, hb5> d;
        public final IChatRoomMsgReceiveListener e;
        public final Map<Long, fk5> f;
        public final Map<ib5, IConnectListener> g;
        @NonNull
        public final Map<Long, String> h;

        /* loaded from: classes5.dex */
        public class b implements fk5.b<fk5.b<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ eb5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.kn7$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0338a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ fk5.b b;
                public final /* synthetic */ b c;

                public C0338a(b bVar, boolean z, fk5.b bVar2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Boolean.valueOf(z), bVar2};
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
                    this.b = bVar2;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        if (i != 0) {
                            if (this.a) {
                                b bVar = this.c;
                                bVar.c.a(bVar.b.longValue(), i, str, chatRoomInfo);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        this.c.d.f.remove(this.c.b);
                        b bVar2 = this.c;
                        bVar2.c.a(bVar2.b.longValue(), i, str, chatRoomInfo);
                    }
                }
            }

            public b(a aVar, Context context, Long l, eb5 eb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, eb5Var};
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
                this.c = eb5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.fk5.b
            public void call(boolean z, fk5.b<Void> bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b.longValue(), new C0338a(this, z, bVar));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements fk5.b<fk5.b<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ fb5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.kn7$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0339a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ fk5.b b;
                public final /* synthetic */ c c;

                public C0339a(c cVar, boolean z, fk5.b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, Boolean.valueOf(z), bVar};
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
                    this.b = bVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        if (i != 0) {
                            if (this.a) {
                                c cVar = this.c;
                                cVar.c.a(cVar.b.longValue(), i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        this.c.d.f.remove(this.c.b);
                        c cVar2 = this.c;
                        cVar2.c.a(cVar2.b.longValue(), i, str);
                    }
                }
            }

            public c(a aVar, Context context, Long l, fb5 fb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, fb5Var};
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
                this.c = fb5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.fk5.b
            public void call(boolean z, fk5.b<Void> bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b.longValue(), new C0339a(this, z, bVar));
                }
            }
        }

        /* renamed from: com.baidu.tieba.kn7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0337a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0337a(a aVar) {
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
                    for (gb5 gb5Var : this.a.c) {
                        if (gb5Var.a(i, j, list)) {
                            return;
                        }
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(cb5.b);
                    treeSet.addAll(list);
                    ((hb5) this.a.d.get(Long.valueOf(j))).a(i, j, treeSet);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kb5 a;

            public d(a aVar, kb5 kb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, kb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kb5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jb5 a;

            public e(a aVar, jb5 jb5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jb5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jb5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) == null) {
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(cb5.b);
                    treeSet.addAll(arrayList);
                    this.a.a(i, str, treeSet);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class f implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ib5 a;

            public f(a aVar, ib5 ib5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ib5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = ib5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        public a(kn7 kn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn7Var};
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
            this.e = new C0337a(this);
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
        }

        @Override // com.baidu.tieba.cb5
        public void d(@NonNull ib5 ib5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ib5Var) == null) {
                f fVar = new f(this, ib5Var);
                this.g.put(ib5Var, fVar);
                BIMManager.registerConnectListenerToList(fVar);
            }
        }

        @Override // com.baidu.tieba.cb5
        public void g(@NonNull ib5 ib5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ib5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.g.remove(ib5Var));
            }
        }

        @Override // com.baidu.tieba.cb5
        public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull hb5 hb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, hb5Var) == null) {
                for (Long l : list) {
                    bk5.b(l);
                    if (this.d.get(l) == hb5Var) {
                        BIMManager.unregisterChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                        this.d.remove(l);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cb5
        public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
                for (Long l : list) {
                    bk5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                }
            }
        }

        @Override // com.baidu.tieba.cb5
        public void b(@NonNull Context context, @NonNull List<Long> list, @NonNull hb5 hb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, hb5Var) == null) {
                for (Long l : list) {
                    bk5.b(l);
                    this.d.put(l, hb5Var);
                    BIMManager.registerChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                }
            }
        }

        @Override // com.baidu.tieba.cb5
        public void c(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull eb5 eb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, list, eb5Var) == null) {
                for (Long l : list) {
                    bk5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                    m(l.longValue()).h(new b(this, context, l, eb5Var));
                }
            }
        }

        @Override // com.baidu.tieba.cb5
        public void e(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull fb5 fb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, list, fb5Var) == null) {
                for (Long l : list) {
                    bk5.b(l);
                    if (TextUtils.equals(this.h.get(l), str + context)) {
                        m(l.longValue()).h(new c(this, context, l, fb5Var));
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cb5
        public void f(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @NonNull jb5 jb5Var) {
            long j3;
            int i2;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), jb5Var}) == null) {
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
                BIMManager.fetchChatRoomMsgRequest(context, Constants.APPID_TIEBA, AccountManager.getUK(context), 4, j, j3, j4, i2, z ? 1 : 0, new e(this, jb5Var));
            }
        }

        @Override // com.baidu.tieba.cb5
        public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull kb5 kb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, kb5Var}) == null) {
                BIMManager.sendMsgToChatRoom(context, j, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, new d(this, kb5Var));
            }
        }

        @NonNull
        public final fk5 m(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                fk5 fk5Var = this.f.get(Long.valueOf(j));
                if (fk5Var == null) {
                    fk5 f2 = fk5.f();
                    this.f.put(Long.valueOf(j), f2);
                    return f2;
                }
                fk5Var.g();
                return fk5Var;
            }
            return (fk5) invokeJ.objValue;
        }
    }

    public kn7() {
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
    @Override // com.baidu.tieba.yf1
    /* renamed from: a */
    public cb5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (cb5) invokeV.objValue;
    }
}
