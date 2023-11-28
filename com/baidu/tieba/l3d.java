package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.FrsVideo;
/* loaded from: classes7.dex */
public class l3d extends ltc {
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
                ltc.a(jSONObject, "video_act", ptc.b(actBtn));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
