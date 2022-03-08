package com.baidu.wallet.core.domain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "https://qianbao.baidu.com";
    public static final Pattern B;
    public static final String m = "https://www.baifubao.com";
    public static final String n = "https:/chong.baidu.com";
    public static final String o = "https://xinyongka.baidu.com";
    public static final String p = "https://zhifu.duxiaoman.com";
    public static final String q = "https://comet.baifubao.com";
    public static final String r = "http://wappass.baidu.com";
    public static final String s = "https://www.dxmpay.com";
    public static final String t = "https://www.dxmpay.com";
    public static final String u = "https://www.dxmpay.com";
    public static final String v = "https://www.dxmpay.com";
    public static final String w = "https://app.duxiaoman.com";
    public static final String x = "https://app.duxiaomanfintech.com";
    public static final String y = "https://bi-sensors.duxiaoman.com";
    public static final String z = "https://jin.baidu.com";
    public transient /* synthetic */ FieldHolder $fh;
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
    public String M;
    public String N;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1294657884, "Lcom/baidu/wallet/core/domain/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1294657884, "Lcom/baidu/wallet/core/domain/b;");
                return;
            }
        }
        B = Pattern.compile("^https://.*\\.com");
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.F) ? this.F : "https://www.baifubao.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.G) ? this.G : "https://www.dxmpay.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.G) ? this.G : "https://www.dxmpay.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.I) ? this.I : q;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.D) ? this.D : o;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getHawkinghost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.M) ? this.M : "https://qianbao.baidu.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(int i2, @NonNull Boolean[] boolArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return i2 != 2 ? i2 != 3 ? "https://www.baifubao.com" : x : TextUtils.isEmpty(this.K) ? w : this.K;
        }
        return (String) invokeIL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.C) ? this.C : "https://www.baifubao.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.G) ? this.G : "https://www.dxmpay.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.J) ? this.J : "https://www.baifubao.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNetcheckhost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.N) ? this.N : "https://jin.baidu.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.E) ? this.E : n;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.G) ? this.G : "https://www.dxmpay.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getSensorhost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.L) ? this.L : "https://bi-sensors.duxiaoman.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.F) ? this.F : "https://www.baifubao.com";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost(Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, boolArr)) == null) {
            boolArr[0] = Boolean.TRUE;
            return !TextUtils.isEmpty(this.H) ? this.H : p;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("life_host");
            if (!TextUtils.isEmpty(optString) && B.matcher(optString).matches()) {
                this.C = optString;
            } else {
                this.C = "";
            }
            String optString2 = jSONObject.optString(a.f49564b);
            if (!TextUtils.isEmpty(optString2) && B.matcher(optString2).matches()) {
                this.D = optString2;
            } else {
                this.D = "";
            }
            String optString3 = jSONObject.optString("nfc_host");
            if (!TextUtils.isEmpty(optString3) && B.matcher(optString3).matches()) {
                this.E = optString3;
            } else {
                this.E = "";
            }
            String optString4 = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString4) && B.matcher(optString4).matches()) {
                this.F = optString4;
                com.baidu.apollon.heartbeat.a.c().b(this.F);
            } else {
                this.F = "";
                com.baidu.apollon.heartbeat.a.c().b("https://www.baifubao.com");
            }
            String optString5 = jSONObject.optString(a.f49567e);
            if (!TextUtils.isEmpty(optString5) && B.matcher(optString5).matches()) {
                this.G = optString5;
            } else {
                this.G = "";
            }
            String optString6 = jSONObject.optString(a.f49568f);
            if (!TextUtils.isEmpty(optString6) && B.matcher(optString6).matches()) {
                this.H = optString6;
            } else {
                this.H = "";
            }
            String optString7 = jSONObject.optString("comet_host");
            if (!TextUtils.isEmpty(optString7) && B.matcher(optString7).matches()) {
                this.I = optString7;
            } else {
                this.I = "";
            }
            String optString8 = jSONObject.optString("my_host");
            if (!TextUtils.isEmpty(optString8) && B.matcher(optString8).matches()) {
                this.J = optString8;
            } else {
                this.J = "";
            }
            String optString9 = jSONObject.optString(a.f49571i);
            if (!TextUtils.isEmpty(optString9) && B.matcher(optString9).matches()) {
                this.K = optString9;
            } else {
                this.K = "";
            }
            String optString10 = jSONObject.optString(a.f49572j);
            if (!TextUtils.isEmpty(optString10) && B.matcher(optString10).matches()) {
                this.L = optString10;
            } else {
                this.L = "";
            }
            String optString11 = jSONObject.optString(a.k);
            if (!TextUtils.isEmpty(optString11) && B.matcher(optString11).matches()) {
                this.M = optString11;
            } else {
                this.M = "";
            }
            String optString12 = jSONObject.optString(a.l);
            if (!TextUtils.isEmpty(optString12) && B.matcher(optString12).matches()) {
                this.N = optString12;
            } else {
                this.N = "";
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
