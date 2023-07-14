package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMEmojiReplyListener;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.livesdk.AlaLiveSdkStatic;
import com.baidu.tieba.ty5;
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
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l19 extends pl1<uo5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements uo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final c c;
        public final IChatRoomMsgReceiveListener d;
        public final Map<Long, ty5> e;
        public final Map<fp5, IConnectListener> f;
        public final b g;

        public final long y(int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                if (i2 == 2) {
                    return 0L;
                }
                return j2;
            }
            return invokeCommon.longValue;
        }

        /* loaded from: classes6.dex */
        public class e implements b.InterfaceC0387b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mp5 a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ a c;

            /* loaded from: classes6.dex */
            public class b implements bp5 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                /* renamed from: com.baidu.tieba.l19$a$e$b$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0379a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ String c;
                    public final /* synthetic */ b d;

                    public RunnableC0379a(b bVar, long j, int i, String str) {
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
                        mp5 mp5Var;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mp5Var = this.d.a.a) != null) {
                            mp5Var.b(this.a, this.b, this.c);
                        }
                    }
                }

                public b(e eVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = eVar;
                }

                @Override // com.baidu.tieba.bp5
                public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) {
                        dh.g(new RunnableC0379a(this, j, i, str));
                    }
                }
            }

            /* renamed from: com.baidu.tieba.l19$a$e$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0378a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ e b;

                public RunnableC0378a(e eVar, long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {eVar, Long.valueOf(j)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = eVar;
                    this.a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    mp5 mp5Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mp5Var = this.b.a) != null) {
                        mp5Var.a(this.a);
                    }
                }
            }

            public e(a aVar, mp5 mp5Var, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, mp5Var, context};
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
                this.a = mp5Var;
                this.b = context;
            }

            @Override // com.baidu.tieba.l19.b.InterfaceC0387b
            public void a(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    w19.j(j);
                    dh.g(new RunnableC0378a(this, j));
                    this.c.l(this.b, j, new b(this));
                }
            }
        }

        /* renamed from: com.baidu.tieba.l19$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0375a implements IChatRoomMsgReceiveListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.l19$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0376a implements Function1<ep5, Void> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ long b;
                public final /* synthetic */ TreeSet c;

                public C0376a(C0375a c0375a, int i, long j, TreeSet treeSet) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0375a, Integer.valueOf(i), Long.valueOf(j), treeSet};
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
                public Void invoke(ep5 ep5Var) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ep5Var)) == null) {
                        ep5Var.a(this.a, this.b, this.c);
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            }

            public C0375a(a aVar) {
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
                    long g = wg.g(list.get(0).getContacterId(), -1L);
                    if (g < 0) {
                        return;
                    }
                    j = g;
                    z = true;
                } else {
                    z = false;
                }
                this.a.g.h(j, list);
                this.a.A(list);
                TreeSet treeSet = new TreeSet(uo5.b);
                treeSet.addAll(list);
                this.a.c.c(j, z, new C0376a(this, i, j, treeSet));
            }
        }

        /* loaded from: classes6.dex */
        public class c implements IFetchMsgByIdListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ fa5 e;
            public final /* synthetic */ ip5 f;
            public final /* synthetic */ a g;

            /* renamed from: com.baidu.tieba.l19$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0377a implements ha5<List<? extends ChatMsg>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ ArrayList c;
                public final /* synthetic */ c d;

                public C0377a(c cVar, int i, String str, ArrayList arrayList) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, Integer.valueOf(i), str, arrayList};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = cVar;
                    this.a = i;
                    this.b = str;
                    this.c = arrayList;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ha5
                /* renamed from: b */
                public void a(@Nullable List<? extends ChatMsg> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if (list != null) {
                            TreeSet<ChatMsg> treeSet = new TreeSet<>(uo5.b);
                            treeSet.addAll(list);
                            this.d.f.a(this.a, this.b, treeSet);
                            return;
                        }
                        TreeSet<ChatMsg> treeSet2 = new TreeSet<>(uo5.b);
                        treeSet2.addAll(this.c);
                        this.d.f.a(this.a, this.b, treeSet2);
                    }
                }
            }

            public c(a aVar, long j, long j2, boolean z, boolean z2, fa5 fa5Var, ip5 ip5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), fa5Var, ip5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.g = aVar;
                this.a = j;
                this.b = j2;
                this.c = z;
                this.d = z2;
                this.e = fa5Var;
                this.f = ip5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j4), arrayList}) != null) {
                    return;
                }
                this.g.A(arrayList);
                int size = arrayList.size();
                if (i != 0 || size < 2) {
                    w19.e(this.a, this.b, i3, this.c, this.d, i, str, size);
                }
                fa5 fa5Var = this.e;
                if (fa5Var != null) {
                    fa5Var.d(arrayList);
                    this.e.f(new C0377a(this, i, str, arrayList));
                    this.e.a(Long.valueOf(this.a), arrayList);
                    return;
                }
                TreeSet<ChatMsg> treeSet = new TreeSet<>(uo5.b);
                treeSet.addAll(arrayList);
                this.f.a(i, str, treeSet);
            }
        }

        /* loaded from: classes6.dex */
        public class f implements ty5.c<ty5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;
            public final /* synthetic */ dp5 d;
            public final /* synthetic */ List e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.l19$a$f$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0380a implements IChatRoomListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ty5.c b;
                public final /* synthetic */ f c;

                public C0380a(f fVar, boolean z, ty5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = fVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        w19.h(this.c.c, i, str);
                        if (i != 0) {
                            if (this.a) {
                                w19.n("im_group_enter_auto_retry_", this.c.c);
                                this.c.f.e.remove(Long.valueOf(this.c.c));
                                f fVar = this.c;
                                fVar.d.a(fVar.b, fVar.c, fVar.e, i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        for (Long l : this.c.e) {
                            this.c.f.g.f(l.longValue());
                        }
                        w19.n("im_group_enter_auto_retry_", this.c.c);
                        this.c.f.e.remove(Long.valueOf(this.c.c));
                        f fVar2 = this.c;
                        fVar2.d.a(fVar2.b, fVar2.c, fVar2.e, i, str);
                    }
                }
            }

            public f(a aVar, Context context, int i, long j, dp5 dp5Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Integer.valueOf(i), Long.valueOf(j), dp5Var, list};
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
                this.d = dp5Var;
                this.e = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ty5.c
            public void call(boolean z, ty5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    Context context = this.a;
                    int i = this.b;
                    BIMManager.enterChatRoomGroup(context, 9L, i, this.f.y(i, this.c), new C0380a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class g implements ty5.c<ty5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ long c;
            public final /* synthetic */ dp5 d;
            public final /* synthetic */ List e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.l19$a$g$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0381a implements IChatRoomListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ty5.c b;
                public final /* synthetic */ g c;

                public C0381a(g gVar, boolean z, ty5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = gVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        w19.i(this.c.c, i, str);
                        if (i != 0) {
                            if (this.a) {
                                w19.n("im_group_exit_auto_retry_", this.c.c);
                                this.c.f.e.remove(Long.valueOf(this.c.c));
                                g gVar = this.c;
                                gVar.d.a(gVar.b, gVar.c, gVar.e, i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        for (Long l : this.c.e) {
                            this.c.f.g.d(l.longValue());
                        }
                        w19.n("im_group_exit_auto_retry_", this.c.c);
                        this.c.f.e.remove(Long.valueOf(this.c.c));
                        g gVar2 = this.c;
                        gVar2.d.a(gVar2.b, gVar2.c, gVar2.e, i, str);
                    }
                }
            }

            public g(a aVar, Context context, int i, long j, dp5 dp5Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Integer.valueOf(i), Long.valueOf(j), dp5Var, list};
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
                this.d = dp5Var;
                this.e = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ty5.c
            public void call(boolean z, ty5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    Context context = this.a;
                    int i = this.b;
                    BIMManager.exitChatRoomGroup(context, 9L, i, this.f.y(i, this.c), new C0381a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class h implements ty5.c<ty5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ long b;
            public final /* synthetic */ bp5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.l19$a$h$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0382a implements IChatRoomEnterListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ty5.c b;
                public final /* synthetic */ h c;

                public C0382a(h hVar, boolean z, ty5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {hVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = hVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener
                public void onResult(int i, String str, IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, chatRoomInfo) == null) {
                        w19.f(this.c.b, i, str);
                        if (i != 0) {
                            if (this.a) {
                                w19.n("im_enter_auto_retry_", this.c.b);
                                this.c.d.e.remove(Long.valueOf(this.c.b));
                                h hVar = this.c;
                                hVar.c.a(hVar.b, i, str, chatRoomInfo);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        this.c.d.g.f(this.c.b);
                        w19.n("im_enter_auto_retry_", this.c.b);
                        this.c.d.e.remove(Long.valueOf(this.c.b));
                        h hVar2 = this.c;
                        hVar2.c.a(hVar2.b, i, str, chatRoomInfo);
                    }
                }
            }

            public h(a aVar, Context context, long j, bp5 bp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Long.valueOf(j), bp5Var};
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
                this.c = bp5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ty5.c
            public void call(boolean z, ty5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.enterChatRoom(this.a, this.b, new C0382a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class i implements ty5.c<ty5.c<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ long b;
            public final /* synthetic */ cp5 c;
            public final /* synthetic */ a d;

            /* renamed from: com.baidu.tieba.l19$a$i$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0383a implements IChatRoomExitListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ ty5.c b;
                public final /* synthetic */ i c;

                public C0383a(i iVar, boolean z, ty5.c cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iVar, Boolean.valueOf(z), cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = iVar;
                    this.a = z;
                    this.b = cVar;
                }

                @Override // com.baidu.android.imsdk.chatmessage.IChatRoomExitListener
                public void onResult(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        w19.g(this.c.b, i, str);
                        if (i != 0) {
                            if (this.a) {
                                w19.n("im_exit_auto_retry_", this.c.b);
                                this.c.d.e.remove(Long.valueOf(this.c.b));
                                i iVar = this.c;
                                iVar.c.a(iVar.b, i, str);
                                return;
                            }
                            this.b.call(false, null);
                            return;
                        }
                        this.c.d.g.d(this.c.b);
                        w19.n("im_exit_auto_retry_", this.c.b);
                        this.c.d.e.remove(Long.valueOf(this.c.b));
                        i iVar2 = this.c;
                        iVar2.c.a(iVar2.b, i, str);
                    }
                }
            }

            public i(a aVar, Context context, long j, cp5 cp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, Long.valueOf(j), cp5Var};
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
                this.c = cp5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ty5.c
            public void call(boolean z, ty5.c<Void> cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                    BIMManager.exitChatRoom(this.a, this.b, new C0383a(this, z, cVar));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class k implements BIMValueCallBack<List<String>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jp5 a;

            /* renamed from: com.baidu.tieba.l19$a$k$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0384a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List a;
                public final /* synthetic */ k b;

                public RunnableC0384a(k kVar, List list) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {kVar, list};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = kVar;
                    this.a = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.a(this.a);
                    }
                }
            }

            public k(a aVar, jp5 jp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jp5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jp5Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str, List<String> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, list) == null) {
                    dh.g(new RunnableC0384a(this, list));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class l implements IMEmojiReplyListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kp5 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ ChatMsg c;

            /* renamed from: com.baidu.tieba.l19$a$l$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0385a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ l c;

                public RunnableC0385a(l lVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {lVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = lVar;
                    this.a = i;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        int i = this.a;
                        if (i == 0) {
                            l lVar = this.c;
                            lVar.a.a(lVar.b, lVar.c);
                            return;
                        }
                        l lVar2 = this.c;
                        lVar2.a.b(i, this.b, lVar2.b, lVar2.c);
                    }
                }
            }

            public l(a aVar, kp5 kp5Var, String str, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, kp5Var, str, chatMsg};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kp5Var;
                this.b = str;
                this.c = chatMsg;
            }

            @Override // com.baidu.android.imsdk.mcast.IMEmojiReplyListener
            public void onResult(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.i("send emoji reply request result: " + i + "\t" + str);
                    }
                    dh.g(new RunnableC0385a(this, i, str));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class m implements IMEmojiReplyListListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hp5 a;

            /* renamed from: com.baidu.tieba.l19$a$m$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0386a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMEmojiReplyListListener.IMEmojiReplyListResponse a;
                public final /* synthetic */ m b;

                public RunnableC0386a(m mVar, IMEmojiReplyListListener.IMEmojiReplyListResponse iMEmojiReplyListResponse) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar, iMEmojiReplyListResponse};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = mVar;
                    this.a = iMEmojiReplyListResponse;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onSuccess(this.a.emojiReplyMap);
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ String b;
                public final /* synthetic */ m c;

                public b(m mVar, int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mVar, Integer.valueOf(i), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = mVar;
                    this.a = i;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.c.a.onFailure(this.a, this.b);
                    }
                }
            }

            public m(a aVar, hp5 hp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hp5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hp5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener
            public void onResult(int i, String str, int i2, IMEmojiReplyListListener.IMEmojiReplyListResponse iMEmojiReplyListResponse) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), iMEmojiReplyListResponse}) == null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.i("fetch emoji list result: " + i + "\t" + str);
                    }
                    if (i == 0 && i2 == 1 && iMEmojiReplyListResponse != null) {
                        dh.g(new RunnableC0386a(this, iMEmojiReplyListResponse));
                        return;
                    }
                    if (i2 != 1 && BdLog.isDebugMode()) {
                        BdLog.i("the packageId(" + i2 + ") is error!");
                    }
                    dh.g(new b(this, i, str));
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements IMEmojiReplyDetailListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gp5 a;

            public b(a aVar, gp5 gp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gp5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gp5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener
            public void onResult(int i, String str, IMEmojiReplyDetailListener.IMEmojiReplyDetailResponse iMEmojiReplyDetailResponse) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, iMEmojiReplyDetailResponse) == null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.i("fetch emoji reply detail result: " + i + "\t" + str);
                    }
                    if (i == 0 && iMEmojiReplyDetailResponse != null) {
                        this.a.a(iMEmojiReplyDetailResponse.hasMore, iMEmojiReplyDetailResponse.emojiReplyDetailList);
                    } else {
                        this.a.onFailure(i, str);
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements IConnectListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fp5 a;

            public d(a aVar, fp5 fp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fp5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fp5Var;
            }

            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    this.a.onResult(i);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class j implements ISendMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lp5 a;

            public j(a aVar, lp5 lp5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, lp5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lp5Var;
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, chatMsg) == null) {
                    this.a.onSendMessageResult(i, chatMsg);
                }
            }
        }

        public a(l19 l19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l19Var};
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
            this.d = new C0375a(this);
            this.e = new HashMap();
            this.f = new HashMap();
            this.g = new b(null);
        }

        @Override // com.baidu.tieba.uo5
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.g.c(j2);
            }
        }

        @Override // com.baidu.tieba.uo5
        public void g(@NonNull fp5 fp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, fp5Var) == null) {
                d dVar = new d(this, fp5Var);
                this.f.put(fp5Var, dVar);
                BIMManager.registerConnectListenerToList(dVar);
            }
        }

        @Override // com.baidu.tieba.uo5
        public void k(@NonNull fp5 fp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, fp5Var) == null) {
                BIMManager.unregisterConnectListenerFromList(this.f.remove(fp5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void c(@NonNull Context context, long j2, @Nullable mp5 mp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), mp5Var}) == null) {
                this.g.i(j2, new e(this, mp5Var, context));
            }
        }

        public final void A(@NonNull List<ChatMsg> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (ChatMsg chatMsg : list) {
                    if (StringUtils.isNull(chatMsg.getMsgKey())) {
                        chatMsg.setMsgKey(String.valueOf(chatMsg.getMsgId()));
                    }
                }
            }
        }

        @Nullable
        public final String x(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
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
        public final ty5 z(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j2)) == null) {
                ty5 ty5Var = this.e.get(Long.valueOf(j2));
                if (ty5Var == null) {
                    ty5 g2 = ty5.g();
                    this.e.put(Long.valueOf(j2), g2);
                    return g2;
                }
                ty5Var.h();
                return ty5Var;
            }
            return (ty5) invokeJ.objValue;
        }

        @Override // com.baidu.tieba.uo5
        public void b(@NonNull Context context, @NonNull String str, long j2, @NonNull ChatMsg chatMsg, boolean z, @NonNull kp5 kp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, Long.valueOf(j2), chatMsg, Boolean.valueOf(z), kp5Var}) == null) {
                IMEmojiReplyListener.IMEmojiReplyRequestInfo iMEmojiReplyRequestInfo = new IMEmojiReplyListener.IMEmojiReplyRequestInfo();
                iMEmojiReplyRequestInfo.emojiContent = str;
                iMEmojiReplyRequestInfo.toUser = j2;
                int i2 = 1;
                iMEmojiReplyRequestInfo.emojiPackageId = 1;
                iMEmojiReplyRequestInfo.msg = chatMsg;
                if (!z) {
                    i2 = 2;
                }
                iMEmojiReplyRequestInfo.opType = i2;
                if (BdLog.isDebugMode()) {
                    BdLog.i("start send emoji reply request");
                }
                BIMManager.emojiReplyForChatRoom(context, iMEmojiReplyRequestInfo, new l(this, kp5Var, str, chatMsg));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void d(@NonNull Context context, long j2, @NonNull ep5 ep5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), ep5Var}) == null) {
                this.c.a(-1, 0L, j2, ep5Var);
                BIMManager.registerChatRoomMsgReceiveListener(context, j2, this.d);
            }
        }

        @Override // com.baidu.tieba.uo5
        public void l(@NonNull Context context, long j2, @NonNull bp5 bp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Long.valueOf(j2), bp5Var}) == null) {
                ty5 z = z(j2);
                w19.d("im_enter_auto_retry_", j2);
                z.i(new h(this, context, j2, bp5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void o(@NonNull Context context, long j2, @NonNull ep5 ep5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j2), ep5Var}) == null) {
                this.c.d(-1, 0L, j2, ep5Var);
                BIMManager.unregisterChatRoomMsgReceiveListener(context, j2, this.d);
            }
        }

        @Override // com.baidu.tieba.uo5
        public void r(@NonNull Context context, long j2, @NonNull cp5 cp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{context, Long.valueOf(j2), cp5Var}) == null) {
                ty5 z = z(j2);
                w19.d("im_exit_auto_retry_", j2);
                z.i(new i(this, context, j2, cp5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void e(@NonNull Context context, boolean z, int i2, @NonNull jp5 jp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2), jp5Var}) == null) {
                BIMManager.getUsedEmoji(context, 1, 4, z, i2, new k(this, jp5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void n(@NonNull Context context, long j2, @NonNull ChatMsg chatMsg, @NonNull lp5 lp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j2), chatMsg, lp5Var}) == null) {
                BIMManager.sendMsgToChatRoomWithSafeParam(context, j2, BIMManager.getBdUKFromBdUid(chatMsg.getSenderUid()), chatMsg, x(context), new j(this, lp5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void f(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull ep5 ep5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, ep5Var}) == null) {
                for (Long l2 : list) {
                    py5.b(l2);
                    this.c.d(i2, j2, l2.longValue(), ep5Var);
                }
                if (!this.c.b()) {
                    BIMManager.unregisterChatRoomGroupMsgReceiveListener(context, 9L, this.d);
                }
            }
        }

        @Override // com.baidu.tieba.uo5
        public void j(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull ep5 ep5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, ep5Var}) == null) {
                if (!this.c.b()) {
                    BIMManager.registerChatRoomGroupMsgReceiveListener(context, 9L, this.d);
                }
                for (Long l2 : list) {
                    py5.b(l2);
                    this.c.a(i2, j2, l2.longValue(), ep5Var);
                }
            }
        }

        @Override // com.baidu.tieba.uo5
        public void m(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull dp5 dp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, dp5Var}) == null) {
                ty5 z = z(j2);
                w19.d("im_group_exit_auto_retry_", j2);
                z.i(new g(this, context, i2, j2, dp5Var, list));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void q(@NonNull Context context, int i2, long j2, @NonNull List<Long> list, @NonNull dp5 dp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), list, dp5Var}) == null) {
                ty5 z = z(j2);
                w19.d("im_group_enter_auto_retry_", j2);
                z.i(new f(this, context, i2, j2, dp5Var, list));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void h(@NonNull Context context, long j2, long j3, int i2, boolean z, boolean z2, @Nullable fa5<List<? extends ChatMsg>> fa5Var, @NonNull ip5 ip5Var) {
            int i3;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), fa5Var, ip5Var}) == null) {
                long j5 = 0;
                if (z) {
                    j4 = Long.MAX_VALUE;
                    i3 = i2 * (-1);
                } else if (z2) {
                    j4 = j3;
                    i3 = i2 * (-1);
                } else {
                    j5 = j3;
                    i3 = i2;
                    j4 = Long.MAX_VALUE;
                }
                BIMManager.fetchChatRoomMsgRequest(context, 10773430L, AccountManager.getUK(context), 4, j2, j5, j4, i3, z ? 1 : 0, new c(this, j2, j5, z, z2, fa5Var, ip5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void i(@NonNull Context context, long j2, @NonNull List<ChatMsg> list, @NonNull hp5 hp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Long.valueOf(j2), list, hp5Var}) == null) {
                IMEmojiReplyListListener.IMEmojiReplyListRequestInfo iMEmojiReplyListRequestInfo = new IMEmojiReplyListListener.IMEmojiReplyListRequestInfo();
                iMEmojiReplyListRequestInfo.emojiPackageId = 1;
                iMEmojiReplyListRequestInfo.roomId = j2;
                for (ChatMsg chatMsg : list) {
                    if (chatMsg.hasReaction()) {
                        iMEmojiReplyListRequestInfo.msgs.add(Long.valueOf(chatMsg.getMsgId()));
                    }
                }
                if (BdLog.isDebugMode()) {
                    BdLog.i("start fetch emoji list");
                }
                BIMManager.fetchEmojiReplyList(context, iMEmojiReplyListRequestInfo, new m(this, hp5Var));
            }
        }

        @Override // com.baidu.tieba.uo5
        public void p(@NonNull Context context, long j2, long j3, @NonNull String str, long j4, int i2, @NonNull gp5 gp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4), Integer.valueOf(i2), gp5Var}) == null) {
                IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo iMEmojiReplyDetailRequestInfo = new IMEmojiReplyDetailListener.IMEmojiReplyDetailRequestInfo();
                iMEmojiReplyDetailRequestInfo.roomId = j2;
                iMEmojiReplyDetailRequestInfo.msgId = j3;
                iMEmojiReplyDetailRequestInfo.emojiContent = str;
                iMEmojiReplyDetailRequestInfo.emojiPackageId = 1L;
                iMEmojiReplyDetailRequestInfo.sortTimeBegin = j4;
                iMEmojiReplyDetailRequestInfo.sortTimeEnd = Long.MAX_VALUE;
                iMEmojiReplyDetailRequestInfo.fetchCount = i2;
                if (BdLog.isDebugMode()) {
                    BdLog.i("start fetch emoji reply detail");
                }
                BIMManager.fetchEmojiReplyDetail(context, iMEmojiReplyDetailRequestInfo, new b(this, gp5Var));
            }
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

        /* renamed from: com.baidu.tieba.l19$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public interface InterfaceC0387b {
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
                        dh.f(this, b.d);
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
            public final InterfaceC0387b b;

            public c(@NonNull InterfaceC0387b interfaceC0387b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {interfaceC0387b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = interfaceC0387b;
            }

            public void c(@Nullable List<ChatMsg> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                    this.a = list;
                }
            }

            @NonNull
            public InterfaceC0387b a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (InterfaceC0387b) invokeV.objValue;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-683311497, "Lcom/baidu/tieba/l19$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-683311497, "Lcom/baidu/tieba/l19$b;");
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
                        dh.d(this.c);
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

        public synchronized void i(long j, @NonNull InterfaceC0387b interfaceC0387b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j, interfaceC0387b) == null) {
                synchronized (this) {
                    if (!this.b.containsKey(Long.valueOf(j))) {
                        this.b.put(Long.valueOf(j), new c(interfaceC0387b));
                        if (this.b.size() == 1) {
                            dh.f(this.c, d);
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
            public final ep5 b;

            public a(int i, long j, @NonNull ep5 ep5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), ep5Var};
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
                this.b = ep5Var;
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
            public ep5 c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.b;
                }
                return (ep5) invokeV.objValue;
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

        public synchronized void a(int i, long j, long j2, @NonNull ep5 ep5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), ep5Var}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j2));
                    if (set == null) {
                        set = new HashSet<>();
                        this.a.put(Long.valueOf(j2), set);
                    }
                    set.add(new a(i, j, ep5Var));
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

        public synchronized void c(long j, boolean z, @NonNull Function1<ep5, Void> function1) {
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

        public synchronized void d(int i, long j, long j2, @NonNull ep5 ep5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), ep5Var}) == null) {
                synchronized (this) {
                    Set<a> set = this.a.get(Long.valueOf(j2));
                    if (set != null) {
                        Iterator<a> it = set.iterator();
                        while (it.hasNext()) {
                            if (it.next().b == ep5Var) {
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

    public l19() {
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
    @Override // com.baidu.tieba.pl1
    /* renamed from: a */
    public uo5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (uo5) invokeV.objValue;
    }
}
