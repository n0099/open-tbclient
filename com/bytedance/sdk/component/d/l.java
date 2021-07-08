package com.bytedance.sdk.component.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.d.c.a;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f28811a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, oVar) == null) {
            if (f28811a) {
                com.bytedance.sdk.component.d.c.c.a(ImageLoader.TAG, "already init!");
            }
            f28811a = true;
            if (oVar == null) {
                oVar = o.a(context);
            }
            com.bytedance.sdk.component.d.c.b.a(context, oVar);
        }
    }

    public static e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? new a.b().b(str) : (e) invokeL.objValue;
    }
}
