package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pj9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qj9 extends pj9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int d;
    public final String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj9(int i, String str, int i2, String str2) {
        super(i, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = i2;
        this.e = str2;
    }

    @Override // com.baidu.tieba.pj9.b, com.baidu.tieba.pj9
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject a = super.a();
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.d != -4399) {
                    jSONObject.put("code", this.d);
                }
                if (!StringUtils.isNull(this.e)) {
                    jSONObject.put("msg", this.e);
                }
                a.put("ext", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return a;
        }
        return (JSONObject) invokeV.objValue;
    }
}
