package com.baidu.ubc;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostByteRequest;
import java.io.IOException;
import java.util.Map;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class h extends a {
    @Override // com.baidu.ubc.a
    public ad a(String str, byte[] bArr, Map<String, String> map) throws IOException {
        PostByteRequest.PostByteRequestBuilder postByteRequest = HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest();
        postByteRequest.requestFrom(3);
        postByteRequest.url(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            postByteRequest.addHeader(entry.getKey(), entry.getValue());
        }
        postByteRequest.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, true));
        final Response executeSync = postByteRequest.content(bArr).build().executeSync();
        return new ad() { // from class: com.baidu.ubc.h.1
            @Override // com.baidu.ubc.ad
            public boolean isSuccessful() {
                return executeSync.isSuccessful();
            }

            @Override // com.baidu.ubc.ad
            public String getMessage() {
                return executeSync.message();
            }

            @Override // com.baidu.ubc.ad
            public String getBody() throws IOException {
                return executeSync.body().string();
            }

            @Override // com.baidu.ubc.ad
            public void close() {
                executeSync.body().close();
            }
        };
    }
}
