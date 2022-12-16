package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
/* loaded from: classes6.dex */
public class ug9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210178, "Lcom/baidu/tieba/ug9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210178, "Lcom/baidu/tieba/ug9;");
                return;
            }
        }
        a = tf9.m();
    }

    public static void a(Cursor cursor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, cursor) == null) && cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
