package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k62 extends p62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String I;
    public boolean J;
    public int K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k62(String str, @NonNull String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = "";
    }

    private void i() {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (jSONObject = this.j) != null) {
            this.u = SwanAppConfigData.t(jSONObject.optString("color"));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.p62, com.baidu.tieba.r62, com.baidu.tieba.t62, com.baidu.tieba.c13
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optInt("maxLength");
        this.E = k(jSONObject);
        this.F = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.G = jSONObject.optInt("selectionStart");
        this.H = jSONObject.optInt("selectionEnd");
        this.I = jSONObject.optString("confirmType");
        boolean z = true;
        if (jSONObject.optInt(com.baidu.sapi2.views.logindialog.view.a.m) != 1) {
            z = false;
        }
        this.J = z;
        i();
    }

    @Override // com.baidu.tieba.p62, com.baidu.tieba.r62, com.baidu.tieba.t62
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.g(jSONObject);
            if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
                this.E = k(jSONObject);
            }
            this.D = jSONObject.optInt("maxLength", this.D);
            this.F = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.F);
            this.G = jSONObject.optInt("selectionStart", this.G);
            this.H = jSONObject.optInt("selectionEnd", this.H);
            this.I = jSONObject.optString("confirmType", this.I);
            boolean z = true;
            if (jSONObject.optInt(com.baidu.sapi2.views.logindialog.view.a.m, this.J ? 1 : 0) != 1) {
                z = false;
            }
            this.J = z;
            this.t = jSONObject.optString("value", this.t);
            i();
        }
    }

    public final int k(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            String optString = jSONObject.optString("cursorSpacing");
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            if (optString.endsWith("rpx")) {
                try {
                    return uo3.g(Integer.parseInt(optString.replace("rpx", "")));
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }
            try {
                return Integer.parseInt(optString.replace("px", ""));
            } catch (NumberFormatException unused2) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.G = i;
            this.H = i2;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.K = i;
        }
    }
}
