package com.baidu.tieba.mention;

import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class ad {
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
        this.n.clear();
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
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

    public int d() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int f() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int g() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public int h() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
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

    public int o() {
        return this.e;
    }

    public void f(int i) {
        this.e = i;
    }

    public int p() {
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

    public int q() {
        return this.h;
    }

    public void h(int i) {
        this.h = i;
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
