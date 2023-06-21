package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class ww3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public Method a;
    public Method b;
    public Object c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284950, "Lcom/baidu/tieba/ww3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284950, "Lcom/baidu/tieba/ww3;");
                return;
            }
        }
        d = new String[]{"android.util.BoostFramework", "com.qualcomm.qti.Performance", "org.codeaurora.Performance"};
    }

    public static Class<?> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String[] strArr = d;
            for (int i = 0; i < strArr.length; i++) {
                try {
                    return dg4.a(strArr[i]);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Class) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c != null && this.a != null && this.b != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!c()) {
                return -1;
            }
            try {
                Object invoke = this.b.invoke(this.c, new Object[0]);
                if (invoke == null) {
                    return -1;
                }
                return ((Integer) invoke).intValue();
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public ww3(Class<?> cls, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            this.c = a(context, cls);
            Method i3 = dg4.i(cls, "perfLockAcquire", Integer.TYPE, int[].class);
            this.a = i3;
            if (i3 != null) {
                i3.setAccessible(true);
            }
            Method i4 = dg4.i(cls, "perfLockRelease", new Class[0]);
            this.b = i4;
            if (i4 != null) {
                i4.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static ww3 b(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                cls = d();
                try {
                    bg4.c(cls);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                cls = null;
            }
            return new ww3(cls, context);
        }
        return (ww3) invokeL.objValue;
    }

    public final Object a(@Nullable Context context, @NonNull Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cls)) == null) {
            Object obj = null;
            try {
                Constructor c = dg4.c(cls, Context.class);
                if (c != null) {
                    obj = c.newInstance(context);
                }
            } catch (Throwable unused) {
            }
            if (obj == null) {
                try {
                    return dg4.m(cls);
                } catch (Throwable unused2) {
                    return obj;
                }
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public int e(int i, int... iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, iArr)) == null) {
            if (!c()) {
                return -1;
            }
            try {
                Object invoke = this.a.invoke(this.c, Integer.valueOf(i), iArr);
                if (invoke == null) {
                    return -1;
                }
                return ((Integer) invoke).intValue();
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeIL.intValue;
    }
}
