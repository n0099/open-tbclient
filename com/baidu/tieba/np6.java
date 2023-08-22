package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class np6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T> void a(JSONObject jSONObject, String key, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, jSONObject, key, t) == null) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                jSONObject.put(key, t);
            } catch (JSONException unused) {
            }
        }
    }
}
