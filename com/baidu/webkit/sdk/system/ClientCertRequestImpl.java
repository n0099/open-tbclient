package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ClientCertRequest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
@TargetApi(21)
/* loaded from: classes3.dex */
public final class ClientCertRequestImpl extends ClientCertRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.ClientCertRequest mRequest;

    public ClientCertRequestImpl(android.webkit.ClientCertRequest clientCertRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clientCertRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequest = clientCertRequest;
    }

    public static ClientCertRequest from(android.webkit.ClientCertRequest clientCertRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, clientCertRequest)) == null) {
            if (clientCertRequest == null) {
                return null;
            }
            return new ClientCertRequestImpl(clientCertRequest);
        }
        return (ClientCertRequest) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mRequest.cancel();
        }
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRequest.getHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final String[] getKeyTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRequest.getKeyTypes() : (String[]) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final int getPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRequest.getPort() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final Principal[] getPrincipals() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRequest.getPrincipals() : (Principal[]) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final void ignore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mRequest.ignore();
        }
    }

    @Override // com.baidu.webkit.sdk.ClientCertRequest
    public final void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, privateKey, x509CertificateArr) == null) {
            this.mRequest.proceed(privateKey, x509CertificateArr);
        }
    }
}
