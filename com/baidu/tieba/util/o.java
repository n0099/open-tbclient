package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class o {
    private static Object m = new Object();
    private static o n;
    private com.baidu.tieba.data.c g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final int a = 2;
    private final int b = 10;
    private final int c = 0;
    private final int d = 1;
    private final int e = 2;
    private final int f = 3;
    private q l = new q(this, null);

    public static o a() {
        if (n == null) {
            synchronized (o.class) {
                if (n == null) {
                    n = new o();
                }
            }
        }
        return n;
    }

    private o() {
    }

    public com.baidu.tieba.data.c b() {
        return this.g;
    }

    public void a(com.baidu.tieba.data.c cVar) {
        synchronized (m) {
            this.g = cVar;
        }
    }

    public void a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String qVar;
        int i6 = 0;
        if (b() != null && b().a()) {
            synchronized (m) {
                this.j++;
                this.i++;
                this.l.a(i);
                i2 = this.j;
                i3 = this.i;
                i4 = this.h;
                i5 = this.h != 0 ? this.k / this.h : 0;
                qVar = this.l.toString();
                if (this.j >= b().b() && this.j >= 10) {
                    if (this.i >= b().e() && this.h >= b().c()) {
                        i6 = 1;
                    } else if (this.i >= b().e()) {
                        i6 = 2;
                    } else if (this.h >= b().c()) {
                        i6 = 3;
                    }
                    c();
                }
            }
            a(i6, i2, i3, qVar, i4, i5);
        }
    }

    public void a(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        String qVar;
        int i5 = 0;
        if (b() != null && b().a()) {
            synchronized (m) {
                this.j++;
                if (j >= b().d()) {
                    this.h++;
                    this.k = (int) (this.k + j);
                }
                i = this.j;
                i2 = this.i;
                i3 = this.h;
                i4 = this.h != 0 ? this.k / this.h : 0;
                qVar = this.l.toString();
                if (this.j >= b().b() && this.j >= 10) {
                    if (this.i >= b().e() && this.h >= b().c()) {
                        i5 = 1;
                    } else if (this.i >= b().e()) {
                        i5 = 2;
                    } else if (this.h >= b().c()) {
                        i5 = 3;
                    }
                    c();
                }
            }
            a(i5, i, i2, qVar, i3, i4);
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, int i5) {
        if (b() != null && b().a() && i != 0) {
            a(i, i2, i3, str, i4, new StringBuilder(String.valueOf(i5)).toString());
        }
    }

    private void a(int i, int i2, int i3, String str, int i4, String str2) {
        p pVar = new p(this, i, i2, i3, str, i4, str2);
        pVar.setParallelTag(2);
        pVar.execute(new Object[0]);
    }

    private void c() {
        this.j = 0;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l.a();
    }
}
