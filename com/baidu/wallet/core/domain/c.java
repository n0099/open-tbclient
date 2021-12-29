package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
/* loaded from: classes13.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String M = "https://bi-sensors.duxiaoman.com";
    public static final String N = "https://jin.baidu.com";
    public static final String O = "https://qianbao.baidu.com";
    public static final Pattern P;
    public static c Q = null;
    public static final String m = "life_host";
    public static final String n = "my_host";
    public static final String o = "credit_card_host";
    public static final String p = "app_host";
    public static final String q = "nfc_host";
    public static final String r = "app_pay_host";
    public static final String s = "m_host";
    public static final String t = "co_host";
    public static final String u = "qianbao_host";
    public static final String v = "zhifuhost";
    public static final String w = "comet_host";
    public static final String x = "wallet_web_cache_host";
    public static final String y = "https://www.baifubao.com";
    public static final String z = "https://app.duxiaomanFintec.com";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String aa;
    public String ab;
    public String ac;
    public String ad;
    public String ae;
    public String af;
    public String ag;

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
        P = Pattern.compile("^https://.*\\.com");
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
        this.A = "https://www.baifubao.com";
        this.B = "https://www.baifubao.com";
        this.C = b.o;
        this.D = "https://www.baifubao.com";
        this.E = "https://chong.baidu.com";
        this.F = "https://www.dxmpay.com";
        this.G = b.q;
        this.H = "https://www.dxmpay.com";
        this.I = "https://www.dxmpay.com";
        this.J = "https://www.dxmpay.com";
        this.K = "https://cp01-ocean-1481.epc.baidu.com:8443";
        this.L = b.p;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Q == null) {
                Q = new c();
            }
            return Q;
        }
        return (c) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.S = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.T = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.U = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.V = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.W = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.X = str;
        }
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.U)) {
                return this.U;
            }
            return this.D;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.W)) {
                return this.W;
            }
            return this.F;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.Y)) {
                return this.Y;
            }
            return this.J;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.ab)) {
                return this.ab;
            }
            return this.G;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.T)) {
                return this.T;
            }
            return this.C;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getHawkinghost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.af) ? this.af : "https://www.baifubao.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(int i2, Boolean[] boolArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (TextUtils.isEmpty(this.U)) {
                if (i2 != 2) {
                    return i2 != 3 ? "https://www.baifubao.com" : z;
                }
                return this.D;
            }
            return this.U;
        }
        return (String) invokeIL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.R)) {
                return this.R;
            }
            return this.A;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.X)) {
                return this.X;
            }
            return this.H;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.S)) {
                return this.S;
            }
            return this.B;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNetcheckhost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.V)) {
                return this.V;
            }
            return this.E;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.Z)) {
                return this.Z;
            }
            return this.I;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getSensorhost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.ac)) {
                return this.ac;
            }
            return this.K;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            if (!TextUtils.isEmpty(this.aa)) {
                return this.aa;
            }
            return this.L;
        }
        return (String) invokeL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.Y = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.Z = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.aa = str;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.ab = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.ac = str;
        }
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("life_host");
            if (!TextUtils.isEmpty(optString) && P.matcher(optString).matches()) {
                this.A = optString;
            } else {
                this.A = "https://www.baifubao.com";
            }
            String optString2 = jSONObject.optString(a.f52975b);
            if (!TextUtils.isEmpty(optString2) && P.matcher(optString2).matches()) {
                this.C = optString2;
            } else {
                this.C = b.o;
            }
            String optString3 = jSONObject.optString("nfc_host");
            if (!TextUtils.isEmpty(optString3) && P.matcher(optString3).matches()) {
                this.E = optString3;
            } else {
                this.E = "https://chong.baidu.com";
            }
            String optString4 = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString4) && P.matcher(optString4).matches()) {
                this.D = optString4;
                com.baidu.apollon.heartbeat.a.c().b(this.U);
            } else {
                this.D = "https://www.baifubao.com";
                com.baidu.apollon.heartbeat.a.c().b(this.D);
            }
            String optString5 = jSONObject.optString(a.f52978e);
            if (!TextUtils.isEmpty(optString5) && P.matcher(optString5).matches()) {
                this.F = optString5;
                this.H = optString5;
                this.J = optString5;
                this.I = optString5;
            } else {
                this.F = "https://www.baifubao.com";
                this.H = "https://m.baifubao.com";
                this.J = "https://co.baifubao.com";
                this.I = "https://qianbao.baidu.com";
            }
            String optString6 = jSONObject.optString(a.f52979f);
            if (!TextUtils.isEmpty(optString6) && P.matcher(optString6).matches()) {
                this.L = optString6;
            } else {
                this.L = WapPayActivity.HOST;
            }
            String optString7 = jSONObject.optString("comet_host");
            if (!TextUtils.isEmpty(optString7) && P.matcher(optString7).matches()) {
                this.G = optString7;
            } else {
                this.G = b.q;
            }
            String optString8 = jSONObject.optString("my_host");
            if (!TextUtils.isEmpty(optString8) && P.matcher(optString8).matches()) {
                this.B = optString8;
            } else {
                this.B = "https://www.baifubao.com";
            }
            String optString9 = jSONObject.optString(a.f52982i);
            if (!TextUtils.isEmpty(optString9) && P.matcher(optString9).matches()) {
                this.ad = optString9;
            } else {
                this.ad = "https://www.baifubao.com";
            }
            String optString10 = jSONObject.optString(a.f52983j);
            if (TextUtils.isEmpty(optString10) && P.matcher(optString10).matches()) {
                this.ae = optString10;
            } else {
                this.ae = "https://bi-sensors.duxiaoman.com";
            }
            String optString11 = jSONObject.optString(a.f52984k);
            if (TextUtils.isEmpty(optString11) && P.matcher(optString11).matches()) {
                this.af = optString11;
            } else {
                this.af = "https://qianbao.baidu.com";
            }
            String optString12 = jSONObject.optString(a.l);
            if (TextUtils.isEmpty(optString12) && P.matcher(optString12).matches()) {
                this.ag = optString12;
            } else {
                this.ag = a.l;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.R = str;
        }
    }
}
