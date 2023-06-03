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
public final class rdb {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<rdb> d;
    public transient /* synthetic */ FieldHolder $fh;
    public sdb a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948119193, "Lcom/baidu/tieba/rdb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948119193, "Lcom/baidu/tieba/rdb;");
        }
    }

    public rdb(Context context, String str) {
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
        wdb.b();
        this.a = new sdb(context, str);
        this.b = str;
        this.c = context;
    }

    public static rdb b(Context context, String str) {
        InterceptResult invokeLL;
        rdb rdbVar;
        rdb rdbVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<rdb> softReference = d;
                if (softReference == null) {
                    rdbVar = null;
                } else {
                    rdbVar = softReference.get();
                }
                if (rdbVar == null || !str.equals(rdbVar.b)) {
                    synchronized (rdb.class) {
                        rdbVar2 = new rdb(context, str);
                        d = new SoftReference<>(rdbVar2);
                    }
                    return rdbVar2;
                }
                return rdbVar;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (rdb) invokeLL.objValue;
    }

    public final void a(Activity activity, pdb pdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, pdbVar) == null) {
            this.a.c(activity, "123", pdbVar);
        }
    }

    public final void c(int i, int i2, Intent intent, pdb pdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, pdbVar}) == null) {
            this.a.d(i, i2, intent, pdbVar);
        }
    }
}
