package com.bytedance.sdk.component.adnet.core;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import java.io.File;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? a(context, (IHttpStack) null) : (l) invokeL.objValue;
    }

    public static l a(Context context, IHttpStack iHttpStack) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, iHttpStack)) == null) {
            if (iHttpStack == null) {
                iHttpStack = new j();
            }
            return a(context, new a(iHttpStack));
        }
        return (l) invokeLL.objValue;
    }

    public static l a(Context context, com.bytedance.sdk.component.adnet.face.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, bVar)) == null) {
            l lVar = new l(new f(new File(com.bytedance.sdk.component.adnet.a.b(context), "reqQueue")), bVar);
            lVar.a();
            return lVar;
        }
        return (l) invokeLL.objValue;
    }
}
