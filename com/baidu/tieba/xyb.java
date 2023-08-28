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
/* loaded from: classes8.dex */
public final class xyb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<xyb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public yyb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948318120, "Lcom/baidu/tieba/xyb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948318120, "Lcom/baidu/tieba/xyb;");
        }
    }

    public xyb(Context context, String str) {
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
        czb.b();
        this.a = new yyb(context, str);
        this.b = str;
        this.c = context;
    }

    public static xyb b(Context context, String str) {
        InterceptResult invokeLL;
        xyb xybVar;
        xyb xybVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<xyb> softReference = d;
                if (softReference == null) {
                    xybVar = null;
                } else {
                    xybVar = softReference.get();
                }
                if (xybVar == null || !str.equals(xybVar.b)) {
                    synchronized (xyb.class) {
                        xybVar2 = new xyb(context, str);
                        d = new SoftReference<>(xybVar2);
                    }
                    return xybVar2;
                }
                return xybVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (xyb) invokeLL.objValue;
    }

    public final void a(Activity activity, vyb vybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, vybVar) == null) {
            this.a.c(activity, "123", vybVar);
        }
    }

    public final void c(int i, int i2, Intent intent, vyb vybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, vybVar}) == null) {
            this.a.d(i, i2, intent, vybVar);
        }
    }
}
