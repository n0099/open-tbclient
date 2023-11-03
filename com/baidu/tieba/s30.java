package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class s30 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile s30 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, r30> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100345, "Lcom/baidu/tieba/s30;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100345, "Lcom/baidu/tieba/s30;");
                return;
            }
        }
        b = AppConfig.isDebug();
        c = null;
    }

    public s30() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap(10);
    }

    public static s30 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (s30.class) {
                    if (c == null) {
                        c = new s30();
                    }
                }
            }
            return c;
        }
        return (s30) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c(str, System.currentTimeMillis());
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e(str, System.currentTimeMillis());
        }
    }

    public void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (!p30.a()) {
                if (b) {
                    Log.e("PlainEventMonitor", "keyevent is disable!");
                    return;
                }
                return;
            }
            r30 remove = this.a.remove(str);
            if (remove != null) {
                remove.d = j;
                q30.c().d(remove);
                return;
            }
            Log.e("PlainEventMonitor", "plain end event do not start:" + str);
        }
    }

    public void e(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            if (!p30.a()) {
                if (b) {
                    Log.e("PlainEventMonitor", "keyevent is disable!");
                }
            } else if (!TextUtils.isEmpty(str) && j > 0) {
                r30 r30Var = new r30(str);
                r30Var.c = j;
                this.a.put(str, r30Var);
            } else {
                Log.e("PlainEventMonitor", "name and timestamps error!");
            }
        }
    }
}
