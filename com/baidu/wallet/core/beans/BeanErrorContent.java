package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f23840a;

    /* renamed from: b  reason: collision with root package name */
    public int f23841b;

    /* renamed from: c  reason: collision with root package name */
    public String f23842c;

    /* renamed from: d  reason: collision with root package name */
    public Object f23843d;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.f23840a = i2;
        this.f23841b = i3;
        this.f23842c = str;
        this.f23843d = obj;
    }

    public int getBeanId() {
        return this.f23840a;
    }

    public Object getErrContent() {
        return this.f23843d;
    }

    public String getMsg() {
        return this.f23842c;
    }

    public int getRet() {
        return this.f23841b;
    }
}
