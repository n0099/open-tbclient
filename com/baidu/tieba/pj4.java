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
/* loaded from: classes5.dex */
public class pj4 extends bj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pj4() {
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

    @Override // com.baidu.tieba.bj4, com.baidu.tieba.ej4
    public void b(JSONObject jSONObject, of4 of4Var, @Nullable of4 of4Var2, @Nullable of4 of4Var3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048576, this, jSONObject, of4Var, of4Var2, of4Var3) != null) || jSONObject == null) {
            return;
        }
        rj4.b().e(jSONObject.optJSONObject("tipmsgs"));
        vj4.f().k(jSONObject.optJSONObject("page_tips"));
        nj4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        xj4.a().d(jSONObject.optJSONObject("pkg_preload"));
        fk4.f(jSONObject.optJSONObject("app_inner_preload"));
        qj4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        ck4.b().d(jSONObject.optJSONObject("tts"));
        yj4.a().e(jSONObject.optJSONObject("simple_control_item"));
        dk4.e(jSONObject.optJSONObject("update_expire_time"));
        if (zj4.a) {
            c(jSONObject);
        }
        bk4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        sj4.a().c(jSONObject.optJSONObject("local_debug"));
        ef4.a().b(jSONObject.optJSONObject(ef4.a().c()));
        if (ak4.b()) {
            uj4.a().b(jSONObject.optJSONObject("api_description"));
        }
        tj4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null || optJSONObject.optLong("errno") != 0) {
            return;
        }
        cf4 b = ef4.b();
        vn4 vn4Var = null;
        if (b != null) {
            vn4Var = b.i();
        }
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            zj4.b = optString;
            if (vn4Var != null) {
                vn4Var.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (vn4Var != null) {
                    if (optInt > 0) {
                        vn4Var.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        vn4Var.putInt("key_h2_heart_beat_timeout", optInt2);
                        return;
                    }
                    return;
                }
                return;
            }
            zj4.a = false;
        }
    }
}
