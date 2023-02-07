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
public final class tk3 implements qk3, sk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<rk3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public interface b extends pn3<Set<rk3<?>>> {
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(tk3 tk3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tk3Var, set, set2};
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
        public static final tk3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400892786, "Lcom/baidu/tieba/tk3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400892786, "Lcom/baidu/tieba/tk3$c;");
                    return;
                }
            }
            a = new tk3();
        }
    }

    public tk3() {
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

    public static tk3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (tk3) invokeV.objValue;
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

    public tk3 e(rk3<?>... rk3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rk3VarArr)) == null) {
            c(Sets.newHashSet(rk3VarArr));
            return this;
        }
        return (tk3) invokeL.objValue;
    }

    public tk3 f(pk3 pk3Var) {
        InterceptResult invokeL;
        String pk3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pk3Var)) == null) {
            if (pk3Var == null) {
                pk3Var2 = "";
            } else {
                pk3Var2 = pk3Var.toString();
            }
            if (qk3.a) {
                Log.i("Tracer-ErrCode", pk3Var2);
            }
            w52.c("Tracer-ErrCode", pk3Var2);
            return this;
        }
        return (tk3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull rk3<?> rk3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rk3Var)) == null) {
            Set<b> set = this.l.get(rk3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(rk3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public tk3 c(Set<rk3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (rk3<?> rk3Var : set) {
                    hashSet.addAll(i(rk3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (tk3) invokeL.objValue;
    }

    public tk3 h(rk3<?>... rk3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rk3VarArr)) == null) {
            synchronized (this.l) {
                for (rk3<?> rk3Var : rk3VarArr) {
                    if (!this.l.containsKey(rk3Var)) {
                        this.l.put(rk3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (tk3) invokeL.objValue;
    }

    public final tk3 d(Set<b> set, Set<rk3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            o23.j().i(new a(this, set, set2));
            return this;
        }
        return (tk3) invokeLL.objValue;
    }

    public tk3 g(b bVar, rk3<?>... rk3VarArr) {
        InterceptResult invokeLL;
        Set<rk3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, rk3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(rk3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(rk3VarArr);
                    }
                    for (rk3<?> rk3Var : newHashSet) {
                        if (rk3Var != null) {
                            i(rk3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (tk3) invokeLL.objValue;
    }

    public tk3 j(b bVar, rk3<?>... rk3VarArr) {
        InterceptResult invokeLL;
        Set<rk3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, rk3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(rk3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(rk3VarArr);
                    }
                    for (rk3<?> rk3Var : newHashSet) {
                        if (rk3Var != null) {
                            i(rk3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (tk3) invokeLL.objValue;
    }
}
