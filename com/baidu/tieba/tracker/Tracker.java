package com.baidu.tieba.tracker;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t3b;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.tieba.u3b;
import com.baidu.tieba.z3b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001cH\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0018H\u0002J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/tracker/Tracker;", "", "()V", "doReportRunnable", "Lkotlin/Function0;", "", "mDefaultReport", "", "getMDefaultReport", "()Z", "setMDefaultReport", "(Z)V", "mDelayMillis", "", "mHandler", "Landroid/os/Handler;", "mPageExclude", "", "", "getMPageExclude", "()Ljava/util/Set;", "mPageSupport", "getMPageSupport", "mProvider", "Lcom/baidu/tieba/tracker/core/ReportProvider;", "mWaitQueue", "", "", "Lcom/baidu/tieba/tracker/core/data/IEventNode;", "add2ReadyQueue", "ubcId", "events", "immediatelyReport", "init", "app", "Landroid/app/Application;", "isCanReport", "event", "isReportImmediately", "registerProvider", "provider", "updateDelayMillis", "min", "", "Companion", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Tracker {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public static final Lazy<Tracker> j;
    public transient /* synthetic */ FieldHolder $fh;
    public u3b a;
    public final Map<String, List<IEventNode>> b;
    public final Handler c;
    public long d;
    public final Set<String> e;
    public final Set<String> f;
    public boolean g;
    public Function0<Unit> h;

    public final void n(Application app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            Intrinsics.checkNotNullParameter(app, "app");
        }
    }

    /* loaded from: classes8.dex */
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

        public final Tracker a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (Tracker) invokeV.objValue;
        }

        public final Tracker b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (Tracker) Tracker.j.getValue();
            }
            return (Tracker) invokeV.objValue;
        }

        public final void c(u3b u3bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u3bVar) != null) || u3bVar == null) {
                return;
            }
            Tracker.i.b().q(u3bVar);
        }

        public final void d(String ubcId, IEventNode iEventNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, ubcId, iEventNode) == null) {
                Intrinsics.checkNotNullParameter(ubcId, "ubcId");
                if (iEventNode == null) {
                    return;
                }
                synchronized (Tracker.i.b().b) {
                    Tracker.i.b().f(ubcId, iEventNode);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-384339224, "Lcom/baidu/tieba/tracker/Tracker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-384339224, "Lcom/baidu/tieba/tracker/Tracker;");
                return;
            }
        }
        i = new a(null);
        j = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) Tracker$Companion$instance$2.INSTANCE);
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final Set<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Set) invokeV.objValue;
    }

    public final Set<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (Set) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Handler handler = this.c;
            final Function0<Unit> function0 = this.h;
            handler.removeCallbacks(new Runnable() { // from class: com.baidu.tieba.o3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Tracker.l(Function0.this);
                    }
                }
            });
            Handler handler2 = this.c;
            final Function0<Unit> function02 = this.h;
            handler2.post(new Runnable() { // from class: com.baidu.tieba.p3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Tracker.m(Function0.this);
                    }
                }
            });
        }
    }

    public Tracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new LinkedHashMap();
        this.c = new Handler(Looper.getMainLooper());
        this.d = 60000L;
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        this.h = new Function0<Unit>(this) { // from class: com.baidu.tieba.tracker.Tracker$doReportRunnable$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Tracker this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                u3b u3bVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                Map map = this.this$0.b;
                Tracker tracker = this.this$0;
                synchronized (map) {
                    if (!tracker.b.isEmpty()) {
                        for (Map.Entry entry : tracker.b.entrySet()) {
                            u3bVar = tracker.a;
                            if (u3bVar != null) {
                                u3bVar.b((String) entry.getKey(), (List) entry.getValue());
                            }
                        }
                        tracker.b.clear();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
    }

    public static final void g(Function0 tmp0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, tmp0) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }
    }

    public static final void l(Function0 tmp0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, tmp0) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }
    }

    public static final void m(Function0 tmp0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tmp0) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }
    }

    public static final void t(Function0 tmp0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, tmp0) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }
    }

    public static final void u(Function0 tmp0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, tmp0) == null) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke();
        }
    }

    public final void q(u3b u3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u3bVar) == null) {
            this.a = u3bVar;
            if (u3bVar != null) {
                u3bVar.a();
            }
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            Handler handler = this.c;
            final Function0<Unit> function0 = this.h;
            handler.removeCallbacks(new Runnable() { // from class: com.baidu.tieba.s3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Tracker.t(Function0.this);
                    }
                }
            });
            Handler handler2 = this.c;
            final Function0<Unit> function02 = this.h;
            handler2.post(new Runnable() { // from class: com.baidu.tieba.r3b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Tracker.u(Function0.this);
                    }
                }
            });
            this.d = i2 * 60 * 1000;
        }
    }

    public final void f(String str, IEventNode iEventNode) {
        u3b u3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, iEventNode) == null) {
            if (p(iEventNode) && t3b.a.a(iEventNode) && (u3bVar = this.a) != null) {
                u3bVar.c(str, iEventNode);
            }
            if (o(iEventNode)) {
                if (this.b.get(str) == null) {
                    this.b.put(str, new ArrayList());
                    Handler handler = this.c;
                    final Function0<Unit> function0 = this.h;
                    handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.q3b
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Tracker.g(Function0.this);
                            }
                        }
                    }, this.d);
                }
                List<IEventNode> list = this.b.get(str);
                if (list != null) {
                    list.add(iEventNode);
                }
            }
        }
    }

    public final boolean o(IEventNode iEventNode) {
        InterceptResult invokeL;
        IEventNode iEventNode2;
        EventParams trackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iEventNode)) == null) {
            IEventNode next = iEventNode.getNext();
            while (true) {
                if (next != null) {
                    iEventNode2 = next.getNext();
                } else {
                    iEventNode2 = null;
                }
                if (iEventNode2 == null) {
                    break;
                }
                next = next.getNext();
            }
            String str = (next == null || (trackParams = next.getTrackParams()) == null || (str = trackParams.get("page")) == null) ? "unknown" : "unknown";
            if (CollectionsKt___CollectionsKt.contains(this.f, str)) {
                return false;
            }
            if (CollectionsKt___CollectionsKt.contains(this.e, str)) {
                return true;
            }
            return this.g;
        }
        return invokeL.booleanValue;
    }

    public final boolean p(IEventNode iEventNode) {
        InterceptResult invokeL;
        Object obj;
        IEventNode iEventNode2;
        EventParams trackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iEventNode)) == null) {
            IEventNode next = iEventNode.getNext();
            while (true) {
                obj = null;
                if (next != null) {
                    iEventNode2 = next.getNext();
                } else {
                    iEventNode2 = null;
                }
                if (iEventNode2 == null) {
                    break;
                }
                next = next.getNext();
            }
            if (next != null && (trackParams = next.getTrackParams()) != null) {
                obj = trackParams.get("type");
            }
            return Intrinsics.areEqual(obj, z3b.a.a.a());
        }
        return invokeL.booleanValue;
    }
}
