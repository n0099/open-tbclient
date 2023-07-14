package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mo0 implements wo0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Object d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final lo0 b;
    public boolean c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final mo0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-597692163, "Lcom/baidu/tieba/mo0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-597692163, "Lcom/baidu/tieba/mo0$b;");
                    return;
                }
            }
            a = new mo0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979259, "Lcom/baidu/tieba/mo0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979259, "Lcom/baidu/tieba/mo0;");
                return;
            }
        }
        d = new Object();
    }

    public mo0() {
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
        this.b = new lo0();
        this.c = false;
    }

    public static mo0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (mo0) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.d = true;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.d = false;
        }
    }

    public /* synthetic */ mo0(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.wo0
    public int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            g("global");
            if (!z31.a(this.b.a(), str)) {
                return i;
            }
            String str2 = (String) z31.b(this.b.a(), str);
            if (str2 != null) {
                try {
                    return Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.wo0
    public double b(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return d2;
            }
            g("global");
            if (!z31.a(this.b.a(), str)) {
                return d2;
            }
            String str2 = (String) z31.b(this.b.a(), str);
            if (str2 != null) {
                try {
                    return Double.parseDouble(str2);
                } catch (NumberFormatException unused) {
                }
            }
            return d2;
        }
        return invokeCommon.doubleValue;
    }

    public void e(@Nullable String str) throws ADConfigError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                JSONObject c = y31.c(str);
                if (c.has("error_code")) {
                    if (TextUtils.equals(c.optString("error_code"), "0")) {
                        if (c.has("error_message")) {
                            if (TextUtils.equals(c.optString("error_message"), "success")) {
                                String optString = c.optString("data");
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject c2 = y31.c(optString);
                                    String optString2 = c2.optString("sign");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        if (TextUtils.equals(optString2, k41.a().b("nad_app_quick_config").getString("_ad_adc_conf_sign", ""))) {
                                            return;
                                        }
                                        k41.a().b("nad_app_quick_config").h("_ad_adc_conf_sign", optString2);
                                        synchronized (d) {
                                            this.b.update(c2);
                                        }
                                        return;
                                    }
                                    throw ADConfigError.error("2", ADConfigError.REASON_NULL_SIGN);
                                }
                                throw ADConfigError.error("7", ADConfigError.REASON_NULL_DATA);
                            }
                            throw ADConfigError.error("5", ADConfigError.REASON_WRONG_MSG);
                        }
                        throw ADConfigError.error("6", ADConfigError.REASON_NULL_MSG);
                    }
                    throw ADConfigError.error("3", ADConfigError.REASON_WRONG_CODE);
                }
                throw ADConfigError.error("4", ADConfigError.REASON_NULL_CODE);
            }
            throw ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE_BODY);
        }
    }

    public final void g(String str) {
        Map<String, ?> all;
        Map<String, ?> all2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            k41 a2 = k41.a();
            h41 b2 = a2.b("nad.launch.config." + str);
            if ("global".equals(str)) {
                if (!this.c && (all2 = b2.getAll()) != null) {
                    z31.f(this.b.a(), all2);
                    this.c = true;
                }
            } else if (((Map) z31.b(this.b.b(), str)) == null && (all = b2.getAll()) != null) {
                z31.e(this.b.b(), str, all);
            }
        }
    }
}
