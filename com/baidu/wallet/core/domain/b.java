package com.baidu.wallet.core.domain;

import android.text.TextUtils;
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
/* loaded from: classes5.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f24863i = "https://www.baifubao.com";
    public static final String j = "https:/chong.baidu.com";
    public static final String k = "https://xinyongka.baidu.com";
    public static final String l = "https://zhifu.duxiaoman.com";
    public static final String m = "https://comet.baifubao.com";
    public static final String n = "http://wappass.baidu.com";
    public static final String o = "https://www.dxmpay.com";
    public static final String p = "https://www.dxmpay.com";
    public static final String q = "https://www.dxmpay.com";
    public static final String r = "https://www.dxmpay.com";
    public static final String s = "https://app.duxiaoman.com";
    public static final Pattern t;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

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
        t = Pattern.compile("^https://.*\\.com");
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
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.x) ? this.x : "https://www.baifubao.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.A) ? this.A : m : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !TextUtils.isEmpty(this.v) ? this.v : k : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) ? z ? TextUtils.isEmpty(this.x) ? s : this.x : "https://www.baifubao.com" : (String) invokeZ.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.u) ? this.u : "https://www.baifubao.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !TextUtils.isEmpty(this.B) ? this.B : "https://www.baifubao.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !TextUtils.isEmpty(this.w) ? this.w : j : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !TextUtils.isEmpty(this.y) ? this.y : "https://www.dxmpay.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !TextUtils.isEmpty(this.x) ? this.x : "https://www.baifubao.com" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? !TextUtils.isEmpty(this.z) ? this.z : l : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("life_host");
            if (!TextUtils.isEmpty(optString) && t.matcher(optString).matches()) {
                this.u = optString;
            } else {
                this.u = "";
            }
            String optString2 = jSONObject.optString(a.f24856b);
            if (!TextUtils.isEmpty(optString2) && t.matcher(optString2).matches()) {
                this.v = optString2;
            } else {
                this.v = "";
            }
            String optString3 = jSONObject.optString("nfc_host");
            if (!TextUtils.isEmpty(optString3) && t.matcher(optString3).matches()) {
                this.w = optString3;
            } else {
                this.w = "";
            }
            String optString4 = jSONObject.optString("app_host");
            if (!TextUtils.isEmpty(optString4) && t.matcher(optString4).matches()) {
                this.x = optString4;
                com.baidu.apollon.heartbeat.a.c().a(this.x);
            } else {
                this.x = "";
                com.baidu.apollon.heartbeat.a.c().a("https://www.baifubao.com");
            }
            String optString5 = jSONObject.optString(a.f24859e);
            if (!TextUtils.isEmpty(optString5) && t.matcher(optString5).matches()) {
                this.y = optString5;
            } else {
                this.y = "";
            }
            String optString6 = jSONObject.optString(a.f24860f);
            if (!TextUtils.isEmpty(optString6) && t.matcher(optString6).matches()) {
                this.z = optString6;
            } else {
                this.z = "";
            }
            String optString7 = jSONObject.optString("comet_host");
            if (!TextUtils.isEmpty(optString7) && t.matcher(optString7).matches()) {
                this.A = optString7;
            } else {
                this.A = "";
            }
            String optString8 = jSONObject.optString("my_host");
            if (!TextUtils.isEmpty(optString8) && t.matcher(optString8).matches()) {
                this.B = optString8;
            } else {
                this.B = "";
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
