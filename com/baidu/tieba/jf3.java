package com.baidu.tieba;

import android.util.Log;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public final class jf3 implements gf3, if3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map l;

    /* loaded from: classes4.dex */
    public interface b extends fi3 {
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(jf3 jf3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jf3Var, set, set2};
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

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public static final jf3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-691801901, "Lcom/baidu/tieba/jf3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-691801901, "Lcom/baidu/tieba/jf3$c;");
                    return;
                }
            }
            a = new jf3();
        }
    }

    public jf3() {
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

    public static jf3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return c.a;
        }
        return (jf3) invokeV.objValue;
    }

    public final boolean b(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
            if (objArr == null || objArr.length < 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public jf3 e(hf3... hf3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hf3VarArr)) == null) {
            c(Sets.newHashSet(hf3VarArr));
            return this;
        }
        return (jf3) invokeL.objValue;
    }

    public jf3 f(ff3 ff3Var) {
        InterceptResult invokeL;
        String ff3Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ff3Var)) == null) {
            if (ff3Var == null) {
                ff3Var2 = "";
            } else {
                ff3Var2 = ff3Var.toString();
            }
            if (gf3.a) {
                Log.i("Tracer-ErrCode", ff3Var2);
            }
            m02.c("Tracer-ErrCode", ff3Var2);
            return this;
        }
        return (jf3) invokeL.objValue;
    }

    public final Set i(hf3 hf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hf3Var)) == null) {
            Set set = (Set) this.l.get(hf3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(hf3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public jf3 c(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    hashSet.addAll(i((hf3) it.next()));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (jf3) invokeL.objValue;
    }

    public jf3 h(hf3... hf3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hf3VarArr)) == null) {
            synchronized (this.l) {
                for (hf3 hf3Var : hf3VarArr) {
                    if (!this.l.containsKey(hf3Var)) {
                        this.l.put(hf3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (jf3) invokeL.objValue;
    }

    public final jf3 d(Set set, Set set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            ex2.j().i(new a(this, set, set2));
            return this;
        }
        return (jf3) invokeLL.objValue;
    }

    public jf3 g(b bVar, hf3... hf3VarArr) {
        InterceptResult invokeLL;
        Set<hf3> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, hf3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(hf3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(hf3VarArr);
                    }
                    for (hf3 hf3Var : newHashSet) {
                        if (hf3Var != null) {
                            i(hf3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), newHashSet);
                }
            }
            return this;
        }
        return (jf3) invokeLL.objValue;
    }

    public jf3 j(b bVar, hf3... hf3VarArr) {
        InterceptResult invokeLL;
        Set<hf3> newHashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, hf3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    if (b(hf3VarArr)) {
                        newHashSet = this.l.keySet();
                    } else {
                        newHashSet = Sets.newHashSet(hf3VarArr);
                    }
                    for (hf3 hf3Var : newHashSet) {
                        if (hf3Var != null) {
                            i(hf3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (jf3) invokeLL.objValue;
    }
}
