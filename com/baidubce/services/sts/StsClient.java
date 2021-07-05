package com.baidubce.services.sts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientConfiguration;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.services.sts.model.GetSessionTokenRequest;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
/* loaded from: classes6.dex */
public class StsClient extends AbstractBceClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GET_SESSION_TOKEN_PATH = "sessionToken";
    public static HttpResponseHandler[] stsHandlers;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-449638784, "Lcom/baidubce/services/sts/StsClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-449638784, "Lcom/baidubce/services/sts/StsClient;");
                return;
            }
        }
        stsHandlers = new HttpResponseHandler[]{new BceMetadataResponseHandler(), new BceErrorResponseHandler(), new BceStsJsonResponseHandler()};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StsClient() {
        this(new BceClientConfiguration());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((BceClientConfiguration) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public GetSessionTokenResponse getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getSessionToken(new GetSessionTokenRequest()) : (GetSessionTokenResponse) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StsClient(BceClientConfiguration bceClientConfiguration) {
        super(bceClientConfiguration, stsHandlers);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bceClientConfiguration};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BceClientConfiguration) objArr2[0], (HttpResponseHandler[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public GetSessionTokenResponse getSessionToken(GetSessionTokenRequest getSessionTokenRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getSessionTokenRequest)) == null) {
            CheckUtils.isNotNull(getSessionTokenRequest, "The parameter request should NOT be null.");
            CheckUtils.checkArgument(getSessionTokenRequest.getDurationSeconds().intValue() > 0, "the durationSeconds parameter should be greater than zero");
            InternalRequest internalRequest = new InternalRequest(HttpMethodName.POST, HttpUtils.appendUri(getEndpoint(), "v1", GET_SESSION_TOKEN_PATH));
            if (getSessionTokenRequest.getDurationSeconds() != null) {
                internalRequest.addParameter("durationSeconds", String.valueOf(getSessionTokenRequest.getDurationSeconds()));
            }
            internalRequest.setCredentials(getSessionTokenRequest.getRequestCredentials());
            internalRequest.addHeader("Content-Length", String.valueOf(getSessionTokenRequest.getAcl() != null ? getSessionTokenRequest.getAcl().length() : 0));
            internalRequest.addHeader("Content-Type", "application/json");
            if (getSessionTokenRequest.getAcl() != null) {
                internalRequest.setContent(RestartableInputStream.wrap(getSessionTokenRequest.getAcl().getBytes()));
            }
            return (GetSessionTokenResponse) invokeHttpClient(internalRequest, GetSessionTokenResponse.class);
        }
        return (GetSessionTokenResponse) invokeL.objValue;
    }
}
