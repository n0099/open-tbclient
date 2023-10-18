package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class k4 {
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
            Field b = sc.b(context.getClass(), j4.class);
            if (b == null || (a = sc.a(context, b)) == null || !(a instanceof j4) || !(a instanceof BdPageContextSupport)) {
                return null;
            }
            return ((BdPageContextSupport) a).getPageContext();
        }
        return (BdPageContext) invokeL.objValue;
    }

    public static j4 c(Context context) {
        InterceptResult invokeL;
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (context instanceof j4) {
                return (j4) context;
            }
            if (context instanceof BdPageContextSupport) {
                BdPageContextSupport bdPageContextSupport = (BdPageContextSupport) context;
                if (bdPageContextSupport.getPageContext() == null) {
                    return null;
                }
                Object orignalPage = bdPageContextSupport.getPageContext().getOrignalPage();
                if (orignalPage instanceof j4) {
                    return (j4) orignalPage;
                }
            }
            Field b = sc.b(context.getClass(), j4.class);
            if (b == null || (a = sc.a(context, b)) == null || !(a instanceof j4)) {
                return null;
            }
            return (j4) a;
        }
        return (j4) invokeL.objValue;
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
            Field b = sc.b(context.getClass(), j4.class);
            if (b == null || (a = sc.a(context, b)) == null || !(a instanceof j4) || !(a instanceof BdPageContextSupport)) {
                return null;
            }
            return (BdPageContextSupport) a;
        }
        return (BdPageContextSupport) invokeL.objValue;
    }
}
