package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.core.BdCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public final class xw {
    public static /* synthetic */ Interceptable $ic;
    public static xw b;
    public static HashMap<String, kx<String, Integer>> c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448322190, "Lcom/baidu/tieba/xw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448322190, "Lcom/baidu/tieba/xw;");
                return;
            }
        }
        c = new HashMap<>();
    }

    public xw() {
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
        new LongSparseArray();
    }

    public static synchronized xw b() {
        InterceptResult invokeV;
        xw xwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (xw.class) {
                if (b == null) {
                    b = new xw();
                }
                xwVar = b;
            }
            return xwVar;
        }
        return (xw) invokeV.objValue;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.a == null) {
                this.a = BdCore.a().getContext();
            }
            Context context = this.a;
            if (context != null) {
                return context;
            }
            throw new RuntimeException("context is null!");
        }
        return (Context) invokeV.objValue;
    }

    @Deprecated
    public static int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            a(str2, str);
            kx<String, Integer> kxVar = c.get(str);
            if (kxVar == null) {
                kxVar = new kx<>(100);
                c.put(str, kxVar);
            }
            Integer c2 = kxVar.c(str2);
            if (c2 == null) {
                try {
                    int identifier = b().getContext().getResources().getIdentifier(str2, str, b().getContext().getPackageName());
                    kxVar.d(str2, Integer.valueOf(identifier));
                    return identifier;
                } catch (Error e) {
                    e.printStackTrace();
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return c2.intValue();
        }
        return invokeLL.intValue;
    }
}
