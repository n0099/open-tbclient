package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class xx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public List<String> b;
    public int c;
    public String d;

    public xx5() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("del_success");
        if (optJSONArray != null) {
            this.a = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                    this.a.add(optJSONArray.optString(i));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("del_fail");
        if (optJSONArray2 != null) {
            this.b = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                    this.b.add(optJSONArray2.optString(i2));
                }
            }
        }
        this.c = jSONObject.optInt("ret_type");
        this.d = jSONObject.optString("text");
    }
}
