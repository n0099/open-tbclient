package com.baidu.turbonet.net.proxy;
/* loaded from: classes17.dex */
public class ProxyConfig {
    public static final ProxyConfig ogd = new ProxyConfig();
    private LibType ogc = LibType.TURBONET;

    /* loaded from: classes17.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    private ProxyConfig() {
    }

    public boolean dYg() {
        return this.ogc == LibType.NATIVE;
    }

    public String toString() {
        return this.ogc == LibType.NATIVE ? "NATIVE" : "TURBONET";
    }

    public void a(LibType libType) {
        this.ogc = libType;
    }
}
