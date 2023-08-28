package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class l1c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "Lifecycle";
    public static final HashSet<WeakReference<a>> b;
    public static AtomicInteger c;
    public static int d;
    public static long e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(long j);

        void b(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891467, "Lcom/baidu/tieba/l1c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891467, "Lcom/baidu/tieba/l1c;");
                return;
            }
        }
        b = new HashSet<>();
        c = new AtomicInteger(0);
        d = 0;
        e = 0L;
    }

    public static void a(boolean z) {
        int i;
        long j;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            int i2 = d;
            boolean z3 = true;
            if (z) {
                i = 1;
            } else {
                i = -1;
            }
            d = i + i2;
            String str2 = a;
            TLog.h(str2, " count:" + d);
            HashSet hashSet = new HashSet();
            synchronized (b) {
                j = e + 1;
                e = j;
                z2 = false;
                if (d == 1 && i2 == 0) {
                    TLog.h(a, " onForeground");
                    if (b.isEmpty()) {
                        c.incrementAndGet();
                    }
                    Iterator<WeakReference<a>> it = b.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next());
                    }
                    z2 = true;
                } else if (d == 0 && i2 == 1) {
                    TLog.h(a, " onBackground");
                    if (b.isEmpty()) {
                        c.decrementAndGet();
                    }
                    Iterator<WeakReference<a>> it2 = b.iterator();
                    while (it2.hasNext()) {
                        hashSet.add(it2.next());
                    }
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    a aVar = (a) ((WeakReference) it3.next()).get();
                    if (aVar == null) {
                        String str3 = a;
                        if (z2) {
                            str = "appFront";
                        } else {
                            str = "appBackgroundnull ref";
                        }
                        TLog.h(str3, str);
                    } else if (z2) {
                        aVar.b(j);
                    } else {
                        aVar.a(j);
                    }
                }
            }
        }
    }

    public static void b(a aVar) {
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            synchronized (b) {
                b.add(new WeakReference<>(aVar));
                if (c.get() > 0) {
                    z = true;
                    j = e;
                } else {
                    z = false;
                    j = 0;
                }
            }
            if (z) {
                aVar.b(j);
            }
        }
    }
}
