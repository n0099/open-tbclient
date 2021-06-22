package com.baidu.wallet.lightapp.business.offlinecache;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LangbridgeCacheManager implements NoProguard, IOfflineCache {

    /* renamed from: b  reason: collision with root package name */
    public IOfflineCache f24939b;

    /* renamed from: c  reason: collision with root package name */
    public String f24940c;
    public final String OFFLINE_FAIL_OVER_OCCUR = "OfflineFailOverOccur";

    /* renamed from: a  reason: collision with root package name */
    public final int f24938a = 5000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24941d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f24942e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f24943f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f24944g = 5000;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgeCacheManager f24945a = new LangbridgeCacheManager();
    }

    private void a(String str) {
        try {
            this.f24944g = new JSONObject(str).optInt("refreshInterval", 5000);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static LangbridgeCacheManager getInstance() {
        return a.f24945a;
    }

    public void forceLangbridgeCacheOnly(Context context, Boolean bool) {
        LangbridgePreloadCellCenter.getInstance(context).setAllCellsEnable(!bool.booleanValue());
    }

    public String getLangbridgeUA(Context context) {
        String str = this.f24940c;
        if (TextUtils.isEmpty(str)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                String userAgentString = new LightappBrowserWebView(context.getApplicationContext()).getSettings().getUserAgentString();
                if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
                    userAgentString = userAgentString + " " + BussinessUtils.getUA(context.getApplicationContext());
                }
                this.f24940c = userAgentString;
                return userAgentString;
            }
            return BussinessUtils.getUA(context.getApplicationContext());
        }
        return str;
    }

    public String getOfflineCacheConfig(Context context) {
        return SdkInitResponse.getInstance().getOfflineCacheConfig(context);
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public JSONObject getOfflineCacheInfo(String str) {
        if (a()) {
            return this.f24939b.getOfflineCacheInfo(str);
        }
        return null;
    }

    public JSONObject getSummaryOfflineCacheInfo(String str) {
        JSONObject offlineCacheInfo;
        JSONObject jSONObject = new JSONObject();
        if (this.f24939b != null && !TextUtils.isEmpty(str) && (offlineCacheInfo = this.f24939b.getOfflineCacheInfo(str)) != null) {
            try {
                jSONObject.put("package_name", offlineCacheInfo.optString("name"));
                jSONObject.put("package_version", offlineCacheInfo.optString("decryVersion"));
            } catch (JSONException e2) {
                LogUtil.e("WebViewCacheManager", "JSONException on getSummaryOfflineCacheInfo", e2);
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleCreateLangbirdge(String str, WebView webView) {
        if (a()) {
            this.f24939b.handleCreateLangbirdge(str, webView);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishLangbirdge(long j) {
        if (a()) {
            this.f24939b.handleFinishLangbirdge(j);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishPage(String str) {
        if (a()) {
            this.f24939b.handleFinishPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleLoadUrl(long j, String str) {
        if (a()) {
            this.f24939b.handleLoadUrl(j, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartLangbirdge(long j, String str) {
        if (a()) {
            this.f24939b.handleStartLangbirdge(j, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartPage(String str) {
        if (a()) {
            this.f24939b.handleStartPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        if (a()) {
            return this.f24939b.interceptRequest(str, map);
        }
        return null;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean isOfflineCacheReady(String str) {
        if (a()) {
            return this.f24939b.isOfflineCacheReady(str);
        }
        return false;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache = this.f24939b;
        if (iOfflineCache != null) {
            iOfflineCache.offlineConfigUpdate(str);
            a(str);
        }
    }

    public void onLangbridgeRefresh(Context context, String str) {
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f24942e.equals(str) && currentTimeMillis - this.f24943f < this.f24944g) {
                this.f24941d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put("pageUrl", str);
                Tracker.send("OfflineFailOverOccur", hashMap, context);
            }
            this.f24942e = str;
            this.f24943f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        if (TextUtils.isEmpty(this.f24940c)) {
            this.f24940c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        this.f24939b = iOfflineCache;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean showProgressLine(String str) {
        if (a()) {
            return this.f24939b.showProgressLine(str);
        }
        return true;
    }

    private boolean a() {
        return this.f24939b != null && this.f24941d;
    }
}
