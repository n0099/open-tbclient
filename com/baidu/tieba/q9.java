package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class q9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static k9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof k9) {
                return (k9) context;
            }
            if (context instanceof l9) {
                return ((l9) context).getPageContext();
            }
            Field b = mi.b(context.getClass(), p9.class);
            if (b == null || (a = mi.a(context, b)) == null || !(a instanceof p9) || !(a instanceof l9)) {
                return null;
            }
            return ((l9) a).getPageContext();
        }
        return (k9) invokeL.objValue;
    }

    public static p9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof p9) {
                return (p9) context;
            }
            if (context instanceof l9) {
                Object orignalPage = ((l9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof p9) {
                    return (p9) orignalPage;
                }
            }
            Field b = mi.b(context.getClass(), p9.class);
            if (b == null || (a = mi.a(context, b)) == null || !(a instanceof p9)) {
                return null;
            }
            return (p9) a;
        }
        return (p9) invokeL.objValue;
    }

    public static l9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof l9) {
                return (l9) context;
            }
            Field b = mi.b(context.getClass(), p9.class);
            if (b == null || (a = mi.a(context, b)) == null || !(a instanceof p9) || !(a instanceof l9)) {
                return null;
            }
            return (l9) a;
        }
        return (l9) invokeL.objValue;
    }
}
