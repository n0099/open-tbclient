package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoActive;
/* loaded from: classes9.dex */
public class yad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoActive videoActive) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoActive)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", videoActive.id);
            ltc.a(jSONObject, "active_name", videoActive.active_name);
            ltc.a(jSONObject, "active_url", videoActive.active_url);
            ltc.a(jSONObject, "native_url", videoActive.native_url);
            ltc.a(jSONObject, "description", videoActive.description);
            ltc.a(jSONObject, "banner_url", videoActive.banner_url);
            ltc.a(jSONObject, "remark", videoActive.remark);
            if (videoActive.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : videoActive.thread_list) {
                    jSONArray.put(y9d.b(threadInfo));
                }
                ltc.a(jSONObject, "thread_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
