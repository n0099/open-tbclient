package com.baidu.turbonet.net.proxy;
/* loaded from: classes14.dex */
public class ProxyConfig {
    public static final ProxyConfig oFH = new ProxyConfig();
    private LibType oFG = LibType.TURBONET;

    /* loaded from: classes14.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean ehs() {
        return this.oFG == LibType.NATIVE;
    }

    public String toString() {
        return this.oFG == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oFG = libType;
    }
}
