package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.tieba.b20;
import com.baidu.tieba.o10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class m10 implements o10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y10 a;
    public v10 b;
    public boolean c;

    public m10(t10 t10Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t10Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b20.b b = b20.b();
        b.c(t10Var);
        this.a = b.b();
    }

    @Override // com.baidu.tieba.o10
    public Response a(o10.a aVar) throws IOException {
        InterceptResult invokeL;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (!this.c) {
                e20 e20Var = (e20) aVar;
                Request request = aVar.request();
                NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                if (request.body() == null) {
                    contentLength = 0;
                } else {
                    contentLength = request.body().contentLength();
                }
                networkStatRecord.requestBodyLength = contentLength;
                v10 c = c(request);
                this.b = c;
                return e20Var.b(request, c);
            }
            throw new IOException("The request has been cancelled.");
        }
        return (Response) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            v10 v10Var = this.b;
            if (v10Var != null) {
                v10Var.disconnect();
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

    public final v10 c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) {
            return this.a.a(request);
        }
        return (v10) invokeL.objValue;
    }
}
