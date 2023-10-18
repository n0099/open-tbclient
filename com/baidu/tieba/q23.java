package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.SwanProcessCallStub;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class q23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final long j;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<SwanAppProcessInfo, o23> a;
    public final Deque<Long> b;
    public final Handler c;
    public final Messenger d;
    public final SwanProcessCallStub e;
    public long f;
    public final Set<m23> g;
    public final m23 h;

    /* loaded from: classes7.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, o23 o23Var);
    }

    /* loaded from: classes7.dex */
    public class a implements m23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q23 a;

        @Override // com.baidu.tieba.m23
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.q23$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0448a implements ik3<m23> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ o23 b;

            public C0448a(a aVar, String str, o23 o23Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, o23Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = o23Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(m23 m23Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m23Var) == null) {
                    m23Var.a(this.a, this.b);
                }
            }
        }

        public a(q23 q23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q23Var;
        }

        @Override // com.baidu.tieba.m23
        public void a(String str, o23 o23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, o23Var) == null) {
                if (q23.i) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.a.g.size() + " event=" + str + " client=" + o23Var.b);
                }
                synchronized (this.a.g) {
                    hk3.a(o53.M(), new C0448a(this, str, o23Var), this.a.g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m23 a;
        public final /* synthetic */ q23 b;

        public b(q23 q23Var, m23 m23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q23Var, m23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q23Var;
            this.a = m23Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.b.g) {
                if (this.b.g.contains(this.a)) {
                    if (q23.i) {
                        Log.i("SwanPuppetManager", "timeout: callback = " + this.a);
                    }
                    this.b.h(this.a);
                    this.a.timeout();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static q23 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-539420905, "Lcom/baidu/tieba/q23$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-539420905, "Lcom/baidu/tieba/q23$d;");
                    return;
                }
            }
            a = new q23(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039895, "Lcom/baidu/tieba/q23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039895, "Lcom/baidu/tieba/q23;");
                return;
            }
        }
        i = am1.a;
        j = TimeUnit.MINUTES.toMillis(5L);
    }

    @SuppressLint({"BDThrowableCheck"})
    public static q23 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!i || ProcessUtils.isMainProcess()) {
                return d.a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (q23) invokeV.objValue;
    }

    public m23 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (m23) invokeV.objValue;
    }

    public synchronized LinkedHashSet<o23> q() {
        InterceptResult invokeV;
        LinkedHashSet<o23> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    public q23() {
        SwanAppProcessInfo[] indices;
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
        this.a = new LinkedHashMap<>();
        this.b = new ArrayDeque();
        this.c = new SwanAppMessengerService.a();
        this.d = new Messenger(this.c);
        this.e = new SwanProcessCallStub(this.c);
        this.f = 0L;
        this.g = new HashSet();
        this.h = new a(this);
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.a.put(swanAppProcessInfo, new o23(swanAppProcessInfo));
            }
        }
    }

    @Nullable
    public synchronized o23 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                o23 o23Var = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    o23 o23Var2 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (o23Var2 != null && o23Var2.b.isSwanAppProcess() && !o23Var2.E()) {
                        if (o23Var2.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + o23Var2);
                            }
                            return null;
                        } else if (o23Var == null) {
                            o23Var = o23Var2;
                        }
                    }
                }
                if (i) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + o23Var);
                }
                return o23Var;
            }
        }
        return (o23) invokeV.objValue;
    }

    public /* synthetic */ q23(a aVar) {
        this();
    }

    public void b(m23 m23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m23Var) == null) {
            c(m23Var, -1L);
        }
    }

    @Nullable
    public synchronized o23 i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<o23> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (o23) invokeL.objValue;
    }

    public synchronized o23 l(@Nullable String str) {
        InterceptResult invokeL;
        o23 i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                i2 = i(str);
                if (i2 == null) {
                    i2 = e();
                }
            }
            return i2;
        }
        return (o23) invokeL.objValue;
    }

    public synchronized o23 n(int i2) {
        InterceptResult invokeI;
        o23 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (o23) invokeI.objValue;
    }

    public synchronized o23 o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        o23 o23Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                o23Var = this.a.get(swanAppProcessInfo);
            }
            return o23Var;
        }
        return (o23) invokeL.objValue;
    }

    @NonNull
    public synchronized o23 r(@Nullable String str) {
        InterceptResult invokeL;
        o23 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.b);
            }
            return l;
        }
        return (o23) invokeL.objValue;
    }

    public void c(m23 m23Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m23Var, j2) == null) {
            synchronized (this.g) {
                this.g.add(m23Var);
                if (i) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.g.size());
                }
            }
            if (j2 > 0) {
                o53.M().postDelayed(new b(this, m23Var), j2);
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.b) {
                t("checkRescuable ===>");
                boolean z = false;
                if (this.f > System.currentTimeMillis()) {
                    t(String.format(Locale.getDefault(), "disallowRescue by mRescueRefractoryUntil(%d)", Long.valueOf(this.f)));
                    return false;
                } else if (this.b.size() < 3) {
                    t(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.b.size()), 3));
                    return true;
                } else {
                    int size = this.b.size() - 3;
                    t("after offer purgeCount=" + size);
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            t("purge: " + this.b.poll());
                        }
                    }
                    t("after purge");
                    Long peek = this.b.peek();
                    if (peek == null) {
                        t("allowRescue by null oldestRecord is should not happen");
                        return true;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                    if (currentTimeMillis > j) {
                        z = true;
                    }
                    t("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
                    return z;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized o23 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                o23 o23Var = null;
                o23 o23Var2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    o23 o23Var3 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (o23Var3 != null && o23Var3.b.isSwanAppProcess() && !o23Var3.E()) {
                        if (o23Var3.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + o23Var3);
                            }
                            return o23Var3;
                        }
                        if (o23Var == null && o23Var3.T()) {
                            o23Var = o23Var3;
                        }
                        if (o23Var2 == null) {
                            o23Var2 = o23Var3;
                        }
                    }
                }
                if (o23Var != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + o23Var);
                    }
                    return o23Var;
                } else if (o23Var2 != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + o23Var2);
                    }
                    return o23Var2;
                } else {
                    for (o23 o23Var4 : this.a.values()) {
                        if (o23Var4 != null) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + o23Var4);
                            }
                            return o23Var4;
                        }
                    }
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (o23) invokeV.objValue;
    }

    public synchronized void g(String str, o23 o23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, o23Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<o23> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (o23 o23Var2 : j2) {
                    if (o23Var2 != o23Var && o23Var2 != null && o23Var2.E()) {
                        if (i) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + o23Var);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + o23Var2);
                        }
                        o23Var2.e0();
                        o23Var2.d0();
                        if (o23Var2.T()) {
                            f23 e = f23.e();
                            h23 h23Var = new h23(110, new Bundle());
                            h23Var.b(o23Var2.b);
                            e.h(h23Var);
                        }
                    }
                }
            }
        }
    }

    public void h(m23 m23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, m23Var) == null) {
            synchronized (this.g) {
                this.g.remove(m23Var);
                if (i) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.g.size());
                }
            }
        }
    }

    public void s(Message message) {
        o23 o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, message) != null) || message == null) {
            return;
        }
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
        if (!indexOf.isSwanAppProcess() || (o = o(indexOf)) == null) {
            return;
        }
        Object obj = message.obj;
        if (!(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        bundle.setClassLoader(q23.class.getClassLoader());
        o.p0(bundle.getLong("property_launch_cost", -1L));
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && i) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public synchronized void v(SwanAppProcessInfo swanAppProcessInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, swanAppProcessInfo) == null) {
            synchronized (this) {
                o23 remove = this.a.remove(swanAppProcessInfo);
                if (remove != null) {
                    this.a.put(swanAppProcessInfo, remove);
                }
                if (i) {
                    u("lru -> " + swanAppProcessInfo);
                }
            }
        }
    }

    @NonNull
    public synchronized List<o23> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (o23 o23Var : this.a.values()) {
                        if (TextUtils.equals(o23Var.getAppId(), str)) {
                            arrayList.add(o23Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <FILTER> o23 p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (o23 o23Var : this.a.values()) {
                    if (cVar.a(filter, o23Var)) {
                        return o23Var;
                    }
                }
                return null;
            }
        }
        return (o23) invokeLL.objValue;
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.b.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LinkedHashSet<o23> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (o23 o23Var : q) {
                sb.append("\n--> ");
                sb.append(o23Var.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.b) {
                if (d()) {
                    this.b.offer(Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_preload_preload_scene", "1");
                    n23.n(wo2.c(), bundle);
                }
            }
        }
    }
}
