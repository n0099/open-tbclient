package com.baidu.tieba;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jjb extends ieb implements hjb, cjb, bjb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Gson b;

    @Override // com.baidu.tieba.ieb
    public void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
        }
    }

    @Override // com.baidu.tieba.ieb
    public boolean g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ieb
    public String h(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) ? "" : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ieb
    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ieb
    public String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? "" : (String) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends TypeToken<HashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jjb jjbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jjbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cjb
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            leb.d(str, str2);
        }
    }

    @Override // com.baidu.tieba.cjb
    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            leb.c(str, str2);
        }
    }

    @Override // com.baidu.tieba.cjb
    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            leb.f(str, str2);
        }
    }

    @Override // com.baidu.tieba.cjb
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            leb.e(str, str2);
        }
    }

    @Override // com.baidu.tieba.bjb
    public ajb e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            dfb dfbVar = new dfb();
            dfbVar.a = "onDnsHostResolve";
            dfbVar.b.put("hostName", str);
            jeb<String> m = m(new Gson().toJson(dfbVar));
            ajb ajbVar = new ajb();
            if (m.a) {
                String str2 = m.b;
                if (str2 != null && !str2.isEmpty()) {
                    ajb a2 = ajb.a(str2);
                    TLog.h("[PreferenceServer]", "onDnsHostResolve get result from mainProcess，success:" + a2.e + ",dnsResolveType:" + a2.c + ",ipsV4 size:" + a2.a.length + ",ipsV6 size:" + a2.b.length);
                    return a2;
                }
                return ajbVar;
            }
            TLog.d("[PreferenceServer]", "onDnsHostResolve send failed!");
            return ajbVar;
        }
        return (ajb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ieb
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                n(str);
            } catch (Exception e) {
                e.printStackTrace();
                TLog.d("[PreferenceServer]", "(onDataFromClient) ex" + e.getMessage());
            }
        }
    }

    public final void n(String str) throws Exception {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cmd");
            int hashCode = optString.hashCode();
            if (hashCode != -544151029) {
                if (hashCode != 1082990212) {
                    if (hashCode == 1360518598 && optString.equals("testSubprocessCrash")) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (optString.equals("setMediaConfig")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (optString.equals("initPreference")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        TLog.h("[PreferenceServer]", "testSubprocessCrash, crash immediately!!!");
                        TransVodProxy.e();
                        return;
                    }
                    return;
                }
                HashMap hashMap = (HashMap) this.b.fromJson(jSONObject.getJSONObject("data").optString("configs"), new a(this).getType());
                if (hashMap != null) {
                    TLog.h("[PreferenceServer]", "setMediaConfig");
                    Preference.k(hashMap);
                    return;
                }
                return;
            }
            xib.c(true);
            Preference.l(this);
            Preference.j(this);
            Preference.i(this);
            TLog.h("[PreferenceServer]", "initPreference");
        }
    }
}
