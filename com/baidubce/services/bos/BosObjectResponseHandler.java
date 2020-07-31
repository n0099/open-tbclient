package com.baidubce.services.bos;

import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.GetObjectResponse;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.util.BLog;
import com.baidubce.util.JoinerUtils;
import com.baidubce.util.LengthCheckInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes19.dex */
public class BosObjectResponseHandler implements HttpResponseHandler {
    @Override // com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        int lastIndexOf;
        if (!(abstractBceResponse instanceof GetObjectResponse)) {
            return false;
        }
        BosObject bosObject = new BosObject();
        ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
        objectMetadata.setContentLength(bceHttpResponse.getHeaderAsLong("Content-Length"));
        objectMetadata.setContentType(bceHttpResponse.getHeader("Content-Type"));
        objectMetadata.setContentEncoding(bceHttpResponse.getHeader("Content-Encoding"));
        objectMetadata.setContentMd5(bceHttpResponse.getHeader(Headers.CONTENT_MD5));
        objectMetadata.setExpires(bceHttpResponse.getHeader(Headers.EXPIRES));
        objectMetadata.setObjectType(bceHttpResponse.getHeader(Headers.BCE_OBJECT_TYPE));
        objectMetadata.setAppendOffset(bceHttpResponse.getHeaderAsLong(Headers.BCE_NEXT_APPEND_OFFSET));
        objectMetadata.setContentDisposition(bceHttpResponse.getHeader("Content-Disposition"));
        objectMetadata.setCacheControl(bceHttpResponse.getHeader(Headers.CACHE_CONTROL));
        String header = bceHttpResponse.getHeader(Headers.BCE_STORAGE_CLASS);
        if (header == null) {
            header = BosClient.STORAGE_CLASS_STANDARD;
        }
        objectMetadata.setStorageClass(header);
        String header2 = bceHttpResponse.getHeader(Headers.ETAG);
        if (header2 != null) {
            objectMetadata.setETag(JoinerUtils.cut("\"", header2));
        }
        String header3 = bceHttpResponse.getHeader(Headers.BCE_CRC32);
        if (header3 != null) {
            try {
                objectMetadata.setCrc32(Long.valueOf(Long.parseLong(header3)));
            } catch (NumberFormatException e) {
                BLog.error("Fail to parse crcx-bce-content-crc32: " + header3, (Throwable) e);
            }
        }
        objectMetadata.setContentLength(objectMetadata.getContentLength());
        String header4 = bceHttpResponse.getHeader(Headers.CONTENT_RANGE);
        objectMetadata.setContentRange(header4);
        if (header4 != null && (lastIndexOf = header4.lastIndexOf(47)) >= 0) {
            try {
                objectMetadata.setInstanceLength(Long.parseLong(header4.substring(lastIndexOf + 1)));
            } catch (NumberFormatException e2) {
                BLog.error("Fail to parse length from Content-Range: " + header4, (Throwable) e2);
            }
        }
        objectMetadata.setLastModified(bceHttpResponse.getHeaderAsRfc822Date(Headers.LAST_MODIFIED));
        objectMetadata.setBceContentSha256(bceHttpResponse.getHeader(Headers.BCE_CONTENT_SHA256));
        for (Map.Entry<String, String> entry : bceHttpResponse.getHeaders().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(Headers.BCE_USER_METADATA_PREFIX)) {
                objectMetadata.addUserMetadata(URLDecoder.decode(key.substring(Headers.BCE_USER_METADATA_PREFIX.length()), "UTF-8"), URLDecoder.decode(entry.getValue(), "UTF-8"));
            }
        }
        InputStream content = bceHttpResponse.getContent();
        if (content != null) {
            bosObject.setObjectContent(new BosObjectInputStream(objectMetadata.getContentLength() >= 0 ? new LengthCheckInputStream(content, objectMetadata.getContentLength(), true) : content, bceHttpResponse.getHttpResponse()));
        }
        ((GetObjectResponse) abstractBceResponse).setObject(bosObject);
        return true;
    }
}
