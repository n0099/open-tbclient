package com.baidu.tieba.mention;

import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class ae {
    private String j;
    private String k;
    private String l;
    private String m;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private boolean i = true;
    private HashMap<String, String> n = new HashMap<>();
    private HashMap<String, String> o = new HashMap<>();

    public void a() {
        this.n.clear();
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = null;
        this.u = null;
    }

    public void b() {
        HashMap<String, String> n = n();
        Set<String> keySet = n.keySet();
        if (keySet.size() != 1) {
            b((String) null);
        } else {
            b(n.get(keySet.iterator().next()));
        }
    }

    public void c() {
        HashMap<String, String> s = s();
        Set<String> keySet = s.keySet();
        if (keySet.size() != 1) {
            j(null);
        } else {
            j(s.get(keySet.iterator().next()));
        }
    }

    public long d() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public long e() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public long f() {
        return this.d;
    }

    public void c(long j) {
        this.d = j;
    }

    public long g() {
        return this.f;
    }

    public void d(long j) {
        this.f = j;
    }

    public long h() {
        return this.b;
    }

    public void e(long j) {
        this.b = j;
    }

    public boolean i() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public String j() {
        return this.j;
    }

    public void a(String str) {
        this.j = str;
    }

    public String k() {
        return this.p;
    }

    public void b(String str) {
        this.p = str;
    }

    public void c(String str) {
        this.q = str;
    }

    public void d(String str) {
        this.r = str;
    }

    public String l() {
        return this.t;
    }

    public void e(String str) {
        this.t = str;
    }

    public String m() {
        return this.u;
    }

    public void f(String str) {
        this.u = str;
    }

    public HashMap<String, String> n() {
        return this.n;
    }

    public long o() {
        return this.e;
    }

    public void f(long j) {
        this.e = j;
    }

    public long p() {
        return this.g;
    }

    public void g(long j) {
        this.g = j;
    }

    public void g(String str) {
        this.k = str;
    }

    public void h(String str) {
        this.l = str;
    }

    public long q() {
        return this.h;
    }

    public void h(long j) {
        this.h = j;
    }

    public String r() {
        return this.m;
    }

    public void i(String str) {
        this.m = str;
    }

    public HashMap<String, String> s() {
        return this.o;
    }

    public String t() {
        return this.s;
    }

    public void j(String str) {
        this.s = str;
    }
}
