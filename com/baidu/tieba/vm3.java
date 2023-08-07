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
public final class vm3 implements sm3, um3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<tm3<?>, Set<b>> l;

    /* loaded from: classes8.dex */
    public interface b extends rp3<Set<tm3<?>>> {
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(vm3 vm3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm3Var, set, set2};
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
        public static final vm3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-341787442, "Lcom/baidu/tieba/vm3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-341787442, "Lcom/baidu/tieba/vm3$c;");
                    return;
                }
            }
            a = new vm3();
        }
    }

    public vm3() {
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

    public static vm3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (vm3) invokeV.objValue;
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

    public vm3 e(tm3<?>... tm3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tm3VarArr)) == null) {
            c(Sets.newHashSet(tm3VarArr));
            return this;
        }
        return (vm3) invokeL.objValue;
    }

    public vm3 f(rm3 rm3Var) {
        InterceptResult invokeL;
        String rm3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rm3Var)) == null) {
            if (rm3Var == null) {
                rm3Var2 = "";
            } else {
                rm3Var2 = rm3Var.toString();
            }
            if (sm3.a) {
                Log.i("Tracer-ErrCode", rm3Var2);
            }
            y72.c("Tracer-ErrCode", rm3Var2);
            return this;
        }
        return (vm3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull tm3<?> tm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tm3Var)) == null) {
            Set<b> set = this.l.get(tm3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(tm3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public vm3 c(Set<tm3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (tm3<?> tm3Var : set) {
                    hashSet.addAll(i(tm3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (vm3) invokeL.objValue;
    }

    public vm3 h(tm3<?>... tm3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tm3VarArr)) == null) {
            synchronized (this.l) {
                for (tm3<?> tm3Var : tm3VarArr) {
                    if (!this.l.containsKey(tm3Var)) {
                        this.l.put(tm3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (vm3) invokeL.objValue;
    }

    public final vm3 d(Set<b> set, Set<tm3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            q43.j().i(new a(this, set, set2));
            return this;
        }
        return (vm3) invokeLL.objValue;
    }

    public vm3 g(b bVar, tm3<?>... tm3VarArr) {
        InterceptResult invokeLL;
        Set<tm3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, tm3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(tm3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(tm3VarArr);
                    }
                    for (tm3<?> tm3Var : newHashSet) {
                        if (tm3Var != null) {
                            i(tm3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (vm3) invokeLL.objValue;
    }

    public vm3 j(b bVar, tm3<?>... tm3VarArr) {
        InterceptResult invokeLL;
        Set<tm3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, tm3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(tm3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(tm3VarArr);
                    }
                    for (tm3<?> tm3Var : newHashSet) {
                        if (tm3Var != null) {
                            i(tm3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (vm3) invokeLL.objValue;
    }
}
