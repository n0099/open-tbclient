package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.impersonal.sprite.ImSpriteSysLog;
import com.baidu.tieba.o18;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class q18 implements hg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final c k;
    public static final long l;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<h08>> b;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<h08>> c;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<h08>> d;
    public final fg5 e;
    public final String f;
    public d g;
    public final HashSet<o18.b> h;
    public Comparator<ChatMsg> i;
    public final Comparator<h08> j;

    /* loaded from: classes5.dex */
    public interface d {
        @MainThread
        void a(long j, List<? extends h08> list, f fVar, e eVar);
    }

    /* loaded from: classes5.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final a b;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-540195409, "Lcom/baidu/tieba/q18$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-540195409, "Lcom/baidu/tieba/q18$f;");
                    return;
                }
            }
            b = new a(null);
        }

        public /* synthetic */ f(boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, z2, z3);
        }

        /* loaded from: classes5.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

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

            public final f a(boolean z, boolean z2, boolean z3) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                    return new f(z, z2, z3, null);
                }
                return (f) invokeCommon.objValue;
            }
        }

        public f(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = z3;
        }

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements Comparator<ChatMsg> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ChatMsg chatMsg, ChatMsg chatMsg2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatMsg, chatMsg2)) == null) {
                if (chatMsg == null || chatMsg2 == null || TextUtils.equals(chatMsg.getMsgKey(), chatMsg2.getMsgKey())) {
                    return 0;
                }
                if (chatMsg.getMsgId() - chatMsg2.getMsgId() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Comparator<h08> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(h08 h08Var, h08 h08Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h08Var, h08Var2)) == null) {
                if (h08Var == null || h08Var2 == null || TextUtils.equals(h08Var.b(), h08Var2.b())) {
                    return 0;
                }
                if (h08Var.a() == 0 || h08Var.a() - h08Var2.a() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
                }
            }
        }

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.longValue;
            }
            return q18.l;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-540195440, "Lcom/baidu/tieba/q18$e;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-540195440, "Lcom/baidu/tieba/q18$e;");
            }
        }

        public e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        public final int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements ig5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q18 a;
        public final /* synthetic */ ChatMsg b;

        public g(q18 q18Var, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q18Var, chatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q18Var;
            this.b = chatMsg;
        }

        @Override // com.baidu.tieba.ig5
        public void a(ChatMsg msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                TreeSet<ChatMsg> y = this.a.y(msg);
                this.a.u(Long.MAX_VALUE);
                ChatMsg b = x18.b(new i08());
                if (b != null) {
                    b.setSendMsgTime(System.currentTimeMillis() / 1000);
                    y.add(b);
                }
                this.a.q(q18.k.a(), y, new e(4));
                HashSet<o18.b> hashSet = this.a.h;
                ChatMsg chatMsg = this.b;
                for (o18.b bVar : hashSet) {
                    String msgKey = chatMsg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey, "msgData.msgKey");
                    bVar.d(msgKey);
                }
            }
        }

        @Override // com.baidu.tieba.ig5
        public void b(int i, String errorMsg, SendMsgResponse sendMsgResponse) {
            String str;
            String msgKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg, sendMsgResponse) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(sendMsgResponse, "sendMsgResponse");
                ChatMsg chatMsg = sendMsgResponse.msg;
                if (chatMsg != null) {
                    q18 q18Var = this.a;
                    String msgKey2 = chatMsg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey2, "sendMsgResponse.msg.msgKey");
                    q18Var.i(msgKey2);
                }
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this.a.j());
                treeSet.add(sendMsgResponse.msg);
                if (i != 0) {
                    w58 imSpriteSysLog = ImSpriteSysLog.getInstance();
                    String n = this.a.n();
                    StringBuilder sb = new StringBuilder();
                    sb.append("sendMessage responseCode : ");
                    sb.append(i);
                    sb.append("errorMsg : ");
                    sb.append(errorMsg);
                    sb.append("sendMsgResponse : ");
                    ChatMsg chatMsg2 = sendMsgResponse.msg;
                    if (chatMsg2 != null && (msgKey = chatMsg2.getMsgKey()) != null) {
                        str = msgKey.toString();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    imSpriteSysLog.c(n, sb.toString());
                    this.a.q(q18.k.a(), treeSet, new e(4));
                } else {
                    this.a.q(q18.k.a(), treeSet, new e(8));
                }
                for (o18.b bVar : this.a.h) {
                    ChatMsg chatMsg3 = sendMsgResponse.msg;
                    Intrinsics.checkNotNullExpressionValue(chatMsg3, "sendMsgResponse.msg");
                    bVar.f(i, errorMsg, chatMsg3);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039089, "Lcom/baidu/tieba/q18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039089, "Lcom/baidu/tieba/q18;");
                return;
            }
        }
        k = new c(null);
        l = gg.g(BIMManager.getBdUidFromBdUK(m35.m().s("key_funny_sprite_uk", "")), 17592328994873L);
    }

    public q18(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        new SparseArray();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = eg5.a();
        this.f = "IMSprite";
        this.h = new HashSet<>();
        this.i = new a();
        this.j = new b();
    }

    public final void c(o18.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null) {
            this.h.add(bVar);
        }
    }

    public final void s(ChatMsg msgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, msgData) == null) {
            Intrinsics.checkNotNullParameter(msgData, "msgData");
            t(msgData);
        }
    }

    public final void t(ChatMsg msgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, msgData) == null) {
            Intrinsics.checkNotNullParameter(msgData, "msgData");
            this.e.d(this.a, msgData, l, new g(this, msgData));
        }
    }

    public final void u(final long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            ng.d(new Runnable() { // from class: com.baidu.tieba.x08
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q18.v(q18.this, j);
                    }
                }
            });
        }
    }

    public final void x(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            this.g = dVar;
        }
    }

    public final TreeSet<ChatMsg> y(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, chatMsg)) == null) {
            Intrinsics.checkNotNullParameter(chatMsg, "chatMsg");
            TreeSet<ChatMsg> treeSet = new TreeSet<>(cg5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public final Comparator<ChatMsg> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (Comparator) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public static final void e(q18 this$0, long j, List list, boolean z, boolean z2, boolean z3, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            d dVar = this$0.g;
            if (dVar != null) {
                dVar.a(j, list, f.b.a(z, z2, z3), loadType);
            }
        }
    }

    public static final void g(q18 this$0, long j, TreeSet msgSet, boolean z, boolean z2, boolean z3, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{this$0, Long.valueOf(j), msgSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgSet, "$msgSet");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            this$0.d(j, msgSet, z, z2, z3, loadType);
        }
    }

    public static final void l(q18 this$0, long j, boolean z, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{this$0, Long.valueOf(j), Boolean.valueOf(z), collection}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z) {
                SizedSyncTreeSet<h08> m = this$0.m(j);
                if (m.isEmpty() && (collection instanceof Collection)) {
                    m.addAll(collection);
                }
            }
        }
    }

    public static final void p(ArrayList arrayList, q18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, arrayList, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                k08<Object> c2 = x18.c((ChatMsg) it.next());
                if (c2 != null) {
                    arrayList2.add(c2);
                }
            }
            for (o18.b bVar : this$0.h) {
                bVar.a(arrayList2);
            }
            TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.i);
            treeSet.addAll(arrayList);
            this$0.f(l, treeSet, false, false, true, new e(3));
        }
    }

    public static final void v(final q18 this$0, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, null, this$0, j) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator<h08> it = this$0.k(l).iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().a() == j) {
                    z = true;
                    it.remove();
                }
            }
            if (!z) {
                return;
            }
            ng.e(new Runnable() { // from class: com.baidu.tieba.h18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q18.w(q18.this);
                    }
                }
            });
        }
    }

    public static final void w(q18 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SizedSyncTreeSet<h08> k2 = this$0.k(l);
            d dVar = this$0.g;
            if (dVar != null) {
                dVar.a(l, new ArrayList(k2), f.b.a(true, false, false), new e(7));
            }
        }
    }

    public final Boolean i(String msgKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, msgKey)) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            Iterator<h08> it = k(l).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "set.iterator()");
            while (it.hasNext()) {
                if (gi.isEquals(it.next().b(), msgKey)) {
                    it.remove();
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public final SizedSyncTreeSet<h08> k(final long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            SizedSyncTreeSet<h08> sizedSyncTreeSet = this.b.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<h08> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(600, new TreeSet(this.j));
                sizedSyncTreeSet2.setCallback(new SizedSyncTreeSet.a() { // from class: com.baidu.tieba.e18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
                    public final void a(boolean z, Collection collection) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, collection) == null) {
                            q18.l(q18.this, j, z, collection);
                        }
                    }
                });
                this.b.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<h08> m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            SizedSyncTreeSet<h08> sizedSyncTreeSet = this.d.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<h08> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(200, new TreeSet(this.j));
                this.d.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<h08> o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            SizedSyncTreeSet<h08> sizedSyncTreeSet = this.c.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<h08> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(new TreeSet(this.j));
                this.c.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @WorkerThread
    public final void d(final long j, TreeSet<ChatMsg> treeSet, final boolean z, final boolean z2, final boolean z3, final e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar}) == null) {
            SizedSyncTreeSet<h08> k2 = k(j);
            SizedSyncTreeSet<h08> o = o(j);
            SizedSyncTreeSet<h08> m = m(j);
            o.clear();
            f a2 = f.b.a(z, z2, z3);
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext()) {
                ChatMsg msg = it.next();
                try {
                    Intrinsics.checkNotNullExpressionValue(msg, "msg");
                    try {
                        h08 h = h(j, msg, a2);
                        if (h != null) {
                            o.add(h);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (!o.isEmpty() || eVar.getType() == 0) {
                if (!m.isEmpty() && z3) {
                    m.addAll(o);
                } else {
                    k2.addAll(o);
                }
                if (eVar.getType() != 8) {
                    final ArrayList arrayList = new ArrayList(k2);
                    ng.c(new Runnable() { // from class: com.baidu.tieba.z08
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                q18.e(q18.this, j, arrayList, z, z2, z3, eVar);
                            }
                        }
                    });
                }
            }
        }
    }

    public final void f(final long j, final TreeSet<ChatMsg> treeSet, final boolean z, final boolean z2, final boolean z3, final e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar}) == null) {
            ng.d(new Runnable() { // from class: com.baidu.tieba.f18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q18.g(q18.this, j, treeSet, z, z2, z3, eVar);
                    }
                }
            });
        }
    }

    public final h08 h(long j, ChatMsg chatMsg, f fVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), chatMsg, fVar})) == null) {
            return r(j, chatMsg);
        }
        return (h08) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.hg5
    public void onReceiveMessage(int i, int i2, final ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, arrayList) == null) && arrayList != null) {
            ng.e(new Runnable() { // from class: com.baidu.tieba.n18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q18.p(arrayList, this);
                    }
                }
            });
        }
    }

    public final void q(long j, TreeSet<ChatMsg> msgSet, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), msgSet, loadType}) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            f(j, msgSet, true, false, false, loadType);
        }
    }

    public final h08 r(long j, ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j, chatMsg)) == null) {
            return x18.c(chatMsg);
        }
        return (h08) invokeJL.objValue;
    }
}
