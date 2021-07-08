package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.lollipop.json.JSONException;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern H;
    public static c I = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f24706i = "life_host";
    public static final String j = "my_host";
    public static final String k = "credit_card_host";
    public static final String l = "app_host";
    public static final String m = "nfc_host";
    public static final String n = "app_pay_host";
    public static final String o = "m_host";
    public static final String p = "co_host";
    public static final String q = "qianbao_host";
    public static final String r = "zhifuhost";
    public static final String s = "comet_host";
    public static final String t = "wallet_web_cache_host";
    public static final String u = "https://www.baifubao.com";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1294657915, "Lcom/baidu/wallet/core/domain/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1294657915, "Lcom/baidu/wallet/core/domain/c;");
                return;
            }
        }
        H = Pattern.compile("^https://.*\\.com");
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = "https://www.baifubao.com";
        this.w = "https://www.baifubao.com";
        this.x = b.k;
        this.y = "https://www.baifubao.com";
        this.z = "https://chong.baidu.com";
        this.A = "https://www.dxmpay.com";
        this.B = b.m;
        this.C = "https://www.dxmpay.com";
        this.D = "https://www.dxmpay.com";
        this.E = "https://www.dxmpay.com";
        this.F = "https://cp01-ocean-1481.epc.baidu.com:8443";
        this.G = b.l;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (I == null) {
                I = new c();
            }
            return I;
        }
        return (c) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.K = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.L = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.M = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.N = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.O = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.P = str;
        }
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TextUtils.isEmpty(this.M)) {
                return this.M;
            }
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!TextUtils.isEmpty(this.O)) {
                return this.O;
            }
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!TextUtils.isEmpty(this.Q)) {
                return this.Q;
            }
            return this.E;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!TextUtils.isEmpty(this.T)) {
                return this.T;
            }
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!TextUtils.isEmpty(this.L)) {
                return this.L;
            }
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            if (TextUtils.isEmpty(this.M)) {
                return z ? this.y : "https://www.baifubao.com";
            }
            return this.M;
        }
        return (String) invokeZ.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!TextUtils.isEmpty(this.J)) {
                return this.J;
            }
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!TextUtils.isEmpty(this.P)) {
                return this.P;
            }
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!TextUtils.isEmpty(this.K)) {
                return this.K;
            }
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!TextUtils.isEmpty(this.N)) {
                return this.N;
            }
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!TextUtils.isEmpty(this.R)) {
                return this.R;
            }
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!TextUtils.isEmpty(this.U)) {
                return this.U;
            }
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!TextUtils.isEmpty(this.S)) {
                return this.S;
            }
            return this.G;
        }
        return (String) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.Q = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.R = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.S = str;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.T = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.U = str;
        }
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("life_host");
            if (!TextUtils.isEmpty(optString) && H.matcher(optString).matches()) {
                this.v = optString;
            } else {
                this.v = "https://www.baifubao.com";
            }
            String optString2 = jSONObject.optString(a.f24698b);
            if (!TextUtils.isEmpty(optString2) && H.matcher(optString2).matches()) {
                this.x = optString2;
            } else {
                this.x = b.k;
            }
            String optString3 = jSONObject.optString("nfc_host");
            if (!TextUtils.isEmpty(optString3) && H.matcher(optString3).matches()) {
                this.z = optString3;
            } else {
                this.z = "https://chong.baidu.com";
            }
            String optString4 = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString4) && H.matcher(optString4).matches()) {
                this.y = optString4;
                com.baidu.apollon.heartbeat.a.c().a(this.M);
            } else {
                this.y = "https://www.baifubao.com";
                com.baidu.apollon.heartbeat.a.c().a(this.y);
            }
            String optString5 = jSONObject.optString(a.f24701e);
            if (!TextUtils.isEmpty(optString5) && H.matcher(optString5).matches()) {
                this.A = optString5;
                this.C = optString5;
                this.E = optString5;
                this.D = optString5;
            } else {
                this.A = "https://www.baifubao.com";
                this.C = "https://m.baifubao.com";
                this.E = "https://co.baifubao.com";
                this.D = "https://qianbao.baidu.com";
            }
            String optString6 = jSONObject.optString(a.f24702f);
            if (!TextUtils.isEmpty(optString6) && H.matcher(optString6).matches()) {
                this.G = optString6;
            } else {
                this.G = WapPayActivity.HOST;
            }
            String optString7 = jSONObject.optString("comet_host");
            if (!TextUtils.isEmpty(optString7) && H.matcher(optString7).matches()) {
                this.B = optString7;
            } else {
                this.B = b.m;
            }
            String optString8 = jSONObject.optString("my_host");
            if (!TextUtils.isEmpty(optString8) && H.matcher(optString8).matches()) {
                this.w = optString8;
            } else {
                this.w = "https://www.baifubao.com";
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.J = str;
        }
    }
}
