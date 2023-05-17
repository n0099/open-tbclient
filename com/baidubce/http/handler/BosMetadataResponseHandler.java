package com.baidubce.http.handler;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceResponseMetadata;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.BosResponseMetadata;
/* loaded from: classes8.dex */
public class BosMetadataResponseHandler implements HttpResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BosMetadataResponseHandler() {
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
            BceResponseMetadata metadata = abstractBceResponse.getMetadata();
            if (metadata instanceof BosResponseMetadata) {
                BosResponseMetadata bosResponseMetadata = (BosResponseMetadata) metadata;
                bosResponseMetadata.setBosDebugId(bceHttpResponse.getHeader(Headers.BCE_DEBUG_ID));
                if (bceHttpResponse.getHeader(Headers.BCE_NEXT_APPEND_OFFSET) != null) {
                    bosResponseMetadata.setNextAppendOffset(Long.valueOf(Long.parseLong(bceHttpResponse.getHeader(Headers.BCE_NEXT_APPEND_OFFSET))));
                }
                if (bceHttpResponse.getHeader("Location") != null) {
                    metadata.setLocation(bceHttpResponse.getHeader("Location"));
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
