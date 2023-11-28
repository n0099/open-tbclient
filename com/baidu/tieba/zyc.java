package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.App;
import tbclient.FrsPage.AdkillerAd;
/* loaded from: classes9.dex */
public class zyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdkillerAd adkillerAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adkillerAd)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "tag", adkillerAd.tag);
            ltc.a(jSONObject, "game_url", adkillerAd.game_url);
            App app = adkillerAd.app;
            if (app != null) {
                ltc.a(jSONObject, "app", suc.b(app));
            }
            ltc.a(jSONObject, "can_close", adkillerAd.can_close);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
