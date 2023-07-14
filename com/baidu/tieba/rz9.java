package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;

    public rz9() {
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

    public static rz9 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            rz9 rz9Var = new rz9();
            jSONObject.optString("brand_name");
            rz9Var.a = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            rz9Var.b = jSONObject.optString("button_scheme");
            rz9Var.c = jSONObject.optString("cmd_scheme");
            jSONObject.optString("icon");
            rz9Var.d = jSONObject.optString("operate_recommend_reason");
            rz9Var.e = jSONObject.optLong("trans_animation_delay", 0L);
            rz9Var.f = jSONObject.optInt("layout_upgrade", 0);
            return rz9Var;
        }
        return (rz9) invokeL.objValue;
    }
}
