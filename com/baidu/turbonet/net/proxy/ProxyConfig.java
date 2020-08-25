package com.baidu.turbonet.net.proxy;
/* loaded from: classes10.dex */
public class ProxyConfig {
    public static final ProxyConfig ndO = new ProxyConfig();
    private LibType ndN = LibType.TURBONET;

    /* loaded from: classes10.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dKv() {
        return this.ndN == LibType.NATIVE;
    }

    public String toString() {
        return this.ndN == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.ndN = libType;
    }
}
