package com.baidu.wallet.lightapp.business.offlinecache;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.wallet.core.NoProguard;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public interface IOfflineCache extends NoProguard {
    JSONObject getOfflineCacheInfo(String str);

    void handleCreateLangbirdge(String str, WebView webView);

    void handleFinishLangbirdge(long j2);

    void handleFinishPage(String str);

    void handleLoadUrl(long j2, String str);

    void handleStartLangbirdge(long j2, String str);

    void handleStartPage(String str);

    WebResourceResponse interceptRequest(String str, Map<String, String> map);

    boolean isOfflineCacheReady(String str);

    void offlineConfigUpdate(String str);

    boolean showProgressLine(String str);
}
