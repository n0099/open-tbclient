package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class q22 extends o12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String L;
    public boolean M;
    public boolean N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q22() {
        super("input", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.o12, com.baidu.tieba.t12, com.baidu.tieba.v12, com.baidu.tieba.x12, com.baidu.tieba.fw2
    public void a(JSONObject jSONObject) throws JSONException {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (this.h == null) {
            this.h = new mw2();
        }
        this.t = jSONObject.optString("value");
        this.L = jSONObject.optString("type");
        boolean z2 = false;
        if (jSONObject.optInt("confirmHold") == 1) {
            z = true;
        } else {
            z = false;
        }
        this.M = z;
        if (jSONObject.optInt("adjustPosition", 1) == 1) {
            z2 = true;
        }
        this.N = z2;
    }
}
