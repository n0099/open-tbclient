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
public class lh4 extends xg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lh4() {
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

    @Override // com.baidu.tieba.xg4, com.baidu.tieba.ah4
    public void b(JSONObject jSONObject, kd4 kd4Var, @Nullable kd4 kd4Var2, @Nullable kd4 kd4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, kd4Var, kd4Var2, kd4Var3) != null) || jSONObject == null) {
            return;
        }
        nh4.b().e(jSONObject.optJSONObject("tipmsgs"));
        rh4.f().k(jSONObject.optJSONObject("page_tips"));
        jh4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        th4.a().d(jSONObject.optJSONObject("pkg_preload"));
        bi4.f(jSONObject.optJSONObject("app_inner_preload"));
        mh4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        yh4.b().d(jSONObject.optJSONObject("tts"));
        uh4.a().e(jSONObject.optJSONObject("simple_control_item"));
        zh4.e(jSONObject.optJSONObject("update_expire_time"));
        if (vh4.a) {
            c(jSONObject);
        }
        xh4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        oh4.a().c(jSONObject.optJSONObject("local_debug"));
        ad4.a().b(jSONObject.optJSONObject(ad4.a().c()));
        if (wh4.b()) {
            qh4.a().b(jSONObject.optJSONObject("api_description"));
        }
        ph4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        yc4 b = ad4.b();
        ql4 ql4Var = null;
        if (b != null) {
            ql4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            vh4.b = optString;
            if (ql4Var != null) {
                ql4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt("switch") > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (ql4Var != null) {
                    if (optInt > 0) {
                        ql4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        ql4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            vh4.a = false;
        }
    }
}
