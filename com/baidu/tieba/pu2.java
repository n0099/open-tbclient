package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pu2 implements tx2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nu2> a;
    public int b;
    public int c;
    public int d;
    public int e;

    public pu2() {
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
        this.b = 1;
        this.c = -16777216;
        this.d = 0;
        this.e = 0;
    }

    @Override // com.baidu.tieba.tx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<nu2> arrayList = this.a;
            if (arrayList != null && !arrayList.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tx2
    public void a(JSONObject jSONObject) throws JSONException {
        int length;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null || !jSONObject.has("points")) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("points");
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        if (length > 0) {
            this.a = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    nu2 nu2Var = new nu2();
                    nu2Var.a(optJSONObject);
                    if (nu2Var.isValid()) {
                        this.a.add(nu2Var);
                    }
                }
            }
        }
        ArrayList<nu2> arrayList = this.a;
        if (arrayList != null && arrayList.size() > 0) {
            this.b = (int) Math.abs(hu2.b(jSONObject.optInt("strokeWidth", 1)));
            this.c = hu2.a(jSONObject.optString("strokeColor"), -16777216);
            this.d = hu2.a(jSONObject.optString("fillColor"), 0);
            this.e = jSONObject.optInt("zIndex", 0);
        }
    }
}
