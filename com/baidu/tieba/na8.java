package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URI;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class na8 {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947995844, "Lcom/baidu/tieba/na8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947995844, "Lcom/baidu/tieba/na8;");
                return;
            }
        }
        a = TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid-usergrow-search/searchGlobal?nonavigationbar=1&customfullscreen=1&user_skin_overlay=0&loadingSignal=1&page_key=a026";
    }

    public static final String a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            try {
                String aSCIIString = new URI(null, null, str, null).toASCIIString();
                Intrinsics.checkNotNullExpressionValue(aSCIIString, "URI(null, null, value, null).toASCIIString()");
                return aSCIIString;
            } catch (Exception e) {
                BdLog.e(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
