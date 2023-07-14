package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q64 extends sa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public transient /* synthetic */ FieldHolder $fh;
    public View z;

    @Override // com.baidu.tieba.sa2, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends ja2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(q64 q64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ja2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (q64.A) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                r64.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948043770, "Lcom/baidu/tieba/q64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948043770, "Lcom/baidu/tieba/q64;");
                return;
            }
        }
        A = fs1.a;
    }

    @Override // com.baidu.tieba.sa2, com.baidu.tieba.ay1
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r64.h(false);
            this.z = null;
            super.D();
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b(new a(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q64(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sa2, com.baidu.tieba.ay1
    public void F(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.z = view2;
        }
    }

    @Override // com.baidu.tieba.sa2, com.baidu.tieba.ay1
    public void O(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int visibility = r().getVisibility();
            int i2 = 0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            if (visibility == i) {
                return;
            }
            if (A) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                ix2.T().m("console", l64.u(true));
            }
            if (this.z != null) {
                if (z) {
                    i2 = 4;
                }
                this.z.setVisibility(i2);
            }
            super.O(z);
        }
    }

    @Override // com.baidu.tieba.sa2, com.baidu.tieba.ay1
    public void e0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            r64.g(str, str2);
        }
    }

    @Override // com.baidu.tieba.sa2
    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r().setVisibility(8);
            r().setBackgroundColor(0);
            r64.c();
            g1();
            String i = m64.m().i();
            if (A) {
                Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i);
            }
            loadUrl(i);
        }
    }
}
