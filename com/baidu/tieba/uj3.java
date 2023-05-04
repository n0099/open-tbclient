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
/* loaded from: classes6.dex */
public final class uj3 implements rj3, tj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<sj3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public interface b extends qm3<Set<sj3<?>>> {
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(uj3 uj3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj3Var, set, set2};
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

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final uj3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-373187156, "Lcom/baidu/tieba/uj3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-373187156, "Lcom/baidu/tieba/uj3$c;");
                    return;
                }
            }
            a = new uj3();
        }
    }

    public uj3() {
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

    public static uj3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (uj3) invokeV.objValue;
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

    public uj3 e(sj3<?>... sj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sj3VarArr)) == null) {
            c(Sets.newHashSet(sj3VarArr));
            return this;
        }
        return (uj3) invokeL.objValue;
    }

    public uj3 f(qj3 qj3Var) {
        InterceptResult invokeL;
        String qj3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, qj3Var)) == null) {
            if (qj3Var == null) {
                qj3Var2 = "";
            } else {
                qj3Var2 = qj3Var.toString();
            }
            if (rj3.a) {
                Log.i("Tracer-ErrCode", qj3Var2);
            }
            x42.c("Tracer-ErrCode", qj3Var2);
            return this;
        }
        return (uj3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull sj3<?> sj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sj3Var)) == null) {
            Set<b> set = this.l.get(sj3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(sj3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public uj3 c(Set<sj3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (sj3<?> sj3Var : set) {
                    hashSet.addAll(i(sj3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (uj3) invokeL.objValue;
    }

    public uj3 h(sj3<?>... sj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sj3VarArr)) == null) {
            synchronized (this.l) {
                for (sj3<?> sj3Var : sj3VarArr) {
                    if (!this.l.containsKey(sj3Var)) {
                        this.l.put(sj3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (uj3) invokeL.objValue;
    }

    public final uj3 d(Set<b> set, Set<sj3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            p13.j().i(new a(this, set, set2));
            return this;
        }
        return (uj3) invokeLL.objValue;
    }

    public uj3 g(b bVar, sj3<?>... sj3VarArr) {
        InterceptResult invokeLL;
        Set<sj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, sj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(sj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(sj3VarArr);
                    }
                    for (sj3<?> sj3Var : newHashSet) {
                        if (sj3Var != null) {
                            i(sj3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (uj3) invokeLL.objValue;
    }

    public uj3 j(b bVar, sj3<?>... sj3VarArr) {
        InterceptResult invokeLL;
        Set<sj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, sj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(sj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(sj3VarArr);
                    }
                    for (sj3<?> sj3Var : newHashSet) {
                        if (sj3Var != null) {
                            i(sj3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (uj3) invokeLL.objValue;
    }
}
