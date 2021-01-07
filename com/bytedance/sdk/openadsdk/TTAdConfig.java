package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.adnet.e.a;
/* loaded from: classes4.dex */
public final class TTAdConfig {

    /* renamed from: a  reason: collision with root package name */
    private String f6378a;

    /* renamed from: b  reason: collision with root package name */
    private String f6379b;
    private boolean c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int[] j;
    private boolean k;
    private boolean l;
    private a m;
    private TTDownloadEventLogger n;
    private TTSecAbs o;
    private String[] p;
    private boolean q;
    private TTCustomController r;

    private TTAdConfig() {
        this.c = false;
        this.f = 0;
        this.g = true;
        this.h = false;
        this.i = false;
        this.k = false;
        this.l = false;
        this.q = false;
    }

    public String getAppId() {
        return this.f6378a;
    }

    public void setAppId(String str) {
        this.f6378a = str;
    }

    public String getAppName() {
        return this.f6379b;
    }

    public void setAppName(String str) {
        this.f6379b = str;
    }

    public boolean isPaid() {
        return this.c;
    }

    public void setPaid(boolean z) {
        this.c = z;
    }

    public String getKeywords() {
        return this.d;
    }

    public void setKeywords(String str) {
        this.d = str;
    }

    public String getData() {
        return this.e;
    }

    public void setData(String str) {
        this.e = str;
    }

    public int getTitleBarTheme() {
        return this.f;
    }

    public void setTitleBarTheme(int i) {
        this.f = i;
    }

    public boolean isAllowShowNotify() {
        return this.g;
    }

    public void setAllowShowNotify(boolean z) {
        this.g = z;
    }

    public boolean isDebug() {
        return this.h;
    }

    public void setDebug(boolean z) {
        this.h = z;
    }

    public boolean isAllowShowPageWhenScreenLock() {
        return this.i;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.i = z;
    }

    public int[] getDirectDownloadNetworkType() {
        return this.j;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.j = iArr;
    }

    public boolean isUseTextureView() {
        return this.k;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }

    public boolean isSupportMultiProcess() {
        return this.l;
    }

    public void setSupportMultiProcess(boolean z) {
        this.l = z;
    }

    public a getHttpStack() {
        return this.m;
    }

    public void setHttpStack(a aVar) {
        this.m = aVar;
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return this.n;
    }

    public void setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        this.n = tTDownloadEventLogger;
    }

    public TTSecAbs getTTSecAbs() {
        return this.o;
    }

    public void setTTSecAbs(TTSecAbs tTSecAbs) {
        this.o = tTSecAbs;
    }

    public String[] getNeedClearTaskReset() {
        return this.p;
    }

    public void setNeedClearTaskReset(String... strArr) {
        this.p = strArr;
    }

    public boolean isAsyncInit() {
        return this.q;
    }

    public void setAsyncInit(boolean z) {
        this.q = z;
    }

    public TTCustomController getCustomController() {
        return this.r;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.r = tTCustomController;
    }

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f6380a;

        /* renamed from: b  reason: collision with root package name */
        private String f6381b;
        private String d;
        private String e;
        private int[] j;
        private a m;
        private TTDownloadEventLogger n;
        private TTSecAbs o;
        private String[] p;
        private TTCustomController r;
        private boolean c = false;
        private int f = 0;
        private boolean g = true;
        private boolean h = false;
        private boolean i = false;
        private boolean k = false;
        private boolean l = false;
        private boolean q = false;

        public Builder appId(String str) {
            this.f6380a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f6381b = str;
            return this;
        }

        public Builder paid(boolean z) {
            this.c = z;
            return this;
        }

        public Builder keywords(String str) {
            this.d = str;
            return this;
        }

        public Builder data(String str) {
            this.e = str;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f = i;
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.g = z;
            return this;
        }

        public Builder debug(boolean z) {
            this.h = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.i = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.j = iArr;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.k = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.l = z;
            return this;
        }

        public Builder httpStack(a aVar) {
            this.m = aVar;
            return this;
        }

        @Deprecated
        public Builder globalDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
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

        public Builder needClearTaskReset(String... strArr) {
            this.p = strArr;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.q = z;
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.r = tTCustomController;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.f6380a);
            tTAdConfig.setAppName(this.f6381b);
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
            tTAdConfig.setHttpStack(this.m);
            tTAdConfig.setTTDownloadEventLogger(this.n);
            tTAdConfig.setTTSecAbs(this.o);
            tTAdConfig.setNeedClearTaskReset(this.p);
            tTAdConfig.setAsyncInit(this.q);
            tTAdConfig.setCustomController(this.r);
            return tTAdConfig;
        }
    }
}
