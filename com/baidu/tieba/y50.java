package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.tieba.a60;
import com.baidu.tieba.n60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class y50 implements a60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k60 a;
    public h60 b;
    public boolean c;

    public y50(f60 f60Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f60Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n60.b b = n60.b();
        b.c(f60Var);
        this.a = b.b();
    }

    @Override // com.baidu.tieba.a60
    public Response a(a60.a aVar) throws IOException {
        InterceptResult invokeL;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (!this.c) {
                q60 q60Var = (q60) aVar;
                Request request = aVar.request();
                NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                if (request.body() == null) {
                    contentLength = 0;
                } else {
                    contentLength = request.body().contentLength();
                }
                networkStatRecord.requestBodyLength = contentLength;
                h60 c = c(request);
                this.b = c;
                return q60Var.b(request, c);
            }
            throw new IOException("The request has been cancelled.");
        }
        return (Response) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            h60 h60Var = this.b;
            if (h60Var != null) {
                h60Var.disconnect();
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final h60 c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) {
            return this.a.a(request);
        }
        return (h60) invokeL.objValue;
    }
}
