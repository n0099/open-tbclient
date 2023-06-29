package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
import com.baidu.tieba.px5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iv8 extends wl1<vn5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements vn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final c c;
        public final IChatRoomMsgReceiveListener d;
        public final Map<Long, px5> e;
        public final Map<go5, IConnectListener> f;
        public final b g;

        public final long t(int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (i2 == 2) {
                    return 0L;
                }
                return j;
            }
            return invokeCommon.longValue;
        }

        /* loaded from: classes6.dex */
        public class i implements b.InterfaceC0366b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ko5 a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ a c;

            /* loaded from: classes6.dex */
            public class b implements co5 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

                /* renamed from: com.baidu.tieba.iv8$a$i$b$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0365a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ String c;
                    public final /* synthetic */ b d;

                    public RunnableC0365a(b bVar, long j, int i, String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {bVar, Long.valueOf(j), Integer.valueOf(i), str};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.d = bVar;
                        this.a = j;
                        this.b = i;
                        this.c = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ko5 ko5Var;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ko5Var = this.d.a.a) != null) {
                            ko5Var.b(this.a, this.b, this.c);
                        }
                    }
                }

                public b(i iVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = iVar;
                }

                @Override // com.baidu.tieba.co5
                public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                        ch.g(new RunnableC0365a(this, j, i, str));
                    }
                }
            }

            /* renamed from: com.baidu.tieba.iv8$a$i$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0364a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ i b;

                public RunnableC0364a(i iVar, long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iVar, Long.valueOf(j)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = iVar;
                    this.a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ko5 ko5Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ko5Var = this.b.a) != null) {
                        ko5Var.a(this.a);
                    }
                }
            }

            public i(a aVar, ko5 ko5Var, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ko5Var, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = ko5Var;
                this.b = context;
            }

            @Override // com.baidu.tieba.iv8.b.InterfaceC0366b
            public void a(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    tv8.j(j);
                    ch.g(new RunnableC0364a(this, j));
                    this.c.i(this.b, j, new b(this));
                }
            }
        }

        /* renamed from: com.baidu.tieba.iv8$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0357a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.iv8$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0358a implements Function1<fo5, Void> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ long b;
                public final /* synthetic */ TreeSet c;

                public C0358a(C0357a c0357a, int i, long j, TreeSet treeSet) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0357a, Integer.valueOf(i), Long.valueOf(j), treeSet};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = i;
                    this.b = j;
                    this.c = treeSet;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a */
                public Void invoke(fo5 fo5Var) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fo5Var)) == null) {
                        fo5Var.a(this.a, this.b, this.c);
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            }

            public C0357a(a aVar) {
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
                boolean z;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list}) != null) || list.isEmpty()) {
                    return;
                }
                if (j == 9) {
                    long g = vg.g(list.get(0).getContacterId(), -1L);
                    if (g < 0) {
                        return;
                    }
                    j = g;
                    z = true;
                } else {
                    z = false;
                }
                this.a.g.h(j, list);
                TreeSet treeSet = new TreeSet(vn5.b);
                treeSet.addAll(list);
                this.a.c.c(j, z, new C0358a(this, i, j, treeSet));
            }
        }

        /* loaded from: classes6.dex */
        public class b implements px5.c<px5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;
            public final /* synthetic */ eo5 d;
            public final /* synthetic */ List e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.iv8$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0359a implements IChatRoomListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ px5.c b;
                public final /* synthetic */ b c;

                public C0359a(b bVar, boolean z, px5.c cVar) {
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

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        tv8.h(this.c.c, i, str);
                        if (i != 0) {
                            if (this.a) {
                                tv8.n("im_group_enter_auto_retry_", this.c.c);
                                this.c.f.e.remove(Long.valueOf(this.c.c));
                                b bVar = this.c;
                                bVar.d.a(bVar.b, bVar.c, bVar.e, i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        for (Long l : this.c.e) {
                            this.c.f.g.f(l.longValue());
                        }
                        tv8.n("im_group_enter_auto_retry_", this.c.c);
                        this.c.f.e.remove(Long.valueOf(this.c.c));
                        b bVar2 = this.c;
                        bVar2.d.a(bVar2.b, bVar2.c, bVar2.e, i, str);
                    }
                }
            }

            public b(a aVar, Context context, int i, long j, eo5 eo5Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Integer.valueOf(i), Long.valueOf(j), eo5Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.a = context;
                this.b = i;
                this.c = j;
                this.d = eo5Var;
                this.e = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.px5.c
            public void call(boolean z, px5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    Context context = this.a;
                    int i = this.b;
                    BIMManager.enterChatRoomGroup(context, 9L, i, this.f.t(i, this.c), new C0359a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements px5.c<px5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;
            public final /* synthetic */ eo5 d;
            public final /* synthetic */ List e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.iv8$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0360a implements IChatRoomListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ px5.c b;
                public final /* synthetic */ c c;

                public C0360a(c cVar, boolean z, px5.c cVar2) {
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

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        tv8.i(this.c.c, i, str);
                        if (i != 0) {
                            if (this.a) {
                                tv8.n("im_group_exit_auto_retry_", this.c.c);
                                this.c.f.e.remove(Long.valueOf(this.c.c));
                                c cVar = this.c;
                                cVar.d.a(cVar.b, cVar.c, cVar.e, i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        for (Long l : this.c.e) {
                            this.c.f.g.d(l.longValue());
                        }
                        tv8.n("im_group_exit_auto_retry_", this.c.c);
                        this.c.f.e.remove(Long.valueOf(this.c.c));
                        c cVar2 = this.c;
                        cVar2.d.a(cVar2.b, cVar2.c, cVar2.e, i, str);
                    }
                }
            }

            public c(a aVar, Context context, int i, long j, eo5 eo5Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Integer.valueOf(i), Long.valueOf(j), eo5Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.a = context;
                this.b = i;
                this.c = j;
                this.d = eo5Var;
                this.e = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.px5.c
            public void call(boolean z, px5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    Context context = this.a;
                    int i = this.b;
                    BIMManager.exitChatRoomGroup(context, 9L, i, this.f.t(i, this.c), new C0360a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements px5.c<px5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ long b;
            public final /* synthetic */ co5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.iv8$a$d$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0361a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ px5.c b;
                public final /* synthetic */ d c;

                public C0361a(d dVar, boolean z, px5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = dVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        tv8.f(this.c.b, i, str);
                        if (i != 0) {
                            if (this.a) {
                                tv8.n("im_enter_auto_retry_", this.c.b);
                                this.c.d.e.remove(Long.valueOf(this.c.b));
                                d dVar = this.c;
                                dVar.c.a(dVar.b, i, str, chatRoomInfo);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        this.c.d.g.f(this.c.b);
                        tv8.n("im_enter_auto_retry_", this.c.b);
                        this.c.d.e.remove(Long.valueOf(this.c.b));
                        d dVar2 = this.c;
                        dVar2.c.a(dVar2.b, i, str, chatRoomInfo);
                    }
                }
            }

            public d(a aVar, Context context, long j, co5 co5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Long.valueOf(j), co5Var};
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
                this.b = j;
                this.c = co5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.px5.c
            public void call(boolean z, px5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b, new C0361a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class e implements px5.c<px5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ long b;
            public final /* synthetic */ do5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.iv8$a$e$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0362a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ px5.c b;
                public final /* synthetic */ e c;

                public C0362a(e eVar, boolean z, px5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = eVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        tv8.g(this.c.b, i, str);
                        if (i != 0) {
                            if (this.a) {
                                tv8.n("im_exit_auto_retry_", this.c.b);
                                this.c.d.e.remove(Long.valueOf(this.c.b));
                                e eVar = this.c;
                                eVar.c.a(eVar.b, i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        this.c.d.g.d(this.c.b);
                        tv8.n("im_exit_auto_retry_", this.c.b);
                        this.c.d.e.remove(Long.valueOf(this.c.b));
                        e eVar2 = this.c;
                        eVar2.c.a(eVar2.b, i, str);
                    }
                }
            }

            public e(a aVar, Context context, long j, do5 do5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Long.valueOf(j), do5Var};
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
                this.b = j;
                this.c = do5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.px5.c
            public void call(boolean z, px5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b, new C0362a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class g implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ io5 e;
            public final /* synthetic */ ho5 f;

            /* renamed from: com.baidu.tieba.iv8$a$g$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0363a implements Function1<List<? extends ChatMsg>, Unit> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ g c;

                public C0363a(g gVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = gVar;
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
                        TreeSet<ChatMsg> treeSet = new TreeSet<>(vn5.b);
                        treeSet.addAll(list);
                        this.c.f.a(this.a, this.b, treeSet);
                        return null;
                    }
                    return (Unit) invokeL.objValue;
                }
            }

            public g(a aVar, long j, long j2, boolean z, boolean z2, io5 io5Var, ho5 ho5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), io5Var, ho5Var};
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
                this.e = io5Var;
                this.f = ho5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) == null) {
                    int size = arrayList.size();
                    if (i != 0 || size < 2) {
                        tv8.e(this.a, this.b, i3, this.c, this.d, i, str, size);
                    }
                    io5 io5Var = this.e;
                    if (io5Var != null) {
                        io5Var.a(this.a, arrayList, new C0363a(this, i, str));
                        return;
                    }
                    TreeSet<ChatMsg> treeSet = new TreeSet<>(vn5.b);
                    treeSet.addAll(arrayList);
                    this.f.a(i, str, treeSet);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class f implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jo5 a;

            public f(a aVar, jo5 jo5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jo5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jo5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class h implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ go5 a;

            public h(a aVar, go5 go5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, go5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = go5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        public a(iv8 iv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            AlaLiveSdkStatic.l();
            this.c = new c(null);
            this.d = new C0357a(this);
            this.e = new HashMap();
            this.f = new HashMap();
            this.g = new b(null);
        }

        @Override // com.baidu.tieba.vn5
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.g.c(j);
            }
        }

        @Override // com.baidu.tieba.vn5
        public void f(@NonNull go5 go5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, go5Var) == null) {
                h hVar = new h(this, go5Var);
                this.f.put(go5Var, hVar);
                BIMManager.registerConnectListenerToList(hVar);
            }
        }

        @Override // com.baidu.tieba.vn5
        public void h(@NonNull go5 go5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, go5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.f.remove(go5Var));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void c(@NonNull Context context, long j, @Nullable ko5 ko5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), ko5Var}) == null) {
                this.g.i(j, new i(this, ko5Var, context));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void a(@NonNull Context context, long j, long j2, int i2, boolean z, boolean z2, @Nullable io5 io5Var, @NonNull ho5 ho5Var) {
            int i3;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), io5Var, ho5Var}) == null) {
                long j4 = 0;
                if (z) {
                    j3 = Long.MAX_VALUE;
                    i3 = i2 * (-1);
                } else if (z2) {
                    j3 = j2;
                    i3 = i2 * (-1);
                } else {
                    j4 = j2;
                    i3 = i2;
                    j3 = Long.MAX_VALUE;
                }
                BIMManager.fetchChatRoomMsgRequest(context, 10773430L, AccountManager.getUK(context), 4, j, j4, j3, i3, z ? 1 : 0, new g(this, j, j4, z, z2, io5Var, ho5Var));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void d(@NonNull Context context, long j, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), fo5Var}) == null) {
                this.c.a(-1, 0L, j, fo5Var);
                BIMManager.registerChatRoomMsgReceiveListener(context, j, this.d);
            }
        }

        @Override // com.baidu.tieba.vn5
        public void i(@NonNull Context context, long j, @NonNull co5 co5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), co5Var}) == null) {
                px5 u = u(j);
                tv8.d("im_enter_auto_retry_", j);
                u.i(new d(this, context, j, co5Var));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void l(@NonNull Context context, long j, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), fo5Var}) == null) {
                this.c.d(-1, 0L, j, fo5Var);
                BIMManager.unregisterChatRoomMsgReceiveListener(context, j, this.d);
            }
        }

        @Override // com.baidu.tieba.vn5
        public void n(@NonNull Context context, long j, @NonNull do5 do5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), do5Var}) == null) {
                px5 u = u(j);
                tv8.d("im_exit_auto_retry_", j);
                u.i(new e(this, context, j, do5Var));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void e(@NonNull Context context, int i2, long j, @NonNull List<Long> list, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j), list, fo5Var}) == null) {
                for (Long l : list) {
                    lx5.b(l);
                    this.c.d(i2, j, l.longValue(), fo5Var);
                }
                if (!this.c.b()) {
                    BIMManager.unregisterChatRoomGroupMsgReceiveListener(context, 9L, this.d);
                }
            }
        }

        @Override // com.baidu.tieba.vn5
        public void g(@NonNull Context context, int i2, long j, @NonNull List<Long> list, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j), list, fo5Var}) == null) {
                if (!this.c.b()) {
                    BIMManager.registerChatRoomGroupMsgReceiveListener(context, 9L, this.d);
                }
                for (Long l : list) {
                    lx5.b(l);
                    this.c.a(i2, j, l.longValue(), fo5Var);
                }
            }
        }

        @Override // com.baidu.tieba.vn5
        public void j(@NonNull Context context, int i2, long j, @NonNull List<Long> list, @NonNull eo5 eo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j), list, eo5Var}) == null) {
                px5 u = u(j);
                tv8.d("im_group_exit_auto_retry_", j);
                u.i(new c(this, context, i2, j, eo5Var, list));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void m(@NonNull Context context, int i2, long j, @NonNull List<Long> list, @NonNull eo5 eo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j), list, eo5Var}) == null) {
                px5 u = u(j);
                tv8.d("im_group_enter_auto_retry_", j);
                u.i(new b(this, context, i2, j, eo5Var, list));
            }
        }

        @Override // com.baidu.tieba.vn5
        public void k(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jo5 jo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), chatMsg, jo5Var}) == null) {
                BIMManager.sendMsgToChatRoomWithSafeParam(context, j, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, s(context), new f(this, jo5Var));
            }
        }

        @Nullable
        public final String s(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
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
        public final px5 u(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
                px5 px5Var = this.e.get(Long.valueOf(j));
                if (px5Var == null) {
                    px5 g2 = px5.g();
                    this.e.put(Long.valueOf(j), g2);
                    return g2;
                }
                px5Var.h();
                return px5Var;
            }
            return (px5) invokeJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final long d;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Long, Integer> a;
        public final Map<Long, c> b;
        public final Runnable c;

        /* renamed from: com.baidu.tieba.iv8$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public interface InterfaceC0366b {
            void a(long j);
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (b.class) {
                        for (Map.Entry entry : this.a.b.entrySet()) {
                            Long l = (Long) entry.getKey();
                            c cVar = (c) entry.getValue();
                            if (cVar.b() && !this.a.g(l.longValue())) {
                                cVar.a().a(l.longValue());
                            }
                            cVar.c(null);
                        }
                        ch.f(this, b.d);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public static class c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Nullable
            public List<ChatMsg> a;
            @NonNull
            public final InterfaceC0366b b;

            public c(@NonNull InterfaceC0366b interfaceC0366b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {interfaceC0366b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = interfaceC0366b;
            }

            public void c(@Nullable List<ChatMsg> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                    this.a = list;
                }
            }

            @NonNull
            public InterfaceC0366b a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (InterfaceC0366b) invokeV.objValue;
            }

            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    List<ChatMsg> list = this.a;
                    if (list != null && !list.isEmpty()) {
                        return false;
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-705505792, "Lcom/baidu/tieba/iv8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-705505792, "Lcom/baidu/tieba/iv8$b;");
                    return;
                }
            }
            d = TimeUnit.SECONDS.toMillis(30L);
        }

        public b() {
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
            this.a = new ConcurrentHashMap();
            this.b = new ConcurrentHashMap();
            this.c = new a(this);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public synchronized void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this) {
                    this.b.remove(Long.valueOf(j));
                    if (this.b.isEmpty()) {
                        ch.d(this.c);
                    }
                }
            }
        }

        public synchronized int e(long j) {
            InterceptResult invokeJ;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                synchronized (this) {
                    Integer num = this.a.get(Long.valueOf(j));
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue();
                    }
                }
                return intValue;
            }
            return invokeJ.intValue;
        }

        public synchronized boolean g(long j) {
            InterceptResult invokeJ;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                synchronized (this) {
                    if (e(j) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                return z;
            }
            return invokeJ.booleanValue;
        }

        public synchronized void d(long j) {
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    Integer num = this.a.get(Long.valueOf(j));
                    if (num == null) {
                        intValue = 0;
                    } else {
                        intValue = num.intValue() - 1;
                    }
                    Integer valueOf = Integer.valueOf(intValue);
                    if (valueOf.intValue() == 0) {
                        this.a.remove(Long.valueOf(j));
                    } else {
                        this.a.put(Long.valueOf(j), valueOf);
                    }
                }
            }
        }

        public synchronized void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                synchronized (this) {
                    Integer num = this.a.get(Long.valueOf(j));
                    int i = 1;
                    if (num != null) {
                        i = 1 + num.intValue();
                    }
                    this.a.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }

        public synchronized void h(long j, @NonNull List<ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048581, this, j, list) == null) {
                synchronized (this) {
                    c cVar = this.b.get(Long.valueOf(j));
                    if (cVar != null) {
                        cVar.c(list);
                    }
                }
            }
        }

        public synchronized void i(long j, @NonNull InterfaceC0366b interfaceC0366b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j, interfaceC0366b) == null) {
                synchronized (this) {
                    if (!this.b.containsKey(Long.valueOf(j))) {
                        this.b.put(Long.valueOf(j), new c(interfaceC0366b));
                        if (this.b.size() == 1) {
                            ch.f(this.c, d);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Long, Set<a>> a;

        /* loaded from: classes6.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int a;
            @NonNull
            public final fo5 b;

            public a(int i, long j, @NonNull fo5 fo5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), fo5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = fo5Var;
            }

            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.a;
                }
                return invokeV.intValue;
            }

            @NonNull
            public fo5 c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.b;
                }
                return (fo5) invokeV.objValue;
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ConcurrentHashMap();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public synchronized void a(int i, long j, long j2, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), fo5Var}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j2));
                    if (set == null) {
                        set = new HashSet<>();
                        this.a.put(Long.valueOf(j2), set);
                    }
                    set.add(new a(i, j, fo5Var));
                }
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                for (Set<a> set : this.a.values()) {
                    for (a aVar : set) {
                        if (aVar.b() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public synchronized void c(long j, boolean z, @NonNull Function1<fo5, Void> function1) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), function1}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j));
                    if (set != null) {
                        for (a aVar : set) {
                            if (aVar.b() == -1) {
                                if (!z) {
                                    function1.invoke(aVar.c());
                                }
                            } else if (z) {
                                function1.invoke(aVar.c());
                            }
                        }
                    }
                }
            }
        }

        public synchronized void d(int i, long j, long j2, @NonNull fo5 fo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), fo5Var}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j2));
                    if (set != null) {
                        Iterator<a> it = set.iterator();
                        while (it.hasNext()) {
                            if (it.next().b == fo5Var) {
                                it.remove();
                            }
                        }
                        if (set.isEmpty()) {
                            this.a.remove(Long.valueOf(j2));
                        }
                    }
                }
            }
        }
    }

    public iv8() {
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
    @Override // com.baidu.tieba.wl1
    /* renamed from: a */
    public vn5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (vn5) invokeV.objValue;
    }
}
