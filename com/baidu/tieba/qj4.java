package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qj4 extends cj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qj4() {
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

    @Override // com.baidu.tieba.cj4, com.baidu.tieba.fj4
    public void b(JSONObject jSONObject, pf4 pf4Var, @Nullable pf4 pf4Var2, @Nullable pf4 pf4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, pf4Var, pf4Var2, pf4Var3) != null) || jSONObject == null) {
            return;
        }
        sj4.b().e(jSONObject.optJSONObject("tipmsgs"));
        wj4.f().k(jSONObject.optJSONObject("page_tips"));
        oj4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        yj4.a().d(jSONObject.optJSONObject("pkg_preload"));
        gk4.f(jSONObject.optJSONObject("app_inner_preload"));
        rj4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        dk4.b().d(jSONObject.optJSONObject("tts"));
        zj4.a().e(jSONObject.optJSONObject("simple_control_item"));
        ek4.e(jSONObject.optJSONObject("update_expire_time"));
        if (ak4.a) {
            c(jSONObject);
        }
        ck4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        tj4.a().c(jSONObject.optJSONObject("local_debug"));
        ff4.a().b(jSONObject.optJSONObject(ff4.a().c()));
        if (bk4.b()) {
            vj4.a().b(jSONObject.optJSONObject("api_description"));
        }
        uj4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        df4 b = ff4.b();
        wn4 wn4Var = null;
        if (b != null) {
            wn4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            ak4.b = optString;
            if (wn4Var != null) {
                wn4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (wn4Var != null) {
                    if (optInt > 0) {
                        wn4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        wn4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            ak4.a = false;
        }
    }
}
