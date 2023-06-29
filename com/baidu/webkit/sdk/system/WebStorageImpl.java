package com.baidu.webkit.sdk.system;

import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import com.baidu.webkit.sdk.WebStorage;
import java.util.Map;
/* loaded from: classes9.dex */
public final class WebStorageImpl extends WebStorage {

    /* loaded from: classes9.dex */
    public static class QuotaUpdater implements WebStorage.QuotaUpdater {
        public final WebStorage.QuotaUpdater mImpl;

        public QuotaUpdater(WebStorage.QuotaUpdater quotaUpdater) {
            this.mImpl = quotaUpdater;
        }

        @Override // com.baidu.webkit.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.mImpl.updateQuota(j);
        }
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void deleteAllData() {
        android.webkit.WebStorage.getInstance().deleteAllData();
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void deleteAllDataIncludeServiceWorker() {
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void deleteOrigin(String str) {
        android.webkit.WebStorage.getInstance().deleteOrigin(str);
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void getOrigins(ValueCallback<Map> valueCallback) {
        android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
    }

    @Override // com.baidu.webkit.sdk.WebStorage
    public final void setQuotaForOrigin(String str, long j) {
        android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
    }
}
