package com.baidu.turbonet.net.proxy;
/* loaded from: classes10.dex */
public class ProxyConfig {
    public static final ProxyConfig neg = new ProxyConfig();
    private LibType nef = LibType.TURBONET;

    /* loaded from: classes10.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dKE() {
        return this.nef == LibType.NATIVE;
    }

    public String toString() {
        return this.nef == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.nef = libType;
    }
}
