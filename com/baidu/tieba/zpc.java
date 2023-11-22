package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AvatarFrame;
/* loaded from: classes9.dex */
public class zpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AvatarFrame avatarFrame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, avatarFrame)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "props_id", avatarFrame.props_id);
            qoc.a(jSONObject, "end_time", avatarFrame.end_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
