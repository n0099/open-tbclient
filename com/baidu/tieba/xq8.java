package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.kx5;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xq8 extends tl1<rn5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements rn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<ao5> c;
        @NonNull
        public final Map<Long, bo5> d;
        public final IChatRoomMsgReceiveListener e;
        public final Map<Long, kx5> f;
        public final Map<co5, IConnectListener> g;
        @NonNull
        public final Map<Long, String> h;

        /* loaded from: classes8.dex */
        public class b implements kx5.c<kx5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ yn5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.xq8$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0513a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ kx5.c b;
                public final /* synthetic */ b c;

                public C0513a(b bVar, boolean z, kx5.c cVar) {
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
                        ir8.f(this.c.b.longValue(), i, str);
                        if (i != 0) {
                            if (this.a) {
                                ir8.k("im_enter_auto_retry_", this.c.b.longValue());
                                b bVar = this.c;
                                bVar.c.a(bVar.b.longValue(), i, str, chatRoomInfo);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        ir8.k("im_enter_auto_retry_", this.c.b.longValue());
                        this.c.d.f.remove(this.c.b);
                        b bVar2 = this.c;
                        bVar2.c.a(bVar2.b.longValue(), i, str, chatRoomInfo);
                    }
                }
            }

            public b(a aVar, Context context, Long l, yn5 yn5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, yn5Var};
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
                this.c = yn5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.kx5.c
            public void call(boolean z, kx5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b.longValue(), new C0513a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements kx5.c<kx5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ Long b;
            public final /* synthetic */ zn5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.xq8$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0514a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ kx5.c b;
                public final /* synthetic */ c c;

                public C0514a(c cVar, boolean z, kx5.c cVar2) {
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
                        ir8.g(this.c.b.longValue(), i, str);
                        if (i != 0) {
                            if (this.a) {
                                ir8.k("im_exit_auto_retry_", this.c.b.longValue());
                                c cVar = this.c;
                                cVar.c.a(cVar.b.longValue(), i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        ir8.k("im_exit_auto_retry_", this.c.b.longValue());
                        this.c.d.f.remove(this.c.b);
                        c cVar2 = this.c;
                        cVar2.c.a(cVar2.b.longValue(), i, str);
                    }
                }
            }

            public c(a aVar, Context context, Long l, zn5 zn5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, l, zn5Var};
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
                this.c = zn5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.kx5.c
            public void call(boolean z, kx5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b.longValue(), new C0514a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class e implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ eo5 e;
            public final /* synthetic */ do5 f;

            /* renamed from: com.baidu.tieba.xq8$a$e$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0515a implements Function1<List<? extends ChatMsg>, Unit> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ e c;

                public C0515a(e eVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = eVar;
                    this.a = i;
                    this.b = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a */
                public Unit invoke(List<? extends ChatMsg> list) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                        TreeSet<ChatMsg> treeSet = new TreeSet<>(rn5.b);
                        treeSet.addAll(list);
                        this.c.f.a(this.a, this.b, treeSet);
                        return null;
                    }
                    return (Unit) invokeL.objValue;
                }
            }

            public e(a aVar, long j, long j2, boolean z, boolean z2, eo5 eo5Var, do5 do5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), eo5Var, do5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = j2;
                this.c = z;
                this.d = z2;
                this.e = eo5Var;
                this.f = do5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) == null) {
                    int size = arrayList.size();
                    if (i != 0 || size < 2) {
                        ir8.e(this.a, this.b, i3, this.c, this.d, i, str, size);
                    }
                    eo5 eo5Var = this.e;
                    if (eo5Var != null) {
                        eo5Var.a(this.a, arrayList, new C0515a(this, i, str));
                        return;
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(rn5.b);
                    treeSet.addAll(arrayList);
                    this.f.a(i, str, treeSet);
                }
            }
        }

        /* renamed from: com.baidu.tieba.xq8$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0512a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0512a(a aVar) {
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
                    for (ao5 ao5Var : this.a.c) {
                        if (ao5Var.a(i, j, list)) {
                            return;
                        }
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(rn5.b);
                    treeSet.addAll(list);
                    ((bo5) this.a.d.get(Long.valueOf(j))).a(i, j, treeSet);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class d implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fo5 a;

            public d(a aVar, fo5 fo5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fo5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fo5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class f implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ co5 a;

            public f(a aVar, co5 co5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, co5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = co5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        public a(xq8 xq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            AlaLiveSdkStatic.l();
            this.c = new ArrayList();
            this.d = new HashMap();
            this.e = new C0512a(this);
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
        }

        @Override // com.baidu.tieba.rn5
        public void e(@NonNull co5 co5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, co5Var) == null) {
                f fVar = new f(this, co5Var);
                this.g.put(co5Var, fVar);
                BIMManager.registerConnectListenerToList(fVar);
            }
        }

        @Override // com.baidu.tieba.rn5
        public void g(@NonNull co5 co5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, co5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.g.remove(co5Var));
            }
        }

        @Override // com.baidu.tieba.rn5
        public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull bo5 bo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, bo5Var) == null) {
                for (Long l : list) {
                    gx5.b(l);
                    if (this.d.get(l) == bo5Var) {
                        BIMManager.unregisterChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                        this.d.remove(l);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.rn5
        public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
                for (Long l : list) {
                    gx5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                }
            }
        }

        @Override // com.baidu.tieba.rn5
        public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable eo5 eo5Var, @NonNull do5 do5Var) {
            int i2;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), eo5Var, do5Var}) == null) {
                long j4 = 0;
                if (z) {
                    j3 = Long.MAX_VALUE;
                    i2 = i * (-1);
                } else if (z2) {
                    j3 = j2;
                    i2 = i * (-1);
                } else {
                    j4 = j2;
                    i2 = i;
                    j3 = Long.MAX_VALUE;
                }
                BIMManager.fetchChatRoomMsgRequest(context, 10773430L, AccountManager.getUK(context), 4, j, j4, j3, i2, z ? 1 : 0, new e(this, j, j4, z, z2, eo5Var, do5Var));
            }
        }

        @Override // com.baidu.tieba.rn5
        public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull bo5 bo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, bo5Var) == null) {
                for (Long l : list) {
                    gx5.b(l);
                    this.d.put(l, bo5Var);
                    BIMManager.registerChatRoomMsgReceiveListener(context, l.longValue(), this.e);
                }
            }
        }

        @Override // com.baidu.tieba.rn5
        public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull yn5 yn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, yn5Var) == null) {
                for (Long l : list) {
                    gx5.b(l);
                    Map<Long, String> map = this.h;
                    map.put(l, str + context);
                    kx5 n = n(l.longValue());
                    ir8.d("im_enter_auto_retry_", l.longValue());
                    n.i(new b(this, context, l, yn5Var));
                }
            }
        }

        @Override // com.baidu.tieba.rn5
        public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull zn5 zn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, zn5Var) == null) {
                for (Long l : list) {
                    gx5.b(l);
                    if (!TextUtils.equals(this.h.get(l), str + context)) {
                        zn5Var.a(l.longValue(), -200, "");
                    } else {
                        kx5 n = n(l.longValue());
                        ir8.d("im_exit_auto_retry_", l.longValue());
                        n.i(new c(this, context, l, zn5Var));
                    }
                }
            }
        }

        @Override // com.baidu.tieba.rn5
        public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, fo5Var}) == null) {
                BIMManager.sendMsgToChatRoomWithSafeParam(context, j, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, m(context), new d(this, fo5Var));
            }
        }

        @Nullable
        public final String m(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("zid", TbadkCoreApplication.getInst().getZid(context, TbadkCoreApplication.getCurrentAccount(), 0, null));
                    jSONObject.put("haotianjing", jSONObject2);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    BdLog.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        @NonNull
        public final kx5 n(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                kx5 kx5Var = this.f.get(Long.valueOf(j));
                if (kx5Var == null) {
                    kx5 g = kx5.g();
                    this.f.put(Long.valueOf(j), g);
                    return g;
                }
                kx5Var.h();
                return kx5Var;
            }
            return (kx5) invokeJ.objValue;
        }
    }

    public xq8() {
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
    @Override // com.baidu.tieba.tl1
    /* renamed from: a */
    public rn5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (rn5) invokeV.objValue;
    }
}
