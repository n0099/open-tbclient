package com.baidu.webkit.sdk.performance;

import com.baidu.webkit.sdk.WebView;
/* loaded from: classes19.dex */
public class ZeusPerformance {
    private ZeusPerformanceTiming mTiming;

    protected ZeusPerformance() {
    }

    public PagePerformanceTiming pageTiming(WebView webView) {
        if (webView == null || webView.getWebViewProvider() == null) {
            return null;
        }
        return webView.getWebViewProvider().getPerformanceTiming();
    }

    public ZeusPerformanceTiming zeusTiming() {
        if (this.mTiming == null) {
            this.mTiming = new ZeusPerformanceTiming();
        }
        return this.mTiming;
    }
}
