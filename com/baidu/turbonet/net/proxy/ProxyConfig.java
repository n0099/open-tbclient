package com.baidu.turbonet.net.proxy;
/* loaded from: classes.dex */
public class ProxyConfig {
    public static final ProxyConfig lMm = new ProxyConfig();
    private LibType lMl = LibType.TURBONET;

    /* loaded from: classes.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean djj() {
        return this.lMl == LibType.NATIVE;
    }

    public String toString() {
        return this.lMl == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.lMl = libType;
    }
}
