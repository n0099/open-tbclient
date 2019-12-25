package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes9.dex */
final class g implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        if (WebKitFactory.getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getHttpDnsUpdateEnabled()) {
            z = WebSettingsGlobalBlink.mHttpDnsUpdated;
            if (!z) {
                boolean unused = WebSettingsGlobalBlink.mHttpDnsUpdated = true;
                Log.i("WebSettingsGlobalBlink", "updateHttpDns first download");
                long unused2 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
                HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
                return;
            }
            z2 = WebSettingsGlobalBlink.mIsAlive;
            if (!z2) {
                Log.i("WebSettingsGlobalBlink", "updateHttpDns net background");
                boolean unused3 = WebSettingsGlobalBlink.mHttpDnsNetChangedAfterPause = true;
                return;
            }
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                com.a.a.a.a.a.a.a.a(e);
            }
            Log.i("WebSettingsGlobalBlink", "updateHttpDns net change");
            long unused4 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
            HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
        }
    }
}
