package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.tieba.tb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public mb2 a;
    public wb2 b;

    /* loaded from: classes6.dex */
    public class a extends ic2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ w52 c;

        public a(@NonNull w52 w52Var, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w52Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w52Var;
            this.a = str;
            this.b = str2;
            if (w52.c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.tieba.jc2
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ic2, com.baidu.tieba.jc2
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return super.b();
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // com.baidu.tieba.jc2
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ic2, com.baidu.tieba.jc2
        public void c(mb2 mb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mb2Var) == null) {
                if (this.c.b != null) {
                    this.c.b.a(mb2Var);
                }
                mb2Var.y0();
            }
        }

        @Override // com.baidu.tieba.ic2, com.baidu.tieba.jc2
        public void d(mb2 mb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mb2Var) == null) {
                super.d(mb2Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221493, "Lcom/baidu/tieba/w52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221493, "Lcom/baidu/tieba/w52;");
                return;
            }
        }
        c = ok1.a;
    }

    public final tb2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            tb2.b bVar = new tb2.b();
            bVar.c(3);
            bVar.b(u52.b());
            return bVar.a();
        }
        return (tb2) invokeV.objValue;
    }

    public mb2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (mb2) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mb2 mb2Var = this.a;
            if (mb2Var != null) {
                mb2Var.k0();
                this.a = null;
            }
            this.b = null;
        }
    }

    public w52(@NonNull String str, @NonNull String str2) {
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
        this.a = sb2.b(c(), new a(this, str, str2), null);
        this.a.addJavascriptInterface(new v52(this.a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public void f(wb2 wb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wb2Var) == null) {
            this.b = wb2Var;
        }
    }
}
