package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f23913a;

    /* renamed from: b  reason: collision with root package name */
    public int f23914b;

    /* renamed from: c  reason: collision with root package name */
    public String f23915c;

    /* renamed from: d  reason: collision with root package name */
    public Object f23916d;

    public BeanErrorContent(int i, int i2, String str, Object obj) {
        this.f23913a = i;
        this.f23914b = i2;
        this.f23915c = str;
        this.f23916d = obj;
    }

    public int getBeanId() {
        return this.f23913a;
    }

    public Object getErrContent() {
        return this.f23916d;
    }

    public String getMsg() {
        return this.f23915c;
    }

    public int getRet() {
        return this.f23914b;
    }
}
