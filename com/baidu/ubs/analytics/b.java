package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.a.i;
import com.baidu.ubs.analytics.a.l;
import com.baidu.ubs.analytics.a.n;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes5.dex */
public final class b implements Serializable {
    public a l;
    public List<n> m;
    public List<com.baidu.ubs.analytics.a.a> n;
    public List<l> o;
    public List<i> p;

    /* loaded from: classes5.dex */
    public static class a implements Serializable {
        public String A;
        public String B;
        public String C;
        public String D;
        public String E = "unkonw";

        /* renamed from: i  reason: collision with root package name */
        public String f22524i;
        public String osVersion;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public final String A() {
            return this.B;
        }

        public final String B() {
            return this.C;
        }

        public final String C() {
            return this.D;
        }

        public final void b(String str) {
            this.f22524i = str;
        }

        public final void d(String str) {
            this.q = str;
        }

        public final void e(String str) {
            this.r = str;
        }

        public final void f(String str) {
            this.s = str;
        }

        public final void g(String str) {
            this.osVersion = str;
        }

        public final String getImei() {
            return this.q;
        }

        public final String getOsVersion() {
            return this.osVersion;
        }

        public final String getPhone() {
            return this.E;
        }

        public final void h(String str) {
            this.t = str;
        }

        public final void i(String str) {
            this.u = str;
        }

        public final void j(String str) {
            this.v = str;
        }

        public final void k(String str) {
            this.w = str;
        }

        public final String l() {
            return this.f22524i;
        }

        public final void m(String str) {
            this.x = str;
        }

        public final void n(String str) {
            this.z = str;
        }

        public final void o(String str) {
            this.A = str;
        }

        public final void p(String str) {
            this.B = str;
        }

        public final void q(String str) {
            this.C = str;
        }

        public final String r() {
            return this.r;
        }

        public final String s() {
            return this.s;
        }

        public final void setPhone(String str) {
            this.E = str;
        }

        public final String t() {
            return this.t;
        }

        public final String u() {
            return this.u;
        }

        public final String v() {
            return this.v;
        }

        public final String w() {
            return this.w;
        }

        public final String x() {
            return this.y;
        }

        public final String y() {
            return this.z;
        }

        public final String z() {
            return this.A;
        }

        public final void l(String str) {
            this.y = str;
        }

        public final void r(String str) {
            this.D = str;
        }
    }

    public final void a(a aVar) {
        this.l = aVar;
    }

    public final void b(List<n> list) {
        this.m = list;
    }

    public final void c(List<com.baidu.ubs.analytics.a.a> list) {
        this.n = list;
    }

    public final void d(List<l> list) {
        this.o = list;
    }

    public final void e(List<i> list) {
        this.p = list;
    }

    public final List<com.baidu.ubs.analytics.a.a> getEvents() {
        return this.n;
    }

    public final a n() {
        return this.l;
    }

    public final List<n> o() {
        return this.m;
    }

    public final List<l> p() {
        return this.o;
    }

    public final List<i> q() {
        return this.p;
    }
}
