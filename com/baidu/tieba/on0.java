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
public class on0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<wn0>> a;
    public final ConcurrentHashMap<Object, ArrayList<wn0>> b;

    public on0() {
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

    public final void a(@NonNull wn0 wn0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wn0Var) == null) {
            synchronized (this) {
                ArrayList<wn0> arrayList = this.a.get(wn0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(wn0Var.b, arrayList);
                } else {
                    Iterator<wn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == wn0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(wn0Var);
                }
                ArrayList<wn0> arrayList2 = this.b.get(wn0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(wn0Var.a, arrayList2);
                } else {
                    Iterator<wn0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == wn0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(wn0Var);
                }
            }
        }
    }

    public <T extends rn0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<wn0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<wn0> it = arrayList.iterator();
                while (it.hasNext()) {
                    wn0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends rn0> void c(@NonNull Object obj, int i, @NonNull un0<T> un0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, un0Var) == null) {
            a(new wn0(i, obj, un0Var.a(), un0Var));
        }
    }

    public <T extends rn0> void d(@NonNull Object obj, @NonNull un0<T> un0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, un0Var) == null) {
            c(obj, 0, un0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<wn0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<wn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        wn0 next = it.next();
                        ArrayList<wn0> arrayList2 = this.a.get(next.b);
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

    public final <T extends rn0> void f(wn0 wn0Var, un0<T> un0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, wn0Var, un0Var, t) == null) {
            int i = wn0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            mn0.b().a(wn0Var, un0Var, t);
                            return;
                        }
                        return;
                    }
                    nn0.b().a(wn0Var, un0Var, t);
                    return;
                }
                vn0.b().a(wn0Var, un0Var, t);
                return;
            }
            un0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
