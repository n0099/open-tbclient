package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class wv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Method b;
    public Object c;

    public wv3(Class<?> cls) {
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 4099;
        if (cls == null) {
            return;
        }
        try {
            Object k = lf4.k(cls, "getInstance", new Object[0]);
            this.c = k;
            if (k != null) {
                Object h = lf4.h(k, "UNIPERF_EVENT_APP_START");
                if (h == null) {
                    intValue = this.a;
                } else {
                    intValue = ((Integer) h).intValue();
                }
                this.a = intValue;
            }
            Method i3 = lf4.i(cls, "uniPerfEvent", Integer.TYPE, String.class, int[].class);
            this.b = i3;
            if (i3 != null) {
                i3.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static wv3 b(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                cls = lf4.b("android.iawareperf.UniPerf", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new wv3(cls);
        }
        return (wv3) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c != null && this.b != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int d(int i, String str, int... iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, iArr)) == null) {
            if (!c()) {
                return -1;
            }
            try {
                Object invoke = this.b.invoke(this.c, Integer.valueOf(i), str, iArr);
                if (invoke == null) {
                    return -1;
                }
                return ((Integer) invoke).intValue();
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeILL.intValue;
    }
}
