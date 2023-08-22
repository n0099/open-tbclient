package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class im5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;

    public im5() {
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

    public static im5 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                im5 im5Var = new im5();
                im5Var.a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                im5Var.b = jSONObject.optInt("width");
                im5Var.c = jSONObject.optInt("height");
                im5Var.d = jSONObject.optString("pic_url");
                im5Var.e = jSONObject.optString("thumbnail");
                im5Var.g = jSONObject.optString("origin_url");
                return im5Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (im5) invokeL.objValue;
    }
}
