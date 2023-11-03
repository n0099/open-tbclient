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
public final class qac {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<qac> d;
    public transient /* synthetic */ FieldHolder $fh;
    public rac a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948086550, "Lcom/baidu/tieba/qac;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948086550, "Lcom/baidu/tieba/qac;");
        }
    }

    public qac(Context context, String str) {
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
        vac.b();
        this.a = new rac(context, str);
        this.b = str;
        this.c = context;
    }

    public static qac b(Context context, String str) {
        InterceptResult invokeLL;
        qac qacVar;
        qac qacVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<qac> softReference = d;
                if (softReference == null) {
                    qacVar = null;
                } else {
                    qacVar = softReference.get();
                }
                if (qacVar == null || !str.equals(qacVar.b)) {
                    synchronized (qac.class) {
                        qacVar2 = new qac(context, str);
                        d = new SoftReference<>(qacVar2);
                    }
                    return qacVar2;
                }
                return qacVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (qac) invokeLL.objValue;
    }

    public final void a(Activity activity, oac oacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, oacVar) == null) {
            this.a.c(activity, "123", oacVar);
        }
    }

    public final void c(int i, int i2, Intent intent, oac oacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, oacVar}) == null) {
            this.a.d(i, i2, intent, oacVar);
        }
    }
}
