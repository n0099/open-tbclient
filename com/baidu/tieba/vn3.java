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
public final class vn3 implements sn3, un3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<tn3<?>, Set<b>> l;

    /* loaded from: classes8.dex */
    public interface b extends rq3<Set<tn3<?>>> {
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(vn3 vn3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn3Var, set, set2};
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
        public static final vn3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-340863921, "Lcom/baidu/tieba/vn3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-340863921, "Lcom/baidu/tieba/vn3$c;");
                    return;
                }
            }
            a = new vn3();
        }
    }

    public vn3() {
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

    public static vn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (vn3) invokeV.objValue;
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

    public vn3 e(tn3<?>... tn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tn3VarArr)) == null) {
            c(Sets.newHashSet(tn3VarArr));
            return this;
        }
        return (vn3) invokeL.objValue;
    }

    public vn3 f(rn3 rn3Var) {
        InterceptResult invokeL;
        String rn3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rn3Var)) == null) {
            if (rn3Var == null) {
                rn3Var2 = "";
            } else {
                rn3Var2 = rn3Var.toString();
            }
            if (sn3.a) {
                Log.i("Tracer-ErrCode", rn3Var2);
            }
            y82.c("Tracer-ErrCode", rn3Var2);
            return this;
        }
        return (vn3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull tn3<?> tn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tn3Var)) == null) {
            Set<b> set = this.l.get(tn3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(tn3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public vn3 c(Set<tn3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (tn3<?> tn3Var : set) {
                    hashSet.addAll(i(tn3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (vn3) invokeL.objValue;
    }

    public vn3 h(tn3<?>... tn3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tn3VarArr)) == null) {
            synchronized (this.l) {
                for (tn3<?> tn3Var : tn3VarArr) {
                    if (!this.l.containsKey(tn3Var)) {
                        this.l.put(tn3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (vn3) invokeL.objValue;
    }

    public final vn3 d(Set<b> set, Set<tn3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            q53.j().i(new a(this, set, set2));
            return this;
        }
        return (vn3) invokeLL.objValue;
    }

    public vn3 g(b bVar, tn3<?>... tn3VarArr) {
        InterceptResult invokeLL;
        Set<tn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, tn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(tn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(tn3VarArr);
                    }
                    for (tn3<?> tn3Var : newHashSet) {
                        if (tn3Var != null) {
                            i(tn3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (vn3) invokeLL.objValue;
    }

    public vn3 j(b bVar, tn3<?>... tn3VarArr) {
        InterceptResult invokeLL;
        Set<tn3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, tn3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(tn3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(tn3VarArr);
                    }
                    for (tn3<?> tn3Var : newHashSet) {
                        if (tn3Var != null) {
                            i(tn3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (vn3) invokeLL.objValue;
    }
}
