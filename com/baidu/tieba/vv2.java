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
/* loaded from: classes6.dex */
public class vv2 extends jv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254167, "Lcom/baidu/tieba/vv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254167, "Lcom/baidu/tieba/vv2;");
                return;
            }
        }
        f = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv2(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zq1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    public yu1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#chooseCoupon", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new yu1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan activity is null");
                }
                return new yu1(1001, "swan activity is null");
            }
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new yu1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new yu1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString3)) {
                    return new yu1(202, "empty appKey");
                }
                String optString4 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString4)) {
                    return new yu1(202, "empty totalAmount");
                }
                PaymentPanelManager.z().s(this, w, optString2, optString3, optString4, optString);
                return yu1.f();
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }

    public yu1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getPaymentInfo", false);
            if (y23.b0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: null swan runtime");
                }
                return new yu1(1001, "swan app is null");
            }
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new yu1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new yu1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("dealId");
                if (TextUtils.isEmpty(optString3)) {
                    return new yu1(202, "empty dealId");
                }
                String optString4 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString4)) {
                    return new yu1(202, "empty appKey");
                }
                String optString5 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString5)) {
                    return new yu1(202, "empty totalAmount");
                }
                PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
                return yu1.f();
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }

    public yu1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setPaymentInfo", false);
            if (y23.b0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new yu1(1001, "swan app is null");
            }
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new yu1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new yu1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("chosenChannel");
                if (TextUtils.isEmpty(optString3)) {
                    return new yu1(202, "empty chosenChannel");
                }
                PaymentPanelManager.z().J(this, optString2, optString3, optString);
                return yu1.f();
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }
}
