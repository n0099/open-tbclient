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
public class ml0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<ul0>> a;
    public final ConcurrentHashMap<Object, ArrayList<ul0>> b;

    public ml0() {
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

    public final void a(@NonNull ul0 ul0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ul0Var) == null) {
            synchronized (this) {
                ArrayList<ul0> arrayList = this.a.get(ul0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(ul0Var.b, arrayList);
                } else {
                    Iterator<ul0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == ul0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(ul0Var);
                }
                ArrayList<ul0> arrayList2 = this.b.get(ul0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(ul0Var.a, arrayList2);
                } else {
                    Iterator<ul0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == ul0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(ul0Var);
                }
            }
        }
    }

    public <T extends pl0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) != null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<ul0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<ul0> it = arrayList.iterator();
                while (it.hasNext()) {
                    ul0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends pl0> void c(@NonNull Object obj, int i, @NonNull sl0<T> sl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, sl0Var) == null) {
            a(new ul0(i, obj, sl0Var.a(), sl0Var));
        }
    }

    public <T extends pl0> void d(@NonNull Object obj, @NonNull sl0<T> sl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, sl0Var) == null) {
            c(obj, 0, sl0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<ul0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<ul0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ul0 next = it.next();
                        ArrayList<ul0> arrayList2 = this.a.get(next.b);
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

    public final <T extends pl0> void f(ul0 ul0Var, sl0<T> sl0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, ul0Var, sl0Var, t) == null) {
            int i = ul0Var.c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            kl0.b().a(ul0Var, sl0Var, t);
                            return;
                        }
                        return;
                    }
                    ll0.b().a(ul0Var, sl0Var, t);
                    return;
                }
                tl0.b().a(ul0Var, sl0Var, t);
                return;
            }
            sl0Var.onEvent(t);
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
