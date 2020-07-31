package com.baidubce.services.sts;

import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import com.baidubce.util.JsonUtils;
import java.io.InputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes19.dex */
public class BceStsJsonResponseHandler extends BceJsonResponseHandler {
    @Override // com.baidubce.http.handler.BceJsonResponseHandler, com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        if (abstractBceResponse instanceof GetSessionTokenResponse) {
            GetSessionTokenResponse getSessionTokenResponse = (GetSessionTokenResponse) abstractBceResponse;
            InputStream content = bceHttpResponse.getContent();
            if (content != null) {
                if (abstractBceResponse.getMetadata().getContentLength() > 0 || HTTP.CHUNK_CODING.equalsIgnoreCase(abstractBceResponse.getMetadata().getTransferEncoding())) {
                    JsonUtils.load(content, getSessionTokenResponse);
                }
                content.close();
            }
            return true;
        }
        return super.handle(bceHttpResponse, abstractBceResponse);
    }
}
