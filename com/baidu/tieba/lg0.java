package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class lg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            if (str2.length() > 2001) {
                int i = 0;
                while (i < str2.length()) {
                    int i2 = i + 2001;
                    if (i2 < str2.length()) {
                        b(3, str, str2.substring(i, i2));
                    } else {
                        b(3, str, str2.substring(i));
                    }
                    i = i2;
                }
                return;
            }
            b(3, str, str2);
        }
    }

    public static void b(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, null, i, str, str2) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                Log.d(str, str2);
                                return;
                            } else {
                                Log.e(str, str2);
                                return;
                            }
                        }
                        Log.w(str, str2);
                        return;
                    }
                    Log.i(str, str2);
                    return;
                }
                Log.d(str, str2);
                return;
            }
            Log.v(str, str2);
        }
    }
}
