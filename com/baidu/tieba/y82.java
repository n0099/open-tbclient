package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y82 implements n82<m82> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;
    public volatile n82<m82> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948283958, "Lcom/baidu/tieba/y82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948283958, "Lcom/baidu/tieba/y82;");
                return;
            }
        }
        c = vm1.a;
    }

    public y82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    @Override // com.baidu.tieba.o82
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return l().f();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o82
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return l().g();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o82
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return l().h();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n82
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return l().i();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o82
    /* renamed from: k */
    public m82 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (m82) l().a();
        }
        return (m82) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o82
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l().reset();
            synchronized (this) {
                this.a = null;
                this.b = null;
            }
        }
    }

    @Override // com.baidu.tieba.n82
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            l().b(str, cVar, pMSAppInfo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.p82<com.baidu.tieba.m82> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.o82
    public void c(p82<m82> p82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p82Var) == null) {
            l().c(p82Var);
        }
    }

    @Override // com.baidu.tieba.n82
    public void d(kg2 kg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kg2Var) == null) {
            l().d(kg2Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o82
    /* renamed from: n */
    public m82 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) {
            return (m82) l().e(pMSAppInfo);
        }
        return (m82) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n82
    public void j(boolean z, v82 v82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, v82Var) == null) {
            l().j(z, v82Var);
        }
    }

    public final n82<m82> l() {
        InterceptResult invokeV;
        n82<m82> x82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        if (m()) {
                            x82Var = new c92();
                        } else {
                            x82Var = new x82();
                        }
                        this.b = x82Var;
                        if (c) {
                            Log.d("SwanAppMasterProviderWrapper", "provider - " + this.b.getClass().getSimpleName());
                        }
                    }
                }
            }
            return this.b;
        }
        return (n82) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                if (ka2.l() > 0 && ka2.i()) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = Boolean.valueOf(z);
            }
            if (c) {
                Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + ed2.V().e0());
                Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.a);
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }
}
