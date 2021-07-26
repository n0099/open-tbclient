package com.bytedance.sdk.openadsdk.core.h;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.e.d;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, context, mVar) == null) && o.a(mVar)) {
            d.j(context, mVar, "playable_preload", "preload_start", null);
        }
    }

    public static void a(Context context, m mVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, mVar, Long.valueOf(j), Long.valueOf(j2)}) == null) && o.a(mVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("loadzip_success_time", Long.valueOf(j));
            hashMap.put("unzip_success_time", Long.valueOf(j2));
            d.j(context, mVar, "playable_preload", "preload_success", hashMap);
        }
    }

    public static void a(Context context, m mVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(65537, null, context, mVar, i2, str) == null) && o.a(mVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_code", Integer.valueOf(i2));
            hashMap.put(LoadErrorCode.Statistics.KEY_ERROR_REASON, str);
            d.j(context, mVar, "playable_preload", "preload_fail", hashMap);
        }
    }
}
