package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.AcrossForumIcon;
/* loaded from: classes8.dex */
public class vyc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AcrossForumIcon acrossForumIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, acrossForumIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon_url", acrossForumIcon.icon_url);
            ktc.a(jSONObject, "pic_type", acrossForumIcon.pic_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
