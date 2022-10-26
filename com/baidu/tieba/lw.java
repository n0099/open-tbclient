package com.baidu.tieba;

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
/* loaded from: classes4.dex */
public final class lw {
    public static /* synthetic */ Interceptable $ic;
    public static lw b;
    public static HashMap c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448310658, "Lcom/baidu/tieba/lw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448310658, "Lcom/baidu/tieba/lw;");
                return;
            }
        }
        c = new HashMap();
    }

    public lw() {
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

    public static synchronized lw b() {
        InterceptResult invokeV;
        lw lwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (lw.class) {
                if (b == null) {
                    b = new lw();
                }
                lwVar = b;
            }
            return lwVar;
        }
        return (lw) invokeV.objValue;
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
            yw ywVar = (yw) c.get(str);
            if (ywVar == null) {
                ywVar = new yw(100);
                c.put(str, ywVar);
            }
            Integer num = (Integer) ywVar.c(str2);
            if (num == null) {
                try {
                    int identifier = b().getContext().getResources().getIdentifier(str2, str, b().getContext().getPackageName());
                    ywVar.d(str2, Integer.valueOf(identifier));
                    return identifier;
                } catch (Error e) {
                    e.printStackTrace();
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }
}
