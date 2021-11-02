package com.baidubce.services.bos;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes11.dex */
public class BosObjectResponseHandler implements HttpResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BosObjectResponseHandler() {
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

    @Override // com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        InterceptResult invokeLL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bceHttpResponse, abstractBceResponse)) == null) {
            if (abstractBceResponse instanceof GetObjectResponse) {
                BosObject bosObject = new BosObject();
                ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
                objectMetadata.setContentLength(bceHttpResponse.getHeaderAsLong("Content-Length"));
                objectMetadata.setContentType(bceHttpResponse.getHeader("Content-Type"));
                objectMetadata.setContentEncoding(bceHttpResponse.getHeader("Content-Encoding"));
                objectMetadata.setContentMd5(bceHttpResponse.getHeader(Headers.CONTENT_MD5));
                objectMetadata.setExpires(bceHttpResponse.getHeader("Expires"));
                objectMetadata.setObjectType(bceHttpResponse.getHeader(Headers.BCE_OBJECT_TYPE));
                objectMetadata.setAppendOffset(bceHttpResponse.getHeaderAsLong(Headers.BCE_NEXT_APPEND_OFFSET));
                objectMetadata.setContentDisposition(bceHttpResponse.getHeader("Content-Disposition"));
                objectMetadata.setCacheControl(bceHttpResponse.getHeader("Cache-Control"));
                String header = bceHttpResponse.getHeader(Headers.BCE_STORAGE_CLASS);
                if (header == null) {
                    header = BosClient.STORAGE_CLASS_STANDARD;
                }
                objectMetadata.setStorageClass(header);
                String header2 = bceHttpResponse.getHeader("ETag");
                if (header2 != null) {
                    objectMetadata.setETag(JoinerUtils.cut("\"", header2));
                }
                String header3 = bceHttpResponse.getHeader(Headers.BCE_CRC32);
                if (header3 != null) {
                    try {
                        objectMetadata.setCrc32(Long.valueOf(Long.parseLong(header3)));
                    } catch (NumberFormatException e2) {
                        BLog.error("Fail to parse crcx-bce-content-crc32: " + header3, (Throwable) e2);
                    }
                }
                objectMetadata.setContentLength(objectMetadata.getContentLength());
                String header4 = bceHttpResponse.getHeader("Content-Range");
                objectMetadata.setContentRange(header4);
                if (header4 != null && (lastIndexOf = header4.lastIndexOf(47)) >= 0) {
                    try {
                        objectMetadata.setInstanceLength(Long.parseLong(header4.substring(lastIndexOf + 1)));
                    } catch (NumberFormatException e3) {
                        BLog.error("Fail to parse length from Content-Range: " + header4, (Throwable) e3);
                    }
                }
                objectMetadata.setLastModified(bceHttpResponse.getHeaderAsRfc822Date("Last-Modified"));
                objectMetadata.setBceContentSha256(bceHttpResponse.getHeader(Headers.BCE_CONTENT_SHA256));
                for (Map.Entry<String, String> entry : bceHttpResponse.getHeaders().entrySet()) {
                    String key = entry.getKey();
                    if (key.startsWith(Headers.BCE_USER_METADATA_PREFIX)) {
                        objectMetadata.addUserMetadata(URLDecoder.decode(key.substring(11), "UTF-8"), URLDecoder.decode(entry.getValue(), "UTF-8"));
                    }
                }
                InputStream content = bceHttpResponse.getContent();
                if (content != null) {
                    if (objectMetadata.getContentLength() >= 0) {
                        content = new LengthCheckInputStream(content, objectMetadata.getContentLength(), true);
                    }
                    bosObject.setObjectContent(new BosObjectInputStream(content, bceHttpResponse.getHttpResponse()));
                }
                ((GetObjectResponse) abstractBceResponse).setObject(bosObject);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
