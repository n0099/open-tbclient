package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AvatarFrame;
/* loaded from: classes8.dex */
public class wuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AvatarFrame avatarFrame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, avatarFrame)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", avatarFrame.props_id);
            ltc.a(jSONObject, "end_time", avatarFrame.end_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
