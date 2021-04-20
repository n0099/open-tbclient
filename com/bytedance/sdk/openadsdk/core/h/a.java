package com.bytedance.sdk.openadsdk.core.h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28074a;

    /* renamed from: b  reason: collision with root package name */
    public int f28075b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f28076c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f28077d = 2;

    /* renamed from: e  reason: collision with root package name */
    public int f28078e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f28079f = 100;

    /* renamed from: g  reason: collision with root package name */
    public int f28080g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f28081h = 2;
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
        this.f28075b = i;
        return this;
    }

    public a o(int i) {
        this.f28076c = i;
        return this;
    }

    public a p(int i) {
        this.f28077d = i;
        return this;
    }

    public a q(int i) {
        this.f28078e = i;
        return this;
    }

    public a r(int i) {
        this.f28079f = i;
        return this;
    }

    public a s(int i) {
        this.f28080g = i;
        return this;
    }

    public a t(int i) {
        this.f28081h = i;
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
        this.f28074a = str;
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
