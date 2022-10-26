package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class p82 implements o82 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p82 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ p82 b;

        public a(p82 p82Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p82Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.h(this.a);
            }
        }
    }

    public p82() {
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
        this.a = new HashMap();
    }

    public static p82 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (p82.class) {
                    if (b == null) {
                        b = new p82();
                    }
                }
            }
            return b;
        }
        return (p82) invokeV.objValue;
    }

    public synchronized p82 b(String str, UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeLL;
        n82 n82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, ubcFlowEvent)) == null) {
            synchronized (this) {
                if (c(str) && (n82Var = (n82) this.a.get(str)) != null) {
                    n82Var.a(str, ubcFlowEvent);
                    return this;
                }
                return this;
            }
        }
        return (p82) invokeLL.objValue;
    }

    public synchronized p82 f(String str, q82 q82Var) {
        InterceptResult invokeLL;
        n82 n82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, q82Var)) == null) {
            synchronized (this) {
                if (c(str) && (n82Var = (n82) this.a.get(str)) != null) {
                    n82Var.e(str, q82Var);
                    return this;
                }
                return this;
            }
        }
        return (p82) invokeLL.objValue;
    }

    public void j(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j) == null) {
            ExecutorUtilsExt.delayPostOnElastic(new a(this, str), "PrefetchStageRecorder", 3, j);
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return !TextUtils.isEmpty(str);
        }
        return invokeL.booleanValue;
    }

    public final synchronized void h(String str) {
        n82 n82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                if (c(str) && (n82Var = (n82) this.a.get(str)) != null) {
                    this.a.remove(str);
                    n82Var.h(str);
                }
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            j(str, 0L);
        }
    }

    public synchronized p82 e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        n82 n82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (c(str) && (n82Var = (n82) this.a.get(str)) != null) {
                    n82Var.d(str, z);
                    if (z2) {
                        i(str);
                    }
                    return this;
                }
                return this;
            }
        }
        return (p82) invokeCommon.objValue;
    }

    public synchronized p82 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c(str) && !this.a.containsKey(str)) {
                    n82 n82Var = new n82();
                    this.a.put(str, n82Var);
                    n82Var.f(str);
                    return this;
                }
                return this;
            }
        }
        return (p82) invokeL.objValue;
    }
}
