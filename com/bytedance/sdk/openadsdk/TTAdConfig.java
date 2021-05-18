package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.sdk.openadsdk.core.p;
import d.b.c.b.f.a;
/* loaded from: classes6.dex */
public final class TTAdConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f27038a;

    /* renamed from: b  reason: collision with root package name */
    public String f27039b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27040c;

    /* renamed from: d  reason: collision with root package name */
    public String f27041d;

    /* renamed from: e  reason: collision with root package name */
    public String f27042e;

    /* renamed from: f  reason: collision with root package name */
    public int f27043f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27044g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27045h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27046i;
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
        public String f27047a;

        /* renamed from: b  reason: collision with root package name */
        public String f27048b;

        /* renamed from: d  reason: collision with root package name */
        public String f27050d;

        /* renamed from: e  reason: collision with root package name */
        public String f27051e;
        public int[] j;
        public a m;
        public TTDownloadEventLogger n;
        public TTSecAbs o;
        public String[] p;
        public TTCustomController r;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27049c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f27052f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27053g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27054h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27055i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean q = false;

        public Builder allowShowNotify(boolean z) {
            this.f27053g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.f27055i = z;
            return this;
        }

        public Builder appId(String str) {
            this.f27047a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f27048b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.q = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f27047a);
            tTAdConfig.setAppName(this.f27048b);
            tTAdConfig.setPaid(this.f27049c);
            tTAdConfig.setKeywords(this.f27050d);
            tTAdConfig.setData(this.f27051e);
            tTAdConfig.setTitleBarTheme(this.f27052f);
            tTAdConfig.setAllowShowNotify(this.f27053g);
            tTAdConfig.setDebug(this.f27054h);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.f27055i);
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
            this.f27051e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f27054h = z;
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
            this.f27050d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.p = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f27049c = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f27052f = i2;
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
        return this.f27038a;
    }

    public String getAppName() {
        String str = this.f27039b;
        if (str == null || str.isEmpty()) {
            this.f27039b = a(p.a());
        }
        return this.f27039b;
    }

    public TTCustomController getCustomController() {
        return this.r;
    }

    public String getData() {
        return this.f27042e;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    public a getHttpStack() {
        return this.m;
    }

    public String getKeywords() {
        return this.f27041d;
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
        return this.f27043f;
    }

    public boolean isAllowShowNotify() {
        return this.f27044g;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.f27046i;
    }

    public boolean isAsyncInit() {
        return this.q;
    }

    public boolean isDebug() {
        return this.f27045h;
    }

    public boolean isPaid() {
        return this.f27040c;
    }

    public boolean isSupportMultiProcess() {
        return this.l;
    }

    public boolean isUseTextureView() {
        return this.k;
    }

    public void setAllowShowNotify(boolean z) {
        this.f27044g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.f27046i = z;
    }

    public void setAppId(String str) {
        this.f27038a = str;
    }

    public void setAppName(String str) {
        this.f27039b = str;
    }

    public void setAsyncInit(boolean z) {
        this.q = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.r = tTCustomController;
    }

    public void setData(String str) {
        this.f27042e = str;
    }

    public void setDebug(boolean z) {
        this.f27045h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    public void setHttpStack(a aVar) {
        this.m = aVar;
    }

    public void setKeywords(String str) {
        this.f27041d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.p = strArr;
    }

    public void setPaid(boolean z) {
        this.f27040c = z;
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
        this.f27043f = i2;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f27040c = false;
        this.f27043f = 0;
        this.f27044g = true;
        this.f27045h = false;
        this.f27046i = false;
        this.k = false;
        this.l = false;
        this.q = false;
    }
}
