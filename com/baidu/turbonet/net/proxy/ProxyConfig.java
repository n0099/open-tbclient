package com.baidu.turbonet.net.proxy;
/* loaded from: classes.dex */
public class ProxyConfig {
    public static final ProxyConfig mfF = new ProxyConfig();
    private LibType mfE = LibType.TURBONET;

    /* loaded from: classes.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dqx() {
        return this.mfE == LibType.NATIVE;
    }

    public String toString() {
        return this.mfE == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.mfE = libType;
    }
}
