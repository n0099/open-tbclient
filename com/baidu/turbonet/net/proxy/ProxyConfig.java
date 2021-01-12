package com.baidu.turbonet.net.proxy;
/* loaded from: classes4.dex */
public class ProxyConfig {
    public static final ProxyConfig oHn = new ProxyConfig();
    private LibType oHm = LibType.TURBONET;

    /* loaded from: classes4.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean edR() {
        return this.oHm == LibType.NATIVE;
    }

    public String toString() {
        return this.oHm == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oHm = libType;
    }
}
