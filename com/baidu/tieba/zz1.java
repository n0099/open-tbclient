package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.FormBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class zz1 extends yz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "Coupon" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanAppCouponApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zz1 b;

        public a(zz1 zz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zz1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                zz1 zz1Var = this.b;
                String str = this.a;
                zz1Var.d(str, new v32(1001, "operation fail, msg = " + exc.getMessage()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    this.b.d(this.a, new v32(1001, "server response fail"));
                    return;
                }
                int optInt = jSONObject.optInt("errno", 10002);
                String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                if (optInt != 0) {
                    this.b.d(this.a, new v32(optInt, optString));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.b.d(this.a, new v32(optInt, optString));
                    return;
                }
                this.b.d(this.a, new v32(0, optString, optJSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            ResponseBody body;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && (body = response.body()) != null) {
                    return vo3.d(body.string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zz1(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(String str, vb3 vb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, vb3Var) == null) {
            xi3 xi3Var = new xi3();
            xi3Var.a = "swan";
            xi3Var.b = str;
            xi3Var.f = vb3Var.O();
            xi3Var.a("host_app", cv2.n().a());
            ci3.i("2267", "83", xi3Var.f());
        }
    }

    public final v32 B(String str, FormBody.Builder builder, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, builder, str2)) == null) {
            a33 a2 = a33.a(builder.build(), c33.b);
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                return new v32(202);
            }
            yi4 yi4Var = new yi4(y, a2, new a(this, str2));
            if (zi4.g().c()) {
                yi4Var.f = true;
            }
            yi4Var.g = true;
            zi4.g().e(yi4Var);
            return v32.f();
        }
        return (v32) invokeLLL.objValue;
    }

    public v32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#takeCoupons", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                return new v32(1001, "SwanApp is null");
            }
            A("coupons_take", b0);
            if (!b02.y(getContext())) {
                return new v32(10007, "is not baidu account");
            }
            if (!b0.N().e(getContext())) {
                return new v32(10004, "user not logged in");
            }
            Pair<v32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((v32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("promotionId");
                if (TextUtils.isEmpty(optString)) {
                    return new v32(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new v32(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", vb3.g0());
                builder.add("promotionId", optString);
                return B("takeCoupons", builder, optString2);
            }
            return new v32(202);
        }
        return (v32) invokeL.objValue;
    }

    public v32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getUserCoupons", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                return new v32(1001, "SwanApp is null");
            }
            A("coupons_user", b0);
            if (!b02.y(getContext())) {
                return new v32(10007, "is not baidu account");
            }
            if (!b0.N().e(getContext())) {
                return new v32(10004, "user not logged in");
            }
            Pair<v32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((v32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new v32(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new v32(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", vb3.g0());
                builder.add("couponAppKey", optString);
                return B("getUserCoupons", builder, optString2);
            }
            return new v32(202);
        }
        return (v32) invokeL.objValue;
    }

    public v32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getPlatformCoupons", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                return new v32(202, "SwanApp is null");
            }
            A("coupons_appkey", b0);
            if (!b02.y(getContext())) {
                return new v32(10007, "is not baidu account");
            }
            Pair<v32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((v32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new v32(202, "couponAppKey is invalid");
                }
                boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
                if (optBoolean) {
                    A("coupons_appkey_user", b0);
                    if (!b0.N().e(getContext())) {
                        return new v32(10004, "user not logged in");
                    }
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new v32(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", vb3.g0());
                builder.add("couponAppKey", optString);
                builder.add("withUserCoupons", String.valueOf(optBoolean));
                return B("getPlatformCoupons", builder, optString2);
            }
            return new v32(202);
        }
        return (v32) invokeL.objValue;
    }

    public final String y(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1741243770) {
                if (hashCode != 15750540) {
                    if (hashCode == 1991726820 && str.equals("getPlatformCoupons")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (str.equals("getUserCoupons")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("takeCoupons")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return null;
                    }
                    return cv2.o().j();
                }
                return cv2.o().f();
            }
            return cv2.o().K();
        }
        return (String) invokeL.objValue;
    }
}
