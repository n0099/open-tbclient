package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes9.dex */
public final class p1 implements HostnameVerifier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p1() {
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

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!defaultHostnameVerifier.verify("tts.baidu.com", sSLSession) && !defaultHostnameVerifier.verify("audiotest.baidu.com", sSLSession)) {
                z = false;
            } else {
                z = true;
            }
            LoggerProxy.d("SslSocketClient", "verify: " + str + " " + z);
            return z;
        }
        return invokeLL.booleanValue;
    }
}
