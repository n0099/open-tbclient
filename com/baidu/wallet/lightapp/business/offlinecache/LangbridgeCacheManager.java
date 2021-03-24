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
    public IOfflineCache f25122b;

    /* renamed from: c  reason: collision with root package name */
    public String f25123c;
    public final String OFFLINE_FAIL_OVER_OCCUR = "OfflineFailOverOccur";

    /* renamed from: a  reason: collision with root package name */
    public final int f25121a = 5000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25124d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f25125e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f25126f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f25127g = 5000;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LangbridgeCacheManager f25128a = new LangbridgeCacheManager();
    }

    private void a(String str) {
        try {
            this.f25127g = new JSONObject(str).optInt("refreshInterval", 5000);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static LangbridgeCacheManager getInstance() {
        return a.f25128a;
    }

    public void forceLangbridgeCacheOnly(Context context, Boolean bool) {
        LangbridgePreloadCellCenter.getInstance(context).setAllCellsEnable(!bool.booleanValue());
    }

    public String getLangbridgeUA(Context context) {
        String str = this.f25123c;
        if (TextUtils.isEmpty(str)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                String userAgentString = new LightappBrowserWebView(context.getApplicationContext()).getSettings().getUserAgentString();
                if (userAgentString != null && !userAgentString.contains("BaiduWallet")) {
                    userAgentString = userAgentString + " " + BussinessUtils.getUA(context.getApplicationContext());
                }
                this.f25123c = userAgentString;
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
            return this.f25122b.getOfflineCacheInfo(str);
        }
        return null;
    }

    public JSONObject getSummaryOfflineCacheInfo(String str) {
        JSONObject offlineCacheInfo;
        JSONObject jSONObject = new JSONObject();
        if (this.f25122b != null && !TextUtils.isEmpty(str) && (offlineCacheInfo = this.f25122b.getOfflineCacheInfo(str)) != null) {
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
            this.f25122b.handleCreateLangbirdge(str, webView);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishLangbirdge(long j) {
        if (a()) {
            this.f25122b.handleFinishLangbirdge(j);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleFinishPage(String str) {
        if (a()) {
            this.f25122b.handleFinishPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleLoadUrl(long j, String str) {
        if (a()) {
            this.f25122b.handleLoadUrl(j, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartLangbirdge(long j, String str) {
        if (a()) {
            this.f25122b.handleStartLangbirdge(j, str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void handleStartPage(String str) {
        if (a()) {
            this.f25122b.handleStartPage(str);
        }
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        if (a()) {
            return this.f25122b.interceptRequest(str, map);
        }
        return null;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean isOfflineCacheReady(String str) {
        if (a()) {
            return this.f25122b.isOfflineCacheReady(str);
        }
        return false;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public void offlineConfigUpdate(String str) {
        IOfflineCache iOfflineCache = this.f25122b;
        if (iOfflineCache != null) {
            iOfflineCache.offlineConfigUpdate(str);
            a(str);
        }
    }

    public void onLangbridgeRefresh(Context context, String str) {
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f25125e.equals(str) && currentTimeMillis - this.f25126f < this.f25127g) {
                this.f25124d = false;
                HashMap hashMap = new HashMap();
                hashMap.put("code", "2");
                hashMap.put("pageUrl", str);
                Tracker.send("OfflineFailOverOccur", hashMap, context);
            }
            this.f25125e = str;
            this.f25126f = currentTimeMillis;
        }
    }

    public void setLangbridgeUA(String str) {
        if (TextUtils.isEmpty(this.f25123c)) {
            this.f25123c = str;
        }
    }

    public void setOfflineCacheImpl(IOfflineCache iOfflineCache) {
        this.f25122b = iOfflineCache;
    }

    @Override // com.baidu.wallet.lightapp.business.offlinecache.IOfflineCache
    public boolean showProgressLine(String str) {
        if (a()) {
            return this.f25122b.showProgressLine(str);
        }
        return true;
    }

    private boolean a() {
        return this.f25122b != null && this.f25124d;
    }
}
