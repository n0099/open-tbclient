package com.bytedance.sdk.openadsdk.core.h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f6868a;

    /* renamed from: b  reason: collision with root package name */
    public int f6869b = 1;
    public int c = 1;
    public int d = 2;
    public int e = 1;
    public int f = 1;
    public int g = 100;
    public int h = 0;
    public int i = 2;
    public int j = 1;
    public int k = 3;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = 2;
    public int p = 1;
    public int q = 0;
    public int r = 1500;
    public int s = 2;
    public int t = -1;
    public int u = 20;
    public int v = -1;
    public int w = 0;
    public int x = 0;
    public int y = 5;
    public List<String> z;

    public static a a() {
        return new a();
    }

    private a() {
    }

    public a a(int i) {
        this.v = i;
        return this;
    }

    public a b(int i) {
        this.w = i;
        return this;
    }

    public a c(int i) {
        this.x = i;
        return this;
    }

    public a d(int i) {
        this.u = i;
        return this;
    }

    public a e(int i) {
        this.t = i;
        return this;
    }

    public a f(int i) {
        this.q = i;
        return this;
    }

    public a g(int i) {
        this.r = i;
        return this;
    }

    public a h(int i) {
        this.s = i;
        return this;
    }

    public a i(int i) {
        this.o = i;
        return this;
    }

    public a j(int i) {
        this.m = i;
        return this;
    }

    public a k(int i) {
        this.n = i;
        return this;
    }

    public a l(int i) {
        this.l = i;
        return this;
    }

    public a m(int i) {
        this.k = i;
        return this;
    }

    public a a(String str) {
        this.f6868a = str;
        return this;
    }

    public a n(int i) {
        this.f6869b = i;
        return this;
    }

    public a o(int i) {
        this.c = i;
        return this;
    }

    public a p(int i) {
        this.d = i;
        return this;
    }

    public a q(int i) {
        this.e = i;
        return this;
    }

    public a r(int i) {
        this.f = i;
        return this;
    }

    public a s(int i) {
        this.g = i;
        return this;
    }

    public a t(int i) {
        this.h = i;
        return this;
    }

    public a u(int i) {
        this.i = i;
        return this;
    }

    public a v(int i) {
        this.j = i;
        return this;
    }

    public a w(int i) {
        this.p = i;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.z = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.z.add(jSONArray.get(i).toString());
                } catch (Exception e) {
                }
            }
        }
        return this;
    }

    public a x(int i) {
        this.y = i;
        return this;
    }
}
