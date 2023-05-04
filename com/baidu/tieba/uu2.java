package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uu2 implements wx2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;

    public uu2() {
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
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
        this.c = -1;
        this.d = -1;
    }

    @Override // com.baidu.tieba.wx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a != Integer.MIN_VALUE && this.b != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wx2
    public void a(JSONObject jSONObject) throws JSONException {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("left") && jSONObject.has("top")) {
            this.a = ol3.g(jSONObject.optInt("left"));
            this.b = ol3.g(jSONObject.optInt("top"));
            int i2 = -1;
            if (jSONObject.has("width")) {
                i = Math.abs(ol3.g(jSONObject.optInt("width")));
            } else {
                i = -1;
            }
            this.c = i;
            if (jSONObject.has("height")) {
                i2 = Math.abs(ol3.g(jSONObject.optInt("height")));
            }
            this.d = i2;
        }
    }
}
