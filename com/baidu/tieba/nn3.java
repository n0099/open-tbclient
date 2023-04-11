package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.h72;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nn3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008182, "Lcom/baidu/tieba/nn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008182, "Lcom/baidu/tieba/nn3;");
                return;
            }
        }
        a = eo1.a;
    }

    @NonNull
    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String string = ig3.a().getString("web_mode_host_key", "");
            if (TextUtils.isEmpty(string)) {
                return "http://radar.bcc-szth.baidu.com:8312";
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (ol3.G()) {
                return PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK;
            }
            return "42";
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String n = t73.K().q().W().n("mPage");
            if (TextUtils.isEmpty(n)) {
                return str;
            }
            try {
                List<String> c = ml3.c(new URI(n).getRawQuery());
                if (c.size() > 0) {
                    for (int i = 0; i < c.size(); i++) {
                        String str2 = c.get(i);
                        if (!TextUtils.isEmpty(str2)) {
                            String[] split = str2.split("=");
                            if (split.length > 1) {
                                str = ml3.a(str, split[0], split[1]);
                            }
                        }
                    }
                }
                return str;
            } catch (URISyntaxException e) {
                if (a) {
                    e.printStackTrace();
                }
                u42.i("SwanWebModeUtils", "appendWebUrlQuery: " + e.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (h72.b.a()) {
                str = d() + "?appKey=" + t73.K().q().getAppId();
            }
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String e = e();
            String valueOf = String.valueOf(mn3.c().g());
            String a2 = a(str);
            String c = c();
            u42.i("SwanWebModeUtils", "appendWebUrlQuery: launchUrl : " + a2 + " rawPath : " + c);
            return Uri.parse(a2).buildUpon().path(c).appendQueryParameter("_swebfr", e).appendQueryParameter("_swebcode", valueOf).appendQueryParameter("_swebHost", br2.n().a()).build().toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String n = t73.K().q().W().n("mPage");
            if (TextUtils.isEmpty(n)) {
                return "";
            }
            try {
                return new URI(n).getPath();
            } catch (URISyntaxException e) {
                if (a) {
                    e.printStackTrace();
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "swanWeb")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(nj3 nj3Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, nj3Var, i)) == null) {
            if (i == 6) {
                return true;
            }
            if (nj3Var == null) {
                return false;
            }
            if (nj3Var.h() == 1013 || nj3Var.h() == 1015) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
