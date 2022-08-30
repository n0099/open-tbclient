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
public final class xc3 implements uc3, wc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<vc3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(xc3 xc3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc3Var, set, set2};
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
    public interface b extends tf3<Set<vc3<?>>> {
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final xc3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-293764350, "Lcom/baidu/tieba/xc3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-293764350, "Lcom/baidu/tieba/xc3$c;");
                    return;
                }
            }
            a = new xc3();
        }
    }

    public xc3() {
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

    public static xc3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (xc3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public xc3 c(Set<vc3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (vc3<?> vc3Var : set) {
                    hashSet.addAll(i(vc3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (xc3) invokeL.objValue;
    }

    public final xc3 d(Set<b> set, Set<vc3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            su2.j().i(new a(this, set, set2));
            return this;
        }
        return (xc3) invokeLL.objValue;
    }

    public xc3 e(vc3<?>... vc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vc3VarArr)) == null) {
            c(Sets.newHashSet(vc3VarArr));
            return this;
        }
        return (xc3) invokeL.objValue;
    }

    public xc3 f(tc3 tc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tc3Var)) == null) {
            String tc3Var2 = tc3Var == null ? "" : tc3Var.toString();
            if (uc3.a) {
                Log.i("Tracer-ErrCode", tc3Var2);
            }
            ay1.c("Tracer-ErrCode", tc3Var2);
            return this;
        }
        return (xc3) invokeL.objValue;
    }

    public xc3 g(b bVar, vc3<?>... vc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, vc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<vc3<?>> keySet = b(vc3VarArr) ? this.l.keySet() : Sets.newHashSet(vc3VarArr);
                    for (vc3<?> vc3Var : keySet) {
                        if (vc3Var != null) {
                            i(vc3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (xc3) invokeLL.objValue;
    }

    public xc3 h(vc3<?>... vc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vc3VarArr)) == null) {
            synchronized (this.l) {
                for (vc3<?> vc3Var : vc3VarArr) {
                    if (!this.l.containsKey(vc3Var)) {
                        this.l.put(vc3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (xc3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull vc3<?> vc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, vc3Var)) == null) {
            Set<b> set = this.l.get(vc3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(vc3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public xc3 j(b bVar, vc3<?>... vc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, vc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (vc3<?> vc3Var : b(vc3VarArr) ? this.l.keySet() : Sets.newHashSet(vc3VarArr)) {
                        if (vc3Var != null) {
                            i(vc3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (xc3) invokeLL.objValue;
    }
}
