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
public final class ve3 implements se3, ue3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<te3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(ve3 ve3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, set, set2};
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
    public interface b extends rh3<Set<te3<?>>> {
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final ve3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-349175610, "Lcom/baidu/tieba/ve3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-349175610, "Lcom/baidu/tieba/ve3$c;");
                    return;
                }
            }
            a = new ve3();
        }
    }

    public ve3() {
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

    public static ve3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (ve3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public ve3 c(Set<te3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (te3<?> te3Var : set) {
                    hashSet.addAll(i(te3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (ve3) invokeL.objValue;
    }

    public final ve3 d(Set<b> set, Set<te3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            qw2.j().i(new a(this, set, set2));
            return this;
        }
        return (ve3) invokeLL.objValue;
    }

    public ve3 e(te3<?>... te3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, te3VarArr)) == null) {
            c(Sets.newHashSet(te3VarArr));
            return this;
        }
        return (ve3) invokeL.objValue;
    }

    public ve3 f(re3 re3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, re3Var)) == null) {
            String re3Var2 = re3Var == null ? "" : re3Var.toString();
            if (se3.a) {
                Log.i("Tracer-ErrCode", re3Var2);
            }
            yz1.c("Tracer-ErrCode", re3Var2);
            return this;
        }
        return (ve3) invokeL.objValue;
    }

    public ve3 g(b bVar, te3<?>... te3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, te3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<te3<?>> keySet = b(te3VarArr) ? this.l.keySet() : Sets.newHashSet(te3VarArr);
                    for (te3<?> te3Var : keySet) {
                        if (te3Var != null) {
                            i(te3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (ve3) invokeLL.objValue;
    }

    public ve3 h(te3<?>... te3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, te3VarArr)) == null) {
            synchronized (this.l) {
                for (te3<?> te3Var : te3VarArr) {
                    if (!this.l.containsKey(te3Var)) {
                        this.l.put(te3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (ve3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull te3<?> te3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, te3Var)) == null) {
            Set<b> set = this.l.get(te3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(te3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public ve3 j(b bVar, te3<?>... te3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, te3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (te3<?> te3Var : b(te3VarArr) ? this.l.keySet() : Sets.newHashSet(te3VarArr)) {
                        if (te3Var != null) {
                            i(te3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (ve3) invokeLL.objValue;
    }
}
