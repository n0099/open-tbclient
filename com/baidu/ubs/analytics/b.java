package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.a.i;
import com.baidu.ubs.analytics.a.l;
import com.baidu.ubs.analytics.a.n;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes6.dex */
public final class b implements Serializable {
    private a l;
    private List<n> m;
    private List<com.baidu.ubs.analytics.a.a> n;
    private List<l> o;
    private List<i> p;

    public final a n() {
        return this.l;
    }

    public final void a(a aVar) {
        this.l = aVar;
    }

    public final List<n> o() {
        return this.m;
    }

    public final void b(List<n> list) {
        this.m = list;
    }

    public final List<com.baidu.ubs.analytics.a.a> getEvents() {
        return this.n;
    }

    public final void c(List<com.baidu.ubs.analytics.a.a> list) {
        this.n = list;
    }

    public final List<l> p() {
        return this.o;
    }

    public final void d(List<l> list) {
        this.o = list;
    }

    public final List<i> q() {
        return this.p;
    }

    public final void e(List<i> list) {
        this.p = list;
    }

    /* loaded from: classes6.dex */
    public static class a implements Serializable {
        private String A;
        private String B;
        private String C;
        private String D;
        private String E = "unkonw";
        private String i;
        private String osVersion;
        private String q;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private String w;
        private String x;
        private String y;
        private String z;

        public final String getImei() {
            return this.q;
        }

        public final void d(String str) {
            this.q = str;
        }

        public final String r() {
            return this.r;
        }

        public final void e(String str) {
            this.r = str;
        }

        public final String s() {
            return this.s;
        }

        public final void f(String str) {
            this.s = str;
        }

        public final String getOsVersion() {
            return this.osVersion;
        }

        public final void g(String str) {
            this.osVersion = str;
        }

        public final String t() {
            return this.t;
        }

        public final void h(String str) {
            this.t = str;
        }

        public final String u() {
            return this.u;
        }

        public final void i(String str) {
            this.u = str;
        }

        public final String v() {
            return this.v;
        }

        public final void j(String str) {
            this.v = str;
        }

        public final String w() {
            return this.w;
        }

        public final void k(String str) {
            this.w = str;
        }

        public final String l() {
            return this.i;
        }

        public final void b(String str) {
            this.i = str;
        }

        public final String x() {
            return this.y;
        }

        public final void l(String str) {
            this.y = str;
        }

        public final void m(String str) {
            this.x = str;
        }

        public final String y() {
            return this.z;
        }

        public final void n(String str) {
            this.z = str;
        }

        public final String z() {
            return this.A;
        }

        public final void o(String str) {
            this.A = str;
        }

        public final String A() {
            return this.B;
        }

        public final void p(String str) {
            this.B = str;
        }

        public final String B() {
            return this.C;
        }

        public final void q(String str) {
            this.C = str;
        }

        public final String C() {
            return this.D;
        }

        public final void r(String str) {
            this.D = str;
        }

        public final String getPhone() {
            return this.E;
        }

        public final void setPhone(String str) {
            this.E = str;
        }
    }
}
