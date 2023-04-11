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
/* loaded from: classes6.dex */
public final class tv {
    public static /* synthetic */ Interceptable $ic;
    public static tv b;
    public static HashMap<String, gw<String, Integer>> c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318315, "Lcom/baidu/tieba/tv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318315, "Lcom/baidu/tieba/tv;");
                return;
            }
        }
        c = new HashMap<>();
    }

    public tv() {
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

    public static synchronized tv b() {
        InterceptResult invokeV;
        tv tvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (tv.class) {
                if (b == null) {
                    b = new tv();
                }
                tvVar = b;
            }
            return tvVar;
        }
        return (tv) invokeV.objValue;
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
            gw<String, Integer> gwVar = c.get(str);
            if (gwVar == null) {
                gwVar = new gw<>(100);
                c.put(str, gwVar);
            }
            Integer c2 = gwVar.c(str2);
            if (c2 == null) {
                try {
                    int identifier = b().getContext().getResources().getIdentifier(str2, str, b().getContext().getPackageName());
                    gwVar.d(str2, Integer.valueOf(identifier));
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
