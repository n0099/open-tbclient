package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class TTAdConfig implements AdConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f38204b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38205c;

    /* renamed from: d  reason: collision with root package name */
    public String f38206d;

    /* renamed from: e  reason: collision with root package name */
    public String f38207e;

    /* renamed from: f  reason: collision with root package name */
    public int f38208f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38209g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38210h;
    public boolean i;
    public int[] j;
    public boolean k;
    public boolean l;
    public String[] m;
    public boolean n;
    public Map<String, Object> o;
    public TTCustomController p;
    public int q;

    /* loaded from: classes6.dex */
    public static class Builder {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f38211b;

        /* renamed from: d  reason: collision with root package name */
        public String f38213d;

        /* renamed from: e  reason: collision with root package name */
        public String f38214e;
        public int[] j;
        public String[] m;
        public TTCustomController o;
        public int p;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38212c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f38215f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38216g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38217h = false;
        public boolean i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean n = false;
        public int q = 2;

        public Builder allowShowNotify(boolean z) {
            this.f38216g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.i = z;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f38211b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.f38211b);
            tTAdConfig.setPaid(this.f38212c);
            tTAdConfig.setKeywords(this.f38213d);
            tTAdConfig.setData(this.f38214e);
            tTAdConfig.setTitleBarTheme(this.f38215f);
            tTAdConfig.setAllowShowNotify(this.f38216g);
            tTAdConfig.setDebug(this.f38217h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.i);
            tTAdConfig.setDirectDownloadNetworkType(this.j);
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
            this.f38214e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f38217h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.f38213d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f38212c = z;
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.q = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder themeStatus(int i) {
            this.p = i;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f38215f = i;
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
        return this.f38204b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f38207e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f38206d;
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
        return this.f38208f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f38209g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAsyncInit() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f38210h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f38205c;
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
        this.f38209g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.f38204b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.p = tTCustomController;
    }

    public void setData(String str) {
        this.f38207e = str;
    }

    public void setDebug(boolean z) {
        this.f38210h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setKeywords(String str) {
        this.f38206d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.f38205c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setThemeStatus(int i) {
        this.q = i;
    }

    public void setTitleBarTheme(int i) {
        this.f38208f = i;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f38205c = false;
        this.f38208f = 0;
        this.f38209g = true;
        this.f38210h = false;
        this.i = false;
        this.k = false;
        this.l = false;
        this.n = false;
        this.o = new HashMap();
    }
}
