package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.tieba.i50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class v50 implements i50.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<i50> a;
    public n50 b;
    public final int c;
    public final Request d;
    public final Call e;
    public int f;

    public v50(List<i50> list, n50 n50Var, int i, Request request, Call call) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, n50Var, Integer.valueOf(i), request, call};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = n50Var;
        this.c = i;
        this.d = request;
        this.e = call;
    }

    @Override // com.baidu.tieba.i50.a
    public Response a(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) ? b(request, this.b) : (Response) invokeL.objValue;
    }

    public Response b(Request request, n50 n50Var) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, n50Var)) == null) {
            if (this.c < this.a.size()) {
                this.f++;
                v50 v50Var = new v50(this.a, n50Var, this.c + 1, request, this.e);
                i50 i50Var = this.a.get(this.c);
                Response a = i50Var.a(v50Var);
                if (a != null) {
                    if (a.body() != null) {
                        a.getStatRecord().responseLength = a.body().contentLength();
                        a.getStatRecord().finishTs = System.currentTimeMillis();
                        MediaType contentType = a.body().contentType();
                        if (contentType != null) {
                            a.getStatRecord().contentType = contentType.toString();
                        }
                        return a;
                    }
                    throw new IllegalStateException("interceptor " + i50Var + " returned a response with no body");
                }
                throw new NullPointerException("interceptor " + i50Var + " returned null");
            }
            throw new AssertionError();
        }
        return (Response) invokeLL.objValue;
    }

    public Call call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (Call) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i50.a
    public n50 connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (n50) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i50.a
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (Request) invokeV.objValue;
    }
}
