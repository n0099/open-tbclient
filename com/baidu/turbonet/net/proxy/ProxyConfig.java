package com.baidu.turbonet.net.proxy;
/* loaded from: classes14.dex */
public class ProxyConfig {
    public static final ProxyConfig oFJ = new ProxyConfig();
    private LibType oFI = LibType.TURBONET;

    /* loaded from: classes14.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean eht() {
        return this.oFI == LibType.NATIVE;
    }

    public String toString() {
        return this.oFI == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oFI = libType;
    }
}
