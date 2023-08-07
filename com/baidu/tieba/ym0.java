package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class ym0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<hn0>> a;
    public final ConcurrentHashMap<Object, ArrayList<hn0>> b;

    public ym0() {
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
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public final void a(@NonNull hn0 hn0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hn0Var) == null) {
            synchronized (this) {
                ArrayList<hn0> arrayList = this.a.get(hn0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(hn0Var.b, arrayList);
                } else {
                    Iterator<hn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == hn0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(hn0Var);
                }
                ArrayList<hn0> arrayList2 = this.b.get(hn0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(hn0Var.a, arrayList2);
                } else {
                    Iterator<hn0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == hn0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(hn0Var);
                }
            }
        }
    }

    public <T extends cn0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<hn0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<hn0> it = arrayList.iterator();
                while (it.hasNext()) {
                    hn0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends cn0> void c(@NonNull Object obj, int i, @NonNull fn0<T> fn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, fn0Var) == null) {
            a(new hn0(i, obj, fn0Var.a(), fn0Var));
        }
    }

    public <T extends cn0> void d(@NonNull Object obj, @NonNull fn0<T> fn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, fn0Var) == null) {
            c(obj, 0, fn0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<hn0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<hn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        hn0 next = it.next();
                        ArrayList<hn0> arrayList2 = this.a.get(next.b);
                        if (arrayList2 != null) {
                            arrayList2.remove(next);
                        }
                    }
                    arrayList.clear();
                    this.b.remove(obj);
                }
            }
        }
    }

    public final <T extends cn0> void f(hn0 hn0Var, fn0<T> fn0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, hn0Var, fn0Var, t) == null) {
            int i = hn0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            wm0.b().a(hn0Var, fn0Var, t);
                            return;
                        }
                        return;
                    }
                    xm0.b().a(hn0Var, fn0Var, t);
                    return;
                }
                gn0.b().a(hn0Var, fn0Var, t);
                return;
            }
            fn0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
