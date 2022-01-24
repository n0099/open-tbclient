package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class TTAdConfig implements AdConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f53201b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53202c;

    /* renamed from: d  reason: collision with root package name */
    public String f53203d;

    /* renamed from: e  reason: collision with root package name */
    public String f53204e;

    /* renamed from: f  reason: collision with root package name */
    public int f53205f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53206g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53207h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53208i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f53209j;
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
        public String f53210b;

        /* renamed from: d  reason: collision with root package name */
        public String f53212d;

        /* renamed from: e  reason: collision with root package name */
        public String f53213e;

        /* renamed from: j  reason: collision with root package name */
        public int[] f53218j;
        public String[] m;
        public TTCustomController o;
        public int p;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53211c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f53214f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f53215g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f53216h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f53217i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean n = false;
        public int q = 2;

        public Builder allowShowNotify(boolean z) {
            this.f53215g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f53217i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f53210b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.f53210b);
            tTAdConfig.setPaid(this.f53211c);
            tTAdConfig.setKeywords(this.f53212d);
            tTAdConfig.setData(this.f53213e);
            tTAdConfig.setTitleBarTheme(this.f53214f);
            tTAdConfig.setAllowShowNotify(this.f53215g);
            tTAdConfig.setDebug(this.f53216h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f53217i);
            tTAdConfig.setDirectDownloadNetworkType(this.f53218j);
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
            this.f53213e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f53216h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f53218j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.f53212d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f53211c = z;
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
            this.f53214f = i2;
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
        return this.f53201b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f53204e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f53209j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f53203d;
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
        return this.f53205f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f53206g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.f53208i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAsyncInit() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f53207h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f53202c;
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
        this.f53206g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f53208i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.f53201b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.p = tTCustomController;
    }

    public void setData(String str) {
        this.f53204e = str;
    }

    public void setDebug(boolean z) {
        this.f53207h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f53209j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setKeywords(String str) {
        this.f53203d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f53202c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setThemeStatus(int i2) {
        this.q = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f53205f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f53202c = false;
        this.f53205f = 0;
        this.f53206g = true;
        this.f53207h = false;
        this.f53208i = false;
        this.k = false;
        this.l = false;
        this.n = false;
        this.o = new HashMap();
    }
}
