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
public final class wn3 implements tn3, vn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<un3<?>, Set<b>> l;

    /* loaded from: classes8.dex */
    public interface b extends sq3<Set<un3<?>>> {
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(wn3 wn3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn3Var, set, set2};
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
        public static final wn3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-312234770, "Lcom/baidu/tieba/wn3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-312234770, "Lcom/baidu/tieba/wn3$c;");
                    return;
                }
            }
            a = new wn3();
        }
    }

    public wn3() {
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

    public static wn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (wn3) invokeV.objValue;
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

    public wn3 e(un3<?>... un3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, un3VarArr)) == null) {
            c(Sets.newHashSet(un3VarArr));
            return this;
        }
        return (wn3) invokeL.objValue;
    }

    public wn3 f(sn3 sn3Var) {
        InterceptResult invokeL;
        String sn3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sn3Var)) == null) {
            if (sn3Var == null) {
                sn3Var2 = "";
            } else {
                sn3Var2 = sn3Var.toString();
            }
            if (tn3.a) {
                Log.i("Tracer-ErrCode", sn3Var2);
            }
            z82.c("Tracer-ErrCode", sn3Var2);
            return this;
        }
        return (wn3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull un3<?> un3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, un3Var)) == null) {
            Set<b> set = this.l.get(un3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(un3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public wn3 c(Set<un3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (un3<?> un3Var : set) {
                    hashSet.addAll(i(un3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (wn3) invokeL.objValue;
    }

    public wn3 h(un3<?>... un3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, un3VarArr)) == null) {
            synchronized (this.l) {
                for (un3<?> un3Var : un3VarArr) {
                    if (!this.l.containsKey(un3Var)) {
                        this.l.put(un3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (wn3) invokeL.objValue;
    }

    public final wn3 d(Set<b> set, Set<un3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            r53.j().i(new a(this, set, set2));
            return this;
        }
        return (wn3) invokeLL.objValue;
    }

    public wn3 g(b bVar, un3<?>... un3VarArr) {
        InterceptResult invokeLL;
        Set<un3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, un3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(un3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(un3VarArr);
                    }
                    for (un3<?> un3Var : newHashSet) {
                        if (un3Var != null) {
                            i(un3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (wn3) invokeLL.objValue;
    }

    public wn3 j(b bVar, un3<?>... un3VarArr) {
        InterceptResult invokeLL;
        Set<un3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, un3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(un3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(un3VarArr);
                    }
                    for (un3<?> un3Var : newHashSet) {
                        if (un3Var != null) {
                            i(un3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (wn3) invokeLL.objValue;
    }
}
