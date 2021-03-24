package com.bytedance.sdk.openadsdk.core.h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28388a;

    /* renamed from: b  reason: collision with root package name */
    public int f28389b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f28390c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f28391d = 2;

    /* renamed from: e  reason: collision with root package name */
    public int f28392e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f28393f = 100;

    /* renamed from: g  reason: collision with root package name */
    public int f28394g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f28395h = 2;
    public int i = 1;
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

    public a b(int i) {
        this.v = i;
        return this;
    }

    public a c(int i) {
        this.w = i;
        return this;
    }

    public a d(int i) {
        this.t = i;
        return this;
    }

    public a e(int i) {
        this.s = i;
        return this;
    }

    public a f(int i) {
        this.p = i;
        return this;
    }

    public a g(int i) {
        this.q = i;
        return this;
    }

    public a h(int i) {
        this.r = i;
        return this;
    }

    public a i(int i) {
        this.n = i;
        return this;
    }

    public a j(int i) {
        this.l = i;
        return this;
    }

    public a k(int i) {
        this.m = i;
        return this;
    }

    public a l(int i) {
        this.k = i;
        return this;
    }

    public a m(int i) {
        this.j = i;
        return this;
    }

    public a n(int i) {
        this.f28389b = i;
        return this;
    }

    public a o(int i) {
        this.f28390c = i;
        return this;
    }

    public a p(int i) {
        this.f28391d = i;
        return this;
    }

    public a q(int i) {
        this.f28392e = i;
        return this;
    }

    public a r(int i) {
        this.f28393f = i;
        return this;
    }

    public a s(int i) {
        this.f28394g = i;
        return this;
    }

    public a t(int i) {
        this.f28395h = i;
        return this;
    }

    public a u(int i) {
        this.i = i;
        return this;
    }

    public a v(int i) {
        this.o = i;
        return this;
    }

    public a w(int i) {
        this.x = i;
        return this;
    }

    public a a(int i) {
        this.u = i;
        return this;
    }

    public a a(String str) {
        this.f28388a = str;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.y = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.y.add(jSONArray.get(i).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
