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
/* loaded from: classes6.dex */
public class wc2 implements vc2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wc2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, uc2> a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wc2 b;

        public a(wc2 wc2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wc2Var;
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

    public wc2() {
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

    public static wc2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (wc2.class) {
                    if (b == null) {
                        b = new wc2();
                    }
                }
            }
            return b;
        }
        return (wc2) invokeV.objValue;
    }

    public synchronized wc2 b(String str, UbcFlowEvent ubcFlowEvent) {
        InterceptResult invokeLL;
        uc2 uc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, ubcFlowEvent)) == null) {
            synchronized (this) {
                if (c(str) && (uc2Var = this.a.get(str)) != null) {
                    uc2Var.a(str, ubcFlowEvent);
                    return this;
                }
                return this;
            }
        }
        return (wc2) invokeLL.objValue;
    }

    public synchronized wc2 f(String str, xc2 xc2Var) {
        InterceptResult invokeLL;
        uc2 uc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, xc2Var)) == null) {
            synchronized (this) {
                if (c(str) && (uc2Var = this.a.get(str)) != null) {
                    uc2Var.e(str, xc2Var);
                    return this;
                }
                return this;
            }
        }
        return (wc2) invokeLL.objValue;
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
        uc2 uc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                if (c(str) && (uc2Var = this.a.get(str)) != null) {
                    this.a.remove(str);
                    uc2Var.h(str);
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

    public synchronized wc2 e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        uc2 uc2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (this) {
                if (c(str) && (uc2Var = this.a.get(str)) != null) {
                    uc2Var.d(str, z);
                    if (z2) {
                        i(str);
                    }
                    return this;
                }
                return this;
            }
        }
        return (wc2) invokeCommon.objValue;
    }

    public synchronized wc2 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c(str) && !this.a.containsKey(str)) {
                    uc2 uc2Var = new uc2();
                    this.a.put(str, uc2Var);
                    uc2Var.f(str);
                    return this;
                }
                return this;
            }
        }
        return (wc2) invokeL.objValue;
    }
}
