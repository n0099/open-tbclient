package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.FrsVideo;
/* loaded from: classes6.dex */
public class iyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsVideo frsVideo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsVideo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ActBtn actBtn = frsVideo.video_act;
            if (actBtn != null) {
                qoc.a(jSONObject, "video_act", uoc.b(actBtn));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
