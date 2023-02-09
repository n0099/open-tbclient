package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public final class jaa {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<jaa> d;
    public transient /* synthetic */ FieldHolder $fh;
    public kaa a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947877951, "Lcom/baidu/tieba/jaa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947877951, "Lcom/baidu/tieba/jaa;");
        }
    }

    public jaa(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        oaa.b();
        this.a = new kaa(context, str);
        this.b = str;
        this.c = context;
    }

    public static jaa b(Context context, String str) {
        InterceptResult invokeLL;
        jaa jaaVar;
        jaa jaaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<jaa> softReference = d;
                if (softReference == null) {
                    jaaVar = null;
                } else {
                    jaaVar = softReference.get();
                }
                if (jaaVar == null || !str.equals(jaaVar.b)) {
                    synchronized (jaa.class) {
                        jaaVar2 = new jaa(context, str);
                        d = new SoftReference<>(jaaVar2);
                    }
                    return jaaVar2;
                }
                return jaaVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (jaa) invokeLL.objValue;
    }

    public final void a(Activity activity, haa haaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, haaVar) == null) {
            this.a.c(activity, "123", haaVar);
        }
    }

    public final void c(int i, int i2, Intent intent, haa haaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, haaVar}) == null) {
            this.a.d(i, i2, intent, haaVar);
        }
    }
}
