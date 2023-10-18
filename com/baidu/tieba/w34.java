package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tieba.a63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes8.dex */
public class w34 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w34 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w34() {
        super(wo2.c());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static w34 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (w34.class) {
                    if (a == null) {
                        a = new w34();
                    }
                }
            }
            return a;
        }
        return (w34) invokeV.objValue;
    }

    public static w34 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            w34 w34Var = new w34();
            w34Var.setHttpDnsEnable(c().getHttpDnsEnable());
            return w34Var;
        }
        return (w34) invokeV.objValue;
    }

    public void a(Request request, List<Interceptor> list, Callback callback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, request, list, callback) != null) || request == null) {
            return;
        }
        OkHttpClient.Builder newBuilder = getOkHttpClient().newBuilder();
        if (list != null && !list.isEmpty()) {
            for (Interceptor interceptor : list) {
                if (interceptor != null) {
                    newBuilder.addInterceptor(interceptor);
                }
            }
        }
        newBuilder.build().newCall(request).enqueue(callback);
    }

    public void b(Request request, Callback callback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, callback) == null) && request != null) {
            getOkHttpClient().newCall(request).enqueue(callback);
        }
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        a63.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (p53.M() == null) {
                return super.initClient();
            }
            j54 j54Var = (j54) p53.M().U();
            OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
            int i = 60000;
            if (j54Var != null && (aVar = j54Var.a) != null) {
                i = aVar.a;
                newBuilder.connectTimeout(aVar.b, TimeUnit.MILLISECONDS);
                newBuilder.addNetworkInterceptor(new ix2());
            }
            long j = i;
            newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            OkHttpClient build = newBuilder.build();
            build.dispatcher().setMaxRequests(10);
            return build;
        }
        return (OkHttpClient) invokeV.objValue;
    }
}
