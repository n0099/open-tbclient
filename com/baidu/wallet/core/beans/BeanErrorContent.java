package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f23911a;

    /* renamed from: b  reason: collision with root package name */
    public int f23912b;

    /* renamed from: c  reason: collision with root package name */
    public String f23913c;

    /* renamed from: d  reason: collision with root package name */
    public Object f23914d;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.f23911a = i2;
        this.f23912b = i3;
        this.f23913c = str;
        this.f23914d = obj;
    }

    public int getBeanId() {
        return this.f23911a;
    }

    public Object getErrContent() {
        return this.f23914d;
    }

    public String getMsg() {
        return this.f23913c;
    }

    public int getRet() {
        return this.f23912b;
    }
}
