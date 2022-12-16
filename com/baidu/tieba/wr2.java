package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public String c;
    public String d;
    public int e;

    public wr2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = true;
        this.d = com.alipay.sdk.widget.d.u;
        this.e = 60;
    }

    public static wr2 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            wr2 wr2Var = new wr2();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        char c = 65535;
                        int hashCode = optString.hashCode();
                        if (hashCode != -1367751899) {
                            if (hashCode == 92896879 && optString.equals("album")) {
                                c = 0;
                            }
                        } else if (optString.equals("camera")) {
                            c = 1;
                        }
                        if (c != 0) {
                            if (c == 1) {
                                i |= 2;
                            }
                        } else {
                            i |= 1;
                        }
                    }
                    wr2Var.a = i;
                }
                wr2Var.b = jSONObject.optBoolean("compressed", true);
                int i3 = 60;
                int optInt = jSONObject.optInt("maxDuration", 60);
                if (optInt <= 60) {
                    i3 = optInt;
                }
                wr2Var.e = i3;
                wr2Var.d = jSONObject.optString("camera");
                wr2Var.c = jSONObject.optString("cb");
            }
            return wr2Var;
        }
        return (wr2) invokeL.objValue;
    }
}
