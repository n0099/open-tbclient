package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nd1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class od1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends mb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public a(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // com.baidu.tieba.mb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                nd1.a aVar = new nd1.a();
                aVar.a = 2;
                aVar.b = id1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mb1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                nd1.a aVar = new nd1.a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") == 0) {
                        aVar.a = 0;
                        aVar.b = jSONObject.optString("msg");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        aVar.c = optJSONObject.optLong("totalAmount");
                        aVar.d = optJSONObject.optLong("userPayAmount");
                        aVar.f = optJSONObject.optString("usedHostMarketingDetail");
                        aVar.h = nd1.a.C0358a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = id1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                }
                this.a.a(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends mb1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd1 a;

        public b(nd1 nd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nd1Var;
        }

        @Override // com.baidu.tieba.mb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                nd1.a aVar = new nd1.a();
                aVar.a = 2;
                aVar.b = id1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                this.a.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mb1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                nd1.a aVar = new nd1.a();
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
                        aVar.h = nd1.a.C0358a.c(optJSONObject.optJSONArray("promotionStatus"));
                    } else {
                        aVar.a = jSONObject.optInt("errorLevel", 2);
                        aVar.b = jSONObject.optString("msg");
                    }
                } catch (Exception unused) {
                    aVar.a = 2;
                    aVar.b = id1.a().getResources().getString(R.string.obfuscated_res_0x7f0f0367);
                }
                this.a.a(aVar);
            }
        }
    }

    public static void a(Bundle bundle, nd1 nd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bundle, nd1Var) == null) {
            ob1 ob1Var = new ob1();
            vb1.d(ob1Var);
            String string = bundle.getString("bduss");
            bundle.remove("bduss");
            c(string, ob1Var);
            String string2 = bundle.getString("openBduss");
            bundle.remove("openBduss");
            e(string2, ob1Var);
            String string3 = bundle.getString("clientId");
            bundle.remove("clientId");
            d(string3, ob1Var);
            nb1 nb1Var = new nb1();
            nb1Var.d("appKey", bundle.get("appKey").toString());
            nb1Var.d("totalAmount", bundle.get("totalAmount").toString());
            nb1Var.d("hostMarketingDetail", bundle.get("hostMarketingDetail").toString());
            new sb1().a(wb1.b(), ob1Var, nb1Var, new b(nd1Var));
        }
    }

    public static void b(String str, String str2, String str3, List<String> list, nd1 nd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, list, nd1Var) == null) {
            ob1 ob1Var = new ob1();
            vb1.d(ob1Var);
            if (!TextUtils.isEmpty(str)) {
                ob1Var.d("Cookie", "BDUSS=" + str);
            }
            nb1 nb1Var = new nb1();
            nb1Var.d("appKey", str2);
            nb1Var.d("totalAmount", str3);
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
                nb1Var.d("hostMarketingDetail", jSONArray.toString());
            }
            new sb1().a(wb1.b(), ob1Var, nb1Var, new a(nd1Var));
        }
    }

    public static void c(String str, ob1 ob1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, ob1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String a2 = ob1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                ob1Var.d("Cookie", str2);
                return;
            }
            ob1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static void d(String str, ob1 ob1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, ob1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String a2 = ob1Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                ob1Var.d("Cookie", str2);
                return;
            }
            ob1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static void e(String str, ob1 ob1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, ob1Var) == null) && str != null && !TextUtils.isEmpty(str)) {
            String a2 = ob1Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                ob1Var.d("Cookie", str2);
                return;
            }
            ob1Var.d("Cookie", a2 + "; " + str2);
        }
    }
}
