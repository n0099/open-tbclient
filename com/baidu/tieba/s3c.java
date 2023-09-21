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
public final class s3c {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<s3c> d;
    public transient /* synthetic */ FieldHolder $fh;
    public t3c a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948101926, "Lcom/baidu/tieba/s3c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948101926, "Lcom/baidu/tieba/s3c;");
        }
    }

    public s3c(Context context, String str) {
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
        x3c.b();
        this.a = new t3c(context, str);
        this.b = str;
        this.c = context;
    }

    public static s3c b(Context context, String str) {
        InterceptResult invokeLL;
        s3c s3cVar;
        s3c s3cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<s3c> softReference = d;
                if (softReference == null) {
                    s3cVar = null;
                } else {
                    s3cVar = softReference.get();
                }
                if (s3cVar == null || !str.equals(s3cVar.b)) {
                    synchronized (s3c.class) {
                        s3cVar2 = new s3c(context, str);
                        d = new SoftReference<>(s3cVar2);
                    }
                    return s3cVar2;
                }
                return s3cVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (s3c) invokeLL.objValue;
    }

    public final void a(Activity activity, q3c q3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, q3cVar) == null) {
            this.a.c(activity, "123", q3cVar);
        }
    }

    public final void c(int i, int i2, Intent intent, q3c q3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, q3cVar}) == null) {
            this.a.d(i, i2, intent, q3cVar);
        }
    }
}
