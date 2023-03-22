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
public final class npa {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<npa> d;
    public transient /* synthetic */ FieldHolder $fh;
    public opa a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948011530, "Lcom/baidu/tieba/npa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948011530, "Lcom/baidu/tieba/npa;");
        }
    }

    public npa(Context context, String str) {
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
        spa.b();
        this.a = new opa(context, str);
        this.b = str;
        this.c = context;
    }

    public static npa b(Context context, String str) {
        InterceptResult invokeLL;
        npa npaVar;
        npa npaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<npa> softReference = d;
                if (softReference == null) {
                    npaVar = null;
                } else {
                    npaVar = softReference.get();
                }
                if (npaVar == null || !str.equals(npaVar.b)) {
                    synchronized (npa.class) {
                        npaVar2 = new npa(context, str);
                        d = new SoftReference<>(npaVar2);
                    }
                    return npaVar2;
                }
                return npaVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (npa) invokeLL.objValue;
    }

    public final void a(Activity activity, lpa lpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, lpaVar) == null) {
            this.a.c(activity, "123", lpaVar);
        }
    }

    public final void c(int i, int i2, Intent intent, lpa lpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, lpaVar}) == null) {
            this.a.d(i, i2, intent, lpaVar);
        }
    }
}
