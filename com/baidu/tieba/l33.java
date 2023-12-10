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
public final class l33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final long j;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<SwanAppProcessInfo, j33> a;
    public final Deque<Long> b;
    public final Handler c;
    public final Messenger d;
    public final SwanProcessCallStub e;
    public long f;
    public final Set<h33> g;
    public final h33 h;

    /* loaded from: classes7.dex */
    public interface c<FILTER> {
        boolean a(FILTER filter, j33 j33Var);
    }

    /* loaded from: classes7.dex */
    public class a implements h33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;

        @Override // com.baidu.tieba.h33
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.l33$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0384a implements dl3<h33> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ j33 b;

            public C0384a(a aVar, String str, j33 j33Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, j33Var};
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
                this.b = j33Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(h33 h33Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h33Var) == null) {
                    h33Var.a(this.a, this.b);
                }
            }
        }

        public a(l33 l33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l33Var;
        }

        @Override // com.baidu.tieba.h33
        public void a(String str, j33 j33Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, j33Var) == null) {
                if (l33.i) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + this.a.g.size() + " event=" + str + " client=" + j33Var.b);
                }
                synchronized (this.a.g) {
                    cl3.a(j63.M(), new C0384a(this, str, j33Var), this.a.g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h33 a;
        public final /* synthetic */ l33 b;

        public b(l33 l33Var, h33 h33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l33Var, h33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l33Var;
            this.a = h33Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.b.g) {
                if (this.b.g.contains(this.a)) {
                    if (l33.i) {
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
        public static l33 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681643139, "Lcom/baidu/tieba/l33$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-681643139, "Lcom/baidu/tieba/l33$d;");
                    return;
                }
            }
            a = new l33(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891901, "Lcom/baidu/tieba/l33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891901, "Lcom/baidu/tieba/l33;");
                return;
            }
        }
        i = vm1.a;
        j = TimeUnit.MINUTES.toMillis(5L);
    }

    @SuppressLint({"BDThrowableCheck"})
    public static l33 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!i || ProcessUtils.isMainProcess()) {
                return d.a;
            }
            throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
        }
        return (l33) invokeV.objValue;
    }

    public h33 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (h33) invokeV.objValue;
    }

    public synchronized LinkedHashSet<j33> q() {
        InterceptResult invokeV;
        LinkedHashSet<j33> linkedHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                linkedHashSet = new LinkedHashSet<>(this.a.values());
            }
            return linkedHashSet;
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    public l33() {
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
                this.a.put(swanAppProcessInfo, new j33(swanAppProcessInfo));
            }
        }
    }

    @Nullable
    public synchronized j33 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                u("b4 computNextPreloadProcess");
                j33 j33Var = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    j33 j33Var2 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (j33Var2 != null && j33Var2.b.isSwanAppProcess() && !j33Var2.E()) {
                        if (j33Var2.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + j33Var2);
                            }
                            return null;
                        } else if (j33Var == null) {
                            j33Var = j33Var2;
                        }
                    }
                }
                if (i) {
                    Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + j33Var);
                }
                return j33Var;
            }
        }
        return (j33) invokeV.objValue;
    }

    public /* synthetic */ l33(a aVar) {
        this();
    }

    public void b(h33 h33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h33Var) == null) {
            c(h33Var, -1L);
        }
    }

    @Nullable
    public synchronized j33 i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                List<j33> j2 = j(str);
                if (j2.isEmpty()) {
                    return null;
                }
                return j2.get(j2.size() - 1);
            }
        }
        return (j33) invokeL.objValue;
    }

    public synchronized j33 l(@Nullable String str) {
        InterceptResult invokeL;
        j33 i2;
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
        return (j33) invokeL.objValue;
    }

    public synchronized j33 n(int i2) {
        InterceptResult invokeI;
        j33 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                o = o(SwanAppProcessInfo.indexOf(i2));
            }
            return o;
        }
        return (j33) invokeI.objValue;
    }

    public synchronized j33 o(SwanAppProcessInfo swanAppProcessInfo) {
        InterceptResult invokeL;
        j33 j33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, swanAppProcessInfo)) == null) {
            synchronized (this) {
                j33Var = this.a.get(swanAppProcessInfo);
            }
            return j33Var;
        }
        return (j33) invokeL.objValue;
    }

    @NonNull
    public synchronized j33 r(@Nullable String str) {
        InterceptResult invokeL;
        j33 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                l = l(str);
                v(l.b);
            }
            return l;
        }
        return (j33) invokeL.objValue;
    }

    public void c(h33 h33Var, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h33Var, j2) == null) {
            synchronized (this.g) {
                this.g.add(h33Var);
                if (i) {
                    Log.i("SwanPuppetManager", "addCallback: after = " + this.g.size());
                }
            }
            if (j2 > 0) {
                j63.M().postDelayed(new b(this, h33Var), j2);
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

    public synchronized j33 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                u("b4 computNextAvailableProcess");
                j33 j33Var = null;
                j33 j33Var2 = null;
                for (int i2 = 0; i2 <= 5; i2++) {
                    j33 j33Var3 = this.a.get(SwanAppProcessInfo.indexOf(i2));
                    if (j33Var3 != null && j33Var3.b.isSwanAppProcess() && !j33Var3.E()) {
                        if (j33Var3.S()) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + j33Var3);
                            }
                            return j33Var3;
                        }
                        if (j33Var == null && j33Var3.T()) {
                            j33Var = j33Var3;
                        }
                        if (j33Var2 == null) {
                            j33Var2 = j33Var3;
                        }
                    }
                }
                if (j33Var != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + j33Var);
                    }
                    return j33Var;
                } else if (j33Var2 != null) {
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + j33Var2);
                    }
                    return j33Var2;
                } else {
                    for (j33 j33Var4 : this.a.values()) {
                        if (j33Var4 != null) {
                            if (i) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + j33Var4);
                            }
                            return j33Var4;
                        }
                    }
                    if (i) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                    }
                    return o(SwanAppProcessInfo.P0);
                }
            }
        }
        return (j33) invokeV.objValue;
    }

    public synchronized void g(String str, j33 j33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, j33Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                List<j33> j2 = k().j(str);
                if (j2.isEmpty()) {
                    return;
                }
                for (j33 j33Var2 : j2) {
                    if (j33Var2 != j33Var && j33Var2 != null && j33Var2.E()) {
                        if (i) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + j33Var);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + j33Var2);
                        }
                        j33Var2.e0();
                        j33Var2.d0();
                        if (j33Var2.T()) {
                            a33 e = a33.e();
                            c33 c33Var = new c33(110, new Bundle());
                            c33Var.b(j33Var2.b);
                            e.h(c33Var);
                        }
                    }
                }
            }
        }
    }

    public void h(h33 h33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, h33Var) == null) {
            synchronized (this.g) {
                this.g.remove(h33Var);
                if (i) {
                    Log.i("SwanPuppetManager", "delCallback: after = " + this.g.size());
                }
            }
        }
    }

    public void s(Message message) {
        j33 o;
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
        bundle.setClassLoader(l33.class.getClassLoader());
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
                j33 remove = this.a.remove(swanAppProcessInfo);
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
    public synchronized List<j33> j(@Nullable String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (j33 j33Var : this.a.values()) {
                        if (TextUtils.equals(j33Var.getAppId(), str)) {
                            arrayList.add(j33Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized <FILTER> j33 p(FILTER filter, c<FILTER> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, filter, cVar)) == null) {
            synchronized (this) {
                for (j33 j33Var : this.a.values()) {
                    if (cVar.a(filter, j33Var)) {
                        return j33Var;
                    }
                }
                return null;
            }
        }
        return (j33) invokeLL.objValue;
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
            LinkedHashSet<j33> q = q();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(":");
            sb.append("\n-> clients: ");
            for (j33 j33Var : q) {
                sb.append("\n--> ");
                sb.append(j33Var.toString());
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
                    i33.n(rp2.c(), bundle);
                }
            }
        }
    }
}
