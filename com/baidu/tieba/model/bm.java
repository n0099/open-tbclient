package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.a.c {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private String i;
    private com.baidu.tieba.util.a m;
    private Context p;
    private bo n = null;
    private bn o = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1387a = true;
    private String b = null;
    private UserData l = null;
    private boolean j = false;
    private boolean k = false;

    public bm(Context context) {
        this.p = null;
        this.p = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
        this.m = new com.baidu.tieba.util.a(context);
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.f1387a = z;
    }

    public boolean b() {
        return this.f1387a;
    }

    public void a(UserData userData) {
        this.l = userData;
    }

    public UserData c() {
        return this.l;
    }

    public boolean d() {
        return this.h;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void a(PersonChangeData personChangeData) {
        c().setSex(personChangeData.getSex());
        c().setName(personChangeData.getName());
        c().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2) {
        if (this.n == null) {
            this.n = new bo(this, null);
            this.n.setPriority(3);
            this.n.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void e() {
        if (c() != null && this.o == null) {
            this.o = new bn(this, null);
            this.o.setPriority(2);
            if (c().getHave_attention() == 1) {
                this.o.execute(1);
            } else {
                this.o.execute(0);
            }
        }
    }

    public com.baidu.tieba.util.a f() {
        return this.m;
    }

    public void b(String str) {
        this.i = str;
    }

    public String g() {
        return this.i;
    }

    public void a(long j) {
        this.c = j;
    }

    public long h() {
        return this.c;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.g = j;
    }

    public long i() {
        return this.g;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean j() {
        return this.j;
    }

    public void d(boolean z) {
        this.k = z;
    }

    public boolean k() {
        return this.k;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void l() {
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.m != null) {
            this.m.b();
        }
    }
}
