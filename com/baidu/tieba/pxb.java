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
/* loaded from: classes7.dex */
public final class pxb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<pxb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public qxb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948078831, "Lcom/baidu/tieba/pxb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948078831, "Lcom/baidu/tieba/pxb;");
        }
    }

    public pxb(Context context, String str) {
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
        uxb.b();
        this.a = new qxb(context, str);
        this.b = str;
        this.c = context;
    }

    public static pxb b(Context context, String str) {
        InterceptResult invokeLL;
        pxb pxbVar;
        pxb pxbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<pxb> softReference = d;
                if (softReference == null) {
                    pxbVar = null;
                } else {
                    pxbVar = softReference.get();
                }
                if (pxbVar == null || !str.equals(pxbVar.b)) {
                    synchronized (pxb.class) {
                        pxbVar2 = new pxb(context, str);
                        d = new SoftReference<>(pxbVar2);
                    }
                    return pxbVar2;
                }
                return pxbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (pxb) invokeLL.objValue;
    }

    public final void a(Activity activity, nxb nxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, nxbVar) == null) {
            this.a.c(activity, "123", nxbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, nxb nxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, nxbVar}) == null) {
            this.a.d(i, i2, intent, nxbVar);
        }
    }
}
