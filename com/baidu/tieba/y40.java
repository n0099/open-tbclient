package com.baidu.tieba;

import android.content.Context;
import com.baidu.tieba.a50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class y40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, a50.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, aVar)) == null) {
            if (context == null) {
                aVar.a(false, null);
                return null;
            }
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                if (cls != null) {
                    Object newInstance = cls.newInstance();
                    Method method = cls.getMethod("getOAID", Context.class);
                    method.setAccessible(true);
                    if (newInstance != null && method != null) {
                        String str = (String) method.invoke(newInstance, context);
                        aVar.a(true, str);
                        return str;
                    }
                }
            } catch (Throwable unused) {
                aVar.a(false, null);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
