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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public class v64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements xi3<e93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw1 a;
        public final /* synthetic */ String b;

        public a(lw1 lw1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw1Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(e93 e93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e93Var) == null) {
                if (e93Var == null || e93Var.d || e93Var.j != 1) {
                    v64.c(this.a, "system deny");
                } else {
                    v64.e(this.a, this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192725, "Lcom/baidu/tieba/v64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192725, "Lcom/baidu/tieba/v64;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void c(lw1 lw1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, lw1Var, str) == null) {
            ny3 ny3Var = new ny3();
            ny3Var.errMsg = str;
            q64.call(lw1Var, false, ny3Var);
        }
    }

    public static void d(JsObject jsObject) {
        lw1 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) != null) || (F = lw1.F(jsObject)) == null) {
            return;
        }
        e43 b0 = e43.b0();
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
            for (String str2 : str.split(";")) {
                if (str2 != null && str2.contains("=")) {
                    int indexOf = str2.indexOf("=");
                    hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void e(lw1 lw1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, lw1Var, str) == null) {
            w64 w64Var = new w64();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f = f(cookie);
                w64Var.uuap_p_token = f.get("UUAP_P_TOKEN");
                w64Var.uuap_p_token_offline = f.get("UUAP_P_TOKEN_OFFLINE");
                w64Var.uuap_s_token = f.get("UUAP_S_TOKEN");
            }
            q64.call(lw1Var, true, w64Var);
        }
    }
}
