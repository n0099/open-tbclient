package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.chromium.base.Callback;
/* compiled from: Callback.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class qac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Incorrect args count in method signature: (TT;)Ljava/lang/Runnable; */
    public static Runnable $default$bind(final Callback callback, final Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, callback, obj)) == null) {
            return new Runnable() { // from class: com.baidu.tieba.fac
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Callback.this.onResult(obj);
                    }
                }
            };
        }
        return (Runnable) invokeLL.objValue;
    }
}
