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
/* loaded from: classes6.dex */
public class uo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull to0 to0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, to0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(to0Var.a);
                Object obj = to0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                if (to0Var.k) {
                    builder.header("Content-Type", "application/x-www-form-urlencoded");
                    builder.header(BOSTokenRequest.CHARSET, "UTF-8");
                    builder.header(HTTP.CONN_DIRECTIVE, "close");
                    builder.header(BOSTokenRequest.ACCEPT, "*/*");
                }
                Headers.a aVar = to0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.header(c.f(i), c.h(i));
                    }
                }
                String str = to0Var.b;
                builder.method(str, qo0.g(str, to0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + to0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
