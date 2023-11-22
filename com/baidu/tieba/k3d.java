package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class k3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SmartApp smartApp) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, smartApp)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "avatar", smartApp.avatar);
            qoc.a(jSONObject, "name", smartApp.name);
            qoc.a(jSONObject, "abstract", smartApp._abstract);
            qoc.a(jSONObject, "pic", smartApp.pic);
            qoc.a(jSONObject, "h5_url", smartApp.h5_url);
            qoc.a(jSONObject, "id", smartApp.id);
            qoc.a(jSONObject, "link", smartApp.link);
            qoc.a(jSONObject, "naws_app_id", smartApp.naws_app_id);
            qoc.a(jSONObject, "is_recom", smartApp.is_recom);
            qoc.a(jSONObject, "is_game", smartApp.is_game);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
