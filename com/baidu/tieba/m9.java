package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class m9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static BdPageContext<?> a(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof BdPageContext) {
                return (BdPageContext) context;
            }
            if (context instanceof BdPageContextSupport) {
                return ((BdPageContextSupport) context).getPageContext();
            }
            Field b = vh.b(context.getClass(), l9.class);
            if (b == null || (a = vh.a(context, b)) == null || !(a instanceof l9) || !(a instanceof BdPageContextSupport)) {
                return null;
            }
            return ((BdPageContextSupport) a).getPageContext();
        }
        return (BdPageContext) invokeL.objValue;
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
            if (context instanceof BdPageContextSupport) {
                Object orignalPage = ((BdPageContextSupport) context).getPageContext().getOrignalPage();
                if (orignalPage instanceof l9) {
                    return (l9) orignalPage;
                }
            }
            Field b = vh.b(context.getClass(), l9.class);
            if (b == null || (a = vh.a(context, b)) == null || !(a instanceof l9)) {
                return null;
            }
            return (l9) a;
        }
        return (l9) invokeL.objValue;
    }

    public static BdPageContextSupport<?> b(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof BdPageContextSupport) {
                return (BdPageContextSupport) context;
            }
            Field b = vh.b(context.getClass(), l9.class);
            if (b == null || (a = vh.a(context, b)) == null || !(a instanceof l9) || !(a instanceof BdPageContextSupport)) {
                return null;
            }
            return (BdPageContextSupport) a;
        }
        return (BdPageContextSupport) invokeL.objValue;
    }
}
