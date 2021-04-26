package com.baidu.turbonet.net.proxy;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
/* loaded from: classes5.dex */
public class ProxyConfig {

    /* renamed from: b  reason: collision with root package name */
    public static final ProxyConfig f23276b = new ProxyConfig();

    /* renamed from: a  reason: collision with root package name */
    public LibType f23277a = LibType.TURBONET;

    /* loaded from: classes5.dex */
    public enum LibType {
        NATIVE,
        TURBONET
    }

    public boolean a() {
        return this.f23277a == LibType.NATIVE;
    }

    public void b(LibType libType) {
        this.f23277a = libType;
    }

    public String toString() {
        return this.f23277a == LibType.NATIVE ? Constant.TYPE_NATIVE : "TURBONET";
    }
}
