package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class rz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile rz1 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public HashMap<String, Long> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948138816, "Lcom/baidu/tieba/rz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948138816, "Lcom/baidu/tieba/rz1;");
                return;
            }
        }
        c = kh1.a;
    }

    public rz1() {
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
        this.a = false;
        this.b = new HashMap<>();
    }

    public static rz1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (rz1.class) {
                    if (d == null) {
                        d = new rz1();
                    }
                }
            }
            return d;
        }
        return (rz1) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            HashMap<String, Long> hashMap = this.b;
            if (hashMap != null && hashMap.containsKey(str) && currentTimeMillis - this.b.get(str).longValue() <= 18000000) {
                if (c) {
                    Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
                    return true;
                }
                return true;
            }
            if (c) {
                HashMap<String, Long> hashMap2 = this.b;
                if (hashMap2 != null && hashMap2.containsKey(str)) {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.b.get(str) + " ，id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
