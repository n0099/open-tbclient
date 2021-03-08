package com.baidubce.http.handler;

import com.baidubce.BceResponseMetadata;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.BosResponseMetadata;
/* loaded from: classes4.dex */
public class BosMetadataResponseHandler implements HttpResponseHandler {
    @Override // com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        BceResponseMetadata metadata = abstractBceResponse.getMetadata();
        if (metadata instanceof BosResponseMetadata) {
            ((BosResponseMetadata) metadata).setBosDebugId(bceHttpResponse.getHeader(Headers.BCE_DEBUG_ID));
            if (bceHttpResponse.getHeader(Headers.BCE_NEXT_APPEND_OFFSET) != null) {
                ((BosResponseMetadata) metadata).setNextAppendOffset(Long.valueOf(Long.parseLong(bceHttpResponse.getHeader(Headers.BCE_NEXT_APPEND_OFFSET))));
            }
            if (bceHttpResponse.getHeader(Headers.LOCATION) != null) {
                metadata.setLocation(bceHttpResponse.getHeader(Headers.LOCATION));
                return false;
            }
            return false;
        }
        return false;
    }
}
