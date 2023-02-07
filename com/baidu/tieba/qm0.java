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
public class qm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<ym0>> a;
    public final ConcurrentHashMap<Object, ArrayList<ym0>> b;

    public qm0() {
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

    public final void a(@NonNull ym0 ym0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ym0Var) == null) {
            synchronized (this) {
                ArrayList<ym0> arrayList = this.a.get(ym0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(ym0Var.b, arrayList);
                } else {
                    Iterator<ym0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == ym0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(ym0Var);
                }
                ArrayList<ym0> arrayList2 = this.b.get(ym0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(ym0Var.a, arrayList2);
                } else {
                    Iterator<ym0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == ym0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(ym0Var);
                }
            }
        }
    }

    public <T extends tm0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<ym0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<ym0> it = arrayList.iterator();
                while (it.hasNext()) {
                    ym0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends tm0> void c(@NonNull Object obj, int i, @NonNull wm0<T> wm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, wm0Var) == null) {
            a(new ym0(i, obj, wm0Var.a(), wm0Var));
        }
    }

    public <T extends tm0> void d(@NonNull Object obj, @NonNull wm0<T> wm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, wm0Var) == null) {
            c(obj, 0, wm0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<ym0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<ym0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ym0 next = it.next();
                        ArrayList<ym0> arrayList2 = this.a.get(next.b);
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

    public final <T extends tm0> void f(ym0 ym0Var, wm0<T> wm0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, ym0Var, wm0Var, t) == null) {
            int i = ym0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            om0.b().a(ym0Var, wm0Var, t);
                            return;
                        }
                        return;
                    }
                    pm0.b().a(ym0Var, wm0Var, t);
                    return;
                }
                xm0.b().a(ym0Var, wm0Var, t);
                return;
            }
            wm0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
