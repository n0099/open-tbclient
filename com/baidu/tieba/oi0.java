package com.baidu.tieba;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class oi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Long a;
    public static Long b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final oi0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-545974987, "Lcom/baidu/tieba/oi0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-545974987, "Lcom/baidu/tieba/oi0$b;");
                    return;
                }
            }
            a = new oi0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948033075, "Lcom/baidu/tieba/oi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948033075, "Lcom/baidu/tieba/oi0;");
                return;
            }
        }
        a = 30000L;
        b = null;
    }

    public /* synthetic */ oi0(a aVar) {
        this();
    }

    @NonNull
    public static oi0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (oi0) invokeV.objValue;
    }

    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String b() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String d = d();
            if (TextUtils.isEmpty(d)) {
                try {
                    if (Build.VERSION.SDK_INT < 19) {
                        a2 = a();
                    } else if (m21.e() && System.currentTimeMillis() - b.longValue() < a.longValue()) {
                        return a() + " " + mi0.a().x().toLowerCase() + "/" + mi0.a().u() + " (Baidu; P1 " + mi0.a().b() + ") nadcorevendor/5.8.0.17";
                    } else {
                        a2 = WebSettings.getDefaultUserAgent(mi0.b());
                    }
                } catch (Throwable unused) {
                    a2 = a();
                }
                String str = a2 + " " + mi0.a().x().toLowerCase() + "/" + mi0.a().u() + " (Baidu; P1 " + mi0.a().b() + ") nadcorevendor/5.8.0.17";
                e(str);
                return str;
            }
            return d;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SharedPreferences sharedPreferences = mi0.b().getSharedPreferences("uad_useragent", 0);
            String string = sharedPreferences.getString(f(), null);
            if (TextUtils.isEmpty(string) && sharedPreferences.getAll().size() > 0) {
                sharedPreferences.edit().clear().apply();
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void e(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            String f = f();
            SharedPreferences.Editor edit = mi0.b().getSharedPreferences("uad_useragent", 0).edit();
            edit.putString(f, str);
            edit.apply();
        }
    }

    @NonNull
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "uad_sys_useragent" + mi0.a().u();
        }
        return (String) invokeV.objValue;
    }

    public oi0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b = Long.valueOf(System.currentTimeMillis());
    }
}
