package com.baidu.tieba;

import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public String c;
    public String d;
    public int e;

    public rz2() {
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
        this.d = "back";
        this.e = 60;
    }

    public static rz2 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            rz2 rz2Var = new rz2();
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
                            if (hashCode == 92896879 && optString.equals(CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_SOURCE_PICTURE_BROWSER)) {
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
                    rz2Var.a = i;
                }
                rz2Var.b = jSONObject.optBoolean("compressed", true);
                int i3 = 60;
                int optInt = jSONObject.optInt("maxDuration", 60);
                if (optInt <= 60) {
                    i3 = optInt;
                }
                rz2Var.e = i3;
                rz2Var.d = jSONObject.optString("camera");
                rz2Var.c = jSONObject.optString("cb");
            }
            return rz2Var;
        }
        return (rz2) invokeL.objValue;
    }
}
