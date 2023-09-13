package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.tieba.wi2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public pi2 a;
    public zi2 b;

    /* loaded from: classes9.dex */
    public class a extends lj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ zc2 c;

        public a(@NonNull zc2 zc2Var, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zc2Var;
            this.a = str;
            this.b = str2;
            if (zc2.c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.tieba.mj2
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lj2, com.baidu.tieba.mj2
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return super.b();
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // com.baidu.tieba.mj2
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lj2, com.baidu.tieba.mj2
        public void c(pi2 pi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pi2Var) == null) {
                if (this.c.b != null) {
                    this.c.b.a(pi2Var);
                }
                pi2Var.x0();
            }
        }

        @Override // com.baidu.tieba.lj2, com.baidu.tieba.mj2
        public void d(pi2 pi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pi2Var) == null) {
                super.d(pi2Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948355072, "Lcom/baidu/tieba/zc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948355072, "Lcom/baidu/tieba/zc2;");
                return;
            }
        }
        c = rr1.a;
    }

    public final wi2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wi2.b bVar = new wi2.b();
            bVar.c(3);
            bVar.b(xc2.b());
            return bVar.a();
        }
        return (wi2) invokeV.objValue;
    }

    public pi2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (pi2) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pi2 pi2Var = this.a;
            if (pi2Var != null) {
                pi2Var.j0();
                this.a = null;
            }
            this.b = null;
        }
    }

    public zc2(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = vi2.b(c(), new a(this, str, str2), null);
        this.a.addJavascriptInterface(new yc2(this.a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public void f(zi2 zi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zi2Var) == null) {
            this.b = zi2Var;
        }
    }
}
