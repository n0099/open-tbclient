package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SmartApp smartApp) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, smartApp)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "avatar", smartApp.avatar);
            poc.a(jSONObject, "name", smartApp.name);
            poc.a(jSONObject, "abstract", smartApp._abstract);
            poc.a(jSONObject, "pic", smartApp.pic);
            poc.a(jSONObject, "h5_url", smartApp.h5_url);
            poc.a(jSONObject, "id", smartApp.id);
            poc.a(jSONObject, "link", smartApp.link);
            poc.a(jSONObject, "naws_app_id", smartApp.naws_app_id);
            poc.a(jSONObject, "is_recom", smartApp.is_recom);
            poc.a(jSONObject, "is_game", smartApp.is_game);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
