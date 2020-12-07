package com.baidu.webkit.internal.blink;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes12.dex */
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
                Thread.sleep(IMConnection.RETRY_DELAY_TIMES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("WebSettingsGlobalBlink", "updateHttpDns net change");
            long unused4 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
            HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
        }
    }
}
