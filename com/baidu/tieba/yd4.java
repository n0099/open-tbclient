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
/* loaded from: classes8.dex */
public class yd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements aq3<hg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o32 a;
        public final /* synthetic */ String b;

        public a(o32 o32Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o32Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o32Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hg3 hg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hg3Var) == null) {
                if (hg3Var == null || hg3Var.d || hg3Var.j != 1) {
                    yd4.c(this.a, "system deny");
                } else {
                    yd4.e(this.a, this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948326304, "Lcom/baidu/tieba/yd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948326304, "Lcom/baidu/tieba/yd4;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void c(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, o32Var, str) == null) {
            q54 q54Var = new q54();
            q54Var.errMsg = str;
            td4.call(o32Var, false, q54Var);
        }
    }

    public static void d(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        hb3 b0 = hb3.b0();
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

    public static void e(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, o32Var, str) == null) {
            zd4 zd4Var = new zd4();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f = f(cookie);
                zd4Var.uuap_p_token = f.get("UUAP_P_TOKEN");
                zd4Var.uuap_p_token_offline = f.get("UUAP_P_TOKEN_OFFLINE");
                zd4Var.uuap_s_token = f.get("UUAP_S_TOKEN");
            }
            td4.call(o32Var, true, zd4Var);
        }
    }
}
