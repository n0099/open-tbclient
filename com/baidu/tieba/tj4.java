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
public class tj4 extends fj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tj4() {
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

    @Override // com.baidu.tieba.fj4, com.baidu.tieba.ij4
    public void b(JSONObject jSONObject, sf4 sf4Var, @Nullable sf4 sf4Var2, @Nullable sf4 sf4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, sf4Var, sf4Var2, sf4Var3) != null) || jSONObject == null) {
            return;
        }
        vj4.b().e(jSONObject.optJSONObject("tipmsgs"));
        zj4.f().k(jSONObject.optJSONObject("page_tips"));
        rj4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        bk4.a().d(jSONObject.optJSONObject("pkg_preload"));
        jk4.f(jSONObject.optJSONObject("app_inner_preload"));
        uj4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        gk4.b().d(jSONObject.optJSONObject("tts"));
        ck4.a().e(jSONObject.optJSONObject("simple_control_item"));
        hk4.e(jSONObject.optJSONObject("update_expire_time"));
        if (dk4.a) {
            c(jSONObject);
        }
        fk4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        wj4.a().c(jSONObject.optJSONObject("local_debug"));
        if4.a().b(jSONObject.optJSONObject(if4.a().c()));
        if (ek4.b()) {
            yj4.a().b(jSONObject.optJSONObject("api_description"));
        }
        xj4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        gf4 b = if4.b();
        zn4 zn4Var = null;
        if (b != null) {
            zn4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            dk4.b = optString;
            if (zn4Var != null) {
                zn4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (zn4Var != null) {
                    if (optInt > 0) {
                        zn4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        zn4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            dk4.a = false;
        }
    }
}
