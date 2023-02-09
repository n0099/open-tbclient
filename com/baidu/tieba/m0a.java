package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class m0a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final Method b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947920235, "Lcom/baidu/tieba/m0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947920235, "Lcom/baidu/tieba/m0a;");
                return;
            }
        }
        try {
            a = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            b = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th) {
            b(th);
            throw null;
        }
    }

    public static void a(Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, canvas, i) == null) {
            try {
                b.invoke(canvas, Integer.valueOf(i));
            } catch (Throwable th) {
                b(th);
                throw null;
            }
        }
    }

    public static RuntimeException b(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            if (th == null) {
                throw new NullPointerException("t");
            }
            c(th);
            throw null;
        }
        return (RuntimeException) invokeL.objValue;
    }

    public static <T extends Throwable> T c(Throwable th) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            throw th;
        }
        return (T) invokeL.objValue;
    }
}
