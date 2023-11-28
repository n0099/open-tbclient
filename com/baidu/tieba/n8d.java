package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class n8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SmartApp smartApp) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, smartApp)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "avatar", smartApp.avatar);
            ltc.a(jSONObject, "name", smartApp.name);
            ltc.a(jSONObject, "abstract", smartApp._abstract);
            ltc.a(jSONObject, pic.f, smartApp.pic);
            ltc.a(jSONObject, "h5_url", smartApp.h5_url);
            ltc.a(jSONObject, "id", smartApp.id);
            ltc.a(jSONObject, "link", smartApp.link);
            ltc.a(jSONObject, "naws_app_id", smartApp.naws_app_id);
            ltc.a(jSONObject, "is_recom", smartApp.is_recom);
            ltc.a(jSONObject, "is_game", smartApp.is_game);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
