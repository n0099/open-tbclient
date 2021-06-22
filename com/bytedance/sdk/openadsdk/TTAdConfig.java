package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.sdk.openadsdk.core.p;
import d.b.c.b.f.a;
/* loaded from: classes6.dex */
public final class TTAdConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f27152a;

    /* renamed from: b  reason: collision with root package name */
    public String f27153b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27154c;

    /* renamed from: d  reason: collision with root package name */
    public String f27155d;

    /* renamed from: e  reason: collision with root package name */
    public String f27156e;

    /* renamed from: f  reason: collision with root package name */
    public int f27157f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27158g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27159h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27160i;
    public int[] j;
    public boolean k;
    public boolean l;
    public a m;
    public TTDownloadEventLogger n;
    public TTSecAbs o;
    public String[] p;
    public boolean q;
    public TTCustomController r;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f27161a;

        /* renamed from: b  reason: collision with root package name */
        public String f27162b;

        /* renamed from: d  reason: collision with root package name */
        public String f27164d;

        /* renamed from: e  reason: collision with root package name */
        public String f27165e;
        public int[] j;
        public a m;
        public TTDownloadEventLogger n;
        public TTSecAbs o;
        public String[] p;
        public TTCustomController r;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27163c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f27166f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27167g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27168h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27169i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean q = false;

        public Builder allowShowNotify(boolean z) {
            this.f27167g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f27169i = z;
            return this;
        }

        public Builder appId(String str) {
            this.f27161a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f27162b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.q = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f27161a);
            tTAdConfig.setAppName(this.f27162b);
            tTAdConfig.setPaid(this.f27163c);
            tTAdConfig.setKeywords(this.f27164d);
            tTAdConfig.setData(this.f27165e);
            tTAdConfig.setTitleBarTheme(this.f27166f);
            tTAdConfig.setAllowShowNotify(this.f27167g);
            tTAdConfig.setDebug(this.f27168h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f27169i);
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
            this.f27165e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f27168h = z;
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
            this.f27164d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.p = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f27163c = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f27166f = i2;
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
        return this.f27152a;
    }

    public String getAppName() {
        String str = this.f27153b;
        if (str == null || str.isEmpty()) {
            this.f27153b = a(p.a());
        }
        return this.f27153b;
    }

    public TTCustomController getCustomController() {
        return this.r;
    }

    public String getData() {
        return this.f27156e;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    public a getHttpStack() {
        return this.m;
    }

    public String getKeywords() {
        return this.f27155d;
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
        return this.f27157f;
    }

    public boolean isAllowShowNotify() {
        return this.f27158g;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.f27160i;
    }

    public boolean isAsyncInit() {
        return this.q;
    }

    public boolean isDebug() {
        return this.f27159h;
    }

    public boolean isPaid() {
        return this.f27154c;
    }

    public boolean isSupportMultiProcess() {
        return this.l;
    }

    public boolean isUseTextureView() {
        return this.k;
    }

    public void setAllowShowNotify(boolean z) {
        this.f27158g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f27160i = z;
    }

    public void setAppId(String str) {
        this.f27152a = str;
    }

    public void setAppName(String str) {
        this.f27153b = str;
    }

    public void setAsyncInit(boolean z) {
        this.q = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.r = tTCustomController;
    }

    public void setData(String str) {
        this.f27156e = str;
    }

    public void setDebug(boolean z) {
        this.f27159h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    public void setHttpStack(a aVar) {
        this.m = aVar;
    }

    public void setKeywords(String str) {
        this.f27155d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.p = strArr;
    }

    public void setPaid(boolean z) {
        this.f27154c = z;
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

    public void setTitleBarTheme(int i2) {
        this.f27157f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f27154c = false;
        this.f27157f = 0;
        this.f27158g = true;
        this.f27159h = false;
        this.f27160i = false;
        this.k = false;
        this.l = false;
        this.q = false;
    }
}
