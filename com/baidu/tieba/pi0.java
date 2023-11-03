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
public class pi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<yi0>> a;
    public final ConcurrentHashMap<Object, ArrayList<yi0>> b;

    public pi0() {
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

    public final void a(@NonNull yi0 yi0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yi0Var) == null) {
            synchronized (this) {
                ArrayList<yi0> arrayList = this.a.get(yi0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(yi0Var.b, arrayList);
                } else {
                    Iterator<yi0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == yi0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(yi0Var);
                }
                ArrayList<yi0> arrayList2 = this.b.get(yi0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(yi0Var.a, arrayList2);
                } else {
                    Iterator<yi0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == yi0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(yi0Var);
                }
            }
        }
    }

    public <T extends ti0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<yi0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<yi0> it = arrayList.iterator();
                while (it.hasNext()) {
                    yi0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends ti0> void c(@NonNull Object obj, int i, @NonNull wi0<T> wi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, wi0Var) == null) {
            a(new yi0(i, obj, wi0Var.a(), wi0Var));
        }
    }

    public <T extends ti0> void d(@NonNull Object obj, @NonNull wi0<T> wi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, wi0Var) == null) {
            c(obj, 0, wi0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<yi0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<yi0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        yi0 next = it.next();
                        ArrayList<yi0> arrayList2 = this.a.get(next.b);
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

    public final <T extends ti0> void f(yi0 yi0Var, wi0<T> wi0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, yi0Var, wi0Var, t) == null) {
            int i = yi0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            ni0.b().a(yi0Var, wi0Var, t);
                            return;
                        }
                        return;
                    }
                    oi0.b().a(yi0Var, wi0Var, t);
                    return;
                }
                xi0.b().a(yi0Var, wi0Var, t);
                return;
            }
            wi0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
