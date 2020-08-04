package com.baidu.turbonet.net.proxy;
/* loaded from: classes19.dex */
public class ProxyConfig {
    public static final ProxyConfig mKT = new ProxyConfig();
    private LibType mKS = LibType.TURBONET;

    /* loaded from: classes19.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dyI() {
        return this.mKS == LibType.NATIVE;
    }

    public String toString() {
        return this.mKS == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.mKS = libType;
    }
}
