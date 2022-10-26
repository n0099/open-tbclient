package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class TTAdConfig implements AdConfig {
    public String a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int[] j;
    public boolean k;
    public boolean l;
    public String[] m;
    public boolean n;
    public int o;
    public Map p;
    public TTCustomController q;
    public int r;

    public TTAdConfig() {
        this.c = false;
        this.f = 0;
        this.g = true;
        this.h = false;
        this.i = false;
        this.k = true;
        this.l = false;
        this.n = false;
        this.o = 0;
        this.p = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.d;
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
                return 4526;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "4.5.2.6";
            }
        };
    }

    public int getThemeStatus() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.g;
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
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.k;
    }

    /* loaded from: classes7.dex */
    public class Builder {
        public String a;
        public String b;
        public String d;
        public String e;
        public int[] j;
        public String[] m;
        public TTCustomController o;
        public int p;
        public boolean c = false;
        public int f = 0;
        public boolean g = true;
        public boolean h = false;
        public boolean i = false;
        public boolean k = true;
        public boolean l = false;
        public boolean n = false;
        public int q = 2;
        public int r = 0;

        public Builder allowShowNotify(boolean z) {
            this.g = z;
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
            this.b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.n = z;
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.o = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.j = iArr;
            return this;
        }

        public Builder keywords(String str) {
            this.d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.m = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.r = i;
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
            this.f = i;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.k = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.a);
            tTAdConfig.setAppName(this.b);
            tTAdConfig.setPaid(this.c);
            tTAdConfig.setKeywords(this.d);
            tTAdConfig.setData(this.e);
            tTAdConfig.setTitleBarTheme(this.f);
            tTAdConfig.setAllowShowNotify(this.g);
            tTAdConfig.setDebug(this.h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.i);
            tTAdConfig.setDirectDownloadNetworkType(this.j);
            tTAdConfig.setUseTextureView(this.k);
            tTAdConfig.setSupportMultiProcess(this.l);
            tTAdConfig.setNeedClearTaskReset(this.m);
            tTAdConfig.setAsyncInit(this.n);
            tTAdConfig.setCustomController(this.o);
            tTAdConfig.setThemeStatus(this.p);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.q));
            tTAdConfig.setExtra(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(this.r));
            return tTAdConfig;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.p.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.p.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public void setAgeGroup(int i) {
        this.p.put(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(i));
    }

    public void setAllowShowNotify(boolean z) {
        this.g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.i = z;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAppName(String str) {
        this.b = str;
    }

    public void setAsyncInit(boolean z) {
        this.n = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.q = tTCustomController;
    }

    public void setData(String str) {
        this.e = str;
    }

    public void setDebug(boolean z) {
        this.h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    public void setKeywords(String str) {
        this.d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.m = strArr;
    }

    public void setPaid(boolean z) {
        this.c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setThemeStatus(int i) {
        this.r = i;
    }

    public void setTitleBarTheme(int i) {
        this.f = i;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.p.put(str, obj);
    }
}
