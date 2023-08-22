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
/* loaded from: classes9.dex */
public class zm4 extends lm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zm4() {
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

    @Override // com.baidu.tieba.lm4, com.baidu.tieba.om4
    public void b(JSONObject jSONObject, yi4 yi4Var, @Nullable yi4 yi4Var2, @Nullable yi4 yi4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, yi4Var, yi4Var2, yi4Var3) != null) || jSONObject == null) {
            return;
        }
        bn4.b().e(jSONObject.optJSONObject("tipmsgs"));
        fn4.f().k(jSONObject.optJSONObject("page_tips"));
        xm4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        hn4.a().d(jSONObject.optJSONObject("pkg_preload"));
        pn4.f(jSONObject.optJSONObject("app_inner_preload"));
        an4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        mn4.b().d(jSONObject.optJSONObject("tts"));
        in4.a().e(jSONObject.optJSONObject("simple_control_item"));
        nn4.e(jSONObject.optJSONObject("update_expire_time"));
        if (jn4.a) {
            c(jSONObject);
        }
        ln4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        cn4.a().c(jSONObject.optJSONObject("local_debug"));
        oi4.a().b(jSONObject.optJSONObject(oi4.a().c()));
        if (kn4.b()) {
            en4.a().b(jSONObject.optJSONObject("api_description"));
        }
        dn4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        mi4 b = oi4.b();
        fr4 fr4Var = null;
        if (b != null) {
            fr4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            jn4.b = optString;
            if (fr4Var != null) {
                fr4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (fr4Var != null) {
                    if (optInt > 0) {
                        fr4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        fr4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            jn4.a = false;
        }
    }
}
