package com.baidu.turbonet.net.proxy;
/* loaded from: classes17.dex */
public class ProxyConfig {
    public static final ProxyConfig oph = new ProxyConfig();
    private LibType opg = LibType.TURBONET;

    /* loaded from: classes17.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean ebO() {
        return this.opg == LibType.NATIVE;
    }

    public String toString() {
        return this.opg == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.opg = libType;
    }
}
