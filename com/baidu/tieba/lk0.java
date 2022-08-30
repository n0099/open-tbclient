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
/* loaded from: classes4.dex */
public class lk0 implements vk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Object d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final kk0 b;
    public boolean c;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final lk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630015398, "Lcom/baidu/tieba/lk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-630015398, "Lcom/baidu/tieba/lk0$b;");
                    return;
                }
            }
            a = new lk0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947945624, "Lcom/baidu/tieba/lk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947945624, "Lcom/baidu/tieba/lk0;");
                return;
            }
        }
        d = new Object();
    }

    public /* synthetic */ lk0(a aVar) {
        this();
    }

    public static lk0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (lk0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vk0
    public int a(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            g("global");
            if (zx0.a(this.b.a(), str) && (str2 = (String) zx0.b(this.b.a(), str)) != null) {
                try {
                    return Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.vk0
    public double b(String str, double d2) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return d2;
            }
            g("global");
            if (zx0.a(this.b.a(), str) && (str2 = (String) zx0.b(this.b.a(), str)) != null) {
                try {
                    return Double.parseDouble(str2);
                } catch (NumberFormatException unused) {
                }
            }
            return d2;
        }
        return invokeCommon.doubleValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.d = true;
        }
    }

    public void e(@Nullable String str) throws ADConfigError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                JSONObject c = yx0.c(str);
                if (c.has("error_code")) {
                    if (TextUtils.equals(c.optString("error_code"), "0")) {
                        if (c.has("error_message")) {
                            if (TextUtils.equals(c.optString("error_message"), "success")) {
                                String optString = c.optString("data");
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject c2 = yx0.c(optString);
                                    String optString2 = c2.optString("sign");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        if (TextUtils.equals(optString2, fy0.a().b("nad_app_quick_config").getString("_ad_adc_conf_sign", ""))) {
                                            return;
                                        }
                                        fy0.a().b("nad_app_quick_config").i("_ad_adc_conf_sign", optString2);
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

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.d = false;
        }
    }

    public final void g(String str) {
        Map<String, ?> all;
        Map<String, ?> all2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            fy0 a2 = fy0.a();
            cy0 b2 = a2.b("nad.launch.config." + str);
            if ("global".equals(str)) {
                if (this.c || (all2 = b2.getAll()) == null) {
                    return;
                }
                zx0.f(this.b.a(), all2);
                this.c = true;
            } else if (((Map) zx0.b(this.b.b(), str)) == null && (all = b2.getAll()) != null) {
                zx0.e(this.b.b(), str, all);
            }
        }
    }

    public lk0() {
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
        this.b = new kk0();
        this.c = false;
    }
}
