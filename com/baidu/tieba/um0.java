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
/* loaded from: classes6.dex */
public class um0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<cn0>> a;
    public final ConcurrentHashMap<Object, ArrayList<cn0>> b;

    public um0() {
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

    public final void a(@NonNull cn0 cn0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cn0Var) == null) {
            synchronized (this) {
                ArrayList<cn0> arrayList = this.a.get(cn0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(cn0Var.b, arrayList);
                } else {
                    Iterator<cn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == cn0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(cn0Var);
                }
                ArrayList<cn0> arrayList2 = this.b.get(cn0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(cn0Var.a, arrayList2);
                } else {
                    Iterator<cn0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == cn0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(cn0Var);
                }
            }
        }
    }

    public <T extends xm0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<cn0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<cn0> it = arrayList.iterator();
                while (it.hasNext()) {
                    cn0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends xm0> void c(@NonNull Object obj, int i, @NonNull an0<T> an0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, an0Var) == null) {
            a(new cn0(i, obj, an0Var.a(), an0Var));
        }
    }

    public <T extends xm0> void d(@NonNull Object obj, @NonNull an0<T> an0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, an0Var) == null) {
            c(obj, 0, an0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<cn0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<cn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        cn0 next = it.next();
                        ArrayList<cn0> arrayList2 = this.a.get(next.b);
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

    public final <T extends xm0> void f(cn0 cn0Var, an0<T> an0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, cn0Var, an0Var, t) == null) {
            int i = cn0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            sm0.b().a(cn0Var, an0Var, t);
                            return;
                        }
                        return;
                    }
                    tm0.b().a(cn0Var, an0Var, t);
                    return;
                }
                bn0.b().a(cn0Var, an0Var, t);
                return;
            }
            an0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
