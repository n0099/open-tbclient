package com.baidu.turbonet.net.proxy;
/* loaded from: classes5.dex */
public class ProxyConfig {
    public static final ProxyConfig oLS = new ProxyConfig();
    private LibType oLR = LibType.TURBONET;

    /* loaded from: classes5.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean ehJ() {
        return this.oLR == LibType.NATIVE;
    }

    public String toString() {
        return this.oLR == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oLR = libType;
    }
}
