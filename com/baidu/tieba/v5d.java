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
public class v5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoActive videoActive) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoActive)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", videoActive.id);
            qoc.a(jSONObject, "active_name", videoActive.active_name);
            qoc.a(jSONObject, "active_url", videoActive.active_url);
            qoc.a(jSONObject, "native_url", videoActive.native_url);
            qoc.a(jSONObject, "description", videoActive.description);
            qoc.a(jSONObject, "banner_url", videoActive.banner_url);
            qoc.a(jSONObject, "remark", videoActive.remark);
            if (videoActive.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : videoActive.thread_list) {
                    jSONArray.put(v4d.b(threadInfo));
                }
                qoc.a(jSONObject, "thread_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
