package com.baidu.tieba;

import android.text.TextUtils;
import android.util.JsonWriter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(JsonWriter jsonWriter, Object obj) throws IOException {
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jsonWriter, obj) == null) {
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    jsonWriter.beginArray();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        Object opt2 = jSONArray.opt(i);
                        if (opt2 != null) {
                            a(jsonWriter, opt2);
                        }
                    }
                    jsonWriter.endArray();
                    return;
                } else if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    jsonWriter.beginObject();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (opt = jSONObject.opt(next)) != null) {
                            jsonWriter.name(next);
                            a(jsonWriter, opt);
                        }
                    }
                    jsonWriter.endObject();
                    return;
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                    return;
                } else if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                    return;
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                    return;
                } else {
                    jsonWriter.value(obj.toString());
                    return;
                }
            }
            jsonWriter.nullValue();
        }
    }
}
