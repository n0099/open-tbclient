package com.bytedance.sdk.openadsdk.core.h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28185a;

    /* renamed from: b  reason: collision with root package name */
    public int f28186b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f28187c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f28188d = 2;

    /* renamed from: e  reason: collision with root package name */
    public int f28189e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f28190f = 100;

    /* renamed from: g  reason: collision with root package name */
    public int f28191g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f28192h = 2;

    /* renamed from: i  reason: collision with root package name */
    public int f28193i = 1;
    public int j = 3;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = 2;
    public int o = 1;
    public int p = 0;
    public int q = 1500;
    public int r = 2;
    public int s = -1;
    public int t = 20;
    public int u = -1;
    public int v = 0;
    public int w = 0;
    public int x = 5;
    public List<String> y;

    public static a a() {
        return new a();
    }

    public a b(int i2) {
        this.v = i2;
        return this;
    }

    public a c(int i2) {
        this.w = i2;
        return this;
    }

    public a d(int i2) {
        this.t = i2;
        return this;
    }

    public a e(int i2) {
        this.s = i2;
        return this;
    }

    public a f(int i2) {
        this.p = i2;
        return this;
    }

    public a g(int i2) {
        this.q = i2;
        return this;
    }

    public a h(int i2) {
        this.r = i2;
        return this;
    }

    public a i(int i2) {
        this.n = i2;
        return this;
    }

    public a j(int i2) {
        this.l = i2;
        return this;
    }

    public a k(int i2) {
        this.m = i2;
        return this;
    }

    public a l(int i2) {
        this.k = i2;
        return this;
    }

    public a m(int i2) {
        this.j = i2;
        return this;
    }

    public a n(int i2) {
        this.f28186b = i2;
        return this;
    }

    public a o(int i2) {
        this.f28187c = i2;
        return this;
    }

    public a p(int i2) {
        this.f28188d = i2;
        return this;
    }

    public a q(int i2) {
        this.f28189e = i2;
        return this;
    }

    public a r(int i2) {
        this.f28190f = i2;
        return this;
    }

    public a s(int i2) {
        this.f28191g = i2;
        return this;
    }

    public a t(int i2) {
        this.f28192h = i2;
        return this;
    }

    public a u(int i2) {
        this.f28193i = i2;
        return this;
    }

    public a v(int i2) {
        this.o = i2;
        return this;
    }

    public a w(int i2) {
        this.x = i2;
        return this;
    }

    public a a(int i2) {
        this.u = i2;
        return this;
    }

    public a a(String str) {
        this.f28185a = str;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.y = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    this.y.add(jSONArray.get(i2).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
