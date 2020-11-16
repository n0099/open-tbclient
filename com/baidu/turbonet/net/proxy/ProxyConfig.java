package com.baidu.turbonet.net.proxy;
/* loaded from: classes12.dex */
public class ProxyConfig {
    public static final ProxyConfig oqL = new ProxyConfig();
    private LibType oqK = LibType.TURBONET;

    /* loaded from: classes12.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean ebN() {
        return this.oqK == LibType.NATIVE;
    }

    public String toString() {
        return this.oqK == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oqK = libType;
    }
}
