package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class y9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static s9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof s9) {
                return (s9) context;
            }
            if (context instanceof t9) {
                return ((t9) context).getPageContext();
            }
            Field b = qi.b(context.getClass(), x9.class);
            if (b == null || (a = qi.a(context, b)) == null || !(a instanceof x9) || !(a instanceof t9)) {
                return null;
            }
            return ((t9) a).getPageContext();
        }
        return (s9) invokeL.objValue;
    }

    public static x9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof x9) {
                return (x9) context;
            }
            if (context instanceof t9) {
                Object orignalPage = ((t9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof x9) {
                    return (x9) orignalPage;
                }
            }
            Field b = qi.b(context.getClass(), x9.class);
            if (b == null || (a = qi.a(context, b)) == null || !(a instanceof x9)) {
                return null;
            }
            return (x9) a;
        }
        return (x9) invokeL.objValue;
    }

    public static t9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof t9) {
                return (t9) context;
            }
            Field b = qi.b(context.getClass(), x9.class);
            if (b == null || (a = qi.a(context, b)) == null || !(a instanceof x9) || !(a instanceof t9)) {
                return null;
            }
            return (t9) a;
        }
        return (t9) invokeL.objValue;
    }
}
