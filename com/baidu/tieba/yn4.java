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
public class yn4 extends kn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yn4() {
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

    @Override // com.baidu.tieba.kn4, com.baidu.tieba.nn4
    public void b(JSONObject jSONObject, xj4 xj4Var, @Nullable xj4 xj4Var2, @Nullable xj4 xj4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, xj4Var, xj4Var2, xj4Var3) != null) || jSONObject == null) {
            return;
        }
        ao4.b().e(jSONObject.optJSONObject("tipmsgs"));
        eo4.f().k(jSONObject.optJSONObject("page_tips"));
        wn4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        go4.a().d(jSONObject.optJSONObject("pkg_preload"));
        oo4.f(jSONObject.optJSONObject("app_inner_preload"));
        zn4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        lo4.b().d(jSONObject.optJSONObject("tts"));
        ho4.a().e(jSONObject.optJSONObject("simple_control_item"));
        mo4.e(jSONObject.optJSONObject("update_expire_time"));
        if (io4.a) {
            c(jSONObject);
        }
        ko4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        bo4.a().c(jSONObject.optJSONObject("local_debug"));
        nj4.a().b(jSONObject.optJSONObject(nj4.a().c()));
        if (jo4.b()) {
            do4.a().b(jSONObject.optJSONObject("api_description"));
        }
        co4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        lj4 b = nj4.b();
        es4 es4Var = null;
        if (b != null) {
            es4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            io4.b = optString;
            if (es4Var != null) {
                es4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (es4Var != null) {
                    if (optInt > 0) {
                        es4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        es4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            io4.a = false;
        }
    }
}
