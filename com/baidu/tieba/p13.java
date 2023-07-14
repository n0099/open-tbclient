package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public p13() {
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

    public static p13 a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            String optString = jSONObject.optString("error");
            if (optJSONObject2 == null || !TextUtils.equals(optString, "0")) {
                return null;
            }
            p13 p13Var = new p13();
            p13Var.a = optJSONObject2.optString("ak");
            p13Var.b = optJSONObject2.optString("sk");
            p13Var.c = optJSONObject2.optString("token");
            p13Var.d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
                p13Var.f = optJSONObject.optString("bosobject");
                p13Var.e = optJSONObject.optString("bosurl");
            }
            return p13Var;
        }
        return (p13) invokeLL.objValue;
    }
}
