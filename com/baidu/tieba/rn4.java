package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rn4 extends dn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rn4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.dn4, com.baidu.tieba.gn4
    public void b(JSONObject jSONObject, qj4 qj4Var, @Nullable qj4 qj4Var2, @Nullable qj4 qj4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, qj4Var, qj4Var2, qj4Var3) != null) || jSONObject == null) {
            return;
        }
        tn4.b().e(jSONObject.optJSONObject("tipmsgs"));
        xn4.f().k(jSONObject.optJSONObject("page_tips"));
        pn4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        zn4.a().d(jSONObject.optJSONObject("pkg_preload"));
        ho4.f(jSONObject.optJSONObject("app_inner_preload"));
        sn4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        eo4.b().d(jSONObject.optJSONObject("tts"));
        ao4.a().e(jSONObject.optJSONObject("simple_control_item"));
        fo4.e(jSONObject.optJSONObject("update_expire_time"));
        if (bo4.a) {
            c(jSONObject);
        }
        do4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        un4.a().c(jSONObject.optJSONObject("local_debug"));
        gj4.a().b(jSONObject.optJSONObject(gj4.a().c()));
        if (co4.b()) {
            wn4.a().b(jSONObject.optJSONObject("api_description"));
        }
        vn4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        ej4 b = gj4.b();
        xr4 xr4Var = null;
        if (b != null) {
            xr4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            bo4.b = optString;
            if (xr4Var != null) {
                xr4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (xr4Var != null) {
                    if (optInt > 0) {
                        xr4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        xr4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            bo4.a = false;
        }
    }
}
