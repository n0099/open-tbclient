package com.baidu.turbonet.net.proxy;
/* loaded from: classes6.dex */
public class ProxyConfig {
    public static final ProxyConfig oRW = new ProxyConfig();
    private LibType oRV = LibType.TURBONET;

    /* loaded from: classes6.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean egr() {
        return this.oRV == LibType.NATIVE;
    }

    public String toString() {
        return this.oRV == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oRV = libType;
    }
}
