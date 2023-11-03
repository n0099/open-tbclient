package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VideoDesc;
/* loaded from: classes8.dex */
public class w5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoDesc videoDesc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoDesc)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "video_id", videoDesc.video_id);
            poc.a(jSONObject, VideoFinishResult.KEY_VIDEO_MD5, videoDesc.video_md5);
            poc.a(jSONObject, "video_url", videoDesc.video_url);
            poc.a(jSONObject, "video_width", videoDesc.video_width);
            poc.a(jSONObject, "video_height", videoDesc.video_height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
