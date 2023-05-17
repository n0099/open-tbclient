package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;

    public sg9() {
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

    public static sg9 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            sg9 sg9Var = new sg9();
            jSONObject.optString("brand_name");
            sg9Var.a = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            sg9Var.b = jSONObject.optString("button_scheme");
            sg9Var.c = jSONObject.optString("cmd_scheme");
            jSONObject.optString("icon");
            sg9Var.d = jSONObject.optString("operate_recommend_reason");
            sg9Var.e = jSONObject.optLong("trans_animation_delay", 0L);
            sg9Var.f = jSONObject.optInt("layout_upgrade", 0);
            return sg9Var;
        }
        return (sg9) invokeL.objValue;
    }
}
