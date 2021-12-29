package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class TTAdConfig implements AdConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55255b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55256c;

    /* renamed from: d  reason: collision with root package name */
    public String f55257d;

    /* renamed from: e  reason: collision with root package name */
    public String f55258e;

    /* renamed from: f  reason: collision with root package name */
    public int f55259f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55260g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55261h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55262i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f55263j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f55264k;
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
        public String f55265b;

        /* renamed from: d  reason: collision with root package name */
        public String f55267d;

        /* renamed from: e  reason: collision with root package name */
        public String f55268e;

        /* renamed from: j  reason: collision with root package name */
        public int[] f55273j;
        public String[] m;
        public TTCustomController o;
        public int p;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55266c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f55269f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f55270g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f55271h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f55272i = false;

        /* renamed from: k  reason: collision with root package name */
        public boolean f55274k = false;
        public boolean l = false;
        public boolean n = false;
        public int q = 2;

        public Builder allowShowNotify(boolean z) {
            this.f55270g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f55272i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f55265b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.f55265b);
            tTAdConfig.setPaid(this.f55266c);
            tTAdConfig.setKeywords(this.f55267d);
            tTAdConfig.setData(this.f55268e);
            tTAdConfig.setTitleBarTheme(this.f55269f);
            tTAdConfig.setAllowShowNotify(this.f55270g);
            tTAdConfig.setDebug(this.f55271h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f55272i);
            tTAdConfig.setDirectDownloadNetworkType(this.f55273j);
            tTAdConfig.setUseTextureView(this.f55274k);
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
            this.f55268e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f55271h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f55273j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.f55267d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f55266c = z;
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
            this.f55269f = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f55274k = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.f55255b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f55258e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f55263j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f55257d;
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
        return this.f55259f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f55260g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.f55262i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAsyncInit() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f55261h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f55256c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.f55264k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.o.remove(str);
    }

    public void setAllowShowNotify(boolean z) {
        this.f55260g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f55262i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.f55255b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.p = tTCustomController;
    }

    public void setData(String str) {
        this.f55258e = str;
    }

    public void setDebug(boolean z) {
        this.f55261h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f55263j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setKeywords(String str) {
        this.f55257d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f55256c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setThemeStatus(int i2) {
        this.q = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f55259f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.f55264k = z;
    }

    public TTAdConfig() {
        this.f55256c = false;
        this.f55259f = 0;
        this.f55260g = true;
        this.f55261h = false;
        this.f55262i = false;
        this.f55264k = false;
        this.l = false;
        this.n = false;
        this.o = new HashMap();
    }
}
