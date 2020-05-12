package com.baidu.turbonet.net.proxy;
/* loaded from: classes.dex */
public class ProxyConfig {
    public static final ProxyConfig lMq = new ProxyConfig();
    private LibType lMp = LibType.TURBONET;

    /* loaded from: classes.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean djh() {
        return this.lMp == LibType.NATIVE;
    }

    public String toString() {
        return this.lMp == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.lMp = libType;
    }
}
