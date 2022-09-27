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
public class zl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<hm0>> a;
    public final ConcurrentHashMap<Object, ArrayList<hm0>> b;

    public zl0() {
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

    public final void a(@NonNull hm0 hm0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hm0Var) == null) {
            synchronized (this) {
                ArrayList<hm0> arrayList = this.a.get(hm0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(hm0Var.b, arrayList);
                } else {
                    Iterator<hm0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == hm0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(hm0Var);
                }
                ArrayList<hm0> arrayList2 = this.b.get(hm0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(hm0Var.a, arrayList2);
                } else {
                    Iterator<hm0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == hm0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(hm0Var);
                }
            }
        }
    }

    public <T extends cm0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<hm0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<hm0> it = arrayList.iterator();
                while (it.hasNext()) {
                    hm0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends cm0> void c(@NonNull Object obj, int i, @NonNull fm0<T> fm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, fm0Var) == null) {
            a(new hm0(i, obj, fm0Var.a(), fm0Var));
        }
    }

    public <T extends cm0> void d(@NonNull Object obj, @NonNull fm0<T> fm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, fm0Var) == null) {
            c(obj, 0, fm0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<hm0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<hm0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        hm0 next = it.next();
                        ArrayList<hm0> arrayList2 = this.a.get(next.b);
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

    public final <T extends cm0> void f(hm0 hm0Var, fm0<T> fm0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, hm0Var, fm0Var, t) == null) {
            int i = hm0Var.c;
            if (i == 0) {
                fm0Var.onEvent(t);
            } else if (i == 1) {
                gm0.b().a(hm0Var, fm0Var, t);
            } else if (i == 2) {
                yl0.b().a(hm0Var, fm0Var, t);
            } else if (i != 3) {
            } else {
                xl0.b().a(hm0Var, fm0Var, t);
            }
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
