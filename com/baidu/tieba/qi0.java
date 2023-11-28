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
/* loaded from: classes7.dex */
public class qi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<zi0>> a;
    public final ConcurrentHashMap<Object, ArrayList<zi0>> b;

    public qi0() {
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

    public final void a(@NonNull zi0 zi0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zi0Var) == null) {
            synchronized (this) {
                ArrayList<zi0> arrayList = this.a.get(zi0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(zi0Var.b, arrayList);
                } else {
                    Iterator<zi0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == zi0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(zi0Var);
                }
                ArrayList<zi0> arrayList2 = this.b.get(zi0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(zi0Var.a, arrayList2);
                } else {
                    Iterator<zi0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == zi0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(zi0Var);
                }
            }
        }
    }

    public <T extends ui0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<zi0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<zi0> it = arrayList.iterator();
                while (it.hasNext()) {
                    zi0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends ui0> void c(@NonNull Object obj, int i, @NonNull xi0<T> xi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, xi0Var) == null) {
            a(new zi0(i, obj, xi0Var.a(), xi0Var));
        }
    }

    public <T extends ui0> void d(@NonNull Object obj, @NonNull xi0<T> xi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, xi0Var) == null) {
            c(obj, 0, xi0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<zi0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<zi0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        zi0 next = it.next();
                        ArrayList<zi0> arrayList2 = this.a.get(next.b);
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

    public final <T extends ui0> void f(zi0 zi0Var, xi0<T> xi0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, zi0Var, xi0Var, t) == null) {
            int i = zi0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            oi0.b().a(zi0Var, xi0Var, t);
                            return;
                        }
                        return;
                    }
                    pi0.b().a(zi0Var, xi0Var, t);
                    return;
                }
                yi0.b().a(zi0Var, xi0Var, t);
                return;
            }
            xi0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
