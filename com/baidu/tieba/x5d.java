package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VideoDesc;
/* loaded from: classes9.dex */
public class x5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoDesc videoDesc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoDesc)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "video_id", videoDesc.video_id);
            qoc.a(jSONObject, VideoFinishResult.KEY_VIDEO_MD5, videoDesc.video_md5);
            qoc.a(jSONObject, "video_url", videoDesc.video_url);
            qoc.a(jSONObject, "video_width", videoDesc.video_width);
            qoc.a(jSONObject, "video_height", videoDesc.video_height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
