package com.baidu.turbonet.net.proxy;
/* loaded from: classes19.dex */
public class ProxyConfig {
    public static final ProxyConfig mKR = new ProxyConfig();
    private LibType mKQ = LibType.TURBONET;

    /* loaded from: classes19.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dyH() {
        return this.mKQ == LibType.NATIVE;
    }

    public String toString() {
        return this.mKQ == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.mKQ = libType;
    }
}
