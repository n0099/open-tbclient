package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BusinessSessionEventHandler implements INoProGuard {
    public void onReceivedAdLandingPagePerformanceData(WebView webView, long j, JSONObject jSONObject) {
        SessionMonitorEngine.getInstance().recordBySourceId(webView, j, 24577, jSONObject);
    }
}
