package com.baidubce.http.handler;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.JsonUtils;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class BceJsonResponseHandler implements HttpResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BceJsonResponseHandler() {
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
            InputStream content = bceHttpResponse.getContent();
            if (content != null) {
                if (abstractBceResponse.getMetadata().getContentLength() > 0 || "chunked".equalsIgnoreCase(abstractBceResponse.getMetadata().getTransferEncoding())) {
                    JsonUtils.load(bceHttpResponse, abstractBceResponse);
                }
                content.close();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
