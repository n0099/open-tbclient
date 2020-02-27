package com.baidu.webkit.sdk;

import android.webkit.ValueCallback;
import java.util.Map;
/* loaded from: classes11.dex */
public class WebStorage {
    private static final WebStorage mInstance = new WebStorage();

    /* loaded from: classes11.dex */
    public static class Origin {
        private String mOrigin;
        private long mQuota;
        private long mUsage;

        protected Origin(String str, long j, long j2) {
            this.mOrigin = null;
            this.mQuota = 0L;
            this.mUsage = 0L;
            this.mOrigin = str;
            this.mQuota = j;
            this.mUsage = j2;
        }

        public String getOrigin() {
            return this.mOrigin;
        }

        public long getQuota() {
            return this.mQuota;
        }

        public long getUsage() {
            return this.mUsage;
        }
    }

    @Deprecated
    /* loaded from: classes11.dex */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    public static WebStorage getInstance() {
        return mInstance;
    }

    public void deleteAllData() {
        WebViewFactory.getProvider().getWebStorage().deleteAllData();
    }

    public void deleteOrigin(String str) {
        WebViewFactory.getProvider().getWebStorage().deleteOrigin(str);
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        WebViewFactory.getProvider().getWebStorage().getOrigins(valueCallback);
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        WebViewFactory.getProvider().getWebStorage().getQuotaForOrigin(str, valueCallback);
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        WebViewFactory.getProvider().getWebStorage().getUsageForOrigin(str, valueCallback);
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        WebViewFactory.getProvider().getWebStorage().setQuotaForOrigin(str, j);
    }
}
