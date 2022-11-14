package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class x9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static r9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof r9) {
                return (r9) context;
            }
            if (context instanceof s9) {
                return ((s9) context).getPageContext();
            }
            Field b = pi.b(context.getClass(), w9.class);
            if (b == null || (a = pi.a(context, b)) == null || !(a instanceof w9) || !(a instanceof s9)) {
                return null;
            }
            return ((s9) a).getPageContext();
        }
        return (r9) invokeL.objValue;
    }

    public static w9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof w9) {
                return (w9) context;
            }
            if (context instanceof s9) {
                Object orignalPage = ((s9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof w9) {
                    return (w9) orignalPage;
                }
            }
            Field b = pi.b(context.getClass(), w9.class);
            if (b == null || (a = pi.a(context, b)) == null || !(a instanceof w9)) {
                return null;
            }
            return (w9) a;
        }
        return (w9) invokeL.objValue;
    }

    public static s9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof s9) {
                return (s9) context;
            }
            Field b = pi.b(context.getClass(), w9.class);
            if (b == null || (a = pi.a(context, b)) == null || !(a instanceof w9) || !(a instanceof s9)) {
                return null;
            }
            return (s9) a;
        }
        return (s9) invokeL.objValue;
    }
}
