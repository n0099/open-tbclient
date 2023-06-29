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
/* loaded from: classes8.dex */
public class xt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull wt0 wt0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wt0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(wt0Var.a);
                Object obj = wt0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                if (wt0Var.h) {
                    builder.header("Content-Type", "application/x-www-form-urlencoded");
                    builder.header(BOSTokenRequest.CHARSET, "UTF-8");
                    builder.header(HTTP.CONN_DIRECTIVE, "close");
                    builder.header("accept", "*/*");
                }
                Headers.a aVar = wt0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.header(c.f(i), c.h(i));
                    }
                }
                String str = wt0Var.b;
                builder.method(str, tt0.g(str, wt0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + wt0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
