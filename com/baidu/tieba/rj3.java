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
public final class rj3 implements oj3, qj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<pj3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public interface b extends nm3<Set<pj3<?>>> {
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(rj3 rj3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj3Var, set, set2};
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
        public static final rj3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-459074609, "Lcom/baidu/tieba/rj3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-459074609, "Lcom/baidu/tieba/rj3$c;");
                    return;
                }
            }
            a = new rj3();
        }
    }

    public rj3() {
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

    public static rj3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (rj3) invokeV.objValue;
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

    public rj3 e(pj3<?>... pj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pj3VarArr)) == null) {
            c(Sets.newHashSet(pj3VarArr));
            return this;
        }
        return (rj3) invokeL.objValue;
    }

    public rj3 f(nj3 nj3Var) {
        InterceptResult invokeL;
        String nj3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nj3Var)) == null) {
            if (nj3Var == null) {
                nj3Var2 = "";
            } else {
                nj3Var2 = nj3Var.toString();
            }
            if (oj3.a) {
                Log.i("Tracer-ErrCode", nj3Var2);
            }
            u42.c("Tracer-ErrCode", nj3Var2);
            return this;
        }
        return (rj3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull pj3<?> pj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pj3Var)) == null) {
            Set<b> set = this.l.get(pj3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(pj3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public rj3 c(Set<pj3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (pj3<?> pj3Var : set) {
                    hashSet.addAll(i(pj3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (rj3) invokeL.objValue;
    }

    public rj3 h(pj3<?>... pj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pj3VarArr)) == null) {
            synchronized (this.l) {
                for (pj3<?> pj3Var : pj3VarArr) {
                    if (!this.l.containsKey(pj3Var)) {
                        this.l.put(pj3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (rj3) invokeL.objValue;
    }

    public final rj3 d(Set<b> set, Set<pj3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            m13.j().i(new a(this, set, set2));
            return this;
        }
        return (rj3) invokeLL.objValue;
    }

    public rj3 g(b bVar, pj3<?>... pj3VarArr) {
        InterceptResult invokeLL;
        Set<pj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, pj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(pj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(pj3VarArr);
                    }
                    for (pj3<?> pj3Var : newHashSet) {
                        if (pj3Var != null) {
                            i(pj3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (rj3) invokeLL.objValue;
    }

    public rj3 j(b bVar, pj3<?>... pj3VarArr) {
        InterceptResult invokeLL;
        Set<pj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, pj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(pj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(pj3VarArr);
                    }
                    for (pj3<?> pj3Var : newHashSet) {
                        if (pj3Var != null) {
                            i(pj3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (rj3) invokeLL.objValue;
    }
}
