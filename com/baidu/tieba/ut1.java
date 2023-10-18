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
public class ut1 extends tt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Coupon" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanAppCouponApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ut1 b;

        public a(ut1 ut1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ut1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ut1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                ut1 ut1Var = this.b;
                String str = this.a;
                ut1Var.d(str, new qx1(1001, "operation fail, msg = " + exc.getMessage()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    this.b.d(this.a, new qx1(1001, "server response fail"));
                    return;
                }
                int optInt = jSONObject.optInt("errno", 10002);
                String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                if (optInt != 0) {
                    this.b.d(this.a, new qx1(optInt, optString));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.b.d(this.a, new qx1(optInt, optString));
                    return;
                }
                this.b.d(this.a, new qx1(0, optString, optJSONObject));
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
                    return pi3.d(body.string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ut1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qx1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#getUserCoupons", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(1001, "SwanApp is null");
            }
            B("coupons_user", c0);
            if (!wt1.z(i())) {
                return new qx1(10007, "is not baidu account");
            }
            if (!c0.N().e(i())) {
                return new qx1(10004, "user not logged in");
            }
            Pair<qx1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((qx1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new qx1(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new qx1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", p53.h0());
                builder.add("couponAppKey", optString);
                return C("getUserCoupons", builder, optString2);
            }
            return new qx1(202);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#takeCoupons", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(1001, "SwanApp is null");
            }
            B("coupons_take", c0);
            if (!wt1.z(i())) {
                return new qx1(10007, "is not baidu account");
            }
            if (!c0.N().e(i())) {
                return new qx1(10004, "user not logged in");
            }
            Pair<qx1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((qx1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("promotionId");
                if (TextUtils.isEmpty(optString)) {
                    return new qx1(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new qx1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", p53.h0());
                builder.add("promotionId", optString);
                return C("takeCoupons", builder, optString2);
            }
            return new qx1(202);
        }
        return (qx1) invokeL.objValue;
    }

    public final void B(String str, p53 p53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, p53Var) == null) {
            rc3 rc3Var = new rc3();
            rc3Var.a = "swan";
            rc3Var.b = str;
            rc3Var.f = p53Var.P();
            rc3Var.a("host_app", wo2.n().a());
            wb3.i("2267", "83", rc3Var.f());
        }
    }

    public final qx1 C(String str, FormBody.Builder builder, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, builder, str2)) == null) {
            uw2 a2 = uw2.a(builder.build(), ww2.b);
            String z = z(str);
            if (TextUtils.isEmpty(z)) {
                return new qx1(202);
            }
            sc4 sc4Var = new sc4(z, a2, new a(this, str2));
            if (tc4.g().c()) {
                sc4Var.f = true;
            }
            sc4Var.g = true;
            tc4.g().e(sc4Var);
            return qx1.f();
        }
        return (qx1) invokeLLL.objValue;
    }

    public qx1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#getPlatformCoupons", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(202, "SwanApp is null");
            }
            B("coupons_appkey", c0);
            if (!wt1.z(i())) {
                return new qx1(10007, "is not baidu account");
            }
            Pair<qx1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((qx1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new qx1(202, "couponAppKey is invalid");
                }
                boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
                if (optBoolean) {
                    B("coupons_appkey_user", c0);
                    if (!c0.N().e(i())) {
                        return new qx1(10004, "user not logged in");
                    }
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new qx1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", p53.h0());
                builder.add("couponAppKey", optString);
                builder.add("withUserCoupons", String.valueOf(optBoolean));
                return C("getPlatformCoupons", builder, optString2);
            }
            return new qx1(202);
        }
        return (qx1) invokeL.objValue;
    }

    public final String z(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
                    return wo2.o().j();
                }
                return wo2.o().f();
            }
            return wo2.o().K();
        }
        return (String) invokeL.objValue;
    }
}
