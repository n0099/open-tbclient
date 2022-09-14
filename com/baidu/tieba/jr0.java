package com.baidu.tieba;

import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
@JvmName(name = "AuthParser")
/* loaded from: classes4.dex */
public final class jr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final hr0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str != null) {
                try {
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("hosts");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                String host = optJSONObject.optString("host");
                                String optString = optJSONObject.optString("auth");
                                Intrinsics.checkNotNullExpressionValue(host, "host");
                                arrayList.add(new gr0(host, b(optString)));
                            }
                        }
                        return new hr0(arrayList);
                    }
                    return null;
                } catch (Exception e) {
                    jj0.a("AuthParser", e.getMessage());
                }
            }
            return null;
        }
        return (hr0) invokeL.objValue;
    }

    public static final ir0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
                if (split$default.size() < 4) {
                    return null;
                }
                return new ir0(BdVideoSeries.parseIntSafe((String) split$default.get(0), 0), BdVideoSeries.parseIntSafe((String) split$default.get(1), 0), BdVideoSeries.parseIntSafe((String) split$default.get(2), 0), BdVideoSeries.parseIntSafe((String) split$default.get(3), 0));
            }
            return null;
        }
        return (ir0) invokeL.objValue;
    }
}
