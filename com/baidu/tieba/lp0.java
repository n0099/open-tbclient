package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class lp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull kp0 kp0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, kp0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(kp0Var.a);
                Object obj = kp0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                if (kp0Var.h) {
                    builder.header("Content-Type", "application/x-www-form-urlencoded");
                    builder.header(BOSTokenRequest.CHARSET, "UTF-8");
                    builder.header(HTTP.CONN_DIRECTIVE, "close");
                    builder.header("accept", "*/*");
                }
                Headers.a aVar = kp0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.header(c.f(i), c.h(i));
                    }
                }
                String str = kp0Var.b;
                builder.method(str, hp0.g(str, kp0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + kp0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
