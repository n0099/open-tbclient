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
public final class mza {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<mza> d;
    public transient /* synthetic */ FieldHolder $fh;
    public nza a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947991349, "Lcom/baidu/tieba/mza;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947991349, "Lcom/baidu/tieba/mza;");
        }
    }

    public mza(Context context, String str) {
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
        rza.b();
        this.a = new nza(context, str);
        this.b = str;
        this.c = context;
    }

    public static mza b(Context context, String str) {
        InterceptResult invokeLL;
        mza mzaVar;
        mza mzaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<mza> softReference = d;
                if (softReference == null) {
                    mzaVar = null;
                } else {
                    mzaVar = softReference.get();
                }
                if (mzaVar == null || !str.equals(mzaVar.b)) {
                    synchronized (mza.class) {
                        mzaVar2 = new mza(context, str);
                        d = new SoftReference<>(mzaVar2);
                    }
                    return mzaVar2;
                }
                return mzaVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (mza) invokeLL.objValue;
    }

    public final void a(Activity activity, kza kzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, kzaVar) == null) {
            this.a.c(activity, "123", kzaVar);
        }
    }

    public final void c(int i, int i2, Intent intent, kza kzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, kzaVar}) == null) {
            this.a.d(i, i2, intent, kzaVar);
        }
    }
}
