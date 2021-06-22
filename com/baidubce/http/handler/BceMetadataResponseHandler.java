package com.baidubce.http.handler;

import com.baidubce.BceResponseMetadata;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.JoinerUtils;
/* loaded from: classes6.dex */
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
        metadata.setContentRange(bceHttpResponse.getHeader("Content-Range"));
        metadata.setContentType(bceHttpResponse.getHeader("Content-Type"));
        metadata.setDate(bceHttpResponse.getHeaderAsRfc822Date("Date"));
        metadata.setTransferEncoding(bceHttpResponse.getHeader("Transfer-Encoding"));
        metadata.setLocation(bceHttpResponse.getHeader("Location"));
        String header = bceHttpResponse.getHeader("ETag");
        if (header != null) {
            metadata.setETag(JoinerUtils.cut("\"", header));
        }
        String header2 = bceHttpResponse.getHeader(Headers.BCE_CRC32);
        if (header2 != null) {
            try {
                metadata.setCrc32(Long.valueOf(Long.parseLong(header2)));
            } catch (NumberFormatException unused) {
            }
        }
        metadata.setExpires(bceHttpResponse.getHeaderAsRfc822Date("Expires"));
        metadata.setLastModified(bceHttpResponse.getHeaderAsRfc822Date("Last-Modified"));
        metadata.setServer(bceHttpResponse.getHeader("Server"));
        return false;
    }
}
