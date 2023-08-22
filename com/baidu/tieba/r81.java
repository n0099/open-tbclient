package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
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
import java.util.Map;
/* loaded from: classes7.dex */
public class r81 extends NadWebFeature {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Activity, q81> b;

    @Override // com.baidu.nadcore.webarch.feature.NadWebFeature
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BdSailorConfig.SAILOR_BASE_UPLOAD : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r81(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap();
    }

    public q81 d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            Map<Activity, q81> map = this.b;
            if (map != null) {
                return map.get(activity);
            }
            return null;
        }
        return (q81) invokeL.objValue;
    }

    public q81 e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            q81 d = d(activity);
            if (d == null) {
                q81 q81Var = new q81(activity);
                this.b.put(activity, q81Var);
                return q81Var;
            }
            return d;
        }
        return (q81) invokeL.objValue;
    }

    public void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            q81 d = d(activity);
            if (activity != null && d != null) {
                this.b.remove(activity);
                if (!d.o()) {
                    d.p(-1, null);
                }
            }
        }
    }

    public void g(Activity activity, int i, Intent intent) {
        q81 d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048580, this, activity, i, intent) == null) && (d = d(activity)) != null) {
            d.p(i, intent);
            this.b.remove(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    @RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(Activity activity, @NonNull ValueCallback<Uri[]> valueCallback, p81 p81Var) {
        InterceptResult invokeLLL;
        boolean z;
        Map<Activity, q81> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, valueCallback, p81Var)) == null) {
            if (activity != null) {
                q81 e = e(activity);
                if (p81Var != null) {
                    z = e.q(valueCallback, p81Var);
                    if (!z) {
                        valueCallback.onReceiveValue(null);
                        if (activity != null && (map = this.b) != null) {
                            map.remove(activity);
                        }
                    }
                    return z;
                }
            }
            z = false;
            if (!z) {
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }
}
