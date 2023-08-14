package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.tieba.b70;
import com.baidu.tieba.o60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class m60 implements o60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y60 a;
    public v60 b;
    public boolean c;

    public m60(t60 t60Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t60Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b70.b b = b70.b();
        b.c(t60Var);
        this.a = b.b();
    }

    @Override // com.baidu.tieba.o60
    public Response a(o60.a aVar) throws IOException {
        InterceptResult invokeL;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (!this.c) {
                e70 e70Var = (e70) aVar;
                Request request = aVar.request();
                NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                if (request.body() == null) {
                    contentLength = 0;
                } else {
                    contentLength = request.body().contentLength();
                }
                networkStatRecord.requestBodyLength = contentLength;
                v60 c = c(request);
                this.b = c;
                return e70Var.b(request, c);
            }
            throw new IOException("The request has been cancelled.");
        }
        return (Response) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            v60 v60Var = this.b;
            if (v60Var != null) {
                v60Var.disconnect();
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

    public final v60 c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) {
            return this.a.a(request);
        }
        return (v60) invokeL.objValue;
    }
}
