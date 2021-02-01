package com.baidu.turbonet.net.proxy;
/* loaded from: classes6.dex */
public class ProxyConfig {
    public static final ProxyConfig oRw = new ProxyConfig();
    private LibType oRv = LibType.TURBONET;

    /* loaded from: classes6.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean egj() {
        return this.oRv == LibType.NATIVE;
    }

    public String toString() {
        return this.oRv == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.oRv = libType;
    }
}
