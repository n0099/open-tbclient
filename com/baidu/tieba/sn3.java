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
/* loaded from: classes7.dex */
public final class sn3 implements pn3, rn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<qn3<?>, Set<b>> l;

    /* loaded from: classes7.dex */
    public interface b extends oq3<Set<qn3<?>>> {
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(sn3 sn3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn3Var, set, set2};
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

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final sn3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-426751374, "Lcom/baidu/tieba/sn3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-426751374, "Lcom/baidu/tieba/sn3$c;");
                    return;
                }
            }
            a = new sn3();
        }
    }

    public sn3() {
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

    public static sn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (sn3) invokeV.objValue;
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

    public sn3 e(qn3<?>... qn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qn3VarArr)) == null) {
            c(Sets.newHashSet(qn3VarArr));
            return this;
        }
        return (sn3) invokeL.objValue;
    }

    public sn3 f(on3 on3Var) {
        InterceptResult invokeL;
        String on3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, on3Var)) == null) {
            if (on3Var == null) {
                on3Var2 = "";
            } else {
                on3Var2 = on3Var.toString();
            }
            if (pn3.a) {
                Log.i("Tracer-ErrCode", on3Var2);
            }
            v82.c("Tracer-ErrCode", on3Var2);
            return this;
        }
        return (sn3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull qn3<?> qn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qn3Var)) == null) {
            Set<b> set = this.l.get(qn3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(qn3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public sn3 c(Set<qn3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (qn3<?> qn3Var : set) {
                    hashSet.addAll(i(qn3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (sn3) invokeL.objValue;
    }

    public sn3 h(qn3<?>... qn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qn3VarArr)) == null) {
            synchronized (this.l) {
                for (qn3<?> qn3Var : qn3VarArr) {
                    if (!this.l.containsKey(qn3Var)) {
                        this.l.put(qn3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (sn3) invokeL.objValue;
    }

    public final sn3 d(Set<b> set, Set<qn3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            n53.j().i(new a(this, set, set2));
            return this;
        }
        return (sn3) invokeLL.objValue;
    }

    public sn3 g(b bVar, qn3<?>... qn3VarArr) {
        InterceptResult invokeLL;
        Set<qn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, qn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(qn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(qn3VarArr);
                    }
                    for (qn3<?> qn3Var : newHashSet) {
                        if (qn3Var != null) {
                            i(qn3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (sn3) invokeLL.objValue;
    }

    public sn3 j(b bVar, qn3<?>... qn3VarArr) {
        InterceptResult invokeLL;
        Set<qn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, qn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(qn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(qn3VarArr);
                    }
                    for (qn3<?> qn3Var : newHashSet) {
                        if (qn3Var != null) {
                            i(qn3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (sn3) invokeLL.objValue;
    }
}
