package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class m8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SmartApp smartApp) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, smartApp)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "avatar", smartApp.avatar);
            ktc.a(jSONObject, "name", smartApp.name);
            ktc.a(jSONObject, "abstract", smartApp._abstract);
            ktc.a(jSONObject, "pic", smartApp.pic);
            ktc.a(jSONObject, "h5_url", smartApp.h5_url);
            ktc.a(jSONObject, "id", smartApp.id);
            ktc.a(jSONObject, "link", smartApp.link);
            ktc.a(jSONObject, "naws_app_id", smartApp.naws_app_id);
            ktc.a(jSONObject, "is_recom", smartApp.is_recom);
            ktc.a(jSONObject, "is_game", smartApp.is_game);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
