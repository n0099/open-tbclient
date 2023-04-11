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
/* loaded from: classes5.dex */
public class ll0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<tl0>> a;
    public final ConcurrentHashMap<Object, ArrayList<tl0>> b;

    public ll0() {
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

    public final void a(@NonNull tl0 tl0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tl0Var) == null) {
            synchronized (this) {
                ArrayList<tl0> arrayList = this.a.get(tl0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(tl0Var.b, arrayList);
                } else {
                    Iterator<tl0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == tl0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(tl0Var);
                }
                ArrayList<tl0> arrayList2 = this.b.get(tl0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(tl0Var.a, arrayList2);
                } else {
                    Iterator<tl0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == tl0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(tl0Var);
                }
            }
        }
    }

    public <T extends ol0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<tl0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<tl0> it = arrayList.iterator();
                while (it.hasNext()) {
                    tl0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends ol0> void c(@NonNull Object obj, int i, @NonNull rl0<T> rl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, rl0Var) == null) {
            a(new tl0(i, obj, rl0Var.a(), rl0Var));
        }
    }

    public <T extends ol0> void d(@NonNull Object obj, @NonNull rl0<T> rl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, rl0Var) == null) {
            c(obj, 0, rl0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<tl0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<tl0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        tl0 next = it.next();
                        ArrayList<tl0> arrayList2 = this.a.get(next.b);
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

    public final <T extends ol0> void f(tl0 tl0Var, rl0<T> rl0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, tl0Var, rl0Var, t) == null) {
            int i = tl0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            jl0.b().a(tl0Var, rl0Var, t);
                            return;
                        }
                        return;
                    }
                    kl0.b().a(tl0Var, rl0Var, t);
                    return;
                }
                sl0.b().a(tl0Var, rl0Var, t);
                return;
            }
            rl0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
