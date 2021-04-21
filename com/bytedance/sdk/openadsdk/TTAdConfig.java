package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.sdk.openadsdk.core.p;
import d.c.c.b.f.a;
/* loaded from: classes5.dex */
public final class TTAdConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f26975a;

    /* renamed from: b  reason: collision with root package name */
    public String f26976b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26977c;

    /* renamed from: d  reason: collision with root package name */
    public String f26978d;

    /* renamed from: e  reason: collision with root package name */
    public String f26979e;

    /* renamed from: f  reason: collision with root package name */
    public int f26980f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26981g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26982h;
    public boolean i;
    public int[] j;
    public boolean k;
    public boolean l;
    public a m;
    public TTDownloadEventLogger n;
    public TTSecAbs o;
    public String[] p;
    public boolean q;
    public TTCustomController r;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f26983a;

        /* renamed from: b  reason: collision with root package name */
        public String f26984b;

        /* renamed from: d  reason: collision with root package name */
        public String f26986d;

        /* renamed from: e  reason: collision with root package name */
        public String f26987e;
        public int[] j;
        public a m;
        public TTDownloadEventLogger n;
        public TTSecAbs o;
        public String[] p;
        public TTCustomController r;

        /* renamed from: c  reason: collision with root package name */
        public boolean f26985c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f26988f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f26989g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f26990h = false;
        public boolean i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean q = false;

        public Builder allowShowNotify(boolean z) {
            this.f26989g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.i = z;
            return this;
        }

        public Builder appId(String str) {
            this.f26983a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f26984b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.q = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f26983a);
            tTAdConfig.setAppName(this.f26984b);
            tTAdConfig.setPaid(this.f26985c);
            tTAdConfig.setKeywords(this.f26986d);
            tTAdConfig.setData(this.f26987e);
            tTAdConfig.setTitleBarTheme(this.f26988f);
            tTAdConfig.setAllowShowNotify(this.f26989g);
            tTAdConfig.setDebug(this.f26990h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.i);
            tTAdConfig.setDirectDownloadNetworkType(this.j);
            tTAdConfig.setUseTextureView(this.k);
            tTAdConfig.setSupportMultiProcess(this.l);
            tTAdConfig.setHttpStack(this.m);
            tTAdConfig.setTTDownloadEventLogger(this.n);
            tTAdConfig.setTTSecAbs(this.o);
            tTAdConfig.setNeedClearTaskReset(this.p);
            tTAdConfig.setAsyncInit(this.q);
            tTAdConfig.setCustomController(this.r);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.r = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.f26987e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f26990h = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.j = iArr;
            return this;
        }

        @Deprecated
        public Builder globalDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
            return this;
        }

        public Builder httpStack(a aVar) {
            this.m = aVar;
            return this;
        }

        public Builder keywords(String str) {
            this.f26986d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.p = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f26985c = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f26988f = i;
            return this;
        }

        public Builder ttDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
            this.n = tTDownloadEventLogger;
            return this;
        }

        public Builder ttSecAbs(TTSecAbs tTSecAbs) {
            this.o = tTSecAbs;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.k = z;
            return this;
        }
    }

    private String a(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public String getAppId() {
        return this.f26975a;
    }

    public String getAppName() {
        String str = this.f26976b;
        if (str == null || str.isEmpty()) {
            this.f26976b = a(p.a());
        }
        return this.f26976b;
    }

    public TTCustomController getCustomController() {
        return this.r;
    }

    public String getData() {
        return this.f26979e;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    public a getHttpStack() {
        return this.m;
    }

    public String getKeywords() {
        return this.f26978d;
    }

    public String[] getNeedClearTaskReset() {
        return this.p;
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return this.n;
    }

    public TTSecAbs getTTSecAbs() {
        return this.o;
    }

    public int getTitleBarTheme() {
        return this.f26980f;
    }

    public boolean isAllowShowNotify() {
        return this.f26981g;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.i;
    }

    public boolean isAsyncInit() {
        return this.q;
    }

    public boolean isDebug() {
        return this.f26982h;
    }

    public boolean isPaid() {
        return this.f26977c;
    }

    public boolean isSupportMultiProcess() {
        return this.l;
    }

    public boolean isUseTextureView() {
        return this.k;
    }

    public void setAllowShowNotify(boolean z) {
        this.f26981g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.i = z;
    }

    public void setAppId(String str) {
        this.f26975a = str;
    }

    public void setAppName(String str) {
        this.f26976b = str;
    }

    public void setAsyncInit(boolean z) {
        this.q = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.r = tTCustomController;
    }

    public void setData(String str) {
        this.f26979e = str;
    }

    public void setDebug(boolean z) {
        this.f26982h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    public void setHttpStack(a aVar) {
        this.m = aVar;
    }

    public void setKeywords(String str) {
        this.f26978d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.p = strArr;
    }

    public void setPaid(boolean z) {
        this.f26977c = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public void setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        this.n = tTDownloadEventLogger;
    }

    public void setTTSecAbs(TTSecAbs tTSecAbs) {
        this.o = tTSecAbs;
    }

    public void setTitleBarTheme(int i) {
        this.f26980f = i;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f26977c = false;
        this.f26980f = 0;
        this.f26981g = true;
        this.f26982h = false;
        this.i = false;
        this.k = false;
        this.l = false;
        this.q = false;
    }
}
