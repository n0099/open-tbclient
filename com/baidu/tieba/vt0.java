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
public class vt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull ut0 ut0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ut0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(ut0Var.a);
                Object obj = ut0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                if (ut0Var.h) {
                    builder.header("Content-Type", "application/x-www-form-urlencoded");
                    builder.header(BOSTokenRequest.CHARSET, "UTF-8");
                    builder.header(HTTP.CONN_DIRECTIVE, "close");
                    builder.header("accept", "*/*");
                }
                Headers.a aVar = ut0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.header(c.f(i), c.h(i));
                    }
                }
                String str = ut0Var.b;
                builder.method(str, rt0.g(str, ut0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + ut0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
