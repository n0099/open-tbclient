package com.baidu.turbonet.net.proxy;
/* loaded from: classes4.dex */
public class ProxyConfig {
    public static final ProxyConfig oHo = new ProxyConfig();
    private LibType oHn = LibType.TURBONET;

    /* loaded from: classes4.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean edR() {
        return this.oHn == LibType.NATIVE;
    }

    public String toString() {
        return this.oHn == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oHn = libType;
    }
}
