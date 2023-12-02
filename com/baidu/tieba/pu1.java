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
/* loaded from: classes7.dex */
public class pu1 extends ou1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Coupon" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanAppCouponApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pu1 b;

        public a(pu1 pu1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pu1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                pu1 pu1Var = this.b;
                String str = this.a;
                pu1Var.d(str, new ly1(1001, "operation fail, msg = " + exc.getMessage()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    this.b.d(this.a, new ly1(1001, "server response fail"));
                    return;
                }
                int optInt = jSONObject.optInt("errno", 10002);
                String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                if (optInt != 0) {
                    this.b.d(this.a, new ly1(optInt, optString));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.b.d(this.a, new ly1(optInt, optString));
                    return;
                }
                this.b.d(this.a, new ly1(0, optString, optJSONObject));
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
                    return kj3.d(body.string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pu1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ly1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#getUserCoupons", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(1001, "SwanApp is null");
            }
            B("coupons_user", c0);
            if (!ru1.z(i())) {
                return new ly1(10007, "is not baidu account");
            }
            if (!c0.N().e(i())) {
                return new ly1(10004, "user not logged in");
            }
            Pair<ly1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((ly1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ly1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", k63.h0());
                builder.add("couponAppKey", optString);
                return C("getUserCoupons", builder, optString2);
            }
            return new ly1(202);
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#takeCoupons", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(1001, "SwanApp is null");
            }
            B("coupons_take", c0);
            if (!ru1.z(i())) {
                return new ly1(10007, "is not baidu account");
            }
            if (!c0.N().e(i())) {
                return new ly1(10004, "user not logged in");
            }
            Pair<ly1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((ly1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("promotionId");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ly1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", k63.h0());
                builder.add("promotionId", optString);
                return C("takeCoupons", builder, optString2);
            }
            return new ly1(202);
        }
        return (ly1) invokeL.objValue;
    }

    public final void B(String str, k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, k63Var) == null) {
            md3 md3Var = new md3();
            md3Var.a = "swan";
            md3Var.b = str;
            md3Var.f = k63Var.P();
            md3Var.a("host_app", rp2.n().a());
            rc3.i("2267", "83", md3Var.f());
        }
    }

    public final ly1 C(String str, FormBody.Builder builder, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, builder, str2)) == null) {
            px2 a2 = px2.a(builder.build(), rx2.b);
            String z = z(str);
            if (TextUtils.isEmpty(z)) {
                return new ly1(202);
            }
            nd4 nd4Var = new nd4(z, a2, new a(this, str2));
            if (od4.g().c()) {
                nd4Var.f = true;
            }
            nd4Var.g = true;
            od4.g().e(nd4Var);
            return ly1.f();
        }
        return (ly1) invokeLLL.objValue;
    }

    public ly1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#getPlatformCoupons", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(202, "SwanApp is null");
            }
            B("coupons_appkey", c0);
            if (!ru1.z(i())) {
                return new ly1(10007, "is not baidu account");
            }
            Pair<ly1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((ly1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "couponAppKey is invalid");
                }
                boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
                if (optBoolean) {
                    B("coupons_appkey_user", c0);
                    if (!c0.N().e(i())) {
                        return new ly1(10004, "user not logged in");
                    }
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ly1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", k63.h0());
                builder.add("couponAppKey", optString);
                builder.add("withUserCoupons", String.valueOf(optBoolean));
                return C("getPlatformCoupons", builder, optString2);
            }
            return new ly1(202);
        }
        return (ly1) invokeL.objValue;
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
                    return rp2.o().j();
                }
                return rp2.o().f();
            }
            return rp2.o().K();
        }
        return (String) invokeL.objValue;
    }
}
