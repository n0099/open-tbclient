package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;

    public u05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayMap();
    }

    @NonNull
    public static u05 b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            u05 u05Var = new u05();
            if (!str2.startsWith("http") && !str2.startsWith("https")) {
                if (str2.startsWith("dialoginternal://")) {
                    Uri parse = Uri.parse(str2);
                    for (String str3 : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str3);
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(queryParameter)) {
                            u05Var.a.put(str3, queryParameter);
                        }
                    }
                    u05Var.a.put("yun_dialogClass", parse.getAuthority());
                    u05Var.a.put("yun_dialogName", str);
                    u05Var.a.put("yun_dialogUrl", str2);
                }
            } else {
                u05Var.a.put("yun_dialogClass", "WebViewYunDialog");
                u05Var.a.put("yun_dialogName", str);
                u05Var.a.put("yun_dialogUrl", str2);
            }
            return u05Var;
        }
        return (u05) invokeLL.objValue;
    }

    public String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.a.get(str);
        }
        return (String) invokeL.objValue;
    }
}
