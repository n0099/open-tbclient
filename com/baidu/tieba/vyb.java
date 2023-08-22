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
public final class vyb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<vyb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public wyb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948258538, "Lcom/baidu/tieba/vyb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948258538, "Lcom/baidu/tieba/vyb;");
        }
    }

    public vyb(Context context, String str) {
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
        azb.b();
        this.a = new wyb(context, str);
        this.b = str;
        this.c = context;
    }

    public static vyb b(Context context, String str) {
        InterceptResult invokeLL;
        vyb vybVar;
        vyb vybVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<vyb> softReference = d;
                if (softReference == null) {
                    vybVar = null;
                } else {
                    vybVar = softReference.get();
                }
                if (vybVar == null || !str.equals(vybVar.b)) {
                    synchronized (vyb.class) {
                        vybVar2 = new vyb(context, str);
                        d = new SoftReference<>(vybVar2);
                    }
                    return vybVar2;
                }
                return vybVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (vyb) invokeLL.objValue;
    }

    public final void a(Activity activity, tyb tybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, tybVar) == null) {
            this.a.c(activity, "123", tybVar);
        }
    }

    public final void c(int i, int i2, Intent intent, tyb tybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, tybVar}) == null) {
            this.a.d(i, i2, intent, tybVar);
        }
    }
}
