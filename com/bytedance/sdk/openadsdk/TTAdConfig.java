package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class TTAdConfig implements AdConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f53156b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53157c;

    /* renamed from: d  reason: collision with root package name */
    public String f53158d;

    /* renamed from: e  reason: collision with root package name */
    public String f53159e;

    /* renamed from: f  reason: collision with root package name */
    public int f53160f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53161g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53162h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53163i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f53164j;
    public boolean k;
    public boolean l;
    public String[] m;
    public boolean n;
    public Map<String, Object> o;
    public TTCustomController p;
    public int q;

    /* loaded from: classes2.dex */
    public static class Builder {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f53165b;

        /* renamed from: d  reason: collision with root package name */
        public String f53167d;

        /* renamed from: e  reason: collision with root package name */
        public String f53168e;

        /* renamed from: j  reason: collision with root package name */
        public int[] f53173j;
        public String[] m;
        public TTCustomController o;
        public int p;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53166c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f53169f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f53170g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f53171h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f53172i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean n = false;
        public int q = 2;

        public Builder allowShowNotify(boolean z) {
            this.f53170g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f53172i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f53165b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.f53165b);
            tTAdConfig.setPaid(this.f53166c);
            tTAdConfig.setKeywords(this.f53167d);
            tTAdConfig.setData(this.f53168e);
            tTAdConfig.setTitleBarTheme(this.f53169f);
            tTAdConfig.setAllowShowNotify(this.f53170g);
            tTAdConfig.setDebug(this.f53171h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f53172i);
            tTAdConfig.setDirectDownloadNetworkType(this.f53173j);
            tTAdConfig.setUseTextureView(this.k);
            tTAdConfig.setSupportMultiProcess(this.l);
            tTAdConfig.setNeedClearTaskReset(this.m);
            tTAdConfig.setAsyncInit(this.n);
            tTAdConfig.setCustomController(this.o);
            tTAdConfig.setThemeStatus(this.p);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.q));
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.o = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.f53168e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f53171h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f53173j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.f53167d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f53166c = z;
            return this;
        }

        public Builder setPluginUpdateConfig(int i2) {
            this.q = i2;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder themeStatus(int i2) {
            this.p = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f53169f = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.k = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.f53156b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f53159e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f53164j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f53158d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String[] getNeedClearTaskReset() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public AdConfig.SdkInfo getSdkInfo() {
        return new AdConfig.SdkInfo() { // from class: com.bytedance.sdk.openadsdk.TTAdConfig.1
            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public boolean isPlugin() {
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return "com.byted.pangle";
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 4022;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "4.0.2.2";
            }
        };
    }

    public int getThemeStatus() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f53160f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f53161g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.f53163i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAsyncInit() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f53162h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f53157c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.o.remove(str);
    }

    public void setAllowShowNotify(boolean z) {
        this.f53161g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f53163i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.f53156b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.p = tTCustomController;
    }

    public void setData(String str) {
        this.f53159e = str;
    }

    public void setDebug(boolean z) {
        this.f53162h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f53164j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setKeywords(String str) {
        this.f53158d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f53157c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setThemeStatus(int i2) {
        this.q = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f53160f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f53157c = false;
        this.f53160f = 0;
        this.f53161g = true;
        this.f53162h = false;
        this.f53163i = false;
        this.k = false;
        this.l = false;
        this.n = false;
        this.o = new HashMap();
    }
}
