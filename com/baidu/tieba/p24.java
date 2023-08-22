package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final p24 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-568020358, "Lcom/baidu/tieba/p24$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-568020358, "Lcom/baidu/tieba/p24$a;");
                    return;
                }
            }
            a = new p24();
        }
    }

    public p24() {
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

    public static p24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (p24) invokeV.objValue;
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull w24 w24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, w24Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString = jSONObject.optString("url");
            if (!optBoolean) {
                w24Var.a(new x24(31008, "download is not exist"));
            } else {
                u74.c().c(optString);
            }
        }
    }

    public void c(@NonNull JSONObject jSONObject, @NonNull w24 w24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, w24Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString = jSONObject.optString("url");
            if (!optBoolean) {
                w24Var.a(new x24(31008, "download is not exist"));
            } else {
                u74.c().e(optString);
            }
        }
    }

    public void e(@NonNull JSONObject jSONObject, @NonNull w24 w24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, w24Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString = jSONObject.optString("url");
            if (!optBoolean) {
                w24Var.a(new x24(31008, "download is not exist"));
            } else {
                u74.c().f(optString);
            }
        }
    }

    public void d(@NonNull JSONObject jSONObject, @NonNull w24 w24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, w24Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            if (!optBoolean) {
                w24Var.a(new x24(31008, "download is not exist"));
                return;
            }
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("apkId");
            String optString3 = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                if (!u74.c().a(optString3, optString, optString2, optBoolean, new r24(w24Var))) {
                    w24Var.a(new x24(31006, "is not in main process"));
                    return;
                }
                return;
            }
            w24Var.a(new x24(31007, "invalid params"));
        }
    }
}
