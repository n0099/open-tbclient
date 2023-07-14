package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class r9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof l9) {
                return (l9) context;
            }
            if (context instanceof m9) {
                return ((m9) context).getPageContext();
            }
            Field b = pi.b(context.getClass(), q9.class);
            if (b == null || (a = pi.a(context, b)) == null || !(a instanceof q9) || !(a instanceof m9)) {
                return null;
            }
            return ((m9) a).getPageContext();
        }
        return (l9) invokeL.objValue;
    }

    public static q9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof q9) {
                return (q9) context;
            }
            if (context instanceof m9) {
                Object orignalPage = ((m9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof q9) {
                    return (q9) orignalPage;
                }
            }
            Field b = pi.b(context.getClass(), q9.class);
            if (b == null || (a = pi.a(context, b)) == null || !(a instanceof q9)) {
                return null;
            }
            return (q9) a;
        }
        return (q9) invokeL.objValue;
    }

    public static m9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof m9) {
                return (m9) context;
            }
            Field b = pi.b(context.getClass(), q9.class);
            if (b == null || (a = pi.a(context, b)) == null || !(a instanceof q9) || !(a instanceof m9)) {
                return null;
            }
            return (m9) a;
        }
        return (m9) invokeL.objValue;
    }
}
