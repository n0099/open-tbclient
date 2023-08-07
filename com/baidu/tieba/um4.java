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
/* loaded from: classes8.dex */
public class um4 extends gm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public um4() {
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

    @Override // com.baidu.tieba.gm4, com.baidu.tieba.jm4
    public void b(JSONObject jSONObject, ti4 ti4Var, @Nullable ti4 ti4Var2, @Nullable ti4 ti4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, ti4Var, ti4Var2, ti4Var3) != null) || jSONObject == null) {
            return;
        }
        wm4.b().e(jSONObject.optJSONObject("tipmsgs"));
        an4.f().k(jSONObject.optJSONObject("page_tips"));
        sm4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        cn4.a().d(jSONObject.optJSONObject("pkg_preload"));
        kn4.f(jSONObject.optJSONObject("app_inner_preload"));
        vm4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        hn4.b().d(jSONObject.optJSONObject("tts"));
        dn4.a().e(jSONObject.optJSONObject("simple_control_item"));
        in4.e(jSONObject.optJSONObject("update_expire_time"));
        if (en4.a) {
            c(jSONObject);
        }
        gn4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        xm4.a().c(jSONObject.optJSONObject("local_debug"));
        ji4.a().b(jSONObject.optJSONObject(ji4.a().c()));
        if (fn4.b()) {
            zm4.a().b(jSONObject.optJSONObject("api_description"));
        }
        ym4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        hi4 b = ji4.b();
        ar4 ar4Var = null;
        if (b != null) {
            ar4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            en4.b = optString;
            if (ar4Var != null) {
                ar4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (ar4Var != null) {
                    if (optInt > 0) {
                        ar4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        ar4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            en4.a = false;
        }
    }
}
