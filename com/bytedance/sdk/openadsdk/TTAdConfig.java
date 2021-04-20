package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.sdk.openadsdk.core.p;
import d.c.c.b.f.a;
/* loaded from: classes5.dex */
public final class TTAdConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f26967a;

    /* renamed from: b  reason: collision with root package name */
    public String f26968b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26969c;

    /* renamed from: d  reason: collision with root package name */
    public String f26970d;

    /* renamed from: e  reason: collision with root package name */
    public String f26971e;

    /* renamed from: f  reason: collision with root package name */
    public int f26972f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26973g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26974h;
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
        public String f26975a;

        /* renamed from: b  reason: collision with root package name */
        public String f26976b;

        /* renamed from: d  reason: collision with root package name */
        public String f26978d;

        /* renamed from: e  reason: collision with root package name */
        public String f26979e;
        public int[] j;
        public a m;
        public TTDownloadEventLogger n;
        public TTSecAbs o;
        public String[] p;
        public TTCustomController r;

        /* renamed from: c  reason: collision with root package name */
        public boolean f26977c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f26980f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f26981g = true;

        /* renamed from: h  reason: collision with root package name */
        public boolean f26982h = false;
        public boolean i = false;
        public boolean k = false;
        public boolean l = false;
        public boolean q = false;

        public Builder allowShowNotify(boolean z) {
            this.f26981g = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.i = z;
            return this;
        }

        public Builder appId(String str) {
            this.f26975a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f26976b = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.q = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f26975a);
            tTAdConfig.setAppName(this.f26976b);
            tTAdConfig.setPaid(this.f26977c);
            tTAdConfig.setKeywords(this.f26978d);
            tTAdConfig.setData(this.f26979e);
            tTAdConfig.setTitleBarTheme(this.f26980f);
            tTAdConfig.setAllowShowNotify(this.f26981g);
            tTAdConfig.setDebug(this.f26982h);
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
            this.f26979e = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.f26982h = z;
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
            this.f26978d = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.p = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.f26977c = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f26980f = i;
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
        return this.f26967a;
    }

    public String getAppName() {
        String str = this.f26968b;
        if (str == null || str.isEmpty()) {
            this.f26968b = a(p.a());
        }
        return this.f26968b;
    }

    public TTCustomController getCustomController() {
        return this.r;
    }

    public String getData() {
        return this.f26971e;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    public a getHttpStack() {
        return this.m;
    }

    public String getKeywords() {
        return this.f26970d;
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
        return this.f26972f;
    }

    public boolean isAllowShowNotify() {
        return this.f26973g;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.i;
    }

    public boolean isAsyncInit() {
        return this.q;
    }

    public boolean isDebug() {
        return this.f26974h;
    }

    public boolean isPaid() {
        return this.f26969c;
    }

    public boolean isSupportMultiProcess() {
        return this.l;
    }

    public boolean isUseTextureView() {
        return this.k;
    }

    public void setAllowShowNotify(boolean z) {
        this.f26973g = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.i = z;
    }

    public void setAppId(String str) {
        this.f26967a = str;
    }

    public void setAppName(String str) {
        this.f26968b = str;
    }

    public void setAsyncInit(boolean z) {
        this.q = z;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.r = tTCustomController;
    }

    public void setData(String str) {
        this.f26971e = str;
    }

    public void setDebug(boolean z) {
        this.f26974h = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    public void setHttpStack(a aVar) {
        this.m = aVar;
    }

    public void setKeywords(String str) {
        this.f26970d = str;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.p = strArr;
    }

    public void setPaid(boolean z) {
        this.f26969c = z;
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
        this.f26972f = i;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public TTAdConfig() {
        this.f26969c = false;
        this.f26972f = 0;
        this.f26973g = true;
        this.f26974h = false;
        this.i = false;
        this.k = false;
        this.l = false;
        this.q = false;
    }
}
