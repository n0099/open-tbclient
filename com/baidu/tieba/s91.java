package com.baidu.tieba;

import android.content.Context;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.ab1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class s91 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final int b = 0;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a(Context context, int i);

        boolean b(HashMap<String, String> hashMap, int i);

        AbsNadBrowserView c(Context context, cb1 cb1Var, int i);

        void d(Context context, boolean z, int i, ab1.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106142, "Lcom/baidu/tieba/s91;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106142, "Lcom/baidu/tieba/s91;");
                return;
            }
        }
        a aVar = r91.a;
        Intrinsics.checkNotNullExpressionValue(aVar, "BuildConfig.BROWSER_FACTORY");
        a = aVar;
        c = 1;
    }

    public static final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return invokeV.intValue;
    }

    public static final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c;
        }
        return invokeV.intValue;
    }
}
