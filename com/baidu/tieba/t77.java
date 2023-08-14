package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FeedKV;
/* loaded from: classes8.dex */
public final class t77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(List<FeedKV> list, String key) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, list, key)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            for (FeedKV feedKV : list) {
                if (Intrinsics.areEqual(feedKV.key, key)) {
                    return feedKV.value;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static final List<d77> b(List<FeedKV> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            ArrayList arrayList = new ArrayList();
            for (FeedKV feedKV : list) {
                String str = feedKV.key;
                Intrinsics.checkNotNullExpressionValue(str, "kv.key");
                d77 d77Var = new d77(str, null, null, null, null, 30, null);
                Map<String, String> d = d77Var.d();
                try {
                    JSONObject jSONObject = new JSONObject(feedKV.value);
                    if (d instanceof HashMap) {
                        Iterator<String> keys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
                        while (keys.hasNext()) {
                            String key = keys.next();
                            if (!Intrinsics.areEqual(key, "position_name")) {
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                String optString = jSONObject.optString(key);
                                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(key)");
                                d.put(key, optString);
                            }
                        }
                    }
                    String optString2 = jSONObject.optString("position_name");
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"position_name\")");
                    d77Var.g(optString2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                arrayList.add(d77Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
