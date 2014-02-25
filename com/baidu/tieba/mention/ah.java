package com.baidu.tieba.mention;

import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class ah {
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
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private boolean i = true;
    private HashMap<String, String> n = new HashMap<>();
    private HashMap<String, String> o = new HashMap<>();

    public void a() {
        HashMap<String, String> m = m();
        Set<String> keySet = m.keySet();
        if (keySet.size() != 1) {
            b((String) null);
        } else {
            b(m.get(keySet.iterator().next()));
        }
    }

    public void b() {
        HashMap<String, String> r = r();
        Set<String> keySet = r.keySet();
        if (keySet.size() != 1) {
            j(null);
        } else {
            j(r.get(keySet.iterator().next()));
        }
    }

    public int c() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int d() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int e() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int f() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public int g() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }

    public boolean h() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public String i() {
        return this.j;
    }

    public void a(String str) {
        this.j = str;
    }

    public String j() {
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

    public String k() {
        return this.t;
    }

    public void e(String str) {
        this.t = str;
    }

    public String l() {
        return this.u;
    }

    public void f(String str) {
        this.u = str;
    }

    public HashMap<String, String> m() {
        return this.n;
    }

    public int n() {
        return this.e;
    }

    public void f(int i) {
        this.e = i;
    }

    public int o() {
        return this.g;
    }

    public void g(int i) {
        this.g = i;
    }

    public void g(String str) {
        this.k = str;
    }

    public void h(String str) {
        this.l = str;
    }

    public int p() {
        return this.h;
    }

    public void h(int i) {
        this.h = i;
    }

    public String q() {
        return this.m;
    }

    public void i(String str) {
        this.m = str;
    }

    public HashMap<String, String> r() {
        return this.o;
    }

    public String s() {
        return this.s;
    }

    public void j(String str) {
        this.s = str;
    }
}
