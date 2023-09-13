package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class yv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, xv> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xv a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            synchronized (yv.class) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName() + "_preferences";
                }
                if (a == null) {
                    a = new HashMap<>();
                }
                if (a.get(str) != null) {
                    return a.get(str);
                }
                xv xvVar = new xv(str);
                a.put(str, xvVar);
                return xvVar;
            }
        }
        return (xv) invokeLL.objValue;
    }
}
