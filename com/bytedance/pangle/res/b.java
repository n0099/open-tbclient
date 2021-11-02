package com.bytedance.pangle.res;

import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
/* loaded from: classes11.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, layoutInflater) == null) {
            try {
                FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
            } catch (Throwable unused) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
            }
            try {
                FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
            } catch (Throwable unused2) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
            }
        }
    }
}
