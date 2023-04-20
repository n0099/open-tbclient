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
public final class sj3 implements pj3, rj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<qj3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public interface b extends om3<Set<qj3<?>>> {
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(sj3 sj3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj3Var, set, set2};
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
        public static final sj3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-430445458, "Lcom/baidu/tieba/sj3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-430445458, "Lcom/baidu/tieba/sj3$c;");
                    return;
                }
            }
            a = new sj3();
        }
    }

    public sj3() {
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

    public static sj3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (sj3) invokeV.objValue;
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

    public sj3 e(qj3<?>... qj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qj3VarArr)) == null) {
            c(Sets.newHashSet(qj3VarArr));
            return this;
        }
        return (sj3) invokeL.objValue;
    }

    public sj3 f(oj3 oj3Var) {
        InterceptResult invokeL;
        String oj3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, oj3Var)) == null) {
            if (oj3Var == null) {
                oj3Var2 = "";
            } else {
                oj3Var2 = oj3Var.toString();
            }
            if (pj3.a) {
                Log.i("Tracer-ErrCode", oj3Var2);
            }
            v42.c("Tracer-ErrCode", oj3Var2);
            return this;
        }
        return (sj3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull qj3<?> qj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qj3Var)) == null) {
            Set<b> set = this.l.get(qj3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(qj3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public sj3 c(Set<qj3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (qj3<?> qj3Var : set) {
                    hashSet.addAll(i(qj3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (sj3) invokeL.objValue;
    }

    public sj3 h(qj3<?>... qj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qj3VarArr)) == null) {
            synchronized (this.l) {
                for (qj3<?> qj3Var : qj3VarArr) {
                    if (!this.l.containsKey(qj3Var)) {
                        this.l.put(qj3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (sj3) invokeL.objValue;
    }

    public final sj3 d(Set<b> set, Set<qj3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            n13.j().i(new a(this, set, set2));
            return this;
        }
        return (sj3) invokeLL.objValue;
    }

    public sj3 g(b bVar, qj3<?>... qj3VarArr) {
        InterceptResult invokeLL;
        Set<qj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, qj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(qj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(qj3VarArr);
                    }
                    for (qj3<?> qj3Var : newHashSet) {
                        if (qj3Var != null) {
                            i(qj3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (sj3) invokeLL.objValue;
    }

    public sj3 j(b bVar, qj3<?>... qj3VarArr) {
        InterceptResult invokeLL;
        Set<qj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, qj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(qj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(qj3VarArr);
                    }
                    for (qj3<?> qj3Var : newHashSet) {
                        if (qj3Var != null) {
                            i(qj3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (sj3) invokeLL.objValue;
    }
}
