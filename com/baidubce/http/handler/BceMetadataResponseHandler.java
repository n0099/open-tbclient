package com.baidubce.http.handler;

import com.baidubce.BceResponseMetadata;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.JoinerUtils;
/* loaded from: classes4.dex */
public class BceMetadataResponseHandler implements HttpResponseHandler {
    @Override // com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        BceResponseMetadata metadata = abstractBceResponse.getMetadata();
        metadata.setBceRequestId(bceHttpResponse.getHeader(Headers.BCE_REQUEST_ID));
        metadata.setBceContentSha256(bceHttpResponse.getHeader(Headers.BCE_CONTENT_SHA256));
        metadata.setContentDisposition(bceHttpResponse.getHeader("Content-Disposition"));
        metadata.setContentEncoding(bceHttpResponse.getHeader("Content-Encoding"));
        metadata.setContentLength(bceHttpResponse.getHeaderAsLong("Content-Length"));
        metadata.setContentMd5(bceHttpResponse.getHeader(Headers.CONTENT_MD5));
        metadata.setContentRange(bceHttpResponse.getHeader(Headers.CONTENT_RANGE));
        metadata.setContentType(bceHttpResponse.getHeader("Content-Type"));
        metadata.setDate(bceHttpResponse.getHeaderAsRfc822Date("Date"));
        metadata.setTransferEncoding(bceHttpResponse.getHeader("Transfer-Encoding"));
        metadata.setLocation(bceHttpResponse.getHeader(Headers.LOCATION));
        String header = bceHttpResponse.getHeader(Headers.ETAG);
        if (header != null) {
            metadata.setETag(JoinerUtils.cut("\"", header));
        }
        String header2 = bceHttpResponse.getHeader(Headers.BCE_CRC32);
        if (header2 != null) {
            try {
                metadata.setCrc32(Long.valueOf(Long.parseLong(header2)));
            } catch (NumberFormatException e) {
            }
        }
        metadata.setExpires(bceHttpResponse.getHeaderAsRfc822Date(Headers.EXPIRES));
        metadata.setLastModified(bceHttpResponse.getHeaderAsRfc822Date(Headers.LAST_MODIFIED));
        metadata.setServer(bceHttpResponse.getHeader("Server"));
        return false;
    }
}
