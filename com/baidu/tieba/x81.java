package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.nadcore.webarch.feature.NadWebFeature;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class x81 {
    public static /* synthetic */ Interceptable $ic;
    public static x81 c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public HashMap<String, NadWebFeature> b;

    public x81() {
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
        this.a = false;
        this.b = new HashMap<>(4);
    }

    public static synchronized x81 c() {
        InterceptResult invokeV;
        x81 x81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (x81.class) {
                if (c == null) {
                    c = new x81();
                }
                x81Var = c;
            }
            return x81Var;
        }
        return (x81) invokeV.objValue;
    }

    @RequiresApi(api = 21)
    public static boolean h(Activity activity, ValueCallback<Uri[]> valueCallback, u81 u81Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, activity, valueCallback, u81Var)) == null) {
            if (valueCallback == null) {
                return false;
            }
            if (activity == null) {
                valueCallback.onReceiveValue(null);
                return false;
            }
            NadWebFeature b = c().b(BdSailorConfig.SAILOR_BASE_UPLOAD);
            if (b != null && b.c()) {
                if (b instanceof w81) {
                    return ((w81) b).h(activity, valueCallback, u81Var);
                }
                valueCallback.onReceiveValue(null);
            } else {
                valueCallback.onReceiveValue(null);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public NadWebFeature a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return b(str);
        }
        return (NadWebFeature) invokeL.objValue;
    }

    public NadWebFeature b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.b.get(str);
        }
        return (NadWebFeature) invokeL.objValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            e(context);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && !this.a) {
            w81 w81Var = new w81(context);
            w81Var.a();
            i(w81Var);
            this.a = true;
        }
    }

    public void f(Activity activity) {
        NadWebFeature a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && (a = a(BdSailorConfig.SAILOR_BASE_UPLOAD)) != null && a.c() && (a instanceof w81)) {
            ((w81) a).f(activity);
        }
    }

    public final void i(NadWebFeature nadWebFeature) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, nadWebFeature) == null) && nadWebFeature != null) {
            this.b.put(nadWebFeature.b(), nadWebFeature);
        }
    }

    public void g(Activity activity, int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), intent}) == null) && 11 == i && (a(BdSailorConfig.SAILOR_BASE_UPLOAD) instanceof w81)) {
            ((w81) a(BdSailorConfig.SAILOR_BASE_UPLOAD)).g(activity, i2, intent);
        }
    }
}
