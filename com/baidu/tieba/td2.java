package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class td2 extends SwanAppWebViewManager implements Object<NgWebView>, rd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public final String w;

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.rd2
    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948177287, "Lcom/baidu/tieba/td2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948177287, "Lcom/baidu/tieba/td2;");
                return;
            }
        }
        x = fs1.a;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rd2
    public ta2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return r();
        }
        return (ta2) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            pi2.U().w0(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public td2(Context context) {
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
        this.w = be2.b();
    }

    @Override // com.baidu.tieba.rd2
    public void C(ji2 ji2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ji2Var) != null) || ji2Var == null) {
            return;
        }
        if (x) {
            Log.d("SwanAppMasterManager", "pathList item: " + ji2Var.b);
        }
        this.b.getSettings().setCodeCacheSetting(oa2.a("appjs", ji2Var.b));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.loadUrl(str);
        }
    }
}
