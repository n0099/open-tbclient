package com.baidubce.http.handler;

import com.baidubce.http.BceHttpResponse;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.JsonUtils;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class BceJsonResponseHandler implements HttpResponseHandler {
    @Override // com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
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
}
