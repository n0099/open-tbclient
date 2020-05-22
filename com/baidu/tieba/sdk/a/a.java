package com.baidu.tieba.sdk.a;

import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends HttpRule {
    public a(int i) {
        super(i);
    }

    private void addSign(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && !"sign".equals(key)) {
                    stringBuffer.append(key + ETAG.EQUAL);
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam("sign", Md5.toMd5(stringBuffer.toString()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.controller.MessageRule
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessage != null && httpMessage.getCmd() < 1030999 && httpMessage.getCmd() >= 1021000) {
            String str = "3.7.5/release|2020-05-20 18:32:01|d490c04";
            try {
                str = URLEncoder.encode(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            httpMessage.addParam("sdkbuildpath", str);
            addSign(httpMessage);
        }
        return httpMessage;
    }
}
