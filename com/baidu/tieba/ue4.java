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
public class ue4 extends ge4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ue4() {
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

    @Override // com.baidu.tieba.ge4, com.baidu.tieba.je4
    public void b(JSONObject jSONObject, ta4 ta4Var, @Nullable ta4 ta4Var2, @Nullable ta4 ta4Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, ta4Var, ta4Var2, ta4Var3) == null) || jSONObject == null) {
            return;
        }
        we4.b().e(jSONObject.optJSONObject("tipmsgs"));
        af4.f().k(jSONObject.optJSONObject("page_tips"));
        se4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        cf4.a().d(jSONObject.optJSONObject("pkg_preload"));
        kf4.f(jSONObject.optJSONObject("app_inner_preload"));
        ve4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        hf4.b().d(jSONObject.optJSONObject("tts"));
        df4.a().e(jSONObject.optJSONObject("simple_control_item"));
        if4.e(jSONObject.optJSONObject("update_expire_time"));
        if (ef4.a) {
            c(jSONObject);
        }
        gf4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        xe4.a().c(jSONObject.optJSONObject("local_debug"));
        ja4.a().b(jSONObject.optJSONObject(ja4.a().c()));
        if (ff4.b()) {
            ze4.a().b(jSONObject.optJSONObject("api_description"));
        }
        ye4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            ha4 b = ja4.b();
            aj4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                ef4.b = optString;
                if (i != null) {
                    i.putString("key_h2_heart_beat_version", optString);
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                    int optInt = optJSONObject2.optInt("timespan");
                    int optInt2 = optJSONObject2.optInt("timeout");
                    if (i != null) {
                        if (optInt > 0) {
                            i.putInt("key_h2_heart_beat_timespan", optInt);
                        }
                        if (optInt2 > 0) {
                            i.putInt("key_h2_heart_beat_timeout", optInt2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ef4.a = false;
            }
        }
    }
}
