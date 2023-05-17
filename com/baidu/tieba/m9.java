package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class m9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static g9<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof g9) {
                return (g9) context;
            }
            if (context instanceof h9) {
                return ((h9) context).getPageContext();
            }
            Field b = ii.b(context.getClass(), l9.class);
            if (b == null || (a = ii.a(context, b)) == null || !(a instanceof l9) || !(a instanceof h9)) {
                return null;
            }
            return ((h9) a).getPageContext();
        }
        return (g9) invokeL.objValue;
    }

    public static l9 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof l9) {
                return (l9) context;
            }
            if (context instanceof h9) {
                Object orignalPage = ((h9) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof l9) {
                    return (l9) orignalPage;
                }
            }
            Field b = ii.b(context.getClass(), l9.class);
            if (b == null || (a = ii.a(context, b)) == null || !(a instanceof l9)) {
                return null;
            }
            return (l9) a;
        }
        return (l9) invokeL.objValue;
    }

    public static h9<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof h9) {
                return (h9) context;
            }
            Field b = ii.b(context.getClass(), l9.class);
            if (b == null || (a = ii.a(context, b)) == null || !(a instanceof l9) || !(a instanceof h9)) {
                return null;
            }
            return (h9) a;
        }
        return (h9) invokeL.objValue;
    }
}
