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
public class ry2 implements u13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<oy2> a;
    public int b;
    public float c;
    public boolean d;

    public ry2() {
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

    @Override // com.baidu.tieba.u13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<oy2> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u13
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
                    oy2 oy2Var = new oy2();
                    oy2Var.a(optJSONObject);
                    if (oy2Var.isValid()) {
                        this.a.add(oy2Var);
                    }
                }
            }
        }
        ArrayList<oy2> arrayList = this.a;
        if (arrayList != null && arrayList.size() > 0) {
            this.b = iy2.a(jSONObject.optString("color"), 0);
            this.c = Math.abs(iy2.b(jSONObject.optDouble("width", 0.0d)));
            this.d = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            iy2.a(jSONObject.optString("borderColor"), 0);
            Math.abs(iy2.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }
}
