package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                return ol.d(context.getApplicationContext().getClassLoader(), str);
            } catch (Throwable th) {
                Log.e("soloader", "loadSoFile error " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
