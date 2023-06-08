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
public final class wdb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<wdb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public xdb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948268148, "Lcom/baidu/tieba/wdb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948268148, "Lcom/baidu/tieba/wdb;");
        }
    }

    public wdb(Context context, String str) {
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
        beb.b();
        this.a = new xdb(context, str);
        this.b = str;
        this.c = context;
    }

    public static wdb b(Context context, String str) {
        InterceptResult invokeLL;
        wdb wdbVar;
        wdb wdbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<wdb> softReference = d;
                if (softReference == null) {
                    wdbVar = null;
                } else {
                    wdbVar = softReference.get();
                }
                if (wdbVar == null || !str.equals(wdbVar.b)) {
                    synchronized (wdb.class) {
                        wdbVar2 = new wdb(context, str);
                        d = new SoftReference<>(wdbVar2);
                    }
                    return wdbVar2;
                }
                return wdbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (wdb) invokeLL.objValue;
    }

    public final void a(Activity activity, udb udbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, udbVar) == null) {
            this.a.c(activity, "123", udbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, udb udbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, udbVar}) == null) {
            this.a.d(i, i2, intent, udbVar);
        }
    }
}
