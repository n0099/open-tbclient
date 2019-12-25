package com.baidubce.services.vod;

import com.baidu.searchbox.datachannel.Contract;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.vod.model.GenerateMediaIdResponse;
import com.baidubce.services.vod.model.GetMediaResourceResponse;
import com.baidubce.services.vod.model.ProcessMediaResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VodJsonResponseHandler extends BceJsonResponseHandler {
    @Override // com.baidubce.http.handler.BceJsonResponseHandler, com.baidubce.http.handler.HttpResponseHandler
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        InputStream content = bceHttpResponse.getContent();
        if (content != null && (abstractBceResponse.getMetadata().getContentLength() > 0 || HTTP.CHUNK_CODING.equalsIgnoreCase(abstractBceResponse.getMetadata().getTransferEncoding()))) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            content.close();
            JSONObject jSONObject = new JSONObject(sb.toString());
            if (abstractBceResponse instanceof GenerateMediaIdResponse) {
                GenerateMediaIdResponse generateMediaIdResponse = (GenerateMediaIdResponse) abstractBceResponse;
                generateMediaIdResponse.setMediaId(jSONObject.getString("mediaId"));
                generateMediaIdResponse.setSourceBucket(jSONObject.getString("sourceBucket"));
                generateMediaIdResponse.setSourceKey(jSONObject.getString("sourceKey"));
                generateMediaIdResponse.setEndPoint(jSONObject.getString(Contract.SCHEME_KEY_HOST));
            } else if (abstractBceResponse instanceof ProcessMediaResponse) {
                ((ProcessMediaResponse) abstractBceResponse).setMediaId(jSONObject.getString("mediaId"));
            } else if (abstractBceResponse instanceof GetMediaResourceResponse) {
                GetMediaResourceResponse.formatJsonToObject(jSONObject, (GetMediaResourceResponse) abstractBceResponse);
            }
            return true;
        }
        return super.handle(bceHttpResponse, abstractBceResponse);
    }
}
