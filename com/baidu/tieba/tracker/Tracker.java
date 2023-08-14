package com.baidu.tieba.tracker;

import android.app.Application;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.tieba.wia;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/tracker/Tracker;", "", "()V", "mInitializer", "", "mProviders", "", "Lcom/baidu/tieba/tracker/core/ReportProvider;", "mWaitQueue", "", "", "Lcom/baidu/tieba/tracker/core/data/IEventNode;", "init", "", "app", "Landroid/app/Application;", "registerProvider", "provider", "reportEvent", "pid", "events", "Companion", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Tracker {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public static final Lazy<Tracker> e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Set<wia> b;
    public final Map<String, IEventNode> c;

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
                return (Tracker) Tracker.e.getValue();
            }
            return (Tracker) invokeV.objValue;
        }

        public final void c(wia wiaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wiaVar) != null) || wiaVar == null) {
                return;
            }
            Tracker.d.b().f(wiaVar);
        }

        public final void d(String event, IEventNode iEventNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, event, iEventNode) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (iEventNode != null) {
                    synchronized (Tracker.d.b().c) {
                        Tracker.d.b().g(event, iEventNode);
                        Unit unit = Unit.INSTANCE;
                    }
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
        d = new a(null);
        e = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) Tracker$Companion$instance$2.INSTANCE);
    }

    public Tracker() {
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
        this.b = new LinkedHashSet();
        this.c = new LinkedHashMap();
    }

    public final void e(Application app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, app) == null) {
            Intrinsics.checkNotNullParameter(app, "app");
            this.a = true;
        }
    }

    public final void g(String str, IEventNode iEventNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iEventNode) == null) {
            if (this.a) {
                for (wia wiaVar : this.b) {
                    wiaVar.onEventReport(str, iEventNode);
                }
                return;
            }
            this.c.put(str, iEventNode);
        }
    }

    public final void f(wia wiaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wiaVar) == null) {
            Set<wia> set = this.b;
            wiaVar.onInit();
            set.add(wiaVar);
            synchronized (this.c) {
                if (!this.c.isEmpty()) {
                    for (Map.Entry<String, IEventNode> entry : this.c.entrySet()) {
                        g(entry.getKey(), entry.getValue());
                    }
                    this.c.clear();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
