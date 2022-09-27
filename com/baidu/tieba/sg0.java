package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class sg0 extends ji0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends lq0<Map<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k61 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ri0 e;
        public final /* synthetic */ ni0 f;
        public final /* synthetic */ HashMap g;
        public final /* synthetic */ String h;
        public final /* synthetic */ sg0 i;

        public a(sg0 sg0Var, k61 k61Var, String str, Context context, String str2, ri0 ri0Var, ni0 ni0Var, HashMap hashMap, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg0Var, k61Var, str, context, str2, ri0Var, ni0Var, hashMap, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = sg0Var;
            this.a = k61Var;
            this.b = str;
            this.c = context;
            this.d = str2;
            this.e = ri0Var;
            this.f = ni0Var;
            this.g = hashMap;
            this.h = str3;
        }

        @Override // com.baidu.tieba.jq0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.a.dismiss();
                this.i.n("4", this.b);
                boolean l = this.i.l(this.c, this.d, this.b);
                this.i.c(this.e, this.f, l ? 0 : 1001, l);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kq0
        /* renamed from: e */
        public void b(Headers headers, @Nullable Map<String, String> map, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, map, i) == null) {
                this.a.dismiss();
                if (map == null) {
                    this.i.n("8", this.b);
                    boolean l = this.i.l(this.c, this.d, this.b);
                    this.i.c(this.e, this.f, l ? 0 : 1001, l);
                    return;
                }
                String str = (String) yz0.b(map, "virtualPhone");
                if (TextUtils.isEmpty(str)) {
                    this.i.n("5", this.b);
                    boolean l2 = this.i.l(this.c, this.d, this.b);
                    this.i.c(this.e, this.f, l2 ? 0 : 1001, l2);
                    return;
                }
                String str2 = (String) yz0.b(map, "solutionId");
                if (TextUtils.isEmpty(str2)) {
                    this.i.n("6", this.b);
                    boolean l3 = this.i.l(this.c, this.d, this.b);
                    this.i.c(this.e, this.f, l3 ? 0 : 1001, l3);
                    return;
                }
                String str3 = (String) yz0.b(this.g, "log_url");
                if (str3 == null) {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    this.i.n("3", this.b);
                } else {
                    this.i.n("7", this.b);
                    String replaceAll = str3.replaceAll("\\__TIMESTAMP__", this.h).replaceAll("\\__VIRTUALPHONE__", str).replaceAll("\\__SOLUTIONID__", str2);
                    sq0 sq0Var = new sq0();
                    sq0Var.k(replaceAll);
                    sq0Var.g(3000);
                    sq0Var.c();
                    zp0.b().a().a(sq0Var, null);
                }
                boolean l4 = this.i.l(this.c, str, this.b);
                this.i.c(this.e, this.f, l4 ? 0 : 1001, l4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kq0
        @Nullable
        /* renamed from: f */
        public Map<String, String> d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? sg0.m(str) : (Map) invokeLLI.objValue;
        }
    }

    public sg0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Map<String, String> m(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONArray optJSONArray = xz0.c(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            hashMap.put("virtualPhone", optJSONObject.optString("virtualPhone"));
            hashMap.put("solutionId", optJSONObject.optString("solutionId"));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ji0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? NotificationCompat.CATEGORY_CALL : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ji0
    public boolean b(@NonNull Context context, @NonNull ni0 ni0Var, @Nullable Map<String, Object> map, @Nullable ri0 ri0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ni0Var, map, ri0Var)) == null) {
            super.b(context, ni0Var, map, ri0Var);
            HashMap<String, String> d = ni0Var.d();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = (String) yz0.b(d, "ext_info");
            String str2 = (String) yz0.b(d, "phone");
            if (TextUtils.isEmpty(str2)) {
                n("1", str);
                c(ri0Var, ni0Var, 202, false);
                return true;
            }
            if (TextUtils.equals(d.containsKey("type") ? (String) yz0.b(d, "type") : "0", "1")) {
                String str3 = (String) yz0.b(d, "number_url");
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str4)) {
                    n("2", str);
                    boolean l = l(context, str2, str);
                    c(ri0Var, ni0Var, l ? 0 : 1001, l);
                    return true;
                }
                k61 k61Var = new k61(context);
                k61Var.e(context.getString(R.string.obfuscated_res_0x7f0f0be8));
                k61Var.c(false);
                k61Var.d(false);
                n21.b(k61Var);
                a aVar = new a(this, k61Var, str, context, str2, ri0Var, ni0Var, d, valueOf);
                String replaceAll = str4.replaceAll("\\__TIMESTAMP__", valueOf);
                sq0 sq0Var = new sq0();
                sq0Var.k(replaceAll);
                sq0Var.g(3000);
                sq0Var.c();
                zp0.b().a().a(sq0Var, aVar);
            } else {
                boolean l2 = l(context, str2, str);
                c(ri0Var, ni0Var, l2 ? 0 : 1001, l2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean l(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (n21.d(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)))) {
                n("11", str2);
                new f81().p(context, str2, "makePhoneCall");
                return true;
            }
            n("9", str2);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void n(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        h01.b(new ClogBuilder().u(ClogBuilder.Page.AD_CALL).i(ClogBuilder.Area.AD_CALL).y(ClogBuilder.LogType.AD_CALL).k(str).p(str2));
    }
}
