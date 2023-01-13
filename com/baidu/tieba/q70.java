package com.baidu.tieba;

import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.tieba.z60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.URISyntaxException;
/* loaded from: classes5.dex */
public class q70 implements z60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q70() {
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

    @Override // com.baidu.tieba.z60
    public Response a(z60.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            Request request = aVar.request();
            try {
                return aVar.a(request);
            } catch (RuntimeException e) {
                if (e.getCause() != null && (e.getCause() instanceof URISyntaxException)) {
                    throw new IOException(e);
                }
                if ((e instanceof IllegalStateException) && e.getMessage().contains("Unexpected readData call. Buffer is null")) {
                    throw new IOException(e);
                }
                throw new RuntimeException(e.getMessage() + " request url == " + request.url(), e);
            }
        }
        return (Response) invokeL.objValue;
    }
}
