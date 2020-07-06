package com.baidu.turbonet.net.proxy;
/* loaded from: classes.dex */
public class ProxyConfig {
    public static final ProxyConfig mCK = new ProxyConfig();
    private LibType mCJ = LibType.TURBONET;

    /* loaded from: classes.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dvu() {
        return this.mCJ == LibType.NATIVE;
    }

    public String toString() {
        return this.mCJ == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.mCJ = libType;
    }
}
