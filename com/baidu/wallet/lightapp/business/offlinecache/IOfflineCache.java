package com.baidu.wallet.lightapp.business.offlinecache;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.wallet.core.NoProguard;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface IOfflineCache extends NoProguard {
    JSONObject getOfflineCacheInfo(String str);

    void handleCreateLangbirdge(String str, WebView webView);

    void handleFinishLangbirdge(long j);

    void handleFinishPage(String str);

    void handleLoadUrl(long j, String str);

    void handleStartLangbirdge(long j, String str);

    void handleStartPage(String str);

    WebResourceResponse interceptRequest(String str, Map<String, String> map);

    boolean isOfflineCacheReady(String str);

    void offlineConfigUpdate(String str);

    boolean showProgressLine(String str);
}
