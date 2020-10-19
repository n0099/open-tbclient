package com.baidu.turbonet.net.proxy;
/* loaded from: classes17.dex */
public class ProxyConfig {
    public static final ProxyConfig nDB = new ProxyConfig();
    private LibType nDA = LibType.TURBONET;

    /* loaded from: classes17.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dSo() {
        return this.nDA == LibType.NATIVE;
    }

    public String toString() {
        return this.nDA == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.nDA = libType;
    }
}
