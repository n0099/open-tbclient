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
public class un4 extends gn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public un4() {
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

    @Override // com.baidu.tieba.gn4, com.baidu.tieba.jn4
    public void b(JSONObject jSONObject, tj4 tj4Var, @Nullable tj4 tj4Var2, @Nullable tj4 tj4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, tj4Var, tj4Var2, tj4Var3) != null) || jSONObject == null) {
            return;
        }
        wn4.b().e(jSONObject.optJSONObject("tipmsgs"));
        ao4.f().k(jSONObject.optJSONObject("page_tips"));
        sn4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        co4.a().d(jSONObject.optJSONObject("pkg_preload"));
        ko4.f(jSONObject.optJSONObject("app_inner_preload"));
        vn4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        ho4.b().d(jSONObject.optJSONObject("tts"));
        do4.a().e(jSONObject.optJSONObject("simple_control_item"));
        io4.e(jSONObject.optJSONObject("update_expire_time"));
        if (eo4.a) {
            c(jSONObject);
        }
        go4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        xn4.a().c(jSONObject.optJSONObject("local_debug"));
        jj4.a().b(jSONObject.optJSONObject(jj4.a().c()));
        if (fo4.b()) {
            zn4.a().b(jSONObject.optJSONObject("api_description"));
        }
        yn4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        hj4 b = jj4.b();
        as4 as4Var = null;
        if (b != null) {
            as4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            eo4.b = optString;
            if (as4Var != null) {
                as4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (as4Var != null) {
                    if (optInt > 0) {
                        as4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        as4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            eo4.a = false;
        }
    }
}
