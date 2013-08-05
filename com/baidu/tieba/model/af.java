package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private long f1325a;
    private long b;
    private long c;
    private long d;

    public af(Context context) {
        a(0L);
        b(0L);
        c(0L);
    }

    public void a(long j) {
        this.f1325a = j;
    }

    public void b(long j) {
        this.b = j;
    }

    public long a() {
        return this.b + this.c;
    }

    public void c(long j) {
        this.c = j;
    }

    public long b() {
        return this.d;
    }

    public void d(long j) {
        this.d = j;
    }
}
