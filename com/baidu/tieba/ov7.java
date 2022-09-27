package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ov7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;

    public ov7() {
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

    public static ov7 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                ov7 ov7Var = new ov7();
                ov7Var.a = jSONObject.optBoolean("show", false);
                ov7Var.b = jSONObject.optInt(CriusAttrConstants.POSITION, -1);
                return ov7Var;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ov7) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "{\"show\":" + this.a + ",\"position\":" + this.b + '}';
        }
        return (String) invokeV.objValue;
    }
}
