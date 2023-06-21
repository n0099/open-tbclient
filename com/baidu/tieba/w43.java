package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w43 extends k43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948220563, "Lcom/baidu/tieba/w43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948220563, "Lcom/baidu/tieba/w43;");
                return;
            }
        }
        f = js1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w43(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public z32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#chooseCoupon", false);
            zb3 b0 = zb3.b0();
            if (b0 == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new z32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan activity is null");
                }
                return new z32(1001, "swan activity is null");
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new z32(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new z32(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("appKey");
            if (TextUtils.isEmpty(optString3)) {
                return new z32(202, "empty appKey");
            }
            String optString4 = jSONObject.optString("totalAmount");
            if (TextUtils.isEmpty(optString4)) {
                return new z32(202, "empty totalAmount");
            }
            PaymentPanelManager.z().s(this, w, optString2, optString3, optString4, optString);
            return z32.f();
        }
        return (z32) invokeL.objValue;
    }

    public z32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getPaymentInfo", false);
            if (zb3.b0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: null swan runtime");
                }
                return new z32(1001, "swan app is null");
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new z32(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new z32(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("dealId");
            if (TextUtils.isEmpty(optString3)) {
                return new z32(202, "empty dealId");
            }
            String optString4 = jSONObject.optString("appKey");
            if (TextUtils.isEmpty(optString4)) {
                return new z32(202, "empty appKey");
            }
            String optString5 = jSONObject.optString("totalAmount");
            if (TextUtils.isEmpty(optString5)) {
                return new z32(202, "empty totalAmount");
            }
            PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
            return z32.f();
        }
        return (z32) invokeL.objValue;
    }

    public z32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setPaymentInfo", false);
            if (zb3.b0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new z32(1001, "swan app is null");
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new z32(202, "cb is empty");
            }
            String optString2 = jSONObject.optString("componentId");
            if (TextUtils.isEmpty(optString2)) {
                return new z32(202, "empty componentId");
            }
            String optString3 = jSONObject.optString("chosenChannel");
            if (TextUtils.isEmpty(optString3)) {
                return new z32(202, "empty chosenChannel");
            }
            PaymentPanelManager.z().J(this, optString2, optString3, optString);
            return z32.f();
        }
        return (z32) invokeL.objValue;
    }
}
