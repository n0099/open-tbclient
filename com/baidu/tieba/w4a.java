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
/* loaded from: classes6.dex */
public final class w4a {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<w4a> d;
    public transient /* synthetic */ FieldHolder $fh;
    public x4a a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948221989, "Lcom/baidu/tieba/w4a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948221989, "Lcom/baidu/tieba/w4a;");
        }
    }

    public w4a(Context context, String str) {
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
        b5a.b();
        this.a = new x4a(context, str);
        this.b = str;
        this.c = context;
    }

    public static w4a b(Context context, String str) {
        InterceptResult invokeLL;
        w4a w4aVar;
        w4a w4aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<w4a> softReference = d;
                if (softReference == null) {
                    w4aVar = null;
                } else {
                    w4aVar = softReference.get();
                }
                if (w4aVar == null || !str.equals(w4aVar.b)) {
                    synchronized (w4a.class) {
                        w4aVar2 = new w4a(context, str);
                        d = new SoftReference<>(w4aVar2);
                    }
                    return w4aVar2;
                }
                return w4aVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (w4a) invokeLL.objValue;
    }

    public final void a(Activity activity, u4a u4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, u4aVar) == null) {
            this.a.c(activity, "123", u4aVar);
        }
    }

    public final void c(int i, int i2, Intent intent, u4a u4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, u4aVar}) == null) {
            this.a.d(i, i2, intent, u4aVar);
        }
    }
}
