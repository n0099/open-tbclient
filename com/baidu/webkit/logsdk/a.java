package com.baidu.webkit.logsdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f61024a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f61025b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            com.baidu.webkit.logsdk.a.b.a().a(str, str2, System.currentTimeMillis());
        }
    }

    public static boolean a(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bVar)) == null) ? com.baidu.webkit.logsdk.a.b.a().a(context, bVar) : invokeLL.booleanValue;
    }
}
