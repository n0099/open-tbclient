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
public class sk4 extends ek4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sk4() {
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

    @Override // com.baidu.tieba.ek4, com.baidu.tieba.hk4
    public void b(JSONObject jSONObject, rg4 rg4Var, @Nullable rg4 rg4Var2, @Nullable rg4 rg4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, rg4Var, rg4Var2, rg4Var3) != null) || jSONObject == null) {
            return;
        }
        uk4.b().e(jSONObject.optJSONObject("tipmsgs"));
        yk4.f().k(jSONObject.optJSONObject("page_tips"));
        qk4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        al4.a().d(jSONObject.optJSONObject("pkg_preload"));
        il4.f(jSONObject.optJSONObject("app_inner_preload"));
        tk4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        fl4.b().d(jSONObject.optJSONObject("tts"));
        bl4.a().e(jSONObject.optJSONObject("simple_control_item"));
        gl4.e(jSONObject.optJSONObject("update_expire_time"));
        if (cl4.a) {
            c(jSONObject);
        }
        el4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        vk4.a().c(jSONObject.optJSONObject("local_debug"));
        hg4.a().b(jSONObject.optJSONObject(hg4.a().c()));
        if (dl4.b()) {
            xk4.a().b(jSONObject.optJSONObject("api_description"));
        }
        wk4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        fg4 b = hg4.b();
        yo4 yo4Var = null;
        if (b != null) {
            yo4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            cl4.b = optString;
            if (yo4Var != null) {
                yo4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt(com.alipay.sdk.data.a.O);
                if (yo4Var != null) {
                    if (optInt > 0) {
                        yo4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        yo4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            cl4.a = false;
        }
    }
}
