package com.baidu.turbonet.net.proxy;
/* loaded from: classes.dex */
public class ProxyConfig {
    public static final ProxyConfig mCH = new ProxyConfig();
    private LibType mCG = LibType.TURBONET;

    /* loaded from: classes.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dvq() {
        return this.mCG == LibType.NATIVE;
    }

    public String toString() {
        return this.mCG == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.mCG = libType;
    }
}
