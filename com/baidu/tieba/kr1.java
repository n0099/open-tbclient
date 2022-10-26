package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes4.dex */
public class kr1 implements nr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public CallbackHandler b;
    public WeakReference c;
    public k22 d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947922591, "Lcom/baidu/tieba/kr1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947922591, "Lcom/baidu/tieba/kr1;");
                return;
            }
        }
        e = wj1.a;
    }

    @Override // com.baidu.tieba.nr1
    public k22 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (k22) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nr1
    public CallbackHandler g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (CallbackHandler) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nr1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return h();
        }
        return (Context) invokeV.objValue;
    }

    public final Context h() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WeakReference weakReference = this.c;
            if (weakReference != null) {
                activity = (Activity) weakReference.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                return this.a;
            }
            return activity;
        }
        return (Context) invokeV.objValue;
    }

    public kr1(Context context, CallbackHandler callbackHandler, k22 k22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, callbackHandler, k22Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = callbackHandler;
        this.d = k22Var;
    }

    public void a(k22 k22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k22Var) == null) {
            k22Var.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
        }
    }

    public final void b(k22 k22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k22Var) == null) {
            if (k22Var instanceof wa2) {
                c((wa2) k22Var);
            } else {
                d(k22Var);
            }
        }
    }

    public final void c(wa2 wa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wa2Var) == null) {
            e(wa2Var, SwanApi$$ModulesProvider.getV8ApiModules(this), tm2.s().b(this));
        }
    }

    public final void d(k22 k22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k22Var) == null) {
            e(k22Var, SwanApi$$ModulesProvider.getWebviewApiModules(this), tm2.s().c(this));
        }
    }

    public void i(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && activity != null) {
            this.c = new WeakReference(activity);
        }
    }

    public final void e(k22 k22Var, Map map, Map map2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, k22Var, map, map2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (map2 != null) {
                if (map == null) {
                    map = map2;
                } else {
                    try {
                        map.putAll(map2);
                    } catch (Exception e2) {
                        if (!e) {
                            return;
                        }
                        e2.printStackTrace();
                        throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                    }
                }
            }
            if (map == null) {
                if (!e) {
                    return;
                }
                throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
            }
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (TextUtils.isEmpty(str2)) {
                    if (e) {
                        throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                    }
                } else if (value == null) {
                    if (e) {
                        throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                    }
                } else {
                    k22Var.addJavascriptInterface(value, str2);
                    if (e) {
                        if (k22Var instanceof wa2) {
                            str = "V8";
                        } else {
                            str = "Webview";
                        }
                        Log.d("Api-Binder", "doBindSwanApis(" + str + "): bound " + str2);
                    }
                }
            }
            if (e) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 5) {
                    Log.w("Api-Binder", "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms");
                }
            }
        }
    }
}
