package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f24025a;

    /* renamed from: b  reason: collision with root package name */
    public int f24026b;

    /* renamed from: c  reason: collision with root package name */
    public String f24027c;

    /* renamed from: d  reason: collision with root package name */
    public Object f24028d;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.f24025a = i2;
        this.f24026b = i3;
        this.f24027c = str;
        this.f24028d = obj;
    }

    public int getBeanId() {
        return this.f24025a;
    }

    public Object getErrContent() {
        return this.f24028d;
    }

    public String getMsg() {
        return this.f24027c;
    }

    public int getRet() {
        return this.f24026b;
    }
}
