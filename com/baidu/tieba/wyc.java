package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.AcrossForumIcon;
/* loaded from: classes9.dex */
public class wyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AcrossForumIcon acrossForumIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, acrossForumIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon_url", acrossForumIcon.icon_url);
            ltc.a(jSONObject, "pic_type", acrossForumIcon.pic_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
