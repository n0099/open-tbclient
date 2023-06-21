package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class j82 extends g72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String L;
    public boolean M;
    public boolean N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j82() {
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

    @Override // com.baidu.tieba.g72, com.baidu.tieba.l72, com.baidu.tieba.n72, com.baidu.tieba.p72, com.baidu.tieba.y13
    public void a(JSONObject jSONObject) throws JSONException {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (this.h == null) {
            this.h = new f23();
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
