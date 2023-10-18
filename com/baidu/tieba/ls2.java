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
/* loaded from: classes7.dex */
public class ls2 implements ov2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<is2> a;
    public int b;
    public float c;
    public boolean d;

    public ls2() {
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
        this.b = 0;
        this.c = 0.0f;
        this.d = false;
    }

    @Override // com.baidu.tieba.ov2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<is2> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ov2
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
                    is2 is2Var = new is2();
                    is2Var.a(optJSONObject);
                    if (is2Var.isValid()) {
                        this.a.add(is2Var);
                    }
                }
            }
        }
        ArrayList<is2> arrayList = this.a;
        if (arrayList != null && arrayList.size() > 0) {
            this.b = cs2.a(jSONObject.optString("color"), 0);
            this.c = Math.abs(cs2.b(jSONObject.optDouble("width", 0.0d)));
            this.d = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            cs2.a(jSONObject.optString("borderColor"), 0);
            Math.abs(cs2.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }
}
