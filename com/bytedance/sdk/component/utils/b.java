package com.bytedance.sdk.component.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(Throwable th);
    }

    public static boolean a(Context context, Intent intent, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, intent, aVar)) == null) {
            if (context != null && intent != null) {
                try {
                    if (!(context instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    context.startActivity(intent);
                    if (aVar != null) {
                        aVar.a();
                        return true;
                    }
                    return true;
                } catch (Throwable th) {
                    if (aVar != null) {
                        aVar.a(th);
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
