package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes8.dex */
public class uc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HttpRequestBuilder a(@NonNull sc4 sc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sc4Var)) == null) {
            return b(sc4Var, null);
        }
        return (HttpRequestBuilder) invokeL.objValue;
    }

    @NonNull
    public static HttpRequestBuilder b(@NonNull sc4 sc4Var, @Nullable tc4 tc4Var) {
        InterceptResult invokeLL;
        HttpCommonRequestBuilder o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sc4Var, tc4Var)) == null) {
            if (tc4Var == null) {
                tc4Var = tc4.g();
            }
            String str = sc4Var.b;
            char c = 65535;
            switch (str.hashCode()) {
                case -531492226:
                    if (str.equals(HttpOptions.METHOD_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case 70454:
                    if (str.equals("GET")) {
                        c = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (str.equals(HttpPut.METHOD_NAME)) {
                        c = 4;
                        break;
                    }
                    break;
                case 2213344:
                    if (str.equals("HEAD")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2461856:
                    if (str.equals("POST")) {
                        c = 3;
                        break;
                    }
                    break;
                case 80083237:
                    if (str.equals(HttpTrace.METHOD_NAME)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (str.equals("CONNECT")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return tc4Var.getRequest();
                case 1:
                    return tc4Var.headerRequest();
                case 2:
                    o = tc4Var.o();
                    break;
                case 3:
                    o = tc4Var.postRequest();
                    break;
                case 4:
                    o = tc4Var.putRequest();
                    break;
                case 5:
                    o = tc4Var.deleteRequest();
                    break;
                case 6:
                    o = tc4Var.y();
                    break;
                case 7:
                    o = tc4Var.a();
                    break;
                default:
                    return tc4Var.getRequest();
            }
            RequestBody requestBody = sc4Var.d;
            if (requestBody != null) {
                o.requestBody(requestBody);
            }
            return o;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }
}
