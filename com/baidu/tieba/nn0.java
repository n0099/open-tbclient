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
public class nn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<vn0>> a;
    public final ConcurrentHashMap<Object, ArrayList<vn0>> b;

    public nn0() {
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

    public final void a(@NonNull vn0 vn0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vn0Var) == null) {
            synchronized (this) {
                ArrayList<vn0> arrayList = this.a.get(vn0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(vn0Var.b, arrayList);
                } else {
                    Iterator<vn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == vn0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(vn0Var);
                }
                ArrayList<vn0> arrayList2 = this.b.get(vn0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(vn0Var.a, arrayList2);
                } else {
                    Iterator<vn0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == vn0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(vn0Var);
                }
            }
        }
    }

    public <T extends qn0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<vn0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<vn0> it = arrayList.iterator();
                while (it.hasNext()) {
                    vn0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends qn0> void c(@NonNull Object obj, int i, @NonNull tn0<T> tn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, tn0Var) == null) {
            a(new vn0(i, obj, tn0Var.a(), tn0Var));
        }
    }

    public <T extends qn0> void d(@NonNull Object obj, @NonNull tn0<T> tn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, tn0Var) == null) {
            c(obj, 0, tn0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<vn0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<vn0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        vn0 next = it.next();
                        ArrayList<vn0> arrayList2 = this.a.get(next.b);
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

    public final <T extends qn0> void f(vn0 vn0Var, tn0<T> tn0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, vn0Var, tn0Var, t) == null) {
            int i = vn0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            ln0.b().a(vn0Var, tn0Var, t);
                            return;
                        }
                        return;
                    }
                    mn0.b().a(vn0Var, tn0Var, t);
                    return;
                }
                un0.b().a(vn0Var, tn0Var, t);
                return;
            }
            tn0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
