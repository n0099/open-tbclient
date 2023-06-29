package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public final class zn3 implements wn3, yn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<xn3<?>, Set<b>> l;

    /* loaded from: classes8.dex */
    public interface b extends vq3<Set<xn3<?>>> {
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(zn3 zn3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn3Var, set, set2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.b = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b bVar : this.a) {
                    bVar.a(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final zn3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-226347317, "Lcom/baidu/tieba/zn3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-226347317, "Lcom/baidu/tieba/zn3$c;");
                    return;
                }
            }
            a = new zn3();
        }
    }

    public zn3() {
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
        this.l = new HashMap();
    }

    public static zn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (zn3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) {
            if (tArr == null || tArr.length < 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public zn3 e(xn3<?>... xn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xn3VarArr)) == null) {
            c(Sets.newHashSet(xn3VarArr));
            return this;
        }
        return (zn3) invokeL.objValue;
    }

    public zn3 f(vn3 vn3Var) {
        InterceptResult invokeL;
        String vn3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vn3Var)) == null) {
            if (vn3Var == null) {
                vn3Var2 = "";
            } else {
                vn3Var2 = vn3Var.toString();
            }
            if (wn3.a) {
                Log.i("Tracer-ErrCode", vn3Var2);
            }
            c92.c("Tracer-ErrCode", vn3Var2);
            return this;
        }
        return (zn3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull xn3<?> xn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xn3Var)) == null) {
            Set<b> set = this.l.get(xn3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(xn3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public zn3 c(Set<xn3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (xn3<?> xn3Var : set) {
                    hashSet.addAll(i(xn3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (zn3) invokeL.objValue;
    }

    public zn3 h(xn3<?>... xn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xn3VarArr)) == null) {
            synchronized (this.l) {
                for (xn3<?> xn3Var : xn3VarArr) {
                    if (!this.l.containsKey(xn3Var)) {
                        this.l.put(xn3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (zn3) invokeL.objValue;
    }

    public final zn3 d(Set<b> set, Set<xn3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            u53.j().i(new a(this, set, set2));
            return this;
        }
        return (zn3) invokeLL.objValue;
    }

    public zn3 g(b bVar, xn3<?>... xn3VarArr) {
        InterceptResult invokeLL;
        Set<xn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, xn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(xn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(xn3VarArr);
                    }
                    for (xn3<?> xn3Var : newHashSet) {
                        if (xn3Var != null) {
                            i(xn3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (zn3) invokeLL.objValue;
    }

    public zn3 j(b bVar, xn3<?>... xn3VarArr) {
        InterceptResult invokeLL;
        Set<xn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, xn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(xn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(xn3VarArr);
                    }
                    for (xn3<?> xn3Var : newHashSet) {
                        if (xn3Var != null) {
                            i(xn3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (zn3) invokeLL.objValue;
    }
}
