package com.baidubce.http.handler;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceErrorResponse;
import com.baidubce.BceServiceException;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.JsonUtils;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class BceErrorResponseHandler implements HttpResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BceErrorResponseHandler() {
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

    @Override // com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bceHttpResponse, abstractBceResponse)) == null) {
            if (bceHttpResponse.getStatusCode() / 100 == 2) {
                return false;
            }
            InputStream content = bceHttpResponse.getContent();
            BceServiceException bceServiceException = null;
            if (content != null) {
                BceErrorResponse loadError = JsonUtils.loadError(content);
                if (loadError == null) {
                    BceServiceException bceServiceException2 = new BceServiceException(bceHttpResponse.getStatusText());
                    bceServiceException2.setErrorCode(null);
                    bceServiceException2.setRequestId(bceHttpResponse.getHeader(Headers.BCE_REQUEST_ID));
                    bceServiceException = bceServiceException2;
                } else if (loadError.getMessage() != null) {
                    bceServiceException = new BceServiceException(loadError.getMessage());
                    bceServiceException.setErrorCode(loadError.getCode());
                    bceServiceException.setRequestId(loadError.getRequestId());
                }
                content.close();
            }
            if (bceServiceException == null) {
                bceServiceException = new BceServiceException(bceHttpResponse.getStatusText());
                bceServiceException.setRequestId(abstractBceResponse.getMetadata().getBceRequestId());
            }
            bceServiceException.setStatusCode(bceHttpResponse.getStatusCode());
            if (bceServiceException.getStatusCode() >= 500) {
                bceServiceException.setErrorType(BceServiceException.ErrorType.Service);
            } else {
                bceServiceException.setErrorType(BceServiceException.ErrorType.Client);
            }
            throw bceServiceException;
        }
        return invokeLL.booleanValue;
    }
}
