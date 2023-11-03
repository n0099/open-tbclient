package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.AcrossForumIcon;
/* loaded from: classes9.dex */
public class xtc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AcrossForumIcon acrossForumIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, acrossForumIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon_url", acrossForumIcon.icon_url);
            poc.a(jSONObject, "pic_type", acrossForumIcon.pic_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
