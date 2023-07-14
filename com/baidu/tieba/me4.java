package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes7.dex */
public class me4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements oq3<vg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;
        public final /* synthetic */ String b;

        public a(c42 c42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(vg3 vg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg3Var) == null) {
                if (vg3Var == null || vg3Var.d || vg3Var.j != 1) {
                    me4.c(this.a, "system deny");
                } else {
                    me4.e(this.a, this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969773, "Lcom/baidu/tieba/me4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969773, "Lcom/baidu/tieba/me4;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void c(c42 c42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, c42Var, str) == null) {
            e64 e64Var = new e64();
            e64Var.errMsg = str;
            he4.call(c42Var, false, e64Var);
        }
    }

    public static void d(JsObject jsObject) {
        c42 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) != null) || (F = c42.F(jsObject)) == null) {
            return;
        }
        vb3 b0 = vb3.b0();
        if (b0 == null) {
            c(F, "internal error");
            return;
        }
        String C = F.C("domain", PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE);
        if (a) {
            Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + C);
        }
        b0.e0().e("mapp_uuap_info", new a(F, C));
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(ParamableElem.DIVIDE_PARAM)) {
                if (str2 != null && str2.contains("=")) {
                    int indexOf = str2.indexOf("=");
                    hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void e(c42 c42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, c42Var, str) == null) {
            ne4 ne4Var = new ne4();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f = f(cookie);
                ne4Var.uuap_p_token = f.get("UUAP_P_TOKEN");
                ne4Var.uuap_p_token_offline = f.get("UUAP_P_TOKEN_OFFLINE");
                ne4Var.uuap_s_token = f.get("UUAP_S_TOKEN");
            }
            he4.call(c42Var, true, ne4Var);
        }
    }
}
