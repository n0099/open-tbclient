package com.baidubce.services.sts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import com.baidubce.util.JsonUtils;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class BceStsJsonResponseHandler extends BceJsonResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BceStsJsonResponseHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidubce.http.handler.BceJsonResponseHandler, com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bceHttpResponse, abstractBceResponse)) == null) {
            if (abstractBceResponse instanceof GetSessionTokenResponse) {
                GetSessionTokenResponse getSessionTokenResponse = (GetSessionTokenResponse) abstractBceResponse;
                InputStream content = bceHttpResponse.getContent();
                if (content != null) {
                    if (abstractBceResponse.getMetadata().getContentLength() > 0 || "chunked".equalsIgnoreCase(abstractBceResponse.getMetadata().getTransferEncoding())) {
                        JsonUtils.load(content, getSessionTokenResponse);
                    }
                    content.close();
                    return true;
                }
                return true;
            }
            return super.handle(bceHttpResponse, abstractBceResponse);
        }
        return invokeLL.booleanValue;
    }
}
