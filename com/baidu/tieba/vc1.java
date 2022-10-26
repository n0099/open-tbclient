package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uc1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a extends ta1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc1 a;

        public a(uc1 uc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc1Var;
        }

        @Override // com.baidu.tieba.ta1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                uc1.a aVar = new uc1.a();
                aVar.a = 2;
                aVar.b = pc1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0366);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ta1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                uc1.a aVar = new uc1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = uc1.a.C0418a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = pc1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0366);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends ta1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc1 a;

        public b(uc1 uc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc1Var;
        }

        @Override // com.baidu.tieba.ta1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                uc1.a aVar = new uc1.a();
                aVar.a = 2;
                aVar.b = pc1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0366);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ta1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                uc1.a aVar = new uc1.a();
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
                        aVar.h = uc1.a.C0418a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = pc1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0366);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, uc1 uc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, uc1Var) == null) {
            va1 va1Var = new va1();
            cb1.d(va1Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, va1Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, va1Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, va1Var);
            ua1 ua1Var = new ua1();
            ua1Var.d("appKey", bundle.get("appKey").toString());
            ua1Var.d("totalAmount", bundle.get("totalAmount").toString());
            ua1Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new za1().a(db1.b(), va1Var, ua1Var, new b(uc1Var));
        }
    }

    public static void b(String str, String str2, String str3, List list, uc1 uc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, uc1Var) == null) {
            va1 va1Var = new va1();
            cb1.d(va1Var);
            if (!TextUtils.isEmpty(str)) {
                va1Var.d("Cookie", "BDUSS=" + str);
            }
            ua1 ua1Var = new ua1();
            ua1Var.d("appKey", str2);
            ua1Var.d("totalAmount", str3);
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            jSONArray.put(new JSONObject(str4));
                        } catch (Exception unused) {
                        }
                    }
                }
                ua1Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new za1().a(db1.b(), va1Var, ua1Var, new a(uc1Var));
        }
    }

    public static void c(String str, va1 va1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, va1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String str2 = (String) va1Var.a("Cookie");
            String str3 = "BDUSS=" + str;
            if (str2 == null) {
                va1Var.d("Cookie", str3);
                return;
            }
            va1Var.d("Cookie", str2 + "; " + str3);
        }
    }

    public static void d(String str, va1 va1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, va1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String str2 = (String) va1Var.a("Cookie");
            String str3 = "CLIENTID=" + str;
            if (str2 == null) {
                va1Var.d("Cookie", str3);
                return;
            }
            va1Var.d("Cookie", str2 + "; " + str3);
        }
    }

    public static void e(String str, va1 va1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, va1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String str2 = (String) va1Var.a("Cookie");
            String str3 = "OPENBDUSS=" + str;
            if (str2 == null) {
                va1Var.d("Cookie", str3);
                return;
            }
            va1Var.d("Cookie", str2 + "; " + str3);
        }
    }
}
