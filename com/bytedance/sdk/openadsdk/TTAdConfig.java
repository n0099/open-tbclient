package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class TTAdConfig implements AdConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f51787b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51788c;

    /* renamed from: d  reason: collision with root package name */
    public String f51789d;

    /* renamed from: e  reason: collision with root package name */
    public String f51790e;

    /* renamed from: f  reason: collision with root package name */
    public int f51791f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51792g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51793h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51794i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f51795j;
    public boolean k;
    public boolean l;
    public String[] m;
    public boolean n;
    public Map<String, Object> o;
    public TTCustomController p;
    public int q;

    /* loaded from: classes7.dex */
    public static class Builder {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f51796b;

        /* renamed from: d  reason: collision with root package name */
        public String f51798d;

        /* renamed from: e  reason: collision with root package name */
        public String f51799e;

        /* renamed from: j  reason: collision with root package name */
        public int[] f51804j;
        public String[] m;
        public TTCustomController o;
        public int p;

        /* renamed from: c  reason: collision with root package name */
        public boolean f51797c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f51800f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f51801g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f51802h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f51803i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean n = false;
        public int q = 2;

        public Builder allowShowNotify(boolean z) {
            this.f51801g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f51803i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f51796b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.f51796b);
            tTAdConfig.setPaid(this.f51797c);
            tTAdConfig.setKeywords(this.f51798d);
            tTAdConfig.setData(this.f51799e);
            tTAdConfig.setTitleBarTheme(this.f51800f);
            tTAdConfig.setAllowShowNotify(this.f51801g);
            tTAdConfig.setDebug(this.f51802h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f51803i);
            tTAdConfig.setDirectDownloadNetworkType(this.f51804j);
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
            this.f51799e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f51802h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f51804j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.f51798d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f51797c = z;
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
            this.f51800f = i2;
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
        return this.f51787b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f51790e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f51795j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f51789d;
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
        return this.f51791f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f51792g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.f51794i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAsyncInit() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f51793h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f51788c;
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
        this.f51792g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f51794i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.f51787b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.p = tTCustomController;
    }

    public void setData(String str) {
        this.f51790e = str;
    }

    public void setDebug(boolean z) {
        this.f51793h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f51795j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setKeywords(String str) {
        this.f51789d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f51788c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setThemeStatus(int i2) {
        this.q = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f51791f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f51788c = false;
        this.f51791f = 0;
        this.f51792g = true;
        this.f51793h = false;
        this.f51794i = false;
        this.k = false;
        this.l = false;
        this.n = false;
        this.o = new HashMap();
    }
}
