package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class te4 extends he4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public te4() {
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

    @Override // com.baidu.tieba.he4
    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", we4.b().d());
                jSONObject.put("tipmsgs", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                gf4.b();
                jSONObject3.put("version", gf4.c());
                jSONObject.put("web_degrade_strategy", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version", cf4.a().b());
                jSONObject.put("pkg_preload", jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("version", se4.b().c());
                jSONObject.put("pkg_clean_strategy", jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("version", ve4.a().b());
                jSONObject.put("getpkg_retry_switch", jSONObject6);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("version", if4.d());
                jSONObject.put("update_expire_time", jSONObject7);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("version", af4.f().h());
                jSONObject.put("page_tips", jSONObject8);
                if (ef4.a) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("version", ef4.b);
                    jSONObject.put("heartbeat", jSONObject9);
                }
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("version", xe4.a().b());
                jSONObject.put("local_debug", jSONObject10);
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("version", ja4.a().a());
                jSONObject.put(ja4.a().c(), jSONObject11);
                if (ff4.b()) {
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("version", ff4.a());
                    jSONObject.put("api_description", jSONObject12);
                }
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("version", hf4.b().c());
                jSONObject.put("tts", jSONObject13);
                new JSONObject().put("version", ye4.a().c());
                jSONObject.put("no_history_apps", jSONObject13);
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("version", kf4.d());
                jSONObject.put("app_inner_preload", jSONObject14);
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("version", df4.a().b());
                jSONObject.put("simple_control_item", jSONObject15);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
