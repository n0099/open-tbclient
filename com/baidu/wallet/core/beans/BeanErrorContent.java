package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f23921a;

    /* renamed from: b  reason: collision with root package name */
    public int f23922b;

    /* renamed from: c  reason: collision with root package name */
    public String f23923c;

    /* renamed from: d  reason: collision with root package name */
    public Object f23924d;

    public BeanErrorContent(int i, int i2, String str, Object obj) {
        this.f23921a = i;
        this.f23922b = i2;
        this.f23923c = str;
        this.f23924d = obj;
    }

    public int getBeanId() {
        return this.f23921a;
    }

    public Object getErrContent() {
        return this.f23924d;
    }

    public String getMsg() {
        return this.f23923c;
    }

    public int getRet() {
        return this.f23922b;
    }
}
