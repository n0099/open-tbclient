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
public class xad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoActive videoActive) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoActive)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", videoActive.id);
            ktc.a(jSONObject, "active_name", videoActive.active_name);
            ktc.a(jSONObject, "active_url", videoActive.active_url);
            ktc.a(jSONObject, "native_url", videoActive.native_url);
            ktc.a(jSONObject, "description", videoActive.description);
            ktc.a(jSONObject, "banner_url", videoActive.banner_url);
            ktc.a(jSONObject, "remark", videoActive.remark);
            if (videoActive.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : videoActive.thread_list) {
                    jSONArray.put(x9d.b(threadInfo));
                }
                ktc.a(jSONObject, "thread_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
