package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.VideoActive;
/* loaded from: classes8.dex */
public class u5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoActive videoActive) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoActive)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", videoActive.id);
            poc.a(jSONObject, "active_name", videoActive.active_name);
            poc.a(jSONObject, "active_url", videoActive.active_url);
            poc.a(jSONObject, "native_url", videoActive.native_url);
            poc.a(jSONObject, "description", videoActive.description);
            poc.a(jSONObject, "banner_url", videoActive.banner_url);
            poc.a(jSONObject, "remark", videoActive.remark);
            if (videoActive.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : videoActive.thread_list) {
                    jSONArray.put(u4d.b(threadInfo));
                }
                poc.a(jSONObject, "thread_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
