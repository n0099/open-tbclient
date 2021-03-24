package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes5.dex */
public final class g implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        String str;
        if (WebKitFactory.getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getHttpDnsUpdateEnabled()) {
            z = WebSettingsGlobalBlink.mHttpDnsUpdated;
            if (z) {
                z2 = WebSettingsGlobalBlink.mIsAlive;
                if (!z2) {
                    Log.i(WebSettingsGlobalBlink.LOGTAG, "updateHttpDns net background");
                    boolean unused = WebSettingsGlobalBlink.mHttpDnsNetChangedAfterPause = true;
                    return;
                }
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                str = "updateHttpDns net change";
            } else {
                boolean unused2 = WebSettingsGlobalBlink.mHttpDnsUpdated = true;
                str = "updateHttpDns first download";
            }
            Log.i(WebSettingsGlobalBlink.LOGTAG, str);
            long unused3 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
            HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
        }
    }
}
