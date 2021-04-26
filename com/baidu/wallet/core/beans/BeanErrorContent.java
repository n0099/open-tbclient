package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f24666a;

    /* renamed from: b  reason: collision with root package name */
    public int f24667b;

    /* renamed from: c  reason: collision with root package name */
    public String f24668c;

    /* renamed from: d  reason: collision with root package name */
    public Object f24669d;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.f24666a = i2;
        this.f24667b = i3;
        this.f24668c = str;
        this.f24669d = obj;
    }

    public int getBeanId() {
        return this.f24666a;
    }

    public Object getErrContent() {
        return this.f24669d;
    }

    public String getMsg() {
        return this.f24668c;
    }

    public int getRet() {
        return this.f24667b;
    }
}
