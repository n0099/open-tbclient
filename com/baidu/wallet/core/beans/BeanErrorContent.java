package com.baidu.wallet.core.beans;
/* loaded from: classes5.dex */
public class BeanErrorContent {

    /* renamed from: a  reason: collision with root package name */
    public int f23943a;

    /* renamed from: b  reason: collision with root package name */
    public int f23944b;

    /* renamed from: c  reason: collision with root package name */
    public String f23945c;

    /* renamed from: d  reason: collision with root package name */
    public Object f23946d;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.f23943a = i2;
        this.f23944b = i3;
        this.f23945c = str;
        this.f23946d = obj;
    }

    public int getBeanId() {
        return this.f23943a;
    }

    public Object getErrContent() {
        return this.f23946d;
    }

    public String getMsg() {
        return this.f23945c;
    }

    public int getRet() {
        return this.f23944b;
    }
}
