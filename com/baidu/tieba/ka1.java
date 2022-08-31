package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ja1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ka1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends i81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja1 a;

        public a(ja1 ja1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ja1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ja1Var;
        }

        @Override // com.baidu.tieba.i81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                ja1.a aVar = new ja1.a();
                aVar.a = 2;
                aVar.b = ea1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0362);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i81
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ja1.a aVar = new ja1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = ja1.a.C0306a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = ea1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0362);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends i81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja1 a;

        public b(ja1 ja1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ja1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ja1Var;
        }

        @Override // com.baidu.tieba.i81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                ja1.a aVar = new ja1.a();
                aVar.a = 2;
                aVar.b = ea1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0362);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i81
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                ja1.a aVar = new ja1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.e = optJSONObject.optLong("reduceAmount");
                        aVar.g = optJSONObject.optInt("overdueStatus");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = ja1.a.C0306a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = ea1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0362);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, ja1 ja1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, ja1Var) == null) {
            k81 k81Var = new k81();
            r81.d(k81Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, k81Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, k81Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, k81Var);
            j81 j81Var = new j81();
            j81Var.d("appKey", bundle.get("appKey").toString());
            j81Var.d("totalAmount", bundle.get("totalAmount").toString());
            j81Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new o81().a(s81.b(), k81Var, j81Var, new b(ja1Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, ja1 ja1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, ja1Var) == null) {
            k81 k81Var = new k81();
            r81.d(k81Var);
            if (!TextUtils.isEmpty(str)) {
                k81Var.d("Cookie", "BDUSS=" + str);
            }
            j81 j81Var = new j81();
            j81Var.d("appKey", str2);
            j81Var.d("totalAmount", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONArray.put(new JSONObject(str4));
                        } catch (Exception unused) {
                        }
                    }
                }
                j81Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new o81().a(s81.b(), k81Var, j81Var, new a(ja1Var));
        }
    }

    public static void c(String str, k81 k81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, k81Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = k81Var.a("Cookie");
        String str2 = "BDUSS=" + str;
        if (a2 == null) {
            k81Var.d("Cookie", str2);
            return;
        }
        k81Var.d("Cookie", a2 + "; " + str2);
    }

    public static void d(String str, k81 k81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, k81Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = k81Var.a("Cookie");
        String str2 = "CLIENTID=" + str;
        if (a2 == null) {
            k81Var.d("Cookie", str2);
            return;
        }
        k81Var.d("Cookie", a2 + "; " + str2);
    }

    public static void e(String str, k81 k81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, k81Var) == null) || str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = k81Var.a("Cookie");
        String str2 = "OPENBDUSS=" + str;
        if (a2 == null) {
            k81Var.d("Cookie", str2);
            return;
        }
        k81Var.d("Cookie", a2 + "; " + str2);
    }
}
