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
public final class qj3 implements nj3, pj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<oj3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public interface b extends mm3<Set<oj3<?>>> {
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(qj3 qj3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj3Var, set, set2};
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
        public static final qj3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-487703760, "Lcom/baidu/tieba/qj3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-487703760, "Lcom/baidu/tieba/qj3$c;");
                    return;
                }
            }
            a = new qj3();
        }
    }

    public qj3() {
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

    public static qj3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (qj3) invokeV.objValue;
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

    public qj3 e(oj3<?>... oj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, oj3VarArr)) == null) {
            c(Sets.newHashSet(oj3VarArr));
            return this;
        }
        return (qj3) invokeL.objValue;
    }

    public qj3 f(mj3 mj3Var) {
        InterceptResult invokeL;
        String mj3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mj3Var)) == null) {
            if (mj3Var == null) {
                mj3Var2 = "";
            } else {
                mj3Var2 = mj3Var.toString();
            }
            if (nj3.a) {
                Log.i("Tracer-ErrCode", mj3Var2);
            }
            t42.c("Tracer-ErrCode", mj3Var2);
            return this;
        }
        return (qj3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull oj3<?> oj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oj3Var)) == null) {
            Set<b> set = this.l.get(oj3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(oj3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public qj3 c(Set<oj3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (oj3<?> oj3Var : set) {
                    hashSet.addAll(i(oj3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (qj3) invokeL.objValue;
    }

    public qj3 h(oj3<?>... oj3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, oj3VarArr)) == null) {
            synchronized (this.l) {
                for (oj3<?> oj3Var : oj3VarArr) {
                    if (!this.l.containsKey(oj3Var)) {
                        this.l.put(oj3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (qj3) invokeL.objValue;
    }

    public final qj3 d(Set<b> set, Set<oj3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            l13.j().i(new a(this, set, set2));
            return this;
        }
        return (qj3) invokeLL.objValue;
    }

    public qj3 g(b bVar, oj3<?>... oj3VarArr) {
        InterceptResult invokeLL;
        Set<oj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, oj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(oj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(oj3VarArr);
                    }
                    for (oj3<?> oj3Var : newHashSet) {
                        if (oj3Var != null) {
                            i(oj3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (qj3) invokeLL.objValue;
    }

    public qj3 j(b bVar, oj3<?>... oj3VarArr) {
        InterceptResult invokeLL;
        Set<oj3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, oj3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(oj3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(oj3VarArr);
                    }
                    for (oj3<?> oj3Var : newHashSet) {
                        if (oj3Var != null) {
                            i(oj3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (qj3) invokeLL.objValue;
    }
}
