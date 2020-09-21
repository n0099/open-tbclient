package com.baidu.turbonet.net.proxy;
/* loaded from: classes15.dex */
public class ProxyConfig {
    public static final ProxyConfig nof = new ProxyConfig();
    private LibType noe = LibType.TURBONET;

    /* loaded from: classes15.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dOC() {
        return this.noe == LibType.NATIVE;
    }

    public String toString() {
        return this.noe == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.noe = libType;
    }
}
