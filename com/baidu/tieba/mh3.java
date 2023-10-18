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
public final class mh3 implements jh3, lh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<kh3<?>, Set<b>> l;

    /* loaded from: classes7.dex */
    public interface b extends ik3<Set<kh3<?>>> {
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(mh3 mh3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh3Var, set, set2};
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
        public static final mh3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-604067406, "Lcom/baidu/tieba/mh3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-604067406, "Lcom/baidu/tieba/mh3$c;");
                    return;
                }
            }
            a = new mh3();
        }
    }

    public mh3() {
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

    public static mh3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (mh3) invokeV.objValue;
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

    public mh3 e(kh3<?>... kh3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kh3VarArr)) == null) {
            c(Sets.newHashSet(kh3VarArr));
            return this;
        }
        return (mh3) invokeL.objValue;
    }

    public mh3 f(ih3 ih3Var) {
        InterceptResult invokeL;
        String ih3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ih3Var)) == null) {
            if (ih3Var == null) {
                ih3Var2 = "";
            } else {
                ih3Var2 = ih3Var.toString();
            }
            if (jh3.a) {
                Log.i("Tracer-ErrCode", ih3Var2);
            }
            p22.c("Tracer-ErrCode", ih3Var2);
            return this;
        }
        return (mh3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull kh3<?> kh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, kh3Var)) == null) {
            Set<b> set = this.l.get(kh3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(kh3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public mh3 c(Set<kh3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (kh3<?> kh3Var : set) {
                    hashSet.addAll(i(kh3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (mh3) invokeL.objValue;
    }

    public mh3 h(kh3<?>... kh3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kh3VarArr)) == null) {
            synchronized (this.l) {
                for (kh3<?> kh3Var : kh3VarArr) {
                    if (!this.l.containsKey(kh3Var)) {
                        this.l.put(kh3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (mh3) invokeL.objValue;
    }

    public final mh3 d(Set<b> set, Set<kh3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            hz2.j().i(new a(this, set, set2));
            return this;
        }
        return (mh3) invokeLL.objValue;
    }

    public mh3 g(b bVar, kh3<?>... kh3VarArr) {
        InterceptResult invokeLL;
        Set<kh3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, kh3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(kh3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(kh3VarArr);
                    }
                    for (kh3<?> kh3Var : newHashSet) {
                        if (kh3Var != null) {
                            i(kh3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (mh3) invokeLL.objValue;
    }

    public mh3 j(b bVar, kh3<?>... kh3VarArr) {
        InterceptResult invokeLL;
        Set<kh3<?>> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, kh3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(kh3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(kh3VarArr);
                    }
                    for (kh3<?> kh3Var : newHashSet) {
                        if (kh3Var != null) {
                            i(kh3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (mh3) invokeLL.objValue;
    }
}
