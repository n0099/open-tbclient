package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Video;
/* loaded from: classes8.dex */
public class u2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Video video) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, video)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pic", video.pic);
            ktc.a(jSONObject, "num", video.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
