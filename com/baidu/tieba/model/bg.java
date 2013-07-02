package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class bg {
    private int q;
    private int r;
    private com.baidu.tieba.data.aj a = null;
    private boolean d = true;
    private boolean c = true;
    private boolean e = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private String b = null;
    private boolean f = false;
    private String k = null;
    private String l = null;
    private String m = null;
    private int n = 1;
    private int o = 1;
    private boolean p = false;

    public void a(com.baidu.tieba.data.aj ajVar) {
        this.a = ajVar;
    }

    public com.baidu.tieba.data.aj a() {
        return this.a;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.d;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public void d(boolean z) {
        this.g = z;
    }

    public void a(int i) {
        this.n = i;
    }

    public int c() {
        return this.n;
    }

    public void b(int i) {
        this.o = i;
    }

    public int d() {
        return this.o;
    }

    public void e(boolean z) {
        this.p = z;
    }

    public boolean e() {
        return this.p;
    }

    public void c(int i) {
        this.q = i;
    }

    public void d(int i) {
        this.r = i;
    }

    public int f() {
        return com.baidu.tieba.data.g.b() / 30;
    }
}
