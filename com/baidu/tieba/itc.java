package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedVideoComponent;
import tbclient.VideoField;
/* loaded from: classes6.dex */
public class itc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedVideoComponent feedVideoComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedVideoComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            VideoField videoField = feedVideoComponent.video_info;
            if (videoField != null) {
                qoc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, y5d.b(videoField));
            }
            qoc.a(jSONObject, "schema", feedVideoComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
