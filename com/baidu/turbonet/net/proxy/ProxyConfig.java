package com.baidu.turbonet.net.proxy;
/* loaded from: classes5.dex */
public class ProxyConfig {
    public static final ProxyConfig oUb = new ProxyConfig();
    private LibType oUa = LibType.TURBONET;

    /* loaded from: classes5.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean egz() {
        return this.oUa == LibType.NATIVE;
    }

    public String toString() {
        return this.oUa == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oUa = libType;
    }
}
