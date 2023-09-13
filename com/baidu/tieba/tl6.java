package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class tl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, dm6> a;
    public final Map<String, dm6> b;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final tl6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-399879923, "Lcom/baidu/tieba/tl6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-399879923, "Lcom/baidu/tieba/tl6$b;");
                    return;
                }
            }
            a = new tl6(null);
        }
    }

    public tl6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public static tl6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (tl6) invokeV.objValue;
    }

    public /* synthetic */ tl6(a aVar) {
        this();
    }

    public dm6 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.b.get(str);
        }
        return (dm6) invokeL.objValue;
    }

    public dm6 g(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            if (uri != null && !TextUtils.isEmpty(uri.getPath())) {
                return this.a.get(uri.getPath());
            }
            return null;
        }
        return (dm6) invokeL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b.remove(str);
        }
    }

    public void j(Map<String, dm6> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) {
            this.a.clear();
            if (!mn6.b(map)) {
                this.a.putAll(map);
            }
        }
    }

    public void a(String str, dm6 dm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dm6Var) == null) {
            this.b.put(str, dm6Var);
        }
    }

    public void k(String str, Map<String, dm6> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, map) == null) {
            i(str);
            this.a.putAll(map);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !mn6.b(this.a)) {
            for (String str : this.a.keySet()) {
                dm6 dm6Var = this.a.get(str);
                if (dm6Var != null) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.i("Offline", "设置所有离线包可用：" + str);
                    dm6Var.g = true;
                }
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        TbLog hybridLog = HybridLog.getInstance();
        hybridLog.i("Offline", "设置单个离线包可用：" + str);
        for (String str2 : this.a.keySet()) {
            dm6 dm6Var = this.a.get(str2);
            if (dm6Var != null && str.equals(dm6Var.c)) {
                dm6Var.g = true;
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        TbLog hybridLog = HybridLog.getInstance();
        hybridLog.i("Offline", "设置单个离线包禁用：" + str);
        for (String str2 : this.a.keySet()) {
            dm6 dm6Var = this.a.get(str2);
            if (dm6Var != null && str.equals(dm6Var.c)) {
                dm6Var.g = false;
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<String> it = this.a.keySet().iterator();
        while (it.hasNext()) {
            dm6 dm6Var = this.a.get(it.next());
            if (dm6Var != null && str.equals(dm6Var.c)) {
                it.remove();
            }
        }
    }
}
