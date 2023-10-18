package com.baidu.tieba;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VideoDesc;
/* loaded from: classes8.dex */
public class xy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static VideoDesc a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            VideoDesc.Builder builder = new VideoDesc.Builder();
            if (jSONObject != null) {
                builder.video_id = Integer.valueOf(jSONObject.optInt("video_id"));
                builder.video_md5 = jSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
                builder.video_url = jSONObject.optString("video_url");
                builder.video_width = jSONObject.optString("video_width");
                builder.video_height = jSONObject.optString("video_height");
            }
            return builder.build(true);
        }
        return (VideoDesc) invokeL.objValue;
    }
}
