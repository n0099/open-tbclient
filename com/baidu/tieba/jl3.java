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
/* loaded from: classes5.dex */
public final class jl3 implements gl3, il3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<hl3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public interface b extends fo3<Set<hl3<?>>> {
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(jl3 jl3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl3Var, set, set2};
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

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final jl3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-686260775, "Lcom/baidu/tieba/jl3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-686260775, "Lcom/baidu/tieba/jl3$c;");
                    return;
                }
            }
            a = new jl3();
        }
    }

    public jl3() {
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

    public static jl3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (jl3) invokeV.objValue;
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

    public jl3 e(hl3<?>... hl3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hl3VarArr)) == null) {
            c(Sets.newHashSet(hl3VarArr));
            return this;
        }
        return (jl3) invokeL.objValue;
    }

    public jl3 f(fl3 fl3Var) {
        InterceptResult invokeL;
        String fl3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fl3Var)) == null) {
            if (fl3Var == null) {
                fl3Var2 = "";
            } else {
                fl3Var2 = fl3Var.toString();
            }
            if (gl3.a) {
                Log.i("Tracer-ErrCode", fl3Var2);
            }
            m62.c("Tracer-ErrCode", fl3Var2);
            return this;
        }
        return (jl3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull hl3<?> hl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hl3Var)) == null) {
            Set<b> set = this.l.get(hl3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(hl3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public jl3 c(Set<hl3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (hl3<?> hl3Var : set) {
                    hashSet.addAll(i(hl3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (jl3) invokeL.objValue;
    }

    public jl3 h(hl3<?>... hl3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hl3VarArr)) == null) {
            synchronized (this.l) {
                for (hl3<?> hl3Var : hl3VarArr) {
                    if (!this.l.containsKey(hl3Var)) {
                        this.l.put(hl3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (jl3) invokeL.objValue;
    }

    public final jl3 d(Set<b> set, Set<hl3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            e33.j().i(new a(this, set, set2));
            return this;
        }
        return (jl3) invokeLL.objValue;
    }

    public jl3 g(b bVar, hl3<?>... hl3VarArr) {
        InterceptResult invokeLL;
        Set<hl3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, hl3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(hl3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(hl3VarArr);
                    }
                    for (hl3<?> hl3Var : newHashSet) {
                        if (hl3Var != null) {
                            i(hl3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (jl3) invokeLL.objValue;
    }

    public jl3 j(b bVar, hl3<?>... hl3VarArr) {
        InterceptResult invokeLL;
        Set<hl3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, hl3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(hl3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(hl3VarArr);
                    }
                    for (hl3<?> hl3Var : newHashSet) {
                        if (hl3Var != null) {
                            i(hl3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (jl3) invokeLL.objValue;
    }
}
