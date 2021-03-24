package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f24227a;

    /* renamed from: b  reason: collision with root package name */
    public int f24228b;

    /* renamed from: c  reason: collision with root package name */
    public String f24229c;

    /* renamed from: d  reason: collision with root package name */
    public Object f24230d;

    public BeanErrorContent(int i, int i2, String str, Object obj) {
        this.f24227a = i;
        this.f24228b = i2;
        this.f24229c = str;
        this.f24230d = obj;
    }

    public int getBeanId() {
        return this.f24227a;
    }

    public Object getErrContent() {
        return this.f24230d;
    }

    public String getMsg() {
        return this.f24229c;
    }

    public int getRet() {
        return this.f24228b;
    }
}
